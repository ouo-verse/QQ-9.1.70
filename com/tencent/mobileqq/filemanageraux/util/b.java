package com.tencent.mobileqq.filemanageraux.util;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.api.ITencentDocConvertABTestUtil;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import ta1.h;

/* compiled from: P */
/* loaded from: classes12.dex */
public class b {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f209673d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f209674e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ITencentDocConvertABTestUtil.a f209675f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ h f209676h;

        a(AppInterface appInterface, String str, ITencentDocConvertABTestUtil.a aVar, h hVar) {
            this.f209673d = appInterface;
            this.f209674e = str;
            this.f209675f = aVar;
            this.f209676h = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appInterface, str, aVar, hVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AppInterface appInterface = this.f209673d;
                if (appInterface != null) {
                    String str = this.f209674e;
                    ReportController.o(appInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
                }
                this.f209675f.a(this.f209676h.c());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.filemanageraux.util.b$b, reason: collision with other inner class name */
    /* loaded from: classes12.dex */
    public class ViewOnClickListenerC7595b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ AppInterface f209677d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f209678e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ITencentDocConvertABTestUtil.a f209679f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ h f209680h;

        ViewOnClickListenerC7595b(AppInterface appInterface, String str, ITencentDocConvertABTestUtil.a aVar, h hVar) {
            this.f209677d = appInterface;
            this.f209678e = str;
            this.f209679f = aVar;
            this.f209680h = hVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, appInterface, str, aVar, hVar);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                AppInterface appInterface = this.f209677d;
                if (appInterface != null) {
                    String str = this.f209678e;
                    ReportController.o(appInterface, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
                }
                this.f209679f.a(this.f209680h.c());
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public static int a(AppInterface appInterface) {
        if (appInterface == null) {
            return 106;
        }
        return f(appInterface.getApp(), 53.0f);
    }

    private static void b(AppInterface appInterface, View view, ITencentDocConvertABTestUtil.a aVar, ViewGroup viewGroup, ViewGroup viewGroup2, LayoutInflater layoutInflater, h hVar) {
        view.setVisibility(0);
        viewGroup2.setVisibility(0);
        View inflate = layoutInflater.inflate(R.layout.amh, viewGroup, false);
        LayerDrawable layerDrawable = (LayerDrawable) viewGroup2.getBackground();
        if (layerDrawable != null) {
            GradientDrawable gradientDrawable = (GradientDrawable) layerDrawable.findDrawableByLayerId(R.id.a4f);
            gradientDrawable.setAlpha(Math.round(hVar.a() * 255.0f));
            if (!TextUtils.isEmpty(hVar.d())) {
                try {
                    gradientDrawable.setColor(k(hVar.d()));
                } catch (NumberFormatException e16) {
                    QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", e16);
                }
            }
        }
        if (!TextUtils.isEmpty(hVar.h())) {
            try {
                ((TextView) inflate.findViewById(R.id.k5u)).setTextColor(k(hVar.h()));
            } catch (NumberFormatException e17) {
                QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", e17);
            }
        }
        if (!TextUtils.isEmpty(hVar.g())) {
            ((TextView) inflate.findViewById(R.id.k5u)).setText(hVar.g());
        }
        if (!TextUtils.isEmpty(hVar.e())) {
            ((URLImageView) inflate.findViewById(R.id.du_)).setImageDrawable(URLDrawable.getDrawable(hVar.e(), URLDrawable.URLDrawableOptions.obtain()));
        }
        inflate.setOnClickListener(new a(appInterface, hVar.b(), aVar, hVar));
        if (hVar.c() == 2) {
            aVar.b((ImageView) inflate.findViewById(R.id.khb));
        }
        ReportController.o(appInterface, "dc00898", "", "", hVar.f(), hVar.f(), 0, 0, "", "", "", "");
        viewGroup2.addView(inflate);
    }

    private static void c(AppInterface appInterface, View view, ITencentDocConvertABTestUtil.a aVar, ViewGroup viewGroup, LayoutInflater layoutInflater, h hVar) {
        view.setVisibility(0);
        viewGroup.setVisibility(0);
        View inflate = layoutInflater.inflate(R.layout.amh, viewGroup, false);
        GradientDrawable gradientDrawable = (GradientDrawable) viewGroup.getBackground();
        if (gradientDrawable != null) {
            gradientDrawable.setAlpha(Math.round(hVar.a() * 255.0f));
            if (!TextUtils.isEmpty(hVar.d())) {
                try {
                    gradientDrawable.setColor(k(hVar.d()));
                } catch (NumberFormatException e16) {
                    QLog.e("TencentDocConvertABTestUtil", 1, "parse bg color fail", e16);
                }
            }
        }
        if (!TextUtils.isEmpty(hVar.h())) {
            try {
                ((TextView) inflate.findViewById(R.id.k5u)).setTextColor(k(hVar.h()));
            } catch (NumberFormatException e17) {
                QLog.e("TencentDocConvertABTestUtil", 1, "parse text color fail", e17);
            }
        }
        if (!TextUtils.isEmpty(hVar.g())) {
            ((TextView) inflate.findViewById(R.id.k5u)).setText(hVar.g());
        }
        if (!TextUtils.isEmpty(hVar.e())) {
            ((URLImageView) inflate.findViewById(R.id.du_)).setImageDrawable(URLDrawable.getDrawable(hVar.e(), URLDrawable.URLDrawableOptions.obtain()));
        }
        inflate.setOnClickListener(new ViewOnClickListenerC7595b(appInterface, hVar.b(), aVar, hVar));
        if (hVar.c() == 2) {
            aVar.b((ImageView) inflate.findViewById(R.id.khb));
        }
        ReportController.o(appInterface, "dc00898", "", "", hVar.f(), hVar.f(), 0, 0, "", "", "", "");
        viewGroup.addView(inflate);
    }

    public static void d(AppInterface appInterface, Activity activity, View view, TeamWorkFileImportInfo teamWorkFileImportInfo, ITencentDocConvertABTestUtil.a aVar) {
        Resources resources;
        if (teamWorkFileImportInfo == null || activity == null || (resources = activity.getResources()) == null) {
            return;
        }
        List<h> g16 = g(teamWorkFileImportInfo.f292074f);
        ArrayList arrayList = new ArrayList();
        if (g16 != null && g16.size() > 0) {
            if (teamWorkFileImportInfo.f292070d != 1) {
                for (h hVar : g16) {
                    if (hVar.c() != 2) {
                        arrayList.add(hVar);
                    }
                }
            } else {
                arrayList.addAll(g16);
            }
        }
        e(appInterface, resources, view, arrayList, aVar);
    }

    private static void e(AppInterface appInterface, Resources resources, View view, List<h> list, ITencentDocConvertABTestUtil.a aVar) {
        if (view != null && aVar != null && list != null && list.size() != 0) {
            ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.cd9);
            ViewGroup viewGroup2 = (ViewGroup) view.findViewById(R.id.acg);
            if (viewGroup != null && viewGroup2 != null) {
                view.setVisibility(8);
                viewGroup.setVisibility(8);
                viewGroup2.setVisibility(8);
                LayoutInflater layoutInflater = (LayoutInflater) BaseApplication.getContext().getSystemService("layout_inflater");
                for (h hVar : list) {
                    int i3 = hVar.i();
                    if (i3 != 1) {
                        if (i3 != 2) {
                            QLog.w("TencentDocConvertABTestUtil", 2, "can not show edit entrance");
                        } else {
                            b(appInterface, view, aVar, viewGroup, viewGroup2, layoutInflater, hVar);
                        }
                    } else {
                        c(appInterface, view, aVar, viewGroup, layoutInflater, hVar);
                    }
                }
            }
        }
    }

    private static int f(Context context, float f16) {
        return (int) ((f16 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private static List<h> g(String str) {
        return null;
    }

    public static List<h> h() {
        return null;
    }

    public static boolean i(TeamWorkFileImportInfo teamWorkFileImportInfo) {
        if (teamWorkFileImportInfo != null && j(teamWorkFileImportInfo.f292074f)) {
            return true;
        }
        return false;
    }

    public static boolean j(String str) {
        List<h> g16 = g(str);
        if (g16 == null || g16.size() <= 0 || g16.get(0).i() == 0) {
            return false;
        }
        return true;
    }

    private static int k(String str) {
        return Integer.decode(str).intValue() | (-16777216);
    }
}
