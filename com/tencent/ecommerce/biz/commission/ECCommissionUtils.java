package com.tencent.ecommerce.biz.commission;

import android.content.Context;
import android.view.View;
import com.tencent.ecommerce.base.ui.g;
import com.tencent.ecommerce.biz.router.ECScheme;
import java.net.URLDecoder;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u001c\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J@\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u0016\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/ecommerce/biz/commission/ECCommissionUtils;", "", "Lorg/json/JSONObject;", "jsonObject", "Lkotlin/Pair;", "", "a", "Landroid/content/Context;", "context", "dialogTitle", "dialogContent", "leftBtnText", "leftBtnUrl", "rightBtnText", "rightBtnUrl", "", "b", "dialogMsg", "c", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECCommissionUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final ECCommissionUtils f101430a = new ECCommissionUtils();

    ECCommissionUtils() {
    }

    private final Pair<String, String> a(JSONObject jsonObject) {
        return new Pair<>(jsonObject.optString("text"), jsonObject.optString("url"));
    }

    private final void b(Context context, final String dialogTitle, final String dialogContent, final String leftBtnText, final String leftBtnUrl, final String rightBtnText, final String rightBtnUrl) {
        final g gVar = new g(context);
        gVar.setTitle(dialogTitle);
        gVar.Y(dialogContent);
        gVar.b0(leftBtnText);
        gVar.f0(rightBtnText);
        gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.commission.ECCommissionUtils$showExplainDialog$$inlined$apply$lambda$1
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
                if (leftBtnUrl.length() > 0) {
                    ECScheme.g(URLDecoder.decode(leftBtnUrl), null, 2, null);
                }
                g.this.dismiss();
            }
        });
        gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.commission.ECCommissionUtils$showExplainDialog$$inlined$apply$lambda$2
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
                if (rightBtnUrl.length() > 0) {
                    ECScheme.g(URLDecoder.decode(rightBtnUrl), null, 2, null);
                }
                g.this.dismiss();
            }
        });
        gVar.show();
    }

    public final void c(Context context, JSONObject dialogMsg) {
        String str;
        String second;
        String first;
        String second2;
        String optString = dialogMsg.optString("title");
        String optString2 = dialogMsg.optString("text");
        JSONObject optJSONObject = dialogMsg.optJSONObject("left_btn");
        Pair<String, String> a16 = optJSONObject != null ? f101430a.a(optJSONObject) : null;
        JSONObject optJSONObject2 = dialogMsg.optJSONObject("right_btn");
        Pair<String, String> a17 = optJSONObject2 != null ? f101430a.a(optJSONObject2) : null;
        if (a16 == null && a17 == null) {
            return;
        }
        ECCommissionUtils eCCommissionUtils = f101430a;
        if (a16 == null || (str = a16.getFirst()) == null) {
            str = "";
        }
        eCCommissionUtils.b(context, optString, optString2, str, (a16 == null || (second2 = a16.getSecond()) == null) ? "" : second2, (a17 == null || (first = a17.getFirst()) == null) ? "" : first, (a17 == null || (second = a17.getSecond()) == null) ? "" : second);
    }
}
