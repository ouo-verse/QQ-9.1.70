package com.tencent.tavsticker.core;

/* compiled from: P */
/* loaded from: classes26.dex */
public interface ITAVStickerContextObserver {
    void onCurrentStickerStateChanged(TAVStickerContext tAVStickerContext, boolean z16);

    void onStickerActive(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView);

    void onStickerAdd(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView);

    void onStickerListChanged(TAVStickerContext tAVStickerContext);

    void onStickerRemove(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView);

    void onStickerResign(TAVStickerContext tAVStickerContext, TAVStickerEditView tAVStickerEditView);
}
