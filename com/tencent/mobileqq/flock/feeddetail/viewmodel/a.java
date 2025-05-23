package com.tencent.mobileqq.flock.feeddetail.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.flock.event.FlockDeleteFeedEvent;
import com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean;
import com.tencent.mobileqq.flock.feeddetail.request.FlockDeleteFeedRequest;
import com.tencent.mobileqq.flock.feeddetail.request.FlockGetFeedDetailRequest;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.richframework.data.base.UIStateData;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 '2\u00020\u0001:\u0001(B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\u0004J\u0006\u0010\f\u001a\u00020\u0004R \u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R#\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R \u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0011R#\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000e0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0015\u001a\u0004\b\u001c\u0010\u0017R$\u0010$\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001e8\u0006@BX\u0086.\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006)"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Ly45/b;", "feed", "", "P1", "", "getLogTag", "Landroid/content/Intent;", "intent", "T1", "refresh", "O1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/richframework/data/base/UIStateData;", "Lcom/tencent/mobileqq/flock/feeddetail/bean/a;", "i", "Landroidx/lifecycle/MutableLiveData;", "_feedDetailData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "R1", "()Landroidx/lifecycle/LiveData;", "feedDetailData", BdhLogUtil.LogTag.Tag_Conn, "_deleteFeedData", "D", "Q1", "deleteFeedData", "Lcom/tencent/mobileqq/flock/feeddetail/bean/FlockFeedDetailInitBean;", "<set-?>", "E", "Lcom/tencent/mobileqq/flock/feeddetail/bean/FlockFeedDetailInitBean;", "S1", "()Lcom/tencent/mobileqq/flock/feeddetail/bean/FlockFeedDetailInitBean;", "initBean", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<Unit>> _deleteFeedData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<Unit>> deleteFeedData;

    /* renamed from: E, reason: from kotlin metadata */
    private FlockFeedDetailInitBean initBean;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> _feedDetailData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> feedDetailData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/flock/feeddetail/viewmodel/a$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.flock.feeddetail.viewmodel.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes12.dex */
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
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/flock/feeddetail/viewmodel/a$b", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "La55/b;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class b implements VSDispatchObserver.OnVSRspCallBack<a55.b> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ y45.b f210122b;

        b(y45.b bVar) {
            this.f210122b = bVar;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) bVar);
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable a55.b rsp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, request, Boolean.valueOf(isSuccess), Long.valueOf(retCode), errMsg, rsp);
                return;
            }
            int i3 = RFWLog.USR;
            if (request != null) {
                str = request.getTraceId();
            } else {
                str = null;
            }
            RFWLog.i("FlockFeedDetailViewModel", i3, "deleteFeed, onReceive, traceId:" + str + ", isSuccess:" + isSuccess + ", retCode:" + retCode + ", errMsg:" + errMsg);
            if (isSuccess && retCode == 0 && rsp != null) {
                a.this._deleteFeedData.postValue(UIStateData.obtainSuccess(false));
                a.this.P1(this.f210122b);
            } else {
                a.this._deleteFeedData.postValue(UIStateData.obtainError(errMsg));
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J6\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/mobileqq/flock/feeddetail/viewmodel/a$c", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lz45/b;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes12.dex */
    public static final class c implements VSDispatchObserver.OnVSRspCallBack<z45.b> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(@Nullable BaseRequest request, boolean isSuccess, long retCode, @Nullable String errMsg, @Nullable z45.b rsp) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, request, Boolean.valueOf(isSuccess), Long.valueOf(retCode), errMsg, rsp);
                return;
            }
            int i3 = RFWLog.USR;
            if (request != null) {
                str = request.getTraceId();
            } else {
                str = null;
            }
            RFWLog.i("FlockFeedDetailViewModel", i3, "refresh, onReceive, traceId:" + str + ", isSuccess:" + isSuccess + ", retCode:" + retCode + ", errMsg:" + errMsg);
            if (isSuccess && retCode == 0 && rsp != null) {
                MutableLiveData mutableLiveData = a.this._feedDetailData;
                UIStateData obtainSuccess = UIStateData.obtainSuccess(VSNetworkHelper.isProtocolCache(errMsg));
                y45.b bVar = rsp.f451895a;
                Intrinsics.checkNotNullExpressionValue(bVar, "rsp.feed");
                mutableLiveData.postValue(obtainSuccess.setData(false, new com.tencent.mobileqq.flock.feeddetail.bean.a(bVar)).setFinish(true));
                return;
            }
            a.this._feedDetailData.postValue(UIStateData.obtainError(errMsg).setRetCode(retCode));
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(34523);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> mutableLiveData = new MutableLiveData<>();
        this._feedDetailData = mutableLiveData;
        this.feedDetailData = mutableLiveData;
        MutableLiveData<UIStateData<Unit>> mutableLiveData2 = new MutableLiveData<>();
        this._deleteFeedData = mutableLiveData2;
        this.deleteFeedData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P1(y45.b feed) {
        SimpleEventBus.getInstance().dispatchEvent(new FlockDeleteFeedEvent(feed));
    }

    public final void O1() {
        y45.b bVar;
        com.tencent.mobileqq.flock.feeddetail.bean.a data;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a> value = this._feedDetailData.getValue();
        if (value != null && (data = value.getData()) != null) {
            bVar = data.a();
        } else {
            bVar = null;
        }
        if (bVar == null) {
            return;
        }
        this._deleteFeedData.postValue(UIStateData.obtainLoading());
        sendRequest(new FlockDeleteFeedRequest(bVar), new b(bVar));
    }

    @NotNull
    public final LiveData<UIStateData<Unit>> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.deleteFeedData;
    }

    @NotNull
    public final LiveData<UIStateData<com.tencent.mobileqq.flock.feeddetail.bean.a>> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.feedDetailData;
    }

    @NotNull
    public final FlockFeedDetailInitBean S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (FlockFeedDetailInitBean) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        FlockFeedDetailInitBean flockFeedDetailInitBean = this.initBean;
        if (flockFeedDetailInitBean != null) {
            return flockFeedDetailInitBean;
        }
        Intrinsics.throwUninitializedPropertyAccessException("initBean");
        return null;
    }

    public final void T1(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Serializable serializableExtra = intent.getSerializableExtra("key_bundle_common_init_bean");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean");
        this.initBean = (FlockFeedDetailInitBean) serializableExtra;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FlockFeedDetailViewModel";
    }

    public final void refresh() {
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        String userId = S1().getUserId();
        if (userId == null) {
            str = "";
        } else {
            str = userId;
        }
        String feedId = S1().getFeedId();
        long createTime = S1().getCreateTime();
        String eUid = S1().getEUid();
        if (eUid == null) {
            str2 = "";
        } else {
            str2 = eUid;
        }
        sendRequest(new FlockGetFeedDetailRequest(0, str, feedId, createTime, str2), new c());
    }
}
