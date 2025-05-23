package g94;

import android.content.Context;
import com.tencent.sqshow.zootopia.nativeui.data.OrientationMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lg94/a;", "Lg94/g;", "", "d", "", "g", "f", "Landroid/content/Context;", "context", "Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;", "orientationMode", "<init>", "(Landroid/content/Context;Lcom/tencent/sqshow/zootopia/nativeui/data/OrientationMode;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a extends g {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, OrientationMode orientationMode) {
        super(context, orientationMode);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(orientationMode, "orientationMode");
    }

    @Override // g94.g
    public float d() {
        if (getIsBigPic()) {
            return super.d() + (f() - super.f());
        }
        return super.d();
    }

    @Override // g94.g
    public int f() {
        if (getIsBigPic()) {
            return super.f() * 2;
        }
        return super.f();
    }

    @Override // g94.g
    public int g() {
        if (getIsBigPic()) {
            return (int) (super.g() * 1.2f);
        }
        return super.g();
    }
}
