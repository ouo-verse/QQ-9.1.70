package com.tencent.av.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.ui.beauty.BeautySeekView;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.m;
import com.tencent.av.ui.operation.QavOperationBaseMenuView;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.DataReport;
import com.tencent.av.utils.av;
import com.tencent.av.utils.aw;
import com.tencent.av.utils.ba;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.profile.view.HScrollView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavOperationMenuView extends QavOperationBaseMenuView {
    ViewGroup C;
    BeautySeekView D;
    LinearLayout E;
    HScrollView F;
    long G;
    ImageView H;
    private boolean I;
    private long J;
    private final long K;
    private Rect L;
    private Rect M;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements BeautySeekView.c {
        a() {
        }

        @Override // com.tencent.av.ui.beauty.BeautySeekView.c
        public void a(String str, int i3, int i16) {
            if (i3 != 2) {
                if (i3 == 3) {
                    VideoAppInterface videoAppInterface = QavOperationMenuView.this.f75038e;
                    if (videoAppInterface != null) {
                        videoAppInterface.w0(str, i16, true);
                    }
                    DataReport.P(m.e.f76023j);
                    return;
                }
                return;
            }
            VideoAppInterface videoAppInterface2 = QavOperationMenuView.this.f75038e;
            if (videoAppInterface2 != null) {
                videoAppInterface2.w0(str, i16, false);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class b implements HScrollView.a {
        b() {
        }

        @Override // com.tencent.mobileqq.profile.view.HScrollView.a
        public void a(int i3) {
            long currentTimeMillis = System.currentTimeMillis();
            if (i3 == 1 && currentTimeMillis - QavOperationMenuView.this.J > 1000) {
                QavOperationMenuView.this.u();
            }
        }
    }

    public QavOperationMenuView(Context context) {
        this(context, null);
    }

    private void A() {
        if (this.H != null && com.tencent.av.opengl.effects.j.D() && AEFilterSupport.e() > 3) {
            this.H.setVisibility(0);
            return;
        }
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
    }

    private void C(rw.a aVar, View view) {
        int i3;
        int i16;
        view.setClickable(aVar.f());
        if (aVar.h()) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            int i17 = av.a.f77061b;
            int a16 = av.a(view, i17);
            int i18 = av.a.f77062c;
            int a17 = av.a(view, i18);
            textView.setTag(av.a.f77063d, null);
            if (aVar.g()) {
                i16 = R.color.amq;
            } else {
                i16 = R.color.f157463q4;
            }
            if (aVar.d() != a16 || i16 != a17) {
                textView.setTag(i17, Integer.valueOf(aVar.d()));
                textView.setTag(i18, Integer.valueOf(i16));
                com.tencent.av.utils.e.a(getResources(), textView, aVar.d(), i16, i16);
            }
            if (!StringUtil.isEmpty(aVar.e())) {
                textView.setText(aVar.e());
            }
            if (!TextUtils.isEmpty(aVar.a())) {
                textView.setContentDescription(aVar.a());
            }
            if (aVar.f432580e || aVar.f432579d == 0) {
                aVar.f432579d = (int) Math.max(ba.getMeasureTextWidth(textView), BaseAIOUtils.f(28.0f, getResources()));
                aVar.f432580e = false;
                if (QLog.isDevelopLevel()) {
                    QLog.i(this.f75037d, 2, "updateView, width[" + aVar.f432579d + "], title[" + aVar.e() + "]");
                }
            }
        }
    }

    private void l() {
        this.f75037d = "QavOperationMenuView_" + com.tencent.av.utils.e.d();
        setGravity(80);
        LayoutInflater.from(getContext()).inflate(R.layout.f168516yt, (ViewGroup) this, true);
        setBackgroundResource(R.drawable.hea);
        ViewGroup viewGroup = (ViewGroup) findViewById(R.id.f164590la0);
        this.C = viewGroup;
        this.D = (BeautySeekView) viewGroup.findViewById(R.id.a7n);
        if (f.d()) {
            this.D.l(getContext().getString(R.string.f1776934n), "BEAUTY_SKIN", 60, 0);
        } else {
            this.D.l(getContext().getString(R.string.iw_), "BEAUTY_SKIN", 50, 0);
        }
        this.D.setBeautySeekActionListener(new a());
        ImageView imageView = (ImageView) findViewById(R.id.la5);
        this.H = imageView;
        if (imageView != null) {
            Drawable drawable = getResources().getDrawable(R.drawable.hrf);
            aw a16 = aw.a(getResources(), R.drawable.hrf, R.color.amp);
            a16.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
            this.H.setImageDrawable(a16);
            this.H.setBackgroundDrawable(null);
            this.H.setOnClickListener(this);
        }
        A();
        this.E = (LinearLayout) findViewById(R.id.ff9);
        this.F = (HScrollView) findViewById(R.id.lye);
        z();
    }

    private void r(ArrayList<rw.a> arrayList, ArrayList<rw.a> arrayList2, int i3, int i16) {
        if (i3 >= 0 && i16 >= 0) {
            int i17 = 0;
            while (i3 <= i16 && i3 < arrayList2.size() && i17 < 6) {
                i17++;
                arrayList.add(arrayList2.get(i3));
                i3++;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean s(int i3) {
        LinearLayout linearLayout = this.E;
        boolean z16 = false;
        if (linearLayout == null) {
            return false;
        }
        int i16 = 0;
        while (true) {
            if (i16 >= linearLayout.getChildCount()) {
                break;
            }
            View childAt = linearLayout.getChildAt(i16);
            if (childAt != null && childAt.getId() == i3 && childAt.isShown()) {
                if (this.L == null) {
                    this.L = new Rect();
                }
                if (this.M == null) {
                    DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
                    this.M = new Rect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                childAt.getGlobalVisibleRect(this.L);
                z16 = this.L.intersect(this.M);
            } else {
                i16++;
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "checkOperationBtnIsVisible, ret[" + z16 + "], id[" + i3 + "]");
        }
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        if (!this.F.isShown()) {
            return;
        }
        this.J = System.currentTimeMillis();
        v(y(Math.abs(this.F.getScrollX())));
    }

    private void v(ArrayList<rw.a> arrayList) {
        if (QLog.isDevelopLevel()) {
            QLog.d(this.f75037d, 4, "doRealReport, size:=[" + arrayList.size() + "]");
        }
        Iterator<rw.a> it = arrayList.iterator();
        while (it.hasNext()) {
            AVUtil.r("0X800BC09", DataReport.v(com.tencent.av.n.e().f()), it.next().c(), "", "", "", "");
        }
    }

    private ArrayList<rw.a> y(int i3) {
        int i16;
        int measuredWidth = this.F.getChildAt(0).getMeasuredWidth();
        int screenWidth = ba.getScreenWidth(getContext());
        ArrayList<rw.a> d16 = this.f76180h.d();
        ArrayList<rw.a> arrayList = new ArrayList<>();
        if (i3 != 0 && d16.size() > 5 && measuredWidth > screenWidth) {
            int i17 = 0;
            int i18 = 0;
            for (int i19 = 0; i19 < d16.size() && i17 <= 5; i19++) {
                rw.a aVar = d16.get(i19);
                if (aVar.h()) {
                    if (i17 != 5) {
                        i16 = aVar.f432579d;
                    } else {
                        i16 = aVar.f432579d / 2;
                    }
                    i18 += i16;
                    i17++;
                }
            }
            int i26 = (int) (((screenWidth - i18) * 1.0f) / 5.5f);
            int i27 = 0;
            int i28 = 0;
            while (true) {
                if (i27 < d16.size()) {
                    i28 += d16.get(i27).f432579d + i26;
                    if (i28 > i3) {
                        break;
                    }
                    i27++;
                } else {
                    i27 = 0;
                    break;
                }
            }
            int i29 = screenWidth - (i28 - i3);
            int i36 = 0;
            int i37 = i27 + 1;
            int i38 = 0;
            while (i27 >= 0 && i37 < d16.size()) {
                i38 += (d16.get(i37).f432579d / 2) + i26;
                if (i38 > i29) {
                    break;
                }
                i36 = i37;
                i37++;
            }
            i37 = i36;
            if (QLog.isDevelopLevel()) {
                QLog.d(this.f75037d, 4, "doRealReport, startPos:=[" + i27 + "], endPos:=" + i37 + ", expireLength:=" + i29);
            }
            r(arrayList, d16, i27, i37);
            return arrayList;
        }
        r(arrayList, d16, 0, 4);
        return arrayList;
    }

    private void z() {
        this.F.setOnScrollListener(new b());
    }

    void B(int i3) {
        BeautySeekView beautySeekView = this.D;
        if (beautySeekView != null) {
            beautySeekView.m(i3);
        }
    }

    @Override // com.tencent.av.ui.operation.QavOperationBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void a(QavPanel qavPanel) {
        super.a(qavPanel);
        VideoAppInterface videoAppInterface = this.f75038e;
        if (videoAppInterface != null) {
            B(videoAppInterface.z("BEAUTY_SKIN"));
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (action != 2 || Math.abs(elapsedRealtime - this.G) > 200) {
            this.G = elapsedRealtime;
            BaseToolbar.keepInToolbar(this.f75038e, -1029L);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.tencent.av.ui.operation.QavOperationBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void f(long j3, boolean z16) {
        super.f(j3, z16);
        if (z16) {
            this.I = false;
            if (QLog.isDevelopLevel()) {
                QLog.i(this.f75037d, 2, "onHide");
            }
        }
    }

    @Override // com.tencent.av.ui.operation.QavOperationBaseMenuView, com.tencent.av.ui.QavMenuBaseView
    public void g(long j3, boolean z16) {
        super.g(j3, z16);
        if (z16) {
            B(this.f75038e.z("BEAUTY_SKIN"));
            h();
            postDelayed(new Runnable() { // from class: com.tencent.av.ui.QavOperationMenuView.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!QavOperationMenuView.this.I) {
                        if (QavOperationMenuView.this.s(m.e.f76025l)) {
                            AVUtil.r("0X800AF84", AVUtil.h(), 0, "", "", "", "");
                            QavOperationMenuView.this.I = true;
                        }
                        QavOperationMenuView.this.u();
                    }
                }
            }, 100L);
        }
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    @SuppressLint({"ResourceType"})
    public void h() {
        boolean z16;
        int i3;
        boolean z17;
        int i16;
        int i17;
        int i18;
        rw.a next;
        View x16;
        super.h();
        if (this.D != null) {
            rw.c cVar = this.f76180h;
            if (cVar != null && cVar.e()) {
                this.C.setVisibility(0);
                this.D.F = true;
                A();
                ImageView imageView = this.H;
                if (imageView != null && imageView.getVisibility() == 0) {
                    RedTouch[] redTouchArr = this.f76181i;
                    if (redTouchArr[2] == null) {
                        redTouchArr[2] = yv.a.h(this.f75038e, this.H, 7);
                    }
                }
            } else {
                this.C.setVisibility(8);
            }
        }
        if (this.E != null) {
            rw.c cVar2 = this.f76180h;
            if (cVar2 != null && cVar2.b().size() != 0) {
                Iterator<rw.a> it = this.f76180h.b().iterator();
                int i19 = 0;
                int i26 = 0;
                while (it.hasNext() && (x16 = x(i19, (next = it.next()))) != null) {
                    int id5 = x16.getId();
                    int j3 = j(id5);
                    if (j3 >= 0) {
                        RedTouch[] redTouchArr2 = this.f76181i;
                        if (j3 < redTouchArr2.length) {
                            redTouchArr2[j3] = i(x16, id5, k(id5));
                        }
                    }
                    C(next, x16);
                    i19++;
                    if (next.h() && com.tencent.av.utils.e.e(0) == 1) {
                        if (i26 % 2 == 0) {
                            x16.setBackgroundColor(-536881408);
                        } else {
                            x16.setBackgroundColor(-539173668);
                        }
                        i26++;
                    }
                }
                int childCount = this.E.getChildCount();
                if (childCount > i19) {
                    this.E.removeViews(i19, childCount - i19);
                }
                rw.c cVar3 = this.f76180h;
                if (cVar3 != null) {
                    ArrayList<rw.a> d16 = cVar3.d();
                    int size = d16.size();
                    int childCount2 = this.E.getChildCount();
                    if (size <= 5) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    int screenWidth = ImmersiveUtils.getScreenWidth();
                    if (z16) {
                        i3 = screenWidth / size;
                    } else {
                        i3 = (int) ((screenWidth * 1.0f) / 5.5f);
                    }
                    if (!z16) {
                        int i27 = 0;
                        int i28 = 0;
                        for (int i29 = 0; i29 < d16.size() && i27 <= 5; i29++) {
                            rw.a aVar = d16.get(i29);
                            if (aVar.h()) {
                                if (i27 != 5) {
                                    i18 = aVar.f432579d;
                                } else {
                                    i18 = aVar.f432579d / 2;
                                }
                                i28 += i18;
                                i27++;
                            }
                        }
                        if (screenWidth > i28) {
                            i3 = (int) (((screenWidth - i28) * 1.0f) / 5.5f);
                        } else {
                            i3 = 0;
                        }
                    } else {
                        ReportController.o(null, "CliOper", "", "", "0X800A342", "0X800A342", 0, 0, "", "", "", "");
                    }
                    if ((i3 & 1) != 0) {
                        i3++;
                    }
                    int i36 = 0;
                    for (int i37 = 0; i37 < childCount2 && i36 < d16.size(); i37++) {
                        View childAt = this.E.getChildAt(i37);
                        if (childAt != null && childAt.getVisibility() == 0) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        if (z17) {
                            if (z16) {
                                i16 = i36;
                                i17 = i3;
                            } else {
                                i16 = i36 + 1;
                                i17 = d16.get(i36).f432579d + i3;
                            }
                            childAt.setLayoutParams(new LinearLayout.LayoutParams(i17, -2));
                            i36 = i16;
                        }
                    }
                }
                this.E.requestLayout();
                return;
            }
            this.E.removeAllViewsInLayout();
        }
    }

    @Override // com.tencent.av.ui.operation.QavOperationBaseMenuView, android.view.View.OnClickListener
    @SuppressLint({"ResourceType"})
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        int id5 = view.getId();
        if (id5 == R.id.la5) {
            u uVar = this.f76182m;
            if (uVar != null) {
                uVar.b(this, 3);
            }
            AVUtil.a("0X800A566", 0);
        } else {
            u uVar2 = this.f76182m;
            if (uVar2 != null) {
                uVar2.a(this, view);
            }
        }
        int j3 = j(id5);
        int k3 = k(id5);
        if (j3 >= 0) {
            RedTouch[] redTouchArr = this.f76181i;
            if (j3 < redTouchArr.length) {
                RedTouch redTouch = redTouchArr[j3];
                if (redTouch != null) {
                    yv.a.b(this.f75038e, redTouch, k3);
                }
                this.f76181i[j3] = null;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    View t(rw.a aVar) {
        if (aVar == null) {
            return null;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.weight = 1.0f;
        Button button = new Button(getContext());
        button.setLayoutParams(layoutParams);
        button.setSingleLine();
        com.tencent.av.utils.e.a(getResources(), button, aVar.d(), R.color.f157463q4, R.color.f157463q4);
        if (!StringUtil.isEmpty(aVar.e())) {
            button.setText(aVar.e());
        }
        button.setBackgroundColor(0);
        button.setId(aVar.b());
        button.setOnClickListener(this);
        button.setTag(av.a.f77060a, aVar);
        button.setTextSize(ViewUtils.pxTosp(BaseAIOUtils.f(12.0f, getResources())));
        button.setCompoundDrawablePadding(BaseAIOUtils.f(8.0f, getResources()));
        float measureTextWidth = ba.getMeasureTextWidth(button);
        aVar.f432579d = (int) Math.max(measureTextWidth, BaseAIOUtils.f(28.0f, getResources()));
        aVar.f432580e = false;
        if (QLog.isDevelopLevel()) {
            QLog.i(this.f75037d, 4, "createOperationBtn, title[" + aVar.e() + "], titleTxtWidth[" + measureTextWidth + "], width[" + aVar.f432579d + "]");
        }
        return button;
    }

    public View w(rw.a aVar) {
        if (aVar == null || this.E == null) {
            return null;
        }
        for (int i3 = 0; i3 < this.E.getChildCount(); i3++) {
            View childAt = this.E.getChildAt(i3);
            rw.a aVar2 = (rw.a) childAt.getTag(av.a.f77060a);
            if (aVar2 != null && aVar2.b() == aVar.b()) {
                return childAt;
            }
        }
        return null;
    }

    View x(int i3, rw.a aVar) {
        LinearLayout linearLayout = this.E;
        if (linearLayout != null && i3 >= 0) {
            if (linearLayout.getChildCount() <= i3) {
                View t16 = t(aVar);
                this.E.addView(t16, i3);
                return t16;
            }
            View childAt = this.E.getChildAt(i3);
            rw.a aVar2 = (rw.a) childAt.getTag(av.a.f77060a);
            if (aVar2 != null && aVar2.b() == aVar.b()) {
                return childAt;
            }
            View t17 = t(aVar);
            this.E.addView(t17, i3);
            return t17;
        }
        return null;
    }

    public QavOperationMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavOperationMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = null;
        this.D = null;
        this.E = null;
        this.G = 0L;
        this.H = null;
        this.I = false;
        this.J = 0L;
        this.K = 1000L;
        this.L = null;
        this.M = null;
        l();
    }
}
