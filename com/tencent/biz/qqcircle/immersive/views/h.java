package com.tencent.biz.qqcircle.immersive.views;

import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.qqcircle.beans.QCircleTabInfo;
import com.tencent.biz.qqcircle.immersive.viewmodel.newbarrage.widgets.QFSGradientTextView;
import com.tencent.biz.qqcircle.richframework.widget.TabLayoutCompat;
import com.tencent.biz.qqcircle.richframework.widget.drag.DragTextView;
import com.tencent.biz.qqcircle.utils.QFSQUIUtilsKt;
import com.tencent.biz.qqcircle.widgets.QFSRichImageView;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.helpers.QCircleSkinHelper;
import qqcircle.QQCircleFeedBase$StTopTabIconInfo;

/* compiled from: P */
/* loaded from: classes4.dex */
public class h {

    /* renamed from: a, reason: collision with root package name */
    private final FrameLayout f90771a;

    /* renamed from: b, reason: collision with root package name */
    private final QFSGradientTextView f90772b;

    /* renamed from: c, reason: collision with root package name */
    private final View f90773c;

    /* renamed from: d, reason: collision with root package name */
    private final ImageView f90774d;

    /* renamed from: e, reason: collision with root package name */
    private final ViewStub f90775e;

    /* renamed from: f, reason: collision with root package name */
    private QFSRichImageView f90776f;

    /* renamed from: g, reason: collision with root package name */
    private DragTextView f90777g;

