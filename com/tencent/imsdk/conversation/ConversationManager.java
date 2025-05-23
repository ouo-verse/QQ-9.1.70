package com.tencent.imsdk.conversation;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.message.DraftMessage;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ConversationManager {
    private static final String TAG = "ConversationManager";
    private ConversationListener mConversationListener;
    private ConversationListener mInternalConversationListener;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class ConversationManagerHolder {
        private static final ConversationManager conversationManager = new ConversationManager();

        ConversationManagerHolder() {
        }
    }

    public static ConversationManager getInstance() {
        return ConversationManagerHolder.conversationManager;
    }

    private void initInternalConversationListener() {
        if (this.mInternalConversationListener == null) {
            this.mInternalConversationListener = new ConversationListener() { // from class: com.tencent.imsdk.conversation.ConversationManager.1
                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationChanged(final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onConversationChanged(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onNewConversation(final List<Conversation> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onNewConversation(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFailed() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerFailed();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFinish() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerFinish();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerStart() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onSyncServerStart();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onTotalUnreadMessageCountChanged(final long j3) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.conversation.ConversationManager.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (ConversationManager.this.mConversationListener != null) {
                                ConversationManager.this.mConversationListener.onTotalUnreadMessageCountChanged(j3);
                            }
                        }
                    });
                }
            };
        }
        nativeSetConversationListener(this.mInternalConversationListener);
    }

    public void deleteConversation(ConversationKey conversationKey, boolean z16, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteConversation(conversationKey, z16, iMCallback);
    }

    public void getConversationInfo(ConversationKey conversationKey, IMCallback<Conversation> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetConversationInfo(conversationKey, iMCallback);
    }

    public void getConversationList(long j3, int i3, IMCallback<ConversationResult> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversationList(j3, i3, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(6013, "sdk not init");
        }
    }

    public void getTotalUnreadMessageCount(IMCallback<Long> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetTotalUnreadMessageCount(iMCallback);
    }

    public void init() {
        initInternalConversationListener();
    }

    protected native void nativeDeleteConversation(ConversationKey conversationKey, boolean z16, IMCallback iMCallback);

    protected native void nativeGetConversationInfo(ConversationKey conversationKey, IMCallback iMCallback);

    protected native void nativeGetConversationList(long j3, int i3, IMCallback iMCallback);

    protected native void nativeGetConversations(List<ConversationKey> list, IMCallback iMCallback);

    protected native void nativeGetTotalUnreadMessageCount(IMCallback iMCallback);

    protected native void nativePinConversation(ConversationKey conversationKey, boolean z16, IMCallback iMCallback);

    protected native void nativeSetConversationDraft(ConversationKey conversationKey, DraftMessage draftMessage, IMCallback iMCallback);

    protected native void nativeSetConversationListener(ConversationListener conversationListener);

    public void pinConversation(ConversationKey conversationKey, boolean z16, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativePinConversation(conversationKey, z16, iMCallback);
    }

    public void setConversationDraft(ConversationKey conversationKey, DraftMessage draftMessage, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetConversationDraft(conversationKey, draftMessage, iMCallback);
    }

    public void setConversationListener(ConversationListener conversationListener) {
        this.mConversationListener = conversationListener;
    }

    public void getConversationList(List<ConversationKey> list, IMCallback<List<Conversation>> iMCallback) {
        if (BaseManager.getInstance().isInited()) {
            nativeGetConversations(list, iMCallback);
        } else if (iMCallback != null) {
            iMCallback.fail(6013, "sdk not init");
        }
    }
}
