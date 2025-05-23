package com.tencent.mobileqq.guild.feed.feedsquare.utils;

import com.tencent.mobileqq.guild.feed.feedsquare.utils.UIStateDataUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0014\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\n\u0010\u0011R%\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00158\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0017\u001a\u0004\b\u0013\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/n;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "b", "()Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;", "insertType", "I", "d", "()I", "scrollPos", "c", "index", "Lkotlin/Function1;", "Lij1/g;", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "predicate", "<init>", "(Lcom/tencent/mobileqq/guild/feed/feedsquare/utils/UIStateDataUtils$InsertType;IILkotlin/jvm/functions/Function1;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.feedsquare.utils.n, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class InsertFeedArgs {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private final UIStateDataUtils.InsertType insertType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private final int scrollPos;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private final int index;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Function1<ij1.g, Boolean> predicate;

    public InsertFeedArgs() {
        this(null, 0, 0, null, 15, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    @NotNull
    /* renamed from: b, reason: from getter */
    public final UIStateDataUtils.InsertType getInsertType() {
        return this.insertType;
    }

    @Nullable
    public final Function1<ij1.g, Boolean> c() {
        return this.predicate;
    }

    /* renamed from: d, reason: from getter */
    public final int getScrollPos() {
        return this.scrollPos;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof InsertFeedArgs)) {
            return false;
        }
        InsertFeedArgs insertFeedArgs = (InsertFeedArgs) other;
        if (this.insertType == insertFeedArgs.insertType && this.scrollPos == insertFeedArgs.scrollPos && this.index == insertFeedArgs.index && Intrinsics.areEqual(this.predicate, insertFeedArgs.predicate)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = ((((this.insertType.hashCode() * 31) + this.scrollPos) * 31) + this.index) * 31;
        Function1<ij1.g, Boolean> function1 = this.predicate;
        if (function1 == null) {
            hashCode = 0;
        } else {
            hashCode = function1.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @NotNull
    public String toString() {
        return "InsertFeedArgs(insertType=" + this.insertType + ", scrollPos=" + this.scrollPos + ", index=" + this.index + ", predicate=" + this.predicate + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InsertFeedArgs(@NotNull UIStateDataUtils.InsertType insertType, int i3, int i16, @Nullable Function1<? super ij1.g, Boolean> function1) {
        Intrinsics.checkNotNullParameter(insertType, "insertType");
        this.insertType = insertType;
        this.scrollPos = i3;
        this.index = i16;
        this.predicate = function1;
    }

    public /* synthetic */ InsertFeedArgs(UIStateDataUtils.InsertType insertType, int i3, int i16, Function1 function1, int i17, DefaultConstructorMarker defaultConstructorMarker) {
        this((i17 & 1) != 0 ? UIStateDataUtils.InsertType.Other : insertType, (i17 & 2) != 0 ? -1 : i3, (i17 & 4) != 0 ? 0 : i16, (i17 & 8) != 0 ? null : function1);
    }
}
