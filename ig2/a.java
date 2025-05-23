package ig2;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ecommerce.biz.taskcenter.bizmodule.api.IECBizModuleProxy;
import com.tencent.mobileqq.jump.api.IJumpApi;
import com.tencent.mobileqq.qroute.QRoute;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lig2/a;", "Lcom/tencent/ecommerce/biz/taskcenter/bizmodule/api/IECBizModuleProxy;", "Landroid/content/Context;", "context", "", QZoneDTLoginReporter.SCHEMA, "", "openPublisher", "<init>", "()V", "a", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a implements IECBizModuleProxy {
    @Override // com.tencent.ecommerce.biz.taskcenter.bizmodule.api.IECBizModuleProxy
    public void openPublisher(Context context, String schema) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schema, "schema");
        if (TextUtils.isEmpty(schema)) {
            return;
        }
        ((IJumpApi) QRoute.api(IJumpApi.class)).doJumpAction(context, schema);
    }
}
