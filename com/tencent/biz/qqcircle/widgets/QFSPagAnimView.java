package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.biz.qqcircle.manager.diffres.QCircleActionType;
import com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage;
import com.tencent.biz.qqcircle.widgets.QFSPagAnimView;
import com.tencent.biz.richframework.download.RFWDownloaderFactory;
import com.tencent.biz.richframework.download.RFWMultiDownloadHelper;
import com.tencent.biz.richframework.util.RFWFileUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.engineer.test.api.RFWTestMock;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import fa0.d;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.libpag.PAGImage;
import org.libpag.PAGImageView;
import org.libpag.PAGView;

/* loaded from: classes5.dex */
public class QFSPagAnimView extends FrameLayout implements d.a {
    private long C;
    private volatile int D;
    private volatile PAGImage E;
    private d F;
    private fa0.d G;
    private final List<Object> H;
    private c I;
    private Runnable J;
    private int K;
    private Function0<Unit> L;

    /* renamed from: d, reason: collision with root package name */
    private final a80.a f93343d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f93344e;

    /* renamed from: f, reason: collision with root package name */
    private final List<Object> f93345f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f93346h;

    /* renamed from: i, reason: collision with root package name */
    private Object f93347i;

    /* renamed from: m, reason: collision with root package name */
    private int f93348m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.biz.qqcircle.widgets.QFSPagAnimView$3, reason: invalid class name */
    /* loaded from: classes5.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f93349d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ long f93350e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f93351f;

        AnonymousClass3(Object obj, long j3, int i3) {
            this.f93349d = obj;
            this.f93350e = j3;
            this.f93351f = i3;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            QFSPagAnimView.this.K("pag anim file is not init inner error");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            QFSPagAnimView.this.K("pag anim file is not init");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g() {
            if (QFSPagAnimView.this.f93344e != null) {
                QFSPagAnimView.this.f93344e.setVisibility(8);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Object r16 = QFSPagAnimView.this.r(this.f93349d);
            if (QFSPagAnimView.this.f93345f.indexOf(r16) == -1) {
                QLog.d(QFSPagAnimView.this.u(), 1, "play but url not exist " + this.f93349d + " re init " + this);
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f93349d);
                QFSPagAnimView.this.T(arrayList, false);
            }
            int indexOf = QFSPagAnimView.this.f93345f.indexOf(r16);
            if (indexOf != -1) {
                QFSPagAnimView.this.f93346h = true;
                QFSPagAnimView.this.f93347i = this.f93349d;
                QFSPagAnimView.this.C = this.f93350e;
                QFSPagAnimView.this.f93348m = this.f93351f;
                List<Object> g16 = QFSPagAnimView.this.f93343d.g();
                if (g16 != null && !g16.isEmpty()) {
                    QFSPagAnimView.this.J = new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.bb
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSPagAnimView.AnonymousClass3.this.g();
                        }
                    };
                    QFSPagAnimView.this.f93343d.e(indexOf, this.f93351f, this.f93350e);
                    return;
                } else {
                    RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ba
                        @Override // java.lang.Runnable
                        public final void run() {
                            QFSPagAnimView.AnonymousClass3.this.f();
                        }
                    });
                    QFSPagAnimView.this.W();
                    return;
                }
            }
            QLog.e(QFSPagAnimView.this.u(), 1, "pag anim file is not init inner error");
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.az
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPagAnimView.AnonymousClass3.this.e();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class a implements a80.f {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void c(String str) {
            QFSPagAnimView.this.K(str);
        }

        @Override // a80.f
        public void b() {
            RFWThreadManager rFWThreadManager = RFWThreadManager.getInstance();
            final QFSPagAnimView qFSPagAnimView = QFSPagAnimView.this;
            rFWThreadManager.runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ax
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPagAnimView.this.E();
                }
            });
        }

        @Override // a80.f
        public void e(final String str) {
            RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ay
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPagAnimView.a.this.c(str);
                }
            });
        }

        @Override // a80.f
        public /* synthetic */ void g() {
            a80.e.a(this);
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationCancel(PAGImageView pAGImageView) {
            RFWThreadManager.getInstance().runOnUiThread(new au(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationEnd(PAGImageView pAGImageView) {
            RFWThreadManager.getInstance().runOnUiThread(new as(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationRepeat(PAGImageView pAGImageView) {
            RFWThreadManager.getInstance().runOnUiThread(new aw(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationStart(PAGImageView pAGImageView) {
            RFWThreadManager.getInstance().runOnUiThread(new av(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGImageView.PAGImageViewListener
        public void onAnimationUpdate(PAGImageView pAGImageView) {
            RFWThreadManager.getInstance().runOnUiThread(new at(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationCancel(PAGView pAGView) {
            RFWThreadManager.getInstance().runOnUiThread(new au(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationEnd(PAGView pAGView) {
            RFWThreadManager.getInstance().runOnUiThread(new as(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationRepeat(PAGView pAGView) {
            RFWThreadManager.getInstance().runOnUiThread(new aw(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationStart(PAGView pAGView) {
            RFWThreadManager.getInstance().runOnUiThread(new av(QFSPagAnimView.this));
        }

        @Override // org.libpag.PAGView.PAGViewListener
        public void onAnimationUpdate(PAGView pAGView) {
            RFWThreadManager.getInstance().runOnUiThread(new at(QFSPagAnimView.this));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public class b extends QCircleBaseResPackage {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ List f93353a;

        b(List list) {
            this.f93353a = list;
        }

        @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
        public List<String> getPreloadZipList() {
            return this.f93353a;
        }

        @Override // com.tencent.biz.qqcircle.manager.diffres.beans.QCircleBaseResPackage
        public List<QCircleActionType> getResRefreshActionTypeList() {
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void onAnimationCancel(QFSPagAnimView qFSPagAnimView);

        void onAnimationEnd(QFSPagAnimView qFSPagAnimView);

        void onAnimationRepeat(QFSPagAnimView qFSPagAnimView);

        void onAnimationStart(QFSPagAnimView qFSPagAnimView);

        void onAnimationUpdate(QFSPagAnimView qFSPagAnimView);

        void onPagPlayError(QFSPagAnimView qFSPagAnimView, String str);
    }

    /* loaded from: classes5.dex */
    public interface d {
        void a();
    }

    public QFSPagAnimView(@NonNull Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit A(int i3, PAGImage pAGImage) {
        this.f93343d.c(i3, pAGImage, this.F);
        this.L = null;
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B(int i3) {
        this.f93348m = i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void D() {
        this.f93346h = false;
        this.f93343d.stop();
    }

    private void P() {
        this.f93346h = false;
        this.f93347i = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RFWTestMock(id = "QFS_RES_DOWNLOAD_MOCK")
    public void T(@NonNull List<Object> list, boolean z16) {
        String str;
        List<Object> s16 = s(list);
        if (x(s16, this.H)) {
            return;
        }
        this.H.clear();
        this.H.addAll(s16);
        QLog.d(u(), 4, "setResUrlList " + this);
        P();
        final ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i3 = 0; i3 < s16.size(); i3++) {
            Object obj = s16.get(i3);
            if (obj instanceof String) {
                String str2 = (String) obj;
                if (!RFWFileUtils.isLocalPath(str2)) {
                    arrayList.add(str2);
                    str = RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(str2);
                } else {
                    str = str2;
                }
                if (y(str2)) {
                    arrayList2.add(str);
                }
            } else {
                arrayList2.add(obj);
            }
        }
        this.f93345f.clear();
        this.f93345f.addAll(arrayList2);
        if (z16) {
            com.tencent.biz.qqcircle.immersive.views.u.f91319o.post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.aq
                @Override // java.lang.Runnable
                public final void run() {
                    QFSPagAnimView.this.C(arrayList);
                }
            });
        } else {
            C(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void W() {
        fa0.d dVar = this.G;
        if (dVar != null) {
            dVar.v();
        }
    }

    private synchronized void X() {
        if (this.f93344e != null) {
            return;
        }
        this.f93344e = new ImageView(getContext());
        if (w()) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -1);
            layoutParams.gravity = 17;
            int i3 = this.K;
            layoutParams.setMargins(i3, i3, i3, i3);
            addView(this.f93344e, layoutParams);
            this.f93344e.setAdjustViewBounds(true);
        } else {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-1, -1);
            layoutParams2.gravity = 17;
            int i16 = this.K;
            layoutParams2.setMargins(i16, i16, i16, i16);
            this.f93344e.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(this.f93344e, layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void C(List<String> list) {
        fa0.d dVar = this.G;
        if (dVar != null) {
            dVar.x(null);
            this.G = null;
        }
        if (list.isEmpty()) {
            this.f93343d.i(this, this.f93345f);
            return;
        }
        fa0.d dVar2 = new fa0.d(new b(list));
        this.G = dVar2;
        if (!dVar2.r()) {
            QLog.d(u(), 1, "resDownload unsucceed " + this);
            dVar2.x(this);
            dVar2.v();
            return;
        }
        this.f93343d.i(this, this.f93345f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object r(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (RFWFileUtils.isLocalPath(str)) {
                return obj;
            }
            return RFWDownloaderFactory.getDownloader(vq3.a.a()).getDefaultSavePath(str);
        }
        return obj;
    }

    private List<Object> s(List<Object> list) {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            if (obj != null && (!(obj instanceof String) || !TextUtils.isEmpty((String) obj))) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private String t(String str) {
        try {
            return new URL(str).getPath();
        } catch (MalformedURLException e16) {
            QLog.e("QFSPagAnimView", 1, "getFilePathFromUrl error:" + e16);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String u() {
        return "QFSPagAnimView";
    }

    private boolean y(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (RFWFileUtils.isLocalPath(str)) {
            return str.endsWith(".pag");
        }
        if (str.endsWith(".pag")) {
            return true;
        }
        String t16 = t(str);
        if (TextUtils.isEmpty(t16) || !t16.endsWith(".pag")) {
            return false;
        }
        return true;
    }

    @Override // fa0.d.a
    public void A2() {
        QLog.d(u(), 1, "onPreloadSucceed " + this);
        a80.a aVar = this.f93343d;
        if (aVar != null) {
            aVar.i(this, this.f93345f);
        }
        if (this.f93346h) {
            N(this.f93347i, this.f93348m, this.C);
        } else {
            V();
        }
    }

    public void E() {
        if (this.D >= 0 && this.E != null) {
            O(this.D, this.E);
            this.D = -1;
            this.E = null;
        }
    }

    public void F() {
        c cVar = this.I;
        if (cVar != null) {
            cVar.onAnimationCancel(this);
        }
    }

    public void G() {
        c cVar = this.I;
        if (cVar != null) {
            cVar.onAnimationEnd(this);
        }
    }

    public void H() {
        c cVar = this.I;
        if (cVar != null) {
            cVar.onAnimationRepeat(this);
        }
    }

    public void I() {
        c cVar = this.I;
        if (cVar != null) {
            cVar.onAnimationStart(this);
        }
        Runnable runnable = this.J;
        this.J = null;
        this.f93343d.l(true);
        if (runnable != null) {
            runnable.run();
        }
    }

    public void J() {
        c cVar = this.I;
        if (cVar != null) {
            cVar.onAnimationUpdate(this);
        }
    }

    public void K(String str) {
        QLog.e("QFSPagAnimView", 1, "onPagPlayError error:" + str);
        c cVar = this.I;
        if (cVar != null) {
            cVar.onPagPlayError(this, str);
        }
    }

    public void L() {
        if (this.H.isEmpty()) {
            QLog.e(u(), 1, "[play] mOriginConfigUrls is null" + this);
            return;
        }
        N(this.H.get(0), this.f93348m, this.C);
    }

    public void M(Object obj) {
        N(obj, this.f93348m, this.C);
    }

    public void N(Object obj, int i3, long j3) {
        com.tencent.biz.qqcircle.immersive.views.u.f91319o.post(new AnonymousClass3(obj, j3, i3));
    }

    public void O(final int i3, final PAGImage pAGImage) {
        if (this.f93343d.h() != null && this.f93343d.h().size() > i3) {
            if (this.f93343d.h().get(i3) == null) {
                QLog.e("QFSPagAnimView", 1, "replaceImage error: pagFile is null:" + i3);
                this.D = i3;
                this.E = pAGImage;
                return;
            }
            try {
                Function0<Unit> function0 = new Function0() { // from class: com.tencent.biz.qqcircle.widgets.ar
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        Unit A;
                        A = QFSPagAnimView.this.A(i3, pAGImage);
                        return A;
                    }
                };
                this.L = function0;
                com.tencent.biz.qqcircle.immersive.views.x.g(new WeakReference(function0));
                return;
            } catch (Throwable th5) {
                QLog.e("QFSPagAnimView", 1, "replaceImage error:", th5);
                return;
            }
        }
        QLog.e("QFSPagAnimView", 1, "replaceImage get pagFile error:" + i3);
        this.D = i3;
        this.E = pAGImage;
    }

    public synchronized boolean Q(Drawable drawable) {
        V();
        X();
        this.J = null;
        this.f93344e.setVisibility(0);
        this.f93344e.setImageDrawable(drawable);
        QLog.d(u(), 4, "[setImageDrawable] " + this);
        return true;
    }

    public boolean R(String str) {
        return S(str, null);
    }

    public synchronized boolean S(String str, QCirclePicStateListener qCirclePicStateListener) {
        Map<String, RFWMultiDownloadHelper.DownloadResult> m3;
        V();
        X();
        this.J = null;
        this.f93344e.setVisibility(0);
        fa0.d dVar = this.G;
        if (dVar != null && dVar.r() && (m3 = dVar.m()) != null && m3.containsKey(str)) {
            dVar.i(str, this.f93344e);
            QLog.d(u(), 4, "[setImageUrl] form local url =  " + str + this);
            return true;
        }
        QCircleFeedPicLoader.g().loadImage(Option.obtain().setRequestWidth(getLayoutParams().width).setRequestHeight(getLayoutParams().height).setUrl(str).setTargetView(this.f93344e).setLoadingDrawableColor(0), qCirclePicStateListener);
        return true;
    }

    public boolean U(Object obj) {
        if (obj instanceof String) {
            String str = (String) obj;
            if (y(str)) {
                M(obj);
                return true;
            }
            R(str);
            return true;
        }
        if (obj instanceof Drawable) {
            Q((Drawable) obj);
            return true;
        }
        M(obj);
        return true;
    }

    public void V() {
        com.tencent.biz.qqcircle.immersive.views.u.f91319o.post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ap
            @Override // java.lang.Runnable
            public final void run() {
                QFSPagAnimView.this.D();
            }
        });
    }

    @Override // fa0.d.a
    public void h4() {
        QLog.d(u(), 1, "onPreloadError " + this);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f93343d.j()) {
            QLog.d(u(), 4, "onDetachedFromWindow stop play " + this);
            V();
        }
    }

    public void setAdjustViewBounds(boolean z16) {
        this.f93343d.b(z16);
    }

    public void setEditResMode(boolean z16) {
        this.f93343d.d(z16);
    }

    public synchronized void setImageViewColorFilter(Integer num) {
        X();
        ImageView imageView = this.f93344e;
        if (imageView != null) {
            if (num == null) {
                imageView.clearColorFilter();
            } else {
                imageView.setColorFilter(num.intValue());
            }
        }
    }

    public void setImageViewMargin(int i3) {
        this.K = i3;
    }

    public void setImageViewScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.f93344e;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    public void setPagAnimListener(c cVar) {
        this.I = cVar;
    }

    public void setPagImageReplaceListener(d dVar) {
        this.F = dVar;
    }

    public void setPagViewScaleMode(int i3) {
        a80.a aVar = this.f93343d;
        if (aVar == null) {
            return;
        }
        aVar.a(i3);
    }

    public void setRepeatTimes(final int i3) {
        com.tencent.biz.qqcircle.immersive.views.u.f91319o.post(new Runnable() { // from class: com.tencent.biz.qqcircle.widgets.ao
            @Override // java.lang.Runnable
            public final void run() {
                QFSPagAnimView.this.B(i3);
            }
        });
    }

    public void setResUrl(Object obj) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(obj);
        setResUrl((List<Object>) arrayList);
    }

    public void setStaticImageMode(boolean z16) {
        this.f93343d.setStaticImageMode(z16);
    }

    @Override // android.view.View
    public String toString() {
        return "QFSPagAnimView";
    }

    public ByteBuffer v(int i3) {
        return this.f93343d.f(i3);
    }

    protected boolean w() {
        return true;
    }

    public boolean x(List list, List list2) {
        if (list == null && list2 == null) {
            return true;
        }
        if (list == null || list2 == null || list.size() != list2.size()) {
            return false;
        }
        for (int i3 = 0; i3 < list.size(); i3++) {
            Object obj = list.get(i3);
            Object obj2 = list2.get(i3);
            if (obj != null && obj2 != null) {
                if (!obj.equals(obj2)) {
                    return false;
                }
            } else if (obj != obj2) {
                return false;
            }
        }
        return true;
    }

    public boolean z() {
        a80.a aVar = this.f93343d;
        if (aVar != null && aVar.j()) {
            return true;
        }
        return false;
    }

    public QFSPagAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public QFSPagAnimView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f93345f = new ArrayList();
        this.C = -1L;
        this.D = -1;
        this.E = null;
        this.F = null;
        this.H = new ArrayList();
        this.J = null;
        this.K = 0;
        com.tencent.biz.qqcircle.immersive.views.u uVar = new com.tencent.biz.qqcircle.immersive.views.u();
        this.f93343d = uVar;
        uVar.k(new a());
    }

    public void setResUrl(@NonNull List<Object> list) {
        T(list, true);
    }
}
