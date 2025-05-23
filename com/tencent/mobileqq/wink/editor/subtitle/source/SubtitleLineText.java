package com.tencent.mobileqq.wink.editor.subtitle.source;

import androidx.annotation.Keep;
import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Keep
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0015\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00d6\u0003J\t\u0010\u0010\u001a\u00020\u0011H\u00d6\u0001J\t\u0010\u0012\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0005\u001a\u00020\u00038F\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\u0007\"\u0004\b\t\u0010\u0004\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/subtitle/source/SubtitleLineText;", "Ljava/io/Serializable;", "text", "", "(Ljava/lang/String;)V", "nnText", "getNnText", "()Ljava/lang/String;", "getText", IECSearchBar.METHOD_SET_TEXT, "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final /* data */ class SubtitleLineText implements Serializable {

    @Nullable
    private String text;

    public SubtitleLineText() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ SubtitleLineText copy$default(SubtitleLineText subtitleLineText, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = subtitleLineText.text;
        }
        return subtitleLineText.copy(str);
    }

    @Nullable
    /* renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final SubtitleLineText copy(@Nullable String text) {
        return new SubtitleLineText(text);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof SubtitleLineText) && Intrinsics.areEqual(this.text, ((SubtitleLineText) other).text)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getNnText() {
        String str = this.text;
        if (str == null) {
            return "";
        }
        Intrinsics.checkNotNull(str);
        return str;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public final void setText(@Nullable String str) {
        this.text = str;
    }

    @NotNull
    public String toString() {
        return "SubtitleLineText(text=" + this.text + ")";
    }

    public SubtitleLineText(@Nullable String str) {
        this.text = str;
    }

    public /* synthetic */ SubtitleLineText(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? null : str);
    }
}
