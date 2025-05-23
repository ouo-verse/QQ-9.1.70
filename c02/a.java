package c02;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010R#\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R#\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R#\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0005\u001a\u0004\b\r\u0010\u0007\u00a8\u0006\u0011"}, d2 = {"Lc02/a;", "", "Lkotlin/Pair;", "", "b", "Lkotlin/Pair;", "getMemberSetAdmin", "()Lkotlin/Pair;", "MemberSetAdmin", "c", "getMemberUnSetAdmin", "MemberUnSetAdmin", "d", "a", "MemberRemoveUser", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final a f30204a = new a();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pair<String, String> MemberSetAdmin = TuplesKt.to("sgrp_member_op_result", "1");

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pair<String, String> MemberUnSetAdmin = TuplesKt.to("sgrp_member_op_result", "2");

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Pair<String, String> MemberRemoveUser = TuplesKt.to("sgrp_member_op_result", "3");

    a() {
    }

    @NotNull
    public final Pair<String, String> a() {
        return MemberRemoveUser;
    }
}
