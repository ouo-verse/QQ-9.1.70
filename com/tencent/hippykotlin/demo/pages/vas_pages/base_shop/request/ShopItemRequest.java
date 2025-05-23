package com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.view.AgreementConsentViewKt$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.VasBasePage;
import com.tencent.hippykotlin.demo.pages.vas_base.krequest.Response;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.GoodsItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.ItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TagsItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.data.TittleItemData;
import com.tencent.hippykotlin.demo.pages.vas_pages.base_shop.request.BaseRequest;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.reactive.collection.c;
import com.tencent.mobileqq.emoticon.IEPRecommendTask;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import java.util.List;
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
public final class ShopItemRequest {
    public static final Companion Companion = new Companion();

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public final ArrayList<ItemData> transformData(String str) {
            Object d16;
            Object d17;
            ArrayList<ItemData> arrayList = new ArrayList<>();
            char c16 = 1;
            int i3 = 0;
            if (str.length() == 0) {
                return arrayList;
            }
            try {
                b l3 = new e(str).l("modData");
                if (l3 != null) {
                    int c17 = l3.c();
                    int i16 = 0;
                    while (i16 < c17) {
                        if (BooleanCompanionObject.INSTANCE instanceof e) {
                            d16 = Boolean.valueOf(l3.e(i16));
                        } else if (IntCompanionObject.INSTANCE instanceof e) {
                            d16 = Integer.valueOf(l3.i(i16));
                        } else if (LongCompanionObject.INSTANCE instanceof e) {
                            d16 = Long.valueOf(l3.m(i16));
                        } else if (StringCompanionObject.INSTANCE instanceof e) {
                            d16 = l3.o(i16);
                        } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                            d16 = Double.valueOf(l3.g(i16));
                        } else {
                            d16 = l3.d(i16);
                        }
                        if (d16 != null) {
                            e eVar = (e) d16;
                            String p16 = eVar.p("cname");
                            TittleItemData tittleItemData = new TittleItemData();
                            ReadWriteProperty readWriteProperty = tittleItemData.title$delegate;
                            KProperty<?>[] kPropertyArr = TittleItemData.$$delegatedProperties;
                            readWriteProperty.setValue(tittleItemData, kPropertyArr[i3], p16);
                            e m3 = eVar.m("extModParams");
                            if (m3 != null) {
                                m3.p("NoMore");
                                m3.p("str_ruleid");
                                tittleItemData.modecnt$delegate.setValue(tittleItemData, kPropertyArr[c16], m3.p("modecnt"));
                                tittleItemData.contextSession$delegate.setValue(tittleItemData, kPropertyArr[5], m3.p("ContextSession"));
                                tittleItemData.url$delegate.setValue(tittleItemData, kPropertyArr[3], m3.p("url"));
                                tittleItemData.leftcnt$delegate.setValue(tittleItemData, kPropertyArr[2], m3.p("leftcnt"));
                                tittleItemData.mainColor$delegate.setValue(tittleItemData, kPropertyArr[4], m3.p("mainColor"));
                            }
                            arrayList.add(tittleItemData);
                            b l16 = eVar.l("vitem");
                            if (l16 != null) {
                                int c18 = l16.c();
                                int i17 = i3;
                                while (i17 < c18) {
                                    if (BooleanCompanionObject.INSTANCE instanceof e) {
                                        d17 = Boolean.valueOf(l16.e(i17));
                                    } else if (IntCompanionObject.INSTANCE instanceof e) {
                                        d17 = Integer.valueOf(l16.i(i17));
                                    } else if (LongCompanionObject.INSTANCE instanceof e) {
                                        d17 = Long.valueOf(l16.m(i17));
                                    } else if (StringCompanionObject.INSTANCE instanceof e) {
                                        d17 = l16.o(i17);
                                    } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                                        d17 = Double.valueOf(l16.g(i17));
                                    } else {
                                        d17 = l16.d(i17);
                                    }
                                    if (d17 != null) {
                                        e eVar2 = (e) d17;
                                        GoodsItemData goodsItemData = new GoodsItemData();
                                        e m16 = eVar2.m(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
                                        b bVar = l3;
                                        int i18 = c17;
                                        b bVar2 = l16;
                                        int i19 = c18;
                                        int i26 = i16;
                                        if (m16 == null) {
                                            goodsItemData.setTitle(eVar2.p("name"));
                                            goodsItemData.setUrl(eVar2.p("image"));
                                            goodsItemData.setType(eVar2.p(VipFunCallConstants.KEY_FEET_TYPE));
                                            String p17 = eVar2.p("itemId");
                                            if (Intrinsics.areEqual(p17, "")) {
                                                p17 = "" + eVar2.j("itemId");
                                            }
                                            goodsItemData.setItemId(p17);
                                            goodsItemData.setPrice((eVar2.m("extrainfo") != null ? r2.j("price") : 0) / 100.0f);
                                        } else {
                                            goodsItemData.setTitle(m16.p("name"));
                                            goodsItemData.setUrl(m16.p("image"));
                                            goodsItemData.setType(m16.p(VipFunCallConstants.KEY_FEET_TYPE));
                                            String p18 = m16.p("itemId");
                                            if (Intrinsics.areEqual(p18, "")) {
                                                p18 = "" + m16.j("itemId");
                                            }
                                            goodsItemData.setItemId(p18);
                                            goodsItemData.setPrice((m16.m("extrainfo") != null ? r2.j("price") : 0) / 100.0f);
                                        }
                                        e m17 = eVar.m("extModParams");
                                        if (m17 != null) {
                                            m17.p("str_ruleid");
                                        }
                                        arrayList.add(goodsItemData);
                                        i17++;
                                        l3 = bVar;
                                        c17 = i18;
                                        l16 = bVar2;
                                        c18 = i19;
                                        i16 = i26;
                                    } else {
                                        throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                    }
                                }
                            }
                            i16++;
                            l3 = l3;
                            c17 = c17;
                            c16 = 1;
                            i3 = 0;
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
            } catch (Exception unused) {
            }
            return arrayList;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00cd A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchTags(VasBasePage vasBasePage, String str, Continuation<? super TagsItemData> continuation) {
        ShopItemRequest$fetchTags$1 shopItemRequest$fetchTags$1;
        Object coroutine_suspended;
        int i3;
        String p16;
        Object d16;
        if (continuation instanceof ShopItemRequest$fetchTags$1) {
            shopItemRequest$fetchTags$1 = (ShopItemRequest$fetchTags$1) continuation;
            int i16 = shopItemRequest$fetchTags$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                shopItemRequest$fetchTags$1.label = i16 - Integer.MIN_VALUE;
                ShopItemRequest$fetchTags$1 shopItemRequest$fetchTags$12 = shopItemRequest$fetchTags$1;
                Object obj = shopItemRequest$fetchTags$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = shopItemRequest$fetchTags$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    BaseRequest.Companion companion = BaseRequest.Companion;
                    e eVar = new e();
                    eVar.z("appid", Boxing.boxInt(Integer.parseInt(str)));
                    e eVar2 = new e();
                    eVar2.z("iKeyType", Boxing.boxInt(1));
                    int i17 = 2;
                    if (vasBasePage.platformApi.getVasModule().getPlatformType() != 1) {
                        i17 = vasBasePage.platformApi.getVasModule().getPlatformType() == 2 ? 3 : 0;
                    }
                    eVar2.z("iOpplat", Boxing.boxInt(i17));
                    eVar2.z("sClientIp", "");
                    eVar2.z("sClientVer", vasBasePage.platformApi.getVasModule().getMainClientVersion());
                    Unit unit = Unit.INSTANCE;
                    eVar.z("stLogin", eVar2);
                    String m3 = AgreementConsentViewKt$$ExternalSyntheticOutline0.m("shop", str);
                    shopItemRequest$fetchTags$12.label = 1;
                    obj = companion.buildBaseRequest(vasBasePage, "https://zb.vip.qq.com/trpc-proxy/qqva/qc_submall_server/qc_submall_server/GetTags", eVar, m3, shopItemRequest$fetchTags$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                p16 = ((Response) obj).data.p("response");
                if (!(p16.length() == 0)) {
                    return null;
                }
                TagsItemData tagsItemData = new TagsItemData();
                tagsItemData.jumpAllUrl = "https://zb.vip.qq.com/v2/pages/classifyPage?_wv=1027&appid=8";
                b l3 = new e(p16).l(ComicCancelRedPointPopItemData.JSON_KEY_TAGS);
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
                            e eVar3 = (e) d16;
                            if (tagsItemData.getTags().size() < 8) {
                                c<TagsItemData.TagInfo> tags = tagsItemData.getTags();
                                String p17 = eVar3.p("name");
                                StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(IEPRecommendTask.PROMOTION_IMAGE_URL_PREFIX);
                                m16.append(eVar3.p("url"));
                                String sb5 = m16.toString();
                                StringBuilder m17 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("https://zb.vip.qq.com/v2/pages/classifyPage?_wv=1027&appid=8&tagname=");
                                m17.append(eVar3.p("name"));
                                tags.add(new TagsItemData.TagInfo(p17, sb5, m17.toString()));
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        }
                    }
                }
                return tagsItemData;
            }
        }
        shopItemRequest$fetchTags$1 = new ShopItemRequest$fetchTags$1(this, continuation);
        ShopItemRequest$fetchTags$1 shopItemRequest$fetchTags$122 = shopItemRequest$fetchTags$1;
        Object obj2 = shopItemRequest$fetchTags$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = shopItemRequest$fetchTags$122.label;
        if (i3 != 0) {
        }
        p16 = ((Response) obj2).data.p("response");
        if (!(p16.length() == 0)) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object firstRequest(VasBasePage vasBasePage, String str, Continuation<? super List<? extends ItemData>> continuation) {
        ShopItemRequest$firstRequest$1 shopItemRequest$firstRequest$1;
        Object coroutine_suspended;
        int i3;
        if (continuation instanceof ShopItemRequest$firstRequest$1) {
            shopItemRequest$firstRequest$1 = (ShopItemRequest$firstRequest$1) continuation;
            int i16 = shopItemRequest$firstRequest$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                shopItemRequest$firstRequest$1.label = i16 - Integer.MIN_VALUE;
                ShopItemRequest$firstRequest$1 shopItemRequest$firstRequest$12 = shopItemRequest$firstRequest$1;
                Object obj = shopItemRequest$firstRequest$12.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = shopItemRequest$firstRequest$12.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    BaseRequest.Companion companion = BaseRequest.Companion;
                    e eVar = new e();
                    eVar.z("appid", Boxing.boxInt(Integer.parseInt(str)));
                    int i17 = 3;
                    eVar.z("locationtype", Boxing.boxInt(3));
                    eVar.z("mParams", new e());
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
                    shopItemRequest$firstRequest$12.label = 1;
                    obj = companion.buildBaseRequest(vasBasePage, "https://zb.vip.qq.com/trpc-proxy/qqva/qc_submall_server/qc_submall_server/GetChiefListV2", eVar, m3, shopItemRequest$firstRequest$12);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Companion.transformData(((Response) obj).data.p("response"));
            }
        }
        shopItemRequest$firstRequest$1 = new ShopItemRequest$firstRequest$1(this, continuation);
        ShopItemRequest$firstRequest$1 shopItemRequest$firstRequest$122 = shopItemRequest$firstRequest$1;
        Object obj2 = shopItemRequest$firstRequest$122.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = shopItemRequest$firstRequest$122.label;
        if (i3 != 0) {
        }
        return Companion.transformData(((Response) obj2).data.p("response"));
    }
}
