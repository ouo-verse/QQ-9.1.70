package com.tencent.mobileqq.startup.control;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.startup.control.a;
import com.tencent.qphone.base.util.QLog;
import com.tencent.state.perf.PerfMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 \u00032\u00020\u0001:\u0002\u0014\u000fB\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u0007\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u001c\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\nR\u001a\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/startup/control/MicroStep;", "", "", "b", "", "", "removeStepIds", "c", "Lcom/tencent/mobileqq/startup/control/MicroStep$BusinessTag;", "businessTag", "Lkotlin/Function0;", "task", "Lcom/tencent/mobileqq/startup/control/a;", "d", "", "a", "Ljava/util/List;", "stepIds", "<init>", "()V", "BusinessTag", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class MicroStep {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    private static volatile int f289684c;

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    private static HashMap<Integer, AsyncStep<Automator>> f289685d;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final List<Integer> stepIds;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\bZ\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*j\u0002\b+j\u0002\b,j\u0002\b-j\u0002\b.j\u0002\b/j\u0002\b0j\u0002\b1j\u0002\b2j\u0002\b3j\u0002\b4j\u0002\b5j\u0002\b6j\u0002\b7j\u0002\b8j\u0002\b9j\u0002\b:j\u0002\b;j\u0002\b<j\u0002\b=j\u0002\b>j\u0002\b?j\u0002\b@j\u0002\bAj\u0002\bBj\u0002\bCj\u0002\bDj\u0002\bEj\u0002\bFj\u0002\bGj\u0002\bHj\u0002\bIj\u0002\bJj\u0002\bKj\u0002\bLj\u0002\bMj\u0002\bNj\u0002\bOj\u0002\bPj\u0002\bQj\u0002\bRj\u0002\bSj\u0002\bTj\u0002\bUj\u0002\bVj\u0002\bWj\u0002\bXj\u0002\bYj\u0002\bZ\u00a8\u0006["}, d2 = {"Lcom/tencent/mobileqq/startup/control/MicroStep$BusinessTag;", "", "(Ljava/lang/String;I)V", HippyQQConstants.HIPPY_TAG, "BasicCrash", "BasicTroop", "BasicPerfNetflow", "BasicPerfMemory", "BasicConversation", "BasicHardCoderSoUpdate", "BasicDexMonitor", "BasicRealNameCheck", "BasicSplashRecord", "GuildTabSpec", "ZPlanConfig", "BasicMiBaoChange", "GuildMsgFocusReport", "TABInit", "NetFlow", "Message", PerfMonitor.TAG, "HardCoderSoUpdate", "DexMonitor", "Guild", "MatchFriend", "MiniMsgTab", "GameCenterCheck", "BasicPandoraEventReport", "AdAndHealthStepReport", "BasicPreDownload", "VASVipData", "VASGetFunCallData", "VASSelfVipData", "PPCLoginAuth", "BasicMessage", "FTS", "RelationGetMatchFriendEntrance", "RelationInitExtensionInfo", "Relation0x5ebForColdStart", "BasicProxyInit", "BasicColorNoteInit", "ColorNoteGetRecentSwitch", "NTMsgMigration", "PskeyPreload", "MsfTicketRefresh", "NewerGuideBanner", "MsfSDK", "MiniDataPull", "BasicRichText", "SubAccountSpecialCare", "MsgNotifyPushDialogTask", "NotificationConfigParser", "ZhuoXusConfigParser", "NTTraceReport", "BmqqInit", "GdtAd", "SafeO3SDK", "PreReflection", "PreCreateRuntimeService", "MqqInitConfig", "QLogGrayVersionColorExpired", "YYB", "MMKVDelayedEvents", "PreDownloadTbs", "RuntimeConfigLoad", "MsgBackupCleanRootPath", "NotificationConfigReport", "BasicAccountPhone", "IssueFix", "GroupVideoPreload", "Shiply", "StartupClassDump", "QuickApp", "AddShortCut", "SubAccountServiceInit", "OnlineStatusInit", "ReportGuid", "NoPasswordCheck", "ReportProcessExit", "MiniGame", "AvatarNotifySyncEnd", "TBSTool", "WVMainProc", "PYMK", "PublicAccountInit", "StudyMode", "FlashTransferResumeFailedTransfer", "FlashTransferServiceInit", "WxMiniApp", "WtUpgradeReport", "QavInit", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes18.dex */
    public static final class BusinessTag {
        private static final /* synthetic */ BusinessTag[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final BusinessTag AdAndHealthStepReport;
        public static final BusinessTag AddShortCut;
        public static final BusinessTag AvatarNotifySyncEnd;
        public static final BusinessTag BasicAccountPhone;
        public static final BusinessTag BasicColorNoteInit;
        public static final BusinessTag BasicConversation;
        public static final BusinessTag BasicCrash;
        public static final BusinessTag BasicDexMonitor;
        public static final BusinessTag BasicHardCoderSoUpdate;
        public static final BusinessTag BasicMessage;
        public static final BusinessTag BasicMiBaoChange;
        public static final BusinessTag BasicPandoraEventReport;
        public static final BusinessTag BasicPerfMemory;
        public static final BusinessTag BasicPerfNetflow;
        public static final BusinessTag BasicPreDownload;
        public static final BusinessTag BasicProxyInit;
        public static final BusinessTag BasicRealNameCheck;
        public static final BusinessTag BasicRichText;
        public static final BusinessTag BasicSplashRecord;
        public static final BusinessTag BasicTroop;
        public static final BusinessTag BmqqInit;
        public static final BusinessTag ColorNoteGetRecentSwitch;
        public static final BusinessTag DexMonitor;
        public static final BusinessTag FTS;
        public static final BusinessTag FlashTransferResumeFailedTransfer;
        public static final BusinessTag FlashTransferServiceInit;
        public static final BusinessTag GameCenterCheck;
        public static final BusinessTag GdtAd;
        public static final BusinessTag GroupVideoPreload;
        public static final BusinessTag Guild;
        public static final BusinessTag GuildMsgFocusReport;
        public static final BusinessTag GuildTabSpec;
        public static final BusinessTag HardCoderSoUpdate;
        public static final BusinessTag Hippy;
        public static final BusinessTag IssueFix;
        public static final BusinessTag MMKVDelayedEvents;
        public static final BusinessTag MatchFriend;
        public static final BusinessTag Message;
        public static final BusinessTag MiniDataPull;
        public static final BusinessTag MiniGame;
        public static final BusinessTag MiniMsgTab;
        public static final BusinessTag MqqInitConfig;
        public static final BusinessTag MsfSDK;
        public static final BusinessTag MsfTicketRefresh;
        public static final BusinessTag MsgBackupCleanRootPath;
        public static final BusinessTag MsgNotifyPushDialogTask;
        public static final BusinessTag NTMsgMigration;
        public static final BusinessTag NTTraceReport;
        public static final BusinessTag NetFlow;
        public static final BusinessTag NewerGuideBanner;
        public static final BusinessTag NoPasswordCheck;
        public static final BusinessTag NotificationConfigParser;
        public static final BusinessTag NotificationConfigReport;
        public static final BusinessTag OnlineStatusInit;
        public static final BusinessTag PPCLoginAuth;
        public static final BusinessTag PYMK;
        public static final BusinessTag PerfMonitor;
        public static final BusinessTag PreCreateRuntimeService;
        public static final BusinessTag PreDownloadTbs;
        public static final BusinessTag PreReflection;
        public static final BusinessTag PskeyPreload;
        public static final BusinessTag PublicAccountInit;
        public static final BusinessTag QLogGrayVersionColorExpired;
        public static final BusinessTag QavInit;
        public static final BusinessTag QuickApp;
        public static final BusinessTag Relation0x5ebForColdStart;
        public static final BusinessTag RelationGetMatchFriendEntrance;
        public static final BusinessTag RelationInitExtensionInfo;
        public static final BusinessTag ReportGuid;
        public static final BusinessTag ReportProcessExit;
        public static final BusinessTag RuntimeConfigLoad;
        public static final BusinessTag SafeO3SDK;
        public static final BusinessTag Shiply;
        public static final BusinessTag StartupClassDump;
        public static final BusinessTag StudyMode;
        public static final BusinessTag SubAccountServiceInit;
        public static final BusinessTag SubAccountSpecialCare;
        public static final BusinessTag TABInit;
        public static final BusinessTag TBSTool;
        public static final BusinessTag VASGetFunCallData;
        public static final BusinessTag VASSelfVipData;
        public static final BusinessTag VASVipData;
        public static final BusinessTag WVMainProc;
        public static final BusinessTag WtUpgradeReport;
        public static final BusinessTag WxMiniApp;
        public static final BusinessTag YYB;
        public static final BusinessTag ZPlanConfig;
        public static final BusinessTag ZhuoXusConfigParser;

        private static final /* synthetic */ BusinessTag[] $values() {
            return new BusinessTag[]{Hippy, BasicCrash, BasicTroop, BasicPerfNetflow, BasicPerfMemory, BasicConversation, BasicHardCoderSoUpdate, BasicDexMonitor, BasicRealNameCheck, BasicSplashRecord, GuildTabSpec, ZPlanConfig, BasicMiBaoChange, GuildMsgFocusReport, TABInit, NetFlow, Message, PerfMonitor, HardCoderSoUpdate, DexMonitor, Guild, MatchFriend, MiniMsgTab, GameCenterCheck, BasicPandoraEventReport, AdAndHealthStepReport, BasicPreDownload, VASVipData, VASGetFunCallData, VASSelfVipData, PPCLoginAuth, BasicMessage, FTS, RelationGetMatchFriendEntrance, RelationInitExtensionInfo, Relation0x5ebForColdStart, BasicProxyInit, BasicColorNoteInit, ColorNoteGetRecentSwitch, NTMsgMigration, PskeyPreload, MsfTicketRefresh, NewerGuideBanner, MsfSDK, MiniDataPull, BasicRichText, SubAccountSpecialCare, MsgNotifyPushDialogTask, NotificationConfigParser, ZhuoXusConfigParser, NTTraceReport, BmqqInit, GdtAd, SafeO3SDK, PreReflection, PreCreateRuntimeService, MqqInitConfig, QLogGrayVersionColorExpired, YYB, MMKVDelayedEvents, PreDownloadTbs, RuntimeConfigLoad, MsgBackupCleanRootPath, NotificationConfigReport, BasicAccountPhone, IssueFix, GroupVideoPreload, Shiply, StartupClassDump, QuickApp, AddShortCut, SubAccountServiceInit, OnlineStatusInit, ReportGuid, NoPasswordCheck, ReportProcessExit, MiniGame, AvatarNotifySyncEnd, TBSTool, WVMainProc, PYMK, PublicAccountInit, StudyMode, FlashTransferResumeFailedTransfer, FlashTransferServiceInit, WxMiniApp, WtUpgradeReport, QavInit};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61387);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            Hippy = new BusinessTag(HippyQQConstants.HIPPY_TAG, 0);
            BasicCrash = new BusinessTag("BasicCrash", 1);
            BasicTroop = new BusinessTag("BasicTroop", 2);
            BasicPerfNetflow = new BusinessTag("BasicPerfNetflow", 3);
            BasicPerfMemory = new BusinessTag("BasicPerfMemory", 4);
            BasicConversation = new BusinessTag("BasicConversation", 5);
            BasicHardCoderSoUpdate = new BusinessTag("BasicHardCoderSoUpdate", 6);
            BasicDexMonitor = new BusinessTag("BasicDexMonitor", 7);
            BasicRealNameCheck = new BusinessTag("BasicRealNameCheck", 8);
            BasicSplashRecord = new BusinessTag("BasicSplashRecord", 9);
            GuildTabSpec = new BusinessTag("GuildTabSpec", 10);
            ZPlanConfig = new BusinessTag("ZPlanConfig", 11);
            BasicMiBaoChange = new BusinessTag("BasicMiBaoChange", 12);
            GuildMsgFocusReport = new BusinessTag("GuildMsgFocusReport", 13);
            TABInit = new BusinessTag("TABInit", 14);
            NetFlow = new BusinessTag("NetFlow", 15);
            Message = new BusinessTag("Message", 16);
            PerfMonitor = new BusinessTag(PerfMonitor.TAG, 17);
            HardCoderSoUpdate = new BusinessTag("HardCoderSoUpdate", 18);
            DexMonitor = new BusinessTag("DexMonitor", 19);
            Guild = new BusinessTag("Guild", 20);
            MatchFriend = new BusinessTag("MatchFriend", 21);
            MiniMsgTab = new BusinessTag("MiniMsgTab", 22);
            GameCenterCheck = new BusinessTag("GameCenterCheck", 23);
            BasicPandoraEventReport = new BusinessTag("BasicPandoraEventReport", 24);
            AdAndHealthStepReport = new BusinessTag("AdAndHealthStepReport", 25);
            BasicPreDownload = new BusinessTag("BasicPreDownload", 26);
            VASVipData = new BusinessTag("VASVipData", 27);
            VASGetFunCallData = new BusinessTag("VASGetFunCallData", 28);
            VASSelfVipData = new BusinessTag("VASSelfVipData", 29);
            PPCLoginAuth = new BusinessTag("PPCLoginAuth", 30);
            BasicMessage = new BusinessTag("BasicMessage", 31);
            FTS = new BusinessTag("FTS", 32);
            RelationGetMatchFriendEntrance = new BusinessTag("RelationGetMatchFriendEntrance", 33);
            RelationInitExtensionInfo = new BusinessTag("RelationInitExtensionInfo", 34);
            Relation0x5ebForColdStart = new BusinessTag("Relation0x5ebForColdStart", 35);
            BasicProxyInit = new BusinessTag("BasicProxyInit", 36);
            BasicColorNoteInit = new BusinessTag("BasicColorNoteInit", 37);
            ColorNoteGetRecentSwitch = new BusinessTag("ColorNoteGetRecentSwitch", 38);
            NTMsgMigration = new BusinessTag("NTMsgMigration", 39);
            PskeyPreload = new BusinessTag("PskeyPreload", 40);
            MsfTicketRefresh = new BusinessTag("MsfTicketRefresh", 41);
            NewerGuideBanner = new BusinessTag("NewerGuideBanner", 42);
            MsfSDK = new BusinessTag("MsfSDK", 43);
            MiniDataPull = new BusinessTag("MiniDataPull", 44);
            BasicRichText = new BusinessTag("BasicRichText", 45);
            SubAccountSpecialCare = new BusinessTag("SubAccountSpecialCare", 46);
            MsgNotifyPushDialogTask = new BusinessTag("MsgNotifyPushDialogTask", 47);
            NotificationConfigParser = new BusinessTag("NotificationConfigParser", 48);
            ZhuoXusConfigParser = new BusinessTag("ZhuoXusConfigParser", 49);
            NTTraceReport = new BusinessTag("NTTraceReport", 50);
            BmqqInit = new BusinessTag("BmqqInit", 51);
            GdtAd = new BusinessTag("GdtAd", 52);
            SafeO3SDK = new BusinessTag("SafeO3SDK", 53);
            PreReflection = new BusinessTag("PreReflection", 54);
            PreCreateRuntimeService = new BusinessTag("PreCreateRuntimeService", 55);
            MqqInitConfig = new BusinessTag("MqqInitConfig", 56);
            QLogGrayVersionColorExpired = new BusinessTag("QLogGrayVersionColorExpired", 57);
            YYB = new BusinessTag("YYB", 58);
            MMKVDelayedEvents = new BusinessTag("MMKVDelayedEvents", 59);
            PreDownloadTbs = new BusinessTag("PreDownloadTbs", 60);
            RuntimeConfigLoad = new BusinessTag("RuntimeConfigLoad", 61);
            MsgBackupCleanRootPath = new BusinessTag("MsgBackupCleanRootPath", 62);
            NotificationConfigReport = new BusinessTag("NotificationConfigReport", 63);
            BasicAccountPhone = new BusinessTag("BasicAccountPhone", 64);
            IssueFix = new BusinessTag("IssueFix", 65);
            GroupVideoPreload = new BusinessTag("GroupVideoPreload", 66);
            Shiply = new BusinessTag("Shiply", 67);
            StartupClassDump = new BusinessTag("StartupClassDump", 68);
            QuickApp = new BusinessTag("QuickApp", 69);
            AddShortCut = new BusinessTag("AddShortCut", 70);
            SubAccountServiceInit = new BusinessTag("SubAccountServiceInit", 71);
            OnlineStatusInit = new BusinessTag("OnlineStatusInit", 72);
            ReportGuid = new BusinessTag("ReportGuid", 73);
            NoPasswordCheck = new BusinessTag("NoPasswordCheck", 74);
            ReportProcessExit = new BusinessTag("ReportProcessExit", 75);
            MiniGame = new BusinessTag("MiniGame", 76);
            AvatarNotifySyncEnd = new BusinessTag("AvatarNotifySyncEnd", 77);
            TBSTool = new BusinessTag("TBSTool", 78);
            WVMainProc = new BusinessTag("WVMainProc", 79);
            PYMK = new BusinessTag("PYMK", 80);
            PublicAccountInit = new BusinessTag("PublicAccountInit", 81);
            StudyMode = new BusinessTag("StudyMode", 82);
            FlashTransferResumeFailedTransfer = new BusinessTag("FlashTransferResumeFailedTransfer", 83);
            FlashTransferServiceInit = new BusinessTag("FlashTransferServiceInit", 84);
            WxMiniApp = new BusinessTag("WxMiniApp", 85);
            WtUpgradeReport = new BusinessTag("WtUpgradeReport", 86);
            QavInit = new BusinessTag("QavInit", 87);
            $VALUES = $values();
        }

        BusinessTag(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static BusinessTag valueOf(String str) {
            return (BusinessTag) Enum.valueOf(BusinessTag.class, str);
        }

        public static BusinessTag[] values() {
            return (BusinessTag[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\b\u0010\b\u001a\u00020\u0007H\u0007R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR>\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\fj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004`\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/startup/control/MicroStep$a;", "", "", "stepId", "Lcom/tencent/mobileqq/app/automator/AsyncStep;", "Lcom/tencent/mobileqq/app/automator/Automator;", "b", "", "a", "MICRO_STEP_ID_BASE", "I", "microStepIdBase", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "stepIdToMicroStep", "Ljava/util/HashMap;", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.startup.control.MicroStep$a, reason: from kotlin metadata */
    /* loaded from: classes18.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
                return;
            }
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) defaultConstructorMarker);
        }

        @JvmStatic
        public final void a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                MicroStep.f289685d.clear();
            }
        }

        @Nullable
        public final AsyncStep<Automator> b(int stepId) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (AsyncStep) iPatchRedirector.redirect((short) 2, (Object) this, stepId);
            }
            return (AsyncStep) MicroStep.f289685d.remove(Integer.valueOf(stepId));
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61395);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        f289684c = 1000;
        f289685d = new HashMap<>();
    }

    public MicroStep() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.stepIds = new ArrayList();
        }
    }

    public final void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        Iterator<T> it = this.stepIds.iterator();
        while (it.hasNext()) {
            f289685d.remove(Integer.valueOf(((Number) it.next()).intValue()));
        }
    }

    public final void c(@NotNull List<Integer> removeStepIds) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) removeStepIds);
            return;
        }
        Intrinsics.checkNotNullParameter(removeStepIds, "removeStepIds");
        Iterator<T> it = removeStepIds.iterator();
        while (it.hasNext()) {
            f289685d.remove(Integer.valueOf(((Number) it.next()).intValue()));
        }
    }

    @NotNull
    public final a d(@NotNull BusinessTag businessTag, @NotNull final Function0<Unit> task) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (a) iPatchRedirector.redirect((short) 4, (Object) this, (Object) businessTag, (Object) task);
        }
        Intrinsics.checkNotNullParameter(businessTag, "businessTag");
        Intrinsics.checkNotNullParameter(task, "task");
        int i3 = f289684c;
        f289684c = i3 + 1;
        this.stepIds.add(Integer.valueOf(i3));
        HashMap<Integer, AsyncStep<Automator>> hashMap = f289685d;
        Integer valueOf = Integer.valueOf(i3);
        AsyncStep<Automator> asyncStep = new AsyncStep<Automator>(task) { // from class: com.tencent.mobileqq.startup.control.MicroStep$run$1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ Function0<Unit> f289687d;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                this.f289687d = task;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) task);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.mobileqq.app.automator.AsyncStep
            public int doStep() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector2.redirect((short) 2, (Object) this)).intValue();
                }
                if (!((Automator) this.mAutomator).D) {
                    this.f289687d.invoke();
                    return 7;
                }
                QLog.d("IAutomator", 1, "MicroStep[" + this.mName + "] not execute for automator destroyed!");
                return 7;
            }
        };
        asyncStep.mName = businessTag.name() + "_" + i3;
        hashMap.put(valueOf, asyncStep);
        return new a.c(i3);
    }
}
