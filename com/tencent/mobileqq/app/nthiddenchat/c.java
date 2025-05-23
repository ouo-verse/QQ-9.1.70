package com.tencent.mobileqq.app.nthiddenchat;

import android.content.Context;
import com.tencent.mobileqq.app.RouterConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.o;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.usecase.click.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J(\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0011\u0010\u000f\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u000bH\u0096\u0002R\u0014\u0010\u0011\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0010R\u0014\u0010\u0013\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0010\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/app/nthiddenchat/c;", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b;", "Landroid/content/Context;", "context", "", "groupId", "title", "", "chatType", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/click/b$a;", "params", "", "interestedIn", "invoke", "Ljava/lang/String;", "TAG", "b", "FROM_NT_HIDDEN_CAHT", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class c implements com.tencent.qqnt.chats.main.vm.usecase.click.b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String FROM_NT_HIDDEN_CAHT;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.TAG = "NTHiddenChatItemClickUseCase";
            this.FROM_NT_HIDDEN_CAHT = "FromNtHiddenChat";
        }
    }

    private final void a(Context context, String groupId, String title, int chatType) {
        ActivityURIRequest activityURIRequest = new ActivityURIRequest(context, RouterConstants.UI_ROUTE_CHAT_ACTVITY);
        activityURIRequest.extra().putString("key_chat_name", title);
        activityURIRequest.extra().putString("key_peerId", groupId);
        activityURIRequest.extra().putInt("key_chat_type", chatType);
        activityURIRequest.extra().putString("key_from", "16");
        activityURIRequest.extra().putBoolean(this.FROM_NT_HIDDEN_CAHT, true);
        activityURIRequest.setFlags(268435456);
        QRoute.startUri(activityURIRequest, (o) null);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean interestedIn(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.click.b
    public boolean invoke(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.b() instanceof g) {
            com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
            Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.qqnt.chats.core.adapter.itemdata.RecentContactChatItem");
            g gVar = (g) b16;
            if (gVar.n() == 1) {
                QLog.d(this.TAG, 1, "C2C , " + gVar.l());
                Context context = params.c().getContext();
                Intrinsics.checkNotNullExpressionValue(context, "params.view.context");
                a(context, gVar.k(), gVar.w().e(), 1);
            }
            if (gVar.n() == 2) {
                QLog.d(this.TAG, 1, "Troop , " + gVar.l());
                Context context2 = params.c().getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "params.view.context");
                a(context2, gVar.k(), gVar.w().e(), 2);
            }
        }
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
