package com.tencent.mobileqq.zootopia.ueloading;

import android.os.CountDownTimer;
import android.util.SparseArray;
import android.view.View;
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
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zootopia.ZootopiaLoadingErrMod;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaGameParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ZPlanModHotPatchConfig;
import com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.ZPlanModHotPatchForModProcess;
import com.tencent.mobileqq.zootopia.download.v;
import com.tencent.mobileqq.zootopia.ipc.an;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUEReportHelper;
import com.tencent.mobileqq.zootopia.ueloading.report.ZPlanUETechReportParams;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.mobileqq.zootopia.view.b;
import com.tencent.mobileqq.zplan.authorize.api.CommonModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.ModChekerParams;
import com.tencent.mobileqq.zplan.dresskey.api.DressInfoIPCData;
import com.tencent.mobileqq.zplan.mod.impl.helper.ModDownloadHelper;
import com.tencent.mobileqq.zplan.resource.api.data.mod.ZPlanResHubResultInfo;
import com.tencent.mobileqq.zplan.smallhome.event.ZplanHideLoadingEvent;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatus;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusInfo;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForModProcess;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.util.QQToastUtil;
import com.tencent.xweb.pinus.ChildProcessServiceWrapper;
import com.tencent.zplan.world.IZPlanWorldStatusListener;
import com.tencent.zplan.world.model.FirstFrameResult;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import k74.i;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ud3.c;

