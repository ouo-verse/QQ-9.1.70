package com.tencent.mobileqq.setting.main.config;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.setting.main.config.AccountManageView;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tenpay.util.Utils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0002J\u0012\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/mobileqq/setting/main/config/AccountManageView;", "Landroid/widget/FrameLayout;", "", "b", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "left", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "right", "d", "c", "Landroid/view/View$OnClickListener;", NodeProps.ON_CLICK, "e", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "singleLineListItem", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarIv", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "f", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class AccountManageView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QUISingleLineListItem singleLineListItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private QQProAvatarView avatarIv;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private RedTouch redTouch;

    public /* synthetic */ AccountManageView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void b() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        ((IRedTouchManager) runtimeService).onRedTouchItemClick("100190.100193");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(View.OnClickListener onClickListener, AccountManageView this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (onClickListener != null) {
            onClickListener.onClick(view);
        }
        this$0.b();
    }

    public final void c() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        this.avatarIv.w(1, appInterface.getCurrentAccountUin());
    }

    public final void d(x.b left, x.c right) {
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.singleLineListItem.setConfig(left, right);
    }

    public final void e(final View.OnClickListener onClick) {
        setOnClickListener(new View.OnClickListener() { // from class: gq2.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                AccountManageView.f(onClick, this, view);
            }
        });
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath("100190.100193");
        if (appInfoByPath != null) {
            iRedTouchManager.reportLevelOneRedInfo("100190.100193", 30);
        }
        this.redTouch.parseRedTouch(appInfoByPath);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AccountManageView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null);
        qUISingleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.None);
        this.singleLineListItem = qUISingleLineListItem;
        addView(qUISingleLineListItem);
        QQProAvatarView qQProAvatarView = new QQProAvatarView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        int dp2Px = Utils.dp2Px(context, 32.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dp2Px, dp2Px);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginEnd(Utils.dp2Px(context, 32.0f));
        qQProAvatarView.setLayoutParams(layoutParams);
        this.avatarIv = qQProAvatarView;
        addView(qQProAvatarView);
        RedTouch applyTo = new RedTouch(context, this.avatarIv).setGravity(53).applyTo();
        Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(context, avatar\u2026P)\n            .applyTo()");
        this.redTouch = applyTo;
    }
}
