package pl4;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.utils.IResultListener;
import com.tencent.timi.game.utils.l;
import mqq.app.NewIntent;
import trpc.yes.common.BaseInterfaceOuterClass$CSQQAccessReply;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {

    /* compiled from: P */
    /* loaded from: classes26.dex */
    class a implements d<BaseInterfaceOuterClass$CSQQAccessReply> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IResultListener f426460a;

        a(IResultListener iResultListener) {
            this.f426460a = iResultListener;
        }

        @Override // pl4.d
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(boolean z16, int i3, int i16, int i17, String str, String str2, @Nullable BaseInterfaceOuterClass$CSQQAccessReply baseInterfaceOuterClass$CSQQAccessReply, @Nullable FromServiceMsg fromServiceMsg) {
            IResultListener iResultListener = this.f426460a;
            if (iResultListener != null) {
                iResultListener.onError(i16, str);
            }
        }

        @Override // pl4.d
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(BaseInterfaceOuterClass$CSQQAccessReply baseInterfaceOuterClass$CSQQAccessReply, FromServiceMsg fromServiceMsg) {
            String str;
            if (baseInterfaceOuterClass$CSQQAccessReply == null) {
                l.e("JsonTimiGameServlet", "null response");
                IResultListener iResultListener = this.f426460a;
                if (iResultListener != null) {
                    iResultListener.onError(-1, "body_type not json");
                    return;
                }
                return;
            }
            if (baseInterfaceOuterClass$CSQQAccessReply.body_type.get() != 1) {
                l.e("JsonTimiGameServlet", "body_type not json");
                IResultListener iResultListener2 = this.f426460a;
                if (iResultListener2 != null) {
                    iResultListener2.onError(-1, "body_type not json");
                    return;
                }
                return;
            }
            if (baseInterfaceOuterClass$CSQQAccessReply.rsp_body.get().size() > 0) {
                str = new String(baseInterfaceOuterClass$CSQQAccessReply.rsp_body.get().toByteArray());
            } else {
                str = "";
            }
            this.f426460a.onSuccess(str);
        }
    }

    private static NewIntent d(int i3, String str) {
        NewIntent newIntent = new NewIntent(BaseApplication.getContext(), b.class);
        newIntent.putExtra("req_cmd", i3);
        newIntent.putExtra("bytes", str.getBytes());
        return newIntent;
    }

    public static void e(int i3, String str, IResultListener<String> iResultListener) {
        ((c) mm4.b.b(c.class)).F1(d(i3, str), BaseInterfaceOuterClass$CSQQAccessReply.class, new a(iResultListener));
    }

    @Override // pl4.a
    protected int b() {
        return 0;
    }

    @Override // pl4.a
    protected boolean c() {
        return true;
    }
}
