package l82;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.tencent.biz.richframework.compat.RFWImmersiveUtils;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.common.picload.QQPicLoader;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.reborn.guide.manager.util.ScheduleManager;
import com.tencent.mobileqq.matchfriend.reborn.register.guest.QQStrangerGuestHelper;
import com.tencent.mobileqq.matchfriend.reborn.utils.n;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ui.VasPagImageView;
import com.tencent.mobileqq.widget.RoundRelativeLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 )2\u00020\u0001:\u0001*B3\u0012\u0006\u0010\u0019\u001a\u00020\u0017\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001a\u0012\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u001d\u00a2\u0006\u0004\b'\u0010(J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\n\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0016J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\b\u0010\u0012\u001a\u00020\fH\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\fR\u0014\u0010\u0019\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u001bR&\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u001bR\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006+"}, d2 = {"Ll82/e;", "Ll82/a;", "", tl.h.F, "", "isNotifyNextElement", "c", "e", "Landroid/graphics/drawable/Drawable;", "d", "Landroid/widget/ImageView;", "imageView", "", "url", "f", "isElementCanActivate", "onElementActivated", "onElementInactivated", "getContextHashCode", "", "getPriority", "text", "g", "Landroid/app/Activity;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/view/View;", "Landroid/view/View;", "matchChatView", "Lkotlin/Function2;", "Lcom/tencent/mobileqq/vas/ui/VasPagImageView;", "Lkotlin/jvm/functions/Function2;", "loadPagListener", "i", "userGuideLayout", "Landroid/widget/TextView;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/TextView;", "guideTipsTv", "<init>", "(Landroid/app/Activity;Landroid/view/View;Lkotlin/jvm/functions/Function2;)V", BdhLogUtil.LogTag.Tag_Conn, "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class e extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final View matchChatView;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Function2<VasPagImageView, String, Unit> loadPagListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private View userGuideLayout;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private TextView guideTipsTv;

    /* JADX WARN: Multi-variable type inference failed */
    public e(Activity activity, View view, Function2<? super VasPagImageView, ? super String, Unit> loadPagListener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(loadPagListener, "loadPagListener");
        this.activity = activity;
        this.matchChatView = view;
        this.loadPagListener = loadPagListener;
        m82.a aVar = m82.a.f416439a;
        aVar.a().h(this, (r15 & 2) != 0 ? Dispatcher.DEFAULT_GROUP_NAME : null, (r15 & 4) != 0 ? "" : null, (r15 & 8) != 0 ? Integer.MIN_VALUE : 0, (r15 & 16) != 0 ? Long.MIN_VALUE : 0L, (r15 & 32) == 0 ? 1 : Integer.MIN_VALUE);
        ScheduleManager.l(aVar.a(), this, null, null, !com.tencent.mobileqq.matchfriend.reborn.utils.h.i() ? 1 : 0, true, 6, null);
    }

    private final void c(boolean isNotifyNextElement) {
        View view = this.userGuideLayout;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
        this.userGuideLayout = null;
        QUIImmersiveHelper.s(this.activity, false, true);
        m82.a aVar = m82.a.f416439a;
        ScheduleManager.b(aVar.a(), this, null, null, 6, null);
        aVar.b().inactivateElement(this, isNotifyNextElement);
        QLog.d("MatchChatGuideElement", 1, "Set has show match chat guide");
    }

    private final Drawable d() {
        Activity activity = this.activity;
        return ContextCompat.getDrawable(activity, n.f245488a.a(activity) ? R.drawable.f9g : R.drawable.f9f);
    }

    private final void e() {
        if (this.userGuideLayout == null) {
            this.userGuideLayout = LayoutInflater.from(this.activity).inflate(R.layout.cyf, (ViewGroup) null);
        }
        View view = this.userGuideLayout;
        if (view != null && view.getParent() == null) {
            View decorView = this.activity.getWindow().getDecorView();
            Intrinsics.checkNotNullExpressionValue(decorView, "activity.window.decorView");
            if (decorView instanceof ViewGroup) {
                ((ViewGroup) decorView).addView(view, new ViewGroup.LayoutParams(-1, -1));
            }
        }
    }

    private final void f(ImageView imageView, String url) {
        QQPicLoader qQPicLoader = QQPicLoader.f201806a;
        Option loadingDrawable = Option.obtain().setUrl(url).setTargetView(imageView).setLoadingDrawable(new ColorDrawable(0));
        Intrinsics.checkNotNullExpressionValue(loadingDrawable, "obtain()\n               \u2026wable(Color.TRANSPARENT))");
        qQPicLoader.e(loadingDrawable, null);
    }

    private final void h() {
        e();
        View view = this.userGuideLayout;
        if (view == null) {
            return;
        }
        View findViewById = view.findViewById(R.id.oou);
        Intrinsics.checkNotNullExpressionValue(findViewById, "guideLayout.findViewById\u2026id.qqstranger_match_chat)");
        this.guideTipsTv = (TextView) view.findViewById(R.id.ooz);
        View findViewById2 = view.findViewById(R.id.ooy);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "guideLayout.findViewById\u2026qstranger_match_chat_pag)");
        View findViewById3 = view.findViewById(R.id.oox);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "guideLayout.findViewById\u2026er_match_chat_guide_anim)");
        view.setVisibility(0);
        view.setBackground(d());
        this.loadPagListener.invoke((VasPagImageView) findViewById2, "https://downv6.qq.com/extendfriend/qqstranger_match_chat_entry.pag");
        f((ImageView) findViewById3, "https://downv6.qq.com/extendfriend/qqstranger_match_chat_guide_animv1.png");
        Resources resources = this.activity.getResources();
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = ViewUtils.dpToPx(17.0f) + resources.getDimensionPixelSize(R.dimen.f10532b) + RFWImmersiveUtils.getStatusBarHeight();
            findViewById.setLayoutParams(marginLayoutParams);
        }
        RoundRelativeLayout roundRelativeLayout = findViewById instanceof RoundRelativeLayout ? (RoundRelativeLayout) findViewById : null;
        if (roundRelativeLayout != null) {
            roundRelativeLayout.f316195e = ViewUtils.dpToPx(8.0f);
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: l82.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.i(e.this, view2);
            }
        });
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: l82.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e.j(e.this, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (hf0.a.a("match_chat_guide_view")) {
            return;
        }
        this$0.c(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(e this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view2 = this$0.matchChatView;
        if (view2 != null) {
            view2.performClick();
        }
        this$0.c(false);
    }

    public final void g(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        TextView textView = this.guideTipsTv;
        if (textView == null) {
            return;
        }
        textView.setText(text);
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public String getContextHashCode() {
        return String.valueOf(this.activity.hashCode());
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public int getPriority() {
        return 104;
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public boolean isElementCanActivate() {
        boolean z16 = false;
        if (com.tencent.mobileqq.matchfriend.reborn.utils.g.f245479a.c(this.activity)) {
            return false;
        }
        if (ScheduleManager.d(m82.a.f416439a.a(), this, null, null, 6, null) && QQStrangerGuestHelper.f245363a.c()) {
            z16 = true;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MatchChatGuideElement", 2, "Check can activated " + z16);
        }
        return z16;
    }

    @Override // l82.a, com.tencent.biz.richframework.order.IOrderElement
    public void onElementActivated() {
        super.onElementActivated();
        QLog.i("MatchChatGuideElement", 1, "Activate main chat guide");
        h();
    }

    @Override // com.tencent.biz.richframework.order.IOrderElement
    public void onElementInactivated() {
        if (QLog.isColorLevel()) {
            QLog.d("MatchChatGuideElement", 2, "Element inactivated");
        }
    }
}
