package com.tencent.mobileqq.weather.chat;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountCommonMrg;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0096\u0002\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/weather/chat/c;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "", "extString", "b", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "<init>", "()V", "a", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class c implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/weather/chat/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-weather-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.weather.chat.c$a, reason: from kotlin metadata */
    /* loaded from: classes20.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(19785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final String b(String extString) {
        List<String> split$default;
        boolean startsWith$default;
        List split$default2;
        if (TextUtils.isEmpty(extString)) {
            return "";
        }
        try {
            String triggleStr = new JSONObject(extString).optString("oac_triggle");
            Intrinsics.checkNotNullExpressionValue(triggleStr, "triggleStr");
            split$default = StringsKt__StringsKt.split$default((CharSequence) triggleStr, new String[]{ContainerUtils.FIELD_DELIMITER}, false, 0, 6, (Object) null);
            for (String str : split$default) {
                startsWith$default = StringsKt__StringsJVMKt.startsWith$default(str, "ad_id", false, 2, null);
                if (startsWith$default) {
                    split$default2 = StringsKt__StringsKt.split$default((CharSequence) str, new String[]{ContainerUtils.KEY_VALUE_DELIMITER}, false, 0, 6, (Object) null);
                    return (String) split$default2.get(1);
                }
            }
        } catch (Exception e16) {
            QLog.e("WeatherAccountItemClickUseCase", 1, "getAdIdFromMsgExtString error..." + e16);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(c this$0, Context context, int i3, String str, ArrayList msgList) {
        String str2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(msgList, "msgList");
        if (!msgList.isEmpty()) {
            IPublicAccountMsgExtMrg iPublicAccountMsgExtMrg = (IPublicAccountMsgExtMrg) QRoute.api(IPublicAccountMsgExtMrg.class);
            Object obj = msgList.get(0);
            Intrinsics.checkNotNullExpressionValue(obj, "msgList[0]");
            str2 = this$0.b(iPublicAccountMsgExtMrg.getBytesOacMsgExtend((MsgRecord) obj));
        } else {
            str2 = "";
        }
        Intrinsics.checkNotNullExpressionValue(context, "context");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
        com.tencent.mobileqq.weather.webpage.f.l(context, (AppInterface) peekAppRuntime, str2);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof g)) {
            return false;
        }
        g gVar = (g) b16;
        if (gVar.n() != 103 || !com.tencent.mobileqq.weather.util.b.i(String.valueOf(gVar.l()))) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z16 = false;
        if (!(params.b() instanceof g)) {
            return false;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
        g gVar = (g) b16;
        if ((gVar.x().c() == 1 || gVar.x().c() == 3) && gVar.x().b() > 0) {
            z16 = true;
        }
        final Context context = params.c().getContext();
        f.f313270a.i(z16);
        ((IPublicAccountCommonMrg) QRoute.api(IPublicAccountCommonMrg.class)).asyncGetLastMsgRecord(gVar.s(), new IMsgOperateCallback() { // from class: com.tencent.mobileqq.weather.chat.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IMsgOperateCallback
            public final void onResult(int i3, String str, ArrayList arrayList) {
                c.c(c.this, context, i3, str, arrayList);
            }
        });
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean needUnifiedAnim(@NotNull b.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) aVar)).booleanValue();
        }
        return b.C9598b.a(this, aVar);
    }
}
