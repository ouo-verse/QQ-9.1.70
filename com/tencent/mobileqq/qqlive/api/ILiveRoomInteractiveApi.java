package com.tencent.mobileqq.qqlive.api;

import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import hr4.b;
import hr4.d;
import hr4.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import rq3.g;
import xq4.c;
import xq4.e;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001JD\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nH&JC\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u0010J2\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\nH&J1\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0013\u0010\u0014J2\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\nH&J1\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0014J*\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\nH&J)\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0018\u0010\u0019J*\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\nH&J)\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u001b\u0010\u0019J*\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\nH&J\"\u0010!\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\u001e2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\nH&J:\u0010$\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\nH&J9\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b$\u0010%J*\u0010'\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\nH&J)\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b'\u0010\u0019J2\u0010*\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00022\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020)\u0018\u00010\nH&J1\u0010*\u001a\b\u0012\u0004\u0012\u00020)0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u0002H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b*\u0010+J*\u0010.\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u00042\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010\nH&J)\u0010.\u001a\b\u0012\u0004\u0012\u00020-0\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0004H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0004\b.\u0010\u0019\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/ILiveRoomInteractiveApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "", "appId", "", "roomId", "msg", "", "Lrq3/b;", "exts", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lrq3/g;", "callback", "", "sendMessage", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "(Ljava/lang/String;JLjava/lang/String;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "anchorId", "Lhr4/d;", "followAnchor", "(Ljava/lang/String;JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lhr4/h;", "unFollowAnchor", "Lhr4/b;", "checkFollowAnchor", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lxq4/c;", "getAnnounce", "Lxq4/e;", "getPlatformAnnounce", "", "type", "Ltr4/b;", "getPrivacySetting", "announce", "Lxq4/g;", "setAnnounce", "(Ljava/lang/String;JJLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lit3/d;", "getMemberAccount", "programId", "Lst3/b;", "getEndPageInfo", "(Ljava/lang/String;JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uid", "Lrr4/d;", "getUserCardInfo", "qq-live-sdk-api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes17.dex */
public interface ILiveRoomInteractiveApi extends QRouteApi {

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class DefaultImpls {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void checkFollowAnchor$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.checkFollowAnchor(str, j3, (ILiveNetRequest.Callback<b>) callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkFollowAnchor");
        }

        public static /* synthetic */ void followAnchor$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, long j16, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.followAnchor(str, j3, j16, (ILiveNetRequest.Callback<d>) callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: followAnchor");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void getAnnounce$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.getAnnounce(str, j3, (ILiveNetRequest.Callback<c>) callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getAnnounce");
        }

        public static /* synthetic */ void getEndPageInfo$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, String str2, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.getEndPageInfo(str, j3, str2, (ILiveNetRequest.Callback<st3.b>) callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getEndPageInfo");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void getMemberAccount$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.getMemberAccount(str, j3, (ILiveNetRequest.Callback<it3.d>) callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMemberAccount");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void getPlatformAnnounce$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.getPlatformAnnounce(str, j3, callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPlatformAnnounce");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void getPrivacySetting$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, int i3, ILiveNetRequest.Callback callback, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.getPrivacySetting(i3, callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getPrivacySetting");
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void getUserCardInfo$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 4) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.getUserCardInfo(str, j3, (ILiveNetRequest.Callback<rr4.d>) callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUserCardInfo");
        }

        public static /* synthetic */ void sendMessage$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, String str2, List list, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessage");
            }
            iLiveRoomInteractiveApi.sendMessage(str, j3, str2, (List<rq3.b>) ((i3 & 8) != 0 ? null : list), (ILiveNetRequest.Callback<g>) ((i3 & 16) != 0 ? null : callback));
        }

        public static /* synthetic */ void setAnnounce$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, long j16, String str2, ILiveNetRequest.Callback callback, int i3, Object obj) {
            ILiveNetRequest.Callback callback2;
            if (obj == null) {
                if ((i3 & 16) != 0) {
                    callback2 = null;
                } else {
                    callback2 = callback;
                }
                iLiveRoomInteractiveApi.setAnnounce(str, j3, j16, str2, (ILiveNetRequest.Callback<xq4.g>) callback2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setAnnounce");
        }

        public static /* synthetic */ void unFollowAnchor$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, long j16, ILiveNetRequest.Callback callback, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 8) != 0) {
                    callback = null;
                }
                iLiveRoomInteractiveApi.unFollowAnchor(str, j3, j16, (ILiveNetRequest.Callback<h>) callback);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: unFollowAnchor");
        }

        public static /* synthetic */ Object sendMessage$default(ILiveRoomInteractiveApi iLiveRoomInteractiveApi, String str, long j3, String str2, List list, Continuation continuation, int i3, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendMessage");
            }
            if ((i3 & 8) != 0) {
                list = null;
            }
            return iLiveRoomInteractiveApi.sendMessage(str, j3, str2, (List<rq3.b>) list, (Continuation<? super QQLiveResponse<g>>) continuation);
        }
    }

    @Nullable
    Object checkFollowAnchor(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<b>> continuation);

    void checkFollowAnchor(@NotNull String appId, long anchorId, @Nullable ILiveNetRequest.Callback<b> callback);

    @Nullable
    Object followAnchor(@NotNull String str, long j3, long j16, @NotNull Continuation<? super QQLiveResponse<d>> continuation);

    void followAnchor(@NotNull String appId, long roomId, long anchorId, @Nullable ILiveNetRequest.Callback<d> callback);

    @Nullable
    Object getAnnounce(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<c>> continuation);

    void getAnnounce(@NotNull String appId, long roomId, @Nullable ILiveNetRequest.Callback<c> callback);

    @Nullable
    Object getEndPageInfo(@NotNull String str, long j3, @NotNull String str2, @NotNull Continuation<? super QQLiveResponse<st3.b>> continuation);

    void getEndPageInfo(@NotNull String appId, long anchorId, @NotNull String programId, @Nullable ILiveNetRequest.Callback<st3.b> callback);

    @Nullable
    Object getMemberAccount(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<it3.d>> continuation);

    void getMemberAccount(@NotNull String appId, long roomId, @Nullable ILiveNetRequest.Callback<it3.d> callback);

    void getPlatformAnnounce(@NotNull String appId, long roomId, @Nullable ILiveNetRequest.Callback<e> callback);

    void getPrivacySetting(int type, @Nullable ILiveNetRequest.Callback<tr4.b> callback);

    @Nullable
    Object getUserCardInfo(@NotNull String str, long j3, @NotNull Continuation<? super QQLiveResponse<rr4.d>> continuation);

    void getUserCardInfo(@NotNull String appId, long uid, @Nullable ILiveNetRequest.Callback<rr4.d> callback);

    @Nullable
    Object sendMessage(@NotNull String str, long j3, @NotNull String str2, @Nullable List<rq3.b> list, @NotNull Continuation<? super QQLiveResponse<g>> continuation);

    void sendMessage(@NotNull String appId, long roomId, @NotNull String msg2, @Nullable List<rq3.b> exts, @Nullable ILiveNetRequest.Callback<g> callback);

    @Nullable
    Object setAnnounce(@NotNull String str, long j3, long j16, @NotNull String str2, @NotNull Continuation<? super QQLiveResponse<xq4.g>> continuation);

    void setAnnounce(@NotNull String appId, long roomId, long anchorId, @NotNull String announce, @Nullable ILiveNetRequest.Callback<xq4.g> callback);

    @Nullable
    Object unFollowAnchor(@NotNull String str, long j3, long j16, @NotNull Continuation<? super QQLiveResponse<h>> continuation);

    void unFollowAnchor(@NotNull String appId, long roomId, long anchorId, @Nullable ILiveNetRequest.Callback<h> callback);
}
