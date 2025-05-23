package com.tencent.mobileqq.guild.homev2.misc.logics;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.guild.homev2.misc.logics.GuildHomeSaveStateLogic;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\f*\u00020\u000b2\u0006\u0010\r\u001a\u00028\u0000\u00a2\u0006\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013\u00b2\u0006\u0016\u0010\u0005\u001a\u00020\b\"\b\b\u0000\u0010\f*\u00020\u000b8\nX\u008a\u0084\u0002"}, d2 = {"Lcom/tencent/mobileqq/guild/homev2/misc/logics/GuildHomeSaveStateLogic;", "", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ldf1/c;", "saveStateCallback", "", "e", "com/tencent/mobileqq/guild/homev2/misc/logics/GuildHomeSaveStateLogic$a", "d", "(Landroid/app/Activity;)Lcom/tencent/mobileqq/guild/homev2/misc/logics/GuildHomeSaveStateLogic$a;", "Landroidx/fragment/app/Fragment;", "T", "receiver", "", "f", "(Landroidx/fragment/app/Fragment;)V", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildHomeSaveStateLogic {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildHomeSaveStateLogic f225894a = new GuildHomeSaveStateLogic();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R%\u0010\u000b\u001a\u0010\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00020\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/guild/homev2/misc/logics/GuildHomeSaveStateLogic$a", "Ldf1/c;", "Landroid/app/Activity;", "saveActivity", "Landroid/os/Bundle;", "a", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "getActivityRef", "()Ljava/lang/ref/WeakReference;", "activityRef", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class a implements df1.c {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final WeakReference<Activity> activityRef;

        a(Activity activity) {
            this.activityRef = new WeakReference<>(activity);
        }

        @Override // df1.c
        @Nullable
        public Bundle a(@NotNull Activity saveActivity) {
            Intrinsics.checkNotNullParameter(saveActivity, "saveActivity");
            Activity activity = this.activityRef.get();
            if (activity == null || !Intrinsics.areEqual(activity, saveActivity)) {
                return null;
            }
            Bundle bundleOf = BundleKt.bundleOf(TuplesKt.to("sgrp_stream_pgin_source_name", com.tencent.mobileqq.guild.report.b.c()));
            Logger.f235387a.d().d("Guild.NewHome.GuildHomeSaveStateLogic", 1, "onSaveInstanceState " + bundleOf);
            return bundleOf;
        }
    }

    GuildHomeSaveStateLogic() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a d(Activity activity) {
        return new a(activity);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0049, code lost:
    
        if ((!r1) == true) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int e(Activity activity, df1.c saveStateCallback) {
        String str;
        boolean isBlank;
        boolean isBlank2;
        int identityHashCode = System.identityHashCode(activity);
        df1.b bVar = df1.b.f393668a;
        bVar.b(identityHashCode, saveStateCallback);
        Bundle d16 = bVar.d(activity);
        if (d16 != null) {
            str = d16.getString("sgrp_stream_pgin_source_name");
        } else {
            str = null;
        }
        boolean z16 = true;
        Logger.f235387a.d().i("Guild.NewHome.GuildHomeSaveStateLogic", 1, "savedInstanceState " + d16);
        isBlank = StringsKt__StringsJVMKt.isBlank(com.tencent.mobileqq.guild.report.b.c());
        if (isBlank) {
            if (str != null) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            }
            z16 = false;
            if (z16) {
                com.tencent.mobileqq.guild.report.b.g(str, "Guild.NewHome.GuildHomeSaveStateLogic");
            }
        }
        return identityHashCode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final a g(Lazy<a> lazy) {
        return lazy.getValue();
    }

    public final <T extends Fragment> void f(@NotNull final T receiver) {
        final Lazy lazy;
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.guild.homev2.misc.logics.GuildHomeSaveStateLogic$install$saveStateCallback$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: Incorrect types in method signature: (TT;)V */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final GuildHomeSaveStateLogic.a invoke() {
                GuildHomeSaveStateLogic.a d16;
                GuildHomeSaveStateLogic guildHomeSaveStateLogic = GuildHomeSaveStateLogic.f225894a;
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "receiver.requireActivity()");
                d16 = guildHomeSaveStateLogic.d(requireActivity);
                return d16;
            }
        });
        receiver.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.homev2.misc.logics.GuildHomeSaveStateLogic$install$1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private int activityCode;

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes13.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f225899a;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    f225899a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                GuildHomeSaveStateLogic.a g16;
                int e16;
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                Logger logger = Logger.f235387a;
                if (QLog.isDebugVersion()) {
                    logger.d().d("Guild.NewHome.GuildHomeSaveStateLogic", 1, "GuildHomeSaveStateLogic onStateChanged:" + event);
                }
                int i3 = a.f225899a[event.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        df1.b.f393668a.e(this.activityCode);
                        source.getLifecycle().removeObserver(this);
                        return;
                    }
                    return;
                }
                GuildHomeSaveStateLogic guildHomeSaveStateLogic = GuildHomeSaveStateLogic.f225894a;
                FragmentActivity requireActivity = Fragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "receiver.requireActivity()");
                g16 = GuildHomeSaveStateLogic.g(lazy);
                e16 = guildHomeSaveStateLogic.e(requireActivity, g16);
                this.activityCode = e16;
            }
        });
    }
}
