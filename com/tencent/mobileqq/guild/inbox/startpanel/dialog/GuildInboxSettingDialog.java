package com.tencent.mobileqq.guild.inbox.startpanel.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import com.tencent.widget.Switch;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import oh1.DrawableType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0002=>B\u0011\u0012\b\b\u0002\u0010\"\u001a\u00020\u0019\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u000f\u001a\u00020\u0005H\u0016J&\u0010\u0014\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0016J\u001a\u0010\u001b\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0012\u0010\u001c\u001a\u00020\u00052\b\u0010\u0018\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001dH\u0016R\u0014\u0010\"\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\u00078\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00105\u001a\u0002028\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0016\u00109\u001a\u0002068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxSettingDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/widget/CompoundButton$OnCheckedChangeListener;", "Landroid/view/View$OnClickListener;", "Lwp1/a;", "", "uh", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "th", "wh", "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", "onResume", "onStart", "Landroid/widget/CompoundButton;", "view", "", "isChecked", "onCheckedChanged", NodeProps.ON_CLICK, "", "switchStatus", "X7", BdhLogUtil.LogTag.Tag_Conn, "Z", "discoveryTab", "D", "Landroid/view/View;", "mRootView", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "E", "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "Lcom/tencent/widget/Switch;", UserInfo.SEX_FEMALE, "Lcom/tencent/widget/Switch;", "mDirectMsgSwitch", "Landroid/widget/RelativeLayout;", "G", "Landroid/widget/RelativeLayout;", "mNotifySettingContainer", "Landroid/widget/TextView;", "H", "Landroid/widget/TextView;", "mNotifySettingValue", "Landroid/widget/ImageView;", "I", "Landroid/widget/ImageView;", "mArraw", "<init>", "(Z)V", "J", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildInboxSettingDialog extends ReportAndroidXDialogFragment implements CompoundButton.OnCheckedChangeListener, View.OnClickListener, wp1.a {

    /* renamed from: C, reason: from kotlin metadata */
    private final boolean discoveryTab;

    /* renamed from: D, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: F, reason: from kotlin metadata */
    private Switch mDirectMsgSwitch;

    /* renamed from: G, reason: from kotlin metadata */
    private RelativeLayout mNotifySettingContainer;

    /* renamed from: H, reason: from kotlin metadata */
    private TextView mNotifySettingValue;

    /* renamed from: I, reason: from kotlin metadata */
    private ImageView mArraw;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\bR\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxSettingDialog$b;", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lri1/a;", "error", "result", "", "b", "(Lri1/a;Ljava/lang/Boolean;)V", "Lmqq/util/WeakReference;", "Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxSettingDialog;", "a", "Lmqq/util/WeakReference;", "dialogRef", "dialog", "<init>", "(Lcom/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxSettingDialog;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    private static final class b implements com.tencent.mobileqq.guild.base.repository.h<Boolean> {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<GuildInboxSettingDialog> dialogRef;

        public b(@NotNull GuildInboxSettingDialog dialog) {
            Intrinsics.checkNotNullParameter(dialog, "dialog");
            this.dialogRef = new WeakReference<>(dialog);
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable Boolean result) {
            IGProSecurityResult iGProSecurityResult;
            Intrinsics.checkNotNullParameter(error, "error");
            Logger.f235387a.d().d("Guild.C2C.GuildInboxSettingDialog", 1, "setMsgNotifyStatus " + error + " " + result);
            if (!error.d()) {
                Context i3 = ch.i();
                int i16 = error.f431477a;
                String str = error.f431478b;
                Object obj = error.f431479c;
                Switch r06 = null;
                if (obj instanceof IGProSecurityResult) {
                    iGProSecurityResult = (IGProSecurityResult) obj;
                } else {
                    iGProSecurityResult = null;
                }
                SecurityTipHelperKt.F(i3, i16, str, iGProSecurityResult, null, null, 48, null);
                GuildInboxSettingDialog guildInboxSettingDialog = this.dialogRef.get();
                if (guildInboxSettingDialog != null) {
                    Switch r122 = guildInboxSettingDialog.mDirectMsgSwitch;
                    if (r122 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
                    } else {
                        r06 = r122;
                    }
                    r06.setChecked(!r06.isChecked());
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/inbox/startpanel/dialog/GuildInboxSettingDialog$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends com.tencent.mobileqq.widget.qus.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ QUSHalfScreenFloatingView f226252d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildInboxSettingDialog f226253e;

        c(QUSHalfScreenFloatingView qUSHalfScreenFloatingView, GuildInboxSettingDialog guildInboxSettingDialog) {
            this.f226252d = qUSHalfScreenFloatingView;
            this.f226253e = guildInboxSettingDialog;
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF57419d() {
            View view = LayoutInflater.from(this.f226252d.getContext()).inflate(R.layout.euv, (ViewGroup) null);
            GuildInboxSettingDialog guildInboxSettingDialog = this.f226253e;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            guildInboxSettingDialog.th(view);
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    public GuildInboxSettingDialog() {
        this(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void th(View rootView) {
        View findViewById = rootView.findViewById(R.id.w4j);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.\u2026ld_direct_message_switch)");
        this.mDirectMsgSwitch = (Switch) findViewById;
        View findViewById2 = rootView.findViewById(R.id.wj7);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.\u2026.guild_inbox_notify_type)");
        this.mNotifySettingContainer = (RelativeLayout) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.wj9);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026_inbox_notify_type_value)");
        this.mNotifySettingValue = (TextView) findViewById3;
        View findViewById4 = rootView.findViewById(R.id.wrk);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "rootView.findViewById(R.id.guild_mute_all_arrow)");
        this.mArraw = (ImageView) findViewById4;
        DrawableType drawableType = new DrawableType(R.drawable.guild_right_arrow, Integer.valueOf(R.color.qui_common_icon_secondary));
        ImageView imageView = this.mArraw;
        RelativeLayout relativeLayout = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mArraw");
            imageView = null;
        }
        drawableType.b(imageView);
        RelativeLayout relativeLayout2 = this.mNotifySettingContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifySettingContainer");
            relativeLayout2 = null;
        }
        relativeLayout2.setOnClickListener(this);
        Switch r06 = this.mDirectMsgSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            r06 = null;
        }
        r06.setChecked(wp1.c.p());
        Switch r07 = this.mDirectMsgSwitch;
        if (r07 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            r07 = null;
        }
        r07.setOnCheckedChangeListener(this);
        xh();
        if (this.discoveryTab) {
            VideoReport.setPageId(rootView, "pg_sgrp_mvp_private_list");
        } else {
            VideoReport.setPageId(rootView, "pg_sgrp_mine");
        }
        VideoReport.setPageReportPolicy(rootView, PageReportPolicy.REPORT_NONE);
        Switch r65 = this.mDirectMsgSwitch;
        if (r65 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            r65 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        ch.Y0(r65, "em_sgrp_private_switch", clickPolicy, exposurePolicy);
        RelativeLayout relativeLayout3 = this.mNotifySettingContainer;
        if (relativeLayout3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifySettingContainer");
        } else {
            relativeLayout = relativeLayout3;
        }
        ch.Y0(relativeLayout, "em_sgrp_private_push", clickPolicy, exposurePolicy);
    }

    private final void uh() {
        View view = this.mRootView;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        View findViewById = view.findViewById(R.id.f66733bf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mRootView.findViewById(R\u2026qus_floating_half_screen)");
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = (QUSHalfScreenFloatingView) findViewById;
        this.mFloatingView = qUSHalfScreenFloatingView2;
        if (qUSHalfScreenFloatingView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
        }
        qUSHalfScreenFloatingView.setIsHeightWrapContent(true);
        qUSHalfScreenFloatingView.setQUSDragFloatController(new c(qUSHalfScreenFloatingView, this));
        qUSHalfScreenFloatingView.J();
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.c
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildInboxSettingDialog.vh(GuildInboxSettingDialog.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void vh(GuildInboxSettingDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    private final void wh() {
        GuildInboxNotificationDialog.INSTANCE.a(this.discoveryTab, getActivity(), new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.inbox.startpanel.dialog.GuildInboxSettingDialog$openNotifySetting$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                GuildInboxSettingDialog.this.xh();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xh() {
        int i3;
        if (wp1.c.o() == 1) {
            i3 = R.string.f15045151;
        } else {
            i3 = R.string.f15046152;
        }
        TextView textView = this.mNotifySettingValue;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifySettingValue");
            textView = null;
        }
        textView.setText(i3);
    }

    @Override // wp1.a
    public void X7(int switchStatus) {
        Switch r26 = this.mDirectMsgSwitch;
        if (r26 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            r26 = null;
        }
        r26.setChecked(wp1.c.p());
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(@Nullable CompoundButton view, boolean isChecked) {
        int i3;
        String str;
        EventCollector.getInstance().onCompoundButtonCheckedBefore(view, isChecked);
        Switch r06 = this.mDirectMsgSwitch;
        Switch r16 = null;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            r06 = null;
        }
        if (Intrinsics.areEqual(view, r06)) {
            if (isChecked) {
                i3 = 2;
            } else {
                i3 = 3;
            }
            wp1.c.t(i3, new b(this));
            Switch r07 = this.mDirectMsgSwitch;
            if (r07 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
                r07 = null;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Switch r46 = this.mDirectMsgSwitch;
            if (r46 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            } else {
                r16 = r46;
            }
            if (r16.isChecked()) {
                str = "1";
            } else {
                str = "2";
            }
            linkedHashMap.put("sgrp_switch_type", str);
            Unit unit = Unit.INSTANCE;
            VideoReport.reportEvent("clck", r07, linkedHashMap);
        }
        EventCollector.getInstance().onCompoundButtonChecked(view, isChecked);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View view) {
        String str;
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            RelativeLayout relativeLayout = this.mNotifySettingContainer;
            RelativeLayout relativeLayout2 = null;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mNotifySettingContainer");
                relativeLayout = null;
            }
            if (Intrinsics.areEqual(view, relativeLayout)) {
                wh();
                RelativeLayout relativeLayout3 = this.mNotifySettingContainer;
                if (relativeLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mNotifySettingContainer");
                } else {
                    relativeLayout2 = relativeLayout3;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                if (wp1.c.o() == 1) {
                    str = "1";
                } else {
                    str = "2";
                }
                linkedHashMap.put("sgrp_private_push_mode", str);
                Unit unit = Unit.INSTANCE;
                VideoReport.reportEvent("clck", relativeLayout2, linkedHashMap);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.f173448dl);
        wp1.c.f446014e.g(this);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.e3i, container);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026g_half_screen, container)");
        this.mRootView = inflate;
        uh();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        wp1.c.f446014e.r(this);
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Object obj;
        View view;
        Object obj2;
        super.onResume();
        View view2 = getView();
        RelativeLayout relativeLayout = null;
        if (view2 != null) {
            obj = view2.getParent();
        } else {
            obj = null;
        }
        if (obj instanceof View) {
            view = (View) obj;
        } else {
            view = null;
        }
        if (view != null) {
            view.setBackgroundColor(0);
        }
        Switch r06 = this.mDirectMsgSwitch;
        if (r06 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            r06 = null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Switch r46 = this.mDirectMsgSwitch;
        if (r46 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mDirectMsgSwitch");
            r46 = null;
        }
        boolean isChecked = r46.isChecked();
        String str = "1";
        if (isChecked) {
            obj2 = "1";
        } else {
            obj2 = "2";
        }
        linkedHashMap.put("sgrp_switch_type", obj2);
        Unit unit = Unit.INSTANCE;
        VideoReport.reportEvent("imp", r06, linkedHashMap);
        RelativeLayout relativeLayout2 = this.mNotifySettingContainer;
        if (relativeLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNotifySettingContainer");
        } else {
            relativeLayout = relativeLayout2;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (wp1.c.o() != 1) {
            str = "2";
        }
        linkedHashMap2.put("sgrp_private_push_mode", str);
        VideoReport.reportEvent("imp", relativeLayout, linkedHashMap2);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (getDialog() != null) {
            Dialog dialog = getDialog();
            Intrinsics.checkNotNull(dialog);
            if (dialog.getWindow() != null) {
                Dialog dialog2 = getDialog();
                Intrinsics.checkNotNull(dialog2);
                Window window = dialog2.getWindow();
                Intrinsics.checkNotNull(window);
                GuildUIUtils.H(window);
            }
        }
    }

    public GuildInboxSettingDialog(boolean z16) {
        this.discoveryTab = z16;
    }

    public /* synthetic */ GuildInboxSettingDialog(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
