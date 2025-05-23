package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.message.CustomElement;
import com.tencent.imsdk.message.FaceElement;
import com.tencent.imsdk.message.FileElement;
import com.tencent.imsdk.message.ImageElement;
import com.tencent.imsdk.message.LocationElement;
import com.tencent.imsdk.message.MergerElement;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListGetOption;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.MessageReceipt;
import com.tencent.imsdk.message.MessageSearchResult;
import com.tencent.imsdk.message.MessageUploadProgressCallback;
import com.tencent.imsdk.message.SoundElement;
import com.tencent.imsdk.message.TextElement;
import com.tencent.imsdk.message.VideoElement;
import com.tencent.imsdk.relationship.ReceiveMessageOptInfo;
import com.tencent.imsdk.relationship.RelationshipManager;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMMessageManagerImpl extends V2TIMMessageManager {
    private final int MAX_ABSTRACT_COUNT;
    private final int MAX_ABSTRACT_LENGTH;
    private final int MAX_FORWARD_COUNT;
    private final String TAG;
    private Object mLockObject;
    private MessageListener mMessageListener;
    private List<V2TIMAdvancedMsgListener> mV2TIMMsgListenerList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class V2TIMMessageManagerImplHolder {
        private static final V2TIMMessageManagerImpl v2TIMMessageManagerImpl = new V2TIMMessageManagerImpl();

        V2TIMMessageManagerImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMMessageManagerImpl getInstance() {
        return V2TIMMessageManagerImplHolder.v2TIMMessageManagerImpl;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void addAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        if (v2TIMAdvancedMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            if (this.mV2TIMMsgListenerList.contains(v2TIMAdvancedMsgListener)) {
                return;
            }
            this.mV2TIMMsgListenerList.add(v2TIMAdvancedMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void clearC2CHistoryMessage(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "userID is empty");
                return;
            }
            return;
        }
        MessageCenter.getInstance().clearC2CHistoryMessage(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.21
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void clearGroupHistoryMessage(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        MessageCenter.getInstance().clearGroupHistoryMessage(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.22
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createCustomMessage(byte[] bArr) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        CustomElement customElement = new CustomElement();
        customElement.setData(bArr);
        message.addElement(customElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createFaceMessage(int i3, byte[] bArr) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        FaceElement faceElement = new FaceElement();
        faceElement.setFaceData(bArr);
        faceElement.setFaceIndex(i3);
        message.addElement(faceElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createFileMessage(String str, String str2) {
        if (new File(str).exists()) {
            V2TIMMessage v2TIMMessage = new V2TIMMessage();
            Message message = new Message();
            FileElement fileElement = new FileElement();
            fileElement.setFilePath(str);
            fileElement.setFileName(str2);
            message.addElement(fileElement);
            v2TIMMessage.setMessage(message);
            return v2TIMMessage;
        }
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createForwardMessage(V2TIMMessage v2TIMMessage) {
        if (v2TIMMessage == null) {
            IMLog.e("V2TIMMessageManagerImpl", "createForwardMessage, message cannot be null");
            return null;
        }
        if (2 != v2TIMMessage.getStatus()) {
            IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
            return null;
        }
        if (9 == v2TIMMessage.getElemType()) {
            IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
            return null;
        }
        Message message = new Message();
        message.setMessageBaseElements(v2TIMMessage.getMessage().getMessageBaseElements());
        message.setForward(true);
        V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
        v2TIMMessage2.setMessage(message);
        return v2TIMMessage2;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createImageMessage(String str) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        ImageElement imageElement = new ImageElement();
        imageElement.setOriginImageFilePath(str);
        message.addElement(imageElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createLocationMessage(String str, double d16, double d17) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        LocationElement locationElement = new LocationElement();
        locationElement.setLongitude(d16);
        locationElement.setLatitude(d17);
        locationElement.setDescription(str);
        message.addElement(locationElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createMergerMessage(List<V2TIMMessage> list, String str, List<String> list2, String str2) {
        if (list != null && list.size() != 0 && list.size() <= 300) {
            ArrayList arrayList = new ArrayList();
            if (list2 != null) {
                int size = list2.size();
                if (size >= 5) {
                    size = 5;
                }
                for (int i3 = 0; i3 < size; i3++) {
                    String str3 = list2.get(i3);
                    if (str3 != null) {
                        if (str3.length() > 100) {
                            str3 = str3.substring(0, 100);
                        }
                        arrayList.add(str3);
                    }
                }
            }
            for (V2TIMMessage v2TIMMessage : list) {
                if (2 != v2TIMMessage.getStatus()) {
                    IMLog.e("V2TIMMessageManagerImpl", "message status must be V2TIM_MSG_STATUS_SEND_SUCC");
                    return null;
                }
                if (9 == v2TIMMessage.getElemType()) {
                    IMLog.e("V2TIMMessageManagerImpl", "group tips message is not support");
                    return null;
                }
            }
            if (str2 == null) {
                IMLog.e("V2TIMMessageManagerImpl", "compatibleText invalid, compatibleText cannot be null");
                return null;
            }
            MergerElement mergerElement = new MergerElement();
            mergerElement.setTitle(str);
            mergerElement.setAbstractList(arrayList);
            mergerElement.setCompatibleText(str2);
            ArrayList arrayList2 = new ArrayList();
            Iterator<V2TIMMessage> it = list.iterator();
            while (it.hasNext()) {
                arrayList2.add(it.next().getMessage());
            }
            mergerElement.setMessageList(arrayList2);
            Message message = new Message();
            message.addElement(mergerElement);
            message.setForward(true);
            V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
            v2TIMMessage2.setMessage(message);
            return v2TIMMessage2;
        }
        IMLog.e("V2TIMMessageManagerImpl", "messageList invalid, the number of messageList must be between 1 and 300");
        return null;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createSoundMessage(String str, int i3) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        SoundElement soundElement = new SoundElement();
        if (i3 < 0) {
            i3 = 0;
        }
        soundElement.setSoundDuration(i3);
        soundElement.setSoundFilePath(str);
        message.addElement(soundElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createTextAtMessage(String str, List<String> list) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        TextElement textElement = new TextElement();
        textElement.setTextContent(str);
        message.addElement(textElement);
        v2TIMMessage.setMessage(message);
        v2TIMMessage.setGroupAtUserList(list);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createTextMessage(String str) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        TextElement textElement = new TextElement();
        textElement.setTextContent(str);
        message.addElement(textElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createVideoMessage(String str, String str2, int i3, String str3) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        VideoElement videoElement = new VideoElement();
        videoElement.setVideoFilePath(str);
        videoElement.setSnapshotFilePath(str3);
        if (i3 < 0) {
            i3 = 0;
        }
        videoElement.setVideoDuration(i3);
        videoElement.setVideoType(str2);
        message.addElement(videoElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void deleteMessageFromLocalStorage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "message is null");
                return;
            }
            return;
        }
        MessageCenter.getInstance().deleteLocalMessage(v2TIMMessage.getMessage().getMessageKey(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.19
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void deleteMessages(List<V2TIMMessage> list, V2TIMCallback v2TIMCallback) {
        if (list != null && !list.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            Iterator<V2TIMMessage> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getMessage().getMessageKey());
            }
            MessageCenter.getInstance().deleteCloudMessageList(arrayList, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.20
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "messages is invalid");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void findMessages(List<String> list, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (list != null && !list.isEmpty()) {
            MessageCenter.getInstance().findMessageByMessageId(list, new IMCallback<List<Message>>(new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.27
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i3, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Message> list2) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list2) {
                        V2TIMMessage v2TIMMessage = new V2TIMMessage();
                        v2TIMMessage.setMessage(message);
                        arrayList.add(v2TIMMessage);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.28
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Message> list2) {
                    super.success((AnonymousClass28) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "messages is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getC2CHistoryMessageList(String str, int i3, V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        MessageKey messageKey;
        if (!TextUtils.isEmpty(str) && i3 != 0) {
            V2TIMValueCallback<List<Message>> v2TIMValueCallback2 = new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.9
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i16, String str2) {
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(i16, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Message> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
                        v2TIMMessage2.setMessage(message);
                        arrayList.add(v2TIMMessage2);
                    }
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onSuccess(arrayList);
                    }
                }
            };
            if (v2TIMMessage != null) {
                messageKey = v2TIMMessage.getMessage().getMessageKey();
            } else {
                messageKey = null;
            }
            MessageListGetOption messageListGetOption = new MessageListGetOption();
            messageListGetOption.setCount(i3);
            messageListGetOption.setToOlderMessage(true);
            messageListGetOption.setGetCloudMessage(true);
            messageListGetOption.setMessageKey(messageKey);
            MessageCenter.getInstance().getC2CHistoryMessageList(str, messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.10
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i16, String str2) {
                    super.fail(i16, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Message> list) {
                    super.success((AnonymousClass10) list);
                }
            });
            return;
        }
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "userID is empty or count is 0");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getC2CReceiveMessageOpt(List<String> list, final V2TIMValueCallback<List<V2TIMReceiveMessageOptInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getC2CReceiveMessageOpt(list, new IMCallback<List<ReceiveMessageOptInfo>>(new V2TIMValueCallback<List<ReceiveMessageOptInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.6
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i3, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<ReceiveMessageOptInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (ReceiveMessageOptInfo receiveMessageOptInfo : list2) {
                            V2TIMReceiveMessageOptInfo v2TIMReceiveMessageOptInfo = new V2TIMReceiveMessageOptInfo();
                            v2TIMReceiveMessageOptInfo.setUserID(receiveMessageOptInfo.getUserID());
                            v2TIMReceiveMessageOptInfo.setC2CReceiveMessageOpt(receiveMessageOptInfo.getC2CReceiveMessageOpt());
                            arrayList.add(v2TIMReceiveMessageOptInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.7
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<ReceiveMessageOptInfo> list2) {
                    super.success((AnonymousClass7) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getGroupHistoryMessageList(String str, int i3, V2TIMMessage v2TIMMessage, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        MessageKey messageKey;
        if (!TextUtils.isEmpty(str) && i3 > 0) {
            V2TIMValueCallback<List<Message>> v2TIMValueCallback2 = new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.11
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i16, String str2) {
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onError(i16, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Message> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Message message : list) {
                        V2TIMMessage v2TIMMessage2 = new V2TIMMessage();
                        v2TIMMessage2.setMessage(message);
                        arrayList.add(v2TIMMessage2);
                    }
                    V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                    if (v2TIMValueCallback3 != null) {
                        v2TIMValueCallback3.onSuccess(arrayList);
                    }
                }
            };
            if (v2TIMMessage != null) {
                messageKey = v2TIMMessage.getMessage().getMessageKey();
            } else {
                messageKey = null;
            }
            MessageListGetOption messageListGetOption = new MessageListGetOption();
            messageListGetOption.setCount(i3);
            messageListGetOption.setToOlderMessage(true);
            messageListGetOption.setGetCloudMessage(true);
            messageListGetOption.setMessageKey(messageKey);
            MessageCenter.getInstance().getGroupHistoryMessageList(str, messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.12
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i16, String str2) {
                    super.fail(i16, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Message> list) {
                    super.success((AnonymousClass12) list);
                }
            });
            return;
        }
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "groupID is empty or count is 0");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void getHistoryMessageList(V2TIMMessageListGetOption v2TIMMessageListGetOption, final V2TIMValueCallback<List<V2TIMMessage>> v2TIMValueCallback) {
        if (v2TIMMessageListGetOption == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "option is null");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) && TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID and userID cannot be null at the same time");
                return;
            }
            return;
        }
        if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID()) && !TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID())) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID and userID cannot set at the same time");
                return;
            }
            return;
        }
        if (v2TIMMessageListGetOption.getCount() <= 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "count less than 0");
                return;
            }
            return;
        }
        MessageListGetOption messageListGetOption = new MessageListGetOption();
        messageListGetOption.setCount(v2TIMMessageListGetOption.getCount());
        messageListGetOption.setGetTimeBegin(v2TIMMessageListGetOption.getGetTimeBegin());
        messageListGetOption.setGetTimePeriod(v2TIMMessageListGetOption.getGetTimePeriod());
        int getType = v2TIMMessageListGetOption.getGetType();
        if (getType != 1) {
            if (getType != 2) {
                if (getType != 3) {
                    if (getType != 4) {
                        if (v2TIMValueCallback != null) {
                            v2TIMValueCallback.onError(6017, "getType is invalid");
                            return;
                        }
                        return;
                    }
                    messageListGetOption.setToOlderMessage(false);
                    messageListGetOption.setGetCloudMessage(false);
                } else {
                    messageListGetOption.setToOlderMessage(true);
                    messageListGetOption.setGetCloudMessage(false);
                }
            } else {
                messageListGetOption.setToOlderMessage(false);
                messageListGetOption.setGetCloudMessage(true);
            }
        } else {
            messageListGetOption.setToOlderMessage(true);
            messageListGetOption.setGetCloudMessage(true);
        }
        if (v2TIMMessageListGetOption.getLastMsg() != null) {
            messageListGetOption.setMessageKey(v2TIMMessageListGetOption.getLastMsg().getMessage().getMessageKey());
        } else if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getGroupID()) && v2TIMMessageListGetOption.getLastMsgSeq() > 0) {
            MessageKey messageKey = new MessageKey();
            messageKey.setSeq(v2TIMMessageListGetOption.getLastMsgSeq());
            messageListGetOption.setMessageKey(messageKey);
        }
        V2TIMValueCallback<List<Message>> v2TIMValueCallback2 = new V2TIMValueCallback<List<Message>>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.13
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str) {
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onError(i3, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(List<Message> list) {
                ArrayList arrayList = new ArrayList();
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    arrayList.add(v2TIMMessage);
                }
                V2TIMValueCallback v2TIMValueCallback3 = v2TIMValueCallback;
                if (v2TIMValueCallback3 != null) {
                    v2TIMValueCallback3.onSuccess(arrayList);
                }
            }
        };
        if (v2TIMMessageListGetOption.getLastMsg() != null) {
            v2TIMMessageListGetOption.getLastMsg().getMessage().getMessageKey();
        }
        if (!TextUtils.isEmpty(v2TIMMessageListGetOption.getUserID())) {
            MessageCenter.getInstance().getC2CHistoryMessageList(v2TIMMessageListGetOption.getUserID(), messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.14
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Message> list) {
                    super.success((AnonymousClass14) list);
                }
            });
        } else {
            MessageCenter.getInstance().getGroupHistoryMessageList(v2TIMMessageListGetOption.getGroupID(), messageListGetOption, new IMCallback<List<Message>>(v2TIMValueCallback2) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.15
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Message> list) {
                    super.success((AnonymousClass15) list);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initListener() {
        this.mMessageListener = new MessageListener() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.1
            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(List<Message> list) {
                for (Message message : list) {
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                        Iterator it = V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMAdvancedMsgListener) it.next()).onRecvMessageModified(v2TIMMessage);
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageReceipt(List<MessageReceipt> list) {
                ArrayList arrayList = new ArrayList();
                for (MessageReceipt messageReceipt : list) {
                    V2TIMMessageReceipt v2TIMMessageReceipt = new V2TIMMessageReceipt();
                    v2TIMMessageReceipt.setMessageReceipt(messageReceipt);
                    arrayList.add(v2TIMMessageReceipt);
                }
                synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                    Iterator it = V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMAdvancedMsgListener) it.next()).onRecvC2CReadReceipt(arrayList);
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(List<MessageKey> list) {
                if (list != null && !list.isEmpty()) {
                    MessageKey messageKey = list.get(0);
                    synchronized (V2TIMMessageManagerImpl.this.mLockObject) {
                        Iterator it = V2TIMMessageManagerImpl.this.mV2TIMMsgListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMAdvancedMsgListener) it.next()).onRecvMessageRevoked(messageKey.getMessageID());
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(List<Message> list) {
                if (list != null && !list.isEmpty()) {
                    Message message = list.get(0);
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    V2TIMSignalingInfo processSignalingMessage = V2TIMSignalingManagerImpl.getInstance().processSignalingMessage(v2TIMMessage);
                    if (processSignalingMessage != null && processSignalingMessage.isOnlineUserOnly()) {
                        return;
                    }
                    V2TIMMessageManagerImpl.this.onRecvNewMessage(v2TIMMessage);
                }
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String insertC2CMessageToLocalStorage(final V2TIMMessage v2TIMMessage, String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "message is null!");
            }
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "sender is empty");
            }
            return "";
        }
        Message message = v2TIMMessage.getMessage();
        message.setMessageType(Message.MESSAGE_TYPE_C2C);
        message.setSenderUserID(str2);
        message.setReceiverUserID(str);
        return MessageCenter.getInstance().insertLocalMessage(message, new IMCallback(new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.25
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Message message2) {
                if (v2TIMValueCallback != null) {
                    v2TIMMessage.setMessage(message2);
                    v2TIMValueCallback.onSuccess(v2TIMMessage);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.26
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str3) {
                super.fail(i3, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                v2TIMMessage.getMessage().update((Message) obj);
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String insertGroupMessageToLocalStorage(final V2TIMMessage v2TIMMessage, String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "message is null!");
            }
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID is empty");
            }
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "sender is empty");
            }
            return "";
        }
        Message message = v2TIMMessage.getMessage();
        message.setMessageType(Message.MESSAGE_TYPE_GROUP);
        message.setSenderUserID(str2);
        message.setGroupID(str);
        return MessageCenter.getInstance().insertLocalMessage(message, new IMCallback(new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.23
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Message message2) {
                if (v2TIMValueCallback != null) {
                    v2TIMMessage.setMessage(message2);
                    v2TIMValueCallback.onSuccess(v2TIMMessage);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.24
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str3) {
                super.fail(i3, str3);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                v2TIMMessage.getMessage().update((Message) obj);
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void markC2CMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "userID is empty");
                return;
            }
            return;
        }
        MessageCenter.getInstance().setC2CMessageRead(str, 0L, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.17
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void markGroupMessageAsRead(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        MessageCenter.getInstance().setGroupMessageRead(str, 0L, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.18
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str2) {
                super.fail(i3, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onRecvNewMessage(V2TIMMessage v2TIMMessage) {
        synchronized (this.mLockObject) {
            Iterator<V2TIMAdvancedMsgListener> it = this.mV2TIMMsgListenerList.iterator();
            while (it.hasNext()) {
                it.next().onRecvNewMessage(v2TIMMessage);
            }
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void removeAdvancedMsgListener(V2TIMAdvancedMsgListener v2TIMAdvancedMsgListener) {
        if (v2TIMAdvancedMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            this.mV2TIMMsgListenerList.remove(v2TIMAdvancedMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void revokeMessage(V2TIMMessage v2TIMMessage, V2TIMCallback v2TIMCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "msg is null");
            }
        } else {
            if (v2TIMMessage.getStatus() != 2) {
                if (v2TIMCallback != null) {
                    v2TIMCallback.onError(6017, "msg status must be V2TIM_MSG_STATUS_SEND_SUCC");
                    return;
                }
                return;
            }
            MessageCenter.getInstance().revokeMessage(v2TIMMessage.getMessage().getMessageKey(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.16
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void searchLocalMessages(V2TIMMessageSearchParam v2TIMMessageSearchParam, final V2TIMValueCallback<V2TIMMessageSearchResult> v2TIMValueCallback) {
        if (v2TIMMessageSearchParam.getSearchTimePosition() >= 0 && v2TIMMessageSearchParam.getSearchTimePeriod() >= 0) {
            if (v2TIMMessageSearchParam.getPageIndex() >= 0 && v2TIMMessageSearchParam.getPageSize() >= 0) {
                MessageCenter.getInstance().findMessageBySearchKey(v2TIMMessageSearchParam.getMessageSearchParam(), new IMCallback<MessageSearchResult>(new V2TIMValueCallback<MessageSearchResult>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.29
                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onError(int i3, String str) {
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onError(i3, str);
                        }
                    }

                    @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                    public void onSuccess(MessageSearchResult messageSearchResult) {
                        V2TIMMessageSearchResult v2TIMMessageSearchResult = new V2TIMMessageSearchResult();
                        v2TIMMessageSearchResult.setMessageSearchResult(messageSearchResult);
                        V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                        if (v2TIMValueCallback2 != null) {
                            v2TIMValueCallback2.onSuccess(v2TIMMessageSearchResult);
                        }
                    }
                }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.30
                    @Override // com.tencent.imsdk.common.IMCallback
                    public void fail(int i3, String str) {
                        super.fail(i3, str);
                    }

                    @Override // com.tencent.imsdk.common.IMCallback
                    public void success(MessageSearchResult messageSearchResult) {
                        super.success((AnonymousClass30) messageSearchResult);
                    }
                });
                return;
            } else {
                if (v2TIMValueCallback != null) {
                    v2TIMValueCallback.onError(6017, "pageIndex or pageSize is invalid");
                    return;
                }
                return;
            }
        }
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "time < 0");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public String sendMessage(final V2TIMMessage v2TIMMessage, String str, String str2, int i3, boolean z16, V2TIMOfflinePushInfo v2TIMOfflinePushInfo, final V2TIMSendCallback<V2TIMMessage> v2TIMSendCallback) {
        if (v2TIMMessage == null) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(6017, "message is null");
            }
            return null;
        }
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(6017, "receiver and groupID cannot be empty at the same time!");
            }
            return null;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (v2TIMSendCallback != null) {
                v2TIMSendCallback.onError(6017, "receiver and groupID cannot set at the same time!");
            }
            return null;
        }
        Message message = v2TIMMessage.getMessage();
        if (!TextUtils.isEmpty(str)) {
            message.setMessageType(Message.MESSAGE_TYPE_C2C);
            message.setReceiverUserID(str);
        } else {
            message.setMessageType(Message.MESSAGE_TYPE_GROUP);
            message.setGroupID(str2);
        }
        message.setPriority(i3);
        if (z16) {
            message.setLifeTime(0);
        }
        if (v2TIMOfflinePushInfo != null) {
            message.setOfflinePushInfo(v2TIMOfflinePushInfo.getMessageOfflinePushInfo());
        }
        message.setPlatform(Message.PLATFORM_ANDROID);
        return MessageCenter.getInstance().sendMessage(message, new MessageUploadProgressCallback() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.2
            @Override // com.tencent.imsdk.message.MessageUploadProgressCallback
            public void onUploadProgress(int i16, final int i17, final int i18) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        int i19;
                        V2TIMSendCallback v2TIMSendCallback2 = v2TIMSendCallback;
                        if (v2TIMSendCallback2 != null) {
                            int i26 = i18;
                            if (i26 > 0) {
                                i19 = (int) ((i17 / i26) * 100.0f);
                            } else {
                                i19 = 0;
                            }
                            v2TIMSendCallback2.onProgress(i19);
                        }
                    }
                });
            }
        }, new IMCallback(new V2TIMValueCallback<Message>() { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.3
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i16, String str3) {
                V2TIMSendCallback v2TIMSendCallback2 = v2TIMSendCallback;
                if (v2TIMSendCallback2 != null) {
                    v2TIMSendCallback2.onError(i16, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(Message message2) {
                if (v2TIMSendCallback != null) {
                    v2TIMMessage.setMessage(message2);
                    v2TIMSendCallback.onSuccess(v2TIMMessage);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.4
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i16, String str3, Object obj) {
                v2TIMMessage.getMessage().update((Message) obj);
                super.fail(i16, str3, obj);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                v2TIMMessage.getMessage().update((Message) obj);
                super.success(obj);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void setC2CReceiveMessageOpt(List<String> list, int i3, V2TIMCallback v2TIMCallback) {
        if (list != null && list.size() != 0) {
            int i16 = 1;
            if (i3 != 0) {
                if (i3 == 1) {
                    i16 = 2;
                } else if (i3 == 2) {
                    i16 = 3;
                } else {
                    IMLog.e("V2TIMMessageManagerImpl", "setC2CReceiveMessageOpt error opt = " + i3);
                    if (v2TIMCallback != null) {
                        v2TIMCallback.onError(6017, "opt is error");
                        return;
                    }
                    return;
                }
            }
            RelationshipManager.getInstance().setC2CReceiveMessageOpt(list, i16, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.5
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i17, String str) {
                    super.fail(i17, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
            return;
        }
        if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public void setGroupReceiveMessageOpt(String str, int i3, V2TIMCallback v2TIMCallback) {
        int i16;
        if (TextUtils.isEmpty(str)) {
            IMLog.e("V2TIMMessageManagerImpl", "setReceiveMessageOpt err, groupID is empty");
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "groupID is empty");
                return;
            }
            return;
        }
        int i17 = GroupMemberInfo.MEMBER_ROLE_MEMBER;
        if (i3 == 0) {
            i16 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_AUTO_RECEIVE;
        } else if (i3 == 1) {
            i16 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_NOT_RECEIVE;
        } else if (i3 == 2) {
            i16 = GroupMemberInfo.MESSAGE_RECEIVE_OPTION_RECEIVE_WITH_NO_OFFLINE_PUSH;
        } else {
            IMLog.e("V2TIMMessageManagerImpl", "setReceiveMessageOpt error opt = " + i3);
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "opt is error");
                return;
            }
            return;
        }
        GroupManager.getInstance().setGroupReceiveMessageOpt(str, i16, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMMessageManagerImpl.8
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i18, String str2) {
                super.fail(i18, str2);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Object obj) {
                super.success(obj);
            }
        });
    }

    V2TIMMessageManagerImpl() {
        this.TAG = "V2TIMMessageManagerImpl";
        this.MAX_FORWARD_COUNT = 300;
        this.MAX_ABSTRACT_COUNT = 5;
        this.MAX_ABSTRACT_LENGTH = 100;
        this.mLockObject = new Object();
        this.mV2TIMMsgListenerList = new CopyOnWriteArrayList();
    }

    @Override // com.tencent.imsdk.v2.V2TIMMessageManager
    public V2TIMMessage createCustomMessage(byte[] bArr, String str, byte[] bArr2) {
        V2TIMMessage v2TIMMessage = new V2TIMMessage();
        Message message = new Message();
        CustomElement customElement = new CustomElement();
        customElement.setData(bArr);
        customElement.setDescription(str);
        customElement.setExtension(bArr2);
        message.addElement(customElement);
        v2TIMMessage.setMessage(message);
        return v2TIMMessage;
    }
}
