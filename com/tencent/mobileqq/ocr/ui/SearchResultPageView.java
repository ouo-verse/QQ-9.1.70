package com.tencent.mobileqq.ocr.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.ocr.OCRTextSearchInfo;
import com.tencent.mobileqq.ocr.ui.BaseOCRTextSearchFragment;
import com.tencent.mobileqq.ocr.ui.b;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.bw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.util.List;

/* loaded from: classes16.dex */
public class SearchResultPageView implements b.c {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public BaseOCRTextSearchFragment.b f254804a;

    /* renamed from: b, reason: collision with root package name */
    BaseOCRTextSearchFragment f254805b;

    /* renamed from: c, reason: collision with root package name */
    XListView f254806c;

    /* renamed from: d, reason: collision with root package name */
    TextView f254807d;

    /* renamed from: e, reason: collision with root package name */
    LinearLayout f254808e;

    /* renamed from: f, reason: collision with root package name */
    b f254809f;

    /* renamed from: g, reason: collision with root package name */
    View f254810g;

    /* renamed from: h, reason: collision with root package name */
    boolean f254811h;

    /* renamed from: i, reason: collision with root package name */
    boolean f254812i;

    /* renamed from: j, reason: collision with root package name */
    Handler f254813j;

    /* renamed from: k, reason: collision with root package name */
    boolean f254814k;

    /* renamed from: l, reason: collision with root package name */
    ProgressBar f254815l;

    /* renamed from: m, reason: collision with root package name */
    boolean f254816m;

    /* renamed from: n, reason: collision with root package name */
    int f254817n;

    /* renamed from: o, reason: collision with root package name */
    com.tencent.mobileqq.ocr.f f254818o;

    public SearchResultPageView(BaseOCRTextSearchFragment.b bVar, SearchResultFragment searchResultFragment) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bVar, (Object) searchResultFragment);
            return;
        }
        this.f254810g = null;
        this.f254811h = false;
        this.f254812i = false;
        this.f254813j = new Handler(Looper.getMainLooper());
        this.f254814k = false;
        this.f254816m = false;
        this.f254817n = 0;
        this.f254804a = bVar;
        this.f254805b = searchResultFragment;
        this.f254809f = new b(bVar.getActivity(), this);
    }

    private void e(String str, String str2) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f254804a.getActivity(), RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("uin", str);
        activityURIRequest.extra().putString("url", str2);
        activityURIRequest.extra().putBoolean("hide_more_button", true);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // com.tencent.mobileqq.ocr.ui.b.c
    public void a(b.C8175b c8175b) {
        OCRTextSearchInfo.SougouSearchInfo sougouSearchInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) c8175b);
            return;
        }
        if (c8175b == null) {
            return;
        }
        if (c8175b.f254844f == 2049 && c8175b.f254839a == 0 && (sougouSearchInfo = (OCRTextSearchInfo.SougouSearchInfo) c8175b.f254840b) != null && !TextUtils.isEmpty(sougouSearchInfo.jumpURL)) {
            e(bw.a(), sougouSearchInfo.jumpURL);
        }
        ReportController.o(null, "dc00898", "", "", "0X80082E9", "0X80082E9", 0, 0, "", "", "", "");
    }

    protected void b(com.tencent.mobileqq.ocr.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) fVar);
            return;
        }
        if (this.f254816m) {
            return;
        }
        this.f254816m = true;
        this.f254818o = fVar;
        if (fVar.f254762d == 0 && fVar.f254761c != null) {
            if (QLog.isColorLevel()) {
                QLog.d("Q.ocr.SearchResultFragment", 2, "results: " + this.f254818o.f254761c.size());
            }
            List<OCRTextSearchInfo.a> list = this.f254818o.f254761c;
            if (list.size() != 0) {
                this.f254809f.b(this.f254818o, list, false, false);
            } else {
                h(-1);
                return;
            }
        }
        g();
        h(fVar.f254762d);
    }

    public View c(Context context, com.tencent.mobileqq.ocr.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (View) iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) fVar);
        }
        if (this.f254810g == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.ayp, (ViewGroup) null);
            this.f254806c = (XListView) inflate.findViewById(R.id.search_result_list);
            this.f254815l = (ProgressBar) inflate.findViewById(R.id.j_t);
            this.f254807d = (TextView) inflate.findViewById(R.id.f166412fa0);
            this.f254806c.setOnTouchListener(this.f254805b.D);
            this.f254808e = (LinearLayout) inflate.findViewById(R.id.eey);
            this.f254810g = inflate;
            this.f254806c.setAdapter((ListAdapter) this.f254809f);
        }
        b(fVar);
        return this.f254810g;
    }

    public void d(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, z16);
            return;
        }
        this.f254816m = false;
        this.f254817n = 0;
        this.f254814k = false;
        this.f254812i = false;
        this.f254811h = z16;
        b bVar = this.f254809f;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    public void g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f254813j.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.ocr.ui.SearchResultPageView.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SearchResultPageView.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        SearchResultPageView.this.f254806c.setSelection(0);
                    }
                }
            }, 50L);
        }
    }

    protected void h(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
            return;
        }
        if (i3 != -2) {
            if (i3 != -1) {
                if (i3 != 0) {
                    if (i3 == 1) {
                        this.f254815l.setVisibility(0);
                        this.f254806c.setVisibility(8);
                        this.f254807d.setVisibility(8);
                    }
                } else {
                    this.f254815l.setVisibility(8);
                    this.f254807d.setVisibility(8);
                    this.f254806c.setVisibility(0);
                }
            } else {
                this.f254815l.setVisibility(8);
                this.f254806c.setVisibility(8);
                this.f254807d.setVisibility(0);
                this.f254807d.setText(R.string.dng);
            }
        } else {
            this.f254815l.setVisibility(8);
            this.f254806c.setVisibility(8);
            this.f254807d.setVisibility(0);
            this.f254807d.setText(R.string.foi);
        }
        this.f254804a.b(null);
    }
}
