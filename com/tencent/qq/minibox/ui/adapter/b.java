package com.tencent.qq.minibox.ui.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.trpcprotocol.minibox.basicinfo.VMBasicInfo$VMAppInfo;
import java.util.ArrayList;
import java.util.List;
import us3.r;

/* compiled from: P */
/* loaded from: classes22.dex */
public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private a C;

    /* renamed from: m, reason: collision with root package name */
    private final List<VMBasicInfo$VMAppInfo> f344655m = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface a {
        void a(View view, VMBasicInfo$VMAppInfo vMBasicInfo$VMAppInfo, int i3);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qq.minibox.ui.adapter.b$b, reason: collision with other inner class name */
    /* loaded from: classes22.dex */
    public static class C9354b extends RecyclerView.ViewHolder {
        private SquareImageView E;
        private TextView F;
        private TextView G;
        private TextView H;
        private TextView I;

        public C9354b(View view) {
            super(view);
            this.E = (SquareImageView) view.findViewById(R.id.f165772xj4);
            this.F = (TextView) view.findViewById(R.id.f1060667p);
            this.G = (TextView) view.findViewById(R.id.f1060467n);
            this.H = (TextView) view.findViewById(R.id.k_5);
            this.I = (TextView) view.findViewById(R.id.md_);
        }
    }

    private boolean j0(String str) {
        if (!TextUtils.isEmpty(str) && (str.startsWith("https://") || str.startsWith("http://"))) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void k0(RecyclerView.ViewHolder viewHolder, VMBasicInfo$VMAppInfo vMBasicInfo$VMAppInfo, int i3, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        a aVar = this.C;
        if (aVar != null) {
            aVar.a(viewHolder.itemView, vMBasicInfo$VMAppInfo, i3);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void n0(Context context, ImageView imageView, String str) {
        URLDrawable fileDrawable;
        if (!TextUtils.isEmpty(str) && imageView != null && context != null) {
            try {
                URLDrawable.URLDrawableOptions b16 = r.b(context);
                if (j0(str)) {
                    fileDrawable = URLDrawable.getDrawable(str, b16);
                } else {
                    fileDrawable = URLDrawable.getFileDrawable(str, b16);
                }
                imageView.setImageDrawable(fileDrawable);
            } catch (Throwable th5) {
                QLog.d("VirtualAppDataAdapter", 1, "[setUrlDrawable] err:" + th5.getMessage());
            }
        }
    }

    public void destroy() {
        this.C = null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f344655m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        return 1;
    }

    public void l0(a aVar) {
        this.C = aVar;
    }

    @SuppressLint({"NotifyDataSetChanged"})
    public void m0(List<VMBasicInfo$VMAppInfo> list) {
        this.f344655m.clear();
        this.f344655m.addAll(list);
        notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final RecyclerView.ViewHolder viewHolder, final int i3) {
        final VMBasicInfo$VMAppInfo vMBasicInfo$VMAppInfo = this.f344655m.get(i3);
        C9354b c9354b = (C9354b) viewHolder;
        n0(viewHolder.itemView.getContext(), c9354b.E, vMBasicInfo$VMAppInfo.app_icon.get());
        c9354b.F.setText(vMBasicInfo$VMAppInfo.app_name.get());
        c9354b.G.setText(vMBasicInfo$VMAppInfo.app_desc.get());
        c9354b.I.setText(vMBasicInfo$VMAppInfo.app_tag.get());
        c9354b.H.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qq.minibox.ui.adapter.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b.this.k0(viewHolder, vMBasicInfo$VMAppInfo, i3, view);
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new C9354b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fhw, viewGroup, false));
    }
}
