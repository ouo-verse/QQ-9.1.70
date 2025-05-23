package com.tencent.mobileqq.qwallet.hb.panel.preview;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qwallet.hb.panel.RecommendSkinView;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.shadow.core.runtime.skin.loader.SkinResFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\f\u001a\u00020\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u001c\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/h;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lcom/tencent/mobileqq/qwallet/pb/RedPackSkin$RecommendSkin;", SkinResFactory.SKIN_THEME_APK_SAVE_DIR, "", "l", "Lcom/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView;", "kotlin.jvm.PlatformType", "E", "Lcom/tencent/mobileqq/qwallet/hb/panel/RecommendSkinView;", "recommendSkinView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class h extends RecyclerView.ViewHolder {

    /* renamed from: E, reason: from kotlin metadata */
    private final RecommendSkinView recommendSkinView;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.recommendSkinView = (RecommendSkinView) view.findViewById(R.id.f71483o_);
    }

    public final void l(@NotNull RedPackSkin$RecommendSkin skin) {
        Intrinsics.checkNotNullParameter(skin, "skin");
        this.recommendSkinView.setScene(1);
        this.recommendSkinView.A0(skin, 0);
    }
}
