package com.tencent.biz.pubaccount.imagecollection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.pubaccount.imagecollection.b;
import com.tencent.biz.pubaccount.imagecollection.c;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.kandian.base.image.api.IImageManager;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes32.dex */
public class PublicAccountImageCollectionListView extends ListView implements AbsListView.OnScrollListener {
    private boolean C;
    private boolean D;
    private boolean E;
    private VelocityTracker F;
    private int G;
    private ArrayList<IPublicAccountImageCollectionUtils.c> H;
    private ArrayList<IPublicAccountImageCollectionUtils.d> I;
    int J;
    private long K;
    boolean L;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<a> f79699d;

    /* renamed from: e, reason: collision with root package name */
    private Context f79700e;

    /* renamed from: f, reason: collision with root package name */
    private int f79701f;

    /* renamed from: h, reason: collision with root package name */
    private AbsListView.OnScrollListener f79702h;

    /* renamed from: i, reason: collision with root package name */
    private float f79703i;

    /* renamed from: m, reason: collision with root package name */
    private float f79704m;

    /* loaded from: classes32.dex */
    public interface a {
        void a(Object obj);
    }

    /* loaded from: classes32.dex */
    static class b {

        /* renamed from: a, reason: collision with root package name */
        public URL f79712a;

        /* renamed from: b, reason: collision with root package name */
        public int f79713b;

        /* renamed from: c, reason: collision with root package name */
        public int f79714c;

        b() {
        }

        public static b a(URL url, int i3, int i16) {
            b bVar = new b();
            bVar.f79712a = url;
            bVar.f79713b = i3;
            bVar.f79714c = i16;
            return bVar;
        }
    }

    public PublicAccountImageCollectionListView(Context context) {
        this(context, null);
    }

    private int f0() {
        for (int firstVisiblePosition = getFirstVisiblePosition(); firstVisiblePosition <= getLastVisiblePosition(); firstVisiblePosition++) {
            int top = getChildAt(firstVisiblePosition - getFirstVisiblePosition()).getTop();
            int bottom = getChildAt(firstVisiblePosition - getFirstVisiblePosition()).getBottom();
            int i3 = this.f79701f;
            if (top < i3 / 2 && bottom > i3 / 2) {
                return firstVisiblePosition;
            }
        }
        return -1;
    }

