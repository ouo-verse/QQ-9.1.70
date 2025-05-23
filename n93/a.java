package n93;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.wink.publish.widget.QCirclePicPreviewImage;
import java.util.ArrayList;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes21.dex */
public class a extends PagerAdapter {

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<k93.a> f419529d = new ArrayList<>();

    /* renamed from: e, reason: collision with root package name */
    private LinkedList<View> f419530e = new LinkedList<>();

    public ArrayList<k93.a> d() {
        return this.f419529d;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        View view = (View) obj;
        viewGroup.removeView(view);
        this.f419530e.add(view);
    }

    public void e(ArrayList<k93.a> arrayList) {
        this.f419529d.clear();
        notifyDataSetChanged();
        if (arrayList != null) {
            this.f419529d.addAll(arrayList);
            notifyDataSetChanged();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return this.f419529d.size();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        if (getF373114d() == 0) {
            return -2;
        }
        return super.getItemPosition(obj);
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
        View qCirclePicPreviewImage;
        k93.a aVar = this.f419529d.get(i3);
        if (this.f419530e.size() > 0) {
            qCirclePicPreviewImage = this.f419530e.removeFirst();
        } else {
            qCirclePicPreviewImage = new QCirclePicPreviewImage(viewGroup.getContext());
            qCirclePicPreviewImage.setLayoutParams(new FrameLayout.LayoutParams(-1, -1, 17));
        }
        viewGroup.addView(qCirclePicPreviewImage);
        ((QCirclePicPreviewImage) qCirclePicPreviewImage).setData(aVar, i3);
        return qCirclePicPreviewImage;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }
}
