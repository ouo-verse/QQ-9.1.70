package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.view.View;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.channel.create.CreateSubChannelInfo;
import com.tencent.mobileqq.guild.channel.create.dialog.QQGuildSubChannelCreateMainDialogFragment;
import com.tencent.mobileqq.guild.home.subhome.c;
import com.tencent.mobileqq.guild.home.viewmodels.e;
import com.tencent.mobileqq.guild.mainframe.startpanel.rightpart.facade.FacadeArgsData;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\r\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0015\u001a\u00020\u00128\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0019\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildHomeCreateLivePart;", "Lcom/tencent/biz/richframework/part/Part;", "", "D9", "Landroid/view/View;", "curRootView", "G9", "view", "J9", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartResume", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "d", "Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;", "facadeArgsData", "Lcom/tencent/mobileqq/guild/home/subhome/e;", "e", "Lcom/tencent/mobileqq/guild/home/subhome/e;", "activeChannelViewModel", "Lmp1/b;", "f", "Lmp1/b;", "homeViewModel", tl.h.F, "Landroid/view/View;", "mLiveSubFragmentView", "", "i", "Z", "mHasBindView", "<init>", "(Lcom/tencent/mobileqq/guild/mainframe/startpanel/rightpart/facade/FacadeArgsData;Lcom/tencent/mobileqq/guild/home/subhome/e;Lmp1/b;)V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeCreateLivePart extends Part {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final FacadeArgsData facadeArgsData;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.guild.home.subhome.e activeChannelViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final mp1.b homeViewModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View mLiveSubFragmentView;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean mHasBindView;

    @Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0005\u001a\u00020\u0004\"\u0006\b\u0000\u0010\u0000\u0018\u00012\u001a\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00028\u0000 \u0002*\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00010\u0001H\n\u00a2\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"T", "Lef1/a;", "kotlin.jvm.PlatformType", "it", "", "a", "(Lef1/a;)V"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b<T> implements Observer {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Object f224920d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Observer f224921e;

        public b(Object obj, Observer observer) {
            this.f224920d = obj;
            this.f224921e = observer;
        }

        @Override // androidx.lifecycle.Observer
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public final void onChanged(ef1.a<T> aVar) {
            T b16;
            if (aVar != null && (b16 = aVar.b(this.f224920d)) != null) {
                this.f224921e.onChanged(b16);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0007\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Landroid/view/View;", "kotlin.jvm.PlatformType", "it", "", NodeProps.ON_CLICK, "(Landroid/view/View;)V", "com/tencent/mobileqq/guild/base/extension/l", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class c implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f224922d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ GuildHomeCreateLivePart f224923e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Ref.LongRef f224924f;

        public c(View view, GuildHomeCreateLivePart guildHomeCreateLivePart, Ref.LongRef longRef) {
            this.f224922d = view;
            this.f224923e = guildHomeCreateLivePart;
            this.f224924f = longRef;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (!com.tencent.mobileqq.guild.util.o.c("fastClickGuard")) {
                String str = this.f224923e.facadeArgsData.f227656e;
                Logger.f235387a.d().i("Guild.NewHome.GuildHomeCreateLivePart", 1, "click createLive, guildId: " + str + ", categoryId:" + this.f224924f.element);
                Fragment hostFragment = this.f224923e.getHostFragment();
                if (hostFragment != null) {
                    Intrinsics.checkNotNullExpressionValue(hostFragment, "hostFragment");
                    QQGuildSubChannelCreateMainDialogFragment Eh = QQGuildSubChannelCreateMainDialogFragment.Eh(new CreateSubChannelInfo(str, this.f224924f.element, "sub_live"));
                    FragmentManager fragmentManager = hostFragment.getFragmentManager();
                    Intrinsics.checkNotNull(fragmentManager);
                    Eh.show(fragmentManager, "Guild.NewHome.GuildHomeCreateLivePart");
                } else {
                    Logger.b bVar = new Logger.b();
                    String str2 = "part's hostFragment is null, guildId: " + str + ", categoryId:" + this.f224924f.element;
                    if (str2 instanceof String) {
                        bVar.a().add(str2);
                    }
                    Iterator<T> it = bVar.a().iterator();
                    while (it.hasNext()) {
                        Logger.f235387a.d().e("Guild.NewHome.GuildHomeCreateLivePart", 1, (String) it.next(), null);
                    }
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public GuildHomeCreateLivePart(@NotNull FacadeArgsData facadeArgsData, @NotNull com.tencent.mobileqq.guild.home.subhome.e activeChannelViewModel, @NotNull mp1.b homeViewModel) {
        Intrinsics.checkNotNullParameter(facadeArgsData, "facadeArgsData");
        Intrinsics.checkNotNullParameter(activeChannelViewModel, "activeChannelViewModel");
        Intrinsics.checkNotNullParameter(homeViewModel, "homeViewModel");
        this.facadeArgsData = facadeArgsData;
        this.activeChannelViewModel = activeChannelViewModel;
        this.homeViewModel = homeViewModel;
    }

    private final void D9() {
        if (this.mHasBindView) {
            return;
        }
        View view = this.mLiveSubFragmentView;
        boolean z16 = false;
        if (view != null && view.isAttachedToWindow()) {
            z16 = true;
        }
        if (!z16) {
            Logger.f235387a.d().w("Guild.NewHome.GuildHomeCreateLivePart", 1, "bindViews !rootView.isAttachedToWindow");
            return;
        }
        View view2 = this.mLiveSubFragmentView;
        Intrinsics.checkNotNull(view2);
        final View G9 = G9(view2);
        if (G9 == null) {
            Logger.f235387a.d().w("Guild.NewHome.GuildHomeCreateLivePart", 1, "bindViews failed getGuildCreateLiveLayoutFrame!");
            return;
        }
        this.mHasBindView = true;
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.NewHome.GuildHomeCreateLivePart", 1, "bindViews execute");
        }
        G9.findViewById(R.id.f165121uz1).setBackgroundResource(R.drawable.guild_home_action_icon_bg);
        ((ImageView) G9.findViewById(R.id.f165120uz0)).setImageResource(R.drawable.guild_token_tab_icon_add);
        J9(G9);
        final Ref.LongRef longRef = new Ref.LongRef();
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        final Ref.BooleanRef booleanRef2 = new Ref.BooleanRef();
        LiveData<ef1.a<e.SelectTabEvent>> Q1 = this.homeViewModel.getGuildSubTabPageViewModel().Q1();
        LifecycleOwner a16 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<e.SelectTabEvent, Unit> function1 = new Function1<e.SelectTabEvent, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeCreateLivePart$delayBindViews$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(e.SelectTabEvent selectTabEvent) {
                invoke2(selectTabEvent);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(e.SelectTabEvent selectTabEvent) {
                Ref.LongRef longRef2 = Ref.LongRef.this;
                c.GuildHomeSubTabData tabData = selectTabEvent.getTabData();
                longRef2.element = tabData != null ? tabData.getCategoryId() : 0L;
                Ref.BooleanRef booleanRef3 = booleanRef2;
                c.GuildHomeSubTabData tabData2 = selectTabEvent.getTabData();
                booleanRef3.element = tabData2 != null && tabData2.getType() == 3;
                G9.setVisibility(booleanRef2.element && booleanRef.element ? 0 : 8);
            }
        };
        Q1.observe(a16, new b(this, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.r
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeCreateLivePart.E9(Function1.this, obj);
            }
        }));
        LiveData<Boolean> W1 = this.activeChannelViewModel.W1();
        LifecycleOwner a17 = com.tencent.mobileqq.guild.discoveryv2.content.part.d.a(this);
        final Function1<Boolean, Unit> function12 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildHomeCreateLivePart$delayBindViews$5
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Ref.BooleanRef booleanRef3 = Ref.BooleanRef.this;
                Intrinsics.checkNotNullExpressionValue(it, "it");
                booleanRef3.element = it.booleanValue();
                G9.setVisibility(booleanRef2.element && Ref.BooleanRef.this.element ? 0 : 8);
            }
        };
        W1.observe(a17, new Observer() { // from class: com.tencent.mobileqq.guild.home.parts.s
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildHomeCreateLivePart.F9(Function1.this, obj);
            }
        });
        G9.setOnClickListener(new c(G9, this, longRef));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    private final View G9(View curRootView) {
        while (curRootView.getParent() != null) {
            View findViewById = curRootView.findViewById(R.id.w39);
            if (findViewById != null) {
                return findViewById;
            }
            Object parent = curRootView.getParent();
            Intrinsics.checkNotNull(parent, "null cannot be cast to non-null type android.view.View");
            curRootView = (View) parent;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H9(GuildHomeCreateLivePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void I9(GuildHomeCreateLivePart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.D9();
    }

    private final void J9(View view) {
        com.tencent.mobileqq.guild.api.impl.e.c(view, "em_sgrp_create_new_stream");
        com.tencent.mobileqq.guild.api.impl.e.b(view, "2");
        com.tencent.mobileqq.guild.api.impl.e.d(view, "1");
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        super.onInitView(rootView);
        this.mLiveSubFragmentView = rootView;
        if (rootView != null) {
            rootView.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.p
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeCreateLivePart.H9(GuildHomeCreateLivePart.this);
                }
            }, 100L);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartResume(@Nullable Activity activity) {
        super.onPartResume(activity);
        View view = this.mLiveSubFragmentView;
        if (view != null) {
            view.postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.home.parts.q
                @Override // java.lang.Runnable
                public final void run() {
                    GuildHomeCreateLivePart.I9(GuildHomeCreateLivePart.this);
                }
            }, 100L);
        }
    }
}
