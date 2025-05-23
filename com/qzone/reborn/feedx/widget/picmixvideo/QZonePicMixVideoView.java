package com.qzone.reborn.feedx.widget.picmixvideo;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.proxy.feedcomponent.model.BusinessFeedData;
import com.qzone.proxy.feedcomponent.model.CellPictureInfo;
import com.qzone.proxy.feedcomponent.model.PictureItem;
import com.qzone.reborn.feedx.util.x;
import com.qzone.reborn.widget.QZoneBaseWidgetView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import gf.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes37.dex */
public class QZonePicMixVideoView extends QZoneBaseWidgetView<BusinessFeedData> implements r {
    public static final int F = ImmersiveUtils.dpToPx(3.0f);
    private c C;
    private View.OnTouchListener D;
    private int E;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f56459e;

    /* renamed from: f, reason: collision with root package name */
    private d f56460f;

    /* renamed from: h, reason: collision with root package name */
    private GridLayoutManager f56461h;

    /* renamed from: i, reason: collision with root package name */
    private RecyclerView.ItemDecoration f56462i;

    /* renamed from: m, reason: collision with root package name */
    private List<PictureItem> f56463m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (QZonePicMixVideoView.this.D != null) {
                return QZonePicMixVideoView.this.D.onTouch(view, motionEvent);
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes37.dex */
    public class b extends RecyclerView.ItemDecoration {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            List list = QZonePicMixVideoView.this.f56463m;
            if (list != null && !list.isEmpty() && list.size() != 1) {
                if (QZonePicMixVideoView.this.I0(list)) {
                    QZonePicMixVideoView.this.w0(rect, view, recyclerView, list.size(), 2);
                    return;
                } else {
                    QZonePicMixVideoView.this.w0(rect, view, recyclerView, list.size(), 3);
                    return;
                }
            }
            super.getItemOffsets(rect, view, recyclerView, state);
        }
    }

    /* loaded from: classes37.dex */
    public interface c {
        void a(PictureItem pictureItem, int i3, View view);
    }

    public QZonePicMixVideoView(Context context) {
        this(context, null);
    }

