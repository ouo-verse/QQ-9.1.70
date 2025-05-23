package com.tencent.mobileqq.qqlive.sail.ui.close;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqlive.api.ILiveNetRequest;
import com.tencent.mobileqq.qqlive.api.sso.QQLiveResponse;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.timi.game.sso.request.QQLiveGetEndPageDataRequest;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\fR\u001f\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel;", "Lcom/tencent/mobileqq/qqlive/sail/base/d;", "", "roomId", "anchorUid", "", "programId", "", "M1", "Landroidx/lifecycle/MutableLiveData;", "", "i", "Landroidx/lifecycle/MutableLiveData;", "N1", "()Landroidx/lifecycle/MutableLiveData;", "closeLiveData", "Lst3/b;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "_endPageLiveData", "Landroidx/lifecycle/LiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "O1", "()Landroidx/lifecycle/LiveData;", "endPageLiveData", "<init>", "()V", "D", "a", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class CloseViewModel extends com.tencent.mobileqq.qqlive.sail.base.d {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final LiveData<st3.b> endPageLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> closeLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<st3.b> _endPageLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/qqlive/sail/ui/close/CloseViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-live-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqlive.sail.ui.close.CloseViewModel$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(51587);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public CloseViewModel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.closeLiveData = new MutableLiveData<>();
        MutableLiveData<st3.b> mutableLiveData = new MutableLiveData<>();
        this._endPageLiveData = mutableLiveData;
        this.endPageLiveData = mutableLiveData;
    }

    public final void M1(final long roomId, long anchorUid, @NotNull String programId) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Long.valueOf(roomId), Long.valueOf(anchorUid), programId);
        } else {
            Intrinsics.checkNotNullParameter(programId, "programId");
            ((ILiveNetRequest) QRoute.api(ILiveNetRequest.class)).sendRequest2(new QQLiveGetEndPageDataRequest(anchorUid, programId), new Function1<QQLiveResponse<st3.b>, Unit>(roomId, this) { // from class: com.tencent.mobileqq.qqlive.sail.ui.close.CloseViewModel$fetchEndPageData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $roomId;
                final /* synthetic */ CloseViewModel this$0;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$roomId = roomId;
                    this.this$0 = this;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, Long.valueOf(roomId), this);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQLiveResponse<st3.b> qQLiveResponse) {
                    invoke2(qQLiveResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQLiveResponse<st3.b> response) {
                    MutableLiveData mutableLiveData;
                    MutableLiveData mutableLiveData2;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) response);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(response, "response");
                    st3.b rsp = response.getRsp();
                    if (!response.isFailed() && rsp != null) {
                        mutableLiveData2 = this.this$0._endPageLiveData;
                        mutableLiveData2.postValue(rsp);
                        return;
                    }
                    AegisLogger.INSTANCE.w("Audience|CloseViewModel", "", "roomId=" + this.$roomId + ", response=" + response);
                    mutableLiveData = this.this$0._endPageLiveData;
                    mutableLiveData.postValue(null);
                }
            });
        }
    }

    @NotNull
    public final MutableLiveData<Boolean> N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.closeLiveData;
    }

    @NotNull
    public final LiveData<st3.b> O1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.endPageLiveData;
    }
}
