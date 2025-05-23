package com.tencent.mobileqq.comment.danmaku.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.danmaku.data.ViewDanmaku;
import com.tencent.common.danmaku.render.j;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.armap.e;
import com.tencent.mobileqq.armap.f;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmediabrowser.api.ICommentDanmakuDepend;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.util.x;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a extends j {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private Context f201786c;

    /* renamed from: d, reason: collision with root package name */
    private int f201787d;

    /* renamed from: e, reason: collision with root package name */
    private Bitmap f201788e;

    /* renamed from: f, reason: collision with root package name */
    private BitmapDrawable f201789f;

    /* renamed from: g, reason: collision with root package name */
    private f f201790g;

    /* renamed from: h, reason: collision with root package name */
    private ConcurrentHashMap<String, List<d>> f201791h;

    /* renamed from: i, reason: collision with root package name */
    private int f201792i;

    /* renamed from: j, reason: collision with root package name */
    private String f201793j;

    /* renamed from: k, reason: collision with root package name */
    private ViewGroup.LayoutParams f201794k;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.comment.danmaku.view.a$a, reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C7464a implements e {
        static IPatchRedirector $redirector_;

        C7464a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.armap.e
        public void h(String str, String str2, Bitmap bitmap) {
            RoundImageView roundImageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, bitmap);
                return;
            }
            List<d> list = (List) a.this.f201791h.get(str);
            if (list != null && list.size() > 0) {
                for (d dVar : list) {
                    if (dVar != null && (roundImageView = dVar.f201803a) != null && dVar.f201804b != null) {
                        roundImageView.setImageBitmap(bitmap);
                        dVar.f201804b.l0(true);
                    }
                }
            }
            a.this.f201791h.remove(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class b implements URLDrawable.URLDrawableListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ RoundImageView f201796d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ViewDanmaku f201797e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ String f201798f;

        b(RoundImageView roundImageView, ViewDanmaku viewDanmaku, String str) {
            this.f201796d = roundImageView;
            this.f201797e = viewDanmaku;
            this.f201798f = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, roundImageView, viewDanmaku, str);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadCanceled(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uRLDrawable);
            } else if (QLog.isColorLevel()) {
                QLog.d("CommentDanmakuRender", 2, "onLoadCanceled : " + this.f201798f);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadFialed(URLDrawable uRLDrawable, Throwable th5) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) uRLDrawable, (Object) th5);
            } else if (QLog.isColorLevel()) {
                QLog.d("CommentDanmakuRender", 2, "onLoadFailed : " + this.f201798f);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadProgressed(URLDrawable uRLDrawable, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uRLDrawable, i3);
            }
        }

        @Override // com.tencent.image.URLDrawable.URLDrawableListener
        public void onLoadSuccessed(URLDrawable uRLDrawable) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) uRLDrawable);
            } else if (uRLDrawable != null) {
                this.f201796d.setImageDrawable(uRLDrawable);
                this.f201797e.l0(true);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private class c extends j.a {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        public RoundImageView f201800d;

        /* renamed from: e, reason: collision with root package name */
        public TextView f201801e;

        public c(View view) {
            super(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) view);
            } else {
                this.f201800d = (RoundImageView) view.findViewById(R.id.icon);
                this.f201801e = (TextView) view.findViewById(R.id.b2y);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class d {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public RoundImageView f201803a;

        /* renamed from: b, reason: collision with root package name */
        public ViewDanmaku f201804b;

        public d(RoundImageView roundImageView, ViewDanmaku viewDanmaku) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, a.this, roundImageView, viewDanmaku);
            } else {
                this.f201803a = roundImageView;
                this.f201804b = viewDanmaku;
            }
        }
    }

    public a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.f201786c = context;
        this.f201787d = Color.parseColor("#00CAFC");
        Bitmap defaultFaceBitmap = BaseImageUtil.getDefaultFaceBitmap();
        this.f201788e = defaultFaceBitmap;
        if (defaultFaceBitmap != null) {
            this.f201789f = new BitmapDrawable(this.f201786c.getResources(), this.f201788e);
        }
        this.f201792i = ((ICommentDanmakuDepend) QRoute.api(ICommentDanmakuDepend.class)).getChatEmotionSizeWithDP();
        this.f201791h = new ConcurrentHashMap<>();
        this.f201793j = MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
        this.f201794k = new ViewGroup.LayoutParams(-2, x.c(context, 21.0f));
        o();
    }

    private void o() {
        f nonMainAppHeadLoader = ((IQQNonMainProcAvatarLoaderApi) QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.f201786c, 1);
        this.f201790g = nonMainAppHeadLoader;
        nonMainAppHeadLoader.init();
        this.f201790g.a(new C7464a());
    }

    private boolean p(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f201793j) && str.equals(this.f201793j)) {
            return true;
        }
        return false;
    }

    private void q(com.tencent.mobileqq.comment.danmaku.data.a aVar, RoundImageView roundImageView, ViewDanmaku viewDanmaku) {
        if (aVar.f201783g) {
            String anonymousHeadUrl = ((ICommentDanmakuDepend) QRoute.api(ICommentDanmakuDepend.class)).getAnonymousHeadUrl(aVar.f201785i);
            URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
            BitmapDrawable bitmapDrawable = this.f201789f;
            obtain.mLoadingDrawable = bitmapDrawable;
            obtain.mFailedDrawable = bitmapDrawable;
            URLDrawable drawable = URLDrawable.getDrawable(anonymousHeadUrl, obtain);
            if (drawable != null) {
                if (drawable.getStatus() == 1) {
                    roundImageView.setImageDrawable(drawable);
                    return;
                } else {
                    drawable.setURLDrawableListener(new b(roundImageView, viewDanmaku, anonymousHeadUrl));
                    drawable.startDownload();
                    return;
                }
            }
            return;
        }
        List<d> list = this.f201791h.get(aVar.f201778b);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(new d(roundImageView, viewDanmaku));
        this.f201791h.put(aVar.f201778b, list);
        roundImageView.setImageBitmap(this.f201790g.b(aVar.f201778b, true));
    }

    @Override // com.tencent.common.danmaku.render.a
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        f fVar = this.f201790g;
        if (fVar != null) {
            fVar.destroy();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.common.danmaku.render.j
    public void j(int i3, j.a aVar, ViewDanmaku viewDanmaku) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), aVar, viewDanmaku);
            return;
        }
        if (viewDanmaku != null && (viewDanmaku.l() instanceof com.tencent.mobileqq.comment.danmaku.data.a) && (aVar instanceof c)) {
            com.tencent.mobileqq.comment.danmaku.data.a aVar2 = (com.tencent.mobileqq.comment.danmaku.data.a) viewDanmaku.l();
            c cVar = (c) aVar;
            cVar.f201801e.setText(new QQText(aVar2.a(), 3, this.f201792i));
            TextView textView = cVar.f201801e;
            if (p(aVar2.f201778b)) {
                i16 = this.f201787d;
            } else {
                i16 = -1;
            }
            textView.setTextColor(i16);
            cVar.f201801e.setAlpha(0.85f);
            q(aVar2, cVar.f201800d, viewDanmaku);
        }
    }

    @Override // com.tencent.common.danmaku.render.j
    public j.a k(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (j.a) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        View inflate = LayoutInflater.from(this.f201786c).inflate(R.layout.hnk, (ViewGroup) null);
        inflate.setLayoutParams(this.f201794k);
        return new c(inflate);
    }
}
