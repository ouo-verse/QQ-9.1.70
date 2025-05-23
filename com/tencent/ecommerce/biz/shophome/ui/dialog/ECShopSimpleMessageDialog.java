package com.tencent.ecommerce.biz.shophome.ui.dialog;

import android.content.Context;
import android.view.View;
import cg0.a;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.router.ECScheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/biz/shophome/ui/dialog/ECShopSimpleMessageDialog;", "", "Landroid/content/Context;", "context", "Lorg/json/JSONObject;", "messageBox", "", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShopSimpleMessageDialog {

    /* renamed from: a, reason: collision with root package name */
    public static final ECShopSimpleMessageDialog f104365a = new ECShopSimpleMessageDialog();

    ECShopSimpleMessageDialog() {
    }

    public final void a(Context context, JSONObject messageBox) {
        JSONObject optJSONObject = messageBox.optJSONObject("left_btn");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject optJSONObject2 = messageBox.optJSONObject("right_btn");
        if (optJSONObject2 == null) {
            optJSONObject2 = new JSONObject();
        }
        final String optString = messageBox.optString("title", "");
        final String optString2 = messageBox.optString("text", "");
        final String optString3 = optJSONObject.optString("text", "");
        final String optString4 = optJSONObject.optString("url", "");
        final String optString5 = optJSONObject2.optString("text", "");
        final String optString6 = optJSONObject2.optString("url", "");
        g gVar = new g(context);
        gVar.setTitle(optString2.length() == 0 ? "" : optString);
        gVar.Y(optString2.length() == 0 ? optString : optString2);
        gVar.b0(optString3);
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopSimpleMessageDialog$showMessageBox$$inlined$apply$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ECScheme.g(optString4, null, 2, null);
                a.b("ECShopSimpleMessageDialog", "[showMessageBox] leftBtnUrl = " + optString4);
            }
        });
        gVar.f0(optString5);
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.shophome.ui.dialog.ECShopSimpleMessageDialog$showMessageBox$$inlined$apply$lambda$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                ECScheme.g(optString6, null, 2, null);
                a.b("ECShopSimpleMessageDialog", "[showMessageBox] rightBtnUrl = " + optString6);
            }
        });
        gVar.show();
    }
}
