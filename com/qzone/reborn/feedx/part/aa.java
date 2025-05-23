package com.qzone.reborn.feedx.part;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.qzone.common.account.LoginData;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.common.event.Event;
import com.qzone.common.event.EventCenter;
import com.qzone.common.event.IObserver;
import com.qzone.personalize.floatobject.business.model.FloatCacheData;
import com.qzone.personalize.floatobject.ui.FloatItemView;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aa extends g implements IObserver.main {

    /* renamed from: d, reason: collision with root package name */
    private Runnable f54979d;

    /* renamed from: e, reason: collision with root package name */
    FloatItemView f54980e;

    /* renamed from: f, reason: collision with root package name */
    private long f54981f;

    public aa() {
        this(LoginData.getInstance().getUin());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void G9() {
        ArrayList<NS_MOBILE_CUSTOM.FloatItemView> arrayList;
        if (QZoneHelper.isInFloatItemBlacklist()) {
            QZLog.w("QZoneFeedxFloatItemPart", "isInFloatItemBlacklist is true,friend feed not show floatitem.");
            return;
        }
        FloatCacheData k3 = com.qzone.personalize.business.b.n().k(this.f54981f);
        if (k3 == null || (arrayList = k3.vecView) == null || arrayList.size() == 0) {
            return;
        }
        if (this.f54980e == null) {
            this.f54980e = new FloatItemView(BaseApplication.getContext());
            getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.feedx.part.z
                @Override // java.lang.Runnable
                public final void run() {
                    aa.this.J9();
                }
            });
        }
        FloatItemView floatItemView = this.f54980e;
        if (floatItemView != null) {
            floatItemView.initObjects(k3, false);
        }
    }

    private void H9(QZoneResult qZoneResult) {
        FloatCacheData floatCacheData;
        if (!qZoneResult.getSucceed() || (floatCacheData = (FloatCacheData) qZoneResult.getBundle().getParcelable(FloatCacheData.PARAM_CACHE_DATA)) == null) {
            return;
        }
        FloatItemView floatItemView = this.f54980e;
        if (floatItemView == null || !floatCacheData.strId.equals(floatItemView.f49281f)) {
            K9();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J9() {
        FloatItemView floatItemView;
        new RelativeLayout.LayoutParams(-1, -1).topMargin = getActivity().getResources().getDimensionPixelSize(R.dimen.azw);
        if ((getPartRootView() instanceof ViewGroup) && (floatItemView = this.f54980e) != null && floatItemView.getParent() == null) {
            ((ViewGroup) getPartRootView()).addView(this.f54980e);
        }
    }

    public void F9() {
        try {
            QZLog.d("QZoneFeedxFloatItemPart", 2, "cleanFloat");
            if (this.f54979d != null) {
                QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).removeTask(this.f54979d);
            }
            FloatItemView floatItemView = this.f54980e;
            if (floatItemView != null) {
                floatItemView.destroy();
                if (getPartRootView() instanceof ViewGroup) {
                    ((ViewGroup) getPartRootView()).removeView(this.f54980e);
                }
                this.f54980e = null;
            }
        } catch (Exception e16) {
            QZLog.e("QZoneFeedxFloatItemPart", "cleanFloat error.", e16);
        }
    }

    void K9() {
        if (this.f54979d == null) {
            this.f54979d = new Runnable() { // from class: com.qzone.reborn.feedx.part.y
                @Override // java.lang.Runnable
                public final void run() {
                    aa.this.G9();
                }
            };
        }
        QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).postDelayed(this.f54979d, 500L);
    }

    @Override // com.tencent.biz.richframework.part.Part
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneFeedxFloatItemPart";
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void i6() {
        super.i6();
        K9();
    }

    @Override // com.qzone.common.event.IObserver.main
    public void onEventUIThread(Event event) {
        if ("Personalize".equals(event.source.getName()) && event.what == 11) {
            I9(event);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(Activity activity, Bundle bundle) {
        super.onPartCreate(activity, bundle);
        EventCenter.getInstance().addUIObserver(this, "Personalize", 11);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(Activity activity) {
        super.onPartDestroy(activity);
        EventCenter.getInstance().removeObserver(this);
        if (this.f54979d != null) {
            QzoneHandlerThreadFactory.getHandlerThread(QzoneHandlerThreadFactory.NormalThread).removeTask(this.f54979d);
        }
        FloatItemView floatItemView = this.f54980e;
        if (floatItemView != null) {
            floatItemView.onDestroy();
            if (getPartRootView() instanceof ViewGroup) {
                ((ViewGroup) getPartRootView()).removeView(this.f54980e);
            }
            this.f54980e = null;
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartPause(Activity activity) {
        super.onPartPause(activity);
        FloatItemView floatItemView = this.f54980e;
        if (floatItemView != null) {
            floatItemView.stop();
        }
        if (Build.VERSION.SDK_INT >= 26) {
            F9();
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(Activity activity) {
        super.onPartResume(activity);
        K9();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(Activity activity) {
        super.onPartStop(activity);
        FloatItemView floatItemView = this.f54980e;
        if (floatItemView != null) {
            floatItemView.stop();
        }
    }

    @Override // com.qzone.reborn.feedx.part.g, com.qzone.reborn.feedx.viewmodel.b
    public void v0(QZoneResult qZoneResult) {
        super.v0(qZoneResult);
        H9(qZoneResult);
    }

    public aa(long j3) {
        this.f54979d = null;
        this.f54981f = j3;
        if (j3 <= 0) {
            this.f54981f = LoginData.getInstance().getUin();
        }
    }

    private void I9(Event event) {
        if (event != null) {
            Object obj = event.params;
            if (obj instanceof FloatCacheData) {
                FloatCacheData floatCacheData = (FloatCacheData) obj;
                FloatItemView floatItemView = this.f54980e;
                if (floatItemView == null || !floatCacheData.strId.equals(floatItemView.f49281f)) {
                    K9();
                }
            }
        }
    }
}
