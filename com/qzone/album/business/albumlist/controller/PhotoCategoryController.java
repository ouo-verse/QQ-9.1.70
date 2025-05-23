package com.qzone.album.business.albumlist.controller;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.qzone.album.business.albumlist.activity.QzonePhotoCategoryActivity;
import com.qzone.album.business.albumlist.activity.QzonePhotoCategoryDetailsActivity;
import com.qzone.album.business.photolist.adapter.y;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.qzone.album.ui.widget.c;
import com.qzone.common.activities.base.BaseActivity;
import com.qzone.common.lifecycle.utils.ViewModelProviders;
import com.qzone.detail.ui.component.FeedDetailCommentTips;
import com.qzone.util.ar;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AdapterView;
import com.tencent.widget.ListView;
import common.config.service.QzoneConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.NetworkState;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

/* loaded from: classes39.dex */
public class PhotoCategoryController extends i4.a implements com.qzone.album.env.common.c {
    private View C;
    private View D;
    private String E;
    private int F;
    private String G;
    private String H;
    private String I;
    Runnable J;
    int K;
    int L;
    private Handler M;
    public com.qzone.album.ui.widget.c N;

    /* renamed from: f, reason: collision with root package name */
    private com.qzone.album.business.albumlist.viewmodel.a f42091f;

    /* renamed from: h, reason: collision with root package name */
    private y f42092h;