@Metadata(d1 = {"\u0000\u00ce\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u00a0\u0001Bi\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010`\u001a\u0004\u0018\u00010[\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010a\u0012\b\b\u0002\u0010i\u001a\u00020\u0007\u0012\n\b\u0002\u0010o\u001a\u0004\u0018\u00010j\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010x\u001a\u0004\u0018\u00010t\u0012\n\b\u0002\u0010}\u001a\u0004\u0018\u00010y\u00a2\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J2\u0010\u0014\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002H\u0002J?\u0010\u001a\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0017\u001a\u00020\u00162\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00040\u0018H\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010 \u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001f\u001a\u00020\u0007H\u0002J \u0010$\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0002J\b\u0010%\u001a\u00020\u0004H\u0002J \u0010&\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"H\u0002J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00072\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0010\u0010*\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0016H\u0002J\u001c\u0010-\u001a\u00020,2\b\b\u0002\u0010+\u001a\u00020\u00072\b\b\u0002\u0010(\u001a\u00020\u0016H\u0002J\u0018\u00101\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u00072\u0006\u00100\u001a\u00020/H\u0002J\b\u00102\u001a\u00020\u0016H\u0002J\u0010\u00104\u001a\u00020\u00042\u0006\u00103\u001a\u00020\u0016H\u0002J\u0018\u00107\u001a\u00020\u00042\u0006\u00105\u001a\u00020\u00022\u0006\u00106\u001a\u00020\u0007H\u0016J\u0010\u00108\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0007H\u0016J\b\u00109\u001a\u00020\u0004H\u0016J\u0010\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u0007H\u0016J\b\u0010>\u001a\u00020\u0004H\u0016J\u0018\u0010?\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0002H\u0016J\u0018\u0010A\u001a\u00020\u00042\u0006\u00100\u001a\u00020/2\u0006\u0010@\u001a\u00020\u000eH\u0016J\"\u0010D\u001a\u00020\u00042\b\u0010C\u001a\u0004\u0018\u00010B2\u0006\u00100\u001a\u00020/2\u0006\u0010@\u001a\u00020\u000eH\u0016J*\u0010G\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J\u0012\u0010H\u001a\u00020\u00042\b\u0010F\u001a\u0004\u0018\u00010EH\u0016J:\u0010J\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010!\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\"2\b\u0010F\u001a\u0004\u0018\u00010E2\u0006\u0010I\u001a\u00020\u00072\u0006\u00105\u001a\u00020\u0002H\u0016J\u0010\u0010K\u001a\u00020\u00042\u0006\u0010F\u001a\u00020EH\u0016J\b\u0010L\u001a\u00020\u0004H\u0016J\u0012\u0010M\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010N\u001a\u00020\u0004H\u0016J\b\u0010O\u001a\u00020\u0004H\u0016J\b\u0010P\u001a\u00020\u0004H\u0016R\u0019\u0010\r\u001a\u0004\u0018\u00010\f8\u0006\u00a2\u0006\f\n\u0004\bQ\u0010R\u001a\u0004\bS\u0010TR$\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010V\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR\u0019\u0010`\u001a\u0004\u0018\u00010[8\u0006\u00a2\u0006\f\n\u0004\b\\\u0010]\u001a\u0004\b^\u0010_R\u0019\u00105\u001a\u0004\u0018\u00010a8\u0006\u00a2\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0017\u0010i\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\bf\u0010$\u001a\u0004\bg\u0010hR\u0019\u0010o\u001a\u0004\u0018\u00010j8\u0006\u00a2\u0006\f\n\u0004\bk\u0010l\u001a\u0004\bm\u0010nR\u0017\u0010F\u001a\u00020E8\u0006\u00a2\u0006\f\n\u0004\bp\u0010q\u001a\u0004\br\u0010sR\u0019\u0010x\u001a\u0004\u0018\u00010t8\u0006\u00a2\u0006\f\n\u0004\b\b\u0010u\u001a\u0004\bv\u0010wR\u0019\u0010}\u001a\u0004\u0018\u00010y8\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010z\u001a\u0004\b{\u0010|R\u001e\u0010\u0082\u0001\u001a\u00020~8BX\u0082\u0084\u0002\u00a2\u0006\u000e\n\u0004\bD\u0010\u007f\u001a\u0006\b\u0080\u0001\u0010\u0081\u0001R\u001b\u0010\u0085\u0001\u001a\u0005\u0018\u00010\u0083\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\t\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b9\u0010\u0086\u0001R\u001e\u0010\u008b\u0001\u001a\n\u0012\u0005\u0012\u00030\u0089\u00010\u0088\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b \u0010\u008a\u0001R\u0017\u0010\u008e\u0001\u001a\u00030\u008c\u00018\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b>\u0010\u008d\u0001R\u0017\u0010\u008f\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010$R\u0017\u0010\u0090\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bS\u0010$R\u001a\u0010\u0091\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b2\u0010\u0086\u0001R\u001a\u0010\u0092\u0001\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\bW\u0010\u0086\u0001R\u0016\u00106\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bv\u0010$R\u0017\u0010\u0093\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\br\u0010$R\u0017\u0010\u0094\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bm\u0010$R\u0017\u0010\u0095\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bd\u0010$R\u0018\u0010\u0096\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u0080\u0001\u0010$R\u0017\u0010\u0097\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bg\u0010>R\u0017\u0010\u0098\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010>R\u0017\u0010\u0099\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010>R\u001c\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009a\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001\u00a8\u0006\u00a1\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController;", "Lud3/c;", "", "fromSource", "", "E", "p0", "", "D", "G", "q0", "g0", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "modConfigJson", "", "errorCode", "errorMessage", "Y", "mapId", "", "needDownloadSize", "Lkotlin/Function1;", "callback", "m0", "(Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;Ljava/lang/Integer;JLkotlin/jvm/functions/Function1;)V", "baseModData", "Lcom/tencent/mobileqq/zplan/resource/api/data/mod/ZPlanResHubResultInfo;", "hotPatchInfo", "hasSkippedHotPatch", "I", "errorMsg", "Lcom/tencent/mobileqq/zootopia/ZootopiaLoadingErrMod;", "mod", "Z", "W", "a0", "isSuccess", "stepCost", "i0", "j0", "needDownloadCommonMod", "Lcom/tencent/mobileqq/zootopia/ueloading/report/c;", "B", "success", "Lorg/json/JSONObject;", "params", "V", "M", IOnlineStatusService.REMAIN_TIME, "n0", "source", "isBackLoad", "Y8", "onEngineInitFinish", "H", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatusInfo;", "statusInfo", "updateStatus", "jf", "J", "K", "curFullEnterParams", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ldy4/a;", ChildProcessServiceWrapper.PROCESS_TYPE_RENDER, UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/zootopia/l;", "progressRecord", "X2", "d0", "reportMod", "K5", "k0", "onResume", "t8", DKHippyEvent.EVENT_STOP, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "fc", "d", "Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "L", "()Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "e", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "N", "()Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "l0", "(Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;)V", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "f", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "O", "()Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "loadingController", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", tl.h.F, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", ExifInterface.LATITUDE_SOUTH, "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "i", "U", "()Z", "useV2Loading", "Lcom/tencent/sqshow/zootopia/report/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/sqshow/zootopia/report/b;", BdhLogUtil.LogTag.Tag_Req, "()Lcom/tencent/sqshow/zootopia/report/b;", "reporter", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/zootopia/l;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "()Lcom/tencent/mobileqq/zootopia/l;", "Lud3/a;", "Lud3/a;", "P", "()Lud3/a;", "modLoadListener", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "getPluginManager", "()Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "pluginManager", "Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper;", "Lkotlin/Lazy;", "T", "()Lcom/tencent/mobileqq/zootopia/ueloading/report/ZPlanUEReportHelper;", "ueReportHelper", "Landroid/os/CountDownTimer;", "Landroid/os/CountDownTimer;", "countDownTimer", "Ljava/lang/String;", "enterSource", "Landroid/util/SparseArray;", "Lwe3/b;", "Landroid/util/SparseArray;", "startEngineListenerPool", "Ljava/util/concurrent/atomic/AtomicInteger;", "Ljava/util/concurrent/atomic/AtomicInteger;", "startEngineCounter", "engineInited", "isFirstFrameReady", "downloadText", "launchText", "hasDestroyed", "triggeredEnterMap", "shouldReEnterSceneWhenResume", "isFromDownloaded", "startTime", "runEnterAvatarSuccessTime", "firstFrameTime", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "X", "Lcom/tencent/mobileqq/zplan/smallhome/status/ZPlanModLoadStatus;", "lastCallbackStatus", "<init>", "(Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;ZLcom/tencent/sqshow/zootopia/report/b;Lcom/tencent/mobileqq/zootopia/l;Lud3/a;Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;)V", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZPlanUELoaderController implements ud3.c {

    /* renamed from: Y, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.l progressRecord;

    /* renamed from: D, reason: from kotlin metadata */
    private final ud3.a modLoadListener;

    /* renamed from: E, reason: from kotlin metadata */
    private final UEActivityPluginManager pluginManager;

    /* renamed from: F, reason: from kotlin metadata */
    private final Lazy ueReportHelper;

    /* renamed from: G, reason: from kotlin metadata */
    private CountDownTimer countDownTimer;

    /* renamed from: H, reason: from kotlin metadata */
    private String enterSource;

    /* renamed from: I, reason: from kotlin metadata */
    private final SparseArray<we3.b> startEngineListenerPool;

    /* renamed from: J, reason: from kotlin metadata */
    private final AtomicInteger startEngineCounter;

    /* renamed from: K, reason: from kotlin metadata */
    private volatile boolean engineInited;

    /* renamed from: L, reason: from kotlin metadata */
    private volatile boolean isFirstFrameReady;

    /* renamed from: M, reason: from kotlin metadata */
    private String downloadText;

    /* renamed from: N, reason: from kotlin metadata */
    private String launchText;

    /* renamed from: P, reason: from kotlin metadata */
    private volatile boolean isBackLoad;

    /* renamed from: Q, reason: from kotlin metadata */
    private volatile boolean hasDestroyed;

    /* renamed from: R, reason: from kotlin metadata */
    private boolean triggeredEnterMap;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean shouldReEnterSceneWhenResume;

    /* renamed from: T, reason: from kotlin metadata */
    private volatile boolean isFromDownloaded;

    /* renamed from: U, reason: from kotlin metadata */
    private long startTime;

    /* renamed from: V, reason: from kotlin metadata */
    private long runEnterAvatarSuccessTime;

    /* renamed from: W, reason: from kotlin metadata */
    private long firstFrameTime;

    /* renamed from: X, reason: from kotlin metadata */
    private ZPlanModLoadStatus lastCallbackStatus;

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

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$a;", "", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController;", "a", "", "DEFAULT_COUNT_DOWN_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ZPlanUELoaderController a(ZootopiaEnterParams enterParams) {
            Intrinsics.checkNotNullParameter(enterParams, "enterParams");
            com.tencent.mobileqq.zootopia.l lVar = new com.tencent.mobileqq.zootopia.l();
            lVar.j(enterParams.getLoadingId());
            return new ZPlanUELoaderController(null, enterParams, null, ag.f373258a.b(), true, null, lVar, null, null);
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$b", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements IZPlanWorldStatusListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f329372d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderController f329373e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f329374f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f329375h;

        b(long j3, ZPlanUELoaderController zPlanUELoaderController, JSONObject jSONObject, ZootopiaEnterParams zootopiaEnterParams) {
            this.f329372d = j3;
            this.f329373e = zPlanUELoaderController;
            this.f329374f = jSONObject;
            this.f329375h = zootopiaEnterParams;
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onEnterSceneResult(boolean success) {
            IZPlanWorldStatusListener.a.a(this, success);
            long currentTimeMillis = System.currentTimeMillis() - this.f329372d;
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "backEnterAvatarScene, onEnterSceneResult, result:" + success + ", stepCost: " + currentTimeMillis);
            this.f329373e.i0(success, currentTimeMillis);
            this.f329373e.V(success, this.f329374f);
            ud3.a modLoadListener = this.f329373e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.j2(success, this.f329374f, this.f329375h);
            }
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onFirstFrame(FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            long currentTimeMillis = System.currentTimeMillis() - this.f329372d;
            ud3.a modLoadListener = this.f329373e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.W0(result);
            }
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "backEnterAvatarScene, onFirstFrame, useV2Loading: " + this.f329373e.getUseV2Loading() + ", stepCost: " + currentTimeMillis);
            com.tencent.sqshow.zootopia.report.b reporter = this.f329373e.getReporter();
            if (reporter != null) {
                reporter.e();
            }
            this.f329373e.isFirstFrameReady = true;
            ZPlanUELoaderController zPlanUELoaderController = this.f329373e;
            zPlanUELoaderController.d0(zPlanUELoaderController.getProgressRecord());
            CountDownTimer countDownTimer = this.f329373e.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f329373e.j0(currentTimeMillis);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$c", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "result", "", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> {
        c() {
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(EnterModCheckResult result) {
            String str;
            ZootopiaEnterParams enterParams;
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterModCheck onCheckComplete, result: " + result.getResultCode() + ", enterSource: " + ZPlanUELoaderController.this.enterSource);
            if (result.isPassed()) {
                ZootopiaEnterParams enterParams2 = ZPlanUELoaderController.this.getEnterParams();
                if (enterParams2 == null || (str = enterParams2.getLoadingId()) == null) {
                    str = "";
                }
                ZPlanUELoaderController zPlanUELoaderController = ZPlanUELoaderController.this;
                ZootopiaEnterParams enterParamsAfterCheck = result.getEnterParamsAfterCheck();
                Intrinsics.checkNotNull(enterParamsAfterCheck);
                zPlanUELoaderController.l0(enterParamsAfterCheck);
                if ((str.length() > 0) && (enterParams = ZPlanUELoaderController.this.getEnterParams()) != null) {
                    enterParams.setLoadingId(str);
                }
                ZPlanUELoaderController.this.G();
            }
            if (Intrinsics.areEqual(ZPlanUELoaderController.this.enterSource, "3")) {
                ZPlanUELoaderController.this.T().n(ZPlanUELoaderController.this.getProgressRecord().getLoadingId());
            }
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(EnterModCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$d", "Lcom/tencent/zplan/world/IZPlanWorldStatusListener;", "", "success", "", "onEnterSceneResult", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "onFirstFrame", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements IZPlanWorldStatusListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f329377d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderController f329378e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ JSONObject f329379f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f329380h;

        d(long j3, ZPlanUELoaderController zPlanUELoaderController, JSONObject jSONObject, ZootopiaEnterParams zootopiaEnterParams) {
            this.f329377d = j3;
            this.f329378e = zPlanUELoaderController;
            this.f329379f = jSONObject;
            this.f329380h = zootopiaEnterParams;
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onEnterSceneResult(boolean success) {
            IZPlanWorldStatusListener.a.a(this, success);
            long currentTimeMillis = System.currentTimeMillis() - this.f329377d;
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "foreground enterAvatarScene, onEnterSceneResult, result:" + success + ", stepCost: " + currentTimeMillis);
            this.f329378e.i0(success, currentTimeMillis);
            this.f329378e.V(success, this.f329379f);
            ud3.a modLoadListener = this.f329378e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.j2(success, this.f329379f, this.f329380h);
            }
        }

        @Override // com.tencent.zplan.world.IZPlanWorldStatusListener
        public void onFirstFrame(FirstFrameResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            long currentTimeMillis = System.currentTimeMillis() - this.f329377d;
            ud3.a modLoadListener = this.f329378e.getModLoadListener();
            if (modLoadListener != null) {
                modLoadListener.W0(result);
            }
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "foreground enterAvatarScene, onFirstFrame, useV2Loading: " + this.f329378e.getUseV2Loading() + ", stepCost: " + currentTimeMillis);
            com.tencent.sqshow.zootopia.report.b reporter = this.f329378e.getReporter();
            if (reporter != null) {
                reporter.e();
            }
            this.f329378e.isFirstFrameReady = true;
            ZPlanUELoaderController zPlanUELoaderController = this.f329378e;
            zPlanUELoaderController.d0(zPlanUELoaderController.getProgressRecord());
            CountDownTimer countDownTimer = this.f329378e.countDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
            this.f329378e.j0(currentTimeMillis);
            ((qk3.a) k74.i.INSTANCE.a(qk3.a.class)).onModFirstFrameCallback(this.f329379f);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$e", "Leh3/b;", "Lcom/tencent/mobileqq/zplan/dresskey/api/DressInfoIPCData;", "maleAvatarCharacter", "femaleAvatarCharacter", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class e implements eh3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f329381a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderController f329382b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ JSONObject f329383c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f329384d;

        e(long j3, ZPlanUELoaderController zPlanUELoaderController, JSONObject jSONObject, ZootopiaEnterParams zootopiaEnterParams) {
            this.f329381a = j3;
            this.f329382b = zPlanUELoaderController;
            this.f329383c = jSONObject;
            this.f329384d = zootopiaEnterParams;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(ZPlanUELoaderController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            ZPlanBaseSceneLoadingView loadingView = this$0.getLoadingController().getLoadingView();
            if (loadingView != null) {
                ZootopiaUEActivity activity = this$0.getActivity();
                loadingView.d(activity != null ? activity.getString(R.string.xwb) : null, Float.valueOf(100.0f));
            }
        }

        @Override // eh3.b
        public void a(DressInfoIPCData maleAvatarCharacter, DressInfoIPCData femaleAvatarCharacter) {
            String str;
            dy4.a K2;
            ZPlanBaseSceneLoadingView loadingView;
            ZPlanBaseSceneLoadingView loadingView2;
            String name;
            ZootopiaMapLoadingParams loadingParams;
            CommonModCheckResult commonModCheckResult;
            ZootopiaMapLoadingParams loadingParams2;
            Intrinsics.checkNotNullParameter(maleAvatarCharacter, "maleAvatarCharacter");
            Intrinsics.checkNotNullParameter(femaleAvatarCharacter, "femaleAvatarCharacter");
            long currentTimeMillis = System.currentTimeMillis() - this.f329381a;
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "onGetDefaultAvatarCharacter completed, stepCost: " + currentTimeMillis);
            if (maleAvatarCharacter.getResultCode() == 0 && femaleAvatarCharacter.getResultCode() == 0) {
                com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
                bVar.g(ZPlanUELoaderController.C(this.f329382b, false, currentTimeMillis, 1, null), true);
                ud3.a modLoadListener = this.f329382b.getModLoadListener();
                if (modLoadListener != null) {
                    modLoadListener.a2(maleAvatarCharacter, femaleAvatarCharacter);
                }
                this.f329383c.put("LoadingId", this.f329382b.getProgressRecord().getLoadingId());
                this.f329383c.put("MaleDefaultAvatarInfo", new JSONObject(maleAvatarCharacter.getInfoJson()));
                this.f329383c.put("FemaleDefaultAvatarInfo", new JSONObject(femaleAvatarCharacter.getInfoJson()));
                this.f329383c.put("isSeparateLoading", !this.f329382b.getUseV2Loading());
                String jSONObject = this.f329383c.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject, "params.toString()");
                ZootopiaEnterParams enterParams = this.f329382b.getEnterParams();
                pu4.g gVar = null;
                Boolean valueOf = (enterParams == null || (loadingParams2 = enterParams.getLoadingParams()) == null) ? null : Boolean.valueOf(loadingParams2.getIsUseNewLoading());
                ZootopiaEnterParams enterParams2 = this.f329382b.getEnterParams();
                String newGuideUrl = (enterParams2 == null || (commonModCheckResult = enterParams2.getCommonModCheckResult()) == null) ? null : commonModCheckResult.getNewGuideUrl();
                ZootopiaEnterParams enterParams3 = this.f329382b.getEnterParams();
                if (enterParams3 != null && (loadingParams = enterParams3.getLoadingParams()) != null) {
                    gVar = loadingParams.loadingBackgroundMaterial();
                }
                QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterScene, loadingParams= " + valueOf + ", newGuideUrl= " + newGuideUrl + ", material= " + gVar + ", " + jSONObject);
                com.tencent.sqshow.zootopia.report.b reporter = this.f329382b.getReporter();
                if (reporter != null) {
                    reporter.d();
                }
                com.tencent.mobileqq.zootopia.k kVar = com.tencent.mobileqq.zootopia.k.f328365a;
                ZootopiaEnterParams enterParams4 = this.f329382b.getEnterParams();
                int mapId = enterParams4 != null ? enterParams4.getMapId() : 0;
                ZootopiaEnterParams enterParams5 = this.f329382b.getEnterParams();
                String str2 = "";
                if (enterParams5 == null || (str = enterParams5.getName()) == null) {
                    str = "";
                }
                kVar.c(mapId, str);
                yk3.d dVar = (yk3.d) k74.i.INSTANCE.a(yk3.d.class);
                ZootopiaEnterParams enterParams6 = this.f329382b.getEnterParams();
                int mapId2 = enterParams6 != null ? enterParams6.getMapId() : 0;
                ZootopiaEnterParams enterParams7 = this.f329382b.getEnterParams();
                if (enterParams7 != null && (name = enterParams7.getName()) != null) {
                    str2 = name;
                }
                dVar.doEnterUeMap(mapId2, str2);
                ZPlanUELoadingController loadingController = this.f329382b.getLoadingController();
                if (loadingController != null && (loadingView2 = loadingController.getLoadingView()) != null) {
                    final ZPlanUELoaderController zPlanUELoaderController = this.f329382b;
                    loadingView2.post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            ZPlanUELoaderController.e.c(ZPlanUELoaderController.this);
                        }
                    });
                }
                ZPlanUELoadingController loadingController2 = this.f329382b.getLoadingController();
                if (loadingController2 != null && (loadingView = loadingController2.getLoadingView()) != null) {
                    loadingView.h(ZPlanModLoadStatus.InnerResDownloading);
                }
                if (this.f329382b.getUseV2Loading()) {
                    this.f329382b.n0(30000L);
                }
                bVar.j(ZPlanUELoaderController.C(this.f329382b, false, 0L, 3, null));
                if (this.f329382b.isBackLoad) {
                    this.f329382b.A(this.f329383c, this.f329384d);
                } else {
                    ZootopiaUEActivity activity = this.f329382b.getActivity();
                    if (activity == null || (K2 = activity.K2()) == null) {
                        return;
                    } else {
                        this.f329382b.F(K2, this.f329383c, this.f329384d);
                    }
                }
                ZPlanUELoaderController zPlanUELoaderController2 = this.f329382b;
                zPlanUELoaderController2.k0(zPlanUELoaderController2.getProgressRecord());
                this.f329382b.getProgressRecord().i(System.currentTimeMillis());
                return;
            }
            this.f329382b.X2(-100, "maleAvatarCharacter = " + maleAvatarCharacter + " femaleAvatarCharacter = " + femaleAvatarCharacter, ZootopiaLoadingErrMod.NATIVE, this.f329382b.getProgressRecord());
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.g(ZPlanUELoaderController.C(this.f329382b, false, currentTimeMillis, 1, null), false);
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterAvatarScene with dressKey error maleDefaultAvatarInfo = " + maleAvatarCharacter + " femaleDefaultAvatarInfo = " + femaleAvatarCharacter);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$f", "Lcom/tencent/mobileqq/zootopia/view/b;", "Landroid/view/View;", "view", "", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class f implements com.tencent.mobileqq.zootopia.view.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZootopiaEnterParams f329393a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ ZootopiaUEActivity f329394b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderController f329395c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f329396d;

        f(ZootopiaEnterParams zootopiaEnterParams, ZootopiaUEActivity zootopiaUEActivity, ZPlanUELoaderController zPlanUELoaderController, String str) {
            this.f329393a = zootopiaEnterParams;
            this.f329394b = zootopiaUEActivity;
            this.f329395c = zPlanUELoaderController;
            this.f329396d = str;
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "handleHotPatchCheckError - " + this.f329393a.getMapId() + ", retry");
            this.f329395c.K(this.f329393a, this.f329396d);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            b.a.b(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "handleHotPatchCheckError - " + this.f329393a.getMapId() + ", cancel");
            this.f329394b.finish();
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void d(View view) {
            b.a.a(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void e(View view) {
            b.a.c(this, view);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$g", "Lcom/tencent/mobileqq/zootopia/view/b;", "Landroid/view/View;", "view", "", "c", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class g implements com.tencent.mobileqq.zootopia.view.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Integer f329397a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f329398b;

        /* JADX WARN: Multi-variable type inference failed */
        g(Integer num, Function1<? super Boolean, Unit> function1) {
            this.f329397a = num;
            this.f329398b = function1;
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void a(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "showHotPatchMobileTipsDialog - " + this.f329397a + ", confirm");
            this.f329398b.invoke(Boolean.TRUE);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void b(View view) {
            b.a.b(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void c(View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "showHotPatchMobileTipsDialog -" + this.f329397a + ", cancel");
            this.f329398b.invoke(Boolean.FALSE);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void d(View view) {
            b.a.a(this, view);
        }

        @Override // com.tencent.mobileqq.zootopia.view.b
        public void e(View view) {
            b.a.c(this, view);
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$i", "Lwe3/b;", "", "success", "", "startEngineState", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class i implements we3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ long f329400a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f329401b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderController f329402c;

        i(long j3, int i3, ZPlanUELoaderController zPlanUELoaderController) {
            this.f329400a = j3;
            this.f329401b = i3;
            this.f329402c = zPlanUELoaderController;
        }

        @Override // we3.b
        public void a(boolean success, int startEngineState) {
            String str;
            long currentTimeMillis = System.currentTimeMillis() - this.f329400a;
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "handleAuthorizeResult handleStartMap:" + success + ", currentIndex:" + this.f329401b + " cost:" + currentTimeMillis);
            this.f329402c.startEngineListenerPool.remove(this.f329401b);
            com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
            ZootopiaEnterParams enterParams = this.f329402c.getEnterParams();
            int mapId = enterParams != null ? enterParams.getMapId() : 0;
            ZootopiaEnterParams enterParams2 = this.f329402c.getEnterParams();
            if (enterParams2 == null || (str = enterParams2.getSource()) == null) {
                str = "0";
            }
            bVar.x(mapId, str, String.valueOf(currentTimeMillis), String.valueOf(currentTimeMillis), success);
        }
    }

    public ZPlanUELoaderController(ZootopiaUEActivity zootopiaUEActivity, ZootopiaEnterParams zootopiaEnterParams, ZPlanUELoadingController zPlanUELoadingController, ZootopiaSource zootopiaSource, boolean z16, com.tencent.sqshow.zootopia.report.b bVar, com.tencent.mobileqq.zootopia.l progressRecord, ud3.a aVar, UEActivityPluginManager uEActivityPluginManager) {
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
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<ZPlanUEReportHelper>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController$ueReportHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ZPlanUEReportHelper invoke() {
                return new ZPlanUEReportHelper(ZPlanUELoaderController.this.getSource(), ZPlanUELoaderController.this.getEnterParams());
            }
        });
        this.ueReportHelper = lazy;
        this.enterSource = "0";
        this.startEngineListenerPool = new SparseArray<>();
        this.startEngineCounter = new AtomicInteger(0);
        p0();
    }

    private final boolean D() {
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "checkCouldEnterMap, start");
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null ? Intrinsics.areEqual(zootopiaEnterParams.getIsDownloaded(), Boolean.FALSE) : false) {
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterMap, but is not downloaded, return");
            return false;
        }
        if (!this.engineInited) {
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterMap, but engine not ready");
            return false;
        }
        if (this.triggeredEnterMap) {
            QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 2, "enterMap, has entered");
            return false;
        }
        this.triggeredEnterMap = true;
        return true;
    }

    private final void E(String fromSource) {
        long loadingStartTime = this.progressRecord.getLoadingStartTime();
        this.progressRecord.k(System.currentTimeMillis());
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, fromSource + ", doWhenNativeModLoadingBegin " + this.progressRecord.getLoadingId() + ", fix loadingStartTime, old= " + loadingStartTime + ", new= " + this.progressRecord.getLoadingStartTime());
        T().i(this.progressRecord);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G() {
        Unit unit;
        ZPlanBaseSceneLoadingView loadingView;
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterMap, loading real start, enterSource: " + this.enterSource);
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.h(ZPlanModLoadStatus.UELoading);
        }
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null) {
            if (zootopiaEnterParams instanceof ZootopiaGameParams) {
                q0();
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterMap, enterParams is null");
        }
    }

    private final long M() {
        long currentTimeMillis = System.currentTimeMillis();
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        return currentTimeMillis - (zootopiaEnterParams != null ? zootopiaEnterParams.getStartTime() : 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZPlanUEReportHelper T() {
        return (ZPlanUEReportHelper) this.ueReportHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V(boolean success, JSONObject params) {
        String jSONObject = params.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "params.toString()");
        ZplanAVControllerForQAV.Companion companion = ZplanAVControllerForQAV.INSTANCE;
        if (companion.t(params.optInt("GameId"))) {
            companion.f();
            companion.h(true);
        }
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "backToActivity=" + companion.l() + " onEnterSceneResult : " + success + ", " + jSONObject);
        int optInt = params.optInt("GameId");
        if (success && params.optInt("FromScene") == 1 && companion.t(optInt)) {
            if (companion.m()) {
                companion.E(false);
            } else {
                if (params.optLong("conectedTime") > 0) {
                    com.tencent.mobileqq.zplan.proxy.a.INSTANCE.c(params.optLong("conectedTime"));
                    QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "lgx backto ueactivity getConnectTime = " + params.optLong("conectedTime"));
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

    private final void W() {
        final ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null) {
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "handleFileBrokenError mapId " + zootopiaEnterParams.getMapId());
            ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.d
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoaderController.X(ZootopiaEnterParams.this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X(ZootopiaEnterParams it) {
        Intrinsics.checkNotNullParameter(it, "$it");
        ((com.tencent.mobileqq.zootopia.ipc.n) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.n.class)).handleDownloadedFileBroken(it.getMapId(), it.getName(), null);
    }

    private final void a0(final int errorCode, final String errorMsg, final ZootopiaLoadingErrMod mod) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.e
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderController.b0(ZootopiaLoadingErrMod.this, errorCode, errorMsg);
            }
        });
        QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "\u4e50\u56ed\u8fdb\u5165\u5931\u8d25\uff0cerrorCode = " + errorCode + " errorMsg = " + errorMsg + " mod=" + mod.name());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b0(ZootopiaLoadingErrMod mod, int i3, String errorMsg) {
        Intrinsics.checkNotNullParameter(mod, "$mod");
        Intrinsics.checkNotNullParameter(errorMsg, "$errorMsg");
        QQToast.makeText(BaseApplicationImpl.sApplication.getApplicationContext(), 4, "\u4e50\u56ed\u8fdb\u5165\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 1000).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c0(ZPlanUELoaderController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        UEActivityPluginManager uEActivityPluginManager = this$0.pluginManager;
        if (uEActivityPluginManager != null) {
            uEActivityPluginManager.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e0(ZPlanUELoaderController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SimpleEventBus simpleEventBus = SimpleEventBus.getInstance();
        ZootopiaEnterParams zootopiaEnterParams = this$0.enterParams;
        simpleEventBus.dispatchEvent(new ZplanHideLoadingEvent(zootopiaEnterParams != null ? Integer.valueOf(zootopiaEnterParams.getMapId()) : null), true);
        this$0.loadingController.t(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f0(ZPlanUELoaderController this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZPlanUEReportHelper T = this$0.T();
        ZPlanUELoadingController zPlanUELoadingController = this$0.loadingController;
        T.g(zPlanUELoadingController != null ? zPlanUELoadingController.getLoadingView() : null);
        ZootopiaUEActivity zootopiaUEActivity = this$0.activity;
        if (zootopiaUEActivity != null) {
            zootopiaUEActivity.finish();
        }
    }

    private final void g0() {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h0(ZPlanUELoaderController this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T().d(this$0.progressRecord, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i0(boolean isSuccess, long stepCost) {
        this.runEnterAvatarSuccessTime = System.currentTimeMillis();
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.k(C(this, false, stepCost, 1, null), isSuccess);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j0(long stepCost) {
        this.firstFrameTime = System.currentTimeMillis();
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.l(C(this, false, stepCost, 1, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0(ZootopiaUEActivity activity, Integer mapId, long needDownloadSize, Function1<? super Boolean, Unit> callback) {
        Unit unit;
        ud3.b o16;
        if (activity == null) {
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "showHotPatchMobileTipsDialog -" + mapId + " - activity is null");
            callback.invoke(Boolean.TRUE);
            return;
        }
        String string = activity.getString(R.string.xw7);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026tpatch_download_4g_title)");
        String string2 = activity.getString(R.string.xw6, com.tencent.mobileqq.zootopia.space.j.f329276a.e(needDownloadSize));
        Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(\n    \u2026wnloadSize)\n            )");
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController == null || (o16 = zPlanUELoadingController.o()) == null) {
            unit = null;
        } else {
            String string3 = activity.getString(R.string.xw4);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.str\u2026patch_download_4g_cancel)");
            String string4 = activity.getString(R.string.xw5);
            Intrinsics.checkNotNullExpressionValue(string4, "activity.getString(R.str\u2026atch_download_4g_confirm)");
            o16.a(string, string2, string3, string4, new g(mapId, callback));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "showHotPatchMobileTipsDialog - dialog null");
            callback.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void n0(final long remainTime) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.f
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderController.o0(ZPlanUELoaderController.this, remainTime);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o0(ZPlanUELoaderController this$0, long j3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        CountDownTimer countDownTimer = this$0.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "startCountDown, time: 30000");
        h hVar = new h(j3, this$0);
        this$0.countDownTimer = hVar;
        hVar.start();
    }

    private final void p0() {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        int andIncrement = this.startEngineCounter.getAndIncrement();
        i iVar = new i(currentTimeMillis, andIncrement, this);
        this.startEngineListenerPool.put(andIncrement, iVar);
        ((we3.a) k74.i.INSTANCE.a(we3.a.class)).startEngine("zootopia_startMap", iVar);
        com.tencent.mobileqq.zootopia.ueloading.report.b bVar = com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0;
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        if (zootopiaEnterParams2 == null || (str = zootopiaEnterParams2.getSource()) == null) {
            str = "0";
        }
        bVar.w(mapId, str);
    }

    private final void q0() {
        PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController$trulyEnterMap$1
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
                QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "trulyEnterMap");
                ZPlanUELoaderController.this.J();
            }
        });
        g0();
    }

    public void A(JSONObject params, ZootopiaEnterParams curFullEnterParams) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(curFullEnterParams, "curFullEnterParams");
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "backEnterAvatarScene, load ue in background");
        long currentTimeMillis = System.currentTimeMillis();
        if (!UE4.isEngineActive()) {
            i.Companion companion = k74.i.INSTANCE;
            ((ok3.b) companion.a(ok3.b.class)).keepEngine();
            ((ok3.b) companion.a(ok3.b.class)).resumeEngine();
        }
        com.tencent.zplan.world.manager.a.f386318c.c(params.getInt("ViewType"), params.toString(), new b(currentTimeMillis, this, params, curFullEnterParams));
    }

    public void F(dy4.a render, JSONObject params, ZootopiaEnterParams curFullEnterParams) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(curFullEnterParams, "curFullEnterParams");
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterAvatarScene, load ue in foreground");
        if (render == null) {
            return;
        }
        com.tencent.mobileqq.zootopia.utils.n.INSTANCE.a(render, params.getInt("ViewType"), params.toString(), new d(System.currentTimeMillis(), this, params, curFullEnterParams));
    }

    public void H() {
        if (!D()) {
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterMapWithCheck, checkCouldEnterMap, false");
        } else {
            G();
        }
    }

    public void J() {
        ZPlanBaseSceneLoadingView loadingView;
        QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithBaseModCheck start");
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams == null) {
            QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithBaseModCheck enterParams is null");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.o(C(this, false, 0L, 3, null));
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.h(ZPlanModLoadStatus.NativeSourceCheck);
        }
        ((si3.b) vb3.a.f441346a.a(si3.b.class)).E(zootopiaEnterParams, new ZPlanUELoaderController$enterSceneWithBaseModCheck$1(this, currentTimeMillis, zootopiaEnterParams));
    }

    public void K(ZootopiaEnterParams enterParams, String modConfigJson) {
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        Intrinsics.checkNotNullParameter(modConfigJson, "modConfigJson");
        long currentTimeMillis = System.currentTimeMillis();
        ZPlanModHotPatchConfig modHotPatchConfig = ((com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.b) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.download.mod.hotpatch.ipc.b.class)).getModHotPatchConfig(String.valueOf(enterParams.getMapId()));
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterSceneWithHotPatchCheck modConfig= " + modHotPatchConfig + ", costTime = " + (System.currentTimeMillis() - currentTimeMillis));
        boolean z16 = false;
        if (modHotPatchConfig != null && modHotPatchConfig.getEnableHotPatch()) {
            z16 = true;
        }
        if (!z16) {
            I(modConfigJson, null, true);
        } else {
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.r(C(this, false, 0L, 3, null));
            ZPlanModHotPatchForModProcess.f328100a.f("ZPlanUELoaderController-ZootopiaUEActivity enterScene", String.valueOf(enterParams.getMapId()), new ZPlanUELoaderController$enterSceneWithHotPatchCheck$1(this, enterParams, currentTimeMillis, modHotPatchConfig, modConfigJson), true, true);
        }
    }

    @Override // ud3.c
    public void K5(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod, com.tencent.mobileqq.zootopia.l progressRecord, boolean reportMod, String source) {
        Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
        Intrinsics.checkNotNullParameter(mod, "mod");
        Intrinsics.checkNotNullParameter(source, "source");
        T().e(errorCode, errorMsg, mod, progressRecord, reportMod, source);
    }

    /* renamed from: L, reason: from getter */
    public final ZootopiaUEActivity getActivity() {
        return this.activity;
    }

    /* renamed from: N, reason: from getter */
    public final ZootopiaEnterParams getEnterParams() {
        return this.enterParams;
    }

    /* renamed from: O, reason: from getter */
    public final ZPlanUELoadingController getLoadingController() {
        return this.loadingController;
    }

    /* renamed from: P, reason: from getter */
    public final ud3.a getModLoadListener() {
        return this.modLoadListener;
    }

    /* renamed from: Q, reason: from getter */
    public final com.tencent.mobileqq.zootopia.l getProgressRecord() {
        return this.progressRecord;
    }

    /* renamed from: R, reason: from getter */
    public final com.tencent.sqshow.zootopia.report.b getReporter() {
        return this.reporter;
    }

    /* renamed from: S, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    /* renamed from: U, reason: from getter */
    public final boolean getUseV2Loading() {
        return this.useV2Loading;
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
        QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "onLoadingError, onProgressError:" + errorCode + ", " + errorMsg + ", " + mod.name() + ", ignore:" + z16);
        if (z16) {
            return;
        }
        Z(errorCode, errorMsg, mod);
        ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.c
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderController.f0(ZPlanUELoaderController.this);
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
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "controller onCreate - " + this);
        this.enterSource = source;
        this.startTime = System.currentTimeMillis();
        this.isBackLoad = isBackLoad;
        if (!Intrinsics.areEqual(source, "3")) {
            T().n(this.progressRecord.getLoadingId());
        }
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.h(C(this, false, 0L, 3, null));
        UE4.loadModulesInDLL(false);
        com.tencent.zplan.engine.service.c.INSTANCE.a(this);
        ZPlanModLoadStatusManagerForModProcess.f335710a.f(this);
        SimpleEventBus.getInstance().registerReceiver(this);
        com.tencent.zplan.engine.service.d.f385635c.j();
        if (!isBackLoad) {
            ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
            if (zootopiaEnterParams != null ? Intrinsics.areEqual(zootopiaEnterParams.getIsDownloaded(), Boolean.TRUE) : false) {
                E("enter and mainPak is ready");
            }
            H();
        } else {
            E("backLoad");
        }
        QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "onCreate cost: " + (System.currentTimeMillis() - this.startTime) + "ms");
    }

    @Override // ud3.c
    public void fc() {
        c.a.c(this);
        final long currentTimeMillis = this.firstFrameTime != 0 ? System.currentTimeMillis() - this.firstFrameTime : 0L;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.b
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanUELoaderController.h0(ZPlanUELoaderController.this, currentTimeMillis);
            }
        }, 128, null, false);
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.n(C(this, false, System.currentTimeMillis() - this.runEnterAvatarSuccessTime, 1, null));
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        return c.a.a(this);
    }

    @Override // ud3.c
    public void jf(boolean isBackLoad) {
        ZPlanBaseSceneLoadingView loadingView;
        if (!D()) {
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "checkMod, iSCloudEnterMap, false");
            return;
        }
        this.triggeredEnterMap = true;
        this.isBackLoad = isBackLoad;
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "checkMod, isBackLoad: " + isBackLoad + ", enterSource: " + this.enterSource);
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.h(ZPlanModLoadStatus.PreChecking);
        }
        com.tencent.mobileqq.zplan.authorize.api.c cVar = (com.tencent.mobileqq.zplan.authorize.api.c) vb3.a.f441346a.a(com.tencent.mobileqq.zplan.authorize.api.c.class);
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : -1;
        ZootopiaSource zootopiaSource = this.source;
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.INSTANCE.i();
        }
        cVar.U(mapId, new ModChekerParams(zootopiaSource, this.enterSource, true, false, null, 24, null), new c());
    }

    public void k0(com.tencent.mobileqq.zootopia.l progressRecord) {
        Intrinsics.checkNotNullParameter(progressRecord, "progressRecord");
        T().o(progressRecord);
    }

    public final void l0(ZootopiaEnterParams zootopiaEnterParams) {
        this.enterParams = zootopiaEnterParams;
    }

    @Override // ud3.c
    public void onDestroy() {
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "onDestroy - " + this);
        this.hasDestroyed = true;
        com.tencent.zplan.engine.service.c.INSTANCE.b(this);
        ZPlanModLoadStatusManagerForModProcess.f335710a.g(this);
        SimpleEventBus.getInstance().unRegisterReceiver(this);
        ((qk3.a) k74.i.INSTANCE.a(qk3.a.class)).clear();
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
    public void onEngineInitFinish(boolean success) {
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "onEngineInitFinish:" + success);
        this.engineInited = success;
        if (success) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.a
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoaderController.c0(ZPlanUELoaderController.this);
                }
            });
            if (!this.isFromDownloaded && !this.isBackLoad) {
                H();
                return;
            }
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "continue load mod after engine inited, isFromDownloaded: " + this.isFromDownloaded + ", isBackLoad: " + this.isBackLoad);
            jf(this.isBackLoad);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(SimpleBaseEvent simpleBaseEvent) {
        c.a.b(this, simpleBaseEvent);
    }

    @Override // ud3.c
    public void onResume() {
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "onResume triggeredEnterMap:" + this.triggeredEnterMap + ", shouldReEnterSceneWhenResume:" + this.shouldReEnterSceneWhenResume);
        if (this.triggeredEnterMap && this.shouldReEnterSceneWhenResume) {
            this.shouldReEnterSceneWhenResume = false;
            J();
        }
    }

    @Override // com.tencent.mobileqq.zplan.smallhome.status.a
    public void updateStatus(ZPlanModLoadStatusInfo statusInfo) {
        Intrinsics.checkNotNullParameter(statusInfo, "statusInfo");
        if (this.isBackLoad) {
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "updateStatus, isBackLoad, return");
            return;
        }
        if (this.lastCallbackStatus != statusInfo.getStatus()) {
            this.lastCallbackStatus = statusInfo.getStatus();
            QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "updateStatus, statusInfo: " + statusInfo.getStatus() + ", " + this);
            if (statusInfo.getStatus() == ZPlanModLoadStatus.MainPakDownloadFinish) {
                ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
                if (zootopiaEnterParams != null) {
                    zootopiaEnterParams.setDownloaded(Boolean.TRUE);
                }
                QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "is downloaded, start checkMod");
                E("after MainPakDownloadFinish");
                if (this.engineInited) {
                    jf(false);
                } else {
                    this.isFromDownloaded = true;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ZPlanUETechReportParams B(boolean needDownloadCommonMod, long stepCost) {
        Boolean isDownloaded;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0;
        long M = M();
        boolean z16 = this.useV2Loading;
        boolean z17 = this.isBackLoad;
        String str = this.enterSource;
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        boolean booleanValue = (zootopiaEnterParams2 == null || (isDownloaded = zootopiaEnterParams2.getIsDownloaded()) == null) ? true : isDownloaded.booleanValue();
        ModDownloadHelper modDownloadHelper = ModDownloadHelper.f334765a;
        ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
        return new ZPlanUETechReportParams(mapId, M, stepCost, z16, z17, str, booleanValue, needDownloadCommonMod, modDownloadHelper.g(zootopiaEnterParams3 != null ? zootopiaEnterParams3.getMapId() : 0));
    }

    public void d0(com.tencent.mobileqq.zootopia.l progressRecord) {
        String str;
        ZPlanUELoadingController zPlanUELoadingController;
        ZPlanBaseSceneLoadingView loadingView;
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "notify onFirstFrameLoadingSuccess");
        if (!this.useV2Loading && (zPlanUELoadingController = this.loadingController) != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.zootopia.ueloading.g
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanUELoaderController.e0(ZPlanUELoaderController.this);
                }
            }, 250L);
        }
        ZPlanUEReportHelper T = T();
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams == null || (str = zootopiaEnterParams.getSource()) == null) {
            str = "0";
        }
        T.f(progressRecord, str);
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
    }

    @Override // ud3.c
    public void onStop() {
        this.shouldReEnterSceneWhenResume = true;
    }

    @Override // ud3.c
    public void t8(ZootopiaEnterParams enterParams) {
        this.triggeredEnterMap = false;
        H();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Y(final ZootopiaUEActivity activity, final ZootopiaEnterParams enterParams, String modConfigJson, int errorCode, String errorMessage) {
        Unit unit;
        ud3.b o16;
        String string = activity.getString(R.string.xw9);
        Intrinsics.checkNotNullExpressionValue(string, "activity.getString(R.str\u2026patch_download_err_title)");
        final String str = activity.getString(R.string.xw8) + "";
        ZPlanUELoadingController zPlanUELoadingController = this.loadingController;
        if (zPlanUELoadingController == null || (o16 = zPlanUELoadingController.o()) == null) {
            unit = null;
        } else {
            String string2 = activity.getString(R.string.xov);
            Intrinsics.checkNotNullExpressionValue(string2, "activity.getString(R.string.zplan_finsih)");
            String string3 = activity.getString(R.string.xss);
            Intrinsics.checkNotNullExpressionValue(string3, "activity.getString(R.string.zplan_retry)");
            o16.a(string, str, string2, string3, new f(enterParams, activity, this, modConfigJson));
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            PostUtilKt.b(new Function0<Unit>() { // from class: com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController$handleHotPatchCheckError$2$1
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
                    QLog.e("ZPlanUELoaderController-ZootopiaUEActivity", 1, "handleHotPatchCheckError - " + ZootopiaEnterParams.this.getMapId() + ", toast");
                    QQToastUtil.showQQToast(1, str);
                    activity.finish();
                }
            });
        }
    }

    private final void Z(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod) {
        if (errorCode != 10004 && errorCode != 10010) {
            a0(errorCode, errorMsg, mod);
        } else {
            W();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ ZPlanUETechReportParams C(ZPlanUELoaderController zPlanUELoaderController, boolean z16, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        if ((i3 & 2) != 0) {
            j3 = 0;
        }
        return zPlanUELoaderController.B(z16, j3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void I(String baseModData, ZPlanResHubResultInfo hotPatchInfo, boolean hasSkippedHotPatch) {
        Map<String, String> convertToModEnterParams;
        JSONObject jsonObject;
        ZootopiaEnterParams zootopiaEnterParams;
        if (hasSkippedHotPatch) {
            convertToModEnterParams = null;
        } else {
            convertToModEnterParams = (hotPatchInfo == null ? new ZPlanResHubResultInfo("", "", "", null, null, null, null, null, 248, null) : hotPatchInfo).convertToModEnterParams();
        }
        QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterScene, baseModData:" + baseModData + ", hotPatchParam:" + convertToModEnterParams + ", hasSkippedHotPatch:" + hasSkippedHotPatch);
        if (!this.engineInited) {
            QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterScene, engineInited:" + this.engineInited + ", return");
            return;
        }
        if (!this.isBackLoad) {
            QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "enterScene, reformBack2Front");
            ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
            if (zootopiaEnterParams2 != null) {
                com.tencent.mobileqq.zplan.smallhome.i.f335703a.b(zootopiaEnterParams2.getMapId(), toString());
            }
        }
        ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
        if (zootopiaEnterParams3 == null || (jsonObject = zootopiaEnterParams3.toJsonObject()) == null || (zootopiaEnterParams = this.enterParams) == null) {
            return;
        }
        if (convertToModEnterParams != null) {
            for (Map.Entry<String, String> entry : convertToModEnterParams.entrySet()) {
                jsonObject.put(entry.getKey(), entry.getValue());
            }
        }
        jsonObject.put("ComModPakPathPrefix", v.f328299a.c());
        if (baseModData.length() > 0) {
            jsonObject.put("ComModuleCfgStr", baseModData);
        }
        ZootopiaSource zootopiaSource = this.source;
        jsonObject.put("Source", zootopiaSource != null ? ah.b(zootopiaSource) : null);
        long currentTimeMillis = System.currentTimeMillis();
        QLog.i("ZPlanUELoaderController-ZootopiaUEActivity", 1, "getDefaultAvatarCharacter, start");
        com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.f(C(this, false, 0L, 3, null));
        ((eh3.a) k74.i.INSTANCE.a(eh3.a.class)).getDefaultAvatarCharacter(new e(currentTimeMillis, this, jsonObject, zootopiaEnterParams));
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zootopia/ueloading/ZPlanUELoaderController$h", "Landroid/os/CountDownTimer;", "", "millisUntilFinished", "", AdCommonMethodHandler.AdCommonEvent.ON_TICK, "onFinish", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class h extends CountDownTimer {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ZPlanUELoaderController f329399a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        h(long j3, ZPlanUELoaderController zPlanUELoaderController) {
            super(j3, 1000L);
            this.f329399a = zPlanUELoaderController;
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            ud3.b o16;
            if (this.f329399a.isFirstFrameReady) {
                QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "isFirstFrameReady true, return");
                return;
            }
            QLog.d("ZPlanUELoaderController-ZootopiaUEActivity", 1, "show error dialog");
            ZPlanUELoadingController loadingController = this.f329399a.getLoadingController();
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
