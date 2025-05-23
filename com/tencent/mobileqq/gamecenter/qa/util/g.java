package com.tencent.mobileqq.gamecenter.qa.util;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/gamecenter/qa/util/g;", "", "", "", "b", "Ljava/util/List;", "a", "()Ljava/util/List;", "REGISTER_ABTEST_LIST", "<init>", "()V", "qqgamecenter-qa-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final g f212706a = new g();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final List<String> REGISTER_ABTEST_LIST;

    static {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf("exp_gamecenter_qa_pindao_askbutton_1505_20220511");
        REGISTER_ABTEST_LIST = listOf;
    }

    g() {
    }

    @NotNull
    public final List<String> a() {
        return REGISTER_ABTEST_LIST;
    }
}
