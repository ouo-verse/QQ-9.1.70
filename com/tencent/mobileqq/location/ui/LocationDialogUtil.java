package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.dq;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;

/* compiled from: P */
/* loaded from: classes15.dex */
public class LocationDialogUtil {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static String f241384a;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$6, reason: invalid class name */
    /* loaded from: classes15.dex */
    class AnonymousClass6 implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f241399d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f241400e;

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$6$a */
        /* loaded from: classes15.dex */
        class a implements DialogInterface.OnClickListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass6.this);
                }
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                } else {
                    AnonymousClass6.this.f241399d.finish();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            LocationDialogUtil.m(this.f241399d, dq.a(this.f241399d, 230, null, this.f241399d.getResources().getString(R.string.vrs) + this.f241400e, R.string.f171151ok, R.string.cancel, new a(), null));
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ReportController.o(null, "CliOper", "", "", "0X800A97A", "0X800A97A", 0, 0, "", "0", "0", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class b implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f241413d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f241414e;

        b(int i3, String str) {
            this.f241413d = i3;
            this.f241414e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) str);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            com.tencent.mobileqq.location.net.e.c().f241360d.e(3, this.f241413d, this.f241414e);
            LocationShareLocationManager.h().o(new LocationRoom.b(this.f241413d, this.f241414e), true);
            ReportController.o(null, "CliOper", "", "", "0X800A979", "0X800A979", 0, 0, "", "0", "0", "");
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f241415d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f241416e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f241417f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f241418h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ LatLng f241419i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ LatLng f241420m;

        c(Activity activity, String str, String str2, String str3, LatLng latLng, LatLng latLng2) {
            this.f241415d = activity;
            this.f241416e = str;
            this.f241417f = str2;
            this.f241418h = str3;
            this.f241419i = latLng;
            this.f241420m = latLng2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, activity, str, str2, str3, latLng, latLng2);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                MapUtils.m(this.f241415d, this.f241416e, this.f241417f, this.f241418h, this.f241419i, this.f241420m);
                ReportController.o(null, "CliOper", "", "", "0X800A970", "0X800A970", 0, 0, "0", "0", "0", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else {
                ReportController.o(null, "CliOper", "", "", "0X800A971", "0X800A971", 0, 0, "0", "0", "0", "");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26931);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f241384a = "";
        }
    }

    public static boolean d(Activity activity) {
        if (activity instanceof QPublicFragmentActivity) {
            String stringExtra = activity.getIntent().getStringExtra("FRAGMENT_KEY");
            if (QLog.isColorLevel()) {
                QLog.d("LocationDialogUtil", 2, "activityIsShareOrPickFragment: invoked. ", " key: ", stringExtra);
            }
            if ("LocationShareFragment".equals(stringExtra) || "LocationPickFragment".equals(stringExtra) || "LocationPickFragment".equals(stringExtra)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void e(int i3, String str) {
        int i16;
        int i17;
        if (i3 == 3) {
            i16 = 1;
        } else {
            if (i3 == 2) {
                i17 = 2;
                ReportController.o(null, "CliOper", "", "", str, str, i17, 0, "", "0", "0", "");
            }
            i16 = 0;
        }
        i17 = i16;
        ReportController.o(null, "CliOper", "", "", str, str, i17, 0, "", "0", "0", "");
    }

    public static void f(Activity activity, int i3, String str, int i16) {
        String string;
        if (QLog.isColorLevel()) {
            QLog.d("LocationDialogUtil", 2, "showEnterOtherRoomExitDialog: invoked. ", "activity = [" + activity + "], uinType = [" + i3 + "], uin = [" + str + "], entryType = [" + i16 + "]");
        }
        if (i16 == 1) {
            string = activity.getResources().getString(R.string.vrq);
        } else {
            string = activity.getResources().getString(R.string.vrp);
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(activity, string, i3, str, i16) { // from class: com.tencent.mobileqq.location.ui.LocationDialogUtil.9
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f241406d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ String f241407e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ int f241408f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ String f241409h;

            /* renamed from: i, reason: collision with root package name */
            final /* synthetic */ int f241410i;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$9$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    LocationHandler K2 = LocationHandler.K2();
                    AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                    K2.N2(new LocationRoom.b(anonymousClass9.f241408f, anonymousClass9.f241409h));
                    com.tencent.mobileqq.location.net.e.c().g(true);
                    com.tencent.mobileqq.location.net.e c16 = com.tencent.mobileqq.location.net.e.c();
                    AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                    c16.a(anonymousClass92.f241408f, anonymousClass92.f241409h);
                    AnonymousClass9 anonymousClass93 = AnonymousClass9.this;
                    LocationShareFragment.wh(anonymousClass93.f241406d, anonymousClass93.f241408f, anonymousClass93.f241409h, anonymousClass93.f241410i);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$9$b */
            /* loaded from: classes15.dex */
            class b implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    }
                }
            }

            {
                this.f241406d = activity;
                this.f241407e = string;
                this.f241408f = i3;
                this.f241409h = str;
                this.f241410i = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, activity, string, Integer.valueOf(i3), str, Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                } else {
                    LocationDialogUtil.m(this.f241406d, dq.a(this.f241406d, 230, null, this.f241407e, R.string.cancel, R.string.f171151ok, new a(), new b()));
                }
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void g(Activity activity, int i3, int i16, String str) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity) { // from class: com.tencent.mobileqq.location.ui.LocationDialogUtil.4
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f241391d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$4$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass4.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        AnonymousClass4.this.f241391d.finish();
                    }
                }
            }

            {
                this.f241391d = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Activity activity2 = this.f241391d;
                LocationDialogUtil.m(this.f241391d, dq.a(activity2, 230, null, activity2.getResources().getString(R.string.vrr), R.string.cancel, R.string.f171151ok, new a(), null));
            }
        });
        com.tencent.mobileqq.location.net.e.c().e(i16, str, i3, 2);
    }

    public static QQCustomDialog h(int i3, String str) {
        if (QLog.isColorLevel()) {
            QLog.d("LocationDialogUtil", 2, "showFloatExitConfirmDialog: invoked. ");
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            QQCustomDialog a16 = dq.a(qBaseActivity, 230, null, BaseApplication.getContext().getString(R.string.vy6), R.string.close, R.string.c9l, new a(), new b(i3, str));
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(a16) { // from class: com.tencent.mobileqq.location.ui.LocationDialogUtil.12
                static IPatchRedirector $redirector_;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ QQCustomDialog f241386e;

                {
                    this.f241386e = a16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) QBaseActivity.this, (Object) a16);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        LocationDialogUtil.m(QBaseActivity.this, this.f241386e);
                    }
                }
            }, 500L);
            return a16;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void i(Activity activity, String str, String str2, String str3, LatLng latLng, LatLng latLng2) {
        m(activity, dq.a(activity, 230, null, activity.getResources().getString(R.string.gfz), R.string.cancel, R.string.f171151ok, new c(activity, str, str2, str3, latLng, latLng2), new d()));
    }

    public static void j(Activity activity, k kVar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity, kVar) { // from class: com.tencent.mobileqq.location.ui.LocationDialogUtil.3
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f241387d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ k f241388e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$3$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        AnonymousClass3.this.f241388e.p();
                        ReportController.o(null, "CliOper", "", "", "0X800A967", "0X800A967", 0, 0, "0", "0", "0", "");
                    }
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$3$b */
            /* loaded from: classes15.dex */
            class b implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass3.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X800A968", "0X800A968", 0, 0, "0", "0", "0", "");
                    }
                }
            }

            {
                this.f241387d = activity;
                this.f241388e = kVar;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity, (Object) kVar);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Activity activity2 = this.f241387d;
                LocationDialogUtil.m(this.f241387d, dq.a(activity2, 230, null, activity2.getResources().getString(R.string.f171090gq3), R.string.cancel, R.string.f171091gq4, new a(), new b()));
            }
        });
    }

    public static void k(Activity activity) {
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable(activity) { // from class: com.tencent.mobileqq.location.ui.LocationDialogUtil.7
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f241402d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$7$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass7.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else if (LocationDialogUtil.d(AnonymousClass7.this.f241402d)) {
                        AnonymousClass7.this.f241402d.finish();
                    }
                }
            }

            {
                this.f241402d = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Activity activity2 = this.f241402d;
                LocationDialogUtil.m(this.f241402d, dq.a(activity2, 230, null, activity2.getResources().getString(R.string.vrt), R.string.f171151ok, R.string.cancel, null, new a()));
            }
        }, 500L);
    }

    public static void l(Activity activity) {
        Runnable runnable = new Runnable(activity) { // from class: com.tencent.mobileqq.location.ui.LocationDialogUtil.8
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f241404d;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$8$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass8.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    } else if (LocationDialogUtil.d(AnonymousClass8.this.f241404d)) {
                        AnonymousClass8.this.f241404d.finish();
                        LocationDialogUtil.f241384a = "";
                    }
                }
            }

            {
                this.f241404d = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Activity activity2 = this.f241404d;
                QQCustomDialog a16 = dq.a(activity2, 230, null, activity2.getResources().getString(R.string.vru), R.string.vrh, R.string.cancel, null, new a());
                a16.setCancelable(false);
                if (!String.valueOf(this.f241404d.hashCode()).equals(LocationDialogUtil.f241384a)) {
                    LocationDialogUtil.m(this.f241404d, a16);
                    if (QLog.isColorLevel()) {
                        QLog.d("LocationDialogUtil", 2, "showRoomJoinLimitedDialog#run: invoked. ", " currentDialogActivityHash: ", LocationDialogUtil.f241384a);
                        return;
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("LocationDialogUtil", 2, "run: invoked. ", " same hash currentDialogActivityHash: ", LocationDialogUtil.f241384a, " activity: ", Integer.valueOf(this.f241404d.hashCode()));
                }
            }
        };
        ThreadManagerV2.getUIHandlerV2().postDelayed(runnable, 500L);
        if (QLog.isColorLevel()) {
            QLog.d("LocationDialogUtil", 2, "showRoomJoinLimitedDialog: invoked. showRoomJoinLimitedDialog#post ", " runnable: ", runnable);
        }
    }

    public static void m(Activity activity, QQCustomDialog qQCustomDialog) {
        if (activity != null) {
            try {
                if (!activity.isFinishing()) {
                    qQCustomDialog.show();
                    f241384a = String.valueOf(activity.hashCode());
                    if (QLog.isColorLevel()) {
                        QLog.d("LocationDialogUtil", 2, "showSafely: invoked. ", " currentDialogActivityHash: ", f241384a);
                    }
                }
            } catch (Exception e16) {
                QLog.e("LocationDialogUtil", 1, "showSafely: failed. ", e16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void n(Activity activity, int i3, String str, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("LocationDialogUtil", 2, "showStartShareLocationDialog: invoked. ", "context = [" + activity + "], uinType = [" + i3 + "], frienduin = [" + str + "]");
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable(activity, i3, str, i16) { // from class: com.tencent.mobileqq.location.ui.LocationDialogUtil.5
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Activity f241393d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ int f241394e;

            /* renamed from: f, reason: collision with root package name */
            final /* synthetic */ String f241395f;

            /* renamed from: h, reason: collision with root package name */
            final /* synthetic */ int f241396h;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$5$a */
            /* loaded from: classes15.dex */
            class a implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                a() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("LocationDialogUtil", 2, "onClick: invoked. showStartShareLocationDialog  ", " which: ", Integer.valueOf(i3));
                    }
                    BaseApplication context = BaseApplication.getContext();
                    AnonymousClass5 anonymousClass5 = AnonymousClass5.this;
                    LocationShareFragment.wh(context, anonymousClass5.f241394e, anonymousClass5.f241395f, anonymousClass5.f241396h);
                    try {
                        com.tencent.mobileqq.location.net.e.c().g(true);
                    } catch (Throwable unused) {
                    }
                    LocationDialogUtil.e(AnonymousClass5.this.f241396h, "0X800A769");
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.location.ui.LocationDialogUtil$5$b */
            /* loaded from: classes15.dex */
            class b implements DialogInterface.OnClickListener {
                static IPatchRedirector $redirector_;

                b() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass5.this);
                    }
                }

                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                        LocationDialogUtil.e(AnonymousClass5.this.f241396h, "0X800A76A");
                    } else {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                    }
                }
            }

            {
                this.f241393d = activity;
                this.f241394e = i3;
                this.f241395f = str;
                this.f241396h = i16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, activity, Integer.valueOf(i3), str, Integer.valueOf(i16));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                Activity activity2 = this.f241393d;
                LocationDialogUtil.m(this.f241393d, dq.a(activity2, 230, null, activity2.getResources().getString(R.string.vrv), R.string.cancel, R.string.f171151ok, new a(), new b()));
            }
        });
    }
}
