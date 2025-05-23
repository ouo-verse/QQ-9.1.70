package com.tencent.mobileqq.guild.media.thirdapp.container.intent;

import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0006\u0003\u0004\u0005\u0006\u0007\bB\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0005\t\n\u000b\f\r\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MainProcessIntent;", "()V", "AppAuthResultIntent", "CloseCurrentContainerIntent", "GetUserProfileIntent", "MiniAppRequestEvent", "NotifyUserAuthResultIntent", "UpdateDragBar", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$AppAuthResultIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$CloseCurrentContainerIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$MiniAppRequestEvent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$NotifyUserAuthResultIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$UpdateDragBar;", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes14.dex */
public abstract class MiniAppIntent extends MainProcessIntent {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u00c6\u0003J\u001f\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u00c6\u0001J\t\u0010\n\u001a\u00020\tH\u00d6\u0001J\t\u0010\u000b\u001a\u00020\u0002H\u00d6\u0001J\u0013\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u00d6\u0003R\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$AppAuthResultIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent;", "", "component1", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;", "component2", "code", "authResult", "copy", "", "toString", "hashCode", "", "other", "", "equals", "I", "getCode", "()I", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;", "getAuthResult", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;", "setAuthResult", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;)V", "<init>", "(ILcom/tencent/mobileqq/guild/media/thirdapp/container/intent/a;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class AppAuthResultIntent extends MiniAppIntent {

        @Nullable
        private AppAuthResult authResult;
        private final int code;

        public AppAuthResultIntent(int i3, @Nullable AppAuthResult appAuthResult) {
            super(null);
            this.code = i3;
            this.authResult = appAuthResult;
        }

        public static /* synthetic */ AppAuthResultIntent copy$default(AppAuthResultIntent appAuthResultIntent, int i3, AppAuthResult appAuthResult, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = appAuthResultIntent.code;
            }
            if ((i16 & 2) != 0) {
                appAuthResult = appAuthResultIntent.authResult;
            }
            return appAuthResultIntent.copy(i3, appAuthResult);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @Nullable
        /* renamed from: component2, reason: from getter */
        public final AppAuthResult getAuthResult() {
            return this.authResult;
        }

        @NotNull
        public final AppAuthResultIntent copy(int code, @Nullable AppAuthResult authResult) {
            return new AppAuthResultIntent(code, authResult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AppAuthResultIntent)) {
                return false;
            }
            AppAuthResultIntent appAuthResultIntent = (AppAuthResultIntent) other;
            if (this.code == appAuthResultIntent.code && Intrinsics.areEqual(this.authResult, appAuthResultIntent.authResult)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @Nullable
        public final AppAuthResult getAuthResult() {
            return this.authResult;
        }

        public final int getCode() {
            return this.code;
        }

        public int hashCode() {
            int hashCode;
            int i3 = this.code * 31;
            AppAuthResult appAuthResult = this.authResult;
            if (appAuthResult == null) {
                hashCode = 0;
            } else {
                hashCode = appAuthResult.hashCode();
            }
            return i3 + hashCode;
        }

        public final void setAuthResult(@Nullable AppAuthResult appAuthResult) {
            this.authResult = appAuthResult;
        }

        @NotNull
        public String toString() {
            return "AppAuthResultIntent(code=" + this.code + ", authResult=" + this.authResult + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$CloseCurrentContainerIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent;", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final class CloseCurrentContainerIntent extends MiniAppIntent {

        @NotNull
        public static final CloseCurrentContainerIntent INSTANCE = new CloseCurrentContainerIntent();

        CloseCurrentContainerIntent() {
            super(null);
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00c6\u0003J\u0013\u0010\u0005\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0002H\u00c6\u0001J\t\u0010\u0007\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\t\u001a\u00020\bH\u00d6\u0001J\u0013\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u00d6\u0003R\u0017\u0010\u0004\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$GetUserProfileIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/ToolProcessIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "component1", "asyncResult", "copy", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "getAsyncResult", "()Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;", "<init>", "(Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/c;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final /* data */ class GetUserProfileIntent extends ToolProcessIntent {

        @NotNull
        private final c asyncResult;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GetUserProfileIntent(@NotNull c asyncResult) {
            super(false, 1, null);
            Intrinsics.checkNotNullParameter(asyncResult, "asyncResult");
            this.asyncResult = asyncResult;
        }

        public static /* synthetic */ GetUserProfileIntent copy$default(GetUserProfileIntent getUserProfileIntent, c cVar, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                cVar = getUserProfileIntent.asyncResult;
            }
            return getUserProfileIntent.copy(cVar);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final c getAsyncResult() {
            return this.asyncResult;
        }

        @NotNull
        public final GetUserProfileIntent copy(@NotNull c asyncResult) {
            Intrinsics.checkNotNullParameter(asyncResult, "asyncResult");
            return new GetUserProfileIntent(asyncResult);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof GetUserProfileIntent) && Intrinsics.areEqual(this.asyncResult, ((GetUserProfileIntent) other).asyncResult)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.ToolProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
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
            return "GetUserProfileIntent(asyncResult=" + this.asyncResult + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u00d6\u0003J\t\u0010\r\u001a\u00020\u000eH\u00d6\u0001J\t\u0010\u000f\u001a\u00020\u0010H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$MiniAppRequestEvent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent;", "req", "Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "(Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;)V", "getReq", "()Lcom/tencent/qqmini/sdk/launcher/core/model/RequestEvent;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class MiniAppRequestEvent extends MiniAppIntent {

        @NotNull
        private final RequestEvent req;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MiniAppRequestEvent(@NotNull RequestEvent req) {
            super(null);
            Intrinsics.checkNotNullParameter(req, "req");
            this.req = req;
        }

        public static /* synthetic */ MiniAppRequestEvent copy$default(MiniAppRequestEvent miniAppRequestEvent, RequestEvent requestEvent, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                requestEvent = miniAppRequestEvent.req;
            }
            return miniAppRequestEvent.copy(requestEvent);
        }

        @NotNull
        /* renamed from: component1, reason: from getter */
        public final RequestEvent getReq() {
            return this.req;
        }

        @NotNull
        public final MiniAppRequestEvent copy(@NotNull RequestEvent req) {
            Intrinsics.checkNotNullParameter(req, "req");
            return new MiniAppRequestEvent(req);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof MiniAppRequestEvent) && Intrinsics.areEqual(this.req, ((MiniAppRequestEvent) other).req)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final RequestEvent getReq() {
            return this.req;
        }

        public int hashCode() {
            return this.req.hashCode();
        }

        @NotNull
        public String toString() {
            return "MiniAppRequestEvent(req=" + this.req + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0003H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$NotifyUserAuthResultIntent;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent;", "code", "", "appId", "", "authCode", "(ILjava/lang/String;Ljava/lang/String;)V", "getAppId", "()Ljava/lang/String;", "getAuthCode", "getCode", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class NotifyUserAuthResultIntent extends MiniAppIntent {

        @NotNull
        private final String appId;

        @NotNull
        private final String authCode;
        private final int code;

        public /* synthetic */ NotifyUserAuthResultIntent(int i3, String str, String str2, int i16, DefaultConstructorMarker defaultConstructorMarker) {
            this((i16 & 1) != 0 ? 0 : i3, str, str2);
        }

        public static /* synthetic */ NotifyUserAuthResultIntent copy$default(NotifyUserAuthResultIntent notifyUserAuthResultIntent, int i3, String str, String str2, int i16, Object obj) {
            if ((i16 & 1) != 0) {
                i3 = notifyUserAuthResultIntent.code;
            }
            if ((i16 & 2) != 0) {
                str = notifyUserAuthResultIntent.appId;
            }
            if ((i16 & 4) != 0) {
                str2 = notifyUserAuthResultIntent.authCode;
            }
            return notifyUserAuthResultIntent.copy(i3, str, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final int getCode() {
            return this.code;
        }

        @NotNull
        /* renamed from: component2, reason: from getter */
        public final String getAppId() {
            return this.appId;
        }

        @NotNull
        /* renamed from: component3, reason: from getter */
        public final String getAuthCode() {
            return this.authCode;
        }

        @NotNull
        public final NotifyUserAuthResultIntent copy(int code, @NotNull String appId, @NotNull String authCode) {
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(authCode, "authCode");
            return new NotifyUserAuthResultIntent(code, appId, authCode);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NotifyUserAuthResultIntent)) {
                return false;
            }
            NotifyUserAuthResultIntent notifyUserAuthResultIntent = (NotifyUserAuthResultIntent) other;
            if (this.code == notifyUserAuthResultIntent.code && Intrinsics.areEqual(this.appId, notifyUserAuthResultIntent.appId) && Intrinsics.areEqual(this.authCode, notifyUserAuthResultIntent.authCode)) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        @NotNull
        public final String getAppId() {
            return this.appId;
        }

        @NotNull
        public final String getAuthCode() {
            return this.authCode;
        }

        public final int getCode() {
            return this.code;
        }

        public int hashCode() {
            return (((this.code * 31) + this.appId.hashCode()) * 31) + this.authCode.hashCode();
        }

        @NotNull
        public String toString() {
            return "NotifyUserAuthResultIntent(code=" + this.code + ", appId=" + this.appId + ", authCode=" + this.authCode + ")";
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public NotifyUserAuthResultIntent(int i3, @NotNull String appId, @NotNull String authCode) {
            super(null);
            Intrinsics.checkNotNullParameter(appId, "appId");
            Intrinsics.checkNotNullParameter(authCode, "authCode");
            this.code = i3;
            this.appId = appId;
            this.authCode = authCode;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003H\u00c6\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u00d6\u0003J\t\u0010\f\u001a\u00020\rH\u00d6\u0001J\t\u0010\u000e\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent$UpdateDragBar;", "Lcom/tencent/mobileqq/guild/media/thirdapp/container/intent/MiniAppIntent;", "fromDragBar", "", "(Z)V", "getFromDragBar", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public static final /* data */ class UpdateDragBar extends MiniAppIntent {
        private final boolean fromDragBar;

        public UpdateDragBar() {
            this(false, 1, null);
        }

        public static /* synthetic */ UpdateDragBar copy$default(UpdateDragBar updateDragBar, boolean z16, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                z16 = updateDragBar.fromDragBar;
            }
            return updateDragBar.copy(z16);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getFromDragBar() {
            return this.fromDragBar;
        }

        @NotNull
        public final UpdateDragBar copy(boolean fromDragBar) {
            return new UpdateDragBar(fromDragBar);
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if ((other instanceof UpdateDragBar) && this.fromDragBar == ((UpdateDragBar) other).fromDragBar) {
                return true;
            }
            return false;
        }

        @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MiniAppIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
        @androidx.annotation.Nullable
        public /* bridge */ /* synthetic */ String eventName() {
            return com.tencent.mvi.base.route.h.a(this);
        }

        public final boolean getFromDragBar() {
            return this.fromDragBar;
        }

        public int hashCode() {
            boolean z16 = this.fromDragBar;
            if (z16) {
                return 1;
            }
            return z16 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            return "UpdateDragBar(fromDragBar=" + this.fromDragBar + ")";
        }

        public UpdateDragBar(boolean z16) {
            super(null);
            this.fromDragBar = z16;
        }

        public /* synthetic */ UpdateDragBar(boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? false : z16);
        }
    }

    public /* synthetic */ MiniAppIntent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Override // com.tencent.mobileqq.guild.media.thirdapp.container.intent.MainProcessIntent, com.tencent.mobileqq.guild.media.thirdapp.container.intent.ContainerMsgIntent, com.tencent.mvi.base.route.i
    @androidx.annotation.Nullable
    public /* bridge */ /* synthetic */ String eventName() {
        return com.tencent.mvi.base.route.h.a(this);
    }

    MiniAppIntent() {
    }
}
