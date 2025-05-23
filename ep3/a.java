package ep3;

import android.content.Context;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.open.agent.auth.model.VirtualCreatorDataSourceImpl;
import com.tencent.open.agent.auth.model.VirtualDeleterDataSourceImpl;
import com.tencent.open.agent.auth.presenter.NewAuthorityPresenter;
import com.tencent.open.agent.auth.presenter.OldAuthorityPresenter;
import com.tencent.open.agent.auth.presenter.SelectPermissionPresenter;
import com.tencent.open.agent.auth.presenter.VirtualCreatorPresenter;
import com.tencent.open.agent.util.t;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes22.dex */
public class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: ep3.a$a, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public class C10258a extends NewAuthorityPresenter {
        final /* synthetic */ e O;

        /* compiled from: P */
        /* renamed from: ep3.a$a$a, reason: collision with other inner class name */
        /* loaded from: classes22.dex */
        class C10259a implements fp3.d {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ com.tencent.open.model.a f396933a;

            C10259a(com.tencent.open.model.a aVar) {
                this.f396933a = aVar;
            }

            private void b(String str, int i3) {
                try {
                    i3 = new JSONObject(str).optInt("ErrorCode");
                    if (i3 == 0) {
                        return;
                    }
                } catch (Exception e16) {
                    t.d("ContractBuilder", "Exception", e16);
                }
                C10258a.this.V0(i3);
            }

            @Override // fp3.d
            public boolean a(boolean z16, String str, int i3, String str2) {
                t.b("ContractBuilder", "deleteVirtual result=", str, ", success=", Boolean.valueOf(z16));
                com.tencent.open.agent.util.d.h("KEY_DELETE_VIRTUAL_D18", this.f396933a, z16);
                if (z16) {
                    b(str, i3);
                } else {
                    C10258a.this.V0(i3);
                }
                return false;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10258a(e eVar, com.tencent.open.agent.auth.model.c cVar, e eVar2) {
            super(eVar, cVar);
            this.O = eVar2;
        }

        @Override // com.tencent.open.agent.auth.presenter.NewAuthorityPresenter, ep3.d
        public boolean e(long j3, boolean z16) {
            if (!NetworkUtil.isNetworkAvailable(this.C)) {
                this.O.ld(0L);
                return true;
            }
            com.tencent.open.model.a b16 = hp3.b.e().b(z());
            if (b16 == null) {
                t.b("ContractBuilder", "deleteVirtual fail for account is null");
                V0(-1);
                return true;
            }
            t.b("ContractBuilder", "deleteVirtual start uin=", com.tencent.open.agent.util.g.C(b16.f341678a));
            com.tencent.open.agent.util.d.B("KEY_DELETE_VIRTUAL_D18");
            new VirtualDeleterDataSourceImpl().a(j3, b16.f341678a, z(), z16, new C10259a(b16));
            return false;
        }

        @Override // com.tencent.open.agent.auth.presenter.NewAuthorityPresenter, com.tencent.open.agent.auth.presenter.BaseAuthorityPresenter, ep3.b
        public void k() {
            super.k();
        }
    }

    public static void a(e eVar, Context context) {
        eVar.y2(new NewAuthorityPresenter(eVar, new com.tencent.open.agent.auth.model.h(context)));
    }

    public static void b(e eVar, Context context) {
        eVar.y2(new C10258a(eVar, new com.tencent.open.agent.auth.model.h(context), eVar));
    }

    public static void c(g gVar, Context context) {
        gVar.Xa(new OldAuthorityPresenter(gVar, new com.tencent.open.agent.auth.model.i(), new com.tencent.open.agent.auth.model.h(context)));
    }

    public static void d(k kVar, Context context) {
        kVar.Dc(new SelectPermissionPresenter(kVar, new com.tencent.open.agent.auth.model.h(context)));
    }

    public static void e(m mVar) {
        mVar.tf(new VirtualCreatorPresenter(mVar, new VirtualCreatorDataSourceImpl()));
    }
}
