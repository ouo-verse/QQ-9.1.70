package b7;

import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import com.tencent.component.media.image.ImageLoader;

/* compiled from: P */
/* loaded from: classes39.dex */
public abstract class g<JsonData> extends e15.f implements ImageLoader.ImageLoadListener, View.OnClickListener {
    protected long C;
    protected x6.a D;

    public g(String str, View view) {
        super(str, view);
        v();
    }

    abstract void A(JsonData jsondata);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // e15.f
    public void q(String str, String str2) {
        super.q(str, str2);
        if (u().equals(str)) {
            y(str2);
        }
    }

    abstract String u();

    abstract void v();

    abstract JsonData w(String str);

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(int i3, Object obj) {
        Message obtain = Message.obtain();
        obtain.obj = obj;
        obtain.what = i3;
        this.f395368f.sendMessage(obtain);
    }

    public void y(String str) {
        JsonData w3 = w(str);
        if (w3 != null) {
            A(w3);
        }
    }

    public void z(long j3, x6.a aVar) {
        this.C = j3;
        this.D = aVar;
    }

    @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
    public void onImageLoaded(String str, Drawable drawable, ImageLoader.Options options) {
        if (drawable != null) {
            x(1, drawable);
        }
    }

    public void onClick(View view) {
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
