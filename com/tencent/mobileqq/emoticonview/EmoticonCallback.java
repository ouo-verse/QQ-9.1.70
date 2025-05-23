package com.tencent.mobileqq.emoticonview;

import android.graphics.drawable.Drawable;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface EmoticonCallback {
    void delete();

    void emoticonMall();

    void onHidePopup(EmoticonInfo emoticonInfo);

    boolean onLongClick(EmoticonInfo emoticonInfo);

    void onShowPopup(EmoticonInfo emoticonInfo, EmoticonInfo emoticonInfo2, Drawable drawable);

    void send();

    void send(EmoticonInfo emoticonInfo);

    void setting();
}
