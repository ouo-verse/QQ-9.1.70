package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.viewpager.widget.PagerAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.nearby.now.IResourceUtil;
import com.tencent.mobileqq.nearby.now.IStoryPlayController;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.IVideoPlayerView;
import com.tencent.mobileqq.nearby.now.view.StuffContainerView;
import com.tencent.mobileqq.nearby.now.view.logic.IVideoInfoListener;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends PagerAdapter implements View.OnClickListener, IVideoPlayerView.a {
    public boolean C;
    private boolean F;

    /* renamed from: d, reason: collision with root package name */
    protected LayoutInflater f252883d;

    /* renamed from: i, reason: collision with root package name */
    public IStoryPlayController f252887i;

    /* renamed from: m, reason: collision with root package name */
    public AppInterface f252888m;

    /* renamed from: e, reason: collision with root package name */
    public SparseArray<b> f252884e = new SparseArray<>();

    /* renamed from: f, reason: collision with root package name */
    public SparseArray<View> f252885f = new SparseArray<>();

    /* renamed from: h, reason: collision with root package name */
    public List<VideoData> f252886h = new ArrayList();
    private boolean D = true;
    private StuffContainerView.f E = null;
    public int G = 0;

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ IShortVideoCommentsView f252889d;

        a(IShortVideoCommentsView iShortVideoCommentsView) {
            this.f252889d = iShortVideoCommentsView;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            this.f252889d.showComment();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes15.dex */
    public class b {

        /* renamed from: a, reason: collision with root package name */
        public int f252891a;

        /* renamed from: b, reason: collision with root package name */
        public ViewGroup f252892b;

        /* renamed from: c, reason: collision with root package name */
        public RelativeLayout f252893c;

        /* renamed from: d, reason: collision with root package name */
        public OperationView f252894d;

        /* renamed from: e, reason: collision with root package name */
        public ImageDisplayView f252895e;

        /* renamed from: f, reason: collision with root package name */
        public QQStoryVideoPlayerErrorView f252896f;

        /* renamed from: g, reason: collision with root package name */
        public View f252897g;

        /* renamed from: h, reason: collision with root package name */
        public VideoData f252898h;

        public b() {
        }
    }

    public h(Context context, boolean z16) {
        this.C = z16;
        this.f252883d = LayoutInflater.from(context);
    }

    private void g(ImageView imageView) {
        if (imageView != null && imageView.getDrawable() != null && (imageView.getDrawable() instanceof URLDrawable) && ((URLDrawable) imageView.getDrawable()).getCurrDrawable() != null && (((URLDrawable) imageView.getDrawable()).getCurrDrawable() instanceof RegionDrawable) && ((RegionDrawable) ((URLDrawable) imageView.getDrawable()).getCurrDrawable()).getBitmap() != null) {
            ((RegionDrawable) ((URLDrawable) imageView.getDrawable()).getCurrDrawable()).getBitmap().recycle();
            if (((URLDrawable) imageView.getDrawable()).getURL() != null) {
                URLDrawable.removeMemoryCacheByUrl(((URLDrawable) imageView.getDrawable()).getURL().toString() + "#now");
            }
            imageView.setImageBitmap(null);
            imageView.setImageDrawable(null);
        }
    }

    public void d(int i3, List<VideoData> list) {
        if (i3 == 0) {
            int size = list.size();
            IStoryPlayController iStoryPlayController = this.f252887i;
            iStoryPlayController.setCurrentIndex(iStoryPlayController.getCurrentIndex() + size);
            h(size);
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < this.f252884e.size(); i16++) {
                arrayList.add(Integer.valueOf(this.f252884e.keyAt(i16)));
            }
            Object[] array = arrayList.toArray();
            Arrays.sort(array);
            for (int length = array.length - 1; length >= 0; length--) {
                int intValue = ((Integer) array[length]).intValue();
                this.f252884e.get(intValue).f252891a += size;
                SparseArray<b> sparseArray = this.f252884e;
                sparseArray.put(sparseArray.get(intValue).f252891a, this.f252884e.get(intValue));
                this.f252884e.delete(intValue);
            }
            ArrayList arrayList2 = new ArrayList();
            for (int i17 = 0; i17 < this.f252885f.size(); i17++) {
                arrayList2.add(Integer.valueOf(this.f252885f.keyAt(i17)));
            }
            Object[] array2 = arrayList2.toArray();
            Arrays.sort(array2);
            for (int length2 = array2.length - 1; length2 >= 0; length2--) {
                int intValue2 = ((Integer) array2[length2]).intValue();
                this.f252885f.put(intValue2 + size, this.f252885f.get(intValue2));
                this.f252885f.remove(intValue2);
            }
            this.G += size;
            this.f252886h.addAll(0, list);
            return;
        }
        if (i3 == 1) {
            this.f252886h.addAll(list);
        }
    }

    public void destroy() {
        OperationView operationView;
        for (int i3 = 0; i3 < this.f252884e.size(); i3++) {
            SparseArray<b> sparseArray = this.f252884e;
            b bVar = sparseArray.get(sparseArray.keyAt(i3));
            if (bVar != null && (operationView = bVar.f252894d) != null) {
                operationView.a();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        if (obj == null) {
            return;
        }
        View view = (View) obj;
        if (((b) view.getTag()) == null) {
            return;
        }
        ((b) view.getTag()).f252894d.a();
        viewGroup.removeView(view);
        IShortVideoCommentsView iShortVideoCommentsView = (IShortVideoCommentsView) obj;
        if (iShortVideoCommentsView.getPlayerView() != null) {
            g((ImageView) iShortVideoCommentsView.getPlayerView().findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getIvCover()));
            g((ImageView) iShortVideoCommentsView.getPlayerView().findViewById(((IResourceUtil) QRoute.api(IResourceUtil.class)).getDoodleView()));
        }
    }

    public b e(int i3) {
        return this.f252884e.get(i3);
    }

    public VideoData f(int i3) {
        List<VideoData> list = this.f252886h;
        if (list != null && i3 >= 0 && i3 < list.size()) {
            return this.f252886h.get(i3);
        }
        return null;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    /* renamed from: getCount */
    public int getF373114d() {
        return 100;
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getItemPosition(Object obj) {
        b bVar;
        int i3;
        int i16;
        if (obj == null || (bVar = (b) ((View) obj).getTag()) == null) {
            return -2;
        }
        if (bVar.f252891a == this.f252887i.getCurrentIndex()) {
            if (this.F) {
                this.F = false;
                return -2;
            }
            i3 = bVar.f252891a + 50;
            i16 = this.G;
        } else {
            i3 = bVar.f252891a + 50;
            i16 = this.G;
        }
        return i3 - i16;
    }

    public View getView(int i3) {
        return this.f252885f.get(i3);
    }

    public void h(int i3) {
        HashMap<Integer, Object> itemListeners = this.f252887i.getItemListeners();
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = itemListeners.keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(it.next().intValue()));
        }
        Object[] array = arrayList.toArray();
        Arrays.sort(array);
        for (int length = array.length - 1; length >= 0; length--) {
            int intValue = ((Integer) array[length]).intValue();
            itemListeners.put(Integer.valueOf(intValue + i3), (IVideoInfoListener) itemListeners.get(Integer.valueOf(intValue)));
            itemListeners.remove(Integer.valueOf(intValue));
        }
    }

    public void i(StuffContainerView.f fVar) {
        this.E = fVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.viewpager.widget.PagerAdapter
    public Object instantiateItem(ViewGroup viewGroup, int i3) {
        int i16 = (i3 - 50) + this.G;
        boolean z16 = true;
        if (i16 >= 0 && i16 < this.f252886h.size()) {
            VideoData videoData = this.f252886h.get(i16);
            b bVar = new b();
            IShortVideoCommentsView createShortVideoCommentsView = ((INowViewCreater) QRoute.api(INowViewCreater.class)).createShortVideoCommentsView(viewGroup.getContext());
            createShortVideoCommentsView.setApp(this.f252888m);
            createShortVideoCommentsView.init(bVar, videoData);
            View view = (View) createShortVideoCommentsView;
            bVar.f252894d.setOnCloseListener(this.E);
            bVar.f252894d.setOnCommentClickListener(new a(createShortVideoCommentsView));
            bVar.f252898h = videoData;
            IStoryPlayController iStoryPlayController = this.f252887i;
            if (iStoryPlayController != null) {
                iStoryPlayController.onViewConstruct(this.f252883d, this, bVar);
            }
            bVar.f252891a = i16;
            this.f252884e.put(i16, bVar);
            this.f252885f.put(i16, view);
            view.setTag(bVar);
            IStoryPlayController iStoryPlayController2 = this.f252887i;
            if (iStoryPlayController2 != null) {
                if (i16 != iStoryPlayController2.getFirstShowIndex()) {
                    z16 = false;
                }
                iStoryPlayController2.onFillData(bVar, videoData, z16, createShortVideoCommentsView);
                if (i16 == this.f252887i.getCurrentIndex()) {
                    this.f252887i.startPlayVideo(i16);
                }
                viewGroup.addView(view, -1, -1);
                return view;
            }
            throw new InvalidParameterException("VideoPlayerPagerAdapter not set mStoryPlayerController");
        }
        QLog.i("VideoPlayerPagerAdapter", 1, "position =" + i16 + " ! realIndex is:" + this.G);
        if (i16 != -1 && i16 != this.f252886h.size()) {
            return null;
        }
        return new View(viewGroup.getContext());
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(View view, Object obj) {
        if (view == obj) {
            return true;
        }
        return false;
    }

    public void j(IStoryPlayController iStoryPlayController, Bundle bundle) {
        this.f252887i = iStoryPlayController;
        this.D = false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IStoryPlayController iStoryPlayController = this.f252887i;
        if (iStoryPlayController != null) {
            iStoryPlayController.onPagerItemClick(view);
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
