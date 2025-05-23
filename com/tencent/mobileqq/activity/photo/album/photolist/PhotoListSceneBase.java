package com.tencent.mobileqq.activity.photo.album.photolist;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Environment;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.photo.PeakFragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.querymedia.MediaQueryHelper;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PhotoGridView;
import com.tencent.widget.TriangleView;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes10.dex */
public class PhotoListSceneBase implements b, View.OnClickListener, CompoundButton.OnCheckedChangeListener, com.tencent.mobileqq.activity.photo.album.albumlist.c {
    static IPatchRedirector $redirector_;
    public View C;
    public View D;
    public View E;
    public FrameLayout F;
    public AsyncTask<Object, Object, List<LocalMediaInfo>> G;
    public PhotoGridView H;
    public GridLayoutManager I;
    public TextView J;
    public Button K;
    public TextView L;
    public TextView M;
    public TriangleView N;
    public LinearLayout P;
    public d Q;

    /* renamed from: d, reason: collision with root package name */
    public PeakFragmentActivity f184275d;

    /* renamed from: e, reason: collision with root package name */
    public AbstractAlbumListFragment f184276e;

    /* renamed from: f, reason: collision with root package name */
    PhotoGridView.OnSelectListener f184277f;

    /* renamed from: h, reason: collision with root package name */
    public f<? extends OtherCommonData> f184278h;

    /* renamed from: i, reason: collision with root package name */
    public e f184279i;

    /* renamed from: m, reason: collision with root package name */
    public RelativeLayout f184280m;

