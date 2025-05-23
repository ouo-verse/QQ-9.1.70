package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.weseevideo.editor.sticker.model.TAVStickerExKt;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.tavsticker.model.TAVSticker;

/* compiled from: P */
/* loaded from: classes22.dex */
public class StickerViewFactory {
    public static WsStickerEditView createStickerEditView(Context context, TAVSticker tAVSticker, StickerEditViewIconConfig stickerEditViewIconConfig) {
        if (tAVSticker != null && tAVSticker.getExtraBundle() != null) {
            if ("blur".equals(TAVStickerExKt.getExtraStickerType(tAVSticker))) {
                return new BlurStickerEditView(context, tAVSticker, stickerEditViewIconConfig);
            }
            return new WsStickerEditView(context, tAVSticker, stickerEditViewIconConfig);
        }
        return null;
    }
}
