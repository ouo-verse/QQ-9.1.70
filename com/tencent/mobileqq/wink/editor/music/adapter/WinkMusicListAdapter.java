package com.tencent.mobileqq.wink.editor.music.adapter;

import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.VsMusicItemInfo;
import com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListAdapter;
import com.tencent.mobileqq.wink.editor.music.lyric.widget.RoundCorneredFrameLayout;
import com.tencent.mobileqq.wink.editor.music.vo.MusicPanelData;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.wink.view.WinkRoundedCornerImageView;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LoadingUtil;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u001c2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001d\u001eB\u001d\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016J\u0014\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00030\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListAdapter$ViewHolder;", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "holder", "", "m0", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "viewType", "r0", "position", "n0", "getItemCount", "", "newItems", "updateData", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/util/List;", "items", "Lb73/a;", BdhLogUtil.LogTag.Tag_Conn, "Lb73/a;", "musicListCallback", "<init>", "(Ljava/util/List;Lb73/a;)V", "D", "a", "ViewHolder", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMusicListAdapter extends RecyclerView.Adapter<ViewHolder> {

    @NotNull
    private static final String E = MusicPanelData.INSTANCE.a(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString("qqcircle_editor_music_config", "")).getMusicSelectCellAnimation();

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final b73.a musicListCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<? extends WinkEditorMusicInfo> items;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0013\u00a2\u0006\u0004\bL\u0010MJ \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J&\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001e\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010$\u001a\u00020\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010*\u001a\u00020%8\u0006\u00a2\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0017\u00100\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u0017\u00106\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0017\u00109\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b7\u0010-\u001a\u0004\b8\u0010/R\u0017\u0010<\u001a\u00020+8\u0006\u00a2\u0006\f\n\u0004\b:\u0010-\u001a\u0004\b;\u0010/R\u0017\u0010?\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b=\u00103\u001a\u0004\b>\u00105R\u0017\u0010B\u001a\u0002018\u0006\u00a2\u0006\f\n\u0004\b@\u00103\u001a\u0004\bA\u00105R#\u0010G\u001a\n C*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bD\u0010E\u001a\u0004\bF\u0010\u0017R\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010J\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/music/adapter/WinkMusicListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "musicInfo", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", "editMode", "", "pgId", "", "u", "", "position", HippyTKDListViewAdapter.X, "w", ReportConstant.COSTREPORT_PREFIX, "v", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "y", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/view/View;", "E", "Landroid/view/View;", "r", "()Landroid/view/View;", "parentView", "Lcom/tencent/mobileqq/wink/editor/music/lyric/widget/RoundCorneredFrameLayout;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/wink/editor/music/lyric/widget/RoundCorneredFrameLayout;", "getWinkMusicItemCoverFl", "()Lcom/tencent/mobileqq/wink/editor/music/lyric/widget/RoundCorneredFrameLayout;", "winkMusicItemCoverFl", "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "G", "Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "getCoverImageView", "()Lcom/tencent/mobileqq/wink/view/WinkRoundedCornerImageView;", "coverImageView", "Landroid/widget/FrameLayout;", "H", "Landroid/widget/FrameLayout;", "getCoverSelectedFrameLayout", "()Landroid/widget/FrameLayout;", "coverSelectedFrameLayout", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "getSongNameTextView", "()Landroid/widget/TextView;", "songNameTextView", "Landroid/widget/ImageView;", "J", "Landroid/widget/ImageView;", "getSongPlayingImageView", "()Landroid/widget/ImageView;", "songPlayingImageView", "K", "getSongSingerTextView", "songSingerTextView", "L", "getSongDurationTextView", "songDurationTextView", "M", "o", "clipImageView", "N", "p", "collectImageView", "kotlin.jvm.PlatformType", "P", "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "loadingView", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Z", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "<init>", "(Landroid/view/View;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class ViewHolder extends RecyclerView.ViewHolder {

        /* renamed from: E, reason: from kotlin metadata */
        @NotNull
        private final View parentView;

        /* renamed from: F, reason: from kotlin metadata */
        @NotNull
        private final RoundCorneredFrameLayout winkMusicItemCoverFl;

        /* renamed from: G, reason: from kotlin metadata */
        @NotNull
        private final WinkRoundedCornerImageView coverImageView;

        /* renamed from: H, reason: from kotlin metadata */
        @NotNull
        private final FrameLayout coverSelectedFrameLayout;

        /* renamed from: I, reason: from kotlin metadata */
        @NotNull
        private final TextView songNameTextView;

        /* renamed from: J, reason: from kotlin metadata */
        @NotNull
        private final ImageView songPlayingImageView;

        /* renamed from: K, reason: from kotlin metadata */
        @NotNull
        private final TextView songSingerTextView;

        /* renamed from: L, reason: from kotlin metadata */
        @NotNull
        private final TextView songDurationTextView;

        /* renamed from: M, reason: from kotlin metadata */
        @NotNull
        private final ImageView clipImageView;

        /* renamed from: N, reason: from kotlin metadata */
        @NotNull
        private final ImageView collectImageView;

        /* renamed from: P, reason: from kotlin metadata */
        @NotNull
        private final Lazy loadingView;

        /* renamed from: Q, reason: from kotlin metadata */
        private boolean isDownloaded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View parentView) {
            super(parentView);
            Lazy lazy;
            Intrinsics.checkNotNullParameter(parentView, "parentView");
            this.parentView = parentView;
            View findViewById = this.itemView.findViewById(R.id.f123607h4);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.\u2026wink_music_item_cover_fl)");
            this.winkMusicItemCoverFl = (RoundCorneredFrameLayout) findViewById;
            View findViewById2 = parentView.findViewById(R.id.f123617h5);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "parentView.findViewById(\u2026wink_music_item_cover_iv)");
            this.coverImageView = (WinkRoundedCornerImageView) findViewById2;
            View findViewById3 = parentView.findViewById(R.id.f123627h6);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "parentView.findViewById(\u2026usic_item_cover_selected)");
            this.coverSelectedFrameLayout = (FrameLayout) findViewById3;
            View findViewById4 = parentView.findViewById(R.id.f123667h_);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "parentView.findViewById(\u2026_music_item_song_name_tv)");
            this.songNameTextView = (TextView) findViewById4;
            View findViewById5 = parentView.findViewById(R.id.f123677ha);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "parentView.findViewById(\u2026sic_item_song_playing_iv)");
            this.songPlayingImageView = (ImageView) findViewById5;
            View findViewById6 = parentView.findViewById(R.id.f123687hb);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "parentView.findViewById(\u2026usic_item_song_singer_tv)");
            this.songSingerTextView = (TextView) findViewById6;
            View findViewById7 = parentView.findViewById(R.id.f123657h9);
            Intrinsics.checkNotNullExpressionValue(findViewById7, "parentView.findViewById(\u2026ic_item_song_duration_tv)");
            this.songDurationTextView = (TextView) findViewById7;
            View findViewById8 = parentView.findViewById(R.id.f123587h2);
            Intrinsics.checkNotNullExpressionValue(findViewById8, "parentView.findViewById(\u2026.wink_music_item_clip_iv)");
            this.clipImageView = (ImageView) findViewById8;
            View findViewById9 = parentView.findViewById(R.id.f123597h3);
            Intrinsics.checkNotNullExpressionValue(findViewById9, "parentView.findViewById(\u2026nk_music_item_collect_iv)");
            this.collectImageView = (ImageView) findViewById9;
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<View>() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.WinkMusicListAdapter$ViewHolder$loadingView$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final View invoke() {
                    return LoadingUtil.getLoadingView(WinkMusicListAdapter.ViewHolder.this.getParentView().getContext(), ViewUtils.dpToPx(20.0f), ViewUtils.dpToPx(20.0f), 1);
                }
            });
            this.loadingView = lazy;
        }

        private final View q() {
            return (View) this.loadingView.getValue();
        }

        private final void s() {
            Option picOption = Option.obtain().setTargetView(this.songPlayingImageView).setLoadingDrawableColor(0).setUrl(WinkMusicListAdapter.E);
            QQPicLoader qQPicLoader = QQPicLoader.f201806a;
            Intrinsics.checkNotNullExpressionValue(picOption, "picOption");
            qQPicLoader.e(picOption, new IPicLoadStateListener() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.d
                @Override // com.tencent.libra.listener.IPicLoadStateListener
                public final void onStateChange(LoadState loadState, Option option) {
                    WinkMusicListAdapter.ViewHolder.t(loadState, option);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void t(LoadState loadState, Option option) {
            r01.c cVar;
            Intrinsics.checkNotNullParameter(loadState, "loadState");
            Intrinsics.checkNotNullParameter(option, "option");
            if (loadState.isFinishSuccess()) {
                Animatable animatable = option.getAnimatable();
                if (animatable instanceof r01.c) {
                    cVar = (r01.c) animatable;
                } else {
                    cVar = null;
                }
                if (cVar != null) {
                    cVar.setLoopCount(1000);
                    cVar.start();
                }
            }
        }

        private final void u(WinkEditorMusicInfo musicInfo, WinkEditorViewModel.EditMode editMode, String pgId) {
            long o16 = musicInfo.o();
            Long l3 = WinkEditorMusicInfo.H;
            if (l3 != null && o16 == l3.longValue()) {
                w53.b.a("WinkMusicListAdapter", "setClipImageView... musicInfo.songId == FAKE_TEMPLATE_SONG_ID");
                this.clipImageView.setVisibility(8);
            } else {
                if (musicInfo.f321262i != 3 && editMode != WinkEditorViewModel.EditMode.Image) {
                    if (musicInfo.f321259e) {
                        this.clipImageView.setVisibility(0);
                        return;
                    } else {
                        this.clipImageView.setVisibility(8);
                        return;
                    }
                }
                this.clipImageView.setVisibility(8);
            }
        }

        private final void v(WinkEditorMusicInfo musicInfo, String pgId) {
            long o16 = musicInfo.o();
            Long l3 = WinkEditorMusicInfo.H;
            if (l3 != null && o16 == l3.longValue()) {
                w53.b.a("WinkMusicListAdapter", "setCollection... musicInfo.songId == FAKE_TEMPLATE_SONG_ID");
                this.collectImageView.setVisibility(8);
            } else {
                if (musicInfo.f321262i != 3) {
                    if (musicInfo.x()) {
                        this.collectImageView.setImageResource(R.drawable.nsq);
                    } else {
                        this.collectImageView.setImageResource(R.drawable.nsp);
                    }
                    this.collectImageView.setVisibility(0);
                    return;
                }
                this.collectImageView.setVisibility(8);
            }
        }

        private final void w(WinkEditorMusicInfo musicInfo) {
            if (musicInfo.f321262i == 2 && !TextUtils.isEmpty(musicInfo.c())) {
                this.coverImageView.setVisibility(0);
                ViewUtilsKt.j(this.coverImageView, musicInfo.c());
            } else {
                this.coverImageView.setVisibility(4);
            }
            if (musicInfo.f321262i == 3) {
                this.coverImageView.setVisibility(0);
                this.coverImageView.setImageResource(R.drawable.ont);
            }
            if (musicInfo.f321259e) {
                this.coverSelectedFrameLayout.setVisibility(0);
            } else {
                this.coverSelectedFrameLayout.setVisibility(8);
            }
        }

        private final void x(WinkEditorMusicInfo musicInfo, int position) {
            int i3 = musicInfo.f321260f;
            if (i3 != 2 && !this.isDownloaded) {
                if (i3 == 1) {
                    if (musicInfo.f321261h >= 0) {
                        if (q().getParent() == null) {
                            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
                            layoutParams.gravity = 17;
                            this.winkMusicItemCoverFl.addView(q(), layoutParams);
                        }
                        q().setVisibility(0);
                    }
                } else {
                    q().setVisibility(8);
                }
            } else {
                this.isDownloaded = true;
                q().setVisibility(8);
            }
            if (q().getVisibility() == 8 && musicInfo.f321259e) {
                s();
                this.songPlayingImageView.setVisibility(0);
            } else {
                this.songPlayingImageView.setVisibility(8);
            }
        }

        private final void y(WinkEditorMusicInfo musicInfo) {
            String q16;
            TextView textView = this.songNameTextView;
            int i3 = musicInfo.f321262i;
            if (i3 == 1) {
                q16 = textView.getContext().getString(R.string.ym9);
            } else if (i3 == 3) {
                q16 = textView.getContext().getString(R.string.ym_);
            } else if (TextUtils.isEmpty(musicInfo.q())) {
                q16 = "";
            } else {
                q16 = musicInfo.q();
                Intrinsics.checkNotNullExpressionValue(q16, "{\n                    mu\u2026ongName\n                }");
            }
            textView.setText(q16);
            if (musicInfo.f321259e) {
                this.songNameTextView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
                this.songNameTextView.setSelected(true);
            } else {
                this.songNameTextView.setEllipsize(TextUtils.TruncateAt.END);
                this.songNameTextView.setSelected(false);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        
            if ((!r4) != false) goto L14;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void z(WinkEditorMusicInfo musicInfo) {
            String str;
            boolean z16;
            String valueOf;
            boolean z17;
            boolean isBlank;
            if (musicInfo.f321262i == 3) {
                this.songSingerTextView.setText("Various Artists");
                this.songDurationTextView.setText("");
                return;
            }
            TextView textView = this.songSingerTextView;
            VsMusicItemInfo j3 = musicInfo.j();
            if (j3 != null && (str = j3.mSingername) != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
            }
            str = "";
            textView.setText(str);
            if (musicInfo.n() != 0) {
                int n3 = musicInfo.n() / 1000;
                int i3 = n3 % 60;
                String str2 = "00";
                if (i3 == 0) {
                    valueOf = "00";
                } else {
                    if (1 <= i3 && i3 < 10) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        valueOf = "0" + i3;
                    } else {
                        valueOf = String.valueOf(i3);
                    }
                }
                int i16 = n3 / 60;
                if (i16 != 0) {
                    if (1 <= i16 && i16 < 10) {
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (z17) {
                        str2 = "0" + i16;
                    } else {
                        str2 = String.valueOf(i16);
                    }
                }
                this.songDurationTextView.setText(" \u00b7 " + str2 + ":" + valueOf);
            } else {
                this.songDurationTextView.setText("");
            }
            if (musicInfo.f321259e) {
                this.songSingerTextView.setSelected(true);
            } else {
                this.songSingerTextView.setSelected(false);
            }
        }

        public final void m(@NotNull WinkEditorMusicInfo musicInfo, @NotNull WinkEditorViewModel.EditMode editMode, int position, @NotNull String pgId) {
            Intrinsics.checkNotNullParameter(musicInfo, "musicInfo");
            Intrinsics.checkNotNullParameter(editMode, "editMode");
            Intrinsics.checkNotNullParameter(pgId, "pgId");
            w(musicInfo);
            x(musicInfo, position);
            y(musicInfo);
            z(musicInfo);
            v(musicInfo, pgId);
            u(musicInfo, editMode, pgId);
        }

        @NotNull
        /* renamed from: o, reason: from getter */
        public final ImageView getClipImageView() {
            return this.clipImageView;
        }

        @NotNull
        /* renamed from: p, reason: from getter */
        public final ImageView getCollectImageView() {
            return this.collectImageView;
        }

        @NotNull
        /* renamed from: r, reason: from getter */
        public final View getParentView() {
            return this.parentView;
        }
    }

    public WinkMusicListAdapter(@NotNull List<? extends WinkEditorMusicInfo> items, @NotNull b73.a musicListCallback) {
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(musicListCallback, "musicListCallback");
        this.items = items;
        this.musicListCallback = musicListCallback;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void m0(WinkEditorMusicInfo musicInfo, ViewHolder holder) {
        int i3;
        int i16;
        VsMusicItemInfo j3;
        Map mapOf;
        String q16 = musicInfo.q();
        Intrinsics.checkNotNullExpressionValue(q16, "musicInfo.songName");
        String str = musicInfo.E;
        long o16 = musicInfo.o();
        Long l3 = WinkEditorMusicInfo.H;
        int i17 = 0;
        if (l3 != null && o16 == l3.longValue()) {
            q16 = "\u6a21\u7248\u97f3\u4e50";
            str = "\u63a8\u8350";
        } else if (musicInfo.f321262i != 3) {
            i3 = 1;
            long o17 = musicInfo.o();
            if ((l3 == null || o17 != l3.longValue()) && musicInfo.f321262i != 3) {
                if (this.musicListCallback.A() != WinkEditorViewModel.EditMode.Image) {
                    i16 = 1;
                    Pair[] pairArr = new Pair[6];
                    pairArr[0] = TuplesKt.to("xsj_music_name", q16);
                    pairArr[1] = TuplesKt.to("xsj_music_id", musicInfo.p());
                    pairArr[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, str);
                    j3 = musicInfo.j();
                    if (j3 != null) {
                        i17 = j3.f320655i;
                    }
                    pairArr[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, String.valueOf(i17));
                    pairArr[4] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_COLLECT, String.valueOf(i3));
                    pairArr[5] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_CUT, String.valueOf(i16));
                    mapOf = MapsKt__MapsKt.mapOf(pairArr);
                    com.tencent.mobileqq.wink.report.a.d(com.tencent.mobileqq.wink.report.a.f326259a, holder.getParentView(), WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_ITEM, null, null, musicInfo.p(), mapOf, null, 76, null);
                }
            }
            i16 = 0;
            Pair[] pairArr2 = new Pair[6];
            pairArr2[0] = TuplesKt.to("xsj_music_name", q16);
            pairArr2[1] = TuplesKt.to("xsj_music_id", musicInfo.p());
            pairArr2[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, str);
            j3 = musicInfo.j();
            if (j3 != null) {
            }
            pairArr2[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, String.valueOf(i17));
            pairArr2[4] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_COLLECT, String.valueOf(i3));
            pairArr2[5] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_CUT, String.valueOf(i16));
            mapOf = MapsKt__MapsKt.mapOf(pairArr2);
            com.tencent.mobileqq.wink.report.a.d(com.tencent.mobileqq.wink.report.a.f326259a, holder.getParentView(), WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_ITEM, null, null, musicInfo.p(), mapOf, null, 76, null);
        }
        i3 = 0;
        long o172 = musicInfo.o();
        if (l3 == null) {
            i16 = 0;
            Pair[] pairArr22 = new Pair[6];
            pairArr22[0] = TuplesKt.to("xsj_music_name", q16);
            pairArr22[1] = TuplesKt.to("xsj_music_id", musicInfo.p());
            pairArr22[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, str);
            j3 = musicInfo.j();
            if (j3 != null) {
            }
            pairArr22[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, String.valueOf(i17));
            pairArr22[4] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_COLLECT, String.valueOf(i3));
            pairArr22[5] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_CUT, String.valueOf(i16));
            mapOf = MapsKt__MapsKt.mapOf(pairArr22);
            com.tencent.mobileqq.wink.report.a.d(com.tencent.mobileqq.wink.report.a.f326259a, holder.getParentView(), WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_ITEM, null, null, musicInfo.p(), mapOf, null, 76, null);
        }
        i16 = 0;
        Pair[] pairArr222 = new Pair[6];
        pairArr222[0] = TuplesKt.to("xsj_music_name", q16);
        pairArr222[1] = TuplesKt.to("xsj_music_id", musicInfo.p());
        pairArr222[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, str);
        j3 = musicInfo.j();
        if (j3 != null) {
        }
        pairArr222[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, String.valueOf(i17));
        pairArr222[4] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_COLLECT, String.valueOf(i3));
        pairArr222[5] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_IF_HAVE_CUT, String.valueOf(i16));
        mapOf = MapsKt__MapsKt.mapOf(pairArr222);
        com.tencent.mobileqq.wink.report.a.d(com.tencent.mobileqq.wink.report.a.f326259a, holder.getParentView(), WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_ITEM, null, null, musicInfo.p(), mapOf, null, 76, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(WinkMusicListAdapter this$0, WinkEditorMusicInfo musicInfo, View view) {
        String str;
        Map<String, ? extends Object> mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(musicInfo, "$musicInfo");
        this$0.musicListCallback.z5(musicInfo);
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        String pgId = this$0.musicListCallback.getPgId();
        Pair[] pairArr = new Pair[4];
        pairArr[0] = TuplesKt.to("xsj_music_id", musicInfo.p());
        pairArr[1] = TuplesKt.to("xsj_music_name", musicInfo.q());
        pairArr[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, musicInfo.E);
        if (musicInfo.x()) {
            str = "1";
        } else {
            str = "0";
        }
        pairArr[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_COLLECT_STATUS, str);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        aVar.a("em_xsj_collect_button", "ev_xsj_abnormal_clck", pgId, mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void p0(WinkMusicListAdapter this$0, WinkEditorMusicInfo musicInfo, View view) {
        Map<String, ? extends Object> mapOf;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(musicInfo, "$musicInfo");
        this$0.musicListCallback.M(true);
        com.tencent.mobileqq.wink.report.a aVar = com.tencent.mobileqq.wink.report.a.f326259a;
        String pgId = this$0.musicListCallback.getPgId();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("xsj_music_id", musicInfo.p()), TuplesKt.to("xsj_music_name", musicInfo.q()), TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, musicInfo.E));
        aVar.a(WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CUT_BUTTON, "ev_xsj_abnormal_clck", pgId, mapOf);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q0(WinkEditorMusicInfo musicInfo, WinkMusicListAdapter this$0, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(musicInfo, "$musicInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (musicInfo.f321262i != 0) {
            this$0.musicListCallback.J0(musicInfo, i3);
        } else {
            w53.b.g("WinkMusicListAdapter", "musicInfo.itemType == WinkEditorMusicInfo.TYPE_PLACEHOLDER");
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NotNull ViewHolder holder, final int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        final WinkEditorMusicInfo winkEditorMusicInfo = this.items.get(position);
        holder.m(winkEditorMusicInfo, this.musicListCallback.A(), position, this.musicListCallback.getPgId());
        holder.getCollectImageView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMusicListAdapter.o0(WinkMusicListAdapter.this, winkEditorMusicInfo, view);
            }
        });
        holder.getClipImageView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMusicListAdapter.p0(WinkMusicListAdapter.this, winkEditorMusicInfo, view);
            }
        });
        holder.getParentView().setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.editor.music.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WinkMusicListAdapter.q0(WinkEditorMusicInfo.this, this, position, view);
            }
        });
        m0(winkEditorMusicInfo, holder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    /* renamed from: r0, reason: merged with bridge method [inline-methods] */
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, "parent");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hds, parent, false);
        Intrinsics.checkNotNullExpressionValue(view, "view");
        return new ViewHolder(view);
    }

    public final void updateData(@NotNull List<? extends WinkEditorMusicInfo> newItems) {
        Intrinsics.checkNotNullParameter(newItems, "newItems");
        this.items = newItems;
    }
}
