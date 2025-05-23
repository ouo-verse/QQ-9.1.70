package ki;

import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonStCommonExt;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.enumtype.CommonEnumMediaType;
import com.qzone.reborn.groupalbum.bean.init.GroupAlbumAlbumDetailInitBean;
import com.qzone.reborn.groupalbum.event.GroupAlbumEditAlbumEvent;
import com.qzone.util.ToastUtil;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.utils.bl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import com.tencent.qqnt.kernel.nativeinterface.AlbumInfo;
import com.tencent.qqnt.kernel.nativeinterface.BatchInfo;
import com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback;
import com.tencent.qqnt.kernel.nativeinterface.MediaListInfo;
import com.tencent.qqnt.kernel.nativeinterface.NTGetMediaListRsp;
import com.tencent.qqnt.kernel.nativeinterface.QunMediaRightEnum;
import com.tencent.qqnt.kernel.nativeinterface.QunRight;
import com.tencent.qqnt.kernel.nativeinterface.StMedia;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.util.ArrayUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import qzone.QZoneBaseAlbumMeta$AlbumInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b6\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 \u001d2\u00020\u0001:\u0002AIB\u0007\u00a2\u0006\u0004\bv\u0010wJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002Jp\u0010\u001c\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u00132\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u00132\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\rH\u0002J\b\u0010\u001d\u001a\u00020\tH\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J8\u0010 \u001a\u00020\u00042\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u00132\u0016\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013H\u0002J(\u0010!\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0011j\b\u0012\u0004\u0012\u00020\u0015`\u0013H\u0002J\u0018\u0010%\u001a\u00020\t2\u0006\u0010\"\u001a\u00020\r2\u0006\u0010$\u001a\u00020#H\u0002J\u0010\u0010(\u001a\u00020\u00042\u0006\u0010'\u001a\u00020&H\u0002J \u0010)\u001a\u00020\t2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020#0\u0011j\b\u0012\u0004\u0012\u00020#`\u0013H\u0002J \u0010*\u001a\u00020\t2\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020#0\u0011j\b\u0012\u0004\u0012\u00020#`\u0013H\u0002J\u001a\u0010.\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u0010-\u001a\u00020,H\u0002J\u0016\u00102\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020\u000bJ\u0018\u00105\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u00104\u001a\u000203J\u0018\u00106\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\r2\u0006\u00104\u001a\u000203J\u0010\u00107\u001a\u00020\u00042\b\u0010+\u001a\u0004\u0018\u00010\rJ\u000e\u00108\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u00109\u001a\u00020\u00042\u0006\u00100\u001a\u00020/J\u000e\u0010:\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tJ\b\u0010;\u001a\u00020\tH\u0016J\u0016\u0010>\u001a\u00020\u000b2\u0006\u0010=\u001a\u00020<2\u0006\u0010\"\u001a\u00020\rJ&\u0010@\u001a\u00020\u00042\u0016\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020#0\u0011j\b\u0012\u0004\u0012\u00020#`\u00132\u0006\u0010?\u001a\u00020\rR$\u0010G\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010K\u001a\b\u0012\u0004\u0012\u00020&0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR4\u0010R\u001a\u0014\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002030H0L8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010M\u001a\u0004\bN\u0010O\"\u0004\bP\u0010QR$\u0010Y\u001a\u0004\u0018\u00010S8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\"\u0010`\u001a\u00020Z8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\b\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010bR\u0018\u0010f\u001a\u0004\u0018\u00010d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010eR\u0018\u0010h\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010gR\u001a\u0010i\u001a\b\u0012\u0004\u0012\u00020#0H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b;\u0010JR\"\u0010o\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010j\u001a\u0004\bk\u0010l\"\u0004\bm\u0010nR\"\u0010u\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010p\u001a\u0004\bq\u0010r\"\u0004\bs\u0010t\u00a8\u0006x"}, d2 = {"Lki/g;", "", "Lci/h;", "requestBean", "", "B", "Lci/e;", "f", "e", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "", "result", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/AlbumInfo;", "album", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchInfo;", "Lkotlin/collections/ArrayList;", "batchList", "Lcom/tencent/qqnt/kernel/nativeinterface/StMedia;", "mediaList", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaListInfo;", "mediaInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/QunRight;", "right", "traceId", tl.h.F, "l", "y", "stMediaList", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "lLoc", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", QAdVrReportParams.ParamKey.MEDIA, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "d", ReportConstant.COSTREPORT_PREFIX, "t", "albumId", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", DomainData.DOMAIN_NAME, "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "bean", "rightIndex", "j", "Lki/g$b;", "listener", "p", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, HippyTKDListViewAdapter.X, "k", "u", "i", "", "batchId", "c", "spaceId", "r", "a", "Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "getInitBean", "()Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;", "setInitBean", "(Lcom/qzone/reborn/groupalbum/bean/init/GroupAlbumAlbumDetailInitBean;)V", "initBean", "", "b", "Ljava/util/List;", "allBatch", "", "Ljava/util/Map;", "getListenerMap", "()Ljava/util/Map;", "setListenerMap", "(Ljava/util/Map;)V", "listenerMap", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "getAlbumInfoData", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "setAlbumInfoData", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;)V", "albumInfoData", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "g", "()Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "setLoadInfo", "(Lcom/tencent/biz/richframework/part/block/base/LoadInfo;)V", "loadInfo", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumCommData;", "commData", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStCommonExt;", "commonExt", "Lci/h;", "layerRequestBean", "mediaInfoList", "I", "getRightBoundIndex", "()I", "setRightBoundIndex", "(I)V", "rightBoundIndex", "Z", "getRightHasMore", "()Z", "setRightHasMore", "(Z)V", "rightHasMore", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class g {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private GroupAlbumAlbumDetailInitBean initBean;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumInfo albumInfoData;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private CommonAlbumCommData commData;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private CommonStCommonExt commonExt;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private ci.h layerRequestBean;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private int rightBoundIndex;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean rightHasMore;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final List<com.qzone.reborn.albumx.common.bean.a> allBatch = new ArrayList();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private Map<String, List<b>> listenerMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private LoadInfo loadInfo = new LoadInfo();

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final List<CommonStMedia> mediaInfoList = new ArrayList();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lki/g$b;", "", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public interface b {
        void a(com.qzone.reborn.albumx.common.bean.b repoBean);
    }

    private final void B(ci.h requestBean) {
        ci.e e16 = e(requestBean);
        ci.b bVar = new ci.b();
        bVar.v(e16);
        bVar.p(true);
        bVar.t(this.mediaInfoList.size() - 1);
        n(requestBean.getAlbumId(), bVar);
    }

    private final void d(com.qzone.reborn.albumx.common.bean.a batchBean) {
        List reversed;
        batchBean.k(batchBean.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String());
        reversed = CollectionsKt___CollectionsKt.reversed(this.allBatch);
        Iterator it = reversed.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((com.qzone.reborn.albumx.common.bean.a) it.next()).getTimeId(), batchBean.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String())) {
                batchBean.getBatchInfo().w("");
            }
        }
    }

    private final ci.e e(ci.h requestBean) {
        ci.e eVar = new ci.e();
        if (requestBean == null) {
            return eVar;
        }
        String stringAttachInfo = this.loadInfo.getStringAttachInfo();
        Intrinsics.checkNotNullExpressionValue(stringAttachInfo, "loadInfo.stringAttachInfo");
        eVar.f0(stringAttachInfo);
        eVar.t0(requestBean.getIsRefresh());
        eVar.o0(requestBean.getIsFetchLeft());
        eVar.p0(requestBean.getIsFetchRight());
        this.rightHasMore = this.loadInfo.isFinish();
        eVar.r0(true);
        eVar.u0(this.rightHasMore);
        QZoneBaseAlbumMeta$AlbumInfo f16 = xh.e.f(this.albumInfoData);
        PBStringField pBStringField = f16.name;
        eVar.k(pBStringField != null ? pBStringField.get() : null);
        PBStringField pBStringField2 = f16.album_id;
        eVar.j(pBStringField2 != null ? pBStringField2.get() : null);
        PBUInt64Field pBUInt64Field = f16.upload_number;
        eVar.s0((int) RangesKt.coerceIn(pBUInt64Field != null ? pBUInt64Field.get() : 0L, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, TTL.MAX_VALUE));
        ArrayList arrayList = new ArrayList();
        if (eVar.getIsRefresh()) {
            arrayList.addAll(this.mediaInfoList);
        } else if (this.rightBoundIndex + 1 <= this.mediaInfoList.size()) {
            List<CommonStMedia> list = this.mediaInfoList;
            arrayList.addAll(list.subList(this.rightBoundIndex + 1, list.size()));
        }
        this.rightBoundIndex = this.mediaInfoList.size() - 1;
        String groupId = requestBean.getGroupId();
        if (groupId == null) {
            groupId = "";
        }
        eVar.e0(groupId);
        eVar.g0(this.rightBoundIndex);
        eVar.y(new ArrayList<>(arrayList));
        return eVar;
    }

    private final ci.e f() {
        ci.h hVar = this.layerRequestBean;
        if (hVar != null) {
            hVar.q(true);
        }
        ci.h hVar2 = this.layerRequestBean;
        if (hVar2 != null) {
            hVar2.l(true);
        }
        ci.h hVar3 = this.layerRequestBean;
        if (hVar3 != null) {
            hVar3.m(true);
        }
        return e(this.layerRequestBean);
    }

    private final void h(boolean isLoadMore, int result, String errMsg, AlbumInfo album, ArrayList<BatchInfo> batchList, ArrayList<StMedia> mediaList, MediaListInfo mediaInfo, QunRight right, String traceId) {
        QLog.e("GroupAlbumDetailRepo", 1, "handleAlbumDetailListResponse result:=" + result + ",traceId:=" + traceId);
        this.loadInfo.setCurrentState(4);
        if (result != 0) {
            ToastUtil.s(errMsg, 4);
            QLog.e("GroupAlbumDetailRepo", 1, "albumDetailListResponse rsp error  isSuccess = false, errMsg = " + errMsg);
            List<com.qzone.reborn.albumx.common.bean.a> list = this.allBatch;
            CommonAlbumCommData commonAlbumCommData = this.commData;
            String str = album.albumId;
            com.qzone.reborn.albumx.common.bean.b bVar = new com.qzone.reborn.albumx.common.bean.b();
            bVar.s(result);
            bVar.q(isLoadMore);
            if (isLoadMore) {
                bVar.l(list);
                bVar.m(commonAlbumCommData);
            }
            Unit unit = Unit.INSTANCE;
            n(str, bVar);
            return;
        }
        this.loadInfo.setStringAttachInfo(mediaInfo.nextAttachInfo);
        boolean z16 = album.creator.uin.equals(LoginData.getInstance().getUinString()) || album.creator.uid.equals(LoginData.getInstance().getUid());
        CommonAlbumCommData commonAlbumCommData2 = new CommonAlbumCommData();
        this.commData = commonAlbumCommData2;
        commonAlbumCommData2.k(right.normalUpload);
        commonAlbumCommData2.c().addAll(right.right);
        if (z16) {
            commonAlbumCommData2.c().add(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMMODIFYALBUM.ordinal()));
            commonAlbumCommData2.c().add(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMDELETEMEDIA.ordinal()));
            commonAlbumCommData2.c().add(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMDELETEALBUM.ordinal()));
        }
        if (!isLoadMore) {
            this.albumInfoData = xh.a.a(album);
            this.allBatch.clear();
        }
        o(mediaList, batchList);
        z(isLoadMore, mediaList);
        this.loadInfo.setFinish(!mediaInfo.nextHasMore);
        ci.b bVar2 = new ci.b();
        bVar2.m(this.commData);
        bVar2.k(this.albumInfoData);
        bVar2.o(errMsg);
        bVar2.s(result);
        bVar2.q(isLoadMore);
        bVar2.l(this.allBatch);
        bVar2.v(e(this.layerRequestBean));
        bVar2.t(this.rightBoundIndex);
        n(album.albumId, bVar2);
    }

    private final boolean l() {
        return this.loadInfo.isFinish();
    }

    private final boolean m(String lLoc, CommonStMedia media) {
        if (media.getType() == CommonEnumMediaType.IMAGE.ordinal()) {
            return TextUtils.equals(media.getImage().getLloc(), lLoc);
        }
        return TextUtils.equals(media.getVideo().getCover().getLloc(), lLoc);
    }

    private final void o(ArrayList<StMedia> stMediaList, ArrayList<BatchInfo> batchList) {
        for (StMedia stMedia : stMediaList) {
            for (BatchInfo batchInfo : batchList) {
                if (stMedia.batchId == batchInfo.linkId) {
                    batchInfo.medias.add(stMedia);
                }
            }
        }
        int i3 = 0;
        if (!bl.b(batchList) && !bl.b(this.allBatch)) {
            long j3 = batchList.get(0).linkId;
            List<com.qzone.reborn.albumx.common.bean.a> list = this.allBatch;
            if (j3 == list.get(list.size() - 1).getBatchInfo().getLinkId()) {
                ArrayList<StMedia> arrayList = batchList.get(0).medias;
                Intrinsics.checkNotNullExpressionValue(arrayList, "batchList[0].medias");
                for (StMedia it : arrayList) {
                    List<com.qzone.reborn.albumx.common.bean.a> list2 = this.allBatch;
                    List<CommonStMedia> j16 = list2.get(list2.size() - 1).getBatchInfo().j();
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    j16.add(xh.h.b(it));
                }
                i3 = 1;
            }
        }
        QLog.d("GroupAlbumDetailRepo", 1, "polymerizeBatchListData  startMergeBatchPos = " + i3);
        if (batchList != null) {
            int size = batchList.size();
            while (i3 < size) {
                BatchInfo batchInfo2 = batchList.get(i3);
                Intrinsics.checkNotNullExpressionValue(batchInfo2, "batchList[i]");
                com.qzone.reborn.albumx.common.bean.a aVar = new com.qzone.reborn.albumx.common.bean.a(xh.b.a(batchInfo2));
                d(aVar);
                this.allBatch.add(aVar);
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(long j3, final g this$0, final boolean z16, final NTGetMediaListRsp nTGetMediaListRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i3 = nTGetMediaListRsp.result;
        fj.v.a(i3 == 0, 4, i3, System.currentTimeMillis() - j3, nTGetMediaListRsp.traceId);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: ki.f
            @Override // java.lang.Runnable
            public final void run() {
                g.w(NTGetMediaListRsp.this, this$0, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(NTGetMediaListRsp nTGetMediaListRsp, g this$0, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MediaListInfo mediaListInfo = new MediaListInfo(nTGetMediaListRsp.prevAttachInfo, nTGetMediaListRsp.nextAttachInfo, nTGetMediaListRsp.prevHasMore, nTGetMediaListRsp.nextHasMore, nTGetMediaListRsp.mediaIndex);
        int i3 = nTGetMediaListRsp.result;
        String str = nTGetMediaListRsp.errMs;
        Intrinsics.checkNotNullExpressionValue(str, "response.errMs");
        AlbumInfo albumInfo = nTGetMediaListRsp.album;
        Intrinsics.checkNotNullExpressionValue(albumInfo, "response.album");
        ArrayList<BatchInfo> arrayList = nTGetMediaListRsp.batchList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "response.batchList");
        ArrayList<StMedia> arrayList2 = nTGetMediaListRsp.mediaList;
        Intrinsics.checkNotNullExpressionValue(arrayList2, "response.mediaList");
        QunRight qunRight = nTGetMediaListRsp.right;
        Intrinsics.checkNotNullExpressionValue(qunRight, "response.right");
        String str2 = nTGetMediaListRsp.traceId;
        Intrinsics.checkNotNullExpressionValue(str2, "response.traceId");
        this$0.h(z16, i3, str, albumInfo, arrayList, arrayList2, mediaListInfo, qunRight, str2);
    }

    private final void y() {
        LoadInfo loadInfo = new LoadInfo();
        this.loadInfo = loadInfo;
        loadInfo.setStringAttachInfo("");
        this.loadInfo.setFinish(false);
    }

    private final void z(boolean isLoadMore, ArrayList<StMedia> mediaList) {
        if (mediaList.isEmpty()) {
            return;
        }
        if (!isLoadMore) {
            this.mediaInfoList.clear();
            QLog.i("GroupAlbumDetailRepo", 1, "media list size is` " + mediaList.size());
            Iterator<T> it = mediaList.iterator();
            while (it.hasNext()) {
                this.mediaInfoList.add(xh.h.b((StMedia) it.next()));
            }
            return;
        }
        QLog.i("GroupAlbumDetailRepo", 1, "media list size is1 " + mediaList.size());
        Iterator<T> it5 = mediaList.iterator();
        while (it5.hasNext()) {
            this.mediaInfoList.add(xh.h.b((StMedia) it5.next()));
        }
    }

    public final void A(String albumId, b listener) {
        List<b> list;
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (albumId == null || albumId.length() == 0) {
            RFWLog.e("GroupAlbumDetailRepo", RFWLog.USR, "unregister fail groupId is null");
        } else if (this.listenerMap.containsKey(albumId) && (list = this.listenerMap.get(albumId)) != null) {
            list.remove(listener);
        }
    }

    public final int c(long batchId, String lLoc) {
        Intrinsics.checkNotNullParameter(lLoc, "lLoc");
        Iterator<com.qzone.reborn.albumx.common.bean.a> it = this.allBatch.iterator();
        boolean z16 = false;
        int i3 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            com.qzone.reborn.albumx.common.bean.a next = it.next();
            if (next.getBatchInfo().getLinkId() == batchId) {
                List<CommonStMedia> j3 = next.getBatchInfo().j();
                if (!bl.b(j3)) {
                    Iterator<CommonStMedia> it5 = j3.iterator();
                    int i16 = 0;
                    while (true) {
                        if (!it5.hasNext()) {
                            break;
                        }
                        if (m(lLoc, it5.next())) {
                            z16 = true;
                            break;
                        }
                        i16++;
                    }
                    i3 += i16;
                }
            } else {
                i3 += next.getBatchInfo().j().size();
            }
        }
        if (z16) {
            return i3;
        }
        return -1;
    }

    /* renamed from: g, reason: from getter */
    public final LoadInfo getLoadInfo() {
        return this.loadInfo;
    }

    public boolean i() {
        ArrayList<Integer> c16;
        CommonAlbumCommData commonAlbumCommData = this.commData;
        if (commonAlbumCommData == null || (c16 = commonAlbumCommData.c()) == null) {
            return false;
        }
        return c16.contains(Integer.valueOf(QunMediaRightEnum.KQUNMEDIARIGHTENUMDELETEMEDIA.ordinal()));
    }

    public final void j(GroupAlbumAlbumDetailInitBean bean, int rightIndex) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.initBean = bean;
        this.rightBoundIndex = rightIndex;
    }

    public final void k(GroupAlbumAlbumDetailInitBean bean) {
        Intrinsics.checkNotNullParameter(bean, "bean");
        this.initBean = bean;
    }

    public final void p(String albumId, b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (albumId == null || albumId.length() == 0) {
            RFWLog.e("GroupAlbumDetailRepo", RFWLog.USR, "register fail groupId is null");
            return;
        }
        if (!this.listenerMap.containsKey(albumId)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(listener);
            this.listenerMap.put(albumId, arrayList);
            return;
        }
        List<b> list = this.listenerMap.get(albumId);
        Intrinsics.checkNotNull(list);
        Iterator<b> it = list.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(String.valueOf(listener.hashCode()), String.valueOf(it.next().hashCode()))) {
                return;
            }
        }
        List<b> list2 = this.listenerMap.get(albumId);
        if (list2 != null) {
            list2.add(listener);
        }
    }

    public final void q(String albumId) {
        y();
        if (!(albumId == null || albumId.length() == 0) && this.listenerMap.containsKey(albumId)) {
            this.listenerMap.remove(albumId);
        }
        this.allBatch.clear();
        this.mediaInfoList.clear();
        this.albumInfoData = null;
        this.initBean = null;
        this.layerRequestBean = null;
    }

    public final void r(ArrayList<CommonStMedia> mediaList, String spaceId) {
        CommonAlbumInfo commonAlbumInfo;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(spaceId, "spaceId");
        boolean s16 = s(mediaList);
        boolean t16 = t(mediaList);
        if (s16 && t16) {
            CommonAlbumInfo commonAlbumInfo2 = this.albumInfoData;
            long uploadNumber = (commonAlbumInfo2 != null ? commonAlbumInfo2.getUploadNumber() : 0L) - mediaList.size();
            if (uploadNumber >= 0 && (commonAlbumInfo = this.albumInfoData) != null) {
                commonAlbumInfo.y0(uploadNumber);
            }
            if (s16 && t16) {
                ci.b bVar = new ci.b();
                bVar.m(this.commData);
                bVar.l(this.allBatch);
                bVar.k(this.albumInfoData);
                bVar.n(this.commonExt);
                bVar.q(true);
                bVar.v(f());
                bVar.t(this.rightBoundIndex);
                CommonAlbumInfo commonAlbumInfo3 = this.albumInfoData;
                n(commonAlbumInfo3 != null ? commonAlbumInfo3.getAlbumId() : null, bVar);
                SimpleEventBus.getInstance().dispatchEvent(new GroupAlbumEditAlbumEvent(spaceId, null, this.albumInfoData, null, 10, null));
                return;
            }
            return;
        }
        RFWLog.e("", RFWLog.USR, "isFindInBatchList = " + s16 + " isFindInMediaInfoList = " + t16);
    }

    public final void x(ci.h requestBean) {
        Intrinsics.checkNotNullParameter(requestBean, "requestBean");
        if (this.initBean == null) {
            RFWLog.e("GroupAlbumDetailRepo", RFWLog.USR, "initBean is null");
            return;
        }
        this.layerRequestBean = requestBean;
        if (requestBean.getIsRefresh()) {
            B(requestBean);
        } else {
            u(true);
        }
    }

    private final boolean s(ArrayList<CommonStMedia> mediaList) {
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        boolean z16 = false;
        while (it.hasNext()) {
            CommonStMedia stMedia = it.next();
            fj.p pVar = fj.p.f399467a;
            Intrinsics.checkNotNullExpressionValue(stMedia, "stMedia");
            String i3 = pVar.i(stMedia);
            Iterator<com.qzone.reborn.albumx.common.bean.a> it5 = this.allBatch.iterator();
            while (true) {
                if (it5.hasNext()) {
                    com.qzone.reborn.albumx.common.bean.a next = it5.next();
                    if (next.getBatchInfo().getLinkId() == stMedia.getBatchId()) {
                        List<CommonStMedia> j3 = next.getBatchInfo().j();
                        if (!j3.isEmpty()) {
                            Iterator<CommonStMedia> it6 = j3.iterator();
                            while (true) {
                                if (!it6.hasNext()) {
                                    break;
                                }
                                if (m(i3, it6.next())) {
                                    it6.remove();
                                    if (next.getBatchInfo().j().size() == 0) {
                                        this.allBatch.remove(next);
                                        if ((!this.allBatch.isEmpty()) && Intrinsics.areEqual(this.allBatch.get(0).getTimeId(), next.getTimeId())) {
                                            if (this.allBatch.get(0).getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String().length() == 0) {
                                                this.allBatch.get(0).getBatchInfo().w(next.getBatchInfo().getCom.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SHOW_TIME java.lang.String());
                                            }
                                        }
                                    }
                                    next.getBatchInfo().z(r1.getUploadNumber() - 1);
                                    z16 = true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return z16;
    }

    private final boolean t(ArrayList<CommonStMedia> mediaList) {
        boolean z16 = false;
        if (ArrayUtils.isOutOfArrayIndex(0, mediaList)) {
            return false;
        }
        Iterator<CommonStMedia> it = mediaList.iterator();
        while (it.hasNext()) {
            CommonStMedia stMedia = it.next();
            fj.p pVar = fj.p.f399467a;
            Intrinsics.checkNotNullExpressionValue(stMedia, "stMedia");
            String i3 = pVar.i(stMedia);
            Iterator<CommonStMedia> it5 = this.mediaInfoList.iterator();
            while (true) {
                if (!it5.hasNext()) {
                    break;
                }
                if (m(i3, it5.next())) {
                    it5.remove();
                    z16 = true;
                    break;
                }
            }
        }
        return z16;
    }

    private final void n(String albumId, com.qzone.reborn.albumx.common.bean.b repoBean) {
        if ((albumId == null || albumId.length() == 0) || !this.listenerMap.containsKey(albumId)) {
            return;
        }
        Map<String, List<b>> map = this.listenerMap;
        CommonAlbumInfo commonAlbumInfo = this.albumInfoData;
        List<b> list = map.get(commonAlbumInfo != null ? commonAlbumInfo.getAlbumId() : null);
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((b) it.next()).a(repoBean);
            }
        }
    }

    public final void u(final boolean isLoadMore) {
        if (!isLoadMore) {
            y();
        }
        GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean = this.initBean;
        if (groupAlbumAlbumDetailInitBean != null) {
            Intrinsics.checkNotNull(groupAlbumAlbumDetailInitBean);
            if (TextUtils.isEmpty(groupAlbumAlbumDetailInitBean.getAlbumId())) {
                return;
            }
            QLog.d("GroupAlbumDetailRepo", 1, "requestGetAlbumBatchList  attachInfo : " + this.loadInfo.getStringAttachInfo() + " | isLoadMore : " + isLoadMore + " | initBean : " + this.initBean);
            if (isLoadMore && l()) {
                return;
            }
            this.loadInfo.setCurrentState(isLoadMore ? 3 : 2);
            final long currentTimeMillis = System.currentTimeMillis();
            GroupAlbumAlbumDetailInitBean groupAlbumAlbumDetailInitBean2 = this.initBean;
            if (groupAlbumAlbumDetailInitBean2 != null) {
                a.f412421a.b(groupAlbumAlbumDetailInitBean2.getGroupId(), groupAlbumAlbumDetailInitBean2.getAlbumId(), "", groupAlbumAlbumDetailInitBean2.getBatchId(), this.loadInfo.getStringAttachInfo(), new IAlbumServiceGetMediaListCallback() { // from class: ki.e
                    @Override // com.tencent.qqnt.kernel.nativeinterface.IAlbumServiceGetMediaListCallback
                    public final void onGetMediaList(NTGetMediaListRsp nTGetMediaListRsp) {
                        g.v(currentTimeMillis, this, isLoadMore, nTGetMediaListRsp);
                    }
                });
            }
        }
    }
}
