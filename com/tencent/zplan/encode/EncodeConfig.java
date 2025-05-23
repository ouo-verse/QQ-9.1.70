package com.tencent.zplan.encode;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.zplan.encode.IEncoder;
import com.tencent.zplan.encode.utils.MediaCodecEncodeType;
import com.tencent.zplan.encode.utils.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0001\u0005B=\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\f\u001a\u00020\u0004\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010+\u001a\u00020\u0004\u0012\b\b\u0003\u0010\u0012\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\t\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0006\u001a\u0004\b\u000b\u0010\bR\u0017\u0010\u0011\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0006\u001a\u0004\b\r\u0010\bR\u0019\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0013\u001a\u0004\b\u0005\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0006\u001a\u0004\b\u0017\u0010\b\"\u0004\b\u0018\u0010\u0019R\"\u0010!\u001a\u00020\u001b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000e\u001a\u0004\b\u0016\u0010\u0010\"\u0004\b\"\u0010#R\"\u0010*\u001a\u00020%8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010&\u001a\u0004\b\n\u0010'\"\u0004\b(\u0010)\u00a8\u0006."}, d2 = {"Lcom/tencent/zplan/encode/a;", "", "", "toString", "", "a", "I", tl.h.F, "()I", "width", "b", "d", "height", "c", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "savaPath", "encodeMode", "Ljava/lang/Integer;", "()Ljava/lang/Integer;", "cacheLimit", "f", "g", "l", "(I)V", "type", "", "Z", "i", "()Z", "j", "(Z)V", "isDebugger", "k", "(Ljava/lang/String;)V", "tempPath", "Lcom/tencent/zplan/encode/a$a;", "Lcom/tencent/zplan/encode/a$a;", "()Lcom/tencent/zplan/encode/a$a;", "setEncodeConfig", "(Lcom/tencent/zplan/encode/a$a;)V", "encodeConfig", "frameRate", "<init>", "(IILjava/lang/String;IILjava/lang/Integer;)V", "base_util_debug"}, k = 1, mv = {1, 5, 1})
/* renamed from: com.tencent.zplan.encode.a, reason: from toString */
/* loaded from: classes38.dex */
public final class EncodeConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int width;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final int height;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String savaPath;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int encodeMode;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Integer cacheLimit;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int type;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean isDebugger;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String tempPath;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private Config encodeConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u001b\u001a\u00020\b\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0014\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u001b\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/zplan/encode/a$a;", "Lcom/tencent/zplan/encode/utils/a;", "", "toString", "", "hashCode", "", "other", "", "equals", "p", "I", "a", "()I", "d", "(I)V", "bitRate", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "b", "e", "bitRateMode", "r", "Z", "c", "()Z", "setEnableBFrame", "(Z)V", "enableBFrame", "<init>", "(IIZ)V", "base_util_debug"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.tencent.zplan.encode.a$a, reason: collision with other inner class name and from toString */
    /* loaded from: classes38.dex */
    public static final /* data */ class Config extends com.tencent.zplan.encode.utils.a {

        /* renamed from: p, reason: collision with root package name and from kotlin metadata and from toString */
        private int bitRate;

        /* renamed from: q, reason: collision with root package name and from kotlin metadata and from toString */
        private int bitRateMode;

        /* renamed from: r, reason: collision with root package name and from kotlin metadata and from toString */
        private boolean enableBFrame;

        public Config() {
            this(0, 0, false, 7, null);
        }

        /* renamed from: a, reason: from getter */
        public final int getBitRate() {
            return this.bitRate;
        }

        /* renamed from: b, reason: from getter */
        public final int getBitRateMode() {
            return this.bitRateMode;
        }

        /* renamed from: c, reason: from getter */
        public final boolean getEnableBFrame() {
            return this.enableBFrame;
        }

        public final void d(int i3) {
            this.bitRate = i3;
        }

        public final void e(int i3) {
            this.bitRateMode = i3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int i3 = ((this.bitRate * 31) + this.bitRateMode) * 31;
            boolean z16 = this.enableBFrame;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @Override // com.tencent.zplan.encode.utils.a
        public String toString() {
            return "Config(bitRate=" + this.bitRate + ", bitRateMode=" + this.bitRateMode + ", enableBFrame=" + this.enableBFrame + ')';
        }

        public /* synthetic */ Config(int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this((i17 & 1) != 0 ? -1 : i3, (i17 & 2) != 0 ? 1 : i16, (i17 & 4) != 0 ? true : z16);
        }

        public Config(int i3, int i16, boolean z16) {
            this.bitRate = i3;
            this.bitRateMode = i16;
            this.enableBFrame = z16;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Config)) {
                return false;
            }
            Config config = (Config) other;
            return this.bitRate == config.bitRate && this.bitRateMode == config.bitRateMode && this.enableBFrame == config.enableBFrame;
        }
    }

    public EncodeConfig(int i3, int i16, String savaPath, int i17, @IEncoder.EncodeMode int i18, Integer num) {
        Intrinsics.checkParameterIsNotNull(savaPath, "savaPath");
        this.width = i3;
        this.height = i16;
        this.savaPath = savaPath;
        this.encodeMode = i18;
        this.cacheLimit = num;
        this.type = EncodeType.SOFTWARE.ordinal();
        this.tempPath = "";
        Config config = new Config(0, 0, false, 7, null);
        config.f385470h = i17;
        config.f385468f = getWidth();
        config.f385469g = getHeight();
        config.f385466d = getWidth();
        config.f385467e = getHeight();
        config.f385477o = MediaCodecEncodeType.SURFACE;
        config.f385471i = new d.i(3, 0, 1, 2);
        config.f385464b = false;
        config.f385465c = 21;
        Unit unit = Unit.INSTANCE;
        this.encodeConfig = config;
    }

    /* renamed from: a, reason: from getter */
    public final Integer getCacheLimit() {
        return this.cacheLimit;
    }

    /* renamed from: b, reason: from getter */
    public final Config getEncodeConfig() {
        return this.encodeConfig;
    }

    /* renamed from: c, reason: from getter */
    public final int getEncodeMode() {
        return this.encodeMode;
    }

    /* renamed from: d, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    /* renamed from: e, reason: from getter */
    public final String getSavaPath() {
        return this.savaPath;
    }

    /* renamed from: f, reason: from getter */
    public final String getTempPath() {
        return this.tempPath;
    }

    /* renamed from: g, reason: from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: h, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* renamed from: i, reason: from getter */
    public final boolean getIsDebugger() {
        return this.isDebugger;
    }

    public final void j(boolean z16) {
        this.isDebugger = z16;
    }

    public final void k(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.tempPath = str;
    }

    public final void l(int i3) {
        this.type = i3;
    }

    public String toString() {
        return "EncodeConfig(width: " + this.width + ", height: " + this.height + ", type: " + this.type + ", cacheLimit: " + this.cacheLimit + " savePath: " + this.savaPath + ", isDebugger: " + this.isDebugger + ", tempPath: " + this.tempPath + ", encodeConfig: " + this.encodeConfig + ')';
    }
}
