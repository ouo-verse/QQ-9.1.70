package com.tencent.mobileqq.troop.homework.logic;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopCardApi;
import com.tencent.mobileqq.troop.homework.api.IHWTroopUtilsApi;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00072\u00020\u0001:\u0001\u000fBZ\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0005\u0012\u0006\u0010\u0016\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00020\u001d\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0006\u0010\b\u001a\u00020\u0002J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0005J\u0016\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0011\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0016\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0013R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u0019R/\u0010\"\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u001e\u0012\b\b\u001f\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/mobileqq/troop/homework/logic/ModifyHWTroopIdentityHelper;", "", "", "i", "f", "", "data", h.F, "g", "source", "j", "", "addRecommendAction", "k", "Landroid/content/Context;", "a", "Landroid/content/Context;", "context", "b", "Ljava/lang/String;", "joinTroopUin", "c", "from", "Ljava/lang/Runnable;", "d", "Ljava/lang/Runnable;", "startRecommendPageAction", "e", "onBackAction", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "homeWordIntro", "Lkotlin/jvm/functions/Function1;", "onModifyHWNameBack", "Landroid/content/BroadcastReceiver;", "Landroid/content/BroadcastReceiver;", "homeworkTroopReceiver", "<init>", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Runnable;Ljava/lang/Runnable;Lkotlin/jvm/functions/Function1;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class ModifyHWTroopIdentityHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String joinTroopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String from;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Runnable startRecommendPageAction;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Runnable onBackAction;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Function1<String, Unit> onModifyHWNameBack;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private BroadcastReceiver homeworkTroopReceiver;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/logic/ModifyHWTroopIdentityHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.logic.ModifyHWTroopIdentityHelper$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52227);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public ModifyHWTroopIdentityHelper(@NotNull Context context, @NotNull String joinTroopUin, @NotNull String from, @Nullable Runnable runnable, @Nullable Runnable runnable2, @NotNull Function1<? super String, Unit> onModifyHWNameBack) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(joinTroopUin, "joinTroopUin");
        Intrinsics.checkNotNullParameter(from, "from");
        Intrinsics.checkNotNullParameter(onModifyHWNameBack, "onModifyHWNameBack");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, joinTroopUin, from, runnable, runnable2, onModifyHWNameBack);
            return;
        }
        this.context = context;
        this.joinTroopUin = joinTroopUin;
        this.from = from;
        this.startRecommendPageAction = runnable;
        this.onBackAction = runnable2;
        this.onModifyHWNameBack = onModifyHWNameBack;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f() {
        Intent intent = new Intent("com.tencent.mobileqq.action.closewebview");
        intent.putExtra("event", "closeWebView");
        BaseApplication.getContext().sendBroadcast(intent, "com.tencent.msg.permission.pushnotify");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(String data) {
        String str;
        try {
            JSONObject jSONObject = new JSONObject(data);
            String optString = jSONObject.optString("groupCode");
            if (!Intrinsics.areEqual(optString, this.joinTroopUin)) {
                QLog.i("ModifyHWTroopIdentityHelper", 1, "[handleIdentityChange] not cur join, troopUin:" + optString + ", curTroopUin:" + this.joinTroopUin);
                return;
            }
            String optString2 = jSONObject.optString("source");
            String content = jSONObject.optString("content");
            QLog.d("ModifyHWTroopIdentityHelper", 1, "[handleIdentityChange] from:" + this.from + ", troopUin:" + this.joinTroopUin + " source:" + optString2 + ", content:" + content);
            if (Intrinsics.areEqual(IHWTroopUtilsApi.HOMEWORK_TROOP_JOIN_SOURCE, optString2)) {
                Function1<String, Unit> function1 = this.onModifyHWNameBack;
                Intrinsics.checkNotNullExpressionValue(content, "content");
                function1.invoke(content);
            } else if (Intrinsics.areEqual(optString2, IHWTroopUtilsApi.HOMEWORK_AIO_TIPS_SOURCE)) {
                String optString3 = jSONObject.optString("uin");
                AppInterface e16 = bg.e();
                if (e16 != null) {
                    str = e16.getCurrentAccountUin();
                } else {
                    str = null;
                }
                if (Intrinsics.areEqual(optString3, str)) {
                    Function1<String, Unit> function12 = this.onModifyHWNameBack;
                    Intrinsics.checkNotNullExpressionValue(content, "content");
                    function12.invoke(content);
                }
            }
        } catch (JSONException e17) {
            QLog.i("ModifyHWTroopIdentityHelper", 1, "[handleIdentityChange] catch exception:" + e17 + ".message");
        }
    }

    private final void i() {
        if (this.homeworkTroopReceiver == null) {
            this.homeworkTroopReceiver = new BroadcastReceiver() { // from class: com.tencent.mobileqq.troop.homework.logic.ModifyHWTroopIdentityHelper$initHWTroopReceiver$1
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ModifyHWTroopIdentityHelper.this);
                    }
                }

                /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
                
                    r6 = r5.f297147a.startRecommendPageAction;
                 */
                @Override // android.content.BroadcastReceiver
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onReceive(@NotNull Context context, @NotNull Intent intent) {
                    String str;
                    boolean z16;
                    Runnable runnable;
                    Runnable runnable2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) intent);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(context, "context");
                    Intrinsics.checkNotNullParameter(intent, "intent");
                    QLog.i("ModifyHWTroopIdentityHelper", 1, "[initHWTroopReceiver] action:" + intent.getAction());
                    String action = intent.getAction();
                    if (action != null) {
                        int hashCode = action.hashCode();
                        if (hashCode != -1872323934) {
                            if (hashCode == 1231272644 && action.equals("start_recomend_page") && runnable2 != null) {
                                runnable2.run();
                                return;
                            }
                            return;
                        }
                        if (action.equals("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT")) {
                            String stringExtra = intent.getStringExtra("data");
                            String stringExtra2 = intent.getStringExtra("event");
                            str = ModifyHWTroopIdentityHelper.this.from;
                            QLog.i("ModifyHWTroopIdentityHelper", 1, "[initHWTroopReceiver] data:" + stringExtra + ", event:" + stringExtra2 + ", from:" + str);
                            if (Intrinsics.areEqual(stringExtra2, IHWTroopUtilsApi.HW_TROOP_BACK_EVENT)) {
                                runnable = ModifyHWTroopIdentityHelper.this.onBackAction;
                                if (runnable != null) {
                                    runnable.run();
                                    return;
                                }
                                return;
                            }
                            if (Intrinsics.areEqual(IHWTroopUtilsApi.HW_TROOP_IDENTITY_CHANGED_EVENT, stringExtra2)) {
                                if (stringExtra != null && stringExtra.length() != 0) {
                                    z16 = false;
                                } else {
                                    z16 = true;
                                }
                                if (!z16) {
                                    ModifyHWTroopIdentityHelper.this.f();
                                    ModifyHWTroopIdentityHelper.this.h(stringExtra);
                                    return;
                                }
                            }
                            QLog.i("ModifyHWTroopIdentityHelper", 1, "[initHWTroopReceiver] skip event:" + stringExtra2);
                        }
                    }
                }
            };
        }
    }

    public final void g() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        String str = this.from;
        if (this.homeworkTroopReceiver != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("ModifyHWTroopIdentityHelper", 1, "[destroy] from:" + str + ", hasRegister:" + z16);
        BroadcastReceiver broadcastReceiver = this.homeworkTroopReceiver;
        if (broadcastReceiver != null) {
            this.context.unregisterReceiver(broadcastReceiver);
            this.homeworkTroopReceiver = null;
        }
    }

    public final void j(@NotNull String source) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) source);
        } else {
            Intrinsics.checkNotNullParameter(source, "source");
            k(source, true);
        }
    }

    public final void k(@NotNull String source, boolean addRecommendAction) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, source, Boolean.valueOf(addRecommendAction));
            return;
        }
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("ModifyHWTroopIdentityHelper", 1, "[jumpToModifyIdentity] troopUin:" + this.joinTroopUin + ", source:" + source + ", from:" + this.from);
        String str = null;
        if (this.homeworkTroopReceiver == null) {
            i();
            IntentFilter intentFilter = new IntentFilter();
            if (addRecommendAction) {
                intentFilter.addAction("start_recomend_page");
            }
            intentFilter.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
            this.context.registerReceiver(this.homeworkTroopReceiver, intentFilter, "com.tencent.msg.permission.pushnotify", null);
        }
        ITroopCardApi iTroopCardApi = (ITroopCardApi) QRoute.api(ITroopCardApi.class);
        Context context = this.context;
        AppInterface e16 = bg.e();
        if (e16 != null) {
            str = e16.getCurrentAccountUin();
        }
        iTroopCardApi.startModifyHomeworkTroopNickname(context, str, this.joinTroopUin, source);
    }
}
