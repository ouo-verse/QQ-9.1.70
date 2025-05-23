package com.tencent.relation.common.nt.api.impl;

import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x11e;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0x76;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xb3;
import com.tencent.imcore.message.ext.codec.decoder.msgType0x210.SubType0xc7;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.CustomWithdrawConfig;
import com.tencent.qqnt.kernel.nativeinterface.DownloadRelateEmojiResultInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.EmojiResourceInfo;
import com.tencent.qqnt.kernel.nativeinterface.FileTransNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupFileListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupItem;
import com.tencent.qqnt.kernel.nativeinterface.HitRelatedEmojiWordsResult;
import com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.ImportOldDbMsgNotifyInfo;
import com.tencent.qqnt.kernel.nativeinterface.InputStatusInfo;
import com.tencent.qqnt.kernel.nativeinterface.KickedInfo;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernel.nativeinterface.MsgSetting;
import com.tencent.qqnt.kernel.nativeinterface.QueryUserSecQualityRsp;
import com.tencent.qqnt.kernel.nativeinterface.RecvdOrder;
import com.tencent.qqnt.kernel.nativeinterface.RelatedWordEmojiInfo;
import com.tencent.qqnt.kernel.nativeinterface.SearchGroupFileResult;
import com.tencent.qqnt.kernel.nativeinterface.TempChatInfo;
import com.tencent.qqnt.kernel.nativeinterface.ax;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.api.IMsgService;
import com.tencent.relation.common.nt.api.IRelationNTPushService;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt__CharJVMKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import msf.msgcomm.nt_msg_common$Msg;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/relation/common/nt/api/impl/RelationNTPushServiceImpl;", "Lcom/tencent/relation/common/nt/api/IRelationNTPushService;", "", "registerRelationNTPush", "unRegisterRelationNTPush", "", "getRelationNTPushSwitch", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "mMsgListener", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "<init>", "()V", "Companion", "a", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RelationNTPushServiceImpl implements IRelationNTPushService {
    public static final long DEAL_MSG_TYPE = 528;
    public static final String PRE_HEX_STRING = "0x";
    public static final String TAG = "RelationNTPushServiceImpl";

    @QAutoInjectJustClazz(configPath = "IMCore/src/main/resources/Inject_relation_nt_push.yml", version = 1)
    private static final HashMap<String, Class<? extends oz3.a>> mSubMsgTypeProcessorMap;
    private static final boolean relationNTPushSwitch;
    private IKernelMsgListener mMsgListener;

    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u001a\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/relation/common/nt/api/impl/RelationNTPushServiceImpl$b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelMsgListener;", "", "businessType", "", QQBrowserActivity.KEY_MSG_TYPE, "msgSubType", "", TPReportKeys.Common.COMMON_ONLINE, "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "msgBuf", "", "onSysMsgNotification", "relation_common_business_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements IKernelMsgListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppRuntime f364726d;

        b(AppRuntime appRuntime) {
            this.f364726d = appRuntime;
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

        /* JADX WARN: Removed duplicated region for block: B:25:0x0123  */
        /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelMsgListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onSysMsgNotification(int businessType, long msgType, long msgSubType, boolean online, ArrayList<Byte> msgBuf) {
            int checkRadix;
            byte[] byteArray;
            if (!RelationNTPushServiceImpl.relationNTPushSwitch) {
                QLog.d(RelationNTPushServiceImpl.TAG, 1, "relationNTPushSwitch closed!");
                return;
            }
            if (msgType != 528) {
                QLog.i(RelationNTPushServiceImpl.TAG, 1, "msgType != 0x210L");
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append(RelationNTPushServiceImpl.PRE_HEX_STRING);
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            String l3 = Long.toString(msgSubType, checkRadix);
            Intrinsics.checkNotNullExpressionValue(l3, "toString(this, checkRadix(radix))");
            sb5.append(l3);
            String sb6 = sb5.toString();
            Class cls = (Class) RelationNTPushServiceImpl.mSubMsgTypeProcessorMap.get(sb6);
            if (cls == null) {
                QLog.i(RelationNTPushServiceImpl.TAG, 1, "processorClazz == null  msgSubTypeHexStr = " + sb6);
                return;
            }
            QLog.i(RelationNTPushServiceImpl.TAG, 1, "msgSubTypeHexStr =  " + sb6 + " msgSubType = " + msgSubType);
            nt_msg_common$Msg nt_msg_common_msg = new nt_msg_common$Msg();
            if (msgBuf != null) {
                try {
                    byteArray = CollectionsKt___CollectionsKt.toByteArray(msgBuf);
                    nt_msg_common_msg.mergeFrom(byteArray);
                } catch (InvalidProtocolBufferMicroException e16) {
                    e = e16;
                    if (QLog.isColorLevel()) {
                    }
                }
            }
            Class<?> cls2 = Long.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("processMsg", Integer.TYPE, cls2, cls2, Boolean.TYPE, nt_msg_common$Msg.class, AppRuntime.class);
            oz3.a aVar = (oz3.a) cls.newInstance();
            Object[] objArr = new Object[6];
            objArr[0] = Integer.valueOf(businessType);
            objArr[1] = Long.valueOf(msgType);
            objArr[2] = Long.valueOf(msgSubType);
            objArr[3] = Boolean.valueOf(online);
            objArr[4] = nt_msg_common_msg;
            try {
                objArr[5] = this.f364726d;
                declaredMethod.invoke(aVar, objArr);
                QLog.d(RelationNTPushServiceImpl.TAG, 1, "process msg busType: " + businessType + " msgType: " + msgType + " subType: " + msgSubType + " online: " + online);
            } catch (InvalidProtocolBufferMicroException e17) {
                e = e17;
                if (QLog.isColorLevel()) {
                    return;
                }
                QLog.e(RelationNTPushServiceImpl.TAG, 2, "convertMsgCommPB fail", e);
            }
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

    static {
        HashMap<String, Class<? extends oz3.a>> hashMap = new HashMap<>();
        mSubMsgTypeProcessorMap = hashMap;
        hashMap.put("0xc7", SubType0xc7.class);
        hashMap.put("0x11e", SubType0x11e.class);
        hashMap.put("0xb3", SubType0xb3.class);
        hashMap.put("0x76", SubType0x76.class);
        relationNTPushSwitch = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105647", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void registerRelationNTPush$lambda$1(int i3, String str) {
        QLog.i(TAG, 1, "register result = " + i3 + ", errMsg = " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void unRegisterRelationNTPush$lambda$3(int i3, String str) {
        QLog.i(TAG, 1, "unregister result = " + i3 + ", errMsg = " + str);
    }

    @Override // com.tencent.relation.common.nt.api.IRelationNTPushService
    public boolean getRelationNTPushSwitch() {
        return relationNTPushSwitch;
    }

    @Override // com.tencent.relation.common.nt.api.IRelationNTPushService
    public void registerRelationNTPush() {
        int collectionSizeOrDefault;
        int checkRadix;
        if (this.mMsgListener != null) {
            QLog.d(TAG, 1, "Already registered!");
            return;
        }
        Set<String> keySet = mSubMsgTypeProcessorMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "mSubMsgTypeProcessorMap.keys");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String it : keySet) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            String substring = it.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            arrayList.add(Long.valueOf(Long.parseLong(substring, checkRadix)));
        }
        ArrayList<Long> arrayList2 = new ArrayList<>(arrayList);
        if (arrayList2.isEmpty()) {
            QLog.d(TAG, 1, "subTypeList.isNullOrEmpty");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "registerNtSysMsgNotification null runtime!");
            return;
        }
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService();
        if (msgService == null) {
            QLog.d(TAG, 1, "registerNtSysMsgNotification fail to get msg service!");
            return;
        }
        QLog.d(TAG, 1, "register sub type msg: " + arrayList2);
        ((IMsgService) QRoute.api(IMsgService.class)).registerSysMsgNotification(0, 528L, arrayList2, new IOperateCallback() { // from class: com.tencent.relation.common.nt.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                RelationNTPushServiceImpl.registerRelationNTPush$lambda$1(i3, str);
            }
        });
        b bVar = new b(peekAppRuntime);
        this.mMsgListener = bVar;
        msgService.addMsgListener(bVar);
    }

    @Override // com.tencent.relation.common.nt.api.IRelationNTPushService
    public void unRegisterRelationNTPush() {
        int collectionSizeOrDefault;
        int checkRadix;
        IKernelMsgListener iKernelMsgListener = this.mMsgListener;
        if (iKernelMsgListener == null) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "unregisterNtSysMsgNotification null runtime!");
            return;
        }
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")).getMsgService();
        if (msgService == null) {
            QLog.d(TAG, 1, "unregisterNtSysMsgNotification fail to get msg service!");
            return;
        }
        msgService.removeMsgListener(iKernelMsgListener);
        Set<String> keySet = mSubMsgTypeProcessorMap.keySet();
        Intrinsics.checkNotNullExpressionValue(keySet, "mSubMsgTypeProcessorMap.keys");
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(keySet, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String it : keySet) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            String substring = it.substring(2);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            checkRadix = CharsKt__CharJVMKt.checkRadix(16);
            arrayList.add(Long.valueOf(Long.parseLong(substring, checkRadix)));
        }
        ArrayList<Long> arrayList2 = new ArrayList<>(arrayList);
        if (arrayList2.isEmpty()) {
            QLog.d(TAG, 1, "No processor, no need to unregister!");
        } else {
            ((IMsgService) QRoute.api(IMsgService.class)).unregisterSysMsgNotification(0, 528L, arrayList2, new IOperateCallback() { // from class: com.tencent.relation.common.nt.api.impl.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    RelationNTPushServiceImpl.unRegisterRelationNTPush$lambda$3(i3, str);
                }
            });
            this.mMsgListener = null;
        }
    }
}
