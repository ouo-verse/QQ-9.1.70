package com.tencent.ecommerce.biz.consumer.model;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import cg0.a;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.base.offline.api.IECOfflineManager;
import com.tencent.ecommerce.biz.consumer.ECContentInfo;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.ECGoodsDataManager;
import com.tencent.ecommerce.biz.consumer.ECGoodsReportManager;
import com.tencent.ecommerce.biz.consumer.report.ECWrapperViewDisappearReportHelper;
import com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel;
import com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView;
import com.tencent.ecommerce.biz.consumer.view.IECPrivatePolicyView;
import com.tencent.ecommerce.biz.util.ECThreadUtilKt;
import com.tencent.ecommerce.repo.consumer.resp.Advertisement;
import com.tencent.ecommerce.repo.consumer.resp.BasicInfo;
import com.tencent.ecommerce.repo.consumer.resp.ExtendInfo;
import com.tencent.ecommerce.repo.consumer.resp.JumpInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayInfo;
import com.tencent.ecommerce.repo.consumer.resp.PlayUI;
import com.tencent.ecommerce.repo.consumer.resp.UIInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentSkipListMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\u00af\u0001\u001a\u00030\u00ad\u0001\u0012\b\u0010\u00b3\u0001\u001a\u00030\u00b0\u0001\u00a2\u0006\u0006\b\u00b4\u0001\u0010\u00b5\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0016\u0010\n\u001a\u00020\u00042\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\f\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\u0004H\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0002J\u001e\u0010\u0012\u001a\u00020\u00042\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0010H\u0002J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u0018\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0013H\u0002J\u001a\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\u0010\u0010!\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0016J\u0010\u0010&\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010(\u001a\u00020'2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\b\u0010*\u001a\u00020\u0004H\u0004J\u0010\u0010+\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\u0010\u0010,\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\u0010\u0010/\u001a\u00020'2\u0006\u0010.\u001a\u00020-H\u0004J\u0010\u00100\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0004J\b\u00101\u001a\u00020\u001fH\u0004J\u0010\u00103\u001a\u00020\u00042\u0006\u00102\u001a\u00020\u001fH\u0004J\n\u00104\u001a\u0004\u0018\u00010\u0019H\u0004J\n\u00105\u001a\u0004\u0018\u00010\u0019H\u0004J\n\u00106\u001a\u0004\u0018\u00010\u0019H\u0004J\b\u00107\u001a\u00020\u001fH\u0004J\b\u00108\u001a\u00020\u001fH\u0004J\u0010\u00109\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010:\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010=\u001a\u00020\u00042\u0006\u0010<\u001a\u00020;H\u0004J\u001c\u0010@\u001a\u00020\u00042\u0012\u0010?\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040>H\u0016J\b\u0010A\u001a\u00020\u0013H&J\b\u0010B\u001a\u00020\u0004H&J\u0010\u0010D\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\bH&J\b\u0010E\u001a\u00020\u0004H&R\u001a\u0010J\u001a\u00020\u000e8\u0004X\u0084D\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010M\u001a\u00020\u000e8\u0004X\u0084\u0004\u00a2\u0006\f\n\u0004\bK\u0010G\u001a\u0004\bL\u0010IR\u001a\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010TR$\u0010<\u001a\u0004\u0018\u00010;8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bV\u0010W\u001a\u0004\bX\u0010Y\"\u0004\bZ\u0010[R\u0016\u0010^\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R$\u0010C\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010`\u001a\u0004\ba\u0010b\"\u0004\bc\u0010dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010n\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010lR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bo\u0010lR$\u0010w\u001a\u0004\u0018\u00010p8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\bq\u0010r\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u0016\u0010y\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bx\u0010BR\u0016\u0010z\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010BR\"\u0010}\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130{8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010|R.\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0~8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b:\u0010\u0080\u0001\u001a\u0006\b\u0081\u0001\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R.\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u007f0\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b)\u0010\u0086\u0001\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u0006\b\u0089\u0001\u0010\u008a\u0001R5\u0010\u0092\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u007f0\u008c\u00018\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b0\u0010\u008d\u0001\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R'\u0010\u0097\u0001\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0004\b+\u0010s\u001a\u0006\b\u0093\u0001\u0010\u0094\u0001\"\u0006\b\u0095\u0001\u0010\u0096\u0001R*\u0010\u009d\u0001\u001a\u0004\u0018\u00010\u007f8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\b\n\u0010\u0098\u0001\u001a\u0006\b\u0099\u0001\u0010\u009a\u0001\"\u0006\b\u009b\u0001\u0010\u009c\u0001R'\u0010\u00a0\u0001\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0004\ba\u0010s\u001a\u0006\b\u009e\u0001\u0010\u0094\u0001\"\u0006\b\u009f\u0001\u0010\u0096\u0001R'\u0010\u00a3\u0001\u001a\u00020\u00138\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0016\n\u0004\b5\u0010s\u001a\u0006\b\u00a1\u0001\u0010\u0094\u0001\"\u0006\b\u00a2\u0001\u0010\u0096\u0001R6\u0010\u00a9\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u0004\u0018\u00010>8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0017\n\u0005\bA\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001\"\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ab\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00aa\u0001\u0010BR\u0018\u0010\u00ac\u0001\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0099\u0001\u0010BR\u0018\u0010\u00af\u0001\u001a\u00030\u00ad\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0006\b\u00a1\u0001\u0010\u00ae\u0001R\u001d\u0010\u00b3\u0001\u001a\u00030\u00b0\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u009e\u0001\u0010\u00b1\u0001\u001a\u0006\b\u00aa\u0001\u0010\u00b2\u0001\u00a8\u0006\u00b6\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel;", "Lcom/tencent/ecommerce/biz/consumer/ui/api/IECGoodsViewModel;", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "goodCardView", "", DomainData.DOMAIN_NAME, "V", "", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "ads", "t", "P", "h0", "i0", "", "J", "", "ext", "a0", "", "uiType", "clickArea", "X", "Lcom/tencent/ecommerce/biz/consumer/report/b;", "l0", "Landroid/view/ViewGroup;", "wrapperView", "bigWrapperView", "setWrapperView", "viewGroup", "setTopWrapperView", "", "isContinuation", "onWrapperViewAppear", "onWrapperViewDisappear", "Llh0/a;", "event", "sendEvent", "Y", "Lcom/tencent/ecommerce/repo/consumer/resp/UIInfo;", "uiInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "o", ReportConstant.COSTREPORT_PREFIX, "D", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayUI;", "playUI", "M", "r", BdhLogUtil.LogTag.Tag_Req, "isShowing", "j0", "O", "v", "L", ExifInterface.LATITUDE_SOUTH, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "W", "p", "Lorg/json/JSONObject;", CacheTable.TABLE_NAME, "b0", "Lkotlin/Function1;", "listener", "addJumpLisenter", "w", "Z", "advertisement", "U", "T", "a", "Ljava/lang/String;", "K", "()Ljava/lang/String;", "TAG", "b", "G", "PRE_LOG", "Landroid/util/SparseArray;", "c", "Landroid/util/SparseArray;", "preloadTypeViewMap", "Lcom/tencent/ecommerce/biz/consumer/report/ECWrapperViewDisappearReportHelper$CardState;", "d", "Lcom/tencent/ecommerce/biz/consumer/report/ECWrapperViewDisappearReportHelper$CardState;", "cardState", "e", "Lorg/json/JSONObject;", "getReportInfo", "()Lorg/json/JSONObject;", "setReportInfo", "(Lorg/json/JSONObject;)V", "f", "Lcom/tencent/ecommerce/biz/consumer/report/b;", "clickReportParams", "g", "Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "u", "()Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;", "setAdvertisement", "(Lcom/tencent/ecommerce/repo/consumer/resp/Advertisement;)V", h.F, "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", BdhLogUtil.LogTag.Tag_Conn, "()Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;", "setGoodCardView", "(Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView;)V", "i", "Landroid/view/ViewGroup;", "j", "topWrapperView", "k", "Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;", "l", "Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;", "I", "()Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;", "g0", "(Lcom/tencent/ecommerce/biz/consumer/view/IECPrivatePolicyView;)V", "privatePolicyView", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "isUIShowing", "isWrapperViewVisible", "", "Ljava/util/Map;", "convertCardUIMap", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "Ljava/util/ArrayList;", "B", "()Ljava/util/ArrayList;", "setDurationRelyPlayInfoList", "(Ljava/util/ArrayList;)V", "durationRelyPlayInfoList", "Ljava/util/List;", "N", "()Ljava/util/List;", "k0", "(Ljava/util/List;)V", "videoPlayInfoList", "Ljava/util/concurrent/ConcurrentSkipListMap;", "Ljava/util/concurrent/ConcurrentSkipListMap;", "H", "()Ljava/util/concurrent/ConcurrentSkipListMap;", "setPlayPositionInfoMap", "(Ljava/util/concurrent/ConcurrentSkipListMap;)V", "playPositionInfoMap", UserInfo.SEX_FEMALE, "()I", "f0", "(I)V", "maxViewPlayPos", "Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "y", "()Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;", "c0", "(Lcom/tencent/ecommerce/repo/consumer/resp/PlayInfo;)V", "currentPlayInfo", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "e0", "duration", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "d0", InnerAudioPlugin.AUDIO_PROPERTY_CURRENTTIME, "Lkotlin/jvm/functions/Function1;", "E", "()Lkotlin/jvm/functions/Function1;", "setJumpListener", "(Lkotlin/jvm/functions/Function1;)V", "jumpListener", HippyTKDListViewAdapter.X, "firstAppear", "firstDisAppear", "Landroid/content/Context;", "Landroid/content/Context;", "context", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "()Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;", "contentInfo", "<init>", "(Landroid/content/Context;Lcom/tencent/ecommerce/biz/consumer/ECContentInfo;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public abstract class ECGoodsBaseViewModel implements IECGoodsViewModel {

    /* renamed from: A, reason: from kotlin metadata */
    private final ECContentInfo contentInfo;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String PRE_LOG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private JSONObject reportInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private Advertisement advertisement;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private IECGoodsCardView goodCardView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private ViewGroup wrapperView;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private ViewGroup topWrapperView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private ViewGroup bigWrapperView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private IECPrivatePolicyView privatePolicyView;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isUIShowing;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private boolean isWrapperViewVisible;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private List<PlayInfo> videoPlayInfoList;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private ConcurrentSkipListMap<Integer, PlayInfo> playPositionInfoMap;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private int maxViewPlayPos;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private PlayInfo currentPlayInfo;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    private int duration;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private int currentTime;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private Function1<? super String, Unit> jumpListener;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    private boolean firstAppear;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    private boolean firstDisAppear;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final Context context;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String TAG = "ECGoodsBaseViewModel";

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<IECGoodsCardView> preloadTypeViewMap = new SparseArray<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private ECWrapperViewDisappearReportHelper.CardState cardState = ECWrapperViewDisappearReportHelper.CardState.UNKNOW;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private com.tencent.ecommerce.biz.consumer.report.b clickReportParams = new com.tencent.ecommerce.biz.consumer.report.b();

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private Map<Integer, Integer> convertCardUIMap = new LinkedHashMap();

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private ArrayList<PlayInfo> durationRelyPlayInfoList = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "closeView", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel$createGoodCardViewByUIType$1$2"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101626e;

        b(int i3) {
            this.f101626e = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            int i3;
            Map<String, String> emptyMap;
            ExtendInfo ext;
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag(R.id.o5t) instanceof Integer) {
                ECGoodsBaseViewModel eCGoodsBaseViewModel = ECGoodsBaseViewModel.this;
                Object tag = view.getTag(R.id.o5t);
                if (tag != null) {
                    eCGoodsBaseViewModel.Y(((Integer) tag).intValue());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
            com.tencent.ecommerce.biz.consumer.report.a aVar = com.tencent.ecommerce.biz.consumer.report.a.f101632a;
            com.tencent.ecommerce.biz.consumer.report.b bVar = new com.tencent.ecommerce.biz.consumer.report.b();
            bVar.e(ECGoodsBaseViewModel.this.getContentInfo().getBusinessId());
            Object tag2 = view.getTag(R.id.nte);
            if (!(tag2 instanceof Integer)) {
                tag2 = null;
            }
            Integer num = (Integer) tag2;
            if (num != null) {
                i3 = num.intValue();
            } else {
                i3 = this.f101626e;
            }
            bVar.g(i3);
            bVar.c(ECGoodsBaseViewModel.this.getContentInfo().getAuthorUin());
            bVar.j(ECGoodsBaseViewModel.this.getContentInfo().getContentId());
            bVar.p(ECGoodsBaseViewModel.this.J());
            bVar.y(ECGoodsBaseViewModel.this.getCurrentTime());
            bVar.i(ECGoodsBaseViewModel.this.getCurrentTime());
            bVar.t(ECGoodsBaseViewModel.this.getContentInfo().getSealTransfer());
            bVar.x(ECGoodsBaseViewModel.this.getContentInfo().getTraceId());
            bVar.o(ECGoodsBaseViewModel.this.getContentInfo().getPageId());
            bVar.u(ECGoodsBaseViewModel.this.getContentInfo().getSourceFrom());
            bVar.h(2);
            Unit unit = Unit.INSTANCE;
            Advertisement advertisement = ECGoodsBaseViewModel.this.getAdvertisement();
            if (advertisement == null || (ext = advertisement.getExt()) == null || (emptyMap = ext.getExt()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            aVar.a(bVar, emptyMap);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n\u00a2\u0006\u0002\b\u0005\u00a8\u0006\u0006"}, d2 = {"<anonymous>", "", "closeView", "Landroid/view/View;", "kotlin.jvm.PlatformType", NodeProps.ON_CLICK, "com/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel$createGoodCardViewByUIType$1$3"}, k = 3, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f101628e;

        c(int i3) {
            this.f101628e = i3;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getTag(R.id.oc6) instanceof Integer) {
                ECGoodsBaseViewModel eCGoodsBaseViewModel = ECGoodsBaseViewModel.this;
                Object tag = view.getTag(R.id.oc6);
                if (tag != null) {
                    eCGoodsBaseViewModel.W(((Integer) tag).intValue());
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0003H\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel$d", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lmh0/a;", "Lmh0/b;", "reqModel", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "", "a", "respModel", "b", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECNetworkCallback<mh0.a, mh0.b> {
        d() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(mh0.a reqModel, ECRemoteResponse errorResponse) {
            ECGoodsBaseViewModel.this.cardState = ECWrapperViewDisappearReportHelper.CardState.REQUEST_ERROR;
            cg0.a.a(ECGoodsBaseViewModel.this.getTAG(), "loadGoodsAdData", ECGoodsBaseViewModel.this.getPRE_LOG() + "error code:" + errorResponse.getCode() + ",error msg:" + errorResponse.getMsg());
            ECGoodsBaseViewModel.this.T();
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(mh0.a reqModel, mh0.b respModel) {
            if (!respModel.b().isEmpty()) {
                ECGoodsBaseViewModel.this.t(respModel.b());
                return;
            }
            ECGoodsBaseViewModel.this.cardState = ECWrapperViewDisappearReportHelper.CardState.REQUEST_EMPTY_RESULT;
            ECGoodsBaseViewModel.this.T();
            cg0.a.a(ECGoodsBaseViewModel.this.getTAG(), "loadGoodsAdData", ECGoodsBaseViewModel.this.getPRE_LOG() + "empty ads");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel$e", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lmh0/c;", "Lmh0/d;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECNetworkCallback<mh0.c, mh0.d> {
        e() {
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(mh0.c reqModel, ECRemoteResponse errorResponse) {
            cg0.a.a(ECGoodsBaseViewModel.this.getTAG(), "report", ECGoodsBaseViewModel.this.getPRE_LOG() + "report success, code:" + errorResponse.getCode() + ", msg:" + errorResponse.getMsg() + ", data:" + errorResponse.getData());
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(mh0.c reqModel, mh0.d respModel) {
            cg0.a.b(ECGoodsBaseViewModel.this.getTAG(), ECGoodsBaseViewModel.this.getPRE_LOG() + "report success, code:" + respModel.getCode());
        }
    }

    public ECGoodsBaseViewModel(Context context, ECContentInfo eCContentInfo) {
        List<PlayInfo> emptyList;
        this.context = context;
        this.contentInfo = eCContentInfo;
        this.PRE_LOG = "[hashCode:" + hashCode() + ",contentScene:" + eCContentInfo.getContentScene() + ",contentId:" + eCContentInfo.getContentId() + "],";
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.videoPlayInfoList = emptyList;
        this.playPositionInfoMap = new ConcurrentSkipListMap<>();
        this.maxViewPlayPos = -1;
        this.firstAppear = true;
        this.firstDisAppear = true;
        P();
        V();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String J() {
        BasicInfo basic;
        String adId;
        Advertisement advertisement = this.advertisement;
        return (advertisement == null || (basic = advertisement.getBasic()) == null || (adId = basic.getAdId()) == null) ? "" : adId;
    }

    private final void P() {
        this.convertCardUIMap.put(500, 500);
        this.convertCardUIMap.put(600, 500);
        this.convertCardUIMap.put(10300, 500);
        this.convertCardUIMap.put(10301, 500);
        this.convertCardUIMap.put(10302, 500);
        this.convertCardUIMap.put(Integer.valueOf(PlayUI.UIType.WEAKEN_SMALL_CARD_NG), 10000);
        this.convertCardUIMap.put(Integer.valueOf(PlayUI.UIType.WEAKEN_MEDIUM_CARD_NG), 10000);
        this.convertCardUIMap.put(10500, 10000);
        this.convertCardUIMap.put(10501, 10000);
        this.convertCardUIMap.put(10000, 10000);
        this.convertCardUIMap.put(10100, 10000);
        this.convertCardUIMap.put(10200, 10000);
        this.convertCardUIMap.put(10201, 10000);
        this.convertCardUIMap.put(10600, 10000);
        this.convertCardUIMap.put(420, 420);
        this.convertCardUIMap.put(421, 420);
        this.convertCardUIMap.put(422, 420);
        this.convertCardUIMap.put(423, 420);
        this.convertCardUIMap.put(424, 420);
        this.convertCardUIMap.put(425, 420);
        this.convertCardUIMap.put(Integer.valueOf(PlayUI.UIType.BIG_CARD_SHAPED_PIC), 420);
    }

    private final void V() {
        this.cardState = ECWrapperViewDisappearReportHelper.CardState.REQUESTING;
        ECGoodsDataManager.INSTANCE.a().b(UUID.randomUUID().toString(), this.contentInfo, new d());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X(int uiType, int clickArea) {
        Map<String, String> emptyMap;
        ExtendInfo ext;
        JSONObject jSONObject = this.reportInfo;
        if (jSONObject != null) {
            jSONObject.put("event", 4);
            jSONObject.put("ui_type", uiType);
            b0(jSONObject);
        }
        IECGoodsCardView iECGoodsCardView = this.goodCardView;
        if (iECGoodsCardView != null) {
            com.tencent.ecommerce.biz.consumer.report.b l06 = l0(uiType, clickArea);
            Advertisement advertisement = this.advertisement;
            if (advertisement == null || (ext = advertisement.getExt()) == null || (emptyMap = ext.getExt()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            iECGoodsCardView.onClickReport(l06, emptyMap);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0() {
        if (this.cardState != ECWrapperViewDisappearReportHelper.CardState.REQUEST_SHOWING) {
            this.cardState = ECWrapperViewDisappearReportHelper.CardState.REQUEST_OK_TOSHOW;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final com.tencent.ecommerce.biz.consumer.report.b l0(int uiType, int clickArea) {
        com.tencent.ecommerce.biz.consumer.report.b bVar = this.clickReportParams;
        bVar.e(this.contentInfo.getBusinessId());
        bVar.g(uiType);
        bVar.c(this.contentInfo.getAuthorUin());
        bVar.j(this.contentInfo.getContentId());
        bVar.p(J());
        bVar.y(this.currentTime);
        bVar.t(this.contentInfo.getSealTransfer());
        bVar.x(this.contentInfo.getTraceId());
        bVar.o(this.contentInfo.getPageId());
        bVar.u(this.contentInfo.getSourceFrom());
        bVar.h(clickArea);
        return this.clickReportParams;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n(IECGoodsCardView goodCardView) {
        ViewGroup bigWrapperView;
        View bigView = goodCardView.getBigView();
        if (bigView == null || (bigWrapperView = getBigWrapperView()) == null) {
            return;
        }
        ViewParent parent = bigView.getParent();
        if (Intrinsics.areEqual(bigWrapperView, parent)) {
            return;
        }
        bigWrapperView.removeAllViews();
        if (parent != null) {
            ((ViewGroup) parent).removeView(bigView);
        }
        bigView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        ViewGroup.LayoutParams layoutParams = bigView.getLayoutParams();
        if (layoutParams != null) {
            ((FrameLayout.LayoutParams) layoutParams).gravity = 80;
            bigWrapperView.addView(bigView);
            cg0.a.b(this.TAG, this.PRE_LOG + "addBigCardToWrapperViewIfNeed");
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(List<Advertisement> ads) {
        cg0.a.b(this.TAG, this.PRE_LOG + "loadAdData onSuccess before");
        try {
            Advertisement advertisement = ads.get(0);
            this.advertisement = advertisement;
            if (advertisement != null) {
                i0();
                if (advertisement.getReport() != null) {
                    this.reportInfo = new JSONObject(advertisement.getReport());
                }
                U(advertisement);
                cg0.a.b(this.TAG, this.PRE_LOG + "loadAdData onSuccess end");
            }
        } catch (Exception e16) {
            cg0.a.a(this.TAG, "loadGoodsAdData onSuccess", this.PRE_LOG + "error e:" + e16.getLocalizedMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: A, reason: from getter */
    public final int getDuration() {
        return this.duration;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ArrayList<PlayInfo> B() {
        return this.durationRelyPlayInfoList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: C, reason: from getter */
    public final IECGoodsCardView getGoodCardView() {
        return this.goodCardView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IECGoodsCardView D(int uiType) {
        IECGoodsCardView iECGoodsCardView = this.goodCardView;
        if (iECGoodsCardView == null) {
            return s(r(uiType));
        }
        if (iECGoodsCardView != null) {
            return iECGoodsCardView;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView");
    }

    protected final Function1<String, Unit> E() {
        return this.jumpListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: F, reason: from getter */
    public final int getMaxViewPlayPos() {
        return this.maxViewPlayPos;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: G, reason: from getter */
    public final String getPRE_LOG() {
        return this.PRE_LOG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ConcurrentSkipListMap<Integer, PlayInfo> H() {
        return this.playPositionInfoMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: I, reason: from getter */
    public final IECPrivatePolicyView getPrivatePolicyView() {
        return this.privatePolicyView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K, reason: from getter */
    public final String getTAG() {
        return this.TAG;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: L, reason: from getter */
    public final ViewGroup getTopWrapperView() {
        return this.topWrapperView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final UIInfo M(PlayUI playUI) {
        int uiType = playUI.getUiType();
        if (uiType == 300) {
            return playUI.getSmallCardGameUIInfo();
        }
        if (uiType == 301) {
            return playUI.getSmallCardMiniGameUIInfo();
        }
        if (uiType == 400) {
            return playUI.getMediumCardGameUIInfo();
        }
        if (uiType == 401) {
            return playUI.getMediumCardMiniGameUIInfo();
        }
        if (uiType == 500) {
            return playUI.getSmallCardProductUIInfo();
        }
        if (uiType == 600) {
            return playUI.getMediumCardProductUIInfo();
        }
        if (uiType == 10000) {
            return playUI.getSmallCardProductUIInfo();
        }
        if (uiType == 10100) {
            return playUI.getMediumCardProductUIInfo();
        }
        if (uiType != 10200 && uiType != 10201) {
            if (uiType != 10400) {
                if (uiType == 10401) {
                    return playUI.getMediumCardWeakenUIInfo();
                }
                if (uiType != 10500) {
                    if (uiType != 10501) {
                        switch (uiType) {
                            case 420:
                                return playUI.getSmallCardGameUIInfo();
                            case 421:
                                return playUI.getMediumCardGameUIInfo();
                            case 422:
                                return playUI.getBigCardGamePromotion();
                            case 423:
                                return playUI.getBigCardGamePromotion();
                            case 424:
                                return playUI.getBigCardGamePromotion();
                            case 425:
                            case PlayUI.UIType.BIG_CARD_SHAPED_PIC /* 426 */:
                                return playUI.getBigCardGamePromotion();
                            default:
                                switch (uiType) {
                                    case 10300:
                                        return playUI.getSamllCardActivityUIInfo();
                                    case 10301:
                                        return playUI.getMediumCardActivityUIInfo();
                                    case 10302:
                                        return playUI.getBigCardActivityUIInfo();
                                    default:
                                        switch (uiType) {
                                            case 10600:
                                                return playUI.getMediumFilmCardProductUIInfo();
                                            case PlayUI.UIType.TOP_VIEW /* 10601 */:
                                                return playUI.getTopViewUIInfo();
                                            case PlayUI.UIType.BOTTOM_FLOATING_CARD /* 10602 */:
                                                return playUI.getBottomFloatingCardUIInfo();
                                            default:
                                                return playUI.getSmallCardProductUIInfo();
                                        }
                                }
                        }
                    }
                    return playUI.getMediumCardGradientUIInfo();
                }
            }
            return playUI.getSamllCardGradientUIInfo();
        }
        return playUI.getBigCardProductUIInfo();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final List<PlayInfo> N() {
        return this.videoPlayInfoList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: O, reason: from getter */
    public final ViewGroup getWrapperView() {
        return this.wrapperView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean Q() {
        ECWrapperViewDisappearReportHelper.CardState cardState = this.cardState;
        return cardState == ECWrapperViewDisappearReportHelper.CardState.REQUEST_ERROR || cardState == ECWrapperViewDisappearReportHelper.CardState.REQUEST_EMPTY_RESULT;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: R, reason: from getter */
    public final boolean getIsUIShowing() {
        return this.isUIShowing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: S, reason: from getter */
    public final boolean getIsWrapperViewVisible() {
        return this.isWrapperViewVisible;
    }

    public abstract void T();

    public abstract void U(Advertisement advertisement);

    /* JADX INFO: Access modifiers changed from: protected */
    public void W(int uiType) {
        JSONObject jSONObject = this.reportInfo;
        if (jSONObject != null) {
            jSONObject.put("event", 3);
            jSONObject.put("ui_type", uiType);
            b0(jSONObject);
        }
        p(uiType);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void Y(int uiType) {
        Map<String, String> emptyMap;
        ExtendInfo ext;
        IECGoodsCardView iECGoodsCardView = this.goodCardView;
        if (iECGoodsCardView != null) {
            com.tencent.ecommerce.biz.consumer.report.b bVar = new com.tencent.ecommerce.biz.consumer.report.b();
            bVar.e(this.contentInfo.getBusinessId());
            bVar.g(uiType);
            bVar.c(this.contentInfo.getAuthorUin());
            bVar.j(this.contentInfo.getContentId());
            bVar.p(J());
            bVar.y(this.currentTime);
            bVar.t(this.contentInfo.getSealTransfer());
            bVar.x(this.contentInfo.getTraceId());
            bVar.o(this.contentInfo.getPageId());
            bVar.u(this.contentInfo.getSourceFrom());
            bVar.n(com.tencent.ecommerce.biz.util.b.b(this.firstDisAppear));
            Unit unit = Unit.INSTANCE;
            Advertisement advertisement = this.advertisement;
            if (advertisement == null || (ext = advertisement.getExt()) == null || (emptyMap = ext.getExt()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            iECGoodsCardView.onWrapperViewDisappear(uiType, bVar, emptyMap);
        }
        this.firstDisAppear = false;
    }

    public abstract void Z();

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel
    public void addJumpLisenter(Function1<? super String, Unit> listener) {
        this.jumpListener = listener;
    }

    protected final void b0(JSONObject reportInfo) {
        ECGoodsReportManager.INSTANCE.a().b(UUID.randomUUID().toString(), reportInfo, new e());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c0(PlayInfo playInfo) {
        this.currentPlayInfo = playInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d0(int i3) {
        this.currentTime = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e0(int i3) {
        this.duration = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f0(int i3) {
        this.maxViewPlayPos = i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g0(IECPrivatePolicyView iECPrivatePolicyView) {
        this.privatePolicyView = iECPrivatePolicyView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void j0(boolean isShowing) {
        this.isUIShowing = isShowing;
        h0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void k0(List<PlayInfo> list) {
        this.videoPlayInfoList = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void o() {
        IECGoodsCardView D = D(w());
        ViewParent parent = D.getView().getParent();
        ViewGroup viewGroup = this.wrapperView;
        if (viewGroup == null || Intrinsics.areEqual(parent, viewGroup)) {
            return;
        }
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(D.getView());
        }
        ViewGroup viewGroup2 = this.wrapperView;
        if (viewGroup2 != null) {
            viewGroup2.removeAllViews();
        }
        ViewGroup viewGroup3 = this.wrapperView;
        if (viewGroup3 != null) {
            viewGroup3.addView(D.getView());
        }
        n(D);
        cg0.a.b(this.TAG, this.PRE_LOG + "addGoodCardViewToWrapperView");
    }

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel
    public void onWrapperViewAppear(final boolean isContinuation) {
        if (this.isWrapperViewVisible) {
            return;
        }
        cg0.a.b(this.TAG, this.PRE_LOG + "onWrapperViewAppear called isContinuation:" + isContinuation);
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel$onWrapperViewAppear$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IECGoodsCardView goodCardView;
                ECGoodsBaseViewModel.this.getContentInfo().setContinuation(isContinuation);
                ECGoodsBaseViewModel.this.isWrapperViewVisible = true;
                ECGoodsBaseViewModel.this.firstAppear = true;
                ECGoodsBaseViewModel.this.firstDisAppear = true;
                if (!ECGoodsBaseViewModel.this.getIsUIShowing() || (goodCardView = ECGoodsBaseViewModel.this.getGoodCardView()) == null) {
                    return;
                }
                ECGoodsBaseViewModel.this.W(goodCardView.getCurUIType());
            }
        });
    }

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel
    public void onWrapperViewDisappear() {
        cg0.a.b(this.TAG, this.PRE_LOG + "onWrapperViewDisappear called");
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel$onWrapperViewDisappear$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                boolean z16;
                ECWrapperViewDisappearReportHelper.CardState cardState;
                z16 = ECGoodsBaseViewModel.this.isWrapperViewVisible;
                if (z16) {
                    ECGoodsBaseViewModel.this.isWrapperViewVisible = false;
                    IECGoodsCardView goodCardView = ECGoodsBaseViewModel.this.getGoodCardView();
                    if (goodCardView != null) {
                        ECGoodsBaseViewModel.this.Y(goodCardView.getCurUIType());
                        goodCardView.resetToSmallCardIfNeed(goodCardView.getCurUIType());
                    }
                    ECWrapperViewDisappearReportHelper eCWrapperViewDisappearReportHelper = ECWrapperViewDisappearReportHelper.f101631a;
                    int businessId = ECGoodsBaseViewModel.this.getContentInfo().getBusinessId();
                    String J = ECGoodsBaseViewModel.this.J();
                    String contentId = ECGoodsBaseViewModel.this.getContentInfo().getContentId();
                    cardState = ECGoodsBaseViewModel.this.cardState;
                    eCWrapperViewDisappearReportHelper.a(businessId, J, contentId, cardState);
                    return;
                }
                a.f(ECGoodsBaseViewModel.this.getTAG(), ECGoodsBaseViewModel.this.getPRE_LOG() + "onWrapperViewDisappear return for not visible.");
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p(int uiType) {
        Map<String, String> emptyMap;
        ExtendInfo ext;
        IECGoodsCardView iECGoodsCardView = this.goodCardView;
        if (iECGoodsCardView != null) {
            com.tencent.ecommerce.biz.consumer.report.b bVar = new com.tencent.ecommerce.biz.consumer.report.b();
            bVar.e(this.contentInfo.getBusinessId());
            bVar.g(uiType);
            bVar.c(this.contentInfo.getAuthorUin());
            bVar.j(this.contentInfo.getContentId());
            bVar.p(J());
            bVar.y(this.currentTime);
            bVar.t(this.contentInfo.getSealTransfer());
            bVar.x(this.contentInfo.getTraceId());
            bVar.o(this.contentInfo.getPageId());
            bVar.u(this.contentInfo.getSourceFrom());
            bVar.n(com.tencent.ecommerce.biz.util.b.b(this.firstAppear));
            Unit unit = Unit.INSTANCE;
            Advertisement advertisement = this.advertisement;
            if (advertisement == null || (ext = advertisement.getExt()) == null || (emptyMap = ext.getExt()) == null) {
                emptyMap = MapsKt__MapsKt.emptyMap();
            }
            iECGoodsCardView.onWrapperViewAppear(bVar, emptyMap, this.contentInfo);
        }
        this.firstAppear = false;
        ECThreadUtilKt.b(3000L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel$callCardViewAppearAndPreloadDetailPage$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                BasicInfo basic;
                ExtendInfo ext2;
                ECGoodsBaseViewModel eCGoodsBaseViewModel = ECGoodsBaseViewModel.this;
                Advertisement advertisement2 = eCGoodsBaseViewModel.getAdvertisement();
                eCGoodsBaseViewModel.a0((advertisement2 == null || (ext2 = advertisement2.getExt()) == null) ? null : ext2.getExt());
                Advertisement advertisement3 = ECGoodsBaseViewModel.this.getAdvertisement();
                if (advertisement3 == null || (basic = advertisement3.getBasic()) == null || basic.getAdRecallChannel() != 6) {
                    return;
                }
                a.b(ECGoodsBaseViewModel.this.getTAG(), "start preload tencent video offline");
                IECOfflineManager offlineManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOfflineManager();
                if (offlineManager != null) {
                    offlineManager.downloadOffline("5179", new Function1<IECOfflineManager.OfflineDownloadState, Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel$callCardViewAppearAndPreloadDetailPage$2.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(IECOfflineManager.OfflineDownloadState offlineDownloadState) {
                            invoke2(offlineDownloadState);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IECOfflineManager.OfflineDownloadState offlineDownloadState) {
                            a.b(ECGoodsBaseViewModel.this.getTAG(), "preload tencent video offline state: " + offlineDownloadState);
                        }
                    });
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void q(final UIInfo uiInfo, final int uiType) {
        ECThreadUtilKt.c(new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.consumer.model.ECGoodsBaseViewModel$configCardUI$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                a.b(ECGoodsBaseViewModel.this.getTAG(), ECGoodsBaseViewModel.this.getPRE_LOG() + "configCardUI uiInfo:" + uiInfo + ",uiType:" + uiType);
                ECGoodsBaseViewModel.this.i0();
                ECGoodsBaseViewModel.this.D(uiType).configCardUI(ECGoodsBaseViewModel.this.getContentInfo(), uiInfo, uiType);
                ECGoodsBaseViewModel eCGoodsBaseViewModel = ECGoodsBaseViewModel.this;
                eCGoodsBaseViewModel.n(eCGoodsBaseViewModel.D(uiType));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final int r(int uiType) {
        Integer num;
        return (!this.convertCardUIMap.containsKey(Integer.valueOf(uiType)) || this.convertCardUIMap.get(Integer.valueOf(uiType)) == null || (num = this.convertCardUIMap.get(Integer.valueOf(uiType))) == null) ? uiType : num.intValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final IECGoodsCardView s(int uiType) {
        if (this.preloadTypeViewMap.get(uiType) == null) {
            IECGoodsCardView a16 = com.tencent.ecommerce.biz.consumer.factory.a.f101595a.a(this.context, uiType, this.videoPlayInfoList);
            this.goodCardView = a16;
            if (a16 != null) {
                a16.setGoodsCardClickListener(new a(a16, this, uiType));
                a16.setCloseClickEventListener(new b(uiType), new c(uiType));
                this.preloadTypeViewMap.put(uiType, this.goodCardView);
                String str = this.TAG;
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.PRE_LOG);
                sb5.append("createGoodCardViewByUIType  view hashcode:");
                IECGoodsCardView iECGoodsCardView = this.goodCardView;
                sb5.append(iECGoodsCardView != null ? iECGoodsCardView.hashCode() : 0);
                sb5.append(",uiType:");
                sb5.append(uiType);
                cg0.a.b(str, sb5.toString());
            }
        }
        return this.preloadTypeViewMap.get(uiType);
    }

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel
    public void setTopWrapperView(ViewGroup viewGroup) {
        this.topWrapperView = viewGroup;
    }

    @Override // com.tencent.ecommerce.biz.consumer.ui.api.IECGoodsViewModel
    public void setWrapperView(ViewGroup wrapperView, ViewGroup bigWrapperView) {
        this.wrapperView = wrapperView;
        this.bigWrapperView = bigWrapperView;
        Z();
        cg0.a.b(this.TAG, this.PRE_LOG + "setWrapperView called, viewGroup:" + wrapperView + " bigWrapperView:" + bigWrapperView);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: u, reason: from getter */
    public final Advertisement getAdvertisement() {
        return this.advertisement;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: v, reason: from getter */
    public final ViewGroup getBigWrapperView() {
        return this.bigWrapperView;
    }

    public abstract int w();

    /* renamed from: x, reason: from getter */
    public final ECContentInfo getContentInfo() {
        return this.contentInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: y, reason: from getter */
    public final PlayInfo getCurrentPlayInfo() {
        return this.currentPlayInfo;
    }

    /* renamed from: z, reason: from getter */
    protected final int getCurrentTime() {
        return this.currentTime;
    }

    private final void h0() {
        this.isUIShowing = true;
        this.cardState = ECWrapperViewDisappearReportHelper.CardState.REQUEST_SHOWING;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016\u00a8\u0006\u000b\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/consumer/model/ECGoodsBaseViewModel$createGoodCardViewByUIType$1$1", "Lcom/tencent/ecommerce/biz/consumer/view/IECGoodsCardView$IGoodsCardClickListener;", "Landroid/view/View;", "view", "", "url", "Ljava/util/ArrayList;", "Lcom/tencent/ecommerce/repo/consumer/resp/JumpInfo;", "jumpInfoList", "", NodeProps.ON_CLICK, "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECGoodsCardView.IGoodsCardClickListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IECGoodsCardView f101622a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ECGoodsBaseViewModel f101623b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f101624c;

        a(IECGoodsCardView iECGoodsCardView, ECGoodsBaseViewModel eCGoodsBaseViewModel, int i3) {
            this.f101622a = iECGoodsCardView;
            this.f101623b = eCGoodsBaseViewModel;
            this.f101624c = i3;
        }

        @Override // com.tencent.ecommerce.biz.consumer.view.IECGoodsCardView.IGoodsCardClickListener
        public void onClick(View view, String url, ArrayList<JumpInfo> jumpInfoList) {
            int i3;
            int i16;
            Map<String, String> emptyMap;
            ExtendInfo ext;
            int i17;
            Map<String, String> emptyMap2;
            ExtendInfo ext2;
            if (view.getTag(R.id.ntd) instanceof Integer) {
                Object tag = view.getTag(R.id.ntd);
                if (tag != null) {
                    i3 = ((Integer) tag).intValue();
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
                }
            } else {
                i3 = 1;
            }
            if (jumpInfoList != null && (true ^ jumpInfoList.isEmpty())) {
                ECGoodsCommonUtils eCGoodsCommonUtils = ECGoodsCommonUtils.f101579a;
                ECGoodsBaseViewModel eCGoodsBaseViewModel = this.f101623b;
                Object tag2 = view.getTag(R.id.nte);
                Integer num = (Integer) (tag2 instanceof Integer ? tag2 : null);
                if (num != null) {
                    i17 = num.intValue();
                } else {
                    i17 = this.f101624c;
                }
                com.tencent.ecommerce.biz.common.e z16 = eCGoodsBaseViewModel.l0(i17, i3).z();
                Advertisement advertisement = this.f101623b.getAdvertisement();
                if (advertisement == null || (ext2 = advertisement.getExt()) == null || (emptyMap2 = ext2.getExt()) == null) {
                    emptyMap2 = MapsKt__MapsKt.emptyMap();
                }
                eCGoodsCommonUtils.m(jumpInfoList, z16.c(emptyMap2).f(), this.f101623b.E());
            } else if (!TextUtils.isEmpty(url)) {
                ECGoodsCommonUtils eCGoodsCommonUtils2 = ECGoodsCommonUtils.f101579a;
                ECGoodsBaseViewModel eCGoodsBaseViewModel2 = this.f101623b;
                Object tag3 = view.getTag(R.id.nte);
                Integer num2 = (Integer) (tag3 instanceof Integer ? tag3 : null);
                if (num2 != null) {
                    i16 = num2.intValue();
                } else {
                    i16 = this.f101624c;
                }
                com.tencent.ecommerce.biz.common.e z17 = eCGoodsBaseViewModel2.l0(i16, i3).z();
                Advertisement advertisement2 = this.f101623b.getAdvertisement();
                if (advertisement2 == null || (ext = advertisement2.getExt()) == null || (emptyMap = ext.getExt()) == null) {
                    emptyMap = MapsKt__MapsKt.emptyMap();
                }
                eCGoodsCommonUtils2.n(url, z17.c(emptyMap).f(), this.f101623b.E());
            }
            this.f101623b.X(this.f101622a.getCurUIType(), i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(Map<String, String> ext) {
        if (ext != null) {
            String J = J();
            ext.get("seller_id");
            String str = ext.get("goods_type");
            if (str == null) {
                str = "0";
            }
            String str2 = ext.get("recall_channel");
            String str3 = str2 != null ? str2 : "0";
            if (TextUtils.isEmpty(J)) {
                cg0.a.b(this.TAG, this.PRE_LOG + "[preloadDetailPage] return by  productId null");
                return;
            }
            wh0.a.f445642d.e(J, str, str3);
            cg0.a.b(this.TAG, this.PRE_LOG + "[preloadDetailPage] productId = " + J + ", goodsType = " + str + " recallChannel = " + str3);
        }
    }

    @Override // com.tencent.ecommerce.biz.consumer.event.IECEvent
    public void sendEvent(lh0.a event) {
    }
}
