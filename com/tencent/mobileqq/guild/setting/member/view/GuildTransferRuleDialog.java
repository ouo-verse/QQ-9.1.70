package com.tencent.mobileqq.guild.setting.member.view;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000  2\u00020\u0001:\u0001!B\u0007\u00a2\u0006\u0004\b\u001e\u0010\u001fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J$\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0016J\u000e\u0010\u0010\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\nR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\n8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001d\u001a\u00020\u00188\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001a\u00a8\u0006\""}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/GuildTransferRuleDialog;", "Landroidx/fragment/app/DialogFragment;", "", "rh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "initData", "onStart", "qh", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "floatingView", "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "title", UserInfo.SEX_FEMALE, "content", "<init>", "()V", "G", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildTransferRuleDialog extends ReportAndroidXDialogFragment {

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView floatingView;

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView title;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView content;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004R\u0014\u0010\t\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\nR\u0014\u0010\f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/GuildTransferRuleDialog$a;", "", "Landroidx/fragment/app/FragmentManager;", "fragManager", "", "title", "content", "", "a", "GUILD_TRANSFER_RULE_CONTENT", "Ljava/lang/String;", "GUILD_TRANSFER_RULE_TITLE", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.setting.member.view.GuildTransferRuleDialog$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull FragmentManager fragManager, @NotNull String title, @NotNull String content) {
            Intrinsics.checkNotNullParameter(fragManager, "fragManager");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(content, "content");
            GuildTransferRuleDialog guildTransferRuleDialog = new GuildTransferRuleDialog();
            Bundle bundle = new Bundle();
            bundle.putString("guild_transfer_rule_title", title);
            bundle.putString("guild_transfer_rule_content", content);
            guildTransferRuleDialog.setArguments(bundle);
            com.tencent.mobileqq.guild.base.extension.d.a(guildTransferRuleDialog, fragManager, "GuildTransferRuleDialogFragment");
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/GuildTransferRuleDialog$b", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", NodeProps.MIN_HEIGHT, "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends com.tencent.mobileqq.widget.qus.e {
        b() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF52508d() {
            View view = LayoutInflater.from(GuildTransferRuleDialog.this.getContext()).inflate(R.layout.f_7, (ViewGroup) null);
            GuildTransferRuleDialog guildTransferRuleDialog = GuildTransferRuleDialog.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            guildTransferRuleDialog.qh(view);
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int minHeight() {
            return ViewUtils.dip2px(100.0f);
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public GuildTransferRuleDialog() {
        setStyle(0, R.style.f173448dl);
    }

    private final void rh() {
        View view = this.rootView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        View findViewById = view.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = (QUSHalfScreenFloatingView) findViewById;
        this.floatingView = qUSHalfScreenFloatingView2;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView2 = null;
        }
        qUSHalfScreenFloatingView2.setIsHeightWrapContent(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.floatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new b());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.floatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.J();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.floatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("floatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView5;
        }
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.setting.member.view.h
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildTransferRuleDialog.sh(GuildTransferRuleDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sh(GuildTransferRuleDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    public final void initData() {
        String str;
        String string;
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString("guild_transfer_rule_title")) == null) {
            str = "";
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("guild_transfer_rule_content")) != null) {
            str2 = string;
        }
        TextView textView = this.title;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("title");
            textView = null;
        }
        textView.setText(str);
        TextView textView3 = this.content;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("content");
        } else {
            textView2 = textView3;
        }
        textView2.setText(str2);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.e3i, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026screen, container, false)");
        this.rootView = inflate;
        rh();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.rootView;
        Window window = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        Object parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
        ((View) parent).setBackgroundColor(0);
        Dialog dialog = getDialog();
        if (dialog != null) {
            window = dialog.getWindow();
        }
        if (window != null) {
            Dialog dialog2 = getDialog();
            Intrinsics.checkNotNull(dialog2);
            Window window2 = dialog2.getWindow();
            Intrinsics.checkNotNull(window2);
            GuildUIUtils.H(window2);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        initData();
    }

    public final void qh(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.f100795tg);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.transfer_rule_title)");
        this.title = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.f100785tf);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.transfer_rule_content)");
        this.content = (TextView) findViewById2;
    }
}
