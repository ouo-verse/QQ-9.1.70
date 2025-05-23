package com.tencent.qqnt.aio.helper.provider;

import com.tencent.aio.api.help.d;
import com.tencent.mobileqq.aio.helper.z;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqnt.aio.helper.MatchFriendGeneralHelper;
import com.tencent.qqnt.aio.helper.NTEmoPanelHelper;
import com.tencent.qqnt.aio.helper.UinUidUpdateHelper;
import com.tencent.qqnt.aio.helper.cc;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016\u00a2\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003H\u0016\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/qqnt/aio/helper/provider/h;", "Lcom/tencent/aio/api/help/d;", "Lcom/tencent/mobileqq/aio/helper/z;", "", "Lcom/tencent/aio/main/businesshelper/h;", "getLifeCycleHelper", "()[Lcom/tencent/aio/main/businesshelper/h;", "Lcom/tencent/aio/main/businesshelper/e;", "getNormalHelper", "()[Lcom/tencent/aio/main/businesshelper/e;", "Lcom/tencent/aio/api/help/a;", "param", "", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class h implements com.tencent.aio.api.help.d, z {
    @Override // com.tencent.mobileqq.aio.helper.z
    public boolean a(com.tencent.aio.api.help.a param) {
        Intrinsics.checkNotNullParameter(param, "param");
        return param.b().c().e() == 104;
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getLifeCycleHelperCreator(param: HelperProviderParam): Map<String, ()-> ILifeCycleHelper>?", imports = {}))
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper(com.tencent.aio.api.help.a aVar) {
        return d.a.b(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    public Map<String, Function0<com.tencent.aio.main.businesshelper.h>> getLifeCycleHelperCreator(com.tencent.aio.api.help.a aVar) {
        return d.a.c(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper() {
        return new com.tencent.aio.main.businesshelper.e[0];
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u7981\u6b62\u6dfb\u52a0NormalHelper", replaceWith = @ReplaceWith(expression = "UseCase", imports = {}))
    public Map<String, Function0<com.tencent.aio.main.businesshelper.e>> getNormalHelperCreator(com.tencent.aio.api.help.a aVar) {
        return d.a.f(this, aVar);
    }

    @Override // com.tencent.aio.api.help.d
    public com.tencent.aio.main.businesshelper.h[] getLifeCycleHelper() {
        List mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new MatchFriendGeneralHelper(), new NTEmoPanelHelper(), new UinUidUpdateHelper(), new cc(), ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getQQStrangerInteractiveMarkHelper(), ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getLittleAssistantHelper(), ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getAIOSigHelper());
        Object[] array = mutableListOf.toArray(new com.tencent.aio.main.businesshelper.h[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (com.tencent.aio.main.businesshelper.h[]) array;
    }

    @Override // com.tencent.aio.api.help.d
    @Deprecated(message = "\u5e9f\u5f03", replaceWith = @ReplaceWith(expression = "getNormalHelperCreator(param: HelperProviderParam)", imports = {}))
    public com.tencent.aio.main.businesshelper.e[] getNormalHelper(com.tencent.aio.api.help.a aVar) {
        return d.a.e(this, aVar);
    }
}
