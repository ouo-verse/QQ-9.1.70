package h00;

import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.z;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;

/* compiled from: P */
/* loaded from: classes38.dex */
public class h extends h00.a {

    /* compiled from: P */
    /* loaded from: classes38.dex */
    class a implements MiniAppLaunchListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ MiniAppLaunchListener f403973a;

        a(MiniAppLaunchListener miniAppLaunchListener) {
            this.f403973a = miniAppLaunchListener;
        }

        @Override // com.tencent.mobileqq.mini.api.MiniAppLaunchListener
        public void onLaunchResult(boolean z16, Bundle bundle) {
            x.j("WSMiniAppJumpStrategy", "[WSMiniAppJumpStrategy.java][jumpAction] onLaunchResult isSuc:" + z16 + ", bundle:" + bundle);
            MiniAppLaunchListener miniAppLaunchListener = this.f403973a;
            if (miniAppLaunchListener != null) {
                miniAppLaunchListener.onLaunchResult(z16, bundle);
            }
        }
    }

    public h(c cVar) {
        super(cVar);
    }

    @Override // h00.a
    public boolean b(c cVar) {
        z.o(cVar.getContext(), cVar.g().miniAppSchema, new a(cVar.c()));
        if (cVar.d() == null) {
            return true;
        }
        cVar.d().c();
        return true;
    }
}
