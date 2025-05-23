package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.profilecard.api.IProfileCardConst;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.troop.activity.TroopAvatarWallPreviewActivity;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class g extends BaseAdapter {
    static IPatchRedirector $redirector_;
    Setting C;
    boolean D;
    boolean E;
    WeakReference<TextView> F;
    int G;
    int H;
    float I;
    float J;
    boolean K;
    boolean L;
    ArrayList<Integer> M;
    protected List<String> N;
    protected List<String> P;

    /* renamed from: d, reason: collision with root package name */
    Context f302526d;

    /* renamed from: e, reason: collision with root package name */
    int f302527e;

    /* renamed from: f, reason: collision with root package name */
    QQAppInterface f302528f;

    /* renamed from: h, reason: collision with root package name */
    String f302529h;

    /* renamed from: i, reason: collision with root package name */
    boolean f302530i;

    /* renamed from: m, reason: collision with root package name */
    String f302531m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageProgressCircle f302532d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLImageView f302533e;

        a(ImageProgressCircle imageProgressCircle, URLImageView uRLImageView) {
            this.f302532d = imageProgressCircle;
            this.f302533e = uRLImageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, g.this, imageProgressCircle, uRLImageView);
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                str = uRLDrawable.getURL().toString();
            } else {
                str = "";
            }
            String str2 = str;
            QLog.e("TroopAvatarBigPhotoAdapter", 1, "onLoadCancelled urlStr : " + str2);
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_cancel", 0, 1, 0, str2, "", "", "");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
                return;
            }
            String str2 = "";
            if (uRLDrawable == null || uRLDrawable.getURL() == null) {
                str = "";
            } else {
                str = uRLDrawable.getURL().toString();
            }
            if (th5 != null) {
                str2 = th5.getMessage();
            }
            String str3 = str2;
            QLog.e("TroopAvatarBigPhotoAdapter", 1, "onLoadFailed urlStr : " + str + "; errorMsg : " + str3);
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_failed", 0, 1, 0, str, str3, "", "");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, this, view, uRLDrawable, interruptedException);
                return;
            }
            String str2 = "";
            if (uRLDrawable == null || uRLDrawable.getURL() == null) {
                str = "";
            } else {
                str = uRLDrawable.getURL().toString();
            }
            if (interruptedException != null) {
                str2 = interruptedException.getMessage();
            }
            String str3 = str2;
            QLog.e("TroopAvatarBigPhotoAdapter", 1, "onLoadInterrupted urlStr : " + str + "; errorMsg : " + str3);
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_interrupt", 0, 1, 0, str, str3, "", "");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, Integer.valueOf(i3));
                return;
            }
            if (this.f302532d.getVisibility() != 0) {
                this.f302532d.setVisibility(0);
            }
            this.f302532d.setProgress(i3 / 100);
            WeakReference<TextView> weakReference = g.this.F;
            if (weakReference != null && weakReference.get() != null) {
                g.this.F.get().setText(this.f302532d.a());
            }
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            g.this.g(this.f302532d);
            this.f302533e.setImageDrawable(uRLDrawable);
            if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                str = uRLDrawable.getURL().toString();
            } else {
                str = "";
            }
            String str2 = str;
            WeakReference<TextView> weakReference = g.this.F;
            if (weakReference != null && weakReference.get() != null) {
                g.this.F.get().setVisibility(8);
            }
            g gVar = g.this;
            gVar.F = null;
            gVar.E = false;
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", LibraTraceConst.Node.IMAGE_LOAD_SUCCESS, 0, 1, 0, str2, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        URLImageView f302535a;

        /* renamed from: b, reason: collision with root package name */
        ImageProgressCircle f302536b;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) g.this);
            }
        }
    }

    public g(Context context, QQAppInterface qQAppInterface) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) context, (Object) qQAppInterface);
            return;
        }
        this.f302530i = false;
        this.f302531m = null;
        this.C = null;
        this.D = true;
        this.E = false;
        this.F = null;
        this.f302528f = qQAppInterface;
        this.f302526d = context;
        this.f302527e = (int) context.getResources().getDimension(R.dimen.f159270z3);
    }

    private boolean b(int i3) {
        List<String> list = this.P;
        if (list != null && list.size() > i3 && !TextUtils.isEmpty(this.P.get(i3)) && AbsDownloader.getFile(this.P.get(i3)) != null) {
            return true;
        }
        return false;
    }

    private URL e(URL url) {
        if (!TextUtils.isEmpty(this.f302531m) && TroopAvatarWallPreviewActivity.PUBLIC_ACCOUNT_IMAGE_SID.equals(this.f302531m) && url.getProtocol().startsWith("http")) {
            return ((IPublicAccountHttpDownloader) QRoute.api(IPublicAccountHttpDownloader.class)).makeURL(url.toString(), 2);
        }
        return url;
    }

    void a() {
        int[] iArr = new int[2];
        int intValue = this.M.get(0).intValue();
        int intValue2 = this.M.get(1).intValue();
        int intValue3 = this.M.get(2).intValue();
        int intValue4 = this.M.get(3).intValue();
        this.G = intValue - iArr[0];
        this.H = intValue2 - iArr[1];
        this.I = intValue3 / ViewUtils.getScreenWidth();
        this.J = intValue4 / ViewUtils.getScreenHeight();
        if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarBigPhotoAdapter", 2, "calculateScale()   leftLocation = " + intValue + " topLocation = " + intValue2);
        }
    }

    void c(URLImageView uRLImageView) {
        a();
        uRLImageView.setPivotX(0.0f);
        uRLImageView.setPivotY(0.0f);
        uRLImageView.setScaleX(this.I);
        uRLImageView.setScaleY(this.J);
        uRLImageView.setTranslationX(this.G);
        uRLImageView.setTranslationY(this.H);
        if (QLog.isColorLevel()) {
            QLog.i("TroopAvatarBigPhotoAdapter", 2, "enterAnimation()   mWidthScale = " + this.I + " mHeightScale = " + this.J);
            QLog.i("TroopAvatarBigPhotoAdapter", 2, "enterAnimation()   mLeftDelta = " + this.G + " mTopDelta = " + this.H);
        }
        uRLImageView.animate().setDuration(200L).scaleX(1.0f).scaleY(1.0f).translationX(0.0f).translationY(0.0f).setInterpolator(new DecelerateInterpolator());
    }

    @Override // android.widget.Adapter
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public String getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, i3);
        }
        if (this.N != null && i3 < getCount()) {
            return this.N.get(i3);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(int i3, b bVar) {
        String str;
        String scheme;
        URL url;
        Setting setting;
        String avatarAddress;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, i3, (Object) bVar);
            return;
        }
        if (bVar != null && this.f302528f != null) {
            URLImageView uRLImageView = bVar.f302535a;
            ImageProgressCircle imageProgressCircle = bVar.f302536b;
            String item = getItem(i3);
            if (!this.E && !b(i3)) {
                QLog.d("TroopAvatarBigPhotoAdapter", 2, "load current");
            } else {
                item = this.P.get(i3);
                QLog.d("TroopAvatarBigPhotoAdapter", 2, "load origin");
            }
            if (TextUtils.isEmpty(item)) {
                return;
            }
            try {
                if (!this.f302530i) {
                    ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
                    if (iTroopAvatarUtilApi.isNumeric(item)) {
                        if (item != null && item.equals(com.tencent.mobileqq.troop.avatar.a.f294527k)) {
                            avatarAddress = iTroopAvatarUtilApi.getAvatarAddress(item, this.f302529h, 0);
                        } else {
                            avatarAddress = iTroopAvatarUtilApi.getAvatarAddress(item, this.f302529h, 1);
                        }
                        str = iTroopAvatarUtilApi.getArtWork(avatarAddress);
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopAvatarBigPhotoAdapter", 2, "loadThumbImage() path = " + str);
                        }
                        scheme = Uri.parse(str).getScheme();
                        if (TextUtils.isEmpty(scheme) && (scheme.equals("http") || scheme.equals("https"))) {
                            try {
                                if (this.L) {
                                    url = new URL(IProfileCardConst.PROTOCOL_QZONE_COVER, "original", str);
                                } else {
                                    url = new URL(str);
                                }
                            } catch (MalformedURLException e16) {
                                if (QLog.isColorLevel()) {
                                    QLog.i("TroopAvatarBigPhotoAdapter", 2, e16.toString());
                                    return;
                                }
                                return;
                            }
                        } else {
                            url = new File(str).toURL();
                        }
                        URL e17 = e(url);
                        setting = this.C;
                        if ((setting != null || setting.bHeadType == 0) && item != null && item.equals(com.tencent.mobileqq.troop.avatar.a.f294527k)) {
                            uRLImageView.setImageResource(R.drawable.brp);
                            return;
                        }
                        URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                        obtain.mRequestWidth = this.f302526d.getResources().getDisplayMetrics().widthPixels;
                        obtain.mRequestHeight = this.f302526d.getResources().getDisplayMetrics().heightPixels;
                        obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                        if (this.D) {
                            obtain.mPlayGifImage = true;
                        }
                        uRLImageView.setImageDrawable(URLDrawable.getDrawable(e17, obtain));
                        if (!this.K && this.L && this.M != null) {
                            c(uRLImageView);
                            this.K = true;
                        }
                        if (QLog.isColorLevel()) {
                            QLog.i("TroopAvatarBigPhotoAdapter", 2, "loadBigMap() mWidthScale = " + this.I + " mHeightScale = " + this.J);
                        }
                        g(imageProgressCircle);
                        uRLImageView.setURLDrawableDownListener(new a(imageProgressCircle, uRLImageView));
                        return;
                    }
                }
                url = new File(str).toURL();
                URL e172 = e(url);
                setting = this.C;
                if (setting != null) {
                }
                uRLImageView.setImageResource(R.drawable.brp);
                return;
            } catch (MalformedURLException e18) {
                if (QLog.isColorLevel()) {
                    QLog.i("TroopAvatarBigPhotoAdapter", 2, e18.toString());
                    return;
                }
                return;
            }
            str = item;
            if (QLog.isColorLevel()) {
            }
            scheme = Uri.parse(str).getScheme();
            if (TextUtils.isEmpty(scheme)) {
            }
        }
    }

    public void g(ImageProgressCircle imageProgressCircle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) imageProgressCircle);
        } else if (imageProgressCircle != null && imageProgressCircle.getVisibility() != 4) {
            imageProgressCircle.setVisibility(4);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this)).intValue();
        }
        List<String> list = this.N;
        if (list != null) {
            return list.size();
        }
        return 0;
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
        b bVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            view2 = (View) iPatchRedirector.redirect((short) 15, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.f167781ha, (ViewGroup) null);
                bVar = new b();
                bVar.f302535a = (URLImageView) view.findViewById(R.id.image);
                bVar.f302536b = (ImageProgressCircle) view.findViewById(R.id.dea);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            g(bVar.f302536b);
            f(i3, bVar);
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, z16);
        } else {
            this.E = z16;
        }
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, z16);
        } else {
            this.L = z16;
        }
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.f302530i = z16;
        }
    }

    public void k(TextView textView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) textView);
        } else {
            this.F = new WeakReference<>(textView);
        }
    }

    public void l(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
        } else {
            this.P = list;
        }
    }

    public void m(ArrayList<Integer> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) arrayList);
        } else {
            this.M = arrayList;
        }
    }

    public void n(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
        } else {
            this.N = list;
        }
    }

    public void o(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f302531m = str;
        }
    }

    public void p(String str, Setting setting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) setting);
        } else {
            this.f302529h = str;
            this.C = setting;
        }
    }

    public void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.D = z16;
        }
    }
}
