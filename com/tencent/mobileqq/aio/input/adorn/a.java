package com.tencent.mobileqq.aio.input.adorn;

import android.content.Context;
import com.tencent.aio.base.mvi.part.InputUIState;
import com.tencent.mobileqq.aio.input.adorn.e;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003J\u0017\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a2\u0006\u0004\b\u0006\u0010\u0007J<\u0010\u000f\u001a.\u0012*\u0012(\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b\u0012\u0006\b\u0000\u0012\u00028\u00000\u000bj\n\u0012\u0006\b\u0000\u0012\u00028\u0000`\u000e0\n2\u0006\u0010\t\u001a\u00020\bH&J2\u0010\u0014\u001a$\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0011j\u0002`\u00130\n2\u0006\u0010\t\u001a\u00020\u0010H&J\u001a\u0010\u0016\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\u0003\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/aio/input/adorn/a;", "Lcom/tencent/mobileqq/aio/input/adorn/e;", "V", "", "Landroid/content/Context;", "context", "b", "(Landroid/content/Context;)Lcom/tencent/mobileqq/aio/input/adorn/e;", "Lcom/tencent/mobileqq/aio/input/adorn/b;", "host", "", "Lcom/tencent/input/base/mvicompat/c;", "Lat/a;", "Lcom/tencent/aio/base/mvi/part/InputUIState;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVBDelegate;", "e", "Lcom/tencent/mobileqq/aio/input/adorn/c;", "Lcom/tencent/input/base/mvicompat/e;", "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/mobileqq/aio/input/adorn/IInputBarVMDelegate;", "c", "Lcom/tencent/aio/base/mvvm/a;", "a", "", "d", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public interface a<V extends e> {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.aio.input.adorn.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C7250a {
        @Nullable
        public static <V extends e> com.tencent.aio.base.mvvm.a<Object, Object> a(@NotNull a<V> aVar) {
            return null;
        }

        public static <V extends e> boolean b(@NotNull a<V> aVar) {
            return true;
        }
    }

    @Nullable
    com.tencent.aio.base.mvvm.a<Object, Object> a();

    @NotNull
    V b(@NotNull Context context);

    @NotNull
    List<com.tencent.input.base.mvicompat.e<at.a, InputUIState, com.tencent.aio.api.runtime.a, c>> c(@NotNull c host);

    boolean d();

    @NotNull
    List<com.tencent.input.base.mvicompat.c<at.a, InputUIState, b, ? super V>> e(@NotNull b host);
}
