package com.tencent.mobileqq.wink.editor.music;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.aw;
import com.tencent.mobileqq.wink.editor.music.b;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import com.tencent.mobileqq.wink.event.StickerEditEvent;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;

/* loaded from: classes21.dex */
public class WinkEditorMusicPanel extends FrameLayout implements b.a, aw.a, View.OnClickListener {
    private TextView C;
    private RelativeLayout D;
    private ImageView E;
    private ImageView F;
    private ImageView G;
    private LinearLayoutManager H;
    private com.tencent.mobileqq.wink.editor.music.b I;
    private LinearLayoutManager J;
    private aw K;
    private boolean L;
    private float M;
    private boolean N;
    private boolean P;
    private String Q;
    private c R;
    private boolean S;
    private boolean T;

    /* renamed from: d, reason: collision with root package name */
    private RelativeLayout f320695d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f320696e;

    /* renamed from: f, reason: collision with root package name */
    private RecyclerView f320697f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f320698h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f320699i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f320700m;

    /* loaded from: classes21.dex */
    class a extends RecyclerView.OnScrollListener {
        a() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            int i16 = 0;
            if (i3 == 0) {
                ImageView imageView = WinkEditorMusicPanel.this.f320698h;
                if (!recyclerView.canScrollHorizontally(-1)) {
                    i16 = 8;
                }
                imageView.setVisibility(i16);
                VideoReport.traverseExposure();
                return;
            }
            if (i3 == 1) {
                WinkEditorMusicPanel.this.f320698h.setVisibility(0);
            }
        }
    }

    /* loaded from: classes21.dex */
    class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // android.support.v7.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i3) {
            super.onScrollStateChanged(recyclerView, i3);
            if (i3 == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* loaded from: classes21.dex */
    public interface c {
        WinkEditorViewModel.EditMode A();

        void J0(@Nullable WinkEditorMusicInfo winkEditorMusicInfo, int i3);

        void M(boolean z16);

        void a();

        void b(ax axVar);

        void c(View view);

        void d(boolean z16);
    }

    public WinkEditorMusicPanel(@NonNull Context context) {
        super(context);
        this.L = false;
        this.M = 0.8f;
        this.P = true;
        this.Q = "";
        this.S = true;
        this.T = false;
        View inflate = LayoutInflater.from(context).inflate(R.layout.hd9, this);
        this.f320695d = (RelativeLayout) inflate.findViewById(R.id.f122707eo);
        this.f320696e = (RecyclerView) inflate.findViewById(R.id.f122647ei);
        this.f320697f = (RecyclerView) inflate.findViewById(R.id.f791148w);
        this.f320698h = (ImageView) inflate.findViewById(R.id.f122727eq);
        this.f320699i = (ImageView) inflate.findViewById(R.id.f122787ew);
        this.E = (ImageView) inflate.findViewById(R.id.f122657ej);
        this.D = (RelativeLayout) inflate.findViewById(R.id.f122737er);
        this.G = (ImageView) inflate.findViewById(R.id.f122677el);
        this.F = (ImageView) inflate.findViewById(R.id.f122667ek);
        this.f320700m = (RelativeLayout) inflate.findViewById(R.id.f122637eh);
        this.C = (TextView) inflate.findViewById(R.id.f122687em);
        this.H = new LinearLayoutManager(context, 0, false);
        this.I = new com.tencent.mobileqq.wink.editor.music.b(context, this);
        this.J = new LinearLayoutManager(context, 0, false);
        this.K = new aw(context, this);
        this.f320697f.setLayoutManager(this.H);
        this.f320697f.setAdapter(this.I);
        this.f320697f.setOnScrollListener(new a());
        this.I.w(WinkEditorMusicInfo.I);
        this.f320696e.setLayoutManager(this.J);
        this.f320696e.setAdapter(this.K);
        this.f320696e.setOnScrollListener(new b());
        this.f320695d.setOnClickListener(this);
        this.E.setOnClickListener(this);
        this.G.setOnClickListener(this);
        this.F.setOnClickListener(this);
        this.C.setOnClickListener(this);
        d(this.C);
    }

    private void d(View view) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_EXPLORE_BUTTON);
        VideoReport.setElementParams(view, WinkDTParamBuilder.buildElementParams());
    }

    private int e(int i3) {
        int itemCount = this.I.getItemCount();
        if (i3 < 0) {
            return 0;
        }
        int i16 = itemCount - 1;
        if (i3 > i16) {
            return i16;
        }
        return i3;
    }

    private boolean f() {
        com.tencent.mobileqq.wink.editor.music.b bVar;
        if (this.H == null || (bVar = this.I) == null || bVar.getItemCount() == 0) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.b.a
    public WinkEditorViewModel.EditMode A() {
        c cVar = this.R;
        if (cVar != null) {
            return cVar.A();
        }
        return WinkEditorViewModel.EditMode.Video;
    }

    @Override // com.tencent.mobileqq.wink.editor.music.b.a
    public void a(@Nullable WinkEditorMusicInfo winkEditorMusicInfo, int i3, boolean z16, int i16, View view) {
        com.tencent.mobileqq.wink.editor.music.b bVar;
        if (i16 == 1) {
            c cVar = this.R;
            if (cVar != null) {
                cVar.a();
                return;
            }
            return;
        }
        if (!z16 && !this.P) {
            QQToast.makeText(getContext(), 0, "\u6a21\u677f\u4e0d\u652f\u6301\u53d6\u6d88\u914d\u4e50", 0).show();
            return;
        }
        if (!z16) {
            setEnableBgm(false);
            return;
        }
        this.T = true;
        if (view != null && view.getX() + view.getWidth() >= this.f320697f.getWidth() - com.tencent.mobileqq.wink.utils.i.a(getContext(), 8.0f) && (bVar = this.I) != null && bVar.q().size() > i3 + 1) {
            this.f320697f.smoothScrollBy(view.getWidth(), 0);
        }
        c cVar2 = this.R;
        if (cVar2 != null) {
            cVar2.J0(winkEditorMusicInfo, i3);
            SimpleEventBus.getInstance().dispatchEvent(new StickerEditEvent(10, 100));
        }
    }

    @Override // com.tencent.mobileqq.wink.editor.music.aw.a
    public void b(ax axVar, View view, int i3) {
        c cVar = this.R;
        if (cVar != null) {
            cVar.b(axVar);
        }
        if (i3 < 3) {
            this.f320696e.smoothScrollToPosition(0);
        } else {
            this.f320696e.smoothScrollBy(((int) view.getX()) - com.tencent.mobileqq.wink.utils.i.a(getContext(), 100.0f), 0);
        }
    }

    public void g(int i3) {
        if (!f()) {
            return;
        }
        this.H.scrollToPosition(e(i3));
    }

    public void h(boolean z16) {
        int i3;
        int i16;
        RecyclerView recyclerView = this.f320697f;
        int i17 = 8;
        if (recyclerView != null) {
            if (z16) {
                i16 = 8;
            } else {
                i16 = 0;
            }
            recyclerView.setVisibility(i16);
        }
        RelativeLayout relativeLayout = this.f320695d;
        if (relativeLayout != null) {
            if (z16) {
                i3 = 8;
            } else {
                i3 = 0;
            }
            relativeLayout.setVisibility(i3);
        }
        RelativeLayout relativeLayout2 = this.f320700m;
        if (relativeLayout2 != null) {
            if (z16) {
                i17 = 0;
            }
            relativeLayout2.setVisibility(i17);
        }
    }

    public void i(@NonNull List<ax> list) {
        aw awVar = this.K;
        if (awVar != null) {
            awVar.u(list);
        }
    }

    public void j(@NonNull List<WinkEditorMusicInfo> list) {
        com.tencent.mobileqq.wink.editor.music.b bVar = this.I;
        if (bVar != null) {
            bVar.w(list);
            VideoReport.traversePage(this.f320697f);
        }
        if (this.f320697f != null) {
            int i3 = 0;
            while (true) {
                if (i3 < list.size()) {
                    if (list.get(i3) != null && list.get(i3).f321259e) {
                        break;
                    } else {
                        i3++;
                    }
                } else {
                    i3 = -1;
                    break;
                }
            }
            if (i3 >= 0) {
                this.f320697f.smoothScrollToPosition(i3);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view != null) {
            if (view.getId() == R.id.f122657ej) {
                this.R.M(true);
                Map<String, ? extends Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
                buildElementParams.put("xsj_music_id", WinkDatongCurrentParams.get("xsj_music_id"));
                buildElementParams.put("xsj_music_name", WinkDatongCurrentParams.get("xsj_music_name"));
                buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME, WinkDatongCurrentParams.get(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_CATEGORY_NAME));
                com.tencent.mobileqq.wink.report.a.f326259a.a(WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_CUT_BUTTON, "ev_xsj_abnormal_clck", this.Q, buildElementParams);
            } else if (view.getId() == R.id.f122677el) {
                if (!this.P) {
                    QQToast.makeText(getContext(), 0, "\u6a21\u677f\u4e0d\u652f\u6301\u53d6\u6d88\u914d\u4e50", 0).show();
                } else if (this.N) {
                    setEnableBgm(false);
                } else {
                    QQToast.makeText(getContext(), 0, "\u56fe\u7247\u4e0d\u652f\u6301\u53d6\u6d88\u97f3\u4e50", 0).show();
                }
            } else if (view.getId() != R.id.f122707eo && view.getId() != R.id.f122687em) {
                if (view.getId() == R.id.f122667ek) {
                    if (!this.L) {
                        this.K.t();
                    }
                    this.R.c(view);
                }
            } else {
                this.R.a();
                Map<String, ? extends Object> buildElementParams2 = WinkDTParamBuilder.buildElementParams();
                buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_LENGTH_ADJUST_ACT, "click");
                if (!TextUtils.isEmpty(this.Q)) {
                    buildElementParams2.put(WinkDaTongReportConstant.ElementParamKey.XSJ_MUSIC_LIBRARY_SOURCE, this.Q);
                } else {
                    QLog.e("AEEditorMusicPanel", 1, "musicLibrarySource is null");
                }
                com.tencent.mobileqq.wink.report.a.f326259a.a(WinkDaTongReportConstant.ElementId.EM_XSJ_MUSIC_LIBRARY, "ev_xsj_camera_action", this.Q, buildElementParams2);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setClipEntranceVisible(boolean z16) {
        int i3;
        ImageView imageView = this.E;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    public void setCollectEntrance(boolean z16) {
        int i3;
        ImageView imageView = this.F;
        if (imageView != null) {
            this.L = z16;
            if (z16) {
                i3 = R.drawable.lot;
            } else {
                i3 = R.drawable.l5v;
            }
            imageView.setImageResource(i3);
        }
    }

    public void setCollectEntranceVisible(boolean z16) {
        int i3;
        ImageView imageView = this.F;
        if (imageView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            imageView.setVisibility(i3);
        }
    }

    public void setEnableBgm(boolean z16) {
        this.T = z16;
        c cVar = this.R;
        if (cVar != null) {
            cVar.d(z16);
        }
    }

    public void setMusicDisableEnable(boolean z16) {
        this.N = z16;
    }

    public void setMusicEnableClear(boolean z16) {
        this.P = z16;
    }

    public void setMusicLibrarySource(String str) {
        this.Q = str;
    }

    public void setOperatePanelVisible(boolean z16) {
        int i3;
        RelativeLayout relativeLayout = this.D;
        if (relativeLayout != null) {
            int i16 = 0;
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            relativeLayout.setVisibility(i3);
            ImageView imageView = this.f320699i;
            if (!z16) {
                i16 = 8;
            }
            imageView.setVisibility(i16);
            this.D.requestLayout();
        }
    }

    public void setOperationCallback(@Nullable c cVar) {
        this.R = cVar;
    }

    public void setAutoTemplate(boolean z16, boolean z17) {
    }
}
