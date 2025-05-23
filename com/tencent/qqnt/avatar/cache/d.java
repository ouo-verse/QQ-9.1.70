package com.tencent.qqnt.avatar.cache;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J)\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00028\u00002\b\b\u0002\u0010\u0007\u001a\u00020\u0006H&\u00a2\u0006\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/avatar/cache/d;", "T", "", "", "key", "resource", "", "highPriority", "", "a", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "avatar_util_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface d<T> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(d dVar, String str, Object obj, boolean z16, int i3, Object obj2) {
            if (obj2 == null) {
                if ((i3 & 4) != 0) {
                    z16 = false;
                }
                dVar.a(str, obj, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: put");
        }
    }

    void a(@NotNull String key, T resource, boolean highPriority);
}
