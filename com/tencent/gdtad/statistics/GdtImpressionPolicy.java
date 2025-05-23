package com.tencent.gdtad.statistics;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.views.GdtUIUtils;
import com.tencent.mobileqq.R;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

@Deprecated
/* loaded from: classes6.dex */
public final class GdtImpressionPolicy implements Handler.Callback {
    public static final long AD_REPORT_IMPRESSION_CHECK_INTERNAL = 1000;
    public static final double AD_REPORT_SATISFIED_VISIBLE_AREA = 0.5d;
    public static final String GDT_IMPRESSION_POLICY_REPORTED = "GdtImpressionPolicyReported";
    private static final String TAG = "GdtImpressionPolicy";

    @NonNull
    private static GdtImpressionPolicy sInstance = new GdtImpressionPolicy();

    @Nullable
    private Handler mHandler;

    @NonNull
    private ConcurrentHashMap<String, WeakReference<View>> viewsInReportCountDown = new ConcurrentHashMap<>();

    /* loaded from: classes6.dex */
    public interface ReportListener {
        void reportImpression(View view);
    }

    GdtImpressionPolicy() {
        this.mHandler = null;
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread(TAG);
        baseHandlerThread.start();
        this.mHandler = new Handler(baseHandlerThread.getLooper(), this);
    }

    private void addIntoCountingMap(@NonNull String str, @NonNull WeakReference<View> weakReference) {
        this.viewsInReportCountDown.put(str, weakReference);
    }

    private boolean getExternalReportState(String str) {
        MobileQQ mobileQQ = MobileQQ.sMobileQQ;
        if (mobileQQ == null) {
            return false;
        }
        return mobileQQ.getSharedPreferences(GDT_IMPRESSION_POLICY_REPORTED, 0).getBoolean(str, false);
    }

    @NonNull
    public static synchronized GdtImpressionPolicy getInstance() {
        GdtImpressionPolicy gdtImpressionPolicy;
        synchronized (GdtImpressionPolicy.class) {
            gdtImpressionPolicy = sInstance;
        }
        return gdtImpressionPolicy;
    }

