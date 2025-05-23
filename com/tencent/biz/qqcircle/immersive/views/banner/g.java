package com.tencent.biz.qqcircle.immersive.views.banner;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qqcircle.report.QCircleNativeSessionManager;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes4.dex */
public class g extends RecyclerView.Adapter<b> {
    private static final int G = ImmersiveUtils.dpToPx(32.0f);
    private static final int H = ImmersiveUtils.dpToPx(4.0f);
    private static final int I = ImmersiveUtils.dpToPx(5.0f);
    private a C;
    private e30.b D;
    private String E;

    /* renamed from: m, reason: collision with root package name */
    private final List<Integer> f90753m = new ArrayList();
    private int F = 0;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
        void a(int i3);
    }

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public class b extends RecyclerView.ViewHolder implements View.OnClickListener {
        private final ImageView E;
        private int F;

        public b(ImageView imageView) {
            super(imageView);
            this.E = imageView;
        }

        private boolean m() {
            if (g.this.F == 1) {
                return true;
            }
            return false;
        }

        private void o() {
            if (g.this.D == null) {
                return;
            }
            VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_EMOJI_OUTSIDE_COMMENT_BOX_BAR);
            Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
            buildElementParams.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_EMOJI_OUTSIDE_COMMENT_BOX_BAR);
            buildElementParams.put("xsj_custom_pgid", g.this.E);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, Integer.valueOf(this.F));
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_NAME, QQSysFaceUtil.getFaceDescription(this.F));
            buildElementParams.putAll(ua0.c.d(g.this.D));
            VideoReport.reportEvent("ev_xsj_abnormal_clck", this.E, buildElementParams);
            buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_ACTION_VIDEO_LOCATION, Long.valueOf(w20.a.j().b()));
            if (g.this.F == 0) {
                buildElementParams.put("xsj_action_type", "cmt");
            } else if (g.this.F == 1) {
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_SCENE, QCircleDaTongConstant.ElementParamValue.ARK_CMT);
            }
            VideoReport.reportEvent(QCircleDaTongConstant.EventId.EV_XSJ_CMT_ACTION, this.E, buildElementParams);
        }

        private void p() {
            if (!m() && g.this.D != null && this.E != null) {
                Map<String, Object> buildElementParams = new QCircleDTParamBuilder().buildElementParams();
                buildElementParams.putAll(ua0.c.d(g.this.D));
                buildElementParams.put("xsj_session_id", QCircleNativeSessionManager.g().getSession());
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_ID, Integer.valueOf(this.F));
                buildElementParams.put(QCircleDaTongConstant.ElementParamKey.XSJ_EMOJI_NAME, QQSysFaceUtil.getFaceDescription(this.F));
                VideoReport.setElementId(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_EMOJI_OUTSIDE_COMMENT_BOX_BAR);
                VideoReport.setElementParams(this.E, buildElementParams);
                VideoReport.setElementReuseIdentifier(this.E, QCircleDaTongConstant.ElementId.EM_XSJ_COMMENT_BOX_BAR + this.E.hashCode());
                VideoReport.setElementExposePolicy(this.E, ExposurePolicy.REPORT_ALL);
                VideoReport.setElementEndExposePolicy(this.E, EndExposurePolicy.REPORT_ALL);
            }
        }

        public void l(int i3) {
            this.F = i3;
            this.E.setImageDrawable(QQSysFaceUtil.getFaceDrawable(i3));
            this.E.setOnClickListener(this);
            p();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (g.this.C != null) {
                g.this.C.a(this.F);
            }
            o();
            QLog.d("QFSFriendCommentGuideEmojiAdapter", 1, "emoji view click, localId: " + this.F);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.f90753m.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull b bVar, int i3) {
        if (i3 >= 3) {
            return;
        }
        bVar.l(this.f90753m.get(i3).intValue());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public b onCreateViewHolder(@NonNull ViewGroup viewGroup, int i3) {
        ImageView imageView = new ImageView(viewGroup.getContext());
        int i16 = G;
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(i16, i16);
        int i17 = I;
        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = i17;
        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = i17;
        imageView.setLayoutParams(layoutParams);
        int i18 = H;
        imageView.setPadding(i18, i18, i18, i18);
        return new b(imageView);
    }

    public void o0(e30.b bVar) {
        this.D = bVar;
    }

    public void p0(String str) {
        this.E = str;
    }

    public void q0(a aVar) {
        this.C = aVar;
    }

    public void r0(int i3) {
        this.F = i3;
    }

    public void setData(List<Integer> list) {
        this.f90753m.clear();
        if (list.size() > 3) {
            this.f90753m.addAll(list.subList(0, 3));
        } else {
            this.f90753m.addAll(list);
        }
        notifyDataSetChanged();
    }
}
