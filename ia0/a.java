package ia0;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "", "a", "qcircle-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class a {
    public static final boolean a(@NotNull g gVar) {
        Intrinsics.checkNotNullParameter(gVar, "<this>");
        if (gVar.n() == 103 && gVar.l() == AppConstants.Q_CIRCLE_PUBLIC_ACCOUNT_UIN_LONGVALUE) {
            return true;
        }
        return false;
    }
}