    private void A0() {
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f56459e = (RecyclerView) findViewById(R.id.f162898n73);
        this.f56461h = new GridLayoutManager(getContext(), 1);
        this.f56459e.setLayoutManager(new LinearLayoutManager(getContext()));
        this.f56459e.setNestedScrollingEnabled(false);
        this.f56459e.setOnTouchListener(new a());
        d dVar = new d();
        this.f56460f = dVar;
        dVar.n0(new c() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.f
            @Override // com.qzone.reborn.feedx.widget.picmixvideo.QZonePicMixVideoView.c
            public final void a(PictureItem pictureItem, int i3, View view) {
                QZonePicMixVideoView.this.C0(pictureItem, i3, view);
            }
        });
        this.f56459e.setAdapter(this.f56460f);
        this.f56462i = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B0() {
        RecyclerView.ItemDecoration itemDecoration;
        RecyclerView recyclerView = this.f56459e;
        if (recyclerView == null || (itemDecoration = this.f56462i) == null) {
            return;
        }
        recyclerView.addItemDecoration(itemDecoration);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C0(PictureItem pictureItem, int i3, View view) {
        c cVar = this.C;
        if (cVar != null) {
            cVar.a(pictureItem, i3, view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void E0() {
        this.f56460f.notifyDataSetChanged();
    }

    private void G0() {
        d dVar = this.f56460f;
        if (dVar == null || this.f56463m == null) {
            return;
        }
        dVar.o0(this.E);
        this.f56460f.k0(getData(), this.f56463m);
        F0(5, new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.e
            @Override // java.lang.Runnable
            public final void run() {
                QZonePicMixVideoView.this.E0();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void w0(Rect rect, View view, RecyclerView recyclerView, int i3, int i16) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        rect.top = 0;
        if (i16 == 2) {
            if (childAdapterPosition % i16 == 0) {
                rect.left = 0;
                rect.right = F / 2;
            } else {
                rect.left = F / 2;
                rect.right = 0;
            }
        } else if (i16 == 3) {
            int i17 = childAdapterPosition % i16;
            if (i17 == 0) {
                rect.left = 0;
                rect.right = (int) ((F / 3.0f) * 2.0f);
            } else if (i17 == 1) {
                int i18 = F;
                rect.left = i18 / 3;
                rect.right = i18 / 3;
            } else {
                rect.left = (int) ((F / 3.0f) * 2.0f);
                rect.right = 0;
            }
        }
        if (childAdapterPosition < i3 - i16) {
            rect.bottom = F;
        }
    }

    private r y0() {
        GridLayoutManager gridLayoutManager = this.f56461h;
        if (gridLayoutManager == null) {
            return null;
        }
        int findFirstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.f56461h.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition >= 0 && findLastVisibleItemPosition >= 0 && findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            while (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
                Object findViewByPosition = this.f56461h.findViewByPosition(findFirstVisibleItemPosition);
                if (findViewByPosition instanceof r) {
                    QLog.d("PSLink-QZonePicMixVideoView", 1, "findFirstVideoItemWidgetView  | feedPos = " + this.dataPosInList + " | picPos = " + findFirstVisibleItemPosition + " | view = " + findViewByPosition);
                    return (r) findViewByPosition;
                }
                findFirstVisibleItemPosition++;
            }
        }
        return null;
    }

    @Override // gf.r
    public void a() {
        r y06 = y0();
        if (y06 != null) {
            y06.a();
        }
    }

    @Override // gf.r
    public QZoneVideoItemWidgetView d() {
        r y06 = y0();
        if (y06 != null) {
            return y06.d();
        }
        return null;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.chk;
    }

    @Override // gf.r
    public void pause() {
        r y06 = y0();
        if (y06 != null) {
            y06.pause();
        }
    }

    @Override // gf.r
    public void play() {
        r y06 = y0();
        if (y06 != null) {
            y06.play();
        }
    }

    public void setEnableOverLimit(boolean z16) {
        this.f56460f.l0(z16);
    }

    public void setItemViewMultiBorderWidth(int i3) {
        this.E = i3;
    }

    public void setOnEmptyTouchListener(View.OnTouchListener onTouchListener) {
        this.D = onTouchListener;
    }

    public void setOnItemClickListener(c cVar) {
        this.C = cVar;
    }

    public void v0() {
        if (this.f56459e != null) {
            F0(5, new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.g
                @Override // java.lang.Runnable
                public final void run() {
                    QZonePicMixVideoView.this.B0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: x0, reason: merged with bridge method [inline-methods] */
    public void bindData(BusinessFeedData businessFeedData, int i3) {
        ArrayList<PictureItem> arrayList = new ArrayList<>();
        if (businessFeedData != null && businessFeedData.getPictureInfo() != null && businessFeedData.getPictureInfo().pics != null) {
            CellPictureInfo pictureInfo = businessFeedData.getPictureInfo();
            pictureInfo.pics.removeAll(Collections.singleton(null));
            arrayList = pictureInfo.pics;
        }
        if (!this.f56459e.isComputingLayout()) {
            this.f56459e.removeItemDecoration(this.f56462i);
        }
        this.f56463m = arrayList;
        int pageType = k0().getPageType();
        boolean z16 = pageType == 10;
        int i16 = x.f55790a.c(pageType) ? 18 : 9;
        if (!z16 && arrayList.size() > i16) {
            this.f56463m = arrayList.subList(0, i16);
        }
        if (H0(this.f56463m)) {
            this.f56461h.setSpanCount(1);
        } else if (I0(this.f56463m)) {
            this.f56461h.setSpanCount(2);
            v0();
        } else {
            this.f56461h.setSpanCount(3);
            v0();
        }
        this.f56459e.setLayoutManager(this.f56461h);
        this.f56460f.m0(this.dataPosInList);
        G0();
    }

    public RecyclerView z0() {
        return this.f56459e;
    }

    public QZonePicMixVideoView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QZonePicMixVideoView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        A0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D0(int i3, Runnable runnable) {
        F0(i3 - 1, runnable);
    }

    private void F0(final int i3, final Runnable runnable) {
        RecyclerView recyclerView;
        if (i3 != 0 && (recyclerView = this.f56459e) != null) {
            if (recyclerView.isComputingLayout()) {
                this.f56459e.postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.picmixvideo.h
                    @Override // java.lang.Runnable
                    public final void run() {
                        QZonePicMixVideoView.this.D0(i3, runnable);
                    }
                }, 20L);
                return;
            } else {
                runnable.run();
                return;
            }
        }
        RFWLog.i("QZonePicMixVideoView", RFWLog.USR, "safeNotify return count = " + i3);
    }

    private boolean H0(List<PictureItem> list) {
        return list == null || list.isEmpty() || list.size() == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean I0(List<PictureItem> list) {
        if (list == null) {
            return false;
        }
        return list.size() == 2 || list.size() == 4;
    }
}
