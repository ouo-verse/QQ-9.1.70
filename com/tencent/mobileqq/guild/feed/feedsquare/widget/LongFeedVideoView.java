package com.tencent.mobileqq.guild.feed.feedsquare.widget;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.richframework.video.RFWPlayer;
import com.tencent.libra.request.DecodeFormat;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildLongFeedContentComponents;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedListImageExKt;
import com.tencent.mobileqq.guild.feed.util.ah;
import com.tencent.mobileqq.guild.feed.util.ax;
import com.tencent.mobileqq.guild.feed.util.bm;
import com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView;
import com.tencent.mobileqq.guild.feed.video.GuildFeedVideoPlayParamManager;
import com.tencent.mobileqq.guild.feed.widget.GuildBaseWidgetView;
import com.tencent.mobileqq.guild.media.widget.RoundCornerLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStImage;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStVideo;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 i2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00015B\u0011\b\u0016\u0012\u0006\u0010c\u001a\u00020b\u00a2\u0006\u0004\bd\u0010eB\u001b\b\u0016\u0012\u0006\u0010c\u001a\u00020b\u0012\b\u0010g\u001a\u0004\u0018\u00010f\u00a2\u0006\u0004\bd\u0010hJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0002J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\b\u0010\u0015\u001a\u00020\u0004H\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\b\u0010\u001f\u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u0004H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\u001c\u0010'\u001a\u00020\u00042\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0004\u0018\u00010$J\u0010\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0011H\u0007J\u001a\u0010,\u001a\u00020\u00042\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110*J\u001a\u0010,\u001a\u00020\u00042\u0012\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110-J\u000e\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.J\u0006\u00101\u001a\u00020%J\u0016\u00102\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\b\u00103\u001a\u00020\u0004H\u0016J\b\u00104\u001a\u00020\u0004H\u0016J\b\u00105\u001a\u00020\u0004H\u0016J\f\u00107\u001a\u0006\u0012\u0002\b\u000306H\u0016R\u0016\u0010:\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010A\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010@R\u0016\u0010D\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bB\u0010CR$\u0010G\u001a\u0010\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010FR\u0016\u0010J\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IRV\u0010N\u001aB\u0012\f\u0012\n K*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n K*\u0004\u0018\u00010\u00110\u0011 K* \u0012\f\u0012\n K*\u0004\u0018\u00010\u00110\u0011\u0012\f\u0012\n K*\u0004\u0018\u00010\u00110\u0011\u0018\u00010*0*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010Q\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010PR*\u0010X\u001a\u00020\u00192\u0006\u0010R\u001a\u00020\u00198\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010C\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0014\u0010[\u001a\u00020Y8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010ZR\u0016\u0010_\u001a\u00020\\8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010^R\u0014\u0010a\u001a\u00020\u00198BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b`\u0010U\u00a8\u0006j"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView;", "Lcom/tencent/mobileqq/guild/feed/widget/GuildBaseWidgetView;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "Leo1/a;", "", "initView", "L0", "K0", "video", "P0", QCircleScheme.AttrDetail.VIDEO_INFO, "X0", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStImage;", "cover", "D0", "A0", "J0", "", "position", "C0", "Q0", "N0", "Lcom/tencent/superplayer/api/ISuperPlayer;", "superPlayer", "M0", "", "continuePlay", "S0", "show", "Z0", "E0", "U0", "isMute", "V0", "G0", "I0", "Lkotlin/Function1;", "Landroid/view/View;", "clickListener", "z0", "height", "setParentContainerHeight", "Landroid/util/Pair;", "p", "setCoverSize", "Lkotlin/Pair;", "", "r", "setRadius", "F0", "B0", "play", "pause", "a", "Lcom/tencent/mobileqq/guild/feed/video/GuildFeedListBaseVideoView;", "d", "Lx12/t;", "Lx12/t;", "binding", "e", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStVideo;", "mVideoInfo", "", "f", "Ljava/lang/String;", "mVideoKey", tl.h.F, "Z", "mIsPlaying", "i", "Lkotlin/jvm/functions/Function1;", "clickCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "parentContainerHeight", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Conn, "Landroid/util/Pair;", "coverSize", "D", UserInfo.SEX_FEMALE, "radius", "value", "E", "getShowMuteIcon", "()Z", "setShowMuteIcon", "(Z)V", "showMuteIcon", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "timeStatusRunnable", "Lcom/tencent/mobileqq/guild/feed/video/GuildFeedListBaseVideoView$b;", "G", "Lcom/tencent/mobileqq/guild/feed/video/GuildFeedListBaseVideoView$b;", "videoInitListener", "H0", "isInFeedList", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "H", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class LongFeedVideoView extends GuildBaseWidgetView<GProStVideo> implements eo1.a {

    /* renamed from: C, reason: from kotlin metadata */
    private Pair<Integer, Integer> coverSize;

    /* renamed from: D, reason: from kotlin metadata */
    private float radius;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean showMuteIcon;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final Runnable timeStatusRunnable;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private GuildFeedListBaseVideoView.b videoInitListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private x12.t binding;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GProStVideo mVideoInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String mVideoKey;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsPlaying;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Function1<? super View, Unit> clickCallback;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int parentContainerHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\b\u0010\r\u001a\u00020\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/widget/LongFeedVideoView$b", "Lcom/tencent/mobileqq/guild/feed/video/c;", "", "a", "", "timeString", "", "videoDuration", "currentDuration", "b", "Lcom/tencent/superplayer/api/ISuperPlayer;", "videoView", "g", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b extends com.tencent.mobileqq.guild.feed.video.c {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.feed.video.c
        public void a() {
            QLog.d("LongFeedVideoView", 1, "firstFrameRenderCallBack| pos: " + LongFeedVideoView.this.getDataPosInList() + ", changeViewStatus true");
            LongFeedVideoView.this.Z0(false);
            LongFeedVideoView.this.E0();
        }

        @Override // com.tencent.mobileqq.guild.feed.video.c
        public void b(@NotNull String timeString, int videoDuration, int currentDuration) {
            Intrinsics.checkNotNullParameter(timeString, "timeString");
            if (LongFeedVideoView.this.mIsPlaying) {
                String y16 = ax.y(videoDuration - currentDuration);
                x12.t tVar = LongFeedVideoView.this.binding;
                if (tVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    tVar = null;
                }
                tVar.f447016f.setText(y16);
            }
            GuildFeedVideoPlayParamManager.f223979d.h(LongFeedVideoView.this.mVideoKey, currentDuration);
        }

        @Override // com.tencent.mobileqq.guild.feed.video.c
        public void f() {
            QLog.d("LongFeedVideoView", 1, "onVideoLoopStart| ----- isPlaying=" + LongFeedVideoView.this.mIsPlaying + " pos=" + LongFeedVideoView.this.getDataPosInList());
            x12.t tVar = LongFeedVideoView.this.binding;
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tVar = null;
            }
            tVar.f447016f.setVisibility(0);
            LongFeedVideoView.this.E0();
        }

        @Override // com.tencent.mobileqq.guild.feed.video.c
        public void g(@NotNull ISuperPlayer videoView) {
            Intrinsics.checkNotNullParameter(videoView, "videoView");
            super.g(videoView);
            QLog.d("LongFeedVideoView", 1, "onVideoPrepared| ----- isPlaying=" + LongFeedVideoView.this.mIsPlaying + " pos=" + LongFeedVideoView.this.getDataPosInList());
            LongFeedVideoView.this.G0();
            if (LongFeedVideoView.this.mIsPlaying) {
                x12.t tVar = LongFeedVideoView.this.binding;
                if (tVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("binding");
                    tVar = null;
                }
                tVar.f447019i.start();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongFeedVideoView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        int a16 = GuildLongFeedContentComponents.INSTANCE.a();
        this.parentContainerHeight = a16;
        this.coverSize = ah.a(a16);
        this.radius = ViewUtils.dpToPx(6.0f);
        this.timeStatusRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.p
            @Override // java.lang.Runnable
            public final void run() {
                LongFeedVideoView.T0(LongFeedVideoView.this);
            }
        };
        this.videoInitListener = new GuildFeedListBaseVideoView.b() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.q
            @Override // com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView.b
            public final void onInitSuccess() {
                LongFeedVideoView.b1(LongFeedVideoView.this);
            }
        };
        initView();
    }

    private final void A0() {
        RelativeLayout.LayoutParams layoutParams;
        x12.t tVar = this.binding;
        x12.t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        ViewGroup.LayoutParams layoutParams2 = tVar.f447019i.getLayoutParams();
        if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
            layoutParams = (RelativeLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        layoutParams.width = -1;
        layoutParams.height = -1;
        layoutParams.addRule(13);
        x12.t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar2 = tVar3;
        }
        tVar2.f447014d.setScaleType(ImageView.ScaleType.CENTER_CROP);
    }

    private final void C0(int position) {
        Q0();
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447019i.setDataPosInList(position);
    }

    private final void D0(GProStVideo video, GProStImage cover) {
        boolean z16;
        GProStImage gProStImage = video.cover;
        if (bm.h(cover).length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            cover = gProStImage;
        }
        Intrinsics.checkNotNullExpressionValue(cover, "realCover");
        J0(video, cover);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void E0() {
        QLog.d("LongFeedVideoView", 1, "delayHideVideoTime");
        ThreadManagerV2.getUIHandlerV2().removeCallbacks(this.timeStatusRunnable);
        ThreadManagerV2.getUIHandlerV2().postDelayed(this.timeStatusRunnable, 4000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G0() {
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447019i.setLoopBack(true);
        U0();
    }

    private final boolean H0() {
        return !this.showMuteIcon;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final boolean I0() {
        String str;
        String str2;
        String str3;
        GProStVideo gProStVideo;
        GProStVideo gProStVideo2;
        x12.t tVar = this.binding;
        String str4 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        GuildFeedListBaseVideoView guildFeedListBaseVideoView = tVar.f447019i;
        if (!(guildFeedListBaseVideoView instanceof GuildFeedListBaseVideoView)) {
            guildFeedListBaseVideoView = null;
        }
        if (guildFeedListBaseVideoView != null && (gProStVideo2 = (GProStVideo) guildFeedListBaseVideoView.getData()) != null) {
            str = gProStVideo2.videoMD5;
        } else {
            str = null;
        }
        GProStVideo gProStVideo3 = this.mVideoInfo;
        if (gProStVideo3 != null) {
            str2 = gProStVideo3.videoMD5;
        } else {
            str2 = null;
        }
        if (guildFeedListBaseVideoView != null && (gProStVideo = (GProStVideo) guildFeedListBaseVideoView.getData()) != null) {
            str3 = gProStVideo.fileId;
        } else {
            str3 = null;
        }
        GProStVideo gProStVideo4 = this.mVideoInfo;
        if (gProStVideo4 != null) {
            str4 = gProStVideo4.fileId;
        }
        if (TextUtils.equals(str, str2) && TextUtils.equals(str3, str4)) {
            return true;
        }
        return false;
    }

    private final void J0(GProStVideo video, GProStImage cover) {
        boolean z16;
        String str;
        int coerceAtLeast;
        int coerceAtLeast2;
        String h16 = bm.h(cover);
        if (h16.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        x12.t tVar = null;
        if (z16) {
            x12.t tVar2 = this.binding;
            if (tVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                tVar = tVar2;
            }
            ImageView imageView = tVar.f447014d;
            Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildFeedItemVideoCover");
            Object obj = this.coverSize.first;
            Intrinsics.checkNotNullExpressionValue(obj, "coverSize.first");
            int intValue = ((Number) obj).intValue();
            Object obj2 = this.coverSize.second;
            Intrinsics.checkNotNullExpressionValue(obj2, "coverSize.second");
            GuildFeedListImageExKt.h(imageView, video, intValue, ((Number) obj2).intValue());
            return;
        }
        String d16 = com.tencent.mobileqq.guild.picload.e.d(h16);
        x12.t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar3 = null;
        }
        ImageView imageView2 = tVar3.f447014d;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.guildFeedItemVideoCover");
        Object tag = imageView2.getTag(R.id.wbk);
        if (tag instanceof String) {
            str = (String) tag;
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        if (!TextUtils.isEmpty(d16) && !Intrinsics.areEqual(d16, str)) {
            imageView2.setTag(R.id.wbk, d16);
            imageView2.setImageDrawable(ContextCompat.getDrawable(getContext(), R.drawable.f162601b70));
            Option loadingDrawable = Option.obtain().setTargetView(imageView2).setUrl(h16).setLoadingDrawable(ContextCompat.getDrawable(getContext(), R.drawable.f162601b70));
            Object obj3 = this.coverSize.first;
            Intrinsics.checkNotNullExpressionValue(obj3, "coverSize.first");
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(((Number) obj3).intValue(), 0);
            Option requestWidth = loadingDrawable.setRequestWidth(coerceAtLeast);
            Object obj4 = this.coverSize.second;
            Intrinsics.checkNotNullExpressionValue(obj4, "coverSize.second");
            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(((Number) obj4).intValue(), 0);
            com.tencent.mobileqq.guild.picload.e.a().f(requestWidth.setRequestHeight(coerceAtLeast2).setPreferDecodeFormat(DecodeFormat.PREFER_RGB_565), null);
            return;
        }
        QLog.i("LongFeedVideoView", 1, "loadVideoCoverIfNeeded fail");
    }

    private final void K0() {
        x12.t tVar = this.binding;
        x12.t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        if (tVar.f447019i.getOutPutMute()) {
            x12.t tVar3 = this.binding;
            if (tVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                tVar2 = tVar3;
            }
            tVar2.f447019i.setOutPutMute(false);
            V0(false);
            GuildFeedVideoPlayParamManager.f223979d.g(false);
            return;
        }
        x12.t tVar4 = this.binding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar2 = tVar4;
        }
        tVar2.f447019i.setOutPutMute(true);
        V0(true);
        GuildFeedVideoPlayParamManager.f223979d.g(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L0() {
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        ISuperPlayer superPlayer = tVar.f447019i.getSuperPlayer();
        boolean z16 = false;
        if (superPlayer != null && superPlayer.isPlaying()) {
            z16 = true;
        }
        if (!z16) {
            QLog.d("LongFeedVideoView", 1, "[onClick mMuteIcon] return for is not Playing");
        } else {
            K0();
        }
    }

    private final void M0(ISuperPlayer superPlayer) {
        if (!I0()) {
            QLog.d("LongFeedVideoView", 1, "playWhenOldPlayerIsExist  !isPlaySameVideo, startANewPlayer");
            S0(true);
            return;
        }
        if (superPlayer.isPlaying()) {
            U0();
            QLog.d("LongFeedVideoView", 1, "playWhenOldPlayerIsExist  isPlaying , return");
            return;
        }
        if (superPlayer.isPausing()) {
            GuildFeedVideoPlayParamManager guildFeedVideoPlayParamManager = GuildFeedVideoPlayParamManager.f223979d;
            QLog.d("LongFeedVideoView", 1, "playWhenOldPlayerIsExist  isPausing , start play, offset = " + guildFeedVideoPlayParamManager.d(this.mVideoKey));
            x12.t tVar = this.binding;
            x12.t tVar2 = null;
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tVar = null;
            }
            tVar.f447019i.getSuperPlayer().seekTo(guildFeedVideoPlayParamManager.d(this.mVideoKey), 3);
            U0();
            x12.t tVar3 = this.binding;
            if (tVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                tVar2 = tVar3;
            }
            tVar2.f447019i.start();
            Z0(false);
            E0();
            QLog.d("LongFeedVideoView", 1, "playWhenOldPlayerIsExist  isPausing , start play");
            return;
        }
        QLog.d("LongFeedVideoView", 1, "playWhenOldPlayerIsExist  startANewPlayer");
        S0(true);
    }

    private final void N0() {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.o
            @Override // java.lang.Runnable
            public final void run() {
                LongFeedVideoView.O0(LongFeedVideoView.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void O0(LongFeedVideoView this$0) {
        long j3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GProStVideo gProStVideo = this$0.mVideoInfo;
        if (gProStVideo != null) {
            j3 = gProStVideo.duration;
        } else {
            j3 = 0;
        }
        x12.t tVar = this$0.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447016f.setText(ax.y(j3));
    }

    private final void P0(GProStVideo video) {
        this.mVideoInfo = video;
        this.mVideoKey = com.tencent.mobileqq.guild.feed.video.e.f223991a.b(video);
    }

    private final void Q0() {
        x12.t tVar = this.binding;
        x12.t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        ISuperPlayer superPlayer = tVar.f447019i.getSuperPlayer();
        if (superPlayer != null) {
            superPlayer.setXYaxis(2);
        }
        x12.t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar2 = tVar3;
        }
        tVar2.f447019i.requestLayout();
    }

    private final void S0(boolean continuePlay) {
        String str;
        long j3;
        GProStVideo gProStVideo = this.mVideoInfo;
        x12.t tVar = null;
        if (gProStVideo != null) {
            str = gProStVideo.playUrl;
        } else {
            str = null;
        }
        if (str == null) {
            QLog.d("LongFeedVideoView", 1, "startANewPlayer fail");
            return;
        }
        x12.t tVar2 = this.binding;
        if (tVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar2 = null;
        }
        GuildFeedListBaseVideoView guildFeedListBaseVideoView = tVar2.f447019i;
        GProStVideo data = getData();
        if (data == null) {
            data = this.mVideoInfo;
        }
        guildFeedListBaseVideoView.setData(data, getDataPosInList());
        String b16 = com.tencent.mobileqq.guild.feed.video.e.f223991a.b(this.mVideoInfo);
        this.mVideoKey = b16;
        if (continuePlay) {
            j3 = GuildFeedVideoPlayParamManager.f223979d.d(b16);
        } else {
            j3 = 0;
        }
        x12.t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar3 = null;
        }
        tVar3.f447019i.setInitListener(this.videoInitListener);
        x12.t tVar4 = this.binding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar = tVar4;
        }
        tVar.f447019i.setVideoWithExchangeUrl(this.mVideoInfo, (int) j3);
        QLog.d("LongFeedVideoView", 1, "[startANewPlayer] playUrlKey=" + this.mVideoKey + " startOffset=" + j3 + " startOffset=" + hashCode());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T0(LongFeedVideoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x12.t tVar = this$0.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447016f.setVisibility(8);
    }

    private final void U0() {
        boolean c16 = GuildFeedVideoPlayParamManager.f223979d.c();
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447019i.setOutPutMute(c16);
        V0(c16);
    }

    private final void V0(final boolean isMute) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.r
                @Override // java.lang.Runnable
                public final void run() {
                    LongFeedVideoView.W0(LongFeedVideoView.this, isMute);
                }
            });
            return;
        }
        x12.t tVar = this.binding;
        FrameLayout.LayoutParams layoutParams = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        ImageView imageView = tVar.f447018h;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.guildFeedVideoOutPutMuteIcon");
        if (imageView.getVisibility() == 8) {
            imageView.setVisibility(0);
        }
        if (isMute) {
            imageView.setImageResource(R.drawable.guild_feed_item_voice_mute);
            ViewGroup.LayoutParams layoutParams2 = imageView.getLayoutParams();
            if (layoutParams2 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams2;
            }
            if (layoutParams != null) {
                layoutParams.rightMargin = ViewUtils.dip2px(9.0f);
            }
            imageView.requestLayout();
        } else {
            imageView.setImageResource(R.drawable.guild_feed_item_voice_high);
            ViewGroup.LayoutParams layoutParams3 = imageView.getLayoutParams();
            if (layoutParams3 instanceof FrameLayout.LayoutParams) {
                layoutParams = (FrameLayout.LayoutParams) layoutParams3;
            }
            if (layoutParams != null) {
                layoutParams.rightMargin = ViewUtils.dip2px(7.0f);
            }
            imageView.requestLayout();
        }
        imageView.setColorFilter(-1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W0(LongFeedVideoView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.V0(z16);
    }

    private final void X0(final GProStVideo videoInfo) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.s
                @Override // java.lang.Runnable
                public final void run() {
                    LongFeedVideoView.Y0(LongFeedVideoView.this, videoInfo);
                }
            });
            return;
        }
        int d16 = videoInfo.duration - GuildFeedVideoPlayParamManager.f223979d.d(this.mVideoKey);
        x12.t tVar = this.binding;
        x12.t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447016f.setVisibility(0);
        x12.t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar2 = tVar3;
        }
        tVar2.f447016f.setText(ax.y(d16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(LongFeedVideoView this$0, GProStVideo videoInfo) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(videoInfo, "$videoInfo");
        this$0.X0(videoInfo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Z0(final boolean show) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.n
                @Override // java.lang.Runnable
                public final void run() {
                    LongFeedVideoView.a1(LongFeedVideoView.this, show);
                }
            });
            return;
        }
        x12.t tVar = this.binding;
        x12.t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447016f.setVisibility(0);
        if (show) {
            x12.t tVar3 = this.binding;
            if (tVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tVar3 = null;
            }
            tVar3.f447015e.setVisibility(0);
            x12.t tVar4 = this.binding;
            if (tVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                tVar2 = tVar4;
            }
            tVar2.f447014d.setVisibility(0);
            return;
        }
        x12.t tVar5 = this.binding;
        if (tVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar5 = null;
        }
        tVar5.f447015e.setVisibility(8);
        x12.t tVar6 = this.binding;
        if (tVar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar2 = tVar6;
        }
        tVar2.f447014d.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a1(LongFeedVideoView this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Z0(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b1(LongFeedVideoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        x12.t tVar = this$0.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447019i.setBaseVideoViewListenerSets(new b());
    }

    private final void initView() {
        x12.t g16 = x12.t.g(com.tencent.guild.aio.reserve2.busi.chosen.view.c.a(this), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater, this, true)");
        this.binding = g16;
        x12.t tVar = null;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        g16.f447018h.setColorFilter(-1);
        x12.t tVar2 = this.binding;
        if (tVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar2 = null;
        }
        FrameLayout frameLayout = tVar2.f447017g;
        Boolean valueOf = Boolean.valueOf(this.showMuteIcon);
        frameLayout.setVisibility(0);
        if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, frameLayout)) == null) {
            frameLayout.setVisibility(8);
        }
        x12.t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar3 = null;
        }
        final FrameLayout frameLayout2 = tVar3.f447017g;
        Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.guildFeedVideoOutPutMuteFrameLayout");
        final long j3 = 200;
        frameLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView$initView$$inlined$setSingleClickListener$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                EventCollector.getInstance().onViewClickedBefore(it);
                frameLayout2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this.L0();
                final View view = frameLayout2;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView$initView$$inlined$setSingleClickListener$1.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
        x12.t tVar4 = this.binding;
        if (tVar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar4 = null;
        }
        RoundCornerLayout roundCornerLayout = tVar4.f447013c;
        float f16 = this.radius;
        roundCornerLayout.setRadius(f16, f16, 0.0f, 0.0f);
        x12.t tVar5 = this.binding;
        if (tVar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar = tVar5;
        }
        final RoundCornerLayout roundCornerLayout2 = tVar.f447013c;
        Intrinsics.checkNotNullExpressionValue(roundCornerLayout2, "binding.guildFeedItemSingleVideoLayout");
        roundCornerLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView$initView$$inlined$setSingleClickListener$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View it) {
                Function1 function1;
                EventCollector.getInstance().onViewClickedBefore(it);
                roundCornerLayout2.setClickable(false);
                Intrinsics.checkNotNullExpressionValue(it, "it");
                function1 = this.clickCallback;
                if (function1 != null) {
                    function1.invoke(it);
                }
                final View view = roundCornerLayout2;
                view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.LongFeedVideoView$initView$$inlined$setSingleClickListener$2.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        view.setClickable(true);
                    }
                }, j3);
                EventCollector.getInstance().onViewClicked(it);
            }
        });
    }

    public final void B0(@NotNull GProStVideo videoInfo, @NotNull GProStImage cover) {
        Intrinsics.checkNotNullParameter(videoInfo, "videoInfo");
        Intrinsics.checkNotNullParameter(cover, "cover");
        QLog.d("LongFeedVideoView", 1, "[bindVideoInfoData] position=" + getDataPosInList() + " hashcode=" + hashCode());
        P0(videoInfo);
        A0();
        D0(videoInfo, cover);
        C0(getDataPosInList());
        X0(videoInfo);
    }

    @NotNull
    public final View F0() {
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        RoundCornerLayout roundCornerLayout = tVar.f447013c;
        Intrinsics.checkNotNullExpressionValue(roundCornerLayout, "binding.guildFeedItemSingleVideoLayout");
        return roundCornerLayout;
    }

    @Override // eo1.a
    public void a() {
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        tVar.f447019i.a();
        Z0(true);
    }

    @Override // eo1.a
    @NotNull
    public GuildFeedListBaseVideoView<?> d() {
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        GuildFeedListBaseVideoView<?> guildFeedListBaseVideoView = tVar.f447019i;
        Intrinsics.checkNotNullExpressionValue(guildFeedListBaseVideoView, "binding.guildVideoView");
        return guildFeedListBaseVideoView;
    }

    @Override // eo1.a
    public void pause() {
        QLog.d("LongFeedVideoView", 1, "[pause]");
        x12.t tVar = this.binding;
        x12.t tVar2 = null;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        RFWPlayer o06 = tVar.f447019i.o0();
        if (o06 != null) {
            o06.pause();
        }
        x12.t tVar3 = this.binding;
        if (tVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            tVar2 = tVar3;
        }
        tVar2.f447018h.setVisibility(8);
        Z0(true);
        N0();
        this.mIsPlaying = false;
    }

    @Override // eo1.a
    public void play() {
        if (H0()) {
            QLog.d("LongFeedVideoView", 1, "[play] return for not AUTO_PLAY_ENABLED");
            return;
        }
        if (!GuildFeedVideoPlayParamManager.f223979d.f()) {
            QLog.d("LongFeedVideoView", 1, "[play] return for no Wifi or not FreeFlow");
            return;
        }
        x12.t tVar = this.binding;
        if (tVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            tVar = null;
        }
        ISuperPlayer superPlayer = tVar.f447019i.getSuperPlayer();
        if (superPlayer != null) {
            QLog.d("LongFeedVideoView", 1, "[play] playWhenOldPlayerIsExist");
            M0(superPlayer);
        } else {
            S0(true);
            QLog.d("LongFeedVideoView", 1, "[play] startANewPlayer");
        }
        this.mIsPlaying = true;
    }

    public final void setCoverSize(@NotNull Pair<Integer, Integer> p16) {
        Intrinsics.checkNotNullParameter(p16, "p");
        this.coverSize = p16;
    }

    @Deprecated(message = "use setCoverSize")
    public final void setParentContainerHeight(int height) {
        this.coverSize = ah.a(height);
    }

    public final void setRadius(float r16) {
        this.radius = r16;
        x12.t tVar = this.binding;
        if (tVar != null) {
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tVar = null;
            }
            RoundCornerLayout roundCornerLayout = tVar.f447013c;
            float f16 = this.radius;
            roundCornerLayout.setRadius(f16, f16, f16, f16);
        }
    }

    public final void setShowMuteIcon(boolean z16) {
        this.showMuteIcon = z16;
        x12.t tVar = this.binding;
        if (tVar != null) {
            if (tVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                tVar = null;
            }
            FrameLayout frameLayout = tVar.f447017g;
            Boolean valueOf = Boolean.valueOf(z16);
            frameLayout.setVisibility(0);
            if (((View) com.tencent.guild.aio.util.ex.g.a(valueOf, frameLayout)) == null) {
                frameLayout.setVisibility(8);
            }
        }
    }

    public final void z0(@Nullable Function1<? super View, Unit> clickListener) {
        this.clickCallback = clickListener;
    }

    public final void setCoverSize(@NotNull kotlin.Pair<Integer, Integer> p16) {
        Intrinsics.checkNotNullParameter(p16, "p");
        this.coverSize = new Pair<>(p16.getFirst(), p16.getSecond());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LongFeedVideoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        int a16 = GuildLongFeedContentComponents.INSTANCE.a();
        this.parentContainerHeight = a16;
        this.coverSize = ah.a(a16);
        this.radius = ViewUtils.dpToPx(6.0f);
        this.timeStatusRunnable = new Runnable() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.p
            @Override // java.lang.Runnable
            public final void run() {
                LongFeedVideoView.T0(LongFeedVideoView.this);
            }
        };
        this.videoInitListener = new GuildFeedListBaseVideoView.b() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.widget.q
            @Override // com.tencent.mobileqq.guild.feed.video.GuildFeedListBaseVideoView.b
            public final void onInitSuccess() {
                LongFeedVideoView.b1(LongFeedVideoView.this);
            }
        };
        initView();
    }
}
