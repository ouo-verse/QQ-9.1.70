package com.tencent.ntcompose.foundation.lazy;

import com.heytap.databaseengine.model.UserInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\f\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u0006B5\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0010\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0013\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\r\u001a\u0004\b\u0012\u0010\u000fR\u0017\u0010\u0019\u001a\u00020\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001c\u001a\u00020\u000b8\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000f\u00a8\u0006 "}, d2 = {"Lcom/tencent/ntcompose/foundation/lazy/LazyListLayoutInfo;", "", "", "toString", "", "Lcom/tencent/ntcompose/foundation/lazy/c;", "a", "Ljava/util/List;", "getVisibleItemsInfo", "()Ljava/util/List;", "visibleItemsInfo", "", "b", UserInfo.SEX_FEMALE, "getViewportStartOffset", "()F", "viewportStartOffset", "c", "getViewportEndOffset", "viewportEndOffset", "", "d", "I", "getTotalItemsCount", "()I", "totalItemsCount", "e", "getViewportSize", "viewportSize", "<init>", "(Ljava/util/List;FFIF)V", "f", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class LazyListLayoutInfo {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: g, reason: collision with root package name */
    public static final int f339293g = 8;

    /* renamed from: h, reason: collision with root package name */
    private static final LazyListLayoutInfo f339294h;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final List<c> visibleItemsInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float viewportStartOffset;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final float viewportEndOffset;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int totalItemsCount;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final float viewportSize;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lcom/tencent/ntcompose/foundation/lazy/LazyListLayoutInfo$a;", "", "Lcom/tencent/ntcompose/foundation/lazy/LazyListLayoutInfo;", "EmptyLazyListLayoutInfo", "Lcom/tencent/ntcompose/foundation/lazy/LazyListLayoutInfo;", "a", "()Lcom/tencent/ntcompose/foundation/lazy/LazyListLayoutInfo;", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.ntcompose.foundation.lazy.LazyListLayoutInfo$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LazyListLayoutInfo a() {
            return LazyListLayoutInfo.f339294h;
        }

        Companion() {
        }
    }

    static {
        List emptyList;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        f339294h = new LazyListLayoutInfo(emptyList, 0.0f, 0.0f, 0, 0.0f);
    }

    public LazyListLayoutInfo(List<c> visibleItemsInfo, float f16, float f17, int i3, float f18) {
        Intrinsics.checkNotNullParameter(visibleItemsInfo, "visibleItemsInfo");
        this.visibleItemsInfo = visibleItemsInfo;
        this.viewportStartOffset = f16;
        this.viewportEndOffset = f17;
        this.totalItemsCount = i3;
        this.viewportSize = f18;
    }

    public String toString() {
        String joinToString$default;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("visibleItemsInfo:");
        joinToString$default = CollectionsKt___CollectionsKt.joinToString$default(this.visibleItemsInfo, null, null, null, 0, null, new Function1<c, CharSequence>() { // from class: com.tencent.ntcompose.foundation.lazy.LazyListLayoutInfo$toString$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(c it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.toString();
            }
        }, 31, null);
        sb5.append(joinToString$default);
        sb5.append("\nviewportStartOffset:");
        sb5.append(this.viewportStartOffset);
        sb5.append("\nviewportEndOffset:");
        sb5.append(this.viewportEndOffset);
        sb5.append("\ntotalItemsCount:");
        sb5.append(this.totalItemsCount);
        sb5.append("\nviewportSize:");
        sb5.append(this.viewportSize);
        sb5.append(TokenParser.SP);
        return sb5.toString();
    }
}
