package com.tencent.mobileqq.troop.troopcreate.classify;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreatePage;
import com.tencent.mobileqq.troop.utils.ay;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0004R\u0014\u0010\n\u001a\u00020\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/TroopCreateClassifyOutItemView;", "Landroid/widget/LinearLayout;", "Lcom/tencent/mobileqq/troop/troopcreate/classify/a;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "g", "d", h.F, "Landroid/widget/ImageView;", "Landroid/widget/ImageView;", "typeIv", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "typeTv", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "f", "a", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopCreateClassifyOutItemView extends LinearLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ImageView typeIv;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final TextView typeTv;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcreate/classify/TroopCreateClassifyOutItemView$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopcreate.classify.TroopCreateClassifyOutItemView$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(25147);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopCreateClassifyOutItemView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(TroopCreateClassifyOutItemView this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ITroopCreatePage iTroopCreatePage = (ITroopCreatePage) QRoute.api(ITroopCreatePage.class);
        Context context = this$0.getContext();
        Intrinsics.checkNotNull(context, "null cannot be cast to non-null type android.app.Activity");
        iTroopCreatePage.openCreateTroopByCategoryPage((Activity) context);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(TroopCreateClassifyOutItemView this$0, a item, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(item, "$item");
        this$0.g(item);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void g(a item) {
        Activity activity;
        Intent intent = new Intent();
        intent.putExtra("url", item.b());
        intent.putExtra("isShowAd", false);
        intent.putExtra("hide_more_button", true);
        intent.putExtra("hide_operation_bar", true);
        com.tencent.mobileqq.troop.troopcreate.a.k(getContext(), intent, RouterConstants.UI_ROUTE_BROWSER);
        Context context = getContext();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            activity.overridePendingTransition(R.anim.activity_new, R.anim.activity_out);
        }
        QLog.i("TroopCreateClassifyOutItemView", 1, "[jumpToH5] item:" + item);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        EventCollector.getInstance().onViewClicked(view);
    }

    public final void d(@NotNull final a item) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) item);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        this.typeTv.setText(item.c());
        this.typeTv.setContentDescription(item.c());
        ay.f302095a.a(item.a(), this.typeIv);
        if (Intrinsics.areEqual(item.d(), "em_group_more_btn")) {
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopCreateClassifyOutItemView.e(TroopCreateClassifyOutItemView.this, view);
                }
            });
        } else {
            setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TroopCreateClassifyOutItemView.f(TroopCreateClassifyOutItemView.this, item, view);
                }
            });
        }
        VideoReport.setElementId(this, item.d());
    }

    public final void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.typeTv.setText("");
        this.typeIv.setImageDrawable(null);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopcreate.classify.f
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TroopCreateClassifyOutItemView.i(view);
            }
        });
        VideoReport.setElementId(this, "");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopCreateClassifyOutItemView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) {
            return;
        }
        iPatchRedirector.redirect((short) 5, (Object) this, (Object) context, (Object) attributeSet);
    }

    public /* synthetic */ TroopCreateClassifyOutItemView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public TroopCreateClassifyOutItemView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        setOrientation(1);
        setGravity(17);
        View.inflate(context, R.layout.f168570fy2, this);
        setBackground(context.getDrawable(R.drawable.f162607lw1));
        View findViewById = findViewById(R.id.txd);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.classify_type_iv)");
        this.typeIv = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.txe);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.classify_type_text)");
        this.typeTv = (TextView) findViewById2;
    }
}
