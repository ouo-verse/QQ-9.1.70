package com.tencent.mobileqq.flock.feedcommon.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b#\u0010$J\f\u0010\u0004\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\u0011\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/section/FlockFeedCommonTimeSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", "r", "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "t", "d", "Landroid/view/View;", "timeLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivTime", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvTime", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", h.F, "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "sectionIoc", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedCommonTimeSection extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View timeLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivTime;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTime;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sectionIoc;

    public FlockFeedCommonTimeSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedcommon.ioc.b>() { // from class: com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonTimeSection$sectionIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedCommonTimeSection.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final com.tencent.mobileqq.flock.feedcommon.ioc.b invoke() {
                    Object p16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (com.tencent.mobileqq.flock.feedcommon.ioc.b) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    p16 = FlockFeedCommonTimeSection.this.p(com.tencent.mobileqq.flock.feedcommon.ioc.b.class);
                    return (com.tencent.mobileqq.flock.feedcommon.ioc.b) p16;
                }
            });
            this.sectionIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void r(com.tencent.mobileqq.flock.feeddetail.bean.a aVar) {
        Unit unit;
        com.tencent.mobileqq.flock.feedcommon.ioc.b s16 = s();
        if (s16 != null) {
            String C8 = s16.C8(aVar.a());
            View view = null;
            if (C8 != null) {
                u();
                TextView textView = this.tvTime;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvTime");
                    textView = null;
                }
                textView.setText(C8);
                View view2 = this.timeLayout;
                if (view2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLayout");
                    view2 = null;
                }
                view2.setVisibility(0);
                unit = Unit.INSTANCE;
            } else {
                unit = null;
            }
            if (unit == null) {
                View view3 = this.timeLayout;
                if (view3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("timeLayout");
                } else {
                    view = view3;
                }
                view.setVisibility(8);
            }
        }
    }

    private final com.tencent.mobileqq.flock.feedcommon.ioc.b s() {
        return (com.tencent.mobileqq.flock.feedcommon.ioc.b) this.sectionIoc.getValue();
    }

    private final void u() {
        int intValue;
        ImageView imageView = this.ivTime;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivTime");
            imageView = null;
        }
        Drawable drawable = imageView.getDrawable();
        com.tencent.mobileqq.flock.feedcommon.ioc.b s16 = s();
        if (s16 != null) {
            ImageView imageView3 = this.ivTime;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivTime");
            } else {
                imageView2 = imageView3;
            }
            com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
            if (QQTheme.isNowThemeIsNight()) {
                Context context = this.mRootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
                intValue = s16.Z5(context).getSecond().intValue();
            } else {
                Context context2 = this.mRootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "mRootView.context");
                intValue = s16.Z5(context2).getFirst().intValue();
            }
            imageView2.setImageDrawable(a16.e(drawable, intValue));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1193276j};
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
            View findViewById = containerView.findViewById(R.id.yfr);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_time)");
            this.timeLayout = findViewById;
            View findViewById2 = containerView.findViewById(R.id.y9x);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_time)");
            this.ivTime = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.kbp);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_time)");
            this.tvTime = (TextView) findViewById3;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.feeddetail.bean.a data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
        } else if (data != null) {
            r(data);
        }
    }
}
