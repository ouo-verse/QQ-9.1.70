package com.tencent.mobileqq.emoticon;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.data.MessageForAniSticker;

/* compiled from: P */
/* loaded from: classes12.dex */
public interface IAniStickerAIOOperation {
    int aniStickerType();

    void getCustomMenuItem(com.tencent.mobileqq.utils.dialogutils.a aVar, MessageForAniSticker messageForAniSticker);

    void onClick(View view, MessageForAniSticker messageForAniSticker);

    boolean onMenuItemClicked(int i3, Context context, MessageForAniSticker messageForAniSticker);
}
