package com.tencent.mobileqq.qqlive.sail.model.audience;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig;
import com.tencent.tavcut.core.render.exporter.MovieExporter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "", "", "value", "Ljava/lang/String;", HippyTextInputController.COMMAND_getValue, "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "HLS", "FLV", MovieExporter.FILE_TYPE, "RTMP", "UNKNOWN", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class StreamFormat {
    private static final /* synthetic */ StreamFormat[] $VALUES;
    static IPatchRedirector $redirector_;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    public static final StreamFormat FLV;
    public static final StreamFormat HLS;
    public static final StreamFormat MP4;
    public static final StreamFormat RTMP;
    public static final StreamFormat UNKNOWN;

    @NotNull
    private final String value;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat$a;", "", "", "format", "Lcom/tencent/mobileqq/qqlive/sail/model/audience/StreamFormat;", "a", "<init>", "()V", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat$a, reason: from kotlin metadata */
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

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        
            if (r4.equals("rtmp") == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:?, code lost:
        
            return com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat.RTMP;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
        
            if (r4.equals("RTMP") == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x003e, code lost:
        
            if (r4.equals("mp4") == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:?, code lost:
        
            return com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat.MP4;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x0048, code lost:
        
            if (r4.equals(com.tencent.qqlive.tvkplayer.tools.config.TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS) == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:?, code lost:
        
            return com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat.HLS;
         */
        /* JADX WARN: Code restructure failed: missing block: B:25:0x0052, code lost:
        
            if (r4.equals("flv") == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:?, code lost:
        
            return com.tencent.mobileqq.qqlive.sail.model.audience.StreamFormat.FLV;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x005c, code lost:
        
            if (r4.equals(com.tencent.tavcut.core.render.exporter.MovieExporter.FILE_TYPE) == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
        
            if (r4.equals("HLS") == false) goto L39;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0076, code lost:
        
            if (r4.equals("FLV") == false) goto L39;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:9:0x001c. Please report as an issue. */
        @NotNull
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final StreamFormat a(@NotNull String format) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (StreamFormat) iPatchRedirector.redirect((short) 2, (Object) this, (Object) format);
            }
            Intrinsics.checkNotNullParameter(format, "format");
            switch (format.hashCode()) {
                case 69712:
                    break;
                case 71631:
                    break;
                case 76529:
                    break;
                case 101488:
                    break;
                case 103407:
                    break;
                case 108273:
                    break;
                case 2526053:
                    break;
                case 3511141:
                    break;
                default:
                    return StreamFormat.UNKNOWN;
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

    private static final /* synthetic */ StreamFormat[] $values() {
        return new StreamFormat[]{HLS, FLV, MP4, RTMP, UNKNOWN};
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        HLS = new StreamFormat("HLS", 0, TVKMediaPlayerConfig.PlayerConfig.FORMAT_ID_HLS);
        FLV = new StreamFormat("FLV", 1, "flv");
        MP4 = new StreamFormat(MovieExporter.FILE_TYPE, 2, "mp4");
        RTMP = new StreamFormat("RTMP", 3, "rtmp");
        UNKNOWN = new StreamFormat("UNKNOWN", 4, "unknown");
        $VALUES = $values();
        INSTANCE = new Companion(null);
    }

    StreamFormat(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), str2);
        } else {
            this.value = str2;
        }
    }

    public static StreamFormat valueOf(String str) {
        return (StreamFormat) Enum.valueOf(StreamFormat.class, str);
    }

    public static StreamFormat[] values() {
        return (StreamFormat[]) $VALUES.clone();
    }

    @NotNull
    public final String getValue() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.value;
    }
}
