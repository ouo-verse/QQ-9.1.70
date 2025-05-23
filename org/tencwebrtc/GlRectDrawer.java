package org.tencwebrtc;

import org.tencwebrtc.GlGenericDrawer;

/* compiled from: P */
/* loaded from: classes29.dex */
public class GlRectDrawer extends GlGenericDrawer {
    private static final String FRAGMENT_SHADER = "void main() {\n  gl_FragColor = sample(tc);\n}\n";

    public GlRectDrawer() {
        super(FRAGMENT_SHADER, new ShaderCallbacks());
    }

    @Override // org.tencwebrtc.GlGenericDrawer, org.tencwebrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawOes(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27) {
        super.drawOes(i3, fArr, i16, i17, i18, i19, i26, i27);
    }

    @Override // org.tencwebrtc.GlGenericDrawer, org.tencwebrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawRgb(int i3, float[] fArr, int i16, int i17, int i18, int i19, int i26, int i27) {
        super.drawRgb(i3, fArr, i16, i17, i18, i19, i26, i27);
    }

    @Override // org.tencwebrtc.GlGenericDrawer, org.tencwebrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void drawYuv(int[] iArr, float[] fArr, int i3, int i16, int i17, int i18, int i19, int i26) {
        super.drawYuv(iArr, fArr, i3, i16, i17, i18, i19, i26);
    }

    @Override // org.tencwebrtc.GlGenericDrawer, org.tencwebrtc.RendererCommon.GlDrawer
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    private static class ShaderCallbacks implements GlGenericDrawer.ShaderCallbacks {
        ShaderCallbacks() {
        }

        @Override // org.tencwebrtc.GlGenericDrawer.ShaderCallbacks
        public void onNewShader(GlShader glShader) {
        }

        @Override // org.tencwebrtc.GlGenericDrawer.ShaderCallbacks
        public void onPrepareShader(GlShader glShader, float[] fArr, int i3, int i16, int i17, int i18) {
        }
    }
}
