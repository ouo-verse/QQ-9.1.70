package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u001a\u0010\b\u001a\u00020\u00028\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0004\u001a\u0004\b\u0003\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/z;", "", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Photo;", "a", "Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Photo;", "impl", "b", "()Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Photo;", "photo", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class z {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Photo impl;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Photo photo;

    public z() {
        Photo photo = new Photo();
        this.impl = photo;
        this.photo = photo;
    }

    @NotNull
    /* renamed from: a, reason: from getter */
    public Photo getPhoto() {
        return this.photo;
    }
}
