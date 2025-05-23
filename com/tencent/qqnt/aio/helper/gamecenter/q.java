package com.tencent.qqnt.aio.helper.gamecenter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aio.data.AIOParam;
import com.tencent.aio.main.businesshelper.h;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.aio.event.InputEvent;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.nt.aio.bottom.GameMsgBottomBarEvent;
import com.tencent.mobileqq.gamecenter.nt.aio.bottom.GameMsgNotifyDataEvent;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.api.IMsgSendHelper;
import com.tencent.qqnt.aio.helper.cw;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 42\u00020\u0001:\u00015B\u0007\u00a2\u0006\u0004\b2\u00103J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u0002H\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0018\u0010\u0011\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010H\u0002J\b\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u0010\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010)R\u0016\u0010-\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0011\u0010,R\u0014\u00101\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100\u00a8\u00066"}, d2 = {"Lcom/tencent/qqnt/aio/helper/gamecenter/q;", "Lcom/tencent/aio/main/businesshelper/h;", "", DomainData.DOMAIN_NAME, "o", "Lcom/tencent/mobileqq/app/QQAppInterface;", "k", "i", "j", "", "gameType", tl.h.F, "c", "e", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "getId", "getTag", "", "interestedIn", "state", "onMoveToState", "Lcom/tencent/aio/main/businesshelper/b;", "param", "onCreate", "Lcom/tencent/aio/api/runtime/a;", "d", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "Lcom/tencent/mobileqq/activity/aio/SessionInfo;", "sessionInfo", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "f", "Lcom/tencent/mobileqq/gamecenter/api/IGameMsgManagerService;", "gameMsgManager", "Ljava/lang/String;", "peerUid", "Landroid/widget/LinearLayout;", "Landroid/widget/LinearLayout;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "gameSession", "Lcom/tencent/mvi/base/route/a;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mvi/base/route/a;", "action", "<init>", "()V", "D", "a", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class q implements com.tencent.aio.main.businesshelper.h {
    private static final ArrayList<String> E;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.aio.api.runtime.a aioContext;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SessionInfo sessionInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IGameMsgManagerService gameMsgManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LinearLayout rootView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TempChatGameSession gameSession;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String peerUid = "";

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.mvi.base.route.a action = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/qqnt/aio/helper/gamecenter/q$b", "Lcom/tencent/mvi/base/route/a;", "Lcom/tencent/mvi/base/route/MsgIntent;", "i", "", "call", "", "sticky", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mvi.base.route.a {
        b() {
        }

        @Override // com.tencent.mvi.base.route.a
        public void call(MsgIntent i3) {
            Intrinsics.checkNotNullParameter(i3, "i");
            QLog.i("GameMsgExternalGameHelper", 2, "[mAction1] call:" + i3);
            if (i3 instanceof GameMsgNotifyDataEvent.GameTypeReceived) {
                q.this.h(((GameMsgNotifyDataEvent.GameTypeReceived) i3).getGameType());
            }
        }

        @Override // com.tencent.mvi.base.route.a
        public boolean sticky() {
            return false;
        }
    }

    static {
        ArrayList<String> arrayListOf;
        arrayListOf = CollectionsKt__CollectionsKt.arrayListOf("\u6536\u5230\uff01", "\u9a6c\u4e0a\u6765\uff01", "\u7a0d\u7b49\u4e00\u4f1a\uff0c\u4f60\u5148\u73a9~", "\u6211\u6709\u70b9\u4e8b\uff0c\u4f60\u5148\u73a9~", "\u6211\u73b0\u5728\u6709\u7a7a\uff0c\u5f00\u4e00\u5c40\u4e48\uff1f");
        E = arrayListOf;
    }

    private final void c() {
        if (this.rootView != null) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = null;
        View inflate = View.inflate(BaseApplication.getContext(), R.layout.f167248a, null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.widget.LinearLayout");
        this.rootView = (LinearLayout) inflate;
        e();
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12, -1);
        com.tencent.aio.api.runtime.a aVar2 = this.aioContext;
        if (aVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar = aVar2;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            LinearLayout linearLayout = this.rootView;
            Intrinsics.checkNotNull(linearLayout);
            e16.h(new GameMsgBottomBarEvent.AddBottomView(0, linearLayout, layoutParams));
        }
    }

    private final void e() {
        if (this.rootView == null) {
            return;
        }
        ArrayList<String> m3 = m();
        LinearLayout linearLayout = this.rootView;
        Intrinsics.checkNotNull(linearLayout);
        LinearLayout linearLayout2 = (LinearLayout) linearLayout.findViewById(R.id.f17318);
        Iterator<String> it = m3.iterator();
        while (it.hasNext()) {
            final String next = it.next();
            LinearLayout linearLayout3 = this.rootView;
            Intrinsics.checkNotNull(linearLayout3);
            TextView textView = new TextView(linearLayout3.getContext());
            textView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            textView.setText(next);
            textView.setTextColor(textView.getResources().getColor(R.color.qui_common_text_primary));
            textView.setTextSize(14.0f);
            int f16 = BaseAIOUtils.f(12.0f, textView.getResources());
            ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams == null) {
                ViewGroup.LayoutParams layoutParams2 = textView.getLayoutParams();
                int i3 = layoutParams2 != null ? layoutParams2.width : -2;
                ViewGroup.LayoutParams layoutParams3 = textView.getLayoutParams();
                marginLayoutParams = new ViewGroup.MarginLayoutParams(i3, layoutParams3 != null ? layoutParams3.height : -2);
            }
            if (f16 != marginLayoutParams.leftMargin) {
                marginLayoutParams.leftMargin = f16;
                textView.setLayoutParams(marginLayoutParams);
            }
            textView.setBackgroundResource(R.drawable.f13423);
            textView.setPadding(BaseAIOUtils.f(15.0f, textView.getResources()), BaseAIOUtils.f(8.0f, textView.getResources()), BaseAIOUtils.f(15.0f, textView.getResources()), BaseAIOUtils.f(8.0f, textView.getResources()));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.aio.helper.gamecenter.p
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    q.g(q.this, next, view);
                }
            });
            linearLayout2.addView(textView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(q this$0, String item, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        ((IMsgSendHelper) QRoute.api(IMsgSendHelper.class)).sendText(this$0.peerUid, 105, item);
    }

    private final QQAppInterface k() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof QQAppInterface) {
            return (QQAppInterface) peekAppRuntime;
        }
        return null;
    }

    private final ArrayList<String> m() {
        QQAppInterface k3 = k();
        IGameMsgManagerService iGameMsgManagerService = k3 != null ? (IGameMsgManagerService) k3.getRuntimeService(IGameMsgManagerService.class, "") : null;
        ArrayList<String> arrayList = new ArrayList<>();
        JSONObject quickReplyConfig = iGameMsgManagerService != null ? iGameMsgManagerService.getQuickReplyConfig() : null;
        if (quickReplyConfig == null) {
            return E;
        }
        JSONArray optJSONArray = quickReplyConfig.optJSONArray("items");
        if (optJSONArray != null && optJSONArray.length() != 0) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                arrayList.add(optJSONArray.getString(i3));
            }
            return arrayList;
        }
        return E;
    }

    private final void n() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().d(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(GameMsgNotifyDataEvent.GameTypeReceived.class)), this.action);
    }

    private final void o() {
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        aVar.e().b(com.tencent.qqnt.aio.utils.j.f352301a.a(Reflection.getOrCreateKotlinClass(GameMsgNotifyDataEvent.GameTypeReceived.class)), this.action);
    }

    @Override // com.tencent.aio.main.businesshelper.e, com.tencent.aio.main.businesshelper.g
    public int getId() {
        return cw.f350623c0;
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public String getTag() {
        return "GameMsgExternalGameHelper";
    }

    @Override // com.tencent.aio.main.businesshelper.e
    public void onCreate(com.tencent.aio.main.businesshelper.b param) {
        Intrinsics.checkNotNullParameter(param, "param");
        QLog.i("GameMsgExternalGameHelper", 1, "[onCreate]");
        com.tencent.aio.api.runtime.a a16 = param.a();
        this.aioContext = a16;
        if (a16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            a16 = null;
        }
        AIOParam g16 = a16.g();
        Intrinsics.checkNotNullExpressionValue(g16, "aioContext.aioParam");
        this.sessionInfo = su3.b.a(g16);
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        Bundle l3 = aVar.g().l();
        String string = l3.getString("key_peerId", "");
        Intrinsics.checkNotNullExpressionValue(string, "mCustomParam.getString(C\u2026Constants.KEY_PEERID, \"\")");
        this.peerUid = string;
        this.gameSession = ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).getGameSessionFromPeerUidOrJson(this.peerUid, l3.getString(AppConstants.Key.KEY_GAME_MSG_SESSION, ""));
        QQAppInterface k3 = k();
        this.gameMsgManager = k3 != null ? (IGameMsgManagerService) k3.getRuntimeService(IGameMsgManagerService.class, "") : null;
        n();
    }

    @Override // com.tencent.aio.main.businesshelper.e
    @Deprecated(message = "\u6b64\u65b9\u6cd5\u5df2\u5e9f\u5f03")
    public void onDestroy() {
        h.a.b(this);
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public void onMoveToState(int state) {
        QLog.i("GameMsgSayHiHelper", 2, "[onMoveToState] state:" + state);
        if (state == 0) {
            i();
        } else {
            if (state != 12) {
                return;
            }
            j();
        }
    }

    private final void i() {
        QLog.i("GameMsgExternalGameHelper", 1, "[doOnCreate]");
    }

    private final void j() {
        QLog.i("GameMsgExternalGameHelper", 1, "[doOnDestroy]");
        o();
    }

    @Override // com.tencent.aio.main.businesshelper.g
    public int[] interestedIn() {
        return new int[]{0, 12};
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(int gameType) {
        if (gameType != 1) {
            return;
        }
        com.tencent.aio.api.runtime.a aVar = this.aioContext;
        com.tencent.aio.api.runtime.a aVar2 = null;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
            aVar = null;
        }
        com.tencent.mvi.base.route.j e16 = aVar.e();
        if (e16 != null) {
            e16.h(InputEvent.InputHide.f188577d);
        }
        com.tencent.aio.api.runtime.a aVar3 = this.aioContext;
        if (aVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("aioContext");
        } else {
            aVar2 = aVar3;
        }
        com.tencent.mvi.base.route.j e17 = aVar2.e();
        if (e17 != null) {
            e17.h(InputEvent.AIOShortcutBarHide.f188562d);
        }
        c();
    }
}
