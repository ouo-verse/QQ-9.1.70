package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.aelight.camera.aioeditor.capture.data.k;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes32.dex */
public class FacePagerAdapter extends PagerAdapter implements FaceListPage.b {

    /* renamed from: d, reason: collision with root package name */
    private Context f68502d;

    /* renamed from: e, reason: collision with root package name */
    private k f68503e;

    /* renamed from: f, reason: collision with root package name */
    private FaceListPage.a f68504f;

    /* renamed from: h, reason: collision with root package name */
    private d f68505h;

    /* renamed from: i, reason: collision with root package name */
    private List<FaceListPage> f68506i = new LinkedList();

    public FacePagerAdapter(Context context) {
        this.f68502d = context;
    }

    @Override // com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.b
    public void c(final hr.b bVar) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePagerAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                if (FacePagerAdapter.this.f68505h instanceof EditVideoDoodle.f) {
                    ((EditVideoDoodle.f) FacePagerAdapter.this.f68505h).f(bVar);
                }
            }
        });
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        FaceListPage faceListPage = (FaceListPage) obj;
        viewGroup.removeView(faceListPage);
        faceListPage.Q = -1;
        faceListPage.t(null);
        this.f68506i.remove(faceListPage);
    }

    public void e(int i3) {
        List<FaceListPage> list = this.f68506i;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (FaceListPage faceListPage : this.f68506i) {
            int i16 = faceListPage.Q;
            if (i16 != i3 && faceListPage.S) {
                faceListPage.S = false;
                faceListPage.t(this.f68505h.getItem(i16));
                if (QLog.isColorLevel()) {
                    QLog.i("FacePagerAdapter", 2, "clearOtherView position:" + faceListPage.Q + ", current:" + i3);
                }
            }
        }
    }

    public FaceListPage f(int i3) {
        List<FaceListPage> list = this.f68506i;
        FaceListPage faceListPage = null;
        if (list != null) {
            for (FaceListPage faceListPage2 : list) {
                if (faceListPage2.Q == i3) {
                    faceListPage = faceListPage2;
                }
            }
        }
        return faceListPage;
    }

    public void g(int i3) {
        FaceListPage f16 = f(i3);
        if (f16 != null && !f16.S) {
            hr.a item = this.f68505h.getItem(i3);
            f16.S = true;
            f16.t(item);
        } else if (QLog.isColorLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("notifyNextPageShow loaded position:");
            sb5.append(i3);
            sb5.append(", page:");
            sb5.append(f16 != null);
            QLog.i("FacePagerAdapter", 2, sb5.toString());
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        d dVar = this.f68505h;
        if (dVar == null) {
            return 0;
        }
        return dVar.getCount();
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        return -2;
    }

    public void h() {
        notifyDataSetChanged();
    }

    public void i(int i3) {
        hr.a item = this.f68505h.getItem(i3);
        if (item != null) {
            for (FaceListPage faceListPage : this.f68506i) {
                if (faceListPage.Q == i3 && faceListPage.S) {
                    faceListPage.t(item);
                }
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        d dVar = this.f68505h;
        if (dVar == null) {
            return null;
        }
        hr.a item = dVar.getItem(i3);
        FaceListPage faceListPage = new FaceListPage(this.f68502d, this.f68503e, this.f68504f);
        if (item instanceof hr.b) {
            hr.b bVar = (hr.b) item;
            if (bVar.i()) {
                bVar.f406005p.set(true);
            } else {
                faceListPage.p(bVar);
            }
            faceListPage.setFavUIEventCb(this);
        }
        viewGroup.addView(faceListPage);
        faceListPage.Q = i3;
        if (((ViewPager) viewGroup).getCurrentItem() == i3) {
            faceListPage.S = true;
        } else {
            faceListPage.S = false;
        }
        faceListPage.t(item);
        this.f68506i.add(faceListPage);
        return faceListPage;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void j(FaceListPage.a aVar) {
        this.f68504f = aVar;
    }

    public void k(d dVar) {
        this.f68505h = dVar;
        notifyDataSetChanged();
    }

    public void l(k kVar) {
        this.f68503e = kVar;
    }

    public void onPageSelected(int i3) {
        for (FaceListPage faceListPage : this.f68506i) {
            if (faceListPage.Q == i3) {
                if (!faceListPage.S) {
                    hr.a item = this.f68505h.getItem(i3);
                    faceListPage.S = true;
                    faceListPage.t(item);
                }
                faceListPage.z();
            }
        }
    }
}
