package com.tencent.biz.qqcircle.immersive.gallery.part;

import android.view.TextureView;
import com.tencent.biz.qqcircle.immersive.part.u;
import cooperation.qqcircle.QCircleConfig;

/* loaded from: classes4.dex */
public class QFSGalleryNewUserGuideVideoPart extends u implements TextureView.SurfaceTextureListener {

    /* renamed from: com.tencent.biz.qqcircle.immersive.gallery.part.QFSGalleryNewUserGuideVideoPart$1, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ QFSGalleryNewUserGuideVideoPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            QFSGalleryNewUserGuideVideoPart.x9(null, true);
        }
    }

    /* renamed from: com.tencent.biz.qqcircle.immersive.gallery.part.QFSGalleryNewUserGuideVideoPart$2, reason: invalid class name */
    /* loaded from: classes4.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ QFSGalleryNewUserGuideVideoPart this$0;

        @Override // java.lang.Runnable
        public void run() {
            QCircleConfig.getInstance().tryGetNewUserGuideVideoAsync();
        }
    }

    static /* bridge */ /* synthetic */ void x9(QFSGalleryNewUserGuideVideoPart qFSGalleryNewUserGuideVideoPart, boolean z16) {
        throw null;
    }
}
