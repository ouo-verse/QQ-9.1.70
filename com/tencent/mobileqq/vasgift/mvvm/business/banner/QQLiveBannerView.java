package com.tencent.mobileqq.vasgift.mvvm.business.banner;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyBaseFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.x;
import com.tencent.mobileqq.vasgift.utils.ThreadManager;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0011\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0001\u001cB\u001b\u0012\b\u0010H\u001a\u0004\u0018\u00010G\u0012\b\u0010J\u001a\u0004\u0018\u00010I\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J$\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\fH\u0002J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00102\u0006\u0010\r\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u0003H\u0014J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\u001c\u0010\u0018\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0017\u001a\u0004\u0018\u00010\tH\u0017J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000fH\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\b\u0010\u001c\u001a\u00020\u0003H\u0016J\b\u0010\u001d\u001a\u00020\u0003H\u0016J\b\u0010\u001e\u001a\u00020\u000fH\u0014J*\u0010#\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u000f2\u0006\u0010!\u001a\u00020\u000f2\b\u0010\"\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010&\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\u0010\u0010(\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u000fH\u0016J\b\u0010)\u001a\u00020\u0003H\u0014J\u0006\u0010*\u001a\u00020\fR\u0018\u0010.\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0018\u00106\u001a\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105R\u0018\u0010:\u001a\u0004\u0018\u0001078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010>\u001a\u0004\u0018\u00010;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010B\u001a\u0004\u0018\u00010?8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u00104R\u0014\u0010F\u001a\u00020\u000f8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bE\u00100\u00a8\u0006N"}, d2 = {"Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveBannerView;", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BaseBannerView;", "Lqh2/f;", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "showAnim", "Landroid/graphics/Bitmap;", MimeHelper.IMAGE_SUBTYPE_BITMAP, "", "pagPath", HippyTKDListViewAdapter.X, "", WidgetCacheConstellationData.NUM, "y", "", "", ReportConstant.COSTREPORT_PREFIX, "l", "to", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/qqgift/mvvm/business/anim/a;", "data", "path", "i", "setNum", "o", "f", "a", tl.h.F, "k", "id", "errorCode", "httpCode", "errorMessage", "onLoadFail", "Lcom/tencent/mobileqq/qqgift/updatasystem/QQGiftPanelResource;", "panelResource", "c", "curLevel", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "t", "Lcom/tencent/mobileqq/widget/RoundImageView;", "H", "Lcom/tencent/mobileqq/widget/RoundImageView;", "sendHead", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "giftIcon", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftIconPagView;", "J", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/QQLiveGiftIconPagView;", "giftIconPagView", "Landroid/view/View;", "K", "Landroid/view/View;", "giftInfoArea", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/NoBoomHitNumberView;", "L", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/NoBoomHitNumberView;", "noBoomHitNumberView", "Landroid/widget/LinearLayout;", "M", "Landroid/widget/LinearLayout;", "batchCntContainer", "N", "minDuration", "P", "defaultLevel", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BannerResManager;", "resManager", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/vasgift/mvvm/business/banner/BannerResManager;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "vas-gift-impl_release"}, k = 1, mv = {1, 7, 1})
@SuppressLint({"ViewConstructor"})
/* loaded from: classes20.dex */
public class QQLiveBannerView extends BaseBannerView implements qh2.f {

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private RoundImageView sendHead;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private ImageView giftIcon;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private QQLiveGiftIconPagView giftIconPagView;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private View giftInfoArea;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private NoBoomHitNumberView noBoomHitNumberView;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private LinearLayout batchCntContainer;

    /* renamed from: N, reason: from kotlin metadata */
    private long minDuration;

    /* renamed from: P, reason: from kotlin metadata */
    private final int defaultLevel;

    public QQLiveBannerView(@Nullable Context context, @Nullable BannerResManager bannerResManager) {
        super(context, bannerResManager);
        this.minDuration = 3000L;
        this.defaultLevel = 11;
    }

