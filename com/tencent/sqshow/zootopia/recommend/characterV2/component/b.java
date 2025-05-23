package com.tencent.sqshow.zootopia.recommend.characterV2.component;

import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H&J\u001c\u0010\t\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0002H&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/sqshow/zootopia/recommend/characterV2/component/b;", "", "", "withAnim", "", "u", "Lm94/h;", "callback", "waitingUeCallback", "r1", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public interface b {
    void r1(m94.h callback, boolean waitingUeCallback);

    void u(boolean withAnim);

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class a {
        public static /* synthetic */ void b(b bVar, m94.h hVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    hVar = m94.b.f416465a;
                }
                if ((i3 & 2) != 0) {
                    z16 = false;
                }
                bVar.r1(hVar, z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: refreshCurrentDress");
        }

        public static /* synthetic */ void a(b bVar, boolean z16, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 1) != 0) {
                    z16 = true;
                }
                bVar.u(z16);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: exitAvatarMall");
        }
    }
}
