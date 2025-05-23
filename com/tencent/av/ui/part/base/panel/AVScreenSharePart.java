package com.tencent.av.ui.part.base.panel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.n;
import com.tencent.av.r;
import com.tencent.av.screenshare.ScreenShareCtrl;
import com.tencent.av.screenshare.ScreenShareManager;
import com.tencent.av.screenshare.ScreenShareQQCustomDialog;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.ScreenRecordHelper;
import com.tencent.av.ui.m;
import com.tencent.av.utils.af;
import com.tencent.av.utils.api.IUIToolsApi;
import com.tencent.commonsdk.badge.CommonBadgeUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.servlet.MiniAppObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;

/* loaded from: classes32.dex */
public class AVScreenSharePart extends com.tencent.av.ui.part.base.panel.e {

    /* renamed from: h, reason: collision with root package name */
    long f76324h;

    /* renamed from: i, reason: collision with root package name */
    private QQProgressDialog f76325i;

    /* renamed from: m, reason: collision with root package name */
    private volatile boolean f76326m;

    /* loaded from: classes32.dex */
    class a implements DialogInterface.OnClickListener {
        a() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AVScreenSharePart.this.K9();
            if (dialogInterface instanceof ScreenShareQQCustomDialog) {
                ((ScreenShareQQCustomDialog) dialogInterface).o0();
            }
        }
    }

    /* loaded from: classes32.dex */
    class b implements DialogInterface.OnClickListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes32.dex */
    class c implements DialogInterface.OnClickListener {
        c() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AVScreenSharePart.this.K9();
            if (dialogInterface instanceof ScreenShareQQCustomDialog) {
                ((ScreenShareQQCustomDialog) dialogInterface).o0();
            }
        }
    }

    /* loaded from: classes32.dex */
    class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes32.dex */
    class f implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76332d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f76333e;

        f(long j3, View view) {
            this.f76332d = j3;
            this.f76333e = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AVScreenSharePart.this.P9(this.f76332d, this.f76333e);
        }
    }

    /* loaded from: classes32.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* loaded from: classes32.dex */
    class h implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76336d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f76337e;

        h(long j3, View view) {
            this.f76336d = j3;
            this.f76337e = view;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            AVScreenSharePart.this.P9(this.f76336d, this.f76337e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class j implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f76343d;

        j(ActionSheet actionSheet) {
            this.f76343d = actionSheet;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.tencent.av.screenshare.c.a("0X800B8AC");
            this.f76343d.superDismiss();
        }
    }

    /* loaded from: classes32.dex */
    class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    public AVScreenSharePart(QavPanel qavPanel) {
        super(qavPanel);
        this.f76324h = 0L;
        this.f76326m = false;
    }

    private static boolean I9() {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 < 29) {
            return false;
        }
        return !Build.MANUFACTURER.equalsIgnoreCase(CommonBadgeUtilImpl.MANUFACTURER_OF_HARDWARE_XIAOMI) || !(DeviceInfoMonitor.getModel().equalsIgnoreCase("2201123C") || DeviceInfoMonitor.getModel().equalsIgnoreCase("Redmi Note 7 Pro") || DeviceInfoMonitor.getModel().equalsIgnoreCase("Redmi K20 Pro") || DeviceInfoMonitor.getModel().equalsIgnoreCase("M2012K11AC")) || i3 >= 33;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K9() {
        if (r.h0() != null) {
            r.h0().l();
            Q9();
            getMainHandler().postDelayed(new Runnable() { // from class: com.tencent.av.ui.part.base.panel.AVScreenSharePart.13
                @Override // java.lang.Runnable
                public void run() {
                    AVScreenSharePart.this.H9();
                }
            }, 5000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P9(long j3, View view) {
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || aVActivity.isFinishing() || aVActivity.isDestroyed()) {
            return;
        }
        ActionSheet create = ActionSheet.create(aVActivity);
        create.addButton(R.string.f224096i0, 0);
        if (af.y()) {
            create.addButton(R.string.f224086hz, 0);
            create.addCancelButton(R.string.cancel);
            create.setOnButtonClickListener(new i(j3, view, create));
            create.setOnBottomCancelListener(new j(create));
            create.show();
            com.tencent.av.screenshare.c.a("0X800B8A1");
            return;
        }
        M9(j3, view);
        com.tencent.av.screenshare.c.b("0X800AD8E", 1);
    }

    private void R9(ScreenShareQQCustomDialog screenShareQQCustomDialog, boolean z16) {
        SessionInfo f16;
        if (nw.b.b() == null || (f16 = n.e().f()) == null) {
            return;
        }
        String currentAccountUin = nw.b.b().getCurrentAccountUin();
        String str = f16.f73091w;
        if (TextUtils.isEmpty(currentAccountUin) || TextUtils.isEmpty(str)) {
            return;
        }
        screenShareQQCustomDialog.r0(currentAccountUin, 1, str, z16);
    }

    private boolean S9() {
        AVActivity aVActivity = (AVActivity) getActivity();
        ScreenRecordHelper d36 = aVActivity == null ? null : aVActivity.d3();
        return d36 == null || d36.A();
    }

    public void E9(long j3, View view) {
        SessionInfo f16 = n.e().f();
        if (!f16.f()) {
            if (QLog.isColorLevel()) {
                QLog.i("normal_2_meeting", 2, "onClick_ScreenShare can not start share now.");
            }
            ScreenShareCtrl.s(7);
        } else {
            com.tencent.av.screenshare.c.i(f16.f73030h, 2, "onClick_ScreenShare");
            A9(j3, m.e.f76024k);
            ScreenShareCtrl y06 = r.h0().y0();
            if (y06 != null) {
                y06.u((AVActivity) getActivity(), j3);
            }
            this.f76370f.post(new Runnable() { // from class: com.tencent.av.ui.part.base.panel.AVScreenSharePart.1
                @Override // java.lang.Runnable
                public void run() {
                    AVScreenSharePart.this.F9(-1052L);
                    QavPanel qavPanel = AVScreenSharePart.this.f76370f;
                    if (qavPanel != null) {
                        qavPanel.E0();
                    }
                }
            });
        }
    }

    public void F9(long j3) {
        rw.a x95;
        if (QLog.isColorLevel() && j3 == -1052) {
            QLog.i(this.f76368d, 2, "updateBtn_ScreenShare");
        }
        Context context = getContext();
        if (context == null || (x95 = x9(m.e.f76024k, j3)) == null) {
            return;
        }
        if (!af.z()) {
            x95.n(false);
            return;
        }
        x95.n(true);
        SessionInfo f16 = n.e().f();
        if (f16.f73067q == 1044) {
            x95.n(false);
            x95.i(false);
            return;
        }
        int i3 = f16.f73046k2;
        if (i3 != 2 && i3 != 1) {
            x95.l(R.drawable.n6l);
            x95.m(context.getResources().getString(R.string.f1774033v));
        } else {
            x95.l(R.drawable.n7l);
            x95.m(context.getResources().getString(R.string.f1774133w));
        }
    }

    public void H9() {
        try {
            QQProgressDialog qQProgressDialog = this.f76325i;
            if (qQProgressDialog == null || !qQProgressDialog.isShowing()) {
                return;
            }
            this.f76325i.dismiss();
            this.f76326m = false;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(this.f76368d, 2, e16.getMessage());
            }
        }
    }

    public void J9(int i3, byte[] bArr) {
        if (this.f76326m) {
            H9();
            if (i3 == 0) {
                E9(0L, null);
                com.tencent.av.screenshare.c.a("0X800AD8D");
                return;
            } else {
                if (bArr == null || bArr.length <= 0) {
                    return;
                }
                DialogUtil.createCustomDialog(getContext(), 230, (String) null, new String(bArr), (String) null, getContext().getString(R.string.idk), new d(), (DialogInterface.OnClickListener) null).show();
                return;
            }
        }
        QQToast.makeText(getContext(), -1, getContext().getResources().getString(R.string.f17820361), 0).show();
    }

    public void L9(long j3, View view) {
        int i3 = n.e().f().f73046k2;
        if (i3 != 2 && i3 != 1) {
            AVActivity aVActivity = (AVActivity) getActivity();
            if (aVActivity == null || aVActivity.isFinishing() || aVActivity.isDestroyed()) {
                return;
            }
            String string = aVActivity.getString(R.string.f224236id);
            String string2 = aVActivity.getString(R.string.f224206ia);
            String string3 = aVActivity.getString(R.string.f224216ib);
            String string4 = aVActivity.getString(R.string.f224226ic);
            String string5 = aVActivity.getString(R.string.f17790358);
            String string6 = aVActivity.getString(R.string.f17786354);
            af.a r16 = af.r(string2, string3, string4);
            SpannableStringBuilder b16 = com.tencent.av.screenshare.a.b(aVActivity, r16.f76972a, r16.f76973b, r16.f76974c);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            if (!defaultSharedPreferences.contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN")) {
                R9((ScreenShareQQCustomDialog) com.tencent.av.screenshare.a.a(aVActivity, string, b16, string6, string5, true, 10, new k(), new a()), true);
                defaultSharedPreferences.edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
                return;
            } else {
                R9((ScreenShareQQCustomDialog) com.tencent.av.screenshare.a.a(aVActivity, string, b16, string6, string5, false, 0, new b(), new c()).setMessageWithoutAutoLink(b16), false);
                return;
            }
        }
        E9(j3, view);
        com.tencent.av.screenshare.c.a("0X800AD8D");
    }

    public void M9(long j3, View view) {
        ScreenShareCtrl y06;
        if (r.h0() == null || Math.abs(SystemClock.elapsedRealtime() - this.f76324h) < 1000 || (y06 = r.h0().y0()) == null) {
            return;
        }
        this.f76324h = SystemClock.elapsedRealtime();
        A9(j3, m.e.f76024k);
        y06.w(j3);
    }

    public void O9() {
        boolean z16;
        VideoAppInterface b16 = nw.b.b();
        if (!I9()) {
            cw.e.g(b16, MiniAppObserver.MINI_APP_CREATE_UPDATABLE_MSG, 3000L);
            return;
        }
        SessionInfo f16 = n.e().f();
        boolean z17 = true;
        if (!f16.f()) {
            QLog.i("normal_2_meeting", 1, "onClick_ShareAudio can not start share now.");
            ScreenShareCtrl.s(7);
            return;
        }
        AVActivity aVActivity = (AVActivity) getActivity();
        ScreenRecordHelper d36 = aVActivity == null ? null : aVActivity.d3();
        if (d36 == null) {
            return;
        }
        if (d36.A()) {
            d36.h();
            z16 = false;
        } else {
            d36.o();
            z16 = true;
        }
        if (getContext() != null) {
            cw.e.i(b16, getContext().getString(z16 ? R.string.f17750345 : R.string.f17749344), 3000L, false);
        }
        boolean A = d36.A();
        boolean z18 = f16.f73060o0;
        if (!f16.N && !f16.O) {
            z17 = false;
        }
        G9(A, z18, z17);
        QavPanel qavPanel = this.f76370f;
        if (qavPanel != null) {
            qavPanel.post(new Runnable() { // from class: com.tencent.av.ui.part.base.panel.AVScreenSharePart.2
                @Override // java.lang.Runnable
                public void run() {
                    AVScreenSharePart.this.W9(-1052L);
                    QavPanel qavPanel2 = AVScreenSharePart.this.f76370f;
                    if (qavPanel2 != null) {
                        qavPanel2.E0();
                    }
                }
            });
        }
    }

    public void Q9() {
        try {
            if (this.f76325i == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(getContext(), 0, R.layout.gza, 17);
                this.f76325i = qQProgressDialog;
                qQProgressDialog.setBackAndSearchFilter(false);
                this.f76325i.setMessage("");
            }
            this.f76325i.show();
            this.f76326m = true;
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(this.f76368d, 2, e16.getMessage());
            }
        }
    }

    public void T9() {
        int audioShareBtnStartResId;
        int i3;
        if (this.f76370f == null) {
            QLog.e(this.f76368d, 1, "updateBtnOutShareAudio error: mQavPanel is null");
            return;
        }
        if (r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        int i16 = (f16.f73060o0 && ((i3 = f16.f73046k2) == 2 || i3 == 1)) ? 0 : 8;
        QavPanel qavPanel = this.f76370f;
        int i17 = m.l.Q;
        qavPanel.setViewVisibility(i17, i16);
        QavPanel qavPanel2 = this.f76370f;
        int i18 = m.l.R;
        qavPanel2.setViewVisibility(i18, i16);
        if (i16 == 8) {
            return;
        }
        boolean S9 = S9();
        IUIToolsApi iUIToolsApi = (IUIToolsApi) QRoute.api(IUIToolsApi.class);
        if (!S9) {
            audioShareBtnStartResId = iUIToolsApi.getAudioShareBtnStopResId();
        } else {
            audioShareBtnStartResId = iUIToolsApi.getAudioShareBtnStartResId();
        }
        this.f76370f.setImgBtnDrawable(i17, audioShareBtnStartResId);
        int i19 = !S9 ? R.string.f17752347 : R.string.f17751346;
        this.f76370f.U0(i18, i19);
        this.f76370f.Q0(i17, getContext().getString(i19));
    }

    public void U9() {
        int i3;
        if (r.h0() == null || this.f76370f == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        int i16 = (f16.f73060o0 && ((i3 = f16.f73046k2) == 2 || i3 == 1)) ? 0 : 8;
        this.f76370f.setViewVisibility(m.l.S, i16);
        this.f76370f.setViewVisibility(m.l.T, i16);
    }

    public void V9(long j3) {
        if (this.f76370f == null || r.h0() == null) {
            return;
        }
        SessionInfo f16 = n.e().f();
        rw.a M = this.f76370f.M(m.e.f76024k);
        if (M == null) {
            return;
        }
        if (!f16.I2 && !f16.J2 && !f16.f73102y2) {
            M.i(true);
            M.k(false);
            if (!f16.z()) {
                if (f16.f73035i == 2) {
                    M.i(false);
                    M.k(true);
                    return;
                } else {
                    M.n(false);
                    return;
                }
            }
            if (f16.f73035i == 2) {
                M.i(true);
                M.k(false);
            }
            F9(j3);
            return;
        }
        M.i(false);
        M.k(true);
    }

    public void W9(long j3) {
        rw.a x95;
        Resources resources;
        int i3;
        Context context = getContext();
        rw.a x96 = x9(m.e.f76029p, j3);
        if (x96 == null || (x95 = x9(m.e.f76024k, j3)) == null) {
            return;
        }
        if (x95.h() && context != null) {
            SessionInfo f16 = n.e().f();
            int i16 = f16.f73046k2;
            if (i16 != 2 && i16 != 1) {
                if (x96.h()) {
                    QLog.i(this.f76368d, 1, "updateBtn_ShareAudio. audioShareBtnItem visiable[1->0]. sessionInfo.mShareState: " + f16.f73046k2);
                }
                x96.n(false);
                return;
            }
            boolean S9 = S9();
            x96.l(S9 ? R.drawable.n7j : R.drawable.n7k);
            if (!S9) {
                resources = context.getResources();
                i3 = R.string.f1774233x;
            } else {
                resources = context.getResources();
                i3 = R.string.f1774333y;
            }
            x96.m(resources.getString(i3));
            if (!x96.h()) {
                QLog.i(this.f76368d, 1, "updateBtn_ShareAudio. audioShareBtnItem visiable[0->1].");
            }
            x96.n(true);
            x96.i(true);
            return;
        }
        if (x96.h()) {
            QLog.i(this.f76368d, 1, "updateBtn_ShareAudio. audioShareBtnItem visiable[1->0]. screenShareBtnItem.isVisiable: " + x95.h());
        }
        x96.n(false);
    }

    public void X9(long j3) {
        rw.a M = this.f76370f.M(m.e.f76024k);
        if (M == null) {
            return;
        }
        if (com.tencent.av.zplan.e.c(r.h0().Y())) {
            M.i(false);
            M.k(true);
        } else {
            M.i(true);
            M.k(false);
            F9(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class i implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f76339d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f76340e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f76341f;

        i(long j3, View view, ActionSheet actionSheet) {
            this.f76339d = j3;
            this.f76340e = view;
            this.f76341f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                AVScreenSharePart.this.M9(this.f76339d, this.f76340e);
            } else if (i3 == 1) {
                ((ScreenShareManager) nw.b.b().B(18)).n();
                com.tencent.av.screenshare.c.a("0X800B8A2");
            }
            this.f76341f.superDismiss();
        }
    }

    public void N9(long j3, View view) {
        AVActivity aVActivity = (AVActivity) getActivity();
        if (aVActivity == null || aVActivity.isFinishing() || aVActivity.isDestroyed()) {
            return;
        }
        String string = aVActivity.getString(R.string.f224236id);
        String string2 = aVActivity.getString(R.string.f224206ia);
        String string3 = aVActivity.getString(R.string.f224216ib);
        String string4 = aVActivity.getString(R.string.f224226ic);
        String string5 = aVActivity.getString(R.string.f17790358);
        String string6 = aVActivity.getString(R.string.f17786354);
        af.a r16 = af.r(string2, string3, string4);
        SpannableStringBuilder b16 = com.tencent.av.screenshare.a.b(aVActivity, r16.f76972a, r16.f76973b, r16.f76974c);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (!defaultSharedPreferences.contains("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN")) {
            R9((ScreenShareQQCustomDialog) com.tencent.av.screenshare.a.a(aVActivity, string, b16, string6, string5, true, 10, new e(), new f(j3, view)), true);
            defaultSharedPreferences.edit().putBoolean("SCREEN_SHARE_NOTICE_DIALOG_IS_SHOWN", true).apply();
        } else {
            R9((ScreenShareQQCustomDialog) com.tencent.av.screenshare.a.a(aVActivity, string, b16, string6, string5, false, 0, new g(), new h(j3, view)).setMessageWithoutAutoLink(b16), false);
        }
    }

    private void G9(boolean z16, boolean z17, boolean z18) {
        String str;
        int i3 = z17 ? z18 ? 2 : 1 : z18 ? 4 : 3;
        if (z16) {
            str = "1";
        } else {
            str = "2";
        }
        ReportController.o(null, "dc00898", "", "", "0X800BF0B", "0X800BF0B", i3, 0, str, "", "", "");
    }

    /* loaded from: classes32.dex */
    class d implements DialogInterface.OnClickListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }
}
