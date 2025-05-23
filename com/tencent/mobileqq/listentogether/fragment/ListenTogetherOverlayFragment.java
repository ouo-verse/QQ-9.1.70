package com.tencent.mobileqq.listentogether.fragment;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.guild.util.IGuildFastClickUtilApi;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.lyrics.LyricsController;
import com.tencent.mobileqq.listentogether.ui.BaseListenTogetherPanel;
import com.tencent.mobileqq.listentogether.ui.UiData;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import com.tencent.util.QQToastUtil;
import com.tencent.widget.ActionSheet;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes33.dex */
public class ListenTogetherOverlayFragment extends PublicBaseFragment {
    private QQAppInterface C;
    private BaseActivity D;
    private ActionSheet E;
    QQCustomDialog F;
    private int G = -1;
    private int H = -1;
    private String I = "";
    private UiData J = new UiData();
    BaseListenTogetherPanel.ReportInfo K = new BaseListenTogetherPanel.ReportInfo();
    private boolean L = false;
    private boolean M = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ListenTogetherManager f240922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LyricsController f240923e;

        b(ListenTogetherManager listenTogetherManager, LyricsController lyricsController) {
            this.f240922d = listenTogetherManager;
            this.f240923e = lyricsController;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f240922d.W0(true);
            this.f240923e.T(false);
            if (ListenTogetherOverlayFragment.this.D.isFinishing()) {
                return;
            }
            ListenTogetherOverlayFragment.this.D.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class c implements DialogInterface.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ListenTogetherManager f240925d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LyricsController f240926e;

        c(ListenTogetherManager listenTogetherManager, LyricsController lyricsController) {
            this.f240925d = listenTogetherManager;
            this.f240926e = lyricsController;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            this.f240925d.V0();
            this.f240926e.T(false);
            if (ListenTogetherOverlayFragment.this.D.isFinishing()) {
                return;
            }
            ListenTogetherOverlayFragment.this.D.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class d implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ListenTogetherManager f240928d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ LyricsController f240929e;

        d(ListenTogetherManager listenTogetherManager, LyricsController lyricsController) {
            this.f240928d = listenTogetherManager;
            this.f240929e = lyricsController;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.f240928d.V0();
            this.f240929e.T(false);
            if (!ListenTogetherOverlayFragment.this.D.isFinishing()) {
                ListenTogetherOverlayFragment.this.D.finish();
            }
            ListenTogetherOverlayFragment.this.M = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class e implements DialogInterface.OnClickListener {
        e() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class f implements DialogInterface.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LyricsController f240932d;

        f(LyricsController lyricsController) {
            this.f240932d = lyricsController;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            this.f240932d.T(false);
            this.f240932d.N = false;
            if (!ListenTogetherOverlayFragment.this.D.isFinishing()) {
                ListenTogetherOverlayFragment.this.D.finish();
            }
            LyricsController lyricsController = this.f240932d;
            if (lyricsController.P) {
                lyricsController.s();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class h implements ActionSheet.OnDismissListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LyricsController f240936d;

        h(LyricsController lyricsController) {
            this.f240936d = lyricsController;
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            this.f240936d.T(false);
            if (ListenTogetherOverlayFragment.this.D.isFinishing()) {
                return;
            }
            ListenTogetherOverlayFragment.this.D.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class i implements DialogInterface.OnCancelListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LyricsController f240938d;

        i(LyricsController lyricsController) {
            this.f240938d = lyricsController;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            this.f240938d.T(false);
            if (ListenTogetherOverlayFragment.this.D.isFinishing()) {
                return;
            }
            ListenTogetherOverlayFragment.this.D.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class j implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ LyricsController f240940d;

        j(LyricsController lyricsController) {
            this.f240940d = lyricsController;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            ListenTogetherOverlayFragment.this.E.dismiss();
            this.f240940d.I();
            this.f240940d.T(false);
            if (ListenTogetherOverlayFragment.this.D.isFinishing()) {
                return;
            }
            ListenTogetherOverlayFragment.this.D.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class k implements DialogInterface.OnClickListener {
        k() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (((IQQFloatingPermission) QRoute.api(IQQFloatingPermission.class)).requestPermission(BaseApplication.getContext())) {
                ListenTogetherOverlayFragment.this.L = true;
            } else {
                ListenTogetherOverlayFragment.this.D.finish();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class l implements DialogInterface.OnClickListener {
        l() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            ListenTogetherOverlayFragment.this.D.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class n implements DialogInterface.OnDismissListener {
        n() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (!ListenTogetherOverlayFragment.this.M && !ListenTogetherOverlayFragment.this.D.isFinishing()) {
                ListenTogetherOverlayFragment.this.D.finish();
            }
            ListenTogetherOverlayFragment.this.E = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class o implements DialogInterface.OnDismissListener {
        o() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (!ListenTogetherOverlayFragment.this.M && !ListenTogetherOverlayFragment.this.D.isFinishing()) {
                ListenTogetherOverlayFragment.this.D.finish();
            }
            ListenTogetherOverlayFragment.this.E = null;
        }
    }

    private void Ch() {
        ListenTogetherManager J = ListenTogetherManager.J(this.C);
        ActionSheet create = ActionSheet.create(this.D);
        this.E = create;
        create.addButton(R.string.g3l);
        this.E.addButton(R.string.f1624720i);
        this.E.addButton(R.string.f1625220n);
        this.E.addCancelButton(R.string.cancel);
        this.E.setOnButtonClickListener(new a(J));
    }

    private void Dh() {
        ListenTogetherManager J = ListenTogetherManager.J(this.C);
        ActionSheet create = ActionSheet.create(this.D);
        this.E = create;
        create.addButton(R.string.g3l);
        this.E.addButton(R.string.isu, 3);
        this.E.addButton(R.string.f1624720i);
        this.E.addButton(R.string.f1625220n);
        this.E.addCancelButton(R.string.cancel);
        this.E.setOnButtonClickListener(new p(J));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Eh(View view, int i3) {
        if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("ListenTogetherOverlayFragment") || i3 != 0 || Gh()) {
            return;
        }
        this.E.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Fh(DialogInterface dialogInterface) {
        if (!this.M && !this.D.isFinishing()) {
            this.D.finish();
        }
        this.E = null;
    }

    private boolean Gh() {
        if (!NetworkUtil.isNetworkAvailable(this.D)) {
            BaseActivity baseActivity = this.D;
            QQToast.makeText(baseActivity, 1, baseActivity.getString(R.string.f171155cp4), 0).show();
            return false;
        }
        ListenTogetherManager J = ListenTogetherManager.J(this.C);
        if (J == null) {
            QLog.i("ListenTogetherOverlayFragment", 1, "[onJoinClick] manager is null");
            return false;
        }
        J.E(this.D, this.H, this.I, new g(J));
        QLog.i("ListenTogetherOverlayFragment", 1, "[onJoinClick] activity = " + this.D + ", mUinType = " + this.H + ", uin = " + this.I);
        return true;
    }

    private void Hh() {
        if (this.E == null && !this.M) {
            this.M = false;
            ListenTogetherManager J = ListenTogetherManager.J(this.C);
            ActionSheet create = ActionSheet.create(this.D);
            this.E = create;
            create.addButton(R.string.g3l);
            this.E.addButton(R.string.isu, 3);
            this.E.addCancelButton(R.string.cancel);
            this.E.setOnButtonClickListener(new m(J));
            this.E.setOnDismissListener(new n());
            this.E.show();
        }
    }

    private void Ih(boolean z16) {
        if (this.E == null && !this.M) {
            this.M = false;
            if (z16) {
                Dh();
            } else {
                Ch();
            }
            this.E.setOnDismissListener(new o());
            this.E.show();
        }
    }

    private void Jh() {
        if (this.F != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
        }
        boolean z16 = this.H == 1;
        LyricsController T = ListenTogetherManager.J(this.C).T();
        QQCustomDialog negativeButton = DialogUtil.createCustomDialog(this.D, 230).setMessage(z16 ? R.string.f171068is2 : R.string.f171067is1).setNegativeButton(R.string.ibr, new e());
        this.F = negativeButton;
        negativeButton.setTitle(z16 ? R.string.f171070is4 : R.string.f171069is3);
        this.F.setOnDismissListener(new f(T));
        this.F.setCanceledOnTouchOutside(false);
        this.F.show();
        T.T(true);
    }

    private void Lh() {
        if (this.F != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherOverlayFragment", 2, "showPermissionDialog in");
        }
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.D, 230).setMessage(R.string.f171262dk2).setNegativeButton(R.string.cancel, new l()).setPositiveButton(R.string.dk6, new k());
        this.F = positiveButton;
        positiveButton.setTitle(R.string.f171263dk4);
        this.F.setCancelable(false);
        this.F.setCanceledOnTouchOutside(false);
        this.F.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Mh() {
        if (this.F != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherOverlayFragment", 2, "showExitDialog in");
        }
        ListenTogetherManager J = ListenTogetherManager.J(this.C);
        LyricsController T = J.T();
        QQCustomDialog positiveButton = DialogUtil.createCustomDialog(this.D, 230).setNegativeButton(R.string.cancel, new c(J, T)).setPositiveButton(R.string.ist, new b(J, T));
        this.F = positiveButton;
        positiveButton.setTitle(R.string.f171066is0);
        this.F.setOnDismissListener(new d(J, T));
        this.F.setCanceledOnTouchOutside(false);
        this.F.show();
        T.T(true);
    }

    private void showActionSheet() {
        if (this.E != null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("ListenTogetherOverlayFragment", 2, "showActionSheet in");
        }
        LyricsController T = ListenTogetherManager.J(this.C).T();
        ActionSheet create = ActionSheet.create(this.D);
        this.E = create;
        create.addButton(R.string.irw);
        this.E.addCancelButton(R.string.cancel);
        this.E.setOnDismissListener(new h(T));
        this.E.setOnCancelListener(new i(T));
        this.E.setOnButtonClickListener(new j(T));
        this.E.show();
        T.T(true);
        ReportController.o(this.C, "dc00898", "", "", QQPermissionConstants.Business.SCENE.QQ_VIP, "0X800A5C1", 1, 0, "", "", "", "");
    }

    public void Kh() {
        if (this.E != null || this.M) {
            return;
        }
        ActionSheet create = ActionSheet.create(this.D);
        this.E = create;
        create.addButton(R.string.f1625120m);
        this.E.addCancelButton(R.string.cancel);
        this.E.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.listentogether.fragment.a
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                ListenTogetherOverlayFragment.this.Eh(view, i3);
            }
        });
        this.E.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.listentogether.fragment.b
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                ListenTogetherOverlayFragment.this.Fh(dialogInterface);
            }
        });
        this.E.show();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public void initWindowStyleAndAnimation(Activity activity) {
        super.initWindowStyleAndAnimation(activity);
        try {
            activity.requestWindowFeature(1);
            activity.getWindow().addFlags(1024);
        } catch (Exception e16) {
            QLog.i("ListenTogetherOverlayFragment", 1, "[initWindowStyleAndAnimation] exception = " + e16);
        }
        activity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        return false;
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needStatusTrans() {
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.C = getBaseActivity().app;
        BaseActivity baseActivity = getBaseActivity();
        this.D = baseActivity;
        Intent intent = baseActivity.getIntent();
        if (intent != null) {
            this.G = intent.getIntExtra("type", 0);
            this.H = intent.getIntExtra("uinType", -1);
            if (intent.hasExtra("uin")) {
                this.I = intent.getStringExtra("uin");
            }
            UiData uiData = (UiData) intent.getParcelableExtra("uiData");
            this.J = uiData;
            if (uiData == null) {
                this.J = new UiData();
            }
            Serializable serializableExtra = intent.getSerializableExtra(CacheTable.TABLE_NAME);
            if (serializableExtra instanceof BaseListenTogetherPanel.ReportInfo) {
                this.K = (BaseListenTogetherPanel.ReportInfo) serializableExtra;
            }
            QLog.i("ListenTogetherOverlayFragment", 1, "[onCreate] mType = " + this.G + ", mUinType = " + this.H + ", uin = " + this.I + ", uiData = " + this.J + ", reportInfo = " + this.K);
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherOverlayFragment", 2, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
        }
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public void onFinish() {
        ListenTogetherManager J;
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null && (J = ListenTogetherManager.J(qQAppInterface)) != null) {
            J.x1(false);
        }
        super.onFinish();
        BaseActivity baseActivity = getBaseActivity();
        if (baseActivity == null) {
            return;
        }
        baseActivity.overridePendingTransition(0, 0);
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherOverlayFragment", 2, MiniSDKConst.NOTIFY_EVENT_ONPAUSE);
        }
        super.onPause();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (QLog.isColorLevel()) {
            QLog.d("ListenTogetherOverlayFragment", 2, "onResume mType: " + this.G + " mHasGotoSetting:" + this.L + " mUinType:" + this.H);
        }
        int i3 = this.G;
        if (i3 == 1) {
            showActionSheet();
            return;
        }
        if (i3 == 2) {
            if (this.L) {
                this.D.finish();
                return;
            } else {
                Lh();
                return;
            }
        }
        if (i3 == 3) {
            Hh();
            return;
        }
        if (i3 == 4) {
            Jh();
            return;
        }
        if (i3 == 5) {
            Ih(true);
            return;
        }
        if (i3 == 6) {
            Ih(false);
        } else if (i3 == 7) {
            Kh();
        } else {
            this.D.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class g implements com.tencent.mobileqq.listentogether.j {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ListenTogetherManager f240934a;

        g(ListenTogetherManager listenTogetherManager) {
            this.f240934a = listenTogetherManager;
        }

        @Override // com.tencent.mobileqq.listentogether.j
        public void onCancel() {
            ListenTogetherOverlayFragment.this.E.dismiss();
        }

        @Override // com.tencent.mobileqq.listentogether.j
        public void a() {
            QLog.i("ListenTogetherOverlayFragment", 1, "[onOk] activity = " + ListenTogetherOverlayFragment.this.D + ", mUinType = " + ListenTogetherOverlayFragment.this.H + ", uin = " + ListenTogetherOverlayFragment.this.I);
            this.f240934a.i1(ListenTogetherOverlayFragment.this.D, ListenTogetherOverlayFragment.this.H, ListenTogetherOverlayFragment.this.I, 1000);
            BaseListenTogetherPanel.ReportInfo reportInfo = ListenTogetherOverlayFragment.this.K;
            ReportController.o(null, "dc00899", reportInfo.mainAction, "", "music_tab", "clk_join", 0, 0, reportInfo.reportUin, "", ListenTogetherOverlayFragment.this.K.shenFen + "", "");
            ListenTogetherOverlayFragment.this.E.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bh() {
        int i3;
        ListenTogetherManager J = ListenTogetherManager.J(this.C);
        if (J == null) {
            QLog.w("ListenTogetherOverlayFragment", 1, "[gotoLyrics] id: music_panel, userState: joined. mgr == null");
            return;
        }
        ListenTogetherSession Q = J.Q(this.H, this.I);
        if (Q != null && (i3 = Q.f437191i) != 3) {
            if (i3 == 1 || i3 == 2) {
                ListenTogetherPlayFragment.Hh(this.D, Q, Q.c(), this.J.f241160h, null);
            } else if (i3 == 4) {
                QQToastUtil.showQQToastInUiThread(0, this.D.getString(R.string.f1625620r));
                return;
            }
            BaseListenTogetherPanel.ReportInfo reportInfo = this.K;
            ReportController.o(null, "dc00899", reportInfo.mainAction, "", "music_tab", "clk_detail", 0, 0, reportInfo.reportUin, "", this.K.shenFen + "", "");
            return;
        }
        QQToastUtil.showQQToastInUiThread(0, this.D.getString(R.string.isa));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class m implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ListenTogetherManager f240944d;

        m(ListenTogetherManager listenTogetherManager) {
            this.f240944d = listenTogetherManager;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                this.f240944d.W0(false);
                ListenTogetherOverlayFragment.this.E.dismiss();
            } else {
                if (i3 != 1) {
                    return;
                }
                ListenTogetherOverlayFragment.this.Mh();
                ListenTogetherOverlayFragment.this.E.dismiss();
                ListenTogetherOverlayFragment.this.M = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ListenTogetherManager f240920d;

        a(ListenTogetherManager listenTogetherManager) {
            this.f240920d = listenTogetherManager;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                this.f240920d.W0(false);
                ListenTogetherOverlayFragment.this.E.dismiss();
                return;
            }
            if (i3 != 1) {
                if (i3 != 2) {
                    return;
                }
                ListenTogetherOverlayFragment.this.Bh();
                ListenTogetherOverlayFragment.this.E.dismiss();
                return;
            }
            if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("ListenTogetherOverlayFragment")) {
                return;
            }
            if (ListenTogetherOverlayFragment.this.D != null && !TextUtils.isEmpty(ListenTogetherOverlayFragment.this.I)) {
                d72.b.o(TroopUtils.f(), ListenTogetherOverlayFragment.this.D, ListenTogetherOverlayFragment.this.H, ListenTogetherOverlayFragment.this.I, 1);
            }
            ListenTogetherOverlayFragment.this.E.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class p implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ListenTogetherManager f240948d;

        p(ListenTogetherManager listenTogetherManager) {
            this.f240948d = listenTogetherManager;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                this.f240948d.W0(false);
                ListenTogetherOverlayFragment.this.E.dismiss();
                return;
            }
            if (i3 == 1) {
                ListenTogetherOverlayFragment.this.Mh();
                ListenTogetherOverlayFragment.this.E.dismiss();
                ListenTogetherOverlayFragment.this.M = true;
            } else {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return;
                    }
                    ListenTogetherOverlayFragment.this.Bh();
                    ListenTogetherOverlayFragment.this.E.dismiss();
                    return;
                }
                if (((IGuildFastClickUtilApi) QRoute.api(IGuildFastClickUtilApi.class)).isFastClick("ListenTogetherOverlayFragment")) {
                    return;
                }
                if (ListenTogetherOverlayFragment.this.D != null && !TextUtils.isEmpty(ListenTogetherOverlayFragment.this.I)) {
                    d72.b.o(TroopUtils.f(), ListenTogetherOverlayFragment.this.D, ListenTogetherOverlayFragment.this.H, ListenTogetherOverlayFragment.this.I, 1);
                }
                ListenTogetherOverlayFragment.this.E.dismiss();
            }
        }
    }
}
