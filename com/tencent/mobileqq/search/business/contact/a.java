package com.tencent.mobileqq.search.business.contact;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import java.util.List;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J:\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\t\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0005\u001a\u00020\u00042\u001c\u0010\b\u001a\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0007\u0012\u0006\u0012\u0004\u0018\u00018\u00010\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/search/business/contact/a;", "T", "", BdhLogUtil.LogTag.Tag_Req, "Lpn2/a;", "searchRequest", "Lkotlin/Function1;", "", "mapFunc", "Ljava/util/concurrent/Future;", "b", "qqsearch-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public interface a<T> {
    @NotNull
    <R> Future<R> b(@NotNull pn2.a searchRequest, @NotNull Function1<? super List<? extends T>, ? extends R> mapFunc);
}
