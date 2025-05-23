package com.tencent.biz.qqcircle.immersive.personal.widget;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.beans.QCircleTagItemInfo;
import com.tencent.biz.qqcircle.immersive.personal.data.w;
import com.tencent.biz.qqcircle.immersive.personal.wrapper.QFSPersonalRankAchieveAnimWrapper;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.theme.SkinnableView;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudMeta$StMedalInfo;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes4.dex */
public class QFSRankTagListView extends QCircleBaseWidgetView<w> implements View.OnClickListener, SkinnableView {
    private static final float K = cx.a(32.0f);
    private View C;
    private QFSNewMedalHintView D;
    private TextView E;
    private boolean F;
    private boolean G;
    private String H;
    private QFSPersonalRankAchieveAnimWrapper I;
    private a J;

    /* renamed from: d, reason: collision with root package name */
    private w f89353d;

    /* renamed from: e, reason: collision with root package name */
    private RecyclerView f89354e;

    /* renamed from: f, reason: collision with root package name */
    private com.tencent.biz.qqcircle.adapter.k f89355f;

    /* renamed from: h, reason: collision with root package name */
    private TextView f89356h;

    /* renamed from: i, reason: collision with root package name */
    private View f89357i;

    /* renamed from: m, reason: collision with root package name */
    private View f89358m;

    /* compiled from: P */
    /* loaded from: classes4.dex */
    public interface a {
    }

    public QFSRankTagListView(@NonNull Context context) {
        this(context, null);
    }

    private void A0() {
        if (this.C == null) {
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{getContext().getResources().getColor(R.color.ajr), QFSQUIUtilsKt.d(getContext(), R.color.qui_common_bg_bottom_light)});
        this.C.setBackground(gradientDrawable);
    }

    private void B0(View view, boolean z16) {
        if (view == null) {
            QLog.d("RANK-QCircleRankTagListView", 1, "[setViewVisible] view should not be null.");
            return;
        }
        int i3 = 0;
        QLog.d("RANK-QCircleRankTagListView", 1, "[setViewVisible] view: ", view.toString(), " | isVisible: ", Boolean.valueOf(z16));
        if (!z16) {
            i3 = 8;
        }
        if (view.getVisibility() != i3) {
            view.setVisibility(i3);
        }
    }

    private void C0(boolean z16) {
        if (z16) {
            q0(false);
        } else {
            p0(false);
        }
    }

    private void D0() {
        if (this.f89354e == null) {
            return;
        }
        QFSPersonalRankAchieveAnimWrapper qFSPersonalRankAchieveAnimWrapper = this.I;
        if (qFSPersonalRankAchieveAnimWrapper != null && qFSPersonalRankAchieveAnimWrapper.p()) {
            QLog.e(getLogTag(), 1, "updateMaskView achieve anim view is visible");
        } else {
            this.f89354e.post(new Runnable() { // from class: com.tencent.biz.qqcircle.immersive.personal.widget.QFSRankTagListView.1
                @Override // java.lang.Runnable
                public void run() {
                    int i3;
                    if (QFSRankTagListView.this.C != null) {
                        View view = QFSRankTagListView.this.C;
                        if (QFSRankTagListView.this.z0()) {
                            i3 = 0;
                        } else {
                            i3 = 8;
                        }
                        view.setVisibility(i3);
                    }
                }
            });
        }
    }

    private void E0(List<FeedCloudMeta$StMedalInfo> list, boolean z16) {
        int size;
        if (this.f89355f == null) {
            QLog.d("RANK-QCircleRankTagListView", 1, "[updateRecyclerSource] recycler adapter should not be null.");
            return;
        }
        if (list == null) {
            size = 0;
        } else {
            size = list.size();
        }
        QLog.d("RANK-QCircleRankTagListView", 1, "[updateRecyclerSource] medal source size: ", Integer.valueOf(size));
        if (size == 0) {
            C0(z16);
            return;
        }
        if (z16) {
            q0(true);
        } else {
            p0(true);
        }
        this.f89355f.setData(r0(list));
        D0();
    }

