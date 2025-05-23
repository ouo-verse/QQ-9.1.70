package com.tencent.imsdk.relationship;

import com.tencent.imsdk.common.IMCallback;
import com.tencent.imsdk.common.IMContext;
import com.tencent.imsdk.manager.BaseManager;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes7.dex */
public class RelationshipManager {
    private FriendshipListener mFriendshipInternalListener;
    private FriendshipListener mFriendshipListener;

    /* compiled from: P */
    /* loaded from: classes7.dex */
    private static class RelationshipManagerHolder {
        private static final RelationshipManager relationshipManager = new RelationshipManager();

        RelationshipManagerHolder() {
        }
    }

    public static RelationshipManager getInstance() {
        return RelationshipManagerHolder.relationshipManager;
    }

    private void initFriendshipListener() {
        if (this.mFriendshipInternalListener == null) {
            this.mFriendshipInternalListener = new FriendshipListener() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1
                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnBlackListAdded(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.4
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnBlackListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnBlackListDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.5
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnBlackListDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendApplicationListAdded(final List<FriendApplication> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendApplicationListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendApplicationListDelete(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.7
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendApplicationListDelete(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendApplicationListRead() {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.8
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendApplicationListRead();
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendInfoChanged(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendInfoChanged(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendListAdded(final List<FriendInfo> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendListAdded(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnFriendListDeleted(final List<String> list) {
                    IMContext.getInstance().runOnMainThread(new Runnable() { // from class: com.tencent.imsdk.relationship.RelationshipManager.1.3
                        @Override // java.lang.Runnable
                        public void run() {
                            if (RelationshipManager.this.mFriendshipListener != null) {
                                RelationshipManager.this.mFriendshipListener.OnFriendListDeleted(list);
                            }
                        }
                    });
                }

                @Override // com.tencent.imsdk.relationship.FriendshipListener
                public void OnSelfInfoUpdated(UserInfo userInfo) {
                    BaseManager.getInstance().notifySelfInfoUpdated(userInfo);
                }
            };
        }
        nativeSetFriendshipListener(this.mFriendshipInternalListener);
    }

    public void addFriend(FriendAddApplication friendAddApplication, IMCallback<FriendOperationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeAddFriend(friendAddApplication, iMCallback);
    }

    public void addFriendsToFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeAddFriendsToFriendGroup(str, list, iMCallback);
    }

    public void addToBlackList(List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeAddToBlackList(list, iMCallback);
    }

    public void checkFriend(List<String> list, int i3, IMCallback<List<FriendCheckResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeCheckFriend(list, i3, iMCallback);
    }

    public void createFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeCreateFromGroup(str, list, iMCallback);
    }

    public void deleteFrendsFromFriendGroup(String str, List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFriendsFromFriendGroup(str, list, iMCallback);
    }

    public void deleteFriendApplication(int i3, String str, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFriendApplication(i3, str, iMCallback);
    }

    public void deleteFriendGroup(List<String> list, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFriendGroup(list, iMCallback);
    }

    public void deleteFromBlackList(List<String> list, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFromBlackList(list, iMCallback);
    }

    public void deleteFromFriendList(List<String> list, int i3, IMCallback<List<FriendOperationResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeDeleteFromFriendList(list, i3, iMCallback);
    }

    public void getBlackList(IMCallback<List<FriendInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetBlackList(iMCallback);
    }

    public void getC2CReceiveMessageOpt(List<String> list, IMCallback<List<ReceiveMessageOptInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetC2CReceiveMessageOpt(list, iMCallback);
    }

    public void getFriendApplicationList(IMCallback<FriendApplicationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendApplicationList(iMCallback);
    }

    public void getFriendGroups(List<String> list, IMCallback<List<FriendGroup>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendGroups(list, iMCallback);
    }

    public void getFriendList(IMCallback<List<FriendInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendList(iMCallback);
    }

    public void getFriendsInfo(List<String> list, IMCallback<List<FriendInfoResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetFriendsInfo(list, iMCallback);
    }

    public void getUsersInfo(List<String> list, IMCallback<List<UserInfo>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeGetUsersInfo(list, iMCallback);
    }

    public void init() {
        initFriendshipListener();
    }

    protected native void nativeAddFriend(FriendAddApplication friendAddApplication, IMCallback iMCallback);

    protected native void nativeAddFriendsToFriendGroup(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeAddToBlackList(List<String> list, IMCallback iMCallback);

    protected native void nativeCheckFriend(List<String> list, int i3, IMCallback iMCallback);

    protected native void nativeCreateFromGroup(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFriendApplication(int i3, String str, IMCallback iMCallback);

    protected native void nativeDeleteFriendGroup(List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFriendsFromFriendGroup(String str, List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFromBlackList(List<String> list, IMCallback iMCallback);

    protected native void nativeDeleteFromFriendList(List<String> list, int i3, IMCallback iMCallback);

    protected native void nativeGetBlackList(IMCallback iMCallback);

    protected native void nativeGetC2CReceiveMessageOpt(List<String> list, IMCallback<List<ReceiveMessageOptInfo>> iMCallback);

    protected native void nativeGetFriendApplicationList(IMCallback iMCallback);

    protected native void nativeGetFriendGroups(List<String> list, IMCallback iMCallback);

    protected native void nativeGetFriendList(IMCallback iMCallback);

    protected native void nativeGetFriendsInfo(List<String> list, IMCallback iMCallback);

    protected native void nativeGetUsersInfo(List<String> list, IMCallback<List<UserInfo>> iMCallback);

    protected native void nativeRenameFriendGroup(String str, String str2, IMCallback iMCallback);

    protected native void nativeResponseFriendApplication(FriendResponse friendResponse, IMCallback iMCallback);

    protected native void nativeSearchFriends(FriendSearchParam friendSearchParam, IMCallback iMCallback);

    protected native void nativeSetC2CReceiveMessageOpt(List<String> list, int i3, IMCallback iMCallback);

    protected native void nativeSetFriendApplicationRead(IMCallback iMCallback);

    protected native void nativeSetFriendInfo(String str, HashMap<String, Object> hashMap, IMCallback iMCallback);

    protected native void nativeSetFriendshipListener(FriendshipListener friendshipListener);

    protected native void nativeSetSelfInfo(HashMap<String, Object> hashMap, IMCallback iMCallback);

    public void renameFriendGroup(String str, String str2, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeRenameFriendGroup(str, str2, iMCallback);
    }

    public void responseFriendApplication(FriendResponse friendResponse, IMCallback<FriendOperationResult> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeResponseFriendApplication(friendResponse, iMCallback);
    }

    public void searchFriends(FriendSearchParam friendSearchParam, IMCallback<List<FriendInfoResult>> iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSearchFriends(friendSearchParam, iMCallback);
    }

    public void setC2CReceiveMessageOpt(List<String> list, int i3, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetC2CReceiveMessageOpt(list, i3, iMCallback);
    }

    public void setFriendApplicationRead(IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetFriendApplicationRead(iMCallback);
    }

    public void setFriendInfo(String str, HashMap<String, Object> hashMap, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetFriendInfo(str, hashMap, iMCallback);
    }

    public void setFriendshipListener(FriendshipListener friendshipListener) {
        this.mFriendshipListener = friendshipListener;
    }

    public void setSelfInfo(HashMap<String, Object> hashMap, IMCallback iMCallback) {
        if (!BaseManager.getInstance().isInited()) {
            if (iMCallback != null) {
                iMCallback.fail(6013, "sdk not init");
                return;
            }
            return;
        }
        nativeSetSelfInfo(hashMap, iMCallback);
    }
}
