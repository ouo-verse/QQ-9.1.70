package com.tencent.qcircle.tavcut.session.callback;

import com.tencent.qcircle.tavcut.bean.TextEditorData;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface StickerOperationCallback {
    void onAddStickerDone(String str);

    void onDeleteButtonClick(String str);

    void onStickerClick(TextEditorData textEditorData);

    void onStickerMoving(String str);

    void onStickerOutsideClick();

    void onStickerSelect(TextEditorData textEditorData);

    void onStickerTouchEnd(TextEditorData textEditorData);

    void onStickerTouchStart(TextEditorData textEditorData);

    void onTextEditButtonClick(TextEditorData textEditorData);

    void onUpdateTextStickerDone(String str);
}
