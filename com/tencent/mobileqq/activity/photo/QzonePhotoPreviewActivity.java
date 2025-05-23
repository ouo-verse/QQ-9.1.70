package com.tencent.mobileqq.activity.photo;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Context;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.tencent.common.galleryactivity.URLImageView2;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.sharpP.SharpPUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import cooperation.peak.PeakConstants;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: classes10.dex */
public class QzonePhotoPreviewActivity extends PublicBaseFragment {
    static IPatchRedirector $redirector_;
    protected ListView C;
    protected LocalPhotoLinearGradientView D;
    protected TextView E;
    protected ArrayList<String> F;
    protected ArrayList<c> G;
    protected HashMap<String, PicInfo> H;
    protected HashMap<String, LocalMediaInfo> I;
    protected d J;
    int K;
    private boolean L;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class a implements AdapterView.OnItemClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzonePhotoPreviewActivity.this);
            }
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, adapterView, view, Integer.valueOf(i3), Long.valueOf(j3));
            } else if (QzonePhotoPreviewActivity.this.L) {
                QzonePhotoPreviewActivity.this.getBaseActivity().finish();
                QAlbumUtil.anim(QzonePhotoPreviewActivity.this.getBaseActivity(), true, false);
            } else {
                QzonePhotoPreviewActivity.this.back();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzonePhotoPreviewActivity.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                Intent intent = QzonePhotoPreviewActivity.this.getIntent();
                intent.putExtra(PeakConstants.SEND_CHANGTU, true);
                intent.putExtra(PeakConstants.KEY_SHOW_TYPE, 1);
                intent.putExtra(PeakConstants.KEY_SHOW_ORIGIN_TYPE, 1);
                BaseActivity baseActivity = QzonePhotoPreviewActivity.this.getBaseActivity();
                Intent intent2 = QzonePhotoPreviewActivity.this.getIntent();
                QzonePhotoPreviewActivity qzonePhotoPreviewActivity = QzonePhotoPreviewActivity.this;
                PhotoUtils.sendPhoto(baseActivity, intent2, qzonePhotoPreviewActivity.F, qzonePhotoPreviewActivity.K, false);
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class c {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        String f184070a;

        /* renamed from: b, reason: collision with root package name */
        float f184071b;

        public c(String str, float f16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QzonePhotoPreviewActivity.this, str, Float.valueOf(f16));
            } else {
                this.f184070a = str;
                this.f184071b = f16;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public class d extends BaseAdapter {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private final String f184073d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: classes10.dex */
        public class a implements AbsListView.RecyclerListener {
            static IPatchRedirector $redirector_;

            a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }

            @Override // com.tencent.widget.AbsListView.RecyclerListener
            public void onMovedToScrapHeap(View view) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
                    return;
                }
                Object tag = view.getTag();
                if (tag != null && (tag instanceof b)) {
                    ((b) tag).f184076a.setImageDrawable(null);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: classes10.dex */
        public class b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            public URLImageView f184076a;

            b() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) d.this);
                }
            }
        }

        public d(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QzonePhotoPreviewActivity.this, (Object) context);
            } else {
                this.f184073d = "VerticalPictureAdapter";
                c();
            }
        }

        private void a(b bVar, int i3) {
            c cVar = (c) getItem(i3);
            if (cVar == null) {
                QZLog.e("VerticalPictureAdapter", "photoInfo == null");
                return;
            }
            AbsListView.LayoutParams layoutParams = (AbsListView.LayoutParams) bVar.f184076a.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new AbsListView.LayoutParams(-1, -2);
            }
            QZLog.d("VerticalPictureAdapter", 1, "photoInfo.heightWeightProportion:", Float.valueOf(cVar.f184071b));
            if (cVar.f184071b != 0.0f) {
                ((ViewGroup.LayoutParams) layoutParams).height = (int) (ViewUtils.getScreenWidth() * cVar.f184071b);
            }
            bVar.f184076a.setLayoutParams(layoutParams);
            bVar.f184076a.setImageDrawable(null);
        }

        private void b(b bVar, int i3) {
            URL url;
            int status;
            c cVar = (c) getItem(i3);
            if (cVar != null && !TextUtils.isEmpty(cVar.f184070a)) {
                File file = new File(cVar.f184070a);
                if (file.exists()) {
                    URLDrawable.URLDrawableOptions obtain = URLDrawable.URLDrawableOptions.obtain();
                    obtain.mRequestWidth = ViewUtils.getScreenWidth();
                    obtain.mRequestHeight = (int) (ViewUtils.getScreenWidth() * cVar.f184071b);
                    obtain.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                    try {
                        url = file.toURI().toURL();
                    } catch (MalformedURLException e16) {
                        e16.printStackTrace();
                        url = null;
                    }
                    if (url != null) {
                        URLDrawable drawable = URLDrawable.getDrawable(url, obtain);
                        if (drawable != null && (status = drawable.getStatus()) != 1 && status != 2 && status != 3) {
                            drawable.startDownload();
                        }
                        if (drawable != null) {
                            bVar.f184076a.setImageDrawable(drawable);
                            return;
                        }
                        return;
                    }
                    return;
                }
                URLDrawable.URLDrawableOptions obtain2 = URLDrawable.URLDrawableOptions.obtain();
                obtain2.mRequestWidth = ViewUtils.getScreenWidth();
                obtain2.mRequestHeight = (int) (ViewUtils.getScreenWidth() * cVar.f184071b);
                obtain2.mLoadingDrawable = com.tencent.mobileqq.urldrawable.b.f306350a;
                URLDrawable drawable2 = URLDrawable.getDrawable(SharpPUtils.getWebpUrl(cVar.f184070a), obtain2);
                if (drawable2 == null) {
                    QLog.w("PEAK", 2, "drawable == null");
                }
                bVar.f184076a.setImageDrawable(drawable2);
                return;
            }
            QZLog.e("VerticalPictureAdapter", "loadImageData: bigUrl is empty");
        }

        private void c() {
            QzonePhotoPreviewActivity.this.C.setRecyclerListener(new a());
        }

        @Override // android.widget.Adapter
        public int getCount() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            if (QzonePhotoPreviewActivity.this.G != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("VerticalPictureAdapter", 2, "wywy getCount =" + QzonePhotoPreviewActivity.this.G.size());
                }
                return QzonePhotoPreviewActivity.this.G.size();
            }
            return 0;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return iPatchRedirector.redirect((short) 3, (Object) this, i3);
            }
            ArrayList<c> arrayList = QzonePhotoPreviewActivity.this.G;
            if (arrayList != null && i3 < arrayList.size() && i3 >= 0) {
                return QzonePhotoPreviewActivity.this.G.get(i3);
            }
            return null;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Long) iPatchRedirector.redirect((short) 4, (Object) this, i3)).longValue();
            }
            return i3;
        }

        @Override // android.widget.Adapter
        public View getView(int i3, View view, ViewGroup viewGroup) {
            View view2;
            View view3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                view3 = view;
                view2 = (View) iPatchRedirector.redirect((short) 5, this, Integer.valueOf(i3), view, viewGroup);
            } else {
                b bVar = new b();
                if (view == null) {
                    URLImageView2 uRLImageView2 = new URLImageView2(viewGroup.getContext());
                    bVar.f184076a = uRLImageView2;
                    uRLImageView2.setTag(bVar);
                } else {
                    bVar = (b) view.getTag();
                }
                a(bVar, i3);
                b(bVar, i3);
                view2 = bVar.f184076a;
                view3 = view2;
            }
            EventCollector.getInstance().onListGetView(i3, view3, viewGroup, getItemId(i3));
            return view2;
        }
    }

    public QzonePhotoPreviewActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.K = 0;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Intent getIntent() {
        return getBaseActivity().getIntent();
    }

    private void initUI(View view) {
        this.D = (LocalPhotoLinearGradientView) view.findViewById(R.id.htr);
        this.D.setShader(new LinearGradient(0.0f, ViewUtils.dip2px(79.0f), 0.0f, 0.0f, -14869219, 0, Shader.TileMode.CLAMP));
        this.C = (ListView) view.findViewById(R.id.hts);
        this.E = (TextView) view.findViewById(R.id.htq);
        this.C.setOnItemClickListener(new a());
        this.E.setOnClickListener(new b());
        d dVar = new d(getBaseActivity());
        this.J = dVar;
        this.C.setAdapter((ListAdapter) dVar);
    }

    private void parseIntent() {
        this.F = getIntent().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
        this.H = (HashMap) getIntent().getSerializableExtra(PeakConstants.PHOTO_INFOS);
        this.I = (HashMap) getIntent().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        this.K = getIntent().getIntExtra(QAlbumConstants.CURRENT_QUALITY_TYPE, 0);
        this.L = getIntent().getBooleanExtra(PeakConstants.IS_FROM_QZONE_ALBUM, false);
        rh();
    }

    private void rh() {
        int i3;
        int i16;
        PicInfo picInfo;
        this.G = new ArrayList<>(1);
        for (int i17 = 0; i17 < this.F.size(); i17++) {
            HashMap<String, PicInfo> hashMap = this.H;
            if (hashMap != null && hashMap.size() > 0 && this.H.containsKey(this.F.get(i17)) && (picInfo = this.H.get(this.F.get(i17))) != null && picInfo.picwidth > 0) {
                this.G.add(new c(this.F.get(i17), (float) ((picInfo.picheight * 1.0d) / picInfo.picwidth)));
            }
            HashMap<String, LocalMediaInfo> hashMap2 = this.I;
            if (hashMap2 != null && hashMap2.containsKey(this.F.get(i17))) {
                LocalMediaInfo localMediaInfo = this.I.get(this.F.get(i17));
                int i18 = localMediaInfo.orientation;
                if (i18 != 90 && i18 != 270) {
                    i3 = localMediaInfo.mediaHeight;
                    i16 = localMediaInfo.mediaWidth;
                } else {
                    i3 = localMediaInfo.mediaWidth;
                    i16 = localMediaInfo.mediaHeight;
                }
                this.G.add(new c(this.F.get(i17), (float) ((i3 * 1.0d) / i16)));
            }
        }
    }

    public void back() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        Intent intent = getIntent();
        intent.setClass(getBaseActivity(), NewPhotoListActivity.class);
        startActivity(intent);
        getBaseActivity().finish();
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment
    public boolean doOnKeyDown(int i3, KeyEvent keyEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) keyEvent)).booleanValue();
        }
        if (i3 == 4) {
            if (this.L) {
                getBaseActivity().finish();
                QAlbumUtil.anim(getBaseActivity(), true, false);
            } else {
                back();
            }
            return true;
        }
        return super.doOnKeyDown(i3, keyEvent);
    }

    @Override // com.tencent.mobileqq.fragment.PublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            inflate = (View) iPatchRedirector.redirect((short) 2, this, layoutInflater, viewGroup, bundle);
        } else {
            inflate = LayoutInflater.from(getBaseActivity()).inflate(R.layout.boz, (ViewGroup) null);
            getBaseActivity().getWindow().addFlags(1024);
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) view, (Object) bundle);
            return;
        }
        super.onViewCreated(view, bundle);
        parseIntent();
        initUI(view);
    }
}
