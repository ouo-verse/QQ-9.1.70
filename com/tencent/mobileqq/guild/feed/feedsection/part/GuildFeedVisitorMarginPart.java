package com.tencent.mobileqq.guild.feed.feedsection.part;

import android.view.View;
import androidx.core.util.Supplier;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.api.IGuildHomeApi;
import com.tencent.mobileqq.guild.feed.launcher.GuildFeedBaseInitBean;
import com.tencent.mobileqq.guild.feed.viewmodel.k;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001bB\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t\u00a2\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R\u001f\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/feed/feedsection/part/GuildFeedVisitorMarginPart;", "Lcom/tencent/biz/richframework/part/Part;", "Landroidx/recyclerview/widget/RecyclerView;", "view", "", "B9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroidx/core/util/Supplier;", "Lcom/tencent/mobileqq/guild/feed/launcher/GuildFeedBaseInitBean;", "d", "Landroidx/core/util/Supplier;", "getMInitBean", "()Landroidx/core/util/Supplier;", "mInitBean", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "e", "Lcom/tencent/mobileqq/guild/feed/viewmodel/k;", "guildInfoManagerViewModel", "", "f", "Z", "isMember", "<init>", "(Landroidx/core/util/Supplier;)V", h.F, "a", "qqguild_feed_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFeedVisitorMarginPart extends Part {

    /* renamed from: i, reason: collision with root package name */
    private static final int f218687i = com.tencent.guild.aio.util.c.b(60);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Supplier<GuildFeedBaseInitBean> mInitBean;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private k guildInfoManagerViewModel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isMember;

    public GuildFeedVisitorMarginPart(@NotNull Supplier<GuildFeedBaseInitBean> mInitBean) {
        Intrinsics.checkNotNullParameter(mInitBean, "mInitBean");
        this.mInitBean = mInitBean;
        this.isMember = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A9(GuildFeedVisitorMarginPart this$0, RecyclerView recyclerView, Boolean it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.d("GuildFeedVisitorMarginPart", 1, "isMemberLiveData updated, newVal = " + it);
        if (!Intrinsics.areEqual(Boolean.valueOf(this$0.isMember), it)) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            this$0.isMember = it.booleanValue();
            if (recyclerView != null) {
                this$0.B9(recyclerView);
            }
        }
    }

    private final void B9(RecyclerView view) {
        if (this.isMember) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
        } else {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), ((IGuildHomeApi) QRoute.api(IGuildHomeApi.class)).getVisitorBarHeight() - f218687i);
            view.setClipToPadding(false);
        }
        QLog.d("GuildFeedVisitorMarginPart", 1, "view.updatePadding(bottom = " + view.getPaddingBottom());
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        final RecyclerView recyclerView;
        k kVar = (k) getViewModel(k.class);
        this.guildInfoManagerViewModel = kVar;
        if (kVar == null) {
            QLog.e("GuildFeedVisitorMarginPart", 1, "[onInitView] guildInfoManagerViewModel is null!");
            return;
        }
        GuildFeedBaseInitBean guildFeedBaseInitBean = this.mInitBean.get();
        if (guildFeedBaseInitBean == null) {
            QLog.e("GuildFeedVisitorMarginPart", 1, "[onInitView] mInitBean is null!");
            return;
        }
        if (guildFeedBaseInitBean.getBusinessType() == 15) {
            k kVar2 = this.guildInfoManagerViewModel;
            if (kVar2 != null) {
                kVar2.Z1(guildFeedBaseInitBean.getGuildId(), guildFeedBaseInitBean.getChannelId());
            }
        } else {
            k kVar3 = this.guildInfoManagerViewModel;
            if (kVar3 != null) {
                kVar3.X1(guildFeedBaseInitBean.getGuildId());
            }
        }
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.wen);
        } else {
            recyclerView = null;
        }
        final Observer observer = new Observer() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.g
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                GuildFeedVisitorMarginPart.A9(GuildFeedVisitorMarginPart.this, recyclerView, (Boolean) obj);
            }
        };
        com.tencent.mobileqq.guild.feed.part.a.c(this).getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.feed.feedsection.part.GuildFeedVisitorMarginPart$onInitView$1

            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes13.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f218693a;

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
                    f218693a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                k kVar4;
                MutableLiveData<Boolean> Q1;
                k kVar5;
                MutableLiveData<Boolean> Q12;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                int i3 = a.f218693a[event.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        kVar5 = GuildFeedVisitorMarginPart.this.guildInfoManagerViewModel;
                        if (kVar5 != null && (Q12 = kVar5.Q1()) != null) {
                            Q12.removeObserver(observer);
                        }
                        QLog.i("GuildFeedVisitorMarginPart", 1, "globalLiveData observer unregistered");
                        return;
                    }
                    return;
                }
                QLog.i("GuildFeedVisitorMarginPart", 1, "globalLiveData observer registered");
                kVar4 = GuildFeedVisitorMarginPart.this.guildInfoManagerViewModel;
                if (kVar4 != null && (Q1 = kVar4.Q1()) != null) {
                    Q1.observe(com.tencent.mobileqq.guild.feed.part.a.c(GuildFeedVisitorMarginPart.this), observer);
                }
            }
        });
    }
}
