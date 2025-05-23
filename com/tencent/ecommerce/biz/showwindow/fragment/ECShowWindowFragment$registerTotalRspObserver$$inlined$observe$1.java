package com.tencent.ecommerce.biz.showwindow.fragment;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import cg0.a;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.common.ECMsgBox;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "t", "kotlin.jvm.PlatformType", "onChanged", "(Ljava/lang/Object;)V", "androidx/lifecycle/LiveDataKt$observe$wrappedObserver$1"}, k = 3, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECShowWindowFragment$registerTotalRspObserver$$inlined$observe$1<T> implements Observer<T> {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ECShowWindowFragment f104593d;

    public ECShowWindowFragment$registerTotalRspObserver$$inlined$observe$1(ECShowWindowFragment eCShowWindowFragment) {
        this.f104593d = eCShowWindowFragment;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t16) {
        JSONObject jSONObject = (JSONObject) t16;
        a.b("ECShowWindowFragment", "totalRspLiveData it = " + jSONObject);
        final JSONObject optJSONObject = jSONObject.optJSONObject("msg_box");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        if (optJSONObject.optBoolean("display")) {
            ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.showwindow.fragment.ECShowWindowFragment$registerTotalRspObserver$$inlined$observe$1$lambda$1

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$registerTotalRspObserver$1$1$dialogCallback$1", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
                /* loaded from: classes31.dex */
                public static final class a implements IECSchemeCallback {
                    a() {
                    }

                    @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
                    public void onCallbackFinished(JSONObject data) {
                        if (data.optBoolean("cancelDialog")) {
                            cg0.a.b("ECShowWindowFragment", "\u6536\u8d77\u5f39\u7a97");
                            FragmentActivity activity = this.f104593d.getActivity();
                            if (activity != null) {
                                activity.finish();
                            }
                        }
                        if (data.optBoolean("regSuccess")) {
                            cg0.a.b("ECShowWindowFragment", "\u7b7e\u7ea6\u6210\u529f");
                            ECShowWindowFragment.li(this.f104593d).b();
                        }
                    }
                }

                /* compiled from: P */
                @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0005\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/showwindow/fragment/ECShowWindowFragment$registerTotalRspObserver$1$1$backPressedCallback$1", "Lkotlin/Function0;", "", "Lcom/tencent/ecommerce/base/ui/ISimpleChatDialogOnBackPressed;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
                /* loaded from: classes31.dex */
                public static final class b implements Function0<Unit> {
                    b() {
                    }

                    public void a() {
                        FragmentActivity activity = this.f104593d.getActivity();
                        if (activity != null) {
                            activity.finish();
                        }
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        a();
                        return Unit.INSTANCE;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    a aVar = new a();
                    b bVar = new b();
                    this.f104593d.msgBox = new ECMsgBox(this.f104593d.requireContext(), aVar, bVar);
                    ECShowWindowFragment.li(this.f104593d).a(JSONObject.this);
                    ECShowWindowFragment.li(this.f104593d).c();
                    cg0.a.b("ECShowWindowFragment", "[getShowWindow] showMessageBox");
                }
            });
        }
    }
}
