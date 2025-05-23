package okhttp3;

import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\r"}, d2 = {"Lokhttp3/Protocol;", "", AudienceReportConst.PROTOCOL, "", "(Ljava/lang/String;ILjava/lang/String;)V", "toString", "HTTP_1_0", "HTTP_1_1", "SPDY_3", "HTTP_2", "H2_PRIOR_KNOWLEDGE", SemanticAttributes.HttpFlavorValues.QUIC, "Companion", "okhttp"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes28.dex */
public enum Protocol {
    HTTP_1_0("http/1.0"),
    HTTP_1_1("http/1.1"),
    SPDY_3("spdy/3.1"),
    HTTP_2(SemanticAttributes.DbSystemValues.H2),
    H2_PRIOR_KNOWLEDGE("h2_prior_knowledge"),
    QUIC("quic");


    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);
    private final String protocol;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lokhttp3/Protocol$Companion;", "", "()V", "get", "Lokhttp3/Protocol;", AudienceReportConst.PROTOCOL, "", "okhttp"}, k = 1, mv = {1, 4, 2})
    /* loaded from: classes28.dex */
    public static final class Companion {
        Companion() {
        }

        @JvmStatic
        @NotNull
        public final Protocol get(@NotNull String protocol2) throws IOException {
            Intrinsics.checkNotNullParameter(protocol2, "protocol");
            Protocol protocol3 = Protocol.HTTP_1_0;
            if (!Intrinsics.areEqual(protocol2, protocol3.protocol)) {
                protocol3 = Protocol.HTTP_1_1;
                if (!Intrinsics.areEqual(protocol2, protocol3.protocol)) {
                    protocol3 = Protocol.H2_PRIOR_KNOWLEDGE;
                    if (!Intrinsics.areEqual(protocol2, protocol3.protocol)) {
                        protocol3 = Protocol.HTTP_2;
                        if (!Intrinsics.areEqual(protocol2, protocol3.protocol)) {
                            protocol3 = Protocol.SPDY_3;
                            if (!Intrinsics.areEqual(protocol2, protocol3.protocol)) {
                                protocol3 = Protocol.QUIC;
                                if (!Intrinsics.areEqual(protocol2, protocol3.protocol)) {
                                    throw new IOException("Unexpected protocol: " + protocol2);
                                }
                            }
                        }
                    }
                }
            }
            return protocol3;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    Protocol(String str) {
        this.protocol = str;
    }

    @JvmStatic
    @NotNull
    public static final Protocol get(@NotNull String str) throws IOException {
        return INSTANCE.get(str);
    }

    @Override // java.lang.Enum
    @NotNull
    public String toString() {
        return this.protocol;
    }
}
