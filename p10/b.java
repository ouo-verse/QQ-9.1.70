package p10;

import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi.util.bb;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lp10/b;", "Lp10/a;", "", "b", "", "c", "Lcom/tencent/biz/pubaccount/weishi/push/WSRedDotPushMsg;", "wsPushMsgData", "d", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class b implements a {
    private final String b() {
        if (!uy.a.f440578a.f() && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().F()) {
            return "1000";
        }
        return "";
    }

    private final boolean c() {
        if (com.tencent.biz.pubaccount.weishi.home.e.l()) {
            x.f("WSCLinkJumpHelper", "[isNeedOpenVerticalForCLink] Is in selected is mono!");
            return false;
        }
        uy.a aVar = uy.a.f440578a;
        if (aVar.f() && !aVar.e()) {
            x.f("WSCLinkJumpHelper", "[isNeedOpenVerticalForCLink] Is in no combo waterfall!");
            return false;
        }
        if (!com.tencent.biz.pubaccount.weishi.config.experiment.b.h().D()) {
            x.f("WSCLinkJumpHelper", "[isNeedOpenVerticalForCLink] Is not CLink test!");
            return false;
        }
        if (!Intrinsics.areEqual(WSPublicAccReport.getInstance().getEnterPublicAccFrom(), "from_home_page")) {
            x.f("WSCLinkJumpHelper", "[isNeedOpenVerticalForCLink] Is not aio open!");
            return false;
        }
        return d(bb.z());
    }

    @Override // p10.a
    public boolean a(Context context, Bundle bundle) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        if (!c()) {
            return false;
        }
        if (bb.z() != null) {
            str = "red_aio";
        } else {
            str = "aio";
        }
        a.b.c(new k("aio_enter_c_link", str).E(context).U(b()).M(0).B(false).H(0).P(String.valueOf(System.currentTimeMillis())).O(2).L(true).F(bundle));
        return true;
    }

    private final boolean d(WSRedDotPushMsg wsPushMsgData) {
        IWSPushBaseStrategy iWSPushBaseStrategy;
        Integer valueOf = (wsPushMsgData == null || (iWSPushBaseStrategy = wsPushMsgData.mStrategyInfo) == null) ? null : Integer.valueOf(iWSPushBaseStrategy.getType());
        if (valueOf == null) {
            x.f("WSCLinkJumpHelper", "[isOpenCLinkPush]  push is null and can open CLink");
            return true;
        }
        x.f("WSCLinkJumpHelper", "[isOpenCLinkPush] pushType:" + valueOf);
        return (valueOf.intValue() == 2 || valueOf.intValue() == 4 || valueOf.intValue() == 5 || valueOf.intValue() == 6 || valueOf.intValue() == 7 || valueOf.intValue() == 8) ? false : true;
    }
}
