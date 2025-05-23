package com.tencent.aelight.camera.ae.flashshow.ui;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.opengl.GLSurfaceView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import androidx.activity.result.ActivityResultCaller;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.aelight.camera.ae.flashshow.AEFlashShowCameraUnit;
import com.tencent.aelight.camera.ae.flashshow.LSCameraGLSurfaceView;
import com.tencent.aelight.camera.ae.flashshow.ui.AEFlashCameraCaptureButtonLayout;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowBottomPanel;
import com.tencent.aelight.camera.ae.flashshow.view.FlashShowMusicButton;
import com.tencent.aelight.camera.struct.camera.material.AEMaterialMetaData;
import com.tencent.ams.dsdk.core.DKConfiguration;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.IQCircleABTestApi;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mobileqq.widget.ViewPagerCompat;
import com.tencent.mobileqq.widget.tip.QUIDefaultBubbleTip;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo;
import com.tencent.mobileqq.wink.editor.music.WinkEditorMusicHelper;
import com.tencent.mobileqq.wink.editor.music.adapter.MusicMenuPagerAdapter;
import com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.music.vo.Scene;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.request.QQWinkGetSmartMaterialMusicReq;
import com.tencent.mobileqq.wink.schema.SchemaHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import mqq.util.WeakReference;
import qqcircle.QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;
import qqcircle.QQCircleSmartMatchMusic$MusicInfoRsp;

