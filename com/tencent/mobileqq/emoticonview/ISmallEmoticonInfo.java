package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.data.Emoticon;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface ISmallEmoticonInfo {
    Drawable getBigDrawable(Context context, float f16);

    Emoticon getEmoticon();

    void setEmoticon(Emoticon emoticon);

    void setIsAPNG(boolean z16);
}
