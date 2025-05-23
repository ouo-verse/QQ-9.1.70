package com.tencent.mobileqq.debug.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadCheck;
import com.tencent.mobileqq.msf.core.x.q;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.widget.PopupMenuDialog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xb36.oidb_cmd0xb36$RspBody;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001e\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH&J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001dH&J\b\u0010\u001f\u001a\u00020\u0003H&J\b\u0010 \u001a\u00020\u0003H&J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0018H&J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u001dH&J\b\u0010$\u001a\u00020\u001dH&J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010*\u001a\u00020&2\u0006\u0010\u0004\u001a\u00020\u0005H&J\"\u0010+\u001a\u0016\u0012\u0004\u0012\u0002H-\u0018\u00010,j\n\u0012\u0004\u0012\u0002H-\u0018\u0001`.\"\u0004\b\u0000\u0010-H&J\b\u0010/\u001a\u00020\u0012H&J \u00100\u001a\u0002012\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002012\u0006\u00105\u001a\u00020\u001dH&J\u0010\u00106\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u00107\u001a\u00020\u0003H&J\b\u00108\u001a\u00020\u0003H&J\u0010\u00109\u001a\u00020:2\u0006\u0010\u000b\u001a\u00020\u0018H&J\b\u0010;\u001a\u00020:H&J\b\u0010<\u001a\u00020:H&J\b\u0010=\u001a\u00020>H&J\u0018\u0010?\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010@\u001a\u00020\u0003H&J\b\u0010A\u001a\u00020\u0003H&J\u0010\u0010B\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010C\u001a\u00020\u0003H&J\u0010\u0010D\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0018H&J\u0010\u0010E\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010F\u001a\u00020\u0003H&J\b\u0010G\u001a\u00020\u0003H&J\b\u0010H\u001a\u00020\u0003H&\u00a8\u0006I"}, d2 = {"Lcom/tencent/mobileqq/debug/api/IQQDebugApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "addCIOButtonIntoScreenShotView", "", "context", "Landroid/content/Context;", "root", "Landroid/view/ViewGroup;", "cioSubmitListener", "Landroid/view/View$OnClickListener;", "addDebugMenu", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/app/QBaseActivity;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "Lcom/tencent/widget/PopupMenuDialog$MenuItem;", "addMSFThreadMonitor", "type", "", MosaicConstants$JsProperty.PROP_THREAD, "Landroid/os/HandlerThread;", "addMenuInVideoView", "app", "Lcom/tencent/common/app/AppInterface;", "Landroid/app/Activity;", "view", "Landroid/view/View;", "buildTestEnvironment", q.f250387s, "", "id", "checkMSFCoreStateFloatViewFromStartUp", "checkMemoryDumpFloat", "checkUpdate", "checkVideoDecoderFrameCostTimes", "stateInfo", "getAConfigFile", "getCIOIntent", "Landroid/content/Intent;", "getCIOSubmitIntent", "getDebugPagePendingIntent", "Landroid/app/PendingIntent;", "getPreDownloadTestIntent", "getSGAudioVirtualList", "Ljava/util/ArrayList;", "T", "Lkotlin/collections/ArrayList;", "getSpringTestAdCode", "hookRespBody", "Ltencent/im/oidb/cmd0xb36/oidb_cmd0xb36$RspBody;", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "rspBody", "troopUin", "init", "initHodorTest", "initJankDialog", "isInstanceOfCIOSubmitActivity", "", "isQosTimerRun", "isTestEnvironment", "newThreadCheckerImp", "Lcom/tencent/mobileqq/app/ThreadCheck;", "onDebugMenuEvent", "printProcessInfo", "registerModule", "restartApp", "showAIOPerfGadgetIfNeed", "showTestBtn", "startFeedEditorSchemeDebugPage", "startNetworkPolicy", "stopQosTimer", "unRegisterModule", "qq_debug_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@QAPI(process = {"all"})
/* loaded from: classes10.dex */
public interface IQQDebugApi extends QRouteApi {
    void addCIOButtonIntoScreenShotView(@NotNull Context context, @NotNull ViewGroup root, @NotNull View.OnClickListener cioSubmitListener);

    void addDebugMenu(@NotNull QBaseActivity activity, @NotNull List<? extends PopupMenuDialog.MenuItem> item);

    void addMSFThreadMonitor(int type, @NotNull HandlerThread thread);

    void addMenuInVideoView(@NotNull AppInterface app, @NotNull Activity activity, @NotNull View view);

    void buildTestEnvironment(@NotNull String sso, @NotNull String id5);

    void checkMSFCoreStateFloatViewFromStartUp();

    void checkMemoryDumpFloat();

    void checkUpdate(@NotNull Activity activity);

    void checkVideoDecoderFrameCostTimes(@NotNull String stateInfo);

    @NotNull
    String getAConfigFile();

    @NotNull
    Intent getCIOIntent(@NotNull Context context);

    @NotNull
    Intent getCIOSubmitIntent(@NotNull Context context);

    @NotNull
    PendingIntent getDebugPagePendingIntent(@NotNull Context context);

    @NotNull
    Intent getPreDownloadTestIntent(@NotNull Context context);

    @Nullable
    <T> ArrayList<T> getSGAudioVirtualList();

    int getSpringTestAdCode();

    @NotNull
    oidb_cmd0xb36$RspBody hookRespBody(@NotNull ToServiceMsg req, @NotNull oidb_cmd0xb36$RspBody rspBody, @NotNull String troopUin);

    void init(@NotNull Context context);

    void initHodorTest();

    void initJankDialog();

    boolean isInstanceOfCIOSubmitActivity(@NotNull Activity activity);

    boolean isQosTimerRun();

    boolean isTestEnvironment();

    @NotNull
    ThreadCheck newThreadCheckerImp();

    void onDebugMenuEvent(@NotNull PopupMenuDialog.MenuItem item, @NotNull QBaseActivity activity);

    void printProcessInfo();

    void registerModule();

    void restartApp(@NotNull Context context);

    void showAIOPerfGadgetIfNeed();

    void showTestBtn(@NotNull Activity activity);

    void startFeedEditorSchemeDebugPage(@NotNull Context context);

    void startNetworkPolicy();

    void stopQosTimer();

    void unRegisterModule();
}
