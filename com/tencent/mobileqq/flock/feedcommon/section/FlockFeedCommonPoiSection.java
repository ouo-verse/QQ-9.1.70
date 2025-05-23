package com.tencent.mobileqq.flock.feedcommon.section;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y45.l;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\t\u001a\u00020\bH\u0014J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J*\u0010\u0013\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0014R\u0016\u0010\u0016\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\u0004\u0018\u00010\u001f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/section/FlockFeedCommonPoiSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", "v", "u", "y", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "d", "Landroid/view/View;", "poiLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivPoi", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvPoi", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", h.F, "Lkotlin/Lazy;", "w", "()Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "sectionIoc", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedCommonPoiSection extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View poiLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivPoi;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvPoi;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sectionIoc;

    public FlockFeedCommonPoiSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedcommon.ioc.b>() { // from class: com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonPoiSection$sectionIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedCommonPoiSection.this);
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
                    p16 = FlockFeedCommonPoiSection.this.p(com.tencent.mobileqq.flock.feedcommon.ioc.b.class);
                    return (com.tencent.mobileqq.flock.feedcommon.ioc.b) p16;
                }
            });
            this.sectionIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void s() {
        final com.tencent.mobileqq.flock.feedcommon.ioc.b w3 = w();
        if (w3 != null && w3.c6()) {
            View view = this.poiLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("poiLayout");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feedcommon.section.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FlockFeedCommonPoiSection.t(com.tencent.mobileqq.flock.feedcommon.ioc.b.this, this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(com.tencent.mobileqq.flock.feedcommon.ioc.b this_run, FlockFeedCommonPoiSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        this_run.n2(context, ((com.tencent.mobileqq.flock.feeddetail.bean.a) this$0.mData).a());
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(com.tencent.mobileqq.flock.feeddetail.bean.a aVar) {
        Unit unit;
        boolean z16;
        boolean isBlank;
        l lVar = aVar.a().f449376k;
        View view = null;
        if (lVar != null) {
            String str = lVar.f449420b;
            if (str != null) {
                isBlank = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank) {
                    z16 = false;
                    if (!z16) {
                        View view2 = this.poiLayout;
                        if (view2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("poiLayout");
                            view2 = null;
                        }
                        view2.setVisibility(8);
                    } else {
                        y();
                        View view3 = this.poiLayout;
                        if (view3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("poiLayout");
                            view3 = null;
                        }
                        view3.setVisibility(0);
                        TextView textView = this.tvPoi;
                        if (textView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("tvPoi");
                            textView = null;
                        }
                        textView.setText(lVar.f449420b);
                        s();
                    }
                    unit = Unit.INSTANCE;
                }
            }
            z16 = true;
            if (!z16) {
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            View view4 = this.poiLayout;
            if (view4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("poiLayout");
            } else {
                view = view4;
            }
            view.setVisibility(8);
        }
    }

    private final void v() {
        View view = this.poiLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("poiLayout");
            view = null;
        }
        com.tencent.mobileqq.flock.datong.c.c(view, "em_searching_people_location");
    }

    private final com.tencent.mobileqq.flock.feedcommon.ioc.b w() {
        return (com.tencent.mobileqq.flock.feedcommon.ioc.b) this.sectionIoc.getValue();
    }

    private final void y() {
        int intValue;
        ImageView imageView = this.ivPoi;
        ImageView imageView2 = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivPoi");
            imageView = null;
        }
        Drawable drawable = imageView.getDrawable();
        com.tencent.mobileqq.flock.feedcommon.ioc.b w3 = w();
        if (w3 != null) {
            ImageView imageView3 = this.ivPoi;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivPoi");
            } else {
                imageView2 = imageView3;
            }
            com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
            if (QQTheme.isNowThemeIsNight()) {
                Context context = this.mRootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
                intValue = w3.Z5(context).getSecond().intValue();
            } else {
                Context context2 = this.mRootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "mRootView.context");
                intValue = w3.Z5(context2).getFirst().intValue();
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
        return new int[]{R.id.f1192576c};
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
            View findViewById = containerView.findViewById(R.id.f166021yf2);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_poi)");
            this.poiLayout = findViewById;
            View findViewById2 = containerView.findViewById(R.id.f165955y72);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.iv_poi)");
            this.ivPoi = (ImageView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.mdl);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_poi)");
            this.tvPoi = (TextView) findViewById3;
            v();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.feeddetail.bean.a data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
        } else if (data != null) {
            u(data);
        }
    }
}
