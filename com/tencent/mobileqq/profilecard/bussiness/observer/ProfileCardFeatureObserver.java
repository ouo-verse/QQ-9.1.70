package com.tencent.mobileqq.profilecard.bussiness.observer;

import com.tencent.mobileqq.app.BusinessObserver;

/* loaded from: classes35.dex */
public class ProfileCardFeatureObserver implements BusinessObserver {
    public static final int TYPE_GET_FRIEND_SOURCE = 1001;
    private static final int TYPE_START_DEFINE = 1000;

    private void updateGetFriendSource(boolean z16, Object obj) {
        String str;
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length >= 2) {
                ((Integer) objArr[0]).intValue();
                str = (String) objArr[1];
                onGetFriendSource(z16, str);
            }
        }
        str = "";
        onGetFriendSource(z16, str);
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int i3, boolean z16, Object obj) {
        if (i3 != 1001) {
            return;
        }
        updateGetFriendSource(z16, obj);
    }

    protected void onGetFriendSource(boolean z16, String str) {
    }
}
