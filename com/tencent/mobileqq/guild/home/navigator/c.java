package com.tencent.mobileqq.guild.home.navigator;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n\u00a2\u0006\u0004\b\u000e\u0010\u000fR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\n8\u0006\u00a2\u0006\f\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\u0005\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/home/navigator/c;", "", "Lkotlin/Function1;", "Lcom/tencent/mobileqq/guild/home/navigator/d;", "", "a", "Lkotlin/jvm/functions/Function1;", "b", "()Lkotlin/jvm/functions/Function1;", "navigatorIconClick", "Lkotlin/Function0;", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "foldIconClick", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<NavigatorData, Unit> navigatorIconClick;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function0<Unit> foldIconClick;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull Function1<? super NavigatorData, Unit> navigatorIconClick, @NotNull Function0<Unit> foldIconClick) {
        Intrinsics.checkNotNullParameter(navigatorIconClick, "navigatorIconClick");
        Intrinsics.checkNotNullParameter(foldIconClick, "foldIconClick");
        this.navigatorIconClick = navigatorIconClick;
        this.foldIconClick = foldIconClick;
    }

    @NotNull
    public final Function0<Unit> a() {
        return this.foldIconClick;
    }

    @NotNull
    public final Function1<NavigatorData, Unit> b() {
        return this.navigatorIconClick;
    }
}
