package com.tencent.mobileqq.qqlive.anchor.prepare;

import android.text.TextUtils;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.anchor.room.helper.q;
import com.tencent.mobileqq.qqlive.anchor.room.helper.s;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomThirdPushCallback;
import com.tencent.mobileqq.qqlive.data.anchor.params.QQLiveAnchorAutoCheckPullPlayParams;
import com.tencent.mobileqq.qqlive.data.anchor.room.QQLiveAnchorRoomInfo;
import com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataThirdPushCheck;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveAnchorClosePushPullBroadcastRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001\u0018B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J&\u0010\u0010\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0011\u001a\u00020\u0004H\u0016J\u0012\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0015H\u0016R\u0016\u0010\u001a\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010!\u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/prepare/b;", "Lcom/tencent/mobileqq/qqlive/api/anchor/prepare/IQQLiveAnchorPrepareObs;", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "qqLiveSDK", "", "init", "", "selected", "onSelected", "destroy", "Lcom/tencent/mobileqq/qqlive/data/anchor/room/QQLiveAnchorRoomInfo;", "roomInfo", "Lcom/tencent/mobileqq/qqlive/data/anchor/params/QQLiveAnchorAutoCheckPullPlayParams;", "params", "Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveAnchorRoomThirdPushCallback;", "callback", "getPushInfo", "startCheck", "anchorRoomThirdPushCallback", "updateLiveStatCallback", "stopCheck", "", "programId", "exitObsRoom", "a", "Z", "isDestroy", "b", "Lcom/tencent/mobileqq/qqlive/api/IQQLiveSDK;", "liveSDK", "Lcom/tencent/mobileqq/qqlive/anchor/room/helper/q;", "c", "Lcom/tencent/mobileqq/qqlive/anchor/room/helper/q;", "requestHelper", "Lcom/tencent/mobileqq/qqlive/anchor/room/helper/s;", "d", "Lcom/tencent/mobileqq/qqlive/anchor/room/helper/s;", "checker", "e", "Lcom/tencent/mobileqq/qqlive/callback/anchor/IQQLiveAnchorRoomThirdPushCallback;", "Landroidx/lifecycle/Observer;", "f", "Landroidx/lifecycle/Observer;", "liveStatObserver", "<init>", "()V", "g", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class b implements IQQLiveAnchorPrepareObs {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroy;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQLiveSDK liveSDK;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final q requestHelper;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private s checker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IQQLiveAnchorRoomThirdPushCallback callback;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Observer<Boolean> liveStatObserver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/anchor/prepare/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.prepare.b$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/qqlive/anchor/prepare/b$b", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest$Callback;", "Lgr4/c;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "response", "", "onResponse", "qq-live-sdk-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.anchor.prepare.b$b, reason: collision with other inner class name */
    /* loaded from: classes17.dex */
    public static final class C8351b implements ILiveNetRequest.Callback<gr4.c> {
        static IPatchRedirector $redirector_;

        C8351b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) b.this);
            }
        }

        @Override // com.tencent.mobileqq.qqlive.api.ILiveNetRequest.Callback
        public void onResponse(@NotNull QQLiveResponse<gr4.c> response) {
            IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) response);
                return;
            }
            Intrinsics.checkNotNullParameter(response, "response");
            AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorPrepareObs", "exitRoom", "exitRoom onResponse, isSuccess:" + response.isSuccess());
            if (response.isSuccess() && response.getRetCode() == 0) {
                Unit unit = null;
                if (response.getRsp() != null && (iQQLiveAnchorRoomThirdPushCallback = b.this.callback) != null) {
                    iQQLiveAnchorRoomThirdPushCallback.onExit();
                    unit = Unit.INSTANCE;
                }
                if (unit == null) {
                    b bVar = b.this;
                    QQLiveErrorMsg qQLiveErrorMsg = new QQLiveErrorMsg();
                    qQLiveErrorMsg.bizModule = 2;
                    qQLiveErrorMsg.bizErrCode = 10110010;
                    qQLiveErrorMsg.bizErrMsg = "\u9000\u51fa\u5931\u8d25";
                    IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback2 = bVar.callback;
                    if (iQQLiveAnchorRoomThirdPushCallback2 != null) {
                        iQQLiveAnchorRoomThirdPushCallback2.onError(qQLiveErrorMsg);
                        return;
                    }
                    return;
                }
                return;
            }
            QQLiveErrorMsg qQLiveErrorMsg2 = new QQLiveErrorMsg();
            qQLiveErrorMsg2.bizModule = 2;
            qQLiveErrorMsg2.bizErrCode = 10110010;
            qQLiveErrorMsg2.bizErrMsg = "\u9000\u51fa\u5931\u8d25";
            IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback3 = b.this.callback;
            if (iQQLiveAnchorRoomThirdPushCallback3 != null) {
                iQQLiveAnchorRoomThirdPushCallback3.onError(qQLiveErrorMsg2);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.requestHelper = new q();
            this.liveStatObserver = new Observer() { // from class: com.tencent.mobileqq.qqlive.anchor.prepare.a
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    b.c(b.this, (Boolean) obj);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(b this$0, Boolean it) {
        IQQLiveAnchorRoomThirdPushCallback iQQLiveAnchorRoomThirdPushCallback;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!this$0.isDestroy && (iQQLiveAnchorRoomThirdPushCallback = this$0.callback) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            iQQLiveAnchorRoomThirdPushCallback.onThirdPushChecked(new QQLiveAnchorDataThirdPushCheck(it.booleanValue(), null));
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareSubModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorPrepareObs", "destroy", "destroy, isDestroy:" + this.isDestroy);
        stopCheck();
        this.isDestroy = true;
        this.callback = null;
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs
    public void exitObsRoom(@NotNull String programId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) programId);
            return;
        }
        Intrinsics.checkNotNullParameter(programId, "programId");
        if (!TextUtils.isEmpty(programId)) {
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest(new QQLiveAnchorClosePushPullBroadcastRequest(programId), new C8351b());
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs
    public void getPushInfo(@Nullable QQLiveAnchorRoomInfo roomInfo, @Nullable QQLiveAnchorAutoCheckPullPlayParams params, @Nullable IQQLiveAnchorRoomThirdPushCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, roomInfo, params, callback);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorPrepareObs", "getPushInfo", "getPushInfo");
        if (this.isDestroy) {
            return;
        }
        this.requestHelper.d(this.liveSDK, roomInfo, params, callback);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareSubModule
    public void init(@NotNull IQQLiveSDK qqLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qqLiveSDK);
            return;
        }
        Intrinsics.checkNotNullParameter(qqLiveSDK, "qqLiveSDK");
        this.liveSDK = qqLiveSDK;
        this.checker = new s(qqLiveSDK.getLoginModule().getLoginInfo().uid);
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareSubModule
    public void onSelected(boolean selected) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, selected);
            return;
        }
        AegisLogger.INSTANCE.i("Open_Live|QQLiveAnchorPrepareObs", "onSelected", "onSelected: " + selected + ", isDestroy:" + this.isDestroy);
        if (!selected) {
            stopCheck();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs
    public void startCheck() {
        MutableLiveData<Boolean> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        s sVar = this.checker;
        if (sVar != null) {
            sVar.i();
        }
        s sVar2 = this.checker;
        if (sVar2 != null && (e16 = sVar2.e()) != null) {
            e16.observeForever(this.liveStatObserver);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs
    public void stopCheck() {
        MutableLiveData<Boolean> e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.isDestroy) {
            return;
        }
        s sVar = this.checker;
        if (sVar != null) {
            sVar.j();
        }
        s sVar2 = this.checker;
        if (sVar2 != null && (e16 = sVar2.e()) != null) {
            e16.removeObserver(this.liveStatObserver);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.anchor.prepare.IQQLiveAnchorPrepareObs
    public void updateLiveStatCallback(@Nullable IQQLiveAnchorRoomThirdPushCallback anchorRoomThirdPushCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) anchorRoomThirdPushCallback);
        } else {
            if (this.isDestroy) {
                return;
            }
            this.callback = anchorRoomThirdPushCallback;
        }
    }
}
