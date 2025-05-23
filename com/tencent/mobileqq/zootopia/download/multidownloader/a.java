package com.tencent.mobileqq.zootopia.download.multidownloader;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J&\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/zootopia/download/multidownloader/a;", "", "", "isSuccess", "", "errorCode", "", "errorMessage", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface a {
    void a(boolean isSuccess, int errorCode, String errorMessage);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: com.tencent.mobileqq.zootopia.download.multidownloader.a$a, reason: collision with other inner class name */
    /* loaded from: classes35.dex */
    public static final class C9108a {
        public static /* synthetic */ void a(a aVar, boolean z16, int i3, String str, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = 0;
                }
                if ((i16 & 4) != 0) {
                    str = null;
                }
                aVar.a(z16, i3, str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onComplete");
        }
    }
}