    /* renamed from: i, reason: collision with root package name */
    private QZonePullToRefreshListView f42093i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f42094m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class c implements Observer<ArrayList<PhotoCategorySummaryInfo>> {
        c() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(ArrayList<PhotoCategorySummaryInfo> arrayList) {
            QZLog.d("[PhotoAlbum]PhotoCategoryController", 1, "PhotoCategorySummaryInfo onChanged...");
            PhotoCategoryController.this.L0(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class d implements Observer<Integer> {
        d() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Integer num) {
            QZLog.d("[PhotoAlbum]PhotoCategoryController", 1, "UiCallback onChanged... type:", num);
            int intValue = num.intValue();
            if (intValue != 7) {
                if (intValue != 8) {
                    return;
                }
                com.qzone.album.env.common.a.m().V(QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "ToastModifyRemarkFail", "\u4fee\u6539\u5907\u6ce8\u5931\u8d25"));
            } else {
                PhotoCategoryController.this.y0();
                PhotoCategoryController.this.O0(3);
                PhotoCategoryController.this.P0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class e implements Observer<Boolean> {
        e() {
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onChanged(Boolean bool) {
            QZLog.d("[PhotoAlbum]PhotoCategoryController", 1, "hasMore onChanged... hasMore:", bool);
            PhotoCategoryController.this.y0();
            if (bool.booleanValue()) {
                PhotoCategoryController.this.O0(5);
            } else {
                PhotoCategoryController.this.O0(7);
            }
            PhotoCategoryController.this.P0();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class f implements View.OnClickListener {
        f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            QZoneHelper.forwardToBrowser(((i4.a) PhotoCategoryController.this).f407174e, PhotoCategoryController.this.E, -1, null, null);
            u4.c.a().r("326", "7", "2");
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class g implements AdapterView.OnItemClickListener {
        g() {
        }

        @Override // com.tencent.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i3, long j3) {
            QZLog.i("[PhotoAlbum]PhotoCategoryController", "click position " + i3);
            PhotoCategorySummaryInfo photoCategorySummaryInfo = (PhotoCategorySummaryInfo) PhotoCategoryController.this.f42092h.getItem(i3 - PhotoCategoryController.this.f42093i.getHeaderViewsCount());
            if (photoCategorySummaryInfo != null) {
                Intent intent = new Intent();
                ParcelableWrapper.putDataToIntent(intent, "categorydetialssummaryinfo", photoCategorySummaryInfo);
                intent.setClass(((i4.a) PhotoCategoryController.this).f407174e, QzonePhotoCategoryDetailsActivity.class);
                PhotoCategoryController.this.W(intent, 17);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class h implements y.f {
        h() {
        }

        @Override // com.qzone.album.business.photolist.adapter.y.f
        public void a(int i3) {
            PhotoCategoryController.this.f42091f.K = i3;
            u4.c.a().h(((i4.a) PhotoCategoryController.this).f407174e, -1, 1001);
            u4.c.a().r("326", "5", "2");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class i implements y.e {
        i() {
        }

        @Override // com.qzone.album.business.photolist.adapter.y.e
        public void a(ArrayList<PhotoCategorySummaryInfo> arrayList, int i3) {
            PhotoCategorySummaryInfo photoCategorySummaryInfo;
            if (PhotoCategoryController.this.f42092h == null || arrayList == null || i3 >= arrayList.size() || (photoCategorySummaryInfo = arrayList.get(i3)) == null) {
                return;
            }
            photoCategorySummaryInfo.needShow = false;
            PhotoCategoryController.this.f42091f.I = true;
            PhotoCategoryController.this.f42091f.K = i3;
            PhotoCategoryController.this.F = 1;
            PhotoCategoryController.this.f42091f.N1(PhotoCategoryController.this.F, photoCategorySummaryInfo, photoCategorySummaryInfo.faceUin + "", photoCategorySummaryInfo.nick);
            photoCategorySummaryInfo.faceStatus = 1;
            PhotoCategoryController.this.f42092h.notifyDataSetChanged();
            LpReportInfo_pf00064.allReport(326, 5, 4);
            PhotoCategoryController.this.R0();
        }

        @Override // com.qzone.album.business.photolist.adapter.y.e
        public void b(ArrayList<PhotoCategorySummaryInfo> arrayList, int i3) {
            PhotoCategorySummaryInfo photoCategorySummaryInfo;
            if (PhotoCategoryController.this.f42092h == null || arrayList == null || i3 >= arrayList.size() || (photoCategorySummaryInfo = arrayList.get(i3)) == null) {
                return;
            }
            photoCategorySummaryInfo.needShow = false;
            PhotoCategoryController.this.f42091f.K = i3;
            PhotoCategoryController.this.F = 7;
            PhotoCategoryController.this.f42091f.N1(PhotoCategoryController.this.F, photoCategorySummaryInfo, photoCategorySummaryInfo.faceUin + "", photoCategorySummaryInfo.nick);
            photoCategorySummaryInfo.faceStatus = 0;
            PhotoCategoryController.this.f42092h.notifyDataSetChanged();
            LpReportInfo_pf00064.allReport(326, 5, 5);
            PhotoCategoryController.this.R0();
        }
    }

    public PhotoCategoryController(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.G = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_PORTRAIT_TEXT, QzoneConfig.DefaultValue.DEFAULT_PORTRAIT_TEXT);
        this.H = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_LOCATION_TEXT, QzoneConfig.DefaultValue.DEFAULT_LOCATION_TEXT);
        this.I = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.QZONE_CONFIG_SECONDARY_KEY_LABEL_TEXT, QzoneConfig.DefaultValue.DEFAULT_LABEL_TEXT);
        this.J = new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryController.10
            @Override // java.lang.Runnable
            public void run() {
                PhotoCategoryController photoCategoryController = PhotoCategoryController.this;
                photoCategoryController.K = 0;
                photoCategoryController.R0();
            }
        };
        this.K = 0;
        this.L = -1;
        this.M = new a();
        this.f42091f = (com.qzone.album.business.albumlist.viewmodel.a) ViewModelProviders.of((BaseActivity) this.f407174e).get(com.qzone.album.business.albumlist.viewmodel.a.class);
    }

    private void B0() {
        if (this.f407174e instanceof QzonePhotoCategoryActivity) {
            String config = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePhotoLeft", "\u7167\u7247");
            String config2 = QzoneConfig.getInstance().getConfig(WnsConfig.MAIN_KEY_QZONE_TEXT_SETTING, "TitlePhotoRight", "\u6211\u7684\u8db3\u8ff9");
            ((QzonePhotoCategoryActivity) this.f407174e).x().setText(config);
            if (this.f42091f.P1() == 1) {
                ((QzonePhotoCategoryActivity) this.f407174e).setTitle(this.G);
                return;
            }
            if (this.f42091f.P1() == 4) {
                ((QzonePhotoCategoryActivity) this.f407174e).setTitle(this.I);
                return;
            }
            if (this.f42091f.P1() == 2) {
                ((QzonePhotoCategoryActivity) this.f407174e).setTitle(this.H);
                boolean z16 = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_CATEGORY_MY_TRACKS_DISPLAY, 1) == 1;
                this.E = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_CATEGORY_MY_TRACKS_URL, "https://h5.qzone.qq.com/activity/travel2016?_wv=4097&_wwv=4");
                if (!z16 || ((QzonePhotoCategoryActivity) this.f407174e).u() == null) {
                    return;
                }
                ((QzonePhotoCategoryActivity) this.f407174e).u().setText(config2);
                ((QzonePhotoCategoryActivity) this.f407174e).u().setVisibility(8);
                ((QzonePhotoCategoryActivity) this.f407174e).u().setOnClickListener(new f());
                return;
            }
            ((QzonePhotoCategoryActivity) this.f407174e).setTitle(this.I);
        }
    }

    private boolean C0(boolean z16) {
        boolean z17 = false;
        if (this.C != null) {
            return false;
        }
        QZonePullToRefreshListView qZonePullToRefreshListView = this.f42093i;
        if (qZonePullToRefreshListView != null && qZonePullToRefreshListView.j0() != null) {
            this.f42094m = new FrameLayout(this.f407174e);
            this.f42093i.j0().addFooterView(this.f42094m);
            FeedDetailCommentTips feedDetailCommentTips = new FeedDetailCommentTips(this.f407174e, w0());
            this.C = feedDetailCommentTips;
            View d16 = feedDetailCommentTips.d();
            if (d16 != null) {
                d16.setBackgroundDrawable(null);
            }
            ((FeedDetailCommentTips) this.C).setLoadingDataText(this.f407174e.getString(R.string.f170931b54));
            ((FeedDetailCommentTips) this.C).setLoadingMoreDataText(this.f407174e.getString(R.string.f170932b55));
            z17 = true;
            ((FeedDetailCommentTips) this.C).K = true;
            if (!z16) {
                O0(5);
            } else {
                O0(3);
            }
            this.f42094m.addView(this.C);
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean D0() {
        return 1 == this.f42091f.P1();
    }

    private void E0() {
        com.qzone.album.env.common.a.m().u().post(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryController.13
            @Override // java.lang.Runnable
            public void run() {
                PhotoCategoryController.this.f42091f.T1(((i4.a) PhotoCategoryController.this).f407174e);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F0() {
        QZLog.d("[PhotoAlbum]PhotoCategoryController", 1, "loadMore...");
        O0(1);
        v0(true);
    }

    private View G0() {
        String config = QzoneConfig.getInstance().getConfig(QzoneConfig.MAIN_KEY_PHOTO_ALBUM, QzoneConfig.SECONDARY_PHOTO_CATEGORY_LIST_HEADER_TIPS, QzoneConfig.DefaultValue.DEFAULT_CATEGORY_LIST_HEADER_TIPS);
        LinearLayout linearLayout = new LinearLayout(this.f407174e);
        linearLayout.setMinimumHeight(ar.e(34.0f));
        linearLayout.setBackgroundColor(-460552);
        linearLayout.setGravity(17);
        ImageView imageView = new ImageView(this.f407174e);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setImageResource(R.drawable.gb6);
        TextView textView = new TextView(this.f407174e);
        textView.setIncludeFontPadding(false);
        textView.setTextSize(14.0f);
        textView.setTextColor(RichStatus.ACTION_COLOR_NORMAL);
        textView.setText(config);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ar.e(13.0f), ar.e(13.0f));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.leftMargin = ar.e(3.0f);
        linearLayout.addView(imageView, layoutParams);
        linearLayout.addView(textView, layoutParams2);
        return linearLayout;
    }

    private void J0() {
        this.f42091f.a2(this.f407174e);
    }

    private void M0() {
        int P1 = this.f42091f.P1();
        if (P1 == 1) {
            u4.c.a().r("326", "5", "1");
        } else if (P1 == 2) {
            u4.c.a().r("326", "7", "1");
        } else {
            if (P1 != 4) {
                return;
            }
            u4.c.a().r("326", "10", "1");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N0() {
        if (this.f42093i.isOverscrollHeadVisiable() || this.f42093i.j0().getLastVisiblePosition() < this.f42093i.j0().getCount() - 1 || !this.f42091f.X1()) {
            return;
        }
        F0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O0(int i3) {
        if (this.f42094m == null || this.C == null) {
            return;
        }
        t4.a.N().L(this.f407174e, this.C, i3);
        if (i3 == 3) {
            if (this.f42094m.getVisibility() != 8) {
                this.f42094m.setVisibility(8);
            }
        } else if (this.f42094m.getVisibility() != 0) {
            this.f42094m.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        if (D0()) {
            com.qzone.album.env.common.a.m().I(this.J, 500L);
        }
    }

    private void Q0() {
        t0();
        int P1 = this.f42091f.P1();
        if (P1 == 1) {
            this.N.l(19);
        } else if (P1 == 2) {
            this.N.l(20);
        } else {
            if (P1 != 4) {
                return;
            }
            this.N.l(21);
        }
    }

    private void S0() {
        View view = this.D;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    private void T0() {
        u4.c.a().C(this.f407174e);
        Q0();
    }

    private void r0() {
        u4.c.a().n(this.f407174e);
    }

    private void s0() {
        this.f42091f.Q1().observe((BaseActivity) this.f407174e, new c());
        this.f42091f.R1().observe((BaseActivity) this.f407174e, new d());
        this.f42091f.O1().observe((BaseActivity) this.f407174e, new e());
    }

    private void t0() {
        if (this.f42091f.Q1().getValue() != null && this.f42091f.Q1().getValue().size() != 0) {
            S0();
        } else {
            x0();
        }
    }

    private void u0() {
        u4.c.a().q(this.f407174e);
    }

    private void v0(boolean z16) {
        T0();
        this.f42091f.S1(z16);
    }

    private Handler w0() {
        return this.M;
    }

    private void x0() {
        View view = this.D;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y0() {
        u4.c.a().i(this.f407174e);
    }

    private void z0() {
        this.N = new com.qzone.album.ui.widget.c(this, new b());
    }

    @Override // i4.a
    public void J(s8.b bVar) {
        super.J(bVar);
        if ("QzoneAlbum".equals(bVar.a()) && bVar.c() == 16) {
            E0();
        }
    }

    @Override // i4.a
    public boolean M(Activity activity) {
        Intent intent = new Intent();
        intent.putExtra("key_photo_category_modify", this.f42091f.J);
        activity.setResult(-1, intent);
        activity.finish();
        return false;
    }

    @Override // i4.a
    public void N(Activity activity) {
        super.N(activity);
        activity.setContentView(R.layout.bo5);
        if (QZLog.isColorLevel()) {
            QZLog.i(QZLog.TO_DEVICE_TAG, 2, "[PhotoAlbum]PhotoCategoryControllerPhotoCategoryController onShellActivityCreate");
        }
        J0();
        B0();
        A0();
        r0();
        s0();
        K0();
        E0();
        M0();
    }

    @Override // i4.a
    public void O(Activity activity) {
        super.O(activity);
        u0();
    }

    @Override // com.qzone.album.env.common.c
    public boolean P2() {
        return false;
    }

    @Override // i4.a
    public void R(Activity activity, int i3, int i16, final Intent intent) {
        super.R(activity, i3, i16, intent);
        if (i3 == 17) {
            I0(i16, intent);
        } else if (i3 == 1001 && i16 == -1) {
            U(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryController.14
                @Override // java.lang.Runnable
                public void run() {
                    PhotoCategoryController.this.H0(intent);
                }
            });
        }
    }

    public void R0() {
        String str;
        if (this.f42093i == null || !this.f42091f.I) {
            return;
        }
        while (this.K < this.f42093i.getChildCount()) {
            int firstVisiblePosition = (this.f42093i.getFirstVisiblePosition() - 1) + this.K;
            if (firstVisiblePosition >= 0 && this.f42091f.Q1().getValue().size() > firstVisiblePosition) {
                PhotoCategorySummaryInfo photoCategorySummaryInfo = this.f42091f.Q1().getValue().get(firstVisiblePosition);
                if (photoCategorySummaryInfo != null) {
                    Object[] objArr = new Object[16];
                    objArr[0] = "isNotShowBubble:";
                    objArr[1] = Boolean.valueOf(this.f42091f.I);
                    objArr[2] = " viewIndex:";
                    objArr[3] = Integer.valueOf(this.K);
                    objArr[4] = " clickpos:";
                    objArr[5] = Integer.valueOf(firstVisiblePosition);
                    objArr[6] = " faceUin:";
                    objArr[7] = Long.valueOf(photoCategorySummaryInfo.faceUin);
                    objArr[8] = " faceStatus:";
                    objArr[9] = Integer.valueOf(photoCategorySummaryInfo.faceStatus);
                    objArr[10] = " faceNick:";
                    objArr[11] = photoCategorySummaryInfo.nick;
                    objArr[12] = " photoNumber:";
                    objArr[13] = Long.valueOf(photoCategorySummaryInfo.photoNumber);
                    objArr[14] = " groupid:";
                    ArrayList<String> arrayList = photoCategorySummaryInfo.groupid_list;
                    if (arrayList != null && arrayList.size() > 0) {
                        str = photoCategorySummaryInfo.groupid_list.get(0);
                    } else {
                        str = "";
                    }
                    objArr[15] = str;
                    QZLog.d("[PhotoAlbum]PhotoCategoryController", 2, objArr);
                }
                if (photoCategorySummaryInfo != null && photoCategorySummaryInfo.faceUin != 0 && photoCategorySummaryInfo.faceStatus == 3 && this.f42091f.I && this.f42093i.getChildAt(this.K) != null && this.f42093i.getChildAt(this.K).getTag() != null) {
                    this.L = firstVisiblePosition;
                    int[] iArr = new int[2];
                    ((y.g) this.f42093i.getChildAt(this.K).getTag()).f42839a.getLocationOnScreen(iArr);
                    int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.azx);
                    QZLog.d("[PhotoAlbum]PhotoCategoryController", 2, "location[0]:", Integer.valueOf(iArr[0]), " location[1]:", Integer.valueOf(iArr[1]), " titleBarHeight:", Integer.valueOf(dimensionPixelSize));
                    QZLog.d("[PhotoAlbum]PhotoCategoryController", 2, "windows height:", Integer.valueOf(this.f407174e.getWindowManager().getDefaultDisplay().getHeight()), " heightPixels:", Integer.valueOf(getResources().getDisplayMetrics().heightPixels));
                    if (iArr[0] >= 0) {
                        int i3 = iArr[1];
                        if (i3 - dimensionPixelSize >= 0 && i3 + ar.d(120.0f) < getResources().getDisplayMetrics().heightPixels) {
                            this.f42091f.I = false;
                            photoCategorySummaryInfo.needShow = true;
                            U(new Runnable() { // from class: com.qzone.album.business.albumlist.controller.PhotoCategoryController.11
                                @Override // java.lang.Runnable
                                public void run() {
                                    PhotoCategoryController.this.f42092h.notifyDataSetChanged();
                                }
                            });
                            this.K++;
                            LpReportInfo_pf00064.allReport(326, 5, 3);
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
            this.K++;
        }
    }

    @Override // com.qzone.album.env.common.c
    public ListView R3() {
        return this.f42093i;
    }

    @Override // com.qzone.album.env.common.c
    public boolean Ta() {
        return NetworkState.isNetSupport();
    }

    @Override // com.qzone.album.env.common.c
    public Activity getCurrentActivity() {
        return H();
    }

    @Override // com.qzone.album.env.common.c
    public View getRootView() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K0() {
        QZLog.d("[PhotoAlbum]PhotoCategoryController", 1, "refresh...");
        v0(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L0(ArrayList<PhotoCategorySummaryInfo> arrayList) {
        QZLog.d("[PhotoAlbum]PhotoCategoryController", 1, "refreshUI...");
        y yVar = this.f42092h;
        if (yVar != null) {
            yVar.q(arrayList);
        }
        Q0();
    }

    /* loaded from: classes39.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message != null && message.what == -10001) {
                PhotoCategoryController.this.F0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H0(Intent intent) {
        String str;
        String str2;
        PhotoCategorySummaryInfo photoCategorySummaryInfo;
        if (intent != null) {
            str = intent.getStringExtra("extra_choose_friend_uin");
            str2 = intent.getStringExtra("extra_choose_friend_name");
            String stringExtra = intent.getStringExtra("extraChooseFriendRemark");
            if (!TextUtils.isEmpty(stringExtra)) {
                str2 = stringExtra;
            }
        } else {
            str = null;
            str2 = null;
        }
        if (str != null && str.length() > 0) {
            this.F = 1;
        } else {
            this.F = 2;
        }
        y yVar = this.f42092h;
        if (yVar == null || (photoCategorySummaryInfo = (PhotoCategorySummaryInfo) yVar.getItem(this.f42091f.K)) == null) {
            return;
        }
        this.f42091f.N1(this.F, photoCategorySummaryInfo, str, str2);
    }

    private void A0() {
        this.f42093i = (QZonePullToRefreshListView) F(R.id.fo9);
        this.f42092h = new y(H(), this.f42091f.E);
        this.f42093i.j0().setOnItemClickListener(new g());
        this.f42092h.o(new h());
        this.f42092h.n(new i());
        this.f42093i.setOnRefreshListener(new j());
        this.f42093i.setOnScrollListener(new k());
        C0(true);
        if (this.D == null) {
            this.D = G0();
        }
        this.f42093i.addHeaderView(this.D);
        t0();
        this.f42093i.j0().setAdapter((ListAdapter) this.f42092h);
        z0();
    }

    private void I0(int i3, Intent intent) {
        if (i3 == -1 && intent.getBooleanExtra("key_photo_category_modify", false)) {
            this.f42091f.J = true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements c.b {
        b() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void a() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void b() {
        }

        @Override // com.qzone.album.ui.widget.c.b
        public void refresh() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class j implements QZonePullToRefreshListView.c {
        j() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onRefresh() {
            PhotoCategoryController.this.K0();
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void Y() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullEnd() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.c
        public void onPullStart() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class k implements AbsListView.OnScrollListener {
        k() {
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i3) {
            if (i3 != 0) {
                if (i3 != 2) {
                    return;
                }
                QZLog.d("[PhotoAlbum]PhotoCategoryController", 2, "remove showNextBubble");
                com.qzone.album.env.common.a.m().O(PhotoCategoryController.this.J);
                PhotoCategoryController.this.N0();
                return;
            }
            if (PhotoCategoryController.this.D0() && PhotoCategoryController.this.f42091f.I) {
                QZLog.d("[PhotoAlbum]PhotoCategoryController", 2, "SCROLL_STATE_IDLE showNextBubble");
                com.qzone.album.env.common.a.m().I(PhotoCategoryController.this.J, 500L);
            }
            PhotoCategoryController.this.N0();
        }

        @Override // com.tencent.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i3, int i16, int i17) {
        }
    }
}
