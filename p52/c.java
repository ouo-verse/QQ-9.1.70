package p52;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u0007B\u0007\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u0007\u0010\u000bR\"\u0010\u000f\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\b\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\u000bR\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001b"}, d2 = {"Lp52/c;", "", "Lcom/tencent/thumbplayer/api/TPPlayerMsg$TPProtocolInfo;", "protocolInfo", "", "b", "", "a", "Z", "getQuicEnable", "()Z", "(Z)V", "quicEnable", "getHasUseQuic", "setHasUseQuic", "hasUseQuic", "", "c", "Ljava/lang/String;", "getNowProto", "()Ljava/lang/String;", "setNowProto", "(Ljava/lang/String;)V", "nowProto", "<init>", "()V", "d", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class c {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean quicEnable;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean hasUseQuic;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private String nowProto = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0010\u0010\t\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u001a\u0010\f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\rR\u0014\u0010\u000f\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lp52/c$a;", "", "", "e", "a", "", "f", "", "url", "d", "Landroid/content/Context;", "context", "b", "", "c", "PROTOCOL_QUIC", "Ljava/lang/String;", "TAG", "<init>", "()V", "kandian_feature_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: p52.c$a, reason: from kotlin metadata */
    /* loaded from: classes33.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a() {
            return b.f425354a.a();
        }

        public final List<String> c() {
            List<String> split$default;
            split$default = StringsKt__StringsKt.split$default((CharSequence) b.f425354a.d(), new String[]{","}, false, 0, 6, (Object) null);
            return split$default;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x0047 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:17:? A[LOOP:0: B:6:0x0010->B:17:?, LOOP_END, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean d(String url) {
            boolean z16;
            if (TextUtils.isEmpty(url)) {
                return false;
            }
            for (String str : c()) {
                if (url != null) {
                    if (new Regex("http[s]?://" + str + ".*").matches(url)) {
                        z16 = true;
                        if (!z16) {
                            return true;
                        }
                    }
                }
                z16 = false;
                if (!z16) {
                }
            }
            return false;
        }

        public final boolean e() {
            return b.f425354a.b();
        }

        public final int f() {
            return b.f425354a.c();
        }

        Companion() {
        }

        public final int b(Context context, String url) {
            int f16;
            if (context == null || !d(url)) {
                return 0;
            }
            if (NetworkUtil.isWifiConnected(context)) {
                f16 = b.f425354a.e();
            } else {
                f16 = b.f425354a.f();
            }
            return f16;
        }
    }

    public final void a(boolean z16) {
        this.quicEnable = z16;
    }

    public final void b(TPPlayerMsg.TPProtocolInfo protocolInfo) {
        Intrinsics.checkNotNullParameter(protocolInfo, "protocolInfo");
        String str = protocolInfo.protocolName;
        Intrinsics.checkNotNullExpressionValue(str, "protocolInfo.protocolName");
        this.nowProto = str;
        if (Intrinsics.areEqual(str, "quic")) {
            this.hasUseQuic = true;
        }
    }
}
