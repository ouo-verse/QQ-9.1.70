package com.tencent.av.ui.virtual;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.business.manager.pendant.d;
import com.tencent.av.opengl.PtuSoLoader;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.av.opengl.effects.j;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.QavMenuBaseView;
import com.tencent.av.ui.QavPanel;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.t;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.HorizontalListView;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavVirtualMenuView extends QavMenuBaseView implements View.OnClickListener, iw.a {
    private d C;
    private t D;

    /* renamed from: h, reason: collision with root package name */
    private Button f76636h;

    /* renamed from: i, reason: collision with root package name */
    private HorizontalListView f76637i;

    /* renamed from: m, reason: collision with root package name */
    private QAVPtvTemplateAdapter f76638m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes3.dex */
    public class a implements View.OnTouchListener {
        a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            BaseToolbar.keepInToolbar(((QavMenuBaseView) QavVirtualMenuView.this).f75038e, -1051L);
            return false;
        }
    }

    public QavVirtualMenuView(Context context) {
        this(context, null);
    }

    private void k(Context context) {
        this.f75037d = "QavVirtualMenuView_" + e.d();
        setGravity(80);
        View inflate = LayoutInflater.from(context).inflate(R.layout.f168484fu2, this);
        inflate.setOnTouchListener(new a());
        Button button = (Button) inflate.findViewById(R.id.g6j);
        this.f76636h = button;
        button.setOnClickListener(this);
        this.f76637i = (HorizontalListView) inflate.findViewById(R.id.d9m);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void a(QavPanel qavPanel) {
        super.a(qavPanel);
        if (this.f75038e != null) {
            Context context = getContext();
            d dVar = (d) this.f75038e.B(14);
            this.C = dVar;
            t tVar = new t(5, dVar);
            this.D = tVar;
            QAVPtvTemplateAdapter qAVPtvTemplateAdapter = new QAVPtvTemplateAdapter(this.f75038e, context, tVar.b(getContext()), this.f76637i);
            this.f76638m = qAVPtvTemplateAdapter;
            this.D.f(qAVPtvTemplateAdapter);
            this.f76638m.m(true);
            this.f76638m.j(this);
            this.f76638m.k(this.D);
            this.f76637i.setAdapter((ListAdapter) this.f76638m);
            d dVar2 = this.C;
            if (dVar2 != null) {
                dVar2.p(0L, this.D);
            }
        }
        if (PtuSoLoader.soloadedPTV) {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.av.ui.virtual.QavVirtualMenuView.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.D() && AEFilterSupport.e() > 3) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        QLog.i(((QavMenuBaseView) QavVirtualMenuView.this).f75037d, 1, "preload PTHumanSegmenter, cost[" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "]");
                    }
                }
            }, 16, null, false);
        }
    }

    @Override // iw.a
    public void b(long j3, QavListItemBase.c cVar) {
        d dVar;
        BaseToolbar.keepInToolbar(this.f75038e, j3);
        if (cVar != null && !TextUtils.equals("-1", cVar.f75024a)) {
            PendantItem pendantItem = null;
            if (TextUtils.equals("0", cVar.f75024a)) {
                d dVar2 = this.C;
                if (dVar2 != null) {
                    dVar2.L(j3, null);
                }
                if (this.f75038e.Y(13)) {
                    ((gu.a) this.f75038e.B(13)).b0(j3, "onEffectClick_vb");
                    return;
                }
                return;
            }
            d dVar3 = this.C;
            if (dVar3 != null) {
                pendantItem = dVar3.w(cVar.f75024a);
            }
            if (pendantItem != null && !TextUtils.isEmpty(pendantItem.getId()) && (dVar = this.C) != null) {
                dVar.L(j3, pendantItem);
            }
            AVUtil.r("0X800AF86", AVUtil.h(), 0, String.valueOf(cVar.f75024a), "", "", "");
        }
    }

    @Override // iw.a
    public void c(long j3) {
        BaseToolbar.keepInToolbar(this.f75038e, j3);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void e(long j3) {
        d dVar = this.C;
        if (dVar != null) {
            dVar.J(j3, this.D);
        }
        super.e(j3);
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void g(long j3, boolean z16) {
        super.g(j3, z16);
        if (z16) {
            h();
        }
    }

    @Override // com.tencent.av.ui.QavMenuBaseView
    public void h() {
        String str;
        PendantItem u16;
        super.h();
        if (this.f76638m != null) {
            d dVar = this.C;
            if (dVar == null || (u16 = dVar.u()) == null) {
                str = "0";
            } else {
                str = u16.getId();
            }
            ArrayList<QavListItemBase.c> b16 = this.D.b(getContext());
            this.f76638m.s(b16);
            int i3 = 0;
            int i16 = -1;
            while (b16 != null && i3 < b16.size()) {
                QavListItemBase.c cVar = b16.get(i3);
                if (cVar != null) {
                    if (TextUtils.equals("0", cVar.f75024a)) {
                        i16 = i3;
                    }
                    if (TextUtils.equals(str, cVar.f75024a)) {
                        break;
                    }
                }
                i3++;
            }
            i3 = -1;
            if (i3 == -1) {
                d dVar2 = this.C;
                if (dVar2 != null) {
                    dVar2.L(0L, null);
                }
                i3 = i16;
            }
            if (QLog.isDevelopLevel()) {
                QLog.i(this.f75037d, 4, "refreshUI, curSelItemId[" + str + "], curSelItemIndex[" + i3 + "], curDefaultIndex[" + i16 + "]");
            }
            BaseToolbar.setSelectedListViewItemAndShow(this.f76637i, this.f76638m, i3);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        QavPanel qavPanel;
        EventCollector.getInstance().onViewClickedBefore(view);
        long d16 = e.d();
        if (view == this.f76636h && (qavPanel = this.f75039f) != null) {
            qavPanel.X0(d16, 0, true);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public QavVirtualMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QavVirtualMenuView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.C = null;
        this.D = null;
        k(context);
    }

    @Override // iw.a
    public void d(QavListItemBase.c cVar) {
    }
}
