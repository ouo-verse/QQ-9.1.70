package fs;

import android.app.Activity;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes38.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public final WeakReference<Activity> f400426a;

    /* renamed from: b, reason: collision with root package name */
    public final int f400427b;

    /* renamed from: c, reason: collision with root package name */
    public final int f400428c;

    /* renamed from: d, reason: collision with root package name */
    public final String f400429d;

    /* renamed from: e, reason: collision with root package name */
    public final float f400430e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f400431f;

    /* renamed from: g, reason: collision with root package name */
    public final int f400432g;

    /* renamed from: h, reason: collision with root package name */
    public final double f400433h;

    /* renamed from: i, reason: collision with root package name */
    public final double f400434i;

    /* renamed from: j, reason: collision with root package name */
    public final String f400435j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f400436k;

    public i(Activity activity, int i3, int i16, String str, float f16, boolean z16, int i17, double d16, double d17, String str2, boolean z17) {
        this.f400427b = i3;
        this.f400428c = i16;
        this.f400426a = new WeakReference<>(activity);
        this.f400429d = str;
        this.f400430e = f16;
        this.f400431f = z16;
        this.f400432g = i17;
        this.f400433h = d16;
        this.f400434i = d17;
        this.f400435j = str2;
        this.f400436k = z17;
    }

    public String toString() {
        return "GenerateThumbArgs{mFileDir='" + this.f400429d + "', mRatioWH=" + this.f400430e + ", mShowLastFrameThumb=" + this.f400431f + ", mOrientation=" + this.f400432g + ", mLatitude=" + this.f400433h + ", mLongitude=" + this.f400434i + ", mExistsThumbPath=" + this.f400435j + ", mThumbOk=" + this.f400436k + '}';
    }
}
