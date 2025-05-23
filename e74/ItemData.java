package e74;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0012\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019\u00a2\u0006\u0004\b \u0010!J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u000f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\n\u001a\u0004\b\u000e\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\n\u001a\u0004\b\u0010\u0010\fR$\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0015\"\u0004\b\u0016\u0010\u0017R*\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\t\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\""}, d2 = {"Le74/b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "name", "e", "template", "c", "placeholder", "Le74/d;", "d", "Le74/d;", "()Le74/d;", "setRequireFunction", "(Le74/d;)V", "requireFunction", "", "Le74/a;", "Ljava/util/List;", "()Ljava/util/List;", "setCallbackData", "(Ljava/util/List;)V", "callbackData", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Le74/d;Ljava/util/List;)V", "robot-business-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: e74.b, reason: from toString */
/* loaded from: classes25.dex */
public final /* data */ class ItemData {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String template;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String placeholder;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private RequireFunction requireFunction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private List<CallbackData> callbackData;

    public ItemData(@NotNull String name, @NotNull String template, @NotNull String placeholder, @Nullable RequireFunction requireFunction, @Nullable List<CallbackData> list) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(template, "template");
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        this.name = name;
        this.template = template;
        this.placeholder = placeholder;
        this.requireFunction = requireFunction;
        this.callbackData = list;
    }

    @Nullable
    public final List<CallbackData> a() {
        return this.callbackData;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getPlaceholder() {
        return this.placeholder;
    }

    @Nullable
    /* renamed from: d, reason: from getter */
    public final RequireFunction getRequireFunction() {
        return this.requireFunction;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getTemplate() {
        return this.template;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ItemData)) {
            return false;
        }
        ItemData itemData = (ItemData) other;
        if (Intrinsics.areEqual(this.name, itemData.name) && Intrinsics.areEqual(this.template, itemData.template) && Intrinsics.areEqual(this.placeholder, itemData.placeholder) && Intrinsics.areEqual(this.requireFunction, itemData.requireFunction) && Intrinsics.areEqual(this.callbackData, itemData.callbackData)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.name.hashCode() * 31) + this.template.hashCode()) * 31) + this.placeholder.hashCode()) * 31;
        RequireFunction requireFunction = this.requireFunction;
        int i3 = 0;
        if (requireFunction == null) {
            hashCode = 0;
        } else {
            hashCode = requireFunction.hashCode();
        }
        int i16 = (hashCode2 + hashCode) * 31;
        List<CallbackData> list = this.callbackData;
        if (list != null) {
            i3 = list.hashCode();
        }
        return i16 + i3;
    }

    @NotNull
    public String toString() {
        return "ItemData(name=" + this.name + ", template=" + this.template + ", placeholder=" + this.placeholder + ", requireFunction=" + this.requireFunction + ", callbackData=" + this.callbackData + ")";
    }
}
