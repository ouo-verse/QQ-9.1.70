package nc;

import android.app.Activity;
import android.content.Intent;
import android.widget.ImageView;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.MutableLiveData;
import com.qzone.common.account.LoginData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumCommData;
import com.qzone.reborn.albumx.common.convert.bean.CommonAlbumInfo;
import com.qzone.reborn.albumx.common.convert.bean.CommonClientAttr;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsArea;
import com.qzone.reborn.albumx.common.convert.bean.CommonMediaLbsAreaList;
import com.qzone.reborn.albumx.common.convert.bean.CommonPageEndMsg;
import com.qzone.reborn.albumx.common.convert.bean.CommonRecommendMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStLBS;
import com.qzone.reborn.albumx.common.convert.bean.CommonStMedia;
import com.qzone.reborn.albumx.common.convert.bean.CommonStTimeLineEvent;
import com.qzone.reborn.albumx.qzonex.bean.initbean.QZAlbumxAlbumDetailInitBean;
import com.qzone.reborn.albumx.qzonex.event.QZAlbumxUpdateAlbumEvent;
import com.qzone.reborn.base.n;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.block.base.LoadInfo;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.EditPhoto;
import com.tencent.qqnt.kernel.nativeinterface.EditPhotoOperaType;
import com.tencent.qqnt.kernel.nativeinterface.EditTravelAlbumScence;
import com.tencent.qqnt.kernel.nativeinterface.EditTravelAlbumScenceOperationType;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditBatchMediaCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditTravelAlbumScenceCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceMoveBatchPhotoCallback;
import com.tencent.qqnt.kernel.nativeinterface.MediaLbsArea;
import com.tencent.qqnt.kernel.nativeinterface.PAEditBatchMediaReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditBatchMediaRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAEditTravelAlbumScenceReq;
import com.tencent.qqnt.kernel.nativeinterface.PAEditTravelAlbumScenceRsp;
import com.tencent.qqnt.kernel.nativeinterface.PAMoveBatchPhotoReq;
import com.tencent.qqnt.kernel.nativeinterface.PAMoveBatchPhotoRsp;
import com.tencent.qqnt.kernel.nativeinterface.StLBS;
import com.tencent.richframework.data.base.UIStateData;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import nc.y;
import ub.k;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d6\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0019\n\u0002\u0010!\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\b\u0007*\u0002\u00b5\u0001\u0018\u00002\u00020\u0001B\t\u00a2\u0006\u0006\b\u00b9\u0001\u0010\u00ba\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J0\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000b2\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0018H\u0016J\u0010\u0010\u001c\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\u000e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u001dJ\u0010\u0010 \u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0016\u0010%\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020!2\u0006\u0010$\u001a\u00020#J\b\u0010&\u001a\u00020\u0016H\u0016J8\u0010/\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020!2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020!H\u0016JN\u00101\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020!2\u0006\u0010*\u001a\u00020\u00102\u0006\u0010+\u001a\u00020!2\u0006\u0010-\u001a\u00020,2\u0006\u0010.\u001a\u00020!2\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011J\b\u00102\u001a\u00020\u0004H\u0016J4\u00107\u001a\u00020\u00042\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u00104\u001a\u0002032\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b05J4\u0010:\u001a\u00020\u00042\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u00109\u001a\u0002082\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b05Jf\u0010@\u001a\u00020\u00042\u0016\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\b\u0010<\u001a\u0004\u0018\u00010;2\u0006\u0010\u0014\u001a\u00020=2\u0006\u0010>\u001a\u00020\u000b2\u0016\u0010?\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00112\u0006\u0010\u000e\u001a\u00020\u000b2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000b05J\u0018\u0010C\u001a\u00020\u00042\b\u0010A\u001a\u0004\u0018\u00010\u00162\u0006\u0010B\u001a\u00020!J*\u0010G\u001a\u00020F2\u0006\u0010D\u001a\u0002082\u001a\u0010E\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010\u000fj\n\u0012\u0004\u0012\u00020!\u0018\u0001`\u0011R$\u0010N\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010I\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\"\u0010V\u001a\u00020O8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010]\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R(\u0010f\u001a\b\u0012\u0004\u0012\u00020_0^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR*\u0010n\u001a\u00020\u000b2\u0006\u0010g\u001a\u00020\u000b8\u0006@FX\u0086\u000e\u00a2\u0006\u0012\n\u0004\bh\u0010i\u001a\u0004\bj\u0010k\"\u0004\bl\u0010mR(\u0010r\u001a\b\u0012\u0004\u0012\u00020\u000b0^8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bo\u0010a\u001a\u0004\bp\u0010c\"\u0004\bq\u0010eR$\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010t\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR#\u0010|\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020#0y0^8\u0006\u00a2\u0006\f\n\u0004\bz\u0010a\u001a\u0004\b{\u0010cR-\u0010\u007f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020!0\u000fj\b\u0012\u0004\u0012\u00020!`\u00110^8\u0006\u00a2\u0006\f\n\u0004\b}\u0010a\u001a\u0004\b~\u0010cR\"\u0010\u0082\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0^8\u0006\u00a2\u0006\u000e\n\u0005\b\u0080\u0001\u0010a\u001a\u0005\b\u0081\u0001\u0010cR \u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0^8\u0006\u00a2\u0006\u000e\n\u0005\b\u0083\u0001\u0010a\u001a\u0005\b\u0084\u0001\u0010cR \u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0^8\u0006\u00a2\u0006\u000e\n\u0005\b\u0086\u0001\u0010a\u001a\u0005\b\u0087\u0001\u0010cR,\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u0089\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R*\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0091\u0001\u0010\u0092\u0001\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R,\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0097\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0098\u0001\u0010\u0099\u0001\u001a\u0006\b\u009a\u0001\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R!\u0010\u00a2\u0001\u001a\t\u0012\u0005\u0012\u00030\u009f\u00010^8\u0006\u00a2\u0006\u000e\n\u0005\b\u00a0\u0001\u0010a\u001a\u0005\b\u00a1\u0001\u0010cR(\u0010\u00a8\u0001\u001a\u00020!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u00a3\u0001\u0010P\u001a\u0006\b\u00a4\u0001\u0010\u00a5\u0001\"\u0006\b\u00a6\u0001\u0010\u00a7\u0001R%\u0010\u00a9\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bi\u0010i\u001a\u0005\b\u00a9\u0001\u0010k\"\u0005\b\u00aa\u0001\u0010mR*\u0010B\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u001a\u0006\b\u00ad\u0001\u0010\u00ae\u0001\"\u0006\b\u00af\u0001\u0010\u00b0\u0001R&\u0010\u00b4\u0001\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u00b1\u0001\u0010i\u001a\u0005\b\u00b2\u0001\u0010k\"\u0005\b\u00b3\u0001\u0010mR\u0018\u0010\u00b8\u0001\u001a\u00030\u00b5\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00b6\u0001\u0010\u00b7\u0001\u00a8\u0006\u00bb\u0001"}, d2 = {"Lnc/y;", "Lcom/qzone/reborn/albumx/common/viewmodel/b;", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "N2", "M2", "K2", "L2", "O2", "P2", "", QFSSearchBaseRequest.EXTRA_KEY_IS_LOAD_MORE, "e3", "isBatchEdit", "Ljava/util/ArrayList;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStMedia;", "Lkotlin/collections/ArrayList;", "mediaList", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStLBS;", "lbs", "f3", "", "getLogTag", "Lcom/tencent/biz/richframework/part/block/base/LoadInfo;", "S1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "W2", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "initBean", "b3", "b2", "", "requestType", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "curTimeline", "Y2", "I2", "Lcom/qzone/reborn/albumx/common/bean/a;", "batchBean", "batchPos", QAdVrReportParams.ParamKey.MEDIA, "mediaPos", "Landroid/widget/ImageView;", "view", "transCreatorKey", ICustomDataEditor.STRING_ARRAY_PARAM_2, "selectMedias", "V2", "c2", "", "selectTime", "Landroidx/core/util/Consumer;", "consumer", ICustomDataEditor.STRING_PARAM_2, "Lcom/qzone/reborn/albumx/common/convert/bean/CommonAlbumInfo;", "dstAlbumInfo", "T2", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "mediaLbsAreaList", "Lcom/tencent/qqnt/kernel/nativeinterface/MediaLbsArea;", "newLbs", "allMediaList", "u2", "albumId", "sortType", "w2", "albumInfo", "rightList", "Lxa/a;", "r2", "H", "Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "C2", "()Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;", "setMInitBean", "(Lcom/qzone/reborn/albumx/qzonex/bean/initbean/QZAlbumxAlbumDetailInitBean;)V", "mInitBean", "Lub/k;", "I", "Lub/k;", NowProxyConstants.AccountInfoKey.A2, "()Lub/k;", "setDataRepo", "(Lub/k;)V", "dataRepo", "J", "Ljava/lang/String;", "getDataRepoKey", "()Ljava/lang/String;", ICustomDataEditor.STRING_ARRAY_PARAM_3, "(Ljava/lang/String;)V", "dataRepoKey", "Landroidx/lifecycle/MutableLiveData;", "", "K", "Landroidx/lifecycle/MutableLiveData;", "getLoverAlbumInviteCheckRspData", "()Landroidx/lifecycle/MutableLiveData;", "setLoverAlbumInviteCheckRspData", "(Landroidx/lifecycle/MutableLiveData;)V", "loverAlbumInviteCheckRspData", "value", "L", "Z", "R2", "()Z", "d3", "(Z)V", "isTimeLine", "M", "S2", "setTimeLineObservable", "isTimeLineObservable", "N", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "z2", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;", "setCurTimeline", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonStTimeLineEvent;)V", "", "P", "J2", "timeLineEventsData", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "E2", "opmaskData", BdhLogUtil.LogTag.Tag_Req, "x2", "curBatchTimeLineEventData", ExifInterface.LATITUDE_SOUTH, "B2", "inviteActionSheetState", "T", "H2", "shareActionSheetState", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "U", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "F2", "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;", "setPageEndMsg", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonPageEndMsg;)V", "pageEndMsg", "V", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", Constants.BASE_IN_PLUGIN_VERSION, "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;", "setMediaLbsAreaList", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonMediaLbsAreaList;)V", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;", "W", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;", Constants.MMCCID, "()Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;", "setRecommendMedia", "(Lcom/qzone/reborn/albumx/common/convert/bean/CommonRecommendMedia;)V", "recommendMedia", "Lxa/b;", "X", "y2", "curHeadCeilingBean", "Y", "getRequestCount", "()I", "setRequestCount", "(I)V", "requestCount", "isShownTopToast", "setShownTopToast", "a0", "Ljava/lang/Integer;", "getSortType", "()Ljava/lang/Integer;", "c3", "(Ljava/lang/Integer;)V", "b0", "Q2", "setFromCache", "isFromCache", "nc/y$b", "c0", "Lnc/y$b;", "listener", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class y extends com.qzone.reborn.albumx.common.viewmodel.b {

    /* renamed from: H, reason: from kotlin metadata */
    private QZAlbumxAlbumDetailInitBean mInitBean;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isTimeLine;

    /* renamed from: N, reason: from kotlin metadata */
    private CommonStTimeLineEvent curTimeline;

    /* renamed from: U, reason: from kotlin metadata */
    private CommonPageEndMsg pageEndMsg;

    /* renamed from: V, reason: from kotlin metadata */
    private CommonMediaLbsAreaList mediaLbsAreaList;

    /* renamed from: W, reason: from kotlin metadata */
    private CommonRecommendMedia recommendMedia;

    /* renamed from: Y, reason: from kotlin metadata */
    private int requestCount;

    /* renamed from: Z, reason: from kotlin metadata */
    private boolean isShownTopToast;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private Integer sortType;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean isFromCache;

    /* renamed from: I, reason: from kotlin metadata */
    private ub.k dataRepo = new ub.k();

    /* renamed from: J, reason: from kotlin metadata */
    private String dataRepoKey = "";

    /* renamed from: K, reason: from kotlin metadata */
    private MutableLiveData<Object> loverAlbumInviteCheckRspData = new MutableLiveData<>();

    /* renamed from: M, reason: from kotlin metadata */
    private MutableLiveData<Boolean> isTimeLineObservable = new MutableLiveData<>();

    /* renamed from: P, reason: from kotlin metadata */
    private final MutableLiveData<List<CommonStTimeLineEvent>> timeLineEventsData = new MutableLiveData<>();

    /* renamed from: Q, reason: from kotlin metadata */
    private final MutableLiveData<ArrayList<Integer>> opmaskData = new MutableLiveData<>();

    /* renamed from: R, reason: from kotlin metadata */
    private final MutableLiveData<CommonStTimeLineEvent> curBatchTimeLineEventData = new MutableLiveData<>();

    /* renamed from: S, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> inviteActionSheetState = new MutableLiveData<>();

    /* renamed from: T, reason: from kotlin metadata */
    private final MutableLiveData<Boolean> shareActionSheetState = new MutableLiveData<>();

    /* renamed from: X, reason: from kotlin metadata */
    private final MutableLiveData<xa.b> curHeadCeilingBean = new MutableLiveData<>();

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private final b listener = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J*\u0010\u000b\u001a\u00020\n2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u001a\u0010\u000e\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"nc/y$a", "Lcom/qzone/reborn/base/n$a;", "", "t", "", "retCode", "", "msg", "", "isFinish", "", "onSuccess", "errorCode", "errorMsg", "onFailure", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements n.a<Object> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f419913b;

        a(int i3) {
            this.f419913b = i3;
        }

        @Override // com.qzone.reborn.base.n.a
        public void onSuccess(Object t16, long retCode, String msg2, boolean isFinish) {
            String str;
            Intrinsics.checkNotNullParameter(msg2, "msg");
            y.this.c3(Integer.valueOf(this.f419913b));
            SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
            QZAlbumxAlbumDetailInitBean mInitBean = y.this.getMInitBean();
            if (mInitBean == null || (str = mInitBean.getAlbumId()) == null) {
                str = "";
            }
            simpleEventBus.dispatchEvent(new QZAlbumxUpdateAlbumEvent(str));
            QQToastUtil.showQQToastInUiThread(5, com.qzone.util.l.a(R.string.jin));
        }

        @Override // com.qzone.reborn.base.n.a
        public void onFailure(long errorCode, String errorMsg) {
            QQToastUtil.showQQToastInUiThread(4, errorMsg);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"nc/y$b", "Lub/k$b;", "Lcom/qzone/reborn/albumx/common/bean/b;", "repoBean", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class b implements k.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(b this$0, com.qzone.reborn.albumx.common.bean.b repoBean) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(repoBean, "$repoBean");
            this$0.a(repoBean);
        }

        @Override // ub.k.b
        public void a(final com.qzone.reborn.albumx.common.bean.b repoBean) {
            Intrinsics.checkNotNullParameter(repoBean, "repoBean");
            if (RFWThreadManager.isMainThread()) {
                y.this.L2(repoBean);
                y.this.N2(repoBean);
                y.this.M2(repoBean);
                y.this.K2(repoBean);
                y.this.U1(repoBean);
                y.this.P2(repoBean);
                y.this.O2(repoBean);
                return;
            }
            RFWThreadManager.getUIHandler().post(new Runnable() { // from class: nc.z
                @Override // java.lang.Runnable
                public final void run() {
                    y.b.c(y.b.this, repoBean);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void K2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        bb.b bVar = repoBean instanceof bb.b ? (bb.b) repoBean : null;
        this.isFromCache = bVar != null ? bVar.getIsFromCache() : false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void L2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        bb.b bVar = repoBean instanceof bb.b ? (bb.b) repoBean : null;
        this.mediaLbsAreaList = bVar != null ? bVar.getMediaLbsAreaList() : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        ArrayList<Integer> f16 = repoBean.f();
        if (f16 == null || f16.isEmpty()) {
            return;
        }
        MutableLiveData<ArrayList<Integer>> mutableLiveData = this.opmaskData;
        ArrayList<Integer> f17 = repoBean.f();
        Intrinsics.checkNotNull(f17);
        mutableLiveData.setValue(f17);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        if (repoBean instanceof bb.b) {
            this.pageEndMsg = ((bb.b) repoBean).getPageEndMsg();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        bb.b bVar = repoBean instanceof bb.b ? (bb.b) repoBean : null;
        this.recommendMedia = bVar != null ? bVar.getRecommendMedia() : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P2(com.qzone.reborn.albumx.common.bean.b repoBean) {
        CommonAlbumCommData commData = repoBean.getCommData();
        List<CommonStTimeLineEvent> e16 = commData != null ? commData.e() : null;
        if (e16 == null || e16.isEmpty()) {
            return;
        }
        MutableLiveData<List<CommonStTimeLineEvent>> mutableLiveData = this.timeLineEventsData;
        CommonAlbumCommData commData2 = repoBean.getCommData();
        Intrinsics.checkNotNull(commData2);
        mutableLiveData.setValue(commData2.e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U2(long j3, y this$0, ArrayList mediaList, Consumer consumer, PAMoveBatchPhotoRsp pAMoveBatchPhotoRsp) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        mc.c.f416541a.e("moveBatchPhoto", System.currentTimeMillis() - j3, pAMoveBatchPhotoRsp.result);
        if (pAMoveBatchPhotoRsp.result != 0) {
            QLog.d(this$0.getTAG(), 1, "moveBatchMedia fail, traceId: " + pAMoveBatchPhotoRsp.traceId);
            com.qzone.reborn.util.o oVar = com.qzone.reborn.util.o.f59556a;
            String str2 = pAMoveBatchPhotoRsp.errMs;
            if (str2 == null || str2.length() == 0) {
                str = "\u8f6c\u79fb\u5931\u8d25";
            } else {
                str = pAMoveBatchPhotoRsp.errMs;
            }
            oVar.d(str, 1);
        } else {
            com.qzone.reborn.util.o.f59556a.d("\u8f6c\u79fb\u6210\u529f", 0);
            this$0.dataRepo.a(mediaList, "");
        }
        consumer.accept(Boolean.valueOf(pAMoveBatchPhotoRsp.result == 0));
    }

    private final void e3(boolean isLoadMore) {
        if (this.isShownTopToast) {
            return;
        }
        if (!isLoadMore) {
            this.requestCount = 0;
            return;
        }
        String uinString = LoginData.getInstance().getUinString();
        boolean d16 = com.qzone.reborn.util.i.b().d("qz_albumx_detail_top_toast_shown_key_" + uinString, false);
        this.isShownTopToast = d16;
        int i3 = this.requestCount + 1;
        this.requestCount = i3;
        if (i3 <= 3 || d16) {
            return;
        }
        QQToastUtil.showQQToastInUiThread(3, com.qzone.util.l.a(R.string.f134839w));
        com.qzone.reborn.util.i.b().l("qz_albumx_detail_top_toast_shown_key_" + uinString, true);
        this.isShownTopToast = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t2(long j3, y this$0, Consumer consumer, PAEditBatchMediaRsp pAEditBatchMediaRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        mc.c.f416541a.e("editBatchMedia", System.currentTimeMillis() - j3, pAEditBatchMediaRsp.result);
        QLog.d(this$0.getTAG(), 1, "editBatchMediaTime traceId: " + pAEditBatchMediaRsp.traceId + ", msg:" + pAEditBatchMediaRsp.errMs);
        if (pAEditBatchMediaRsp.result != 0) {
            com.qzone.reborn.util.o.f59556a.d("\u4fee\u6539\u65f6\u95f4\u5931\u8d25", 1);
        } else {
            this$0.b2(false);
            com.qzone.reborn.util.o.f59556a.d("\u4fee\u6539\u65f6\u95f4\u6210\u529f", 0);
        }
        consumer.accept(Boolean.valueOf(pAEditBatchMediaRsp.result == 0));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v2(y this$0, boolean z16, ArrayList mediaList, MediaLbsArea lbs, Consumer consumer, PAEditTravelAlbumScenceRsp pAEditTravelAlbumScenceRsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mediaList, "$mediaList");
        Intrinsics.checkNotNullParameter(lbs, "$lbs");
        Intrinsics.checkNotNullParameter(consumer, "$consumer");
        if (pAEditTravelAlbumScenceRsp.result != 0) {
            QLog.d(this$0.getTAG(), 1, "editMediaLocal fail, traceId: " + pAEditTravelAlbumScenceRsp.traceId + ", msg:" + pAEditTravelAlbumScenceRsp.errMs);
            com.qzone.reborn.util.o.f59556a.d("\u4fee\u6539\u5730\u70b9\u5931\u8d25 " + pAEditTravelAlbumScenceRsp.errMs, 1);
        } else {
            StLBS stLBS = lbs.lbsInfo;
            Intrinsics.checkNotNullExpressionValue(stLBS, "lbs.lbsInfo");
            this$0.f3(z16, mediaList, xh.g.a(stLBS));
            com.qzone.reborn.util.o.f59556a.d("\u4fee\u6539\u5730\u70b9\u6210\u529f", 0);
        }
        consumer.accept(Boolean.valueOf(pAEditTravelAlbumScenceRsp.result == 0));
    }

    /* renamed from: A2, reason: from getter */
    public final ub.k getDataRepo() {
        return this.dataRepo;
    }

    public final MutableLiveData<Boolean> B2() {
        return this.inviteActionSheetState;
    }

    /* renamed from: C2, reason: from getter */
    public final QZAlbumxAlbumDetailInitBean getMInitBean() {
        return this.mInitBean;
    }

    /* renamed from: D2, reason: from getter */
    public final CommonMediaLbsAreaList getMediaLbsAreaList() {
        return this.mediaLbsAreaList;
    }

    public final MutableLiveData<ArrayList<Integer>> E2() {
        return this.opmaskData;
    }

    /* renamed from: F2, reason: from getter */
    public final CommonPageEndMsg getPageEndMsg() {
        return this.pageEndMsg;
    }

    /* renamed from: G2, reason: from getter */
    public final CommonRecommendMedia getRecommendMedia() {
        return this.recommendMedia;
    }

    public final MutableLiveData<Boolean> H2() {
        return this.shareActionSheetState;
    }

    public String I2() {
        return "";
    }

    public final MutableLiveData<List<CommonStTimeLineEvent>> J2() {
        return this.timeLineEventsData;
    }

    /* renamed from: Q2, reason: from getter */
    public final boolean getIsFromCache() {
        return this.isFromCache;
    }

    /* renamed from: R2, reason: from getter */
    public final boolean getIsTimeLine() {
        return this.isTimeLine;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public LoadInfo S1() {
        return this.dataRepo.getLoadInfo();
    }

    public final MutableLiveData<Boolean> S2() {
        return this.isTimeLineObservable;
    }

    public final void T2(final ArrayList<CommonStMedia> mediaList, CommonAlbumInfo dstAlbumInfo, final Consumer<Boolean> consumer) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(dstAlbumInfo, "dstAlbumInfo");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        String albumId = dstAlbumInfo.getAlbumId();
        CommonAlbumInfo value = M1().getValue();
        if (Intrinsics.areEqual(albumId, value != null ? value.getAlbumId() : null)) {
            QLog.d(getTAG(), 1, "moveBatchMedia fail dst album == src album");
            com.qzone.reborn.util.o.f59556a.d("\u4e0d\u80fd\u8f6c\u79fb\u5230\u540c\u4e00\u4e2a\u76f8\u518c\u4e2d", 1);
            return;
        }
        PAMoveBatchPhotoReq pAMoveBatchPhotoReq = new PAMoveBatchPhotoReq();
        CommonAlbumInfo value2 = M1().getValue();
        pAMoveBatchPhotoReq.srcAlbumid = value2 != null ? value2.getAlbumId() : null;
        pAMoveBatchPhotoReq.dstAlbumid = dstAlbumInfo.getAlbumId();
        Iterator<T> it = mediaList.iterator();
        while (it.hasNext()) {
            pAMoveBatchPhotoReq.srcPicidList.add(((CommonStMedia) it.next()).k());
        }
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.moveBatchPhoto(pAMoveBatchPhotoReq, new IPersonalAlbumServiceMoveBatchPhotoCallback() { // from class: nc.w
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceMoveBatchPhotoCallback
                public final void onMoveBatchPhoto(PAMoveBatchPhotoRsp pAMoveBatchPhotoRsp) {
                    y.U2(currentTimeMillis, this, mediaList, consumer, pAMoveBatchPhotoRsp);
                }
            });
        }
    }

    public final void V2(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view, int transCreatorKey, ArrayList<CommonStMedia> selectMedias) {
        String str;
        String name;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(selectMedias, "selectMedias");
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.mInitBean;
        String str2 = "";
        if (qZAlbumxAlbumDetailInitBean == null || (str = qZAlbumxAlbumDetailInitBean.getAlbumId()) == null) {
            str = "";
        }
        batchBean.g(str);
        CommonAlbumInfo value = M1().getValue();
        if (value != null && (name = value.getName()) != null) {
            str2 = name;
        }
        batchBean.h(str2);
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.mInitBean;
        if (qZAlbumxAlbumDetailInitBean2 != null) {
            qZAlbumxAlbumDetailInitBean2.setClickMediaPos(this.dataRepo.h(batchBean.getBatchInfo().getLinkId(), k9.b.f411905a.a(media)));
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean3 = this.mInitBean;
        if (qZAlbumxAlbumDetailInitBean3 != null) {
            qZAlbumxAlbumDetailInitBean3.setDataRepoKey(this.dataRepoKey);
        }
        view.setTag(R.id.f100755tc, Integer.valueOf(transCreatorKey));
        com.qzone.reborn.albumx.qzonex.utils.h.f53411a.c(view.getContext(), view, mediaPos, I2(), batchBean, this.mInitBean, selectMedias);
    }

    public final void W2(Activity activity) {
        Intent intent;
        if (this.mInitBean != null || activity == null || (intent = activity.getIntent()) == null || intent.getExtras() == null) {
            return;
        }
        Intent intent2 = activity.getIntent();
        Serializable serializableExtra = intent2 != null ? intent2.getSerializableExtra("key_bundle_common_init_bean") : null;
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = serializableExtra instanceof QZAlbumxAlbumDetailInitBean ? (QZAlbumxAlbumDetailInitBean) serializableExtra : null;
        this.mInitBean = qZAlbumxAlbumDetailInitBean;
        if (this.sortType == null) {
            this.sortType = qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getSortType() : null;
        }
    }

    public final void Y2(int requestType, CommonStTimeLineEvent curTimeline) {
        Intrinsics.checkNotNullParameter(curTimeline, "curTimeline");
        this.curTimeline = curTimeline;
        d3(true);
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.mInitBean;
        if (qZAlbumxAlbumDetailInitBean != null) {
            this.dataRepo.A(qZAlbumxAlbumDetailInitBean);
        }
        ub.k kVar = this.dataRepo;
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.mInitBean;
        kVar.I(qZAlbumxAlbumDetailInitBean2 != null ? qZAlbumxAlbumDetailInitBean2.getAlbumId() : null, this.listener);
        this.dataRepo.U(this.isTimeLine, curTimeline);
        this.dataRepo.O(requestType, curTimeline);
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void a2(com.qzone.reborn.albumx.common.bean.a batchBean, int batchPos, CommonStMedia media, int mediaPos, ImageView view, int transCreatorKey) {
        String str;
        String name;
        Intrinsics.checkNotNullParameter(batchBean, "batchBean");
        Intrinsics.checkNotNullParameter(media, "media");
        Intrinsics.checkNotNullParameter(view, "view");
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.mInitBean;
        String str2 = "";
        if (qZAlbumxAlbumDetailInitBean == null || (str = qZAlbumxAlbumDetailInitBean.getAlbumId()) == null) {
            str = "";
        }
        batchBean.g(str);
        CommonAlbumInfo value = M1().getValue();
        if (value != null && (name = value.getName()) != null) {
            str2 = name;
        }
        batchBean.h(str2);
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.mInitBean;
        if (qZAlbumxAlbumDetailInitBean2 != null) {
            qZAlbumxAlbumDetailInitBean2.setClickMediaPos(this.dataRepo.h(batchBean.getBatchInfo().getLinkId(), k9.b.f411905a.a(media)));
        }
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean3 = this.mInitBean;
        if (qZAlbumxAlbumDetailInitBean3 != null) {
            qZAlbumxAlbumDetailInitBean3.setDataRepoKey(this.dataRepoKey);
        }
        view.setTag(R.id.f100755tc, Integer.valueOf(transCreatorKey));
        com.qzone.reborn.albumx.qzonex.utils.h.f53411a.d(view.getContext(), view, mediaPos, I2(), batchBean, this.mInitBean);
    }

    public final void a3(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dataRepoKey = str;
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void b2(boolean isLoadMore) {
        CommonStTimeLineEvent commonStTimeLineEvent;
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.mInitBean;
        if (qZAlbumxAlbumDetailInitBean != null) {
            this.dataRepo.A(qZAlbumxAlbumDetailInitBean);
        }
        ub.k kVar = this.dataRepo;
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean2 = this.mInitBean;
        kVar.I(qZAlbumxAlbumDetailInitBean2 != null ? qZAlbumxAlbumDetailInitBean2.getAlbumId() : null, this.listener);
        if (!isLoadMore) {
            d3(false);
            this.curTimeline = null;
        }
        boolean z16 = this.isTimeLine;
        if (z16 && (commonStTimeLineEvent = this.curTimeline) != null) {
            this.dataRepo.U(z16, commonStTimeLineEvent);
            ub.k kVar2 = this.dataRepo;
            CommonStTimeLineEvent commonStTimeLineEvent2 = this.curTimeline;
            Intrinsics.checkNotNull(commonStTimeLineEvent2);
            kVar2.O(2, commonStTimeLineEvent2);
            return;
        }
        this.dataRepo.U(z16, this.curTimeline);
        this.dataRepo.L(isLoadMore, this.sortType);
        e3(isLoadMore);
    }

    public final void b3(QZAlbumxAlbumDetailInitBean initBean) {
        Intrinsics.checkNotNullParameter(initBean, "initBean");
        this.mInitBean = initBean;
        if (this.sortType == null) {
            this.sortType = initBean != null ? initBean.getSortType() : null;
        }
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b
    public void c2() {
        ub.k kVar = this.dataRepo;
        QZAlbumxAlbumDetailInitBean qZAlbumxAlbumDetailInitBean = this.mInitBean;
        kVar.J(qZAlbumxAlbumDetailInitBean != null ? qZAlbumxAlbumDetailInitBean.getAlbumId() : null);
    }

    public final void c3(Integer num) {
        this.sortType = num;
    }

    public final void d3(boolean z16) {
        this.isTimeLine = z16;
        this.isTimeLineObservable.postValue(Boolean.valueOf(z16));
    }

    @Override // com.qzone.reborn.albumx.common.viewmodel.b, com.tencent.biz.richframework.part.BaseViewModel
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZAlbumxAlbumDetailViewModel";
    }

    public final xa.a r2(CommonAlbumInfo albumInfo, ArrayList<Integer> rightList) {
        Intrinsics.checkNotNullParameter(albumInfo, "albumInfo");
        xa.a aVar = new xa.a(com.qzone.reborn.albumx.qzonex.utils.c.f53402a.c(Integer.valueOf(albumInfo.getQzAlbumType())));
        aVar.m(albumInfo.getAlbumId());
        aVar.n(albumInfo.getName());
        aVar.o(albumInfo.getCreator().getUin());
        aVar.r(albumInfo.getShareAlbum());
        aVar.q(albumInfo.getCooperation.qqcircle.report.datong.QCircleDaTongConstant.ElementParamValue.PERMISSION java.lang.String());
        aVar.s(albumInfo.getCreator().getUin());
        for (CommonClientAttr commonClientAttr : albumInfo.getShareAlbum().e()) {
            xa.d dVar = new xa.d();
            dVar.b(commonClientAttr.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getNick());
            dVar.d(commonClientAttr.getCooperation.qqcircle.report.QCircleAlphaUserReporter.KEY_USER java.lang.String().getUin());
            dVar.c(com.qzone.reborn.albumx.qzonex.utils.b.f53400a.c(commonClientAttr.getAttr().getFamilyRole()));
            aVar.j().add(dVar);
        }
        if (rightList != null) {
            Iterator<T> it = rightList.iterator();
            while (it.hasNext()) {
                aVar.g().add(Integer.valueOf(((Number) it.next()).intValue()));
            }
        }
        aVar.p(this.mediaLbsAreaList);
        UIStateData<List<com.qzone.reborn.albumx.common.bean.a>> value = O1().getValue();
        boolean z16 = false;
        if (value != null && value.getState() == 0) {
            z16 = true;
        }
        aVar.l(z16);
        QLog.i(getTAG(), 2, "albumid:" + albumInfo.getAlbumId() + " | member size:" + albumInfo.getShareAlbum().e().size() + "| rightList:" + (rightList != null ? CollectionsKt___CollectionsKt.joinToString$default(rightList, ", ", "[", "]", 0, null, null, 56, null) : null));
        return aVar;
    }

    public final void s2(ArrayList<CommonStMedia> mediaList, long selectTime, final Consumer<Boolean> consumer) {
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        PAEditBatchMediaReq pAEditBatchMediaReq = new PAEditBatchMediaReq();
        CommonAlbumInfo value = M1().getValue();
        pAEditBatchMediaReq.albumId = value != null ? value.getAlbumId() : null;
        for (CommonStMedia commonStMedia : mediaList) {
            ArrayList<EditPhoto> arrayList = pAEditBatchMediaReq.editPhotoList;
            EditPhoto editPhoto = new EditPhoto();
            editPhoto.shootTime = selectTime / 1000;
            editPhoto.picId = commonStMedia.k();
            editPhoto.lbs = xh.g.b(commonStMedia.getLbs());
            arrayList.add(editPhoto);
        }
        pAEditBatchMediaReq.operations.add(Integer.valueOf(EditPhotoOperaType.KEDITPHOTOOPERATYPESHOOTTIME.ordinal()));
        final long currentTimeMillis = System.currentTimeMillis();
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.editBatchMedia(pAEditBatchMediaReq, new IPersonalAlbumServiceEditBatchMediaCallback() { // from class: nc.x
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditBatchMediaCallback
                public final void onEditBatchMedia(PAEditBatchMediaRsp pAEditBatchMediaRsp) {
                    y.t2(currentTimeMillis, this, consumer, pAEditBatchMediaRsp);
                }
            });
        }
    }

    public final void w2(String albumId, int sortType) {
        this.dataRepo.j(albumId, sortType, new a(sortType));
    }

    public final MutableLiveData<CommonStTimeLineEvent> x2() {
        return this.curBatchTimeLineEventData;
    }

    public final MutableLiveData<xa.b> y2() {
        return this.curHeadCeilingBean;
    }

    /* renamed from: z2, reason: from getter */
    public final CommonStTimeLineEvent getCurTimeline() {
        return this.curTimeline;
    }

    private final void f3(boolean isBatchEdit, ArrayList<CommonStMedia> mediaList, CommonStLBS lbs) {
        if (isBatchEdit) {
            this.dataRepo.X(mediaList, lbs);
        } else {
            b2(false);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void u2(final ArrayList<CommonStMedia> mediaList, CommonMediaLbsAreaList mediaLbsAreaList, final MediaLbsArea lbs, boolean newLbs, ArrayList<CommonStMedia> allMediaList, final boolean isBatchEdit, final Consumer<Boolean> consumer) {
        Object obj;
        CommonMediaLbsArea commonMediaLbsArea;
        CommonMediaLbsArea commonMediaLbsArea2;
        ArrayList<CommonMediaLbsArea> a16;
        Object orNull;
        ArrayList arrayList;
        ArrayList<CommonMediaLbsArea> a17;
        Object obj2;
        Intrinsics.checkNotNullParameter(mediaList, "mediaList");
        Intrinsics.checkNotNullParameter(lbs, "lbs");
        Intrinsics.checkNotNullParameter(allMediaList, "allMediaList");
        Intrinsics.checkNotNullParameter(consumer, "consumer");
        PAEditTravelAlbumScenceReq pAEditTravelAlbumScenceReq = new PAEditTravelAlbumScenceReq();
        CommonAlbumInfo it = M1().getValue();
        if (it != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            pAEditTravelAlbumScenceReq.album = xh.a.b(it);
        }
        HashMap hashMap = new HashMap();
        for (CommonStMedia commonStMedia : mediaList) {
            if (mediaLbsAreaList != null && (a17 = mediaLbsAreaList.a()) != null) {
                Iterator<T> it5 = a17.iterator();
                while (true) {
                    if (!it5.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it5.next();
                    CommonMediaLbsArea commonMediaLbsArea3 = (CommonMediaLbsArea) obj2;
                    if (commonStMedia.getShootTime() <= commonMediaLbsArea3.getEndShootTime() && commonStMedia.getShootTime() >= commonMediaLbsArea3.getStartShootTime()) {
                        break;
                    }
                }
                commonMediaLbsArea2 = (CommonMediaLbsArea) obj2;
                if (commonMediaLbsArea2 != null) {
                    arrayList = (ArrayList) hashMap.get(commonMediaLbsArea2);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        hashMap.put(commonMediaLbsArea2, arrayList);
                    }
                    arrayList.add(commonStMedia);
                }
            }
            if (mediaLbsAreaList == null || (a16 = mediaLbsAreaList.a()) == null) {
                commonMediaLbsArea = null;
            } else {
                orNull = CollectionsKt___CollectionsKt.getOrNull(a16, 0);
                commonMediaLbsArea = (CommonMediaLbsArea) orNull;
            }
            if (commonMediaLbsArea != null) {
                commonMediaLbsArea2 = commonMediaLbsArea;
                arrayList = (ArrayList) hashMap.get(commonMediaLbsArea2);
                if (arrayList == null) {
                }
                arrayList.add(commonStMedia);
            }
        }
        if (newLbs) {
            Set entrySet = hashMap.entrySet();
            Intrinsics.checkNotNullExpressionValue(entrySet, "map.entries");
            Iterator it6 = entrySet.iterator();
            while (it6.hasNext()) {
                Map.Entry entry = (Map.Entry) it6.next();
                Object key = entry.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "entry.key");
                CommonMediaLbsArea commonMediaLbsArea4 = (CommonMediaLbsArea) key;
                long startShootTime = (commonMediaLbsArea4.getStartShootTime() + commonMediaLbsArea4.getEndShootTime()) / 2;
                ArrayList<EditTravelAlbumScence> arrayList2 = pAEditTravelAlbumScenceReq.scences;
                EditTravelAlbumScence editTravelAlbumScence = new EditTravelAlbumScence();
                MediaLbsArea mediaLbsArea = new MediaLbsArea();
                editTravelAlbumScence.lbsArea = mediaLbsArea;
                mediaLbsArea.lbsInfo = xh.g.b(commonMediaLbsArea4.getLbsInfo());
                editTravelAlbumScence.lbsArea.lbsPhotoNum = commonMediaLbsArea4.getLbsPhotoNum() - ((ArrayList) entry.getValue()).size();
                editTravelAlbumScence.lbsArea.photoNum = commonMediaLbsArea4.getPhotoNum() - ((ArrayList) entry.getValue()).size();
                editTravelAlbumScence.lbsArea.desc = commonMediaLbsArea4.getDesc();
                editTravelAlbumScence.lbsArea.userConfirmed = commonMediaLbsArea4.getUserConfirmed();
                editTravelAlbumScence.lbsArea.sceneryName = commonMediaLbsArea4.getLbsInfo().getLocation();
                editTravelAlbumScence.lbsArea.startShootTime = commonMediaLbsArea4.getStartShootTime();
                Iterator it7 = it6;
                editTravelAlbumScence.lbsArea.endShootTime = startShootTime - 1;
                editTravelAlbumScence.lbsAreaStartTime = commonMediaLbsArea4.getStartShootTime();
                editTravelAlbumScence.operation = EditTravelAlbumScenceOperationType.KEDITTRAVELALBUMSCENCEOPERATIONTYPEMOD.ordinal();
                arrayList2.add(editTravelAlbumScence);
                ArrayList<EditTravelAlbumScence> arrayList3 = pAEditTravelAlbumScenceReq.scences;
                EditTravelAlbumScence editTravelAlbumScence2 = new EditTravelAlbumScence();
                MediaLbsArea mediaLbsArea2 = new MediaLbsArea();
                editTravelAlbumScence2.lbsArea = mediaLbsArea2;
                mediaLbsArea2.lbsInfo = lbs.lbsInfo;
                mediaLbsArea2.lbsPhotoNum = ((ArrayList) entry.getValue()).size();
                editTravelAlbumScence2.lbsArea.photoNum = ((ArrayList) entry.getValue()).size();
                MediaLbsArea mediaLbsArea3 = editTravelAlbumScence2.lbsArea;
                mediaLbsArea3.desc = lbs.desc;
                mediaLbsArea3.userConfirmed = lbs.userConfirmed;
                mediaLbsArea3.sceneryName = lbs.lbsInfo.location;
                mediaLbsArea3.startShootTime = startShootTime;
                mediaLbsArea3.endShootTime = commonMediaLbsArea4.getEndShootTime();
                editTravelAlbumScence2.lbsAreaStartTime = startShootTime;
                editTravelAlbumScence2.operation = EditTravelAlbumScenceOperationType.KEDITTRAVELALBUMSCENCEOPERATIONTYPEADD.ordinal();
                arrayList3.add(editTravelAlbumScence2);
                ArrayList<CommonStMedia> arrayList4 = new ArrayList();
                for (Object obj3 : allMediaList) {
                    CommonStMedia commonStMedia2 = (CommonStMedia) obj3;
                    if (commonStMedia2.getShootTime() <= commonMediaLbsArea4.getEndShootTime() && commonStMedia2.getShootTime() >= commonMediaLbsArea4.getStartShootTime()) {
                        arrayList4.add(obj3);
                    }
                }
                for (CommonStMedia commonStMedia3 : arrayList4) {
                    ArrayList<EditPhoto> arrayList5 = pAEditTravelAlbumScenceReq.photos;
                    EditPhoto editPhoto = new EditPhoto();
                    editPhoto.picId = commonStMedia3.k();
                    Object value = entry.getValue();
                    Intrinsics.checkNotNullExpressionValue(value, "entry.value");
                    Iterator it8 = ((Iterable) value).iterator();
                    while (true) {
                        if (it8.hasNext()) {
                            obj = it8.next();
                            if (Intrinsics.areEqual(commonStMedia3.k(), ((CommonStMedia) obj).k())) {
                                break;
                            }
                        } else {
                            obj = null;
                            break;
                        }
                    }
                    editPhoto.shootTime = obj == null ? commonMediaLbsArea4.getStartShootTime() + 1 : startShootTime + 1;
                    editPhoto.lbs = lbs.lbsInfo;
                    arrayList5.add(editPhoto);
                }
                it6 = it7;
            }
        } else {
            for (CommonStMedia commonStMedia4 : mediaList) {
                ArrayList<EditPhoto> arrayList6 = pAEditTravelAlbumScenceReq.photos;
                EditPhoto editPhoto2 = new EditPhoto();
                editPhoto2.picId = commonStMedia4.k();
                editPhoto2.shootTime = lbs.startShootTime + 1;
                editPhoto2.lbs = lbs.lbsInfo;
                arrayList6.add(editPhoto2);
            }
            ArrayList<EditTravelAlbumScence> arrayList7 = pAEditTravelAlbumScenceReq.scences;
            EditTravelAlbumScence editTravelAlbumScence3 = new EditTravelAlbumScence();
            MediaLbsArea mediaLbsArea4 = new MediaLbsArea();
            editTravelAlbumScence3.lbsArea = mediaLbsArea4;
            mediaLbsArea4.lbsInfo = lbs.lbsInfo;
            mediaLbsArea4.lbsPhotoNum = lbs.lbsPhotoNum + mediaList.size();
            editTravelAlbumScence3.lbsArea.photoNum = lbs.photoNum + mediaList.size();
            MediaLbsArea mediaLbsArea5 = editTravelAlbumScence3.lbsArea;
            mediaLbsArea5.desc = lbs.desc;
            mediaLbsArea5.userConfirmed = lbs.userConfirmed;
            mediaLbsArea5.sceneryName = lbs.lbsInfo.location;
            mediaLbsArea5.startShootTime = lbs.startShootTime;
            mediaLbsArea5.endShootTime = lbs.endShootTime;
            arrayList7.add(editTravelAlbumScence3);
        }
        com.tencent.qqnt.kernel.api.z b16 = com.qzone.reborn.albumx.qzonex.utils.i.b();
        if (b16 != null) {
            b16.editTravelAlbumScence(pAEditTravelAlbumScenceReq, new IPersonalAlbumServiceEditTravelAlbumScenceCallback() { // from class: nc.v
                @Override // com.tencent.qqnt.kernel.nativeinterface.IPersonalAlbumServiceEditTravelAlbumScenceCallback
                public final void onEditTravelAlbumScence(PAEditTravelAlbumScenceRsp pAEditTravelAlbumScenceRsp) {
                    y.v2(y.this, isBatchEdit, mediaList, lbs, consumer, pAEditTravelAlbumScenceRsp);
                }
            });
        }
    }
}
