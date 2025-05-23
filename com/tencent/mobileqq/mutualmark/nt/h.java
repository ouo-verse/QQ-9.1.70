package com.tencent.mobileqq.mutualmark.nt;

import android.content.Context;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.data.converter.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016R\u001a\u0010\u0011\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/mutualmark/nt/h;", "Lcom/tencent/qqnt/chats/data/converter/g;", "Lcom/tencent/qqnt/chats/data/converter/f;", "payload", "", "matchPayload", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "Lcom/tencent/qqnt/chats/data/converter/c;", "params", "", "update", "", "a", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "logTag", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class h extends com.tencent.qqnt.chats.data.converter.g {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String logTag;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.logTag = "MutualMarkProcessor";
        }
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public boolean matchPayload(@NotNull com.tencent.qqnt.chats.data.converter.f payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) payload)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(payload, "payload");
        return payload instanceof k;
    }

    @Override // com.tencent.qqnt.chats.data.converter.g
    public void update(@NotNull com.tencent.qqnt.chats.core.adapter.itemdata.g item, @NotNull com.tencent.qqnt.chats.data.converter.c params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) item, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(params, "params");
        if (item.n() != 1) {
            return;
        }
        if (item.q().getBoolean("is_local_cache_data", false)) {
            QLog.d(this.logTag, 2, item.w().e() + " process local data");
            return;
        }
        f fVar = f.f252196a;
        if (fVar.d(String.valueOf(item.l()))) {
            return;
        }
        try {
            Context context = MobileQQ.sMobileQQ.getBaseContext();
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            Intrinsics.checkNotNull(peekAppRuntime, "null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
            QQAppInterface qQAppInterface = (QQAppInterface) peekAppRuntime;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            fVar.g(context, qQAppInterface, String.valueOf(item.l()), 5, null);
            fVar.e(qQAppInterface);
            if (QLog.isDebugVersion()) {
                QLog.d(this.logTag, 4, "update, chat_uin=" + item.l() + ", chat_msg=" + ((Object) item.v().f()));
            }
        } catch (ClassCastException e16) {
            QLog.e(this.logTag, 1, e16, new Object[0]);
        }
    }
}
