package com.tencent.mobileqq.troop.teamup.member.adapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.utils.au;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.proavatar.QQProAvatarView;
import com.tencent.mobileqq.proavatar.e;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.TriggerRunnerKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QColorNickTextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010*\u001a\u00020\u0006\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u00a2\u0006\u0004\b+\u0010,J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\tH\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0016\u001a\u00020\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0014\u0010 \u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u001dR\u0014\u0010$\u001a\u00020!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010&\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010\u001dR\u0014\u0010)\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006-"}, d2 = {"Lcom/tencent/mobileqq/troop/teamup/member/adapter/f;", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/h;", "Lcom/tencent/mobileqq/troop/teamup/member/data/c;", "data", "", "u", "Landroid/view/View;", "view", "v", "Lcom/tencent/mobileqq/troop/teamup/member/data/b;", "l", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;", "E", "Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;", "eventHandler", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", UserInfo.SEX_FEMALE, "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "memberCheckBox", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "G", "Lcom/tencent/mobileqq/proavatar/QQProAvatarView;", "memberAvatar", "Lcom/tencent/mobileqq/widget/QColorNickTextView;", "H", "Lcom/tencent/mobileqq/widget/QColorNickTextView;", "memberName", "Landroid/widget/TextView;", "I", "Landroid/widget/TextView;", "memberSignTime", "J", "memberJoinStatus", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "K", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "memberInvite", "L", "memberImageDetail", "M", "Landroid/view/View;", "memberLine", "itemView", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/troop/teamup/member/adapter/a;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class f extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final a eventHandler;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final QUICheckBox memberCheckBox;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final QQProAvatarView memberAvatar;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final QColorNickTextView memberName;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final TextView memberSignTime;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final TextView memberJoinStatus;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final QUIButton memberInvite;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final TextView memberImageDetail;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final View memberLine;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@NotNull final View itemView, @NotNull a eventHandler) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        Intrinsics.checkNotNullParameter(eventHandler, "eventHandler");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) itemView, (Object) eventHandler);
            return;
        }
        this.eventHandler = eventHandler;
        View findViewById = itemView.findViewById(R.id.z1j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.member_check_box)");
        QUICheckBox qUICheckBox = (QUICheckBox) findViewById;
        this.memberCheckBox = qUICheckBox;
        View findViewById2 = itemView.findViewById(R.id.z1x);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.member_icon)");
        this.memberAvatar = (QQProAvatarView) findViewById2;
        View findViewById3 = itemView.findViewById(R.id.eos);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.member_name)");
        this.memberName = (QColorNickTextView) findViewById3;
        View findViewById4 = itemView.findViewById(R.id.f85444oz);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.sign_time)");
        this.memberSignTime = (TextView) findViewById4;
        View findViewById5 = itemView.findViewById(R.id.yae);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "itemView.findViewById(R.id.join_status)");
        this.memberJoinStatus = (TextView) findViewById5;
        View findViewById6 = itemView.findViewById(R.id.xru);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "itemView.findViewById(R.id.invite_troop)");
        QUIButton qUIButton = (QUIButton) findViewById6;
        this.memberInvite = qUIButton;
        View findViewById7 = itemView.findViewById(R.id.xic);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "itemView.findViewById(R.id.image_detail)");
        TextView textView = (TextView) findViewById7;
        this.memberImageDetail = textView;
        View findViewById8 = itemView.findViewById(R.id.dqa);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "itemView.findViewById(R.id.item_line)");
        this.memberLine = findViewById8;
        TriggerRunnerKt.c(itemView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.adapter.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.q(itemView, this, view);
            }
        }, 1, null);
        TriggerRunnerKt.c(qUIButton, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.adapter.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.r(itemView, this, view);
            }
        }, 1, null);
        TriggerRunnerKt.c(textView, 0L, new View.OnClickListener() { // from class: com.tencent.mobileqq.troop.teamup.member.adapter.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                f.s(itemView, this, view);
            }
        }, 1, null);
        qUICheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.troop.teamup.member.adapter.e
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                f.t(itemView, this, compoundButton, z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void q(View itemView, f this$0, View it) {
        com.tencent.mobileqq.troop.teamup.member.data.c cVar;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = itemView.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.teamup.member.data.c) {
            cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) tag;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            if (cVar.n()) {
                this$0.memberCheckBox.setChecked(!r0.isChecked());
                cVar.o(this$0.memberCheckBox.isChecked());
                Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> c16 = this$0.eventHandler.c();
                Intrinsics.checkNotNullExpressionValue(it, "it");
                c16.invoke(it, cVar);
            } else {
                Intrinsics.checkNotNullExpressionValue(it, "it");
                this$0.v(it, cVar);
            }
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(View itemView, f this$0, View it) {
        com.tencent.mobileqq.troop.teamup.member.data.c cVar;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = itemView.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.teamup.member.data.c) {
            cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) tag;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> a16 = this$0.eventHandler.a();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            a16.invoke(it, cVar);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(View itemView, f this$0, View it) {
        com.tencent.mobileqq.troop.teamup.member.data.c cVar;
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = itemView.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.teamup.member.data.c) {
            cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) tag;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> d16 = this$0.eventHandler.d();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            d16.invoke(it, cVar);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void t(View itemView, f this$0, CompoundButton buttonView, boolean z16) {
        com.tencent.mobileqq.troop.teamup.member.data.c cVar;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(buttonView, z16);
        Intrinsics.checkNotNullParameter(itemView, "$itemView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Object tag = itemView.getTag();
        if (tag instanceof com.tencent.mobileqq.troop.teamup.member.data.c) {
            cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) tag;
        } else {
            cVar = null;
        }
        if (cVar != null) {
            cVar.o(z16);
            Function2<View, com.tencent.mobileqq.troop.teamup.member.data.c, Unit> c16 = this$0.eventHandler.c();
            Intrinsics.checkNotNullExpressionValue(buttonView, "buttonView");
            c16.invoke(buttonView, cVar);
        }
        EventCollector.getInstance().onCompoundButtonChecked(buttonView, z16);
    }

    private final void u(com.tencent.mobileqq.troop.teamup.member.data.c data) {
        boolean z16;
        boolean z17;
        String string;
        QUICheckBox qUICheckBox = this.memberCheckBox;
        boolean z18 = true;
        if (data.m() && data.n()) {
            z16 = true;
        } else {
            z16 = false;
        }
        qUICheckBox.setChecked(z16);
        QUICheckBox qUICheckBox2 = this.memberCheckBox;
        Boolean valueOf = Boolean.valueOf(data.n());
        qUICheckBox2.setVisibility(0);
        if (((View) au.a(valueOf, qUICheckBox2)) == null) {
            qUICheckBox2.setVisibility(8);
        }
        QUIButton qUIButton = this.memberInvite;
        if (!data.n() && !data.j()) {
            z17 = false;
        } else {
            z17 = true;
        }
        Boolean valueOf2 = Boolean.valueOf(z17);
        qUIButton.setVisibility(8);
        if (((View) au.a(valueOf2, qUIButton)) == null) {
            qUIButton.setVisibility(0);
        }
        TextView textView = this.memberImageDetail;
        if (!data.g() && !data.n()) {
            z18 = false;
        }
        Boolean valueOf3 = Boolean.valueOf(z18);
        textView.setVisibility(8);
        if (((View) au.a(valueOf3, textView)) == null) {
            textView.setVisibility(0);
        }
        if (data.g()) {
            this.memberJoinStatus.setVisibility(0);
            if (data.k()) {
                this.memberJoinStatus.setText(this.itemView.getResources().getString(R.string.f235777ck));
            } else {
                TextView textView2 = this.memberJoinStatus;
                if (this.memberInvite.getVisibility() == 8) {
                    string = this.itemView.getResources().getString(R.string.f236307e0);
                } else {
                    string = this.itemView.getResources().getString(R.string.f236227ds);
                }
                textView2.setText(string);
            }
        }
        if (data.l()) {
            if (data.k()) {
                this.memberJoinStatus.setVisibility(0);
                this.memberJoinStatus.setText(this.itemView.getResources().getString(R.string.f236237dt));
            } else if (this.memberInvite.getVisibility() == 0) {
                this.memberJoinStatus.setVisibility(0);
                this.memberJoinStatus.setText(this.itemView.getResources().getString(R.string.f236177dn));
            } else {
                this.memberJoinStatus.setVisibility(8);
            }
        }
        TextView textView3 = this.memberJoinStatus;
        Boolean valueOf4 = Boolean.valueOf(data.n());
        textView3.setVisibility(8);
        if (((View) au.a(valueOf4, textView3)) == null) {
            textView3.setVisibility(0);
        }
        View view = this.memberLine;
        Boolean valueOf5 = Boolean.valueOf(data.i());
        view.setVisibility(8);
        if (((View) au.a(valueOf5, view)) == null) {
            view.setVisibility(0);
        }
    }

    private final void v(View view, com.tencent.mobileqq.troop.teamup.member.data.c data) {
        HashMap hashMapOf;
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, view.getContext().getString(R.string.i7y));
        ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openTroopmemberCard(MobileQQ.sMobileQQ.peekAppRuntime(), view.getContext(), String.valueOf(data.b().groupId), String.valueOf(data.f()), 10, 9, bundle);
        com.tencent.mobileqq.troop.teamup.report.a aVar = com.tencent.mobileqq.troop.teamup.report.a.f299203a;
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("touin", Long.valueOf(data.f())));
        h.a.f(aVar, view, "em_group_head", hashMapOf, null, 8, null);
    }

    @Override // com.tencent.mobileqq.troop.teamup.member.adapter.h
    public void l(@NotNull com.tencent.mobileqq.troop.teamup.member.data.b data) {
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (!(data instanceof com.tencent.mobileqq.troop.teamup.member.data.c)) {
            return;
        }
        com.tencent.mobileqq.troop.teamup.member.data.c cVar = (com.tencent.mobileqq.troop.teamup.member.data.c) data;
        this.memberName.setText(cVar.e());
        this.memberSignTime.setText(new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 HH:mm", Locale.getDefault()).format(new Date(cVar.c() * 1000)));
        u(cVar);
        String r16 = this.memberAvatar.r();
        if (this.memberAvatar.q() != null && Intrinsics.areEqual(r16, String.valueOf(cVar.f()))) {
            com.tencent.qqnt.avatar.fetch.c q16 = this.memberAvatar.q();
            if (q16 != null) {
                this.memberAvatar.z(q16, true);
            }
        } else {
            this.memberAvatar.x(1, String.valueOf(cVar.f()), new e.a(0, false, false, false, 0, false, 0, 0, null, false, false, 0, null, null, 0, 32767, null).g(100).a());
        }
        QQProAvatarView qQProAvatarView = this.memberAvatar;
        if (cVar.n()) {
            i3 = ViewUtils.dpToPx(12.0f);
        } else {
            i3 = 0;
        }
        ViewGroup.LayoutParams layoutParams = qQProAvatarView.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        } else {
            marginLayoutParams = null;
        }
        if (marginLayoutParams == null) {
            ViewGroup.LayoutParams layoutParams2 = qQProAvatarView.getLayoutParams();
            int i17 = -2;
            if (layoutParams2 != null) {
                i16 = layoutParams2.width;
            } else {
                i16 = -2;
            }
            ViewGroup.LayoutParams layoutParams3 = qQProAvatarView.getLayoutParams();
            if (layoutParams3 != null) {
                i17 = layoutParams3.height;
            }
            marginLayoutParams = new ViewGroup.MarginLayoutParams(i16, i17);
        }
        if (i3 != marginLayoutParams.leftMargin) {
            marginLayoutParams.leftMargin = i3;
            qQProAvatarView.setLayoutParams(marginLayoutParams);
        }
    }
}
