package h92;

import android.view.View;
import com.tencent.mobileqq.fragment.QIphoneTitleBarFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0004\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/fragment/QIphoneTitleBarFragment;", "", "enable", "", "a", "msgbackup_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class a {
    public static final void a(@NotNull QIphoneTitleBarFragment qIphoneTitleBarFragment, boolean z16) {
        float f16;
        Intrinsics.checkNotNullParameter(qIphoneTitleBarFragment, "<this>");
        qIphoneTitleBarFragment.setRightButtonEnable(z16);
        View rightTextView = qIphoneTitleBarFragment.getRightTextView();
        if (z16) {
            f16 = 1.0f;
        } else {
            f16 = 0.3f;
        }
        rightTextView.setAlpha(f16);
    }
}
