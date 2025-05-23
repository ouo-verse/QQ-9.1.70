package com.tencent.mobileqq.shortvideo.mtveffects;

import android.graphics.RectF;
import com.tencent.mobileqq.shortvideo.mtveffects.MTVBaseFilter;
import com.tencent.ttpic.openapi.filter.RenderBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class MTV1TopLayerRender extends LayerRenderBase {
    public static final int MATERIAL_ID_DOV_TEXT = 0;
    public static final int MATERIAL_ID_TODAY_TEXT = 1;
    private MTVBaseFilter.TextParam mDovParam;
    private HorizontialGlitchFilter mFilter;
    private MTVBaseFilter.TextParam mTodayParam;

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public void onSurfaceChanged(int i3, int i16) {
        super.onSurfaceChanged(i3, i16);
        if (i3 != 0 && i16 != 0) {
            HorizontialGlitchFilter horizontialGlitchFilter = this.mFilter;
            if (horizontialGlitchFilter != null) {
                horizontialGlitchFilter.onOutputSizeChanged(i3, i16);
                return;
            }
            HorizontialGlitchFilter horizontialGlitchFilter2 = new HorizontialGlitchFilter();
            this.mFilter = horizontialGlitchFilter2;
            horizontialGlitchFilter2.init();
            this.mFilter.onOutputSizeChanged(getWidth(), getHeight());
        }
    }

    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    public void onSurfaceDestroy() {
        super.onSurfaceDestroy();
        HorizontialGlitchFilter horizontialGlitchFilter = this.mFilter;
        if (horizontialGlitchFilter != null) {
            horizontialGlitchFilter.destroy();
            this.mFilter = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0065 A[RETURN] */
    @Override // com.tencent.mobileqq.shortvideo.mtveffects.LayerRenderBase
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int process(RenderBuffer renderBuffer, int i3, float[] fArr, float[] fArr2) {
        boolean z16;
        MTVBaseFilter.TextParam textParam;
        HorizontialGlitchFilter horizontialGlitchFilter;
        int i16;
        int materialTextureID;
        RectF materialArea;
        MTVBaseFilter.TextParam textParam2;
        renderBuffer.bind();
        MTVBaseFilter.TextParam textParam3 = this.mDovParam;
        boolean z17 = true;
        if (textParam3 != null && textParam3.mShow) {
            HorizontialGlitchFilter horizontialGlitchFilter2 = this.mFilter;
            int i17 = textParam3.mGlitchID;
            int materialTextureID2 = getMaterialTextureID();
            RectF materialArea2 = getMaterialArea(0);
            MTVBaseFilter.TextParam textParam4 = this.mDovParam;
            if (horizontialGlitchFilter2.process(i17, materialTextureID2, materialArea2, textParam4.mRect, textParam4.mChangeColor, textParam4.mColor, fArr, fArr2)) {
                z16 = true;
                textParam = this.mTodayParam;
                if (textParam != null && textParam.mShow) {
                    horizontialGlitchFilter = this.mFilter;
                    i16 = textParam.mGlitchID;
                    materialTextureID = getMaterialTextureID();
                    materialArea = getMaterialArea(1);
                    textParam2 = this.mTodayParam;
                    if (!horizontialGlitchFilter.process(i16, materialTextureID, materialArea, textParam2.mRect, textParam2.mChangeColor, textParam2.mColor, fArr, fArr2) && !z16) {
                        z17 = false;
                    }
                    z16 = z17;
                }
                renderBuffer.unbind();
                if (!z16) {
                    return renderBuffer.getTexId();
                }
                return -1;
            }
        }
        z16 = false;
        textParam = this.mTodayParam;
        if (textParam != null) {
            horizontialGlitchFilter = this.mFilter;
            i16 = textParam.mGlitchID;
            materialTextureID = getMaterialTextureID();
            materialArea = getMaterialArea(1);
            textParam2 = this.mTodayParam;
            if (!horizontialGlitchFilter.process(i16, materialTextureID, materialArea, textParam2.mRect, textParam2.mChangeColor, textParam2.mColor, fArr, fArr2)) {
                z17 = false;
            }
            z16 = z17;
        }
        renderBuffer.unbind();
        if (!z16) {
        }
    }

    public void updateData(MTVBaseFilter.TextParam textParam, MTVBaseFilter.TextParam textParam2) {
        this.mDovParam = textParam;
        this.mTodayParam = textParam2;
    }
}
