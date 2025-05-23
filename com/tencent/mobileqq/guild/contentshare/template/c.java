package com.tencent.mobileqq.guild.contentshare.template;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate;
import com.tencent.mobileqq.guild.contentshare.d;
import com.tencent.mobileqq.guild.contentshare.g;
import com.tencent.mobileqq.guild.contentshare.h;
import com.tencent.mobileqq.guild.contentshare.template.HeaderComponent;
import com.tencent.mobileqq.guild.contentshare.template.content.MsgContentComponent;
import com.tencent.mobileqq.guild.contentshare.widget.BounceScrollView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.dp;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0016J \u0010\u000b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\n\u0010\r\u001a\u0004\u0018\u00010\fH\u0017J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/contentshare/template/c;", "Lcom/tencent/mobileqq/guild/contentshare/AbsGuildContentShareTemplate;", "Landroid/util/SparseArray;", "Lcom/tencent/mobileqq/guild/contentshare/g;", "d", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/contentshare/d;", "shareData", "Landroid/view/View;", HippyNestedScrollComponent.PRIORITY_PARENT, "j", "Landroid/view/ViewGroup;", "k", "", "e", "Lvp1/dp;", "Lvp1/dp;", "officialBinding", "<init>", "()V", "f", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends AbsGuildContentShareTemplate {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private dp officialBinding;

    public c() {
        super(0);
    }

    @Override // com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate
    @NotNull
    public SparseArray<g> d() {
        SparseArray<g> sparseArray = new SparseArray<>();
        sparseArray.put(0, new vg1.a(this));
        sparseArray.put(1, new HeaderComponent(HeaderComponent.LayoutType.Vertical));
        sparseArray.put(2, new com.tencent.mobileqq.guild.contentshare.template.content.b(this));
        sparseArray.put(3, new MsgContentComponent(this));
        sparseArray.put(4, new b(0, 1, null));
        return sparseArray;
    }

    @Override // com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate
    @NotNull
    public View j(@NotNull Context context, @NotNull d shareData, @NotNull View parent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(shareData, "shareData");
        Intrinsics.checkNotNullParameter(parent, "parent");
        h.MsgContentStyle msgContentStyle = new h.MsgContentStyle(-16777216, R.layout.f8n, 29.0f, -16777216);
        dp g16 = dp.g(LayoutInflater.from(context), new FrameLayout(context), false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(LayoutInflater.f\u2026meLayout(context), false)");
        this.officialBinding = g16;
        g16.getRoot().measure(View.MeasureSpec.makeMeasureSpec(parent.getMeasuredWidth(), 1073741824), 0);
        g g17 = g(0);
        if (g17 != null) {
            ConstraintLayout constraintLayout = g16.f442963b;
            Intrinsics.checkNotNullExpressionValue(constraintLayout, "binding.bgContainer");
            g.a.a(g17, constraintLayout, shareData, null, 4, null);
        }
        g g18 = g(1);
        if (g18 != null) {
            FrameLayout frameLayout = g16.f442966e;
            Intrinsics.checkNotNullExpressionValue(frameLayout, "binding.headerArea");
            g.a.a(g18, frameLayout, shareData, null, 4, null);
        }
        g g19 = g(2);
        if (g19 != null) {
            FrameLayout frameLayout2 = g16.f442965d;
            Intrinsics.checkNotNullExpressionValue(frameLayout2, "binding.contentArea");
            g19.a(frameLayout2, shareData, msgContentStyle);
        }
        g g26 = g(3);
        if (g26 != null) {
            FrameLayout frameLayout3 = g16.f442965d;
            Intrinsics.checkNotNullExpressionValue(frameLayout3, "binding.contentArea");
            g26.a(frameLayout3, shareData, msgContentStyle);
        }
        g g27 = g(4);
        if (g27 != null) {
            FrameLayout frameLayout4 = g16.f442964c;
            Intrinsics.checkNotNullExpressionValue(frameLayout4, "binding.bottomArea");
            g.a.a(g27, frameLayout4, shareData, null, 4, null);
        }
        l(g16.getRoot(), ViewUtils.dpToPx(6.0f));
        ImageView imageView = g16.f442969h;
        Intrinsics.checkNotNullExpressionValue(imageView, "binding.topTitle");
        m(imageView, "https://downv6.qq.com/innovate/guild/common/guild_share_template1_top_v3.png");
        if (!FontSettingManager.isFontSizeNormal()) {
            FontSettingManager.resetViewSize2Normal(context, g16.getRoot());
        }
        BounceScrollView root = g16.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "binding.root");
        return root;
    }

    @Override // com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate
    @SuppressLint({"UseCompatLoadingForDrawables"})
    @Nullable
    public ViewGroup k() {
        FrameLayout frameLayout;
        Drawable mutate;
        dp dpVar = this.officialBinding;
        if (dpVar != null && (frameLayout = dpVar.f442968g) != null) {
            int parseColor = Color.parseColor("#80000000");
            ((TextView) frameLayout.findViewById(R.id.f79624__)).setTextColor(parseColor);
            ImageView imageView = (ImageView) frameLayout.findViewById(R.id.f79544_2);
            Drawable drawable = frameLayout.getContext().getDrawable(R.drawable.guild_content_share_arrow);
            if (drawable != null && (mutate = drawable.mutate()) != null) {
                DrawableCompat.setTint(mutate, parseColor);
                imageView.setImageDrawable(mutate);
            }
            return frameLayout;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.guild.contentshare.AbsGuildContentShareTemplate
    public void e() {
    }
}
