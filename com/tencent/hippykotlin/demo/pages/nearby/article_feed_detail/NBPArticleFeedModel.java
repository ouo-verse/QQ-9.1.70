package com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail;

import c01.c;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.view.BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.goods_center.card.product.GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.comment.NBPFeedCommentsData;
import com.tencent.kuikly.core.base.h;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.relation.common.nt.api.impl.RelationNTPushServiceImpl;
import j25.b;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.ranges.RangesKt___RangesKt;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.Typography;
import n35.w;
import n35.z;
import org.apache.httpcore.message.TokenParser;
import p35.ac;
import p35.ag;
import p35.g;
import p35.n;
import s35.af;
import t35.a;

/* loaded from: classes31.dex */
public final class NBPArticleFeedModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "feed", "getFeed()Lkuikly/com/tencent/trpcprotocol/qqstranger/common/feed/Feed;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "contentText", "getContentText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "showDivider", "getShowDivider()Z", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "commentCount", "getCommentCount()I", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "imageUrl", "getImageUrl()Ljava/lang/Object;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "statusIcon", "getStatusIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "statusTitle", "getStatusTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "statusBgColor", "getStatusBgColor()Lcom/tencent/kuikly/core/base/Color;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "jiebanTagInfo", "getJiebanTagInfo()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NBPArticleFeedModel.class, "feedHadDeleted", "getFeedHadDeleted()Z", 0)};
    public final int appId;
    public final NBPFeedCommentsData commentsData;
    public Pair<Float, Float> coverSize;
    public final ReadWriteProperty feedHadDeleted$delegate;
    public final boolean isHeadFeed;
    public final ReadWriteProperty jiebanTagInfo$delegate;
    public final String myConstellation;
    public Function1<? super n, Unit> onFeedUpdateListener;
    public final ReadWriteProperty statusBgColor$delegate;
    public final ReadWriteProperty statusIcon$delegate;
    public final ReadWriteProperty statusTitle$delegate;
    public final int type;
    public final String viewerId;
    public final ReadWriteProperty feed$delegate = c.a(null);
    public final ReadWriteProperty contentText$delegate = c.a("");
    public final ReadWriteProperty showDivider$delegate = c.a(Boolean.TRUE);
    public final ReadWriteProperty commentCount$delegate = c.a(0);
    public NBPLikeData likeData = new NBPLikeData();
    public String headAvatar = "";
    public final ReadWriteProperty imageUrl$delegate = c.a(null);

    public NBPArticleFeedModel(int i3, String str, String str2, int i16, NBPFeedCommentsData nBPFeedCommentsData, boolean z16) {
        this.appId = i3;
        this.viewerId = str;
        this.myConstellation = str2;
        this.type = i16;
        this.commentsData = nBPFeedCommentsData;
        this.isHeadFeed = z16;
        Float valueOf = Float.valueOf(0.0f);
        this.coverSize = new Pair<>(valueOf, valueOf);
        this.statusIcon$delegate = c.a("");
        this.statusTitle$delegate = c.a("");
        this.statusBgColor$delegate = c.a(h.INSTANCE.j());
        this.jiebanTagInfo$delegate = c.a("");
        this.feedHadDeleted$delegate = c.a(Boolean.FALSE);
    }

    public final int getCommentCount() {
        return ((Number) this.commentCount$delegate.getValue(this, $$delegatedProperties[3])).intValue();
    }

    public final n getFeed() {
        return (n) this.feed$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean getFeedHadDeleted() {
        return ((Boolean) this.feedHadDeleted$delegate.getValue(this, $$delegatedProperties[9])).booleanValue();
    }

    public final Object getImageUrl() {
        return this.imageUrl$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final String getJiebanTagInfo() {
        return (String) this.jiebanTagInfo$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final String getStatusIcon() {
        return (String) this.statusIcon$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final String getStatusTitle() {
        return (String) this.statusTitle$delegate.getValue(this, $$delegatedProperties[6]);
    }

    public final boolean isHost() {
        af afVar;
        String str;
        af afVar2;
        if (this.appId == 2) {
            String str2 = this.viewerId;
            n feed = getFeed();
            if (feed == null || (afVar2 = feed.f425194e) == null || (str = Long.valueOf(afVar2.f433207e).toString()) == null) {
                str = "";
            }
            return Intrinsics.areEqual(str2, str);
        }
        String str3 = this.viewerId;
        n feed2 = getFeed();
        return Intrinsics.areEqual(str3, (feed2 == null || (afVar = feed2.f425194e) == null) ? null : afVar.f433205d);
    }

    public final void setCommentCount(int i3) {
        this.commentCount$delegate.setValue(this, $$delegatedProperties[3], Integer.valueOf(i3));
    }

    public final void setFeedHadDeleted() {
        this.feedHadDeleted$delegate.setValue(this, $$delegatedProperties[9], Boolean.TRUE);
    }

    public final void setShowDivider(boolean z16) {
        this.showDivider$delegate.setValue(this, $$delegatedProperties[2], Boolean.valueOf(z16));
    }

    public final List<a> sortJieBanLabelTag(List<a> list) {
        List<a> sortedWith;
        final NBPArticleFeedModel$sortJieBanLabelTag$1 nBPArticleFeedModel$sortJieBanLabelTag$1 = new Function2<a, a, Integer>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedModel$sortJieBanLabelTag$1
            @Override // kotlin.jvm.functions.Function2
            public final Integer invoke(a aVar, a aVar2) {
                int i3 = aVar.f435362d;
                int i16 = aVar2.f435362d;
                int i17 = 1;
                boolean z16 = 10001 <= i3 && i3 < 11111;
                boolean z17 = 10001 <= i16 && i16 < 11111;
                if (z16 && z17) {
                    i17 = i16 - i3;
                } else if (z16) {
                    i17 = -1;
                } else if (!z17) {
                    i17 = 0;
                }
                return Integer.valueOf(i17);
            }
        };
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(list, new Comparator() { // from class: ht0.a
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int intValue;
                intValue = ((Number) Function2.this.invoke(obj, obj2)).intValue();
                return intValue;
            }
        });
        return sortedWith;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02a8  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01bf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void updateFeed(n nVar) {
        String decodeToString;
        Object obj;
        boolean z16;
        List<a> emptyList;
        List<a> sortJieBanLabelTag;
        int size;
        String m3;
        List<a> emptyList2;
        List<a> emptyList3;
        Object firstOrNull;
        String str;
        af afVar;
        boolean z17;
        String str2;
        af afVar2;
        String str3;
        boolean startsWith$default;
        j25.c cVar;
        b bVar;
        j25.c cVar2;
        j25.c cVar3;
        String str4;
        j25.c cVar4;
        b bVar2;
        j25.c cVar5;
        b bVar3;
        j25.c cVar6;
        Object first;
        Pair<Float, Float> pair;
        Pair<Float, Float> pair2;
        float coerceAtLeast;
        float coerceAtLeast2;
        List<z> list;
        Object firstOrNull2;
        ReadWriteProperty readWriteProperty = this.feed$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[0], nVar);
        Function1<? super n, Unit> function1 = this.onFeedUpdateListener;
        if (function1 != null) {
            function1.invoke(nVar);
        }
        decodeToString = StringsKt__StringsJVMKt.decodeToString(nVar.f425197i.f30291a);
        this.contentText$delegate.setValue(this, kPropertyArr[1], decodeToString);
        NBPLikeData nBPLikeData = this.likeData;
        ac acVar = nVar.E;
        nBPLikeData.updateLiked(acVar != null && acVar.f425122h == 1);
        NBPLikeData nBPLikeData2 = this.likeData;
        ac acVar2 = nVar.E;
        nBPLikeData2.updateNumber(acVar2 != null ? acVar2.f425120e : 0);
        setCommentCount(nVar.G);
        if (getCommentCount() == 0) {
            g gVar = nVar.J;
            setCommentCount(gVar != null ? gVar.f425169d : 0);
        }
        if (!nVar.f425198m.isEmpty()) {
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) nVar.f425198m);
            ag agVar = (ag) first;
            com.tencent.kuikly.core.manager.c cVar7 = com.tencent.kuikly.core.manager.c.f117352a;
            float m16 = GoodsCenterProductView$body$1$1$3$$ExternalSyntheticOutline0.m(cVar7);
            float dpScaleDensity = PageDataExtKt.getDpScaleDensity(cVar7.g().getPageData());
            float f16 = m16 - 32;
            if (this.appId == 2) {
                pair = new Pair<>(Float.valueOf(f16), Float.valueOf((f16 / 3) * 4));
            } else {
                Pair<Float, Float> pair3 = new Pair<>(Float.valueOf(f16), Float.valueOf(f16));
                try {
                    float f17 = agVar.f425142h / dpScaleDensity;
                    float f18 = agVar.f425141f / dpScaleDensity;
                    float f19 = 0.42f * f16;
                    if (f17 >= f19 || f18 >= f19) {
                        float f26 = f17 / f18;
                        if (f26 >= 3.0f) {
                            pair2 = new Pair<>(Float.valueOf(f16), Float.valueOf(f19));
                        } else if (f18 / f17 >= 3.0f) {
                            pair2 = new Pair<>(Float.valueOf(f19), Float.valueOf(f16));
                        } else if (!(f17 > f18)) {
                            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(f26 * f16, f19);
                            pair2 = new Pair<>(Float.valueOf(coerceAtLeast), Float.valueOf(f16));
                        } else {
                            Float valueOf = Float.valueOf(f16);
                            coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(f16 / f26, f19);
                            pair2 = new Pair<>(valueOf, Float.valueOf(coerceAtLeast2));
                        }
                        pair = pair2;
                    } else {
                        pair = new Pair<>(Float.valueOf(f19), Float.valueOf(f19));
                    }
                } catch (Throwable th5) {
                    AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("e: ", th5, KLog.INSTANCE, "getCoverSize");
                    pair = pair3;
                }
            }
            this.coverSize = pair;
            if (this.appId == 2) {
                w wVar = agVar.f425139d;
                if (wVar != null && (list = wVar.f418273d) != null) {
                    firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    z zVar = (z) firstOrNull2;
                    if (zVar != null) {
                        obj = zVar.f418280d;
                    }
                }
            } else {
                obj = agVar.f425140e;
            }
            ReadWriteProperty readWriteProperty2 = this.imageUrl$delegate;
            KProperty<?>[] kPropertyArr2 = $$delegatedProperties;
            readWriteProperty2.setValue(this, kPropertyArr2[4], obj);
            String str5 = "";
            if (this.appId != 2) {
                this.statusTitle$delegate.setValue(this, kPropertyArr2[6], "");
                return;
            }
            af afVar3 = nVar.f425194e;
            if (((afVar3 == null || (cVar6 = afVar3.f433208e0) == null) ? 0L : cVar6.f409185i) > 0) {
                if (((afVar3 == null || (cVar5 = afVar3.f433208e0) == null || (bVar3 = cVar5.f409186m) == null) ? 0L : bVar3.f409175d) > 0) {
                    z16 = true;
                    if (this.isHeadFeed && z16) {
                        if (afVar3 != null || (cVar4 = afVar3.f433208e0) == null || (bVar2 = cVar4.f409186m) == null || (r0 = bVar2.f409178h) == null) {
                            String str6 = "";
                        }
                        this.statusIcon$delegate.setValue(this, kPropertyArr2[5], str6);
                        afVar = nVar.f425194e;
                        if (afVar != null && (cVar3 = afVar.f433208e0) != null && (str4 = cVar3.f409182e) != null) {
                            if (str4.length() <= 0) {
                                z17 = true;
                                if (!z17) {
                                    str2 = "";
                                } else {
                                    StringBuilder m17 = BotListCellKt$BotListCell$3$1$2$2$$ExternalSyntheticOutline0.m('\u627e');
                                    af afVar4 = nVar.f425194e;
                                    m17.append((afVar4 == null || (cVar2 = afVar4.f433208e0) == null) ? null : cVar2.f409182e);
                                    str2 = m17.toString();
                                }
                                this.statusTitle$delegate.setValue(this, kPropertyArr2[6], str2);
                                afVar2 = nVar.f425194e;
                                if (afVar2 != null || (cVar = afVar2.f433208e0) == null || (bVar = cVar.f409186m) == null || (str3 = bVar.f409179i) == null) {
                                    str3 = "";
                                }
                                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "#", false, 2, null);
                                if (startsWith$default) {
                                    if (str3.length() == 7) {
                                        StringBuilder m18 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("0xff");
                                        String substring = str3.substring(1);
                                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                                        m18.append(substring);
                                        str3 = m18.toString();
                                    } else {
                                        StringBuilder m19 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(RelationNTPushServiceImpl.PRE_HEX_STRING);
                                        String substring2 = str3.substring(1);
                                        Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                                        m19.append(substring2);
                                        str3 = m19.toString();
                                    }
                                }
                                this.statusBgColor$delegate.setValue(this, kPropertyArr2[7], new h(h.INSTANCE.o(str3)));
                            }
                        }
                        z17 = false;
                        if (!z17) {
                        }
                        this.statusTitle$delegate.setValue(this, kPropertyArr2[6], str2);
                        afVar2 = nVar.f425194e;
                        if (afVar2 != null) {
                        }
                        str3 = "";
                        startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "#", false, 2, null);
                        if (startsWith$default) {
                        }
                        this.statusBgColor$delegate.setValue(this, kPropertyArr2[7], new h(h.INSTANCE.o(str3)));
                    }
                    this.jiebanTagInfo$delegate.setValue(this, kPropertyArr2[8], "");
                    ArrayList arrayList = new ArrayList();
                    if (!isHost()) {
                        af afVar5 = nVar.f425194e;
                        String str7 = afVar5 != null ? afVar5.f433214i : null;
                        if (!Intrinsics.areEqual(str7, this.myConstellation)) {
                            str7 = "";
                        }
                        if (str7.length() > 0) {
                            str5 = this.myConstellation;
                        } else {
                            af afVar6 = nVar.f425194e;
                            if (afVar6 == null || (emptyList3 = afVar6.f433211g0) == null) {
                                emptyList3 = CollectionsKt__CollectionsKt.emptyList();
                            }
                            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) sortJieBanLabelTag(emptyList3));
                            a aVar = (a) firstOrNull;
                            if (aVar != null && (str = aVar.f435363e) != null) {
                                str5 = str;
                            }
                        }
                    }
                    if (str5.length() <= 0) {
                        arrayList.add(str5);
                    }
                    if (!isHost()) {
                        af afVar7 = nVar.f425194e;
                        if (afVar7 == null || (emptyList2 = afVar7.I) == null) {
                            emptyList2 = CollectionsKt__CollectionsKt.emptyList();
                        }
                        sortJieBanLabelTag = sortJieBanLabelTag(emptyList2);
                    } else {
                        af afVar8 = nVar.f425194e;
                        if (afVar8 == null || (emptyList = afVar8.f433213h0) == null) {
                            emptyList = CollectionsKt__CollectionsKt.emptyList();
                        }
                        sortJieBanLabelTag = sortJieBanLabelTag(emptyList);
                    }
                    if (!sortJieBanLabelTag.isEmpty()) {
                        Iterator<a> it = sortJieBanLabelTag.iterator();
                        while (it.hasNext()) {
                            String str8 = it.next().f435363e;
                            if ((str8.length() > 0) && !arrayList.contains(str8)) {
                                arrayList.add(str8);
                            }
                            if (arrayList.size() >= 2) {
                                break;
                            }
                        }
                    }
                    size = arrayList.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (i3 != arrayList.size() - 1) {
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(getJiebanTagInfo());
                            m3 = LoadFailParams$$ExternalSyntheticOutline0.m(sb5, (String) arrayList.get(i3), Typography.middleDot);
                        } else {
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(getJiebanTagInfo());
                            m3 = LoadFailParams$$ExternalSyntheticOutline0.m(sb6, (String) arrayList.get(i3), TokenParser.SP);
                        }
                        this.jiebanTagInfo$delegate.setValue(this, $$delegatedProperties[8], m3);
                    }
                    return;
                }
            }
            z16 = false;
            if (this.isHeadFeed) {
                if (afVar3 != null) {
                }
                String str62 = "";
                this.statusIcon$delegate.setValue(this, kPropertyArr2[5], str62);
                afVar = nVar.f425194e;
                if (afVar != null) {
                    if (str4.length() <= 0) {
                    }
                }
                z17 = false;
                if (!z17) {
                }
                this.statusTitle$delegate.setValue(this, kPropertyArr2[6], str2);
                afVar2 = nVar.f425194e;
                if (afVar2 != null) {
                }
                str3 = "";
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str3, "#", false, 2, null);
                if (startsWith$default) {
                }
                this.statusBgColor$delegate.setValue(this, kPropertyArr2[7], new h(h.INSTANCE.o(str3)));
            }
            this.jiebanTagInfo$delegate.setValue(this, kPropertyArr2[8], "");
            ArrayList arrayList2 = new ArrayList();
            if (!isHost()) {
            }
            if (str5.length() <= 0) {
            }
            if (!isHost()) {
            }
            if (!sortJieBanLabelTag.isEmpty()) {
            }
            size = arrayList2.size();
            while (i3 < size) {
            }
            return;
        }
        obj = null;
        ReadWriteProperty readWriteProperty22 = this.imageUrl$delegate;
        KProperty<?>[] kPropertyArr22 = $$delegatedProperties;
        readWriteProperty22.setValue(this, kPropertyArr22[4], obj);
        String str52 = "";
        if (this.appId != 2) {
        }
    }
}
