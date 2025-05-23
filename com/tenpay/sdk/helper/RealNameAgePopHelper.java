package com.tenpay.sdk.helper;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.Window;
import android.widget.TextView;
import com.qwallet.utils.QWalletUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import com.tencent.qphone.base.util.QLog;
import com.tenpay.idverify.model.ChildrenRealNameConfig;
import com.tenpay.sdk.helper.RealNameAgePopHelper;
import com.tenpay.util.Utils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import x05.c;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0003\u001d\u001e\u001fB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J;\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u0016H\u0002J;\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\r0\u0016H\u0002J \u0010\u001c\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/tenpay/sdk/helper/RealNameAgePopHelper;", "", "()V", "TAG", "", "getCidAgeType", "Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopAgeType;", "cid", "isNeedPop", "", "popType", "", "popAgeDialog", "", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/app/Activity;", "ageType", "callback", "Lcom/tenpay/sdk/helper/RealNameAgePopHelper$IRealNamePopCallback;", "popCommonDialog", "dialogData", "Lcom/tenpay/idverify/model/ChildrenRealNameConfig$PopConfig;", "Lkotlin/Function1;", "Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopResult;", "Lkotlin/ParameterName;", "name", "result", "popParentCommitDialog", "tryPopByCID", "EnumPopAgeType", "EnumPopResult", "IRealNamePopCallback", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes27.dex */
public final class RealNameAgePopHelper {

    @NotNull
    public static final RealNameAgePopHelper INSTANCE = new RealNameAgePopHelper();

    @NotNull
    private static final String TAG = "RealNameAgePopHelper";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n\u00a8\u0006\f"}, d2 = {"Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopAgeType;", "", "value", "", "(Ljava/lang/String;II)V", HippyTextInputController.COMMAND_getValue, "()I", "REJECT_0_8", "PARENT_CONFIRM_16_18", "ADULT_PASS_18", "PARENT_COMMIT_8_16", "Companion", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EnumPopAgeType {
        REJECT_0_8(1),
        PARENT_CONFIRM_16_18(2),
        ADULT_PASS_18(3),
        PARENT_COMMIT_8_16(4);


        /* renamed from: Companion, reason: from kotlin metadata */
        @NotNull
        public static final Companion INSTANCE = new Companion(null);
        private final int value;

        @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopAgeType$Companion;", "", "()V", "intValueOf", "Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopAgeType;", "value", "", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* loaded from: classes27.dex */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            @Nullable
            public final EnumPopAgeType intValueOf(int value) {
                boolean z16;
                for (EnumPopAgeType enumPopAgeType : EnumPopAgeType.values()) {
                    if (enumPopAgeType.getValue() == value) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (z16) {
                        return enumPopAgeType;
                    }
                }
                return null;
            }

