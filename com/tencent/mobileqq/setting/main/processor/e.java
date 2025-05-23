package com.tencent.mobileqq.setting.main.processor;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.account.api.IAccountManagerApi;
import com.tencent.mobileqq.qroute.QRoute;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B\u0019\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/setting/main/processor/e;", "Lcom/tencent/mobileqq/setting/processor/c;", "Landroid/view/View;", "view", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lgq2/a;", HippyTKDListViewAdapter.X, "onCreate", "onResume", "o", "", "g", "Z", "isNewType", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;Z)V", tl.h.F, "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class e extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final boolean isNewType;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(Context context, boolean z16) {
        super(context, 1);
        Intrinsics.checkNotNullParameter(context, "context");
        this.isNewType = z16;
    }

    private final void A(View view) {
        Activity e16 = e();
        if (e16 != null) {
            ((IAccountManagerApi) QRoute.api(IAccountManagerApi.class)).startAccountManagerFragment(e16, null);
        }
        com.tencent.mobileqq.setting.utils.o oVar = com.tencent.mobileqq.setting.utils.o.f286768a;
        oVar.c("CliOper", "Setting_tab", "Clk_manage_acc", (r20 & 8) != 0 ? 0 : 0, (r20 & 16) != 0 ? "" : null, (r20 & 32) != 0 ? "" : null, (r20 & 64) != 0 ? "" : null, (r20 & 128) != 0 ? "" : null);
        com.tencent.mobileqq.setting.utils.o.k(oVar, "0X800B82D", 0, null, null, null, null, 62, null);
        com.tencent.mobileqq.setting.utils.o.g(oVar, view, "em_bas_account_security", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(view, "view");
        this$0.A(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        com.tencent.mobileqq.setting.utils.o.f286768a.l(it, "em_bas_account_security", null, false);
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public void o() {
        super.o();
        l();
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        super.onCreate();
        com.tencent.mobileqq.setting.utils.o.k(com.tencent.mobileqq.setting.utils.o.f286768a, "0X800B7C9", 0, null, null, null, null, 62, null);
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onResume() {
        super.onResume();
        l();
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public gq2.a q() {
        gq2.a aVar = new gq2.a(this.isNewType, new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.main.processor.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.y(e.this, view);
            }
        });
        aVar.w(new com.tencent.mobileqq.widget.listitem.g() { // from class: com.tencent.mobileqq.setting.main.processor.d
            @Override // com.tencent.mobileqq.widget.listitem.g
            public final void M(View view) {
                e.z(view);
            }
        });
        return aVar;
    }
}