    /* loaded from: classes10.dex */
    class a extends RecyclerView.OnScrollListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) PhotoListSceneBase.this);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recyclerView, i3);
                return;
            }
            MediaQueryHelper mediaQueryHelper = PhotoListSceneBase.this.f184278h.f184310e.getMediaQueryHelper();
            if (i3 == 0 && mediaQueryHelper != null && PhotoListSceneBase.this.I.findLastVisibleItemPosition() + (mediaQueryHelper.mEachCount / 2) > PhotoListSceneBase.this.Q.getNUM_BACKGOURND_ICON() && !PhotoListSceneBase.this.f184278h.f184312h.f184303n.get()) {
                PhotoListSceneBase.this.l();
            }
        }
    }

    public PhotoListSceneBase(f<? extends OtherCommonData> fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) fVar);
            return;
        }
        this.f184277f = new GridSelectListener(this);
        this.Q = null;
        this.f184278h = fVar;
        if (fVar != null) {
            this.f184275d = fVar.f184309d;
            this.f184279i = fVar.f184312h;
            this.f184277f = new GridSelectListener(this);
        }
    }

    private boolean i(boolean z16, int i3) {
        int i16 = this.f184278h.f184310e.maxSelectNum;
        if (i3 == i16 && !z16) {
            return true;
        }
        if (i3 == i16 - 1 && z16) {
            return true;
        }
        return false;
    }

    public static void q(Context context) {
        if (context == null) {
            QLog.d("QQAlbum", 1, "preInitUI params illegal, return ");
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        PhotoListSceneBase photoListSceneBase = new PhotoListSceneBase();
        LayoutInflater from = LayoutInflater.from(context);
        context.getResources();
        d.s0();
        View inflate = from.inflate(R.layout.cbj, (ViewGroup) null);
        photoListSceneBase.C = inflate;
        if (inflate != null) {
            inflate.setId(View.generateViewId());
        }
        View inflate2 = from.inflate(R.layout.gzm, (ViewGroup) null);
        photoListSceneBase.D = inflate2;
        if (inflate2 != null) {
            inflate2.setId(View.generateViewId());
        }
        View inflate3 = from.inflate(R.layout.gzl, (ViewGroup) null);
        photoListSceneBase.E = inflate3;
        if (inflate3 != null) {
            inflate3.setId(View.generateViewId());
        }
        photoListSceneBase.o();
        TextView textView = photoListSceneBase.L;
        if (textView != null) {
            textView.setVisibility(0);
            photoListSceneBase.L.setOnClickListener(photoListSceneBase);
        }
        TextView textView2 = photoListSceneBase.M;
        if (textView2 != null) {
            textView2.getResources().getString(R.string.f1772833j);
            BaseApplication.getContext().getResources().getString(R.string.f1772633h);
        }
        TriangleView triangleView = photoListSceneBase.N;
        if (triangleView != null) {
            triangleView.setColor(photoListSceneBase.M.getCurrentTextColor());
        }
        LinearLayout linearLayout = photoListSceneBase.P;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(photoListSceneBase);
        }
        QLog.i("QQAlbum", 1, "preload necessary resource cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    private void r(int i3, ArrayList<String> arrayList, int i16, View view, LocalMediaInfo localMediaInfo) {
        NumberCheckBox numberCheckBox;
        NumberCheckBox numberCheckBox2;
        NumberCheckBox numberCheckBox3;
        NumberCheckBox numberCheckBox4;
        com.tencent.mobileqq.activity.photo.album.photolist.a aVar;
        NumberCheckBox numberCheckBox5;
        if (i3 != i16) {
            int indexOf = arrayList.indexOf(localMediaInfo.path);
            if (indexOf >= 0 && (aVar = (com.tencent.mobileqq.activity.photo.album.photolist.a) view.getTag()) != null && (numberCheckBox5 = aVar.J) != null) {
                numberCheckBox5.setCheckedNumber(indexOf + 1);
                return;
            }
            return;
        }
        int mediaType = QAlbumUtil.getMediaType(localMediaInfo);
        if (mediaType == 0 || mediaType == 1) {
            com.tencent.mobileqq.activity.photo.album.photolist.a aVar2 = (com.tencent.mobileqq.activity.photo.album.photolist.a) view.getTag();
            if (aVar2 == null) {
                QLog.w("QQAlbum", 1, "realUpdateCheckbox holder = null");
            }
            int i17 = localMediaInfo.selectStatus;
            if (i17 == 1) {
                if (aVar2 != null && (numberCheckBox4 = aVar2.J) != null) {
                    numberCheckBox4.setCheckedNumber(arrayList.indexOf(localMediaInfo.path) + 1);
                }
                if (view.getBackground() != null) {
                    view.setBackgroundDrawable(null);
                }
            } else if (i17 == 3) {
                if (aVar2 != null && (numberCheckBox2 = aVar2.J) != null) {
                    numberCheckBox2.setChecked(false);
                }
            } else {
                if (aVar2 != null && (numberCheckBox = aVar2.J) != null) {
                    numberCheckBox.setChecked(false);
                }
                if (view.getBackground() != null) {
                    view.setBackgroundDrawable(null);
                }
            }
            if (AppSetting.f99565y && aVar2 != null && (numberCheckBox3 = aVar2.J) != null) {
                aVar2.J.setContentDescription(QAlbumUtil.createContentDescriptionWithCheckBox(mediaType, localMediaInfo, i16, numberCheckBox3.isChecked()));
            }
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.c
    public void a(QQAlbumInfo qQAlbumInfo, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, qQAlbumInfo, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            TextView textView = this.M;
            String str = this.f184278h.f184310e.albumName;
            if (str == null) {
                str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            }
            textView.setText(str);
            this.f184279i.f184290a = true;
            this.f184278h.f184310e.createMediaQueryHelper(this.f184275d);
            this.f184275d.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.activity.photo.album.photolist.PhotoListSceneBase.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) PhotoListSceneBase.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else {
                        PhotoListSceneBase.this.m(false);
                    }
                }
            });
        }
        c(false);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public View b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (View) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184275d.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.inflate(R.layout.cbj, (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.c
    public void c(boolean z16) {
        ObjectAnimator ofInt;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        if (this.f184276e == null) {
            if (z16) {
                AbstractAlbumListFragment w3 = this.f184278h.w();
                this.f184276e = w3;
                w3.C = this;
            } else {
                return;
            }
        }
        FragmentManager supportFragmentManager = this.f184275d.getSupportFragmentManager();
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.setTransition(4097);
        if (z16) {
            ofInt = ObjectAnimator.ofInt(this.F, "backgroundColor", this.f184275d.getResources().getColor(R.color.f156932fm), this.f184275d.getResources().getColor(R.color.f156943fx));
            QAlbumUtil.rotate180Degrees(this.N, false);
            if (!this.f184276e.isAdded() && supportFragmentManager.findFragmentByTag(this.f184276e.toString()) == null) {
                try {
                    int id5 = this.F.getId();
                    AbstractAlbumListFragment abstractAlbumListFragment = this.f184276e;
                    beginTransaction.add(id5, abstractAlbumListFragment, abstractAlbumListFragment.toString());
                } catch (IllegalStateException unused) {
                    beginTransaction.show(this.f184276e);
                }
            } else {
                beginTransaction.show(this.f184276e);
            }
        } else {
            ofInt = ObjectAnimator.ofInt(this.F, "backgroundColor", this.f184275d.getResources().getColor(R.color.f156943fx), this.f184275d.getResources().getColor(R.color.f156932fm));
            QAlbumUtil.rotate180Degrees(this.N, true);
            beginTransaction.hide(this.f184276e);
        }
        beginTransaction.commit();
        ofInt.setDuration(300L);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setRepeatMode(2);
        ofInt.start();
        this.f184278h.H(z16);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public View d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (View) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184275d.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.inflate(R.layout.gzm, (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        View view = this.C;
        if (view != null && view.getLayoutParams() != null) {
            return new RelativeLayout.LayoutParams(this.C.getLayoutParams());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, (int) this.f184275d.getResources().getDimension(R.dimen.title_bar_height));
        layoutParams.addRule(10);
        return layoutParams;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        View view = this.D;
        if (view != null && view.getLayoutParams() != null) {
            return new RelativeLayout.LayoutParams(this.D.getLayoutParams());
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(12);
        return layoutParams;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        View view = this.C;
        if (view != null) {
            layoutParams.addRule(3, view.getId());
        }
        return layoutParams;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public View h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (View) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        LayoutInflater layoutInflater = (LayoutInflater) this.f184275d.getSystemService("layout_inflater");
        if (layoutInflater == null) {
            return null;
        }
        return layoutInflater.inflate(R.layout.gzl, (ViewGroup) null);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.photolist.b
    public RelativeLayout.LayoutParams j() {
        RelativeLayout.LayoutParams layoutParams;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RelativeLayout.LayoutParams) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        View view = this.E;
        if (view != null && view.getLayoutParams() != null) {
            layoutParams = new RelativeLayout.LayoutParams(this.E.getLayoutParams());
        } else {
            layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        }
        View view2 = this.C;
        if (view2 != null) {
            layoutParams.addRule(3, view2.getId());
        }
        View view3 = this.D;
        if (view3 != null) {
            layoutParams.addRule(2, view3.getId());
        }
        return layoutParams;
    }

    @TargetApi(8)
    public File k() throws IOException {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (File) iPatchRedirector.redirect((short) 18, (Object) this);
        }
        String str = "JPEG_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + "_";
        if ("mounted".equals(Environment.getExternalStorageState())) {
            File createTempFile = File.createTempFile(str, ".jpg", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM));
            this.f184279i.f184292c = createTempFile.getAbsolutePath();
            return createTempFile;
        }
        return null;
    }

    public void l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
            return;
        }
        MediaQueryHelper mediaQueryHelper = this.f184278h.f184310e.getMediaQueryHelper();
        if (mediaQueryHelper != null && !mediaQueryHelper.mTraversalDone) {
            new g(this.f184278h).execute(new Object[0]);
        }
    }

    public synchronized void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, z16);
            return;
        }
        if (z16) {
            this.f184278h.f184310e.closeMediaQueryHelper();
        }
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "PhotoListSceneBase,excuteQueryPhotoTask: needNew = " + z16);
        }
        h hVar = new h(this.f184278h);
        this.G = hVar;
        hVar.execute(new Object[0]);
    }

    public View n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (View) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        long currentTimeMillis = System.currentTimeMillis();
        this.f184280m = new RelativeLayout(this.f184275d);
        this.f184280m.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
        View b16 = this.f184278h.b();
        this.C = b16;
        if (b16 != null) {
            b16.setId(View.generateViewId());
            RelativeLayout.LayoutParams e16 = this.f184278h.e();
            if (e16 != null) {
                this.f184280m.addView(this.C, e16);
            } else {
                this.f184280m.addView(this.C);
            }
        }
        View d16 = this.f184278h.d();
        this.D = d16;
        if (d16 != null) {
            d16.setId(View.generateViewId());
            RelativeLayout.LayoutParams f16 = this.f184278h.f();
            if (f16 != null) {
                this.f184280m.addView(this.D, f16);
            } else {
                this.f184280m.addView(this.C);
            }
        }
        View h16 = this.f184278h.h();
        this.E = h16;
        if (h16 != null) {
            h16.setId(View.generateViewId());
            RelativeLayout.LayoutParams j3 = this.f184278h.j();
            if (j3 != null) {
                this.f184280m.addView(this.E, j3);
            } else {
                this.f184280m.addView(this.E);
            }
        }
        FrameLayout frameLayout = new FrameLayout(this.f184275d);
        this.F = frameLayout;
        frameLayout.setId(View.generateViewId());
        this.F.setBackgroundColor(this.f184275d.getResources().getColor(R.color.f156932fm));
        RelativeLayout.LayoutParams g16 = this.f184278h.g();
        if (g16 != null) {
            this.f184280m.addView(this.F, g16);
        } else {
            this.f184280m.addView(this.F);
        }
        QLog.i("QQAlbum", 1, "getContentView cost\uff1a" + (System.currentTimeMillis() - currentTimeMillis));
        return this.f184280m;
    }

    public void o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        View view = this.C;
        if (view != null) {
            this.L = (TextView) view.findViewById(R.id.ivTitleBtnLeft);
            this.M = (TextView) this.C.findViewById(R.id.ivTitleName);
            this.N = (TriangleView) this.C.findViewById(R.id.dta);
            this.P = (LinearLayout) this.C.findViewById(R.id.lmy);
        }
        View view2 = this.D;
        if (view2 != null) {
            this.J = (TextView) view2.findViewById(R.id.fyh);
            this.K = (Button) this.D.findViewById(R.id.send_btn);
        }
        View view3 = this.E;
        if (view3 != null) {
            this.H = (PhotoGridView) view3.findViewById(R.id.photo_list_gv);
        }
        QLog.i("QQAlbum", 1, "getUI init views cost:" + (System.currentTimeMillis() - currentTimeMillis));
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, compoundButton, Boolean.valueOf(z16));
        } else if (compoundButton.getId() == R.id.h1y) {
            this.f184278h.M(compoundButton, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    @TargetApi(9)
    public void onClick(View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) view);
        } else {
            int id5 = view.getId();
            if (id5 == R.id.ivTitleBtnLeft) {
                this.f184278h.P(view);
            } else if (id5 == R.id.fyh) {
                this.f184278h.L(view);
            } else if (id5 == R.id.send_btn) {
                this.f184278h.O(view);
            } else if (id5 == R.id.lmy) {
                AbstractAlbumListFragment abstractAlbumListFragment = this.f184276e;
                if (abstractAlbumListFragment != null && abstractAlbumListFragment.isAdded() && !this.f184276e.isHidden()) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    this.f184278h.u(this.f184275d.getIntent());
                }
                c(z16);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        o();
        TextView textView = this.L;
        if (textView != null) {
            textView.setVisibility(0);
            this.L.setOnClickListener(this);
        }
        if (this.M != null) {
            String string = BaseApplication.getContext().getResources().getString(R.string.f1772833j);
            String string2 = BaseApplication.getContext().getResources().getString(R.string.f1772633h);
            TextView textView2 = this.M;
            PhotoCommonBaseData<? extends OtherCommonData> photoCommonBaseData = this.f184278h.f184310e;
            String str = photoCommonBaseData.albumName;
            if (str != null) {
                string = str;
            } else if (photoCommonBaseData.showMediaType != 2) {
                string = string2;
            }
            textView2.setText(string);
        }
        TriangleView triangleView = this.N;
        if (triangleView != null) {
            triangleView.setColor(this.M.getCurrentTextColor());
        }
        LinearLayout linearLayout = this.P;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        this.I = new GridLayoutManager(this.f184275d, this.f184278h.f184312h.f184304o);
        this.H.setScrollBarStyle(0);
        this.Q = new d(this.f184278h);
        PhotoGridView photoGridView = this.H;
        if (photoGridView != null) {
            photoGridView.setLayoutManager(this.I);
            this.H.setAdapter(this.Q);
            this.H.setOnIndexChangedListener(this.f184277f);
            this.H.addOnScrollListener(new a());
        }
        QLog.i("QQAlbum", 1, "initUI cost\uff1a" + (System.currentTimeMillis() - currentTimeMillis));
    }

    public void s(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str);
            return;
        }
        if (this.f184279i.f184305p) {
            QAlbumUtil.sLastAlbumRecordTime = System.currentTimeMillis();
            QAlbumUtil.sLastAlbumPhotoCountMap.put(this.f184278h.f184310e.albumId, Integer.valueOf(this.Q.getNUM_BACKGOURND_ICON()));
            if (!TextUtils.isEmpty(str)) {
                QAlbumUtil.sLastAlbumPath = str;
                HashMap<String, Pair<String, String>> hashMap = QAlbumUtil.sSelectItemAlbum;
                if (hashMap.containsKey(str)) {
                    Pair<String, String> pair = hashMap.get(str);
                    QAlbumUtil.sLastAlbumId = (String) pair.first;
                    QAlbumUtil.sLastAlbumName = (String) pair.second;
                    QAlbumUtil.putLastAlbumInfo(this.f184275d, QAlbumUtil.sLastAlbumId, QAlbumUtil.sLastAlbumName);
                }
            }
        }
        QAlbumUtil.clearSelectItemInfo();
    }

    public void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
            return;
        }
        if (i(z16, this.f184278h.f184310e.selectedPhotoList.size())) {
            int findFirstVisibleItemPosition = this.I.findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = this.I.findLastVisibleItemPosition();
            for (int i3 = findFirstVisibleItemPosition; i3 <= findLastVisibleItemPosition; i3++) {
                if (this.Q.getItemViewType(i3) != 2) {
                    View childAt = this.H.getChildAt(i3 - findFirstVisibleItemPosition);
                    LocalMediaInfo m06 = this.Q.m0(i3);
                    if (childAt == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQAlbum", 2, "updateCheckbox view = null at " + i3);
                        }
                    } else if (m06 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("QQAlbum", 2, "updateCheckbox info = null at " + i3);
                        }
                    } else {
                        com.tencent.mobileqq.activity.photo.album.photolist.a aVar = (com.tencent.mobileqq.activity.photo.album.photolist.a) childAt.getTag();
                        if (aVar != null) {
                            if (!z16 && m06.selectStatus != 1) {
                                aVar.F.setAlpha(0.3f);
                            } else {
                                aVar.F.setAlpha(1.0f);
                            }
                        } else {
                            QLog.w("QQAlbum", 1, "selectLimitRemind holder = null");
                        }
                    }
                }
            }
        }
    }

    public void u(int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        ArrayList<String> arrayList = this.f184278h.f184310e.selectedPhotoList;
        int findFirstVisibleItemPosition = this.I.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.I.findLastVisibleItemPosition();
        for (int i16 = findFirstVisibleItemPosition; i16 <= findLastVisibleItemPosition; i16++) {
            if (!z16 || i3 == i16) {
                View childAt = this.H.getChildAt(i16 - findFirstVisibleItemPosition);
                LocalMediaInfo m06 = this.Q.m0(i16);
                if (childAt == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, "updateCheckbox view = null at " + i16);
                    }
                } else if (m06 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("QQAlbum", 2, "updateCheckbox info = null at " + i16);
                    }
                } else {
                    r(i3, arrayList, i16, childAt, m06);
                }
            }
        }
    }

    public void v() {
        com.tencent.mobileqq.activity.photo.album.photolist.a aVar;
        NumberCheckBox numberCheckBox;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        int findFirstVisibleItemPosition = this.I.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.I.findLastVisibleItemPosition();
        for (int i3 = findFirstVisibleItemPosition; i3 <= findLastVisibleItemPosition; i3++) {
            View childAt = this.H.getChildAt(i3 - findFirstVisibleItemPosition);
            LocalMediaInfo m06 = this.Q.m0(i3);
            if (childAt == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "updateCheckbox view = null at " + i3);
                }
            } else if (m06 == null) {
                if (QLog.isColorLevel()) {
                    QLog.d("QQAlbum", 2, "updateCheckbox info = null at " + i3);
                }
            } else {
                int indexOf = this.f184278h.f184310e.selectedPhotoList.indexOf(m06.path);
                if (indexOf >= 0 && (aVar = (com.tencent.mobileqq.activity.photo.album.photolist.a) childAt.getTag()) != null && (numberCheckBox = aVar.J) != null) {
                    numberCheckBox.setCheckedNumber(indexOf + 1);
                }
            }
        }
    }

    PhotoListSceneBase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.f184277f = new GridSelectListener(this);
            this.Q = null;
        }
    }
}
