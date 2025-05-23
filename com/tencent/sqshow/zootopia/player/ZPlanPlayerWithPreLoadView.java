package com.tencent.sqshow.zootopia.player;

import android.content.Context;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.engineering.preload.PreLoader;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.player.preload.VideoPlayerPreLoadManager;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import na4.d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB)\b\u0007\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0017\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001c\u0010\t\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\f\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\r\u001a\u00020\u0004H\u0014J\b\u0010\u000e\u001a\u00020\u0004H\u0014J\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0011\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/sqshow/zootopia/player/ZPlanPlayerWithPreLoadView;", "Lcom/tencent/sqshow/zootopia/player/ZootopiaPlayerView;", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "", UserInfo.SEX_FEMALE, "O", "", "isMultiLevel", "K", "G", "M", "H", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "I", "J", "Lcom/tencent/sqshow/zootopia/player/f;", "currentOptions", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "L", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanPlayerWithPreLoadView extends ZootopiaPlayerView {

    /* renamed from: K, reason: from kotlin metadata */
    private f currentOptions;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/player/ZPlanPlayerWithPreLoadView$b", "Lka4/b;", "Lcom/tencent/sqshow/zootopia/player/q;", "player", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements ka4.b {
        b() {
        }

        @Override // ka4.b
        public void a(q player) {
            QLog.d("ZPlanPlayerWithPreLoadView", 1, "onVideoPrepared, real play:" + player);
            ZPlanPlayerWithPreLoadView.this.O();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/sqshow/zootopia/player/ZPlanPlayerWithPreLoadView$c", "Lma4/a;", "Lcom/tencent/sqshow/zootopia/player/q;", "player", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements ma4.a {
        c() {
        }

        @Override // ma4.a
        public void a(q player) {
            QLog.d("ZPlanPlayerWithPreLoadView", 1, "onInitSuccess");
            ZPlanPlayerWithPreLoadView.this.g();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/sqshow/zootopia/player/ZPlanPlayerWithPreLoadView$d", "Lka4/a;", "", "module", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ERROR_TYPE, "errorCode", "", "extraInfo", "", "onVideoPlayError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements ka4.a {
        d() {
        }

        @Override // ka4.a
        public void onVideoPlayError(int module, int errorType, int errorCode, String extraInfo) {
            QLog.d("ZPlanPlayerWithPreLoadView", 1, "onVideoPlayError, module:" + module + ", errorType:" + errorType + ", errorCode" + errorCode + ", extraInfo:" + extraInfo);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/sqshow/zootopia/player/ZPlanPlayerWithPreLoadView$e", "Lna4/d$b;", "Lcom/tencent/sqshow/zootopia/player/f;", "options", "", "continueNextProcess", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements d.b {
        e() {
        }

        @Override // na4.d.b
        public void a(f options, boolean continueNextProcess) {
            Intrinsics.checkNotNullParameter(options, "options");
            QLog.d("ZPlanPlayerWithPreLoadView", 1, "url selected onFinish, selected play url: " + options.f());
            ZPlanPlayerWithPreLoadView.this.G(options);
        }
    }

    public ZPlanPlayerWithPreLoadView(Context context) {
        this(context, null, 0, 6, null);
    }

    private final void F(f options) {
        com.tencent.sqshow.zootopia.player.e b16;
        com.tencent.sqshow.zootopia.player.e c16;
        com.tencent.sqshow.zootopia.player.e playerListenerSet = options.getPlayerListenerSet();
        if (playerListenerSet == null || (b16 = playerListenerSet.b(new b())) == null || (c16 = b16.c(new c())) == null) {
            return;
        }
        c16.a(new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G(f options) {
        QLog.d("ZPlanPlayerWithPreLoadView", 1, "doPlay, options: " + options);
        setVideoUrl(options != null ? options.f() : null);
        com.tencent.sqshow.zootopia.player.c player = getPlayer();
        if (player != null) {
            player.setXYaxis(getVideoXYaxis());
        }
        ZootopiaPlayerView.z(this, false, false, 1, null);
    }

    private final void K(f options, boolean isMultiLevel) {
        QLog.d("ZPlanPlayerWithPreLoadView", 1, "startByNewPlayer");
        if (isMultiLevel) {
            QLog.d("ZPlanPlayerWithPreLoadView", 1, "select url before start");
            LinkedList<Integer> linkedList = new LinkedList<>();
            d.Companion companion = na4.d.INSTANCE;
            linkedList.add(Integer.valueOf(companion.b()));
            companion.a().j(linkedList, options, new e());
            return;
        }
        G(options);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void N(ZPlanPlayerWithPreLoadView this$0, f options, VideoPlayerPreLoadManager.b[] bVarArr) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(options, "$options");
        VideoPlayerPreLoadManager a16 = VideoPlayerPreLoadManager.INSTANCE.a();
        f fVar = this$0.currentOptions;
        a16.m(fVar != null ? fVar.a() : null);
        boolean z16 = false;
        VideoPlayerPreLoadManager.b bVar = bVarArr[0];
        q player = bVar != null ? bVar.getPlayer() : null;
        if (bVar.getIsPreloadError()) {
            QLog.d("ZPlanPlayerWithPreLoadView", 1, "isPreloadError, startByNewPlayer");
            if (player != null) {
                player.L();
            }
            L(this$0, options, false, 2, null);
            return;
        }
        f playerOptions = player != null ? player.getPlayerOptions() : null;
        if (playerOptions != null) {
            playerOptions.l(options.getPlayerListenerSet());
        }
        this$0.x(player);
        com.tencent.sqshow.zootopia.player.d dVar = com.tencent.sqshow.zootopia.player.d.f372208a;
        com.tencent.sqshow.zootopia.player.c player2 = this$0.getPlayer();
        Intrinsics.checkNotNull(player2, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.player.ZootopiaSuperPlayer");
        dVar.a(options, (q) player2);
        com.tencent.sqshow.zootopia.player.c player3 = this$0.getPlayer();
        QLog.d("ZPlanPlayerWithPreLoadView", 1, "status: " + (player3 != null ? player3.getCurrStatus() : null) + ", player:" + player);
        com.tencent.sqshow.zootopia.player.c player4 = this$0.getPlayer();
        if (player4 != null && player4.isPrepared()) {
            z16 = true;
        }
        if (z16) {
            QLog.d("ZPlanPlayerWithPreLoadView", 1, "is prepared, play pre load view");
            com.tencent.sqshow.zootopia.player.c player5 = this$0.getPlayer();
            Intrinsics.checkNotNull(player5, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.player.ZootopiaSuperPlayer");
            com.tencent.sqshow.zootopia.player.c player6 = this$0.getPlayer();
            Intrinsics.checkNotNull(player6, "null cannot be cast to non-null type com.tencent.sqshow.zootopia.player.ZootopiaSuperPlayer");
            ((q) player5).onVideoPrepared(((q) player6).getPlayer());
            return;
        }
        QLog.d("ZPlanPlayerWithPreLoadView", 1, "player is not prepared, wait");
    }

    public final void M(final f options) {
        Intrinsics.checkNotNullParameter(options, "options");
        this.currentOptions = options;
        String a16 = options.a();
        QLog.d("ZPlanPlayerWithPreLoadView", 1, "fileId: " + a16);
        if (H(options)) {
            F(options);
            PreLoader.addListener(a16, new OnTaskListener() { // from class: com.tencent.sqshow.zootopia.player.g
                @Override // com.tencent.mobileqq.engineering.preload.inter.OnTaskListener
                public final void onComplete(Object[] objArr) {
                    ZPlanPlayerWithPreLoadView.N(ZPlanPlayerWithPreLoadView.this, options, (VideoPlayerPreLoadManager.b[]) objArr);
                }
            });
        } else {
            L(this, options, false, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.player.ZootopiaPlayerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.sqshow.zootopia.player.ZootopiaPlayerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        I();
    }

    public ZPlanPlayerWithPreLoadView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O() {
        QLog.d("ZPlanPlayerWithPreLoadView", 1, "startWithPreLoad");
        com.tencent.sqshow.zootopia.player.c player = getPlayer();
        ISuperPlayer player2 = player != null ? player.getPlayer() : null;
        if (player2 != null) {
            player2.setOutputMute(false);
        }
        com.tencent.sqshow.zootopia.player.c player3 = getPlayer();
        if (player3 != null) {
            player3.setXYaxis(getVideoXYaxis());
        }
        com.tencent.sqshow.zootopia.player.c player4 = getPlayer();
        if (player4 != null) {
            player4.startPlay();
        }
    }

    public final void I() {
        QLog.e("ZPlanPlayerWithPreLoadView", 1, "pause player");
        com.tencent.sqshow.zootopia.player.c player = getPlayer();
        if (player != null) {
            player.pause();
        }
    }

    public final void J() {
        QLog.e("ZPlanPlayerWithPreLoadView", 1, "clear player");
        I();
        v();
    }

    public /* synthetic */ ZPlanPlayerWithPreLoadView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public final boolean H(f options) {
        String a16 = options != null ? options.a() : null;
        if (a16 == null || a16.length() == 0) {
            return false;
        }
        return PreLoader.exists(a16) && VideoPlayerPreLoadManager.INSTANCE.a().i(a16);
    }

    public ZPlanPlayerWithPreLoadView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }

    static /* synthetic */ void L(ZPlanPlayerWithPreLoadView zPlanPlayerWithPreLoadView, f fVar, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        zPlanPlayerWithPreLoadView.K(fVar, z16);
    }
}
