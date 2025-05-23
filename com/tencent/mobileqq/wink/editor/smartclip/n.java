package com.tencent.mobileqq.wink.editor.smartclip;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.editor.smartclip.n;
import com.tencent.mobileqq.wink.editor.view.WinkSegClipView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.videocut.utils.r;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes21.dex */
public class n extends RecyclerView.Adapter<d> {

    /* renamed from: d, reason: collision with root package name */
    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d f321517d;

    /* renamed from: e, reason: collision with root package name */
    private final List<WinkSegClipView.SegClipModel> f321518e;

    /* renamed from: f, reason: collision with root package name */
    private final HashMap<Object, Bitmap> f321519f = new HashMap<>();

    /* renamed from: h, reason: collision with root package name */
    private c f321520h;

    /* renamed from: i, reason: collision with root package name */
    private final com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f f321521i;

    /* renamed from: m, reason: collision with root package name */
    private int f321522m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class a implements com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c() {
            n.this.notifyDataSetChanged();
        }

        @Override // com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.f
        public void a(@Nullable Object obj, long j3, @Nullable Bitmap bitmap) {
            boolean z16;
            if (j3 != 0) {
                return;
            }
            n.this.f321519f.put(obj, Bitmap.createBitmap(bitmap));
            Iterator it = n.this.f321518e.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (com.tencent.videocut.render.extension.e.n(((WinkSegClipView.SegClipModel) it.next()).getMediaClip()).equals(obj)) {
                        z16 = true;
                        break;
                    }
                } else {
                    z16 = false;
                    break;
                }
            }
            if (z16) {
                ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.smartclip.m
                    @Override // java.lang.Runnable
                    public final void run() {
                        n.a.this.c();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f321524d;

        b(int i3) {
            this.f321524d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (this.f321524d != n.this.f321522m) {
                if (n.this.f321520h != null) {
                    n.this.f321520h.onClick(this.f321524d);
                }
                n.this.f321522m = this.f321524d;
                n.this.notifyDataSetChanged();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public interface c {
        void onClick(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class d extends RecyclerView.ViewHolder {

        /* renamed from: d, reason: collision with root package name */
        ImageView f321526d;

        /* renamed from: e, reason: collision with root package name */
        TextView f321527e;

        /* renamed from: f, reason: collision with root package name */
        View f321528f;

        public d(View view) {
            super(view);
            this.f321526d = (ImageView) view.findViewById(R.id.y8t);
            this.f321527e = (TextView) view.findViewById(R.id.f111046k6);
            this.f321528f = view.findViewById(R.id.y8u);
        }
    }

    public n(com.tencent.mobileqq.wink.editor.clipping.timeline.widget.videotrack.d dVar, List<WinkSegClipView.SegClipModel> list) {
        String str;
        a aVar = new a();
        this.f321521i = aVar;
        this.f321522m = 0;
        this.f321517d = dVar;
        this.f321518e = list;
        dVar.b(aVar);
        for (WinkSegClipView.SegClipModel segClipModel : list) {
            if (segClipModel.getMediaClip().resource != null) {
                str = segClipModel.getMediaClip().resource.path;
            } else {
                str = "";
            }
            String n3 = com.tencent.videocut.render.extension.e.n(segClipModel.getMediaClip());
            this.f321519f.put(n3, Bitmap.createBitmap(this.f321517d.getBitmapByTime(0L, n3, str)));
        }
    }

    private Bitmap u(WinkSegClipView.SegClipModel segClipModel) {
        Bitmap bitmap = this.f321519f.get(com.tencent.videocut.render.extension.e.n(segClipModel.getMediaClip()));
        if (bitmap != null && !bitmap.isRecycled()) {
            return bitmap;
        }
        return this.f321517d.a();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f321518e.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(d dVar, int i3) {
        WinkSegClipView.SegClipModel segClipModel = this.f321518e.get(i3);
        dVar.f321526d.setImageBitmap(u(segClipModel));
        float e16 = r.f384266a.e(((float) segClipModel.getSelectDuration()) / segClipModel.getSpeedRate());
        dVar.f321527e.setText(String.format("%.1f", Float.valueOf(e16)).replace(".0", "") + ReportConstant.COSTREPORT_PREFIX);
        if (this.f321522m == i3) {
            dVar.f321528f.setVisibility(0);
        } else {
            dVar.f321528f.setVisibility(4);
        }
        dVar.f321526d.setOnClickListener(new b(i3));
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) dVar.itemView.getLayoutParams();
        if (i3 == 0) {
            marginLayoutParams.leftMargin = marginLayoutParams.rightMargin;
        } else {
            marginLayoutParams.leftMargin = 0;
        }
        dVar.itemView.setLayoutParams(marginLayoutParams);
        EventCollector.getInstance().onRecyclerBindViewHolder(dVar, i3, getItemId(i3));
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public d onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new d(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hcy, viewGroup, false));
    }

    public void x() {
        this.f321517d.c(this.f321521i);
    }

    public void y(c cVar) {
        this.f321520h = cVar;
    }

    public void z(int i3) {
        this.f321522m = i3;
    }
}
