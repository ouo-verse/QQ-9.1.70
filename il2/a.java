package il2;

import com.qwallet.protocol.Wallet.pb.pet.PetCommon$DeviceInfo;
import com.qwallet.protocol.Wallet.pb.pet.PetCommon$DeviceSupport;
import com.qwallet.protocol.Wallet.pb.pet.PetUserState$HomepageRsp;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.utils.c;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00052\u00020\u0001:\u0002\u0007\u0005B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lil2/a;", "", "Lcom/qwallet/protocol/Wallet/pb/pet/PetUserState$HomepageRsp;", "rsp", "", "b", "Lil2/a$b;", "a", "Lil2/a$b;", "()Lil2/a$b;", "setSupportResult", "(Lil2/a$b;)V", "supportResult", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SupportResult supportResult;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006\u00a8\u0006\t"}, d2 = {"Lil2/a$a;", "", "Lcom/qwallet/protocol/Wallet/pb/pet/PetCommon$DeviceInfo;", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: il2.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes16.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final PetCommon$DeviceInfo a() {
            c cVar = c.f279254a;
            String e16 = cVar.e();
            int d16 = cVar.d();
            String a16 = cVar.a();
            int c16 = cVar.c();
            int b16 = cVar.b();
            QLog.d("QWallet.Pet.Supporter", 1, "phoneModel=" + e16 + ", memorySize=" + d16 + " cpuBrand=[" + a16 + "] cpuMaxFreq=" + c16 + "  cpuCoreNumber=" + b16);
            PetCommon$DeviceInfo petCommon$DeviceInfo = new PetCommon$DeviceInfo();
            petCommon$DeviceInfo.phone_model.set(e16);
            petCommon$DeviceInfo.memory_size.set(d16);
            petCommon$DeviceInfo.cpu_type.set(a16);
            petCommon$DeviceInfo.cpu_max_freq.set(c16);
            petCommon$DeviceInfo.cpu_core_num.set(b16);
            return petCommon$DeviceInfo;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u000e\u001a\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lil2/a$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "b", "()Z", "isSupport", "Ljava/lang/String;", "()Ljava/lang/String;", "failUrl", "<init>", "(ZLjava/lang/String;)V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: il2.a$b, reason: from toString */
    /* loaded from: classes16.dex */
    public static final /* data */ class SupportResult {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSupport;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String failUrl;

        public SupportResult(boolean z16, @Nullable String str) {
            this.isSupport = z16;
            this.failUrl = str;
        }

        @Nullable
        /* renamed from: a, reason: from getter */
        public final String getFailUrl() {
            return this.failUrl;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSupport() {
            return this.isSupport;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SupportResult)) {
                return false;
            }
            SupportResult supportResult = (SupportResult) other;
            if (this.isSupport == supportResult.isSupport && Intrinsics.areEqual(this.failUrl, supportResult.failUrl)) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isSupport;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int i3 = r06 * 31;
            String str = this.failUrl;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return i3 + hashCode;
        }

        @NotNull
        public String toString() {
            return "SupportResult(isSupport=" + this.isSupport + ", failUrl=" + this.failUrl + ")";
        }
    }

    @Nullable
    /* renamed from: a, reason: from getter */
    public final SupportResult getSupportResult() {
        return this.supportResult;
    }

    public final void b(@Nullable PetUserState$HomepageRsp rsp) {
        PetCommon$DeviceSupport petCommon$DeviceSupport;
        boolean z16;
        PBStringField pBStringField;
        PBBoolField pBBoolField;
        String str = null;
        if (rsp != null) {
            petCommon$DeviceSupport = rsp.device_support;
        } else {
            petCommon$DeviceSupport = null;
        }
        if (petCommon$DeviceSupport != null && (pBBoolField = petCommon$DeviceSupport.is_support) != null) {
            z16 = pBBoolField.get();
        } else {
            z16 = true;
        }
        if (petCommon$DeviceSupport != null && (pBStringField = petCommon$DeviceSupport.fail_url) != null) {
            str = pBStringField.get();
        }
        this.supportResult = new SupportResult(z16, str);
    }
}
