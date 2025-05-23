package com.tencent.qqnt.avatar.impl.engine;

import android.content.Context;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u001f\u0010\u0007\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\t\u001a\u00028\u00012\u0006\u0010\u0004\u001a\u00028\u00002\u0006\u0010\u0006\u001a\u00020\u0005H&\u00a2\u0006\u0004\b\t\u0010\bJ\b\u0010\u000b\u001a\u00020\nH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/avatar/impl/engine/a;", "K", "T", "", "key", "Landroid/content/Context;", "context", "a", "(Ljava/lang/Object;Landroid/content/Context;)Ljava/lang/Object;", "b", "", "release", "avatar_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface a<K, T> {
    T a(K key, @NotNull Context context);

    T b(K key, @NotNull Context context);

    void release();
}
