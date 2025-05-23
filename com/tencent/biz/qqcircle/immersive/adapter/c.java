package com.tencent.biz.qqcircle.immersive.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.part.block.base.BaseListViewAdapter;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class c extends BaseListViewAdapter<Integer> {
    private e30.b C;
    private String D;

    /* renamed from: m, reason: collision with root package name */
    private b f84719m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    class a extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView E;
        private int F;
        private int G;

        public a(ImageView imageView) {
            super(imageView);
            this.E = imageView;
        }

        private void m() {
            if (c.this.C != null && this.E != null) {
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.putAll(ua0.c.d(c.this.C));
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, Integer.valueOf(this.F));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_NAME, QQSysFaceUtil.getFaceDescription(this.F));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_LOCATION, Integer.valueOf(this.G + 1));
                VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_LONGPRESS_CMT_EMOJI);
                VideoReport.setElementParams(this.E, buildElementParams);
                VideoReport.setElementReuseIdentifier(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_LONGPRESS_CMT_EMOJI + this.E.hashCode());
                VideoReport.setElementExposePolicy(this.E, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementEndExposePolicy(this.E, EndExposurePolicy.REPORT_ALL);
            }
        }

        private void o() {
            if (c.this.C == null) {
                return;
            }
            VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_LONGPRESS_CMT_EMOJI);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.putAll(ua0.c.d(c.this.C));
            buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_LONGPRESS_CMT_EMOJI);
            buildElementParams.put("xsj_custom_pgid", c.this.D);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, Integer.valueOf(this.F));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_NAME, QQSysFaceUtil.getFaceDescription(this.F));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_LOCATION, Integer.valueOf(this.G + 1));
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION, this.E, buildElementParams);
        }

        public void l(int i3, int i16) {
            this.F = i3;
            this.G = i16;
            this.E.setImageDrawable(QQSysFaceUtil.getFaceDrawable(i3));
            this.E.setOnClickListener(this);
            m();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (c.this.f84719m != null) {
                c.this.f84719m.a(this.F, this.G);
            }
            o();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface b {
        void a(int i3, int i16);
    }

    public void l0(e30.b bVar) {
        this.C = bVar;
    }

    public void m0(b bVar) {
        this.f84719m = bVar;
    }

    public void n0(String str) {
        this.D = str;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i3) {
        if (viewHolder instanceof a) {
            ((a) viewHolder).l(((Integer) this.mDataList.get(i3)).intValue(), i3);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        imageView.setLayoutParams(new RecyclerView.LayoutParams(ImmersiveUtils.dpToPx(48.0f), ImmersiveUtils.dpToPx(48.0f)));
        imageView.setPadding(ImmersiveUtils.dpToPx(6.0f), ImmersiveUtils.dpToPx(6.0f), ImmersiveUtils.dpToPx(6.0f), ImmersiveUtils.dpToPx(6.0f));
        return new a(imageView);
    }
}
