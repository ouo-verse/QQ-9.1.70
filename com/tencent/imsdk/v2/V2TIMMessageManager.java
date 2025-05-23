package com.tencent.imsdk.v2;

import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public abstract class V2TIMMessageManager {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMMessageManager getInstance() {
        return V2TIMMessageManagerImpl.getInstance();
    }

    public abstract void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener);

    public abstract void clearC2CHistoryMessage(String str, V2TIMCallback v2TIMCallback);

    public abstract void clearGroupHistoryMessage(String str, V2TIMCallback v2TIMCallback);

    public abstract V2TIMMessage createCustomMessage(byte[] bArr);

    public abstract V2TIMMessage createCustomMessage(byte[] bArr, String str, byte[] bArr2);

    public abstract V2TIMMessage createFaceMessage(int i3, byte[] bArr);

    public abstract V2TIMMessage createFileMessage(String str, String str2);

    public abstract V2TIMMessage createForwardMessage(V2TIMMessage v2TIMMessage);

    public abstract V2TIMMessage createImageMessage(String str);

    public abstract V2TIMMessage createLocationMessage(String str, double d16, double d17);

    public abstract V2TIMMessage createMergerMessage(List<V2TIMMessage> list, String str, List<String> list2, String str2);

    public abstract V2TIMMessage createSoundMessage(String str, int i3);

    public abstract V2TIMMessage createTextAtMessage(String str, List<String> list);

    public abstract V2TIMMessage createTextMessage(String str);

    public abstract V2TIMMessage createVideoMessage(String str, String str2, int i3, String str3);

    public abstract void deleteMessageFromLocalStorage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback);

    public abstract void deleteMessages(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback);

    public abstract void findMessages(List<String> list, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getC2CHistoryMessageList(String str, int i3, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getC2CReceiveMessageOpt(List<String> list, V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>> v2TIMValueCallback);

    public abstract void getGroupHistoryMessageList(String str, int i3, V2TIMMessage v2TIMMessage, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract void getHistoryMessageList(V2TIMMessageListGetOption v2TIMMessageListGetOption, V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback);

    public abstract String insertC2CMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract String insertGroupMessageToLocalStorage(V2TIMMessage v2TIMMessage, String str, String str2, V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback);

    public abstract void markC2CMessageAsRead(String str, V2TIMCallback v2TIMCallback);

    public abstract void markGroupMessageAsRead(String str, V2TIMCallback v2TIMCallback);

    public abstract void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener);

    public abstract void revokeMessage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback);

    public abstract void searchLocalMessages(V2TIMMessageSearchParam v2TIMMessageSearchParam, V2TIMValueCallback<V2TIMMessageSearchResult> v2TIMValueCallback);

    public abstract String sendMessage(V2TIMMessage v2TIMMessage, String str, String str2, int i3, boolean z16, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback);

    public abstract void setC2CReceiveMessageOpt(List<String> list, int i3, V2TIMCallback v2TIMCallback);

    public abstract void setGroupReceiveMessageOpt(String str, int i3, V2TIMCallback v2TIMCallback);
}
