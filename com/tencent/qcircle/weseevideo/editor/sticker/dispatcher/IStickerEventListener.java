package com.tencent.qcircle.weseevideo.editor.sticker.dispatcher;

import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IStickerEventListener {
    void onStickerDataChanged(TAVSticker tAVSticker, TAVStickerOperationMode tAVStickerOperationMode, float f16, float f17, float f18, float f19);

    void onStickerStatusChanged(TAVSticker tAVSticker, boolean z16, boolean z17);
}
