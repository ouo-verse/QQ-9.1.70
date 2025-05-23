package com.tencent.mobileqq.guild.setting.member.view.topcard;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channelcard.AnimationControl;
import com.tencent.mobileqq.guild.channelcard.videoplay.c;
import com.tencent.mobileqq.guild.data.v;
import com.tencent.mobileqq.guild.discovery.widget.voiceavatar.MineVoiceAvatarLayout;
import com.tencent.mobileqq.guild.live.livemanager.player.GuildLivePlayerTag;
import com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberTopCardList;
import com.tencent.mobileqq.guild.util.QQGuildUIUtil;
import com.tencent.mobileqq.guild.util.cw;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProFeedSummary;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.richframework.thread.RFWThreadManager;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010+\u001a\u00020*\u0012\n\b\u0002\u0010-\u001a\u0004\u0018\u00010,\u00a2\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u000e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u0014\u0010\u000b\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bJ\u000e\u0010\u000e\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fJ\u0012\u0010\u0014\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u0018\u0010!\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberTopCardList;", "Landroid/widget/FrameLayout;", "Lcg1/b;", "f", "Landroidx/lifecycle/LifecycleOwner;", "owner", "", "e", "", "Ldg1/b;", "list", "g", "Ld02/b;", "listener", "setOnMemberCardItemClickListener", "", "show", "setOnlineChannelCardViewShow", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "Landroid/view/View;", "d", "Landroid/view/View;", "channelMemberCardContainer", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "listView", "Lcg1/a;", "Lcg1/a;", "channelCardAdapter", h.F, "Ld02/b;", "onCardItemClickListener", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/c;", "i", "Lcom/tencent/mobileqq/guild/channelcard/videoplay/c;", "visibleAreaVideoController", "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/channelcard/AnimationControl;", "animationControl", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildMemberTopCardList extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private View channelMemberCardContainer;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private RecyclerView listView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private cg1.a channelCardAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private d02.b onCardItemClickListener;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.guild.channelcard.videoplay.c visibleAreaVideoController;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private AnimationControl animationControl;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberTopCardList$a", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class a extends RecyclerView.ItemDecoration {
        a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            outRect.right = ViewUtils.dip2px(6.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberTopCardList$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "", "onScrollStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class b extends RecyclerView.OnScrollListener {
        b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@NotNull RecyclerView recyclerView, int newState) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                VideoReport.traverseExposure();
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\tH\u0016J \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J\u0018\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\fH\u0016J\u0018\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016\u00a8\u0006\u0019"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberTopCardList$d", "Lcg1/b;", "Lcom/tencent/mobileqq/guild/discovery/widget/voiceavatar/MineVoiceAvatarLayout;", "mediaAvatarLayout", "", "r1", "Landroid/view/View;", "cardView", "A0", "", "a", "itemView", "", "position", "Ldg1/b;", "itemData", ICustomDataEditor.STRING_PARAM_1, "", "channelId", "channelType", "z0", "channelInfo", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProFeedSummary;", "feedSummary", "q1", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class d implements cg1.b {
        d() {
        }

        @Override // cg1.b
        public void A0(@NotNull View cardView) {
            Intrinsics.checkNotNullParameter(cardView, "cardView");
            ViewGroup.LayoutParams layoutParams = cardView.getLayoutParams();
            dh1.a aVar = dh1.a.f393835a;
            layoutParams.width = aVar.e();
            layoutParams.height = aVar.d();
        }

        @Override // cg1.b
        public boolean a() {
            return GuildMemberTopCardList.this.animationControl.f();
        }

        @Override // cg1.b
        public void q1(@NotNull dg1.b channelInfo, @NotNull IGProFeedSummary feedSummary) {
            Intrinsics.checkNotNullParameter(channelInfo, "channelInfo");
            Intrinsics.checkNotNullParameter(feedSummary, "feedSummary");
            d02.b bVar = GuildMemberTopCardList.this.onCardItemClickListener;
            if (bVar != null) {
                bVar.q1(channelInfo, feedSummary);
            }
        }

        @Override // cg1.b
        public void r1(@NotNull MineVoiceAvatarLayout mediaAvatarLayout) {
            Intrinsics.checkNotNullParameter(mediaAvatarLayout, "mediaAvatarLayout");
            dh1.a aVar = dh1.a.f393835a;
            mediaAvatarLayout.setAvatarSizeAndHorizontalSpacing(aVar.b(), aVar.c());
            mediaAvatarLayout.setAvatarRatio(aVar.b() / ((int) cw.d(37)));
        }

        @Override // cg1.b
        public void s1(@NotNull View itemView, int position, @NotNull dg1.b itemData) {
            Map mapOf;
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            Intrinsics.checkNotNullParameter(itemData, "itemData");
            VideoReport.setElementId(itemView, "em_sgrp_member_list_online");
            VideoReport.setElementReuseIdentifier(itemView, itemData.getChannelId() + "_" + itemData.getCardType());
            VideoReport.setElementExposePolicy(itemView, ExposurePolicy.REPORT_ALL);
            VideoReport.setElementEndExposePolicy(itemView, EndExposurePolicy.REPORT_NONE);
            VideoReport.setElementClickPolicy(itemView, ClickPolicy.REPORT_ALL);
            mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("sgrp_channel_online_status", v.a(itemData.getChannelType())), TuplesKt.to("sgrp_sub_channel_id", String.valueOf(itemData.getChannelId())), TuplesKt.to("sgrp_user_place", Integer.valueOf(position)), TuplesKt.to("sgrp_channel_online_number", itemData.getMemberCount()), TuplesKt.to("sgrp_content_card_type", Integer.valueOf(itemData.getCardType())));
            VideoReport.setElementParams(itemView, mapOf);
        }

        @Override // cg1.b
        public void z0(@NotNull String channelId, int channelType) {
            Intrinsics.checkNotNullParameter(channelId, "channelId");
            d02.b bVar = GuildMemberTopCardList.this.onCardItemClickListener;
            if (bVar != null) {
                bVar.z0(channelId, channelType);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMemberTopCardList(@NotNull Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final cg1.b f() {
        return new d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h() {
        VideoReport.traverseExposure();
    }

    public final void e(@NotNull LifecycleOwner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.animationControl.e(owner);
        owner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.setting.member.view.topcard.GuildMemberTopCardList$attachToLifecycleOwner$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes14.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f234767a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f234767a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                c cVar;
                c cVar2;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = a.f234767a[event.ordinal()];
                if (i3 == 1) {
                    cVar = GuildMemberTopCardList.this.visibleAreaVideoController;
                    cVar.g();
                } else if (i3 == 2) {
                    cVar2 = GuildMemberTopCardList.this.visibleAreaVideoController;
                    cVar2.k();
                }
            }
        });
    }

    public final void g(@NotNull List<? extends dg1.b> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        this.channelCardAdapter.submitList(list);
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: d02.a
            @Override // java.lang.Runnable
            public final void run() {
                GuildMemberTopCardList.h();
            }
        });
        this.visibleAreaVideoController.g();
        setOnlineChannelCardViewShow(!list.isEmpty());
    }

    @Override // android.view.View
    protected void onConfigurationChanged(@Nullable Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (newConfig != null) {
            dh1.a.f393835a.g(QQGuildUIUtil.f(newConfig.screenWidthDp * 1.0f));
            cg1.a aVar = this.channelCardAdapter;
            aVar.notifyItemRangeChanged(0, aVar.getNUM_BACKGOURND_ICON(), 1);
        }
    }

    public final void setOnMemberCardItemClickListener(@NotNull d02.b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.onCardItemClickListener = listener;
    }

    public final void setOnlineChannelCardViewShow(boolean show) {
        boolean z16;
        boolean z17 = true;
        if (this.channelCardAdapter.getNUM_BACKGOURND_ICON() > 0 && show) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.channelMemberCardContainer.getVisibility() != 0) {
            z17 = false;
        }
        if (z16 == z17) {
            return;
        }
        if (z16) {
            this.visibleAreaVideoController.g();
            this.channelMemberCardContainer.setVisibility(0);
        } else {
            this.visibleAreaVideoController.k();
            this.channelMemberCardContainer.setVisibility(8);
        }
        VideoReport.traverseExposure();
    }

    public /* synthetic */ GuildMemberTopCardList(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildMemberTopCardList(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        dh1.a.f393835a.f();
        View.inflate(context, R.layout.ezt, this);
        View findViewById = findViewById(R.id.tne);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.card_container)");
        this.channelMemberCardContainer = findViewById;
        View findViewById2 = findViewById(R.id.to5);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.card_list)");
        this.listView = (RecyclerView) findViewById2;
        this.channelCardAdapter = new cg1.a(f());
        c cVar = new c();
        RecyclerView recyclerView = this.listView;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.setClipToPadding(false);
        recyclerView.setAdapter(this.channelCardAdapter);
        recyclerView.addOnItemTouchListener(cVar);
        recyclerView.addItemDecoration(new a());
        this.visibleAreaVideoController = new com.tencent.mobileqq.guild.channelcard.videoplay.c(GuildLivePlayerTag.MEMBER_LIST, this.listView, 0, 4, null);
        this.animationControl = new AnimationControl(this.listView);
        this.listView.addOnScrollListener(new b());
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/guild/setting/member/view/topcard/GuildMemberTopCardList$c", "Landroidx/recyclerview/widget/RecyclerView$OnItemTouchListener;", "Landroid/view/MotionEvent;", "e", "", "a", "Landroidx/recyclerview/widget/RecyclerView;", "rv", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "", "onTouchEvent", "disallowIntercept", "onRequestDisallowInterceptTouchEvent", "", "d", UserInfo.SEX_FEMALE, "mLastDownX", "mLastDownY", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class c implements RecyclerView.OnItemTouchListener {

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        private float mLastDownX;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private float mLastDownY;

        c() {
        }

        private final boolean a(MotionEvent e16) {
            if (Math.abs(this.mLastDownX - e16.getX()) > Math.abs(this.mLastDownY - e16.getY())) {
                return true;
            }
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public boolean onInterceptTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
            int action = e16.getAction();
            if (action != 0) {
                if (action == 2 && a(e16)) {
                    rv5.getParent().requestDisallowInterceptTouchEvent(true);
                    return false;
                }
                return false;
            }
            this.mLastDownX = e16.getX();
            this.mLastDownY = e16.getY();
            return false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onTouchEvent(@NotNull RecyclerView rv5, @NotNull MotionEvent e16) {
            Intrinsics.checkNotNullParameter(rv5, "rv");
            Intrinsics.checkNotNullParameter(e16, "e");
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
        }
    }
}
