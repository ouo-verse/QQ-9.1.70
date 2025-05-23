package h12;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.eh;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes14.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private static LruCache<String, Drawable> f404070a = new LruCache<>(25);

    /* renamed from: b, reason: collision with root package name */
    private static INetworkStateApi.a f404071b = new INetworkStateApi.a() { // from class: h12.b
        @Override // com.tencent.mobileqq.guild.nt.misc.api.INetworkStateApi.a
        public final void onNetworkConnect(boolean z16) {
            c.j(z16);
        }
    };

    static {
        ((INetworkStateApi) QRoute.api(INetworkStateApi.class)).addConnectStateListener(f404071b);
    }

    public static void c(String str, Drawable drawable) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f404070a.put(str, drawable);
    }

    private static void d() {
        Iterator<Map.Entry<String, Drawable>> it = f404070a.snapshot().entrySet().iterator();
        while (it.hasNext()) {
            Drawable value = it.next().getValue();
            if (value instanceof URLDrawable) {
                URLDrawable uRLDrawable = (URLDrawable) value;
                if (uRLDrawable.getStatus() == 2) {
                    uRLDrawable.restartDownload();
                }
            }
        }
    }

    private static String e(String str, int i3, String str2, boolean z16) {
        StringBuilder sb5 = new StringBuilder(str);
        if (i3 > 0) {
            sb5.append("#");
            sb5.append(i3);
            sb5.append("#");
            sb5.append(z16);
        }
        if (!TextUtils.isEmpty(str2)) {
            sb5.append("#");
            sb5.append(str2);
        }
        return sb5.toString();
    }

    public static Drawable f(Resources resources, Drawable drawable, @NonNull Bitmap.Config config, int i3) {
        Bitmap bitmap;
        if (resources == null) {
            return null;
        }
        if (drawable instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        } else {
            if (drawable instanceof URLDrawable) {
                Drawable currDrawable = ((URLDrawable) drawable).getCurrDrawable();
                if (currDrawable instanceof RegionDrawable) {
                    bitmap = ((RegionDrawable) currDrawable).getBitmap();
                }
            }
            bitmap = null;
        }
        if (bitmap == null) {
            return null;
        }
        Bitmap copy = bitmap.copy(config, true);
        eh.a(copy, i3);
        return new BitmapDrawable(resources, copy);
    }

    public static Drawable g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return f404070a.get(str);
    }

    public static Drawable h(@NonNull String str, int i3, String str2, Drawable drawable) {
        return i(str, i3, str2, drawable, false);
    }

    public static Drawable i(@NonNull String str, int i3, String str2, Drawable drawable, boolean z16) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String e16 = e(str, i3, str2, z16);
        Drawable drawable2 = f404070a.get(e16);
        if (drawable2 != null) {
            if (drawable2 instanceof URLDrawable) {
                URLDrawable uRLDrawable = (URLDrawable) drawable2;
                if (uRLDrawable.getStatus() == 2) {
                    uRLDrawable.restartDownload();
                }
            }
            return drawable2;
        }
        if (drawable == null) {
            drawable = new BitmapDrawable(QQGuildUIUtil.j(z16));
        }
        Drawable J = ch.J(str, i3, drawable, z16);
        Drawable[] drawableArr = {J};
        if (J == null) {
            drawableArr[0] = drawable;
        } else {
            k(e16, drawableArr);
        }
        f404070a.put(e16, drawableArr[0]);
        return drawableArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void j(boolean z16) {
        if (z16) {
            d();
        }
    }

    private static void k(String str, Drawable[] drawableArr) {
        Drawable drawable = drawableArr[0];
        if (drawable instanceof URLDrawable) {
            ((URLDrawable) drawable).setURLDrawableListener(new a(drawableArr, str));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes14.dex */
    public class a implements URLDrawable.URLDrawableListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable[] f404072d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f404073e;

        a(Drawable[] drawableArr, String str) {
            this.f404072d = drawableArr;
            this.f404073e = str;
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            QLog.e("GuildURLDrawableUtil", 1, "onLoadFailed url: " + this.f404073e + ", size: " + c.f404070a.size());
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            Drawable[] drawableArr = this.f404072d;
            drawableArr[0] = ((URLDrawable) drawableArr[0]).getCurrDrawable();
            c.f404070a.put(this.f404073e, this.f404072d[0]);
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
        }
    }
}
