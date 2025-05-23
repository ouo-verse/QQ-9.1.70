package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import com.tencent.mobileqq.guild.media.thirdapp.container.ContainerLifeEvent;
import com.tencent.mobileqq.remoteweb.RemoteWebTimeCost;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MainProcessIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "<init>", "()V", "ContainerLifeIntent", "RemoteWebTimeCostIntent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class MainProcessIntent extends ContainerMsgIntent {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MainProcessIntent$ContainerLifeIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MainProcessIntent;", "event", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/ContainerLifeEvent;", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/ContainerLifeEvent;)V", "getEvent", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/ContainerLifeEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class ContainerLifeIntent extends MainProcessIntent {

        @NotNull
        private final ContainerLifeEvent event;

        public ContainerLifeIntent(@NotNull ContainerLifeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            this.event = event;
        }

        public static /* synthetic */ ContainerLifeIntent copy$default(ContainerLifeIntent containerLifeIntent, ContainerLifeEvent containerLifeEvent, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                containerLifeEvent = containerLifeIntent.event;
            }
            return containerLifeIntent.copy(containerLifeEvent);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final ContainerLifeEvent getEvent() {
            return this.event;
        }

        @NotNull
        public final ContainerLifeIntent copy(@NotNull ContainerLifeEvent event) {
            Intrinsics.checkNotNullParameter(event, "event");
            return new ContainerLifeIntent(event);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof ContainerLifeIntent) && this.event == ((ContainerLifeIntent) other).event) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final ContainerLifeEvent getEvent() {
            return this.event;
        }

        public int hashCode() {
            return this.event.hashCode();
        }

        @NotNull
        public String toString() {
            return "ContainerLifeIntent(event=" + this.event + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MainProcessIntent$RemoteWebTimeCostIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MainProcessIntent;", "type", "Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "(Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;)V", "getType", "()Lcom/tencent/mobileqq/remoteweb/RemoteWebTimeCost;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class RemoteWebTimeCostIntent extends MainProcessIntent {

        @NotNull
        private final RemoteWebTimeCost type;

        public RemoteWebTimeCostIntent(@NotNull RemoteWebTimeCost type) {
            Intrinsics.checkNotNullParameter(type, "type");
            this.type = type;
        }

        public static /* synthetic */ RemoteWebTimeCostIntent copy$default(RemoteWebTimeCostIntent remoteWebTimeCostIntent, RemoteWebTimeCost remoteWebTimeCost, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                remoteWebTimeCost = remoteWebTimeCostIntent.type;
            }
            return remoteWebTimeCostIntent.copy(remoteWebTimeCost);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final RemoteWebTimeCost getType() {
            return this.type;
        }

        @NotNull
        public final RemoteWebTimeCostIntent copy(@NotNull RemoteWebTimeCost type) {
            Intrinsics.checkNotNullParameter(type, "type");
            return new RemoteWebTimeCostIntent(type);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof RemoteWebTimeCostIntent) && this.type == ((RemoteWebTimeCostIntent) other).type) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final RemoteWebTimeCost getType() {
            return this.type;
        }

        public int hashCode() {
            return this.type.hashCode();
        }

        @NotNull
        public String toString() {
            return "RemoteWebTimeCostIntent(type=" + this.type + ")";
        }
    }

    public MainProcessIntent() {
        super(false, false, 2, null);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }
}