    private boolean inCountingMap(@Nullable View view) {
        Collection<WeakReference<View>> values = this.viewsInReportCountDown.values();
        if (values != null) {
            for (WeakReference<View> weakReference : values) {
                if (view != null && weakReference != null && weakReference.get() != null && view == weakReference.get()) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    @Nullable
    private GdtAd isViewParamsOk(@Nullable View view) {
        Object tag;
        if (view == null || (tag = view.getTag(R.id.kx_)) == null || !(tag instanceof GdtAd)) {
            return null;
        }
        GdtAd gdtAd = (GdtAd) tag;
        if (TextUtils.isEmpty(gdtAd.getTraceId()) || TextUtils.isEmpty(gdtAd.getUrlForImpression())) {
            return null;
        }
        return gdtAd;
    }

    public static boolean isVisibleAreaSatisfied(View view) {
        if (GdtUIUtils.getPercentageOfGlobalVisibleRect(view) > 0.5d) {
            return true;
        }
        return false;
    }

    private void putExternalReportState(String str, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SharedPreferences sharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences(GDT_IMPRESSION_POLICY_REPORTED, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        trimToSize(sharedPreferences, edit, 8192);
        edit.putBoolean(str, z16);
        edit.apply();
    }

    private void removeFromCountingMap(@NonNull String str) {
        this.viewsInReportCountDown.remove(str);
    }

    private void tickOutTheDataChangedView(View view, @NonNull GdtAd gdtAd) {
        Set<String> keySet = this.viewsInReportCountDown.keySet();
        if (keySet != null) {
            for (String str : keySet) {
                WeakReference<View> weakReference = this.viewsInReportCountDown.get(str);
                if (weakReference != null && weakReference.get() != null && view == weakReference.get()) {
                    if (gdtAd.getTraceId() != null && !gdtAd.getTraceId().equals(str)) {
                        removeFromCountingMap(str);
                        return;
                    }
                    return;
                }
            }
        }
    }

    private void trimToSize(@NonNull SharedPreferences sharedPreferences, @NonNull SharedPreferences.Editor editor, int i3) {
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null) {
            Set<String> keySet = all.keySet();
            if (keySet.size() - i3 > 0) {
                int abs = Math.abs((int) (keySet.size() - (i3 * 0.5f)));
                String[] strArr = new String[abs];
                Iterator<String> it = keySet.iterator();
                int i16 = 0;
                while (it.hasNext()) {
                    int i17 = i16 + 1;
                    strArr[i16] = it.next();
                    if (i17 >= abs) {
                        break;
                    } else {
                        i16 = i17;
                    }
                }
                for (int i18 = 0; i18 < abs; i18++) {
                    String str = strArr[i18];
                    if (!TextUtils.isEmpty(str)) {
                        editor.remove(str);
                    }
                }
            }
        }
    }

    public void clearCountingMap() {
        this.viewsInReportCountDown.clear();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(@Nullable Message message) {
        GdtLog.d(TAG, "handleMessage : ");
        if (message != null) {
            Object obj = message.obj;
            if (obj instanceof WeakReference) {
                WeakReference weakReference = (WeakReference) obj;
                if (weakReference.get() != null) {
                    View view = (View) weakReference.get();
                    GdtAd isViewParamsOk = isViewParamsOk(view);
                    if (isViewParamsOk == null) {
                        GdtLog.d(TAG, "break: statistics == null");
                        return false;
                    }
                    if (isViewParamsOk.reportState != 1) {
                        GdtLog.d(TAG, "break: statistics.reportState != 1 " + isViewParamsOk.getTraceId());
                        return false;
                    }
                    if (!isVisibleAreaSatisfied(view)) {
                        GdtLog.d(TAG, "break: isVisibleAreaSatisfied not " + isViewParamsOk.getTraceId());
                        isViewParamsOk.reportState = -1;
                        return false;
                    }
                    if (!inCountingMap(view)) {
                        GdtLog.d(TAG, "break: inCountingMap not " + isViewParamsOk.getTraceId());
                        return false;
                    }
                    Object tag = view.getTag(R.id.kx9);
                    if (tag == null) {
                        GdtLog.d(TAG, "break: o2 == null " + isViewParamsOk.getTraceId());
                        return false;
                    }
                    if (!(tag instanceof ReportListener)) {
                        GdtLog.d(TAG, "break: o2 instanceof ReportListener not " + isViewParamsOk.getTraceId());
                        return false;
                    }
                    if (getExternalReportState(isViewParamsOk.getTraceId())) {
                        GdtLog.d(TAG, "break: already reported " + isViewParamsOk.getTraceId());
                        return false;
                    }
                    ((ReportListener) tag).reportImpression(view);
                    isViewParamsOk.reportState = 2;
                    putExternalReportState(isViewParamsOk.getTraceId(), true);
                    GdtLog.d(TAG, "report " + isViewParamsOk.getTraceId());
                    removeFromCountingMap(isViewParamsOk.getTraceId());
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void report(@NonNull View view) {
        if (view != null) {
            GdtLog.d(TAG, "report view: " + view.hashCode());
            GdtAd isViewParamsOk = isViewParamsOk(view);
            if (isViewParamsOk == null) {
                GdtLog.d(TAG, "break: statistics == null");
                return;
            }
            if (isViewParamsOk.reportState == 2) {
                GdtLog.d(TAG, "break: already report " + isViewParamsOk.getTraceId());
                return;
            }
            if (!isVisibleAreaSatisfied(view)) {
                GdtLog.d(TAG, "break: isVisibleAreaSatisfied not");
                return;
            }
            tickOutTheDataChangedView(view, isViewParamsOk);
            Message obtainMessage = this.mHandler.obtainMessage();
            WeakReference<View> weakReference = new WeakReference<>(view);
            obtainMessage.obj = weakReference;
            if (!inCountingMap(view)) {
                GdtLog.d(TAG, "inCountingMap not " + isViewParamsOk.getTraceId());
                addIntoCountingMap(isViewParamsOk.getTraceId(), weakReference);
            }
            isViewParamsOk.reportState = 1;
            this.mHandler.sendMessageDelayed(obtainMessage, 1000L);
        }
    }
}
