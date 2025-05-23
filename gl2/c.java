package gl2;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qwallet.pet.data.DownloadDetail;
import com.tencent.mobileqq.qwallet.pet.data.ModelType;
import com.tencent.mobileqq.qwallet.pet.data.f;
import com.tencent.mobileqq.qwallet.pet.data.j;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\t\u0010\nJ&\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u00a8\u0006\u000b"}, d2 = {"Lgl2/c;", "Lgl2/b;", "", "petType", "", "clothing", WadlProxyConsts.SCENE_ID, "", "i", "<init>", "()V", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class c extends b {
    public final void i(@NotNull String petType, @NotNull List<String> clothing, @Nullable String sceneId) {
        String str;
        Intrinsics.checkNotNullParameter(petType, "petType");
        Intrinsics.checkNotNullParameter(clothing, "clothing");
        j h16 = f.f278777a.h(sceneId);
        jl2.b bVar = jl2.b.f410584a;
        ModelType modelType = ModelType.NULL;
        if (h16 != null) {
            str = h16.getDownloadUrl();
        } else {
            str = null;
        }
        DownloadDetail b16 = bVar.b(modelType, str);
        if (b16 != null) {
            f().add(b16);
        }
        g(petType);
    }
}
