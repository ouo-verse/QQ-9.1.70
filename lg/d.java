package lg;

import com.qzone.common.account.LoginData;
import com.qzone.common.business.service.QZoneWriteOperationService;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellFeedCommInfo;
import com.qzone.proxy.feedcomponent.model.CellLocalInfo;
import com.qzone.reborn.feedx.itemview.friendposting.QZoneFriendPostingFeedItemView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tianshu.data.TianShuAdPosItemData;
import com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.util.QZLog;
import cooperation.vip.pb.TianShuAccess;
import cooperation.vip.tianshu.TianShuManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import zg.QZoneFeedBottomContainerItemData;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b,\u0010-J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0010\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0015\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0016\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0010\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u0006\u0010\u0018\u001a\u00020\rJ\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\bJ\u0006\u0010\u001a\u001a\u00020\rJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u001c\u001a\u00020\rJ\u0006\u0010\u001d\u001a\u00020\rJ\u0006\u0010\u001e\u001a\u00020\u000fJ\u0006\u0010\u001f\u001a\u00020\rR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010%R$\u0010+\u001a\u0012\u0012\u0004\u0012\u00020(0'j\b\u0012\u0004\u0012\u00020(`)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*\u00a8\u0006."}, d2 = {"Llg/d;", "", "Lzg/a;", "itemData", "", "actionId", "Lcom/tencent/mobileqq/tianshu/data/TianShuReportData;", "l", "", "Lcom/tencent/mobileqq/tianshu/data/TianShuAdPosItemData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcooperation/vip/pb/TianShuAccess$GetAdsRsp;", "adsRsp", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", DomainData.DOMAIN_NAME, "g", "Lcom/qzone/proxy/feedcomponent/model/BusinessFeedData;", "feedData", "p", "e", ReportConstant.COSTREPORT_PREFIX, "c", "d", "k", "u", "t", "r", tl.h.F, "o", "f", "", "b", "J", "GAMEPLAY_AD_EXPOSE_INTERVAL", "", "Ljava/util/List;", "gameplayItemList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "showExpandAnimList", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f414454a = new d();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final long GAMEPLAY_AD_EXPOSE_INTERVAL = com.qzone.reborn.configx.g.f53821a.b().K0();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final List<QZoneFeedBottomContainerItemData> gameplayItemList = new ArrayList();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static final ArrayList<String> showExpandAnimList = new ArrayList<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes38.dex */
    public static final class a<T> implements Comparator {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(Integer.valueOf(((QZoneFeedBottomContainerItemData) t16).getOrder()), Integer.valueOf(((QZoneFeedBottomContainerItemData) t17).getOrder()));
            return compareValues;
        }
    }

    d() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(boolean z16, final TianShuAccess.GetAdsRsp getAdsRsp) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: lg.c
            @Override // java.lang.Runnable
            public final void run() {
                d.j(TianShuAccess.GetAdsRsp.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(TianShuAccess.GetAdsRsp adsRsp) {
        try {
            d dVar = f414454a;
            Intrinsics.checkNotNullExpressionValue(adsRsp, "adsRsp");
            dVar.q(adsRsp);
        } catch (Exception e16) {
            QZLog.e("QZoneFeedBottomContainerManager", 1, e16, "[fetchData]");
            xe.b.f447841a.d(e16);
        }
    }

    private final TianShuReportData l(QZoneFeedBottomContainerItemData itemData, int actionId) {
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mAppId = "tianshu.247";
        tianShuReportData.mPageId = "tianshu.247";
        tianShuReportData.mOperTime = TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis());
        tianShuReportData.mTraceId = LoginData.getInstance().getUinString() + "_" + tianShuReportData.mOperTime;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mActionId = actionId;
        tianShuReportData.mTriggerInfo = itemData.getTraceInfo();
        tianShuReportData.mItemId = itemData.getAdID();
        return tianShuReportData;
    }

    private final boolean n() {
        if (com.qzone.reborn.util.i.b().g("KEY_QZONE_BOTTOM_CONTAINER_CLOSE_TIME", 0) < 3) {
            return true;
        }
        if (System.currentTimeMillis() - com.qzone.reborn.util.i.b().h("KEY_QZONE_BOTTOM_CONTAINER_CLOSE_DATE", 0L) <= 2592000000L) {
            return false;
        }
        com.qzone.reborn.util.i.b().o("KEY_QZONE_BOTTOM_CONTAINER_CLOSE_TIME", 0);
        return true;
    }

    public final void d() {
        showExpandAnimList.clear();
    }

    public final void f() {
        com.qzone.reborn.util.i.b().o("KEY_QZONE_BOTTOM_CONTAINER_CLOSE_TIME", com.qzone.reborn.util.i.b().g("KEY_QZONE_BOTTOM_CONTAINER_CLOSE_TIME", 0) + 1);
        com.qzone.reborn.util.i.b().p("KEY_QZONE_BOTTOM_CONTAINER_CLOSE_DATE", System.currentTimeMillis());
    }

    public final boolean g() {
        return (!n() || com.qzone.reborn.util.k.f59549a.g() || Intrinsics.areEqual(QZoneFriendPostingFeedItemView.INSTANCE.a().get(Long.valueOf(LoginData.getInstance().getUin())), Boolean.TRUE)) ? false : true;
    }

    public final void h() {
        TianShuManager.getInstance().requestAdv(m(), new TianShuGetAdvCallback() { // from class: lg.b
            @Override // com.tencent.mobileqq.tianshu.data.TianShuGetAdvCallback
            public final void onGetAdvs(boolean z16, TianShuAccess.GetAdsRsp getAdsRsp) {
                d.i(z16, getAdsRsp);
            }
        });
    }

    public final List<QZoneFeedBottomContainerItemData> k() {
        return gameplayItemList;
    }

    public final boolean o() {
        return System.currentTimeMillis() - com.qzone.reborn.util.i.b().h("KEY_QZONE_BOTTOM_CONTAINER_LAST_EXPOSE_TIME", 0L) > GAMEPLAY_AD_EXPOSE_INTERVAL;
    }

    public final void r() {
        com.qzone.reborn.util.i.b().p("KEY_QZONE_BOTTOM_CONTAINER_LAST_EXPOSE_TIME", System.currentTimeMillis());
    }

    public final void t(QZoneFeedBottomContainerItemData itemData) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        TianShuManager.getInstance().report(l(itemData, 102));
    }

    public final void u() {
        Iterator<T> it = gameplayItemList.iterator();
        while (it.hasNext()) {
            TianShuManager.getInstance().report(f414454a.l((QZoneFeedBottomContainerItemData) it.next(), 101));
        }
    }

    private final List<TianShuAdPosItemData> m() {
        List<TianShuAdPosItemData> mutableListOf;
        TianShuAdPosItemData tianShuAdPosItemData = new TianShuAdPosItemData();
        tianShuAdPosItemData.mNeedCnt = 10;
        tianShuAdPosItemData.mPosId = 1376;
        Unit unit = Unit.INSTANCE;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(tianShuAdPosItemData);
        return mutableListOf;
    }

    private final void q(TianShuAccess.GetAdsRsp adsRsp) {
        List distinct;
        List sortedWith;
        gameplayItemList.clear();
        ArrayList arrayList = new ArrayList();
        if (adsRsp.code.get() == 0 && !adsRsp.mapAds.isEmpty()) {
            int size = adsRsp.mapAds.size();
            for (int i3 = 0; i3 < size; i3++) {
                for (TianShuAccess.AdItem adItem : adsRsp.mapAds.get(i3).value.get().lst.get()) {
                    QZoneFeedBottomContainerItemData qZoneFeedBottomContainerItemData = new QZoneFeedBottomContainerItemData(null, null, null, null, null, 0, 0, 127, null);
                    qZoneFeedBottomContainerItemData.h(1376);
                    String str = adItem.traceinfo.get();
                    Intrinsics.checkNotNullExpressionValue(str, "adItem.traceinfo.get()");
                    qZoneFeedBottomContainerItemData.m(str);
                    qZoneFeedBottomContainerItemData.g(String.valueOf(adItem.iAdId.get()));
                    for (TianShuAccess.MapEntry mapEntry : adItem.argList.get()) {
                        String value = mapEntry.value.get();
                        String str2 = mapEntry.key.get();
                        if (str2 != null) {
                            switch (str2.hashCode()) {
                                case -1255130495:
                                    if (str2.equals("jumpurl")) {
                                        Intrinsics.checkNotNullExpressionValue(value, "value");
                                        qZoneFeedBottomContainerItemData.j(value);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3226745:
                                    if (str2.equals("icon")) {
                                        Intrinsics.checkNotNullExpressionValue(value, "value");
                                        qZoneFeedBottomContainerItemData.i(value);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 3373707:
                                    if (str2.equals("name")) {
                                        Intrinsics.checkNotNullExpressionValue(value, "value");
                                        qZoneFeedBottomContainerItemData.k(value);
                                        break;
                                    } else {
                                        break;
                                    }
                                case 106006350:
                                    if (str2.equals("order")) {
                                        qZoneFeedBottomContainerItemData.l(Integer.parseInt(value.toString()));
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                    }
                    arrayList.add(qZoneFeedBottomContainerItemData);
                }
            }
            List<QZoneFeedBottomContainerItemData> list = gameplayItemList;
            distinct = CollectionsKt___CollectionsKt.distinct(arrayList);
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(distinct, new a());
            list.addAll(sortedWith);
            RFWLog.d("QZoneFeedBottomContainerManager", RFWLog.USR, "gameplayItemList: adsRsp " + list + "len: " + list.size());
            return;
        }
        RFWLog.d("QZoneFeedBottomContainerManager", RFWLog.USR, "parseTianShuResponse: adsRsp is empty");
    }

    public final boolean c(BusinessFeedData feedData) {
        CellFeedCommInfo cellFeedCommInfo;
        String str = (feedData == null || (cellFeedCommInfo = feedData.cellFeedCommInfo) == null) ? null : cellFeedCommInfo.clientkey;
        if (str == null) {
            return true;
        }
        return showExpandAnimList.contains(str);
    }

    public final void e(BusinessFeedData feedData) {
        CellLocalInfo localInfoV2;
        if (feedData != null && (localInfoV2 = feedData.getLocalInfoV2()) != null) {
            localInfoV2.setShowBottomContainer(2);
        }
        QZoneWriteOperationService.v0().I0(feedData);
    }

    public final void s(BusinessFeedData feedData) {
        CellFeedCommInfo cellFeedCommInfo;
        String str = (feedData == null || (cellFeedCommInfo = feedData.cellFeedCommInfo) == null) ? null : cellFeedCommInfo.clientkey;
        if (str == null) {
            return;
        }
        showExpandAnimList.add(str);
    }

    public final boolean p(BusinessFeedData feedData) {
        CellLocalInfo localInfoV2;
        if ((feedData != null && feedData.isFakeFeed()) && QLog.isColorLevel()) {
            CellLocalInfo localInfoV22 = feedData.getLocalInfoV2();
            Integer valueOf = localInfoV22 != null ? Integer.valueOf(localInfoV22.fakeType) : null;
            CellLocalInfo localInfoV23 = feedData.getLocalInfoV2();
            Integer valueOf2 = localInfoV23 != null ? Integer.valueOf(localInfoV23.showBottomContainer) : null;
            QLog.d("QZoneFeedBottomContainer", 2, "isShowBottomRecommendFakeFeed: fake: " + valueOf + ", showBottomContainer: " + valueOf2 + ", feedData: " + ef.b.a(feedData) + ", hashCode: " + feedData.hashCode());
        }
        return (feedData == null || (localInfoV2 = feedData.getLocalInfoV2()) == null || localInfoV2.showBottomContainer != 1) ? false : true;
    }
}
