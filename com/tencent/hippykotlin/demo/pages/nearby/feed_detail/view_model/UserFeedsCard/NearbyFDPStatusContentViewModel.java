package com.tencent.hippykotlin.demo.pages.nearby.feed_detail.view_model.UserFeedsCard;

import c01.c;
import c45.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.yifanshang.detail.view.YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.BDHService;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.FastClickUtils;
import com.tencent.hippykotlin.demo.pages.nearby.base.utils.NearbyProUtilsKt;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.ClickLocation;
import com.tencent.hippykotlin.demo.pages.nearby.base.view.NBPLikeData;
import com.tencent.hippykotlin.demo.pages.nearby.feed_detail.model.NearbySsoDoLikeRequestModel$Companion;
import com.tencent.kuikly.core.base.d;
import com.tencent.kuikly.core.log.KLog;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;
import kotlin.text.StringsKt__StringsJVMKt;
import n25.j;
import n25.k;
import n25.l;
import n25.m;
import n35.v;
import n35.w;
import n35.z;
import o25.f;
import org.apache.httpcore.message.TokenParser;
import q25.g;
import r25.e;

/* loaded from: classes31.dex */
public final class NearbyFDPStatusContentViewModel {
    public static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "statusImageIndexNode", "getStatusImageIndexNode()Lkuikly/com/tencent/trpcprotocol/qqntv2/richmedia/richmedia/IndexNode;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "statusTopicList", "getStatusTopicList()Lcom/tencent/kuikly/core/reactive/collection/ObservableList;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "statusTitle", "getStatusTitle()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "feedID", "getFeedID()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "statusFeed", "getStatusFeed()Lkuikly/com/tencent/trpcprotocol/lplan/common/feed/StatusFeed;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "statusIcon", "getStatusIcon()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "statusText", "getStatusText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "commentCountStr", "getCommentCountStr()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "locationText", "getLocationText()Ljava/lang/String;", 0), YiFanShangDetailBottomButtonAttr$$ExternalSyntheticOutline0.m(NearbyFDPStatusContentViewModel.class, "mapTheme", "getMapTheme()Lkuikly/com/tencent/trpcprotocol/lplan/common/map/MapTheme;", 0)};
    public boolean didReportFeedRead;
    public NearbyFDPUserFeedTimelineItemViewModel timelineItemViewModel;
    public int unSelfLikeCount;
    public final ReadWriteProperty statusImageIndexNode$delegate = c.a(null);
    public final ReadWriteProperty statusTopicList$delegate = c.b();
    public final ReadWriteProperty statusTitle$delegate = c.a(null);
    public final ReadWriteProperty feedID$delegate = c.a(null);
    public final ReadWriteProperty statusFeed$delegate = c.a(createStatusFeed());
    public final ReadWriteProperty statusIcon$delegate = c.a(null);
    public final ReadWriteProperty statusText$delegate = c.a(null);
    public NBPLikeData likeData = new NBPLikeData();
    public final ReadWriteProperty commentCountStr$delegate = c.a(null);
    public final ReadWriteProperty locationText$delegate = c.a(null);
    public final FastClickUtils likeFastClickUtils = new FastClickUtils(200);
    public final ReadWriteProperty mapTheme$delegate = c.a(null);
    public final FastClickUtils fastClickUtils = new FastClickUtils(500);

    public NearbyFDPStatusContentViewModel(NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel) {
        this.timelineItemViewModel = nearbyFDPUserFeedTimelineItemViewModel;
        refreshData();
    }

    public final String getFeedID() {
        return (String) this.feedID$delegate.getValue(this, $$delegatedProperties[3]);
    }

    public final String getLocationText() {
        return (String) this.locationText$delegate.getValue(this, $$delegatedProperties[8]);
    }

    public final f getMapTheme() {
        return (f) this.mapTheme$delegate.getValue(this, $$delegatedProperties[9]);
    }

    public final l getStatusFeed() {
        return (l) this.statusFeed$delegate.getValue(this, $$delegatedProperties[4]);
    }

    public final v getStatusImageIndexNode() {
        return (v) this.statusImageIndexNode$delegate.getValue(this, $$delegatedProperties[0]);
    }

    public final boolean isSelfFeed() {
        e eVar;
        l statusFeed = getStatusFeed();
        return (statusFeed == null || (eVar = statusFeed.f418093e) == null || eVar.f430610d != UserDataManager.INSTANCE.getUserSelfInfo().tid) ? false : true;
    }

    public final void onClickCardContent(Boolean bool) {
        boolean z16;
        if (this.fastClickUtils.isFastDoubleClick()) {
            return;
        }
        String urlFromCache = BDHService.INSTANCE.getUrlFromCache(getStatusImageIndexNode());
        if (urlFromCache == null) {
            urlFromCache = "";
        }
        if (getStatusFeed() != null) {
            z16 = true;
            int i3 = this.timelineItemViewModel.fromFollowingTab ? 15 : 1;
            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
            l statusFeed = getStatusFeed();
            Intrinsics.checkNotNull(statusFeed);
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar.v("feedImageUrl", urlFromCache);
            eVar.v("hasFollowed", bool);
            Unit unit = Unit.INSTANCE;
            companion.openFeedDetail(statusFeed, i3, eVar);
        } else {
            z16 = false;
        }
        KLog kLog = KLog.INSTANCE;
        NearbyConst nearbyConst = NearbyConst.INSTANCE;
        kLog.i("feed_detail_page", "did click  card content  to open footprint detail page result:" + z16 + TokenParser.SP + ((String) this.statusText$delegate.getValue(this, $$delegatedProperties[6])) + TokenParser.SP + getFeedID() + " imageUrl:" + urlFromCache + ", hasFollowed:" + bool);
    }

    public final void onClickLikeBtn(boolean z16, ClickLocation clickLocation) {
        if (this.likeFastClickUtils.isFastDoubleClick()) {
            KLog kLog = KLog.INSTANCE;
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("isFastDoubleClick did click, like btn feedId:");
            m3.append(getFeedID());
            kLog.i("feed_detail_page", m3.toString());
            return;
        }
        KLog kLog2 = KLog.INSTANCE;
        NearbyConst nearbyConst2 = NearbyConst.INSTANCE;
        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("did click like btn feedId:");
        m16.append(getFeedID());
        m16.append(" isDoubleClick:");
        m16.append(z16);
        m16.append(", clickLocation: ");
        m16.append(clickLocation != null ? Float.valueOf(clickLocation.f114210x) : null);
        m16.append("\u3001 ");
        m16.append(clickLocation != null ? Float.valueOf(clickLocation.f114211y) : null);
        kLog2.i("feed_detail_page", m16.toString());
        if (z16) {
            this.likeData.doDoubleClickAnimation(clickLocation);
            if (this.likeData.getIcon().isLiked) {
                kLog2.i("feed_detail_page", "in liked when double click");
                return;
            }
        }
        boolean z17 = !this.likeData.getIcon().isLiked;
        NBPLikeData.updateData$default(this.likeData, d.b(z17) + this.unSelfLikeCount, Boolean.valueOf(z17));
        String feedID = getFeedID();
        if (feedID == null) {
            feedID = "";
        }
        NearbySsoDoLikeRequestModel$Companion.requestLikeStatusFeed$default(z17, feedID);
    }

    /* JADX WARN: Code restructure failed: missing block: B:70:0x011e, code lost:
    
        if ((r0.length() == 0) != false) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01b1, code lost:
    
        if (r0 == null) goto L124;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void refreshData() {
        String str;
        String str2;
        g gVar;
        String str3;
        g gVar2;
        String str4;
        j jVar;
        w wVar;
        List<z> list;
        Object firstOrNull;
        List<j> list2;
        Object firstOrNull2;
        a aVar;
        String decodeToString;
        String str5;
        List<m> list3;
        List mutableList;
        List<m> list4;
        List mutableList2;
        k kVar;
        String str6;
        v25.a aVar2;
        List<String> list5;
        Object firstOrNull3;
        f mapThemeFromCache;
        List<String> list6;
        Object firstOrNull4;
        f mapThemeFromCache2;
        n25.f fVar;
        int i3;
        n25.f fVar2;
        g gVar3;
        g gVar4;
        NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel = this.timelineItemViewModel;
        l lVar = nearbyFDPUserFeedTimelineItemViewModel.statusFeed;
        v vVar = null;
        if (lVar == null || (str = lVar.f418092d) == null) {
            v25.a aVar3 = nearbyFDPUserFeedTimelineItemViewModel.feed;
            str = aVar3 != null ? aVar3.f440824d : null;
        }
        ReadWriteProperty readWriteProperty = this.feedID$delegate;
        KProperty<?>[] kPropertyArr = $$delegatedProperties;
        readWriteProperty.setValue(this, kPropertyArr[3], str);
        NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel2 = this.timelineItemViewModel;
        l lVar2 = nearbyFDPUserFeedTimelineItemViewModel2.statusFeed;
        if (lVar2 == null || (gVar4 = lVar2.f418094f) == null || (str2 = gVar4.f428260h) == null) {
            v25.a aVar4 = nearbyFDPUserFeedTimelineItemViewModel2.feed;
            str2 = (aVar4 == null || (gVar = aVar4.f440828i) == null) ? null : gVar.f428260h;
        }
        this.statusIcon$delegate.setValue(this, kPropertyArr[5], str2);
        NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel3 = this.timelineItemViewModel;
        l lVar3 = nearbyFDPUserFeedTimelineItemViewModel3.statusFeed;
        if (lVar3 == null || (gVar3 = lVar3.f418094f) == null || (str3 = gVar3.f428259f) == null) {
            v25.a aVar5 = nearbyFDPUserFeedTimelineItemViewModel3.feed;
            str3 = (aVar5 == null || (gVar2 = aVar5.f440828i) == null) ? null : gVar2.f428259f;
        }
        this.statusText$delegate.setValue(this, kPropertyArr[6], str3);
        NBPLikeData nBPLikeData = this.likeData;
        l lVar4 = this.timelineItemViewModel.statusFeed;
        nBPLikeData.updateLiked((lVar4 == null || (fVar2 = lVar4.E) == null || fVar2.f418064h != 1) ? false : true);
        l lVar5 = this.timelineItemViewModel.statusFeed;
        if (lVar5 != null && (fVar = lVar5.E) != null) {
            this.likeData.updateNumber(fVar.f418062e);
            this.unSelfLikeCount = (fVar.f418064h != 1 || (i3 = fVar.f418062e) <= 0) ? fVar.f418062e : i3 - 1;
        }
        l lVar6 = this.timelineItemViewModel.statusFeed;
        if (lVar6 != null && (list6 = lVar6.P) != null) {
            firstOrNull4 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list6);
            String str7 = (String) firstOrNull4;
            if (str7 != null && (mapThemeFromCache2 = NearbyProUtilsKt.getMapThemeFromCache(str7)) != null) {
                this.mapTheme$delegate.setValue(this, kPropertyArr[9], mapThemeFromCache2);
            }
        }
        if (getMapTheme() == null && (aVar2 = this.timelineItemViewModel.feed) != null && (list5 = aVar2.M) != null) {
            firstOrNull3 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list5);
            String str8 = (String) firstOrNull3;
            if (str8 != null && (mapThemeFromCache = NearbyProUtilsKt.getMapThemeFromCache(str8)) != null) {
                this.mapTheme$delegate.setValue(this, kPropertyArr[9], mapThemeFromCache);
            }
        }
        l lVar7 = this.timelineItemViewModel.statusFeed;
        if (lVar7 != null) {
            updateCommentCount(Integer.valueOf(lVar7.H).intValue());
        }
        l lVar8 = this.timelineItemViewModel.statusFeed;
        if (lVar8 != null && (kVar = lVar8.C) != null && (str6 = kVar.Q) != null) {
            this.locationText$delegate.setValue(this, kPropertyArr[8], str6);
        }
        if (getLocationText() != null) {
            String locationText = getLocationText();
            Intrinsics.checkNotNull(locationText);
        }
        v25.a aVar6 = this.timelineItemViewModel.feed;
        if (aVar6 == null || (str4 = aVar6.H) == null) {
            str4 = "";
        }
        this.locationText$delegate.setValue(this, kPropertyArr[8], str4);
        v25.a aVar7 = this.timelineItemViewModel.feed;
        if (aVar7 != null && (list4 = aVar7.I) != null) {
            mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list4);
            this.statusTopicList$delegate.setValue(this, kPropertyArr[1], new com.tencent.kuikly.core.reactive.collection.c(mutableList2, null, null, 6, null));
        }
        l lVar9 = this.timelineItemViewModel.statusFeed;
        if (lVar9 != null && (list3 = lVar9.J) != null) {
            mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list3);
            this.statusTopicList$delegate.setValue(this, kPropertyArr[1], new com.tencent.kuikly.core.reactive.collection.c(mutableList, null, null, 6, null));
        }
        v25.a aVar8 = this.timelineItemViewModel.feed;
        if (aVar8 != null && (str5 = aVar8.f440827h) != null) {
            this.statusTitle$delegate.setValue(this, kPropertyArr[2], str5);
        }
        l lVar10 = this.timelineItemViewModel.statusFeed;
        if (lVar10 != null && (aVar = lVar10.f418096i) != null) {
            decodeToString = StringsKt__StringsJVMKt.decodeToString(aVar.f30291a);
            this.statusTitle$delegate.setValue(this, kPropertyArr[2], decodeToString);
        }
        if (getStatusImageIndexNode() == null) {
            l lVar11 = this.timelineItemViewModel.statusFeed;
            if (lVar11 != null && (list2 = lVar11.f418097m) != null) {
                firstOrNull2 = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list2);
                jVar = (j) firstOrNull2;
            }
            v25.a aVar9 = this.timelineItemViewModel.feed;
            jVar = aVar9 != null ? aVar9.f440829m : null;
            if (jVar != null && (wVar = jVar.f418083d) != null && (list = wVar.f418273d) != null) {
                firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                z zVar = (z) firstOrNull;
                if (zVar != null) {
                    vVar = zVar.f418280d;
                }
            }
            if (vVar != null) {
                this.statusImageIndexNode$delegate.setValue(this, kPropertyArr[0], vVar);
            }
        }
        this.statusFeed$delegate.setValue(this, kPropertyArr[4], createStatusFeed());
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0010, code lost:
    
        r2 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final l createStatusFeed() {
        List emptyList;
        List mutableList;
        NearbyFDPUserFeedTimelineItemViewModel nearbyFDPUserFeedTimelineItemViewModel = this.timelineItemViewModel;
        l lVar = nearbyFDPUserFeedTimelineItemViewModel.statusFeed;
        if (lVar != null) {
            return lVar;
        }
        v25.a aVar = nearbyFDPUserFeedTimelineItemViewModel.feed;
        if (aVar == null) {
            return null;
        }
        j jVar = aVar.f440829m;
        if (jVar == null || emptyList == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        String str = aVar.f440824d;
        List<m> list = aVar.I;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) emptyList);
        return new l(str, new e(aVar.f440825e, null, null, 0, null, 1073741822), null, null, null, mutableList, null, 0L, null, false, 0, list, aVar.K, aVar.L, null, 1990620);
    }

    public final void updateCommentCount(int i3) {
        String str;
        if (i3 > 99) {
            str = "99+";
        } else if (i3 > 0) {
            str = String.valueOf(i3);
        } else {
            str = "";
        }
        this.commentCountStr$delegate.setValue(this, $$delegatedProperties[7], str);
    }
}
