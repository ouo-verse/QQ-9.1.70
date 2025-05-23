package com.tencent.mobileqq.wink.editor.templatecoll;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheLunarData;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.clipping.TimelineViewModelV2;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditData;
import com.tencent.mobileqq.wink.editor.model.WinkTavCutScene;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClipSegFragment;
import com.tencent.mobileqq.wink.editor.view.WinkSegClipView;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.picker.utils.MediaCompressUtils;
import com.tencent.mobileqq.wink.picker.utils.PhotoListLogicPreDealDialog;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.ResourceModel;
import java.util.Collection;
import java.util.Iterator;
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
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bI\u0010JJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u0002H\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\b\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\b\u0010\u0016\u001a\u00020\u0002H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0014J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0017J\b\u0010\u001e\u001a\u00020\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0002H\u0016J\u0010\u0010 \u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010!\u001a\u00020\u0002H\u0014J\b\u0010\"\u001a\u00020\u0002H\u0016R\u0014\u0010%\u001a\u00020\u00198\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b#\u0010$R#\u0010,\u001a\n '*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00103\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0014\u0010?\u001a\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010)\u001a\u0004\bF\u0010G\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClipSegFragment;", "Lcom/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollAdjustFragment;", "", "initData", "Landroid/view/View;", "view", "ci", "", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditData;", "Uh", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initView", "", "ai", "Xh", "Zh", "ii", "hi", "", "fi", "ei", WidgetCacheLunarData.JI, "Vh", "", "getContentLayoutId", "", "getLogTag", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "Ch", "Bh", "onDestroyView", "M", "Ljava/lang/String;", "TAG", "Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "kotlin.jvm.PlatformType", "N", "Lkotlin/Lazy;", "bi", "()Lcom/tencent/mobileqq/wink/editor/clipping/TimelineViewModelV2;", "timelineViewModel", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "playerStatusBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "J", "curVideoStartUs", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", BdhLogUtil.LogTag.Tag_Req, "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$d;", "segClipModel", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "playerListener", "Lcom/tencent/tavcut/core/session/ISessionListener;", "T", "Lcom/tencent/tavcut/core/session/ISessionListener;", "renderListener", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "U", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "stepHelper", "Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog;", "V", "Yh", "()Lcom/tencent/mobileqq/wink/picker/utils/PhotoListLogicPreDealDialog;", "preprocessMediaDialog", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorTemplateCollClipSegFragment extends WinkEditorTemplateCollAdjustFragment {

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy timelineViewModel;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView playerStatusBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    private long curVideoStartUs;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private WinkSegClipView.SegClipModel segClipModel;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final IPlayer.PlayerListener playerListener;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final ISessionListener renderListener;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final WinkMediaPickerNextStepHelper stepHelper;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    private final Lazy preprocessMediaDialog;

    @NotNull
    public Map<Integer, View> W = new LinkedHashMap();

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final String TAG = "WinkEditorTemplateCollClipSegFragment";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0017\u00a8\u0006\u0004"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClipSegFragment$a", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "", "onGlobalLayout", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f322448d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ WinkEditorTemplateCollClipSegFragment f322449e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ FrameLayout f322450f;

        a(View view, WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment, FrameLayout frameLayout) {
            this.f322448d = view;
            this.f322449e = winkEditorTemplateCollClipSegFragment;
            this.f322450f = frameLayout;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        @RequiresApi(16)
        public void onGlobalLayout() {
            this.f322448d.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            WinkEditorViewModel.EditMode editMode = WinkEditorViewModel.EditMode.Video;
            List Uh = this.f322449e.Uh();
            Boolean bool = Boolean.FALSE;
            int width = this.f322450f.getWidth();
            int height = this.f322450f.getHeight();
            Boolean isOpenFFmpegDecode = u53.i.f438428a;
            Intrinsics.checkNotNullExpressionValue(isOpenFFmpegDecode, "isOpenFFmpegDecode");
            boolean booleanValue = isOpenFFmpegDecode.booleanValue();
            Integer softDecodeThreadCnt = u53.i.f438429b;
            Intrinsics.checkNotNullExpressionValue(softDecodeThreadCnt, "softDecodeThreadCnt");
            dr.WinkTavCutParams winkTavCutParams = new dr.WinkTavCutParams(false, editMode, Uh, null, bool, width, height, null, null, booleanValue, softDecodeThreadCnt.intValue(), Long.MAX_VALUE, false, false, null, WinkTavCutScene.CollSeg, true, false, 0, 0, false, null, 4092160, null);
            TimelineViewModelV2 bi5 = this.f322449e.bi();
            if (bi5 != null) {
                WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment = this.f322449e;
                TimelineViewModelV2.S2(bi5, winkEditorTemplateCollClipSegFragment, this.f322450f, winkTavCutParams, winkEditorTemplateCollClipSegFragment.playerListener, this.f322449e.renderListener, true, false, true, 0L, null, 832, null);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClipSegFragment$b", "Lcom/tencent/mobileqq/wink/editor/view/WinkSegClipView$c;", "", "b", "", "startTimeUs", "a", "c", "timeUs", "e", "d", "f", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkSegClipView.c {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void a(long startTimeUs) {
            WinkEditorTemplateCollClipSegFragment.this.bi().o3(startTimeUs, WinkEditorTemplateCollClipSegFragment.this.ai());
            TimelineViewModelV2 timelineViewModel = WinkEditorTemplateCollClipSegFragment.this.bi();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, startTimeUs, false, false, 6, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void b() {
            WinkEditorTemplateCollClipSegFragment.this.bi().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void c() {
            WinkEditorTemplateCollClipSegFragment.this.bi().c3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void d() {
            WinkEditorTemplateCollClipSegFragment.this.bi().b3();
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void e(long timeUs) {
            TimelineViewModelV2 timelineViewModel = WinkEditorTemplateCollClipSegFragment.this.bi();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, timeUs, false, false, 6, null);
        }

        @Override // com.tencent.mobileqq.wink.editor.view.WinkSegClipView.c
        public void f() {
            WinkEditorTemplateCollClipSegFragment.this.bi().c3();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClipSegFragment$c", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerListener;", "Lcom/tencent/tavcut/core/render/player/IPlayer$PlayerStatus;", "status", "Lcom/tencent/tavcut/core/render/player/IPlayer;", "iPlayer", "", "onStatusChanged", "", "currentDurationUs", "playerDurationUs", "onPositionChanged", "onPlayerSourceReady", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements IPlayer.PlayerListener {
        c() {
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPlayerSourceReady(@NotNull IPlayer iPlayer) {
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onPositionChanged(long currentDurationUs, long playerDurationUs) {
            WinkEditorTemplateCollClipSegFragment.this.bi().m2().postValue(Long.valueOf(currentDurationUs));
            ((WinkSegClipView) WinkEditorTemplateCollClipSegFragment.this.Kh(R.id.f81914fg)).z(currentDurationUs);
        }

        @Override // com.tencent.tavcut.core.render.player.IPlayer.PlayerListener
        public void onStatusChanged(@Nullable IPlayer.PlayerStatus status, @NotNull IPlayer iPlayer) {
            ImageView imageView;
            Intrinsics.checkNotNullParameter(iPlayer, "iPlayer");
            if (status == IPlayer.PlayerStatus.PLAYING) {
                ImageView imageView2 = WinkEditorTemplateCollClipSegFragment.this.playerStatusBtn;
                if (imageView2 != null) {
                    imageView2.setImageResource(R.drawable.oqq);
                }
            } else if (status == IPlayer.PlayerStatus.PAUSED && (imageView = WinkEditorTemplateCollClipSegFragment.this.playerStatusBtn) != null) {
                imageView.setImageResource(R.drawable.oqs);
            }
            WinkEditorTemplateCollClipSegFragment.this.bi().l2().postValue(status);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClipSegFragment$e", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/c;", "", "isError", "", "errorMsgResId", "", "l1", "z0", "", "progress", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "itemIndex", "e", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class e extends com.tencent.mobileqq.wink.picker.core.viewmodel.c {
        e() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(WinkEditorTemplateCollClipSegFragment this$0, int i3, float f16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Yh().z(i3, f16);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(WinkEditorTemplateCollClipSegFragment this$0, float f16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.Yh().P(f16);
        }

        @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
        public void e(final int itemIndex, final float progress) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment = WinkEditorTemplateCollClipSegFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.q
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorTemplateCollClipSegFragment.e.c(WinkEditorTemplateCollClipSegFragment.this, itemIndex, progress);
                }
            });
        }

        @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
        public void l1(boolean isError, int errorMsgResId) {
            WinkEditorTemplateCollClipSegFragment.this.Vh();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
        public void m(final float progress) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment = WinkEditorTemplateCollClipSegFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.p
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorTemplateCollClipSegFragment.e.d(WinkEditorTemplateCollClipSegFragment.this, progress);
                }
            });
        }

        @Override // com.tencent.mobileqq.wink.picker.core.viewmodel.b
        public void z0() {
            WinkEditorTemplateCollClipSegFragment.this.Vh();
        }
    }

    public WinkEditorTemplateCollClipSegFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TimelineViewModelV2>() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollClipSegFragment$timelineViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final TimelineViewModelV2 invoke() {
                return (TimelineViewModelV2) WinkEditorTemplateCollClipSegFragment.this.getViewModel(TimelineViewModelV2.class);
            }
        });
        this.timelineViewModel = lazy;
        this.playerListener = new c();
        this.renderListener = new d();
        this.stepHelper = new WinkMediaPickerNextStepHelper(new e());
        lazy2 = LazyKt__LazyJVMKt.lazy(new WinkEditorTemplateCollClipSegFragment$preprocessMediaDialog$2(this));
        this.preprocessMediaDialog = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0057, code lost:
    
        r0 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final List<WinkEditData> Uh() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void Vh() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.k
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorTemplateCollClipSegFragment.Wh(WinkEditorTemplateCollClipSegFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Wh(WinkEditorTemplateCollClipSegFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Yh().m();
    }

    private final long Xh() {
        WinkSegClipView.SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null) {
            return segClipModel.getOriginStartTime();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final PhotoListLogicPreDealDialog Yh() {
        return (PhotoListLogicPreDealDialog) this.preprocessMediaDialog.getValue();
    }

    private final long Zh() {
        return ((WinkSegClipView) Kh(R.id.f81914fg)).k();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long ai() {
        WinkSegClipView.SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null) {
            return segClipModel.getSelectDuration();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final TimelineViewModelV2 bi() {
        return (TimelineViewModelV2) this.timelineViewModel.getValue();
    }

    private final void ci(View view) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new a(view, this, (FrameLayout) view.findViewById(R.id.v8h)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void di(WinkEditorTemplateCollClipSegFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.bi().W2()) {
            this$0.bi().b3();
        } else {
            this$0.bi().c3();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final boolean ei() {
        if (Math.abs(Zh() - Xh()) > 10000) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ec A[EDGE_INSN: B:43:0x00ec->B:44:0x00ec BREAK  A[LOOP:0: B:16:0x003d->B:53:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[LOOP:0: B:16:0x003d->B:53:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean fi() {
        MetaMaterial wh5;
        TemplatePreProcessConfig H0;
        List<TemplatePreProcessConfig.Media> medias;
        Object obj;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29 = false;
        if (Zh() != Xh() && getOriginalMediaInfo() != null) {
            LocalMediaInfo originalMediaInfo = getOriginalMediaInfo();
            Intrinsics.checkNotNull(originalMediaInfo);
            if (e93.i.I(originalMediaInfo) && (wh5 = wh()) != null && (H0 = com.tencent.mobileqq.wink.editor.c.H0(wh5)) != null && (medias = H0.getMedias()) != null) {
                Iterator<T> it = medias.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) obj;
                        if (media.getIndex() != getMediaIndex()) {
                            List<TemplatePreProcessConfig.Media.Preprocess> preprocess = media.getPreprocess();
                            if (preprocess != null) {
                                Intrinsics.checkNotNullExpressionValue(preprocess, "preprocess");
                                List<TemplatePreProcessConfig.Media.Preprocess> list = preprocess;
                                if (!(list instanceof Collection) || !list.isEmpty()) {
                                    Iterator<T> it5 = list.iterator();
                                    while (it5.hasNext()) {
                                        if (((TemplatePreProcessConfig.Media.Preprocess) it5.next()).getIndex() == getMediaIndex()) {
                                            z27 = true;
                                        } else {
                                            z27 = false;
                                        }
                                        if (z27) {
                                            z28 = true;
                                            break;
                                        }
                                    }
                                }
                                z28 = false;
                                if (z28) {
                                    z17 = true;
                                    if (!z17) {
                                        List<TemplatePreProcessConfig.Media.Preprocess> preprocess2 = media.getPreprocess();
                                        if (preprocess2 != null) {
                                            Intrinsics.checkNotNullExpressionValue(preprocess2, "preprocess");
                                            List<TemplatePreProcessConfig.Media.Preprocess> list2 = preprocess2;
                                            if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                                                Iterator<T> it6 = list2.iterator();
                                                while (it6.hasNext()) {
                                                    List<Integer> multipleIndexes = ((TemplatePreProcessConfig.Media.Preprocess) it6.next()).getMultipleIndexes();
                                                    if (multipleIndexes != null && multipleIndexes.contains(Integer.valueOf(getMediaIndex()))) {
                                                        z19 = true;
                                                    } else {
                                                        z19 = false;
                                                    }
                                                    if (z19) {
                                                        z26 = true;
                                                        break;
                                                    }
                                                }
                                            }
                                            z26 = false;
                                            if (z26) {
                                                z18 = true;
                                                if (!z18) {
                                                    z16 = false;
                                                    if (!z16) {
                                                        break;
                                                    }
                                                }
                                            }
                                        }
                                        z18 = false;
                                        if (!z18) {
                                        }
                                    }
                                }
                            }
                            z17 = false;
                            if (!z17) {
                            }
                        }
                        z16 = true;
                        if (!z16) {
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                TemplatePreProcessConfig.Media media2 = (TemplatePreProcessConfig.Media) obj;
                if (media2 != null) {
                    List<TemplatePreProcessConfig.Media.Preprocess> preprocess3 = media2.getPreprocess();
                    if (preprocess3 == null || preprocess3.isEmpty()) {
                        z29 = true;
                    }
                    return !z29;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gi(WinkEditorTemplateCollClipSegFragment this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View cancelBtn = this$0.getCancelBtn();
        if (cancelBtn != null) {
            com.tencent.mobileqq.wink.editor.templatecoll.c.b(cancelBtn, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_CONTENT_RETURN_BUTTON, Boolean.TRUE);
        }
        super.Bh();
    }

    private final void hi() {
        if (bi().W2()) {
            bi().b3();
        }
    }

    private final void ii() {
        if (!bi().W2()) {
            bi().c3();
        }
    }

    private final void initData() {
        long j3;
        long j16 = requireArguments().getLong("ARG_VIDEO_SELECTION_DURATION");
        long j17 = requireArguments().getLong("ARG_VIDEO_START");
        this.curVideoStartUs = j17;
        MediaClip mediaClip = (MediaClip) requireArguments().getParcelable("ARG_VIDEO_CLIP");
        if (mediaClip == null) {
            mediaClip = new MediaClip(null, null, null, null, null, null, null, 127, null);
        }
        MediaClip l3 = com.tencent.videocut.render.extension.e.l(mediaClip);
        float f16 = 0.0f;
        ResourceModel resourceModel = l3.resource;
        if (resourceModel != null) {
            j3 = resourceModel.sourceDuration;
        } else {
            j3 = 0;
        }
        this.segClipModel = new WinkSegClipView.SegClipModel(l3, f16, j3, j16, j17, j17, 2, null);
    }

    private final void initView(View rootView) {
        View findViewById = rootView.findViewById(R.id.f164879u42);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.confirmBtn)");
        com.tencent.mobileqq.wink.editor.templatecoll.c.a(findViewById, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_CONTENT_APPLY_BUTTON, true);
        View findViewById2 = rootView.findViewById(R.id.tr7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.changeMediaBtn)");
        com.tencent.mobileqq.wink.editor.templatecoll.c.a(findViewById2, WinkDaTongReportConstant.ElementId.EM_XSJ_CHANGE_CONTENT_BUTTON, true);
        ImageView imageView = (ImageView) rootView.findViewById(R.id.f25790bs);
        this.playerStatusBtn = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.j
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorTemplateCollClipSegFragment.di(WinkEditorTemplateCollClipSegFragment.this, view);
                }
            });
        }
        ((WinkSegClipView) Kh(R.id.f81914fg)).setSegClipCallback(new b());
    }

    private final void ji() {
        List<? extends LocalMediaInfo> mutableListOf;
        LocalMediaInfo originalMediaInfo = getOriginalMediaInfo();
        int i3 = 0;
        if (originalMediaInfo != null) {
            MediaCompressUtils mediaCompressUtils = MediaCompressUtils.f325262a;
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(originalMediaInfo);
            i3 = mediaCompressUtils.q(mutableListOf).size();
        }
        Yh().p(i3, false, false, false, false, false, false, false, true);
        Yh().w();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void Bh() {
        if (ei()) {
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            ViewUtilsKt.n(requireContext, 0, 0, Integer.valueOf(R.string.f239097lj), new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.l
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    WinkEditorTemplateCollClipSegFragment.gi(WinkEditorTemplateCollClipSegFragment.this, dialogInterface, i3);
                }
            }, null, null, 102, null);
            return;
        }
        super.Bh();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void Ch(@NotNull View view) {
        LocalMediaInfo localMediaInfo;
        List<? extends LocalMediaInfo> mutableListOf;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!ei()) {
            super.Bh();
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("ARG_MEDIA_INDEX", getMediaIndex());
        intent.putExtra("ARG_VIDEO_START", Zh());
        if (fi()) {
            LocalMediaInfo originalMediaInfo = getOriginalMediaInfo();
            if (originalMediaInfo != null && (localMediaInfo = e93.i.b(originalMediaInfo)) != null) {
                localMediaInfo.mStartTime = Zh();
            } else {
                localMediaInfo = null;
            }
            WinkMediaPickerNextStepHelper winkMediaPickerNextStepHelper = this.stepHelper;
            Activity hostActivity = getHostActivity();
            Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
            TabType pickerTabType = getPickerTabType();
            Intrinsics.checkNotNull(pickerTabType);
            Intrinsics.checkNotNull(localMediaInfo);
            mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(localMediaInfo);
            MediaPickerScene vh5 = vh();
            MetaMaterial wh5 = wh();
            Intrinsics.checkNotNull(wh5);
            Boolean needDetectFace = getNeedDetectFace();
            Intrinsics.checkNotNull(needDetectFace);
            winkMediaPickerNextStepHelper.h(hostActivity, pickerTabType, mutableListOf, false, vh5, new TemplateLibraryData(wh5, needDetectFace.booleanValue(), getMediaIndex()), new WinkEditorTemplateCollClipSegFragment$onConfirmClick$1(intent, this));
            ji();
            return;
        }
        Fragment targetFragment = getTargetFragment();
        if (targetFragment != null) {
            targetFragment.onActivityResult(100, 202, intent);
        }
        Gh();
    }

    @Nullable
    public View Kh(int i3) {
        View findViewById;
        Map<Integer, View> map = this.W;
        View view = map.get(Integer.valueOf(i3));
        if (view == null) {
            View view2 = getView();
            if (view2 != null && (findViewById = view2.findViewById(i3)) != null) {
                map.put(Integer.valueOf(i3), findViewById);
                return findViewById;
            }
            return null;
        }
        return view;
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment
    public void _$_clearFindViewByIdCache() {
        this.W.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hem;
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag, reason: from getter */
    public String getTAG() {
        return this.TAG;
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        bi().d3();
        WinkSegClipView winkSegClipView = (WinkSegClipView) Kh(R.id.f81914fg);
        if (winkSegClipView != null) {
            winkSegClipView.i();
        }
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        hi();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ii();
    }

    @Override // com.tencent.mobileqq.wink.editor.templatecoll.WinkEditorTemplateCollAdjustFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    @RequiresApi(21)
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
        ci(view);
        initView(view);
        WinkSegClipView.SegClipModel segClipModel = this.segClipModel;
        if (segClipModel != null) {
            ((WinkSegClipView) Kh(R.id.f81914fg)).setSegClipModel(segClipModel);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/wink/editor/templatecoll/WinkEditorTemplateCollClipSegFragment$d", "Lcom/tencent/tavcut/core/session/ISessionListener;", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "", "onRenderDataChanged", "onRenderDataApplied", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class d implements ISessionListener {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void b(WinkEditorTemplateCollClipSegFragment this$0, LAKRenderModel newData) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(newData, "$newData");
            this$0.bi().D3(newData.getTimeLines());
            this$0.bi().o3(((WinkSegClipView) this$0.Kh(R.id.f81914fg)).k(), this$0.ai());
            TimelineViewModelV2 timelineViewModel = this$0.bi();
            Intrinsics.checkNotNullExpressionValue(timelineViewModel, "timelineViewModel");
            TimelineViewModelV2.g3(timelineViewModel, 0L, false, false, 6, null);
            ((WinkSegClipView) this$0.Kh(R.id.f81914fg)).u();
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull final LAKRenderModel newData, long duration, long mediaDuration) {
            Intrinsics.checkNotNullParameter(newData, "newData");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkEditorTemplateCollClipSegFragment winkEditorTemplateCollClipSegFragment = WinkEditorTemplateCollClipSegFragment.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.templatecoll.o
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorTemplateCollClipSegFragment.d.b(WinkEditorTemplateCollClipSegFragment.this, newData);
                }
            });
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
        }
    }
}
