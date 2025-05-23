package com.tencent.mobileqq.vas.kuikly.moduleimpl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ecommerce.base.router.api.IECLogicCallback;
import com.tencent.ecommerce.biz.webview.IECWebViewPluginModel;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.qqecommerce.biz.sdk.api.IQQECommerceSdk;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.kuikly.ProxyFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJG\u0010\r\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0001\u00a2\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u000bH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/vas/kuikly/moduleimpl/EcommerceImpl;", "", "Landroid/app/Activity;", "kuiklyActivity", "", "jsonString", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "a", "<init>", "()V", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class EcommerceImpl {
    public void a(@Nullable Activity kuiklyActivity, @NotNull String jsonString, @Nullable final Function1<Object, Unit> callback) {
        Context context;
        Intrinsics.checkNotNullParameter(jsonString, "jsonString");
        final HashMap hashMap = new HashMap();
        hashMap.put("nameSpace", "ecommerce");
        hashMap.put("method", "getAddress");
        hashMap.put("requestJson", jsonString);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        ProxyFragment.Companion companion = ProxyFragment.INSTANCE;
        companion.a(new Function1<FragmentActivity, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.EcommerceImpl$openEcommerceGetAddress$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002=\u0012/\u0012-\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0001j\u0002`\nJ-\u0010\u000b\u001a\u00020\t2\"\u0010\b\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0096\u0002\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/EcommerceImpl$openEcommerceGetAddress$1$a", "Lkotlin/Function1;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "Lkotlin/ParameterName;", "name", "result", "", "Lcom/tencent/mobileqq/qqecommerce/biz/sdk/api/QQEcommerceLogicCallback;", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes20.dex */
            public static final class a implements Function1<HashMap<String, Object>, Unit> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Ref.ObjectRef<IECWebViewPluginModel> f309737d;

                /* renamed from: e, reason: collision with root package name */
                final /* synthetic */ FragmentActivity f309738e;

                /* renamed from: f, reason: collision with root package name */
                final /* synthetic */ HashMap<String, String> f309739f;

                /* renamed from: h, reason: collision with root package name */
                final /* synthetic */ Function1<Object, Unit> f309740h;

                /* compiled from: P */
                @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\u00072\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004`\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/vas/kuikly/moduleimpl/EcommerceImpl$openEcommerceGetAddress$1$a$a", "Lcom/tencent/ecommerce/base/router/api/IECLogicCallback;", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "result", "", "onResult", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
                /* renamed from: com.tencent.mobileqq.vas.kuikly.moduleimpl.EcommerceImpl$openEcommerceGetAddress$1$a$a, reason: collision with other inner class name */
                /* loaded from: classes20.dex */
                public static final class C8912a implements IECLogicCallback {

                    /* renamed from: a, reason: collision with root package name */
                    final /* synthetic */ Function1<Object, Unit> f309741a;

                    /* renamed from: b, reason: collision with root package name */
                    final /* synthetic */ Ref.ObjectRef<IECWebViewPluginModel> f309742b;

                    C8912a(Function1<Object, Unit> function1, Ref.ObjectRef<IECWebViewPluginModel> objectRef) {
                        this.f309741a = function1;
                        this.f309742b = objectRef;
                    }

                    @Override // com.tencent.ecommerce.base.router.api.IECLogicCallback
                    public void onResult(@NotNull HashMap<String, Object> result) {
                        String str;
                        Intrinsics.checkNotNullParameter(result, "result");
                        Object obj = result.get("resultJson");
                        if (obj != null) {
                            str = obj.toString();
                        } else {
                            str = null;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("IEcommerce", 1, "call back " + str);
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str);
                            Function1<Object, Unit> function1 = this.f309741a;
                            if (function1 != null) {
                                function1.invoke(nf2.a.e(jSONObject));
                            }
                        } catch (Exception e16) {
                            QLog.e("IEcommerce", 1, "error", e16);
                        }
                        this.f309742b.element = null;
                    }
                }

                a(Ref.ObjectRef<IECWebViewPluginModel> objectRef, FragmentActivity fragmentActivity, HashMap<String, String> hashMap, Function1<Object, Unit> function1) {
                    this.f309737d = objectRef;
                    this.f309738e = fragmentActivity;
                    this.f309739f = hashMap;
                    this.f309740h = function1;
                }

                /* JADX WARN: Multi-variable type inference failed */
                public void a(@NotNull HashMap<String, Object> result) {
                    T t16;
                    Intrinsics.checkNotNullParameter(result, "result");
                    Ref.ObjectRef<IECWebViewPluginModel> objectRef = this.f309737d;
                    Object obj = result.get("web_view_plugin_model");
                    if (obj instanceof IECWebViewPluginModel) {
                        t16 = (IECWebViewPluginModel) obj;
                    } else {
                        t16 = 0;
                    }
                    objectRef.element = t16;
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    linkedHashMap.putAll(this.f309739f);
                    linkedHashMap.put("requestCode", 0);
                    QLog.i("IEcommerce", 1, "openEcommerceGetAddress");
                    Ref.ObjectRef<IECWebViewPluginModel> objectRef2 = this.f309737d;
                    IECWebViewPluginModel iECWebViewPluginModel = objectRef2.element;
                    if (iECWebViewPluginModel != null) {
                        iECWebViewPluginModel.action(this.f309738e, linkedHashMap, new C8912a(this.f309740h, objectRef2));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HashMap<String, Object> hashMap) {
                    a(hashMap);
                    return Unit.INSTANCE;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity) {
                invoke2(fragmentActivity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull FragmentActivity activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                ((IQQECommerceSdk) QRoute.api(IQQECommerceSdk.class)).handleLogic(128, hashMap, new a(objectRef, activity, hashMap, callback));
            }
        });
        companion.c(new Function4<FragmentActivity, Integer, Integer, Intent, Unit>() { // from class: com.tencent.mobileqq.vas.kuikly.moduleimpl.EcommerceImpl$openEcommerceGetAddress$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(FragmentActivity fragmentActivity, Integer num, Integer num2, Intent intent) {
                invoke(fragmentActivity, num.intValue(), num2.intValue(), intent);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull FragmentActivity fragmentActivity, int i3, int i16, @Nullable Intent intent) {
                Intrinsics.checkNotNullParameter(fragmentActivity, "<anonymous parameter 0>");
                IECWebViewPluginModel iECWebViewPluginModel = objectRef.element;
                if (iECWebViewPluginModel != null) {
                    iECWebViewPluginModel.onActivityResult(intent, i3, i16);
                }
            }
        });
        if (kuiklyActivity == null) {
            context = BaseApplication.getContext();
        } else {
            context = kuiklyActivity;
        }
        Intent intent = new Intent();
        intent.addFlags(268435456);
        QPublicFragmentActivity.b.b(context, intent, QPublicTransFragmentActivity.class, ProxyFragment.class);
        if (kuiklyActivity != null) {
            kuiklyActivity.overridePendingTransition(0, 0);
        }
    }
}
