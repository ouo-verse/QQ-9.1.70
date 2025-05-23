package com.tencent.mobileqq.qqlive.sail.ui.prepare;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.login.ILiveLoginApi;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.config.QQLiveBusinessConfig;
import com.tencent.mobileqq.qqlive.data.auth.QQLiveRealNameAuthData;
import com.tencent.mobileqq.qqlive.data.user.LiveUserInfo;
import com.tencent.mobileqq.qqlive.sail.model.AnchorRoomInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.LocationInfo;
import com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetAudienceInfoViewableReq;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetRealNameAuthReq;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetRedPointRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0016\u0018\u0000 J2\u00020\u0001:\u0001KB\u0007\u00a2\u0006\u0004\bH\u0010IJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nJ\u0013\u0010\u000e\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u00122\u0006\u0010\u0011\u001a\u00020\u0010J\b\u0010\u0014\u001a\u00020\u0004H\u0014J\u0006\u0010\u0015\u001a\u00020\u0004R\"\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR$\u0010\"\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\r8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u001d\u0010)\u001a\b\u0012\u0004\u0012\u00020$0#8\u0006\u00a2\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010-\u001a\b\u0012\u0004\u0012\u00020*0#8\u0006\u00a2\u0006\f\n\u0004\b+\u0010&\u001a\u0004\b,\u0010(R\u001d\u00101\u001a\b\u0012\u0004\u0012\u00020.0#8\u0006\u00a2\u0006\f\n\u0004\b/\u0010&\u001a\u0004\b0\u0010(R\u001d\u00105\u001a\b\u0012\u0004\u0012\u0002020#8\u0006\u00a2\u0006\f\n\u0004\b3\u0010&\u001a\u0004\b4\u0010(R%\u0010:\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u000106060#8\u0006\u00a2\u0006\f\n\u0004\b8\u0010&\u001a\u0004\b9\u0010(R%\u0010=\u001a\u0010\u0012\f\u0012\n 7*\u0004\u0018\u000106060#8\u0006\u00a2\u0006\f\n\u0004\b;\u0010&\u001a\u0004\b<\u0010(R\"\u0010A\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010\u0017\u001a\u0004\b?\u0010\u0019\"\u0004\b@\u0010\u001bR\"\u0010G\u001a\u0002068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "Lcom/tencent/mobileqq/qqlive/sail/model/AnchorRoomInfo;", "roomInfo", "", "b2", "M1", "", "roomType", "Z1", "", "errCode", "c2", "Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRealNameAuthData;", "Q1", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/qqlive/sail/room/l;", "L1", "onCleared", "R1", "i", "J", "getRoomId", "()J", "setRoomId", "(J)V", "roomId", "<set-?>", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRealNameAuthData;", "P1", "()Lcom/tencent/mobileqq/qqlive/data/auth/QQLiveRealNameAuthData;", "realNameAuthData", "Landroidx/lifecycle/MutableLiveData;", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "U1", "()Landroidx/lifecycle/MutableLiveData;", "roomName", "Lcom/tencent/mobileqq/qqlive/sail/model/common/RoomCoverInfo;", "D", "N1", "coverInfo", "Lgr4/k;", "E", "O1", "curLabel", "Lcom/tencent/mobileqq/qqlive/sail/model/common/LocationInfo;", UserInfo.SEX_FEMALE, "getLocationInfo", "locationInfo", "", "kotlin.jvm.PlatformType", "G", "W1", "isProtocolChecked", "H", "S1", "redPointData", "I", "T1", ICustomDataEditor.STRING_ARRAY_PARAM_2, "redPointTaskId", "Z", "X1", "()Z", "setReadyToLive", "(Z)V", "isReadyToLive", "<init>", "()V", "K", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLivePrepareViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> roomName;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<RoomCoverInfo> coverInfo;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<gr4.k> curLabel;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<LocationInfo> locationInfo;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> isProtocolChecked;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> redPointData;

    /* renamed from: I, reason: from kotlin metadata */
    private long redPointTaskId;

    /* renamed from: J, reason: from kotlin metadata */
    private boolean isReadyToLive;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private long roomId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private QQLiveRealNameAuthData realNameAuthData;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel$a;", "", "", "START_LIVE_ERROR_TYPE_DIALOG", "I", "START_LIVE_ERROR_TYPE_PASS", "START_LIVE_ERROR_TYPE_TOAST", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareViewModel$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/sail/ui/prepare/QQLivePrepareViewModel$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lir4/b;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes17.dex */
    public static final class b implements ILiveNetRequest.Callback<ir4.b> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) QQLivePrepareViewModel.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<ir4.b> response) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            if (response.isFailed()) {
                AegisLogger.INSTANCE.e("Open_Live|LivePrepareFragmentViewModel", "fetchAudienceInfoViewable", "onFailed, errCode=" + response.getRetCode() + ", errMsg=" + response.getErrMsg());
                return;
            }
            ir4.b rsp = response.getRsp();
            boolean z16 = false;
            if (rsp != null && rsp.f408444a == 1) {
                z16 = true;
            }
            AegisLogger.INSTANCE.i("Open_Live|LivePrepareFragmentViewModel", "fetchAudienceInfoViewable", "onSuccess, viewable=" + z16);
            ct3.a.n("MMKV_KEY_HIDE_ROOM_NICKNAME", QQLivePrepareViewModel.this.getRoomId(), z16 ^ true);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52949);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 21)) {
            redirector.redirect((short) 21);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLivePrepareViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.realNameAuthData = new QQLiveRealNameAuthData();
        this.roomName = new MutableLiveData<>();
        this.coverInfo = new MutableLiveData<>();
        this.curLabel = new MutableLiveData<>();
        this.locationInfo = new MutableLiveData<>();
        Boolean bool = Boolean.FALSE;
        this.isProtocolChecked = new MutableLiveData<>(bool);
        this.redPointData = new MutableLiveData<>(bool);
    }

    private final void M1() {
        ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveGetAudienceInfoViewableReq(this.roomId), new b());
    }

    private final void b2(AnchorRoomInfo roomInfo) {
        com.tencent.mobileqq.qqlive.sail.model.common.UserInfo j3 = roomInfo.j();
        if (j3 != null && j3.f() > 0) {
            if (((ILiveLoginApi) QRoute.api(ILiveLoginApi.class)).updateUserInfo(QQLiveBusinessConfig.QQLIVE_APP_ID, String.valueOf(com.tencent.mobileqq.qqlive.sail.c.f272176a.G()), new LiveUserInfo(j3.f(), j3.a(), j3.b(), j3.c()))) {
                AegisLogger.INSTANCE.i("Open_Live|LivePrepareFragmentViewModel", "updateLoginUser", "updateUserInfo success, name=" + j3.b() + ", id=" + j3.f() + ", sex=" + j3.c());
                return;
            }
            AegisLogger.INSTANCE.i("Open_Live|LivePrepareFragmentViewModel", "updateLoginUser", "updateUserInfo fail, name=" + j3.b() + ", id=" + j3.f());
        }
    }

    @NotNull
    public final com.tencent.mobileqq.qqlive.sail.room.l<Integer> L1(@NotNull Context context) {
        boolean z16;
        String str;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (com.tencent.mobileqq.qqlive.sail.room.l) iPatchRedirector.redirect((short) 18, (Object) this, (Object) context);
        }
        Intrinsics.checkNotNullParameter(context, "context");
        if (!NetworkUtil.isNetworkAvailable()) {
            return new com.tencent.mobileqq.qqlive.sail.room.l<>(1, -1L, "\u7f51\u7edc\u5df2\u65ad\u5f00\uff0c\u8bf7\u8fde\u63a5\u540e\u91cd\u8bd5\u3002", 0, 8, null);
        }
        if (this.realNameAuthData.getAuthState() != 2 && this.realNameAuthData.getAuthState() != 0) {
            if (this.realNameAuthData.getAuthState() == 3) {
                return new com.tencent.mobileqq.qqlive.sail.room.l<>(2, this.realNameAuthData.getAuthState(), context.getString(R.string.f210295hq), 0, 8, null);
            }
            if (this.curLabel.getValue() == null) {
                return new com.tencent.mobileqq.qqlive.sail.room.l<>(1, -1L, "\u8bf7\u9009\u62e9\u76f4\u64ad\u5185\u5bb9", 0, 8, null);
            }
            if (Intrinsics.areEqual(this.isProtocolChecked.getValue(), Boolean.FALSE)) {
                return new com.tencent.mobileqq.qqlive.sail.room.l<>(2, -1L, context.getString(R.string.f210895jc), 0, 8, null);
            }
            String value = this.roomName.getValue();
            if (value != null && value.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                return new com.tencent.mobileqq.qqlive.sail.room.l<>(1, -1L, context.getString(R.string.f210195hg), 0, 8, null);
            }
            RoomCoverInfo value2 = this.coverInfo.getValue();
            if (value2 != null) {
                str = value2.e();
            } else {
                str = null;
            }
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (z17) {
                return new com.tencent.mobileqq.qqlive.sail.room.l<>(1, -1L, context.getString(R.string.f210105h8), 0, 8, null);
            }
            return new com.tencent.mobileqq.qqlive.sail.room.l<>(0, 0L, null, 0, 14, null);
        }
        return new com.tencent.mobileqq.qqlive.sail.room.l<>(2, this.realNameAuthData.getAuthState(), context.getString(R.string.f210545ie), 0, 8, null);
    }

    @NotNull
    public final MutableLiveData<RoomCoverInfo> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.coverInfo;
    }

    @NotNull
    public final MutableLiveData<gr4.k> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.curLabel;
    }

    @NotNull
    public final QQLiveRealNameAuthData P1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (QQLiveRealNameAuthData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.realNameAuthData;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047  */
    @Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object Q1(@NotNull Continuation<? super QQLiveRealNameAuthData> continuation) {
        QQLivePrepareViewModel$getRealNameAuthState$1 qQLivePrepareViewModel$getRealNameAuthState$1;
        Object coroutine_suspended;
        int i3;
        QQLivePrepareViewModel qQLivePrepareViewModel;
        QQLiveResponse qQLiveResponse;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return iPatchRedirector.redirect((short) 17, (Object) this, (Object) continuation);
        }
        if (continuation instanceof QQLivePrepareViewModel$getRealNameAuthState$1) {
            qQLivePrepareViewModel$getRealNameAuthState$1 = (QQLivePrepareViewModel$getRealNameAuthState$1) continuation;
            int i16 = qQLivePrepareViewModel$getRealNameAuthState$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                qQLivePrepareViewModel$getRealNameAuthState$1.label = i16 - Integer.MIN_VALUE;
                Object obj = qQLivePrepareViewModel$getRealNameAuthState$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = qQLivePrepareViewModel$getRealNameAuthState$1.label;
                if (i3 == 0) {
                    if (i3 == 1) {
                        qQLivePrepareViewModel = (QQLivePrepareViewModel) qQLivePrepareViewModel$getRealNameAuthState$1.L$0;
                        ResultKt.throwOnFailure(obj);
                    } else {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                } else {
                    ResultKt.throwOnFailure(obj);
                    ILiveNetRequest iLiveNetRequest = (ILiveNetRequest) QRoute.api(ILiveNetRequest.class);
                    QQLiveGetRealNameAuthReq qQLiveGetRealNameAuthReq = new QQLiveGetRealNameAuthReq(1);
                    qQLivePrepareViewModel$getRealNameAuthState$1.L$0 = this;
                    qQLivePrepareViewModel$getRealNameAuthState$1.label = 1;
                    obj = iLiveNetRequest.sendRequestOnSuspend(qQLiveGetRealNameAuthReq, qQLivePrepareViewModel$getRealNameAuthState$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    qQLivePrepareViewModel = this;
                }
                qQLiveResponse = (QQLiveResponse) obj;
                QQLiveRealNameAuthData qQLiveRealNameAuthData = new QQLiveRealNameAuthData();
                if (qQLiveResponse.getRsp() == null) {
                    Object rsp = qQLiveResponse.getRsp();
                    Intrinsics.checkNotNull(rsp);
                    qQLiveRealNameAuthData.setAuthState(((fr4.b) rsp).f400375a);
                    Object rsp2 = qQLiveResponse.getRsp();
                    Intrinsics.checkNotNull(rsp2);
                    String str = ((fr4.b) rsp2).f400376b;
                    Intrinsics.checkNotNullExpressionValue(str, "response.rsp!!.verifyUrl");
                    qQLiveRealNameAuthData.setVerifyUrl(str);
                    Object rsp3 = qQLiveResponse.getRsp();
                    Intrinsics.checkNotNull(rsp3);
                    String str2 = ((fr4.b) rsp3).f400377c;
                    Intrinsics.checkNotNullExpressionValue(str2, "response.rsp!!.tipsContent");
                    qQLiveRealNameAuthData.setTipsContent(str2);
                } else {
                    qQLiveRealNameAuthData.setTipsContent("\u5b9e\u540d\u8ba4\u8bc1\u5931\u8d25");
                }
                qQLivePrepareViewModel.realNameAuthData = qQLiveRealNameAuthData;
                AegisLogger.INSTANCE.i("Open_Live|LivePrepareFragmentViewModel", "getRealNameAuthState", qQLiveRealNameAuthData.toString());
                return qQLiveRealNameAuthData;
            }
        }
        qQLivePrepareViewModel$getRealNameAuthState$1 = new QQLivePrepareViewModel$getRealNameAuthState$1(this, continuation);
        Object obj2 = qQLivePrepareViewModel$getRealNameAuthState$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = qQLivePrepareViewModel$getRealNameAuthState$1.label;
        if (i3 == 0) {
        }
        qQLiveResponse = (QQLiveResponse) obj2;
        QQLiveRealNameAuthData qQLiveRealNameAuthData2 = new QQLiveRealNameAuthData();
        if (qQLiveResponse.getRsp() == null) {
        }
        qQLivePrepareViewModel.realNameAuthData = qQLiveRealNameAuthData2;
        AegisLogger.INSTANCE.i("Open_Live|LivePrepareFragmentViewModel", "getRealNameAuthState", qQLiveRealNameAuthData2.toString());
        return qQLiveRealNameAuthData2;
    }

    public final void R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetRedPointRequest(0), new Function1<QQLiveResponse<vr4.d>, Unit>() { // from class: com.tencent.mobileqq.qqlive.sail.ui.prepare.QQLivePrepareViewModel$getRedPoint$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLivePrepareViewModel.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<vr4.d> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<vr4.d> response) {
                    vr4.e eVar;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    AegisLogger.Companion companion = AegisLogger.INSTANCE;
                    companion.i("Open_Live|LivePrepareFragmentViewModel", "getRedPoint", "errCode=" + response.getRetCode() + ", msg=" + response.getErrMsg());
                    long j3 = 0;
                    if (!response.isFailed() && response.getRsp() != null) {
                        vr4.d rsp = response.getRsp();
                        Intrinsics.checkNotNull(rsp);
                        if (rsp.f443280a != null) {
                            QQLivePrepareViewModel qQLivePrepareViewModel = QQLivePrepareViewModel.this;
                            vr4.d rsp2 = response.getRsp();
                            if (rsp2 != null && (eVar = rsp2.f443280a) != null) {
                                j3 = eVar.f443282b;
                            }
                            qQLivePrepareViewModel.a2(j3);
                            QQLivePrepareViewModel.this.S1().postValue(Boolean.TRUE);
                            return;
                        }
                    }
                    companion.w("Open_Live|LivePrepareFragmentViewModel", "[getRedPoint] no red point");
                    QQLivePrepareViewModel.this.a2(0L);
                    QQLivePrepareViewModel.this.S1().postValue(Boolean.FALSE);
                }
            });
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.redPointData;
    }

    public final long T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this)).longValue();
        }
        return this.redPointTaskId;
    }

    @NotNull
    public final MutableLiveData<String> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.roomName;
    }

    @NotNull
    public final MutableLiveData<Boolean> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.isProtocolChecked;
    }

    public final boolean X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.isReadyToLive;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Z1(int roomType, @Nullable AnchorRoomInfo roomInfo) {
        int i3;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, roomType, (Object) roomInfo);
            return;
        }
        if (roomInfo == null) {
            return;
        }
        this.isReadyToLive = true;
        this.roomId = roomInfo.p().g();
        this.realNameAuthData.setAuthState(1);
        if (roomType == 0) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        MutableLiveData<gr4.k> mutableLiveData = this.curLabel;
        List<gr4.k> e16 = roomInfo.p().e();
        gr4.k kVar = null;
        if (e16 != null) {
            Iterator<T> it = e16.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((gr4.k) next).f403141e == i3) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    kVar = next;
                    break;
                }
            }
            kVar = kVar;
        }
        mutableLiveData.postValue(kVar);
        this.coverInfo.postValue(roomInfo.r().c());
        this.roomName.postValue(roomInfo.r().j());
        b2(roomInfo);
        M1();
    }

    public final void a2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, j3);
        } else {
            this.redPointTaskId = j3;
        }
    }

    public final void c2(long errCode) {
        QQLiveRealNameAuthData qQLiveRealNameAuthData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, errCode);
            return;
        }
        if (errCode == 1004) {
            qQLiveRealNameAuthData = new QQLiveRealNameAuthData(2);
        } else if (errCode == 1010) {
            qQLiveRealNameAuthData = new QQLiveRealNameAuthData(3);
        } else {
            qQLiveRealNameAuthData = new QQLiveRealNameAuthData();
        }
        this.realNameAuthData = qQLiveRealNameAuthData;
    }

    public final long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.roomId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            super.onCleared();
        }
    }
}