            Companion() {
            }
        }

        EnumPopAgeType(int i3) {
            this.value = i3;
        }

        @JvmStatic
        @Nullable
        public static final EnumPopAgeType intValueOf(int i3) {
            return INSTANCE.intValueOf(i3);
        }

        public final int getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopResult;", "", "(Ljava/lang/String;I)V", "REJECT", "AGREE", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public enum EnumPopResult {
        REJECT,
        AGREE
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a8\u0006\b"}, d2 = {"Lcom/tenpay/sdk/helper/RealNameAgePopHelper$IRealNamePopCallback;", "", "onPopCallback", "", "popType", "Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopAgeType;", "result", "Lcom/tenpay/sdk/helper/RealNameAgePopHelper$EnumPopResult;", "qwallet-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public interface IRealNamePopCallback {
        void onPopCallback(@NotNull EnumPopAgeType popType, @NotNull EnumPopResult result);
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[EnumPopAgeType.values().length];
            try {
                iArr[EnumPopAgeType.REJECT_0_8.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumPopAgeType.PARENT_COMMIT_8_16.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumPopAgeType.PARENT_CONFIRM_16_18.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumPopAgeType.ADULT_PASS_18.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    RealNameAgePopHelper() {
    }

    @JvmStatic
    @NotNull
    public static final EnumPopAgeType getCidAgeType(@NotNull String cid) {
        Intrinsics.checkNotNullParameter(cid, "cid");
        EnumPopAgeType realNameAgeType = ChildrenRealNameConfig.INSTANCE.get().getRealNameAgeType(Utils.getAgeByIDNumber(cid));
        QLog.i(TAG, 1, "getCidAgeType: " + realNameAgeType);
        return realNameAgeType;
    }

    @JvmStatic
    public static final boolean isNeedPop(int popType) {
        boolean z16;
        if (popType == EnumPopAgeType.REJECT_0_8.getValue() || popType == EnumPopAgeType.PARENT_COMMIT_8_16.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && popType != EnumPopAgeType.PARENT_CONFIRM_16_18.getValue()) {
            return false;
        }
        return true;
    }

    @JvmStatic
    public static final void popAgeDialog(@NotNull Activity activity, @NotNull final EnumPopAgeType ageType, @NotNull final IRealNamePopCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(ageType, "ageType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ChildrenRealNameConfig childrenRealNameConfig = ChildrenRealNameConfig.INSTANCE.get();
        int i3 = WhenMappings.$EnumSwitchMapping$0[ageType.ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        callback.onPopCallback(ageType, EnumPopResult.AGREE);
                        return;
                    }
                    return;
                }
                INSTANCE.popCommonDialog(activity, childrenRealNameConfig.getNonAgeGuideTip(), new Function1<EnumPopResult, Unit>() { // from class: com.tenpay.sdk.helper.RealNameAgePopHelper$popAgeDialog$3
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(RealNameAgePopHelper.EnumPopResult enumPopResult) {
                        invoke2(enumPopResult);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull RealNameAgePopHelper.EnumPopResult result) {
                        Intrinsics.checkNotNullParameter(result, "result");
                        RealNameAgePopHelper.IRealNamePopCallback.this.onPopCallback(ageType, result);
                    }
                });
                return;
            }
            INSTANCE.popParentCommitDialog(activity, childrenRealNameConfig.getChildAgeTip(), new Function1<EnumPopResult, Unit>() { // from class: com.tenpay.sdk.helper.RealNameAgePopHelper$popAgeDialog$2
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RealNameAgePopHelper.EnumPopResult enumPopResult) {
                    invoke2(enumPopResult);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull RealNameAgePopHelper.EnumPopResult result) {
                    Intrinsics.checkNotNullParameter(result, "result");
                    RealNameAgePopHelper.IRealNamePopCallback.this.onPopCallback(ageType, result);
                }
            });
            return;
        }
        INSTANCE.popCommonDialog(activity, childrenRealNameConfig.getNonAgeRejectTip(), new Function1<EnumPopResult, Unit>() { // from class: com.tenpay.sdk.helper.RealNameAgePopHelper$popAgeDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(RealNameAgePopHelper.EnumPopResult enumPopResult) {
                invoke2(enumPopResult);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull RealNameAgePopHelper.EnumPopResult result) {
                Intrinsics.checkNotNullParameter(result, "result");
                RealNameAgePopHelper.IRealNamePopCallback.this.onPopCallback(ageType, result);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[Catch: JSONException -> 0x00a4, TryCatch #0 {JSONException -> 0x00a4, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0092, B:29:0x00a0, B:33:0x006f, B:36:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076 A[Catch: JSONException -> 0x00a4, TryCatch #0 {JSONException -> 0x00a4, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0092, B:29:0x00a0, B:33:0x006f, B:36:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0092 A[Catch: JSONException -> 0x00a4, TryCatch #0 {JSONException -> 0x00a4, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0092, B:29:0x00a0, B:33:0x006f, B:36:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006f A[Catch: JSONException -> 0x00a4, TryCatch #0 {JSONException -> 0x00a4, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0092, B:29:0x00a0, B:33:0x006f, B:36:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004a A[Catch: JSONException -> 0x00a4, TryCatch #0 {JSONException -> 0x00a4, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0092, B:29:0x00a0, B:33:0x006f, B:36:0x004a), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void popCommonDialog(final Activity activity, ChildrenRealNameConfig.PopConfig dialogData, final Function1<? super EnumPopResult, Unit> callback) {
        String str;
        boolean z16;
        final Function2<DialogInterface, Integer, Unit> function2;
        DialogInterface.OnClickListener onClickListener;
        String leftButton;
        boolean z17;
        final Function2<DialogInterface, Integer, Unit> function22;
        TextView btnight;
        try {
            String retMsg = dialogData.getRetMsg();
            DialogInterface.OnClickListener onClickListener2 = null;
            if (retMsg != null) {
                str = StringsKt__StringsJVMKt.replace$default(retMsg, RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
            } else {
                str = null;
            }
            CharSequence e16 = x05.c.e(str, new c.InterfaceC11524c() { // from class: com.tenpay.sdk.helper.a
                @Override // x05.c.InterfaceC11524c
                public final void onClickUrl(String str2) {
                    RealNameAgePopHelper.popCommonDialog$lambda$1(activity, str2);
                }
            });
            String title = dialogData.getTitle();
            String leftButton2 = dialogData.getLeftButton();
            String rightButton = dialogData.getRightButton();
            String rightButton2 = dialogData.getRightButton();
            if (rightButton2 != null && rightButton2.length() != 0) {
                z16 = false;
                if (!z16) {
                    function2 = null;
                } else {
                    function2 = new Function2<DialogInterface, Integer, Unit>() { // from class: com.tenpay.sdk.helper.RealNameAgePopHelper$popCommonDialog$dialog$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface, Integer num) {
                            invoke(dialogInterface, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DialogInterface dialogInterface, int i3) {
                            callback.invoke(RealNameAgePopHelper.EnumPopResult.AGREE);
                        }
                    };
                }
                if (function2 == null) {
                    onClickListener = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.helper.b
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            RealNameAgePopHelper.popCommonDialog$lambda$2(Function2.this, dialogInterface, i3);
                        }
                    };
                } else {
                    onClickListener = null;
                }
                leftButton = dialogData.getLeftButton();
                if (leftButton != null && leftButton.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        function22 = null;
                    } else {
                        function22 = new Function2<DialogInterface, Integer, Unit>() { // from class: com.tenpay.sdk.helper.RealNameAgePopHelper$popCommonDialog$dialog$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface, Integer num) {
                                invoke(dialogInterface, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(DialogInterface dialogInterface, int i3) {
                                callback.invoke(RealNameAgePopHelper.EnumPopResult.REJECT);
                            }
                        };
                    }
                    if (function22 != null) {
                        onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.helper.c
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                RealNameAgePopHelper.popCommonDialog$lambda$3(Function2.this, dialogInterface, i3);
                            }
                        };
                    }
                    QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.f167856jn, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
                    createCustomDialogUrlWithoutAutoLink.setTitleMutiLine();
                    createCustomDialogUrlWithoutAutoLink.setCancelable(false);
                    createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
                    btnight = createCustomDialogUrlWithoutAutoLink.getBtnight();
                    if (btnight != null) {
                        btnight.setTextColor(activity.getResources().getColor(R.color.bf9));
                    }
                    createCustomDialogUrlWithoutAutoLink.show();
                }
                z17 = true;
                if (!z17) {
                }
                if (function22 != null) {
                }
                QQCustomDialog createCustomDialogUrlWithoutAutoLink2 = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.f167856jn, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
                createCustomDialogUrlWithoutAutoLink2.setTitleMutiLine();
                createCustomDialogUrlWithoutAutoLink2.setCancelable(false);
                createCustomDialogUrlWithoutAutoLink2.setCanceledOnTouchOutside(false);
                btnight = createCustomDialogUrlWithoutAutoLink2.getBtnight();
                if (btnight != null) {
                }
                createCustomDialogUrlWithoutAutoLink2.show();
            }
            z16 = true;
            if (!z16) {
            }
            if (function2 == null) {
            }
            leftButton = dialogData.getLeftButton();
            if (leftButton != null) {
                z17 = false;
                if (!z17) {
                }
                if (function22 != null) {
                }
                QQCustomDialog createCustomDialogUrlWithoutAutoLink22 = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.f167856jn, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
                createCustomDialogUrlWithoutAutoLink22.setTitleMutiLine();
                createCustomDialogUrlWithoutAutoLink22.setCancelable(false);
                createCustomDialogUrlWithoutAutoLink22.setCanceledOnTouchOutside(false);
                btnight = createCustomDialogUrlWithoutAutoLink22.getBtnight();
                if (btnight != null) {
                }
                createCustomDialogUrlWithoutAutoLink22.show();
            }
            z17 = true;
            if (!z17) {
            }
            if (function22 != null) {
            }
            QQCustomDialog createCustomDialogUrlWithoutAutoLink222 = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.f167856jn, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
            createCustomDialogUrlWithoutAutoLink222.setTitleMutiLine();
            createCustomDialogUrlWithoutAutoLink222.setCancelable(false);
            createCustomDialogUrlWithoutAutoLink222.setCanceledOnTouchOutside(false);
            btnight = createCustomDialogUrlWithoutAutoLink222.getBtnight();
            if (btnight != null) {
            }
            createCustomDialogUrlWithoutAutoLink222.show();
        } catch (JSONException e17) {
            QLog.w(TAG, 1, "popCommonDialog fail: ", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popCommonDialog$lambda$1(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QWalletUtils.k(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popCommonDialog$lambda$2(Function2 function2, DialogInterface dialogInterface, int i3) {
        function2.invoke(dialogInterface, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popCommonDialog$lambda$3(Function2 function2, DialogInterface dialogInterface, int i3) {
        function2.invoke(dialogInterface, Integer.valueOf(i3));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[Catch: JSONException -> 0x00b9, TryCatch #0 {JSONException -> 0x00b9, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0093, B:29:0x0096, B:31:0x009c, B:32:0x00b5, B:36:0x006f, B:39:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0076 A[Catch: JSONException -> 0x00b9, TryCatch #0 {JSONException -> 0x00b9, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0093, B:29:0x0096, B:31:0x009c, B:32:0x00b5, B:36:0x006f, B:39:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0093 A[Catch: JSONException -> 0x00b9, TryCatch #0 {JSONException -> 0x00b9, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0093, B:29:0x0096, B:31:0x009c, B:32:0x00b5, B:36:0x006f, B:39:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009c A[Catch: JSONException -> 0x00b9, TryCatch #0 {JSONException -> 0x00b9, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0093, B:29:0x0096, B:31:0x009c, B:32:0x00b5, B:36:0x006f, B:39:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006f A[Catch: JSONException -> 0x00b9, TryCatch #0 {JSONException -> 0x00b9, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0093, B:29:0x0096, B:31:0x009c, B:32:0x00b5, B:36:0x006f, B:39:0x004a), top: B:2:0x0003 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x004a A[Catch: JSONException -> 0x00b9, TryCatch #0 {JSONException -> 0x00b9, blocks: (B:3:0x0003, B:5:0x000a, B:6:0x0019, B:8:0x003c, B:15:0x0051, B:16:0x005b, B:18:0x0061, B:25:0x0076, B:26:0x007b, B:28:0x0093, B:29:0x0096, B:31:0x009c, B:32:0x00b5, B:36:0x006f, B:39:0x004a), top: B:2:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void popParentCommitDialog(final Activity activity, ChildrenRealNameConfig.PopConfig dialogData, final Function1<? super EnumPopResult, Unit> callback) {
        String str;
        boolean z16;
        final Function2<DialogInterface, Integer, Unit> function2;
        DialogInterface.OnClickListener onClickListener;
        String leftButton;
        boolean z17;
        final Function2<DialogInterface, Integer, Unit> function22;
        TextView btnight;
        Window window;
        try {
            String retMsg = dialogData.getRetMsg();
            DialogInterface.OnClickListener onClickListener2 = null;
            if (retMsg != null) {
                str = StringsKt__StringsJVMKt.replace$default(retMsg, RedTouch.NEWLINE_CHAR, "\n", false, 4, (Object) null);
            } else {
                str = null;
            }
            CharSequence e16 = x05.c.e(str, new c.InterfaceC11524c() { // from class: com.tenpay.sdk.helper.d
                @Override // x05.c.InterfaceC11524c
                public final void onClickUrl(String str2) {
                    RealNameAgePopHelper.popParentCommitDialog$lambda$5(activity, str2);
                }
            });
            String title = dialogData.getTitle();
            String leftButton2 = dialogData.getLeftButton();
            String rightButton = dialogData.getRightButton();
            String rightButton2 = dialogData.getRightButton();
            if (rightButton2 != null && rightButton2.length() != 0) {
                z16 = false;
                if (!z16) {
                    function2 = null;
                } else {
                    function2 = new Function2<DialogInterface, Integer, Unit>() { // from class: com.tenpay.sdk.helper.RealNameAgePopHelper$popParentCommitDialog$dialog$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface, Integer num) {
                            invoke(dialogInterface, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(DialogInterface dialogInterface, int i3) {
                            callback.invoke(RealNameAgePopHelper.EnumPopResult.AGREE);
                        }
                    };
                }
                if (function2 == null) {
                    onClickListener = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.helper.e
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i3) {
                            RealNameAgePopHelper.popParentCommitDialog$lambda$6(Function2.this, dialogInterface, i3);
                        }
                    };
                } else {
                    onClickListener = null;
                }
                leftButton = dialogData.getLeftButton();
                if (leftButton != null && leftButton.length() != 0) {
                    z17 = false;
                    if (!z17) {
                        function22 = null;
                    } else {
                        function22 = new Function2<DialogInterface, Integer, Unit>() { // from class: com.tenpay.sdk.helper.RealNameAgePopHelper$popParentCommitDialog$dialog$2
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(DialogInterface dialogInterface, Integer num) {
                                invoke(dialogInterface, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(DialogInterface dialogInterface, int i3) {
                                callback.invoke(RealNameAgePopHelper.EnumPopResult.REJECT);
                            }
                        };
                    }
                    if (function22 != null) {
                        onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tenpay.sdk.helper.f
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i3) {
                                RealNameAgePopHelper.popParentCommitDialog$lambda$7(Function2.this, dialogInterface, i3);
                            }
                        };
                    }
                    QQCustomDialog createCustomDialogUrlWithoutAutoLink = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.fz7, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
                    createCustomDialogUrlWithoutAutoLink.setTitleMutiLine();
                    createCustomDialogUrlWithoutAutoLink.setCancelable(false);
                    createCustomDialogUrlWithoutAutoLink.setCanceledOnTouchOutside(false);
                    btnight = createCustomDialogUrlWithoutAutoLink.getBtnight();
                    if (btnight != null) {
                        btnight.setTextColor(-1);
                    }
                    window = createCustomDialogUrlWithoutAutoLink.getWindow();
                    if (window != null) {
                        window.setGravity(80);
                        window.getDecorView().setPadding(0, 0, 0, 0);
                        window.getAttributes().width = -1;
                        window.getAttributes().height = -2;
                    }
                    createCustomDialogUrlWithoutAutoLink.show();
                }
                z17 = true;
                if (!z17) {
                }
                if (function22 != null) {
                }
                QQCustomDialog createCustomDialogUrlWithoutAutoLink2 = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.fz7, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
                createCustomDialogUrlWithoutAutoLink2.setTitleMutiLine();
                createCustomDialogUrlWithoutAutoLink2.setCancelable(false);
                createCustomDialogUrlWithoutAutoLink2.setCanceledOnTouchOutside(false);
                btnight = createCustomDialogUrlWithoutAutoLink2.getBtnight();
                if (btnight != null) {
                }
                window = createCustomDialogUrlWithoutAutoLink2.getWindow();
                if (window != null) {
                }
                createCustomDialogUrlWithoutAutoLink2.show();
            }
            z16 = true;
            if (!z16) {
            }
            if (function2 == null) {
            }
            leftButton = dialogData.getLeftButton();
            if (leftButton != null) {
                z17 = false;
                if (!z17) {
                }
                if (function22 != null) {
                }
                QQCustomDialog createCustomDialogUrlWithoutAutoLink22 = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.fz7, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
                createCustomDialogUrlWithoutAutoLink22.setTitleMutiLine();
                createCustomDialogUrlWithoutAutoLink22.setCancelable(false);
                createCustomDialogUrlWithoutAutoLink22.setCanceledOnTouchOutside(false);
                btnight = createCustomDialogUrlWithoutAutoLink22.getBtnight();
                if (btnight != null) {
                }
                window = createCustomDialogUrlWithoutAutoLink22.getWindow();
                if (window != null) {
                }
                createCustomDialogUrlWithoutAutoLink22.show();
            }
            z17 = true;
            if (!z17) {
            }
            if (function22 != null) {
            }
            QQCustomDialog createCustomDialogUrlWithoutAutoLink222 = DialogUtil.createCustomDialogUrlWithoutAutoLink(activity, 230, R.layout.fz7, title, e16, leftButton2, rightButton, onClickListener, onClickListener2);
            createCustomDialogUrlWithoutAutoLink222.setTitleMutiLine();
            createCustomDialogUrlWithoutAutoLink222.setCancelable(false);
            createCustomDialogUrlWithoutAutoLink222.setCanceledOnTouchOutside(false);
            btnight = createCustomDialogUrlWithoutAutoLink222.getBtnight();
            if (btnight != null) {
            }
            window = createCustomDialogUrlWithoutAutoLink222.getWindow();
            if (window != null) {
            }
            createCustomDialogUrlWithoutAutoLink222.show();
        } catch (JSONException e17) {
            QLog.w(TAG, 1, "popParentCommitDialog fail: ", e17);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popParentCommitDialog$lambda$5(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "$activity");
        QWalletUtils.k(activity, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popParentCommitDialog$lambda$6(Function2 function2, DialogInterface dialogInterface, int i3) {
        function2.invoke(dialogInterface, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void popParentCommitDialog$lambda$7(Function2 function2, DialogInterface dialogInterface, int i3) {
        function2.invoke(dialogInterface, Integer.valueOf(i3));
    }

    @JvmStatic
    public static final void tryPopByCID(@NotNull Activity activity, @NotNull String cid, @NotNull IRealNamePopCallback callback) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(cid, "cid");
        Intrinsics.checkNotNullParameter(callback, "callback");
        popAgeDialog(activity, getCidAgeType(cid), callback);
    }
}
