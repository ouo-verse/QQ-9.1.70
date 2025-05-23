package com.tencent.mobileqq.qqlive.room.livelabel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qqlive.sso.request.QQLiveGetSecondLabelsRequest;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qqlive.common.api.AegisLogger;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u000e\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007J\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0007R\u0014\u0010\r\u001a\u00020\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR'\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R'\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00020\u00078FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0013\u0010\u000f\u001a\u0004\b\u0014\u0010\u0011R\u001c\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/livelabel/QQLiveLabelViewModel;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/mobileqq/qqlive/api/sso/QQLiveResponse;", "Lf55/b;", "response", "Lcom/tencent/mobileqq/qqlive/room/livelabel/j;", "U1", "Landroidx/lifecycle/LiveData;", "S1", "Q1", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest;", "i", "Lcom/tencent/mobileqq/qqlive/api/ILiveNetRequest;", "requestApi", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lkotlin/Lazy;", "T1", "()Landroidx/lifecycle/LiveData;", "_gameLabels", BdhLogUtil.LogTag.Tag_Conn, "R1", "gameLabels", "Landroidx/lifecycle/MutableLiveData;", "D", "Landroidx/lifecycle/MutableLiveData;", "_videoLabels", "E", "_allLabels", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class QQLiveLabelViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy gameLabels;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<j> _videoLabels;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<j> _allLabels;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ILiveNetRequest requestApi;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy _gameLabels;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/qqlive/room/livelabel/QQLiveLabelViewModel$a;", "", "", "LABEL_TYPE_ALL", "J", "LABEL_TYPE_GAME", "LABEL_TYPE_VIDEO", "", "LOG_TAG", "Ljava/lang/String;", "", "RECENTLY_USED_GAME_ID", "I", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.room.livelabel.QQLiveLabelViewModel$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30022);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQLiveLabelViewModel() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        QRouteApi api = QRoute.api(ILiveNetRequest.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ILiveNetRequest::class.java)");
        this.requestApi = (ILiveNetRequest) api;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LiveData<QQLiveResponse<f55.b>>>() { // from class: com.tencent.mobileqq.qqlive.room.livelabel.QQLiveLabelViewModel$_gameLabels$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveLabelViewModel.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveData<QQLiveResponse<f55.b>> invoke() {
                ILiveNetRequest iLiveNetRequest;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (LiveData) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                iLiveNetRequest = QQLiveLabelViewModel.this.requestApi;
                return iLiveNetRequest.sendRequest(new QQLiveGetSecondLabelsRequest(2L));
            }
        });
        this._gameLabels = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new QQLiveLabelViewModel$gameLabels$2(this));
        this.gameLabels = lazy2;
        this._videoLabels = new MutableLiveData<>();
        this._allLabels = new MutableLiveData<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveData<QQLiveResponse<f55.b>> T1() {
        return (LiveData) this._gameLabels.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final j U1(QQLiveResponse<f55.b> response) {
        AegisLogger.INSTANCE.d("Open_Live|QQLiveLabelViewModel", "parseResponse", response.toString());
        f55.b rsp = response.getRsp();
        if (rsp != null) {
            j jVar = new j();
            jVar.f271631c = rsp.f397865c;
            jVar.f271630b = false;
            jVar.f271629a = rsp.f397863a;
            return jVar;
        }
        return null;
    }

    @NotNull
    public final LiveData<j> Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QQLiveLabelViewModel$getAllLabels$1(this, null), 3, null);
            return this._allLabels;
        }
        return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
    }

    @NotNull
    public final LiveData<QQLiveResponse<j>> R1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        Object value = this.gameLabels.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-gameLabels>(...)");
        return (LiveData) value;
    }

    @NotNull
    public final LiveData<j> S1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new QQLiveLabelViewModel$getVideoLabels$1(this, null), 3, null);
            return this._videoLabels;
        }
        return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
