package com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo;

import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.timer.TimerKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
/* loaded from: classes32.dex */
public final class QSearchNetSugWordsRepo {
    public static final void access$nofityFail(QSearchNetSugWordsRepo qSearchNetSugWordsRepo, int i3, String str, final Function2 function2) {
        qSearchNetSugWordsRepo.getClass();
        Utils.INSTANCE.logToNative("QSearchNetSugWordsRepo requestData failed, errorCode=" + i3 + ", errorMsg=" + str);
        TimerKt.d(1000, new Function0<Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qsearch_detail_page.page.sugword.repo.QSearchNetSugWordsRepo$nofityFail$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Unit invoke() {
                function2.invoke(Boolean.FALSE, new NetSugWordsRspWrapper(null, null));
                return Unit.INSTANCE;
            }
        });
    }

    public final String getExtensionData(int i3, int i16) {
        e eVar = new e();
        eVar.t(QFSSearchBaseRequest.EXTRA_KEY_QUERY_SOURCE, i3);
        eVar.t("userSource", i16);
        eVar.u("sourceVersion", PageDataExtKt.getResVersion(c.f117352a.g().getPageData()));
        return eVar.toString();
    }
}
