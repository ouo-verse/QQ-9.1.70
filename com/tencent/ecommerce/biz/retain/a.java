package com.tencent.ecommerce.biz.retain;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.biz.retain.repo.ECRetainInfoModel;
import com.tencent.ecommerce.biz.retain.repo.ECRetainRepository;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013JQ\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u00052%\u0010\u000e\u001a!\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007j\u0002`\rJ\u000e\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/ecommerce/biz/retain/a;", "", "", "retainId", "spuId", "", "report", "Lkotlin/Function1;", "Lcom/tencent/ecommerce/biz/retain/ECRetainViewOption;", "Lkotlin/ParameterName;", "name", "option", "", "Lcom/tencent/ecommerce/biz/retain/CallbackShowRetain;", "callback", "", "b", "a", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f104118a = new a();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/retain/a$a", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "Lorg/json/JSONObject;", "data", "", "onCallbackFinished", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.biz.retain.a$a, reason: collision with other inner class name */
    /* loaded from: classes31.dex */
    public static final class C1088a implements IECSchemeCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f104119a;

        C1088a(Function1 function1) {
            this.f104119a = function1;
        }

        @Override // com.tencent.ecommerce.base.router.api.IECSchemeCallback
        public void onCallbackFinished(JSONObject data) {
            if (data.has("retain_callback_option_key")) {
                this.f104119a.invoke(ECRetainViewOption.INSTANCE.a(data.optInt("option", 0)));
            }
        }
    }

    a() {
    }

    public final void a(String retainId) {
        ECRetainRepository.f104121b.markInvalidRetainID(retainId);
    }

    public final boolean b(String retainId, String spuId, Map<Object, ? extends Object> report, Function1<? super ECRetainViewOption, Unit> callback) {
        ECRetainRepository eCRetainRepository = ECRetainRepository.f104121b;
        boolean isNeedRetain = eCRetainRepository.isNeedRetain(retainId);
        eCRetainRepository.markRetainShowed(retainId);
        if (!isNeedRetain) {
            cg0.a.b("Retain", "not need retain, spuID:" + spuId + " retainID:" + retainId);
            return false;
        }
        ECRetainInfoModel retainInfo = eCRetainRepository.getRetainInfo();
        if (retainInfo != null) {
            if (!(retainInfo.retainId.length() == 0)) {
                Bundle bundle = new Bundle();
                bundle.putString("type", "2");
                bundle.putString(KuiklyLaunchParams.PARAM_MODAL_MODE, "1");
                bundle.putString("page_name", "retain_pop_window");
                bundle.putString("pb_data", retainInfo.getData().toString());
                bundle.putString("report_data", new JSONObject(report).toString());
                for (Map.Entry<String, String> entry : ug0.a.c(new C1088a(callback)).entrySet()) {
                    bundle.putString(entry.getKey(), entry.getValue());
                }
                Intent intent = new Intent();
                intent.addFlags(268435456);
                intent.putExtras(bundle);
                com.tencent.ecommerce.base.plugin.a.f100882a.c(intent, ECRetainFragment.class, true);
                ECRetainRepository.f104121b.reportRetainPopup(spuId);
                cg0.a.b("Retain", "show retain ktv page");
                return true;
            }
        }
        cg0.a.a("Retain", "showRetainView", "not need retain info, spuID:" + spuId + " retainID:" + retainId);
        return false;
    }
}
