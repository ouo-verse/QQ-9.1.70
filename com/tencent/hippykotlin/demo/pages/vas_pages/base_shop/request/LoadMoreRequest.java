package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.GoodsItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BaseRequest;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class LoadMoreRequest {
    /* JADX WARN: Removed duplicated region for block: B:12:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object loadMoreRequest(VasBasePage vasBasePage, String str, String str2, Function2<? super List<? extends ItemData>, ? super String, Unit> function2, Continuation<? super Unit> continuation) {
        LoadMoreRequest$loadMoreRequest$1 loadMoreRequest$loadMoreRequest$1;
        Object coroutine_suspended;
        int i3;
        Function2<? super List<? extends ItemData>, ? super String, Unit> function22;
        VasBasePage vasBasePage2;
        String p16;
        Object d16;
        if (continuation instanceof LoadMoreRequest$loadMoreRequest$1) {
            loadMoreRequest$loadMoreRequest$1 = (LoadMoreRequest$loadMoreRequest$1) continuation;
            int i16 = loadMoreRequest$loadMoreRequest$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                loadMoreRequest$loadMoreRequest$1.label = i16 - Integer.MIN_VALUE;
                LoadMoreRequest$loadMoreRequest$1 loadMoreRequest$loadMoreRequest$12 = loadMoreRequest$loadMoreRequest$1;
                Object obj = loadMoreRequest$loadMoreRequest$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = loadMoreRequest$loadMoreRequest$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    BaseRequest.Companion companion = BaseRequest.Companion;
                    e eVar = new e();
                    eVar.z("appid", Boxing.boxInt(Integer.parseInt(str)));
                    int i17 = 3;
                    eVar.z("locationtype", Boxing.boxInt(3));
                    eVar.z("lUid", Boxing.boxLong(Long.parseLong(vasBasePage.platformApi.getQqModule().getUin())));
                    eVar.z("listindex", Boxing.boxInt(30));
                    eVar.z("pagesize", Boxing.boxInt(30));
                    eVar.z("modName", "");
                    e eVar2 = new e();
                    eVar2.z("ContextSession", str2);
                    Unit unit = Unit.INSTANCE;
                    eVar.z("mParams", eVar2);
                    e eVar3 = new e();
                    eVar3.z("iKeyType", Boxing.boxInt(1));
                    if (vasBasePage.platformApi.getVasModule().getPlatformType() == 1) {
                        i17 = 2;
                    } else if (vasBasePage.platformApi.getVasModule().getPlatformType() != 2) {
                        i17 = 0;
                    }
                    eVar3.z("iOpplat", Boxing.boxInt(i17));
                    eVar3.z("sClientIp", "");
                    eVar3.z("sClientVer", vasBasePage.platformApi.getVasModule().getMainClientVersion());
                    eVar.z("stLogin", eVar3);
                    String m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("shop", str);
                    loadMoreRequest$loadMoreRequest$12.L$0 = vasBasePage;
                    function22 = function2;
                    loadMoreRequest$loadMoreRequest$12.L$1 = function22;
                    loadMoreRequest$loadMoreRequest$12.label = 1;
                    obj = companion.buildBaseRequest(vasBasePage, "https://zb.vip.qq.com/trpc-proxy/qqva/qc_submall_server/qc_submall_server/GetMoreListV2", eVar, m3, loadMoreRequest$loadMoreRequest$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    vasBasePage2 = vasBasePage;
                } else if (i3 == 1) {
                    Function2<? super List<? extends ItemData>, ? super String, Unit> function23 = loadMoreRequest$loadMoreRequest$12.L$1;
                    vasBasePage2 = loadMoreRequest$loadMoreRequest$12.L$0;
                    ResultKt.throwOnFailure(obj);
                    function22 = function23;
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p16 = ((Response) obj).data.p("response");
                ArrayList arrayList = new ArrayList();
                if (!(p16.length() == 0)) {
                    function22.invoke(arrayList, "");
                    return Unit.INSTANCE;
                }
                e eVar4 = new e(p16);
                b l3 = eVar4.l(VideoTemplateParser.ITEM_LIST);
                if (l3 != null) {
                    int c16 = l3.c();
                    for (int i18 = 0; i18 < c16; i18++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxBoolean(l3.e(i18));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxInt(l3.i(i18));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxLong(l3.m(i18));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d16 = l3.o(i18);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxDouble(l3.g(i18));
                        } else {
                            d16 = l3.d(i18);
                        }
                        if (d16 != null) {
                            e eVar5 = (e) d16;
                            KLog.INSTANCE.i(vasBasePage2.getPageName(), eVar5.toString());
                            GoodsItemData goodsItemData = new GoodsItemData();
                            e m16 = eVar5.m(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
                            if (m16 != null) {
                                goodsItemData.setTitle(m16.p("name"));
                                goodsItemData.setUrl(m16.p("image"));
                                goodsItemData.setType(m16.p(VipFunCallConstants.KEY_FEET_TYPE));
                                goodsItemData.setItemId(m16.p("itemId"));
                                goodsItemData.setPrice((m16.m("extrainfo") != null ? r6.j("price") : 0) / 100.0f);
                            }
                            arrayList.add(goodsItemData);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                e m17 = eVar4.m("extParams");
                Intrinsics.checkNotNull(m17);
                function22.invoke(arrayList, m17.p("ContextSession"));
                return Unit.INSTANCE;
            }
        }
        loadMoreRequest$loadMoreRequest$1 = new LoadMoreRequest$loadMoreRequest$1(this, continuation);
        LoadMoreRequest$loadMoreRequest$1 loadMoreRequest$loadMoreRequest$122 = loadMoreRequest$loadMoreRequest$1;
        Object obj2 = loadMoreRequest$loadMoreRequest$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = loadMoreRequest$loadMoreRequest$122.label;
        if (i3 != 0) {
        }
        p16 = ((Response) obj2).data.p("response");
        ArrayList arrayList2 = new ArrayList();
        if (!(p16.length() == 0)) {
        }
    }
}
