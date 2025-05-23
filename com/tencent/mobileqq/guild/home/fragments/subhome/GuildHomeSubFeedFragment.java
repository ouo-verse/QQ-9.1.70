package com.tencent.mobileqq.guild.home.fragments.subhome;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.PartFragmentIOCKt;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.event.GuildFeedsHomeJumpFeedChannelEvent;
import com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment;
import com.tencent.mobileqq.guild.home.parts.GuildHomeSubFeedPart;
import com.tencent.mobileqq.guild.home.viewmodels.e;
import com.tencent.mobileqq.guild.home.viewmodels.permission.GuildHomePermissionViewModel;
import com.tencent.mobileqq.guild.home.views.dialog.SingleOptionPopupWindow;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.report.IPerformanceReportTask;
import com.tencent.mobileqq.guild.util.GuildUIUtils;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.richframework.argus.node.ArgusTag;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@ArgusTag(testConfigKey = "Argus_Guild_Home_Feed", testTags = {"AUTO_PRELOAD"})
@Metadata(d1 = {"\u0000]\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f*\u0001\u0002\b\u0007\u0018\u0000 62\u00020\u0001:\u00017B\u0007\u00a2\u0006\u0004\b4\u00105J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\u0014\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0014J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016J\u0012\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016J\u001c\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0019\u001a\u00020\u0005H\u0016J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\b\u0010\u001b\u001a\u00020\tH\u0016R\u0016\u0010\u001e\u001a\u00020\u00148\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b \u0010!R\u001b\u0010(\u001a\u00020#8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001d\u0010-\u001a\u0004\u0018\u00010)8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b*\u0010%\u001a\u0004\b+\u0010,R\u0016\u0010/\u001a\u00020\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010\u001cR\u001b\u00103\u001a\u00020\u000f8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b0\u0010%\u001a\u0004\b1\u00102\u00a8\u00068"}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubFeedFragment;", "Lcom/tencent/mobileqq/guild/homev2/fragments/tabs/fragments/GuildHomeSubBaseFragment;", "com/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubFeedFragment$c", "Wh", "()Lcom/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubFeedFragment$c;", "", "Sh", "Qh", "", "", "", "Mh", "", "getContentLayoutId", "", "Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFeedPart;", "assembleParts", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "contentView", "onViewCreatedBeforePartInit", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "c6", "th", "I", "Landroid/view/View;", "rightActionLayout", "Landroid/widget/TextView;", "J", "Landroid/widget/TextView;", "rightActionText", "Lwo1/c;", "K", "Lkotlin/Lazy;", "Ph", "()Lwo1/c;", "preparedIoc", "Lcom/tencent/mobileqq/guild/home/views/dialog/SingleOptionPopupWindow;", "L", "Oh", "()Lcom/tencent/mobileqq/guild/home/views/dialog/SingleOptionPopupWindow;", "popupWindow", "M", "curSelectedPosition", "N", "Nh", "()Lcom/tencent/mobileqq/guild/home/parts/GuildHomeSubFeedPart;", "homeFeedContentPart", "<init>", "()V", "P", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSubFeedFragment extends com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment {

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Map<Integer, String> Q;

    @NotNull
    private static final Map<Integer, Integer> R;

    /* renamed from: I, reason: from kotlin metadata */
    private View rightActionLayout;

    /* renamed from: J, reason: from kotlin metadata */
    private TextView rightActionText;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy preparedIoc;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final Lazy popupWindow;

    /* renamed from: M, reason: from kotlin metadata */
    private int curSelectedPosition;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final Lazy homeFeedContentPart;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR#\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bR#\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubFeedFragment$a;", "", "", "", "", "OPTION_VALUE_MAP", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "OPTION_REPORT_MAP", "a", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment$a, reason: from kotlin metadata */
    /* loaded from: classes13.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Map<Integer, Integer> a() {
            return GuildHomeSubFeedFragment.R;
        }

        @NotNull
        public final Map<Integer, String> b() {
            return GuildHomeSubFeedFragment.Q;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f224835d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f224836e;

        public b(Object obj, Observer observer) {
            this.f224835d = obj;
            this.f224836e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f224835d)) != null) {
                this.f224836e.onChanged(b16);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001R\"\u0010\b\u001a\u00020\u00028\u0016@\u0016X\u0096\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005\"\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/home/fragments/subhome/GuildHomeSubFeedFragment$c", "Lwo1/c;", "", "a", "I", "()I", "b", "(I)V", "sortMode", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements wo1.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private int sortMode = 3;

        c() {
        }

        @Override // wo1.c
        /* renamed from: a, reason: from getter */
        public int getSortMode() {
            return this.sortMode;
        }

        @Override // wo1.c
        public void b(int i3) {
            this.sortMode = i3;
        }
    }

    static {
        Map<Integer, String> mapOf;
        Map<Integer, Integer> mapOf2;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(3, "\u65b0\u53d1\u8868"), TuplesKt.to(1, "\u65b0\u56de\u590d"), TuplesKt.to(2, "\u70ed\u95e8"));
        Q = mapOf;
        mapOf2 = MapsKt__MapsKt.mapOf(TuplesKt.to(3, 2), TuplesKt.to(1, 3), TuplesKt.to(2, 1));
        R = mapOf2;
    }

    public GuildHomeSubFeedFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<c>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment$preparedIoc$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeSubFeedFragment.c invoke() {
                GuildHomeSubFeedFragment.c Wh;
                Wh = GuildHomeSubFeedFragment.this.Wh();
                return Wh;
            }
        });
        this.preparedIoc = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<SingleOptionPopupWindow>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment$popupWindow$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final SingleOptionPopupWindow invoke() {
                Map Mh;
                Context context = GuildHomeSubFeedFragment.this.getContext();
                if (context == null) {
                    return null;
                }
                final GuildHomeSubFeedFragment guildHomeSubFeedFragment = GuildHomeSubFeedFragment.this;
                GuildHomeSubFeedFragment.Companion companion = GuildHomeSubFeedFragment.INSTANCE;
                Map<Integer, String> b16 = companion.b();
                Map<Integer, Integer> a16 = companion.a();
                Mh = guildHomeSubFeedFragment.Mh();
                return new SingleOptionPopupWindow(context, b16, a16, Mh, new Function3<Integer, Integer, String, Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment$popupWindow$2$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num, Integer num2, String str) {
                        invoke(num.intValue(), num2.intValue(), str);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3, int i16, @NotNull String selectedValue) {
                        wo1.c Ph;
                        mp1.b ph5;
                        Intrinsics.checkNotNullParameter(selectedValue, "selectedValue");
                        Ph = GuildHomeSubFeedFragment.this.Ph();
                        Ph.b(i16);
                        ph5 = GuildHomeSubFeedFragment.this.ph();
                        ph5.getGuildSubTabPageViewModel().N1(i16);
                    }
                });
            }
        });
        this.popupWindow = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<GuildHomeSubFeedPart>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment$homeFeedContentPart$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeSubFeedPart invoke() {
                JumpGuildParam rh5;
                mp1.b ph5;
                IPerformanceReportTask uh5;
                IPerformanceReportTask sh5;
                rh5 = GuildHomeSubFeedFragment.this.rh();
                ph5 = GuildHomeSubFeedFragment.this.ph();
                GuildHomePermissionViewModel guildHomePermissionViewModel = ph5.getGuildHomePermissionViewModel();
                uh5 = GuildHomeSubFeedFragment.this.uh();
                sh5 = GuildHomeSubFeedFragment.this.sh();
                return new GuildHomeSubFeedPart(rh5, guildHomePermissionViewModel, uh5, sh5);
            }
        });
        this.homeFeedContentPart = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Map<String, Object> Mh() {
        String str;
        Map<String, Object> mapOf;
        String string;
        Pair[] pairArr = new Pair[3];
        Bundle arguments = getArguments();
        String str2 = "";
        if (arguments == null || (str = arguments.getString("channelId")) == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("sgrp_sub_channel_id", str);
        pairArr[1] = TuplesKt.to("sgrp_section_type", 1);
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString("EXTRA_CATEGORY_NAME")) != null) {
            str2 = string;
        }
        pairArr[2] = TuplesKt.to("sgrp_section_name", str2);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return mapOf;
    }

    private final GuildHomeSubFeedPart Nh() {
        return (GuildHomeSubFeedPart) this.homeFeedContentPart.getValue();
    }

    private final SingleOptionPopupWindow Oh() {
        return (SingleOptionPopupWindow) this.popupWindow.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final wo1.c Ph() {
        return (wo1.c) this.preparedIoc.getValue();
    }

    private final void Qh() {
        LiveData<Integer> O1 = ph().getGuildSubTabPageViewModel().O1();
        LifecycleOwner lifecycleOwner = getLifecycleOwner();
        final Function1<Integer, Unit> function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment$initRightActionData$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                TextView textView;
                GuildHomeSubFeedFragment guildHomeSubFeedFragment = GuildHomeSubFeedFragment.this;
                Iterator<T> it = GuildHomeSubFeedFragment.INSTANCE.b().keySet().iterator();
                int i3 = 0;
                while (true) {
                    if (!it.hasNext()) {
                        i3 = -1;
                        break;
                    }
                    Object next = it.next();
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    if (num != null && ((Number) next).intValue() == num.intValue()) {
                        break;
                    } else {
                        i3++;
                    }
                }
                guildHomeSubFeedFragment.curSelectedPosition = i3;
                textView = GuildHomeSubFeedFragment.this.rightActionText;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("rightActionText");
                    textView = null;
                }
                textView.setText(GuildHomeSubFeedFragment.INSTANCE.b().get(num));
                Logger.f235387a.d().d("Guild.NewHome.subFrag.GuildHomeSubFeedFragment", 1, "feedSortMode changed " + num);
            }
        };
        O1.observe(lifecycleOwner, new Observer() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFeedFragment.Rh(Function1.this, obj);
            }
        });
        Ph().b(3);
        ph().getGuildSubTabPageViewModel().N1(3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Rh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final void Sh() {
        View view = null;
        View initRightActionLayout$lambda$3 = getLayoutInflater().inflate(R.layout.f168105eu2, (ViewGroup) null);
        initRightActionLayout$lambda$3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                GuildHomeSubFeedFragment.Th(GuildHomeSubFeedFragment.this, view2);
            }
        });
        Intrinsics.checkNotNullExpressionValue(initRightActionLayout$lambda$3, "initRightActionLayout$lambda$3");
        if1.a.b(initRightActionLayout$lambda$3, "em_sgrp_sort_btn", null, null, null, null, null, null, new IDynamicParams() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map Uh;
                Uh = GuildHomeSubFeedFragment.Uh(GuildHomeSubFeedFragment.this, str);
                return Uh;
            }
        }, 126, null);
        Intrinsics.checkNotNullExpressionValue(initRightActionLayout$lambda$3, "layoutInflater.inflate(R\u2026)\n            }\n        }");
        this.rightActionLayout = initRightActionLayout$lambda$3;
        View findViewById = initRightActionLayout$lambda$3.findViewById(R.id.f74453wa);
        Intrinsics.checkNotNullExpressionValue(findViewById, "rightActionLayout.findVi\u2026d(R.id.right_action_text)");
        this.rightActionText = (TextView) findViewById;
        View view2 = this.rightActionLayout;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
        } else {
            view = view2;
        }
        View findViewById2 = view.findViewById(R.id.f74433w9);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "rightActionLayout.findVi\u2026(R.id.right_action_image)");
        GuildUIUtils.d((ImageView) findViewById2, R.drawable.guild_feed_sort_icon, Integer.valueOf(R.color.qui_common_text_secondary));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Th(GuildHomeSubFeedFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SingleOptionPopupWindow Oh = this$0.Oh();
        if (Oh != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            Oh.p(it, this$0.curSelectedPosition);
        }
        EventCollector.getInstance().onViewClicked(it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map Uh(GuildHomeSubFeedFragment this$0, String str) {
        int i3;
        Map mapOf;
        Map plus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Map<String, Object> Mh = this$0.Mh();
        Integer num = R.get(Integer.valueOf(this$0.Ph().getSortMode()));
        if (num != null) {
            i3 = num.intValue();
        } else {
            i3 = -1;
        }
        mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("sgrp_sort_type", Integer.valueOf(i3)));
        plus = MapsKt__MapsKt.plus(Mh, mapOf);
        return plus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Vh(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c Wh() {
        return new c();
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<GuildHomeSubFeedPart> assembleParts() {
        List<GuildHomeSubFeedPart> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(Nh());
        return mutableListOf;
    }

    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment, com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.b
    @NotNull
    public View c6() {
        View view = this.rightActionLayout;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rightActionLayout");
            return null;
        }
        return view;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f168103eu0;
    }

    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment, com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Sh();
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFeedFragment", 1, "onCreate id:" + System.identityHashCode(this));
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        PartFragmentIOCKt.unregisterIoc(this, wo1.c.class);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.subFrag.GuildHomeSubFeedFragment", 1, "onDestroy id:" + System.identityHashCode(this));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        LiveData<ef1.a<e.FeedSquareSwitchEvent>> P1 = ph().getGuildSubTabPageViewModel().P1();
        final GuildHomeSubFeedFragment$onViewCreated$1 guildHomeSubFeedFragment$onViewCreated$1 = new Function1<e.FeedSquareSwitchEvent, Unit>() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.GuildHomeSubFeedFragment$onViewCreated$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e.FeedSquareSwitchEvent feedSquareSwitchEvent) {
                invoke2(feedSquareSwitchEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e.FeedSquareSwitchEvent feedSquareSwitchEvent) {
                SimpleEventBus.getInstance().dispatchEvent(new GuildFeedsHomeJumpFeedChannelEvent(feedSquareSwitchEvent.getGuildId(), feedSquareSwitchEvent.getChannelId()));
                Logger.f235387a.d().d("Guild.NewHome.subFrag.GuildHomeSubFeedFragment", 1, "feedSwitchEvent " + feedSquareSwitchEvent.getGuildId() + " " + feedSquareSwitchEvent.getChannelId());
            }
        };
        P1.observe(this, new b(null, new Observer() { // from class: com.tencent.mobileqq.guild.home.fragments.subhome.a
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeSubFeedFragment.Vh(Function1.this, obj);
            }
        }));
        Qh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedBeforePartInit(@Nullable View contentView, @Nullable Bundle savedInstanceState) {
        super.onViewCreatedBeforePartInit(contentView, savedInstanceState);
        PartFragmentIOCKt.registerIoc(this, Ph(), wo1.c.class);
    }

    @Override // com.tencent.mobileqq.guild.homev2.fragments.tabs.fragments.GuildHomeSubBaseFragment
    @NotNull
    public String th() {
        return "Guild.NewHome.subFrag.GuildHomeSubFeedFragment";
    }
}
