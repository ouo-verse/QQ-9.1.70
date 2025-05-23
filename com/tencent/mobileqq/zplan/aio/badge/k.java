package com.tencent.mobileqq.zplan.aio.badge;

import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00152\u00020\u0001:\u0001\tB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\"\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\u0014R\u0016\u0010\u0017\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0016R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0019\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/k;", "", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/aio/badge/c;", "data", "Lcom/tencent/widget/calloutpopupwindow/CalloutPopupWindow;", "a", "Landroid/view/View;", "anchorView", "", "f", "Landroid/widget/PopupWindow$OnDismissListener;", "listener", "e", "Landroid/view/View$OnClickListener;", "d", "b", "", "c", "Lcom/tencent/widget/calloutpopupwindow/CalloutPopupWindow;", "popupWindow", "Lcom/tencent/mobileqq/zplan/aio/badge/j;", "Lcom/tencent/mobileqq/zplan/aio/badge/j;", "statusTipsHelper", "<init>", "(Lmqq/app/AppRuntime;Landroid/content/Context;Lcom/tencent/mobileqq/zplan/aio/badge/c;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class k {

    /* renamed from: c, reason: collision with root package name */
    private static final a f330960c = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final CalloutPopupWindow popupWindow;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private j statusTipsHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/zplan/aio/badge/k$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public k(AppRuntime appRuntime, Context context, c data) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(data, "data");
        this.popupWindow = a(appRuntime, context, data);
    }

    private final CalloutPopupWindow a(AppRuntime app, Context context, c data) {
        int color;
        CalloutPopupWindow build;
        CalloutPopupWindow.DrawableBuilder drawableBuilder = new CalloutPopupWindow.DrawableBuilder(CalloutPopupWindow.builder(context).setText(data.getText()).setTextSize(14.0f).setTextColor(-1).setPosition(50).setLifetime(data.getLifeTime()).setTextSingleLine(true).setMaxWidth((int) (context.getResources().getDisplayMetrics().widthPixels * 0.5d)));
        if (ThemeUtil.isNowThemeIsNight(app, false, null)) {
            color = context.getResources().getColor(R.color.c4t);
        } else {
            color = context.getResources().getColor(R.color.c4v);
        }
        CalloutPopupWindow.Builder build2 = drawableBuilder.setBackgroundColor(color).setBackgroundRadius(8).build();
        if (data instanceof com.tencent.mobileqq.zplan.aio.badge.a) {
            com.tencent.mobileqq.zplan.aio.badge.a aVar = (com.tencent.mobileqq.zplan.aio.badge.a) data;
            if (aVar.c().isEmpty()) {
                build = build2.build();
            } else {
                j jVar = new j(context, aVar);
                this.statusTipsHelper = jVar;
                build = build2.build(jVar.a());
            }
            Intrinsics.checkNotNullExpressionValue(build, "{\n            if (data.u\u2026)\n            }\n        }");
            return build;
        }
        CalloutPopupWindow build3 = build2.build();
        Intrinsics.checkNotNullExpressionValue(build3, "{\n            windowBuilder.build()\n        }");
        return build3;
    }

    public final void b() {
        CalloutPopupWindow calloutPopupWindow = this.popupWindow;
        if (calloutPopupWindow != null) {
            calloutPopupWindow.dismiss();
        }
        j jVar = this.statusTipsHelper;
        if (jVar != null) {
            jVar.e();
        }
        this.statusTipsHelper = null;
    }

    public final boolean c() {
        CalloutPopupWindow calloutPopupWindow = this.popupWindow;
        if (calloutPopupWindow != null) {
            return calloutPopupWindow.isShowing();
        }
        return false;
    }

    public final void d(View.OnClickListener listener) {
        View contentView;
        Intrinsics.checkNotNullParameter(listener, "listener");
        CalloutPopupWindow calloutPopupWindow = this.popupWindow;
        if (calloutPopupWindow == null || (contentView = calloutPopupWindow.getContentView()) == null) {
            return;
        }
        contentView.setOnClickListener(listener);
    }

    public final void e(PopupWindow.OnDismissListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        CalloutPopupWindow calloutPopupWindow = this.popupWindow;
        if (calloutPopupWindow != null) {
            calloutPopupWindow.setOnDismissListener(listener);
        }
    }

    public final void f(View anchorView) {
        if (this.popupWindow == null) {
            QLog.d("ZplanEntranceTips", 1, "showTips, popupWindow is null");
            return;
        }
        if (anchorView == null) {
            QLog.d("ZplanEntranceTips", 1, "showTips, anchorView is null");
        } else if (anchorView.getVisibility() == 8) {
            QLog.d("ZplanEntranceTips", 1, "showTips, anchorView is gone");
        } else {
            QLog.d("ZplanEntranceTips", 1, "ZplanEntranceTips showed");
            this.popupWindow.showAsPointer(anchorView);
        }
    }
}
