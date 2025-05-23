package com.tencent.av.ui.beauty;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.av.ui.QAVPtvTemplateAdapter;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.effect.toolbar.BaseToolbar;
import com.tencent.av.ui.t;
import com.tencent.av.utils.AVUtil;
import com.tencent.av.utils.e;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import iw.a;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class MakeupView extends BeautyBaseView implements a {
    QAVPtvTemplateAdapter C;
    gu.a D;
    String E;
    int F;
    t G;

    /* renamed from: f, reason: collision with root package name */
    final ArrayList<QavListItemBase.c> f75447f;

    /* renamed from: h, reason: collision with root package name */
    final TextView f75448h;

    /* renamed from: i, reason: collision with root package name */
    final BeautySeekView f75449i;

    /* renamed from: m, reason: collision with root package name */
    final HorizontalListView f75450m;

    public MakeupView(Context context) {
        this(context, null);
    }

    @Override // com.tencent.av.ui.beauty.BeautySeekView.c
    public void a(String str, int i3, int i16) {
        if (i3 != 2) {
            if (i3 == 3) {
                this.F = i16;
                gu.a aVar = this.D;
                if (aVar != null) {
                    aVar.f0(this.E, i16, true);
                }
                try {
                    AVUtil.a("0X800AA63", Integer.parseInt(this.E));
                } catch (Throwable unused) {
                }
            }
        } else {
            this.F = i16;
            gu.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.f0(this.E, i16, false);
            }
        }
    }

    @Override // iw.a
    public void b(long j3, QavListItemBase.c cVar) {
        if (QLog.isColorLevel()) {
            QLog.i("MakeupView", 2, "onEffectClick, seq[" + j3 + "], info[" + cVar + "]");
        }
        BaseToolbar.keepInToolbar(this.f75424d, j3);
        if (cVar == null) {
            return;
        }
        gu.a aVar = this.D;
        if (aVar != null) {
            aVar.b0(j3, "onEffectClick");
        }
        PendantItem pendantItem = null;
        if (TextUtils.equals("0", cVar.f75024a)) {
            gu.a aVar2 = this.D;
            if (aVar2 != null) {
                aVar2.L(j3, null);
            }
            g(null);
            AVUtil.r("0X800AA64", 0, 0, "", "", "", "");
            return;
        }
        gu.a aVar3 = this.D;
        if (aVar3 != null) {
            pendantItem = aVar3.w(cVar.f75024a);
        }
        if (pendantItem != null && !TextUtils.isEmpty(pendantItem.getId())) {
            gu.a aVar4 = this.D;
            if (aVar4 != null) {
                aVar4.L(j3, pendantItem);
            }
            g(cVar.f75024a);
            try {
                AVUtil.a("0X800AA62", Integer.parseInt(cVar.f75024a));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // iw.a
    public void c(long j3) {
        BaseToolbar.keepInToolbar(this.f75424d, j3);
    }

    @Override // com.tencent.av.ui.beauty.BeautyBaseView
    public void e(long j3, boolean z16) {
        gu.a aVar = this.D;
        if (aVar != null) {
            aVar.J(j3, this.G);
        }
    }

    @Override // com.tencent.av.ui.beauty.BeautyBaseView
    public void f(long j3, boolean z16) {
        gu.a aVar = this.D;
        if (aVar != null) {
            aVar.p(j3, this.G);
        }
        refreshUI();
    }

    public void g(String str) {
        if (!TextUtils.equals(str, this.E)) {
            if (QLog.isColorLevel()) {
                QLog.i("MakeupView", 2, "changeCurSelItem, cur[" + str + "], pre[" + this.E + "]");
            }
            this.E = str;
            gu.a aVar = this.D;
            if (aVar != null) {
                int c06 = aVar.c0(str);
                this.F = c06;
                this.D.f0(this.E, c06, false);
            }
            j();
        }
    }

    public void h() {
        String str;
        gu.a aVar = this.D;
        if (aVar != null) {
            String str2 = null;
            if (!aVar.d0()) {
                str = this.D.K;
            } else {
                str = null;
            }
            int i3 = 0;
            int i16 = 0;
            while (true) {
                if (i16 < this.f75447f.size()) {
                    QavListItemBase.c cVar = this.f75447f.get(i16);
                    if (cVar != null && TextUtils.equals(str, cVar.f75024a)) {
                        break;
                    } else {
                        i16++;
                    }
                } else {
                    i16 = -1;
                    break;
                }
            }
            if (i16 >= 1) {
                str2 = str;
                i3 = i16;
            }
            g(str2);
            QAVPtvTemplateAdapter qAVPtvTemplateAdapter = this.C;
            if (qAVPtvTemplateAdapter != null) {
                BaseToolbar.setSelectedListViewItemAndShow(this.f75450m, qAVPtvTemplateAdapter, i3);
            }
        }
    }

    void i() {
        ArrayList<QavListItemBase.c> b16 = this.G.b(getContext());
        this.f75447f.clear();
        this.f75447f.addAll(b16);
    }

    public void j() {
        if (TextUtils.isEmpty(this.E)) {
            TextView textView = this.f75448h;
            if (textView != null) {
                textView.setVisibility(0);
            }
            BeautySeekView beautySeekView = this.f75449i;
            if (beautySeekView != null) {
                beautySeekView.setVisibility(8);
                return;
            }
            return;
        }
        TextView textView2 = this.f75448h;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        BeautySeekView beautySeekView2 = this.f75449i;
        if (beautySeekView2 != null) {
            beautySeekView2.setVisibility(0);
            this.f75449i.l(getContext().getResources().getString(R.string.w2v), this.E, this.F, 0);
        }
    }

    @Override // com.tencent.av.ui.d
    public void refreshUI() {
        if (this.C != null && this.D != null) {
            i();
            this.C.s(this.f75447f);
            this.C.notifyDataSetChanged();
            h();
        }
    }

    @Override // com.tencent.av.ui.beauty.BeautyBaseView
    public void setAppInterface(VideoAppInterface videoAppInterface) {
        super.setAppInterface(videoAppInterface);
        long d16 = e.d();
        if (this.f75424d != null) {
            gu.a aVar = (gu.a) videoAppInterface.B(13);
            this.D = aVar;
            aVar.p(d16, this.G);
        }
        this.G = new t(4, this.D);
        i();
        QAVPtvTemplateAdapter qAVPtvTemplateAdapter = new QAVPtvTemplateAdapter(this.f75424d, getContext(), this.f75447f, this.f75450m, 5.6f);
        this.C = qAVPtvTemplateAdapter;
        this.G.f(qAVPtvTemplateAdapter);
        this.C.j(this);
        this.C.k(this.G);
        this.C.n(true);
        this.C.m(true);
        this.f75450m.setAdapter((ListAdapter) this.C);
        h();
    }

    public MakeupView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MakeupView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f75447f = new ArrayList<>(10);
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = 50;
        this.G = null;
        View.inflate(context, R.layout.aph, this);
        this.f75448h = (TextView) findViewById(R.id.jmn);
        BeautySeekView beautySeekView = (BeautySeekView) findViewById(R.id.a7n);
        this.f75449i = beautySeekView;
        beautySeekView.setBeautySeekActionListener(this);
        HorizontalListView horizontalListView = (HorizontalListView) findViewById(R.id.d9m);
        this.f75450m = horizontalListView;
        horizontalListView.setStayDisplayOffsetZero(true);
        j();
    }

    @Override // iw.a
    public void d(QavListItemBase.c cVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
