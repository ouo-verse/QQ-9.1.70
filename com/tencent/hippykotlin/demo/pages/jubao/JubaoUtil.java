package com.tencent.hippykotlin.demo.pages.jubao;

import com.tencent.hippykotlin.demo.pages.base.extension.PageDataExtKt;
import com.tencent.kuikly.core.base.ComposeView;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.l;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.timi.game.api.cookie.QQLiveCookieConstants;
import java.util.Iterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import s4.c;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class JubaoUtil {
    public static final JubaoUtil INSTANCE = new JubaoUtil();

    public static void fillParent$default(ComposeView composeView) {
        composeView.attr(new JubaoUtil$fillParent$1(0.0f));
        composeView.event(new Function1<l, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil$fillParent$2
            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(l lVar) {
                lVar.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.jubao.JubaoUtil$fillParent$2.1
                    @Override // kotlin.jvm.functions.Function1
                    public final /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                        return Unit.INSTANCE;
                    }
                });
                return Unit.INSTANCE;
            }
        });
    }

    public final e getContentValidateReq$qecommerce_biz_release(PageModel pageModel) {
        Integer num;
        e eVar = new e();
        eVar.v("appid", pageModel.getPostData().appId);
        e eVar2 = new e();
        eVar2.v("key", pageModel.psKey);
        eVar2.v(QQLiveCookieConstants.CookieKeys.COOKIE_KEY_P_UIN, PageDataExtKt.getUin(pageModel.page.getPageData()));
        eVar2.v("desc", pageModel.addReason);
        JubaoTypeData jubaoTypeData = pageModel.selectedTypeData;
        eVar2.t("reason_id", (jubaoTypeData == null || (num = jubaoTypeData.f114200id) == null) ? 5000000 : num.intValue());
        eVar2.v("msg_uuid", pageModel.uuid);
        eVar2.t("msg_number", pageModel.getEvidenceNum());
        b bVar = new b();
        Iterator<Map.Entry<String, String>> it = pageModel.pics.entrySet().iterator();
        while (it.hasNext()) {
            bVar.t(it.next().getValue());
        }
        Unit unit = Unit.INSTANCE;
        eVar2.v(c.PICS, bVar);
        eVar2.v("phone", "");
        eVar2.w("is_shield", false);
        eVar2.w("has_money_loss", pageModel.money > 0);
        eVar2.u("money_loss", pageModel.money);
        eVar.v("content", eVar2);
        eVar.v("ext", pageModel.getPostData().postData.toString());
        return eVar;
    }
}
