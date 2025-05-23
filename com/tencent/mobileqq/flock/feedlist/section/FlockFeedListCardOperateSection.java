package com.tencent.mobileqq.flock.feedlist.section;

import android.view.View;
import android.widget.TextView;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.ktx.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0014J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0014J*\u0010\u0014\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/flock/feedlist/section/FlockFeedListCardOperateSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", "isActive", "", "u", ReportConstant.COSTREPORT_PREFIX, "v", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", HippyTKDListViewAdapter.X, "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvOperate", "Lmc1/a;", "e", "Lkotlin/Lazy;", "w", "()Lmc1/a;", "clickIoc", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public class FlockFeedListCardOperateSection extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TextView tvOperate;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy clickIoc;

    public FlockFeedListCardOperateSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<mc1.a>() { // from class: com.tencent.mobileqq.flock.feedlist.section.FlockFeedListCardOperateSection$clickIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedListCardOperateSection.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final mc1.a invoke() {
                    Object p16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (mc1.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    p16 = FlockFeedListCardOperateSection.this.p(mc1.a.class);
                    return (mc1.a) p16;
                }
            });
            this.clickIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void s(final boolean isActive) {
        TextView textView = this.tvOperate;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOperate");
            textView = null;
        }
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feedlist.section.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                FlockFeedListCardOperateSection.t(isActive, this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void t(boolean z16, FlockFeedListCardOperateSection this$0, View view) {
        mc1.a w3;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16 && (w3 = this$0.w()) != null) {
            w3.t4(((com.tencent.mobileqq.flock.feeddetail.bean.a) this$0.mData).a());
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void u(boolean isActive) {
        String str;
        TextView textView = this.tvOperate;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOperate");
            textView = null;
        }
        if (isActive) {
            str = "\u8fdb\u7fa4";
        } else {
            str = "\u5df2\u7ed3\u675f";
        }
        textView.setText(str);
        textView.setEnabled(isActive);
    }

    private final void v(boolean isActive) {
        int i3;
        Map<String, Object> mutableMapOf;
        Pair[] pairArr = new Pair[1];
        if (isActive) {
            i3 = 2;
        } else {
            i3 = 3;
        }
        pairArr[0] = TuplesKt.to(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, Integer.valueOf(i3));
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
        TextView textView = this.tvOperate;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvOperate");
            textView = null;
        }
        com.tencent.mobileqq.flock.datong.c.d(textView, "em_bas_search_sub_activity_entry_button", new com.tencent.mobileqq.flock.datong.b().g(mutableMapOf));
    }

    private final mc1.a w() {
        return (mc1.a) this.clickIoc.getValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f1192376a};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
        } else if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.f109776gq);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.tv_operate)");
            this.tvOperate = (TextView) findViewById;
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
            u(e.e(data.a().f449374i));
            s(e.e(data.a().f449374i));
            v(e.e(data.a().f449374i));
        }
    }
}
