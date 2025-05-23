package com.tencent.mobileqq.guild.feed.channeltop;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.qui.quibutton.QUIButton;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.guild.base.GuildBaseBottomSheetFragment;
import com.tencent.mobileqq.guild.base.GuildTransBottomSheetDialogFragment;
import com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopOperator;
import com.tencent.mobileqq.guild.feed.util.l;
import com.tencent.mobileqq.guild.util.qqui.g;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.qqnt.kernel.api.o;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopChannelFeedReq;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProTopChannelFeedRsp;
import com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0003H\u0002J\b\u0010\b\u001a\u00020\u0003H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH\u0002J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J$\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u001a\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010,\u001a\u00020'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010)R\u0016\u0010/\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010.R\u0016\u00101\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b0\u0010.R\u0016\u00103\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010+R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020-8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u0010.R\u001e\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010:8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopFragment;", "Lcom/tencent/mobileqq/guild/base/GuildBaseBottomSheetFragment;", "Landroid/view/View$OnClickListener;", "", "wh", "", "getContentLayoutId", "vh", OcrConfig.CHINESE, "Landroid/view/View;", "view", "yh", "xh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "onCreateView", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "v", NodeProps.ON_CLICK, "D", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Landroid/widget/ImageView;", "E", "Landroid/widget/ImageView;", "closeIv", "Landroid/widget/TextView;", UserInfo.SEX_FEMALE, "Landroid/widget/TextView;", "contentTv", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "G", "Lcom/tencent/biz/qui/quibutton/QUIButton;", "setTimeBtn", "", "H", "Ljava/lang/String;", "feedId", "I", "sectionName", "", "J", "guildId", "K", "channelId", "L", "panelPageSource", "Ltn1/c;", "M", "Ltn1/c;", "timePickerHelper", "N", "confirmTime", "Lkotlin/Function0;", "P", "Lkotlin/jvm/functions/Function0;", "dismissEndCallback", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedChannelTopFragment extends GuildBaseBottomSheetFragment implements View.OnClickListener {

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: D, reason: from kotlin metadata */
    private View rootView;

    /* renamed from: E, reason: from kotlin metadata */
    private ImageView closeIv;

    /* renamed from: F, reason: from kotlin metadata */
    private TextView contentTv;

    /* renamed from: G, reason: from kotlin metadata */
    private QUIButton setTimeBtn;

    /* renamed from: J, reason: from kotlin metadata */
    private long guildId;

    /* renamed from: K, reason: from kotlin metadata */
    private long channelId;

    /* renamed from: L, reason: from kotlin metadata */
    private int panelPageSource;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private tn1.c timePickerHelper;

    /* renamed from: N, reason: from kotlin metadata */
    private long confirmTime;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String feedId = "";

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String sectionName = "";

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private Function0<Unit> dismissEndCallback = new GuildFeedChannelTopFragment$dismissEndCallback$1(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\bR\u0014\u0010\n\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0014\u0010\f\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\bR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopFragment$a;", "", "Lcom/tencent/mobileqq/guild/feed/channeltop/GuildFeedChannelTopOperator$b;", "param", "", "a", "", "ARGS_CHANNEL_ID", "Ljava/lang/String;", "ARGS_FEED_ID", "ARGS_GUILD_ID", "ARGS_PANEL_PAGE_SOURCE", "ARGS_SECTION_NAME", "TAG", "", "TIME_MILLS_PER_SECOND", "J", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull GuildFeedChannelTopOperator.FeedChannelTopParam param) {
            Intrinsics.checkNotNullParameter(param, "param");
            Intent intent = new Intent();
            intent.putExtra("feed_id", param.getFeedId());
            intent.putExtra("guild_id", param.getGuildId());
            intent.putExtra("channel_id", param.getChannelId());
            intent.putExtra("section_name", param.getSectionName());
            intent.putExtra("panel_page_source", param.getPageSource());
            Context context = QBaseActivity.sTopActivity;
            if (context == null) {
                context = BaseApplication.getContext();
            }
            boolean z16 = context instanceof Activity;
            if (!z16) {
                intent.addFlags(268435456);
            }
            if (z16) {
                GuildTransBottomSheetDialogFragment.INSTANCE.a(context, intent, GuildFeedChannelTopFragment.class, "GuildFeedChannelTopFragment");
                return;
            }
            if (QBaseActivity.sTopActivity != null) {
                GuildTransBottomSheetDialogFragment.Companion companion = GuildTransBottomSheetDialogFragment.INSTANCE;
                QBaseActivity sTopActivity = QBaseActivity.sTopActivity;
                Intrinsics.checkNotNullExpressionValue(sTopActivity, "sTopActivity");
                companion.a(sTopActivity, intent, GuildFeedChannelTopFragment.class, "GuildFeedChannelTopFragment");
                return;
            }
            GuildTransBottomSheetDialogFragment.Companion companion2 = GuildTransBottomSheetDialogFragment.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            companion2.a(context, intent, GuildFeedChannelTopFragment.class, "GuildFeedChannelTopFragment");
        }

        Companion() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ah(final int i3, final String str, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
        QLog.d("GuildFeedChannelTopFragment", 1, "topChannelFeed, result=" + i3 + ", errMsg=" + str + ", rsp=" + gProTopChannelFeedRsp);
        kotlin.Function0.b(100, new Runnable() { // from class: com.tencent.mobileqq.guild.feed.channeltop.b
            @Override // java.lang.Runnable
            public final void run() {
                GuildFeedChannelTopFragment.Bh(i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Bh(int i3, String str) {
        if (i3 == 0) {
            g.f(2, "\u8bbe\u7f6e\u6210\u529f");
        } else {
            g.f(0, str);
        }
    }

    private final int getContentLayoutId() {
        return R.layout.ere;
    }

    private final void vh() {
        long a16 = tn1.c.INSTANCE.a();
        if (this.timePickerHelper == null) {
            WeakReference weakReference = new WeakReference(requireContext());
            String string = getString(R.string.f143710mt);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.guild\u2026cancel_sticky_time_stamp)");
            this.timePickerHelper = new tn1.c(weakReference, string, a16, new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.guild.feed.channeltop.GuildFeedChannelTopFragment$handleClickTimeBtn$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                    invoke(l3.longValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3) {
                    GuildFeedChannelTopFragment.this.confirmTime = j3 / 1000;
                }
            }, this.dismissEndCallback);
        }
        tn1.c cVar = this.timePickerHelper;
        if (cVar != null) {
            cVar.h(a16);
        }
        tn1.c cVar2 = this.timePickerHelper;
        if (cVar2 != null) {
            cVar2.i();
        }
    }

    private final void wh() {
        String str;
        long j3;
        Bundle arguments = getArguments();
        String str2 = null;
        String str3 = "";
        if (arguments != null) {
            str = arguments.getString("feed_id", "");
        } else {
            str = null;
        }
        if (str == null) {
            str = "";
        }
        this.feedId = str;
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("section_name", "");
        }
        if (str2 != null) {
            str3 = str2;
        }
        this.sectionName = str3;
        Bundle arguments3 = getArguments();
        long j16 = 0;
        if (arguments3 != null) {
            j3 = arguments3.getLong("channel_id", 0L);
        } else {
            j3 = 0;
        }
        this.channelId = j3;
        Bundle arguments4 = getArguments();
        if (arguments4 != null) {
            j16 = arguments4.getLong("guild_id", 0L);
        }
        this.guildId = j16;
        Bundle arguments5 = getArguments();
        int i3 = 0;
        if (arguments5 != null) {
            i3 = arguments5.getInt("panel_page_source", 0);
        }
        this.panelPageSource = i3;
    }

    private final void xh(View view) {
        VideoReport.setElementId(view, "em_sgrp_forum_top_time_set");
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_NONE);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_NONE);
    }

    private final void yh(View view) {
        VideoReport.addToDetectionWhitelist(getActivity());
        VideoReport.setPageId(view, "pg_sgrp_forum_top_time_set");
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_channel_id", Long.valueOf(this.guildId));
        hashMap.put("sgrp_sub_channel_id", Long.valueOf(this.channelId));
        hashMap.put(AppConstants.Key.SHARE_PANEL_PAGE_SOURCE, Integer.valueOf(this.panelPageSource));
        hashMap.put("sgrp_feed_id", this.feedId);
        VideoReport.setPageParams(view, new PageParams(hashMap));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zh() {
        o c16 = l.c();
        if (c16 == null) {
            return;
        }
        QLog.d("GuildFeedChannelTopFragment", 1, "topChannelFeed, guildId=" + this.guildId + ", channelId=" + this.channelId + ", feedId=" + this.feedId + ", sceneType=3, cancelTime=" + this.confirmTime);
        GProTopChannelFeedReq gProTopChannelFeedReq = new GProTopChannelFeedReq();
        gProTopChannelFeedReq.guildId = this.guildId;
        gProTopChannelFeedReq.channelId = this.channelId;
        gProTopChannelFeedReq.feedId = this.feedId;
        gProTopChannelFeedReq.sceneType = 3;
        gProTopChannelFeedReq.cancelTime = this.confirmTime;
        gProTopChannelFeedReq.visitFrom = com.tencent.mobileqq.guild.report.b.f();
        gProTopChannelFeedReq.pginSourceName = com.tencent.mobileqq.guild.report.b.c();
        c16.topChannelFeed(gProTopChannelFeedReq, new IGProTopChannelFeedCallback() { // from class: com.tencent.mobileqq.guild.feed.channeltop.a
            @Override // com.tencent.qqnt.kernelgpro.nativeinterface.IGProTopChannelFeedCallback
            public final void onResult(int i3, String str, GProTopChannelFeedRsp gProTopChannelFeedRsp) {
                GuildFeedChannelTopFragment.Ah(i3, str, gProTopChannelFeedRsp);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@Nullable View v3) {
        Integer num;
        EventCollector.getInstance().onViewClickedBefore(v3);
        if (v3 != null) {
            num = Integer.valueOf(v3.getId());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == R.id.aze) {
            dismiss();
        } else if (num != null && num.intValue() == R.id.f83494jp) {
            vh();
            Dialog dialog = getDialog();
            if (dialog != null) {
                dialog.hide();
            }
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.avy);
        wh();
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View inflate = inflater.inflate(getContentLayoutId(), container);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) inflate;
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, viewGroup);
        return viewGroup;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        String str;
        Resources resources;
        Intrinsics.checkNotNullParameter(view, "view");
        yh(view);
        this.rootView = view;
        View findViewById = view.findViewById(R.id.aze);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.close_iv)");
        this.closeIv = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.f83494jp);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.set_cancel_time_btn)");
        this.setTimeBtn = (QUIButton) findViewById2;
        View findViewById3 = view.findViewById(R.id.b_6);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.content_tv)");
        TextView textView = (TextView) findViewById3;
        this.contentTv = textView;
        QUIButton qUIButton = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentTv");
            textView = null;
        }
        Context context = getContext();
        if (context != null && (resources = context.getResources()) != null) {
            str = resources.getString(R.string.f145640s1, this.sectionName);
        } else {
            str = null;
        }
        textView.setText(str);
        ImageView imageView = this.closeIv;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("closeIv");
            imageView = null;
        }
        imageView.setOnClickListener(this);
        QUIButton qUIButton2 = this.setTimeBtn;
        if (qUIButton2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setTimeBtn");
            qUIButton2 = null;
        }
        qUIButton2.setOnClickListener(this);
        QUIButton qUIButton3 = this.setTimeBtn;
        if (qUIButton3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("setTimeBtn");
        } else {
            qUIButton = qUIButton3;
        }
        xh(qUIButton);
    }
}
