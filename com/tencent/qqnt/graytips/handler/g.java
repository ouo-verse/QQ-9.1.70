package com.tencent.qqnt.graytips.handler;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.aio.data.AIOContact;
import com.tencent.aio.data.AIOParam;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IContactApi;
import com.tencent.qqnt.graytips.action.p;
import com.tencent.qqnt.kernel.api.IUixConvertAdapterApi;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ0\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0002J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J(\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J*\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/graytips/handler/g;", "Lcom/tencent/qqnt/graytips/handler/a;", "Landroid/content/Context;", "context", "", "uin", "", "uid", "nick", "Lcom/tencent/aio/api/runtime/a;", "aioContext", "", "f", "Lorg/json/JSONObject;", "jsonObject", "Lcom/tencent/qqnt/graytips/action/a;", "actionInfo", "e", "Lcom/tencent/qqnt/graytips/action/f;", "d", "Lmqq/app/AppRuntime;", "app", "Lgv3/a;", "aioAbility", "c", "<init>", "()V", "b", "a", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class g extends a {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/graytips/handler/g$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "graytips_kit_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.graytips.handler.g$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(30866);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f(Context context, long uin, String uid, String nick, com.tencent.aio.api.runtime.a aioContext) {
        long a16;
        long j3;
        Long longOrNull;
        if (uin == 0) {
            QLog.d("OpenFriendProfileActionHandler", 1, "openProfile uin=0");
            return;
        }
        AIOContact c16 = aioContext.g().r().c();
        int e16 = c16.e();
        String j16 = c16.j();
        ArrayList arrayList = new ArrayList();
        String g16 = c16.g();
        if (c16.e() == 2) {
            longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(c16.j());
            if (longOrNull != null) {
                a16 = longOrNull.longValue();
            } else {
                j3 = 0;
                ((IContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IContactApi.class)).openProfileCard(context, new AIOMsgItem(new MsgRecord(0L, 0L, 0L, 0L, e16, 5, 0, 3, uid, j16, "", "", 0L, 0L, 0L, 0L, null, 0, "", "", nick, "", "", arrayList, null, null, 0L, 0, null, g16, null, false, null, null, "", 0L, 0L, null, false, 0, 0, null, null, null, 0L, false, null, 0L, 0, null, null, uin, j3, null, null, 0, 0, null, null, 0, null)));
            }
        } else {
            AIOParam g17 = aioContext.g();
            Intrinsics.checkNotNullExpressionValue(g17, "aioContext.aioParam");
            a16 = su3.c.a(g17);
        }
        j3 = a16;
        ((IContactApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IContactApi.class)).openProfileCard(context, new AIOMsgItem(new MsgRecord(0L, 0L, 0L, 0L, e16, 5, 0, 3, uid, j16, "", "", 0L, 0L, 0L, 0L, null, 0, "", "", nick, "", "", arrayList, null, null, 0L, 0, null, g16, null, false, null, null, "", 0L, 0L, null, false, 0, 0, null, null, null, 0L, false, null, 0L, 0, null, null, uin, j3, null, null, 0, 0, null, null, 0, null)));
    }

    @Override // com.tencent.qqnt.graytips.handler.b
    public void c(@NotNull AppRuntime app, @NotNull Context context, @NotNull com.tencent.qqnt.graytips.action.f actionInfo, @Nullable gv3.a aioAbility) {
        com.tencent.aio.api.runtime.a a16;
        Long longOrNull;
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, app, context, actionInfo, aioAbility);
            return;
        }
        Intrinsics.checkNotNullParameter(app, "app");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        p pVar = (p) actionInfo;
        if (aioAbility != null && (a16 = aioAbility.a()) != null) {
            if (!TextUtils.isEmpty(pVar.c())) {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(pVar.c());
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                } else {
                    j3 = 0;
                }
                f(context, j3, pVar.b(), pVar.a(), a16);
                return;
            }
            if (!TextUtils.isEmpty(pVar.b())) {
                try {
                    long uinFromUid = ((IUixConvertAdapterApi) QRoute.api(IUixConvertAdapterApi.class)).getUinFromUid(((p) actionInfo).b());
                    if (uinFromUid != 0) {
                        f(context, uinFromUid, pVar.b(), pVar.a(), a16);
                    } else {
                        QLog.d("OpenFriendProfileActionHandler", 1, "uin is 0");
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // com.tencent.qqnt.graytips.handler.a
    @NotNull
    public com.tencent.qqnt.graytips.action.f d(@NotNull JSONObject jsonObject, @NotNull String uid, @NotNull String nick, @NotNull String uin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.graytips.action.f) iPatchRedirector.redirect((short) 3, this, jsonObject, uid, nick, uin);
        }
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Intrinsics.checkNotNullParameter(uid, "uid");
        Intrinsics.checkNotNullParameter(nick, "nick");
        Intrinsics.checkNotNullParameter(uin, "uin");
        return new p(uid, nick, uin);
    }

    @Override // com.tencent.qqnt.graytips.handler.a
    public void e(@NotNull JSONObject jsonObject, @NotNull com.tencent.qqnt.graytips.action.a actionInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) jsonObject, (Object) actionInfo);
        } else {
            Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
            Intrinsics.checkNotNullParameter(actionInfo, "actionInfo");
        }
    }
}
