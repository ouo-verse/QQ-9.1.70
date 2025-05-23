package p10;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.WSOpenHomeThenVideoParams;
import com.tencent.biz.pubaccount.weishi.main.a;
import com.tencent.biz.pubaccount.weishi.util.q;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.biz.pubaccount.weishi.verticalvideo.k;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lp10/d;", "Lp10/a;", "", "b", "Landroid/content/Context;", "context", "Landroid/os/Bundle;", "bundle", "", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class d implements a {
    private final String b() {
        if (!uy.a.f440578a.f() && com.tencent.biz.pubaccount.weishi.config.experiment.b.h().F()) {
            return "1000";
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    @Override // p10.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean a(Context context, Bundle bundle) {
        boolean z16;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        if (bundle == null) {
            x.j("WSOpenHomeThenVideoJumpHelper", "bundle is null.");
            return false;
        }
        Serializable serializable = bundle.getSerializable("key_open_home_then_video_params");
        WSOpenHomeThenVideoParams wSOpenHomeThenVideoParams = serializable instanceof WSOpenHomeThenVideoParams ? (WSOpenHomeThenVideoParams) serializable : null;
        if (wSOpenHomeThenVideoParams == null) {
            x.j("WSOpenHomeThenVideoJumpHelper", "openHomeThenVideoParams is null.");
            return false;
        }
        String feedId = wSOpenHomeThenVideoParams.getFeedId();
        if (feedId != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(feedId);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    x.j("WSOpenHomeThenVideoJumpHelper", "openHomeThenVideoParams.feedId is null or blank.");
                    return false;
                }
                stSimpleMetaFeed a16 = q.a(wSOpenHomeThenVideoParams.getFeedJson());
                ArrayList arrayList = new ArrayList();
                if (a16 != null) {
                    arrayList.add(a16);
                }
                a.b.c(new k("open_home_then_video", wSOpenHomeThenVideoParams.getPlayScene()).I(wSOpenHomeThenVideoParams.getFeedId()).J(arrayList).E(context).U(b()).M(0).B(false).H(0).P(String.valueOf(System.currentTimeMillis())).O(2).z(wSOpenHomeThenVideoParams.getAutoShowCommentParams()));
                x.j("WSOpenHomeThenVideoJumpHelper", "handle() success.");
                return true;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }
}
