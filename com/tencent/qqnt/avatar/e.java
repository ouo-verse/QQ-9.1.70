package com.tencent.qqnt.avatar;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H&J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/avatar/e;", "", "Lcom/tencent/qqnt/avatar/b;", "option", "e", "", "uid", "", "uin", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "d", "groupCode", "b", "avatar_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public interface e {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes23.dex */
    public static final class a {
        public static /* synthetic */ void a(e eVar, long j3, CoroutineScope coroutineScope, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    coroutineScope = GlobalScope.INSTANCE;
                }
                eVar.b(j3, coroutineScope);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAvatarByGroupCode");
        }

        public static /* synthetic */ void b(e eVar, String str, long j3, CoroutineScope coroutineScope, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    coroutineScope = GlobalScope.INSTANCE;
                }
                eVar.d(str, j3, coroutineScope);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadAvatarByUid");
        }
    }

    void b(long groupCode, @NotNull CoroutineScope scope);

    void d(@NotNull String uid, long uin, @NotNull CoroutineScope scope);

    @NotNull
    e e(@NotNull b option);
}
