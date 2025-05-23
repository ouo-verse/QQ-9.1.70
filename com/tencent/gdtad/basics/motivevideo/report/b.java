package com.tencent.gdtad.basics.motivevideo.report;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.api.vinfo.TVKNetVideoInfo;
import com.tencent.util.URLUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public class b implements View.OnTouchListener {
    private InterfaceC1159b C;
    private List<WeakReference<View>> D = new ArrayList();
    private boolean E = false;
    private boolean F = false;

    /* renamed from: d, reason: collision with root package name */
    private long f109100d;

    /* renamed from: e, reason: collision with root package name */
    private int f109101e;

    /* renamed from: f, reason: collision with root package name */
    private int f109102f;

    /* renamed from: h, reason: collision with root package name */
    private long f109103h;

    /* renamed from: i, reason: collision with root package name */
    private int f109104i;

    /* renamed from: m, reason: collision with root package name */
    private int f109105m;

    /* compiled from: P */
    /* loaded from: classes6.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f109106a;

        /* renamed from: b, reason: collision with root package name */
        public int f109107b;

        /* renamed from: c, reason: collision with root package name */
        public int f109108c;

        /* renamed from: d, reason: collision with root package name */
        public int f109109d;

        public a(int i3, int i16, int i17, int i18) {
            this.f109106a = i3;
            this.f109107b = i16;
            this.f109108c = i17;
            this.f109109d = i18;
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.gdtad.basics.motivevideo.report.b$b, reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1159b {
        void a(long j3, long j16, int i3, int i16, int i17, int i18);
    }

    private String c(int i3, String str, int i16, int i17, int i18, int i19) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("da", String.valueOf(i16));
            jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, String.valueOf(i17));
            jSONObject.put("px", String.valueOf(i18));
            jSONObject.put("py", String.valueOf(i19));
            jSONObject.put(HippyTKDListViewAdapter.X, String.valueOf(1));
        } catch (Exception e16) {
            QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToExposureUrl error", e16);
        }
        return d(i3, str, jSONObject.toString());
    }

    public String a(String str, a aVar) {
        if (aVar == null) {
            QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAdBoxAntiSpamToClickUrl params == null");
            return str;
        }
        long j3 = this.f109103h - this.f109100d;
        long currentTimeMillis = System.currentTimeMillis() - this.f109103h;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f109100d;
        BaseApplication context = BaseApplication.getContext();
        JSONObject jSONObject = new JSONObject();
        try {
            int h16 = x.h(context, ScreenUtil.getInstantScreenWidth(context));
            int h17 = x.h(context, ScreenUtil.getInstantScreenHeight(context));
            jSONObject.put("g", String.valueOf(j3));
            jSONObject.put("sc", String.valueOf(currentTimeMillis));
            jSONObject.put("ec", String.valueOf(currentTimeMillis2));
            jSONObject.put("aa", String.valueOf(this.f109101e - aVar.f109108c));
            jSONObject.put("ab", String.valueOf(this.f109102f - aVar.f109109d));
            jSONObject.put("ba", String.valueOf(this.f109104i - aVar.f109108c));
            jSONObject.put("bb", String.valueOf(this.f109105m - aVar.f109109d));
            jSONObject.put("d", "0");
            jSONObject.put("p", "0");
            jSONObject.put("f", "0");
            jSONObject.put(HippyTKDListViewAdapter.X, "1");
            jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, h17);
            jSONObject.put("da", h16);
            jSONObject.put("px", String.valueOf(aVar.f109108c));
            jSONObject.put("py", String.valueOf(aVar.f109109d));
        } catch (Exception e16) {
            GdtLog.e("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", e16);
        }
        return d(1, str, jSONObject.toString());
    }

    public String b(String str, a aVar) {
        if (aVar == null) {
            QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAdBoxAntiSpamToExposureUr params == null");
            return str;
        }
        return c(2, str, aVar.f109106a, aVar.f109107b, aVar.f109108c, aVar.f109109d);
    }

    public String d(int i3, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl TextUtils.isEmpty(url)");
            return str;
        }
        Map<String, String> argumentsFromURL = URLUtil.getArgumentsFromURL(str);
        if (argumentsFromURL != null && argumentsFromURL.containsKey(ReportConstant.COSTREPORT_PREFIX)) {
            QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl hasKey  type = " + i3 + ", url=" + str);
            return str;
        }
        String addParameter = URLUtil.addParameter(str, ReportConstant.COSTREPORT_PREFIX, str2);
        QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 1, "addAntiSpamToUrl type = " + i3 + ",result url=" + addParameter);
        if (QLog.isColorLevel()) {
            QLog.i("GdtMotiveVideoClickCoordinateReportHelper", 2, "report param: " + str2);
        }
        return addParameter;
    }

    public String e(String str) {
        BaseApplication context = BaseApplication.getContext();
        return c(4, str, x.h(context, ScreenUtil.getInstantScreenWidth(context)), x.h(context, ScreenUtil.getInstantScreenHeight(context)), 0, 0);
    }

    public String f(String str, long j3, boolean z16, boolean z17, String str2) {
        String str3;
        int instantScreenWidth;
        int instantScreenHeight;
        String str4;
        int i3;
        long abs = Math.abs(this.f109103h - this.f109100d);
        long currentTimeMillis = System.currentTimeMillis() - this.f109103h;
        long currentTimeMillis2 = System.currentTimeMillis() - this.f109100d;
        BaseApplication context = BaseApplication.getContext();
        if (TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.F) {
                    instantScreenWidth = ScreenUtil.getInstantScreenWidth(context);
                    instantScreenHeight = ScreenUtil.getInstantScreenHeight(context) + ScreenUtil.getNavigationBarHeight(context);
                } else {
                    instantScreenWidth = ScreenUtil.getInstantScreenWidth(context) + ScreenUtil.getNavigationBarHeight(context);
                    instantScreenHeight = ScreenUtil.getInstantScreenHeight(context);
                }
                int h16 = x.h(context, instantScreenWidth);
                int h17 = x.h(context, instantScreenHeight);
                jSONObject.put("da", String.valueOf(h16));
                jSONObject.put(TVKNetVideoInfo.AUDIO_TRACK_DOLBY, String.valueOf(h17));
                jSONObject.put("px", String.valueOf(0));
                jSONObject.put("py", String.valueOf(0));
                jSONObject.put(HippyTKDListViewAdapter.X, String.valueOf(z16 ? 1 : 0));
                jSONObject.put("p", String.valueOf(j3));
                jSONObject.put("aa", String.valueOf(x.h(context, this.f109101e)));
                jSONObject.put("ab", String.valueOf(x.h(context, this.f109102f)));
                jSONObject.put("ba", String.valueOf(x.h(context, this.f109104i)));
                jSONObject.put("bb", String.valueOf(x.h(context, this.f109105m)));
                jSONObject.put("g", String.valueOf(abs));
                if (this.E) {
                    str4 = "1";
                } else {
                    str4 = "0";
                }
                jSONObject.put("f", str4);
                jSONObject.put("sc", String.valueOf(currentTimeMillis));
                jSONObject.put("ec", String.valueOf(currentTimeMillis2));
                jSONObject.put("d", String.valueOf(0));
                jSONObject.put("sz", String.valueOf(-999));
                if (z17) {
                    i3 = 2;
                } else {
                    i3 = 1;
                }
                jSONObject.put("vca", String.valueOf(i3));
            } catch (Exception e16) {
                GdtLog.e("GdtMotiveVideoClickCoordinateReportHelper", "getReportString error", e16);
            }
            str3 = jSONObject.toString();
        } else {
            str3 = str2;
        }
        GdtLog.i("GdtMotiveVideoClickCoordinateReportHelper", "cgi upload param:" + str3);
        return d(3, str, str3);
    }

    public void g(View view) {
        List<WeakReference<View>> list = this.D;
        if (list != null && view != null) {
            list.add(new WeakReference<>(view));
            view.setOnTouchListener(this);
        } else {
            GdtLog.d("GdtMotiveVideoClickCoordinateReportHelper", "cancel listenOnTouchEvent");
        }
    }

    public void h() {
        this.C = null;
        Iterator<WeakReference<View>> it = this.D.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null) {
                view.setOnTouchListener(null);
            }
        }
        this.E = false;
    }

    public void i(View view) {
        List<WeakReference<View>> list = this.D;
        if (list != null && view != null) {
            for (WeakReference<View> weakReference : list) {
                if (weakReference.get() == view) {
                    this.D.remove(weakReference);
                    view.setOnTouchListener(null);
                    return;
                }
            }
            return;
        }
        GdtLog.d("GdtMotiveVideoClickCoordinateReportHelper", "cancel removeTouchEventListener");
    }

    public void j(boolean z16) {
        this.F = z16;
    }

    public void k(InterfaceC1159b interfaceC1159b) {
        this.C = interfaceC1159b;
    }

    public void l(boolean z16) {
        this.E = z16;
    }

    @Override // android.view.View.OnTouchListener
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouch(View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1) {
                this.f109103h = System.currentTimeMillis();
                this.f109104i = (int) motionEvent.getRawX();
                int rawY = (int) motionEvent.getRawY();
                this.f109105m = rawY;
                InterfaceC1159b interfaceC1159b = this.C;
                if (interfaceC1159b != null) {
                    interfaceC1159b.a(this.f109100d, this.f109103h, this.f109101e, this.f109102f, this.f109104i, rawY);
                    return false;
                }
                return false;
            }
            return false;
        }
        this.f109100d = System.currentTimeMillis();
        this.f109101e = (int) motionEvent.getRawX();
        this.f109102f = (int) motionEvent.getRawY();
        return false;
    }
}
