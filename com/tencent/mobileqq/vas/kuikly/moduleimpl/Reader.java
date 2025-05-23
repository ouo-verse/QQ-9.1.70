package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.app.Activity;
import com.tencent.ark.ark;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasReaderApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002JE\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062+\u0010\u000e\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Reader;", "", "", ark.ARKMETADATA_JSON, "a", "isOnStr", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "b", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class Reader {
    @NotNull
    public final String a(@NotNull String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        JSONObject jSONObject = new JSONObject(json);
        IVasReaderApi iVasReaderApi = (IVasReaderApi) QRoute.api(IVasReaderApi.class);
        float a16 = au.a(jSONObject.opt("textSize"));
        String optString = jSONObject.optString("fontFamily");
        Intrinsics.checkNotNullExpressionValue(optString, "jsonObject.optString(\"fontFamily\")");
        String optString2 = jSONObject.optString("textContent");
        Intrinsics.checkNotNullExpressionValue(optString2, "jsonObject.optString(\"textContent\")");
        return iVasReaderApi.measureText(a16, optString, optString2, jSONObject.optInt(NodeProps.MAX_WIDTH), au.a(jSONObject.opt("textSpacing")), jSONObject.optInt("fontWeight"));
    }

    public final void b(@NotNull String isOnStr, @Nullable Activity activity, @Nullable final Function1<Object, Unit> callback) {
        boolean z16;
        Intrinsics.checkNotNullParameter(isOnStr, "isOnStr");
        boolean z17 = true;
        if (isOnStr.length() > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 || !Intrinsics.areEqual(isOnStr, "1")) {
            z17 = false;
        }
        ((IVasReaderApi) QRoute.api(IVasReaderApi.class)).setVolumeKeyListener(z17, activity, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.Reader$setVolumeKeyListener$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Map mapOf;
                Function1<Object, Unit> function1 = callback;
                if (function1 != null) {
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("key", Integer.valueOf(i3)));
                    function1.invoke(mapOf);
                }
            }
        });
    }
}
