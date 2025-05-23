package com.tencent.robot.adelie.homepage.mine.part;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.robot.adelie.homepage.utils.CommonExKt;
import com.tencent.robot.qqmc.RobotQQMC;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000Y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u001b\u0018\u0000 '2\u00020\u0001:\u0001\u0006B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006("}, d2 = {"Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView;", "Landroid/widget/RelativeLayout;", "La24/d;", "data", "", "setData", "a", "Lcom/tencent/robot/adelie/homepage/mine/part/g;", "d", "Lcom/tencent/robot/adelie/homepage/mine/part/g;", "bannerConfig", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterInfoView;", "e", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterInfoView;", "infoView", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterBannerView;", "f", "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterBannerView;", "bannerView", "Landroid/widget/ImageView;", tl.h.F, "Landroid/widget/ImageView;", "bkgView", "Landroid/graphics/drawable/Drawable;", "i", "Landroid/graphics/drawable/Drawable;", "imageDefaultDrawable", "com/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView$b", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView$b;", "imageLoadListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BdhLogUtil.LogTag.Tag_Conn, "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class AdelieCreateCenterHeaderView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private CreateCenterBanner bannerConfig;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieCreateCenterInfoView infoView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private AdelieCreateCenterBannerView bannerView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ImageView bkgView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Drawable imageDefaultDrawable;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b imageLoadListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/robot/adelie/homepage/mine/part/AdelieCreateCenterHeaderView$b", "Lcom/tencent/libra/listener/IPicLoadStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b implements IPicLoadStateListener {
        b() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@Nullable LoadState state, @Nullable Option option) {
            QLog.e("AdelieCreateCenterHeaderView", 1, "imageLoadListener: " + state);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterHeaderView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final void a() {
        AdelieCreateCenterBannerView adelieCreateCenterBannerView = this.bannerView;
        if (adelieCreateCenterBannerView != null) {
            adelieCreateCenterBannerView.i();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x001c, code lost:
    
        if (r0.isEmpty() == true) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void setData(@Nullable a24.d data) {
        boolean z16;
        List<CreateCenterBannerItem> a16;
        AdelieCreateCenterBannerView adelieCreateCenterBannerView;
        AdelieCreateCenterInfoView adelieCreateCenterInfoView;
        if (this.bannerConfig == null) {
            this.bannerConfig = RobotQQMC.INSTANCE.getCreateCenterBanner();
        }
        CreateCenterBanner createCenterBanner = this.bannerConfig;
        if (createCenterBanner != null && (r0 = createCenterBanner.a()) != null) {
            z16 = true;
        }
        z16 = false;
        if (z16) {
            AdelieCreateCenterBannerView adelieCreateCenterBannerView2 = this.bannerView;
            if (adelieCreateCenterBannerView2 != null) {
                adelieCreateCenterBannerView2.setVisibility(8);
            }
            this.imageDefaultDrawable = getContext().getResources().getDrawable(R.drawable.j4_);
        } else {
            AdelieCreateCenterBannerView adelieCreateCenterBannerView3 = this.bannerView;
            if (adelieCreateCenterBannerView3 != null) {
                adelieCreateCenterBannerView3.setVisibility(0);
            }
            CreateCenterBanner createCenterBanner2 = this.bannerConfig;
            if (createCenterBanner2 != null && (a16 = createCenterBanner2.a()) != null && (adelieCreateCenterBannerView = this.bannerView) != null) {
                adelieCreateCenterBannerView.k(a16);
            }
            this.imageDefaultDrawable = getContext().getResources().getDrawable(R.drawable.j4a);
        }
        String str = null;
        if (je0.a.a(BaseApplication.getContext())) {
            if (z16) {
                CreateCenterBanner createCenterBanner3 = this.bannerConfig;
                if (createCenterBanner3 != null) {
                    str = createCenterBanner3.getCreateCenterBkgRoundUrlNight();
                }
            } else {
                CreateCenterBanner createCenterBanner4 = this.bannerConfig;
                if (createCenterBanner4 != null) {
                    str = createCenterBanner4.getCreateCenterBkgUrlNight();
                }
            }
        } else if (z16) {
            CreateCenterBanner createCenterBanner5 = this.bannerConfig;
            if (createCenterBanner5 != null) {
                str = createCenterBanner5.getCreateCenterBkgRoundUrlDay();
            }
        } else {
            CreateCenterBanner createCenterBanner6 = this.bannerConfig;
            if (createCenterBanner6 != null) {
                str = createCenterBanner6.getCreateCenterBkgUrlDay();
            }
        }
        ImageView imageView = this.bkgView;
        if (imageView != null) {
            Drawable drawable = this.imageDefaultDrawable;
            CommonExKt.g(imageView, str, drawable, drawable, this.imageLoadListener);
        }
        if (data != null && (adelieCreateCenterInfoView = this.infoView) != null) {
            adelieCreateCenterInfoView.setData(data);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ AdelieCreateCenterHeaderView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AdelieCreateCenterHeaderView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.imageLoadListener = new b();
        View.inflate(context, R.layout.ds9, this);
        this.infoView = (AdelieCreateCenterInfoView) findViewById(R.id.dls);
        this.bannerView = (AdelieCreateCenterBannerView) findViewById(R.id.a5n);
        this.bkgView = (ImageView) findViewById(R.id.x8a);
    }
}
