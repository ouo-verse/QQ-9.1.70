package com.tencent.biz.qui.quitagview;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0010\u001a\u00020\t\u0012\u0006\u0010\u0018\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010#\u001a\u00020\u0002\u00a2\u0006\u0004\b$\u0010%J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0018\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0014\u0010\u001a\u001a\u0004\b\u0012\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\"\u0010#\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u001f\u001a\u0004\b\n\u0010 \"\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/biz/qui/quitagview/d;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/biz/qui/quitagview/QUITagType;", "a", "Lcom/tencent/biz/qui/quitagview/QUITagType;", "d", "()Lcom/tencent/biz/qui/quitagview/QUITagType;", "setType", "(Lcom/tencent/biz/qui/quitagview/QUITagType;)V", "type", "Lcom/tencent/biz/qui/quitagview/QUITagSize;", "b", "Lcom/tencent/biz/qui/quitagview/QUITagSize;", "c", "()Lcom/tencent/biz/qui/quitagview/QUITagSize;", "setSize", "(Lcom/tencent/biz/qui/quitagview/QUITagSize;)V", "size", "Lcom/tencent/biz/qui/quitagview/a;", "Lcom/tencent/biz/qui/quitagview/a;", "()Lcom/tencent/biz/qui/quitagview/a;", "setIcon", "(Lcom/tencent/biz/qui/quitagview/a;)V", "icon", "Ljava/lang/String;", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "content", "<init>", "(Lcom/tencent/biz/qui/quitagview/QUITagType;Lcom/tencent/biz/qui/quitagview/QUITagSize;Lcom/tencent/biz/qui/quitagview/a;Ljava/lang/String;)V", "QUITagView_debug"}, k = 1, mv = {1, 4, 2})
/* renamed from: com.tencent.biz.qui.quitagview.d, reason: from toString */
/* loaded from: classes5.dex */
public final /* data */ class QUITagViewConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private QUITagType type;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private QUITagSize size;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private QUITagIcon icon;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String content;

    public QUITagViewConfig(@NotNull QUITagType type, @NotNull QUITagSize size, @Nullable QUITagIcon qUITagIcon, @NotNull String content) {
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(content, "content");
        this.type = type;
        this.size = size;
        this.icon = qUITagIcon;
        this.content = content;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final QUITagIcon getIcon() {
        return this.icon;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final QUITagSize getSize() {
        return this.size;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final QUITagType getType() {
        return this.type;
    }

    public boolean equals(@Nullable Object other) {
        if (this != other) {
            if (other instanceof QUITagViewConfig) {
                QUITagViewConfig qUITagViewConfig = (QUITagViewConfig) other;
                if (!Intrinsics.areEqual(this.type, qUITagViewConfig.type) || !Intrinsics.areEqual(this.size, qUITagViewConfig.size) || !Intrinsics.areEqual(this.icon, qUITagViewConfig.icon) || !Intrinsics.areEqual(this.content, qUITagViewConfig.content)) {
                    return false;
                }
                return true;
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i3;
        int i16;
        int i17;
        QUITagType qUITagType = this.type;
        int i18 = 0;
        if (qUITagType != null) {
            i3 = qUITagType.hashCode();
        } else {
            i3 = 0;
        }
        int i19 = i3 * 31;
        QUITagSize qUITagSize = this.size;
        if (qUITagSize != null) {
            i16 = qUITagSize.hashCode();
        } else {
            i16 = 0;
        }
        int i26 = (i19 + i16) * 31;
        QUITagIcon qUITagIcon = this.icon;
        if (qUITagIcon != null) {
            i17 = qUITagIcon.hashCode();
        } else {
            i17 = 0;
        }
        int i27 = (i26 + i17) * 31;
        String str = this.content;
        if (str != null) {
            i18 = str.hashCode();
        }
        return i27 + i18;
    }

    @NotNull
    public String toString() {
        return "QUITagViewConfig(type=" + this.type + ", size=" + this.size + ", icon=" + this.icon + ", content=" + this.content + ")";
    }
}
