package com.tencent.mobileqq.aio.bubble;

import android.text.TextUtils;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.aio.utils.m;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.bubble.IBubbleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0010\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/aio/bubble/a;", "", "", "bubbleId", "", "a", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setBubbleId", "(Ljava/lang/String;)V", "Z", "c", "()Z", "setShootBubble", "(Z)V", "isShootBubble", "Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;", "msgItem", "<init>", "(Lcom/tencent/mobileqq/aio/msg/AIOMsgItem;)V", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String bubbleId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isShootBubble;

    public a(@NotNull AIOMsgItem msgItem) {
        Intrinsics.checkNotNullParameter(msgItem, "msgItem");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) msgItem);
            return;
        }
        this.bubbleId = "";
        String b16 = m.f194167a.b(msgItem);
        this.bubbleId = b16;
        this.isShootBubble = a(b16);
    }

    private final boolean a(String bubbleId) {
        Integer intOrNull;
        if (TextUtils.isEmpty(bubbleId)) {
            return false;
        }
        QRouteApi api = QRoute.api(IBubbleManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IBubbleManager::class.java)");
        IBubbleManager iBubbleManager = (IBubbleManager) api;
        intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(bubbleId);
        if (intOrNull == null) {
            return false;
        }
        int intValue = intOrNull.intValue();
        if (!iBubbleManager.checkBubbleFile(intValue) || !iBubbleManager.isShootBubble(intValue)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.bubbleId;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
        }
        return this.isShootBubble;
    }
}
