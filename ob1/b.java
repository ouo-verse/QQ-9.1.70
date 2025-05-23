package ob1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView;
import com.tencent.mobileqq.filemanager.activity.fileassistant.QfileBaseTabView;
import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.aw;
import com.tencent.mobileqq.filemanager.widget.HeaderScrollView;
import com.tencent.mobileqq.filemanager.widget.SendBottomBar;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b extends PagerAdapter implements QfileBaseFavFileTabView.d {
    private HeaderScrollView C;

    /* renamed from: d, reason: collision with root package name */
    private Context f422320d;

    /* renamed from: e, reason: collision with root package name */
    private int[] f422321e;

    /* renamed from: f, reason: collision with root package name */
    private final Map<Integer, QfileBaseTabView> f422322f = new HashMap();

    /* renamed from: h, reason: collision with root package name */
    private boolean f422323h = false;

    /* renamed from: i, reason: collision with root package name */
    private int f422324i = -1;

    /* renamed from: m, reason: collision with root package name */
    private QfileBaseTabView f422325m;

    public b(Context context, int[] iArr) {
        this.f422320d = context;
        this.f422321e = iArr;
    }

    private QfileBaseTabView h(int i3) {
        QfileBaseTabView qfileBaseTabView = this.f422322f.get(Integer.valueOf(i3));
        if (qfileBaseTabView != null) {
            return qfileBaseTabView;
        }
        int i16 = this.f422321e[i3];
        QfileBaseTabView d16 = aw.d(this.f422320d, i16);
        if (d16 == null) {
            d16 = aw.b(this.f422320d, i16);
        }
        if (d16 == null) {
            d16 = aw.c(this.f422320d, i16);
        }
        if (d16 == null) {
            d16 = aw.a(this.f422320d, i16, this);
        }
        if (d16 == null) {
            QLog.e("FileViewPagerAdapter<FileAssistant>", 1, "getTabView return null!,tabPos:" + i3);
            return null;
        }
        d16.setFocusable(false);
        if (d16 instanceof QfileBaseRecentFileTabView) {
            ((QfileBaseRecentFileTabView) d16).setAttribution(1);
        }
        this.f422322f.put(Integer.valueOf(i3), d16);
        return d16;
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.d
    public boolean b() {
        return this.f422323h;
    }

    public void d(ArrayList<FileManagerEntity> arrayList) {
        Iterator<Integer> it = this.f422322f.keySet().iterator();
        while (it.hasNext()) {
            QfileBaseTabView qfileBaseTabView = this.f422322f.get(Integer.valueOf(it.next().intValue()));
            if (qfileBaseTabView != null) {
                qfileBaseTabView.l(arrayList);
            }
        }
    }

    public void destroy() {
        Iterator<Integer> it = this.f422322f.keySet().iterator();
        while (it.hasNext()) {
            QfileBaseTabView qfileBaseTabView = this.f422322f.get(Integer.valueOf(it.next().intValue()));
            if (qfileBaseTabView != null) {
                qfileBaseTabView.z();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i3, @NonNull Object obj) {
        viewGroup.removeView((View) obj);
    }

    public void e(ArrayList<WeiYunFileInfo> arrayList) {
        QfileBaseTabView qfileBaseTabView = this.f422322f.get(Integer.valueOf(this.f422324i));
        if (qfileBaseTabView != null) {
            qfileBaseTabView.m(arrayList);
        }
    }

    public void f(Set<FileInfo> set, SendBottomBar sendBottomBar) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = this.f422322f.keySet().iterator();
        int i3 = 0;
        while (it.hasNext()) {
            QfileBaseTabView qfileBaseTabView = this.f422322f.get(Integer.valueOf(it.next().intValue()));
            if (qfileBaseTabView != null) {
                if (qfileBaseTabView.x(set)) {
                    i3++;
                }
                arrayList.add(qfileBaseTabView);
            }
        }
        sendBottomBar.setRefreshTabCount(i3);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            ((QfileBaseTabView) it5.next()).n(set);
        }
    }

    public ListView g() {
        QfileBaseTabView qfileBaseTabView = this.f422322f.get(Integer.valueOf(this.f422324i));
        if (qfileBaseTabView != null) {
            return qfileBaseTabView.q();
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        int[] iArr = this.f422321e;
        if (iArr == null) {
            return 0;
        }
        return iArr.length;
    }

    public void i() {
        QfileBaseTabView qfileBaseTabView = this.f422322f.get(Integer.valueOf(this.f422324i));
        if (qfileBaseTabView != null) {
            qfileBaseTabView.C();
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    public Object instantiateItem(@NonNull ViewGroup viewGroup, int i3) {
        boolean z16;
        if (this.f422324i != -1 && this.f422322f.get(Integer.valueOf(i3)) == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QfileBaseTabView h16 = h(i3);
        if (h16 == null) {
            QLog.e("FileViewPagerAdapter", 1, "getTabView return null");
            return new FrameLayout(this.f422320d);
        }
        if (z16) {
            k(this.f422324i);
        }
        viewGroup.addView(h16);
        return h16;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view, @NonNull Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void j(HeaderScrollView headerScrollView) {
        this.C = headerScrollView;
    }

    public void k(int i3) {
        QfileBaseTabView qfileBaseTabView = this.f422325m;
        if (qfileBaseTabView != null) {
            qfileBaseTabView.onPause();
            this.f422325m.B();
        }
        this.f422324i = i3;
        QfileBaseTabView qfileBaseTabView2 = this.f422322f.get(Integer.valueOf(i3));
        this.f422325m = qfileBaseTabView2;
        if (qfileBaseTabView2 != null) {
            HeaderScrollView headerScrollView = this.C;
            if (headerScrollView != null) {
                headerScrollView.setCurrentScrollableContainer(qfileBaseTabView2);
            }
            this.f422325m.A();
            this.f422325m.setExpandGroup(true);
            this.f422325m.onResume();
        }
    }

    @Override // com.tencent.mobileqq.filemanager.activity.favfile.QfileBaseFavFileTabView.d
    public void setRefreshedFavList(boolean z16) {
        if (z16 == this.f422323h) {
            return;
        }
        QLog.i("FileViewPagerAdapter", 1, "FavFileS setRefreshedFavList:" + this.f422323h + "->" + z16);
        this.f422323h = z16;
    }
}
