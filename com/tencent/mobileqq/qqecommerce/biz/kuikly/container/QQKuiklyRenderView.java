package com.tencent.mobileqq.qqecommerce.biz.kuikly.container;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Size;
import android.widget.FrameLayout;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.biz.qqcircle.utils.cw;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.common.config.AppSetting;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.imageloader.api.IECImageLoader;
import com.tencent.ecommerce.base.report.api.IECDataReport;
import com.tencent.ecommerce.biz.qq.api.IECQQApi;
import com.tencent.ecommerce.biz.res.api.IECResourceApi;
import com.tencent.kuikly.core.render.android.context.KuiklyRenderCoreExecuteMode;
import com.tencent.kuikly.core.render.android.exception.ErrorReason;
import com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewDelegator;
import com.tencent.kuikly.core.render.android.expand.a;
import com.tencent.kuikly.core.render.android.performace.KRMonitorType;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.imcore.proxy.basic.CaughtExceptionReportProxy;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyFontAdapter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.QQKuiklyGlobalSwitchAdapter;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.n;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.o;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.r;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.DexConfig;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.KuiklyLaunchParams;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.QQKuiklyException;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.ResError;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.UpdateType;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.d;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.api.impl.QQKuiklyContextCodeFetcher;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.ExecuteContextMode;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.config.QQKuiklyConfigManager;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.QQKuiklyExport;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.QQKuiklyPlatformApi;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.PreRequestData;
import com.tencent.mobileqq.qqecommerce.biz.kuikly.preload.QQKuiklyPrePrequest;
import com.tencent.mobileqq.qqecommerce.biz.report.ECDataReportManager;
import com.tencent.mobileqq.qqperf.api.IPerfApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.api.IStudyModeManager;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.controller.QAdCardExtraData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.QZoneNavigateToQQTransparentFragment;
import cooperation.qzone.QzoneIPCModule;
import d01.u;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt__ExceptionsKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00c6\u00012\u00020\u00012\u00020\u00022\u00020\u0003:\u0002\u00c3\u0001B)\u0012\u0007\u0010\u00d6\u0001\u001a\u00020C\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\t\b\u0002\u0010\u0084\u0001\u001a\u00020.\u00a2\u0006\u0006\b\u00d7\u0001\u0010\u00d8\u0001J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J.\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000f2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\b\u0010\u0014\u001a\u00020\u0007H\u0016J\b\u0010\u0015\u001a\u00020\u0007H\u0016J$\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u0017H\u0016J\u0018\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0010H\u0016J\"\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u001eH\u0016J\u000e\u0010!\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020 J\n\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u0011\u0010$\u001a\u0004\u0018\u00010#H\u0016\u00a2\u0006\u0004\b$\u0010%J\u0006\u0010&\u001a\u00020\u0007J \u0010-\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'2\u0006\u0010*\u001a\u00020)2\u0006\u0010,\u001a\u00020+H\u0016J\"\u00100\u001a\u00020\u00072\u0006\u0010/\u001a\u00020.2\b\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010,\u001a\u00020+H\u0016J\b\u00101\u001a\u00020.H\u0016J\b\u00102\u001a\u00020.H\u0016J\b\u00103\u001a\u00020\u0007H\u0016J\b\u00104\u001a\u00020\u0007H\u0016J\u0010\u00107\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016J\u0010\u00108\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016J\u0010\u00109\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016J\u0010\u0010:\u001a\u00020\u00072\u0006\u00106\u001a\u000205H\u0016J\b\u0010;\u001a\u00020+H\u0016J\u0010\u0010=\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020<H\u0016J\u0016\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0017H\u0016J\b\u0010?\u001a\u00020.H\u0016J\b\u0010@\u001a\u00020.H\u0016J\b\u0010A\u001a\u00020.H\u0016J\b\u0010B\u001a\u00020.H\u0016J\u000e\u0010E\u001a\u00020\u00072\u0006\u0010D\u001a\u00020CJ\u0087\u0001\u0010T\u001a\u00020\u00072\u0006\u0010G\u001a\u00020F2f\u0010Q\u001ab\u0012\u0013\u0012\u00110I\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00070Hj\u0002`P2\u0006\u0010S\u001a\u00020RH\u0000\u00a2\u0006\u0004\bT\u0010UJ\u0006\u0010V\u001a\u00020.J\b\u0010W\u001a\u00020.H\u0002Jp\u0010X\u001a\u00020\u00072f\u0010Q\u001ab\u0012\u0013\u0012\u00110I\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00070Hj\u0002`PH\u0002Jp\u0010Y\u001a\u00020\u00072f\u0010Q\u001ab\u0012\u0013\u0012\u00110I\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00070Hj\u0002`PH\u0002Jx\u0010Z\u001a\u00020\u00072\u0006\u0010S\u001a\u00020R2f\u0010Q\u001ab\u0012\u0013\u0012\u00110I\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00070Hj\u0002`PH\u0002Jx\u0010[\u001a\u00020.2\u0006\u0010S\u001a\u00020R2f\u0010Q\u001ab\u0012\u0013\u0012\u00110I\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00070Hj\u0002`PH\u0002Jx\u0010\\\u001a\u00020.2\u0006\u0010S\u001a\u00020R2f\u0010Q\u001ab\u0012\u0013\u0012\u00110I\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00070Hj\u0002`PH\u0002J\u0010\u0010]\u001a\u00020\u00072\u0006\u0010S\u001a\u00020RH\u0002J\u0080\u0001\u0010_\u001a\u00020\u00072\u0006\u0010S\u001a\u00020R2\u0006\u0010^\u001a\u00020.2f\u0010Q\u001ab\u0012\u0013\u0012\u00110I\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u001b\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(N\u0012\u0015\u0012\u0013\u0018\u00010\t\u00a2\u0006\f\bJ\u0012\b\bK\u0012\u0004\b\b(O\u0012\u0004\u0012\u00020\u00070Hj\u0002`PH\u0002J\b\u0010`\u001a\u00020#H\u0002J\b\u0010a\u001a\u00020\u0007H\u0002J\b\u0010b\u001a\u00020\u0007H\u0002J\b\u0010c\u001a\u00020\u0007H\u0002J\u0016\u0010f\u001a\u00020\u00072\f\u0010e\u001a\b\u0012\u0004\u0012\u00020\u00070dH\u0002J\b\u0010g\u001a\u00020\u0007H\u0002J\b\u0010h\u001a\u00020\u0007H\u0002J\b\u0010i\u001a\u00020\u0007H\u0002J\u0018\u0010l\u001a\u00020\u00072\u0006\u0010j\u001a\u00020I2\u0006\u0010k\u001a\u00020\tH\u0002J\u0010\u0010m\u001a\u00020\u00072\u0006\u0010(\u001a\u00020'H\u0002J\b\u0010n\u001a\u00020\u0007H\u0002J\b\u0010o\u001a\u00020\tH\u0002J\b\u0010p\u001a\u00020\u0007H\u0002J\u0014\u0010q\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u0017H\u0002J$\u0010r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\b\u0010s\u001a\u00020\u001bH\u0002J\b\u0010t\u001a\u00020\u0007H\u0002J\b\u0010u\u001a\u00020.H\u0002J\b\u0010v\u001a\u00020.H\u0002J\b\u0010w\u001a\u00020.H\u0002J\b\u0010x\u001a\u00020.H\u0002J\b\u0010y\u001a\u00020#H\u0002J\b\u0010z\u001a\u00020\tH\u0002J\b\u0010{\u001a\u00020\u0007H\u0002J\b\u0010|\u001a\u00020.H\u0002J\b\u0010}\u001a\u00020.H\u0002J\b\u0010~\u001a\u00020.H\u0002J\b\u0010\u007f\u001a\u00020.H\u0002J\t\u0010\u0080\u0001\u001a\u00020\u0007H\u0002J\t\u0010\u0081\u0001\u001a\u00020\u0007H\u0002R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\r\u0010\u0082\u0001R\u0016\u0010\u0084\u0001\u001a\u00020.8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u0083\u0001\u0010rR\u001a\u0010\u0088\u0001\u001a\u00030\u0085\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R5\u0010\u008f\u0001\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00100\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u0089\u0001\u0010\u008a\u0001\u001a\u0006\b\u008b\u0001\u0010\u008c\u0001\"\u0006\b\u008d\u0001\u0010\u008e\u0001R\u0019\u0010\u0092\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u0018\u0010\u0094\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0093\u0001\u0010rR\u001a\u0010\u0096\u0001\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bZ\u0010\u0095\u0001R\u0017\u0010\u0097\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010zR\u0019\u0010S\u001a\u0004\u0018\u00010R8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\\\u0010\u0098\u0001R\u0018\u0010\u0099\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010zR\u0017\u0010\u009a\u0001\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010zR)\u0010\u00a1\u0001\u001a\u00030\u009b\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\b`\u0010\u009c\u0001\u001a\u0006\b\u009d\u0001\u0010\u009e\u0001\"\u0006\b\u009f\u0001\u0010\u00a0\u0001R,\u0010\u00a9\u0001\u001a\u0005\u0018\u00010\u00a2\u00018\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0018\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001\u001a\u0006\b\u00a5\u0001\u0010\u00a6\u0001\"\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ab\u0001\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bz\u0010\u00aa\u0001R\u0018\u0010j\u001a\u00020I8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u00aa\u0001R\u0018\u0010\u00ad\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ac\u0001\u0010rR\u0019\u0010\u00af\u0001\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ae\u0001\u0010\u0091\u0001R\u0019\u0010\u00b1\u0001\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00a3\u0001R\u0018\u0010\u00b2\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a5\u0001\u0010rR\u0017\u0010\u00b5\u0001\u001a\u00030\u00b3\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bs\u0010\u00b4\u0001R\u0017\u0010\u00b8\u0001\u001a\u00030\u00b6\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bo\u0010\u00b7\u0001R\u001c\u0010\u00bc\u0001\u001a\u0005\u0018\u00010\u00b9\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ba\u0001\u0010\u00bb\u0001R\u0017\u0010\u00bd\u0001\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\by\u0010rR\u001c\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00be\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u0018\u0010\u00c5\u0001\u001a\u00030\u00c2\u00018VX\u0096\u0004\u00a2\u0006\b\u001a\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u0017\u0010\u00c8\u0001\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00c6\u0001\u0010\u00c7\u0001R\u0017\u0010\u00c9\u0001\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00ac\u0001\u0010\u00c7\u0001R\u0017\u0010\u00ca\u0001\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00ae\u0001\u0010\u00c7\u0001R\u0017\u0010\u00cb\u0001\u001a\u00020\t8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00ba\u0001\u0010\u00c7\u0001R\u0018\u0010\u00cf\u0001\u001a\u00030\u00cc\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00cd\u0001\u0010\u00ce\u0001R\u0017\u0010\u00d1\u0001\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00b0\u0001\u0010\u00d0\u0001R\u0017\u0010\u00d2\u0001\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00bf\u0001\u0010\u00d0\u0001R\u001a\u0010\u00d5\u0001\u001a\u0005\u0018\u00010\u00d3\u00018BX\u0082\u0004\u00a2\u0006\b\u001a\u0006\b\u00a3\u0001\u0010\u00d4\u0001\u00a8\u0006\u00d9\u0001"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/g;", "Lcom/tencent/kuikly/core/render/android/expand/a;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "c", "delegate", "", "setQQKuiklyRenderViewDelegate", "", ZPlanPublishSource.FROM_SCHEME, "Landroid/util/Size;", "size", "d", "pageName", "", "", "params", "b", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, "onResume", "onDetach", AdMetricTag.EVENT_NAME, "", "data", "sentEvent", "y0", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "onActivityResult", "Lorg/json/JSONObject;", "setActivityResult", "V0", "", "K0", "()Ljava/lang/Long;", "n0", "", "throwable", "Lcom/tencent/kuikly/core/render/android/exception/ErrorReason;", HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON, "Lcom/tencent/kuikly/core/render/android/context/KuiklyRenderCoreExecuteMode;", "executeMode", "Ia", "", "isSucceed", "onPageLoadComplete", "h4", "ng", "Sa", "p9", "Lcom/tencent/kuikly/core/render/android/b;", "kuiklyRenderExport", "registerExternalModule", "Ff", "registerExternalRenderView", "registerViewExternalPropHandler", "C2", "Lj01/a;", "pg", "O1", "Cc", "M0", "u0", "c1", "Landroid/content/Context;", "newContext", "o0", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;", "resError", "Lkotlin/Function4;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/ExecuteContextMode;", "Lkotlin/ParameterName;", "name", "mode", "state", "contextCode", "assetsPath", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/LoadResultCallback;", "result", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "dexResFetcher", "i0", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/k;Lkotlin/jvm/functions/Function4;Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;)V", "c0", "b0", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", BdhLogUtil.LogTag.Tag_Conn, "D", "E", "E0", "fourceUpdate", "G", "H", "k0", "j0", "l0", "Lkotlin/Function0;", "task", "w0", "Y", "D0", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "executeContextMode", "msg", "t0", "p0", "q0", BdhLogUtil.LogTag.Tag_Req, "s0", "y", "Z", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "z0", "h0", "A0", "f0", "v0", "T", "J", "X", "g0", "e0", "B0", "d0", UserInfo.SEX_FEMALE, "a0", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;", "e", "isEmbedScene", "Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator;", "f", "Lcom/tencent/kuikly/core/render/android/expand/KuiklyRenderViewDelegator;", "kuiklyRenderViewDelegator", tl.h.F, "Ljava/util/Map;", "O", "()Ljava/util/Map;", "setPageParams", "(Ljava/util/Map;)V", QAdCardExtraData.AdExtraInnerKey.AD_EXTRA_KEY_PAGE_PARAMS, "i", "Ljava/lang/String;", "pagerName", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "useHostDisplayMetrics", "Ljava/lang/Long;", "embedSceneSyncTimeout", "reportResVersion", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/c;", "pageStartTs", "renderStartTs", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/i;", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/i;", "K", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/i;", "setLaunchPerformance", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/i;)V", "launchPerformance", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/QQKuiklyPrePrequest;", "I", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/QQKuiklyPrePrequest;", "P", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/QQKuiklyPrePrequest;", "setPreRequest", "(Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/preload/QQKuiklyPrePrequest;)V", "preRequest", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/config/ExecuteContextMode;", "configExecuteContextMode", "L", "isHotReloadMode", "M", "localIp", "N", "pageProgressStatus", "isForceUpdate", "Landroid/os/Handler;", "Landroid/os/Handler;", "mHandler", "Ljava/lang/Runnable;", "Ljava/lang/Runnable;", "timeoutRunnable", "Landroid/app/Dialog;", ExifInterface.LATITUDE_SOUTH, "Landroid/app/Dialog;", "debugErrorDialog", "hadDetach", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/m;", "U", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/m;", "dexResCallback", "Ll01/a;", "a", "()Ll01/a;", "unitConverter", "V", "()Ljava/lang/String;", "tracePageName", "minQQVersion", "minResVersion", "resId", "Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/UpdateType;", "W", "()Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/UpdateType;", "updateType", "()J", "openPageTs", "timeout", "Landroid/app/Activity;", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "context", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/api/h;Z)V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class QQKuiklyRenderView extends FrameLayout implements com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g, com.tencent.kuikly.core.render.android.expand.a {

    /* renamed from: V, reason: from kotlin metadata */
    public static final Companion INSTANCE;
    private static int W;

    /* renamed from: a0, reason: collision with root package name */
    private static volatile boolean f262856a0;

    /* renamed from: C, reason: from kotlin metadata */
    private Long embedSceneSyncTimeout;

    /* renamed from: D, reason: from kotlin metadata */
    private long reportResVersion;

    /* renamed from: E, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher;

    /* renamed from: F, reason: from kotlin metadata */
    private long pageStartTs;

    /* renamed from: G, reason: from kotlin metadata */
    private long renderStartTs;

    /* renamed from: H, reason: from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.i launchPerformance;

    /* renamed from: I, reason: from kotlin metadata */
    private QQKuiklyPrePrequest preRequest;

    /* renamed from: J, reason: from kotlin metadata */
    private ExecuteContextMode configExecuteContextMode;

    /* renamed from: K, reason: from kotlin metadata */
    private ExecuteContextMode executeContextMode;

    /* renamed from: L, reason: from kotlin metadata */
    private boolean isHotReloadMode;

    /* renamed from: M, reason: from kotlin metadata */
    private String localIp;

    /* renamed from: N, reason: from kotlin metadata */
    private int pageProgressStatus;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean isForceUpdate;

    /* renamed from: Q, reason: from kotlin metadata */
    private final Handler mHandler;

    /* renamed from: R, reason: from kotlin metadata */
    private final Runnable timeoutRunnable;

    /* renamed from: S, reason: from kotlin metadata */
    private Dialog debugErrorDialog;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean hadDetach;

    /* renamed from: U, reason: from kotlin metadata */
    private m dexResCallback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isEmbedScene;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private KuiklyRenderViewDelegator kuiklyRenderViewDelegator;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Map<String, Object> pageParams;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private String pagerName;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean useHostDisplayMetrics;

    /* compiled from: P */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b&\u0010'J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u0002J\u001a\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0015R\u0014\u0010\u0017\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0015R\u0014\u0010\u0019\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0015R\u0014\u0010\u001b\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0015R\u0014\u0010\u001c\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u0015R\u0014\u0010\u001d\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u0015R\u0014\u0010\u001e\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u0015R\u0014\u0010\u001f\u001a\u00020\u00138\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0015R\u0014\u0010 \u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b \u0010\u0012R\u0014\u0010!\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b!\u0010\u0012R\u0014\u0010\"\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u0012R\u0016\u0010#\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010%\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010\u0015\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/kuikly/container/QQKuiklyRenderView$a;", "", "", "pagerName", "turboDisplayKey", "e", "displayKey", "c", "", "d", "minQQVersion", "", "f", "b", "", "DEFAULT_TIME_OUT", "J", "OPEN_PAGE_COUNT", "Ljava/lang/String;", "", "PAGE_PROGRESS_STATUS_CONTENT_VIEW_CREATED", "I", "PAGE_PROGRESS_STATUS_CONTEXT_RUNTIME_ERROR", "PAGE_PROGRESS_STATUS_INIT", "PAGE_PROGRESS_STATUS_LOAD_BUNDLE", "PAGE_PROGRESS_STATUS_LOAD_BUNDLE_FAIL", "PAGE_PROGRESS_STATUS_ROOT_VIEW_CREATED", "PAGE_STATE_LOADING", "PAGE_STATE_LOAD_ERROR", "PAGE_STATE_LOAD_QQ_VERSION_NOT_ENABLE", "PAGE_STATE_LOAD_SUCCESS", "PAGE_STATE_TIMEOUT", "QSEARCH_DETAIL_PAGE", "RESULT_STATUS", "TAG", "adapterHadInit", "Z", "openCount", "<init>", "()V", "qqecommerce_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void d() {
            if (QQKuiklyRenderView.f262856a0 && QQEcommerceSdk.INSTANCE.isInitialized()) {
                return;
            }
            QQKuiklyRenderView.f262856a0 = true;
            hf2.b.f404840a.d();
            pg2.b.f426174a.a();
            u uVar = u.f392615m;
            uVar.v(n.f262801a);
            uVar.x(r.f262806a);
            uVar.p(QQKuiklyFontAdapter.f262766a);
            uVar.w(o.f262802a);
            uVar.u(new com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.f());
            uVar.n(new com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.a());
            uVar.t(new com.tencent.mobileqq.qqecommerce.biz.kuikly.adapter.e());
            uVar.q(new QQKuiklyGlobalSwitchAdapter());
        }

        private final String e(String pagerName, String turboDisplayKey) {
            if (QQKuiklyConfigManager.f262835a.l(pagerName, turboDisplayKey)) {
                return turboDisplayKey == null ? pagerName : turboDisplayKey;
            }
            return null;
        }

        public final String b(String pagerName, String turboDisplayKey) {
            Intrinsics.checkNotNullParameter(pagerName, "pagerName");
            String e16 = e(pagerName, turboDisplayKey);
            return e16 == null || e16.length() == 0 ? e16 : c(e16);
        }

        public final boolean f(String minQQVersion) {
            Intrinsics.checkNotNullParameter(minQQVersion, "minQQVersion");
            return (minQQVersion.length() == 0) || cw.a(minQQVersion, AppSetting.f99551k) != 1;
        }

        Companion() {
        }

        private final String c(String displayKey) {
            boolean isNowThemeIsNight = ThemeUtil.isNowThemeIsNight(null, false, null);
            return displayKey + "_" + (isNowThemeIsNight ? 1 : 0) + "_" + AppSetting.f99551k + "_" + QQKuiklyPlatformApi.INSTANCE.a();
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes35.dex */
    public /* synthetic */ class b {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f262863a;

        static {
            int[] iArr = new int[ExecuteContextMode.values().length];
            try {
                iArr[ExecuteContextMode.JVM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ExecuteContextMode.DEX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f262863a = iArr;
        }
    }

    static {
        Companion companion = new Companion(null);
        INSTANCE = companion;
        companion.d();
    }

    public /* synthetic */ QQKuiklyRenderView(Context context, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : hVar, (i3 & 4) != 0 ? false : z16);
    }

    private final void A(Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result) {
        PreRequestData h16 = QQKuiklyConfigManager.f262835a.h(this.pageParams.get(KuiklyLaunchParams.PARAM_QQMC_CONFIG), this.pagerName);
        if (h16 != null) {
            this.preRequest = new QQKuiklyPrePrequest(h16, this.pageParams);
        }
        if (b0() && !Intrinsics.areEqual(this.pagerName, "QQKMPCore")) {
            QLog.i("QQKuiklyRenderView", 1, "fetchContextCode : " + this.pagerName + " isHotReloadMode true");
            this.isForceUpdate = true;
            B(result);
            return;
        }
        if (INSTANCE.f(L())) {
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c cVar = this.dexResFetcher;
            if (cVar != null) {
                C(cVar, result);
                return;
            }
            result.invoke(ExecuteContextMode.JVM, 107, "", null);
            QLog.i("QQKuiklyRenderView", 1, "resFetcher is null, run in jvm mode: " + this.pagerName);
            return;
        }
        result.invoke(ExecuteContextMode.DEX, 109, "", null);
        QLog.e("QQKuiklyRenderView", 1, "version not support, minQQVersion: " + L() + ", appVersion: " + AppSetting.f99551k + ", pageName: " + this.pagerName);
    }

    private final boolean A0() {
        if (QQTheme.isVasTheme()) {
            return !f0() || QQTheme.isBaseDIYTheme();
        }
        return false;
    }

    private final void B(final Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result) {
        QQKuiklyContextCodeFetcher.f262815a.b(this.localIp, this.pagerName, new Function2<String, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView$fetchContextCodeInHotReloadMode$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, String str2) {
                invoke2(str, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String contextCode, String str) {
                Intrinsics.checkNotNullParameter(contextCode, "contextCode");
                QLog.i("QQKuiklyRenderView", 1, "fetchContextCodeInHotReloadMode success, contextCode: " + contextCode + ", assetsPath: " + str);
                result.invoke(ExecuteContextMode.DEX, 107, contextCode, str);
            }
        });
        QQKuiklyPrePrequest qQKuiklyPrePrequest = this.preRequest;
        if (qQKuiklyPrePrequest != null) {
            qQKuiklyPrePrequest.l(true);
        }
    }

    private final boolean B0() {
        Object obj = this.pageParams.get(KuiklyLaunchParams.PARAM_SYNC_RENDERING);
        if (obj == null) {
            return true;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        return !(obj instanceof String) || Intrinsics.areEqual(obj, "1") || Intrinsics.areEqual(obj, "true");
    }

    private final void C(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher, Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result) {
        UpdateType W2 = W();
        this.isForceUpdate = false;
        QLog.i("QQKuiklyRenderView", 1, "[fetchDexResContextCode]: updateType: " + W2.getType() + ", pageName: " + this.pagerName);
        if (W2 == UpdateType.TYPE_USE_LOCAL_PRIORITY) {
            if (D(dexResFetcher, result)) {
                QLog.i("QQKuiklyRenderView", 1, "[fetchDexResContextCode] load local dex res success: " + this.pagerName);
                E0(dexResFetcher);
            } else {
                G(dexResFetcher, !v0(), result);
            }
        } else {
            G(dexResFetcher, true, result);
        }
        QQKuiklyPrePrequest qQKuiklyPrePrequest = this.preRequest;
        if (qQKuiklyPrePrequest != null) {
            qQKuiklyPrePrequest.l(this.isForceUpdate);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C0(QQKuiklyRenderView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.e("QQKuiklyRenderView", 1, "wait timeout:" + this$0.U());
        this$0.pageProgressStatus = 111;
        this$0.k0();
    }

    private final boolean D(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher, Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result) {
        String baseDexPaths;
        if (E(dexResFetcher, result)) {
            return true;
        }
        if (!v0()) {
            return false;
        }
        DexConfig d16 = dexResFetcher.d();
        long tag = d16 != null ? d16.getTag() : 0L;
        String a16 = dexResFetcher.a(this.pagerName);
        long H = H();
        QLog.i("QQKuiklyRenderView", 1, "[fetchDexResFromLocal] pageName: " + this.pagerName + ", dexTag: " + tag + ", aarTag: " + H + " dexPath:" + a16);
        String str = "";
        if (tag < H) {
            result.invoke(ExecuteContextMode.JVM, 107, "", null);
            return true;
        }
        if (a16 == null) {
            return false;
        }
        DexConfig d17 = dexResFetcher.d();
        if (d17 != null && (baseDexPaths = d17.getBaseDexPaths()) != null) {
            str = baseDexPaths;
        }
        result.invoke(ExecuteContextMode.DEX, 107, str + a16, null);
        return true;
    }

    private final boolean E(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher, Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result) {
        return false;
    }

    private final void E0(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher) {
        dexResFetcher.e(!dexResFetcher.c(), new Function1<ResError, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView$updateDexRes$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResError it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResError resError) {
                invoke2(resError);
                return Unit.INSTANCE;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F() {
        this.pageParams.put(KuiklyLaunchParams.PARAM_SYNC_RENDERING, Boolean.FALSE);
        QLog.i("QQKuiklyRenderView", 1, "force async rendering in loading ui");
    }

    private final void G(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher, boolean fourceUpdate, Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result) {
        QLog.i("QQKuiklyRenderView", 1, "[forceFetchDexResContextCode] force update dex res: " + this.pagerName);
        this.isForceUpdate = true;
        result.invoke(ExecuteContextMode.DEX, 110, "", null);
        m mVar = new m(this, result, dexResFetcher);
        this.dexResCallback = mVar;
        dexResFetcher.e(fourceUpdate, mVar);
    }

    private final long H() {
        if (!com.tencent.kuikly.core.render.android.context.h.INSTANCE.a(this.pagerName)) {
            return -1L;
        }
        Long tag = ft0.a.f400599a;
        Intrinsics.checkNotNullExpressionValue(tag, "tag");
        return tag.longValue();
    }

    private final Activity I() {
        Context context = getContext();
        if (context instanceof Activity) {
            return (Activity) context;
        }
        while (context instanceof ContextWrapper) {
            ContextWrapper contextWrapper = (ContextWrapper) context;
            if (contextWrapper.getBaseContext() instanceof Activity) {
                Context baseContext = contextWrapper.getBaseContext();
                Intrinsics.checkNotNull(baseContext, "null cannot be cast to non-null type android.app.Activity");
                return (Activity) baseContext;
            }
            context = contextWrapper.getBaseContext();
        }
        return null;
    }

    private final String J() {
        String S = S();
        return S.length() == 0 ? QQKuiklyConfigManager.f262835a.i(this.pagerName) : S;
    }

    private final String L() {
        Object obj = this.pageParams.get(KuiklyLaunchParams.PARAM_MIN_QQ_VERSION);
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    private final String M() {
        Object obj = this.pageParams.get(KuiklyLaunchParams.PARAM_MIN_RES_VERSION);
        if (obj instanceof Integer) {
            return String.valueOf(((Number) obj).intValue());
        }
        if (obj instanceof Long) {
            return String.valueOf(((Number) obj).longValue());
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        return "";
    }

    private final long N() {
        Object obj = this.pageParams.get(KuiklyLaunchParams.PARAM_OPEN_PAGE_TS);
        Long l3 = obj instanceof Long ? (Long) obj : null;
        if (l3 != null) {
            return l3.longValue();
        }
        return 0L;
    }

    private final int Q() {
        return SimpleUIUtil.getCurrentMode(((IStudyModeManager) QRoute.api(IStudyModeManager.class)).getStudyModeSwitch());
    }

    private final String R() {
        if (Intrinsics.areEqual(this.pageParams.get("is_load_on_split_mode"), Boolean.TRUE)) {
            return "1";
        }
        return "0";
    }

    private final String S() {
        Object obj = this.pageParams.get("bundle_name");
        String str = obj instanceof String ? (String) obj : null;
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long T() {
        if (b.f262863a[this.executeContextMode.ordinal()] != 2) {
            return -1L;
        }
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c cVar = this.dexResFetcher;
        if (cVar != null) {
            return cVar.f();
        }
        return 0L;
    }

    private final long U() {
        Long longOrNull;
        Object obj = this.pageParams.get("timeout");
        if (obj instanceof String) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull((String) obj);
            if (longOrNull != null) {
                return longOrNull.longValue();
            }
            return 15000L;
        }
        Long l3 = obj instanceof Long ? (Long) obj : null;
        if (l3 != null) {
            return l3.longValue();
        }
        return 15000L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String V() {
        if (b.f262863a[this.executeContextMode.ordinal()] == 1) {
            return this.pagerName;
        }
        return this.pagerName + "_" + this.executeContextMode.name();
    }

    private final UpdateType W() {
        Integer intOrNull;
        Object obj = this.pageParams.get("update_type");
        if (obj instanceof String) {
            UpdateType.Companion companion = UpdateType.INSTANCE;
            intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) obj);
            return companion.a(intOrNull != null ? intOrNull.intValue() : 0);
        }
        if (obj instanceof Integer) {
            return UpdateType.INSTANCE.a(((Number) obj).intValue());
        }
        return UpdateType.TYPE_USE_LOCAL_PRIORITY;
    }

    private final void X() {
        String J = J();
        if (J.length() > 0) {
            QLog.i("QQKuiklyRenderView", 1, "[initDexResFetcher]: resId:" + S() + " and fetcher id: " + J + ", pageName: " + this.pagerName);
            this.dexResFetcher = d.a.a(uf2.c.f438902a, J, false, 2, null);
        }
    }

    private final void Z(String pageName, Map<String, Object> params) {
        long N;
        String str;
        this.pagerName = pageName;
        this.useHostDisplayMetrics = KuiklyLaunchParams.INSTANCE.i(params.get(KuiklyLaunchParams.PARAM_USE_HOST_DISPLAY_METRICS));
        a0();
        if (QLog.isColorLevel()) {
            QLog.i("QQKuiklyRenderView", 1, "initPageParams pageName:" + pageName + " params: " + params);
        }
        this.pageParams.putAll(params);
        this.pageParams.put("page_name", pageName);
        this.pageParams.put(MiniGamePAHippyBaseFragment.KEY_THEME, Integer.valueOf(ThemeUtil.isNowThemeIsNight(null, false, null) ? 1 : 0));
        this.pageParams.put("appId", 1);
        this.pageParams.put("uin", String.valueOf(QQKuiklyPlatformApi.INSTANCE.a()));
        this.pageParams.put("isDebug", Boolean.FALSE);
        Map<String, Object> map = this.pageParams;
        Boolean bool = Boolean.TRUE;
        map.put("isPublic", bool);
        long T = T();
        this.pageParams.put("resVersion", Long.valueOf(T));
        this.reportResVersion = T;
        this.pageParams.put("buildVersion", 3);
        this.pageParams.put("isQQContainer", 1);
        this.pageParams.put("isFoldDevice", Integer.valueOf(PadUtil.a(getContext()) == DeviceType.FOLD ? 1 : 0));
        this.pageParams.put("isTabletDevice", Integer.valueOf(PadUtil.a(getContext()) != DeviceType.TABLET ? 0 : 1));
        this.pageParams.put("qqThemeMode", Integer.valueOf(Q()));
        this.pageParams.put("isClearBgColor", Integer.valueOf(h0() ? 1 : 0));
        this.pageParams.put("dpScaleDensity", Float.valueOf(Resources.getSystem().getDisplayMetrics().density));
        this.pageParams.put("qqScaleDensity", Float.valueOf(getContext().getResources().getDisplayMetrics().density / FontSettingManager.getFontScale()));
        if (N() == 0) {
            N = System.currentTimeMillis();
        } else {
            N = N();
        }
        this.pageStartTs = N;
        this.pageParams.put(KuiklyLaunchParams.PARAM_OPEN_PAGE_TS, Long.valueOf(N));
        this.launchPerformance.f(KuiklyLaunchParams.PARAM_OPEN_PAGE_TS, this.pageStartTs);
        if (g0()) {
            Map<String, Object> map2 = this.pageParams;
            IECQQApi qqApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getQqApi();
            if (qqApi == null || (str = qqApi.getLbsInfo()) == null) {
                str = "";
            }
            map2.put("lbs", str);
        }
        if (Intrinsics.areEqual(params.get("is_load_on_split_mode"), bool)) {
            this.pageParams.put("isIpad", bool);
        }
    }

    private final void a0() {
        Long l3;
        if (this.isEmbedScene) {
            Long b16 = QQKuiklyConfigManager.f262835a.b(this.pagerName);
            l3 = Long.valueOf(b16 != null ? b16.longValue() : 100L);
        } else {
            l3 = null;
        }
        this.embedSceneSyncTimeout = l3;
    }

    private final boolean b0() {
        return false;
    }

    private final boolean d0() {
        return this.pageParams.containsKey(KuiklyLaunchParams.PARAM_MODAL_MODE);
    }

    private final boolean e0() {
        return Intrinsics.areEqual(this.pageParams.get("bundle_name"), "new_qecommerce");
    }

    private final boolean f0() {
        if (QQTheme.isBaseDIYTheme()) {
            return true;
        }
        return QQTheme.isNowThemeIsDIY();
    }

    private final boolean g0() {
        return Intrinsics.areEqual("qsearch_detail", this.pagerName);
    }

    private final boolean h0() {
        Integer f16 = KuiklyLaunchParams.INSTANCE.f(this.pageParams);
        if (f16 == null || f16.intValue() != 0) {
            return false;
        }
        return A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar = this.delegate;
        if (hVar != null) {
            hVar.hideErrorView();
        }
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar2 = this.delegate;
        if (hVar2 != null) {
            hVar2.hideLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar = this.delegate;
        if (hVar != null) {
            hVar.showErrorView();
        }
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar2 = this.delegate;
        if (hVar2 != null) {
            hVar2.hideLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar = this.delegate;
        if (hVar != null) {
            hVar.hideErrorView();
        }
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar2 = this.delegate;
        if (hVar2 != null) {
            hVar2.showLoadingView();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m0(QQKuiklyRenderView this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        dialogInterface.dismiss();
        this$0.debugErrorDialog = null;
    }

    private final void p0(Throwable throwable) {
        if (QQKuiklyConfigManager.f262835a.k()) {
            CaughtExceptionReportProxy.e(new QQKuiklyException(this.pagerName + "_" + this.reportResVersion, throwable), "");
        }
    }

    private final void q0() {
        final Map mutableMapOf;
        this.launchPerformance.e("content_view_created");
        long currentTimeMillis = System.currentTimeMillis() - this.pageStartTs;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("cost_time", Long.valueOf(currentTimeMillis)), TuplesKt.to("state", Long.valueOf(System.currentTimeMillis() - this.renderStartTs)), TuplesKt.to("bundle_name", this.pagerName), TuplesKt.to("scene", R()));
        mutableMapOf.putAll(y());
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.l
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyRenderView.r0(mutableMapOf);
            }
        }, 128, null, true);
        QLog.i("QQKuiklyRenderView", 1, "reportHRPageCost cost_time:" + currentTimeMillis + " mode: " + this.executeContextMode);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r0(Map reportMap) {
        Intrinsics.checkNotNullParameter(reportMap, "$reportMap");
        IECDataReport.a.a(new ECDataReportManager(), "ec_quality_ktv_page_cost_time", reportMap, false, 4, null);
    }

    private final void s0() {
        Map mutableMapOf;
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("result_status", Integer.valueOf(this.pageProgressStatus)), TuplesKt.to("bundle_name", this.pagerName), TuplesKt.to("cost_time", Long.valueOf(System.currentTimeMillis() - this.pageStartTs)));
        mutableMapOf.putAll(y());
        IECDataReport.a.a(new ECDataReportManager(), "ec_quality_ktv_page_result", mutableMapOf, false, 4, null);
    }

    private final void t0(ExecuteContextMode executeContextMode, String msg2) {
        String str;
        Map mapOf;
        ECDataReportManager eCDataReportManager = new ECDataReportManager();
        Pair[] pairArr = new Pair[6];
        if (executeContextMode == ExecuteContextMode.DEX) {
            str = "HRDynamicAarBizException";
        } else {
            str = "HRBizException";
        }
        pairArr[0] = TuplesKt.to("error_tag", str);
        pairArr[1] = TuplesKt.to("error_msg", msg2);
        pairArr[2] = TuplesKt.to(PictureConst.KEY_CLASSNAME, this.pagerName);
        pairArr[3] = TuplesKt.to("method", this.pagerName);
        pairArr[4] = TuplesKt.to("bundle_name", this.pagerName);
        pairArr[5] = TuplesKt.to(ReportDataBuilder.KEY_BUNDLE_ID, Long.valueOf(this.reportResVersion));
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        IECDataReport.a.a(eCDataReportManager, "ec_quality_error_log", mapOf, false, 4, null);
    }

    private final boolean v0() {
        String M = M();
        if (!(M.length() == 0)) {
            com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c cVar = this.dexResFetcher;
            if (Long.parseLong(M) > (cVar != null ? cVar.f() : 0L)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w0(final Function0<Unit> task) {
        if (Intrinsics.areEqual(Thread.currentThread(), Looper.getMainLooper().getThread())) {
            task.invoke();
        } else {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.i
                @Override // java.lang.Runnable
                public final void run() {
                    QQKuiklyRenderView.x0(Function0.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    private final Map<Object, Object> y() {
        Map<Object, Object> mutableMapOf;
        Map<Object, Object> mutableMapOf2;
        if (this.executeContextMode == ExecuteContextMode.JVM) {
            mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("open_page_count", Integer.valueOf(W)));
            return mutableMapOf2;
        }
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("config_mode", Integer.valueOf(this.configExecuteContextMode.value)), TuplesKt.to("execute_mode", Integer.valueOf(this.executeContextMode.value)), TuplesKt.to(ReportDataBuilder.KEY_BUNDLE_ID, Long.valueOf(this.reportResVersion)), TuplesKt.to("type", Integer.valueOf(!this.isForceUpdate ? 1 : 0)), TuplesKt.to("async_load", Integer.valueOf(this.pageParams.containsKey("kr_async_loader_id") ? 1 : 0)), TuplesKt.to("open_page_count", Integer.valueOf(W)));
        return mutableMapOf;
    }

    private final void z() {
        try {
            Dialog dialog = this.debugErrorDialog;
            if (dialog != null) {
                dialog.dismiss();
            }
            this.debugErrorDialog = null;
        } catch (Throwable th5) {
            QLog.e("QQKuiklyRenderView", 1, "hide debug dialog error: " + th5);
        }
    }

    private final void z0() {
        String str;
        if (tf2.a.b(this.pageParams)) {
            setBackground(new ColorDrawable(0));
            return;
        }
        if (!g0() && !h0()) {
            if (ThemeUtil.isNowThemeIsNight(null, false, null)) {
                str = "#FF1A1A1A";
            } else {
                str = "#FFFFFFFF";
            }
            setBackground(new ColorDrawable(Color.parseColor(str)));
            return;
        }
        setBackground(new ColorDrawable(1));
        IECResourceApi resourceApi = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getResourceApi();
        if (resourceApi != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            resourceApi.fetchDrawable(context, "qui_image://common_bg_bottom_standard_bg", (IECImageLoader.ImageLoaderOption) null, new Function3<Drawable, Integer, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView$setBackgroundColor$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(Drawable drawable, Integer num, String str2) {
                    invoke(drawable, num.intValue(), str2);
                    return Unit.INSTANCE;
                }

                public final void invoke(Drawable drawable, int i3, String msg2) {
                    Intrinsics.checkNotNullParameter(msg2, "msg");
                    if (drawable != null) {
                        QQKuiklyRenderView.this.setBackground(drawable);
                    }
                }
            });
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public KuiklyRenderCoreExecuteMode C2() {
        if (this.isHotReloadMode) {
            return KuiklyRenderCoreExecuteMode.DEX;
        }
        if (b.f262863a[this.executeContextMode.ordinal()] == 2) {
            return KuiklyRenderCoreExecuteMode.DEX;
        }
        return KuiklyRenderCoreExecuteMode.JVM;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean Cc() {
        return this.pageParams.containsKey("kr_enable_async_load");
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ff(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.q(this, kuiklyRenderExport);
        QQKuiklyExport.f262900a.registerTDFlModule(kuiklyRenderExport);
        Iterator<T> it = sf2.a.f433766a.a().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e) it.next()).registerTDFlModule(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Ia(Throwable throwable, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        String stackTraceToString;
        String stackTraceToString2;
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Intrinsics.checkNotNullParameter(errorReason, "errorReason");
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        if (b0()) {
            Context context = getContext();
            stackTraceToString2 = ExceptionsKt__ExceptionsKt.stackTraceToString(throwable);
            QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(context, 230, (String) null, stackTraceToString2, (String) null, "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.j
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    QQKuiklyRenderView.m0(QQKuiklyRenderView.this, dialogInterface, i3);
                }
            }, (DialogInterface.OnClickListener) null);
            createCustomDialog.getBtnLeft().setTypeface(Typeface.DEFAULT_BOLD);
            createCustomDialog.getBtnight().setTypeface(Typeface.DEFAULT_BOLD);
            createCustomDialog.show();
            this.debugErrorDialog = createCustomDialog;
            return;
        }
        ExecuteContextMode executeContextMode = this.executeContextMode;
        stackTraceToString = ExceptionsKt__ExceptionsKt.stackTraceToString(throwable);
        t0(executeContextMode, stackTraceToString);
        p0(throwable);
    }

    /* renamed from: K, reason: from getter */
    public final com.tencent.mobileqq.qqecommerce.biz.kuikly.api.i getLaunchPerformance() {
        return this.launchPerformance;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    /* renamed from: K0, reason: from getter */
    public Long getEmbedSceneSyncTimeout() {
        return this.embedSceneSyncTimeout;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    /* renamed from: M0, reason: from getter */
    public boolean getUseHostDisplayMetrics() {
        return this.useHostDisplayMetrics;
    }

    public final Map<String, Object> O() {
        return this.pageParams;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public Map<String, Object> O1() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (ImmersiveUtils.statusHeight != -1) {
            linkedHashMap.put("statusBarHeight", Float.valueOf(a().a(ImmersiveUtils.statusHeight)));
        }
        Object obj = this.pageParams.get(KuiklyLaunchParams.PARAM_BOTTOM_NAV_BAR_HEIGHT);
        if (obj instanceof Integer) {
            if (((Number) obj).intValue() > 0) {
                linkedHashMap.put("safeAreaInsets", a().a(ImmersiveUtils.statusHeight) + " 0 " + a().a(r1.intValue()) + " 0");
            }
        }
        return linkedHashMap;
    }

    /* renamed from: P, reason: from getter */
    public final QQKuiklyPrePrequest getPreRequest() {
        return this.preRequest;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public Integer Re() {
        return a.C5872a.s(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void Sa() {
        a.C5872a.i(this);
        this.pageProgressStatus = 5;
        q0();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public String V0() {
        Companion companion = INSTANCE;
        String str = this.pagerName;
        Object obj = this.pageParams.get(KuiklyLaunchParams.PARAM_TURBO_DISPLAY);
        return companion.b(str, obj instanceof String ? (String) obj : null);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public l01.a a() {
        return this.kuiklyRenderViewDelegator.j();
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public void b(final String pageName, Map<String, Object> params, final Size size) {
        Intrinsics.checkNotNullParameter(pageName, "pageName");
        Intrinsics.checkNotNullParameter(params, "params");
        INSTANCE.d();
        W++;
        Z(pageName, params);
        z0();
        this.launchPerformance.e("fetch_context_code_start");
        X();
        this.mHandler.postDelayed(this.timeoutRunnable, U());
        A(new Function4<ExecuteContextMode, Integer, String, String, Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView$onAttach$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(ExecuteContextMode executeContextMode, Integer num, String str, String str2) {
                invoke(executeContextMode, num.intValue(), str, str2);
                return Unit.INSTANCE;
            }

            public final void invoke(final ExecuteContextMode mode, final int i3, final String contextCode, final String str) {
                Intrinsics.checkNotNullParameter(mode, "mode");
                Intrinsics.checkNotNullParameter(contextCode, "contextCode");
                final QQKuiklyRenderView qQKuiklyRenderView = QQKuiklyRenderView.this;
                final String str2 = pageName;
                final Size size2 = size;
                qQKuiklyRenderView.w0(new Function0<Unit>() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.QQKuiklyRenderView$onAttach$1.1
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
                        Handler handler;
                        Runnable runnable;
                        long T;
                        boolean z16;
                        String V;
                        KuiklyRenderViewDelegator kuiklyRenderViewDelegator;
                        QQKuiklyRenderView.this.pageProgressStatus = i3;
                        QQKuiklyRenderView.this.executeContextMode = mode;
                        handler = QQKuiklyRenderView.this.mHandler;
                        runnable = QQKuiklyRenderView.this.timeoutRunnable;
                        handler.removeCallbacks(runnable);
                        switch (i3) {
                            case 107:
                                QQKuiklyRenderView.this.j0();
                                T = QQKuiklyRenderView.this.T();
                                QQKuiklyRenderView.this.O().put("resVersion", Long.valueOf(T));
                                QQKuiklyRenderView.this.reportResVersion = T;
                                QQKuiklyRenderView.this.getLaunchPerformance().e("fetch_context_code_end");
                                com.tencent.mobileqq.qqecommerce.biz.kuikly.api.i launchPerformance = QQKuiklyRenderView.this.getLaunchPerformance();
                                z16 = QQKuiklyRenderView.this.isForceUpdate;
                                launchPerformance.c(z16);
                                IPerfApi iPerfApi = (IPerfApi) QRoute.api(IPerfApi.class);
                                V = QQKuiklyRenderView.this.V();
                                iPerfApi.traceStart(V);
                                kuiklyRenderViewDelegator = QQKuiklyRenderView.this.kuiklyRenderViewDelegator;
                                QQKuiklyRenderView qQKuiklyRenderView2 = QQKuiklyRenderView.this;
                                kuiklyRenderViewDelegator.p(qQKuiklyRenderView2, contextCode, str2, qQKuiklyRenderView2.O(), size2, str);
                                return;
                            case 108:
                            case 109:
                                QQKuiklyRenderView.this.k0();
                                return;
                            case 110:
                                QQKuiklyRenderView.this.F();
                                QQKuiklyRenderView.this.l0();
                                return;
                            default:
                                return;
                        }
                    }
                });
            }
        });
        Y();
        if ((g0() && ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_search_page_load_ec_skin", false)) || e0()) {
            pg2.b bVar = pg2.b.f426174a;
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            bVar.b(context);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    /* renamed from: c, reason: from getter */
    public com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h getDelegate() {
        return this.delegate;
    }

    /* renamed from: c0, reason: from getter */
    public final boolean getHadDetach() {
        return this.hadDetach;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean c1() {
        return this.pageParams.containsKey("kr_enable_async_load");
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public void d(String scheme, Size size) {
        Intrinsics.checkNotNullParameter(scheme, "scheme");
        Map<String, Object> c16 = tf2.a.c(scheme);
        Object obj = c16.get("page_name");
        String str = obj instanceof String ? (String) obj : null;
        if (str == null) {
            str = "";
        }
        b(str, c16, size);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public List<KRMonitorType> ec() {
        return a.C5872a.n(this);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean h4() {
        return (this.isHotReloadMode || d0() || !B0()) ? false : true;
    }

    public final void i0(ResError resError, Function4<? super ExecuteContextMode, ? super Integer, ? super String, ? super String, Unit> result, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.c dexResFetcher) {
        Intrinsics.checkNotNullParameter(resError, "resError");
        Intrinsics.checkNotNullParameter(result, "result");
        Intrinsics.checkNotNullParameter(dexResFetcher, "dexResFetcher");
        QLog.e("QQKuiklyRenderView", 1, "[forceFetchDexResContextCode]: code: " + resError.getCode() + ", msg: " + resError.getMessage() + ", pageName: " + this.pagerName);
        if (D(dexResFetcher, result)) {
            QLog.i("QQKuiklyRenderView", 1, "[forceFetchDexResContextCode]: load local dex success: " + this.pagerName);
            return;
        }
        if (com.tencent.kuikly.core.render.android.context.h.INSTANCE.a(this.pagerName)) {
            result.invoke(ExecuteContextMode.JVM, 107, "", null);
            QLog.i("QQKuiklyRenderView", 1, "force fetch dex in error, back jvm mode: " + this.pagerName);
            return;
        }
        result.invoke(ExecuteContextMode.DEX, 108, "", null);
        QLog.e("QQKuiklyRenderView", 1, "[forceFetchDexResContextCode]: load local dex error: " + this.pagerName);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void le(com.tencent.kuikly.core.render.android.performace.c cVar) {
        a.C5872a.h(this, cVar);
    }

    public final void n0() {
        this.kuiklyRenderViewDelegator.u();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean ng() {
        return (this.isHotReloadMode || d0() || !B0()) ? false : true;
    }

    public final void o0(Context newContext) {
        Intrinsics.checkNotNullParameter(newContext, "newContext");
        this.kuiklyRenderViewDelegator.z(newContext);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public void onDetach() {
        m mVar = this.dexResCallback;
        if (mVar != null) {
            mVar.b();
        }
        this.kuiklyRenderViewDelegator.r();
        s0();
        D0();
        this.mHandler.removeCallbacks(this.timeoutRunnable);
        z();
        this.hadDetach = true;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void onPageLoadComplete(boolean isSucceed, ErrorReason errorReason, KuiklyRenderCoreExecuteMode executeMode) {
        Intrinsics.checkNotNullParameter(executeMode, "executeMode");
        a.C5872a.k(this, isSucceed, errorReason, executeMode);
        com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar = this.delegate;
        if (hVar != null) {
            hVar.onPageLoadComplete(isSucceed, errorReason, executeMode);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public void onPause() {
        this.kuiklyRenderViewDelegator.s();
        ((IPerfApi) QRoute.api(IPerfApi.class)).traceEnd(V());
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public void onResume() {
        this.kuiklyRenderViewDelegator.t();
        ((IPerfApi) QRoute.api(IPerfApi.class)).traceStart(V());
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void p9() {
        a.C5872a.j(this);
        this.pageProgressStatus = 3;
        this.renderStartTs = System.currentTimeMillis();
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void pg(j01.a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        a.C5872a.g(this, data);
        this.launchPerformance.d(data);
        QLog.i("QQKuiklyRenderView", 1, "pageName: " + this.pagerName + ", data:" + data + " launchData: " + this.launchPerformance);
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalModule(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.o(this, kuiklyRenderExport);
        QQKuiklyExport.f262900a.registerExternalModule(kuiklyRenderExport);
        Iterator<T> it = sf2.a.f433766a.a().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e) it.next()).registerExternalModule(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerExternalRenderView(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.p(this, kuiklyRenderExport);
        QQKuiklyExport.f262900a.registerExternalRenderView(kuiklyRenderExport);
        Iterator<T> it = sf2.a.f433766a.a().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e) it.next()).registerExternalRenderView(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public void registerViewExternalPropHandler(com.tencent.kuikly.core.render.android.b kuiklyRenderExport) {
        Intrinsics.checkNotNullParameter(kuiklyRenderExport, "kuiklyRenderExport");
        a.C5872a.r(this, kuiklyRenderExport);
        QQKuiklyExport.f262900a.registerViewExternalPropHandler(kuiklyRenderExport);
        Iterator<T> it = sf2.a.f433766a.a().iterator();
        while (it.hasNext()) {
            ((com.tencent.mobileqq.qqecommerce.biz.kuikly.api.e) it.next()).registerViewExternalPropHandler(kuiklyRenderExport);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public void sentEvent(String eventName, Map<String, ? extends Object> data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        this.kuiklyRenderViewDelegator.B(eventName, data);
    }

    public final void setActivityResult(JSONObject data) {
        Intent intent;
        Intrinsics.checkNotNullParameter(data, "data");
        Integer d16 = KuiklyLaunchParams.INSTANCE.d(this.pageParams);
        if (d16 != null) {
            if (data.optInt(QZoneNavigateToQQTransparentFragment.EXTRA_KEY_REQUEST_CODE) != d16.intValue()) {
                return;
            }
            int optInt = data.optInt("result_code");
            JSONObject optJSONObject = data.optJSONObject("data");
            if (optJSONObject == null || (intent = nf2.a.d(optJSONObject)) == null) {
                intent = new Intent();
            }
            intent.putExtra("page_name", data.optString("page_name"));
            Activity I = I();
            if (I != null) {
                I.setResult(optInt, intent);
            }
        }
    }

    public final void setLaunchPerformance(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.i iVar) {
        Intrinsics.checkNotNullParameter(iVar, "<set-?>");
        this.launchPerformance = iVar;
    }

    public final void setPageParams(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.pageParams = map;
    }

    public final void setPreRequest(QQKuiklyPrePrequest qQKuiklyPrePrequest) {
        this.preRequest = qQKuiklyPrePrequest;
    }

    public final void setQQKuiklyRenderViewDelegate(com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h delegate) {
        this.delegate = delegate;
    }

    @Override // com.tencent.kuikly.core.render.android.expand.a
    public boolean u0() {
        Object obj = this.pageParams.get(KuiklyLaunchParams.PARAM_BOTTOM_NAV_BAR_HEIGHT);
        return (obj instanceof Integer) && ((Number) obj).intValue() > 0;
    }

    public void y0(String eventName, Object data) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        this.kuiklyRenderViewDelegator.B(eventName, data);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public QQKuiklyRenderView(Context context, com.tencent.mobileqq.qqecommerce.biz.kuikly.api.h hVar, boolean z16) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.delegate = hVar;
        this.isEmbedScene = z16;
        this.kuiklyRenderViewDelegator = new KuiklyRenderViewDelegator(this);
        this.pageParams = new LinkedHashMap();
        this.pagerName = "";
        this.reportResVersion = -1L;
        this.launchPerformance = new com.tencent.mobileqq.qqecommerce.biz.kuikly.api.i();
        ExecuteContextMode executeContextMode = ExecuteContextMode.JVM;
        this.configExecuteContextMode = executeContextMode;
        this.executeContextMode = executeContextMode;
        this.localIp = "";
        this.mHandler = new Handler(Looper.getMainLooper());
        this.timeoutRunnable = new Runnable() { // from class: com.tencent.mobileqq.qqecommerce.biz.kuikly.container.k
            @Override // java.lang.Runnable
            public final void run() {
                QQKuiklyRenderView.C0(QQKuiklyRenderView.this);
            }
        };
        setClipChildren(false);
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.kuikly.api.g
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 10000) {
            pg2.b.f426174a.c(resultCode, data);
        }
        this.kuiklyRenderViewDelegator.o(requestCode, resultCode, data);
    }

    private final void D0() {
    }

    private final void Y() {
    }
}
