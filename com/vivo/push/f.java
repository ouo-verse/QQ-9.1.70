package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;

/* compiled from: P */
/* loaded from: classes6.dex */
final class f implements c.a<e> {
    private static e b(String str) {
        try {
            return new e(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e16) {
            com.vivo.push.util.u.a(8101, e16.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ e a(String str) {
        return b(str);
    }
}
