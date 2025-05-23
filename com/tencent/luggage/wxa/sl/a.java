package com.tencent.luggage.wxa.sl;

import android.os.Looper;
import android.os.Message;
import android.text.Selection;
import com.tencent.luggage.wxa.tn.b0;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f140389a = new C6722a(Looper.getMainLooper());

    /* renamed from: b, reason: collision with root package name */
    public volatile c f140390b;

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.sl.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6722a extends b0 {
        public C6722a(Looper looper) {
            super(looper);
        }

        @Override // com.tencent.luggage.wxa.tn.b0
        public void d(Message message) {
            if (1000 == message.what) {
                String str = (String) message.obj;
                int i3 = message.arg1;
                if (a.this.f140390b != null) {
                    a.this.f140390b.a(str, i3);
                }
            }
        }
    }

    public void a(CharSequence charSequence, boolean z16) {
        if (charSequence == null) {
            return;
        }
        Message a16 = this.f140389a.a(1000, Selection.getSelectionEnd(charSequence), 0, charSequence.toString());
        this.f140389a.c(1000);
        this.f140389a.a(a16, z16 ? 150L : 0L);
    }

    public void a(c cVar) {
        this.f140390b = cVar;
    }
}
