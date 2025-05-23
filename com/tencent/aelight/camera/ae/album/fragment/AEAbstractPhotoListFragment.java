package com.tencent.aelight.camera.ae.album.fragment;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout;
import com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout;
import com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment;
import com.tencent.aelight.camera.ae.album.logic.c;
import com.tencent.aelight.camera.ae.album.nocropper.AECropperView;
import com.tencent.aelight.camera.ae.camera.ui.bubble.BubbleTextView;
import com.tencent.aelight.camera.ae.report.AEBaseReportParam;
import com.tencent.aelight.camera.ae.util.AECameraPrefsUtil;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.OtherCommonData;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.QAlbumCommonUtil;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qcircle.api.IQCircleRFWApi;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoViewFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.bm;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

/* loaded from: classes32.dex */
public abstract class AEAbstractPhotoListFragment extends ReportFragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, AEAbstractAlbumListFragment.c, AEAlbumPreviewMaskLayout.a {
    public int C;
    int D;
    public int E;
    private FrameLayout F;
    public AEAlbumLinearLayout G;
    public GridLayoutManager H;
    private FrameLayout I;
    public AECropperView J;
    public BaseVideoView K;
    public ViewGroup L;
    public ImageView M;
    public TextView N;
    public AEAlbumPreviewMaskLayout P;
    public RecyclerView Q;
    private BubbleTextView R;
    public TextView S;
    private ImageView T;
    private Runnable U;
    public TextView V;
    View W;
    TextView X;
    View Y;
    LinearLayout Z;

    /* renamed from: a0, reason: collision with root package name */
    FrameLayout f62024a0;

    /* renamed from: d, reason: collision with root package name */
    public com.tencent.aelight.camera.ae.album.logic.c f62027d;

    /* renamed from: d0, reason: collision with root package name */
    private TextView f62028d0;

    /* renamed from: e, reason: collision with root package name */
    com.tencent.mobileqq.activity.photo.album.photolist.e f62029e;

    /* renamed from: e0, reason: collision with root package name */
    private LottieDrawable f62030e0;

    /* renamed from: f, reason: collision with root package name */
    public AEAbstractAlbumListFragment f62031f;

    /* renamed from: f0, reason: collision with root package name */
    private LottieDrawable f62032f0;

    /* renamed from: g0, reason: collision with root package name */
    private Drawable f62033g0;

    /* renamed from: h0, reason: collision with root package name */
    private Drawable f62035h0;

    /* renamed from: i, reason: collision with root package name */
    SharedPreferences f62036i;

    /* renamed from: i0, reason: collision with root package name */
    private boolean f62037i0;

    /* renamed from: j0, reason: collision with root package name */
    Dialog f62038j0;

    /* renamed from: k0, reason: collision with root package name */
    public AsyncTask<Object, Object, List<LocalMediaInfo>> f62039k0;

    /* renamed from: m, reason: collision with root package name */
    public int f62040m;

    /* renamed from: h, reason: collision with root package name */
    public e f62034h = null;

    /* renamed from: b0, reason: collision with root package name */
    public final boolean f62025b0 = com.tencent.aelight.camera.ae.util.i.a();

    /* renamed from: c0, reason: collision with root package name */
    private boolean f62026c0 = false;

    /* loaded from: classes32.dex */
    class a implements OnApplyWindowInsetsListener {
        a() {
        }

