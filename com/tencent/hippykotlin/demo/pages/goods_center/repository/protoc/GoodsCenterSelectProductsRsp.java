package com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc;

import androidx.core.app.NotificationCompat;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.base.ISSOModel;
import com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory;
import com.tencent.hippykotlin.demo.pages.base.protoc.Btn;
import com.tencent.hippykotlin.demo.pages.base.protoc.Icon;
import com.tencent.hippykotlin.demo.pages.base.protoc.MsgBox;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterFilterOption;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterOrderBy;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.startup.step.InitSkin;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.ProcessConstant;

/* loaded from: classes31.dex */
public final class GoodsCenterSelectProductsRsp implements ISSOModel {
    public static final Companion Companion = new Companion();
    public static final ISSOModelFactory<GoodsCenterSelectProductsRsp> Factory = new ISSOModelFactory<GoodsCenterSelectProductsRsp>() { // from class: com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterSelectProductsRsp$Companion$Factory$1
        @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModelFactory
        public final GoodsCenterSelectProductsRsp decode(e eVar) {
            return GoodsCenterSelectProductsRsp.Companion.decode(eVar);
        }
    };
    public final String backgroundUrl;
    public final ArrayList<GoodsCenterCategory> categoryList;
    public final String cookie;
    public final GoodsCenterFilter filter;
    public final ArrayList<GoodsCenterFilterCond> filterCondList;
    public final boolean isEnd;
    public final MsgBox msgBox;
    public final GoodsCenterSelectionCenter navigation;
    public final ArrayList<GoodsCenterOrderBy> orderByList;
    public final ArrayList<GoodsCenterProductInfo> productList;
    public final ArrayList<GoodsCenterRangeCond> rangeCond;
    public final int total;
    public final GoodsCenterTodayTurnover turnover;

    public GoodsCenterSelectProductsRsp() {
        this(null, false, null, null, null, null, null, null, null, null, null, 0, null, InitSkin.DRAWABLE_COUNT, null);
    }

