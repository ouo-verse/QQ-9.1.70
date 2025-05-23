package com.tencent.mobileqq.wink.editor.tts;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.ae.util.PagViewMonitor;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.ui.VasPagView;
import com.tencent.mobileqq.wink.utils.ViewUtilsKt;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.libpag.PAGFile;
import org.libpag.PAGView;

/* compiled from: P */
/* loaded from: classes21.dex */
public class b extends RecyclerView.Adapter<a> {
    private Context C;
    private com.tencent.mobileqq.wink.editor.tts.a D;

    /* renamed from: m, reason: collision with root package name */
    private List<WinkTTSDataInfo> f322559m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes21.dex */
    public static class a extends RecyclerView.ViewHolder implements View.OnClickListener {
        private View E;
        private FrameLayout F;
        private ImageView G;
        private FrameLayout H;
        private VasPagView I;
        private ImageView J;
        private TextView K;
        private FrameLayout L;
        private com.tencent.mobileqq.wink.editor.tts.a M;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.wink.editor.tts.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes21.dex */
        public class C9045a implements Function1<PAGView, Unit> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ String f322560d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ PAGFile f322561e;

            C9045a(String str, PAGFile pAGFile) {
                this.f322560d = str;
                this.f322561e = pAGFile;
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unit invoke(PAGView pAGView) {
                if (pAGView != null && !TextUtils.isEmpty(this.f322560d) && !pAGView.isPlaying()) {
                    pAGView.setComposition(this.f322561e);
                    pAGView.setRepeatCount(0);
                    pAGView.play();
                    return null;
                }
                return null;
            }
        }

        public a(View view, com.tencent.mobileqq.wink.editor.tts.a aVar) {
            super(view);
            this.M = aVar;
            this.E = view;
            this.F = (FrameLayout) view.findViewById(R.id.f1042462s);
            this.G = (ImageView) view.findViewById(R.id.f1042562t);
            this.K = (TextView) view.findViewById(R.id.f1042762v);
            this.L = (FrameLayout) view.findViewById(R.id.f1043062y);
            this.H = (FrameLayout) view.findViewById(R.id.f1042662u);
            this.I = (VasPagView) view.findViewById(R.id.f1042262q);
            this.J = (ImageView) view.findViewById(R.id.f1042862w);
            this.F.setOnClickListener(this);
        }

        private void n(String str) {
            this.I.api().build().postAction(new C9045a(str, PagViewMonitor.Load(this.I.getContext().getAssets(), str)));
        }

        public void m(WinkTTSDataInfo winkTTSDataInfo, int i3) {
            if (winkTTSDataInfo.getItemType() == 1 && !TextUtils.isEmpty(winkTTSDataInfo.getIcon())) {
                this.G.setVisibility(0);
                ViewUtilsKt.j(this.G, winkTTSDataInfo.getIcon());
                this.L.setVisibility(8);
            } else if (winkTTSDataInfo.getItemType() == 0) {
                this.G.setVisibility(8);
                this.L.setVisibility(0);
            } else {
                this.G.setVisibility(4);
                this.L.setVisibility(8);
            }
            this.F.setTag(winkTTSDataInfo);
            this.K.setText(winkTTSDataInfo.getDisplayName());
            if (winkTTSDataInfo.getDownloadStatus() == 1) {
                this.J.setVisibility(0);
            } else {
                this.J.setVisibility(8);
            }
            if (winkTTSDataInfo.isSelected()) {
                this.K.setTextColor(this.E.getContext().getResources().getColor(R.color.f158017al3));
                TextView textView = this.K;
                textView.setTypeface(textView.getTypeface(), 1);
                if (winkTTSDataInfo.getItemType() != 0 && winkTTSDataInfo.isPlaying()) {
                    this.I.setVisibility(0);
                    n("wink/pag/icon_music_wave_animation.pag");
                } else {
                    this.I.setVisibility(8);
                }
                this.H.setBackgroundResource(R.drawable.f162010l52);
                return;
            }
            this.K.setTextColor(this.E.getContext().getResources().getColor(R.color.bfq));
            TextView textView2 = this.K;
            textView2.setTypeface(textView2.getTypeface(), 0);
            this.H.setBackgroundResource(R.color.ajr);
            this.I.setVisibility(8);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (view.getId() == R.id.f1042462s) {
                WinkTTSDataInfo winkTTSDataInfo = (WinkTTSDataInfo) view.getTag();
                this.M.a(winkTTSDataInfo, winkTTSDataInfo.isSelected());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(Context context, com.tencent.mobileqq.wink.editor.tts.a aVar) {
        this.C = context;
        this.D = aVar;
    }

    public static void i0(View view, WinkTTSDataInfo winkTTSDataInfo) {
        if (winkTTSDataInfo != null) {
            VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EMOTION_VOLUME_THUMBNAIL_BUTTON);
            VideoReport.setElementReuseIdentifier(view, String.valueOf(winkTTSDataInfo.getTemplateType()));
            Map<String, Object> buildElementParams = WinkDTParamBuilder.buildElementParams();
            buildElementParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VOLUME_NAME, winkTTSDataInfo.getDisplayName());
            VideoReport.setElementParams(view, buildElementParams);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        }
    }

    public static void j0(View view) {
        VideoReport.setElementId(view, WinkDaTongReportConstant.ElementId.EM_XSJ_EMOTION_VOLUME_THUMBNAIL_BUTTON);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        List<WinkTTSDataInfo> list = this.f322559m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(a aVar, int i3) {
        aVar.m(this.f322559m.get(i3), i3);
        i0(aVar.F, this.f322559m.get(i3));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(ViewGroup viewGroup, int i3) {
        a aVar = new a(LayoutInflater.from(this.C).inflate(R.layout.hdm, viewGroup, false), this.D);
        j0(aVar.F);
        return aVar;
    }

    public void m0(List<WinkTTSDataInfo> list) {
        this.f322559m = list;
    }
}
