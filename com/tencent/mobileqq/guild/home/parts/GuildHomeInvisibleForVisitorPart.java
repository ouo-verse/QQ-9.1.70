package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Space;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.guild.api.IGuildEmotionCodecApi;
import com.tencent.mobileqq.guild.home.subhome.g;
import com.tencent.mobileqq.guild.home.viewmodels.header.GuildHomeCoverColors;
import com.tencent.mobileqq.guild.home.views.GuildHomeCoverBelowList;
import com.tencent.mobileqq.guild.home.views.header.GuildHomeGuildInfoLayout;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.widget.CharacterCountEditText;
import com.tencent.mobileqq.guild.widget.RadiusFrameLayout;
import com.tencent.mobileqq.guild.widget.ShadowFrameLayout;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProGuildInfo;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProGuildEssenceSvrRsp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import wh2.dh;

@Metadata(d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u0000 U2\u00020\u0001:\u0001VB\u0007\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0002J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u0012\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016J\u001c\u0010\u001a\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\u0012\u0010\u001b\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u0006\u0010\u001c\u001a\u00020\u0002R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00108\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010;\u001a\u0002088\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0016\u0010C\u001a\u00020@8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bA\u0010BR\u0016\u0010G\u001a\u00020D8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\bE\u0010FR\"\u0010O\u001a\u00020H8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010R\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bP\u0010Q\u00a8\u0006W"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeInvisibleForVisitorPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "", "initData", "ta", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "qa", "la", "wa", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProGuildInfo;", "guildInfo", "ia", "", "msgLeave", "guildName", "ua", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/content/res/Configuration;", "configuration", "onConfigurationChanged", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "ha", "Landroid/view/ViewStub;", "e", "Landroid/view/ViewStub;", "linearLayout", "f", "Landroid/view/View;", TtmlNode.TAG_LAYOUT, "Landroid/widget/Button;", tl.h.F, "Landroid/widget/Button;", "joinBtn", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "i", "Lcom/tencent/mobileqq/guild/widget/CharacterCountEditText;", "msgTv", "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/widget/ShadowFrameLayout;", "msgCardBg", "Lcom/tencent/mobileqq/guild/home/views/header/GuildHomeGuildInfoLayout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/home/views/header/GuildHomeGuildInfoLayout;", "guildInfoHead", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "D", "Lcom/tencent/mobileqq/guild/home/views/GuildHomeCoverBelowList;", "coverBelow", "Landroid/widget/Space;", "E", "Landroid/widget/Space;", "windowAnchor", "Landroid/widget/LinearLayout;", UserInfo.SEX_FEMALE, "Landroid/widget/LinearLayout;", "visitorLayout", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "G", "Lcom/tencent/mobileqq/guild/widget/RadiusFrameLayout;", "msgRfy", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "H", "Lcom/tencent/mobileqq/guild/report/IPerformanceReportTask;", "guildVisitorReportTask", "", "I", "Z", "pa", "()Z", "setInflated", "(Z)V", "isInflated", "J", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "onStateUpdate", "<init>", "()V", "K", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeInvisibleForVisitorPart extends a {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildHomeGuildInfoLayout guildInfoHead;

    /* renamed from: D, reason: from kotlin metadata */
    private GuildHomeCoverBelowList coverBelow;

    /* renamed from: E, reason: from kotlin metadata */
    private Space windowAnchor;

    /* renamed from: F, reason: from kotlin metadata */
    private LinearLayout visitorLayout;

    /* renamed from: G, reason: from kotlin metadata */
    private RadiusFrameLayout msgRfy;

    /* renamed from: H, reason: from kotlin metadata */
    private IPerformanceReportTask guildVisitorReportTask;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean isInflated;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.g onStateUpdate = qa();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ViewStub linearLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private View layout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Button joinBtn;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private CharacterCountEditText msgTv;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ShadowFrameLayout msgCardBg;

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildHomeInvisibleForVisitorPart$b", "Lcom/tencent/mobileqq/guild/home/subhome/g;", "Lbp1/a;", "state", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements com.tencent.mobileqq.guild.home.subhome.g {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f224947b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ GuildHomeInvisibleForVisitorPart f224948c;

        public b(String str, GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart) {
            this.f224947b = str;
            this.f224948c = guildHomeInvisibleForVisitorPart;
        }

        @Override // com.tencent.mobileqq.guild.home.subhome.g
        public void a(@NotNull bp1.a state) {
            Intrinsics.checkNotNullParameter(state, "state");
            if (state.getOffset() >= 0.0f && this.f224948c.layout != null) {
                View view = this.f224948c.layout;
                if (view == null) {
                    Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                    view = null;
                }
                view.setTranslationY(state.getOffset());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ia(final IGProGuildInfo guildInfo) {
        com.tencent.mobileqq.qqguildsdk.data.genc.ch chVar = new com.tencent.mobileqq.qqguildsdk.data.genc.ch();
        String guildID = guildInfo.getGuildID();
        Intrinsics.checkNotNullExpressionValue(guildID, "guildInfo.getGuildID()");
        chVar.c(Long.parseLong(guildID));
        ((IGPSService) com.tencent.mobileqq.guild.util.ch.R0(IGPSService.class)).queryGuildVisitor(chVar, new dh() { // from class: com.tencent.mobileqq.guild.home.parts.ar
            @Override // wh2.dh
            public final void a(int i3, String str, IGProGuildEssenceSvrRsp iGProGuildEssenceSvrRsp) {
                GuildHomeInvisibleForVisitorPart.ja(GuildHomeInvisibleForVisitorPart.this, guildInfo, i3, str, iGProGuildEssenceSvrRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initData() {
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = this.guildInfoHead;
        GuildHomeCoverBelowList guildHomeCoverBelowList = null;
        if (guildHomeGuildInfoLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoHead");
            guildHomeGuildInfoLayout = null;
        }
        guildHomeGuildInfoLayout.f(B9());
        LiveData<GuildHomeCoverColors> T1 = E9().getHeaderColorsViewModel().T1();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<GuildHomeCoverColors, Unit> function1 = new Function1<GuildHomeCoverColors, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeInvisibleForVisitorPart$initData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GuildHomeCoverColors guildHomeCoverColors) {
                invoke2(guildHomeCoverColors);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GuildHomeCoverColors it) {
                CharacterCountEditText characterCountEditText;
                GuildHomeGuildInfoLayout guildHomeGuildInfoLayout2;
                ShadowFrameLayout shadowFrameLayout;
                LinearLayout linearLayout;
                ShadowFrameLayout shadowFrameLayout2;
                characterCountEditText = GuildHomeInvisibleForVisitorPart.this.msgTv;
                LinearLayout linearLayout2 = null;
                if (characterCountEditText == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("msgTv");
                    characterCountEditText = null;
                }
                characterCountEditText.setTextColor(it.getGuildNameColor());
                guildHomeGuildInfoLayout2 = GuildHomeInvisibleForVisitorPart.this.guildInfoHead;
                if (guildHomeGuildInfoLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("guildInfoHead");
                    guildHomeGuildInfoLayout2 = null;
                }
                Intrinsics.checkNotNullExpressionValue(it, "it");
                guildHomeGuildInfoLayout2.g(it);
                if (it.getType() == 2) {
                    shadowFrameLayout2 = GuildHomeInvisibleForVisitorPart.this.msgCardBg;
                    if (shadowFrameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("msgCardBg");
                        shadowFrameLayout2 = null;
                    }
                    shadowFrameLayout2.setFillColor(it.getSubChannelBgColor(), false);
                } else {
                    shadowFrameLayout = GuildHomeInvisibleForVisitorPart.this.msgCardBg;
                    if (shadowFrameLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("msgCardBg");
                        shadowFrameLayout = null;
                    }
                    shadowFrameLayout.setFillColor(it.getSubChannelBgColor(), true);
                }
                linearLayout = GuildHomeInvisibleForVisitorPart.this.visitorLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("visitorLayout");
                } else {
                    linearLayout2 = linearLayout;
                }
                linearLayout2.setBackgroundColor(it.getMainColor());
            }
        };
        T1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.as
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeInvisibleForVisitorPart.ma(Function1.this, obj);
            }
        });
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout2 = this.guildInfoHead;
        if (guildHomeGuildInfoLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoHead");
            guildHomeGuildInfoLayout2 = null;
        }
        GuildHomeCoverBelowList guildHomeCoverBelowList2 = this.coverBelow;
        if (guildHomeCoverBelowList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
            guildHomeCoverBelowList2 = null;
        }
        guildHomeGuildInfoLayout2.k(guildHomeCoverBelowList2, "GuildHomeInvisibleForVisitorPart");
        GuildHomeCoverBelowList guildHomeCoverBelowList3 = this.coverBelow;
        if (guildHomeCoverBelowList3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
            guildHomeCoverBelowList3 = null;
        }
        guildHomeCoverBelowList3.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.guild.home.parts.at
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
                GuildHomeInvisibleForVisitorPart.na(GuildHomeInvisibleForVisitorPart.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
            }
        });
        GuildHomeCoverBelowList guildHomeCoverBelowList4 = this.coverBelow;
        if (guildHomeCoverBelowList4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
        } else {
            guildHomeCoverBelowList = guildHomeCoverBelowList4;
        }
        guildHomeCoverBelowList.post(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.au
            @Override // java.lang.Runnable
            public final void run() {
                GuildHomeInvisibleForVisitorPart.oa(GuildHomeInvisibleForVisitorPart.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ja(GuildHomeInvisibleForVisitorPart this$0, IGProGuildInfo guildInfo, int i3, String str, IGProGuildEssenceSvrRsp iGProGuildEssenceSvrRsp) {
        String msgLeave;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(guildInfo, "$guildInfo");
        QLog.d("Guild.NewHome.GuildHomeInvisibleForVisitorPart", 1, "queryGuildVisitor code:" + i3 + " msg:" + str + " rsp:" + iGProGuildEssenceSvrRsp);
        if (iGProGuildEssenceSvrRsp == null) {
            msgLeave = "";
        } else {
            msgLeave = iGProGuildEssenceSvrRsp.getUnifiedEssenceInfo().getVisitorMsg();
        }
        Intrinsics.checkNotNullExpressionValue(msgLeave, "msgLeave");
        String guildName = guildInfo.getGuildName();
        Intrinsics.checkNotNullExpressionValue(guildName, "guildInfo.guildName");
        this$0.ua(msgLeave, guildName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void la() {
        ViewStub viewStub = this.linearLayout;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
            viewStub = null;
        }
        viewStub.setVisibility(0);
        getPartRootView().findViewById(R.id.vaz).setVisibility(0);
        getPartRootView().findViewById(R.id.u_r).setVisibility(0);
        ViewStub viewStub2 = (ViewStub) getPartRootView().findViewById(R.id.f165532wi2);
        if (viewStub2 != null) {
            viewStub2.setVisibility(8);
        }
        getPartRootView().findViewById(R.id.x4w).setVisibility(8);
        getPartRootView().findViewById(R.id.b9w).setVisibility(8);
        getPartRootView().findViewById(R.id.f98755ny).setVisibility(8);
        getPartRootView().findViewById(R.id.loading_layout).setVisibility(8);
        getPartRootView().findViewById(R.id.ulf).setVisibility(8);
        A9().E(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ma(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void na(GuildHomeInvisibleForVisitorPart this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = this$0.guildInfoHead;
        GuildHomeCoverBelowList guildHomeCoverBelowList = null;
        if (guildHomeGuildInfoLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoHead");
            guildHomeGuildInfoLayout = null;
        }
        GuildHomeCoverBelowList guildHomeCoverBelowList2 = this$0.coverBelow;
        if (guildHomeCoverBelowList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
        } else {
            guildHomeCoverBelowList = guildHomeCoverBelowList2;
        }
        guildHomeGuildInfoLayout.k(guildHomeCoverBelowList, "GuildHomeInvisibleForVisitorPart");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void oa(GuildHomeInvisibleForVisitorPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        GuildHomeGuildInfoLayout guildHomeGuildInfoLayout = this$0.guildInfoHead;
        GuildHomeCoverBelowList guildHomeCoverBelowList = null;
        if (guildHomeGuildInfoLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("guildInfoHead");
            guildHomeGuildInfoLayout = null;
        }
        GuildHomeCoverBelowList guildHomeCoverBelowList2 = this$0.coverBelow;
        if (guildHomeCoverBelowList2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("coverBelow");
        } else {
            guildHomeCoverBelowList = guildHomeCoverBelowList2;
        }
        guildHomeGuildInfoLayout.k(guildHomeCoverBelowList, "GuildHomeInvisibleForVisitorPart");
        this$0.ta();
    }

    private final com.tencent.mobileqq.guild.home.subhome.g qa() {
        g.Companion companion = com.tencent.mobileqq.guild.home.subhome.g.INSTANCE;
        return new b("Guild.NewHome.GuildHomeInvisibleForVisitorPart", this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ra(GuildHomeInvisibleForVisitorPart this$0, ViewStub viewStub, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.isInflated = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void sa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ta() {
        Resources resources;
        Configuration configuration;
        if (QQGuildUIUtil.y() && this.msgRfy != null) {
            Context context = getContext();
            boolean z16 = false;
            if (context != null && (resources = context.getResources()) != null && (configuration = resources.getConfiguration()) != null && configuration.orientation == 2) {
                z16 = true;
            }
            RadiusFrameLayout radiusFrameLayout = null;
            if (z16) {
                RadiusFrameLayout radiusFrameLayout2 = this.msgRfy;
                if (radiusFrameLayout2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("msgRfy");
                    radiusFrameLayout2 = null;
                }
                radiusFrameLayout2.setMinimumHeight(cx.a(100.0f));
                RadiusFrameLayout radiusFrameLayout3 = this.msgRfy;
                if (radiusFrameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("msgRfy");
                } else {
                    radiusFrameLayout = radiusFrameLayout3;
                }
                radiusFrameLayout.getLayoutParams().height = cx.a(100.0f);
                return;
            }
            RadiusFrameLayout radiusFrameLayout4 = this.msgRfy;
            if (radiusFrameLayout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgRfy");
                radiusFrameLayout4 = null;
            }
            radiusFrameLayout4.setMinimumHeight(cx.a(224.0f));
            RadiusFrameLayout radiusFrameLayout5 = this.msgRfy;
            if (radiusFrameLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("msgRfy");
            } else {
                radiusFrameLayout = radiusFrameLayout5;
            }
            radiusFrameLayout.getLayoutParams().height = -2;
        }
    }

    private final void ua(String msgLeave, String guildName) {
        boolean z16;
        ha();
        Button button = this.joinBtn;
        Button button2 = null;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinBtn");
            button = null;
        }
        button.setVisibility(0);
        CharacterCountEditText characterCountEditText = this.msgTv;
        if (characterCountEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("msgTv");
            characterCountEditText = null;
        }
        CharSequence qQText = ((IGuildEmotionCodecApi) QRoute.api(IGuildEmotionCodecApi.class)).toQQText(msgLeave, 20);
        if (qQText.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String qqStr = HardCodeUtil.qqStr(R.string.f158301p9);
            Intrinsics.checkNotNullExpressionValue(qqStr, "qqStr(R.string.guild_visitor_leave_msg_default)");
            qQText = String.format(qqStr, Arrays.copyOf(new Object[]{guildName}, 1));
            Intrinsics.checkNotNullExpressionValue(qQText, "format(format, *args)");
        }
        characterCountEditText.setText(qQText);
        Button button3 = this.joinBtn;
        if (button3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinBtn");
        } else {
            button2 = button3;
        }
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.parts.av
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                GuildHomeInvisibleForVisitorPart.va(GuildHomeInvisibleForVisitorPart.this, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void va(GuildHomeInvisibleForVisitorPart this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9().i().g(view, true);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void wa() {
        getPartRootView().findViewById(R.id.b9w).setVisibility(0);
        getPartRootView().findViewById(R.id.f98755ny).setVisibility(0);
        getPartRootView().findViewById(R.id.loading_layout).setVisibility(0);
        getPartRootView().findViewById(R.id.ulf).setVisibility(0);
        A9().E(true);
    }

    public final void ha() {
        Button button = this.joinBtn;
        if (button == null) {
            Intrinsics.throwUninitializedPropertyAccessException("joinBtn");
            button = null;
        }
        com.tencent.mobileqq.guild.util.ch.Y0(button, "em_sgrp_bottom_join_channel", ClickPolicy.REPORT_ALL, ExposurePolicy.REPORT_ALL);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onConfigurationChanged(@Nullable Configuration configuration) {
        super.onConfigurationChanged(configuration);
        ta();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        View findViewById = rootView.findViewById(R.id.u_r);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.cover_below)");
        this.coverBelow = (GuildHomeCoverBelowList) findViewById;
        View findViewById2 = rootView.findViewById(R.id.f915155d);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.system_window_anchor)");
        this.windowAnchor = (Space) findViewById2;
        View findViewById3 = rootView.findViewById(R.id.wjw);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "rootView.findViewById(R.\u2026sible_for_visitor_layout)");
        ViewStub viewStub = (ViewStub) findViewById3;
        this.linearLayout = viewStub;
        if (viewStub == null) {
            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
            viewStub = null;
        }
        viewStub.setOnInflateListener(new ViewStub.OnInflateListener() { // from class: com.tencent.mobileqq.guild.home.parts.ap
            @Override // android.view.ViewStub.OnInflateListener
            public final void onInflate(ViewStub viewStub2, View view) {
                GuildHomeInvisibleForVisitorPart.ra(GuildHomeInvisibleForVisitorPart.this, viewStub2, view);
            }
        });
        this.guildVisitorReportTask = C9().b().duplicate(new String[0]).setStageCode("stage_visitor_part");
        LiveData<IGProGuildInfo> e26 = E9().getGuildHomeTitleViewModel().e2();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        final Function1<IGProGuildInfo, Unit> function1 = new Function1<IGProGuildInfo, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeInvisibleForVisitorPart$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(IGProGuildInfo iGProGuildInfo) {
                invoke2(iGProGuildInfo);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r2v1, types: [android.view.ViewStub] */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable IGProGuildInfo iGProGuildInfo) {
                ?? r26;
                GuildHomeGuildInfoLayout guildHomeGuildInfoLayout;
                ViewStub viewStub2;
                ViewStub viewStub3;
                GuildHomeGuildInfoLayout guildHomeGuildInfoLayout2;
                Space space;
                IPerformanceReportTask iPerformanceReportTask;
                GuildHomeGuildInfoLayout guildHomeGuildInfoLayout3 = null;
                if (iGProGuildInfo == null || iGProGuildInfo.isVisibleForVisitor() || iGProGuildInfo.isMember() || iGProGuildInfo.getIsBanned()) {
                    r26 = GuildHomeInvisibleForVisitorPart.this.linearLayout;
                    if (r26 == 0) {
                        Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
                    } else {
                        guildHomeGuildInfoLayout3 = r26;
                    }
                    guildHomeGuildInfoLayout3.setVisibility(8);
                } else {
                    if (!GuildHomeInvisibleForVisitorPart.this.getIsInflated()) {
                        viewStub2 = GuildHomeInvisibleForVisitorPart.this.linearLayout;
                        if (viewStub2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
                            viewStub2 = null;
                        }
                        if (viewStub2.getParent() != null) {
                            GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart = GuildHomeInvisibleForVisitorPart.this;
                            viewStub3 = guildHomeInvisibleForVisitorPart.linearLayout;
                            if (viewStub3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("linearLayout");
                                viewStub3 = null;
                            }
                            View inflate = viewStub3.inflate();
                            Intrinsics.checkNotNullExpressionValue(inflate, "linearLayout.inflate()");
                            guildHomeInvisibleForVisitorPart.layout = inflate;
                            GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart2 = GuildHomeInvisibleForVisitorPart.this;
                            View view = guildHomeInvisibleForVisitorPart2.layout;
                            if (view == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                                view = null;
                            }
                            View findViewById4 = view.findViewById(R.id.y_w);
                            Intrinsics.checkNotNullExpressionValue(findViewById4, "layout.findViewById(R.id.joinBtn)");
                            guildHomeInvisibleForVisitorPart2.joinBtn = (Button) findViewById4;
                            GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart3 = GuildHomeInvisibleForVisitorPart.this;
                            View view2 = guildHomeInvisibleForVisitorPart3.layout;
                            if (view2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                                view2 = null;
                            }
                            View findViewById5 = view2.findViewById(R.id.zfo);
                            Intrinsics.checkNotNullExpressionValue(findViewById5, "layout.findViewById(R.id.msgTv)");
                            guildHomeInvisibleForVisitorPart3.msgTv = (CharacterCountEditText) findViewById5;
                            GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart4 = GuildHomeInvisibleForVisitorPart.this;
                            View view3 = guildHomeInvisibleForVisitorPart4.layout;
                            if (view3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                                view3 = null;
                            }
                            View findViewById6 = view3.findViewById(R.id.zfj);
                            Intrinsics.checkNotNullExpressionValue(findViewById6, "layout.findViewById(R.id.msgCardBg)");
                            guildHomeInvisibleForVisitorPart4.msgCardBg = (ShadowFrameLayout) findViewById6;
                            GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart5 = GuildHomeInvisibleForVisitorPart.this;
                            View view4 = guildHomeInvisibleForVisitorPart5.layout;
                            if (view4 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                                view4 = null;
                            }
                            View findViewById7 = view4.findViewById(R.id.wjg);
                            Intrinsics.checkNotNullExpressionValue(findViewById7, "layout.findViewById(R.id.guild_info)");
                            guildHomeInvisibleForVisitorPart5.guildInfoHead = (GuildHomeGuildInfoLayout) findViewById7;
                            GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart6 = GuildHomeInvisibleForVisitorPart.this;
                            View view5 = guildHomeInvisibleForVisitorPart6.layout;
                            if (view5 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                                view5 = null;
                            }
                            View findViewById8 = view5.findViewById(R.id.f1200078d);
                            Intrinsics.checkNotNullExpressionValue(findViewById8, "layout.findViewById(R.id.visitor_layout)");
                            guildHomeInvisibleForVisitorPart6.visitorLayout = (LinearLayout) findViewById8;
                            GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart7 = GuildHomeInvisibleForVisitorPart.this;
                            View view6 = guildHomeInvisibleForVisitorPart7.layout;
                            if (view6 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                                view6 = null;
                            }
                            View findViewById9 = view6.findViewById(R.id.zfm);
                            Intrinsics.checkNotNullExpressionValue(findViewById9, "layout.findViewById(R.id.msgRfy)");
                            guildHomeInvisibleForVisitorPart7.msgRfy = (RadiusFrameLayout) findViewById9;
                            guildHomeGuildInfoLayout2 = GuildHomeInvisibleForVisitorPart.this.guildInfoHead;
                            if (guildHomeGuildInfoLayout2 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("guildInfoHead");
                                guildHomeGuildInfoLayout2 = null;
                            }
                            space = GuildHomeInvisibleForVisitorPart.this.windowAnchor;
                            if (space == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                                space = null;
                            }
                            guildHomeGuildInfoLayout2.setWindowAnchor(space);
                            iPerformanceReportTask = GuildHomeInvisibleForVisitorPart.this.guildVisitorReportTask;
                            if (iPerformanceReportTask == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("guildVisitorReportTask");
                                iPerformanceReportTask = null;
                            }
                            View view7 = GuildHomeInvisibleForVisitorPart.this.layout;
                            if (view7 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException(TtmlNode.TAG_LAYOUT);
                                view7 = null;
                            }
                            final GuildHomeInvisibleForVisitorPart guildHomeInvisibleForVisitorPart8 = GuildHomeInvisibleForVisitorPart.this;
                            qw1.b.j(iPerformanceReportTask, view7, new Function1<IPerformanceReportTask, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeInvisibleForVisitorPart$onInitView$2.1
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Unit invoke(IPerformanceReportTask iPerformanceReportTask2) {
                                    invoke2(iPerformanceReportTask2);
                                    return Unit.INSTANCE;
                                }

                                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                public final void invoke2(@NotNull IPerformanceReportTask reportOnFirstFrame) {
                                    IPerformanceReportTask iPerformanceReportTask2;
                                    Intrinsics.checkNotNullParameter(reportOnFirstFrame, "$this$reportOnFirstFrame");
                                    cp1.d dVar = cp1.d.f391542a;
                                    iPerformanceReportTask2 = GuildHomeInvisibleForVisitorPart.this.guildVisitorReportTask;
                                    if (iPerformanceReportTask2 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("guildVisitorReportTask");
                                        iPerformanceReportTask2 = null;
                                    }
                                    dVar.b(iPerformanceReportTask2);
                                }
                            });
                        }
                    }
                    GuildHomeInvisibleForVisitorPart.this.initData();
                    GuildHomeInvisibleForVisitorPart.this.ia(iGProGuildInfo);
                    GuildHomeInvisibleForVisitorPart.this.la();
                    guildHomeGuildInfoLayout = GuildHomeInvisibleForVisitorPart.this.guildInfoHead;
                    if (guildHomeGuildInfoLayout == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("guildInfoHead");
                    } else {
                        guildHomeGuildInfoLayout3 = guildHomeGuildInfoLayout;
                    }
                    guildHomeGuildInfoLayout3.i(iGProGuildInfo);
                }
                if (iGProGuildInfo == null || !iGProGuildInfo.isMember()) {
                    return;
                }
                GuildHomeInvisibleForVisitorPart.this.wa();
            }
        };
        e26.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.aq
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeInvisibleForVisitorPart.sa(Function1.this, obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.home.parts.a, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        A9().h(this.onStateUpdate);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        A9().C(this.onStateUpdate);
    }

    /* renamed from: pa, reason: from getter */
    public final boolean getIsInflated() {
        return this.isInflated;
    }
}
