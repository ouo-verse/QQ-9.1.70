package com.tencent.mobileqq.perf.process.config;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/perf/process/config/f;", "", "", "e", "", "a", "c", "d", "b", "<init>", "()V", "QQPerf-kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f257911a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(32147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            f257911a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!from.containsKey("background_memory_control_debug_json")) {
            return "{\n  \"mainSwitch\": true,\n  \"killUnimportantProcessTimeMs\": 300000,\n  \"processWhiteList\": [\n    \"com.tencent.mobileqq:video\",\n    \"com.tencent.mobileqq\",\n    \"com.tencent.mobileqq:MSF\"\n  ],\n    \"floatWrapperBlackList\": [\n      \"com.tencent.mobileqq.guild.window.GuildAudioChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildWorldChannelFloatWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floatwindow.QQLiveFloatingProxyWrapper\",\n      \"com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager\",\n      \"com.tencent.mobileqq.listentogether.lyrics.LyricsController\"\n    ],\n  \"vendorStrategies\": {\n    \"default\": {\n      \"ceilingKillThresholdMemMB\": 1800,\n      \"ceilingKillDelayTimeMs\": 2000,\n      \"ceilingKillSwitch\": true,\n      \"killUnimportantProcessSwitch\": true\n    }\n  }\n}";
        }
        String decodeString = from.decodeString("background_memory_control_debug_json", "{\n  \"mainSwitch\": true,\n  \"killUnimportantProcessTimeMs\": 300000,\n  \"processWhiteList\": [\n    \"com.tencent.mobileqq:video\",\n    \"com.tencent.mobileqq\",\n    \"com.tencent.mobileqq:MSF\"\n  ],\n    \"floatWrapperBlackList\": [\n      \"com.tencent.mobileqq.guild.window.GuildAudioChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildWorldChannelFloatWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floatwindow.QQLiveFloatingProxyWrapper\",\n      \"com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager\",\n      \"com.tencent.mobileqq.listentogether.lyrics.LyricsController\"\n    ],\n  \"vendorStrategies\": {\n    \"default\": {\n      \"ceilingKillThresholdMemMB\": 1800,\n      \"ceilingKillDelayTimeMs\": 2000,\n      \"ceilingKillSwitch\": true,\n      \"killUnimportantProcessSwitch\": true\n    }\n  }\n}");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(MMKV\u2026T_BACKGROUND_JSON_CONFIG)");
        return decodeString;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!from.containsKey("cache_memory_control_debug_json")) {
            return "{\n    \"cleanImageSwitch\": true,\n    \"cleanCommonSwitch\": true,\n    \"allowSizeCalculator\": true,\n    \"recycleWhenEvicted\": true,\n    \"enableDalvikMemoryTrim\": true,\n    \"useBitmapPool\": false,\n    \"logRemovedDetailInfo\": false,\n    \"imageMaxSizeRatio\": 0.1875,\n    \"imagePoolMaxSizeRatio\": 0.0625,\n    \"commonCacheMaxSizeRatio\": 0.25,\n    \"businessUseFrequencyWeight\": 0.3,\n    \"businessUseTimeWeight\": 0.3,\n    \"businessCacheSizeWeight\": 0.4,\n    \"backgroundCleanRate\": 0.5,\n    \"appLowMemoryCleanRate\": \"0.3,0.3,0\",\n    \"sysLowMemoryCleanRate\": \"0.5,0.3,0.1,0\",\n    \"trimTimeInternalLowMemory\": 60000,\n    \"trimTimeInternalBackground\": 180000,\n    \"trimTimeInternalOther\": 300000,\n    \"classComputerMaxTime\": 1000,\n    \"sameClassComputeMaxTimes\": 5,\n    \"singleClassMaxSize\": 15728640,\n    \"imageCacheRatioBelowAndroid8\": 0.3,\n    \"reportSamplingPercent\": 0.01,\n    \"dalvikMemoryCeilRate\": 0.8\n  }";
        }
        String decodeString = from.decodeString("cache_memory_control_debug_json", "{\n    \"cleanImageSwitch\": true,\n    \"cleanCommonSwitch\": true,\n    \"allowSizeCalculator\": true,\n    \"recycleWhenEvicted\": true,\n    \"enableDalvikMemoryTrim\": true,\n    \"useBitmapPool\": false,\n    \"logRemovedDetailInfo\": false,\n    \"imageMaxSizeRatio\": 0.1875,\n    \"imagePoolMaxSizeRatio\": 0.0625,\n    \"commonCacheMaxSizeRatio\": 0.25,\n    \"businessUseFrequencyWeight\": 0.3,\n    \"businessUseTimeWeight\": 0.3,\n    \"businessCacheSizeWeight\": 0.4,\n    \"backgroundCleanRate\": 0.5,\n    \"appLowMemoryCleanRate\": \"0.3,0.3,0\",\n    \"sysLowMemoryCleanRate\": \"0.5,0.3,0.1,0\",\n    \"trimTimeInternalLowMemory\": 60000,\n    \"trimTimeInternalBackground\": 180000,\n    \"trimTimeInternalOther\": 300000,\n    \"classComputerMaxTime\": 1000,\n    \"sameClassComputeMaxTimes\": 5,\n    \"singleClassMaxSize\": 15728640,\n    \"imageCacheRatioBelowAndroid8\": 0.3,\n    \"reportSamplingPercent\": 0.01,\n    \"dalvikMemoryCeilRate\": 0.8\n  }");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(MMKV\u2026EFAULT_CACHE_JSON_CONFIG)");
        return decodeString;
    }

    @NotNull
    public final String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!from.containsKey("foreground_memory_control_debug_json")) {
            return "{\n    \"preloadSwitch\": true,\n    \"preloadMemFreeRation\": 0.2,\n    \"preloadMemFreeThreshold\": 600,\n    \"killSwitch\": true,\n    \"killFreeMemRatio\": 0.1,\n    \"killCheckInterval\": 5,\n    \"processWhiteList\": [\n      \"com.tencent.mobileqq:qzone\",\n      \"com.tencent.mobileqq:mini\",\n      \"com.tencent.mobileqq:zplan\",\n      \"com.tencent.mobileqq:gameservice\"\n    ]\n  }";
        }
        String decodeString = from.decodeString("foreground_memory_control_debug_json", "{\n    \"preloadSwitch\": true,\n    \"preloadMemFreeRation\": 0.2,\n    \"preloadMemFreeThreshold\": 600,\n    \"killSwitch\": true,\n    \"killFreeMemRatio\": 0.1,\n    \"killCheckInterval\": 5,\n    \"processWhiteList\": [\n      \"com.tencent.mobileqq:qzone\",\n      \"com.tencent.mobileqq:mini\",\n      \"com.tencent.mobileqq:zplan\",\n      \"com.tencent.mobileqq:gameservice\"\n    ]\n  }");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(MMKV\u2026T_FOREGROUND_JSON_CONFIG)");
        return decodeString;
    }

    @NotNull
    public final String d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        if (!from.containsKey("main_proc_memory_control_debug_json")) {
            return "{\n    \"mainProcessKillSwitch\": true,\n    \"mainKillDelayTime\": 360000,\n    \"mainKillMemThreshold\": 0.7,\n    \"mainProcessKillSwitchForNoLogin\": true,\n    \"mainKillDelayTimeForNoLogin\": 180000,\n    \"mainKillMemThresholdForNoLogin\": 0.3,\n    \"mainGcSwitch\": true,\n    \"mainGcDelayTime\": 60000,\n    \"mainGcMemThreshold\": 0.5,\n    \"floatWrapperBlackList\": [\n      \"com.tencent.mobileqq.guild.window.GuildAudioChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildWorldChannelFloatWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floatwindow.QQLiveFloatingProxyWrapper\",\n      \"com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager\",\n      \"com.tencent.mobileqq.listentogether.lyrics.LyricsController\"\n    ],\n    \"sceneBlackList\": [],\n    \"mainKillOnlyReport\": false,\n    \"screenLockInterval\": 3000,\n    \"allKillTimePeriod\": [\"0-24\"],\n    \"careOldTypeNotification\": true,\n    \"allowedSubProcessList\": [\"com.tencent.mobileqq:video\"]\n  }";
        }
        String decodeString = from.decodeString("main_proc_memory_control_debug_json", "{\n    \"mainProcessKillSwitch\": true,\n    \"mainKillDelayTime\": 360000,\n    \"mainKillMemThreshold\": 0.7,\n    \"mainProcessKillSwitchForNoLogin\": true,\n    \"mainKillDelayTimeForNoLogin\": 180000,\n    \"mainKillMemThresholdForNoLogin\": 0.3,\n    \"mainGcSwitch\": true,\n    \"mainGcDelayTime\": 60000,\n    \"mainGcMemThreshold\": 0.5,\n    \"floatWrapperBlackList\": [\n      \"com.tencent.mobileqq.guild.window.GuildAudioChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildLiveChannelFloatWrapper\",\n      \"com.tencent.mobileqq.guild.window.GuildWorldChannelFloatWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floatwindow.QQLiveFloatingProxyWrapper\",\n      \"com.tencent.mobileqq.qqlive.widget.floatwindow.QQLiveFloatWindowWrapper\",\n      \"com.tencent.timi.game.liveroom.impl.room.floating.TGLiveFloatManager\",\n      \"com.tencent.mobileqq.listentogether.lyrics.LyricsController\"\n    ],\n    \"sceneBlackList\": [],\n    \"mainKillOnlyReport\": false,\n    \"screenLockInterval\": 3000,\n    \"allKillTimePeriod\": [\"0-24\"],\n    \"careOldTypeNotification\": true,\n    \"allowedSubProcessList\": [\"com.tencent.mobileqq:video\"]\n  }");
        Intrinsics.checkNotNullExpressionValue(decodeString, "entity.decodeString(MMKV\u2026LT_MAIN_PROC_JSON_CONFIG)");
        return decodeString;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        MMKVOptionEntity from = QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(from, "from(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
        return from.decodeBool("memory_control_debug_switch_v2", false);
    }
}
