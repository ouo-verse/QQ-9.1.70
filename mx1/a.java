package mx1;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private final View f417724d;

    public a(View view) {
        this.f417724d = view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public View instantiateItem(ViewGroup viewGroup, int i3) {
        View view = this.f417724d;
        QLog.d("GuildRobotTag:RobotAtViewPagerAdapter", 1, "instantiateItem position=" + i3 + ", view=" + view);
        viewGroup.addView(view);
        return view;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        QLog.d("GuildRobotTag:RobotAtViewPagerAdapter", 1, "destroyItem position=" + i3 + ", view=" + obj);
        viewGroup.removeView((View) obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        return 1;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }
}
