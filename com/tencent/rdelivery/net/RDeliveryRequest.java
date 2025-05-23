package com.tencent.rdelivery.net;

import android.text.TextUtils;
import android.util.Base64;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder;
import com.tencent.raft.codegenmeta.utils.Constants;
import com.tencent.rdelivery.RDeliverySetting;
import com.tencent.rdelivery.net.ServerUrlGenerator;
import iz3.l;
import iz3.m;
import java.nio.charset.Charset;
import java.security.Key;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* compiled from: P */
@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010%\n\u0002\b%\n\u0002\u0010 \n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0003\t\u00c2\u0001B\t\u00a2\u0006\u0006\b\u00c0\u0001\u0010\u00c1\u0001J,\u0010\t\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007J.\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J&\u0010\f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J&\u0010\u000e\u001a\u00020\r2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\b\u0010\u0010\u001a\u0004\u0018\u00010\rR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u0011\u001a\u0004\b\u0018\u0010\u0013\"\u0004\b\u0019\u0010\u0015R$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u001c\u0010\u0013\"\u0004\b\u001d\u0010\u0015R$\u0010%\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010-\u001a\u00020&8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R$\u00105\u001a\u0004\u0018\u00010.8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R$\u0010D\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR%\u0010I\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020E8\u0006\u00a2\u0006\f\n\u0004\bF\u0010G\u001a\u0004\b/\u0010HR\"\u0010L\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\u0011\u001a\u0004\bJ\u0010\u0013\"\u0004\bK\u0010\u0015R$\u0010P\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bM\u0010\u0011\u001a\u0004\bN\u0010\u0013\"\u0004\bO\u0010\u0015R$\u0010T\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u0011\u001a\u0004\bR\u0010\u0013\"\u0004\bS\u0010\u0015R\"\u0010W\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010\u0011\u001a\u0004\b'\u0010\u0013\"\u0004\bV\u0010\u0015R\"\u0010[\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bX\u0010\u0011\u001a\u0004\bY\u0010\u0013\"\u0004\bZ\u0010\u0015R\"\u0010^\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\\\u0010\u0011\u001a\u0004\bF\u0010\u0013\"\u0004\b]\u0010\u0015R\"\u0010a\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b_\u0010\u0011\u001a\u0004\b>\u0010\u0013\"\u0004\b`\u0010\u0015R\"\u0010c\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u0011\u001a\u0004\b\u001b\u0010\u0013\"\u0004\bb\u0010\u0015R$\u0010e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b)\u0010d\u001a\u0004\be\u0010f\"\u0004\bg\u0010hR$\u0010j\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010 \u001a\u0004\bM\u0010\"\"\u0004\bi\u0010$R*\u0010q\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010k8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bQ\u0010n\"\u0004\bo\u0010pR$\u0010s\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\br\u0010d\u001a\u0004\bs\u0010f\"\u0004\bt\u0010hR$\u0010w\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010\u0011\u001a\u0004\bX\u0010\u0013\"\u0004\bv\u0010\u0015R$\u0010{\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bx\u0010\u0011\u001a\u0004\by\u0010\u0013\"\u0004\bz\u0010\u0015R$\u0010\u007f\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b|\u0010 \u001a\u0004\b}\u0010\"\"\u0004\b~\u0010$R(\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0005\b\u0080\u0001\u0010 \u001a\u0005\b\u0081\u0001\u0010\"\"\u0005\b\u0082\u0001\u0010$R%\u0010\u0085\u0001\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u000f\u0010\u0011\u001a\u0005\b\u0080\u0001\u0010\u0013\"\u0005\b\u0084\u0001\u0010\u0015R+\u0010\u008c\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u0087\u0001\u0010\u0088\u0001\u001a\u0005\bU\u0010\u0089\u0001\"\u0006\b\u008a\u0001\u0010\u008b\u0001R&\u0010\u0090\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\u000e\u0010}\u001a\u0005\bx\u0010\u008d\u0001\"\u0006\b\u008e\u0001\u0010\u008f\u0001R'\u0010\u0093\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0091\u0001\u0010}\u001a\u0005\bu\u0010\u008d\u0001\"\u0006\b\u0092\u0001\u0010\u008f\u0001R&\u0010\u0095\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\f\u0010}\u001a\u0005\b|\u0010\u008d\u0001\"\u0006\b\u0094\u0001\u0010\u008f\u0001R(\u0010\u0099\u0001\u001a\u00020\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b\u0096\u0001\u0010}\u001a\u0006\b\u0097\u0001\u0010\u008d\u0001\"\u0006\b\u0098\u0001\u0010\u008f\u0001R(\u0010\u009e\u0001\u001a\u00030\u009a\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b\u0097\u0001\u0010\u0012\u001a\u0005\br\u0010\u009b\u0001\"\u0006\b\u009c\u0001\u0010\u009d\u0001R'\u0010\u00a0\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\b\u001c\u0010 \u001a\u0005\b\u0096\u0001\u0010\"\"\u0005\b\u009f\u0001\u0010$R&\u0010\u00a2\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0013\n\u0004\b\u0010\u0010d\u001a\u0004\b7\u0010f\"\u0005\b\u00a1\u0001\u0010hR'\u0010\u00a4\u0001\u001a\u00030\u009a\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\b\u0012\u0010\u0012\u001a\u0005\bl\u0010\u009b\u0001\"\u0006\b\u00a3\u0001\u0010\u009d\u0001R+\u0010\u00aa\u0001\u001a\u0005\u0018\u00010\u00a5\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b}\u0010\u00a6\u0001\u001a\u0006\b\u0087\u0001\u0010\u00a7\u0001\"\u0006\b\u00a8\u0001\u0010\u00a9\u0001R'\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bJ\u0010d\u001a\u0005\b\u00ab\u0001\u0010f\"\u0005\b\u00ac\u0001\u0010hR+\u0010\u00b3\u0001\u001a\u0005\u0018\u00010\u00ae\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0006\b\u00ab\u0001\u0010\u00af\u0001\u001a\u0005\b\u0017\u0010\u00b0\u0001\"\u0006\b\u00b1\u0001\u0010\u00b2\u0001R'\u0010\u00b4\u0001\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0004\bg\u0010o\u001a\u0006\b\u00b4\u0001\u0010\u00b5\u0001\"\u0006\b\u00b6\u0001\u0010\u00b7\u0001R'\u0010\u00b9\u0001\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0005\b\u00b6\u0001\u0010 \u001a\u0004\b_\u0010\"\"\u0005\b\u00b8\u0001\u0010$R*\u0010\u00bf\u0001\u001a\u0005\u0018\u00010\u00ba\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\bb\u0010\u00bb\u0001\u001a\u0005\b\\\u0010\u00bc\u0001\"\u0006\b\u00bd\u0001\u0010\u00be\u0001\u00a8\u0006\u00c3\u0001"}, d2 = {"Lcom/tencent/rdelivery/net/RDeliveryRequest;", "", "", com.heytap.mcssdk.a.a.f36102l, "extraTag", "Lcom/tencent/rdelivery/util/c;", "logger", "", "doPrintLog", "a", "enableEncrypt", "j", "D", "Lorg/json/JSONObject;", "B", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "H", "Ljava/lang/String;", "I", "()Ljava/lang/String;", "t0", "(Ljava/lang/String;)V", "systemId", "b", "d", "P", "appId", "c", "G", "r0", "sign", "", "Ljava/lang/Long;", "getTimestamp", "()Ljava/lang/Long;", "w0", "(Ljava/lang/Long;)V", "timestamp", "Lcom/tencent/rdelivery/net/BaseProto$PullType;", "e", "Lcom/tencent/rdelivery/net/BaseProto$PullType;", "r", "()Lcom/tencent/rdelivery/net/BaseProto$PullType;", "g0", "(Lcom/tencent/rdelivery/net/BaseProto$PullType;)V", "pullType", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "f", "Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Lcom/tencent/rdelivery/net/BaseProto$PullTarget;", "f0", "(Lcom/tencent/rdelivery/net/BaseProto$PullTarget;)V", "pullTarget", "Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", "g", "Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", "getPullDataType", "()Lcom/tencent/rdelivery/net/BaseProto$ConfigType;", "e0", "(Lcom/tencent/rdelivery/net/BaseProto$ConfigType;)V", "pullDataType", tl.h.F, "Lorg/json/JSONObject;", "getSubSystemBizParams", "()Lorg/json/JSONObject;", "s0", "(Lorg/json/JSONObject;)V", "subSystemBizParams", "", "i", "Ljava/util/Map;", "()Ljava/util/Map;", "customProperties", "K", "x0", "userId", "k", "getUuid", "y0", "uuid", "l", ReportConstant.COSTREPORT_PREFIX, "h0", TVKLiveRequestBuilder.RequestParamKey.QIMEI36, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "appVersion", DomainData.DOMAIN_NAME, "getBundleId", BdhLogUtil.LogTag.Tag_Req, "bundleId", "o", "W", "devModel", "p", "V", "devManufacturer", "O", "androidSystemVersion", "Ljava/lang/Boolean;", "is64Bit", "()Ljava/lang/Boolean;", "M", "(Ljava/lang/Boolean;)V", "X", "groupID", "", "t", "Ljava/util/List;", "()Ljava/util/List;", "Z", "(Ljava/util/List;)V", "keys", "u", "isDebugPackage", "T", "v", "b0", "logicEnvironment", "w", "getContext", ExifInterface.LATITUDE_SOUTH, "context", HippyTKDListViewAdapter.X, "J", "v0", "taskChecksum", "y", "getTaskCheckCount", "u0", "taskCheckCount", "n0", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_REQUEST_ID, "Liz3/m;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Liz3/m;", "()Liz3/m;", "a0", "(Liz3/m;)V", "listener", "()J", "l0", "(J)V", "requestEnqueueTS", BdhLogUtil.LogTag.Tag_Conn, "k0", "requestDequeueTS", "m0", "requestExecuteTS", "E", UserInfo.SEX_FEMALE, "q0", "responseTS", "", "()I", "j0", "(I)V", "reqSize", "p0", "respDecFinishTS", "U", "decodeResult", "i0", "reportSampling", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "()Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "o0", "(Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;)V", "requestSrc", "L", "Y", "isInitRequest", "Ljava/security/Key;", "Ljava/security/Key;", "()Ljava/security/Key;", "setAesKey", "(Ljava/security/Key;)V", "aesKey", "isAPad", "()Z", "N", "(Z)V", "d0", "mergeReqId", "Liz3/j;", "Liz3/j;", "()Liz3/j;", "c0", "(Liz3/j;)V", "mergePullRequestResultListener", "<init>", "()V", "RequestSource", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class RDeliveryRequest {

    /* renamed from: P, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: from kotlin metadata */
    @Nullable
    private m listener;

    /* renamed from: B, reason: from kotlin metadata */
    private long requestEnqueueTS;

    /* renamed from: C, reason: from kotlin metadata */
    private long requestDequeueTS;

    /* renamed from: D, reason: from kotlin metadata */
    private long requestExecuteTS;

    /* renamed from: E, reason: from kotlin metadata */
    private long responseTS;

    /* renamed from: F, reason: from kotlin metadata */
    private int reqSize;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Long respDecFinishTS;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private Boolean decodeResult;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private RequestSource requestSrc;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private Boolean isInitRequest;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Key aesKey;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean isAPad;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Long mergeReqId;

    /* renamed from: O, reason: from kotlin metadata */
    @Nullable
    private iz3.j mergePullRequestResultListener;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String sign;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long timestamp;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseProto$PullTarget pullTarget;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BaseProto$ConfigType pullDataType;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private JSONObject subSystemBizParams;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String uuid;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String qimei;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean is64Bit;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long groupID;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<String> keys;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Boolean isDebugPackage;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String logicEnvironment;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String context;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long taskChecksum;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Long taskCheckCount;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String systemId = "";

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appId = "";

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BaseProto$PullType pullType = BaseProto$PullType.UNKNOWN;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, String> customProperties = new LinkedHashMap();

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String userId = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String appVersion = "";

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String bundleId = "";

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String devModel = "";

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String devManufacturer = "";

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String androidSystemVersion = "";

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String requestId = "";

    /* renamed from: I, reason: from kotlin metadata */
    private int reportSampling = 10;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "SDK_INIT", "PERIODIC", "NETWORK_RECONNECT", "HOT_RELOAD", "HOST_APP", "MULTI_PROCESS_DATA_SYNC", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 1, 16})
    /* loaded from: classes25.dex */
    public enum RequestSource {
        SDK_INIT(0),
        PERIODIC(1),
        NETWORK_RECONNECT(2),
        HOT_RELOAD(3),
        HOST_APP(4),
        MULTI_PROCESS_DATA_SYNC(5);

        private final int value;

        RequestSource(int i3) {
            this.value = i3;
        }

        public final int getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0003J\u0006\u0010\n\u001a\u00020\tJ5\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0010\u0010\u0011J5\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\t2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\u0014\u0010\u0015J$\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00162\u0006\u0010\u000e\u001a\u00020\u0018R\u0014\u0010\u001a\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/rdelivery/net/RDeliveryRequest$a;", "", "Lcom/tencent/rdelivery/net/RDeliveryRequest;", "Lcom/tencent/rdelivery/RDeliverySetting;", "setting", "", "e", "", "g", "", "f", "Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;", "src", "Liz3/e;", "listener", "mergeReqId", "c", "(Lcom/tencent/rdelivery/RDeliverySetting;Lcom/tencent/rdelivery/net/RDeliveryRequest$RequestSource;Liz3/e;Ljava/lang/Long;)Lcom/tencent/rdelivery/net/RDeliveryRequest;", WadlProxyConsts.SCENE_ID, "Liz3/m;", "a", "(Lcom/tencent/rdelivery/RDeliverySetting;JLiz3/m;Ljava/lang/Long;)Lcom/tencent/rdelivery/net/RDeliveryRequest;", "", "keys", "Liz3/l;", "d", "TAG", "Ljava/lang/String;", "<init>", "()V", "rdelivery_nonCommercialRelease"}, k = 1, mv = {1, 4, 0})
    /* renamed from: com.tencent.rdelivery.net.RDeliveryRequest$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
    public static final class Companion {
        Companion() {
        }

        public static /* synthetic */ RDeliveryRequest b(Companion companion, RDeliverySetting rDeliverySetting, long j3, m mVar, Long l3, int i3, Object obj) {
            m mVar2;
            Long l16;
            if ((i3 & 4) != 0) {
                mVar2 = null;
            } else {
                mVar2 = mVar;
            }
            if ((i3 & 8) != 0) {
                l16 = null;
            } else {
                l16 = l3;
            }
            return companion.a(rDeliverySetting, j3, mVar2, l16);
        }

        private final void e(@NotNull RDeliveryRequest rDeliveryRequest, RDeliverySetting rDeliverySetting) {
            rDeliveryRequest.t0(rDeliverySetting.getSystemId());
            rDeliveryRequest.P(rDeliverySetting.getAppId());
            rDeliveryRequest.x0(rDeliverySetting.getUserId());
            rDeliveryRequest.h0(rDeliverySetting.getCom.tencent.qqlive.tvkplayer.vinfo.live.TVKLiveRequestBuilder.RequestParamKey.QIMEI36 java.lang.String());
            rDeliveryRequest.y0(rDeliverySetting.getUuid());
            rDeliveryRequest.R(rDeliverySetting.getBundleId());
            rDeliveryRequest.Q(rDeliverySetting.getHostAppVersion());
            rDeliveryRequest.W(rDeliverySetting.getDevModel());
            rDeliveryRequest.V(rDeliverySetting.getDevManufacturer());
            rDeliveryRequest.O(rDeliverySetting.getAndroidSystemVersion());
            rDeliveryRequest.M(rDeliverySetting.getIs64Bit());
            rDeliveryRequest.b0(rDeliverySetting.getLogicEnvironment());
            rDeliveryRequest.T(rDeliverySetting.getIsDebugPackage());
            rDeliveryRequest.f0(rDeliverySetting.getPullTarget());
            rDeliveryRequest.e0(rDeliverySetting.getPullDataType());
            rDeliveryRequest.s0(rDeliverySetting.getSubSystemBizParams());
            rDeliveryRequest.N(rDeliverySetting.getIsAPad());
        }

        @NotNull
        public final RDeliveryRequest a(@NotNull RDeliverySetting setting, long sceneId, @Nullable m listener, @Nullable Long mergeReqId) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            RDeliveryRequest rDeliveryRequest = new RDeliveryRequest();
            Companion companion = RDeliveryRequest.INSTANCE;
            companion.e(rDeliveryRequest, setting);
            rDeliveryRequest.g0(BaseProto$PullType.GROUP);
            synchronized (setting) {
                rDeliveryRequest.f().putAll(setting.j());
                Unit unit = Unit.INSTANCE;
            }
            rDeliveryRequest.X(Long.valueOf(sceneId));
            rDeliveryRequest.n0(com.tencent.rdelivery.report.c.f364376c.e());
            rDeliveryRequest.w0(Long.valueOf(companion.f() / 1000));
            rDeliveryRequest.a0(listener);
            rDeliveryRequest.d0(mergeReqId);
            return rDeliveryRequest;
        }

        @NotNull
        public final RDeliveryRequest c(@NotNull RDeliverySetting setting, @NotNull RequestSource src, @Nullable iz3.e listener, @Nullable Long mergeReqId) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            Intrinsics.checkParameterIsNotNull(src, "src");
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                logger.a(com.tencent.rdelivery.util.d.a("RDeliveryRequest", setting.getRdInstanceIdentifier()), "createFullRequest " + src, setting.getEnableDetailLog());
            }
            RDeliveryRequest rDeliveryRequest = new RDeliveryRequest();
            Companion companion = RDeliveryRequest.INSTANCE;
            companion.e(rDeliveryRequest, setting);
            rDeliveryRequest.g0(BaseProto$PullType.ALL);
            synchronized (setting) {
                rDeliveryRequest.f().putAll(setting.j());
                Unit unit = Unit.INSTANCE;
            }
            rDeliveryRequest.n0(com.tencent.rdelivery.report.c.f364376c.e());
            rDeliveryRequest.o0(src);
            rDeliveryRequest.w0(Long.valueOf(companion.f() / 1000));
            rDeliveryRequest.a0(listener);
            rDeliveryRequest.d0(mergeReqId);
            return rDeliveryRequest;
        }

        @NotNull
        public final RDeliveryRequest d(@NotNull RDeliverySetting setting, @NotNull List<String> keys, @NotNull l listener) {
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            Intrinsics.checkParameterIsNotNull(keys, "keys");
            Intrinsics.checkParameterIsNotNull(listener, "listener");
            RDeliveryRequest rDeliveryRequest = new RDeliveryRequest();
            Companion companion = RDeliveryRequest.INSTANCE;
            companion.e(rDeliveryRequest, setting);
            rDeliveryRequest.g0(BaseProto$PullType.CONFIG);
            synchronized (setting) {
                rDeliveryRequest.f().putAll(setting.j());
                Unit unit = Unit.INSTANCE;
            }
            rDeliveryRequest.Z(keys);
            rDeliveryRequest.n0(com.tencent.rdelivery.report.c.f364376c.e());
            rDeliveryRequest.w0(Long.valueOf(companion.f() / 1000));
            rDeliveryRequest.a0(listener);
            return rDeliveryRequest;
        }

        public final long f() {
            return System.currentTimeMillis();
        }

        @NotNull
        public final String g(@NotNull RDeliverySetting setting) {
            ServerUrlGenerator.ProtocolPathInUrl protocolPathInUrl;
            Intrinsics.checkParameterIsNotNull(setting, "setting");
            if (setting.getEnableEncrypt()) {
                protocolPathInUrl = ServerUrlGenerator.ProtocolPathInUrl.PULL_ALL_CONFIG_SWITCH_DATA_ENCRYPT;
            } else {
                protocolPathInUrl = ServerUrlGenerator.ProtocolPathInUrl.PULL_ALL_CONFIG_SWITCH_DATA;
            }
            String a16 = ServerUrlGenerator.f364301a.a(setting, protocolPathInUrl);
            com.tencent.rdelivery.util.c logger = setting.getLogger();
            if (logger != null) {
                com.tencent.rdelivery.util.c.b(logger, "RDeliveryRequest", "getServerUrl, result = " + a16, false, 4, null);
            }
            return a16;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ JSONObject C(RDeliveryRequest rDeliveryRequest, com.tencent.rdelivery.util.c cVar, boolean z16, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            str = null;
        }
        return rDeliveryRequest.B(cVar, z16, str);
    }

    @Nullable
    /* renamed from: A, reason: from getter */
    public final RequestSource getRequestSrc() {
        return this.requestSrc;
    }

    @NotNull
    public final JSONObject B(@Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog, @Nullable String extraTag) {
        String z16 = z();
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDeliveryRequest", extraTag), "origin reqStr = " + z16, doPrintLog);
        }
        JSONObject jSONObject = new JSONObject();
        Key c16 = com.tencent.rdelivery.util.b.c();
        Intrinsics.checkExpressionValueIsNotNull(c16, "CryptoUtil.genAesRandomKey()");
        this.aesKey = c16;
        Charset charset = Charsets.UTF_8;
        if (z16 != null) {
            byte[] bytes = z16.getBytes(charset);
            Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
            byte[] b16 = com.tencent.rdelivery.util.b.b(bytes, c16);
            Intrinsics.checkExpressionValueIsNotNull(b16, "CryptoUtil.aesEncrypt(re\u2026tr.toByteArray(), aesKey)");
            byte[] encode = Base64.encode(b16, 2);
            Intrinsics.checkExpressionValueIsNotNull(encode, "Base64.encode(aesEncryptReq, Base64.NO_WRAP)");
            String str = new String(encode, charset);
            byte[] encode2 = Base64.encode(com.tencent.rdelivery.util.b.e(c16.getEncoded(), com.tencent.rdelivery.util.b.d("MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQC/rT6ULqXC32dgz4t/Vv4WS9pT\nks5Z2fPmbTHIXEVeiOEnjOpPBHOi1AUz+Ykqjk11ZyjidUwDyIaC/VtaC5Z7Bt/W\n+CFluDer7LiiDa6j77if5dbcvWUrJbgvhKqaEhWnMDXT1pAG2KxL/pNFAYguSLpO\nh9pK97G8umUMkkwWkwIDAQAB")), 2);
            Intrinsics.checkExpressionValueIsNotNull(encode2, "Base64.encode(rsaByteArray, Base64.NO_WRAP)");
            String str2 = new String(encode2, charset);
            jSONObject.put("cipher_text", str);
            jSONObject.put("public_key_version", 1);
            jSONObject.put("pull_key", str2);
            return jSONObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
    }

    @NotNull
    public final String D(@Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog, @Nullable String extraTag) {
        String jSONObject = B(logger, doPrintLog, extraTag).toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject, "v2Request.toString()");
        return jSONObject;
    }

    @Nullable
    /* renamed from: E, reason: from getter */
    public final Long getRespDecFinishTS() {
        return this.respDecFinishTS;
    }

    /* renamed from: F, reason: from getter */
    public final long getResponseTS() {
        return this.responseTS;
    }

    @Nullable
    /* renamed from: G, reason: from getter */
    public final String getSign() {
        return this.sign;
    }

    @Nullable
    public final JSONObject H() {
        if (Intrinsics.areEqual(this.systemId, BaseProto$BizSystemID.TAB.getValue())) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = this.subSystemBizParams;
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
            }
            jSONObject2.putOpt("isInitRequest", this.isInitRequest);
            jSONObject.putOpt("tabBizParams", jSONObject2);
            return jSONObject;
        }
        return null;
    }

    @NotNull
    /* renamed from: I, reason: from getter */
    public final String getSystemId() {
        return this.systemId;
    }

    @Nullable
    /* renamed from: J, reason: from getter */
    public final Long getTaskChecksum() {
        return this.taskChecksum;
    }

    @NotNull
    /* renamed from: K, reason: from getter */
    public final String getUserId() {
        return this.userId;
    }

    @Nullable
    /* renamed from: L, reason: from getter */
    public final Boolean getIsInitRequest() {
        return this.isInitRequest;
    }

    public final void M(@Nullable Boolean bool) {
        this.is64Bit = bool;
    }

    public final void N(boolean z16) {
        this.isAPad = z16;
    }

    public final void O(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.androidSystemVersion = str;
    }

    public final void P(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appId = str;
    }

    public final void Q(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.appVersion = str;
    }

    public final void R(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.bundleId = str;
    }

    public final void S(@Nullable String str) {
        this.context = str;
    }

    public final void T(@Nullable Boolean bool) {
        this.isDebugPackage = bool;
    }

    public final void U(@Nullable Boolean bool) {
        this.decodeResult = bool;
    }

    public final void V(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.devManufacturer = str;
    }

    public final void W(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.devModel = str;
    }

    public final void X(@Nullable Long l3) {
        this.groupID = l3;
    }

    public final void Y(@Nullable Boolean bool) {
        this.isInitRequest = bool;
    }

    public final void Z(@Nullable List<String> list) {
        this.keys = list;
    }

    @NotNull
    public final String a(@NotNull String appKey, @Nullable String extraTag, @Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog) {
        Intrinsics.checkParameterIsNotNull(appKey, "appKey");
        String str = "rdelivery" + appKey;
        StringBuilder sb5 = new StringBuilder();
        sb5.append(this.systemId);
        sb5.append("$");
        sb5.append(this.appId);
        sb5.append("$");
        sb5.append(this.pullType.getValue());
        sb5.append("$");
        String str2 = this.logicEnvironment;
        if (str2 == null) {
            str2 = "";
        }
        sb5.append(str2);
        sb5.append("$");
        sb5.append(this.timestamp);
        sb5.append("$");
        sb5.append(this.userId);
        sb5.append("$");
        sb5.append(str);
        String sb6 = sb5.toString();
        Intrinsics.checkExpressionValueIsNotNull(sb6, "StringBuilder().append(s\u2026              .toString()");
        String a16 = com.tencent.rdelivery.util.e.f364656a.a(sb6);
        if (logger != null) {
            logger.a(com.tencent.rdelivery.util.d.a("RDeliveryRequest", extraTag), "generateSign " + a16, doPrintLog);
        }
        return a16;
    }

    public final void a0(@Nullable m mVar) {
        this.listener = mVar;
    }

    @Nullable
    /* renamed from: b, reason: from getter */
    public final Key getAesKey() {
        return this.aesKey;
    }

    public final void b0(@Nullable String str) {
        this.logicEnvironment = str;
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final String getAndroidSystemVersion() {
        return this.androidSystemVersion;
    }

    public final void c0(@Nullable iz3.j jVar) {
        this.mergePullRequestResultListener = jVar;
    }

    @NotNull
    /* renamed from: d, reason: from getter */
    public final String getAppId() {
        return this.appId;
    }

    public final void d0(@Nullable Long l3) {
        this.mergeReqId = l3;
    }

    @NotNull
    /* renamed from: e, reason: from getter */
    public final String getAppVersion() {
        return this.appVersion;
    }

    public final void e0(@Nullable BaseProto$ConfigType baseProto$ConfigType) {
        this.pullDataType = baseProto$ConfigType;
    }

    @NotNull
    public final Map<String, String> f() {
        return this.customProperties;
    }

    public final void f0(@Nullable BaseProto$PullTarget baseProto$PullTarget) {
        this.pullTarget = baseProto$PullTarget;
    }

    @Nullable
    /* renamed from: g, reason: from getter */
    public final Boolean getDecodeResult() {
        return this.decodeResult;
    }

    public final void g0(@NotNull BaseProto$PullType baseProto$PullType) {
        Intrinsics.checkParameterIsNotNull(baseProto$PullType, "<set-?>");
        this.pullType = baseProto$PullType;
    }

    @NotNull
    /* renamed from: h, reason: from getter */
    public final String getDevManufacturer() {
        return this.devManufacturer;
    }

    public final void h0(@Nullable String str) {
        this.qimei = str;
    }

    @NotNull
    /* renamed from: i, reason: from getter */
    public final String getDevModel() {
        return this.devModel;
    }

    public final void i0(int i3) {
        this.reportSampling = i3;
    }

    @NotNull
    public final String j(boolean enableEncrypt, @Nullable com.tencent.rdelivery.util.c logger, boolean doPrintLog, @Nullable String extraTag) {
        if (enableEncrypt) {
            return D(logger, doPrintLog, extraTag);
        }
        return z();
    }

    public final void j0(int i3) {
        this.reqSize = i3;
    }

    @Nullable
    /* renamed from: k, reason: from getter */
    public final Long getGroupID() {
        return this.groupID;
    }

    public final void k0(long j3) {
        this.requestDequeueTS = j3;
    }

    @Nullable
    public final List<String> l() {
        return this.keys;
    }

    public final void l0(long j3) {
        this.requestEnqueueTS = j3;
    }

    @Nullable
    /* renamed from: m, reason: from getter */
    public final m getListener() {
        return this.listener;
    }

    public final void m0(long j3) {
        this.requestExecuteTS = j3;
    }

    @Nullable
    /* renamed from: n, reason: from getter */
    public final String getLogicEnvironment() {
        return this.logicEnvironment;
    }

    public final void n0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.requestId = str;
    }

    @Nullable
    /* renamed from: o, reason: from getter */
    public final iz3.j getMergePullRequestResultListener() {
        return this.mergePullRequestResultListener;
    }

    public final void o0(@Nullable RequestSource requestSource) {
        this.requestSrc = requestSource;
    }

    @Nullable
    /* renamed from: p, reason: from getter */
    public final Long getMergeReqId() {
        return this.mergeReqId;
    }

    public final void p0(@Nullable Long l3) {
        this.respDecFinishTS = l3;
    }

    @Nullable
    /* renamed from: q, reason: from getter */
    public final BaseProto$PullTarget getPullTarget() {
        return this.pullTarget;
    }

    public final void q0(long j3) {
        this.responseTS = j3;
    }

    @NotNull
    /* renamed from: r, reason: from getter */
    public final BaseProto$PullType getPullType() {
        return this.pullType;
    }

    public final void r0(@Nullable String str) {
        this.sign = str;
    }

    @Nullable
    /* renamed from: s, reason: from getter */
    public final String getQimei() {
        return this.qimei;
    }

    public final void s0(@Nullable JSONObject jSONObject) {
        this.subSystemBizParams = jSONObject;
    }

    /* renamed from: t, reason: from getter */
    public final int getReportSampling() {
        return this.reportSampling;
    }

    public final void t0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.systemId = str;
    }

    /* renamed from: u, reason: from getter */
    public final int getReqSize() {
        return this.reqSize;
    }

    public final void u0(@Nullable Long l3) {
        this.taskCheckCount = l3;
    }

    /* renamed from: v, reason: from getter */
    public final long getRequestDequeueTS() {
        return this.requestDequeueTS;
    }

    public final void v0(@Nullable Long l3) {
        this.taskChecksum = l3;
    }

    /* renamed from: w, reason: from getter */
    public final long getRequestEnqueueTS() {
        return this.requestEnqueueTS;
    }

    public final void w0(@Nullable Long l3) {
        this.timestamp = l3;
    }

    /* renamed from: x, reason: from getter */
    public final long getRequestExecuteTS() {
        return this.requestExecuteTS;
    }

    public final void x0(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.userId = str;
    }

    @NotNull
    /* renamed from: y, reason: from getter */
    public final String getRequestId() {
        return this.requestId;
    }

    public final void y0(@Nullable String str) {
        this.uuid = str;
    }

    @NotNull
    public final String z() {
        BaseProto$Platform baseProto$Platform;
        Integer num;
        JSONObject jSONObject = new JSONObject();
        if (this.isAPad) {
            baseProto$Platform = BaseProto$Platform.APAD;
        } else {
            baseProto$Platform = BaseProto$Platform.ANDROID;
        }
        jSONObject.put("platform", baseProto$Platform.getValue());
        Locale locale = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(locale, "Locale.getDefault()");
        jSONObject.put(IjkMediaMeta.IJKM_KEY_LANGUAGE, locale.getLanguage());
        jSONObject.put("sdkVersion", "1.3.36-RC01");
        jSONObject.put("guid", this.userId);
        jSONObject.put("appVersion", this.appVersion);
        jSONObject.put("osVersion", this.androidSystemVersion);
        jSONObject.putOpt("is64Bit", this.is64Bit);
        jSONObject.put("bundleId", this.bundleId);
        jSONObject.putOpt(TVKLiveRequestBuilder.RequestParamKey.QIMEI36, this.qimei);
        jSONObject.putOpt(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_UNIQUE_ID, this.uuid);
        if (!TextUtils.isEmpty(this.devManufacturer)) {
            jSONObject.putOpt("manufacturer", this.devManufacturer);
        }
        if (!TextUtils.isEmpty(this.devModel)) {
            jSONObject.putOpt("model", this.devModel);
        }
        JSONObject jSONObject2 = new JSONObject();
        for (Map.Entry<String, String> entry : this.customProperties.entrySet()) {
            jSONObject2.putOpt(entry.getKey(), entry.getValue());
        }
        JSONObject jSONObject3 = new JSONObject();
        BaseProto$PullType baseProto$PullType = this.pullType;
        if (baseProto$PullType == BaseProto$PullType.GROUP) {
            jSONObject3.putOpt("groupID", String.valueOf(this.groupID));
        } else if (baseProto$PullType == BaseProto$PullType.CONFIG) {
            jSONObject3.putOpt("keys", new JSONArray((Collection) this.keys));
        }
        jSONObject3.putOpt(Constants.Service.PROPERTIES, jSONObject);
        jSONObject3.putOpt("isDebugPackage", this.isDebugPackage);
        jSONObject3.putOpt("customProperties", jSONObject2);
        JSONObject jSONObject4 = new JSONObject();
        jSONObject4.putOpt("systemID", this.systemId);
        jSONObject4.putOpt("appID", this.appId);
        jSONObject4.putOpt("sign", this.sign);
        jSONObject4.putOpt("timestamp", this.timestamp);
        jSONObject4.putOpt("pullType", Integer.valueOf(this.pullType.getValue()));
        BaseProto$PullTarget baseProto$PullTarget = this.pullTarget;
        Integer num2 = null;
        if (baseProto$PullTarget != null) {
            num = Integer.valueOf(baseProto$PullTarget.getValue());
        } else {
            num = null;
        }
        jSONObject4.putOpt("target", num);
        BaseProto$ConfigType baseProto$ConfigType = this.pullDataType;
        if (baseProto$ConfigType != null) {
            num2 = Integer.valueOf(baseProto$ConfigType.getValue());
        }
        jSONObject4.putOpt("configType", num2);
        jSONObject4.putOpt("pullParams", jSONObject3);
        jSONObject4.putOpt(MosaicConstants$JsProperty.PROP_ENV, this.logicEnvironment);
        Long l3 = this.taskChecksum;
        if (l3 != null) {
            jSONObject4.putOpt("taskChecksum", String.valueOf(l3.longValue()));
        }
        Long l16 = this.taskCheckCount;
        if (l16 != null) {
            long longValue = l16.longValue();
            if (longValue >= 0) {
                jSONObject4.putOpt("taskCheckCount", Long.valueOf(longValue));
            }
        }
        jSONObject4.putOpt("systemBizParams", H());
        jSONObject4.putOpt("context", this.context);
        String jSONObject5 = jSONObject4.toString();
        Intrinsics.checkExpressionValueIsNotNull(jSONObject5, "request.toString()");
        return jSONObject5;
    }
}
