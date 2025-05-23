package af2;

import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate;
import com.tencent.mobileqq.auto.engine.event.ASEngineEnterEvent;
import com.tencent.mobileqq.auto.engine.lib.ASEngineConstants;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J0\u0010\b\u001a\u00020\u00022&\u0010\u0007\u001a\"\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0006H\u0016J4\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\b\u0010\f\u001a\u00020\u0002H\u0016J4\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00052\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J4\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\t2\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016\u00a8\u0006\u0014"}, d2 = {"Laf2/e;", "Lcom/tencent/ecommerce/base/plugin/IECPluginServiceDelegate;", "", "onCreate", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "onStartCommand", "", "type", "onHandleLogic", "onHandlePtsLoad", "url", "onHandleScheme", "target", "onHandleTargetScheme", "onPtsLoadFailed", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes39.dex */
public final class e implements IECPluginServiceDelegate {

    /* renamed from: a, reason: collision with root package name */
    public static final e f26008a = new e();

    e() {
    }

    @Override // com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate
    public void onHandleLogic(int type, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Override // com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate
    public void onHandleScheme(String url, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(params, "params");
    }

    @Override // com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate
    public void onHandleTargetScheme(int target, HashMap<String, String> params) {
        Intrinsics.checkNotNullParameter(params, "params");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
    
        r6 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r6);
     */
    @Override // com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onStartCommand(HashMap<String, String> params) {
        Long longOrNull;
        ASEngineEnterEvent aSEngineEnterEvent = new ASEngineEnterEvent(ASEngineConstants.BusinessKey.BUSINESS_ECOMMERCE);
        aSEngineEnterEvent.setCallBackResult(true);
        long longValue = (params == null || (r6 = params.get("KEY_ENTER_TIME")) == null || longOrNull == null) ? 0L : longOrNull.longValue();
        if (longValue > 0) {
            aSEngineEnterEvent.setLoadCost(String.valueOf(System.currentTimeMillis() - longValue));
        }
        SimpleEventBus.getInstance().dispatchEvent(aSEngineEnterEvent);
    }

    @Override // com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate
    public void onCreate() {
    }

    @Override // com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate
    public void onHandlePtsLoad() {
    }

    @Override // com.tencent.ecommerce.base.plugin.IECPluginServiceDelegate
    public void onPtsLoadFailed() {
    }
}
