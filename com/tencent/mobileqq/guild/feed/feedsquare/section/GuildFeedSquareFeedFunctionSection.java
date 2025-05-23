package com.tencent.mobileqq.guild.feed.feedsquare.section;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.google.android.flexbox.FlexboxLayout;
import com.tencent.biz.qui.quicheckbox.QUICheckBox;
import com.tencent.biz.richframework.adapter.section.SectionIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.api.IGuildFeedNativeDetailApi;
import com.tencent.mobileqq.guild.feed.api.impl.GuildFeedImagePreDecoder;
import com.tencent.mobileqq.guild.feed.feedsquare.data.GuildFeedSquareFeedPayloadType;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildFeedSquareFeedItemView;
import com.tencent.mobileqq.guild.feed.util.bn;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelInfo;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStChannelSign;
import com.tencent.qqnt.kernelgpro.nativeinterface.GProStFeed;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u00012\u00020\u0002:\u00011B\u0007\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0003H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\fH\u0014J&\u0010\u0019\u001a\u00020\u00032\u001c\u0010\u0018\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u0014j\u0002`\u00170\u0013H\u0014J*\u0010!\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0016J\u0010\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\fH\u0016J\u0010\u0010%\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0003H\u0016R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00062"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedFunctionSection;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/section/GuildFeedSquareFeedBaseSection;", "Landroid/view/View$OnClickListener;", "", "c0", "", "W", "a0", "V", "b0", "Z", "X", "Landroid/view/View;", "view", "Y", "", "getViewStubLayoutId", "containerView", "onInitView", "", "", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedSquareFeedPayloadType;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/i;", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/GuildFeedSquareFeedPayloadInstanceType;", "payloadMaps", "H", "Lcom/tencent/mobileqq/guild/feed/feedsquare/data/h;", "data", "", "position", "", "", "payload", "M", "v", NodeProps.ON_CLICK, NodeProps.VISIBLE, "onVisibleChanged", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareFeedItemView;", "e", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildFeedSquareFeedItemView;", "feedItemView", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "f", "Lcom/tencent/biz/qui/quicheckbox/QUICheckBox;", "checkBox", "<init>", "()V", tl.h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedSquareFeedFunctionSection extends GuildFeedSquareFeedBaseSection implements View.OnClickListener {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private GuildFeedSquareFeedItemView feedItemView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private QUICheckBox checkBox;

    private final void V() {
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView = null;
        if (J()) {
            GuildFeedSquareFeedItemView guildFeedSquareFeedItemView2 = this.feedItemView;
            if (guildFeedSquareFeedItemView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
                guildFeedSquareFeedItemView2 = null;
            }
            VideoReport.setElementClickPolicy(guildFeedSquareFeedItemView2, ClickPolicy.REPORT_NONE);
            GuildFeedSquareFeedItemView guildFeedSquareFeedItemView3 = this.feedItemView;
            if (guildFeedSquareFeedItemView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
                guildFeedSquareFeedItemView3 = null;
            }
            VideoReport.setElementExposePolicy(guildFeedSquareFeedItemView3, ExposurePolicy.REPORT_NONE);
            GuildFeedSquareFeedItemView guildFeedSquareFeedItemView4 = this.feedItemView;
            if (guildFeedSquareFeedItemView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
            } else {
                guildFeedSquareFeedItemView = guildFeedSquareFeedItemView4;
            }
            VideoReport.setElementEndExposePolicy(guildFeedSquareFeedItemView, EndExposurePolicy.REPORT_NONE);
            return;
        }
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView5 = this.feedItemView;
        if (guildFeedSquareFeedItemView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
        } else {
            guildFeedSquareFeedItemView = guildFeedSquareFeedItemView5;
        }
        A(guildFeedSquareFeedItemView, "em_sgrp_forum_feed");
    }

    private final void W() {
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView = this.feedItemView;
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView2 = null;
        if (guildFeedSquareFeedItemView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
            guildFeedSquareFeedItemView = null;
        }
        GuildFeedSquareFeedItemView.setInjectClickEvent$default(guildFeedSquareFeedItemView, true, null, 2, null);
        QUICheckBox qUICheckBox = this.checkBox;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
            qUICheckBox = null;
        }
        qUICheckBox.setVisibility(0);
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView3 = this.feedItemView;
        if (guildFeedSquareFeedItemView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
            guildFeedSquareFeedItemView3 = null;
        }
        ((TextView) guildFeedSquareFeedItemView3.findViewById(R.id.w_x)).setVisibility(8);
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView4 = this.feedItemView;
        if (guildFeedSquareFeedItemView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
        } else {
            guildFeedSquareFeedItemView2 = guildFeedSquareFeedItemView4;
        }
        FlexboxLayout flexboxLayout = (FlexboxLayout) guildFeedSquareFeedItemView2.findViewById(R.id.way);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(0, R.id.wad);
        layoutParams.addRule(1, R.id.wa7);
        layoutParams.setMarginEnd(ViewUtils.dip2px(10.0f));
        flexboxLayout.setLayoutParams(layoutParams);
        a0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Y(View view) {
        String str;
        HashMap hashMap = new HashMap();
        switch (((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).b()) {
            case 13:
                str = "em_sgrp_nowplay_hold_share";
                break;
            case 14:
                str = "em_sgrp_voice_hold_share";
                break;
            case 15:
                str = "em_sgrp_single_event_hold_share";
                break;
            default:
                str = "em_sgrp_forum_hold_share";
                break;
        }
        hashMap.putAll(C());
        VideoReport.setElementId(view, str);
        VideoReport.reportEvent("dt_clck", view, hashMap);
        V();
    }

    private final void Z() {
        String str;
        long j3;
        GProStChannelInfo gProStChannelInfo;
        GProStChannelSign gProStChannelSign;
        QUICheckBox qUICheckBox = this.checkBox;
        String str2 = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
            qUICheckBox = null;
        }
        boolean z16 = !qUICheckBox.isChecked();
        vi1.f fVar = (vi1.f) SectionIOCKt.getIocInterface(this, vi1.f.class);
        if (fVar != null) {
            int i3 = this.mPosition;
            GProStFeed D = D();
            if (D != null) {
                str2 = D.idd;
            }
            if (str2 == null) {
                str = "";
            } else {
                str = str2;
            }
            GProStFeed D2 = D();
            if (D2 != null && (gProStChannelInfo = D2.channelInfo) != null && (gProStChannelSign = gProStChannelInfo.sign) != null) {
                j3 = gProStChannelSign.channelId;
            } else {
                j3 = 0;
            }
            fVar.c(i3, str, j3, z16);
        }
    }

    private final void a0() {
        vi1.f fVar = (vi1.f) SectionIOCKt.getIocInterface(this, vi1.f.class);
        QUICheckBox qUICheckBox = this.checkBox;
        String str = null;
        if (qUICheckBox == null) {
            Intrinsics.throwUninitializedPropertyAccessException("checkBox");
            qUICheckBox = null;
        }
        boolean z16 = false;
        if (fVar != null) {
            GProStFeed D = D();
            if (D != null) {
                str = D.idd;
            }
            if (str == null) {
                str = "";
            }
            if (fVar.j(str)) {
                z16 = true;
            }
        }
        qUICheckBox.setChecked(z16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final boolean b0() {
        return bn.f223895a.f(((com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData).getBlockData());
    }

    private final boolean c0() {
        if (p() == 18) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    protected boolean H(@NotNull List<? extends Map<GuildFeedSquareFeedPayloadType, ? extends com.tencent.mobileqq.guild.feed.feedsquare.data.i>> payloadMaps) {
        boolean z16;
        Intrinsics.checkNotNullParameter(payloadMaps, "payloadMaps");
        List<? extends Map<GuildFeedSquareFeedPayloadType, ? extends com.tencent.mobileqq.guild.feed.feedsquare.data.i>> list = payloadMaps;
        if ((list instanceof Collection) && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Map map = (Map) it.next();
            if (!map.containsKey(GuildFeedSquareFeedPayloadType.SELECT_STATE_PAYLOAD) && !map.containsKey(GuildFeedSquareFeedPayloadType.PADDING_CHANGE_PAYLOAD)) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedBaseSection
    public void M(@Nullable com.tencent.mobileqq.guild.feed.feedsquare.data.h data, int position, @Nullable List<Object> payload) {
        boolean c06 = c0();
        V();
        if (c06) {
            W();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        return new int[0];
    }

    @Override // android.view.View.OnClickListener
    public void onClick(@NotNull final View v3) {
        EventCollector.getInstance().onViewClickedBefore(v3);
        Intrinsics.checkNotNullParameter(v3, "v");
        if (c0()) {
            Z();
        } else {
            yl1.n.i(B(), 0L, new Function0<Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedFunctionSection$onClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    GuildFeedSquareFeedItemView guildFeedSquareFeedItemView;
                    List<String> listOfNotNull;
                    List listOfNotNull2;
                    GProStFeed D = GuildFeedSquareFeedFunctionSection.this.D();
                    if (D != null) {
                        GuildFeedSquareFeedFunctionSection guildFeedSquareFeedFunctionSection = GuildFeedSquareFeedFunctionSection.this;
                        View view = v3;
                        guildFeedSquareFeedItemView = guildFeedSquareFeedFunctionSection.feedItemView;
                        if (guildFeedSquareFeedItemView == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("feedItemView");
                            guildFeedSquareFeedItemView = null;
                        }
                        Map<String, Object> C = guildFeedSquareFeedFunctionSection.C();
                        VideoReport.setElementId(guildFeedSquareFeedItemView, "em_sgrp_forum_feed");
                        VideoReport.setElementClickPolicy(guildFeedSquareFeedItemView, ClickPolicy.REPORT_NONE);
                        VideoReport.reportEvent("clck", guildFeedSquareFeedItemView, C);
                        ImageView imageView = (ImageView) view.findViewById(R.id.f165499wb4);
                        Drawable drawable = imageView != null ? imageView.getDrawable() : null;
                        GuildFeedImagePreDecoder guildFeedImagePreDecoder = GuildFeedImagePreDecoder.INSTANCE;
                        listOfNotNull = CollectionsKt__CollectionsKt.listOfNotNull(com.tencent.mobileqq.guild.feed.util.m.b(D).getUrl());
                        guildFeedImagePreDecoder.putIfAbsent(listOfNotNull, drawable);
                        if (((IGuildFeedNativeDetailApi) QRoute.api(IGuildFeedNativeDetailApi.class)).hasThirdVideo(D)) {
                            listOfNotNull2 = CollectionsKt__CollectionsKt.listOfNotNull(D.defaultBackgroundImg);
                            IGuildFeedImagePreDecoder.a.a(guildFeedImagePreDecoder, listOfNotNull2, null, 2, null);
                        }
                        guildFeedSquareFeedFunctionSection.K(D, 0, 1);
                    }
                }
            }, 2, null);
        }
        EventCollector.getInstance().onViewClicked(v3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        View findViewById = containerView.findViewById(R.id.wad);
        Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewBy\u2026ed_item_header_check_box)");
        this.checkBox = (QUICheckBox) findViewById;
        GuildFeedSquareFeedItemView guildFeedSquareFeedItemView = (GuildFeedSquareFeedItemView) containerView;
        this.feedItemView = guildFeedSquareFeedItemView;
        guildFeedSquareFeedItemView.setCombinedClickListener(200L, new GuildFeedSquareFeedFunctionSection$onInitView$1(this), new Function1<View, Unit>() { // from class: com.tencent.mobileqq.guild.feed.feedsquare.section.GuildFeedSquareFeedFunctionSection$onInitView$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                boolean b06;
                Intrinsics.checkNotNullParameter(it, "it");
                GuildFeedSquareFeedFunctionSection.this.X();
                b06 = GuildFeedSquareFeedFunctionSection.this.b0();
                if (b06) {
                    return;
                }
                GuildFeedSquareFeedFunctionSection.this.O();
                GuildFeedSquareFeedFunctionSection.this.Y(it);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        com.tencent.mobileqq.guild.feed.feedsquare.data.h hVar;
        yj1.f fVar;
        if (visible && (hVar = (com.tencent.mobileqq.guild.feed.feedsquare.data.h) this.mData) != null && (fVar = (yj1.f) SectionIOCKt.getIocInterface(this, yj1.f.class)) != null) {
            fVar.a(hVar.getBlockData(), this.mPosition);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X() {
    }
}
