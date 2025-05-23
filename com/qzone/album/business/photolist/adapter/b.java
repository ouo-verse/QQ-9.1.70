package com.qzone.album.business.photolist.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.qzone.album.business.search.SearchFilter;
import com.qzone.album.business.search.SearchFilterComposition;
import com.qzone.util.ar;
import com.qzone.widget.FlexiableProcessImageView;
import com.tencent.component.media.image.ImageProcessor;
import com.tencent.component.media.image.processor.RoundCornerProcessor;
import com.tencent.component.media.image.processor.SpecifiedSizeCropByPivotProcessor;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b extends RecyclerView.Adapter<a> {
    private LayoutInflater C;
    private SearchFilterComposition D;

    /* renamed from: m, reason: collision with root package name */
    private Context f42678m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static abstract class a extends RecyclerView.ViewHolder {
        protected View E;

        public a(View view) {
            super(view);
            this.E = view;
        }

        public abstract void l(SearchFilter searchFilter);
    }

    /* compiled from: P */
    /* renamed from: com.qzone.album.business.photolist.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes39.dex */
    public static class C0331b extends a {
        public static final float G = ar.d(30.0f);
        public static final ImageProcessor H = new a();
        public FlexiableProcessImageView F;

        /* compiled from: P */
        /* renamed from: com.qzone.album.business.photolist.adapter.b$b$a */
        /* loaded from: classes39.dex */
        class a extends ImageProcessor {
            a() {
            }

            @Override // com.tencent.component.media.image.ImageProcessor
            public Drawable process(Drawable drawable) {
                float f16 = C0331b.G;
                return new RoundCornerProcessor(6.0f).process(new SpecifiedSizeCropByPivotProcessor((int) f16, (int) f16).process(drawable));
            }
        }

        public C0331b(View view) {
            super(view);
            View view2 = this.E;
            if (view2 != null) {
                FlexiableProcessImageView flexiableProcessImageView = (FlexiableProcessImageView) view2.findViewById(R.id.f166690hd3);
                this.F = flexiableProcessImageView;
                flexiableProcessImageView.setAsyncImageProcessor(H);
            }
        }

        @Override // com.qzone.album.business.photolist.adapter.b.a
        public void l(SearchFilter searchFilter) {
            if (this.F == null || searchFilter == null || TextUtils.isEmpty(searchFilter.filterPortaitUrl)) {
                return;
            }
            FlexiableProcessImageView flexiableProcessImageView = this.F;
            float f16 = G;
            com.qzone.album.util.c.c(flexiableProcessImageView, (int) f16, (int) f16);
            this.F.setAsyncImage(searchFilter.filterPortaitUrl);
        }
    }

    public b(Context context, SearchFilterComposition searchFilterComposition) {
        this.f42678m = context;
        this.D = searchFilterComposition;
        if (context != null) {
            this.C = LayoutInflater.from(context);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        SearchFilterComposition searchFilterComposition = this.D;
        if (searchFilterComposition == null || !searchFilterComposition.isDataValid()) {
            return 0;
        }
        return this.D.flatternedFilters.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        SearchFilterComposition searchFilterComposition = this.D;
        if (searchFilterComposition == null || searchFilterComposition.getFilterAt(i3) == null) {
            return 0;
        }
        return this.D.getFilterAt(i3).getViewType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        LayoutInflater layoutInflater;
        if (this.f42678m == null || (layoutInflater = this.C) == null) {
            return null;
        }
        if (i3 == 0) {
            return new c(layoutInflater.inflate(R.layout.biu, viewGroup, false));
        }
        if (i3 != 1) {
            return null;
        }
        return new C0331b(layoutInflater.inflate(R.layout.bit, viewGroup, false));
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    public static class c extends a {
        public TextView F;

        public c(View view) {
            super(view);
            View view2 = this.E;
            if (view2 != null) {
                this.F = (TextView) view2.findViewById(R.id.f166691hd4);
            }
        }

        @Override // com.qzone.album.business.photolist.adapter.b.a
        public void l(SearchFilter searchFilter) {
            TextView textView;
            if (searchFilter == null || TextUtils.isEmpty(searchFilter.filterContent) || (textView = this.F) == null) {
                return;
            }
            textView.setText(searchFilter.filterContent);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        SearchFilterComposition searchFilterComposition;
        if (aVar == null || (searchFilterComposition = this.D) == null) {
            return;
        }
        aVar.l(searchFilterComposition.getFilterAt(i3));
    }
}
