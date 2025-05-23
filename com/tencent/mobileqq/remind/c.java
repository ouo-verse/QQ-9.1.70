package com.tencent.mobileqq.remind;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.remind.widget.IosTimepicker;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import java.util.Date;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f280874a;

    /* renamed from: b, reason: collision with root package name */
    public static String f280875b;

    /* renamed from: c, reason: collision with root package name */
    public static String f280876c;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f280877d;

    /* renamed from: e, reason: collision with root package name */
    private static IosTimepicker.e f280878e;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class a implements IosTimepicker.e {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x003d  */
        /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[LOOP:0: B:31:0x0088->B:32:0x008a, LOOP_END] */
        @Override // com.tencent.mobileqq.remind.widget.IosTimepicker.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public long a(WheelView[] wheelViewArr, int[] iArr) {
            String str;
            int i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Long) iPatchRedirector.redirect((short) 2, (Object) this, (Object) wheelViewArr, (Object) iArr)).longValue();
            }
            if (iArr.length == 3 && wheelViewArr.length == 3) {
                if (AppSetting.f99565y) {
                    String c16 = e.c(iArr[0]);
                    int i16 = iArr[1];
                    String str2 = null;
                    if (i16 >= 0) {
                        String[] strArr = e.f280885b;
                        if (i16 < strArr.length) {
                            str = strArr[i16];
                            i3 = iArr[2];
                            if (i3 >= 0) {
                                String[] strArr2 = e.f280886c;
                                if (i3 < strArr2.length) {
                                    str2 = strArr2[i3];
                                }
                            }
                            if (!TextUtils.isEmpty(c16) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                                String str3 = HardCodeUtil.qqStr(R.string.t0a) + c16 + str + HardCodeUtil.qqStr(R.string.t09) + str2 + HardCodeUtil.qqStr(R.string.t0_);
                                for (WheelView wheelView : wheelViewArr) {
                                    wheelView.setContentDescription(str3);
                                }
                            }
                        }
                    }
                    str = null;
                    i3 = iArr[2];
                    if (i3 >= 0) {
                    }
                    if (!TextUtils.isEmpty(c16)) {
                        String str32 = HardCodeUtil.qqStr(R.string.t0a) + c16 + str + HardCodeUtil.qqStr(R.string.t09) + str2 + HardCodeUtil.qqStr(R.string.t0_);
                        while (r5 < r4) {
                        }
                    }
                }
                return e.b(iArr[0], iArr[1], iArr[2]);
            }
            return -1L;
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements DialogInterface.OnDismissListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IosTimepicker f280879d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JsBridgeListener f280880e;

        b(IosTimepicker iosTimepicker, JsBridgeListener jsBridgeListener) {
            this.f280879d = iosTimepicker;
            this.f280880e = jsBridgeListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) iosTimepicker, (Object) jsBridgeListener);
            }
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface);
                return;
            }
            IosTimepicker iosTimepicker = this.f280879d;
            if (iosTimepicker != null && this.f280880e != null) {
                long f16 = iosTimepicker.f() / 1000;
                if (DeviceInfoMonitor.getModel().equals("Coolpad 5890")) {
                    long time = new Date().getTime() / 1000;
                    if (f16 < time) {
                        f16 = time;
                    }
                }
                if (QLog.isColorLevel()) {
                    QLog.d(c.f280874a, 2, "onDismiss Time :" + e.a(1000 * f16));
                }
                this.f280879d.setOnTimePickerSelectListener(null);
                this.f280880e.c(Long.valueOf(f16));
                c.f280877d = true;
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(74661);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f280874a = "remind";
        f280875b = "1";
        f280876c = "0";
        f280877d = true;
        f280878e = new a();
    }

    public static int b(Context context, String str, long j3, long j16, String str2, String str3, int[] iArr) {
        return -9;
    }

    public static void c(Context context, long j3, IosTimepicker.f fVar, JsBridgeListener jsBridgeListener) {
        LayoutInflater from = LayoutInflater.from(context);
        if (f280877d) {
            f280877d = false;
            ActionSheet createMenuSheet = ActionSheet.createMenuSheet(context);
            ((DispatchActionMoveScrollView) createMenuSheet.findViewById(R.id.f163936cz)).dispatchActionMove = true;
            IosTimepicker iosTimepicker = (IosTimepicker) from.inflate(R.layout.c3q, (ViewGroup) null);
            iosTimepicker.setMaxDays(25568);
            iosTimepicker.g(context, createMenuSheet, fVar, null, new BaseAdapter[]{new com.tencent.mobileqq.remind.a(context, 25), new com.tencent.mobileqq.remind.b(context, e.f280885b, 25), new com.tencent.mobileqq.remind.b(context, e.f280886c, 25)}, new int[]{(int) e.f(j3), e.d(j3), e.e(j3)}, f280878e);
            createMenuSheet.getWindow().setFlags(16777216, 16777216);
            createMenuSheet.setActionContentView(iosTimepicker, null);
            createMenuSheet.setOnDismissListener(new b(iosTimepicker, jsBridgeListener));
            try {
                createMenuSheet.show();
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.d(f280874a, 2, th5.getMessage());
                }
            }
        }
    }

    public static boolean d(String str) {
        if (str.equalsIgnoreCase(f280875b)) {
            return true;
        }
        return false;
    }

    public static Long e(String str) {
        long time = new Date().getTime() / 1000;
        try {
            time = Long.valueOf(str).longValue();
        } catch (NumberFormatException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f280874a, 2, "getLong error: " + e16.getMessage());
                e16.printStackTrace();
            }
        }
        return Long.valueOf(time);
    }

    public static String f(String str, String str2) {
        try {
            return new JSONObject(str).optString(str2);
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(f280874a, 2, "getString from json error:" + e16.getMessage());
            }
            return "";
        }
    }
}
