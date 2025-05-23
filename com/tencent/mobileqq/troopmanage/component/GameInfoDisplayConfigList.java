package com.tencent.mobileqq.troopmanage.component;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.IQQKuiklyRouter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameApi;
import com.tencent.mobileqq.troopmanage.repo.TroopManageViewModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.Group;
import com.tencent.mobileqq.widget.listitem.QUIListItemAdapter;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.qqnt.kernel.nativeinterface.GroupGame;
import com.tencent.qqnt.kernel.nativeinterface.GroupGameInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupGameList;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import java.util.ArrayList;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001*B7\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010\u001c\u001a\u00020\u001a\u00a2\u0006\u0004\b'\u0010(J\f\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J+\u0010\r\u001a\u00020\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00060\bH\u0002J\f\u0010\u000f\u001a\u00020\u000e*\u00020\u0004H\u0002J\f\u0010\u0011\u001a\u00020\u0010*\u00020\u0004H\u0002J\f\u0010\u0013\u001a\u00020\u0010*\u00020\u0012H\u0002J\f\u0010\u0015\u001a\u00020\u0010*\u00020\u0014H\u0002J\f\u0010\u0017\u001a\u00020\u0010*\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0016R\u0014\u0010\u001c\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u000f\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/GameInfoDisplayConfigList;", "Lcom/tencent/mobileqq/troopmanage/component/bv;", "Lcom/tencent/mobileqq/widget/listitem/a;", "E", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "H", "", "J", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "troopInfo", "callback", BdhLogUtil.LogTag.Tag_Conn, "", "I", "Lorg/json/JSONObject;", "B", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGameList;", "M", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGame;", "K", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupGameInfo;", "L", "Lcom/tencent/mobileqq/widget/listitem/Group;", "D", "", "g", "requestCode", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;", "adapter", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;", "viewModel", "", "dtReportPgId", "<init>", "(Lcom/tencent/mobileqq/app/QBaseActivity;Lcom/tencent/mobileqq/widget/listitem/QUIListItemAdapter;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mobileqq/troopmanage/repo/TroopManageViewModel;Ljava/lang/String;I)V", tl.h.F, "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class GameInfoDisplayConfigList extends bv {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final int requestCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troopmanage/component/GameInfoDisplayConfigList$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "data", "", "Lcom/tencent/qqnt/troop/FetchTroopInfoCallback;", "a", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements Function2<Boolean, TroopInfo, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<TroopInfo, Unit> f303044d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ TroopInfo f303045e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super TroopInfo, Unit> function1, TroopInfo troopInfo) {
            this.f303044d = function1;
            this.f303045e = troopInfo;
        }

        public void a(boolean isSuccess, TroopInfo data) {
            Intrinsics.checkNotNullParameter(data, "data");
            QLog.i("GameInfoDisplayConfigList", 1, "ensureTroopInfoWithGameData: fetchTroopBasicInfoWithExt: isSuccess=" + isSuccess);
            this.f303044d.invoke(this.f303045e);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
            a(bool.booleanValue(), troopInfo);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameInfoDisplayConfigList(QBaseActivity activity, QUIListItemAdapter adapter, LifecycleOwner lifecycleOwner, TroopManageViewModel viewModel, String dtReportPgId, int i3) {
        super(activity, adapter, lifecycleOwner, viewModel, dtReportPgId);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(adapter, "adapter");
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(dtReportPgId, "dtReportPgId");
        this.requestCode = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject B(TroopInfo troopInfo) {
        JSONObject jSONObject = new JSONObject();
        GroupGameList groupGameList = troopInfo.groupGameList;
        Intrinsics.checkNotNullExpressionValue(groupGameList, "groupGameList");
        jSONObject.put("groupGameList", M(groupGameList));
        jSONObject.put("selectedGameId", new JSONArray((Collection) troopInfo.selectedGameId));
        return jSONObject;
    }

    private final void C(Function1<? super TroopInfo, Unit> callback) {
        TroopInfo H = H();
        if (I(H)) {
            callback.invoke(H);
        } else {
            ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopBasicInfoWithExt(H.getTroopUin(), "GameInfoDisplayConfigList", e(), new b(callback, H));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(GameInfoDisplayConfigList this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(view, "<anonymous parameter 0>");
        bv.n(this$0, "em_group_show_game_state", null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(GameInfoDisplayConfigList this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        bv.l(this$0, "em_group_show_game_state", null, 2, null);
        this$0.J();
    }

    private final TroopInfo H() {
        return g().h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean I(TroopInfo troopInfo) {
        Intrinsics.checkNotNullExpressionValue(troopInfo.groupGameList.gameInfos, "groupGameList.gameInfos");
        return !r2.isEmpty();
    }

    private final void J() {
        C(new Function1<TroopInfo, Unit>() { // from class: com.tencent.mobileqq.troopmanage.component.GameInfoDisplayConfigList$jumpGameListPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(TroopInfo troopInfo) {
                invoke2(troopInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(TroopInfo troopInfo) {
                boolean I;
                JSONObject B;
                Intrinsics.checkNotNullParameter(troopInfo, "troopInfo");
                I = GameInfoDisplayConfigList.this.I(troopInfo);
                if (!I) {
                    QQToast.makeText(GameInfoDisplayConfigList.this.b(), 1, "\u83b7\u53d6\u6e38\u620f\u4fe1\u606f\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", 0).show();
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("bundle_name", "gamecenter_game_card");
                jSONObject.put("page_name", "TroopProfileCardGameListPage");
                B = GameInfoDisplayConfigList.this.B(troopInfo);
                jSONObject.put("gameData", B.toString());
                jSONObject.put("troopUin", troopInfo.getTroopUin());
                ((IQQKuiklyRouter) QRoute.api(IQQKuiklyRouter.class)).launchKuiklyPage(GameInfoDisplayConfigList.this.b(), jSONObject);
            }
        });
    }

    private final JSONObject K(GroupGame groupGame) {
        JSONObject jSONObject;
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VirtualAppProxy.KEY_GAME_ID, groupGame.gameId);
        jSONObject2.put("notAllowSelected", groupGame.notAllowSelected);
        GroupGameInfo gameInfo = groupGame.gameInfo;
        if (gameInfo != null) {
            Intrinsics.checkNotNullExpressionValue(gameInfo, "gameInfo");
            jSONObject = L(gameInfo);
        } else {
            jSONObject = null;
        }
        jSONObject2.put("gameInfo", jSONObject);
        return jSONObject2;
    }

    private final JSONObject L(GroupGameInfo groupGameInfo) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("appId", groupGameInfo.appId);
        jSONObject.put("name", groupGameInfo.name);
        jSONObject.put("iconUrl", groupGameInfo.iconUrl);
        return jSONObject;
    }

    private final JSONObject M(GroupGameList groupGameList) {
        JSONArray jSONArray = new JSONArray();
        ArrayList<GroupGame> gameInfos = groupGameList.gameInfos;
        Intrinsics.checkNotNullExpressionValue(gameInfos, "gameInfos");
        for (GroupGame groupGame : gameInfos) {
            if (groupGame != null) {
                jSONArray.mo162put(K(groupGame));
            }
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("gameInfos", jSONArray);
        return jSONObject;
    }

    public Group D() {
        return new Group(E());
    }

    private final com.tencent.mobileqq.widget.listitem.a<?> E() {
        com.tencent.mobileqq.widget.listitem.x v3 = bv.v(this, R.string.z96, "", null, null, 12, null);
        v3.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.troopmanage.component.af
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                GameInfoDisplayConfigList.F(GameInfoDisplayConfigList.this, view);
            }
        });
        v3.p(((ITroopGameApi) QRoute.api(ITroopGameApi.class)).enableShowGameCard(g().h()));
        v3.x(new View.OnClickListener() { // from class: com.tencent.mobileqq.troopmanage.component.ag
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GameInfoDisplayConfigList.G(GameInfoDisplayConfigList.this, view);
            }
        });
        return v3;
    }
}
