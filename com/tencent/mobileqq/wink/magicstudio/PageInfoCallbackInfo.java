package com.tencent.mobileqq.wink.magicstudio;

import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPicStyle;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioPrompt;
import com.tencent.mobileqq.wink.magicstudio.model.MagicStudioTip;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001Bg\u0012\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004\u0012\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004\u0012\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u0004\u0012\u0016\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0002j\b\u0012\u0004\u0012\u00020\u0019`\u0004\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u0004H\u00c6\u0003J\u0019\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u0004H\u00c6\u0003J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u0004H\u00c6\u0003J\t\u0010\u000b\u001a\u00020\nH\u00d6\u0001J\t\u0010\r\u001a\u00020\fH\u00d6\u0001J\u0013\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R'\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00030\u0002j\b\u0012\u0004\u0012\u00020\u0003`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R'\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0002j\b\u0012\u0004\u0012\u00020\u0006`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u0011\u001a\u0004\b\u0015\u0010\u0013R'\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0002j\b\u0012\u0004\u0012\u00020\b`\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013R'\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00190\u0002j\b\u0012\u0004\u0012\u00020\u0019`\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u0011\u001a\u0004\b\u001a\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/magicstudio/ab;", "", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/magicstudio/model/g;", "Lkotlin/collections/ArrayList;", "a", "Lcom/tencent/mobileqq/wink/magicstudio/model/f;", "b", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPrompt;", "c", "", "toString", "", "hashCode", "other", "", "equals", "Ljava/util/ArrayList;", "g", "()Ljava/util/ArrayList;", "magicStudioTips", "f", "magicStudioStyle", "e", "magicStudioPrompt", "Lcom/tencent/mobileqq/wink/magicstudio/model/MagicStudioPicStyle;", "d", "magicStudioPicStyles", "<init>", "(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.wink.magicstudio.ab, reason: from toString */
/* loaded from: classes21.dex */
public final /* data */ class PageInfoCallbackInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<MagicStudioTip> magicStudioTips;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<com.tencent.mobileqq.wink.magicstudio.model.f> magicStudioStyle;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<MagicStudioPrompt> magicStudioPrompt;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final ArrayList<MagicStudioPicStyle> magicStudioPicStyles;

    public PageInfoCallbackInfo(@NotNull ArrayList<MagicStudioTip> magicStudioTips, @NotNull ArrayList<com.tencent.mobileqq.wink.magicstudio.model.f> magicStudioStyle, @NotNull ArrayList<MagicStudioPrompt> magicStudioPrompt, @NotNull ArrayList<MagicStudioPicStyle> magicStudioPicStyles) {
        Intrinsics.checkNotNullParameter(magicStudioTips, "magicStudioTips");
        Intrinsics.checkNotNullParameter(magicStudioStyle, "magicStudioStyle");
        Intrinsics.checkNotNullParameter(magicStudioPrompt, "magicStudioPrompt");
        Intrinsics.checkNotNullParameter(magicStudioPicStyles, "magicStudioPicStyles");
        this.magicStudioTips = magicStudioTips;
        this.magicStudioStyle = magicStudioStyle;
        this.magicStudioPrompt = magicStudioPrompt;
        this.magicStudioPicStyles = magicStudioPicStyles;
    }

    @NotNull
    public final ArrayList<MagicStudioTip> a() {
        return this.magicStudioTips;
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.wink.magicstudio.model.f> b() {
        return this.magicStudioStyle;
    }

    @NotNull
    public final ArrayList<MagicStudioPrompt> c() {
        return this.magicStudioPrompt;
    }

    @NotNull
    public final ArrayList<MagicStudioPicStyle> d() {
        return this.magicStudioPicStyles;
    }

    @NotNull
    public final ArrayList<MagicStudioPrompt> e() {
        return this.magicStudioPrompt;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PageInfoCallbackInfo)) {
            return false;
        }
        PageInfoCallbackInfo pageInfoCallbackInfo = (PageInfoCallbackInfo) other;
        if (Intrinsics.areEqual(this.magicStudioTips, pageInfoCallbackInfo.magicStudioTips) && Intrinsics.areEqual(this.magicStudioStyle, pageInfoCallbackInfo.magicStudioStyle) && Intrinsics.areEqual(this.magicStudioPrompt, pageInfoCallbackInfo.magicStudioPrompt) && Intrinsics.areEqual(this.magicStudioPicStyles, pageInfoCallbackInfo.magicStudioPicStyles)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final ArrayList<com.tencent.mobileqq.wink.magicstudio.model.f> f() {
        return this.magicStudioStyle;
    }

    @NotNull
    public final ArrayList<MagicStudioTip> g() {
        return this.magicStudioTips;
    }

    public int hashCode() {
        return (((((this.magicStudioTips.hashCode() * 31) + this.magicStudioStyle.hashCode()) * 31) + this.magicStudioPrompt.hashCode()) * 31) + this.magicStudioPicStyles.hashCode();
    }

    @NotNull
    public String toString() {
        return "PageInfoCallbackInfo(magicStudioTips=" + this.magicStudioTips + ", magicStudioStyle=" + this.magicStudioStyle + ", magicStudioPrompt=" + this.magicStudioPrompt + ", magicStudioPicStyles=" + this.magicStudioPicStyles + ")";
    }
}
