package com.tencent.mobileqq.guild.discovery.search;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.mobileqq.guild.base.extension.m;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import ef1.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.TimeSource;
import kotlin.time.TimedValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\bB'\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\f\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002R\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryController;", "", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "owner", "", "b", "a", "Landroidx/lifecycle/LifecycleOwner;", "viewLifecycleOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryView;", "c", "Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryView;", "()Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryView;", "searchEntryView", "", "d", "I", "searchEntryPageType", "Lnh1/b;", "e", "Lnh1/b;", "viewModel", "<init>", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/ViewModelStoreOwner;Lcom/tencent/mobileqq/guild/discovery/search/GuildSearchEntryView;I)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildSearchEntryController {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LifecycleOwner viewLifecycleOwner;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ViewModelStoreOwner owner;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GuildSearchEntryView searchEntryView;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final int searchEntryPageType;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private nh1.b viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\u0006\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/discovery/search/GuildSearchEntryController$b", "Landroidx/lifecycle/ViewModelProvider$Factory;", "Landroidx/lifecycle/ViewModel;", "T", "Ljava/lang/Class;", "p0", OperateCustomButton.OPERATE_CREATE, "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements ViewModelProvider.Factory {
        @Override // androidx.lifecycle.ViewModelProvider.Factory
        @NotNull
        public <T extends ViewModel> T create(@NotNull Class<T> p06) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            TimedValue timedValue = new TimedValue(new nh1.b(), TimeSource.Monotonic.ValueTimeMark.m1966elapsedNowUwyO8pc(TimeSource.Monotonic.INSTANCE.m1963markNowz9LOYto()), null);
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildViewModelProvider", 2, "create " + m.a(timedValue.getValue()) + " cost " + Duration.m1875toStringimpl(timedValue.m1981getDurationUwyO8pc()));
            }
            return (T) timedValue.getValue();
        }
    }

    public GuildSearchEntryController(@NotNull LifecycleOwner viewLifecycleOwner, @NotNull ViewModelStoreOwner owner, @NotNull GuildSearchEntryView searchEntryView, int i3) {
        Intrinsics.checkNotNullParameter(viewLifecycleOwner, "viewLifecycleOwner");
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(searchEntryView, "searchEntryView");
        this.viewLifecycleOwner = viewLifecycleOwner;
        this.owner = owner;
        this.searchEntryView = searchEntryView;
        this.searchEntryPageType = i3;
        b(viewLifecycleOwner, owner);
    }

    private final void b(LifecycleOwner lifecycleOwner, ViewModelStoreOwner owner) {
        c.Companion companion = c.INSTANCE;
        this.viewModel = (nh1.b) new ViewModelProvider(owner, new b()).get(nh1.b.class);
        this.viewLifecycleOwner.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.discovery.search.GuildSearchEntryController$attach$2
            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                LifecycleOwner lifecycleOwner2;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Logger.f235387a.d().i("Guild.search.GuildSearchEntry", 1, "onStateChanged: " + event);
                if (event == Lifecycle.Event.ON_RESUME) {
                    if (GuildSearchEntryController.this.getSearchEntryView().isAttachedToWindow()) {
                        GuildSearchEntryController.this.getSearchEntryView().d();
                        GuildSearchEntryController.this.getSearchEntryView().f();
                    }
                } else if (event == Lifecycle.Event.ON_PAUSE && GuildSearchEntryController.this.getSearchEntryView().isAttachedToWindow()) {
                    GuildSearchEntryController.this.getSearchEntryView().e();
                }
                if (event == Lifecycle.Event.ON_DESTROY) {
                    lifecycleOwner2 = GuildSearchEntryController.this.viewLifecycleOwner;
                    lifecycleOwner2.getLifecycle().removeObserver(this);
                }
            }
        });
    }

    @NotNull
    /* renamed from: c, reason: from getter */
    public final GuildSearchEntryView getSearchEntryView() {
        return this.searchEntryView;
    }
}
