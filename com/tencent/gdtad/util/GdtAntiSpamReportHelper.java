package com.tencent.gdtad.util;

import android.annotation.SuppressLint;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GdtAntiSpamReportHelper implements View.OnTouchListener {
    private static final String ASP_KEY_DOWN_X = "aa";
    private static final String ASP_KEY_DOWN_Y = "ab";
    private static final String ASP_KEY_INTERVAL_DOWN_TO_UP = "g";
    private static final String ASP_KEY_REAL_HEIGHT = "db";
    private static final String ASP_KEY_REAL_WIDTH = "da";
    private static final String ASP_KEY_REAL_X = "px";
    private static final String ASP_KEY_REAL_Y = "py";
    private static final String ASP_KEY_UP_X = "ba";
    private static final String ASP_KEY_UP_Y = "bb";
    private static final String ASP_KEY_VIDEO_PLAY_DURATION = "p";
    private static final String TAG = "GdtAntiSpamReportHelper";
    private long mDownTime;
    private int mDownX;
    private int mDownY;
    private long mUpTime;
    private int mUpX;
    private int mUpY;
    private final List<WeakReference<View>> targets = Collections.synchronizedList(new ArrayList());
    private long mExpoTime = 0;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class AdReportParams {
        public int height;
        public int width;

        /* renamed from: x, reason: collision with root package name */
        public int f109509x;

        /* renamed from: y, reason: collision with root package name */
        public int f109510y;

        public AdReportParams(int i3, int i16, int i17, int i18) {
            this.width = i3;
            this.height = i16;
            this.f109509x = i17;
            this.f109510y = i18;
        }
    }

    private static AdReportParams buildReportParams(View view) {
        if (view == null) {
            QLog.e(TAG, 1, "buildReportParams error: view is null");
            return null;
        }
        try {
            int[] iArr = new int[2];
            view.getLocationOnScreen(iArr);
            return new AdReportParams(view.getWidth(), view.getHeight(), iArr[0], iArr[1]);
        } catch (Exception e16) {
            QLog.e(TAG, 1, "buildReportParams", e16);
            return null;
        }
    }

    public static String getAdAntiSpamExpoFromClickParams(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("db");
            String string = jSONObject.getString(ASP_KEY_REAL_WIDTH);
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("db", optString);
            jSONObject2.put(ASP_KEY_REAL_WIDTH, string);
            QLog.d(TAG, 2, "expo from click antiSpamParams:", jSONObject2.toString());
            return URLEncoder.encode(jSONObject2.toString(), "utf-8");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAdAntiSpamExpoFromClickParams error", e16);
            return "";
        }
    }

    public static String getAdAntiSpamForExpoParams(View view) {
        if (buildReportParams(view) == null) {
            QLog.d(TAG, 1, "gerAdAntiSpamForExpoParams params == null");
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("db", pxToDipString(r7.height));
            jSONObject.put(ASP_KEY_REAL_WIDTH, pxToDipString(r7.width));
            QLog.d(TAG, 2, "expo antiSpamParams:", jSONObject.toString());
            return URLEncoder.encode(jSONObject.toString(), "utf-8");
        } catch (Exception e16) {
            QLog.e(TAG, 1, "gerAdAntiSpamForExpoParams jsonObject error", e16);
            return "";
        }
    }

    private static String pxToDipString(float f16) {
        return String.valueOf(ViewUtils.pxToDp(f16));
    }

    public String getAdAntiSpamForClickParams(View view) {
        if (buildReportParams(view) == null) {
            QLog.d(TAG, 1, "getAdAntiSpamForClickParams params == null");
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = this.mUpTime - this.mDownTime;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ASP_KEY_DOWN_X, pxToDipString(this.mDownX - r11.f109509x));
            jSONObject.put(ASP_KEY_DOWN_Y, pxToDipString(this.mDownY - r11.f109510y));
            jSONObject.put(ASP_KEY_UP_X, pxToDipString(this.mUpX - r11.f109509x));
            jSONObject.put(ASP_KEY_UP_Y, pxToDipString(this.mUpY - r11.f109510y));
            jSONObject.put("db", pxToDipString(r11.height));
            jSONObject.put(ASP_KEY_REAL_WIDTH, pxToDipString(r11.width));
            jSONObject.put(ASP_KEY_REAL_X, pxToDipString(r11.f109509x));
            jSONObject.put(ASP_KEY_REAL_Y, pxToDipString(r11.f109510y));
            jSONObject.put("g", String.valueOf(j3));
            long j16 = this.mExpoTime;
            if (j16 > 0) {
                jSONObject.put("p", String.valueOf(currentTimeMillis - j16));
            }
        } catch (Exception e16) {
            QLog.e(TAG, 1, "getAdAntiSpamForClickParams jsonObject error", e16);
        }
        QLog.d(TAG, 2, "click antiSpamParams:", jSONObject.toString());
        return jSONObject.toString();
    }

    public void listenOnTouchEvent(View view) {
        if (view == null) {
            QLog.e(TAG, 1, "listenOnTouchEvent null");
        } else {
            this.targets.add(new WeakReference<>(view));
            view.setOnTouchListener(this);
        }
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
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.mUpTime = System.currentTimeMillis();
                this.mUpX = (int) motionEvent.getRawX();
                this.mUpY = (int) motionEvent.getRawY();
                return false;
            }
            return false;
        }
        this.mDownTime = System.currentTimeMillis();
        this.mDownX = (int) motionEvent.getRawX();
        this.mDownY = (int) motionEvent.getRawY();
        return false;
    }

    public void resetExpoTime() {
        this.mExpoTime = 0L;
    }

    public void setDownData(int i3, int i16) {
        this.mDownTime = System.currentTimeMillis();
        this.mDownX = i3;
        this.mDownY = i16;
    }

    public void setExpoTime() {
        this.mExpoTime = System.currentTimeMillis();
    }

    public void setUpData(int i3, int i16) {
        this.mUpTime = System.currentTimeMillis();
        this.mUpX = i3;
        this.mUpY = i16;
    }
}
