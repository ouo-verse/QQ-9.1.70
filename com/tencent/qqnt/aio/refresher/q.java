package com.tencent.qqnt.aio.refresher;

import android.graphics.drawable.Drawable;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.font.IFontManager;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\b"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/q;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "", "a", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class q extends com.tencent.mobileqq.aio.msglist.holder.external.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/q$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.q$a, reason: from kotlin metadata */
    /* loaded from: classes23.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60487);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public q() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.d
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof o)) {
            return;
        }
        o oVar = (o) request;
        if (oVar.b().p0() == 104) {
            return;
        }
        QRouteApi api = QRoute.api(IFontManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IFontManager::class.java)");
        IFontManager iFontManager = (IFontManager) api;
        if (oVar.a().isEmpty()) {
            return;
        }
        Map.Entry<Integer, IFontManager.FontDrawableInfo> next = oVar.a().entrySet().iterator().next();
        Intrinsics.checkNotNullExpressionValue(next, "iterator.next()");
        Map.Entry<Integer, IFontManager.FontDrawableInfo> entry = next;
        int fontId = entry.getValue().getFontId();
        if (!iFontManager.checkFontFile(fontId)) {
            iFontManager.startDownload(fontId, oVar.b());
            return;
        }
        IFontManager.FontDrawableInfo value = entry.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "defaultInfoMap.value");
        if (!iFontManager.isNeedFontDrawable(value)) {
            return;
        }
        HashMap hashMap = new HashMap();
        for (Map.Entry<Integer, IFontManager.FontDrawableInfo> entry2 : oVar.a().entrySet()) {
            Intrinsics.checkNotNullExpressionValue(entry2, "newIterator.next()");
            Map.Entry<Integer, IFontManager.FontDrawableInfo> entry3 = entry2;
            IFontManager.FontDrawableInfo value2 = entry3.getValue();
            Intrinsics.checkNotNullExpressionValue(value2, "next.value");
            Drawable fontDrawable = iFontManager.getFontDrawable(value2);
            if (fontDrawable != null) {
                Integer key = entry3.getKey();
                Intrinsics.checkNotNullExpressionValue(key, "next.key");
                hashMap.put(key, fontDrawable);
            }
        }
        if (hashMap.isEmpty()) {
            return;
        }
        oVar.d(new p(oVar.b().getMsgId(), new com.tencent.mobileqq.aio.msglist.holder.font.a(hashMap, 1)));
    }
}