    private final List<Integer> s(int num) {
        ArrayList arrayList = new ArrayList();
        do {
            arrayList.add(0, Integer.valueOf(num % 10));
            num /= 10;
        } while (num > 0);
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(QQLiveBannerView this$0) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.F) {
            QLog.e("QQLiveBannerView", 1, "delayEndRunnable run but isPlaying");
            return;
        }
        NoBoomHitNumberView noBoomHitNumberView = this$0.noBoomHitNumberView;
        if (noBoomHitNumberView != null) {
            noBoomHitNumberView.m();
        }
        QQLiveGiftIconPagView qQLiveGiftIconPagView = this$0.giftIconPagView;
        if (qQLiveGiftIconPagView != null) {
            qQLiveGiftIconPagView.p();
        }
        ImageView imageView = this$0.giftIcon;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
        b bVar = this$0.C;
        if (bVar != null) {
            com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this$0.f311744m;
            NoBoomHitNumberView noBoomHitNumberView2 = this$0.noBoomHitNumberView;
            if (noBoomHitNumberView2 != null) {
                i3 = noBoomHitNumberView2.getCurrentNum();
            } else {
                i3 = 0;
            }
            bVar.g(aVar, i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(QQLiveBannerView this$0, Bitmap it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "$it");
        this$0.x(false, it, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(QQLiveBannerView this$0, QQGiftPanelResource qQGiftPanelResource) {
        String str;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (qQGiftPanelResource != null) {
            str = qQGiftPanelResource.f265003c;
        } else {
            str = null;
        }
        this$0.x(true, null, str);
    }

    private final void x(boolean showAnim, Bitmap bitmap, String pagPath) {
        if (showAnim) {
            ImageView imageView = this.giftIcon;
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            QQLiveGiftIconPagView qQLiveGiftIconPagView = this.giftIconPagView;
            if (qQLiveGiftIconPagView != null) {
                qQLiveGiftIconPagView.setVisibility(0);
            }
            QQLiveGiftIconPagView qQLiveGiftIconPagView2 = this.giftIconPagView;
            if (qQLiveGiftIconPagView2 != null) {
                if (pagPath == null) {
                    pagPath = "";
                }
                qQLiveGiftIconPagView2.o(pagPath);
                return;
            }
            return;
        }
        ImageView imageView2 = this.giftIcon;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
        QQLiveGiftIconPagView qQLiveGiftIconPagView3 = this.giftIconPagView;
        if (qQLiveGiftIconPagView3 != null) {
            qQLiveGiftIconPagView3.setVisibility(8);
        }
        ImageView imageView3 = this.giftIcon;
        if (imageView3 != null) {
            imageView3.setImageBitmap(bitmap);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0084  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void y(long num) {
        int size;
        int i3;
        Bitmap bitmap;
        if (num == 0) {
            LinearLayout linearLayout = this.batchCntContainer;
            if (linearLayout != null) {
                int childCount = linearLayout.getChildCount();
                for (int i16 = 0; i16 < childCount; i16++) {
                    View childAt = linearLayout.getChildAt(i16);
                    if (childAt != null) {
                        childAt.setVisibility(8);
                    }
                }
                return;
            }
            return;
        }
        List<Integer> s16 = s((int) num);
        LinearLayout linearLayout2 = this.batchCntContainer;
        if (linearLayout2 != null) {
            if (linearLayout2.getChildCount() >= s16.size()) {
                if (linearLayout2.getChildCount() > s16.size()) {
                    int childCount2 = linearLayout2.getChildCount();
                    for (int size2 = s16.size(); size2 < childCount2; size2++) {
                        View childAt2 = linearLayout2.getChildAt(size2);
                        if (childAt2 != null) {
                            childAt2.setVisibility(8);
                        }
                    }
                }
                size = s16.size();
                for (i3 = 0; i3 < size; i3++) {
                    ImageView imageView = (ImageView) linearLayout2.getChildAt(i3);
                    if (imageView != null) {
                        BannerResManager bannerResManager = this.D;
                        if (bannerResManager != null) {
                            bitmap = bannerResManager.z(this.defaultLevel, s16.get(i3).intValue());
                        } else {
                            bitmap = null;
                        }
                        imageView.setImageBitmap(bitmap);
                    }
                    if (imageView != null) {
                        imageView.setVisibility(0);
                    }
                }
            }
            do {
                linearLayout2.addView(new ImageView(getContext()), new LinearLayout.LayoutParams(x.a(10.0f), x.a(14.0f)));
            } while (linearLayout2.getChildCount() < s16.size());
            size = s16.size();
            while (i3 < size) {
            }
        }
    }

    private final void z() {
        boolean z16;
        boolean z17;
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f311744m;
        if (aVar != null) {
            long j3 = aVar.f264912c;
            int i3 = aVar.f264915f;
            long j16 = i3 * j3;
            boolean z18 = true;
            QLog.i("QQLiveBannerView", 1, "update while giftNum:" + i3 + ", giftPrice:" + j3);
            if (0 <= j16 && j16 < 80) {
                z16 = true;
            } else {
                z16 = false;
            }
            Unit unit = null;
            if (z16) {
                View view = this.giftInfoArea;
                if (view != null) {
                    view.setBackgroundResource(R.drawable.f161933l11);
                    unit = Unit.INSTANCE;
                }
            } else {
                if (80 <= j16 && j16 < 400) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (z17) {
                    View view2 = this.giftInfoArea;
                    if (view2 != null) {
                        view2.setBackgroundResource(R.drawable.f161934l12);
                        unit = Unit.INSTANCE;
                    }
                } else {
                    if (400 > j16 || j16 >= 1000) {
                        z18 = false;
                    }
                    if (z18) {
                        View view3 = this.giftInfoArea;
                        if (view3 != null) {
                            view3.setBackgroundResource(R.drawable.f161935l13);
                            unit = Unit.INSTANCE;
                        }
                    } else {
                        View view4 = this.giftInfoArea;
                        if (view4 != null) {
                            view4.setBackgroundResource(R.drawable.f161936l14);
                            unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            if (unit != null) {
                return;
            }
        }
        View view5 = this.giftInfoArea;
        if (view5 != null) {
            view5.setBackgroundResource(R.drawable.f161933l11);
            Unit unit2 = Unit.INSTANCE;
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void a() {
        this.E = System.currentTimeMillis();
    }

    @Override // qh2.f
    public void c(int id5, @Nullable final QQGiftPanelResource panelResource) {
        String str;
        String str2;
        String str3;
        String str4;
        final Bitmap decodeFile;
        if (panelResource != null) {
            str = panelResource.f265002b;
        } else {
            str = null;
        }
        QLog.i("QQLiveBannerView", 1, "onLoadSuccess id:" + id5 + ",panelResource:" + str);
        com.tencent.mobileqq.qqgift.mvvm.business.anim.a aVar = this.f311744m;
        if (aVar != null && aVar.f264914e == id5) {
            if (panelResource != null) {
                try {
                    str2 = panelResource.f265003c;
                } catch (Exception e16) {
                    QLog.e("QQLiveBannerView", 1, "catchException: onLoadSuccess:throw Exception! " + e16.getMessage());
                    return;
                }
            } else {
                str2 = null;
            }
            if (!FileUtils.fileExists(str2)) {
                if (panelResource != null && (str4 = panelResource.f265002b) != null && (decodeFile = BitmapFactory.decodeFile(str4)) != null) {
                    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                        x(false, decodeFile, "");
                        return;
                    } else {
                        ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.i
                            @Override // java.lang.Runnable
                            public final void run() {
                                QQLiveBannerView.v(QQLiveBannerView.this, decodeFile);
                            }
                        });
                        return;
                    }
                }
                return;
            }
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
                if (panelResource != null) {
                    str3 = panelResource.f265003c;
                } else {
                    str3 = null;
                }
                x(true, null, str3);
                return;
            }
            ThreadManager.a(new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.j
                @Override // java.lang.Runnable
                public final void run() {
                    QQLiveBannerView.w(QQLiveBannerView.this, panelResource);
                }
            });
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView, com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void f() {
        super.f();
        QLog.i("QQLiveBannerView", 1, "onHitStart");
        b bVar = this.C;
        if (bVar != null) {
            bVar.h(this.f311744m);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void h() {
        QLog.i("QQLiveBannerView", 1, "onHitEnd");
        m();
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    @SuppressLint({"SetTextI18n"})
    public void i(@Nullable com.tencent.mobileqq.qqgift.mvvm.business.anim.a data, @Nullable String path) {
        boolean z16;
        long j3;
        if (data != null) {
            this.f311744m = data;
            if (!TextUtils.isEmpty(data.f264922m)) {
                URLDrawable a16 = com.tencent.mobileqq.vasgift.utils.d.a(data.f264922m, null, null);
                RoundImageView roundImageView = this.sendHead;
                if (roundImageView != null) {
                    roundImageView.setImageDrawable(a16);
                }
            }
            z();
            this.f311740e.setText(data.f264919j);
            this.f311742h.setText("\u9001" + j(data.f264913d, 3));
            BannerResManager bannerResManager = this.D;
            if (bannerResManager != null) {
                bannerResManager.m(data.f264914e, this);
            }
            long j16 = data.f264915f * data.f264912c;
            boolean z17 = true;
            if (0 <= j16 && j16 < 99) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                j3 = 2500;
            } else {
                if (99 > j16 || j16 >= 999) {
                    z17 = false;
                }
                if (z17) {
                    j3 = 7000;
                } else {
                    j3 = MiniGamePAHippyBaseFragment.LOAD_HIPPY_TIME_OUT;
                }
            }
            this.minDuration = j3;
            y(data.f264917h);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    protected int k() {
        return R.layout.h8t;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void l() {
        RoundImageView roundImageView = (RoundImageView) findViewById(R.id.x85);
        this.sendHead = roundImageView;
        if (roundImageView != null) {
            roundImageView.setmRadius(ImmersiveUtils.dpToPx(19.0f), false);
        }
        this.f311740e = (TextView) findViewById(R.id.zr_);
        this.f311742h = (TextView) findViewById(R.id.vph);
        this.giftIcon = (ImageView) findViewById(R.id.cv8);
        this.giftIconPagView = (QQLiveGiftIconPagView) findViewById(R.id.vpd);
        this.giftInfoArea = findViewById(R.id.vpe);
        NoBoomHitNumberView noBoomHitNumberView = (NoBoomHitNumberView) findViewById(R.id.fca);
        this.noBoomHitNumberView = noBoomHitNumberView;
        if (noBoomHitNumberView != null) {
            noBoomHitNumberView.setResManager(this.D);
        }
        NoBoomHitNumberView noBoomHitNumberView2 = this.noBoomHitNumberView;
        if (noBoomHitNumberView2 != null) {
            noBoomHitNumberView2.setListener(this);
        }
        this.batchCntContainer = (LinearLayout) findViewById(R.id.t5d);
        this.G = new Runnable() { // from class: com.tencent.mobileqq.vasgift.mvvm.business.banner.h
            @Override // java.lang.Runnable
            public final void run() {
                QQLiveBannerView.u(QQLiveBannerView.this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void m() {
        this.F = false;
        long max = Math.max(this.minDuration - (System.currentTimeMillis() - this.E), 600L);
        QLog.i("QQLiveBannerView", 1, "onEnd need delay:" + max);
        ThreadManager.b(this.G, max);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void n(int to5) {
        if (!this.F) {
            this.F = true;
            ThreadManager.d(this.G);
            this.E = System.currentTimeMillis();
        }
        NoBoomHitNumberView noBoomHitNumberView = this.noBoomHitNumberView;
        if (noBoomHitNumberView != null) {
            noBoomHitNumberView.o(to5);
        }
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void o() {
        ThreadManager.d(this.G);
        this.F = false;
        NoBoomHitNumberView noBoomHitNumberView = this.noBoomHitNumberView;
        if (noBoomHitNumberView != null) {
            noBoomHitNumberView.n();
        }
        QQLiveGiftIconPagView qQLiveGiftIconPagView = this.giftIconPagView;
        if (qQLiveGiftIconPagView != null) {
            qQLiveGiftIconPagView.p();
        }
        ImageView imageView = this.giftIcon;
        if (imageView != null) {
            imageView.setImageBitmap(null);
        }
    }

    @Override // qh2.g
    public void onLoadFail(int id5, int errorCode, int httpCode, @Nullable String errorMessage) {
        QLog.e("QQLiveBannerView", 1, "onLoadFail id:" + id5 + ",errorCode:" + errorCode + ",httpCode:" + httpCode + ",errorMessage:" + errorMessage);
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView
    public void setNum(int num) {
        NoBoomHitNumberView noBoomHitNumberView = this.noBoomHitNumberView;
        if (noBoomHitNumberView != null) {
            noBoomHitNumberView.setNum(num);
        }
    }

    public final long t() {
        long coerceAtLeast;
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(this.minDuration - (System.currentTimeMillis() - this.E), 600L);
        return coerceAtLeast;
    }

    @Override // com.tencent.mobileqq.vasgift.mvvm.business.banner.BaseBannerView, com.tencent.mobileqq.vasgift.mvvm.business.banner.e
    public void d(int curLevel) {
    }
}
