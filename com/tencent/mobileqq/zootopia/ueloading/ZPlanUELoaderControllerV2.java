package com.tencent.mobileqq.zootopia.ueloading;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.SparseArray;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.epicgames.ue4.UE4;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.guild.aio.util.PostUtilKt;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.z1.download.data.ZPlanModVersionSimpleData;
import com.tencent.mobileqq.z1.download.data.ZootopiaDownloadParams;
import com.tencent.mobileqq.z1.download.data.ZootopiaExtraData;
import com.tencent.mobileqq.z1.download.data.ZootopiaSummaryData;
import com.tencent.mobileqq.z1.download.diffpatch.ZPlanMapDiffPatchInfo;
import com.tencent.mobileqq.zootopia.ZootopiaLoadingErrMod;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.ZootopiaDownloadManagerIpc;
import com.tencent.mobileqq.zootopia.entry.IEntryApi;
import com.tencent.mobileqq.zootopia.ipc.an;
import com.tencent.mobileqq.zootopia.portal.detail.ZootopiaDetailFragment;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportHelper;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUETechReportParams;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.mobileqq.zplan.mod.impl.helper.ModDownloadHelper;
import com.tencent.mobileqq.zplan.smallhome.event.ZplanHideLoadingEvent;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatus;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForModProcess;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.util.QQToastUtil;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import defpackage.UEBuglyInfoRecorder;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import k74.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import pv4.y;
import qv4.aw;
import ud3.c;
import vd3.PrepareErr;
import vd3.PrepareResult;

