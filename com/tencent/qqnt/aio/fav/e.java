package com.tencent.qqnt.aio.fav;

import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/aio/fav/e;", "", "", QQBrowserActivity.KEY_MSG_TYPE, "Lcom/tencent/qqnt/aio/fav/d;", "a", "", "b", "Ljava/util/Map;", "favFactory", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class e {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final e f349924a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, d> favFactory;

    static {
        Map<Integer, d> mapOf;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63403);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f349924a = new e();
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(31, new MixMsgFavHandler()), TuplesKt.to(2, new MixMsgFavHandler()), TuplesKt.to(3, new c()), TuplesKt.to(6, new PttMsgFavHandler()), TuplesKt.to(7, new VideoMsgFavHandler()), TuplesKt.to(8, new MultiForwardMsgFavHandler()), TuplesKt.to(9, new ReplyMsgFavHandler()), TuplesKt.to(11, new ArkMsgFavHandler()));
        favFactory = mapOf;
    }

    e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final d a(int msgType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (d) iPatchRedirector.redirect((short) 2, (Object) this, msgType);
        }
        return favFactory.get(Integer.valueOf(msgType));
    }
}
