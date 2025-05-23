package com.tencent.mobileqq.wink.dect;

import com.gyailib.library.GYVideoClassifyResult;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0007H&J\"\u0010\n\u001a\u00020\u00052\u0018\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\tH&J\u001e\u0010\u000e\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0003H&\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/wink/dect/b;", "", "", "", "result", "", "d", "Lcom/gyailib/library/GYVideoClassifyResult;", "b", "", "a", "Ljava/lang/Exception;", "e", "msg", "c", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface b {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes21.dex */
    public static final class a {
        public static /* synthetic */ void a(b bVar, Exception exc, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    exc = null;
                }
                if ((i3 & 2) != 0) {
                    str = "";
                }
                bVar.c(exc, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onFailed");
        }
    }

    void a(@NotNull Map<String, ? extends List<String>> result);

    void b(@NotNull GYVideoClassifyResult result);

    void c(@Nullable Exception e16, @NotNull String msg2);

    void d(@NotNull List<String> result);
}
