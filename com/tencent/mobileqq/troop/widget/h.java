package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.libra.trace.LibraTraceConst;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.avatar.TroopUploadingThread;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.troop.widget.AvatarGridAdapter;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Gallery;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes19.dex */
public class h extends BaseAdapter implements DecodeTaskCompletionListener {
    static IPatchRedirector $redirector_;
    boolean C;
    String D;
    boolean E;
    boolean F;
    boolean G;
    protected int H;
    protected int I;
    protected int J;
    protected int K;
    boolean L;
    protected Bitmap M;
    protected IFaceDecoder N;
    protected List<com.tencent.mobileqq.troop.avatar.a> P;

    /* renamed from: d, reason: collision with root package name */
    Context f302538d;

    /* renamed from: e, reason: collision with root package name */
    Gallery f302539e;

    /* renamed from: f, reason: collision with root package name */
    String f302540f;

    /* renamed from: h, reason: collision with root package name */
    Setting f302541h;

    /* renamed from: i, reason: collision with root package name */
    int f302542i;

    /* renamed from: m, reason: collision with root package name */
    QQAppInterface f302543m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class a implements URLDrawableDownListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ImageProgressCircle f302544d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ URLImageView f302545e;

        a(ImageProgressCircle imageProgressCircle, URLImageView uRLImageView) {
            this.f302544d = imageProgressCircle;
            this.f302545e = uRLImageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, h.this, imageProgressCircle, uRLImageView);
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
            if (QLog.isColorLevel()) {
                QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("onLoadCancelled ", new Object[0]));
            }
            if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                str = uRLDrawable.getURL().toString();
            } else {
                str = "";
            }
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_cancel", 0, 1, 0, str, "", "", "");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, view, uRLDrawable, th5);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("onLoadFailed ", new Object[0]));
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
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_failed", 0, 1, 0, str, str2, "", "");
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
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", "load_interrupt", 0, 1, 0, str, str2, "", "");
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, this, view, uRLDrawable, Integer.valueOf(i3));
                return;
            }
            if (this.f302544d.getVisibility() != 0) {
                this.f302544d.setVisibility(0);
            }
            this.f302544d.setProgress(i3 / 100);
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) view, (Object) uRLDrawable);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("onLoadSuccessed ", new Object[0]));
            }
            h.this.f(this.f302544d);
            this.f302545e.setImageDrawable(uRLDrawable);
            if (uRLDrawable != null && uRLDrawable.getURL() != null) {
                str = uRLDrawable.getURL().toString();
            } else {
                str = "";
            }
            ReportController.n(null, "dc00899", "BizTechReport", "", "Grp_avatar", LibraTraceConst.Node.IMAGE_LOAD_SUCCESS, 0, 1, 0, str, "", "", "");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        URLImageView f302547a;

        /* renamed from: b, reason: collision with root package name */
        ImageProgressCircle f302548b;

        /* renamed from: c, reason: collision with root package name */
        com.tencent.mobileqq.troop.avatar.a f302549c;

        protected b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) h.this);
            }
        }
    }

    public h(Context context, QQAppInterface qQAppInterface, String str, int i3, int i16, Gallery gallery) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, qQAppInterface, str, Integer.valueOf(i3), Integer.valueOf(i16), gallery);
            return;
        }
        this.C = false;
        this.D = null;
        this.E = true;
        this.F = true;
        this.G = false;
        this.L = false;
        this.M = null;
        this.P = new ArrayList(7);
        this.f302543m = qQAppInterface;
        this.f302538d = context;
        this.f302540f = str;
        this.f302539e = gallery;
        this.f302542i = (int) context.getResources().getDimension(R.dimen.f159270z3);
        this.H = i3;
        this.I = i16;
        IFaceDecoder iQQAvatarService = ((IQQAvatarService) qQAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(qQAppInterface);
        this.N = iQQAvatarService;
        iQQAvatarService.setDecodeTaskCompletionListener(this);
    }

    @Override // android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.tencent.mobileqq.troop.avatar.a getItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (com.tencent.mobileqq.troop.avatar.a) iPatchRedirector.redirect((short) 10, (Object) this, i3);
        }
        if (this.P != null && i3 < getCount()) {
            return this.P.get(i3);
        }
        return null;
    }

    public Rect b(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Rect) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        com.tencent.mobileqq.troop.avatar.a item = getItem(i3);
        Rect rect = new Rect();
        if (item != null) {
            ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getClipRect(rect, item.f294536h);
        }
        return rect;
    }

    public String c(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String) iPatchRedirector.redirect((short) 14, (Object) this, i3);
        }
        com.tencent.mobileqq.troop.avatar.a item = getItem(i3);
        if (item == null) {
            return null;
        }
        String str = item.f294530b;
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(item.f294529a)) {
            return null;
        }
        if (this.C) {
            return str;
        }
        ITroopAvatarUtilApi iTroopAvatarUtilApi = (ITroopAvatarUtilApi) QRoute.api(ITroopAvatarUtilApi.class);
        if (item.f294531c == 1 && (item.f294529a == null || !new File(item.f294529a).exists())) {
            return iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(item.f294530b, this.f302540f, 1));
        }
        if (item.f294531c != 2 && (item.f294529a == null || !new File(item.f294529a).exists())) {
            if (item.f294531c != 3) {
                return null;
            }
            return iTroopAvatarUtilApi.getArtWork(iTroopAvatarUtilApi.getAvatarAddress(item.f294530b, this.f302540f, 0));
        }
        return item.f294529a;
    }

    public void d(int i3, b bVar) {
        URL uRL4TroopPhoto;
        com.tencent.mobileqq.troop.avatar.a item;
        URLDrawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, i3, (Object) bVar);
            return;
        }
        if (bVar != null && this.f302543m != null) {
            URLImageView uRLImageView = bVar.f302547a;
            ImageProgressCircle imageProgressCircle = bVar.f302548b;
            String c16 = c(i3);
            Rect b16 = b(i3);
            if (QLog.isColorLevel()) {
                QLog.i("TroopAvatarWallGalleryAdapter", 2, "loadBigImage loadThumbImage() path = " + c16);
            }
            if (TextUtils.isEmpty(c16) || (uRL4TroopPhoto = ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getURL4TroopPhoto(c16)) == null || (item = getItem(i3)) == null) {
                return;
            }
            String str = item.f294530b;
            Setting setting = this.f302541h;
            if ((setting == null || setting.bHeadType == 0) && com.tencent.mobileqq.troop.avatar.a.f294527k.equals(str) && !this.L) {
                this.L = true;
                if (!this.N.isPausing()) {
                    this.N.requestDecodeFace(this.f302540f, 4, true);
                }
            }
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
            if (this.G && this.F) {
                obtain.mRequestWidth = -1;
                obtain.mRequestHeight = -1;
                drawable = URLDrawable.getDrawable(uRL4TroopPhoto, obtain);
                drawable.setTag(com.tencent.mobileqq.urldrawable.a.b(b16.left, b16.top, b16.width(), b16.height(), this.H, this.I));
                drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306344x);
            } else if (!this.F) {
                drawable = URLDrawable.getDrawable(uRL4TroopPhoto, obtain);
                int min = Math.min(this.J, this.K);
                if (SimpleUIUtil.getSimpleUISwitch()) {
                    drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306330j);
                    drawable.setTag(new int[]{min, min, (int) (min * 0.071428575f)});
                } else {
                    drawable.setTag(com.tencent.mobileqq.urldrawable.a.d(min, min));
                    drawable.setDecodeHandler(com.tencent.mobileqq.urldrawable.a.f306323c);
                }
                uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else {
                obtain.mRequestWidth = this.H;
                obtain.mRequestHeight = this.I;
                drawable = URLDrawable.getDrawable(uRL4TroopPhoto, obtain);
                drawable.setDecodeHandler(null);
                uRLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
            uRLImageView.setImageDrawable(drawable);
            if (drawable.getStatus() != 1) {
                if (imageProgressCircle.getVisibility() != 0) {
                    imageProgressCircle.setVisibility(0);
                }
                imageProgressCircle.setProgress(0);
                uRLImageView.setURLDrawableDownListener(new a(imageProgressCircle, uRLImageView));
                return;
            }
            f(imageProgressCircle);
        }
    }

    public void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            this.N.destory();
        }
    }

    public void f(ImageProgressCircle imageProgressCircle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) imageProgressCircle);
        } else if (imageProgressCircle != null && imageProgressCircle.getVisibility() != 4) {
            imageProgressCircle.setVisibility(4);
        }
    }

    public void g(List<com.tencent.mobileqq.troop.avatar.a> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            return;
        }
        if (com.tencent.mobileqq.troop.avatar.a.a(list, this.P)) {
            if (QLog.isColorLevel()) {
                QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList equal return", new Object[0]));
            }
        } else {
            if (QLog.isColorLevel()) {
                QLog.i("TroopAvatarWallGalleryAdapter", 2, String.format("setAvatarList %s", Arrays.deepToString(list.toArray())));
            }
            this.P.clear();
            this.P.addAll(list);
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        List<com.tencent.mobileqq.troop.avatar.a> list = this.P;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Long) iPatchRedirector.redirect((short) 15, (Object) this, i3)).longValue();
        }
        return i3;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        b bVar;
        View view2;
        View view3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            view2 = (View) iPatchRedirector.redirect((short) 16, this, Integer.valueOf(i3), view, viewGroup);
            view3 = view;
        } else {
            if (view == null) {
                view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.c1d, (ViewGroup) null);
                bVar = new b();
                URLImageView uRLImageView = (URLImageView) view.findViewById(R.id.image);
                bVar.f302547a = uRLImageView;
                uRLImageView.setLayoutParams(new RelativeLayout.LayoutParams(this.H, this.I));
                bVar.f302548b = (ImageProgressCircle) view.findViewById(R.id.dea);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            d(i3, bVar);
            bVar.f302549c = getItem(i3);
            bVar.f302547a.setContentDescription(HardCodeUtil.qqStr(R.string.ubh) + (i3 + 1));
            view2 = view;
            view3 = view2;
        }
        EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
        return view2;
    }

    public void h(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.F = z16;
        }
    }

    public void i(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            this.G = z16;
        }
    }

    public void j(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }

    public void k(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Integer.valueOf(i16));
        } else {
            this.J = i3;
            this.K = i16;
        }
    }

    public void l(Setting setting) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) setting);
        } else {
            this.f302541h = setting;
            notifyDataSetChanged();
        }
    }

    public void m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.D = str;
        }
    }

    public void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        } else {
            this.E = z16;
        }
    }

    public void o(com.tencent.mobileqq.troop.avatar.a aVar, TroopUploadingThread.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) aVar, (Object) bVar);
            return;
        }
        for (int i3 = 0; i3 < this.f302539e.getChildCount(); i3++) {
            Object tag = this.f302539e.getChildAt(i3).getTag();
            if (tag != null && (tag instanceof AvatarGridAdapter.a)) {
                b bVar2 = (b) tag;
                if (bVar2.f302549c.equals(aVar)) {
                    if (!aVar.f294533e) {
                        bVar2.f302548b.setVisibility(8);
                    } else {
                        bVar2.f302548b.setProgress(bVar.f294521b);
                    }
                }
            }
        }
    }

    @Override // com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener
    public void onDecodeTaskCompleted(int i3, int i16, String str, Bitmap bitmap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Integer.valueOf(i3), Integer.valueOf(i16), str, bitmap);
        } else {
            notifyDataSetChanged();
        }
    }
}
