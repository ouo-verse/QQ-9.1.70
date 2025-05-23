package com.tencent.sqshow.zootopia.nativeui.data.repo;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/h;", "", "", "param", "", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface h {
    void a(String param);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static /* synthetic */ void a(h hVar, String str, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    str = "request_lazy";
                }
                hVar.a(str);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadCoinInfo");
        }
    }
}
