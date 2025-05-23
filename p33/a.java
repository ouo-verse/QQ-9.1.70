package p33;

import android.graphics.Bitmap;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b(\u0010)R\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0010\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u001d\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0019\u001a\u0004\b\u0003\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010!\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u0019\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR$\u0010'\u001a\u0004\u0018\u00010\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010#\u001a\u0004\b\u001e\u0010$\"\u0004\b%\u0010&\u00a8\u0006*"}, d2 = {"Lp33/a;", "", "", "a", "[I", "b", "()[I", h.F, "([I)V", NodeProps.COLORS, "", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "i", "(Ljava/lang/String;)V", "normalColor", "Lp33/b;", "Lp33/b;", "d", "()Lp33/b;", "j", "(Lp33/b;)V", "scannerData", "", "Z", "()Z", "g", "(Z)V", "bold", "e", "f", "l", "useImageShader", "Landroid/graphics/Bitmap;", "Landroid/graphics/Bitmap;", "()Landroid/graphics/Bitmap;", "k", "(Landroid/graphics/Bitmap;)V", "shaderBitmap", "<init>", "()V", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] colors = new int[0];

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String normalColor = "";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ScannerData scannerData;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean bold;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean useImageShader;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Bitmap shaderBitmap;

    /* renamed from: a, reason: from getter */
    public final boolean getBold() {
        return this.bold;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final int[] getColors() {
        return this.colors;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getNormalColor() {
        return this.normalColor;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final ScannerData getScannerData() {
        return this.scannerData;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final Bitmap getShaderBitmap() {
        return this.shaderBitmap;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getUseImageShader() {
        return this.useImageShader;
    }

    public final void g(boolean z16) {
        this.bold = z16;
    }

    public final void h(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.colors = iArr;
    }

    public final void i(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.normalColor = str;
    }

    public final void j(@Nullable ScannerData scannerData) {
        this.scannerData = scannerData;
    }

    public final void k(@Nullable Bitmap bitmap) {
        this.shaderBitmap = bitmap;
    }

    public final void l(boolean z16) {
        this.useImageShader = z16;
    }
}
