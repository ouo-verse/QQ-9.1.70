package com.tencent.mobileqq.qqlive.sail.ui.player;

import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamDefinition;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000=\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\b\u0006*\u0001\u001c\u0018\u0000 \u00042\u00020\u0001:\u0001\u000eB\u0017\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\u0006\u0010\u0014\u001a\u00020\b\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016J\b\u0010\u000f\u001a\u00020\u0006H\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0014\u0010\u0014\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/j;", "Lcom/tencent/mobileqq/qqlive/sail/ui/player/a;", "", "e", "f", "g", "", "init", "", "selectedPosition", "fromPosition", "b", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamDefinition;", "definition", "a", QCircleLpReportDc05507.KEY_CLEAR, "", "J", "roomId", "I", "position", "Lcom/tencent/mobileqq/qqlive/sail/ui/player/b;", "c", "Lcom/tencent/mobileqq/qqlive/sail/ui/player/b;", "preloadConfig", "d", "Z", "isWeakNetwork", "com/tencent/mobileqq/qqlive/sail/ui/player/j$b", "Lcom/tencent/mobileqq/qqlive/sail/ui/player/j$b;", "weakNetworkHandler", "<init>", "(JI)V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class j implements a {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final long roomId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int position;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.qqlive.sail.ui.player.b preloadConfig;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isWeakNetwork;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b weakNetworkHandler;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/player/j$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.player.j$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/player/j$b", "Lcom/tencent/mobileqq/msf/sdk/handler/IWeakNetStatusHandler;", "", "weakReason", "", "onNormalToWeakNet", "lastWeakReason", "onWeakNetToNormal", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IWeakNetStatusHandler {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) j.this);
            }
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onNormalToWeakNet(int weakReason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, weakReason);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|UniDirectionalPreloadStrategy", "onNormalToWeakNet", "roomId=" + j.this.roomId + ", weak network, reason=" + weakReason);
            j.this.isWeakNetwork = true;
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.IWeakNetStatusHandler
        public void onWeakNetToNormal(int lastWeakReason) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, lastWeakReason);
                return;
            }
            AegisLogger.INSTANCE.i("Audience|UniDirectionalPreloadStrategy", "onWeakNetToNormal", "roomId=" + j.this.roomId + ", normal network, lastWeakReason=" + lastWeakReason);
            j.this.isWeakNetwork = false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52868);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j(long j3, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Long.valueOf(j3), Integer.valueOf(i3));
            return;
        }
        this.roomId = j3;
        this.position = i3;
        this.preloadConfig = com.tencent.mobileqq.qqlive.sail.ui.player.b.INSTANCE.a();
        this.weakNetworkHandler = new b();
    }

    private final boolean e() {
        if (g() && f()) {
            return true;
        }
        return false;
    }

    private final boolean f() {
        boolean z16;
        if (c.f273028a.a().getValue() <= this.preloadConfig.b()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16) {
            AegisLogger.INSTANCE.i("Audience|UniDirectionalPreloadStrategy", "isDefinitionEnable", "roomId=" + this.roomId + ", not allow");
        }
        return z16;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0071, code lost:
    
        if (r7.equals(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus.G_4) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00ad, code lost:
    
        if (r6 < 3) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00af, code lost:
    
        r7 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x007b, code lost:
    
        if (r7.equals("5G") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        if (r6 < 4) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0085, code lost:
    
        if (r7.equals("wifi") == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0091, code lost:
    
        r7 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008f, code lost:
    
        if (r7.equals(com.tencent.ams.adcore.mma.api.Global.TRACKING_WIFI) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009a, code lost:
    
        if (r7.equals(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.bridge.info.QADNetStatus.G_5) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00a8, code lost:
    
        if (r7.equals("4G") == false) goto L45;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final boolean g() {
        boolean isBlank;
        boolean z16;
        boolean z17;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.preloadConfig.c());
        boolean z18 = false;
        if (isBlank) {
            AegisLogger.INSTANCE.i("Audience|UniDirectionalPreloadStrategy", "isNetworkEnable", "roomId=" + this.roomId + ", not allow, no network config");
            return false;
        }
        if (AppNetConnInfo.isWifiConn() && !this.isWeakNetwork) {
            z16 = true;
        } else {
            z16 = false;
        }
        int mobileInfo = AppNetConnInfo.getMobileInfo();
        String c16 = this.preloadConfig.c();
        int hashCode = c16.hashCode();
        if (hashCode != 1683) {
            if (hashCode != 1746) {
                if (hashCode != 2664213) {
                    if (hashCode != 3649301) {
                        if (hashCode != 1714) {
                            if (hashCode == 1715) {
                            }
                        }
                    }
                    z17 = false;
                }
            }
            if (z16 || z17) {
                z18 = true;
            }
            if (!z18) {
                AegisLogger.INSTANCE.i("Audience|UniDirectionalPreloadStrategy", "isNetworkEnable", "roomId=" + this.roomId + ", mobile=" + mobileInfo + ", isWeakNetwork=" + this.isWeakNetwork);
            }
            return z18;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.ui.player.a
    public void a(@NotNull StreamDefinition definition) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) definition);
        } else {
            Intrinsics.checkNotNullParameter(definition, "definition");
            c.f273028a.b(definition);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.ui.player.a
    public boolean b(int selectedPosition, int fromPosition) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z17 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(selectedPosition), Integer.valueOf(fromPosition))).booleanValue();
        }
        if (!e() || Math.abs(this.position - selectedPosition) > this.preloadConfig.a()) {
            return false;
        }
        if (selectedPosition > fromPosition) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = this.position;
        if (i3 > selectedPosition) {
            z17 = true;
        }
        boolean z18 = !(z16 ^ z17);
        if (z18) {
            AegisLogger.INSTANCE.i("Audience|UniDirectionalPreloadStrategy", "canPreload", "roomId=" + this.roomId + " can preload, position=" + i3);
        } else {
            AegisLogger.Companion companion = AegisLogger.INSTANCE;
            if (companion.isColorLevel()) {
                companion.i("Audience|UniDirectionalPreloadStrategy", "canPreload", "roomId=" + this.roomId + " not preload, position=" + this.position + ", selectedPosition=" + selectedPosition + ", fromPosition=" + fromPosition);
            }
        }
        return z18;
    }

    @Override // com.tencent.mobileqq.qqlive.sail.ui.player.a
    public void clear() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            AppNetConnInfo.unRegisterWeakNetStatusHandler(this.weakNetworkHandler);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.sail.ui.player.a
    public void init() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            AppNetConnInfo.unRegisterWeakNetStatusHandler(this.weakNetworkHandler);
            AppNetConnInfo.registerWeakNetStatusHandler(BaseApplication.context, this.weakNetworkHandler);
        }
    }
}
