package com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel;

import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelKt;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.repository.QQStrangerMsgSettingRepository;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.a;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qcoroutine.api.coroutine.CorountineFunKt;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 &2\u00020\u0001:\u0001'B\u0007\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\u0006\u0010\b\u001a\u00020\u0004J\u001c\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u0014\u0010\u000e\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000bJ\u0006\u0010\u000f\u001a\u00020\u0004J\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0015\u001a\u00020\u0004R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001b\u0010#\u001a\u00020\u001e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/QQStrangerMsgSettingViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/viewmodel/a;", "state", "", "X1", "", "getLogTag", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", "Landroidx/lifecycle/Observer;", "observer", "O1", "R1", "S1", "T1", "", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "W1", "U1", "P1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "updateUIStateLiveData", "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/QQStrangerMsgSettingRepository;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/setting/repository/QQStrangerMsgSettingRepository;", "repository", "Landroid/os/Handler;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "Q1", "()Landroid/os/Handler;", "mainHandler", "<init>", "()V", "D", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerMsgSettingViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private final Lazy mainHandler;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<a> updateUIStateLiveData = new MutableLiveData<>();

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final QQStrangerMsgSettingRepository repository = new QQStrangerMsgSettingRepository();

    public QQStrangerMsgSettingViewModel() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Handler>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.QQStrangerMsgSettingViewModel$mainHandler$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Handler invoke() {
                return new Handler(Looper.getMainLooper());
            }
        });
        this.mainHandler = lazy;
    }

    private final Handler Q1() {
        return (Handler) this.mainHandler.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void X1(final a state) {
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            this.updateUIStateLiveData.setValue(state);
        } else {
            Q1().post(new Runnable() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.setting.viewmodel.b
                @Override // java.lang.Runnable
                public final void run() {
                    QQStrangerMsgSettingViewModel.Z1(QQStrangerMsgSettingViewModel.this, state);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z1(QQStrangerMsgSettingViewModel this$0, a state) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(state, "$state");
        this$0.updateUIStateLiveData.setValue(state);
    }

    public final void O1(LifecycleOwner lifecycleOwner, Observer<a> observer) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.updateUIStateLiveData.observe(lifecycleOwner, observer);
    }

    public final void P1() {
        QLog.i("QQStrangerMsgSettingViewModel", 1, "deleteAllConversations");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if ((peekAppRuntime instanceof QQAppInterface ? (QQAppInterface) peekAppRuntime : null) == null) {
            QLog.i("QQStrangerMsgSettingViewModel", 1, "app is null");
            X1(new a.OnDeleteAllConversationsUIState(false));
        } else {
            ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).deleteAllRecentContact();
            QLog.i("QQStrangerMsgSettingViewModel", 1, "deleteAll success");
            X1(new a.OnDeleteAllConversationsUIState(true));
        }
    }

    public final void R1(Observer<a> observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.updateUIStateLiveData.removeObserver(observer);
    }

    public final void S1() {
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerMsgSettingViewModel", Boolean.FALSE, null, null, new QQStrangerMsgSettingViewModel$requestMsgSettingsData$1(this, null), 12, null);
    }

    public final void T1() {
        X1(new a.UpdateSettingDataOptionsUIState(this.repository.i()));
    }

    public final void U1(boolean r122) {
        QLog.i("QQStrangerMsgSettingViewModel", 1, "setHideModeSwitch switch : " + r122);
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerMsgSettingViewModel", Boolean.FALSE, null, null, new QQStrangerMsgSettingViewModel$setHideModeSwitch$1(this, r122, null), 12, null);
    }

    public final void W1(boolean r122) {
        QLog.i("QQStrangerMsgSettingViewModel", 1, "setNewChatMsgNotifySwitch switch : " + r122);
        CorountineFunKt.e(ViewModelKt.getViewModelScope(this), "QQStrangerMsgSettingViewModel", Boolean.FALSE, null, null, new QQStrangerMsgSettingViewModel$setNewChatMsgNotifySwitch$1(this, r122, null), 12, null);
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    public String getLogTag() {
        return "QQStrangerMsgSettingViewModel";
    }

    public final void onDestroy() {
        Q1().removeCallbacksAndMessages(null);
    }
}
