package com.tencent.biz.qqcircle.immersive.album.view;

import a40.j;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* loaded from: classes4.dex */
public class AlbumProductionListView extends LinearLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final String f84804h = "com.tencent.biz.qqcircle.immersive.album.view.AlbumProductionListView";

    /* renamed from: d, reason: collision with root package name */
    private Context f84805d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f84806e;

    /* renamed from: f, reason: collision with root package name */
    private a40.j f84807f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public class a extends RecyclerView.ItemDecoration {

        /* renamed from: d, reason: collision with root package name */
        final int f84808d;

        /* renamed from: e, reason: collision with root package name */
        final int f84809e;

        /* renamed from: f, reason: collision with root package name */
        final int f84810f;

        /* renamed from: h, reason: collision with root package name */
        final int f84811h;

        public a(int i3, int i16, int i17, int i18) {
            this.f84808d = i3;
            this.f84809e = i16;
            this.f84810f = i17;
            this.f84811h = i18;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            if (recyclerView.getAdapter() == null) {
                QLog.e(AlbumProductionListView.f84804h, 2, "set item decoration failed, production list's adapter is null!");
                return;
            }
            rect.left = this.f84808d;
            rect.top = this.f84809e;
            rect.right = this.f84810f;
            if (recyclerView.getChildAdapterPosition(view) == recyclerView.getAdapter().getNUM_BACKGOURND_ICON() - 1) {
                rect.bottom = this.f84811h;
            }
        }
    }

    public AlbumProductionListView(Context context) {
        super(context);
        d(context);
    }

    private void d(Context context) {
        this.f84805d = context;
        setOrientation(1);
        this.f84806e = new RecyclerView(this.f84805d);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.f84805d);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-1, -1);
        linearLayoutManager.setOrientation(1);
        this.f84806e.setLayoutManager(linearLayoutManager);
        this.f84806e.setLayoutParams(layoutParams);
        a40.j jVar = new a40.j(context);
        this.f84807f = jVar;
        this.f84806e.setAdapter(jVar);
        this.f84806e.setNestedScrollingEnabled(false);
        this.f84806e.addItemDecoration(new a(ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(0.0f), ViewUtils.dpToPx(4.0f), ViewUtils.dpToPx(0.0f)));
        addView(this.f84806e);
    }

    public void a(List<e30.b> list) {
        a40.j jVar = this.f84807f;
        if (jVar != null) {
            jVar.l0(list);
        }
    }

    public List<e30.b> b() {
        a40.j jVar = this.f84807f;
        if (jVar != null) {
            return jVar.getData();
        }
        return null;
    }

    public RecyclerView c() {
        return this.f84806e;
    }

    public void setData(List<e30.b> list) {
        a40.j jVar = this.f84807f;
        if (jVar != null) {
            jVar.setData(list);
        }
    }

    public void setFeedItemOnClickListener(j.a aVar) {
        this.f84807f.x0(aVar);
    }

    public void setReportSourceAndAlbumId(String str, String str2) {
        this.f84807f.y0(str, str2);
    }

    public AlbumProductionListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        d(context);
    }
}
