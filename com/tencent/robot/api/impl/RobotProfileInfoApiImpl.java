package com.tencent.robot.api.impl;

import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfile;
import com.tencent.qqnt.kernel.nativeinterface.GroupRobotProfileReq;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotBaseInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotCoreInfo;
import com.tencent.qqnt.kernel.nativeinterface.RobotProfileFetchType;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.robot.api.IRobotProfileInfoApi;
import com.tencent.robot.api.impl.RobotProfileInfoApiImpl$mKernelMsgListener$2;
import com.tencent.robot.profile.utils.RobotProfileUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000C\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\t*\u0001\"\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\"\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J$\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\"\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u0017\u001a\u00020\bH\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000e\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0004H\u0016R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0018\u0010 \u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010'\u001a\u00020\"8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/robot/api/impl/RobotProfileInfoApiImpl;", "Lcom/tencent/robot/api/IRobotProfileInfoApi;", "Lcom/tencent/robot/api/impl/q;", "internalArgs", "", "fetchRobotProfileInfoInternal", "registerKickListener", "unRegisterKickListener", "", "uin", "Lcom/tencent/qqnt/kernel/nativeinterface/RobotCoreInfo;", "getRobotCoreInfoFromRecord", "recordRobotFriendsFromCache", "clearRobotFriendsRecord", "robotUin", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupRobotProfileCallback;", "callback", "fetchRobotProfileInfo", "fetchRobotProfileInfoFromServer", "getRobotProfileInfoFromLocal", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "getRecentRobotProfileCache", "getBKN", "getRobotCoreInfoFromFriendsCache", "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "mAccountUin", "Ljava/lang/String;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mAllRobotFriendsList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "mRecentRobotProfileCache", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupRobotProfile;", "com/tencent/robot/api/impl/RobotProfileInfoApiImpl$mKernelMsgListener$2$a", "mKernelMsgListener$delegate", "Lkotlin/Lazy;", "getMKernelMsgListener", "()Lcom/tencent/robot/api/impl/RobotProfileInfoApiImpl$mKernelMsgListener$2$a;", "mKernelMsgListener", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotProfileInfoApiImpl implements IRobotProfileInfoApi {

    @Nullable
    private volatile String mAccountUin;

    @NotNull
    private CopyOnWriteArrayList<RobotCoreInfo> mAllRobotFriendsList = new CopyOnWriteArrayList<>();

    /* renamed from: mKernelMsgListener$delegate, reason: from kotlin metadata */
    @NotNull
    private final Lazy mKernelMsgListener;

    @Nullable
    private volatile GroupRobotProfile mRecentRobotProfileCache;

    public RobotProfileInfoApiImpl() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotProfileInfoApiImpl$mKernelMsgListener$2.a>() { // from class: com.tencent.robot.api.impl.RobotProfileInfoApiImpl$mKernelMsgListener$2

            @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/robot/api/impl/RobotProfileInfoApiImpl$mKernelMsgListener$2$a", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernel/nativeinterface/KickedInfo;", "kickedInfo", "", "onKickedOffLine", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes25.dex */
            public static final class a implements IKernelMsgListener {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ RobotProfileInfoApiImpl f367414d;

                a(RobotProfileInfoApiImpl robotProfileInfoApiImpl) {
                    this.f367414d = robotProfileInfoApiImpl;
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onAddSendMsg(MsgRecord msgRecord) {
                    ax.a(this, msgRecord);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onContactUnreadCntUpdate(HashMap hashMap) {
                    ax.b(this, hashMap);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onCustomWithdrawConfigUpdate(CustomWithdrawConfig customWithdrawConfig) {
                    ax.c(this, customWithdrawConfig);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onDraftUpdate(Contact contact, ArrayList arrayList, long j3) {
                    ax.d(this, contact, arrayList, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onEmojiDownloadComplete(EmojiNotifyInfo emojiNotifyInfo) {
                    ax.e(this, emojiNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onEmojiResourceUpdate(EmojiResourceInfo emojiResourceInfo) {
                    ax.f(this, emojiResourceInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onFileMsgCome(ArrayList arrayList) {
                    ax.g(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGrabPasswordRedBag(int i3, String str, int i16, RecvdOrder recvdOrder, MsgRecord msgRecord) {
                    ax.h(this, i3, str, i16, recvdOrder, msgRecord);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupFileInfoAdd(GroupItem groupItem) {
                    ax.i(this, groupItem);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupFileInfoUpdate(GroupFileListResult groupFileListResult) {
                    ax.j(this, groupFileListResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupTransferInfoAdd(GroupItem groupItem) {
                    ax.k(this, groupItem);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onGroupTransferInfoUpdate(GroupFileListResult groupFileListResult) {
                    ax.l(this, groupFileListResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onHitCsRelatedEmojiResult(DownloadRelateEmojiResultInfo downloadRelateEmojiResultInfo) {
                    ax.m(this, downloadRelateEmojiResultInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onHitEmojiKeywordResult(HitRelatedEmojiWordsResult hitRelatedEmojiWordsResult) {
                    ax.n(this, hitRelatedEmojiWordsResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onHitRelatedEmojiResult(RelatedWordEmojiInfo relatedWordEmojiInfo) {
                    ax.o(this, relatedWordEmojiInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onImportOldDbProgressUpdate(ImportOldDbMsgNotifyInfo importOldDbMsgNotifyInfo) {
                    ax.p(this, importOldDbMsgNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onInputStatusPush(InputStatusInfo inputStatusInfo) {
                    ax.q(this, inputStatusInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public void onKickedOffLine(@Nullable KickedInfo kickedInfo) {
                    this.f367414d.recordRobotFriendsFromCache();
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onLineDev(ArrayList arrayList) {
                    ax.s(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onLogLevelChanged(long j3) {
                    ax.t(this, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMiscDataChanged(ArrayList arrayList) {
                    ax.u(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgBoxChanged(ArrayList arrayList) {
                    ax.v(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgDelete(Contact contact, ArrayList arrayList) {
                    ax.w(this, contact, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgInfoListAdd(ArrayList arrayList) {
                    ax.x(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgInfoListUpdate(ArrayList arrayList) {
                    ax.y(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgQRCodeStatusChanged(int i3) {
                    ax.z(this, i3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgRecall(int i3, String str, long j3) {
                    ax.A(this, i3, str, j3);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgSecurityNotify(MsgRecord msgRecord) {
                    ax.B(this, msgRecord);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgSettingUpdate(MsgSetting msgSetting) {
                    ax.C(this, msgSetting);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onMsgWithRichLinkInfoUpdate(ArrayList arrayList) {
                    ax.D(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtFirstViewMsgSyncEnd() {
                    ax.E(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtMsgSyncContactUnread() {
                    ax.F(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtMsgSyncEnd() {
                    ax.G(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onNtMsgSyncStart() {
                    ax.H(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvMsg(ArrayList arrayList) {
                    ax.I(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvMsgSvrRspTransInfo(long j3, Contact contact, int i3, int i16, String str, byte[] bArr) {
                    ax.J(this, j3, contact, i3, i16, str, bArr);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvOnlineFileMsg(ArrayList arrayList) {
                    ax.K(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRecvSysMsg(ArrayList arrayList) {
                    ax.L(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRedTouchChanged() {
                    ax.M(this);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRichMediaDownloadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
                    ax.N(this, fileTransNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRichMediaProgerssUpdate(FileTransNotifyInfo fileTransNotifyInfo) {
                    ax.O(this, fileTransNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onRichMediaUploadComplete(FileTransNotifyInfo fileTransNotifyInfo) {
                    ax.P(this, fileTransNotifyInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onSearchGroupFileInfoUpdate(SearchGroupFileResult searchGroupFileResult) {
                    ax.Q(this, searchGroupFileResult);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onSendMsgError(long j3, Contact contact, int i3, String str) {
                    ax.R(this, j3, contact, i3, str);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onSysMsgNotification(int i3, long j3, long j16, boolean z16, ArrayList arrayList) {
                    ax.S(this, i3, j3, j16, z16, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onTempChatInfoUpdate(TempChatInfo tempChatInfo) {
                    ax.T(this, tempChatInfo);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserChannelTabStatusChanged(boolean z16) {
                    ax.U(this, z16);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserOnlineStatusChanged(boolean z16) {
                    ax.V(this, z16);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserSecQualityChanged(QueryUserSecQualityRsp queryUserSecQualityRsp) {
                    ax.W(this, queryUserSecQualityRsp);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onUserTabStatusChanged(ArrayList arrayList) {
                    ax.X(this, arrayList);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onlineStatusBigIconDownloadPush(int i3, long j3, String str) {
                    ax.Y(this, i3, j3, str);
                }

                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
                public /* synthetic */ void onlineStatusSmallIconDownloadPush(int i3, long j3, String str) {
                    ax.Z(this, i3, j3, str);
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                return new a(RobotProfileInfoApiImpl.this);
            }
        });
        this.mKernelMsgListener = lazy;
    }

    private final void clearRobotFriendsRecord() {
        this.mAccountUin = null;
        if (!this.mAllRobotFriendsList.isEmpty()) {
            this.mAllRobotFriendsList.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchRobotProfileInfo$lambda$0(RobotProfileInternalArgs internalArgs, RobotProfileInfoApiImpl this$0) {
        Intrinsics.checkNotNullParameter(internalArgs, "$internalArgs");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        internalArgs.f(RobotProfileUtils.f368193a.h());
        this$0.fetchRobotProfileInfoInternal(internalArgs);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchRobotProfileInfoFromServer$lambda$1(RobotProfileInternalArgs internalArgs, RobotProfileInfoApiImpl this$0) {
        Intrinsics.checkNotNullParameter(internalArgs, "$internalArgs");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        internalArgs.f(RobotProfileUtils.f368193a.h());
        this$0.fetchRobotProfileInfoInternal(internalArgs);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void fetchRobotProfileInfoInternal(final RobotProfileInternalArgs internalArgs) {
        Long longOrNull;
        long j3;
        Long longOrNull2;
        GroupRobotProfileReq groupRobotProfileReq = new GroupRobotProfileReq();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(internalArgs.getRobotUin());
        long j16 = 0;
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        groupRobotProfileReq.robotUin = j3;
        String troopUin = internalArgs.getTroopUin();
        if (troopUin != null && longOrNull2 != null) {
            j16 = longOrNull2.longValue();
        }
        groupRobotProfileReq.groupId = j16;
        groupRobotProfileReq.bkn = internalArgs.getBkn();
        groupRobotProfileReq.fetchType = internalArgs.getFetchType();
        ac a16 = u64.h.a();
        if (a16 != null) {
            a16.fetchGroupRobotProfileWithReq(groupRobotProfileReq, new IGetGroupRobotProfileCallback() { // from class: com.tencent.robot.api.impl.o
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupRobotProfileCallback
                public final void onResult(int i3, String str, GroupRobotProfile groupRobotProfile) {
                    RobotProfileInfoApiImpl.fetchRobotProfileInfoInternal$lambda$4(RobotProfileInternalArgs.this, this, i3, str, groupRobotProfile);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void fetchRobotProfileInfoInternal$lambda$4(RobotProfileInternalArgs internalArgs, RobotProfileInfoApiImpl this$0, int i3, String str, GroupRobotProfile groupRobotProfile) {
        Intrinsics.checkNotNullParameter(internalArgs, "$internalArgs");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IGetGroupRobotProfileCallback callback = internalArgs.getCallback();
        if (callback != null) {
            callback.onResult(i3, str, groupRobotProfile);
        }
        if (i3 == 0 && groupRobotProfile != null && groupRobotProfile.robotData.robotUin != 0) {
            this$0.mRecentRobotProfileCache = groupRobotProfile;
        }
    }

    private final RobotProfileInfoApiImpl$mKernelMsgListener$2.a getMKernelMsgListener() {
        return (RobotProfileInfoApiImpl$mKernelMsgListener$2.a) this.mKernelMsgListener.getValue();
    }

    private final RobotCoreInfo getRobotCoreInfoFromRecord(String uin) {
        String str;
        String str2;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Object obj = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        if (!Intrinsics.areEqual(str, this.mAccountUin)) {
            return null;
        }
        Iterator<T> it = this.mAllRobotFriendsList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            RobotCoreInfo robotCoreInfo = (RobotCoreInfo) next;
            if (robotCoreInfo != null) {
                str2 = Long.valueOf(robotCoreInfo.robotUin).toString();
            } else {
                str2 = null;
            }
            if (Intrinsics.areEqual(str2, uin)) {
                obj = next;
                break;
            }
        }
        return (RobotCoreInfo) obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void recordRobotFriendsFromCache() {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.tencent.robot.api.impl.n
            @Override // java.lang.Runnable
            public final void run() {
                RobotProfileInfoApiImpl.recordRobotFriendsFromCache$lambda$6(RobotProfileInfoApiImpl.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void recordRobotFriendsFromCache$lambda$6(RobotProfileInfoApiImpl this$0) {
        String str;
        boolean z16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        ArrayList<RobotCoreInfo> arrayList = null;
        if (peekAppRuntime != null) {
            str = peekAppRuntime.getCurrentAccountUin();
        } else {
            str = null;
        }
        this$0.mAccountUin = str;
        ac a16 = u64.h.a();
        if (a16 != null) {
            arrayList = a16.getAllRobotFriendsFromCache();
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            this$0.mAllRobotFriendsList.clear();
            this$0.mAllRobotFriendsList.addAll(arrayList);
        } else {
            this$0.mAllRobotFriendsList.clear();
        }
    }

    private final void registerKickListener() {
        IRuntimeService iRuntimeService;
        w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.addMsgListener(getMKernelMsgListener());
        }
    }

    private final void unRegisterKickListener() {
        IRuntimeService iRuntimeService;
        w msgService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService != null && (msgService = iKernelService.getMsgService()) != null) {
            msgService.removeMsgListener(getMKernelMsgListener());
        }
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    public void fetchRobotProfileInfo(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final RobotProfileInternalArgs robotProfileInternalArgs = new RobotProfileInternalArgs(robotUin, troopUin, RobotProfileFetchType.KLOCALANDSERVER, "", callback);
        if (RFWThreadManager.isMainThread()) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.robot.api.impl.p
                @Override // java.lang.Runnable
                public final void run() {
                    RobotProfileInfoApiImpl.fetchRobotProfileInfo$lambda$0(RobotProfileInternalArgs.this, this);
                }
            });
        } else {
            robotProfileInternalArgs.f(RobotProfileUtils.f368193a.h());
            fetchRobotProfileInfoInternal(robotProfileInternalArgs);
        }
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    public void fetchRobotProfileInfoFromServer(@NotNull String robotUin, @Nullable String troopUin, @Nullable IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        final RobotProfileInternalArgs robotProfileInternalArgs = new RobotProfileInternalArgs(robotUin, troopUin, RobotProfileFetchType.KSERVER, "", callback);
        if (RFWThreadManager.isMainThread()) {
            RFWThreadManager.getInstance().execOnNetThread(new Runnable() { // from class: com.tencent.robot.api.impl.m
                @Override // java.lang.Runnable
                public final void run() {
                    RobotProfileInfoApiImpl.fetchRobotProfileInfoFromServer$lambda$1(RobotProfileInternalArgs.this, this);
                }
            });
        } else {
            robotProfileInternalArgs.f(RobotProfileUtils.f368193a.h());
            fetchRobotProfileInfoInternal(robotProfileInternalArgs);
        }
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    @NotNull
    public String getBKN() {
        return RobotProfileUtils.f368193a.h();
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    @Nullable
    public GroupRobotProfile getRecentRobotProfileCache(@NotNull String robotUin) {
        String str;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        GroupRobotProfile groupRobotProfile = this.mRecentRobotProfileCache;
        if (groupRobotProfile != null) {
            RobotBaseInfo robotBaseInfo = groupRobotProfile.robotData;
            if (robotBaseInfo != null) {
                str = Long.valueOf(robotBaseInfo.robotUin).toString();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(robotUin, str)) {
                return groupRobotProfile;
            }
        }
        return null;
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    @Nullable
    public RobotCoreInfo getRobotCoreInfoFromFriendsCache(@NotNull String robotUin) {
        RobotCoreInfo robotCoreInfo;
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        ac a16 = u64.h.a();
        if (a16 != null) {
            robotCoreInfo = a16.getRobotFriendsFromCacheWithUin(Util.toLongOrDefault(robotUin, 0L));
        } else {
            robotCoreInfo = null;
        }
        if (robotCoreInfo != null) {
            if (this.mAccountUin != null) {
                clearRobotFriendsRecord();
                return robotCoreInfo;
            }
            return robotCoreInfo;
        }
        return getRobotCoreInfoFromRecord(robotUin);
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    public void getRobotProfileInfoFromLocal(@NotNull String robotUin, @Nullable String troopUin, @NotNull IGetGroupRobotProfileCallback callback) {
        Intrinsics.checkNotNullParameter(robotUin, "robotUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        fetchRobotProfileInfoInternal(new RobotProfileInternalArgs(robotUin, troopUin, RobotProfileFetchType.KLOCAL, "", callback));
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    public void onCreate() {
        registerKickListener();
    }

    @Override // com.tencent.robot.api.IRobotProfileInfoApi
    public void onDestroy() {
        unRegisterKickListener();
        this.mRecentRobotProfileCache = null;
    }
}
