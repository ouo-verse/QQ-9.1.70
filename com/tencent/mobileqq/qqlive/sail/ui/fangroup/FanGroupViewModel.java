package com.tencent.mobileqq.qqlive.sail.ui.fangroup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.liveroom.impl.room.follow.TGLiveFollowManager;
import com.tencent.timi.game.sso.request.QQLiveFansGroupConfigRequest;
import com.tencent.timi.game.sso.request.QQLiveFansGroupInfoRequest;
import com.tencent.timi.game.sso.request.QQLiveRecordFansGroupShow;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.qlive.trpc_room_global_config.TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004R\u001c\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001f\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u000eR\u001f\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00160\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001c0\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u000eR\u001d\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00108\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/fangroup/FanGroupViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "roomType", "", "anchorUid", "", "O1", "P1", "Q1", "U1", "Landroidx/lifecycle/MutableLiveData;", "Ltrpc/qlive/trpc_room_global_config/TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp;", "i", "Landroidx/lifecycle/MutableLiveData;", "_fanGroupConfig", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "fanGroupConfig", "Lnr4/d;", BdhLogUtil.LogTag.Tag_Conn, "_fanGroupInfo", "D", "S1", "fanGroupInfo", "", "E", "_followStatus", UserInfo.SEX_FEMALE, "T1", "followStatus", "<init>", "()V", "G", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class FanGroupViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<nr4.d> _fanGroupInfo;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<nr4.d> fanGroupInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _followStatus;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> followStatus;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> _fanGroupConfig;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> fanGroupConfig;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/fangroup/FanGroupViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.fangroup.FanGroupViewModel$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/fangroup/FanGroupViewModel$b", "Lcom/tencent/mobileqq/qqlive/callback/follow/IQQLiveCheckFollowCallback;", "", "isFollow", "", "onSuccess", "errCode", "", "errMsg", "onFail", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements IQQLiveCheckFollowCallback {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) FanGroupViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onFail(int errCode, @Nullable String errMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, errCode, (Object) errMsg);
            } else {
                FanGroupViewModel.this._followStatus.postValue(Boolean.FALSE);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.callback.follow.IQQLiveCheckFollowCallback
        public void onSuccess(int isFollow) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                MutableLiveData mutableLiveData = FanGroupViewModel.this._followStatus;
                boolean z16 = true;
                if (isFollow != 1) {
                    z16 = false;
                }
                mutableLiveData.postValue(Boolean.valueOf(z16));
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, isFollow);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51824);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public FanGroupViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> mutableLiveData = new MutableLiveData<>();
        this._fanGroupConfig = mutableLiveData;
        this.fanGroupConfig = mutableLiveData;
        MutableLiveData<nr4.d> mutableLiveData2 = new MutableLiveData<>();
        this._fanGroupInfo = mutableLiveData2;
        this.fanGroupInfo = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>();
        this._followStatus = mutableLiveData3;
        this.followStatus = mutableLiveData3;
    }

    public final void O1(int roomType, long anchorUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Integer.valueOf(roomType), Long.valueOf(anchorUid));
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveFansGroupConfigRequest(anchorUid, roomType), new Function1<QQLiveResponse<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.FanGroupViewModel$fetchFanGroupConfig$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FanGroupViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> response) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    MutableLiveData mutableLiveData3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp rsp = response.getRsp();
                    if (!response.isFailed() && rsp != null) {
                        if (rsp.retcode.get() == 0) {
                            mutableLiveData2 = FanGroupViewModel.this._fanGroupConfig;
                            mutableLiveData2.postValue(rsp);
                            return;
                        }
                        AegisLogger.INSTANCE.w("Audience|FanGroupViewModel", "getFanGroupConfig", "retCode=" + rsp.retcode.get() + ", errMsg=" + rsp.errmsg.get());
                        mutableLiveData3 = FanGroupViewModel.this._fanGroupConfig;
                        mutableLiveData3.postValue(null);
                        return;
                    }
                    AegisLogger.INSTANCE.w("Audience|FanGroupViewModel", "getFanGroupConfig", "failed, " + response);
                    mutableLiveData = FanGroupViewModel.this._fanGroupConfig;
                    mutableLiveData.postValue(null);
                }
            });
        }
    }

    public final void P1(long anchorUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, anchorUid);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveFansGroupInfoRequest(anchorUid), new Function1<QQLiveResponse<nr4.d>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.fangroup.FanGroupViewModel$fetchFanGroupInfo$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FanGroupViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<nr4.d> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<nr4.d> response) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    MutableLiveData mutableLiveData3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    nr4.d rsp = response.getRsp();
                    if (!response.isFailed() && rsp != null) {
                        int i3 = rsp.f421214a;
                        if (i3 == 0) {
                            mutableLiveData2 = FanGroupViewModel.this._fanGroupInfo;
                            mutableLiveData2.postValue(rsp);
                            return;
                        }
                        AegisLogger.INSTANCE.w("Audience|FanGroupViewModel", "getFanGroupConfig", "retCode=" + i3 + ", errMsg=" + rsp.f421215b);
                        mutableLiveData3 = FanGroupViewModel.this._fanGroupInfo;
                        mutableLiveData3.postValue(null);
                        return;
                    }
                    AegisLogger.INSTANCE.w("Audience|FanGroupViewModel", "fetchFanGroupInfo", "failed, " + response);
                    mutableLiveData = FanGroupViewModel.this._fanGroupInfo;
                    mutableLiveData.postValue(null);
                }
            });
        }
    }

    public final void Q1(long anchorUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, anchorUid);
        } else {
            TGLiveFollowManager.f377684a.f(null, anchorUid, new b());
        }
    }

    @NotNull
    public final LiveData<TrpcRoomGlobalConfigOuterClass$GetFansGroupConfigRsp> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.fanGroupConfig;
    }

    @NotNull
    public final LiveData<nr4.d> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.fanGroupInfo;
    }

    @NotNull
    public final LiveData<Boolean> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.followStatus;
    }

    public final void U1(long anchorUid) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, anchorUid);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveRecordFansGroupShow(anchorUid), FanGroupViewModel$markGuideShow$1.INSTANCE);
        }
    }
}
