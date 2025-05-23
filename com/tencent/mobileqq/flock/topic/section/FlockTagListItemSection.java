package com.tencent.mobileqq.flock.topic.section;

import android.view.View;
import android.widget.TextView;
import b55.g;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.c;
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

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0014J*\u0010\u000f\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\n2\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\fH\u0014R\u0016\u0010\u0012\u001a\u00020\u00058\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/flock/topic/section/FlockTagListItemSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lb55/g;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "data", "", "position", "", "", "payload", "t", "d", "Landroid/view/View;", "parentView", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tagTv", "f", "countTv", "Lpc1/a;", h.F, "Lkotlin/Lazy;", ReportConstant.COSTREPORT_PREFIX, "()Lpc1/a;", "flockTopicSectionIoc", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockTagListItemSection extends c<g> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View parentView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tagTv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView countTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy flockTopicSectionIoc;

    public FlockTagListItemSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<pc1.a>() { // from class: com.tencent.mobileqq.flock.topic.section.FlockTagListItemSection$flockTopicSectionIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockTagListItemSection.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final pc1.a invoke() {
                    Object p16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (pc1.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    p16 = FlockTagListItemSection.this.p(pc1.a.class);
                    return (pc1.a) p16;
                }
            });
            this.flockTopicSectionIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final pc1.a s() {
        return (pc1.a) this.flockTopicSectionIoc.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(FlockTagListItemSection this$0, g gVar, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        pc1.a s16 = this$0.s();
        if (s16 != null) {
            s16.L3(gVar);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1193176i};
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
            View findViewById = containerView.findViewById(R.id.f922657e);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tag_name)");
            this.tagTv = (TextView) findViewById;
            View findViewById2 = containerView.findViewById(R.id.u9z);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.count_of_member)");
            this.countTv = (TextView) findViewById2;
            this.parentView = containerView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable final g data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data != null) {
            TextView textView = this.tagTv;
            View view = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tagTv");
                textView = null;
            }
            textView.setText("#" + data.f27974b);
            TextView textView2 = this.countTv;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("countTv");
                textView2 = null;
            }
            textView2.setText(data.f27976d + "\u4eba\u53c2\u4e0e");
            View view2 = this.parentView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("parentView");
            } else {
                view = view2;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.topic.section.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    FlockTagListItemSection.u(FlockTagListItemSection.this, data, view3);
                }
            });
        }
    }
}
