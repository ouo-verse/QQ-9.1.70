package com.tencent.mobileqq.search.presenter;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.search.model.y;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

/* compiled from: P */
/* loaded from: classes18.dex */
public class f extends qn2.f {
    public f(IFaceDecoder iFaceDecoder) {
        super(iFaceDecoder);
    }

    private void n(sn2.c cVar, up2.a aVar) {
        if (cVar.f() != null && !TextUtils.isEmpty(aVar.U())) {
            String U = aVar.U();
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = x.c(cVar.getView().getContext(), 50.0f);
            obtain.mRequestHeight = x.c(cVar.getView().getContext(), 50.0f);
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            if (URLUtil.isValidUrl(U)) {
                URLDrawable drawable = URLDrawable.getDrawable(U, obtain);
                drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(x.c(cVar.getView().getContext(), 50.0f), x.c(cVar.getView().getContext(), 50.0f), x.c(cVar.getView().getContext(), 3.0f)));
                drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                cVar.f().setImageDrawable(drawable);
                if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                    drawable.restartDownload();
                    return;
                }
                return;
            }
            cVar.f().setImageDrawable(colorDrawable);
        }
    }

    private void o(sn2.c cVar, io2.b bVar, up2.a aVar) {
        String str = aVar.X.miniIconUrl;
        if (bVar.o() != null && !TextUtils.isEmpty(str)) {
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = x.c(cVar.getView().getContext(), 14.0f);
            obtain.mRequestHeight = x.c(cVar.getView().getContext(), 14.0f);
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            URLDrawable drawable = URLDrawable.getDrawable(str, obtain);
            drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(x.c(cVar.getView().getContext(), 14.0f), x.c(cVar.getView().getContext(), 14.0f), 0));
            drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            bVar.q().setImageDrawable(drawable);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
        }
    }

    private void p(sn2.c cVar, io2.b bVar, up2.a aVar) {
        if (bVar.q() != null && aVar.R()) {
            String S = aVar.S();
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mRequestWidth = x.c(cVar.getView().getContext(), 40.0f);
            obtain.mRequestHeight = x.c(cVar.getView().getContext(), 12.0f);
            obtain.mFailedDrawable = colorDrawable;
            obtain.mLoadingDrawable = colorDrawable;
            URLDrawable drawable = URLDrawable.getDrawable(S, obtain);
            drawable.setTag(com.tencent.mobileqq.urldrawable.a.c(x.c(cVar.getView().getContext(), 38.0f), x.c(cVar.getView().getContext(), 12.0f), 0));
            drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
            bVar.q().setImageDrawable(drawable);
            if (drawable.getStatus() != 1 && drawable.getStatus() != 0) {
                drawable.restartDownload();
            }
        }
    }

    @Override // qn2.f, qn2.d
    /* renamed from: g */
    public void a(y yVar, sn2.c cVar) {
        up2.a aVar;
        io2.b bVar = null;
        if (yVar instanceof up2.a) {
            aVar = (up2.a) yVar;
        } else {
            aVar = null;
        }
        if (cVar instanceof io2.b) {
            bVar = (io2.b) cVar;
        }
        if (bVar != null && aVar != null) {
            if (bVar.b() != null) {
                bVar.b().setVisibility(0);
            }
            TextView p16 = bVar.p();
            if (p16 != null) {
                p16.setVisibility(8);
            }
            if (!TextUtils.isEmpty(yVar.getTitleSpans())) {
                bVar.b().setText(aVar.getTitleSpans());
            }
            n(cVar, aVar);
            o(cVar, bVar, aVar);
            h(yVar, cVar);
            p(cVar, bVar, aVar);
            return;
        }
        QLog.i("MiniProgramSearchResultPresenter", 1, "resultView == null || result == null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // qn2.f
    public void h(y yVar, sn2.c cVar) {
        super.h(yVar, cVar);
    }

    @Override // qn2.f, qn2.c
    /* renamed from: l */
    public void f(y yVar, sn2.c cVar, Bitmap bitmap) {
        if (yVar.k() == 103) {
            if (cVar.f() != null) {
                cVar.f().setImageDrawable(SearchUtils.r0(bitmap));
                return;
            }
            return;
        }
        super.f(yVar, cVar, bitmap);
    }
}
