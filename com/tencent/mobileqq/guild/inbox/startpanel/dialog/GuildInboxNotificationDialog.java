package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vp1.cn;

/* compiled from: P */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 92\u00020\u0001:\u0001:B\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001a\u00a2\u0006\u0004\b7\u00108J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u001a\u0010\t\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0007H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J\b\u0010\u000b\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\bH\u0002J&\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\u001fR\u0016\u0010$\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010\u001fR\u0016\u0010&\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010\u001fR\u0016\u0010(\u001a\u00020\u00028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010\u001fR\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u0016\u0010.\u001a\u00020)8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u001e\u00106\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00105\u00a8\u0006;"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxNotificationDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View;", "view", "", "initView", "th", "Lkotlin/Function2;", "", "wh", OcrConfig.CHINESE, "xh", "msgNotifyType", "yh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "", BdhLogUtil.LogTag.Tag_Conn, "Z", "discoveryTab", "D", "Landroid/view/View;", "mNotifyOnlyAtBtn", "E", "mNotifyOpenBtn", UserInfo.SEX_FEMALE, "mNotifyCloseBtn", "G", "mNotifyOpenFlagView", "H", "mNotifyCloseFlagView", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mNotificationImageView", "J", "mLockmNotificationImageView", "Lvp1/cn;", "K", "Lvp1/cn;", "binding", "Lkotlin/Function0;", "L", "Lkotlin/jvm/functions/Function0;", "onDialogDismissCallback", "<init>", "(Z)V", "M", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInboxNotificationDialog extends BottomSheetDialogFragment {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean discoveryTab;

    /* renamed from: D, reason: from kotlin metadata */
    private View mNotifyOnlyAtBtn;

    /* renamed from: E, reason: from kotlin metadata */
    private View mNotifyOpenBtn;

    /* renamed from: F, reason: from kotlin metadata */
    private View mNotifyCloseBtn;

    /* renamed from: G, reason: from kotlin metadata */
    private View mNotifyOpenFlagView;

    /* renamed from: H, reason: from kotlin metadata */
    private View mNotifyCloseFlagView;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mNotificationImageView;

    /* renamed from: J, reason: from kotlin metadata */
    private ImageView mLockmNotificationImageView;

    /* renamed from: K, reason: from kotlin metadata */
    private cn binding;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> onDialogDismissCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eJ*\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0007R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxNotificationDialog$a;", "", "", "discoveryTab", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lkotlin/Function0;", "", "block", "a", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.inbox.startpanel.dialog.GuildInboxNotificationDialog$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(boolean discoveryTab, @Nullable FragmentActivity activity, @NotNull Function0<Unit> block) {
            Intrinsics.checkNotNullParameter(block, "block");
            if (activity == null) {
                return;
            }
            GuildInboxNotificationDialog guildInboxNotificationDialog = new GuildInboxNotificationDialog(discoveryTab);
            guildInboxNotificationDialog.onDialogDismissCallback = block;
            guildInboxNotificationDialog.show(activity.getSupportFragmentManager(), "Guild.C2C.GuildInboxNotificationDialog");
        }

        Companion() {
        }
    }

    public GuildInboxNotificationDialog() {
        this(false, 1, null);
    }

    private final void initView(View view) {
        View findViewById = view.findViewById(R.id.f165587wt2);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.guild_notification_image)");
        this.mNotificationImageView = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.f165568wp3);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.g\u2026_lock_notification_image)");
        this.mLockmNotificationImageView = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(R.id.zuv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.notify_only_at_btn)");
        this.mNotifyOnlyAtBtn = findViewById3;
        View findViewById4 = view.findViewById(R.id.zuh);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.notify_close_btn)");
        this.mNotifyCloseBtn = findViewById4;
        View findViewById5 = view.findViewById(R.id.zux);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.notify_open_btn)");
        this.mNotifyOpenBtn = findViewById5;
        View findViewById6 = view.findViewById(R.id.zui);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.notify_close_btn_iv)");
        this.mNotifyCloseFlagView = findViewById6;
        View findViewById7 = view.findViewById(R.id.zuy);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "view.findViewById(R.id.notify_open_btn_iv)");
        this.mNotifyOpenFlagView = findViewById7;
        View view2 = this.mNotifyOnlyAtBtn;
        cn cnVar = null;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyOnlyAtBtn");
            view2 = null;
        }
        view2.setVisibility(8);
        cn cnVar2 = this.binding;
        if (cnVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            cnVar = cnVar2;
        }
        cnVar.f442748k.setText(R.string.f140820f0);
    }

    private final void th() {
        final Function2<Integer, View, Unit> wh5 = wh();
        View view = this.mNotifyOpenBtn;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyOpenBtn");
            view = null;
        }
        view.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                GuildInboxNotificationDialog.uh(GuildInboxNotificationDialog.this, wh5, view3);
            }
        });
        View view3 = this.mNotifyCloseBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyCloseBtn");
        } else {
            view2 = view3;
        }
        view2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view4) {
                GuildInboxNotificationDialog.vh(GuildInboxNotificationDialog.this, wh5, view4);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(GuildInboxNotificationDialog this$0, Function2 clickListener, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            clickListener.invoke(1, it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(GuildInboxNotificationDialog this$0, Function2 clickListener, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(clickListener, "$clickListener");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            clickListener.invoke(2, it);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    private final Function2<Integer, View, Unit> wh() {
        return new Function2<Integer, View, Unit>() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.GuildInboxNotificationDialog$createClickListener$1

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxNotificationDialog$createClickListener$1$a", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lri1/a;", "error", "result", "", "b", "(Lri1/a;Ljava/lang/Boolean;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes13.dex */
            public static final class a implements com.tencent.mobileqq.guild.base.repository.h<Boolean> {

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ GuildInboxNotificationDialog f226250a;

                a(GuildInboxNotificationDialog guildInboxNotificationDialog) {
                    this.f226250a = guildInboxNotificationDialog;
                }

                @Override // com.tencent.mobileqq.guild.base.repository.h
                /* renamed from: b, reason: merged with bridge method [inline-methods] */
                public void a(@NotNull ri1.a error, @Nullable Boolean result) {
                    Intrinsics.checkNotNullParameter(error, "error");
                    if (!Intrinsics.areEqual(result, Boolean.TRUE)) {
                        this.f226250a.yh(wp1.c.o());
                        SecurityTipHelperKt.N((IGProSecurityResult) error.f431479c, this.f226250a.getContext(), error.f431477a, error.f431478b, false, null, 48, null);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view) {
                invoke(num.intValue(), view);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull View v3) {
                Intrinsics.checkNotNullParameter(v3, "v");
                wp1.c.s(i3, new a(GuildInboxNotificationDialog.this));
                GuildInboxNotificationDialog.this.yh(i3);
                VideoReport.reportEvent("clck", v3, null);
            }
        };
    }

    private final void xh() {
        if (this.discoveryTab) {
            VideoReport.setPageId(getView(), "pg_sgrp_mvp_private_list");
        } else {
            VideoReport.setPageId(getView(), "pg_sgrp_mine");
        }
        VideoReport.setPageReportPolicy(getView(), PageReportPolicy.REPORT_NONE);
        View view = this.mNotifyOpenBtn;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyOpenBtn");
            view = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        ch.Y0(view, "em_sgrp_private_push_on", clickPolicy, exposurePolicy);
        View view3 = this.mNotifyCloseBtn;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyCloseBtn");
        } else {
            view2 = view3;
        }
        ch.Y0(view2, "em_sgrp_private_push_off", clickPolicy, exposurePolicy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void yh(int msgNotifyType) {
        View view = this.mNotifyCloseFlagView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyCloseFlagView");
            view = null;
        }
        view.setVisibility(8);
        View view3 = this.mNotifyOpenFlagView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyOpenFlagView");
            view3 = null;
        }
        view3.setVisibility(8);
        if (msgNotifyType != 1) {
            if (msgNotifyType == 2) {
                View view4 = this.mNotifyCloseFlagView;
                if (view4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNotifyCloseFlagView");
                } else {
                    view2 = view4;
                }
                view2.setVisibility(0);
                return;
            }
            return;
        }
        View view5 = this.mNotifyOpenFlagView;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifyOpenFlagView");
        } else {
            view2 = view5;
        }
        view2.setVisibility(0);
    }

    private final void zh() {
        ImageView imageView = null;
        if (QQTheme.isNowThemeIsNight()) {
            ImageView imageView2 = this.mNotificationImageView;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNotificationImageView");
                imageView2 = null;
            }
            imageView2.setBackgroundResource(R.drawable.guild_notification_drawable_night);
            ImageView imageView3 = this.mLockmNotificationImageView;
            if (imageView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLockmNotificationImageView");
            } else {
                imageView = imageView3;
            }
            imageView.setBackgroundResource(R.drawable.guild_lock_notification_drawable_night);
            return;
        }
        ImageView imageView4 = this.mNotificationImageView;
        if (imageView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotificationImageView");
            imageView4 = null;
        }
        imageView4.setBackgroundResource(R.drawable.guild_notification_drawable);
        ImageView imageView5 = this.mLockmNotificationImageView;
        if (imageView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLockmNotificationImageView");
        } else {
            imageView = imageView5;
        }
        imageView.setBackgroundResource(R.drawable.guild_lock_notification_drawable);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        super.onCreateView(inflater, container, savedInstanceState);
        cn g16 = cn.g(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(inflater, container, false)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        LinearLayout root = g16.getRoot();
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, root);
        return root;
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(@NotNull DialogInterface dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        super.onDismiss(dialog);
        Function0<Unit> function0 = this.onDialogDismissCallback;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        ViewParent viewParent;
        super.onResume();
        View view = getView();
        View view2 = null;
        if (view != null) {
            viewParent = view.getParent();
        } else {
            viewParent = null;
        }
        if (viewParent instanceof View) {
            view2 = (View) viewParent;
        }
        if (view2 != null) {
            view2.setBackgroundColor(0);
        }
        yh(wp1.c.o());
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        initView(view);
        zh();
        th();
        xh();
        super.onViewCreated(view, savedInstanceState);
    }

    public GuildInboxNotificationDialog(boolean z16) {
        this.discoveryTab = z16;
    }

    public /* synthetic */ GuildInboxNotificationDialog(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
