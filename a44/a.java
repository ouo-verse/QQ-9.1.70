package a44;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010#\u001a\u00020\u001d\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016R$\u0010\u000e\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0015\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R$\u0010\u001c\u001a\u0004\u0018\u00010\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010#\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001e\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"La44/a;", "Lb74/a;", "newItemData", "", "a", "b", "", "c", "La44/g;", "La44/g;", "g", "()La44/g;", "k", "(La44/g;)V", "styleFunction", "La44/c;", "La44/c;", "e", "()La44/c;", "i", "(La44/c;)V", "requireFunction", "La44/e;", "La44/e;", "f", "()La44/e;", "j", "(La44/e;)V", "reviseFunction", "", "d", "Ljava/lang/String;", "()Ljava/lang/String;", h.F, "(Ljava/lang/String;)V", "callbackData", "<init>", "(La44/g;La44/c;La44/e;Ljava/lang/String;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements b74.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private StyleFunction styleFunction;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RequireFunction requireFunction;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ReviseFunction reviseFunction;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String callbackData;

    public a(@Nullable StyleFunction styleFunction, @Nullable RequireFunction requireFunction, @Nullable ReviseFunction reviseFunction, @NotNull String callbackData) {
        Intrinsics.checkNotNullParameter(callbackData, "callbackData");
        this.styleFunction = styleFunction;
        this.requireFunction = requireFunction;
        this.reviseFunction = reviseFunction;
        this.callbackData = callbackData;
    }

    @Override // b74.a
    public boolean a(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return false;
    }

    @Override // b74.a
    public boolean b(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return false;
    }

    @Override // b74.a
    @Nullable
    public Object c(@NotNull b74.a newItemData) {
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return null;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getCallbackData() {
        return this.callbackData;
    }

    @Nullable
    /* renamed from: e, reason: from getter */
    public final RequireFunction getRequireFunction() {
        return this.requireFunction;
    }

    @Nullable
    /* renamed from: f, reason: from getter */
    public final ReviseFunction getReviseFunction() {
        return this.reviseFunction;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final StyleFunction getStyleFunction() {
        return this.styleFunction;
    }

    public final void h(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.callbackData = str;
    }

    public final void i(@Nullable RequireFunction requireFunction) {
        this.requireFunction = requireFunction;
    }

    public final void j(@Nullable ReviseFunction reviseFunction) {
        this.reviseFunction = reviseFunction;
    }

    public final void k(@Nullable StyleFunction styleFunction) {
        this.styleFunction = styleFunction;
    }

    public /* synthetic */ a(StyleFunction styleFunction, RequireFunction requireFunction, ReviseFunction reviseFunction, String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : styleFunction, (i3 & 2) != 0 ? null : requireFunction, (i3 & 4) != 0 ? null : reviseFunction, (i3 & 8) != 0 ? "" : str);
    }
}
