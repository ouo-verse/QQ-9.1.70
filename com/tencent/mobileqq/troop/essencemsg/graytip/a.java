package com.tencent.mobileqq.troop.essencemsg.graytip;

import android.content.Context;
import com.tencent.mobileqq.aio.event.MsgNavigationEvent;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.parser.JumpParserResult;
import com.tencent.mobileqq.app.parser.ax;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mvi.base.route.j;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.graytips.action.f;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0004H\u0016J*\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/troop/essencemsg/graytip/a;", "Lcom/tencent/qqnt/graytips/handler/b;", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/f;", "a", "actionInfo", "b", "Lmqq/app/AppRuntime;", "app", "Landroid/content/Context;", "context", "Lgv3/a;", "aioAbility", "", "c", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a implements com.tencent.qqnt.graytips.handler.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: b, reason: collision with root package name */
    @NotNull
    private static final String f295321b;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0016\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00028\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\t\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/troop/essencemsg/graytip/a$a;", "", "", "url", "Lgv3/a;", "aioAbility", "", "a", "KEY_SEQ", "Ljava/lang/String;", "NAV_MSG_SCHEME", "TAG", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.essencemsg.graytip.a$a, reason: collision with other inner class name and from kotlin metadata */
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

        /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
        
            r0 = kotlin.text.StringsKt__StringNumberConversionsKt.toLongOrNull(r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final boolean a(@NotNull String url, @NotNull gv3.a aioAbility) {
            boolean startsWith$default;
            HashMap<String, String> paramMap;
            Long longOrNull;
            j e16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) url, (Object) aioAbility)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(aioAbility, "aioAbility");
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, a.f295321b, false, 2, null);
            if (startsWith$default) {
                if (QLog.isColorLevel()) {
                    QLog.d("EssGrayTipActionHandler", 2, "tryParserScheme: url=" + url);
                }
                JumpParserResult e17 = ax.e(url);
                if (e17 != null && (paramMap = e17.getParamMap()) != null && (r0 = paramMap.get("msgSeq")) != null && longOrNull != null) {
                    long longValue = longOrNull.longValue();
                    com.tencent.aio.api.runtime.a a16 = aioAbility.a();
                    if (a16 != null && (e16 = a16.e()) != null) {
                        e16.h(new MsgNavigationEvent.NavigateBySeqEvent("other", longValue, 0L, false, null, false, false, null, 252, null));
                        return true;
                    }
                    return true;
                }
            }
            return false;
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(62021);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
            f295321b = "mqqapi://NTGroup/essence";
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public f a(@NotNull JSONObject jsonObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f) iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonObject);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        return new e(jsonObject.optLong("seq"));
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    @NotNull
    public JSONObject b(@NotNull f actionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (JSONObject) iPatchRedirector.redirect((short) 3, (Object) this, (Object) actionInfo);
        }
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("seq", ((e) actionInfo).a());
        return jSONObject;
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(@NotNull AppRuntime app, @NotNull Context context, @NotNull f actionInfo, @Nullable gv3.a aioAbility) {
        long j3;
        com.tencent.aio.api.runtime.a a16;
        j e16;
        AIOMsgItem b16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, app, context, actionInfo, aioAbility);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        e eVar = (e) actionInfo;
        QLog.i("EssGrayTipActionHandler", 1, "handle on click! seq is " + eVar.a());
        if (aioAbility != null && (b16 = aioAbility.b()) != null) {
            j3 = b16.getMsgId();
        } else {
            j3 = 0;
        }
        String valueOf = String.valueOf(j3);
        if (aioAbility != null && (a16 = aioAbility.a()) != null && (e16 = a16.e()) != null) {
            e16.h(new MsgNavigationEvent.NavigateBySeqEvent("gray_tips" + valueOf, eVar.a(), 0L, false, null, false, false, null, 252, null));
        }
    }
}
