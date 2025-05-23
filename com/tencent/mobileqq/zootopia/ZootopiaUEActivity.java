package com.tencent.mobileqq.zootopia;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import com.epicgames.ue4.GameActivity;
import com.epicgames.ue4.GameActivityThunk;
import com.epicgames.ue4.UE4;
import com.tencent.ams.dsdk.core.hippy.DKHippyEvent;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zootopia.ZootopiaUEActivity;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaGameParams;
import com.tencent.mobileqq.zootopia.data.ZootopiaMapLoadingParams;
import com.tencent.mobileqq.zootopia.ipc.f;
import com.tencent.mobileqq.zootopia.qav.ZplanAVControllerForQAV;
import com.tencent.mobileqq.zootopia.service.api.IZootopiaShareArkService;
import com.tencent.mobileqq.zootopia.ue.UEActivityPluginManager;
import com.tencent.mobileqq.zootopia.ue.UEActivityViewManager;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderController;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoaderControllerV2;
import com.tencent.mobileqq.zootopia.ueloading.ZPlanUELoadingController;
import com.tencent.mobileqq.zootopia.utils.AccountChangeReceiver;
import com.tencent.mobileqq.zootopia.view.ZPlanBaseSceneLoadingView;
import com.tencent.mobileqq.zootopia.view.ZootopiaAudioCallFloatView;
import com.tencent.mobileqq.zootopia.webview.ZPlanModH5MediaStatusManager;
import com.tencent.mobileqq.zplan.ZPlanAppInterface;
import com.tencent.mobileqq.zplan.authorize.api.CommonModCheckResult;
import com.tencent.mobileqq.zplan.dresskey.api.DressInfoIPCData;
import com.tencent.mobileqq.zplan.polling.PollingManager;
import com.tencent.mobileqq.zplan.polling.task.TaskIdEnum;
import com.tencent.mobileqq.zplan.smallhome.ZPlanUEActivityHelper;
import com.tencent.mobileqq.zplan.smallhome.status.ZPlanModLoadStatusManagerForMain;
import com.tencent.mobileqq.zplan.utils.ba;
import com.tencent.mobileqq.zplan.utils.stack.lifecycle.IUEActivityLifeCycle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.MiniSDKConst;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import com.tencent.sqshow.zootopia.utils.ag;
import com.tencent.state.report.SquareReportConst;
import com.tencent.util.LiuHaiUtils;
import com.tencent.zplan.luabridge.plugins.data.CommonLoadingData;
import com.tencent.zplan.utils.StackPrinter;
import com.tencent.zplan.world.activity.ZPlanActivity;
import com.tencent.zplan.world.model.FirstFrameResult;
import defpackage.UEBuglyInfoRecorder;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import k74.i;
import kc3.GameJudgeParams;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.QQPermissionCallback;
import mqq.app.QQPermissionHelper;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ca\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00d2\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b:\u0002\u00d3\u0001B\t\u00a2\u0006\u0006\b\u00d0\u0001\u0010\u00d1\u0001J\n\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J(\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J\u0012\u0010\u0018\u001a\u00020\u000b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\b\u0010\u001a\u001a\u00020\u000bH\u0002J\b\u0010\u001b\u001a\u00020\u000bH\u0002J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\b\u0010\u001e\u001a\u00020\u0012H\u0002J\b\u0010\u001f\u001a\u00020\u000bH\u0002J\b\u0010 \u001a\u00020\u000bH\u0002J\b\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u000bH\u0002J\b\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u000bH\u0002J\u0012\u0010'\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J\u0012\u0010(\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010%H\u0002J \u0010.\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u000bH\u0002J\b\u00100\u001a\u00020\u0012H\u0002J\b\u00102\u001a\u000201H\u0016J\u001a\u00106\u001a\u00020\u00122\u0006\u00103\u001a\u00020)2\b\u00105\u001a\u0004\u0018\u000104H\u0016J\u0010\u00109\u001a\u00020\u000b2\u0006\u00108\u001a\u000207H\u0014J\u0012\u0010;\u001a\u00020\u000b2\b\u0010:\u001a\u0004\u0018\u000107H\u0014J\u0010\u0010=\u001a\u00020\u000b2\u0006\u0010<\u001a\u00020)H\u0007J\u0006\u0010>\u001a\u00020\u000fJ\b\u0010?\u001a\u00020\u000bH\u0014J\u0012\u0010B\u001a\u00020\u000b2\b\u0010A\u001a\u0004\u0018\u00010@H\u0014J\b\u0010C\u001a\u00020\u000bH\u0014J\u0010\u0010E\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u0012H\u0016J\u0010\u0010G\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000fH\u0016J\u001a\u0010I\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\b\u0010H\u001a\u0004\u0018\u00010\u000fH\u0016J\u0018\u0010M\u001a\u00020\u000b2\u0006\u0010K\u001a\u00020J2\u0006\u0010L\u001a\u00020JH\u0016J \u0010Q\u001a\u00020\u000b2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010O\u001a\u00020N2\u0006\u0010P\u001a\u00020\tH\u0016J\u0010\u0010T\u001a\u00020\u000b2\u0006\u0010S\u001a\u00020RH\u0016J\b\u0010U\u001a\u00020\u000bH\u0016J\b\u0010V\u001a\u00020\u000bH\u0014J\b\u0010W\u001a\u00020\u000bH\u0014J\u0010\u0010X\u001a\u00020\u000b2\b\u0010O\u001a\u0004\u0018\u00010\tJ\u0010\u0010[\u001a\u00020\u000b2\u0006\u0010Z\u001a\u00020YH\u0016J\u001a\u0010\\\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u000fH\u0016J7\u0010b\u001a\u00020\u000b2\u0006\u0010^\u001a\u00020]2\u0006\u0010_\u001a\u00020)2\u0016\u0010a\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u000f0`\"\u0004\u0018\u00010\u000fH\u0017\u00a2\u0006\u0004\bb\u0010cJ\b\u0010e\u001a\u00020dH\u0016J/\u0010h\u001a\u00020\u000b2\u0006\u0010_\u001a\u00020)2\u000e\u0010a\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000f0`2\u0006\u0010g\u001a\u00020fH\u0016\u00a2\u0006\u0004\bh\u0010iJ\u0010\u0010k\u001a\u00020\u000b2\u0006\u0010j\u001a\u00020\u000fH\u0016J\u0012\u0010m\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020]0lJ\u0010\u0010o\u001a\u00020\u000b2\u0006\u0010n\u001a\u00020)H\u0016J\u0010\u0010r\u001a\u00020\u000b2\u0006\u0010q\u001a\u00020pH\u0016J\b\u0010s\u001a\u00020\u0012H\u0016J\u0006\u0010u\u001a\u00020tJ\u0006\u0010v\u001a\u00020\u0012R\u0018\u0010P\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bw\u0010xR\"\u0010\u007f\u001a\u00020\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010z\u001a\u0004\b{\u0010|\"\u0004\b}\u0010~R\u0017\u0010\u0082\u0001\u001a\u0002018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0080\u0001\u0010\u0081\u0001R\u0019\u0010\u0085\u0001\u001a\u00020t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0089\u0001\u001a\u00030\u0086\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0087\u0001\u0010\u0088\u0001R\u0018\u0010\u008d\u0001\u001a\u00030\u008a\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R\u001c\u0010\u0091\u0001\u001a\u0005\u0018\u00010\u008e\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u008f\u0001\u0010\u0090\u0001R\u0019\u0010\u0094\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0092\u0001\u0010\u0093\u0001R\u0019\u0010\u0096\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0095\u0001\u0010\u0093\u0001R\u001a\u0010\u009a\u0001\u001a\u00030\u0097\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u0098\u0001\u0010\u0099\u0001R'\u0010\u009f\u0001\u001a\u0012\u0012\r\u0012\u000b\u0012\u0006\u0012\u0004\u0018\u00010]0\u009c\u00010\u009b\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u009d\u0001\u0010\u009e\u0001R\u001a\u0010\u00a1\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00a0\u0001\u0010zR\u0018\u0010\u00a5\u0001\u001a\u00030\u00a2\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a3\u0001\u0010\u00a4\u0001R\u0018\u0010\u00a9\u0001\u001a\u00030\u00a6\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00a7\u0001\u0010\u00a8\u0001R\u0018\u0010\u00ad\u0001\u001a\u00030\u00aa\u00018\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u00ab\u0001\u0010\u00ac\u0001R\u0018\u0010\u00af\u0001\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0007\n\u0005\b\u00ae\u0001\u0010zR\u0019\u0010\u00b2\u0001\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b0\u0001\u0010\u00b1\u0001R\u001b\u0010\u00b5\u0001\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b3\u0001\u0010\u00b4\u0001R\u001c\u0010\u00b9\u0001\u001a\u0005\u0018\u00010\u00b6\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00b7\u0001\u0010\u00b8\u0001R\u001c\u0010\u00bd\u0001\u001a\u0005\u0018\u00010\u00ba\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bb\u0001\u0010\u00bc\u0001R\u001c\u0010\u00c1\u0001\u001a\u0005\u0018\u00010\u00be\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00bf\u0001\u0010\u00c0\u0001R\u001c\u0010\u00c5\u0001\u001a\u0005\u0018\u00010\u00c2\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c3\u0001\u0010\u00c4\u0001R\u0019\u0010\u00c7\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c6\u0001\u0010\u0093\u0001R\u001c\u0010\u00cb\u0001\u001a\u0005\u0018\u00010\u00c8\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00c9\u0001\u0010\u00ca\u0001R\u001c\u0010\u00cf\u0001\u001a\u0005\u0018\u00010\u00cc\u00018\u0002@\u0002X\u0082\u000e\u00a2\u0006\b\n\u0006\b\u00cd\u0001\u0010\u00ce\u0001\u00a8\u0006\u00d4\u0001"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity;", "Lcom/tencent/zplan/world/activity/ZPlanActivity;", "Ltx4/a;", "Lcom/tencent/mobileqq/zootopia/lua/d;", "Lcom/epicgames/ue4/GameActivityThunk$CMShowEngineInitFinishListener;", "Lcom/tencent/mobileqq/zootopia/lua/b;", "Li74/b;", "Lcom/tencent/mobileqq/zootopia/lua/e;", "Lud3/a;", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "B3", "", "d3", "H3", "p3", "", "peerUin", "peerNickName", "", "isGroup", "", "roomId", "M3", "newUrl", "T3", "I3", "C3", "g3", "r3", "initObserver", "e3", "F3", "f3", Constants.BASE_IN_APP_NAME, "E3", "R3", "S3", "Lsc3/b;", "observer", "c3", Constants.EMULATOR_INFO, "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/zootopia/ZootopiaLoadingErrMod;", "mod", "x3", "Q3", "t3", "Lcom/tencent/mobileqq/zootopia/helper/e;", BdhLogUtil.LogTag.Tag_Conn, "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "Landroid/os/Bundle;", "outState", "onSaveInstanceState", mqq.app.Constants.FILE_INSTANCE_STATE, "onCreate", "status", "J3", ICustomDataEditor.NUMBER_PARAM_3, "onResume", "Landroid/content/Intent;", "newIntent", "onNewIntent", DKHippyEvent.EVENT_STOP, "success", "onEngineInitFinish", "modConfigJson", "p", "errorMessage", "A1", "Lcom/tencent/mobileqq/zplan/dresskey/api/DressInfoIPCData;", "maleAvatarCharacter", "femaleAvatarCharacter", ICustomDataEditor.STRING_ARRAY_PARAM_2, "Lorg/json/JSONObject;", "params", "enterParams", "j2", "Lcom/tencent/zplan/world/model/FirstFrameResult;", "result", "W0", "finish", MiniSDKConst.NOTIFY_EVENT_ONPAUSE, MosaicConstants$JsFunction.FUNC_ON_DESTROY, "P3", "Lcom/tencent/zplan/luabridge/plugins/data/CommonLoadingData;", "loadingData", "Q0", "o", "", "caller", "requestCode", "", "permissions", "requestPermissions", "(Ljava/lang/Object;I[Ljava/lang/String;)V", "Landroid/app/Activity;", "x1", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", IZootopiaShareArkService.ARK_MAP_TEAM_PARAMS, "c1", "", "i3", "requestedOrientation", "setRequestedOrientation", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", ICustomDataEditor.STRING_ARRAY_PARAM_8, "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "l3", ICustomDataEditor.STRING_PARAM_3, "k0", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "l0", "Ljava/lang/String;", "j3", "()Ljava/lang/String;", "setNewGuideUrl", "(Ljava/lang/String;)V", "newGuideUrl", "m0", "Lcom/tencent/mobileqq/zootopia/helper/e;", "permissionHelper", "n0", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "o0", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityViewManager;", "viewManager", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "p0", "Lcom/tencent/mobileqq/zootopia/ue/UEActivityPluginManager;", "pluginManager", "Lcom/tencent/sqshow/zootopia/report/b;", "q0", "Lcom/tencent/sqshow/zootopia/report/b;", "reporter", "r0", "Z", "didDestroy", "s0", "isFirstFrameReady", "Lcom/tencent/mobileqq/zootopia/l;", "t0", "Lcom/tencent/mobileqq/zootopia/l;", "progressRecord", "Landroid/util/SparseArray;", "", "u0", "Landroid/util/SparseArray;", "permissionCallerMap", "v0", "launchText", "Ljava/util/concurrent/atomic/AtomicBoolean;", "w0", "Ljava/util/concurrent/atomic/AtomicBoolean;", "isReceiverRegister", "Lcom/tencent/mobileqq/zootopia/utils/AccountChangeReceiver;", "x0", "Lcom/tencent/mobileqq/zootopia/utils/AccountChangeReceiver;", "accountChangeReceiver", "Lal3/a;", "y0", "Lal3/a;", "liveSteamPushManager", "z0", "activityName", "A0", "I", "activityHash", "B0", "Lsc3/b;", "uiObserver", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaAudioCallFloatView;", "C0", "Lcom/tencent/mobileqq/zootopia/view/ZootopiaAudioCallFloatView;", "floatRootView", "Lcom/tencent/mobileqq/zootopia/view/l;", "D0", "Lcom/tencent/mobileqq/zootopia/view/l;", "invitingNotificationView", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "E0", "Lcom/tencent/mobileqq/zootopia/ueloading/ZPlanUELoadingController;", "uELoadingController", "Lud3/c;", "F0", "Lud3/c;", "uELoaderController", "G0", "useV2Loading", "Landroid/content/BroadcastReceiver;", "H0", "Landroid/content/BroadcastReceiver;", "rewardReceiver", "Lkc3/b;", "I0", "Lkc3/b;", "minorsHandler", "<init>", "()V", "J0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZootopiaUEActivity extends ZPlanActivity implements tx4.a, com.tencent.mobileqq.zootopia.lua.d, GameActivityThunk.CMShowEngineInitFinishListener, com.tencent.mobileqq.zootopia.lua.b, i74.b, com.tencent.mobileqq.zootopia.lua.e, ud3.a {

    /* renamed from: J0, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A0, reason: from kotlin metadata */
    private int activityHash;

    /* renamed from: B0, reason: from kotlin metadata */
    private sc3.b uiObserver;

    /* renamed from: C0, reason: from kotlin metadata */
    private ZootopiaAudioCallFloatView floatRootView;

    /* renamed from: D0, reason: from kotlin metadata */
    private com.tencent.mobileqq.zootopia.view.l invitingNotificationView;

    /* renamed from: E0, reason: from kotlin metadata */
    private ZPlanUELoadingController uELoadingController;

    /* renamed from: F0, reason: from kotlin metadata */
    private ud3.c uELoaderController;

    /* renamed from: G0, reason: from kotlin metadata */
    private boolean useV2Loading;

    /* renamed from: H0, reason: from kotlin metadata */
    private BroadcastReceiver rewardReceiver;

    /* renamed from: I0, reason: from kotlin metadata */
    private kc3.b minorsHandler;

    /* renamed from: k0, reason: collision with root package name and from kotlin metadata */
    private ZootopiaEnterParams enterParams;

    /* renamed from: l0, reason: collision with root package name and from kotlin metadata */
    private String newGuideUrl;

    /* renamed from: m0, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.zootopia.helper.e permissionHelper;

    /* renamed from: n0, reason: collision with root package name and from kotlin metadata */
    private ZootopiaSource source;

    /* renamed from: o0, reason: collision with root package name and from kotlin metadata */
    private final UEActivityViewManager viewManager;

    /* renamed from: p0, reason: collision with root package name and from kotlin metadata */
    private final UEActivityPluginManager pluginManager;

    /* renamed from: q0, reason: collision with root package name and from kotlin metadata */
    private com.tencent.sqshow.zootopia.report.b reporter;

    /* renamed from: r0, reason: collision with root package name and from kotlin metadata */
    private boolean didDestroy;

    /* renamed from: s0, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isFirstFrameReady;

    /* renamed from: t0, reason: collision with root package name and from kotlin metadata */
    private l progressRecord;

    /* renamed from: u0, reason: collision with root package name and from kotlin metadata */
    private final SparseArray<List<Object>> permissionCallerMap;

    /* renamed from: v0, reason: collision with root package name and from kotlin metadata */
    private String launchText;

    /* renamed from: w0, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean isReceiverRegister;

    /* renamed from: x0, reason: collision with root package name and from kotlin metadata */
    private final AccountChangeReceiver accountChangeReceiver;

    /* renamed from: y0, reason: collision with root package name and from kotlin metadata */
    private final al3.a liveSteamPushManager;

    /* renamed from: z0, reason: collision with root package name and from kotlin metadata */
    private String activityName;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ9\u0010\f\u001a\u00020\u000b\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u000e8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0010R\u0014\u0010\u0016\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00158\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zootopia/ZootopiaUEActivity$a;", "", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "T", "Landroid/content/Context;", "context", "param", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "Landroid/os/Bundle;", "bundle", "", "b", "(Landroid/content/Context;Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;Landroid/os/Bundle;)V", "", "AT_LOADING", "Ljava/lang/String;", "KEY_CUR_PROCESS_ID", "KEY_PARAMS", "KEY_SOURCE", "TAG", "", "TOAST_SHOW_TIME_DEBUG", "I", "TOAST_SHOW_TIME_RELEASE", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zootopia.ZootopiaUEActivity$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c() {
            ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).setUEActivityStarting(true);
        }

        @JvmStatic
        public final <T extends ZootopiaEnterParams> void b(Context context, T param, ZootopiaSource source, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(param, "param");
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            QLog.i("ZootopiaUEActivity", 1, "[FragmentLifeCycle]start ZootopiaUEActivity:" + param.getMapId() + " - " + param.getName() + " - " + param.getVersion());
            com.tencent.mobileqq.zootopia.ueloading.report.b.f329531a.y(param.getMapId(), param.getSource(), String.valueOf(System.currentTimeMillis() - param.getStartTime()));
            i.Companion companion = k74.i.INSTANCE;
            if (((com.tencent.mobileqq.zootopia.ipc.f) companion.a(com.tencent.mobileqq.zootopia.ipc.f.class)).isUEActivityStarting()) {
                QLog.i("ZootopiaUEActivity", 1, "[FragmentLifeCycle]ZootopiaUEActivity:" + param.getName() + ", is starting, do not repeat, return");
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.w
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaUEActivity.Companion.c();
                }
            }, 16, null, true);
            if (MobileQQ.sProcessId == 1) {
                ZPlanModLoadStatusManagerForMain.f335706a.i(param.getMapId(), false);
            } else {
                ((sk3.b) companion.a(sk3.b.class)).enterLoadStatus(param.getMapId(), false);
            }
            Intent intent = new Intent(context, (Class<?>) ZootopiaUEActivity.class);
            intent.putExtra("enter_params", param);
            intent.putExtra("key_source", source);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtras(bundle);
            context.startActivity(intent);
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0018\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\nH\u0016\u00a8\u0006\u0016"}, d2 = {"com/tencent/mobileqq/zootopia/ZootopiaUEActivity$b", "Lsc3/b;", "", "status", "", "f", "d", "", "peerUin", "peerNickName", "", "isGroup", "", "roomId", "g", "e", "uin", "isSpeaking", "c", "isWifi", "isBad", "b", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends sc3.b {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\t\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0004H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/ZootopiaUEActivity$b$a", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "", "", "permissions", "", ForwardMiniChooseFriendOption.RESULT_LIST, "onDenied", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes35.dex */
        public static final class a extends QQPermission.BasePermissionsListener {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ ZootopiaUEActivity f327897a;

            a(ZootopiaUEActivity zootopiaUEActivity) {
                this.f327897a = zootopiaUEActivity;
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onAllGranted() {
                QLog.i("ZootopiaUiObserver", 1, "request Audio permission result is Granted");
                super.onAllGranted();
            }

            @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
            public void onDenied(List<String> permissions, List<Integer> results) {
                QLog.i("ZootopiaUiObserver", 1, "request audio permission result is Denied");
                super.onDenied(permissions, results);
                this.f327897a.p3();
            }
        }

        b() {
        }

        @Override // sc3.b
        public void b(boolean isWifi, boolean isBad) {
            ZootopiaAudioCallFloatView zootopiaAudioCallFloatView = ZootopiaUEActivity.this.floatRootView;
            if (zootopiaAudioCallFloatView != null) {
                zootopiaAudioCallFloatView.x(isWifi, isBad);
            }
        }

        @Override // sc3.b
        public void c(long uin, boolean isSpeaking) {
            ZootopiaAudioCallFloatView zootopiaAudioCallFloatView = ZootopiaUEActivity.this.floatRootView;
            if (zootopiaAudioCallFloatView != null) {
                zootopiaAudioCallFloatView.y(uin, isSpeaking);
            }
        }

        @Override // sc3.b
        public void d() {
            if (QLog.isColorLevel()) {
                QLog.i("ZootopiaUiObserver", 2, "onChangeUiShowFloatWindow");
            }
            ZootopiaUEActivity.this.p3();
        }

        @Override // sc3.b
        public void e() {
            com.tencent.mobileqq.zootopia.view.l lVar = ZootopiaUEActivity.this.invitingNotificationView;
            if (lVar != null) {
                lVar.f();
            }
        }

        @Override // sc3.b
        public void f(int status) {
            QLog.i("ZootopiaUiObserver", 1, "onChangeUiShowFloatWindow " + status);
            ZootopiaUEActivity.this.J3(status);
        }

        @Override // sc3.b
        public void g(String peerUin, String peerNickName, boolean isGroup, long roomId) {
            Intrinsics.checkNotNullParameter(peerUin, "peerUin");
            Intrinsics.checkNotNullParameter(peerNickName, "peerNickName");
            ZootopiaUEActivity.this.M3(peerUin, peerNickName, isGroup, roomId);
            ZplanAVControllerForQAV.Companion companion = ZplanAVControllerForQAV.INSTANCE;
            ZootopiaUEActivity zootopiaUEActivity = ZootopiaUEActivity.this;
            companion.e(zootopiaUEActivity, new a(zootopiaUEActivity));
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J \u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/zootopia/ZootopiaUEActivity$c", "Llc3/a;", "", "mapId", "", "f", "", "exitCode", "", "msg", "e", "from", "url", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c extends lc3.a {
        c() {
        }

        @Override // lc3.a
        public void d(long from, int mapId, String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            QLog.e("ZootopiaUEActivity", 1, "onMinorsJumpToUrl: mapId=" + mapId + ", from=" + from);
        }

        @Override // lc3.a
        public void e(int mapId, long exitCode, String msg2) {
            QLog.e("ZootopiaUEActivity", 1, "onMinorsLoginInterrupt: mapId=" + mapId + ", exitCode=" + exitCode + ", msg=" + msg2);
        }

        @Override // lc3.a
        public void f(int mapId) {
            QLog.i("ZootopiaUEActivity", 1, "onMinorsLoginSucceed: mapId=" + mapId);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/zootopia/ZootopiaUEActivity$d", "Llc3/b;", "", "mapId", "", "exitCode", "", "msg", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class d implements lc3.b {
        d() {
        }

        @Override // lc3.b
        public void a(int mapId, long exitCode, String msg2) {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            QLog.e("ZootopiaUEActivity", 1, "onMinorsExitGame: mapId=" + mapId + ", exitCode=" + exitCode + ", msg=" + msg2);
            if (ZootopiaUEActivity.this.isFinishing()) {
                return;
            }
            ZootopiaUEActivity.this.finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A3(ZootopiaUEActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((yk3.d) k74.i.INSTANCE.a(yk3.d.class)).activityResume(true, this$0.activityName, this$0.activityHash, "zplan");
    }

    private final ZootopiaEnterParams B3() {
        Serializable serializableExtra = getIntent().getSerializableExtra("enter_params");
        if (serializableExtra instanceof ZootopiaEnterParams) {
            return (ZootopiaEnterParams) serializableExtra;
        }
        return null;
    }

    private final void C3() {
        F3();
        r3();
    }

    private final void D3() {
        if (this.isReceiverRegister.compareAndSet(false, true)) {
            this.accountChangeReceiver.b(this);
        }
    }

    private final void E3() {
        if (this.rewardReceiver != null) {
            return;
        }
        this.rewardReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.zootopia.ZootopiaUEActivity$registerRewardReceiver$1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                QLog.i("ZootopiaUEActivity", 1, "receive reward");
                yb4.e.g(yb4.e.f450058a, null, 0, 3, null);
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("action_broadcast_reward");
        registerReceiver(this.rewardReceiver, intentFilter);
    }

    private final void F3() {
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "removeLoadingView");
        ZPlanUELoadingController zPlanUELoadingController = this.uELoadingController;
        if (zPlanUELoadingController != null) {
            zPlanUELoadingController.t(true);
        }
    }

    private final String I3() {
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        Integer valueOf = zootopiaEnterParams != null ? Integer.valueOf(zootopiaEnterParams.getMapId()) : null;
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        return "[mapID:" + valueOf + ", mapName:" + (zootopiaEnterParams2 != null ? zootopiaEnterParams2.getName() : null) + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void K3(final ZootopiaUEActivity this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.floatRootView == null) {
            ZootopiaAudioCallFloatView zootopiaAudioCallFloatView = new ZootopiaAudioCallFloatView(this$0);
            this$0.floatRootView = zootopiaAudioCallFloatView;
            zootopiaAudioCallFloatView.p(new View.OnClickListener() { // from class: com.tencent.mobileqq.zootopia.v
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ZootopiaUEActivity.L3(ZootopiaUEActivity.this, view);
                }
            });
        }
        ZootopiaAudioCallFloatView zootopiaAudioCallFloatView2 = this$0.floatRootView;
        if (zootopiaAudioCallFloatView2 != null) {
            zootopiaAudioCallFloatView2.q();
        }
        ZootopiaAudioCallFloatView zootopiaAudioCallFloatView3 = this$0.floatRootView;
        if (zootopiaAudioCallFloatView3 != null) {
            zootopiaAudioCallFloatView3.v(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L3(ZootopiaUEActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ZplanAVControllerForQAV.INSTANCE.c(this$0.n3());
        QLog.d("ZootopiaUEActivity", 1, "btn_audio_call_backto");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void M3(String peerUin, String peerNickName, boolean isGroup, long roomId) {
        if (this.invitingNotificationView == null) {
            this.invitingNotificationView = new com.tencent.mobileqq.zootopia.view.l(this);
        }
        com.tencent.mobileqq.zootopia.view.l lVar = this.invitingNotificationView;
        if (lVar != null) {
            lVar.k(peerUin, peerNickName, isGroup, roomId);
        }
    }

    private final void Q3() {
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        boolean z16 = false;
        if (zootopiaEnterParams != null && !zootopiaEnterParams.getNeedMinorsHeartBeat()) {
            z16 = true;
        }
        if (z16) {
            ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
            Integer valueOf = zootopiaEnterParams2 != null ? Integer.valueOf(zootopiaEnterParams2.getMapId()) : null;
            ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
            QLog.i("ZootopiaUEActivity", 1, "stopMinorsHeartBeat: mapId=" + valueOf + ", params.needMinorsHeartBeat=" + (zootopiaEnterParams3 != null ? Boolean.valueOf(zootopiaEnterParams3.getNeedMinorsHeartBeat()) : null));
            return;
        }
        kc3.b bVar = this.minorsHandler;
        if (bVar != null) {
            bVar.b();
        }
    }

    private final void R3() {
        if (this.isReceiverRegister.compareAndSet(true, false)) {
            this.accountChangeReceiver.c(this);
        }
    }

    private final void S3() {
        BroadcastReceiver broadcastReceiver = this.rewardReceiver;
        if (broadcastReceiver != null) {
            try {
                unregisterReceiver(broadcastReceiver);
            } catch (Exception e16) {
                QLog.e("ZootopiaUEActivity", 1, "unRegisterRewardReceiver", e16);
            }
        }
        this.rewardReceiver = null;
    }

    private final void T3(String newUrl) {
        if (TextUtils.isEmpty(newUrl)) {
            return;
        }
        QLog.i("ZootopiaUEActivity", 1, "updateNewGuideUrl " + newUrl);
        if (newUrl == null) {
            newUrl = "";
        }
        this.newGuideUrl = newUrl;
        ZPlanModH5MediaStatusManager h5MediaStatusManager = this.viewManager.getH5MediaStatusManager();
        String str = this.newGuideUrl;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        h5MediaStatusManager.f(str, zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0);
    }

    private final void d3() {
        boolean enableXiaoWoUseNormalFont = ZPlanQQMC.INSTANCE.enableXiaoWoUseNormalFont();
        QLog.i("ZootopiaUEActivity", 1, "justFontConfig useNormalFont=" + enableXiaoWoUseNormalFont);
        if (!enableXiaoWoUseNormalFont || Build.VERSION.SDK_INT < 24) {
            return;
        }
        GlobalDisplayMetricsManager.adjustDisplayMetrics(this);
        FontSettingManager.resetFontIfNeeded(this, true, false);
    }

    private final boolean e3() {
        ZPlanUELoadingController zPlanUELoadingController = this.uELoadingController;
        if (zPlanUELoadingController != null) {
            return zPlanUELoadingController.g();
        }
        return false;
    }

    private final void f3() {
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "doDestroy, didDestroy:" + this.didDestroy);
        if (this.didDestroy) {
            return;
        }
        this.didDestroy = true;
        com.tencent.zplan.engine.service.c.INSTANCE.b(this);
        this.pluginManager.y();
        Q3();
        com.tencent.sqshow.zootopia.report.b bVar = this.reporter;
        if (bVar != null) {
            bVar.b();
        }
        ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).destroy(this.activityName, this.activityHash);
        ((yk3.d) k74.i.INSTANCE.a(yk3.d.class)).activityDestroy(true, this.activityName, this.activityHash);
        com.tencent.mobileqq.zootopia.view.l lVar = this.invitingNotificationView;
        if (lVar != null) {
            lVar.j();
        }
        this.viewManager.i();
        PollingManager.INSTANCE.a().g(TaskIdEnum.LIVE_STREAM_HEART_BEAT_TASK);
    }

    private final void g3() {
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        QLog.i("ZootopiaUEActivity", 1, "enableSwitchScreen sceneType:" + (zootopiaEnterParams != null ? Integer.valueOf(zootopiaEnterParams.getScreenType()) : null));
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        if (zootopiaEnterParams2 != null) {
            if (zootopiaEnterParams2.getScreenType() != 1 && zootopiaEnterParams2.getScreenType() != 0) {
                if (zootopiaEnterParams2.getScreenType() == 2) {
                    this.pluginManager.w(true);
                    return;
                }
                return;
            }
            this.pluginManager.w(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h3(ZootopiaUEActivity this$0) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i.Companion companion = k74.i.INSTANCE;
        ((com.tencent.mobileqq.zootopia.ipc.f) companion.a(com.tencent.mobileqq.zootopia.ipc.f.class)).setUEActivityStarting(false);
        ((yk3.d) companion.a(yk3.d.class)).activityFinish(true, this$0.activityName, this$0.activityHash);
        yk3.d dVar = (yk3.d) companion.a(yk3.d.class);
        ZootopiaEnterParams zootopiaEnterParams = this$0.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0;
        ZootopiaEnterParams zootopiaEnterParams2 = this$0.enterParams;
        if (zootopiaEnterParams2 == null || (str = zootopiaEnterParams2.getName()) == null) {
            str = "";
        }
        dVar.doExitUeMap(mapId, str);
    }

    private final void initObserver() {
        this.uiObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p3() {
        ZootopiaAudioCallFloatView zootopiaAudioCallFloatView = this.floatRootView;
        if (zootopiaAudioCallFloatView != null) {
            zootopiaAudioCallFloatView.l();
        }
    }

    private final void r3() {
        com.tencent.mobileqq.zootopia.ipc.f fVar = (com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class);
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        f.a.a(fVar, zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0, false, 2, null);
        ZPlanUELoadingController zPlanUELoadingController = this.uELoadingController;
        if (zPlanUELoadingController != null) {
            zPlanUELoadingController.u();
        }
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "showLoadingView");
        this.isFirstFrameReady = false;
    }

    private final boolean t3() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("100472", true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u3() {
        ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).setUEActivityStarting(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v3(ZootopiaUEActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        LiuHaiUtils.initLiuHaiProperty(this$0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w3(ZootopiaUEActivity this$0, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("ZootopiaUEActivity", 1, "SystemUiVisibilityChangeListener " + i3);
        this$0.H3();
    }

    private final void x3(int errorCode, String errorMsg, ZootopiaLoadingErrMod mod) {
        ud3.c cVar = this.uELoaderController;
        if (cVar != null) {
            cVar.X2(errorCode, errorMsg, mod, this.progressRecord);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y3() {
        ((com.tencent.mobileqq.zootopia.ipc.f) k74.i.INSTANCE.a(com.tencent.mobileqq.zootopia.ipc.f.class)).setUEActivityStarting(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z3(ZootopiaUEActivity this$0, CommonLoadingData loadingData) {
        ZPlanBaseSceneLoadingView loadingView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(loadingData, "$loadingData");
        if (this$0.useV2Loading) {
            return;
        }
        ZPlanUELoadingController zPlanUELoadingController = this$0.uELoadingController;
        if (zPlanUELoadingController != null && (loadingView = zPlanUELoadingController.getLoadingView()) != null) {
            loadingView.d(this$0.launchText, Float.valueOf(loadingData.getProgress()));
        }
        this$0.progressRecord.h(loadingData.getCurrentMode());
        this$0.progressRecord.p(loadingData.getTotalMode());
        this$0.progressRecord.o(loadingData.getProgress());
    }

    @Override // ud3.a
    public void A1(int errorCode, String errorMessage) {
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "onModCheckFailed, " + errorCode + ", " + errorMessage);
    }

    @Override // com.tencent.mobileqq.zootopia.lua.e
    /* renamed from: C, reason: from getter */
    public com.tencent.mobileqq.zootopia.helper.e getPermissionHelper() {
        return this.permissionHelper;
    }

    public final void J3(final int status) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.u
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaUEActivity.K3(ZootopiaUEActivity.this, status);
            }
        });
    }

    @Override // tx4.a
    public void Q0(final CommonLoadingData loadingData) {
        Intrinsics.checkNotNullParameter(loadingData, "loadingData");
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "onProgressChange:" + loadingData.getSceneId() + ", " + loadingData.getProgress() + ", " + loadingData.getTotalMode() + ", " + loadingData.getCurrentMode());
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null && loadingData.getSceneId() != zootopiaEnterParams.getMapId()) {
            QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "sceneId diff, ignore");
            return;
        }
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.o
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaUEActivity.z3(ZootopiaUEActivity.this, loadingData);
            }
        });
    }

    @Override // ud3.a
    public void W0(FirstFrameResult result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.isFirstFrameReady = true;
    }

    @Override // ud3.a
    public void a2(DressInfoIPCData maleAvatarCharacter, DressInfoIPCData femaleAvatarCharacter) {
        Intrinsics.checkNotNullParameter(maleAvatarCharacter, "maleAvatarCharacter");
        Intrinsics.checkNotNullParameter(femaleAvatarCharacter, "femaleAvatarCharacter");
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "onRequestAvatarCharacterSuccess");
    }

    @Override // i74.b
    public boolean a8() {
        boolean isFinishing = isFinishing();
        QLog.i("ZootopiaUEActivity", 1, "isPageFinishing : " + isFinishing + ", hash:" + hashCode() + ", this:" + this);
        return isFinishing;
    }

    @Override // com.tencent.mobileqq.zootopia.lua.b
    public void c1(String gameTeamParams) {
        Intrinsics.checkNotNullParameter(gameTeamParams, "gameTeamParams");
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams instanceof ZootopiaGameParams) {
            Intrinsics.checkNotNull(zootopiaEnterParams, "null cannot be cast to non-null type com.tencent.mobileqq.zootopia.data.ZootopiaGameParams");
            ((ZootopiaGameParams) zootopiaEnterParams).setGameTeamParams(gameTeamParams);
        }
    }

    @Override // com.tencent.zplan.world.activity.ZPlanActivity, android.app.Activity
    public void finish() {
        String str;
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + " finish");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.s
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaUEActivity.h3(ZootopiaUEActivity.this);
            }
        }, 16, null, true);
        ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).finish(this.activityName, this.activityHash);
        super.finish();
        f3();
        k kVar = k.f328365a;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        int mapId = zootopiaEnterParams != null ? zootopiaEnterParams.getMapId() : 0;
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        if (zootopiaEnterParams2 == null || (str = zootopiaEnterParams2.getName()) == null) {
            str = "";
        }
        kVar.e(mapId, str);
        ZPlanUEActivityHelper.INSTANCE.a().onDestroy();
        ud3.c cVar = this.uELoaderController;
        if (cVar != null) {
            cVar.onDestroy();
        }
        ZPlanUELoadingController zPlanUELoadingController = this.uELoadingController;
        if (zPlanUELoadingController != null) {
            zPlanUELoadingController.onDestroy();
        }
        com.tencent.mobileqq.zootopia.utils.n.INSTANCE.b("UEActivity", true, 7);
    }

    @Override // ud3.a
    public void j2(boolean success, JSONObject params, ZootopiaEnterParams enterParams) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(enterParams, "enterParams");
        QLog.i("ZootopiaUEActivity", 1, "onModEnterSceneResult " + success);
        CommonModCheckResult commonModCheckResult = enterParams.getCommonModCheckResult();
        T3(commonModCheckResult != null ? commonModCheckResult.getNewGuideUrl() : null);
    }

    /* renamed from: j3, reason: from getter */
    public final String getNewGuideUrl() {
        return this.newGuideUrl;
    }

    /* renamed from: l3, reason: from getter */
    public final ZootopiaSource getSource() {
        return this.source;
    }

    public final String n3() {
        String optString;
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        JSONObject jsonObject = zootopiaEnterParams != null ? zootopiaEnterParams.toJsonObject() : null;
        if (jsonObject == null) {
            return "";
        }
        if (!TextUtils.isEmpty(jsonObject.optString("VisitUin"))) {
            optString = jsonObject.optString("VisitUin", "");
            Intrinsics.checkNotNullExpressionValue(optString, "{\n                params\u2026itUin\", \"\")\n            }");
        } else {
            optString = jsonObject.optString("Uin", "");
            Intrinsics.checkNotNullExpressionValue(optString, "{\n                params\u2026(\"Uin\", \"\")\n            }");
        }
        return optString;
    }

    @Override // com.tencent.zplan.world.activity.ZPlanActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration newConfig) {
        Intrinsics.checkNotNullParameter(newConfig, "newConfig");
        super.onConfigurationChanged(newConfig);
        ZootopiaAudioCallFloatView zootopiaAudioCallFloatView = this.floatRootView;
        if (zootopiaAudioCallFloatView != null) {
            zootopiaAudioCallFloatView.n(newConfig.orientation);
        }
        com.tencent.mobileqq.zootopia.view.l lVar = this.invitingNotificationView;
        if (lVar != null) {
            lVar.g(newConfig.orientation);
        }
        this.viewManager.w(newConfig);
        QLog.d("ZootopiaUEActivity", 1, "onConfigurationChanged " + newConfig.orientation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.activity.ZPlanActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + " onDestroy");
        f3();
        super.onDestroy();
        R3();
        S3();
        G3(this.uiObserver);
        ZplanAVControllerForQAV.INSTANCE.h(false);
    }

    @Override // com.epicgames.ue4.GameActivityThunk.CMShowEngineInitFinishListener
    public void onEngineInitFinish(boolean success) {
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "onEngineInitFinish:" + success);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.activity.ZPlanActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent newIntent) {
        CommonModCheckResult commonModCheckResult;
        super.onNewIntent(newIntent);
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + " onNewIntent");
        String str = null;
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.n
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaUEActivity.y3();
            }
        }, 16, null, true);
        Serializable serializableExtra = newIntent != null ? newIntent.getSerializableExtra("enter_params") : null;
        ZootopiaEnterParams zootopiaEnterParams = serializableExtra instanceof ZootopiaEnterParams ? (ZootopiaEnterParams) serializableExtra : null;
        this.enterParams = zootopiaEnterParams;
        if (zootopiaEnterParams != null && (commonModCheckResult = zootopiaEnterParams.getCommonModCheckResult()) != null) {
            str = commonModCheckResult.getNewGuideUrl();
        }
        T3(str);
        g3();
        C3();
        ud3.c cVar = this.uELoaderController;
        if (cVar != null) {
            cVar.t8(this.enterParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.activity.ZPlanActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        this.pluginManager.x();
        UEBuglyInfoRecorder.f25109a.g();
        QLog.i("ZootopiaUEActivity", 1, "ZootopiaUEActivity :: removePlugin");
    }

    @Override // com.tencent.zplan.world.activity.ZPlanActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Intrinsics.checkNotNullParameter(grantResults, "grantResults");
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "requesrCode " + requestCode + ", permission: " + permissions + ", " + grantResults);
        }
        QQPermission o16 = ZplanAVControllerForQAV.INSTANCE.o();
        if (o16 != null) {
            o16.onRequestPermissionResult(requestCode, permissions, grantResults);
        }
        if (this.permissionHelper.b(requestCode, permissions, grantResults)) {
            QLog.i("qqBaseActivity", 1, "requesr failed " + permissions + ", " + grantResults);
            return;
        }
        if (grantResults.length == 0) {
            return;
        }
        List<Object> list = this.permissionCallerMap.get(requestCode);
        if (list != null && list.size() > 0) {
            for (Object obj : list) {
                if (obj != null) {
                    if (obj instanceof QQPermissionCallback) {
                        ArrayList arrayList = new ArrayList();
                        int length = grantResults.length;
                        for (int i3 = 0; i3 < length; i3++) {
                            if (grantResults[i3] != 0) {
                                arrayList.add(permissions[i3]);
                            }
                        }
                        if (arrayList.size() > 0) {
                            ((QQPermissionCallback) obj).deny(requestCode, permissions, grantResults);
                        } else {
                            ((QQPermissionCallback) obj).grant(requestCode, permissions, grantResults);
                        }
                    } else {
                        QQPermissionHelper.requestResult(obj, requestCode, permissions, grantResults);
                    }
                }
            }
        }
        if (list != null) {
            this.permissionCallerMap.remove(requestCode);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.activity.ZPlanActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.t
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaUEActivity.A3(ZootopiaUEActivity.this);
            }
        }, 16, null, true);
        com.tencent.zplan.engine.service.d dVar = com.tencent.zplan.engine.service.d.f385635c;
        dVar.d();
        dVar.e();
        this.pluginManager.u();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof ZPlanAppInterface) {
            ((ZPlanAppInterface) peekAppRuntime).y(null);
        } else {
            QLog.e("ZootopiaUEActivity", 1, "appRuntime is not ZPlanAppInterface(maybe null),can not call setLowerPriorityProcessList");
        }
        QLog.i("ZootopiaUEActivity", 1, "ZootopiaUEActivity :: registerPlugin");
        ud3.c cVar = this.uELoaderController;
        if (cVar != null) {
            cVar.onResume();
        }
        UEBuglyInfoRecorder.f25109a.h();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
        outState.putInt("currentProcessId", Process.myPid());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        ud3.c cVar = this.uELoaderController;
        if (cVar != null) {
            cVar.onStop();
        }
    }

    @Override // ud3.a
    public void p(String modConfigJson) {
        Intrinsics.checkNotNullParameter(modConfigJson, "modConfigJson");
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "onModCheckComplete, " + modConfigJson);
    }

    @Override // com.tencent.mobileqq.zootopia.lua.e
    public void requestPermissions(Object caller, int requestCode, String... permissions) {
        boolean z16;
        Intrinsics.checkNotNullParameter(caller, "caller");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        if (QLog.isColorLevel()) {
            QLog.d("qqBaseActivity", 2, "fight.requestPermissions-" + permissions);
        }
        ArrayList arrayList = new ArrayList();
        for (String str : permissions) {
            Intrinsics.checkNotNull(str);
            if (checkSelfPermission(str) != 0) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() > 0) {
            List<Object> list = this.permissionCallerMap.get(requestCode);
            if (list == null) {
                list = new ArrayList<>();
            }
            int size = list.size();
            int i3 = 0;
            while (true) {
                if (i3 >= size) {
                    z16 = false;
                    break;
                }
                Object obj = list.get(i3);
                if (obj != null && obj == caller) {
                    z16 = true;
                    break;
                }
                i3++;
            }
            if (!z16) {
                list.add(caller);
                this.permissionCallerMap.put(requestCode, list);
            }
            Object[] array = arrayList.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            requestPermissions((String[]) array, requestCode);
            return;
        }
        if (caller instanceof QQPermissionCallback) {
            ((QQPermissionCallback) caller).grant(requestCode, permissions, null);
        } else {
            QQPermissionHelper.doExecuteSuccess(caller, requestCode);
        }
    }

    /* renamed from: s3, reason: from getter */
    public final boolean getIsFirstFrameReady() {
        return this.isFirstFrameReady;
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
        QLog.i("ZootopiaUEActivity", 1, "setRequestedOrientation " + requestedOrientation, new StackPrinter("setRequestedOrientation"));
    }

    private final void H3() {
        QLog.i("ZootopiaUEActivity", 1, "restoreTransparentBars ");
        getWindow().getDecorView().setSystemUiVisibility(5894);
    }

    public final Map<String, Object> i3() {
        Object obj;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[2];
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        if (zootopiaEnterParams != null) {
            obj = Integer.valueOf(zootopiaEnterParams.getMapId());
        } else {
            obj = "";
        }
        pairArr[0] = TuplesKt.to("zplan_map_id", obj);
        pairArr[1] = TuplesKt.to(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ag.f373258a.d(this.source));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        return mutableMapOf;
    }

    private final void G3(sc3.b observer) {
        if (observer != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
                ((ZPlanAppInterface) appInterface).deleteObserver(observer);
            }
        }
    }

    private final void c3(sc3.b observer) {
        if (observer != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
            if (appInterface != null && (appInterface instanceof ZPlanAppInterface)) {
                ((ZPlanAppInterface) appInterface).addObserver(observer);
            }
        }
    }

    @Override // com.tencent.mobileqq.zootopia.lua.d
    public void o(int errorCode, String errorMsg) {
        if (errorMsg == null) {
            errorMsg = "engineError";
        }
        x3(errorCode, errorMsg, ZootopiaLoadingErrMod.ENGINE);
    }

    public ZootopiaUEActivity() {
        super(false, 1, null);
        this.newGuideUrl = "";
        this.permissionHelper = new com.tencent.mobileqq.zootopia.helper.e();
        this.source = ZootopiaSource.INSTANCE.i();
        UEActivityViewManager uEActivityViewManager = new UEActivityViewManager(this);
        this.viewManager = uEActivityViewManager;
        this.pluginManager = new UEActivityPluginManager(this, uEActivityViewManager);
        this.progressRecord = new l();
        this.permissionCallerMap = new SparseArray<>();
        this.isReceiverRegister = new AtomicBoolean(false);
        this.accountChangeReceiver = new AccountChangeReceiver();
        this.liveSteamPushManager = new al3.a();
        this.activityName = "";
    }

    public final void P3(ZootopiaEnterParams params) {
        QLog.i("ZootopiaUEActivity", 1, "startMinorsHeartBeat: mapId=" + (params != null ? Integer.valueOf(params.getMapId()) : null) + ", params.needMinorsHeartBeat=" + (params != null ? Boolean.valueOf(params.getNeedMinorsHeartBeat()) : null));
        if ((params == null || params.getNeedMinorsHeartBeat()) ? false : true) {
            return;
        }
        if (params != null && this.minorsHandler == null) {
            this.minorsHandler = new kc3.b(new GameJudgeParams(params.getMapId(), params.getOpenId(), params.getAccessToken(), new d(), new c(), ZootopiaSource.INSTANCE.j(this.source), this));
        }
        kc3.b bVar = this.minorsHandler;
        if (bVar != null) {
            bVar.c();
        }
        this.liveSteamPushManager.b();
    }

    @Override // com.tencent.zplan.world.activity.ZPlanActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == 4) {
            if (e3()) {
                ZPlanUELoadingController zPlanUELoadingController = this.uELoadingController;
                if (zPlanUELoadingController == null) {
                    return true;
                }
                zPlanUELoadingController.s();
                return true;
            }
            UE4.inputEvent(event);
            GameActivity Get = GameActivity.Get();
            if (Get == null) {
                return true;
            }
            Get.onKeyDown(keyCode, event);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.zplan.world.activity.ZPlanActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        ud3.c zPlanUELoaderController;
        String str;
        int i3;
        ZootopiaMapLoadingParams loadingParams;
        int i16;
        ba.f335809a.a(this, "ZootopiaUEActivity");
        ZootopiaEnterParams B3 = B3();
        this.enterParams = B3;
        if (B3 != null) {
            if (B3.isGameType()) {
                i16 = B3.isSmallHome() ? 4 : 3;
            } else {
                i16 = 2;
            }
            this.reporter = com.tencent.sqshow.zootopia.report.b.INSTANCE.a(i16, B3.getMapId());
            this.progressRecord.j(B3.getLoadingId());
            CommonModCheckResult commonModCheckResult = B3.getCommonModCheckResult();
            T3(commonModCheckResult != null ? commonModCheckResult.getNewGuideUrl() : null);
        }
        String I3 = I3();
        ZootopiaEnterParams zootopiaEnterParams = this.enterParams;
        QLog.i("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3 + "onCreate, enterParams: " + (zootopiaEnterParams != null ? zootopiaEnterParams.getLoadingParams() : null));
        com.tencent.sqshow.zootopia.report.b bVar = this.reporter;
        if (bVar != null) {
            bVar.a(getIntent());
        }
        super.onCreate(savedInstanceState);
        ZootopiaEnterParams zootopiaEnterParams2 = this.enterParams;
        this.useV2Loading = (zootopiaEnterParams2 == null || (loadingParams = zootopiaEnterParams2.getLoadingParams()) == null) ? false : loadingParams.getIsUseNewLoading();
        this.activityName = xk3.b.f448110a.b(this);
        this.activityHash = hashCode();
        ((IUEActivityLifeCycle) QRoute.api(IUEActivityLifeCycle.class)).create(this.activityName, this.activityHash, this);
        i.Companion companion = k74.i.INSTANCE;
        ((yk3.d) companion.a(yk3.d.class)).activityCreate(true, this.activityName, this.activityHash, "zplan");
        if (savedInstanceState != null && (i3 = savedInstanceState.getInt("currentProcessId", 0)) != 0 && i3 != Process.myPid()) {
            QLog.e("ZootopiaUEActivity", 1, "[ZSceneLoading]" + I3() + "onCreate, process not equal");
        }
        com.tencent.sqshow.zootopia.report.b bVar2 = this.reporter;
        if (bVar2 != null) {
            bVar2.c();
        }
        D3();
        E3();
        Serializable serializableExtra = getIntent().getSerializableExtra("key_source");
        ZootopiaSource zootopiaSource = serializableExtra instanceof ZootopiaSource ? (ZootopiaSource) serializableExtra : null;
        if (zootopiaSource == null) {
            zootopiaSource = ZootopiaSource.INSTANCE.i();
        }
        this.source = zootopiaSource;
        g3();
        ZPlanUEActivityHelper.INSTANCE.a().k(this);
        ZPlanUELoadingController zPlanUELoadingController = new ZPlanUELoadingController(this, this.useV2Loading, this.enterParams, this.source);
        this.uELoadingController = zPlanUELoadingController;
        FrameLayout frameLayout = getCom.tencent.ams.mosaic.MosaicConstants$JsProperty.PROP_ROOT_VIEW java.lang.String();
        Window window = getWindow();
        Intrinsics.checkNotNullExpressionValue(window, "window");
        zPlanUELoadingController.x(frameLayout, window);
        r3();
        this.viewManager.s();
        initObserver();
        c3(this.uiObserver);
        if (t3()) {
            zPlanUELoaderController = new ZPlanUELoaderControllerV2(this, this.enterParams, this.uELoadingController, this.source, this.useV2Loading, this.reporter, this.progressRecord, this, this.pluginManager);
        } else {
            zPlanUELoaderController = new ZPlanUELoaderController(this, this.enterParams, this.uELoadingController, this.source, this.useV2Loading, this.reporter, this.progressRecord, this, this.pluginManager);
        }
        this.uELoaderController = zPlanUELoaderController;
        com.tencent.zplan.engine.service.d.f385635c.j();
        com.tencent.zplan.engine.service.c.INSTANCE.a(this);
        ud3.c cVar = this.uELoaderController;
        if (cVar != null) {
            ZootopiaEnterParams zootopiaEnterParams3 = this.enterParams;
            if (zootopiaEnterParams3 == null || (str = zootopiaEnterParams3.getSource()) == null) {
                str = "0";
            }
            cVar.Y8(str, false);
        }
        ((com.tencent.mobileqq.zootopia.ipc.ag) companion.a(com.tencent.mobileqq.zootopia.ipc.ag.class)).initForQzone();
        this.liveSteamPushManager.a();
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.zootopia.p
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaUEActivity.u3();
            }
        }, 16, null, true);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.zootopia.q
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaUEActivity.v3(ZootopiaUEActivity.this);
            }
        });
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(new View.OnSystemUiVisibilityChangeListener() { // from class: com.tencent.mobileqq.zootopia.r
            @Override // android.view.View.OnSystemUiVisibilityChangeListener
            public final void onSystemUiVisibilityChange(int i17) {
                ZootopiaUEActivity.w3(ZootopiaUEActivity.this, i17);
            }
        });
        H3();
        QLog.i("ZootopiaUEActivity", 1, "onCreate end");
        d3();
    }

    @Override // com.tencent.mobileqq.zootopia.lua.e
    public Activity x1() {
        return this;
    }
}
