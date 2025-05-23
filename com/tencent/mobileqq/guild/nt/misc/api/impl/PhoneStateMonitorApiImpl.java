package com.tencent.mobileqq.guild.nt.misc.api.impl;

import android.content.Context;
import com.tencent.av.utils.PhoneStatusMonitor;
import com.tencent.mobileqq.guild.nt.misc.api.IPhoneStateMonitorApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/misc/api/impl/PhoneStateMonitorApiImpl;", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi$b;", "callback", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi$a;", "newPhoneStateMonitor", "<init>", "()V", "a", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class PhoneStateMonitorApiImpl implements IPhoneStateMonitorApi {

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0082\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000f\u001a\u00020\f\u00a2\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\u0013\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u00d6\u0003R\u0014\u0010\u000f\u001a\u00020\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/guild/nt/misc/api/impl/PhoneStateMonitorApiImpl$a;", "Lcom/tencent/mobileqq/guild/nt/misc/api/IPhoneStateMonitorApi$a;", "", "release", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/av/utils/PhoneStatusMonitor;", "a", "Lcom/tencent/av/utils/PhoneStatusMonitor;", "monitor", "<init>", "(Lcom/tencent/av/utils/PhoneStatusMonitor;)V", "qqguild-boundaries-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.nt.misc.api.impl.PhoneStateMonitorApiImpl$a, reason: from toString */
    /* loaded from: classes14.dex */
    private static final /* data */ class PhoneStateMonitorImpl implements IPhoneStateMonitorApi.a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final PhoneStatusMonitor monitor;

        public PhoneStateMonitorImpl(@NotNull PhoneStatusMonitor monitor) {
            Intrinsics.checkNotNullParameter(monitor, "monitor");
            this.monitor = monitor;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof PhoneStateMonitorImpl) && Intrinsics.areEqual(this.monitor, ((PhoneStateMonitorImpl) other).monitor)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return this.monitor.hashCode();
        }

        @Override // com.tencent.mobileqq.guild.nt.misc.api.IPhoneStateMonitorApi.a
        public void release() {
            this.monitor.o();
        }

        @NotNull
        public String toString() {
            return "PhoneStateMonitorImpl(monitor=" + this.monitor + ')';
        }
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IPhoneStateMonitorApi
    @NotNull
    public IPhoneStateMonitorApi.a newPhoneStateMonitor(@NotNull Context context, @NotNull final IPhoneStateMonitorApi.b callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        return new PhoneStateMonitorImpl(new PhoneStatusMonitor(context, new PhoneStatusMonitor.a() { // from class: dv1.a
            @Override // com.tencent.av.utils.PhoneStatusMonitor.a
            public final void a(boolean z16) {
                IPhoneStateMonitorApi.b.this.a(z16);
            }
        }));
    }
}
