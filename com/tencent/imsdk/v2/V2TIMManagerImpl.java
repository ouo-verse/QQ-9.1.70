package com.tencent.imsdk.v2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.common.SystemUtil;
import com.tencent.imsdk.group.GroupInfoChangeItem;
import com.tencent.imsdk.group.GroupListener;
import com.tencent.imsdk.group.GroupManager;
import com.tencent.imsdk.group.GroupMemberInfo;
import com.tencent.imsdk.group.GroupMemberInfoChangeItem;
import com.tencent.imsdk.manager.BaseManager;
import com.tencent.imsdk.manager.CustomServerInfo;
import com.tencent.imsdk.manager.SDKConfig;
import com.tencent.imsdk.manager.SDKListener;
import com.tencent.imsdk.message.Message;
import com.tencent.imsdk.message.MessageCenter;
import com.tencent.imsdk.message.MessageKey;
import com.tencent.imsdk.message.MessageListener;
import com.tencent.imsdk.message.MessageReceipt;
import com.tencent.imsdk.relationship.RelationshipManager;
import com.tencent.imsdk.relationship.UserInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class V2TIMManagerImpl extends V2TIMManager {
    private static final String TAG = "V2TIMManagerImpl";
    private GroupListener mGroupInternalListener;
    private V2TIMSDKListener mIMSDKListener;
    private MessageListener mMessageInternalListener;
    private V2TIMGroupListener mV2TIMGroupListener;
    private Object mLockObject = new Object();
    private final List<V2TIMSDKListener> mIMSDKListenerList = new ArrayList();
    private final List<V2TIMGroupListener> mGroupListenerList = new ArrayList();
    private List<V2TIMSimpleMsgListener> mV2TIMSimpleMsgListenerList = new CopyOnWriteArrayList();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class V2TIMManagerImplHolder {
        private static final V2TIMManagerImpl v2TIMManagerImpl = new V2TIMManagerImpl();

        V2TIMManagerImplHolder() {
        }
    }

    protected V2TIMManagerImpl() {
        initMessageListener();
        initGroupListener();
        V2TIMMessageManagerImpl.getInstance().initListener();
    }

    private void callbackOnError(V2TIMValueCallback<Object> v2TIMValueCallback, int i3, String str) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(i3, str);
        }
    }

    private void callbackOnSuccess(V2TIMValueCallback<Object> v2TIMValueCallback, Object obj) {
        if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onSuccess(obj);
        }
    }

    public static V2TIMManagerImpl getInstance() {
        return V2TIMManagerImplHolder.v2TIMManagerImpl;
    }

    private void initGroupListener() {
        this.mGroupInternalListener = new GroupListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.24
            V2TIMGroupMemberInfo convertToV2GroupMemberInfo(GroupMemberInfo groupMemberInfo) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                if (groupMemberInfo != null) {
                    v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                }
                return v2TIMGroupMemberInfo;
            }

            List<V2TIMGroupMemberInfo> convertToV2GroupMemberInfoList(List<GroupMemberInfo> list) {
                ArrayList arrayList = new ArrayList();
                Iterator<GroupMemberInfo> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(convertToV2GroupMemberInfo(it.next()));
                }
                return arrayList;
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onApplicationProcessed(String str, GroupMemberInfo groupMemberInfo, boolean z16, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onApplicationProcessed(str, convertToV2GroupMemberInfo(groupMemberInfo), z16, str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGrantAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGrantAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupAttributeChanged(String str, Map<String, String> map) {
                Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupAttributeChanged(str, unmodifiableMap);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupCreated(String str) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupCreated(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupDismissed(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupDismissed(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupInfoChanged(String str, List<GroupInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupInfoChangeItem groupInfoChangeItem : list) {
                    V2TIMGroupChangeInfo v2TIMGroupChangeInfo = new V2TIMGroupChangeInfo();
                    v2TIMGroupChangeInfo.setGroupInfoChangeItem(groupInfoChangeItem);
                    arrayList.add(v2TIMGroupChangeInfo);
                }
                List<V2TIMGroupChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onGroupRecycled(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onGroupRecycled(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberEnter(String str, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberEnter(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInfoChanged(String str, List<GroupMemberInfoChangeItem> list) {
                ArrayList arrayList = new ArrayList();
                for (GroupMemberInfoChangeItem groupMemberInfoChangeItem : list) {
                    V2TIMGroupMemberChangeInfo v2TIMGroupMemberChangeInfo = new V2TIMGroupMemberChangeInfo();
                    v2TIMGroupMemberChangeInfo.setGroupMemberInfoChangeItem(groupMemberInfoChangeItem);
                    arrayList.add(v2TIMGroupMemberChangeInfo);
                }
                List<V2TIMGroupMemberChangeInfo> unmodifiableList = Collections.unmodifiableList(arrayList);
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberInfoChanged(str, unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberInvited(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberInvited(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberKicked(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberKicked(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onMemberLeave(String str, GroupMemberInfo groupMemberInfo) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onMemberLeave(str, convertToV2GroupMemberInfo(groupMemberInfo));
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onQuitFromGroup(String str) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onQuitFromGroup(str);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveJoinApplication(String str, GroupMemberInfo groupMemberInfo, String str2) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onReceiveJoinApplication(str, convertToV2GroupMemberInfo(groupMemberInfo), str2);
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onReceiveRESTCustomData(String str, byte[] bArr) {
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onReceiveRESTCustomData(str, (byte[]) bArr.clone());
                }
            }

            @Override // com.tencent.imsdk.group.GroupListener
            public void onRevokeAdministrator(String str, GroupMemberInfo groupMemberInfo, List<GroupMemberInfo> list) {
                List<V2TIMGroupMemberInfo> unmodifiableList = Collections.unmodifiableList(convertToV2GroupMemberInfoList(list));
                Iterator it = V2TIMManagerImpl.this.mGroupListenerList.iterator();
                while (it.hasNext()) {
                    ((V2TIMGroupListener) it.next()).onRevokeAdministrator(str, convertToV2GroupMemberInfo(groupMemberInfo), unmodifiableList);
                }
            }
        };
        GroupManager.getInstance().setGroupListener(this.mGroupInternalListener);
    }

    private void initLocalStorage(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        String str = (String) obj;
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "invalid userID");
        } else {
            BaseManager.getInstance().initLocalStorage(str, new IMCallback(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.22
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str2) {
                    super.fail(i3, str2);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj2) {
                    super.success(obj2);
                }
            });
        }
    }

    private void initMessageListener() {
        this.mMessageInternalListener = new MessageListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.23
            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveNewMessage(List<Message> list) {
                V2TIMGroupMemberInfo v2TIMGroupMemberInfo;
                if (list != null && !list.isEmpty()) {
                    Message message = list.get(0);
                    int messageType = message.getMessageType();
                    V2TIMMessage v2TIMMessage = new V2TIMMessage();
                    v2TIMMessage.setMessage(message);
                    int elemType = v2TIMMessage.getElemType();
                    V2TIMUserInfo v2TIMUserInfo = null;
                    if (messageType == Message.MESSAGE_TYPE_C2C) {
                        V2TIMUserInfo v2TIMUserInfo2 = new V2TIMUserInfo();
                        v2TIMUserInfo2.setUserID(v2TIMMessage.getSender());
                        v2TIMUserInfo2.setNickName(v2TIMMessage.getNickName());
                        v2TIMUserInfo2.setFaceUrl(v2TIMMessage.getFaceUrl());
                        v2TIMUserInfo = v2TIMUserInfo2;
                        v2TIMGroupMemberInfo = null;
                    } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                        v2TIMGroupMemberInfo = new V2TIMGroupMemberInfo();
                        GroupMemberInfo groupMemberInfo = new GroupMemberInfo();
                        groupMemberInfo.setGroupID(message.getGroupID());
                        groupMemberInfo.setUserID(message.getSenderUserID());
                        groupMemberInfo.setNickname(message.getNickName());
                        groupMemberInfo.setNameCard(message.getNameCard());
                        groupMemberInfo.setFaceUrl(message.getFaceUrl());
                        groupMemberInfo.setFriendRemark(message.getFriendRemark());
                        v2TIMGroupMemberInfo.setGroupMemberInfo(groupMemberInfo);
                    } else {
                        v2TIMGroupMemberInfo = null;
                    }
                    if (elemType == 1) {
                        V2TIMTextElem textElem = v2TIMMessage.getTextElem();
                        synchronized (V2TIMManagerImpl.this.mLockObject) {
                            for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                if (messageType == Message.MESSAGE_TYPE_C2C) {
                                    v2TIMSimpleMsgListener.onRecvC2CTextMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, textElem.getText());
                                } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                    v2TIMSimpleMsgListener.onRecvGroupTextMessage(v2TIMMessage.getMsgID(), message.getGroupID(), v2TIMGroupMemberInfo, textElem.getText());
                                }
                            }
                        }
                        return;
                    }
                    if (elemType == 2) {
                        V2TIMCustomElem customElem = v2TIMMessage.getCustomElem();
                        synchronized (V2TIMManagerImpl.this.mLockObject) {
                            for (V2TIMSimpleMsgListener v2TIMSimpleMsgListener2 : V2TIMManagerImpl.this.mV2TIMSimpleMsgListenerList) {
                                if (messageType == Message.MESSAGE_TYPE_C2C) {
                                    v2TIMSimpleMsgListener2.onRecvC2CCustomMessage(v2TIMMessage.getMsgID(), v2TIMUserInfo, customElem.getData());
                                } else if (messageType == Message.MESSAGE_TYPE_GROUP) {
                                    v2TIMSimpleMsgListener2.onRecvGroupCustomMessage(v2TIMMessage.getMsgID(), v2TIMMessage.getGroupID(), v2TIMGroupMemberInfo, customElem.getData());
                                }
                            }
                        }
                    }
                }
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageModified(List<Message> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageReceipt(List<MessageReceipt> list) {
            }

            @Override // com.tencent.imsdk.message.MessageListener
            public void onReceiveMessageRevoked(List<MessageKey> list) {
            }
        };
        MessageCenter.getInstance().addMessageListener(this.mMessageInternalListener);
    }

    private void setBuildInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, 6017, "param is empty");
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                String optString = jSONObject.optString("buildBrand");
                String optString2 = jSONObject.optString("buildManufacturer");
                String optString3 = jSONObject.optString("buildModel");
                String optString4 = jSONObject.optString("buildVersionRelease");
                int optInt = jSONObject.optInt("buildVersionSDKInt");
                SystemUtil.setBuildBrand(optString);
                SystemUtil.setBuildManufacturer(optString2);
                SystemUtil.setBuildModel(optString3);
                SystemUtil.setBuildVersionRelease(optString4);
                SystemUtil.setBuildVersionSDKInt(optInt);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e16) {
                callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
                e16.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, 6017, "param is not string");
    }

    private void setCustomServerInfo(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        boolean z16;
        boolean z17;
        if (obj != null && (obj instanceof String)) {
            String str = (String) obj;
            if (TextUtils.isEmpty(str)) {
                callbackOnError(v2TIMValueCallback, 6017, "param is empty");
                return;
            }
            CustomServerInfo customServerInfo = new CustomServerInfo();
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("longconnectionAddressList");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                        CustomServerInfo.ServerAddress serverAddress = new CustomServerInfo.ServerAddress();
                        serverAddress.f116752ip = jSONObject2.optString("ip");
                        serverAddress.port = jSONObject2.optInt("port");
                        if (jSONObject2.has("isIPv6")) {
                            z17 = jSONObject2.optBoolean("isIPv6");
                        } else {
                            z17 = false;
                        }
                        serverAddress.isIPv6 = z17;
                        arrayList.add(serverAddress);
                    }
                    customServerInfo.longconnectionAddressList = arrayList;
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("shortconnectionAddressList");
                if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i16 = 0; i16 < optJSONArray2.length(); i16++) {
                        JSONObject jSONObject3 = optJSONArray2.getJSONObject(i16);
                        CustomServerInfo.ServerAddress serverAddress2 = new CustomServerInfo.ServerAddress();
                        serverAddress2.f116752ip = jSONObject3.optString("ip");
                        serverAddress2.port = jSONObject3.optInt("port");
                        if (jSONObject3.has("isIPv6")) {
                            z16 = jSONObject3.optBoolean("isIPv6");
                        } else {
                            z16 = false;
                        }
                        serverAddress2.isIPv6 = z16;
                        arrayList2.add(serverAddress2);
                    }
                    customServerInfo.shortconnectionAddressList = arrayList2;
                }
                customServerInfo.serverPublicKey = jSONObject.optString("serverPublicKey");
                BaseManager.getInstance().setCustomServerInfo(customServerInfo);
                callbackOnSuccess(v2TIMValueCallback, null);
                return;
            } catch (JSONException e16) {
                callbackOnError(v2TIMValueCallback, 6017, "convert param to json failed");
                e16.printStackTrace();
                return;
            }
        }
        callbackOnError(v2TIMValueCallback, 6017, "param is not string");
    }

    private void setLibraryPath(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (!(obj instanceof String)) {
            callbackOnError(v2TIMValueCallback, 6017, "param is not string");
            return;
        }
        if (BaseManager.getInstance().setLibraryPath((String) obj)) {
            callbackOnSuccess(v2TIMValueCallback, null);
        } else {
            callbackOnError(v2TIMValueCallback, 6017, "system load so library failed");
        }
    }

    private void setSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.2
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.remove(V2TIMManagerImpl.this.mIMSDKListener);
                }
                if (v2TIMSDKListener != null) {
                    V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
                }
                V2TIMManagerImpl.this.mIMSDKListener = v2TIMSDKListener;
            }
        });
    }

    private void setTestEnvironment(Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (obj != null && (obj instanceof Boolean)) {
            BaseManager.getInstance().setTestEnvironment(((Boolean) obj).booleanValue());
        }
        callbackOnSuccess(v2TIMValueCallback, null);
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.13
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mGroupListenerList.contains(v2TIMGroupListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.3
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mIMSDKListenerList.contains(v2TIMSDKListener)) {
                    return;
                }
                V2TIMManagerImpl.this.mIMSDKListenerList.add(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void addSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            if (this.mV2TIMSimpleMsgListenerList.contains(v2TIMSimpleMsgListener)) {
                return;
            }
            this.mV2TIMSimpleMsgListenerList.add(v2TIMSimpleMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void callExperimentalAPI(String str, Object obj, V2TIMValueCallback<Object> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            callbackOnError(v2TIMValueCallback, 6017, "invalid api");
            return;
        }
        if (str.equals("setCustomServerInfo")) {
            setCustomServerInfo(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setLibraryPath")) {
            setLibraryPath(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("initLocalStorage")) {
            initLocalStorage(obj, v2TIMValueCallback);
            return;
        }
        if (str.equals("setTestEnvironment")) {
            setTestEnvironment(obj, v2TIMValueCallback);
        } else if (str.equals("setBuildInfo")) {
            setBuildInfo(obj, v2TIMValueCallback);
        } else {
            callbackOnError(v2TIMValueCallback, 6017, "unsupported api");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005c, code lost:
    
        if (r4.equalsIgnoreCase(com.tencent.imsdk.v2.V2TIMManager.GROUP_TYPE_AVCHATROOM) != false) goto L26;
     */
    @Override // com.tencent.imsdk.v2.V2TIMManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createGroup(String str, String str2, String str3, V2TIMValueCallback<String> v2TIMValueCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupType is empty");
                return;
            }
            return;
        }
        if (TextUtils.isEmpty(str3)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupName is empty");
                return;
            }
            return;
        }
        if (!str.equalsIgnoreCase(V2TIMManager.GROUP_TYPE_WORK)) {
            if (!str.equalsIgnoreCase(V2TIMManager.GROUP_TYPE_MEETING)) {
                if (!str.equalsIgnoreCase("Private")) {
                    if (!str.equalsIgnoreCase("ChatRoom")) {
                        String str4 = "Public";
                        if (!str.equalsIgnoreCase("Public")) {
                            str4 = V2TIMManager.GROUP_TYPE_AVCHATROOM;
                        }
                        str = str4;
                        GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
                            @Override // com.tencent.imsdk.common.IMCallback
                            public void fail(int i3, String str5) {
                                super.fail(i3, str5);
                            }

                            @Override // com.tencent.imsdk.common.IMCallback
                            public void success(String str5) {
                                super.success((AnonymousClass15) str5);
                            }
                        });
                    }
                }
            }
            str = "ChatRoom";
            GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str5) {
                    super.fail(i3, str5);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(String str5) {
                    super.success((AnonymousClass15) str5);
                }
            });
        }
        str = "Private";
        GroupManager.getInstance().createGroup(str, str2, str3, new IMCallback<String>(v2TIMValueCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.15
            @Override // com.tencent.imsdk.common.IMCallback
            public void fail(int i3, String str5) {
                super.fail(i3, str5);
            }

            @Override // com.tencent.imsdk.common.IMCallback
            public void success(String str5) {
                super.success((AnonymousClass15) str5);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void dismissGroup(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "invalid groupID");
                return;
            }
            return;
        }
        GroupManager.getInstance().dismissGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.18
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public int getLoginStatus() {
        return BaseManager.getInstance().getLoginStatus();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getLoginUser() {
        return BaseManager.getInstance().getLoginUser();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public long getServerTime() {
        return BaseManager.getInstance().getServerTime();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void getUsersInfo(List<String> list, final V2TIMValueCallback<List<V2TIMUserFullInfo>> v2TIMValueCallback) {
        if (list != null && list.size() != 0) {
            RelationshipManager.getInstance().getUsersInfo(list, new IMCallback<List<UserInfo>>(new V2TIMValueCallback<List<UserInfo>>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.19
                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onError(int i3, String str) {
                    V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                    if (v2TIMValueCallback2 != null) {
                        v2TIMValueCallback2.onError(i3, str);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMValueCallback
                public void onSuccess(List<UserInfo> list2) {
                    if (v2TIMValueCallback != null) {
                        ArrayList arrayList = new ArrayList();
                        for (UserInfo userInfo : list2) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            arrayList.add(v2TIMUserFullInfo);
                        }
                        v2TIMValueCallback.onSuccess(arrayList);
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.20
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(List<UserInfo> list2) {
                    super.success((AnonymousClass20) list2);
                }
            });
        } else if (v2TIMValueCallback != null) {
            v2TIMValueCallback.onError(6017, "invalid userIDList");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String getVersion() {
        return BaseManager.getInstance().getVersion();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i3, V2TIMSDKConfig v2TIMSDKConfig) {
        return initSDK(context, i3, v2TIMSDKConfig, null);
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void joinGroup(String str, String str2, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "invalid groupID");
                return;
            }
            return;
        }
        GroupManager.getInstance().joinGroup(str, str2, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.16
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void login(String str, String str2, final V2TIMCallback v2TIMCallback) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            BaseManager.getInstance().login(str, str2, new IMCallback(new V2TIMCallback() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.5
                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onError(int i3, String str3) {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onError(i3, str3);
                    }
                }

                @Override // com.tencent.imsdk.v2.V2TIMCallback
                public void onSuccess() {
                    V2TIMCallback v2TIMCallback2 = v2TIMCallback;
                    if (v2TIMCallback2 != null) {
                        v2TIMCallback2.onSuccess();
                    }
                }
            }) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.6
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str3) {
                    super.fail(i3, str3);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else {
            v2TIMCallback.onError(6017, "userID or userSig is empty");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void logout(V2TIMCallback v2TIMCallback) {
        BaseManager.getInstance().logout(new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.7
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void quitGroup(String str, V2TIMCallback v2TIMCallback) {
        if (TextUtils.isEmpty(str)) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "invalid groupID");
                return;
            }
            return;
        }
        GroupManager.getInstance().quitGroup(str, new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.17
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

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        if (v2TIMGroupListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.14
            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mGroupListenerList.remove(v2TIMGroupListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeIMSDKListener(final V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKListener == null) {
            return;
        }
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.4
            @Override // java.lang.Runnable
            public void run() {
                V2TIMManagerImpl.this.mIMSDKListenerList.remove(v2TIMSDKListener);
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void removeSimpleMsgListener(V2TIMSimpleMsgListener v2TIMSimpleMsgListener) {
        if (v2TIMSimpleMsgListener == null) {
            return;
        }
        synchronized (this.mLockObject) {
            this.mV2TIMSimpleMsgListenerList.remove(v2TIMSimpleMsgListener);
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CCustomMessage(byte[] bArr, String str, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "customData is null");
            }
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return null;
        }
        V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
        V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, str, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.9
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i3) {
            }
        });
        return createCustomMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendC2CTextMessage(String str, String str2, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "text is null");
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "userID is empty");
            }
            return null;
        }
        V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
        V2TIMMessageManager.getInstance().sendMessage(createTextMessage, str2, null, 2, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.8
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i3, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i3, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i3) {
            }
        });
        return createTextMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupCustomMessage(byte[] bArr, String str, int i3, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        int i16;
        if (bArr == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "customData is null");
                return null;
            }
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID is empty");
                return "";
            }
            return "";
        }
        V2TIMMessage createCustomMessage = V2TIMMessageManagerImpl.getInstance().createCustomMessage(bArr);
        if (i3 == 0 || (i3 != 1 && i3 != 3)) {
            i16 = 2;
        } else {
            i16 = i3;
        }
        V2TIMMessageManager.getInstance().sendMessage(createCustomMessage, null, str, i16, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.11
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i17, String str2) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i17, str2);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i17) {
            }
        });
        return createCustomMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public String sendGroupTextMessage(String str, String str2, int i3, final V2TIMValueCallback<V2TIMMessage> v2TIMValueCallback) {
        int i16;
        if (str == null) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "text is null");
                return null;
            }
            return null;
        }
        if (TextUtils.isEmpty(str2)) {
            if (v2TIMValueCallback != null) {
                v2TIMValueCallback.onError(6017, "groupID is empty");
                return "";
            }
            return "";
        }
        V2TIMMessage createTextMessage = V2TIMMessageManagerImpl.getInstance().createTextMessage(str);
        if (i3 == 0 || (i3 != 1 && i3 != 3)) {
            i16 = 2;
        } else {
            i16 = i3;
        }
        V2TIMMessageManager.getInstance().sendMessage(createTextMessage, null, str2, i16, false, new V2TIMOfflinePushInfo(), new V2TIMSendCallback<V2TIMMessage>() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.10
            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onError(int i17, String str3) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onError(i17, str3);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMValueCallback
            public void onSuccess(V2TIMMessage v2TIMMessage) {
                V2TIMValueCallback v2TIMValueCallback2 = v2TIMValueCallback;
                if (v2TIMValueCallback2 != null) {
                    v2TIMValueCallback2.onSuccess(v2TIMMessage);
                }
            }

            @Override // com.tencent.imsdk.v2.V2TIMSendCallback
            public void onProgress(int i17) {
            }
        });
        return createTextMessage.getMsgID();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setGroupListener(final V2TIMGroupListener v2TIMGroupListener) {
        IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.12
            @Override // java.lang.Runnable
            public void run() {
                if (V2TIMManagerImpl.this.mV2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.remove(V2TIMManagerImpl.this.mV2TIMGroupListener);
                }
                if (v2TIMGroupListener != null) {
                    V2TIMManagerImpl.this.mGroupListenerList.add(v2TIMGroupListener);
                }
                V2TIMManagerImpl.this.mV2TIMGroupListener = v2TIMGroupListener;
            }
        });
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void setSelfInfo(V2TIMUserFullInfo v2TIMUserFullInfo, V2TIMCallback v2TIMCallback) {
        if (v2TIMUserFullInfo == null) {
            if (v2TIMCallback != null) {
                v2TIMCallback.onError(6017, "invalid params");
                return;
            }
            return;
        }
        HashMap<String, Object> modifyParams = v2TIMUserFullInfo.getModifyParams();
        if (modifyParams != null && !modifyParams.isEmpty()) {
            RelationshipManager.getInstance().setSelfInfo(v2TIMUserFullInfo.getModifyParams(), new IMCallback(v2TIMCallback) { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.21
                @Override // com.tencent.imsdk.common.IMCallback
                public void fail(int i3, String str) {
                    super.fail(i3, str);
                }

                @Override // com.tencent.imsdk.common.IMCallback
                public void success(Object obj) {
                    super.success(obj);
                }
            });
        } else if (v2TIMCallback != null) {
            v2TIMCallback.onError(6017, "no changed info");
        }
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public void unInitSDK() {
        BaseManager.getInstance().unInitSDK();
    }

    @Override // com.tencent.imsdk.v2.V2TIMManager
    public boolean initSDK(Context context, int i3, V2TIMSDKConfig v2TIMSDKConfig, V2TIMSDKListener v2TIMSDKListener) {
        if (v2TIMSDKConfig == null) {
            v2TIMSDKConfig = new V2TIMSDKConfig();
        }
        final V2TIMLogListener logListener = v2TIMSDKConfig.getLogListener();
        boolean z16 = logListener != null;
        SDKConfig sDKConfig = new SDKConfig();
        sDKConfig.sdkAppId = i3;
        sDKConfig.logSetting.logLevel = v2TIMSDKConfig.getLogLevel();
        setSDKListener(v2TIMSDKListener);
        return BaseManager.getInstance().initSDK(context, sDKConfig, z16, new SDKListener() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1
            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectFailed(final int i16, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnectFailed(i16, str);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnectSuccess() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnectSuccess();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onConnecting() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onConnecting();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onKickedOffline() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onKickedOffline();
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onLog(final int i16, final String str) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        V2TIMLogListener v2TIMLogListener = logListener;
                        if (v2TIMLogListener != null) {
                            v2TIMLogListener.onLog(i16, str);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onSelfInfoUpdated(final UserInfo userInfo) {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        for (V2TIMSDKListener v2TIMSDKListener2 : V2TIMManagerImpl.this.mIMSDKListenerList) {
                            V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
                            v2TIMUserFullInfo.setUserInfo(userInfo);
                            v2TIMSDKListener2.onSelfInfoUpdated(v2TIMUserFullInfo);
                        }
                    }
                });
            }

            @Override // com.tencent.imsdk.manager.SDKListener
            public void onUserSigExpired() {
                IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.v2.V2TIMManagerImpl.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Iterator it = V2TIMManagerImpl.this.mIMSDKListenerList.iterator();
                        while (it.hasNext()) {
                            ((V2TIMSDKListener) it.next()).onUserSigExpired();
                        }
                    }
                });
            }
        });
    }
}
