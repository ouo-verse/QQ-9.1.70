package bl2;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a*\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002\u001a\u0006\u0010\b\u001a\u00020\u0001\u00a8\u0006\t"}, d2 = {"", "Lbl2/c;", "", "skinId", "", "outerSkinId", "skinFrom", "b", "a", "qqpay-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class d {
    @NotNull
    public static final HbSkinInfo a() {
        return new HbSkinInfo(0, "", 0, HardCodeUtil.qqStr(R.string.n78), 0, "", "", "", "", "", "", "", "", "", false, "", true);
    }

    @Nullable
    public static final HbSkinInfo b(@NotNull List<HbSkinInfo> list, int i3, @NotNull String outerSkinId, int i16) {
        Object obj;
        boolean z16;
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(outerSkinId, "outerSkinId");
        Iterator<T> it = list.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                HbSkinInfo hbSkinInfo = (HbSkinInfo) obj;
                if (hbSkinInfo.getSkinId() == i3 && Intrinsics.areEqual(hbSkinInfo.getOuterSkinId(), outerSkinId) && hbSkinInfo.getSkinFrom() == i16) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (HbSkinInfo) obj;
    }
}
