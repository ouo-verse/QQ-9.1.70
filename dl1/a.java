package dl1;

import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.nativedetail.bottom.permission.SpeakPermissionType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016R$\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Ldl1/a;", "Ldl1/b;", "", "a", "Landroid/widget/TextView;", "tipsView", "", "configTip", "", "b", "", "Ljava/lang/CharSequence;", "getCustomizedHintText", "()Ljava/lang/CharSequence;", "c", "(Ljava/lang/CharSequence;)V", "customizedHintText", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class a implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CharSequence customizedHintText;

    @Override // dl1.b
    public int a() {
        return SpeakPermissionType.PERMISSION_TYPE_ALL_MUTED.ordinal();
    }

    @Override // dl1.b
    public void b(@NotNull TextView tipsView, @NotNull String configTip) {
        boolean z16;
        Intrinsics.checkNotNullParameter(tipsView, "tipsView");
        Intrinsics.checkNotNullParameter(configTip, "configTip");
        CharSequence charSequence = this.customizedHintText;
        if (charSequence != null && charSequence.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            charSequence = null;
        }
        if (charSequence == null) {
            charSequence = tipsView.getContext().getString(R.string.f144580p6);
        }
        tipsView.setText(charSequence);
    }

    public final void c(@Nullable CharSequence charSequence) {
        this.customizedHintText = charSequence;
    }
}