@Metadata(d1 = {"\u0000\u00f0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001KBi\u0012\b\u0010Q\u001a\u0004\u0018\u00010L\u0012\b\u0010D\u001a\u0004\u0018\u000106\u0012\b\u0010]\u001a\u0004\u0018\u00010X\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010^\u0012\b\b\u0002\u0010f\u001a\u00020\u0005\u0012\n\b\u0002\u0010l\u001a\u0004\u0018\u00010g\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010t\u001a\u0004\u0018\u00010p\u0012\n\b\u0002\u0010z\u001a\u0004\u0018\u00010u\u00a2\u0006\u0006\b\u00ae\u0001\u0010\u00af\u0001J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J \u0010\u0011\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0014\u0010\u0013\u001a\u00020\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0002J \u0010\u0014\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0015\u001a\u00020\u0007H\u0002J\u0018\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0017H\u0002J\u001c\u0010\u001d\u001a\u00020\u001c2\b\b\u0002\u0010\u001b\u001a\u00020\u00052\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002J\u0018\u0010!\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0002J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0007H\u0002J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$2\u0006\u0010'\u001a\u00020&H\u0002J\u0010\u0010)\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0002J\u0010\u0010-\u001a\u00020,2\u0006\u0010+\u001a\u00020*H\u0002J\u0018\u00100\u001a\u00020\u00072\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0005H\u0016J\b\u00101\u001a\u00020\u0007H\u0016J\u0010\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u000202H\u0016J\u0010\u00105\u001a\u00020\u00072\u0006\u0010/\u001a\u00020\u0005H\u0016J\u0018\u00108\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u001f2\u0006\u00107\u001a\u000206H\u0016J\"\u0010;\u001a\u00020\u00072\b\u0010:\u001a\u0004\u0018\u0001092\u0006\u0010 \u001a\u00020\u001f2\u0006\u00107\u001a\u000206H\u0016J*\u0010>\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J\u0012\u0010?\u001a\u00020\u00072\b\u0010=\u001a\u0004\u0018\u00010<H\u0016J:\u0010A\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010<2\u0006\u0010@\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u0003H\u0016J\u0010\u0010B\u001a\u00020\u00072\u0006\u0010=\u001a\u00020<H\u0016J\b\u0010C\u001a\u00020\u0007H\u0016J\u0012\u0010E\u001a\u00020\u00072\b\u0010D\u001a\u0004\u0018\u000106H\u0016J\b\u0010F\u001a\u00020\u0007H\u0016J\b\u0010G\u001a\u00020\u0007H\u0016J\b\u0010H\u001a\u00020\u0007H\u0016J\u0010\u0010J\u001a\u00020\u00072\u0006\u0010I\u001a\u00020\u0005H\u0016J\u0010\u0010K\u001a\u00020\u00072\u0006\u0010%\u001a\u00020$H\u0016R\u0019\u0010Q\u001a\u0004\u0018\u00010L8\u0006\u00a2\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR$\u0010D\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bR\u0010S\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\u0019\u0010]\u001a\u0004\u0018\u00010X8\u0006\u00a2\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\R\u0019\u0010.\u001a\u0004\u0018\u00010^8\u0006\u00a2\u0006\f\n\u0004\b_\u0010`\u001a\u0004\ba\u0010bR\u0017\u0010f\u001a\u00020\u00058\u0006\u00a2\u0006\f\n\u0004\bc\u0010\u000b\u001a\u0004\bd\u0010eR\u0019\u0010l\u001a\u0004\u0018\u00010g8\u0006\u00a2\u0006\f\n\u0004\bh\u0010i\u001a\u0004\bj\u0010kR\u0017\u0010=\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010m\u001a\u0004\bn\u0010oR\u0019\u0010t\u001a\u0004\u0018\u00010p8\u0006\u00a2\u0006\f\n\u0004\bT\u0010q\u001a\u0004\br\u0010sR\u0019\u0010z\u001a\u0004\u0018\u00010u8\u0006\u00a2\u0006\f\n\u0004\bv\u0010w\u001a\u0004\bx\u0010yR\u001c\u0010\u0080\u0001\u001a\u00020{8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b|\u0010}\u001a\u0004\b~\u0010\u007fR'\u0010\u0085\u0001\u001a\u00020\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0016\n\u0005\b[\u0010\u0081\u0001\u001a\u0005\bv\u0010\u0082\u0001\"\u0006\b\u0083\u0001\u0010\u0084\u0001R*\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\br\u0010\u0081\u0001\u001a\u0006\b\u0086\u0001\u0010\u0082\u0001\"\u0006\b\u0087\u0001\u0010\u0084\u0001R*\u0010\u008b\u0001\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0017\n\u0005\bx\u0010\u0081\u0001\u001a\u0006\b\u0089\u0001\u0010\u0082\u0001\"\u0006\b\u008a\u0001\u0010\u0084\u0001R%\u0010/\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0015\n\u0004\bn\u0010\u000b\u001a\u0005\b\u008c\u0001\u0010e\"\u0006\b\u008d\u0001\u0010\u008e\u0001R%\u0010\u0090\u0001\u001a\u00020\u00058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0014\n\u0004\bj\u0010\u000b\u001a\u0004\b|\u0010e\"\u0006\b\u008f\u0001\u0010\u008e\u0001R\u001b\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0091\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\ba\u0010\u0092\u0001R\u001e\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0095\u00010\u0094\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b~\u0010\u0096\u0001R\u0017\u0010\u009a\u0001\u001a\u00030\u0098\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\bd\u0010\u0099\u0001R\u0017\u0010\u009b\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u000bR\u0018\u0010\u009d\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u009c\u0001\u0010\u000bR\u0017\u0010\u009e\u0001\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000bR\u0017\u0010\u009f\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010nR\u0018\u0010\u00a1\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010nR\u0018\u0010\u00a2\u0001\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u008c\u0001\u0010nR\u001b\u0010\u00a5\u0001\u001a\u0005\u0018\u00010\u00a3\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b?\u0010\u00a4\u0001R\u0018\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u001c\u0010\u00ad\u0001\u001a\u0005\u0018\u00010\u00aa\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001\u00a8\u0006\u00b0\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "Lud3/c;", "Lvd3/c;", "", "fromSource", "", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_IS_DOWNLOADED, "", "w", "k0", "v", "Z", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/zootopia/ZootopiaLoadingErrMod;", "mod", BdhLogUtil.LogTag.Tag_Req, "hintTxt", "P", ExifInterface.LATITUDE_SOUTH, "a0", "isSuccess", "", "stepCost", "d0", "e0", "needDownloadCommonMod", "Lcom/tencent/mobileqq/zootopia/ueloading/report/c;", "t", "success", "Lorg/json/JSONObject;", "params", "O", BdhLogUtil.LogTag.Tag_Conn, "i0", "Lvd3/f;", "result", "Lvd3/e;", NotificationCompat.CATEGORY_ERROR, "b0", "y", "Lqv4/aw;", "updateInfo", "Lcom/tencent/mobileqq/z1/download/data/ZootopiaDownloadParams;", "Y", "source", "isBackLoad", "Y8", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "statusInfo", "updateStatus", "jf", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "curFullEnterParams", ReportConstant.COSTREPORT_PREFIX, "Ldy4/a;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/zootopia/l;", "progressRecord", "X2", "V", "reportMod", "K5", "f0", "onResume", "enterParams", "t8", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "fc", "p0", "onEngineInitFinish", "a", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "B", "()Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "e", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "D", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "setEnterParams", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;)V", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "f", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "G", "()Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "loadingController", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", tl.h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "L", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "i", "N", "()Z", "useV2Loading", "Lcom/tencent/sqshow/zootopia/report/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/report/b;", "K", "()Lcom/tencent/sqshow/zootopia/report/b;", "reporter", "Lcom/tencent/mobileqq/zootopia/l;", "J", "()Lcom/tencent/mobileqq/zootopia/l;", "Lud3/a;", "Lud3/a;", "H", "()Lud3/a;", "modLoadListener", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "E", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "I", "()Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "pluginManager", "Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper;", UserInfo.SEX_FEMALE, "Lkotlin/Lazy;", "M", "()Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper;", "ueReportHelper", "Ljava/lang/String;", "()Ljava/lang/String;", "setEnterSource", "(Ljava/lang/String;)V", "enterSource", "getDownloadText", "g0", "downloadText", "getLaunchText", "h0", "launchText", "U", "setBackLoad", "(Z)V", "setHasDestroyed", "hasDestroyed", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "countDownTimer", "Landroid/util/SparseArray;", "Lwe3/b;", "Landroid/util/SparseArray;", "startEngineListenerPool", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "startEngineCounter", "isFirstFrameReady", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "triggeredEnterMap", "shouldReEnterSceneWhenResume", "startTime", "T", "runEnterAvatarSuccessTime", "firstFrameTime", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "lastCallbackStatus", "Lvd3/g;", "W", "Lvd3/g;", "mUELoaderPreparer", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "X", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "worldStatusListener", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ZLcom/tencent/sqshow/zootopia/report/b;Lcom/tencent/mobileqq/zootopia/l;Lud3/a;Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUELoaderControllerV2 implements ud3.c, vd3.c {

    /* renamed from: Y, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final HashMap<String, Long> Z = new HashMap<>();

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.l progressRecord;

    /* renamed from: D, reason: from kotlin metadata */
    private final ud3.a modLoadListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final UEActivityPluginManager pluginManager;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy ueReportHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private String enterSource;

    /* renamed from: H, reason: from kotlin metadata */
    private String downloadText;

    /* renamed from: I, reason: from kotlin metadata */
    private String launchText;

    /* renamed from: J, reason: from kotlin metadata */
    private volatile boolean isBackLoad;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile boolean hasDestroyed;

    /* renamed from: L, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: M, reason: from kotlin metadata */
    private final SparseArray<we3.b> startEngineListenerPool;

    /* renamed from: N, reason: from kotlin metadata */
    private final AtomicInteger startEngineCounter;

    /* renamed from: P, reason: from kotlin metadata */
    private volatile boolean isFirstFrameReady;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean triggeredEnterMap;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean shouldReEnterSceneWhenResume;

    /* renamed from: S, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: T, reason: from kotlin metadata */
    private long runEnterAvatarSuccessTime;

    /* renamed from: U, reason: from kotlin metadata */
    private long firstFrameTime;

    /* renamed from: V, reason: from kotlin metadata */
    private ZPlanModLoadStatus lastCallbackStatus;

    /* renamed from: W, reason: from kotlin metadata */
    private final vd3.g mUELoaderPreparer;

    /* renamed from: X, reason: from kotlin metadata */
    private IZPlanWorldStatusListener worldStatusListener;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaUEActivity activity;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ZootopiaEnterParams enterParams;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final ZPlanUELoadingController loadingController;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource source;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final boolean useV2Loading;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.sqshow.zootopia.report.b reporter;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000bR0\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\fj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006`\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2$a;", "", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2;", "a", "", "DEFAULT_COUNT_DOWN_TIME", "J", "", "TAG", "Ljava/lang/String;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "loadingStartTimeMap", "Ljava/util/HashMap;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanUELoaderControllerV2 a(ZootopiaEnterParams enterParams) {
            Intrinsics.checkNotNullParameter(enterParams, "enterParams");
            com.tencent.mobileqq.zootopia.l lVar = new com.tencent.mobileqq.zootopia.l();
            lVar.j(enterParams.getLoadingId());
            return new ZPlanUELoaderControllerV2(null, enterParams, null, ag.f373258a.b(), true, null, lVar, null, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2$b", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IZPlanWorldStatusListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f329409d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderControllerV2 f329410e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f329411f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f329412h;

        b(long j3, ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2, JSONObject jSONObject, ZootopiaEnterParams zootopiaEnterParams) {
            this.f329409d = j3;
            this.f329410e = zPlanUELoaderControllerV2;
            this.f329411f = jSONObject;
            this.f329412h = zootopiaEnterParams;
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onEnterSceneResult(boolean success) {
            IZPlanWorldStatusListener.a.a(this, success);
            long currentTimeMillis = System.currentTimeMillis() - this.f329409d;
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "backEnterAvatarScene, onEnterSceneResult, result:" + success + ", stepCost: " + currentTimeMillis);
            this.f329410e.d0(success, currentTimeMillis);
            this.f329410e.O(success, this.f329411f);
            ud3.a modLoadListener = this.f329410e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.j2(success, this.f329411f, this.f329412h);
            }
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onFirstFrame(FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            long currentTimeMillis = System.currentTimeMillis() - this.f329409d;
            ud3.a modLoadListener = this.f329410e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.W0(result);
            }
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "backEnterAvatarScene, onFirstFrame, useV2Loading: " + this.f329410e.getUseV2Loading() + ", stepCost: " + currentTimeMillis);
            com.tencent.sqshow.zootopia.report.b reporter = this.f329410e.getReporter();
            if (reporter != null) {
                reporter.e();
            }
            this.f329410e.isFirstFrameReady = true;
            ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2 = this.f329410e;
            zPlanUELoaderControllerV2.V(zPlanUELoaderControllerV2.getProgressRecord());
            CountDownTimer countDownTimer = this.f329410e.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f329410e.e0(currentTimeMillis);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2$c", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements IZPlanWorldStatusListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f329413d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderControllerV2 f329414e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f329415f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f329416h;

        c(long j3, ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2, JSONObject jSONObject, ZootopiaEnterParams zootopiaEnterParams) {
            this.f329413d = j3;
            this.f329414e = zPlanUELoaderControllerV2;
            this.f329415f = jSONObject;
            this.f329416h = zootopiaEnterParams;
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onEnterSceneResult(boolean success) {
            IZPlanWorldStatusListener.a.a(this, success);
            long currentTimeMillis = System.currentTimeMillis() - this.f329413d;
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "foreground enterAvatarScene, onEnterSceneResult, result:" + success + ", stepCost: " + currentTimeMillis);
            this.f329414e.d0(success, currentTimeMillis);
            this.f329414e.O(success, this.f329415f);
            ud3.a modLoadListener = this.f329414e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.j2(success, this.f329415f, this.f329416h);
            }
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onFirstFrame(FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            long currentTimeMillis = System.currentTimeMillis() - this.f329413d;
            ud3.a modLoadListener = this.f329414e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.W0(result);
            }
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "foreground enterAvatarScene, onFirstFrame, useV2Loading: " + this.f329414e.getUseV2Loading() + ", stepCost: " + currentTimeMillis);
            com.tencent.sqshow.zootopia.report.b reporter = this.f329414e.getReporter();
            if (reporter != null) {
                reporter.e();
            }
            this.f329414e.isFirstFrameReady = true;
            this.f329414e.triggeredEnterMap = true;
            ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2 = this.f329414e;
            zPlanUELoaderControllerV2.V(zPlanUELoaderControllerV2.getProgressRecord());
            CountDownTimer countDownTimer = this.f329414e.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f329414e.e0(currentTimeMillis);
            ((qk3.a) k74.i.INSTANCE.a(qk3.a.class)).onModFirstFrameCallback(this.f329415f);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2$e", "Lwe3/b;", "", "success", "", "startEngineState", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements we3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f329418a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f329419b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderControllerV2 f329420c;

        e(long j3, int i3, ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2) {
            this.f329418a = j3;
            this.f329419b = i3;
            this.f329420c = zPlanUELoaderControllerV2;
        }

        @Override // we3.b
        public void a(boolean success, int startEngineState) {
            String str;
            long currentTimeMillis = System.currentTimeMillis() - this.f329418a;
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "handleAuthorizeResult handleStartMap:" + success + ", currentIndex:" + this.f329419b + " cost:" + currentTimeMillis);
            this.f329420c.startEngineListenerPool.remove(this.f329419b);
            com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
            ZootopiaEnterParams enterParams = this.f329420c.getEnterParams();
            int mapId = enterParams != null ? enterParams.getMapId() : 0;
            ZootopiaEnterParams enterParams2 = this.f329420c.getEnterParams();
            if (enterParams2 == null || (str = enterParams2.getSource()) == null) {
                str = "0";
            }
            bVar.x(mapId, str, String.valueOf(currentTimeMillis), String.valueOf(currentTimeMillis), success);
        }
    }

    public ZPlanUELoaderControllerV2(ZootopiaUEActivity zootopiaUEActivity, ZootopiaEnterParams zootopiaEnterParams, ZPlanUELoadingController zPlanUELoadingController, ZootopiaSource zootopiaSource, boolean z16, com.tencent.sqshow.zootopia.report.b bVar, com.tencent.mobileqq.zootopia.l progressRecord, ud3.a aVar, UEActivityPluginManager uEActivityPluginManager) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(progressRecord, "progressRecord");
        this.activity = zootopiaUEActivity;
        this.enterParams = zootopiaEnterParams;
        this.loadingController = zPlanUELoadingController;
        this.source = zootopiaSource;
        this.useV2Loading = z16;
        this.reporter = bVar;
        this.progressRecord = progressRecord;
        this.modLoadListener = aVar;
        this.pluginManager = uEActivityPluginManager;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanUEReportHelper>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2$ueReportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanUEReportHelper invoke() {
                return new ZPlanUEReportHelper(ZPlanUELoaderControllerV2.this.getSource(), ZPlanUELoaderControllerV2.this.getEnterParams());
            }
        });
        this.ueReportHelper = lazy;
        this.enterSource = "0";
        this.startEngineListenerPool = new SparseArray<>();
        this.startEngineCounter = new AtomicInteger(0);
        this.mUELoaderPreparer = new vd3.g();
        k0();
    }

    private final long C() {
        long currentTimeMillis = System.currentTimeMillis();
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        return currentTimeMillis - (zootopiaEnterParams != null ? zootopiaEnterParams.getStartTime() : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void O(boolean success, JSONObject params) {
        String jSONObject = params.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "params.toString()");
        ZplanAVControllerForQAV.Companion companion = ZplanAVControllerForQAV.INSTANCE;
        if (companion.t(params.optInt("GameId"))) {
            companion.f();
            companion.h(true);
        }
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "backToActivity=" + companion.l() + " onEnterSceneResult : " + success + ", " + jSONObject);
        int optInt = params.optInt("GameId");
        if (success && params.optInt("FromScene") == 1 && companion.t(optInt)) {
            if (companion.m()) {
                companion.E(false);
            } else {
                if (params.optLong("conectedTime") > 0) {
                    com.tencent.mobileqq.zplan.proxy.a.INSTANCE.c(params.optLong("conectedTime"));
                    QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "lgx backto ueactivity getConnectTime = " + params.optLong("conectedTime"));
                }
                ZootopiaUEActivity zootopiaUEActivity = this.activity;
                if (zootopiaUEActivity != null) {
                    zootopiaUEActivity.J3(1);
                }
            }
            if (companion.l() || companion.n()) {
                companion.v(1, optInt == 200001);
                companion.F(false);
            }
        }
    }

    private final void P(final String hintTxt) {
        final ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null) {
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "handleFileBrokenError mapId " + zootopiaEnterParams.getMapId());
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.m
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoaderControllerV2.Q(ZootopiaEnterParams.this, hintTxt);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Q(ZootopiaEnterParams it, String str) {
        Intrinsics.checkNotNullParameter(it, "$it");
        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).handleDownloadedFileBroken(it.getMapId(), it.getName(), str);
    }

    private final void R(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod) {
        a0();
        if (errorCode != -21005 && errorCode != 10004 && errorCode != 10010) {
            S(errorCode, errorMsg, mod);
        } else {
            P(errorCode == -21005 ? "\u5c0f\u7a9d\u4e0e\u5f53\u524d\u624bQ\u5f15\u64ce\u7248\u672c\u4e0d\u5339\u914d" : null);
        }
    }

    private final void S(final int errorCode, final String errorMsg, final ZootopiaLoadingErrMod mod) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.n
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderControllerV2.T(ZootopiaLoadingErrMod.this, errorCode, errorMsg);
            }
        });
        QLog.e("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "\u4e50\u56ed\u8fdb\u5165\u5931\u8d25\uff0cerrorCode = " + errorCode + " errorMsg = " + errorMsg + " mod=" + mod.name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T(ZootopiaLoadingErrMod mod, int i3, String errorMsg) {
        Intrinsics.checkNotNullParameter(mod, "$mod");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        QQToast.makeText(BaseApplicationImpl.sApplication.getApplicationContext(), 4, "\u4e50\u56ed\u8fdb\u5165\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1000).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W(ZPlanUELoaderControllerV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        ZootopiaEnterParams zootopiaEnterParams = this$0.enterParams;
        simpleEventBus.dispatchEvent(new ZplanHideLoadingEvent(zootopiaEnterParams != null ? Integer.valueOf(zootopiaEnterParams.getMapId()) : null), true);
        this$0.loadingController.t(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ZPlanUELoaderControllerV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanUEReportHelper M = this$0.M();
        ZPlanUELoadingController zPlanUELoadingController = this$0.loadingController;
        M.g(zPlanUELoadingController != null ? zPlanUELoadingController.getLoadingView() : null);
        ZootopiaUEActivity zootopiaUEActivity = this$0.activity;
        if (zootopiaUEActivity != null) {
            zootopiaUEActivity.finish();
        }
    }

    private final void Z() {
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (!(zootopiaEnterParams != null && zootopiaEnterParams.getMapId() == 200001)) {
            ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
            if (!(zootopiaEnterParams2 != null && zootopiaEnterParams2.getMapId() == 2000008)) {
                ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
                if (!(zootopiaEnterParams3 != null && zootopiaEnterParams3.getMapId() == 2000001)) {
                    return;
                }
            }
        }
        vb3.a aVar = vb3.a.f441346a;
        ((cl3.b) aVar.a(cl3.b.class)).j();
        ((zk3.a) aVar.a(zk3.a.class)).b();
    }

    private final void a0() {
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        String pakPath = zootopiaEnterParams != null ? zootopiaEnterParams.getPakPath() : null;
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "printPakInfo pakFileDir:" + pakPath);
        if (pakPath == null || pakPath.length() == 0) {
            return;
        }
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        String str = pakPath + "/" + (zootopiaEnterParams2 != null ? zootopiaEnterParams2.getProjectName() : null) + ".pak";
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "printPakInfo pakFilePath:" + str);
        File file = new File(str);
        boolean exists = file.exists();
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "printPakInfo pakFile is exists:" + exists);
        if (exists) {
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "printPakInfo pakFile length:" + file.length() + ", lastModify:" + file.lastModified());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ZPlanUELoaderControllerV2 this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.M().d(this$0.progressRecord, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d0(boolean isSuccess, long stepCost) {
        this.runEnterAvatarSuccessTime = System.currentTimeMillis();
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.k(u(this, false, stepCost, 1, null), isSuccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e0(long stepCost) {
        this.firstFrameTime = System.currentTimeMillis();
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.l(u(this, false, stepCost, 1, null));
    }

    private final void i0() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.p
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderControllerV2.j0(ZPlanUELoaderControllerV2.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j0(ZPlanUELoaderControllerV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CountDownTimer countDownTimer = this$0.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        QLog.d("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "startCountDown, time: 30000");
        d dVar = new d();
        this$0.countDownTimer = dVar;
        dVar.start();
    }

    private final void k0() {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        int andIncrement = this.startEngineCounter.getAndIncrement();
        e eVar = new e(currentTimeMillis, andIncrement, this);
        this.startEngineListenerPool.put(andIncrement, eVar);
        ((we3.a) k74.i.INSTANCE.a(we3.a.class)).startEngine("zootopia_startMap", eVar);
        com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0;
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        if (zootopiaEnterParams2 == null || (str = zootopiaEnterParams2.getSource()) == null) {
            str = "0";
        }
        bVar.w(mapId, str);
    }

    private final boolean v() {
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "checkCouldEnterMap, start");
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null ? Intrinsics.areEqual(zootopiaEnterParams.getIsDownloaded(), Boolean.FALSE) : false) {
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "enterMap, but is not downloaded, return");
            return false;
        }
        if (this.triggeredEnterMap) {
            QLog.d("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 2, "enterMap, has entered");
            return false;
        }
        this.triggeredEnterMap = true;
        return true;
    }

    private final void w(String fromSource, boolean isDownloaded) {
        String str;
        long longValue;
        long loadingStartTime = this.progressRecord.getLoadingStartTime();
        this.progressRecord.a();
        com.tencent.mobileqq.zootopia.l lVar = this.progressRecord;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams == null || (str = zootopiaEnterParams.getLoadingId()) == null) {
            str = "";
        }
        lVar.j(str);
        this.progressRecord.k(System.currentTimeMillis());
        if (isDownloaded) {
            HashMap<String, Long> hashMap = Z;
            if (!hashMap.containsKey(this.progressRecord.getLoadingId())) {
                hashMap.put(this.progressRecord.getLoadingId(), Long.valueOf(this.progressRecord.getLoadingStartTime()));
            } else {
                com.tencent.mobileqq.zootopia.l lVar2 = this.progressRecord;
                Long l3 = hashMap.get(lVar2.getLoadingId());
                if (l3 == null) {
                    longValue = this.progressRecord.getLoadingStartTime();
                } else {
                    longValue = l3.longValue();
                }
                lVar2.k(longValue);
            }
        }
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, fromSource + ", doWhenNativeModLoadingBegin " + this.progressRecord.getLoadingId() + ", fix loadingStartTime, old= " + loadingStartTime + ", new= " + this.progressRecord.getLoadingStartTime());
        M().i(this.progressRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y(PrepareResult result) {
        String str;
        dy4.a K2;
        ZPlanBaseSceneLoadingView loadingView;
        ZPlanBaseSceneLoadingView loadingView2;
        JSONObject enterJson = result.getEnterJson();
        ZootopiaEnterParams enterParams = result.getEnterParams();
        if (!this.isBackLoad) {
            QLog.d("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "enterScene, reformBack2Front");
            com.tencent.mobileqq.zplan.smallhome.i.f335703a.b(enterParams.getMapId(), toString());
        }
        com.tencent.sqshow.zootopia.report.b bVar = this.reporter;
        if (bVar != null) {
            bVar.d();
        }
        com.tencent.mobileqq.zootopia.k kVar = com.tencent.mobileqq.zootopia.k.f328365a;
        int mapId = enterParams != null ? enterParams.getMapId() : 0;
        if (enterParams == null || (str = enterParams.getName()) == null) {
            str = "";
        }
        kVar.c(mapId, str);
        i.Companion companion = k74.i.INSTANCE;
        ((yk3.d) companion.a(yk3.d.class)).doEnterUeMap(enterParams.getMapId(), enterParams.getName());
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController != null && (loadingView2 = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.o
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoaderControllerV2.z(ZPlanUELoaderControllerV2.this);
                }
            });
        }
        ZPlanUELoadingController zPlanUELoadingController2 = this.loadingController;
        if (zPlanUELoadingController2 != null && (loadingView = zPlanUELoadingController2.getLoadingView()) != null) {
            loadingView.h(ZPlanModLoadStatus.InnerResDownloading);
        }
        if (this.useV2Loading) {
            i0();
        }
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.j(u(this, false, 0L, 3, null));
        if (!this.isBackLoad && !((com.tencent.mobileqq.zootopia.ipc.f) companion.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isFloat()) {
            ZootopiaUEActivity zootopiaUEActivity = this.activity;
            if (zootopiaUEActivity == null || (K2 = zootopiaUEActivity.K2()) == null) {
                return;
            } else {
                x(K2, enterJson, enterParams);
            }
        } else {
            s(enterJson, enterParams);
        }
        f0(this.progressRecord);
        this.progressRecord.i(System.currentTimeMillis());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ZPlanUELoaderControllerV2 this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanBaseSceneLoadingView loadingView = this$0.loadingController.getLoadingView();
        if (loadingView != null) {
            ZootopiaUEActivity zootopiaUEActivity = this$0.activity;
            loadingView.d(zootopiaUEActivity != null ? zootopiaUEActivity.getString(R.string.xwb) : null, Float.valueOf(100.0f));
        }
    }

    public void A() {
        ZPlanBaseSceneLoadingView loadingView;
        if (!v()) {
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "enterMapWithCheck, checkCouldEnterMap, false");
            return;
        }
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.h(ZPlanModLoadStatus.UELoading);
        }
        this.mUELoaderPreparer.a(this);
    }

    /* renamed from: B, reason: from getter */
    public final ZootopiaUEActivity getActivity() {
        return this.activity;
    }

    /* renamed from: D, reason: from getter */
    public final ZootopiaEnterParams getEnterParams() {
        return this.enterParams;
    }

    /* renamed from: E, reason: from getter */
    public final String getEnterSource() {
        return this.enterSource;
    }

    /* renamed from: F, reason: from getter */
    public final boolean getHasDestroyed() {
        return this.hasDestroyed;
    }

    /* renamed from: G, reason: from getter */
    public final ZPlanUELoadingController getLoadingController() {
        return this.loadingController;
    }

    /* renamed from: H, reason: from getter */
    public final ud3.a getModLoadListener() {
        return this.modLoadListener;
    }

    /* renamed from: I, reason: from getter */
    public final UEActivityPluginManager getPluginManager() {
        return this.pluginManager;
    }

    /* renamed from: J, reason: from getter */
    public final com.tencent.mobileqq.zootopia.l getProgressRecord() {
        return this.progressRecord;
    }

    /* renamed from: K, reason: from getter */
    public final com.tencent.sqshow.zootopia.report.b getReporter() {
        return this.reporter;
    }

    @Override // ud3.c
    public void K5(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod, com.tencent.mobileqq.zootopia.l progressRecord, boolean reportMod, String source) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(mod, "mod");
        Intrinsics.checkNotNullParameter(source, "source");
        M().e(errorCode, errorMsg, mod, progressRecord, reportMod, source);
    }

    /* renamed from: L, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    public final ZPlanUEReportHelper M() {
        return (ZPlanUEReportHelper) this.ueReportHelper.getValue();
    }

    /* renamed from: N, reason: from getter */
    public final boolean getUseV2Loading() {
        return this.useV2Loading;
    }

    /* renamed from: U, reason: from getter */
    public final boolean getIsBackLoad() {
        return this.isBackLoad;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if ((r0 != null && r0.isFinishing()) != false) goto L15;
     */
    @Override // ud3.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void X2(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod, com.tencent.mobileqq.zootopia.l progressRecord) {
        boolean z16;
        String str;
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(mod, "mod");
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if ((zPlanUELoadingController != null ? zPlanUELoadingController.getLoadingView() : null) != null) {
            ZootopiaUEActivity zootopiaUEActivity = this.activity;
            z16 = false;
        }
        z16 = true;
        QLog.e("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "onLoadingError, onProgressError:" + errorCode + ", " + errorMsg + ", " + mod.name() + ", ignore:" + z16);
        if (z16) {
            return;
        }
        R(errorCode, errorMsg, mod);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.l
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderControllerV2.X(ZPlanUELoaderControllerV2.this);
            }
        }, 950L);
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams == null || (str = zootopiaEnterParams.getSource()) == null) {
            str = "0";
        }
        K5(errorCode, errorMsg, mod, progressRecord, true, str);
    }

    @Override // ud3.c
    public void Y8(String source, boolean isBackLoad) {
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "controller onCreate - " + this + " isBackLoad = " + isBackLoad);
        this.enterSource = source;
        this.startTime = System.currentTimeMillis();
        this.isBackLoad = isBackLoad;
        if (!Intrinsics.areEqual(source, "3")) {
            M().n(this.progressRecord.getLoadingId());
        }
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.h(u(this, false, 0L, 3, null));
        UE4.loadModulesInDLL(false);
        ZPlanModLoadStatusManagerForModProcess.f335710a.f(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.zplan.engine.service.d.f385635c.j();
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        boolean areEqual = zootopiaEnterParams != null ? Intrinsics.areEqual(zootopiaEnterParams.getIsDownloaded(), Boolean.TRUE) : false;
        if (!isBackLoad) {
            if (areEqual) {
                w("enter and mainPak is ready", true);
            }
            A();
        } else {
            w("backLoad", areEqual);
        }
        Z();
        QLog.d("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "onCreate cost: " + (System.currentTimeMillis() - this.startTime) + "ms");
    }

    @Override // vd3.c
    public void a(final PrepareResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "onPrepareComplete is ok = " + result.e() + " isBackLoad = " + this.isBackLoad);
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2$onPrepareComplete$1
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
                if (PrepareResult.this.e()) {
                    QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 4, "onPrepareComplete enterJson = " + PrepareResult.this.getEnterJson());
                    this.y(PrepareResult.this);
                    return;
                }
                ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2 = this;
                PrepareResult prepareResult = PrepareResult.this;
                PrepareErr err = prepareResult.getErr();
                Intrinsics.checkNotNull(err);
                zPlanUELoaderControllerV2.b0(prepareResult, err);
            }
        });
    }

    public void f0(com.tencent.mobileqq.zootopia.l progressRecord) {
        Intrinsics.checkNotNullParameter(progressRecord, "progressRecord");
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "reportNativeSuccess loadingID = " + progressRecord.getLoadingId());
        M().o(progressRecord);
        Z.remove(progressRecord.getLoadingId());
    }

    @Override // ud3.c
    public void fc() {
        c.a.c(this);
        final long currentTimeMillis = this.firstFrameTime != 0 ? System.currentTimeMillis() - this.firstFrameTime : 0L;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.k
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderControllerV2.c0(ZPlanUELoaderControllerV2.this, currentTimeMillis);
            }
        }, 128, null, false);
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.n(u(this, false, System.currentTimeMillis() - this.runEnterAvatarSuccessTime, 1, null));
    }

    public final void g0(String str) {
        this.downloadText = str;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return c.a.a(this);
    }

    public final void h0(String str) {
        this.launchText = str;
    }

    @Override // ud3.c
    public void jf(boolean isBackLoad) {
        ZPlanBaseSceneLoadingView loadingView;
        if (!v()) {
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "checkMod, iSCloudEnterMap, false");
            return;
        }
        this.triggeredEnterMap = true;
        this.isBackLoad = isBackLoad;
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "checkMod, isBackLoad: " + isBackLoad + ", enterSource: " + this.enterSource);
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.h(ZPlanModLoadStatus.PreChecking);
        }
        this.mUELoaderPreparer.a(this);
    }

    @Override // ud3.c
    public void onDestroy() {
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "onDestroy - " + this);
        this.hasDestroyed = true;
        ZPlanModLoadStatusManagerForModProcess.f335710a.g(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ((qk3.a) k74.i.INSTANCE.a(qk3.a.class)).clear();
        this.startEngineListenerPool.clear();
        this.worldStatusListener = null;
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
    public void onEngineInitFinish(boolean p06) {
        throw new NotImplementedError("An operation is not implemented: Not yet implemented");
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        c.a.b(this, simpleBaseEvent);
    }

    @Override // ud3.c
    public void onResume() {
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "onResume triggeredEnterMap:" + this.triggeredEnterMap + ", shouldReEnterSceneWhenResume:" + this.shouldReEnterSceneWhenResume);
        if (this.triggeredEnterMap && this.shouldReEnterSceneWhenResume) {
            this.shouldReEnterSceneWhenResume = false;
            this.mUELoaderPreparer.a(this);
        }
    }

    public void s(JSONObject params, ZootopiaEnterParams curFullEnterParams) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(curFullEnterParams, "curFullEnterParams");
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "backEnterAvatarScene, load ue in background engine is active = " + UE4.isEngineActive());
        long currentTimeMillis = System.currentTimeMillis();
        if (!UE4.isEngineActive()) {
            i.Companion companion = k74.i.INSTANCE;
            ((ok3.b) companion.a(ok3.b.class)).keepEngine();
            ((ok3.b) companion.a(ok3.b.class)).resumeEngine();
        }
        a0();
        com.tencent.zplan.world.manager.a.f386318c.c(params.getInt("ViewType"), params.toString(), new b(currentTimeMillis, this, params, curFullEnterParams));
    }

    @Override // ud3.c
    public void t8(ZootopiaEnterParams enterParams) {
        this.enterParams = enterParams;
        this.triggeredEnterMap = false;
        A();
    }

    @Override // com.tencent.mobileqq.zplan.smallhome.status.a
    public void updateStatus(ZPlanModLoadStatusInfo statusInfo) {
        ZootopiaEnterParams zootopiaEnterParams;
        Intrinsics.checkNotNullParameter(statusInfo, "statusInfo");
        if (this.isBackLoad) {
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "updateStatus, isBackLoad, return");
            return;
        }
        if (this.lastCallbackStatus != statusInfo.getStatus()) {
            this.lastCallbackStatus = statusInfo.getStatus();
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "updateStatus, statusInfo: " + statusInfo.getStatus() + ", " + this);
            if (statusInfo.getStatus() != ZPlanModLoadStatus.MainPakDownloadFinish || (zootopiaEnterParams = this.enterParams) == null) {
                return;
            }
            if (zootopiaEnterParams != null) {
                zootopiaEnterParams.setDownloaded(Boolean.TRUE);
            }
            this.triggeredEnterMap = false;
            QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "updateStatus is downloaded, start checkMod");
            w("after MainPakDownloadFinish", true);
            jf(false);
        }
    }

    public void x(dy4.a render, JSONObject params, ZootopiaEnterParams curFullEnterParams) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(curFullEnterParams, "curFullEnterParams");
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "enterAvatarScene, load ue in foreground");
        if (render == null) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        a0();
        this.worldStatusListener = new c(currentTimeMillis, this, params, curFullEnterParams);
        com.tencent.mobileqq.zootopia.utils.n.INSTANCE.a(render, params.getInt("ViewType"), params.toString(), this.worldStatusListener);
    }

    private final ZPlanUETechReportParams t(boolean needDownloadCommonMod, long stepCost) {
        Boolean isDownloaded;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0;
        long C = C();
        boolean z16 = this.useV2Loading;
        boolean z17 = this.isBackLoad;
        String str = this.enterSource;
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        boolean booleanValue = (zootopiaEnterParams2 == null || (isDownloaded = zootopiaEnterParams2.getIsDownloaded()) == null) ? true : isDownloaded.booleanValue();
        ModDownloadHelper modDownloadHelper = ModDownloadHelper.f334765a;
        ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
        return new ZPlanUETechReportParams(mapId, C, stepCost, z16, z17, str, booleanValue, needDownloadCommonMod, modDownloadHelper.g(zootopiaEnterParams3 != null ? zootopiaEnterParams3.getMapId() : 0));
    }

    public void V(com.tencent.mobileqq.zootopia.l progressRecord) {
        String str;
        String str2;
        ZPlanUELoadingController zPlanUELoadingController;
        ZPlanBaseSceneLoadingView loadingView;
        QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "notify onFirstFrameLoadingSuccess");
        if (!this.useV2Loading && (zPlanUELoadingController = this.loadingController) != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.q
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoaderControllerV2.W(ZPlanUELoaderControllerV2.this);
                }
            }, 250L);
        }
        ZPlanUEReportHelper M = M();
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams == null || (str = zootopiaEnterParams.getSource()) == null) {
            str = "0";
        }
        M.f(progressRecord, str);
        if (!this.useV2Loading) {
            ic3.a aVar = (ic3.a) k74.i.INSTANCE.a(ic3.a.class);
            ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
            aVar.modLoadFinish(zootopiaEnterParams2 != null ? zootopiaEnterParams2.getMapId() : 0);
            an anVar = an.f328351a;
            ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
            anVar.a(zootopiaEnterParams3 != null ? zootopiaEnterParams3.getMapId() : 0);
        }
        ZootopiaUEActivity zootopiaUEActivity = this.activity;
        if (zootopiaUEActivity != null) {
            zootopiaUEActivity.P3(this.enterParams);
        }
        UEBuglyInfoRecorder uEBuglyInfoRecorder = UEBuglyInfoRecorder.f25109a;
        ZootopiaEnterParams zootopiaEnterParams4 = this.enterParams;
        int mapId = zootopiaEnterParams4 != null ? zootopiaEnterParams4.getMapId() : 0;
        ZootopiaEnterParams zootopiaEnterParams5 = this.enterParams;
        if (zootopiaEnterParams5 == null || (str2 = zootopiaEnterParams5.getName()) == null) {
            str2 = "";
        }
        uEBuglyInfoRecorder.f(mapId, str2);
    }

    @Override // ud3.c
    public void onStop() {
        this.shouldReEnterSceneWhenResume = true;
    }

    private final ZootopiaDownloadParams Y(aw updateInfo) {
        y yVar = updateInfo.f430021a;
        qv4.g gVar = updateInfo.f430022b;
        String valueOf = String.valueOf(gVar.f430142a);
        String str = gVar.f430145d;
        Intrinsics.checkNotNullExpressionValue(str, "extraInfo.mapName");
        String str2 = gVar.f430146e;
        Intrinsics.checkNotNullExpressionValue(str2, "extraInfo.background");
        String str3 = gVar.f430148g;
        Intrinsics.checkNotNullExpressionValue(str3, "extraInfo.button");
        String str4 = gVar.f430152k;
        Intrinsics.checkNotNullExpressionValue(str4, "extraInfo.typeIcon");
        ZootopiaSummaryData zootopiaSummaryData = new ZootopiaSummaryData(valueOf, 2, str, str2, str3, str4, "");
        String str5 = yVar.f427732e;
        Intrinsics.checkNotNullExpressionValue(str5, "verInfo.cosURL");
        String str6 = yVar.f427731d;
        Intrinsics.checkNotNullExpressionValue(str6, "verInfo.nowMapVer");
        long j3 = yVar.f427734g;
        ZPlanModVersionSimpleData zPlanModVersionSimpleData = new ZPlanModVersionSimpleData(gVar.f430142a);
        String str7 = yVar.f427731d;
        Intrinsics.checkNotNullExpressionValue(str7, "verInfo.nowMapVer");
        zPlanModVersionSimpleData.setNowMapVer(str7);
        String str8 = yVar.f427732e;
        Intrinsics.checkNotNullExpressionValue(str8, "verInfo.cosURL");
        zPlanModVersionSimpleData.setCosUrl(str8);
        String str9 = yVar.f427733f;
        Intrinsics.checkNotNullExpressionValue(str9, "verInfo.runScript");
        zPlanModVersionSimpleData.setRunScript(str9);
        zPlanModVersionSimpleData.setDataSize(yVar.f427734g);
        zPlanModVersionSimpleData.setScriptType(yVar.f427735h);
        String str10 = yVar.f427738k;
        Intrinsics.checkNotNullExpressionValue(str10, "verInfo.md5");
        zPlanModVersionSimpleData.setMd5(str10);
        String str11 = yVar.f427740m;
        Intrinsics.checkNotNullExpressionValue(str11, "verInfo.pakMd5");
        zPlanModVersionSimpleData.setPakMd5(str11);
        zPlanModVersionSimpleData.setPackType(yVar.f427743p);
        Unit unit = Unit.INSTANCE;
        String str12 = gVar.f430150i;
        Intrinsics.checkNotNullExpressionValue(str12, "extraInfo.mapProjName");
        String str13 = gVar.f430151j;
        Intrinsics.checkNotNullExpressionValue(str13, "extraInfo.barPic");
        String valueOf2 = String.valueOf(yVar.f427735h);
        int i3 = gVar.f430149h;
        boolean z16 = gVar.f430153l;
        String str14 = yVar.f427733f;
        Intrinsics.checkNotNullExpressionValue(str14, "verInfo.runScript");
        return new ZootopiaDownloadParams(zootopiaSummaryData, str5, str6, j3, zPlanModVersionSimpleData, new ZootopiaExtraData(str12, str13, valueOf2, i3, z16, str14, true, false, false, null, ZootopiaMapLoadingParams.INSTANCE.a(gVar.f430155n), false, 2944, null), ZPlanMapDiffPatchInfo.INSTANCE.b(yVar.f427742o));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b0(PrepareResult result, PrepareErr err) {
        PrepareErr err2 = result.getErr();
        Intrinsics.checkNotNull(err2);
        int errCode = err2.getErrCode();
        String errMsg = err.getErrMsg();
        int errType = err.getErrType();
        if (errType == 1) {
            QQToastUtil.showQQToast(1, "\u4e50\u56ed\u8fdb\u5165\u5931\u8d25\uff0c\u5f15\u64ce\u542f\u52a8\u5931\u8d25");
            ZootopiaUEActivity zootopiaUEActivity = this.activity;
            if (zootopiaUEActivity != null) {
                zootopiaUEActivity.finish();
            }
        } else if (errType != 2) {
            if (errType == 5) {
                X2(errCode, errMsg, ZootopiaLoadingErrMod.NATIVE, this.progressRecord);
            }
        } else if (errCode == 5) {
            if (result.getUpdateInfo() != null) {
                ZootopiaDownloadParams Y = Y(result.getUpdateInfo());
                ZPlanMapDiffPatchInfo diffPatchInfo = Y.getDiffPatchInfo();
                QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "diffInfo = " + (diffPatchInfo != null ? diffPatchInfo.diffPatchInfo() : null));
                ZootopiaDownloadManagerIpc.f328013a.n(Y, false, this.activity, new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2$processPrepareError$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                        invoke(bool.booleanValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(boolean z16) {
                        ZootopiaUEActivity activity;
                        if (z16 || (activity = ZPlanUELoaderControllerV2.this.getActivity()) == null) {
                            return;
                        }
                        activity.finish();
                    }
                });
            } else {
                Bundle bundle = new Bundle();
                ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
                bundle.putInt("mapId", zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0);
                bundle.putSerializable("detail_config", new ZootopiaDetailFragment.Config(0, false, false, true, null, null, false, null, 247, null));
                QLog.i("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "updateInfo is null gotoMapDetail");
                IEntryApi iEntryApi = (IEntryApi) QRoute.api(IEntryApi.class);
                BaseApplication context = BaseApplication.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext()");
                ZootopiaSource zootopiaSource = this.source;
                if (zootopiaSource == null) {
                    zootopiaSource = ZootopiaSource.INSTANCE.i();
                }
                iEntryApi.startDetailFragment(context, zootopiaSource, bundle);
                ZootopiaUEActivity zootopiaUEActivity2 = this.activity;
                if (zootopiaUEActivity2 != null) {
                    zootopiaUEActivity2.finish();
                }
            }
        }
        c.a.d(this, errCode, errMsg, ZootopiaLoadingErrMod.NATIVE, this.progressRecord, false, result.getEnterParams().getSource(), 16, null);
    }

    static /* synthetic */ ZPlanUETechReportParams u(ZPlanUELoaderControllerV2 zPlanUELoaderControllerV2, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        return zPlanUELoaderControllerV2.t(z16, j3);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderControllerV2$d", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d extends CountDownTimer {
        d() {
            super(30000L, 1000L);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ud3.b o16;
            if (ZPlanUELoaderControllerV2.this.isFirstFrameReady) {
                QLog.d("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "isFirstFrameReady true, return");
                return;
            }
            QLog.d("ZPlanUELoaderControllerV2-ZootopiaUEActivity", 1, "show error dialog");
            ZPlanUELoadingController loadingController = ZPlanUELoaderControllerV2.this.getLoadingController();
            if (loadingController == null || (o16 = loadingController.o()) == null) {
                return;
            }
            o16.b();
        }

        @Override // android.os.CountDownTimer
        public void onTick(long millisUntilFinished) {
        }
    }
}
