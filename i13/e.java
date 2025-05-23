package i13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\b\u0010\f\u001a\u00020\u0004H\u0016J\u0018\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\rH\u0016J\u0018\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016R$\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\t0\u0015j\b\u0012\u0004\u0012\u00020\t`\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Li13/e;", "Landroidx/viewpager/widget/PagerAdapter;", "Landroid/view/View;", "view", "", "position", "", "d", "", "Li13/a;", "guideData", "e", "getCount", "", "obj", "", "isViewFromObject", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "instantiateItem", "destroyItem", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "data", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final ArrayList<GuideData> data = new ArrayList<>();

    private final void d(View view, int position) {
        Object orNull;
        orNull = CollectionsKt___CollectionsKt.getOrNull(this.data, position);
        GuideData guideData = (GuideData) orNull;
        if (guideData == null) {
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.q1j);
        ((TextView) view.findViewById(R.id.pot)).setText(guideData.getDes());
        imageView.setImageDrawable(URLDrawable.getDrawable(guideData.getUrl(), URLDrawable.URLDrawableOptions.obtain()));
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup container, int position, Object obj) {
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(obj, "obj");
        View view = obj instanceof View ? (View) obj : null;
        if (view != null) {
            container.removeView(view);
        }
    }

    public final void e(List<GuideData> guideData) {
        Intrinsics.checkNotNullParameter(guideData, "guideData");
        this.data.clear();
        this.data.addAll(guideData);
        notifyDataSetChanged();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.data.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup container, int position) {
        Intrinsics.checkNotNullParameter(container, "container");
        View view = LayoutInflater.from(container.getContext()).inflate(R.layout.dfk, container, false);
        container.addView(view, new ViewGroup.LayoutParams(-1, -1));
        Intrinsics.checkNotNullExpressionValue(view, "view");
        d(view, position);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(obj, "obj");
        return Intrinsics.areEqual(view, obj);
    }
}
