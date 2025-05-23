package com.tencent.mobileqq.qqlive.api.room.impl;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.ilive.pb.LiveRoomList;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.room.IRequestRoomStatus;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetLivingAnchorInfoRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/RequestRoomStatusImpl;", "Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus;", "()V", Const.BUNDLE_KEY_REQUEST, "", "roomId", "", "callback", "Lcom/tencent/mobileqq/qqlive/api/room/IRequestRoomStatus$IRoomResult;", "Companion", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes17.dex */
public final class RequestRoomStatusImpl implements IRequestRoomStatus {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    private static final String TAG = "Audience|RequestRoomStatusImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/tencent/mobileqq/qqlive/api/room/impl/RequestRoomStatusImpl$Companion;", "", "()V", "TAG", "", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes17.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(21980);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public RequestRoomStatusImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.room.IRequestRoomStatus
    public void request(final long roomId, @Nullable final IRequestRoomStatus.IRoomResult callback) {
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(roomId), callback);
            return;
        }
        AegisLogger.INSTANCE.i(TAG, Const.BUNDLE_KEY_REQUEST, "roomId=" + roomId);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(Long.valueOf(roomId));
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetLivingAnchorInfoRequest(listOf), new Function1<QQLiveResponse<LiveRoomList.GetLivingAnchorInfoRsp>, Unit>(roomId) { // from class: com.tencent.mobileqq.qqlive.api.room.impl.RequestRoomStatusImpl$request$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ long $roomId;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$roomId = roomId;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, IRequestRoomStatus.IRoomResult.this, Long.valueOf(roomId));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<LiveRoomList.GetLivingAnchorInfoRsp> qQLiveResponse) {
                invoke2(qQLiveResponse);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull QQLiveResponse<LiveRoomList.GetLivingAnchorInfoRsp> response) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                    return;
                }
                Intrinsics.checkNotNullParameter(response, "response");
                LiveRoomList.GetLivingAnchorInfoRsp rsp = response.getRsp();
                if (!response.isFailed() && rsp != null) {
                    boolean z16 = rsp.feeds.size() > 0;
                    AegisLogger.INSTANCE.i("Audience|RequestRoomStatusImpl", Const.BUNDLE_KEY_REQUEST, "success, roomId=" + this.$roomId + ", living=" + z16);
                    IRequestRoomStatus.IRoomResult iRoomResult = IRequestRoomStatus.IRoomResult.this;
                    if (iRoomResult != null) {
                        iRoomResult.onResult(this.$roomId, z16, 0, null);
                        return;
                    }
                    return;
                }
                AegisLogger.INSTANCE.i("Audience|RequestRoomStatusImpl", Const.BUNDLE_KEY_REQUEST, "failed, response=" + response);
                IRequestRoomStatus.IRoomResult iRoomResult2 = IRequestRoomStatus.IRoomResult.this;
                if (iRoomResult2 != null) {
                    iRoomResult2.onResult(this.$roomId, true, (int) response.getRetCode(), response.getErrMsg());
                }
            }
        });
    }
}
