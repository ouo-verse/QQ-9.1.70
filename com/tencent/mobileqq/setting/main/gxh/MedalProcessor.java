package com.tencent.mobileqq.setting.main.gxh;

import android.app.Activity;
import android.content.Context;
import android.widget.CompoundButton;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.listitem.x;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.manager.Manager;
import tl.h;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0014\u0010\u0015J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\f\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/setting/main/gxh/MedalProcessor;", "Lcom/tencent/mobileqq/setting/processor/c;", "", "D", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/widget/listitem/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "onCreate", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "Landroidx/lifecycle/MutableLiveData;", "", "g", "Landroidx/lifecycle/MutableLiveData;", "showMedal", "Lcom/tencent/mobileqq/app/CardObserver;", h.F, "Lcom/tencent/mobileqq/app/CardObserver;", "cardObserver", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "i", "a", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class MedalProcessor extends com.tencent.mobileqq.setting.processor.c {

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final MutableLiveData<Boolean> showMedal;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final CardObserver cardObserver;

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0014\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/setting/main/gxh/MedalProcessor$b", "Lcom/tencent/mobileqq/app/CardObserver;", "", "success", "", "onSetMedal", "isSuccess", "", "data", "onGetPrettyOwnerFlag", "onSetPrettyOwnerFlag", "qq_setting_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b extends CardObserver {
        b() {
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onGetPrettyOwnerFlag(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetMedal(boolean success) {
            if (!success) {
                MedalProcessor.this.D();
                if (((Boolean) MedalProcessor.this.showMedal.getValue()) != null) {
                    MedalProcessor.this.showMedal.postValue(Boolean.valueOf(!r5.booleanValue()));
                }
                QLog.d("MedalProcessor", 1, "onSetMedal failed");
                return;
            }
            AppInterface f16 = MedalProcessor.this.f();
            Card card = null;
            Manager manager = f16 != null ? f16.getManager(QQManagerFactory.FRIENDS_MANAGER) : null;
            FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
            if (friendsManager != null) {
                AppInterface f17 = MedalProcessor.this.f();
                card = friendsManager.q(f17 != null ? f17.getCurrentAccountUin() : null);
            }
            if (card == null) {
                return;
            }
            MedalProcessor.this.showMedal.postValue(Boolean.valueOf(true ^ card.medalSwitchDisable));
            QLog.d("MedalProcessor", 2, "onSetMedal medalSwitchDisable=" + card.medalSwitchDisable + " ");
        }

        @Override // com.tencent.mobileqq.app.CardObserver
        protected void onSetPrettyOwnerFlag(boolean isSuccess, Object data) {
            Intrinsics.checkNotNullParameter(data, "data");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MedalProcessor(Context context) {
        super(context, 20);
        Intrinsics.checkNotNullParameter(context, "context");
        this.showMedal = new MutableLiveData<>();
        this.cardObserver = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B(MedalProcessor this$0, CompoundButton compoundButton, boolean z16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (!NetworkUtil.isNetSupport(this$0.e())) {
            this$0.D();
            this$0.showMedal.postValue(Boolean.valueOf(!z16));
            return;
        }
        AppInterface f16 = this$0.f();
        BusinessHandler businessHandler = f16 != null ? f16.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER) : null;
        CardHandler cardHandler = businessHandler instanceof CardHandler ? (CardHandler) businessHandler : null;
        if (cardHandler != null) {
            cardHandler.k5(!z16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D() {
        Activity e16 = e();
        if (e16 != null) {
            e16.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.setting.main.gxh.d
                @Override // java.lang.Runnable
                public final void run() {
                    MedalProcessor.E();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E() {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, 1, R.string.hhc, 0).show(context.getResources().getDimensionPixelSize(R.dimen.title_bar_height));
    }

    private final void F() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.setting.main.gxh.c
            @Override // java.lang.Runnable
            public final void run() {
                MedalProcessor.G(MedalProcessor.this);
            }
        }, 5, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void G(MedalProcessor this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AppInterface f16 = this$0.f();
        Card card = null;
        Manager manager = f16 != null ? f16.getManager(QQManagerFactory.FRIENDS_MANAGER) : null;
        FriendsManager friendsManager = manager instanceof FriendsManager ? (FriendsManager) manager : null;
        if (friendsManager != null) {
            AppInterface f17 = this$0.f();
            card = friendsManager.q(f17 != null ? f17.getCurrentAccountUin() : null);
        }
        if (card != null) {
            boolean z16 = card.medalSwitchDisable;
            if (QLog.isColorLevel()) {
                QLog.d("MedalProcessor", 2, "initUI medalSwitchDisable = " + z16);
            }
            this$0.showMedal.postValue(Boolean.valueOf(!z16));
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onCreate() {
        super.onCreate();
        F();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.addObserver(this.cardObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c, com.tencent.mobileqq.setting.processor.d
    public void onDestroy() {
        super.onDestroy();
        AppInterface f16 = f();
        if (f16 != null) {
            f16.removeObserver(this.cardObserver);
        }
    }

    @Override // com.tencent.mobileqq.setting.processor.c
    public com.tencent.mobileqq.widget.listitem.a<?> q() {
        final x xVar = new x(new x.b.C8996b("\u52cb\u7ae0\u5899", R.drawable.qui_qq_medal), new x.c.f(false, new CompoundButton.OnCheckedChangeListener() { // from class: com.tencent.mobileqq.setting.main.gxh.a
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z16) {
                MedalProcessor.B(MedalProcessor.this, compoundButton, z16);
            }
        }));
        Activity e16 = e();
        QBaseActivity qBaseActivity = e16 instanceof QBaseActivity ? (QBaseActivity) e16 : null;
        if (qBaseActivity != null) {
            MutableLiveData<Boolean> mutableLiveData = this.showMedal;
            final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.tencent.mobileqq.setting.main.gxh.MedalProcessor$onCreateItemConfig$2$1$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke2(bool);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Boolean showMedal) {
                    x.c.f O = xVar.O();
                    Intrinsics.checkNotNullExpressionValue(showMedal, "showMedal");
                    O.f(showMedal.booleanValue());
                    this.l();
                }
            };
            mutableLiveData.observe(qBaseActivity, new Observer() { // from class: com.tencent.mobileqq.setting.main.gxh.b
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    MedalProcessor.C(Function1.this, obj);
                }
            });
        }
        return xVar;
    }
}
