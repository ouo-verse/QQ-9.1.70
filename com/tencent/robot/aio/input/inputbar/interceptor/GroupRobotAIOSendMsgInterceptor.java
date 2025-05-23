package com.tencent.robot.aio.input.inputbar.interceptor;

import android.os.Bundle;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.interceptor.sendmsg.a;
import com.tencent.qqnt.aio.msg.api.IAIOMsgItemApi;
import com.tencent.qqnt.graytips.api.INtGrayTipApi;
import com.tencent.qqnt.graytips.local.LocalGrayTip;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.TextElement;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import com.tencent.qqnt.robot.api.IRobotServiceApi;
import com.tencent.qqnt.studymode.api.IStudyModeApi;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.robot.aio.input.inputbar.config.RobotAtConfig;
import com.tencent.robot.aio.input.inputbar.config.RobotAtConfigParser;
import com.tencent.robot.aio.input.inputbar.interceptor.GroupRobotAIOSendMsgInterceptor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0002\u0010\u001cB\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\u0016\u0010\t\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0018\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u001b\u0010\u001e\u001a\u00020\u001a8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/interceptor/GroupRobotAIOSendMsgInterceptor;", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgElement;", "msgElementList", "", "g", "f", "d", "c", "", "robotUin", "e", "Lcom/tencent/aio/data/AIOSession;", "aioSession", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "a", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/c;", "paramWrapper", "Lcom/tencent/qqnt/aio/interceptor/sendmsg/d;", "intercept", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "Lcom/tencent/aio/data/msglist/a;", "msgItem", "interceptResend", "Lcom/tencent/robot/aio/input/inputbar/config/RobotAtConfig;", "Lkotlin/Lazy;", "b", "()Lcom/tencent/robot/aio/input/inputbar/config/RobotAtConfig;", "robotAtConfig", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class GroupRobotAIOSendMsgInterceptor implements com.tencent.qqnt.aio.interceptor.sendmsg.a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy robotAtConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/robot/aio/input/inputbar/interceptor/GroupRobotAIOSendMsgInterceptor$b;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "", "errMsg", "", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/MsgRecord;", "msgRecord", "onAddSendMsg", "", "d", "J", "msgId", "<init>", "(J)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements IKernelMsgListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private final long msgId;

        public b(long j3) {
            this.msgId = j3;
        }

        private final void b(Contact peer, String errMsg) {
            String str = peer.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "peer.peerUid");
            LocalGrayTip.LocalGrayTipBuilder localGrayTipBuilder = new LocalGrayTip.LocalGrayTipBuilder(str, peer.chatType, 2202L, 0, false, false, null, 120, null);
            LocalGrayTip.LocalGrayTipBuilder.i(localGrayTipBuilder, errMsg, 0, 2, null);
            LocalGrayTip m3 = localGrayTipBuilder.m();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                ((INtGrayTipApi) QRoute.api(INtGrayTipApi.class)).addLocalGrayTip(peekAppRuntime, m3, new IAddJsonGrayTipMsgCallback() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.a
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAddJsonGrayTipMsgCallback
                    public final void onResult(int i3, long j3) {
                        GroupRobotAIOSendMsgInterceptor.b.c(i3, j3);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(int i3, long j3) {
            QLog.d("GroupRobotAIOSendMsgInterceptor", 1, "addLocalGrayTip result=" + i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        public void onAddSendMsg(@NotNull MsgRecord msgRecord) {
            Intrinsics.checkNotNullParameter(msgRecord, "msgRecord");
            if (this.msgId == msgRecord.msgId) {
                w e16 = f.e();
                if (e16 != null) {
                    e16.removeMsgListener(this);
                }
                w e17 = f.e();
                if (e17 != null) {
                    long j3 = this.msgId;
                    String str = msgRecord.peerUid;
                    Intrinsics.checkNotNullExpressionValue(str, "msgRecord.peerUid");
                    e17.cancelSendMsg(j3, str, msgRecord.chatType);
                }
                Contact contact = new Contact(msgRecord.chatType, msgRecord.peerUid, msgRecord.guildId);
                String qqStr = HardCodeUtil.qqStr(R.string.f222376dc);
                Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.robot_gro\u2026o_not_support_study_mode)");
                b(contact, qqStr);
            }
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
        public /* synthetic */ void onKickedOffLine(KickedInfo kickedInfo) {
            ax.r(this, kickedInfo);
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

    public GroupRobotAIOSendMsgInterceptor() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<RobotAtConfig>() { // from class: com.tencent.robot.aio.input.inputbar.interceptor.GroupRobotAIOSendMsgInterceptor$robotAtConfig$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final RobotAtConfig invoke() {
                return RobotAtConfigParser.INSTANCE.a();
            }
        });
        this.robotAtConfig = lazy;
    }

    private final Contact a(AIOSession aioSession) {
        return new Contact(aioSession.c().e(), aioSession.c().j(), aioSession.c().f());
    }

    private final RobotAtConfig b() {
        return (RobotAtConfig) this.robotAtConfig.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x008b A[EDGE_INSN: B:39:0x008b->B:40:0x008b BREAK  A[LOOP:2: B:28:0x004a->B:46:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:? A[LOOP:2: B:28:0x004a->B:46:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean c(List<MsgElement> msgElementList) {
        Object obj;
        boolean z16;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = msgElementList.iterator();
        while (true) {
            boolean z17 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            MsgElement msgElement = (MsgElement) next;
            if (msgElement.elementType == 1 && msgElement.textElement != null) {
                z17 = true;
            }
            if (z17) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            TextElement textElement = ((MsgElement) it5.next()).textElement;
            if (textElement != null) {
                arrayList2.add(textElement);
            }
        }
        Iterator it6 = arrayList2.iterator();
        while (true) {
            if (it6.hasNext()) {
                obj = it6.next();
                TextElement textElement2 = (TextElement) obj;
                String uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(textElement2.atNtUid);
                if (textElement2.atType == 2 && ((IRobotServiceApi) QRoute.api(IRobotServiceApi.class)).isRobotUin(uin)) {
                    Intrinsics.checkNotNullExpressionValue(uin, "uin");
                    if (e(uin)) {
                        z16 = true;
                        if (!z16) {
                            break;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            } else {
                obj = null;
                break;
            }
        }
        if (((TextElement) obj) == null) {
            return false;
        }
        return true;
    }

    private final boolean d() {
        return b().getEnable();
    }

    private final boolean e(String robotUin) {
        return !b().getWhiteList().contains(robotUin);
    }

    private final boolean f() {
        return ((IStudyModeApi) QRoute.api(IStudyModeApi.class)).isStudyMode();
    }

    private final boolean g(List<MsgElement> msgElementList) {
        if (msgElementList.isEmpty() || !f() || !d() || !c(msgElementList)) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    @NotNull
    public com.tencent.qqnt.aio.interceptor.sendmsg.d intercept(@NotNull com.tencent.qqnt.aio.interceptor.sendmsg.c paramWrapper) {
        long j3;
        Long j06;
        Intrinsics.checkNotNullParameter(paramWrapper, "paramWrapper");
        if (g(paramWrapper.c().getValue())) {
            Contact a16 = a(paramWrapper.d().a());
            Bundle b16 = paramWrapper.b();
            long j16 = 0;
            if (b16 != null) {
                j3 = b16.getLong("msg_id");
            } else {
                j3 = 0;
            }
            if (j3 == 0) {
                w e16 = f.e();
                if (e16 != null && (j06 = e16.j0(a16.chatType)) != null) {
                    j16 = j06.longValue();
                }
                j3 = j16;
            }
            ArrayList<MsgElement> transformAioMsgToElements = ((IAIOMsgItemApi) QRoute.api(IAIOMsgItemApi.class)).transformAioMsgToElements(paramWrapper.d().b());
            w e17 = f.e();
            if (e17 != null) {
                e17.addMsgListener(new b(j3));
            }
            w e18 = f.e();
            if (e18 != null) {
                e18.o0(j3, a16, transformAioMsgToElements);
            }
            return new com.tencent.qqnt.aio.interceptor.sendmsg.d(true, true);
        }
        return new com.tencent.qqnt.aio.interceptor.sendmsg.d(false, true);
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public boolean interceptResend(@NotNull com.tencent.aio.api.runtime.a aioContext, @NotNull com.tencent.aio.data.msglist.a msgItem) {
        Intrinsics.checkNotNullParameter(aioContext, "aioContext");
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        if (!(msgItem instanceof AIOMsgItem)) {
            return false;
        }
        ArrayList<MsgElement> arrayList = ((AIOMsgItem) msgItem).getMsgRecord().elements;
        Intrinsics.checkNotNullExpressionValue(arrayList, "msgItem.msgRecord.elements");
        boolean g16 = g(arrayList);
        if (g16) {
            QQToastUtil.showQQToast(0, R.string.f222376dc);
            new com.tencent.videocut.utils.dsl.b();
        } else {
            new com.tencent.videocut.utils.dsl.a(g16);
        }
        return g16;
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public void reportAfterKernelSend(boolean z16, long j3) {
        a.C9483a.b(this, z16, j3);
    }

    @Override // com.tencent.qqnt.aio.interceptor.sendmsg.a
    public void reportBeforeKernelSend(boolean z16, long j3) {
        a.C9483a.c(this, z16, j3);
    }
}
