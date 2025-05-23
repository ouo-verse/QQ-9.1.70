package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes32.dex */
public class EditVideoSave extends u {
    aj C;

    /* renamed from: d, reason: collision with root package name */
    private String f67831d;

    /* renamed from: e, reason: collision with root package name */
    float f67832e;

    /* renamed from: f, reason: collision with root package name */
    boolean f67833f;

    /* renamed from: h, reason: collision with root package name */
    float f67834h;

    /* renamed from: i, reason: collision with root package name */
    private Dialog f67835i;

    /* renamed from: m, reason: collision with root package name */
    int f67836m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends SimpleObserver<fs.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ fs.b f67839a;

        a(fs.b bVar) {
            this.f67839a = bVar;
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(fs.b bVar) {
            int i3;
            int i16;
            super.onNext(bVar);
            EditVideoSave.this.q0(5);
            PublishParam publishParam = this.f67839a.f400396m;
            hd0.c.a("EditVideoSave", "publishParam = " + publishParam);
            if (EditVideoSave.this.mUi.getActivity() != null) {
                Intent intent = EditVideoSave.this.mUi.getActivity().getIntent();
                if (intent != null) {
                    i3 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
                    i16 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
                } else {
                    i3 = 0;
                    i16 = 0;
                }
                Intent E0 = SaveVideoActivity.E0(EditVideoSave.this.mUi.getContext(), publishParam.f69066d, i16, i3, EditVideoSave.this.mParent.C.e());
                EditVideoSave.this.f67831d = publishParam.f69066d;
                E0.putExtra(ShortVideoConstants.SV_MEDIACODEC_ENCODE_ENABLE, true);
                E0.putExtra(ShortVideoConstants.VIDEO_EDIT_FLAG, publishParam.H != 0);
                if (intent != null) {
                    E0.putExtra("qqstory_slide_show_scene", intent.getIntExtra("qqstory_slide_show_scene", -1));
                }
                EditVideoSave editVideoSave = EditVideoSave.this;
                if (editVideoSave.f67836m == 19) {
                    editVideoSave.mUi.getActivity().startActivityForResult(E0, 222);
                } else {
                    editVideoSave.mUi.getActivity().startActivityForResult(E0, 111);
                }
                EditVideoSave editVideoSave2 = EditVideoSave.this;
                editVideoSave2.f67832e = 5.0f;
                editVideoSave2.f67833f = false;
                float f16 = 50000.0f / ((float) publishParam.E);
                editVideoSave2.f67834h = f16;
                if (f16 == 0.0f) {
                    editVideoSave2.f67834h = 1.0f;
                }
                editVideoSave2.p0();
            }
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onCancel() {
            super.onCancel();
            hd0.c.t("EditVideoSave", "saveVideo cancel !");
            EditVideoSave.this.mParent.t(0);
            EditVideoSave.this.m0();
            QQToast.makeText(EditVideoSave.this.mUi.getContext(), HardCodeUtil.qqStr(R.string.m0t), 0).show();
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(Error error) {
            super.onError(error);
            hd0.c.g("EditVideoSave", "saveVideo error \uff1a" + error);
            EditVideoSave.this.mParent.t(0);
            QQToast.makeText(EditVideoSave.this.mUi.getContext(), 1, HardCodeUtil.qqStr(R.string.lyc) + error, 0).show();
            EditVideoSave.this.m0();
        }
    }

    public EditVideoSave(EditVideoPartManager editVideoPartManager) {
        super(editVideoPartManager);
        this.f67834h = 3.0f;
        this.f67836m = -1;
    }

    private aj l0() {
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

    public void m0() {
        Dialog dialog = this.f67835i;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    public void o0(String str, boolean z16, int i3) {
        if (this.f67835i == null) {
            ReportDialog reportDialog = new ReportDialog(getContext());
            this.f67835i = reportDialog;
            Window window = reportDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable());
                window.setDimAmount(0.0f);
            }
            this.f67835i.requestWindowFeature(1);
            this.f67835i.setContentView(R.layout.ba8);
            ImageView imageView = (ImageView) this.f67835i.findViewById(R.id.g1f);
            aj l06 = l0();
            this.C = l06;
            imageView.setImageDrawable(l06);
        }
        ((TextView) this.f67835i.findViewById(R.id.f166327f13)).setText(str);
        this.f67835i.setCancelable(z16);
        this.f67835i.setCanceledOnTouchOutside(z16);
        this.C.i(0);
        getUi().getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.3
            @Override // java.lang.Runnable
            public void run() {
                ss.a.a(EditVideoSave.this.f67835i);
            }
        }, i3);
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onDestroy() {
        m0();
        super.onDestroy();
    }

    void p0() {
        aa aaVar = this.mUi;
        if (aaVar == null) {
            return;
        }
        aaVar.getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.4
            @Override // java.lang.Runnable
            public void run() {
                EditVideoSave editVideoSave = EditVideoSave.this;
                if (editVideoSave.f67833f) {
                    return;
                }
                float f16 = editVideoSave.f67832e;
                if (f16 < 50.0f) {
                    editVideoSave.f67832e = f16 + editVideoSave.f67834h;
                } else {
                    editVideoSave.f67832e = f16 + 1.0f;
                }
                float f17 = editVideoSave.f67832e;
                if (f17 > 99.0f) {
                    editVideoSave.f67832e = 99.0f;
                    editVideoSave.q0((int) 99.0f);
                } else {
                    editVideoSave.q0((int) f17);
                    EditVideoSave.this.p0();
                }
            }
        }, 1000L);
    }

    public void q0(int i3) {
        aj ajVar = this.C;
        if (ajVar == null) {
            return;
        }
        ajVar.t();
        this.C.i(i3);
        this.C.p(true);
        this.C.m(false);
        this.C.q(String.valueOf(i3) + "%");
        if (QLog.isColorLevel()) {
            QLog.w("EditVideoSave", 2, "[setProgress] current:" + this.C.a() + ", progress:" + i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00b3 A[LOOP:0: B:14:0x00ad->B:16:0x00b3, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void n0() {
        int i3;
        int i16;
        Iterator<u> it;
        EditVideoDoodle editVideoDoodle;
        hd0.c.a("EditVideoSave", "saveHWVideo");
        EditVideoParams editVideoParams = this.mParent.C;
        EditVideoParams.EditSource editSource = editVideoParams.f204059i;
        if (editSource instanceof EditLocalVideoSource) {
            i16 = ((EditLocalVideoSource) editSource).f204044e.rotation;
        } else if (editSource instanceof EditTakeVideoSource) {
            i16 = ((EditTakeVideoSource) editSource).f204052e.rotation;
        } else {
            i3 = 0;
            fs.b bVar = new fs.b(editVideoParams);
            bVar.f400387d.videoMaxrate = CodecParam.mMaxrate;
            if (((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) {
                bVar.f400387d.videoMaxrate = ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).getCqMaxBitrate() * 1000;
            }
            bVar.f400399p = fs.s.b(2);
            Activity activity = this.mUi.getActivity();
            int width = editSource.getWidth();
            int height = editSource.getHeight();
            String sourcePath = editSource.getSourcePath();
            float width2 = (editSource.getWidth() * 1.0f) / editSource.getHeight();
            EditVideoSpeedFilter editVideoSpeedFilter = this.mParent.J;
            bVar.f400392i = new fs.i(activity, width, height, sourcePath, width2, editVideoSpeedFilter == null && editVideoSpeedFilter.q0() == 5, i3, 0.0d, 0.0d, "", false);
            it = this.mParent.D.iterator();
            while (it.hasNext()) {
                it.next().editVideoPrePublish(0, bVar);
            }
            hd0.c.t("EditVideoSave", "PUBLISH start ...");
            o0(HardCodeUtil.qqStr(R.string.lxn), false, 0);
            q0(2);
            Stream map = Stream.of(bVar).map(new ThreadOffFunction("EditVideoSave", 2)).map(new fs.f());
            editVideoDoodle = this.mParent.I;
            if (editVideoDoodle != null) {
                map = map.map(editVideoDoodle.q0(0));
            }
            map.map(new fs.m()).map(new fs.t(this.mParent.C)).map(new UIThreadOffFunction(this)).subscribe(new a(bVar));
        }
        i3 = i16;
        fs.b bVar2 = new fs.b(editVideoParams);
        bVar2.f400387d.videoMaxrate = CodecParam.mMaxrate;
        if (((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) {
        }
        bVar2.f400399p = fs.s.b(2);
        Activity activity2 = this.mUi.getActivity();
        int width3 = editSource.getWidth();
        int height2 = editSource.getHeight();
        String sourcePath2 = editSource.getSourcePath();
        float width22 = (editSource.getWidth() * 1.0f) / editSource.getHeight();
        EditVideoSpeedFilter editVideoSpeedFilter2 = this.mParent.J;
        bVar2.f400392i = new fs.i(activity2, width3, height2, sourcePath2, width22, editVideoSpeedFilter2 == null && editVideoSpeedFilter2.q0() == 5, i3, 0.0d, 0.0d, "", false);
        it = this.mParent.D.iterator();
        while (it.hasNext()) {
        }
        hd0.c.t("EditVideoSave", "PUBLISH start ...");
        o0(HardCodeUtil.qqStr(R.string.lxn), false, 0);
        q0(2);
        Stream map2 = Stream.of(bVar2).map(new ThreadOffFunction("EditVideoSave", 2)).map(new fs.f());
        editVideoDoodle = this.mParent.I;
        if (editVideoDoodle != null) {
        }
        map2.map(new fs.m()).map(new fs.t(this.mParent.C)).map(new UIThreadOffFunction(this)).subscribe(new a(bVar2));
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void editVideoStateChanged(int i3, Object obj) {
        if (i3 == 9 || i3 == 19) {
            this.f67836m = i3;
            n0();
        }
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.u
    public void onActivityResult(final int i3, int i16, final Intent intent) {
        StringBuilder sb5;
        String str;
        if (i3 == 111 || i3 == 222) {
            if (intent == null || ((str = this.f67831d) != null && str.equals(intent.getStringExtra("fakeId")))) {
                this.mParent.t(0);
                this.f67833f = true;
                if (i16 == -1) {
                    q0(100);
                    this.mUi.getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoSave.1
                        @Override // java.lang.Runnable
                        public void run() {
                            EditVideoSave.this.m0();
                            if (i3 == 222) {
                                EditVideoSave.this.mParent.y0(intent.getStringExtra("key_video_save_path"));
                            } else {
                                QQToast.makeText(EditVideoSave.this.mUi.getContext(), 2, HardCodeUtil.qqStr(R.string.f171931lz4), 0).show();
                            }
                        }
                    }, 500L);
                    return;
                }
                if (i16 != 1) {
                    if (i16 == 0) {
                        m0();
                        return;
                    }
                    return;
                }
                m0();
                if (i3 == 222) {
                    sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.m2d));
                } else {
                    sb5 = new StringBuilder(HardCodeUtil.qqStr(R.string.lyf));
                }
                if (intent != null && intent.getStringExtra("error") != null) {
                    sb5.append(MsgSummary.STR_COLON);
                    sb5.append(intent.getStringExtra("error"));
                }
                QQToast.makeText(this.mUi.getContext(), 1, sb5, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements aj.b {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressCompleted(aj ajVar) {
            if (QLog.isColorLevel()) {
                QLog.i("EditVideoSave", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + ajVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressChanged(aj ajVar, int i3, int i16) {
        }
    }
}
