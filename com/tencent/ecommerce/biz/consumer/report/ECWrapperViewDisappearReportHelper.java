package com.tencent.ecommerce.biz.consumer.report;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.common.e;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\rB\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/report/ECWrapperViewDisappearReportHelper;", "", "", "busId", "", "productId", "contentId", "Lcom/tencent/ecommerce/biz/consumer/report/ECWrapperViewDisappearReportHelper$CardState;", "state", "", "a", "<init>", "()V", "CardState", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECWrapperViewDisappearReportHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final ECWrapperViewDisappearReportHelper f101631a = new ECWrapperViewDisappearReportHelper();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/report/ECWrapperViewDisappearReportHelper$CardState;", "", "value", "", "(Ljava/lang/String;II)V", "UNKNOW", "REQUESTING", "REQUEST_ERROR", "REQUEST_EMPTY_RESULT", "REQUEST_OK_TOSHOW", "REQUEST_SHOWING", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public enum CardState {
        UNKNOW(0),
        REQUESTING(1),
        REQUEST_ERROR(2),
        REQUEST_EMPTY_RESULT(3),
        REQUEST_OK_TOSHOW(4),
        REQUEST_SHOWING(5);

        public final int value;

        CardState(int i3) {
            this.value = i3;
        }
    }

    ECWrapperViewDisappearReportHelper() {
    }

    public final void a(int busId, String productId, String contentId, CardState state) {
        Map<Object, Object> f16 = new e().a(String.valueOf(busId)).b("viewer_uin", String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount())).b("productId", String.valueOf(productId)).b("contentId", String.valueOf(contentId)).b("state", String.valueOf(state.value)).f();
        cg0.a.b("ECWrapperViewDisappearReportHelper", "[reportCardState] params = " + f16);
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, "ds_goods_card_disappear_state", f16, false, 4, null);
    }
}
