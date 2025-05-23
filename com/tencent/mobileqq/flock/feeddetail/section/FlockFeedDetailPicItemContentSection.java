package com.tencent.mobileqq.flock.feeddetail.section;

import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.c;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B\u0007\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0014J\u0012\u0010\u000e\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0014J*\u0010\u0014\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/section/FlockFeedDetailPicItemContentSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/b;", "", "t", "data", "Landroid/util/Size;", "size", "v", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "y", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", "d", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", "picContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivPic", "Lcom/tencent/mobileqq/flock/feeddetail/ioc/b;", "f", "Lkotlin/Lazy;", "w", "()Lcom/tencent/mobileqq/flock/feeddetail/ioc/b;", "mediaClickIoc", "", HippyTKDListViewAdapter.X, "()F", "picWidth", "<init>", "()V", h.F, "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedDetailPicItemContentSection extends c<com.tencent.mobileqq.flock.feeddetail.bean.b> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundFrameLayout picContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivPic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy mediaClickIoc;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/section/FlockFeedDetailPicItemContentSection$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feeddetail.section.FlockFeedDetailPicItemContentSection$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(33387);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FlockFeedDetailPicItemContentSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feeddetail.ioc.b>() { // from class: com.tencent.mobileqq.flock.feeddetail.section.FlockFeedDetailPicItemContentSection$mediaClickIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedDetailPicItemContentSection.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.mobileqq.flock.feeddetail.ioc.b invoke() {
                    Object p16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.feeddetail.ioc.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    p16 = FlockFeedDetailPicItemContentSection.this.p(com.tencent.mobileqq.flock.feeddetail.ioc.b.class);
                    return (com.tencent.mobileqq.flock.feeddetail.ioc.b) p16;
                }
            });
            this.mediaClickIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final Size s(com.tencent.mobileqq.flock.feeddetail.bean.b data) {
        float f16;
        float coerceAtMost;
        float x16 = x();
        float f17 = (4.0f * x16) / 3;
        try {
            f16 = (data.d().f449404b / data.d().f449403a) * x16;
        } catch (Exception e16) {
            RFWLog.fatal("FlockFeedDetailPicItemContentSection", RFWLog.USR, e16);
            f16 = f17;
        }
        RoundFrameLayout roundFrameLayout = this.picContainer;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picContainer");
            roundFrameLayout = null;
        }
        ViewGroup.LayoutParams layoutParams = roundFrameLayout.getLayoutParams();
        if (layoutParams != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.width = (int) x16;
            coerceAtMost = RangesKt___RangesKt.coerceAtMost(f16, f17);
            layoutParams2.height = (int) coerceAtMost;
            roundFrameLayout.setLayoutParams(layoutParams2);
            roundFrameLayout.setRadius(DisplayUtil.dip2px(this.mRootView.getContext(), 8.0f));
            return new Size(roundFrameLayout.getLayoutParams().width, roundFrameLayout.getLayoutParams().height);
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
    }

    private final void t() {
        RoundFrameLayout roundFrameLayout = this.picContainer;
        if (roundFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picContainer");
            roundFrameLayout = null;
        }
        roundFrameLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feeddetail.section.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlockFeedDetailPicItemContentSection.u(FlockFeedDetailPicItemContentSection.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(FlockFeedDetailPicItemContentSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.mobileqq.flock.feeddetail.ioc.b w3 = this$0.w();
        if (w3 != null) {
            ImageView imageView = this$0.ivPic;
            if (imageView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivPic");
                imageView = null;
            }
            w3.w0(imageView, this$0.mPosition);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(com.tencent.mobileqq.flock.feeddetail.bean.b data, Size size) {
        com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
        Option requestHeight = Option.obtain().setUrl(data.d().f449405c).setRequestWidth(size.getWidth()).setRequestHeight(size.getHeight());
        ImageView imageView = this.ivPic;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPic");
            imageView = null;
        }
        a16.c(requestHeight.setTargetView(imageView).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    private final com.tencent.mobileqq.flock.feeddetail.ioc.b w() {
        return (com.tencent.mobileqq.flock.feeddetail.ioc.b) this.mediaClickIoc.getValue();
    }

    private final float x() {
        return ImmersiveUtils.getScreenWidth() - (2 * this.mRootView.getContext().getResources().getDimension(R.dimen.caz));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1191075y};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.f247409y);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pic_container)");
            this.picContainer = (RoundFrameLayout) findViewById;
            View findViewById2 = containerView.findViewById(R.id.dwp);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_pic)");
            this.ivPic = (ImageView) findViewById2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.feeddetail.bean.b data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
        } else if (data != null) {
            v(data, s(data));
            t();
        }
    }
}
