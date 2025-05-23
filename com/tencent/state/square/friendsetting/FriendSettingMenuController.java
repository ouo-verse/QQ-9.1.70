package com.tencent.state.square.friendsetting;

import android.content.Context;
import android.view.View;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.mobileqq.R;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareAvatarExtra;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.detail.event.DetailGuestCloseToMeEvent;
import com.tencent.state.square.detail.event.DetailGuestCloseToMeResultInfoEvent;
import com.tencent.state.square.detail.event.DetailGuestFixedEvent;
import com.tencent.state.square.detail.event.DetailGuestGetCloseToMeInfoEvent;
import com.tencent.state.square.detail.event.DetailGuestHideEvent;
import com.tencent.state.utils.SquareSwitchUtils;
import com.tencent.state.view.BottomActionSheet;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import is4.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import wx4.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\u0018\u0000 R2\u00020\u0001:\u0001RB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u00108\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0018\u00109\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010:\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020=J\u0010\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020\u00052\u0006\u0010?\u001a\u00020@H\u0002J\u0018\u0010B\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010C\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0018\u0010D\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0006\u0010E\u001a\u00020\u0005J\u0010\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020HH\u0002J \u0010I\u001a\u00020\u00052\u0006\u0010J\u001a\u00020\f2\u0006\u0010K\u001a\u00020L2\u0006\u0010M\u001a\u00020\fH\u0002J\u001a\u0010N\u001a\u00020\u00052\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00010.J\u0010\u0010P\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\u000e\u0010Q\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0015R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR7\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\f\u00a2\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0007\"\u0004\b\u001a\u0010\tR\u0016\u0010\u001b\u001a\n \u001d*\u0004\u0018\u00010\u001c0\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0007\"\u0004\b \u0010\tR\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\tR\"\u0010$\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\tR\u000e\u0010'\u001a\u00020(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020(X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001c\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0001\u0018\u00010.X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\"\u0010/\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0007\"\u0004\b1\u0010\tR\u000e\u00102\u001a\u000203X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006S"}, d2 = {"Lcom/tencent/state/square/friendsetting/FriendSettingMenuController;", "", "()V", "bubbleSettingCallback", "Lkotlin/Function0;", "", "getBubbleSettingCallback", "()Lkotlin/jvm/functions/Function0;", "setBubbleSettingCallback", "(Lkotlin/jvm/functions/Function0;)V", "cancelHideCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "uin", "getCancelHideCallback", "()Lkotlin/jvm/functions/Function1;", "setCancelHideCallback", "(Lkotlin/jvm/functions/Function1;)V", "context", "Landroid/content/Context;", "data", "Lcom/tencent/state/square/data/SquareAvatarItem;", "endMultiMotionCallback", "getEndMultiMotionCallback", "setEndMultiMotionCallback", "eventBus", "Lcom/tencent/biz/richframework/eventbus/SimpleEventBus;", "kotlin.jvm.PlatformType", "focusEffectsSettingCallback", "getFocusEffectsSettingCallback", "setFocusEffectsSettingCallback", "hideCallback", "getHideCallback", "setHideCallback", "interactionClickCallback", "getInteractionClickCallback", "setInteractionClickCallback", "isBackToSquare", "", SKey.SettingTips.CLOSE_TO_ME_KEY, "isFixed", "isFixing", "isHide", "pageInfo", "", "privacyClickCallback", "getPrivacyClickCallback", "setPrivacyClickCallback", "reporter", "Lcom/tencent/state/square/IReporter;", "service", "Lcom/tencent/state/square/friendsetting/SettingService;", "tipsController", "Lcom/tencent/state/square/friendsetting/SettingTipsController;", "bindSquareView", "cancelFixed", "closeToMe", "doOnGetCloseToMeResultInfo", "event", "Lcom/tencent/state/square/detail/event/DetailGuestCloseToMeResultInfoEvent;", "fillCustom", "dialog", "Lcom/tencent/state/view/BottomActionSheet;", "fillHost", "fixOrCancel", QCircleDaTongConstant.ElementParamValue.FIXED, "hide", "onBackToSquare", "onPrivacyClick", "view", "Landroid/view/View;", "report", "eventId", "btnType", "", "actionType", "setPageInfo", "dtMap", "showHideListPanel", "showMenu", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class FriendSettingMenuController {
    private static final int BUBBLE_SETTING = 7;
    private static final int CHAT_LAND_FOCUS_SETTING = 8;
    private static final int CLOSE_TO_ME = 1;
    private static final int END_MULTI_MOTION = 4;
    private static final int FIXED = 2;
    private static final int GET_HIDE_LIST = 0;
    private static final int HIDE = 3;
    private static final int INTERACTION = 6;
    private static final int PRIVACY_STATUS = 5;
    private static final String TAG = "FriendSettingMenuController";
    private Function0<Unit> bubbleSettingCallback;
    private Function1<? super String, Unit> cancelHideCallback;
    private Context context;
    private SquareAvatarItem data;
    private Function0<Unit> endMultiMotionCallback;
    private Function0<Unit> focusEffectsSettingCallback;
    private Function0<Unit> hideCallback;
    private Function0<Unit> interactionClickCallback;
    private boolean isBackToSquare;
    private boolean isCloseToMe;
    private boolean isFixed;
    private boolean isFixing;
    private boolean isHide;
    private Map<String, Object> pageInfo;
    private Function0<Unit> privacyClickCallback;
    private final SettingService service = new SettingService();
    private final IReporter reporter = SquareBase.INSTANCE.getConfig().getReporter();
    private final SettingTipsController tipsController = new SettingTipsController();
    private SimpleEventBus eventBus = SimpleEventBus.getInstance();

    /* JADX WARN: Code restructure failed: missing block: B:3:0x003c, code lost:
    
        r1 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void cancelFixed(Context context, final SquareAvatarItem data) {
        Long longOrNull;
        SquareBaseKt.getSquareLog().i(TAG, "cancel fixed uin: " + data.getUin());
        SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xcb, 2);
        this.isFixed = false;
        SettingService settingService = this.service;
        String uin = data.getUin();
        long longValue = (uin == null || longOrNull == null) ? 0L : longOrNull.longValue();
        settingService.cancelFixed(longValue, false, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$cancelFixed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                invoke(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3) {
                boolean z17;
                SettingService settingService2;
                FriendSettingMenuController.this.isFixed = !z16;
                SquareAvatarExtra extra = data.getExtra();
                z17 = FriendSettingMenuController.this.isFixed;
                extra.setFixed(z17);
                FriendSettingMenuController.this.isFixing = false;
                settingService2 = FriendSettingMenuController.this.service;
                settingService2.report(SquareReportConst.CustomEventId.EVENT_ID_FIXED_FRIEND, data.getUin(), 0, d.INSTANCE.b(z16), i3, SquareReportConst.Param.EM_STATE_KETAI);
                if (!z16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FriendSettingMenuController", "cancelFixed req error " + data.getUin(), null, 4, null);
                    return;
                }
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FriendSettingMenuController", "cancelFixed success " + data.getUin(), null, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void closeToMe(Context context, final SquareAvatarItem data) {
        SquareBaseKt.getSquareLog().i(TAG, "closeToMe uin: " + data.getUin());
        this.tipsController.showCloseToMeTipsIfNeed(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$closeToMe$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SimpleEventBus simpleEventBus;
                simpleEventBus = FriendSettingMenuController.this.eventBus;
                simpleEventBus.dispatchEvent(new DetailGuestGetCloseToMeInfoEvent(data.getUin()));
            }
        });
    }

    private final void fillCustom(BottomActionSheet dialog) {
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem != null) {
            if (!SquareSwitchUtils.INSTANCE.enableFilamentDetail()) {
                dialog.addActionSheet(6, "\u62cd\u4e00\u62cd");
            }
            report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 4, "imp");
            if (!this.isCloseToMe) {
                dialog.addActionSheet(1, "\u8d34\u8fd1\u6211");
                report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 0, "imp");
            } else {
                dialog.addActionSheet(1, "\u5df2\u8d34\u8fd1");
            }
            if (squareAvatarItem.getExtra().getIsFixed()) {
                dialog.addActionSheet(2, "\u53d6\u6d88\u56fa\u5b9a");
                report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 3, "imp");
            } else {
                dialog.addActionSheet(2, "\u56fa\u5b9a");
                report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 1, "imp");
            }
            dialog.addActionSheet(3, "\u79fb\u9664");
            report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 2, "imp");
            if (squareAvatarItem.getExtra().getIsMultiMotion()) {
                dialog.addActionSheet(4, "\u7ed3\u675f\u4ed6\u7684\u53cc\u4ebaPOSE");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void fixOrCancel(Context context, SquareAvatarItem data) {
        if (this.isFixing) {
            SquareBaseKt.getSquareLog().i(TAG, "isFixing so do nothing");
        } else if (data.getExtra().getIsFixed()) {
            cancelFixed(context, data);
            report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 3, "click");
        } else {
            report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 1, "click");
            fixed(context, data);
        }
    }

    private final void fixed(final Context context, final SquareAvatarItem data) {
        Long longOrNull;
        SquareBaseKt.getSquareLog().i(TAG, "fixed uin: " + data.getUin());
        this.tipsController.showFixedTipsIfNeed(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$fixed$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xcr, 2);
            }
        });
        this.isFixed = true;
        SettingService settingService = this.service;
        b bVar = new b();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(data.getUin());
        bVar.f408677a = longOrNull != null ? longOrNull.longValue() : 0L;
        bVar.f408678b = data.getLocation().getArea();
        bVar.f408679c = data.getLocation().getRank();
        Unit unit = Unit.INSTANCE;
        settingService.setFixed(bVar, false, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$fixed$3
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                invoke(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3) {
                boolean z17;
                SettingService settingService2;
                FriendSettingMenuController.this.isFixed = z16;
                SquareAvatarExtra extra = data.getExtra();
                z17 = FriendSettingMenuController.this.isFixed;
                extra.setFixed(z17);
                FriendSettingMenuController.this.isFixing = false;
                settingService2 = FriendSettingMenuController.this.service;
                settingService2.report(SquareReportConst.CustomEventId.EVENT_ID_FIXED_FRIEND, data.getUin(), 1, d.INSTANCE.b(z16), i3, SquareReportConst.Param.EM_STATE_KETAI);
                if (!z16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FriendSettingMenuController", "fixed req error " + data.getUin(), null, 4, null);
                    return;
                }
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FriendSettingMenuController", "fixed success " + data.getUin(), null, 4, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void hide(final Context context, final SquareAvatarItem data) {
        Long longOrNull;
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(data.getUin());
        if (longOrNull != null) {
            final long longValue = longOrNull.longValue();
            this.tipsController.showHideTipsIfNeed(context, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$hide$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xcu, 2);
                    FriendHideListDataManager.INSTANCE.hide(longValue, data.getUnitType(), new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$hide$1.1
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                            invoke(bool.booleanValue(), num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z16, int i3) {
                            SettingService settingService;
                            SquareBaseKt.getSquareLog().i("FriendSettingMenuController", "hide " + longValue + " result " + z16);
                            settingService = FriendSettingMenuController.this.service;
                            settingService.report(SquareReportConst.CustomEventId.EVENT_ID_HIDE_FRIEND, data.getUin(), 1, d.INSTANCE.b(z16), i3, SquareReportConst.Param.EM_STATE_KETAI);
                        }
                    });
                    FriendSettingMenuController.this.isHide = true;
                    Function0<Unit> hideCallback = FriendSettingMenuController.this.getHideCallback();
                    if (hideCallback != null) {
                        hideCallback.invoke();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onPrivacyClick(View view) {
        Function0<Unit> function0 = this.privacyClickCallback;
        if (function0 != null) {
            function0.invoke();
        }
        this.reporter.reportEvent("click", view, new LinkedHashMap());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void report(String eventId, int btnType, String actionType) {
        IReporter iReporter = this.reporter;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(SquareReportConst.Key.KEY_CUSTOMER_POPUP_BUTTON, Integer.valueOf(btnType));
        linkedHashMap.put("zplan_action_type", actionType);
        Unit unit = Unit.INSTANCE;
        iReporter.reportEvent(eventId, linkedHashMap);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showHideListPanel(Context context) {
        Map map = this.pageInfo;
        if (map == null) {
            map = new LinkedHashMap();
        }
        FriendHideListPanel friendHideListPanel = new FriendHideListPanel(context, map);
        friendHideListPanel.setCancelHideCallback(this.cancelHideCallback);
        friendHideListPanel.show();
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0010, code lost:
    
        if (r1.getRank() == 1) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void bindSquareView(SquareAvatarItem data) {
        boolean z16;
        SquareAvatarExtra extra;
        this.data = data;
        boolean z17 = false;
        if (data != null && (r1 = data.getLocation()) != null) {
            z16 = true;
        }
        z16 = false;
        this.isCloseToMe = z16;
        if (data != null && (extra = data.getExtra()) != null) {
            z17 = extra.getIsFixed();
        }
        this.isFixed = z17;
    }

    public final void doOnGetCloseToMeResultInfo(DetailGuestCloseToMeResultInfoEvent event) {
        final SquareAvatarItem squareAvatarItem;
        Long longOrNull;
        Intrinsics.checkNotNullParameter(event, "event");
        Context context = this.context;
        if (context == null || (squareAvatarItem = this.data) == null) {
            return;
        }
        PlaceInfo placeInfo = event.getPlaceInfo();
        if (placeInfo == null) {
            SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "closeToMe local failed " + squareAvatarItem.getUin(), null, 4, null);
            ICommonUtils.DefaultImpls.showToast$default(SquareBase.INSTANCE.getConfig().getCommonUtils(), context, R.string.xcd, 0, 4, (Object) null);
            return;
        }
        SquareBase.INSTANCE.getConfig().getCommonUtils().showToast(context, R.string.xd5, 2);
        this.isCloseToMe = true;
        this.isFixing = true;
        this.isFixed = true;
        SettingService settingService = this.service;
        b bVar = new b();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(squareAvatarItem.getUin());
        bVar.f408677a = longOrNull != null ? longOrNull.longValue() : 0L;
        bVar.f408678b = placeInfo.getArea();
        bVar.f408679c = placeInfo.getRank();
        Unit unit = Unit.INSTANCE;
        settingService.setFixed(bVar, false, new Function2<Boolean, Integer, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$doOnGetCloseToMeResultInfo$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Integer num) {
                invoke(bool.booleanValue(), num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16, int i3) {
                SettingService settingService2;
                squareAvatarItem.getExtra().setFixed(z16);
                FriendSettingMenuController.this.isCloseToMe = z16;
                FriendSettingMenuController.this.isFixed = z16;
                FriendSettingMenuController.this.isFixing = false;
                settingService2 = FriendSettingMenuController.this.service;
                settingService2.report(SquareReportConst.CustomEventId.EVENT_ID_FIXED_FRIEND, squareAvatarItem.getUin(), 2, d.INSTANCE.b(z16), i3, SquareReportConst.Param.EM_STATE_KETAI);
                if (!z16) {
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FriendSettingMenuController", "closeToMe req error " + squareAvatarItem.getUin(), null, 4, null);
                    return;
                }
                SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), "FriendSettingMenuController", "closeToMe success " + squareAvatarItem.getUin(), null, 4, null);
            }
        });
    }

    public final Function0<Unit> getBubbleSettingCallback() {
        return this.bubbleSettingCallback;
    }

    public final Function1<String, Unit> getCancelHideCallback() {
        return this.cancelHideCallback;
    }

    public final Function0<Unit> getEndMultiMotionCallback() {
        return this.endMultiMotionCallback;
    }

    public final Function0<Unit> getFocusEffectsSettingCallback() {
        return this.focusEffectsSettingCallback;
    }

    public final Function0<Unit> getHideCallback() {
        return this.hideCallback;
    }

    public final Function0<Unit> getInteractionClickCallback() {
        return this.interactionClickCallback;
    }

    public final Function0<Unit> getPrivacyClickCallback() {
        return this.privacyClickCallback;
    }

    public final void onBackToSquare() {
        SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem == null || squareAvatarItem.isMe()) {
            return;
        }
        this.isBackToSquare = true;
        if (this.isCloseToMe) {
            this.eventBus.dispatchEvent(new DetailGuestCloseToMeEvent(squareAvatarItem.getUin()));
        }
        this.eventBus.dispatchEvent(new DetailGuestFixedEvent(squareAvatarItem.getUin(), this.isFixed));
        if (this.isHide) {
            this.eventBus.dispatchEvent(new DetailGuestHideEvent(squareAvatarItem.getUin()));
        }
    }

    public final void setBubbleSettingCallback(Function0<Unit> function0) {
        this.bubbleSettingCallback = function0;
    }

    public final void setCancelHideCallback(Function1<? super String, Unit> function1) {
        this.cancelHideCallback = function1;
    }

    public final void setEndMultiMotionCallback(Function0<Unit> function0) {
        this.endMultiMotionCallback = function0;
    }

    public final void setFocusEffectsSettingCallback(Function0<Unit> function0) {
        this.focusEffectsSettingCallback = function0;
    }

    public final void setHideCallback(Function0<Unit> function0) {
        this.hideCallback = function0;
    }

    public final void setInteractionClickCallback(Function0<Unit> function0) {
        this.interactionClickCallback = function0;
    }

    public final void setPageInfo(Map<String, Object> dtMap) {
        Intrinsics.checkNotNullParameter(dtMap, "dtMap");
        this.pageInfo = dtMap;
    }

    public final void setPrivacyClickCallback(Function0<Unit> function0) {
        this.privacyClickCallback = function0;
    }

    public final void showMenu(final Context context) {
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        final SquareAvatarItem squareAvatarItem = this.data;
        if (squareAvatarItem != null) {
            final BottomActionSheet bottomActionSheet = new BottomActionSheet(context);
            if (!squareAvatarItem.isMe()) {
                fillCustom(bottomActionSheet);
            } else {
                fillHost(bottomActionSheet);
                IReporter squareReporter = SquareBaseKt.getSquareReporter();
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"));
                squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_ZPLAN_BUBBLE_SETTING_BUTTON, mutableMapOf);
            }
            bottomActionSheet.setItemClickListener(new Function2<Integer, View, Unit>() { // from class: com.tencent.state.square.friendsetting.FriendSettingMenuController$showMenu$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view) {
                    invoke(num.intValue(), view);
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3, View view) {
                    boolean z16;
                    Intrinsics.checkNotNullParameter(view, "view");
                    switch (i3) {
                        case 0:
                            FriendSettingMenuController.this.showHideListPanel(context);
                            FriendSettingMenuController.this.report(SquareReportConst.CustomEventId.EVENT_ID_HOST_SETTING_WINDOW, 0, "click");
                            break;
                        case 1:
                            z16 = FriendSettingMenuController.this.isCloseToMe;
                            if (!z16) {
                                FriendSettingMenuController.this.closeToMe(context, squareAvatarItem);
                                FriendSettingMenuController.this.report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 0, "click");
                                break;
                            } else {
                                ICommonUtils.DefaultImpls.showToast$default(SquareBase.INSTANCE.getConfig().getCommonUtils(), context, R.string.xcs, 0, 4, (Object) null);
                                break;
                            }
                        case 2:
                            FriendSettingMenuController.this.fixOrCancel(context, squareAvatarItem);
                            break;
                        case 3:
                            FriendSettingMenuController.this.hide(context, squareAvatarItem);
                            FriendSettingMenuController.this.report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 2, "click");
                            break;
                        case 4:
                            Function0<Unit> endMultiMotionCallback = FriendSettingMenuController.this.getEndMultiMotionCallback();
                            if (endMultiMotionCallback != null) {
                                endMultiMotionCallback.invoke();
                                break;
                            }
                            break;
                        case 5:
                            FriendSettingMenuController.this.onPrivacyClick(view);
                            break;
                        case 6:
                            Function0<Unit> interactionClickCallback = FriendSettingMenuController.this.getInteractionClickCallback();
                            if (interactionClickCallback != null) {
                                interactionClickCallback.invoke();
                            }
                            FriendSettingMenuController.this.report(SquareReportConst.CustomEventId.EVENT_ID_CUSTOM_SETTING_WINDOW, 4, "click");
                            break;
                        case 7:
                            Function0<Unit> bubbleSettingCallback = FriendSettingMenuController.this.getBubbleSettingCallback();
                            if (bubbleSettingCallback != null) {
                                bubbleSettingCallback.invoke();
                                break;
                            }
                            break;
                        case 8:
                            Function0<Unit> focusEffectsSettingCallback = FriendSettingMenuController.this.getFocusEffectsSettingCallback();
                            if (focusEffectsSettingCallback != null) {
                                focusEffectsSettingCallback.invoke();
                                break;
                            }
                            break;
                    }
                    bottomActionSheet.dismiss();
                }
            });
            bottomActionSheet.show();
        }
    }

    private final void fillHost(BottomActionSheet dialog) {
        View addActionSheet = dialog.addActionSheet(5, "\u9690\u79c1\u6388\u6743");
        IReporter.DefaultImpls.setElementInfo$default(this.reporter, addActionSheet, SquareReportConst.ElementId.ELEMENT_ID_MORE_FLOATS, new LinkedHashMap(), false, false, 24, null);
        this.reporter.reportEvent("imp", addActionSheet, new LinkedHashMap());
        dialog.addActionSheet(7, "\u6c14\u6ce1\u8bbe\u7f6e");
    }
}
