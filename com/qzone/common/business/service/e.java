package com.qzone.common.business.service;

import android.text.TextUtils;
import com.qzone.common.event.Observable;
import com.qzone.util.al;

/* compiled from: P */
/* loaded from: classes39.dex */
public class e extends Observable {

    /* renamed from: d, reason: collision with root package name */
    private static final al<e, Void> f45809d = new a();

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a extends al<e, Void> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.qzone.util.al
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public e a(Void r16) {
            return new e();
        }
    }

    e() {
        super("Local");
    }

    public static e D() {
        return f45809d.get(null);
    }

    public boolean C(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        notify(1, str);
        return true;
    }

    public void E() {
        F(0);
    }

    public void F(int i3) {
        notify(3, Integer.valueOf(i3));
    }
}
