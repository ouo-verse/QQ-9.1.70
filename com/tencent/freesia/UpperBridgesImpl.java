package com.tencent.freesia;

import android.os.Build;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010)\u001a\u00020(\u0012\u0006\u0010$\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020!\u0012\u0006\u0010&\u001a\u00020\r\u0012\u0006\u00106\u001a\u00020\u0010\u0012\u0006\u00104\u001a\u00020\u0013\u0012\u0006\u0010/\u001a\u00020\b\u0012\u0006\u0010+\u001a\u00020\u0018\u0012\u0006\u0010-\u001a\u00020\u001e\u00a2\u0006\u0004\b8\u00109J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H\u0016\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\bH\u0016\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001c\u001a\u00020\u001bH\u0016\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001f\u001a\u00020\u001eH\u0016\u00a2\u0006\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020!8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010$\u001a\u00020\u00058\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010&\u001a\u00020\r8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010)\u001a\u00020(8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\u00188\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010-\u001a\u00020\u001e8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010/\u001a\u00020\b8\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u00100R\"\u00102\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\n018\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R\u0016\u00104\u001a\u00020\u00138\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0016\u00106\u001a\u00020\u00108\u0002@\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006:"}, d2 = {"Lcom/tencent/freesia/UpperBridgesImpl;", "Lcom/tencent/freesia/UpperBridges;", "Lcom/tencent/freesia/ConfigParserBridge;", "getParserBridge", "()Lcom/tencent/freesia/ConfigParserBridge;", "Lcom/tencent/freesia/MSFServletBridge;", "getMSFBridge", "()Lcom/tencent/freesia/MSFServletBridge;", "", "uin", "Lcom/tencent/freesia/KVBridgeWrapper;", "getKVBridge", "(Ljava/lang/String;)Lcom/tencent/freesia/KVBridgeWrapper;", "Lcom/tencent/freesia/ILogger;", "getLogger", "()Lcom/tencent/freesia/ILogger;", "Lcom/tencent/freesia/CustomRuleBridge;", "getCustomRuleBridge", "()Lcom/tencent/freesia/CustomRuleBridge;", "Lcom/tencent/freesia/HTTPBridge;", "getHTTPBridge", "()Lcom/tencent/freesia/HTTPBridge;", "getLargeFileRootDir", "()Ljava/lang/String;", "Lcom/tencent/freesia/BeaconBridge;", "getBeaconBridge", "()Lcom/tencent/freesia/BeaconBridge;", "Lcom/tencent/freesia/DeviceInfo;", "getDeviceInfo", "()Lcom/tencent/freesia/DeviceInfo;", "Lcom/tencent/freesia/Tick;", "getTick", "()Lcom/tencent/freesia/Tick;", "Lcom/tencent/freesia/IKVBridgeCreator;", "kvCreator", "Lcom/tencent/freesia/IKVBridgeCreator;", "msf", "Lcom/tencent/freesia/MSFServletBridge;", "logger", "Lcom/tencent/freesia/ILogger;", "Lcom/tencent/freesia/ConfigParserBridgeImpl;", "parserBridge", "Lcom/tencent/freesia/ConfigParserBridgeImpl;", "beaconBridge", "Lcom/tencent/freesia/BeaconBridge;", "tick", "Lcom/tencent/freesia/Tick;", "rootDir", "Ljava/lang/String;", "Ljava/util/concurrent/ConcurrentHashMap;", "kvCache", "Ljava/util/concurrent/ConcurrentHashMap;", "httpBridge", "Lcom/tencent/freesia/HTTPBridge;", "customRuleBridge", "Lcom/tencent/freesia/CustomRuleBridge;", "<init>", "(Lcom/tencent/freesia/ConfigParserBridgeImpl;Lcom/tencent/freesia/MSFServletBridge;Lcom/tencent/freesia/IKVBridgeCreator;Lcom/tencent/freesia/ILogger;Lcom/tencent/freesia/CustomRuleBridge;Lcom/tencent/freesia/HTTPBridge;Ljava/lang/String;Lcom/tencent/freesia/BeaconBridge;Lcom/tencent/freesia/Tick;)V", "unitedconfig-android_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public abstract class UpperBridgesImpl implements UpperBridges {
    static IPatchRedirector $redirector_;
    private final BeaconBridge beaconBridge;
    private final CustomRuleBridge customRuleBridge;
    private final HTTPBridge httpBridge;
    private final ConcurrentHashMap<String, KVBridgeWrapper> kvCache;
    private final IKVBridgeCreator kvCreator;
    private final ILogger logger;
    private final MSFServletBridge msf;
    private final ConfigParserBridgeImpl parserBridge;
    private final String rootDir;
    private final Tick tick;

    public UpperBridgesImpl(@NotNull ConfigParserBridgeImpl parserBridge, @NotNull MSFServletBridge msf2, @NotNull IKVBridgeCreator kvCreator, @NotNull ILogger logger, @NotNull CustomRuleBridge customRuleBridge, @NotNull HTTPBridge httpBridge, @NotNull String rootDir, @NotNull BeaconBridge beaconBridge, @NotNull Tick tick) {
        Intrinsics.checkNotNullParameter(parserBridge, "parserBridge");
        Intrinsics.checkNotNullParameter(msf2, "msf");
        Intrinsics.checkNotNullParameter(kvCreator, "kvCreator");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(customRuleBridge, "customRuleBridge");
        Intrinsics.checkNotNullParameter(httpBridge, "httpBridge");
        Intrinsics.checkNotNullParameter(rootDir, "rootDir");
        Intrinsics.checkNotNullParameter(beaconBridge, "beaconBridge");
        Intrinsics.checkNotNullParameter(tick, "tick");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, parserBridge, msf2, kvCreator, logger, customRuleBridge, httpBridge, rootDir, beaconBridge, tick);
            return;
        }
        this.parserBridge = parserBridge;
        this.msf = msf2;
        this.kvCreator = kvCreator;
        this.logger = logger;
        this.customRuleBridge = customRuleBridge;
        this.httpBridge = httpBridge;
        this.rootDir = rootDir;
        this.beaconBridge = beaconBridge;
        this.tick = tick;
        this.kvCache = new ConcurrentHashMap<>();
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public BeaconBridge getBeaconBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (BeaconBridge) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.beaconBridge;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public CustomRuleBridge getCustomRuleBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (CustomRuleBridge) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.customRuleBridge;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public DeviceInfo getDeviceInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (DeviceInfo) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return new DeviceInfo(Build.BRAND, DeviceInfoMonitor.getModel(), new OS(OSType.AND, String.valueOf(Build.VERSION.SDK_INT)));
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public HTTPBridge getHTTPBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (HTTPBridge) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.httpBridge;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public String getLargeFileRootDir() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.rootDir;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public ILogger getLogger() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ILogger) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.logger;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public MSFServletBridge getMSFBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MSFServletBridge) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.msf;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public ConfigParserBridge getParserBridge() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (ConfigParserBridge) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.parserBridge;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public Tick getTick() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (Tick) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.tick;
    }

    @Override // com.tencent.freesia.UpperBridges
    @NotNull
    public KVBridgeWrapper getKVBridge(@NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (KVBridgeWrapper) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uin);
        }
        Intrinsics.checkNotNullParameter(uin, "uin");
        KVBridgeWrapper kVBridgeWrapper = this.kvCache.get(uin);
        if (kVBridgeWrapper != null) {
            return kVBridgeWrapper;
        }
        KVBridgeWrapper kVBridgeWrapper2 = new KVBridgeWrapper(uin, this.kvCreator.create(uin));
        this.kvCache.put(uin, kVBridgeWrapper2);
        return kVBridgeWrapper2;
    }
}
