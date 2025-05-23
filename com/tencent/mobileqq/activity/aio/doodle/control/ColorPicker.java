package com.tencent.mobileqq.activity.aio.doodle.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.activity.aio.doodle.control.ColorView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* loaded from: classes10.dex */
public class ColorPicker extends RDBaseListLayout<b, d> implements View.OnClickListener, com.tencent.mobileqq.scribble.b {

    /* renamed from: m, reason: collision with root package name */
    private final int[] f178511m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements ColorView.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ d f178512a;

        a(d dVar) {
            this.f178512a = dVar;
        }

        @Override // com.tencent.mobileqq.activity.aio.doodle.control.ColorView.b
        public void onClick() {
            ColorPicker.this.onClick(this.f178512a.f178517b);
        }
    }

    /* loaded from: classes10.dex */
    public static class b extends com.tencent.mobileqq.activity.aio.doodle.control.a {

        /* renamed from: b, reason: collision with root package name */
        public int f178514b;

        /* renamed from: c, reason: collision with root package name */
        public int f178515c;

        /* renamed from: d, reason: collision with root package name */
        public int f178516d;

        public b(int i3, int i16, int i17) {
            this.f178514b = i3;
            this.f178515c = i16;
            this.f178516d = i17;
        }

        public boolean equals(Object obj) {
            if (obj == null || !(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f178514b != bVar.f178514b || this.f178516d != bVar.f178516d || this.f178515c != bVar.f178515c) {
                return false;
            }
            return true;
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
    }

    /* loaded from: classes10.dex */
    public static class d extends d61.a {

        /* renamed from: b, reason: collision with root package name */
        ColorView f178517b;

        /* renamed from: c, reason: collision with root package name */
        ImageView f178518c;
    }

    public ColorPicker(Context context) {
        super(context);
        this.f178511m = new int[]{-16777216, -5789785, -845543, -27392, -274353, -10233288, -9576193, -6989057};
        k(1);
    }

    private void r() {
        int i3 = 0;
        while (true) {
            int[] iArr = this.f178511m;
            if (i3 < iArr.length) {
                d(new b(0, -1, iArr[i3]), false);
                i3++;
            } else {
                return;
            }
        }
    }

    private void s() {
        List<Integer> f16 = DoodleResHelper.k().f(0);
        if (f16 == null) {
            return;
        }
        for (Integer num : f16) {
            if (!DoodleResHelper.k().n(0, num.intValue())) {
                DoodleResHelper.k().q(0, num.intValue(), this, this);
                DoodleResHelper.k().p(0, num.intValue(), this, this);
            } else {
                d(new b(1, num.intValue(), -1), false);
            }
        }
    }

    public static String t(int i3) {
        switch (i3) {
            case -16777216:
                return HardCodeUtil.qqStr(R.string.ksk);
            case -13338378:
            case -9576193:
                return HardCodeUtil.qqStr(R.string.ksi);
            case -10233288:
            case -8136876:
                return HardCodeUtil.qqStr(R.string.ksh);
            case -6989057:
                return HardCodeUtil.qqStr(R.string.ksd);
            case -5789785:
                return HardCodeUtil.qqStr(R.string.ksc);
            case -2148308:
            case -845543:
                return HardCodeUtil.qqStr(R.string.ksg);
            case -1009097:
            case -27392:
                return HardCodeUtil.qqStr(R.string.ksj);
            case -274353:
                return HardCodeUtil.qqStr(R.string.ksb);
            case -1:
                return HardCodeUtil.qqStr(R.string.kse);
            default:
                return "";
        }
    }

    @Override // com.tencent.mobileqq.scribble.b
    public void b(View view, int i3, com.tencent.mobileqq.scribble.c cVar, int i16) {
        if (i3 == 3) {
            if (1 == i16) {
                p(false);
                m();
                return;
            } else {
                if (4 != i16) {
                    QLog.d("ColorPicker", 2, "ScribbleResMgr down error:" + i16);
                    return;
                }
                return;
            }
        }
        if (i3 == 1 && 1 == i16) {
            q();
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    public boolean m() {
        s();
        r();
        return true;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int h16 = h(view);
        e(h16, false);
        b g16 = g(h16);
        if (g16 != null) {
            AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
            int i3 = g16.f178514b;
            if (1 == i3) {
                ReportController.o(waitAppRuntime, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, g16.f178515c, "", "", "", "");
            } else if (i3 == 0) {
                ReportController.o(waitAppRuntime, "dc00898", "", "", "0X80081BA", "0X80081BA", 1, g16.f178516d, "", "", "", "");
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public d l(int i3, b bVar) {
        d dVar = new d();
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(Utils.n(32.0f, getResources()), -1));
        int n3 = Utils.n(4.0f, getResources());
        int n16 = Utils.n(9.5f, getResources());
        relativeLayout.setPadding(n3, n16, n3, n16);
        dVar.b(relativeLayout);
        relativeLayout.setOnClickListener(this);
        dVar.f178518c = new ImageView(getContext());
        dVar.f178518c.setBackgroundDrawable(getContext().getResources().getDrawable(R.drawable.c0b));
        dVar.f178518c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        if (bVar.a()) {
            dVar.f178518c.setVisibility(0);
        } else {
            dVar.f178518c.setVisibility(4);
        }
        dVar.f178517b = new ColorView(getContext(), null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Utils.n(18.0f, getResources()), Utils.n(18.0f, getResources()));
        int n17 = Utils.n(3.0f, getResources());
        layoutParams.setMargins(n17, n17, n17, n17);
        ((RelativeLayout) dVar.a()).addView(dVar.f178517b);
        relativeLayout.addView(dVar.f178518c);
        dVar.f178517b.setListener(new a(dVar));
        dVar.f178517b.setLayoutParams(layoutParams);
        if (bVar.f178514b == 0) {
            dVar.f178517b.setColor(bVar.f178516d);
        } else {
            dVar.f178517b.setBtmap(DoodleResHelper.k().g(0, bVar.f178515c));
        }
        return dVar;
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void o(int i3, b bVar, d dVar) {
        String str;
        if (dVar != null && bVar != null) {
            int i16 = bVar.f178514b;
            if (i16 == 0) {
                dVar.f178517b.setColor(bVar.f178516d);
                str = t(bVar.f178516d);
            } else if (i16 == 1) {
                dVar.f178517b.setBtmap(DoodleResHelper.k().g(0, bVar.f178515c));
                str = HardCodeUtil.qqStr(R.string.ksf) + (i3 + 1);
            } else {
                str = "";
            }
            if (dVar.f178518c != null) {
                if (bVar.a()) {
                    dVar.f178518c.setVisibility(0);
                } else {
                    dVar.f178518c.setVisibility(4);
                }
            }
            if (AppSetting.f99565y) {
                dVar.f178517b.setContentDescription(str);
            }
        }
    }

    public ColorPicker(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f178511m = new int[]{-16777216, -5789785, -845543, -27392, -274353, -10233288, -9576193, -6989057};
        k(1);
    }

    public ColorPicker(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f178511m = new int[]{-16777216, -5789785, -845543, -27392, -274353, -10233288, -9576193, -6989057};
        k(1);
    }

    public void setListener(c cVar) {
    }

    @Override // com.tencent.mobileqq.activity.aio.doodle.control.RDBaseListLayout
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public void n(int i3, b bVar) {
    }
}
