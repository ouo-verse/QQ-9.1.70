package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.Observer;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedPayloadType;
import com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedDetailInitBean;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedMainInitBean;
import com.tencent.mobileqq.guild.feed.nativedetail.content.feedmain.data.GProStFeedDetailRspWrapper;
import com.tencent.mobileqq.guild.feed.publish.bean.GuildTaskProgressState;
import com.tencent.mobileqq.guild.feed.util.GuildFeedBottomSectionHelper;
import com.tencent.mobileqq.guild.feed.util.GuildFeedCommentUtil;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007\u00a2\u0006\u0004\bD\u0010EJ\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J \u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u000fH\u0002J\b\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u0003H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\nH\u0014J&\u0010 \u001a\u00020\u00142\u001c\u0010\u001f\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001d0\u001bj\u0002`\u001e0\u001aH\u0014J*\u0010(\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#2\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%H\u0016J\u0010\u0010*\u001a\u00020\u00062\u0006\u0010)\u001a\u00020\u0014H\u0016J\u0012\u0010+\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010,\u001a\u00020\u000fH\u0016R\u001a\u00101\u001a\u00060-j\u0002`.8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001d\u00107\u001a\u0004\u0018\u0001028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R\u0014\u0010;\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u0014\u0010C\u001a\u00020@8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bA\u0010B\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBottomSection;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroidx/lifecycle/Observer;", "Lcom/tencent/qqnt/kernelgpro/nativeinterface/GProStFeed;", "Lij1/g;", "d0", "", "k0", "m0", "l0", "Landroid/view/View;", "share", "comment", "prefer", "a0", "", "j0", "e0", "i0", "newStFeed", "", "n0", "", "getViewStubLayoutId", "containerView", "onInitView", "", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedSquareFeedPayloadType;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/i;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedSquareFeedPayloadInstanceType;", "payloadMaps", "H", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "attached", "onAttachedChanged", "o0", "v", "Lqj1/h;", "Lcom/tencent/mobileqq/guild/feed/nativedetail/content/feedmain/data/IFeedMainDisplayable;", "e", "Lqj1/h;", "lastFeedInfo", "Lwo1/c;", "f", "Lkotlin/Lazy;", "g0", "()Lwo1/c;", "guildFeedSortModeIoc", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents;", tl.h.F, "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents;", "components", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents;", "i", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedPostFailedEditComponents;", "postFailedEditComponents", "Lcom/tencent/mobileqq/guild/feed/util/GuildFeedBottomSectionHelper;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/feed/util/GuildFeedBottomSectionHelper;", "bottomSectionHelper", "<init>", "()V", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareFeedBottomSection extends GuildFeedSquareFeedBaseSection implements Observer<GProStFeed> {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private qj1.h lastFeedInfo;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy guildFeedSortModeIoc;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedBottomComponents components;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private GuildFeedPostFailedEditComponents postFailedEditComponents;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildFeedBottomSectionHelper bottomSectionHelper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016J \u0010\r\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016J\b\u0010\u0010\u001a\u00020\u0006H\u0016\u00a8\u0006\u0011"}, d2 = {"com/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBottomSection$a", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedBottomComponents$b;", "", "b", "d", "g", "", "isEnable", "e", "Landroid/view/View;", "share", "comment", "prefer", "c", "", "a", "f", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements GuildFeedBottomComponents.b {
        a() {
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public int a() {
            wo1.c g06 = GuildFeedSquareFeedBottomSection.this.g0();
            if (g06 != null) {
                return g06.getSortMode();
            }
            return 0;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void b() {
            GuildFeedSquareFeedBottomSection.this.k0();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void c(@NotNull View share, @NotNull View comment, @NotNull View prefer) {
            Intrinsics.checkNotNullParameter(share, "share");
            Intrinsics.checkNotNullParameter(comment, "comment");
            Intrinsics.checkNotNullParameter(prefer, "prefer");
            GuildFeedSquareFeedBottomSection.this.a0(share, comment, prefer);
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void d() {
            GuildFeedSquareFeedBottomSection.this.m0();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean e() {
            return bn.f223895a.j(GuildFeedSquareFeedBottomSection.this.d0());
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean f() {
            if (GuildFeedSquareFeedBottomSection.this.p() == 14 && com.tencent.mobileqq.guild.feed.util.r.f223924a.a()) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public void g() {
            GuildFeedSquareFeedBottomSection.this.l0();
        }

        @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedBottomComponents.b
        public boolean isEnable() {
            boolean z16;
            boolean z17;
            GuildTaskProgressState p16 = GuildFeedSquareFeedBottomSection.this.d0().p();
            if (p16 != null && kn1.c.a(p16)) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (!z16) {
                return true;
            }
            GProStFeed D = GuildFeedSquareFeedBottomSection.this.D();
            if (D != null && com.tencent.mobileqq.guild.feed.nativeinterface.kt.a.j(D)) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (!z17) {
                return true;
            }
            return false;
        }
    }

    public GuildFeedSquareFeedBottomSection() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<wo1.c>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBottomSection$guildFeedSortModeIoc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final wo1.c invoke() {
                return (wo1.c) SectionIOCKt.getIocInterface(GuildFeedSquareFeedBottomSection.this, wo1.c.class);
            }
        });
        this.guildFeedSortModeIoc = lazy;
        this.components = new GuildFeedBottomComponents(new a());
        GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = new GuildFeedBottomSectionHelper();
        guildFeedBottomSectionHelper.u("FileUtil");
        this.bottomSectionHelper = guildFeedBottomSectionHelper;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a0(View share, View comment, View prefer) {
        A(share, j0());
        String e06 = e0();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        EndExposurePolicy endExposurePolicy = EndExposurePolicy.REPORT_ALL;
        com.tencent.mobileqq.guild.feed.report.d.e(comment, e06, clickPolicy, exposurePolicy, endExposurePolicy, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.q
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map b06;
                b06 = GuildFeedSquareFeedBottomSection.b0(GuildFeedSquareFeedBottomSection.this, str);
                return b06;
            }
        });
        com.tencent.mobileqq.guild.feed.report.d.e(prefer, i0(), clickPolicy, exposurePolicy, endExposurePolicy, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.r
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map c06;
                c06 = GuildFeedSquareFeedBottomSection.c0(GuildFeedSquareFeedBottomSection.this, str);
                return c06;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map b0(GuildFeedSquareFeedBottomSection this$0, String str) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> C = this$0.C();
        qj1.h hVar = this$0.lastFeedInfo;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
            hVar = null;
        }
        if (hVar.getCommentCount() != 0) {
            i3 = 1;
        } else {
            i3 = 0;
        }
        C.put("sgrp_is_no_comment", Integer.valueOf(i3));
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map c0(GuildFeedSquareFeedBottomSection this$0, String str) {
        int i3;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> C = this$0.C();
        qj1.h hVar = this$0.lastFeedInfo;
        qj1.h hVar2 = null;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
            hVar = null;
        }
        int i16 = 0;
        if (hVar.getPreferStatus() == 1) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        C.put("sgrp_action_result", Integer.valueOf(i3));
        qj1.h hVar3 = this$0.lastFeedInfo;
        if (hVar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
        } else {
            hVar2 = hVar3;
        }
        if (hVar2.getPreferStatus() == 1) {
            i16 = 1;
        }
        C.put("sgrp_state", Integer.valueOf(i16));
        return C;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final ij1.g d0() {
        return ((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String e0() {
        switch (((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).b()) {
            case 13:
                return "em_sgrp_nowplay_comment";
            case 14:
                return "em_sgrp_voice_comment";
            case 15:
                return "em_sgrp_single_event_comment";
            default:
                return "em_sgrp_forum_comment";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final wo1.c g0() {
        return (wo1.c) this.guildFeedSortModeIoc.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String i0() {
        switch (((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).b()) {
            case 13:
                return "em_sgrp_nowplay_up";
            case 14:
                return "em_sgrp_voice_up";
            case 15:
                return "em_sgrp_single_event_up";
            default:
                return "em_sgrp_forum_up";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String j0() {
        switch (((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).b()) {
            case 13:
                return "em_sgrp_nowplay_share";
            case 14:
                return "em_sgrp_voice_share";
            case 15:
                return "em_sgrp_single_event_share";
            default:
                return "em_sgrp_forum_share";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k0() {
        GProStFeed D;
        boolean z16;
        String str;
        if (!bn.f223895a.f(d0()) && (D = D()) != null) {
            GuildFeedDetailInitBean F = F(D);
            if (!d0().s()) {
                qj1.h hVar = this.lastFeedInfo;
                if (hVar == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                    hVar = null;
                }
                if (hVar.getCommentCount() == 0) {
                    GuildFeedCommentUtil guildFeedCommentUtil = GuildFeedCommentUtil.f223766a;
                    View rootView = getRootView();
                    Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                    guildFeedCommentUtil.n(rootView, D, F, t());
                    return;
                }
                xj1.a aVar = (xj1.a) SectionIOCKt.getIocInterface(this, xj1.a.class);
                if (aVar != null) {
                    String str2 = D.channelInfo.sign.joinGuildSig;
                    if (str2 != null && str2.length() != 0) {
                        z16 = false;
                    } else {
                        z16 = true;
                    }
                    if (z16) {
                        GProStChannelSign gProStChannelSign = D.channelInfo.sign;
                        JumpGuildParam.JoinInfoParam joinInfoParam = F.getJoinInfoParam();
                        if (joinInfoParam == null || (str = joinInfoParam.getJoinSignature()) == null) {
                            str = "";
                        }
                        gProStChannelSign.joinGuildSig = str;
                    }
                    aVar.a(D);
                    return;
                }
                return;
            }
            K(D, 3, 3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0() {
        Logger logger = Logger.f235387a;
        logger.d().i(v(), 1, "handleShareClicked");
        if (bn.f223895a.f(d0())) {
            return;
        }
        O();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m0() {
        GProStFeed D = D();
        if (D != null) {
            this.bottomSectionHelper.p(com.tencent.mobileqq.guild.feed.nativepublish.utils.k.c(1, F(D)));
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            qj1.h hVar = this.lastFeedInfo;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar = null;
            }
            com.tencent.mobileqq.guild.main.d.d(peekAppRuntime, String.valueOf(hVar.getGuildId()), "feedListPreferClick");
        }
    }

    private final boolean n0(GProStFeed newStFeed) {
        qj1.h hVar;
        if (this.mData != 0 && (hVar = this.lastFeedInfo) != null) {
            String str = newStFeed.idd;
            if (hVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar = null;
            }
            if (Intrinsics.areEqual(str, hVar.getFeedId())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    protected boolean H(@NotNull List<? extends Map<GuildFeedSquareFeedPayloadType, ? extends com.tencent.mobileqq.guild.feed.feedsquare.data.i>> payloadMaps) {
        Intrinsics.checkNotNullParameter(payloadMaps, "payloadMaps");
        List<? extends Map<GuildFeedSquareFeedPayloadType, ? extends com.tencent.mobileqq.guild.feed.feedsquare.data.i>> list = payloadMaps;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            if (((Map) it.next()).containsKey(GuildFeedSquareFeedPayloadType.VIEW_COUNT_PAYLOAD)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.i<GuildFeedMainInitBean> iVar;
        boolean z16;
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.b<GuildFeedMainInitBean> context;
        GProStFeed D = D();
        if (D == null) {
            return;
        }
        GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents = null;
        GProStFeedDetailRspWrapper gProStFeedDetailRspWrapper = new GProStFeedDetailRspWrapper(D, null, 2, null);
        this.lastFeedInfo = gProStFeedDetailRspWrapper;
        this.components.m(gProStFeedDetailRspWrapper, position, payload);
        GuildTaskProgressState p16 = d0().p();
        GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
        guildFeedBottomSectionHelper.x(p16);
        qj1.h hVar = this.lastFeedInfo;
        if (hVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
            hVar = null;
        }
        guildFeedBottomSectionHelper.t(hVar);
        guildFeedBottomSectionHelper.w(D);
        com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g gVar = (com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g) SectionIOCKt.getIocInterface(this, com.tencent.mobileqq.guild.feed.feedsquare.part.remake.g.class);
        if (gVar != null && (context = gVar.getContext()) != null) {
            iVar = context.d();
        } else {
            iVar = null;
        }
        guildFeedBottomSectionHelper.v(iVar);
        if (p16 != null && kn1.c.a(p16)) {
            z16 = true;
        } else {
            z16 = false;
        }
        GuildFeedPostFailedEditComponents guildFeedPostFailedEditComponents2 = this.postFailedEditComponents;
        if (guildFeedPostFailedEditComponents2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("postFailedEditComponents");
        } else {
            guildFeedPostFailedEditComponents = guildFeedPostFailedEditComponents2;
        }
        guildFeedPostFailedEditComponents.g(z16);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return this.components.i();
    }

    @Override // androidx.lifecycle.Observer
    /* renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void onChanged(@Nullable GProStFeed newStFeed) {
        if (newStFeed != null && n0(newStFeed)) {
            qj1.h hVar = null;
            this.lastFeedInfo = new GProStFeedDetailRspWrapper(newStFeed, null, 2, null);
            GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
            guildFeedBottomSectionHelper.w(newStFeed);
            qj1.h hVar2 = this.lastFeedInfo;
            if (hVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
                hVar2 = null;
            }
            guildFeedBottomSectionHelper.t(hVar2);
            GuildFeedBottomComponents guildFeedBottomComponents = this.components;
            qj1.h hVar3 = this.lastFeedInfo;
            if (hVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lastFeedInfo");
            } else {
                hVar = hVar3;
            }
            guildFeedBottomComponents.n(hVar);
        }
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onAttachedChanged(boolean attached) {
        GProStFeed D = D();
        if (D != null && !TextUtils.isEmpty(D.idd)) {
            if (attached) {
                jj1.b.c().observerGlobalState(D, this);
            } else {
                jj1.b.c().removeObserverGlobalState(D, this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        this.components.o(containerView);
        GuildFeedBottomSectionHelper guildFeedBottomSectionHelper = this.bottomSectionHelper;
        Context context = getRootView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        guildFeedBottomSectionHelper.s(context);
        this.postFailedEditComponents = new GuildFeedPostFailedEditComponents(containerView, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBottomSection$onInitView$1
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
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = GuildFeedSquareFeedBottomSection.this.bottomSectionHelper;
                guildFeedBottomSectionHelper2.n();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBottomSection$onInitView$2
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
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = GuildFeedSquareFeedBottomSection.this.bottomSectionHelper;
                guildFeedBottomSectionHelper2.o();
            }
        }, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBottomSection$onInitView$3
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
                GuildFeedBottomSectionHelper guildFeedBottomSectionHelper2;
                guildFeedBottomSectionHelper2 = GuildFeedSquareFeedBottomSection.this.bottomSectionHelper;
                guildFeedBottomSectionHelper2.q();
            }
        });
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.n
    @NotNull
    public String v() {
        return "GuildFeedSquareFeedBottomSection";
    }
}