    private void i0(final int i3, final int i16) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg start:" + i3 + " count:" + i16);
        }
        if (this.H == null) {
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (NetworkUtil.isWifiConnected(this.f79700e)) {
            final ArrayList arrayList = new ArrayList(this.H);
            final long j3 = this.K;
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (PublicAccountImageCollectionListView.this.K != j3) {
                        return;
                    }
                    List list = arrayList;
                    int size = list == null ? 0 : list.size();
                    LinkedList<b> linkedList = new LinkedList();
                    for (int i17 = i3; i17 < i3 + i16; i17++) {
                        if (i17 <= size && i17 >= 1) {
                            if (PublicAccountImageCollectionListView.this.K != j3) {
                                return;
                            }
                            try {
                                IPublicAccountImageCollectionUtils.c cVar = (IPublicAccountImageCollectionUtils.c) arrayList.get(i17 - 1);
                                if (cVar == null) {
                                    continue;
                                } else {
                                    URL s16 = ((com.tencent.biz.pubaccount.imagecollection.b) PublicAccountImageCollectionListView.this.getAdapter()).s(cVar.f79746a);
                                    if (s16 == null) {
                                        return;
                                    }
                                    int i18 = ((com.tencent.biz.pubaccount.imagecollection.b) PublicAccountImageCollectionListView.this.getAdapter()).q(cVar)[0];
                                    int i19 = ((com.tencent.biz.pubaccount.imagecollection.b) PublicAccountImageCollectionListView.this.getAdapter()).q(cVar)[1];
                                    linkedList.add(b.a(s16, i18, i19));
                                    if (QLog.isColorLevel()) {
                                        QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg index:" + i17 + "  reqWidth = " + i18 + " reqHeight = " + i19);
                                    }
                                }
                            } catch (Exception e16) {
                                e16.printStackTrace();
                                if (PublicAccountImageCollectionListView.this.K != j3) {
                                    return;
                                }
                            }
                        }
                    }
                    if (PublicAccountImageCollectionListView.this.K != j3) {
                        return;
                    }
                    for (b bVar : linkedList) {
                        if (bVar != null && bVar.f79712a != null) {
                            com.tencent.mobileqq.kandian.base.image.b bVar2 = new com.tencent.mobileqq.kandian.base.image.b();
                            bVar2.f239004a = bVar.f79712a;
                            bVar2.f239005b = bVar.f79713b;
                            bVar2.f239006c = bVar.f79714c;
                            ((IImageManager) QRoute.api(IImageManager.class)).loadImage(bVar2, null);
                        }
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("PublicAccountImageCollectionListView", 2, "preloadImg size:" + linkedList.size() + " cost:" + (System.currentTimeMillis() - currentTimeMillis));
                    }
                }
            }, 5, null, true);
        }
    }

    private void j0() {
        if (!this.L && ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).canPreload()) {
            ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).cancelNotDownloadTask();
            ArrayList<IPublicAccountImageCollectionUtils.d> arrayList = this.I;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).addTask(this.I.get(i3).f79755d);
                }
            }
            this.L = true;
        }
    }

    private void l0(int i3) {
        View childAt = getChildAt(i3 - getFirstVisiblePosition());
        if (childAt == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionListView", 2, "smoothScrollTo targetView is null");
                return;
            }
            return;
        }
        if (i3 != f0()) {
            this.E = true;
        }
        int top = childAt.getTop();
        int bottom = childAt.getBottom();
        if (childAt.getTag() instanceof b.h) {
            b.h hVar = (b.h) childAt.getTag();
            if (hVar.f79836b.getBottom() != hVar.f79837c.getBottom()) {
                bottom = hVar.f79837c.getBottom() + top;
            }
        }
        final int i16 = ((top + bottom) / 2) - (this.f79701f / 2);
        if (i16 == 0) {
            return;
        }
        int abs = Math.abs(i16);
        int abs2 = Math.abs(this.G);
        final int i17 = abs2 == 0 ? 400 : abs / abs2;
        this.C = true;
        ((IImageManager) QRoute.api(IImageManager.class)).pauseDownload();
        post(new Runnable() { // from class: com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView.1
            @Override // java.lang.Runnable
            public void run() {
                PublicAccountImageCollectionListView.this.smoothScrollBy(i16, i17);
            }
        });
    }

    public void c0(a aVar) {
        this.f79699d.add(aVar);
    }

    public void e0() {
        ArrayList<a> arrayList = this.f79699d;
        if (arrayList != null) {
            arrayList.clear();
            this.f79699d = null;
        }
        VelocityTracker velocityTracker = this.F;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.F = null;
        }
        this.f79700e = null;
        ((IImageManager) QRoute.api(IImageManager.class)).clean();
    }

    public ViewGroup g0() {
        return (ViewGroup) getChildAt(f0() - getFirstVisiblePosition());
    }

    public Boolean h0(View view) {
        return Boolean.valueOf(g0().equals(view));
    }

    void init(Context context) {
        this.f79700e = context;
        this.F = VelocityTracker.obtain();
        super.setOnScrollListener(this);
    }

    void k0() {
        for (int firstVisiblePosition = getFirstVisiblePosition(); firstVisiblePosition <= getLastVisiblePosition(); firstVisiblePosition++) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(firstVisiblePosition - getFirstVisiblePosition());
            if (viewGroup.getTop() < this.f79701f / 2 && viewGroup.getBottom() > this.f79701f / 2) {
                if (viewGroup.getTag() instanceof c.C0813c) {
                    viewGroup.setClickable(false);
                    viewGroup.getChildAt(0).setClickable(true);
                    viewGroup.getChildAt(0).setFocusable(true);
                    viewGroup.getChildAt(0).setEnabled(true);
                }
                if (viewGroup.getTag() instanceof b.h) {
                    viewGroup.setClickable(false);
                    viewGroup.getChildAt(1).setClickable(true);
                    viewGroup.getChildAt(1).setFocusable(true);
                    viewGroup.getChildAt(1).setEnabled(true);
                }
            } else {
                if (viewGroup.getTag() instanceof c.C0813c) {
                    viewGroup.setClickable(true);
                    viewGroup.getChildAt(0).setClickable(false);
                    viewGroup.getChildAt(0).setFocusable(false);
                    viewGroup.getChildAt(0).setEnabled(false);
                }
                if (viewGroup.getTag() instanceof b.h) {
                    viewGroup.setClickable(true);
                    viewGroup.getChildAt(1).setClickable(false);
                    viewGroup.getChildAt(1).setFocusable(false);
                    viewGroup.getChildAt(1).setEnabled(false);
                }
            }
        }
    }

    public void m0() {
        l0(this.J);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.C) {
            return true;
        }
        if (motionEvent.getAction() == 0) {
            this.E = false;
            this.D = false;
            this.f79703i = motionEvent.getY();
            this.J = f0();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // com.tencent.widget.ListView, com.tencent.widget.AbsListView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.C) {
            return true;
        }
        if (this.F == null) {
            this.F = VelocityTracker.obtain();
        }
        this.F.addMovement(motionEvent);
        if (motionEvent.getAction() == 1) {
            this.f79704m = motionEvent.getY();
            this.F.clear();
        } else if (motionEvent.getAction() == 2) {
            this.F.computeCurrentVelocity(1);
            this.G = (int) this.F.getYVelocity();
            if (this.D) {
                return true;
            }
            if (getChildAt(this.J - getFirstVisiblePosition()) != null) {
                if (Math.abs(motionEvent.getY() - this.f79703i) >= ((int) (r0.getHeight() * 0.8d))) {
                    if (motionEvent.getY() - this.f79703i > 0.0f) {
                        this.D = true;
                        l0(this.J - 1);
                        return true;
                    }
                    if (motionEvent.getY() - this.f79703i < 0.0f) {
                        this.D = true;
                        l0(this.J + 1);
                        return true;
                    }
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setPhotoCollectionInfo(ArrayList<IPublicAccountImageCollectionUtils.c> arrayList) {
        this.H = arrayList;
        i0(1, 1);
    }

    public void setRecommendInfo(ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
        this.I = arrayList;
    }

    public void setScreenHeight(int i3) {
        this.f79701f = i3;
    }

    public PublicAccountImageCollectionListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f79699d = new ArrayList<>();
        this.f79702h = null;
        this.C = false;
        this.D = false;
        this.E = false;
        this.G = 0;
        this.H = null;
        this.I = null;
        this.K = 0L;
        this.L = false;
        init(context);
    }

    void d0(View view) {
        VideoFeedsAlphaMaskView videoFeedsAlphaMaskView;
        if (view == null || view.getTag() == null) {
            return;
        }
        if (view.getTag() instanceof b.h) {
            videoFeedsAlphaMaskView = ((b.h) view.getTag()).f79839e;
        } else if (view.getTag() instanceof b.g) {
            videoFeedsAlphaMaskView = ((b.g) view.getTag()).f79831j;
        } else {
            videoFeedsAlphaMaskView = view.getTag() instanceof c.C0813c ? ((c.C0813c) view.getTag()).f79855b : null;
        }
        float round = Math.round((Math.abs(((view.getBottom() + view.getTop()) / 2) - (this.f79701f / 2)) / ((view.getBottom() - view.getTop()) / 2)) * 100.0f) / 100.0f;
        if (round > 1.0f) {
            round = 1.0f;
        }
        if (videoFeedsAlphaMaskView != null) {
            videoFeedsAlphaMaskView.setAlpha(round);
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        for (int i18 = 0; i18 < i16; i18++) {
            d0(absListView.getChildAt(i18));
        }
    }

    @Override // com.tencent.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView absListView, int i3) {
        ArrayList<a> arrayList;
        if (i3 == 0) {
            if (!this.C) {
                l0(this.J);
            }
            this.C = false;
            ViewGroup g06 = g0();
            if (this.E && (arrayList = this.f79699d) != null && g06 != null) {
                Iterator<a> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().a(g06.getTag());
                }
            }
            ((IImageManager) QRoute.api(IImageManager.class)).resume();
            i0(getFirstVisiblePosition(), (getLastVisiblePosition() - getFirstVisiblePosition()) + 1 + ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).getPreloadImageCount());
            if (getChildAt(absListView.getLastVisiblePosition() - getFirstVisiblePosition()).getTag() instanceof c.C0813c) {
                j0();
            }
            k0();
        } else if (i3 == 2) {
            if (this.C) {
                return;
            }
            if (this.f79704m - this.f79703i > 0.0f) {
                l0(this.J - 1);
            } else {
                l0(this.J + 1);
            }
        }
        AbsListView.OnScrollListener onScrollListener = this.f79702h;
        if (onScrollListener != null) {
            onScrollListener.onScrollStateChanged(absListView, i3);
        }
    }

    public PublicAccountImageCollectionListView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f79699d = new ArrayList<>();
        this.f79702h = null;
        this.C = false;
        this.D = false;
        this.E = false;
        this.G = 0;
        this.H = null;
        this.I = null;
        this.K = 0L;
        this.L = false;
        init(context);
    }
}
