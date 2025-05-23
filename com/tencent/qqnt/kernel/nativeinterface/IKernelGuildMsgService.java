package com.tencent.qqnt.kernel.nativeinterface;

import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelGuildMsgService {

    /* compiled from: P */
    /* loaded from: classes24.dex */
    public static final class CppProxy implements IKernelGuildMsgService {
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

        private native long native_addKernelGuildMsgListener(long j3, IKernelGuildMsgListener iKernelGuildMsgListener);

        private native void native_fetchGroupGuildUnread(long j3, Contact contact, boolean z16, IOperateCallback iOperateCallback);

        private native void native_getAllJoinGuildCnt(long j3, IJoinGuildCntCallback iJoinGuildCntCallback);

        private native void native_getChannelFreqLimitInfo(long j3, Contact contact);

        private native void native_getGuestMsgAbstractByRange(long j3, Contact contact, long j16, int i3, boolean z16, int i16, IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback);

        private native void native_getGuestMsgAbstracts(long j3, String str, ArrayList<String> arrayList, int i3, IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback);

        private native void native_getGuestMsgByRange(long j3, Contact contact, long j16, int i3, boolean z16, int i16, IGuestMsgOperateCallback iGuestMsgOperateCallback);

        private native void native_getGuildGroupBubble(long j3, Contact contact, boolean z16, IGetGuildGroupBubbleCallback iGetGuildGroupBubbleCallback);

        private native void native_getGuildGroupTransData(long j3, Contact contact, IGetGuildBinaryDataCallback iGetGuildBinaryDataCallback);

        private native void native_getGuildMsgAbFlag(long j3, IGuildMsgAbFlagCallback iGuildMsgAbFlagCallback);

        private native void native_getMsgAbstractList(long j3, Contact contact, ArrayList<Long> arrayList, IGuildGetMsgAbstractsCallback iGuildGetMsgAbstractsCallback);

        private native void native_getMsgAbstractListBySeqRange(long j3, Contact contact, long j16, long j17, IGuildGetMsgAbstractsCallback iGuildGetMsgAbstractsCallback);

        private native void native_getMsgsBySeqList(long j3, Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback);

        private native void native_getMsgsBySeqRange(long j3, Contact contact, long j16, long j17, IMsgOperateCallback iMsgOperateCallback);

        private native void native_insertGameResultAsMsgToDb(long j3, MsgRecord msgRecord, IOperateCallback iOperateCallback);

        private native void native_isGuildChannelSync(long j3, MatchKey matchKey, IGuildMatchedOperateCallback iGuildMatchedOperateCallback);

        private native void native_onScenesChangeForSilenceMode(long j3, int i3);

        private native void native_refreshMsgAbstracts(long j3, String str, ArrayList<String> arrayList);

        private native void native_refreshMsgAbstractsByGuildIds(long j3, ArrayList<String> arrayList);

        private native void native_removeKernelGuildMsgListener(long j3, long j16);

        private native void native_sendSummonMsg(long j3, Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback);

        private native void native_setBuildMode(long j3, int i3);

        private native void native_setConfigurationServiceData(long j3, HashMap<Long, String> hashMap);

        private native void native_setFocusOnGuild(long j3, boolean z16);

        private native void native_setGroupGuildBubbleRead(long j3, Contact contact, IOperateCallback iOperateCallback);

        private native void native_setGroupGuildFlag(long j3, int i3);

        private native void native_setGroupGuildMsgRead(long j3, Contact contact, ArrayList<SceneInfoParam> arrayList, boolean z16, boolean z17, IOperateCallback iOperateCallback);

        private native void native_setGuildTabUserFlag(long j3, int i3);

        private native void native_setGuildUDCFlag(long j3, int i3);

        private native void native_startGuildMsgSync(long j3);

        public static native int preloadMethod();

        public void _djinni_private_destroy() {
            if (!this.destroyed.getAndSet(true)) {
                nativeDestroy(this.nativeRef);
            }
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public long addKernelGuildMsgListener(IKernelGuildMsgListener iKernelGuildMsgListener) {
            return native_addKernelGuildMsgListener(this.nativeRef, iKernelGuildMsgListener);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void fetchGroupGuildUnread(Contact contact, boolean z16, IOperateCallback iOperateCallback) {
            native_fetchGroupGuildUnread(this.nativeRef, contact, z16, iOperateCallback);
        }

        protected void finalize() throws Throwable {
            _djinni_private_destroy();
            super.finalize();
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getAllJoinGuildCnt(IJoinGuildCntCallback iJoinGuildCntCallback) {
            native_getAllJoinGuildCnt(this.nativeRef, iJoinGuildCntCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getChannelFreqLimitInfo(Contact contact) {
            native_getChannelFreqLimitInfo(this.nativeRef, contact);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getGuestMsgAbstractByRange(Contact contact, long j3, int i3, boolean z16, int i16, IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback) {
            native_getGuestMsgAbstractByRange(this.nativeRef, contact, j3, i3, z16, i16, iGuestGetMsgAbstractsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getGuestMsgAbstracts(String str, ArrayList<String> arrayList, int i3, IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback) {
            native_getGuestMsgAbstracts(this.nativeRef, str, arrayList, i3, iGuestGetMsgAbstractsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getGuestMsgByRange(Contact contact, long j3, int i3, boolean z16, int i16, IGuestMsgOperateCallback iGuestMsgOperateCallback) {
            native_getGuestMsgByRange(this.nativeRef, contact, j3, i3, z16, i16, iGuestMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getGuildGroupBubble(Contact contact, boolean z16, IGetGuildGroupBubbleCallback iGetGuildGroupBubbleCallback) {
            native_getGuildGroupBubble(this.nativeRef, contact, z16, iGetGuildGroupBubbleCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getGuildGroupTransData(Contact contact, IGetGuildBinaryDataCallback iGetGuildBinaryDataCallback) {
            native_getGuildGroupTransData(this.nativeRef, contact, iGetGuildBinaryDataCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getGuildMsgAbFlag(IGuildMsgAbFlagCallback iGuildMsgAbFlagCallback) {
            native_getGuildMsgAbFlag(this.nativeRef, iGuildMsgAbFlagCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getMsgAbstractList(Contact contact, ArrayList<Long> arrayList, IGuildGetMsgAbstractsCallback iGuildGetMsgAbstractsCallback) {
            native_getMsgAbstractList(this.nativeRef, contact, arrayList, iGuildGetMsgAbstractsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getMsgAbstractListBySeqRange(Contact contact, long j3, long j16, IGuildGetMsgAbstractsCallback iGuildGetMsgAbstractsCallback) {
            native_getMsgAbstractListBySeqRange(this.nativeRef, contact, j3, j16, iGuildGetMsgAbstractsCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getMsgsBySeqList(Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsBySeqList(this.nativeRef, contact, arrayList, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void getMsgsBySeqRange(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback) {
            native_getMsgsBySeqRange(this.nativeRef, contact, j3, j16, iMsgOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void insertGameResultAsMsgToDb(MsgRecord msgRecord, IOperateCallback iOperateCallback) {
            native_insertGameResultAsMsgToDb(this.nativeRef, msgRecord, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void isGuildChannelSync(MatchKey matchKey, IGuildMatchedOperateCallback iGuildMatchedOperateCallback) {
            native_isGuildChannelSync(this.nativeRef, matchKey, iGuildMatchedOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void onScenesChangeForSilenceMode(int i3) {
            native_onScenesChangeForSilenceMode(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void refreshMsgAbstracts(String str, ArrayList<String> arrayList) {
            native_refreshMsgAbstracts(this.nativeRef, str, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void refreshMsgAbstractsByGuildIds(ArrayList<String> arrayList) {
            native_refreshMsgAbstractsByGuildIds(this.nativeRef, arrayList);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void removeKernelGuildMsgListener(long j3) {
            native_removeKernelGuildMsgListener(this.nativeRef, j3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void sendSummonMsg(Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback) {
            native_sendSummonMsg(this.nativeRef, contact, arrayList, hashMap, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setBuildMode(int i3) {
            native_setBuildMode(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setConfigurationServiceData(HashMap<Long, String> hashMap) {
            native_setConfigurationServiceData(this.nativeRef, hashMap);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setFocusOnGuild(boolean z16) {
            native_setFocusOnGuild(this.nativeRef, z16);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setGroupGuildBubbleRead(Contact contact, IOperateCallback iOperateCallback) {
            native_setGroupGuildBubbleRead(this.nativeRef, contact, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setGroupGuildFlag(int i3) {
            native_setGroupGuildFlag(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setGroupGuildMsgRead(Contact contact, ArrayList<SceneInfoParam> arrayList, boolean z16, boolean z17, IOperateCallback iOperateCallback) {
            native_setGroupGuildMsgRead(this.nativeRef, contact, arrayList, z16, z17, iOperateCallback);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setGuildTabUserFlag(int i3) {
            native_setGuildTabUserFlag(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void setGuildUDCFlag(int i3) {
            native_setGuildUDCFlag(this.nativeRef, i3);
        }

        @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelGuildMsgService
        public void startGuildMsgSync() {
            native_startGuildMsgSync(this.nativeRef);
        }
    }

    long addKernelGuildMsgListener(IKernelGuildMsgListener iKernelGuildMsgListener);

    void fetchGroupGuildUnread(Contact contact, boolean z16, IOperateCallback iOperateCallback);

    void getAllJoinGuildCnt(IJoinGuildCntCallback iJoinGuildCntCallback);

    void getChannelFreqLimitInfo(Contact contact);

    void getGuestMsgAbstractByRange(Contact contact, long j3, int i3, boolean z16, int i16, IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback);

    void getGuestMsgAbstracts(String str, ArrayList<String> arrayList, int i3, IGuestGetMsgAbstractsCallback iGuestGetMsgAbstractsCallback);

    void getGuestMsgByRange(Contact contact, long j3, int i3, boolean z16, int i16, IGuestMsgOperateCallback iGuestMsgOperateCallback);

    void getGuildGroupBubble(Contact contact, boolean z16, IGetGuildGroupBubbleCallback iGetGuildGroupBubbleCallback);

    void getGuildGroupTransData(Contact contact, IGetGuildBinaryDataCallback iGetGuildBinaryDataCallback);

    void getGuildMsgAbFlag(IGuildMsgAbFlagCallback iGuildMsgAbFlagCallback);

    void getMsgAbstractList(Contact contact, ArrayList<Long> arrayList, IGuildGetMsgAbstractsCallback iGuildGetMsgAbstractsCallback);

    void getMsgAbstractListBySeqRange(Contact contact, long j3, long j16, IGuildGetMsgAbstractsCallback iGuildGetMsgAbstractsCallback);

    void getMsgsBySeqList(Contact contact, ArrayList<Long> arrayList, IMsgOperateCallback iMsgOperateCallback);

    void getMsgsBySeqRange(Contact contact, long j3, long j16, IMsgOperateCallback iMsgOperateCallback);

    void insertGameResultAsMsgToDb(MsgRecord msgRecord, IOperateCallback iOperateCallback);

    void isGuildChannelSync(MatchKey matchKey, IGuildMatchedOperateCallback iGuildMatchedOperateCallback);

    void onScenesChangeForSilenceMode(int i3);

    void refreshMsgAbstracts(String str, ArrayList<String> arrayList);

    void refreshMsgAbstractsByGuildIds(ArrayList<String> arrayList);

    void removeKernelGuildMsgListener(long j3);

    void sendSummonMsg(Contact contact, ArrayList<MsgElement> arrayList, HashMap<Integer, MsgAttributeInfo> hashMap, IOperateCallback iOperateCallback);

    void setBuildMode(int i3);

    void setConfigurationServiceData(HashMap<Long, String> hashMap);

    void setFocusOnGuild(boolean z16);

    void setGroupGuildBubbleRead(Contact contact, IOperateCallback iOperateCallback);

    void setGroupGuildFlag(int i3);

    void setGroupGuildMsgRead(Contact contact, ArrayList<SceneInfoParam> arrayList, boolean z16, boolean z17, IOperateCallback iOperateCallback);

    void setGuildTabUserFlag(int i3);

    void setGuildUDCFlag(int i3);

    void startGuildMsgSync();
}
