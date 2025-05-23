package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import c45.i;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.BridgeModule;
import com.tencent.hippykotlin.demo.pages.base.QToastMode;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.NBPUserSelfInfo;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporterKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.FeedPublishTechReporter;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.k;
import d45.a;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.l;
import r25.b;
import r25.c;
import r25.e;
import s25.f;

/* loaded from: classes31.dex */
public final class NBPPublishService$sendPublishRequest$1 extends Lambda implements Function1<f, Unit> {
    public final /* synthetic */ Function3<Boolean, f, String, Unit> $callback;
    public final /* synthetic */ NBPPublishConfig $config;
    public final /* synthetic */ FeedPublishTechReporter $publishReporter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public NBPPublishService$sendPublishRequest$1(FeedPublishTechReporter feedPublishTechReporter, NBPPublishConfig nBPPublishConfig, Function3<? super Boolean, ? super f, ? super String, Unit> function3) {
        super(1);
        this.$publishReporter = feedPublishTechReporter;
        this.$config = nBPPublishConfig;
        this.$callback = function3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:46:0x00aa, code lost:
    
        if (r5 != null) goto L53;
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054  */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Unit invoke(f fVar) {
        l lVar;
        String str;
        QToastMode qToastMode;
        String str2;
        String decodeToString;
        String str3;
        List<b> list;
        Object obj;
        boolean z16;
        String str4;
        f fVar2 = fVar;
        FeedPublishTechReporter feedPublishTechReporter = this.$publishReporter;
        feedPublishTechReporter.getClass();
        feedPublishTechReporter.submitTimeUsage = Integer.valueOf((int) (APICallTechReporterKt.NBPCurrentTime() - feedPublishTechReporter.submitStartTime));
        l lVar2 = fVar2 != null ? fVar2.f433139d : null;
        String str5 = "";
        if (lVar2 != null) {
            m25.f fVar3 = fVar2.f433141f;
            boolean z17 = fVar3 != null && fVar3.f416062d == 0;
            if (z17) {
                qToastMode = QToastMode.Success;
            } else {
                qToastMode = QToastMode.Warning;
            }
            if (this.$config.showToast) {
                if (fVar3 != null && (str4 = fVar3.f416063e) != null) {
                    if (str4.length() > 0) {
                        z16 = true;
                        if (z16) {
                            BridgeModule currentBridgeModule = Utils.INSTANCE.currentBridgeModule();
                            m25.f fVar4 = fVar2.f433141f;
                            Intrinsics.checkNotNull(fVar4);
                            currentBridgeModule.qToast(fVar4.f416063e, qToastMode);
                        }
                    }
                }
                z16 = false;
                if (z16) {
                }
            }
            if (z17) {
                KLog.INSTANCE.i("NBPPublishService", "requestPublishFeed success");
                this.$publishReporter.reportResult$enumunboxing$(2, null);
                NBPUserSelfInfo userSelfInfo = UserDataManager.INSTANCE.getUserSelfInfo();
                e eVar = lVar2.f418093e;
                if (eVar != null && (list = eVar.I) != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it.next();
                        if (((b) obj).f430598d == 1001) {
                            break;
                        }
                    }
                    b bVar = (b) obj;
                    if (bVar != null) {
                        c cVar = bVar.f430600f;
                        if (cVar != null) {
                            str2 = cVar.f430604h;
                        }
                    }
                }
                str2 = "";
                if (userSelfInfo.updateAvatarDressBorderUrl(str2)) {
                    UserDataManager.INSTANCE.saveUserSelfInfo();
                    AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule"), "onNearbyProUserInfoChange", false, 4, null);
                }
                NBPPublishConfig nBPPublishConfig = this.$config;
                String str6 = nBPPublishConfig.source;
                List<String> list2 = nBPPublishConfig.themes;
                k kVar = (k) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRNotifyModule");
                com.tencent.kuikly.core.nvi.serialization.json.e m3 = AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("source", str6);
                decodeToString = StringsKt__StringsJVMKt.decodeToString(a.b(i.d(lVar2)));
                m3.v("statusFeed", decodeToString);
                if (!list2.isEmpty()) {
                    str3 = "1";
                } else {
                    str3 = "0";
                }
                m3.v("isSelectedTheme", str3);
                Unit unit = Unit.INSTANCE;
                k.d(kVar, "onPublishFeedFinish", m3, false, 4, null);
                new QQNearbyModule().asyncToNativeMethod("notifyFeedRefresh", new Object[]{i.d(lVar2)}, (Function1<Object, Unit>) null);
                Function3<Boolean, f, String, Unit> function3 = this.$callback;
                if (function3 != null) {
                    function3.invoke(Boolean.TRUE, fVar2, null);
                }
            } else {
                m25.f fVar5 = fVar2.f433141f;
                String str7 = fVar5 != null ? fVar5.f416063e : null;
                KLog.INSTANCE.e("NBPPublishService", "requestPublishFeed failed, rsp.response.msg: " + str7);
                this.$publishReporter.reportResult$enumunboxing$(5, str7);
                Function3<Boolean, f, String, Unit> function32 = this.$callback;
                if (function32 != null) {
                    function32.invoke(Boolean.FALSE, fVar2, str7);
                }
            }
        } else {
            KLog.INSTANCE.e("NBPPublishService", "requestPublishFeed failed, statusFeed is null");
        }
        if (fVar2 != null && (lVar = fVar2.f433139d) != null && (str = lVar.f418092d) != null) {
            str5 = str;
        }
        NBPPublishService.access$customDtReportPublish(0, str5, this.$config);
        return Unit.INSTANCE;
    }
}
