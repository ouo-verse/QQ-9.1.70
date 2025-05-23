package com.tencent.hippykotlin.demo.pages.foundation.module;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.scroll.HippyHeaderListViewController;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.RoleCardKt$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.layout.d;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ShareModule extends Module {
    public final void doShareAction(int i3, ShareActionData shareActionData, ShareContentData shareContentData, final Function1<? super Integer, Unit> function1) {
        e m3 = RoleCardKt$$ExternalSyntheticOutline0.m("shareAction", i3);
        if ((shareContentData.qzoneThirdPartyAppId.length() > 0) && AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            shareContentData.shareUrl += "&third_party_app_id=" + shareContentData.qzoneThirdPartyAppId;
        }
        if (shareActionData != null) {
            e eVar = new e();
            eVar.v("friendUin", shareActionData.uin);
            eVar.v("friendName", shareActionData.label);
            eVar.t("friendType", shareActionData.uinType);
            eVar.v("guildId", shareActionData.guildId);
            eVar.w("directShowShareDialog", shareActionData.directShowShareDialog);
            m3.v("shareUserData", eVar);
        }
        e eVar2 = new e();
        eVar2.t("shareType", shareContentData.shareType);
        eVar2.v("arkJson", shareContentData.arkJson);
        eVar2.v("title", shareContentData.title);
        eVar2.v("desc", shareContentData.desc);
        eVar2.v(WadlProxyConsts.KEY_JUMP_URL, shareContentData.shareUrl);
        eVar2.v("qzoneComment", shareContentData.qzoneComment);
        eVar2.v("qzoneThirdPartyAppId", shareContentData.qzoneThirdPartyAppId);
        eVar2.t("useQCircleWxShare", shareContentData.useQCircleWxShare);
        b bVar = new b();
        Iterator<String> it = shareContentData.imageUrls.iterator();
        while (it.hasNext()) {
            bVar.t(it.next());
        }
        eVar2.v("imageUrl", bVar);
        eVar2.t(HippyHeaderListViewController.VIEW_TAG, shareContentData.viewTag);
        d dVar = shareContentData.clipArea;
        if (dVar != null) {
            e eVar3 = new e();
            eVar3.v(HippyTKDListViewAdapter.X, Float.valueOf(dVar.getX()));
            eVar3.v("y", Float.valueOf(dVar.getY()));
            eVar3.v("width", Float.valueOf(dVar.getWidth()));
            eVar3.v("height", Float.valueOf(dVar.getHeight()));
            Unit unit = Unit.INSTANCE;
            eVar2.v("clipArea", eVar3);
        }
        eVar2.v("scale", Float.valueOf(shareContentData.scale));
        m3.v("shareContentData", eVar2);
        toNative(false, "doShareAction", m3.toString(), new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.foundation.module.ShareModule$doShareAction$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar4) {
                e eVar5 = eVar4;
                function1.invoke(Integer.valueOf(eVar5 != null ? eVar5.j("shareActionErrCode") : 0));
                return Unit.INSTANCE;
            }
        }, false);
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "HRShareModule";
    }
}
