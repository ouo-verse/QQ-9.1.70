package com.tencent.mobileqq.guild.home.checkin;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.base.extension.d;
import com.tencent.mobileqq.guild.handler.api.impl.QQGuildHandler;
import com.tencent.mobileqq.guild.home.checkin.GuildCheckinDialogFragment;
import com.tencent.mobileqq.guild.home.checkin.view.GuildCheckinDetailView;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.guild.util.o;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildCheckinRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.QUSHalfScreenFloatingView;
import com.tencent.mobileqq.widget.qus.e;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.cz;

/* compiled from: P */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\t\u0018\u0000 <2\u00020\u00012\u00020\u0002:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u000f\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0003H\u0002J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0006H\u0002J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001e\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\u0010\u0010!\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0006H\u0016R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u00068\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010'R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0018\u00109\u001a\u0004\u0018\u0001068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/mobileqq/guild/home/checkin/GuildCheckinDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "", "initData", "yh", "Landroid/view/View;", "contentView", "xh", "com/tencent/mobileqq/guild/home/checkin/GuildCheckinDialogFragment$b", "vh", "()Lcom/tencent/mobileqq/guild/home/checkin/GuildCheckinDialogFragment$b;", "", "result", "", "errMsg", "wh", "Ch", "view", "type", "Ah", "Bh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onStart", "v", NodeProps.ON_CLICK, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/widget/qus/QUSHalfScreenFloatingView;", "mFloatingView", "D", "Landroid/view/View;", "mRootView", "E", "closeIcon", "Lcom/tencent/mobileqq/guild/home/checkin/view/GuildCheckinDetailView;", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/guild/home/checkin/view/GuildCheckinDetailView;", "checkinDetailView", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "G", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "openCalendarButton", "H", "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildCheckinRsp;", "I", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildCheckinRsp;", "checkinInfo", "<init>", "()V", "J", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildCheckinDialogFragment extends ReportAndroidXDialogFragment implements View.OnClickListener {

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: C, reason: from kotlin metadata */
    private QUSHalfScreenFloatingView mFloatingView;

    /* renamed from: D, reason: from kotlin metadata */
    private View mRootView;

    /* renamed from: E, reason: from kotlin metadata */
    private View closeIcon;

    /* renamed from: F, reason: from kotlin metadata */
    private GuildCheckinDetailView checkinDetailView;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIButton openCalendarButton;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private IGProGuildCheckinRsp checkinInfo;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\n8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\fR\u0014\u0010\u000f\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/home/checkin/GuildCheckinDialogFragment$a;", "", "Landroidx/fragment/app/FragmentManager;", "manager", "", "guildId", "Lcom/tencent/mobileqq/qqguildsdk/data/genc/IGProGuildCheckinRsp;", "checkinRsp", "Lcom/tencent/mobileqq/guild/home/checkin/GuildCheckinDialogFragment;", "a", "", "BTN_TYPE_OPEN_ACTIVE", "I", "BTN_TYPE_OPEN_CALENDAR", "BTN_TYPE_OPEN_NOTIFY", "CHECKIN_INFO", "Ljava/lang/String;", "GUILD_CHECKIN_ACTIVE_VALUE", "GUILD_CHECKIN_CALENDAR", "TAG", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.checkin.GuildCheckinDialogFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final GuildCheckinDialogFragment a(@NotNull FragmentManager manager, @NotNull String guildId, @NotNull IGProGuildCheckinRsp checkinRsp) {
            Intrinsics.checkNotNullParameter(manager, "manager");
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(checkinRsp, "checkinRsp");
            GuildCheckinDialogFragment guildCheckinDialogFragment = new GuildCheckinDialogFragment();
            Bundle bundle = new Bundle();
            bundle.putString("extra_guild_id", guildId);
            bundle.putSerializable("CHECKIN_INFO", checkinRsp);
            guildCheckinDialogFragment.setArguments(bundle);
            d.a(guildCheckinDialogFragment, manager, "GuildCheckinDialogFragment");
            return guildCheckinDialogFragment;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/home/checkin/GuildCheckinDialogFragment$b", "Lvo1/b;", "Landroid/view/View;", "view", "", "a", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements vo1.b {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(GuildCheckinDialogFragment this$0, int i3, String errMsg, int i16) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullExpressionValue(errMsg, "errMsg");
            this$0.wh(i3, errMsg);
        }

        @Override // vo1.b
        public void a(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildCheckinDialogFragment.this.Ah(view, 2);
            QQGuildHandler qQGuildHandler = (QQGuildHandler) ch.j(QQGuildHandler.class);
            String str = GuildCheckinDialogFragment.this.guildId;
            final GuildCheckinDialogFragment guildCheckinDialogFragment = GuildCheckinDialogFragment.this;
            qQGuildHandler.Z2(str, 8, 1, new cz() { // from class: to1.b
                @Override // vh2.cz
                public final void a(int i3, String str2, int i16) {
                    GuildCheckinDialogFragment.b.d(GuildCheckinDialogFragment.this, i3, str2, i16);
                }
            });
        }

        @Override // vo1.b
        public void b(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            GuildCheckinDialogFragment.this.Ah(view, 3);
            FragmentActivity activity = GuildCheckinDialogFragment.this.getActivity();
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("https://qun.qq.com/guild/h5/guild-level/index.html#/?guild_id=%s&from=1&user_type=1", Arrays.copyOf(new Object[]{GuildCheckinDialogFragment.this.guildId}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            ch.i1(activity, format);
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = GuildCheckinDialogFragment.this.mFloatingView;
            if (qUSHalfScreenFloatingView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
                qUSHalfScreenFloatingView = null;
            }
            qUSHalfScreenFloatingView.t();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/checkin/GuildCheckinDialogFragment$c", "Lcom/tencent/mobileqq/widget/qus/e;", "Landroid/view/View;", "createContentView", "", "showMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c extends e {
        c() {
        }

        @Override // com.tencent.mobileqq.widget.qus.d
        @Nullable
        /* renamed from: createContentView */
        public View getF52508d() {
            View view = LayoutInflater.from(GuildCheckinDialogFragment.this.getContext()).inflate(R.layout.ej6, (ViewGroup) null);
            GuildCheckinDialogFragment guildCheckinDialogFragment = GuildCheckinDialogFragment.this;
            Intrinsics.checkNotNullExpressionValue(view, "view");
            guildCheckinDialogFragment.xh(view);
            return view;
        }

        @Override // com.tencent.mobileqq.widget.qus.e, com.tencent.mobileqq.widget.qus.d
        public int showMode() {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Ah(View view, int type) {
        Map mapOf;
        VideoReport.setElementId(view, "em_sgrp_btn");
        ch.x(view);
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_btn_type", Integer.valueOf(type)));
        VideoReport.reportEvent("clck", view, mapOf);
    }

    private final void Bh(View view) {
        VideoReport.setElementId(view, "em_sgrp_close_btn");
        ch.x(view);
        VideoReport.reportEvent("clck", view, null);
    }

    private final void Ch() {
        HashMap hashMapOf;
        IGProGuildCheckinRsp iGProGuildCheckinRsp = this.checkinInfo;
        if (iGProGuildCheckinRsp != null) {
            VideoReport.addToDetectionWhitelist(getActivity());
            View view = this.mRootView;
            View view2 = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
                view = null;
            }
            VideoReport.setPageId(view, "pg_sgrp_sign_in_pop");
            hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("sgrp_continual_sign_day", Integer.valueOf(iGProGuildCheckinRsp.getCheckinCnt())));
            IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
            View view3 = this.mRootView;
            if (view3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            } else {
                view2 = view3;
            }
            iGuildDTReportApi.setGuildPageParams(view2, this.guildId, hashMapOf);
        }
    }

    private final void initData() {
        Serializable serializable;
        IGProGuildCheckinRsp iGProGuildCheckinRsp;
        String str;
        Bundle arguments = getArguments();
        GuildCheckinDetailView guildCheckinDetailView = null;
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("CHECKIN_INFO");
        } else {
            serializable = null;
        }
        if (serializable instanceof IGProGuildCheckinRsp) {
            iGProGuildCheckinRsp = (IGProGuildCheckinRsp) serializable;
        } else {
            iGProGuildCheckinRsp = null;
        }
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str = arguments2.getString("extra_guild_id");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.guildId = str;
        if (iGProGuildCheckinRsp == null) {
            Logger.f235387a.d().w("GuildCheckinDialogFragment", 1, "initData: checkinInfo is null, " + getArguments());
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
            if (qUSHalfScreenFloatingView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            } else {
                qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
            }
            qUSHalfScreenFloatingView.t();
            return;
        }
        GuildCheckinDetailView guildCheckinDetailView2 = this.checkinDetailView;
        if (guildCheckinDetailView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkinDetailView");
            guildCheckinDetailView2 = null;
        }
        guildCheckinDetailView2.setAvatar(this.guildId);
        IGProGuildInfo L = ch.L(this.guildId);
        if (L == null) {
            Logger.f235387a.d().w("GuildCheckinDialogFragment", 1, "initData: guildInfo is null");
        }
        boolean z16 = false;
        if (L != null && L.getSignInNotifySwitch() == 0) {
            z16 = true;
        }
        boolean z17 = !z16;
        GuildCheckinDetailView guildCheckinDetailView3 = this.checkinDetailView;
        if (guildCheckinDetailView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkinDetailView");
        } else {
            guildCheckinDetailView = guildCheckinDetailView3;
        }
        guildCheckinDetailView.setCheckinInfo(iGProGuildCheckinRsp, z17);
        this.checkinInfo = iGProGuildCheckinRsp;
    }

    private final b vh() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wh(int result, String errMsg) {
        Logger.f235387a.d().i("GuildCheckinDialogFragment", 1, "openGuildSignInNotify(" + this.guildId + "): " + result + " - " + errMsg + " ");
        if (!isAdded()) {
            return;
        }
        if (result != 0) {
            QQToast.makeText(getContext(), 1, R.string.f142270ix, 0).show();
            return;
        }
        QQToast.makeText(getContext(), 2, "\u5df2\u5f00\u542f\u7b7e\u5230\u63d0\u9192", 0).show();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView = this.mFloatingView;
        if (qUSHalfScreenFloatingView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            qUSHalfScreenFloatingView = null;
        }
        qUSHalfScreenFloatingView.t();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void xh(View contentView) {
        View findViewById = contentView.findViewById(R.id.azb);
        Intrinsics.checkNotNullExpressionValue(findViewById, "contentView.findViewById(R.id.close_icon)");
        this.closeIcon = findViewById;
        View findViewById2 = contentView.findViewById(R.id.f164795tw1);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "contentView.findViewById(R.id.checkin_detail_view)");
        this.checkinDetailView = (GuildCheckinDetailView) findViewById2;
        View findViewById3 = contentView.findViewById(R.id.zyn);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "contentView.findViewById\u2026.id.open_calendar_button)");
        this.openCalendarButton = (QUIButton) findViewById3;
        GuildCheckinDetailView guildCheckinDetailView = this.checkinDetailView;
        QUIButton qUIButton = null;
        if (guildCheckinDetailView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkinDetailView");
            guildCheckinDetailView = null;
        }
        guildCheckinDetailView.setCheckinCallback(vh());
        View view = this.closeIcon;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIcon");
            view = null;
        }
        view.setOnClickListener(this);
        QUIButton qUIButton2 = this.openCalendarButton;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("openCalendarButton");
        } else {
            qUIButton = qUIButton2;
        }
        qUIButton.setOnClickListener(this);
    }

    private final void yh() {
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
            qUSHalfScreenFloatingView2 = null;
        }
        qUSHalfScreenFloatingView2.setIsHeightWrapContent(true);
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mFloatingView;
        if (qUSHalfScreenFloatingView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            qUSHalfScreenFloatingView3 = null;
        }
        qUSHalfScreenFloatingView3.setQUSDragFloatController(new c());
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView4 = this.mFloatingView;
        if (qUSHalfScreenFloatingView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
            qUSHalfScreenFloatingView4 = null;
        }
        qUSHalfScreenFloatingView4.J();
        QUSHalfScreenFloatingView qUSHalfScreenFloatingView5 = this.mFloatingView;
        if (qUSHalfScreenFloatingView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
        } else {
            qUSHalfScreenFloatingView = qUSHalfScreenFloatingView5;
        }
        qUSHalfScreenFloatingView.setOnDismissListener(new QUSBaseHalfScreenFloatingView.l() { // from class: to1.a
            @Override // com.tencent.mobileqq.widget.qus.QUSBaseHalfScreenFloatingView.l
            public final void onDismiss() {
                GuildCheckinDialogFragment.zh(GuildCheckinDialogFragment.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void zh(GuildCheckinDialogFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.dismissAllowingStateLoss();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (!o.a(v3)) {
            View view = this.closeIcon;
            QUSHalfScreenFloatingView qUSHalfScreenFloatingView = null;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("closeIcon");
                view = null;
            }
            if (v3 == view) {
                Bh(v3);
                QUSHalfScreenFloatingView qUSHalfScreenFloatingView2 = this.mFloatingView;
                if (qUSHalfScreenFloatingView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
                } else {
                    qUSHalfScreenFloatingView = qUSHalfScreenFloatingView2;
                }
                qUSHalfScreenFloatingView.t();
            } else {
                QUIButton qUIButton = this.openCalendarButton;
                if (qUIButton == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("openCalendarButton");
                    qUIButton = null;
                }
                if (v3 == qUIButton) {
                    Ah(v3, 1);
                    FragmentActivity activity = getActivity();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("https://qun.qq.com/guild/h5/guild-member-sign/index.html#/?guildId=%s", Arrays.copyOf(new Object[]{this.guildId}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                    ch.i1(activity, format);
                    QUSHalfScreenFloatingView qUSHalfScreenFloatingView3 = this.mFloatingView;
                    if (qUSHalfScreenFloatingView3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFloatingView");
                    } else {
                        qUSHalfScreenFloatingView = qUSHalfScreenFloatingView3;
                    }
                    qUSHalfScreenFloatingView.t();
                }
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.f173448dl);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.e3i, container, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(com.ten\u2026screen, container, false)");
        this.mRootView = inflate;
        yh();
        View view = this.mRootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
            view = null;
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, view);
        return view;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        View view = this.mRootView;
        Window window = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mRootView");
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
        Ch();
    }
}
