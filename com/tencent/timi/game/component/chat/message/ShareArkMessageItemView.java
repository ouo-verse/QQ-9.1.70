package com.tencent.timi.game.component.chat.message;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.open.ArkAppInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.ark.api.IArkAPIService;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.newnearby.INearbyAddFriendHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.tencent.timi.game.ui.widget.TimiArkView;
import com.tencent.timi.game.utils.IResultListener;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.UStringsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import trpc.yes.common.CommonOuterClass$QQUserId;
import trpc.yes.common.MessageOuterClass$ArkBaseInfo;
import trpc.yes.common.MessageOuterClass$MsgContent;
import trpc.yes.common.MessageOuterClass$ShareArkMsg;
import trpc.yes.common.RecommendProxyOuterClass$SendIMArkMsgRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 62\u00020\u0001:\u00017B'\b\u0007\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u000100\u0012\b\b\u0002\u00103\u001a\u000202\u00a2\u0006\u0004\b4\u00105J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0010\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0010H\u0002J\u0010\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0018\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\u001a\u001a\u00020\bH\u0014J\b\u0010\u001b\u001a\u00020\bH\u0014J\u0010\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0014R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00068"}, d2 = {"Lcom/tencent/timi/game/component/chat/message/ShareArkMessageItemView;", "Lcom/tencent/timi/game/component/chat/message/BaseMessageView;", "Ltrpc/yes/common/MessageOuterClass$ShareArkMsg;", "arkMsg", "", AdMetricTag.EVENT_NAME, "Lorg/json/JSONObject;", "paramObject", "", "Z", "Ltrpc/yes/common/CommonOuterClass$QQUserId;", "Y", ExifInterface.LATITUDE_SOUTH, "T", BdhLogUtil.LogTag.Tag_Req, "", "", "relationMap", "X", "V", "isClickReport", "c0", "userId", "d0", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Lcom/tencent/timi/game/tim/api/message/a;", "msg", "I", "Lzf4/d;", "f0", "Lzf4/d;", "tipSelectHelper", "Lcom/tencent/mobileqq/ark/module/g;", "g0", "Lcom/tencent/mobileqq/ark/module/g;", "appNotifyCallback", "h0", "Ljava/lang/String;", "appId", "Lcom/tencent/timi/game/ui/widget/TimiArkView;", "i0", "Lcom/tencent/timi/game/ui/widget/TimiArkView;", "arkView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "j0", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class ShareArkMessageItemView extends BaseMessageView {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final zf4.d tipSelectHelper;

    /* renamed from: g0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.ark.module.g appNotifyCallback;

    /* renamed from: h0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId;

    /* renamed from: i0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TimiArkView arkView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/timi/game/component/chat/message/ShareArkMessageItemView$b", "Lcom/tencent/timi/game/utils/IResultListener;", "Ltrpc/yes/common/RecommendProxyOuterClass$SendIMArkMsgRsp;", "result", "", "a", "", "errorCode", "", "errorMessage", "onError", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements IResultListener<RecommendProxyOuterClass$SendIMArkMsgRsp> {
        b() {
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(@Nullable RecommendProxyOuterClass$SendIMArkMsgRsp result) {
            com.tencent.timi.game.ui.widget.f.a("\u5206\u4eab\u6218\u7ee9\u6210\u529f");
        }

        @Override // com.tencent.timi.game.utils.IResultListener
        public void onError(int errorCode, @Nullable String errorMessage) {
            com.tencent.timi.game.ui.widget.f.c("\u5206\u4eab\u6218\u7ee9\u5931\u8d25");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShareArkMessageItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void Q(JSONObject paramObject) {
        CommonOuterClass$QQUserId selfQQUserId = getSelfQQUserId();
        if (selfQQUserId != null) {
            bm4.a aVar = (bm4.a) mm4.b.b(bm4.a.class);
            QBaseActivity b16 = vf4.a.b();
            Intrinsics.checkNotNullExpressionValue(b16, "getTopQActivity()");
            String string = paramObject.getString("userUin");
            Intrinsics.checkNotNullExpressionValue(string, "paramObject.getString(\"userUin\")");
            String optString = paramObject.optString("userNick", "--");
            Intrinsics.checkNotNullExpressionValue(optString, "paramObject.optString(\"userNick\", \"--\")");
            aVar.k0(b16, selfQQUserId, string, optString, Y(paramObject), paramObject.optInt(VirtualAppProxy.KEY_GAME_ID));
        }
    }

    private final void R(MessageOuterClass$ShareArkMsg arkMsg, JSONObject paramObject) {
        boolean z16;
        JSONArray optJSONArray = paramObject.optJSONArray("teammateUins");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            AppRuntime a16 = vf4.a.a();
            String uin = optJSONArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(uin, "uin");
            if (a16 != null) {
                z16 = ((bm4.a) mm4.b.b(bm4.a.class)).H3(uin, a16);
            } else {
                z16 = false;
            }
            linkedHashMap.put(uin, Boolean.valueOf(z16));
        }
        X(arkMsg, linkedHashMap);
    }

    private final void S(MessageOuterClass$ShareArkMsg arkMsg, JSONObject paramObject) {
        PBInt32Field pBInt32Field;
        CommonOuterClass$QQUserId selfQQUserId = getSelfQQUserId();
        boolean z16 = false;
        if (selfQQUserId != null && (pBInt32Field = selfQQUserId.user_from) != null && pBInt32Field.get() == 4) {
            z16 = true;
        }
        if (z16) {
            T(arkMsg, paramObject);
        } else {
            R(arkMsg, paramObject);
        }
    }

    private final void T(final MessageOuterClass$ShareArkMsg arkMsg, JSONObject paramObject) {
        Long longOrNull;
        long j3;
        JSONArray optJSONArray = paramObject.optJSONArray("teammateTinyIds");
        final LinkedHashMap linkedHashMap = new LinkedHashMap();
        final ArrayList arrayList = new ArrayList();
        if (optJSONArray == null) {
            return;
        }
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            String tinyId = optJSONArray.getString(i3);
            Intrinsics.checkNotNullExpressionValue(tinyId, "tinyId");
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(tinyId);
            if (longOrNull != null) {
                j3 = longOrNull.longValue();
            } else {
                j3 = 0;
            }
            if (j3 != 0) {
                arrayList.add(Long.valueOf(j3));
            }
        }
        ((bm4.a) mm4.b.b(bm4.a.class)).h3(arrayList, new INearbyAddFriendHelper.b() { // from class: com.tencent.timi.game.component.chat.message.al
            @Override // com.tencent.mobileqq.newnearby.INearbyAddFriendHelper.b
            public final void a(List list) {
                ShareArkMessageItemView.U(arrayList, linkedHashMap, this, arkMsg, list);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(List tinyIdList, Map relationMap, ShareArkMessageItemView this$0, MessageOuterClass$ShareArkMsg arkMsg, List list) {
        Intrinsics.checkNotNullParameter(tinyIdList, "$tinyIdList");
        Intrinsics.checkNotNullParameter(relationMap, "$relationMap");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(arkMsg, "$arkMsg");
        if (list != null && list.size() == tinyIdList.size()) {
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                String valueOf = String.valueOf(((Number) tinyIdList.get(i3)).longValue());
                Object obj = list.get(i3);
                Intrinsics.checkNotNullExpressionValue(obj, "result[index]");
                relationMap.put(valueOf, obj);
            }
        }
        this$0.X(arkMsg, relationMap);
    }

    private final void V(MessageOuterClass$ShareArkMsg arkMsg) {
        boolean z16;
        gh4.e I0 = ((gh4.f) mm4.b.b(gh4.f.class)).I0();
        if (I0 != null) {
            if (arkMsg.game_id.get() == I0.getMYesGameId()) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                if (getRoomInfo() != null) {
                    xf4.a aVar = xf4.a.f447906a;
                    int i3 = arkMsg.game_id.get();
                    int i16 = arkMsg.card_type.get();
                    long mRoomIdFromServer = I0.getMRoomIdFromServer();
                    CommonOuterClass$QQUserId mQQUserId = I0.getMQQUserId();
                    String str = arkMsg.ark_msg_info.meta.get();
                    Intrinsics.checkNotNullExpressionValue(str, "arkMsg.ark_msg_info.meta.get()");
                    aVar.a(i3, i16, mRoomIdFromServer, mQQUserId, str, new b());
                    return;
                }
                return;
            }
        }
        String X0 = ((ag4.h) mm4.b.b(ag4.h.class)).X0(arkMsg.game_id.get());
        Intrinsics.checkNotNullExpressionValue(X0, "getService(IGameConfigSe\u2026ame(arkMsg.game_id.get())");
        com.tencent.timi.game.ui.widget.f.c("\u76ee\u524d\u4e0d\u5728" + X0 + "\u4ea4\u53cb\u5927\u5385\u65e0\u6cd5\u5206\u4eab\u54e6\uff5e");
    }

    private final void W(MessageOuterClass$ShareArkMsg arkMsg, JSONObject paramObject) {
        int optInt = paramObject.optInt("width");
        int optInt2 = paramObject.optInt("height");
        com.tencent.timi.game.utils.l.i("ShareArkMessageItemView", "ark size change w = [" + optInt + "], h = [" + optInt2 + "]");
        com.tencent.timi.game.tim.api.message.a msg2 = getMsg();
        if (msg2 != null) {
            msg2.n(com.tencent.timi.game.utils.b.a(optInt2));
        }
        getBaseContentContainer().setMinimumHeight(0);
        if (optInt > 0 && optInt2 > 0) {
            this.arkView.q(new ArkAppInfo.Size(com.tencent.timi.game.utils.b.a(optInt), com.tencent.timi.game.utils.b.a(optInt2)));
        }
        a aVar = a.f376607a;
        if (optInt2 > aVar.a(arkMsg.card_type.get())) {
            aVar.b(arkMsg.card_type.get(), com.tencent.timi.game.utils.b.a(optInt2));
        }
    }

    private final void X(MessageOuterClass$ShareArkMsg arkMsg, Map<String, Boolean> relationMap) {
        Map map;
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("arkuin", this.arkView.getMUniqueId());
        map = MapsKt__MapsKt.toMap(relationMap);
        jSONObject.put("relationships", new JSONObject(map));
        ((IArkAPIService) QRoute.api(IArkAPIService.class)).postArkNotify(arkMsg.ark_msg_info.appid.get(), "", "native_query_relationship_cb", jSONObject.toString());
    }

    private final CommonOuterClass$QQUserId Y(JSONObject paramObject) {
        long j3;
        Integer intOrNull;
        int i3;
        long j16;
        String guildId = paramObject.optString("guildId");
        String userFrom = paramObject.optString("userFrom");
        String userUin = paramObject.optString("userUin");
        String userYesId = paramObject.optString("userYesId");
        CommonOuterClass$QQUserId commonOuterClass$QQUserId = new CommonOuterClass$QQUserId();
        PBUInt64Field pBUInt64Field = commonOuterClass$QQUserId.guild_id;
        Intrinsics.checkNotNullExpressionValue(guildId, "guildId");
        ULong uLongOrNull = UStringsKt.toULongOrNull(guildId);
        long j17 = 0;
        if (uLongOrNull != null) {
            j3 = uLongOrNull.getData();
        } else {
            j3 = 0;
        }
        pBUInt64Field.set(j3);
        PBInt32Field pBInt32Field = commonOuterClass$QQUserId.user_from;
        Intrinsics.checkNotNullExpressionValue(userFrom, "userFrom");
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(userFrom);
        if (intOrNull != null) {
            i3 = intOrNull.intValue();
        } else {
            i3 = 0;
        }
        pBInt32Field.set(i3);
        PBUInt64Field pBUInt64Field2 = commonOuterClass$QQUserId.uid;
        Intrinsics.checkNotNullExpressionValue(userUin, "userUin");
        ULong uLongOrNull2 = UStringsKt.toULongOrNull(userUin);
        if (uLongOrNull2 != null) {
            j16 = uLongOrNull2.getData();
        } else {
            j16 = 0;
        }
        pBUInt64Field2.set(j16);
        PBUInt64Field pBUInt64Field3 = commonOuterClass$QQUserId.yes_uid;
        Intrinsics.checkNotNullExpressionValue(userYesId, "userYesId");
        ULong uLongOrNull3 = UStringsKt.toULongOrNull(userYesId);
        if (uLongOrNull3 != null) {
            j17 = uLongOrNull3.getData();
        }
        pBUInt64Field3.set(j17);
        return commonOuterClass$QQUserId;
    }

    private final void Z(MessageOuterClass$ShareArkMsg arkMsg, String eventName, final JSONObject paramObject) {
        switch (eventName.hashCode()) {
            case -1865861548:
                if (eventName.equals("ark_query_relationship")) {
                    S(arkMsg, paramObject);
                    return;
                }
                return;
            case 890274234:
                if (eventName.equals("ark_share")) {
                    V(arkMsg);
                    return;
                }
                return;
            case 908951369:
                if (eventName.equals("ark_size_change")) {
                    W(arkMsg, paramObject);
                    return;
                }
                return;
            case 1365112720:
                if (eventName.equals("ark_show_personal_info")) {
                    post(new Runnable() { // from class: com.tencent.timi.game.component.chat.message.ak
                        @Override // java.lang.Runnable
                        public final void run() {
                            ShareArkMessageItemView.a0(ShareArkMessageItemView.this, paramObject);
                        }
                    });
                    return;
                }
                return;
            case 1467308434:
                if (eventName.equals("ark_add_friends")) {
                    Q(paramObject);
                    return;
                }
                return;
            case 1685929086:
                if (eventName.equals("ark_greeting")) {
                    d0(Y(paramObject));
                    return;
                }
                return;
            default:
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a0(ShareArkMessageItemView this$0, JSONObject paramObject) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(paramObject, "$paramObject");
        n iMessageListener = this$0.getIMessageListener();
        if (iMessageListener != null) {
            iMessageListener.a(this$0.Y(paramObject));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0046 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0047 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final boolean b0(ShareArkMessageItemView this$0, com.tencent.timi.game.tim.api.message.a msg2, String str, String eventName, String str2) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(msg2, "$msg");
        com.tencent.timi.game.utils.l.i("ShareArkMessageItemView", "appName:" + str + ", eventName:" + eventName + ", params:" + str2);
        if (str2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return false;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    if (!Intrinsics.areEqual(this$0.arkView.getMUniqueId(), jSONObject.getString("arkuin"))) {
                        return true;
                    }
                    MessageOuterClass$ShareArkMsg messageOuterClass$ShareArkMsg = msg2.a().share_ark_msg;
                    Intrinsics.checkNotNullExpressionValue(messageOuterClass$ShareArkMsg, "msg.content().share_ark_msg");
                    Intrinsics.checkNotNullExpressionValue(eventName, "eventName");
                    this$0.Z(messageOuterClass$ShareArkMsg, eventName, jSONObject);
                    return true;
                } catch (Exception unused) {
                    return false;
                }
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final void c0(boolean isClickReport) {
        long j3;
        MessageOuterClass$ShareArkMsg messageOuterClass$ShareArkMsg;
        MessageOuterClass$MsgContent a16;
        CommonOuterClass$QQUserId c16;
        PBUInt64Field pBUInt64Field;
        CommonOuterClass$QQUserId c17;
        PBUInt64Field pBUInt64Field2;
        com.tencent.timi.game.tim.api.message.a msg2 = getMsg();
        long j16 = 0;
        if (msg2 != null && (c17 = msg2.c()) != null && (pBUInt64Field2 = c17.uid) != null) {
            j3 = pBUInt64Field2.get();
        } else {
            j3 = 0;
        }
        com.tencent.timi.game.tim.api.message.a msg3 = getMsg();
        if (msg3 != null && (c16 = msg3.c()) != null && (pBUInt64Field = c16.yes_uid) != null) {
            j16 = pBUInt64Field.get();
        }
        long j17 = j16;
        zf4.b bVar = zf4.b.f452467a;
        TimiArkView timiArkView = this.arkView;
        com.tencent.timi.game.tim.api.message.a msg4 = getMsg();
        if (msg4 != null && (a16 = msg4.a()) != null) {
            messageOuterClass$ShareArkMsg = a16.share_ark_msg;
        } else {
            messageOuterClass$ShareArkMsg = null;
        }
        bVar.c(timiArkView, messageOuterClass$ShareArkMsg, getRoomInfo(), j3, j17, l(), isClickReport);
    }

    private final void d0(CommonOuterClass$QQUserId userId) {
        zf4.c.f452468a.m(userId, getMsg(), getRoomInfo(), getSelfQQUserId(), this.tipSelectHelper);
        c0(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView
    public void I(@NotNull final com.tencent.timi.game.tim.api.message.a msg2) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        super.I(msg2);
        this.arkView.setOnLongClickListener(getOnLongClickListner());
        MessageOuterClass$ArkBaseInfo arkMsgInfo = msg2.a().share_ark_msg.ark_msg_info;
        int i3 = msg2.a().share_ark_msg.card_type.get();
        c0(false);
        int m3 = msg2.m();
        if (m3 > 0) {
            getBaseContentContainer().setMinimumHeight(m3);
        } else {
            a aVar = a.f376607a;
            if (aVar.a(i3) > 0) {
                getBaseContentContainer().setMinimumHeight(aVar.a(i3));
            }
        }
        com.tencent.mobileqq.ark.module.g gVar = this.appNotifyCallback;
        if (gVar != null) {
            un4.d.f439289a.s(gVar);
        }
        String str = arkMsgInfo.appid.get();
        Intrinsics.checkNotNullExpressionValue(str, "arkMsgInfo.appid.get()");
        this.appId = str;
        this.appNotifyCallback = new com.tencent.mobileqq.ark.module.g() { // from class: com.tencent.timi.game.component.chat.message.aj
            @Override // com.tencent.mobileqq.ark.module.g
            public final boolean notify(String str2, String str3, String str4) {
                boolean b06;
                b06 = ShareArkMessageItemView.b0(ShareArkMessageItemView.this, msg2, str2, str3, str4);
                return b06;
            }
        };
        un4.d dVar = un4.d.f439289a;
        String str2 = this.appId;
        String mUniqueId = this.arkView.getMUniqueId();
        com.tencent.mobileqq.ark.module.g gVar2 = this.appNotifyCallback;
        Intrinsics.checkNotNull(gVar2);
        dVar.o(str2, mUniqueId, gVar2);
        TimiArkView timiArkView = this.arkView;
        Intrinsics.checkNotNullExpressionValue(arkMsgInfo, "arkMsgInfo");
        timiArkView.l(arkMsgInfo, new c());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        boolean isBlank;
        super.onAttachedToWindow();
        if (this.appNotifyCallback != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(this.appId);
            if (!isBlank) {
                un4.d dVar = un4.d.f439289a;
                String str = this.appId;
                String mUniqueId = this.arkView.getMUniqueId();
                com.tencent.mobileqq.ark.module.g gVar = this.appNotifyCallback;
                Intrinsics.checkNotNull(gVar);
                dVar.o(str, mUniqueId, gVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.component.chat.message.BaseMessageView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        com.tencent.mobileqq.ark.module.g gVar = this.appNotifyCallback;
        if (gVar != null) {
            un4.d.f439289a.s(gVar);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ShareArkMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ShareArkMessageItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public ShareArkMessageItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.tipSelectHelper = new zf4.d();
        this.appId = "";
        setContentView(R.layout.hwd);
        View findViewById = findViewById(R.id.y_);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.arkView)");
        TimiArkView timiArkView = (TimiArkView) findViewById;
        this.arkView = timiArkView;
        if (context instanceof LifecycleOwner) {
            timiArkView.e((LifecycleOwner) context);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/component/chat/message/ShareArkMessageItemView$c", "Lcom/tencent/ark/ArkViewImplement$LoadCallback;", "", "p0", "p1", "", "p2", "", "p3", "", "onLoadFailed", "onLoadState", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements ArkViewImplement.LoadCallback {
        c() {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadState(int p06) {
        }

        @Override // com.tencent.ark.ArkViewImplement.LoadCallback
        public void onLoadFailed(int p06, int p16, @Nullable String p26, boolean p36) {
        }
    }
}
