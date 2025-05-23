package com.tencent.mobileqq.tvideo.presenter.intro;

import android.app.Activity;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.widgets.QCircleAvatarView;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tvideo.event.QFSTVideoPageWebViewShowEvent;
import com.tencent.mobileqq.tvideo.presenter.intro.e;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tvideo.Video;
import tvideo.VideoBriefIntro$Star;

/* compiled from: P */
/* loaded from: classes19.dex */
public class e extends RecyclerView.Adapter<a> {
    private static final int D = ViewUtils.dip2px(52.0f);
    private Video C;

    /* renamed from: m, reason: collision with root package name */
    private List<VideoBriefIntro$Star> f304712m = new ArrayList();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a extends RecyclerView.ViewHolder {
        private final QCircleAvatarView E;
        private final TextView F;

        a(@NonNull View view) {
            super(view);
            this.E = (QCircleAvatarView) view.findViewById(R.id.xzm);
            this.F = (TextView) view.findViewById(R.id.f1057966z);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void o(final VideoBriefIntro$Star videoBriefIntro$Star) {
            TextView textView = this.F;
            if (textView != null && this.E != null && videoBriefIntro$Star != null) {
                textView.setText(videoBriefIntro$Star.name.get());
                this.E.setAvatarByUrl(videoBriefIntro$Star.image_url.get(), new Size(e.D, e.D));
                this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.tvideo.presenter.intro.c
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        e.a.this.p(videoBriefIntro$Star, view);
                    }
                });
                this.itemView.post(new Runnable() { // from class: com.tencent.mobileqq.tvideo.presenter.intro.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.a.this.q(videoBriefIntro$Star);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void p(VideoBriefIntro$Star videoBriefIntro$Star, View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (ScreenUtils.isLandscape() && (this.itemView.getContext() instanceof Activity)) {
                ((Activity) this.itemView.getContext()).onBackPressed();
            }
            QFSTVideoPageWebViewShowEvent qFSTVideoPageWebViewShowEvent = new QFSTVideoPageWebViewShowEvent();
            qFSTVideoPageWebViewShowEvent.setWord(videoBriefIntro$Star.name.get());
            SimpleEventBus.getInstance().dispatchEvent(qFSTVideoPageWebViewShowEvent);
            r(this.itemView, videoBriefIntro$Star.name.get());
            VideoReport.reportEvent("clck", this.itemView, null);
            EventCollector.getInstance().onViewClicked(view);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void q(VideoBriefIntro$Star videoBriefIntro$Star) {
            r(this.itemView, videoBriefIntro$Star.name.get());
            VideoReport.reportEvent("imp", this.itemView, null);
        }

        private void r(View view, String str) {
            Map<String, Object> i3 = gy2.c.i(e.this.C);
            i3.put("star_name", str);
            VideoReport.setElementParams(view, i3);
            VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_NONE);
            VideoReport.setElementId(view, "fanclub_icon");
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: getItemCount */
    public int getNUM_BACKGOURND_ICON() {
        return this.f304712m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull a aVar, int i3) {
        VideoBriefIntro$Star videoBriefIntro$Star = this.f304712m.get(i3);
        if (videoBriefIntro$Star != null) {
            aVar.o(videoBriefIntro$Star);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: l0, reason: merged with bridge method [inline-methods] */
    public a onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        int i16;
        if (ScreenUtils.isPortrait()) {
            i16 = R.layout.ggv;
        } else {
            i16 = R.layout.ggu;
        }
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(i16, viewGroup, false));
    }

    public void m0(List<VideoBriefIntro$Star> list) {
        this.f304712m = list;
        notifyDataSetChanged();
    }

    public void n0(Video video) {
        this.C = video;
    }
}