    private void m0() {
        View view = this.f89357i;
        if (view == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.leftMargin = cx.a(36.0f);
        this.f89357i.setLayoutParams(layoutParams);
    }

    private void o0() {
        TextView textView;
        if ((!this.G || (textView = this.E) == null) && (textView = this.f89356h) == null) {
            textView = null;
        }
        if (textView == null) {
            return;
        }
        VideoReport.setElementId(textView, QCircleDaTongConstant.ElementId.EM_XSJ_MEDAL_WALL_ICON);
        VideoReport.setElementParams(textView, new QCircleDTParamBuilder().buildElementParams());
        VideoReport.setElementExposePolicy(textView, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementClickPolicy(textView, ClickPolicy.REPORT_NONE);
    }

    private void p0(boolean z16) {
        B0(this, z16);
        B0(this.f89354e, z16);
    }

    private void q0(boolean z16) {
        B0(this, true);
        B0(this.f89354e, z16);
    }

    private List<QCircleTagItemInfo> r0(List<FeedCloudMeta$StMedalInfo> list) {
        ArrayList arrayList = new ArrayList();
        if (list == null) {
            QLog.d("RANK-QCircleRankTagListView", 1, "[convertTagItemInfoList] medal source should not be null.");
            return arrayList;
        }
        for (FeedCloudMeta$StMedalInfo feedCloudMeta$StMedalInfo : list) {
            if (feedCloudMeta$StMedalInfo.type.get() == -1) {
                arrayList.add(new QCircleTagItemInfo(-1, feedCloudMeta$StMedalInfo));
            } else {
                arrayList.add(new QCircleTagItemInfo(3, feedCloudMeta$StMedalInfo));
            }
        }
        return arrayList;
    }

    private void s0(View view) {
        this.G = y0();
        this.D = (QFSNewMedalHintView) view.findViewById(R.id.f485420_);
        this.E = (TextView) view.findViewById(R.id.f32760um);
        ImageView imageView = (ImageView) view.findViewById(R.id.f31290qn);
        if (this.G) {
            this.f89358m.setVisibility(8);
            this.D.setVisibility(0);
            this.E.setVisibility(0);
            imageView.setVisibility(8);
            this.D.setOnClickListener(this);
            this.E.setOnClickListener(this);
            imageView.setOnClickListener(this);
            QLog.d("RANK-QCircleRankTagListView", 1, "[initNewHintView] isHintMedalWallIconOptimizeExp");
            return;
        }
        this.f89358m.setVisibility(0);
        this.D.setVisibility(8);
        this.E.setVisibility(8);
        imageView.setVisibility(8);
    }

    private void u0(View view) {
        this.f89354e = (RecyclerView) view.findViewById(R.id.f32790up);
        this.f89357i = view.findViewById(R.id.f31280qm);
        this.f89358m = view.findViewById(R.id.f32350ti);
        this.f89356h = (TextView) view.findViewById(R.id.f32750ul);
        this.C = view.findViewById(R.id.f32340th);
        A0();
        this.I = new QFSPersonalRankAchieveAnimWrapper(getContext(), view);
        s0(view);
        x0();
        w0(getContext());
        v0();
        VideoReport.setElementId(this.f89357i, QCircleDaTongConstant.ElementId.EM_XSJ_ENTRY_ACHIEVEMENT_SHOW_BUTTON);
    }

    private void v0() {
        if (this.f89354e == null) {
            QLog.w("RANK-QCircleRankTagListView", 1, "[initializeRecyclerAdapter] rank tag recycler view should not be null.");
            return;
        }
        com.tencent.biz.qqcircle.adapter.k kVar = new com.tencent.biz.qqcircle.adapter.k();
        this.f89355f = kVar;
        this.f89354e.setAdapter(kVar);
    }

    private void w0(Context context) {
        if (this.f89354e == null) {
            QLog.d("RANK-QCircleRankTagListView", 1, "[initializeRecyclerParam] rank tag recycler view should not be null.");
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(0);
        this.f89354e.setLayoutManager(linearLayoutManager);
    }

    private void x0() {
        View view = this.f89358m;
        if (view != null) {
            view.setOnClickListener(this);
            int a16 = cx.a(10.0f);
            QCirclePluginUtil.expandViewTouchDelegate(this.f89358m, a16, a16, a16, a16);
        }
    }

    private boolean y0() {
        return TextUtils.equals(com.tencent.biz.qqcircle.utils.l.b("exp_icon"), "exp_icon_B");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean z0() {
        QFSNewMedalHintView qFSNewMedalHintView;
        float f16 = K;
        View view = this.f89358m;
        if (view != null && view.getVisibility() == 0) {
            f16 += this.f89358m.getWidth();
        }
        if (this.G && (qFSNewMedalHintView = this.D) != null && qFSNewMedalHintView.getVisibility() == 0) {
            return this.D.j();
        }
        if (this.f89354e != null && r1.getWidth() >= cx.g() - f16) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.g5h;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.qqcircle.widgets.QCircleBaseWidgetView
    public String getLogTag() {
        return "RANK-QCircleRankTagListView";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    /* renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void bindData(w wVar, int i3) {
        boolean z16;
        if (wVar == null) {
            QLog.d("RANK-QCircleRankTagListView", 1, "[bindData] medal wall should not be null.");
            return;
        }
        this.f89353d = wVar;
        this.H = wVar.b().medalWall.medalWallJumpUrl.get();
        boolean z17 = wVar.b().medalWall.needRedPoint.get();
        this.F = z17;
        if (z17) {
            QLog.d("RANK-QCircleRankTagListView", 1, "mIsShowRedPoint: true");
        }
        if (wVar.z() && this.F && !this.G) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 && this.I != null) {
            B0(this.f89356h, false);
            this.I.j(true);
            com.tencent.biz.qqcircle.immersive.manager.e.a().notifyGroupActivate(this.I);
        } else if (!z16) {
            B0(this.f89356h, true);
            m0();
        }
        boolean isOwner = QCirclePluginUtil.isOwner(wVar.L());
        List<FeedCloudMeta$StMedalInfo> arrayList = new ArrayList<>();
        List<FeedCloudMeta$StMedalInfo> list = wVar.b().medalWall.medalInfos.get();
        if (list != null && list.size() > 0) {
            arrayList.addAll(list);
            TextView textView = this.E;
            if (textView != null) {
                textView.setVisibility(0);
            }
        } else {
            RFWLog.i("RANK-QCircleRankTagListView", RFWLog.USR, "[bindData] medalInfos is null");
            TextView textView2 = this.E;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
        }
        if (arrayList.isEmpty()) {
            C0(isOwner);
        }
        QFSNewMedalHintView qFSNewMedalHintView = this.D;
        if (qFSNewMedalHintView != null && this.G) {
            qFSNewMedalHintView.setData(wVar.b().medalWall.get());
            this.D.k();
        }
        E0(arrayList, isOwner);
        o0();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.widget.BaseWidgetView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        QFSPersonalRankAchieveAnimWrapper qFSPersonalRankAchieveAnimWrapper = this.I;
        if (qFSPersonalRankAchieveAnimWrapper != null) {
            qFSPersonalRankAchieveAnimWrapper.m();
            com.tencent.biz.qqcircle.immersive.manager.e.a().removeElement(this.I);
        }
        QFSNewMedalHintView qFSNewMedalHintView = this.D;
        if (qFSNewMedalHintView != null) {
            qFSNewMedalHintView.h();
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        A0();
    }

    public void setOnQFSRankTagListActionListener(a aVar) {
        this.J = aVar;
    }

    public QFSRankTagListView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSRankTagListView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.F = false;
        this.G = false;
        u0(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
