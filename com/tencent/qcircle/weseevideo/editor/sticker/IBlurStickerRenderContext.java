package com.tencent.qcircle.weseevideo.editor.sticker;

import com.tencent.tavsticker.model.TAVSticker;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public interface IBlurStickerRenderContext {
    List<TAVSticker> getBlurStickers();

    boolean shouldRenderBlurSticker();
}
