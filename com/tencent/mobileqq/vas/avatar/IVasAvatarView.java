package com.tencent.mobileqq.vas.avatar;

import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.quibadge.QUIBadge;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J,\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u0004H&J\b\u0010\n\u001a\u00020\bH&J\b\u0010\u000b\u001a\u00020\bH&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/vas/avatar/IVasAvatarView;", "Lnw3/a;", "", "uin", "", "faceId", "headSize", "source", "", "startLoadAvatar", "pauseAnim", "resumeAnim", "vas_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public interface IVasAvatarView extends nw3.a {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes20.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ void startLoadAvatar$default(IVasAvatarView iVasAvatarView, String str, int i3, int i16, int i17, int i18, Object obj) {
            if (obj == null) {
                if ((i18 & 4) != 0) {
                    i16 = 200;
                }
                if ((i18 & 8) != 0) {
                    i17 = 0;
                }
                iVasAvatarView.startLoadAvatar(str, i3, i16, i17);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startLoadAvatar");
        }
    }

    @Override // nw3.a
    @NotNull
    /* synthetic */ View getAvatarLayout();

    @Override // nw3.a
    @Nullable
    /* synthetic */ QUIBadge getAvatarUnread();

    @Override // nw3.a
    @NotNull
    /* synthetic */ ImageView getAvatarView();

    void pauseAnim();

    void resumeAnim();

    @Override // nw3.a
    /* synthetic */ void setTopRightHole(float f16, float f17, boolean z16);

    void startLoadAvatar(@NotNull String uin, int faceId, int headSize, int source);
}
