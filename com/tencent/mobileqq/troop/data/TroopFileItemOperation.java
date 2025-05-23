package com.tencent.mobileqq.troop.data;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.SpannableString;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.api.IQFileConfigManager;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.managers.CUOpenCardGuideMng;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.utils.TroopFileManager;
import com.tencent.mobileqq.troop.utils.TroopFileTransferManager;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import java.util.UUID;

/* compiled from: P */
/* loaded from: classes19.dex */
public class TroopFileItemOperation {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public Activity f294842a;

    /* renamed from: b, reason: collision with root package name */
    public long f294843b;

    /* renamed from: c, reason: collision with root package name */
    public QQAppInterface f294844c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.troop.data.TroopFileItemOperation$9, reason: invalid class name */
    /* loaded from: classes19.dex */
    class AnonymousClass9 implements ThreadExcutor.IThreadListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopFileTransferManager f294849d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f294850e;

        AnonymousClass9(TroopFileTransferManager troopFileTransferManager, n nVar) {
            this.f294849d = troopFileTransferManager;
            this.f294850e = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileItemOperation.this, troopFileTransferManager, nVar);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onAdded() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPostRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.troop.data.TroopFileItemOperation.9.1
                    static IPatchRedirector $redirector_;

                    /* compiled from: P */
                    /* renamed from: com.tencent.mobileqq.troop.data.TroopFileItemOperation$9$1$a */
                    /* loaded from: classes19.dex */
                    class a implements DialogInterface.OnClickListener {
                        static IPatchRedirector $redirector_;

