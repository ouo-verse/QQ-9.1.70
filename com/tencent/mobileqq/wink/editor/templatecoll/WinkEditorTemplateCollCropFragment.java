package com.tencent.mobileqq.wink.editor.templatecoll;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropTextureView;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorCropView;
import com.tencent.mobileqq.wink.editor.crop.WinkEditorTransformTextureView;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollCropFragment;
import com.tencent.mobileqq.wink.editor.templatecoll.ah;
import com.tencent.mobileqq.wink.editor.view.WinkSegClipView;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.QCircleCommonLoadingDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.util.UiThreadUtil;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00a3\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b*\u0001T\u0018\u0000 b2\u00020\u0001:\u0001cB\u0007\u00a2\u0006\u0004\b`\u0010aJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0002J\b\u0010\u0016\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0002H\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u0002H\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010!\u001a\u00020 H\u0014J\b\u0010\"\u001a\u00020\u001bH\u0016J\u001a\u0010%\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010#H\u0017J\b\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\u0010\u0010(\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020\u0002H\u0014J\b\u0010*\u001a\u00020\u0002H\u0016R#\u00101\u001a\n ,*\u0004\u0018\u00010+0+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u00100R\u0018\u00105\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010D\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u001d\u0010I\u001a\u0004\u0018\u00010E8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bF\u0010.\u001a\u0004\bG\u0010HR\u001b\u0010N\u001a\u00020J8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bK\u0010.\u001a\u0004\bL\u0010MR\u001b\u0010S\u001a\u00020O8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bP\u0010.\u001a\u0004\bQ\u0010RR\u0014\u0010W\u001a\u00020T8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bU\u0010VR\u0014\u0010[\u001a\u00020X8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bY\u0010ZR\u0014\u0010_\u001a\u00020\\8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b]\u0010^\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment;", "Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollAdjustFragment;", "", "initData", "mi", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Yh", "initView", "pi", "Landroid/view/View;", "view", "li", "Xh", "zi", "", "si", "ri", "ti", "", WidgetCacheLunarData.JI, "gi", "hi", WidgetCacheLunarData.YI, "xi", "Zh", "ai", "", "elementId", "bi", "di", "ci", "", "getContentLayoutId", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Ch", "Bh", "onDestroyView", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "kotlin.jvm.PlatformType", "M", "Lkotlin/Lazy;", "ki", "()Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Landroid/widget/ImageView;", "N", "Landroid/widget/ImageView;", "playerStatusBtn", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropView;", "P", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorCropView;", "cropView", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "J", "curVideoStartUs", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "segClipModel", "Landroid/view/Surface;", ExifInterface.LATITUDE_SOUTH, "Landroid/view/Surface;", "playerSurface", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView;", "T", "ii", "()Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView;", "segClipView", "Lcom/tencent/mobileqq/wink/editor/templatecoll/ah;", "U", "ei", "()Lcom/tencent/mobileqq/wink/editor/templatecoll/ah;", "cropViewModel", "Lcom/tencent/videocut/model/MediaClip;", "V", "fi", "()Lcom/tencent/videocut/model/MediaClip;", "originMediaClip", "com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$g", "W", "Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$g;", "surfaceTextureListener", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "X", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Y", "Lcom/tencent/tavcut/core/session/ISessionListener;", "renderListener", "<init>", "()V", "a0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorTemplateCollCropFragment extends WinkEditorTemplateCollAdjustFragment {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy timelineViewModel;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private ImageView playerStatusBtn;

    /* renamed from: P, reason: from kotlin metadata */
    private WinkEditorCropView cropView;

    /* renamed from: Q, reason: from kotlin metadata */
    private long curVideoStartUs;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private WinkSegClipView.SegClipModel segClipModel;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private Surface playerSurface;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final Lazy segClipView;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final Lazy cropViewModel;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy originMediaClip;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final g surfaceTextureListener;

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final ISessionListener renderListener;

    @NotNull
    public Map<Integer, View> Z = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$b", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f322471d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkEditorTemplateCollCropFragment f322472e;

        b(View view, WinkEditorTemplateCollCropFragment winkEditorTemplateCollCropFragment) {
            this.f322471d = view;
            this.f322472e = winkEditorTemplateCollCropFragment;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(16)
        public void onGlobalLayout() {
            this.f322471d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WinkEditorCropView winkEditorCropView = this.f322472e.cropView;
            WinkEditorCropView winkEditorCropView2 = null;
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            winkEditorCropView.setEnableAutoAdjust(false);
            WinkEditorCropView winkEditorCropView3 = this.f322472e.cropView;
            if (winkEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
            } else {
                winkEditorCropView2 = winkEditorCropView3;
            }
            winkEditorCropView2.getEditorGestureTextureView().setSurfaceTextureListener(this.f322472e.surfaceTextureListener);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$c", "Lcom/tencent/mobileqq/wink/editor/crop/WinkEditorTransformTextureView$b;", "Landroid/graphics/Matrix;", "matrix", "", "isChanged", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements WinkEditorTransformTextureView.b {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.editor.crop.WinkEditorTransformTextureView.b
        public void a(@NotNull Matrix matrix, boolean isChanged) {
            Intrinsics.checkNotNullParameter(matrix, "matrix");
            WinkEditorTemplateCollCropFragment.this.ki().b3();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$d", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$c;", "", "b", "", "startTimeUs", "a", "c", "timeUs", "e", "d", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements WinkSegClipView.c {
        d() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void a(long startTimeUs) {
            WinkEditorTemplateCollCropFragment.this.ki().o3(startTimeUs, WinkEditorTemplateCollCropFragment.this.ji());
            TimelineViewModelV2 timelineViewModel = WinkEditorTemplateCollCropFragment.this.ki();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, startTimeUs, false, false, 6, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void b() {
            WinkEditorTemplateCollCropFragment.this.ki().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void c() {
            WinkEditorTemplateCollCropFragment.this.ki().c3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void d() {
            WinkEditorTemplateCollCropFragment.this.ki().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void e(long timeUs) {
            TimelineViewModelV2 timelineViewModel = WinkEditorTemplateCollCropFragment.this.ki();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, timeUs, false, false, 6, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void f() {
            WinkEditorTemplateCollCropFragment.this.ki().c3();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$e", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e implements IPlayer.PlayerListener {
        e() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            WinkEditorTemplateCollCropFragment.this.ki().m2().postValue(Long.valueOf(currentDurationUs));
            WinkSegClipView ii5 = WinkEditorTemplateCollCropFragment.this.ii();
            if (ii5 != null) {
                ii5.z(currentDurationUs);
            }
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            ImageView imageView;
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (status == IPlayer.PlayerStatus.PLAYING) {
                ImageView imageView2 = WinkEditorTemplateCollCropFragment.this.playerStatusBtn;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.oqq);
                }
            } else if (status == IPlayer.PlayerStatus.PAUSED && (imageView = WinkEditorTemplateCollCropFragment.this.playerStatusBtn) != null) {
                imageView.setImageResource(R.drawable.oqs);
            }
            WinkEditorTemplateCollCropFragment.this.ki().l2().postValue(status);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$g", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/graphics/SurfaceTexture;", "surface", "", "width", "height", "", "onSurfaceTextureAvailable", "onSurfaceTextureSizeChanged", "", "onSurfaceTextureDestroyed", "onSurfaceTextureUpdated", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class g implements TextureView.SurfaceTextureListener {
        g() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            WinkEditorTemplateCollCropFragment.this.playerSurface = new Surface(surface);
            try {
                WinkEditorTemplateCollCropFragment.this.mi();
                WinkEditorTemplateCollCropFragment.this.initView();
            } catch (Exception e16) {
                w53.b.c("WinkEditorTemplateCollClipFragment", e16.toString());
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
            surface.release();
            Surface surface2 = WinkEditorTemplateCollCropFragment.this.playerSurface;
            if (surface2 != null) {
                surface2.release();
            }
            WinkEditorTemplateCollCropFragment.this.playerSurface = null;
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(@NotNull SurfaceTexture surface, int width, int height) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(@NotNull SurfaceTexture surface) {
            Intrinsics.checkNotNullParameter(surface, "surface");
        }
    }

    public WinkEditorTemplateCollCropFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TimelineViewModelV2>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollCropFragment$timelineViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TimelineViewModelV2 invoke() {
                return (TimelineViewModelV2) WinkEditorTemplateCollCropFragment.this.getViewModel(TimelineViewModelV2.class);
            }
        });
        this.timelineViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkSegClipView>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollCropFragment$segClipView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkSegClipView invoke() {
                View view = WinkEditorTemplateCollCropFragment.this.getView();
                if (view != null) {
                    return (WinkSegClipView) view.findViewById(R.id.f81914fg);
                }
                return null;
            }
        });
        this.segClipView = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<ah>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollCropFragment$cropViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final ah invoke() {
                return (ah) new ViewModelProvider(WinkEditorTemplateCollCropFragment.this.requireActivity()).get(ah.class);
            }
        });
        this.cropViewModel = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<MediaClip>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollCropFragment$originMediaClip$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final MediaClip invoke() {
                MediaClip mediaClip = (MediaClip) WinkEditorTemplateCollCropFragment.this.requireArguments().getParcelable("ARG_VIDEO_CLIP");
                return mediaClip == null ? new MediaClip(null, null, null, null, null, null, null, 127, null) : mediaClip;
            }
        });
        this.originMediaClip = lazy4;
        this.surfaceTextureListener = new g();
        this.playerListener = new e();
        this.renderListener = new f();
    }

    private final void Xh() {
        ah.CropInfo N1 = ei().N1(fi());
        if (N1 != null) {
            WinkEditorCropView winkEditorCropView = this.cropView;
            WinkEditorCropView winkEditorCropView2 = null;
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            winkEditorCropView.getEditorGestureTextureView().setTransform(N1.getCropViewMatrix());
            WinkEditorCropView winkEditorCropView3 = this.cropView;
            if (winkEditorCropView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView3 = null;
            }
            winkEditorCropView3.getEditorGestureTextureView().setCropRect(N1.getCropViewCropRect());
            WinkEditorCropView winkEditorCropView4 = this.cropView;
            if (winkEditorCropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
            } else {
                winkEditorCropView2 = winkEditorCropView4;
            }
            winkEditorCropView2.getMaskView().setCropViewRect(N1.getCropViewCropRect());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0057, code lost:
    
        r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final List<WinkEditData> Yh() {
        boolean z16;
        MediaClip mediaClip;
        List emptyList;
        List<WinkEditData> mutableListOf;
        BackgroundModel backgroundModel = new BackgroundModel(null, null, null, null, null, null, null, null, 0.0f, 0, null, 2047, null);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey("ARG_VIDEO_CLIP")) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            mediaClip = (MediaClip) requireArguments().getParcelable("ARG_VIDEO_CLIP");
            if (requireArguments().containsKey("ARG_BACKGROUND_MODEL")) {
                Parcelable parcelable = requireArguments().getParcelable("ARG_BACKGROUND_MODEL");
                Intrinsics.checkNotNull(parcelable, "null cannot be cast to non-null type com.tencent.videocut.model.BackgroundModel");
                backgroundModel = (BackgroundModel) parcelable;
            }
        } else {
            mediaClip = null;
        }
        if (mediaClip == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        MediaModel c16 = com.tencent.mobileqq.wink.editor.model.a.c(emptyList, backgroundModel, null, 4, null);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkEditData(c16, com.tencent.mobileqq.wink.editor.model.a.r(c16), null, null, null, null, false, null, null, null, null, null, true, null, null, null, false, null, 257920, null));
        return mutableListOf;
    }

    private final boolean Zh() {
        if (!ri() && !ti()) {
            return false;
        }
        return true;
    }

    private final void ai() {
        if (!Zh()) {
            super.Bh();
            return;
        }
        Intent intent = new Intent();
        WinkEditorCropView winkEditorCropView = this.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        intent.putExtra("ARG_CROP_RECT", winkEditorCropView.e());
        intent.putExtra("ARG_MEDIA_INDEX", getMediaIndex());
        intent.putExtra("ARG_VIDEO_START", hi());
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(100, 202, intent);
        }
        zi();
        Gh();
    }

    private final void bi(View view, String elementId) {
        VideoReport.setElementId(view, elementId);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
    }

    private final void ci(View view) {
        String str;
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        if (ri()) {
            str = "1";
        } else {
            str = "0";
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CUT, str);
        VideoReport.reportEvent("ev_xsj_camera_action", view, map);
    }

    private final void di(View view) {
        Object obj;
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        String str = "1";
        if (ti()) {
            obj = "1";
        } else {
            obj = "0";
        }
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_IS_VIDEO_LENGTH_ADJUST, obj);
        if (!ri()) {
            str = "0";
        }
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_IS_CUT, str);
        VideoReport.reportEvent("ev_xsj_camera_action", view, map);
    }

    private final ah ei() {
        return (ah) this.cropViewModel.getValue();
    }

    private final MediaClip fi() {
        return (MediaClip) this.originMediaClip.getValue();
    }

    private final long gi() {
        WinkSegClipView.SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null) {
            return segClipModel.getOriginStartTime();
        }
        return 0L;
    }

    private final long hi() {
        WinkSegClipView ii5 = ii();
        if (ii5 != null) {
            return ii5.k();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkSegClipView ii() {
        return (WinkSegClipView) this.segClipView.getValue();
    }

    private final void initData() {
        long j3;
        long j16 = requireArguments().getLong("ARG_VIDEO_SELECTION_DURATION");
        long j17 = requireArguments().getLong("ARG_VIDEO_START");
        this.curVideoStartUs = j17;
        MediaClip l3 = com.tencent.videocut.render.extension.e.l(fi());
        ResourceModel resourceModel = l3.resource;
        if (resourceModel != null) {
            j3 = resourceModel.sourceDuration;
        } else {
            j3 = 0;
        }
        this.segClipModel = new WinkSegClipView.SegClipModel(l3, 0.0f, j3, j16, j17, j17, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initView() {
        WinkSegClipView ii5;
        View view = null;
        if (!si()) {
            pi();
            View view2 = getView();
            if (view2 != null) {
                view = view2.findViewById(R.id.f164879u42);
            }
            bi(view, WinkDaTongReportConstant.ElementId.EM_XSJ_CAMERA_CUT_ADJUST_APPLY_BUTTON);
        } else {
            View view3 = getView();
            if (view3 != null) {
                view = view3.findViewById(R.id.f164879u42);
            }
            bi(view, WinkDaTongReportConstant.ElementId.EM_XSJ_PICTURE_CUT_BUTTON);
        }
        WinkSegClipView.SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null && (ii5 = ii()) != null) {
            ii5.setSegClipModel(segClipModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long ji() {
        WinkSegClipView.SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null) {
            return segClipModel.getSelectDuration();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelineViewModelV2 ki() {
        return (TimelineViewModelV2) this.timelineViewModel.getValue();
    }

    private final void li(View view) {
        View findViewById = view.findViewById(R.id.ubn);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.cropView)");
        WinkEditorCropView winkEditorCropView = (WinkEditorCropView) findViewById;
        this.cropView = winkEditorCropView;
        WinkEditorCropView winkEditorCropView2 = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        com.tencent.videocut.utils.e eVar = com.tencent.videocut.utils.e.f384236a;
        winkEditorCropView.setResPaddingLeft(eVar.a(32.0f));
        WinkEditorCropView winkEditorCropView3 = this.cropView;
        if (winkEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView3 = null;
        }
        winkEditorCropView3.setResPaddingRight(eVar.a(32.0f));
        if (si()) {
            WinkEditorCropView winkEditorCropView4 = this.cropView;
            if (winkEditorCropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView4 = null;
            }
            winkEditorCropView4.setResPaddingBottom(eVar.a(48.0f));
            WinkEditorCropView winkEditorCropView5 = this.cropView;
            if (winkEditorCropView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView5 = null;
            }
            winkEditorCropView5.setResPaddingTop(eVar.a(60.0f));
            WinkEditorCropView winkEditorCropView6 = this.cropView;
            if (winkEditorCropView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView6 = null;
            }
            winkEditorCropView6.setResBottomHeight(eVar.a(115.0f));
        } else {
            WinkEditorCropView winkEditorCropView7 = this.cropView;
            if (winkEditorCropView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView7 = null;
            }
            winkEditorCropView7.setResPaddingBottom(eVar.a(24.0f));
            WinkEditorCropView winkEditorCropView8 = this.cropView;
            if (winkEditorCropView8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView8 = null;
            }
            winkEditorCropView8.setResPaddingTop(eVar.a(52.0f));
            WinkEditorCropView winkEditorCropView9 = this.cropView;
            if (winkEditorCropView9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView9 = null;
            }
            winkEditorCropView9.setResBottomHeight(eVar.a(270.0f));
        }
        WinkEditorCropView winkEditorCropView10 = this.cropView;
        if (winkEditorCropView10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView10 = null;
        }
        winkEditorCropView10.getMaskView().setShowCropCornerTouchArea(false);
        int parseColor = Color.parseColor("#C0121212");
        WinkEditorCropView winkEditorCropView11 = this.cropView;
        if (winkEditorCropView11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView11 = null;
        }
        winkEditorCropView11.getMaskView().setDimmedColor(parseColor);
        WinkEditorCropView winkEditorCropView12 = this.cropView;
        if (winkEditorCropView12 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView12 = null;
        }
        winkEditorCropView12.getMaskView().setDimmedColorWhenTouch(parseColor);
        MediaClip mediaClip = (MediaClip) requireArguments().getParcelable("ARG_VIDEO_CLIP");
        if (mediaClip == null) {
            mediaClip = new MediaClip(null, null, null, null, null, null, null, 127, null);
        }
        WinkEditorCropView winkEditorCropView13 = this.cropView;
        if (winkEditorCropView13 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView13 = null;
        }
        winkEditorCropView13.setResourceSize(com.tencent.videocut.render.extension.e.o(mediaClip).width, com.tencent.videocut.render.extension.e.o(mediaClip).height);
        float f16 = requireArguments().getFloat("ARG_CROP_FRAME_ASPECT_RATIO", 0.5625f);
        WinkEditorCropView winkEditorCropView14 = this.cropView;
        if (winkEditorCropView14 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView14 = null;
        }
        winkEditorCropView14.getMaskView().setTargetAspectRatio(f16, 0);
        int i3 = requireArguments().getInt("ARG_CROP_FRAME_SCALE_MODE", 3);
        if (i3 == -1 || i3 == 2) {
            WinkEditorCropView winkEditorCropView15 = this.cropView;
            if (winkEditorCropView15 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
            } else {
                winkEditorCropView2 = winkEditorCropView15;
            }
            winkEditorCropView2.getEditorGestureTextureView().setScaleMode(WinkEditorCropTextureView.ScaleMode.LETTER_BOX);
        }
        view.getViewTreeObserver().addOnGlobalLayoutListener(new b(view, this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mi() {
        dr drVar;
        dr C2;
        WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
        List<WinkEditData> Yh = Yh();
        Boolean bool = Boolean.FALSE;
        WinkEditorCropView winkEditorCropView = this.cropView;
        WinkEditorCropView winkEditorCropView2 = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        int width = winkEditorCropView.getEditorGestureTextureView().getWidth();
        WinkEditorCropView winkEditorCropView3 = this.cropView;
        if (winkEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView3 = null;
        }
        int height = winkEditorCropView3.getEditorGestureTextureView().getHeight();
        Surface surface = this.playerSurface;
        Boolean isOpenFFmpegDecode = u53.i.f438428a;
        Intrinsics.checkNotNullExpressionValue(isOpenFFmpegDecode, "isOpenFFmpegDecode");
        boolean booleanValue = isOpenFFmpegDecode.booleanValue();
        Integer softDecodeThreadCnt = u53.i.f438429b;
        Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
        dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(false, editMode, Yh, null, bool, width, height, surface, null, booleanValue, softDecodeThreadCnt.intValue(), Long.MAX_VALUE, false, false, null, WinkTavCutScene.CollSeg, false, false, 0, 0, false, null, 4092160, null);
        TimelineViewModelV2 ki5 = ki();
        if (ki5 != null) {
            TimelineViewModelV2.S2(ki5, this, null, winkTavCutParams, this.playerListener, this.renderListener, true, false, true, 0L, null, 832, null);
        }
        ah ei5 = ei();
        TimelineViewModelV2 ki6 = ki();
        if (ki6 != null) {
            drVar = ki6.C2();
        } else {
            drVar = null;
        }
        Intrinsics.checkNotNull(drVar);
        ei5.O1(drVar);
        ei().P1(fi());
        TimelineViewModelV2 ki7 = ki();
        if (ki7 != null && (C2 = ki7.C2()) != null) {
            WinkEditorCropView winkEditorCropView4 = this.cropView;
            if (winkEditorCropView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView4 = null;
            }
            int width2 = winkEditorCropView4.getEditorGestureTextureView().getWidth();
            WinkEditorCropView winkEditorCropView5 = this.cropView;
            if (winkEditorCropView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView5 = null;
            }
            C2.P(width2, winkEditorCropView5.getEditorGestureTextureView().getHeight());
        }
        WinkEditorCropView winkEditorCropView6 = this.cropView;
        if (winkEditorCropView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView6 = null;
        }
        winkEditorCropView6.setEnableAutoAdjust(true);
        WinkEditorCropView winkEditorCropView7 = this.cropView;
        if (winkEditorCropView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView7 = null;
        }
        winkEditorCropView7.getEditorGestureTextureView().setImageToWrapCropMinBounds(false);
        Xh();
        zi();
        WinkEditorCropView winkEditorCropView8 = this.cropView;
        if (winkEditorCropView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
        } else {
            winkEditorCropView2 = winkEditorCropView8;
        }
        winkEditorCropView2.getEditorGestureTextureView().setTransformListener(new c());
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.aa
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorTemplateCollCropFragment.ni(WinkEditorTemplateCollCropFragment.this);
            }
        }, 800L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ni(final WinkEditorTemplateCollCropFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ki().b3();
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.ad
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorTemplateCollCropFragment.oi(WinkEditorTemplateCollCropFragment.this);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oi(WinkEditorTemplateCollCropFragment this$0) {
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkSegClipView ii5 = this$0.ii();
        if (ii5 != null) {
            j3 = ii5.k();
        } else {
            j3 = 0;
        }
        long j16 = j3;
        this$0.ki().o3(j16, this$0.ji());
        TimelineViewModelV2 timelineViewModel = this$0.ki();
        Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
        TimelineViewModelV2.g3(timelineViewModel, j16, false, false, 6, null);
        dr C2 = this$0.ki().C2();
        if (C2 != null) {
            C2.setAutoPlay(true);
        }
        this$0.ki().c3();
    }

    private final void pi() {
        ImageView imageView;
        View view = getView();
        if (view != null) {
            imageView = (ImageView) view.findViewById(R.id.f25790bs);
        } else {
            imageView = null;
        }
        this.playerStatusBtn = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.ab
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkEditorTemplateCollCropFragment.qi(WinkEditorTemplateCollCropFragment.this, view2);
                }
            });
        }
        WinkSegClipView ii5 = ii();
        if (ii5 != null) {
            ii5.setSegClipCallback(new d());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void qi(WinkEditorTemplateCollCropFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.ki().W2()) {
            this$0.ki().b3();
        } else {
            this$0.ki().c3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean ri() {
        ah ei5 = ei();
        MediaClip fi5 = fi();
        WinkEditorCropView winkEditorCropView = this.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        return ei5.M1(fi5, winkEditorCropView.e());
    }

    private final boolean si() {
        return requireArguments().getBoolean("ARG_IS_IMAGE_CLIP", false);
    }

    private final boolean ti() {
        if (Math.abs(hi() - gi()) > 10000) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ui(WinkEditorTemplateCollCropFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View cancelBtn = this$0.getCancelBtn();
        if (cancelBtn != null) {
            com.tencent.mobileqq.wink.editor.templatecoll.c.b(cancelBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_CONTENT_RETURN_BUTTON, Boolean.TRUE);
        }
        super.Bh();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vi(String str, final WinkEditorTemplateCollCropFragment this$0, final QCircleCommonLoadingDialog qCircleCommonLoadingDialog) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            Bitmap decodeFile = SafeBitmapFactory.decodeFile(str);
            WinkEditorCropView winkEditorCropView = this$0.cropView;
            if (winkEditorCropView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("cropView");
                winkEditorCropView = null;
            }
            RectF e16 = winkEditorCropView.e();
            Bitmap cropBmp = Bitmap.createBitmap(decodeFile, (int) e16.left, (int) e16.top, (int) e16.width(), (int) e16.height());
            Intrinsics.checkNotNullExpressionValue(cropBmp, "cropBmp");
            final boolean f16 = com.tencent.mobileqq.wink.utils.j.f(cropBmp);
            decodeFile.recycle();
            cropBmp.recycle();
            UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.af
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorTemplateCollCropFragment.wi(QCircleCommonLoadingDialog.this, f16, this$0);
                }
            });
        } catch (Exception e17) {
            w53.b.c("WinkEditorTemplateCollClipFragment", e17.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x000e, code lost:
    
        if (r3.isShowing() == true) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void wi(QCircleCommonLoadingDialog qCircleCommonLoadingDialog, boolean z16, WinkEditorTemplateCollCropFragment this$0) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qCircleCommonLoadingDialog != null) {
            z17 = true;
        }
        z17 = false;
        if (z17) {
            qCircleCommonLoadingDialog.dismiss();
        }
        if (z16) {
            this$0.ai();
        } else {
            QQToast.makeText(this$0.getContext(), R.string.f241357rn, 0).show();
        }
    }

    private final void xi() {
        if (ki().W2()) {
            ki().b3();
        }
    }

    private final void yi() {
        if (!ki().W2()) {
            ki().c3();
        }
    }

    private final void zi() {
        ah ei5 = ei();
        MediaClip fi5 = fi();
        WinkEditorCropView winkEditorCropView = this.cropView;
        WinkEditorCropView winkEditorCropView2 = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        Matrix d16 = winkEditorCropView.getEditorGestureTextureView().d();
        WinkEditorCropView winkEditorCropView3 = this.cropView;
        if (winkEditorCropView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView3 = null;
        }
        RectF c16 = winkEditorCropView3.getMaskView().c();
        WinkEditorCropView winkEditorCropView4 = this.cropView;
        if (winkEditorCropView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
        } else {
            winkEditorCropView2 = winkEditorCropView4;
        }
        ei5.T1(fi5, d16, c16, winkEditorCropView2.e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void Bh() {
        WinkEditorCropView winkEditorCropView = this.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        if (!winkEditorCropView.i()) {
            return;
        }
        if (!Zh()) {
            super.Bh();
            return;
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ViewUtilsKt.n(requireContext, 0, 0, Integer.valueOf(R.string.f239097lj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.ac
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                WinkEditorTemplateCollCropFragment.ui(WinkEditorTemplateCollCropFragment.this, dialogInterface, i3);
            }
        }, null, null, 102, null);
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void Ch(@NotNull View view) {
        boolean z16;
        Intrinsics.checkNotNullParameter(view, "view");
        WinkEditorCropView winkEditorCropView = this.cropView;
        String str = null;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        if (!winkEditorCropView.i()) {
            return;
        }
        if (si()) {
            ci(view);
        } else {
            di(view);
        }
        if (si()) {
            Boolean needDetectFace = getNeedDetectFace();
            Intrinsics.checkNotNull(needDetectFace);
            if (needDetectFace.booleanValue()) {
                final String string = requireArguments().getString("ARG_IMAGE_PATH");
                if (string != null && string.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    ai();
                    return;
                }
                QCircleCommonLoadingDialog.c cVar = new QCircleCommonLoadingDialog.c(getContext());
                Context context = getContext();
                if (context != null) {
                    str = context.getString(R.string.f240367oz);
                }
                final QCircleCommonLoadingDialog a16 = cVar.p(str).n(true).a();
                a16.show();
                ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.ae
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorTemplateCollCropFragment.vi(string, this, a16);
                    }
                });
                return;
            }
        }
        ai();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void _$_clearFindViewByIdCache() {
        this.Z.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        if (si()) {
            return R.layout.hen;
        }
        return R.layout.heo;
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkEditorTemplateCollClipFragment";
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ki().d3();
        WinkEditorCropView winkEditorCropView = this.cropView;
        if (winkEditorCropView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cropView");
            winkEditorCropView = null;
        }
        winkEditorCropView.getEditorGestureTextureView().setTransformListener(null);
        WinkSegClipView ii5 = ii();
        if (ii5 != null) {
            ii5.i();
        }
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        xi();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        yi();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    @RequiresApi(21)
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        li(view);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollCropFragment$f", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class f implements ISessionListener {
        f() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorTemplateCollCropFragment this$0, LAKRenderModel newData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            this$0.ki().D3(newData.getTimeLines());
            WinkSegClipView ii5 = this$0.ii();
            if (ii5 != null) {
                ii5.u();
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorTemplateCollCropFragment winkEditorTemplateCollCropFragment = WinkEditorTemplateCollCropFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.ag
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorTemplateCollCropFragment.f.b(WinkEditorTemplateCollCropFragment.this, newData);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }
}