@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 s2\u00020\u0001:\u0001tB\u001f\u0012\u0006\u0010m\u001a\u00020l\u0012\u0006\u0010n\u001a\u00020\u000e\u0012\u0006\u0010p\u001a\u00020o\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0012\u0010\f\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000eH\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0014J\b\u0010\u0019\u001a\u00020\u0002H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00108\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\f\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u001c\u0010A\u001a\b\u0012\u0004\u0012\u00020>0=8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0018\u0010D\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010F\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010CR\u0016\u0010I\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010K\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bJ\u0010CR\u0016\u0010M\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010HR\u0018\u0010Q\u001a\u0004\u0018\u00010N8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0018\u0010U\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010Y\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010^\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010[R\u001a\u0010b\u001a\u00020\u00048\u0006X\u0086D\u00a2\u0006\f\n\u0004\b_\u0010C\u001a\u0004\b`\u0010aR\u0016\u0010d\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bc\u0010HR\u0018\u0010h\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bf\u0010gR\u0018\u0010i\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010gR\u0014\u0010k\u001a\u00020\u00108BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b:\u0010j\u00a8\u0006u"}, d2 = {"Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMusicPart;", "Llq/a;", "", "O", "", "musicName", "musicId", "musicCategory", "j0", "l0", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "currentMusic", "I", "e0", "Landroid/view/View;", "v", "", ViewStickEventHelper.IS_SHOW, "f0", DKConfiguration.PreloadKeys.KEY_MATERIAL_ID, "g0", "d0", "view", "k0", "e", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/aelight/camera/ae/flashshow/AEFlashShowCameraUnit;", "unit", "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowBottomPanelViewModel;", "bottomPanelViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/dj;", "D", "Lcom/tencent/aelight/camera/ae/flashshow/ui/dj;", "musicViewModel", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ab;", "E", "Lcom/tencent/aelight/camera/ae/flashshow/ui/ab;", "captureViewModel", "Lcom/tencent/aelight/camera/ae/part/a;", UserInfo.SEX_FEMALE, "Lcom/tencent/aelight/camera/ae/part/a;", "stateViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "G", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/a;", "musicPlayerViewModel", "Lcom/tencent/aelight/camera/ae/e;", "H", "Lcom/tencent/aelight/camera/ae/e;", "mMaterialViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "musicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "J", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicVolumeControlViewModel;", "musicVolumeViewModel", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/wink/editor/music/adapter/MusicMenuPagerAdapter;", "K", "Lmqq/util/WeakReference;", "musicAdapter", "L", "Ljava/lang/String;", "tongKuanMusicMid", "M", "tongkuanMeterialid", "N", "Z", "hasChangeMeterialid", "P", "loadingMusicTitle", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "firstTimeCheckTongKuanMusicId", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowMusicButton;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowMusicButton;", "musicButton", "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowBottomPanel;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/aelight/camera/ae/flashshow/view/FlashShowBottomPanel;", "musicBottomPanel", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "T", "Lcom/tencent/mobileqq/widget/ViewPagerCompat;", "viewPager", "U", "Landroid/view/View;", "musicTab", "V", "volumeTab", "W", "getKEY_ATTRS", "()Ljava/lang/String;", "KEY_ATTRS", "X", "isMaterialPanelOpen", "Landroid/view/View$OnClickListener;", "Y", "Landroid/view/View$OnClickListener;", "flashButtonClickListener", "closeButtonListener", "()Z", "needMaterialMusic", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Llq/b;", "partManager", "<init>", "(Landroid/app/Activity;Landroid/view/View;Llq/b;)V", "a0", "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class AEFlashShowMusicPart extends lq.a {

    /* renamed from: C, reason: from kotlin metadata */
    private AEFlashShowBottomPanelViewModel bottomPanelViewModel;

    /* renamed from: D, reason: from kotlin metadata */
    private dj musicViewModel;

    /* renamed from: E, reason: from kotlin metadata */
    private ab captureViewModel;

    /* renamed from: F, reason: from kotlin metadata */
    private com.tencent.aelight.camera.ae.part.a stateViewModel;

    /* renamed from: G, reason: from kotlin metadata */
    private com.tencent.mobileqq.wink.editor.music.viewmodel.a musicPlayerViewModel;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.aelight.camera.ae.e mMaterialViewModel;

    /* renamed from: I, reason: from kotlin metadata */
    private MusicSourceViewModel musicSourceViewModel;

    /* renamed from: J, reason: from kotlin metadata */
    private MusicVolumeControlViewModel musicVolumeViewModel;

    /* renamed from: K, reason: from kotlin metadata */
    private WeakReference<MusicMenuPagerAdapter> musicAdapter;

    /* renamed from: L, reason: from kotlin metadata */
    private String tongKuanMusicMid;

    /* renamed from: M, reason: from kotlin metadata */
    private String tongkuanMeterialid;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean hasChangeMeterialid;

    /* renamed from: P, reason: from kotlin metadata */
    private String loadingMusicTitle;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean firstTimeCheckTongKuanMusicId;

    /* renamed from: R, reason: from kotlin metadata */
    private FlashShowMusicButton musicButton;

    /* renamed from: S, reason: from kotlin metadata */
    private FlashShowBottomPanel musicBottomPanel;

    /* renamed from: T, reason: from kotlin metadata */
    private ViewPagerCompat viewPager;

    /* renamed from: U, reason: from kotlin metadata */
    private View musicTab;

    /* renamed from: V, reason: from kotlin metadata */
    private View volumeTab;

    /* renamed from: W, reason: from kotlin metadata */
    private final String KEY_ATTRS;

    /* renamed from: X, reason: from kotlin metadata */
    private boolean isMaterialPanelOpen;

    /* renamed from: Y, reason: from kotlin metadata */
    private View.OnClickListener flashButtonClickListener;

    /* renamed from: Z, reason: from kotlin metadata */
    private View.OnClickListener closeButtonListener;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final AEFlashShowCameraUnit unit;

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/aelight/camera/ae/flashshow/ui/AEFlashShowMusicPart$b", "Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicSelectFragment$c;", "", "pause", "play", "", "position", InnerAudioPlugin.AUDIO_OPERATE_SEEK, "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b implements MusicSelectFragment.c {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.c
        public void pause() {
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = AEFlashShowMusicPart.this.musicPlayerViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
                aVar = null;
            }
            aVar.P1();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.c
        public void play() {
            WeakReference weakReference = AEFlashShowMusicPart.this.musicAdapter;
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = null;
            if (weakReference == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
                weakReference = null;
            }
            MusicMenuPagerAdapter musicMenuPagerAdapter = (MusicMenuPagerAdapter) weakReference.get();
            Fragment item = musicMenuPagerAdapter != null ? musicMenuPagerAdapter.getItem(0) : null;
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment");
            if (((MusicSelectFragment) item).getExpand()) {
                com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = AEFlashShowMusicPart.this.musicPlayerViewModel;
                if (aVar2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
                } else {
                    aVar = aVar2;
                }
                aVar.O1();
            }
        }

        @Override // com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment.c
        public void seek(int position) {
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = AEFlashShowMusicPart.this.musicPlayerViewModel;
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = null;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
                aVar = null;
            }
            aVar.N1(position);
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar3 = AEFlashShowMusicPart.this.musicPlayerViewModel;
            if (aVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            } else {
                aVar2 = aVar3;
            }
            aVar2.O1();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AEFlashShowMusicPart(Activity activity, View rootView, lq.b partManager) {
        super(activity, rootView, partManager);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        Intrinsics.checkNotNullParameter(partManager, "partManager");
        Object b16 = partManager.b(65537, new Object[0]);
        Intrinsics.checkNotNullExpressionValue(b16, "partManager.get(VSCaptur\u2026.MANAGER_GET_ACTION_UNIT)");
        this.unit = (AEFlashShowCameraUnit) b16;
        this.loadingMusicTitle = "\u9009\u62e9\u97f3\u4e50";
        this.firstTimeCheckTongKuanMusicId = true;
        this.KEY_ATTRS = "key_attrs";
    }

    private final void I(WinkEditorMusicInfo currentMusic) {
        boolean z16;
        String p16;
        if (o83.b.f422214a.a()) {
            String str = this.tongKuanMusicMid;
            if (str != null) {
                if (str.length() > 0) {
                    z16 = true;
                    if (z16 || !this.firstTimeCheckTongKuanMusicId) {
                    }
                    if (currentMusic != null && (p16 = currentMusic.p()) != null) {
                        if ((p16.length() > 0) && !Intrinsics.areEqual(p16, this.tongKuanMusicMid)) {
                            com.tencent.aelight.camera.ae.flashshow.util.u uVar = com.tencent.aelight.camera.ae.flashshow.util.u.f65126a;
                            String string = BaseApplication.getContext().getString(R.string.y0o);
                            Intrinsics.checkNotNullExpressionValue(string, "getContext()\n           \u2026nd_other_music_recommend)");
                            uVar.a(string, 0);
                        }
                    }
                    this.firstTimeCheckTongKuanMusicId = false;
                    return;
                }
            }
            z16 = false;
            if (z16) {
            }
        }
    }

    private final boolean J() {
        if (WinkContext.INSTANCE.d().u("QCIRCLE")) {
            ab abVar = this.captureViewModel;
            if (abVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
                abVar = null;
            }
            if (abVar.L1().getValue() == AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K(AEFlashShowMusicPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FlashShowMusicButton flashShowMusicButton = this$0.musicButton;
        MusicSourceViewModel musicSourceViewModel = null;
        if (flashShowMusicButton != null) {
            FlashShowMusicButton.d(flashShowMusicButton, null, 1, null);
        }
        MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
        if (musicSourceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        } else {
            musicSourceViewModel = musicSourceViewModel2;
        }
        musicSourceViewModel.y2();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L(AEFlashShowMusicPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MusicSourceViewModel musicSourceViewModel = this$0.musicSourceViewModel;
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = null;
        if (musicSourceViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel = null;
        }
        musicSourceViewModel.E3();
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this$0.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel2 = null;
        }
        ds value = aEFlashShowBottomPanelViewModel2.j2().getValue();
        boolean z16 = false;
        if (value != null && value.getShow()) {
            z16 = true;
        }
        this$0.isMaterialPanelOpen = z16;
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel3 = this$0.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
        } else {
            aEFlashShowBottomPanelViewModel = aEFlashShowBottomPanelViewModel3;
        }
        aEFlashShowBottomPanelViewModel.k2().postValue(Boolean.TRUE);
        this$0.e0();
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("xsp_xsj_fabuqi_qukushiyongxintuijian");
        ((IQCircleABTestApi) QRoute.api(IQCircleABTestApi.class)).reportExpExposure("exp_xsj_fabuqi_yinyuejieruqyinresou");
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M(AEFlashShowMusicPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPagerCompat viewPagerCompat = this$0.viewPager;
        if (viewPagerCompat != null) {
            viewPagerCompat.setCurrentItem(0);
        }
        View view2 = this$0.musicTab;
        if (view2 != null) {
            view2.setSelected(true);
        }
        View view3 = this$0.volumeTab;
        if (view3 != null) {
            view3.setSelected(false);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(AEFlashShowMusicPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewPagerCompat viewPagerCompat = this$0.viewPager;
        if (viewPagerCompat != null) {
            viewPagerCompat.setCurrentItem(1);
        }
        View view2 = this$0.musicTab;
        if (view2 != null) {
            view2.setSelected(false);
        }
        View view3 = this$0.volumeTab;
        if (view3 != null) {
            view3.setSelected(true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void O() {
        MusicSourceViewModel musicSourceViewModel;
        List emptyList;
        ArrayList arrayListOf;
        String str;
        ViewModel viewModel = com.tencent.aelight.camera.ae.n.a(this.unit).get(AEFlashShowBottomPanelViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "of(unit).get(AEFlashShow\u2026nelViewModel::class.java)");
        this.bottomPanelViewModel = (AEFlashShowBottomPanelViewModel) viewModel;
        ViewModel viewModel2 = com.tencent.aelight.camera.ae.n.a(this.unit).get(dj.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "of(unit).get(AEFlashShow\u2026sicViewModel::class.java)");
        this.musicViewModel = (dj) viewModel2;
        ViewModel viewModel3 = com.tencent.aelight.camera.ae.n.a(this.unit).get(ab.class);
        Intrinsics.checkNotNullExpressionValue(viewModel3, "of(unit).get(AEFlashShow\u2026odeViewModel::class.java)");
        this.captureViewModel = (ab) viewModel3;
        ViewModel viewModel4 = com.tencent.aelight.camera.ae.n.a(this.unit).get(com.tencent.aelight.camera.ae.part.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel4, "of(unit).get(AEVideoStor\u2026ateViewModel::class.java)");
        this.stateViewModel = (com.tencent.aelight.camera.ae.part.a) viewModel4;
        ViewModel viewModel5 = com.tencent.aelight.camera.ae.n.a(this.unit).get(com.tencent.aelight.camera.ae.e.class);
        Intrinsics.checkNotNullExpressionValue(viewModel5, "of(unit).get(AEMaterialViewModel::class.java)");
        this.mMaterialViewModel = (com.tencent.aelight.camera.ae.e) viewModel5;
        Activity A = this.unit.A();
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = null;
        final FragmentActivity fragmentActivity = A instanceof FragmentActivity ? (FragmentActivity) A : null;
        if (fragmentActivity == null) {
            return;
        }
        ViewModel viewModel6 = new ViewModelProvider(fragmentActivity).get(MusicSourceViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel6, "ViewModelProvider(activi\u2026rceViewModel::class.java)");
        this.musicSourceViewModel = (MusicSourceViewModel) viewModel6;
        ViewModel viewModel7 = new ViewModelProvider(fragmentActivity).get(MusicVolumeControlViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel7, "ViewModelProvider(activi\u2026rolViewModel::class.java)");
        this.musicVolumeViewModel = (MusicVolumeControlViewModel) viewModel7;
        Object systemService = this.f415377f.getSystemService("audio");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.media.AudioManager");
        ViewModel viewModel8 = new ViewModelProvider(fragmentActivity, new com.tencent.mobileqq.wink.editor.music.viewmodel.f((AudioManager) systemService, Scene.CAMERA)).get(com.tencent.mobileqq.wink.editor.music.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel8, "ViewModelProvider(activi\u2026yerViewModel::class.java)");
        this.musicPlayerViewModel = (com.tencent.mobileqq.wink.editor.music.viewmodel.a) viewModel8;
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel2 = null;
        }
        MediatorLiveData<Pair<PanelTag, Boolean>> e26 = aEFlashShowBottomPanelViewModel2.e2();
        AEFlashShowCameraUnit aEFlashShowCameraUnit = this.unit;
        final Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit> function1 = new Function1<Pair<? extends PanelTag, ? extends Boolean>, Unit>() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.AEFlashShowMusicPart$initViewModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends PanelTag, ? extends Boolean> pair) {
                invoke2((Pair<? extends PanelTag, Boolean>) pair);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Pair<? extends PanelTag, Boolean> pair) {
                AEFlashShowMusicPart.this.l0();
            }
        };
        e26.observe(aEFlashShowCameraUnit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ch
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.a0(Function1.this, obj);
            }
        });
        if (J()) {
            com.tencent.aelight.camera.ae.e eVar = this.mMaterialViewModel;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
                eVar = null;
            }
            eVar.P1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cl
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    AEFlashShowMusicPart.b0(AEFlashShowMusicPart.this, (com.tencent.aelight.camera.ae.r) obj);
                }
            });
        }
        MusicSourceViewModel musicSourceViewModel2 = this.musicSourceViewModel;
        if (musicSourceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel2 = null;
        }
        musicSourceViewModel2.P2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cm
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.c0(AEFlashShowMusicPart.this, fragmentActivity, (WinkEditorMusicInfo) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel3 = this.musicSourceViewModel;
        if (musicSourceViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel3 = null;
        }
        musicSourceViewModel3.I2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bu
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.P(AEFlashShowMusicPart.this, (Boolean) obj);
            }
        });
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel3 = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel3 = null;
        }
        aEFlashShowBottomPanelViewModel3.k2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bv
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.Q(AEFlashShowMusicPart.this, (Boolean) obj);
            }
        });
        dj djVar = this.musicViewModel;
        if (djVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicViewModel");
            djVar = null;
        }
        djVar.L1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bw
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.R(AEFlashShowMusicPart.this, (AEFlashShowMusicState) obj);
            }
        });
        ab abVar = this.captureViewModel;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
            abVar = null;
        }
        abVar.L1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bx
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.T(AEFlashShowMusicPart.this, (AEFlashCameraCaptureButtonLayout.Style) obj);
            }
        });
        com.tencent.aelight.camera.ae.part.a aVar = this.stateViewModel;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
            aVar = null;
        }
        aVar.M1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bz
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.U(AEFlashShowMusicPart.this, (Boolean) obj);
            }
        });
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar2 = this.musicPlayerViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar2 = null;
        }
        aVar2.L1().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ca
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.V(AEFlashShowMusicPart.this, (Integer) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel4 = this.musicSourceViewModel;
        if (musicSourceViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel4 = null;
        }
        musicSourceViewModel4.D2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cb
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.W(AEFlashShowMusicPart.this, (MusicInfoWrapper) obj);
            }
        });
        MusicSourceViewModel musicSourceViewModel5 = this.musicSourceViewModel;
        if (musicSourceViewModel5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            musicSourceViewModel5 = null;
        }
        musicSourceViewModel5.j3().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ci
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.X(AEFlashShowMusicPart.this, (List) obj);
            }
        });
        Intent intent = fragmentActivity.getIntent();
        Serializable serializableExtra = intent != null ? intent.getSerializableExtra(this.KEY_ATTRS) : null;
        final HashMap hashMap = serializableExtra instanceof HashMap ? (HashMap) serializableExtra : null;
        this.tongKuanMusicMid = hashMap != null ? (String) hashMap.get("music") : null;
        this.tongkuanMeterialid = hashMap != null ? (String) hashMap.get("meterial") : null;
        if (hashMap != null && (str = (String) hashMap.get(QCircleScheme.AttrQQPublish.MUSIC_LOADING_TITLE)) != null) {
            this.loadingMusicTitle = str;
        }
        if (!TextUtils.isEmpty(this.tongKuanMusicMid)) {
            MusicSourceViewModel musicSourceViewModel6 = this.musicSourceViewModel;
            if (musicSourceViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel6 = null;
            }
            musicSourceViewModel6.u4(true);
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(this.tongKuanMusicMid);
            WinkEditorMusicHelper.D(arrayListOf, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cj
                @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
                public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str2, Object obj) {
                    AEFlashShowMusicPart.Y(hashMap, this, baseRequest, z16, j3, str2, (QQCircleSmartMatchMusic$MusicInfoRsp) obj);
                }
            });
            FlashShowMusicButton flashShowMusicButton = this.musicButton;
            if (flashShowMusicButton != null) {
                flashShowMusicButton.f(false);
            }
            FlashShowMusicButton flashShowMusicButton2 = this.musicButton;
            if (flashShowMusicButton2 != null) {
                flashShowMusicButton2.setLoadingMusicTitle(this.loadingMusicTitle);
            }
        } else {
            MusicSourceViewModel musicSourceViewModel7 = this.musicSourceViewModel;
            if (musicSourceViewModel7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            } else {
                musicSourceViewModel = musicSourceViewModel7;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            MusicSourceViewModel.q3(musicSourceViewModel, emptyList, null, false, 4, null);
        }
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel4 = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
        } else {
            aEFlashShowBottomPanelViewModel = aEFlashShowBottomPanelViewModel4;
        }
        aEFlashShowBottomPanelViewModel.f2().observe(this.unit, new Observer() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ck
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                AEFlashShowMusicPart.Z(AEFlashShowMusicPart.this, (Boolean) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void P(AEFlashShowMusicPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            MusicSourceViewModel musicSourceViewModel = this$0.musicSourceViewModel;
            if (musicSourceViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            }
            this$0.I(musicSourceViewModel.P2().getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(AEFlashShowMusicPart this$0, Boolean show) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(show, "show");
        if (show.booleanValue()) {
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this$0.bottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                aEFlashShowBottomPanelViewModel = null;
            }
            AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this$0.bottomPanelViewModel;
            if (aEFlashShowBottomPanelViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                aEFlashShowBottomPanelViewModel2 = null;
            }
            aEFlashShowBottomPanelViewModel.p2(aEFlashShowBottomPanelViewModel2.k2());
            FlashShowBottomPanel flashShowBottomPanel = this$0.musicBottomPanel;
            if (flashShowBottomPanel != null) {
                flashShowBottomPanel.b();
            }
            View view = this$0.musicTab;
            if (view != null) {
                view.performClick();
            }
            com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this$0.musicPlayerViewModel;
            if (aVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
                aVar = null;
            }
            aVar.O1();
        } else {
            FlashShowBottomPanel flashShowBottomPanel2 = this$0.musicBottomPanel;
            if (flashShowBottomPanel2 != null) {
                flashShowBottomPanel2.a();
            }
            if (this$0.J() && this$0.isMaterialPanelOpen) {
                com.tencent.aelight.camera.ae.e eVar = this$0.mMaterialViewModel;
                if (eVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
                    eVar = null;
                }
                com.tencent.aelight.camera.ae.r value = eVar.P1().getValue();
                if ((value != null ? value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() : null) == null) {
                    this$0.d0();
                }
            }
            this$0.isMaterialPanelOpen = false;
        }
        FlashShowBottomPanel flashShowBottomPanel3 = this$0.musicBottomPanel;
        if (flashShowBottomPanel3 != null) {
            this$0.f0(flashShowBottomPanel3, show.booleanValue());
        }
        WeakReference<MusicMenuPagerAdapter> weakReference = this$0.musicAdapter;
        if (weakReference == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
            weakReference = null;
        }
        MusicMenuPagerAdapter musicMenuPagerAdapter = weakReference.get();
        ActivityResultCaller item = musicMenuPagerAdapter != null ? musicMenuPagerAdapter.getItem(0) : null;
        MusicSelectFragment musicSelectFragment = item instanceof MusicSelectFragment ? (MusicSelectFragment) item : null;
        if (musicSelectFragment == null) {
            return;
        }
        musicSelectFragment.Th(show.booleanValue());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R(final AEFlashShowMusicPart this$0, AEFlashShowMusicState aEFlashShowMusicState) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (aEFlashShowMusicState.getMusicOn()) {
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put("xsj_music_name", aEFlashShowMusicState.getTitle());
            HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params2, "params");
            params2.put("xsj_music_id", aEFlashShowMusicState.getMid());
            FlashShowMusicButton flashShowMusicButton = this$0.musicButton;
            if (flashShowMusicButton != null) {
                String title = aEFlashShowMusicState.getTitle();
                if (title == null) {
                    title = "\u64ad\u653e\u97f3\u4e50";
                }
                flashShowMusicButton.setMusicOn(title);
            }
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cc
                @Override // java.lang.Runnable
                public final void run() {
                    AEFlashShowMusicPart.S(AEFlashShowMusicPart.this);
                }
            });
            return;
        }
        FlashShowMusicButton flashShowMusicButton2 = this$0.musicButton;
        if (flashShowMusicButton2 != null) {
            flashShowMusicButton2.setMusicOff();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S(AEFlashShowMusicPart this$0) {
        AEMaterialMetaData aEMaterialMetaData;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.J()) {
            com.tencent.aelight.camera.ae.e eVar = this$0.mMaterialViewModel;
            String str = null;
            if (eVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
                eVar = null;
            }
            com.tencent.aelight.camera.ae.r value = eVar.P1().getValue();
            if (value != null && (aEMaterialMetaData = value.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String()) != null) {
                str = aEMaterialMetaData.f69050id;
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            com.tencent.mobileqq.wink.utils.ar arVar = com.tencent.mobileqq.wink.utils.ar.f326685a;
            if (arVar.c("material_recommend_key" + MobileQQ.sMobileQQ.getLastLoginUin(), true)) {
                FlashShowMusicButton flashShowMusicButton = this$0.musicButton;
                if (flashShowMusicButton != null) {
                    this$0.k0(flashShowMusicButton);
                }
                arVar.m("material_recommend_key" + MobileQQ.sMobileQQ.getLastLoginUin(), false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(AEFlashShowMusicPart this$0, AEFlashCameraCaptureButtonLayout.Style style) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(AEFlashShowMusicPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.l0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void V(AEFlashShowMusicPart this$0, Integer num) {
        int i3;
        MusicSourceViewModel musicSourceViewModel;
        WeakReference<MusicMenuPagerAdapter> weakReference;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WeakReference<MusicMenuPagerAdapter> weakReference2 = this$0.musicAdapter;
        if (weakReference2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
            weakReference2 = null;
        }
        MusicMenuPagerAdapter musicMenuPagerAdapter = weakReference2.get();
        if ((musicMenuPagerAdapter != null ? musicMenuPagerAdapter.getItem(0) : null) instanceof MusicSelectFragment) {
            long intValue = num.intValue();
            MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
            if (musicSourceViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel2 = null;
            }
            Integer startTimeInMs = musicSourceViewModel2.getStartTimeInMs();
            if (startTimeInMs == null) {
                MusicSourceViewModel musicSourceViewModel3 = this$0.musicSourceViewModel;
                if (musicSourceViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                    musicSourceViewModel3 = null;
                }
                MusicInfoWrapper value = musicSourceViewModel3.D2().getValue();
                startTimeInMs = value != null ? Integer.valueOf(value.getStartTime()) : null;
                if (startTimeInMs == null) {
                    MusicSourceViewModel musicSourceViewModel4 = this$0.musicSourceViewModel;
                    if (musicSourceViewModel4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                        musicSourceViewModel4 = null;
                    }
                    WinkEditorMusicInfo currentMusic = musicSourceViewModel4.getCurrentMusic();
                    startTimeInMs = currentMusic != null ? Integer.valueOf(currentMusic.s()) : null;
                    if (startTimeInMs == null) {
                        i3 = 0;
                        long j3 = intValue - i3;
                        long a16 = com.tencent.mobileqq.wink.editor.music.a.a(j3);
                        musicSourceViewModel = this$0.musicSourceViewModel;
                        if (musicSourceViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                            musicSourceViewModel = null;
                        }
                        if (musicSourceViewModel.getCurrentMusic() != null) {
                            com.tencent.mobileqq.wink.editor.music.lyric.e a17 = com.tencent.mobileqq.wink.editor.music.lyric.e.a();
                            MusicSourceViewModel musicSourceViewModel5 = this$0.musicSourceViewModel;
                            if (musicSourceViewModel5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                                musicSourceViewModel5 = null;
                            }
                            a17.e(a16, musicSourceViewModel5.getVideoDurationMs());
                        }
                        weakReference = this$0.musicAdapter;
                        if (weakReference == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
                            weakReference = null;
                        }
                        MusicMenuPagerAdapter musicMenuPagerAdapter2 = weakReference.get();
                        Fragment item = musicMenuPagerAdapter2 != null ? musicMenuPagerAdapter2.getItem(0) : null;
                        Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment");
                        ((MusicSelectFragment) item).Yh(j3 * 1000);
                    }
                }
            }
            i3 = startTimeInMs.intValue();
            long j36 = intValue - i3;
            long a162 = com.tencent.mobileqq.wink.editor.music.a.a(j36);
            musicSourceViewModel = this$0.musicSourceViewModel;
            if (musicSourceViewModel == null) {
            }
            if (musicSourceViewModel.getCurrentMusic() != null) {
            }
            weakReference = this$0.musicAdapter;
            if (weakReference == null) {
            }
            MusicMenuPagerAdapter musicMenuPagerAdapter22 = weakReference.get();
            if (musicMenuPagerAdapter22 != null) {
            }
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment");
            ((MusicSelectFragment) item).Yh(j36 * 1000);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(AEFlashShowMusicPart this$0, MusicInfoWrapper musicInfoWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.wink.editor.music.viewmodel.a aVar = this$0.musicPlayerViewModel;
        dj djVar = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicPlayerViewModel");
            aVar = null;
        }
        Intrinsics.checkNotNullExpressionValue(musicInfoWrapper, "musicInfoWrapper");
        aVar.Q1(musicInfoWrapper);
        MusicVolumeControlViewModel musicVolumeControlViewModel = this$0.musicVolumeViewModel;
        if (musicVolumeControlViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicVolumeViewModel");
            musicVolumeControlViewModel = null;
        }
        musicVolumeControlViewModel.n2(musicInfoWrapper.getMusicInfo() != null, false);
        if (musicInfoWrapper.getMusicInfo() == null) {
            dj djVar2 = this$0.musicViewModel;
            if (djVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicViewModel");
            } else {
                djVar = djVar2;
            }
            djVar.L1().postValue(new AEFlashShowMusicState(false, null, null, null, 14, null));
            this$0.j0("", "", "");
            return;
        }
        dj djVar3 = this$0.musicViewModel;
        if (djVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicViewModel");
            djVar3 = null;
        }
        MutableLiveData<AEFlashShowMusicState> L1 = djVar3.L1();
        WinkEditorMusicInfo musicInfo = musicInfoWrapper.getMusicInfo();
        String p16 = musicInfo != null ? musicInfo.p() : null;
        WinkEditorMusicInfo musicInfo2 = musicInfoWrapper.getMusicInfo();
        L1.postValue(new AEFlashShowMusicState(true, p16, musicInfo2 != null ? musicInfo2.q() : null, null, 8, null));
        WinkEditorMusicInfo musicInfo3 = musicInfoWrapper.getMusicInfo();
        Intrinsics.checkNotNull(musicInfo3);
        String q16 = musicInfo3.q();
        Intrinsics.checkNotNullExpressionValue(q16, "musicInfoWrapper.musicInfo!!.songName");
        WinkEditorMusicInfo musicInfo4 = musicInfoWrapper.getMusicInfo();
        Intrinsics.checkNotNull(musicInfo4);
        String p17 = musicInfo4.p();
        Intrinsics.checkNotNullExpressionValue(p17, "musicInfoWrapper.musicInfo!!.songMid");
        WinkEditorMusicInfo musicInfo5 = musicInfoWrapper.getMusicInfo();
        Intrinsics.checkNotNull(musicInfo5);
        String str = musicInfo5.E;
        Intrinsics.checkNotNullExpressionValue(str, "musicInfoWrapper.musicInfo!!.categoryName");
        this$0.j0(q16, p17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(AEFlashShowMusicPart this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.aelight.camera.ae.part.a aVar = this$0.stateViewModel;
        MusicSourceViewModel musicSourceViewModel = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
            aVar = null;
        }
        w53.b.f("AEFlashShowMusicPart", "[observe] capturingLiveData:" + aVar.N1().getValue());
        com.tencent.aelight.camera.ae.part.a aVar2 = this$0.stateViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
            aVar2 = null;
        }
        if (Intrinsics.areEqual(aVar2.N1().getValue(), Boolean.TRUE)) {
            FlashShowMusicButton flashShowMusicButton = this$0.musicButton;
            if (flashShowMusicButton != null) {
                flashShowMusicButton.setMusicOff();
                return;
            }
            return;
        }
        MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
        if (musicSourceViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
        } else {
            musicSourceViewModel = musicSourceViewModel2;
        }
        musicSourceViewModel.f4();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y(HashMap hashMap, AEFlashShowMusicPart this$0, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleSmartMatchMusic$MusicInfoRsp qQCircleSmartMatchMusic$MusicInfoRsp) {
        MusicSourceViewModel musicSourceViewModel;
        List emptyList;
        Object orNull;
        VsMusicItemInfo j16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQCircleSmartMatchMusic$MusicInfoRsp != null) {
            List<WinkEditorMusicInfo> queriedMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$MusicInfoRsp.musicListInfo.get()), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350");
            if (Intrinsics.areEqual(hashMap != null ? (String) hashMap.get(QCircleScheme.AttrQQPublish.MUSIC_COMPLETE) : null, "1")) {
                Intrinsics.checkNotNullExpressionValue(queriedMusicList, "queriedMusicList");
                orNull = CollectionsKt___CollectionsKt.getOrNull(queriedMusicList, 0);
                WinkEditorMusicInfo winkEditorMusicInfo = (WinkEditorMusicInfo) orNull;
                if (winkEditorMusicInfo != null && (j16 = winkEditorMusicInfo.j()) != null) {
                    int i3 = j16.musicDuration;
                    int i16 = j16.musicStart;
                    int i17 = i3 - i16;
                    ms.a.f("AEFlashShowMusicPart", "make music complete, durationMs: " + i17 + ContainerUtils.KEY_VALUE_DELIMITER + i3 + "-" + i16);
                    long j17 = (long) i17;
                    MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
                    if (musicSourceViewModel2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                        musicSourceViewModel2 = null;
                    }
                    if (j17 > musicSourceViewModel2.getVideoDurationMs()) {
                        MusicSourceViewModel musicSourceViewModel3 = this$0.musicSourceViewModel;
                        if (musicSourceViewModel3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                            musicSourceViewModel3 = null;
                        }
                        musicSourceViewModel3.z4(j17);
                    }
                }
            }
            MusicSourceViewModel musicSourceViewModel4 = this$0.musicSourceViewModel;
            if (musicSourceViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                musicSourceViewModel = null;
            } else {
                musicSourceViewModel = musicSourceViewModel4;
            }
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            MusicSourceViewModel.q3(musicSourceViewModel, emptyList, queriedMusicList, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z(AEFlashShowMusicPart this$0, Boolean bool) {
        FlashShowMusicButton flashShowMusicButton;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (bool.booleanValue() || (flashShowMusicButton = this$0.musicButton) == null) {
            return;
        }
        flashShowMusicButton.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(AEFlashShowMusicPart this$0, com.tencent.aelight.camera.ae.r rVar) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MusicSourceViewModel musicSourceViewModel = null;
        if ((rVar != null ? rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String() : null) == null) {
            MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
            if (musicSourceViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
            } else {
                musicSourceViewModel = musicSourceViewModel2;
            }
            musicSourceViewModel.y2();
            return;
        }
        String str = rVar.getCom.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts.KEY_MATERIAL java.lang.String().f69050id;
        if (str != null) {
            if (Intrinsics.areEqual(str, this$0.tongkuanMeterialid)) {
                String str2 = this$0.tongKuanMusicMid;
                if (!(str2 == null || str2.length() == 0) && !this$0.hasChangeMeterialid) {
                    return;
                }
            }
            this$0.hasChangeMeterialid = true;
            this$0.g0(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(AEFlashShowMusicPart this$0, FragmentActivity activity, WinkEditorMusicInfo winkEditorMusicInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        GLSurfaceView F = this$0.unit.F();
        LSCameraGLSurfaceView lSCameraGLSurfaceView = F instanceof LSCameraGLSurfaceView ? (LSCameraGLSurfaceView) F : null;
        if (lSCameraGLSurfaceView != null) {
            lSCameraGLSurfaceView.setMusic(winkEditorMusicInfo != null);
        }
        SchemaHelper.f326270a.e(activity, winkEditorMusicInfo);
    }

    private final void d0() {
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
        if (aEFlashShowBottomPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel = null;
        }
        MutableLiveData<ds> j26 = aEFlashShowBottomPanelViewModel.j2();
        com.tencent.aelight.camera.ae.e eVar = this.mMaterialViewModel;
        if (eVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMaterialViewModel");
            eVar = null;
        }
        AEMaterialMetaData M1 = eVar.M1(4);
        j26.postValue(new ds(true, M1 != null ? M1.f69050id : null, null));
    }

    private final void e0() {
        FlashShowMusicButton flashShowMusicButton = this.musicButton;
        if (flashShowMusicButton == null) {
            return;
        }
        VideoReport.reportEvent("dt_clck", flashShowMusicButton, null);
    }

    private final void f0(View v3, boolean isShow) {
        String str;
        HashMap<String, Object> e16 = com.tencent.aelight.camera.ae.flashshow.ab.c().e();
        Intrinsics.checkNotNullExpressionValue(e16, "g().generateElementParams()");
        VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_PANEL);
        if (isShow) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        VideoReport.reportEvent(str, v3, e16);
    }

    private final void g0(String materialId) {
        QQWinkGetSmartMaterialMusicReq qQWinkGetSmartMaterialMusicReq = new QQWinkGetSmartMaterialMusicReq(materialId);
        final long currentTimeMillis = System.currentTimeMillis();
        VSNetworkHelper.getInstance().sendRequest(qQWinkGetSmartMaterialMusicReq, new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cd
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                AEFlashShowMusicPart.i0(currentTimeMillis, this, baseRequest, z16, j3, str, (QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i0(long j3, AEFlashShowMusicPart this$0, BaseRequest baseRequest, boolean z16, long j16, String str, QQCircleSmartMatchMusic$GetSmartMaterialMusicRsp qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp) {
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField;
        List<QQCircleSmartMatchMusic$MusicInfo> list;
        PBRepeatMessageField<QQCircleSmartMatchMusic$MusicInfo> pBRepeatMessageField2;
        List<QQCircleSmartMatchMusic$MusicInfo> list2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        long currentTimeMillis = System.currentTimeMillis() - j3;
        MusicSourceViewModel musicSourceViewModel = null;
        QLog.i("AEFlashShowMusicPart", 1, "requestMaterialMusic isSuccess: +" + z16 + " +retCode: +" + j16 + " +errMsg: " + str + "cost time " + currentTimeMillis + "rsp.musics size: +" + ((qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp == null || (pBRepeatMessageField2 = qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.musics) == null || (list2 = pBRepeatMessageField2.get()) == null) ? null : Integer.valueOf(list2.size())));
        if (this$0.J() && j16 == 0 && z16) {
            boolean z17 = false;
            if ((qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp == null || (pBRepeatMessageField = qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.musics) == null || (list = pBRepeatMessageField.get()) == null || !(list.isEmpty() ^ true)) ? false : true) {
                MusicSourceViewModel musicSourceViewModel2 = this$0.musicSourceViewModel;
                if (musicSourceViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                    musicSourceViewModel2 = null;
                }
                if (musicSourceViewModel2.j3().getValue() != null && (!r7.isEmpty())) {
                    z17 = true;
                }
                if (z17) {
                    List<WinkEditorMusicInfo> queriedMusicList = WinkEditorMusicHelper.j(WinkEditorMusicHelper.l(qQCircleSmartMatchMusic$GetSmartMaterialMusicRsp.musics.get()), "FAKE_CATEGORY_RECOMMEND_ID", "\u63a8\u8350");
                    QLog.i("AEFlashShowMusicPart", 1, "requestMaterialMusic setMaterialReCommendMusic size" + queriedMusicList.size());
                    MusicSourceViewModel musicSourceViewModel3 = this$0.musicSourceViewModel;
                    if (musicSourceViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("musicSourceViewModel");
                    } else {
                        musicSourceViewModel = musicSourceViewModel3;
                    }
                    Intrinsics.checkNotNullExpressionValue(queriedMusicList, "queriedMusicList");
                    musicSourceViewModel.s4(queriedMusicList);
                    return;
                }
                return;
            }
        }
        FlashShowMusicButton flashShowMusicButton = this$0.musicButton;
        if (flashShowMusicButton != null) {
            flashShowMusicButton.setMusicOff();
        }
    }

    private final void j0(String musicName, String musicId, String musicCategory) {
        HashMap<String, Object> params = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_music_name", musicName);
        HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params2, "params");
        params2.put("xsj_music_id", musicId);
        HashMap<String, Object> params3 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params3, "params");
        params3.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, musicCategory);
        HashMap<String, Object> params4 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params4, "params");
        params4.put("xsj_custom_pgid", WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_PAGE);
    }

    private final void k0(View view) {
        com.tencent.mobileqq.widget.tip.a r16 = QUIDefaultBubbleTip.r(this.f415377f);
        r16.o0("\u5df2\u6839\u636e\u9053\u5177\u63a8\u8350\u97f3\u4e50");
        r16.m0(3);
        r16.k0(1);
        r16.R(0);
        r16.S(view);
        r16.n0(16);
        r16.s0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0067, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0.k2().getValue(), java.lang.Boolean.TRUE) == false) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void l0() {
        AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel = this.bottomPanelViewModel;
        com.tencent.aelight.camera.ae.part.a aVar = null;
        if (aEFlashShowBottomPanelViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
            aEFlashShowBottomPanelViewModel = null;
        }
        Pair<PanelTag, Boolean> value = aEFlashShowBottomPanelViewModel.e2().getValue();
        boolean z16 = true;
        if (value != null && value.getSecond().booleanValue()) {
            if (J()) {
                AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel2 = this.bottomPanelViewModel;
                if (aEFlashShowBottomPanelViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                    aEFlashShowBottomPanelViewModel2 = null;
                }
                Pair<PanelTag, Boolean> value2 = aEFlashShowBottomPanelViewModel2.e2().getValue();
                if ((value2 != null ? value2.getFirst() : null) == PanelTag.MATERIAL_PANEL) {
                    AEFlashShowBottomPanelViewModel aEFlashShowBottomPanelViewModel3 = this.bottomPanelViewModel;
                    if (aEFlashShowBottomPanelViewModel3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("bottomPanelViewModel");
                        aEFlashShowBottomPanelViewModel3 = null;
                    }
                }
            }
            z16 = false;
        }
        ab abVar = this.captureViewModel;
        if (abVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("captureViewModel");
            abVar = null;
        }
        if (abVar.L1().getValue() != AEFlashCameraCaptureButtonLayout.Style.VIDEO_STYLE) {
            z16 = false;
        }
        com.tencent.aelight.camera.ae.part.a aVar2 = this.stateViewModel;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateViewModel");
        } else {
            aVar = aVar2;
        }
        if (!Intrinsics.areEqual(aVar.M1().getValue(), Boolean.TRUE)) {
            z16 = false;
        }
        FlashShowMusicButton flashShowMusicButton = this.musicButton;
        if (flashShowMusicButton == null) {
            return;
        }
        flashShowMusicButton.setVisibility(z16 ? 0 : 8);
    }

    @Override // lq.a
    protected void e() {
        this.musicButton = (FlashShowMusicButton) this.f415376e.findViewById(R.id.rtw);
        View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.bt
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AEFlashShowMusicPart.K(AEFlashShowMusicPart.this, view);
            }
        };
        this.closeButtonListener = onClickListener;
        FlashShowMusicButton flashShowMusicButton = this.musicButton;
        if (flashShowMusicButton != null) {
            Intrinsics.checkNotNull(onClickListener);
            flashShowMusicButton.setCloseButtonListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.ce
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AEFlashShowMusicPart.L(AEFlashShowMusicPart.this, view);
            }
        };
        this.flashButtonClickListener = onClickListener2;
        FlashShowMusicButton flashShowMusicButton2 = this.musicButton;
        if (flashShowMusicButton2 != null) {
            flashShowMusicButton2.setOnClickListener(onClickListener2);
        }
        FlashShowMusicButton flashShowMusicButton3 = this.musicButton;
        if (flashShowMusicButton3 != null) {
            VideoReport.setElementId(flashShowMusicButton3, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_BUTTON);
            VideoReport.setElementParams(flashShowMusicButton3, com.tencent.aelight.camera.ae.flashshow.ab.c().e());
        }
        Activity A = this.unit.A();
        FragmentActivity fragmentActivity = A instanceof FragmentActivity ? (FragmentActivity) A : null;
        if (fragmentActivity == null) {
            return;
        }
        View findViewById = this.f415376e.findViewById(R.id.s1g);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026w_multi_unit_music_panel)");
        FlashShowBottomPanel flashShowBottomPanel = (FlashShowBottomPanel) ((ViewStub) findViewById).inflate().findViewById(R.id.f163722rn4);
        this.musicBottomPanel = flashShowBottomPanel;
        if (flashShowBottomPanel != null) {
            flashShowBottomPanel.setVisibility(8);
        }
        FlashShowBottomPanel flashShowBottomPanel2 = this.musicBottomPanel;
        this.viewPager = flashShowBottomPanel2 != null ? (ViewPagerCompat) flashShowBottomPanel2.findViewById(R.id.rn5) : null;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
        WeakReference<MusicMenuPagerAdapter> weakReference = new WeakReference<>(new MusicMenuPagerAdapter(supportFragmentManager, Scene.CAMERA, null, 4, null));
        this.musicAdapter = weakReference;
        ViewPagerCompat viewPagerCompat = this.viewPager;
        if (viewPagerCompat != null) {
            viewPagerCompat.setAdapter(weakReference.get());
        }
        ViewPagerCompat viewPagerCompat2 = this.viewPager;
        if (viewPagerCompat2 != null) {
            viewPagerCompat2.setScrollable(false);
        }
        WeakReference<MusicMenuPagerAdapter> weakReference2 = this.musicAdapter;
        if (weakReference2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
            weakReference2 = null;
        }
        MusicMenuPagerAdapter musicMenuPagerAdapter = weakReference2.get();
        if ((musicMenuPagerAdapter != null ? musicMenuPagerAdapter.getItem(0) : null) instanceof MusicSelectFragment) {
            WeakReference<MusicMenuPagerAdapter> weakReference3 = this.musicAdapter;
            if (weakReference3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("musicAdapter");
                weakReference3 = null;
            }
            MusicMenuPagerAdapter musicMenuPagerAdapter2 = weakReference3.get();
            Fragment item = musicMenuPagerAdapter2 != null ? musicMenuPagerAdapter2.getItem(0) : null;
            Intrinsics.checkNotNull(item, "null cannot be cast to non-null type com.tencent.mobileqq.wink.editor.music.fragments.MusicSelectFragment");
            ((MusicSelectFragment) item).Vh(new b());
        }
        FlashShowBottomPanel flashShowBottomPanel3 = this.musicBottomPanel;
        View findViewById2 = flashShowBottomPanel3 != null ? flashShowBottomPanel3.findViewById(R.id.f163721rn3) : null;
        this.musicTab = findViewById2;
        if (findViewById2 != null) {
            findViewById2.setSelected(true);
        }
        View view = this.musicTab;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cf
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    AEFlashShowMusicPart.M(AEFlashShowMusicPart.this, view2);
                }
            });
        }
        FlashShowBottomPanel flashShowBottomPanel4 = this.musicBottomPanel;
        View findViewById3 = flashShowBottomPanel4 != null ? flashShowBottomPanel4.findViewById(R.id.rn6) : null;
        this.volumeTab = findViewById3;
        if (findViewById3 != null) {
            findViewById3.setSelected(false);
        }
        View view2 = this.volumeTab;
        if (view2 != null) {
            view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.aelight.camera.ae.flashshow.ui.cg
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    AEFlashShowMusicPart.N(AEFlashShowMusicPart.this, view3);
                }
            });
        }
        View view3 = this.volumeTab;
        if (view3 != null) {
            com.tencent.mobileqq.wink.report.a.d(com.tencent.mobileqq.wink.report.a.f326259a, view3, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_VOLUME_BUTTON, null, ExposurePolicy.REPORT_NONE, null, null, null, 116, null);
        }
        O();
    }

    @Override // lq.a
    public void onDestroy() {
        super.onDestroy();
        try {
            ViewPagerCompat viewPagerCompat = this.viewPager;
            if (viewPagerCompat != null) {
                viewPagerCompat.setAdapter(null);
            }
        } catch (Exception e16) {
            ms.a.d("AEFlashShowMusicPart", "onDestroy viewPager setAdapter exception", e16);
        }
        this.flashButtonClickListener = null;
        this.closeButtonListener = null;
    }
}
