package n1;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.Messenger;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {
    public static g a(f fVar) {
        return new a(fVar);
    }

    /* compiled from: P */
    /* loaded from: classes2.dex */
    private static class a implements g {

        /* renamed from: a, reason: collision with root package name */
        private f f417974a;

        /* renamed from: b, reason: collision with root package name */
        final Messenger f417975b = new Messenger(new HandlerC10817a());

        /* compiled from: P */
        /* renamed from: n1.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        class HandlerC10817a extends Handler {
            HandlerC10817a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 1:
                        a.this.f417974a.c();
                        return;
                    case 2:
                        a.this.f417974a.a();
                        return;
                    case 3:
                        a.this.f417974a.b(message.getData().getInt(WadlProxyConsts.FLAGS));
                        return;
                    case 4:
                        a.this.f417974a.e();
                        return;
                    case 5:
                        a.this.f417974a.f();
                        return;
                    case 6:
                        a.this.f417974a.d((Messenger) message.getData().getParcelable("EMH"));
                        return;
                    default:
                        return;
                }
            }
        }

        public a(f fVar) {
            this.f417974a = null;
            this.f417974a = fVar;
        }

        @Override // n1.g
        public Messenger a() {
            return this.f417975b;
        }

        @Override // n1.g
        public void disconnect(Context context) {
        }
    }
}
