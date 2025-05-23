package com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album;

import com.tencent.aelight.camera.constants.AEEditorConstants;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.manager.AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.dataline.DatalineDetailViewModel$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQBridgeApi;
import com.tencent.hippykotlin.demo.pages.goods_center.repository.protoc.GoodsCenterProductInfo$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumBatchBean;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonAlbumInfo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStMedia;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.convert.bean.CommonStUser;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.repo.QZAlbumDetailRepo;
import com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback;
import com.tencent.hippykotlin.demo.pages.qzone.module.QZoneComposePlatformModule;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.module.k;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt___RangesKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 *2\u00020\u0001:\u0002*+B\u000f\u0012\u0006\u0010!\u001a\u00020 \u00a2\u0006\u0004\b(\u0010)J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u0004H\u0002J4\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000eH\u0002JG\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00042'\u0010\u001d\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0018\u00a2\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000b0\u0017j\u0002`\u001cJ\u0006\u0010\u001f\u001a\u00020\u000bR\u0017\u0010!\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001e\u0010&\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006,"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/QZPhotoBrowserHelper;", "", "", "searchLLOC", "", "getLLOCIndex", "", "getLLOCPolymerizeId", "", "queryOrder", "cnt", "", "fetchMediaList", "requestMore", "", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/convert/bean/CommonStMedia;", "mediaList", "showIndexList", "postDataToNative", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/QZPhotoBrowserHelper$QZPhotoBrowserBusinessType;", "businessType", QAdVrReportParams.ParamKey.MEDIA, "clickedViewID", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/nvi/serialization/json/e;", "Lkotlin/ParameterName;", "name", "data", "Lcom/tencent/kuikly/core/module/CallbackFn;", "callback", "openPhotoBrowser", "printAllLLOC", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumDetailRepo;", "repo", "Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumDetailRepo;", "getRepo", "()Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumDetailRepo;", "Lcom/tencent/kuikly/core/module/CallbackRef;", "callbackRef", "Ljava/lang/String;", "<init>", "(Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/repo/QZAlbumDetailRepo;)V", "Companion", "QZPhotoBrowserBusinessType", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZPhotoBrowserHelper {
    public static final String QZ_DA_TU_PIC_INDEX_CHANGE = "QZ_DA_TU_PIC_INDEX_CHANGE";
    public static final String QZ_DA_TU_PIC_LOAD_MORE = "QZ_DA_TU_PIC_LOAD_MORE";
    public static final String QZ_PHOTO_BROWSER_LOAD_MORE_NOTIFICATION = "QZ_PHOTO_BROWSER_LOAD_MORE_NOTIFICATION";
    public static final String QZ_PHOTO_BROWSER_LOAD_MORE_RSP_NOTIFICATION = "QZ_PHOTO_BROWSER_LOAD_MORE_RSP_NOTIFICATION";
    public static final String TAG = "QZPhotoBrowserHelper";
    private String callbackRef;
    private final QZAlbumDetailRepo repo;
    public static final int $stable = 8;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/hippykotlin/demo/pages/qqkmp/qzone/album/QZPhotoBrowserHelper$QZPhotoBrowserBusinessType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "PERSONAL_ALBUM", "GROUP_ALBUM", "qecommerce-biz_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes37.dex */
    public enum QZPhotoBrowserBusinessType {
        PERSONAL_ALBUM(0),
        GROUP_ALBUM(1);

        private final int value;

        QZPhotoBrowserBusinessType(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    public QZPhotoBrowserHelper(QZAlbumDetailRepo qZAlbumDetailRepo) {
        this.repo = qZAlbumDetailRepo;
        KLog.INSTANCE.d(TAG, "addNotify");
        this.callbackRef = k.b(QQBridgeApi.INSTANCE.getNotifyModule(), QZ_PHOTO_BROWSER_LOAD_MORE_NOTIFICATION, false, new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.QZPhotoBrowserHelper.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e eVar) {
                String str;
                KLog kLog = KLog.INSTANCE;
                kLog.d(QZPhotoBrowserHelper.TAG, "receive QZ_PHOTO_BROWSER_LOAD_MORE_NOTIFICATION: " + eVar);
                if (eVar == null || (str = eVar.p("lloc")) == null) {
                    str = "";
                }
                boolean f16 = eVar != null ? eVar.f("queryOrder") : false;
                int j3 = eVar != null ? eVar.j("cnt") : 0;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("lloc: ");
                sb5.append(str);
                sb5.append(", queryOrder: ");
                sb5.append(f16);
                sb5.append(", cnt: ");
                DatalineDetailViewModel$$ExternalSyntheticOutline0.m(sb5, j3, kLog, QZPhotoBrowserHelper.TAG);
                QZPhotoBrowserHelper.this.fetchMediaList(str, f16, j3);
            }
        }, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchMediaList(String searchLLOC, boolean queryOrder, int cnt) {
        IntRange until;
        List<CommonStMedia> slice;
        IntRange until2;
        List<Integer> list;
        IntRange until3;
        IntRange until4;
        List<CommonStMedia> mediaInfoList = this.repo.getMediaInfoList();
        int lLOCIndex = getLLOCIndex(searchLLOC);
        CollectionsKt__CollectionsKt.emptyList();
        CollectionsKt__CollectionsKt.emptyList();
        if (queryOrder) {
            int i3 = lLOCIndex - cnt;
            if (i3 < 0) {
                i3 = 0;
            }
            until3 = RangesKt___RangesKt.until(i3, lLOCIndex);
            slice = CollectionsKt___CollectionsKt.slice((List) mediaInfoList, until3);
            until4 = RangesKt___RangesKt.until(i3 + 1, lLOCIndex + 1);
            list = CollectionsKt___CollectionsKt.toList(until4);
        } else {
            if (lLOCIndex + cnt + 1 > mediaInfoList.size() && !this.repo.getLastIsFinish()) {
                requestMore(searchLLOC, queryOrder, cnt);
                return;
            }
            int size = mediaInfoList.size();
            int i16 = lLOCIndex + 1;
            until = RangesKt___RangesKt.until(i16, size);
            slice = CollectionsKt___CollectionsKt.slice((List) mediaInfoList, until);
            until2 = RangesKt___RangesKt.until(i16 + 1, size + 1);
            list = CollectionsKt___CollectionsKt.toList(until2);
        }
        postDataToNative(searchLLOC, queryOrder, slice, list);
    }

    private final int getLLOCIndex(String searchLLOC) {
        Iterator<CommonStMedia> it = this.repo.getMediaInfoList().iterator();
        int i3 = 0;
        while (it.hasNext() && !Intrinsics.areEqual(it.next().getMediaLLoc(), searchLLOC)) {
            i3++;
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long getLLOCPolymerizeId(String searchLLOC) {
        long j3 = 0;
        for (CommonAlbumBatchBean commonAlbumBatchBean : this.repo.getAllBatch()) {
            Iterator<CommonStMedia> it = commonAlbumBatchBean.getBatchInfo().getMedias().iterator();
            while (true) {
                if (it.hasNext()) {
                    CommonStMedia next = it.next();
                    if (Intrinsics.areEqual(next.getMediaLLoc(), searchLLOC)) {
                        if (commonAlbumBatchBean.getBatchInfo().getLinkType() == 1) {
                            j3 = next.getLinkId();
                        } else {
                            j3 = next.getBatchId();
                        }
                        KLog kLog = KLog.INSTANCE;
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("linkType: ");
                        m3.append(commonAlbumBatchBean.getBatchInfo().getLinkType());
                        m3.append(", batchId: ");
                        m3.append(next.getBatchId());
                        m3.append(", linkId: ");
                        m3.append(next.getLinkId());
                        m3.append(", polymerizeId: ");
                        m3.append(j3);
                        kLog.d(TAG, m3.toString());
                    }
                }
            }
        }
        return j3;
    }

    private final void postDataToNative(String searchLLOC, boolean queryOrder, List<CommonStMedia> mediaList, List<Integer> showIndexList) {
        String str = "";
        for (CommonStMedia commonStMedia : mediaList) {
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m(str);
            m3.append(commonStMedia.getMediaLLoc());
            m3.append(',');
            str = m3.toString();
        }
        KLog.INSTANCE.d(TAG, "ringlutest fetchMediaList searchLLOC: " + searchLLOC + ", queryOrder: " + queryOrder + " searchedMediaLLOCS: " + str);
        e eVar = new e();
        b bVar = new b();
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            bVar.t(it.next().toJSONObject());
        }
        b m16 = GoodsCenterProductInfo$$ExternalSyntheticOutline0.m(eVar, "mediaList", bVar);
        Iterator<Integer> it5 = showIndexList.iterator();
        while (it5.hasNext()) {
            m16.r(it5.next().intValue());
        }
        eVar.v("showIndexList", m16);
        eVar.v("searchLLOC", searchLLOC);
        eVar.w("queryOrder", queryOrder);
        k.d((k) c.f117352a.g().acquireModule("KRNotifyModule"), QZ_PHOTO_BROWSER_LOAD_MORE_RSP_NOTIFICATION, eVar, false, 4, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void requestMore(final String searchLLOC, final boolean queryOrder, final int cnt) {
        this.repo.requestMore(new DataCallback<List<? extends CommonAlbumBatchBean>>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.QZPhotoBrowserHelper$requestMore$1
            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public void onFailure(long errorCode, String errorMsg) {
                KLog.INSTANCE.e(QZPhotoBrowserHelper.TAG, "requestMore onFailure: " + errorMsg);
            }

            @Override // com.tencent.hippykotlin.demo.pages.qqkmp.qzone.network.DataCallback
            public /* bridge */ /* synthetic */ void onSuccess(List<? extends CommonAlbumBatchBean> list, long j3, String str, boolean z16) {
                onSuccess2((List<CommonAlbumBatchBean>) list, j3, str, z16);
            }

            /* renamed from: onSuccess, reason: avoid collision after fix types in other method */
            public void onSuccess2(List<CommonAlbumBatchBean> t16, long retCode, String msg2, boolean isFinish) {
                QZPhotoBrowserHelper.this.fetchMediaList(searchLLOC, queryOrder, cnt);
                AdelieAgreementConsentPage$onCreate$1$1$3$$ExternalSyntheticOutline0.m((k) c.f117352a.g().acquireModule("KRNotifyModule"), QZPhotoBrowserHelper.QZ_DA_TU_PIC_LOAD_MORE, false, 4, null);
            }
        });
    }

    public final QZAlbumDetailRepo getRepo() {
        return this.repo;
    }

    public final void printAllLLOC() {
        Iterator<CommonStMedia> it = this.repo.getMediaInfoList().iterator();
        while (it.hasNext()) {
            String mediaLLoc = it.next().getMediaLLoc();
            KLog.INSTANCE.d(TAG, "ringlutest printALLLLOC: " + mediaLLoc);
        }
    }

    public final void openPhotoBrowser(QZPhotoBrowserBusinessType businessType, CommonStMedia media, int clickedViewID, final Function1<? super e, Unit> callback) {
        String str;
        String str2;
        Map mapOf;
        List listOf;
        List listOf2;
        CommonStUser creator;
        String uin;
        printAllLLOC();
        String mediaLLoc = media.getMediaLLoc();
        int lLOCIndex = getLLOCIndex(mediaLLoc) + 1;
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("businessType", String.valueOf(businessType.getValue()));
        CommonAlbumInfo albumInfo = this.repo.getAlbumInfo();
        String str3 = "";
        if (albumInfo == null || (str = albumInfo.getAlbumId()) == null) {
            str = "";
        }
        pairArr[1] = TuplesKt.to("albumId", str);
        CommonAlbumInfo albumInfo2 = this.repo.getAlbumInfo();
        if (albumInfo2 == null || (str2 = albumInfo2.getName()) == null) {
            str2 = "";
        }
        pairArr[2] = TuplesKt.to(AEEditorConstants.ALBUMNAME, str2);
        CommonAlbumInfo albumInfo3 = this.repo.getAlbumInfo();
        if (albumInfo3 != null && (creator = albumInfo3.getCreator()) != null && (uin = creator.getUin()) != null) {
            str3 = uin;
        }
        pairArr[3] = TuplesKt.to("creatorUin", str3);
        CommonAlbumInfo albumInfo4 = this.repo.getAlbumInfo();
        pairArr[4] = TuplesKt.to("mediaCount", String.valueOf(albumInfo4 != null ? albumInfo4.getUploadNumber() : 0L));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        QZoneComposePlatformModule.Companion companion = QZoneComposePlatformModule.Companion;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(media);
        listOf2 = CollectionsKt__CollectionsJVMKt.listOf(Integer.valueOf(lLOCIndex));
        Function1<e, Unit> function1 = new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.qqkmp.qzone.album.QZPhotoBrowserHelper$openPhotoBrowser$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e eVar) {
                invoke2(eVar);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x0024, code lost:
            
                if (r13.f("photoBrowserDidExit") == true) goto L8;
             */
            /* JADX WARN: Code restructure failed: missing block: B:6:0x002a, code lost:
            
                r1 = r12.this$0.callbackRef;
             */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final void invoke2(e eVar) {
                String str4;
                long lLOCPolymerizeId;
                KLog kLog = KLog.INSTANCE;
                kLog.d(QZPhotoBrowserHelper.TAG, "openPhotoBrowser callback : " + eVar);
                boolean z16 = eVar != null;
                if (z16 && str4 != null) {
                    QZPhotoBrowserHelper qZPhotoBrowserHelper = QZPhotoBrowserHelper.this;
                    kLog.d(QZPhotoBrowserHelper.TAG, "removeNotify");
                    c cVar = c.f117352a;
                    ((k) cVar.g().acquireModule("KRNotifyModule")).e(QZPhotoBrowserHelper.QZ_PHOTO_BROWSER_LOAD_MORE_NOTIFICATION, str4);
                    String p16 = eVar.p("lloc");
                    if (p16 == null) {
                        p16 = "";
                    }
                    lLOCPolymerizeId = qZPhotoBrowserHelper.getLLOCPolymerizeId(p16);
                    k.d((k) cVar.g().acquireModule("KRNotifyModule"), QZPhotoBrowserHelper.QZ_DA_TU_PIC_INDEX_CHANGE, AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("lloc", p16, "link_id", String.valueOf(lLOCPolymerizeId)), false, 4, null);
                }
                callback.invoke(eVar);
            }
        };
        KLog.INSTANCE.d("QZoneComposePlatformModule", AdelieManagerCenterPage$DeleteAlertDialog$1$2$1$$ExternalSyntheticOutline0.m("openPhotoBrowser clickedViewID: ", clickedViewID, ", clickedLLOC: ", mediaLLoc));
        e eVar = new e();
        b bVar = new b();
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            bVar.t(((CommonStMedia) it.next()).toJSONObject());
        }
        b bVar2 = new b();
        Iterator it5 = listOf2.iterator();
        while (it5.hasNext()) {
            bVar2.r(((Number) it5.next()).intValue());
        }
        eVar.v("mediaList", bVar);
        eVar.v("showIndexList", bVar2);
        eVar.t("curIndex", 0);
        eVar.t("clickedViewID", clickedViewID);
        eVar.v("clickedLLOC", mediaLLoc);
        for (Map.Entry entry : mapOf.entrySet()) {
            eVar.v((String) entry.getKey(), (String) entry.getValue());
        }
        QZoneComposePlatformModule qZoneComposePlatformModule = companion.get();
        if (qZoneComposePlatformModule != null) {
            Module.toNative$default(qZoneComposePlatformModule, true, "openPhotoBrowser", eVar.toString(), function1, false, 16, null);
        }
    }
}
