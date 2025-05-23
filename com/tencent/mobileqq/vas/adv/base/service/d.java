package com.tencent.mobileqq.vas.adv.base.service;

import com.tencent.ecommerce.base.searchbar.IECSearchBar;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.vas.adv.common.callback.VasAdCallback;
import com.tencent.mobileqq.vas.adv.common.data.VasAdvServiceCode;
import com.tencent.mobileqq.vas.adv.common.data.VasNewAdParams;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.access;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \"2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001#B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u000b\u001a\u00020\u0014\u00a2\u0006\u0004\b \u0010!J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\u00020\b2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0014J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0003H\u0014J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\u0018\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0006H\u0014R\"\u0010\u000b\u001a\u00020\u00148\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001c\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/base/service/d;", "Lcom/tencent/mobileqq/vas/adv/base/service/c;", "Ltencent/gdt/access$AdGetReq;", "Ltencent/gdt/access$AdGetRsp;", "", "retCode", "", "msg", "", "l", "Lbz2/a;", "callback", "k", "rsp", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/vas/adv/common/data/VasAdvServiceCode;", "serviceCode", "errMsg", h.F, "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "d", "Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", "getCallback", "()Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;", IECSearchBar.METHOD_SET_CALLBACK, "(Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;)V", "e", "Ltencent/gdt/access$AdGetRsp;", "mAdRsp", "Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;", "vasNewAdParams", "<init>", "(Lcom/tencent/mobileqq/vas/adv/common/data/VasNewAdParams;Lcom/tencent/mobileqq/vas/adv/common/callback/VasAdCallback;)V", "f", "a", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class d extends c<access.AdGetReq, access.AdGetRsp> {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private VasAdCallback callback;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private access.AdGetRsp mAdRsp;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(@NotNull VasNewAdParams vasNewAdParams, @NotNull VasAdCallback callback) {
        super(vasNewAdParams);
        Intrinsics.checkNotNullParameter(vasNewAdParams, "vasNewAdParams");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.callback = callback;
    }

    private final void l(int retCode, String msg2) {
        if (QLog.isColorLevel()) {
            QLog.d("VasAdLoadService", 2, "callRewardResult retCode:" + retCode);
        }
        this.callback.onRsp(retCode, this.mAdRsp, msg2);
    }

    @Override // com.tencent.mobileqq.vas.adv.base.service.c
    protected void h(@NotNull VasAdvServiceCode serviceCode, @NotNull String errMsg) {
        Intrinsics.checkNotNullParameter(serviceCode, "serviceCode");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        this.mAdRsp = null;
        l(c(serviceCode), errMsg);
        if (QLog.isColorLevel()) {
            QLog.d("VasAdLoadService", 2, "onError errMsg:" + errMsg);
        }
    }

    @Override // com.tencent.mobileqq.vas.adv.base.service.c
    protected void k(@NotNull bz2.a<access.AdGetRsp> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e.f307985a.v(m(), callback);
    }

    @NotNull
    protected access.AdGetReq m() {
        return d();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.vas.adv.base.service.c
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    public void i(@NotNull access.AdGetRsp rsp) {
        Intrinsics.checkNotNullParameter(rsp, "rsp");
        this.mAdRsp = rsp;
        access.RetMsg retMsg = rsp.ret_msg;
        int i3 = retMsg.ret_code.get();
        String str = retMsg.err_msg.get();
        Intrinsics.checkNotNullExpressionValue(str, "retInfo.err_msg.get()");
        l(i3, str);
    }
}
