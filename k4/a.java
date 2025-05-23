package k4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.view.ExtendImageView;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes38.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private Context f411580a;

    /* renamed from: b, reason: collision with root package name */
    private AlbumCacheData f411581b;

    /* renamed from: c, reason: collision with root package name */
    private String f411582c;

    /* renamed from: d, reason: collision with root package name */
    private View f411583d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f411584e;

    /* renamed from: f, reason: collision with root package name */
    private TextView f411585f;

    /* renamed from: g, reason: collision with root package name */
    private ImageView f411586g;

    /* renamed from: h, reason: collision with root package name */
    private ExtendImageView f411587h;

    /* renamed from: i, reason: collision with root package name */
    private ExtendImageView f411588i;

    /* renamed from: j, reason: collision with root package name */
    private String f411589j;

    /* renamed from: k, reason: collision with root package name */
    private String f411590k;

    public a(Context context, AlbumCacheData albumCacheData, String str) {
        this.f411580a = context;
        this.f411581b = albumCacheData;
        this.f411582c = str;
        e();
        g();
    }

    private void e() {
        View inflate = LayoutInflater.from(this.f411580a).inflate(this.f411581b == null ? R.layout.bhw : R.layout.bhx, (ViewGroup) null, false);
        this.f411583d = inflate;
        ExtendImageView extendImageView = (ExtendImageView) inflate.findViewById(R.id.f164259p9);
        this.f411587h = extendImageView;
        extendImageView.setForeground(R.drawable.f162170aq2);
        this.f411586g = (ImageView) this.f411583d.findViewById(R.id.hax);
        this.f411588i = (ExtendImageView) this.f411583d.findViewById(R.id.f166679hb2);
        this.f411584e = (TextView) this.f411583d.findViewById(R.id.f166677hb0);
        this.f411585f = (TextView) this.f411583d.findViewById(R.id.f166678hb1);
        AlbumCacheData albumCacheData = this.f411581b;
        if (albumCacheData != null) {
            this.f411584e.setText(albumCacheData.albumname);
            if (!TextUtils.isEmpty(this.f411581b.albumOwner)) {
                this.f411585f.setText(this.f411581b.albumOwner);
                return;
            } else {
                this.f411585f.setText(s8.f.f().g(String.valueOf(this.f411581b.ownerUin)));
                return;
            }
        }
        if (TextUtils.isEmpty(this.f411589j) || TextUtils.isEmpty(this.f411590k)) {
            return;
        }
        this.f411584e.setText(this.f411589j);
        this.f411585f.setText(this.f411590k);
    }

    private void g() {
        ImageLoader.Options options = new ImageLoader.Options();
        options.useMainThread = true;
        ImageLoader.getInstance().loadImageAsync("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_icon_disc.png", new C10632a(), options);
        if (TextUtils.isEmpty(this.f411582c)) {
            return;
        }
        ImageLoader.getInstance().loadImageAsync(this.f411582c, new b(), options);
        ImageLoader.getInstance().loadImageAsync("https://qzonestyle.gtimg.cn/qzone/phone/n/QQ-Qzone-Android/qzone_icon_big_play.png", new c((ImageView) this.f411583d.findViewById(R.id.dwq)), options);
        ImageLoader.Options options2 = new ImageLoader.Options();
        options2.useMainThread = true;
        options2.extraProcessor = new uo.a(10);
        ImageLoader.getInstance().loadImageAsync(this.f411582c, new d(), options2);
    }

    public View d() {
        return this.f411583d;
    }

    public void f(String str) {
        TextView textView = this.f411584e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: k4.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public class C10632a implements ImageLoader.ImageLoadListener {
        C10632a() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable == null || a.this.f411586g == null) {
                return;
            }
            a.this.f411586g.setImageDrawable(drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class b implements ImageLoader.ImageLoadListener {
        b() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable == null || a.this.f411588i == null) {
                return;
            }
            a.this.f411588i.setImageDrawable(drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class c implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageView f411593d;

        c(ImageView imageView) {
            this.f411593d = imageView;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            ImageView imageView;
            if (drawable == null || (imageView = this.f411593d) == null) {
                return;
            }
            imageView.setImageDrawable(drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class d implements ImageLoader.ImageLoadListener {
        d() {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (drawable == null || a.this.f411587h == null) {
                return;
            }
            a.this.f411587h.setImageDrawable(drawable);
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageCanceled(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageFailed(String str, ImageLoader.Options options) {
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageProgress(String str, float f16, ImageLoader.Options options) {
        }
    }
}
