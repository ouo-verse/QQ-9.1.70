package k4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.component.media.image.view.ExtendImageView;
import com.tencent.mobileqq.R;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    private Context f411659a;

    /* renamed from: b, reason: collision with root package name */
    private AlbumCacheData f411660b;

    /* renamed from: c, reason: collision with root package name */
    private ArrayList<String> f411661c;

    /* renamed from: d, reason: collision with root package name */
    private View f411662d;

    /* renamed from: e, reason: collision with root package name */
    private int f411663e = 3;

    /* renamed from: f, reason: collision with root package name */
    private ExtendImageView[] f411664f = new ExtendImageView[3];

    public i(Context context, AlbumCacheData albumCacheData, ArrayList<String> arrayList) {
        this.f411659a = context;
        this.f411660b = albumCacheData;
        this.f411661c = arrayList;
        c();
        d();
    }

    private void c() {
        View inflate = LayoutInflater.from(this.f411659a).inflate(R.layout.biz, (ViewGroup) null, false);
        this.f411662d = inflate;
        this.f411664f[0] = (ExtendImageView) inflate.findViewById(R.id.f164291r5);
        this.f411664f[1] = (ExtendImageView) this.f411662d.findViewById(R.id.f164292r6);
        this.f411664f[2] = (ExtendImageView) this.f411662d.findViewById(R.id.f164293r7);
    }

    private void d() {
        ArrayList<String> arrayList = this.f411661c;
        if (arrayList == null || arrayList.size() < this.f411663e) {
            return;
        }
        ImageLoader.Options options = new ImageLoader.Options();
        options.useMainThread = true;
        for (int i3 = 0; i3 < this.f411663e; i3++) {
            ImageLoader.getInstance().loadImageAsync(this.f411661c.get(i3), new a(i3), options);
        }
    }

    public View b() {
        return this.f411662d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public class a implements ImageLoader.ImageLoadListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f411665d;

        a(int i3) {
            this.f411665d = i3;
        }

        @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
        public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
            if (i.this.f411664f[this.f411665d] == null || drawable == null) {
                return;
            }
            i.this.f411664f[this.f411665d].setImageDrawable(drawable);
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
