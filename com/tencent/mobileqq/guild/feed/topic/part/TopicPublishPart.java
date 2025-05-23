package com.tencent.mobileqq.guild.feed.topic.part;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.feed.feedsquare.utils.GuildFeedDraftHelper;
import com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildPublishV2Layout;
import com.tencent.mobileqq.guild.feed.manager.GuildInfoManager;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 -2\u00020\u0001:\u0001.B\u0007\u00a2\u0006\u0004\b+\u0010,J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010#\u001a\u00020\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010 R\u0018\u0010&\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/topic/part/TopicPublishPart;", "Lcom/tencent/mobileqq/guild/feed/topic/part/TopicBasePart;", "", "R9", "", "guildId", "topicId", "", "Y9", "S9", "ba", "ca", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Lkotlinx/coroutines/Job;", tl.h.F, "Lkotlinx/coroutines/Job;", "mDraftJob", "i", "Ljava/lang/CharSequence;", "mDraftText", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "mDraftMediaSize", "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildPublishV2Layout;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/guild/feed/feedsquare/widget/GuildPublishV2Layout;", "mEditLayout", "", "D", "Z", "mIsMute", "E", "mCanPublish", UserInfo.SEX_FEMALE, "Ljava/lang/Boolean;", "mIsMember", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "G", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "mInfoManagerViewModel", "<init>", "()V", "H", "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class TopicPublishPart extends TopicBasePart {

    /* renamed from: C, reason: from kotlin metadata */
    private GuildPublishV2Layout mEditLayout;

    /* renamed from: D, reason: from kotlin metadata */
    private boolean mIsMute;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private Boolean mIsMember;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.guild.feed.viewmodel.k mInfoManagerViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Job mDraftJob;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private CharSequence mDraftText = "";

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mDraftMediaSize = -1;

    /* renamed from: E, reason: from kotlin metadata */
    private boolean mCanPublish = true;

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001e\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/guild/feed/topic/part/TopicPublishPart$b", "Lcom/tencent/qqlive/module/videoreport/data/IDynamicParams;", "", "event", "", "", "getDynamicParams", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements IDynamicParams {
        b() {
        }

        @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
        @NotNull
        public Map<String, Object> getDynamicParams(@Nullable String event) {
            String str;
            Map<String, Object> mutableMapOf;
            Pair[] pairArr = new Pair[1];
            if (TextUtils.isEmpty(TopicPublishPart.this.mDraftText) && TopicPublishPart.this.mDraftMediaSize <= 0) {
                str = "0";
            } else {
                str = "1";
            }
            pairArr[0] = TuplesKt.to("sgrp_forum_editor_type", str);
            mutableMapOf = MapsKt__MapsKt.mutableMapOf(pairArr);
            return mutableMapOf;
        }
    }

    private final CharSequence R9() {
        CharSequence trim;
        String removePrefix;
        trim = StringsKt__StringsKt.trim((CharSequence) z9().getTopicNameRef());
        removePrefix = StringsKt__StringsKt.removePrefix(trim.toString(), (CharSequence) "#");
        String str = "#" + removePrefix;
        return (getContext().getResources().getString(R.string.f158011og) + " ") + str;
    }

    private final void S9() {
        if (this.mInfoManagerViewModel == null) {
            this.mInfoManagerViewModel = (com.tencent.mobileqq.guild.feed.viewmodel.k) getViewModel(com.tencent.mobileqq.guild.feed.viewmodel.k.class);
        }
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar);
        kVar.X1(z9().getGuildId());
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar2 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar2);
        kVar2.T1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.i
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicPublishPart.T9(TopicPublishPart.this, (Long) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar3 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar3);
        kVar3.L1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.j
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicPublishPart.U9(TopicPublishPart.this, (Long) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar4 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar4);
        kVar4.U1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.k
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicPublishPart.V9(TopicPublishPart.this, (Boolean) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar5 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar5);
        kVar5.O1().observe(getHostFragment(), new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.l
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicPublishPart.W9(TopicPublishPart.this, (Boolean) obj);
            }
        });
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar6 = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar6);
        MutableLiveData<Boolean> Q1 = kVar6.Q1();
        if (Q1 != null) {
            Fragment hostFragment = getHostFragment();
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicPublishPart$initInfoViewModel$5
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean bool) {
                    com.tencent.mobileqq.guild.feed.viewmodel.k kVar7;
                    Boolean bool2;
                    QLog.d("GuildFeedSquareV2PublishPart", 4, "[isMemberStateChange] = " + bool);
                    kVar7 = TopicPublishPart.this.mInfoManagerViewModel;
                    Intrinsics.checkNotNull(kVar7);
                    boolean P1 = kVar7.P1();
                    bool2 = TopicPublishPart.this.mIsMember;
                    if (Intrinsics.areEqual(bool2, Boolean.valueOf(P1))) {
                        return;
                    }
                    TopicPublishPart.this.mIsMember = Boolean.valueOf(P1);
                    TopicPublishPart.this.ca();
                }
            };
            Q1.observe(hostFragment, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.m
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TopicPublishPart.X9(Function1.this, obj);
                }
            });
        }
        GuildInfoManager.q().R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T9(TopicPublishPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U9(TopicPublishPart this$0, Long l3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void V9(TopicPublishPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hj1.b.b("GuildFeedSquareV2PublishPart", "observe getsRestrictPostLiveData = " + bool);
        this$0.ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(TopicPublishPart this$0, Boolean bool) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ba();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void X9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Y9(String guildId, String topicId) {
        hj1.b.b("TopicPublishPart", "[observeFeedDraft] mGuildId=" + guildId + " , topicId=" + topicId);
        if (this.mDraftJob == null) {
            this.mDraftJob = GuildFeedDraftHelper.f219277a.c(com.tencent.mobileqq.guild.feed.part.a.d(this), guildId, "", topicId, 3, new Function2<CharSequence, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicPublishPart$observeFeedDraft$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                private static final void a(TopicPublishPart topicPublishPart, CharSequence charSequence, int i3) {
                    topicPublishPart.mDraftText = charSequence;
                    topicPublishPart.mDraftMediaSize = i3;
                    topicPublishPart.ca();
                    CharSequence charSequence2 = topicPublishPart.mDraftText;
                    hj1.b.b("TopicPublishPart", "[feedDraftFlow] mDraftText=" + ((Object) charSequence2) + ", mDraftMediaSize=" + topicPublishPart.mDraftMediaSize);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(CharSequence charSequence, Integer num) {
                    invoke(charSequence, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(@NotNull CharSequence draft, int i3) {
                    Intrinsics.checkNotNullParameter(draft, "draft");
                    if (Intrinsics.areEqual(draft.toString(), TopicPublishPart.this.mDraftText.toString()) && i3 == TopicPublishPart.this.mDraftMediaSize) {
                        return;
                    }
                    CharSequence charSequence = TopicPublishPart.this.mDraftText;
                    QLog.d("TopicPublishPart", 1, " draft= " + ((Object) draft) + " , mDraftText =" + ((Object) charSequence) + " , mediaSize = " + i3 + " , mDraftMediaSize= " + TopicPublishPart.this.mDraftMediaSize);
                    a(TopicPublishPart.this, draft, i3);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(TopicPublishPart this$0, View rootView, View view) {
        boolean z16;
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(rootView, "$rootView");
        if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
            if (this$0.mCanPublish) {
                xn1.e eVar = xn1.e.f448187a;
                Context context = rootView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
                long topicId = this$0.z9().getTopicId();
                String topicNameRef = this$0.z9().getTopicNameRef();
                String guildId = this$0.z9().getGuildId();
                if (this$0.mDraftText.length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                eVar.m(context, topicId, topicNameRef, guildId, z16, this$0.R9());
            } else {
                com.tencent.mobileqq.guild.feed.feedsquare.utils.j jVar = com.tencent.mobileqq.guild.feed.feedsquare.utils.j.f219338a;
                Activity activity = this$0.getActivity();
                Intrinsics.checkNotNullExpressionValue(activity, "activity");
                com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this$0.mInfoManagerViewModel;
                Intrinsics.checkNotNull(kVar);
                com.tencent.mobileqq.guild.util.qqui.g.f(-1, jVar.d(activity, kVar));
            }
            VideoReport.reportEvent("clck", view, null);
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void aa(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void ba() {
        com.tencent.mobileqq.guild.feed.viewmodel.k kVar = this.mInfoManagerViewModel;
        Intrinsics.checkNotNull(kVar);
        boolean b26 = kVar.b2();
        if (this.mIsMute != b26) {
            this.mIsMute = b26;
            ca();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void ca() {
        GuildPublishV2Layout guildPublishV2Layout;
        if (Intrinsics.areEqual(this.mIsMember, Boolean.FALSE)) {
            return;
        }
        boolean z16 = this.mIsMute;
        this.mCanPublish = !z16;
        GuildPublishV2Layout guildPublishV2Layout2 = null;
        if (z16) {
            GuildPublishV2Layout guildPublishV2Layout3 = this.mEditLayout;
            if (guildPublishV2Layout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
                guildPublishV2Layout = null;
            } else {
                guildPublishV2Layout = guildPublishV2Layout3;
            }
            String string = getContext().getString(R.string.f1522719y);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.te\u2026_new_feed_not_permission)");
            GuildPublishV2Layout.e(guildPublishV2Layout, string, getContext().getResources().getColor(R.color.qui_common_text_secondary_light), 0, 4, null);
            GuildPublishV2Layout guildPublishV2Layout4 = this.mEditLayout;
            if (guildPublishV2Layout4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
                guildPublishV2Layout4 = null;
            }
            guildPublishV2Layout4.setBackgroundResource(R.drawable.guild_input_view_background_normal);
        } else {
            if (TextUtils.isEmpty(this.mDraftText)) {
                GuildPublishV2Layout guildPublishV2Layout5 = this.mEditLayout;
                if (guildPublishV2Layout5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
                    guildPublishV2Layout5 = null;
                }
                guildPublishV2Layout5.d(R9(), getContext().getResources().getColor(R.color.qui_common_text_secondary), this.mDraftMediaSize);
            } else {
                GuildPublishV2Layout guildPublishV2Layout6 = this.mEditLayout;
                if (guildPublishV2Layout6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
                    guildPublishV2Layout6 = null;
                }
                guildPublishV2Layout6.d(this.mDraftText, getContext().getResources().getColor(R.color.qui_common_text_primary), this.mDraftMediaSize);
            }
            GuildPublishV2Layout guildPublishV2Layout7 = this.mEditLayout;
            if (guildPublishV2Layout7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
                guildPublishV2Layout7 = null;
            }
            guildPublishV2Layout7.setBackgroundResource(R.drawable.guild_input_view_background);
        }
        GuildPublishV2Layout guildPublishV2Layout8 = this.mEditLayout;
        if (guildPublishV2Layout8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
        } else {
            guildPublishV2Layout2 = guildPublishV2Layout8;
        }
        guildPublishV2Layout2.invalidate();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull final View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        View findViewById = rootView.findViewById(R.id.f165505wd0);
        findViewById.setBackgroundResource(R.drawable.guild_input_view_background);
        Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type com.tencent.mobileqq.guild.feed.feedsquare.widget.GuildPublishV2Layout");
        GuildPublishV2Layout guildPublishV2Layout = (GuildPublishV2Layout) findViewById;
        this.mEditLayout = guildPublishV2Layout;
        guildPublishV2Layout.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.feed.topic.part.g
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TopicPublishPart.Z9(TopicPublishPart.this, rootView, view);
            }
        });
        S9();
        Y9(z9().getGuildId(), String.valueOf(z9().getTopicId()));
        GuildPublishV2Layout guildPublishV2Layout2 = this.mEditLayout;
        if (guildPublishV2Layout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
            guildPublishV2Layout2 = null;
        }
        if1.a.b(guildPublishV2Layout2, "em_sgrp_forum_editor", null, null, null, ClickPolicy.REPORT_NONE, null, null, new b(), 110, null);
        ca();
        MutableLiveData<Boolean> q26 = A9().q2();
        LifecycleOwner c16 = com.tencent.mobileqq.guild.feed.part.a.c(this);
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.feed.topic.part.TopicPublishPart$onInitView$4
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean it) {
                GuildPublishV2Layout guildPublishV2Layout3;
                GuildPublishV2Layout guildPublishV2Layout4;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                GuildPublishV2Layout guildPublishV2Layout5 = null;
                if (it.booleanValue()) {
                    guildPublishV2Layout4 = TopicPublishPart.this.mEditLayout;
                    if (guildPublishV2Layout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
                    } else {
                        guildPublishV2Layout5 = guildPublishV2Layout4;
                    }
                    guildPublishV2Layout5.setVisibility(0);
                    return;
                }
                guildPublishV2Layout3 = TopicPublishPart.this.mEditLayout;
                if (guildPublishV2Layout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEditLayout");
                } else {
                    guildPublishV2Layout5 = guildPublishV2Layout3;
                }
                guildPublishV2Layout5.setVisibility(8);
            }
        };
        q26.observe(c16, new Observer() { // from class: com.tencent.mobileqq.guild.feed.topic.part.h
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                TopicPublishPart.aa(Function1.this, obj);
            }
        });
    }
}
