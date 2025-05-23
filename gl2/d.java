package gl2;

import com.qwallet.protocol.Wallet.pb.pet.PetUserState$HomepageRsp;
import com.tencent.mobileqq.qwallet.pet.data.DownloadDetail;
import com.tencent.mobileqq.qwallet.pet.data.FilamentDefaultResource;
import com.tencent.mobileqq.qwallet.pet.data.ModelType;
import com.tencent.mobileqq.qwallet.pet.data.PetInfo;
import com.tencent.mobileqq.qwallet.pet.data.f;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lgl2/d;", "Lgl2/b;", "Lcom/qwallet/protocol/Wallet/pb/pet/PetUserState$HomepageRsp;", "rsp", "", "i", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d extends b {
    public final void i(@NotNull PetUserState$HomepageRsp rsp) {
        String str;
        boolean z16;
        PetInfo petInfo;
        Object obj;
        DownloadDetail b16;
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        f fVar = f.f278777a;
        FilamentDefaultResource d16 = fVar.d();
        String str2 = null;
        if (d16 != null) {
            str = d16.getDefaultResource();
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16 && (b16 = jl2.b.f410584a.b(ModelType.KTX, str)) != null && !b16.e()) {
            f().add(b16);
        }
        if (rsp.user_type.get() == 1) {
            g(null);
            return;
        }
        List<PetInfo> e16 = fVar.e();
        if (e16 != null) {
            Iterator<T> it = e16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((PetInfo) obj).getType(), rsp.pet_type.get())) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            petInfo = (PetInfo) obj;
        } else {
            petInfo = null;
        }
        if (petInfo != null) {
            str2 = petInfo.getType();
        }
        g(str2);
    }
}
