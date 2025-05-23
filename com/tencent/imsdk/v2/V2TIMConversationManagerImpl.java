package com.tencent.imsdk.v2;

import android.text.TextUtils;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.conversation.Conversation;
import com.tencent.imsdk.conversation.ConversationKey;
import com.tencent.imsdk.conversation.ConversationListener;
import com.tencent.imsdk.conversation.ConversationManager;
import com.tencent.imsdk.conversation.ConversationResult;
import com.tencent.imsdk.message.DraftMessage;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMConversationManagerImpl extends V2TIMConversationManager {
    private ConversationListener mConversationListener;
    private V2TIMConversationListener mV2TIMConversationListener;
    private final List<V2TIMConversationListener> mV2TIMConversationListenerList;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class V2TIMConversationManagerImplHolder {
        private static final V2TIMConversationManagerImpl v2TIMConversationManagerImpl = new V2TIMConversationManagerImpl();

        V2TIMConversationManagerImplHolder() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static V2TIMConversationManagerImpl getInstance() {
        return V2TIMConversationManagerImplHolder.v2TIMConversationManagerImpl;
    }

    private void initListener() {
        if (this.mConversationListener == null) {
            this.mConversationListener = new ConversationListener() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.1
                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onConversationChanged(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onConversationChanged(unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onNewConversation(List<Conversation> list) {
                    ArrayList arrayList = new ArrayList();
                    for (Conversation conversation : list) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList.add(v2TIMConversation);
                    }
                    List<V2TIMConversation> unmodifiableList = Collections.unmodifiableList(arrayList);
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onNewConversation(unmodifiableList);
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFailed() {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onSyncServerFailed();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerFinish() {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onSyncServerFinish();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onSyncServerStart() {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onSyncServerStart();
                    }
                }

                @Override // com.tencent.imsdk.conversation.ConversationListener
                public void onTotalUnreadMessageCountChanged(long j3) {
                    Iterator it = V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.iterator();
                    while (it.hasNext()) {
                        ((V2TIMConversationListener) it.next()).onTotalUnreadMessageCountChanged(j3);
                    }
                }
            };
        }
        ConversationManager.getInstance().setConversationListener(this.mConversationListener);
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void addConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.contains(v2TIMConversationListener)) {
                    return;
                }
                V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void deleteConversation(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is empty");
            }
        } else {
            ConversationManager.getInstance().deleteConversation(getConversationKey(str), true, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.11
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
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversation(String str, final V2TIMValueCallback<V2TIMConversation> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationID is empty");
            }
        } else {
            ConversationManager.getInstance().getConversationInfo(getConversationKey(str), new IMCallback<Conversation>(new V2TIMValueCallback<Conversation>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.9
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str2) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i3, str2);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(Conversation conversation) {
                    if (v2TIMValueCallback != null) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        v2TIMValueCallback.onSuccess(v2TIMConversation);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.10
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str2) {
                    super.fail(i3, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Conversation conversation) {
                    super.success((AnonymousClass10) conversation);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ConversationKey getConversationKey(String str) {
        ConversationKey conversationKey = new ConversationKey();
        if (str.indexOf("c2c_") == 0) {
            String substring = str.substring(4);
            conversationKey.setConversationType(1);
            conversationKey.setConversationID(substring);
        } else if (str.indexOf(VipFunCallConstants.KEY_GROUP_ONE) == 0) {
            String substring2 = str.substring(6);
            conversationKey.setConversationType(2);
            conversationKey.setConversationID(substring2);
        }
        return conversationKey;
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationList(long j3, int i3, final V2TIMValueCallback<V2TIMConversationResult> v2TIMValueCallback) {
        ConversationManager.getInstance().getConversationList(j3, i3, new IMCallback<ConversationResult>(new V2TIMValueCallback<ConversationResult>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.5
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i16, String str) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i16, str);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(ConversationResult conversationResult) {
                if (v2TIMValueCallback != null) {
                    V2TIMConversationResult v2TIMConversationResult = new V2TIMConversationResult();
                    v2TIMConversationResult.setConversationResult(conversationResult);
                    v2TIMValueCallback.onSuccess(v2TIMConversationResult);
                }
            }
        }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.6
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i16, String str) {
                super.fail(i16, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(ConversationResult conversationResult) {
                super.success((AnonymousClass6) conversationResult);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getTotalUnreadMessageCount(V2TIMValueCallback<Long> v2TIMValueCallback) {
        ConversationManager.getInstance().getTotalUnreadMessageCount(new IMCallback<Long>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.14
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str) {
                super.fail(i3, str);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(Long l3) {
                super.success((AnonymousClass14) l3);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void pinConversation(String str, boolean z16, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is empty");
            }
        } else {
            ConversationManager.getInstance().pinConversation(getConversationKey(str), z16, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.13
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
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void removeConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        if (v2TIMConversationListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(v2TIMConversationListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationDraft(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "conversationID is empty");
            }
        } else {
            ConversationKey conversationKey = getConversationKey(str);
            DraftMessage draftMessage = new DraftMessage();
            if (str2 != null) {
                draftMessage.setUserDefinedData(str2.getBytes());
            }
            ConversationManager.getInstance().setConversationDraft(conversationKey, draftMessage, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.12
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str3) {
                    super.fail(i3, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void setConversationListener(final V2TIMConversationListener v2TIMConversationListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMConversationManagerImpl.this.mV2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.remove(V2TIMConversationManagerImpl.this.mV2TIMConversationListener);
                }
                if (v2TIMConversationListener != null) {
                    V2TIMConversationManagerImpl.this.mV2TIMConversationListenerList.add(v2TIMConversationListener);
                }
                V2TIMConversationManagerImpl.this.mV2TIMConversationListener = v2TIMConversationListener;
            }
        });
    }

    V2TIMConversationManagerImpl() {
        this.mV2TIMConversationListenerList = new ArrayList();
        initListener();
    }

    @Override // com.tencent.imsdk.v2.V2TIMConversationManager
    public void getConversationList(List<String> list, final V2TIMValueCallback<List<V2TIMConversation>> v2TIMValueCallback) {
        if (list == null || list.size() == 0) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "conversationIDList cannot be empty");
            }
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getConversationKey(it.next()));
            }
            ConversationManager.getInstance().getConversationList(arrayList, new IMCallback<List<Conversation>>(new V2TIMValueCallback<List<Conversation>>() { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.7
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i3, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<Conversation> list2) {
                    ArrayList arrayList2 = new ArrayList();
                    for (Conversation conversation : list2) {
                        V2TIMConversation v2TIMConversation = new V2TIMConversation();
                        v2TIMConversation.setConversation(conversation);
                        arrayList2.add(v2TIMConversation);
                    }
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onSuccess(arrayList2);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMConversationManagerImpl.8
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<Conversation> list2) {
                    super.success((AnonymousClass8) list2);
                }
            });
        }
    }
}
