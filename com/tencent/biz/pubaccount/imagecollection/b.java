package com.tencent.biz.pubaccount.imagecollection;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.LruCache;
import android.view.Display;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetailActivity;
import com.tencent.biz.pubaccount.accountdetail.api.impl.PublicAccountDetailImpl;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountServlet;
import com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionPreloadManager;
import com.tencent.biz.pubaccount.imagecollection.api.IPublicAccountImageCollectionUtils;
import com.tencent.biz.pubaccount.imagecollection.api.impl.PublicAccountImageCollectionMainActivityImpl;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.mobileqq.applets.c;
import com.tencent.mobileqq.kandian.base.view.widget.VideoFeedsAlphaMaskView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowRequest;
import com.tencent.mobileqq.mp.mobileqq_mp$FollowResponse;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.widget.ImageProgressCircle;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScaleGestureDetector;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Formatter;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;

/* compiled from: P */
/* loaded from: classes32.dex */
public class b extends BaseAdapter implements View.OnClickListener, ScaleGestureDetector.OnScaleGestureListener {
    private QQAppInterface C;
    private com.tencent.biz.pubaccount.imagecollection.c G;
    private GestureDetector H;
    Button J;
    View K;
    TextView L;
    private int N;
    private View P;
    float R;
    int T;
    int U;
    private boolean V;
    private LruCache<String, URL> Y;

    /* renamed from: a0, reason: collision with root package name */
    private com.tencent.mobileqq.applets.c f79801a0;

    /* renamed from: h, reason: collision with root package name */
    private PublicAccountImageCollectionListView f79809h;

    /* renamed from: i, reason: collision with root package name */
    private Context f79810i;

    /* renamed from: m, reason: collision with root package name */
    private Activity f79811m;

    /* renamed from: d, reason: collision with root package name */
    final int f79804d = 0;

    /* renamed from: e, reason: collision with root package name */
    final int f79806e = 1;

    /* renamed from: f, reason: collision with root package name */
    final int f79808f = 2;
    private IPublicAccountImageCollectionUtils.a D = null;
    private ArrayList<IPublicAccountImageCollectionUtils.d> E = null;
    public ArrayList<IPublicAccountImageCollectionUtils.c> F = null;
    private boolean I = true;
    boolean M = false;
    boolean Q = false;
    int S = 0;
    boolean W = false;
    boolean X = false;
    boolean Z = false;

    /* renamed from: b0, reason: collision with root package name */
    String f79802b0 = "";

    /* renamed from: c0, reason: collision with root package name */
    String f79803c0 = "";

    /* renamed from: d0, reason: collision with root package name */
    String f79805d0 = "";

