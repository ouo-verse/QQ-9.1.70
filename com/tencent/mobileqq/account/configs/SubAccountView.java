package com.tencent.mobileqq.account.configs;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.listitem.QUIListItemBackgroundType;
import com.tencent.mobileqq.widget.listitem.QUISingleLineListItem;
import com.tencent.mobileqq.widget.listitem.x;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tR\u0016\u0010\u000e\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0016\u0010\u0013\u001a\u00020\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/account/configs/SubAccountView;", "Landroid/widget/FrameLayout;", "", "", "subAccountList", "", "d", "Lcom/tencent/mobileqq/widget/listitem/x$b;", "left", "Lcom/tencent/mobileqq/widget/listitem/x$c;", "right", "e", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "Lcom/tencent/mobileqq/widget/listitem/QUISingleLineListItem;", "singleLineListItem", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "avatarIvFirst", "f", "avatarIvSecond", "Lcom/tencent/mobileqq/account/viewmodel/c;", "vm", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Lcom/tencent/mobileqq/account/viewmodel/c;Landroidx/lifecycle/LifecycleOwner;Landroid/content/Context;Landroid/util/AttributeSet;I)V", "qqaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes9.dex */
public final class SubAccountView extends FrameLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QUISingleLineListItem singleLineListItem;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQProAvatarView avatarIvFirst;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQProAvatarView avatarIvSecond;

    public /* synthetic */ SubAccountView(com.tencent.mobileqq.account.viewmodel.c cVar, LifecycleOwner lifecycleOwner, Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(cVar, lifecycleOwner, context, (i16 & 8) != 0 ? null : attributeSet, (i16 & 16) != 0 ? 0 : i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, cVar, lifecycleOwner, context, attributeSet, Integer.valueOf(i3), Integer.valueOf(i16), defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(List<String> subAccountList) {
        int size = subAccountList.size();
        if (size != 1) {
            if (size != 2) {
                this.avatarIvFirst.setVisibility(8);
                this.avatarIvSecond.setVisibility(8);
                return;
            } else {
                this.avatarIvSecond.setVisibility(0);
                this.avatarIvSecond.w(1, subAccountList.get(0));
                this.avatarIvFirst.setVisibility(0);
                this.avatarIvFirst.w(1, subAccountList.get(1));
                return;
            }
        }
        this.avatarIvSecond.setVisibility(0);
        this.avatarIvSecond.w(1, subAccountList.get(0));
        this.avatarIvFirst.setVisibility(8);
    }

    public final void e(@NotNull x.b left, @NotNull x.c right) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) left, (Object) right);
            return;
        }
        Intrinsics.checkNotNullParameter(left, "left");
        Intrinsics.checkNotNullParameter(right, "right");
        this.singleLineListItem.setConfig(left, right);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubAccountView(@Nullable com.tencent.mobileqq.account.viewmodel.c cVar, @Nullable LifecycleOwner lifecycleOwner, @NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        MutableLiveData<List<String>> P1;
        Intrinsics.checkNotNullParameter(context, "context");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, cVar, lifecycleOwner, context, attributeSet, Integer.valueOf(i3));
            return;
        }
        QUISingleLineListItem qUISingleLineListItem = new QUISingleLineListItem(context, null);
        qUISingleLineListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        qUISingleLineListItem.setBackgroundType(QUIListItemBackgroundType.None);
        this.singleLineListItem = qUISingleLineListItem;
        addView(qUISingleLineListItem);
        QQProAvatarView qQProAvatarView = new QQProAvatarView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        int dpToPx = ViewUtils.dpToPx(32.0f);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.gravity = 8388629;
        layoutParams.setMarginEnd(ViewUtils.dpToPx(32.0f));
        qQProAvatarView.setLayoutParams(layoutParams);
        qQProAvatarView.setVisibility(8);
        this.avatarIvSecond = qQProAvatarView;
        addView(qQProAvatarView);
        QQProAvatarView qQProAvatarView2 = new QQProAvatarView(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        int dpToPx2 = ViewUtils.dpToPx(32.0f);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(dpToPx2, dpToPx2);
        layoutParams2.gravity = 8388629;
        layoutParams2.setMarginEnd(ViewUtils.dpToPx(57.0f));
        qQProAvatarView2.setLayoutParams(layoutParams2);
        qQProAvatarView2.setVisibility(8);
        this.avatarIvFirst = qQProAvatarView2;
        addView(qQProAvatarView2);
        if (lifecycleOwner == null || cVar == null || (P1 = cVar.P1()) == null) {
            return;
        }
        final Function1<List<? extends String>, Unit> function1 = new Function1<List<? extends String>, Unit>() { // from class: com.tencent.mobileqq.account.configs.SubAccountView$3$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) SubAccountView.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends String> list) {
                invoke2((List<String>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> it) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                SubAccountView subAccountView = SubAccountView.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                subAccountView.d(it);
            }
        };
        P1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.account.configs.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                SubAccountView.c(Function1.this, obj);
            }
        });
    }
}
