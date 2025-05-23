package com.tencent.qqnt.aio.toppopup;

import com.tencent.mobileqq.kandian.base.image.api.IPublicAccountHttpDownloader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.annotation.qautoinject.QAutoInjectJustClazz;
import com.tencent.qqnt.aio.adapter.toppopup.DebugTopPopupView;
import com.tencent.qqnt.aio.adapter.toppopup.TroopOnlineMemberPopupView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\fJ\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002RD\u0010\r\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00070\u0006j\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u0007`\b8\u0002@\u0002X\u0083\u000e\u00a2\u0006\f\n\u0004\b\t\u0010\n\u0012\u0004\b\u000b\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/aio/toppopup/b;", "", "", IPublicAccountHttpDownloader.BUSI_TYPE_PARAM_KEY, "Lcom/tencent/qqnt/aio/toppopup/a;", "a", "Ljava/util/HashMap;", "Ljava/lang/Class;", "Lkotlin/collections/HashMap;", "b", "Ljava/util/HashMap;", "getMPopViewMap$annotations", "()V", "mPopViewMap", "<init>", "aio_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f352150a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @QAutoInjectJustClazz(configPath = "AutoInjectYml/Business/AIO/toppopup/Inject_TopPopupView.yml", version = 1)
    @NotNull
    private static HashMap<String, Class<a>> mPopViewMap;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(52148);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
            return;
        }
        f352150a = new b();
        HashMap<String, Class<a>> hashMap = new HashMap<>();
        mPopViewMap = hashMap;
        hashMap.put("1", TroopOnlineMemberPopupView.class);
        mPopViewMap.put("-1", DebugTopPopupView.class);
    }

    b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Nullable
    public final a a(@NotNull String busiType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this, (Object) busiType);
        }
        Intrinsics.checkNotNullParameter(busiType, "busiType");
        Class<a> cls = mPopViewMap.get(busiType);
        if (cls != null) {
            return cls.newInstance();
        }
        return null;
    }
}
