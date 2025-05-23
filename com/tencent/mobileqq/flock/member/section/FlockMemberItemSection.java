package com.tencent.mobileqq.flock.member.section;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.biz.richframework.compat.ImmersiveUtils;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.flock.base.c;
import com.tencent.mobileqq.flock.utils.FlockJumpHelper;
import com.tencent.mobileqq.flock.widget.AvatarView;
import com.tencent.mobileqq.flock.widget.UserLabelView;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.plugins.QQFriendJsPlugin;
import cooperation.qqcircle.report.QCircleAlphaUserReporter;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import y45.o;

/* compiled from: P */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 02\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0014J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J*\u0010\u0012\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000fH\u0014R\u0016\u0010\u0015\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u001d\u0010-\u001a\u0004\u0018\u00010(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/flock/member/section/FlockMemberItemSection;", "Lcom/tencent/mobileqq/flock/base/c;", "Lcom/tencent/mobileqq/flock/member/bean/a;", "Ly45/o;", QCircleAlphaUserReporter.KEY_USER, "", HippyTKDListViewAdapter.X, "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "data", "", "position", "", "", "payload", "u", "d", "Landroid/view/View;", "layoutView", "Lcom/tencent/mobileqq/flock/widget/AvatarView;", "e", "Lcom/tencent/mobileqq/flock/widget/AvatarView;", "avatarImageView", "Landroid/widget/TextView;", "f", "Landroid/widget/TextView;", "userNameTv", h.F, "sender", "Lcom/tencent/mobileqq/flock/widget/UserLabelView;", "i", "Lcom/tencent/mobileqq/flock/widget/UserLabelView;", "userDetailTv", "Landroid/widget/Button;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/widget/Button;", QQFriendJsPlugin.API_ADD_FRIEND, "Lnc1/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "t", "()Lnc1/a;", "flockMemberListSectionIoc", "<init>", "()V", "D", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class FlockMemberItemSection extends c<com.tencent.mobileqq.flock.member.bean.a> {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static final int E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy flockMemberListSectionIoc;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private View layoutView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private AvatarView avatarImageView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView userNameTv;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private TextView sender;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private UserLabelView userDetailTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private Button addFriend;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/flock/member/section/FlockMemberItemSection$a;", "", "", "AVATAR_SIZE", "I", "KEY_IS_FRIEND", "KEY_IS_NOT_FRIEND", "SEXUAL_FEMALE", "SEXUAL_MALE", "SEXUAL_NONE", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.member.section.FlockMemberItemSection$a, reason: from kotlin metadata */
    /* loaded from: classes12.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47377);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
            E = ImmersiveUtils.dpToPx(52.0f);
        }
    }

    public FlockMemberItemSection() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<nc1.a>() { // from class: com.tencent.mobileqq.flock.member.section.FlockMemberItemSection$flockMemberListSectionIoc$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FlockMemberItemSection.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                @Nullable
                public final nc1.a invoke() {
                    Object p16;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (nc1.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                    }
                    p16 = FlockMemberItemSection.this.p(nc1.a.class);
                    return (nc1.a) p16;
                }
            });
            this.flockMemberListSectionIoc = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final nc1.a t() {
        return (nc1.a) this.flockMemberListSectionIoc.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(FlockMemberItemSection this$0, o this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        nc1.a t16 = this$0.t();
        if (t16 != null) {
            String id5 = this_apply.f449449a;
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            t16.Q3(id5);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(FlockMemberItemSection this$0, o this_apply, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(this_apply, "$this_apply");
        FlockJumpHelper.Companion companion = FlockJumpHelper.INSTANCE;
        View view2 = this$0.layoutView;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutView");
            view2 = null;
        }
        Context context = view2.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "layoutView.context");
        String id5 = this_apply.f449449a;
        Intrinsics.checkNotNullExpressionValue(id5, "id");
        companion.f(context, id5);
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void x(o user) {
        UserLabelView userLabelView = this.userDetailTv;
        if (userLabelView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userDetailTv");
            userLabelView = null;
        }
        userLabelView.a(user);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[]{R.id.f11919767};
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@Nullable View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        if (containerView != null) {
            View findViewById = containerView.findViewById(R.id.vbc);
            AvatarView onInitView$lambda$1$lambda$0 = (AvatarView) findViewById;
            Intrinsics.checkNotNullExpressionValue(onInitView$lambda$1$lambda$0, "onInitView$lambda$1$lambda$0");
            AvatarView.setAvatarSize$default(onInitView$lambda$1$lambda$0, E, 0, 2, null);
            Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById<AvatarView>\u2026VATAR_SIZE)\n            }");
            this.avatarImageView = onInitView$lambda$1$lambda$0;
            View findViewById2 = containerView.findViewById(R.id.vbf);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.flock_member_username)");
            this.userNameTv = (TextView) findViewById2;
            View findViewById3 = containerView.findViewById(R.id.vbd);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.flock_member_sender)");
            this.sender = (TextView) findViewById3;
            View findViewById4 = containerView.findViewById(R.id.vbe);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.flock_member_user_detail)");
            this.userDetailTv = (UserLabelView) findViewById4;
            View findViewById5 = containerView.findViewById(R.id.vbb);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.flock_member_addFriend)");
            this.addFriend = (Button) findViewById5;
            this.layoutView = containerView;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void onBindData(@Nullable com.tencent.mobileqq.flock.member.bean.a data, int position, @Nullable List<Object> payload) {
        final o a16;
        String str;
        int i3;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, data, Integer.valueOf(position), payload);
            return;
        }
        if (data != null && (a16 = data.a()) != null) {
            AvatarView avatarView = this.avatarImageView;
            Button button = null;
            if (avatarView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avatarImageView");
                avatarView = null;
            }
            String id5 = a16.f449449a;
            Intrinsics.checkNotNullExpressionValue(id5, "id");
            AvatarView.i(avatarView, id5, false, 2, null);
            TextView textView = this.userNameTv;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userNameTv");
                textView = null;
            }
            textView.setText(a16.f449450b);
            TextView textView2 = this.sender;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("sender");
                textView2 = null;
            }
            nc1.a t16 = t();
            if (t16 != null) {
                str = t16.D5();
            } else {
                str = null;
            }
            if (Intrinsics.areEqual(str, a16.f449449a)) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView2.setVisibility(i3);
            x(a16);
            if (a16.f449455g == 0) {
                Button button2 = this.addFriend;
                if (button2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(QQFriendJsPlugin.API_ADD_FRIEND);
                    button2 = null;
                }
                button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.member.section.a
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        FlockMemberItemSection.v(FlockMemberItemSection.this, a16, view);
                    }
                });
                Button button3 = this.addFriend;
                if (button3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(QQFriendJsPlugin.API_ADD_FRIEND);
                    button3 = null;
                }
                button3.setVisibility(0);
            } else {
                Button button4 = this.addFriend;
                if (button4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(QQFriendJsPlugin.API_ADD_FRIEND);
                    button4 = null;
                }
                button4.setVisibility(8);
            }
            View view = this.layoutView;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutView");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.flock.member.section.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    FlockMemberItemSection.w(FlockMemberItemSection.this, a16, view2);
                }
            });
            View view2 = this.layoutView;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutView");
                view2 = null;
            }
            VideoReport.setElementId(view2, "em_bas_participant_entry");
            View view3 = this.layoutView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("layoutView");
                view3 = null;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("nickname", a16.f449450b);
            nc1.a t17 = t();
            if (t17 != null) {
                str2 = t17.D5();
            } else {
                str2 = null;
            }
            hashMap.put("is_sponsor_label", String.valueOf(Intrinsics.areEqual(str2, a16.f449449a) ? 1 : 0));
            VideoReport.setElementParams(view3, hashMap);
            Button button5 = this.addFriend;
            if (button5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException(QQFriendJsPlugin.API_ADD_FRIEND);
            } else {
                button = button5;
            }
            VideoReport.setElementId(button, "em_bas_add_friend_button");
        }
    }
}
