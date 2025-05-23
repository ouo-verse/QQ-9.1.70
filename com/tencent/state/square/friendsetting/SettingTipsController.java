package com.tencent.state.square.friendsetting;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.widget.PopupWindowCompat;
import com.tencent.mobileqq.R;
import com.tencent.state.SquareDebug;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.ICommonUtils;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.Square;
import com.tencent.state.square.SquareBase;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareFragment;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.components.SquareGroupReportComponentKt;
import com.tencent.state.square.holder.TroopViewHolder;
import com.tencent.state.square.message.AddRoleDialogInfo;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.square.resource.ISquareViewManagerProxy;
import com.tencent.state.view.SquareAddRoleDialog;
import com.tencent.state.view.TextBubblePopupWindow;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 -2\u00020\u0001:\u0001-B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\f\u001a\u00020\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0006J\u001e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bJ,\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u001dJ\u001c\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fJ\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\u001c\u0010!\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fJ\u001c\u0010\"\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fJ\u001c\u0010#\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fJ\u001c\u0010$\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fJ\u001c\u0010%\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001fJ*\u0010&\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/tencent/state/square/friendsetting/SettingTipsController;", "", "()V", "addRoleBubble", "Lcom/tencent/state/view/TextBubblePopupWindow;", SKey.SettingTips.CLOSE_TO_ME_KEY, "", SKey.SettingTips.TROOP_CLOSE_TO_ME_KEY, "isFixed", SKey.SettingTips.TROOP_HIDE_KEY, "showAddTroopDialogFlagExpireDuration", "", "canShowAddTroopDialog", "remarkFlagOnlyDebug", "", "setHasAddTroop", "fromFriendSelector", "showAddRoleBubble", "squareFragment", "Lcom/tencent/state/square/SquareFragment;", "selectIconView", "Landroid/view/View;", "type", "showAddRoleDialog", "context", "Landroid/content/Context;", "info", "Lcom/tencent/state/square/message/AddRoleDialogInfo;", "callback", "Lkotlin/Function1;", "showCloseToMeTipsIfNeed", "Lkotlin/Function0;", "showFirstToastIfNeed", "showFixedTipsIfNeed", "showHideTipsIfNeed", "showMayKnowEntranceHideDialog", "showTroopCloseToMeTipsFirst", "showTroopHideTipsFirst", "showTroopOperateBubbleForHolder", "vh", "Lcom/tencent/state/square/holder/TroopViewHolder;", "managerProxy", "Lcom/tencent/state/square/resource/ISquareViewManagerProxy;", "dismissListener", "Landroid/widget/PopupWindow$OnDismissListener;", "Companion", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SettingTipsController {
    public static final long ADD_ROLE_BUBBLE_TIMES = 4000;
    private static final int A_WEEK_SECOND = 604800;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_SHOW_DIALOG_COUNT = 3;
    private static final String TAG = "SettingTipsController";
    public static final long TROOP_OPERATE_BUBBLE_TIMES = 4000;
    private static String specialFirstToast;
    private TextBubblePopupWindow addRoleBubble;
    private boolean isCloseToMe;
    private boolean isCloseToMeTroop;
    private boolean isFixed;
    private boolean isHideTroop;
    private int showAddTroopDialogFlagExpireDuration = 604800;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/state/square/friendsetting/SettingTipsController$Companion;", "", "()V", "ADD_ROLE_BUBBLE_TIMES", "", "A_WEEK_SECOND", "", "MAX_SHOW_DIALOG_COUNT", "TAG", "", "TROOP_OPERATE_BUBBLE_TIMES", "specialFirstToast", "getSpecialFirstToast", "()Ljava/lang/String;", "setSpecialFirstToast", "(Ljava/lang/String;)V", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public static final class Companion {
        Companion() {
        }

        public final String getSpecialFirstToast() {
            return SettingTipsController.specialFirstToast;
        }

        public final void setSpecialFirstToast(String str) {
            SettingTipsController.specialFirstToast = str;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final void remarkFlagOnlyDebug() {
        if (Square.INSTANCE.getConfig().isDebug()) {
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.IS_FIRST_GOTO_SQUARE_KEY, true, null, false, 12, null);
            IMMKV.DefaultImpls.removeKey$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_HAS_ADD_TROOP, null, false, 6, null);
            IMMKV.DefaultImpls.removeKey$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_SHOW_ADD_TROOP_DIALOG_COUNT, null, false, 6, null);
            IMMKV.DefaultImpls.removeKey$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_LAST_SHOW_ADD_TROOP_DIALOG_TIME, null, false, 6, null);
        }
    }

    public final void setHasAddTroop(boolean fromFriendSelector) {
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_HAS_ADD_TROOP, true, null, false, 12, null);
    }

    public final void showAddRoleDialog(Context context, AddRoleDialogInfo info, Function1<? super Integer, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(info, "info");
        new SquareAddRoleDialog(context, info, callback).show();
    }

    public final void showFirstToastIfNeed(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = specialFirstToast;
        specialFirstToast = null;
        if (!(str == null || str.length() == 0)) {
            ICommonUtils.DefaultImpls.showToast$default(SquareBase.INSTANCE.getConfig().getCommonUtils(), context, str, 0, 4, (Object) null);
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.IS_FIRST_GOTO_SQUARE_KEY, false, null, false, 12, null);
        } else if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.IS_FIRST_GOTO_SQUARE_KEY, true, null, false, 12, null)) {
            ICommonUtils.DefaultImpls.showToast$default(SquareBase.INSTANCE.getConfig().getCommonUtils(), context, R.string.xev, 0, 4, (Object) null);
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.IS_FIRST_GOTO_SQUARE_KEY, false, null, false, 12, null);
        }
    }

    public final void showHideTipsIfNeed(Context context, Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        callback.invoke();
    }

    public final void showMayKnowEntranceHideDialog(Context context, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
        String string = context.getResources().getString(R.string.xct);
        Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026quare_hide_may_know_user)");
        commonUtils.showDialog(context, string, "\u6211\u77e5\u9053\u4e86", (String) null, false, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showMayKnowEntranceHideDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
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
                Function0.this.invoke();
            }
        });
    }

    public final void showTroopOperateBubbleForHolder(SquareFragment squareFragment, TroopViewHolder vh5, ISquareViewManagerProxy managerProxy, PopupWindow.OnDismissListener dismissListener) {
        Intrinsics.checkNotNullParameter(squareFragment, "squareFragment");
        Intrinsics.checkNotNullParameter(vh5, "vh");
        Context context = squareFragment.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "squareFragment.context ?: return");
            vh5.setBubbleVisible(8);
            Square.INSTANCE.getConfig().getThreadManager().postOnUiDelayed(2000L, new SettingTipsController$showTroopOperateBubbleForHolder$1(context, squareFragment, vh5, dismissListener));
        }
    }

    public final boolean canShowAddTroopDialog() {
        Square square = Square.INSTANCE;
        if (square.getConfig().isDebug() && SquareDebug.INSTANCE.getForceShowAddTroopDialog()) {
            return true;
        }
        if (square.getConfig().isDebug() && SquareDebug.INSTANCE.getShortShowAddTroopExpireDuration()) {
            this.showAddTroopDialogFlagExpireDuration = 60;
        }
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_HAS_ADD_TROOP, false, null, false, 12, null)) {
            SquareBaseKt.getSquareLog().d(TAG, "canShowAddTroopDialog, hasAdd");
            return false;
        }
        int decodeInt$default = IMMKV.DefaultImpls.decodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_SHOW_ADD_TROOP_DIALOG_COUNT, 0, null, false, 12, null);
        if (decodeInt$default >= 3) {
            SquareBaseKt.getSquareLog().d(TAG, "canShowAddTroopDialog, maxCount");
            return false;
        }
        long serverTime = square.getConfig().getCommonUtils().getServerTime();
        long decodeLong$default = IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_LAST_SHOW_ADD_TROOP_DIALOG_TIME, serverTime, null, false, 12, null);
        if (decodeInt$default != 0 && serverTime - decodeLong$default < this.showAddTroopDialogFlagExpireDuration) {
            SquareBaseKt.getSquareLog().d(TAG, "canShowAddTroopDialog, unExpired");
            return false;
        }
        IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_LAST_SHOW_ADD_TROOP_DIALOG_TIME, serverTime, null, false, 12, null);
        IMMKV.DefaultImpls.encodeInt$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.KEY_SHOW_ADD_TROOP_DIALOG_COUNT, decodeInt$default + 1, null, false, 12, null);
        return true;
    }

    public final void showAddRoleBubble(SquareFragment squareFragment, final View selectIconView, int type) {
        Intrinsics.checkNotNullParameter(squareFragment, "squareFragment");
        Intrinsics.checkNotNullParameter(selectIconView, "selectIconView");
        final Context context = squareFragment.getContext();
        if (context != null) {
            Intrinsics.checkNotNullExpressionValue(context, "squareFragment.context ?: return");
            TextBubblePopupWindow textBubblePopupWindow = this.addRoleBubble;
            if (textBubblePopupWindow != null && textBubblePopupWindow.isShowing()) {
                textBubblePopupWindow.dismiss();
            }
            String string = context.getResources().getString(R.string.xei);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026d_role_popup_window_tips)");
            final TextBubblePopupWindow textBubblePopupWindow2 = new TextBubblePopupWindow(context, string);
            int width = selectIconView.getWidth() + ViewExtensionsKt.dip(context, 10);
            int dip = (-selectIconView.getHeight()) + ViewExtensionsKt.dip(context, 5);
            textBubblePopupWindow2.updateBubbleBg(false);
            final Function0<Unit> function0 = new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showAddRoleBubble$2$autoDismissRunnable$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    if (TextBubblePopupWindow.this.isShowing()) {
                        TextBubblePopupWindow.this.dismiss();
                    }
                }
            };
            textBubblePopupWindow2.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showAddRoleBubble$$inlined$apply$lambda$1
                @Override // android.widget.PopupWindow.OnDismissListener
                public final void onDismiss() {
                    TextBubblePopupWindow textBubblePopupWindow3;
                    textBubblePopupWindow3 = this.addRoleBubble;
                    if (Intrinsics.areEqual(textBubblePopupWindow3, TextBubblePopupWindow.this)) {
                        this.addRoleBubble = null;
                    }
                    Square square = Square.INSTANCE;
                    square.getConfig().getThreadManager().removeTaskOnUI(function0);
                    square.getConfig().getReporter().reportEvent("imp_end", TextBubblePopupWindow.this.getTextView(), new LinkedHashMap());
                }
            });
            Square square = Square.INSTANCE;
            square.getConfig().getThreadManager().postOnUiDelayed(4000L, function0);
            IReporter reporter = square.getConfig().getReporter();
            View contentView = textBubblePopupWindow2.getContentView();
            Intrinsics.checkNotNullExpressionValue(contentView, "this.contentView");
            String checkNearby = SquareReportConst.PageId.INSTANCE.checkNearby();
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, SquareGroupReportComponentKt.getSourceFrom(context));
            Unit unit = Unit.INSTANCE;
            reporter.setPageInfo(context, contentView, checkNearby, linkedHashMap);
            square.getConfig().getReporter().setElementInfo(textBubblePopupWindow2.getTextView(), SquareReportConst.ElementId.ELEMENT_ID_SQUARE_ADD_BUBBLE, new LinkedHashMap(), false, false);
            square.getConfig().getReporter().reportEvent("imp", textBubblePopupWindow2.getTextView(), new LinkedHashMap());
            PopupWindowCompat.showAsDropDown(textBubblePopupWindow2, selectIconView, width, dip, 8388611);
            this.addRoleBubble = textBubblePopupWindow2;
        }
    }

    public final void showCloseToMeTipsIfNeed(Context context, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.isCloseToMe && !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.CLOSE_TO_ME_KEY, false, null, false, 12, null) && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            SquareBase.INSTANCE.getConfig().getCommonUtils().showDialog(context, "\u8d34\u8fd1\u6211\u7684\u597d\u53cb\u4f1a\u56fa\u5b9a\u5728\u6211\u7684\u5468\u56f4\u3002", "\u6211\u77e5\u9053\u4e86", (String) null, false, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showCloseToMeTipsIfNeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Function0.this.invoke();
                }
            });
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.CLOSE_TO_ME_KEY, true, null, false, 12, null);
            this.isCloseToMe = true;
            return;
        }
        callback.invoke();
    }

    public final void showFixedTipsIfNeed(Context context, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.isFixed && !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.FIXED_KEY, false, null, false, 12, null) && (context instanceof Activity) && !((Activity) context).isFinishing()) {
            SquareBase.INSTANCE.getConfig().getCommonUtils().showDialog(context, "\u597d\u53cb\u4f1a\u56fa\u5b9a\u5728\u539f\u5730\u4e0d\u52a8\u3002", "\u6211\u77e5\u9053\u4e86", (String) null, false, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showFixedTipsIfNeed$1
                /* JADX INFO: Access modifiers changed from: package-private */
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
                    Function0.this.invoke();
                }
            });
            IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.FIXED_KEY, true, null, false, 12, null);
            this.isFixed = true;
            return;
        }
        callback.invoke();
    }

    public final void showTroopCloseToMeTipsFirst(Context context, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.isCloseToMeTroop && !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.TROOP_CLOSE_TO_ME_KEY, false, null, false, 12, null) && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                String string = activity.getResources().getString(R.string.xdf);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026p_first_close_to_me_tips)");
                commonUtils.showDialog(context, string, "\u6211\u77e5\u9053\u4e86", (String) null, false, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showTroopCloseToMeTipsFirst$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        Function0.this.invoke();
                    }
                });
                IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.TROOP_CLOSE_TO_ME_KEY, true, null, false, 12, null);
                this.isCloseToMeTroop = true;
                return;
            }
        }
        callback.invoke();
    }

    public final void showTroopHideTipsFirst(Context context, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (!this.isHideTroop && !IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.TROOP_HIDE_KEY, false, null, false, 12, null) && (context instanceof Activity)) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                ICommonUtils commonUtils = SquareBase.INSTANCE.getConfig().getCommonUtils();
                String string = activity.getResources().getString(R.string.xdg);
                Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr\u2026re_troop_first_hide_tips)");
                commonUtils.showDialog(context, string, "\u6211\u77e5\u9053\u4e86", (String) null, false, new Function0<Unit>() { // from class: com.tencent.state.square.friendsetting.SettingTipsController$showTroopHideTipsFirst$1
                    /* JADX INFO: Access modifiers changed from: package-private */
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
                        Function0.this.invoke();
                    }
                });
                IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.SettingTips.TROOP_HIDE_KEY, true, null, false, 12, null);
                this.isHideTroop = true;
                return;
            }
        }
        callback.invoke();
    }
}
