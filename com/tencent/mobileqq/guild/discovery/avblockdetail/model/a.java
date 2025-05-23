package com.tencent.mobileqq.guild.discovery.avblockdetail.model;

import com.tencent.luggage.wxa.c8.c;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001B;\b\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0010\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0002\u001a\u00020\u0000H\u0016R\u001a\u0010\u0006\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u00058\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\n\u0010\u0007\u001a\u0004\b\u000b\u0010\tR\"\u0010\f\u001a\u00020\u00058\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\u0007\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0011\u001a\u00020\u00108\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0015\u001a\u00020\u00108\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014\"\u0004\b\u0017\u0010\u0018\u0082\u0001\u0001\u001b\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/a;", "", "newItem", "", "getDiffPayload", "", "itemId", "Ljava/lang/String;", "getItemId", "()Ljava/lang/String;", "traceId", "getTraceId", c.G, "getPos", "setPos", "(Ljava/lang/String;)V", "", "indexPriority", "I", "getIndexPriority", "()I", "contentType", "getContentType", "setContentType", "(I)V", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II)V", "Lcom/tencent/mobileqq/guild/discovery/avblockdetail/model/GuildRecommendCardItem;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public abstract class a {
    private int contentType;
    private final int indexPriority;

    @NotNull
    private final String itemId;

    @NotNull
    private String pos;

    @NotNull
    private final String traceId;

    public /* synthetic */ a(String str, String str2, String str3, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, i3, i16);
    }

    public int getContentType() {
        return this.contentType;
    }

    @NotNull
    public List<Object> getDiffPayload(@NotNull a newItem) {
        List<Object> emptyList;
        Intrinsics.checkNotNullParameter(newItem, "newItem");
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public int getIndexPriority() {
        return this.indexPriority;
    }

    @NotNull
    public String getItemId() {
        return this.itemId;
    }

    @NotNull
    public String getPos() {
        return this.pos;
    }

    @NotNull
    public String getTraceId() {
        return this.traceId;
    }

    public void setContentType(int i3) {
        this.contentType = i3;
    }

    public void setPos(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pos = str;
    }

    a(String str, String str2, String str3, int i3, int i16) {
        this.itemId = str;
        this.traceId = str2;
        this.pos = str3;
        this.indexPriority = i3;
        this.contentType = i16;
    }

    public /* synthetic */ a(String str, String str2, String str3, int i3, int i16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? "GuildBaseItem" : str, (i17 & 2) != 0 ? "" : str2, (i17 & 4) != 0 ? "" : str3, (i17 & 8) != 0 ? 101 : i3, (i17 & 16) != 0 ? 1 : i16, null);
    }
}
