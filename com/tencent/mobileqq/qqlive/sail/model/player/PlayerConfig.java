package com.tencent.mobileqq.qqlive.sail.model.player;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u000e\b\u0086\b\u0018\u0000 P2\u00020\u0001:\u0001QB\u00fd\u0001\u0012\u0006\u0010\r\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0007\u0012\b\b\u0002\u0010 \u001a\u00020\u0007\u0012\b\b\u0002\u0010%\u001a\u00020!\u0012\b\b\u0002\u0010(\u001a\u00020\u0016\u0012\b\b\u0002\u0010*\u001a\u00020\u0016\u0012\b\b\u0002\u0010,\u001a\u00020\u0016\u0012\b\b\u0002\u0010.\u001a\u00020\u0016\u0012\b\b\u0002\u00100\u001a\u00020\u0016\u0012\b\b\u0002\u00101\u001a\u00020\u0016\u0012\b\b\u0002\u00106\u001a\u000202\u0012\b\b\u0002\u0010;\u001a\u000207\u0012\b\b\u0002\u0010=\u001a\u00020\u0007\u0012\b\b\u0002\u0010>\u001a\u00020\u0016\u0012\b\b\u0002\u0010@\u001a\u00020\u0016\u0012\b\b\u0002\u0010A\u001a\u00020\u0007\u0012\b\b\u0002\u0010C\u001a\u00020\u0007\u0012\u001a\b\u0002\u0010H\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010D\u0012\b\b\u0002\u0010J\u001a\u00020\u0016\u0012\b\b\u0002\u0010M\u001a\u00020\u0007\u00a2\u0006\u0004\bN\u0010OJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0012\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0015\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u0017\u0010\u001b\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u001e\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u000f\u001a\u0004\b\u001d\u0010\u0011R\u0017\u0010 \u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u000f\u001a\u0004\b \u0010\u0011R\u0017\u0010%\u001a\u00020!8\u0006\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\u001f\u0010$R\u0017\u0010(\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b&\u0010\u0018\u001a\u0004\b'\u0010\u001aR\u0017\u0010*\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b)\u0010\u0018\u001a\u0004\b)\u0010\u001aR\u0017\u0010,\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b'\u0010\u0018\u001a\u0004\b+\u0010\u001aR\u0017\u0010.\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0018\u001a\u0004\b-\u0010\u001aR\u0017\u00100\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0018\u001a\u0004\b/\u0010\u001aR\u0017\u00101\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0018\u001a\u0004\b\t\u0010\u001aR\u0017\u00106\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b&\u00105R\u0017\u0010;\u001a\u0002078\u0006\u00a2\u0006\f\n\u0004\b8\u00109\u001a\u0004\b3\u0010:R\u0017\u0010=\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b<\u0010\u000f\u001a\u0004\b<\u0010\u0011R\u0017\u0010>\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0018\u001a\u0004\b\u0017\u0010\u001aR\u0017\u0010@\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b?\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\u0017\u0010A\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001d\u0010\u000f\u001a\u0004\b?\u0010\u0011R\u0017\u0010C\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\bB\u0010\u000f\u001a\u0004\b\u0013\u0010\u0011R)\u0010H\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010D8\u0006\u00a2\u0006\f\n\u0004\bE\u0010F\u001a\u0004\b\"\u0010GR\u0017\u0010J\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\bI\u0010\u0018\u001a\u0004\b8\u0010\u001aR\"\u0010M\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bK\u0010\u000f\u001a\u0004\b\u000e\u0010\u0011\"\u0004\bB\u0010L\u00a8\u0006R"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "I", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()I", WadlProxyConsts.SCENE_ID, "b", "Z", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Z", "isMute", "c", "k", "playWhenPrepared", "", "d", "J", "l", "()J", "replayIntervalMs", "e", ReportConstant.COSTREPORT_PREFIX, "isUseTextureView", "f", "isZOrderMediaOverlay", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "g", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "()Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "format", h.F, "j", "minBufferDuration", "i", "maxBufferDuration", "getMinBufferingTimeMs", "minBufferingTimeMs", "getMaxBufferingTimeMs", "maxBufferingTimeMs", "getBufferingTimeoutMs", "bufferingTimeoutMs", "bufferingPacketDurationMin", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion$LatencyStrategy;", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion$LatencyStrategy;", "()Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion$LatencyStrategy;", "latencyStrategy", "", "o", UserInfo.SEX_FEMALE, "()F", "speedUpRate", "p", "isEnableDownloadProxy", "flvPreloadDurationMs", "r", "flvPreloadSize", "isSupportQuicFLv", "t", "enableQuicPlaintext", "", "u", "Ljava/util/Map;", "()Ljava/util/Map;", "httpHeader", "v", "updateDownloadQualityIntervalMs", "w", "(Z)V", "enableQUIC", "<init>", "(IZZJZZLcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;JJJJJJLcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion$LatencyStrategy;FZJJZZLjava/util/Map;JZ)V", HippyTKDListViewAdapter.X, "Companion", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final /* data */ class PlayerConfig {
    static IPatchRedirector $redirector_;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int sceneId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final boolean isMute;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean playWhenPrepared;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long replayIntervalMs;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final boolean isUseTextureView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final boolean isZOrderMediaOverlay;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final StreamFormat format;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final long minBufferDuration;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final long maxBufferDuration;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final long minBufferingTimeMs;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final long maxBufferingTimeMs;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final long bufferingTimeoutMs;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final long bufferingPacketDurationMin;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Companion.LatencyStrategy latencyStrategy;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final float speedUpRate;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final boolean isEnableDownloadProxy;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private final long flvPreloadDurationMs;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private final long flvPreloadSize;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private final boolean isSupportQuicFLv;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    private final boolean enableQuicPlaintext;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Map<String, String> httpHeader;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    private final long updateDownloadQualityIntervalMs;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    private boolean enableQUIC;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion;", "", "()V", "DEFAULT_BUFFERING_PACKET_DURATION_MS", "", "DEFAULT_BUFFERING_TIMEOUT_MS", "DEFAULT_BUFFER_PACKET_MAX_DURATION", "DEFAULT_FLV_PRELOAD_DURATION_MS", "DEFAULT_FLV_PRELOAD_SIZE", "DEFAULT_MAX_BUFFERING_TIME_MS", "DEFAULT_MIN_BUFFERING_TIME_MS", "DEFAULT_MIN_BUFFER_DURATION", "DEFAULT_REPLAY_INTERVAL", "DEFAULT_SPEED_UP_RATE", "", "DEFAULT_UPDATE_DOWNLOAD_QUALITY_INTERVAL_MS", "LatencyStrategy", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion$LatencyStrategy;", "", "", "value", "I", HippyTextInputController.COMMAND_getValue, "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "NONE", "SPEED_UP", "SKIP_FRAME", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes17.dex */
        public static final class LatencyStrategy {
            private static final /* synthetic */ LatencyStrategy[] $VALUES;
            static IPatchRedirector $redirector_;

            /* renamed from: Companion, reason: from kotlin metadata */
            @NotNull
            public static final Companion INSTANCE;
            public static final LatencyStrategy NONE;
            public static final LatencyStrategy SKIP_FRAME;
            public static final LatencyStrategy SPEED_UP;
            private final int value;

            @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion$LatencyStrategy$a;", "", "", "value", "Lcom/tencent/mobileqq/qqlive/sail/model/player/PlayerConfig$Companion$LatencyStrategy;", "a", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
            /* renamed from: com.tencent.mobileqq.qqlive.sail.model.player.PlayerConfig$Companion$LatencyStrategy$a, reason: from kotlin metadata */
            /* loaded from: classes17.dex */
            public static final class Companion {
                static IPatchRedirector $redirector_;

                public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                    this();
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                        return;
                    }
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
                }

                @NotNull
                public final LatencyStrategy a(int value) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        return (LatencyStrategy) iPatchRedirector.redirect((short) 2, (Object) this, value);
                    }
                    if (value != 0) {
                        if (value != 1) {
                            if (value != 2) {
                                return LatencyStrategy.NONE;
                            }
                            return LatencyStrategy.SKIP_FRAME;
                        }
                        return LatencyStrategy.SPEED_UP;
                    }
                    return LatencyStrategy.NONE;
                }

                Companion() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                        return;
                    }
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            private static final /* synthetic */ LatencyStrategy[] $values() {
                return new LatencyStrategy[]{NONE, SPEED_UP, SKIP_FRAME};
            }

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30885);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 3)) {
                    redirector.redirect((short) 3);
                    return;
                }
                NONE = new LatencyStrategy("NONE", 0, 0);
                SPEED_UP = new LatencyStrategy("SPEED_UP", 1, 1);
                SKIP_FRAME = new LatencyStrategy("SKIP_FRAME", 2, 2);
                $VALUES = $values();
                INSTANCE = new Companion(null);
            }

            LatencyStrategy(String str, int i3, int i16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
                } else {
                    this.value = i16;
                }
            }

            public static LatencyStrategy valueOf(String str) {
                return (LatencyStrategy) Enum.valueOf(LatencyStrategy.class, str);
            }

            public static LatencyStrategy[] values() {
                return (LatencyStrategy[]) $VALUES.clone();
            }

            public final int getValue() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
                }
                return this.value;
            }
        }

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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30899);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 54)) {
            redirector.redirect((short) 54);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public PlayerConfig(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, @NotNull StreamFormat format, long j16, long j17, long j18, long j19, long j26, long j27, @NotNull Companion.LatencyStrategy latencyStrategy, float f16, boolean z26, long j28, long j29, boolean z27, boolean z28, @Nullable Map<String, String> map, long j36, boolean z29) {
        Intrinsics.checkNotNullParameter(format, "format");
        Intrinsics.checkNotNullParameter(latencyStrategy, "latencyStrategy");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), format, Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), latencyStrategy, Float.valueOf(f16), Boolean.valueOf(z26), Long.valueOf(j28), Long.valueOf(j29), Boolean.valueOf(z27), Boolean.valueOf(z28), map, Long.valueOf(j36), Boolean.valueOf(z29));
            return;
        }
        this.sceneId = i3;
        this.isMute = z16;
        this.playWhenPrepared = z17;
        this.replayIntervalMs = j3;
        this.isUseTextureView = z18;
        this.isZOrderMediaOverlay = z19;
        this.format = format;
        this.minBufferDuration = j16;
        this.maxBufferDuration = j17;
        this.minBufferingTimeMs = j18;
        this.maxBufferingTimeMs = j19;
        this.bufferingTimeoutMs = j26;
        this.bufferingPacketDurationMin = j27;
        this.latencyStrategy = latencyStrategy;
        this.speedUpRate = f16;
        this.isEnableDownloadProxy = z26;
        this.flvPreloadDurationMs = j28;
        this.flvPreloadSize = j29;
        this.isSupportQuicFLv = z27;
        this.enableQuicPlaintext = z28;
        this.httpHeader = map;
        this.updateDownloadQualityIntervalMs = j36;
        this.enableQUIC = z29;
    }

    public final long a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this)).longValue();
        }
        return this.bufferingPacketDurationMin;
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return ((Boolean) iPatchRedirector.redirect((short) 25, (Object) this)).booleanValue();
        }
        return this.enableQUIC;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.enableQuicPlaintext;
    }

    public final long d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Long) iPatchRedirector.redirect((short) 19, (Object) this)).longValue();
        }
        return this.flvPreloadDurationMs;
    }

    public final long e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return ((Long) iPatchRedirector.redirect((short) 20, (Object) this)).longValue();
        }
        return this.flvPreloadSize;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 53)) {
            return ((Boolean) iPatchRedirector.redirect((short) 53, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof PlayerConfig)) {
            return false;
        }
        PlayerConfig playerConfig = (PlayerConfig) other;
        if (this.sceneId == playerConfig.sceneId && this.isMute == playerConfig.isMute && this.playWhenPrepared == playerConfig.playWhenPrepared && this.replayIntervalMs == playerConfig.replayIntervalMs && this.isUseTextureView == playerConfig.isUseTextureView && this.isZOrderMediaOverlay == playerConfig.isZOrderMediaOverlay && this.format == playerConfig.format && this.minBufferDuration == playerConfig.minBufferDuration && this.maxBufferDuration == playerConfig.maxBufferDuration && this.minBufferingTimeMs == playerConfig.minBufferingTimeMs && this.maxBufferingTimeMs == playerConfig.maxBufferingTimeMs && this.bufferingTimeoutMs == playerConfig.bufferingTimeoutMs && this.bufferingPacketDurationMin == playerConfig.bufferingPacketDurationMin && this.latencyStrategy == playerConfig.latencyStrategy && Float.compare(this.speedUpRate, playerConfig.speedUpRate) == 0 && this.isEnableDownloadProxy == playerConfig.isEnableDownloadProxy && this.flvPreloadDurationMs == playerConfig.flvPreloadDurationMs && this.flvPreloadSize == playerConfig.flvPreloadSize && this.isSupportQuicFLv == playerConfig.isSupportQuicFLv && this.enableQuicPlaintext == playerConfig.enableQuicPlaintext && Intrinsics.areEqual(this.httpHeader, playerConfig.httpHeader) && this.updateDownloadQualityIntervalMs == playerConfig.updateDownloadQualityIntervalMs && this.enableQUIC == playerConfig.enableQUIC) {
            return true;
        }
        return false;
    }

    @NotNull
    public final StreamFormat f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (StreamFormat) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.format;
    }

    @Nullable
    public final Map<String, String> g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (Map) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.httpHeader;
    }

    @NotNull
    public final Companion.LatencyStrategy h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (Companion.LatencyStrategy) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.latencyStrategy;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 52)) {
            return ((Integer) iPatchRedirector.redirect((short) 52, (Object) this)).intValue();
        }
        int i3 = this.sceneId * 31;
        boolean z16 = this.isMute;
        int i16 = 1;
        int i17 = z16;
        if (z16 != 0) {
            i17 = 1;
        }
        int i18 = (i3 + i17) * 31;
        boolean z17 = this.playWhenPrepared;
        int i19 = z17;
        if (z17 != 0) {
            i19 = 1;
        }
        int a16 = (((i18 + i19) * 31) + androidx.fragment.app.a.a(this.replayIntervalMs)) * 31;
        boolean z18 = this.isUseTextureView;
        int i26 = z18;
        if (z18 != 0) {
            i26 = 1;
        }
        int i27 = (a16 + i26) * 31;
        boolean z19 = this.isZOrderMediaOverlay;
        int i28 = z19;
        if (z19 != 0) {
            i28 = 1;
        }
        int hashCode2 = (((((((((((((((((((i27 + i28) * 31) + this.format.hashCode()) * 31) + androidx.fragment.app.a.a(this.minBufferDuration)) * 31) + androidx.fragment.app.a.a(this.maxBufferDuration)) * 31) + androidx.fragment.app.a.a(this.minBufferingTimeMs)) * 31) + androidx.fragment.app.a.a(this.maxBufferingTimeMs)) * 31) + androidx.fragment.app.a.a(this.bufferingTimeoutMs)) * 31) + androidx.fragment.app.a.a(this.bufferingPacketDurationMin)) * 31) + this.latencyStrategy.hashCode()) * 31) + Float.floatToIntBits(this.speedUpRate)) * 31;
        boolean z26 = this.isEnableDownloadProxy;
        int i29 = z26;
        if (z26 != 0) {
            i29 = 1;
        }
        int a17 = (((((hashCode2 + i29) * 31) + androidx.fragment.app.a.a(this.flvPreloadDurationMs)) * 31) + androidx.fragment.app.a.a(this.flvPreloadSize)) * 31;
        boolean z27 = this.isSupportQuicFLv;
        int i36 = z27;
        if (z27 != 0) {
            i36 = 1;
        }
        int i37 = (a17 + i36) * 31;
        boolean z28 = this.enableQuicPlaintext;
        int i38 = z28;
        if (z28 != 0) {
            i38 = 1;
        }
        int i39 = (i37 + i38) * 31;
        Map<String, String> map = this.httpHeader;
        if (map == null) {
            hashCode = 0;
        } else {
            hashCode = map.hashCode();
        }
        int a18 = (((i39 + hashCode) * 31) + androidx.fragment.app.a.a(this.updateDownloadQualityIntervalMs)) * 31;
        boolean z29 = this.enableQUIC;
        if (!z29) {
            i16 = z29 ? 1 : 0;
        }
        return a18 + i16;
    }

    public final long i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.maxBufferDuration;
    }

    public final long j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Long) iPatchRedirector.redirect((short) 10, (Object) this)).longValue();
        }
        return this.minBufferDuration;
    }

    public final boolean k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.playWhenPrepared;
    }

    public final long l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Long) iPatchRedirector.redirect((short) 6, (Object) this)).longValue();
        }
        return this.replayIntervalMs;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.sceneId;
    }

    public final float n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Float) iPatchRedirector.redirect((short) 17, (Object) this)).floatValue();
        }
        return this.speedUpRate;
    }

    public final long o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Long) iPatchRedirector.redirect((short) 24, (Object) this)).longValue();
        }
        return this.updateDownloadQualityIntervalMs;
    }

    public final boolean p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return this.isEnableDownloadProxy;
    }

    public final boolean q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isMute;
    }

    public final boolean r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.isSupportQuicFLv;
    }

    public final boolean s() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.isUseTextureView;
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, z16);
        } else {
            this.enableQUIC = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 51)) {
            return (String) iPatchRedirector.redirect((short) 51, (Object) this);
        }
        return "PlayerConfig(sceneId=" + this.sceneId + ", isMute=" + this.isMute + ", playWhenPrepared=" + this.playWhenPrepared + ", replayIntervalMs=" + this.replayIntervalMs + ", isUseTextureView=" + this.isUseTextureView + ", isZOrderMediaOverlay=" + this.isZOrderMediaOverlay + ", format=" + this.format + ", minBufferDuration=" + this.minBufferDuration + ", maxBufferDuration=" + this.maxBufferDuration + ", minBufferingTimeMs=" + this.minBufferingTimeMs + ", maxBufferingTimeMs=" + this.maxBufferingTimeMs + ", bufferingTimeoutMs=" + this.bufferingTimeoutMs + ", bufferingPacketDurationMin=" + this.bufferingPacketDurationMin + ", latencyStrategy=" + this.latencyStrategy + ", speedUpRate=" + this.speedUpRate + ", isEnableDownloadProxy=" + this.isEnableDownloadProxy + ", flvPreloadDurationMs=" + this.flvPreloadDurationMs + ", flvPreloadSize=" + this.flvPreloadSize + ", isSupportQuicFLv=" + this.isSupportQuicFLv + ", enableQuicPlaintext=" + this.enableQuicPlaintext + ", httpHeader=" + this.httpHeader + ", updateDownloadQualityIntervalMs=" + this.updateDownloadQualityIntervalMs + ", enableQUIC=" + this.enableQUIC + ")";
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ PlayerConfig(int i3, boolean z16, boolean z17, long j3, boolean z18, boolean z19, StreamFormat streamFormat, long j16, long j17, long j18, long j19, long j26, long j27, Companion.LatencyStrategy latencyStrategy, float f16, boolean z26, long j28, long j29, boolean z27, boolean z28, Map map, long j36, boolean z29, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, r5, r6, r7, r9, r10, r11, r12, r14, r16, r18, r20, r22, r24, r25, r26, r27, r29, r31, (524288 & i16) != 0 ? true : z28, (1048576 & i16) != 0 ? null : map, (2097152 & i16) != 0 ? 1000L : j36, (4194304 & i16) != 0 ? r31 : z29);
        boolean z36 = (i16 & 2) != 0 ? false : z16;
        boolean z37 = (i16 & 4) != 0 ? true : z17;
        long j37 = (i16 & 8) != 0 ? 2000L : j3;
        boolean z38 = (i16 & 16) != 0 ? true : z18;
        boolean z39 = (i16 & 32) != 0 ? false : z19;
        StreamFormat streamFormat2 = (i16 & 64) != 0 ? StreamFormat.FLV : streamFormat;
        long j38 = (i16 & 128) != 0 ? 2000L : j16;
        long j39 = (i16 & 256) != 0 ? 60000L : j17;
        long j46 = (i16 & 512) != 0 ? 1000L : j18;
        long j47 = (i16 & 1024) != 0 ? 5000L : j19;
        long j48 = (i16 & 2048) != 0 ? 30000L : j26;
        long j49 = (i16 & 4096) != 0 ? 4000L : j27;
        Companion.LatencyStrategy latencyStrategy2 = (i16 & 8192) != 0 ? Companion.LatencyStrategy.SPEED_UP : latencyStrategy;
        float f17 = (i16 & 16384) != 0 ? 1.2f : f16;
        boolean z46 = (32768 & i16) != 0 ? true : z26;
        long j56 = (65536 & i16) != 0 ? 1200L : j28;
        long j57 = (131072 & i16) != 0 ? 2621440L : j29;
        boolean z47 = (262144 & i16) != 0 ? true : z27;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Boolean.valueOf(z16), Boolean.valueOf(z17), Long.valueOf(j3), Boolean.valueOf(z18), Boolean.valueOf(z19), streamFormat, Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19), Long.valueOf(j26), Long.valueOf(j27), latencyStrategy, Float.valueOf(f16), Boolean.valueOf(z26), Long.valueOf(j28), Long.valueOf(j29), Boolean.valueOf(z27), Boolean.valueOf(z28), map, Long.valueOf(j36), Boolean.valueOf(z29), Integer.valueOf(i16), defaultConstructorMarker);
    }
}
