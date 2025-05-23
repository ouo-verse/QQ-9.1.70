package com.tencent.mobileqq.perf.process.config;

import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.avbiz.Constants;
import com.tencent.freesia.IConfigData;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.AppSetting;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bG\n\u0002\u0010\u0011\n\u0002\u0010\u0007\n\u0002\b\r\u0018\u0000 g2\u00020\u0001:\u0001{B\u0007\u00a2\u0006\u0004\by\u0010zJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R(\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR(\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00188\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001eR\"\u0010\"\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0006\u001a\u0004\b#\u0010\b\"\u0004\b$\u0010\nR4\u0010*\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0&0%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u001a\u001a\u0004\b(\u0010\u001c\"\u0004\b)\u0010\u001eR(\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001c\"\u0004\b-\u0010\u001eR\"\u0010.\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010\u0006\u001a\u0004\b/\u0010\b\"\u0004\b0\u0010\nR(\u00101\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b1\u0010\u001a\u001a\u0004\b'\u0010\u001c\"\u0004\b2\u0010\u001eR\"\u00103\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010\u0006\u001a\u0004\b4\u0010\b\"\u0004\b5\u0010\nR\"\u00106\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b6\u0010\r\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R\"\u00109\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b9\u0010\u0007\u001a\u0004\b:\u0010\u0015\"\u0004\b;\u0010\u0017R\"\u0010<\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010\u0006\u001a\u0004\b=\u0010\b\"\u0004\b>\u0010\nR\"\u0010?\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010\r\u001a\u0004\b@\u0010\u000f\"\u0004\bA\u0010\u0011R\"\u0010B\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010\u0007\u001a\u0004\bC\u0010\u0015\"\u0004\bD\u0010\u0017R\"\u0010E\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bE\u0010\u0007\u001a\u0004\bF\u0010\u0015\"\u0004\bG\u0010\u0017R\"\u0010H\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bH\u0010\u0006\u001a\u0004\bI\u0010\b\"\u0004\bJ\u0010\nR\"\u0010K\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010\u0006\u001a\u0004\bL\u0010\b\"\u0004\bM\u0010\nR\"\u0010N\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010\u0006\u001a\u0004\bO\u0010\b\"\u0004\bP\u0010\nR\"\u0010Q\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bQ\u0010\u0006\u001a\u0004\bR\u0010\b\"\u0004\bS\u0010\nR(\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00020%8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bT\u0010\u001a\u001a\u0004\bU\u0010\u001c\"\u0004\bV\u0010\u001eR\"\u0010W\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010\r\u001a\u0004\bX\u0010\u000f\"\u0004\bY\u0010\u0011R$\u0010[\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020\u00048\u0006@BX\u0087\u000e\u00a2\u0006\f\n\u0004\b[\u0010\u0006\u001a\u0004\b\\\u0010\bR\"\u0010]\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b]\u0010\u0007\u001a\u0004\b^\u0010\u0015\"\u0004\b_\u0010\u0017R\"\u0010`\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010\r\u001a\u0004\ba\u0010\u000f\"\u0004\bb\u0010\u0011R\"\u0010c\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bc\u0010\r\u001a\u0004\bd\u0010\u000f\"\u0004\be\u0010\u0011R\"\u0010f\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bf\u0010\r\u001a\u0004\bg\u0010\u000f\"\u0004\bh\u0010\u0011R\"\u0010i\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bi\u0010\u0006\u001a\u0004\bj\u0010\b\"\u0004\bk\u0010\nR\"\u0010l\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bl\u0010\u0006\u001a\u0004\b\r\u0010\b\"\u0004\bm\u0010\nR(\u0010p\u001a\b\u0012\u0004\u0012\u00020o0n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bp\u0010q\u001a\u0004\br\u0010s\"\u0004\bt\u0010uR\"\u0010v\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0004\bv\u0010\u0006\u001a\u0004\bw\u0010\b\"\u0004\bx\u0010\n\u00a8\u0006|"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/MainProcConfig;", "Lcom/tencent/freesia/IConfigData;", "", "toString", "", "mainKillSwitch", "Z", "D", "()Z", "setMainKillSwitch", "(Z)V", "", "mainKillDelayTime", "I", HippyTKDListViewAdapter.X, "()I", "setMainKillDelayTime", "(I)V", "", "mainKillMemThreshold", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "()D", "O", "(D)V", "", "floatWrapperBlackList", "Ljava/util/List;", "o", "()Ljava/util/List;", "setFloatWrapperBlackList", "(Ljava/util/List;)V", "mainKillSceneBlackList", BdhLogUtil.LogTag.Tag_Conn, "setMainKillSceneBlackList", "mainKillOnlyReport", "B", "setMainKillOnlyReport", "", "Lkotlin/Pair;", "d", ReportConstant.COSTREPORT_PREFIX, "N", "killTimePeriod", "allKillTimePeriod", "c", "setAllKillTimePeriod", "careOldTypeNotification", "g", "setCareOldTypeNotification", "allowedSubProcessList", "setAllowedSubProcessList", "mainKillSwitchForNoLogin", "E", "setMainKillSwitchForNoLogin", "mainKillDelayTimeForNoLogin", "y", "setMainKillDelayTimeForNoLogin", "mainKillMemThresholdForNoLogin", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "P", "mainGcSwitch", "w", "setMainGcSwitch", "mainGcDelayTime", "t", "setMainGcDelayTime", "mainGcMemThreshold", "u", "setMainGcMemThreshold", "mainGcReportSample", "v", "setMainGcReportSample", "fixInputMethodManager", "l", "L", "fixDisplayManager", "k", "K", "fixPhoneWindow", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "setFixPhoneWindow", "exemptAllPrivateAPI", "j", "J", "phoneWinMfr", "G", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "phoneWinDelay", UserInfo.SEX_FEMALE, "setPhoneWinDelay", "<set-?>", "enableForegroundGC", "i", "foregroundGcThreshold", "p", "setForegroundGcThreshold", "foregroundGcTime", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "setForegroundGcTime", "bgReportSample", "f", "setBgReportSample", "bgReportAccountSample", "e", "setBgReportAccountSample", "coldStartLimit", h.F, "setColdStartLimit", "procAliveSwitch", BdhLogUtil.LogTag.Tag_Req, "", "", "procAliveSample", "[Ljava/lang/Float;", "H", "()[Ljava/lang/Float;", "setProcAliveSample", "([Ljava/lang/Float;)V", "fixScene", DomainData.DOMAIN_NAME, "M", "<init>", "()V", "a", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class MainProcConfig implements IConfigData {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: f, reason: collision with root package name */
    @NotNull
    private static MainProcConfig f257886f;

    @SerializedName(alternate = {"timePD"}, value = "allKillTimePeriod")
    @NotNull
    private List<String> allKillTimePeriod;

    @SerializedName(alternate = {"subPrcLS"}, value = "allowedSubProcessList")
    @NotNull
    private List<String> allowedSubProcessList;

    @SerializedName("bgAccSp")
    private int bgReportAccountSample;

    @SerializedName("bgSp")
    private int bgReportSample;

    @SerializedName(alternate = {"oldNotifySW"}, value = "careOldTypeNotification")
    private boolean careOldTypeNotification;

    @SerializedName("coldStLIM")
    private boolean coldStartLimit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Expose(deserialize = false)
    @NotNull
    private List<Pair<Integer, Integer>> killTimePeriod;

    @SerializedName(alternate = {"fgGcSW"}, value = "enable_foreground_gc")
    private boolean enableForegroundGC;

    @SerializedName(alternate = {"enablePvtApi"}, value = "exemptAllPrivateAPI")
    private boolean exemptAllPrivateAPI;

    @SerializedName(alternate = {"fixDisplay"}, value = "fixDisplayManager")
    private boolean fixDisplayManager;

    @SerializedName(alternate = {"fixIMM"}, value = "fixInputMethodManager")
    private boolean fixInputMethodManager;

    @SerializedName(alternate = {"fixPhoneWin"}, value = "fixPhoneWindow")
    private boolean fixPhoneWindow;

    @SerializedName("fixScene")
    private boolean fixScene;

    @SerializedName(alternate = {"floatBL"}, value = "floatWrapperBlackList")
    @NotNull
    private List<String> floatWrapperBlackList;

    @SerializedName(alternate = {"fgGcTHR"}, value = "fg_gc_threshold")
    private double foregroundGcThreshold;

    @SerializedName(alternate = {"fgGcTime"}, value = "fg_gc_time")
    private int foregroundGcTime;

    @SerializedName(alternate = {"gcDelay"}, value = "mainGcDelayTime")
    private int mainGcDelayTime;

    @SerializedName(alternate = {"gcTHR"}, value = "mainGcMemThreshold")
    private double mainGcMemThreshold;

    @SerializedName(alternate = {"gcSample"}, value = "mainGcReportSample")
    private double mainGcReportSample;

    @SerializedName(alternate = {"gcSW"}, value = "mainGcSwitch")
    private boolean mainGcSwitch;

    @SerializedName(alternate = {"killDelay"}, value = "mainKillDelayTime")
    private int mainKillDelayTime;

    @SerializedName(alternate = {"noLoginDelay"}, value = "mainKillDelayTimeForNoLogin")
    private int mainKillDelayTimeForNoLogin;

    @SerializedName(alternate = {"killTHR"}, value = "mainKillMemThreshold")
    private double mainKillMemThreshold;

    @SerializedName(alternate = {"noLoginTHR"}, value = "mainKillMemThresholdForNoLogin")
    private double mainKillMemThresholdForNoLogin;

    @SerializedName(alternate = {"justReport"}, value = "mainKillOnlyReport")
    private boolean mainKillOnlyReport;

    @SerializedName(alternate = {"sceneBL"}, value = "sceneBlackList")
    @NotNull
    private List<String> mainKillSceneBlackList;

    @SerializedName(alternate = {"killSW"}, value = "mainProcessKillSwitch")
    private boolean mainKillSwitch;

    @SerializedName(alternate = {"noLoginSW"}, value = "mainProcessKillSwitchForNoLogin")
    private boolean mainKillSwitchForNoLogin;

    @SerializedName("phoneWinDelay")
    private int phoneWinDelay;

    @SerializedName("phoneWinMfr")
    @NotNull
    private List<String> phoneWinMfr;

    @SerializedName("aliveSamp")
    @NotNull
    private Float[] procAliveSample;

    @SerializedName("aliveSW")
    private boolean procAliveSwitch;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0006\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b$\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J(\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u00070\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0002J\u0006\u0010\u000b\u001a\u00020\nJ\u0006\u0010\f\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0005J\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u0007R(\u0010\u0011\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010\u001f\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0014\u0010\"\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001bR\u0014\u0010#\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b#\u0010\u001e\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/MainProcConfig$a;", "", "Lcom/tencent/mobileqq/perf/process/config/MainProcConfig;", "f", "", "", "timeStr", "Lkotlin/Pair;", "", "c", "", "i", "d", "jsonStr", "g", "", "b", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "Lcom/tencent/mobileqq/perf/process/config/MainProcConfig;", "e", "()Lcom/tencent/mobileqq/perf/process/config/MainProcConfig;", h.F, "(Lcom/tencent/mobileqq/perf/process/config/MainProcConfig;)V", "getInstance$annotations", "()V", "", "GC_MAIN_MEM_THRESHOLD", "D", "GC_MAIN_REPORT_SAMPLE", "GROUP", "Ljava/lang/String;", "KILL_MAIN_DELAY_TIME", "I", "KILL_MAIN_MEM_THRESHOLD", "KILL_MAIN_MEM_THRESHOLD_NO_LOGIN", "TAG", "<init>", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.perf.process.config.MainProcConfig$a, reason: from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
                return;
            }
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) defaultConstructorMarker);
        }

        private final List<Pair<Integer, Integer>> c(List<String> timeStr) {
            List<Pair<Integer, Integer>> emptyList;
            int collectionSizeOrDefault;
            List split$default;
            try {
                List<String> list = timeStr;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"-"}, false, 0, 6, (Object) null);
                    arrayList.add(new Pair(Integer.valueOf(Integer.parseInt((String) split$default.get(0))), Integer.valueOf(Integer.parseInt((String) split$default.get(1)))));
                }
                return arrayList;
            } catch (Exception e16) {
                QLog.e("MainProcConfig", 1, "convertTimePeriod fail, timeStr: " + timeStr, e16);
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.String] */
        /* JADX WARN: Type inference failed for: r0v5, types: [com.tencent.mobileqq.perf.process.config.MainProcConfig] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        public final MainProcConfig f() {
            MainProcConfig mainProcConfig = "MainProcConfig";
            try {
                f fVar = f.f257911a;
                if (fVar.e()) {
                    QLog.i("MainProcConfig", 1, "loadConfig, use local config");
                    mainProcConfig = g(fVar.d());
                } else {
                    QLog.i("MainProcConfig", 1, "loadConfig, use publish config");
                    MainProcConfig mainProcConfig2 = (MainProcConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig("100972");
                    if (mainProcConfig2 == null) {
                        mainProcConfig = d();
                    } else {
                        mainProcConfig = mainProcConfig2;
                    }
                }
                return mainProcConfig;
            } catch (Throwable th5) {
                QLog.e(mainProcConfig, 1, "loadConfig, error. use default config", th5);
                return d();
            }
        }

        @NotNull
        public final Pair<Boolean, Boolean> b() {
            boolean z16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (Pair) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            String MANUFACTURER = Build.MANUFACTURER;
            Intrinsics.checkNotNullExpressionValue(MANUFACTURER, "MANUFACTURER");
            Locale ENGLISH = Locale.ENGLISH;
            Intrinsics.checkNotNullExpressionValue(ENGLISH, "ENGLISH");
            String lowerCase = MANUFACTURER.toLowerCase(ENGLISH);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
            com.tencent.mobileqq.perf.process.util.b bVar = com.tencent.mobileqq.perf.process.util.b.f257946a;
            boolean z17 = false;
            boolean d16 = bVar.d(e().G(), lowerCase, 0);
            if (!d16 && !bVar.d(e().G(), lowerCase, 1)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (d16 || bVar.d(e().G(), lowerCase, 2)) {
                z17 = true;
            }
            return new Pair<>(Boolean.valueOf(z16), Boolean.valueOf(z17));
        }

        @NotNull
        public final MainProcConfig d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (MainProcConfig) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            MainProcConfig mainProcConfig = new MainProcConfig();
            mainProcConfig.L(false);
            mainProcConfig.K(false);
            mainProcConfig.J(false);
            return mainProcConfig;
        }

        @NotNull
        public final MainProcConfig e() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return MainProcConfig.f257886f;
            }
            return (MainProcConfig) iPatchRedirector.redirect((short) 2, (Object) this);
        }

        @NotNull
        public final MainProcConfig g(@NotNull String jsonStr) {
            boolean contains$default;
            List<String> mutableListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (MainProcConfig) iPatchRedirector.redirect((short) 6, (Object) this, (Object) jsonStr);
            }
            Intrinsics.checkNotNullParameter(jsonStr, "jsonStr");
            MainProcConfig config = (MainProcConfig) new Gson().fromJson(jsonStr, MainProcConfig.class);
            config.N(c(config.c()));
            if (!AppSetting.isPublicVersion()) {
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) jsonStr, (CharSequence) "usePublish", false, 2, (Object) null);
                if (!contains$default && !Utils.K()) {
                    mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("vivo-0-29..34", "vivo-1-27..28", "xiaomi-1-31..34", "xiaomi-0-29..30", "xiaomi-2-28", "huawei-1-31..32", "oppo-1-27..34", "realme-1-31..34", "oneplus-1-34", "nubia-2-34");
                    config.Q(mutableListOf);
                    config.P(0.2d);
                    config.O(0.7d);
                    config.R(true);
                    config.M(true);
                }
            }
            QLog.i("MainProcConfig", 1, String.valueOf(config));
            Intrinsics.checkNotNullExpressionValue(config, "config");
            return config;
        }

        public final void h(@NotNull MainProcConfig mainProcConfig) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) mainProcConfig);
            } else {
                Intrinsics.checkNotNullParameter(mainProcConfig, "<set-?>");
                MainProcConfig.f257886f = mainProcConfig;
            }
        }

        public final void i() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this);
            } else {
                h(f());
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32039);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 66)) {
            redirector.redirect((short) 66);
            return;
        }
        Companion companion = new Companion(null);
        INSTANCE = companion;
        f257886f = companion.f();
    }

    public MainProcConfig() {
        List<Pair<Integer, Integer>> emptyList;
        List<String> emptyList2;
        List<String> listOf;
        List<String> mutableListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mainKillDelayTime = 300000;
        this.mainKillMemThreshold = 0.9d;
        this.floatWrapperBlackList = com.tencent.mobileqq.perf.process.state.floating.a.f257938a.b();
        this.mainKillSceneBlackList = new ArrayList();
        this.mainKillOnlyReport = true;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.killTimePeriod = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.allKillTimePeriod = emptyList2;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Constants.Process.VIDEO_PROCESS);
        this.allowedSubProcessList = listOf;
        this.mainKillDelayTimeForNoLogin = 300000;
        this.mainKillMemThresholdForNoLogin = 0.3d;
        this.mainGcDelayTime = 300000;
        this.mainGcMemThreshold = 0.5d;
        this.mainGcReportSample = 1.0d;
        this.fixInputMethodManager = true;
        this.fixDisplayManager = true;
        this.exemptAllPrivateAPI = true;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf("vivo-1-33", "xiaomi-2-30");
        this.phoneWinMfr = mutableListOf;
        this.phoneWinDelay = 60000;
        this.foregroundGcThreshold = 0.7d;
        this.foregroundGcTime = 30000;
        this.bgReportSample = 10;
        this.bgReportAccountSample = 1000;
        this.procAliveSample = new Float[]{Float.valueOf(1.0f), Float.valueOf(0.001f), Float.valueOf(0.001f), Float.valueOf(0.01f)};
    }

    @NotNull
    public static final MainProcConfig r() {
        return INSTANCE.e();
    }

    public final double A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Double) iPatchRedirector.redirect((short) 26, (Object) this)).doubleValue();
        }
        return this.mainKillMemThresholdForNoLogin;
    }

    public final boolean B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        return this.mainKillOnlyReport;
    }

    @NotNull
    public final List<String> C() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mainKillSceneBlackList;
    }

    public final boolean D() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.mainKillSwitch;
    }

    public final boolean E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.mainKillSwitchForNoLogin;
    }

    public final int F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 46)) {
            return ((Integer) iPatchRedirector.redirect((short) 46, (Object) this)).intValue();
        }
        return this.phoneWinDelay;
    }

    @NotNull
    public final List<String> G() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 44)) {
            return (List) iPatchRedirector.redirect((short) 44, (Object) this);
        }
        return this.phoneWinMfr;
    }

    @NotNull
    public final Float[] H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 61)) {
            return (Float[]) iPatchRedirector.redirect((short) 61, (Object) this);
        }
        return this.procAliveSample;
    }

    public final boolean I() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 59)) {
            return ((Boolean) iPatchRedirector.redirect((short) 59, (Object) this)).booleanValue();
        }
        return this.procAliveSwitch;
    }

    public final void J(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 43)) {
            iPatchRedirector.redirect((short) 43, (Object) this, z16);
        } else {
            this.exemptAllPrivateAPI = z16;
        }
    }

    public final void K(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, z16);
        } else {
            this.fixDisplayManager = z16;
        }
    }

    public final void L(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            iPatchRedirector.redirect((short) 37, (Object) this, z16);
        } else {
            this.fixInputMethodManager = z16;
        }
    }

    public final void M(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 64)) {
            iPatchRedirector.redirect((short) 64, (Object) this, z16);
        } else {
            this.fixScene = z16;
        }
    }

    public final void N(@NotNull List<Pair<Integer, Integer>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.killTimePeriod = list;
        }
    }

    public final void O(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, Double.valueOf(d16));
        } else {
            this.mainKillMemThreshold = d16;
        }
    }

    public final void P(double d16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, this, Double.valueOf(d16));
        } else {
            this.mainKillMemThresholdForNoLogin = d16;
        }
    }

    public final void Q(@NotNull List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 45)) {
            iPatchRedirector.redirect((short) 45, (Object) this, (Object) list);
        } else {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.phoneWinMfr = list;
        }
    }

    public final void R(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 60)) {
            iPatchRedirector.redirect((short) 60, (Object) this, z16);
        } else {
            this.procAliveSwitch = z16;
        }
    }

    @NotNull
    public final List<String> c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.allKillTimePeriod;
    }

    @NotNull
    public final List<String> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (List) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.allowedSubProcessList;
    }

    public final int e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 55)) {
            return ((Integer) iPatchRedirector.redirect((short) 55, (Object) this)).intValue();
        }
        return this.bgReportAccountSample;
    }

    public final int f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Integer) iPatchRedirector.redirect((short) 53, (Object) this)).intValue();
        }
        return this.bgReportSample;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.careOldTypeNotification;
    }

    public final boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 57)) {
            return ((Boolean) iPatchRedirector.redirect((short) 57, (Object) this)).booleanValue();
        }
        return this.coldStartLimit;
    }

    public final boolean i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 48)) {
            return ((Boolean) iPatchRedirector.redirect((short) 48, (Object) this)).booleanValue();
        }
        return this.enableForegroundGC;
    }

    public final boolean j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 42)) {
            return ((Boolean) iPatchRedirector.redirect((short) 42, (Object) this)).booleanValue();
        }
        return this.exemptAllPrivateAPI;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        return this.fixDisplayManager;
    }

    public final boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return ((Boolean) iPatchRedirector.redirect((short) 36, (Object) this)).booleanValue();
        }
        return this.fixInputMethodManager;
    }

    public final boolean m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            return ((Boolean) iPatchRedirector.redirect((short) 40, (Object) this)).booleanValue();
        }
        return this.fixPhoneWindow;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 63)) {
            return ((Boolean) iPatchRedirector.redirect((short) 63, (Object) this)).booleanValue();
        }
        return this.fixScene;
    }

    @NotNull
    public final List<String> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.floatWrapperBlackList;
    }

    public final double p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 49)) {
            return ((Double) iPatchRedirector.redirect((short) 49, (Object) this)).doubleValue();
        }
        return this.foregroundGcThreshold;
    }

    public final int q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return ((Integer) iPatchRedirector.redirect((short) 51, (Object) this)).intValue();
        }
        return this.foregroundGcTime;
    }

    @NotNull
    public final List<Pair<Integer, Integer>> s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return this.killTimePeriod;
    }

    public final int t() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        return this.mainGcDelayTime;
    }

    @NotNull
    public String toString() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        String joinToString$default;
        String removePrefix;
        List split$default;
        Object lastOrNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 65)) {
            return (String) iPatchRedirector.redirect((short) 65, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("killSW=");
        sb5.append(this.mainKillSwitch);
        sb5.append(", killDelay=");
        sb5.append(this.mainKillDelayTime);
        sb5.append(", killTHR=");
        sb5.append(this.mainKillMemThreshold);
        sb5.append(", noLoginSW=");
        sb5.append(this.mainKillSwitchForNoLogin);
        sb5.append(", noLoginDelay=");
        sb5.append(this.mainKillDelayTimeForNoLogin);
        sb5.append(", noLoginTHR=");
        sb5.append(this.mainKillMemThresholdForNoLogin);
        sb5.append(", fixLeak=");
        sb5.append(this.fixInputMethodManager);
        sb5.append(", ");
        sb5.append(this.fixDisplayManager);
        sb5.append(", ");
        sb5.append(this.fixPhoneWindow);
        sb5.append(", phoneWinMfr=");
        sb5.append(this.phoneWinMfr);
        sb5.append(", phoneWinDelay=");
        sb5.append(this.phoneWinDelay);
        sb5.append(", gcSW=");
        sb5.append(this.mainGcSwitch);
        sb5.append(", gcDelay=");
        sb5.append(this.mainGcDelayTime);
        sb5.append(", gcTHR=");
        sb5.append(this.mainGcMemThreshold);
        sb5.append(", gcSamp=");
        sb5.append(this.mainGcReportSample);
        sb5.append(", floatBL=");
        List<String> list = this.floatWrapperBlackList;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            split$default = StringsKt__StringsKt.split$default((CharSequence) it.next(), new String[]{"."}, false, 0, 6, (Object) null);
            lastOrNull = CollectionsKt___CollectionsKt.lastOrNull((List<? extends Object>) split$default);
            arrayList.add((String) lastOrNull);
        }
        sb5.append(arrayList);
        sb5.append(", sceneBL=");
        sb5.append(this.mainKillSceneBlackList);
        sb5.append(", justReport=");
        sb5.append(this.mainKillOnlyReport);
        sb5.append(", timePD=");
        sb5.append(this.killTimePeriod);
        sb5.append(", oldNotifySW=");
        sb5.append(this.careOldTypeNotification);
        sb5.append(", subPrcLS=");
        List<String> list2 = this.allowedSubProcessList;
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault2);
        Iterator<T> it5 = list2.iterator();
        while (it5.hasNext()) {
            removePrefix = StringsKt__StringsKt.removePrefix((String) it5.next(), (CharSequence) "com.tencent.mobileqq:");
            arrayList2.add(removePrefix);
        }
        sb5.append(arrayList2);
        sb5.append(", enablePvtApi=");
        sb5.append(this.exemptAllPrivateAPI);
        sb5.append(", fgGcSW=");
        sb5.append(this.enableForegroundGC);
        sb5.append(", bgSam=");
        sb5.append(this.bgReportSample);
        sb5.append(", bgAccSam=");
        sb5.append(this.bgReportAccountSample);
        sb5.append(", procAliveSW=");
        sb5.append(this.procAliveSwitch);
        sb5.append(", procAliveSamp=");
        joinToString$default = ArraysKt___ArraysKt.joinToString$default(this.procAliveSample, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, MainProcConfig$toString$3.INSTANCE, 31, (Object) null);
        sb5.append(joinToString$default);
        sb5.append(", coldStLIM=");
        sb5.append(this.coldStartLimit);
        sb5.append(", fixScene=");
        sb5.append(this.fixScene);
        return sb5.toString();
    }

    public final double u() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            return ((Double) iPatchRedirector.redirect((short) 32, (Object) this)).doubleValue();
        }
        return this.mainGcMemThreshold;
    }

    public final double v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            return ((Double) iPatchRedirector.redirect((short) 34, (Object) this)).doubleValue();
        }
        return this.mainGcReportSample;
    }

    public final boolean w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Boolean) iPatchRedirector.redirect((short) 28, (Object) this)).booleanValue();
        }
        return this.mainGcSwitch;
    }

    public final int x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return this.mainKillDelayTime;
    }

    public final int y() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Integer) iPatchRedirector.redirect((short) 24, (Object) this)).intValue();
        }
        return this.mainKillDelayTimeForNoLogin;
    }

    public final double z() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Double) iPatchRedirector.redirect((short) 6, (Object) this)).doubleValue();
        }
        return this.mainKillMemThreshold;
    }
}
