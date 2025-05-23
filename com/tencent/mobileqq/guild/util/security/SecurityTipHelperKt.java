package com.tencent.mobileqq.guild.util.security;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.widget.TextView;
import com.google.gson.Gson;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.guild.api.IGuildTempApi;
import com.tencent.mobileqq.guild.util.cb;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a&\u0010\u0007\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0007\u001aH\u0010\u000f\u001a\u00020\u00062\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007\u001a0\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007\u001aP\u0010\u0017\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0001\u001a\u0004\u0018\u00010\u00002\u0006\u0010\t\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0014\u001a\u00020\u00132\u0016\b\u0002\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015H\u0007\u001a&\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0012\u0010\u0019\u001a\u00020\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002\u001a\u0010\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u0004H\u0002\u001a\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u0004H\u0002\u001aB\u0010\u001f\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00152\b\b\u0002\u0010\u001e\u001a\u00020\u00132\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0018\u0010$\u001a\u00020\u00062\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0002\u001aP\u0010*\u001a\u0014\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060(2\u0006\u0010&\u001a\u00020%2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001aB\u0010+\u001a\u0016\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0006\u0018\u00010(2\u0006\u0010'\u001a\u00020\u00132\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00152\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002\u001a\u0018\u0010,\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0018\u0010-\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0001\u001a\u00020\u0000H\u0002\u001a\u0010\u0010.\u001a\u00020\u00132\u0006\u0010&\u001a\u00020%H\u0002\u001a\u0016\u00100\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0004\u001a\u0016\u00101\u001a\u00020\u00062\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010/\u001a\u00020\u0004\u001a*\u00103\u001a\u00020\u000b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010#\u001a\u00020\"H\u0007\u001a\u000e\u00104\u001a\u00020\u000b2\u0006\u00102\u001a\u00020\u0004\"\u0014\u00108\u001a\u0002058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b6\u00107\"\u001e\u0010<\u001a\n\u0012\u0004\u0012\u00020 \u0018\u0001098\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b:\u0010;\u00a8\u0006="}, d2 = {"Landroid/content/Context;", "context", "Lcf1/b;", "toastEvent", "", "defaultErrorMsg", "", "E", "", "errorCode", "errorMsg", "Lcom/tencent/mobileqq/qqguildsdk/data/IGProSecurityResult;", "result", "Lcom/tencent/mobileqq/guild/util/security/i;", "dialogCallback", BdhLogUtil.LogTag.Tag_Conn, "defaultPrompt", "I", "toastDefaultMsg", "", "userToastError", "Lkotlin/Function1;", "onClickBtn", "L", "r", "p", "str", "o", "content", "O", "needRetryWhenFailed", "t", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "dialog", "", "actionCode", DomainData.DOMAIN_NAME, "Lcom/tencent/mobileqq/guild/util/security/c;", "detail", "showTwoButton", "Lkotlin/Function2;", "Landroid/content/DialogInterface;", "i", tl.h.F, "j", "k", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "url", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "strPrompt", "f", "e", "Lcom/google/gson/Gson;", "a", "Lcom/google/gson/Gson;", "gson", "Lmqq/util/WeakReference;", "b", "Lmqq/util/WeakReference;", "currentSecurityDialog", "qqguild-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SecurityTipHelperKt {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Gson f235628a = new Gson();

    /* renamed from: b, reason: collision with root package name */
    @Nullable
    private static WeakReference<QQCustomDialog> f235629b;

    @JvmOverloads
    public static final void A(@Nullable Context context, int i3, @Nullable String str, @Nullable IGProSecurityResult iGProSecurityResult) {
        F(context, i3, str, iGProSecurityResult, null, null, 48, null);
    }

    @JvmOverloads
    public static final void B(@Nullable Context context, int i3, @Nullable String str, @Nullable IGProSecurityResult iGProSecurityResult, @Nullable String str2) {
        F(context, i3, str, iGProSecurityResult, str2, null, 32, null);
    }

    @JvmOverloads
    public static final void C(@Nullable Context context, int i3, @Nullable String str, @Nullable IGProSecurityResult iGProSecurityResult, @Nullable String str2, @Nullable i iVar) {
        if (context == null) {
            return;
        }
        if (iGProSecurityResult != null && iGProSecurityResult.get$actionCode() != 0) {
            I(context, iGProSecurityResult, str, iVar);
        } else {
            b.c(context, i3, str, str2);
        }
    }

    @JvmOverloads
    public static final void D(@Nullable Context context, @NotNull cf1.b toastEvent) {
        Intrinsics.checkNotNullParameter(toastEvent, "toastEvent");
        G(context, toastEvent, null, 4, null);
    }

    @JvmOverloads
    public static final void E(@Nullable Context context, @NotNull cf1.b toastEvent, @Nullable String str) {
        Intrinsics.checkNotNullParameter(toastEvent, "toastEvent");
        F(context, toastEvent.f30775b, toastEvent.f30774a, toastEvent.f30776c, str, null, 32, null);
    }

    public static /* synthetic */ void F(Context context, int i3, String str, IGProSecurityResult iGProSecurityResult, String str2, i iVar, int i16, Object obj) {
        IGProSecurityResult iGProSecurityResult2;
        String str3;
        i iVar2;
        if ((i16 & 8) != 0) {
            iGProSecurityResult2 = null;
        } else {
            iGProSecurityResult2 = iGProSecurityResult;
        }
        if ((i16 & 16) != 0) {
            str3 = null;
        } else {
            str3 = str2;
        }
        if ((i16 & 32) != 0) {
            iVar2 = null;
        } else {
            iVar2 = iVar;
        }
        C(context, i3, str, iGProSecurityResult2, str3, iVar2);
    }

    public static /* synthetic */ void G(Context context, cf1.b bVar, String str, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        E(context, bVar, str);
    }

    @JvmOverloads
    public static final void H(@NotNull Context context, @NotNull IGProSecurityResult result, @Nullable String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        M(context, result, str, null, 8, null);
    }

    @JvmOverloads
    public static final void I(@NotNull Context context, @NotNull IGProSecurityResult result, @Nullable String str, @Nullable i iVar) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(result, "result");
        if (ch.a1(context, result, iVar) || r(context, result, iVar)) {
            return;
        }
        if (p(result)) {
            t(result, context, new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$showSecurityTip$1
                public final void invoke(int i3) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            }, true, iVar);
            return;
        }
        QQToast.makeText(context, 1, cb.d(result.getStrPrompt(), str, context.getResources().getString(R.string.f155591hx)), 1).show();
        if (iVar != null) {
            iVar.onDismiss();
        }
    }

    @Deprecated(message = "\u9519\u8bef\u6587\u6848\u9700\u8981\u7531\u540e\u53f0\u63d0\u4f9b\uff0c\u8fd9\u4e2a\u65b9\u6cd5\u4e0d\u518d\u9002\u7528", replaceWith = @ReplaceWith(expression = "showSecurityOrErrorTip", imports = {}))
    @JvmOverloads
    public static final boolean J(@Nullable IGProSecurityResult iGProSecurityResult, @Nullable Context context, int i3, @Nullable String str) {
        return N(iGProSecurityResult, context, i3, str, false, null, 48, null);
    }

    @Deprecated(message = "\u9519\u8bef\u6587\u6848\u9700\u8981\u7531\u540e\u53f0\u63d0\u4f9b\uff0c\u8fd9\u4e2a\u65b9\u6cd5\u4e0d\u518d\u9002\u7528", replaceWith = @ReplaceWith(expression = "showSecurityOrErrorTip", imports = {}))
    @JvmOverloads
    public static final boolean K(@Nullable IGProSecurityResult iGProSecurityResult, @Nullable Context context, int i3, @Nullable String str, boolean z16) {
        return N(iGProSecurityResult, context, i3, str, z16, null, 32, null);
    }

    @Deprecated(message = "\u9519\u8bef\u6587\u6848\u9700\u8981\u7531\u540e\u53f0\u63d0\u4f9b\uff0c\u8fd9\u4e2a\u65b9\u6cd5\u4e0d\u518d\u9002\u7528", replaceWith = @ReplaceWith(expression = "showSecurityOrErrorTip", imports = {}))
    @JvmOverloads
    public static final boolean L(@Nullable IGProSecurityResult iGProSecurityResult, @Nullable Context context, int i3, @Nullable String str, boolean z16, @Nullable Function1<? super Integer, Unit> function1) {
        boolean z17;
        if (context != null && function1 != null) {
            if (s(context, iGProSecurityResult, null, 4, null)) {
                return true;
            }
            if (iGProSecurityResult != null && p(iGProSecurityResult)) {
                QLog.i("SecurityTipHelper", 1, "showSecurityDialog | actionCode: " + iGProSecurityResult.get$actionCode() + " - strPrompt: " + iGProSecurityResult.getStrPrompt() + " - strDetail: " + iGProSecurityResult.getStrDetail());
                u(iGProSecurityResult, context, function1, true, null, 16, null);
                return true;
            }
            QLog.i("SecurityTipHelper", 1, "showToast | errorCode: " + i3 + " - userToastError: " + z16 + " - toastDefaultMsg: " + str);
            if (z16) {
                ch.t1(context, i3, str, iGProSecurityResult);
            } else if (!TextUtils.isEmpty(str)) {
                Intrinsics.checkNotNull(str);
                O(str);
            }
            return false;
        }
        if (context == null) {
            z17 = true;
        } else {
            z17 = false;
        }
        QLog.e("SecurityTipHelper", 1, "context null? " + z17 + " -- result: " + iGProSecurityResult);
        return false;
    }

    public static /* synthetic */ void M(Context context, IGProSecurityResult iGProSecurityResult, String str, i iVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            str = null;
        }
        if ((i3 & 8) != 0) {
            iVar = null;
        }
        I(context, iGProSecurityResult, str, iVar);
    }

    public static /* synthetic */ boolean N(IGProSecurityResult iGProSecurityResult, Context context, int i3, String str, boolean z16, Function1 function1, int i16, Object obj) {
        if ((i16 & 16) != 0) {
            z16 = true;
        }
        boolean z17 = z16;
        if ((i16 & 32) != 0) {
            function1 = new Function1<Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$showSecurityTip$2
                public final void invoke(int i17) {
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                    invoke(num.intValue());
                    return Unit.INSTANCE;
                }
            };
        }
        return L(iGProSecurityResult, context, i3, str, z17, function1);
    }

    private static final void O(String str) {
        QQToast.makeText(BaseApplication.getContext(), str, 0).show();
    }

    @NotNull
    public static final IGProSecurityResult e(@NotNull String strPrompt) {
        Intrinsics.checkNotNullParameter(strPrompt, "strPrompt");
        return g(strPrompt, "{}", 0L, 4, null);
    }

    @JvmOverloads
    @NotNull
    public static final IGProSecurityResult f(@Nullable final String str, @Nullable final String str2, final long j3) {
        return new IGProSecurityResult() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$createSecurityResult$1
            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
            /* renamed from: getActionCode, reason: from getter */
            public long get$actionCode() {
                return j3;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
            @NotNull
            public String getStrDetail() {
                String str3 = str2;
                if (str3 == null) {
                    return "";
                }
                return str3;
            }

            @Override // com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult
            @NotNull
            public String getStrPrompt() {
                String str3 = str;
                if (str3 == null) {
                    return "";
                }
                return str3;
            }
        };
    }

    public static /* synthetic */ IGProSecurityResult g(String str, String str2, long j3, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = "";
        }
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        if ((i3 & 4) != 0) {
            j3 = Long.MIN_VALUE;
        }
        return f(str, str2, j3);
    }

    private static final Function2<DialogInterface, Integer, Unit> h(boolean z16, final Function1<? super Integer, Unit> function1, final i iVar) {
        if (z16) {
            return new Function2<DialogInterface, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$getCancelHandler$1
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

                public final void invoke(@NotNull DialogInterface dialogInterface, int i3) {
                    Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
                    function1.invoke(Integer.valueOf(i3));
                    i iVar2 = iVar;
                    if (iVar2 != null) {
                        iVar2.onClick();
                    }
                }
            };
        }
        return null;
    }

    private static final Function2<DialogInterface, Integer, Unit> i(final c cVar, final Context context, boolean z16, final Function1<? super Integer, Unit> function1, final i iVar) {
        if (!z16) {
            return new Function2<DialogInterface, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$getConfirmHandler$1
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

                public final void invoke(@NotNull DialogInterface dialogInterface, int i3) {
                    Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
                    function1.invoke(Integer.valueOf(i3));
                }
            };
        }
        if (cVar.b() == 1) {
            return new Function2<DialogInterface, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$getConfirmHandler$2
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

                public final void invoke(@NotNull DialogInterface dialogInterface, int i3) {
                    Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
                    Context context2 = context;
                    String a16 = cVar.a();
                    Intrinsics.checkNotNullExpressionValue(a16, "detail.url");
                    SecurityTipHelperKt.l(context2, a16);
                    function1.invoke(Integer.valueOf(i3));
                    i iVar2 = iVar;
                    if (iVar2 != null) {
                        iVar2.onClick();
                    }
                }
            };
        }
        if (cVar.b() == 2) {
            return new Function2<DialogInterface, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$getConfirmHandler$3
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

                public final void invoke(@NotNull DialogInterface dialogInterface, int i3) {
                    Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
                    Context context2 = context;
                    String a16 = cVar.a();
                    Intrinsics.checkNotNullExpressionValue(a16, "detail.url");
                    SecurityTipHelperKt.m(context2, a16);
                    function1.invoke(Integer.valueOf(i3));
                    i iVar2 = iVar;
                    if (iVar2 != null) {
                        iVar2.onClick();
                    }
                }
            };
        }
        return new Function2<DialogInterface, Integer, Unit>() { // from class: com.tencent.mobileqq.guild.util.security.SecurityTipHelperKt$getConfirmHandler$4
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

            public final void invoke(@NotNull DialogInterface dialogInterface, int i3) {
                Intrinsics.checkNotNullParameter(dialogInterface, "<anonymous parameter 0>");
                function1.invoke(Integer.valueOf(i3));
                i iVar2 = iVar;
                if (iVar2 != null) {
                    iVar2.onClick();
                }
            }
        };
    }

    private static final String j(boolean z16, Context context) {
        if (z16) {
            String string = context.getString(R.string.f140850f3);
            Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.string.guild_cancel)");
            return string;
        }
        return "";
    }

    private static final String k(boolean z16, Context context) {
        if (z16) {
            String string = context.getString(R.string.f155601hy);
            Intrinsics.checkNotNullExpressionValue(string, "{\n        context.getStr\u2026_tips_go_to_handle)\n    }");
            return string;
        }
        String string2 = context.getString(R.string.f146610un);
        Intrinsics.checkNotNullExpressionValue(string2, "{\n        context.getStr\u2026tring.guild_i_know)\n    }");
        return string2;
    }

    public static final void l(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_BROWSER);
        activityURIRequest.extra().putString("url", url);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    public static final void m(@NotNull Context context, @NotNull String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(context, url, 5002, null);
    }

    private static final void n(QQCustomDialog qQCustomDialog, long j3) {
        VideoReport.setPageId(qQCustomDialog.getRootView(), "pg_sgrp_blacklist_pop");
        VideoReport.setElementId(qQCustomDialog.getBtnLeft(), "em_aio_channel_setting");
        VideoReport.setElementId(qQCustomDialog.getBtnight(), "em_sgrp_blacklist_pop_handle");
        TextView btnLeft = qQCustomDialog.getBtnLeft();
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_ALL;
        VideoReport.setElementExposePolicy(btnLeft, exposurePolicy);
        TextView btnLeft2 = qQCustomDialog.getBtnLeft();
        ClickPolicy clickPolicy = ClickPolicy.REPORT_ALL;
        VideoReport.setElementClickPolicy(btnLeft2, clickPolicy);
        VideoReport.setElementExposePolicy(qQCustomDialog.getBtnight(), exposurePolicy);
        VideoReport.setElementClickPolicy(qQCustomDialog.getBtnight(), clickPolicy);
        HashMap hashMap = new HashMap();
        hashMap.put("sgrp_blacklist_errorcode", Long.valueOf(j3));
        VideoReport.setPageParams(qQCustomDialog.getRootView(), new PageParams(hashMap));
    }

    private static final boolean o(String str) {
        boolean z16;
        if (str.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        try {
            f235628a.fromJson(str, c.class);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    private static final boolean p(IGProSecurityResult iGProSecurityResult) {
        if (iGProSecurityResult != null) {
            String strDetail = iGProSecurityResult.getStrDetail();
            Intrinsics.checkNotNullExpressionValue(strDetail, "result.strDetail");
            if (o(strDetail)) {
                return true;
            }
        }
        return false;
    }

    private static final boolean q(c cVar) {
        if (!Intrinsics.areEqual(cVar.a(), "") && cVar.b() != Integer.MIN_VALUE) {
            return true;
        }
        return false;
    }

    private static final boolean r(Context context, IGProSecurityResult iGProSecurityResult, i iVar) {
        if (context instanceof Activity) {
            Activity activity = (Activity) context;
            if (!activity.isFinishing()) {
                return ch.b1(activity, iGProSecurityResult, iVar);
            }
        }
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return ch.b1(qBaseActivity, iGProSecurityResult, iVar);
        }
        return false;
    }

    static /* synthetic */ boolean s(Context context, IGProSecurityResult iGProSecurityResult, i iVar, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            iVar = null;
        }
        return r(context, iGProSecurityResult, iVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r0.isFinishing() == false) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final void t(final IGProSecurityResult iGProSecurityResult, final Context context, final Function1<? super Integer, Unit> function1, boolean z16, final i iVar) {
        Activity currentTopActivity;
        DialogInterface.OnClickListener onClickListener;
        QQCustomDialog qQCustomDialog;
        if (context instanceof Activity) {
            currentTopActivity = (Activity) context;
            if (!currentTopActivity.isDestroyed()) {
            }
        }
        currentTopActivity = ((IGuildTempApi) QRoute.api(IGuildTempApi.class)).getCurrentTopActivity();
        Activity activity = currentTopActivity;
        if (activity != null && !activity.isDestroyed() && !activity.isFinishing()) {
            c cVar = (c) f235628a.fromJson(iGProSecurityResult.getStrDetail(), c.class);
            if (iGProSecurityResult.getStrPrompt() != null && cVar != null) {
                WeakReference<QQCustomDialog> weakReference = f235629b;
                if (weakReference != null && (qQCustomDialog = weakReference.get()) != null && qQCustomDialog.isShowing()) {
                    QLog.w("SecurityTipHelper", 1, "[showSecurityDialog] current dialog is showing,dismiss it");
                    qQCustomDialog.dismiss();
                }
                boolean q16 = q(cVar);
                String strPrompt = iGProSecurityResult.getStrPrompt();
                String j3 = j(q16, activity);
                String k3 = k(q16, activity);
                final Function2<DialogInterface, Integer, Unit> i3 = i(cVar, activity, q16, function1, iVar);
                DialogInterface.OnClickListener onClickListener2 = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.security.k
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i16) {
                        SecurityTipHelperKt.w(Function2.this, dialogInterface, i16);
                    }
                };
                final Function2<DialogInterface, Integer, Unit> h16 = h(q16, function1, iVar);
                if (h16 != null) {
                    onClickListener = new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.guild.util.security.l
                        @Override // android.content.DialogInterface.OnClickListener
                        public final void onClick(DialogInterface dialogInterface, int i16) {
                            SecurityTipHelperKt.x(Function2.this, dialogInterface, i16);
                        }
                    };
                } else {
                    onClickListener = null;
                }
                QQCustomDialog dialog = DialogUtil.createCustomDialog(activity, 230, (String) null, strPrompt, j3, k3, onClickListener2, onClickListener, new DialogInterface.OnDismissListener() { // from class: com.tencent.mobileqq.guild.util.security.m
                    @Override // android.content.DialogInterface.OnDismissListener
                    public final void onDismiss(DialogInterface dialogInterface) {
                        SecurityTipHelperKt.y(i.this, dialogInterface);
                    }
                });
                Intrinsics.checkNotNullExpressionValue(dialog, "dialog");
                n(dialog, iGProSecurityResult.get$actionCode());
                dialog.show();
                f235629b = new WeakReference<>(dialog);
                return;
            }
            return;
        }
        if (z16) {
            QLog.w("SecurityTipHelper", 1, "[showSecurityDialog] activity is finishing. retry again in 500 ms");
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: com.tencent.mobileqq.guild.util.security.j
                @Override // java.lang.Runnable
                public final void run() {
                    SecurityTipHelperKt.v(IGProSecurityResult.this, context, function1, iVar);
                }
            }, 500L);
            return;
        }
        QLog.e("SecurityTipHelper", 1, "[showSecurityDialog] failed. activity if finishing");
    }

    static /* synthetic */ void u(IGProSecurityResult iGProSecurityResult, Context context, Function1 function1, boolean z16, i iVar, int i3, Object obj) {
        if ((i3 & 8) != 0) {
            z16 = false;
        }
        if ((i3 & 16) != 0) {
            iVar = null;
        }
        t(iGProSecurityResult, context, function1, z16, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void v(IGProSecurityResult result, Context context, Function1 onClickBtn, i iVar) {
        Intrinsics.checkNotNullParameter(result, "$result");
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(onClickBtn, "$onClickBtn");
        t(result, context, onClickBtn, false, iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(Function2 tmp0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(dialogInterface, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(Function2 function2, DialogInterface dialogInterface, int i3) {
        function2.invoke(dialogInterface, Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(i iVar, DialogInterface dialogInterface) {
        if (iVar != null) {
            iVar.onDismiss();
        }
    }

    @JvmOverloads
    public static final void z(@Nullable Context context, int i3, @Nullable String str) {
        F(context, i3, str, null, null, null, 56, null);
    }
}
