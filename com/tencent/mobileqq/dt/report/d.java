package com.tencent.mobileqq.dt.report;

import android.annotation.SuppressLint;
import android.hardware.SensorEvent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Base64;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.dt.model.i;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static long f203861a;

    /* renamed from: b, reason: collision with root package name */
    private static int f203862b;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnTouchListener f203863d;

        a(View.OnTouchListener onTouchListener) {
            this.f203863d = onTouchListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onTouchListener);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            this.f203863d.onTouch(view, motionEvent);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnTouchListener f203864d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f203865e;

        b(View.OnTouchListener onTouchListener, Object obj) {
            this.f203864d = onTouchListener;
            this.f203865e = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onTouchListener, obj);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            this.f203864d.onTouch(view, motionEvent);
            return ((View.OnTouchListener) this.f203865e).onTouch(view, motionEvent);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class c implements TextWatcher {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203866d;

        c(String str) {
            this.f203866d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) editable);
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i3, int i16, int i17) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, charSequence, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
            } else {
                i.c().f(this.f203866d, i17, i3);
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.dt.report.d$d, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    class ViewOnLongClickListenerC7491d implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203867d;

        ViewOnLongClickListenerC7491d(String str) {
            this.f203867d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean z16;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                z16 = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                i.c().e(this.f203867d);
                z16 = false;
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return z16;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class e implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f203868d;

        e(String str) {
            this.f203868d = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            i.c().d(this.f203868d, keyEvent);
            return false;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class f implements View.OnLongClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnLongClickListener f203869d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f203870e;

        f(View.OnLongClickListener onLongClickListener, Object obj) {
            this.f203869d = onLongClickListener;
            this.f203870e = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onLongClickListener, obj);
            }
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            boolean onLongClick;
            EventCollector.getInstance().onViewLongClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                onLongClick = ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view)).booleanValue();
            } else {
                this.f203869d.onLongClick(view);
                onLongClick = ((View.OnLongClickListener) this.f203870e).onLongClick(view);
            }
            EventCollector.getInstance().onViewLongClicked(view);
            return onLongClick;
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class g implements View.OnKeyListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View.OnKeyListener f203871d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Object f203872e;

        g(View.OnKeyListener onKeyListener, Object obj) {
            this.f203871d = onKeyListener;
            this.f203872e = obj;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) onKeyListener, obj);
            }
        }

        @Override // android.view.View.OnKeyListener
        public boolean onKey(View view, int i3, KeyEvent keyEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, this, view, Integer.valueOf(i3), keyEvent)).booleanValue();
            }
            this.f203871d.onKey(view, i3, keyEvent);
            return ((View.OnKeyListener) this.f203872e).onKey(view, i3, keyEvent);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f203861a = -1L;
            f203862b = 0;
        }
    }

    public static String a(String str) {
        try {
            return String.format("0x%04x", Integer.valueOf(Integer.parseInt(str.substring(2), 16) + 1));
        } catch (Throwable th5) {
            QLog.e("FEKitMain.RegReport", 1, "click2Sensor exception:" + th5.getMessage());
            return "";
        }
    }

    public static boolean b() {
        try {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqsec_register_login_monitor_switch", false);
        } catch (Throwable th5) {
            QLog.e("FEKitMain.RegReport", 1, "shiply exception:" + th5);
            return true;
        }
    }

    public static boolean c() {
        try {
            return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqsec_register_login_monitor_switch", false);
        } catch (Throwable th5) {
            QLog.e("FEKitMain.RegReport", 1, "shiply exception:" + th5);
            return false;
        }
    }

    public static String d(Object obj) {
        DecimalFormat decimalFormat;
        String str;
        if (obj == null) {
            return "";
        }
        try {
            decimalFormat = new DecimalFormat("#.00");
        } catch (Throwable th5) {
            QLog.e("FEKitMain.RegReport", 1, "eventToString exception:" + th5.getMessage());
        }
        if (obj instanceof MotionEvent) {
            MotionEvent motionEvent = (MotionEvent) obj;
            if (motionEvent.getAction() == 2) {
                f203862b++;
            }
            if (motionEvent.getAction() != 1) {
                return "-1";
            }
            long eventTime = motionEvent.getEventTime() - motionEvent.getDownTime();
            if (motionEvent.getDevice() == null) {
                str = "";
            } else {
                str = Base64.encodeToString(motionEvent.getDevice().toString().getBytes(StandardCharsets.UTF_8), 0).replace("\n", "");
            }
            String str2 = "{\"X\":\"" + decimalFormat.format(motionEvent.getX()) + "\",\"Y\":\"" + decimalFormat.format(motionEvent.getY()) + "\",\"p\":\"" + decimalFormat.format(motionEvent.getPressure()) + "\",\"s\":\"" + motionEvent.getSize() + "\",\"touch\":\"" + motionEvent.getTouchMajor() + "_" + motionEvent.getTouchMinor() + "\",\"device\":\"" + str + "\",\"toolType\":\"" + motionEvent.getToolType(motionEvent.getActionIndex()) + "\",\"move\":\"" + f203862b;
            f203862b = 0;
            return str2 + "\",\"duration\":\"" + eventTime + "\"}";
        }
        if (obj instanceof SensorEvent) {
            SensorEvent sensorEvent = (SensorEvent) obj;
            return "{\"X\":\"" + decimalFormat.format(sensorEvent.values[0]) + "\",\"Y\":\"" + decimalFormat.format(sensorEvent.values[1]) + "\",\"Z\":\"" + decimalFormat.format(sensorEvent.values[2]) + "\"}";
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return "";
    }

    public static boolean e(String str) {
        if (!str.equals(com.tencent.mobileqq.dt.api.c.f203650m) && !str.equals(com.tencent.mobileqq.dt.api.c.f203651n) && !str.equals(com.tencent.mobileqq.dt.api.c.f203649l) && !str.equals(com.tencent.mobileqq.dt.api.c.f203663z) && !str.equals(com.tencent.mobileqq.dt.api.c.f203662y) && !str.equals(com.tencent.mobileqq.dt.api.c.f203661x) && !str.equals(com.tencent.mobileqq.dt.api.c.f203646i) && !str.equals(com.tencent.mobileqq.dt.api.c.f203644g) && !str.equals(com.tencent.mobileqq.dt.api.c.f203645h) && !str.equals(com.tencent.mobileqq.dt.api.c.f203658u) && !str.equals(com.tencent.mobileqq.dt.api.c.I) && !str.equals(com.tencent.mobileqq.dt.api.c.K) && !str.equals(com.tencent.mobileqq.dt.api.c.M) && !str.equals(com.tencent.mobileqq.dt.api.c.O)) {
            return false;
        }
        return true;
    }

    public static boolean f() {
        try {
            IFeatureRuntimeService iFeatureRuntimeService = (IFeatureRuntimeService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IFeatureRuntimeService.class, "all");
            if (!iFeatureRuntimeService.isFeatureSwitchEnable("reg_action_report")) {
                return false;
            }
            return "1".equals(iFeatureRuntimeService.getJSONObject("reg_action_report", "{}").optString("reg_new_sensor", "1"));
        } catch (Throwable th5) {
            QLog.e("FEKitMain.RegReport", 1, "reg_action_report reg_new_sensor:" + th5);
            return false;
        }
    }

    public static void g(String str, View view) {
        try {
            if (view instanceof EditText) {
                ((EditText) view).addTextChangedListener(new c(str));
                Class<?> cls = Class.forName("android.view.View");
                Class<?> cls2 = Class.forName("android.view.View$ListenerInfo");
                Field declaredField = cls.getDeclaredField("mListenerInfo");
                declaredField.setAccessible(true);
                Object obj = declaredField.get(view);
                Field declaredField2 = cls2.getDeclaredField("mOnLongClickListener");
                Field declaredField3 = cls2.getDeclaredField("mOnKeyListener");
                declaredField2.setAccessible(true);
                declaredField3.setAccessible(true);
                Object obj2 = declaredField2.get(obj);
                Object obj3 = declaredField3.get(obj);
                ViewOnLongClickListenerC7491d viewOnLongClickListenerC7491d = new ViewOnLongClickListenerC7491d(str);
                e eVar = new e(str);
                if (obj == null) {
                    view.setOnLongClickListener(viewOnLongClickListenerC7491d);
                    view.setOnKeyListener(eVar);
                    return;
                }
                if (obj2 == null) {
                    view.setOnLongClickListener(viewOnLongClickListenerC7491d);
                } else {
                    declaredField2.set(obj, new f(viewOnLongClickListenerC7491d, obj2));
                }
                if (obj3 == null) {
                    view.setOnKeyListener(eVar);
                } else {
                    declaredField3.set(obj, new g(eVar, obj3));
                }
            }
        } catch (Throwable th5) {
            QLog.e("FEKitMain.RegReport", 1, "regEvC Throwable:" + th5);
        }
    }

    @SuppressLint({"PrivateApi", "DiscouragedPrivateApi"})
    public static void h(AppInterface appInterface, String str, String str2, View view, View.OnTouchListener onTouchListener) {
        try {
            if (com.tencent.mobileqq.dt.api.c.K.equals(str2)) {
                return;
            }
            Class<?> cls = Class.forName("android.view.View");
            Class<?> cls2 = Class.forName("android.view.View$ListenerInfo");
            Field declaredField = cls.getDeclaredField("mListenerInfo");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(view);
            Field declaredField2 = cls2.getDeclaredField("mOnTouchListener");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(obj);
            a aVar = new a(onTouchListener);
            if (obj == null) {
                view.setOnTouchListener(aVar);
            } else if (obj2 == null) {
                view.setOnTouchListener(aVar);
            } else {
                declaredField2.set(obj, new b(onTouchListener, obj2));
            }
        } catch (Throwable th5) {
            QLog.e("FEKitMain.RegReport", 1, "uiTouchEventHook exception:" + th5);
        }
    }
}
