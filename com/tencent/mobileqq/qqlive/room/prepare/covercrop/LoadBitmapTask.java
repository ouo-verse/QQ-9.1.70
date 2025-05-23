package com.tencent.mobileqq.qqlive.room.prepare.covercrop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.room.widget.PortraitImageView;
import com.tencent.mobileqq.qqlive.room.widget.RegionView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.common.api.AegisLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes17.dex */
public class LoadBitmapTask {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private PortraitImageView f271921a;

    /* renamed from: b, reason: collision with root package name */
    private RegionView f271922b;

    /* renamed from: c, reason: collision with root package name */
    private int f271923c;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.qqlive.room.prepare.covercrop.LoadBitmapTask$1, reason: invalid class name */
    /* loaded from: classes17.dex */
    class AnonymousClass1 implements Runnable {
        static IPatchRedirector $redirector_;
        final /* synthetic */ ViewGroup C;
        final /* synthetic */ ImageView D;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f271924d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f271925e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f271926f;

        /* renamed from: h, reason: collision with root package name */
        final /* synthetic */ int f271927h;

        /* renamed from: i, reason: collision with root package name */
        final /* synthetic */ int f271928i;

        /* renamed from: m, reason: collision with root package name */
        final /* synthetic */ int f271929m;

        AnonymousClass1(Activity activity, String str, int i3, int i16, int i17, int i18, ViewGroup viewGroup, ImageView imageView) {
            this.f271924d = activity;
            this.f271925e = str;
            this.f271926f = i3;
            this.f271927h = i16;
            this.f271928i = i17;
            this.f271929m = i18;
            this.C = viewGroup;
            this.D = imageView;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, LoadBitmapTask.this, activity, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18), viewGroup, imageView);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap bitmap;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            Point point = new Point();
            this.f271924d.getWindowManager().getDefaultDisplay().getSize(point);
            try {
                System.gc();
                bitmap = com.tencent.mobileqq.qqlive.utils.a.INSTANCE.b(this.f271925e, point.x, point.y, true);
            } catch (Exception unused) {
                LoadBitmapTask.this.f271923c = 2;
                bitmap = null;
                ThreadManager.getUIHandler().post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.LoadBitmapTask.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Bitmap f271930d;

                    {
                        this.f271930d = bitmap;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bitmap);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (this.f271930d != null) {
                            int screenWidth = ViewUtils.getScreenWidth();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            int i3 = (screenWidth - anonymousClass1.f271926f) / 2;
                            PortraitImageView portraitImageView = LoadBitmapTask.this.f271921a;
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            portraitImageView.setRestrict(anonymousClass12.f271926f, anonymousClass12.f271927h, i3, 0);
                            LoadBitmapTask.this.f271921a.setImageBitmap(this.f271930d);
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                            LoadBitmapTask loadBitmapTask = LoadBitmapTask.this;
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            Activity activity = anonymousClass13.f271924d;
                            PortraitImageView portraitImageView2 = LoadBitmapTask.this.f271921a;
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            loadBitmapTask.f271922b = new RegionView(activity, portraitImageView2, anonymousClass14.f271926f, anonymousClass14.f271927h, 1, i3, 0);
                            AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                            LoadBitmapTask loadBitmapTask2 = LoadBitmapTask.this;
                            if (anonymousClass15.f271928i == anonymousClass15.f271929m) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            loadBitmapTask2.g(z16);
                            AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                            anonymousClass16.C.addView(LoadBitmapTask.this.f271921a, layoutParams);
                            AnonymousClass1 anonymousClass17 = AnonymousClass1.this;
                            anonymousClass17.C.addView(LoadBitmapTask.this.f271922b, layoutParams);
                            try {
                                Bitmap decodeResource = BitmapFactory.decodeResource(LoadBitmapTask.this.f271922b.getResources(), R.drawable.nmd);
                                AnonymousClass1 anonymousClass18 = AnonymousClass1.this;
                                LoadBitmapTask.this.f271922b.setCropBitmap(Bitmap.createScaledBitmap(decodeResource, anonymousClass18.f271926f, anonymousClass18.f271927h, false));
                                LoadBitmapTask.this.f271921a.setVisibility(0);
                                LoadBitmapTask.this.f271921a.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.LoadBitmapTask.1.1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC83781.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        AnonymousClass1 anonymousClass19 = AnonymousClass1.this;
                                        ImageView imageView = anonymousClass19.D;
                                        if (imageView == null) {
                                            return;
                                        }
                                        imageView.setImageBitmap(LoadBitmapTask.this.f271922b.a());
                                        AnonymousClass1 anonymousClass110 = AnonymousClass1.this;
                                        if (anonymousClass110.f271928i != anonymousClass110.f271929m) {
                                            LoadBitmapTask.this.f271921a.setVisibility(8);
                                        }
                                    }
                                }, 100L);
                                return;
                            } catch (Exception e16) {
                                AegisLogger.e("Open_Live|LoadBitmapTask", "LoadBitmapTask", "e:", e16);
                                return;
                            }
                        }
                        AegisLogger.i("Open_Live|LoadBitmapTask", "LoadBitmapTask", "errorcode:" + LoadBitmapTask.this.f271923c);
                        AnonymousClass1.this.f271924d.finish();
                    }
                });
            } catch (OutOfMemoryError unused2) {
                LoadBitmapTask.this.f271923c = 1;
                bitmap = null;
                ThreadManager.getUIHandler().post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.LoadBitmapTask.1.1
                    static IPatchRedirector $redirector_;

                    /* renamed from: d, reason: collision with root package name */
                    final /* synthetic */ Bitmap f271930d;

                    {
                        this.f271930d = bitmap;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bitmap);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        boolean z16;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                            return;
                        }
                        if (this.f271930d != null) {
                            int screenWidth = ViewUtils.getScreenWidth();
                            AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                            int i3 = (screenWidth - anonymousClass1.f271926f) / 2;
                            PortraitImageView portraitImageView = LoadBitmapTask.this.f271921a;
                            AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                            portraitImageView.setRestrict(anonymousClass12.f271926f, anonymousClass12.f271927h, i3, 0);
                            LoadBitmapTask.this.f271921a.setImageBitmap(this.f271930d);
                            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                            LoadBitmapTask loadBitmapTask = LoadBitmapTask.this;
                            AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                            Activity activity = anonymousClass13.f271924d;
                            PortraitImageView portraitImageView2 = LoadBitmapTask.this.f271921a;
                            AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                            loadBitmapTask.f271922b = new RegionView(activity, portraitImageView2, anonymousClass14.f271926f, anonymousClass14.f271927h, 1, i3, 0);
                            AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                            LoadBitmapTask loadBitmapTask2 = LoadBitmapTask.this;
                            if (anonymousClass15.f271928i == anonymousClass15.f271929m) {
                                z16 = true;
                            } else {
                                z16 = false;
                            }
                            loadBitmapTask2.g(z16);
                            AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                            anonymousClass16.C.addView(LoadBitmapTask.this.f271921a, layoutParams);
                            AnonymousClass1 anonymousClass17 = AnonymousClass1.this;
                            anonymousClass17.C.addView(LoadBitmapTask.this.f271922b, layoutParams);
                            try {
                                Bitmap decodeResource = BitmapFactory.decodeResource(LoadBitmapTask.this.f271922b.getResources(), R.drawable.nmd);
                                AnonymousClass1 anonymousClass18 = AnonymousClass1.this;
                                LoadBitmapTask.this.f271922b.setCropBitmap(Bitmap.createScaledBitmap(decodeResource, anonymousClass18.f271926f, anonymousClass18.f271927h, false));
                                LoadBitmapTask.this.f271921a.setVisibility(0);
                                LoadBitmapTask.this.f271921a.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.LoadBitmapTask.1.1.1
                                    static IPatchRedirector $redirector_;

                                    {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                            iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC83781.this);
                                        }
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        IPatchRedirector iPatchRedirector3 = $redirector_;
                                        if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                            iPatchRedirector3.redirect((short) 2, (Object) this);
                                            return;
                                        }
                                        AnonymousClass1 anonymousClass19 = AnonymousClass1.this;
                                        ImageView imageView = anonymousClass19.D;
                                        if (imageView == null) {
                                            return;
                                        }
                                        imageView.setImageBitmap(LoadBitmapTask.this.f271922b.a());
                                        AnonymousClass1 anonymousClass110 = AnonymousClass1.this;
                                        if (anonymousClass110.f271928i != anonymousClass110.f271929m) {
                                            LoadBitmapTask.this.f271921a.setVisibility(8);
                                        }
                                    }
                                }, 100L);
                                return;
                            } catch (Exception e16) {
                                AegisLogger.e("Open_Live|LoadBitmapTask", "LoadBitmapTask", "e:", e16);
                                return;
                            }
                        }
                        AegisLogger.i("Open_Live|LoadBitmapTask", "LoadBitmapTask", "errorcode:" + LoadBitmapTask.this.f271923c);
                        AnonymousClass1.this.f271924d.finish();
                    }
                });
            }
            ThreadManager.getUIHandler().post(new Runnable(bitmap) { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.LoadBitmapTask.1.1
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ Bitmap f271930d;

                {
                    this.f271930d = bitmap;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AnonymousClass1.this, (Object) bitmap);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    boolean z16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.f271930d != null) {
                        int screenWidth = ViewUtils.getScreenWidth();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        int i3 = (screenWidth - anonymousClass1.f271926f) / 2;
                        PortraitImageView portraitImageView = LoadBitmapTask.this.f271921a;
                        AnonymousClass1 anonymousClass12 = AnonymousClass1.this;
                        portraitImageView.setRestrict(anonymousClass12.f271926f, anonymousClass12.f271927h, i3, 0);
                        LoadBitmapTask.this.f271921a.setImageBitmap(this.f271930d);
                        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
                        LoadBitmapTask loadBitmapTask = LoadBitmapTask.this;
                        AnonymousClass1 anonymousClass13 = AnonymousClass1.this;
                        Activity activity = anonymousClass13.f271924d;
                        PortraitImageView portraitImageView2 = LoadBitmapTask.this.f271921a;
                        AnonymousClass1 anonymousClass14 = AnonymousClass1.this;
                        loadBitmapTask.f271922b = new RegionView(activity, portraitImageView2, anonymousClass14.f271926f, anonymousClass14.f271927h, 1, i3, 0);
                        AnonymousClass1 anonymousClass15 = AnonymousClass1.this;
                        LoadBitmapTask loadBitmapTask2 = LoadBitmapTask.this;
                        if (anonymousClass15.f271928i == anonymousClass15.f271929m) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        loadBitmapTask2.g(z16);
                        AnonymousClass1 anonymousClass16 = AnonymousClass1.this;
                        anonymousClass16.C.addView(LoadBitmapTask.this.f271921a, layoutParams);
                        AnonymousClass1 anonymousClass17 = AnonymousClass1.this;
                        anonymousClass17.C.addView(LoadBitmapTask.this.f271922b, layoutParams);
                        try {
                            Bitmap decodeResource = BitmapFactory.decodeResource(LoadBitmapTask.this.f271922b.getResources(), R.drawable.nmd);
                            AnonymousClass1 anonymousClass18 = AnonymousClass1.this;
                            LoadBitmapTask.this.f271922b.setCropBitmap(Bitmap.createScaledBitmap(decodeResource, anonymousClass18.f271926f, anonymousClass18.f271927h, false));
                            LoadBitmapTask.this.f271921a.setVisibility(0);
                            LoadBitmapTask.this.f271921a.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.qqlive.room.prepare.covercrop.LoadBitmapTask.1.1.1
                                static IPatchRedirector $redirector_;

                                {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                        iPatchRedirector3.redirect((short) 1, (Object) this, (Object) RunnableC83781.this);
                                    }
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    IPatchRedirector iPatchRedirector3 = $redirector_;
                                    if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 2)) {
                                        iPatchRedirector3.redirect((short) 2, (Object) this);
                                        return;
                                    }
                                    AnonymousClass1 anonymousClass19 = AnonymousClass1.this;
                                    ImageView imageView = anonymousClass19.D;
                                    if (imageView == null) {
                                        return;
                                    }
                                    imageView.setImageBitmap(LoadBitmapTask.this.f271922b.a());
                                    AnonymousClass1 anonymousClass110 = AnonymousClass1.this;
                                    if (anonymousClass110.f271928i != anonymousClass110.f271929m) {
                                        LoadBitmapTask.this.f271921a.setVisibility(8);
                                    }
                                }
                            }, 100L);
                            return;
                        } catch (Exception e16) {
                            AegisLogger.e("Open_Live|LoadBitmapTask", "LoadBitmapTask", "e:", e16);
                            return;
                        }
                    }
                    AegisLogger.i("Open_Live|LoadBitmapTask", "LoadBitmapTask", "errorcode:" + LoadBitmapTask.this.f271923c);
                    AnonymousClass1.this.f271924d.finish();
                }
            });
        }
    }

    public LoadBitmapTask(int i3, int i16, Activity activity, ViewGroup viewGroup, ImageView imageView, String str, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), activity, viewGroup, imageView, str, Integer.valueOf(i17), Integer.valueOf(i18));
        } else {
            this.f271921a = new PortraitImageView(activity);
            ThreadManager.getFileThreadHandler().post(new AnonymousClass1(activity, str, i17, i18, i3, i16, viewGroup, imageView));
        }
    }

    public RegionView f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RegionView) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f271922b;
    }

    public void g(boolean z16) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
            return;
        }
        RegionView regionView = this.f271922b;
        int i16 = 0;
        if (regionView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            regionView.setVisibility(i3);
        }
        PortraitImageView portraitImageView = this.f271921a;
        if (portraitImageView != null) {
            if (!z16) {
                i16 = 8;
            }
            portraitImageView.setVisibility(i16);
        }
    }
}
