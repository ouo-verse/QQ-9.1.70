package com.tencent.tavsticker.core;

import android.view.MotionEvent;
import com.tencent.tavsticker.model.TAVSticker;
import com.tencent.tavsticker.model.TAVStickerOperationMode;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITAVStickerEventListener {
    void onDataChanged(TAVSticker tAVSticker, TAVStickerOperationMode tAVStickerOperationMode, float f16, float f17, float f18, float f19);

    void onStickerClick(TAVSticker tAVSticker, MotionEvent motionEvent);

    void onTouchBegin(TAVSticker tAVSticker, MotionEvent motionEvent);

    void onTouchEnd(TAVSticker tAVSticker, MotionEvent motionEvent);
}
