package com.tencent.aelight.camera.aioeditor.takevideo;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.data.AEMaterialArkInfo;
import com.tencent.aelight.camera.ae.util.g;
import com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart;
import com.tencent.aelight.camera.aioeditor.activity.richmedia.SaveVideoActivity;
import com.tencent.aelight.camera.aioeditor.docenhance.DocEnhancePart;
import com.tencent.aelight.camera.aioeditor.editipc.a;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.sendpanel.SendPanelPart;
import com.tencent.aelight.camera.aioeditor.takevideo.u;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraEntryManager;
import com.tencent.aelight.camera.report.api.IAEBaseDataReporter;
import com.tencent.aelight.camera.struct.editor.PublishParam;
import com.tencent.aelight.camera.util.api.IMediaCodecDPC;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.network.pb.qqstory_struct$VideoReaderConf;
import com.tencent.biz.qqstory.network.pb.qqstory_struct$VideoSpreadGroupList;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.maxvideo.MaxVideoConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.editor.composite.CodecParam;
import com.tencent.mobileqq.editor.database.PublishVideoEntry;
import com.tencent.mobileqq.editor.params.EditLocalPhotoSource;
import com.tencent.mobileqq.editor.params.EditLocalVideoSource;
import com.tencent.mobileqq.editor.params.EditTakePhotoSource;
import com.tencent.mobileqq.editor.params.EditTakeVideoSource;
import com.tencent.mobileqq.editor.params.EditVideoParams;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.tribe.data.TribeVideoPublishParams;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.aj;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LiuHaiUtils;
import com.tribe.async.async.Bosses;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.reactive.Observer;
import com.tribe.async.reactive.SimpleObserver;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.StreamFunction;
import com.tribe.async.reactive.UIThreadOffFunction;
import cooperation.peak.PeakConstants;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.app.AppActivity;
import org.json.JSONException;
import org.json.JSONObject;
import org.light.utils.GsonUtils;

/* loaded from: classes32.dex */
public class EditVideoPartManager implements IEventReceiver {

    /* renamed from: s0, reason: collision with root package name */
    public static mr.a f67776s0;
    public EditVideoParams C;
    protected r E;
    protected EditARCakeButton F;
    protected EditVideoStoryButton G;
    public EditProviderPart H;
    public EditVideoDoodle I;
    protected EditVideoSpeedFilter J;
    protected com.tencent.aelight.camera.aioeditor.capture.music.c K;
    public EditPicRawImage L;
    protected i M;
    protected EditVideoSave N;
    protected EditPicSave P;
    protected z Q;
    protected SendPanelPart R;
    protected DocEnhancePart S;
    public ViewGroup T;
    public RelativeLayout U;
    protected EditVideoLimitRegion W;
    protected EditJumpToPtu X;
    public Bundle Y;

    /* renamed from: a0, reason: collision with root package name */
    private int f67777a0;

    /* renamed from: c0, reason: collision with root package name */
    private VideoStoryDataBean f67779c0;

    /* renamed from: d0, reason: collision with root package name */
    protected String f67781d0;

    /* renamed from: e0, reason: collision with root package name */
    protected String f67783e0;

    /* renamed from: f0, reason: collision with root package name */
    protected float f67785f0;

    /* renamed from: g0, reason: collision with root package name */
    protected AEMaterialArkInfo f67786g0;

    /* renamed from: h0, reason: collision with root package name */
    private String f67788h0;

    /* renamed from: i, reason: collision with root package name */
    public Intent f67789i;

    /* renamed from: i0, reason: collision with root package name */
    private float f67790i0;

    /* renamed from: j0, reason: collision with root package name */
    private boolean f67791j0;

    /* renamed from: l0, reason: collision with root package name */
    private Dialog f67793l0;

    /* renamed from: m, reason: collision with root package name */
    public aa f67794m;

    /* renamed from: m0, reason: collision with root package name */
    private aj f67795m0;

    /* renamed from: n0, reason: collision with root package name */
    private QQCustomDialog f67796n0;

    /* renamed from: o0, reason: collision with root package name */
    private QQCustomDialog f67797o0;

    /* renamed from: r0, reason: collision with root package name */
    protected HWEditLocalVideoPlayer f67800r0;

    /* renamed from: d, reason: collision with root package name */
    protected int f67780d = -1;

    /* renamed from: e, reason: collision with root package name */
    protected boolean f67782e = false;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f67784f = false;

    /* renamed from: h, reason: collision with root package name */
    protected boolean f67787h = false;
    protected List<u> D = Collections.emptyList();
    public boolean V = true;
    protected Map<Class<? extends u.a>, u.a> Z = new HashMap();

    /* renamed from: b0, reason: collision with root package name */
    public int f67778b0 = 0;

    /* renamed from: k0, reason: collision with root package name */
    private float f67792k0 = 3.0f;

    /* renamed from: p0, reason: collision with root package name */
    protected final AtomicInteger f67798p0 = new AtomicInteger(1);

    /* renamed from: q0, reason: collision with root package name */
    protected List<Error> f67799q0 = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager$10, reason: invalid class name */
    /* loaded from: classes32.dex */
    public class AnonymousClass10 implements a.h {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f67801a;

        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager$10$1, reason: invalid class name */
        /* loaded from: classes32.dex */
        class AnonymousClass1 implements g.a {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ String f67803a;

            AnonymousClass1(String str) {
                this.f67803a = str;
            }

