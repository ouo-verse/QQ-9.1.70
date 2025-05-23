package com.tencent.mobileqq.filemanager.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qui.quiblurview.QQBlurView;
import com.tencent.widget.ListView;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QFileSendBottomView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name */
    private QQBlurView f209442d;

    /* renamed from: e, reason: collision with root package name */
    private ListView f209443e;

    /* renamed from: f, reason: collision with root package name */
    private RelativeLayout f209444f;

    public QFileSendBottomView(Context context) {
        super(context, null);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.alz, this);
        c();
    }

    private void c() {
        this.f209444f = (RelativeLayout) findViewById(R.id.imz);
    }

    public void a(ListView listView) {
        this.f209443e = listView;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.addView(new View(getContext()), new RelativeLayout.LayoutParams(-1, BaseAIOUtils.f(50.0f, getResources())));
        listView.addFooterView(relativeLayout);
        d();
    }

    public View b(int i3) {
        return findViewById(i3);
    }

    protected void d() {
        QQBlurView qQBlurView = this.f209442d;
        if (qQBlurView != null) {
            qQBlurView.onDestroy();
            this.f209442d = null;
        }
        if (!ThemeUtil.isDefaultOrDIYTheme(false)) {
            this.f209444f.setBackgroundResource(R.drawable.qfile_file_activity_div);
            return;
        }
        QQBlurView qQBlurView2 = (QQBlurView) findViewById(R.id.kmg);
        this.f209442d = qQBlurView2;
        qQBlurView2.setVisibility(0);
        this.f209442d.j(this.f209443e);
        QQBlurView qQBlurView3 = this.f209442d;
        qQBlurView3.m(qQBlurView3);
        this.f209442d.p(-1);
        this.f209442d.z(new ColorDrawable(Color.parseColor("#E5EBEDF5")));
        this.f209442d.k(0);
        this.f209442d.A(8.0f);
        this.f209442d.l(8);
        this.f209442d.x();
        this.f209442d.onResume();
    }

    public QFileSendBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.alz, (ViewGroup) this, true);
        c();
    }
}
