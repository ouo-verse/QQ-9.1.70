package com.tencent.mobileqq.zplan.minixwconnected.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u0000 \u00172\u00020\u0001:\u0001\u0018B'\b\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\tR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/view/MiniHomeConnectInviteView;", "Landroid/widget/RelativeLayout;", "", "friendUin", "", "g", "f", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "c", "Landroid/view/View;", "d", "Landroid/view/View;", "contentView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "e", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class MiniHomeConnectInviteView extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View contentView;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectInviteView(Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean d(View view, MotionEvent motionEvent) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(CoroutineScope scope, long j3, View view) {
        Intrinsics.checkNotNullParameter(scope, "$scope");
        view.setEnabled(false);
        CorountineFunKt.e(scope, "MiniHomeConnectInviteNeighborComponent_\u540e\u53f0\u53d1\u9001\u9080\u8bf7ark", null, null, null, new MiniHomeConnectInviteView$initView$2$1(j3, view, null), 14, null);
    }

    private final void g(String friendUin) {
        String str;
        View view = this.contentView;
        TextView textView = view != null ? (TextView) view.findViewById(R.id.q2n) : null;
        if (textView != null) {
            textView.setText("Ta \u8fd8\u6ca1\u6709\u521b\u5efa\u8ff7\u4f60\u7a9d");
        }
        View view2 = this.contentView;
        QUIButton qUIButton = view2 != null ? (QUIButton) view2.findViewById(R.id.q2k) : null;
        if (qUIButton != null) {
            qUIButton.setText("\u9080\u8bf7 Ta \u505a\u90bb\u5c45");
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        QQAppInterface qQAppInterface = peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null;
        if (qQAppInterface == null) {
            QLog.e("MiniHomeConnectInviteView", 1, "AppRuntime is null when updateText!");
            return;
        }
        Manager manager = qQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.app.FriendsManager");
        Friends v3 = ((FriendsManager) manager).v(friendUin);
        Intrinsics.checkNotNullExpressionValue(v3, "fm.findFriendEntityByUin(friendUin)");
        String friendNick = v3.getFriendNick();
        if (friendNick.length() > 15) {
            Intrinsics.checkNotNullExpressionValue(friendNick, "friendNick");
            String substring = friendNick.substring(0, 15);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String\u2026ing(startIndex, endIndex)");
            friendNick = substring + MiniBoxNoticeInfo.APPNAME_SUFFIX;
        }
        String str2 = ((Object) friendNick) + " \u8fd8\u6ca1\u6709\u521b\u5efa\u8ff7\u4f60\u7a9d";
        if (textView != null) {
            textView.setText(str2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str2);
            spannableStringBuilder.setSpan(new StyleSpan(1), 0, friendNick.length(), 17);
            textView.setText(spannableStringBuilder);
        }
        if (qUIButton != null) {
            byte b16 = v3.gender;
            if (b16 == 1) {
                str = "\u4ed6";
            } else if (b16 == 2) {
                str = "\u5979";
            } else {
                str = "Ta";
            }
            qUIButton.setText("\u9080\u8bf7 " + str + " \u505a\u90bb\u5c45");
        }
    }

    public final void c(final CoroutineScope scope, final long friendUin) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        if (this.contentView == null) {
            this.contentView = LayoutInflater.from(getContext()).inflate(R.layout.dhn, this);
        }
        View view = this.contentView;
        ViewGroup viewGroup = view != null ? (ViewGroup) view.findViewById(R.id.ppw) : null;
        if (viewGroup != null) {
            viewGroup.setOnTouchListener(new View.OnTouchListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.e
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view2, MotionEvent motionEvent) {
                    boolean d16;
                    d16 = MiniHomeConnectInviteView.d(view2, motionEvent);
                    return d16;
                }
            });
        }
        View view2 = this.contentView;
        QUIButton qUIButton = view2 != null ? (QUIButton) view2.findViewById(R.id.q2k) : null;
        if (qUIButton != null) {
            qUIButton.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.zplan.minixwconnected.view.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view3) {
                    MiniHomeConnectInviteView.e(CoroutineScope.this, friendUin, view3);
                }
            });
        }
        try {
            g(String.valueOf(friendUin));
            f(String.valueOf(friendUin));
        } catch (Exception e16) {
            QLog.e("MiniHomeConnectInviteView", 1, "updateText error=" + e16);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectInviteView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ MiniHomeConnectInviteView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    private final void f(String friendUin) {
        View view = this.contentView;
        QQProAvatarView qQProAvatarView = view != null ? (QQProAvatarView) view.findViewById(R.id.q2o) : null;
        com.tencent.mobileqq.proavatar.e a16 = new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(640).a();
        if (qQProAvatarView != null) {
            qQProAvatarView.x(1, friendUin, a16);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MiniHomeConnectInviteView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
