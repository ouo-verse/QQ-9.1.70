package com.tencent.qqnt.kernelgpro.nativeinterface;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes24.dex */
public interface IKernelGProGuildMsgService {

    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelGProGuildMsgService {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private final AtomicBoolean destroyed = new AtomicBoolean(false);
        private final long nativeRef;

        CppProxy(long j3) {
            if (j3 != 0) {
                this.nativeRef = j3;
                return;
            }
            throw new RuntimeException("nativeRef is zero");
        }

        private native void nativeDestroy(long j3);

        private native long native_addKernelGProGuildMsgListener(long j3, IKernelGProGuildMsgListener iKernelGProGuildMsgListener);

        private native void native_clearGuildReadSceneV2(long j3, GProContact gProContact, int i3, IGuildOperateCallback iGuildOperateCallback);

        private native void native_deleteGuildFeedDraft(long j3, String str, int i3, String str2, IGuildOperateCallback iGuildOperateCallback);

        private native void native_deleteRecallMsg(long j3, GProContact gProContact, long j16, IGuildOperateCallback iGuildOperateCallback);

        private native void native_deleteRecallMsgForLocal(long j3, GProContact gProContact, long j16, IGuildOperateCallback iGuildOperateCallback);

        private native void native_enableFilterMsgAbstractNotify(long j3, boolean z16);

        private native void native_enableFilterUnreadInfoNotify(long j3, boolean z16);

        private native void native_forceShowGuildHelperNode(long j3);

        private native void native_getAllDirectSessionUnreadCntInfo(long j3, IUnreadCntCallback iUnreadCntCallback);

        private native void native_getAllGuildUnreadCntInfo(long j3, IUnreadCntCallback iUnreadCntCallback);

        private native void native_getCategoryUnreadCntInfo(long j3, ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

        private native void native_getChannelEventFlow(long j3, GProContact gProContact);

        private native void native_getFirstUnreadAtallMsg(long j3, GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback);

        private native void native_getFirstUnreadAtmeMsg(long j3, GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback);

        private native void native_getFirstUnreadCommonMsg(long j3, GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback);

        private native void native_getGuildChannelListUnreadInfo(long j3, ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

        private native void native_getGuildFeedDraft(long j3, String str, int i3, String str2, IGProGuildDraftCallback iGProGuildDraftCallback);

        private native void native_getGuildFeedsUnreadCntInfo(long j3, ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

        private native void native_getGuildHelperNotifySwitch(long j3, IGuildHelperNotifySwitchOperateCallback iGuildHelperNotifySwitchOperateCallback);

        private native void native_getGuildInteractiveNotification(long j3, String str, int i3, IGuildInteractiveNotificationCallback iGuildInteractiveNotificationCallback);

        private native void native_getGuildUnreadCntInfo(long j3, ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

        private native void native_getGuildUnreadCntTabInfo(long j3, ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

        private native void native_getMsgAbstracts(long j3, String str, ArrayList<String> arrayList, IGProGuildGetMsgAbstractsCallback iGProGuildGetMsgAbstractsCallback);

        private native void native_getNavigateInfo(long j3, GProContact gProContact, IFetchNavigateInfoCallback iFetchNavigateInfoCallback);

        private native void native_getUnreadCntInfo(long j3, ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

        private native void native_outputGuildUnreadInfo(long j3, GProContact gProContact);

        private native void native_recallGProMsg(long j3, GProContact gProContact, ArrayList<Long> arrayList, IGuildOperateCallback iGuildOperateCallback);

        private native void native_recallMsgs(long j3, GProContact gProContact, ArrayList<GProRecallReqItem> arrayList, IGProRecallCallback iGProRecallCallback);

        private native void native_removeKernelGProGuildMsgListener(long j3, long j16);

        private native void native_setCurOnScreenMsg(long j3, GProContact gProContact, int i3, ArrayList<Long> arrayList);

        private native void native_setFocusSession(long j3, GProContact gProContact, boolean z16, int i3);

        private native void native_setGProAllDirectMsgRead(long j3, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setGProAllGuildMsgRead(long j3, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setGProGuildMsgRead(long j3, String str, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setGProLocalMsgRead(long j3, GProContact gProContact, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setGProMsgRead(long j3, GProContact gProContact, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setGuildFeedDraft(long j3, String str, int i3, String str2, GProGuildFeedDraft gProGuildFeedDraft, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setGuildHelperNotifySwitch(long j3, int i3, int i16, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setUnVisibleChannelCntInfo(long j3, ArrayList<GProContact> arrayList, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setUnVisibleChannelTypeCntInfo(long j3, ArrayList<Integer> arrayList, ArrayList<Long> arrayList2, IGuildOperateCallback iGuildOperateCallback);

        private native void native_setVisibleGuildCntInfo(long j3, String str, IGuildOperateCallback iGuildOperateCallback);

        public static native int preloadMethod();

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public long addKernelGProGuildMsgListener(IKernelGProGuildMsgListener iKernelGProGuildMsgListener) {
            return native_addKernelGProGuildMsgListener(this.nativeRef, iKernelGProGuildMsgListener);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void clearGuildReadSceneV2(GProContact gProContact, int i3, IGuildOperateCallback iGuildOperateCallback) {
            native_clearGuildReadSceneV2(this.nativeRef, gProContact, i3, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void deleteGuildFeedDraft(String str, int i3, String str2, IGuildOperateCallback iGuildOperateCallback) {
            native_deleteGuildFeedDraft(this.nativeRef, str, i3, str2, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void deleteRecallMsg(GProContact gProContact, long j3, IGuildOperateCallback iGuildOperateCallback) {
            native_deleteRecallMsg(this.nativeRef, gProContact, j3, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void deleteRecallMsgForLocal(GProContact gProContact, long j3, IGuildOperateCallback iGuildOperateCallback) {
            native_deleteRecallMsgForLocal(this.nativeRef, gProContact, j3, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void enableFilterMsgAbstractNotify(boolean z16) {
            native_enableFilterMsgAbstractNotify(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void enableFilterUnreadInfoNotify(boolean z16) {
            native_enableFilterUnreadInfoNotify(this.nativeRef, z16);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void forceShowGuildHelperNode() {
            native_forceShowGuildHelperNode(this.nativeRef);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getAllDirectSessionUnreadCntInfo(IUnreadCntCallback iUnreadCntCallback) {
            native_getAllDirectSessionUnreadCntInfo(this.nativeRef, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getAllGuildUnreadCntInfo(IUnreadCntCallback iUnreadCntCallback) {
            native_getAllGuildUnreadCntInfo(this.nativeRef, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getCategoryUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback) {
            native_getCategoryUnreadCntInfo(this.nativeRef, arrayList, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getChannelEventFlow(GProContact gProContact) {
            native_getChannelEventFlow(this.nativeRef, gProContact);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getFirstUnreadAtallMsg(GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback) {
            native_getFirstUnreadAtallMsg(this.nativeRef, gProContact, iGuildFetchChannelLatestSeqCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getFirstUnreadAtmeMsg(GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback) {
            native_getFirstUnreadAtmeMsg(this.nativeRef, gProContact, iGuildFetchChannelLatestSeqCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getFirstUnreadCommonMsg(GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback) {
            native_getFirstUnreadCommonMsg(this.nativeRef, gProContact, iGuildFetchChannelLatestSeqCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getGuildChannelListUnreadInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback) {
            native_getGuildChannelListUnreadInfo(this.nativeRef, arrayList, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getGuildFeedDraft(String str, int i3, String str2, IGProGuildDraftCallback iGProGuildDraftCallback) {
            native_getGuildFeedDraft(this.nativeRef, str, i3, str2, iGProGuildDraftCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getGuildFeedsUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback) {
            native_getGuildFeedsUnreadCntInfo(this.nativeRef, arrayList, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getGuildHelperNotifySwitch(IGuildHelperNotifySwitchOperateCallback iGuildHelperNotifySwitchOperateCallback) {
            native_getGuildHelperNotifySwitch(this.nativeRef, iGuildHelperNotifySwitchOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getGuildInteractiveNotification(String str, int i3, IGuildInteractiveNotificationCallback iGuildInteractiveNotificationCallback) {
            native_getGuildInteractiveNotification(this.nativeRef, str, i3, iGuildInteractiveNotificationCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getGuildUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback) {
            native_getGuildUnreadCntInfo(this.nativeRef, arrayList, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getGuildUnreadCntTabInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback) {
            native_getGuildUnreadCntTabInfo(this.nativeRef, arrayList, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getMsgAbstracts(String str, ArrayList<String> arrayList, IGProGuildGetMsgAbstractsCallback iGProGuildGetMsgAbstractsCallback) {
            native_getMsgAbstracts(this.nativeRef, str, arrayList, iGProGuildGetMsgAbstractsCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getNavigateInfo(GProContact gProContact, IFetchNavigateInfoCallback iFetchNavigateInfoCallback) {
            native_getNavigateInfo(this.nativeRef, gProContact, iFetchNavigateInfoCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void getUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback) {
            native_getUnreadCntInfo(this.nativeRef, arrayList, iUnreadCntCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void outputGuildUnreadInfo(GProContact gProContact) {
            native_outputGuildUnreadInfo(this.nativeRef, gProContact);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void recallGProMsg(GProContact gProContact, ArrayList<Long> arrayList, IGuildOperateCallback iGuildOperateCallback) {
            native_recallGProMsg(this.nativeRef, gProContact, arrayList, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void recallMsgs(GProContact gProContact, ArrayList<GProRecallReqItem> arrayList, IGProRecallCallback iGProRecallCallback) {
            native_recallMsgs(this.nativeRef, gProContact, arrayList, iGProRecallCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void removeKernelGProGuildMsgListener(long j3) {
            native_removeKernelGProGuildMsgListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setCurOnScreenMsg(GProContact gProContact, int i3, ArrayList<Long> arrayList) {
            native_setCurOnScreenMsg(this.nativeRef, gProContact, i3, arrayList);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setFocusSession(GProContact gProContact, boolean z16, int i3) {
            native_setFocusSession(this.nativeRef, gProContact, z16, i3);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setGProAllDirectMsgRead(IGuildOperateCallback iGuildOperateCallback) {
            native_setGProAllDirectMsgRead(this.nativeRef, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setGProAllGuildMsgRead(IGuildOperateCallback iGuildOperateCallback) {
            native_setGProAllGuildMsgRead(this.nativeRef, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setGProGuildMsgRead(String str, IGuildOperateCallback iGuildOperateCallback) {
            native_setGProGuildMsgRead(this.nativeRef, str, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setGProLocalMsgRead(GProContact gProContact, IGuildOperateCallback iGuildOperateCallback) {
            native_setGProLocalMsgRead(this.nativeRef, gProContact, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setGProMsgRead(GProContact gProContact, IGuildOperateCallback iGuildOperateCallback) {
            native_setGProMsgRead(this.nativeRef, gProContact, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setGuildFeedDraft(String str, int i3, String str2, GProGuildFeedDraft gProGuildFeedDraft, IGuildOperateCallback iGuildOperateCallback) {
            native_setGuildFeedDraft(this.nativeRef, str, i3, str2, gProGuildFeedDraft, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setGuildHelperNotifySwitch(int i3, int i16, IGuildOperateCallback iGuildOperateCallback) {
            native_setGuildHelperNotifySwitch(this.nativeRef, i3, i16, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setUnVisibleChannelCntInfo(ArrayList<GProContact> arrayList, IGuildOperateCallback iGuildOperateCallback) {
            native_setUnVisibleChannelCntInfo(this.nativeRef, arrayList, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setUnVisibleChannelTypeCntInfo(ArrayList<Integer> arrayList, ArrayList<Long> arrayList2, IGuildOperateCallback iGuildOperateCallback) {
            native_setUnVisibleChannelTypeCntInfo(this.nativeRef, arrayList, arrayList2, iGuildOperateCallback);
        }

        @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IKernelGProGuildMsgService
        public void setVisibleGuildCntInfo(String str, IGuildOperateCallback iGuildOperateCallback) {
            native_setVisibleGuildCntInfo(this.nativeRef, str, iGuildOperateCallback);
        }
    }

    long addKernelGProGuildMsgListener(IKernelGProGuildMsgListener iKernelGProGuildMsgListener);

    void clearGuildReadSceneV2(GProContact gProContact, int i3, IGuildOperateCallback iGuildOperateCallback);

    void deleteGuildFeedDraft(String str, int i3, String str2, IGuildOperateCallback iGuildOperateCallback);

    void deleteRecallMsg(GProContact gProContact, long j3, IGuildOperateCallback iGuildOperateCallback);

    void deleteRecallMsgForLocal(GProContact gProContact, long j3, IGuildOperateCallback iGuildOperateCallback);

    void enableFilterMsgAbstractNotify(boolean z16);

    void enableFilterUnreadInfoNotify(boolean z16);

    void forceShowGuildHelperNode();

    void getAllDirectSessionUnreadCntInfo(IUnreadCntCallback iUnreadCntCallback);

    void getAllGuildUnreadCntInfo(IUnreadCntCallback iUnreadCntCallback);

    void getCategoryUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

    void getChannelEventFlow(GProContact gProContact);

    void getFirstUnreadAtallMsg(GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback);

    void getFirstUnreadAtmeMsg(GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback);

    void getFirstUnreadCommonMsg(GProContact gProContact, IGuildFetchChannelLatestSeqCallback iGuildFetchChannelLatestSeqCallback);

    void getGuildChannelListUnreadInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

    void getGuildFeedDraft(String str, int i3, String str2, IGProGuildDraftCallback iGProGuildDraftCallback);

    void getGuildFeedsUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

    void getGuildHelperNotifySwitch(IGuildHelperNotifySwitchOperateCallback iGuildHelperNotifySwitchOperateCallback);

    void getGuildInteractiveNotification(String str, int i3, IGuildInteractiveNotificationCallback iGuildInteractiveNotificationCallback);

    void getGuildUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

    void getGuildUnreadCntTabInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

    void getMsgAbstracts(String str, ArrayList<String> arrayList, IGProGuildGetMsgAbstractsCallback iGProGuildGetMsgAbstractsCallback);

    void getNavigateInfo(GProContact gProContact, IFetchNavigateInfoCallback iFetchNavigateInfoCallback);

    void getUnreadCntInfo(ArrayList<GProContact> arrayList, IUnreadCntCallback iUnreadCntCallback);

    void outputGuildUnreadInfo(GProContact gProContact);

    void recallGProMsg(GProContact gProContact, ArrayList<Long> arrayList, IGuildOperateCallback iGuildOperateCallback);

    void recallMsgs(GProContact gProContact, ArrayList<GProRecallReqItem> arrayList, IGProRecallCallback iGProRecallCallback);

    void removeKernelGProGuildMsgListener(long j3);

    void setCurOnScreenMsg(GProContact gProContact, int i3, ArrayList<Long> arrayList);

    void setFocusSession(GProContact gProContact, boolean z16, int i3);

    void setGProAllDirectMsgRead(IGuildOperateCallback iGuildOperateCallback);

    void setGProAllGuildMsgRead(IGuildOperateCallback iGuildOperateCallback);

    void setGProGuildMsgRead(String str, IGuildOperateCallback iGuildOperateCallback);

    void setGProLocalMsgRead(GProContact gProContact, IGuildOperateCallback iGuildOperateCallback);

    void setGProMsgRead(GProContact gProContact, IGuildOperateCallback iGuildOperateCallback);

    void setGuildFeedDraft(String str, int i3, String str2, GProGuildFeedDraft gProGuildFeedDraft, IGuildOperateCallback iGuildOperateCallback);

    void setGuildHelperNotifySwitch(int i3, int i16, IGuildOperateCallback iGuildOperateCallback);

    void setUnVisibleChannelCntInfo(ArrayList<GProContact> arrayList, IGuildOperateCallback iGuildOperateCallback);

    void setUnVisibleChannelTypeCntInfo(ArrayList<Integer> arrayList, ArrayList<Long> arrayList2, IGuildOperateCallback iGuildOperateCallback);

    void setVisibleGuildCntInfo(String str, IGuildOperateCallback iGuildOperateCallback);
}
