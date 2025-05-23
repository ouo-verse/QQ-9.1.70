package com.tencent.mobileqq.nearbypro.feedscheck.avatarpart;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.nearbypro.base.j;
import com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart;
import com.tencent.mobileqq.nearbypro.profile.avatar.MyNearbyProBizScene;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J\u001c\u0010\u000f\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/feedscheck/avatarpart/b;", "Lcom/tencent/mobileqq/nearbypro/profile/avatar/AvatarPart;", "", "needShow", "", "Z9", "W9", "Landroid/view/ViewGroup$LayoutParams;", "L9", "Landroid/widget/FrameLayout$LayoutParams;", "M9", "", "action", "", "args", "handleBroadcastMessage", "S9", "U9", "", BdhLogUtil.LogTag.Tag_Req, "J", "getTinyId", "()J", "tinyId", "<init>", "(J)V", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class b extends AvatarPart {

    /* renamed from: R, reason: from kotlin metadata */
    private final long tinyId;

    public b(long j3) {
        this.tinyId = j3;
    }

    private final void Z9(int needShow) {
        ViewGroup avatarContainer = getAvatarContainer();
        if (avatarContainer != null) {
            avatarContainer.setVisibility(needShow);
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart
    @NotNull
    public ViewGroup.LayoutParams L9() {
        int dpToPx = ViewUtils.dpToPx(375.0f);
        int realHeight = ScreenUtil.getRealHeight(BaseApplication.context);
        j.c().e("NBP.PersonalPart.AvatarPart", " createLayoutParams rootViewWith : " + dpToPx + ", screenHeight: " + realHeight);
        X9(ViewUtils.dpToPx(375.0f));
        Y9((getRelHeight() / 4) * 3);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(getRelWidth(), getRelHeight());
        layoutParams.gravity = 80;
        return layoutParams;
    }

    @Override // com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart
    @NotNull
    public FrameLayout.LayoutParams M9() {
        int dpToPx = ViewUtils.dpToPx(375.0f);
        int dpToPx2 = ViewUtils.dpToPx(375.0f);
        int relWidth = (getRelWidth() / 3) * 2;
        int i3 = (int) (relWidth / 4.7d);
        int dip2px = ((dpToPx - relWidth) / 2) + ViewUtils.dip2px(27.0f);
        int i16 = dpToPx2 / 78;
        if (MyNearbyProBizScene.INSTANCE.a()) {
            i16 = 0;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(relWidth, i3);
        layoutParams.leftMargin = dip2px;
        layoutParams.bottomMargin = i16;
        layoutParams.gravity = 80;
        return layoutParams;
    }

    @Override // com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart
    @NotNull
    public String S9() {
        return "https://static-res.qq.com/static-res/drawer/drawer_filament_shadow_2.png";
    }

    @Override // com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart
    public void W9() {
        N9(2);
    }

    @Override // com.tencent.mobileqq.nearbypro.part.e, com.tencent.biz.richframework.part.Part
    public void handleBroadcastMessage(@Nullable String action, @Nullable Object args) {
        if (Intrinsics.areEqual(action, "SELECT_CURRENT_LOCATION_POS")) {
            Intrinsics.checkNotNull(args, "null cannot be cast to non-null type kotlin.Int");
            Z9(((Integer) args).intValue());
        }
    }

    @Override // com.tencent.mobileqq.nearbypro.profile.avatar.AvatarPart
    public void U9() {
    }
}
