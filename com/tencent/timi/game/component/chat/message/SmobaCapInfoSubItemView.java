package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.timi.game.room.impl.util.YoloRoomUtil;
import com.tencent.timi.game.userinfo.impl.view.TimiAvatarRoundImageViewImpl;
import java.text.DecimalFormat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.PremadesTeamServerOuterClass$ShareGameBattleResultRsp;
import trpc.yes.common.SmobaDataOuterClass$PlayerSettleInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomBattleResultAction;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomDataInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloRoomInfo;
import trpc.yes.common.YoloRoomOuterClass$YoloSmobaRoomBattleResultAction;
import ug4.b;
import yf4.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u001b2\u00020\u0001:\u0002)*B'\b\u0007\u0012\u0006\u0010\"\u001a\u00020!\u0012\n\b\u0002\u0010$\u001a\u0004\u0018\u00010#\u0012\b\b\u0002\u0010&\u001a\u00020%\u00a2\u0006\u0004\b'\u0010(J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002Jf\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\u0014\u0010\u001d\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001cR\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u001f\u00a8\u0006+"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView;", "Landroid/widget/FrameLayout;", "", "roomId", "", "d", "(Ljava/lang/Long;)Z", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "userId", "e", "victory", "Ltrpc/yes/common/YoloRoomOuterClass$YoloSmobaRoomBattleResultAction;", "action", "Ltrpc/yes/common/SmobaDataOuterClass$PlayerSettleInfo;", "play", "", "desc", "selfQQUserId", "Ltrpc/yes/common/YoloRoomOuterClass$YoloRoomInfo;", "roomInfo", "msgId", "battleId", "Lcom/tencent/timi/game/component/chat/message/n;", "iMessageListener", "Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView$b;", "iShareClickListener", "", "f", "Ljava/lang/String;", "smobaHeroBaseUrl", "Lnr2/as;", "Lnr2/as;", "binding", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class SmobaCapInfoSubItemView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String smobaHeroBaseUrl;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final nr2.as binding;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView$b;", "", "Landroid/view/View;", "v", "", NodeProps.ON_CLICK, "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void onClick(@NotNull View v3);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016JP\u0010\u0011\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/timi/game/component/chat/message/SmobaCapInfoSubItemView$c", "Lpl4/d;", "Ltrpc/yes/common/PremadesTeamServerOuterClass$ShareGameBattleResultRsp;", "response", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "originalMsfRsp", "", "d", "", "isMsfSuccess", "", "msfResultCode", "timiErrCode", "timiSubErrCode", "", "timiErrMsg", "timiDisplayErrMsg", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements pl4.d<PremadesTeamServerOuterClass$ShareGameBattleResultRsp> {
        c() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:4:0x0030, code lost:
        
            if ((!r2) == true) goto L8;
         */
        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void b(boolean isMsfSuccess, int msfResultCode, int timiErrCode, int timiSubErrCode, @Nullable String timiErrMsg, @Nullable String timiDisplayErrMsg, @Nullable PremadesTeamServerOuterClass$ShareGameBattleResultRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            boolean z16;
            boolean isBlank;
            com.tencent.timi.game.utils.l.e("SmobaCapInfoSubItemView", "share battle result fail, timiErrCode[" + timiErrCode + "], timiDisplayErrMsg[" + timiDisplayErrMsg + "]");
            if (timiDisplayErrMsg != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(timiDisplayErrMsg);
                z16 = true;
            }
            z16 = false;
            if (z16) {
                QQToast.makeText(BaseApplication.getContext(), 4, timiDisplayErrMsg, 0).show();
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable PremadesTeamServerOuterClass$ShareGameBattleResultRsp response, @Nullable FromServiceMsg originalMsfRsp) {
            com.tencent.timi.game.utils.l.i("SmobaCapInfoSubItemView", "share battle result fail");
            QQToast.makeText(BaseApplication.getContext(), 5, "\u5206\u4eab\u6218\u7ee9\u6210\u529f", 0).show();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaCapInfoSubItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final boolean d(Long roomId) {
        int i3;
        gm4.c K0;
        YoloRoomOuterClass$YoloRoomInfo roomInfo;
        YoloRoomOuterClass$YoloRoomDataInfo yoloRoomOuterClass$YoloRoomDataInfo;
        PBInt32Field pBInt32Field;
        if (roomId == null) {
            return false;
        }
        long longValue = roomId.longValue();
        fm4.g gVar = (fm4.g) mm4.b.b(fm4.g.class);
        if (gVar != null && (K0 = gVar.K0(longValue)) != null && (roomInfo = K0.getRoomInfo()) != null && (yoloRoomOuterClass$YoloRoomDataInfo = roomInfo.room_data_info) != null && (pBInt32Field = yoloRoomOuterClass$YoloRoomDataInfo.sub_create_from) != null) {
            i3 = pBInt32Field.get();
        } else {
            i3 = -1;
        }
        if (i3 != 0 && i3 != 1) {
            return false;
        }
        return true;
    }

    private final boolean e(CommonOuterClass$QQUserId userId) {
        if (userId.user_from.get() == 4) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(n nVar, CommonOuterClass$QQUserId userId, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(userId, "$userId");
        if (nVar != null) {
            nVar.a(userId);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00d1, code lost:
    
        if (ll4.b.a(r13, r20) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void h(boolean z16, b bVar, CommonOuterClass$QQUserId commonOuterClass$QQUserId, YoloRoomOuterClass$YoloSmobaRoomBattleResultAction action, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, CommonOuterClass$QQUserId commonOuterClass$QQUserId2, CommonOuterClass$QQUserId userId, SmobaCapInfoSubItemView this$0, View it) {
        boolean z17;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId3;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(action, "$action");
        Intrinsics.checkNotNullParameter(userId, "$userId");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (z16) {
            if (bVar != null) {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                bVar.onClick(it);
            }
            String X0 = ((ag4.h) mm4.b.b(ag4.h.class)).X0(101);
            Intrinsics.checkNotNullExpressionValue(X0, "getService(IGameConfigSe\u2026e(CommonOuterClass.smoba)");
            if (I0 != null) {
                if (I0.getMYesGameId() == 101) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    pl4.c cVar = (pl4.c) mm4.b.b(pl4.c.class);
                    a.Companion companion = yf4.a.INSTANCE;
                    CommonOuterClass$QQUserId mQQUserId = I0.getMQQUserId();
                    long mRoomIdFromServer = I0.getMRoomIdFromServer();
                    YoloRoomOuterClass$YoloRoomBattleResultAction yoloRoomOuterClass$YoloRoomBattleResultAction = new YoloRoomOuterClass$YoloRoomBattleResultAction();
                    yoloRoomOuterClass$YoloRoomBattleResultAction.game_id.set(101);
                    YoloRoomOuterClass$YoloSmobaRoomBattleResultAction yoloRoomOuterClass$YoloSmobaRoomBattleResultAction = yoloRoomOuterClass$YoloRoomBattleResultAction.smoba_battle_result_action;
                    YoloRoomOuterClass$YoloSmobaRoomBattleResultAction yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2 = new YoloRoomOuterClass$YoloSmobaRoomBattleResultAction();
                    yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2.smoba_battle_result.set(action.smoba_battle_result.get());
                    yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2.smoba_hero_conf_list.set(action.smoba_hero_conf_list.get());
                    yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2.user_id_list.set(action.user_id_list.get());
                    yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2.battle_result_text.set(action.battle_result_text.get());
                    if (action.gift_config.has()) {
                        CommonOuterClass$QQUserId commonOuterClass$QQUserId4 = null;
                        if (yoloRoomOuterClass$YoloRoomInfo != null) {
                            commonOuterClass$QQUserId3 = yoloRoomOuterClass$YoloRoomInfo.owner_user_id;
                        } else {
                            commonOuterClass$QQUserId3 = null;
                        }
                        if (!ll4.b.a(commonOuterClass$QQUserId3, commonOuterClass$QQUserId2)) {
                            if (yoloRoomOuterClass$YoloRoomInfo != null) {
                                commonOuterClass$QQUserId4 = yoloRoomOuterClass$YoloRoomInfo.create_user_id;
                            }
                        }
                        yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2.gift_room_battle_result_text.set(action.gift_room_battle_result_text.get());
                        yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2.gift_config.set(action.gift_config.get());
                    }
                    yoloRoomOuterClass$YoloSmobaRoomBattleResultAction.set(yoloRoomOuterClass$YoloSmobaRoomBattleResultAction2);
                    Unit unit = Unit.INSTANCE;
                    cVar.F1(companion.a(mQQUserId, mRoomIdFromServer, 101, yoloRoomOuterClass$YoloRoomBattleResultAction), PremadesTeamServerOuterClass$ShareGameBattleResultRsp.class, new c());
                }
            }
            com.tencent.timi.game.ui.widget.f.c("\u76ee\u524d\u4e0d\u5728" + X0 + "\u4ea4\u53cb\u5927\u5385\u65e0\u6cd5\u5206\u4eab\u54e6\uff5e");
        } else if (commonOuterClass$QQUserId != null && I0 != null) {
            bm4.a aVar = (bm4.a) mm4.b.b(bm4.a.class);
            QBaseActivity b16 = vf4.a.b();
            Intrinsics.checkNotNullExpressionValue(b16, "getTopQActivity()");
            String valueOf = String.valueOf(userId.uid.get());
            String h16 = this$0.binding.f420890r.h();
            Intrinsics.checkNotNullExpressionValue(h16, "binding.subNickView.acquireShowName()");
            aVar.k0(b16, commonOuterClass$QQUserId, valueOf, h16, userId, I0.getMYesGameId());
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(SmobaCapInfoSubItemView this$0, boolean z16, boolean z17, YoloRoomOuterClass$YoloRoomInfo yoloRoomOuterClass$YoloRoomInfo, String msgId, CommonOuterClass$QQUserId userId, String battleId, boolean z18) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msgId, "$msgId");
        Intrinsics.checkNotNullParameter(userId, "$userId");
        Intrinsics.checkNotNullParameter(battleId, "$battleId");
        ImageView imageView = this$0.binding.f420874b;
        if (z18) {
            i3 = R.drawable.o_2;
        } else if (z16) {
            i3 = R.drawable.o_4;
        } else {
            i3 = R.drawable.o_3;
        }
        imageView.setImageResource(i3);
        ImageView imageView2 = this$0.binding.f420874b;
        Intrinsics.checkNotNullExpressionValue(imageView2, "binding.addFriendIv");
        fh4.g.o(imageView2, z17);
        if (z17 && !z18 && yoloRoomOuterClass$YoloRoomInfo != null) {
            mm4.a b16 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
            ImageView imageView3 = this$0.binding.f420874b;
            Intrinsics.checkNotNullExpressionValue(imageView3, "binding.addFriendIv");
            String str = msgId + "_" + userId.uid.get();
            ConcurrentHashMap<String, String> L = YoloRoomUtil.L(yoloRoomOuterClass$YoloRoomInfo);
            L.put("yes_to_uid", nn4.a.a(userId.uid.get()));
            L.put("yes_to_yes_uid", nn4.a.a(userId.yes_uid.get()));
            L.put("yes_battle_id", battleId);
            Unit unit = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u2026                        }");
            b.a.a((ug4.b) b16, imageView3, false, str, "em_yes_chat_record_add_friend", L, 2, null);
        }
    }

    public final void f(final boolean victory, @NotNull final YoloRoomOuterClass$YoloSmobaRoomBattleResultAction action, @NotNull final CommonOuterClass$QQUserId userId, @NotNull SmobaDataOuterClass$PlayerSettleInfo play, @NotNull String desc, @Nullable final CommonOuterClass$QQUserId selfQQUserId, @Nullable final YoloRoomOuterClass$YoloRoomInfo roomInfo, @NotNull final String msgId, @NotNull final String battleId, @Nullable final n iMessageListener, @Nullable final b iShareClickListener) {
        String str;
        String str2;
        CommonOuterClass$QQUserId commonOuterClass$QQUserId;
        String str3;
        PBUInt64Field pBUInt64Field;
        PBInt32Field pBInt32Field;
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Intrinsics.checkNotNullParameter(play, "play");
        Intrinsics.checkNotNullParameter(desc, "desc");
        Intrinsics.checkNotNullParameter(msgId, "msgId");
        Intrinsics.checkNotNullParameter(battleId, "battleId");
        this.binding.f420884l.setUserId(userId);
        this.binding.f420888p.setText(String.valueOf(play.killcnt.get()));
        this.binding.f420886n.setText(String.valueOf(play.deadcnt.get()));
        this.binding.f420883k.setText(String.valueOf(play.assistcnt.get()));
        this.binding.f420877e.setBackgroundURL(this.smobaHeroBaseUrl + play.heroid.get());
        this.binding.f420891s.setText(new DecimalFormat("0.#").format(Float.valueOf(((float) play.oldmvpscore.get()) / ((float) 100))));
        this.binding.f420884l.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.ao
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmobaCapInfoSubItemView.g(n.this, userId, view);
            }
        });
        ImageView imageView = this.binding.f420889q;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.subMvpView");
        fh4.g.o(imageView, play.ismvp.get() > 0);
        this.binding.f420889q.setImageResource(victory ? R.drawable.o_f : R.drawable.o_5);
        int i3 = play.medal_tag.get();
        if (i3 == 0) {
            FrameLayout frameLayout = this.binding.f420881i;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.medalTagFl");
            fh4.g.o(frameLayout, false);
        } else if (i3 == 1) {
            FrameLayout frameLayout2 = this.binding.f420881i;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.medalTagFl");
            fh4.g.o(frameLayout2, true);
            this.binding.f420881i.setBackgroundResource(R.drawable.o_8);
            this.binding.f420882j.setText(play.medal_desc.get());
        } else if (i3 == 2) {
            FrameLayout frameLayout3 = this.binding.f420881i;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.medalTagFl");
            fh4.g.o(frameLayout3, true);
            this.binding.f420881i.setBackgroundResource(R.drawable.o_7);
            this.binding.f420882j.setText(play.medal_desc.get());
        }
        int i16 = play.kill_tag.get();
        String str4 = "";
        if (i16 != 0) {
            if (i16 == 1) {
                str4 = "\u8d85\u795e";
            } else if (i16 == 2) {
                str4 = "\u4e94\u6740";
            } else if (i16 == 3) {
                str4 = "\u56db\u6740";
            } else if (i16 == 4) {
                str4 = "\u4e09\u6740";
            }
        }
        FrameLayout frameLayout4 = this.binding.f420879g;
        Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.killTagFl");
        fh4.g.o(frameLayout4, str4.length() > 0);
        if (str4.length() > 0) {
            this.binding.f420880h.setText(str4);
        }
        CommonOuterClass$QQUserId E = ((ll4.a) mm4.b.b(ll4.a.class)).E();
        final boolean a16 = ll4.b.a(userId, E);
        if (a16) {
            this.binding.f420890r.setText("\u6211");
            ImageView imageView2 = this.binding.f420874b;
            Intrinsics.checkNotNullExpressionValue(imageView2, "binding.addFriendIv");
            fh4.g.o(imageView2, (!(roomInfo != null && (pBInt32Field = roomInfo.room_type) != null && pBInt32Field.get() == 1) || ((sm4.a) mm4.b.b(sm4.a.class)).y3() || e(userId)) ? false : true);
            this.binding.f420874b.setImageResource(victory ? R.drawable.o_e : R.drawable.o_d);
            if (roomInfo != null) {
                mm4.a b16 = mm4.b.b(ug4.b.class);
                Intrinsics.checkNotNullExpressionValue(b16, "getService(IReportService::class.java)");
                ug4.b bVar = (ug4.b) b16;
                ImageView imageView3 = this.binding.f420874b;
                Intrinsics.checkNotNullExpressionValue(imageView3, "binding.addFriendIv");
                String str5 = msgId + "_" + userId.uid.get();
                ConcurrentHashMap<String, String> L = YoloRoomUtil.L(roomInfo);
                L.put("yes_battle_id", battleId);
                L.put("yes_battle_result", victory ? "1" : "0");
                Unit unit = Unit.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(L, "getCommonRoomInfoReportP\u20260\")\n                    }");
                b.a.a(bVar, imageView3, false, str5, "em_yes_chat_record_share", L, 2, null);
                str = "getService(IReportService::class.java)";
                str3 = "_";
                str2 = "yes_battle_id";
                commonOuterClass$QQUserId = E;
            } else {
                str = "getService(IReportService::class.java)";
                str3 = "_";
                str2 = "yes_battle_id";
                commonOuterClass$QQUserId = E;
            }
        } else {
            this.binding.f420890r.setUserId(userId);
            AppRuntime appRuntime = vf4.a.a();
            final boolean d16 = d((roomInfo == null || (pBUInt64Field = roomInfo.room_id) == null) ? null : Long.valueOf(pBUInt64Field.get()));
            ImageView imageView4 = this.binding.f420874b;
            Intrinsics.checkNotNullExpressionValue(imageView4, "binding.addFriendIv");
            fh4.g.o(imageView4, d16);
            bm4.a aVar = (bm4.a) mm4.b.b(bm4.a.class);
            Intrinsics.checkNotNullExpressionValue(appRuntime, "appRuntime");
            str = "getService(IReportService::class.java)";
            str2 = "yes_battle_id";
            commonOuterClass$QQUserId = E;
            str3 = "_";
            aVar.Q0(userId, appRuntime, new INearbyAddFriendHelper.c() { // from class: com.tencent.timi.game.component.chat.message.ap
                @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper.c
                public final void a(boolean z16) {
                    SmobaCapInfoSubItemView.i(SmobaCapInfoSubItemView.this, victory, d16, roomInfo, msgId, userId, battleId, z16);
                }
            });
        }
        final CommonOuterClass$QQUserId commonOuterClass$QQUserId2 = commonOuterClass$QQUserId;
        this.binding.f420874b.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.timi.game.component.chat.message.aq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SmobaCapInfoSubItemView.h(a16, iShareClickListener, selfQQUserId, action, roomInfo, commonOuterClass$QQUserId2, userId, this, view);
            }
        });
        TextView textView = this.binding.f420887o;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subDescTv");
        fh4.g.o(textView, !a16);
        this.binding.f420887o.setText(desc);
        this.binding.f420890r.setClickable(false);
        if (roomInfo != null) {
            mm4.a b17 = mm4.b.b(ug4.b.class);
            Intrinsics.checkNotNullExpressionValue(b17, str);
            TimiAvatarRoundImageViewImpl timiAvatarRoundImageViewImpl = this.binding.f420884l;
            Intrinsics.checkNotNullExpressionValue(timiAvatarRoundImageViewImpl, "binding.subAvatarView");
            String str6 = msgId + str3 + userId.uid.get();
            ConcurrentHashMap<String, String> L2 = YoloRoomUtil.L(roomInfo);
            L2.put("yes_to_uid", nn4.a.a(userId.uid.get()));
            L2.put("yes_to_yes_uid", nn4.a.a(userId.yes_uid.get()));
            L2.put(str2, battleId);
            Unit unit2 = Unit.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(L2, "getCommonRoomInfoReportP\u2026ttleId)\n                }");
            b.a.a((ug4.b) b17, timiAvatarRoundImageViewImpl, false, str6, "em_yes_chat_record_user_head", L2, 2, null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaCapInfoSubItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ SmobaCapInfoSubItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public SmobaCapInfoSubItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.smobaHeroBaseUrl = "https://cdn.yes.qq.com/smoba/hero/";
        nr2.as g16 = nr2.as.g(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.from(context), this, true)");
        this.binding = g16;
        g16.f420884l.setNeedDrawSex(true);
        TextView textView = g16.f420891s;
        Intrinsics.checkNotNullExpressionValue(textView, "binding.subScoreTv");
        fh4.d.a(textView);
    }
}
