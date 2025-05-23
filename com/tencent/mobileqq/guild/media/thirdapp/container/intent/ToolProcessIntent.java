package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import android.view.Surface;
import androidx.annotation.Nullable;
import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.mobileqq.guild.media.thirdapp.ScreenMode;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qaddefine.QAdReportDefine$AdReporterParams;
import cooperation.qzone.QZoneShareManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001:\u000b\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010B\u0011\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ContainerMsgIntent;", "", "needResult", "<init>", "(Z)V", "CloseLoadingIntent", "EventNotifyIntent", "GetScreenContentSizeIntent", "NotifyFloatWindowIntent", "NotifyOfflineResCompleted", "NotifyWebForegroundIntent", "NotifyWebScreenChangedIntent", "ResizeWebIntent", "SendJSCallbackIntent", "ShowFullScreenIconIntent", "ShowInputIntent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public class ToolProcessIntent extends ContainerMsgIntent {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$CloseLoadingIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class CloseLoadingIntent extends ToolProcessIntent {

        @NotNull
        public static final CloseLoadingIntent INSTANCE = new CloseLoadingIntent();

        CloseLoadingIntent() {
            super(false, 1, null);
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$EventNotifyIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", AdMetricTag.EVENT_NAME, "", "data", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "getData", "()Lorg/json/JSONObject;", "getEventName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class EventNotifyIntent extends ToolProcessIntent {

        @NotNull
        private final JSONObject data;

        @NotNull
        private final String eventName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EventNotifyIntent(@NotNull String eventName, @NotNull JSONObject data) {
            super(false, 1, null);
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(data, "data");
            this.eventName = eventName;
            this.data = data;
        }

        public static /* synthetic */ EventNotifyIntent copy$default(EventNotifyIntent eventNotifyIntent, String str, JSONObject jSONObject, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = eventNotifyIntent.eventName;
            }
            if ((i3 & 2) != 0) {
                jSONObject = eventNotifyIntent.data;
            }
            return eventNotifyIntent.copy(str, jSONObject);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getEventName() {
            return this.eventName;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final JSONObject getData() {
            return this.data;
        }

        @NotNull
        public final EventNotifyIntent copy(@NotNull String eventName, @NotNull JSONObject data) {
            Intrinsics.checkNotNullParameter(eventName, "eventName");
            Intrinsics.checkNotNullParameter(data, "data");
            return new EventNotifyIntent(eventName, data);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof EventNotifyIntent)) {
                return false;
            }
            EventNotifyIntent eventNotifyIntent = (EventNotifyIntent) other;
            if (Intrinsics.areEqual(this.eventName, eventNotifyIntent.eventName) && Intrinsics.areEqual(this.data, eventNotifyIntent.data)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final JSONObject getData() {
            return this.data;
        }

        @NotNull
        public final String getEventName() {
            return this.eventName;
        }

        public int hashCode() {
            return (this.eventName.hashCode() * 31) + this.data.hashCode();
        }

        @NotNull
        public String toString() {
            return "EventNotifyIntent(eventName=" + this.eventName + ", data=" + this.data + ")";
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$GetScreenContentSizeIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "component1", "asyncResult", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "getAsyncResult", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class GetScreenContentSizeIntent extends ToolProcessIntent {

        @NotNull
        private final c asyncResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetScreenContentSizeIntent(@NotNull c asyncResult) {
            super(false, 1, null);
            Intrinsics.checkNotNullParameter(asyncResult, "asyncResult");
            this.asyncResult = asyncResult;
        }

        public static /* synthetic */ GetScreenContentSizeIntent copy$default(GetScreenContentSizeIntent getScreenContentSizeIntent, c cVar, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cVar = getScreenContentSizeIntent.asyncResult;
            }
            return getScreenContentSizeIntent.copy(cVar);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final c getAsyncResult() {
            return this.asyncResult;
        }

        @NotNull
        public final GetScreenContentSizeIntent copy(@NotNull c asyncResult) {
            Intrinsics.checkNotNullParameter(asyncResult, "asyncResult");
            return new GetScreenContentSizeIntent(asyncResult);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetScreenContentSizeIntent) && Intrinsics.areEqual(this.asyncResult, ((GetScreenContentSizeIntent) other).asyncResult)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final c getAsyncResult() {
            return this.asyncResult;
        }

        public int hashCode() {
            return this.asyncResult.hashCode();
        }

        @NotNull
        public String toString() {
            return "GetScreenContentSizeIntent(asyncResult=" + this.asyncResult + ")";
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$NotifyFloatWindowIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "isFloatWindowVisible", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class NotifyFloatWindowIntent extends ToolProcessIntent {
        private final boolean isFloatWindowVisible;

        public NotifyFloatWindowIntent() {
            this(false, 1, null);
        }

        public static /* synthetic */ NotifyFloatWindowIntent copy$default(NotifyFloatWindowIntent notifyFloatWindowIntent, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = notifyFloatWindowIntent.isFloatWindowVisible;
            }
            return notifyFloatWindowIntent.copy(z16);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsFloatWindowVisible() {
            return this.isFloatWindowVisible;
        }

        @NotNull
        public final NotifyFloatWindowIntent copy(boolean isFloatWindowVisible) {
            return new NotifyFloatWindowIntent(isFloatWindowVisible);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NotifyFloatWindowIntent) && this.isFloatWindowVisible == ((NotifyFloatWindowIntent) other).isFloatWindowVisible) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        public int hashCode() {
            boolean z16 = this.isFloatWindowVisible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public final boolean isFloatWindowVisible() {
            return this.isFloatWindowVisible;
        }

        @NotNull
        public String toString() {
            return "NotifyFloatWindowIntent(isFloatWindowVisible=" + this.isFloatWindowVisible + ")";
        }

        public NotifyFloatWindowIntent(boolean z16) {
            super(false, 1, null);
            this.isFloatWindowVisible = z16;
        }

        public /* synthetic */ NotifyFloatWindowIntent(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$NotifyOfflineResCompleted;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "url", "", "timeCost", "", "(Ljava/lang/String;J)V", "getTimeCost", "()J", "getUrl", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class NotifyOfflineResCompleted extends ToolProcessIntent {
        private final long timeCost;

        @NotNull
        private final String url;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotifyOfflineResCompleted(@NotNull String url, long j3) {
            super(false, 1, null);
            Intrinsics.checkNotNullParameter(url, "url");
            this.url = url;
            this.timeCost = j3;
        }

        public static /* synthetic */ NotifyOfflineResCompleted copy$default(NotifyOfflineResCompleted notifyOfflineResCompleted, String str, long j3, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = notifyOfflineResCompleted.url;
            }
            if ((i3 & 2) != 0) {
                j3 = notifyOfflineResCompleted.timeCost;
            }
            return notifyOfflineResCompleted.copy(str, j3);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: component2, reason: from getter */
        public final long getTimeCost() {
            return this.timeCost;
        }

        @NotNull
        public final NotifyOfflineResCompleted copy(@NotNull String url, long timeCost) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new NotifyOfflineResCompleted(url, timeCost);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyOfflineResCompleted)) {
                return false;
            }
            NotifyOfflineResCompleted notifyOfflineResCompleted = (NotifyOfflineResCompleted) other;
            if (Intrinsics.areEqual(this.url, notifyOfflineResCompleted.url) && this.timeCost == notifyOfflineResCompleted.timeCost) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        public final long getTimeCost() {
            return this.timeCost;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        public int hashCode() {
            return (this.url.hashCode() * 31) + androidx.fragment.app.a.a(this.timeCost);
        }

        @NotNull
        public String toString() {
            return "NotifyOfflineResCompleted(url=" + this.url + ", timeCost=" + this.timeCost + ")";
        }

        public /* synthetic */ NotifyOfflineResCompleted(String str, long j3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i3 & 2) != 0 ? 0L : j3);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0006\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u00d6\u0003J\t\u0010\u000b\u001a\u00020\fH\u00d6\u0001J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$NotifyWebForegroundIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "isVisible", "", "(Z)V", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class NotifyWebForegroundIntent extends ToolProcessIntent {
        private final boolean isVisible;

        public NotifyWebForegroundIntent() {
            this(false, 1, null);
        }

        public static /* synthetic */ NotifyWebForegroundIntent copy$default(NotifyWebForegroundIntent notifyWebForegroundIntent, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = notifyWebForegroundIntent.isVisible;
            }
            return notifyWebForegroundIntent.copy(z16);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getIsVisible() {
            return this.isVisible;
        }

        @NotNull
        public final NotifyWebForegroundIntent copy(boolean isVisible) {
            return new NotifyWebForegroundIntent(isVisible);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof NotifyWebForegroundIntent) && this.isVisible == ((NotifyWebForegroundIntent) other).isVisible) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        public int hashCode() {
            boolean z16 = this.isVisible;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        public final boolean isVisible() {
            return this.isVisible;
        }

        @NotNull
        public String toString() {
            return "NotifyWebForegroundIntent(isVisible=" + this.isVisible + ")";
        }

        public NotifyWebForegroundIntent(boolean z16) {
            super(false, 1, null);
            this.isVisible = z16;
        }

        public /* synthetic */ NotifyWebForegroundIntent(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? true : z16);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u001c\u001a\u00020\u001dH\u00d6\u0001R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$NotifyWebScreenChangedIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "topPlaceHolder", "", "leftPlaceHolder", "rightPlaceHolder", "bottomPlaceHolder", QAdReportDefine$AdReporterParams.K_Q_AD_REPORTER_PARAM_KEY_SCREEN_MODE, "Lcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;", "(IIIILcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;)V", "getBottomPlaceHolder", "()I", "getLeftPlaceHolder", "getRightPlaceHolder", "getScreenMode", "()Lcom/tencent/mobileqq/guild/media/thirdapp/ScreenMode;", "getTopPlaceHolder", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class NotifyWebScreenChangedIntent extends ToolProcessIntent {
        private final int bottomPlaceHolder;
        private final int leftPlaceHolder;
        private final int rightPlaceHolder;

        @NotNull
        private final ScreenMode screenMode;
        private final int topPlaceHolder;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotifyWebScreenChangedIntent(int i3, int i16, int i17, int i18, @NotNull ScreenMode screenMode) {
            super(false, 1, null);
            Intrinsics.checkNotNullParameter(screenMode, "screenMode");
            this.topPlaceHolder = i3;
            this.leftPlaceHolder = i16;
            this.rightPlaceHolder = i17;
            this.bottomPlaceHolder = i18;
            this.screenMode = screenMode;
        }

        public static /* synthetic */ NotifyWebScreenChangedIntent copy$default(NotifyWebScreenChangedIntent notifyWebScreenChangedIntent, int i3, int i16, int i17, int i18, ScreenMode screenMode, int i19, Object obj) {
            if ((i19 & 1) != 0) {
                i3 = notifyWebScreenChangedIntent.topPlaceHolder;
            }
            if ((i19 & 2) != 0) {
                i16 = notifyWebScreenChangedIntent.leftPlaceHolder;
            }
            int i26 = i16;
            if ((i19 & 4) != 0) {
                i17 = notifyWebScreenChangedIntent.rightPlaceHolder;
            }
            int i27 = i17;
            if ((i19 & 8) != 0) {
                i18 = notifyWebScreenChangedIntent.bottomPlaceHolder;
            }
            int i28 = i18;
            if ((i19 & 16) != 0) {
                screenMode = notifyWebScreenChangedIntent.screenMode;
            }
            return notifyWebScreenChangedIntent.copy(i3, i26, i27, i28, screenMode);
        }

        /* renamed from: component1, reason: from getter */
        public final int getTopPlaceHolder() {
            return this.topPlaceHolder;
        }

        /* renamed from: component2, reason: from getter */
        public final int getLeftPlaceHolder() {
            return this.leftPlaceHolder;
        }

        /* renamed from: component3, reason: from getter */
        public final int getRightPlaceHolder() {
            return this.rightPlaceHolder;
        }

        /* renamed from: component4, reason: from getter */
        public final int getBottomPlaceHolder() {
            return this.bottomPlaceHolder;
        }

        @NotNull
        /* renamed from: component5, reason: from getter */
        public final ScreenMode getScreenMode() {
            return this.screenMode;
        }

        @NotNull
        public final NotifyWebScreenChangedIntent copy(int topPlaceHolder, int leftPlaceHolder, int rightPlaceHolder, int bottomPlaceHolder, @NotNull ScreenMode screenMode) {
            Intrinsics.checkNotNullParameter(screenMode, "screenMode");
            return new NotifyWebScreenChangedIntent(topPlaceHolder, leftPlaceHolder, rightPlaceHolder, bottomPlaceHolder, screenMode);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyWebScreenChangedIntent)) {
                return false;
            }
            NotifyWebScreenChangedIntent notifyWebScreenChangedIntent = (NotifyWebScreenChangedIntent) other;
            if (this.topPlaceHolder == notifyWebScreenChangedIntent.topPlaceHolder && this.leftPlaceHolder == notifyWebScreenChangedIntent.leftPlaceHolder && this.rightPlaceHolder == notifyWebScreenChangedIntent.rightPlaceHolder && this.bottomPlaceHolder == notifyWebScreenChangedIntent.bottomPlaceHolder && this.screenMode == notifyWebScreenChangedIntent.screenMode) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        public final int getBottomPlaceHolder() {
            return this.bottomPlaceHolder;
        }

        public final int getLeftPlaceHolder() {
            return this.leftPlaceHolder;
        }

        public final int getRightPlaceHolder() {
            return this.rightPlaceHolder;
        }

        @NotNull
        public final ScreenMode getScreenMode() {
            return this.screenMode;
        }

        public final int getTopPlaceHolder() {
            return this.topPlaceHolder;
        }

        public int hashCode() {
            return (((((((this.topPlaceHolder * 31) + this.leftPlaceHolder) * 31) + this.rightPlaceHolder) * 31) + this.bottomPlaceHolder) * 31) + this.screenMode.hashCode();
        }

        @NotNull
        public String toString() {
            return "NotifyWebScreenChangedIntent(topPlaceHolder=" + this.topPlaceHolder + ", leftPlaceHolder=" + this.leftPlaceHolder + ", rightPlaceHolder=" + this.rightPlaceHolder + ", bottomPlaceHolder=" + this.bottomPlaceHolder + ", screenMode=" + this.screenMode + ")";
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\nH\u00c6\u0003J=\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001b\u001a\u00020\n2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u0007H\u00d6\u0001J\t\u0010\u001f\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$ResizeWebIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "uniqueKey", "", "surface", "Landroid/view/Surface;", "width", "", "height", "needRebuildDisplay", "", "(Ljava/lang/String;Landroid/view/Surface;IIZ)V", "getHeight", "()I", "getNeedRebuildDisplay", "()Z", "getSurface", "()Landroid/view/Surface;", "getUniqueKey", "()Ljava/lang/String;", "getWidth", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class ResizeWebIntent extends ToolProcessIntent {
        private final int height;
        private final boolean needRebuildDisplay;

        @org.jetbrains.annotations.Nullable
        private final Surface surface;

        @NotNull
        private final String uniqueKey;
        private final int width;

        public /* synthetic */ ResizeWebIntent(String str, Surface surface, int i3, int i16, boolean z16, int i17, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i17 & 2) != 0 ? null : surface, i3, i16, (i17 & 16) != 0 ? false : z16);
        }

        public static /* synthetic */ ResizeWebIntent copy$default(ResizeWebIntent resizeWebIntent, String str, Surface surface, int i3, int i16, boolean z16, int i17, Object obj) {
            if ((i17 & 1) != 0) {
                str = resizeWebIntent.uniqueKey;
            }
            if ((i17 & 2) != 0) {
                surface = resizeWebIntent.surface;
            }
            Surface surface2 = surface;
            if ((i17 & 4) != 0) {
                i3 = resizeWebIntent.width;
            }
            int i18 = i3;
            if ((i17 & 8) != 0) {
                i16 = resizeWebIntent.height;
            }
            int i19 = i16;
            if ((i17 & 16) != 0) {
                z16 = resizeWebIntent.needRebuildDisplay;
            }
            return resizeWebIntent.copy(str, surface2, i18, i19, z16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getUniqueKey() {
            return this.uniqueKey;
        }

        @org.jetbrains.annotations.Nullable
        /* renamed from: component2, reason: from getter */
        public final Surface getSurface() {
            return this.surface;
        }

        /* renamed from: component3, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        /* renamed from: component4, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getNeedRebuildDisplay() {
            return this.needRebuildDisplay;
        }

        @NotNull
        public final ResizeWebIntent copy(@NotNull String uniqueKey, @org.jetbrains.annotations.Nullable Surface surface, int width, int height, boolean needRebuildDisplay) {
            Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
            return new ResizeWebIntent(uniqueKey, surface, width, height, needRebuildDisplay);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ResizeWebIntent)) {
                return false;
            }
            ResizeWebIntent resizeWebIntent = (ResizeWebIntent) other;
            if (Intrinsics.areEqual(this.uniqueKey, resizeWebIntent.uniqueKey) && Intrinsics.areEqual(this.surface, resizeWebIntent.surface) && this.width == resizeWebIntent.width && this.height == resizeWebIntent.height && this.needRebuildDisplay == resizeWebIntent.needRebuildDisplay) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        public final int getHeight() {
            return this.height;
        }

        public final boolean getNeedRebuildDisplay() {
            return this.needRebuildDisplay;
        }

        @org.jetbrains.annotations.Nullable
        public final Surface getSurface() {
            return this.surface;
        }

        @NotNull
        public final String getUniqueKey() {
            return this.uniqueKey;
        }

        public final int getWidth() {
            return this.width;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode;
            int hashCode2 = this.uniqueKey.hashCode() * 31;
            Surface surface = this.surface;
            if (surface == null) {
                hashCode = 0;
            } else {
                hashCode = surface.hashCode();
            }
            int i3 = (((((hashCode2 + hashCode) * 31) + this.width) * 31) + this.height) * 31;
            boolean z16 = this.needRebuildDisplay;
            int i16 = z16;
            if (z16 != 0) {
                i16 = 1;
            }
            return i3 + i16;
        }

        @NotNull
        public String toString() {
            return "ResizeWebIntent(uniqueKey=" + this.uniqueKey + ", surface=" + this.surface + ", width=" + this.width + ", height=" + this.height + ", needRebuildDisplay=" + this.needRebuildDisplay + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ResizeWebIntent(@NotNull String uniqueKey, @org.jetbrains.annotations.Nullable Surface surface, int i3, int i16, boolean z16) {
            super(false);
            Intrinsics.checkNotNullParameter(uniqueKey, "uniqueKey");
            this.uniqueKey = uniqueKey;
            this.surface = surface;
            this.width = i3;
            this.height = i16;
            this.needRebuildDisplay = z16;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0006H\u00c6\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u00c6\u0001J\u0013\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u00d6\u0003J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$SendJSCallbackIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "callbackId", "", "callbackJson", "isFrequentCallback", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getCallbackId", "()Ljava/lang/String;", "getCallbackJson", "()Z", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class SendJSCallbackIntent extends ToolProcessIntent {

        @NotNull
        private final String callbackId;

        @NotNull
        private final String callbackJson;
        private final boolean isFrequentCallback;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SendJSCallbackIntent(@NotNull String callbackId, @NotNull String callbackJson, boolean z16) {
            super(false, 1, null);
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            Intrinsics.checkNotNullParameter(callbackJson, "callbackJson");
            this.callbackId = callbackId;
            this.callbackJson = callbackJson;
            this.isFrequentCallback = z16;
        }

        public static /* synthetic */ SendJSCallbackIntent copy$default(SendJSCallbackIntent sendJSCallbackIntent, String str, String str2, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = sendJSCallbackIntent.callbackId;
            }
            if ((i3 & 2) != 0) {
                str2 = sendJSCallbackIntent.callbackJson;
            }
            if ((i3 & 4) != 0) {
                z16 = sendJSCallbackIntent.isFrequentCallback;
            }
            return sendJSCallbackIntent.copy(str, str2, z16);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getCallbackId() {
            return this.callbackId;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getCallbackJson() {
            return this.callbackJson;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getIsFrequentCallback() {
            return this.isFrequentCallback;
        }

        @NotNull
        public final SendJSCallbackIntent copy(@NotNull String callbackId, @NotNull String callbackJson, boolean isFrequentCallback) {
            Intrinsics.checkNotNullParameter(callbackId, "callbackId");
            Intrinsics.checkNotNullParameter(callbackJson, "callbackJson");
            return new SendJSCallbackIntent(callbackId, callbackJson, isFrequentCallback);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SendJSCallbackIntent)) {
                return false;
            }
            SendJSCallbackIntent sendJSCallbackIntent = (SendJSCallbackIntent) other;
            if (Intrinsics.areEqual(this.callbackId, sendJSCallbackIntent.callbackId) && Intrinsics.areEqual(this.callbackJson, sendJSCallbackIntent.callbackJson) && this.isFrequentCallback == sendJSCallbackIntent.isFrequentCallback) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final String getCallbackId() {
            return this.callbackId;
        }

        @NotNull
        public final String getCallbackJson() {
            return this.callbackJson;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = ((this.callbackId.hashCode() * 31) + this.callbackJson.hashCode()) * 31;
            boolean z16 = this.isFrequentCallback;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        public final boolean isFrequentCallback() {
            return this.isFrequentCallback;
        }

        @NotNull
        public String toString() {
            return "SendJSCallbackIntent(callbackId=" + this.callbackId + ", callbackJson=" + this.callbackJson + ", isFrequentCallback=" + this.isFrequentCallback + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$ShowFullScreenIconIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class ShowFullScreenIconIntent extends ToolProcessIntent {

        @NotNull
        public static final ShowFullScreenIconIntent INSTANCE = new ShowFullScreenIconIntent();

        ShowFullScreenIconIntent() {
            super(false, 1, null);
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0004\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0005\u001a\u00020\u0002H\u00c6\u0003J\t\u0010\u0007\u001a\u00020\u0006H\u00c6\u0003J1\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00022\b\b\u0002\u0010\u000b\u001a\u00020\u0006H\u00c6\u0001J\t\u0010\r\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u000eH\u00d6\u0001J\u0013\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u00d6\u0003R\u0017\u0010\b\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\t\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\u0014\u001a\u0004\b\u0017\u0010\u0016R\u0017\u0010\n\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u0014\u001a\u0004\b\u0018\u0010\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent$ShowInputIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "", "component1", "component2", "component3", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "component4", "hintText", "actionText", QZoneShareManager.QZONE_SHARE_VIDEO_TEXT, "inputResult", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getHintText", "()Ljava/lang/String;", "getActionText", "getDefaultText", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "getInputResult", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class ShowInputIntent extends ToolProcessIntent {

        @NotNull
        private final String actionText;

        @NotNull
        private final String defaultText;

        @NotNull
        private final String hintText;

        @NotNull
        private final c inputResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ShowInputIntent(@NotNull String hintText, @NotNull String actionText, @NotNull String defaultText, @NotNull c inputResult) {
            super(false, 1, null);
            Intrinsics.checkNotNullParameter(hintText, "hintText");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(defaultText, "defaultText");
            Intrinsics.checkNotNullParameter(inputResult, "inputResult");
            this.hintText = hintText;
            this.actionText = actionText;
            this.defaultText = defaultText;
            this.inputResult = inputResult;
        }

        public static /* synthetic */ ShowInputIntent copy$default(ShowInputIntent showInputIntent, String str, String str2, String str3, c cVar, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = showInputIntent.hintText;
            }
            if ((i3 & 2) != 0) {
                str2 = showInputIntent.actionText;
            }
            if ((i3 & 4) != 0) {
                str3 = showInputIntent.defaultText;
            }
            if ((i3 & 8) != 0) {
                cVar = showInputIntent.inputResult;
            }
            return showInputIntent.copy(str, str2, str3, cVar);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final String getHintText() {
            return this.hintText;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getActionText() {
            return this.actionText;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getDefaultText() {
            return this.defaultText;
        }

        @NotNull
        /* renamed from: component4, reason: from getter */
        public final c getInputResult() {
            return this.inputResult;
        }

        @NotNull
        public final ShowInputIntent copy(@NotNull String hintText, @NotNull String actionText, @NotNull String defaultText, @NotNull c inputResult) {
            Intrinsics.checkNotNullParameter(hintText, "hintText");
            Intrinsics.checkNotNullParameter(actionText, "actionText");
            Intrinsics.checkNotNullParameter(defaultText, "defaultText");
            Intrinsics.checkNotNullParameter(inputResult, "inputResult");
            return new ShowInputIntent(hintText, actionText, defaultText, inputResult);
        }

        public boolean equals(@org.jetbrains.annotations.Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ShowInputIntent)) {
                return false;
            }
            ShowInputIntent showInputIntent = (ShowInputIntent) other;
            if (Intrinsics.areEqual(this.hintText, showInputIntent.hintText) && Intrinsics.areEqual(this.actionText, showInputIntent.actionText) && Intrinsics.areEqual(this.defaultText, showInputIntent.defaultText) && Intrinsics.areEqual(this.inputResult, showInputIntent.inputResult)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final String getActionText() {
            return this.actionText;
        }

        @NotNull
        public final String getDefaultText() {
            return this.defaultText;
        }

        @NotNull
        public final String getHintText() {
            return this.hintText;
        }

        @NotNull
        public final c getInputResult() {
            return this.inputResult;
        }

        public int hashCode() {
            return (((((this.hintText.hashCode() * 31) + this.actionText.hashCode()) * 31) + this.defaultText.hashCode()) * 31) + this.inputResult.hashCode();
        }

        @NotNull
        public String toString() {
            return "ShowInputIntent(hintText=" + this.hintText + ", actionText=" + this.actionText + ", defaultText=" + this.defaultText + ", inputResult=" + this.inputResult + ")";
        }
    }

    public ToolProcessIntent() {
        this(false, 1, null);
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
    @Nullable
    public /* bridge */ /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    public ToolProcessIntent(boolean z16) {
        super(true, z16);
    }

    public /* synthetic */ ToolProcessIntent(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z16);
    }
}
