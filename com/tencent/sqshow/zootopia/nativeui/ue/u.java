package com.tencent.sqshow.zootopia.nativeui.ue;

import com.tencent.sqshow.zootopia.avatar.c;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/ue/u;", "Lcom/tencent/sqshow/zootopia/avatar/c;", "", "withToast", "Ga", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface u extends com.tencent.sqshow.zootopia.avatar.c {
    boolean Ga(boolean withToast);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static void b(u uVar, boolean z16) {
            c.a.a(uVar, z16);
        }

        public static /* synthetic */ boolean a(u uVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                return uVar.Ga(z16);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkUeStatus");
        }
    }
}
