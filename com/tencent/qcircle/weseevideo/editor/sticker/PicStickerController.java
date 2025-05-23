package com.tencent.qcircle.weseevideo.editor.sticker;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.qcircle.tavcut.session.config.StickerEditViewIconConfig;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsPicStickerContentView;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerContentView;
import com.tencent.qcircle.weseevideo.editor.sticker.view.WsStickerEditView;
import com.tencent.tavsticker.core.TAVStickerContext;
import java.util.Iterator;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes22.dex */
public class PicStickerController extends StickerController {
    private int containerHeight;
    private int containerWidth;

    public PicStickerController(Context context, @Nullable StickerEditViewIconConfig stickerEditViewIconConfig) {
        super(context, stickerEditViewIconConfig);
        this.containerHeight = -1;
        this.containerWidth = -1;
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.StickerController
    public void checkContainerSize(ViewGroup viewGroup) {
        super.checkContainerSize(viewGroup);
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        int i3 = layoutParams.width;
        if (i3 != this.containerWidth || layoutParams.height != this.containerHeight) {
            this.containerWidth = i3;
            this.containerHeight = layoutParams.height;
            WsStickerContentView wsStickerContentView = this.stickerContentView;
            if (wsStickerContentView instanceof WsPicStickerContentView) {
                Iterator<WsStickerEditView> it = ((WsPicStickerContentView) wsStickerContentView).getStickerEditViews().iterator();
                while (it.hasNext()) {
                    it.next().initLocation(layoutParams.width, layoutParams.height);
                }
            }
        }
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.StickerController
    protected TAVStickerContext createStickerContextInner(Context context) {
        return new WsPicStickerContext(context);
    }

    @Override // com.tencent.qcircle.weseevideo.editor.sticker.StickerController
    protected void initContentView(Context context) {
        this.stickerContentView = new WsPicStickerContentView(context);
    }

    public void setAddingMultiSticker(boolean z16) {
        TAVStickerContext tAVStickerContext = this.stickerContext;
        if (tAVStickerContext instanceof WsPicStickerContext) {
            ((WsPicStickerContext) tAVStickerContext).setAddingTemplate(z16);
        }
    }

    public void setStickersVisible() {
    }
}
