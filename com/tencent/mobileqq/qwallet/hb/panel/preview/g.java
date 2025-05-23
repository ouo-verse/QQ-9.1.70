package com.tencent.mobileqq.qwallet.hb.panel.preview;

import android.content.res.Resources;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/g;", "Landroidx/viewpager2/widget/ViewPager2$PageTransformer;", "Landroid/view/View;", "page", "", "position", "", "transformPage", "a", UserInfo.SEX_FEMALE, "margin", "b", "offset", "<init>", "()V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class g implements ViewPager2.PageTransformer {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final float margin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final float offset;

    public g() {
        Resources resources = MobileQQ.sMobileQQ.getApplicationContext().getResources();
        this.margin = resources.getDimension(R.dimen.dch);
        this.offset = resources.getDimension(R.dimen.dci);
    }

    @Override // androidx.viewpager2.widget.ViewPager2.PageTransformer
    public void transformPage(@NotNull View page, float position) {
        float coerceAtMost;
        Intrinsics.checkNotNullParameter(page, "page");
        coerceAtMost = RangesKt___RangesKt.coerceAtMost(Math.abs(position), 1.0f);
        float f16 = 1.0f - (coerceAtMost * 0.17f);
        page.setScaleX(f16);
        page.setScaleY(f16);
    }
}
