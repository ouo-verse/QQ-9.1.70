package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.aelight.camera.ae.camera.core.AEFilterManagerHolder;
import com.tencent.aelight.camera.ae.camera.filter.AEFilterProcessTex;
import com.tencent.aelight.camera.aioeditor.capture.data.QIMFilterCategoryItem;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ab extends RecyclerView.Adapter<c> {

    /* renamed from: d, reason: collision with root package name */
    private Context f63056d;

    /* renamed from: e, reason: collision with root package name */
    List<QIMFilterCategoryItem> f63057e = new ArrayList();

    /* renamed from: f, reason: collision with root package name */
    int f63058f;

    /* renamed from: h, reason: collision with root package name */
    private b f63059h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ c f63060d;

        a(c cVar) {
            this.f63060d = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ab.this.f63059h.onItemClick(this.f63060d.itemView, this.f63060d.getLayoutPosition());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface b {
        void onItemClick(View view, int i3);
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class c extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        private ImageView f63062d;

        /* renamed from: e, reason: collision with root package name */
        private ImageView f63063e;

        /* renamed from: f, reason: collision with root package name */
        private TextView f63064f;

        public c(View view) {
            super(view);
            this.f63062d = (ImageView) view.findViewById(R.id.rup);
            this.f63063e = (ImageView) view.findViewById(R.id.rux);
            this.f63064f = (TextView) view.findViewById(R.id.rte);
        }
    }

    public ab(Context context, int i3) {
        this.f63056d = context;
        this.f63058f = i3;
    }

    private boolean t() {
        AEFilterProcessTex aEFilterManager = AEFilterManagerHolder.getAEFilterManager();
        if (aEFilterManager == null) {
            return true;
        }
        return aEFilterManager.U;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f63057e.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(c cVar, int i3) {
        String str;
        QIMFilterCategoryItem qIMFilterCategoryItem = this.f63057e.get(i3);
        if (qIMFilterCategoryItem != null) {
            QIMFilterCategoryItem qIMFilterCategoryItem2 = this.f63057e.get(i3);
            QIMFilterCategoryItem i16 = com.tencent.aelight.camera.aioeditor.activity.richmedia.m.n().i(this.f63058f);
            boolean equals = i16 != null ? TextUtils.equals(i16.f66697d, qIMFilterCategoryItem2.f66697d) : false;
            if (!equals) {
                equals = (i16 == null || i16.k()) && qIMFilterCategoryItem2.k();
            }
            if (equals && t()) {
                cVar.f63063e.setVisibility(0);
            } else {
                cVar.f63063e.setVisibility(8);
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = this.f63056d.getResources().getDrawable(R.drawable.ee_);
            obtain.mFailedDrawable = this.f63056d.getResources().getDrawable(R.drawable.ee_);
            if (i3 == 0) {
                str = "https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none2.png";
            } else {
                str = qIMFilterCategoryItem.f66700h;
            }
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            if (drawable.getStatus() == 2) {
                drawable.restartDownload();
            }
            cVar.f63062d.setImageDrawable(drawable);
            cVar.f63064f.setText(qIMFilterCategoryItem2.f66698e);
            if (this.f63059h != null) {
                cVar.itemView.setOnClickListener(new a(cVar));
            }
            cVar.itemView.setTag(qIMFilterCategoryItem2);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public c onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new c(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167488dl2, viewGroup, false));
    }

    public void s(b bVar) {
        this.f63059h = bVar;
    }

    public void setData(List<QIMFilterCategoryItem> list) {
        this.f63057e.clear();
        this.f63057e.addAll(list);
    }
}
