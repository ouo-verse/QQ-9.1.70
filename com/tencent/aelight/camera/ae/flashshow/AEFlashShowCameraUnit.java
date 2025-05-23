package com.tencent.aelight.camera.ae.flashshow;

import android.app.Activity;
import android.app.Dialog;
import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Outline;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.aekit.api.standard.filter.AEFilterManager;
import com.tencent.aelight.camera.ae.camera.ui.topbar.AEVideoStoryTopBarViewModel;
import com.tencent.aelight.camera.ae.download.AEResUtil;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.download.LSDownloadMaterialRunnable;
import com.tencent.aelight.camera.ae.flashshow.filter.LSFilterProcessTex;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowBottomPanelViewModel;
import com.tencent.aelight.camera.ae.flashshow.ui.LSCaptureController;
import com.tencent.aelight.camera.ae.flashshow.ui.captureButton.AbsLSCaptureButton;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.pref.api.IPrefRecorder;
import com.tencent.aelight.camera.struct.camera.AEPhotoCaptureResult;
import com.tencent.aelight.camera.struct.camera.AEVideoCaptureResult;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.QQPermissionFactory;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.extractor.FirstFramePreLoader;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.magicAvatar.model.MagicAvatarGenerateInfo;
import com.tencent.mobileqq.wink.magicstudio.MagicStudioCreationViewModel;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioUploadImgAndStyle;
import com.tencent.mobileqq.wink.model.AEDataToEditor;
import com.tencent.mobileqq.wink.model.InteractiveModel;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qcircle.weishi.module.publisher.entity.TemplateBean;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.util.LiuHaiUtils;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import jq.b;
import jq.d;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.light.AudioPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.MovieConfig;
import org.light.MovieController;
import org.light.RendererConfig;
import org.light.bean.WMElement;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;

/* compiled from: P */
/* loaded from: classes32.dex */
public class AEFlashShowCameraUnit extends LSMiddleCameraUnit {
    private boolean A1;
    private boolean B1;
    private boolean C1;
    private boolean D1;
    private boolean E1;
    private boolean F1;
    private LightEngine G1;
    private WinkEditorMusicInfo H1;
    private boolean I1;
    private MagicStudioPicStyle J1;
    private QQPermission K1;
    protected d.a L1;

    /* renamed from: t1, reason: collision with root package name */
    private AEFlashShowBottomPanelViewModel f63688t1;

    /* renamed from: u1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.part.a f63689u1;

    /* renamed from: v1, reason: collision with root package name */
    private com.tencent.aelight.camera.ae.flashshow.ui.ab f63690v1;

    /* renamed from: w1, reason: collision with root package name */
    private com.tencent.mobileqq.wink.editor.music.viewmodel.a f63691w1;

    /* renamed from: x1, reason: collision with root package name */
    private MusicSourceViewModel f63692x1;

    /* renamed from: y1, reason: collision with root package name */
    private MagicStudioCreationViewModel f63693y1;

