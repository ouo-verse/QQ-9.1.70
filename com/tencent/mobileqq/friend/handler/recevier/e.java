package com.tencent.mobileqq.friend.handler.recevier;

import android.util.Pair;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.friend.api.impl.FriendDataServiceImpl;
import com.tencent.mobileqq.friend.api.impl.FriendExtensionServiceImpl;
import com.tencent.mobileqq.friend.data.FriendListRequestData;
import com.tencent.mobileqq.friend.handler.FriendHandler;
import com.tencent.mobileqq.friend.processor.BaseFriendProcessor;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import friendlist.FriendInfo;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetFriendListResp;
import friendlist.GroupInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u001f2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001IB\u0017\u0012\u0006\u0010E\u001a\u00020D\u0012\u0006\u0010F\u001a\u00020\u0002\u00a2\u0006\u0004\bG\u0010HJ\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J$\u0010\u0016\u001a\u00020\t2\u001a\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012j\n\u0012\u0004\u0012\u00020\u0013\u0018\u0001`\u0014H\u0002JH\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u0012j\b\u0012\u0004\u0012\u00020\u001e`\u00142\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0012j\b\u0012\u0004\u0012\u00020\u000f`\u00142\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J*\u0010$\u001a\u0004\u0018\u00010\f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u001c2\u0006\u0010#\u001a\u00020\"H\u0002J8\u0010'\u001a\u00020\t2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u0012j\b\u0012\u0004\u0012\u00020\u000f`\u00142\u0006\u0010&\u001a\u00020%2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J*\u0010)\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001c2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u0010-\u001a\u00020\t2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*H\u0002J\u0010\u0010/\u001a\u00020\t2\u0006\u0010.\u001a\u00020*H\u0002J0\u00103\u001a\u00020\t2\u0006\u0010(\u001a\u00020\u001c2\u0006\u00100\u001a\u00020*2\u0006\u00101\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u00102\u001a\u00020*H\u0002J\"\u00104\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0002J\u0018\u00106\u001a\u00020\t2\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u0018\u00107\u001a\u00020\t2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010&\u001a\u00020%H\u0002J\b\u00108\u001a\u00020\fH\u0016J\"\u0010;\u001a\u00020\t2\u0006\u00109\u001a\u00020\u00032\u0006\u0010:\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016R\u0016\u0010=\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010<R\u0016\u0010@\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010B\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b;\u0010AR\u0014\u0010C\u001a\u00020\f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b'\u0010A\u00a8\u0006J"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/recevier/e;", "Lcom/tencent/mobileqq/friend/handler/recevier/a;", "Lcom/tencent/mobileqq/friend/handler/FriendHandler;", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "response", "", "data", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, tl.h.F, "", "key", "i", "Lfriendlist/FriendInfo;", "selfInfoResp", "t", "Ljava/util/ArrayList;", "Lfriendlist/GroupInfo;", "Lkotlin/collections/ArrayList;", "groupListResp", ReportConstant.COSTREPORT_PREFIX, "friendRespList", "Lfriendlist/FriendListSubSrvRspCode;", "stSubSrvRspCode", "", "timestamp", "", "isComplete", "Lcom/tencent/mobileqq/data/Friends;", "g", "friendResp", "isFriendRemarkToggleOpen", "Lcom/tencent/mobileqq/friend/api/impl/FriendDataServiceImpl;", "friendService", "j", "Lcom/tencent/mobileqq/friend/data/a;", "extRspData", "f", "isSuccess", "k", "", "talCount", "errCode", DomainData.DOMAIN_NAME, "ntFriendListSeq", "p", "totalCount", "fromIndex", "resendCount", "o", "l", "friendRsp", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "c", "req", "res", "e", "I", "mRequestFailedCount", "d", "J", "mRequestFailedTimestamp", "Ljava/lang/String;", "HAS_SHELF_QQ_FRIEND", "SEPARATOR", "Lcom/tencent/common/app/AppInterface;", "appRuntime", "handler", "<init>", "(Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/friend/handler/FriendHandler;)V", "a", "IMCore_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class e extends a<FriendHandler> {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int mRequestFailedCount;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private long mRequestFailedTimestamp;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String HAS_SHELF_QQ_FRIEND;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String SEPARATOR;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/friend/handler/recevier/e$a;", "", "", "QQ_8925_FRIEND_REMARK_WITH_FLAG", "Ljava/lang/String;", "", "REMARK_FETCH_SUCCESS", ExifInterface.LATITUDE_SOUTH, "TAG", "<init>", "()V", "IMCore_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.friend.handler.recevier.e$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34858);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(@NotNull AppInterface appRuntime, @NotNull FriendHandler handler) {
        super(appRuntime, handler);
        Intrinsics.checkNotNullParameter(appRuntime, "appRuntime");
        Intrinsics.checkNotNullParameter(handler, "handler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) appRuntime, (Object) handler);
        } else {
            this.HAS_SHELF_QQ_FRIEND = "has_shelf_qq_friend";
            this.SEPARATOR = "_";
        }
    }

    private final void f(ArrayList<FriendInfo> friendRespList, com.tencent.mobileqq.friend.data.a extRspData, long timestamp, boolean isComplete) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        FriendExtensionServiceImpl service = FriendExtensionServiceImpl.getService(b());
        Iterator<FriendInfo> it = friendRespList.iterator();
        while (it.hasNext()) {
            FriendInfo next = it.next();
            String valueOf = String.valueOf(next.friendUin);
            ExtensionInfo extensionInfo = service.getExtensionInfo(valueOf);
            if (extensionInfo == null) {
                extensionInfo = new ExtensionInfo();
                extensionInfo.uin = valueOf;
            }
            extensionInfo.timestamp = timestamp;
            arrayList2.add(new Pair(extensionInfo, next));
            arrayList.add(extensionInfo);
        }
        Iterator<BaseFriendProcessor> it5 = d().F2().iterator();
        while (it5.hasNext()) {
            it5.next().onBatchUpdateExtensionInfo(arrayList2, extRspData, timestamp, isComplete);
        }
        service.saveExtensionInfoList(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [int, boolean] */
    /* JADX WARN: Type inference failed for: r9v3 */
    private final ArrayList<Friends> g(ArrayList<FriendInfo> friendRespList, FriendListSubSrvRspCode stSubSrvRspCode, long timestamp, boolean isComplete) {
        ArrayList<Friends> arrayList = new ArrayList<>();
        ArrayList arrayList2 = new ArrayList();
        FriendDataServiceImpl friendService = FriendDataServiceImpl.getService(b());
        ?? r95 = 0;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_8925_friend_remark_with_flag", false);
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendListReceiver", 2, "batchUpdateFriendInfo| timestamp: " + timestamp + ", isComplete: " + isComplete + " , currentThread:" + Thread.currentThread().getName() + "isFriendRemarkToggleOpen: " + isSwitchOn);
            if (stSubSrvRspCode != null) {
                QLog.d("IMCore.friend.FriendListReceiver", 2, "wGetRemarkRspCode: " + ((int) stSubSrvRspCode.wGetRemarkRspCode));
            }
        }
        Iterator<FriendInfo> it = friendRespList.iterator();
        while (it.hasNext()) {
            FriendInfo friendResp = it.next();
            Friends friends = new Friends();
            friends.uin = String.valueOf(friendResp.friendUin);
            friends.name = friendResp.nick;
            Intrinsics.checkNotNullExpressionValue(friendResp, "friendResp");
            Intrinsics.checkNotNullExpressionValue(friendService, "friendService");
            friends.remark = j(friendResp, stSubSrvRspCode, isSwitchOn, friendService);
            friends.groupid = friendResp.groupId;
            friends.cSpecialFlag = friendResp.cSpecialFlag;
            friends.detalStatusFlag = friendResp.detalStatusFlag;
            friends.datetime = timestamp;
            friends.alias = friendResp.sShowName;
            friends.abilityBits = friendResp.uAbiFlag;
            friends.eNetwork = friendResp.eNetworkType;
            friends.netTypeIconId = friendResp.eIconType;
            friends.strTermDesc = friendResp.strTermDesc;
            friends.iTermType = friendResp.iTermType;
            friends.gender = friendResp.cSex;
            friends.setShieldFlag(r95);
            friends.setIsBlackFlag(r95);
            friends.setIsBlackedFlag(r95);
            friends.robotType = friendResp.uRobotType;
            friends.robotVersion = friendResp.uRobotVersion;
            Friends friend = friendService.getFriend(friends.uin, true, true);
            if (friend != null) {
                byte b16 = friend.gathtertype;
                if (b16 == 1) {
                    friends.gathtertype = (byte) 1;
                } else if (b16 == 2) {
                    friends.gathtertype = (byte) 2;
                }
                friends.age = friend.age;
                friends.smartRemark = friend.smartRemark;
                friends.gender = friend.gender;
                friends.recommReason = friend.recommReason;
            }
            arrayList2.add(new Pair(friends, friendResp));
            arrayList.add(friends);
            r95 = 0;
        }
        Iterator<BaseFriendProcessor> it5 = ((FriendHandler) d()).F2().iterator();
        while (it5.hasNext()) {
            it5.next().onBatchUpdateFriendInfo(arrayList2, timestamp, isComplete);
        }
        friendService.saveFriendList(arrayList, isComplete, timestamp);
        return arrayList;
    }

    private final void h() {
        MMKVOptionEntity from = QMMKV.from(b().getApplicationContext(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(appRuntime.applicat\u2026t, QMMKVFile.FILE_COMMON)");
        String i3 = i(this.HAS_SHELF_QQ_FRIEND);
        if (from.decodeBool(i3, false)) {
            QLog.i("IMCore.friend.FriendListReceiver", 1, "hasShelfQQFriend changed uinFlag");
            from.encodeBool(i3, false);
        } else {
            QLog.i("IMCore.friend.FriendListReceiver", 1, "no need changed uinFlag");
        }
    }

    private final String i(String key) {
        return key + this.SEPARATOR + ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount();
    }

    private final String j(FriendInfo friendResp, FriendListSubSrvRspCode stSubSrvRspCode, boolean isFriendRemarkToggleOpen, FriendDataServiceImpl friendService) {
        if (isFriendRemarkToggleOpen && stSubSrvRspCode != null && stSubSrvRspCode.wGetRemarkRspCode != 0) {
            Friends friend = friendService.getFriend(String.valueOf(friendResp.friendUin), true, true);
            if (friend == null) {
                return "";
            }
            return friend.remark;
        }
        return friendResp.remark;
    }

    private final void k(boolean isSuccess, ToServiceMsg request, FromServiceMsg response, Object data) {
        Serializable serializable = request.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.friend.data.FriendListRequestData");
        FriendListRequestData friendListRequestData = (FriendListRequestData) serializable;
        int i3 = request.extraData.getInt(AppConstants.KEY_RESEND_COUNT, 0);
        QLog.d("IMCore.friend.FriendListReceiver", 1, "handleRequestFriendListResult| resultCode: " + response.getResultCode() + ", resendCount: " + i3 + ", isSuccess: " + isSuccess);
        if (response.getResultCode() == 2901 && i3 < 2) {
            request.extraData.putInt(AppConstants.KEY_RESEND_COUNT, i3 + 1);
            d().I2().f(request);
            return;
        }
        d().a3(0L);
        int totalFriendCount = friendListRequestData.getTotalFriendCount();
        int friendStartIndex = friendListRequestData.getFriendStartIndex();
        if (totalFriendCount == 0 && (data instanceof GetFriendListResp)) {
            totalFriendCount = ((GetFriendListResp) data).totoal_friend_count;
        }
        o(isSuccess, totalFriendCount, friendStartIndex, response.getResultCode(), i3);
        if (isSuccess) {
            p(friendListRequestData.getNtFriendListSeq());
            FriendHandler d16 = d();
            Boolean bool = Boolean.TRUE;
            d16.notifyUI(1, true, bool);
            d().notifyUI(95, true, new Boolean[]{bool, null});
            return;
        }
        d().notifyUI(1, false, null);
        d().notifyUI(95, false, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x008d A[LOOP:0: B:20:0x0087->B:22:0x008d, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void l(ToServiceMsg request, FromServiceMsg response, Object data) {
        FriendInfo friendResp;
        Iterator<BaseFriendProcessor> it;
        boolean z16;
        if (response.isSuccess() && (data instanceof GetFriendListResp)) {
            GetFriendListResp getFriendListResp = (GetFriendListResp) data;
            if (getFriendListResp.result != 1) {
                if (getFriendListResp.vecFriendInfo.isEmpty()) {
                    ArrayList<FriendInfo> arrayList = getFriendListResp.vecRobots;
                    if (arrayList != null && !arrayList.isEmpty()) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (!z16) {
                        friendResp = getFriendListResp.vecRobots.get(0);
                        com.tencent.mobileqq.friend.data.a aVar = new com.tencent.mobileqq.friend.data.a(getFriendListResp);
                        String valueOf = String.valueOf(friendResp.friendUin);
                        byte b16 = friendResp.groupId;
                        Intrinsics.checkNotNullExpressionValue(friendResp, "friendResp");
                        FriendListSubSrvRspCode friendListSubSrvRspCode = getFriendListResp.stSubSrvRspCode;
                        Intrinsics.checkNotNullExpressionValue(friendListSubSrvRspCode, "data.stSubSrvRspCode");
                        r(friendResp, friendListSubSrvRspCode);
                        q(friendResp, aVar);
                        if (!d().M2()) {
                            d().notifyUI(1, true, Boolean.TRUE);
                        }
                        it = d().F2().iterator();
                        while (it.hasNext()) {
                            it.next().onGetFriendInfoFinish(valueOf);
                        }
                        if (!QLog.isColorLevel()) {
                            QLog.d("IMCore.friend.FriendListReceiver", 2, "receiveFriendInfoResponse| friendUin: " + valueOf + ", groundId: " + ((int) b16));
                            return;
                        }
                        return;
                    }
                }
                friendResp = getFriendListResp.vecFriendInfo.get(0);
                com.tencent.mobileqq.friend.data.a aVar2 = new com.tencent.mobileqq.friend.data.a(getFriendListResp);
                String valueOf2 = String.valueOf(friendResp.friendUin);
                byte b162 = friendResp.groupId;
                Intrinsics.checkNotNullExpressionValue(friendResp, "friendResp");
                FriendListSubSrvRspCode friendListSubSrvRspCode2 = getFriendListResp.stSubSrvRspCode;
                Intrinsics.checkNotNullExpressionValue(friendListSubSrvRspCode2, "data.stSubSrvRspCode");
                r(friendResp, friendListSubSrvRspCode2);
                q(friendResp, aVar2);
                if (!d().M2()) {
                }
                it = d().F2().iterator();
                while (it.hasNext()) {
                }
                if (!QLog.isColorLevel()) {
                }
            }
        }
        int i3 = request.extraData.getInt(AppConstants.KEY_RESEND_COUNT, 0);
        QLog.e("IMCore.friend.FriendListReceiver", 1, "receiveFriendInfoResponse| failed resultCode: " + response.getResultCode() + ", resendCount: " + i3);
        if (response.getResultCode() == 2901 && i3 < 2) {
            request.extraData.putInt(AppConstants.KEY_RESEND_COUNT, i3 + 1);
            d().I2().f(request);
        } else {
            d().notifyUI(1, false, null);
            d().notifyUI(95, false, null);
        }
    }

    private final void m(ToServiceMsg request, FromServiceMsg response, Object data) {
        boolean z16;
        long j3;
        Serializable serializable = request.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
        Intrinsics.checkNotNull(serializable, "null cannot be cast to non-null type com.tencent.mobileqq.friend.data.FriendListRequestData");
        FriendListRequestData friendListRequestData = (FriendListRequestData) serializable;
        if (response.isSuccess() && (data instanceof GetFriendListResp)) {
            GetFriendListResp getFriendListResp = (GetFriendListResp) data;
            if (getFriendListResp.result != 1) {
                n(getFriendListResp.totoal_friend_count, response.getResultCode());
                long timeStamp = friendListRequestData.getTimeStamp();
                short s16 = getFriendListResp.startIndex;
                short s17 = getFriendListResp.friend_count;
                short s18 = getFriendListResp.totoal_friend_count;
                int i3 = s16 + s17;
                if (i3 >= s18) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                ArrayList<String> uinList = friendListRequestData.getUinList();
                ArrayList<FriendInfo> arrayList = new ArrayList<>();
                ArrayList<FriendInfo> arrayList2 = getFriendListResp.vecFriendInfo;
                if (arrayList2 != null) {
                    arrayList.addAll(arrayList2);
                }
                if (getFriendListResp.vecRobots != null) {
                    StringBuilder sb5 = new StringBuilder();
                    j3 = timeStamp;
                    sb5.append("receiveFriendListResponse robot size=");
                    sb5.append(getFriendListResp.vecRobots.size());
                    QLog.d("IMCore.friend.FriendListReceiver", 1, sb5.toString());
                    arrayList.addAll(getFriendListResp.vecRobots);
                } else {
                    j3 = timeStamp;
                }
                for (Iterator<FriendInfo> it = arrayList.iterator(); it.hasNext(); it = it) {
                    uinList.add(String.valueOf(it.next().friendUin));
                }
                com.tencent.mobileqq.friend.data.a aVar = new com.tencent.mobileqq.friend.data.a(getFriendListResp);
                d().G2().b(getFriendListResp.cShowPcIcon);
                if (s16 == 0) {
                    j3 = System.currentTimeMillis();
                    t(getFriendListResp.stSelfInfo);
                }
                QLog.i("IMCore.friend.FriendListReceiver", 1, "receiveFriendListResponse startIndex " + ((int) s16));
                s(getFriendListResp.vecGroupInfo);
                FriendListSubSrvRspCode friendListSubSrvRspCode = getFriendListResp.stSubSrvRspCode;
                Intrinsics.checkNotNullExpressionValue(friendListSubSrvRspCode, "data.stSubSrvRspCode");
                long j16 = j3;
                boolean z17 = z16;
                g(arrayList, friendListSubSrvRspCode, j16, z17);
                f(arrayList, aVar, j16, z17);
                QLog.i("IMCore.friend.FriendListReceiver", 1, "receiveFriendListResponse| timestamp: " + j16 + ", startIndex: " + ((int) s16) + ", friendCount: " + ((int) s17) + ", totalFriendCount: " + ((int) s18) + ", isComplete: " + z17 + ", uinListSize: " + uinList.size());
                if (!z17) {
                    FriendListRequestData friendListRequestData2 = new FriendListRequestData(null, false, 0, 0, 0, 0, 0L, 0, 0, false, 0, 2047, null);
                    friendListRequestData2.setUinList(uinList);
                    friendListRequestData2.setFriendStartIndex(i3);
                    friendListRequestData2.setFriendCount(200);
                    friendListRequestData2.setTimeStamp(j16);
                    friendListRequestData2.setTotalFriendCount(s18);
                    friendListRequestData2.setPullRefresh(friendListRequestData.isPullRefresh());
                    friendListRequestData2.setShowTermType(1);
                    friendListRequestData2.setNtFriendListSeq(friendListRequestData.getNtFriendListSeq());
                    d().T2(friendListRequestData2, false);
                    return;
                }
                h();
                k(true, request, response, data);
                Iterator<BaseFriendProcessor> it5 = d().F2().iterator();
                while (it5.hasNext()) {
                    it5.next().onGetFriendListFinish(friendListRequestData.isPullRefresh(), uinList, aVar);
                }
                return;
            }
        }
        k(false, request, response, data);
    }

    private final void n(int talCount, int errCode) {
        Iterator<BaseFriendProcessor> it = d().F2().iterator();
        while (it.hasNext()) {
            it.next().onReportFriendListNetLoad(d().H2(), System.currentTimeMillis(), talCount, errCode);
        }
    }

    private final void o(boolean isSuccess, int totalCount, int fromIndex, int errCode, int resendCount) {
        String str;
        HashMap<String, String> hashMap = new HashMap<>();
        long currentTimeMillis = System.currentTimeMillis() - d().H2();
        if (isSuccess) {
            str = "1";
        } else {
            str = "0";
        }
        hashMap.put("reqGetStatus", str);
        hashMap.put("friendListCount", String.valueOf(totalCount));
        hashMap.put("fromIndex", String.valueOf(fromIndex));
        hashMap.put("reqCountEveryPage", "200");
        hashMap.put("retryCount", String.valueOf(resendCount));
        hashMap.put("totalConsume", String.valueOf(currentTimeMillis));
        hashMap.put("errorCode", String.valueOf(errCode));
        StatisticCollector.getInstance(b().getApplicationContext()).collectPerformance(null, StatisticCollector.FRIENDLIST_RESULT, true, 0L, 0L, hashMap, null);
        if (isSuccess) {
            if (this.mRequestFailedCount > 0 && this.mRequestFailedTimestamp > 0) {
                long currentTimeMillis2 = System.currentTimeMillis() - this.mRequestFailedTimestamp;
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("mFriendListFailedCount", String.valueOf(this.mRequestFailedCount));
                hashMap2.put("failedTime", String.valueOf(currentTimeMillis2));
                StatisticCollector.getInstance(b().getApplicationContext()).collectPerformance(null, StatisticCollector.FRIENDLIST_FAILED_DETAIL, true, 0L, 0L, hashMap2, null);
                this.mRequestFailedCount = 0;
                this.mRequestFailedTimestamp = 0L;
                return;
            }
            return;
        }
        this.mRequestFailedCount++;
        if (this.mRequestFailedTimestamp == 0) {
            this.mRequestFailedTimestamp = d().H2();
        }
    }

    private final void p(int ntFriendListSeq) {
        if (ntFriendListSeq != 0) {
            com.tencent.mobileqq.friend.utils.b.d().j(ntFriendListSeq);
        }
    }

    private final void q(FriendInfo friendResp, com.tencent.mobileqq.friend.data.a extRspData) {
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendListReceiver", 2, "updateExtensionInfo");
        }
        String valueOf = String.valueOf(friendResp.friendUin);
        FriendExtensionServiceImpl service = FriendExtensionServiceImpl.getService(b());
        ExtensionInfo extensionInfo = service.getExtensionInfo(valueOf);
        if (extensionInfo == null) {
            extensionInfo = new ExtensionInfo();
            extensionInfo.uin = valueOf;
        }
        extensionInfo.timestamp = System.currentTimeMillis();
        Iterator<BaseFriendProcessor> it = d().F2().iterator();
        while (it.hasNext()) {
            it.next().onUpdateExtensionInfo(extensionInfo, friendResp, extRspData);
        }
        service.saveExtensionInfo(extensionInfo);
    }

    private final void r(FriendInfo friendRsp, FriendListSubSrvRspCode stSubSrvRspCode) {
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendListReceiver", 2, "updateFriendInfo");
        }
        Friends friends = new Friends();
        FriendDataServiceImpl friendService = FriendDataServiceImpl.getService(b());
        friends.name = friendRsp.nick;
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qq_8925_friend_remark_with_flag", false);
        Intrinsics.checkNotNullExpressionValue(friendService, "friendService");
        friends.remark = j(friendRsp, stSubSrvRspCode, isSwitchOn, friendService);
        friends.uin = String.valueOf(friendRsp.friendUin);
        friends.groupid = friendRsp.groupId;
        byte b16 = friendRsp.cSpecialFlag;
        friends.cSpecialFlag = b16;
        if (b16 < 0) {
            QLog.d("IMCore.friend.FriendListReceiver", 1, "cSpecialFlag is 0xff");
            friends.cSpecialFlag = (byte) 0;
        }
        friends.detalStatusFlag = friendRsp.detalStatusFlag;
        friends.alias = friendRsp.sShowName;
        friends.iTermType = friendRsp.iTermType;
        friends.abilityBits = friendRsp.uAbiFlag;
        friends.netTypeIconId = friendRsp.eIconType;
        friends.strTermDesc = friendRsp.strTermDesc;
        friends.gender = friendRsp.cSex;
        friends.setShieldFlag(false);
        friends.setIsBlackFlag(0);
        friends.setIsBlackedFlag(0);
        friends.robotType = friendRsp.uRobotType;
        friends.robotVersion = friendRsp.uRobotVersion;
        Friends friend = friendService.getFriend(friends.uin);
        if (friend != null) {
            friends.datetime = friend.datetime;
            friends.lastLoginType = friend.lastLoginType;
            byte b17 = friend.gathtertype;
            if (b17 == 1) {
                friends.gathtertype = (byte) 1;
            } else if (b17 == 2) {
                friends.gathtertype = (byte) 2;
            }
            friends.age = friend.age;
            friends.smartRemark = friend.smartRemark;
            friends.gender = friend.gender;
            friends.recommReason = friend.recommReason;
        }
        Iterator<BaseFriendProcessor> it = d().F2().iterator();
        while (it.hasNext()) {
            it.next().onUpdateFriendInfo(friends, friendRsp);
        }
        friendService.saveFriend(friends);
    }

    private final void s(ArrayList<GroupInfo> groupListResp) {
        if (groupListResp == null) {
            QLog.e("IMCore.friend.FriendListReceiver", 1, "updateGroupList| groupListResp is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendListReceiver", 2, "updateGroupList");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<GroupInfo> it = groupListResp.iterator();
        while (it.hasNext()) {
            GroupInfo next = it.next();
            Groups groups = new Groups();
            groups.group_id = next.groupId;
            groups.group_name = next.groupname;
            groups.group_friend_count = next.friend_count;
            groups.seqid = next.seqid;
            arrayList.add(groups);
            if (QLog.isColorLevel()) {
                QLog.d("IMCore.friend.FriendListReceiver", 2, "updateGroupList| " + groups);
            }
        }
        FriendDataServiceImpl service = FriendDataServiceImpl.getService(b());
        if (arrayList.size() > 0) {
            service.saveGroupList(arrayList);
        }
    }

    private final void t(FriendInfo selfInfoResp) {
        if (selfInfoResp == null) {
            QLog.e("IMCore.friend.FriendListReceiver", 1, "updateSelfInfo| selfInfoResp is null");
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("IMCore.friend.FriendListReceiver", 2, "updateSelfInfo");
        }
        FriendDataServiceImpl service = FriendDataServiceImpl.getService(b());
        Friends friend = service.getFriend(b().getCurrentAccountUin());
        if (friend == null) {
            friend = new Friends();
        }
        friend.name = selfInfoResp.nick;
        friend.remark = friend.remark;
        friend.uin = String.valueOf(selfInfoResp.friendUin);
        friend.cSpecialFlag = selfInfoResp.cSpecialFlag;
        friend.detalStatusFlag = selfInfoResp.detalStatusFlag;
        friend.alias = selfInfoResp.sShowName;
        friend.abilityBits = selfInfoResp.uAbiFlag;
        friend.eNetwork = selfInfoResp.eNetworkType;
        friend.groupid = selfInfoResp.groupId;
        Iterator<BaseFriendProcessor> it = d().F2().iterator();
        while (it.hasNext()) {
            it.next().onUpdateSelfInfo(friend, selfInfoResp);
        }
        service.saveFriend(friend);
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    @NotNull
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "friendlist.getFriendGroupList";
    }

    @Override // com.tencent.mobileqq.friend.handler.recevier.a
    public void e(@NotNull ToServiceMsg req, @NotNull FromServiceMsg res, @Nullable Object data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, req, res, data);
            return;
        }
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(res, "res");
        Serializable serializable = req.extraData.getSerializable(Reflection.getOrCreateKotlinClass(FriendListRequestData.class).getSimpleName());
        if (serializable instanceof FriendListRequestData) {
            if (((FriendListRequestData) serializable).isRequestSingle()) {
                l(req, res, data);
                return;
            } else {
                m(req, res, data);
                return;
            }
        }
        QLog.e("IMCore.friend.FriendListReceiver", 1, "GET_FRIEND_GROUP_LIST| requestData is not FriendListRequestData");
    }
}
