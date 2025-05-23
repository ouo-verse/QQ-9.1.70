package com.tencent.mobileqq.troop.troopsetting.part;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qui.quisecnavbar.QUISecNavBar;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.aio.BaseAIOUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.IBizTroopMemberInfoService;
import com.tencent.mobileqq.troop.api.IChatSettingForTroopApi;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.ITroopUtilApi;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.troopsetting.event.a;
import com.tencent.mobileqq.troop.troopsetting.modules.memberface.TroopMemberFaceUpdateSource;
import com.tencent.mobileqq.troop.troopsetting.modules.searchway.viewmodel.TroopSearchWayToastEvent;
import com.tencent.mobileqq.troop.troopsetting.vm.TroopSettingViewModel;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troop.TroopExtDBInfoRepo;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mqq.app.AppActivity;
import mqq.app.Constants;
import mqq.app.Foreground;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0001)\u0018\u0000 ;2\u00020\u0001:\u0001<B\u0007\u00a2\u0006\u0004\b9\u0010:J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0002J\u0010\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001a\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\u0010\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0012H\u0002J\b\u0010\u0015\u001a\u00020\u0002H\u0002J\u0012\u0010\u0018\u001a\u00020\u00022\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016J\u001c\u0010\u001d\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001e\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001f\u001a\u00020\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016R\u001e\u0010$\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\"\u00104\u001a\u00020-8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107\u00a8\u0006="}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingMngObserverPart;", "Lcom/tencent/mobileqq/troop/troopsetting/part/h;", "", "T9", "", "isSuccess", "Q9", "success", "", "result", "R9", "Y9", "fromJoinGroup", "P9", "isHomeworkTroop", "", "data", "V9", "Landroid/content/Intent;", "intent", "U9", "X9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onPartCreate", "onPartDestroy", "onPartStop", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/TroopSearchWayToastEvent;", "e", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "troopSearchWayToastReceiver", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "f", "Lcom/tencent/biz/qui/quisecnavbar/QUISecNavBar;", "navbar", "com/tencent/mobileqq/troop/troopsetting/part/TroopSettingMngObserverPart$b", tl.h.F, "Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingMngObserverPart$b;", "fireMemberObserver", "Lcom/tencent/mobileqq/troop/api/observer/b;", "i", "Lcom/tencent/mobileqq/troop/api/observer/b;", "getTroopMngObserver", "()Lcom/tencent/mobileqq/troop/api/observer/b;", "setTroopMngObserver", "(Lcom/tencent/mobileqq/troop/api/observer/b;)V", "troopMngObserver", "Landroid/content/BroadcastReceiver;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/BroadcastReceiver;", "mReceiver", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopSettingMngObserverPart extends h {
    static IPatchRedirector $redirector_;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private SimpleEventReceiver<TroopSearchWayToastEvent> troopSearchWayToastReceiver;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private QUISecNavBar navbar;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b fireMemberObserver;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private com.tencent.mobileqq.troop.api.observer.b troopMngObserver;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private BroadcastReceiver mReceiver;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/part/TroopSettingMngObserverPart$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingMngObserverPart$a, reason: from kotlin metadata */
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

    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J>\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/TroopSettingMngObserverPart$b", "Lcom/tencent/mobileqq/troop/api/observer/e;", "", "isSuccess", "", "errorCode", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", SquareJSConst.Params.PARAMS_UIN_LIST, "troopuin", "", "onDeleteTroopMember", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b extends com.tencent.mobileqq.troop.api.observer.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingMngObserverPart.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.e
        protected void onDeleteTroopMember(boolean isSuccess, int errorCode, @Nullable ArrayList<String> uinList, @Nullable String troopuin) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), Integer.valueOf(errorCode), uinList, troopuin);
            } else if (TroopSettingMngObserverPart.this.B9().T2().troopUin != null && !TextUtils.equals(troopuin, TroopSettingMngObserverPart.this.B9().T2().troopUin)) {
                TroopSettingMngObserverPart.this.Q9(isSuccess);
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016J$\u0010\n\u001a\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b`\tH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/TroopSettingMngObserverPart$c", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/mobileqq/troop/troopsetting/modules/searchway/viewmodel/TroopSearchWayToastEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "event", "", "onReceiveEvent", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "Lkotlin/collections/ArrayList;", "getEventClass", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements SimpleEventReceiver<TroopSearchWayToastEvent> {
        static IPatchRedirector $redirector_;

        c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingMngObserverPart.this);
            }
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        @NotNull
        public ArrayList<Class<TroopSearchWayToastEvent>> getEventClass() {
            ArrayList<Class<TroopSearchWayToastEvent>> arrayListOf;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(TroopSearchWayToastEvent.class);
                return arrayListOf;
            }
            return (ArrayList) iPatchRedirector.redirect((short) 3, (Object) this);
        }

        @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
        public void onReceiveEvent(@Nullable SimpleBaseEvent event) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 2;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) event);
                return;
            }
            if (event instanceof TroopSearchWayToastEvent) {
                Activity activity = TroopSettingMngObserverPart.this.getActivity();
                Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type mqq.app.AppActivity");
                if (((AppActivity) activity).isResume()) {
                    TroopSearchWayToastEvent troopSearchWayToastEvent = (TroopSearchWayToastEvent) event;
                    if (!troopSearchWayToastEvent.isSuccess()) {
                        i3 = 1;
                    }
                    QQToast.makeText(BaseApplication.context, i3, HardCodeUtil.qqStr(troopSearchWayToastEvent.getResId()), 1).show();
                }
            }
        }
    }

    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J>\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002H\u0014\u00a8\u0006\u0010"}, d2 = {"com/tencent/mobileqq/troop/troopsetting/part/TroopSettingMngObserverPart$d", "Lcom/tencent/mobileqq/troop/api/observer/b;", "", "url", "", "c", "", "isSuccess", "", "troopuin", "oldOwnerUid", "newOwnerUid", "", "result", "strErrorMsg", "e", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class d extends com.tencent.mobileqq.troop.api.observer.b {
        static IPatchRedirector $redirector_;

        d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopSettingMngObserverPart.this);
            }
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void c(@NotNull String url) {
            QBaseActivity qBaseActivity;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) url);
                return;
            }
            Intrinsics.checkNotNullParameter(url, "url");
            if (QLog.isColorLevel()) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("onGetAddTroopWebInfo url=%s", Arrays.copyOf(new Object[]{url}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.d("TroopMngObserverPart", 2, format);
            }
            Activity activity = TroopSettingMngObserverPart.this.getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity == null || !qBaseActivity.isResume()) {
                return;
            }
            if (TextUtils.isEmpty(url)) {
                QQToast.makeText(TroopSettingMngObserverPart.this.getActivity(), 2, R.string.f173066h23, 1).show(qBaseActivity.getTitleBarHeight());
            } else {
                ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).openAddTroopWeb(TroopSettingMngObserverPart.this.getActivity(), url, TroopSettingMngObserverPart.this.B9().T2().troopUin);
                qBaseActivity.overridePendingTransition(R.anim.f154454a3, R.anim.f154442w);
            }
            ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).popBack(TroopSettingMngObserverPart.this.getActivity());
        }

        @Override // com.tencent.mobileqq.troop.api.observer.b
        protected void e(boolean isSuccess, long troopuin, @Nullable String oldOwnerUid, @Nullable String newOwnerUid, int result, @Nullable String strErrorMsg) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), Long.valueOf(troopuin), oldOwnerUid, newOwnerUid, Integer.valueOf(result), strErrorMsg);
                return;
            }
            if (QLog.isDebugVersion()) {
                QLog.d("TroopMngObserverPart", 4, "[onOIDB0X89E_0_Ret] sus:" + isSuccess + ", tUin:" + troopuin + ", old:" + oldOwnerUid + ", new:" + newOwnerUid + ", res:" + result);
            }
            if (isSuccess && result == 0 && TroopSettingMngObserverPart.this.B9().T2().troopUin != null && !TextUtils.isEmpty(TroopSettingMngObserverPart.this.B9().T2().troopUin) && Intrinsics.areEqual(TroopSettingMngObserverPart.this.B9().T2().troopUin, String.valueOf(troopuin))) {
                TroopSettingViewModel B9 = TroopSettingMngObserverPart.this.B9();
                String string = TroopSettingMngObserverPart.this.getContext().getResources().getString(R.string.g3n);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026.api.R.string.quit_troop)");
                B9.b4(new a.r(string));
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopSettingMngObserverPart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.fireMemberObserver = new b();
        this.troopMngObserver = new d();
        this.mReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.troop.troopsetting.part.TroopSettingMngObserverPart$mReceiver$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopSettingMngObserverPart.this);
                }
            }

            @Override // android.content.BroadcastReceiver
            public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                boolean z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                    return;
                }
                Intrinsics.checkNotNullParameter(context, "context");
                Intrinsics.checkNotNullParameter(intent, "intent");
                TroopInfoData T2 = TroopSettingMngObserverPart.this.B9().T2();
                String action = intent.getAction();
                if (T2.troopUin != null && T2.isHomeworkTroop()) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (Intrinsics.areEqual("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT", action)) {
                    String stringExtra = intent.getStringExtra("data");
                    if (Intrinsics.areEqual(IHWTroopUtilsApi.HW_TROOP_IDENTITY_CHANGED_EVENT, intent.getStringExtra("event"))) {
                        TroopSettingMngObserverPart.this.V9(z16, stringExtra);
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual("start_recomend_page", action)) {
                    com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                    Activity activity = TroopSettingMngObserverPart.this.getActivity();
                    Intrinsics.checkNotNullExpressionValue(activity, "activity");
                    aVar.h(activity);
                    return;
                }
                if (Intrinsics.areEqual("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER", action)) {
                    TroopSettingMngObserverPart.this.U9(intent);
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void P9(boolean fromJoinGroup) {
        Intent splashActivityIntent;
        TroopInfoData T2 = B9().T2();
        int i3 = T2.f294880pa;
        if (i3 == 3) {
            Intent intent = new Intent();
            intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            getActivity().setResult(-1, intent);
            com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
            Activity activity = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity, "activity");
            aVar.h(activity);
            return;
        }
        if (i3 == 30) {
            splashActivityIntent = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getChatActivityIntent(getActivity());
        } else {
            splashActivityIntent = ((IChatSettingForTroopApi) QRoute.api(IChatSettingForTroopApi.class)).getSplashActivityIntent(getActivity());
        }
        Intent m3 = BaseAIOUtils.m(splashActivityIntent, new int[]{2});
        m3.putExtra("uin", T2.troopUin);
        m3.putExtra("uintype", 1);
        m3.putExtra("uinname", T2.newTroopName);
        Bundle arguments = getPartHost().getArguments();
        if (arguments == null) {
            arguments = new Bundle();
        }
        if (fromJoinGroup && B9().F2()) {
            m3.putExtra("fromThirdAppByOpenSDK", true);
            m3.putExtra("appid", arguments.getString("appid"));
            m3.putExtra("pkg_name", arguments.getString("pkg_name"));
            m3.putExtra("app_name", arguments.getString("app_name"));
            m3.putExtra("action", arguments.getInt("pkg_name"));
        }
        getActivity().startActivity(m3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Q9(boolean isSuccess) {
        TroopInfo findTroopInfo;
        if (isSuccess && (findTroopInfo = ((ITroopInfoService) z9().getRuntimeService(ITroopInfoService.class, "")).findTroopInfo(B9().T2().troopUin)) != null && findTroopInfo.wMemberNum != B9().T2().wMemberNum) {
            B9().T2().updateTroopAdmMemberNum(findTroopInfo, findTroopInfo.wMemberNum);
            B9().b4(a.h.f301120a);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void R9(boolean success, int result) {
        QBaseActivity qBaseActivity;
        QLog.i("TroopMngObserverPart", 1, "[handleQuitTroopReq] success:" + success + ", result:" + result);
        if (success && result == 0) {
            Intent intent = new Intent();
            intent.putExtra(AppConstants.Key.IS_NEED_FINISH, true);
            Activity activity = getActivity();
            if (activity instanceof QBaseActivity) {
                qBaseActivity = (QBaseActivity) activity;
            } else {
                qBaseActivity = null;
            }
            if (qBaseActivity != null) {
                qBaseActivity.setResult(-1, intent);
            }
            com.tencent.mobileqq.troop.troopsetting.activity.a aVar = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
            Activity activity2 = getActivity();
            Intrinsics.checkNotNullExpressionValue(activity2, "activity");
            aVar.h(activity2);
            return;
        }
        if (result == 9) {
            com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.b();
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bs
                @Override // java.lang.Runnable
                public final void run() {
                    TroopSettingMngObserverPart.S9(TroopSettingMngObserverPart.this);
                }
            });
            return;
        }
        switch (result) {
            case 2013005:
            case 2013006:
                return;
            default:
                if (result != 2013004) {
                    com.tencent.mobileqq.troop.troopsetting.activity.a aVar2 = com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a;
                    Activity activity3 = getActivity();
                    String string = getContext().getResources().getString(R.string.b1a);
                    Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026api.R.string.exit_failed)");
                    aVar2.j(activity3, 2, string, 1500);
                }
                ((ITroopUtilApi) QRoute.api(ITroopUtilApi.class)).popBack(getActivity());
                return;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S9(TroopSettingMngObserverPart this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Y9();
    }

    private final void T9() {
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingMngObserverPart$initObserver$1(this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U9(Intent intent) {
        if (B9().L2() == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("troopUin");
        ArrayList<String> stringArrayListExtra = intent.getStringArrayListExtra("delMemberUins");
        if (stringExtra != null && Intrinsics.areEqual(stringExtra, B9().T2().troopUin) && stringArrayListExtra != null) {
            for (String str : stringArrayListExtra) {
                CopyOnWriteArrayList<String> L2 = B9().L2();
                if (L2 != null) {
                    L2.remove(str);
                }
            }
            TroopInfo S2 = B9().S2();
            if (S2.getTroopUin() != null) {
                if (QLog.isColorLevel()) {
                    QLog.d("TroopMngObserverPart", 2, "onReceive memberNumClient:" + S2.getMemberNumClient() + "  wMemberNum:" + S2.wMemberNum + " delMembers.size():" + stringArrayListExtra.size() + " troopUin:" + S2.troopuin);
                }
                S2.setMemberNumClient(S2.getMemberNumClient() - stringArrayListExtra.size());
            }
            CopyOnWriteArrayList<String> L22 = B9().L2();
            if (L22 != null) {
                TroopExtDBInfoRepo.INSTANCE.updateTroopSettingMemberList(S2.getTroopUin(), L22);
            }
            B9().b4(new a.o(TroopMemberFaceUpdateSource.DELETE_MEMBER_BROADCAST));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void V9(boolean isHomeworkTroop, String data) {
        if (!isHomeworkTroop || TextUtils.isEmpty(data)) {
            return;
        }
        QLog.i("TroopMngObserverPart", 2, "[onHWTroopIdentifyChanged] data:" + data);
        try {
            final TroopInfoData T2 = B9().T2();
            if (data == null) {
                data = "{}";
            }
            JSONObject jSONObject = new JSONObject(data);
            if (!TextUtils.equals(T2.troopUin, jSONObject.optString("groupCode"))) {
                return;
            }
            jSONObject.optString("content");
            String optString = jSONObject.optString("source");
            final int optInt = jSONObject.optInt("rankId", 333);
            final String optString2 = jSONObject.optString("nickName");
            final int optInt2 = jSONObject.optInt("nickNameId");
            final String optString3 = jSONObject.optString("uin");
            final String optString4 = jSONObject.optString("course");
            final String optString5 = jSONObject.optString("name");
            if (Intrinsics.areEqual(IHWTroopUtilsApi.HOMEWORK_TROOP_PROFILE_SOURCE, optString)) {
                ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.troop.troopsetting.part.br
                    @Override // java.lang.Runnable
                    public final void run() {
                        TroopSettingMngObserverPart.W9(TroopSettingMngObserverPart.this, T2, optString3, optString2, optInt, optString4, optString5, optInt2);
                    }
                }, 8, null, false);
            } else {
                Intrinsics.areEqual(IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE, optString);
            }
        } catch (JSONException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void W9(TroopSettingMngObserverPart this$0, TroopInfoData mTroopInfoData, String str, String str2, int i3, String str3, String str4, int i16) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(mTroopInfoData, "$mTroopInfoData");
        ((IBizTroopMemberInfoService) this$0.z9().getRuntimeService(IBizTroopMemberInfoService.class, "")).saveHomeworkTroopMemberIdentity(mTroopInfoData.troopUin, str, str2, i3, str3, str4);
        this$0.B9().h4(str2, Integer.valueOf(i16), str2);
        this$0.B9().b4(new a.o(TroopMemberFaceUpdateSource.HW_TROOP_MODIFY));
    }

    private final void X9() {
        this.troopSearchWayToastReceiver = new c();
        SimpleEventBus.getInstance().registerReceiver(this.troopSearchWayToastReceiver);
        ((ITroopUtilsApi) QRoute.api(ITroopUtilsApi.class)).preloadWebProcess(z9());
    }

    private final void Y9() {
        Activity topActivity = Foreground.getTopActivity();
        if (topActivity != null) {
            final QQCustomDialog qQCustomDialog = new QQCustomDialog(topActivity, R.style.qZoneInputDialog);
            qQCustomDialog.setContentView(R.layout.custom_dialog);
            qQCustomDialog.setCanceledOnTouchOutside(false);
            qQCustomDialog.setTitle("\u6e29\u99a8\u63d0\u793a");
            qQCustomDialog.setMessage("\u672c\u7fa4\u4e3a\u4ed8\u8d39\u8d85\u5927\u7fa4\uff0c\u6682\u4e0d\u652f\u6301\u8f6c\u8ba9\u53ca\u89e3\u6563\uff0c\u656c\u8bf7\u8c05\u89e3\uff01");
            qQCustomDialog.setNegativeButton("\u6211\u77e5\u9053\u4e86", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.troopsetting.part.bt
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    TroopSettingMngObserverPart.Z9(QQCustomDialog.this, dialogInterface, i3);
                }
            });
            qQCustomDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Z9(QQCustomDialog dialog, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        dialog.dismiss();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        QUISecNavBar qUISecNavBar;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) rootView);
            return;
        }
        super.onInitView(rootView);
        T9();
        if (rootView != null) {
            qUISecNavBar = (QUISecNavBar) rootView.findViewById(R.id.jo9);
        } else {
            qUISecNavBar = null;
        }
        this.navbar = qUISecNavBar;
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.part.h, com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        QBaseActivity qBaseActivity;
        QBaseActivity qBaseActivity2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) activity, (Object) savedInstanceState);
            return;
        }
        super.onPartCreate(activity, savedInstanceState);
        boolean z16 = activity instanceof QBaseActivity;
        if (z16) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            qBaseActivity.addObserver(this.troopMngObserver);
            qBaseActivity.addObserver(this.fireMemberObserver);
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("start_recomend_page");
        intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
        intentFilter.addAction("com.tencent.mobileqq.actoino.ACTIONO_DEL_TROOP_MEMBER");
        if (z16) {
            qBaseActivity2 = (QBaseActivity) activity;
        } else {
            qBaseActivity2 = null;
        }
        if (qBaseActivity2 != null) {
            qBaseActivity2.registerReceiver(this.mReceiver, intentFilter);
        }
        X9();
        LifecycleOwner lifecycleOwner = getPartHost().getLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "partHost.hostLifecycleOwner");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(lifecycleOwner), null, null, new TroopSettingMngObserverPart$onPartCreate$2(this, null), 3, null);
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        QBaseActivity qBaseActivity;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity);
            return;
        }
        super.onPartDestroy(activity);
        QBaseActivity qBaseActivity2 = null;
        if (activity instanceof QBaseActivity) {
            qBaseActivity = (QBaseActivity) activity;
        } else {
            qBaseActivity = null;
        }
        if (qBaseActivity != null) {
            qBaseActivity.removeObserver(this.troopMngObserver);
            qBaseActivity.removeObserver(this.fireMemberObserver);
        }
        try {
            if (activity instanceof QBaseActivity) {
                qBaseActivity2 = (QBaseActivity) activity;
            }
            if (qBaseActivity2 != null) {
                qBaseActivity2.unregisterReceiver(this.mReceiver);
            }
        } catch (Exception e16) {
            QLog.e("TroopMngObserverPart", 1, "doOnDestroy unregisterReceiver, e:" + e16.getMessage());
        }
        com.tencent.mobileqq.troop.troopsetting.activity.a.f301056a.a();
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartStop(@Nullable Activity activity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) activity);
            return;
        }
        super.onPartStop(activity);
        try {
            SimpleEventBus.getInstance().unRegisterReceiver(this.troopSearchWayToastReceiver);
        } catch (Exception e16) {
            QLog.e("TroopMngObserverPart", 1, "doOnDestroy unregisterReceiver, e:" + e16.getMessage());
        }
    }
}
