package com.tencent.mobileqq.flock.feedcommon.section;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.widget.SingleAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y45.o;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b$\u0010%J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J*\u0010\u0012\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001d\u0010#\u001a\u0004\u0018\u00010\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/section/FlockFeedCommonPublisherSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", "t", "v", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "d", "Landroid/view/View;", "publisherLayout", "Lcom/tencent/mobileqq/flock/widget/SingleAvatarView;", "e", "Lcom/tencent/mobileqq/flock/widget/SingleAvatarView;", "ivAvatar", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvNick", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", h.F, "Lkotlin/Lazy;", "w", "()Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "sectionIoc", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class FlockFeedCommonPublisherSection extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View publisherLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private SingleAvatarView ivAvatar;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvNick;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sectionIoc;

    public FlockFeedCommonPublisherSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedcommon.ioc.b>() { // from class: com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonPublisherSection$sectionIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedCommonPublisherSection.this);
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
                    p16 = FlockFeedCommonPublisherSection.this.p(com.tencent.mobileqq.flock.feedcommon.ioc.b.class);
                    return (com.tencent.mobileqq.flock.feedcommon.ioc.b) p16;
                }
            });
            this.sectionIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void s(com.tencent.mobileqq.flock.feeddetail.bean.a aVar) {
        o oVar = aVar.a().f449369d;
        if (oVar != null) {
            SingleAvatarView singleAvatarView = this.ivAvatar;
            if (singleAvatarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivAvatar");
                singleAvatarView = null;
            }
            String id5 = oVar.f449449a;
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            singleAvatarView.o(id5);
        }
    }

    private final void t() {
        View view;
        final com.tencent.mobileqq.flock.feedcommon.ioc.b w3 = w();
        if (w3 != null && w3.t3() && (view = this.publisherLayout) != null) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feedcommon.section.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FlockFeedCommonPublisherSection.u(com.tencent.mobileqq.flock.feedcommon.ioc.b.this, this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void u(com.tencent.mobileqq.flock.feedcommon.ioc.b this_run, FlockFeedCommonPublisherSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        this_run.S4(context, ((com.tencent.mobileqq.flock.feeddetail.bean.a) this$0.mData).a());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void v(com.tencent.mobileqq.flock.feeddetail.bean.a aVar) {
        o oVar = aVar.a().f449369d;
        if (oVar != null) {
            TextView textView = this.tvNick;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvNick");
                textView = null;
            }
            textView.setText(oVar.f449450b);
        }
    }

    private final com.tencent.mobileqq.flock.feedcommon.ioc.b w() {
        return (com.tencent.mobileqq.flock.feedcommon.ioc.b) this.sectionIoc.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1192876f};
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
            this.publisherLayout = containerView.findViewById(R.id.yfb);
            View findViewById = containerView.findViewById(R.id.f165909du3);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.iv_avatar)");
            this.ivAvatar = (SingleAvatarView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.mdg);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_nick)");
            this.tvNick = (TextView) findViewById2;
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
            s(data);
            v(data);
            t();
        }
    }
}
