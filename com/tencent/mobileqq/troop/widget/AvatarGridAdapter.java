package com.tencent.mobileqq.troop.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.x;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes19.dex */
public class AvatarGridAdapter extends BaseAdapter implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    public static String M;
    public boolean C;
    protected QQAppInterface D;
    protected String E;
    protected int F;
    protected int G;
    protected boolean H;
    protected boolean I;
    protected String J;
    protected IFaceDecoder K;
    protected GridView L;

    /* renamed from: d, reason: collision with root package name */
    protected Handler f302256d;

    /* renamed from: e, reason: collision with root package name */
    protected WeakReference<Activity> f302257e;

    /* renamed from: f, reason: collision with root package name */
    protected List<com.tencent.mobileqq.troop.avatar.a> f302258f;

    /* renamed from: h, reason: collision with root package name */
    protected int f302259h;

    /* renamed from: i, reason: collision with root package name */
    protected boolean f302260i;

    /* renamed from: m, reason: collision with root package name */
    protected boolean f302261m;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        ImageView f302264a;

        /* renamed from: b, reason: collision with root package name */
        ProgressBar f302265b;

        /* renamed from: c, reason: collision with root package name */
        BorderURLImageView f302266c;

        /* renamed from: d, reason: collision with root package name */
        View f302267d;

        /* renamed from: e, reason: collision with root package name */
        com.tencent.mobileqq.troop.avatar.a f302268e;

        protected a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) AvatarGridAdapter.this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(76815);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 19)) {
            redirector.redirect((short) 19);
        } else {
            M = "AvatarGridAdapter";
        }
    }

    public AvatarGridAdapter(WeakReference<Activity> weakReference, GridView gridView, QQAppInterface qQAppInterface, String str, boolean z16, boolean z17, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, weakReference, gridView, qQAppInterface, str, Boolean.valueOf(z16), Boolean.valueOf(z17), str2);
            return;
        }
        this.f302256d = new Handler(Looper.getMainLooper());
        this.f302258f = new ArrayList(8);
        this.f302260i = false;
        this.f302261m = true;
        this.C = false;
        this.I = false;
        this.K = null;
        this.f302257e = weakReference;
        this.L = gridView;
        this.D = qQAppInterface;
        this.E = str;
        this.J = str2;
        this.H = z16;
        g(z17);
        if (weakReference != null && weakReference.get() != null && qQAppInterface != null) {
            Activity activity = weakReference.get();
            IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
            this.K = iQQAvatarService;
            iQQAvatarService.setDecodeTaskCompletionListener(this);
            Resources resources = activity.getResources();
            activity.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.abj);
            this.F = b(weakReference.get());
            this.G = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getScaledCoverHeight(this.F);
            gridView.setColumnWidth(this.F);
            gridView.setVerticalSpacing(dimensionPixelSize);
            gridView.setHorizontalSpacing(dimensionPixelSize);
            gridView.setAdapter((ListAdapter) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.e(M, 2, "AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
        }
        throw new NullPointerException("AvatarWallAdapter Construct error, Activity or QQAppInterface is null !!!!");
    }

    protected void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.C && this.f302258f.size() >= 0 && this.f302258f.size() < 7) {
            com.tencent.mobileqq.troop.avatar.a aVar = new com.tencent.mobileqq.troop.avatar.a();
            aVar.f294531c = 4;
            this.f302258f.add(aVar);
        }
    }

    public int b(Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity)).intValue();
        }
        int dimensionPixelSize = activity.getResources().getDimensionPixelSize(R.dimen.abj);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return ((displayMetrics.widthPixels - (this.f302257e.get().getResources().getDimensionPixelSize(R.dimen.abm) * 2)) - (dimensionPixelSize * 3)) / 4;
    }

    @Override // android.widget.Adapter
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.avatar.a getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (com.tencent.mobileqq.troop.avatar.a) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        if (this.f302258f != null && i3 < getCount() && i3 >= 0) {
            return this.f302258f.get(i3);
        }
        return null;
    }

    public Rect d(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Rect) iPatchRedirector.redirect((short) 15, (Object) this, i3);
        }
        com.tencent.mobileqq.troop.avatar.a item = getItem(i3);
        Rect rect = new Rect();
        if (item != null) {
            ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getClipRect(rect, item.f294536h);
        }
        return rect;
    }

    public void e(int i3) {
        Activity activity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3);
            return;
        }
        if (i3 != this.L.getNumColumns()) {
            ViewGroup.LayoutParams layoutParams = this.L.getLayoutParams();
            layoutParams.width = (this.L.getRequestedColumnWidth() * i3) + ((i3 - 1) * this.L.getVerticalSpacing()) + this.L.getPaddingLeft() + this.L.getPaddingRight();
            layoutParams.height = -2;
            if (layoutParams instanceof RelativeLayout.LayoutParams) {
                ((RelativeLayout.LayoutParams) layoutParams).addRule(14);
            } else if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).gravity = 1;
            }
            WeakReference<Activity> weakReference = this.f302257e;
            if (weakReference == null) {
                activity = null;
            } else {
                activity = weakReference.get();
            }
            if (activity != null && Thread.currentThread() != activity.getMainLooper().getThread()) {
                activity.runOnUiThread(new Runnable(i3, layoutParams) { // from class: com.tencent.mobileqq.troop.widget.AvatarGridAdapter.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ int f302262d;

                    /* renamed from: e, reason: collision with root package name */
                    final /* synthetic */ ViewGroup.LayoutParams f302263e;

                    {
                        this.f302262d = i3;
                        this.f302263e = layoutParams;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, this, AvatarGridAdapter.this, Integer.valueOf(i3), layoutParams);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            AvatarGridAdapter.this.L.setNumColumns(this.f302262d);
                            AvatarGridAdapter.this.L.setLayoutParams(this.f302263e);
                        }
                    }
                });
            } else {
                this.L.setNumColumns(i3);
                this.L.setLayoutParams(layoutParams);
            }
        }
    }

    public void f(List<com.tencent.mobileqq.troop.avatar.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            return;
        }
        if (this.I) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(M, 2, String.format("updateDataSet %s", Arrays.deepToString(list.toArray())));
        }
        this.f302258f.clear();
        this.f302258f.addAll(list);
        a();
        notifyDataSetChanged();
    }

    public void g(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        List<com.tencent.mobileqq.troop.avatar.a> list = this.f302258f;
        if (list != null) {
            i3 = list.size();
        } else {
            i3 = 0;
        }
        int i16 = 4;
        if (i3 < 4) {
            i16 = i3;
        }
        e(i16);
        return i3;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Long) iPatchRedirector.redirect((short) 14, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        Activity activity;
        View view2;
        View view3;
        a aVar;
        String str;
        View view4;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            view3 = (View) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), view, viewGroup);
            view4 = view;
        } else {
            WeakReference<Activity> weakReference = this.f302257e;
            String str2 = null;
            if (weakReference != null) {
                activity = weakReference.get();
            } else {
                activity = null;
            }
            if (view == null) {
                if (activity == null) {
                    view3 = view;
                    view4 = view3;
                } else {
                    view2 = LayoutInflater.from(activity).inflate(R.layout.a1c, (ViewGroup) null);
                }
            } else {
                view2 = view;
            }
            com.tencent.mobileqq.troop.avatar.a item = getItem(i3);
            if (item != null) {
                int i16 = item.f294531c;
                ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
                if (i16 != 4) {
                    if (i16 == 1 && (item.f294529a == null || !new File(item.f294529a).exists())) {
                        str = iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(item.f294530b, this.E, 1));
                    } else if (i16 != 2 && (item.f294529a == null || !new File(item.f294529a).exists())) {
                        if (i16 == 3) {
                            str = iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(item.f294530b, this.E, 0));
                        }
                    } else {
                        str = item.f294529a;
                    }
                    str2 = str;
                }
                if (view2.getTag() == null) {
                    aVar = new a();
                    aVar.f302264a = (ImageView) view2.findViewById(R.id.f163995gd);
                    ProgressBar progressBar = (ProgressBar) view2.findViewById(R.id.dea);
                    aVar.f302265b = progressBar;
                    if (activity != null) {
                        try {
                            progressBar.setProgressDrawable(activity.getResources().getDrawable(R.drawable.f161534a60));
                        } catch (OutOfMemoryError e16) {
                            if (QLog.isColorLevel()) {
                                QLog.e(M, 2, e16, new Object[0]);
                            }
                        }
                    }
                    aVar.f302266c = (BorderURLImageView) view2.findViewById(R.id.dce);
                    AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) view2.getLayoutParams();
                    if (layoutParams == null) {
                        layoutParams = new AbsListView.LayoutParams(this.F, this.G);
                    } else {
                        ((ViewGroup.LayoutParams) layoutParams).height = this.G;
                        ((ViewGroup.LayoutParams) layoutParams).width = this.F;
                    }
                    aVar.f302268e = item;
                    view2.setLayoutParams(layoutParams);
                    view2.setTag(aVar);
                } else {
                    aVar = (a) view2.getTag();
                    aVar.f302268e = item;
                }
                a aVar2 = aVar;
                if (activity != null) {
                    view2.setContentDescription(HardCodeUtil.qqStr(R.string.jui) + i3);
                    if (i16 == 4) {
                        view2.setContentDescription(HardCodeUtil.qqStr(R.string.juh));
                    }
                    i(aVar2, activity, i16, str2, i3, item.f294535g);
                }
                ProgressBar progressBar2 = aVar2.f302265b;
                if (item.f294533e) {
                    if (progressBar2.getVisibility() != 0) {
                        progressBar2.setVisibility(0);
                    }
                    progressBar2.setProgress(item.f294532d);
                    progressBar2.setProgress(100);
                } else {
                    progressBar2.setVisibility(8);
                }
                if (item.f294534f) {
                    if (aVar2.f302267d == null) {
                        aVar2.f302267d = ((ViewStub) view2.findViewById(R.id.knj)).inflate();
                        view2.setTag(aVar2);
                    }
                    aVar2.f302267d.setVisibility(0);
                } else {
                    View view5 = aVar2.f302267d;
                    if (view5 != null) {
                        view5.setVisibility(8);
                    }
                }
                if (this.f302260i && i3 == this.f302259h && !this.f302261m) {
                    view2.setVisibility(8);
                } else {
                    view2.setVisibility(0);
                }
            }
            view3 = view2;
            view4 = view3;
        }
        EventCollector.getInstance().onListGetView(i3, view4, viewGroup, getItemId(i3));
        return view3;
    }

    public void h(com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) aVar, (Object) bVar);
            return;
        }
        for (int i3 = 0; i3 < this.L.getChildCount(); i3++) {
            Object tag = this.L.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof a)) {
                a aVar2 = (a) tag;
                if (aVar2.f302268e.equals(aVar)) {
                    if (!aVar.f294533e) {
                        aVar2.f302265b.setVisibility(8);
                    } else {
                        aVar2.f302265b.setProgress(bVar.f294521b);
                    }
                }
            }
        }
    }

    protected void i(a aVar, Context context, int i3, String str, int i16, boolean z16) {
        URL uRL4TroopPhoto;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, aVar, context, Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16));
            return;
        }
        BorderURLImageView borderURLImageView = aVar.f302266c;
        borderURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        if (z16) {
            borderURLImageView.setBorderWidth(x.c(context, 2.0f));
            borderURLImageView.setBorderColor(context.getResources().getColor(R.color.a4f));
        } else {
            borderURLImageView.setBorderWidth(0);
        }
        ImageView imageView = aVar.f302264a;
        imageView.setVisibility(8);
        if (i3 == 4) {
            if (borderURLImageView.getDrawable() != null) {
                borderURLImageView.setImageDrawable(null);
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new FrameLayout.LayoutParams(this.F, this.G);
            }
            layoutParams.gravity = 17;
            imageView.setLayoutParams(layoutParams);
            imageView.setVisibility(0);
            return;
        }
        if (str == null || (uRL4TroopPhoto = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(str)) == null) {
            return;
        }
        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
        obtain.mMemoryCacheKeySuffix = "thumb";
        URLDrawable drawable = URLDrawable.getDrawable(uRL4TroopPhoto, obtain);
        Rect d16 = d(i16);
        drawable.setTag(com.tencent.mobileqq.urldrawable.a.b(d16.left, d16.top, d16.width(), d16.height(), this.F, this.G));
        drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306344x);
        borderURLImageView.setImageDrawable(drawable);
        if (QLog.isColorLevel()) {
            QLog.i(M, 2, String.format("viewFactory: FROM_OTHERS, path=" + str, new Object[0]));
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else {
            notifyDataSetChanged();
        }
    }
}
