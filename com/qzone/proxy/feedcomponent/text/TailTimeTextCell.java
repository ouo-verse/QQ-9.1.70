package com.qzone.proxy.feedcomponent.text;

import android.graphics.Paint;
import android.graphics.Shader;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\u000f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\nH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/qzone/proxy/feedcomponent/text/TailTimeTextCell;", "Lcom/qzone/proxy/feedcomponent/text/InnerOperateTextCell;", "type", "", "text", "", "(ILjava/lang/String;)V", "canBreak", "", "getWidth", "", "p", "Landroid/graphics/Paint;", "isUseCustomFont", CanvasView.ACTION_SET_FONT_SIZE, "", "fontSize", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class TailTimeTextCell extends InnerOperateTextCell {
    public TailTimeTextCell(int i3, String str) {
        super(i3, str);
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean canBreak() {
        return false;
    }

    public Object clone() {
        return super.clone();
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public boolean isUseCustomFont() {
        return true;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public float getWidth(Paint p16) {
        if (p16 == null) {
            return super.getWidth(p16);
        }
        Shader shader = p16.getShader();
        p16.setShader(null);
        p16.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        float textSize = p16.getTextSize();
        p16.setTextSize(this.fontSize);
        float width = super.getWidth(p16);
        p16.setTextSize(textSize);
        p16.setShader(shader);
        p16.setShadowLayer(this.mShadowRadius, this.mShadowX, this.mShadowY, this.mShadowColor);
        return width;
    }

    @Override // com.qzone.proxy.feedcomponent.text.TextCell
    public void setFontSize(Paint p16, float fontSize) {
        if (p16 == null) {
            super.setFontSize(p16, fontSize);
            return;
        }
        float textSize = p16.getTextSize();
        p16.setTextSize(fontSize);
        super.setFontSize(p16, fontSize);
        p16.setTextSize(textSize);
    }
}
