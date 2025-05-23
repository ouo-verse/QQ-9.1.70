package com.tencent.mobileqq.setting.config;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u00a2\u0006\u0004\b \u0010!J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ7\u0010\u0011\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022%\b\u0002\u0010\u0010\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000bJ\u0006\u0010\u0013\u001a\u00020\u0012R\u0016\u0010\u0016\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0018\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/setting/config/SingleLineRedTouchView;", "Landroid/widget/FrameLayout;", "", "redTouchPath", "", "c", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "left", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "right", "d", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", NodeProps.ON_CLICK, "e", "", "b", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "singleLineListItem", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "Lcom/tencent/mobileqq/tianshu/ui/RedTouch;", "redTouch", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qq_setting_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes18.dex */
public final class SingleLineRedTouchView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QUISingleLineListItem singleLineListItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RedTouch redTouch;

    public /* synthetic */ SingleLineRedTouchView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    private final void c(String redTouchPath) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        ((IRedTouchManager) runtimeService).onRedTouchItemClick(redTouchPath);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(Function1 function1, SingleLineRedTouchView this$0, String str, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (function1 != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            function1.invoke(it);
        }
        this$0.c(str);
        EventCollector.getInstance().onViewClicked(it);
    }

    public final boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.redTouch.hasRedTouch();
    }

    public final void d(@NotNull x.b left, @NotNull x.c right) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) left, (Object) right);
            return;
        }
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.singleLineListItem.setConfig(left, right);
    }

    public final void e(@Nullable final String redTouchPath, @Nullable final Function1<? super View, Unit> onClick) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) redTouchPath, (Object) onClick);
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return;
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IR\u2026va, ProcessConstant.MAIN)");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        BusinessInfoCheckUpdate.AppInfo appInfoByPath = iRedTouchManager.getAppInfoByPath(redTouchPath);
        this.redTouch.parseRedTouch(appInfoByPath);
        iRedTouchManager.onReportRedPointExposure(appInfoByPath);
        setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.setting.config.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SingleLineRedTouchView.f(Function1.this, this, redTouchPath, view);
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SingleLineRedTouchView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null);
        qUISingleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.None);
        this.singleLineListItem = qUISingleLineListItem;
        addView(qUISingleLineListItem);
        RedTouch applyTo = new RedTouch(context, this.singleLineListItem).setRightMargin(32.0f).applyTo();
        Intrinsics.checkNotNullExpressionValue(applyTo, "RedTouch(context, single\u2026f)\n            .applyTo()");
        this.redTouch = applyTo;
    }
}
