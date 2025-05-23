package com.qzone.canvasui.widget;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.qzone.module.feedcomponent.ui.AreaConst;
import com.qzone.module.feedcomponent.ui.AreaManager;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.proxy.feedcomponent.model.PictureUrl;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.ditto.area.DittoHost;
import com.tencent.ditto.shell.DittoUIEngine;
import com.tencent.ditto.shell.LayoutAttrSet;

/* compiled from: P */
/* loaded from: classes39.dex */
public class GifImageArea extends AsyncCanvasImageArea {
    private PictureItem pictureItem;

    public GifImageArea(DittoHost dittoHost, LayoutAttrSet layoutAttrSet) {
        super(dittoHost, layoutAttrSet);
    }

    private boolean drawGifMark(Canvas canvas, int i3, int i16) {
        int i17 = AreaConst.dp25;
        if (i3 <= i17) {
            return false;
        }
        int i18 = i3 - AreaConst.dp14;
        AreaManager.GIF_DRAWABLE.setBounds(i3 - i17, i18, i3, i3);
        AreaManager.GIF_DRAWABLE.draw(canvas);
        return true;
    }

    @Override // com.qzone.canvasui.widget.AsyncCanvasImageArea, com.tencent.ditto.widget.DittoImageArea, com.tencent.ditto.area.DittoArea
    public void onDraw(Canvas canvas) {
        PictureUrl pictureUrl;
        super.onDraw(canvas);
        PictureItem pictureItem = this.pictureItem;
        if (pictureItem == null || (pictureUrl = pictureItem.currentUrl) == null || pictureUrl.width <= 0 || pictureUrl.height <= 0) {
            return;
        }
        pictureUrl.width = (int) (DittoUIEngine.g().getDensity() * 80.0f);
        this.pictureItem.currentUrl.height = (int) (DittoUIEngine.g().getDensity() * 80.0f);
        PictureUrl pictureUrl2 = this.pictureItem.currentUrl;
        drawGifMark(canvas, pictureUrl2.width, pictureUrl2.height);
    }

    public void setData(PictureItem pictureItem, Drawable drawable, ImageLoader.Options options) {
        PictureUrl pictureUrl;
        this.pictureItem = pictureItem;
        if (pictureItem == null || (pictureUrl = pictureItem.currentUrl) == null || TextUtils.isEmpty(pictureUrl.url)) {
            return;
        }
        PictureUrl pictureUrl2 = pictureItem.currentUrl;
        setAsyncImage(pictureUrl2.imageUrl, pictureUrl2.url, drawable, options);
    }
}
