package com.tencent.mobileqq.wink.context;

import android.os.Parcel;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\t\b\u0004\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u0082\u0001\r\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/context/q;", "", "", "c", "a", "", "b", "toString", "<init>", "()V", "Lcom/tencent/mobileqq/wink/context/a;", "Lcom/tencent/mobileqq/wink/context/c;", "Lcom/tencent/mobileqq/wink/context/d;", "Lcom/tencent/mobileqq/wink/context/e;", "Lcom/tencent/mobileqq/wink/context/g;", "Lcom/tencent/mobileqq/wink/context/h;", "Lcom/tencent/mobileqq/wink/context/i;", "Lcom/tencent/mobileqq/wink/context/j;", "Lcom/tencent/mobileqq/wink/context/k;", "Lcom/tencent/mobileqq/wink/context/l;", "Lcom/tencent/mobileqq/wink/context/m;", "Lcom/tencent/mobileqq/wink/context/n;", "Lcom/tencent/mobileqq/wink/context/o;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u0014\u0010\u000e\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/context/q$a;", "", "", PreDownloadConstants.RPORT_KEY_BUSINESS_NAME, "Lcom/tencent/mobileqq/wink/context/q;", "c", "Landroid/os/Parcel;", "parcel", "b", DownloadInfo.spKey_Config, "", "d", "", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.context.q$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Removed duplicated region for block: B:6:0x009a A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(@Nullable String businessName) {
            if (businessName != null) {
                switch (businessName.hashCode()) {
                    case -1322459498:
                        if (businessName.equals("qqstranger")) {
                            return true;
                        }
                        break;
                    case -1274223135:
                        if (!businessName.equals("filetbstool")) {
                        }
                        break;
                    case -825146633:
                        if (!businessName.equals("QCIRCLE_AVATAR")) {
                        }
                        break;
                    case -221673174:
                        if (!businessName.equals(QQWinkConstants.ENTRY_BUSINESS_KANDIAN)) {
                        }
                        break;
                    case -176742241:
                        if (!businessName.equals("qqnearby")) {
                        }
                        break;
                    case -127732263:
                        if (!businessName.equals("SHARE_AVATAR")) {
                        }
                        break;
                    case 19908128:
                        if (!businessName.equals("ECOMMERCE")) {
                        }
                        break;
                    case 67973745:
                        if (!businessName.equals("Flock")) {
                        }
                        break;
                    case 68174803:
                        if (!businessName.equals("GUILD")) {
                        }
                        break;
                    case 77564797:
                        if (!businessName.equals("QZONE")) {
                        }
                        break;
                    case 477153755:
                        if (!businessName.equals("QCIRCLE_REDPACKET")) {
                        }
                        break;
                    case 861433953:
                        if (!businessName.equals("QCIRCLE")) {
                        }
                        break;
                    case 1172029062:
                        if (businessName.equals("emoticon")) {
                        }
                        break;
                    case 1506520400:
                        if (!businessName.equals("AI_AVATAR")) {
                        }
                        break;
                }
            }
            return false;
        }

        @NotNull
        public final q b(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return c(parcel.readString());
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Failed to find 'out' block for switch in B:6:0x001a. Please report as an issue. */
        @NotNull
        public final q c(@Nullable String businessName) {
            if (!a(businessName)) {
                QLog.w("WinkBusinessConfig", 1, "[retrieve] invalid businessName");
                businessName = "QCIRCLE";
            }
            if (businessName != null) {
                switch (businessName.hashCode()) {
                    case -1322459498:
                        if (businessName.equals("qqstranger")) {
                            return n.f318053b;
                        }
                        break;
                    case -1274223135:
                        if (businessName.equals("filetbstool")) {
                            return e.f318043b;
                        }
                        break;
                    case -825146633:
                        if (businessName.equals("QCIRCLE_AVATAR")) {
                            return k.f318050b;
                        }
                        break;
                    case -221673174:
                        if (businessName.equals(QQWinkConstants.ENTRY_BUSINESS_KANDIAN)) {
                            return j.f318049b;
                        }
                        break;
                    case -176742241:
                        if (businessName.equals("qqnearby")) {
                            return m.f318052b;
                        }
                        break;
                    case 19908128:
                        if (businessName.equals("ECOMMERCE")) {
                            return c.f318041b;
                        }
                        break;
                    case 67973745:
                        if (businessName.equals("Flock")) {
                            return g.f318046b;
                        }
                        break;
                    case 68174803:
                        if (businessName.equals("GUILD")) {
                            return h.f318047b;
                        }
                        break;
                    case 77564797:
                        if (businessName.equals("QZONE")) {
                            return o.f318054b;
                        }
                        break;
                    case 477153755:
                        if (businessName.equals("QCIRCLE_REDPACKET")) {
                            return i.f318048b;
                        }
                        break;
                    case 861433953:
                        if (businessName.equals("QCIRCLE")) {
                            return l.f318051b;
                        }
                        break;
                    case 1172029062:
                        if (businessName.equals("emoticon")) {
                            return d.f318042b;
                        }
                        break;
                    case 1506520400:
                        if (businessName.equals("AI_AVATAR")) {
                            return a.f318034b;
                        }
                        break;
                }
            }
            return l.f318051b;
        }

        public final void d(@NotNull Parcel parcel, @NotNull q config) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            Intrinsics.checkNotNullParameter(config, "config");
            parcel.writeString(config.a());
        }

        Companion() {
        }
    }

    public /* synthetic */ q(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public abstract String a();

    public abstract int b();

    @NotNull
    public abstract String c();

    @NotNull
    public String toString() {
        return "{appkey=" + c() + ", name=" + a() + ", type=" + b() + "}";
    }

    q() {
    }
}