            @Override // com.tencent.aelight.camera.ae.util.g.a
            public void onFail() {
                ms.a.c("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---generate gif onFail:");
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        EditVideoPartManager.this.E();
                        EditVideoPartManager.this.L0();
                    }
                });
            }

            @Override // com.tencent.aelight.camera.ae.util.g.a
            public void onSuccess(String str) {
                ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---generate gif onSuccess, gifPath=" + str);
                com.tencent.aelight.camera.aioeditor.editipc.a.n(str, QzoneEmotionUtils.SIGN_ICON_URL_END, new a.h() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.1.1
                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onCancel() {
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.1.1.3
                            @Override // java.lang.Runnable
                            public void run() {
                                EditVideoPartManager.this.E();
                            }
                        });
                    }

                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onFail() {
                        ms.a.c("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---upload gif fail");
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.1.1.2
                            @Override // java.lang.Runnable
                            public void run() {
                                EditVideoPartManager.this.E();
                                EditVideoPartManager.this.L0();
                            }
                        });
                    }

                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onSuccess(final String str2) {
                        ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---upload gif onSuccess, gifPath=" + str2);
                        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Point c16 = com.tencent.aelight.camera.ae.util.a.f65756a.c(AnonymousClass10.this.f67801a);
                                AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                EditVideoPartManager.this.G("video", anonymousClass1.f67803a, str2, c16.x, c16.y);
                                EditVideoPartManager.this.r1(100);
                                EditVideoPartManager.this.E();
                                EditVideoPartManager.this.f67794m.finish(-1, null, R.anim.dialog_exit, 0, true);
                            }
                        });
                    }

                    @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
                    public void onProgress(int i3) {
                    }
                });
            }
        }

        AnonymousClass10(String str) {
            this.f67801a = str;
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onCancel() {
            ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onCancel:");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.3
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoPartManager.this.E();
                }
            });
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onFail() {
            ms.a.c("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onFail:");
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.2
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoPartManager.this.E();
                    EditVideoPartManager.this.L0();
                }
            });
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onProgress(final int i3) {
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.10.4
                @Override // java.lang.Runnable
                public void run() {
                    EditVideoPartManager.this.r1(i3);
                }
            });
        }

        @Override // com.tencent.aelight.camera.aioeditor.editipc.a.h
        public void onSuccess(String str) {
            ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "uploadArkVideo---onSuccess: videoDownLoadUrl=" + str);
            com.tencent.aelight.camera.ae.util.g.f65767a.b(this.f67801a, EditVideoPartManager.this.f67785f0, 1000L, new AnonymousClass1(str));
        }
    }

    /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager$11, reason: invalid class name */
    /* loaded from: classes32.dex */
    class AnonymousClass11 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f67815d;
        final /* synthetic */ EditVideoPartManager this$0;

        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager$11$a */
        /* loaded from: classes32.dex */
        class a implements DialogInterface.OnClickListener {
            a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "PermissionDialog--onClick which=" + i3);
                Activity activity = AnonymousClass11.this.this$0.f67794m.getActivity();
                if (i3 == 1) {
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", activity.getPackageName(), null));
                    activity.startActivity(intent);
                }
                dialogInterface.dismiss();
            }
        }

        /* renamed from: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager$11$b */
        /* loaded from: classes32.dex */
        class b implements DialogInterface.OnCancelListener {
            b() {
            }

            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "PermissionDialog--onCancel");
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            a aVar = new a();
            DialogUtil.showPermissionSettingDialog(this.this$0.f67794m.getActivity(), null, this.f67815d, aVar, aVar, new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class a extends QQPermission.BasePermissionsListener {
        a() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            EditVideoPartManager.this.J0();
        }
    }

    /* loaded from: classes32.dex */
    class b extends SimpleJob<Object> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f67820d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f67821e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f67822f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ String[] f67823h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(String str, String str2, int i3, int i16, String[] strArr) {
            super(str);
            this.f67820d = str2;
            this.f67821e = i3;
            this.f67822f = i16;
            this.f67823h = strArr;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object doInBackground(JobContext jobContext, Void... voidArr) {
            id0.a.n("video_edit", this.f67820d, this.f67821e, this.f67822f, this.f67823h);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c extends SimpleJob<Object> {
        c(String str) {
            super(str);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tribe.async.async.Job
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Object doInBackground(JobContext jobContext, Void... voidArr) {
            id0.b.i("0X80076BC");
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d extends SimpleObserver<fs.b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f67826a;

        d(long j3) {
            this.f67826a = j3;
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onNext(fs.b bVar) {
            int i3;
            int i16;
            super.onNext(bVar);
            EditVideoPartManager.this.z();
            EditVideoPartManager.this.f67784f = false;
            hd0.c.g("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH onNext");
            Iterator<u> it = EditVideoPartManager.this.D.iterator();
            while (it.hasNext()) {
                it.next().editVideoPostPublish(bVar);
            }
            id0.a.k("publish_story", "publish_saveToEntry", 0, 0, "", String.valueOf(SystemClock.uptimeMillis() - this.f67826a));
            if (EditVideoPartManager.this.f67798p0.decrementAndGet() > 0) {
                hd0.c.t("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
                return;
            }
            EditVideoPartManager editVideoPartManager = EditVideoPartManager.this;
            editVideoPartManager.f67784f = false;
            editVideoPartManager.f67794m.dismissLoadingDialog();
            if (EditVideoPartManager.this.f67799q0.isEmpty()) {
                if (EditVideoPartManager.this.f67794m.getActivity() != null) {
                    if (EditVideoPartManager.this.C.e() == 14) {
                        hd0.c.a("Q.qqstory.publish.edit.EditVideoPartManager", "Q.videostory.publish.upload[peak process]  sendBroadcast notify publish start(to read info from db)");
                        Intent intent = EditVideoPartManager.this.f67794m.getActivity().getIntent();
                        if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryDefaultShare(intent) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromCheckEntry(intent) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(intent) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isQzoneTailEntry(intent)) {
                            EditVideoPartManager.this.f67794m.getContext().sendBroadcast(new Intent("action_fire_create_video_story"));
                        } else {
                            EditVideoStoryButton editVideoStoryButton = EditVideoPartManager.this.G;
                            if (editVideoStoryButton != null) {
                                editVideoStoryButton.B0(HardCodeUtil.qqStr(R.string.lyq), false, 0);
                                EditVideoPartManager.this.G.D0(2);
                                EditVideoPartManager.this.G.D0(5);
                                PublishParam publishParam = bVar.f400396m;
                                hd0.c.a("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + publishParam);
                                if (EditVideoPartManager.this.f67794m.getActivity() != null) {
                                    Intent intent2 = EditVideoPartManager.this.f67794m.getActivity().getIntent();
                                    if (intent2 != null) {
                                        i3 = intent2.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
                                        i16 = intent2.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
                                    } else {
                                        i3 = 0;
                                        i16 = 0;
                                    }
                                    Intent E0 = SaveVideoActivity.E0(EditVideoPartManager.this.f67794m.getContext(), publishParam.f69066d, i16, i3, EditVideoPartManager.this.C.e());
                                    EditVideoPartManager.this.G.z0(publishParam.f69066d);
                                    int intExtra = intent.getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, js.a.f410904d.b());
                                    E0.putExtra(ShortVideoConstants.SV_MEDIACODEC_ENCODE_ENABLE, true);
                                    E0.putExtra(ShortVideoConstants.VIDEO_EDIT_FLAG, publishParam.H != 0);
                                    E0.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, publishParam.f69067e);
                                    E0.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, intExtra);
                                    if (intent2 != null) {
                                        E0.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, intent2.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM));
                                        String stringExtra = intent2.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
                                        ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + stringExtra);
                                        E0.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra);
                                        E0.putExtra("qqstory_slide_show_scene", intent2.getIntExtra("qqstory_slide_show_scene", -1));
                                    }
                                    if (!js.a.f410915o.d(intExtra) && !js.a.f410914n.d(intExtra)) {
                                        EditVideoPartManager.this.f67794m.getActivity().startActivityForResult(E0, 211);
                                    } else {
                                        EditVideoPartManager.this.f67794m.getActivity().startActivityForResult(E0, 21);
                                    }
                                    EditVideoPartManager.this.G.s0(5, publishParam.E);
                                    return;
                                }
                            }
                        }
                    } else if (EditVideoPartManager.this.C.e() == 2 && EditVideoPartManager.this.j1()) {
                        ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "in AIO sending video ark msg process");
                        EditVideoPartManager.this.n0(bVar);
                        return;
                    }
                    PublishParam publishParam2 = bVar.f400396m;
                    hd0.c.a("Q.qqstory.publish.edit.EditVideoPartManager", "publishParam = " + publishParam2);
                    Intent publishIntent = EditVideoPartManager.this.f67794m.getPublishIntent(bVar);
                    EditVideoPartManager editVideoPartManager2 = EditVideoPartManager.this;
                    editVideoPartManager2.h1(publishIntent, editVideoPartManager2.C.e(), publishParam2, bVar.f400402s);
                    return;
                }
                return;
            }
            Iterator<Error> it5 = EditVideoPartManager.this.f67799q0.iterator();
            while (it5.hasNext()) {
                hd0.c.h("Q.qqstory.publish.edit.EditVideoPartManager", "publish error %s", it5.next());
            }
            QQToast.makeText(EditVideoPartManager.this.f67794m.getContext(), EditVideoPartManager.this.f67799q0.size() + HardCodeUtil.qqStr(R.string.m1v), 0).show();
            x xVar = (x) EditVideoPartManager.this.R(x.class);
            if (xVar != null) {
                xVar.play();
            }
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onCancel() {
            super.onCancel();
        }

        @Override // com.tribe.async.reactive.SimpleObserver, com.tribe.async.reactive.Observer
        public void onError(Error error) {
            super.onError(error);
            id0.a.k("publish_story", "publish_saveToEntry", 0, -1, error.getMessage() + "", String.valueOf(SystemClock.uptimeMillis() - this.f67826a));
            EditVideoPartManager.this.U0(error);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class f implements DialogInterface.OnClickListener {
        f() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditVideoPartManager.this.E();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            EditVideoPartManager.this.Q0();
        }
    }

    private fs.b B(EditVideoParams.EditSource editSource, int i3, int i16, String str, float f16, int i17, String str2, boolean z16, long j3, String str3, String str4, int i18, int i19) {
        fs.b bVar = new fs.b(this.C);
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        publishVideoEntry.multiFragmentGroupId = str3;
        publishVideoEntry.createTime = j3 + (i18 * 1000);
        publishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
        if (((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()) {
            bVar.f400387d.videoMaxrate = ((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).getCqMaxBitrate() * 1000;
            bVar.f400387d.putExtra("composite_key_bitrate_mode", Boolean.valueOf(((IMediaCodecDPC) QRoute.api(IMediaCodecDPC.class)).isCqBitrateModeSwitchOpen()));
        }
        PublishVideoEntry publishVideoEntry2 = bVar.f400387d;
        publishVideoEntry2.videoMinrate = CodecParam.mMinrate;
        publishVideoEntry2.videoUploadGroupTempDir = str4;
        bVar.f400399p = fs.s.b(this.C.f204055d);
        Activity activity = this.f67794m.getActivity();
        EditVideoSpeedFilter editVideoSpeedFilter = this.J;
        bVar.f400392i = new fs.i(activity, i3, i16, str, f16, editVideoSpeedFilter != null && editVideoSpeedFilter.q0() == 5, i17, 0.0d, 0.0d, str2, z16);
        if (!(editSource instanceof EditTakeVideoSource) && !(editSource instanceof EditLocalVideoSource)) {
            bVar.f400387d.putExtra("is_hw_encode", Boolean.FALSE);
        } else {
            bVar.f400387d.putExtra("is_hw_encode", Boolean.TRUE);
        }
        bVar.f400387d.putExtra("thumb_rotation", Integer.valueOf(i17));
        bVar.f400387d.putExtra("composite_key_capturemode", Integer.valueOf(K()));
        bVar.f400387d.putExtra("composite_key_entrance", Integer.valueOf(this.C.k()));
        String m3 = bVar.f400384a.m("extra_text_filter_text");
        if (!TextUtils.isEmpty(m3)) {
            if (TextUtils.isEmpty(bVar.f400387d.videoDoodleDescription)) {
                bVar.f400387d.videoDoodleDescription = m3;
            } else {
                StringBuilder sb5 = new StringBuilder();
                PublishVideoEntry publishVideoEntry3 = bVar.f400387d;
                sb5.append(publishVideoEntry3.videoDoodleDescription);
                sb5.append(m3);
                publishVideoEntry3.videoDoodleDescription = sb5.toString();
            }
        }
        return bVar;
    }

    private aj C() {
        aj ajVar = new aj(this.f67794m.getContext());
        ajVar.h(BaseAIOUtils.f(50.0f, this.f67794m.getActivity().getResources()));
        ajVar.f(true);
        ajVar.o(false);
        ajVar.r(-1);
        ajVar.e(0);
        ajVar.j(-15550475);
        ajVar.l(3);
        ajVar.E = true;
        ajVar.A = 2;
        ajVar.n(true);
        ajVar.g(new e());
        return ajVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E() {
        Dialog dialog = this.f67793l0;
        if (dialog != null) {
            dialog.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(String str) {
        com.tencent.aelight.camera.aioeditor.editipc.a.n(str, ".mp4", new AnonymousClass10(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        aa aaVar = this.f67794m;
        if (aaVar == null) {
            return;
        }
        aaVar.getRootView().postDelayed(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.5
            @Override // java.lang.Runnable
            public void run() {
                if (EditVideoPartManager.this.f67791j0) {
                    return;
                }
                if (EditVideoPartManager.this.f67790i0 < 50.0f) {
                    EditVideoPartManager.this.f67790i0 += EditVideoPartManager.this.f67792k0;
                } else {
                    EditVideoPartManager.this.f67790i0 += 1.0f;
                }
                if (EditVideoPartManager.this.f67790i0 > 99.0f) {
                    EditVideoPartManager.this.f67790i0 = 99.0f;
                    EditVideoPartManager editVideoPartManager = EditVideoPartManager.this;
                    editVideoPartManager.q1((int) editVideoPartManager.f67790i0);
                } else {
                    EditVideoPartManager editVideoPartManager2 = EditVideoPartManager.this;
                    editVideoPartManager2.q1((int) editVideoPartManager2.f67790i0);
                    EditVideoPartManager.this.J();
                }
            }
        }, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J0() {
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle != null) {
            editVideoDoodle.V().o1();
        }
        t(9);
        if (SlideShowPhotoListManager.n().m() == 22) {
            LpReportInfo_pf00064.allReport(680, 2, 6);
            LpReportInfo_pf00064.allReport(680, 12, 1);
        }
    }

    private void S0(int i3) {
        if (!l0()) {
            Bosses.get().postJob(new c("Q.qqstory.publish.edit.EditVideoPartManager"));
        }
        if (this.C.c("extra_is_slide_show_video", false)) {
            id0.a.n("video_edit", "pub_slides", 0, 0, new String[0]);
        }
        if (this.C.k() == 104) {
            id0.a.n("video_shoot_fromweb", "done_pub", 0, 0, new String[0]);
        }
    }

    private void V0(EditVideoParams.EditSource editSource, Observer<fs.b> observer) {
        fs.b bVar = new fs.b(this.C);
        PublishVideoEntry publishVideoEntry = bVar.f400387d;
        publishVideoEntry.videoMaxrate = CodecParam.mMaxrate;
        publishVideoEntry.videoMinrate = CodecParam.mMinrate;
        String m3 = this.C.m("extra_upload_temp_directory");
        bVar.f400399p = m3;
        if (m3 == null) {
            bVar.f400399p = fs.s.b(this.C.f204055d);
        }
        bVar.f400395l = new fs.g(editSource.getSourcePath());
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().editVideoPrePublish(0, bVar);
        }
        w(bVar);
        A(bVar);
        hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH start, Folder = %s", bVar.f400399p);
        this.f67794m.showLoadingDialog(HardCodeUtil.qqStr(R.string.m0u), false, 500L);
        this.f67798p0.set(1);
        this.f67799q0.clear();
        Stream map = Stream.of(bVar).map(new ThreadOffFunction("Q.qqstory.publish.edit.EditVideoPartManager", 2)).map(new fs.p(false)).map(new fs.u());
        Activity activity = this.f67794m.getActivity();
        EditVideoSpeedFilter editVideoSpeedFilter = this.J;
        Stream map2 = map.map(new fs.h(activity, editVideoSpeedFilter != null ? editVideoSpeedFilter.q0() : 0));
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle != null) {
            map2 = map2.map(editVideoDoodle.q0(0));
        }
        map2.map(new fs.q()).map((StreamFunction) xc0.c.a(fs.a.class, new Object[0])).map(new fs.t(this.C)).map(new UIThreadOffFunction(this)).subscribe(observer);
    }

    private void a1() {
        if (this.C.e() == 14) {
            hd0.c.k("Q.qqstory.publish.edit.EditVideoPartManager", "reportPublish()  entranceType=" + this.C.k() + " , isEditCamera:" + this.C.p());
            int i3 = this.C.k() == 120 ? 1 : 2;
            int i16 = this.C.p() ? 1 : 2;
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject.put("lens_tab", f0().getLensTabId());
                jSONObject.put(MaxVideoConst.INTENT_PARAM_WATERMARK_ID, f0().getWatermarkId());
                jSONObject.put("music_id", f0().getSongMid());
                jSONObject.put(QzoneCameraConst.Tag.ARG_PARAM_FILTER_ID, f0().getFilterId());
                jSONObject.put(QzoneCameraConst.Tag.ARG_PARAM_STICKER_ID, f0().getStickerId());
                jSONObject.put("word_id", f0().getWordId());
                if (f0().getMusicType() == 1) {
                    jSONObject.put("music_play_time", f0().getMusciPlayTime());
                }
                jSONObject.put("video_duration", f0().getVideoDuration());
                jSONObject2.put("music_type", f0().getMusicType());
                jSONObject2.put("filter_type", f0().getFilterType());
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            VSReporter.m("mystatus_edit", "post_clk", i3, 0, String.valueOf(i16), "", jSONObject.toString(), jSONObject2.toString());
        }
    }

    private void k1() {
        if (this.f67796n0 == null) {
            String string = this.f67794m.getContext().getString(R.string.y8b);
            String string2 = this.f67794m.getContext().getString(R.string.y8a);
            this.f67796n0 = DialogUtil.createCustomDialog(this.f67794m.getContext(), 230, (String) null, string, this.f67794m.getContext().getString(R.string.y8_), string2, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.v
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    EditVideoPartManager.this.o0(dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.w
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    EditVideoPartManager.p0(dialogInterface, i3);
                }
            });
        }
        try {
            if (this.f67796n0.isShowing()) {
                return;
            }
            this.f67796n0.show();
        } catch (Throwable th5) {
            ms.a.e("Q.qqstory.publish.edit.EditVideoPartManager", th5);
        }
    }

    private void l1(String str) {
        if (this.f67793l0 == null) {
            ReportDialog reportDialog = new ReportDialog(this.f67794m.getContext());
            this.f67793l0 = reportDialog;
            Window window = reportDialog.getWindow();
            if (window != null) {
                window.setBackgroundDrawable(new ColorDrawable());
                window.setDimAmount(0.0f);
            }
            this.f67793l0.requestWindowFeature(1);
            this.f67793l0.setContentView(R.layout.ba8);
            ImageView imageView = (ImageView) this.f67793l0.findViewById(R.id.g1f);
            aj C = C();
            this.f67795m0 = C;
            imageView.setImageDrawable(C);
        }
        ((TextView) this.f67793l0.findViewById(R.id.f166327f13)).setText(str);
        this.f67793l0.setCancelable(false);
        this.f67793l0.setCanceledOnTouchOutside(false);
        p1(0);
        this.f67794m.getRootView().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.4
            @Override // java.lang.Runnable
            public void run() {
                EditVideoPartManager.this.f67793l0.show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n0(fs.b bVar) {
        int i3;
        int i16;
        if (this.f67794m.getActivity() == null) {
            ms.a.c("Q.qqstory.publish.edit.EditVideoPartManager", "jumpToSaveVideoForAioSendVideoArkMsg--activity not exist");
            return;
        }
        l1(HardCodeUtil.qqStr(R.string.lyq));
        PublishParam publishParam = bVar.f400396m;
        ms.a.a("Q.qqstory.publish.edit.EditVideoPartManager", "jumpToSaveVideoForAioSendVideoArkMsg: publishParam=" + publishParam);
        Intent intent = this.f67794m.getActivity().getIntent();
        if (intent != null) {
            i3 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_FRAME_COUNT, 0);
            i16 = intent.getIntExtra(ShortVideoConstants.SV_TOTAL_RECORD_TIME, 0);
        } else {
            i3 = 0;
            i16 = 0;
        }
        Intent E0 = SaveVideoActivity.E0(this.f67794m.getContext(), publishParam.f69066d, i16, i3, this.C.e());
        this.f67788h0 = publishParam.f69066d;
        js.a aVar = js.a.f410904d;
        int b16 = aVar.b();
        if (intent != null) {
            b16 = intent.getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, aVar.b());
        }
        E0.putExtra(ShortVideoConstants.SV_MEDIACODEC_ENCODE_ENABLE, true);
        E0.putExtra(ShortVideoConstants.VIDEO_EDIT_FLAG, publishParam.H != 0);
        E0.putExtra(ShortVideoConstants.THUMBFILE_SEND_PATH, publishParam.f69067e);
        E0.putExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, b16);
        if (intent != null) {
            E0.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM));
            String stringExtra = intent.getStringExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME);
            ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "start SaveVideoActivity---takeSameName=" + stringExtra);
            E0.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, stringExtra);
            E0.putExtra("qqstory_slide_show_scene", intent.getIntExtra("qqstory_slide_show_scene", -1));
        }
        this.f67794m.getActivity().startActivityForResult(E0, 237);
        m1(5, publishParam.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void o0(DialogInterface dialogInterface, int i3) {
        g0();
    }

    private void p1(int i3) {
        aj ajVar = this.f67795m0;
        if (ajVar == null) {
            return;
        }
        ajVar.t();
        this.f67795m0.i(i3);
        this.f67795m0.p(true);
        this.f67795m0.m(false);
        this.f67795m0.q(i3 + "%");
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "[setProgress] current:" + this.f67795m0.a() + ", progress:" + i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q1(int i3) {
        if (j1()) {
            i3 = (int) ((i3 * 50.0f) / 100.0f);
        }
        p1(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r1(int i3) {
        if (j1()) {
            i3 = (int) (((i3 * 50.0f) / 100.0f) + 50.0f);
        }
        p1(i3);
    }

    public static boolean v(int i3, int i16) {
        if ((i3 & i16) == i16) {
            return true;
        }
        return false;
    }

    private void x() {
        if (this.f67794m == null || this.C == null) {
            QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "have not attach ui and params  mUi " + this.f67794m + " mEditVideoParams " + this.C);
        }
    }

    public void A(fs.b bVar) {
        long j3 = this.C.f204058h.getLong("troop_uin");
        if (j3 != 0) {
            qqstory_struct$VideoReaderConf qqstory_struct_videoreaderconf = new qqstory_struct$VideoReaderConf();
            qqstory_struct_videoreaderconf.ban_type.set(1);
            qqstory_struct_videoreaderconf.user_list.set(new ArrayList());
            qqstory_struct_videoreaderconf.setHasFlag(true);
            bVar.f400387d.readerConfBytes = qqstory_struct_videoreaderconf.toByteArray();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Long.valueOf(j3));
            if (arrayList.size() > 0) {
                synchronized (this) {
                    qqstory_struct$VideoSpreadGroupList qqstory_struct_videospreadgrouplist = new qqstory_struct$VideoSpreadGroupList();
                    byte[] bArr = bVar.f400387d.spreadGroupBytes;
                    if (bArr != null) {
                        try {
                            qqstory_struct_videospreadgrouplist.mergeFrom(bArr);
                        } catch (InvalidProtocolBufferMicroException e16) {
                            hd0.c.h("Q.qqstory.publish.edit.EditVideoPartManager", "checkTroopStory", e16);
                        }
                    }
                    qqstory_struct_videospreadgrouplist.group_list.set(arrayList);
                    qqstory_struct_videospreadgrouplist.visibility_type.set(4);
                    qqstory_struct_videospreadgrouplist.setHasFlag(true);
                    bVar.f400387d.spreadGroupBytes = qqstory_struct_videospreadgrouplist.toByteArray();
                }
            }
        }
    }

    public void A0() {
        F0();
        t(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void B0() {
        if (this.f67794m.getActivity() == null) {
            return;
        }
        if (this.f67780d == 7) {
            t(0);
        } else {
            t(27);
        }
    }

    public void C0() {
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onPause();
        }
    }

    public void D0() {
        this.f67794m.dismissLoadingDialog();
        DoodleLayout V = this.I.V();
        int[] q06 = V.q0(0);
        int[] k06 = V.k0(0);
        int[] iArr = this.M.P;
        iArr[0] = q06[0];
        iArr[1] = q06[1];
        iArr[2] = k06[0];
        iArr[3] = k06[1];
        iArr[4] = V.C0().V();
        Bitmap S = S();
        if (S != null && !S.isRecycled()) {
            Bitmap X = V.X();
            if (X != null) {
                S = com.tencent.biz.qqstory.utils.b.j(S, X);
                hd0.c.a("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone merged");
            }
            this.M.D = S;
            t(7);
            return;
        }
        hd0.c.g("Q.qqstory.publish.edit.EditVideoPartManager", "onPrepareCropDone fail");
    }

    public void E0() {
        SlideShowPhotoListManager n3;
        aa aaVar = this.f67794m;
        if (aaVar == null) {
            QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "onPreparePublishDone error, mUi is null");
            return;
        }
        Z0(aaVar.getContext());
        b1();
        Activity activity = this.f67794m.getActivity();
        int i3 = -1;
        if (activity instanceof EditPicActivity) {
            int intExtra = activity.getIntent().getIntExtra(AECameraConstants.KEY_EDITPIC_CAMERATYPE, -1);
            if (intExtra == 1) {
                BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4).edit().putLong("sv_latest_taken_photo_time", -1L).commit();
                com.tencent.aelight.camera.aioeditor.activity.richmedia.c.h();
            } else if (intExtra == 2) {
                com.tencent.aelight.camera.aioeditor.activity.richmedia.c.g();
            } else if (intExtra == 3) {
                com.tencent.aelight.camera.aioeditor.activity.richmedia.c.k();
            }
        }
        if (V() != 7 || (n3 = SlideShowPhotoListManager.n()) == null) {
            return;
        }
        List<SlideItemInfo> o16 = n3.o();
        Iterator<SlideItemInfo> it = o16.iterator();
        int i16 = 0;
        while (it.hasNext()) {
            if (it.next().f94290h == 1) {
                i16++;
            }
        }
        int size = o16.size() - i16;
        int l3 = n3.l();
        Intent intent = this.f67794m.getActivity().getIntent();
        if (intent != null) {
            EditVideoParams editVideoParams = (EditVideoParams) intent.getParcelableExtra(EditVideoParams.class.getName());
            if (editVideoParams != null) {
                i3 = editVideoParams.l("extra_ablum_type", -1);
            } else {
                i3 = intent.getIntExtra("extra_ablum_type", -1);
            }
        }
        id0.a.n("video_edit_slides", "clk_pub", l3 == 11 ? 0 : 1, 0, id0.a.a(i3) + "", o16.size() + "", size + "", i16 + "");
    }

    public void G0(Bundle bundle) {
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onRestoreInstanceState(bundle);
        }
    }

    public void H0() {
        if (this.f67780d == -1) {
            t(0);
        }
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onResume();
        }
    }

    public void I() {
        DoodleLayout V;
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle == null || (V = editVideoDoodle.V()) == null) {
            return;
        }
        V.f68172u0.H();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void I0() {
        if (i0()) {
            J0();
        } else {
            c1(new a());
        }
    }

    public int K() {
        EditVideoParams editVideoParams = this.C;
        int i3 = editVideoParams.f204056e;
        if (!(editVideoParams.f204059i instanceof EditLocalVideoSource) || i3 == 9) {
            return i3;
        }
        return 2;
    }

    public void K0(Bundle bundle) {
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onSaveInstanceState(bundle);
        }
        bundle.putInt("mEditState", this.f67780d);
    }

    public int L() {
        return k0() ? l0() ? 3 : 4 : l0() ? 1 : 2;
    }

    public final void L0() {
        ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "onSaveOrUploadArkVideoError");
        if (this.f67797o0 == null) {
            this.f67797o0 = DialogUtil.createCustomDialog(this.f67794m.getActivity(), 230).setMessage(R.string.ylz).setPositiveButton(R.string.yly, new g()).setNegativeButton(R.string.cancel, new f());
        }
        if (this.f67797o0.isShowing()) {
            return;
        }
        this.f67797o0.show();
    }

    public int M() {
        return k0() ? l0() ? 3 : 4 : l0() ? 1 : 2;
    }

    public void M0() {
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onStart();
        }
    }

    public int N() {
        return 0;
    }

    public void N0() {
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onStop();
        }
    }

    public String O(Bitmap bitmap) {
        EditProviderPart editProviderPart = this.H;
        if (editProviderPart != null) {
            return editProviderPart.A0(bitmap);
        }
        return "";
    }

    public void O0() {
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle != null) {
            editVideoDoodle.V().q1();
        }
    }

    public int P() {
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle != null) {
            return editVideoDoodle.p0();
        }
        return 0;
    }

    public void P0(boolean z16) {
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onWindowFocusChanged(z16);
        }
    }

    public int Q() {
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle != null) {
            return editVideoDoodle.o0(N());
        }
        return 0;
    }

    public void Q0() {
        EditVideoDoodle editVideoDoodle = this.I;
        boolean z16 = false;
        if (editVideoDoodle != null) {
            DoodleLayout V = editVideoDoodle.V();
            if (V != null) {
                V.n1();
            }
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = this.I.V().r0();
            if (r06 != null && r06.L.p()) {
                if (QLog.isColorLevel()) {
                    QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "preparePublish");
                }
                this.f67794m.showLoadingDialog(HardCodeUtil.qqStr(R.string.f171929ly3), false, 500L);
                EditVideoDoodle editVideoDoodle2 = this.I;
                editVideoDoodle2.C = 2;
                editVideoDoodle2.V().s1();
                z16 = true;
            }
            com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.g C0 = this.I.V().C0();
            if (C0 != null) {
                C0.Y();
            }
        }
        if (z16) {
            return;
        }
        E0();
    }

    public Bitmap S() {
        EditPicRawImage editPicRawImage = this.L;
        if (editPicRawImage != null) {
            return editPicRawImage.p0();
        }
        return null;
    }

    public Bundle T() {
        Bundle bundle = this.Y;
        return bundle == null ? new Bundle() : bundle;
    }

    public void T0(Class<? extends u.a> cls, u.a aVar) {
        z();
        x();
        if (cls != null) {
            if (cls.isInstance(aVar)) {
                u.a aVar2 = this.Z.get(cls);
                if (aVar2 == null) {
                    hd0.c.m("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s with %s", cls.getSimpleName(), aVar);
                } else {
                    hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "publishEditExport for %s replace %s by %s", cls.getSimpleName(), aVar2, aVar);
                }
                this.Z.put(cls, aVar);
                return;
            }
            throw new IllegalArgumentException("the 2nd parameter's type " + aVar.getClass().getName() + " is not instance of " + cls.getName());
        }
        throw new IllegalArgumentException("editExportClass should not be null");
    }

    public EditVideoDoodle U() {
        return this.I;
    }

    public void U0(Error error) {
        hd0.c.g("Q.qqstory.publish.edit.EditVideoPartManager", "PUBLISH error \uff1a" + error);
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().editVideoPublishError(error);
        }
        id0.a.k("video_edit", "pub_error", 0, 0, error.toString());
        this.f67799q0.add(error);
        if (this.f67798p0.decrementAndGet() > 0) {
            hd0.c.t("Q.qqstory.publish.edit.EditVideoPartManager", "waiting for another observer finish");
            return;
        }
        this.f67784f = false;
        this.f67794m.dismissLoadingDialog();
        QQToast.makeText(this.f67794m.getContext(), HardCodeUtil.qqStr(R.string.lyz), 0).show();
        x xVar = (x) R(x.class);
        if (xVar != null) {
            xVar.play();
        }
    }

    public int V() {
        return this.f67777a0;
    }

    public int W() {
        return R.layout.dof;
    }

    protected SimpleObserver<fs.b> X() {
        return new d(SystemClock.uptimeMillis());
    }

    public void X0(String str, int i3, int i16, String... strArr) {
        Bosses.get().postJob(new b("Q.qqstory.publish.edit.EditVideoPartManager", str, i3, i16, strArr));
    }

    public int Y() {
        EditVideoParams editVideoParams = this.C;
        if (editVideoParams == null) {
            return 0;
        }
        int e16 = editVideoParams.e();
        if (e16 == 2) {
            return 5;
        }
        if (e16 == 3) {
            return 4;
        }
        if (e16 != 4) {
            if (e16 == 11) {
                return 2;
            }
            if (e16 != 12) {
                return 0;
            }
        }
        return 3;
    }

    public List<u> Z() {
        return this.D;
    }

    public void Z0(Context context) {
        if (this.C.k() == 14) {
            id0.a.n("story_grp", "clk_send", 0, 0, new String[0]);
        }
    }

    public long a0(int i3) {
        long j3;
        EditVideoParams.EditSource editSource = this.C.f204059i;
        if ((editSource instanceof EditTakePhotoSource) || (editSource instanceof EditLocalPhotoSource)) {
            j3 = 5000;
        } else if (editSource instanceof EditLocalVideoSource) {
            EditLocalVideoSource editLocalVideoSource = (EditLocalVideoSource) editSource;
            j3 = editLocalVideoSource.f204046h - editLocalVideoSource.f204045f;
            if (j3 == 0) {
                j3 = editLocalVideoSource.f204044e.mDuration;
            }
        } else if (editSource instanceof EditTakeVideoSource) {
            j3 = ((EditTakeVideoSource) editSource).f204052e.mDuration;
        } else {
            throw new RuntimeException(HardCodeUtil.qqStr(R.string.m2l));
        }
        EditVideoSpeedFilter editVideoSpeedFilter = this.J;
        if (editVideoSpeedFilter == null) {
            return j3;
        }
        int q06 = editVideoSpeedFilter.q0();
        if (q06 != 1) {
            return q06 != 2 ? q06 != 3 ? q06 != 4 ? j3 : j3 * 4 : ((float) j3) / 1.5f : j3 * 2;
        }
        return j3 / 2;
    }

    public int b0() {
        int i3 = this.C.f204055d;
        int i16 = 2;
        if (i3 != 2) {
            i16 = 3;
            if (i3 != 3) {
                i16 = 4;
                if (i3 != 4) {
                    i16 = 5;
                    if (i3 != 5) {
                        return 999;
                    }
                }
            }
        }
        return i16;
    }

    public void b1() {
        z();
        x();
        EditVideoParams.EditSource editSource = this.C.f204059i;
        hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "onConfirmClick : %s", editSource);
        Intent intent = this.f67794m.getActivity().getIntent();
        if (!this.f67784f) {
            if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(intent, this.C.e()) || ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(intent)) {
                String str = "";
                if (this.f67794m.getActivity() != null && this.f67794m.getActivity().getIntent() != null && this.f67794m.getActivity().getIntent().getBundleExtra("state") != null) {
                    str = this.f67794m.getActivity().getIntent().getBundleExtra("state").getString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH");
                }
                if (this.C.f204059i instanceof EditLocalVideoSource) {
                    this.C.f204059i = new EditLocalPhotoSource(str, new LocalMediaInfo());
                }
                I0();
            }
            this.f67784f = i0();
            x xVar = (x) R(x.class);
            if (xVar != null) {
                xVar.pause();
            }
            if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(intent, this.C.e()) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(intent)) {
                SimpleObserver<fs.b> X = X();
                boolean z16 = editSource instanceof EditLocalVideoSource;
                if (!z16 && !(editSource instanceof EditTakeVideoSource)) {
                    if ((editSource instanceof EditLocalPhotoSource) || (editSource instanceof EditTakePhotoSource)) {
                        R0();
                        CodecParam.mRecordTime = 5000;
                        CodecParam.mRecordFrames = 125;
                        CodecParam.mIsSmooth = 0;
                        CodecParam.mEnableTotalTimeAdjust = 0;
                        EditVideoSpeedFilter editVideoSpeedFilter = this.J;
                        CodecParam.mSaveMode = editVideoSpeedFilter != null ? editVideoSpeedFilter.q0() : 0;
                        V0(editSource, X);
                    }
                } else {
                    W0(editSource, X);
                    if (z16) {
                        id0.a.n("video_edit", "pub_local", 0, 1, new String[0]);
                    }
                }
                a1();
                return;
            }
            a1();
            return;
        }
        hd0.c.t("Q.qqstory.publish.edit.EditVideoPartManager", "requestPublish duplicate");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public View c0() {
        r rVar = this.E;
        if (rVar != null) {
            return rVar.t0();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c1(QQPermission.BasePermissionsListener basePermissionsListener) {
        BusinessConfig businessConfig;
        aa aaVar = this.f67794m;
        if (aaVar == null) {
            return;
        }
        Activity activity = aaVar.getActivity();
        if (activity instanceof AppActivity) {
            boolean z16 = !com.tencent.aelight.camera.ae.flashshow.util.q.a(activity);
            LinkedList linkedList = new LinkedList();
            if (z16) {
                linkedList.add(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE);
                linkedList.add(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE);
            }
            if (linkedList.size() > 0) {
                if (l0()) {
                    businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_EDIT_PHOTO, QQPermissionConstants.Business.SCENE.RICH_MEDIA_EDIT_PHOTO);
                } else {
                    businessConfig = new BusinessConfig(QQPermissionConstants.Business.ID.QQ_RICH_MEDIA_EDIT_VIDEO, QQPermissionConstants.Business.SCENE.RICH_MEDIA_EDIT_VIDEO);
                }
                QQPermissionFactory.getQQPermission(activity, businessConfig).requestPermissions(new String[]{QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE}, 2, basePermissionsListener);
            }
        }
    }

    public aa d0() {
        return this.f67794m;
    }

    public void d1() {
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle != null) {
            editVideoDoodle.V().O();
        }
    }

    public long e0() {
        return 0L;
    }

    public void e1(Bitmap bitmap, boolean z16) {
        z();
        EditPicRawImage editPicRawImage = this.L;
        if (editPicRawImage != null) {
            editPicRawImage.y0(bitmap, z16);
        }
    }

    public VideoStoryDataBean f0() {
        try {
            if (this.f67779c0 == null) {
                VideoStoryDataBean videoStoryDataBean = (VideoStoryDataBean) T().getSerializable("KEY_VIDEO_STORY_CAMERA_TYPE");
                if (videoStoryDataBean == null) {
                    videoStoryDataBean = new VideoStoryDataBean();
                }
                this.f67779c0 = videoStoryDataBean;
            }
        } catch (Exception e16) {
            QLog.e("Q.qqstory.publish.edit.EditVideoPartManager", 1, "getVsDataBean error", e16);
            this.f67779c0 = new VideoStoryDataBean();
        }
        return this.f67779c0;
    }

    public void f1(boolean z16) {
        r rVar = this.E;
        if (rVar != null) {
            rVar.H0(z16);
        }
    }

    protected void g0() {
        x xVar = (x) R(x.class);
        if (xVar != null) {
            xVar.pause();
        }
        this.f67794m.finish(0, null, R.anim.dialog_exit, 0);
    }

    public void g1(int i3) {
        this.f67777a0 = i3;
        if (QLog.isColorLevel()) {
            QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 2, "setFrom " + this.f67777a0);
        }
    }

    public boolean i0() {
        aa aaVar = this.f67794m;
        if (aaVar == null) {
            return false;
        }
        boolean a16 = com.tencent.aelight.camera.ae.flashshow.util.q.a(aaVar.getContext());
        ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "checkPermission,   grantStorage: " + a16);
        return a16;
    }

    public boolean i1() {
        if (TextUtils.isEmpty(this.f67781d0)) {
            return false;
        }
        if (this.f67786g0 == null) {
            this.f67786g0 = (AEMaterialArkInfo) GsonUtils.json2Obj(this.f67781d0, AEMaterialArkInfo.class);
            ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "ArkVideo---json2Obj materialArkInfo=" + this.f67786g0);
        }
        AEMaterialArkInfo aEMaterialArkInfo = this.f67786g0;
        return aEMaterialArkInfo != null && "game".equals(aEMaterialArkInfo.getType());
    }

    @Override // com.tribe.async.dispatch.IEventReceiver
    public boolean isValidate() {
        return this.f67787h;
    }

    protected void j0(EditVideoParams editVideoParams) {
        hd0.c.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %s", editVideoParams);
        int i3 = editVideoParams.f204057f;
        List<u> arrayList = new ArrayList<>();
        int i16 = editVideoParams.f204055d;
        if (i16 == 11) {
            com.tencent.aelight.camera.aioeditor.takevideo.b bVar = new com.tencent.aelight.camera.aioeditor.takevideo.b(this, i3);
            this.E = bVar;
            arrayList.add(bVar);
        } else if (i16 == 12) {
            com.tencent.aelight.camera.aioeditor.e eVar = new com.tencent.aelight.camera.aioeditor.e(this, i3);
            this.E = eVar;
            arrayList.add(eVar);
        } else if (i16 == 14) {
            EditVideoStoryButton editVideoStoryButton = new EditVideoStoryButton(this);
            this.G = editVideoStoryButton;
            arrayList.add(editVideoStoryButton);
        } else if (i16 == 15) {
            EditARCakeButton editARCakeButton = new EditARCakeButton(this);
            this.F = editARCakeButton;
            arrayList.add(editARCakeButton);
        } else {
            r rVar = new r(this, i3);
            this.E = rVar;
            arrayList.add(rVar);
        }
        if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(this.f67794m.getActivity().getIntent(), this.C.e()) && !((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.f67794m.getActivity().getIntent())) {
            EditProviderPart editProviderPart = new EditProviderPart(this);
            this.H = editProviderPart;
            arrayList.add(editProviderPart);
        }
        if (editVideoParams.r()) {
            EditPicRawImage editPicRawImage = new EditPicRawImage(this, i3);
            this.L = editPicRawImage;
            arrayList.add(editPicRawImage);
        } else {
            this.f67800r0 = new HWEditLocalVideoPlayer(this);
            if (editVideoParams.q()) {
                arrayList.add(new HWEditImportVideoPlayer(this));
            } else if (editVideoParams.f()) {
                arrayList.add(this.f67800r0);
            }
        }
        if (v(i3, 2)) {
            if (editVideoParams.f204055d == 14) {
                arrayList.add(new EditVideoSmartMusicPart(this));
            } else {
                com.tencent.aelight.camera.aioeditor.capture.music.c cVar = new com.tencent.aelight.camera.aioeditor.capture.music.c(this, false);
                this.K = cVar;
                arrayList.add(cVar);
            }
        }
        if (v(i3, 1024) || v(i3, 131072) || v(i3, 1) || v(i3, 8)) {
            EditVideoDoodle editVideoDoodle = new EditVideoDoodle(this, i3);
            this.I = editVideoDoodle;
            arrayList.add(editVideoDoodle);
        }
        if (v(i3, 256)) {
            EditVideoSpeedFilter editVideoSpeedFilter = new EditVideoSpeedFilter(this, true);
            this.J = editVideoSpeedFilter;
            arrayList.add(editVideoSpeedFilter);
        }
        if (editVideoParams.r() && v(i3, 4)) {
            i iVar = new i(this);
            this.M = iVar;
            arrayList.add(iVar);
        }
        if (v(i3, 512)) {
            if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(this.f67794m.getActivity().getIntent())) {
                EditPicSave editPicSave = new EditPicSave(this);
                this.P = editPicSave;
                arrayList.add(editPicSave);
            } else if (!((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(this.f67794m.getActivity().getIntent(), this.C.e())) {
                EditVideoSave editVideoSave = new EditVideoSave(this);
                this.N = editVideoSave;
                arrayList.add(editVideoSave);
            } else {
                EditPicSave editPicSave2 = new EditPicSave(this);
                this.P = editPicSave2;
                arrayList.add(editPicSave2);
            }
        }
        if (v(i3, 16)) {
            z zVar = new z(this);
            this.Q = zVar;
            arrayList.add(zVar);
        }
        if (js.a.f410906f.d(editVideoParams.D) && (editVideoParams.p() || editVideoParams.r() || editVideoParams.s())) {
            SendPanelPart sendPanelPart = new SendPanelPart(this);
            this.R = sendPanelPart;
            arrayList.add(sendPanelPart);
        }
        if (v(editVideoParams.f204057f, 4096)) {
            EditVideoLimitRegion editVideoLimitRegion = new EditVideoLimitRegion(this);
            this.W = editVideoLimitRegion;
            arrayList.add(editVideoLimitRegion);
        }
        p(arrayList);
        List<u> unmodifiableList = Collections.unmodifiableList(arrayList);
        this.D = unmodifiableList;
        hd0.c.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts %d", Integer.valueOf(unmodifiableList.size()));
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            hd0.c.b("Q.qqstory.publish.edit.EditVideoPartManager", "initEditVideoParts : %s", it.next().getClass().getSimpleName());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean j1() {
        if (this.C.e() == 2 || this.C.e() == 106) {
            return i1();
        }
        return false;
    }

    public boolean k0() {
        z();
        x();
        return this.C.q();
    }

    public boolean l0() {
        z();
        x();
        return this.C.r();
    }

    public boolean m0() {
        z();
        x();
        if (this.Y == null || !k0()) {
            return false;
        }
        return this.Y.getBoolean("KEY_FROM_PIC_TO_VIDEO", false);
    }

    public void n1() {
        z();
        x();
        ((IAEBaseDataReporter) QRoute.api(IAEBaseDataReporter.class)).reportRephotoBtn();
        id0.b.i("0X80076B6");
        id0.b.f("0X80075C2");
        EditVideoDoodle editVideoDoodle = this.I;
        int p06 = editVideoDoodle != null ? editVideoDoodle.p0() : 0;
        i iVar = this.M;
        if (iVar != null) {
            p06 += iVar.K;
        }
        EditProviderPart editProviderPart = this.H;
        if (editProviderPart != null && editProviderPart.G0()) {
            p06++;
        }
        hd0.c.b("Q.qqstory.publish.edit.EditVideoPartManager", "tryQuitRecordUI, current is preview state, edit count = %d", Integer.valueOf(p06));
        if (p06 < 1) {
            g0();
            return;
        }
        id0.b.i("0X80076B7");
        id0.b.f("0X80075C3");
        k1();
    }

    public boolean o1() {
        SendPanelPart sendPanelPart = this.R;
        return sendPanelPart != null && sendPanelPart.I;
    }

    public void q(String str) {
        DocEnhancePart docEnhancePart = this.S;
        if (docEnhancePart != null) {
            docEnhancePart.p0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void q0() {
        if (this.f67794m.getActivity() == null) {
            return;
        }
        if (this.f67780d == 7) {
            t(0);
        } else {
            t(28);
        }
    }

    public void r(aa aaVar, EditVideoParams editVideoParams) {
        z();
        if (aaVar != null && editVideoParams != null) {
            if (this.f67794m == aaVar && this.C == editVideoParams) {
                hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "duplicate attachUiAndParams ui=%s, params=%s", aaVar, editVideoParams);
                return;
            }
            this.f67794m = aaVar;
            this.C = editVideoParams;
            j0(editVideoParams);
            Iterator<u> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().attachEditVideoUi(aaVar);
            }
            return;
        }
        throw new IllegalArgumentException("both ui ant params should not be null");
    }

    public void r0() {
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onActivityFinish();
        }
    }

    public int s(Message message) {
        z();
        if (this.f67784f) {
            hd0.c.t("Q.qqstory.publish.edit.EditVideoPartManager", "broadcast message ignore because of publishing");
            return 0;
        }
        Iterator<u> it = this.D.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (it.next().dispatchEditVideoMessage(Message.obtain(message))) {
                i3++;
            }
        }
        if (i3 == 0 && QLog.isDevelopLevel()) {
            hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "broadcastEditVideoMessage, but no one handled", message);
        }
        message.recycle();
        return i3;
    }

    public boolean t0() {
        com.tencent.aelight.camera.aioeditor.capture.music.c cVar = this.K;
        if (cVar != null && cVar.onBackPressed()) {
            hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", this.K);
            return true;
        }
        EditVideoDoodle editVideoDoodle = this.I;
        if (editVideoDoodle != null && editVideoDoodle.onBackPressed()) {
            hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", this.I);
            return true;
        }
        i iVar = this.M;
        if (iVar != null && iVar.onBackPressed()) {
            hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", this.M);
            return true;
        }
        r rVar = this.E;
        if (rVar != null && rVar.onBackPressed()) {
            hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", this.E);
            return true;
        }
        EditVideoStoryButton editVideoStoryButton = this.G;
        if (editVideoStoryButton != null && editVideoStoryButton.onBackPressed()) {
            hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", this.G);
            return true;
        }
        SendPanelPart sendPanelPart = this.R;
        if (sendPanelPart != null && sendPanelPart.onBackPressed()) {
            hd0.c.v("Q.qqstory.publish.edit.EditVideoPartManager", "%s consume the back press event", this.R);
            return true;
        }
        n1();
        return true;
    }

    public final void u(int i3, Object obj) {
        z();
        x();
        if (this.f67784f) {
            hd0.c.u("Q.qqstory.publish.edit.EditVideoPartManager", "change state ignore because of publishing, %s", new Throwable());
            return;
        }
        if (this.f67780d != i3 || i3 == 2 || i3 == 23) {
            if (this.f67782e) {
                hd0.c.u("Q.qqstory.publish.edit.EditVideoPartManager", "change state while state changing, " + i3 + " oldState:" + this.f67780d, new Throwable());
            }
            this.f67782e = true;
            hd0.c.m("Q.qqstory.publish.edit.EditVideoPartManager", "changeState : %s => %s", Integer.valueOf(this.f67780d), Integer.valueOf(i3));
            int i16 = this.f67780d;
            this.f67780d = i3;
            Iterator<u> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().editVideoStateChanged(i16, this.f67780d, obj);
            }
        }
        this.f67782e = false;
    }

    public void u0() {
        z();
        x();
        this.f67787h = true;
        Intent intent = this.f67794m.getActivity().getIntent();
        this.Y = fr.c.a(intent);
        this.f67781d0 = intent.getStringExtra(AECameraConstants.KEY_SEND_ARK_MSG_JSON_INFO);
        this.f67783e0 = intent.getStringExtra(AECameraConstants.KEY_SEND_ARK_MSG_GAME_SCORE);
        this.f67785f0 = intent.getFloatExtra(AECameraConstants.KEY_SEND_ARK_MSG_COVER_START_PERCENTAGE, 0.0f);
        ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "onCreate--ArkVideo arkJson=" + this.f67781d0 + ", score=" + this.f67783e0 + ", percent=" + this.f67785f0);
        Iterator<u> it = this.D.iterator();
        while (it.hasNext()) {
            it.next().onCreate();
        }
        if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isStoryPhoto(intent, this.C.e()) || ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isSameStoryPhotoEntry(intent)) {
            LiuHaiUtils.resetFullScreen(this.f67794m.getActivity());
            RelativeLayout relativeLayout = this.U;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            ViewGroup viewGroup = this.T;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
        }
        if (v(this.C.f204057f, 64)) {
            f67776s0 = new mr.a();
            return;
        }
        View findViewById = this.f67794m.getActivity().findViewById(R.id.f163779rz1);
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void v0() {
        this.M.K += Q();
        boolean z16 = false;
        if (this.f67780d == 7) {
            t(0);
            return;
        }
        DoodleLayout V = this.I.V();
        V.j1();
        com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.c r06 = V.r0();
        if (r06 != null && r06.L.p()) {
            this.f67794m.showLoadingDialog(HardCodeUtil.qqStr(R.string.lzx), false, 500L);
            this.I.C = 3;
            V.s1();
            z16 = true;
        }
        if (z16) {
            return;
        }
        D0();
    }

    public void w(fs.b bVar) {
        byte[] bArr = bVar.f400387d.readerConfBytes;
        if (bArr == null || bArr.length == 0) {
            qqstory_struct$VideoReaderConf qqstory_struct_videoreaderconf = new qqstory_struct$VideoReaderConf();
            qqstory_struct_videoreaderconf.ban_type.set(0);
            qqstory_struct_videoreaderconf.setHasFlag(true);
            bVar.f400387d.readerConfBytes = qqstory_struct_videoreaderconf.toByteArray();
        }
    }

    public void w0() {
        List<u> list = this.D;
        if (list != null) {
            Iterator<u> it = list.iterator();
            while (it.hasNext()) {
                it.next().onDestroy();
            }
            D();
        }
        if (f67776s0 != null && !com.tencent.mobileqq.shortvideo.util.c.c()) {
            f67776s0.b();
        }
        com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().e();
        this.f67787h = false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void x0() {
        this.I.V().o1();
        t(19);
        if (SlideShowPhotoListManager.n().m() == 22) {
            LpReportInfo_pf00064.allReport(680, 2, 5);
            LpReportInfo_pf00064.allReport(680, 13, 1);
        }
    }

    public boolean y(int i3) {
        return this.f67780d == i3;
    }

    protected void z() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new IllegalStateException("can not access by non-ui thread");
        }
    }

    public void z0() {
        EditProviderPart editProviderPart = this.H;
        if (editProviderPart != null) {
            editProviderPart.x0();
        }
    }

    private void R0() {
        S0(0);
    }

    private void m1(int i3, long j3) {
        this.f67790i0 = i3;
        this.f67791j0 = false;
        float f16 = 50000.0f / ((float) j3);
        this.f67792k0 = f16;
        if (f16 == 0.0f) {
            this.f67792k0 = 1.0f;
        }
        J();
    }

    public void D() {
        this.f67794m = null;
    }

    public void F(String str, String str2, String str3, int i3, int i16) {
        ab.b(this.f67794m.getActivity(), 21, this.f67786g0.getPrompt(), com.tencent.aelight.camera.ae.util.a.f65756a.a(str, str2, str3, i3, i16, d0().getActivity().getIntent().getStringExtra("material_id"), this.f67783e0, this.f67786g0));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void G(String str, String str2, String str3, int i3, int i16) {
        SessionInfo sessionInfo = new SessionInfo();
        Bundle bundle = this.C.f204058h;
        sessionInfo.f179555d = bundle.getInt("uintype");
        sessionInfo.f179557e = bundle.getString("uin");
        sessionInfo.f179559f = bundle.getString("troop_uin");
        sessionInfo.f179563i = bundle.getString("uinname");
        com.tencent.aelight.camera.aioeditor.editipc.a.l(sessionInfo, this.f67786g0.getPrompt(), com.tencent.aelight.camera.ae.util.a.f65756a.a(str, str2, str3, i3, i16, d0().getActivity().getIntent().getStringExtra("material_id"), this.f67783e0, this.f67786g0));
    }

    public final void t(int i3) {
        u(i3, null);
    }

    private void h0(int i3, final Intent intent) {
        String str;
        if (intent == null || ((str = this.f67788h0) != null && str.equals(intent.getStringExtra("fakeId")))) {
            t(0);
            this.f67791j0 = true;
            if (i3 == -1) {
                q1(100);
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.7
                    @Override // java.lang.Runnable
                    public void run() {
                        if (EditVideoPartManager.this.C.e() != 14) {
                            EditVideoPartManager.this.H(intent.getStringExtra("key_video_save_path"));
                        }
                    }
                }, 64, null, true);
            } else if (i3 == 1) {
                E();
                L0();
            } else if (i3 == 0) {
                E();
            }
        }
    }

    public void F0() {
        t(24);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.EditVideoPartManager.13
            @Override // java.lang.Runnable
            public void run() {
                Bitmap S = EditVideoPartManager.this.S();
                if (S != null) {
                    try {
                        if (EditVideoPartManager.v(EditVideoPartManager.this.C.f204057f, 64)) {
                            if (EditVideoPartManager.f67776s0 == null) {
                                EditVideoPartManager.f67776s0 = new mr.a();
                            }
                            EditVideoPartManager.f67776s0.d(S.getWidth(), S.getHeight());
                        }
                    } catch (Exception e16) {
                        EditVideoPartManager.f67776s0 = null;
                        QLog.d("Q.qqstory.publish.edit.EditVideoPartManager", 1, "artImageRender init error, ", e16);
                    }
                }
            }
        });
    }

    public u.a R(Class<? extends u.a> cls) {
        if (cls != null) {
            return this.Z.get(cls);
        }
        throw new IllegalArgumentException("editExportClass should not be null");
    }

    public void s0(int i3, int i16, Intent intent) {
        if (i3 == 237) {
            ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "onActivityResult---CODE_REQ_AIO_SAVE_ARK_VIDEO--resultCode=" + i16);
            h0(i16, intent);
            return;
        }
        aa aaVar = this.f67794m;
        if (aaVar == null) {
            ms.a.i("Q.qqstory.publish.edit.EditVideoPartManager", "onActivityResult---, mUi is null!");
            return;
        }
        if (((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).isFromMiniApp(aaVar.getActivity().getIntent())) {
            ms.a.f("Q.qqstory.publish.edit.EditVideoPartManager", "onActivityResult---isFromMiniApp");
            this.f67794m.finish(-1, intent, R.anim.dialog_exit, 0, true);
        } else {
            Iterator<u> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().onActivityResult(i3, i16, intent);
            }
        }
    }

    public void W0(EditVideoParams.EditSource editSource, Observer<fs.b> observer) {
        int width;
        int height;
        String sourcePath;
        float f16;
        int i3;
        Stream map;
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis();
        String str = "Q.qqstory.publish.edit.EditVideoPartManager";
        if (editSource instanceof EditLocalVideoSource) {
            EditLocalVideoSource editLocalVideoSource = (EditLocalVideoSource) editSource;
            hd0.c.a("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
            CodecParam.mRecordTime = 5000;
            CodecParam.mRecordFrames = 125;
            CodecParam.mIsSmooth = 0;
            CodecParam.mEnableTotalTimeAdjust = 0;
            EditVideoSpeedFilter editVideoSpeedFilter = this.J;
            CodecParam.mSaveMode = editVideoSpeedFilter != null ? editVideoSpeedFilter.q0() : 0;
            int width2 = editLocalVideoSource.getWidth();
            int height2 = editLocalVideoSource.getHeight();
            width = Math.min(width2, height2);
            height = Math.max(width2, height2);
            sourcePath = editLocalVideoSource.getSourcePath();
            f16 = (width * 1.0f) / height;
            i3 = editLocalVideoSource.f204044e.rotation;
            hd0.c.a("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo EditLocalVideoSource.mediaInfo" + editLocalVideoSource.f204044e.toString());
        } else if (editSource instanceof EditTakeVideoSource) {
            EditTakeVideoSource editTakeVideoSource = (EditTakeVideoSource) editSource;
            hd0.c.a("Q.qqstory.publish.edit.EditVideoPartManager", "publishVideo CodecParam.mRecordFrames" + CodecParam.mRecordFrames + " CodecParam.mRecordTime" + CodecParam.mRecordTime);
            CodecParam.mRecordTime = 5000;
            CodecParam.mRecordFrames = 125;
            CodecParam.mIsSmooth = 0;
            CodecParam.mEnableTotalTimeAdjust = 0;
            EditVideoSpeedFilter editVideoSpeedFilter2 = this.J;
            CodecParam.mSaveMode = editVideoSpeedFilter2 != null ? editVideoSpeedFilter2.q0() : 0;
            width = editTakeVideoSource.getWidth();
            height = editTakeVideoSource.getHeight();
            sourcePath = editTakeVideoSource.getSourcePath();
            f16 = (width * 1.0f) / height;
            i3 = editTakeVideoSource.f204052e.rotation;
        } else {
            throw new IllegalArgumentException(HardCodeUtil.qqStr(R.string.f171934m10) + editSource);
        }
        int i16 = i3;
        int i17 = height;
        String str2 = sourcePath;
        int i18 = width;
        float f17 = f16;
        ArrayList arrayList = new ArrayList();
        arrayList.add(0);
        String format = String.format("%s.%d", QQStoryContext.h().d(), Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        hd0.c.m("Q.qqstory.publish.edit.EditVideoPartManager", "publish video groupId=%s. fragment count=%d", format, Integer.valueOf(arrayList.size()));
        String m3 = this.C.m("extra_upload_temp_directory");
        this.f67798p0.set(arrayList.size());
        this.f67799q0.clear();
        int i19 = 0;
        while (i19 < arrayList.size()) {
            int intValue = ((Integer) arrayList.get(i19)).intValue();
            S0(intValue);
            int i26 = i19;
            String str3 = format;
            ArrayList arrayList2 = arrayList;
            String str4 = str;
            fs.b B = B(editSource, i18, i17, str2, f17, i16, "", false, serverTimeMillis, str3, m3, i26, intValue);
            Iterator<u> it = this.D.iterator();
            while (it.hasNext()) {
                it.next().editVideoPrePublish(intValue, B);
            }
            w(B);
            A(B);
            hd0.c.v(str4, "PUBLISH start, Folder = %s", B.f400399p);
            this.f67794m.showLoadingDialog(HardCodeUtil.qqStr(R.string.lzg), false, 500L);
            Stream map2 = Stream.of(B).map(new ThreadOffFunction(str4, 2)).map(new fs.l(null, (x) R(x.class), 0));
            EditVideoDoodle editVideoDoodle = this.I;
            if (editVideoDoodle != null) {
                map2 = map2.map(editVideoDoodle.q0(intValue));
                if (!this.I.f67755e.d0().isEmpty() || e0() != 0) {
                    map2 = map2.map(new fs.d(this.I, (com.tencent.aelight.camera.aioeditor.takevideo.e) R(com.tencent.aelight.camera.aioeditor.takevideo.e.class), intValue));
                }
            }
            EditVideoParams.EditSource editSource2 = this.C.f204059i;
            if (!(editSource2 instanceof EditTakeVideoSource) && !(editSource2 instanceof EditLocalVideoSource)) {
                map = map2.map(new fs.q()).map((StreamFunction) xc0.c.a(fs.a.class, new Object[0]));
            } else {
                map = map2.map(new fs.m());
            }
            if (this.C.e() == 14) {
                this.C.f204058h.putInt("VIDEO_STORY_JUMP_TO_TYPE", ((IAECameraEntryManager) QRoute.api(IAECameraEntryManager.class)).getStoryShareType(this.f67794m.getActivity().getIntent()));
            }
            map.map(new fs.t(this.C)).map(new UIThreadOffFunction(this)).subscribe(observer);
            i19 = i26 + 1;
            str = str4;
            format = str3;
            arrayList = arrayList2;
        }
        Iterator<u> it5 = this.D.iterator();
        while (it5.hasNext()) {
            it5.next().editVideoPublish();
        }
    }

    void h1(Intent intent, int i3, PublishParam publishParam, TribeVideoPublishParams tribeVideoPublishParams) {
        if (i3 != 11) {
            if (i3 != 12) {
                this.f67794m.finish(-1, intent, R.anim.dialog_exit, 0, true);
                return;
            } else {
                this.f67794m.finish(-1, intent, R.anim.dialog_exit, 0, true);
                return;
            }
        }
        int i16 = -1;
        String str = null;
        for (u uVar : this.D) {
            if (uVar instanceof com.tencent.aelight.camera.aioeditor.takevideo.b) {
                com.tencent.aelight.camera.aioeditor.takevideo.b bVar = (com.tencent.aelight.camera.aioeditor.takevideo.b) uVar;
                i16 = bVar.P0();
                str = bVar.getThemeName();
            }
        }
        intent.putExtra("theme_id", i16);
        intent.putExtra("theme_name", str);
        intent.putExtra(TribeVideoPublishParams.BUNDLE_EXTRA_KEY, tribeVideoPublishParams);
        if (QLog.isColorLevel()) {
            QLog.i("tribe_publish", 2, "getPublishIntent");
        }
        this.f67794m.finish(-1, intent, R.anim.dialog_exit, 0, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(List<u> list) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void y0(String str) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void p0(DialogInterface dialogInterface, int i3) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class e implements aj.b {
        e() {
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressCompleted(aj ajVar) {
            if (QLog.isColorLevel()) {
                QLog.i("Q.qqstory.publish.edit.EditVideoPartManager", 2, "[onProgressCompleted] hide ProgressPieDrawable ,ppd = " + ajVar);
            }
        }

        @Override // com.tencent.mobileqq.widget.aj.b
        public void onProgressChanged(aj ajVar, int i3, int i16) {
        }
    }

    public void Y0(String str, String str2, String str3, boolean z16) {
    }
}
