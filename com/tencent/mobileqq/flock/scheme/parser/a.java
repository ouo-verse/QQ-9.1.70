package com.tencent.mobileqq.flock.scheme.parser;

import android.content.Context;
import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.flock.feeddetail.bean.FlockFeedDetailInitBean;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ4\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\"\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005`\u0006H\u0016J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/mobileqq/flock/scheme/parser/a;", "Lcom/tencent/mobileqq/flock/scheme/parser/d;", "Landroid/content/Context;", "context", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "params", "", "a", "", "clientSource", "b", "<init>", "()V", "qq-flock-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes12.dex */
public final class a extends d {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.flock.scheme.parser.d
    public void a(@NotNull Context context, @NotNull HashMap<String, String> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) params);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        long b16 = com.tencent.mobileqq.flock.scheme.a.b(params, "group_id", 0L);
        String str = params.get("feed_id");
        String str2 = "";
        if (str == null) {
            str = "";
        }
        String str3 = str;
        String str4 = params.get("user_id");
        if (str4 == null) {
            str4 = "";
        }
        String str5 = str4;
        String str6 = params.get(QCircleSchemeAttr.MainPage.EUID);
        if (str6 != null) {
            str2 = str6;
        }
        com.tencent.mobileqq.flock.a.f209993a.a(context, new FlockFeedDetailInitBean(str5, str3, com.tencent.mobileqq.flock.scheme.a.b(params, AlbumCacheData.CREATE_TIME, 0L), b16, null, str2, b(com.tencent.mobileqq.flock.scheme.a.a(params, "client_source", 0)), 0, 144, null));
    }

    public final int b(int clientSource) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, clientSource)).intValue();
        }
        if (clientSource == 1) {
            return 5;
        }
        return 0;
    }
}
