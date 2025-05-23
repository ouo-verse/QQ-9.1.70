package com.tencent.hippykotlin.demo.pages.qwallet.base.log;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.foundation.lib.QQBrowser;
import com.tencent.kuikly.core.coroutines.b;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.NetworkModule;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
@DebugMetadata(c = "com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWClsLog$report$1", f = "QWClsLog.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes33.dex */
public final class QWClsLog$report$1 extends SuspendLambda implements Function2<b, Continuation<? super Unit>, Object> {
    public final /* synthetic */ e $body;
    public NetworkModule L$0;
    public String L$1;
    public e L$2;
    public String L$3;
    public e L$4;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QWClsLog$report$1(e eVar, Continuation<? super QWClsLog$report$1> continuation) {
        super(2, continuation);
        this.$body = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new QWClsLog$report$1(this.$body, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(b bVar, Continuation<? super Unit> continuation) {
        return ((QWClsLog$report$1) create(bVar, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended;
        e eVar;
        e eVar2;
        String str;
        NetworkModule networkModule;
        String str2;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Utils utils = Utils.INSTANCE;
            utils.getClass();
            NetworkModule networkModule2 = (NetworkModule) c.f117352a.g().acquireModule("KRNetworkModule");
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("uid=");
            m3.append(utils.currentQQKuiklyPlatformApi().getUin());
            String sb5 = m3.toString();
            e m16 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("Content-Type", "application/json");
            QQBrowser qQBrowser = QQBrowser.INSTANCE;
            this.L$0 = networkModule2;
            this.L$1 = sb5;
            this.L$2 = m16;
            this.L$3 = "User-Agent";
            this.L$4 = m16;
            this.label = 1;
            Object userAgent = qQBrowser.getUserAgent(this);
            if (userAgent == coroutine_suspended) {
                return coroutine_suspended;
            }
            eVar = m16;
            eVar2 = eVar;
            obj = userAgent;
            str = sb5;
            networkModule = networkModule2;
            str2 = "User-Agent";
        } else if (i3 == 1) {
            eVar = this.L$4;
            str2 = this.L$3;
            e eVar3 = this.L$2;
            String str3 = this.L$1;
            NetworkModule networkModule3 = this.L$0;
            ResultKt.throwOnFailure(obj);
            eVar2 = eVar3;
            str = str3;
            networkModule = networkModule3;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        eVar.v(str2, obj);
        final e eVar4 = this.$body;
        networkModule.c("https://h5.qianbao.qq.com/log/report?", true, eVar4, eVar2, str, 10, new Function3<e, Boolean, String, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qwallet.base.log.QWClsLog$report$1.2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public final Unit invoke(e eVar5, Boolean bool, String str4) {
                e eVar6 = eVar5;
                String str5 = str4;
                if (bool.booleanValue()) {
                    KLog.INSTANCE.d("QWClsLog", "report success : " + str5 + TokenParser.SP + eVar6 + TokenParser.SP + e.this);
                } else {
                    KLog.INSTANCE.e("QWClsLog", "report fail : " + str5 + TokenParser.SP + eVar6 + TokenParser.SP + e.this);
                }
                return Unit.INSTANCE;
            }
        });
        return Unit.INSTANCE;
    }
}
