package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.ui.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class SearchSougouResultItemBuilder extends c {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    public static final Paint f254819c;

    /* renamed from: a, reason: collision with root package name */
    private ColorDrawable f254820a;

    /* renamed from: b, reason: collision with root package name */
    ViewGroup f254821b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class UrlDownloadListener implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        UrlDownloadListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchSougouResultItemBuilder.this);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, (Object) th5);
                return;
            }
            if (SearchSougouResultItemBuilder.this.f254821b != null && uRLDrawable != null && uRLDrawable.getURL() != null) {
                View findViewWithTag = SearchSougouResultItemBuilder.this.f254821b.findViewWithTag(uRLDrawable.getURL().toString());
                if (findViewWithTag != null && (findViewWithTag instanceof ImageView)) {
                    findViewWithTag.post(new Runnable(findViewWithTag) { // from class: com.tencent.mobileqq.ocr.ui.SearchSougouResultItemBuilder.UrlDownloadListener.1
                        static IPatchRedirector $redirector_;

                        /* renamed from: d, reason: collision with root package name */
                        final /* synthetic */ View f254823d;

                        {
                            this.f254823d = findViewWithTag;
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) UrlDownloadListener.this, (Object) findViewWithTag);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                            } else {
                                this.f254823d.setVisibility(8);
                            }
                        }
                    });
                }
                if (QLog.isColorLevel()) {
                    QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "UrlDownloadListener image fail," + uRLDrawable.getURL());
                }
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ViewGroup f254825a;

        /* renamed from: b, reason: collision with root package name */
        TextView f254826b;

        /* renamed from: c, reason: collision with root package name */
        TextView f254827c;

        /* renamed from: d, reason: collision with root package name */
        TextView f254828d;

        /* renamed from: e, reason: collision with root package name */
        ImageView f254829e;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) SearchSougouResultItemBuilder.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20611);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f254819c = new Paint();
        }
    }

    public SearchSougouResultItemBuilder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.f254820a = new ColorDrawable(Color.parseColor("#e7e7e7"));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v3, types: [android.view.View, android.view.ViewGroup] */
    /* JADX WARN: Type inference failed for: r8v4, types: [android.view.View] */
    public View a(int i3, View view, ViewGroup viewGroup, b bVar, b.C8175b c8175b) {
        a aVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), view, viewGroup, bVar, c8175b);
        }
        Context context = viewGroup.getContext();
        OCRTextSearchInfo.SougouSearchInfo sougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo) c8175b.f254840b;
        if (view != 0) {
            b.C8175b c8175b2 = (b.C8175b) view.getTag();
            if (c8175b2.f254839a == c8175b.f254839a && c8175b2.f254844f == c8175b.f254844f) {
                aVar = (a) view.getTag(-1);
                z16 = false;
                if (!z16 || aVar == null) {
                    aVar = new a();
                    view = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ayr, viewGroup, false);
                    aVar.f254825a = view;
                    aVar.f254826b = (TextView) view.findViewById(R.id.title);
                    aVar.f254827c = (TextView) view.findViewById(R.id.f163838v);
                    aVar.f254828d = (TextView) view.findViewById(R.id.iz4);
                    aVar.f254829e = (ImageView) view.findViewById(R.id.image);
                    view.setTag(-1, aVar);
                }
                c(aVar, sougouSearchInfo);
                view.setTag(c8175b);
                return view;
            }
        }
        aVar = null;
        if (!z16) {
        }
        aVar = new a();
        view = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.ayr, viewGroup, false);
        aVar.f254825a = view;
        aVar.f254826b = (TextView) view.findViewById(R.id.title);
        aVar.f254827c = (TextView) view.findViewById(R.id.f163838v);
        aVar.f254828d = (TextView) view.findViewById(R.id.iz4);
        aVar.f254829e = (ImageView) view.findViewById(R.id.image);
        view.setTag(-1, aVar);
        c(aVar, sougouSearchInfo);
        view.setTag(c8175b);
        return view;
    }

    public void b(ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) viewGroup);
        } else {
            this.f254821b = viewGroup;
        }
    }

    void c(a aVar, OCRTextSearchInfo.SougouSearchInfo sougouSearchInfo) {
        SpannableString b16;
        com.tencent.mobileqq.ocr.ui.a aVar2 = new com.tencent.mobileqq.ocr.ui.a(sougouSearchInfo.titleKeyWords, null);
        if (!TextUtils.isEmpty(sougouSearchInfo.title) && (b16 = aVar2.b(sougouSearchInfo.title, true)) != null) {
            aVar.f254826b.setText(b16);
        }
        com.tencent.mobileqq.ocr.ui.a aVar3 = new com.tencent.mobileqq.ocr.ui.a(sougouSearchInfo.abstractStrKeyWords, null);
        if (!TextUtils.isEmpty(sougouSearchInfo.abstractStr)) {
            aVar.f254827c.setText(aVar3.a(com.tencent.mobileqq.ocr.ui.a.c(sougouSearchInfo.abstractStr)));
        }
        try {
            if (TextUtils.isEmpty(sougouSearchInfo.summaryPic)) {
                aVar.f254829e.setVisibility(8);
            } else {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                obtain.mRequestWidth = x.c(MobileQQ.sMobileQQ, 80.0f);
                obtain.mRequestHeight = x.c(MobileQQ.sMobileQQ, 60.0f);
                ColorDrawable colorDrawable = this.f254820a;
                obtain.mFailedDrawable = colorDrawable;
                obtain.mLoadingDrawable = colorDrawable;
                URLDrawable drawable = URLDrawable.getDrawable(sougouSearchInfo.summaryPic, obtain);
                if (drawable != null && drawable.getStatus() == 2) {
                    if (QLog.isColorLevel()) {
                        QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem image fail," + sougouSearchInfo);
                    }
                    aVar.f254829e.setVisibility(8);
                } else {
                    aVar.f254829e.setVisibility(0);
                    if (drawable != null) {
                        drawable.setURLDrawableListener(new UrlDownloadListener());
                    }
                    aVar.f254829e.setImageDrawable(drawable);
                }
                aVar.f254829e.setTag(sougouSearchInfo.summaryPic);
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("Q.ocr.SearchSougouResultItemBuilder", 2, "updateNormalItem", e16);
            }
            e16.printStackTrace();
        }
        if (TextUtils.isEmpty(sougouSearchInfo.sourceFrom)) {
            aVar.f254828d.setVisibility(8);
        } else {
            aVar.f254828d.setVisibility(0);
            aVar.f254828d.setText(sougouSearchInfo.sourceFrom);
        }
    }
}
