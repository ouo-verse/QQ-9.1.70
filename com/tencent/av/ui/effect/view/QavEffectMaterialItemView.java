package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.gcore.abase.utils.PatternUtils;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.utils.ba;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavEffectMaterialItemView extends QavListItemBase {
    CircleProgressWithBg C;
    ImageView D;
    ImageView E;
    RelativeLayout F;

    /* renamed from: i, reason: collision with root package name */
    TextView f75589i;

    /* renamed from: m, reason: collision with root package name */
    ImageView f75590m;

    public QavEffectMaterialItemView(Context context) {
        super(context);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void b(int i3, boolean z16, boolean z17, QavListItemBase.c cVar, QavListItemBase.a aVar) {
        String str;
        int i16;
        if (cVar == null) {
            return;
        }
        super.a(i3, aVar);
        setId(i3);
        setTag(cVar);
        this.f75590m.setTag(cVar);
        if (TextUtils.isEmpty(cVar.f75024a)) {
            if (this.F.getVisibility() != 4) {
                this.F.setVisibility(4);
                return;
            }
            return;
        }
        if (this.F.getVisibility() != 0) {
            this.F.setVisibility(0);
        }
        if ("0".equals(cVar.f75024a)) {
            if (!TextUtils.isEmpty(cVar.f75025b)) {
                i16 = Integer.valueOf(cVar.f75025b).intValue();
            } else {
                i16 = 0;
            }
            if (i16 > 0) {
                this.f75590m.setImageResource(i16);
            } else {
                this.f75590m.setImageResource(R.drawable.trans);
            }
        } else if (!TextUtils.isEmpty(cVar.f75025b)) {
            this.f75590m.setImageDrawable(URLDrawable.getDrawable(cVar.f75025b, URLDrawable.URLDrawableOptions.obtain()));
        }
        if (!cVar.f75027d && !cVar.f75024a.equals("0")) {
            this.D.setVisibility(0);
        } else {
            this.D.setVisibility(8);
        }
        this.C.setVisibility(8);
        setHighlight(z16, h(cVar));
        if (cVar.f75036m) {
            this.f75589i.setVisibility(0);
            TextView textView = this.f75589i;
            if (TextUtils.isEmpty(cVar.f75026c)) {
                str = " ";
            } else {
                str = cVar.f75026c;
            }
            textView.setText(str);
            return;
        }
        this.f75589i.setVisibility(8);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void e(int i3, int i16) {
        ((LayoutInflater) this.f75021e.getSystemService("layout_inflater")).inflate(R.layout.ftx, this);
        int color = this.f75021e.getResources().getColor(R.color.f158017al3);
        int color2 = getResources().getColor(R.color.f156818c9);
        this.F = (RelativeLayout) findViewById(R.id.f166585gb2);
        this.f75590m = (ImageView) findViewById(R.id.f166567g81);
        this.E = (ImageView) findViewById(R.id.f30140nj);
        this.D = (ImageView) findViewById(R.id.g7x);
        this.C = (CircleProgressWithBg) findViewById(R.id.f166568g83);
        this.f75589i = (TextView) findViewById(R.id.hid);
        this.D.setImageResource(R.drawable.f7u);
        g(i3, i16);
        this.C.setStrokeWidth(1.6f);
        this.C.setBgAndProgressColor(100, color, 100, color2);
        this.f75590m.setOnClickListener(this);
        this.f75590m.setOnTouchListener(ba.f77070d);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void f(int i3) {
        if (i3 >= 100) {
            if (this.C.getVisibility() != 8) {
                this.C.setVisibility(8);
            }
            this.D.setVisibility(8);
        } else if (i3 < 0) {
            if (this.C.getVisibility() != 8) {
                this.C.setVisibility(8);
            }
            this.D.setVisibility(0);
        } else {
            if (this.C.getVisibility() != 0) {
                this.C.setVisibility(0);
            }
            this.C.setProgress(i3);
            this.D.setVisibility(8);
        }
    }

    public boolean h(QavListItemBase.c cVar) {
        if (cVar != null && !TextUtils.isEmpty(cVar.f75024a)) {
            if (cVar.f75029f == 8 && cVar.f75024a.equals(PatternUtils.NO_MATCH)) {
                return true;
            }
            return "0".equals(cVar.f75024a);
        }
        return false;
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void setHighlight(boolean z16, boolean z17) {
        if (z17) {
            this.E.setImageDrawable(getResources().getDrawable(R.drawable.f161340n71));
            this.f75590m.setImageDrawable(z16 ? null : getResources().getDrawable(R.drawable.n7e));
        } else {
            this.E.setImageDrawable(getResources().getDrawable(R.drawable.f161342n72));
        }
        this.E.setVisibility(z16 ? 0 : 8);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void setHighlight(boolean z16) {
        this.E.setVisibility(z16 ? 0 : 8);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void g(int i3, int i16) {
    }
}
