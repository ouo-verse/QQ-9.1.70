package com.tencent.robot.subscribe.api.impl;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog;
import com.tencent.mobileqq.qqpermission.base.AuthorizationRequestInfo;
import com.tencent.mobileqq.qqpermission.base.MessageNotificationInfo;
import com.tencent.mobileqq.qqpermission.view.AuthorizationRequestDialog;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import com.tencent.qqnt.kernel.nativeinterface.IFetchSubscribeMsgTemplateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IRobotCommonCallBack;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateReq;
import com.tencent.qqnt.kernel.nativeinterface.QuerySubscribeMsgTemplateRsp;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateInfo;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateOp;
import com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateSetReq;
import com.tencent.qqnt.kernel.nativeinterface.SubscribePanelInfo;
import com.tencent.robot.profile.data.g;
import com.tencent.robot.subscribe.api.IRobotMessageSubscribeApi;
import com.tencent.robot.subscribe.api.impl.RobotMessageSubscribeApiImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.C11736d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import r64.SubscribeMessageDialogParam;

/* compiled from: P */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0018\u0018\u0000 *2\u00020\u0001:\u0001+B\u0007\u00a2\u0006\u0004\b(\u0010)JC\u0010\u000f\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0002J3\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000b2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0011\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00070\u0002H\u0002J\u0018\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002J3\u0010\u0019\u001a\u00020\u00182\u0006\u0010\f\u001a\u00020\u000b2\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u00022\u0006\u0010\n\u001a\u00020\tH\u0002\u00a2\u0006\u0004\b\u0019\u0010\u001aJ2\u0010\u001e\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2 \u0010\b\u001a\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00070\u001bH\u0002J<\u0010$\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0\u001c2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\n\u0010&\u001a\u0004\u0018\u00010%H\u0002JC\u0010'\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0016\u00a8\u0006,"}, d2 = {"Lcom/tencent/robot/subscribe/api/impl/RobotMessageSubscribeApiImpl;", "Lcom/tencent/robot/subscribe/api/IRobotMessageSubscribeApi;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "state", "", "callback", "Lr64/a;", "dialogParam", "", "srcTag", "Landroid/content/Context;", "context", "fetchDataAndShowAuthorizationDialog", "groupId", "", "isOwner", "checkTroopOwner", "Lcom/tencent/qqnt/kernel/nativeinterface/SubscribePanelInfo;", "panelInfo", "getRequestDialogTitle", "outerCallback", "com/tencent/robot/subscribe/api/impl/RobotMessageSubscribeApiImpl$b", "createAuthorizationListener", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lr64/a;)Lcom/tencent/robot/subscribe/api/impl/RobotMessageSubscribeApiImpl$b;", "Lkotlin/Function2;", "", "Lcom/tencent/mobileqq/qqpermission/base/MessageNotificationInfo;", "pullSubscribeMessageTemplateInfo", "", "robotUin", "", "templateIds", "listChecked", "subscribeMsgTemplate", "Lcom/tencent/qqnt/kernel/api/ac;", "getRobotService", "showTicketRequestDialog", "<init>", "()V", "Companion", "a", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class RobotMessageSubscribeApiImpl implements IRobotMessageSubscribeApi {

    @NotNull
    private static final a Companion = new a(null);

    @Deprecated
    @NotNull
    private static final String TAG = "RobotMessageSubscribeApiImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/subscribe/api/impl/RobotMessageSubscribeApiImpl$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0005H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/robot/subscribe/api/impl/RobotMessageSubscribeApiImpl$b", "Lcom/tencent/mobileqq/qqpermission/authorization/QQAuthorizationDialog$AuthorizationListener;", "", "", "listCheck", "", "onAllow", "onRefuse", "Lcom/tencent/mobileqq/qqpermission/view/AuthorizationRequestDialog;", "dialog", "onDialogDismiss", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    public static final class b extends QQAuthorizationDialog.AuthorizationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SubscribeMessageDialogParam f368580a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RobotMessageSubscribeApiImpl f368581b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f368582c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Function1<Integer, Unit> f368583d;

        /* JADX WARN: Multi-variable type inference failed */
        b(SubscribeMessageDialogParam subscribeMessageDialogParam, RobotMessageSubscribeApiImpl robotMessageSubscribeApiImpl, String str, Function1<? super Integer, Unit> function1) {
            this.f368580a = subscribeMessageDialogParam;
            this.f368581b = robotMessageSubscribeApiImpl;
            this.f368582c = str;
            this.f368583d = function1;
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x001a, code lost:
        
            if (r11 == 0) goto L12;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r11v0, types: [java.util.List<java.lang.Boolean>, java.util.List] */
        /* JADX WARN: Type inference failed for: r11v1, types: [java.util.ArrayList] */
        /* JADX WARN: Type inference failed for: r11v2 */
        /* JADX WARN: Type inference failed for: r11v6 */
        /* JADX WARN: Type inference failed for: r11v7 */
        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onAllow(@Nullable List<Boolean> listCheck) {
            boolean z16;
            int size = this.f368580a.d().size();
            if (listCheck != 0) {
                if (listCheck.size() == size) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (!z16) {
                    listCheck = 0;
                }
            }
            listCheck = new ArrayList<>(size);
            for (int i3 = 0; i3 < size; i3++) {
                listCheck.add(Boolean.FALSE);
            }
            this.f368581b.subscribeMsgTemplate(this.f368582c, this.f368580a.getGroupId(), this.f368580a.getRobotUin(), this.f368580a.d(), listCheck);
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onDialogDismiss(@Nullable AuthorizationRequestDialog dialog) {
            this.f368583d.invoke(0);
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onRefuse() {
            int collectionSizeOrDefault;
            RobotMessageSubscribeApiImpl robotMessageSubscribeApiImpl = this.f368581b;
            String str = this.f368582c;
            long groupId = this.f368580a.getGroupId();
            long robotUin = this.f368580a.getRobotUin();
            List<Object> d16 = this.f368580a.d();
            List<Object> d17 = this.f368580a.d();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(d17, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = d17.iterator();
            while (it.hasNext()) {
                it.next();
                arrayList.add(Boolean.FALSE);
            }
            robotMessageSubscribeApiImpl.subscribeMsgTemplate(str, groupId, robotUin, d16, arrayList);
        }
    }

    private final void checkTroopOwner(String groupId, final Function1<? super Boolean, Unit> callback) {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            callback.invoke(Boolean.FALSE);
        } else {
            ((ITroopInfoService) peekAppRuntime.getRuntimeService(ITroopInfoService.class, "")).asyncGetTroopInfo(groupId, new com.tencent.mobileqq.data.troop.a() { // from class: com.tencent.robot.subscribe.api.impl.b
                @Override // com.tencent.mobileqq.data.troop.a
                public final void a(TroopInfo troopInfo) {
                    RobotMessageSubscribeApiImpl.checkTroopOwner$lambda$0(Function1.this, peekAppRuntime, troopInfo);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkTroopOwner$lambda$0(Function1 callback, AppRuntime appRuntime, TroopInfo troopInfo) {
        boolean z16;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (troopInfo != null) {
            String currentAccountUin = appRuntime.getCurrentAccountUin();
            if (currentAccountUin == null) {
                currentAccountUin = "";
            }
            z16 = troopInfo.isTroopOwner(currentAccountUin);
        } else {
            z16 = false;
        }
        callback.invoke(Boolean.valueOf(z16));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final b createAuthorizationListener(String srcTag, Function1<? super Integer, Unit> outerCallback, SubscribeMessageDialogParam dialogParam) {
        return new b(dialogParam, this, srcTag, outerCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fetchDataAndShowAuthorizationDialog(final Function1<? super Integer, Unit> callback, final SubscribeMessageDialogParam dialogParam, final String srcTag, final Context context) {
        callback.invoke(1);
        pullSubscribeMessageTemplateInfo(dialogParam, new Function2<List<? extends MessageNotificationInfo>, SubscribePanelInfo, Unit>() { // from class: com.tencent.robot.subscribe.api.impl.RobotMessageSubscribeApiImpl$fetchDataAndShowAuthorizationDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MessageNotificationInfo> list, SubscribePanelInfo subscribePanelInfo) {
                invoke2(list, subscribePanelInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable final List<? extends MessageNotificationInfo> list, @NotNull final SubscribePanelInfo panelInfo) {
                final RobotMessageSubscribeApiImpl.b createAuthorizationListener;
                Intrinsics.checkNotNullParameter(panelInfo, "panelInfo");
                if (list != null) {
                    createAuthorizationListener = this.createAuthorizationListener(srcTag, callback, dialogParam);
                    final Function1<Integer, Unit> function1 = callback;
                    final Context context2 = context;
                    final SubscribeMessageDialogParam subscribeMessageDialogParam = dialogParam;
                    final RobotMessageSubscribeApiImpl robotMessageSubscribeApiImpl = this;
                    C11736d.c(new Function0<Unit>() { // from class: com.tencent.robot.subscribe.api.impl.RobotMessageSubscribeApiImpl$fetchDataAndShowAuthorizationDialog$1.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            String requestDialogTitle;
                            function1.invoke(2);
                            Context context3 = context2;
                            Drawable b16 = u64.c.b(String.valueOf(subscribeMessageDialogParam.getRobotUin()));
                            requestDialogTitle = robotMessageSubscribeApiImpl.getRequestDialogTitle(subscribeMessageDialogParam, panelInfo);
                            String str = panelInfo.sendActionText;
                            if (str == null) {
                                str = "";
                            }
                            QQAuthorizationDialog.showAuthorizationRequestDialog(context3, new AuthorizationRequestInfo(b16, requestDialogTitle, str, createAuthorizationListener).messageNotificationDialog(list));
                        }
                    });
                    return;
                }
                QLog.e("RobotMessageSubscribeApiImpl", 1, "[pullSubscribeMessageTemplateInfo] error happen");
                callback.invoke(0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String getRequestDialogTitle(SubscribeMessageDialogParam dialogParam, SubscribePanelInfo panelInfo) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Object[] objArr = new Object[2];
        String robotName = dialogParam.getRobotName();
        String str = "";
        if (robotName == null) {
            robotName = "";
        }
        objArr[0] = robotName;
        String str2 = panelInfo.applyActionText;
        if (str2 != null) {
            str = str2;
        }
        objArr[1] = str;
        String format = String.format("%s %s", Arrays.copyOf(objArr, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
        return format;
    }

    private final ac getRobotService() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")) != null) {
            return iKernelService.getRobotService();
        }
        return null;
    }

    private final void pullSubscribeMessageTemplateInfo(SubscribeMessageDialogParam dialogParam, final Function2<? super List<? extends MessageNotificationInfo>, ? super SubscribePanelInfo, Unit> callback) {
        ac robotService = getRobotService();
        if (robotService == null) {
            callback.invoke(null, new SubscribePanelInfo());
            return;
        }
        long robotUin = dialogParam.getRobotUin();
        List<Object> d16 = dialogParam.d();
        Intrinsics.checkNotNull(d16, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID>");
        robotService.FetchSubscribeMsgTemplate(new QuerySubscribeMsgTemplateReq(robotUin, (ArrayList) d16), new IFetchSubscribeMsgTemplateCallback() { // from class: com.tencent.robot.subscribe.api.impl.c
            @Override // com.tencent.qqnt.kernel.nativeinterface.IFetchSubscribeMsgTemplateCallback
            public final void onResult(int i3, String str, QuerySubscribeMsgTemplateRsp querySubscribeMsgTemplateRsp) {
                RobotMessageSubscribeApiImpl.pullSubscribeMessageTemplateInfo$lambda$2(Function2.this, i3, str, querySubscribeMsgTemplateRsp);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void pullSubscribeMessageTemplateInfo$lambda$2(Function2 callback, int i3, String str, QuerySubscribeMsgTemplateRsp querySubscribeMsgTemplateRsp) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (i3 == 0 && querySubscribeMsgTemplateRsp != null) {
            ArrayList<SubscribeMsgTemplateInfo> arrayList = querySubscribeMsgTemplateRsp.templateInfos;
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(new MessageNotificationInfo(((SubscribeMsgTemplateInfo) it.next()).templateTitle, true));
            }
            SubscribePanelInfo subscribePanelInfo = querySubscribeMsgTemplateRsp.panelInfo;
            Intrinsics.checkNotNullExpressionValue(subscribePanelInfo, "response.panelInfo");
            callback.invoke(arrayList2, subscribePanelInfo);
            return;
        }
        QLog.e(TAG, 1, "[fetchSubscribeMsgTemplate]: result=" + i3 + ", error=" + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void subscribeMsgTemplate(final String srcTag, long groupId, long robotUin, List<? extends Object> templateIds, List<Boolean> listChecked) {
        int i3;
        if (listChecked.size() != templateIds.size()) {
            QLog.e(TAG, 1, "[subscribeMsgTemplate] listChecked.size != templateIds.size");
            return;
        }
        Intrinsics.checkNotNull(templateIds, "null cannot be cast to non-null type java.util.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID>{ kotlin.collections.TypeAliasesKt.ArrayList<com.tencent.qqnt.kernel.nativeinterface.SubscribeMsgTemplateID> }");
        ArrayList arrayList = (ArrayList) templateIds;
        ArrayList arrayList2 = new ArrayList();
        int size = templateIds.size();
        for (int i16 = 0; i16 < size; i16++) {
            SubscribeMsgTemplateID subscribeMsgTemplateID = (SubscribeMsgTemplateID) arrayList.get(i16);
            if (listChecked.get(i16).booleanValue()) {
                i3 = 1;
            } else {
                i3 = 2;
            }
            arrayList2.add(new SubscribeMsgTemplateOp(subscribeMsgTemplateID, i3));
        }
        ac robotService = getRobotService();
        if (robotService != null) {
            robotService.SubscribeMsgTemplateSet(new SubscribeMsgTemplateSetReq(groupId, 0L, robotUin, arrayList2), new IRobotCommonCallBack() { // from class: com.tencent.robot.subscribe.api.impl.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IRobotCommonCallBack
                public final void onResult(int i17, String str) {
                    RobotMessageSubscribeApiImpl.subscribeMsgTemplate$lambda$3(srcTag, i17, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void subscribeMsgTemplate$lambda$3(String srcTag, int i3, String str) {
        Intrinsics.checkNotNullParameter(srcTag, "$srcTag");
        QLog.i(TAG, 1, srcTag + " [subscribeMsgTemplateSet]: result=" + i3 + ", errMsg=" + str);
    }

    @Override // com.tencent.robot.subscribe.api.IRobotMessageSubscribeApi
    public void showTicketRequestDialog(@NotNull final String srcTag, @NotNull final Context context, @NotNull final SubscribeMessageDialogParam dialogParam, @NotNull final Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(srcTag, "srcTag");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(dialogParam, "dialogParam");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String valueOf = String.valueOf(dialogParam.getGroupId());
        QLog.i(TAG, 1, "[showTicketRequestDialog]: troopUin=" + valueOf);
        if (g.INSTANCE.b(valueOf)) {
            checkTroopOwner(valueOf, new Function1<Boolean, Unit>() { // from class: com.tencent.robot.subscribe.api.impl.RobotMessageSubscribeApiImpl$showTicketRequestDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                    invoke(bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(boolean z16) {
                    if (z16) {
                        this.fetchDataAndShowAuthorizationDialog(callback, dialogParam, srcTag, context);
                    } else {
                        QQToast.makeText(context, 0, R.string.f222496do, 0).show();
                        callback.invoke(0);
                    }
                }
            });
        } else {
            fetchDataAndShowAuthorizationDialog(callback, dialogParam, srcTag, context);
        }
    }
}
