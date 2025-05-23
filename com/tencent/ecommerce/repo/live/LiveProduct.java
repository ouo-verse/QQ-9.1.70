package com.tencent.ecommerce.repo.live;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.qq.e.comm.pi.AppDownloadCallback;
import com.tencent.ark.ark;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.ecommerce.biz.live.GoodsType;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.ecommerce.biz.live.ProductStatus;
import com.tencent.ecommerce.biz.live.UIType;
import com.tencent.ecommerce.repo.live.LiveShowItem;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.tmdownloader.internal.storage.table.CacheTable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\bc\b\u0086\b\u0018\u0000 \u00072\u00020\u0001:\u00033:?B\u00bb\u0002\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0011\u001a\u00020\f\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\u0006\u0010\u0013\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0016\u001a\u00020\u0005\u0012\u0006\u0010\u0017\u001a\u00020\f\u0012\u0006\u0010\u0018\u001a\u00020\f\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001b\u001a\u00020\f\u0012\u0006\u0010\u001c\u001a\u00020\f\u0012\u0006\u0010\u001e\u001a\u00020\u001d\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010!\u001a\u00020\u0019\u0012\u0006\u0010\"\u001a\u00020\u0005\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u0012\b\b\u0002\u0010$\u001a\u00020\u0005\u0012\b\b\u0002\u0010%\u001a\u00020\u0003\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001f\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)\u0012\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+\u0012\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010-\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010/\u00a2\u0006\u0006\b\u0090\u0001\u0010\u0091\u0001J\u0013\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\u0003J\u0006\u0010\u000b\u001a\u00020\u0003J\u00dd\u0002\u00103\u001a\u00020\u00002\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0003\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\f2\b\b\u0002\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0012\u001a\u00020\f2\b\b\u0002\u0010\u0013\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0003\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\f2\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\f2\b\b\u0002\u0010\u001c\u001a\u00020\f2\b\b\u0002\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010 \u001a\u00020\u001f2\b\b\u0002\u0010!\u001a\u00020\u00192\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00032\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u00032\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+2\u0016\b\u0002\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010-2\n\b\u0002\u00100\u001a\u0004\u0018\u00010/2\n\b\u0002\u00101\u001a\u0004\u0018\u00010/2\n\b\u0002\u00102\u001a\u0004\u0018\u00010/H\u00c6\u0001J\t\u00104\u001a\u00020\fH\u00d6\u0001R\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b3\u00105\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010\u000e\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b:\u0010\n\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\"\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u00105\u001a\u0004\b@\u00107\"\u0004\bA\u00109R\"\u0010\u0010\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u00105\u001a\u0004\bC\u00107\"\u0004\bD\u00109R\"\u0010\u0011\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bE\u00105\u001a\u0004\bF\u00107\"\u0004\bG\u00109R\"\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bH\u00105\u001a\u0004\bB\u00107\"\u0004\bI\u00109R\"\u0010\u0013\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bJ\u00105\u001a\u0004\bJ\u00107\"\u0004\bK\u00109R\"\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bL\u00105\u001a\u0004\bE\u00107\"\u0004\bM\u00109R\"\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b;\u0010N\u001a\u0004\bO\u0010P\"\u0004\bQ\u0010RR\"\u0010\u0016\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bS\u0010\n\u001a\u0004\bT\u0010<\"\u0004\bU\u0010>R\"\u0010\u0017\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bV\u00105\u001a\u0004\bW\u00107\"\u0004\bX\u00109R\"\u0010\u0018\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u00105\u001a\u0004\bV\u00107\"\u0004\bZ\u00109R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\"\u0010\u001b\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\ba\u00105\u001a\u0004\bb\u00107\"\u0004\bc\u00109R\"\u0010\u001c\u001a\u00020\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b6\u00105\u001a\u0004\bL\u00107\"\u0004\bd\u00109R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bY\u0010g\"\u0004\bh\u0010iR\"\u0010 \u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bj\u0010k\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\"\u0010!\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010\\\u001a\u0004\bj\u0010^\"\u0004\bq\u0010`R\"\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010\n\u001a\u0004\bS\u0010<\"\u0004\br\u0010>R\"\u0010#\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bs\u0010N\u001a\u0004\bt\u0010P\"\u0004\bu\u0010RR\"\u0010$\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b@\u0010\n\u001a\u0004\bp\u0010<\"\u0004\bv\u0010>R\"\u0010%\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bC\u0010N\u001a\u0004\bf\u0010P\"\u0004\bw\u0010RR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bb\u0010k\u001a\u0004\bx\u0010m\"\u0004\by\u0010oR$\u0010'\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bz\u00105\u001a\u0004\bz\u00107\"\u0004\b{\u00109R$\u0010(\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b|\u00105\u001a\u0004\b|\u00107\"\u0004\b}\u00109R&\u0010*\u001a\u0004\u0018\u00010)8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bT\u0010~\u001a\u0004\ba\u0010\u007f\"\u0006\b\u0080\u0001\u0010\u0081\u0001R(\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bW\u0010\u0082\u0001\u001a\u0005\b[\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R4\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f\u0018\u00010-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bx\u0010\u0086\u0001\u001a\u0005\bs\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R(\u00100\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bF\u0010\u008a\u0001\u001a\u0005\be\u0010\u008b\u0001\"\u0006\b\u008c\u0001\u0010\u008d\u0001R(\u00101\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bl\u0010\u008a\u0001\u001a\u0005\bH\u0010\u008b\u0001\"\u0006\b\u008e\u0001\u0010\u008d\u0001R(\u00102\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u000b\u0010\u008a\u0001\u001a\u0005\b?\u0010\u008b\u0001\"\u0006\b\u008f\u0001\u0010\u008d\u0001\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/tencent/ecommerce/repo/live/q;", "", "other", "", "equals", "", "hashCode", UserInfo.SEX_FEMALE, "Lcom/tencent/ecommerce/repo/live/UIStatus;", BdhLogUtil.LogTag.Tag_Req, "I", "E", "", "mediaProductId", "goodsType", "saasProductId", "saasTypeStr", "title", "adTxt", "cover", "buttonTxt", "isExplaining", "status", "statusTxt", "indexTxt", "Lcom/tencent/ecommerce/repo/live/q$b;", "price", "salesTxt", "detailUrl", "", "inventory", "Lcom/tencent/ecommerce/repo/live/q$c;", "uiStyle", "oriPrice", "index", "isSelected", "positionInList", "isTop", "tempUIStyle", "shopId", "skuId", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "liveTabId", "Lcom/tencent/ecommerce/repo/live/l;", "liveActivity", "", CacheTable.TABLE_NAME, "Lcom/tencent/ecommerce/repo/live/r;", "normalShowItem", "couponShowItem", "activityShowItem", "a", "toString", "Ljava/lang/String;", "o", "()Ljava/lang/String;", "setMediaProductId", "(Ljava/lang/String;)V", "b", "i", "()I", "setGoodsType", "(I)V", "c", "u", "setSaasProductId", "d", "v", "setSaasTypeStr", "e", BdhLogUtil.LogTag.Tag_Conn, "setTitle", "f", "K", "g", "setCover", tl.h.F, "setButtonTxt", "Z", "G", "()Z", "L", "(Z)V", "j", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "setStatus", "k", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "setStatusTxt", "l", "setIndexTxt", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/ecommerce/repo/live/q$b;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/ecommerce/repo/live/q$b;", "setPrice", "(Lcom/tencent/ecommerce/repo/live/q$b;)V", DomainData.DOMAIN_NAME, "w", "setSalesTxt", "setDetailUrl", "p", "J", "()J", "setInventory", "(J)V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/ecommerce/repo/live/q$c;", "D", "()Lcom/tencent/ecommerce/repo/live/q$c;", "setUiStyle", "(Lcom/tencent/ecommerce/repo/live/q$c;)V", "r", "setOriPrice", "setIndex", "t", "H", "O", "N", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "B", "P", HippyTKDListViewAdapter.X, "setShopId", "y", "setSkuId", "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "()Lcom/tencent/ecommerce/biz/live/LiveTabId;", "M", "(Lcom/tencent/ecommerce/biz/live/LiveTabId;)V", "Lcom/tencent/ecommerce/repo/live/l;", "()Lcom/tencent/ecommerce/repo/live/l;", "setLiveActivity", "(Lcom/tencent/ecommerce/repo/live/l;)V", "Ljava/util/Map;", "()Ljava/util/Map;", "setReportInfo", "(Ljava/util/Map;)V", "Lcom/tencent/ecommerce/repo/live/r;", "()Lcom/tencent/ecommerce/repo/live/r;", "setNormalShowItem", "(Lcom/tencent/ecommerce/repo/live/r;)V", "setCouponShowItem", "setActivityShowItem", "<init>", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/repo/live/q$b;Ljava/lang/String;Ljava/lang/String;JLcom/tencent/ecommerce/repo/live/q$c;Lcom/tencent/ecommerce/repo/live/q$b;IZIZLcom/tencent/ecommerce/repo/live/q$c;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/ecommerce/biz/live/LiveTabId;Lcom/tencent/ecommerce/repo/live/l;Ljava/util/Map;Lcom/tencent/ecommerce/repo/live/r;Lcom/tencent/ecommerce/repo/live/r;Lcom/tencent/ecommerce/repo/live/r;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* renamed from: com.tencent.ecommerce.repo.live.q, reason: from toString */
/* loaded from: classes31.dex */
public final /* data */ class LiveProduct {

    /* renamed from: F, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata and from toString */
    private LiveActivity liveActivity;

    /* renamed from: B, reason: from kotlin metadata and from toString */
    private Map<String, String> reportInfo;

    /* renamed from: C, reason: from kotlin metadata and from toString */
    private LiveShowItem normalShowItem;

    /* renamed from: D, reason: from kotlin metadata and from toString */
    private LiveShowItem couponShowItem;

    /* renamed from: E, reason: from kotlin metadata and from toString */
    private LiveShowItem activityShowItem;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    private String mediaProductId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    private int goodsType;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    private String saasProductId;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    private String saasTypeStr;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    private String title;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
    private String adTxt;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
    private String cover;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
    private String buttonTxt;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isExplaining;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
    private int status;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata and from toString */
    private String statusTxt;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata and from toString */
    private String indexTxt;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata and from toString */
    private Price price;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata and from toString */
    private String salesTxt;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata and from toString */
    private String detailUrl;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
    private long inventory;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
    private UIStyle uiStyle;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
    private Price oriPrice;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata and from toString */
    private int index;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isSelected;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata and from toString */
    private int positionInList;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata and from toString */
    private boolean isTop;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata and from toString */
    private UIStyle tempUIStyle;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata and from toString */
    private String shopId;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata and from toString */
    private String skuId;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata and from toString */
    private LiveTabId liveTabId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\n\u0010\u0006\u001a\u00020\u0002*\u00020\u0004J\n\u0010\b\u001a\u00020\u0007*\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\r\u001a\u00020\f8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/live/q$a;", "", "Lorg/json/JSONObject;", "productJson", "Lcom/tencent/ecommerce/repo/live/q;", "b", "a", "", "c", "PRODUCT_TYPE_SAAS", "I", "PRODUCT_TYPE_SHOP", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.q$a, reason: from kotlin metadata */
    /* loaded from: classes31.dex */
    public static final class Companion {
        Companion() {
        }

        public final JSONObject a(LiveProduct liveProduct) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("goods_type", liveProduct.getGoodsType());
            jSONObject.put("media_product_id", liveProduct.getMediaProductId());
            jSONObject.put("shop_id", liveProduct.getShopId());
            jSONObject.put("sku_id", liveProduct.getSkuId());
            LiveActivity liveActivity = liveProduct.getLiveActivity();
            jSONObject.put("activity_id", liveActivity != null ? liveActivity.getActivityId() : null);
            return jSONObject;
        }

        public final int c(LiveProduct liveProduct) {
            String shopId = liveProduct.getShopId();
            if (shopId != null) {
                if (shopId.length() > 0) {
                    return 1;
                }
            }
            return 2;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LiveProduct b(JSONObject productJson) {
            String str;
            String str2;
            String str3;
            String optString;
            JSONObject optJSONObject = productJson.optJSONObject(ReportDataBuilder.KEY_PRODUCT_ID);
            JSONObject optJSONObject2 = productJson.optJSONObject("ui_style");
            JSONObject optJSONObject3 = productJson.optJSONObject("ori_price");
            JSONObject optJSONObject4 = productJson.optJSONObject(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
            JSONArray optJSONArray = productJson.optJSONArray("coupon_report_info");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    JSONObject optJSONObject5 = optJSONArray.optJSONObject(i3);
                    if (optJSONObject5 != null) {
                    }
                }
            }
            JSONObject optJSONObject6 = productJson.optJSONObject("live_common_style_infos");
            JSONObject optJSONObject7 = optJSONObject6 != null ? optJSONObject6.optJSONObject("normal_style_info") : null;
            JSONObject optJSONObject8 = optJSONObject6 != null ? optJSONObject6.optJSONObject("coupon_style_info") : null;
            JSONObject optJSONObject9 = optJSONObject6 != null ? optJSONObject6.optJSONObject("live_active_style_info") : null;
            if (optJSONObject == null || (str = optJSONObject.optString("media_product_id")) == null) {
                str = "";
            }
            int optInt = optJSONObject != null ? optJSONObject.optInt("goods_type") : 0;
            String optString2 = productJson.optString("saas_product_id");
            String optString3 = productJson.optString("saas_type_str");
            String optString4 = productJson.optString("title");
            String optString5 = productJson.optString("ad_txt");
            String optString6 = productJson.optString("cover");
            String optString7 = productJson.optString(AppDownloadCallback.BUTTON_TXT);
            boolean optBoolean = productJson.optBoolean("is_explaining");
            int optInt2 = productJson.optInt("status");
            String optString8 = productJson.optString("status_txt");
            String optString9 = productJson.optString("index_txt");
            Price price = new Price(productJson);
            String optString10 = productJson.optString("sales_txt");
            String optString11 = productJson.optString("detail_url");
            long optLong = productJson.optLong("inventory");
            int optInt3 = optJSONObject2 != null ? optJSONObject2.optInt("ui_type") : 0;
            if (optJSONObject2 == null || (str2 = optJSONObject2.optString("ui_title")) == null) {
                str2 = "";
            }
            UIStyle uIStyle = new UIStyle(optInt3, str2);
            Price price2 = new Price(optJSONObject3);
            int optInt4 = productJson.optInt("index");
            boolean z16 = false;
            int i16 = 0;
            boolean z17 = false;
            UIStyle uIStyle2 = null;
            String str4 = (optJSONObject == null || (optString = optJSONObject.optString("shop_id")) == null) ? "" : optString;
            if (optJSONObject == null || (str3 = optJSONObject.optString("sku_id")) == null) {
                str3 = "";
            }
            LiveTabId liveTabId = null;
            LiveActivity a16 = optJSONObject4 == null ? null : LiveActivity.INSTANCE.a(optJSONObject4);
            LiveShowItem.Companion companion = LiveShowItem.INSTANCE;
            return new LiveProduct(str, optInt, optString2, optString3, optString4, optString5, optString6, optString7, optBoolean, optInt2, optString8, optString9, price, optString10, optString11, optLong, uIStyle, price2, optInt4, z16, i16, z17, uIStyle2, str4, str3, liveTabId, a16, linkedHashMap, companion.a(optJSONObject7), companion.a(optJSONObject8), companion.a(optJSONObject9), 41418752, null);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016B\u0013\b\u0016\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017\u00a2\u0006\u0004\b\u0015\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\f\u001a\u00020\t8\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0014\u0010\u000f\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0014\u0010\u0011\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000eR\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0012\u0010\u000e\u001a\u0004\b\n\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/ecommerce/repo/live/q$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "", "a", "J", "priceNum", "b", "Ljava/lang/String;", "pricesTxt", "c", "pricesSuffix", "d", "()Ljava/lang/String;", "pricesPre", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Lorg/json/JSONObject;", ark.ARKMETADATA_JSON, "(Lorg/json/JSONObject;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.q$b, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class Price {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final long priceNum;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String pricesTxt;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final String pricesSuffix;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        private final String pricesPre;

        public Price(long j3, String str, String str2, String str3) {
            this.priceNum = j3;
            this.pricesTxt = str;
            this.pricesSuffix = str2;
            this.pricesPre = str3;
        }

        /* renamed from: a, reason: from getter */
        public final String getPricesPre() {
            return this.pricesPre;
        }

        public int hashCode() {
            int a16 = com.tencent.ecommerce.biz.commission.forecast.b.a(this.priceNum) * 31;
            String str = this.pricesTxt;
            int hashCode = (a16 + (str != null ? str.hashCode() : 0)) * 31;
            String str2 = this.pricesSuffix;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.pricesPre;
            return hashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "Price(priceNum=" + this.priceNum + ", pricesTxt=" + this.pricesTxt + ", pricesSuffix=" + this.pricesSuffix + ", pricesPre=" + this.pricesPre + ")";
        }

        public Price(JSONObject jSONObject) {
            this(jSONObject != null ? jSONObject.optLong("price") : 0L, (jSONObject == null || (r0 = jSONObject.optString("prices_txt")) == null) ? "0" : r0, (jSONObject == null || (r1 = jSONObject.optString("prices_suffix")) == null) ? "" : r1, (jSONObject == null || (r9 = jSONObject.optString("prices_prefix")) == null) ? "" : r9);
            String optString;
            String optString2;
            String optString3;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Price)) {
                return false;
            }
            Price price = (Price) other;
            return this.priceNum == price.priceNum && Intrinsics.areEqual(this.pricesTxt, price.pricesTxt) && Intrinsics.areEqual(this.pricesSuffix, price.pricesSuffix) && Intrinsics.areEqual(this.pricesPre, price.pricesPre);
        }
    }

    public LiveProduct(String str, @GoodsType int i3, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16, @ProductStatus int i16, String str8, String str9, Price price, String str10, String str11, long j3, UIStyle uIStyle, Price price2, int i17, boolean z17, int i18, boolean z18, UIStyle uIStyle2, String str12, String str13, LiveTabId liveTabId, LiveActivity liveActivity, Map<String, String> map, LiveShowItem liveShowItem, LiveShowItem liveShowItem2, LiveShowItem liveShowItem3) {
        this.mediaProductId = str;
        this.goodsType = i3;
        this.saasProductId = str2;
        this.saasTypeStr = str3;
        this.title = str4;
        this.adTxt = str5;
        this.cover = str6;
        this.buttonTxt = str7;
        this.isExplaining = z16;
        this.status = i16;
        this.statusTxt = str8;
        this.indexTxt = str9;
        this.price = price;
        this.salesTxt = str10;
        this.detailUrl = str11;
        this.inventory = j3;
        this.uiStyle = uIStyle;
        this.oriPrice = price2;
        this.index = i17;
        this.isSelected = z17;
        this.positionInList = i18;
        this.isTop = z18;
        this.tempUIStyle = uIStyle2;
        this.shopId = str12;
        this.skuId = str13;
        this.liveTabId = liveTabId;
        this.liveActivity = liveActivity;
        this.reportInfo = map;
        this.normalShowItem = liveShowItem;
        this.couponShowItem = liveShowItem2;
        this.activityShowItem = liveShowItem3;
    }

    /* renamed from: A, reason: from getter */
    public final String getStatusTxt() {
        return this.statusTxt;
    }

    /* renamed from: B, reason: from getter */
    public final UIStyle getTempUIStyle() {
        return this.tempUIStyle;
    }

    /* renamed from: C, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    /* renamed from: D, reason: from getter */
    public final UIStyle getUiStyle() {
        return this.uiStyle;
    }

    public final boolean E() {
        List<HotLabel> a16;
        LiveShowItem liveShowItem = this.couponShowItem;
        return (liveShowItem == null || (a16 = liveShowItem.a()) == null || !(a16.isEmpty() ^ true)) ? false : true;
    }

    public final boolean F() {
        LiveActivity liveActivity = this.liveActivity;
        if (liveActivity == null || liveActivity == null) {
            return false;
        }
        return liveActivity.k();
    }

    /* renamed from: G, reason: from getter */
    public final boolean getIsExplaining() {
        return this.isExplaining;
    }

    /* renamed from: H, reason: from getter */
    public final boolean getIsSelected() {
        return this.isSelected;
    }

    public final boolean I() {
        ActivityStock activityStock;
        if (F()) {
            LiveActivity liveActivity = this.liveActivity;
            if (liveActivity == null || (activityStock = liveActivity.getActivityStock()) == null || !activityStock.d()) {
                return false;
            }
        } else if (this.inventory > 0) {
            return false;
        }
        return true;
    }

    /* renamed from: J, reason: from getter */
    public final boolean getIsTop() {
        return this.isTop;
    }

    public final void K(String str) {
        this.adTxt = str;
    }

    public final void L(boolean z16) {
        this.isExplaining = z16;
    }

    public final void M(LiveTabId liveTabId) {
        this.liveTabId = liveTabId;
    }

    public final void N(int i3) {
        this.positionInList = i3;
    }

    public final void O(boolean z16) {
        this.isSelected = z16;
    }

    public final void P(UIStyle uIStyle) {
        this.tempUIStyle = uIStyle;
    }

    public final void Q(boolean z16) {
        this.isTop = z16;
    }

    public final UIStatus R() {
        LiveActivity liveActivity = this.liveActivity;
        if (liveActivity != null) {
            return liveActivity.n();
        }
        return UIStatus.UI_STATUS_NONE;
    }

    public final LiveProduct a(String mediaProductId, @GoodsType int goodsType, String saasProductId, String saasTypeStr, String title, String adTxt, String cover, String buttonTxt, boolean isExplaining, @ProductStatus int status, String statusTxt, String indexTxt, Price price, String salesTxt, String detailUrl, long inventory, UIStyle uiStyle, Price oriPrice, int index, boolean isSelected, int positionInList, boolean isTop, UIStyle tempUIStyle, String shopId, String skuId, LiveTabId liveTabId, LiveActivity liveActivity, Map<String, String> reportInfo, LiveShowItem normalShowItem, LiveShowItem couponShowItem, LiveShowItem activityShowItem) {
        return new LiveProduct(mediaProductId, goodsType, saasProductId, saasTypeStr, title, adTxt, cover, buttonTxt, isExplaining, status, statusTxt, indexTxt, price, salesTxt, detailUrl, inventory, uiStyle, oriPrice, index, isSelected, positionInList, isTop, tempUIStyle, shopId, skuId, liveTabId, liveActivity, reportInfo, normalShowItem, couponShowItem, activityShowItem);
    }

    /* renamed from: c, reason: from getter */
    public final LiveShowItem getActivityShowItem() {
        return this.activityShowItem;
    }

    /* renamed from: d, reason: from getter */
    public final String getAdTxt() {
        return this.adTxt;
    }

    /* renamed from: e, reason: from getter */
    public final String getButtonTxt() {
        return this.buttonTxt;
    }

    /* renamed from: f, reason: from getter */
    public final LiveShowItem getCouponShowItem() {
        return this.couponShowItem;
    }

    /* renamed from: g, reason: from getter */
    public final String getCover() {
        return this.cover;
    }

    /* renamed from: h, reason: from getter */
    public final String getDetailUrl() {
        return this.detailUrl;
    }

    public int hashCode() {
        int hashCode = ((this.mediaProductId.hashCode() * 31) + this.goodsType) * 31;
        String str = this.shopId;
        int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.skuId;
        int hashCode3 = hashCode2 + (str2 != null ? str2.hashCode() : 0);
        LiveActivity liveActivity = this.liveActivity;
        return liveActivity != null ? (hashCode3 * 31) + liveActivity.getActivityId().hashCode() : hashCode3;
    }

    /* renamed from: i, reason: from getter */
    public final int getGoodsType() {
        return this.goodsType;
    }

    /* renamed from: j, reason: from getter */
    public final int getIndex() {
        return this.index;
    }

    /* renamed from: k, reason: from getter */
    public final String getIndexTxt() {
        return this.indexTxt;
    }

    /* renamed from: l, reason: from getter */
    public final long getInventory() {
        return this.inventory;
    }

    /* renamed from: m, reason: from getter */
    public final LiveActivity getLiveActivity() {
        return this.liveActivity;
    }

    /* renamed from: n, reason: from getter */
    public final LiveTabId getLiveTabId() {
        return this.liveTabId;
    }

    /* renamed from: o, reason: from getter */
    public final String getMediaProductId() {
        return this.mediaProductId;
    }

    /* renamed from: p, reason: from getter */
    public final LiveShowItem getNormalShowItem() {
        return this.normalShowItem;
    }

    /* renamed from: q, reason: from getter */
    public final Price getOriPrice() {
        return this.oriPrice;
    }

    /* renamed from: r, reason: from getter */
    public final int getPositionInList() {
        return this.positionInList;
    }

    /* renamed from: s, reason: from getter */
    public final Price getPrice() {
        return this.price;
    }

    public final Map<String, String> t() {
        return this.reportInfo;
    }

    public String toString() {
        return "LiveProduct(mediaProductId=" + this.mediaProductId + ", goodsType=" + this.goodsType + ", saasProductId=" + this.saasProductId + ", saasTypeStr=" + this.saasTypeStr + ", title=" + this.title + ", adTxt=" + this.adTxt + ", cover=" + this.cover + ", buttonTxt=" + this.buttonTxt + ", isExplaining=" + this.isExplaining + ", status=" + this.status + ", statusTxt=" + this.statusTxt + ", indexTxt=" + this.indexTxt + ", price=" + this.price + ", salesTxt=" + this.salesTxt + ", detailUrl=" + this.detailUrl + ", inventory=" + this.inventory + ", uiStyle=" + this.uiStyle + ", oriPrice=" + this.oriPrice + ", index=" + this.index + ", isSelected=" + this.isSelected + ", positionInList=" + this.positionInList + ", isTop=" + this.isTop + ", tempUIStyle=" + this.tempUIStyle + ", shopId=" + this.shopId + ", skuId=" + this.skuId + ", liveTabId=" + this.liveTabId + ", liveActivity=" + this.liveActivity + ", reportInfo=" + this.reportInfo + ", normalShowItem=" + this.normalShowItem + ", couponShowItem=" + this.couponShowItem + ", activityShowItem=" + this.activityShowItem + ")";
    }

    /* renamed from: u, reason: from getter */
    public final String getSaasProductId() {
        return this.saasProductId;
    }

    /* renamed from: v, reason: from getter */
    public final String getSaasTypeStr() {
        return this.saasTypeStr;
    }

    /* renamed from: w, reason: from getter */
    public final String getSalesTxt() {
        return this.salesTxt;
    }

    /* renamed from: x, reason: from getter */
    public final String getShopId() {
        return this.shopId;
    }

    /* renamed from: y, reason: from getter */
    public final String getSkuId() {
        return this.skuId;
    }

    /* renamed from: z, reason: from getter */
    public final int getStatus() {
        return this.status;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u000b\u001a\u00020\u0004\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0087\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ecommerce/repo/live/q$c;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", "type", "b", "Ljava/lang/String;", "uiTitle", "<init>", "(ILjava/lang/String;)V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* renamed from: com.tencent.ecommerce.repo.live.q$c, reason: from toString */
    /* loaded from: classes31.dex */
    public static final /* data */ class UIStyle {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int type;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final String uiTitle;

        public UIStyle(@UIType int i3, String str) {
            this.type = i3;
            this.uiTitle = str;
        }

        public int hashCode() {
            int i3 = this.type * 31;
            String str = this.uiTitle;
            return i3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "UIStyle(type=" + this.type + ", uiTitle=" + this.uiTitle + ")";
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof UIStyle)) {
                return false;
            }
            UIStyle uIStyle = (UIStyle) other;
            return this.type == uIStyle.type && Intrinsics.areEqual(this.uiTitle, uIStyle.uiTitle);
        }
    }

    public /* synthetic */ LiveProduct(String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, boolean z16, int i16, String str8, String str9, Price price, String str10, String str11, long j3, UIStyle uIStyle, Price price2, int i17, boolean z17, int i18, boolean z18, UIStyle uIStyle2, String str12, String str13, LiveTabId liveTabId, LiveActivity liveActivity, Map map, LiveShowItem liveShowItem, LiveShowItem liveShowItem2, LiveShowItem liveShowItem3, int i19, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i3, str2, str3, str4, str5, str6, str7, z16, i16, str8, str9, price, str10, str11, j3, uIStyle, price2, i17, (i19 & 524288) != 0 ? false : z17, (i19 & 1048576) != 0 ? -1 : i18, (i19 & 2097152) != 0 ? false : z18, (i19 & 4194304) != 0 ? null : uIStyle2, (i19 & 8388608) != 0 ? null : str12, (i19 & 16777216) != 0 ? null : str13, (i19 & 33554432) != 0 ? null : liveTabId, (i19 & 67108864) != 0 ? null : liveActivity, (i19 & 134217728) != 0 ? null : map, (i19 & 268435456) != 0 ? null : liveShowItem, (i19 & 536870912) != 0 ? null : liveShowItem2, (i19 & 1073741824) != 0 ? null : liveShowItem3);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!Intrinsics.areEqual(LiveProduct.class, other != null ? other.getClass() : null)) {
            return false;
        }
        if (other != null) {
            LiveProduct liveProduct = (LiveProduct) other;
            if ((!Intrinsics.areEqual(this.mediaProductId, liveProduct.mediaProductId)) || this.goodsType != liveProduct.goodsType || (!Intrinsics.areEqual(this.shopId, liveProduct.shopId)) || (!Intrinsics.areEqual(this.skuId, liveProduct.skuId))) {
                return false;
            }
            LiveActivity liveActivity = this.liveActivity;
            String activityId = liveActivity != null ? liveActivity.getActivityId() : null;
            LiveActivity liveActivity2 = liveProduct.liveActivity;
            return !(Intrinsics.areEqual(activityId, liveActivity2 != null ? liveActivity2.getActivityId() : null) ^ true);
        }
        throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.repo.live.LiveProduct");
    }
}
