package com.tencent.mobileqq.qqlive.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sail.request.LiveCheckFollowRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveEndPageRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveFollowRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveGetAnnounceRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveGetMemberAccount;
import com.tencent.mobileqq.qqlive.sail.request.LiveGetPrivacySettingRequest;
import com.tencent.mobileqq.qqlive.sail.request.LivePlatformAnnounceRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveSetAnnounceRequest;
import com.tencent.mobileqq.qqlive.sail.request.LiveUnFollowRequest;
import com.tencent.mobileqq.qqlive.sail.request.SendMessageRequest;
import com.tencent.mobileqq.qqlive.sso.request.GetUserInfoRequest;
import com.tencent.mobileqq.qroute.QRoute;
import hr4.b;
import hr4.d;
import hr4.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq3.g;
import xq4.c;
import xq4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b/\u00100J@\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH\u0016JA\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u0010J0\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\nH\u0016J1\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J0\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\nH\u0016J1\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0014J(\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\nH\u0016J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\nH\u0016J)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0019J(\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nH\u0016J \u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\nH\u0016J8\u0010$\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\nH\u0016J9\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J(\u0010'\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\nH\u0016J)\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0019J0\u0010*\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\nH\u0016J1\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J(\u0010.\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00042\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\nH\u0016J)\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/impl/LiveRoomInteractiveApiImpl;", "Lcom/tencent/mobileqq/qqlive/api/ILiveRoomInteractiveApi;", "", "appId", "", "roomId", "msg", "", "Lrq3/b;", "exts", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lrq3/g;", "callback", "", "sendMessage", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchorId", "Lhr4/d;", "followAnchor", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lhr4/h;", "unFollowAnchor", "Lhr4/b;", "checkFollowAnchor", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lxq4/c;", "getAnnounce", "Lxq4/e;", "getPlatformAnnounce", "", "type", "Ltr4/b;", "getPrivacySetting", "announce", "Lxq4/g;", "setAnnounce", "(Ljava/lang/String;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lit3/d;", "getMemberAccount", "programId", "Lst3/b;", "getEndPageInfo", "(Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uid", "Lrr4/d;", "getUserCardInfo", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class LiveRoomInteractiveApiImpl implements ILiveRoomInteractiveApi {
    static IPatchRedirector $redirector_;

    public LiveRoomInteractiveApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void checkFollowAnchor(@NotNull String appId, long anchorId, @Nullable ILiveNetRequest.Callback<b> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, appId, Long.valueOf(anchorId), callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveCheckFollowRequest(appId, anchorId), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void followAnchor(@NotNull String appId, long roomId, long anchorId, @Nullable ILiveNetRequest.Callback<d> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, appId, Long.valueOf(roomId), Long.valueOf(anchorId), callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveFollowRequest(appId, anchorId, roomId), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void getAnnounce(@NotNull String appId, long roomId, @Nullable ILiveNetRequest.Callback<c> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, appId, Long.valueOf(roomId), callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveGetAnnounceRequest(appId, roomId), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void getEndPageInfo(@NotNull String appId, long anchorId, @NotNull String programId, @Nullable ILiveNetRequest.Callback<st3.b> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, appId, Long.valueOf(anchorId), programId, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(programId, "programId");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveEndPageRequest(appId, anchorId, programId), callback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void getMemberAccount(@NotNull String appId, long roomId, @Nullable ILiveNetRequest.Callback<it3.d> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, appId, Long.valueOf(roomId), callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveGetMemberAccount(appId, roomId), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void getPlatformAnnounce(@NotNull String appId, long roomId, @Nullable ILiveNetRequest.Callback<e> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, appId, Long.valueOf(roomId), callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LivePlatformAnnounceRequest(appId, roomId), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void getPrivacySetting(int type, @Nullable ILiveNetRequest.Callback<tr4.b> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, type, (Object) callback);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveGetPrivacySettingRequest(type), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void getUserCardInfo(@NotNull String appId, long uid, @Nullable ILiveNetRequest.Callback<rr4.d> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, appId, Long.valueOf(uid), callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new GetUserInfoRequest(appId, uid), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void sendMessage(@NotNull String appId, long roomId, @NotNull String msg2, @Nullable List<rq3.b> exts, @Nullable ILiveNetRequest.Callback<g> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appId, Long.valueOf(roomId), msg2, exts, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new SendMessageRequest(appId, roomId, msg2, exts), callback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void setAnnounce(@NotNull String appId, long roomId, long anchorId, @NotNull String announce, @Nullable ILiveNetRequest.Callback<xq4.g> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, appId, Long.valueOf(roomId), Long.valueOf(anchorId), announce, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(appId, "appId");
        Intrinsics.checkNotNullParameter(announce, "announce");
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveSetAnnounceRequest(appId, roomId, anchorId, announce), callback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    public void unFollowAnchor(@NotNull String appId, long roomId, long anchorId, @Nullable ILiveNetRequest.Callback<h> callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appId, Long.valueOf(roomId), Long.valueOf(anchorId), callback);
        } else {
            Intrinsics.checkNotNullParameter(appId, "appId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new LiveUnFollowRequest(appId, anchorId, roomId), callback);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object checkFollowAnchor(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<b>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveCheckFollowRequest(str, j3), continuation) : iPatchRedirector.redirect((short) 9, this, str, Long.valueOf(j3), continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object followAnchor(@NotNull String str, long j3, long j16, @NotNull Continuation<? super QQLiveResponse<d>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveFollowRequest(str, j16, j3), continuation) : iPatchRedirector.redirect((short) 5, this, str, Long.valueOf(j3), Long.valueOf(j16), continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object getAnnounce(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<c>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveGetAnnounceRequest(str, j3), continuation) : iPatchRedirector.redirect((short) 11, this, str, Long.valueOf(j3), continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object getEndPageInfo(@NotNull String str, long j3, @NotNull String str2, @NotNull Continuation<? super QQLiveResponse<st3.b>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveEndPageRequest(str, j3, str2), continuation) : iPatchRedirector.redirect((short) 19, this, str, Long.valueOf(j3), str2, continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object getMemberAccount(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<it3.d>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 17)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveGetMemberAccount(str, j3), continuation) : iPatchRedirector.redirect((short) 17, this, str, Long.valueOf(j3), continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object getUserCardInfo(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<rr4.d>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 21)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new GetUserInfoRequest(str, j3), continuation) : iPatchRedirector.redirect((short) 21, this, str, Long.valueOf(j3), continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object sendMessage(@NotNull String str, long j3, @NotNull String str2, @Nullable List<rq3.b> list, @NotNull Continuation<? super QQLiveResponse<g>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new SendMessageRequest(str, j3, str2, list), continuation) : iPatchRedirector.redirect((short) 3, this, str, Long.valueOf(j3), str2, list, continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object setAnnounce(@NotNull String str, long j3, long j16, @NotNull String str2, @NotNull Continuation<? super QQLiveResponse<xq4.g>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveSetAnnounceRequest(str, j3, j16, str2), continuation) : iPatchRedirector.redirect((short) 15, this, str, Long.valueOf(j3), Long.valueOf(j16), str2, continuation);
    }

    @Override // com.tencent.mobileqq.qqlive.api.ILiveRoomInteractiveApi
    @Nullable
    public Object unFollowAnchor(@NotNull String str, long j3, long j16, @NotNull Continuation<? super QQLiveResponse<h>> continuation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequestOnSuspend(new LiveUnFollowRequest(str, j16, j3), continuation) : iPatchRedirector.redirect((short) 7, this, str, Long.valueOf(j3), Long.valueOf(j16), continuation);
    }
}