    public h(ViewGroup viewGroup) {
        FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.gc8, viewGroup, false);
        this.f90771a = frameLayout;
        this.f90772b = (QFSGradientTextView) frameLayout.findViewById(android.R.id.text1);
        this.f90775e = (ViewStub) frameLayout.findViewById(R.id.f54812g8);
        this.f90773c = frameLayout.findViewById(R.id.vg_);
        this.f90774d = (ImageView) frameLayout.findViewById(R.id.ztw);
        this.f90777g = (DragTextView) frameLayout.findViewById(R.id.f110576iw);
    }

    private void o() {
        if (this.f90776f != null) {
            return;
        }
        QFSRichImageView qFSRichImageView = (QFSRichImageView) this.f90775e.inflate();
        this.f90776f = qFSRichImageView;
        qFSRichImageView.setAdjustViewBounds(true);
    }

    public View a() {
        return this.f90771a;
    }

    public QFSGradientTextView b() {
        return this.f90772b;
    }

    public void c() {
        QLog.d("QCircleFolderTabView", 2, "hideNewTips");
        this.f90774d.setVisibility(8);
    }

    public void d() {
        this.f90777g.setVisibility(8);
    }

    public void e() {
        View view = this.f90773c;
        if (view == null) {
            return;
        }
        view.setVisibility(8);
    }

    public void f(TabLayoutCompat tabLayoutCompat, boolean z16) {
        int d16;
        QFSRichImageView qFSRichImageView = this.f90776f;
        if (qFSRichImageView != null && tabLayoutCompat != null) {
            if (z16) {
                qFSRichImageView.setColorMode(1);
                if (this.f90776f.isSelected()) {
                    d16 = QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_brand_standard);
                } else {
                    d16 = QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_text_primary);
                }
                this.f90776f.setImageViewColorFilter(Integer.valueOf(d16));
                this.f90776f.e0();
                tabLayoutCompat.setSelectedIndicatorNoShadowLayer();
            } else {
                qFSRichImageView.setColorMode(2);
                this.f90776f.setImageViewColorFilter(null);
                this.f90776f.e0();
                tabLayoutCompat.setSelectedIndicatorShadowLayer(6.0f, 0.0f, 3.0f, QCircleSkinHelper.getInstance().getColor(R.color.cko));
            }
            QLog.d("QCircleFolderTabView", 1, "[onEnableSkinChanged] tab image: " + this.f90776f.Z().f93412a + " | selected: " + this.f90776f.isSelected());
        }
    }

    public void g(TabLayoutCompat tabLayoutCompat, boolean z16) {
        QFSGradientTextView qFSGradientTextView = this.f90772b;
        if (qFSGradientTextView == null && this.f90776f == null) {
            return;
        }
        if (qFSGradientTextView != null && this.f90776f == null) {
            h(tabLayoutCompat, z16);
        } else {
            f(tabLayoutCompat, z16);
        }
    }

    public void h(TabLayoutCompat tabLayoutCompat, boolean z16) {
        ColorStateList colorStateList;
        int color;
        Typeface defaultFromStyle;
        QFSGradientTextView qFSGradientTextView = this.f90772b;
        if (qFSGradientTextView != null && tabLayoutCompat != null) {
            if (z16) {
                if (qFSGradientTextView.isSelected()) {
                    colorStateList = RFWApplication.getApplication().getResources().getColorStateList(R.color.qui_common_brand_standard);
                } else {
                    colorStateList = RFWApplication.getApplication().getResources().getColorStateList(R.color.qui_common_text_primary);
                }
                color = QFSQUIUtilsKt.d(RFWApplication.getApplication(), R.color.qui_common_brand_standard);
                tabLayoutCompat.setSelectedIndicatorNoShadowLayer();
            } else {
                colorStateList = RFWApplication.getApplication().getResources().getColorStateList(R.color.f157876cm4);
                color = RFWApplication.getApplication().getResources().getColor(R.color.cla);
                tabLayoutCompat.setSelectedIndicatorShadowLayer(6.0f, 0.0f, 3.0f, QCircleSkinHelper.getInstance().getColor(R.color.cko));
            }
            QLog.d("QCircleFolderTabView", 1, "[onEnableSkinChanged] tab text: " + ((Object) this.f90772b.getText()) + " | selected: " + this.f90772b.isSelected());
            this.f90772b.setTextColor(colorStateList);
            QFSGradientTextView qFSGradientTextView2 = this.f90772b;
            if (qFSGradientTextView2.isSelected()) {
                defaultFromStyle = Typeface.defaultFromStyle(1);
            } else {
                defaultFromStyle = Typeface.defaultFromStyle(0);
            }
            qFSGradientTextView2.setTypeface(defaultFromStyle);
            tabLayoutCompat.setSelectedTabIndicatorColor(color);
        }
    }

    public void i(boolean z16) {
        QFSRichImageView qFSRichImageView = this.f90776f;
        if (qFSRichImageView != null) {
            qFSRichImageView.setSelected(z16);
        }
        QFSGradientTextView qFSGradientTextView = this.f90772b;
        if (qFSGradientTextView != null) {
            qFSGradientTextView.setSelected(z16);
        }
    }

    public void j(QCircleTabInfo qCircleTabInfo) {
        QQCircleFeedBase$StTopTabIconInfo iconInfo = qCircleTabInfo.getIconInfo();
        if (iconInfo != null) {
            o();
            QFSRichImageView.b bVar = new QFSRichImageView.b();
            QFSRichImageView.a aVar = new QFSRichImageView.a();
            aVar.f93410a = iconInfo.darkIconSelectedUrl.get();
            aVar.f93411b = iconInfo.darkIconUrl.get();
            bVar.f93418g = aVar;
            bVar.f93412a = iconInfo.lightIconSelectedUrl.get();
            bVar.f93415d = iconInfo.lightIconUrl.get();
            bVar.f93417f = false;
            this.f90776f.setColorMode(2);
            this.f90776f.setIsWrapContent(true);
            this.f90776f.setRepeatTimes(1);
            this.f90776f.setResInfo(bVar);
            this.f90772b.setWidth(0);
        }
    }

    public void k() {
        QLog.d("QCircleFolderTabView", 2, "showNewTips");
        this.f90774d.setVisibility(0);
    }

    public void l(int i3) {
        this.f90777g.setVisibility(0);
        this.f90777g.setText(String.valueOf(i3));
    }

    public void m() {
        View view = this.f90773c;
        if (view == null) {
            return;
        }
        view.setVisibility(0);
    }

    public void n(boolean z16) {
        QFSGradientTextView qFSGradientTextView = this.f90772b;
        if (qFSGradientTextView == null) {
            return;
        }
        if (z16) {
            qFSGradientTextView.setShadowLayer(6.0f, 0.0f, 3.0f, QCircleSkinHelper.getInstance().getColor(R.color.cko));
        } else {
            qFSGradientTextView.setShadowLayer(0.0f, 0.0f, 0.0f, 0);
        }
    }

    public void p(String str) {
        QFSGradientTextView qFSGradientTextView = this.f90772b;
        if (qFSGradientTextView != null) {
            qFSGradientTextView.setText(str);
        }
    }
}
