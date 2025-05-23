package com.tencent.mobileqq.guild.mainframe.manager;

import android.app.Activity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment;
import com.tencent.mobileqq.guild.homev2.misc.d;
import com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\"B\t\b\u0002\u00a2\u0006\u0004\b \u0010!J\b\u0010\u0003\u001a\u00020\u0002H\u0007J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u000e\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0004J\u000e\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fJ&\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004J+\u0010\u001a\u001a\u00020\t\"\f\b\u0000\u0010\u0018*\u00020\u0012*\u00020\u00172\u0006\u0010\u0019\u001a\u00028\u00002\u0006\u0010\u000b\u001a\u00020\u0004\u00a2\u0006\u0004\b\u001a\u0010\u001bR$\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001cj\b\u0012\u0004\u0012\u00020\u0007`\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u001e\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/manager/GuildOpenRecordManager;", "", "", "d", "", "curGuildId", "g", "Lcom/tencent/mobileqq/guild/mainframe/manager/GuildOpenRecordManager$a;", QQPermissionConstants.Permission.AUIDO_GROUP, "", "b", "instanceId", "i", "guildId", "e", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "oldId", "newId", h.F, "Lcom/tencent/mobileqq/guild/homev2/misc/d;", "T", "receiver", "f", "(Landroidx/lifecycle/LifecycleOwner;Ljava/lang/String;)V", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Ljava/util/HashSet;", "guildOpenRecords", "<init>", "()V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildOpenRecordManager {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final GuildOpenRecordManager f227480a = new GuildOpenRecordManager();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final HashSet<ActivityRecord> guildOpenRecords = new HashSet<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u000e\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\n\u001a\u0004\b\r\u0010\u000b\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/mainframe/manager/GuildOpenRecordManager$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "guildId", "b", "instanceId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager$a, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class ActivityRecord {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String guildId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String instanceId;

        public ActivityRecord(@NotNull String guildId, @NotNull String instanceId) {
            Intrinsics.checkNotNullParameter(guildId, "guildId");
            Intrinsics.checkNotNullParameter(instanceId, "instanceId");
            this.guildId = guildId;
            this.instanceId = instanceId;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getGuildId() {
            return this.guildId;
        }

        @NotNull
        /* renamed from: b, reason: from getter */
        public final String getInstanceId() {
            return this.instanceId;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ActivityRecord)) {
                return false;
            }
            ActivityRecord activityRecord = (ActivityRecord) other;
            if (Intrinsics.areEqual(this.guildId, activityRecord.guildId) && Intrinsics.areEqual(this.instanceId, activityRecord.instanceId)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return (this.guildId.hashCode() * 31) + this.instanceId.hashCode();
        }

        @NotNull
        public String toString() {
            return "ActivityRecord(guildId=" + this.guildId + ", instanceId=" + this.instanceId + ")";
        }
    }

    GuildOpenRecordManager() {
    }

    @JvmStatic
    public static final boolean d() {
        return !guildOpenRecords.isEmpty();
    }

    @JvmStatic
    public static final boolean g(@Nullable String curGuildId) {
        int i3;
        HashSet<ActivityRecord> hashSet = guildOpenRecords;
        if ((hashSet instanceof Collection) && hashSet.isEmpty()) {
            i3 = 0;
        } else {
            Iterator<T> it = hashSet.iterator();
            i3 = 0;
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((ActivityRecord) it.next()).getGuildId(), curGuildId) && (i3 = i3 + 1) < 0) {
                    CollectionsKt__CollectionsKt.throwCountOverflow();
                }
            }
        }
        if (i3 != 0) {
            return false;
        }
        return true;
    }

    public final void b(@NotNull ActivityRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        guildOpenRecords.add(record);
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.jump.GuildOpenRecordManager", 2, "addGuildOpenRecord " + record + " size:" + guildOpenRecords.size());
        }
    }

    @NotNull
    public final String c(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (activity instanceof QPublicFragmentActivity) {
            QPublicFragmentActivity qPublicFragmentActivity = (QPublicFragmentActivity) activity;
            if (qPublicFragmentActivity.getFragment() instanceof GuildHomeFragment) {
                QPublicBaseFragment fragment = qPublicFragmentActivity.getFragment();
                Intrinsics.checkNotNull(fragment, "null cannot be cast to non-null type com.tencent.mobileqq.guild.home.fragments.GuildHomeFragment");
                return ((GuildHomeFragment) fragment).getGuildId();
            }
            return "";
        }
        return "";
    }

    public final boolean e(@NotNull String guildId) {
        Intrinsics.checkNotNullParameter(guildId, "guildId");
        HashSet<ActivityRecord> hashSet = guildOpenRecords;
        if ((hashSet instanceof Collection) && hashSet.isEmpty()) {
            return false;
        }
        Iterator<T> it = hashSet.iterator();
        while (it.hasNext()) {
            if (Intrinsics.areEqual(((ActivityRecord) it.next()).getGuildId(), guildId)) {
                return true;
            }
        }
        return false;
    }

    public final <T extends LifecycleOwner & d> void f(@NotNull final T receiver, @NotNull final String instanceId) {
        Intrinsics.checkNotNullParameter(receiver, "receiver");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        receiver.getLifecycle().addObserver(new LifecycleEventObserver() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager$install$1

            /* compiled from: P */
            @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
            /* loaded from: classes14.dex */
            public /* synthetic */ class a {

                /* renamed from: a, reason: collision with root package name */
                public static final /* synthetic */ int[] f227486a;

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
                    f227486a = iArr;
                }
            }

            @Override // androidx.lifecycle.LifecycleEventObserver
            public void onStateChanged(@NotNull LifecycleOwner source, @NotNull Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(source, "source");
                Intrinsics.checkNotNullParameter(event, "event");
                String guildId = ((d) LifecycleOwner.this).getGuildId();
                int i3 = a.f227486a[event.ordinal()];
                if (i3 != 1) {
                    if (i3 == 2) {
                        GuildOpenRecordManager.f227480a.i(instanceId);
                        source.getLifecycle().removeObserver(this);
                        return;
                    }
                    return;
                }
                GuildOpenRecordManager.f227480a.b(new GuildOpenRecordManager.ActivityRecord(guildId, instanceId));
            }
        });
    }

    public final void h(@NotNull LifecycleOwner lifecycleOwner, @NotNull String instanceId, @NotNull String oldId, @NotNull String newId) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        Intrinsics.checkNotNullParameter(oldId, "oldId");
        Intrinsics.checkNotNullParameter(newId, "newId");
        if (lifecycleOwner.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            i(instanceId);
            b(new ActivityRecord(newId, instanceId));
        }
    }

    public final void i(@NotNull final String instanceId) {
        Intrinsics.checkNotNullParameter(instanceId, "instanceId");
        CollectionsKt__MutableCollectionsKt.removeAll(guildOpenRecords, new Function1<ActivityRecord, Boolean>() { // from class: com.tencent.mobileqq.guild.mainframe.manager.GuildOpenRecordManager$removeGuildOpenRecord$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            @NotNull
            public final Boolean invoke(@NotNull GuildOpenRecordManager.ActivityRecord it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(instanceId, it.getInstanceId()));
            }
        });
        Logger logger = Logger.f235387a;
        if (QLog.isColorLevel()) {
            logger.d().d("Guild.jump.GuildOpenRecordManager", 2, "removeGuildOpenRecord " + instanceId + " size:" + guildOpenRecords.size());
        }
    }
}
