package com.tencent.mobileqq.flock.feedcommon.section;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Arrays;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y45.k;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\u0011\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/section/FlockFeedCommonParticipantSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", "u", ReportConstant.COSTREPORT_PREFIX, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "w", "d", "Landroid/view/View;", "participantLayout", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "tvParticipant", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "f", "Lkotlin/Lazy;", "v", "()Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "sectionIoc", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedCommonParticipantSection extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View participantLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView tvParticipant;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sectionIoc;

    public FlockFeedCommonParticipantSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedcommon.ioc.b>() { // from class: com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonParticipantSection$sectionIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedCommonParticipantSection.this);
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
                    p16 = FlockFeedCommonParticipantSection.this.p(com.tencent.mobileqq.flock.feedcommon.ioc.b.class);
                    return (com.tencent.mobileqq.flock.feedcommon.ioc.b) p16;
                }
            });
            this.sectionIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void s() {
        final com.tencent.mobileqq.flock.feedcommon.ioc.b v3 = v();
        if (v3 != null && v3.a8()) {
            View view = this.participantLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("participantLayout");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feedcommon.section.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FlockFeedCommonParticipantSection.t(com.tencent.mobileqq.flock.feedcommon.ioc.b.this, this, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(com.tencent.mobileqq.flock.feedcommon.ioc.b this_run, FlockFeedCommonParticipantSection this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.mRootView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
        this_run.Z8(context, ((com.tencent.mobileqq.flock.feeddetail.bean.a) this$0.mData).a());
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u() {
        View view = this.participantLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("participantLayout");
            view = null;
        }
        com.tencent.mobileqq.flock.datong.c.c(view, "em_bas_list_participants");
    }

    private final com.tencent.mobileqq.flock.feedcommon.ioc.b v() {
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
        return new int[]{R.id.f1192476b};
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
            View findViewById = containerView.findViewById(R.id.yez);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.layout_participant)");
            this.participantLayout = findViewById;
            View findViewById2 = containerView.findViewById(R.id.f109846gx);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_participant)");
            this.tvParticipant = (TextView) findViewById2;
            u();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.feeddetail.bean.a data, int position, @Nullable List<Object> payload) {
        String str;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data != null) {
            TextView textView = this.tvParticipant;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvParticipant");
                textView = null;
            }
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            com.tencent.mobileqq.flock.feedcommon.ioc.b v3 = v();
            if (v3 == null || (str = v3.y8()) == null) {
                str = "%s\u4eba\u53c2\u4e0e";
            }
            Object[] objArr = new Object[1];
            k kVar = data.a().f449379n;
            if (kVar != null) {
                i3 = kVar.f449416b;
            } else {
                i3 = 0;
            }
            objArr[0] = String.valueOf(i3);
            String format = String.format(str, Arrays.copyOf(objArr, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            textView.setText(format);
            s();
        }
    }
}
