package com.tencent.mobileqq.zplan.card.impl.view.banner;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.viewpager2.widget.ViewPager2;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.sqshow.zootopia.data.ZootopiaCardData;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J#\u0010\t\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a2\u0006\u0004\b\t\u0010\nJ:\u0010\u0015\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H&\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/zplan/card/impl/view/banner/b;", "", "Landroid/view/View;", "getView", "Landroidx/viewpager2/widget/ViewPager2;", "viewpager", "", "viewBgColor", "", "b", "(Landroidx/viewpager2/widget/ViewPager2;Ljava/lang/Integer;)V", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Loa4/a;", "mapResViewModel", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "Lcom/tencent/sqshow/zootopia/data/c;", "dataInfo", com.tencent.luggage.wxa.c8.c.G, "cardPos", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface b {
    void a(LifecycleOwner owner, oa4.a mapResViewModel, ZootopiaSource sourceCurrent, ZootopiaCardData dataInfo, int pos, int cardPos);

    void b(ViewPager2 viewpager, Integer viewBgColor);

    View getView();
}
