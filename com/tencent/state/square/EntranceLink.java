package com.tencent.state.square;

import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0005H\u00d6\u0001J\b\u0010\u0014\u001a\u00020\u0003H\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/state/square/EntranceLink;", "", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "", "linkType", "", "(Ljava/lang/String;I)V", "getLink", "()Ljava/lang/String;", "setLink", "(Ljava/lang/String;)V", "getLinkType", "()I", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "Companion", "square_base_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes26.dex */
public final /* data */ class EntranceLink {
    public static final int LINK_TYPE_H5 = 1;
    public static final int LINK_TYPE_SCHEME = 2;
    public static final int LINK_TYPE_TEXT = 3;
    public static final int LINK_TYPE_UN_KNOW = 0;

    @NotNull
    private String link;
    private final int linkType;

    public EntranceLink(@NotNull String link, int i3) {
        Intrinsics.checkNotNullParameter(link, "link");
        this.link = link;
        this.linkType = i3;
    }

    public static /* synthetic */ EntranceLink copy$default(EntranceLink entranceLink, String str, int i3, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            str = entranceLink.link;
        }
        if ((i16 & 2) != 0) {
            i3 = entranceLink.linkType;
        }
        return entranceLink.copy(str, i3);
    }

    @NotNull
    /* renamed from: component1, reason: from getter */
    public final String getLink() {
        return this.link;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLinkType() {
        return this.linkType;
    }

    @NotNull
    public final EntranceLink copy(@NotNull String link, int linkType) {
        Intrinsics.checkNotNullParameter(link, "link");
        return new EntranceLink(link, linkType);
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof EntranceLink) {
                EntranceLink entranceLink = (EntranceLink) other;
                if (!Intrinsics.areEqual(this.link, entranceLink.link) || this.linkType != entranceLink.linkType) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    @NotNull
    public final String getLink() {
        return this.link;
    }

    public final int getLinkType() {
        return this.linkType;
    }

    public int hashCode() {
        int i3;
        String str = this.link;
        if (str != null) {
            i3 = str.hashCode();
        } else {
            i3 = 0;
        }
        return (i3 * 31) + this.linkType;
    }

    public final void setLink(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.link = str;
    }

    @NotNull
    public String toString() {
        return "{type:" + this.linkType + ", link:" + this.link + '}';
    }
}
