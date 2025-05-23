package com.tencent.mobileqq.guild.widget.banner;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.api.IGuildAdapterService;
import com.tencent.mobileqq.guild.api.IGuildDTReportApi;
import com.tencent.mobileqq.guild.api.IQQGuildJubaoApi;
import com.tencent.mobileqq.guild.constant.GuildFacadeType;
import com.tencent.mobileqq.guild.data.w;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqlive.tvkplayer.event.TVKEventId;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J&\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u001a\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u000f\u001a\u00020\u0002H\u0016R\u0016\u0010\u0012\u001a\u00020\u000b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/widget/banner/BannerTipOffDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "", "th", "sh", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "Landroid/view/View;", "onCreateView", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/TextView;", "D", "Landroid/widget/TextView;", "tipOffView", "E", "cancelView", "", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "guildId", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "G", "Lcom/tencent/mobileqq/guild/constant/GuildFacadeType;", "facadeType", "<init>", "()V", "H", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class BannerTipOffDialog extends BottomSheetDialogFragment {

    /* renamed from: C, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: D, reason: from kotlin metadata */
    private TextView tipOffView;

    /* renamed from: E, reason: from kotlin metadata */
    private TextView cancelView;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private String guildId = "";

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private GuildFacadeType facadeType = GuildFacadeType.Standalone;

    private final void sh() {
        TextView textView = this.tipOffView;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipOffView");
            textView = null;
        }
        VideoReport.setElementId(textView, "em_sgrp_pop_report_btn");
        TextView textView3 = this.tipOffView;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipOffView");
            textView3 = null;
        }
        ClickPolicy clickPolicy = ClickPolicy.REPORT_NONE;
        VideoReport.setElementClickPolicy(textView3, clickPolicy);
        TextView textView4 = this.tipOffView;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipOffView");
            textView4 = null;
        }
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        VideoReport.setElementExposePolicy(textView4, exposurePolicy);
        TextView textView5 = this.tipOffView;
        if (textView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipOffView");
            textView5 = null;
        }
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_NONE;
        VideoReport.setElementEndExposePolicy(textView5, endExposurePolicy);
        TextView textView6 = this.cancelView;
        if (textView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
            textView6 = null;
        }
        VideoReport.setElementId(textView6, "em_sgrp_pop_cancel_btn");
        TextView textView7 = this.cancelView;
        if (textView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
            textView7 = null;
        }
        VideoReport.setElementClickPolicy(textView7, clickPolicy);
        TextView textView8 = this.cancelView;
        if (textView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
            textView8 = null;
        }
        VideoReport.setElementExposePolicy(textView8, exposurePolicy);
        TextView textView9 = this.cancelView;
        if (textView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
        } else {
            textView2 = textView9;
        }
        VideoReport.setElementEndExposePolicy(textView2, endExposurePolicy);
    }

    private final void th() {
        String str;
        VideoReport.addToDetectionWhitelist(getActivity());
        HashMap hashMap = new HashMap();
        w.a(hashMap);
        if (this.facadeType.isDialogStyle()) {
            str = "pg_sgrp_sole_channel_floated";
        } else {
            str = "pg_sgrp_sole_channel";
        }
        View view = this.rootView;
        View view2 = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        VideoReport.setPageId(view, str);
        IGuildDTReportApi iGuildDTReportApi = (IGuildDTReportApi) QRoute.api(IGuildDTReportApi.class);
        View view3 = this.rootView;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
        } else {
            view2 = view3;
        }
        iGuildDTReportApi.setGuildPageParams(view2, this.guildId, hashMap);
    }

    @Override // androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(R.layout.ego, container);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, inflate);
        return inflate;
    }

    @Override // com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXDialogFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        View view = this.rootView;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException(MosaicConstants$JsProperty.PROP_ROOT_VIEW);
            view = null;
        }
        ViewParent parent = view.getParent();
        Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) parent).setBackgroundColor(0);
        TextView textView = this.tipOffView;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipOffView");
            textView = null;
        }
        VideoReport.reportEvent("imp", textView, null);
        TextView textView2 = this.cancelView;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
            textView2 = null;
        }
        VideoReport.reportEvent("imp", textView2, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        Serializable serializable;
        Intrinsics.checkNotNullParameter(view, "view");
        Bundle arguments = getArguments();
        String str2 = "";
        TextView textView = null;
        if (arguments != null) {
            str = arguments.getString("guildId", "");
        } else {
            str = null;
        }
        if (str != null) {
            str2 = str;
        }
        this.guildId = str2;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            serializable = arguments2.getSerializable("facadeType");
        } else {
            serializable = null;
        }
        GuildFacadeType guildFacadeType = (GuildFacadeType) serializable;
        if (guildFacadeType == null) {
            guildFacadeType = GuildFacadeType.Standalone;
        }
        this.facadeType = guildFacadeType;
        this.rootView = view;
        View findViewById = view.findViewById(R.id.f97665l0);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.tipOff)");
        TextView textView2 = (TextView) findViewById;
        this.tipOffView = textView2;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tipOffView");
            textView2 = null;
        }
        jt1.b.b(textView2, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.widget.banner.BannerTipOffDialog$onViewCreated$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                String str3;
                TextView textView3;
                String str4;
                Intrinsics.checkNotNullParameter(it, "it");
                boolean z16 = true;
                QLog.i("BannerTipOffDialog", 1, "[onReportClicked] start");
                IGuildAdapterService iGuildAdapterService = (IGuildAdapterService) ch.R0(IGuildAdapterService.class);
                str3 = BannerTipOffDialog.this.guildId;
                List<IGProChannelInfo> channelList = iGuildAdapterService.getChannelList(str3, true);
                textView3 = BannerTipOffDialog.this.tipOffView;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tipOffView");
                    textView3 = null;
                }
                VideoReport.reportEvent("clck", textView3, null);
                List<IGProChannelInfo> list = channelList;
                if (list != null && !list.isEmpty()) {
                    z16 = false;
                }
                String channelUin = z16 ? "" : channelList.get(0).getChannelUin();
                IQQGuildJubaoApi iQQGuildJubaoApi = (IQQGuildJubaoApi) QRoute.api(IQQGuildJubaoApi.class);
                FragmentActivity activity = BannerTipOffDialog.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type com.tencent.mobileqq.app.QBaseActivity");
                str4 = BannerTipOffDialog.this.guildId;
                iQQGuildJubaoApi.reportGuild((QBaseActivity) activity, str4, channelUin, TVKEventId.PLAYER_STATE_START_BUFFERING, true);
                BannerTipOffDialog.this.dismiss();
            }
        });
        View findViewById2 = view.findViewById(R.id.cancel);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.cancel)");
        TextView textView3 = (TextView) findViewById2;
        this.cancelView = textView3;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cancelView");
        } else {
            textView = textView3;
        }
        jt1.b.b(textView, new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.widget.banner.BannerTipOffDialog$onViewCreated$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                invoke2(view2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                TextView textView4;
                Intrinsics.checkNotNullParameter(it, "it");
                textView4 = BannerTipOffDialog.this.cancelView;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("cancelView");
                    textView4 = null;
                }
                VideoReport.reportEvent("clck", textView4, null);
                BannerTipOffDialog.this.dismiss();
            }
        });
        th();
        sh();
    }
}
