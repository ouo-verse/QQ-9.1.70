package nw3;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.quibadge.QUIBadge;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J \u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH&\u00a8\u0006\u000f"}, d2 = {"Lnw3/a;", "", "Landroid/widget/ImageView;", "getAvatarView", "Landroid/view/View;", "getAvatarLayout", "Lcom/tencent/mobileqq/quibadge/QUIBadge;", "getAvatarUnread", "", "redPointWidth", "redPointHeight", "", "isNumPoint", "", "setTopRightHole", "chats_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public interface a {
    @NotNull
    View getAvatarLayout();

    @Nullable
    QUIBadge getAvatarUnread();

    @NotNull
    ImageView getAvatarView();

    void setTopRightHole(float redPointWidth, float redPointHeight, boolean isNumPoint);
}
