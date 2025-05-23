package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart;
import com.tencent.aelight.camera.aioeditor.editipc.a;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.guild.temp.api.IGuildActivityApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.longshot.LongShotNTManager;
import com.tencent.util.AutoSaveUtils;
import com.tencent.widget.ActionSheet;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.peak.PeakConstants;
import cooperation.qqfav.QfavBuilder;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import dov.com.qq.im.ae.current.SessionWrap;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes32.dex */
public class EditPicPartManager extends EditVideoPartManager implements QfavBuilder.b, AIOGalleryUtils.d {

    /* renamed from: t0, reason: collision with root package name */
    private Intent f67690t0;

    private void C1(Observer<fs.b> observer) {
        fs.b bVar = new fs.b(this.C);
        bVar.f400399p = fs.s.b(2);
        bVar.f400395l = new fs.g(this.C.f204059i.getSourcePath());
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        bVar.f400398o = lpReportInfo_pf00064;
        lpReportInfo_pf00064.actionType = 615;
        lpReportInfo_pf00064.subactionType = 8;
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().editVideoPrePublish(0, bVar);
        }
        String m3 = bVar.f400384a.m("extra_text_filter_text");
        if (!TextUtils.isEmpty(m3)) {
            if (TextUtils.isEmpty(bVar.f400387d.videoDoodleDescription)) {
                bVar.f400387d.videoDoodleDescription = m3;
            } else {
                StringBuilder sb5 = new StringBuilder();
                PublishVideoEntry publishVideoEntry = bVar.f400387d;
                sb5.append(publishVideoEntry.videoDoodleDescription);
                sb5.append(m3);
                publishVideoEntry.videoDoodleDescription = sb5.toString();
            }
        }
        bVar.f400387d.putExtra("composite_key_capturemode", Integer.valueOf(K()));
        bVar.f400387d.putExtra("composite_key_entrance", Integer.valueOf(this.C.k()));
        id0.b.f("0X80076EA");
        hd0.c.t("EditPicActivity.EditPicPartManager", "PUBLISH start ...");
        this.f67794m.showLoadingDialog(HardCodeUtil.qqStr(R.string.lwp), false, 500L);
        Stream.of(bVar).map(new ThreadOffFunction("EditPicActivity.EditPicPartManager", 2)).map(new fs.r(this.C.E)).map(new fs.e((d) R(d.class), null)).map(new fs.p(h.f68705a + "qq_pic_merged_" + System.currentTimeMillis() + ".jpg")).map(new fs.n()).map(new fs.t(this.C)).map(new UIThreadOffFunction(this)).subscribe(observer);
    }

    private void D1() {
        String n3 = PlusPanelUtils.n(AppConstants.SDCARD_IMG_CAMERA);
        Activity activity = this.f67794m.getActivity();
        activity.getIntent().putExtra(EditPicActivity.IMAGE_PATH, n3);
        if (QLog.isColorLevel()) {
            QLog.d("EditPicActivity.EditPicPartManager", 2, "reset2Camera begin " + this.f67794m.getActivity() + " new path " + n3);
        }
        PreferenceManager.getDefaultSharedPreferences(this.f67794m.getContext()).edit().putString(EditPicActivity.SP_KEY_NEW_PATH, n3).commit();
        Intent intent = new Intent();
        FileProvider7Helper.setSystemCapture(activity, new File(n3), intent);
        intent.putExtra("android.intent.extra.quickCapture", true);
        try {
            activity.startActivityForResult(intent, 666);
        } catch (Exception e16) {
            e16.printStackTrace();
            try {
                QQToast.makeText(activity, HardCodeUtil.qqStr(R.string.lwv), 0).show();
            } catch (Exception unused) {
                QLog.e("EditPicActivity.EditPicPartManager", 1, "reset2Camera err", e16);
            }
            activity.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E1(Intent intent) {
        Activity activity = this.f67794m.getActivity();
        String stringExtra = intent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
        ActionSheet createFullScreenDialog = ActionSheet.createFullScreenDialog(activity);
        createFullScreenDialog.addButton(R.string.bsj);
        createFullScreenDialog.addButton(R.string.bst);
        createFullScreenDialog.addButton(R.string.bsh);
        createFullScreenDialog.addCancelButton(R.string.cancel);
        createFullScreenDialog.setOnButtonClickListener(new b(createFullScreenDialog, intent, stringExtra, activity));
        createFullScreenDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F1(fs.b bVar) {
        final String sourcePath;
        fs.g gVar = bVar.f400395l;
        if (!gVar.f400422h && gVar.f400421g) {
            sourcePath = gVar.f400416b;
        } else {
            QLog.d("EditPicActivity.EditPicPartManager", 1, "send sourcePath");
            sourcePath = this.C.f204059i.getSourcePath();
        }
        com.tencent.aelight.camera.aioeditor.editipc.a.n(sourcePath, ".jpg", new a.h() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.2
            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onCancel() {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.2.3
                    @Override // java.lang.Runnable
                    public void run() {
                        EditPicPartManager.this.f67794m.dismissLoadingDialog();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onFail() {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.2.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EditPicPartManager.this.f67794m.dismissLoadingDialog();
                        EditPicPartManager.this.L0();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onSuccess(final String str) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Point b16 = com.tencent.aelight.camera.ae.util.a.f65756a.b(EditPicPartManager.this.d0().getContext(), sourcePath);
                        EditPicPartManager editPicPartManager = EditPicPartManager.this;
                        String str2 = str;
                        editPicPartManager.G("image", str2, str2, b16.x, b16.y);
                        EditPicPartManager.this.f67794m.dismissLoadingDialog();
                        EditPicPartManager.this.f67794m.finish(-1, null, R.anim.dialog_exit, 0, true);
                    }
                });
            }

            @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
            public void onProgress(int i3) {
            }
        });
    }

    private void x1() {
        if (this.C.k() == 104) {
            id0.a.n("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
        }
        if (k0()) {
            id0.a.n("video_edit", "pub_local", 0, 0, new String[0]);
        }
    }

    private void y1(long j3) {
        final Activity activity;
        aa aaVar = this.f67794m;
        if (aaVar == null || (activity = aaVar.getActivity()) == null) {
            return;
        }
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager.4
            @Override // java.lang.Runnable
            public void run() {
                activity.finish();
            }
        }, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void z1(EditPicPartManager editPicPartManager) {
        int i3;
        try {
            DoodleLayout V = ((d) editPicPartManager.R(d.class)).V();
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = V.r0();
            if (r06 == null || r06.isEmpty()) {
                return;
            }
            qs.d d16 = V.f68165n0.d();
            int i16 = d16.f429429a;
            int i17 = d16.f429430b;
            int i18 = 5;
            int i19 = -1;
            if (i16 == 0) {
                if (i17 == -16777216) {
                    i18 = 12;
                } else if (i17 == -13338378) {
                    i18 = 6;
                } else if (i17 != -8136876) {
                    i18 = i17 != -2148308 ? i17 != -1009097 ? i17 != -1 ? -1 : 2 : 4 : 3;
                }
                i3 = i18;
            } else if (i16 != 1) {
                if (i16 == 2) {
                    if (i17 == 1) {
                        i19 = 7;
                    } else if (i17 == 2) {
                        i19 = 8;
                    } else if (i17 == 3) {
                        i19 = 9;
                    } else if (i17 == 4) {
                        i19 = 10;
                    } else if (i17 == 5) {
                        i19 = 11;
                    }
                }
                i3 = i19;
            } else {
                i3 = 1;
            }
            ReportController.o(null, "dc00898", "", "", "0X800A7C2", "0X800A7C2", i3, 0, "", "", "", "");
        } catch (Exception unused) {
            hd0.c.t("EditPicActivity.EditPicPartManager", "\u7f16\u8f91\u6d82\u9e26\u4e0a\u62a5\u5931\u8d25");
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void Q0() {
        super.Q0();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void U0(Error error) {
        hd0.c.g("EditPicActivity.EditPicPartManager", "PIC PUBLISH error \uff1a" + error);
        this.f67794m.dismissLoadingDialog();
        QQToast.makeText(this.f67794m.getContext(), HardCodeUtil.qqStr(R.string.lws) + error, 0).show();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public int W() {
        return R.layout.do_;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    protected SimpleObserver<fs.b> X() {
        return new a();
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void b1() {
        x1();
        C1(X());
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    protected void g0() {
        aa aaVar = this.f67794m;
        if (aaVar == null) {
            QLog.e("EditPicActivity.EditPicPartManager", 1, "giveUpEditVideo error, mUi is null!");
            return;
        }
        int intExtra = aaVar.getActivity().getIntent().getIntExtra("camera_type", -1);
        if (intExtra != -1) {
            if (QLog.isColorLevel()) {
                QLog.d("EditPicActivity.EditPicPartManager", 2, "giveUpEditVideo, is from camera" + intExtra + " clear photo " + this.C.f204059i.getSourcePath());
            }
            File file = new File(this.C.f204059i.getSourcePath());
            if (com.tencent.aelight.camera.ae.util.c.f(this.f67794m.getContext(), file)) {
                file.delete();
            }
            BaseImageUtil.savePhotoToSysAlbum(this.f67794m.getContext(), this.C.f204059i.getSourcePath());
            Intent intent = new Intent();
            intent.putExtra(PeakConstants.PHOTO_EDIT_RE_CAMERA, true);
            intent.putExtra("camera_type", intExtra);
            if (intExtra == 103) {
                this.f67794m.finish(0, intent, R.anim.dialog_exit, 0);
                return;
            } else {
                D1();
                return;
            }
        }
        this.f67794m.finish(0, null, R.anim.dialog_exit, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void j0(EditVideoParams editVideoParams) {
        ArrayList arrayList = new ArrayList();
        if (15 == this.C.f204055d) {
            EditARCakeButton editARCakeButton = new EditARCakeButton(this);
            this.F = editARCakeButton;
            arrayList.add(editARCakeButton);
        } else {
            r rVar = new r(this, editVideoParams.f204057f);
            this.E = rVar;
            arrayList.add(rVar);
            EditProviderPart editProviderPart = new EditProviderPart(this);
            this.H = editProviderPart;
            arrayList.add(editProviderPart);
            EditVideoDoodle editVideoDoodle = new EditVideoDoodle(this, editVideoParams.f204057f);
            this.I = editVideoDoodle;
            arrayList.add(editVideoDoodle);
            i iVar = new i(this);
            this.M = iVar;
            arrayList.add(iVar);
        }
        EditPicRawImage editPicRawImage = new EditPicRawImage(this, editVideoParams.f204057f);
        this.L = editPicRawImage;
        arrayList.add(editPicRawImage);
        if (EditVideoPartManager.v(editVideoParams.f204057f, 512)) {
            EditPicSave editPicSave = new EditPicSave(this);
            this.P = editPicSave;
            arrayList.add(editPicSave);
        }
        if (EditVideoPartManager.v(editVideoParams.f204057f, 4096)) {
            EditVideoLimitRegion editVideoLimitRegion = new EditVideoLimitRegion(this);
            this.W = editVideoLimitRegion;
            arrayList.add(editVideoLimitRegion);
        }
        if (EditVideoPartManager.v(editVideoParams.f204057f, 2048)) {
            EditJumpToPtu editJumpToPtu = new EditJumpToPtu(this);
            this.X = editJumpToPtu;
            arrayList.add(editJumpToPtu);
        }
        if (EditPicMeiHua.l0(editVideoParams.f204057f)) {
            arrayList.add(new EditPicMeiHua(this));
        }
        if (2 == this.C.f204055d) {
            DocEnhancePart docEnhancePart = new DocEnhancePart(this);
            this.S = docEnhancePart;
            arrayList.add(docEnhancePart);
        }
        this.D = arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public boolean j1() {
        boolean j16 = super.j1();
        if (j16) {
            if ((this.f67794m.getActivity() == null || this.f67794m.getActivity().getIntent() == null || !this.f67794m.getActivity().getIntent().getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false)) ? false : true) {
                return false;
            }
        }
        return j16;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager
    public void s0(int i3, int i16, Intent intent) {
        super.s0(i3, i16, intent);
        if (i3 == 1000) {
            this.f67789i = intent;
        }
        if (i3 == 18001) {
            if (i16 == -1) {
                LongShotNTManager.INSTANCE.a().x(this.f67794m.getActivity(), intent);
                this.f67794m.finish(-1, this.f67690t0, R.anim.dialog_exit, 0, false);
                this.f67690t0 = null;
                return;
            }
            return;
        }
        if (i3 == 18002 && i16 == -1) {
            this.f67794m.finish(-1, this.f67690t0, R.anim.dialog_exit, 0, false);
            this.f67690t0 = null;
        }
    }

    public void B1(fs.b bVar) {
        ((com.tencent.aelight.camera.aioeditor.capture.data.d) fr.f.c(5)).p(this.f67794m.getActivity());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends SimpleObserver<fs.b> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditPicPartManager$a$a, reason: collision with other inner class name */
        /* loaded from: classes32.dex */
        public class C0590a implements com.tencent.qqnt.aio.adapter.api.c {
            C0590a() {
            }

            @Override // com.tencent.qqnt.aio.adapter.api.c
            public void a() {
                EditPicPartManager editPicPartManager = EditPicPartManager.this;
                editPicPartManager.f67794m.finish(-1, editPicPartManager.f67690t0, R.anim.dialog_exit, 0, false);
                EditPicPartManager.this.f67690t0 = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes32.dex */
        public class b implements com.tencent.qqnt.aio.adapter.api.c {
            b() {
            }

            @Override // com.tencent.qqnt.aio.adapter.api.c
            public void a() {
                EditPicPartManager editPicPartManager = EditPicPartManager.this;
                editPicPartManager.f67794m.finish(-1, editPicPartManager.f67690t0, R.anim.dialog_exit, 0, false);
                EditPicPartManager.this.f67690t0 = null;
            }
        }

        a() {
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onCancel() {
            super.onCancel();
            hd0.c.t("EditPicActivity.EditPicPartManager", "PIC PUBLISH cancel !");
            EditPicPartManager.this.f67794m.dismissLoadingDialog();
            QQToast.makeText(EditPicPartManager.this.f67794m.getContext(), HardCodeUtil.qqStr(R.string.lwt), 0).show();
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(Error error) {
            super.onError(error);
            EditPicPartManager.this.U0(error);
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(fs.b bVar) {
            super.onNext(bVar);
            if (EditPicPartManager.this.j1()) {
                EditPicPartManager.this.F1(bVar);
                return;
            }
            EditPicPartManager.this.f67794m.dismissLoadingDialog();
            Activity activity = EditPicPartManager.this.f67794m.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            hd0.c.a("EditPicActivity.EditPicPartManager", "picDestPath = " + bVar.f400395l.f400416b);
            Intent publishIntent = EditPicPartManager.this.f67794m.getPublishIntent(bVar);
            boolean z16 = bVar.f400395l.f400422h;
            if (!z16) {
                publishIntent.putExtra(AEEditorConstants.EXTRA_IS_EDITED_PIC, !z16);
            }
            EditPicPartManager.this.B1(bVar);
            hd0.c.a("EditPicActivity.EditPicPartManager", "subBussinessId = " + EditPicPartManager.this.C.o());
            EditVideoParams editVideoParams = EditPicPartManager.this.C;
            if (editVideoParams.f204055d == 2) {
                int o16 = editVideoParams.o();
                if (o16 == 106) {
                    AutoSaveUtils.a(true, bVar.f400395l.f400416b);
                } else if (o16 != 107 && o16 != 110) {
                    if (bVar.b()) {
                        AutoSaveUtils.a(true, bVar.f400395l.f400416b);
                    }
                } else if (bVar.b()) {
                    AutoSaveUtils.b(bVar.f400395l.f400416b, true);
                }
            }
            EditPicPartManager.z1(EditPicPartManager.this);
            String stringExtra = publishIntent.getStringExtra("PhotoConst.PLUGIN_APK");
            boolean booleanExtra = publishIntent.getBooleanExtra(PeakConstants.DIRECT_BACK_TO_QZONE, false);
            if ("qzone_plugin.apk".equals(stringExtra) && booleanExtra) {
                EditPicPartManager.this.f67794m.finish(-1, publishIntent, R.anim.dialog_exit, 0);
                return;
            }
            EditVideoParams editVideoParams2 = EditPicPartManager.this.C;
            if (editVideoParams2.f204055d == 2 && (editVideoParams2.k() == 122 || EditPicPartManager.this.C.k() == 133)) {
                String stringExtra2 = publishIntent.getStringExtra("PhotoConst.SINGLE_PHOTO_PATH");
                EditPicPartManager.this.f67690t0 = publishIntent;
                if (EditPicPartManager.this.C.c("extra_complete_preview_share", false)) {
                    LongShotNTManager.INSTANCE.a().L(activity, null, stringExtra2, new C0590a());
                    return;
                } else {
                    LongShotNTManager.INSTANCE.a().I(activity, stringExtra2, new b());
                    return;
                }
            }
            EditVideoParams editVideoParams3 = EditPicPartManager.this.C;
            if (editVideoParams3.f204055d == 2 && editVideoParams3.k() == 125) {
                EditPicPartManager.this.f67794m.finish(-1, publishIntent, R.anim.dialog_exit, 0, false);
                ReportController.o(null, "dc00898", "", "", "0X800A188", "0X800A188", 0, 0, "", "", "", "");
                return;
            }
            EditVideoParams editVideoParams4 = EditPicPartManager.this.C;
            if (editVideoParams4.f204055d == 2 && EditVideoParams.u(editVideoParams4.k())) {
                EditPicPartManager.this.E1(publishIntent);
                ReportController.o(null, "dc00898", "", "", "0X800A183", "0X800A183", 0, 0, "", "", "", "");
                return;
            }
            EditVideoParams editVideoParams5 = EditPicPartManager.this.C;
            if (editVideoParams5.f204055d == 2 && editVideoParams5.t()) {
                publishIntent.putExtra(PeakConstants.SEND_PICTURE_ORIGIN, !bVar.b());
                publishIntent.putExtra(PeakConstants.SEND_PICTURE_EDIT_PLAY_PARAMS, bVar.f400401r);
                EditPicPartManager.this.f67794m.finish(-1, publishIntent, R.anim.dialog_exit, 0, false);
            } else if (publishIntent.getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false)) {
                EditPicPartManager.this.f67794m.finish(-1, publishIntent, R.anim.dialog_exit, 0, false);
            } else {
                EditPicPartManager editPicPartManager = EditPicPartManager.this;
                editPicPartManager.A1(activity, editPicPartManager.C.e(), publishIntent);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f67701d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Intent f67702e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f67703f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ Activity f67704h;

        b(ActionSheet actionSheet, Intent intent, String str, Activity activity) {
            this.f67701d = actionSheet;
            this.f67702e = intent;
            this.f67703f = str;
            this.f67704h = activity;
        }

        /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
        
            if (r18.f67702e.getBooleanExtra(com.tencent.aelight.camera.constants.AEEditorConstants.EXTRA_IS_EDITED_PIC, false) == false) goto L22;
         */
        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onClick(View view, int i3) {
            if (view == null) {
                this.f67701d.dismiss();
                return;
            }
            String content = this.f67701d.getContent(i3);
            if (content == null) {
                this.f67701d.dismiss();
                return;
            }
            if (TextUtils.isEmpty(content)) {
                this.f67701d.dismiss();
                return;
            }
            if (content.equals(view.getResources().getString(R.string.bsj))) {
                int i16 = EditPicPartManager.this.C.k() == 130 ? 0 : 1;
                this.f67702e.putExtra("forward_type", i16);
                this.f67702e.putExtra(AppConstants.Key.FORWARD_FILEPATH, this.f67703f);
                ForwardBaseOption.startForwardActivityForResult(this.f67704h, this.f67702e, 19003);
                ReportController.o(null, "dc00898", "", "", "0X800A184", "0X800A184", 0, 0, "", "", "", "");
            } else if (content.equals(view.getResources().getString(R.string.bst))) {
                File file = new File(this.f67703f);
                AIOGalleryUtils.p((Activity) view.getContext(), file, Utils.Crc64String(file.getAbsolutePath()), EditPicPartManager.this);
                ReportController.o(null, "dc00898", "", "", "0X800A185", "0X800A185", 0, 0, "", "", "", "");
            } else if (content.equals(view.getResources().getString(R.string.bsh))) {
                QfavBuilder.e0(this.f67703f).i(this.f67704h, BaseApplicationImpl.getApplication().getRuntime().getAccount(), R.string.cvt, EditPicPartManager.this);
                ReportController.o(null, "dc00898", "", "", "0X800A186", "0X800A186", 0, 0, "", "", "", "");
            }
            this.f67701d.dismiss();
        }
    }

    @Override // cooperation.qqfav.QfavBuilder.b
    public void a(boolean z16) {
        if (z16) {
            y1(1000L);
        }
    }

    @Override // com.tencent.mobileqq.richmediabrowser.utils.AIOGalleryUtils.d
    public void onSavePhotoResult(boolean z16) {
        if (z16) {
            y1(1000L);
        }
    }

    void A1(Activity activity, int i3, Intent intent) {
        if (i3 == 6) {
            intent.setFlags(536870912);
            intent.removeExtra(EditVideoParams.class.getName());
            activity.startActivityForResult(intent, 1001);
            return;
        }
        if (i3 == 8) {
            QQToast.makeText(activity, "\u62b1\u6b49\uff0c\u56fe\u6587\u53d1\u8868\u529f\u80fd\u5df2\u4e0b\u67b6", 1).show();
            activity.finish();
            return;
        }
        if (i3 == 103) {
            intent.addFlags(603979776);
            intent.putExtra("qq_sub_business_id", 103);
            activity.startActivity(intent);
            activity.setResult(-1);
            activity.finish();
            return;
        }
        if (i3 != 106 && i3 != 109) {
            activity.startActivity(intent);
            this.f67794m.finish(-1, null, R.anim.dialog_exit, 0, true);
            return;
        }
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1050);
        if (!((this.f67794m.getActivity() == null || this.f67794m.getActivity().getIntent() == null || !this.f67794m.getActivity().getIntent().getBooleanExtra(PeakConstants.IS_INPULT_FULL_SCREEN_MODE, false)) ? false : true)) {
            SessionWrap sessionWrap = (SessionWrap) intent.getParcelableExtra(AECameraConstants.ARG_SESSION_INFO);
            if (sessionWrap != null && sessionWrap.f394449f == 10014 && intent.getBooleanExtra("isSplitViewMode", false)) {
                ((IGuildActivityApi) QRoute.api(IGuildActivityApi.class)).launchGuildChatPieInSplitMode(activity, intent);
            } else {
                activity.startActivity(intent);
            }
            this.f67794m.finish(-1, null, R.anim.dialog_exit, 0, true);
            return;
        }
        this.f67794m.finish(-1, intent, R.anim.dialog_exit, 0, true);
    }
}
