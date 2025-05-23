package com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks;

import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.base.Utils;
import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.foundation.module.CacheModule;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQBridgeApi;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConstKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask;
import com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.SequenceTaskQueue$execute$1;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import f35.g;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* loaded from: classes31.dex */
public final class TagPickGuideTask implements ISequenceTask {
    public final Function0<g> getLoginRsp;
    public final Function0<Boolean> isInMainPage;
    public Function1<? super Boolean, Unit> onFinishCb;
    public final com.tencent.kuikly.core.pager.g pageData;
    public final Function1<Boolean, Unit> setIsInMainPage;

    /* JADX WARN: Multi-variable type inference failed */
    public TagPickGuideTask(com.tencent.kuikly.core.pager.g gVar, Function0<g> function0, Function0<Boolean> function02, Function1<? super Boolean, Unit> function1) {
        this.pageData = gVar;
        this.getLoginRsp = function0;
        this.isInMainPage = function02;
        this.setIsInMainPage = function1;
        k.b(QQBridgeApi.INSTANCE.getNotifyModule(), "NBP_KUIKLY_PAGE_WILL_DESTORY_EVENT", false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.tasks.TagPickGuideTask.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                Function1<? super Boolean, Unit> function12;
                e eVar2 = eVar;
                if (Intrinsics.areEqual(eVar2 != null ? eVar2.p("pageName") : null, "nearbypro_guide_tag_pick") && (function12 = TagPickGuideTask.this.onFinishCb) != null) {
                    function12.invoke(Boolean.FALSE);
                }
                return Unit.INSTANCE;
            }
        }, 2, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    public final boolean canStart() {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0091, code lost:
    
        if (r1.intValue() != 1) goto L22;
     */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.main.foreground.guide.ISequenceTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void onStart(Function1<? super Boolean, Unit> function1) {
        Object firstOrNull;
        byte[] encodeToByteArray;
        KLog kLog = KLog.INSTANCE;
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("checkTagGuide:");
        m3.append(this.isInMainPage.invoke().booleanValue());
        kLog.i("TagSelectGuideTask", m3.toString());
        if (!this.isInMainPage.invoke().booleanValue()) {
            ((SequenceTaskQueue$execute$1) function1).invoke(Boolean.FALSE);
            return;
        }
        g invoke = this.getLoginRsp.invoke();
        f35.k kVar = invoke != null ? invoke.F : null;
        if (kVar != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) kVar.f397817e);
            if (firstOrNull != null) {
                if (!c.f117352a.g().getPageData().u()) {
                    CacheModule cacheModule = Utils.INSTANCE.cacheModule("");
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("KEY_HAD_DISPLAY_TAG_GUIDE");
                    m16.append(PageDataExtKt.getUin(this.pageData));
                    Integer num = cacheModule.getInt(m16.toString());
                    if (num != null) {
                    }
                }
                this.onFinishCb = function1;
                this.setIsInMainPage.invoke(Boolean.FALSE);
                CacheModule cacheModule2 = Utils.INSTANCE.cacheModule("");
                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("KEY_HAD_DISPLAY_TAG_GUIDE");
                m17.append(PageDataExtKt.getUin(this.pageData));
                cacheModule2.setInt(m17.toString(), 1);
                byte[] d16 = i.d(kVar);
                e jsonWithMainPgParams = NearbyConstKt.jsonWithMainPgParams();
                QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
                encodeToByteArray = StringsKt__StringsJVMKt.encodeToByteArray(jsonWithMainPgParams.toString());
                companion.setSharePenetratePageData(new byte[][]{d16, encodeToByteArray});
                QQKuiklyPlatformApi.Companion companion2 = QQKuiklyPlatformApi.Companion;
                QQKuiklyPlatformApi.Companion.openPage$default("mqqapi://kuikly/open?version=1&src_type=app&page_name=nearbypro_guide_tag_pick&modal_mode=1", false, 6);
                return;
            }
            ((SequenceTaskQueue$execute$1) function1).invoke(Boolean.FALSE);
            return;
        }
        ((SequenceTaskQueue$execute$1) function1).invoke(Boolean.FALSE);
    }
}
