package com.tencent.mobileqq.troop.troopnotification.vm;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.profilecard.observer.ProfileCardObserver;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.troopjoin.TryJoinTroopResult;
import com.tencent.mobileqq.troop.troopjoin.api.ITroopJoinApi;
import com.tencent.mobileqq.troop.troopnotification.activity.TroopRequestRefuseActivity;
import com.tencent.mobileqq.troop.troopnotification.render.parser.TroopNotificationBaseButtonParser;
import com.tencent.mobileqq.troop.troopnotification.repo.TroopNotificationOperateRepo;
import com.tencent.mobileqq.troop.troopnotification.utils.g;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$friendCardObserver$2;
import com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$notificationChangeObserver$2;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOStarterApi;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyOperateType;
import com.tencent.qqnt.notification.ITroopNotificationInnerService;
import com.tencent.qqnt.notification.f;
import com.tencent.qqnt.troop.ITroopMemberOperationRepoApi;
import com.tencent.qqnt.troop.TroopInfoRepo;
import com.tencent.qqnt.troop.i;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import cooperation.qzone.QzoneIPCModule;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0081\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\n*\u0001D\u0018\u0000 K2\u00020\u0001:\u0001LB\u0007\u00a2\u0006\u0004\bI\u0010JJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\r\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\u000e\u001a\u00020\u0004J\u001e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u001e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0006J \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cJ\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u0002J\u0016\u0010#\u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010&\u001a\u00020\t8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010)\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u001f\u0010/\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060*8\u0006\u00a2\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u001f\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000*8\u0006\u00a2\u0006\f\n\u0004\b4\u0010,\u001a\u0004\b5\u0010.R\u0018\u00109\u001a\u0004\u0018\u00010\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b7\u00108R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020:0*8\u0006\u00a2\u0006\f\n\u0004\b;\u0010,\u001a\u0004\b<\u0010.R\u001b\u0010C\u001a\u00020>8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b?\u0010@\u001a\u0004\bA\u0010BR\u001b\u0010H\u001a\u00020D8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\bE\u0010@\u001a\u0004\bF\u0010G\u00a8\u0006M"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM;", "Landroidx/lifecycle/ViewModel;", "", "memberUin", "", "m2", "Lcom/tencent/qqnt/notification/f;", "newMsg", "k2", "Landroidx/lifecycle/LifecycleOwner;", "owner", "Landroid/os/Bundle;", "args", "c2", "destroy", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "msg", "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser$a;", "clickData", "i2", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyOperateType;", "operateType", "l2", "U1", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "j2", "Landroid/content/Context;", "context", "troopUin", SemanticAttributes.DbSystemValues.H2, "d2", "i", "Landroidx/lifecycle/LifecycleOwner;", "lifecycleOwner", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/qqnt/notification/f;", "_curNotification", "Landroidx/lifecycle/MutableLiveData;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "W1", "()Landroidx/lifecycle/MutableLiveData;", "curNotification", "Lcom/tencent/mobileqq/data/Card;", "D", "Lcom/tencent/mobileqq/data/Card;", "_curProfileCard", "E", "X1", "curProfileCard", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/troopnotification/render/parser/TroopNotificationBaseButtonParser$a;", "pendingClickData", "", "G", "Z1", "finishOperation", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "H", "Lkotlin/Lazy;", ICustomDataEditor.STRING_ARRAY_PARAM_2, "()Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "friendCardObserver", "com/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM$notificationChangeObserver$2$a", "I", "b2", "()Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM$notificationChangeObserver$2$a;", "notificationChangeObserver", "<init>", "()V", "J", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopNotificationDetailVM extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<f> curNotification;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Card _curProfileCard;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Card> curProfileCard;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private TroopNotificationBaseButtonParser.a pendingClickData;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> finishOperation;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final Lazy friendCardObserver;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final Lazy notificationChangeObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private LifecycleOwner lifecycleOwner;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private f _curNotification;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM$a;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM;", "a", "", "REQUEST_CODE_REFUSE", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final TroopNotificationDetailVM a(@NotNull FragmentActivity activity) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (TroopNotificationDetailVM) iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity);
            }
            Intrinsics.checkNotNullParameter(activity, "activity");
            ViewModel viewModel = new ViewModelProvider(activity).get(TroopNotificationDetailVM.class);
            Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026tionDetailVM::class.java)");
            return (TroopNotificationDetailVM) viewModel;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59842);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopNotificationDetailVM() {
        Lazy lazy;
        Lazy lazy2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.curNotification = new MutableLiveData<>(this._curNotification);
        this.curProfileCard = new MutableLiveData<>(this._curProfileCard);
        this.finishOperation = new MutableLiveData<>();
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<TroopNotificationDetailVM$friendCardObserver$2.a>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$friendCardObserver$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM$friendCardObserver$2$a", "Lcom/tencent/mobileqq/profilecard/observer/ProfileCardObserver;", "", "isSuccess", "", "profileCard", "", "onGetProfileCard", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a extends ProfileCardObserver {
                static IPatchRedirector $redirector_;

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ TroopNotificationDetailVM f300936d;

                a(TroopNotificationDetailVM troopNotificationDetailVM) {
                    this.f300936d = troopNotificationDetailVM;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopNotificationDetailVM);
                    }
                }

                @Override // com.tencent.mobileqq.profilecard.observer.ProfileCardObserver
                protected void onGetProfileCard(boolean isSuccess, @Nullable Object profileCard) {
                    f fVar;
                    String str;
                    Card card;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), profileCard);
                        return;
                    }
                    if (QLog.isColorLevel()) {
                        QLog.d("TroopNotificationDetailVM", 2, "onGetProfileCard: isSuccess=" + isSuccess + ", profileCard=" + profileCard);
                    }
                    if (isSuccess && (profileCard instanceof Card)) {
                        Card card2 = (Card) profileCard;
                        String str2 = card2.uin;
                        fVar = this.f300936d._curNotification;
                        if (fVar != null) {
                            str = fVar.h();
                        } else {
                            str = null;
                        }
                        if (Intrinsics.areEqual(str2, str)) {
                            this.f300936d._curProfileCard = card2;
                            MutableLiveData<Card> X1 = this.f300936d.X1();
                            card = this.f300936d._curProfileCard;
                            X1.postValue(card);
                        }
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationDetailVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopNotificationDetailVM.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.friendCardObserver = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<TroopNotificationDetailVM$notificationChangeObserver$2.a>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$notificationChangeObserver$2
            static IPatchRedirector $redirector_;

            /* compiled from: P */
            @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\b\u0010\t\u001a\u00020\u0004H\u0016J \u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/troop/troopnotification/vm/TroopNotificationDetailVM$notificationChangeObserver$2$a", "Lcom/tencent/qqnt/inner/observer/a;", "Lcom/tencent/qqnt/notification/f;", "newMsg", "", "a", "c", "msg", "d", "e", "", "unreadCount", "unhandledCount", "unHandleAndUnreadCount", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
            /* loaded from: classes19.dex */
            public static final class a implements com.tencent.qqnt.inner.observer.a {
                static IPatchRedirector $redirector_;

                /* renamed from: a, reason: collision with root package name */
                final /* synthetic */ TroopNotificationDetailVM f300937a;

                a(TroopNotificationDetailVM troopNotificationDetailVM) {
                    this.f300937a = troopNotificationDetailVM;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) troopNotificationDetailVM);
                    }
                }

                @Override // com.tencent.qqnt.inner.observer.a
                public void a(@NotNull f newMsg) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) newMsg);
                    } else {
                        Intrinsics.checkNotNullParameter(newMsg, "newMsg");
                        this.f300937a.k2(newMsg);
                    }
                }

                @Override // com.tencent.qqnt.troop.g
                public void b(int unreadCount, int unhandledCount, int unHandleAndUnreadCount) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                        iPatchRedirector.redirect((short) 6, this, Integer.valueOf(unreadCount), Integer.valueOf(unhandledCount), Integer.valueOf(unHandleAndUnreadCount));
                    }
                }

                @Override // com.tencent.qqnt.inner.observer.a
                public void c() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this);
                    } else {
                        QLog.e("TroopNotificationDetailVM", 1, "onNotificationClear: error invoke");
                    }
                }

                @Override // com.tencent.qqnt.inner.observer.a
                public void d(@NotNull f msg2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                        iPatchRedirector.redirect((short) 4, (Object) this, (Object) msg2);
                    } else {
                        Intrinsics.checkNotNullParameter(msg2, "msg");
                        QLog.e("TroopNotificationDetailVM", 1, "onNotificationRemove: error invoke");
                    }
                }

                @Override // com.tencent.qqnt.inner.observer.a
                public void e() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                        iPatchRedirector.redirect((short) 5, (Object) this);
                    }
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationDetailVM.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final a invoke() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? new a(TroopNotificationDetailVM.this) : (a) iPatchRedirector2.redirect((short) 2, (Object) this);
            }
        });
        this.notificationChangeObserver = lazy2;
    }

    private final ProfileCardObserver a2() {
        return (ProfileCardObserver) this.friendCardObserver.getValue();
    }

    private final TroopNotificationDetailVM$notificationChangeObserver$2.a b2() {
        return (TroopNotificationDetailVM$notificationChangeObserver$2.a) this.notificationChangeObserver.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(String troopUin, TroopNotificationDetailVM this$0, String str) {
        Intrinsics.checkNotNullParameter(troopUin, "$troopUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        QLog.i("TroopNotificationDetailVM", 1, "[inviteToGroup] uid is empty:" + TextUtils.isEmpty(str));
        if (!TextUtils.isEmpty(str)) {
            ITroopMemberOperationRepoApi iTroopMemberOperationRepoApi = (ITroopMemberOperationRepoApi) QRoute.api(ITroopMemberOperationRepoApi.class);
            LifecycleOwner lifecycleOwner = this$0.lifecycleOwner;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleOwner = null;
            }
            iTroopMemberOperationRepoApi.inviteToGroup(troopUin, str, lifecycleOwner, "TroopNotificationDetailVM", new i() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.c
                @Override // com.tencent.qqnt.troop.i
                public final void onResult(boolean z16, int i3, String str2) {
                    TroopNotificationDetailVM.f2(z16, i3, str2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(final boolean z16, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("TroopNotificationDetailVM", 1, "[inviteToGroup] isSus:" + z16 + ",res:" + i3 + ",msg:" + errMsg);
        bg.k(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.d
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationDetailVM.g2(z16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g2(boolean z16) {
        g.f300931a.f(z16, "", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void k2(f newMsg) {
        List<f> listOf;
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleOwner = null;
            }
            listOf = CollectionsKt__CollectionsJVMKt.listOf(newMsg);
            iTroopNotificationInnerService.saveNotificationMsg(lifecycleOwner, listOf);
        }
        this._curNotification = newMsg;
        this.curNotification.postValue(newMsg);
    }

    private final void m2(final String memberUin) {
        bg.f302144a.j(new Runnable() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.a
            @Override // java.lang.Runnable
            public final void run() {
                TroopNotificationDetailVM.n2(memberUin, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n2(String memberUin, TroopNotificationDetailVM this$0) {
        Card card;
        Intrinsics.checkNotNullParameter(memberUin, "$memberUin");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        IProfileDataService iProfileDataService = (IProfileDataService) bg.l(IProfileDataService.class);
        if (iProfileDataService != null) {
            card = iProfileDataService.getProfileCard(memberUin, false);
        } else {
            card = null;
        }
        if (card != null && card.iQQLevel > 0) {
            this$0._curProfileCard = card;
            this$0.curProfileCard.postValue(card);
        } else {
            com.tencent.mobileqq.troop.troopnotification.utils.e.f300928a.d(memberUin);
        }
    }

    public final void U1(@NotNull f msg2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) msg2);
        } else {
            Intrinsics.checkNotNullParameter(msg2, "msg");
            TroopNotificationOperateRepo.f300860a.j(msg2, new Function4<Boolean, Integer, String, f, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$blackListNotification$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(4);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationDetailVM.this);
                    }
                }

                @Override // kotlin.jvm.functions.Function4
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, f fVar) {
                    invoke(bool.booleanValue(), num.intValue(), str, fVar);
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull f newMsg) {
                    TroopNotificationBaseButtonParser.a aVar;
                    String str;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, newMsg);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                    Intrinsics.checkNotNullParameter(newMsg, "newMsg");
                    g gVar = g.f300931a;
                    aVar = TroopNotificationDetailVM.this.pendingClickData;
                    if (aVar == null || (str = aVar.a()) == null) {
                        str = "";
                    }
                    gVar.f(z16, str, i3);
                }
            });
        }
    }

    @NotNull
    public final MutableLiveData<f> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.curNotification;
    }

    @NotNull
    public final MutableLiveData<Card> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.curProfileCard;
    }

    @NotNull
    public final MutableLiveData<Boolean> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (MutableLiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.finishOperation;
    }

    public final void c2(@NotNull LifecycleOwner owner, @NotNull Bundle args) {
        f fVar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) owner, (Object) args);
            return;
        }
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(args, "args");
        this.lifecycleOwner = owner;
        int i3 = args.getInt("KEY_CATEGORY");
        long j3 = args.getLong("KEY_SEQ");
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        LifecycleOwner lifecycleOwner = null;
        if (iTroopNotificationInnerService != null) {
            fVar = iTroopNotificationInnerService.getNotificationMsgFromCache(i3, j3);
        } else {
            fVar = null;
        }
        boolean z16 = true;
        QLog.d("TroopNotificationDetailVM", 1, "init: category=" + i3 + ", seq=" + j3 + ", notificationMsg=" + fVar);
        if (fVar != null) {
            this._curNotification = fVar;
            this.curNotification.postValue(fVar);
            String h16 = fVar.h();
            if (h16 != null) {
                if (h16.length() <= 0) {
                    z16 = false;
                }
                if (z16) {
                    m2(h16);
                }
            }
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.addObserver(a2());
        }
        ITroopNotificationInnerService iTroopNotificationInnerService2 = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService2 != null) {
            LifecycleOwner lifecycleOwner2 = this.lifecycleOwner;
            if (lifecycleOwner2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
            } else {
                lifecycleOwner = lifecycleOwner2;
            }
            iTroopNotificationInnerService2.registerNotificationChangedObserver(lifecycleOwner, b2());
        }
    }

    public final void d2(@NotNull final String troopUin, @NotNull String memberUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) troopUin, (Object) memberUin);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(memberUin, "memberUin");
        ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(memberUin, true, true, new IRelationNTUinAndUidApi.e() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.b
            @Override // com.tencent.relation.common.api.IRelationNTUinAndUidApi.e
            public final void a(String str) {
                TroopNotificationDetailVM.e2(troopUin, this, str);
            }
        });
    }

    public final void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ITroopNotificationInnerService iTroopNotificationInnerService = (ITroopNotificationInnerService) bg.l(ITroopNotificationInnerService.class);
        if (iTroopNotificationInnerService != null) {
            LifecycleOwner lifecycleOwner = this.lifecycleOwner;
            if (lifecycleOwner == null) {
                Intrinsics.throwUninitializedPropertyAccessException("lifecycleOwner");
                lifecycleOwner = null;
            }
            iTroopNotificationInnerService.destroyNotificationMsg(lifecycleOwner);
        }
        AppInterface e16 = bg.e();
        if (e16 != null) {
            e16.removeObserver(a2());
        }
    }

    public final void h2(@NotNull final Context context, @NotNull final String troopUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) context, (Object) troopUin);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        ((ITroopJoinApi) QRoute.api(ITroopJoinApi.class)).tryLaunchJoinTroop(context, new com.tencent.mobileqq.troop.troopjoin.a(troopUin, "", 10014, false, null, false, 56, null), false, new Function2<TryJoinTroopResult, Integer, Unit>(troopUin, context) { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$joinTroopAgain$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ String $troopUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
                this.$troopUin = troopUin;
                this.$context = context;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) troopUin, (Object) context);
                }
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(TryJoinTroopResult tryJoinTroopResult, Integer num) {
                invoke(tryJoinTroopResult, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TryJoinTroopResult joinTroopResult, int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) joinTroopResult, i3);
                    return;
                }
                Intrinsics.checkNotNullParameter(joinTroopResult, "joinTroopResult");
                QLog.d("TroopNotificationDetailVM", 1, "requestJoinTroop: tryLaunchJoinTroop troopUin=" + this.$troopUin + ", result=" + joinTroopResult + ", errCode=" + i3);
                g.f300931a.e(joinTroopResult, i3);
                TroopInfo troopInfoFromCache = TroopInfoRepo.INSTANCE.getTroopInfoFromCache(this.$troopUin);
                if (troopInfoFromCache != null && troopInfoFromCache.hadJoinTroop()) {
                    QRouteApi api = QRoute.api(IAIOStarterApi.class);
                    Intrinsics.checkNotNullExpressionValue(api, "api(IAIOStarterApi::class.java)");
                    Context context2 = this.$context;
                    String str = troopInfoFromCache.troopuin;
                    Intrinsics.checkNotNullExpressionValue(str, "troopInfo.troopuin");
                    String troopDisplayName = troopInfoFromCache.getTroopDisplayName();
                    Intrinsics.checkNotNullExpressionValue(troopDisplayName, "troopInfo.troopDisplayName");
                    IAIOStarterApi.a.b((IAIOStarterApi) api, context2, 2, str, troopDisplayName, 0L, null, 48, null);
                }
            }
        });
    }

    public final void i2(@NotNull Activity activity, @NotNull f msg2, @NotNull TroopNotificationBaseButtonParser.a clickData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, activity, msg2, clickData);
            return;
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        this.pendingClickData = clickData;
        TroopRequestRefuseActivity.J2(activity, 1001, msg2);
    }

    public final void j2(int requestCode, int resultCode, @Nullable Intent data) {
        f fVar;
        String str;
        String str2;
        String b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("TroopNotificationDetailVM", 2, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode + ", data=" + data);
        }
        if (requestCode != 1001 || resultCode != -1 || (fVar = this._curNotification) == null || data == null) {
            return;
        }
        String stringExtra = data.getStringExtra("key_refuse_reason");
        if (stringExtra == null) {
            str = "";
        } else {
            str = stringExtra;
        }
        boolean booleanExtra = data.getBooleanExtra("key_set_black_list", false);
        TroopNotificationOperateRepo troopNotificationOperateRepo = TroopNotificationOperateRepo.f300860a;
        TroopNotificationBaseButtonParser.a aVar = this.pendingClickData;
        if (aVar == null || (b16 = aVar.b()) == null) {
            str2 = "";
        } else {
            str2 = b16;
        }
        troopNotificationOperateRepo.q(fVar, 2, str2, str, booleanExtra, new Function4<Boolean, Integer, String, f, Unit>() { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$onActivityResult$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationDetailVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str3, f fVar2) {
                invoke(bool.booleanValue(), num.intValue(), str3, fVar2);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull f newMsg) {
                TroopNotificationBaseButtonParser.a aVar2;
                String str3;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, newMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(newMsg, "newMsg");
                g gVar = g.f300931a;
                aVar2 = TroopNotificationDetailVM.this.pendingClickData;
                if (aVar2 == null || (str3 = aVar2.a()) == null) {
                    str3 = "";
                }
                gVar.f(z16, str3, i3);
                if (z16) {
                    TroopNotificationDetailVM.this.Z1().postValue(Boolean.TRUE);
                }
            }
        });
    }

    public final void l2(@NotNull GroupNotifyOperateType operateType, @NotNull f msg2, @NotNull final TroopNotificationBaseButtonParser.a clickData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, operateType, msg2, clickData);
            return;
        }
        Intrinsics.checkNotNullParameter(operateType, "operateType");
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(clickData, "clickData");
        TroopNotificationOperateRepo.r(TroopNotificationOperateRepo.f300860a, msg2, 2, clickData.b(), null, false, new Function4<Boolean, Integer, String, f, Unit>(this) { // from class: com.tencent.mobileqq.troop.troopnotification.vm.TroopNotificationDetailVM$operateNotification$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ TroopNotificationDetailVM this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(4);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopNotificationBaseButtonParser.a.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num, String str, f fVar) {
                invoke(bool.booleanValue(), num.intValue(), str, fVar);
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3, @NotNull String errMsg, @NotNull f newMsg) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Boolean.valueOf(z16), Integer.valueOf(i3), errMsg, newMsg);
                    return;
                }
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                Intrinsics.checkNotNullParameter(newMsg, "newMsg");
                g.f300931a.f(z16, TroopNotificationBaseButtonParser.a.this.a(), i3);
                if (z16) {
                    this.this$0.Z1().postValue(Boolean.TRUE);
                }
            }
        }, 24, null);
    }
}
