package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.editipc.a;
import com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelManager;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadExcutor;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniConst;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.Iterator;

/* loaded from: classes32.dex */
public class EditPicSave extends u {
    private boolean C;
    private boolean D;
    private int E;
    private com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e F;
    ThreadExcutor.IThreadListener G;

    /* renamed from: d, reason: collision with root package name */
    int f67714d;

    /* renamed from: e, reason: collision with root package name */
    boolean f67715e;

    /* renamed from: f, reason: collision with root package name */
    int f67716f;

    /* renamed from: h, reason: collision with root package name */
    protected Dialog f67717h;

    /* renamed from: i, reason: collision with root package name */
    aj f67718i;

    /* renamed from: m, reason: collision with root package name */
    private String f67719m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends SimpleObserver<fs.b> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str) {
            EditPicSave editPicSave = EditPicSave.this;
            IMiniAppService iMiniAppService = (IMiniAppService) QRoute.api(IMiniAppService.class);
            EditPicSave editPicSave2 = EditPicSave.this;
            editPicSave.f67719m = iMiniAppService.getTmpPathFromOut(str, editPicSave2.w0(editPicSave2.mUi.getContext()));
            FileUtils.copyFile(new File(str), new File(EditPicSave.this.f67719m));
            EditPicSave.this.D = true;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(boolean z16, String str) {
            EditPicSave.this.G.onPreRun();
            hd0.c.a("EditPicSave", "insertMedia suc:" + z16 + ", path:" + str);
            if (z16) {
                EditPicSave.this.f67719m = str;
                EditPicSave.this.D = true;
            }
            EditPicSave.this.G.onPostRun();
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onNext(fs.b bVar) {
            super.onNext(bVar);
            EditPicSave.this.E0(40);
            final String str = bVar.f400395l.f400416b;
            hd0.c.a("EditPicSave", "picPath = " + str);
            if (EditPicSave.this.mUi.getActivity() != null) {
                try {
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("EditPicSave", 2, "savePic " + e16.toString());
                    }
                }
                if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(EditPicSave.this.mUi.getActivity().getIntent()) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(EditPicSave.this.mUi.getActivity().getIntent())) {
                    EditPicSave.this.f67719m = PlusPanelUtils.m();
                    ss.h.f434426a.j(EditPicSave.this.mUi.getActivity(), new File(str), EditPicSave.this.f67719m, new ss.e() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.m
                        @Override // ss.e
                        public final void onResult(boolean z16, String str2) {
                            EditPicSave.a.this.d(z16, str2);
                        }
                    });
                    EditPicSave editPicSave = EditPicSave.this;
                    editPicSave.f67714d = 40;
                    editPicSave.f67715e = false;
                    editPicSave.f67716f = 10;
                    editPicSave.D0();
                }
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.l
                    @Override // java.lang.Runnable
                    public final void run() {
                        EditPicSave.a.this.c(str);
                    }
                }, 64, EditPicSave.this.G, true);
                EditPicSave editPicSave2 = EditPicSave.this;
                editPicSave2.f67714d = 40;
                editPicSave2.f67715e = false;
                editPicSave2.f67716f = 10;
                editPicSave2.D0();
            }
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onCancel() {
            super.onCancel();
            hd0.c.t("EditPicSave", "saveVideo cancel !");
            if (!EditPicSave.this.C) {
                if (EditPicSave.this.mParent.C.e() == 14) {
                    EditPicSave.this.mParent.f67784f = false;
                }
                EditPicSave.this.mParent.t(0);
            }
            EditPicSave.this.v0();
            QQToast.makeText(EditPicSave.this.mUi.getContext(), HardCodeUtil.qqStr(R.string.lwz), 0).show();
            EditPicSave.this.x0();
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(Error error) {
            super.onError(error);
            hd0.c.g("EditPicSave", "saveVideo error \uff1a" + error);
            if (!EditPicSave.this.C) {
                if (EditPicSave.this.mParent.C.e() == 14) {
                    EditPicSave.this.mParent.f67784f = false;
                }
                EditPicSave.this.mParent.t(0);
            }
            QQToast.makeText(EditPicSave.this.mUi.getContext(), 1, HardCodeUtil.qqStr(R.string.f171926lx1) + error, 0).show();
            EditPicSave.this.v0();
            EditPicSave.this.y0(error.getMessage());
        }
    }

    public EditPicSave(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.f67716f = 20;
        this.C = false;
        this.D = true;
        this.E = 0;
        this.G = new ThreadExcutor.IThreadListener() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.1
            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPostRun() {
                aa aaVar = EditPicSave.this.mUi;
                if (aaVar == null || aaVar.getActivity() == null) {
                    return;
                }
                EditPicSave.this.mUi.getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // java.lang.Runnable
                    public void run() {
                        if (EditPicSave.this.C) {
                            return;
                        }
                        byte b16 = EditPicSave.this.E == 20;
                        com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e eVar = EditPicSave.this.F;
                        EditPicSave.this.mParent.t(0);
                        EditPicSave editPicSave = EditPicSave.this;
                        editPicSave.f67715e = true;
                        editPicSave.E0(100);
                        EditPicSave.this.v0();
                        if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(EditPicSave.this.mUi.getActivity().getIntent()) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(EditPicSave.this.mUi.getActivity().getIntent())) {
                            int e16 = EditPicSave.this.mParent.C.e();
                            int i3 = R.string.lwy;
                            if (e16 != 14) {
                                if (EditPicSave.this.D) {
                                    i3 = R.string.f171925lx0;
                                }
                                QQToast.makeText(EditPicSave.this.mUi.getContext(), EditPicSave.this.D ? 2 : 1, i3, 0).show();
                                EditPicSave.this.z0();
                                return;
                            }
                            Intent intent = EditPicSave.this.mUi.getActivity().getIntent();
                            if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare(intent)) {
                                return;
                            }
                            EditVideoPartManager editVideoPartManager2 = EditPicSave.this.mParent;
                            editVideoPartManager2.f67784f = false;
                            editVideoPartManager2.t(0);
                            if (EditPicSave.this.D) {
                                boolean z16 = intent.getIntExtra("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2;
                                if (b16 == false) {
                                    if (EditPicSave.this.B0()) {
                                        ms.a.f("EditPicSave", "arkViewId is not empty, doUploadAndForwardVideoArkMsg");
                                        EditPicSave editPicSave2 = EditPicSave.this;
                                        editPicSave2.F0(editPicSave2.f67719m);
                                        return;
                                    }
                                    ab.c(EditPicSave.this.mUi.getActivity(), EditPicSave.this.f67719m, z16, 2);
                                    return;
                                }
                                SendPanelManager.k().u(intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM));
                                String stringExtra = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
                                ms.a.f("EditPicSave", "onPostRun---takeSameName=" + stringExtra);
                                SendPanelManager.k().w(stringExtra);
                                SendPanelManager.k().A(eVar.f68834a, eVar.f68837d, EditPicSave.this.f67719m, "", false);
                                return;
                            }
                            QQToast.makeText(EditPicSave.this.mUi.getContext(), 1, HardCodeUtil.qqStr(R.string.lwy), 0).show();
                            EditPicSave.this.y0(null);
                            return;
                        }
                        Intent intent2 = new Intent();
                        intent2.setAction(MiniConst.LaunchCameraPluginConst.BROADCAST_ACTION_CAMERA_BACK_RESULT);
                        intent2.putExtra("file_path", EditPicSave.this.f67719m);
                        intent2.putExtra("is_video", false);
                        EditPicSave.this.mUi.getActivity().sendBroadcast(intent2);
                        EditPicSave.this.mUi.getActivity().setResult(-1, EditPicSave.this.mUi.getActivity().getIntent());
                        EditPicSave.this.mUi.getActivity().finish();
                    }
                }, 500L);
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onPreRun() {
                EditPicSave.this.D = false;
            }

            @Override // com.tencent.mobileqq.app.ThreadExcutor.IThreadListener
            public void onAdded() {
            }
        };
    }

    private void A0() {
        fs.b bVar = new fs.b(this.mParent.C);
        bVar.f400399p = fs.s.b(2);
        bVar.f400395l = new fs.g(this.mParent.C.f204059i.getSourcePath());
        Iterator<u> it = this.mParent.D.iterator();
        while (it.hasNext()) {
            it.next().editVideoPrePublish(0, bVar);
        }
        hd0.c.t("EditPicSave", "PUBLISH start ...");
        C0(HardCodeUtil.qqStr(R.string.f171927lx3), false, 0);
        E0(20);
        Stream.of(bVar).map(new fs.e((d) getEditExport(d.class), null)).map(new ThreadOffFunction("EditPicSave", 2)).map(new fs.p(h.f68705a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg", true, null)).map(new UIThreadOffFunction(this)).subscribe(new a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean B0() {
        if (this.mParent.C.l("VIDEO_STORY_JUMP_TO_TYPE", 0) == 2) {
            return false;
        }
        return this.mParent.i1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0(final String str) {
        com.tencent.aelight.camera.aioeditor.editipc.a.n(str, ".jpg", new a.h() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.2
            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onCancel() {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EditPicSave.this.mUi.dismissLoadingDialog();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onFail() {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EditPicSave.this.mUi.dismissLoadingDialog();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onSuccess(final String str2) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Point b16 = com.tencent.aelight.camera.ae.util.a.f65756a.b(EditPicSave.this.getContext(), str);
                        EditVideoPartManager editVideoPartManager = EditPicSave.this.mParent;
                        String str3 = str2;
                        editVideoPartManager.F("image", str3, str3, b16.x, b16.y);
                        EditPicSave.this.mUi.dismissLoadingDialog();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onProgress(int i3) {
            }
        });
    }

    private aj u0() {
        aj ajVar = new aj(getContext());
        ajVar.h(BaseAIOUtils.f(50.0f, getResources()));
        ajVar.f(true);
        ajVar.o(false);
        ajVar.r(-1);
        ajVar.e(0);
        ajVar.j(-15550475);
        ajVar.l(3);
        ajVar.E = true;
        ajVar.A = 2;
        ajVar.n(true);
        ajVar.g(new b());
        return ajVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String w0(Context context) {
        if (context == null) {
            return "";
        }
        return context.getSharedPreferences(MiniConst.LaunchCameraPluginConst.MINI_LAUNCH_TAG, 0).getString(MiniConst.LaunchCameraPluginConst.MINI_LAUNCH_AE_APP_ID, "");
    }

    public void C0(String str, boolean z16, int i3) {
        if (this.C) {
            return;
        }
        if (this.f67717h == null) {
            Dialog t06 = t0();
            this.f67717h = t06;
            ImageView imageView = (ImageView) t06.findViewById(R.id.g1f);
            aj u06 = u0();
            this.f67718i = u06;
            imageView.setImageDrawable(u06);
        }
        ((TextView) this.f67717h.findViewById(R.id.f166327f13)).setText(str);
        this.f67717h.setCancelable(z16);
        this.f67717h.setCanceledOnTouchOutside(z16);
        this.f67718i.i(0);
        getUi().getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.4
            @Override // java.lang.Runnable
            public void run() {
                aa aaVar = EditPicSave.this.mUi;
                Activity activity = aaVar == null ? null : aaVar.getActivity();
                if (activity == null || activity.isFinishing() || activity.isDestroyed()) {
                    return;
                }
                ss.a.a(EditPicSave.this.f67717h);
            }
        }, i3);
    }

    void D0() {
        if (this.C) {
            return;
        }
        this.mUi.getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicSave.5
            @Override // java.lang.Runnable
            public void run() {
                EditPicSave editPicSave = EditPicSave.this;
                if (editPicSave.f67715e) {
                    return;
                }
                int i3 = editPicSave.f67714d + editPicSave.f67716f;
                editPicSave.f67714d = i3;
                if (i3 > 99) {
                    editPicSave.f67714d = 99;
                    editPicSave.E0(99);
                } else {
                    editPicSave.E0(i3);
                    EditPicSave.this.D0();
                }
            }
        }, 1000L);
    }

    public void E0(int i3) {
        aj ajVar;
        if (this.C || (ajVar = this.f67718i) == null) {
            return;
        }
        ajVar.t();
        this.f67718i.i(i3);
        if (QLog.isColorLevel()) {
            QLog.w("EditPicSave", 2, "[setProgress] current:" + this.f67718i.a() + ", progress:" + i3);
        }
        this.f67718i.p(true);
        this.f67718i.m(false);
        this.f67718i.q(String.valueOf(i3) + "%");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Dialog t0() {
        ReportDialog reportDialog = new ReportDialog(getContext());
        Window window = reportDialog.getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable());
            window.setDimAmount(0.0f);
        }
        reportDialog.requestWindowFeature(1);
        reportDialog.setContentView(R.layout.ba8);
        return reportDialog;
    }

    public void v0() {
        Dialog dialog = this.f67717h;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        this.C = true;
        v0();
        super.onDestroy();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 == 0) {
            this.E = i3;
            this.F = null;
        } else if (i3 == 9) {
            id0.b.h("0X80080E1", id0.b.f407534c);
            A0();
        } else {
            if (i3 != 20) {
                return;
            }
            this.E = i3;
            if (obj instanceof com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e) {
                this.F = (com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.e) obj;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void y0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x0() {
    }

    protected void z0() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements aj.b {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressCompleted(aj ajVar) {
            if (QLog.isColorLevel()) {
                QLog.i("EditPicSave", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + ajVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressChanged(aj ajVar, int i3, int i16) {
        }
    }
}
