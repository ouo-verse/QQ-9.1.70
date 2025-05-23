package com.tencent.qqnt.markdown.data.quote;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.markdown.api.IRichJumpApi;
import com.tencent.qqnt.markdown.data.quote.b;
import com.tencent.util.LoadingUtil;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000 12\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b/\u00100J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\u0018\u0010\u0010\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000f\u001a\u00020\u0006R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0016R\u0014\u0010\u001a\u001a\u00020\u00188\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0019R\u0014\u0010\u001b\u001a\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0016R\u0014\u0010\u001e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010!\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010 R\u0014\u0010#\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010\u001dR\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010*\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b,\u0010-\u00a8\u00062"}, d2 = {"Lcom/tencent/qqnt/markdown/data/quote/e;", "", "Landroid/content/Context;", "context", "", "d", "", "drawableResId", "colorResId", "Landroid/graphics/drawable/Drawable;", "b", "Landroidx/constraintlayout/widget/ConstraintLayout;", "c", "Lcom/tencent/qqnt/markdown/data/quote/j;", "data", "width", "f", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "loadingIcon", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "loadingTips", "loadingArrow", "e", "Landroidx/constraintlayout/widget/ConstraintLayout;", "loadingLayout", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "contentRecyclerView", "g", "containerLayout", "Lcom/tencent/qqnt/markdown/data/quote/b;", tl.h.F, "Lcom/tencent/qqnt/markdown/data/quote/b;", "contentAdapter", "i", "Lcom/tencent/qqnt/markdown/data/quote/j;", "citationData", "", "j", "Z", "isExpanded", "<init>", "(Landroid/content/Context;)V", "k", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView loadingIcon;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView loadingTips;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView loadingArrow;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout loadingLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final RecyclerView contentRecyclerView;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ConstraintLayout containerLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private com.tencent.qqnt.markdown.data.quote.b contentAdapter;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private j citationData;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private boolean isExpanded;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/markdown/data/quote/e$a;", "", "", "LOADING_STATE_FAIL", "I", "LOADING_STATE_NONE", "LOADING_STATE_SUCCESS", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.markdown.data.quote.e$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/qqnt/markdown/data/quote/e$b", "Lcom/tencent/qqnt/markdown/data/quote/b$a;", "Landroid/view/View;", "view", "Lcom/tencent/qqnt/markdown/data/quote/f;", "data", "", "position", "", "a", "rich_kit_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements b.a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f359421a;

        b(Context context) {
            this.f359421a = context;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // com.tencent.qqnt.markdown.data.quote.b.a
        public void a(@Nullable View view, @Nullable f data, int position) {
            boolean startsWith$default;
            boolean startsWith$default2;
            boolean startsWith$default3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, view, data, Integer.valueOf(position));
                return;
            }
            if (data != null && !TextUtils.isEmpty(data.b())) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(data.b(), "http", false, 2, null);
                if (!startsWith$default) {
                    startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(data.b(), "https", false, 2, null);
                    if (!startsWith$default2) {
                        startsWith$default3 = StringsKt__StringsJVMKt.startsWith$default(data.b(), SchemaUtils.SCHEMA_MQQAPI, false, 2, null);
                        if (startsWith$default3) {
                            ((IRichJumpApi) QRoute.api(IRichJumpApi.class)).doUrlAction(this.f359421a, data.b());
                            return;
                        }
                        return;
                    }
                }
                ((IRichJumpApi) QRoute.api(IRichJumpApi.class)).openBrowser(this.f359421a, data.b());
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35273);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        this.context = context;
        ImageView imageView = new ImageView(context);
        int dpToPx = ViewUtils.dpToPx(20.0f);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.leftToLeft = 0;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        imageView.setLayoutParams(layoutParams);
        imageView.setId(View.generateViewId());
        this.loadingIcon = imageView;
        TextView textView = new TextView(context);
        ConstraintLayout.LayoutParams layoutParams2 = new ConstraintLayout.LayoutParams(-2, -2);
        ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin = ViewUtils.dpToPx(4.0f);
        ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = ViewUtils.dpToPx(30.0f);
        layoutParams2.leftToRight = imageView.getId();
        layoutParams2.topToTop = 0;
        layoutParams2.bottomToBottom = 0;
        layoutParams2.rightToRight = 0;
        layoutParams2.horizontalBias = 0.0f;
        layoutParams2.constrainedWidth = true;
        textView.setLayoutParams(layoutParams2);
        textView.setMaxLines(1);
        textView.setTextSize(14.0f);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTextColor(textView.getResources().getColor(R.color.qui_common_bubble_guest_text_primary));
        this.loadingTips = textView;
        ImageView imageView2 = new ImageView(context);
        int dpToPx2 = ViewUtils.dpToPx(16.0f);
        ConstraintLayout.LayoutParams layoutParams3 = new ConstraintLayout.LayoutParams(dpToPx2, dpToPx2);
        layoutParams3.rightToRight = 0;
        layoutParams3.topToTop = 0;
        layoutParams3.bottomToBottom = 0;
        imageView2.setLayoutParams(layoutParams3);
        imageView2.setVisibility(4);
        this.loadingArrow = imageView2;
        ConstraintLayout constraintLayout = new ConstraintLayout(context);
        constraintLayout.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        constraintLayout.addView(imageView);
        constraintLayout.addView(textView);
        constraintLayout.addView(imageView2);
        constraintLayout.setId(View.generateViewId());
        this.loadingLayout = constraintLayout;
        RecyclerView recyclerView = new RecyclerView(context);
        ConstraintLayout.LayoutParams layoutParams4 = new ConstraintLayout.LayoutParams(-1, -2);
        layoutParams4.topToBottom = constraintLayout.getId();
        ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin = ViewUtils.dpToPx(8.0f);
        recyclerView.setLayoutParams(layoutParams4);
        recyclerView.setClipToPadding(false);
        recyclerView.setVerticalScrollBarEnabled(false);
        recyclerView.setOverScrollMode(2);
        recyclerView.setVisibility(8);
        this.contentRecyclerView = recyclerView;
        ConstraintLayout constraintLayout2 = new ConstraintLayout(context);
        constraintLayout2.setLayoutParams(new ConstraintLayout.LayoutParams(-1, -2));
        int dpToPx3 = ViewUtils.dpToPx(10.0f);
        int dpToPx4 = ViewUtils.dpToPx(7.0f);
        constraintLayout2.setPadding(dpToPx3, dpToPx4, dpToPx3, dpToPx4);
        constraintLayout2.addView(constraintLayout);
        constraintLayout2.addView(recyclerView);
        this.containerLayout = constraintLayout2;
        d(context);
    }

    private final Drawable b(int drawableResId, int colorResId) {
        return ie0.a.f().o(this.context, drawableResId, colorResId, 1001);
    }

    private final void d(Context context) {
        List<f> list;
        this.isExpanded = false;
        this.loadingIcon.setImageDrawable(LoadingUtil.getLoadingDrawable(context, 2));
        this.loadingArrow.setImageDrawable(b(R.drawable.qui_chevron_down, R.color.qui_common_icon_primary));
        this.contentRecyclerView.setVisibility(8);
        this.loadingLayout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.qqnt.markdown.data.quote.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                e.e(e.this, view);
            }
        });
        j jVar = this.citationData;
        if (jVar != null) {
            list = jVar.a();
        } else {
            list = null;
        }
        com.tencent.qqnt.markdown.data.quote.b bVar = new com.tencent.qqnt.markdown.data.quote.b(context, list);
        this.contentAdapter = bVar;
        bVar.n0(new b(context));
        this.contentRecyclerView.addItemDecoration(new b.c(ViewUtils.dpToPx(6.0f)));
        this.contentRecyclerView.setAdapter(this.contentAdapter);
        this.contentRecyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(context.getColorStateList(R.color.qui_common_fill_standard_primary));
        gradientDrawable.setCornerRadius(ViewUtils.dpToPx(4.0f));
        this.containerLayout.setBackground(gradientDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(e this$0, View view) {
        List<f> list;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        j jVar = this$0.citationData;
        if (jVar != null) {
            list = jVar.a();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            if (this$0.isExpanded) {
                this$0.loadingArrow.setImageDrawable(this$0.b(R.drawable.qui_chevron_down, R.color.qui_common_icon_primary));
                this$0.contentRecyclerView.setVisibility(8);
                this$0.isExpanded = false;
            } else {
                this$0.loadingArrow.setImageDrawable(this$0.b(R.drawable.qui_chevron_up, R.color.qui_common_icon_primary));
                this$0.contentRecyclerView.setVisibility(0);
                this$0.isExpanded = true;
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @NotNull
    public final ConstraintLayout c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (ConstraintLayout) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.containerLayout;
    }

    public final void f(@Nullable j data, int width) {
        boolean z16;
        boolean z17;
        String str;
        String str2;
        Integer num;
        Integer num2;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 4;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) data, width);
            return;
        }
        if (data == null) {
            return;
        }
        String str3 = null;
        boolean z18 = true;
        if (QLog.isDevelopLevel()) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append("updateData loadingTips = ");
            g b16 = data.b();
            if (b16 != null) {
                str2 = b16.a();
            } else {
                str2 = null;
            }
            sb5.append(str2);
            sb5.append(", status = ");
            g b17 = data.b();
            if (b17 != null) {
                num = Integer.valueOf(b17.b());
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(", contentDataList.size = ");
            List<f> a16 = data.a();
            if (a16 != null) {
                num2 = Integer.valueOf(a16.size());
            } else {
                num2 = null;
            }
            sb5.append(num2);
            QLog.d("QuoteComponent", 1, sb5.toString());
        }
        this.citationData = data;
        g b18 = data.b();
        if (b18 != null && b18.b() == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            this.loadingIcon.setImageDrawable(b(R.drawable.qui_tick_circle, R.color.qui_common_brand_standard));
        } else {
            g b19 = data.b();
            if (b19 != null && b19.b() == 2) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this.loadingIcon.setImageDrawable(b(R.drawable.qui_caution_circle, R.color.qui_common_brand_standard));
            } else {
                this.loadingIcon.setImageDrawable(LoadingUtil.getLoadingDrawable(this.context, 2));
            }
        }
        g b26 = data.b();
        if (b26 != null) {
            str = b26.a();
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            TextView textView = this.loadingTips;
            g b27 = data.b();
            if (b27 != null) {
                str3 = b27.a();
            }
            textView.setText(str3);
        }
        ImageView imageView = this.loadingArrow;
        List<f> a17 = data.a();
        if (a17 == null || a17.isEmpty()) {
            z18 = false;
        }
        if (z18) {
            i3 = 0;
        }
        imageView.setVisibility(i3);
        com.tencent.qqnt.markdown.data.quote.b bVar = this.contentAdapter;
        if (bVar != null) {
            bVar.setData(data.a());
        }
        this.loadingArrow.setImageDrawable(b(R.drawable.qui_chevron_down, R.color.qui_common_icon_primary));
        this.contentRecyclerView.setVisibility(8);
        ViewGroup.LayoutParams layoutParams = this.containerLayout.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = width;
        }
    }
}
