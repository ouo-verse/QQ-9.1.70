package com.tencent.aelight.camera.aioeditor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.aelight.camera.aioeditor.EditVideoSmartMusicPart;
import com.tencent.aelight.camera.aioeditor.SmartMusicAdapter;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import java.util.List;
import qqcircle.QQCircleSmartMatchMusic$MusicInfo;

/* compiled from: P */
/* loaded from: classes32.dex */
public class SmartMusicRecyclerView extends RecyclerView {
    private boolean C;

    /* renamed from: d, reason: collision with root package name */
    private nf0.a f66314d;

    /* renamed from: e, reason: collision with root package name */
    private SmartMusicAdapter f66315e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f66316f;

    /* renamed from: h, reason: collision with root package name */
    private SmartMusicAdapter.b f66317h;

    /* renamed from: i, reason: collision with root package name */
    private EditVideoSmartMusicPart.g f66318i;

    /* renamed from: m, reason: collision with root package name */
    private int f66319m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            SmartMusicRecyclerView.this.g(recyclerView, i3);
        }
    }

    public SmartMusicRecyclerView(Context context) {
        this(context, null, 0);
    }

    private void e() {
        SmartMusicAdapter.b bVar = this.f66317h;
        if (bVar != null) {
            bVar.g(false);
            this.f66317h.i(false);
            this.f66317h.e();
        }
    }

    private void f() {
        nf0.a aVar = new nf0.a(getContext(), BaseAIOUtils.f(120.0f, getContext().getResources()));
        this.f66314d = aVar;
        setLayoutManager(aVar);
        SmartMusicAdapter smartMusicAdapter = new SmartMusicAdapter();
        this.f66315e = smartMusicAdapter;
        setAdapter(smartMusicAdapter);
        addOnScrollListener(new a());
    }

    public nf0.a d() {
        return this.f66314d;
    }

    public void setHasAutoSet(boolean z16) {
        this.f66316f = z16;
    }

    public void setLastPosition(int i3) {
        this.f66319m = i3;
    }

    public void setListener(EditVideoSmartMusicPart.g gVar) {
        this.f66318i = gVar;
        SmartMusicAdapter smartMusicAdapter = this.f66315e;
        if (smartMusicAdapter != null) {
            smartMusicAdapter.G(gVar);
        }
    }

    public void setNeedScale(boolean z16) {
        this.C = z16;
        d().n(z16);
        if (this.f66317h != null) {
            float h16 = z16 ? d().h() : 1.0f;
            this.f66317h.itemView.setScaleY(h16);
            this.f66317h.itemView.setScaleX(h16);
        }
    }

    public SmartMusicRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SmartMusicRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = true;
        f();
    }

    public void setMusicData(List<QQCircleSmartMatchMusic$MusicInfo> list) {
        if (list != null) {
            this.f66315e.setData(list);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(RecyclerView recyclerView, int i3) {
        if (i3 == 0) {
            SmartMusicAdapter.b bVar = this.f66317h;
            if (bVar != null && this.f66316f && this.C) {
                bVar.f();
                this.f66317h.d();
            }
            if (!this.f66316f) {
                int e16 = this.f66314d.e() + 1;
                recyclerView.smoothScrollToPosition(e16);
                e();
                SmartMusicAdapter.b bVar2 = (SmartMusicAdapter.b) recyclerView.findViewHolderForAdapterPosition(e16);
                this.f66317h = bVar2;
                EditVideoSmartMusicPart.g gVar = this.f66318i;
                if (gVar != null && this.f66319m != e16) {
                    this.f66319m = e16;
                    gVar.b(e16, bVar2);
                }
                this.f66316f = true;
            }
        }
        if ((i3 == 1 || i3 == 2) && i3 == 1) {
            e();
            this.f66316f = false;
        }
    }

    @Override // android.support.v7.widget.RecyclerView
    public void smoothScrollToPosition(int i3) {
        int i16 = i3 - 1;
        if (i16 < 0) {
            i16 = 0;
        }
        smoothScrollBy(0, d().i(i16));
    }
}
