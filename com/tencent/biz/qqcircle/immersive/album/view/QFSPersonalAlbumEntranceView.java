package com.tencent.biz.qqcircle.immersive.album.view;

import a40.f;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.beans.QCircleAlbumDetailBean;
import com.tencent.biz.qqcircle.beans.QCircleAlbumListBean;
import com.tencent.biz.qqcircle.events.QCircleAlbumEvent;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.requests.QCircleDeleteAlbumRequest;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import feedcloud.FeedCloudMeta$FeedAlbumInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import qqcircle.QQCircleFeedAlbum$DeleteAlbumRsp;
import z30.b;

/* loaded from: classes4.dex */
public class QFSPersonalAlbumEntranceView extends LinearLayout implements b.a {
    private static final String C = "com.tencent.biz.qqcircle.immersive.album.view.QFSPersonalAlbumEntranceView";
    public static final int D = cx.a(18.0f);
    public static final int E = cx.a(18.0f);
    public static final int F = cx.a(8.0f);
    private static final int G = cx.a(20.0f);

    /* renamed from: d, reason: collision with root package name */
    private Context f84841d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f84842e;

    /* renamed from: f, reason: collision with root package name */
    private a40.f f84843f;

    /* renamed from: h, reason: collision with root package name */
    private b40.d f84844h;

    /* renamed from: i, reason: collision with root package name */
    public c f84845i;

    /* renamed from: m, reason: collision with root package name */
    private float f84846m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a implements f.c {
        a() {
        }

        @Override // a40.f.c
        public void a() {
            QFSPersonalAlbumEntranceView.this.m();
        }

        @Override // a40.f.c
        public void b(b40.a aVar) {
            if (!fb0.a.a(QFSPersonalAlbumEntranceView.C)) {
                QFSPersonalAlbumEntranceView.this.h(aVar);
            }
        }

        @Override // a40.f.c
        public void c(b40.a aVar, boolean z16) {
            try {
                QCircleAlbumDetailBean qCircleAlbumDetailBean = new QCircleAlbumDetailBean();
                qCircleAlbumDetailBean.setFeedAlbum(aVar.f().album.get());
                com.tencent.biz.qqcircle.launcher.c.Z(QFSPersonalAlbumEntranceView.this.f84841d, qCircleAlbumDetailBean);
            } catch (Exception e16) {
                QLog.e(QFSPersonalAlbumEntranceView.C, 4, e16, new Object[0]);
            }
        }

        @Override // a40.f.c
        public void d() {
            if (fb0.a.a(QFSPersonalAlbumEntranceView.C) || com.tencent.biz.qqcircle.helpers.d.a(10, true)) {
                return;
            }
            com.tencent.biz.qqcircle.launcher.c.o0(QFSPersonalAlbumEntranceView.this.getContext(), uq3.c.o3(), null, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class c extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final int f84849d;

        /* renamed from: e, reason: collision with root package name */
        final int f84850e;

        /* renamed from: f, reason: collision with root package name */
        final int f84851f;

        public c(int i3, int i16, int i17) {
            this.f84849d = i3;
            this.f84850e = i16;
            this.f84851f = i17;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getAdapter() == null) {
                return;
            }
            if (recyclerView.getChildAdapterPosition(view) == 0) {
                if (QFSPersonalAlbumEntranceView.this.f84843f.getNUM_BACKGOURND_ICON() == 1) {
                    rect.left = this.f84849d;
                    rect.right = this.f84851f;
                    return;
                } else {
                    rect.left = this.f84849d;
                    rect.right = this.f84850e / 2;
                    return;
                }
            }
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getNUM_BACKGOURND_ICON() - 1) {
                rect.left = this.f84850e / 2;
                rect.right = this.f84851f;
            } else {
                int i3 = this.f84850e;
                rect.left = i3 / 2;
                rect.right = i3 / 2;
            }
        }
    }

    public QFSPersonalAlbumEntranceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(b40.a aVar) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleDeleteAlbumRequest(aVar.k().longValue()), k());
    }

    private void i(Context context) {
        this.f84841d = context;
        addView(LayoutInflater.from(context).inflate(R.layout.gl_, (ViewGroup) this, false));
        this.f84842e = (RecyclerView) findViewById(R.id.album_list);
        j();
    }

    private void j() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f84841d);
        linearLayoutManager.setOrientation(0);
        this.f84842e.setLayoutManager(linearLayoutManager);
        if (this.f84843f == null) {
            this.f84843f = new a40.f(this.f84841d);
        }
        this.f84843f.J0(new a());
        this.f84842e.setAdapter(this.f84843f);
        c cVar = new c(D, F, E);
        this.f84845i = cVar;
        this.f84842e.addItemDecoration(cVar);
        this.f84842e.addOnScrollListener(new b());
    }

    private VSDispatchObserver.OnVSRspCallBack<QQCircleFeedAlbum$DeleteAlbumRsp> k() {
        return new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.immersive.album.view.r
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                QFSPersonalAlbumEntranceView.this.n(baseRequest, z16, j3, str, (QQCircleFeedAlbum$DeleteAlbumRsp) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        List<b40.a> a16 = this.f84844h.a();
        if (a16 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        Iterator<b40.a> it = a16.iterator();
        while (it.hasNext()) {
            FeedCloudMeta$FeedAlbumInfo f16 = it.next().f();
            if (f16 != null) {
                arrayList.add(f16);
            }
        }
        QCircleAlbumListBean qCircleAlbumListBean = new QCircleAlbumListBean();
        qCircleAlbumListBean.setUin(this.f84844h.d());
        qCircleAlbumListBean.setFeedAlbumInfo(arrayList);
        qCircleAlbumListBean.setAttachInfo(this.f84844h.c());
        qCircleAlbumListBean.setHasMore(this.f84844h.e());
        com.tencent.biz.qqcircle.launcher.c.a0(this.f84841d, qCircleAlbumListBean);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void n(BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleFeedAlbum$DeleteAlbumRsp qQCircleFeedAlbum$DeleteAlbumRsp) {
        if (z16 && j3 == 0) {
            String str2 = C;
            QLog.d(str2, 1, "deleteFeed  success | traceId:" + baseRequest.getTraceId());
            try {
                SimpleEventBus.getInstance().dispatchEvent(new QCircleAlbumEvent(1, ((QCircleDeleteAlbumRequest) baseRequest).getRequest().album_id.get()));
                QLog.e(str2, 1, "deleteAlbum  error | traceId:" + baseRequest.getTraceId());
                return;
            } catch (Exception e16) {
                QLog.e(C, 1, "send QCircleAlbumEvent failed:" + e16.getMessage());
                return;
            }
        }
        QLog.e(C, 1, "deleteAlbum  error | traceId:" + baseRequest.getTraceId());
        QCircleToast.o(getContext().getResources().getString(R.string.f181443ds), 0);
    }

    @Override // z30.b.a
    public boolean a(MotionEvent motionEvent) {
        return l(motionEvent);
    }

    public boolean l(MotionEvent motionEvent) {
        RecyclerView recyclerView = this.f84842e;
        if (recyclerView == null || recyclerView.getVisibility() != 0) {
            return false;
        }
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        int[] iArr = new int[2];
        getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i16 = iArr[1];
        int measuredWidth = getMeasuredWidth() + i3;
        int measuredHeight = getMeasuredHeight() + i16;
        if (rawY < i16 || rawY > measuredHeight || rawX < i3 || rawX > measuredWidth) {
            return false;
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        z30.b.f451838b.a(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        z30.b.f451838b.c(this);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        RecyclerView recyclerView;
        if (motionEvent.getAction() == 0) {
            this.f84846m = motionEvent.getX();
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 2) {
            if (motionEvent.getX() - this.f84846m < 0.0f && (recyclerView = this.f84842e) != null && !recyclerView.canScrollHorizontally(1)) {
                return true;
            }
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        b40.d dVar;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f84846m = motionEvent.getX();
            return true;
        }
        if (action == 2) {
            float x16 = motionEvent.getX() - this.f84846m;
            if (x16 < 0.0f && Math.abs(x16) > G && (dVar = this.f84844h) != null && dVar.a() != null && this.f84844h.a().size() > 5) {
                m();
            }
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setUserAlbum(b40.d dVar) {
        this.f84844h = dVar;
        a40.f fVar = this.f84843f;
        if (fVar != null) {
            fVar.updateData(dVar.a());
        }
    }

    public QFSPersonalAlbumEntranceView(@NonNull Context context) {
        super(context);
        i(context);
    }
}
