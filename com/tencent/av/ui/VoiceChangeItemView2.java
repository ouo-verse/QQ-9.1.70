package com.tencent.av.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.av.ui.QavListItemBase;
import com.tencent.av.ui.effect.view.EffectMaterialImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes3.dex */
public class VoiceChangeItemView2 extends QavListItemBase {
    ImageView C;

    /* renamed from: i, reason: collision with root package name */
    Context f75325i;

    /* renamed from: m, reason: collision with root package name */
    EffectMaterialImageView f75326m;

    public VoiceChangeItemView2(Context context) {
        super(context);
        this.f75326m = null;
        this.C = null;
        this.f75325i = context;
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void b(int i3, boolean z16, boolean z17, QavListItemBase.c cVar, QavListItemBase.a aVar) {
        if (cVar == null) {
            return;
        }
        super.a(i3, aVar);
        setId(i3);
        setTag(cVar);
        if (!TextUtils.isEmpty(cVar.f75025b)) {
            this.f75326m.setImageDrawable(URLDrawable.getDrawable(cVar.f75025b, URLDrawable.URLDrawableOptions.obtain()));
        }
        int i16 = cVar.f75030g;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    this.C.setVisibility(8);
                } else {
                    this.C.setImageResource(R.drawable.dem);
                    this.C.setVisibility(0);
                }
            } else {
                this.C.setImageResource(R.drawable.dem);
                this.C.setVisibility(0);
            }
        } else {
            this.C.setImageResource(R.drawable.dem);
            this.C.setVisibility(0);
        }
        setHighlight(z16);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void e(int i3, int i16) {
        ((LayoutInflater) this.f75325i.getSystemService("layout_inflater")).inflate(R.layout.f168530zt, this);
        this.f75326m = (EffectMaterialImageView) findViewById(R.id.f166567g81);
        this.C = (ImageView) findViewById(R.id.kzx);
        this.f75326m.setOnClickListener(this);
        setOnClickListener(this);
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void g(int i3, int i16) {
        View findViewById = findViewById(R.id.kzv);
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i16;
        findViewById.setLayoutParams(layoutParams);
        if (this.f75326m != null && i3 < getResources().getDimensionPixelSize(R.dimen.a47)) {
            ViewGroup.LayoutParams layoutParams2 = this.f75326m.getLayoutParams();
            layoutParams2.width = i3;
            layoutParams2.height = i3;
            this.f75326m.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.tencent.av.ui.QavListItemBase
    public void setHighlight(boolean z16) {
        this.f75326m.setHighlight(z16);
    }
}
