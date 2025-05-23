package com.tencent.mobileqq.wink.editor.filter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.filter.e;
import com.tencent.mobileqq.wink.view.ab;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import java.io.File;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class e extends com.tencent.mobileqq.wink.view.ab {
    private static final String Y = u53.b.f438371b;
    private static final String Z;

    /* renamed from: a0, reason: collision with root package name */
    private static final String f320388a0;
    private int T;
    private int U;
    private MetaMaterial V;
    private boolean W;
    public int X;

    static {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("wink/pag");
        String str = File.separator;
        sb5.append(str);
        sb5.append("qvideo_editor_filter_intelligence_normaltorefresh.pag");
        Z = sb5.toString();
        f320388a0 = "wink/pag" + str + "qvideo_editor_filter_intelligence_refreshtorefresh.pag";
    }

    public e(@NonNull final Context context, WinkEditorViewModel.EditMode editMode) {
        super(context, editMode);
        this.T = 0;
        this.U = -1;
        this.V = null;
        this.W = false;
        this.X = 102;
        if (com.tencent.videocut.utils.g.f384239a.h("wink/pag")) {
            ThreadManager.getFileThreadHandler().post(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.filter.b
                @Override // java.lang.Runnable
                public final void run() {
                    e.t0(context);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void t0(Context context) {
        com.tencent.videocut.utils.g.f384239a.a(context, "wink/pag", Y);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public void F(int i3, MetaMaterial metaMaterial) {
        MetaMaterial metaMaterial2;
        if (this.X == 101 && metaMaterial != null && f.r(metaMaterial)) {
            QQToast.makeText(BaseApplication.getContext(), R.string.f239427mf, 0).show();
            return;
        }
        super.F(i3, metaMaterial);
        if (this.T == 5) {
            this.T = 0;
            return;
        }
        if (f.r(metaMaterial) && this.W) {
            this.T = 3;
            this.V = metaMaterial;
            f.F(metaMaterial, true);
            int i16 = this.U;
            if (i16 >= 0) {
                notifyItemChanged(i16);
            }
        }
        if (f.r(metaMaterial) && !this.W) {
            this.T = 2;
            this.V = metaMaterial;
            f.F(metaMaterial, true);
            int i17 = this.U;
            if (i17 >= 0) {
                notifyItemChanged(i17);
            }
        }
        if (!f.r(metaMaterial) && (metaMaterial2 = this.V) != null) {
            f.F(metaMaterial2, false);
        }
    }

    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public void a0(int i3) {
        MetaMaterial metaMaterial;
        super.a0(i3);
        if (i3 == -1 && (metaMaterial = this.V) != null) {
            f.F(metaMaterial, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.ab
    public void n0(ab.a aVar, int i3, @NonNull @NotNull MetaMaterial metaMaterial) {
        super.n0(aVar, i3, metaMaterial);
        if (!(aVar instanceof a)) {
            return;
        }
        a aVar2 = (a) aVar;
        if (f.r(metaMaterial)) {
            this.V = metaMaterial;
            this.U = aVar2.getAdapterPosition();
            if (!aVar2.H.getIsBuild()) {
                ms.a.a("FilterMaterialPanelContentAdapter", "build pagView ");
                aVar2.H.api().build();
            }
            int i16 = this.T;
            if (i16 != 1) {
                if (i16 != 2) {
                    if (i16 == 3) {
                        aVar2.q(f320388a0);
                        this.W = true;
                        this.T = 0;
                    }
                } else {
                    aVar2.q(Z);
                    this.W = true;
                    this.T = 0;
                }
            } else {
                aVar2.r();
                this.T = 0;
            }
            if (!this.W) {
                aVar2.C.setText("\u667a\u80fd");
                if (this.X == 101) {
                    aVar2.f326923e.setImageResource(R.drawable.nq9);
                } else {
                    aVar2.f326923e.setImageResource(R.drawable.nq8);
                }
            } else {
                aVar2.C.setText("\u6362\u4e00\u6362");
                if (this.X == 101) {
                    aVar2.f326923e.setImageResource(R.drawable.nqa);
                } else {
                    aVar2.f326923e.setImageResource(R.drawable.nq_);
                }
            }
        }
        VideoReport.setElementId(aVar.itemView, WinkDaTongReportConstant.ElementId.EM_XSJ_FILTER_ITEM);
        VideoReport.setElementReuseIdentifier(aVar.itemView, String.valueOf(metaMaterial.hashCode()));
        Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_NAME, metaMaterial.f30533id);
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_SLIDING_VALUE, Integer.valueOf(f.i(metaMaterial)));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID, WinkDatongCurrentParams.params.get(WinkDaTongReportConstant.ElementParamKey.XSJ_CAMERA_CLCK_REF_PGID));
        buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_FILTER_CATEGORY, com.tencent.mobileqq.wink.editor.c.o(metaMaterial));
        VideoReport.setElementParams(aVar.itemView, buildElementParams);
        VideoReport.setElementEndExposePolicy(aVar.itemView, EndExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(aVar.itemView, ClickPolicy.REPORT_ALL);
    }

    @Override // com.tencent.mobileqq.wink.view.ab
    protected ab.a o0(ViewGroup viewGroup, int i3) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.hf7, viewGroup, false));
    }

    public void s0() {
        this.T = 4;
        this.W = false;
        notifyDataSetChanged();
    }

    public void u0() {
        int i3 = this.U;
        if (i3 >= 0) {
            notifyItemChanged(i3);
        }
    }

    public void v0(boolean z16) {
        this.W = z16;
    }

    public void w0() {
        this.T = 5;
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.view.AbsWinkMaterialPanelContentAdapter
    public boolean y(int i3, MetaMaterial metaMaterial) {
        return f.r(metaMaterial);
    }

    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a extends ab.a {
        public VasPagView H;
        public ImageView I;
        private final PAGView.PAGViewListener J;

        public a(View view) {
            super(view);
            this.J = new C9027a();
            this.H = (VasPagView) view.findViewById(R.id.f116426yp);
            this.I = (ImageView) view.findViewById(R.id.f165965y90);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ Unit o(String str, PAGView pAGView) {
            PAGFile Load = PagViewMonitor.Load(this.H.getContext().getAssets(), str);
            if (Load != null) {
                pAGView.stop();
                pAGView.setComposition(Load);
                pAGView.setRepeatCount(1);
                pAGView.removeListener(this.J);
                pAGView.addListener(this.J);
                pAGView.setProgress(0.0d);
                pAGView.flush();
                pAGView.play();
                return null;
            }
            ms.a.a("FilterMaterialPanelContentAdapter", "pag not exist " + str);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ Unit p(PAGView pAGView) {
            pAGView.stop();
            return null;
        }

        public void q(final String str) {
            ms.a.a("FilterMaterialPanelContentAdapter", "showPag " + str);
            this.H.api().postAction(new Function1() { // from class: com.tencent.mobileqq.wink.editor.filter.d
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit o16;
                    o16 = e.a.this.o(str, (PAGView) obj);
                    return o16;
                }
            });
        }

        public void r() {
            ms.a.a("FilterMaterialPanelContentAdapter", "stop pag");
            this.H.api().postAction(new Function1() { // from class: com.tencent.mobileqq.wink.editor.filter.c
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    Unit p16;
                    p16 = e.a.p((PAGView) obj);
                    return p16;
                }
            });
        }

        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.wink.editor.filter.e$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        class C9027a implements PAGView.PAGViewListener {
            C9027a() {
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationCancel(PAGView pAGView) {
                VasPagView vasPagView = a.this.H;
                if (vasPagView != null) {
                    vasPagView.setVisibility(8);
                }
                ImageView imageView = a.this.I;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationEnd(PAGView pAGView) {
                VasPagView vasPagView = a.this.H;
                if (vasPagView != null) {
                    vasPagView.setVisibility(8);
                }
                ImageView imageView = a.this.I;
                if (imageView != null) {
                    imageView.setVisibility(8);
                }
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationStart(PAGView pAGView) {
                VasPagView vasPagView = a.this.H;
                if (vasPagView != null) {
                    vasPagView.setVisibility(0);
                }
                ImageView imageView = a.this.I;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationRepeat(PAGView pAGView) {
            }

            @Override // org.libpag.PAGView.PAGViewListener
            public void onAnimationUpdate(PAGView pAGView) {
            }
        }
    }
}
