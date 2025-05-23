package com.tencent.mobileqq.troop.homework.notice.detail.viewmodel;

import android.content.Intent;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHWApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.model.BaseItem;
import com.tencent.mobileqq.troop.homework.common.widget.mediaedit.view.HWMediaEditFoldView;
import com.tencent.mobileqq.troop.homework.notice.detail.event.HWNoticeDetailEvent;
import com.tencent.mobileqq.troop.homework.notice.list.event.HWNoticeListUpdateEvent;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.DeleteGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.JobKt__JobKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 W2\u00020\u0001:\u0001XB\u000f\u0012\u0006\u0010T\u001a\u00020S\u00a2\u0006\u0004\bU\u0010VJ-\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\u000e\u001a\u00020\bH\u0002J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0002J\u0006\u0010\u0015\u001a\u00020\bJ\b\u0010\u0016\u001a\u00020\bH\u0014R\u0014\u0010\u0019\u001a\u00020\u00048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0017\u0010\u001f\u001a\u00020\u001a8\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010%\u001a\u00020 8\u0006\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u0014\u0010'\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010\u001cR\u001a\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00040(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b,\u0010*R\u001a\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00060(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b.\u0010*R(\u00107\u001a\b\u0012\u0004\u0012\u00020\u0006008\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010*R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u0002008\u0006\u00a2\u0006\f\n\u0004\b9\u00102\u001a\u0004\b:\u00104R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00020<8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b=\u0010>R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\u0002008\u0006\u00a2\u0006\f\n\u0004\b@\u00102\u001a\u0004\bA\u00104R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bC\u0010*R\u001d\u0010G\u001a\b\u0012\u0004\u0012\u00020\u0002008\u0006\u00a2\u0006\f\n\u0004\bE\u00102\u001a\u0004\bF\u00104R\u0014\u0010K\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010JR#\u0010P\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0L008\u0006\u00a2\u0006\f\n\u0004\bN\u00102\u001a\u0004\bO\u00104R\u0011\u0010\u0003\u001a\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\bQ\u0010R\u00a8\u0006Y"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/HWNoticeDetailViewModel;", "Landroidx/lifecycle/ViewModel;", "", "isTeacher", "", "contentHeight", "", "authorUin", "", "p2", "(Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Long;)V", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailRsp;", "detail", ICustomDataEditor.NUMBER_PARAM_2, "m2", "shown", "q2", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/f;", "i2", "isFirstRequest", "c2", ICustomDataEditor.STRING_ARRAY_PARAM_2, "onCleared", "i", "I", "mediaContentHeight", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Ljava/lang/String;", "j2", "()Ljava/lang/String;", "troopUin", "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "g2", "()Lcom/tencent/mobileqq/troop/homework/api/IHWTroopUIApi$DetailPageFrom;", "from", "D", "noticeId", "Landroidx/lifecycle/MutableLiveData;", "E", "Landroidx/lifecycle/MutableLiveData;", "_isTeacher", UserInfo.SEX_FEMALE, "_contentHeight", "G", "_authorUin", "Landroidx/lifecycle/LiveData;", "H", "Landroidx/lifecycle/LiveData;", "e2", "()Landroidx/lifecycle/LiveData;", "setAuthorUinData", "(Landroidx/lifecycle/LiveData;)V", "authorUinData", "_isRightIconOfNavBarShown", "J", "k2", "isRightIconOfNavBarShown", "Landroidx/lifecycle/MediatorLiveData;", "K", "Landroidx/lifecycle/MediatorLiveData;", "_mediaContentClose", "L", SemanticAttributes.DbSystemValues.H2, "mediaContentClose", "M", "_finishPage", "N", "f2", "finishPage", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/d;", "P", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/manager/d;", "mediaEditManager", "", "Lcom/tencent/mobileqq/troop/homework/common/widget/mediaedit/model/BaseItem;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "getMediaItemList", "mediaItemList", "l2", "()Z", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Intent;)V", BdhLogUtil.LogTag.Tag_Req, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class HWNoticeDetailViewModel extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final IHWTroopUIApi.DetailPageFrom from;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String noticeId;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isTeacher;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _contentHeight;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Long> _authorUin;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private LiveData<Long> authorUinData;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isRightIconOfNavBarShown;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isRightIconOfNavBarShown;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MediatorLiveData<Boolean> _mediaContentClose;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> mediaContentClose;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private MutableLiveData<Boolean> _finishPage;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> finishPage;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.d mediaEditManager;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<BaseItem>> mediaItemList;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int mediaContentHeight;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/detail/viewmodel/HWNoticeDetailViewModel$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(53073);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public HWNoticeDetailViewModel(@NotNull Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) intent);
            return;
        }
        this.mediaContentHeight = HWMediaEditFoldView.C;
        String stringExtra = intent.getStringExtra("TROOP_UIN");
        stringExtra = stringExtra == null ? "0" : stringExtra;
        this.troopUin = stringExtra;
        Serializable serializableExtra = intent.getSerializableExtra("DETAIL_FROM");
        Intrinsics.checkNotNull(serializableExtra, "null cannot be cast to non-null type com.tencent.mobileqq.troop.homework.api.IHWTroopUIApi.DetailPageFrom");
        this.from = (IHWTroopUIApi.DetailPageFrom) serializableExtra;
        String stringExtra2 = intent.getStringExtra("NOTICE_ID");
        this.noticeId = stringExtra2 != null ? stringExtra2 : "0";
        MutableLiveData<Boolean> mutableLiveData = new MutableLiveData<>();
        this._isTeacher = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._contentHeight = mutableLiveData2;
        MutableLiveData<Long> mutableLiveData3 = new MutableLiveData<>();
        this._authorUin = mutableLiveData3;
        this.authorUinData = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._isRightIconOfNavBarShown = mutableLiveData4;
        this.isRightIconOfNavBarShown = mutableLiveData4;
        MediatorLiveData<Boolean> mediatorLiveData = new MediatorLiveData<>();
        final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel$_mediaContentClose$1$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                MutableLiveData mutableLiveData5;
                MutableLiveData mutableLiveData6;
                MutableLiveData mutableLiveData7;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) bool);
                    return;
                }
                HWNoticeDetailViewModel hWNoticeDetailViewModel = HWNoticeDetailViewModel.this;
                mutableLiveData5 = hWNoticeDetailViewModel._isTeacher;
                Boolean bool2 = (Boolean) mutableLiveData5.getValue();
                mutableLiveData6 = HWNoticeDetailViewModel.this._contentHeight;
                Integer num = (Integer) mutableLiveData6.getValue();
                mutableLiveData7 = HWNoticeDetailViewModel.this._authorUin;
                hWNoticeDetailViewModel.p2(bool2, num, (Long) mutableLiveData7.getValue());
            }
        };
        mediatorLiveData.addSource(mutableLiveData, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWNoticeDetailViewModel.R1(Function1.this, obj);
            }
        });
        final Function1<Long, Unit> function12 = new Function1<Long, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel$_mediaContentClose$1$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Long l3) {
                invoke2(l3);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Long l3) {
                MutableLiveData mutableLiveData5;
                MutableLiveData mutableLiveData6;
                MutableLiveData mutableLiveData7;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) l3);
                    return;
                }
                HWNoticeDetailViewModel hWNoticeDetailViewModel = HWNoticeDetailViewModel.this;
                mutableLiveData5 = hWNoticeDetailViewModel._isTeacher;
                Boolean bool = (Boolean) mutableLiveData5.getValue();
                mutableLiveData6 = HWNoticeDetailViewModel.this._contentHeight;
                Integer num = (Integer) mutableLiveData6.getValue();
                mutableLiveData7 = HWNoticeDetailViewModel.this._authorUin;
                hWNoticeDetailViewModel.p2(bool, num, (Long) mutableLiveData7.getValue());
            }
        };
        mediatorLiveData.addSource(mutableLiveData3, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.c
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWNoticeDetailViewModel.S1(Function1.this, obj);
            }
        });
        final Function1<Integer, Unit> function13 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel$_mediaContentClose$1$3
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke2(num);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Integer num) {
                MutableLiveData mutableLiveData5;
                MutableLiveData mutableLiveData6;
                MutableLiveData mutableLiveData7;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) num);
                    return;
                }
                HWNoticeDetailViewModel hWNoticeDetailViewModel = HWNoticeDetailViewModel.this;
                mutableLiveData5 = hWNoticeDetailViewModel._isTeacher;
                Boolean bool = (Boolean) mutableLiveData5.getValue();
                mutableLiveData6 = HWNoticeDetailViewModel.this._contentHeight;
                Integer num2 = (Integer) mutableLiveData6.getValue();
                mutableLiveData7 = HWNoticeDetailViewModel.this._authorUin;
                hWNoticeDetailViewModel.p2(bool, num2, (Long) mutableLiveData7.getValue());
            }
        };
        mediatorLiveData.addSource(mutableLiveData2, new Observer() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                HWNoticeDetailViewModel.T1(Function1.this, obj);
            }
        });
        this._mediaContentClose = mediatorLiveData;
        this.mediaContentClose = mediatorLiveData;
        MutableLiveData<Boolean> mutableLiveData5 = new MutableLiveData<>();
        this._finishPage = mutableLiveData5;
        this.finishPage = mutableLiveData5;
        com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.d dVar = new com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.d(stringExtra, ViewModelKt.getViewModelScope(this), new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.HWNoticeDetailViewModel$mediaEditManager$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) HWNoticeDetailViewModel.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                MutableLiveData mutableLiveData6;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, i3);
                } else {
                    mutableLiveData6 = HWNoticeDetailViewModel.this._contentHeight;
                    mutableLiveData6.setValue(Integer.valueOf(i3));
                }
            }
        });
        this.mediaEditManager = dVar;
        this.mediaItemList = dVar.p();
        m2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void R1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b2(HWNoticeDetailViewModel this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            QQToastUtil.showQQToastInUiThread(2, "\u5220\u9664\u6210\u529f");
            SimpleEventBus.getInstance().dispatchEvent(new HWNoticeListUpdateEvent.NoticeDeleted(this$0.noticeId));
            this$0._finishPage.postValue(Boolean.TRUE);
            return;
        }
        QLog.e("HW.Notice..Detail.HWNoticeDetailViewModel", 1, "deleteNotice fail, result:" + i3 + ", errMsg:" + str);
        QQToastUtil.showQQToastInUiThread(1, "\u5220\u9664\u5931\u8d25");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(boolean z16, HWNoticeDetailViewModel this$0, int i3, String errMsg, GetGroupSchoolNoticeDetailRsp rsp) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        if (QLog.isColorLevel()) {
            QLog.i("HW.Notice..Detail.HWNoticeDetailViewModel", 2, "fetchNoticeDetail onResult, errCode:" + i3 + ", errMsg:" + errMsg);
        }
        if (i3 == 0) {
            SimpleEventBus.getInstance().dispatchEvent(new HWNoticeDetailEvent.NoticeDetailUpdate(rsp));
            if (z16) {
                QLog.i("HW.Notice..Detail.", 1, "SchoolPartner Notice info page record data loading complete");
                this$0.n2(rsp);
                this$0.c2(false);
                return;
            }
            return;
        }
        SimpleEventBus.getInstance().dispatchEvent(new HWNoticeDetailEvent.NoticeDetailError(i3));
    }

    private final void m2() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new HWNoticeDetailViewModel$setMediaContentCloseStatus$1(this, null), 3, null);
    }

    private final void n2(GetGroupSchoolNoticeDetailRsp detail) {
        this._authorUin.postValue(Long.valueOf(detail.authorUin));
        this.mediaEditManager.x(detail);
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.f
            @Override // java.lang.Runnable
            public final void run() {
                HWNoticeDetailViewModel.o2(HWNoticeDetailViewModel.this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(HWNoticeDetailViewModel this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((ITroopHWApi) QRoute.api(ITroopHWApi.class)).notifyTroopBannerHWBizOpened(this$0.troopUin, this$0.noticeId);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0033, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r4) != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void p2(Boolean isTeacher, Integer contentHeight, Long authorUin) {
        boolean z16;
        String str;
        if (contentHeight == null) {
            return;
        }
        if (contentHeight.intValue() < this.mediaContentHeight) {
            this._mediaContentClose.setValue(Boolean.FALSE);
            return;
        }
        MediatorLiveData<Boolean> mediatorLiveData = this._mediaContentClose;
        if (!Intrinsics.areEqual(isTeacher, Boolean.TRUE)) {
            if (authorUin != null) {
                String l3 = authorUin.toString();
                AppInterface e16 = bg.e();
                if (e16 != null) {
                    str = e16.getCurrentAccountUin();
                } else {
                    str = null;
                }
            }
            z16 = false;
            mediatorLiveData.setValue(Boolean.valueOf(z16));
        }
        z16 = true;
        mediatorLiveData.setValue(Boolean.valueOf(z16));
    }

    public final void a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
            return;
        }
        DeleteGroupSchoolNoticeReq deleteGroupSchoolNoticeReq = new DeleteGroupSchoolNoticeReq(this.noticeId, Long.parseLong(this.troopUin));
        r g16 = bg.f302144a.g();
        if (g16 != null) {
            g16.deleteGroupSchoolNotice(deleteGroupSchoolNoticeReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    HWNoticeDetailViewModel.b2(HWNoticeDetailViewModel.this, i3, str);
                }
            });
        }
    }

    public final void c2(final boolean isFirstRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, isFirstRequest);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("HW.Notice..Detail.HWNoticeDetailViewModel", 2, "fetchNoticeDetail, troopUin:" + this.troopUin + ", noticeId:" + this.noticeId + ", isFirstRequest:" + isFirstRequest);
        }
        GetGroupSchoolNoticeDetailReq getGroupSchoolNoticeDetailReq = new GetGroupSchoolNoticeDetailReq(this.noticeId, Long.parseLong(this.troopUin), !isFirstRequest);
        r g16 = bg.f302144a.g();
        if (g16 != null) {
            g16.getGroupSchoolNoticeDetail(getGroupSchoolNoticeDetailReq, new IGetGroupSchoolNoticeDetailCallback() { // from class: com.tencent.mobileqq.troop.homework.notice.detail.viewmodel.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeDetailCallback
                public final void onResult(int i3, String str, GetGroupSchoolNoticeDetailRsp getGroupSchoolNoticeDetailRsp) {
                    HWNoticeDetailViewModel.d2(isFirstRequest, this, i3, str, getGroupSchoolNoticeDetailRsp);
                }
            });
        }
    }

    @NotNull
    public final LiveData<Long> e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.authorUinData;
    }

    @NotNull
    public final LiveData<Boolean> f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (LiveData) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.finishPage;
    }

    @NotNull
    public final IHWTroopUIApi.DetailPageFrom g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IHWTroopUIApi.DetailPageFrom) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.from;
    }

    @NotNull
    public final LiveData<Boolean> h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (LiveData) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.mediaContentClose;
    }

    @NotNull
    public final com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (com.tencent.mobileqq.troop.homework.common.widget.mediaedit.manager.f) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mediaEditManager;
    }

    @NotNull
    public final String j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.troopUin;
    }

    @NotNull
    public final LiveData<Boolean> k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.isRightIconOfNavBarShown;
    }

    public final boolean l2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this)).booleanValue();
        }
        Boolean value = this._isTeacher.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        return value.booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
            return;
        }
        super.onCleared();
        JobKt__JobKt.cancelChildren$default(ViewModelKt.getViewModelScope(this).getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        CoroutineScopeKt.cancel$default(ViewModelKt.getViewModelScope(this), null, 1, null);
        com.tencent.mobileqq.troop.homework.utils.b.a();
        this.mediaEditManager.i();
    }

    public final void q2(boolean shown) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, shown);
        } else {
            this._isRightIconOfNavBarShown.postValue(Boolean.valueOf(shown));
        }
    }
}
