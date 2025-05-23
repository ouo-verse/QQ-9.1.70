package com.qzone.publish.ui.publishmodule;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.tool.ReportUtils;
import com.qzone.util.image.ImageInfo;
import com.qzone.widget.AsyncMarkImageView;
import com.qzone.widget.PhotoCarouselView;
import com.tencent.component.utils.preference.PreferenceManager;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.GridView;
import common.config.service.QzoneConfig;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class d extends com.qzone.publish.ui.publishmodule.b {
    private LinearLayout C;
    private View D;
    private View E;
    private AsyncMarkImageView F;
    private View G;
    private TextView H;
    private ImageInfo I = null;
    boolean J = false;
    boolean K = false;
    ArrayList<ImageInfo> L = new ArrayList<>();
    protected ArrayList<ImageInfo> M = new ArrayList<>();
    ArrayList<ImageInfo> N = new ArrayList<>();
    protected ArrayList<LocalMediaInfo> P = new ArrayList<>();
    private int Q = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_MOOD_RECENT_PHOTO_COUNT, 10);
    boolean R = false;
    private HashMap<String, ImageInfo> S = new HashMap<>();
    private Comparator<ImageInfo> T = new b();
    private ArrayList<String> U = new ArrayList<>();

    /* renamed from: h, reason: collision with root package name */
    private boolean f51998h;

    /* renamed from: i, reason: collision with root package name */
    private l5.a f51999i;

    /* renamed from: m, reason: collision with root package name */
    private RelativeLayout f52000m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            d.this.y();
            LpReportInfo_pf00064.allReport(586, 34, 5);
            HashMap hashMap = new HashMap();
            hashMap.put("clickClose", String.valueOf(1));
            ReportUtils.b("guessPhoto", hashMap);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Comparator<ImageInfo> {
        b() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(ImageInfo imageInfo, ImageInfo imageInfo2) {
            return -Long.valueOf(imageInfo.mModifiedDate).compareTo(Long.valueOf(imageInfo2.mModifiedDate));
        }
    }

    private long u() {
        long currentTimeMillis = System.currentTimeMillis();
        l5.a aVar = this.f51999i;
        if (aVar == null || aVar.isCacheExpired(currentTimeMillis)) {
            return 1L;
        }
        return this.f51999i.openPhotoCarousel;
    }

    public static int v() {
        return QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PUBLISH_MOOD, QzoneConfig.SECONDARY_RECENT_PHOTO_CAROUSEL_COUNT, 5);
    }

    public boolean A() {
        ArrayList<ImageInfo> arrayList = this.N;
        return arrayList != null && arrayList.size() > 0;
    }

    public boolean B() {
        return u() == 2;
    }

    public boolean C() {
        return u() == 1;
    }

    public boolean D() {
        RelativeLayout relativeLayout = this.f52000m;
        if (relativeLayout != null && relativeLayout.isShown()) {
            return true;
        }
        View view = this.E;
        return view != null && view.isShown();
    }

    public void E(boolean z16) {
        ArrayList<ImageInfo> arrayList;
        if (this.I == null || b().U == null || (arrayList = this.N) == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < b().U.size(); i3++) {
            String str = b().U.get(i3);
            LocalMediaInfo localMediaInfo = b().W.get(str);
            if (localMediaInfo != null) {
                arrayList2.add(localMediaInfo);
            } else {
                QZLog.d("RecentPhotoModule", 4, "machineLearningReport:" + str + "is not from photo picker");
            }
        }
        for (int i16 = 0; i16 < this.M.size(); i16++) {
            this.M.get(i16);
        }
        this.N.removeAll(this.M);
    }

    public void G(l5.a aVar) {
        this.f51999i = aVar;
    }

    public void H(boolean z16, GridView gridView, e9.a aVar, List<ImageInfo> list, Context context) {
        View childAt;
        if (z16 == this.f51998h || gridView == null || aVar == null || context == null) {
            return;
        }
        try {
            int lastVisiblePosition = gridView.getLastVisiblePosition();
            if ((aVar.d0(lastVisiblePosition) || aVar.d0(lastVisiblePosition + 1)) && (childAt = gridView.getChildAt(lastVisiblePosition)) != null) {
                PhotoCarouselView photoCarouselView = (PhotoCarouselView) childAt.findViewById(R.id.hst);
                ImageView imageView = (ImageView) childAt.findViewById(R.id.ht7);
                TextView textView = (TextView) childAt.findViewById(R.id.ht9);
                if (z16 && list != null) {
                    imageView.setImageResource(R.drawable.g7a);
                    textView.setTextColor(-1);
                    if (photoCarouselView != null) {
                        photoCarouselView.setImageInfos(list);
                        photoCarouselView.c(100L);
                        LpReportInfo_pf00064.allReport(586, 33, 3);
                        this.f51998h = true;
                    }
                } else {
                    imageView.setImageResource(R.drawable.g7_);
                    textView.setTextColor(context.getResources().getColor(R.color.a8i));
                    photoCarouselView.setVisibility(8);
                    this.f51998h = false;
                }
            }
        } catch (Throwable th5) {
            QZLog.d("RecentPhotoModule", 1, "switchPhotoCarouse error: ", th5);
        }
    }

    public void I(long j3) {
        SharedPreferences defaultPreference = PreferenceManager.getDefaultPreference(BaseApplication.getContext(), LoginData.getInstance().getUin());
        if (defaultPreference != null) {
            SharedPreferences.Editor edit = defaultPreference.edit();
            edit.putLong("last_entry", j3);
            edit.commit();
        }
    }

    public void J(boolean z16) {
        SharedPreferences defaultPreference = PreferenceManager.getDefaultPreference(BaseApplication.getContext(), LoginData.getInstance().getUin());
        if (defaultPreference != null) {
            SharedPreferences.Editor edit = defaultPreference.edit();
            edit.putBoolean("new_photo_red_dot", z16);
            edit.commit();
        }
    }

    public void t() {
        AsyncMarkImageView asyncMarkImageView;
        View view = this.E;
        if (view == null || view.getVisibility() != 0 || (asyncMarkImageView = this.F) == null) {
            return;
        }
        asyncMarkImageView.getLayoutParams().width = this.F.getHeight();
    }

    public ImageInfo w() {
        return this.I;
    }

    public boolean x(MotionEvent motionEvent) {
        RelativeLayout relativeLayout = this.f52000m;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            int[] iArr = new int[2];
            this.f52000m.getLocationOnScreen(iArr);
            int i3 = iArr[0];
            if (new Rect(i3, iArr[1], this.f52000m.getWidth() + i3, iArr[1] + this.f52000m.getHeight()).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                return false;
            }
            y();
            return true;
        }
        View view = this.E;
        if (view == null || view.getVisibility() != 0) {
            return false;
        }
        int[] iArr2 = new int[2];
        this.E.getLocationOnScreen(iArr2);
        int i16 = iArr2[0];
        if (new Rect(i16, iArr2[1], this.E.getWidth() + i16, iArr2[1] + this.E.getHeight()).contains((int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
            return false;
        }
        y();
        return true;
    }

    public void y() {
        if (e().P2 != -1) {
            e().Q2 = System.currentTimeMillis() - e().P2;
            QZLog.d("RecentPhotoModule", 4, "recentPhotoExposureTime:" + e().Q2);
        }
        RelativeLayout relativeLayout = this.f52000m;
        if (relativeLayout != null && relativeLayout.getVisibility() == 0) {
            this.f52000m.setVisibility(8);
        }
        View view = this.E;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.E.setVisibility(8);
    }

    public void F() {
        J(false);
        I(System.currentTimeMillis());
    }

    public void z() {
        this.f52000m = (RelativeLayout) a(R.id.iug);
        this.C = (LinearLayout) a(R.id.i1a);
        View a16 = a(R.id.iud);
        this.D = a16;
        a16.setOnClickListener(new a());
        this.E = a(R.id.ezk);
        int R = b().P.R();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.E.getLayoutParams();
        layoutParams.height = ViewUtils.dpToPx(1.0f) + R;
        layoutParams.setMargins(R + ViewUtils.dpToPx(21.5f), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        this.F = (AsyncMarkImageView) a(R.id.dxq);
        this.H = (TextView) a(R.id.ezn);
        this.G = a(R.id.ezm);
    }
}
