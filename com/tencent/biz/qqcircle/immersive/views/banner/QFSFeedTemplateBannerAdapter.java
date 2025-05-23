package com.tencent.biz.qqcircle.immersive.views.banner;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.immersive.utils.af;
import com.tencent.biz.qqcircle.widgets.RoundFrameLayout;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import cooperation.qqcircle.report.QCircleLpReportDc05507;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import qqcircle.QQCircleDitto$StItemInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSFeedTemplateBannerAdapter extends k<RecyclerView.ViewHolder> {
    private List<QQCircleDitto$StItemInfo> G = new ArrayList();
    private int H = 0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class QFSFeedTemplateBannerVH extends RecyclerView.ViewHolder {
        private RoundFrameLayout E;
        private ImageView F;
        private ImageView G;
        private ImageView H;
        private ImageView I;
        private TextView J;
        private TextView K;
        private TextView L;
        private z01.a M;
        private Runnable N;

        public QFSFeedTemplateBannerVH(@NonNull View view) {
            super(view);
            this.E = (RoundFrameLayout) view.findViewById(R.id.f44401p3);
            this.F = (ImageView) view.findViewById(R.id.f44381p1);
            this.G = (ImageView) view.findViewById(R.id.f44391p2);
            this.H = (ImageView) view.findViewById(R.id.f44411p4);
            this.I = (ImageView) view.findViewById(R.id.f44431p6);
            this.J = (TextView) view.findViewById(R.id.f56462ko);
            this.K = (TextView) view.findViewById(R.id.f56452kn);
            this.L = (TextView) view.findViewById(R.id.f56442km);
            RoundFrameLayout roundFrameLayout = this.E;
            if (roundFrameLayout != null) {
                roundFrameLayout.setRadius(roundFrameLayout.getContext().getResources().getDimensionPixelSize(R.dimen.d37));
            }
        }

        public boolean t() {
            if (this.M != null) {
                return true;
            }
            return false;
        }

        public void u(Animatable animatable) {
            if (animatable instanceof z01.a) {
                z01.a aVar = (z01.a) animatable;
                this.M = aVar;
                aVar.setAutoPlay(false);
                this.M.stop();
            }
        }

        public void v() {
            if (this.N == null) {
                this.N = new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.views.banner.QFSFeedTemplateBannerAdapter.QFSFeedTemplateBannerVH.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (QFSFeedTemplateBannerVH.this.t()) {
                            QFSFeedTemplateBannerVH.this.M.start();
                            QLog.d("QFSFeedTemplateBannerAdapter", 1, "apng start!");
                        }
                    }
                };
            }
            this.E.postDelayed(this.N, 500L);
        }

        public void w() {
            if (t()) {
                this.E.removeCallbacks(this.N);
                this.M.stop();
                this.M = null;
                this.G.setImageDrawable(null);
                QLog.d("QFSFeedTemplateBannerAdapter", 1, "apng stop!");
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCircleDitto$StItemInfo f90519d;

        a(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
            this.f90519d = qQCircleDitto$StItemInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSFeedTemplateBannerAdapter.this.x0(this.f90519d.f429300id.get());
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), this.f90519d.buttonInfo.jumpUrl.get());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QQCircleDitto$StItemInfo f90521d;

        b(QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo) {
            this.f90521d = qQCircleDitto$StItemInfo;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QFSFeedTemplateBannerAdapter.this.z0();
            com.tencent.biz.qqcircle.launcher.c.g(view.getContext(), this.f90521d.buttonInfo.jumpUrl.get());
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class c extends QCirclePicStateListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QFSFeedTemplateBannerVH f90523d;

        c(QFSFeedTemplateBannerVH qFSFeedTemplateBannerVH) {
            this.f90523d = qFSFeedTemplateBannerVH;
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            QFSFeedTemplateBannerVH qFSFeedTemplateBannerVH = this.f90523d;
            if (qFSFeedTemplateBannerVH != null && !qFSFeedTemplateBannerVH.t() && loadState.isFinishSuccess() && option.getAnimatable() != null) {
                this.f90523d.u(option.getAnimatable());
                this.f90523d.v();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public static class d extends RecyclerView.ViewHolder {
        private ImageView E;

        public d(@NonNull View view) {
            super(view);
            this.E = (ImageView) view.findViewById(R.id.f44421p5);
        }
    }

    private void A0() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<QQCircleDitto$StItemInfo> it = this.G.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f429300id.get());
            sb5.append(";");
        }
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(612).setSubActionType(3).setExt3(sb5.toString()));
    }

    private void w0(QFSFeedTemplateBannerVH qFSFeedTemplateBannerVH, int i3) {
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = this.G.get(i3);
        String a16 = af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "motion_cover_url");
        if (!qFSFeedTemplateBannerVH.t()) {
            ImageView imageView = qFSFeedTemplateBannerVH.G;
            Option loadingDrawableColor = Option.obtain().setUrl(a16).setRequestWidth(imageView.getWidth()).setRequestHeight(imageView.getHeight()).setTargetView(imageView).setEnableAutoDeleteLocalCache(false).setLoadingDrawableColor(0);
            loadingDrawableColor.setSupportRecycler(true);
            QCircleFeedPicLoader.g().loadImage(loadingDrawableColor, new c(qFSFeedTemplateBannerVH));
        } else {
            qFSFeedTemplateBannerVH.v();
        }
        QLog.d("QFSFeedTemplateBannerAdapter", 1, "[onViewHolderSelected] -> apng url = " + a16 + " ,pos: " + i3);
        y0(qQCircleDitto$StItemInfo.f429300id.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void x0(String str) {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(612).setSubActionType(6).setExt3(str));
    }

    private void y0(String str) {
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(612).setSubActionType(5).setExt3(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z0() {
        StringBuilder sb5 = new StringBuilder();
        Iterator<QQCircleDitto$StItemInfo> it = this.G.iterator();
        while (it.hasNext()) {
            sb5.append(it.next().f429300id.get());
            sb5.append(";");
        }
        QCircleLpReportDc05507.report(new QCircleLpReportDc05507.DataBuilder().setActionType(612).setSubActionType(4).setExt3(sb5.toString()));
    }

    public void B0() {
        o0(getRecyclerView().findViewHolderForAdapterPosition(this.H), this.H);
    }

    public void C0() {
        p0(getRecyclerView().findViewHolderForAdapterPosition(this.H), this.H);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i3) {
        if (i3 == this.G.size() - 1) {
            return 10002;
        }
        return 10001;
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    protected void i0(RecyclerView.ViewHolder viewHolder, int i3) {
        List<QQCircleDitto$StItemInfo> list = this.G;
        if (list == null) {
            return;
        }
        QQCircleDitto$StItemInfo qQCircleDitto$StItemInfo = list.get(i3);
        if (viewHolder instanceof QFSFeedTemplateBannerVH) {
            QFSFeedTemplateBannerVH qFSFeedTemplateBannerVH = (QFSFeedTemplateBannerVH) viewHolder;
            String a16 = af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "static_cover_url");
            String a17 = af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "mask_img_url");
            if (TextUtils.isEmpty(a17)) {
                a17 = "https://qq-video.cdn-go.cn/url-resource/latest/defaultmode/8918/pymk/qvideo_pymk_muban_mask_default.png";
            }
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(a16).setRequestWidth(qFSFeedTemplateBannerVH.F.getMeasuredWidth()).setRequestHeight(qFSFeedTemplateBannerVH.F.getMeasuredHeight()).setTargetView(qFSFeedTemplateBannerVH.F), null);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(a17).setRequestWidth(qFSFeedTemplateBannerVH.H.getMeasuredWidth()).setRequestHeight(qFSFeedTemplateBannerVH.H.getMeasuredHeight()).setTargetView(qFSFeedTemplateBannerVH.H), null);
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl("https://qq-video.cdn-go.cn/android/latest/defaultmode/8935/FRI_TAB_PYMK/qvideo_pymk_muban_btn_V2.png").setRequestWidth(qFSFeedTemplateBannerVH.I.getMeasuredWidth()).setRequestHeight(qFSFeedTemplateBannerVH.I.getMeasuredHeight()).setTargetView(qFSFeedTemplateBannerVH.I), null);
            qFSFeedTemplateBannerVH.L.setText(qQCircleDitto$StItemInfo.buttonInfo.name.get());
            qFSFeedTemplateBannerVH.J.setText(qQCircleDitto$StItemInfo.name.get());
            if (qQCircleDitto$StItemInfo.des.get().size() > 0) {
                qFSFeedTemplateBannerVH.K.setText(qQCircleDitto$StItemInfo.des.get().get(0));
            }
            qFSFeedTemplateBannerVH.G.setOnClickListener(new a(qQCircleDitto$StItemInfo));
            VideoReport.setElementId(qFSFeedTemplateBannerVH.G, "em_xsj_template_item");
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_template_id", qQCircleDitto$StItemInfo.f429300id.get());
            buildElementParams.put("xsj_template_name", qQCircleDitto$StItemInfo.name.get());
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_TEMPLATE_INDEX, Integer.valueOf(i3 + 1));
            VideoReport.setElementParams(qFSFeedTemplateBannerVH.G, buildElementParams);
            return;
        }
        if (viewHolder instanceof d) {
            d dVar = (d) viewHolder;
            QCircleFeedPicLoader.g().loadImage(Option.obtain().setUrl(af.a(qQCircleDitto$StItemInfo.urlInfo.get(), "cover_url")).setRequestWidth(dVar.E.getMeasuredWidth()).setRequestHeight(dVar.E.getMeasuredWidth()).setTargetView(dVar.E));
            dVar.E.setOnClickListener(new b(qQCircleDitto$StItemInfo));
            VideoReport.setElementId(dVar.E, QCircleDaTongConstant.ElementId.EM_XSJ_VIEW_MORE_BUTTON);
        }
    }

    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public int k0() {
        return this.G.size();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public void o0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.o0(viewHolder, i3);
        this.H = i3;
        if (viewHolder instanceof QFSFeedTemplateBannerVH) {
            w0((QFSFeedTemplateBannerVH) viewHolder, i3);
        } else {
            A0();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        Context context = viewGroup.getContext();
        if (i3 == 10002) {
            return new d(LayoutInflater.from(context).inflate(R.layout.gff, viewGroup, false));
        }
        return new QFSFeedTemplateBannerVH(LayoutInflater.from(context).inflate(R.layout.gfd, viewGroup, false));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.immersive.views.banner.k
    public void p0(RecyclerView.ViewHolder viewHolder, int i3) {
        super.p0(viewHolder, i3);
        if (viewHolder instanceof QFSFeedTemplateBannerVH) {
            ((QFSFeedTemplateBannerVH) viewHolder).w();
            QLog.d("QFSFeedTemplateBannerAdapter", 1, "[onViewHolderUnSelected] -> pos: " + i3);
        }
    }

    public void setDatas(List<QQCircleDitto$StItemInfo> list) {
        if (list != null && !list.isEmpty()) {
            this.G.clear();
            this.G.addAll(list);
            notifyDataSetChanged();
        }
    }

    public List<QQCircleDitto$StItemInfo> v0() {
        return this.G;
    }
}
