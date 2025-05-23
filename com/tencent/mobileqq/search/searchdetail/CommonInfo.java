package com.tencent.mobileqq.search.searchdetail;

import com.tencent.mobileqq.transfile.filebrowser.MimeTypeParser;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u0012\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001Be\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0018\u001a\u00020\u0007\u0012\u0006\u0010\u001b\u001a\u00020\u0007\u0012\u0006\u0010!\u001a\u00020\u001c\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010&\u001a\u00020\u0007\u0012\b\b\u0002\u0010,\u001a\u00020\u0003\u0012\b\b\u0002\u0010/\u001a\u00020\u0003\u00a2\u0006\u0004\b0\u00101J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016R\u0017\u0010\f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0011\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u0010\u0010\u000bR\u0017\u0010\u0016\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0018\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u001b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u000bR\u0017\u0010!\u001a\u00020\u001c8\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u0017\u0010$\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\b\"\u0010\u0013\u001a\u0004\b#\u0010\u0015R\u0017\u0010&\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b%\u0010\n\u001a\u0004\b\u0012\u0010\u000bR\"\u0010,\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b\u0017\u0010)\"\u0004\b*\u0010+R\"\u0010/\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010(\u001a\u0004\b\u0019\u0010)\"\u0004\b.\u0010+\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/search/searchdetail/b;", "", "other", "", "equals", "", "hashCode", "", "toString", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "itemId", "b", "c", "name", "getTabContentMask", "tabContentMask", "d", "I", "getLayoutId", "()I", "layoutId", "e", "layoutContent", "f", "getExtension", MimeTypeParser.ATTR_EXTENSION, "", "g", "[B", "getByteExtension", "()[B", "byteExtension", tl.h.F, "getBizId", "bizId", "i", "traceId", "j", "Z", "()Z", "setFirstItem", "(Z)V", "isFirstItem", "k", "setLastItem", "isLastItem", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;[BILjava/lang/String;ZZ)V", "qqsearch-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.search.searchdetail.b, reason: from toString */
/* loaded from: classes18.dex */
public final /* data */ class CommonInfo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String itemId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String name;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String tabContentMask;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private final int layoutId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String layoutContent;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String extension;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final byte[] byteExtension;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final int bizId;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final String traceId;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isFirstItem;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isLastItem;

    public CommonInfo(@NotNull String itemId, @NotNull String name, @NotNull String tabContentMask, int i3, @NotNull String layoutContent, @NotNull String extension, @NotNull byte[] byteExtension, int i16, @NotNull String traceId, boolean z16, boolean z17) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(tabContentMask, "tabContentMask");
        Intrinsics.checkNotNullParameter(layoutContent, "layoutContent");
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(byteExtension, "byteExtension");
        Intrinsics.checkNotNullParameter(traceId, "traceId");
        this.itemId = itemId;
        this.name = name;
        this.tabContentMask = tabContentMask;
        this.layoutId = i3;
        this.layoutContent = layoutContent;
        this.extension = extension;
        this.byteExtension = byteExtension;
        this.bizId = i16;
        this.traceId = traceId;
        this.isFirstItem = z16;
        this.isLastItem = z17;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getItemId() {
        return this.itemId;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final String getLayoutContent() {
        return this.layoutContent;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTraceId() {
        return this.traceId;
    }

    /* renamed from: e, reason: from getter */
    public final boolean getIsFirstItem() {
        return this.isFirstItem;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CommonInfo)) {
            return false;
        }
        CommonInfo commonInfo = (CommonInfo) other;
        if (Intrinsics.areEqual(this.itemId, commonInfo.itemId) && Intrinsics.areEqual(this.name, commonInfo.name) && Intrinsics.areEqual(this.tabContentMask, commonInfo.tabContentMask) && this.layoutId == commonInfo.layoutId && Intrinsics.areEqual(this.layoutContent, commonInfo.layoutContent) && Intrinsics.areEqual(this.extension, commonInfo.extension) && Arrays.equals(this.byteExtension, commonInfo.byteExtension) && this.bizId == commonInfo.bizId && Intrinsics.areEqual(this.traceId, commonInfo.traceId)) {
            return true;
        }
        return false;
    }

    /* renamed from: f, reason: from getter */
    public final boolean getIsLastItem() {
        return this.isLastItem;
    }

    public int hashCode() {
        return super.hashCode();
    }

    @NotNull
    public String toString() {
        return "CommonInfo(itemId='" + this.itemId + "', name='" + this.name + "', tabContentMask='" + this.tabContentMask + "', layoutId=" + this.layoutId + ", extension='" + this.extension + "',bizId=" + this.bizId + ", traceId='" + this.traceId + "', isFirstItem=" + this.isFirstItem + ", isLastItem=" + this.isLastItem + ')';
    }

    public /* synthetic */ CommonInfo(String str, String str2, String str3, int i3, String str4, String str5, byte[] bArr, int i16, String str6, boolean z16, boolean z17, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i3, str4, str5, bArr, i16, (i17 & 256) != 0 ? "" : str6, (i17 & 512) != 0 ? false : z16, (i17 & 1024) != 0 ? false : z17);
    }
}