    /* renamed from: z1, reason: collision with root package name */
    private Dialog f63694z1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements Observer<Boolean> {
        a() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            AEFlashShowCameraUnit.this.A1 = !bool.booleanValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class c implements b.InterfaceC10606b {
        c() {
        }

        @Override // jq.b.InterfaceC10606b
        public void a() {
            AEFlashShowCameraUnit.this.f63688t1.c2();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class d implements d.a {
        d() {
        }

        @Override // jq.d.a
        public void onDoubleTap() {
            if (!AEFlashShowCameraUnit.this.A1) {
                if (AEFlashShowCameraUnit.this.E1) {
                    ms.a.f(AEFlashShowCameraUnit.this.f63731f, "capturing status can not toggle camera");
                    return;
                } else {
                    AEFlashShowCameraUnit.this.m0();
                    return;
                }
            }
            ms.a.f(AEFlashShowCameraUnit.this.f63731f, "cut down status can not toggle camera");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        private int f63702d = 0;

        e() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int i3 = this.f63702d + 1;
            this.f63702d = i3;
            if (i3 > 1) {
                ViewTreeObserver viewTreeObserver = AEFlashShowCameraUnit.this.P0.getViewTreeObserver();
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnGlobalLayoutListener(this);
                }
            }
            com.tencent.aelight.camera.ae.util.h.e(new com.tencent.mobileqq.activity.richmedia.i(AEFlashShowCameraUnit.this.P0.getMeasuredWidth(), AEFlashShowCameraUnit.this.P0.getMeasuredHeight()));
            ms.a.f(AEFlashShowCameraUnit.this.f63731f, "mMaxPreviewSize set: " + com.tencent.aelight.camera.ae.util.h.a());
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class f extends QQPermission.BasePermissionsListener {
        f() {
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            AEFlashShowCameraUnit.this.c4();
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDenied(List<String> list, List<Integer> list2) {
            super.onDenied(list, list2);
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onDialogShow(PermissionRequestDialog permissionRequestDialog, List<String> list) {
            super.onDialogShow(permissionRequestDialog, list);
        }
    }

    public AEFlashShowCameraUnit(or.e eVar, or.d dVar, Bundle bundle) {
        super(eVar, dVar, bundle);
        this.A1 = false;
        this.B1 = false;
        this.C1 = false;
        this.D1 = false;
        this.E1 = false;
        this.F1 = false;
        this.L1 = new d();
    }

    private String A3() {
        String H3 = H3();
        String str = "";
        if (H3 != null && !H3.isEmpty()) {
            str = "" + H3;
        }
        String F3 = F3();
        if (F3 == null || F3.isEmpty()) {
            return str;
        }
        return str + F3;
    }

    private AEMaterialMetaData B3() {
        com.tencent.aelight.camera.ae.r value = this.Q0.P1().getValue();
        if (value == null || value.getType() != 4 || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
            return null;
        }
        AEMaterialMetaData aEMaterialMetaData = value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
        if (!TextUtils.isEmpty(aEMaterialMetaData.challengeTopic) && this.f63954y0.b(1114113, new Object[0]) != null && com.tencent.mobileqq.wink.model.b.f324006a.e(aEMaterialMetaData.challengeTopic)) {
            InteractiveModel interactiveModel = (InteractiveModel) this.f63954y0.b(1114113, new Object[0]);
            aEMaterialMetaData.challengeTopic = interactiveModel.getTagName();
            aEMaterialMetaData.challengeRotation = interactiveModel.getRotation();
            aEMaterialMetaData.challengeScale = interactiveModel.getScale();
            aEMaterialMetaData.challengePositionX = interactiveModel.getXAxisPercentage();
            aEMaterialMetaData.challengePositionY = interactiveModel.getYAxisPercentage();
            aEMaterialMetaData.challengeJoinsNums = interactiveModel.getJoinNums();
            ms.a.a(this.f63731f, "getCurrentDaoJuMaterial... challengeTopic model:" + interactiveModel);
        }
        return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String();
    }

    private String C3() {
        com.tencent.aelight.camera.ae.r value = this.Q0.P1().getValue();
        if (value == null || value.getType() != 4 || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
            return null;
        }
        return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f69050id;
    }

    private String D3() {
        com.tencent.aelight.camera.ae.r value = this.Q0.P1().getValue();
        if (value == null || value.getType() != 4 || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
            return null;
        }
        return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().showName;
    }

    private String E3() {
        com.tencent.aelight.camera.ae.r value = this.Q0.P1().getValue();
        if (value == null || value.getType() != 4 || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
            return null;
        }
        return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().topic;
    }

    private String F3() {
        com.tencent.aelight.camera.ae.r value = this.Q0.P1().getValue();
        if (value == null || value.getType() != 4 || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
            return null;
        }
        return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().content;
    }

    private AEDataToEditor G3() {
        if (this.f63954y0.b(1114113, new Object[0]) == null) {
            return null;
        }
        InteractiveModel interactiveModel = (InteractiveModel) this.f63954y0.b(1114113, new Object[0]);
        if (!com.tencent.mobileqq.wink.model.b.f324006a.e(interactiveModel.getTagName())) {
            return null;
        }
        AEDataToEditor aEDataToEditor = new AEDataToEditor(interactiveModel.getTagName(), interactiveModel.getRotation(), interactiveModel.getScale(), interactiveModel.getXAxisPercentage(), interactiveModel.getYAxisPercentage(), interactiveModel.getJoinNums());
        ms.a.f(this.f63731f, "getDataToEditor... challengeTopic model:" + aEDataToEditor);
        return aEDataToEditor;
    }

    private String H3() {
        com.tencent.aelight.camera.ae.r value = this.Q0.P1().getValue();
        if (value == null || value.getType() != 4 || value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() == null) {
            return null;
        }
        return value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().friendContent;
    }

    private MusicVolumeControlViewModel I3() {
        ComponentCallbacks2 A = A();
        if (A instanceof FragmentActivity) {
            return (MusicVolumeControlViewModel) new ViewModelProvider((ViewModelStoreOwner) A).get(MusicVolumeControlViewModel.class);
        }
        return (MusicVolumeControlViewModel) new ViewModelProvider(this).get(MusicVolumeControlViewModel.class);
    }

    private void K3() {
        this.f63688t1 = (AEFlashShowBottomPanelViewModel) com.tencent.aelight.camera.ae.n.a(this).get(AEFlashShowBottomPanelViewModel.class);
        this.f63689u1 = (com.tencent.aelight.camera.ae.part.a) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.part.a.class);
        this.f63690v1 = (com.tencent.aelight.camera.ae.flashshow.ui.ab) com.tencent.aelight.camera.ae.n.a(this).get(com.tencent.aelight.camera.ae.flashshow.ui.ab.class);
        com.tencent.mobileqq.wink.editor.music.viewmodel.f fVar = new com.tencent.mobileqq.wink.editor.music.viewmodel.f((AudioManager) A().getSystemService("audio"), Scene.CAMERA);
        final Activity A = A();
        if (A instanceof FragmentActivity) {
            FragmentActivity fragmentActivity = (FragmentActivity) A;
            this.f63692x1 = (MusicSourceViewModel) new ViewModelProvider(fragmentActivity).get(MusicSourceViewModel.class);
            this.f63691w1 = (com.tencent.mobileqq.wink.editor.music.viewmodel.a) new ViewModelProvider(fragmentActivity, fVar).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
        } else {
            this.f63692x1 = (MusicSourceViewModel) new ViewModelProvider(this).get(MusicSourceViewModel.class);
        }
        this.f63689u1.N1().observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCameraUnit.this.Q3((Boolean) obj);
            }
        });
        this.f63692x1.W2().observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.m
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCameraUnit.R3(A, (Integer) obj);
            }
        });
        this.f63692x1.D2().observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.n
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCameraUnit.this.S3((MusicInfoWrapper) obj);
            }
        });
        this.Q0.R1().observe(this, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.o
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowCameraUnit.this.r4(((Boolean) obj).booleanValue());
            }
        });
        this.f63688t1.f2().observe(this, new a());
    }

    private void L3() {
        Bundle bundle;
        Bundle bundle2 = this.Z;
        if (bundle2 != null && (bundle = bundle2.getBundle(AECameraConstants.FRAGMENT_EXTRA_DATA)) != null) {
            this.J1 = (MagicStudioPicStyle) bundle.getSerializable("magic_studio_pic_style");
        }
        MagicStudioCreationViewModel magicStudioCreationViewModel = (MagicStudioCreationViewModel) new ViewModelProvider(this).get(MagicStudioCreationViewModel.class);
        this.f63693y1 = magicStudioCreationViewModel;
        magicStudioCreationViewModel.u3(true);
        this.f63693y1.s3(true);
        this.f63693y1.t2(this, A(), this.D, new Function1() { // from class: com.tencent.aelight.camera.ae.flashshow.i
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                Unit T3;
                T3 = AEFlashShowCameraUnit.this.T3((MagicStudioCreationViewModel.b.GotoMultiSelect) obj);
                return T3;
            }
        }, new Function0() { // from class: com.tencent.aelight.camera.ae.flashshow.j
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit U3;
                U3 = AEFlashShowCameraUnit.this.U3();
                return U3;
            }
        }, new Function0() { // from class: com.tencent.aelight.camera.ae.flashshow.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                Unit V3;
                V3 = AEFlashShowCameraUnit.this.V3();
                return V3;
            }
        });
    }

    private boolean M3(WinkEditorMusicInfo winkEditorMusicInfo) {
        try {
            return new File(WinkEditorMusicHelper.o(winkEditorMusicInfo)).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O3() {
        ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.d
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCameraUnit.this.t3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P3() {
        if (!NetworkUtil.isNetworkAvailable()) {
            QQToast.makeText(BaseApplication.getContext(), "\u9b54\u6cd5\u5931\u7075\u5566\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5\uff5e", 0).show();
            E2();
            return;
        }
        String stringExtra = A().getIntent().getStringExtra(AECameraConstants.MAGIC_AVATAR_STYLE);
        if (stringExtra == null) {
            stringExtra = "";
        }
        ms.a.f("MagicAvatarCapture", "MAGIC_AVATAR_FRAGMENT_CAMERA_REQUEST_KEY");
        MagicAvatarGenerateInfo magicAvatarGenerateInfo = new MagicAvatarGenerateInfo();
        magicAvatarGenerateInfo.setOriginFilePath(this.Q.path);
        magicAvatarGenerateInfo.setOriginStyleName(stringExtra);
        k4(magicAvatarGenerateInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void Q3(Boolean bool) {
        if (bool.booleanValue()) {
            this.f63691w1.O1();
            LSFilterProcessTex.H0 = true;
            this.E1 = true;
        } else {
            this.f63691w1.P1();
            this.E1 = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void R3(Activity activity, Integer num) {
        QQToast.makeText(activity, 1, activity.getString(num.intValue()), 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit T3(MagicStudioCreationViewModel.b.GotoMultiSelect gotoMultiSelect) {
        l4(this.Y.c(), null, this.f63693y1.k3(A(), gotoMultiSelect, this.J1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit U3() {
        E2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit V3() {
        E2();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void W3(boolean z16) {
        d4(z16, this.Q, this.D1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void X3() {
        VideoEnvironment.loadAVCodecSo();
        LocalMediaInfo localMediaInfo = this.Q;
        final boolean z16 = (localMediaInfo == null || TextUtils.isEmpty(localMediaInfo.path) || !new com.tencent.aelight.camera.ae.flashshow.util.w(this.f63731f).a(this.Q)) ? false : true;
        boolean z17 = this.f63692x1.getCurrentMusic() != null;
        ms.a.f(this.f63731f, "decode video finish, hasMusicBgm = " + z17);
        if (z16) {
            FirstFramePreLoader.f320286a.o(this.Q);
        }
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.h
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCameraUnit.this.W3(z16);
            }
        });
    }

    private void b4() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.3
            @Override // java.lang.Runnable
            public void run() {
                View view = AEFlashShowCameraUnit.this.D;
                if (view != null) {
                    view.setOutlineProvider(new a());
                    AEFlashShowCameraUnit.this.D.setClipToOutline(true);
                }
            }

            /* compiled from: P */
            /* renamed from: com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit$3$a */
            /* loaded from: classes32.dex */
            class a extends ViewOutlineProvider {
                a() {
                }

                @Override // android.view.ViewOutlineProvider
                public void getOutline(View view, Outline outline) {
                    outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), 40.0f);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c4() {
        ms.a.f(this.f63731f, "all necessary permissions granted");
        this.f63729c0 = true;
        if (this.f63727a0) {
            ms.a.f(this.f63731f, "current activity resumed, try open camera");
            n0();
        }
    }

    private void g4(final AEMaterialMetaData aEMaterialMetaData, String str) {
        WinkEditorMusicHelper.D(new ArrayList(Arrays.asList(str)), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.aelight.camera.ae.flashshow.f
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                AEFlashShowCameraUnit.this.a4(aEMaterialMetaData, baseRequest, z16, j3, str2, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h4, reason: merged with bridge method [inline-methods] */
    public void N3(AEMaterialMetaData aEMaterialMetaData) {
        LSCaptureController lSCaptureController;
        if (u3(aEMaterialMetaData) || (lSCaptureController = this.f63953x0) == null) {
            return;
        }
        lSCaptureController.x(aEMaterialMetaData, this.I1);
        this.I1 = false;
        lq.b bVar = this.f63954y0;
        Object[] objArr = new Object[1];
        if (aEMaterialMetaData == null) {
            aEMaterialMetaData = AEMaterialMetaData.MATERIAL_NONE;
        }
        objArr[0] = aEMaterialMetaData;
        bVar.q(851970, objArr);
    }

    private void i4() {
        String str;
        if (A() != null) {
            str = A().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID);
        } else {
            str = "";
        }
        com.tencent.aelight.camera.aebase.b.g(str);
    }

    private void k4(MagicAvatarGenerateInfo magicAvatarGenerateInfo) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putParcelable(AECameraConstants.MAGIC_AVATAR_CAPTURE_INFO, magicAvatarGenerateInfo);
        intent.putExtras(bundle);
        A().setResult(-1, intent);
        A().finish();
    }

    private void l4(int i3, MagicStudioUploadImgAndStyle magicStudioUploadImgAndStyle, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putSerializable(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH, this.Q);
        if (magicStudioUploadImgAndStyle != null) {
            bundle2.putParcelable(AECameraConstants.FRAGMENT_CAMERA_RESULT_MAGIC_INFO, magicStudioUploadImgAndStyle);
        }
        if (bundle != null) {
            bundle2.putBundle(AECameraConstants.FRAGMENT_CAMERA_GOTO_MULTI_SELECT_INFO, bundle);
        }
        Bundle bundle3 = this.Z;
        if (bundle3 != null) {
            String string = bundle3.getString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION);
            if (string != null) {
                bundle2.putString(AECameraConstants.FRAGMENT_RETURN_SECOND_ACTION, string);
            }
            Bundle bundle4 = this.Z.getBundle(AECameraConstants.FRAGMENT_EXTRA_DATA);
            if (bundle4 != null) {
                bundle2.putAll(bundle4);
            }
        }
        if (((FragmentActivity) A()) != null) {
            ((FragmentActivity) A()).getSupportFragmentManager().setFragmentResult(String.valueOf(i3), bundle2);
            Fragment findFragmentByTag = ((FragmentActivity) A()).getSupportFragmentManager().findFragmentByTag("MAGIC_STUDIO_CAPTURE");
            if (findFragmentByTag == null) {
                ((FragmentActivity) A()).getSupportFragmentManager().popBackStack();
            } else {
                ((FragmentActivity) A()).getSupportFragmentManager().beginTransaction().remove(findFragmentByTag).commitAllowingStateLoss();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n4(AEMaterialMetaData aEMaterialMetaData, WinkEditorMusicInfo winkEditorMusicInfo) {
        if (u3(aEMaterialMetaData)) {
            return;
        }
        List<WinkEditorMusicInfo> value = this.f63692x1.N2().getValue();
        if (value != null) {
            Iterator<WinkEditorMusicInfo> it = value.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                WinkEditorMusicInfo next = it.next();
                if (next.o() == winkEditorMusicInfo.o()) {
                    winkEditorMusicInfo.D = next.D;
                    break;
                }
            }
        }
        MusicInfoWrapper value2 = this.f63692x1.D2().getValue();
        if (value2 == null || value2.getMusicInfo() == null) {
            this.H1 = winkEditorMusicInfo;
            this.f63692x1.M3(winkEditorMusicInfo, 0);
        }
        N3(aEMaterialMetaData);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r4(boolean z16) {
        LSCameraGLSurfaceView lSCameraGLSurfaceView = this.E;
        if (lSCameraGLSurfaceView != null) {
            if (z16) {
                lSCameraGLSurfaceView.setAudioPause();
            } else {
                lSCameraGLSurfaceView.setAudioStart();
            }
        }
    }

    private void s3() {
        com.tencent.aelight.camera.ae.flashshow.ui.ab abVar;
        MusicSourceViewModel musicSourceViewModel = this.f63692x1;
        boolean z16 = (musicSourceViewModel == null || musicSourceViewModel.D2().getValue() == null || this.f63692x1.D2().getValue().getMusicInfo() == null) ? false : true;
        if (z16 && (abVar = this.f63690v1) != null && abVar.f64707i.getValue() == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
            p4();
        }
        r4(z16);
    }

    private void s4() {
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.10
            @Override // java.lang.Runnable
            public void run() {
                if (AEFlashShowCameraUnit.this.f63734m.isFlashEnabled()) {
                    AEFlashShowCameraUnit aEFlashShowCameraUnit = AEFlashShowCameraUnit.this;
                    aEFlashShowCameraUnit.f63734m.turnFlash(aEFlashShowCameraUnit.A(), false);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t3() {
        final AEMaterialMetaData M1 = this.Q0.M1(4);
        if (u3(M1)) {
            return;
        }
        String w3 = w3(M1);
        if (u3(M1)) {
            return;
        }
        MusicInfoWrapper value = this.f63692x1.D2().getValue();
        if (!TextUtils.isEmpty(w3) && (value == null || value.getMusicInfo() == null)) {
            ms.a.f(this.f63731f, "apply material with bgm music id = " + w3);
            g4(M1, w3);
            return;
        }
        ms.a.f(this.f63731f, "apply material with no bgm music");
        Activity A = A();
        if (A != null) {
            A.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.e
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowCameraUnit.this.N3(M1);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean u3(AEMaterialMetaData aEMaterialMetaData) {
        if (com.tencent.aelight.camera.ae.flashshow.util.e.a(aEMaterialMetaData)) {
            return true;
        }
        if (com.tencent.aelight.camera.ae.flashshow.util.e.a(this.Q0.M1(4))) {
            return true;
        }
        return !TextUtils.equals(aEMaterialMetaData.f69050id, r0.f69050id);
    }

    private String w3(AEMaterialMetaData aEMaterialMetaData) {
        AudioPlaceHolder[] audioPlaceHolders;
        if (!com.tencent.aelight.camera.ae.d.t()) {
            ms.a.c(this.f63731f, "decodeMaterialBgmMusicId sdk is not ready ");
            return null;
        }
        try {
            String localPath = aEMaterialMetaData.getLocalPath();
            if (localPath.endsWith("/")) {
                localPath = localPath + TemplateBean.TEMPLATE_JSON;
            }
            LightAsset Load = LightAsset.Load(localPath, 100);
            if (this.G1 == null) {
                LightEngine.initAuth(A(), null, "lightsdk_qq", nq.a.b().a());
                LightEngine make = LightEngine.make(null, null, new RendererConfig(AEResUtil.s()));
                this.G1 = make;
                make.setConfig(MovieConfig.make());
            }
            MovieController assetForMovie = this.G1.setAssetForMovie(Load);
            if (assetForMovie == null || (audioPlaceHolders = assetForMovie.getAudioPlaceHolders()) == null || audioPlaceHolders.length <= 0) {
                return null;
            }
            return audioPlaceHolders[0].musicID;
        } catch (Exception e16) {
            ms.a.e(this.f63731f, e16);
            return null;
        }
    }

    private void x3(AEPhotoCaptureResult aEPhotoCaptureResult, int i3) {
        ms.a.f(this.f63731f, "directReturnResult--- " + i3);
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        this.Q = localMediaInfo;
        localMediaInfo.path = aEPhotoCaptureResult.filePath;
        localMediaInfo.mMimeType = "image/*";
        if (A() == null || !(A() instanceof FragmentActivity)) {
            return;
        }
        if (i3 != 101) {
            if (i3 == 102) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        AEFlashShowCameraUnit.this.P3();
                    }
                });
                return;
            } else {
                l4(i3, null, null);
                return;
            }
        }
        if (this.J1 != null) {
            if (com.tencent.mobileqq.wink.editor.util.h.f322638a.c()) {
                l4(this.Y.c(), null, MagicStudioCreationViewModel.INSTANCE.a(this.J1, this.Q, true));
            } else {
                this.f63693y1.p3(this.Q.path, this.J1, true, null, 0);
            }
        }
    }

    private void y3() {
        List<WMElement> wmGetEditableWMElements;
        AEFilterManager aEFilterManager = this.f63924f0;
        if (aEFilterManager == null || (wmGetEditableWMElements = aEFilterManager.wmGetEditableWMElements()) == null) {
            return;
        }
        for (WMElement wMElement : wmGetEditableWMElements) {
            if (WMElement.TYPE_CHECK_IN.equals(wMElement.type)) {
                wMElement.doCheckIn();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z3, reason: merged with bridge method [inline-methods] */
    public void Y3(AEMaterialMetaData aEMaterialMetaData, WinkEditorMusicInfo winkEditorMusicInfo) {
        if (u3(aEMaterialMetaData)) {
            return;
        }
        if (winkEditorMusicInfo == null) {
            N3(aEMaterialMetaData);
            return;
        }
        if (winkEditorMusicInfo.f321261h == 1) {
            ms.a.c(this.f63731f, "song is in downloading process, just ignore");
            return;
        }
        if (M3(winkEditorMusicInfo)) {
            ms.a.f(this.f63731f, "song is downloaded, apply directly");
            n4(aEMaterialMetaData, winkEditorMusicInfo);
        } else {
            ms.a.f(this.f63731f, "start download song...");
            WinkEditorMusicHelper.I(winkEditorMusicInfo, new b(aEMaterialMetaData, winkEditorMusicInfo));
            this.f63692x1.M3(winkEditorMusicInfo, 0);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected int I() {
        AEVideoStoryTopBarViewModel.Ratio ratio = AEVideoStoryTopBarViewModel.Ratio.FULL;
        this.V = ratio;
        return ratio.code;
    }

    public boolean J3() {
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(A(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM));
        return qQPermission != null && qQPermission.hasPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0 && qQPermission.hasPermission(QQPermissionConstants.Permission.WRITE_EXTERNAL_STORAGE) == 0;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    protected int L() {
        return R.layout.dnv;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void T1() {
        super.T1();
        this.f63950u0.b(new c());
        this.f63949t0 = new jq.d(this.L1);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void V1() {
        super.V1();
        K3();
        L3();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    public void Y() {
        ms.a.f(this.f63731f, "onPhotoCaptureStart---");
        P1();
        AbsLSCaptureButton absLSCaptureButton = this.F;
        if (absLSCaptureButton != null) {
            absLSCaptureButton.setVisibility(8);
        }
        this.f63954y0.q(196609, new Object[0]);
        if (this.f63734m.isFlashEnabled()) {
            o4(true);
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit
    public void a0() {
        if (this.f63732h.getActivity() != null) {
            Activity activity = this.f63732h.getActivity();
            boolean z16 = activity.checkSelfPermission(QQPermissionConstants.Permission.CAMERA) != 0;
            LinkedList linkedList = new LinkedList();
            if (z16) {
                linkedList.add(QQPermissionConstants.Permission.CAMERA);
            }
            if (linkedList.isEmpty()) {
                return;
            }
            QQPermission qQPermission = QQPermissionFactory.getQQPermission(activity, new BusinessConfig(QQPermissionConstants.Business.ID.GY_FLASH_SHOW_UNIT, QQPermissionConstants.Business.SCENE.GY_FLASH_SHOW_UNIT));
            this.K1 = qQPermission;
            if (qQPermission != null) {
                qQPermission.requestPermissions((String[]) linkedList.toArray(new String[0]), 2, new f());
            }
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void d1() {
        super.d1();
        this.f63689u1.O1().postValue(Boolean.TRUE);
        b4();
        if (mq.a.d().g(IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS) == 0) {
            return;
        }
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_POSITION, Integer.valueOf(com.tencent.aelight.camera.ae.flashshow.util.r.a()));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_EFFICIENCY_LVTM, Long.valueOf(mq.a.d().g(IPrefRecorder.MILESTONE_ON_SLEECT_CAMERA_IN_FS)));
        buildElementParams.put("xsj_actiontype", WinkDaTongReportConstant.ElementParamValue.XSJ_SHOOT_RENDER);
        buildElementParams.put("xsj_eid", WinkDaTongReportConstant.ElementParamValue.XSJ_CAMERA_EFFICIENCY_INFO);
        VideoReport.reportEvent("ev_xsj_camera_action", buildElementParams);
    }

    public void e4(int i3, String[] strArr, int[] iArr) {
        QQPermission qQPermission = this.K1;
        if (qQPermission != null) {
            qQPermission.onRequestPermissionResult(i3, strArr, iArr);
            this.K1 = null;
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void f1() {
        LiuHaiUtils.initLiuHaiScreenUI_Common(this.L, this.M, ViewUtils.dip2px(1.0f));
        this.L.setVisibility(8);
        this.M.setVisibility(8);
        View view = this.P0;
        if (view != null) {
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnGlobalLayoutListener(new e());
            }
        }
    }

    public void f4() {
        com.tencent.aelight.camera.ae.r value;
        com.tencent.aelight.camera.ae.e eVar = this.Q0;
        if (eVar == null || (value = eVar.P1().getValue()) == null || value.getType() == 1) {
            return;
        }
        this.f63953x0.w(null);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void j2(boolean z16, String str) {
        z1().g();
        s3();
        if (this.F1) {
            i4();
        }
        s4();
    }

    public void j4() {
        com.tencent.aelight.camera.ae.r value;
        com.tencent.aelight.camera.ae.e eVar = this.Q0;
        if (eVar == null || (value = eVar.P1().getValue()) == null || value.getType() == 1) {
            return;
        }
        this.f63953x0.w(value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String());
    }

    public void m4(String str) {
        this.f63954y0.q(983041, str);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public void n(int i3, int i16) {
        this.f63953x0.h();
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.6
            @Override // java.lang.Runnable
            public void run() {
                LiuHaiUtils.resetAllLiuHaiStatus();
                if (AEFlashShowCameraUnit.this.f63732h.R().get() != null) {
                    LiuHaiUtils.initLiuHaiProperty(AEFlashShowCameraUnit.this.f63732h.R().get());
                    AEFlashShowCameraUnit.this.f1();
                }
            }
        });
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected void n2() {
        if (this.F1) {
            return;
        }
        this.F1 = true;
        i4();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityPause() {
        super.onActivityPause();
        this.B1 = true;
        AEVideoStoryTopBarViewModel aEVideoStoryTopBarViewModel = this.f63945p1;
        if (aEVideoStoryTopBarViewModel != null) {
            this.A1 = false;
            aEVideoStoryTopBarViewModel.N1().postValue(Boolean.TRUE);
        }
        q4();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onActivityResume() {
        ms.a.a(this.f63731f, "onActivityResume ");
        super.onActivityResume();
        this.B1 = false;
        if (this.C1 && this.N != null) {
            ms.a.a(this.f63731f, "mAEVideoCaptureResult :" + this.N.mergedMp4FilePath);
            this.D1 = true;
            o4(true);
            Q1();
            onVideoCaptured(this.N);
        }
        this.C1 = false;
        ThreadManagerV2.excute(new LSDownloadMaterialRunnable(), 128, null, true);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.q
    public boolean onBackPressed() {
        if (this.f63688t1.o2()) {
            this.f63688t1.c2();
            return false;
        }
        return super.onBackPressed();
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.aebase.e, com.tencent.aelight.camera.ae.q
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.y
    public void onPhotoCaptured(AEPhotoCaptureResult aEPhotoCaptureResult) {
        String str;
        HashMap hashMap;
        ms.a.f(this.f63731f, "onPhotoCaptured--- [Type] Photo");
        this.P = aEPhotoCaptureResult;
        y3();
        if (aEPhotoCaptureResult != null) {
            ac acVar = this.Y;
            if (acVar != null && acVar.n()) {
                x3(aEPhotoCaptureResult, this.Y.c());
            } else {
                LocalMediaInfo localMediaInfo = new LocalMediaInfo();
                this.Q = localMediaInfo;
                localMediaInfo.path = aEPhotoCaptureResult.filePath;
                localMediaInfo.mMimeType = "image/*";
                Intent intent = A().getIntent();
                if (intent != null && (hashMap = (HashMap) intent.getSerializableExtra("key_attrs")) != null) {
                    str = (String) hashMap.get("music");
                } else {
                    str = "";
                }
                com.tencent.aelight.camera.ae.flashshow.util.b.f65103a.a(this.f63732h.getActivity(), 4097, this.Q, str, C3(), E3(), A3(), D3(), B3(), G3());
                FirstFramePreLoader.r(this.Q);
            }
        }
        s4();
        o4(false);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouch(view, motionEvent);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.y
    public void onVideoCaptureStart() {
        Q1();
        w2(8);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit.9
            @Override // java.lang.Runnable
            public void run() {
                AEFlashShowCameraUnit.this.f63953x0.i();
            }
        });
        this.f63954y0.q(196609, new Object[0]);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView.y
    public void onVideoCaptured(AEVideoCaptureResult aEVideoCaptureResult) {
        ms.a.f(this.f63731f, "onVideoCaptured--- [Type] Video" + this.B1);
        this.N = aEVideoCaptureResult;
        aEVideoCaptureResult.finishTimeMs = System.currentTimeMillis();
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        this.Q = localMediaInfo;
        localMediaInfo.path = aEVideoCaptureResult.videoMp4FilePath;
        localMediaInfo.mMimeType = "video/mp4";
        if (A() != null) {
            A().getIntent().getIntExtra(AECameraConstants.VIDEO_STORY_FROM_TYPE, 0);
        }
        s4();
        if (this.B1) {
            this.C1 = true;
            return;
        }
        if (nr.a.e(aEVideoCaptureResult.videoMp4FilePath) <= 0) {
            if (this.D1) {
                o4(false);
                E2();
                this.D1 = false;
            }
            this.F0 = false;
            this.f63689u1.N1().postValue(Boolean.FALSE);
            g();
            return;
        }
        mq.a.d().j(IPrefRecorder.MILESTONE_CAMERA_RECORD_JUMP_FLASH);
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.b
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCameraUnit.this.X3();
            }
        });
    }

    public void p4() {
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.f63691w1;
        if (aVar != null) {
            aVar.O1();
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit, com.tencent.aelight.camera.ae.flashshow.LSBaseCameraUnit, com.tencent.aelight.camera.ae.q
    public View q(ViewGroup viewGroup) {
        this.f63952w0 = new GestureDetector(A(), new g(), null, true);
        View q16 = super.q(viewGroup);
        h1(q16);
        return q16;
    }

    public void q4() {
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this.f63691w1;
        if (aVar != null) {
            aVar.P1();
        }
    }

    public void t4(double d16) {
        com.tencent.aelight.camera.ae.e eVar = this.Q0;
        if (eVar != null) {
            eVar.X1("makeup.strength", Double.toString(d16));
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected lq.b u1(ViewGroup viewGroup) {
        Activity A = A();
        if (viewGroup != null) {
            return new lq.b(A, viewGroup, this);
        }
        return super.u1(null);
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected boolean v1(AEMaterialMetaData aEMaterialMetaData, int i3, boolean z16) {
        if (this.H1 != null) {
            MusicInfoWrapper value = this.f63692x1.D2().getValue();
            if (value != null && value.getMusicInfo() != null && value.getMusicInfo().o() == this.H1.o()) {
                this.f63692x1.y2();
            }
            this.H1 = null;
        }
        if (i3 != 4 || com.tencent.aelight.camera.ae.flashshow.util.e.a(aEMaterialMetaData)) {
            return false;
        }
        this.I1 = z16;
        ms.a.f(this.f63731f, "custom apply material, id = " + aEMaterialMetaData.f69050id);
        this.f63934k0 = true;
        u2(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.p
            @Override // java.lang.Runnable
            public final void run() {
                AEFlashShowCameraUnit.this.O3();
            }
        });
        return true;
    }

    public boolean v3(QQPermission.BasePermissionsListener basePermissionsListener) {
        if (J3()) {
            return true;
        }
        QQPermission qQPermission = QQPermissionFactory.getQQPermission(A(), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_AIO_ALBUM, QQPermissionConstants.Business.SCENE.OPEN_AIO_ALBUM));
        if (qQPermission == null) {
            return false;
        }
        qQPermission.requestPermissions(QQPermissionConstants.Permission.GROUP_STORAGE, 2, basePermissionsListener);
        return false;
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    protected boolean x1() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class b implements WinkEditorMusicHelper.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ AEMaterialMetaData f63697a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WinkEditorMusicInfo f63698b;

        b(AEMaterialMetaData aEMaterialMetaData, WinkEditorMusicInfo winkEditorMusicInfo) {
            this.f63697a = aEMaterialMetaData;
            this.f63698b = winkEditorMusicInfo;
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.b
        public void a(WinkEditorMusicInfo winkEditorMusicInfo, final boolean z16, String str) {
            ms.a.f(AEFlashShowCameraUnit.this.f63731f, "song download finish, success = " + z16);
            if (AEFlashShowCameraUnit.this.u3(this.f63697a)) {
                return;
            }
            Activity A = AEFlashShowCameraUnit.this.A();
            final AEMaterialMetaData aEMaterialMetaData = this.f63697a;
            final WinkEditorMusicInfo winkEditorMusicInfo2 = this.f63698b;
            A.runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.q
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowCameraUnit.b.this.d(z16, aEMaterialMetaData, winkEditorMusicInfo2);
                }
            });
        }

        @Override // com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper.b
        public void b(WinkEditorMusicInfo winkEditorMusicInfo, int i3) {
            ms.a.f(AEFlashShowCameraUnit.this.f63731f, "song download update, progress = " + i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void d(boolean z16, AEMaterialMetaData aEMaterialMetaData, WinkEditorMusicInfo winkEditorMusicInfo) {
            if (z16) {
                AEFlashShowCameraUnit.this.n4(aEMaterialMetaData, winkEditorMusicInfo);
            } else {
                AEFlashShowCameraUnit.this.N3(aEMaterialMetaData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0024  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ void a4(final AEMaterialMetaData aEMaterialMetaData, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        final WinkEditorMusicInfo winkEditorMusicInfo;
        if (qQCircleSmartMatchMusic$MusicInfoRsp != null) {
            List<WinkEditorMusicInfo> j16 = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get()), "", "");
            if (!j16.isEmpty()) {
                winkEditorMusicInfo = j16.get(0);
                if (winkEditorMusicInfo == null) {
                    ms.a.f(this.f63731f, "request online music info success, songName" + winkEditorMusicInfo.q() + ", songUrl" + winkEditorMusicInfo.t() + ", songMid = " + winkEditorMusicInfo.p() + ", songStartTime = " + winkEditorMusicInfo.s() + ", songDuration = " + winkEditorMusicInfo.n());
                } else {
                    ms.a.f(this.f63731f, "request online music info fail");
                }
                if (A() == null) {
                    A().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.g
                        @Override // java.lang.Runnable
                        public final void run() {
                            AEFlashShowCameraUnit.this.Y3(aEMaterialMetaData, winkEditorMusicInfo);
                        }
                    });
                    return;
                }
                return;
            }
        }
        winkEditorMusicInfo = null;
        if (winkEditorMusicInfo == null) {
        }
        if (A() == null) {
        }
    }

    private void o4(boolean z16) {
        if (z16) {
            Activity activity = this.f63732h.getActivity();
            if (activity == null || activity.isFinishing()) {
                return;
            }
            if (this.f63694z1 == null) {
                ReportDialog reportDialog = new ReportDialog(activity, R.style.qZoneInputDialog);
                this.f63694z1 = reportDialog;
                reportDialog.setCancelable(false);
                this.f63694z1.setCanceledOnTouchOutside(false);
                this.f63694z1.setContentView(R.layout.f168383uh);
            }
            this.f63694z1.show();
            return;
        }
        Dialog dialog = this.f63694z1;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.f63694z1.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void S3(MusicInfoWrapper musicInfoWrapper) {
        WinkEditorMusicInfo musicInfo = musicInfoWrapper != null ? musicInfoWrapper.getMusicInfo() : null;
        if (this.H1 != musicInfo) {
            this.H1 = null;
        }
        r4(musicInfo != null);
    }

    private void h1(View view) {
        ConstraintLayout constraintLayout = (ConstraintLayout) view.findViewById(R.id.s2l);
        if (constraintLayout == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R.id.s2m);
        int a16 = com.tencent.videocut.utils.p.f384261d.a();
        com.tencent.videocut.utils.o oVar = com.tencent.videocut.utils.o.f384257a;
        if (oVar.c(view.getContext()) / oVar.d(view.getContext()) <= 1.7777778f) {
            int e16 = com.tencent.aelight.camera.ae.camera.ui.gallery.t.e(view.getContext());
            Resources resources = view.getContext().getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.f13159e);
            constraintLayout.setPadding(0, a16 + com.tencent.videocut.utils.e.f384236a.a(48.0f), 0, e16 + dimensionPixelSize + resources.getDimensionPixelSize(R.dimen.f13179g) + resources.getDimensionPixelSize(R.dimen.f13169f) + resources.getDimensionPixelSize(R.dimen.f13139c));
            ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) frameLayout.getLayoutParams();
            layoutParams.bottomToBottom = 0;
            layoutParams.dimensionRatio = null;
            return;
        }
        constraintLayout.setPadding(0, a16 + com.tencent.videocut.utils.e.f384236a.a(48.0f), 0, 0);
    }

    private void d4(boolean z16, LocalMediaInfo localMediaInfo, boolean z17) {
        ms.a.f(this.f63731f, "[onDecodeVideoInfo] success = " + z16 + " fromResume = " + z17 + " isCaptureFromResume = " + this.D1);
        this.F0 = false;
        this.f63689u1.N1().postValue(Boolean.FALSE);
        if (z17) {
            o4(false);
            E2();
            this.D1 = false;
        }
        if (localMediaInfo != null && z16) {
            ms.a.f(this.f63731f, "[onVideoCaptured] videoInfo = " + localMediaInfo.mDuration + "video path = " + localMediaInfo.path);
            WinkEditorMusicInfo currentMusic = this.f63692x1.getCurrentMusic();
            Float valueOf = Float.valueOf(0.0f);
            if (currentMusic != null) {
                valueOf = I3().T1().getValue();
            }
            Float f16 = valueOf;
            Integer m3 = currentMusic != null ? this.f63692x1.m3(currentMusic.p()) : null;
            ms.a.f(this.f63731f, "[onVideoCaptured] music:" + currentMusic);
            this.Q.mMediaType = 2;
            com.tencent.aelight.camera.ae.flashshow.util.b.f65103a.b(this.f63732h.getActivity(), 4097, localMediaInfo, currentMusic, m3, f16, C3(), E3(), A3(), D3(), B3(), G3());
            return;
        }
        onCaptureError(101);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    protected class g extends GestureDetector.SimpleOnGestureListener {
        protected g() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            AbsLSCaptureButton absLSCaptureButton = AEFlashShowCameraUnit.this.F;
            if (absLSCaptureButton == null || !absLSCaptureButton.c()) {
                if (AEFlashShowCameraUnit.this.A1) {
                    ms.a.a(AEFlashShowCameraUnit.this.f63731f, "can not switch tab when cutdown ");
                    return false;
                }
                if (motionEvent.getX() - motionEvent2.getX() > 110.0f) {
                    AEFlashShowCameraUnit.this.f63690v1.M1().postValue(AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE);
                } else if (motionEvent2.getX() - motionEvent.getX() > 110.0f) {
                    AEFlashShowCameraUnit.this.f63690v1.M1().postValue(AEFlashCameraCaptureButtonLayout.Style.PIC_STYLE);
                }
                return false;
            }
            ms.a.a(AEFlashShowCameraUnit.this.f63731f, "can not switch tab when capturing ");
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    public void denied() {
    }

    @Override // com.tencent.aelight.camera.ae.flashshow.LSMiddleCameraUnit
    public void grant() {
    }
}
