package com.tencent.mobileqq.flock.feedlist.section;

import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.richframework.compat.DisplayUtil;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.RoundFrameLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J*\u0010\u0012\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/section/a;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", "coverUrl", "", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "r", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", "d", "Lcom/tencent/mobileqq/widget/RoundFrameLayout;", "coverContainer", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivCover", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class a extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private RoundFrameLayout coverContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivCover;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void q(String coverUrl) {
        com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
        Option url = Option.obtain().setUrl(coverUrl);
        ImageView imageView = this.ivCover;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView = null;
        }
        Option requestWidth = url.setRequestWidth(imageView.getLayoutParams().width);
        ImageView imageView3 = this.ivCover;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
            imageView3 = null;
        }
        Option requestHeight = requestWidth.setRequestHeight(imageView3.getLayoutParams().height);
        ImageView imageView4 = this.ivCover;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivCover");
        } else {
            imageView2 = imageView4;
        }
        a16.c(requestHeight.setTargetView(imageView2).setLoadingDrawableId(R.drawable.asd).setFailedDrawableId(R.drawable.asd));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1191175z};
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
            View findViewById = containerView.findViewById(R.id.f164919bb0);
            RoundFrameLayout roundFrameLayout = (RoundFrameLayout) findViewById;
            roundFrameLayout.setRadius(DisplayUtil.dip2px(roundFrameLayout.getContext(), 8.0f));
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<RoundFrameL\u2026ntext, 8f))\n            }");
            this.coverContainer = roundFrameLayout;
            View findViewById2 = containerView.findViewById(R.id.duw);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_cover)");
            this.ivCover = (ImageView) findViewById2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.feeddetail.bean.a data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
        } else if (data != null) {
            String str = data.a().f449384s;
            Intrinsics.checkNotNullExpressionValue(str, "feed.coverUrl");
            q(str);
        }
    }
}
