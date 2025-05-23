package com.tencent.imsdk.message;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.IMLog;
import com.tencent.imsdk.manager.BaseManager;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MessageCenter {
    private static final String TAG = "MessageCenter";
    private MessageListener mMessageListener;
    private Object mLockObject = new Object();
    private CopyOnWriteArrayList<MessageListener> mMessageProxyListenerList = new CopyOnWriteArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class MessageCenterHolder {
        private static final MessageCenter messageCenter = new MessageCenter();

        MessageCenterHolder() {
        }
    }

    protected MessageCenter() {
    }

    public static MessageCenter getInstance() {
        return MessageCenterHolder.messageCenter;
    }

    private void initMessageListener() {
        MessageListener messageListener = new MessageListener() { // from class: com.tencent.imsdk.message.MessageCenter.1
            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(final List<Message> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it.hasNext()) {
                                ((MessageListener) it.next()).onReceiveMessageModified(list);
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageReceipt(final List<MessageReceipt> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it.hasNext()) {
                                ((MessageListener) it.next()).onReceiveMessageReceipt(list);
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(final List<MessageKey> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it.hasNext()) {
                                ((MessageListener) it.next()).onReceiveMessageRevoked(list);
                            }
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(final List<Message> list) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.message.MessageCenter.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        synchronized (MessageCenter.this.mLockObject) {
                            Iterator it = MessageCenter.this.mMessageProxyListenerList.iterator();
                            while (it.hasNext()) {
                                ((MessageListener) it.next()).onReceiveNewMessage(list);
                            }
                        }
                    }
                });
            }
        };
        this.mMessageListener = messageListener;
        nativeSetMessageListener(messageListener);
    }

    public void addMessageListener(MessageListener messageListener) {
        synchronized (this.mLockObject) {
            this.mMessageProxyListenerList.add(messageListener);
        }
    }

    public void clearC2CHistoryMessage(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeClearC2CHistoryMessage(str, iMCallback);
    }

    public void clearC2CLocalMessage(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeClearC2CLocalMessage(str, iMCallback);
    }

    public void clearGroupHistoryMessage(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeClearGroupHistoryMessage(str, iMCallback);
    }

    public void clearGroupLocalMessage(String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeClearGroupLocalMessage(str, iMCallback);
    }

    public void deleteCloudMessageList(List<MessageKey> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteCloudMessageList(list, iMCallback);
    }

    public void deleteLocalMessage(MessageKey messageKey, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteLocalMessage(messageKey, iMCallback);
    }

    public void downloadMessageElement(DownloadParam downloadParam, IMCallback<DownloadProgressInfo> iMCallback, IMCallback iMCallback2) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback2 != null) {
                iMCallback2.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDownloadMessageElement(downloadParam, iMCallback, iMCallback2);
    }

    public void downloadRelayMessageList(Message message, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDownloadRelayMessageList(message, iMCallback);
    }

    public void findMessageByMessageId(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeFindMessageByMessageID(list, iMCallback);
    }

    public void findMessageBySearchKey(MessageSearchParam messageSearchParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeFindMessageBySearchKey(messageSearchParam, iMCallback);
    }

    public void getC2CHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetC2CHistoryMessageList(str, messageListGetOption, iMCallback);
    }

    public void getDownloadUrl(DownloadParam downloadParam, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetDownloadUrl(downloadParam, iMCallback);
    }

    public void getGroupHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetGroupHistoryMessageList(str, messageListGetOption, iMCallback);
    }

    public void init() {
        initMessageListener();
    }

    public String insertLocalMessage(Message message, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return null;
            }
            return null;
        }
        return nativeInsertLocalMessage(message, iMCallback);
    }

    public boolean isMessagePeerRead(MessageKey messageKey) {
        if (!BaseManager.getInstance().isInited()) {
            IMLog.e(TAG, "sdk not ini");
            return false;
        }
        return nativeIsMessagePeerRead(messageKey);
    }

    public boolean isMessageSelfRead(MessageKey messageKey) {
        if (!BaseManager.getInstance().isInited()) {
            IMLog.e(TAG, "sdk not ini");
            return false;
        }
        return nativeIsMessageSelfRead(messageKey);
    }

    protected native void nativeClearC2CHistoryMessage(String str, IMCallback iMCallback);

    protected native void nativeClearC2CLocalMessage(String str, IMCallback iMCallback);

    protected native void nativeClearGroupHistoryMessage(String str, IMCallback iMCallback);

    protected native void nativeClearGroupLocalMessage(String str, IMCallback iMCallback);

    protected native void nativeDeleteCloudMessageList(List<MessageKey> list, IMCallback iMCallback);

    protected native void nativeDeleteLocalMessage(MessageKey messageKey, IMCallback iMCallback);

    protected native void nativeDownloadMessageElement(DownloadParam downloadParam, IMCallback iMCallback, IMCallback iMCallback2);

    protected native void nativeDownloadRelayMessageList(Message message, IMCallback iMCallback);

    protected native void nativeFindMessageByMessageID(List<String> list, IMCallback iMCallback);

    protected native void nativeFindMessageBySearchKey(MessageSearchParam messageSearchParam, IMCallback iMCallback);

    protected native void nativeGetC2CHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback);

    protected native void nativeGetDownloadUrl(DownloadParam downloadParam, IMCallback iMCallback);

    protected native void nativeGetGroupHistoryMessageList(String str, MessageListGetOption messageListGetOption, IMCallback iMCallback);

    protected native String nativeInsertLocalMessage(Message message, IMCallback iMCallback);

    protected native boolean nativeIsMessagePeerRead(MessageKey messageKey);

    protected native boolean nativeIsMessageSelfRead(MessageKey messageKey);

    protected native void nativeRevokeMessage(MessageKey messageKey, IMCallback iMCallback);

    protected native String nativeSendMessage(Message message, MessageUploadProgressCallback messageUploadProgressCallback, IMCallback iMCallback);

    protected native void nativeSetC2CMessageRead(String str, long j3, IMCallback iMCallback);

    protected native void nativeSetGroupMessageRead(String str, long j3, IMCallback iMCallback);

    protected native void nativeSetLocalCustomNumber(Message message, int i3);

    protected native void nativeSetLocalCustomString(Message message, String str);

    protected native void nativeSetMessageListener(MessageListener messageListener);

    public void revokeMessage(MessageKey messageKey, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeRevokeMessage(messageKey, iMCallback);
    }

    public String sendMessage(Message message, MessageUploadProgressCallback messageUploadProgressCallback, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return null;
            }
            return null;
        }
        return nativeSendMessage(message, messageUploadProgressCallback, iMCallback);
    }

    public void setC2CMessageRead(String str, long j3, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetC2CMessageRead(str, j3, iMCallback);
    }

    public void setGroupMessageRead(String str, long j3, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetGroupMessageRead(str, j3, iMCallback);
    }

    public void setLocalCustomNumber(Message message, int i3) {
        nativeSetLocalCustomNumber(message, i3);
    }

    public void setLocalCustomString(Message message, String str) {
        nativeSetLocalCustomString(message, str);
    }
}
