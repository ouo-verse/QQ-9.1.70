package g03;

import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import com.tencent.qqmini.miniapp.widget.CanvasView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0011\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-R\u0017\u0010\u0007\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\n\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u001a\u0010\r\u001a\u00020\u00028\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u000e8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\b\u0010\u0011R\"\u0010\u0019\u001a\u00020\u00138\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u000b\u0010 \"\u0004\b!\u0010\"R$\u0010%\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b$\u0010\u0006\"\u0004\b\u001e\u0010\u001bR\"\u0010(\u001a\u00020\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b!\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b&\u0010'R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b)\u0010\u0006\"\u0004\b*\u0010\u001b\u00a8\u0006."}, d2 = {"Lg03/a;", "", "", "a", "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "b", "getDIY_NEW_CONFIG_TYPE", "DIY_NEW_CONFIG_TYPE", "c", "getDIY_OLD_CONFIG_TYPE", "DIY_OLD_CONFIG_TYPE", "", "d", "I", "()I", "MIN_HEIGHT_EXCLUDE_PADDING", "", "e", "Z", "()Z", h.F, "(Z)V", "isMirror", "f", "(Ljava/lang/String;)V", "align", "", "g", "[I", "()[I", "i", "([I)V", CanvasView.ACTION_RECT, "getBubbleId", "bubbleId", "j", "(I)V", "sBubbleMinHeight", "getType", "k", "type", "<init>", "()V", "vas_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public class a {

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String bubbleId;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG = IBubbleManager.INSTANCE.b() + "DiyBubbleConfig";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String DIY_NEW_CONFIG_TYPE = "diy_chartlet";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String DIY_OLD_CONFIG_TYPE = "static";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int MIN_HEIGHT_EXCLUDE_PADDING = 48;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isMirror = true;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String align = "";

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private int[] rect = new int[4];

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int sBubbleMinHeight = -1;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String type = "diy_chartlet";

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getAlign() {
        return this.align;
    }

    /* renamed from: b, reason: from getter */
    public final int getMIN_HEIGHT_EXCLUDE_PADDING() {
        return this.MIN_HEIGHT_EXCLUDE_PADDING;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final int[] getRect() {
        return this.rect;
    }

    /* renamed from: d, reason: from getter */
    public final int getSBubbleMinHeight() {
        return this.sBubbleMinHeight;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsMirror() {
        return this.isMirror;
    }

    public final void f(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.align = str;
    }

    public final void g(@Nullable String str) {
        this.bubbleId = str;
    }

    public final void h(boolean z16) {
        this.isMirror = z16;
    }

    public final void i(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.rect = iArr;
    }

    public final void j(int i3) {
        this.sBubbleMinHeight = i3;
    }

    public final void k(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.type = str;
    }
}
