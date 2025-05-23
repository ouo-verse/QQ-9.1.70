package com.tencent.mobileqq.troopmanage.component;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.tencent.biz.qui.profileskin.widget.QUIImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mobileqq.widget.listitem.x.b.d;
import com.tencent.mobileqq.widget.listitem.x.c.g;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005B\u0017\u0012\u0006\u0010\u001c\u001a\u00028\u0000\u0012\u0006\u0010\u001d\u001a\u00028\u0001\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0014J&\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0014J\b\u0010\u0018\u001a\u0004\u0018\u00010\nR\u0018\u0010\u001b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/troopmanage/component/bb;", "Lcom/tencent/mobileqq/widget/listitem/x$b$d;", "Left", "Lcom/tencent/mobileqq/widget/listitem/x$c$g;", "Right", "Lcom/tencent/mobileqq/widget/listitem/x;", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "Landroid/content/Context;", "context", "Lcom/tencent/biz/qui/profileskin/widget/QUIImageView;", "W", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "view", "", "position", "", "", "payloads", "", "P", "V", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/biz/qui/profileskin/widget/QUIImageView;", "mCheckBox", "left", "right", "<init>", "(Lcom/tencent/mobileqq/widget/listitem/x$b$d;Lcom/tencent/mobileqq/widget/listitem/x$c$g;)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class bb<Left extends x.b.d, Right extends x.c.g> extends com.tencent.mobileqq.widget.listitem.x<x.b, x.c> {
    static IPatchRedirector $redirector_;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUIImageView mCheckBox;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(@NotNull Left left, @NotNull Right right) {
        super(left, right);
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) left, (Object) right);
        }
    }

    private final QUIImageView W(Context context) {
        QUIImageView qUIImageView = new QUIImageView(context);
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(DisplayUtil.dip2px(context, 16.0f), DisplayUtil.dip2px(context, 16.0f));
        marginLayoutParams.leftMargin = DisplayUtil.dip2px(context, 12.0f);
        marginLayoutParams.rightMargin = DisplayUtil.dip2px(context, 12.0f);
        qUIImageView.setLayoutParams(marginLayoutParams);
        qUIImageView.setImageResource(R.drawable.qq_account_select_icon);
        qUIImageView.setVisibility(8);
        qUIImageView.setContentDescription(HardCodeUtil.qqStr(R.string.f2061057e));
        return qUIImageView;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    /* renamed from: P */
    public void F(@NotNull QUISingleLineListItem view, int position, @NotNull List<? extends Object> payloads) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, view, Integer.valueOf(position), payloads);
            return;
        }
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(payloads, "payloads");
        super.F(view, position, payloads);
        QUIImageView qUIImageView = this.mCheckBox;
        if (qUIImageView != null) {
            if (qUIImageView.getParent() instanceof ViewGroup) {
                ViewParent parent = qUIImageView.getParent();
                Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
                ((ViewGroup) parent).removeView(this.mCheckBox);
            }
            view.f(qUIImageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.widget.listitem.x, com.tencent.mobileqq.widget.listitem.w
    @NotNull
    /* renamed from: Q */
    public QUISingleLineListItem H(@NotNull ViewGroup parent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (QUISingleLineListItem) iPatchRedirector.redirect((short) 2, (Object) this, (Object) parent);
        }
        Intrinsics.checkNotNullParameter(parent, "parent");
        Context context = parent.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "parent.context");
        this.mCheckBox = W(context);
        return super.H(parent);
    }

    @Nullable
    public final QUIImageView V() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QUIImageView) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mCheckBox;
    }
}
