package com.tencent.av.ui.effect.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;

/* compiled from: P */
/* loaded from: classes3.dex */
public class QavVoiceChangeMaterialItemView extends QavListItemBase {
    ImageView C;
    TextView D;

    /* renamed from: i, reason: collision with root package name */
    Context f75603i;

    /* renamed from: m, reason: collision with root package name */
    ImageView f75604m;

    public QavVoiceChangeMaterialItemView(Context context) {
        super(context);
        this.f75604m = null;
        this.f75603i = context;
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void b(int i3, boolean z16, boolean z17, QavListItemBase.c cVar, QavListItemBase.a aVar) {
        String str;
        if (cVar == null) {
            return;
        }
        super.a(i3, aVar);
        setId(i3);
        setTag(cVar);
        if (!TextUtils.isEmpty(cVar.f75025b)) {
            this.f75604m.setImageDrawable(URLDrawable.getDrawable(cVar.f75025b, URLDrawable.URLDrawableOptions.obtain()));
        }
        setHighlight(z16, "0".equals(cVar.f75024a));
        if (cVar.f75036m) {
            this.D.setVisibility(0);
            TextView textView = this.D;
            if (TextUtils.isEmpty(cVar.f75026c)) {
                str = " ";
            } else {
                str = cVar.f75026c;
            }
            textView.setText(str);
        } else {
            this.D.setVisibility(8);
        }
        if ("0".equals(cVar.f75024a)) {
            if (z16) {
                setContentDescription(HardCodeUtil.qqStr(R.string.zio));
                this.f75604m.setContentDescription(HardCodeUtil.qqStr(R.string.zio));
                return;
            } else {
                setContentDescription(HardCodeUtil.qqStr(R.string.zin));
                this.f75604m.setContentDescription(HardCodeUtil.qqStr(R.string.zin));
                return;
            }
        }
        if (z16) {
            setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f238447js), cVar.f75026c));
            this.f75604m.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f238447js), cVar.f75026c));
        } else {
            setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f238437jr), cVar.f75026c));
            this.f75604m.setContentDescription(String.format(HardCodeUtil.qqStr(R.string.f238437jr), cVar.f75026c));
        }
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void e(int i3, int i16) {
        ((LayoutInflater) this.f75603i.getSystemService("layout_inflater")).inflate(R.layout.fuf, this);
        this.f75604m = (ImageView) findViewById(R.id.f166567g81);
        this.C = (ImageView) findViewById(R.id.f30140nj);
        this.D = (TextView) findViewById(R.id.hid);
        setOnClickListener(this);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void setHighlight(boolean z16, boolean z17) {
        if (z17) {
            this.C.setImageResource(R.drawable.f161340n71);
            this.f75604m.setImageDrawable(z16 ? null : ResourcesCompat.getDrawable(getResources(), R.drawable.n7e, null));
        } else {
            this.C.setImageResource(R.drawable.f161342n72);
        }
        this.C.setVisibility(z16 ? 0 : 8);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void setHighlight(boolean z16) {
        this.C.setVisibility(z16 ? 0 : 8);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void g(int i3, int i16) {
    }
}