    /* renamed from: e0, reason: collision with root package name */
    private PublicAccountImageCollectionListView.a f79807e0 = new a();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements PublicAccountImageCollectionListView.a {
        a() {
        }

        @Override // com.tencent.biz.pubaccount.imagecollection.PublicAccountImageCollectionListView.a
        public void a(Object obj) {
            if (obj instanceof g) {
                b bVar = b.this;
                if (!bVar.Q) {
                    ((PublicAccountImageCollectionMainActivityImpl) bVar.f79811m).showUserGuide();
                }
                b.this.Q = true;
            } else {
                ((PublicAccountImageCollectionMainActivityImpl) b.this.f79811m).hideUserGuide();
            }
            if (obj instanceof h) {
                if (b.this.I) {
                    b.this.J(true);
                    return;
                } else {
                    b.this.J(false);
                    return;
                }
            }
            b.this.J(true);
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.biz.pubaccount.imagecollection.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    class ViewOnTouchListenerC0812b implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f79813d;

        ViewOnTouchListenerC0812b(int i3) {
            this.f79813d = i3;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            b.this.P = view;
            b bVar = b.this;
            bVar.S = this.f79813d;
            bVar.H.onTouchEvent(motionEvent);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            b.this.K(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class f implements iy.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f79818a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f79819b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ImageProgressCircle f79820c;

        f(boolean z16, long j3, ImageProgressCircle imageProgressCircle) {
            this.f79818a = z16;
            this.f79819b = j3;
            this.f79820c = imageProgressCircle;
        }

        @Override // iy.a
        public void a(URL url, Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadSuccessed");
            }
            if (!this.f79818a) {
                ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageTime(true, this.f79819b);
            }
            b.this.z(this.f79820c);
        }

        @Override // iy.a
        public void b(URL url, int i3) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadProgressed");
            }
            b.this.L(this.f79820c, i3);
        }

        @Override // iy.a
        public void c(URL url, Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage onLoadFailed");
            }
            if (!this.f79818a) {
                ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageTime(false, this.f79819b);
            }
            b.this.z(this.f79820c);
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class g {

        /* renamed from: a, reason: collision with root package name */
        ZImageView f79822a;

        /* renamed from: b, reason: collision with root package name */
        ImageProgressCircle f79823b;

        /* renamed from: c, reason: collision with root package name */
        TextView f79824c;

        /* renamed from: d, reason: collision with root package name */
        ImageView f79825d;

        /* renamed from: e, reason: collision with root package name */
        TextView f79826e;

        /* renamed from: f, reason: collision with root package name */
        TextView f79827f;

        /* renamed from: g, reason: collision with root package name */
        TextView f79828g;

        /* renamed from: h, reason: collision with root package name */
        TextView f79829h;

        /* renamed from: i, reason: collision with root package name */
        Button f79830i;

        /* renamed from: j, reason: collision with root package name */
        VideoFeedsAlphaMaskView f79831j;

        /* renamed from: k, reason: collision with root package name */
        View f79832k;

        /* renamed from: l, reason: collision with root package name */
        TextView f79833l;

        /* renamed from: m, reason: collision with root package name */
        int f79834m;
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class h {

        /* renamed from: a, reason: collision with root package name */
        View f79835a;

        /* renamed from: b, reason: collision with root package name */
        TextView f79836b;

        /* renamed from: c, reason: collision with root package name */
        ZImageView f79837c;

        /* renamed from: d, reason: collision with root package name */
        ImageProgressCircle f79838d;

        /* renamed from: e, reason: collision with root package name */
        VideoFeedsAlphaMaskView f79839e;

        /* renamed from: f, reason: collision with root package name */
        public int f79840f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class i extends GestureDetector.SimpleOnGestureListener {
        i() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            return super.onDoubleTapEvent(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f16, float f17) {
            return super.onFling(motionEvent, motionEvent2, f16, f17);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            super.onShowPress(motionEvent);
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if ((b.this.P.getTag() instanceof g) && (!(b.this.P.getTag() instanceof g) || b.this.f79809h.h0(b.this.P).booleanValue())) {
                return false;
            }
            b.this.u();
            return false;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            PublicAccountImageCollectionMainActivityImpl.doubleTapFlag = true;
            b.this.P();
            return false;
        }
    }

    public b(Context context, PublicAccountImageCollectionListView publicAccountImageCollectionListView, QQAppInterface qQAppInterface) {
        this.Y = null;
        this.f79810i = context.getApplicationContext();
        this.f79811m = (Activity) context;
        this.f79809h = publicAccountImageCollectionListView;
        this.C = qQAppInterface;
        publicAccountImageCollectionListView.c0(this.f79807e0);
        this.R = this.f79809h.getResources().getDisplayMetrics().density;
        if (w()) {
            this.T = p()[1] - r();
        } else {
            this.T = p()[1];
        }
        this.U = p()[0];
        this.f79809h.setScreenHeight(this.T);
        this.Y = new LruCache<>(15);
        v(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(ImageProgressCircle imageProgressCircle, int i3) {
        if (imageProgressCircle.getVisibility() != 0) {
            imageProgressCircle.setVisibility(0);
        }
        imageProgressCircle.setProgress(i3 / 100);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        Button button = this.J;
        if (button == null || !this.M) {
            return;
        }
        button.setText(this.f79810i.getResources().getString(R.string.d7i));
        this.J.setBackgroundDrawable(this.f79810i.getResources().getDrawable(R.drawable.d6z));
    }

    private void N() {
        Button button = this.J;
        if (button != null) {
            if (this.M) {
                button.setVisibility(8);
            } else {
                if (TextUtils.isEmpty(this.D.f79735c) || this.D.f79735c.equals("0")) {
                    return;
                }
                this.J.setVisibility(0);
                this.J.setBackgroundDrawable(this.f79810i.getResources().getDrawable(R.drawable.common_btn_blue));
                this.J.setText(this.f79810i.getResources().getString(R.string.d7j));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P() {
        View view = this.P;
        if (view != null && (view.getTag() instanceof h) && this.f79809h.h0(this.P).booleanValue()) {
            Intent intent = new Intent(this.f79810i, (Class<?>) PublicAccountImageCollectionActivity.class);
            float[] fArr = new float[9];
            ((ZImageView) ((ViewGroup) this.P).getChildAt(0)).getImageMatrix().getValues(fArr);
            ArrayList<IPublicAccountImageCollectionUtils.c> arrayList = this.F;
            if (arrayList == null) {
                return;
            }
            IPublicAccountImageCollectionUtils.c cVar = arrayList.get(this.S - 1);
            String str = cVar.f79746a;
            int i3 = q(cVar)[0];
            int i16 = q(cVar)[1];
            ZImageView zImageView = (ZImageView) ((ViewGroup) this.P).getChildAt(0);
            int width = zImageView.getWidth();
            int height = zImageView.getHeight();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            intent.putExtra("doubleBitMapPath", str);
            intent.putExtra("urlImageHeight", i16);
            intent.putExtra("urlImageWidth", i3);
            intent.putExtra("urlImageWidthReal", width);
            intent.putExtra("urlImageHeightReal", height);
            intent.putExtra("imageMatrix", fArr);
            this.f79811m.startActivity(intent);
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.f79805d0, "0X8007B91", "0X8007B91", 0, 0, this.f79802b0, this.f79803c0, cVar.f79746a, "2", false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(int i3) {
        QQToast.makeText(this.f79810i, i3, 0).show();
    }

    private int r() {
        Resources resources = this.f79811m.getResources();
        return resources.getDimensionPixelSize(resources.getIdentifier("status_bar_height", "dimen", "android"));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u() {
        int lastVisiblePosition = this.f79809h.getLastVisiblePosition() - this.f79809h.getFirstVisiblePosition();
        for (int i3 = 0; i3 <= lastVisiblePosition; i3++) {
            View childAt = this.f79809h.getChildAt(i3);
            if (childAt.getTag() != null && (childAt.getTag() instanceof h)) {
                h hVar = (h) childAt.getTag();
                if (hVar.f79836b.getVisibility() == 0) {
                    this.I = false;
                    hVar.f79836b.setVisibility(8);
                } else {
                    this.I = true;
                    hVar.f79836b.setVisibility(0);
                }
            }
        }
        if (this.I) {
            J(true);
        } else {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.f79805d0, "0X8007B92", "0X8007B92", 0, 0, this.f79802b0, this.f79803c0, "", "", false);
            J(false);
        }
    }

    private boolean w() {
        return false;
    }

    private void y(ZImageView zImageView, com.tencent.mobileqq.kandian.base.image.b bVar, ImageProgressCircle imageProgressCircle, int i3) {
        ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        if (bVar != null && bVar.f239004a != null) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url = " + bVar.f239004a + " reqWidth = " + bVar.f239005b + " reqHeight = " + bVar.f239006c);
            }
            boolean z16 = AbsDownloader.getFile(bVar.f239004a.toString()) != null;
            if (z16) {
                ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageHit(true, i3);
            } else {
                ((IPublicAccountImageCollectionPreloadManager) QRoute.api(IPublicAccountImageCollectionPreloadManager.class)).doStatisticReportForImageHit(false, i3);
            }
            zImageView.setImagePlaceHolder(colorDrawable).setImageForImageCollection(bVar, new f(z16, NetConnInfoCenter.getServerTimeMillis(), imageProgressCircle));
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "loadImage url is empty! use default preload image");
        }
        zImageView.setImageDrawable(colorDrawable);
    }

    public void A(String str) {
        this.f79802b0 = str;
    }

    void B(g gVar) {
        IPublicAccountImageCollectionUtils.a aVar = this.D;
        if (aVar == null) {
            if (this.W) {
                if (QLog.isDevelopLevel()) {
                    QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover getPhotoCollectionInfo error");
                }
                gVar.f79833l.setVisibility(0);
                z(gVar.f79823b);
                ((PublicAccountImageCollectionMainActivityImpl) this.f79811m).hideUserGuide();
                return;
            }
            gVar.f79833l.setVisibility(8);
            return;
        }
        if (aVar.f79740h != null && QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageCover title =" + this.D.f79737e + "; coverUrl =" + this.D.f79740h.f79742a + "; accountName = " + this.D.f79740h.f79743b + "; author=" + this.D.f79740h.f79745d + "; time =" + this.D.f79740h.f79744c);
        }
        gVar.f79832k.setVisibility(0);
        gVar.f79824c.setText(this.D.f79737e);
        String str = "" + this.N;
        int i3 = this.N;
        if (i3 > 1000000) {
            str = "100\u4e07+";
        } else if (i3 > 100000) {
            str = new Formatter().format("%.1f", Double.valueOf(i3 / 100000.0d)).toString() + HardCodeUtil.qqStr(R.string.pnm);
        }
        gVar.f79829h.setText(HardCodeUtil.qqStr(R.string.pm9) + str);
        IPublicAccountImageCollectionUtils.b bVar = this.D.f79740h;
        if (bVar != null) {
            gVar.f79828g.setText(bVar.f79743b);
            gVar.f79826e.setText(bVar.f79745d);
            gVar.f79827f.setText(bVar.f79744c);
            if (!TextUtils.isEmpty(bVar.f79743b)) {
                gVar.f79825d.setVisibility(0);
                gVar.f79825d.setImageDrawable(FaceDrawable.getFaceDrawable(this.C, 1, this.D.f79735c));
            } else {
                gVar.f79825d.setVisibility(8);
            }
            com.tencent.mobileqq.kandian.base.image.b bVar2 = new com.tencent.mobileqq.kandian.base.image.b();
            bVar2.f239004a = s(bVar.f79742a);
            y(gVar.f79822a, bVar2, gVar.f79823b, 0);
        }
        if (TextUtils.isEmpty(this.D.f79735c) || this.D.f79735c.equals("0")) {
            new RelativeLayout.LayoutParams(-1, -1).setMargins(BaseAIOUtils.f(12.0f, this.f79810i.getResources()), BaseAIOUtils.f(25.0f, this.f79810i.getResources()), 0, 0);
            gVar.f79825d.setVisibility(8);
            gVar.f79829h.setTextSize(2, 14.0f);
            gVar.f79828g.setVisibility(8);
            gVar.f79826e.setTextSize(2, 14.0f);
            gVar.f79827f.setTextSize(2, 14.0f);
            this.K.setOnClickListener(null);
        }
        if (!this.Q) {
            ((PublicAccountImageCollectionMainActivityImpl) this.f79811m).showUserGuide();
        }
        this.Q = true;
    }

    void C(h hVar, int i3) {
        IPublicAccountImageCollectionUtils.c cVar;
        int i16;
        int i17;
        ArrayList<IPublicAccountImageCollectionUtils.c> arrayList = this.F;
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "setDataForImageFeeds mPhotoItemInfo is null");
                return;
            }
            return;
        }
        if (i3 < 1 || i3 > arrayList.size() || (cVar = this.F.get(i3 - 1)) == null || (i16 = cVar.f79749d) == 0 || (i17 = this.U) == 0) {
            return;
        }
        int i18 = cVar.f79750e;
        int i19 = i18 / i16;
        int i26 = this.T;
        if (i19 <= i26 / i17) {
            i26 = (i17 * i18) / i16;
        }
        cVar.f79751f = true;
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) hVar.f79837c.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) hVar.f79836b.getLayoutParams();
        ViewGroup.LayoutParams layoutParams3 = hVar.f79835a.getLayoutParams();
        layoutParams.width = this.U;
        layoutParams.height = i26;
        hVar.f79837c.setLayoutParams(layoutParams);
        URL s16 = s(cVar.f79746a);
        if (s16 == null) {
            return;
        }
        com.tencent.mobileqq.kandian.base.image.b bVar = new com.tencent.mobileqq.kandian.base.image.b();
        bVar.f239004a = s16;
        bVar.f239005b = q(cVar)[0];
        bVar.f239006c = q(cVar)[1];
        y(hVar.f79837c, bVar, hVar.f79838d, hVar.f79840f);
        if ((((double) (((float) cVar.f79749d) / ((float) cVar.f79750e))) <= 1.3d || TextUtils.isEmpty(cVar.f79747b) || cVar.f79747b.equals(" ")) ? false : true) {
            hVar.f79836b.setMinHeight(BaseAIOUtils.f(97.0f, this.f79810i.getResources()));
            layoutParams3.height = layoutParams.height + BaseAIOUtils.f(97.0f, this.f79810i.getResources());
            hVar.f79836b.setGravity(16);
        } else {
            layoutParams3.height = layoutParams.height;
            hVar.f79836b.setGravity(80);
        }
        int i27 = this.T;
        float f16 = this.R;
        if (i26 > i27 - ((int) (88.0f * f16))) {
            hVar.f79836b.setPadding((int) (f16 * 15.0f), (int) (10.0f * f16), (int) (15.0f * f16), (int) (f16 * 44.0f));
        } else {
            hVar.f79836b.setPadding((int) (f16 * 15.0f), (int) (f16 * 10.0f), (int) (15.0f * f16), (int) (f16 * 10.0f));
        }
        hVar.f79836b.setLayoutParams(layoutParams2);
        hVar.f79835a.setLayoutParams(layoutParams3);
        hVar.f79836b.setMaxLines(3);
        hVar.f79836b.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
        hVar.f79836b.setText(i3 + "/" + this.F.size() + "  " + cVar.f79747b);
        if (!TextUtils.isEmpty(cVar.f79747b) && !cVar.f79747b.equals(" ")) {
            hVar.f79836b.setBackgroundColor(Color.parseColor("#66000000"));
        } else {
            hVar.f79836b.setBackgroundColor(0);
        }
        if (!this.I) {
            hVar.f79836b.setVisibility(8);
        } else {
            hVar.f79836b.setVisibility(0);
        }
        hVar.f79836b.setOnClickListener(new c());
    }

    public void D(boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetPhotoCollectionInfoError isError = " + z16);
        }
        this.W = z16;
    }

    public void E(boolean z16) {
        if (QLog.isDevelopLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "setGetRecommendInfoError isError = " + z16);
        }
        this.X = z16;
    }

