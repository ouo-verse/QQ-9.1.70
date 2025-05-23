package com.tencent.state.library.focus;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.state.mmkv.SKey;
import com.tencent.state.privacy.StrangerPrivacyManager;
import com.tencent.state.report.SquareReportConst;
import com.tencent.state.square.IReporter;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.common.ViewExtensionsKt;
import com.tencent.state.square.mmkv.IMMKV;
import com.tencent.state.view.CommonDialog;
import com.tencent.state.view.CommonDialogData;
import com.tencent.state.view.ContentStyle;
import com.tencent.state.view.ResStyle;
import com.tencent.state.view.SquareSingleCheckBoxView;
import com.tencent.video.decode.AVDecodeError;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002JF\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n26\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0004\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\b0\fJ(\u0010\u0012\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\u00062\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ.\u0010\u0016\u001a\u00020\r2\b\u0010\t\u001a\u0004\u0018\u00010\n2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u00142\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0014J2\u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u00062\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u001cJ\u000e\u0010\u001d\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u001e\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001e\u0010\u001f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\b0\u0014H\u0002J$\u0010!\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u001cJ\"\u0010\"\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014J\"\u0010#\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u001cJ\"\u0010$\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\b0\u001cJ\u000e\u0010%\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ \u0010&\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0010\b\u0002\u0010 \u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0014J2\u0010'\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00142\u0012\b\u0002\u0010\u0018\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0014J0\u0010(\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0017\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00142\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/state/library/focus/FocusDialogTips;", "", "()V", "MAX_HOUR", "", "TAG", "", "checkAndShowStrangerPrivacyDialog", "", "context", "Landroid/content/Context;", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "show", "button", "hasLeaveDeskDialog", "friendName", "Lkotlin/Function0;", "hasOccupiedDialog", "showCalendarDialog", "onConfirm", "onCancel", "showEndFocusDialog", "learnTime", "statText", "Lkotlin/Function1;", "showFirstFocusDialog", "showFirstGroupFocusDialog", "showGroupHelperDialog", "showCallback", "showLibraryWelcomeTip", "showMaxFocusTimeDialog", "showSeeOtherRoomFocusTips", "showShareFindDeskDialog", "showSingleHelperDialog", "showStartFocusDialog", "showSwitchTableDialog", "showWelcomeBackDialog", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class FocusDialogTips {
    public static final FocusDialogTips INSTANCE = new FocusDialogTips();
    private static final int MAX_HOUR = 6;
    private static final String TAG = "FocusDialogTips";

    FocusDialogTips() {
    }

    private final void showGroupHelperDialog(Context context, final Function0<Unit> showCallback) {
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(new ResStyle(Integer.valueOf(R.drawable.i_p), null, null, 0, 0, null, null, null, null, 510, null), "\u540c\u684c\u8bf4\u660e", null, null, "\u6211\u77e5\u9053\u4e86", new ContentStyle("\u540c\u684c\u4e4b\u95f4\u53ef\u4ee5\u4e92\u76f8\u8bf7\u6559\u3001\u966a\u4f34\u4e13\u6ce8\uff0c\u627e\u4e2a\u4e00\u8d77\u6210\u957f\u7684\u5c0f\u4f19\u4f34\u5427\u3002", 0.0f, 0, false, 0, null, null, 126, null), null, false, null, false, 896, null));
        commonDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.state.library.focus.FocusDialogTips$showGroupHelperDialog$1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Function0.this.invoke();
            }
        });
        commonDialog.show();
    }

    public final void showFirstFocusDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_SINGLE_START_FOCUS_TIPS, false, null, false, 12, null)) {
            return;
        }
        showStartFocusDialog(context, new Function0<Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showFirstFocusDialog$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_SINGLE_START_FOCUS_TIPS, true, null, false, 12, null);
            }
        });
    }

    public final void showSingleHelperDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        showStartFocusDialog$default(this, context, null, 2, null);
    }

    public final void hasLeaveDeskDialog(Context context, String friendName, final Function0<Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(friendName, "friendName");
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(null, "\u54ce\u5440\uff0c\u6765\u665a\u4e00\u6b65", null, null, "\u6211\u77e5\u9053\u4e86", new ContentStyle((friendName.length() == 0 ? "TA" : friendName) + " \u5df2\u79bb\u5f00\u5ea7\u4f4d\uff0c\u6709\u7f18\u518d\u4f1a\u5427\uff0c\u4e5f\u53ef\u4ee5\u53bb\u770b\u770b\u5176\u4ed6\u5728\u4e13\u6ce8\u7684\u540c\u5b66\u54e6", 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
        commonDialog.show();
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$hasLeaveDeskDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Function0 function0 = Function0.this;
                if (function0 != null) {
                }
            }
        });
    }

    public final void hasOccupiedDialog(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(null, "\u4f4d\u7f6e\u6709\u4eba\u4e86", "\u53d6\u6d88", "\u627e\u4e00\u4e2a\u4f4d\u7f6e", null, new ContentStyle("\u4f4d\u7f6e\u6709\u4eba\u4e86\uff0c\u662f\u5426\u4e3a\u4f60\u627e\u4e00\u4e2a\u4f4d\u7f6e\n\u4f60\u8bbe\u7f6e\u7684\u4e13\u6ce8\u76ee\u6807\u5c06\u4e3a\u4f60\u540c\u6b65 ", 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
        commonDialog.show();
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$hasOccupiedDialog$1
            public final void invoke(int i3) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }
        });
    }

    public final void showFirstGroupFocusDialog(Context context) {
        if (context == null || IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_GROUP_START_FOCUS_TIPS, false, null, false, 12, null)) {
            return;
        }
        showGroupHelperDialog(context, new Function0<Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showFirstGroupFocusDialog$1
            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_GROUP_START_FOCUS_TIPS, true, null, false, 12, null);
            }
        });
    }

    public final void showStartFocusDialog(Context context, final Function0<Unit> showCallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(new ResStyle(Integer.valueOf(R.drawable.ib8), null, null, 0, 0, null, null, null, null, 510, null), "\u4e13\u6ce8\u8ba1\u65f6\u5df2\u5f00\u59cb", null, null, "\u6211\u77e5\u9053\u4e86", new ContentStyle("\u6ce8\u610f\u907f\u514d\u79bb\u5f00\u56fe\u4e66\u9986\u3001\u5207\u51fa\u4f7f\u7528\u5176\u5b83\u8f6f\u4ef6\u6216\u8005\u5c06\u624b\u673a\u9501\u5c4f\uff0c\u5426\u5219\u53ef\u80fd\u4f1a\u5bfc\u81f4\u4e13\u6ce8\u8ba1\u65f6\u5931\u8d25\u54e6\u3002", 0.0f, 0, false, 0, null, null, 126, null), null, false, null, false, 960, null));
        commonDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.state.library.focus.FocusDialogTips$showStartFocusDialog$1
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                Function0 function0 = Function0.this;
                if (function0 != null) {
                }
            }
        });
        commonDialog.show();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0099  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void checkAndShowStrangerPrivacyDialog(Context context, final Function2<? super Boolean, ? super Integer, Unit> callback) {
        boolean z16;
        ResStyle resStyle;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (CommonDialog.INSTANCE.getHadDialogShowing().get()) {
            SquareBaseKt.getSquareLog().w(TAG, "check and show stranger privacy dialog but hadDialogShowing is true");
            return;
        }
        final long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - IMMKV.DefaultImpls.decodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Library.KEY_STRANGER_DIALOG_SHOW_TIME, 0L, null, false, 12, null) <= 259200000) {
            SquareBaseKt.getSquareLog().d(TAG, "check and show stranger privacy dialog but time limit");
            return;
        }
        String dialogIconFilePath = StrangerPrivacyManager.INSTANCE.getDialogIconFilePath();
        if (dialogIconFilePath != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(dialogIconFilePath);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    SquareBaseKt.getSquareLog().w(TAG, "check and show stranger privacy dialog but iconFilePath invalid " + dialogIconFilePath);
                    resStyle = new ResStyle(null, null, null, 0, 0, null, null, null, null, 508, null);
                } else {
                    resStyle = new ResStyle(null, dialogIconFilePath, null, ViewExtensionsKt.dip(context, 296), ViewExtensionsKt.dip(context, 100), Integer.valueOf(ViewExtensionsKt.dip(context, 102)), Integer.valueOf(ViewExtensionsKt.dip(context, AVDecodeError.JNI_NOT_SUPPORT_PIXFMT_ERR)), null, null, 388, null);
                }
                CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, "\u5c06\u4f60\u7684\u72b6\u6001\u8bbe\u7f6e\u4e3a\u964c\u751f\u4eba\u53ef\u89c1", "\u4ee5\u540e\u518d\u8bf4", "\u4e00\u952e\u8bbe\u7f6e", null, new ContentStyle("\u83b7\u5f97\u66f4\u591a\u5173\u6ce8\u4e0e\u4e92\u52a8\u5427\uff01", 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
                commonDialog.setCanceledOnTouchOutside(false);
                commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$checkAndShowStrangerPrivacyDialog$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                        invoke(num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(int i3) {
                        if (i3 != 2) {
                            SquareBaseKt.getSquareLog().d("FocusDialogTips", "ignore set stranger visible");
                        } else {
                            StrangerPrivacyManager.setStrangerVisible$default(StrangerPrivacyManager.INSTANCE, true, false, null, 6, null);
                        }
                        Function2.this.invoke(Boolean.FALSE, Integer.valueOf(i3));
                    }
                });
                commonDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.state.library.focus.FocusDialogTips$checkAndShowStrangerPrivacyDialog$2
                    @Override // android.content.DialogInterface.OnShowListener
                    public final void onShow(DialogInterface dialogInterface) {
                        IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Library.KEY_STRANGER_DIALOG_SHOW_TIME, currentTimeMillis, null, false, 12, null);
                        callback.invoke(Boolean.TRUE, 0);
                    }
                });
                commonDialog.show();
            }
        }
        z16 = true;
        if (!z16) {
        }
        CommonDialog commonDialog2 = new CommonDialog(context, new CommonDialogData(resStyle, "\u5c06\u4f60\u7684\u72b6\u6001\u8bbe\u7f6e\u4e3a\u964c\u751f\u4eba\u53ef\u89c1", "\u4ee5\u540e\u518d\u8bf4", "\u4e00\u952e\u8bbe\u7f6e", null, new ContentStyle("\u83b7\u5f97\u66f4\u591a\u5173\u6ce8\u4e0e\u4e92\u52a8\u5427\uff01", 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
        commonDialog2.setCanceledOnTouchOutside(false);
        commonDialog2.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$checkAndShowStrangerPrivacyDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                if (i3 != 2) {
                    SquareBaseKt.getSquareLog().d("FocusDialogTips", "ignore set stranger visible");
                } else {
                    StrangerPrivacyManager.setStrangerVisible$default(StrangerPrivacyManager.INSTANCE, true, false, null, 6, null);
                }
                Function2.this.invoke(Boolean.FALSE, Integer.valueOf(i3));
            }
        });
        commonDialog2.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.state.library.focus.FocusDialogTips$checkAndShowStrangerPrivacyDialog$2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                IMMKV.DefaultImpls.encodeLong$default(SquareBaseKt.getSquareMMKV(), SKey.Library.KEY_STRANGER_DIALOG_SHOW_TIME, currentTimeMillis, null, false, 12, null);
                callback.invoke(Boolean.TRUE, 0);
            }
        });
        commonDialog2.show();
    }

    public final void showLibraryWelcomeTip(Context context, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (context != null) {
            ResStyle resStyle = new ResStyle(Integer.valueOf(R.drawable.i_z), null, null, 0, 0, null, null, null, null, 510, null);
            String string = context.getString(R.string.xgk);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026are_library_welcome_tips)");
            CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(resStyle, "\u56fe\u4e66\u9986\u5f00\u5f20\u5566", "\u4ee5\u540e\u518d\u8bf4", "\u53bb\u770b\u770b", null, new ContentStyle(string, 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
            commonDialog.show();
            commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showLibraryWelcomeTip$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    Function1.this.invoke(Boolean.valueOf(i3 == 2));
                }
            });
        }
    }

    public final void showMaxFocusTimeDialog(Context context, final Function0<Unit> callback) {
        if (context != null) {
            CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(new ResStyle(Integer.valueOf(R.drawable.ib8), null, null, 0, 0, null, null, null, null, 510, null), "\u4e13\u6ce8\u7ed3\u675f", null, null, "\u6211\u77e5\u9053\u4e86", new ContentStyle("\u4f60\u5df2\u4e13\u6ce8\u4e866\u4e2a\u5c0f\u65f6\uff0c\u4e13\u6ce8\u65f6\u95f4\u592a\u957f\u5566\uff0c\u4f11\u606f\u4e00\u4e0b\u5427\uff0c\u6ce8\u610f\u52b3\u9038\u7ed3\u5408\u54e6\u3002", 0.0f, 0, false, 0, null, null, 126, null), null, false, null, false, 960, null));
            commonDialog.show();
            commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showMaxFocusTimeDialog$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    Function0 function0 = Function0.this;
                    if (function0 != null) {
                    }
                }
            });
        }
    }

    public final void showSeeOtherRoomFocusTips(Context context, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        String string = context.getString(R.string.xgf);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026ee_other_room_focus_tips)");
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(null, "\u5c0f\u63d0\u793a", "\u53d6\u6d88", "\u786e\u5b9a\u7ed3\u675f", null, new ContentStyle(string, 0.0f, 0, false, 0, null, null, 126, null), null, false, null, false, 960, null));
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showSeeOtherRoomFocusTips$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                if (i3 != 2) {
                    Function1.this.invoke(Boolean.FALSE);
                } else {
                    Function1.this.invoke(Boolean.TRUE);
                }
            }
        });
        commonDialog.show();
    }

    public final void showShareFindDeskDialog(Context context, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_SHARE_GROUP_TIPS, false, null, false, 12, null)) {
            callback.invoke(Boolean.TRUE);
            return;
        }
        IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_SHARE_GROUP_TIPS, true, null, false, 12, null);
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(new ResStyle(Integer.valueOf(R.drawable.ib8), null, null, 0, 0, null, null, null, null, 510, null), "\u627e\u4e2a\u4e00\u8d77\u4e13\u6ce8\u7684\u540c\u684c\u5427", "\u53d6\u6d88", "\u53bb\u9080\u8bf7", null, new ContentStyle("\u540c\u684c\u53ef\u4ee5\u4e92\u76f8\u966a\u4f34\u3001\u4e92\u76f8\u9f13\u52b1\uff0c\u5171\u540c\u4e13\u6ce8\uff0c\u5f62\u6210\u826f\u597d\u7684\u6c1b\u56f4", 0.0f, 0, false, 17, null, null, 110, null), null, false, null, false, 960, null));
        commonDialog.show();
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showShareFindDeskDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Function1.this.invoke(Boolean.valueOf(i3 == 2));
            }
        });
    }

    public final void showSwitchTableDialog(Context context, final Function0<Unit> onConfirm, final Function0<Unit> onCancel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        if (!IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.CAN_SHOW_LIBRARY_SWITCH_TABLE_TIPS, true, null, false, 12, null)) {
            onConfirm.invoke();
            return;
        }
        final SquareSingleCheckBoxView squareSingleCheckBoxView = new SquareSingleCheckBoxView(context, null, 0, 6, null);
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(null, "\u662f\u5426\u66f4\u6362\u5ea7\u4f4d?", "\u7a0d\u540e\u518d\u8bf4", "\u66f4\u6362\u5ea7\u4f4d", null, new ContentStyle("\u5f53\u524d\u4f60\u5df2\u5728\u5176\u5b83\u5ea7\u4f4d\u4e0a\uff0c\u66f4\u6362\u4f4d\u7f6e\u4e0d\u4f1a\u4e2d\u65ad\u4f60\u7684\u4e13\u6ce8\u65f6\u95f4", 0.0f, 0, false, 3, null, null, 102, null), squareSingleCheckBoxView, false, null, false, 896, null));
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showSwitchTableDialog$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                if (i3 == 1) {
                    Function0 function0 = Function0.this;
                    if (function0 != null) {
                        return;
                    }
                    return;
                }
                if (i3 != 2) {
                    return;
                }
                if (squareSingleCheckBoxView.hasSelected()) {
                    IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.CAN_SHOW_LIBRARY_SWITCH_TABLE_TIPS, false, null, false, 12, null);
                }
                onConfirm.invoke();
            }
        });
        commonDialog.show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void hasLeaveDeskDialog$default(FocusDialogTips focusDialogTips, Context context, String str, Function0 function0, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function0 = null;
        }
        focusDialogTips.hasLeaveDeskDialog(context, str, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showMaxFocusTimeDialog$default(FocusDialogTips focusDialogTips, Context context, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        focusDialogTips.showMaxFocusTimeDialog(context, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showStartFocusDialog$default(FocusDialogTips focusDialogTips, Context context, Function0 function0, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function0 = null;
        }
        focusDialogTips.showStartFocusDialog(context, function0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void showSwitchTableDialog$default(FocusDialogTips focusDialogTips, Context context, Function0 function0, Function0 function02, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            function02 = null;
        }
        focusDialogTips.showSwitchTableDialog(context, function0, function02);
    }

    public final boolean showCalendarDialog(Context context, final Function0<Unit> onConfirm, final Function0<Unit> onCancel) {
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        if (context == null || IMMKV.DefaultImpls.decodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_LIBRARY_CALENDAR_TIPS, false, null, false, 12, null)) {
            return false;
        }
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(new ResStyle(Integer.valueOf(R.drawable.i_h), null, null, 0, 0, null, null, null, null, 510, null), "\u4e13\u6ce8\u65e5\u5386\u4e0a\u7ebf\u5566", "\u7a0d\u540e\u518d\u8bf4", "\u53bb\u770b\u770b", null, new ContentStyle("\u4e13\u6ce810\u5206\u949f\u5373\u53ef\u6d82\u6ee1\u5706\u5708\uff0c\u5feb\u6765\u5b8c\u6210\u6bcf\u5929\u81ea\u5f8b\u7684\u5c0f\u76ee\u6807\u5427\uff0c\u5e2e\u4f60\u517b\u6210\u575a\u6301\u7684\u597d\u4e60\u60ef\uff01", 0.0f, 0, false, 17, null, null, 102, null), null, false, null, false, 960, null));
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showCalendarDialog$$inlined$also$lambda$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                if (i3 == 1) {
                    onCancel.invoke();
                } else {
                    if (i3 != 2) {
                        return;
                    }
                    Function0.this.invoke();
                }
            }
        });
        commonDialog.setOnShowListener(new DialogInterface.OnShowListener() { // from class: com.tencent.state.library.focus.FocusDialogTips$showCalendarDialog$1$2
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                IMMKV.DefaultImpls.encodeBool$default(SquareBaseKt.getSquareMMKV(), SKey.Library.HAS_SHOW_LIBRARY_CALENDAR_TIPS, true, null, false, 12, null);
            }
        });
        commonDialog.show();
        return true;
    }

    public final void showEndFocusDialog(Context context, String learnTime, String statText, final Function1<? super Boolean, Unit> callback) {
        boolean isBlank;
        Map<String, Object> mutableMapOf;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(learnTime, "learnTime");
        Intrinsics.checkNotNullParameter(statText, "statText");
        Intrinsics.checkNotNullParameter(callback, "callback");
        TextView textView = new TextView(context);
        textView.setText(statText);
        textView.setTextColor(Color.parseColor("#B2876B"));
        textView.setTextSize(14.0f);
        textView.setGravity(17);
        textView.setBackgroundResource(R.drawable.gtj);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        layoutParams.topMargin = com.tencent.state.ViewExtensionsKt.dip((View) textView, 18);
        Unit unit = Unit.INSTANCE;
        textView.setLayoutParams(layoutParams);
        isBlank = StringsKt__StringsJVMKt.isBlank(statText);
        com.tencent.state.ViewExtensionsKt.setVisibility(textView, !isBlank);
        textView.setPadding(com.tencent.state.ViewExtensionsKt.dip((View) textView, 15), com.tencent.state.ViewExtensionsKt.dip((View) textView, 5), com.tencent.state.ViewExtensionsKt.dip((View) textView, 15), com.tencent.state.ViewExtensionsKt.dip((View) textView, 5));
        CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(new ResStyle(Integer.valueOf(R.drawable.i9l), null, null, 0, 0, null, null, null, null, 510, null), "\u662f\u5426\u7ed3\u675f\u672c\u6b21\u4e13\u6ce8?", "\u53d6\u6d88", "\u786e\u8ba4\u7ed3\u675f", null, new ContentStyle(learnTime, 24.0f, 0, true, 17, null, null, 100, null), textView, false, null, false, 896, null));
        commonDialog.show();
        commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showEndFocusDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3) {
                Map<String, Object> mutableMapOf2;
                Map<String, Object> mutableMapOf3;
                Map<String, Object> mutableMapOf4;
                if (i3 != 2) {
                    Function1.this.invoke(Boolean.FALSE);
                    IReporter squareReporter = SquareBaseKt.getSquareReporter();
                    mutableMapOf4 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "clck"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 0), TuplesKt.to("zplan_event_source_parameters", 1));
                    squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_END_FOCUS_DIALOG, mutableMapOf4);
                } else {
                    Function1.this.invoke(Boolean.TRUE);
                    IReporter squareReporter2 = SquareBaseKt.getSquareReporter();
                    mutableMapOf2 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "clck"), TuplesKt.to(SquareReportConst.Key.KEY_END_POP_WINDOW_BTN, 1), TuplesKt.to("zplan_event_source_parameters", 1));
                    squareReporter2.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_END_FOCUS_DIALOG, mutableMapOf2);
                }
                IReporter squareReporter3 = SquareBaseKt.getSquareReporter();
                mutableMapOf3 = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp_end"), TuplesKt.to("zplan_event_source_parameters", 1));
                squareReporter3.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_END_FOCUS_DIALOG, mutableMapOf3);
            }
        });
        IReporter squareReporter = SquareBaseKt.getSquareReporter();
        mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to("zplan_action_type", "imp"), TuplesKt.to("zplan_event_source_parameters", 1));
        squareReporter.reportEvent(SquareReportConst.CustomEventId.EVENT_ID_END_FOCUS_DIALOG, mutableMapOf);
    }

    public final void showWelcomeBackDialog(Context context, final Function0<Unit> onConfirm, final Function0<Unit> onCancel) {
        Intrinsics.checkNotNullParameter(onConfirm, "onConfirm");
        Intrinsics.checkNotNullParameter(onCancel, "onCancel");
        if (context != null) {
            CommonDialog commonDialog = new CommonDialog(context, new CommonDialogData(null, "\u6b22\u8fce\u56de\u6765", "\u91cd\u65b0\u5f00\u59cb", "\u8fd4\u56de\u5ea7\u4f4d", null, new ContentStyle("\u662f\u5426\u8981\u56de\u5230\u4f60\u521a\u624d\u7684\u5ea7\u4f4d\u7ee7\u7eed\u4e13\u6ce8\uff1f", 0.0f, 0, false, 17, null, null, 102, null), null, false, null, false, 960, null));
            commonDialog.setDismissCallback(new Function1<Integer, Unit>() { // from class: com.tencent.state.library.focus.FocusDialogTips$showWelcomeBackDialog$$inlined$also$lambda$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(int i3) {
                    if (i3 == 1) {
                        Function0.this.invoke();
                    } else {
                        if (i3 != 2) {
                            return;
                        }
                        onConfirm.invoke();
                    }
                }
            });
            commonDialog.show();
        }
    }
}
