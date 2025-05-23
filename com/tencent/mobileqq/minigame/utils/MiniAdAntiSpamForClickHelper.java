package com.tencent.mobileqq.minigame.utils;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MiniAdAntiSpamForClickHelper implements View.OnTouchListener {
    private static final String ASP_KEY_DOWN_X = "aa";
    private static final String ASP_KEY_DOWN_Y = "ab";
    private static final String ASP_KEY_INTERVAL_DOWN_TO_UP = "g";
    private static final String ASP_KEY_IS_DRAG = "d";
    private static final String ASP_KEY_REAL_HEIGHT = "db";
    private static final String ASP_KEY_REAL_WIDTH = "da";
    private static final String ASP_KEY_REAL_X = "px";
    private static final String ASP_KEY_REAL_Y = "py";
    private static final String ASP_KEY_UP_X = "ba";
    private static final String ASP_KEY_UP_Y = "bb";
    private static final String TAG = "MiniAdAntiSpamForClickHelper";
    private static final String URL_PARAMS_KEY_ANTI_SPAM = "s";
    private long mDownTime;
    private int mDownX;
    private int mDownY;
    private long mUpTime;
    private int mUpX;
    private int mUpY;
    private final List<WeakReference<View>> targets = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class AdReportParams {
        public int height;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f247026x;

        /* renamed from: y, reason: collision with root package name */
        public int f247027y;

        public AdReportParams(int i3, int i16, int i17, int i18) {
            this.width = i3;
            this.height = i16;
            this.f247026x = i17;
            this.f247027y = i18;
        }
    }

    private String pxToDipString(float f16) {
        return String.valueOf(x.h(BaseApplication.getContext(), f16));
    }

    public void onDestroy() {
        Iterator<WeakReference<View>> it = this.targets.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null) {
                view.setOnTouchListener(null);
            }
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownTime = System.currentTimeMillis();
            this.mDownX = (int) motionEvent.getRawX();
            this.mDownY = (int) motionEvent.getRawY();
            return false;
        }
        if (action != 1) {
            return false;
        }
        this.mUpTime = System.currentTimeMillis();
        this.mUpX = (int) motionEvent.getRawX();
        this.mUpY = (int) motionEvent.getRawY();
        return false;
    }

    public String getMiniAdAntiSpamForClickParams(AdReportParams adReportParams) {
        if (adReportParams == null) {
            QLog.d(TAG, 1, "getMiniAdAntiSpamForClickParams params == null");
            return "";
        }
        long j3 = this.mUpTime - this.mDownTime;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ASP_KEY_DOWN_X, pxToDipString(this.mDownX - adReportParams.f247026x));
            jSONObject.put(ASP_KEY_DOWN_Y, pxToDipString(this.mDownY - adReportParams.f247027y));
            jSONObject.put(ASP_KEY_UP_X, pxToDipString(this.mUpX - adReportParams.f247026x));
            jSONObject.put(ASP_KEY_UP_Y, pxToDipString(this.mUpY - adReportParams.f247027y));
            jSONObject.put("d", "0");
            jSONObject.put("db", pxToDipString(adReportParams.height));
            jSONObject.put(ASP_KEY_REAL_WIDTH, pxToDipString(adReportParams.width));
            jSONObject.put(ASP_KEY_REAL_X, pxToDipString(adReportParams.f247026x));
            jSONObject.put(ASP_KEY_REAL_Y, pxToDipString(adReportParams.f247027y));
            jSONObject.put("g", String.valueOf(j3));
        } catch (Exception e16) {
            QLog.e(TAG, 1, "get AntiSpamForClickParams jsonObject error", e16);
        }
        return jSONObject.toString();
    }

    public AdReportParams buildReportParams(View view) {
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new AdReportParams(view.getWidth(), view.getHeight(), iArr[0], iArr[1]);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "buildReportParams", e16);
            return null;
        }
    }

    public void listenOnTouchEvent(View view) {
        if (view == null) {
            QLog.e(TAG, 1, "listenOnTouchEvent null");
        } else {
            this.targets.add(new WeakReference<>(view));
            view.setOnTouchListener(this);
        }
    }

    public void removeListenOnTouchEvent(View view) {
        if (view == null) {
            QLog.e(TAG, 1, "removeListenOnTouchEvent null");
            return;
        }
        for (WeakReference<View> weakReference : this.targets) {
            if (weakReference.get() == view) {
                this.targets.remove(weakReference);
                view.setOnTouchListener(null);
                return;
            }
        }
    }
}
