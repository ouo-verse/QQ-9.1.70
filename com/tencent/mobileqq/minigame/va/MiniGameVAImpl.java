package com.tencent.mobileqq.minigame.va;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.gamecenter.wadl.api.IQQGameDualDownloadService;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamecenter.wadl.biz.entity.WadlResult;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.minigame.api.IMiniGameVAManager;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.utils.MiniGameDownloadUtil;
import com.tencent.mobileqq.minigame.va.IMiniGameVA;
import com.tencent.mobileqq.minigame.va.download.MetaDreamDownloadRequest;
import com.tencent.mobileqq.minigame.va.download.MiniGameVADownload;
import com.tencent.mobileqq.minigame.va.download.MiniGameVARequest;
import com.tencent.mobileqq.minigame.va.downloadui.MiniGameVAStartData;
import com.tencent.mobileqq.minigame.va.downloadui.VAInstallAppLoadingFragment;
import com.tencent.mobileqq.minigame.va.util.DiffPatchHandler;
import com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager;
import com.tencent.mobileqq.minigame.va.util.DiffPatchUtil;
import com.tencent.mobileqq.minigame.va.util.MiniGameVAUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.IMiniBoxLauncher;
import com.tencent.qq.minibox.api.IMiniBoxService;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.VirtualAppProxy;
import com.vivo.push.PushClientConstants;
import fs3.MiniBoxInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import nl0.d;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00ba\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 s2\u00020\u00012\u00020\u0002:\u0001sB\u0007\u00a2\u0006\u0004\bq\u0010rJh\u0010\u0013\u001a\u00020\u00102\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\u00072B\u0010\u0012\u001a>\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u000e`\u0011H\u0002Jn\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032B\u0010\u0012\u001a>\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u000e`\u0011H\u0002JR\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2@\u0010\u0012\u001a<\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0019H\u0002J`\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00032F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0014\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u0014\u0018\u0001`\u0011H\u0002J \u0010\u001f\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0002J\u0018\u0010 \u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020!H\u0002J(\u0010(\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\n2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0002J\u0018\u0010+\u001a\u00020\u00072\u0006\u0010)\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007H\u0002J\u0018\u0010.\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0002JX\u00100\u001a\u00020\u00102N\u0010\u0012\u001aJ\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010/\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0/`\u0011H\u0002J \u00102\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\n2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010/H\u0002J \u00104\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u00103\u001a\u00020!H\u0002J\u0010\u00105\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u001a\u00107\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u00106\u001a\u00020\nH\u0002J\u0006\u00108\u001a\u00020\u0010J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020%09J\b\u0010;\u001a\u00020\u0010H\u0016JX\u0010<\u001a\u00020\u00102N\u0010\u0012\u001aJ\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010/\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0/`\u0011H\u0016JX\u0010=\u001a\u00020\u00102N\u0010\u0012\u001aJ\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010/\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0/`\u0011H\u0016JT\u0010?\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00032B\u0010\u0012\u001a>\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\b\u0012\u0004\u0012\u00020\u000e`\u0011H\u0016JX\u0010@\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00032F\u0010\u0012\u001aB\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u000e\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u0011H\u0016J\n\u0010A\u001a\u0004\u0018\u00010\u000eH\u0016Jb\u0010C\u001a\u00020\u00102\u0006\u0010>\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u00032@\u0010\u0012\u001a<\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u0019H\u0016JZ\u0010D\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2@\u0010\u0012\u001a<\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u0010\u0018\u00010\tj\u0004\u0018\u0001`\u00192\u0006\u00106\u001a\u00020\nH\u0016J\u0010\u0010E\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u001a\u0010G\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010F\u001a\u0004\u0018\u00010\u0003H\u0016J;\u0010\u001f\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010H\u001a\u0004\u0018\u00010\n2\b\u0010I\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\u001f\u0010JJ\u0010\u0010K\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010L\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0018\u0010O\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010N\u001a\u00020MH\u0016J\u0018\u0010P\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010N\u001a\u00020MH\u0016J\b\u0010Q\u001a\u00020\u0007H\u0016J\u0012\u0010R\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J$\u0010V\u001a\u00020\u00102\u001a\u0010U\u001a\u0016\u0012\u0004\u0012\u00020!\u0018\u00010Sj\n\u0012\u0004\u0012\u00020!\u0018\u0001`TH\u0016J\u0006\u0010X\u001a\u00020WR\u0018\u0010Z\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010\\\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\\\u0010]R\u001c\u0010_\u001a\b\u0012\u0004\u0012\u00020\u000e0^8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b_\u0010`R\"\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000e0a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bb\u0010cR0\u0010e\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020M0Sj\b\u0012\u0004\u0012\u00020M`T0d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\be\u0010fRb\u0010h\u001aP\u0012L\u0012J\u0012\u0013\u0012\u00110\n\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u001b\u0012\u0019\u0012\u0004\u0012\u00020\u000e\u0018\u00010/\u00a2\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\tj\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0/`\u00110g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bh\u0010iR\u0014\u0010k\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bk\u0010lR\u0014\u0010m\u001a\u00020j8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bm\u0010lR\u001c\u0010n\u001a\b\u0012\u0004\u0012\u00020%098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bn\u0010oR\"\u0010p\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020%0a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bp\u0010c\u00a8\u0006t"}, d2 = {"Lcom/tencent/mobileqq/minigame/va/MiniGameVAImpl;", "Lcom/tencent/mobileqq/minigame/va/IMiniGameVA;", "Lnl0/d;", "", VirtualAppProxy.KEY_GAME_ID, "Lcom/tencent/mobileqq/minigame/config/MiniGameVAInterceptConfig$VAInterceptConfig;", DownloadInfo.spKey_Config, "", "miniVersionCode", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadDataWrapper;", "data", "", "Lcom/tencent/mobileqq/minigame/va/MiniGameRequestCallback;", "callback", "queryVAInner", "Lcom/tencent/mobileqq/minigame/va/MiniGameDownloadData;", "downloadData", "findData", "handleQueryVAInfo", "errMsg", "Lcom/tencent/mobileqq/minigame/va/MiniGameGeneralCallback;", "installInner", PushClientConstants.TAG_PKG_NAME, "requestDownloadInfo", "scene", "autoResume", "startDownload", "notifyStatusListener", "Lcom/tencent/gamecenter/wadl/biz/entity/WadlResult;", "wadlResult", "updateStartDownloadTs", "isDiff", "", "downloadEndTs", "diffEndTs", "reportDownloadCost", "taskStatus", "defaultStatus", "matchDownloadStatus", "progress", "status", "matchDownloadProgress", "", "addQueryCallback", "list", "notifyQueryCallback", "downloadResult", "onApkDownloadComplete", "findAppIdFromGameId", "needCheckDiff", "onApkFileReady", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/MutableLiveData;", "getSpaceLiveData", "preloadVADownload", "queryExistDownloadList", "queryExistVAList", "appId", "queryVAInfo", "queryCanUpdateVA", "getLastUpdateVA", "versionCode", "restartAndInstallVA", "installVA", "uninstallVA", "uriData", "launchVA", "needInstall", "onlyWifi", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;IZ)V", "pauseDownload", "cancelDownload", "Lcom/tencent/mobileqq/minigame/va/StatusListener;", "listener", "registerStatusListener", "unregisterStatusListener", "getBusinessId", "onWadlStatusChanged", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "wadlResults", "onQueryCallback", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVADownload;", "getDownloadService", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVARequest;", "gameRequest", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVARequest;", "gameDownloadService", "Lcom/tencent/mobileqq/minigame/va/download/MiniGameVADownload;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "installedList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Ljava/util/concurrent/ConcurrentHashMap;", "downloadingMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "statusListener", "Ljava/util/Map;", "", "queryCallbackList", "Ljava/util/List;", "Ljava/util/concurrent/locks/ReentrantLock;", "queryLock", "Ljava/util/concurrent/locks/ReentrantLock;", "statusLock", "spaceLiveData", "Landroidx/lifecycle/MutableLiveData;", "startDownloadTsMap", "<init>", "()V", "Companion", "qqmini_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class MiniGameVAImpl implements IMiniGameVA, d {
    private static final String TAG = "MiniGameVAImpl";
    private volatile MiniGameVADownload gameDownloadService;
    private MiniGameVARequest gameRequest;
    private CopyOnWriteArrayList<MiniGameDownloadDataWrapper> installedList = new CopyOnWriteArrayList<>();
    private ConcurrentHashMap<String, MiniGameDownloadDataWrapper> downloadingMap = new ConcurrentHashMap<>();
    private final Map<String, ArrayList<StatusListener>> statusListener = new LinkedHashMap();
    private final List<Function2<Boolean, List<MiniGameDownloadDataWrapper>, Unit>> queryCallbackList = new ArrayList();
    private final ReentrantLock queryLock = new ReentrantLock();
    private final ReentrantLock statusLock = new ReentrantLock();
    private MutableLiveData<Long> spaceLiveData = new MutableLiveData<>();
    private ConcurrentHashMap<String, Long> startDownloadTsMap = new ConcurrentHashMap<>();

    /* JADX INFO: Access modifiers changed from: private */
    public final void addQueryCallback(Function2<? super Boolean, ? super List<MiniGameDownloadDataWrapper>, Unit> callback) {
        ReentrantLock reentrantLock = this.queryLock;
        reentrantLock.lock();
        try {
            this.queryCallbackList.add(callback);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String findAppIdFromGameId(String gameId) {
        Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap;
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null && (interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap()) != null) {
            for (Map.Entry<String, MiniGameVAInterceptConfig.VAInterceptConfig> entry : interceptConfigMap.entrySet()) {
                if (Intrinsics.areEqual(entry.getValue().getGameAppId(), gameId)) {
                    return entry.getKey();
                }
            }
            return "";
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleQueryVAInfo(MiniGameDownloadData downloadData, MiniGameDownloadDataWrapper findData, int miniVersionCode, String gameId, Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback) {
        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = new MiniGameDownloadDataWrapper();
        miniGameDownloadDataWrapper.setData(downloadData);
        miniGameDownloadDataWrapper.setDownloadStatus(0);
        if (findData != null && findData.getDownloadStatus() != 7) {
            MiniGameDownloadUtil miniGameDownloadUtil = MiniGameDownloadUtil.INSTANCE;
            if (miniGameDownloadUtil.compareVersionCode(findData.getData().getVersionCode(), miniVersionCode) >= 0) {
                if (miniGameDownloadUtil.compareVersionCode(miniGameDownloadDataWrapper.getData().getVersionCode(), findData.getData().getVersionCode()) > 0) {
                    miniGameDownloadDataWrapper.setDownloadStatus(11);
                    this.downloadingMap.put(gameId, miniGameDownloadDataWrapper);
                }
                if (TextUtils.isEmpty(findData.getData().getDownloadUrl())) {
                    findData.getData().setDownloadUrl(downloadData.getDownloadUrl());
                }
                QLog.i(TAG, 1, "handleQueryVAInfo  newData:" + miniGameDownloadDataWrapper + ", findData:" + findData);
                callback.invoke(Boolean.TRUE, findData);
                return;
            }
        }
        if (MiniGameDownloadUtil.INSTANCE.compareVersionCode(miniGameDownloadDataWrapper.getData().getVersionCode(), miniVersionCode) >= 0) {
            QLog.i(TAG, 1, "handleQueryVAInfo  return newData:" + miniGameDownloadDataWrapper);
            this.downloadingMap.put(gameId, miniGameDownloadDataWrapper);
            callback.invoke(Boolean.TRUE, miniGameDownloadDataWrapper);
            return;
        }
        QLog.e(TAG, 1, "queryVAInfo find not satisfy miniVersionCode:" + miniVersionCode + " newData:" + miniGameDownloadDataWrapper + ", findData:" + findData);
        callback.invoke(Boolean.FALSE, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void installInner(final MiniGameDownloadDataWrapper data, final Function2<? super Boolean, ? super String, Unit> callback) {
        String str;
        Map mutableMapOf;
        String str2 = "1";
        if (com.tencent.mobileqq.qmethodmonitor.a.a(BaseApplication.getContext())) {
            str = "1";
        } else {
            str = "2";
        }
        if (!((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).isApkDownloadInnerStorageEnable()) {
            str2 = "0";
        }
        final String str3 = str2;
        String gameId = data.getData().getGameId();
        Pair[] pairArr = new Pair[5];
        pairArr[0] = TuplesKt.to("ext2", String.valueOf(data.getData().getSize()));
        pairArr[1] = TuplesKt.to("ext8", String.valueOf(data.getScene()));
        pairArr[2] = TuplesKt.to("ext9", str);
        pairArr[3] = TuplesKt.to("ext45", str3);
        String dexVersion = MiniBoxSDK.getDexVersion(BaseApplication.getContext());
        if (dexVersion == null) {
            dexVersion = "";
        }
        pairArr[4] = TuplesKt.to("ex13", dexVersion);
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989684", "18", gameId, mutableMapOf);
        final long currentTimeMillis = System.currentTimeMillis();
        IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
        String apkPath = data.getData().getApkPath();
        Intrinsics.checkNotNull(apkPath);
        iMiniBoxLauncher.installVirtualApp(apkPath, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$installInner$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str4) {
                invoke(bool.booleanValue(), num.intValue(), str4);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, String str4) {
                int matchDownloadProgress;
                Map mutableMapOf2;
                String str5 = str4;
                QLog.i("MiniGameVAImpl", 1, "installVA isSuccess:" + z16 + ", errCode:" + i3 + " errMsg:" + str5);
                MiniGameDownloadDataWrapper.this.setDownloadStatus(z16 ? 9 : 5);
                MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = MiniGameDownloadDataWrapper.this;
                matchDownloadProgress = this.matchDownloadProgress(100, 9);
                miniGameDownloadDataWrapper.setProgress(matchDownloadProgress);
                this.notifyStatusListener(MiniGameDownloadDataWrapper.this.getData().getGameId(), MiniGameDownloadDataWrapper.this);
                ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).calculateMiniGameSpaceOccupy();
                Function2<Boolean, String, Unit> function2 = callback;
                if (function2 != null) {
                    function2.invoke(Boolean.valueOf(z16), i3 + ", " + str5);
                }
                if (z16) {
                    QLog.i("MiniGameVAImpl", 1, "installVA success and start delete");
                    this.getDownloadService().deleteDownload(MiniGameDownloadDataWrapper.this.getData());
                    MiniGameDownloadUtil.INSTANCE.saveUpdateApkData(null);
                }
                String str6 = com.tencent.mobileqq.qmethodmonitor.a.a(BaseApplication.getContext()) ? "1" : "2";
                String gameId2 = MiniGameDownloadDataWrapper.this.getData().getGameId();
                Pair[] pairArr2 = new Pair[9];
                pairArr2[0] = TuplesKt.to("ext6", String.valueOf(i3));
                pairArr2[1] = TuplesKt.to("ext7", z16 ? "1" : "2");
                pairArr2[2] = TuplesKt.to("ext2", String.valueOf(MiniGameDownloadDataWrapper.this.getData().getSize()));
                pairArr2[3] = TuplesKt.to("ext46", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                pairArr2[4] = TuplesKt.to("ext8", String.valueOf(MiniGameDownloadDataWrapper.this.getScene()));
                pairArr2[5] = TuplesKt.to("ext45", str3);
                if (str5 == null) {
                    str5 = "";
                }
                pairArr2[6] = TuplesKt.to("ext9", str5);
                String dexVersion2 = MiniBoxSDK.getDexVersion(BaseApplication.getContext());
                pairArr2[7] = TuplesKt.to("ex13", dexVersion2 != null ? dexVersion2 : "");
                pairArr2[8] = TuplesKt.to("ext23", str6);
                mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(pairArr2);
                MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989337", "18", gameId2, mutableMapOf2);
            }
        });
    }

    private final int matchDownloadStatus(int taskStatus, int defaultStatus) {
        int i3 = 2;
        if (taskStatus != 2) {
            if (taskStatus != 12) {
                int i16 = 4;
                if (taskStatus != 4) {
                    i3 = 5;
                    if (taskStatus != 5) {
                        i16 = 6;
                        if (taskStatus != 6) {
                            if (taskStatus != 7) {
                                return defaultStatus;
                            }
                        }
                    }
                    return i16;
                }
                return i3;
            }
            return 10;
        }
        return 1;
    }

    private final void notifyQueryCallback(boolean isSuccess, List<MiniGameDownloadDataWrapper> list) {
        ReentrantLock reentrantLock = this.queryLock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.queryCallbackList.iterator();
            while (it.hasNext()) {
                ((Function2) it.next()).invoke(Boolean.valueOf(isSuccess), list);
            }
            this.queryCallbackList.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:6:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void notifyStatusListener(String gameId, MiniGameDownloadDataWrapper data) {
        boolean z16;
        if (data.getDownloadStatus() == 9) {
            this.downloadingMap.remove(gameId);
            this.installedList.add(data);
        } else {
            if (data.getDownloadStatus() == 10) {
                int i3 = 0;
                z16 = data.getData().getDiffPatchInfo() == null || !data.getNotNotifyWhenDelete();
                this.downloadingMap.remove(gameId);
                Iterator<MiniGameDownloadDataWrapper> it = this.installedList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    } else if (Intrinsics.areEqual(it.next().getData().getGameId(), gameId)) {
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i3 >= 0) {
                    this.installedList.remove(i3);
                }
                if (z16) {
                    QLog.i(TAG, 1, "notifyStatusListener needNotify:false data:" + data);
                    return;
                }
                ReentrantLock reentrantLock = this.statusLock;
                reentrantLock.lock();
                try {
                    ArrayList<StatusListener> arrayList = this.statusListener.get(gameId);
                    ArrayList arrayList2 = arrayList != null ? new ArrayList(arrayList) : null;
                    if (arrayList2 != null) {
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            ((StatusListener) it5.next()).onStatusChanged(data);
                        }
                        Unit unit = Unit.INSTANCE;
                    }
                    return;
                } finally {
                    reentrantLock.unlock();
                }
            }
            this.downloadingMap.put(gameId, data);
        }
        z16 = true;
        if (z16) {
        }
    }

    private final void onApkDownloadComplete(final String gameId, final MiniGameDownloadDataWrapper data, WadlResult downloadResult) {
        data.getData().setApkPath(downloadResult.downloadFilePath);
        final long currentTimeMillis = System.currentTimeMillis();
        MiniGameDiffPatchInfo json2DiffPatchInfo = DiffPatchUtil.INSTANCE.json2DiffPatchInfo(downloadResult.wadlParams.extraData);
        if (json2DiffPatchInfo == null) {
            QLog.d(TAG, 2, "onWadlStatusChanged STATUS_DOWNLOADED, then install data:" + data);
            reportDownloadCost(gameId, false, currentTimeMillis, 0L);
            onApkFileReady(data, false);
            notifyStatusListener(gameId, data);
            return;
        }
        if (Intrinsics.areEqual(json2DiffPatchInfo, data.getData().getDiffPatchInfo())) {
            data.setDownloadStatus(2);
            notifyStatusListener(gameId, data);
            DiffPatchTaskManager.getTaskManager().startPatch(data.getData(), new DiffPatchTaskManager.DiffPatchCallback() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$onApkDownloadComplete$1
                @Override // com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager.DiffPatchCallback
                public void onFail(String errorMsg) {
                    String findAppIdFromGameId;
                    Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                    QLog.e("MiniGameVAImpl", 1, "diffPatch failed, error=" + errorMsg);
                    this.notifyStatusListener(gameId, MiniGameDownloadDataWrapper.this);
                    MiniGameDownloadDataWrapper.this.setNotNotifyWhenDelete(true);
                    this.getDownloadService().deleteDownload(MiniGameDownloadDataWrapper.this.getData());
                    MiniGameVAImpl miniGameVAImpl = this;
                    MiniGameDownloadData data2 = MiniGameDownloadDataWrapper.this.getData();
                    findAppIdFromGameId = this.findAppIdFromGameId(gameId);
                    DiffPatchHandler.handleDiffPatchFailed(miniGameVAImpl, data2, findAppIdFromGameId);
                }

                @Override // com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager.DiffPatchCallback
                public void onSuccess(String newApkPath) {
                    Intrinsics.checkNotNullParameter(newApkPath, "newApkPath");
                    MiniGameDownloadDataWrapper.this.setDownloadStatus(5);
                    MiniGameDownloadDataWrapper.this.getData().setApkPath(newApkPath);
                    this.notifyStatusListener(gameId, MiniGameDownloadDataWrapper.this);
                    this.reportDownloadCost(gameId, true, currentTimeMillis, System.currentTimeMillis());
                    this.onApkFileReady(MiniGameDownloadDataWrapper.this, false);
                }
            }, "1");
        } else {
            QLog.i(TAG, 1, "onApkDownloadComplete: diffPatch invalid, delete it.");
            data.setDownloadStatus(6);
            getDownloadService().deleteDownload(data.getData());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onApkFileReady(MiniGameDownloadDataWrapper data, boolean needCheckDiff) {
        Map mutableMapOf;
        String gameId = data.getData().getGameId();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ext7", "1"), TuplesKt.to("ext8", String.valueOf(data.getScene())), TuplesKt.to("ext2", String.valueOf(data.getData().getSize())));
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989339", "18", gameId, mutableMapOf);
        if (data.getIsAutoInstall()) {
            installVA(data, null, needCheckDiff);
        } else {
            MiniGameDownloadUtil.INSTANCE.saveUpdateApkData(data);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryExistDownloadList$lambda$0(MiniGameVAImpl this$0, Function2 callback) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.addQueryCallback(callback);
        this$0.getDownloadService().queryDownload();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryExistVAList$lambda$2(final MiniGameVAImpl this$0, final Function2 callback, final Map configMap) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(configMap, "$configMap");
        ((IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class)).getMiniBoxInstallList(new Function2<Boolean, List<? extends MiniBoxInfo>, Unit>() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$queryExistVAList$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends MiniBoxInfo> list) {
                invoke(bool.booleanValue(), (List<MiniBoxInfo>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, List<MiniBoxInfo> list) {
                CopyOnWriteArrayList copyOnWriteArrayList;
                CopyOnWriteArrayList copyOnWriteArrayList2;
                CopyOnWriteArrayList copyOnWriteArrayList3;
                ArrayList arrayList = new ArrayList();
                if (z16 && list != null) {
                    Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> map = configMap;
                    for (MiniBoxInfo miniBoxInfo : list) {
                        MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig = map.get(miniBoxInfo.getPkgName());
                        if (vAInterceptConfig != null) {
                            int gameAppMinVersionCode = vAInterceptConfig.getGameAppMinVersionCode();
                            MiniGameDownloadData miniGameDownloadData = new MiniGameDownloadData();
                            miniGameDownloadData.setGameId(vAInterceptConfig.getGameAppId());
                            String iconFilePath = miniBoxInfo.getIconFilePath();
                            if (iconFilePath == null) {
                                iconFilePath = "";
                            }
                            miniGameDownloadData.setGameIcon(iconFilePath);
                            String appName = miniBoxInfo.getAppName();
                            if (appName == null) {
                                appName = "";
                            }
                            miniGameDownloadData.setGameName(appName);
                            miniGameDownloadData.setPkgName(miniBoxInfo.getPkgName());
                            miniGameDownloadData.setVersionCode(String.valueOf(miniBoxInfo.getVersionCode()));
                            IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
                            String pkgName = miniBoxInfo.getPkgName();
                            miniGameDownloadData.setSize(iMiniBoxLauncher.getAppCacheSize(pkgName != null ? pkgName : ""));
                            MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = new MiniGameDownloadDataWrapper();
                            miniGameDownloadDataWrapper.setData(miniGameDownloadData);
                            miniGameDownloadDataWrapper.setDownloadStatus(MiniGameDownloadUtil.INSTANCE.compareVersionCode(miniGameDownloadData.getVersionCode(), gameAppMinVersionCode) >= 0 ? 9 : 7);
                            arrayList.add(miniGameDownloadDataWrapper);
                        }
                    }
                }
                copyOnWriteArrayList = MiniGameVAImpl.this.installedList;
                copyOnWriteArrayList.clear();
                copyOnWriteArrayList2 = MiniGameVAImpl.this.installedList;
                copyOnWriteArrayList2.addAll(arrayList);
                copyOnWriteArrayList3 = MiniGameVAImpl.this.installedList;
                QLog.i("MiniGameVAImpl", 1, "queryExistVAList getMiniBoxInstallList isSuccess:" + z16 + " installedList:" + copyOnWriteArrayList3 + ", then start queryDownload");
                MiniGameVAImpl.this.addQueryCallback(callback);
                MiniGameVAImpl.this.getDownloadService().queryDownload();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void queryVAInner(final String gameId, final MiniGameVAInterceptConfig.VAInterceptConfig config, final int miniVersionCode, final Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.a
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAImpl.queryVAInner$lambda$4(MiniGameVAImpl.this, config, gameId, callback, miniVersionCode);
            }
        }, 128, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void queryVAInner$lambda$4(final MiniGameVAImpl this$0, final MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig, final String str, final Function2 callback, final int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        this$0.queryExistVAList(new Function2<Boolean, List<? extends MiniGameDownloadDataWrapper>, Unit>() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$queryVAInner$1$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, List<? extends MiniGameDownloadDataWrapper> list) {
                invoke(bool.booleanValue(), (List<MiniGameDownloadDataWrapper>) list);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, List<MiniGameDownloadDataWrapper> list) {
                final MiniGameDownloadDataWrapper miniGameDownloadDataWrapper;
                Object obj;
                QLog.i("MiniGameVAImpl", 1, "queryExistVAList find gameId:" + str + ", isSuccess:" + z16 + " list:" + list);
                if (z16) {
                    if (list != null) {
                        String str2 = str;
                        Iterator<T> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                obj = null;
                                break;
                            } else {
                                obj = it.next();
                                if (Intrinsics.areEqual(((MiniGameDownloadDataWrapper) obj).getData().getGameId(), str2)) {
                                    break;
                                }
                            }
                        }
                        miniGameDownloadDataWrapper = (MiniGameDownloadDataWrapper) obj;
                    } else {
                        miniGameDownloadDataWrapper = null;
                    }
                    MiniGameVAImpl miniGameVAImpl = this$0;
                    String str3 = str;
                    Intrinsics.checkNotNull(str3);
                    MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig2 = vAInterceptConfig;
                    String gameAppPkgName = vAInterceptConfig2 != null ? vAInterceptConfig2.getGameAppPkgName() : null;
                    if (gameAppPkgName == null) {
                        gameAppPkgName = "";
                    }
                    final int i16 = i3;
                    final MiniGameVAImpl miniGameVAImpl2 = this$0;
                    final String str4 = str;
                    final Function2<Boolean, MiniGameDownloadDataWrapper, Unit> function2 = callback;
                    miniGameVAImpl.requestDownloadInfo(str3, gameAppPkgName, new Function2<Boolean, MiniGameDownloadData, Unit>() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$queryVAInner$1$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, MiniGameDownloadData miniGameDownloadData) {
                            invoke(bool.booleanValue(), miniGameDownloadData);
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z17, MiniGameDownloadData miniGameDownloadData) {
                            QLog.i("MiniGameVAImpl", 1, "queryVAInfo requestDownload isSuccess:" + z17 + ", data:" + miniGameDownloadData + " miniVersionCode:" + i16);
                            if (z17 && miniGameDownloadData != null) {
                                miniGameVAImpl2.handleQueryVAInfo(miniGameDownloadData, miniGameDownloadDataWrapper, i16, str4, function2);
                            } else {
                                function2.invoke(Boolean.FALSE, null);
                            }
                        }
                    });
                    return;
                }
                callback.invoke(Boolean.FALSE, null);
            }
        });
        if (vAInterceptConfig != null) {
            MiniGameDownloadUtil.INSTANCE.loadImage(vAInterceptConfig.getLoadingImage(), com.tencent.superplayer.utils.b.b(), com.tencent.superplayer.utils.b.a(), null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void requestDownloadInfo(String gameId, String pkgName, final Function2<? super Boolean, ? super MiniGameDownloadData, Unit> callback) {
        MiniGameVARequest miniGameVARequest;
        if (Intrinsics.areEqual("com.tencent.letsgo", pkgName)) {
            miniGameVARequest = new MetaDreamDownloadRequest();
        } else {
            miniGameVARequest = new MiniGameVARequest();
        }
        this.gameRequest = miniGameVARequest;
        Intrinsics.checkNotNull(miniGameVARequest);
        miniGameVARequest.setListener(new Function2<Boolean, MiniGameDownloadData, Unit>() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$requestDownloadInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, MiniGameDownloadData miniGameDownloadData) {
                invoke(bool.booleanValue(), miniGameDownloadData);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, MiniGameDownloadData miniGameDownloadData) {
                MiniGameVARequest miniGameVARequest2;
                miniGameVARequest2 = MiniGameVAImpl.this.gameRequest;
                if (miniGameVARequest2 != null) {
                    miniGameVARequest2.setListener(null);
                }
                Function2<Boolean, MiniGameDownloadData, Unit> function2 = callback;
                if (function2 != null) {
                    function2.invoke(Boolean.valueOf(z16), miniGameDownloadData);
                }
            }
        });
        MiniGameVARequest miniGameVARequest2 = this.gameRequest;
        Intrinsics.checkNotNull(miniGameVARequest2);
        miniGameVARequest2.requestGameDownload(gameId, pkgName);
    }

    private final void updateStartDownloadTs(WadlResult wadlResult) {
        int i3 = wadlResult.taskStatus;
        if (i3 == 2 && wadlResult.progress <= 1) {
            QLog.i(TAG, 1, "reportDownloadCost updateStartDownloadTs start");
            ConcurrentHashMap<String, Long> concurrentHashMap = this.startDownloadTsMap;
            String str = wadlResult.wadlParams.appId;
            Intrinsics.checkNotNullExpressionValue(str, "wadlResult.wadlParams.appId");
            concurrentHashMap.put(str, Long.valueOf(System.currentTimeMillis()));
            return;
        }
        if (i3 == 5 || (i3 == 2 && wadlResult.progress > 1)) {
            ConcurrentHashMap<String, Long> concurrentHashMap2 = this.startDownloadTsMap;
            String str2 = wadlResult.wadlParams.appId;
            Intrinsics.checkNotNullExpressionValue(str2, "wadlResult.wadlParams.appId");
            concurrentHashMap2.put(str2, 0L);
            QLog.i(TAG, 1, "reportDownloadCost updateStartDownloadTs reset");
        }
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void cancelDownload(String gameId) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.downloadingMap.get(gameId);
        QLog.i(TAG, 1, "cancelDownload gameId:" + gameId + ", data::" + miniGameDownloadDataWrapper);
        if (miniGameDownloadDataWrapper == null) {
            return;
        }
        getDownloadService().deleteDownload(miniGameDownloadDataWrapper.getData());
    }

    public int getBusinessId() {
        return 3;
    }

    public final MiniGameVADownload getDownloadService() {
        if (this.gameDownloadService != null) {
            MiniGameVADownload miniGameVADownload = this.gameDownloadService;
            Intrinsics.checkNotNull(miniGameVADownload);
            return miniGameVADownload;
        }
        synchronized (this) {
            if (this.gameDownloadService == null) {
                this.gameDownloadService = new MiniGameVADownload(getBusinessId(), this);
            }
            Unit unit = Unit.INSTANCE;
        }
        MiniGameVADownload miniGameVADownload2 = this.gameDownloadService;
        Intrinsics.checkNotNull(miniGameVADownload2);
        return miniGameVADownload2;
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public MiniGameDownloadDataWrapper getLastUpdateVA() {
        MiniGameDownloadDataWrapper updateApkData = MiniGameDownloadUtil.INSTANCE.getUpdateApkData();
        if (updateApkData == null || TextUtils.isEmpty(updateApkData.getData().getApkPath()) || !new File(updateApkData.getData().getApkPath()).exists()) {
            return null;
        }
        QLog.i(TAG, 1, "getLastUpdateVA exit:" + updateApkData);
        return updateApkData;
    }

    public final MutableLiveData<Long> getSpaceLiveData() {
        return this.spaceLiveData;
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void installVA(final MiniGameDownloadDataWrapper data, final Function2<? super Boolean, ? super String, Unit> callback, boolean needCheckDiff) {
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(TAG, 1, "installVA apkPath:" + data.getData().getApkPath());
        if (TextUtils.isEmpty(data.getData().getApkPath())) {
            QLog.e(TAG, 1, "installVA but apk is null");
            return;
        }
        File file = new File(data.getData().getApkPath());
        if (!file.exists()) {
            QLog.e(TAG, 1, "installVA but apk file not exists");
            return;
        }
        QLog.i(TAG, 1, "installVA needCheckDiff:" + needCheckDiff + " data:" + data);
        if (needCheckDiff) {
            IMiniGameVAUtilsApi iMiniGameVAUtilsApi = (IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class);
            String name = file.getName();
            Intrinsics.checkNotNullExpressionValue(name, "apkFile.name");
            if (iMiniGameVAUtilsApi.isDiffPatchApk(name)) {
                MiniGameDiffPatchInfo diffPatchInfo = data.getData().getDiffPatchInfo();
                boolean z16 = diffPatchInfo != null && file.length() == diffPatchInfo.getNewApkDataSize();
                QLog.i(TAG, 1, "installVA isPatched:" + z16 + " apkFile.length:" + file.length());
                if (!z16) {
                    MiniGameDiffPatchInfo diffPatchInfo2 = data.getData().getDiffPatchInfo();
                    if (diffPatchInfo2 != null && file.length() == diffPatchInfo2.getPatchSize()) {
                        MiniGameVAUtil.showDebugToast("\u5b89\u88c5\u672a\u5408\u5e76\u7684\u589e\u91cf\u5305\uff0c\u5148\u5408\u5e76\u518d\u5b89\u88c5");
                        DiffPatchTaskManager.getTaskManager().startPatch(data.getData(), new DiffPatchTaskManager.DiffPatchCallback() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$installVA$1
                            @Override // com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager.DiffPatchCallback
                            public void onFail(String errorMsg) {
                                Intrinsics.checkNotNullParameter(errorMsg, "errorMsg");
                                QLog.e("MiniGameVAImpl", 1, "installVA diffPatch failed, error=" + errorMsg);
                                Function2<Boolean, String, Unit> function2 = callback;
                                if (function2 != null) {
                                    function2.invoke(Boolean.FALSE, errorMsg);
                                }
                            }

                            @Override // com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager.DiffPatchCallback
                            public void onSuccess(String newApkPath) {
                                Intrinsics.checkNotNullParameter(newApkPath, "newApkPath");
                                QLog.i("MiniGameVAImpl", 1, "installVA diffPatch success");
                                MiniGameDownloadDataWrapper.this.setDownloadStatus(5);
                                MiniGameDownloadDataWrapper.this.getData().setApkPath(newApkPath);
                                this.installInner(MiniGameDownloadDataWrapper.this, callback);
                            }
                        }, "2");
                        return;
                    }
                }
            }
        }
        installInner(data, callback);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void launchVA(MiniGameDownloadDataWrapper data, String uriData) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(data, "data");
        QLog.i(TAG, 1, "launchVA data:" + data);
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null && !miniGameVAInterceptConfig.getInterceptConfigMap().isEmpty()) {
            Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap();
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(interceptConfigMap.size());
            LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            Iterator<T> it = interceptConfigMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(((MiniGameVAInterceptConfig.VAInterceptConfig) entry.getValue()).getGameAppPkgName(), entry.getValue());
            }
            MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig = (MiniGameVAInterceptConfig.VAInterceptConfig) linkedHashMap.get(data.getData().getPkgName());
            if (vAInterceptConfig == null) {
                QLog.e(TAG, 1, "launchVA: get config null, pkgName=" + data.getData().getPkgName());
                return;
            }
            MiniGameVAStartData miniGameVAStartData = new MiniGameVAStartData(vAInterceptConfig, data);
            miniGameVAStartData.setUriData(uriData);
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = BaseApplication.getContext();
            }
            Context context2 = context;
            VAInstallAppLoadingFragment.Companion companion = VAInstallAppLoadingFragment.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            VAInstallAppLoadingFragment.Companion.startVA$default(companion, context2, miniGameVAStartData, null, 4, null);
            return;
        }
        QLog.e(TAG, 1, "queryExistVAList config null");
    }

    public final void onDestroy() {
        this.downloadingMap.clear();
        this.statusListener.clear();
        this.queryCallbackList.clear();
        getDownloadService().destroyDownloadService(this);
    }

    @Override // nl0.d
    public void onQueryCallback(ArrayList<WadlResult> wadlResults) {
        ArrayList<MiniGameDownloadDataWrapper> arrayList = new ArrayList();
        if (wadlResults != null) {
            for (WadlResult wadlResult : wadlResults) {
                int matchDownloadStatus = matchDownloadStatus(wadlResult.taskStatus, 0);
                MiniGameDownloadData miniGameDownloadData = new MiniGameDownloadData();
                String str = wadlResult.wadlParams.appId;
                Intrinsics.checkNotNullExpressionValue(str, "wadl.wadlParams.appId");
                miniGameDownloadData.setGameId(str);
                String str2 = wadlResult.wadlParams.iconUrl;
                Intrinsics.checkNotNullExpressionValue(str2, "wadl.wadlParams.iconUrl");
                miniGameDownloadData.setGameIcon(str2);
                String str3 = wadlResult.wadlParams.appName;
                Intrinsics.checkNotNullExpressionValue(str3, "wadl.wadlParams.appName");
                miniGameDownloadData.setGameName(str3);
                miniGameDownloadData.setPkgName(wadlResult.wadlParams.packageName);
                miniGameDownloadData.setVersionCode(String.valueOf(wadlResult.wadlParams.versionCode));
                miniGameDownloadData.setDownloadUrl(wadlResult.wadlParams.apkUrl);
                miniGameDownloadData.setDownloadSize(wadlResult.downloadFileSize);
                miniGameDownloadData.setSize(wadlResult.fileSize);
                miniGameDownloadData.setApkPath(wadlResult.downloadFilePath);
                miniGameDownloadData.setDiffPatchInfo(DiffPatchUtil.INSTANCE.json2DiffPatchInfo(wadlResult.wadlParams.extraData));
                MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = new MiniGameDownloadDataWrapper();
                miniGameDownloadDataWrapper.setData(miniGameDownloadData);
                miniGameDownloadDataWrapper.setDownloadStatus(matchDownloadStatus);
                miniGameDownloadDataWrapper.setProgress(matchDownloadProgress(wadlResult.progress, matchDownloadStatus));
                arrayList.add(miniGameDownloadDataWrapper);
                QLog.i(TAG, 1, "onQueryCallback wadl:" + wadlResult + " ");
            }
        }
        for (MiniGameDownloadDataWrapper miniGameDownloadDataWrapper2 : arrayList) {
            MiniGameDownloadDataWrapper miniGameDownloadDataWrapper3 = this.downloadingMap.get(miniGameDownloadDataWrapper2.getData().getGameId());
            if (miniGameDownloadDataWrapper3 != null) {
                miniGameDownloadDataWrapper2.setAutoInstall(miniGameDownloadDataWrapper3.getIsAutoInstall());
                miniGameDownloadDataWrapper2.setErrorCode(miniGameDownloadDataWrapper3.getErrorCode());
                miniGameDownloadDataWrapper2.setOnlyOnWifi(miniGameDownloadDataWrapper3.getOnlyOnWifi());
                miniGameDownloadDataWrapper2.setScene(miniGameDownloadDataWrapper3.getScene());
                miniGameDownloadDataWrapper2.setNotNotifyWhenDelete(miniGameDownloadDataWrapper3.getNotNotifyWhenDelete());
            }
            this.downloadingMap.put(miniGameDownloadDataWrapper2.getData().getGameId(), miniGameDownloadDataWrapper2);
        }
        CopyOnWriteArrayList<MiniGameDownloadDataWrapper> copyOnWriteArrayList = this.installedList;
        Iterator<Map.Entry<String, MiniGameDownloadDataWrapper>> it = this.downloadingMap.entrySet().iterator();
        while (it.hasNext()) {
            copyOnWriteArrayList.add(it.next().getValue());
        }
        QLog.i(TAG, 1, "onQueryCallback wadlResults:" + (wadlResults != null ? Integer.valueOf(wadlResults.size()) : null) + " callback list:" + copyOnWriteArrayList + " ");
        notifyQueryCallback(true, copyOnWriteArrayList);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void pauseDownload(String gameId) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.downloadingMap.get(gameId);
        QLog.i(TAG, 1, "pauseDownload gameId:" + gameId + ", data::" + miniGameDownloadDataWrapper);
        if (miniGameDownloadDataWrapper == null) {
            return;
        }
        getDownloadService().pauseDownload(miniGameDownloadDataWrapper.getData());
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void preloadVADownload() {
        getDownloadService().queryDownload();
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryCanUpdateVA(String appId, final Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        queryVAInfo(appId, new Function2<Boolean, MiniGameDownloadDataWrapper, Unit>() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$queryCanUpdateVA$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                invoke(bool.booleanValue(), miniGameDownloadDataWrapper);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper) {
                ConcurrentHashMap concurrentHashMap;
                QLog.i("MiniGameVAImpl", 1, "queryCanUpdateVA isSuccess:" + z16 + " findData:" + miniGameDownloadDataWrapper);
                if (z16 && miniGameDownloadDataWrapper != null) {
                    concurrentHashMap = this.downloadingMap;
                    MiniGameDownloadDataWrapper miniGameDownloadDataWrapper2 = (MiniGameDownloadDataWrapper) concurrentHashMap.get(miniGameDownloadDataWrapper.getData().getGameId());
                    if (miniGameDownloadDataWrapper2 != null && miniGameDownloadDataWrapper2.getDownloadStatus() == 11) {
                        Function2<Boolean, MiniGameDownloadDataWrapper, Unit> function2 = callback;
                        if (function2 != null) {
                            function2.invoke(Boolean.TRUE, miniGameDownloadDataWrapper2);
                            return;
                        }
                        return;
                    }
                    Function2<Boolean, MiniGameDownloadDataWrapper, Unit> function22 = callback;
                    if (function22 != null) {
                        function22.invoke(Boolean.FALSE, miniGameDownloadDataWrapper);
                        return;
                    }
                    return;
                }
                Function2<Boolean, MiniGameDownloadDataWrapper, Unit> function23 = callback;
                if (function23 != null) {
                    function23.invoke(Boolean.valueOf(z16), miniGameDownloadDataWrapper);
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryExistDownloadList(final Function2<? super Boolean, ? super List<MiniGameDownloadDataWrapper>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.b
            @Override // java.lang.Runnable
            public final void run() {
                MiniGameVAImpl.queryExistDownloadList$lambda$0(MiniGameVAImpl.this, callback);
            }
        }, 32, null, false);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryExistVAList(final Function2<? super Boolean, ? super List<MiniGameDownloadDataWrapper>, Unit> callback) {
        int mapCapacity;
        Intrinsics.checkNotNullParameter(callback, "callback");
        QLog.i(TAG, 1, "start queryExistVAList");
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null && !miniGameVAInterceptConfig.getInterceptConfigMap().isEmpty()) {
            Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap();
            mapCapacity = MapsKt__MapsJVMKt.mapCapacity(interceptConfigMap.size());
            final LinkedHashMap linkedHashMap = new LinkedHashMap(mapCapacity);
            Iterator<T> it = interceptConfigMap.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(((MiniGameVAInterceptConfig.VAInterceptConfig) entry.getValue()).getGameAppPkgName(), entry.getValue());
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.minigame.va.c
                @Override // java.lang.Runnable
                public final void run() {
                    MiniGameVAImpl.queryExistVAList$lambda$2(MiniGameVAImpl.this, callback, linkedHashMap);
                }
            }, 32, null, false);
            return;
        }
        QLog.e(TAG, 1, "queryExistVAList config null");
        callback.invoke(Boolean.FALSE, null);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void queryVAInfo(String appId, final Function2<? super Boolean, ? super MiniGameDownloadDataWrapper, Unit> callback) {
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(callback, "callback");
        MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
        if (miniGameVAInterceptConfig != null && !miniGameVAInterceptConfig.getInterceptConfigMap().isEmpty()) {
            final MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig = miniGameVAInterceptConfig.getInterceptConfigMap().get(appId);
            final String gameAppId = vAInterceptConfig != null ? vAInterceptConfig.getGameAppId() : null;
            if (!TextUtils.isEmpty(gameAppId) && ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).isModelLimitValid(appId, true)) {
                MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig2 = miniGameVAInterceptConfig.getInterceptConfigMap().get(appId);
                final int gameAppMinVersionCode = vAInterceptConfig2 != null ? vAInterceptConfig2.getGameAppMinVersionCode() : 0;
                QLog.i(TAG, 1, "queryVAInfo vaInterceptConfig.availableCheckSwitch:" + miniGameVAInterceptConfig.getAvailableCheckSwitch());
                if (miniGameVAInterceptConfig.getAvailableCheckSwitch()) {
                    ((IMiniBoxService) QRoute.api(IMiniBoxService.class)).checkMiniBoxAvailable(miniGameVAInterceptConfig.getAvailableCheckDefault(), miniGameVAInterceptConfig.getAvailableCheckTimeout(), miniGameVAInterceptConfig.getAvailableCheckCrashStacks(), new bs3.b() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$queryVAInfo$1
                        @Override // bs3.b
                        public void onChecked(boolean isAvailable, int checkStep, String reason) {
                            Intrinsics.checkNotNullParameter(reason, "reason");
                            QLog.i("MiniGameVAImpl", 1, "queryVAInfo checkMiniBoxAvailable onChecked isAvailable:" + isAvailable + " checkStep:" + checkStep);
                            if (isAvailable) {
                                MiniGameVAImpl.this.queryVAInner(gameAppId, vAInterceptConfig, gameAppMinVersionCode, callback);
                            } else {
                                callback.invoke(Boolean.FALSE, null);
                            }
                        }
                    });
                    return;
                } else {
                    queryVAInner(gameAppId, vAInterceptConfig, gameAppMinVersionCode, callback);
                    return;
                }
            }
            callback.invoke(Boolean.FALSE, null);
            QLog.e(TAG, 1, "queryExistVAList appId not valid: " + appId);
            return;
        }
        callback.invoke(Boolean.FALSE, null);
        QLog.e(TAG, 1, "queryExistVAList config null");
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void registerStatusListener(String gameId, StatusListener listener) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.statusLock;
        reentrantLock.lock();
        try {
            ArrayList<StatusListener> arrayList = this.statusListener.get(gameId);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(listener);
            this.statusListener.put(gameId, arrayList);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void restartAndInstallVA(String appId, String gameId, String versionCode, Function2<? super Boolean, ? super String, Unit> callback) {
        Map<String, MiniGameVAInterceptConfig.VAInterceptConfig> interceptConfigMap;
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(versionCode, "versionCode");
        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.downloadingMap.get(gameId);
        QLog.i(TAG, 1, "restartAndInstallVA appId:" + appId + ", gameId:" + gameId + ", data:" + miniGameDownloadDataWrapper);
        if (miniGameDownloadDataWrapper == null || miniGameDownloadDataWrapper.getDownloadStatus() != 5) {
            if (callback != null) {
                callback.invoke(Boolean.TRUE, "download status invalid");
                return;
            }
            return;
        }
        if (MiniGameDownloadUtil.INSTANCE.compareVersionCode(miniGameDownloadDataWrapper.getData().getVersionCode(), versionCode) > 0) {
            MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
            MiniGameVAInterceptConfig.VAInterceptConfig vAInterceptConfig = (miniGameVAInterceptConfig == null || (interceptConfigMap = miniGameVAInterceptConfig.getInterceptConfigMap()) == null) ? null : interceptConfigMap.get(appId);
            if (vAInterceptConfig == null) {
                if (callback != null) {
                    callback.invoke(Boolean.FALSE, "config null");
                }
                QLog.e(TAG, 1, "restartAndInstallVA config null");
                return;
            }
            MiniGameVAStartData miniGameVAStartData = new MiniGameVAStartData(vAInterceptConfig, miniGameDownloadDataWrapper);
            miniGameVAStartData.setNeedInstall(true);
            VAInstallAppLoadingFragment.Companion companion = VAInstallAppLoadingFragment.INSTANCE;
            BaseApplication context = BaseApplication.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "getContext()");
            companion.startVA(context, miniGameVAStartData, null);
            if (callback != null) {
                callback.invoke(Boolean.TRUE, "");
                return;
            }
            return;
        }
        if (callback != null) {
            callback.invoke(Boolean.TRUE, "nothing to do");
        }
        QLog.i(TAG, 1, "restartAndInstallVA nothing to do");
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void startDownload(String gameId, Boolean needInstall, Boolean onlyWifi, int scene, boolean autoResume) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.downloadingMap.get(gameId);
        QLog.i(TAG, 1, "startDownload gameId:" + gameId + ", needInstall:" + needInstall + ", onlyWifi:" + onlyWifi + ", data:" + miniGameDownloadDataWrapper + ", scene:" + scene + ", autoResume:" + autoResume);
        if (miniGameDownloadDataWrapper == null) {
            return;
        }
        if (needInstall != null) {
            miniGameDownloadDataWrapper.setAutoInstall(needInstall.booleanValue());
        }
        if (onlyWifi != null) {
            miniGameDownloadDataWrapper.setOnlyOnWifi(onlyWifi.booleanValue());
        }
        if (scene != DownloadScene.SCENE_INSTALL_UNKNOW.getScene()) {
            miniGameDownloadDataWrapper.setScene(scene);
        }
        startDownload(miniGameDownloadDataWrapper, scene, autoResume);
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void uninstallVA(final String gameId) {
        Object obj;
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Iterator<T> it = this.installedList.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (Intrinsics.areEqual(((MiniGameDownloadDataWrapper) obj).getData().getGameId(), gameId)) {
                    break;
                }
            }
        }
        final MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = (MiniGameDownloadDataWrapper) obj;
        QLog.i(TAG, 1, "uninstallVA data:" + miniGameDownloadDataWrapper);
        if (miniGameDownloadDataWrapper == null || TextUtils.isEmpty(miniGameDownloadDataWrapper.getData().getPkgName())) {
            return;
        }
        DiffPatchHandler.cancelPatchDownload(this, gameId, this.downloadingMap);
        IMiniBoxLauncher iMiniBoxLauncher = (IMiniBoxLauncher) QRoute.api(IMiniBoxLauncher.class);
        String pkgName = miniGameDownloadDataWrapper.getData().getPkgName();
        Intrinsics.checkNotNull(pkgName);
        iMiniBoxLauncher.uninstallVirtualApp(pkgName, new Function3<Boolean, Integer, String, Unit>() { // from class: com.tencent.mobileqq.minigame.va.MiniGameVAImpl$uninstallVA$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str) {
                invoke(bool.booleanValue(), num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, String str) {
                QLog.i("MiniGameVAImpl", 1, "uninstallVirtualApp isSuccess:" + z16 + " errMsg:" + str);
                if (z16) {
                    MiniGameDownloadDataWrapper.this.setDownloadStatus(10);
                    this.notifyStatusListener(gameId, MiniGameDownloadDataWrapper.this);
                    ((IMiniGameVAManager) QRoute.api(IMiniGameVAManager.class)).calculateMiniGameSpaceOccupy();
                }
            }
        });
    }

    @Override // com.tencent.mobileqq.minigame.va.IMiniGameVA
    public void unregisterStatusListener(String gameId, StatusListener listener) {
        Intrinsics.checkNotNullParameter(gameId, "gameId");
        Intrinsics.checkNotNullParameter(listener, "listener");
        ReentrantLock reentrantLock = this.statusLock;
        reentrantLock.lock();
        try {
            ArrayList<StatusListener> arrayList = this.statusListener.get(gameId);
            if (arrayList == null) {
                return;
            }
            arrayList.remove(listener);
            this.statusListener.put(gameId, arrayList);
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reportDownloadCost(String gameId, boolean isDiff, long downloadEndTs, long diffEndTs) {
        Object obj;
        Object obj2;
        long coerceAtLeast;
        Map mutableMapOf;
        Long l3 = this.startDownloadTsMap.get(gameId);
        if (l3 != null) {
            if (l3.longValue() <= 0) {
                return;
            }
            String str = "1";
            if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
                obj = "1";
            } else {
                obj = "2";
            }
            boolean useWifiAndXGSwitch = MiniGameVAUtil.getUseWifiAndXGSwitch();
            if (((IQQGameDualDownloadService) QRoute.api(IQQGameDualDownloadService.class)).isKingCard()) {
                obj2 = "1";
            } else {
                obj2 = "2";
            }
            long longValue = downloadEndTs - l3.longValue();
            long j3 = diffEndTs > 0 ? diffEndTs - downloadEndTs : 0L;
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(downloadEndTs, diffEndTs);
            long longValue2 = coerceAtLeast - l3.longValue();
            Pair[] pairArr = new Pair[7];
            if (isDiff) {
                str = "2";
            }
            pairArr[0] = TuplesKt.to("ext7", str);
            pairArr[1] = TuplesKt.to("ext8", String.valueOf(longValue2));
            pairArr[2] = TuplesKt.to("ext9", obj2);
            pairArr[3] = TuplesKt.to("ext23", obj);
            pairArr[4] = TuplesKt.to("ext6", String.valueOf(longValue));
            pairArr[5] = TuplesKt.to("ext46", String.valueOf(j3));
            pairArr[6] = TuplesKt.to("ext45", String.valueOf(useWifiAndXGSwitch));
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989590", "18", gameId, mutableMapOf);
            QLog.i(TAG, 1, "reportDownloadCost isWifiAndXG:" + useWifiAndXGSwitch + ", allCost:" + longValue2 + ", downloadCost:" + longValue + ", diffCost:" + j3);
        }
    }

    @Override // nl0.d
    public void onWadlStatusChanged(WadlResult wadlResult) {
        String str;
        Map mutableMapOf;
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "onWadlStatusChanged wadlResult:" + wadlResult);
        }
        if (wadlResult == null) {
            return;
        }
        String gameId = wadlResult.wadlParams.appId;
        MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.downloadingMap.get(gameId);
        if (miniGameDownloadDataWrapper == null) {
            QLog.e(TAG, 1, "onWadlStatusChanged but gameId:" + gameId + " data is null");
            return;
        }
        updateStartDownloadTs(wadlResult);
        miniGameDownloadDataWrapper.setDownloadStatus(matchDownloadStatus(wadlResult.taskStatus, miniGameDownloadDataWrapper.getDownloadStatus()));
        miniGameDownloadDataWrapper.setProgress(matchDownloadProgress(wadlResult.progress, miniGameDownloadDataWrapper.getDownloadStatus()));
        miniGameDownloadDataWrapper.setErrorCode(wadlResult.errCode);
        miniGameDownloadDataWrapper.getData().setDownloadSize(wadlResult.downloadFileSize);
        miniGameDownloadDataWrapper.getData().setSize(wadlResult.fileSize);
        if (miniGameDownloadDataWrapper.getDownloadStatus() == 5) {
            Intrinsics.checkNotNullExpressionValue(gameId, "gameId");
            onApkDownloadComplete(gameId, miniGameDownloadDataWrapper, wadlResult);
        } else {
            Intrinsics.checkNotNullExpressionValue(gameId, "gameId");
            notifyStatusListener(gameId, miniGameDownloadDataWrapper);
        }
        if (miniGameDownloadDataWrapper.getErrorCode() != 0) {
            if (miniGameDownloadDataWrapper.getErrorCode() == 999 && ((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).isApkDownloadInnerStorageEnable()) {
                QLog.i(TAG, 1, "onWadlStatusChanged download failed space not enough on inner storage");
                miniGameDownloadDataWrapper.setNotNotifyWhenDelete(true);
                getDownloadService().deleteDownload(miniGameDownloadDataWrapper.getData());
                MiniGameVAUtil.handleInnerStorageDownloadFailed(this, findAppIdFromGameId(gameId));
                str = "1";
            } else {
                str = "";
            }
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ext7", "2"), TuplesKt.to("ext8", String.valueOf(miniGameDownloadDataWrapper.getScene())), TuplesKt.to("ext2", String.valueOf(miniGameDownloadDataWrapper.getData().getSize())), TuplesKt.to("ext45", str));
            MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989339", "18", gameId, mutableMapOf);
        }
        if (miniGameDownloadDataWrapper.getIsAutoInstall() && 4 == wadlResult.taskStatus && wadlResult.progress >= 95) {
            MiniBoxSDK.preload();
        }
    }

    static /* synthetic */ void onApkFileReady$default(MiniGameVAImpl miniGameVAImpl, MiniGameDownloadDataWrapper miniGameDownloadDataWrapper, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = false;
        }
        miniGameVAImpl.onApkFileReady(miniGameDownloadDataWrapper, z16);
    }

    private final void startDownload(MiniGameDownloadDataWrapper data, int scene, boolean autoResume) {
        Map mutableMapOf;
        if (data.getDownloadStatus() == 4 && autoResume) {
            getDownloadService().resumeDownload(data.getData());
        } else if (data.getDownloadStatus() == 5 && !TextUtils.isEmpty(data.getData().getApkPath()) && new File(data.getData().getApkPath()).exists()) {
            IMiniGameVA.DefaultImpls.installVA$default(this, data, null, false, 6, null);
        } else {
            if (data.getData().getDiffPatchInfo() == null) {
                DiffPatchHandler.cancelPatchDownload(this, data.getData().getGameId(), this.downloadingMap);
            } else {
                MiniGameDownloadDataWrapper miniGameDownloadDataWrapper = this.downloadingMap.get(data.getData().getGameId());
                if (miniGameDownloadDataWrapper != null && !Intrinsics.areEqual(miniGameDownloadDataWrapper.getData().getDiffPatchInfo(), data.getData().getDiffPatchInfo())) {
                    cancelDownload(miniGameDownloadDataWrapper.getData().getGameId());
                    QLog.i(TAG, 1, "startDownload cancel downloadingGame.data:" + miniGameDownloadDataWrapper.getData());
                    DiffPatchHandler.reportDownloadDiffError(data.getData().getGameId(), data, -2, "download all apk");
                }
            }
            getDownloadService().startDownload(data);
            if (data.getData().getDiffPatchInfo() != null) {
                MiniGameDiffPatchInfo diffPatchInfo = data.getData().getDiffPatchInfo();
                if (!TextUtils.isEmpty(diffPatchInfo != null ? diffPatchInfo.getDiffPatchUrl() : null)) {
                    DiffPatchUtil.INSTANCE.preloadDiffPatch();
                }
            }
        }
        String gameId = data.getData().getGameId();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("ext7", String.valueOf(scene)), TuplesKt.to("ext2", String.valueOf(data.getData().getSize())));
        MiniAppUtils.reportMiniGameCenterDC00087("1", WadlProxyConsts.PAGE_ID_DOWNLOAD, "9080", "908015", "989338", "18", gameId, mutableMapOf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int matchDownloadProgress(int progress, int status) {
        if (status == 9) {
            return progress;
        }
        if (status == 5) {
            return 98;
        }
        return (int) Math.ceil(progress * 0.98f);
    }
}
