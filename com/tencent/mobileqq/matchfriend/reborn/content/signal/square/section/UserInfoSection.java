package com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.matchfriend.reborn.content.signal.utils.ModelExtKt;
import com.tencent.mobileqq.matchfriend.reborn.widget.QQKLAvatarView;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.aio.utils.l;
import com.tencent.trpcprotocol.kuolie.signal_plaza_svr.signal_plaza_svr.SignalPlazaSvrPB$SignalInfo;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b'\u0010(J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013H\u0014R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u001b\u0010&\u001a\u00020!8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/signal/square/section/UserInfoSection;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/trpcprotocol/kuolie/signal_plaza_svr/signal_plaza_svr/SignalPlazaSvrPB$SignalInfo;", "data", "", "t", ReportConstant.COSTREPORT_PREFIX, "", "v", "u", "r", "p", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "onInitView", "", "position", "", "", "payload", "w", "Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQKLAvatarView;", "d", "Lcom/tencent/mobileqq/matchfriend/reborn/widget/QQKLAvatarView;", "signalUserAvatar", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "signalUserName", "f", "signalUserState", "", h.F, "Lkotlin/Lazy;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "myConstellation", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class UserInfoSection extends Section<SignalPlazaSvrPB$SignalInfo> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private QQKLAvatarView signalUserAvatar;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private TextView signalUserName;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private TextView signalUserState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final Lazy myConstellation;

    public UserInfoSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.signal.square.section.UserInfoSection$myConstellation$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PBStringField pBStringField;
                Object a16 = com.tencent.mobileqq.matchfriend.reborn.utils.d.f245469a.a("loginUserInfoKey");
                String str = null;
                userInfo$MiniInfo userinfo_miniinfo = a16 instanceof userInfo$MiniInfo ? (userInfo$MiniInfo) a16 : null;
                if (userinfo_miniinfo != null && (pBStringField = userinfo_miniinfo.constellation) != null) {
                    str = pBStringField.get();
                }
                return str == null ? "" : str;
            }
        });
        this.myConstellation = lazy;
    }

    private final void p() {
        TextView textView = this.signalUserName;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserName");
            textView = null;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        layoutParams.startToEnd = R.id.opp;
        layoutParams.endToStart = R.id.opq;
        layoutParams.topToTop = 0;
        layoutParams.bottomToTop = R.id.opv;
        layoutParams.setMarginStart(l.b(4));
        layoutParams.setMarginEnd(l.b(4));
        textView.setLayoutParams(layoutParams);
    }

    private final String q() {
        return (String) this.myConstellation.getValue();
    }

    private final void r() {
        TextView textView = this.signalUserState;
        View view = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserState");
            textView = null;
        }
        textView.setVisibility(8);
        TextView textView2 = this.signalUserName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserName");
        } else {
            view = textView2;
        }
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(0, -2);
        layoutParams.startToEnd = R.id.opp;
        layoutParams.endToStart = R.id.opq;
        layoutParams.topToTop = 0;
        layoutParams.bottomToBottom = 0;
        layoutParams.setMarginStart(l.b(4));
        layoutParams.setMarginEnd(l.b(4));
        view.setLayoutParams(layoutParams);
    }

    private final void s(SignalPlazaSvrPB$SignalInfo data) {
        p();
        TextView textView = this.signalUserState;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserState");
            textView = null;
        }
        textView.setText("\u5728\u7ebf");
        textView.setCompoundDrawablesRelativeWithIntrinsicBounds(textView.getContext().getDrawable(R.drawable.g4p), (Drawable) null, (Drawable) null, (Drawable) null);
        textView.setCompoundDrawablePadding(LayoutAttrsKt.getDp(2));
    }

    private final void t(SignalPlazaSvrPB$SignalInfo data) {
        if (ModelExtKt.s(data)) {
            s(data);
        } else if (v(data)) {
            u(data);
        } else {
            r();
        }
    }

    private final void u(SignalPlazaSvrPB$SignalInfo data) {
        List take;
        List<String> o16 = ModelExtKt.o(data, q());
        if (o16.isEmpty()) {
            r();
            return;
        }
        p();
        TextView textView = this.signalUserState;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserState");
            textView = null;
        }
        StringBuilder sb5 = new StringBuilder();
        take = CollectionsKt___CollectionsKt.take(o16, 2);
        Iterator it = take.iterator();
        while (it.hasNext()) {
            sb5.append(((String) it.next()) + "\u00b7");
        }
        if (sb5.length() > 0) {
            sb5.deleteCharAt(sb5.length() - 1);
        }
        textView.setText(sb5.toString());
        TextView textView3 = this.signalUserState;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserState");
            textView3 = null;
        }
        textView3.setCompoundDrawables(null, null, null, null);
        TextView textView4 = this.signalUserState;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserState");
        } else {
            textView2 = textView4;
        }
        textView2.setCompoundDrawablePadding(LayoutAttrsKt.getDp(0));
    }

    private final boolean v(SignalPlazaSvrPB$SignalInfo data) {
        if (!data.same_tags.isEmpty() || !data.my_ark_tags.isEmpty()) {
            return true;
        }
        String str = data.constellation.get();
        Intrinsics.checkNotNullExpressionValue(str, "data.constellation.get()");
        return str.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.opp);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026anger_square_item_avatar)");
        this.signalUserAvatar = (QQKLAvatarView) findViewById;
        View findViewById2 = containerView.findViewById(R.id.opt);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy\u2026tranger_square_item_name)");
        this.signalUserName = (TextView) findViewById2;
        View findViewById3 = containerView.findViewById(R.id.opv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy\u2026uare_item_state_and_tags)");
        this.signalUserState = (TextView) findViewById3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void onBindData(SignalPlazaSvrPB$SignalInfo data, int position, List<Object> payload) {
        Intrinsics.checkNotNullParameter(data, "data");
        QQKLAvatarView qQKLAvatarView = this.signalUserAvatar;
        TextView textView = null;
        if (qQKLAvatarView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserAvatar");
            qQKLAvatarView = null;
        }
        qQKLAvatarView.c(data.avatar.get(), null);
        TextView textView2 = this.signalUserName;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("signalUserName");
        } else {
            textView = textView2;
        }
        textView.setText(data.nick.get());
        t(data);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public int[] getViewStubLayoutId() {
        return new int[0];
    }
}
