package com.tencent.mobileqq.qqvideoedit.editor.hdr;

import android.opengl.EGLContext;
import androidx.annotation.NonNull;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.filter.GLSLRender;
import com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.YTHDR;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.tvkplayer.report.capability.TVKDeviceCapabilityReportConstant;
import com.tencent.tav.coremedia.TextureInfo;
import com.tencent.tavkit.ciimage.CIContext;
import com.tencent.tavkit.ciimage.CIImage;
import com.tencent.tavkit.composition.video.RenderInfo;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import fe4.a;
import fe4.b;
import java.io.File;

/* compiled from: P */
/* loaded from: classes17.dex */
public class a extends fe4.a {

    /* renamed from: c, reason: collision with root package name */
    private final String f275765c = "HDREffectNode" + Integer.toHexString(hashCode());

    /* renamed from: d, reason: collision with root package name */
    private boolean f275766d = false;

    /* renamed from: e, reason: collision with root package name */
    private long f275767e = 0;

    /* renamed from: f, reason: collision with root package name */
    private boolean f275768f = false;

    /* renamed from: g, reason: collision with root package name */
    private boolean f275769g = true;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.hdr.a$a, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    class C8435a implements a.b {

        /* renamed from: a, reason: collision with root package name */
        private YTHDR f275770a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f275771b;

        /* renamed from: c, reason: collision with root package name */
        private TextureInfo f275772c;

        /* renamed from: d, reason: collision with root package name */
        private boolean f275773d = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f275774e = false;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.hdr.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public class C8436a implements com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.a {
            C8436a() {
            }

            @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.a
            public void a(int i3) {
                if (C8435a.this.f275770a != null) {
                    synchronized (C8435a.this.f275770a) {
                        ms.a.c("HDREffectNode", "onInitError: " + C8435a.this.f275770a.v());
                    }
                    a.f(a.this);
                }
            }

            @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.youtu.a
            public void onInitSuccess() {
                if (C8435a.this.f275770a != null) {
                    synchronized (C8435a.this.f275770a) {
                        ms.a.c("HDREffectNode", "onInitSuccess: " + C8435a.this.f275770a.v());
                        C8435a.this.f275771b = true;
                        ms.a.c("HDREffectNode", "onInitSuccess: " + C8435a.this.f275770a.v() + ", mIsCallbackSuccess" + C8435a.this.f275771b);
                    }
                    a.f(a.this);
                }
            }
        }

        C8435a() {
        }

        private void e(RenderInfo renderInfo, int i3, int i16) {
            i();
            YTHDR ythdr = new YTHDR();
            this.f275770a = ythdr;
            ythdr.z(new C8436a());
            this.f275774e = g(this.f275770a, i16, i3, renderInfo.getCiContext().getRenderContext().eglContext());
        }

        private boolean g(YTHDR ythdr, int i3, int i16, EGLContext eGLContext) {
            if (ythdr == null) {
                return false;
            }
            String aEKitBaseResUnzipFinalPath = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getAEKitBaseResUnzipFinalPath();
            ms.a.f("HDREffectNode", "hdrResPath:" + aEKitBaseResUnzipFinalPath);
            if (aEKitBaseResUnzipFinalPath == null) {
                return false;
            }
            int w3 = ythdr.w(aEKitBaseResUnzipFinalPath + TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR + File.separator, QCircleSkinHelper.SKIN_CONFIG_FILE_NAME, i3, i16, 0, eGLContext);
            if (w3 != 0 && w3 != -999) {
                ms.a.c("HDREffectNode", "loadSdkModel GlobalInitSDK ret : " + w3);
                return false;
            }
            return true;
        }

        @NonNull
        private CIImage h(CIImage cIImage, RenderInfo renderInfo, int i3, int i16) {
            if (this.f275770a == null) {
                return cIImage;
            }
            TextureInfo textureInfo = this.f275772c;
            if (textureInfo == null || textureInfo.width != i3 || textureInfo.height != i16) {
                k(renderInfo, i3, i16);
            }
            renderInfo.getCiContext().convertImageToTexture(cIImage, this.f275772c);
            if (this.f275770a.v() == 0) {
                renderInfo.getCiContext().getRenderContext().makeCurrent();
            }
            YTHDR ythdr = this.f275770a;
            int i17 = this.f275772c.textureID;
            ythdr.x(i17, i17);
            return new CIImage(new TextureInfo(this.f275772c.textureID, GLSLRender.GL_TEXTURE_2D, i3, i16, 0));
        }

        private void i() {
            if (this.f275770a != null) {
                ms.a.c("HDREffectNode", "releaseHdr: ");
                this.f275770a.y();
                this.f275773d = false;
                this.f275774e = false;
                this.f275771b = false;
            }
        }

        private void j() {
            TextureInfo textureInfo = this.f275772c;
            if (textureInfo != null) {
                textureInfo.release();
                this.f275772c = null;
            }
        }

        private void k(@NonNull RenderInfo renderInfo, int i3, int i16) {
            renderInfo.getCiContext().getRenderContext().makeCurrent();
            j();
            TextureInfo newTextureInfo = CIContext.newTextureInfo(i3, i16);
            this.f275772c = newTextureInfo;
            newTextureInfo.setFormat(6408);
        }

        @Override // fe4.a.b
        public void a(fe4.b bVar, RenderInfo renderInfo) {
            boolean f16 = f();
            for (int i3 = 0; i3 < bVar.a().size(); i3++) {
                b.a aVar = bVar.a().get(i3);
                CIImage image = aVar.getImage();
                int i16 = (int) image.getSize().width;
                int i17 = (int) image.getSize().height;
                if (i16 > 0 && i17 > 0) {
                    if (f16) {
                        if (!this.f275773d) {
                            i();
                            YTHDR ythdr = new YTHDR();
                            this.f275770a = ythdr;
                            this.f275774e = g(ythdr, i17, i16, null);
                            this.f275773d = true;
                        }
                        if (this.f275774e) {
                            aVar.b(h(image, renderInfo, i16, i17));
                        }
                    } else {
                        if (!this.f275773d) {
                            e(renderInfo, i16, i17);
                            this.f275773d = true;
                        }
                        if (this.f275774e && this.f275771b) {
                            CIImage h16 = h(image, renderInfo, i16, i17);
                            if (a.this.f275767e != 1) {
                                image = h16;
                            }
                            aVar.b(image);
                        }
                    }
                }
            }
        }

        protected boolean f() {
            return a.this.f275769g;
        }

        @Override // fe4.a.b
        public boolean isNeedApply(RenderInfo renderInfo) {
            if (!a.this.f275766d) {
                a.this.f275767e = 0L;
                return false;
            }
            if (!a.this.f275768f) {
                ms.a.a("HDREffectNode", "SO\u6ca1\u6709\u52a0\u8f7d\u6210\u529f \u5c1d\u8bd5\u91cd\u65b0\u52a0\u8f7d");
                a.this.l();
                return false;
            }
            a.this.f275767e++;
            return true;
        }

        @Override // fe4.a.b
        public void release() {
            ms.a.c("HDREffectNode", "release: ");
            j();
            i();
        }
    }

    static /* bridge */ /* synthetic */ b f(a aVar) {
        aVar.getClass();
        return null;
    }

    @Override // fe4.a
    @NonNull
    public a.b a() {
        ms.a.f("HDREffectNode", "createFilter");
        return new C8435a();
    }

    @Override // com.tencent.tavkit.report.IReportable
    public String getReportKey() {
        return "HDREffectNode";
    }

    public void l() {
        if (this.f275768f) {
            return;
        }
        if (!c.a()) {
            ms.a.c("HDREffectNode", "prepareHdr hdr loaded failed");
        } else {
            this.f275768f = true;
        }
    }

    public void m(boolean z16) {
        this.f275766d = z16;
    }

    public void n(boolean z16) {
        this.f275769g = z16;
    }
}