    public void F(boolean z16) {
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "setIsFollowed isFollowed = " + z16);
        }
        this.M = z16;
        N();
    }

    public void H(int i3) {
        this.N = i3;
        if (this.L != null) {
            String str = "" + i3;
            if (i3 > 1000000) {
                str = "100\u4e07+";
            } else if (i3 > 100000) {
                str = new Formatter().format("%.1f", Double.valueOf(i3 / 100000.0d)).toString() + HardCodeUtil.qqStr(R.string.pn5);
            }
            this.L.setText(HardCodeUtil.qqStr(R.string.pmi) + str);
        }
    }

    public void J(boolean z16) {
        View childAt = ((ViewGroup) this.f79809h.getParent()).getChildAt(1);
        View childAt2 = ((ViewGroup) this.f79809h.getParent()).getChildAt(2);
        if (childAt2 == null || childAt == null) {
            return;
        }
        if (z16) {
            childAt2.setVisibility(0);
            childAt.setVisibility(0);
        } else {
            childAt2.setVisibility(8);
            childAt.setVisibility(8);
        }
    }

    void K(View view) {
        if (QLog.isDevelopLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "showMoreDescription");
        }
        TextView textView = (TextView) view;
        if (!this.Z) {
            textView.setMaxLines(Integer.MAX_VALUE);
            textView.setEllipsize(null);
            this.Z = true;
        } else {
            textView.setMaxLines(3);
            textView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
            this.Z = false;
        }
    }

    void O() {
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) this.C.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null) {
            PublicAccountDetailImpl publicAccountDetailImpl = (PublicAccountDetailImpl) iPublicAccountDataManager.findAccountDetailInfo(this.D.f79735c);
            if (publicAccountDetailImpl != null && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(publicAccountDetailImpl.accountFlag) != -4) {
                this.C.removeObserver(this.f79801a0);
                com.tencent.mobileqq.applets.c cVar = new com.tencent.mobileqq.applets.c(new e());
                this.f79801a0 = cVar;
                this.C.addObserver(cVar);
                com.tencent.mobileqq.applets.e.c(this.C, true, this.D.f79735c, 21);
            } else {
                NewIntent newIntent = new NewIntent(this.f79810i, ((IPublicAccountServlet) QRoute.api(IPublicAccountServlet.class)).getServletClass());
                newIntent.putExtra("cmd", "follow");
                mobileqq_mp$FollowRequest mobileqq_mp_followrequest = new mobileqq_mp$FollowRequest();
                mobileqq_mp_followrequest.uin.set((int) Long.parseLong(this.D.f79735c));
                mobileqq_mp_followrequest.ext.set("21");
                newIntent.putExtra("data", mobileqq_mp_followrequest.toByteArray());
                newIntent.setObserver(new d());
                this.C.startServlet(newIntent);
            }
        }
        ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).reportFollowEvent(this.C, this.D.f79735c, 21);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<IPublicAccountImageCollectionUtils.c> arrayList = this.F;
        if (arrayList == null) {
            return 1;
        }
        return arrayList.size() + 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i3) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 3;
    }

    public void n() {
        if (this.f79811m != null) {
            this.f79811m = null;
        }
        LruCache<String, URL> lruCache = this.Y;
        if (lruCache != null) {
            lruCache.evictAll();
        }
        if (this.f79807e0 != null) {
            this.f79807e0 = null;
        }
        if (this.P != null) {
            this.P = null;
        }
        QQAppInterface qQAppInterface = this.C;
        if (qQAppInterface != null) {
            qQAppInterface.removeObserver(this.f79801a0);
        }
    }

    public void o() {
        com.tencent.biz.pubaccount.imagecollection.c cVar = this.G;
        if (cVar != null) {
            cVar.i(this.E);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.J) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.f79805d0, "0X8007B8E", "0X8007B8E", 0, 0, this.f79802b0, this.f79803c0, "", "", false);
            O();
        } else if (view == this.K) {
            ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.f79805d0, "0X8007B8D", "0X8007B8D", 0, 0, this.f79802b0, this.f79803c0, "", "", false);
            t();
        }
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    public URL s(String str) {
        URL url;
        URL url2 = this.Y.get(str);
        if (url2 != null) {
            return url2;
        }
        try {
            url = new URL(str);
        } catch (MalformedURLException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "getURLPath ERROR e = " + e16.getMessage());
            }
            url = null;
        }
        if (url == null) {
            return url2;
        }
        this.Y.put(str, url);
        return url;
    }

    void t() {
        if (this.D != null) {
            ActivityURIRequest activityURIRequest = new ActivityURIRequest(this.f79811m, IPublicAccountDetailActivity.ROUTE_NAME);
            activityURIRequest.extra().putString("uin", this.D.f79735c);
            activityURIRequest.setFlags(67108864);
            QRoute.startUri(activityURIRequest, (o) null);
        }
    }

    void v(Context context) {
        this.H = new GestureDetector(context, new i());
    }

    private int[] p() {
        int[] iArr = new int[2];
        Display defaultDisplay = this.f79811m.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return iArr;
    }

    public void G(IPublicAccountImageCollectionUtils.a aVar) {
        if (aVar == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "setPhotoCollectionInfo articleURl = " + aVar.f79734b + "; puin=" + aVar.f79735c + "; imageUrl=" + aVar.f79736d);
        }
        this.D = aVar;
        this.f79803c0 = aVar.f79734b;
        this.f79805d0 = aVar.f79735c;
        ArrayList<IPublicAccountImageCollectionUtils.c> arrayList = aVar.f79741i;
        this.F = arrayList;
        this.f79809h.setPhotoCollectionInfo(arrayList);
    }

    public void I(ArrayList<IPublicAccountImageCollectionUtils.d> arrayList) {
        if (arrayList == null) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos is null");
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionAdapter", 2, "setRecommendItemInfos size = " + arrayList.size());
        }
        this.E = arrayList;
        this.f79809h.setRecommendInfo(arrayList);
    }

    public int[] q(IPublicAccountImageCollectionUtils.c cVar) {
        int[] iArr = new int[2];
        if (cVar != null) {
            int i3 = cVar.f79749d;
            int i16 = this.U;
            if (i3 > i16) {
                iArr[0] = i16;
                int i17 = cVar.f79750e;
                int i18 = i17 / i3;
                int i19 = this.T;
                if (i18 > i19 / i16) {
                    iArr[1] = i19;
                } else {
                    iArr[1] = (i16 * i17) / i3;
                }
            } else {
                iArr[0] = i3;
                int i26 = cVar.f79750e;
                int i27 = this.T;
                if (i26 > i27) {
                    iArr[1] = i27;
                } else {
                    iArr[1] = i26;
                }
            }
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(ImageProgressCircle imageProgressCircle) {
        if (imageProgressCircle == null || imageProgressCircle.getVisibility() == 4) {
            return;
        }
        imageProgressCircle.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class d implements BusinessObserver {
        d() {
        }

        @Override // mqq.observer.BusinessObserver
        public void onReceive(int i3, boolean z16, Bundle bundle) {
            try {
                if (!z16) {
                    b.this.m(R.string.d6b);
                    return;
                }
                byte[] byteArray = bundle.getByteArray("data");
                if (byteArray != null) {
                    mobileqq_mp$FollowResponse mobileqq_mp_followresponse = new mobileqq_mp$FollowResponse();
                    mobileqq_mp_followresponse.mergeFrom(byteArray);
                    int i16 = mobileqq_mp_followresponse.ret_info.get().ret_code.get();
                    if (i16 == 0) {
                        if (QLog.isColorLevel()) {
                            QLog.d("PublicAccountImageCollectionAdapter", 2, "follow success");
                        }
                        b bVar = b.this;
                        bVar.M = true;
                        bVar.M();
                        return;
                    }
                    if (i16 == 58) {
                        b.this.m(R.string.d69);
                    } else if (i16 == 65) {
                        b.this.m(R.string.d5i);
                    } else {
                        b.this.m(R.string.d6b);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i3) {
        if (i3 == 0) {
            return 0;
        }
        return i3 == getCount() - 1 ? 2 : 1;
    }

    boolean x(int i3, View view) {
        if (view == null) {
            return false;
        }
        if (i3 == 1) {
            return view.getTag() != null && (view.getTag() instanceof h);
        }
        if (i3 == 0) {
            return view.getTag() != null && (view.getTag() instanceof g);
        }
        return true;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        g gVar;
        View view2 = view;
        this.S = 0;
        int itemViewType = getItemViewType(i3);
        h hVar = null;
        if (x(itemViewType, view2)) {
            if (itemViewType != 0) {
                if (itemViewType == 1) {
                    h hVar2 = (h) view.getTag();
                    hVar2.f79840f = i3;
                    view2.setTag(hVar2);
                    hVar = hVar2;
                    gVar = null;
                }
                gVar = null;
            } else {
                gVar = (g) view.getTag();
            }
        } else if (itemViewType != 0) {
            if (itemViewType == 1) {
                view2 = LayoutInflater.from(this.f79810i).inflate(R.layout.f168414vh, viewGroup, false);
                h hVar3 = new h();
                hVar3.f79838d = (ImageProgressCircle) view2.findViewById(R.id.g4c);
                hVar3.f79837c = (ZImageView) view2.findViewById(R.id.f166554g43);
                hVar3.f79836b = (TextView) view2.findViewById(R.id.f165752dc3);
                hVar3.f79839e = (VideoFeedsAlphaMaskView) view2.findViewById(R.id.enp);
                hVar3.f79835a = view2.findViewById(R.id.root_layout);
                hVar3.f79840f = i3;
                view2.setTag(hVar3);
                gVar = null;
                hVar = hVar3;
            }
            gVar = null;
        } else {
            view2 = LayoutInflater.from(this.f79810i).inflate(R.layout.f168413vg, viewGroup, false);
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            layoutParams.height = this.T;
            view2.setLayoutParams(layoutParams);
            g gVar2 = new g();
            gVar2.f79822a = (ZImageView) view2.findViewById(R.id.dd5);
            gVar2.f79823b = (ImageProgressCircle) view2.findViewById(R.id.dd6);
            gVar2.f79824c = (TextView) view2.findViewById(R.id.dd7);
            gVar2.f79825d = (ImageView) view2.findViewById(R.id.ddb);
            gVar2.f79828g = (TextView) view2.findViewById(R.id.ddc);
            gVar2.f79827f = (TextView) view2.findViewById(R.id.dd8);
            gVar2.f79826e = (TextView) view2.findViewById(R.id.f165758dd0);
            gVar2.f79826e = (TextView) view2.findViewById(R.id.f165758dd0);
            gVar2.f79829h = (TextView) view2.findViewById(R.id.dde);
            gVar2.f79830i = (Button) view2.findViewById(R.id.dd_);
            gVar2.f79831j = (VideoFeedsAlphaMaskView) view2.findViewById(R.id.enp);
            gVar2.f79832k = view2.findViewById(R.id.ddd);
            gVar2.f79833l = (TextView) view2.findViewById(R.id.dd9);
            gVar2.f79834m = i3;
            Button button = gVar2.f79830i;
            this.J = button;
            button.setOnClickListener(this);
            View view3 = gVar2.f79832k;
            this.K = view3;
            view3.setOnClickListener(this);
            this.L = gVar2.f79829h;
            view2.setTag(gVar2);
            gVar = gVar2;
        }
        if (itemViewType == 1) {
            C(hVar, i3);
        } else if (itemViewType == 0) {
            B(gVar);
        } else if (itemViewType == 2) {
            if (!this.V) {
                String str = "";
                if (this.E != null) {
                    for (int i16 = 0; this.E.size() > i16 && i16 < 6; i16++) {
                        str = str + this.E.get(i16).f79755d + ContainerUtils.FIELD_DELIMITER;
                    }
                }
                ((IPublicAccountReportUtils) QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, this.f79805d0, "0X8007B93", "0X8007B93", 0, 0, this.f79802b0, this.f79803c0, str, "", false);
            }
            this.V = true;
            if (this.G == null) {
                this.G = new com.tencent.biz.pubaccount.imagecollection.c(this.f79811m, this.E, this.T, this.U, this.X);
            }
            com.tencent.biz.pubaccount.imagecollection.c cVar = this.G;
            if (cVar != null) {
                view2 = cVar.f(this.f79811m, view2, viewGroup);
            }
        }
        view2.setLongClickable(true);
        view2.setOnTouchListener(new ViewOnTouchListenerC0812b(i3));
        return view2;
    }

    @Override // com.tencent.widget.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class e extends c.a {
        e() {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void c(Object obj) {
            b.this.m(R.string.d6b);
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void d(Object obj) {
            if (QLog.isColorLevel()) {
                QLog.d("PublicAccountImageCollectionAdapter", 2, "follow success");
            }
            b bVar = b.this;
            bVar.M = true;
            bVar.M();
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public int e() {
            return 0;
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void a(boolean z16, Object obj) {
        }

        @Override // com.tencent.mobileqq.applets.c.a
        public void b(boolean z16, Object obj) {
        }
    }
}
