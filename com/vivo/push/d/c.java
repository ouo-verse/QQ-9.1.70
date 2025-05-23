package com.vivo.push.d;

import com.vivo.push.restructure.request.a.a.c;
import com.vivo.push.util.u;

/* compiled from: P */
/* loaded from: classes12.dex */
final class c implements c.a<b> {
    private static b b(String str) {
        try {
            return new b(new com.vivo.push.restructure.request.a.a.a(str));
        } catch (Exception e16) {
            u.a(8101, e16.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.request.a.a.c.a
    public final /* synthetic */ b a(String str) {
        return b(str);
    }
}
