package com.tencent.mobileqq.guild.media.game.widget;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.media.core.notify.SwitchThemeEvent;
import com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog;
import com.tencent.mobileqq.guild.util.bw;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.dq;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001EB\u0015\u0012\f\u0010A\u001a\b\u0012\u0004\u0012\u00020@0?\u00a2\u0006\u0004\bB\u0010CJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u000bH\u0016R\"\u0010\u0018\u001a\u00020\u000b8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010 \u001a\u00020\u00198\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010(\u001a\u00020!8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00108\u001a\u0002018\u0006@\u0006X\u0086.\u00a2\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0017\u0010>\u001a\u0002098\u0006\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamChooseModeDialog;", "Lcom/tencent/mobileqq/guild/media/game/widget/BaseBottomDialog;", "Landroid/view/View$OnClickListener;", "", "initListener", "Eh", "Fh", "Hh", "Ih", "", "qh", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, UserInfo.SEX_FEMALE, "Landroid/view/View;", "Ch", "()Landroid/view/View;", "Oh", "(Landroid/view/View;)V", "mStartBtn", "Landroidx/recyclerview/widget/RecyclerView;", "G", "Landroidx/recyclerview/widget/RecyclerView;", "yh", "()Landroidx/recyclerview/widget/RecyclerView;", "Kh", "(Landroidx/recyclerview/widget/RecyclerView;)V", "mRecyclerView", "Landroid/widget/LinearLayout;", "H", "Landroid/widget/LinearLayout;", "Ah", "()Landroid/widget/LinearLayout;", "Mh", "(Landroid/widget/LinearLayout;)V", "mRuleCheckLl", "Landroid/widget/CheckBox;", "I", "Landroid/widget/CheckBox;", OcrConfig.CHINESE, "()Landroid/widget/CheckBox;", "Lh", "(Landroid/widget/CheckBox;)V", "mRuleCheckBox", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "Bh", "()Landroid/widget/TextView;", "Nh", "(Landroid/widget/TextView;)V", "mRuleText", "Lys1/b;", "K", "Lys1/b;", "Dh", "()Lys1/b;", "ryViewAdapter", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/qqguildsdk/data/dq;", "gameModes", "<init>", "(Ljava/util/ArrayList;)V", "L", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTeamChooseModeDialog extends BaseBottomDialog implements View.OnClickListener {

    /* renamed from: F, reason: from kotlin metadata */
    public View mStartBtn;

    /* renamed from: G, reason: from kotlin metadata */
    public RecyclerView mRecyclerView;

    /* renamed from: H, reason: from kotlin metadata */
    public LinearLayout mRuleCheckLl;

    /* renamed from: I, reason: from kotlin metadata */
    public CheckBox mRuleCheckBox;

    /* renamed from: J, reason: from kotlin metadata */
    public TextView mRuleText;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final ys1.b ryViewAdapter;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildTeamChooseModeDialog$c", "Lcom/tencent/mobileqq/guild/media/core/notify/o;", "Lcom/tencent/mobileqq/guild/media/core/notify/ar;", "event", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements com.tencent.mobileqq.guild.media.core.notify.o<SwitchThemeEvent> {
        c() {
        }

        @Override // com.tencent.mobileqq.guild.media.core.notify.o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void D0(@NotNull SwitchThemeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            if (event.getNewThemeType() != 2) {
                GuildTeamChooseModeDialog.this.dismissAllowingStateLoss();
            }
        }
    }

    public GuildTeamChooseModeDialog(@NotNull ArrayList<dq> gameModes) {
        Intrinsics.checkNotNullParameter(gameModes, "gameModes");
        this.ryViewAdapter = new ys1.b(gameModes);
    }

    private final void Eh() {
        Hh();
    }

    private final void Fh() {
        if (!Intrinsics.areEqual(bw.P(), "AUTH_PERMANENT")) {
            ph().getBehavior().setState(4);
            GuildTeamAuthDialog guildTeamAuthDialog = new GuildTeamAuthDialog(new b(), 1);
            FragmentManager supportFragmentManager = QBaseActivity.sTopActivity.getSupportFragmentManager();
            Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "sTopActivity.supportFragmentManager");
            com.tencent.mobileqq.guild.base.extension.d.a(guildTeamAuthDialog, supportFragmentManager, "QMGame.GuildTeamChooseModeDialog");
            return;
        }
        if (zh().isChecked()) {
            rh().W1(this.ryViewAdapter.getMGameInfo());
        } else {
            QQToast.makeText(getContext(), "\u8bf7\u52fe\u9009\u534f\u8bae", 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Gh(GuildTeamChooseModeDialog this$0, CompoundButton compoundButton, boolean z16) {
        EventCollector.getInstance().onCompoundButtonCheckedBefore(compoundButton, z16);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            bw.w1("AUTH_PERMANENT");
            this$0.Ch().setEnabled(true);
        } else {
            bw.w1("AUTH_ONLY_ONCE");
            this$0.Ch().setEnabled(false);
        }
        EventCollector.getInstance().onCompoundButtonChecked(compoundButton, z16);
    }

    private final void Hh() {
        ph().getBehavior().setState(4);
        GuildTeamAuthDialog guildTeamAuthDialog = new GuildTeamAuthDialog(new d(), 2);
        FragmentManager supportFragmentManager = QBaseActivity.sTopActivity.getSupportFragmentManager();
        Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "sTopActivity.supportFragmentManager");
        com.tencent.mobileqq.guild.base.extension.d.a(guildTeamAuthDialog, supportFragmentManager, "QMGame.GuildTeamChooseModeDialog");
    }

    private final void Ih() {
        Map mapOf;
        View rootView = getRootView();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_avchannel_gameplay_id", rh().h2()), TuplesKt.to("sgrp_team_state", Integer.valueOf(rh().q2())), TuplesKt.to("sgrp_user_segment", rh().o2()), TuplesKt.to("sgrp_room_users_number", Integer.valueOf(rh().j2())));
        ch.T0(rootView, "em_sgrp_honorofkings_game_model", clickPolicy, exposurePolicy, mapOf);
        ch.X0(Ch(), "em_sgrp_honorofkings_game_ongoing_btn", new IDynamicParams() { // from class: com.tencent.mobileqq.guild.media.game.widget.af
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Jh;
                Jh = GuildTeamChooseModeDialog.Jh(GuildTeamChooseModeDialog.this, str);
                return Jh;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Jh(GuildTeamChooseModeDialog this$0, String str) {
        Map mapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_game_mode", this$0.ryViewAdapter.getMGameInfo().getName()));
        return mapOf;
    }

    private final void initListener() {
        Ch().setOnClickListener(this);
        zh().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.guild.media.game.widget.ag
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                GuildTeamChooseModeDialog.Gh(GuildTeamChooseModeDialog.this, compoundButton, z16);
            }
        });
        Bh().setOnClickListener(this);
        com.tencent.mobileqq.guild.media.core.notify.p d16 = com.tencent.mobileqq.guild.media.core.j.d();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "this.viewLifecycleOwner");
        d16.k0(viewLifecycleOwner, SwitchThemeEvent.class, new c());
    }

    @NotNull
    public final LinearLayout Ah() {
        LinearLayout linearLayout = this.mRuleCheckLl;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRuleCheckLl");
        return null;
    }

    @NotNull
    public final TextView Bh() {
        TextView textView = this.mRuleText;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRuleText");
        return null;
    }

    @NotNull
    public final View Ch() {
        View view = this.mStartBtn;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mStartBtn");
        return null;
    }

    @NotNull
    /* renamed from: Dh, reason: from getter */
    public final ys1.b getRyViewAdapter() {
        return this.ryViewAdapter;
    }

    public final void Kh(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.mRecyclerView = recyclerView;
    }

    public final void Lh(@NotNull CheckBox checkBox) {
        Intrinsics.checkNotNullParameter(checkBox, "<set-?>");
        this.mRuleCheckBox = checkBox;
    }

    public final void Mh(@NotNull LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.mRuleCheckLl = linearLayout;
    }

    public final void Nh(@NotNull TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.mRuleText = textView;
    }

    public final void Oh(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mStartBtn = view;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (Intrinsics.areEqual(v3, Ch())) {
            Fh();
        } else if (Intrinsics.areEqual(v3, Bh())) {
            Eh();
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        View findViewById = getRootView().findViewById(R.id.b7p);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.confirm_btn)");
        Oh(findViewById);
        View findViewById2 = getRootView().findViewById(R.id.wvr);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.guild_recyclerview)");
        Kh((RecyclerView) findViewById2);
        View findViewById3 = getRootView().findViewById(R.id.f787047s);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.id.rule_ll)");
        Mh((LinearLayout) findViewById3);
        View findViewById4 = getRootView().findViewById(R.id.f786347l);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.rule_cb)");
        Lh((CheckBox) findViewById4);
        zh().setChecked(Intrinsics.areEqual(bw.P(), "AUTH_PERMANENT"));
        View findViewById5 = getRootView().findViewById(R.id.f787447w);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "rootView.findViewById(R.id.rule_tv)");
        Nh((TextView) findViewById5);
        if (Intrinsics.areEqual(bw.P(), "AUTH_PERMANENT")) {
            Ah().setVisibility(0);
        }
        this.ryViewAdapter.setHasStableIds(true);
        yh().setAdapter(this.ryViewAdapter);
        initListener();
        Ih();
    }

    @Override // com.tencent.mobileqq.guild.media.game.widget.BaseBottomDialog
    public int qh() {
        return R.layout.esn;
    }

    @NotNull
    public final RecyclerView yh() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRecyclerView");
        return null;
    }

    @NotNull
    public final CheckBox zh() {
        CheckBox checkBox = this.mRuleCheckBox;
        if (checkBox != null) {
            return checkBox;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRuleCheckBox");
        return null;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildTeamChooseModeDialog$b", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;", "", "e", "b", "d", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b implements GuildTeamAuthDialog.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void b() {
            QLog.d("QMGame.GuildTeamChooseModeDialog", 4, "onClickPermanentConfirm");
            GuildTeamChooseModeDialog.this.rh().W1(GuildTeamChooseModeDialog.this.getRyViewAdapter().getMGameInfo());
            GuildTeamChooseModeDialog.this.ph().dismiss();
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void d() {
            QLog.d("QMGame.GuildTeamChooseModeDialog", 4, "onClickCancel");
            GuildTeamChooseModeDialog.this.ph().getBehavior().setState(3);
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void e() {
            QLog.d("QMGame.GuildTeamChooseModeDialog", 4, "onClickOnceConfirm");
            GuildTeamChooseModeDialog.this.rh().W1(GuildTeamChooseModeDialog.this.getRyViewAdapter().getMGameInfo());
            GuildTeamChooseModeDialog.this.ph().dismiss();
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void a() {
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void c() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/media/game/widget/GuildTeamChooseModeDialog$d", "Lcom/tencent/mobileqq/guild/media/game/widget/GuildTeamAuthDialog$b;", "", "e", "b", "d", "c", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements GuildTeamAuthDialog.b {
        d() {
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void a() {
            GuildTeamChooseModeDialog.this.ph().getBehavior().setState(3);
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void b() {
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void c() {
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void d() {
        }

        @Override // com.tencent.mobileqq.guild.media.game.widget.GuildTeamAuthDialog.b
        public void e() {
        }
    }
}
