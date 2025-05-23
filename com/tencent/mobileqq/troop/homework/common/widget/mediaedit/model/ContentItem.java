package com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u001a\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001c\u001a\u00020\u00122\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u00d6\u0003J\t\u0010\u001f\u001a\u00020\tH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u001a\u0010\u0011\u001a\u00020\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/ContentItem;", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseTextItem;", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "setContent", "contentMinHeight", "", "getContentMinHeight", "()I", "setContentMinHeight", "(I)V", "marginBottomPx", "getMarginBottomPx", "setMarginBottomPx", "notifyContentHeightOnce", "", "getNotifyContentHeightOnce", "()Z", "setNotifyContentHeightOnce", "(Z)V", "paddingPx", "getPaddingPx", "setPaddingPx", "component1", "copy", "equals", "other", "", "hashCode", "toString", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes19.dex */
public final /* data */ class ContentItem extends BaseTextItem {
    static IPatchRedirector $redirector_;

    @NotNull
    private String content;
    private int contentMinHeight;
    private int marginBottomPx;
    private boolean notifyContentHeightOnce;
    private int paddingPx;

    public ContentItem() {
        this(null, 1, 0 == true ? 1 : 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            return;
        }
        iPatchRedirector.redirect((short) 18, (Object) this);
    }

    public static /* synthetic */ ContentItem copy$default(ContentItem contentItem, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = contentItem.content;
        }
        return contentItem.copy(str);
    }

    @NotNull
    public final String component1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.content;
    }

    @NotNull
    public final ContentItem copy(@NotNull String content) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (ContentItem) iPatchRedirector.redirect((short) 14, (Object) this, (Object) content);
        }
        Intrinsics.checkNotNullParameter(content, "content");
        return new ContentItem(content);
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if ((other instanceof ContentItem) && Intrinsics.areEqual(this.content, ((ContentItem) other).content)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final String getContent() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.content;
    }

    public final int getContentMinHeight() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.contentMinHeight;
    }

    public final int getMarginBottomPx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
        }
        return this.marginBottomPx;
    }

    public final boolean getNotifyContentHeightOnce() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.notifyContentHeightOnce;
    }

    public final int getPaddingPx() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.paddingPx;
    }

    public int hashCode() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Integer) iPatchRedirector.redirect((short) 16, (Object) this)).intValue();
        }
        return this.content.hashCode();
    }

    public final void setContent(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.content = str;
        }
    }

    public final void setContentMinHeight(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, i3);
        } else {
            this.contentMinHeight = i3;
        }
    }

    public final void setMarginBottomPx(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, i3);
        } else {
            this.marginBottomPx = i3;
        }
    }

    public final void setNotifyContentHeightOnce(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.notifyContentHeightOnce = z16;
        }
    }

    public final void setPaddingPx(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, i3);
        } else {
            this.paddingPx = i3;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return "ContentItem(content=" + this.content + ")";
    }

    public ContentItem(@NotNull String content) {
        int i3;
        int i16;
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) content);
            return;
        }
        this.content = content;
        i3 = f.f296801a;
        this.contentMinHeight = i3;
        i16 = f.f296802b;
        this.paddingPx = i16;
    }

    public /* synthetic */ ContentItem(String str, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), defaultConstructorMarker);
    }
}