        @Override // android.support.v4.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            ViewGroup viewGroup;
            if ((view instanceof ViewGroup) && (viewGroup = (ViewGroup) view.findViewById(R.id.f163788s05)) != null) {
                viewGroup.setPadding(0, windowInsetsCompat.getSystemWindowInsetTop(), 0, 0);
            }
            return windowInsetsCompat;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class b implements AEAlbumLinearLayout.ScrollListener {
        b() {
        }

        @Override // com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.ScrollListener
        public void a(float f16) {
            AEAbstractPhotoListFragment.this.f62027d.C(f16);
        }

        @Override // com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.ScrollListener
        public void b(float f16) {
            AEAbstractPhotoListFragment.this.f62027d.u(f16);
        }

        @Override // com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.ScrollListener
        public void c(int i3, boolean z16) {
            AEAbstractPhotoListFragment.this.f62027d.A(i3, z16);
        }

        @Override // com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.ScrollListener
        public void onScrollStart(int i3) {
            AEAbstractPhotoListFragment.this.f62027d.B(i3);
        }

        @Override // com.tencent.aelight.camera.ae.album.AEAlbumLinearLayout.ScrollListener
        public void onStatusChanged(boolean z16) {
            if (AEAbstractPhotoListFragment.this.f62037i0 || z16) {
                return;
            }
            com.tencent.aelight.camera.aebase.c.i(AEAbstractPhotoListFragment.this.f62027d.f62125i.initialHasPickedNum > 0);
            AEAbstractPhotoListFragment.this.f62037i0 = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            AEAbstractPhotoListFragment.this.f62027d.r();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes32.dex */
    public class d implements View.OnClickListener {
        d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (AEAbstractPhotoListFragment.this.K.isPlaying()) {
                AEAbstractPhotoListFragment.this.K.pause();
            } else {
                AEAbstractPhotoListFragment.this.K.resume();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    public class f implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        int f62051d;

        /* renamed from: e, reason: collision with root package name */
        CheckBox f62052e;

        public f() {
        }

        public void a(CheckBox checkBox) {
            this.f62052e = checkBox;
        }

        public void b(int i3) {
            this.f62051d = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            c.b bVar = AEAbstractPhotoListFragment.this.f62027d.D;
            if (bVar != null) {
                bVar.e(view, this.f62051d, this.f62052e);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* loaded from: classes32.dex */
    public class g extends RecyclerView.ViewHolder {
        public TextView C;
        public View D;
        public TextView E;
        public f F;

        /* renamed from: d, reason: collision with root package name */
        public ImageView f62054d;

        /* renamed from: e, reason: collision with root package name */
        public ImageView f62055e;

        /* renamed from: f, reason: collision with root package name */
        public ImageView f62056f;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f62057h;

        /* renamed from: i, reason: collision with root package name */
        public NumberCheckBox f62058i;

        /* renamed from: m, reason: collision with root package name */
        public URLDrawable f62059m;

        public g(View view) {
            super(view);
            this.f62055e = (ImageView) view.findViewById(R.id.ry7);
            this.f62054d = (ImageView) view.findViewById(R.id.f163775ry2);
            this.f62056f = (ImageView) view.findViewById(R.id.f163761rv3);
            this.D = view.findViewById(R.id.ry8);
            this.f62058i = (NumberCheckBox) view.findViewById(R.id.ry9);
            this.C = (TextView) view.findViewById(R.id.ry_);
            ImageView imageView = (ImageView) view.findViewById(R.id.rxy);
            this.f62057h = imageView;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            if (this.f62058i != null) {
                ((IQCircleRFWApi) QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.f62058i, false);
            }
            if (this.C != null) {
                ((IQCircleRFWApi) QRoute.api(IQCircleRFWApi.class)).setNumberTypeface(this.C, false);
            }
        }
    }

    /* loaded from: classes32.dex */
    public class h extends AsyncTask<Object, Object, List<LocalMediaInfo>> {

        /* renamed from: a, reason: collision with root package name */
        private boolean f62060a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f62061b;

        public h(boolean z16, boolean z17) {
            this.f62060a = z16;
            this.f62061b = z17;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public List<LocalMediaInfo> doInBackground(Object... objArr) {
            PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = AEAbstractPhotoListFragment.this.f62027d.f62123f;
            if (photoCommonBaseData.selectedPhotoList == null) {
                photoCommonBaseData.selectedPhotoList = new ArrayList<>();
            }
            if (photoCommonBaseData.selectedMediaInfoHashMap == null) {
                photoCommonBaseData.selectedMediaInfoHashMap = new HashMap<>();
            }
            HashMap<String, LocalMediaInfo> hashMap = photoCommonBaseData.selectedMediaInfoHashMap;
            bm.a();
            List<LocalMediaInfo> l3 = AEAbstractPhotoListFragment.this.f62027d.l(this.f62060a);
            if (l3 == null) {
                l3 = new ArrayList<>();
            }
            com.tencent.mobileqq.activity.photo.album.photolist.e eVar = AEAbstractPhotoListFragment.this.f62029e;
            eVar.f184294e = 0;
            eVar.f184295f = 0;
            long currentTimeMillis = System.currentTimeMillis() - QAlbumUtil.sLastAlbumRecordTime;
            int intValue = QAlbumUtil.sLastAlbumPhotoCountMap.containsKey(photoCommonBaseData.albumId) ? QAlbumUtil.sLastAlbumPhotoCountMap.get(photoCommonBaseData.albumId).intValue() : 0;
            if (AEAbstractPhotoListFragment.this.f62029e.f184306q && photoCommonBaseData.albumId.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
                for (LocalMediaInfo localMediaInfo : l3) {
                    if (localMediaInfo != null && !TextUtils.isEmpty(localMediaInfo.path)) {
                        com.tencent.mobileqq.activity.photo.album.photolist.e.f184289u.remove(localMediaInfo.path);
                        hashMap.remove(localMediaInfo.path);
                    }
                }
                l3.addAll(0, com.tencent.mobileqq.activity.photo.album.photolist.e.f184289u.values());
            }
            if (AEAbstractPhotoListFragment.this.f62029e.f184307r && photoCommonBaseData.albumId.equals(QAlbumCustomAlbumConstants.VIDEO_ALBUM_ID)) {
                for (LocalMediaInfo localMediaInfo2 : l3) {
                    if (localMediaInfo2 != null && !TextUtils.isEmpty(localMediaInfo2.path)) {
                        com.tencent.mobileqq.activity.photo.album.photolist.e.f184289u.remove(localMediaInfo2.path);
                        hashMap.remove(localMediaInfo2.path);
                    }
                }
                int i3 = 0;
                for (LocalMediaInfo localMediaInfo3 : com.tencent.mobileqq.activity.photo.album.photolist.e.f184289u.values()) {
                    if (localMediaInfo3 != null && "video/mp4".equals(localMediaInfo3.mMimeType)) {
                        l3.add(i3, localMediaInfo3);
                        i3++;
                    }
                }
            }
            AEAbstractPhotoListFragment.this.f62027d.G(l3);
            int size = l3.size();
            ArrayList<String> arrayList = new ArrayList<>(size);
            for (int i16 = 0; i16 < l3.size(); i16++) {
                LocalMediaInfo localMediaInfo4 = l3.get(i16);
                if (localMediaInfo4.path != null) {
                    int mediaType = QAlbumUtil.getMediaType(localMediaInfo4);
                    localMediaInfo4.position = Integer.valueOf(arrayList.size());
                    arrayList.add(localMediaInfo4.path);
                    if (photoCommonBaseData.selectedPhotoList.contains(localMediaInfo4.path)) {
                        localMediaInfo4.selectStatus = 1;
                        if (!photoCommonBaseData.selectedIndex.contains(localMediaInfo4.position)) {
                            photoCommonBaseData.selectedIndex.add(localMediaInfo4.position);
                        }
                        com.tencent.mobileqq.activity.photo.album.photolist.e eVar2 = AEAbstractPhotoListFragment.this.f62029e;
                        if (eVar2.f184293d && mediaType == 1) {
                            int i17 = eVar2.f184294e + 1;
                            eVar2.f184294e = i17;
                            if (i17 == 1) {
                                eVar2.f184296g = localMediaInfo4;
                            }
                        }
                        if (eVar2.f184306q && !hashMap.containsKey(localMediaInfo4.path)) {
                            hashMap.put(localMediaInfo4.path, localMediaInfo4);
                        }
                        if (!TextUtils.isEmpty(localMediaInfo4.mMimeType) && "image/gif".equals(localMediaInfo4.mMimeType)) {
                            AEAbstractPhotoListFragment.this.f62029e.f184295f++;
                        }
                    } else if (photoCommonBaseData.selectedPhotoList.size() < photoCommonBaseData.maxSelectNum && localMediaInfo4.path.equals(AEAbstractPhotoListFragment.this.f62029e.f184292c)) {
                        localMediaInfo4.selectStatus = 1;
                        photoCommonBaseData.selectedPhotoList.add(localMediaInfo4.path);
                        photoCommonBaseData.selectedIndex.add(localMediaInfo4.position);
                        hashMap.put(localMediaInfo4.path, localMediaInfo4);
                    } else if (AEAbstractPhotoListFragment.this.f62029e.f184305p && currentTimeMillis <= 60000 && intValue == l3.size() && localMediaInfo4.path.equals(QAlbumUtil.sLastAlbumPath)) {
                        localMediaInfo4.selectStatus = 3;
                    } else {
                        localMediaInfo4.selectStatus = 2;
                    }
                }
            }
            if (AEAbstractPhotoListFragment.this.f62027d.p()) {
                if (photoCommonBaseData.allMediaInfoHashMap == null) {
                    photoCommonBaseData.allMediaInfoHashMap = new HashMap<>();
                } else {
                    Iterator<String> it = photoCommonBaseData.selectedPhotoList.iterator();
                    while (it.hasNext()) {
                        String next = it.next();
                        if (photoCommonBaseData.allMediaInfoHashMap.containsKey(next) && !hashMap.containsKey(next)) {
                            hashMap.put(next, photoCommonBaseData.allMediaInfoHashMap.get(next));
                        }
                    }
                    photoCommonBaseData.allMediaInfoHashMap.clear();
                }
                for (int i18 = 0; i18 < size; i18++) {
                    LocalMediaInfo localMediaInfo5 = l3.get(i18);
                    String str = localMediaInfo5.path;
                    if (str != null) {
                        photoCommonBaseData.allMediaInfoHashMap.put(str, localMediaInfo5);
                    }
                }
            }
            photoCommonBaseData.mediaPathsList = arrayList;
            if (QLog.isColorLevel()) {
                QLog.d("PhotoListActivity", 2, "QueryPhotoTask,doInBackground,mediaList.size :" + l3.size());
            }
            return l3;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(List<LocalMediaInfo> list) {
            AEAbstractPhotoListFragment.this.f62027d.z(list, this.f62060a);
            if (this.f62060a) {
                AEAbstractPhotoListFragment.this.r(false, false);
                com.tencent.aelight.camera.aebase.c.h(AEAbstractPhotoListFragment.this.f62027d.f62125i.initialHasPickedNum > 0, "1");
            }
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
            if (this.f62061b) {
                AEAbstractPhotoListFragment.this.D();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes32.dex */
    public static class i implements OnCompositionLoadedListener {

        /* renamed from: a, reason: collision with root package name */
        private WeakReference<AEAbstractPhotoListFragment> f62063a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f62064b;

        /* renamed from: c, reason: collision with root package name */
        private boolean f62065c;

        i(AEAbstractPhotoListFragment aEAbstractPhotoListFragment, boolean z16, boolean z17) {
            this.f62063a = new WeakReference<>(aEAbstractPhotoListFragment);
            this.f62064b = z16;
            this.f62065c = z17;
        }

        @Override // com.airbnb.lottie.OnCompositionLoadedListener
        public void onCompositionLoaded(LottieComposition lottieComposition) {
            AEAbstractPhotoListFragment aEAbstractPhotoListFragment = this.f62063a.get();
            if (aEAbstractPhotoListFragment == null) {
                return;
            }
            LottieDrawable lottieDrawable = new LottieDrawable();
            lottieDrawable.setComposition(lottieComposition);
            lottieDrawable.loop(false);
            if (this.f62064b) {
                lottieDrawable.playAnimation();
            } else {
                lottieDrawable.setProgress(1.0f);
            }
            lottieDrawable.setBounds(0, 0, ImmersiveUtils.dpToPx(20.0f), ImmersiveUtils.dpToPx(20.0f));
            if (this.f62065c) {
                aEAbstractPhotoListFragment.f62032f0 = lottieDrawable;
                aEAbstractPhotoListFragment.f62028d0.setCompoundDrawables(aEAbstractPhotoListFragment.f62032f0, null, null, null);
            } else {
                aEAbstractPhotoListFragment.f62030e0 = lottieDrawable;
                aEAbstractPhotoListFragment.f62028d0.setCompoundDrawables(aEAbstractPhotoListFragment.f62030e0, null, null, null);
            }
        }
    }

    private void J(boolean z16, boolean z17) {
        TextView textView = this.f62028d0;
        if (textView == null) {
            return;
        }
        if (z16) {
            textView.setVisibility(0);
            AECropperView aECropperView = this.J;
            int k3 = aECropperView != null ? aECropperView.k() : 1;
            if (k3 == 1) {
                LottieDrawable lottieDrawable = this.f62032f0;
                if (lottieDrawable == null) {
                    LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_expand.json", new i(this, z17, true));
                    return;
                }
                if (z17) {
                    lottieDrawable.playAnimation();
                } else {
                    lottieDrawable.setProgress(1.0f);
                }
                this.f62028d0.setCompoundDrawables(this.f62032f0, null, null, null);
            } else if (k3 == 2) {
                LottieDrawable lottieDrawable2 = this.f62030e0;
                if (lottieDrawable2 == null) {
                    LottieComposition.Factory.fromAssetFileName(getActivity(), "imageselector_scale_shrink.json", new i(this, z17, false));
                    return;
                }
                if (z17) {
                    lottieDrawable2.playAnimation();
                } else {
                    lottieDrawable2.setProgress(1.0f);
                }
                this.f62028d0.setCompoundDrawables(this.f62030e0, null, null, null);
            }
            this.f62028d0.setCompoundDrawablePadding(ImmersiveUtils.dpToPx(4.0f));
            return;
        }
        textView.setVisibility(8);
    }

    private LocalMediaInfo v(Object obj) {
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData;
        HashMap<String, LocalMediaInfo> hashMap;
        HashMap<String, LocalMediaInfo> hashMap2;
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData2 = this.f62027d.f62123f;
        LocalMediaInfo localMediaInfo = (photoCommonBaseData2 == null || (hashMap2 = photoCommonBaseData2.selectedMediaInfoHashMap) == null) ? null : hashMap2.get(obj);
        return (localMediaInfo != null || (photoCommonBaseData = this.f62027d.f62123f) == null || (hashMap = photoCommonBaseData.allMediaInfoHashMap) == null) ? localMediaInfo : hashMap.get(obj);
    }

    public void A(boolean z16) {
        int size = this.f62027d.f62123f.selectedPhotoList.size();
        com.tencent.aelight.camera.ae.album.logic.c cVar = this.f62027d;
        int i3 = size + cVar.f62125i.initialHasPickedNum;
        int i16 = cVar.f62123f.maxSelectNum;
        if ((i3 == i16 && !z16) || (i3 == i16 - 1 && z16)) {
            int findFirstVisibleItemPosition = ((GridLayoutManager) this.Q.getLayoutManager()).findFirstVisibleItemPosition();
            int findLastVisibleItemPosition = ((GridLayoutManager) this.Q.getLayoutManager()).findLastVisibleItemPosition();
            for (int i17 = findFirstVisibleItemPosition; i17 <= findLastVisibleItemPosition; i17++) {
                if (this.f62034h.getItemViewType(i17) != 2) {
                    View childAt = this.Q.getChildAt(i17 - findFirstVisibleItemPosition);
                    LocalMediaInfo p16 = this.f62034h.p(i17);
                    if (childAt == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i17);
                        }
                    } else if (p16 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i17);
                        }
                    } else {
                        g gVar = (g) this.Q.getChildViewHolder(childAt);
                        if (!z16 && p16.selectStatus != 1) {
                            gVar.f62055e.setAlpha(0.3f);
                        } else {
                            gVar.f62055e.setAlpha(1.0f);
                        }
                    }
                }
            }
        }
    }

    public void B(CharSequence charSequence) {
        getActivity().setTitle(charSequence);
        this.X.setText(charSequence);
    }

    public void D() {
        try {
            if (this.f62038j0 != null) {
                n();
            } else {
                Dialog u16 = u();
                this.f62038j0 = u16;
                u16.setCancelable(true);
                this.f62038j0.show();
            }
            if (this.f62038j0.isShowing()) {
                return;
            }
            this.f62038j0.show();
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.e("PhotoListActivity", 2, "show dialog error", e16);
            }
            this.f62038j0 = null;
        }
    }

    public void E(boolean z16) {
        this.T.setVisibility(z16 ? 0 : 8);
    }

    public void F(boolean z16) {
        ObjectAnimator ofInt;
        if (this.f62031f == null) {
            if (!z16) {
                return;
            }
            AEAbstractAlbumListFragment t16 = t();
            this.f62031f = t16;
            t16.g(this);
        }
        FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
        beginTransaction.setTransition(4097);
        if (z16 && !this.f62031f.isAdded()) {
            ofInt = ObjectAnimator.ofInt(this.f62024a0, "backgroundColor", getResources().getColor(R.color.f156932fm), getResources().getColor(R.color.f156943fx));
            z(this.Y, false);
            beginTransaction.add(R.id.f163727ro4, this.f62031f, null);
        } else {
            ofInt = ObjectAnimator.ofInt(this.f62024a0, "backgroundColor", getResources().getColor(R.color.f156943fx), getResources().getColor(R.color.f156932fm));
            z(this.Y, true);
            beginTransaction.remove(this.f62031f);
        }
        beginTransaction.addToBackStack(null);
        beginTransaction.commit();
        ofInt.setDuration(300L);
        ofInt.setEvaluator(new ArgbEvaluator());
        ofInt.setRepeatMode(2);
        ofInt.start();
        this.f62027d.q(z16);
    }

    public void H(int i3, boolean z16) {
        g gVar;
        NumberCheckBox numberCheckBox;
        ArrayList<String> arrayList = this.f62027d.f62123f.selectedPhotoList;
        int findFirstVisibleItemPosition = ((GridLayoutManager) this.Q.getLayoutManager()).findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = ((GridLayoutManager) this.Q.getLayoutManager()).findLastVisibleItemPosition();
        for (int i16 = findFirstVisibleItemPosition; i16 <= findLastVisibleItemPosition; i16++) {
            if (!z16 || i3 == i16) {
                View childAt = this.Q.getChildAt(i16 - findFirstVisibleItemPosition);
                LocalMediaInfo p16 = this.f62034h.p(i16);
                if (childAt == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhotoListActivity", 2, "updateCheckbox view = null at " + i16);
                    }
                } else if (p16 == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d("PhotoListActivity", 2, "updateCheckbox info = null at " + i16);
                    }
                } else if (i3 != i16) {
                    int indexOf = arrayList.indexOf(p16.path);
                    if (indexOf >= 0 && (gVar = (g) this.Q.getChildViewHolder(childAt)) != null && (numberCheckBox = gVar.f62058i) != null) {
                        numberCheckBox.setCheckedNumber(indexOf + 1 + this.f62027d.f62125i.initialHasPickedNum);
                    }
                } else {
                    int mediaType = QAlbumUtil.getMediaType(p16);
                    if (mediaType == 0 || mediaType == 1) {
                        g gVar2 = (g) this.Q.getChildViewHolder(childAt);
                        int i17 = p16.selectStatus;
                        if (i17 == 1) {
                            gVar2.f62058i.setCheckedNumber(arrayList.indexOf(p16.path) + 1 + this.f62027d.f62125i.initialHasPickedNum);
                            if (childAt.getBackground() != null) {
                                childAt.setBackgroundDrawable(null);
                            }
                        } else if (i17 == 3) {
                            gVar2.f62058i.setChecked(false);
                        } else {
                            gVar2.f62058i.setChecked(false);
                            if (childAt.getBackground() != null) {
                                childAt.setBackgroundDrawable(null);
                            }
                        }
                        if (AppSetting.f99565y) {
                            gVar2.f62058i.setContentDescription(QAlbumUtil.createContentDescriptionWithCheckBox(mediaType, p16, i16, gVar2.f62058i.isChecked()));
                        }
                    }
                }
            }
        }
    }

    public void K(boolean z16) {
        I(z16);
        G(z16);
    }

    @Override // com.tencent.aelight.camera.ae.album.AEAlbumPreviewMaskLayout.a
    public void c() {
        this.f62027d.x();
    }

    public void n() {
        Dialog dialog = this.f62038j0;
        if (dialog != null) {
            try {
                dialog.cancel();
            } catch (IllegalArgumentException e16) {
                if (QLog.isColorLevel()) {
                    QLog.e("PhotoListActivity", 2, "cancel dialog error", e16);
                }
            }
        }
    }

    public void o() {
        if (this.R.getVisibility() == 0) {
            Runnable runnable = this.U;
            if (runnable != null) {
                this.R.removeCallbacks(runnable);
            }
            this.R.setVisibility(8);
            AECameraPrefsUtil.f().l(AECameraConstants.SP_KEY_AE_PHOTO_SWITCH_RATIO_TIPS, true, 0);
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        if (compoundButton.getId() == R.id.h1y) {
            this.f62027d.y(compoundButton, z16);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ArrayList<String> arrayList;
        int i3;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (this.f62027d != null) {
            int id5 = view.getId();
            if (id5 == R.id.rvd) {
                this.f62027d.E(view);
            } else if (id5 == R.id.fyh) {
                this.f62027d.w(view);
            } else if (id5 == R.id.send_btn) {
                this.f62027d.D(view);
            } else {
                if (id5 == R.id.rvc) {
                    AEAbstractAlbumListFragment aEAbstractAlbumListFragment = this.f62031f;
                    boolean z16 = aEAbstractAlbumListFragment == null || !aEAbstractAlbumListFragment.isAdded();
                    if (z16) {
                        this.f62027d.k(getActivity().getIntent());
                    }
                    F(z16);
                } else if (id5 == R.id.rve) {
                    this.f62027d.s(view);
                    PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62027d.f62123f;
                    if (photoCommonBaseData != null && (arrayList = photoCommonBaseData.selectedPhotoList) != null) {
                        int size = arrayList.size();
                        AEBaseReportParam.U().f().f65712d = AEBaseReportParam.U().X();
                        if (this.f62027d.f62125i.canMixPhotoAndVideo) {
                            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.Z.longValue();
                            Iterator<String> it = this.f62027d.f62123f.selectedPhotoList.iterator();
                            long j3 = 0;
                            i3 = 0;
                            while (it.hasNext()) {
                                LocalMediaInfo v3 = v(it.next());
                                if (v3 != null && QAlbumUtil.getMediaType(v3) == 1) {
                                    i3++;
                                    j3 += v3.mDuration / 1000;
                                }
                            }
                            AEBaseReportParam.U().f().f65730v = i3;
                            AEBaseReportParam.U().f().f65731w = j3;
                            size -= i3;
                        } else {
                            AEBaseReportParam.U().f().f65729u = AEBaseReportParam.W.longValue();
                            i3 = 0;
                        }
                        com.tencent.aelight.camera.ae.report.b.b().C(size);
                        com.tencent.aelight.camera.aebase.c.g(this.f62027d.f62125i.initialHasPickedNum > 0, size, i3, "1");
                    }
                } else if (id5 == R.id.s3u) {
                    this.f62027d.v(view);
                    o();
                    J(true, true);
                }
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT > 23) {
            getActivity().getWindow().setBackgroundDrawable(null);
        }
        com.tencent.aelight.camera.ae.album.logic.c s16 = s();
        this.f62027d = s16;
        this.f62029e = s16.f62124h;
        this.f62036i = BaseApplication.getContext().getSharedPreferences("share", 4);
        Resources resources = getResources();
        int i3 = resources.getDisplayMetrics().widthPixels;
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.c6x);
        this.D = dimensionPixelSize;
        int i16 = (i3 - (dimensionPixelSize * 2)) / 3;
        this.f62040m = i16;
        this.C = i16;
        Intent intent = getActivity().getIntent();
        this.f62027d.n(intent);
        if (QLog.isColorLevel()) {
            QLog.d("SelectPhotoTrace", 2, "PhotoListActivity onCreate(),extra is:" + intent.getExtras());
        }
        if (QLog.isColorLevel()) {
            QLog.d("SelectPhotoTrace", 2, "PhotoListActivity,hashCode is:" + System.identityHashCode(this));
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f62027d.i();
        AEAlbumLinearLayout aEAlbumLinearLayout = this.G;
        if (aEAlbumLinearLayout != null) {
            aEAlbumLinearLayout.setScrollListener(null);
        }
        AEAlbumPreviewMaskLayout aEAlbumPreviewMaskLayout = this.P;
        if (aEAlbumPreviewMaskLayout != null) {
            aEAlbumPreviewMaskLayout.setOnTouchCallback(null);
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onPause() {
        ms.a.f("PhotoListActivity", "onPause---");
        super.onPause();
        this.f62039k0 = null;
        o();
        BaseVideoView baseVideoView = this.K;
        if (baseVideoView == null || !baseVideoView.isPlaying()) {
            return;
        }
        this.f62026c0 = true;
        this.K.pause();
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportFragment, android.app.Fragment
    public void onResume() {
        ms.a.f("PhotoListActivity", "onResume---");
        super.onResume();
        this.f62027d.j();
        BaseVideoView baseVideoView = this.K;
        if (baseVideoView == null || !this.f62026c0) {
            return;
        }
        this.f62026c0 = false;
        baseVideoView.resume();
    }

    @Override // android.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        x(view);
    }

    public void p() {
        if (this.R.getVisibility() == 0 || AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_PHOTO_SWITCH_RATIO_TIPS, false, 0)) {
            return;
        }
        this.R.setIncludeFontPadding(false);
        int b16 = UIUtils.b(getActivity(), 8.0f);
        int b17 = UIUtils.b(getActivity(), 6.0f);
        this.R.setPadding(b16, b17, b16, b17);
        this.R.setTextSize(1, 14.0f);
        this.R.setTextColor(-1);
        this.R.f62581m = Color.parseColor("#252525");
        this.R.f62578f = UIUtils.b(getActivity(), 6.0f);
        BubbleTextView bubbleTextView = this.R;
        bubbleTextView.D = false;
        bubbleTextView.f62580i = UIUtils.b(getActivity(), 6.0f);
        this.R.setText(getActivity().getString(R.string.y1j));
        this.R.a();
        this.R.setVisibility(0);
        boolean c16 = AECameraPrefsUtil.f().c(AECameraConstants.SP_KEY_AE_PHOTO_SWITCH_RATIO_TIPS_SHOULD_AUTO_DISAPPEAR, true, 0);
        ms.a.a("PhotoListActivity", "checkShowSwitchRatioTips--shouldAutoDisappear=" + c16);
        if (c16) {
            Runnable runnable = new Runnable() { // from class: com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.7
                @Override // java.lang.Runnable
                public void run() {
                    AEAbstractPhotoListFragment.this.o();
                }
            };
            this.U = runnable;
            this.R.postDelayed(runnable, 5000L);
        }
    }

    public void r(boolean z16, boolean z17) {
        h hVar = new h(z16, z17);
        this.f62039k0 = hVar;
        hVar.execute(new Object[0]);
    }

    protected abstract com.tencent.aelight.camera.ae.album.logic.c s();

    public abstract AEAbstractAlbumListFragment t();

    protected Dialog u() {
        return new ReportDialog(getActivity());
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment.c
    public void d() {
        F(false);
    }

    public void w() {
        J(false, false);
        o();
    }

    public void C() {
        J(true, false);
        p();
    }

    @Override // com.tencent.aelight.camera.ae.album.fragment.AEAbstractAlbumListFragment.c
    public void a(QQAlbumInfo qQAlbumInfo, int i3, boolean z16) {
        if (z16) {
            ms.a.f("PhotoListActivity", "onAlbumListChoose--albumId=" + qQAlbumInfo.f203112id);
            PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62027d.f62123f;
            String str = qQAlbumInfo.name;
            photoCommonBaseData.albumName = str;
            photoCommonBaseData.albumId = qQAlbumInfo.f203112id;
            if (str == null) {
                str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            }
            B(str);
            this.f62029e.f184290a = true;
            getActivity().runOnUiThread(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.8
                @Override // java.lang.Runnable
                public void run() {
                    AEAbstractPhotoListFragment.this.r(false, true);
                }
            });
        }
        F(false);
    }

    public boolean y(LocalMediaInfo localMediaInfo) {
        return localMediaInfo != null && "image/gif".equals(localMediaInfo.mMimeType);
    }

    private void q(View view) {
        this.T = (ImageView) view.findViewById(R.id.rvj);
        this.K = (BaseVideoView) QQVideoViewFactory.createBaseVideoView(getActivity(), 126L, null, null);
        this.I.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.5
            @Override // java.lang.Runnable
            public void run() {
                int indexOfChild = AEAbstractPhotoListFragment.this.I.indexOfChild(AEAbstractPhotoListFragment.this.R) + 1;
                int min = Math.min(AEAbstractPhotoListFragment.this.I.getWidth(), AEAbstractPhotoListFragment.this.I.getHeight());
                ms.a.f("PhotoListActivity", "createVideoPreviewView--length=" + min);
                AEAbstractPhotoListFragment.this.I.addView(AEAbstractPhotoListFragment.this.K, Math.max(0, indexOfChild), new FrameLayout.LayoutParams(min, min));
                AEAbstractPhotoListFragment.this.K.setVisibility(4);
            }
        });
        this.K.setOnClickListener(new d());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void x(View view) {
        this.f62024a0 = (FrameLayout) view.findViewById(R.id.f163727ro4);
        this.W = view.findViewById(R.id.rvd);
        this.V = (TextView) view.findViewById(R.id.rve);
        this.W.setVisibility(0);
        this.W.setOnClickListener(this);
        this.V.setVisibility(0);
        this.V.setOnClickListener(this);
        this.X = (TextView) view.findViewById(R.id.rvg);
        PhotoCommonBaseData<OtherCommonData> photoCommonBaseData = this.f62027d.f62123f;
        String str = photoCommonBaseData.albumName;
        if (str == null) {
            if (photoCommonBaseData.showMediaType == 2) {
                str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME_VIDEO;
            } else {
                str = QAlbumCustomAlbumConstants.RECENT_ALBUM_NAME;
            }
        }
        B(str);
        this.Y = view.findViewById(R.id.rvf);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.rvc);
        this.Z = linearLayout;
        linearLayout.setOnClickListener(this);
        this.F = (FrameLayout) view.findViewById(R.id.rto);
        AEAlbumLinearLayout aEAlbumLinearLayout = (AEAlbumLinearLayout) view.findViewById(R.id.rnv);
        this.G = aEAlbumLinearLayout;
        aEAlbumLinearLayout.setScrollListener(new b());
        AECropperView aECropperView = (AECropperView) view.findViewById(R.id.rnw);
        this.J = aECropperView;
        aECropperView.setMaxZoom(5.0f);
        this.R = (BubbleTextView) view.findViewById(R.id.f163799s24);
        AEAlbumPreviewMaskLayout aEAlbumPreviewMaskLayout = (AEAlbumPreviewMaskLayout) view.findViewById(R.id.rtp);
        this.P = aEAlbumPreviewMaskLayout;
        aEAlbumPreviewMaskLayout.setOnTouchCallback(this);
        this.L = (ViewGroup) view.findViewById(R.id.rwn);
        this.M = (ImageView) view.findViewById(R.id.rvz);
        this.N = (TextView) view.findViewById(R.id.s3s);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.f163774ry1);
        this.Q = recyclerView;
        ((DefaultItemAnimator) recyclerView.getItemAnimator()).setSupportsChangeAnimations(false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        this.H = gridLayoutManager;
        this.Q.setLayoutManager(gridLayoutManager);
        e eVar = new e();
        this.f62034h = eVar;
        this.Q.setAdapter(eVar);
        this.I = (FrameLayout) view.findViewById(R.id.ryk);
        q(view);
        TextView textView = (TextView) view.findViewById(R.id.s3p);
        this.S = textView;
        textView.setOnClickListener(new c());
        TextView textView2 = (TextView) view.findViewById(R.id.s3u);
        this.f62028d0 = textView2;
        textView2.setOnClickListener(this);
        this.f62027d.F();
    }

    private void G(boolean z16) {
        int dimensionPixelSize = z16 ? 0 : getResources().getDimensionPixelSize(R.dimen.f13109_);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.F.getLayoutParams();
        marginLayoutParams.bottomMargin = dimensionPixelSize;
        this.F.setLayoutParams(marginLayoutParams);
    }

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final View inflate = layoutInflater.inflate(R.layout.dlr, viewGroup, false);
        ViewCompat.setOnApplyWindowInsetsListener(inflate, new a());
        if (inflate != null) {
            inflate.post(new Runnable() { // from class: com.tencent.aelight.camera.ae.album.fragment.AEAbstractPhotoListFragment.2
                @Override // java.lang.Runnable
                public void run() {
                    ViewCompat.requestApplyInsets(inflate);
                }
            });
        }
        FragmentCollector.onFragmentViewCreated(this, inflate);
        return inflate;
    }

    private void I(boolean z16) {
        if (z16) {
            if (this.f62033g0 == null) {
                Drawable drawable = getResources().getDrawable(R.drawable.iy7);
                this.f62033g0 = drawable;
                drawable.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0f), ImmersiveUtils.dpToPx(30.0f));
            }
            this.S.setCompoundDrawables(this.f62033g0, null, null, null);
            this.S.setText(R.string.f169873y24);
        } else {
            if (this.f62035h0 == null) {
                Drawable drawable2 = getResources().getDrawable(R.drawable.iy6);
                this.f62035h0 = drawable2;
                drawable2.setBounds(0, 0, ImmersiveUtils.dpToPx(30.0f), ImmersiveUtils.dpToPx(30.0f));
            }
            this.S.setCompoundDrawables(this.f62035h0, null, null, null);
            this.S.setText(R.string.f169874y25);
        }
        this.S.setPadding(0, 0, ImmersiveUtils.dpToPx(10.0f), 0);
    }

    /* loaded from: classes32.dex */
    public class e extends RecyclerView.Adapter<g> implements URLDrawableDownListener {

        /* renamed from: e, reason: collision with root package name */
        public Drawable f62047e;

        /* renamed from: h, reason: collision with root package name */
        public LayoutInflater f62049h;

        /* renamed from: d, reason: collision with root package name */
        public ArrayList<LocalMediaInfo> f62046d = new ArrayList<>();

        /* renamed from: f, reason: collision with root package name */
        public ColorDrawable f62048f = new ColorDrawable(570425344);

        public e() {
            this.f62049h = AEAbstractPhotoListFragment.this.getActivity().getLayoutInflater();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.f62046d.size();
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        public int getItemViewType(int i3) {
            return QAlbumUtil.getMediaType(this.f62046d.get(i3));
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View view, URLDrawable uRLDrawable) {
            new Rect();
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) uRLDrawable.getTag();
            int i3 = localMediaInfo.listViewPosition;
            if (i3 == -1 || localMediaInfo.visableTime == 0) {
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis() - localMediaInfo.visableTime;
            if (QLog.isColorLevel()) {
                QLog.d("PhotoListActivity", 2, "onLoadSuccessed,no next ,listViewPositon:" + i3 + " costTime:" + uptimeMillis + " imageInfo;" + localMediaInfo);
            }
        }

        public LocalMediaInfo p(int i3) {
            return this.f62046d.get(i3);
        }

        public TextView q() {
            TextView textView = new TextView(AEAbstractPhotoListFragment.this.getActivity());
            textView.setGravity(17);
            textView.setTextSize(10.0f);
            textView.setTextColor(-1);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setSize(QAlbumCommonUtil.dp2px(30.0f, AEAbstractPhotoListFragment.this.getResources()), QAlbumCommonUtil.dp2px(18.0f, AEAbstractPhotoListFragment.this.getResources()));
            gradientDrawable.setCornerRadii(new float[]{QAlbumCommonUtil.dp2px(2.0f, AEAbstractPhotoListFragment.this.getResources()), QAlbumCommonUtil.dp2px(2.0f, AEAbstractPhotoListFragment.this.getResources()), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f});
            gradientDrawable.setColor(1291845632);
            textView.setBackgroundDrawable(gradientDrawable);
            return textView;
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: r, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(g gVar, int i3) {
            c.a aVar;
            f fVar = new f();
            int itemViewType = getItemViewType(i3);
            if (itemViewType == 0) {
                c.a aVar2 = AEAbstractPhotoListFragment.this.f62027d.C;
                if (aVar2 != null) {
                    aVar2.g(i3, gVar, fVar);
                    return;
                }
                return;
            }
            if (itemViewType != 1) {
                if (itemViewType == 2 && (aVar = AEAbstractPhotoListFragment.this.f62027d.C) != null) {
                    aVar.a(i3, gVar, fVar);
                    return;
                }
                return;
            }
            c.a aVar3 = AEAbstractPhotoListFragment.this.f62027d.C;
            if (aVar3 != null) {
                aVar3.b(i3, gVar, fVar);
            }
        }

        public void t(List<LocalMediaInfo> list, boolean z16) {
            this.f62046d.clear();
            if (list == null || list.size() == 0) {
                return;
            }
            if (!AEAbstractPhotoListFragment.this.f62029e.f184306q && QAlbumUtil.getMediaType(list.get(0)) == 2) {
                list.remove(0);
            }
            this.f62046d.addAll(list);
            AEAbstractPhotoListFragment.this.f62027d.H(this.f62046d, z16);
        }

        @Override // android.support.v7.widget.RecyclerView.Adapter
        /* renamed from: s, reason: merged with bridge method [inline-methods] */
        public g onCreateViewHolder(ViewGroup viewGroup, int i3) {
            if (i3 == 0) {
                if (AEAbstractPhotoListFragment.this.f62027d.C == null) {
                    return null;
                }
                AEAbstractPhotoListFragment aEAbstractPhotoListFragment = AEAbstractPhotoListFragment.this;
                return new g(aEAbstractPhotoListFragment.f62027d.C.d());
            }
            if (i3 != 1) {
                if (i3 != 2 || AEAbstractPhotoListFragment.this.f62027d.C == null) {
                    return null;
                }
                AEAbstractPhotoListFragment aEAbstractPhotoListFragment2 = AEAbstractPhotoListFragment.this;
                return new g(aEAbstractPhotoListFragment2.f62027d.C.f());
            }
            if (AEAbstractPhotoListFragment.this.f62027d.C == null) {
                return null;
            }
            AEAbstractPhotoListFragment aEAbstractPhotoListFragment3 = AEAbstractPhotoListFragment.this;
            return new g(aEAbstractPhotoListFragment3.f62027d.C.c());
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View view, URLDrawable uRLDrawable) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View view, URLDrawable uRLDrawable, Throwable th5) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View view, URLDrawable uRLDrawable, InterruptedException interruptedException) {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View view, URLDrawable uRLDrawable, int i3) {
        }
    }

    public static void z(View view, boolean z16) {
        RotateAnimation rotateAnimation = new RotateAnimation(z16 ? 180.0f : 0.0f, z16 ? 360.0f : 180.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setFillAfter(true);
        view.startAnimation(rotateAnimation);
    }
}
