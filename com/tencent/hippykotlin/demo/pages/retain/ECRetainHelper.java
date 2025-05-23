package com.tencent.hippykotlin.demo.pages.retain;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.QUISkinImage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ktx.IPagerIdKtxKt;
import com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainCacheManager;
import com.tencent.hippykotlin.demo.pages.retain.repo.ECRetainRepository;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.BridgeManager;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class ECRetainHelper {
    public static final ECRetainHelper INSTANCE = new ECRetainHelper();

    public final boolean showRetainView(String str, String str2, e eVar, final Function1<? super ECRetainViewOption, Unit> function1) {
        ECRetainRepository eCRetainRepository = ECRetainRepository.INSTANCE;
        boolean isNeedRetain = eCRetainRepository.isNeedRetain(str);
        c cVar = c.f117352a;
        BridgeManager bridgeManager = BridgeManager.f117344a;
        k kVar = (k) cVar.k(bridgeManager.u()).acquireModule("KRNotifyModule");
        e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("retainId", str);
        Unit unit = Unit.INSTANCE;
        k.d(kVar, "retain_mark_retain_notify", m3, false, 4, null);
        if (!isNeedRetain) {
            KLog.INSTANCE.e("Retain", QUISkinImage$$ExternalSyntheticOutline0.m("not need retain, spuID:", str2, " retainID:", str));
            return false;
        }
        ECRetainCacheManager eCRetainCacheManager = ECRetainCacheManager.INSTANCE;
        if (eCRetainCacheManager.getCacheInfo().retainId.length() == 0) {
            KLog.INSTANCE.e("Retain", QUISkinImage$$ExternalSyntheticOutline0.m("showRetainView not need retain info, spuID:", str2, " retainID:", str));
            return false;
        }
        e eVar2 = new e();
        eVar2.v("pb_data", eCRetainCacheManager.getCacheInfo().data);
        eVar2.v("reportJson", eVar);
        eCRetainRepository.reportRetainPopup$1(str2);
        IPagerIdKtxKt.openPageForResult$default(cVar.k(bridgeManager.u()), "mqqapi://ecommerce/open?target=52&channel=2&page_name=retain_pop_window&modal_mode=1", eVar2, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.retain.ECRetainHelper$showRetainView$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar3) {
                ECRetainViewOption eCRetainViewOption;
                e eVar4 = eVar3;
                Function1<ECRetainViewOption, Unit> function12 = function1;
                int j3 = eVar4 != null ? eVar4.j("option") : 0;
                ECRetainViewOption[] values = ECRetainViewOption.values();
                int length = values.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        eCRetainViewOption = null;
                        break;
                    }
                    eCRetainViewOption = values[i3];
                    if (eCRetainViewOption.value == j3) {
                        break;
                    }
                    i3++;
                }
                if (eCRetainViewOption == null) {
                    eCRetainViewOption = ECRetainViewOption.EXIT;
                }
                function12.invoke(eCRetainViewOption);
                return Unit.INSTANCE;
            }
        }, 2);
        return true;
    }
}
