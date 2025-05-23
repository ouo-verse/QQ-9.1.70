package com.tencent.mobileqq.filemanager.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qui.quiemptystate.QUIEmptyState;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes12.dex */
public class NoFileRelativeLayout extends RelativeLayout {
    private View.OnClickListener C;

    /* renamed from: d, reason: collision with root package name */
    TextView f209418d;

    /* renamed from: e, reason: collision with root package name */
    Context f209419e;

    /* renamed from: f, reason: collision with root package name */
    View f209420f;

    /* renamed from: h, reason: collision with root package name */
    LinearLayout f209421h;

    /* renamed from: i, reason: collision with root package name */
    int f209422i;

    /* renamed from: m, reason: collision with root package name */
    int f209423m;

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            ((ITeamWorkUtils) QRoute.api(ITeamWorkUtils.class)).jumpToTencentDocIndex((Activity) NoFileRelativeLayout.this.getContext(), ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_YINDAO, -1);
            ReportController.o(null, "dc00898", "", "", "0X800A226", "0X800A226", 0, 0, "", "", "", "");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public NoFileRelativeLayout(Context context) {
        this(context, null);
    }

    public void a() {
        this.f209418d.setVisibility(8);
    }

    public void b() {
        this.f209418d.setVisibility(0);
    }

    public void setGone() {
        this.f209421h.setVisibility(8);
        setVisibility(8);
    }

    public void setLayoutParams(int i3, int i16) {
        if (i3 > 0 && i16 > 20) {
            if (this.f209422i == i3 && this.f209423m == i16) {
                return;
            }
            this.f209422i = i3;
            this.f209423m = i16;
            this.f209421h.setLayoutParams(new RelativeLayout.LayoutParams(this.f209422i, this.f209423m - 20));
            this.f209421h.invalidate();
        }
    }

    public void setVisible(boolean z16) {
        if (z16) {
            this.f209421h.setVisibility(0);
            setVisibility(0);
        } else {
            this.f209421h.setVisibility(4);
            setVisibility(8);
        }
    }

    public NoFileRelativeLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NoFileRelativeLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f209421h = null;
        this.f209422i = 0;
        this.f209423m = 0;
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.alr, this);
        this.f209421h = (LinearLayout) inflate.findViewById(R.id.fa9);
        if (context instanceof Activity) {
            View decorView = ((Activity) context).getWindow().getDecorView();
            this.f209421h.setLayoutParams(new RelativeLayout.LayoutParams(decorView.getWidth(), decorView.getHeight() / 2));
        }
        ViewGroup viewGroup = (ViewGroup) inflate.findViewById(R.id.v7b);
        QUIEmptyState.Builder builder = new QUIEmptyState.Builder(getContext());
        builder.setImageType(2);
        builder.setTitle(HardCodeUtil.qqStr(R.string.f170932md));
        builder.setBackgroundColorType(0);
        builder.setAutoCenter(false);
        QUIEmptyState build = builder.build();
        this.f209420f = build;
        viewGroup.addView(build);
        this.f209418d = (TextView) inflate.findViewById(R.id.jfz);
        this.C = new a();
        ((ITeamWorkUtilsTemp) QRoute.api(ITeamWorkUtilsTemp.class)).configHistoryTabEmptyTips(this.f209418d, this.C);
        this.f209418d.setVisibility(8);
        this.f209419e = context;
    }

    public void setTopViewHeight(float f16) {
    }
}
