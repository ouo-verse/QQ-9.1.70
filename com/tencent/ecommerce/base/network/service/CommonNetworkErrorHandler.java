package com.tencent.ecommerce.base.network.service;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/base/network/service/CommonNetworkErrorHandler;", "", "", "code", "", "msg", "Landroid/content/Context;", "context", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes32.dex */
public final class CommonNetworkErrorHandler {

    /* renamed from: a, reason: collision with root package name */
    public static final CommonNetworkErrorHandler f100823a = new CommonNetworkErrorHandler();

    CommonNetworkErrorHandler() {
    }

    public final void a(int code, String msg2, Context context) {
        if (code == -1 || code == 2 || code == 4097 || code == 5 || code == 6) {
            i.f101155b.c(R.string.wvb, ECToastIcon.ICON_ERROR, 0);
            return;
        }
        if (code == 31080) {
            i.f101155b.d(msg2, ECToastIcon.ICON_ERROR, 0);
            return;
        }
        if (code != 31081) {
            i.f101155b.c(R.string.wi5, ECToastIcon.ICON_ERROR, 0);
            return;
        }
        final g gVar = new g(context);
        gVar.Y(msg2);
        gVar.b0("");
        gVar.f0(context.getString(R.string.wo7));
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.base.network.service.CommonNetworkErrorHandler$handleError$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                g.this.dismiss();
            }
        });
        gVar.show();
    }
}
