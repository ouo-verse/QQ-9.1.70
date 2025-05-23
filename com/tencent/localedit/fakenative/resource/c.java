package com.tencent.localedit.fakenative.resource;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0002\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u00a2\u0006\u0004\b\r\u0010\u000eR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R%\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0003\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/localedit/fakenative/resource/c;", "", "Lkotlin/Function0;", "a", "Lkotlin/jvm/functions/Function0;", "b", "()Lkotlin/jvm/functions/Function0;", "task", "Lkotlin/Function1;", "", "Lkotlin/jvm/functions/Function1;", "()Lkotlin/jvm/functions/Function1;", "callback", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "docx_local_edit_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes7.dex */
public abstract class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Object> task;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Function1<Object, Unit> callback;

    public c(@NotNull Function0<? extends Object> task, @Nullable Function1<Object, Unit> function1) {
        Intrinsics.checkNotNullParameter(task, "task");
        this.task = task;
        this.callback = function1;
    }

    @Nullable
    public final Function1<Object, Unit> a() {
        return this.callback;
    }

    @NotNull
    public final Function0<Object> b() {
        return this.task;
    }

    public /* synthetic */ c(Function0 function0, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(function0, (i3 & 2) != 0 ? null : function1);
    }
}
