package com.tencent.qqnt.kernel.nativeinterface;

import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes24.dex */
public interface IKernelAvatarListener {
    void onAvatarChanged(HashMap<String, String> hashMap, AvatarSize avatarSize);

    void onAvatarChangedForUin(HashMap<Long, String> hashMap, AvatarSize avatarSize);

    void onGroupAvatarChanged(HashMap<Long, String> hashMap, AvatarSize avatarSize);

    void onGroupPortraitChanged(long j3, HashMap<Integer, String> hashMap, AvatarSize avatarSize);
}
