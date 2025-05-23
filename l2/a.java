package l2;

import android.content.Context;
import com.hihonor.honorid.core.data.HonorAccount;
import com.hihonor.honorid.d;
import com.hihonor.honorid.usecase.WriteHnAccountUseCase;
import i45.c;
import java.util.ArrayList;
import q.q.q.e.w.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class a implements k2.b {

    /* renamed from: a, reason: collision with root package name */
    private static a f413698a;

    a() {
    }

    public static synchronized a b(Context context) {
        a aVar;
        synchronized (a.class) {
            if (f413698a == null) {
                e.a(context);
                a aVar2 = new a();
                f413698a = aVar2;
                aVar2.c(context);
            }
            aVar = f413698a;
        }
        return aVar;
    }

    private void c(Context context) {
        e.c("SDKAccountManager", "init SDKAccountManager", true);
        c.a(context);
    }

    @Override // k2.b
    public boolean a(Context context, HonorAccount honorAccount) {
        if (!j2.a.d(honorAccount)) {
            e.c("SDKAccountManager", "the account is invalid , cannot be added into file", true);
            return false;
        }
        m2.a.b(context).c(honorAccount);
        ArrayList arrayList = new ArrayList();
        arrayList.add(honorAccount);
        new com.hihonor.honorid.b(d.a()).a(new WriteHnAccountUseCase(context, arrayList, true), new WriteHnAccountUseCase.RequestValues(honorAccount.p()), null);
        return true;
    }

    @Override // k2.b
    public ArrayList<HonorAccount> a(Context context) {
        e.c("SDKAccountManager", "MemCache has no account,parse from file", true);
        ArrayList<HonorAccount> a16 = b.a("accounts.xml", context, true);
        if (!a16.isEmpty()) {
            m2.a.b(context).c(a16.get(0));
        }
        return a16;
    }
}
