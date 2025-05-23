package com.xiaomi.push;

import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class em extends eb {
    public em() {
        l("PING", null);
        k("0");
        h(0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.xiaomi.push.eb
    public ByteBuffer f(ByteBuffer byteBuffer) {
        if (p().length == 0) {
            return byteBuffer;
        }
        return super.f(byteBuffer);
    }

    @Override // com.xiaomi.push.eb
    public int x() {
        if (p().length == 0) {
            return 0;
        }
        return super.x();
    }
}