                        a() {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this);
                            }
                        }

                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i3) {
                            IPatchRedirector iPatchRedirector = $redirector_;
                            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                            } else if (i3 == 1 && TroopFileItemOperation.this.k() != 0) {
                                TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
                                TroopFileTransferManager.O(troopFileItemOperation.f294844c, troopFileItemOperation.f294843b).g0(AnonymousClass9.this.f294850e.f294915a);
                            }
                        }
                    }

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass9.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        AnonymousClass9 anonymousClass9 = AnonymousClass9.this;
                        TroopFileTransferManager.Item J = anonymousClass9.f294849d.J(anonymousClass9.f294850e.f294915a);
                        if (J == null || J.ErrorCode != -136) {
                            int l3 = TroopFileItemOperation.this.l(false);
                            a aVar = new a();
                            String s16 = l3 == 1 ? TroopFileItemOperation.s(R.string.emh, TroopFileUtils.p(AnonymousClass9.this.f294850e.f294917c), AnonymousClass9.this.f294850e.e()) : TroopFileItemOperation.s(R.string.etz, TroopFileUtils.p(AnonymousClass9.this.f294850e.f294917c));
                            TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
                            DialogUtil.createCustomDialog(troopFileItemOperation.p(troopFileItemOperation.f294842a), 230, TroopFileItemOperation.t(R.string.f171413eu1), s16, R.string.cancel, R.string.f171412eu0, aVar, aVar).show();
                            return;
                        }
                        AnonymousClass9 anonymousClass92 = AnonymousClass9.this;
                        TroopFileItemOperation troopFileItemOperation2 = TroopFileItemOperation.this;
                        troopFileItemOperation2.B(anonymousClass92.f294850e, troopFileItemOperation2.f294842a.getString(R.string.evo), TroopFileItemOperation.this.f294842a.getString(R.string.evp));
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
        public void onPreRun() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class a implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f294854d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Bundle f294855e;

        a(n nVar, Bundle bundle) {
            this.f294854d = nVar;
            this.f294855e = bundle;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileItemOperation.this, nVar, bundle);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 1 && TroopFileItemOperation.this.k() != 0) {
                TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
                TroopFileTransferManager.O(troopFileItemOperation.f294844c, troopFileItemOperation.f294843b).f0(this.f294854d.f294915a, this.f294855e);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class b implements ActionSheet.OnButtonClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f294857d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ n f294858e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f294859f;

        b(boolean z16, n nVar, ActionSheet actionSheet) {
            this.f294857d = z16;
            this.f294858e = nVar;
            this.f294859f = actionSheet;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileItemOperation.this, Boolean.valueOf(z16), nVar, actionSheet);
            }
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, i3);
                return;
            }
            if (!this.f294857d) {
                i3++;
            }
            if (i3 != 0) {
                if (i3 == 1 && TroopFileItemOperation.this.k() != 0) {
                    TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
                    TroopFileManager.F(troopFileItemOperation.f294844c, troopFileItemOperation.f294843b).t(this.f294858e);
                    ReportController.o(TroopFileItemOperation.this.f294844c, "CliOper", "", "", "Grp", "Clk_delete_share", 0, 0, "", TroopFileItemOperation.this.f294843b + "", "", "");
                }
            } else {
                TroopFileItemOperation troopFileItemOperation2 = TroopFileItemOperation.this;
                TroopFileTransferManager.O(troopFileItemOperation2.f294844c, troopFileItemOperation2.f294843b).p(this.f294858e.f294915a);
                ReportController.o(TroopFileItemOperation.this.f294844c, "CliOper", "", "", "Grp", "Clk_delete_local", 0, 0, "", TroopFileItemOperation.this.f294843b + "", "", "");
            }
            this.f294859f.dismiss();
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class c implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f294861d;

        c(n nVar) {
            this.f294861d = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileItemOperation.this, (Object) nVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
            TroopFileManager.F(troopFileItemOperation.f294844c, troopFileItemOperation.f294843b).t(this.f294861d);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class d implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f294863d;

        d(n nVar) {
            this.f294863d = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileItemOperation.this, (Object) nVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
            TroopFileManager.F(troopFileItemOperation.f294844c, troopFileItemOperation.f294843b).L(this.f294863d);
            dialogInterface.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class e implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopFileTransferManager f294865d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UUID f294866e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ j f294867f;

        e(TroopFileTransferManager troopFileTransferManager, UUID uuid, j jVar) {
            this.f294865d = troopFileTransferManager;
            this.f294866e = uuid;
            this.f294867f = jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileItemOperation.this, troopFileTransferManager, uuid, jVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                this.f294865d.g0(this.f294866e);
                j jVar = this.f294867f;
                if (jVar != null) {
                    jVar.onResult(0);
                    return;
                }
                return;
            }
            j jVar2 = this.f294867f;
            if (jVar2 != null) {
                jVar2.onResult(-1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class f implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f294869d;

        f(FileManagerEntity fileManagerEntity) {
            this.f294869d = fileManagerEntity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileItemOperation.this, (Object) fileManagerEntity);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
            } else if (i3 == 1) {
                TroopFileItemOperation.this.o(this.f294869d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class g implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ TroopFileTransferManager f294871d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ UUID f294872e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Bundle f294873f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ j f294874h;

        g(TroopFileTransferManager troopFileTransferManager, UUID uuid, Bundle bundle, j jVar) {
            this.f294871d = troopFileTransferManager;
            this.f294872e = uuid;
            this.f294873f = bundle;
            this.f294874h = jVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, TroopFileItemOperation.this, troopFileTransferManager, uuid, bundle, jVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            int i16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                boolean f06 = this.f294871d.f0(this.f294872e, this.f294873f);
                j jVar = this.f294874h;
                if (jVar != null) {
                    if (f06) {
                        i16 = 0;
                    } else {
                        i16 = -2;
                    }
                    jVar.onResult(i16);
                    return;
                }
                return;
            }
            j jVar2 = this.f294874h;
            if (jVar2 != null) {
                jVar2.onResult(-1);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class h implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f294876d;

        h(n nVar) {
            this.f294876d = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileItemOperation.this, (Object) nVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                if (TroopFileItemOperation.this.k() != 0) {
                    TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
                    TroopFileManager.F(troopFileItemOperation.f294844c, troopFileItemOperation.f294843b).t(this.f294876d);
                }
                ReportController.o(TroopFileItemOperation.this.f294844c, "CliOper", "", "", "Grp", "Cancel_pause_upload", 0, 0, "", TroopFileItemOperation.this.f294843b + "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    class i implements DialogInterface.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ n f294878d;

        i(n nVar) {
            this.f294878d = nVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopFileItemOperation.this, (Object) nVar);
            }
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) dialogInterface, i3);
                return;
            }
            if (i3 == 1) {
                TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
                TroopFileTransferManager.O(troopFileItemOperation.f294844c, troopFileItemOperation.f294843b).p(this.f294878d.f294915a);
                TroopFileItemOperation troopFileItemOperation2 = TroopFileItemOperation.this;
                n nVar = TroopFileManager.F(troopFileItemOperation2.f294844c, troopFileItemOperation2.f294843b).f301893e.get(this.f294878d.f294929o);
                if (nVar != null) {
                    nVar.D.remove(this.f294878d.f294916b);
                }
                ReportController.o(TroopFileItemOperation.this.f294844c, "CliOper", "", "", "Grp", "Cancel_pause_download", 0, 0, "", TroopFileItemOperation.this.f294843b + "", "", "");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface j {
        void onResult(int i3);
    }

    public TroopFileItemOperation(long j3, QQAppInterface qQAppInterface, Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), qQAppInterface, activity);
            return;
        }
        this.f294843b = j3;
        this.f294844c = qQAppInterface;
        this.f294842a = activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public void v(final String str, final String str2, final long j3, final int i3, final Bundle bundle, final j jVar, final TroopFileTransferManager troopFileTransferManager) {
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.data.p
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i16) {
                TroopFileItemOperation.u(TroopFileTransferManager.this, str, str2, j3, i3, bundle, jVar, dialogInterface, i16);
            }
        };
        String s16 = s(R.string.emd, TroopFileUtils.p(str2), TroopFileUtils.j(j3));
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(p(this.f294842a), 230, t(R.string.erp), s16, R.string.cancel, R.string.ekq, onClickListener, onClickListener);
        CharSequence c16 = CUOpenCardGuideMng.c(this.f294842a, this.f294844c, 2, s16);
        if (c16 instanceof SpannableString) {
            createCustomDialog.setMessageWithoutAutoLink(c16);
        }
        createCustomDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int k() {
        return l(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int l(boolean z16) {
        if (z16) {
            return TroopFileUtils.d(this.f294844c, this.f294842a, this.f294843b);
        }
        return TroopFileUtils.c(this.f294842a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(FileManagerEntity fileManagerEntity) {
        TroopFileTransferManager.O(this.f294844c, this.f294843b).y0(fileManagerEntity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Activity p(Activity activity) {
        if (activity instanceof BasePluginActivity) {
            return ((BasePluginActivity) activity).getOutActivity();
        }
        return activity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String s(int i3, Object... objArr) {
        return String.format(t(i3), objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String t(int i3) {
        return BaseApplication.getContext().getResources().getString(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void u(TroopFileTransferManager troopFileTransferManager, String str, String str2, long j3, int i3, Bundle bundle, j jVar, DialogInterface dialogInterface, int i16) {
        if (i16 == 1) {
            if (troopFileTransferManager.x0(str, str2, j3, i3, bundle) == null && jVar != null) {
                jVar.onResult(-2);
                return;
            }
            return;
        }
        if (jVar != null) {
            jVar.onResult(-1);
        }
    }

    public void B(n nVar, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, nVar, str, str2);
            return;
        }
        QQCustomDialog createCustomDialogUrl = DialogUtil.createCustomDialogUrl(p(this.f294842a), 230);
        createCustomDialogUrl.setTitle(str).setMessage(str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) createCustomDialogUrl.getMessageTextView().getLayoutParams();
        layoutParams.gravity = 17;
        createCustomDialogUrl.getMessageTextView().setLayoutParams(layoutParams);
        createCustomDialogUrl.setPositiveButton(this.f294842a.getResources().getString(R.string.f171151ok), new d(nVar));
        createCustomDialogUrl.show();
    }

    public void C(final String str, final String str2, final long j3, final int i3, final Bundle bundle, final j jVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, str2, Long.valueOf(j3), Integer.valueOf(i3), bundle, jVar);
            return;
        }
        int k3 = k();
        QLog.i("TroopFileItemOperation", 1, "startDownload filePath:" + str + ", fileSize:" + j3 + ", busId:" + i3 + ", nettype:" + k3);
        if (k3 == 0) {
            if (jVar != null) {
                jVar.onResult(-2);
                return;
            }
            return;
        }
        final TroopFileTransferManager O = TroopFileTransferManager.O(this.f294844c, this.f294843b);
        com.tencent.mobileqq.filemanager.data.c fileAutoDownloadConfig = ((IQFileConfigManager) this.f294844c.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(str2));
        if (FileManagerUtil.is2GOr3G() && j3 > fileAutoDownloadConfig.f207738b) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.data.o
                @Override // java.lang.Runnable
                public final void run() {
                    TroopFileItemOperation.this.v(str, str2, j3, i3, bundle, jVar, O);
                }
            });
            return;
        }
        t x06 = O.x0(str, str2, j3, i3, bundle);
        if (jVar != null) {
            if (x06 == null) {
                jVar.onResult(-2);
            } else {
                jVar.onResult(0);
            }
        }
    }

    public void D(FileManagerEntity fileManagerEntity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) fileManagerEntity);
            return;
        }
        int k3 = k();
        if (k3 == 0) {
            return;
        }
        if (k3 == 1 && fileManagerEntity.fileSize > 3145728) {
            f fVar = new f(fileManagerEntity);
            String s16 = s(R.string.emc, TroopFileUtils.p(fileManagerEntity.fileName), TroopFileUtils.j(fileManagerEntity.fileSize));
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(p(this.f294842a), 230, t(R.string.erp), s16, R.string.cancel, R.string.hkj, fVar, fVar);
            CharSequence c16 = CUOpenCardGuideMng.c(this.f294842a, this.f294844c, 2, s16);
            if (c16 instanceof SpannableString) {
                createCustomDialog.setMessageWithoutAutoLink(c16);
            }
            createCustomDialog.show();
            return;
        }
        o(fileManagerEntity);
    }

    public void E(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) nVar);
            return;
        }
        if (k() != 0) {
            TroopFileManager.F(this.f294844c, this.f294843b).S(nVar);
            ReportController.o(this.f294844c, "CliOper", "", "", "Grp", "Clk_trans_save", 0, 0, "", this.f294843b + "", "", "");
        }
    }

    public void i(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) nVar);
        } else {
            i iVar = new i(nVar);
            DialogUtil.createCustomDialog(p(this.f294842a), 230, t(R.string.ejl), t(R.string.ejk), R.string.cancel, R.string.f171151ok, iVar, iVar).show();
        }
    }

    public void j(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) nVar);
        } else {
            h hVar = new h(nVar);
            DialogUtil.createCustomDialog(p(this.f294842a), 230, t(R.string.ejp), t(R.string.ejo), R.string.cancel, R.string.f171151ok, hVar, hVar).show();
        }
    }

    public void m(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) nVar);
            return;
        }
        String string = this.f294842a.getString(R.string.ekx);
        String format = String.format(this.f294842a.getString(R.string.ekn), TroopFileUtils.p(nVar.f294917c));
        QQCustomDialog createCustomDialogUrl = DialogUtil.createCustomDialogUrl(p(this.f294842a), 230);
        createCustomDialogUrl.setTitle(string).setMessage(format);
        createCustomDialogUrl.setPositiveButton(this.f294842a.getString(R.string.f171151ok), new c(nVar));
        createCustomDialogUrl.show();
    }

    public void n(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) nVar);
            return;
        }
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(p(this.f294842a), null);
        String[] stringArray = this.f294842a.getResources().getStringArray(R.array.f155246bv);
        boolean z16 = false;
        if (nVar.f294930p == 11 && com.tencent.mobileqq.filemanager.util.q.f(nVar.f294934t)) {
            actionSheet.addButton(stringArray[0], 1);
            z16 = true;
        }
        if (TroopFileUtils.a(this.f294844c, this.f294843b) || this.f294844c.getCurrentAccountUin().equals(nVar.i())) {
            actionSheet.addButton(stringArray[1], 1);
        }
        actionSheet.setOnButtonClickListener(new b(z16, nVar, actionSheet));
        actionSheet.addCancelButton(R.string.cancel);
        try {
            actionSheet.show();
        } catch (Exception e16) {
            QLog.e("TroopFileItemOperation", 1, "sheet show exception", e16);
        }
    }

    public int q(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Integer) iPatchRedirector.redirect((short) 13, (Object) this, (Object) nVar)).intValue();
        }
        return !"/".equals(nVar.f294929o) ? 1 : 0;
    }

    public t r(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (t) iPatchRedirector.redirect((short) 12, (Object) this, (Object) nVar);
        }
        t H = TroopFileTransferManager.O(this.f294844c, this.f294843b).H(nVar.f294916b);
        if (H == null) {
            H = TroopFileUtils.k(this.f294844c, this.f294843b, nVar.f294915a.toString(), nVar.f294916b, nVar.f294917c, nVar.f294918d, nVar.f294919e);
            H.f294980n = nVar.f294938x;
            H.f294981o = nVar.f294939y;
            H.f294979m = nVar.f294937w;
        }
        if (H.f294976j == 0) {
            H.f294976j = nVar.f294918d;
        }
        H.f294968b = nVar.f294916b;
        return H;
    }

    public void w(UUID uuid, Bundle bundle, j jVar) {
        String t16;
        long j3;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, uuid, bundle, jVar);
            return;
        }
        int k3 = k();
        int i3 = -2;
        if (k3 == 0) {
            if (jVar != null) {
                jVar.onResult(-2);
                return;
            }
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f294844c, this.f294843b);
        if (k3 == 1) {
            t I = O.I(uuid);
            if (I != null) {
                j3 = I.f294976j;
                t16 = s(R.string.emf, TroopFileUtils.p(I.f294987u), TroopFileUtils.j(I.f294976j));
                str = I.f294987u;
            } else {
                t16 = t(R.string.eme);
                j3 = 0;
                str = "";
            }
            if (j3 > ((IQFileConfigManager) this.f294844c.getRuntimeService(IQFileConfigManager.class, "")).getFileAutoDownloadConfig(com.tencent.mobileqq.troop.utils.d.a(str)).f207738b) {
                g gVar = new g(O, uuid, bundle, jVar);
                Activity p16 = p(this.f294842a);
                if (!p16.isDestroyed() && !p16.isFinishing()) {
                    p16.runOnUiThread(new Runnable(p16, t16, gVar) { // from class: com.tencent.mobileqq.troop.data.TroopFileItemOperation.5
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ Activity f294845d;

                        /* renamed from: e, reason: collision with root package name */
                        final /* synthetic */ String f294846e;

                        /* renamed from: f, reason: collision with root package name */
                        final /* synthetic */ DialogInterface.OnClickListener f294847f;

                        {
                            this.f294845d = p16;
                            this.f294846e = t16;
                            this.f294847f = gVar;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, this, TroopFileItemOperation.this, p16, t16, gVar);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            Activity activity = this.f294845d;
                            String t17 = TroopFileItemOperation.t(R.string.erp);
                            String str2 = this.f294846e;
                            DialogInterface.OnClickListener onClickListener = this.f294847f;
                            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(activity, 230, t17, str2, R.string.cancel, R.string.etw, onClickListener, onClickListener);
                            TroopFileItemOperation troopFileItemOperation = TroopFileItemOperation.this;
                            CharSequence c16 = CUOpenCardGuideMng.c(troopFileItemOperation.f294842a, troopFileItemOperation.f294844c, 2, this.f294846e);
                            if (c16 instanceof SpannableString) {
                                createCustomDialog.setMessageWithoutAutoLink(c16);
                            }
                            createCustomDialog.show();
                        }
                    });
                    return;
                }
                return;
            }
            boolean f06 = O.f0(uuid, bundle);
            if (jVar != null) {
                if (f06) {
                    i3 = 0;
                }
                jVar.onResult(i3);
                return;
            }
            return;
        }
        boolean f07 = O.f0(uuid, bundle);
        if (jVar != null) {
            if (f07) {
                i3 = 0;
            }
            jVar.onResult(i3);
        }
    }

    public void x(n nVar, Bundle bundle) {
        String s16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) nVar, (Object) bundle);
            return;
        }
        int l3 = l(false);
        a aVar = new a(nVar, bundle);
        if (l3 == 1) {
            s16 = s(R.string.emf, TroopFileUtils.p(nVar.f294917c), nVar.e());
        } else {
            s16 = s(R.string.ety, TroopFileUtils.p(nVar.f294917c));
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(p(this.f294842a), 230, t(R.string.etx), s16, R.string.cancel, R.string.etw, aVar, aVar);
        if (l3 == 1) {
            CharSequence c16 = CUOpenCardGuideMng.c(this.f294842a, this.f294844c, 2, s16);
            if (c16 instanceof SpannableString) {
                createCustomDialog.setMessageWithoutAutoLink(c16);
            }
        }
        createCustomDialog.show();
    }

    public void y(n nVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) nVar);
        } else {
            TroopFileTransferManager O = TroopFileTransferManager.O(this.f294844c, this.f294843b);
            ThreadManagerV2.post(new Runnable(O) { // from class: com.tencent.mobileqq.troop.data.TroopFileItemOperation.8
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TroopFileTransferManager f294848d;

                {
                    this.f294848d = O;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopFileItemOperation.this, (Object) O);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        this.f294848d.U();
                    }
                }
            }, 8, new AnonymousClass9(O, nVar), false);
        }
    }

    public void z(UUID uuid, j jVar) {
        String t16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) uuid, (Object) jVar);
            return;
        }
        if (k() == 0) {
            if (jVar != null) {
                jVar.onResult(-2);
                return;
            }
            return;
        }
        TroopFileTransferManager O = TroopFileTransferManager.O(this.f294844c, this.f294843b);
        if (FileManagerUtil.is2GOr3G()) {
            e eVar = new e(O, uuid, jVar);
            t I = O.I(uuid);
            if (I != null) {
                t16 = s(R.string.emh, TroopFileUtils.p(I.f294987u), TroopFileUtils.j(I.f294976j));
            } else {
                t16 = t(R.string.emg);
            }
            DialogUtil.createCustomDialog(p(this.f294842a), 230, t(R.string.erp), t16, R.string.cancel, R.string.f171412eu0, eVar, eVar).show();
            return;
        }
        O.g0(uuid);
        if (jVar != null) {
            jVar.onResult(0);
        }
    }
}
