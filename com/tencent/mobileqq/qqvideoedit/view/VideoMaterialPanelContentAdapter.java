package com.tencent.mobileqq.qqvideoedit.view;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.view.VideoDownLoadingView;
import com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask;
import com.tencent.mobileqq.qqvideoedit.utils.p;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes17.dex */
public abstract class VideoMaterialPanelContentAdapter extends RecyclerView.Adapter<b> {
    protected VideoEditorViewModel.EditMode E;
    private ApplyMaterialTask F;
    private QQToast.IToastValidListener G;
    private final int H;
    private final int I;
    private final int J;
    private final int K;

    /* renamed from: d, reason: collision with root package name */
    private final int f276267d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f276268e;

    /* renamed from: i, reason: collision with root package name */
    private int f276271i;

    /* renamed from: h, reason: collision with root package name */
    private int f276270h = -1;

    /* renamed from: m, reason: collision with root package name */
    private boolean f276272m = false;
    private boolean C = false;
    private boolean D = false;

    /* renamed from: f, reason: collision with root package name */
    private List<MetaMaterial> f276269f = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f276278a;

        static {
            int[] iArr = new int[ApplyMaterialTask.Status.values().length];
            f276278a = iArr;
            try {
                iArr[ApplyMaterialTask.Status.SUCCEEDED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f276278a[ApplyMaterialTask.Status.FAILED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f276278a[ApplyMaterialTask.Status.ONGOING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: classes17.dex */
    public static class b extends RecyclerView.ViewHolder {
        public TextView C;

        /* renamed from: d, reason: collision with root package name */
        public CardView f276279d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f276280e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f276281f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f276282h;

        /* renamed from: i, reason: collision with root package name */
        public ImageView f276283i;

        /* renamed from: m, reason: collision with root package name */
        public VideoDownLoadingView f276284m;

        public b(View view) {
            super(view);
            this.f276279d = (CardView) view.findViewById(R.id.f164726tm1);
            this.f276280e = (ImageView) view.findViewById(R.id.y9u);
            this.f276281f = (ImageView) view.findViewById(R.id.y8z);
            this.f276282h = (ImageView) view.findViewById(R.id.y5f);
            this.f276283i = (ImageView) view.findViewById(R.id.y2f);
            this.f276284m = (VideoDownLoadingView) view.findViewById(R.id.g2d);
            this.C = (TextView) view.findViewById(R.id.tv_name);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void e(int i3, int i16, int i17) {
            this.f276284m.setBgCorner(i17 / 2);
            this.f276284m.setMinimumHeight(i17);
            this.f276284m.setMinimumWidth(i17);
            this.f276284m.setProgressSizeAndMode(i3, i16, false);
            this.f276284m.setBgColor(0);
            this.f276284m.setProgressColor(-1);
            this.f276284m.b(false);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void f(boolean z16) {
            if (z16 && this.f276283i.getVisibility() != 0) {
                this.f276283i.setVisibility(0);
            } else if (!z16 && this.f276283i.getVisibility() != 4) {
                this.f276283i.setVisibility(4);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void g(boolean z16, int i3) {
            if (z16) {
                if (this.f276282h.getVisibility() != 0) {
                    this.f276282h.setVisibility(0);
                    this.f276284m.setVisibility(0);
                }
                f(false);
            } else if (this.f276282h.getVisibility() != 4) {
                this.f276282h.setVisibility(4);
                this.f276284m.setVisibility(4);
            }
            this.f276284m.setProgress(i3);
        }
    }

    public VideoMaterialPanelContentAdapter(@NonNull Context context, VideoEditorViewModel.EditMode editMode, int i3) {
        this.E = editMode;
        this.f276267d = i3;
        this.H = x.c(context, 20.0f);
        this.I = x.c(context, 6.0f);
        this.J = x.c(context, 2.0f);
        this.K = x.c(context, 16.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A(final MetaMaterial metaMaterial, final int i3, ApplyMaterialTask.Status status, int i16) {
        com.tencent.mobileqq.qqvideoedit.flow.b.c("onPreExecute", metaMaterial, String.format("callback: %s-%s", status, Integer.valueOf(i16)));
        ApplyMaterialTask.Status status2 = ApplyMaterialTask.Status.SUCCEEDED;
        if (status == status2) {
            boolean d06 = this.F.d0(i3, metaMaterial);
            com.tencent.mobileqq.qqvideoedit.flow.b.c("isApplyMaterialLocal", metaMaterial, String.valueOf(d06));
            if (d06) {
                boolean z16 = this.F.z(i3, metaMaterial);
                com.tencent.mobileqq.qqvideoedit.flow.b.c("isMaterialReady", metaMaterial, String.valueOf(z16));
                if (!z16 && com.tencent.mobileqq.qqvideoedit.editor.b.d(metaMaterial) != 100) {
                    if (com.tencent.mobileqq.qqvideoedit.editor.b.d(metaMaterial) < 0) {
                        this.F.Y(i3, metaMaterial);
                        com.tencent.mobileqq.qqvideoedit.flow.b.c("onDownloadMaterial", metaMaterial, "start");
                        com.tencent.mobileqq.qqvideoedit.flow.b.d(metaMaterial, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.qqvideoedit.view.d
                            @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask.a
                            public final void a(ApplyMaterialTask.Status status3, int i17) {
                                VideoMaterialPanelContentAdapter.this.z(metaMaterial, i3, status3, i17);
                            }
                        });
                        return;
                    }
                    com.tencent.mobileqq.qqvideoedit.flow.b.c("executeApplyMaterialTask", metaMaterial, String.format("run into wrong branch: isMaterialReady=%s, downloadProgress=%s", Boolean.valueOf(this.F.z(i3, metaMaterial)), Integer.valueOf(com.tencent.mobileqq.qqvideoedit.editor.b.d(metaMaterial))));
                    return;
                }
                I(status2, i3, metaMaterial);
                return;
            }
            com.tencent.mobileqq.qqvideoedit.flow.b.c("onApplyMaterialOnline", metaMaterial, "start");
            this.F.Q(i3, metaMaterial);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(int i3, MetaMaterial metaMaterial, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!this.C) {
            y(i3, metaMaterial);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C(final MetaMaterial metaMaterial, final ApplyMaterialTask.Status status, final int i3, final ApplyMaterialTask.Status status2, int i16) {
        com.tencent.mobileqq.qqvideoedit.flow.b.c("onPostDownloadMaterial", metaMaterial, String.format("callback: %s-%s", status2, Integer.valueOf(i16)));
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.view.VideoMaterialPanelContentAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                if (status == ApplyMaterialTask.Status.FAILED) {
                    VideoMaterialPanelContentAdapter.this.L(i3, metaMaterial);
                    return;
                }
                int i17 = a.f276278a[status2.ordinal()];
                if (i17 != 1) {
                    if (i17 == 2) {
                        VideoMaterialPanelContentAdapter.this.L(i3, metaMaterial);
                    }
                } else if (VideoMaterialPanelContentAdapter.this.f276271i == i3) {
                    com.tencent.mobileqq.qqvideoedit.flow.b.c("onApplyMaterialLocal", metaMaterial, "start");
                    VideoMaterialPanelContentAdapter.this.O(i3, true);
                    VideoMaterialPanelContentAdapter.this.F.g(i3, metaMaterial);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D(int i3) {
        if (this.G != null) {
            QQToast.makeText(RFWApplication.getApplication(), R.string.ynb, 1).showByQueue(this.G);
        } else {
            QQToast.makeText(RFWApplication.getApplication(), R.string.ynb, 1).show();
        }
        notifyItemChanged(i3, 1);
    }

    private void I(final ApplyMaterialTask.Status status, final int i3, final MetaMaterial metaMaterial) {
        com.tencent.mobileqq.qqvideoedit.flow.b.c("onPostDownloadMaterial", metaMaterial, "start");
        this.F.f0(status, i3, metaMaterial, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.qqvideoedit.view.e
            @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask.a
            public final void a(ApplyMaterialTask.Status status2, int i16) {
                VideoMaterialPanelContentAdapter.this.C(metaMaterial, status, i3, status2, i16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(final int i3, MetaMaterial metaMaterial) {
        com.tencent.mobileqq.qqvideoedit.editor.b.x(metaMaterial, -1);
        ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.view.a
            @Override // java.lang.Runnable
            public final void run() {
                VideoMaterialPanelContentAdapter.this.D(i3);
            }
        });
    }

    private void x(final int i3, @NonNull final MetaMaterial metaMaterial) {
        if (this.F == null) {
            return;
        }
        com.tencent.mobileqq.qqvideoedit.flow.b.c("onPreExecute", metaMaterial, "start");
        if (metaMaterial != null) {
            oj2.c.b().d(metaMaterial.f30533id);
        }
        this.F.e0(i3, metaMaterial, new ApplyMaterialTask.a() { // from class: com.tencent.mobileqq.qqvideoedit.view.c
            @Override // com.tencent.mobileqq.qqvideoedit.flow.ApplyMaterialTask.a
            public final void a(ApplyMaterialTask.Status status, int i16) {
                VideoMaterialPanelContentAdapter.this.A(metaMaterial, i3, status, i16);
            }
        });
    }

    private void y(int i3, MetaMaterial metaMaterial) {
        if (metaMaterial == null) {
            return;
        }
        if (!this.D && i3 == this.f276270h && !this.f276272m) {
            return;
        }
        this.f276272m = false;
        this.f276271i = i3;
        x(i3, metaMaterial);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(MetaMaterial metaMaterial, final int i3, ApplyMaterialTask.Status status, int i16) {
        com.tencent.mobileqq.qqvideoedit.flow.b.c("onDownloadMaterial", metaMaterial, String.format("callback: %s-%s", status, Integer.valueOf(i16)));
        int i17 = a.f276278a[status.ordinal()];
        if (i17 != 1) {
            if (i17 != 2) {
                if (i17 == 3) {
                    com.tencent.mobileqq.qqvideoedit.editor.b.x(metaMaterial, i16);
                    ThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qqvideoedit.view.VideoMaterialPanelContentAdapter.1
                        @Override // java.lang.Runnable
                        public void run() {
                            VideoMaterialPanelContentAdapter.this.notifyItemChanged(i3, 1);
                        }
                    });
                    return;
                }
                return;
            }
            L(i3, metaMaterial);
            I(ApplyMaterialTask.Status.FAILED, i3, metaMaterial);
            J(metaMaterial, QQWinkConstants.CostCode.RESULT_FAIL);
            return;
        }
        com.tencent.mobileqq.qqvideoedit.editor.b.x(metaMaterial, 100);
        I(ApplyMaterialTask.Status.SUCCEEDED, i3, metaMaterial);
        J(metaMaterial, "0");
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final void onBindViewHolder(b bVar, final int i3) {
        boolean z16;
        String str;
        int i16;
        final MetaMaterial metaMaterial = this.f276269f.get(i3);
        boolean z17 = false;
        if (metaMaterial != null) {
            if ("ID_PLACEHOLDER".equals(metaMaterial.f30533id)) {
                if (bVar.itemView.getVisibility() != 4) {
                    bVar.itemView.setVisibility(4);
                }
                EventCollector.getInstance().onRecyclerBindViewHolder(bVar, i3, getItemId(i3));
            } else if (bVar.itemView.getVisibility() != 0) {
                bVar.itemView.setVisibility(0);
            }
        }
        if (metaMaterial != null) {
            if (this.f276270h == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (TextUtils.isEmpty(metaMaterial.thumbUrl)) {
                bVar.f276280e.setVisibility(0);
                bVar.f276280e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            } else if (metaMaterial.thumbUrl.startsWith("http")) {
                bVar.f276280e.setVisibility(0);
                bVar.f276280e.setScaleType(ImageView.ScaleType.CENTER_CROP);
                if (this.E == VideoEditorViewModel.EditMode.Video) {
                    str = com.tencent.mobileqq.qqvideoedit.editor.b.j(metaMaterial);
                } else {
                    str = "none";
                }
                p.a(bVar.f276280e, metaMaterial.thumbUrl, com.tencent.mobileqq.qqvideoedit.editor.b.e(metaMaterial), str, null);
            } else {
                bVar.f276280e.setVisibility(0);
                bVar.f276280e.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                bVar.f276280e.setImageResource(com.tencent.mobileqq.qqvideoedit.editor.b.o(metaMaterial));
            }
            if (com.tencent.mobileqq.qqvideoedit.editor.b.n(metaMaterial) != -1) {
                bVar.f276279d.setCardBackgroundColor(com.tencent.mobileqq.qqvideoedit.editor.b.n(metaMaterial));
            }
            TextView textView = bVar.C;
            if (textView != null) {
                textView.setText(com.tencent.mobileqq.qqvideoedit.editor.b.k(metaMaterial));
                TextView textView2 = bVar.C;
                Resources resources = bVar.itemView.getContext().getResources();
                if (z16) {
                    i16 = R.color.bfp;
                } else {
                    i16 = R.color.bfq;
                }
                textView2.setTextColor(resources.getColor(i16));
            }
            if (z16) {
                bVar.f276281f.setVisibility(0);
                bVar.g(false, -1);
                bVar.f(false);
            } else {
                bVar.f276281f.setVisibility(4);
                if (com.tencent.mobileqq.qqvideoedit.editor.b.q(metaMaterial)) {
                    int d16 = com.tencent.mobileqq.qqvideoedit.editor.b.d(metaMaterial);
                    if (d16 == -1 || d16 == 100) {
                        bVar.g(false, d16);
                        ApplyMaterialTask applyMaterialTask = this.F;
                        if (applyMaterialTask != null) {
                            boolean z18 = applyMaterialTask.z(i3, metaMaterial);
                            if (d16 == -1 && !z18 && com.tencent.mobileqq.qqvideoedit.editor.b.c(metaMaterial)) {
                                z17 = true;
                            }
                            bVar.f(z17);
                        }
                    } else {
                        bVar.g(true, d16);
                    }
                }
            }
            bVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.qqvideoedit.view.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    VideoMaterialPanelContentAdapter.this.B(i3, metaMaterial, view);
                }
            });
            F(bVar, i3, metaMaterial);
        }
        EventCollector.getInstance().onRecyclerBindViewHolder(bVar, i3, getItemId(i3));
    }

    protected abstract b G(ViewGroup viewGroup, int i3);

    @Override // android.support.v7.widget.RecyclerView.Adapter
    /* renamed from: H, reason: merged with bridge method [inline-methods] */
    public final b onCreateViewHolder(ViewGroup viewGroup, int i3) {
        b G = G(viewGroup, i3);
        if (this.f276267d == 1) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) G.itemView.getLayoutParams();
            if (i3 == 0) {
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = this.H;
            } else if (i3 == 2) {
                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.H;
            }
        }
        G.e(this.I, this.J, this.K);
        return G;
    }

    public void K(ApplyMaterialTask applyMaterialTask) {
        this.F = applyMaterialTask;
    }

    public final void M(List<MetaMaterial> list) {
        this.f276269f = list;
    }

    public void N(int i3) {
        O(i3, false);
    }

    public void O(int i3, boolean z16) {
        RecyclerView recyclerView;
        if (QLog.isColorLevel()) {
            QLog.i("MaterialPanelContentAdapter", 2, getClass().getSimpleName() + " setSelectedIndex:" + i3);
        }
        if (i3 >= 0 && (recyclerView = this.f276268e) != null && (recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            if (((LinearLayoutManager) this.f276268e.getLayoutManager()).getOrientation() == 0) {
                com.tencent.mobileqq.qqvideoedit.utils.c.g(this.f276268e, this.f276270h, i3, z16, false);
            } else {
                com.tencent.mobileqq.qqvideoedit.utils.c.h(this.f276268e, this.f276270h, i3, z16, false);
            }
        }
        this.f276270h = i3;
        notifyDataSetChanged();
    }

    public void P(VideoEditorViewModel.EditMode editMode) {
        if (this.E == editMode) {
            return;
        }
        this.E = editMode;
        this.f276270h = -1;
        notifyDataSetChanged();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public final int getItemCount() {
        List<MetaMaterial> list = this.f276269f;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.support.v7.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        this.f276268e = recyclerView;
    }

    private void J(@NonNull MetaMaterial metaMaterial, String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void F(b bVar, int i3, @NonNull MetaMaterial metaMaterial) {
    }
}
