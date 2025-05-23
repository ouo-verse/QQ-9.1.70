package com.tencent.ecommerce.biz.orders.sampleorders;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.pts.core.PTSAppInstance;
import com.tencent.pts.ui.vnode.PTSNodeText;
import com.tencent.pts.ui.vnode.PTSNodeVirtual;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00032\u00020\u0001:\u0002\u000b\u0003B\u0011\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001c\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\n\u001a\u00020\u0002H\u0016R\u0016\u0010\r\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderTimerView;", "Lcom/tencent/pts/ui/vnode/PTSNodeText;", "", "b", "", "key", "", "value", "", "setAttribute", "onParseValueFinished", "a", "Ljava/lang/String;", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID, "Lcom/tencent/pts/core/PTSAppInstance;", "appInstance", "<init>", "(Lcom/tencent/pts/core/PTSAppInstance;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECApplySampleOrderTimerView extends PTSNodeText {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private String orderId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderTimerView$a;", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual$a;", "Lcom/tencent/pts/core/PTSAppInstance;", "ptsAppInstance", "Lcom/tencent/pts/ui/vnode/PTSNodeVirtual;", "buildNodeVirtual", "Landroid/content/Context;", "context", "nodeVirtual", "Landroid/view/View;", "buildNativeView", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements PTSNodeVirtual.a {
        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public View buildNativeView(Context context, PTSNodeVirtual nodeVirtual) {
            TextView textView = new TextView(context);
            textView.setTextSize(11.0f);
            textView.setTextColor(ECSkin.INSTANCE.getColor(R.color.f6952y));
            textView.setGravity(21);
            return textView;
        }

        @Override // com.tencent.pts.ui.vnode.PTSNodeVirtual.a
        public PTSNodeVirtual buildNodeVirtual(PTSAppInstance ptsAppInstance) {
            return new ECApplySampleOrderTimerView(ptsAppInstance);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\tR\u0014\u0010\r\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\tR\u0014\u0010\u000e\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\tR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/orders/sampleorders/ECApplySampleOrderTimerView$b;", "", "Landroid/content/Context;", "context", "", "timeMillis", "", "a", "DAY", "J", "EC_PTS_TIMER", "Ljava/lang/String;", "HOUR", "MINUTE", "ORDER_ID", "SECOND", "", "TEXT_SIZE_SP", UserInfo.SEX_FEMALE, "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderTimerView$b, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Context context, long timeMillis) {
            long j3 = timeMillis / 86400000;
            if (j3 > 0) {
                Resources resources = context.getResources();
                StringBuilder sb5 = new StringBuilder();
                sb5.append(j3);
                sb5.append('\u5929');
                return resources.getString(R.string.wrt, sb5.toString());
            }
            long j16 = timeMillis / 3600000;
            long j17 = (timeMillis % 3600000) / 60000;
            if (j17 <= 0) {
                if (timeMillis > 0) {
                    return context.getResources().getString(R.string.wrt, "00\u5c0f\u65f601\u5206");
                }
                return "";
            }
            Resources resources2 = context.getResources();
            StringBuilder sb6 = new StringBuilder();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j16)}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            sb6.append(format);
            sb6.append("\u5c0f\u65f6");
            String format2 = String.format("%02d", Arrays.copyOf(new Object[]{Long.valueOf(j17)}, 1));
            Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
            sb6.append(format2);
            sb6.append('\u5206');
            return resources2.getString(R.string.wrt, sb6.toString());
        }
    }

    public ECApplySampleOrderTimerView(PTSAppInstance pTSAppInstance) {
        super(pTSAppInstance);
        this.orderId = "";
        getView().post(new Runnable() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderTimerView.1
            @Override // java.lang.Runnable
            public final void run() {
                ECApplySampleOrderTimerView.this.b();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b() {
        if (getView().isAttachedToWindow()) {
            long a16 = com.tencent.ecommerce.biz.orders.sampleorders.a.f103795b.a(this.orderId);
            super.setTextContent(INSTANCE.a(getView().getContext(), a16));
            if (a16 > 0) {
                ECThreadUtilKt.e(60000L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.orders.sampleorders.ECApplySampleOrderTimerView$refreshTime$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        ECApplySampleOrderTimerView.this.b();
                    }
                });
            }
        }
    }

    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public void onParseValueFinished() {
        super.onParseValueFinished();
        super.setTextContent(INSTANCE.a(getView().getContext(), com.tencent.ecommerce.biz.orders.sampleorders.a.f103795b.a(this.orderId)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.pts.ui.vnode.PTSNodeTextBase, com.tencent.pts.ui.vnode.PTSNodeVirtual
    public boolean setAttribute(String key, Object value) {
        if (Intrinsics.areEqual(key, "order-id") && (value instanceof String)) {
            this.orderId = (String) value;
        }
        return super.setAttribute(key, value);
    }
}
