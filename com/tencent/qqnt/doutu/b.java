package com.tencent.qqnt.doutu;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.aio.adapter.api.IReportControllerApi;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes24.dex */
public class b extends BaseAdapter implements View.OnClickListener, tw3.a {
    static IPatchRedirector $redirector_;
    public static int R;
    public String C;
    public String D;
    public String E;
    private ColorDrawable F;
    public MqqHandler G;
    private boolean H;
    private int I;
    private DoutuData J;
    public c K;
    public long L;
    public HashMap<String, String> M;
    public DoutuData N;
    public g P;
    URLDrawableDownListener Q;

    /* renamed from: d, reason: collision with root package name */
    public List<DoutuData> f356026d;

    /* renamed from: e, reason: collision with root package name */
    public List<DoutuData> f356027e;

    /* renamed from: f, reason: collision with root package name */
    private int f356028f;

    /* renamed from: h, reason: collision with root package name */
    private int f356029h;

    /* renamed from: i, reason: collision with root package name */
    private int f356030i;

    /* renamed from: m, reason: collision with root package name */
    private int f356031m;

    /* compiled from: P */
    /* loaded from: classes24.dex */
    class a implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) uRLDrawable);
            } else {
                QLog.e("DoutuEmotionAdapter", 1, "doutu drawable onLoadCancelled!");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
            } else {
                QLog.e("DoutuEmotionAdapter", 1, "doutu drawable onLoadFailed!");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, interruptedException);
            } else {
                QLog.e("DoutuEmotionAdapter", 1, "doutu drawable onLoadInterrupted!");
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, view, uRLDrawable, Integer.valueOf(i3));
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            Object tag = view.getTag();
            if (tag != null && (tag instanceof C9610b)) {
                C9610b c9610b = (C9610b) tag;
                ProgressBar progressBar = c9610b.f356035c;
                if (progressBar != null) {
                    progressBar.setVisibility(4);
                }
                b bVar = b.this;
                if (bVar.M == null) {
                    bVar.M = new HashMap<>();
                }
                DoutuData doutuData = c9610b.f356036d;
                if (doutuData != null && (str = doutuData.picMd5) != null && (str2 = doutuData.picDownUrl) != null) {
                    b.this.M.put(str, str2);
                }
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.qqnt.doutu.b$b, reason: collision with other inner class name */
    /* loaded from: classes24.dex */
    private static class C9610b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        RelativeLayout f356033a;

        /* renamed from: b, reason: collision with root package name */
        URLImageView f356034b;

        /* renamed from: c, reason: collision with root package name */
        ProgressBar f356035c;

        /* renamed from: d, reason: collision with root package name */
        DoutuData f356036d;

        /* renamed from: e, reason: collision with root package name */
        int f356037e;

        C9610b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            R = 4;
        }
    }

    public b(g gVar, String str, String str2, String str3, MqqHandler mqqHandler, boolean z16, c cVar, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, gVar, str, str2, str3, mqqHandler, Boolean.valueOf(z16), cVar, Integer.valueOf(i3));
            return;
        }
        this.F = new ColorDrawable();
        this.H = false;
        this.I = -1;
        this.J = new DoutuData("abababababababababababab", null);
        this.L = 0L;
        this.Q = new a();
        this.C = str;
        this.D = str2;
        this.E = str3;
        this.G = mqqHandler;
        this.P = gVar;
        this.K = cVar;
        this.H = (!z16 || cVar == null || TextUtils.isEmpty(cVar.f356039b)) ? false : true;
        this.L = System.currentTimeMillis();
        this.f356028f = ViewUtils.dip2px(80.0f);
        this.f356029h = ViewUtils.dip2px(80.0f);
        this.f356030i = ViewUtils.dip2px(70.0f);
        this.f356031m = ViewUtils.dip2px(70.0f);
        if (i3 > 0 && this.H) {
            R = i3;
        }
        if (!this.H) {
            R = 9;
            R = Math.max(R, ViewUtils.getScreenWidth() / this.f356028f);
        }
        this.f356026d = new ArrayList();
        for (int i16 = 0; i16 < R; i16++) {
            this.f356026d.add(new DoutuData());
        }
        this.M = new HashMap<>();
    }

    @Override // tw3.a
    public void a() {
        int size;
        int size2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        List<DoutuData> list = this.f356026d;
        if (list == null || this.f356027e == null || (size = list.size()) >= (size2 = this.f356027e.size())) {
            return;
        }
        this.f356026d.clear();
        for (int i3 = 0; i3 < size2 && i3 < R + size; i3++) {
            this.f356026d.add(this.f356027e.get(i3));
        }
        notifyDataSetChanged();
    }

    public void b(List<DoutuData> list, boolean z16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, list, Boolean.valueOf(z16), Long.valueOf(j3));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("DoutuEmotionAdapter", 2, "addSmartPicList removeEmptyData:" + z16);
        }
        if (j3 != this.L) {
            if (QLog.isColorLevel()) {
                QLog.e("DoutuEmotionAdapter", 2, "addSmartPicList key:" + j3 + ", timeKey:" + this.L);
                return;
            }
            return;
        }
        if (this.f356026d != null && this.f356027e != null && list != null) {
            int size = list.size();
            int i3 = this.I;
            if (i3 > 0) {
                this.f356027e.addAll(i3, list);
                this.I += list.size();
            }
            int size2 = this.f356026d.size() + size;
            ArrayList arrayList = new ArrayList();
            for (int i16 = 0; i16 < size2 && i16 < this.f356027e.size(); i16++) {
                if (!z16 || this.f356027e.get(i16).picMd5 == null || !this.f356027e.get(i16).picMd5.equalsIgnoreCase("abababababababababababab")) {
                    arrayList.add(this.f356027e.get(i16));
                }
            }
            if (z16) {
                this.f356027e.remove(this.J);
                this.I = -1;
            }
            e(arrayList);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e("DoutuEmotionAdapter", 2, "addSmartPicList list:" + this.f356026d + ", listAll:" + this.f356027e);
        }
    }

    public void c(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, j3);
            return;
        }
        if (j3 != this.L) {
            if (QLog.isColorLevel()) {
                QLog.e("DoutuEmotionAdapter", 2, "removeLoading key:" + j3 + ", timeKey:" + this.L);
                return;
            }
            return;
        }
        List<DoutuData> list = this.f356026d;
        if (list != null && this.f356027e != null) {
            int size = list.size();
            this.f356027e.remove(this.J);
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < size && i3 < this.f356027e.size(); i3++) {
                arrayList.add(this.f356027e.get(i3));
            }
            e(arrayList);
        }
        this.I = -1;
    }

    public void d() {
        List<DoutuData> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("DoutuEmotionAdapter", 2, "[doutu]resetData");
        }
        List<DoutuData> list2 = this.f356026d;
        if (list2 == null) {
            this.f356026d = new ArrayList();
        } else {
            list2.clear();
        }
        List<DoutuData> list3 = this.f356027e;
        int i3 = 0;
        if (list3 != null && list3.size() > 0) {
            while (i3 < R && i3 < this.f356027e.size()) {
                this.f356026d.add(this.f356027e.get(i3));
                i3++;
            }
        } else {
            while (i3 < 9) {
                this.f356026d.add(new DoutuData());
                i3++;
            }
        }
        if (this.H && (list = this.f356027e) != null && list.size() > 0) {
            int size = this.f356027e.size();
            int i16 = R;
            if (size < i16) {
                i16 = this.f356027e.size();
            }
            this.I = i16;
            this.f356027e.add(i16, this.J);
            this.f356026d.add(this.I, this.J);
        }
    }

    public void e(List<DoutuData> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (this.f356026d == null) {
            this.f356026d = new ArrayList();
        }
        if (list != null) {
            this.f356026d.clear();
            this.f356026d.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f356026d.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return iPatchRedirector.redirect((short) 4, (Object) this, i3);
        }
        List<DoutuData> list = this.f356026d;
        if (list != null && i3 < list.size()) {
            return this.f356026d.get(i3);
        }
        return null;
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
        C9610b c9610b;
        View view2;
        URL url;
        View view3;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            view4 = (View) iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (i3 >= this.f356026d.size()) {
                QLog.e("DoutuEmotionAdapter", 2, "get view position exception , position = " + i3 + ",size = " + this.f356026d.size());
            } else {
                DoutuData doutuData = this.f356026d.get(i3);
                if (doutuData == null) {
                    QLog.e("DoutuEmotionAdapter", 1, "getView emoticon empty position = " + i3);
                } else {
                    if (view != null && view.getTag() != null) {
                        c9610b = (C9610b) view.getTag();
                        view2 = view;
                    } else {
                        c9610b = new C9610b();
                        Context context = viewGroup.getContext();
                        c9610b.f356033a = new RelativeLayout(context);
                        c9610b.f356033a.setLayoutParams(new ViewGroup.LayoutParams(this.f356028f, this.f356029h));
                        c9610b.f356034b = new URLImageView(context);
                        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f356030i, this.f356031m);
                        layoutParams.addRule(13, -1);
                        c9610b.f356033a.addView(c9610b.f356034b, layoutParams);
                        ProgressBar progressBar = new ProgressBar(context);
                        c9610b.f356035c = progressBar;
                        progressBar.setIndeterminateDrawable(context.getResources().getDrawable(R.drawable.f160545jt));
                        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(ViewUtils.dip2px(30.0f), ViewUtils.dip2px(30.0f));
                        layoutParams2.addRule(13, -1);
                        c9610b.f356033a.addView(c9610b.f356035c, layoutParams2);
                        view2 = c9610b.f356033a;
                        view2.setTag(c9610b);
                    }
                    C9610b c9610b2 = c9610b;
                    c9610b2.f356036d = doutuData;
                    c9610b2.f356037e = i3;
                    c9610b2.f356035c.setVisibility(0);
                    String str = doutuData.thumbDownUrl;
                    if (str != null) {
                        try {
                            url = new URL(str);
                        } catch (MalformedURLException e16) {
                            QLog.e("DoutuEmotionAdapter", 1, "getView url exception e = " + e16.getMessage());
                            url = null;
                        }
                        if (url == null) {
                            QLog.e("DoutuEmotionAdapter", 1, "getView url = null");
                            view3 = view2;
                            view4 = null;
                        } else {
                            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                            ColorDrawable colorDrawable = this.F;
                            obtain.mLoadingDrawable = colorDrawable;
                            obtain.mFailedDrawable = colorDrawable;
                            obtain.mPlayGifImage = true;
                            obtain.mExtraInfo = doutuData;
                            URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
                            if (drawable.getStatus() != 1) {
                                drawable.setTag(doutuData);
                                AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                if (peekAppRuntime != null) {
                                    drawable.addHeader("my_uin", peekAppRuntime.getAccount());
                                } else {
                                    QLog.e("DoutuEmotionAdapter", 1, "[getView] urldrawable add my uin header error, app is null!");
                                }
                                if (drawable.getStatus() == 2 || drawable.getStatus() == 3) {
                                    drawable.restartDownload();
                                }
                            } else {
                                c9610b2.f356035c.setVisibility(4);
                                if (this.M == null) {
                                    this.M = new HashMap<>();
                                }
                                this.M.put(doutuData.picMd5, doutuData.picDownUrl);
                            }
                            c9610b2.f356034b.setImageDrawable(drawable);
                            c9610b2.f356034b.setURLDrawableDownListener(this.Q);
                            c9610b2.f356034b.setTag(c9610b2);
                            c9610b2.f356034b.setFocusable(true);
                            c9610b2.f356034b.setFocusableInTouchMode(true);
                            view2.setOnClickListener(this);
                        }
                    } else {
                        c9610b2.f356034b.setImageDrawable(this.F);
                    }
                    view4 = view2;
                    view3 = view4;
                }
            }
            view3 = view;
            view4 = null;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view4;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C9610b c9610b;
        DoutuData doutuData;
        URLDrawable uRLDrawable;
        File fileInLocal;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) view);
        } else {
            Object tag = view.getTag();
            if (tag != null && (tag instanceof C9610b)) {
                c9610b = (C9610b) tag;
            } else {
                c9610b = null;
            }
            if (c9610b != null && (doutuData = c9610b.f356036d) != null && doutuData.thumbDownUrl != null && (uRLDrawable = (URLDrawable) c9610b.f356034b.getDrawable()) != null && (fileInLocal = uRLDrawable.getFileInLocal()) != null) {
                String path = fileInLocal.getPath();
                g gVar = this.P;
                if (gVar != null) {
                    gVar.a(path, this.C, this.D, this.E, doutuData);
                }
                ((IReportControllerApi) com.tencent.qqnt.aio.adapter.a.b(IReportControllerApi.class)).reportWith898(null, "", "", "0X800B54A", "0X800B54A", 0, 0, "", "", "", "");
                com.tencent.mobileqq.temp.report.a.a(MobileQQ.sMobileQQ.peekAppRuntime(), "dc00898", "", "", "0X8007FAB", "0X8007FAB", 0, 0, "", String.valueOf(c9610b.f356037e + 1), doutuData.picMd5, doutuData.picDownUrl);
                this.N = doutuData;
                MqqHandler mqqHandler = this.G;
                if (mqqHandler != null) {
                    mqqHandler.obtainMessage(82).sendToTarget();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }
}
