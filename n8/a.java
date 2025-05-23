package n8;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.processor.OvalProcessor;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private ImageLoader f419476a = ImageLoader.getInstance(BaseApplication.getContext());

    /* compiled from: P */
    /* loaded from: classes38.dex */
    public interface c {
        void a(Drawable drawable);

        void b(String str);
    }

    public void a(String str, int i3, c cVar) {
        C10831a c10831a = new C10831a(cVar);
        if (str.startsWith("http")) {
            ImageLoader.Options options = new ImageLoader.Options();
            options.useMainThread = false;
            options.imageConfig = Bitmap.Config.RGB_565;
            options.clipWidth = i3;
            options.fileRootPath = g4.d.f401216a;
            Drawable loadImage = this.f419476a.loadImage(str, c10831a, options);
            if (loadImage != null) {
                cVar.a(loadImage);
                return;
            }
            return;
        }
        ImageLoader.Options obtain = ImageLoader.Options.obtain();
        obtain.useMainThread = true;
        obtain.extraProcessor = new OvalProcessor();
        obtain.clipHeight = i3;
        obtain.clipWidth = i3;
        Drawable loadImage2 = ImageLoader.getInstance().loadImage("avatar://" + str, c10831a, obtain);
        if (loadImage2 != null) {
            cVar.a(loadImage2);
        }
    }

    public void b(String str, c cVar) {
        if (str.contains(".9.png")) {
            com.qzone.util.image.c.J(str, true, new b(cVar), Bitmap.Config.ARGB_8888);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: n8.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10831a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f419477d;

        C10831a(c cVar) {
            this.f419477d = cVar;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            this.f419477d.b(str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f419477d.a(drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f419479d;

        b(c cVar) {
            this.f419479d = cVar;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
            this.f419479d.b(str);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            this.f419479d.a(drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
