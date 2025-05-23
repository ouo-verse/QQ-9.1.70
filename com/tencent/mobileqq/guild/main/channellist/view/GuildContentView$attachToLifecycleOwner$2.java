package com.tencent.mobileqq.guild.main.channellist.view;

import android.view.ViewParent;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import ar1.j;
import com.tencent.mobileqq.guild.widget.y;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/guild/main/channellist/view/GuildContentView$attachToLifecycleOwner$2", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", "event", "", "onStateChanged", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildContentView$attachToLifecycleOwner$2 implements LifecycleEventObserver {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ GuildContentView f227125d;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f227126a;

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
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f227126a = iArr;
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
        j jVar;
        j jVar2;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        QLog.i("Guild.MF.GuildContentView", 1, "onStateChanged " + source + ", " + event);
        int i3 = a.f227126a[event.ordinal()];
        j jVar3 = null;
        ViewParent viewParent = null;
        j jVar4 = null;
        if (i3 == 1) {
            jVar = this.f227125d.summaryUpdateHelper;
            if (jVar == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryUpdateHelper");
            } else {
                jVar3 = jVar;
            }
            jVar3.b();
            return;
        }
        if (i3 == 2) {
            jVar2 = this.f227125d.summaryUpdateHelper;
            if (jVar2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("summaryUpdateHelper");
            } else {
                jVar4 = jVar2;
            }
            jVar4.a();
            return;
        }
        if (i3 == 3) {
            ViewParent parent = this.f227125d.getParent();
            while (true) {
                if (parent == null) {
                    break;
                }
                if (parent instanceof y) {
                    viewParent = parent;
                    break;
                }
                parent = parent.getParent();
            }
            y yVar = (y) viewParent;
            if (yVar != null) {
                recyclerView2 = this.f227125d.recyclerView;
                yVar.removeRecyclerView(recyclerView2);
            }
            source.getLifecycle().removeObserver(this);
            recyclerView = this.f227125d.recyclerView;
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.endAnimations();
            }
        }
    }
}
