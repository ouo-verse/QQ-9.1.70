package com.tencent.mobileqq.troop.troopsetting.share.troopsetting;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.troop.utils.bg;
import cooperation.qzone.QZoneShareData;
import cooperation.qzone.QZoneShareManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0016J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/d;", "Lcom/tencent/mobileqq/troop/troopsetting/share/a;", "Lcom/tencent/mobileqq/troop/troopsetting/share/b;", "shareContext", "", "headUrl", "", "f", "", "d", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class d extends com.tencent.mobileqq.troop.troopsetting.share.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/troopsetting/share/troopsetting/d$a;", "", "", "REQUEST_CODE_SHARE_QZONE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.troopsetting.share.troopsetting.d$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(61058);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void f(com.tencent.mobileqq.troop.troopsetting.share.b shareContext, String headUrl) {
        String str;
        List listOf;
        String str2 = shareContext.h().troopUin;
        com.tencent.mobileqq.troop.troopshare.a f16 = shareContext.f();
        if (f16 != null) {
            str = f16.f301556d;
        } else {
            str = null;
        }
        String c16 = c(shareContext);
        String str3 = "";
        if (c16 == null) {
            c16 = "";
        }
        String b16 = b(shareContext);
        if (b16 != null) {
            str3 = b16;
        }
        QZoneShareData qZoneShareData = new QZoneShareData();
        qZoneShareData.mTitle = c16;
        qZoneShareData.mSummary = str3;
        qZoneShareData.targetUrl = str;
        bg bgVar = bg.f302144a;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(headUrl);
        qZoneShareData.mImageUrls = bgVar.n(listOf);
        QZoneShareManager.shareToQzone(shareContext.b(), str2, qZoneShareData, null, 145);
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    public void a(@NotNull com.tencent.mobileqq.troop.troopsetting.share.b shareContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) shareContext);
            return;
        }
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        String str = shareContext.h().troopUin;
        QRouteApi api = QRoute.api(ITroopAvatarUtilApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopAvatarUtilApi::class.java)");
        f(shareContext, ((ITroopAvatarUtilApi) api).getAvatarAddress("", str, 0));
    }

    @Override // com.tencent.mobileqq.troop.troopsetting.share.a
    @NotNull
    public List<String> d() {
        List<String> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf("qzoneshuoshuo");
            return listOf;
        }
        return (List) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
