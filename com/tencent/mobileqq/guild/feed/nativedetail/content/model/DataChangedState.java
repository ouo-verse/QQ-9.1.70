package com.tencent.mobileqq.guild.feed.nativedetail.content.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/nativedetail/content/model/c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "()I", "dataChangedSource", "b", "Ljava/lang/Object;", "()Ljava/lang/Object;", "payload", "<init>", "(ILjava/lang/Object;)V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.guild.feed.nativedetail.content.model.c, reason: from toString */
/* loaded from: classes13.dex */
public final /* data */ class DataChangedState {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private final int dataChangedSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @Nullable
    private final Object payload;

    public DataChangedState(int i3, @Nullable Object obj) {
        this.dataChangedSource = i3;
        this.payload = obj;
    }

    /* renamed from: a, reason: from getter */
    public final int getDataChangedSource() {
        return this.dataChangedSource;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Object getPayload() {
        return this.payload;
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataChangedState)) {
            return false;
        }
        DataChangedState dataChangedState = (DataChangedState) other;
        if (this.dataChangedSource == dataChangedState.dataChangedSource && Intrinsics.areEqual(this.payload, dataChangedState.payload)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode;
        int i3 = this.dataChangedSource * 31;
        Object obj = this.payload;
        if (obj == null) {
            hashCode = 0;
        } else {
            hashCode = obj.hashCode();
        }
        return i3 + hashCode;
    }

    @NotNull
    public String toString() {
        return "DataChangedState(dataChangedSource=" + this.dataChangedSource + ", payload=" + this.payload + ")";
    }

    public /* synthetic */ DataChangedState(int i3, Object obj, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, (i16 & 2) != 0 ? null : obj);
    }
}
