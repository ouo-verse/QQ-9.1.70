package com.qzone.homepage.ui.Facade;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.qzone.homepage.ui.Facade.model.ConfigArea;
import com.qzone.homepage.ui.Facade.ui.FacadeView;
import com.qzone.widget.AsyncImageView;
import com.tencent.component.media.image.BitmapReference;
import com.tencent.component.media.image.ImageManager;
import com.tencent.component.media.image.drawable.ImageDrawable;
import com.tencent.component.media.image.processor.OvalProcessor;
import cooperation.qzone.util.QZLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends i {

    /* renamed from: l, reason: collision with root package name */
    public String f47582l;

    /* renamed from: m, reason: collision with root package name */
    public int f47583m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f47584n;

    e() {
    }

    public static e d(ConfigArea configArea) {
        e eVar = new e();
        eVar.b(configArea);
        eVar.f47583m = configArea.contentStyle;
        eVar.f47582l = configArea.imageUrl;
        eVar.f47584n = configArea.type == 11;
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0053  */
    @Override // com.qzone.homepage.ui.Facade.i
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View c(FacadeView facadeView) {
        Bitmap decodeFile;
        int i3;
        AsyncImageView asyncImageView = new AsyncImageView(facadeView.getContext());
        int i16 = this.f47583m;
        if (i16 == 2) {
            asyncImageView.setAsyncImageProcessor(new OvalProcessor());
        } else if (i16 != 1) {
            QZLog.w("ImageRegion", "configArea imageStyl error,use default image");
        }
        if (facadeView.j() == 1) {
            File localFileByUrl = ImageManager.getLocalFileByUrl(facadeView.getContext(), this.f47582l, h.l().i());
            OvalProcessor ovalProcessor = null;
            if (localFileByUrl != null) {
                try {
                    decodeFile = BitmapFactory.decodeFile(localFileByUrl.getAbsolutePath());
                } catch (OutOfMemoryError unused) {
                }
                i3 = this.f47583m;
                if (i3 != 2) {
                    ovalProcessor = new OvalProcessor();
                } else if (i3 != 1) {
                    QZLog.w("ImageRegion", "configArea imageStyl error,use default image");
                }
                Drawable imageDrawable = new ImageDrawable(BitmapReference.getBitmapReference(decodeFile));
                if (ovalProcessor != null) {
                    imageDrawable = ovalProcessor.process(imageDrawable);
                }
                asyncImageView.setImageDrawable(imageDrawable);
            }
            decodeFile = null;
            i3 = this.f47583m;
            if (i3 != 2) {
            }
            Drawable imageDrawable2 = new ImageDrawable(BitmapReference.getBitmapReference(decodeFile));
            if (ovalProcessor != null) {
            }
            asyncImageView.setImageDrawable(imageDrawable2);
        } else {
            asyncImageView.setAsyncImage(this.f47582l);
        }
        asyncImageView.setScaleType(ImageView.ScaleType.FIT_XY);
        return asyncImageView;
    }
}
