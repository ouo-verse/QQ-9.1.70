package com.tencent.mobileqq.gamecenter.nt.api.impl;

import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.api.TabPreloadItem;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.msginfo.GameCenterSessionInfo;
import com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi;
import com.tencent.mobileqq.icgame.api.room.PreloadTRTCPlayerParams;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgAttributeInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.QueryMsgsParams;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactExtAttr;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.nativeinterface.TempChatGameSession;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.kernelpublic.nativeinterface.MsgAbstractElement;
import com.tencent.qqnt.msg.api.IMsgUtilApi;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 v2\u00020\u0001:\u0001wB\u0007\u00a2\u0006\u0004\bt\u0010uJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u001a\u0010\u000e\u001a\u0004\u0018\u00010\f2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0002JB\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001aj\b\u0012\u0004\u0012\u00020\u0002`\u001b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000b2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0002J*\u0010\u001e\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0016\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u001aj\b\u0012\u0004\u0012\u00020\u0002`\u001bH\u0002J\u0018\u0010\"\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J(\u0010&\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020 2\u0006\u0010%\u001a\u00020$H\u0016J*\u0010+\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u00172\u0006\u0010(\u001a\u00020\u00172\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010%\u001a\u00020$H\u0016J \u0010-\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010%\u001a\u00020,H\u0016J\u0016\u0010/\u001a\u00020.2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 J\u0018\u00100\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016J\u0014\u00103\u001a\u0004\u0018\u0001022\b\u00101\u001a\u0004\u0018\u00010\u0002H\u0016J*\u0010:\u001a\u00020\u000f2\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u00020\t2\u0006\u00107\u001a\u00020 2\b\u00109\u001a\u0004\u0018\u000108H\u0016J\u0014\u0010<\u001a\u0004\u0018\u0001022\b\u0010;\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010=\u001a\u0004\u0018\u0001022\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u001a\u0010?\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\u0006\u0010%\u001a\u00020>H\u0016J\u0014\u0010A\u001a\u0004\u0018\u00010@2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u000e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bH\u0016J\u0012\u0010C\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u001a\u0010D\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u001a\u0010E\u001a\u0004\u0018\u00010\u00022\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u0004H\u0016J\u0010\u0010G\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020FH\u0016J\u0010\u0010H\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020FH\u0016J\u001c\u0010I\u001a\u00020\u000f2\b\u0010;\u001a\u0004\u0018\u00010\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u001c\u0010I\u001a\u00020\u000f2\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020M0LH\u0016J\u0010\u0010O\u001a\n\u0012\u0006\b\u0001\u0012\u00020M0LH\u0016J\u0018\u0010R\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\u0017H\u0016J\u0018\u0010R\u001a\u00020\u00042\u0006\u0010S\u001a\u00020\u00042\u0006\u0010T\u001a\u00020\u0004H\u0016J(\u0010X\u001a\u00020\u000f2\u0006\u0010U\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010V\u001a\u00020\u00042\u0006\u0010W\u001a\u000202H\u0016J\u0014\u0010[\u001a\u0004\u0018\u00010Z2\b\u0010Y\u001a\u0004\u0018\u00010\u0004H\u0016J$\u0010^\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010\\\u001a\u0004\u0018\u00010Z2\u0006\u0010]\u001a\u00020\tH\u0016Jj\u0010f\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010_\u001a\u0004\u0018\u00010\u00042\b\u0010`\u001a\u0004\u0018\u00010\u00042\b\u0010a\u001a\u0004\u0018\u00010\u00042\b\u0010b\u001a\u0004\u0018\u00010\u00042\b\u0010Q\u001a\u0004\u0018\u00010\u00042\b\u0010P\u001a\u0004\u0018\u00010\u00042\b\u0010c\u001a\u0004\u0018\u00010\u00042\b\u0010d\u001a\u0004\u0018\u00010\u00042\u0006\u0010e\u001a\u00020 H\u0016J\u001c\u0010h\u001a\u0002022\b\u0010\u001f\u001a\u0004\u0018\u00010\u00042\b\u0010g\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010i\u001a\u0004\u0018\u0001022\u0006\u0010g\u001a\u00020\u0004H\u0016J\u0018\u0010j\u001a\u00020\u00042\u0006\u0010P\u001a\u00020\u00172\u0006\u0010Q\u001a\u00020\u0017H\u0016J\u0012\u0010l\u001a\u0004\u0018\u00010@2\u0006\u0010k\u001a\u00020\u0004H\u0016J\u0012\u0010m\u001a\u0004\u0018\u00010\u00042\u0006\u0010k\u001a\u00020\u0004H\u0016J\b\u0010n\u001a\u00020\u000fH\u0016R*\u0010o\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0002\u0018\u0001`\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010pR \u0010r\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u000f0q8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\br\u0010s\u00a8\u0006x"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/nt/api/impl/GameMsgNtApiImpl;", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "getContentFromContact", "Lmqq/app/AppRuntime;", "kotlin.jvm.PlatformType", "getApp", "", "isContactValid", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", TabPreloadItem.TAB_NAME_MESSAGE, "filterValidGameMsg", "", "clearGameRecentContactList", "Lcom/tencent/qqnt/kernel/api/aa;", "getRecentContactService", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "contactInfo", "onRecentContactListChanged", "originList", "", "sortedContactList", "changedList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "mergeChangeListToChange", "list", "addValidContactInfo", "peerUid", "", "chatType", "setMsgRead", "limitSize", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$b;", "listener", "getMsgList", "msgId", "msgTime", "Lcom/tencent/qqnt/kernel/nativeinterface/QueryMsgsParams;", "params", "queryMsgsWithFilter", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$a;", "getLatestMsg", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "getContact", "buildRecentContactInfo", "contact", "Lcom/tencent/qqnt/kernel/nativeinterface/TempChatGameSession;", "getGameSessionFromContact", "Lcom/tencent/qqnt/kernel/nativeinterface/AnchorPointContactInfo;", "anchor", "fetchOld", "count", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "fetchGameRecentContactInfo", "msg", "getGameSessionFromMsg", "getGameSessionFromPeerUid", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$c;", "getTempGameSessionFromPeerUid", "Lcom/tencent/mobileqq/gamecenter/msginfo/GameCenterSessionInfo;", "getGameSessionInfo", "getGameRecentContactList", "getGameRecentContact", "getRecentContactInfo", "getGameRecentContactInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "addMsgListener", "removeMsgListener", "addGrayTipForGameAIO", "Lcom/tencent/qqnt/graytips/local/LocalGrayTip;", "localGrayTip", "Ljava/lang/Class;", "Lcom/tencent/qqnt/graytips/handler/b;", "getGrayTipsJumpSettingHandlerClz", "getGrayTipsAddFriendHandlerClz", "selfTinyId", "peerTinyId", "createUidFromTinyId", "selfTinyIdStr", "peerTinyIdStr", "sayHiType", "text", "gameSession", "sendSayHiMsg", "content", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "createArkElement", "arkElement", "front", "insertLocalArkRecord", "peerRoleId", "selfRoleId", "peerOpenId", "selfOpenId", "gameAppId", PreloadTRTCPlayerParams.KEY_SIG, "pushWindowFlag", "getGameSessionJson", "jsonStr", "getGameSessionFromPeerUidOrJson", "parseGameSessionJson", "createConvertUinFromTinyId", "convertUin", "getSessionInfoByUin", "getPeerUidByUin", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "mGameRecentContactList", "Ljava/util/ArrayList;", "Lkotlin/Function1;", "mGameRecentContactListener", "Lkotlin/jvm/functions/Function1;", "<init>", "()V", "Companion", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class GameMsgNtApiImpl implements IGameMsgNtApi {

    @NotNull
    private static final String TAG = "GameMsgNtApiImpl";

    @Nullable
    private ArrayList<RecentContactInfo> mGameRecentContactList;

    @NotNull
    private final Function1<RecentContactListChangedInfo, Unit> mGameRecentContactListener = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.GameMsgNtApiImpl$mGameRecentContactListener$1
        /* JADX INFO: Access modifiers changed from: package-private */
        {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
            invoke2(recentContactListChangedInfo);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull RecentContactListChangedInfo it) {
            Intrinsics.checkNotNullParameter(it, "it");
            GameMsgNtApiImpl.this.onRecentContactListChanged(it);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0007\u001a\u00020\u00062\u0016\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/gamecenter/nt/api/impl/GameMsgNtApiImpl$b", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$b;", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "Lkotlin/collections/ArrayList;", TabPreloadItem.TAB_NAME_MESSAGE, "", "onSuccess", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements IGameMsgNtApi.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGameMsgNtApi.a f212258a;

        b(IGameMsgNtApi.a aVar) {
            this.f212258a = aVar;
        }

        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.b
        public void onSuccess(@NotNull ArrayList<MsgRecord> msgList) {
            MsgRecord msgRecord;
            Intrinsics.checkNotNullParameter(msgList, "msgList");
            IGameMsgNtApi.a aVar = this.f212258a;
            if (msgList.isEmpty()) {
                msgRecord = null;
            } else {
                msgRecord = msgList.get(0);
            }
            aVar.a(msgRecord);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/gamecenter/nt/api/impl/GameMsgNtApiImpl$c", "Lcom/tencent/mobileqq/gamecenter/nt/api/IGameMsgNtApi$a;", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "latestMsg", "", "a", "qq-gamecenter-msg-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements IGameMsgNtApi.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ GameMsgNtApiImpl f212259a;

        c(IGameMsgNtApi.c cVar, GameMsgNtApiImpl gameMsgNtApiImpl) {
            this.f212259a = gameMsgNtApiImpl;
        }

        @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi.a
        public void a(@Nullable MsgRecord latestMsg) {
            this.f212259a.getGameSessionFromMsg(latestMsg);
            throw null;
        }
    }

    private final void addValidContactInfo(RecentContactInfo contactInfo, ArrayList<RecentContactInfo> list) {
        if (!isContactValid(contactInfo)) {
            return;
        }
        Intrinsics.checkNotNull(contactInfo);
        list.add(contactInfo);
    }

    private final void clearGameRecentContactList() {
        this.mGameRecentContactList = null;
    }

    private final MsgRecord filterValidGameMsg(List<MsgRecord> msgList) {
        MsgRecord msgRecord;
        if (msgList != null && !msgList.isEmpty()) {
            int size = msgList.size();
            do {
                size--;
                if (-1 < size) {
                    msgRecord = msgList.get(size);
                    if (hd1.a.e(msgRecord)) {
                        break;
                    }
                }
            } while (!hd1.a.d(msgRecord));
            return msgRecord;
        }
        return null;
    }

    private final AppRuntime getApp() {
        return MobileQQ.sMobileQQ.peekAppRuntime();
    }

    private final String getContentFromContact(RecentContactInfo info) {
        String str;
        Object obj;
        boolean z16;
        if (info == null) {
            return "";
        }
        ArrayList<MsgAbstractElement> arrayList = info.abstractContent;
        Intrinsics.checkNotNullExpressionValue(arrayList, "info.abstractContent");
        Iterator<T> it = arrayList.iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                String str2 = ((MsgAbstractElement) obj).content;
                if (str2 != null && str2.length() != 0) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MsgAbstractElement msgAbstractElement = (MsgAbstractElement) obj;
        if (msgAbstractElement != null) {
            str = msgAbstractElement.content;
        }
        if (str == null) {
            return "";
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void getMsgList$lambda$1(IGameMsgNtApi.b listener, long j3, int i3, String errMsg, ArrayList arrayList) {
        boolean z16;
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        ArrayList<MsgRecord> arrayList2 = new ArrayList<>();
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            arrayList2.addAll(arrayList);
        }
        listener.onSuccess(arrayList2);
        QLog.d(TAG, 4, "[getMsgList] result:" + i3 + ",errMsg" + errMsg + ",listSize:" + arrayList2.size() + ",cost:" + (System.currentTimeMillis() - j3) + ",thread:" + Thread.currentThread());
    }

    private final aa getRecentContactService() {
        return ((IKernelService) getApp().getRuntimeService(IKernelService.class, "all")).getRecentContactService();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertLocalArkRecord$lambda$10(int i3, String str) {
        QLog.i(TAG, 1, "[insertLocalArkRecord] result " + i3 + " errMsg " + str);
    }

    private final boolean isContactValid(RecentContactInfo info) {
        boolean z16;
        if (info != null && info.chatType == 105) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            return false;
        }
        TempChatGameSession gameSessionFromContact = getGameSessionFromContact(info);
        if (gameSessionFromContact == null) {
            QLog.d(TAG, 2, "gameSession is null");
            return false;
        }
        if (!TextUtils.isEmpty(gameSessionFromContact.peerRoleId) && !TextUtils.isEmpty(gameSessionFromContact.selfRoleId)) {
            return true;
        }
        QLog.d(TAG, 2, "gameSession is invalid,gameSession:" + gameSessionFromContact);
        return false;
    }

    private final ArrayList<RecentContactInfo> mergeChangeListToChange(List<RecentContactInfo> originList, List<Long> sortedContactList, List<RecentContactInfo> changedList) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        int collectionSizeOrDefault2;
        int mapCapacity2;
        int coerceAtLeast2;
        Unit unit;
        RecentContactInfo recentContactInfo;
        List<RecentContactInfo> list = originList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(Long.valueOf(((RecentContactInfo) obj).contactId), obj);
        }
        List<RecentContactInfo> list2 = changedList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        mapCapacity2 = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault2);
        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mapCapacity2, 16);
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(coerceAtLeast2);
        for (Object obj2 : list2) {
            linkedHashMap2.put(Long.valueOf(((RecentContactInfo) obj2).contactId), obj2);
        }
        ArrayList<RecentContactInfo> arrayList = new ArrayList<>();
        Iterator<T> it = sortedContactList.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            RecentContactInfo recentContactInfo2 = (RecentContactInfo) linkedHashMap2.get(Long.valueOf(longValue));
            if (recentContactInfo2 != null) {
                addValidContactInfo(recentContactInfo2, arrayList);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null && (recentContactInfo = (RecentContactInfo) linkedHashMap.get(Long.valueOf(longValue))) != null) {
                addValidContactInfo(recentContactInfo, arrayList);
            }
        }
        QLog.i(TAG, 2, "[mergeChangeListToChange] originList:" + originList.size() + ",sortedList:" + sortedContactList.size() + ",changedList:" + changedList.size() + ",newList:" + arrayList.size());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onRecentContactListChanged(RecentContactListChangedInfo contactInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(contactInfo.changedList);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(contactInfo.sortedContactList);
        this.mGameRecentContactList = mergeChangeListToChange(getGameRecentContactList(), arrayList2, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryMsgsWithFilter$lambda$2(IGameMsgNtApi.b listener, long j3, int i3, String str, ArrayList msgList) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        listener.onSuccess(msgList);
        QLog.d(TAG, 2, "[queryMsgsWithFilter] result:" + i3 + ",errMsg" + str + ",listSize:" + msgList.size() + ",cost:" + (System.currentTimeMillis() - j3) + ",thread:" + Thread.currentThread());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sendSayHiMsg$lambda$9(int i3, int i16, String str) {
        QLog.i(TAG, 1, "[sendMsg] sayHiType:" + i3 + ",errMsg:" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setMsgRead$lambda$0(int i3, String str) {
        QLog.i(TAG, 2, "[setMsgRead] result:" + i3 + ",errMsg:" + str);
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void addGrayTipForGameAIO(@Nullable String msg2, @Nullable String peerUid) {
        if (!TextUtils.isEmpty(msg2) && !TextUtils.isEmpty(peerUid)) {
            Intrinsics.checkNotNull(peerUid);
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(peerUid, 105, 656397L, 0, false, false, null, 120, null);
            Intrinsics.checkNotNull(msg2);
            LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, msg2, 0, 2, null);
            addGrayTipForGameAIO(localGrayTipBuilder.m(), peerUid);
            return;
        }
        QLog.i(TAG, 1, "[addGrayTipForGameAIO] msg or peerUid is empty");
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void addMsgListener(@NotNull IKernelMsgListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.addMsgListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public RecentContactInfo buildRecentContactInfo(@NotNull String peerUid, int chatType) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        RecentContactInfo recentContactInfo = new RecentContactInfo();
        recentContactInfo.peerUid = peerUid;
        recentContactInfo.chatType = chatType;
        return recentContactInfo;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public MsgElement createArkElement(@Nullable String content) {
        boolean z16;
        if (content != null && content.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e(TAG, 1, "insertLocalArkRecord params invalid,content:" + content);
            return null;
        }
        com.tencent.qqnt.msg.data.a aVar = new com.tencent.qqnt.msg.data.a();
        aVar.o(content);
        return ((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createArkElement(aVar);
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public String createConvertUinFromTinyId(long selfTinyId, long peerTinyId) {
        try {
            String f16 = ((IMessageFacade) getApp().getRuntimeService(IMessageFacade.class, "")).getTinyIdCache().f(String.valueOf(peerTinyId), String.valueOf(selfTinyId));
            if (f16 == null) {
                return "";
            }
            return f16;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public String createUidFromTinyId(long selfTinyId, long peerTinyId) {
        String createUidFromTinyId;
        w e16 = com.tencent.qqnt.msg.f.e();
        return (e16 == null || (createUidFromTinyId = e16.createUidFromTinyId(selfTinyId, peerTinyId)) == null) ? "" : createUidFromTinyId;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void fetchGameRecentContactInfo(@NotNull AnchorPointContactInfo anchor, boolean fetchOld, int count, @Nullable IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        aa recentContactService = getRecentContactService();
        if (recentContactService != null) {
            recentContactService.m(4, this.mGameRecentContactListener);
            recentContactService.g0(4, this.mGameRecentContactListener);
        }
        QLog.i(TAG, 1, "[fetchGameRecentContactInfo] start");
        aa recentContactService2 = ((IKernelService) getApp().getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        if (recentContactService2 != null) {
            recentContactService2.v(anchor, fetchOld, 4, count, callback);
        }
    }

    @NotNull
    public final Contact getContact(@NotNull String peerUid, int chatType) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return new Contact(chatType, peerUid, "");
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public RecentContactInfo getGameRecentContact(@NotNull String peerUid) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Iterator<T> it = getGameRecentContactList().iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                RecentContactInfo recentContactInfo = (RecentContactInfo) obj;
                boolean z17 = true;
                if (peerUid.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    z17 = Intrinsics.areEqual(recentContactInfo.peerUid, peerUid);
                }
                if (z17) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (RecentContactInfo) obj;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public RecentContactInfo getGameRecentContactInfo(int chatType, @NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        for (RecentContactInfo recentContactInfo : getGameRecentContactList()) {
            if (recentContactInfo.chatType == chatType && Intrinsics.areEqual(recentContactInfo.peerUid, peerUid)) {
                return recentContactInfo;
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public List<RecentContactInfo> getGameRecentContactList() {
        List<RecentContactInfo> emptyList;
        ArrayList<RecentContactInfo> arrayList = this.mGameRecentContactList;
        if (arrayList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
            return emptyList;
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public TempChatGameSession getGameSessionFromContact(@Nullable RecentContactInfo contact) {
        if (contact != null) {
            ArrayList<RecentContactExtAttr> arrayList = contact.extAttrs;
            if (arrayList.size() == 0 && contact.nestedChangedList.size() > 0) {
                arrayList = contact.nestedChangedList.get(0).extAttrs;
            }
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                RecentContactExtAttr recentContactExtAttr = arrayList.get(i3);
                Intrinsics.checkNotNullExpressionValue(recentContactExtAttr, "extAttrs[i]");
                TempChatGameSession tempChatGameSession = recentContactExtAttr.gameSession;
                if (tempChatGameSession != null) {
                    return tempChatGameSession;
                }
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public TempChatGameSession getGameSessionFromMsg(@Nullable MsgRecord msg2) {
        HashMap<Integer, MsgAttributeInfo> hashMap;
        MsgAttributeInfo msgAttributeInfo;
        if (msg2 != null && (hashMap = msg2.msgAttrs) != null && (msgAttributeInfo = hashMap.get(6)) != null) {
            return msgAttributeInfo.gameChatSession;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public TempChatGameSession getGameSessionFromPeerUid(@NotNull String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        return getGameSessionFromContact(getGameRecentContact(peerUid));
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public TempChatGameSession getGameSessionFromPeerUidOrJson(@Nullable String peerUid, @Nullable String jsonStr) {
        boolean z16;
        TempChatGameSession tempChatGameSession;
        boolean z17 = false;
        if (peerUid != null && peerUid.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            tempChatGameSession = getGameSessionFromPeerUid(peerUid);
            if (tempChatGameSession != null) {
                return tempChatGameSession;
            }
        } else {
            tempChatGameSession = null;
        }
        if (jsonStr == null || jsonStr.length() == 0) {
            z17 = true;
        }
        if (!z17) {
            tempChatGameSession = parseGameSessionJson(jsonStr);
        }
        if (tempChatGameSession == null) {
            return new TempChatGameSession();
        }
        return tempChatGameSession;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public GameCenterSessionInfo getGameSessionInfo(@Nullable RecentContactInfo info) {
        AppRuntime app = getApp();
        TempChatGameSession gameSessionFromContact = getGameSessionFromContact(info);
        if ((app instanceof AppInterface) && info != null && gameSessionFromContact != null) {
            IRuntimeService runtimeService = app.getRuntimeService(IGameMsgManagerService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IG\u2026va, ProcessConstant.MAIN)");
            if (((IGameMsgManagerService) runtimeService).isGameMsgBlocked(String.valueOf(gameSessionFromContact.gameAppId))) {
                return null;
            }
            GameCenterSessionInfo gameCenterSessionInfo = new GameCenterSessionInfo();
            gameCenterSessionInfo.a0(info.msgTime);
            gameCenterSessionInfo.Z(getContentFromContact(info));
            gameCenterSessionInfo.N(String.valueOf(gameSessionFromContact.gameAppId));
            gameCenterSessionInfo.j0(createConvertUinFromTinyId(gameSessionFromContact.selfTinyId, gameSessionFromContact.peerTinyId));
            gameCenterSessionInfo.C(info.chatType);
            gameCenterSessionInfo.m0((int) info.unreadCnt);
            gameCenterSessionInfo.i0(gameSessionFromContact.peerRoleId);
            gameCenterSessionInfo.b0(gameSessionFromContact.selfRoleId);
            gameCenterSessionInfo.G(gameSessionFromContact.peerTinyId);
            gameCenterSessionInfo.l0(gameSessionFromContact.selfTinyId);
            return gameCenterSessionInfo;
        }
        QLog.e(TAG, 1, "[createSessionInfo] param is error,app" + app + ",info" + app);
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public String getGameSessionJson(@Nullable String peerUid, @Nullable String peerRoleId, @Nullable String selfRoleId, @Nullable String peerOpenId, @Nullable String selfOpenId, @Nullable String peerTinyId, @Nullable String selfTinyId, @Nullable String gameAppId, @Nullable String sig, int pushWindowFlag) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("peerUid", peerUid);
            jSONObject.put("peerRoleId", peerRoleId);
            jSONObject.put("selfRoleId", selfRoleId);
            jSONObject.put("peerOpenId", peerOpenId);
            jSONObject.put("selfOpenId", selfOpenId);
            jSONObject.put("peerTinyId", peerTinyId);
            jSONObject.put("selfTinyId", selfTinyId);
            jSONObject.put("gameAppId", gameAppId);
            jSONObject.put(PreloadTRTCPlayerParams.KEY_SIG, sig);
            jSONObject.put("pushWindowFlag", pushWindowFlag);
            String jSONObject2 = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject2, "obj.toString()");
            return jSONObject2;
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public Class<? extends com.tencent.qqnt.graytips.handler.b> getGrayTipsAddFriendHandlerClz() {
        return ld1.b.class;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public Class<? extends com.tencent.qqnt.graytips.handler.b> getGrayTipsJumpSettingHandlerClz() {
        return ld1.d.class;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void getLatestMsg(@NotNull String peerUid, int chatType, @NotNull IGameMsgNtApi.a listener) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        getMsgList(peerUid, chatType, 1, new b(listener));
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void getMsgList(@NotNull String peerUid, int chatType, int limitSize, @NotNull final IGameMsgNtApi.b listener) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long currentTimeMillis = System.currentTimeMillis();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.getMsgs(getContact(peerUid, chatType), 0L, limitSize, true, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GameMsgNtApiImpl.getMsgList$lambda$1(IGameMsgNtApi.b.this, currentTimeMillis, i3, str, arrayList);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public String getPeerUidByUin(@NotNull String convertUin) {
        Intrinsics.checkNotNullParameter(convertUin, "convertUin");
        GameCenterSessionInfo sessionInfoByUin = getSessionInfoByUin(convertUin);
        if (sessionInfoByUin != null) {
            return sessionInfoByUin.t();
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x004f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[LOOP:0: B:6:0x0029->B:21:?, LOOP_END, SYNTHETIC] */
    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public RecentContactInfo getRecentContactInfo(int chatType, @NotNull String peerUid) {
        List<RecentContactInfo> a16;
        boolean z16;
        boolean areEqual;
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        aa recentContactService = ((IKernelService) getApp().getRuntimeService(IKernelService.class, "all")).getRecentContactService();
        Object obj = null;
        if (recentContactService == null || (a16 = recentContactService.a()) == null) {
            return null;
        }
        Iterator<T> it = a16.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RecentContactInfo recentContactInfo = (RecentContactInfo) next;
            if (recentContactInfo.chatType == chatType) {
                z16 = true;
                if (TextUtils.isEmpty(peerUid)) {
                    areEqual = true;
                } else {
                    areEqual = Intrinsics.areEqual(recentContactInfo.peerUid, peerUid);
                }
                if (areEqual) {
                    if (!z16) {
                        obj = next;
                        break;
                    }
                }
            }
            z16 = false;
            if (!z16) {
            }
        }
        return (RecentContactInfo) obj;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public GameCenterSessionInfo getSessionInfoByUin(@NotNull String convertUin) {
        IGameMsgManagerService iGameMsgManagerService;
        Intrinsics.checkNotNullParameter(convertUin, "convertUin");
        AppRuntime app = getApp();
        if (app != null && (iGameMsgManagerService = (IGameMsgManagerService) app.getRuntimeService(IGameMsgManagerService.class, "all")) != null) {
            return iGameMsgManagerService.getSessionInfoByUin(convertUin);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void getTempGameSessionFromPeerUid(@Nullable String peerUid, @NotNull IGameMsgNtApi.c listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (peerUid == null) {
            listener.a(null);
            Unit unit = Unit.INSTANCE;
        }
        IGameMsgNtApi iGameMsgNtApi = (IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class);
        Intrinsics.checkNotNull(peerUid);
        iGameMsgNtApi.getLatestMsg(peerUid, 105, new c(listener, this));
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void insertLocalArkRecord(@Nullable String peerUid, @Nullable MsgElement arkElement, boolean front) {
        w wVar;
        IKernelService iKernelService;
        if (!TextUtils.isEmpty(peerUid) && arkElement != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null) {
                wVar = iKernelService.getMsgService();
            } else {
                wVar = null;
            }
            w wVar2 = wVar;
            if (wVar2 != null) {
                wVar2.w(new Contact(105, peerUid, ""), 11L, arkElement, front, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.h
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                    public final void onResult(int i3, String str) {
                        GameMsgNtApiImpl.insertLocalArkRecord$lambda$10(i3, str);
                    }
                });
                return;
            }
            return;
        }
        QLog.e(TAG, 1, "[insertLocalArkRecord] params is invalid,arkElement:" + arkElement);
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void onDestroy() {
        clearGameRecentContactList();
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @Nullable
    public TempChatGameSession parseGameSessionJson(@NotNull String jsonStr) {
        Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
        if (!TextUtils.isEmpty(jsonStr)) {
            try {
                JSONObject jSONObject = new JSONObject(jsonStr);
                String optString = jSONObject.optString("peerRoleId");
                String optString2 = jSONObject.optString("selfRoleId");
                String optString3 = jSONObject.optString("peerOpenId");
                String optString4 = jSONObject.optString("selfOpenId");
                String optString5 = jSONObject.optString("peerTinyId");
                Intrinsics.checkNotNullExpressionValue(optString5, "obj.optString(\"peerTinyId\")");
                long parseLong = Long.parseLong(optString5);
                String optString6 = jSONObject.optString("selfTinyId");
                Intrinsics.checkNotNullExpressionValue(optString6, "obj.optString(\"selfTinyId\")");
                long parseLong2 = Long.parseLong(optString6);
                String optString7 = jSONObject.optString("gameAppId");
                Intrinsics.checkNotNullExpressionValue(optString7, "obj.optString(\"gameAppId\")");
                return new TempChatGameSession(Long.parseLong(optString7), "", parseLong2, optString2, optString4, parseLong, optString, optString3, Integer.valueOf(jSONObject.optInt("pushWindowFlag")), 0, 0, 0);
            } catch (Exception e16) {
                QLog.e(TAG, 1, e16, new Object[0]);
            }
        }
        return null;
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void queryMsgsWithFilter(long msgId, long msgTime, @Nullable QueryMsgsParams params, @NotNull final IGameMsgNtApi.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        final long currentTimeMillis = System.currentTimeMillis();
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.queryMsgsWithFilter(msgId, msgTime, params, new IMsgOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.f
                @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    GameMsgNtApiImpl.queryMsgsWithFilter$lambda$2(IGameMsgNtApi.b.this, currentTimeMillis, i3, str, arrayList);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void removeMsgListener(@NotNull IKernelMsgListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.removeMsgListener(listener);
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void sendSayHiMsg(final int sayHiType, @NotNull String peerUid, @NotNull String text, @NotNull TempChatGameSession gameSession) {
        MsgAttributeInfo a16;
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(gameSession, "gameSession");
        ArrayList<MsgElement> arrayList = new ArrayList<>();
        HashMap<Integer, MsgAttributeInfo> hashMap = new HashMap<>();
        a16 = com.tencent.qqnt.kernel.util.a.f359256a.a(6, (i16 & 2) != 0 ? 0L : 0L, (i16 & 4) != 0 ? null : null, (i16 & 8) != 0 ? null : null, (i16 & 16) != 0 ? null : null, (i16 & 32) != 0 ? null : null, (i16 & 64) != 0 ? null : null, (i16 & 128) != 0 ? null : null, (i16 & 256) != 0 ? null : gameSession, (i16 & 512) != 0 ? null : null, (i16 & 1024) != 0 ? null : null, (i16 & 2048) != 0 ? null : null, (i16 & 4096) != 0 ? null : null, (i16 & 8192) != 0 ? null : null, (i16 & 16384) != 0 ? null : null, (i16 & 32768) != 0 ? null : null, (i16 & 65536) != 0 ? null : null, (i16 & 131072) != 0 ? null : null, (i16 & 262144) != 0 ? null : null);
        hashMap.put(105, a16);
        arrayList.add(((IMsgUtilApi) QRoute.api(IMsgUtilApi.class)).createTextElement(text));
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.sendMsg(0L, getContact(peerUid, 105), arrayList, hashMap, new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    GameMsgNtApiImpl.sendSayHiMsg$lambda$9(sayHiType, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void setMsgRead(@NotNull String peerUid, int chatType) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        w e16 = com.tencent.qqnt.msg.f.e();
        if (e16 != null) {
            e16.setMsgRead(getContact(peerUid, chatType), new IOperateCallback() { // from class: com.tencent.mobileqq.gamecenter.nt.api.impl.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    GameMsgNtApiImpl.setMsgRead$lambda$0(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    @NotNull
    public String createUidFromTinyId(@NotNull String selfTinyIdStr, @NotNull String peerTinyIdStr) {
        Intrinsics.checkNotNullParameter(selfTinyIdStr, "selfTinyIdStr");
        Intrinsics.checkNotNullParameter(peerTinyIdStr, "peerTinyIdStr");
        try {
            return ((IGameMsgNtApi) QRoute.api(IGameMsgNtApi.class)).createUidFromTinyId(Long.parseLong(selfTinyIdStr), Long.parseLong(peerTinyIdStr));
        } catch (Exception e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return "";
        }
    }

    @Override // com.tencent.mobileqq.gamecenter.nt.api.IGameMsgNtApi
    public void addGrayTipForGameAIO(@Nullable LocalGrayTip localGrayTip, @Nullable String peerUid) {
        if (localGrayTip != null && !TextUtils.isEmpty(peerUid)) {
            QLog.i(TAG, 1, "[addGrayTipForGameAIO] success");
            QRouteApi api = QRoute.api(INtGrayTipApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(INtGrayTipApi::class.java)");
            AppRuntime app = getApp();
            Intrinsics.checkNotNullExpressionValue(app, "getApp()");
            INtGrayTipApi.a.a((INtGrayTipApi) api, app, localGrayTip, null, 4, null);
            return;
        }
        QLog.i(TAG, 1, "[addGrayTipForGameAIO] localGrayTip or peerUid is empty");
    }
}
