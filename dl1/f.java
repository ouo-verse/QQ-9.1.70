package dl1;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Ldl1/f;", "Ldl1/b;", "", "a", "Landroid/widget/TextView;", "tipsView", "", "configTip", "", "b", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class f implements b {
    @Override // dl1.b
    public int a() {
        return SpeakPermissionType.PERMISSION_TYPE_SELF_MUTED.ordinal();
    }

    @Override // dl1.b
    public void b(@NotNull TextView tipsView, @NotNull String configTip) {
        Intrinsics.checkNotNullParameter(tipsView, "tipsView");
        Intrinsics.checkNotNullParameter(configTip, "configTip");
        tipsView.setText(tipsView.getContext().getString(R.string.f144580p6));
    }
}
