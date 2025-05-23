package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.app.Activity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IDiyCardBgUtils;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0010B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016JE\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bJE\u0010\u000e\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bR\u001b\u0010\u0014\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/Card;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "params", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "d", "c", "Lcom/tencent/mobileqq/vas/api/IDiyCardBgUtils;", "a", "Lkotlin/Lazy;", "b", "()Lcom/tencent/mobileqq/vas/api/IDiyCardBgUtils;", "diyCardBgUtils", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class Card {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy diyCardBgUtils;

    public Card() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<IDiyCardBgUtils>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.Card$diyCardBgUtils$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final IDiyCardBgUtils invoke() {
                return (IDiyCardBgUtils) QRoute.api(IDiyCardBgUtils.class);
            }
        });
        this.diyCardBgUtils = lazy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final IDiyCardBgUtils b() {
        return (IDiyCardBgUtils) this.diyCardBgUtils.getValue();
    }

    public final void c(@Nullable Activity activity, @NotNull String params, @Nullable Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(params, "params");
        JSONObject jSONObject = new JSONObject(params);
        IDiyCardBgUtils b16 = b();
        String optString = jSONObject.optString("filePath");
        Intrinsics.checkNotNullExpressionValue(optString, "json.optString(\"filePath\")");
        String optString2 = jSONObject.optString("url");
        Intrinsics.checkNotNullExpressionValue(optString2, "json.optString(\"url\")");
        b16.setCustomStyleAndBg(activity, optString, optString2, jSONObject.optLong("styleId"), callback);
    }

    public final void d(@Nullable Activity activity, @NotNull String params, @Nullable Function1<Object, Unit> callback) {
        LifecycleOwner a16;
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(params, "params");
        if (activity != null && (a16 = nf2.b.a(activity)) != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(a16)) != null) {
            BuildersKt__Builders_commonKt.launch$default(lifecycleScope, null, null, new Card$uploadBgToUps$1(params, this, callback, null), 3, null);
        }
    }
}
