package com.tencent.ecommerce.biz.hr.module;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.Window;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.heytap.databaseengine.type.DeviceType;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.account.api.IECAccountManager;
import com.tencent.ecommerce.base.imageloader.api.IECPagSoLoader;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaSelectorConfig;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECTabType;
import com.tencent.ecommerce.base.proto.ECPBParser;
import com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequestCallback;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.base.report.api.IECDtReport;
import com.tencent.ecommerce.base.router.api.IECSchemeCallback;
import com.tencent.ecommerce.base.ui.ECSkin;
import com.tencent.ecommerce.base.ui.SoftKeyboardStateHelper;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.api.IECCoreSkinApi;
import com.tencent.ecommerce.base.utils.ECThreadUtilKt;
import com.tencent.ecommerce.base.videnevent.api.IECVideoControlDelegate;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import com.tencent.ecommerce.biz.comment.UploadStateListener;
import com.tencent.ecommerce.biz.common.ECMsgBox;
import com.tencent.ecommerce.biz.consumer.ECGoodsCommonUtils;
import com.tencent.ecommerce.biz.consumer.IECGameProxy;
import com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver;
import com.tencent.ecommerce.biz.detail.ui.view.ECShopDetailServiceFragment;
import com.tencent.ecommerce.biz.guild.api.IECGuildApi;
import com.tencent.ecommerce.biz.hr.ECHRFragment;
import com.tencent.ecommerce.biz.hr.ECHippyRenderView;
import com.tencent.ecommerce.biz.hr.ktx.HRResourceExtKt;
import com.tencent.ecommerce.biz.lucy.ILucyApi;
import com.tencent.ecommerce.biz.orders.address.ECAddress;
import com.tencent.ecommerce.biz.pay.api.IECVasPayObserver;
import com.tencent.ecommerce.biz.pay.api.IECVasRechargeApi;
import com.tencent.ecommerce.biz.qcircle.api.IECQCircleApi;
import com.tencent.ecommerce.biz.qq.api.IECQQApi;
import com.tencent.ecommerce.biz.qtroop.api.IECQTroopServiceApi;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import com.tencent.ecommerce.biz.router.ECScheme;
import com.tencent.ecommerce.biz.submitsucceed.ECSubmitSucceedFragment;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedFrom;
import com.tencent.ecommerce.biz.submitsucceed.SubmitSucceedUIState;
import com.tencent.ecommerce.biz.util.r;
import com.tencent.ecommerce.biz.vibration.api.IECVibrationApi;
import com.tencent.ecommerce.biz.vibration.api.VibrationMode;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.kuikly.core.render.android.css.ktx.KRCSSViewExtensionKt;
import com.tencent.lbssearch.object.result.DistrictResultObject;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.report.MiniAppDesktopDtReportHelper;
import com.tencent.mobileqq.mini.servlet.MiniAppSendSmsCodeServlet;
import com.tencent.mobileqq.minigame.kuikly.MiniGameKuiklyModule;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.VRReportDefine$ReportParam;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qmethod.pandoraex.monitor.ClipboardMonitor;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qqmini.sdk.launcher.core.proxy.PayProxy;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import cooperation.qzone.remote.ServiceConst;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import d01.u;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Marker;
import qg0.ECQQLiveSSOResponse;
import si0.ECTroopInfo;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b0\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u0099\u00012\u00020\u0001:\u0002\u009a\u0001B\t\u00a2\u0006\u0006\b\u0097\u0001\u0010\u0098\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016JI\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0016J?\u0010\u000f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J?\u0010\u0011\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010\u0012\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0013\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0014\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J?\u0010\u0016\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010\u0017\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u0019\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001a\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001c\u001a\u00020\u001b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\u001d\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\u001e\u001a\u00020\u0004H\u0002J\u0012\u0010\u001f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010!\u001a\u00020\u0002H\u0002J?\u0010\"\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010#\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010$\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010%\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010&\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010'\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010(\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010)\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010*\u001a\u00020\u0004H\u0002J\u0012\u0010+\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010,\u001a\u00020\u0004H\u0002J\b\u0010-\u001a\u00020\u0002H\u0002J\u0012\u0010.\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010/\u001a\u00020\u0004H\u0002J\b\u00100\u001a\u00020\u0004H\u0002J\b\u00101\u001a\u00020\u0004H\u0002J?\u00102\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u00103\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00104\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00105\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u00106\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J?\u00107\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J5\u00108\u001a\u00020\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J5\u00109\u001a\u00020\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010:\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010;\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u001a\u0010=\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010<\u001a\u00020\u0004H\u0002J\u0012\u0010>\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010?\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010@\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010A\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010B\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010C\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010D\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010E\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010F\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010G\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010H\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010I\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J?\u0010J\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J0\u0010P\u001a\u00020\u00022\u0006\u0010K\u001a\u00020\u00042\u0012\u0010M\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0L2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010NH\u0002J\u0012\u0010Q\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J?\u0010R\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010S\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010T\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010U\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010V\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u0010W\u001a\u00020\u0004H\u0002J\u0012\u0010X\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010Y\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040]2\u0006\u0010Z\u001a\u00020\u00042\u0006\u0010\\\u001a\u00020[H\u0002J\u0012\u0010_\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010`\u001a\u00020\u0004H\u0002J5\u0010a\u001a\u00020\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J5\u0010b\u001a\u00020\u00022+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\u0012\u0010c\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010d\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010e\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010f\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J?\u0010g\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010h\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010i\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u0010j\u001a\u00020\u0004H\u0002J\u0010\u0010m\u001a\u00020\u00022\u0006\u0010l\u001a\u00020kH\u0002J\u0012\u0010o\u001a\u00020\u00022\b\u0010n\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010q\u001a\u00020\u00022\b\u0010p\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010s\u001a\u00020\u00022\b\u0010r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010t\u001a\u00020\u00022\b\u0010r\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010u\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010v\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010w\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010x\u001a\u00020\u00022\b\u0010r\u001a\u0004\u0018\u00010\u0004H\u0002J?\u0010y\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010z\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J?\u0010{\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042+\u0010\r\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\fH\u0002J\b\u0010|\u001a\u00020\u0002H\u0002J\b\u0010}\u001a\u00020\u0002H\u0002J\b\u0010~\u001a\u00020\u0002H\u0002J\b\u0010\u007f\u001a\u00020\u0002H\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0002H\u0002J\t\u0010\u0081\u0001\u001a\u00020\u0002H\u0002J\u000e\u0010\u0083\u0001\u001a\u00020k*\u00030\u0082\u0001H\u0002J\u000e\u0010\u0085\u0001\u001a\u00020k*\u00030\u0084\u0001H\u0002J\u000e\u0010\u0087\u0001\u001a\u00020k*\u00030\u0086\u0001H\u0002J\u0010\u0010\u0088\u0001\u001a\u0005\u0018\u00010\u0086\u0001*\u00020kH\u0002R!\u0010\u008e\u0001\u001a\u00030\u0089\u00018FX\u0086\u0084\u0002\u00a2\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u008b\u0001\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001RK\u0010\u0092\u0001\u001a4\u0012\u0004\u0012\u00020\u0004\u0012)\u0012'\u0012\u0015\u0012\u0013\u0018\u00010\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0007j\u0004\u0018\u0001`\f0\u008f\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0093\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001\u00a8\u0006\u009b\u0001"}, d2 = {"Lcom/tencent/ecommerce/biz/hr/module/HRBridgeModule;", "Li01/e;", "", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "method", "params", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "result", "Lcom/tencent/kuikly/core/render/android/export/KuiklyRenderCallback;", "callback", "call", "e0", "b0", "O", "c0", "a0", "i0", "j0", "P", "N", "i", "j", "h0", "", "y", "N0", "L", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t0", "i1", "A0", "K", ICustomDataEditor.STRING_ARRAY_PARAM_1, "m0", "O0", "M0", BdhLogUtil.LogTag.Tag_Req, "M", "X0", "E", "h1", BdhLogUtil.LogTag.Tag_Conn, "D", UserInfo.SEX_FEMALE, "G", "u0", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "k1", "j1", "o", "k0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "n0", "q0", "postfix", "s0", "o0", "p0", "r0", HippyTKDListViewAdapter.X, "H0", "I0", "G0", "J0", "F0", "V", "g1", "t", "f0", "url", "", "userData", "Lcom/tencent/ecommerce/base/router/api/IECSchemeCallback;", "ecSchemeCallback", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "r", "W0", "Z0", "p", "B0", "U", "P0", "u", "v", "cmd", "", "useOriginalPath", "Lkotlin/Pair;", "l0", "d0", "w", "H", "I", "K0", "L0", "E0", "W", "X", "Z", "Y", "J", "Lorg/json/JSONObject;", "msgBoxJson", "Y0", "photoBrowserConfigStr", "g0", "feedLike", "v0", "stFeed", "w0", "y0", "z0", ExifInterface.LATITUDE_SOUTH, "T", "x0", "D0", "C0", "b1", "Q0", "U0", "V0", "R0", "T0", "S0", "Lcom/tencent/lbssearch/object/result/DistrictResultObject;", "f1", "Lcom/tencent/lbssearch/object/result/DistrictResultObject$DistrictResult;", "e1", "Lcom/tencent/ecommerce/biz/orders/address/ECAddress;", "d1", "c1", "Lcom/tencent/ecommerce/biz/hr/module/f;", "d", "Lkotlin/Lazy;", "B", "()Lcom/tencent/ecommerce/biz/hr/module/f;", "notifyModule", "", "e", "Ljava/util/Map;", "gameCallbackMap", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "f", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "gameEventListener", "<init>", "()V", tl.h.F, "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRBridgeModule extends i01.e {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Lazy notifyModule;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private Map<String, Function1<Object, Unit>> gameCallbackMap;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private IECGameEventReceiver gameEventListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/biz/hr/module/cir/a;", "Lorg/json/JSONObject;", "params", "", WadlProxyConsts.CHANNEL, "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<com.tencent.ecommerce.biz.hr.module.cir.a, JSONObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ com.tencent.ecommerce.biz.hr.module.cir.a f102583a;

        b(com.tencent.ecommerce.biz.hr.module.cir.a aVar) {
            this.f102583a = aVar;
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public JSONObject decodeResponse(byte[] rsp) {
            return this.f102583a.a(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(com.tencent.ecommerce.biz.hr.module.cir.a params, int channel, JSONObject reqExt) {
            return params.b();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$c", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Lcom/tencent/ecommerce/biz/hr/module/cir/a;", "Lorg/json/JSONObject;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class c implements IECNetworkCallback<com.tencent.ecommerce.biz.hr.module.cir.a, JSONObject> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f102584a;

        c(Function1 function1) {
            this.f102584a = function1;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(com.tencent.ecommerce.biz.hr.module.cir.a reqModel, ECRemoteResponse errorResponse) {
            Map mapOf;
            Function1 function1 = this.f102584a;
            if (function1 != null) {
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errorMsg", errorResponse.getMsg()), TuplesKt.to("errorCode", Integer.valueOf(errorResponse.getCode())));
            }
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(com.tencent.ecommerce.biz.hr.module.cir.a reqModel, JSONObject respModel) {
            Function1 function1 = this.f102584a;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", respModel.toString());
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0002H\u0016\u00a8\u0006\n\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$openVasRechargePanel$2$1", "Lcom/tencent/ecommerce/biz/pay/api/IECVasPayObserver;", "", "onOpenPayViewFail", "onOpenPayViewSuccess", "onPaySuccess", "", "code", "onPayError", "onPayViewClose", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class d implements IECVasPayObserver {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ JSONObject f102586b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f102587c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1 f102588d;

        d(JSONObject jSONObject, JSONObject jSONObject2, Function1 function1) {
            this.f102586b = jSONObject;
            this.f102587c = jSONObject2;
            this.f102588d = function1;
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECVasPayObserver
        public void onOpenPayViewFail() {
            cg0.a.b("HRBridgeModule", "[openVasRechargePanel] onOpenPayViewFail invoked");
            Function1 function1 = this.f102588d;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VRReportDefine$ReportParam.IS_SUCCESS, "0");
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECVasPayObserver
        public void onOpenPayViewSuccess() {
            cg0.a.b("HRBridgeModule", "[openVasRechargePanel] onOpenPayViewSuccess invoked");
            Function1 function1 = this.f102588d;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VRReportDefine$ReportParam.IS_SUCCESS, "1");
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECVasPayObserver
        public void onPayError(int code) {
            cg0.a.b("HRBridgeModule", "[openVasRechargePanel] onPayError invoked, code = " + code);
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECVasPayObserver
        public void onPaySuccess() {
            cg0.a.b("HRBridgeModule", "[openVasRechargePanel] onPaySuccess invoked");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(AdMetricTag.EVENT_NAME, "VASTopUpScuccessfullyNotify");
            HRBridgeModule.this.B().call("postNotify", jSONObject.toString(), (Function1<Object, Unit>) null);
        }

        @Override // com.tencent.ecommerce.biz.pay.api.IECVasPayObserver
        public void onPayViewClose() {
            cg0.a.b("HRBridgeModule", "[openVasRechargePanel] onPayViewClose invoked");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$e", "Lcom/tencent/ecommerce/base/qqlivesso/api/IECQQLiveSSORequestCallback;", "Lqg0/a;", "response", "", "onResult", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class e implements IECQQLiveSSORequestCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f102589a;

        e(Function1 function1) {
            this.f102589a = function1;
        }

        @Override // com.tencent.ecommerce.base.qqlivesso.api.IECQQLiveSSORequestCallback
        public void onResult(ECQQLiveSSOResponse response) {
            boolean isSuccess = response.getIsSuccess();
            Function1 function1 = this.f102589a;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("success", isSuccess ? 1 : 0);
                jSONObject.put("data", response.getData());
                jSONObject.put("errorCode", response.getErrorCode());
                jSONObject.put("errorMsg", response.getErrorMsg());
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$f", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "", "appId", "", "progress", "taskStatus", "", "onDownloadStatusChanged", "subscribeStatus", "followStatus", "onSubscribeStatus", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class f implements IECGameEventReceiver {
        f() {
        }

        @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
        public void onDownloadStatusChanged(String appId, int progress, int taskStatus) {
            cg0.a.b("HRBridgeModule", "gameEventLister onDownloadStatusChanged appId:" + appId + ", taskStatus:" + taskStatus + ", progress:" + progress);
            Iterator it = HRBridgeModule.this.gameCallbackMap.entrySet().iterator();
            while (it.hasNext()) {
                Function1 function1 = (Function1) ((Map.Entry) it.next()).getValue();
                if (function1 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("appId", appId);
                    jSONObject.put("taskStatus", taskStatus);
                    jSONObject.put("progress", progress);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }

        @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
        public void onSubscribeStatus(String appId, int subscribeStatus, int followStatus) {
            cg0.a.b("HRBridgeModule", "gameEventLister onSubscribeStatus appId:" + appId + ", subscribeStatus:" + subscribeStatus + ", followStatus:" + followStatus);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$g", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "", "downloadAppId", "", "progress", "taskStatus", "", "onDownloadStatusChanged", "subscribeAppId", "subscribeStatus", "followStatus", "onSubscribeStatus", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class g implements IECGameEventReceiver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f102591d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f102592e;

        g(String str, Function1 function1) {
            this.f102591d = str;
            this.f102592e = function1;
        }

        @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
        public void onDownloadStatusChanged(String downloadAppId, int progress, int taskStatus) {
            if (!Intrinsics.areEqual(this.f102591d, downloadAppId)) {
                cg0.a.b("HRBridgeModule", "queryGameSubscribeStatus onSubscribeStatus return by appId incorrect appid:" + downloadAppId + ", status:" + taskStatus + ", progress:" + progress);
                return;
            }
            cg0.a.b("HRBridgeModule", "queryGameSubscribeStatus onDownloadStatusChanged appId:" + this.f102591d + ", status:" + taskStatus + ", progress:" + progress);
            Function1 function1 = this.f102592e;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("taskStatus", taskStatus);
                jSONObject.put("progress", progress);
                Unit unit = Unit.INSTANCE;
            }
        }

        @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
        public void onSubscribeStatus(String subscribeAppId, int subscribeStatus, int followStatus) {
            if (!Intrinsics.areEqual(this.f102591d, subscribeAppId)) {
                cg0.a.b("HRBridgeModule", "queryGameSubscribeStatus onSubscribeStatus return by appId incorrect appid:" + this.f102591d + ",subscribeAppId:" + subscribeAppId);
                return;
            }
            cg0.a.b("HRBridgeModule", "queryGameSubscribeStatus onSubscribeStatus appId:" + this.f102591d + ", status:" + subscribeStatus + ", followStatus:" + followStatus);
            Function1 function1 = this.f102592e;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subscribeStatus", subscribeStatus);
                jSONObject.put("followStatus", followStatus);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\f\u0012\u0004\u0012\u00020\u00020\u0001j\u0002`\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u0005\u00b8\u0006\u0000"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$showSignAlert$1$onBackPressed$1", "Lkotlin/Function0;", "", "Lcom/tencent/ecommerce/base/ui/ISimpleChatDialogOnBackPressed;", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class h implements Function0<Unit> {

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ JSONObject f102594e;

        h(JSONObject jSONObject) {
            this.f102594e = jSONObject;
        }

        public void a() {
            Activity activity = HRBridgeModule.this.getActivity();
            if (activity != null) {
                activity.finish();
            }
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001c\u0010\u000b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$i", "Lcom/tencent/ecommerce/base/network/service/IECJsonNetworkCallback;", "Lorg/json/JSONObject;", "reqParams", "respData", "", MiniAppDesktopDtReportHelper.DT_MINI_TRACE_INFO, "", "onSuccess", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "onError", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class i implements IECJsonNetworkCallback {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1 f102595a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Pair f102596b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f102597c;

        i(Function1 function1, Pair pair, JSONObject jSONObject) {
            this.f102595a = function1;
            this.f102596b = pair;
            this.f102597c = jSONObject;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onError(JSONObject reqParams, ECRemoteResponse errorResponse) {
            String str;
            Map mapOf;
            StringBuilder sb5 = new StringBuilder();
            sb5.append("on HR ssoRequest error, cmd: ");
            sb5.append(this.f102596b);
            sb5.append(", param: ");
            sb5.append(this.f102597c);
            sb5.append(", error: ");
            sb5.append(errorResponse != null ? errorResponse.getMsg() : null);
            cg0.a.b("HRBridgeModule", sb5.toString());
            Function1 function1 = this.f102595a;
            if (function1 != null) {
                Pair[] pairArr = new Pair[2];
                if (errorResponse == null || (str = errorResponse.getMsg()) == null) {
                    str = "";
                }
                pairArr[0] = TuplesKt.to("errorMsg", str);
                pairArr[1] = TuplesKt.to("errorCode", Integer.valueOf(errorResponse != null ? errorResponse.getCode() : -1));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
            }
        }

        @Override // com.tencent.ecommerce.base.network.service.IECJsonNetworkCallback
        public void onSuccess(JSONObject reqParams, JSONObject respData, String traceInfo) {
            Function1 function1 = this.f102595a;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("data", String.valueOf(respData));
                Unit unit = Unit.INSTANCE;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("sso success, cmdMethod: ");
            sb5.append((String) this.f102596b.getSecond());
            sb5.append(", data: ");
            sb5.append(respData != null ? respData.toString() : null);
            cg0.a.b("HRBridgeModule", sb5.toString());
        }
    }

    public HRBridgeModule() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.ecommerce.biz.hr.module.f>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$notifyModule$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final f invoke() {
                return new f();
            }
        });
        this.notifyModule = lazy;
        this.gameCallbackMap = new LinkedHashMap();
    }

    private final void A(final Function1<Object, Unit> callback) {
        Context context = getContext();
        if (context != null) {
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLocationService().requestFullDistrictList(context, new Function3<Integer, String, DistrictResultObject, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$getFullMapInfo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, DistrictResultObject districtResultObject) {
                    invoke(num.intValue(), str, districtResultObject);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, String str, DistrictResultObject districtResultObject) {
                    if (i3 != 0) {
                        cg0.a.b("HRBridgeModule", "[getFullMapInfo] getError: " + i3 + ", msg: " + str);
                        Function1 function1 = callback;
                        if (function1 != null) {
                            return;
                        }
                        return;
                    }
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("[getFullMapInfo] success: info = ");
                    sb5.append(districtResultObject != null ? HRBridgeModule.this.f1(districtResultObject) : null);
                    cg0.a.b("HRBridgeModule", sb5.toString());
                    Function1 function12 = callback;
                    if (function12 != null) {
                    }
                }
            });
        }
    }

    private final void A0(String params) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString("content");
        if (optString != null) {
            com.tencent.ecommerce.base.ui.i.f101155b.b(optString, k06.optInt("mode"));
        }
    }

    private final void C0(String params, Function1<Object, Unit> callback) {
        cg0.a.b("HRBridgeModule", "queryGameDownloadTaskStatus params:" + params);
        String optString = KRCSSViewExtensionKt.k0(params).optString("appId");
        if (ECGoodsCommonUtils.f101579a.b(optString)) {
            if (this.gameEventListener == null) {
                this.gameEventListener = new f();
                IECGameProxy gameProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy();
                IECGameEventReceiver iECGameEventReceiver = this.gameEventListener;
                if (iECGameEventReceiver != null) {
                    gameProxy.registerGameListener(iECGameEventReceiver);
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver");
                }
            }
            this.gameCallbackMap.put(optString, callback);
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doQuerySingleTask(optString);
        }
    }

    private final String D() {
        String deviceInfo;
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        return (qCircleApi == null || (deviceInfo = qCircleApi.getDeviceInfo()) == null) ? "" : deviceInfo;
    }

    private final void D0(String params, Function1<Object, Unit> callback) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString("appId");
        String optString2 = k06.optString("channelId");
        if (ECGoodsCommonUtils.f101579a.b(optString, optString2)) {
            g gVar = new g(optString, callback);
            cg0.a.b("HRBridgeModule", "queryGameStatus onSubscribeStatus start query appId=" + optString + ", channelId:" + optString2);
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().querySubscribeStatusForKTV(optString, optString2, gVar);
        }
    }

    private final String E() {
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        if (qCircleApi != null ? qCircleApi.getFeedMuteConfig() : true) {
            return "1";
        }
        return "0";
    }

    private final String F() {
        String pluginQua;
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        return (qCircleApi == null || (pluginQua = qCircleApi.getPluginQua()) == null) ? "" : pluginQua;
    }

    private final String G() {
        String qua;
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        return (qCircleApi == null || (qua = qCircleApi.getQua()) == null) ? "" : qua;
    }

    private final void H(Function1<Object, Unit> callback) {
        Map mapOf;
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        int qQCirCurrentTabIndex = qCircleApi != null ? qCircleApi.getQQCirCurrentTabIndex() : 0;
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("index", Integer.valueOf(qQCirCurrentTabIndex)));
            callback.invoke(mapOf);
        }
    }

    private final void I(Function1<Object, Unit> callback) {
        Map mapOf;
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        int qQTabCurrentIndex = qCircleApi != null ? qCircleApi.getQQTabCurrentIndex() : 0;
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("index", Integer.valueOf(qQTabCurrentIndex)));
            callback.invoke(mapOf);
        }
    }

    private final String J() {
        IECAccountManager accountManager = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("uin", accountManager.getCurrentAccount());
        jSONObject.put("nickName", accountManager.getCurrentAccountNickName());
        jSONObject.put("headUrl", accountManager.getCurrentAccountHeadUrl());
        return jSONObject.toString();
    }

    private final String K(String params) {
        String optString = KRCSSViewExtensionKt.k0(params).optString(PushClientConstants.TAG_PKG_NAME, "");
        String str = "0";
        if (getContext() == null) {
            if (optString == null || optString.length() == 0) {
                return "0";
            }
        }
        IECGameProxy gameProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy();
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        if (gameProxy.isAppInstalled(context, optString)) {
            str = "1";
        }
        cg0.a.b("HRBridgeModule", "isAppInstalled params:" + params + " result:" + str);
        return str;
    }

    private final String L() {
        IECResourceApi resourceApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getResourceApi();
        if (resourceApi != null ? resourceApi.isVasTheme() : false) {
            return "1";
        }
        return "0";
    }

    private final String M() {
        IECGameProxy gameProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy();
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        if (gameProxy.isWifiConnected(context)) {
            return "1";
        }
        return "0";
    }

    private final void M0(String params) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doInstallAction(k06.optString("appId", ""), k06.optString(PushClientConstants.TAG_PKG_NAME, ""), k06.optString("appName", ""), k06.optString("channelId", ""), k06.optString("downloadUrl", ""));
        cg0.a.b("HRBridgeModule", "requestInstallApp params:" + params);
    }

    private final void N(String params, final Function1<Object, Unit> callback) {
        IECQQApi qqApi;
        Context context = getContext();
        if (context == null || (qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        qqApi.joinDaZi(context, params, new Function2<Integer, String, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$joinDaZi$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String str) {
                Function1 function1 = Function1.this;
                if (function1 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", i3);
                    jSONObject.put("msg", str);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    private final void N0(String params) {
        JSONObject optJSONObject = KRCSSViewExtensionKt.k0(params).optJSONObject("reqParams");
        String optString = optJSONObject.optString("business_id");
        String optString2 = optJSONObject.optString(ServiceConst.PARA_SESSION_ID);
        String optString3 = optJSONObject.optString("msg_id");
        int optInt = optJSONObject.optInt("fb_type");
        ILucyApi lucyApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getLucyApi();
        if (lucyApi != null) {
            lucyApi.requestFeedback(optString, optString3, optString2, optInt);
        }
    }

    private final void O(String params, final Function1<Object, Unit> callback) {
        IECGuildApi guildApi;
        Context context = getContext();
        if (context == null || (guildApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGuildApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        guildApi.joinChannel(context, params, new Function1<Integer, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$joinGuildChannel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Function1 function1 = Function1.this;
                if (function1 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", i3);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    private final void O0(String params) {
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doResumeAction(KRCSSViewExtensionKt.k0(params).optString("appId", ""));
        cg0.a.b("HRBridgeModule", "resumeDownloadApp params:" + params);
    }

    private final void P(String params, final Function1<Object, Unit> callback) {
        Integer intOrNull;
        Context context = getContext();
        if (context != null) {
            JSONObject k06 = KRCSSViewExtensionKt.k0(params);
            String optString = k06.optString("troopUin");
            String optString2 = k06.optString("troopName");
            String optString3 = k06.optString("authSign");
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(k06.optString("sourceId"));
            int intValue = intOrNull != null ? intOrNull.intValue() : 0;
            IECQQApi qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
            if (qqApi != null) {
                qqApi.joinTroop(context, optString, optString2, optString3, intValue, new Function2<Integer, String, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$joinTroop$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                        invoke(num.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, String str) {
                        Function1 function1 = Function1.this;
                        if (function1 != null) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("code", i3);
                            jSONObject.put("msg", str);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
            }
        }
    }

    private final String P0() {
        return String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getTicket().getServerTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q(String url, Map<Object, ? extends Object> userData, IECSchemeCallback ecSchemeCallback) {
        if (QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().isMainProcess()) {
            ECScheme.c(url, ecSchemeCallback, userData);
        } else {
            if (userData != null) {
                QQEcommerceSdk.jumpScheme(url, ecSchemeCallback, (HashMap) userData);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
        }
    }

    private final void Q0() {
        Activity activity;
        IECVibrationApi vibrationApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVibrationApi();
        if (vibrationApi == null || (activity = getActivity()) == null) {
            return;
        }
        vibrationApi.vibrate(activity, VibrationMode.ERROR);
    }

    private final void R(String params) {
        String optString = KRCSSViewExtensionKt.k0(params).optString(PushClientConstants.TAG_PKG_NAME, "");
        if (getContext() == null) {
            if (optString == null || optString.length() == 0) {
                return;
            }
        }
        IECGameProxy gameProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy();
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        gameProxy.startApp(context, optString);
        cg0.a.b("HRBridgeModule", "launchApp params:" + params);
    }

    private final void R0() {
        Activity activity;
        IECVibrationApi vibrationApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVibrationApi();
        if (vibrationApi == null || (activity = getActivity()) == null) {
            return;
        }
        vibrationApi.vibrate(activity, VibrationMode.HEAVY);
    }

    private final void S0() {
        Activity activity;
        IECVibrationApi vibrationApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVibrationApi();
        if (vibrationApi == null || (activity = getActivity()) == null) {
            return;
        }
        vibrationApi.vibrate(activity, VibrationMode.LIGHT);
    }

    private final void T0() {
        Activity activity;
        IECVibrationApi vibrationApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVibrationApi();
        if (vibrationApi == null || (activity = getActivity()) == null) {
            return;
        }
        vibrationApi.vibrate(activity, VibrationMode.MEDIUM);
    }

    private final void U(String params, Function1<Object, Unit> callback) {
        Map mapOf;
        double currentTimeMillis = System.currentTimeMillis() / 1000.0d;
        if (callback != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("time", Double.valueOf(currentTimeMillis)));
            callback.invoke(mapOf);
        }
    }

    private final void U0() {
        Activity activity;
        IECVibrationApi vibrationApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVibrationApi();
        if (vibrationApi == null || (activity = getActivity()) == null) {
            return;
        }
        vibrationApi.vibrate(activity, VibrationMode.SUCCESS);
    }

    private final void V0() {
        Activity activity;
        IECVibrationApi vibrationApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVibrationApi();
        if (vibrationApi == null || (activity = getActivity()) == null) {
            return;
        }
        vibrationApi.vibrate(activity, VibrationMode.WARNING);
    }

    private final void X(String params, final Function1<Object, Unit> callback) {
        try {
            JSONObject jSONObject = new JSONObject(params);
            int optInt = jSONObject.optInt("from");
            JSONObject optJSONObject = jSONObject.optJSONObject("addressData");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            final ECAddress c16 = c1(optJSONObject);
            if (c16 == null) {
                com.tencent.ecommerce.biz.orders.address.c.e(optInt, c16, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$openAddressSelector$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                        invoke2(eCAddress);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ECAddress eCAddress) {
                        Function1 function1 = callback;
                        if (function1 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("addressData", eCAddress != null ? HRBridgeModule.this.d1(eCAddress) : null);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                });
                return;
            }
            Activity activity = getActivity();
            if (activity != null) {
                com.tencent.ecommerce.biz.orders.address.c.b(activity, c16.id, false, new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$openAddressSelector$$inlined$let$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                        invoke2(eCAddress);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(ECAddress eCAddress) {
                        Function1 function1 = callback;
                        if (function1 != null) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("addressData", eCAddress != null ? com.tencent.ecommerce.biz.orders.address.b.d(eCAddress) : null);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }, 4, null);
            }
        } catch (JSONException unused) {
            cg0.a.a("HRBridgeModule", "openAddressSelector", "json parse exception: " + params);
        }
    }

    private final void X0(String params) {
        cg0.a.b("HRBridgeModule", "showDownloadNoWifiDialog params:" + params);
        if (getContext() == null) {
            return;
        }
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString("msg", "");
        final boolean optBoolean = k06.optBoolean("isResume", false);
        final String optString2 = k06.optString("appId", "");
        final String optString3 = k06.optString(PushClientConstants.TAG_PKG_NAME, "");
        final String optString4 = k06.optString("appName", "");
        final String optString5 = k06.optString("channelId", "");
        final String optString6 = k06.optString("downloadUrl", "");
        IECGameProxy gameProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy();
        Context context = getContext();
        Intrinsics.checkNotNull(context);
        gameProxy.showNoWifiDialog(context, optString, new Function1<Boolean, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$showDownloadNoWifiDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                if (z16) {
                    if (optBoolean) {
                        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doResumeAction(optString2);
                    } else {
                        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doDownloadAction(optString2, optString3, optString4, optString5, optString6);
                    }
                }
            }
        });
    }

    private final void Y0(JSONObject msgBoxJson) {
        Context context = getContext();
        if (context != null) {
            ECMsgBox eCMsgBox = new ECMsgBox(context, new ri0.e(getActivity(), null), new h(msgBoxJson));
            eCMsgBox.a(msgBoxJson);
            eCMsgBox.c();
        }
    }

    private final void Z(String params, final Function1<Object, Unit> callback) {
        try {
            JSONObject jSONObject = new JSONObject(params);
            int optInt = jSONObject.optInt("from");
            JSONObject optJSONObject = jSONObject.optJSONObject("addressData");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            com.tencent.ecommerce.biz.orders.address.c.e(optInt, c1(optJSONObject), new Function1<ECAddress, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$openEditAddressPage$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ECAddress eCAddress) {
                    invoke2(eCAddress);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ECAddress eCAddress) {
                    JSONObject d16;
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(QCircleDaTongConstant.ElementParamValue.OPERATION, eCAddress != null ? 1 : 2);
                    if (eCAddress != null) {
                        d16 = HRBridgeModule.this.d1(eCAddress);
                        jSONObject2.put("addressData", d16);
                    }
                    Function1 function1 = callback;
                    if (function1 != null) {
                    }
                }
            });
        } catch (JSONException unused) {
            cg0.a.a("HRBridgeModule", "openEditAddressPage", "json parse exception: " + params);
        }
    }

    private final void a0(String params) {
        IECGuildApi guildApi;
        Context context = getContext();
        if (context == null || (guildApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGuildApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        guildApi.openArticlePage(context, params);
    }

    private final void a1(String params) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doDownloadAction(k06.optString("appId", ""), k06.optString(PushClientConstants.TAG_PKG_NAME, ""), k06.optString("appName", ""), k06.optString("channelId", ""), k06.optString("downloadUrl", ""));
        cg0.a.b("HRBridgeModule", "startDownloadApp params:" + params);
    }

    private final void b0(String params) {
        IECGuildApi guildApi;
        Context context = getContext();
        if (context == null || (guildApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGuildApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        guildApi.openChannelPage(context, params);
    }

    private final void b1(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            params = "";
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("appId");
        String optString2 = jSONObject.optString("channelId");
        String optString3 = jSONObject.optString(QCircleDaTongConstant.ElementParamValue.OPERATION, "1");
        String optString4 = jSONObject.optString(VasWebviewConstants.KEY_ADTAG, "xiaoshijie_gametab");
        if (ECGoodsCommonUtils.f101579a.b(optString, optString2)) {
            j jVar = new j(optString, callback);
            cg0.a.b("HRBridgeModule", "subscribeGame start appId:" + optString + ", channelId:" + optString2 + ", adTag:" + optString4);
            QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
            qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().registerGameListener(jVar);
            qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().subscribeGame(optString, optString2, optString3, optString4);
        }
    }

    private final void c0(String params) {
        IECGuildApi guildApi;
        Context context = getContext();
        if (context == null || (guildApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGuildApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        guildApi.openSubChannelPage(context, params);
    }

    private final ECAddress c1(JSONObject jSONObject) {
        if (jSONObject.has("id")) {
            return new ECAddress(Long.parseLong(jSONObject.optString("id")), jSONObject.optString("province"), jSONObject.optString("city"), jSONObject.optString("district"), jSONObject.optString("street"), jSONObject.optString("detail_address"), jSONObject.optString("name"), jSONObject.optString(DeviceType.DeviceCategory.MOBILE), jSONObject.optString("masked_mobile"), jSONObject.optInt("is_default") == 1, jSONObject.optString("label"));
        }
        return null;
    }

    private final void d0(String params) {
        JSONObject b16 = com.tencent.ecommerce.base.ktx.e.b(new JSONObject(), params);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("services", b16.optJSONArray("dataArray"));
        String jSONObject2 = jSONObject.toString();
        Bundle bundle = new Bundle();
        bundle.putString("is_trans_activity", "1");
        bundle.putString("service", jSONObject2);
        bundle.putString("title", b16.optString("infoTitle"));
        Context context = getContext();
        if (context == null) {
            context = wg0.a.a();
        }
        yi0.a.p(context, ECShopDetailServiceFragment.class, bundle, 0, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject d1(ECAddress eCAddress) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", String.valueOf(eCAddress.id));
        jSONObject.put("province", eCAddress.province);
        jSONObject.put("city", eCAddress.city);
        jSONObject.put("district", eCAddress.district);
        jSONObject.put("street", eCAddress.street);
        jSONObject.put("detail_address", eCAddress.detailAddress);
        jSONObject.put("name", eCAddress.consignee);
        jSONObject.put(DeviceType.DeviceCategory.MOBILE, eCAddress.phoneNumber);
        jSONObject.put("masked_mobile", eCAddress.maskedPhoneNumber);
        jSONObject.put("is_default", eCAddress.isDefaultAddress ? 1 : 0);
        jSONObject.put("label", eCAddress.label);
        return jSONObject;
    }

    private final void e0(String params, final Function1<Object, Unit> callback) {
        IECQQApi qqApi;
        Context context = getContext();
        if (context == null || (qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        qqApi.openMiniApp(context, params, new Function2<Integer, String, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$openMiniAppPage$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String str) {
                Function1 function1 = Function1.this;
                if (function1 != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("code", i3);
                    jSONObject.put("msg", str);
                    Unit unit = Unit.INSTANCE;
                }
            }
        });
    }

    private final JSONObject e1(DistrictResultObject.DistrictResult districtResult) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", districtResult.f118545id);
        String str = districtResult.name;
        if (str == null) {
            str = "";
        }
        jSONObject.put("name", str);
        String str2 = districtResult.fullname;
        jSONObject.put("fullname", str2 != null ? str2 : "");
        JSONArray jSONArray = new JSONArray();
        List<String> list = districtResult.pinyin;
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                jSONArray.mo162put((String) it.next());
            }
        }
        Unit unit = Unit.INSTANCE;
        jSONObject.put("pinyin", jSONArray);
        JSONArray jSONArray2 = new JSONArray();
        List<Integer> list2 = districtResult.cidx;
        if (list2 != null) {
            Iterator<T> it5 = list2.iterator();
            while (it5.hasNext()) {
                jSONArray2.put(((Integer) it5.next()).intValue());
            }
        }
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("cidx", jSONArray2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final JSONObject f1(DistrictResultObject districtResultObject) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = districtResultObject.result.iterator();
        while (it.hasNext()) {
            List list = (List) it.next();
            JSONArray jSONArray2 = new JSONArray();
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                jSONArray2.mo162put(e1((DistrictResultObject.DistrictResult) it5.next()));
            }
            Unit unit = Unit.INSTANCE;
            jSONArray.mo162put(jSONArray2);
        }
        Unit unit2 = Unit.INSTANCE;
        jSONObject.put("result", jSONArray);
        return jSONObject;
    }

    private final void h0(String params) {
        IECQQApi qqApi;
        Context context = getContext();
        if (context == null || (qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        qqApi.openProfileCard(context, params);
    }

    private final void h1() {
        if (((Number) com.tencent.ecommerce.base.config.service.b.f100655b.b(100320, "enable_download_pag_so", 1)).intValue() == 0) {
            cg0.a.b("HRBridgeModule", "tryDownloadPagSo skipped. remote config is switch off.");
            return;
        }
        cg0.a.b("HRBridgeModule", "tryDownloadPagSo.");
        IECPagSoLoader pagSoLoader = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getPagSoLoader();
        if (pagSoLoader.loadPagSo()) {
            return;
        }
        pagSoLoader.downloadPagSo();
    }

    private final void i(String params) {
        Context context = getContext();
        if (context != null) {
            JSONObject k06 = KRCSSViewExtensionKt.k0(params);
            String optString = k06.optString("uin");
            String optString2 = k06.optString("name");
            IECQQApi qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
            if (qqApi != null) {
                qqApi.addFriend(context, optString2, optString);
            }
        }
    }

    private final void i0(String params) {
        IECQQApi qqApi;
        Context context = getContext();
        if (context == null || (qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        qqApi.openSearchEmoticonPage(context, params);
    }

    private final void i1(String params, Function1<Object, Unit> callback) {
        Context context = getContext();
        if (context != null) {
            JSONObject k06 = KRCSSViewExtensionKt.k0(params);
            CoroutineScope CoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
            BatchUploader batchUploader = new BatchUploader("qplus", new k(), null, null, null, 28, null);
            cg0.a.b("HRBridgeModule", "[uploadSinglePhotoFromAlbum] begin open Media Picker");
            dg0.a.f393682b.openMediaSelector(context, new ECMediaSelectorConfig(ECTabType.ONLY_IMAGE, 1, null, null, 12, null), new HRBridgeModule$uploadSinglePhotoFromAlbum$1(this, CoroutineScope, k06, batchUploader, callback));
        }
    }

    private final void j(String params) {
        IECQQApi qqApi;
        Context context = getContext();
        if (context == null || (qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        qqApi.addFriendWithParams(context, params);
    }

    private final void j0(String params) {
        IECQQApi qqApi;
        Context context = getContext();
        if (context == null || (qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi()) == null) {
            return;
        }
        if (params == null) {
            params = "";
        }
        qqApi.openTroopPage(context, params);
    }

    private final String j1(String params) {
        String optString = KRCSSViewExtensionKt.k0(params).optString(HippyControllerProps.STRING);
        if (optString != null) {
            return URLDecoder.decode(optString);
        }
        return "";
    }

    private final void k0(String params, Function1<Object, Unit> callback) {
        IECVasRechargeApi vasPay;
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        JSONObject optJSONObject = k06.optJSONObject("reportExt");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        JSONObject jSONObject = optJSONObject;
        jSONObject.put("app_id", k06.optInt("appId"));
        jSONObject.put(IECVasRechargeApi.SUB_SCENE_ID, k06.optInt(WadlProxyConsts.SCENE_ID));
        jSONObject.put("source", k06.optInt("sourceId"));
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[openVasRechargePanel] invoke, reportParams = ");
        sb5.append(jSONObject);
        sb5.append(", activity is null = ");
        sb5.append(getActivity() == null);
        cg0.a.b("HRBridgeModule", sb5.toString());
        Activity activity = getActivity();
        if (activity != null && (vasPay = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVasPay()) != null) {
            vasPay.openVasRecharge(activity, k06.optString("title"), k06.optString("appName"), jSONObject, new d(k06, jSONObject, callback));
        }
        if (getActivity() != null || callback == null) {
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(VRReportDefine$ReportParam.IS_SUCCESS, "0");
        Unit unit = Unit.INSTANCE;
        callback.invoke(jSONObject2);
    }

    private final String k1(String params) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        String replace$default4;
        String optString = KRCSSViewExtensionKt.k0(params).optString(HippyControllerProps.STRING);
        if (optString != null) {
            replace$default = StringsKt__StringsJVMKt.replace$default(URLEncoder.encode(optString), Marker.ANY_NON_NULL_MARKER, "%20", false, 4, (Object) null);
            replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "*", "%2A", false, 4, (Object) null);
            replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "%7E", "~", false, 4, (Object) null);
            replace$default4 = StringsKt__StringsJVMKt.replace$default(replace$default3, "/", "%2F", false, 4, (Object) null);
            return replace$default4;
        }
        return "";
    }

    private final String l(String params) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString("msg");
        if (k06.optBoolean("isEncode")) {
            Charset charset = Charsets.UTF_8;
            if (optString != null) {
                byte[] bytes = optString.getBytes(charset);
                Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                return Base64.encodeToString(bytes, 2);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        return new String(Base64.decode(optString, 2), Charsets.UTF_8);
    }

    private final Pair<String, String> l0(String cmd, boolean useOriginalPath) {
        List split$default;
        List list;
        Object last;
        Object last2;
        split$default = StringsKt__StringsKt.split$default((CharSequence) cmd, new String[]{"/"}, false, 0, 6, (Object) null);
        ArrayList arrayList = new ArrayList();
        Iterator it = split$default.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((String) next).length() > 0) {
                arrayList.add(next);
            }
        }
        list = CollectionsKt___CollectionsKt.toList(arrayList);
        if (list.size() < 2 && wg0.a.b()) {
            throw new IllegalArgumentException("cmd param is invalid. cmd = " + cmd);
        }
        String join = TextUtils.join(".", list.subList(0, list.size() - 1));
        StringBuilder sb5 = new StringBuilder();
        sb5.append('/');
        sb5.append(join);
        sb5.append('/');
        last = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
        sb5.append((String) last);
        String sb6 = sb5.toString();
        if (useOriginalPath) {
            last2 = CollectionsKt___CollectionsKt.last((List<? extends Object>) list);
            return new Pair<>(join, last2);
        }
        return new Pair<>(join, sb6);
    }

    private final String m(String params) {
        String str;
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        boolean optBoolean = k06.optBoolean("isEncode");
        JSONArray jSONArray = new JSONArray();
        JSONArray optJSONArray = k06.optJSONArray("msg");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                if (optBoolean) {
                    String optString = optJSONArray.optString(i3);
                    Charset charset = Charsets.UTF_8;
                    if (optString != null) {
                        byte[] bytes = optString.getBytes(charset);
                        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
                        str = Base64.encodeToString(bytes, 2);
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    str = new String(Base64.decode(optJSONArray.optString(i3), 2), Charsets.UTF_8);
                }
                jSONArray.mo162put(str);
            }
        }
        return jSONArray.toString();
    }

    private final void m0(String params) {
        QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().doPauseAction(KRCSSViewExtensionKt.k0(params).optString("appId", ""));
        cg0.a.b("HRBridgeModule", "pauseDownloadApp params:" + params);
    }

    private final void n0(String params) {
        s0(params, ".png");
    }

    private final void o(String params) {
        JSONObject k06 = KRCSSViewExtensionKt.k0(params);
        String optString = k06.optString("circle_feed_id");
        boolean optBoolean = k06.optBoolean("is_showing");
        IECVideoControlDelegate videoControl = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getVideoControl();
        if (videoControl != null) {
            videoControl.sendQCirclePanelStateEvent(optString, optBoolean);
        }
    }

    private final void o0(String params) {
        String optString = KRCSSViewExtensionKt.k0(params).optString("url");
        if (optString.length() == 0) {
            return;
        }
        URLDrawable.getDrawable(optString, URLDrawable.URLDrawableOptions.obtain()).startDownload(false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.CharSequence, T, java.lang.String] */
    private final void p0(String params) {
        List split$default;
        if (params == null) {
            params = "{}";
        }
        ?? optString = new JSONObject(params).optString("urlToken");
        if (optString.length() == 0) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = optString;
        split$default = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        if (true ^ split$default.isEmpty()) {
            objectRef.element = (String) split$default.get(0);
        }
        IECCoreSkinApi.a.a(ECSkin.INSTANCE, (String) objectRef.element, null, new Function1<Drawable, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$preDownloadImageUrlToken$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable) {
                invoke2(drawable);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Drawable drawable) {
                cg0.a.b("preDownloadImageUrlToken", "getDrawable " + ((String) Ref.ObjectRef.this.element));
            }
        }, 2, null);
    }

    private final void q0(String params) {
        s0(params, ".pag");
    }

    private final void r(String params) {
        ECHRFragment b16 = com.tencent.ecommerce.biz.hr.ktx.b.b(this);
        if (b16 != null) {
            b16.gi(params);
            return;
        }
        Activity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.CharSequence, T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v5, types: [T, java.lang.String] */
    private final void r0(String params) {
        List split$default;
        Context context;
        if (params == null) {
            params = "{}";
        }
        ?? optString = new JSONObject(params).optString("urlToken");
        if (optString.length() == 0) {
            return;
        }
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = optString;
        split$default = StringsKt__StringsKt.split$default((CharSequence) optString, new String[]{QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER}, false, 0, 6, (Object) null);
        if (!split$default.isEmpty()) {
            objectRef.element = (String) split$default.get(0);
        }
        String url = ECSkin.INSTANCE.getUrl((String) objectRef.element);
        if (url != null) {
            if (!(url.length() > 0) || (context = getContext()) == null) {
                return;
            }
            HRResourceExtKt.a(context, url, ".pag", new Function1<File, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$preDownloadPAGUrlToken$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(File file) {
                    invoke2(file);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(File file) {
                    cg0.a.b("preDownloadPAGUrlToken", "fetchResourceFile " + ((String) Ref.ObjectRef.this.element));
                }
            });
        }
    }

    private final void s0(String params, String postfix) {
        Context context;
        String optString = KRCSSViewExtensionKt.k0(params).optString("url");
        if ((optString.length() == 0) || (context = getContext()) == null) {
            return;
        }
        HRResourceExtKt.a(context, optString, postfix, new Function1<File, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$preDownloadResourceFile$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(File file) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(File file) {
                invoke2(file);
                return Unit.INSTANCE;
            }
        });
    }

    private final void t0() {
        Context context = getContext();
        if (context != null) {
            dg0.a.f393682b.preLoad(context);
        }
    }

    private final String u(String params) {
        return String.valueOf(System.currentTimeMillis());
    }

    private final String v(String params) {
        if (params == null) {
            params = "{}";
        }
        JSONObject jSONObject = new JSONObject(params);
        return new SimpleDateFormat(jSONObject.optString("format")).format(new Date(jSONObject.optLong(PayProxy.Source.PAY_REQUEST_TIME_STAMP_KEY)));
    }

    private final String w() {
        return String.valueOf(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
    }

    private final String x(String params) {
        if (params == null) {
            params = "";
        }
        return com.tencent.ecommerce.biz.hr.module.e.f102613b.a(new JSONObject(params).optString("key"));
    }

    private final int y(String params) {
        String optString = KRCSSViewExtensionKt.k0(params).optString("uin");
        IECQQApi qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
        if (qqApi != null) {
            return qqApi.getFriendStatus(optString);
        }
        return 0;
    }

    private final void z(Function1<Object, Unit> callback) {
        List<ECTroopInfo> arrayList;
        IECQTroopServiceApi qTroopService = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQTroopService();
        if (qTroopService == null || (arrayList = qTroopService.getTroopList()) == null) {
            arrayList = new ArrayList<>();
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(((ECTroopInfo) it.next()).a());
        }
        if (callback != null) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("groupList", jSONArray);
            Unit unit = Unit.INSTANCE;
            callback.invoke(jSONObject);
        }
    }

    public final com.tencent.ecommerce.biz.hr.module.f B() {
        return (com.tencent.ecommerce.biz.hr.module.f) this.notifyModule.getValue();
    }

    @Override // i01.e, i01.a
    public Object call(String method, String params, Function1<Object, Unit> callback) {
        Map mapOf;
        Map mapOf2;
        Window window;
        Window window2;
        boolean z16 = true;
        switch (method.hashCode()) {
            case -2130355595:
                if (method.equals("requestInstallApp")) {
                    M0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -2053827893:
                if (method.equals("qCircleOpenPersonalDetailPage")) {
                    x0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -2033410357:
                if (method.equals("isVasTheme")) {
                    return L();
                }
                break;
            case -1931275169:
                if (method.equals("showAlert")) {
                    W0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1915759654:
                if (method.equals("joinGuildChannel")) {
                    O(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1885814023:
                if (method.equals("queryGameDownloadTaskStatus")) {
                    C0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1822997679:
                if (method.equals("localServeTime")) {
                    U(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1719416390:
                if (method.equals("preDownloadImageUrlToken")) {
                    p0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1708490788:
                if (method.equals("base64Code")) {
                    return l(params);
                }
                break;
            case -1658123345:
                if (method.equals("openProfileCard")) {
                    h0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1432135197:
                if (method.equals("qCriclePreDownloadVideo")) {
                    z0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1402234666:
                if (method.equals("joinDaZi")) {
                    N(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1394796766:
                if (method.equals("lucyAssistFeedbackRequest")) {
                    N0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1388069597:
                if (method.equals("copyToPasteboard")) {
                    t(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1355268731:
                if (method.equals("qCircleDTReport")) {
                    L0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1341526622:
                if (method.equals("queryGameSubscribeStatus")) {
                    D0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1334458857:
                if (method.equals("reportPageCostTimeForSuccess")) {
                    I0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1188637476:
                if (method.equals("uploadSinglePhotoFromAlbum")) {
                    i1(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1160320250:
                if (method.equals("getFullGroupListInfo")) {
                    z(callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1113515589:
                if (method.equals("preloadPB")) {
                    u0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1061481307:
                if (method.equals("openEditAddressView")) {
                    Z(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -1060266576:
                if (method.equals("callPhone")) {
                    W(params);
                    return Unit.INSTANCE;
                }
                break;
            case -1046029642:
                if (method.equals("setCachedToNative")) {
                    if (params == null) {
                        params = "";
                    }
                    JSONObject jSONObject = new JSONObject(params);
                    com.tencent.ecommerce.biz.hr.module.e.f102613b.b(jSONObject.optString("key"), jSONObject.optString("value"));
                    if (callback != null) {
                        return callback.invoke(null);
                    }
                    return null;
                }
                break;
            case -978893770:
                if (method.equals("qToast")) {
                    A0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -948503195:
                if (method.equals("getFullMapInfo")) {
                    A(callback);
                    return Unit.INSTANCE;
                }
                break;
            case -881226962:
                if (method.equals("loadRemoteConfig")) {
                    if (params == null) {
                        params = "";
                    }
                    JSONObject jSONObject2 = new JSONObject(params);
                    return com.tencent.ecommerce.base.config.service.b.f100655b.a(jSONObject2.optInt("configID"), jSONObject2.optString("configKey"), jSONObject2.opt(RemoteHandleConst.PARAM_DEFAULT_VALUE));
                }
                break;
            case -830899617:
                if (method.equals("getQCirclePluginQua")) {
                    return F();
                }
                break;
            case -797625283:
                if (method.equals("urlDecode")) {
                    return j1(params);
                }
                break;
            case -790217931:
                if (method.equals("preDownloadPAGUrlToken")) {
                    r0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -779770692:
                if (method.equals("dateFormatter")) {
                    return v(params);
                }
                break;
            case -760684443:
                if (method.equals("urlEncode")) {
                    return k1(params);
                }
                break;
            case -704143875:
                if (method.equals("fetchCachedFromNative")) {
                    if (callback == null) {
                        return null;
                    }
                    mapOf2 = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("value", x(params)));
                    return callback.invoke(mapOf2);
                }
                break;
            case -675127954:
                if (method.equals("launchApp")) {
                    R(params);
                    return Unit.INSTANCE;
                }
                break;
            case -504772615:
                if (method.equals(IndividuationPlugin.Method_OpenPage)) {
                    f0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -504298424:
                if (method.equals("joinTroop")) {
                    P(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case -482608985:
                if (method.equals("closePage")) {
                    r(params);
                    return Unit.INSTANCE;
                }
                break;
            case -427040572:
                if (method.equals("reportDT")) {
                    F0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -373443937:
                if (method.equals(QQFriendJsPlugin.API_ADD_FRIEND)) {
                    i(params);
                    return Unit.INSTANCE;
                }
                break;
            case -358828511:
                if (method.equals("preDownloadAPNGResource")) {
                    n0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -150803079:
                if (method.equals("preDownloadPAGResource")) {
                    q0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -140458505:
                if (method.equals("getAccount")) {
                    return w();
                }
                break;
            case -111135063:
                if (method.equals("openGuildChannelPage")) {
                    b0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -86412972:
                if (method.equals("qCircleOpenComment")) {
                    w0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -49907120:
                if (method.equals("qCircleOpenSharePanel")) {
                    y0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -30168426:
                if (method.equals("reportPageCostTimeForCache")) {
                    G0(params);
                    return Unit.INSTANCE;
                }
                break;
            case -27800292:
                if (method.equals("reportPageCostTimeForError")) {
                    H0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 107332:
                if (method.equals("log")) {
                    V(params);
                    return Unit.INSTANCE;
                }
                break;
            case 5448656:
                if (method.equals("preDownloadImage")) {
                    o0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 17451498:
                if (method.equals("downloadPagSo")) {
                    h1();
                    return Unit.INSTANCE;
                }
                break;
            case 21162782:
                if (method.equals("openQQCirLayerPage")) {
                    S(params);
                    return Unit.INSTANCE;
                }
                break;
            case 110532135:
                if (method.equals("toast")) {
                    g1(params);
                    return Unit.INSTANCE;
                }
                break;
            case 115715456:
                if (method.equals("ssoRequest")) {
                    Z0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 150658536:
                if (method.equals("getQCircleVideoMuteValue")) {
                    return E();
                }
                break;
            case 196033107:
                if (method.equals("openQQCirLayerPageForSearch")) {
                    T(params);
                    return Unit.INSTANCE;
                }
                break;
            case 212323384:
                if (method.equals("getQQTabCurrentIndex")) {
                    I(callback);
                    return Unit.INSTANCE;
                }
                break;
            case 227513088:
                if (method.equals("getQQCirCurrentTabIndex")) {
                    H(callback);
                    return Unit.INSTANCE;
                }
                break;
            case 242711444:
                if (method.equals("downloadAppShowNoWifiDialog")) {
                    X0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 298133060:
                if (method.equals("openApplySampleSuccessPage")) {
                    Y(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 309951979:
                if (method.equals("addFriendWithParams")) {
                    j(params);
                    return Unit.INSTANCE;
                }
                break;
            case 432952604:
                if (method.equals("openGuildArticlePage")) {
                    a0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 433923123:
                if (method.equals("showPhotoBrowser")) {
                    g0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 446263767:
                if (method.equals("openTroopPage")) {
                    j0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 483103770:
                if (method.equals("getDeviceInfo")) {
                    return new JSONObject(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getRuntime().getDeviceInfo()).toString();
                }
                break;
            case 554268688:
                if (method.equals("getQCircleDateFormat")) {
                    return C(params);
                }
                break;
            case 563539483:
                if (method.equals("shakeMedium")) {
                    T0();
                    return Unit.INSTANCE;
                }
                break;
            case 567747937:
                if (method.equals("shakeHeavy")) {
                    R0();
                    return Unit.INSTANCE;
                }
                break;
            case 571566512:
                if (method.equals("shakeLight")) {
                    S0();
                    return Unit.INSTANCE;
                }
                break;
            case 579997206:
                if (method.equals("qCircleFeedLike")) {
                    v0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 624965748:
                if (method.equals("sendQCirclePanelStateEvent")) {
                    o(params);
                    return Unit.INSTANCE;
                }
                break;
            case 737037876:
                if (method.equals("qCircleDCReport")) {
                    K0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 793103395:
                if (method.equals("cirRequest")) {
                    p(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 823987093:
                if (method.equals("preloadMediaPickerModule")) {
                    t0();
                    return Unit.INSTANCE;
                }
                break;
            case 845451589:
                if (method.equals("openVasRecharge")) {
                    k0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 856773115:
                if (method.equals("cleanPB")) {
                    q(params);
                    return Unit.INSTANCE;
                }
                break;
            case 867669152:
                if (method.equals(MiniGameKuiklyModule.METHOD_OPEN_MINI_APP)) {
                    e0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 876084748:
                if (method.equals("resumeDownloadApp")) {
                    O0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 886437261:
                if (method.equals("setBlackStatusBarStyle")) {
                    Activity activity = getActivity();
                    if (activity == null || (window = activity.getWindow()) == null) {
                        return null;
                    }
                    return Boolean.valueOf(r.f104881b.c(true, window));
                }
                break;
            case 978035875:
                if (method.equals("isAppInstalled")) {
                    return K(params);
                }
                break;
            case 1012600160:
                if (method.equals("shakeSuccessMode")) {
                    U0();
                    return Unit.INSTANCE;
                }
                break;
            case 1043777951:
                if (method.equals("signAlert")) {
                    if (params != null && params.length() != 0) {
                        z16 = false;
                    }
                    if (z16) {
                        return "";
                    }
                    try {
                        Y0(new JSONObject(params));
                    } catch (Exception e16) {
                        cg0.a.a("HRBridgeModule", "signAlert", "exception = " + e16);
                    }
                    return "";
                }
                break;
            case 1064165142:
                if (method.equals("serverTimeMillis")) {
                    return P0();
                }
                break;
            case 1065113763:
                if (method.equals("pauseDownloadApp")) {
                    m0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 1179876079:
                if (method.equals("getQCircleDeviceInfo")) {
                    return D();
                }
                break;
            case 1193976733:
                if (method.equals("currentTimestamp")) {
                    return u(params);
                }
                break;
            case 1214252007:
                if (method.equals("openSearchEmoticonPage")) {
                    i0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 1303342745:
                if (method.equals("getCachedFromNative")) {
                    return x(params);
                }
                break;
            case 1368681126:
                if (method.equals("getFriendStatus")) {
                    return Integer.valueOf(y(params));
                }
                break;
            case 1563829491:
                if (method.equals("openSelectAddressView")) {
                    X(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1571678300:
                if (method.equals("subscribeGame")) {
                    b1(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1609771468:
                if (method.equals("qqLiveSSORequest")) {
                    B0(params, callback);
                    return Unit.INSTANCE;
                }
                break;
            case 1647239786:
                if (method.equals("isWifiConnected")) {
                    return M();
                }
                break;
            case 1648957435:
                if (method.equals("openGuildSubChannelPage")) {
                    c0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 1657204926:
                if (method.equals("base64CodeBatch")) {
                    return m(params);
                }
                break;
            case 1672606399:
                if (method.equals("reportRealtime")) {
                    J0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 1717739575:
                if (method.equals("setWhiteStatusBarStyle")) {
                    Activity activity2 = getActivity();
                    if (activity2 == null || (window2 = activity2.getWindow()) == null) {
                        return null;
                    }
                    return Boolean.valueOf(r.f104881b.c(false, window2));
                }
                break;
            case 1755659775:
                if (method.equals("closeKeyboard")) {
                    Activity activity3 = getActivity();
                    if (activity3 == null) {
                        return null;
                    }
                    SoftKeyboardStateHelper.INSTANCE.a(activity3);
                    return Unit.INSTANCE;
                }
                break;
            case 1770477138:
                if (method.equals("getQCircleQua")) {
                    return G();
                }
                break;
            case 1799882873:
                if (method.equals("shakeWarningMode")) {
                    V0();
                    return Unit.INSTANCE;
                }
                break;
            case 1811096719:
                if (method.equals("getUserInfo")) {
                    return J();
                }
                break;
            case 1842320229:
                if (method.equals("shakeErrorMode")) {
                    Q0();
                    return Unit.INSTANCE;
                }
                break;
            case 1863106231:
                if (method.equals("startDownloadApp")) {
                    a1(params);
                    return Unit.INSTANCE;
                }
                break;
            case 1977633769:
                if (method.equals("getMediaId")) {
                    return com.tencent.ecommerce.biz.register.b.f103963a.a();
                }
                break;
            case 2013561112:
                if (method.equals("openLogisticsPage")) {
                    d0(params);
                    return Unit.INSTANCE;
                }
                break;
            case 2019244645:
                if (method.equals("reportCustomDtEvent")) {
                    E0(params);
                    return Unit.INSTANCE;
                }
                break;
        }
        if (callback == null) {
            return null;
        }
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("code", -1), TuplesKt.to("message", "\u65b9\u6cd5\u4e0d\u5b58\u5728"));
        return callback.invoke(mapOf);
    }

    @Override // i01.e, i01.a
    public void onDestroy() {
        super.onDestroy();
        QQEcommerceSdk qQEcommerceSdk = QQEcommerceSdk.INSTANCE;
        IECQCircleApi qCircleApi = qQEcommerceSdk.getGlobalInternalSdk().getQCircleApi();
        if (qCircleApi != null) {
            qCircleApi.ktvPageClose(String.valueOf(hashCode()));
        }
        IECGameEventReceiver iECGameEventReceiver = this.gameEventListener;
        if (iECGameEventReceiver != null) {
            qQEcommerceSdk.getGlobalInternalSdk().getGameProxy().unRegisterGameListener(iECGameEventReceiver);
        }
    }

    private final String C(String params) {
        if (params != null) {
            long optLong = new JSONObject(params).optLong("time");
            IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
            String dateFormat = qCircleApi != null ? qCircleApi.getDateFormat(optLong * 1000) : null;
            if (dateFormat != null) {
                return dateFormat;
            }
        }
        return "";
    }

    private final void E0(String params) {
        Map linkedHashMap;
        if (params == null || params.length() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("eventCode");
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject == null || (linkedHashMap = com.tencent.ecommerce.biz.util.f.b(optJSONObject)) == null) {
                linkedHashMap = new LinkedHashMap();
            }
            IECDtReport.b.a(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getReporter(), null, optString, linkedHashMap, null, 8, null);
        } catch (JSONException e16) {
            cg0.a.a("HRBridgeModule", "reportCustomDtEvent", "[reportCustomDtEvent] e = " + e16);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void G0(String params) {
        JSONObject jSONObject;
        ECHippyRenderView a16;
        if (params != null) {
            if (params.length() > 0) {
                jSONObject = new JSONObject(params);
                a16 = com.tencent.ecommerce.biz.hr.ktx.b.a(this);
                if (a16 == null) {
                    a16.f(com.tencent.ecommerce.biz.util.f.a(jSONObject));
                    return;
                }
                return;
            }
        }
        jSONObject = new JSONObject();
        a16 = com.tencent.ecommerce.biz.hr.ktx.b.a(this);
        if (a16 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void H0(String params) {
        JSONObject jSONObject;
        ECHippyRenderView a16;
        if (params != null) {
            if (params.length() > 0) {
                jSONObject = new JSONObject(params);
                a16 = com.tencent.ecommerce.biz.hr.ktx.b.a(this);
                if (a16 == null) {
                    a16.g(com.tencent.ecommerce.biz.util.f.a(jSONObject));
                    return;
                }
                return;
            }
        }
        jSONObject = new JSONObject();
        a16 = com.tencent.ecommerce.biz.hr.ktx.b.a(this);
        if (a16 == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void I0(String params) {
        JSONObject jSONObject;
        ECHippyRenderView a16;
        if (params != null) {
            if (params.length() > 0) {
                jSONObject = new JSONObject(params);
                a16 = com.tencent.ecommerce.biz.hr.ktx.b.a(this);
                if (a16 == null) {
                    a16.h(com.tencent.ecommerce.biz.util.f.a(jSONObject));
                    return;
                }
                return;
            }
        }
        jSONObject = new JSONObject();
        a16 = com.tencent.ecommerce.biz.hr.ktx.b.a(this);
        if (a16 == null) {
        }
    }

    private final void K0(String params) {
        if (params == null || params.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final JSONObject optJSONObject = jSONObject.optJSONObject("qCircleDCReportParam");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("feedPbToken");
        final int optInt = jSONObject.optInt("qCircleDCReportActionType");
        final int optInt2 = jSONObject.optInt("qCircleDCReportSubActionType");
        ECPBParser.f100901b.e(optString, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$reportToQCircleDc$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                invoke2(messageMicro);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageMicro<?> messageMicro) {
                IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                if (qCircleApi != null) {
                    qCircleApi.reportToDc5507(optInt, optInt2, com.tencent.ecommerce.biz.util.f.b(optJSONObject), messageMicro);
                }
            }
        });
    }

    private final void L0(String params) {
        if (params == null || params.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final JSONObject optJSONObject = jSONObject.optJSONObject("extraParam");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        String optString = jSONObject.optString("feedPbToken");
        final String optString2 = jSONObject.optString(AdMetricTag.EVENT_NAME);
        ECPBParser.f100901b.e(optString, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$reportToQCircleDt$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                invoke2(messageMicro);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(MessageMicro<?> messageMicro) {
                IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                if (qCircleApi != null) {
                    qCircleApi.reportToDt(optString2, com.tencent.ecommerce.biz.util.f.b(optJSONObject), messageMicro);
                }
            }
        });
    }

    private final void S(String params) {
        Activity activity;
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            int optInt = jSONObject.optInt("videoTag");
            int optInt2 = jSONObject.optInt("sourceType");
            int optInt3 = jSONObject.optInt("subSourceType");
            String optString = jSONObject.optString("pageName");
            View viewWithTag = viewWithTag(optInt);
            IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
            if (qCircleApi == null || (activity = getActivity()) == null) {
                return;
            }
            qCircleApi.launchQCircleFeed(activity, optInt2, optInt3, optString, viewWithTag);
        }
    }

    private final void T(String params) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        Activity activity;
        if (params == null || (optJSONArray = (jSONObject = new JSONObject(params)).optJSONArray("feedPbTokens")) == null) {
            return;
        }
        int length = optJSONArray.length();
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < length; i3++) {
            MessageMicro<?> f16 = ECPBParser.f100901b.f(optJSONArray.optString(i3));
            if (f16 != null) {
                arrayList.add(f16);
            }
        }
        IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
        if (qCircleApi == null || (activity = getActivity()) == null) {
            return;
        }
        qCircleApi.launchQCircleFeed(activity, arrayList, String.valueOf(hashCode()), jSONObject);
    }

    private final void W(String params) {
        String str;
        if (params == null || (str = new JSONObject(params).optString(MiniAppSendSmsCodeServlet.KEY_PHONE_NUMBER)) == null) {
            str = "";
        }
        com.tencent.ecommerce.base.device.b.f100686a.a(wg0.a.a(), str);
    }

    private final void Y(String params, Function1<Object, Unit> callback) {
        List<String> listOf;
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString(QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_ORDER_ID);
            String optString2 = jSONObject.optString("spuId");
            String optString3 = jSONObject.optString("shopId");
            String optString4 = jSONObject.optString("skuId");
            String optString5 = jSONObject.optString("priSortId");
            SubmitSucceedUIState submitSucceedUIState = new SubmitSucceedUIState("\u7533\u8bf7\u6210\u529f\uff0c\u5f85\u5546\u5bb6\u5ba1\u6279", "\u5ba1\u6279\u72b6\u6001\u8bf7\u5728\u6211\u7684\u8ba2\u5355\u67e5\u770b", "\u67e5\u770b\u8ba2\u5355");
            Activity activity = getActivity();
            if (activity != null) {
                ECSubmitSucceedFragment.Companion companion = ECSubmitSucceedFragment.INSTANCE;
                SubmitSucceedFrom submitSucceedFrom = SubmitSucceedFrom.APPLY_SAMPLE_ORDER;
                listOf = CollectionsKt__CollectionsJVMKt.listOf(optString2);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("order_id", optString);
                jSONObject2.put("shop_id", optString3);
                jSONObject2.put("sku_id", optString4);
                jSONObject2.put("pri_sort_id", optString5);
                Unit unit = Unit.INSTANCE;
                companion.a(activity, submitSucceedUIState, submitSucceedFrom, listOf, jSONObject2);
            }
        }
    }

    private final void Z0(String params, Function1<Object, Unit> callback) {
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            Pair<String, String> l06 = l0(jSONObject.optString("cmd"), jSONObject.optBoolean("useOriginalPath", false));
            cg0.a.b("HRBridgeModule", "ssoRequest, cmd: " + l06);
            JSONObject optJSONObject = jSONObject.optJSONObject("reqParam");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            com.tencent.ecommerce.base.network.service.a.c(l06.getFirst(), l06.getSecond(), optJSONObject, new i(callback, l06, optJSONObject));
        }
    }

    private final void p(String params, Function1<Object, Unit> callback) {
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            String optString = jSONObject.optString("cmd");
            JSONObject optJSONObject = jSONObject.optJSONObject("reqParam");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            com.tencent.ecommerce.biz.hr.module.cir.a aVar = new com.tencent.ecommerce.biz.hr.module.cir.a(optString, optJSONObject);
            com.tencent.ecommerce.base.network.service.a.f100826c.g(optString, aVar, new b(aVar), new c(callback));
        }
    }

    private final void q(String params) {
        if (params != null) {
            JSONArray optJSONArray = new JSONObject(params).optJSONArray("tokenArray");
            int d16 = ECPBParser.f100901b.d();
            if (optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i3 = 0; i3 < length; i3++) {
                    ECPBParser.f100901b.g(optJSONArray.getString(i3));
                }
            }
            cg0.a.b("ECPBParser", "clean pb, beforeSize=" + d16 + ", afterSize=" + ECPBParser.f100901b.d());
        }
    }

    private final void u0(String params, Function1<Object, Unit> callback) {
        if (params != null) {
            JSONObject jSONObject = new JSONObject(params);
            ECPBParser.f100901b.b(jSONObject.optString("pbClassName"), jSONObject.optString(BaseConstants.ATTRIBUTE_KEY_PB_DATA), jSONObject.optString("feedPbToken"), null);
        }
    }

    private final void B0(String params, Function1<Object, Unit> callback) {
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("service");
        String optString2 = jSONObject.optString("method");
        JSONObject optJSONObject = jSONObject.optJSONObject("reqParams");
        rg0.a.f431441b.a(optString, optString2, optJSONObject != null ? optJSONObject.toString() : null, new e(callback));
    }

    private final void F0(String params) {
        Map linkedHashMap;
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("eventCode");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null || (linkedHashMap = com.tencent.ecommerce.biz.util.f.a(optJSONObject)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        IECDataReport.a.a(com.tencent.ecommerce.base.report.service.b.f100913b, optString, linkedHashMap, false, 4, null);
        if (linkedHashMap.containsKey("realtime")) {
            com.tencent.ecommerce.base.report.service.g.d(optString, linkedHashMap);
        }
    }

    private final void J0(String params) {
        Map linkedHashMap;
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("eventCode");
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject == null || (linkedHashMap = com.tencent.ecommerce.biz.util.f.a(optJSONObject)) == null) {
            linkedHashMap = new LinkedHashMap();
        }
        com.tencent.ecommerce.base.report.service.g.d(optString, linkedHashMap);
    }

    private final void V(String params) {
        if (params == null) {
            return;
        }
        cg0.a.b("HippyRender", new JSONObject(params).optString("content"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    /* JADX WARN: Type inference failed for: r2v8, types: [T, ri0.d] */
    private final void f0(String params, Function1<Object, Unit> callback) {
        boolean contains$default;
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = jSONObject.optString("url");
        cg0.a.b("HRBridgeModule", "open page url: " + ((String) objectRef.element));
        final JSONObject optJSONObject = jSONObject.optJSONObject("userData");
        if (optJSONObject == null) {
            optJSONObject = new JSONObject();
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) objectRef.element, (CharSequence) "kuikly", false, 2, (Object) null);
        if (contains$default) {
            d01.l i3 = u.f392615m.i();
            if (i3 != null) {
                Context context = getContext();
                Intrinsics.checkNotNull(context);
                i3.a(context, (String) objectRef.element, optJSONObject, "");
                return;
            }
            return;
        }
        boolean z16 = jSONObject.optInt("closeCurPage") > 0;
        final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        if (callback != null) {
            objectRef2.element = new ri0.d(callback);
        }
        if (z16) {
            r(null);
            ECThreadUtilKt.e(16L, new Function0<Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$openPage$2
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

                /* JADX WARN: Multi-variable type inference failed */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    HRBridgeModule.this.Q((String) objectRef.element, com.tencent.ecommerce.biz.util.f.a(optJSONObject), (ri0.d) objectRef2.element);
                }
            });
        } else {
            Q((String) objectRef.element, com.tencent.ecommerce.biz.util.f.a(optJSONObject), (ri0.d) objectRef2.element);
        }
    }

    private final void g0(String photoBrowserConfigStr) {
        JSONObject jSONObject;
        JSONArray optJSONArray;
        if ((photoBrowserConfigStr == null || photoBrowserConfigStr.length() == 0) || (optJSONArray = (jSONObject = new JSONObject(photoBrowserConfigStr)).optJSONArray("photosUrl")) == null) {
            return;
        }
        int optInt = jSONObject.optInt("photosIndex", 0);
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i3 = 0; i3 < length; i3++) {
            arrayList.add(optJSONArray.optString(i3));
        }
        lg0.a aVar = lg0.a.f414523b;
        JSONObject optJSONObject = jSONObject.optJSONObject("extInfoMap");
        aVar.a(arrayList, optInt, optJSONObject != null ? com.tencent.ecommerce.biz.util.f.b(optJSONObject) : null);
    }

    private final void g1(String params) {
        if (params == null) {
            return;
        }
        com.tencent.ecommerce.base.ui.i.f101155b.d(new JSONObject(params).optString("content"), ECToastIcon.ICON_DEFAULT, 0);
    }

    private final void t(String params) {
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        Context context = getContext();
        Object systemService = context != null ? context.getSystemService("clipboard") : null;
        ClipboardManager clipboardManager = (ClipboardManager) (systemService instanceof ClipboardManager ? systemService : null);
        if (clipboardManager != null) {
            ClipboardMonitor.setPrimaryClip(clipboardManager, ClipData.newPlainText("HRBridgeModule", jSONObject.optString("content")));
        }
    }

    private final void v0(String feedLike) {
        if (feedLike == null || feedLike.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject(feedLike);
        String optString = jSONObject.optString("feedPbToken");
        final boolean optBoolean = jSONObject.optBoolean("isPraise");
        if (optString.length() > 0) {
            ECPBParser.f100901b.e(optString, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$qCircleFeedLike$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MessageMicro<?> messageMicro) {
                    IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                    if (qCircleApi != null) {
                        qCircleApi.feedRequestDoLike(messageMicro, optBoolean);
                    }
                }
            });
            return;
        }
        cg0.a.a("HRBridgeModule", "qCircleFeedLike error", "pbToken=" + optString);
    }

    private final void w0(String stFeed) {
        if (stFeed == null || stFeed.length() == 0) {
            return;
        }
        String optString = new JSONObject(stFeed).optString("feedPbToken", "");
        if (optString.length() > 0) {
            ECPBParser.f100901b.e(optString, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$qCircleOpenComment$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MessageMicro<?> messageMicro) {
                    IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                    if (qCircleApi != null) {
                        qCircleApi.openQCircleComment(messageMicro);
                    }
                }
            });
            return;
        }
        cg0.a.a("HRBridgeModule", "qCircleOpenComment error", "pbToken=" + optString);
    }

    private final void x0(String stFeed) {
        if (stFeed == null || stFeed.length() == 0) {
            return;
        }
        String optString = new JSONObject(stFeed).optString("feedPbToken", "");
        if (optString.length() > 0) {
            ECPBParser.f100901b.e(optString, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$qCircleOpenPersonalDetailPage$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MessageMicro<?> messageMicro) {
                    IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                    if (qCircleApi != null) {
                        qCircleApi.openQCirclePersonalDetailPage(messageMicro);
                    }
                }
            });
            return;
        }
        cg0.a.a("HRBridgeModule", "openQCirclePersonalDetailPage error", "pbToken=" + optString);
    }

    private final void y0(String stFeed) {
        if (stFeed == null || stFeed.length() == 0) {
            return;
        }
        String optString = new JSONObject(stFeed).optString("feedPbToken", "");
        if (optString.length() > 0) {
            ECPBParser.f100901b.e(optString, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$qCircleOpenSharePanel$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MessageMicro<?> messageMicro) {
                    IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                    if (qCircleApi != null) {
                        qCircleApi.openQCircleSharePanel(messageMicro);
                    }
                }
            });
            return;
        }
        cg0.a.a("HRBridgeModule", "qCircleOpenSharePanel error", "pbToken=" + optString);
    }

    private final void z0(String params) {
        if (params == null || params.length() == 0) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        String optString = jSONObject.optString("feedPbToken", "");
        final String optString2 = jSONObject.optString("pageId", "");
        if (optString.length() > 0) {
            ECPBParser.f100901b.e(optString, new Function1<MessageMicro<?>, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$qCirclePreDownloadVideo$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MessageMicro<?> messageMicro) {
                    invoke2(messageMicro);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MessageMicro<?> messageMicro) {
                    IECQCircleApi qCircleApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQCircleApi();
                    if (qCircleApi != null) {
                        qCircleApi.preDownloadVideo(messageMicro, optString2);
                    }
                }
            });
            return;
        }
        cg0.a.a("HRBridgeModule", "qCirclePreDownloadVideo error", "pbToken=" + optString + ", pageId=" + optString2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0076, code lost:
    
        if (r2 != null) goto L36;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void W0(String params, final Function1<Object, Unit> callback) {
        String str;
        boolean z16;
        if (params == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject(params);
        final String optString = jSONObject.optString("title");
        final String optString2 = jSONObject.optString("message");
        JSONArray optJSONArray = jSONObject.optJSONArray("buttons");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        final JSONArray jSONArray = optJSONArray;
        final JSONObject optJSONObject = jSONObject.optJSONObject("info");
        String str2 = null;
        Integer valueOf = optJSONObject != null ? Integer.valueOf(optJSONObject.optInt("messageAlignment")) : null;
        Context context = getContext();
        if (context != null) {
            com.tencent.ecommerce.base.ui.g gVar = new com.tencent.ecommerce.base.ui.g(context);
            gVar.Z((valueOf != null && valueOf.intValue() == 1) ? 3 : 1);
            String str3 = "";
            if (optString2 != null) {
                if (optString2.length() == 0) {
                    str = optJSONObject != null ? optJSONObject.optString("message") : null;
                } else {
                    str = optString2;
                }
            }
            str = "";
            gVar.Y(str);
            if (optString != null) {
                if (!(optString.length() == 0)) {
                    str2 = optString;
                } else if (optJSONObject != null) {
                    str2 = optJSONObject.optString("title");
                }
                if (str2 != null) {
                    str3 = str2;
                }
            }
            gVar.setTitle(str3);
            gVar.b0(jSONArray.optString(0));
            gVar.f0(jSONArray.optString(1));
            if (gVar.getLeftMessage().length() > 0) {
                final int i3 = 1;
                final Integer num = valueOf;
                z16 = false;
                gVar.a0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$showAlert$$inlined$apply$lambda$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Map mapOf;
                        Function1 function1 = callback;
                        if (function1 != null) {
                            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("index", 0));
                        }
                    }
                });
            } else {
                z16 = false;
            }
            if (gVar.getRightMessage().length() <= 0 ? z16 : true) {
                final int i16 = 1;
                final Integer num2 = valueOf;
                gVar.e0(new Function1<View, Unit>() { // from class: com.tencent.ecommerce.biz.hr.module.HRBridgeModule$showAlert$$inlined$apply$lambda$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(View view) {
                        invoke2(view);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(View view) {
                        Map mapOf;
                        Function1 function1 = callback;
                        if (function1 != null) {
                            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("index", 1));
                        }
                    }
                });
            }
            gVar.show();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$k", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener;", "Lcom/tencent/ecommerce/biz/comment/UploadStateListener$a;", "state", "", "onStateChanged", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class k implements UploadStateListener {
        k() {
        }

        @Override // com.tencent.ecommerce.biz.comment.UploadStateListener
        public void onStateChanged(UploadStateListener.a state) {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J \u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$j", "Lcom/tencent/ecommerce/biz/consumer/event/IECGameEventReceiver;", "", "appId", "", "progress", "taskStatus", "", "onDownloadStatusChanged", "subscribeAppId", "subscribeStatus", "followStatus", "onSubscribeStatus", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class j implements IECGameEventReceiver {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f102598d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f102599e;

        j(String str, Function1 function1) {
            this.f102598d = str;
            this.f102599e = function1;
        }

        @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
        public void onSubscribeStatus(String subscribeAppId, int subscribeStatus, int followStatus) {
            if (!Intrinsics.areEqual(this.f102598d, subscribeAppId)) {
                cg0.a.b("HRBridgeModule", "subscribeGame return by appId incorrect");
                return;
            }
            cg0.a.b("HRBridgeModule", "subscribeGame subscribeStatus=" + subscribeStatus + ", followStatus:" + followStatus);
            Function1 function1 = this.f102599e;
            if (function1 != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("subscribeStatus", subscribeStatus);
                jSONObject.put("followStatus", followStatus);
                Unit unit = Unit.INSTANCE;
            }
            QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getGameProxy().unRegisterGameListener(this);
        }

        @Override // com.tencent.ecommerce.biz.consumer.event.IECGameEventReceiver
        public void onDownloadStatusChanged(String appId, int progress, int taskStatus) {
        }
    }
}
