package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class GifTemplatePicker extends RDBaseListLayout<a, c> implements View.OnClickListener, com.tencent.mobileqq.scribble.b {

    /* loaded from: classes10.dex */
    public static class a extends com.tencent.mobileqq.activity.aio.doodle.control.a {

        /* renamed from: b, reason: collision with root package name */
        public int f178525b;

        /* renamed from: c, reason: collision with root package name */
        public int f178526c;

        public a(int i3, int i16) {
            this.f178526c = i3;
            this.f178525b = i16;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f178526c != aVar.f178526c || this.f178525b != aVar.f178525b) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public interface b {
    }

    /* loaded from: classes10.dex */
    public static class c extends d61.a {

        /* renamed from: b, reason: collision with root package name */
        public ImageView f178527b;

        /* renamed from: c, reason: collision with root package name */
        public View f178528c;
    }

    public GifTemplatePicker(Context context) {
        super(context);
        k(1);
    }

    private void r(boolean z16) {
        d(new a(R.drawable.c0d, 0), false);
        List<Integer> f16 = DoodleResHelper.k().f(1);
        if (f16 == null) {
            return;
        }
        for (Integer num : f16) {
            if (!DoodleResHelper.k().m(1, num.intValue())) {
                if (z16) {
                    DoodleResHelper.k().q(1, num.intValue(), this, this);
                }
            } else {
                d(new a(num.intValue(), 1), false);
            }
        }
    }

    @Override // com.tencent.mobileqq.scribble.b
    public void b(View view, int i3, com.tencent.mobileqq.scribble.c cVar, int i16) {
        if (i3 == 4) {
            if (1 == i16) {
                p(false);
                r(false);
                q();
            } else if (4 != i16) {
                QLog.d("GifTemplatePicker", 2, "ScribbleResMgr down error:" + i16);
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    public boolean m() {
        r(true);
        q();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int h16 = h(view);
        e(h16, false);
        a g16 = g(h16);
        if (g16 != null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            if (1 == g16.f178525b) {
                ReportController.o(waitAppRuntime, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, g16.f178526c, "", "", "", "");
            } else {
                ReportController.o(waitAppRuntime, "dc00898", "", "", "0X80081B4", "0X80081B4", 1, 0, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public c l(int i3, a aVar) {
        Drawable drawable;
        c cVar = new c();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setOnClickListener(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(Utils.n(50.0f, getResources()), Utils.n(37.0f, getResources())));
        cVar.b(relativeLayout);
        cVar.f178527b = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.n(40.0f, getResources()), Utils.n(27.0f, getResources()));
        int n3 = Utils.n(5.0f, getResources());
        layoutParams.leftMargin = n3;
        layoutParams.topMargin = n3;
        cVar.f178527b.setLayoutParams(layoutParams);
        int i16 = aVar.f178525b;
        if (i16 == 1) {
            drawable = DoodleResHelper.k().h(1, aVar.f178526c);
        } else if (i16 == 0) {
            drawable = getContext().getResources().getDrawable(aVar.f178526c);
        } else {
            drawable = null;
        }
        cVar.f178527b.setOnClickListener(this);
        cVar.f178527b.setImageDrawable(drawable);
        relativeLayout.addView(cVar.f178527b);
        View view = new View(getContext());
        cVar.f178528c = view;
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        cVar.f178528c.setBackgroundColor(-1427313428);
        cVar.f178528c.setClickable(false);
        relativeLayout.addView(cVar.f178528c, 0);
        return cVar;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void o(int i3, a aVar, c cVar) {
        Drawable drawable;
        String str;
        if (cVar.f178527b != null) {
            int i16 = aVar.f178525b;
            if (i16 == 1) {
                drawable = DoodleResHelper.k().h(1, aVar.f178526c);
            } else if (i16 == 0) {
                drawable = getContext().getResources().getDrawable(aVar.f178526c);
            } else {
                drawable = null;
            }
            cVar.f178527b.setImageDrawable(drawable);
            if (AppSetting.f99565y) {
                if (i3 == 0) {
                    str = HardCodeUtil.qqStr(R.string.n2r);
                } else {
                    str = HardCodeUtil.qqStr(R.string.n2q) + i3;
                }
                cVar.f178527b.setContentDescription(str);
            }
        }
        if (cVar.f178528c != null) {
            if (aVar.a()) {
                cVar.f178528c.setVisibility(0);
            } else {
                cVar.f178528c.setVisibility(8);
            }
        }
    }

    public GifTemplatePicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        k(1);
    }

    public GifTemplatePicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        k(1);
    }

    public void setListener(b bVar) {
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void n(int i3, a aVar) {
    }
}
