package com.tencent.mobileqq.search.presenter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.PublicAccountInfoForSearch;
import com.tencent.mobileqq.search.model.y;
import com.tencent.widget.immersive.ImmersiveUtils;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j extends qn2.f {

    /* renamed from: e, reason: collision with root package name */
    private Drawable f283655e;

    public j(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    private void n(sn2.c cVar, TextView textView, boolean z16) {
        if (z16) {
            if (this.f283655e == null) {
                Drawable drawable = cVar.b().getContext().getResources().getDrawable(R.drawable.br7);
                this.f283655e = drawable;
                drawable.setBounds(0, 0, ImmersiveUtils.dpToPx(15.0f), ImmersiveUtils.dpToPx(15.0f));
            }
            textView.setCompoundDrawables(null, null, this.f283655e, null);
            return;
        }
        textView.setCompoundDrawables(null, null, null, null);
    }

    private void o(sn2.c cVar, y yVar) {
        boolean z16;
        TextView b16 = cVar.b();
        if (b16 != null && yVar != null) {
            Context context = b16.getContext();
            if (yVar instanceof up2.b) {
                PublicAccountInfoForSearch R = ((up2.b) yVar).R();
                if (R != null && context != null) {
                    if (R.getCertifiedGrade() > 0) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    n(cVar, b16, z16);
                    return;
                }
                return;
            }
            if (yVar instanceof com.tencent.mobileqq.search.model.f) {
                com.tencent.mobileqq.search.model.f fVar = (com.tencent.mobileqq.search.model.f) yVar;
                if (context != null) {
                    n(cVar, b16, fVar.G());
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qn2.f
    public void k(sn2.c cVar, y yVar) {
        up2.b bVar;
        PublicAccountInfoForSearch R;
        super.k(cVar, yVar);
        if ((yVar instanceof up2.b) && (R = (bVar = (up2.b) yVar).R()) != null && R.getDisplayNumber() != null && R.getDisplayNumber().equalsIgnoreCase(bVar.s())) {
            SpannableString spannableString = new SpannableString(R.getName());
            spannableString.setSpan(new ForegroundColorSpan(-16734752), 0, R.getName().length(), 33);
            cVar.b().setText(spannableString);
        }
        o(cVar, yVar);
    }
}
