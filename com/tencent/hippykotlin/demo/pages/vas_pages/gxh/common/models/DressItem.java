package com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.models;

import b01.a;
import c01.c;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.vas_base.gxh.AppId;
import com.tencent.hippykotlin.demo.pages.vas_pages.gxh.common.FeeType;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
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
public final class DressItem implements a {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "appId", "getAppId()Lcom/tencent/hippykotlin/demo/pages/vas_base/gxh/AppId;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "itemId", "getItemId()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "image", "getImage()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "itemBgColor", "getItemBgColor()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "imageWidth", "getImageWidth()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "imageHeight", "getImageHeight()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "name", "getName()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "price", "getPrice()F", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, VipFunCallConstants.KEY_FEET_TYPE, "getFeeType()Lcom/tencent/hippykotlin/demo/pages/vas_pages/gxh/common/FeeType;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "isBlindBox", "isBlindBox()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "svipLevel", "getSvipLevel()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "strRuleID", "getStrRuleID()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "hideZeroPrice", "getHideZeroPrice()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "discount", "getDiscount()Lcom/tencent/hippykotlin/demo/pages/vas_pages/gxh/common/models/DressItem$Discount;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "extraImages", "getExtraImages()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "immersiveMaterial", "getImmersiveMaterial()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "labels", "getLabels()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "messageBottomTabOne", "getMessageBottomTabOne()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "messageBottomTabTwo", "getMessageBottomTabTwo()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "messageBottomTabThree", "getMessageBottomTabThree()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "messageBottomTabFour", "getMessageBottomTabFour()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "aioBottomTabOne", "getAioBottomTabOne()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "aioBottomTabTwo", "getAioBottomTabTwo()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "aioBottomTabThree", "getAioBottomTabThree()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "aioBottomTabFour", "getAioBottomTabFour()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "aioBottomTabFive", "getAioBottomTabFive()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "aioBottomTabSix", "getAioBottomTabSix()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "drawerBottomTabOne", "getDrawerBottomTabOne()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "drawerBottomTabTwo", "getDrawerBottomTabTwo()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "aioBg", "getAioBg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "drawerBg", "getDrawerBg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "messageBg", "getMessageBg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "bottomBg", "getBottomBg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "headerBg", "getHeaderBg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(DressItem.class, "searchBar", "getSearchBar()Ljava/lang/String;", 0)};
    public final ReadWriteProperty discount$delegate;
    public final ReadWriteProperty extraImages$delegate;
    public final ReadWriteProperty feeType$delegate;
    public final ReadWriteProperty hideZeroPrice$delegate;
    public final ReadWriteProperty imageHeight$delegate;
    public final ReadWriteProperty imageWidth$delegate;
    public final ReadWriteProperty immersiveMaterial$delegate;
    public final ReadWriteProperty isBlindBox$delegate;
    public final ReadWriteProperty labels$delegate;
    public final ReadWriteProperty name$delegate;
    public final ReadWriteProperty price$delegate;
    public final ReadWriteProperty strRuleID$delegate;
    public final ReadWriteProperty svipLevel$delegate;
    public final ReadWriteProperty appId$delegate = c.a(AppId.NONE);
    public final ReadWriteProperty itemId$delegate = c.a(0);
    public final ReadWriteProperty image$delegate = c.a("");
    public final ReadWriteProperty itemBgColor$delegate = c.a("");

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Discount implements a {
        public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Discount.class, "type", "getType()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Discount.class, "userCanDiscount", "getUserCanDiscount()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Discount.class, "discountPrice", "getDiscountPrice()F", 0)};
        public final ReadWriteProperty type$delegate = c.a("");
        public final ReadWriteProperty userCanDiscount$delegate = c.a(Boolean.FALSE);
        public final ReadWriteProperty discountPrice$delegate = c.a(Float.valueOf(0.0f));

        @Override // b01.a
        public final void deserialization(e eVar) {
            e m3 = eVar.m("itemDiscount");
            if (m3 != null) {
                String p16 = m3.p("type");
                ReadWriteProperty readWriteProperty = this.type$delegate;
                KProperty<?>[] kPropertyArr = $$delegatedProperties;
                readWriteProperty.setValue(this, kPropertyArr[0], p16);
                this.userCanDiscount$delegate.setValue(this, kPropertyArr[1], Boolean.valueOf(m3.f("userCanDiscount")));
                this.discountPrice$delegate.setValue(this, kPropertyArr[2], Float.valueOf(m3.j("discountPrice") / 100.0f));
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static final class Label implements a {
        public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Label.class, "backgroundColorValue", "getBackgroundColorValue()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Label.class, "fontColorValue", "getFontColorValue()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Label.class, "msg", "getMsg()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(Label.class, WadlProxyConsts.KEY_JUMP_URL, "getJumpUrl()Ljava/lang/String;", 0)};
        public final ReadWriteProperty backgroundColorValue$delegate = c.a("");
        public final ReadWriteProperty fontColorValue$delegate = c.a("");
        public final ReadWriteProperty msg$delegate = c.a("");
        public final ReadWriteProperty jumpUrl$delegate = c.a("");

        @Override // b01.a
        public final void deserialization(e eVar) {
            String p16 = eVar.p("backgroundColorValue");
            ReadWriteProperty readWriteProperty = this.backgroundColorValue$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            readWriteProperty.setValue(this, kPropertyArr[0], p16);
            this.fontColorValue$delegate.setValue(this, kPropertyArr[1], eVar.p("fontColorValue"));
            this.msg$delegate.setValue(this, kPropertyArr[2], eVar.p("msg"));
            this.jumpUrl$delegate.setValue(this, kPropertyArr[3], eVar.p(WadlProxyConsts.KEY_JUMP_URL));
        }
    }

    public DressItem() {
        Float valueOf = Float.valueOf(0.0f);
        this.imageWidth$delegate = c.a(valueOf);
        this.imageHeight$delegate = c.a(valueOf);
        this.name$delegate = c.a("");
        this.price$delegate = c.a(valueOf);
        this.feeType$delegate = c.a(FeeType.FREE);
        Boolean bool = Boolean.FALSE;
        this.isBlindBox$delegate = c.a(bool);
        this.svipLevel$delegate = c.a(0);
        this.strRuleID$delegate = c.a("");
        this.hideZeroPrice$delegate = c.a(bool);
        this.discount$delegate = c.a(new Discount());
        this.extraImages$delegate = c.b();
        this.immersiveMaterial$delegate = c.a("");
        this.labels$delegate = c.b();
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_tab_icon_1_selected.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_tab_icon_5.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_tab_icon_2.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_tab_icon_4.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_aio_panel_ptt_nor.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_aio_panel_image_nor.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_aio_panel_camera_nor.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_aio_panel_hongbao_nor.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_aio_panel_emotion_nor.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_aio_more_nor.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/qq_setting_setting_white.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/qq_setting_me_nightmode_off_white.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_chat_background.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/qq_setting_me_bg.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_background.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_bottom_bar_background_theme_version2.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_header_bar_bg.9.png");
        c.a("https://tianquan.gtimg.cn/__test__/immersive/theme/1045169/skin_searchbar_input_theme_version2.9.png");
    }

    @Override // b01.a
    public final void deserialization(e eVar) {
        FeeType feeType;
        AppId appId;
        List listOf;
        Object d16;
        b l3;
        Object d17;
        Object d18;
        int j3 = eVar.j("appId");
        AppId[] values = AppId.values();
        int length = values.length;
        int i3 = 0;
        while (true) {
            feeType = null;
            if (i3 >= length) {
                appId = null;
                break;
            }
            appId = values[i3];
            if (appId.value == j3) {
                break;
            } else {
                i3++;
            }
        }
        if (appId == null) {
            appId = AppId.NONE;
        }
        ReadWriteProperty readWriteProperty = this.appId$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], appId);
        this.itemId$delegate.setValue(this, kPropertyArr[1], Integer.valueOf(eVar.j("itemId")));
        this.image$delegate.setValue(this, kPropertyArr[2], eVar.p("image"));
        this.name$delegate.setValue(this, kPropertyArr[6], eVar.p("name"));
        this.itemBgColor$delegate.setValue(this, kPropertyArr[3], eVar.p("itemBgColor"));
        int j16 = eVar.j(VipFunCallConstants.KEY_FEET_TYPE);
        FeeType[] values2 = FeeType.values();
        int length2 = values2.length;
        int i16 = 0;
        while (true) {
            if (i16 >= length2) {
                break;
            }
            FeeType feeType2 = values2[i16];
            if (feeType2.value == j16) {
                feeType = feeType2;
                break;
            }
            i16++;
        }
        if (feeType == null) {
            feeType = FeeType.UNKNOWN;
        }
        this.feeType$delegate.setValue(this, kPropertyArr[8], feeType);
        this.strRuleID$delegate.setValue(this, kPropertyArr[11], eVar.p("strRuleID"));
        e m3 = eVar.m("extrainfo");
        if (m3 != null) {
            this.price$delegate.setValue(this, kPropertyArr[7], Float.valueOf(m3.j("price") / 100.0f));
            this.svipLevel$delegate.setValue(this, kPropertyArr[10], Integer.valueOf(m3.j("svipLevel")));
        }
        e m16 = eVar.m("extraappinfo");
        if (m16 != null) {
            ArrayList arrayList = new ArrayList();
            b l16 = m16.l("multOperationType");
            if (l16 != null) {
                int c16 = l16.c();
                for (int i17 = 0; i17 < c16; i17++) {
                    if (BooleanCompanionObject.INSTANCE instanceof Integer) {
                        d18 = Boolean.valueOf(l16.e(i17));
                    } else if (IntCompanionObject.INSTANCE instanceof Integer) {
                        d18 = Integer.valueOf(l16.i(i17));
                    } else if (LongCompanionObject.INSTANCE instanceof Integer) {
                        d18 = Long.valueOf(l16.m(i17));
                    } else if (StringCompanionObject.INSTANCE instanceof Integer) {
                        d18 = l16.o(i17);
                    } else if (DoubleCompanionObject.INSTANCE instanceof Integer) {
                        d18 = Double.valueOf(l16.g(i17));
                    } else {
                        d18 = l16.d(i17);
                    }
                    if (d18 != null) {
                        arrayList.add(Integer.valueOf(((Integer) d18).intValue()));
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                    }
                }
            }
            boolean contains = arrayList.contains(3);
            ReadWriteProperty readWriteProperty2 = this.isBlindBox$delegate;
            KProperty<?>[] kPropertyArr2 = $$delegatedProperties;
            readWriteProperty2.setValue(this, kPropertyArr2[9], Boolean.valueOf(contains));
            e m17 = m16.m("extraInfo");
            if (m17 != null) {
                this.immersiveMaterial$delegate.setValue(this, kPropertyArr2[15], m17.p("immersiveMaterial"));
            }
        }
        e m18 = eVar.m("discount");
        if (m18 != null) {
            Discount discount = new Discount();
            m18.r(discount);
            this.discount$delegate.setValue(this, $$delegatedProperties[13], discount);
        }
        e m19 = eVar.m("extraimage");
        if (m19 != null && (l3 = m19.l("images")) != null) {
            int c17 = l3.c();
            for (int i18 = 0; i18 < c17; i18++) {
                if (BooleanCompanionObject.INSTANCE instanceof String) {
                    d17 = Boolean.valueOf(l3.e(i18));
                } else if (IntCompanionObject.INSTANCE instanceof String) {
                    d17 = Integer.valueOf(l3.i(i18));
                } else if (LongCompanionObject.INSTANCE instanceof String) {
                    d17 = Long.valueOf(l3.m(i18));
                } else if (StringCompanionObject.INSTANCE instanceof String) {
                    d17 = l3.o(i18);
                } else if (DoubleCompanionObject.INSTANCE instanceof String) {
                    d17 = Double.valueOf(l3.g(i18));
                } else {
                    d17 = l3.d(i18);
                }
                if (d17 != null) {
                    ((com.tencent.kuikly.core.reactive.collection.c) this.extraImages$delegate.getValue(this, $$delegatedProperties[14])).add((String) d17);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
                }
            }
        }
        ArrayList arrayList2 = new ArrayList();
        b l17 = eVar.l("labels");
        if (l17 != null) {
            int c18 = l17.c();
            for (int i19 = 0; i19 < c18; i19++) {
                if (BooleanCompanionObject.INSTANCE instanceof e) {
                    d16 = Boolean.valueOf(l17.e(i19));
                } else if (IntCompanionObject.INSTANCE instanceof e) {
                    d16 = Integer.valueOf(l17.i(i19));
                } else if (LongCompanionObject.INSTANCE instanceof e) {
                    d16 = Long.valueOf(l17.m(i19));
                } else if (StringCompanionObject.INSTANCE instanceof e) {
                    d16 = l17.o(i19);
                } else if (DoubleCompanionObject.INSTANCE instanceof e) {
                    d16 = Double.valueOf(l17.g(i19));
                } else {
                    d16 = l17.d(i19);
                }
                if (d16 != null) {
                    Label label = new Label();
                    ((e) d16).r(label);
                    arrayList2.add(label);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                }
            }
        }
        ReadWriteProperty readWriteProperty3 = this.labels$delegate;
        KProperty<?>[] kPropertyArr3 = $$delegatedProperties;
        ((com.tencent.kuikly.core.reactive.collection.c) readWriteProperty3.getValue(this, kPropertyArr3[16])).clear();
        ((com.tencent.kuikly.core.reactive.collection.c) this.labels$delegate.getValue(this, kPropertyArr3[16])).addAll(arrayList2);
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new AppId[]{AppId.CARD, AppId.CHATBG, AppId.THEME, AppId.FUNCALL});
        int i26 = listOf.contains(getAppId()) ? 168 : 112;
        this.imageWidth$delegate.setValue(this, kPropertyArr3[4], Float.valueOf(eVar.k("width", 112)));
        this.imageHeight$delegate.setValue(this, kPropertyArr3[5], Float.valueOf(eVar.k("height", i26)));
    }

    public final AppId getAppId() {
        return (AppId) this.appId$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final FeeType getFeeType() {
        return (FeeType) this.feeType$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final float getPrice() {
        return ((Number) this.price$delegate.getValue(this, $$delegatedProperties[7])).floatValue();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DressItem)) {
            return false;
        }
        DressItem dressItem = (DressItem) obj;
        if (getAppId() == dressItem.getAppId()) {
            ReadWriteProperty readWriteProperty = this.itemId$delegate;
            KProperty<?>[] kPropertyArr = $$delegatedProperties;
            if (((Number) readWriteProperty.getValue(this, kPropertyArr[1])).intValue() == ((Number) dressItem.itemId$delegate.getValue(dressItem, kPropertyArr[1])).intValue() && Intrinsics.areEqual((String) this.image$delegate.getValue(this, kPropertyArr[2]), (String) dressItem.image$delegate.getValue(dressItem, kPropertyArr[2])) && Intrinsics.areEqual((String) this.name$delegate.getValue(this, kPropertyArr[6]), (String) dressItem.name$delegate.getValue(dressItem, kPropertyArr[6])) && getFeeType() == dressItem.getFeeType()) {
                return true;
            }
        }
        return false;
    }
}
