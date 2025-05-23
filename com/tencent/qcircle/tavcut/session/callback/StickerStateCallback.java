package com.tencent.qcircle.tavcut.session.callback;

import com.tencent.tavsticker.core.TAVStickerContext;
import com.tencent.tavsticker.core.TAVStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface StickerStateCallback {
    void onStatusChanged(boolean z16);

    void onStickerActive();

    void onStickerAdd(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView);

    void onStickerResign(TAVSticker tAVSticker);
}
