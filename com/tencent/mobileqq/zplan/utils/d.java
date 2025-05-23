package com.tencent.mobileqq.zplan.utils;

import java.io.InputStream;
import java.io.OutputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00028\u0000H&\u00a2\u0006\u0004\b\b\u0010\tJ'\u0010\r\u001a\u00028\u0001\"\u0004\b\u0001\u0010\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00010\u000bH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/zplan/utils/d;", "K", "", "key", "Ljava/io/InputStream;", "a", "(Ljava/lang/Object;)Ljava/io/InputStream;", "Ljava/io/OutputStream;", "b", "(Ljava/lang/Object;)Ljava/io/OutputStream;", "V", "Lkotlin/Function0;", "block", "c", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public abstract class d<K> {
    public abstract InputStream a(K key);

    public abstract OutputStream b(K key);

    public abstract <V> Object c(Function0<? extends V> function0, Continuation<? super V> continuation);
}
