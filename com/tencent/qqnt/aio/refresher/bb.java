package com.tencent.qqnt.aio.refresher;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.avatar.api.IVasAvatarManager;
import com.tencent.mobileqq.vip.api.VipData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.VASPersonalVipNumberInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/bb;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/d;", "Lcom/tencent/mobileqq/aio/msglist/holder/external/h;", Const.BUNDLE_KEY_REQUEST, "", "a", "", "b", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public final class bb extends com.tencent.mobileqq.aio.msglist.holder.external.d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/aio/refresher/bb$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "aio_ext_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.aio.refresher.bb$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(60578);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public bb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.tencent.mobileqq.vip.api.VipData$VipNumberInfo, T] */
    @Override // com.tencent.mobileqq.aio.msglist.holder.external.d
    public void a(@NotNull com.tencent.mobileqq.aio.msglist.holder.external.h request) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) request);
            return;
        }
        Intrinsics.checkNotNullParameter(request, "request");
        if (!(request instanceof az)) {
            return;
        }
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        az azVar = (az) request;
        VASPersonalVipNumberInfo c16 = azVar.c();
        if (c16 != null) {
            ?? vipNumberInfo = new VipData.VipNumberInfo();
            Integer num = c16.appId;
            Intrinsics.checkNotNullExpressionValue(num, "it.appId");
            vipNumberInfo.setAppId(num.intValue());
            Integer num2 = c16.itemId;
            Intrinsics.checkNotNullExpressionValue(num2, "it.itemId");
            vipNumberInfo.setItemId(num2.intValue());
            Integer num3 = c16.numberItemId;
            Intrinsics.checkNotNullExpressionValue(num3, "it.numberItemId");
            vipNumberInfo.setNumberItemId(num3.intValue());
            Integer num4 = c16.numberIdx;
            Intrinsics.checkNotNullExpressionValue(num4, "it.numberIdx");
            vipNumberInfo.setNumberIdx(num4.intValue());
            vipNumberInfo.setLongNumber(azVar.d());
            objectRef.element = vipNumberInfo;
        }
        com.tencent.mobileqq.aio.msglist.holder.avatar.a aVar = new com.tencent.mobileqq.aio.msglist.holder.avatar.a(((IVasAvatarManager) QRoute.api(IVasAvatarManager.class)).getVasAvatarDrawable(azVar.f(), azVar.a(), 200, 0, 9, (VipData.VipNumberInfo) objectRef.element, false, azVar.e()).getDrawable());
        if (QLog.isDevelopLevel()) {
            QLog.i("VasAvatarRefresher", 4, "[loadData]: msgId is " + azVar.b().getMsgId() + " uin is " + azVar.f() + " faceId is " + azVar.a());
        }
        azVar.g(new ba(azVar.b().getMsgId(), azVar.f(), azVar.a(), aVar));
    }

    @Override // com.tencent.mobileqq.aio.msglist.holder.external.d
    public boolean b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
        }
        return true;
    }
}