    @Override // com.tencent.hippykotlin.demo.pages.base.ISSOModel
    public final e encode() {
        e eVar = new e();
        eVar.v("cookie", this.cookie);
        eVar.w("is_end", this.isEnd);
        b bVar = new b();
        ArrayList<GoodsCenterProductInfo> arrayList = this.productList;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                bVar.t(((GoodsCenterProductInfo) it.next()).encode());
            }
        }
        b m3 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "product_list", bVar);
        ArrayList<GoodsCenterCategory> arrayList2 = this.categoryList;
        if (arrayList2 != null) {
            Iterator<T> it5 = arrayList2.iterator();
            while (it5.hasNext()) {
                m3.t(((GoodsCenterCategory) it5.next()).encode());
            }
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "category_list", m3);
        ArrayList<GoodsCenterOrderBy> arrayList3 = this.orderByList;
        if (arrayList3 != null) {
            Iterator<T> it6 = arrayList3.iterator();
            while (it6.hasNext()) {
                m16.t(((GoodsCenterOrderBy) it6.next()).encode());
            }
        }
        b m17 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "order_by_list", m16);
        ArrayList<GoodsCenterFilterCond> arrayList4 = this.filterCondList;
        if (arrayList4 != null) {
            Iterator<T> it7 = arrayList4.iterator();
            while (it7.hasNext()) {
                m17.t(((GoodsCenterFilterCond) it7.next()).encode());
            }
        }
        b m18 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "filter_cond_list", m17);
        ArrayList<GoodsCenterRangeCond> arrayList5 = this.rangeCond;
        if (arrayList5 != null) {
            Iterator<T> it8 = arrayList5.iterator();
            while (it8.hasNext()) {
                m18.t(((GoodsCenterRangeCond) it8.next()).encode());
            }
        }
        eVar.v("range_cond", m18);
        GoodsCenterTodayTurnover goodsCenterTodayTurnover = this.turnover;
        if (goodsCenterTodayTurnover != null) {
            eVar.v("turnover", goodsCenterTodayTurnover.encode());
        }
        GoodsCenterSelectionCenter goodsCenterSelectionCenter = this.navigation;
        if (goodsCenterSelectionCenter != null) {
            eVar.v(NotificationCompat.CATEGORY_NAVIGATION, goodsCenterSelectionCenter.encode());
        }
        eVar.v(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, this.backgroundUrl);
        MsgBox msgBox = this.msgBox;
        if (msgBox != null) {
            eVar.v("msg_box", msgBox.encode());
        }
        eVar.t("total", this.total);
        GoodsCenterFilter goodsCenterFilter = this.filter;
        if (goodsCenterFilter != null) {
            eVar.v("filter", goodsCenterFilter.encode());
        }
        return eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final int hashCode() {
        int hashCode = this.cookie.hashCode() * 31;
        boolean z16 = this.isEnd;
        int i3 = z16;
        if (z16 != 0) {
            i3 = 1;
        }
        int i16 = (hashCode + i3) * 31;
        ArrayList<GoodsCenterProductInfo> arrayList = this.productList;
        int hashCode2 = (i16 + (arrayList == null ? 0 : arrayList.hashCode())) * 31;
        ArrayList<GoodsCenterCategory> arrayList2 = this.categoryList;
        int hashCode3 = (hashCode2 + (arrayList2 == null ? 0 : arrayList2.hashCode())) * 31;
        ArrayList<GoodsCenterOrderBy> arrayList3 = this.orderByList;
        int hashCode4 = (hashCode3 + (arrayList3 == null ? 0 : arrayList3.hashCode())) * 31;
        ArrayList<GoodsCenterFilterCond> arrayList4 = this.filterCondList;
        int hashCode5 = (hashCode4 + (arrayList4 == null ? 0 : arrayList4.hashCode())) * 31;
        ArrayList<GoodsCenterRangeCond> arrayList5 = this.rangeCond;
        int hashCode6 = (hashCode5 + (arrayList5 == null ? 0 : arrayList5.hashCode())) * 31;
        GoodsCenterTodayTurnover goodsCenterTodayTurnover = this.turnover;
        int hashCode7 = (hashCode6 + (goodsCenterTodayTurnover == null ? 0 : goodsCenterTodayTurnover.hashCode())) * 31;
        GoodsCenterSelectionCenter goodsCenterSelectionCenter = this.navigation;
        int m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.backgroundUrl, (hashCode7 + (goodsCenterSelectionCenter == null ? 0 : goodsCenterSelectionCenter.hashCode())) * 31, 31);
        MsgBox msgBox = this.msgBox;
        int m16 = QQAudioParams$$ExternalSyntheticOutline0.m(this.total, (m3 + (msgBox == null ? 0 : msgBox.hashCode())) * 31, 31);
        GoodsCenterFilter goodsCenterFilter = this.filter;
        return m16 + (goodsCenterFilter != null ? goodsCenterFilter.hashCode() : 0);
    }

    public final String toString() {
        return "GoodsCenterSelectProductsRsp(cookie=" + this.cookie + ", isEnd=" + this.isEnd + ", productList=" + this.productList + ", categoryList=" + this.categoryList + ", orderByList=" + this.orderByList + ", filterCondList=" + this.filterCondList + ", rangeCond=" + this.rangeCond + ", turnover=" + this.turnover + ", navigation=" + this.navigation + ", backgroundUrl=" + this.backgroundUrl + ", msgBox=" + this.msgBox + ", total=" + this.total + ", filter=" + this.filter + ')';
    }

    /* loaded from: classes31.dex */
    public static final class Companion {
        public final GoodsCenterSelectProductsRsp decode(e eVar) {
            ArrayList arrayList;
            String str;
            ArrayList arrayList2;
            ArrayList arrayList3;
            ArrayList arrayList4;
            ArrayList arrayList5;
            ArrayList arrayList6;
            ArrayList arrayList7;
            ArrayList arrayList8;
            GoodsCenterTodayTurnover goodsCenterTodayTurnover;
            GoodsCenterSelectionCenter goodsCenterSelectionCenter;
            GoodsCenterSelectionCenter goodsCenterSelectionCenter2;
            String str2;
            MsgBox msgBox;
            Btn btn;
            ArrayList arrayList9;
            b bVar;
            String str3;
            String str4;
            String str5;
            ArrayList arrayList10;
            ArrayList arrayList11;
            b bVar2;
            ArrayList arrayList12;
            b bVar3;
            ArrayList arrayList13;
            int i3;
            ArrayList arrayList14;
            String str6;
            String q16 = eVar.q("cookie", "");
            boolean g16 = eVar.g("is_end", false);
            b l3 = eVar.l("product_list");
            String str7 = "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject";
            if (l3 != null) {
                arrayList = new ArrayList();
                int c16 = l3.c();
                for (int i16 = 0; i16 < c16; i16++) {
                    Object d16 = l3.d(i16);
                    if (d16 != null) {
                        GoodsCenterProductInfo.Companion companion = GoodsCenterProductInfo.Companion;
                        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        arrayList.add(companion.decode((e) d16));
                    }
                }
            } else {
                arrayList = null;
            }
            b l16 = eVar.l("category_list");
            long j3 = 0;
            if (l16 != null) {
                ArrayList arrayList15 = new ArrayList();
                int c17 = l16.c();
                int i17 = 0;
                while (i17 < c17) {
                    Object d17 = l16.d(i17);
                    if (d17 != null) {
                        Intrinsics.checkNotNull(d17, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar2 = (e) d17;
                        str6 = q16;
                        arrayList15.add(new GoodsCenterCategory(eVar2.o("id", j3), eVar2.q("name", ""), eVar2.k("goods_type", 0)));
                    } else {
                        str6 = q16;
                    }
                    i17++;
                    q16 = str6;
                    j3 = 0;
                }
                str = q16;
                arrayList2 = arrayList15;
            } else {
                str = q16;
                arrayList2 = null;
            }
            b l17 = eVar.l("order_by_list");
            if (l17 != null) {
                ArrayList arrayList16 = new ArrayList();
                int c18 = l17.c();
                for (int i18 = 0; i18 < c18; i18++) {
                    Object d18 = l17.d(i18);
                    if (d18 != null) {
                        GoodsCenterOrderBy.Companion companion2 = GoodsCenterOrderBy.Companion;
                        Intrinsics.checkNotNull(d18, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        GoodsCenterOrderBy decode = companion2.decode((e) d18);
                        if (i18 == 0) {
                            decode.setCurIsSelected(true);
                        }
                        arrayList16.add(decode);
                    }
                }
                arrayList3 = arrayList16;
            } else {
                arrayList3 = null;
            }
            b l18 = eVar.l("filter_cond_list");
            if (l18 != null) {
                arrayList6 = new ArrayList();
                int c19 = l18.c();
                int i19 = 0;
                while (i19 < c19) {
                    Object d19 = l18.d(i19);
                    if (d19 != null) {
                        Intrinsics.checkNotNull(d19, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar3 = (e) d19;
                        int k3 = eVar3.k("type", 0);
                        String q17 = eVar3.q("name", "");
                        ArrayList arrayList17 = new ArrayList();
                        bVar3 = l18;
                        b l19 = eVar3.l("options");
                        if (l19 != null) {
                            i3 = c19;
                            arrayList14 = new ArrayList();
                            arrayList12 = arrayList3;
                            int c26 = l19.c();
                            arrayList13 = arrayList2;
                            int i26 = 0;
                            while (i26 < c26) {
                                int i27 = c26;
                                Object d26 = l19.d(i26);
                                b bVar4 = l19;
                                if (d26 != null) {
                                    GoodsCenterFilterOption.Companion companion3 = GoodsCenterFilterOption.Companion;
                                    Intrinsics.checkNotNull(d26, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                                    arrayList14.add(companion3.decode((e) d26));
                                }
                                i26++;
                                c26 = i27;
                                l19 = bVar4;
                            }
                        } else {
                            arrayList12 = arrayList3;
                            arrayList13 = arrayList2;
                            i3 = c19;
                            arrayList14 = arrayList17;
                        }
                        arrayList6.add(new GoodsCenterFilterCond(k3, q17, arrayList14, eVar3.g(ProcessConstant.MULTI, false)));
                    } else {
                        arrayList12 = arrayList3;
                        bVar3 = l18;
                        arrayList13 = arrayList2;
                        i3 = c19;
                    }
                    i19++;
                    l18 = bVar3;
                    c19 = i3;
                    arrayList3 = arrayList12;
                    arrayList2 = arrayList13;
                }
                arrayList4 = arrayList3;
                arrayList5 = arrayList2;
            } else {
                arrayList4 = arrayList3;
                arrayList5 = arrayList2;
                arrayList6 = null;
            }
            b l26 = eVar.l("range_cond");
            if (l26 != null) {
                ArrayList arrayList18 = new ArrayList();
                int c27 = l26.c();
                for (int i28 = 0; i28 < c27; i28++) {
                    Object d27 = l26.d(i28);
                    if (d27 != null) {
                        Intrinsics.checkNotNull(d27, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                        e eVar4 = (e) d27;
                        arrayList18.add(new GoodsCenterRangeCond(eVar4.k("type", 0), eVar4.q("name", ""), -1L, eVar4.q("lower_txt", ""), -1L, eVar4.q("upper_txt", ""), eVar4.q("unit", ""), eVar4.o("min_limit", 0L), eVar4.o("max_limit", 0L), eVar4.q("err_toast", "")));
                    }
                }
                arrayList7 = arrayList18;
            } else {
                arrayList7 = null;
            }
            e m3 = eVar.m("turnover");
            String str8 = "event_code";
            String str9 = "msg";
            if (m3 != null) {
                b l27 = m3.l("turnover_infos");
                if (l27 != null) {
                    arrayList10 = new ArrayList();
                    int c28 = l27.c();
                    int i29 = 0;
                    while (i29 < c28) {
                        int i36 = c28;
                        Object d28 = l27.d(i29);
                        if (d28 != null) {
                            Intrinsics.checkNotNull(d28, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                            e eVar5 = (e) d28;
                            bVar2 = l27;
                            arrayList11 = arrayList7;
                            arrayList10.add(new GoodsCenterStringKV(eVar5.q("key", ""), eVar5.q("value", "")));
                        } else {
                            arrayList11 = arrayList7;
                            bVar2 = l27;
                        }
                        i29++;
                        c28 = i36;
                        l27 = bVar2;
                        arrayList7 = arrayList11;
                    }
                    arrayList8 = arrayList7;
                } else {
                    arrayList8 = arrayList7;
                    arrayList10 = null;
                }
                e m16 = m3.m("detail_button");
                goodsCenterTodayTurnover = new GoodsCenterTodayTurnover(arrayList10, m16 != null ? new Icon(m16.q("msg", ""), m16.q("url", ""), m16.q("img", ""), m16.q("event_code", "")) : null);
            } else {
                arrayList8 = arrayList7;
                goodsCenterTodayTurnover = null;
            }
            e m17 = eVar.m(NotificationCompat.CATEGORY_NAVIGATION);
            if (m17 != null) {
                b l28 = m17.l("buttons");
                if (l28 != null) {
                    arrayList9 = new ArrayList();
                    int c29 = l28.c();
                    int i37 = 0;
                    while (i37 < c29) {
                        Object d29 = l28.d(i37);
                        if (d29 != null) {
                            Intrinsics.checkNotNull(d29, str7);
                            e eVar6 = (e) d29;
                            bVar = l28;
                            str4 = str7;
                            str5 = str9;
                            str3 = str8;
                            arrayList9.add(new Icon(eVar6.q(str9, ""), eVar6.q("url", ""), eVar6.q("img", ""), eVar6.q(str8, "")));
                        } else {
                            bVar = l28;
                            str3 = str8;
                            str4 = str7;
                            str5 = str9;
                        }
                        i37++;
                        l28 = bVar;
                        str7 = str4;
                        str9 = str5;
                        str8 = str3;
                    }
                } else {
                    arrayList9 = null;
                }
                goodsCenterSelectionCenter = new GoodsCenterSelectionCenter(arrayList9);
            } else {
                goodsCenterSelectionCenter = null;
            }
            String q18 = eVar.q(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_BACKGROUND_URL, "");
            e m18 = eVar.m("msg_box");
            if (m18 != null) {
                boolean g17 = m18.g("display", false);
                String q19 = m18.q("title", "");
                String q26 = m18.q("text", "");
                e m19 = m18.m("left_btn");
                if (m19 != null) {
                    goodsCenterSelectionCenter2 = goodsCenterSelectionCenter;
                    str2 = q18;
                    btn = new Btn(m19.q("text", ""), m19.q("url", ""), m19.g("should_pop_page", false), m19.g("should_keep_msg_box", false));
                } else {
                    goodsCenterSelectionCenter2 = goodsCenterSelectionCenter;
                    str2 = q18;
                    btn = null;
                }
                e m26 = m18.m("right_btn");
                msgBox = new MsgBox(g17, q19, q26, btn, m26 != null ? new Btn(m26.q("text", ""), m26.q("url", ""), m26.g("should_pop_page", false), m26.g("should_keep_msg_box", false)) : null);
            } else {
                goodsCenterSelectionCenter2 = goodsCenterSelectionCenter;
                str2 = q18;
                msgBox = null;
            }
            int k16 = eVar.k("total", 0);
            e m27 = eVar.m("filter");
            return new GoodsCenterSelectProductsRsp(str, g16, arrayList, arrayList5, arrayList4, arrayList6, arrayList8, goodsCenterTodayTurnover, goodsCenterSelectionCenter2, str2, msgBox, k16, m27 != null ? GoodsCenterFilter.Companion.decode(m27) : null);
        }
    }

    public GoodsCenterSelectProductsRsp(String str, boolean z16, ArrayList<GoodsCenterProductInfo> arrayList, ArrayList<GoodsCenterCategory> arrayList2, ArrayList<GoodsCenterOrderBy> arrayList3, ArrayList<GoodsCenterFilterCond> arrayList4, ArrayList<GoodsCenterRangeCond> arrayList5, GoodsCenterTodayTurnover goodsCenterTodayTurnover, GoodsCenterSelectionCenter goodsCenterSelectionCenter, String str2, MsgBox msgBox, int i3, GoodsCenterFilter goodsCenterFilter) {
        this.cookie = str;
        this.isEnd = z16;
        this.productList = arrayList;
        this.categoryList = arrayList2;
        this.orderByList = arrayList3;
        this.filterCondList = arrayList4;
        this.rangeCond = arrayList5;
        this.turnover = goodsCenterTodayTurnover;
        this.navigation = goodsCenterSelectionCenter;
        this.backgroundUrl = str2;
        this.msgBox = msgBox;
        this.total = i3;
        this.filter = goodsCenterFilter;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsCenterSelectProductsRsp)) {
            return false;
        }
        GoodsCenterSelectProductsRsp goodsCenterSelectProductsRsp = (GoodsCenterSelectProductsRsp) obj;
        return Intrinsics.areEqual(this.cookie, goodsCenterSelectProductsRsp.cookie) && this.isEnd == goodsCenterSelectProductsRsp.isEnd && Intrinsics.areEqual(this.productList, goodsCenterSelectProductsRsp.productList) && Intrinsics.areEqual(this.categoryList, goodsCenterSelectProductsRsp.categoryList) && Intrinsics.areEqual(this.orderByList, goodsCenterSelectProductsRsp.orderByList) && Intrinsics.areEqual(this.filterCondList, goodsCenterSelectProductsRsp.filterCondList) && Intrinsics.areEqual(this.rangeCond, goodsCenterSelectProductsRsp.rangeCond) && Intrinsics.areEqual(this.turnover, goodsCenterSelectProductsRsp.turnover) && Intrinsics.areEqual(this.navigation, goodsCenterSelectProductsRsp.navigation) && Intrinsics.areEqual(this.backgroundUrl, goodsCenterSelectProductsRsp.backgroundUrl) && Intrinsics.areEqual(this.msgBox, goodsCenterSelectProductsRsp.msgBox) && this.total == goodsCenterSelectProductsRsp.total && Intrinsics.areEqual(this.filter, goodsCenterSelectProductsRsp.filter);
    }

    public /* synthetic */ GoodsCenterSelectProductsRsp(String str, boolean z16, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4, ArrayList arrayList5, GoodsCenterTodayTurnover goodsCenterTodayTurnover, GoodsCenterSelectionCenter goodsCenterSelectionCenter, String str2, MsgBox msgBox, int i3, GoodsCenterFilter goodsCenterFilter, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this("", false, null, null, null, null, null, null, null, "", null, 0, null);
    }
}
