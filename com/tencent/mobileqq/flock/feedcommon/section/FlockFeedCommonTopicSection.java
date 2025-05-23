package com.tencent.mobileqq.flock.feedcommon.section;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001&B\u0007\u00a2\u0006\u0004\b#\u0010$J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\f\u0010\u0005\u001a\u00020\u0003*\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J*\u0010\u0011\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0014R\u0016\u0010\u0014\u001a\u00020\b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u001d\u0010\"\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/section/FlockFeedCommonTopicSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "", ReportConstant.COSTREPORT_PREFIX, "u", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "w", "d", "Landroid/view/View;", "topicLayout", "Landroid/widget/ImageView;", "e", "Landroid/widget/ImageView;", "ivTopic", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "tvTopic", "Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", h.F, "Lkotlin/Lazy;", "v", "()Lcom/tencent/mobileqq/flock/feedcommon/ioc/b;", "sectionIoc", "<init>", "()V", "i", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockFeedCommonTopicSection extends com.tencent.mobileqq.flock.base.c<com.tencent.mobileqq.flock.feeddetail.bean.a> {
    static IPatchRedirector $redirector_;
    private static final int C;
    private static final int D;
    private static final int E;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: m, reason: collision with root package name */
    private static final int f210059m;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View topicLayout;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ImageView ivTopic;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView tvTopic;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy sectionIoc;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/flock/feedcommon/section/FlockFeedCommonTopicSection$a;", "", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonTopicSection$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
                return;
            }
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) defaultConstructorMarker);
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25043);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
            return;
        }
        INSTANCE = new Companion(null);
        f210059m = Color.parseColor("#FFE6F5FF");
        C = Color.parseColor("#FF004573");
        D = Color.parseColor("#FF0099FF");
        E = Color.parseColor("#FF0099FF");
    }

    public FlockFeedCommonTopicSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.flock.feedcommon.ioc.b>() { // from class: com.tencent.mobileqq.flock.feedcommon.section.FlockFeedCommonTopicSection$sectionIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockFeedCommonTopicSection.this);
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
                    p16 = FlockFeedCommonTopicSection.this.p(com.tencent.mobileqq.flock.feedcommon.ioc.b.class);
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
        if (v3 != null && v3.T1()) {
            View view = this.topicLayout;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.feedcommon.section.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FlockFeedCommonTopicSection.t(FlockFeedCommonTopicSection.this, v3, view2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void t(FlockFeedCommonTopicSection this$0, com.tencent.mobileqq.flock.feedcommon.ioc.b this_run, View view) {
        Integer num;
        Object orNull;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_run, "$this_run");
        y45.f[] fVarArr = ((com.tencent.mobileqq.flock.feeddetail.bean.a) this$0.mData).a().f449383r;
        if (fVarArr != null) {
            orNull = ArraysKt___ArraysKt.getOrNull(fVarArr, 0);
            y45.f fVar = (y45.f) orNull;
            if (fVar != null) {
                num = Integer.valueOf(fVar.f449391a);
                if (num != null) {
                    num.intValue();
                    Context context = this$0.mRootView.getContext();
                    Intrinsics.checkNotNullExpressionValue(context, "mRootView.context");
                    this_run.j3(context, num.intValue());
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        }
        num = null;
        if (num != null) {
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
    
        if (r0 != false) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.view.View] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void u(com.tencent.mobileqq.flock.feeddetail.bean.a aVar) {
        boolean z16;
        boolean z17;
        boolean isBlank;
        String b16 = com.tencent.mobileqq.flock.ktx.e.b(aVar.a());
        boolean z18 = true;
        if (b16 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(b16);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    com.tencent.mobileqq.flock.feedcommon.ioc.b v3 = v();
                    if (v3 != null) {
                        z17 = v3.s1();
                    } else {
                        z17 = false;
                    }
                }
                z18 = false;
                TextView textView = null;
                if (!z18) {
                    View view = this.topicLayout;
                    if (view == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                        view = null;
                    }
                    view.setVisibility(0);
                    TextView textView2 = this.tvTopic;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("tvTopic");
                    } else {
                        textView = textView2;
                    }
                    textView.setText(com.tencent.mobileqq.flock.ktx.e.b(aVar.a()));
                    return;
                }
                ?? r56 = this.topicLayout;
                if (r56 == 0) {
                    Intrinsics.throwUninitializedPropertyAccessException("topicLayout");
                } else {
                    textView = r56;
                }
                textView.setVisibility(8);
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
        z18 = false;
        TextView textView3 = null;
        if (!z18) {
        }
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
        return new int[]{R.id.f1193976q};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        int i3;
        int i16;
        int i17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.yfu);
            Drawable background = findViewById.getBackground();
            com.tencent.mobileqq.flock.picloader.a a16 = com.tencent.mobileqq.flock.picloader.a.a();
            if (QQTheme.isNowThemeIsNight()) {
                i3 = C;
            } else {
                i3 = f210059m;
            }
            findViewById.setBackground(a16.e(background, i3));
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<View>(R.id.\u2026Y_BG_COLOR)\n            }");
            this.topicLayout = findViewById;
            View findViewById2 = containerView.findViewById(R.id.y_6);
            ImageView imageView = (ImageView) findViewById2;
            Drawable drawable = imageView.getDrawable();
            com.tencent.mobileqq.flock.picloader.a a17 = com.tencent.mobileqq.flock.picloader.a.a();
            if (QQTheme.isNowThemeIsNight()) {
                i16 = E;
            } else {
                i16 = D;
            }
            Drawable e16 = a17.e(drawable, i16);
            if (e16 != null) {
                imageView.setImageDrawable(e16);
            }
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById<ImageView>(\u2026          }\n            }");
            this.ivTopic = imageView;
            View findViewById3 = containerView.findViewById(R.id.me6);
            TextView textView = (TextView) findViewById3;
            if (QQTheme.isNowThemeIsNight()) {
                i17 = E;
            } else {
                i17 = D;
            }
            textView.setTextColor(i17);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById<TextView>(R\u2026TEXT_COLOR)\n            }");
            this.tvTopic = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.feeddetail.bean.a data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
        } else if (data != null) {
            u(data);
            s();
        }
    }
}
