package d01;

import android.widget.ImageView;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0006\b\u0086\b\u0018\u0000 \u00032\u00020\u0001:\u0001\u000bBE\u0012\u0006\u0010\u0011\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u001c\u0012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010!\u00a2\u0006\u0004\b%\u0010&J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\t\u0010\u0006\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\b\u001a\u00020\u0007H\u00d6\u0001J\u0013\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0011\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0016\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u001b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0019\u001a\u0004\b\u0012\u0010\u001aR\u0017\u0010 \u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001d\u0010\u001fR%\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0001\u0018\u00010!8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\"\u001a\u0004\b\u000b\u0010#\u00a8\u0006'"}, d2 = {"Ld01/a;", "", "", "g", tl.h.F, "", "toString", "", "hashCode", "other", "equals", "a", "Ljava/lang/String;", "f", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "src", "b", "I", "d", "()I", "requestWidth", "c", "requestHeight", "Z", "()Z", "needResize", "Landroid/widget/ImageView$ScaleType;", "e", "Landroid/widget/ImageView$ScaleType;", "()Landroid/widget/ImageView$ScaleType;", "scaleType", "", "Ljava/util/Map;", "()Ljava/util/Map;", "context", "<init>", "(Ljava/lang/String;IIZLandroid/widget/ImageView$ScaleType;Ljava/util/Map;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: d01.a, reason: from toString */
/* loaded from: classes7.dex */
public final /* data */ class HRImageLoadOption {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String src;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int requestWidth;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int requestHeight;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final boolean needResize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ImageView.ScaleType scaleType;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Map<String, Object> context;

    public HRImageLoadOption(@NotNull String src, int i3, int i16, boolean z16, @NotNull ImageView.ScaleType scaleType, @Nullable Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(scaleType, "scaleType");
        this.src = src;
        this.requestWidth = i3;
        this.requestHeight = i16;
        this.needResize = z16;
        this.scaleType = scaleType;
        this.context = map;
    }

    @Nullable
    public final Map<String, Object> a() {
        return this.context;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getNeedResize() {
        return this.needResize;
    }

    /* renamed from: c, reason: from getter */
    public final int getRequestHeight() {
        return this.requestHeight;
    }

    /* renamed from: d, reason: from getter */
    public final int getRequestWidth() {
        return this.requestWidth;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final ImageView.ScaleType getScaleType() {
        return this.scaleType;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof HRImageLoadOption) {
                HRImageLoadOption hRImageLoadOption = (HRImageLoadOption) other;
                if (!Intrinsics.areEqual(this.src, hRImageLoadOption.src) || this.requestWidth != hRImageLoadOption.requestWidth || this.requestHeight != hRImageLoadOption.requestHeight || this.needResize != hRImageLoadOption.needResize || !Intrinsics.areEqual(this.scaleType, hRImageLoadOption.scaleType) || !Intrinsics.areEqual(this.context, hRImageLoadOption.context)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    public final boolean g() {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.src, "assets://", false, 2, null);
        return startsWith$default;
    }

    public final boolean h() {
        boolean startsWith$default;
        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(this.src, "file://", false, 2, null);
        return startsWith$default;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int i3;
        int i16;
        String str = this.src;
        int i17 = 0;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        int i18 = ((((i3 * 31) + this.requestWidth) * 31) + this.requestHeight) * 31;
        boolean z16 = this.needResize;
        int i19 = z16;
        if (z16 != 0) {
            i19 = 1;
        }
        int i26 = (i18 + i19) * 31;
        ImageView.ScaleType scaleType = this.scaleType;
        if (scaleType != null) {
            i16 = scaleType.hashCode();
        } else {
            i16 = 0;
        }
        int i27 = (i26 + i16) * 31;
        Map<String, Object> map = this.context;
        if (map != null) {
            i17 = map.hashCode();
        }
        return i27 + i17;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.src = str;
    }

    @NotNull
    public String toString() {
        return "HRImageLoadOption(src=" + this.src + ", requestWidth=" + this.requestWidth + ", requestHeight=" + this.requestHeight + ", needResize=" + this.needResize + ", scaleType=" + this.scaleType + ", context=" + this.context + ")";
    }
}
