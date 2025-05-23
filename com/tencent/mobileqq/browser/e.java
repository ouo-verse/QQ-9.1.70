package com.tencent.mobileqq.browser;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.onlinestatus.bv;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.LRULinkedHashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes11.dex */
public class e extends BaseAdapter {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private ArrayList<com.tencent.mobileqq.browser.b> f200549d;

    /* renamed from: e, reason: collision with root package name */
    private Context f200550e;

    /* renamed from: f, reason: collision with root package name */
    private int f200551f;

    /* renamed from: h, reason: collision with root package name */
    private Map<String, Drawable> f200552h;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f200553d;

        a(int i3) {
            this.f200553d = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) e.this, i3);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                int i3 = e.this.f200551f;
                int i16 = this.f200553d;
                if (i3 != i16) {
                    e.this.f200551f = i16;
                    e.this.notifyDataSetChanged();
                }
                bv.a("0X800ADEB");
                if (QLog.isColorLevel()) {
                    QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, "[action] bindItemClickListener: invoked. ", " position: ", Integer.valueOf(this.f200553d));
                }
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        TextView f200555a;

        /* renamed from: b, reason: collision with root package name */
        TextView f200556b;

        /* renamed from: c, reason: collision with root package name */
        URLImageView f200557c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f200558d;

        /* renamed from: e, reason: collision with root package name */
        LinearLayout f200559e;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public e(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f200549d = new ArrayList<>();
        this.f200552h = new LRULinkedHashMap(20);
        this.f200550e = context;
        this.f200551f = k();
    }

    private void c(int i3, b bVar) {
        if (i3 == this.f200551f) {
            bVar.f200558d.setVisibility(0);
        } else {
            bVar.f200558d.setVisibility(8);
        }
    }

    private void d(b bVar, com.tencent.mobileqq.browser.b bVar2) {
        Drawable drawable;
        if (!bVar2.f()) {
            if (!TextUtils.isEmpty(bVar2.a())) {
                URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                ColorDrawable colorDrawable = new ColorDrawable(0);
                obtain.mLoadingDrawable = colorDrawable;
                obtain.mFailedDrawable = colorDrawable;
                bVar.f200557c.setImageDrawable(URLDrawable.getDrawable(bVar2.a(), obtain));
                return;
            }
            bVar.f200557c.setImageDrawable(new ColorDrawable(0));
            return;
        }
        try {
            String d16 = bVar2.d();
            if (this.f200552h.containsKey(d16)) {
                drawable = this.f200552h.get(d16);
            } else {
                Drawable j3 = j(this.f200550e, d16);
                this.f200552h.put(d16, j3);
                drawable = j3;
            }
            bVar.f200557c.setImageDrawable(drawable);
        } catch (Exception e16) {
            QLog.e("[BrowserOpt] RecommendBrowserAdapter", 1, "bindIconView: failed. ", e16);
        }
    }

    private void e(int i3, View view, ViewGroup viewGroup) {
        view.setOnClickListener(new a(i3));
    }

    private void f(int i3, b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        com.tencent.mobileqq.browser.b bVar2 = this.f200549d.get(i3);
        c(i3, bVar);
        g(bVar, bVar2);
        d(bVar, bVar2);
        i("bindIconView", currentTimeMillis);
    }

    private void g(b bVar, com.tencent.mobileqq.browser.b bVar2) {
        bVar.f200555a.setText(bVar2.c());
        bVar.f200556b.setText(bVar2.e());
        if (bVar2.f()) {
            bVar.f200556b.setVisibility(8);
            bVar.f200559e.setGravity(16);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.f200555a.getLayoutParams();
            layoutParams.setMargins(layoutParams.leftMargin, 0, layoutParams.rightMargin, layoutParams.bottomMargin);
            bVar.f200555a.setLayoutParams(layoutParams);
            return;
        }
        bVar.f200556b.setVisibility(0);
        bVar.f200559e.setGravity(0);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.f200555a.getLayoutParams();
        layoutParams2.setMargins(layoutParams2.leftMargin, (int) this.f200550e.getResources().getDimension(R.dimen.f159454d70), layoutParams2.rightMargin, layoutParams2.bottomMargin);
        bVar.f200555a.setLayoutParams(layoutParams2);
    }

    @NotNull
    private b h(View view) {
        b bVar = new b();
        bVar.f200555a = (TextView) view.findViewById(R.id.dr7);
        bVar.f200556b = (TextView) view.findViewById(R.id.f166931j64);
        bVar.f200557c = (URLImageView) view.findViewById(R.id.f165861dq1);
        bVar.f200558d = (ImageView) view.findViewById(R.id.xsu);
        bVar.f200559e = (LinearLayout) view.findViewById(R.id.f95165e9);
        return bVar;
    }

    private static void i(String str, long j3) {
        long currentTimeMillis = System.currentTimeMillis() - j3;
        if (QLog.isColorLevel()) {
            QLog.d("[BrowserOpt] RecommendBrowserAdapter", 2, str + " [cost] countTime: invoked. ", " ms: ", Long.valueOf(currentTimeMillis));
        }
    }

    private static Drawable j(Context context, String str) throws PackageManager.NameNotFoundException {
        Drawable apkIcon = ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkIcon(context, context.getPackageManager().getApplicationInfo(str, 128).publicSourceDir);
        if (apkIcon != null) {
            return apkIcon;
        }
        return context.getResources().getDrawable(R.drawable.e98);
    }

    private int k() {
        String b16 = c.b();
        if (!TextUtils.isEmpty(b16)) {
            String e16 = com.tencent.mobileqq.browser.a.e(b16);
            for (int i3 = 0; i3 < this.f200549d.size(); i3++) {
                com.tencent.mobileqq.browser.b bVar = this.f200549d.get(i3);
                if (e16 != null && e16.equals(bVar.d())) {
                    return i3;
                }
            }
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f200549d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        return this.f200549d.get(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            view2 = (View) iPatchRedirector.redirect((short) 6, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(BaseApplication.context).inflate(R.layout.gzz, viewGroup, false);
                bVar = h(view);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            f(i3, bVar);
            e(i3, view, viewGroup);
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            this.f200552h.clear();
        }
    }

    public void m(List<com.tencent.mobileqq.browser.b> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) list);
            return;
        }
        this.f200549d.clear();
        this.f200549d.addAll(list);
        notifyDataSetChanged();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public com.tencent.mobileqq.browser.b n() {
        int size = this.f200549d.size();
        int i3 = this.f200551f;
        if (size > i3 && i3 >= 0) {
            return this.f200549d.get(i3);
        }
        return null;
    }
}
