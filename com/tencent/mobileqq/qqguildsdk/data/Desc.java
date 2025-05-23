package com.tencent.mobileqq.qqguildsdk.data;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u000b\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0014\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\f\u001a\u0004\b\u0005\u0010\u000e\"\u0004\b\u0013\u0010\u0010R\"\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u0012\u0010\b\"\u0004\b\u0015\u0010\n\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqguildsdk/data/bv;", "", "", "toString", "", "a", "I", "b", "()I", "setId", "(I)V", "id", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "title", "c", "setDesc", "desc", "setPermType", "permType", "<init>", "(ILjava/lang/String;Ljava/lang/String;I)V", "qqguild-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* renamed from: com.tencent.mobileqq.qqguildsdk.data.bv, reason: from toString */
/* loaded from: classes17.dex */
public final class Desc {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private int id;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String title;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    @NotNull
    private String desc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private int permType;

    public Desc(int i3, @NotNull String title, @NotNull String desc, int i16) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(desc, "desc");
        this.id = i3;
        this.title = title;
        this.desc = desc;
        this.permType = i16;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public final String getDesc() {
        return this.desc;
    }

    /* renamed from: b, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: c, reason: from getter */
    public final int getPermType() {
        return this.permType;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public String toString() {
        return "Desc(id=" + this.id + ", title=" + this.title + ", desc=" + this.desc + ", permType=" + this.permType + ')';
    }
}
