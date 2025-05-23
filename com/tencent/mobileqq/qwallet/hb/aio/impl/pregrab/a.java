package com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/aio/impl/pregrab/a;", "", "", "b", "", "retCode", "", "retMsg", "a", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.qwallet.hb.aio.impl.pregrab.a$a, reason: collision with other inner class name */
    /* loaded from: classes16.dex */
    public static final class C8460a {
        public static /* synthetic */ void a(a aVar, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    str = null;
                }
                aVar.a(i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onPreGrabFinish");
        }
    }

    void a(int retCode, @Nullable String retMsg);

    void b();
}
