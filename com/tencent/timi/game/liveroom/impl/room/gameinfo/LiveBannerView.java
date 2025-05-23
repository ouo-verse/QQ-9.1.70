package com.tencent.timi.game.liveroom.impl.room.gameinfo;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.liveroom.impl.room.gameinfo.LiveBannerView;
import com.tencent.timi.game.utils.w;
import com.tencent.timi.game.web.business.api.race.LivingRoomInfo;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import nf4.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import si4.b;
import tl.h;
import trpc.yes.common.PremadesTeamServerOuterClass$AnchorGameInfo;
import trpc.yes.common.PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010I\u001a\u00020H\u0012\n\b\u0002\u0010K\u001a\u0004\u0018\u00010J\u00a2\u0006\u0004\bL\u0010MJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\b\u0010\u000f\u001a\u00020\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J\b\u0010\u0013\u001a\u00020\u0004H\u0014J\b\u0010\u0014\u001a\u00020\u0004H\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00158\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010$\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010+\u001a\u0004\u0018\u00010%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R$\u00103\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010;\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010?\u001a\u0002048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u00106\u001a\u0004\b=\u00108\"\u0004\b>\u0010:R\"\u0010G\u001a\u00020@8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u00a8\u0006N"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/LiveBannerView;", "Lcom/tencent/timi/game/liveroom/impl/room/gameinfo/BaseLiveGameInfoView;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;", "liveRoomInfoRsp", "", "o", "Lkf4/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lsi4/a;", "r", "p", "Ltrpc/yes/common/PremadesTeamServerOuterClass$AnchorGameInfo;", "info", DomainData.DOMAIN_NAME, "Lcom/tencent/timi/game/web/business/api/race/LivingRoomInfo;", "e", "", "showTag", "j", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "", h.F, "Ljava/lang/String;", "getAnchorId", "()Ljava/lang/String;", "setAnchorId", "(Ljava/lang/String;)V", "anchorId", "", "i", "I", "getGameId", "()I", "setGameId", "(I)V", VirtualAppProxy.KEY_GAME_ID, "Lkf4/a;", "Lkf4/a;", "getCurGuildInfo", "()Lkf4/a;", "setCurGuildInfo", "(Lkf4/a;)V", "curGuildInfo", "Lnf4/c$a;", BdhLogUtil.LogTag.Tag_Conn, "Lnf4/c$a;", "getBannerState", "()Lnf4/c$a;", "setBannerState", "(Lnf4/c$a;)V", "bannerState", "", "D", "J", "getWebProcessKeepDuration", "()J", "setWebProcessKeepDuration", "(J)V", "webProcessKeepDuration", "E", "getLastTimeLaunchWebProcess", "setLastTimeLaunchWebProcess", "lastTimeLaunchWebProcess", "Lsi4/b;", UserInfo.SEX_FEMALE, "Lsi4/b;", "getPushManager", "()Lsi4/b;", "setPushManager", "(Lsi4/b;)V", "pushManager", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class LiveBannerView extends BaseLiveGameInfoView {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private c.a bannerState;

    /* renamed from: D, reason: from kotlin metadata */
    private long webProcessKeepDuration;

    /* renamed from: E, reason: from kotlin metadata */
    private long lastTimeLaunchWebProcess;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private b pushManager;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String anchorId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int gameId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private kf4.a curGuildInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/gameinfo/LiveBannerView$a", "Lsi4/b;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp;", "liveRoomInfoRsp", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a implements b {
        a() {
        }

        @Override // si4.b
        public void a(@Nullable PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp liveRoomInfoRsp) {
            LiveBannerView.this.o(liveRoomInfoRsp);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveBannerView(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final kf4.b m() {
        return r().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void o(PremadesTeamServerOuterClass$GetChannelLiveRoomInfoRsp liveRoomInfoRsp) {
        String str;
        String str2;
        PBStringField pBStringField;
        PBStringField pBStringField2;
        PremadesTeamServerOuterClass$AnchorGameInfo premadesTeamServerOuterClass$AnchorGameInfo = null;
        if (liveRoomInfoRsp != null && (pBStringField2 = liveRoomInfoRsp.anchor_id) != null) {
            str = pBStringField2.get();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (liveRoomInfoRsp != null && (pBStringField = liveRoomInfoRsp.anchor_id) != null) {
                str2 = pBStringField.get();
            } else {
                str2 = null;
            }
            this.anchorId = str2;
        }
        if (liveRoomInfoRsp != null) {
            premadesTeamServerOuterClass$AnchorGameInfo = liveRoomInfoRsp.game_info;
        }
        n(premadesTeamServerOuterClass$AnchorGameInfo);
    }

    private final void p() {
        if (System.currentTimeMillis() - this.lastTimeLaunchWebProcess > this.webProcessKeepDuration) {
            w.a(new Runnable() { // from class: nj4.b
                @Override // java.lang.Runnable
                public final void run() {
                    LiveBannerView.q(LiveBannerView.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(LiveBannerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((lo4.a) mm4.b.b(lo4.a.class)).K1();
        this$0.lastTimeLaunchWebProcess = System.currentTimeMillis();
    }

    private final si4.a r() {
        si4.a l26 = ((ni4.a) mm4.b.b(ni4.a.class)).l2();
        Intrinsics.checkNotNullExpressionValue(l26, "getService(IAnchorRoomSe\u2026ss.java).liveApiManager()");
        return l26;
    }

    @Override // com.tencent.timi.game.liveroom.impl.room.gameinfo.BaseLiveGameInfoView
    @NotNull
    public LivingRoomInfo e() {
        String str;
        String str2;
        LivingRoomInfo livingRoomInfo = new LivingRoomInfo();
        livingRoomInfo.setFromGuild(true);
        kf4.b m3 = m();
        String str3 = null;
        if (m3 != null) {
            str = m3.f412313b;
        } else {
            str = null;
        }
        String str4 = "";
        if (str == null) {
            str = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str, "anchorInfo()?.nick ?: \"\"");
        }
        livingRoomInfo.setAnchorNick(str);
        kf4.b m16 = m();
        if (m16 != null) {
            str2 = m16.f412314c;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        } else {
            Intrinsics.checkNotNullExpressionValue(str2, "anchorInfo()?.avatarUrl ?: \"\"");
        }
        livingRoomInfo.setAnchorHeadUrl(str2);
        String str5 = this.anchorId;
        if (str5 == null) {
            kf4.b m17 = m();
            if (m17 != null) {
                str3 = m17.f412312a;
            }
            if (str3 != null) {
                str4 = str3;
            }
        } else {
            str4 = str5;
        }
        livingRoomInfo.setAnchorId(str4);
        livingRoomInfo.setRoomId(String.valueOf(r().g()));
        livingRoomInfo.setAnchor(r().b());
        livingRoomInfo.setGameId(this.gameId);
        return livingRoomInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.liveroom.impl.room.gameinfo.BaseLiveGameInfoView
    public void j(@Nullable PremadesTeamServerOuterClass$AnchorGameInfo info, boolean showTag) {
        int i3;
        super.j(info, showTag);
        if (getVisibility() == 0) {
            p();
            i3 = com.tencent.timi.game.utils.b.a(54);
        } else {
            i3 = 0;
        }
        c.a aVar = this.bannerState;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    public final void n(@Nullable PremadesTeamServerOuterClass$AnchorGameInfo info) {
        g(info, true);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.curGuildInfo == null) {
            this.curGuildInfo = r().k();
        }
        kf4.a aVar = this.curGuildInfo;
        if (aVar != null) {
            r().j(aVar, this.pushManager);
            o(r().h(aVar));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        r().f(this.pushManager);
    }

    public final void setAnchorId(@Nullable String str) {
        this.anchorId = str;
    }

    public final void setBannerState(@Nullable c.a aVar) {
        this.bannerState = aVar;
    }

    public final void setCurGuildInfo(@Nullable kf4.a aVar) {
        this.curGuildInfo = aVar;
    }

    public final void setGameId(int i3) {
        this.gameId = i3;
    }

    public final void setLastTimeLaunchWebProcess(long j3) {
        this.lastTimeLaunchWebProcess = j3;
    }

    public final void setPushManager(@NotNull b bVar) {
        Intrinsics.checkNotNullParameter(bVar, "<set-?>");
        this.pushManager = bVar;
    }

    public final void setWebProcessKeepDuration(long j3) {
        this.webProcessKeepDuration = j3;
    }

    public /* synthetic */ LiveBannerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public LiveBannerView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.gameId = 1;
        this.webProcessKeepDuration = 30000L;
        this.pushManager = new a();
    }
}
