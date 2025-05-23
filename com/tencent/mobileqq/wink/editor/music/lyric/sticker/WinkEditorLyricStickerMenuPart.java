package com.tencent.mobileqq.wink.editor.music.lyric.sticker;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.cx;
import com.tencent.mobileqq.wink.editor.dr;
import com.tencent.mobileqq.wink.editor.draft.WinkEditUIData;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.lyric.sticker.WinkEditorLyricStickerMenuPart;
import com.tencent.mobileqq.wink.editor.music.lyric.sticker.z;
import com.tencent.mobileqq.wink.editor.music.ui.LyricStyleStickerImageVIew;
import com.tencent.mobileqq.wink.editor.music.ui.MarqueeTextView;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicSourceViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.MusicInfoWrapper;
import com.tencent.mobileqq.wink.editor.template.x;
import com.tencent.mobileqq.wink.flow.ApplyMaterialTask;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import com.tencent.qcircle.weseevideo.editor.sticker.constant.WsStickerConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.widget.immersive.ImmersiveUtils;
import d73.LyricSticker;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0099\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\t*\u0001N\u0018\u0000 T2\u00020\u0001:\u0001UB\u0007\u00a2\u0006\u0004\bR\u0010SJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0014J\u0012\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0014J\b\u0010\u0010\u001a\u00020\u0004H\u0014J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0016\u001a\u00020\u0006J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\b\u0010 \u001a\u00020\u0004H\u0002J\b\u0010!\u001a\u00020\u0004H\u0002J\u0012\u0010$\u001a\u00020\u00042\b\u0010#\u001a\u0004\u0018\u00010\"H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J\u0016\u0010)\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020(\u0018\u00010&H\u0002J\n\u0010+\u001a\u0004\u0018\u00010*H\u0002R\u001b\u00100\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00108\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u00107R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0018\u0010F\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u0014\u0010Q\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010P\u00a8\u0006V"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/WinkEditorMenuPart;", "Lcom/tencent/mobileqq/wink/editor/menu/MenuType;", "ba", "", "oa", "", "B9", "onDismiss", "Landroid/os/Bundle;", "args", "L9", "pa", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "initAfterInflation", "ma", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "J9", "onInitView", "touchView", "size", "Oa", "Lcom/tencent/mobileqq/wink/editor/draft/WinkEditUIData;", "uiData", "N9", "", "onBackEvent", "v", ViewStickEventHelper.IS_SHOW, "jb", "initViewModel", "lb", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "info", "kb", "Wa", "", "", "", "Sa", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkLyricStickerUIData;", "Ra", "M", "Lkotlin/Lazy;", "Qa", "()I", "halfMenuHeight", "Lcom/tencent/mobileqq/wink/editor/music/ui/LyricStyleStickerImageVIew;", "N", "Lcom/tencent/mobileqq/wink/editor/music/ui/LyricStyleStickerImageVIew;", "lyricStyleStickerImageVIew", "Landroid/widget/ImageView;", "P", "Landroid/widget/ImageView;", "leftBtn", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "rightBtn", "Landroid/support/v7/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Req, "Landroid/support/v7/widget/RecyclerView;", "mRecyclerView", "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", ExifInterface.LATITUDE_SOUTH, "Lcom/tencent/mobileqq/wink/editor/music/viewmodel/MusicSourceViewModel;", "mMusicSourceViewModel", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z;", "T", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/z;", "mWinkEditorLyricStickerViewModel", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerAdapter;", "U", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerAdapter;", "mWinkEditorLyricStickerAdapter", "V", "Landroid/view/View;", "mPanelLayout", "com/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart$b", "W", "Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart$b;", "mApplyMaterialLocalTask", "<init>", "()V", "X", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorLyricStickerMenuPart extends WinkEditorMenuPart {

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static String Y = WsStickerConstant.RedPacketAddStickerFrom.EDIT_PAGE;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final Lazy halfMenuHeight;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private LyricStyleStickerImageVIew lyricStyleStickerImageVIew;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private ImageView leftBtn;

    /* renamed from: Q, reason: from kotlin metadata */
    @Nullable
    private ImageView rightBtn;

    /* renamed from: R, reason: from kotlin metadata */
    @Nullable
    private RecyclerView mRecyclerView;

    /* renamed from: S, reason: from kotlin metadata */
    @Nullable
    private MusicSourceViewModel mMusicSourceViewModel;

    /* renamed from: T, reason: from kotlin metadata */
    @Nullable
    private z mWinkEditorLyricStickerViewModel;

    /* renamed from: U, reason: from kotlin metadata */
    @Nullable
    private WinkEditorLyricStickerAdapter mWinkEditorLyricStickerAdapter;

    /* renamed from: V, reason: from kotlin metadata */
    @Nullable
    private View mPanelLayout;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    private final b mApplyMaterialLocalTask;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart$a;", "", "", "entryPosition", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setEntryPosition", "(Ljava/lang/String;)V", "emptyStyleMetaMaterial", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.editor.music.lyric.sticker.WinkEditorLyricStickerMenuPart$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final String a() {
            return WinkEditorLyricStickerMenuPart.Y;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/wink/editor/music/lyric/sticker/WinkEditorLyricStickerMenuPart$b", "Lcom/tencent/mobileqq/wink/flow/a;", "", "position", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "g", "Y", "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$Status;", VirtualAppProxy.KEY_DOWNLOAD_STATUS, "Lcom/tencent/mobileqq/wink/flow/ApplyMaterialTask$a;", "callback", "F1", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends com.tencent.mobileqq.wink.flow.a {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(MetaMaterial material, WinkEditorLyricStickerMenuPart this$0, int i3) {
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            QQToast.makeText(com.tencent.mobileqq.wink.b.c(), com.tencent.mobileqq.wink.b.c().getString(R.string.f239587mv), 1).show();
            com.tencent.mobileqq.wink.editor.c.r1(material, true);
            WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter = this$0.mWinkEditorLyricStickerAdapter;
            if (winkEditorLyricStickerAdapter != null) {
                winkEditorLyricStickerAdapter.notifyItemChanged(i3, 1);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void e(final WinkEditorLyricStickerMenuPart this$0, ApplyMaterialTask.a callback, final MetaMaterial material, final int i3, ApplyMaterialTask.Status status, final int i16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(callback, "$callback");
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(status, "status");
            if (!this$0.visible && status == ApplyMaterialTask.Status.SUCCEEDED && !(callback instanceof z.b)) {
                return;
            }
            callback.a(status, i16);
            if (status == ApplyMaterialTask.Status.ONGOING && i16 % 5 == 0 && com.tencent.mobileqq.wink.editor.c.x(material) != i16) {
                ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.t
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorLyricStickerMenuPart.b.f(MetaMaterial.this, i16, this$0, i3);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void f(MetaMaterial material, int i3, WinkEditorLyricStickerMenuPart this$0, int i16) {
            Intrinsics.checkNotNullParameter(material, "$material");
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            com.tencent.mobileqq.wink.editor.c.s1(material, i3);
            WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter = this$0.mWinkEditorLyricStickerAdapter;
            if (winkEditorLyricStickerAdapter != null) {
                winkEditorLyricStickerAdapter.notifyItemChanged(i16, 1);
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void F1(@Nullable ApplyMaterialTask.Status downloadStatus, final int position, @NotNull final MetaMaterial material, @NotNull final ApplyMaterialTask.a callback) {
            Intrinsics.checkNotNullParameter(material, "material");
            Intrinsics.checkNotNullParameter(callback, "callback");
            if (downloadStatus == ApplyMaterialTask.Status.FAILED) {
                Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
                final WinkEditorLyricStickerMenuPart winkEditorLyricStickerMenuPart = WinkEditorLyricStickerMenuPart.this;
                uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.r
                    @Override // java.lang.Runnable
                    public final void run() {
                        WinkEditorLyricStickerMenuPart.b.d(MetaMaterial.this, winkEditorLyricStickerMenuPart, position);
                    }
                });
            }
            if (com.tencent.mobileqq.wink.editor.sticker.m.W(material)) {
                super.F1(downloadStatus, position, material, callback);
            } else {
                final WinkEditorLyricStickerMenuPart winkEditorLyricStickerMenuPart2 = WinkEditorLyricStickerMenuPart.this;
                com.tencent.mobileqq.wink.editor.sticker.l.M(material, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.s
                    @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask.a
                    public final void a(ApplyMaterialTask.Status status, int i3) {
                        WinkEditorLyricStickerMenuPart.b.e(WinkEditorLyricStickerMenuPart.this, callback, material, position, status, i3);
                    }
                });
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void Y(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            super.Y(position, material);
        }

        @Override // com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public void g(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            if (!WinkEditorLyricStickerMenuPart.this.visible && position >= 0) {
                return;
            }
            com.tencent.mobileqq.wink.editor.c.s1(material, 100);
            j73.a.f409615a.a(material);
            z zVar = WinkEditorLyricStickerMenuPart.this.mWinkEditorLyricStickerViewModel;
            if (zVar != null) {
                z.g2(zVar, material, null, false, false, false, 30, null);
            }
        }

        @Override // com.tencent.mobileqq.wink.flow.a, com.tencent.mobileqq.wink.flow.ApplyMaterialTask
        public boolean z(int position, @NotNull MetaMaterial material) {
            Intrinsics.checkNotNullParameter(material, "material");
            if (Intrinsics.areEqual("no_lyrics", material.f30533id)) {
                com.tencent.mobileqq.wink.editor.sticker.m.Q0(material, true);
                return true;
            }
            return super.z(position, material);
        }
    }

    public WinkEditorLyricStickerMenuPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.WinkEditorLyricStickerMenuPart$halfMenuHeight$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Integer invoke() {
                return Integer.valueOf(WinkEditorLyricStickerMenuPart.this.getContext().getResources().getDimensionPixelSize(R.dimen.dja));
            }
        });
        this.halfMenuHeight = lazy;
        this.mApplyMaterialLocalTask = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pa(View view, int i3, WinkEditorLyricStickerMenuPart this$0) {
        View view2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i3;
        rect.bottom += i3;
        rect.left -= i3;
        rect.right += i3;
        if (QLog.isColorLevel()) {
            QLog.d(this$0.TAG, 2, "[expandViewTouchDelegate] bounds.top=" + rect.top + "bounds.bottom=" + rect.bottom);
        }
        TouchDelegate touchDelegate = new TouchDelegate(rect, view);
        if (View.class.isInstance(view.getParent())) {
            Object parent = view.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            if (view2 != null) {
                view2.setTouchDelegate(touchDelegate);
            }
        }
    }

    private final int Qa() {
        return ((Number) this.halfMenuHeight.getValue()).intValue();
    }

    private final WinkLyricStickerUIData Ra() {
        WinkEditUIData C9 = C9();
        if (C9 instanceof WinkLyricStickerUIData) {
            return (WinkLyricStickerUIData) C9;
        }
        return null;
    }

    private final Map<String, Object> Sa() {
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION, Y);
        map.put(DTParamKey.REPORT_KEY_APPKEY, WinkDTParamBuilder.APP_KEY);
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Ta() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ua(WinkEditorLyricStickerMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = this$0.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.r2();
        }
        cx.Companion companion = cx.INSTANCE;
        if (companion.f()) {
            this$0.G9().u5(MenuType.MUSIC, null);
        }
        if (!companion.f()) {
            this$0.x9();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Va(WinkEditorLyricStickerMenuPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x9();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void Wa() {
        G9().Y2().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                WinkEditorLyricStickerMenuPart.Xa(WinkEditorLyricStickerMenuPart.this, ((Long) obj).longValue());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Xa(WinkEditorLyricStickerMenuPart this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = this$0.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.l2(j3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ya(WinkEditorLyricStickerMenuPart this$0, MusicInfoWrapper musicInfoWrapper) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = this$0.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.j2(musicInfoWrapper);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Za(final WinkEditorLyricStickerMenuPart this$0, final com.tencent.mobileqq.wink.editor.model.b winkMaterialVO) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(winkMaterialVO, "winkMaterialVO");
        ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.g
            @Override // java.lang.Runnable
            public final void run() {
                WinkEditorLyricStickerMenuPart.ab(com.tencent.mobileqq.wink.editor.model.b.this, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ab(com.tencent.mobileqq.wink.editor.model.b winkMaterialVO, WinkEditorLyricStickerMenuPart this$0) {
        MutableLiveData<List<MetaMaterial>> c26;
        Intrinsics.checkNotNullParameter(winkMaterialVO, "$winkMaterialVO");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<MetaMaterial> b16 = winkMaterialVO.b();
        Intrinsics.checkNotNullExpressionValue(b16, "winkMaterialVO.metaMaterials");
        for (MetaMaterial it : b16) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            com.tencent.mobileqq.wink.editor.sticker.m.K(it, "CATEGORY_LYRIC_STICKER_TEXT_DECOR");
        }
        MetaMaterial metaMaterial = new MetaMaterial();
        metaMaterial.f30533id = "no_lyrics";
        metaMaterial.additionalFields = new HashMap();
        metaMaterial.thumbUrl = "thumbNon";
        winkMaterialVO.b().add(0, metaMaterial);
        z zVar = this$0.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.v2(metaMaterial);
        }
        z zVar2 = this$0.mWinkEditorLyricStickerViewModel;
        if (zVar2 != null && (c26 = zVar2.c2()) != null) {
            c26.postValue(winkMaterialVO.b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void bb(WinkEditorLyricStickerMenuPart this$0, List list) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter = this$0.mWinkEditorLyricStickerAdapter;
        if (winkEditorLyricStickerAdapter != null) {
            winkEditorLyricStickerAdapter.u0(list);
        }
        this$0.lb();
        z zVar = this$0.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.w2(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cb(WinkEditorLyricStickerMenuPart this$0, MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.lb();
        this$0.kb(metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void eb(WinkEditorLyricStickerMenuPart this$0, LyricSticker lyricSticker) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        WinkLyricStickerUIData Ra = this$0.Ra();
        if (Ra != null) {
            Ra.saveUIDraft(lyricSticker);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fb(WinkEditorLyricStickerMenuPart this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LyricStyleStickerImageVIew lyricStyleStickerImageVIew = this$0.lyricStyleStickerImageVIew;
        if (lyricStyleStickerImageVIew != null) {
            lyricStyleStickerImageVIew.setState(num);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void gb(WinkEditorLyricStickerMenuPart this$0, x.UpdateTemplateAction updateTemplateAction) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        z zVar = this$0.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.k2(updateTemplateAction);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0039, code lost:
    
        if (r1 != false) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void hb(WinkEditorLyricStickerMenuPart this$0, View view) {
        boolean z16;
        Integer currentState;
        Integer currentState2;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LyricStyleStickerImageVIew lyricStyleStickerImageVIew = this$0.lyricStyleStickerImageVIew;
        boolean z17 = true;
        if (lyricStyleStickerImageVIew != null && (currentState2 = lyricStyleStickerImageVIew.getCurrentState()) != null && currentState2.intValue() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            LyricStyleStickerImageVIew lyricStyleStickerImageVIew2 = this$0.lyricStyleStickerImageVIew;
            if (lyricStyleStickerImageVIew2 == null || (currentState = lyricStyleStickerImageVIew2.getCurrentState()) == null || currentState.intValue() != 3) {
                z17 = false;
            }
        }
        this$0.Q9(null);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ib(dr tavCut) {
        WinkVideoTavCut winkVideoTavCut;
        Intrinsics.checkNotNullParameter(tavCut, "$tavCut");
        FrameLayout frameLayout = null;
        if (tavCut instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) tavCut;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            frameLayout = winkVideoTavCut.getCurrentPlayerViewContainer();
        }
        if (frameLayout != null) {
            frameLayout.setVisibility(0);
        }
    }

    private final void initViewModel() {
        com.tencent.mobileqq.wink.editor.template.x Sk;
        LiveData<x.UpdateTemplateAction> P1;
        MutableLiveData<Integer> b26;
        LiveData<LyricSticker> a26;
        LiveData<MetaMaterial> W1;
        MutableLiveData<List<MetaMaterial>> c26;
        LiveData<MusicInfoWrapper> D2;
        Wa();
        FragmentActivity activity = getHostFragment().getActivity();
        if (activity != null) {
            this.mMusicSourceViewModel = (MusicSourceViewModel) new ViewModelProvider(activity).get(MusicSourceViewModel.class);
            z zVar = (z) getViewModel(z.class);
            zVar.u2(this.mApplyMaterialLocalTask);
            this.mWinkEditorLyricStickerViewModel = zVar;
            MusicSourceViewModel musicSourceViewModel = this.mMusicSourceViewModel;
            if (musicSourceViewModel != null && (D2 = musicSourceViewModel.D2()) != null) {
                D2.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.n
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkEditorLyricStickerMenuPart.Ya(WinkEditorLyricStickerMenuPart.this, (MusicInfoWrapper) obj);
                    }
                });
            }
            aa().getLyricStickerMaterialVOLiveData().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.o
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    WinkEditorLyricStickerMenuPart.Za(WinkEditorLyricStickerMenuPart.this, (com.tencent.mobileqq.wink.editor.model.b) obj);
                }
            });
            z zVar2 = this.mWinkEditorLyricStickerViewModel;
            if (zVar2 != null && (c26 = zVar2.c2()) != null) {
                c26.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.p
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkEditorLyricStickerMenuPart.bb(WinkEditorLyricStickerMenuPart.this, (List) obj);
                    }
                });
            }
            z zVar3 = this.mWinkEditorLyricStickerViewModel;
            if (zVar3 != null && (W1 = zVar3.W1()) != null) {
                W1.observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.q
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkEditorLyricStickerMenuPart.cb(WinkEditorLyricStickerMenuPart.this, (MetaMaterial) obj);
                    }
                });
            }
            z zVar4 = this.mWinkEditorLyricStickerViewModel;
            if (zVar4 != null && (a26 = zVar4.a2()) != null) {
                a26.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.d
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkEditorLyricStickerMenuPart.eb(WinkEditorLyricStickerMenuPart.this, (LyricSticker) obj);
                    }
                });
            }
            LyricStyleStickerImageVIew lyricStyleStickerImageVIew = this.lyricStyleStickerImageVIew;
            if (lyricStyleStickerImageVIew != null) {
                lyricStyleStickerImageVIew.setState(2);
            }
            z zVar5 = this.mWinkEditorLyricStickerViewModel;
            if (zVar5 != null && (b26 = zVar5.b2()) != null) {
                b26.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.e
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkEditorLyricStickerMenuPart.fb(WinkEditorLyricStickerMenuPart.this, (Integer) obj);
                    }
                });
            }
            WinkEditorFragment F9 = F9();
            if (F9 != null && (Sk = F9.Sk()) != null && (P1 = Sk.P1()) != null) {
                P1.observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.f
                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        WinkEditorLyricStickerMenuPart.gb(WinkEditorLyricStickerMenuPart.this, (x.UpdateTemplateAction) obj);
                    }
                });
            }
        }
    }

    private final void jb(View v3, boolean isShow) {
        String str;
        Map<String, Object> map = WinkDTParamBuilder.buildElementParams();
        Intrinsics.checkNotNullExpressionValue(map, "map");
        map.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION, Y);
        VideoReport.setElementId(v3, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRICS_STYLE_PANEL);
        if (isShow) {
            str = "dt_imp";
        } else {
            str = "dt_imp_end";
        }
        VideoReport.reportEvent(str, v3, map);
    }

    private final void kb(MetaMaterial info) {
        if (info != null && !Intrinsics.areEqual(info.f30533id, "no_lyrics")) {
            HashMap<String, Object> params = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params, "params");
            params.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_LYRICS, 1);
            HashMap<String, Object> params2 = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params2, "params");
            params2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_NAME, com.tencent.mobileqq.wink.editor.c.a0(info));
            HashMap<String, Object> params3 = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params3, "params");
            params3.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_ID, info.f30533id);
            HashMap<String, Object> params4 = WinkDatongCurrentParams.params;
            Intrinsics.checkNotNullExpressionValue(params4, "params");
            params4.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION, Y);
            return;
        }
        HashMap<String, Object> params5 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params5, "params");
        params5.put(WinkDaTongReportConstant.ElementParamKey.XSJ_PUBLISH_IS_LYRICS, 0);
        HashMap<String, Object> params6 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params6, "params");
        params6.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_NAME, "");
        HashMap<String, Object> params7 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params7, "params");
        params7.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_ID, "");
        HashMap<String, Object> params8 = WinkDatongCurrentParams.params;
        Intrinsics.checkNotNullExpressionValue(params8, "params");
        params8.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LYRIC_BUTTON_LOCATION, "");
    }

    private final void lb() {
        MetaMaterial metaMaterial;
        z zVar = this.mWinkEditorLyricStickerViewModel;
        String str = null;
        if (zVar != null) {
            metaMaterial = zVar.X1();
        } else {
            metaMaterial = null;
        }
        WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter = this.mWinkEditorLyricStickerAdapter;
        if (winkEditorLyricStickerAdapter != null) {
            if (metaMaterial != null) {
                str = metaMaterial.f30533id;
            }
            int t06 = winkEditorLyricStickerAdapter.t0(str);
            WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter2 = this.mWinkEditorLyricStickerAdapter;
            if (winkEditorLyricStickerAdapter2 != null) {
                winkEditorLyricStickerAdapter2.b0(t06, true);
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public int B9() {
        return R.id.yvq;
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    public void J9(@NotNull WinkEditorViewModel.EditMode editMode) {
        Intrinsics.checkNotNullParameter(editMode, "editMode");
        super.J9(editMode);
        z zVar = this.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.e2(editMode);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    protected void L9(@Nullable Bundle args) {
        WinkVideoTavCut winkVideoTavCut;
        FrameLayout frameLayout;
        MetaMaterial metaMaterial;
        MetaMaterial X1;
        super.L9(args);
        z zVar = this.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.i2(H9());
        }
        dr H9 = H9();
        String str = null;
        if (H9 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H9;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            frameLayout = winkVideoTavCut.getCurrentPlayerViewContainer();
        } else {
            frameLayout = null;
        }
        if (frameLayout != null) {
            frameLayout.setVisibility(4);
        }
        WinkEditorMenuPart.sa(this, Qa(), 0, 2, null);
        View view = this.mPanelLayout;
        if (view != null) {
            jb(view, true);
        }
        z zVar2 = this.mWinkEditorLyricStickerViewModel;
        if (zVar2 != null) {
            metaMaterial = zVar2.X1();
        } else {
            metaMaterial = null;
        }
        if (metaMaterial != null) {
            z zVar3 = this.mWinkEditorLyricStickerViewModel;
            if (zVar3 != null && (X1 = zVar3.X1()) != null) {
                str = X1.f30533id;
            }
            if (!Intrinsics.areEqual(str, "no_lyrics")) {
                return;
            }
        }
        WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter = this.mWinkEditorLyricStickerAdapter;
        if (winkEditorLyricStickerAdapter != null) {
            winkEditorLyricStickerAdapter.v0();
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.d
    public void N9(@Nullable WinkEditUIData uiData) {
        super.N9(uiData);
        if (uiData instanceof WinkLyricStickerUIData) {
            O9(uiData);
            z zVar = this.mWinkEditorLyricStickerViewModel;
            if (zVar != null) {
                zVar.o2(((WinkLyricStickerUIData) uiData).getUIDraft(), this.mApplyMaterialLocalTask);
            }
        }
    }

    public final void Oa(@Nullable final View touchView, final int size) {
        View view;
        if (touchView == null) {
            return;
        }
        Object parent = touchView.getParent();
        if (parent instanceof View) {
            view = (View) parent;
        } else {
            view = null;
        }
        if (view != null) {
            view.post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.m
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorLyricStickerMenuPart.Pa(touchView, size, this);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    @NotNull
    public MenuType ba() {
        return MenuType.LYRIC_STICKER;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void initAfterInflation(@NotNull View rootView) {
        Context context;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.initAfterInflation(rootView);
        this.rightBtn = (ImageView) rootView.findViewById(R.id.f6442367);
        this.leftBtn = (ImageView) rootView.findViewById(R.id.f6441366);
        this.mRecyclerView = (RecyclerView) rootView.findViewById(R.id.f790648r);
        this.mPanelLayout = rootView.findViewById(R.id.f6440365);
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            List<MetaMaterial> list = null;
            if (recyclerView != null) {
                context = recyclerView.getContext();
            } else {
                context = null;
            }
            recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
            Context context2 = recyclerView.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "it.context");
            WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter = new WinkEditorLyricStickerAdapter(context2, G9().getEditMode());
            winkEditorLyricStickerAdapter.f0(new QQToast.IToastValidListener() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.j
                @Override // com.tencent.mobileqq.widget.QQToast.IToastValidListener
                public final boolean canShowToast() {
                    boolean Ta;
                    Ta = WinkEditorLyricStickerMenuPart.Ta();
                    return Ta;
                }
            });
            this.mWinkEditorLyricStickerAdapter = winkEditorLyricStickerAdapter;
            Intrinsics.checkNotNull(winkEditorLyricStickerAdapter);
            recyclerView.setAdapter(winkEditorLyricStickerAdapter);
            WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter2 = this.mWinkEditorLyricStickerAdapter;
            Intrinsics.checkNotNull(winkEditorLyricStickerAdapter2);
            winkEditorLyricStickerAdapter2.S(this.mApplyMaterialLocalTask);
            WinkEditorLyricStickerAdapter winkEditorLyricStickerAdapter3 = this.mWinkEditorLyricStickerAdapter;
            if (winkEditorLyricStickerAdapter3 != null) {
                z zVar = this.mWinkEditorLyricStickerViewModel;
                if (zVar != null) {
                    list = zVar.Z1();
                }
                winkEditorLyricStickerAdapter3.u0(list);
            }
            lb();
        }
        ImageView imageView = this.leftBtn;
        if (imageView != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.k
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorLyricStickerMenuPart.Ua(WinkEditorLyricStickerMenuPart.this, view);
                }
            });
        }
        ImageView imageView2 = this.rightBtn;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.l
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorLyricStickerMenuPart.Va(WinkEditorLyricStickerMenuPart.this, view);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    protected void ma() {
        super.ma();
        qa();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public boolean onBackEvent() {
        if (this.visible) {
            ImageView imageView = this.leftBtn;
            if (imageView != null) {
                imageView.performClick();
            }
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d
    protected void onDismiss() {
        WinkVideoTavCut winkVideoTavCut;
        super.onDismiss();
        z zVar = this.mWinkEditorLyricStickerViewModel;
        if (zVar != null) {
            zVar.h2();
        }
        View view = this.mPanelLayout;
        if (view != null) {
            jb(view, false);
        }
        dr H9 = H9();
        if (H9 != null) {
            H9.play();
        }
        dr H92 = H9();
        if (H92 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H92;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.O2(WinkVideoTavCut.INSTANCE.m());
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart, com.tencent.mobileqq.wink.editor.d, com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        LyricStyleStickerImageVIew lyricStyleStickerImageVIew = ((MarqueeTextView) rootView.findViewById(R.id.zjp)).getLyricStyleStickerImageVIew();
        this.lyricStyleStickerImageVIew = lyricStyleStickerImageVIew;
        Oa(lyricStyleStickerImageVIew, ImmersiveUtils.dpToPx(10.0f));
        LyricStyleStickerImageVIew lyricStyleStickerImageVIew2 = this.lyricStyleStickerImageVIew;
        if (lyricStyleStickerImageVIew2 != null) {
            lyricStyleStickerImageVIew2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WinkEditorLyricStickerMenuPart.hb(WinkEditorLyricStickerMenuPart.this, view);
                }
            });
        }
        VideoReport.setElementId(this.lyricStyleStickerImageVIew, WinkDaTongReportConstant.ElementId.EM_XSJ_LYRIC_ENTRY_BUTTON);
        VideoReport.setElementParams(this.lyricStyleStickerImageVIew, Sa());
        O9(new WinkLyricStickerUIData(this));
        initViewModel();
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    protected void pa() {
        WinkVideoTavCut winkVideoTavCut;
        super.pa();
        final dr H9 = H9();
        if (H9 != null) {
            dr H92 = H9();
            if (H92 != null) {
                H92.flush(true);
            }
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.music.lyric.sticker.i
                @Override // java.lang.Runnable
                public final void run() {
                    WinkEditorLyricStickerMenuPart.ib(dr.this);
                }
            }, 50L);
        }
        dr H93 = H9();
        if (H93 != null) {
            H93.play();
        }
        dr H94 = H9();
        if (H94 instanceof WinkVideoTavCut) {
            winkVideoTavCut = (WinkVideoTavCut) H94;
        } else {
            winkVideoTavCut = null;
        }
        if (winkVideoTavCut != null) {
            winkVideoTavCut.O2(-16777216);
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart
    public void oa() {
    }
}
