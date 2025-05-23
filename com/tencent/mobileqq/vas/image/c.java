package com.tencent.mobileqq.vas.image;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u001c\u0010\u0005\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/vas/image/c;", "Lcom/tencent/mobileqq/vas/image/AbsAsyncDrawable;", "Lkotlin/Function1;", "", "block", "setLoadedListener", "<init>", "()V", "vas_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public abstract class c extends AbsAsyncDrawable {
    public abstract void setLoadedListener(@NotNull Function1<? super c, Unit> block);
}
