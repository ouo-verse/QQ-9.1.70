package com.tencent.mobileqq.emoticon;

import java.util.List;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface ISogouEmoji {
    void onDestroy();

    void pullMultipleEmojiKey(List<String> list);

    void trySend(int i3, String str);
}
