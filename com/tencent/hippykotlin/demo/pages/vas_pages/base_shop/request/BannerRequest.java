package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.FuncModItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TopBannerItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BaseRequest;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mtt.hippy.views.hippylist.ViewStickEventHelper;
import java.util.ArrayList;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class BannerRequest {
    /* JADX WARN: Removed duplicated region for block: B:113:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0101 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0030  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchBanners(VasBasePage vasBasePage, String str, Continuation<? super ArrayList<ItemData>> continuation) {
        BannerRequest$fetchBanners$1 bannerRequest$fetchBanners$1;
        Object coroutine_suspended;
        int i3;
        String p16;
        Object d16;
        Object d17;
        String str2;
        Object d18;
        boolean z16;
        String str3;
        if (continuation instanceof BannerRequest$fetchBanners$1) {
            bannerRequest$fetchBanners$1 = (BannerRequest$fetchBanners$1) continuation;
            int i16 = bannerRequest$fetchBanners$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                bannerRequest$fetchBanners$1.label = i16 - Integer.MIN_VALUE;
                BannerRequest$fetchBanners$1 bannerRequest$fetchBanners$12 = bannerRequest$fetchBanners$1;
                Object obj = bannerRequest$fetchBanners$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = bannerRequest$fetchBanners$12.label;
                boolean z17 = true;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    BaseRequest.Companion companion = BaseRequest.Companion;
                    e eVar = new e();
                    eVar.z("appid", Boxing.boxInt(Integer.parseInt(str)));
                    int i17 = 3;
                    eVar.z("locationtype", Boxing.boxInt(3));
                    eVar.z("lUid", Boxing.boxLong(Long.parseLong(vasBasePage.platformApi.getQqModule().getUin())));
                    e eVar2 = new e();
                    eVar2.z("iKeyType", Boxing.boxInt(1));
                    if (vasBasePage.platformApi.getVasModule().getPlatformType() == 1) {
                        i17 = 2;
                    } else if (vasBasePage.platformApi.getVasModule().getPlatformType() != 2) {
                        i17 = 0;
                    }
                    eVar2.z("iOpplat", Boxing.boxInt(i17));
                    eVar2.z("sClientIp", "");
                    eVar2.z("sClientVer", vasBasePage.platformApi.getVasModule().getMainClientVersion());
                    Unit unit = Unit.INSTANCE;
                    eVar.z("stLogin", eVar2);
                    String m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("shop", str);
                    bannerRequest$fetchBanners$12.label = 1;
                    obj = companion.buildBaseRequest(vasBasePage, "https://zb.vip.qq.com/trpc-proxy/qqva/qc_submall_server/qc_submall_server/GetPageConfig", eVar, m3, bannerRequest$fetchBanners$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p16 = ((Response) obj).data.p("response");
                ArrayList arrayList = new ArrayList();
                if (!(p16.length() != 0)) {
                    return arrayList;
                }
                e eVar3 = new e(p16);
                b l3 = eVar3.l("vTopBanner");
                if (l3 != null) {
                    int c16 = l3.c();
                    int i18 = 0;
                    while (i18 < c16) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d18 = Boxing.boxBoolean(l3.e(i18));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d18 = Boxing.boxInt(l3.i(i18));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d18 = Boxing.boxLong(l3.m(i18));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d18 = l3.o(i18);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d18 = Boxing.boxDouble(l3.g(i18));
                        } else {
                            d18 = l3.d(i18);
                        }
                        if (d18 != null) {
                            e eVar4 = (e) d18;
                            if (Intrinsics.areEqual(eVar4.p(ViewStickEventHelper.IS_SHOW), "1")) {
                                TopBannerItemData topBannerItemData = new TopBannerItemData();
                                e m16 = eVar4.m("image");
                                if (m16 == null || (str3 = m16.p("src")) == null) {
                                    str3 = "";
                                }
                                ReadWriteProperty readWriteProperty = topBannerItemData.image$delegate;
                                KProperty<?>[] kPropertyArr = TopBannerItemData.$$delegatedProperties;
                                readWriteProperty.setValue(topBannerItemData, kPropertyArr[0], str3);
                                z16 = true;
                                topBannerItemData.url$delegate.setValue(topBannerItemData, kPropertyArr[1], eVar4.p("url"));
                                arrayList.add(topBannerItemData);
                            } else {
                                z16 = z17;
                            }
                            i18++;
                            z17 = z16;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                b l16 = eVar3.l("vFuncMod");
                if (l16 != null) {
                    int c17 = l16.c();
                    for (int i19 = 0; i19 < c17; i19++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d17 = Boxing.boxBoolean(l16.e(i19));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d17 = Boxing.boxInt(l16.i(i19));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d17 = Boxing.boxLong(l16.m(i19));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d17 = l16.o(i19);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d17 = Boxing.boxDouble(l16.g(i19));
                        } else {
                            d17 = l16.d(i19);
                        }
                        if (d17 != null) {
                            e eVar5 = (e) d17;
                            FuncModItemData funcModItemData = new FuncModItemData();
                            funcModItemData.setTitle(eVar5.p("title"));
                            funcModItemData.setDesc(eVar5.p("desc"));
                            e m17 = eVar5.m("icon");
                            if (m17 == null || (str2 = m17.p("src")) == null) {
                                str2 = "";
                            }
                            funcModItemData.setIcon(str2);
                            funcModItemData.setUrl(eVar5.p(WadlProxyConsts.KEY_JUMP_URL));
                            arrayList.add(funcModItemData);
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                b l17 = eVar3.l("vSplitBanner");
                if (l17 != null) {
                    int c18 = l17.c();
                    for (int i26 = 0; i26 < c18; i26++) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxBoolean(l17.e(i26));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxInt(l17.i(i26));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxLong(l17.m(i26));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d16 = l17.o(i26);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d16 = Boxing.boxDouble(l17.g(i26));
                        } else {
                            d16 = l17.d(i26);
                        }
                        if (d16 != null) {
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                return arrayList;
            }
        }
        bannerRequest$fetchBanners$1 = new BannerRequest$fetchBanners$1(this, continuation);
        BannerRequest$fetchBanners$1 bannerRequest$fetchBanners$122 = bannerRequest$fetchBanners$1;
        Object obj2 = bannerRequest$fetchBanners$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = bannerRequest$fetchBanners$122.label;
        boolean z172 = true;
        if (i3 != 0) {
        }
        p16 = ((Response) obj2).data.p("response");
        ArrayList arrayList2 = new ArrayList();
        if (!(p16.length() != 0)) {
        }
    }
}
