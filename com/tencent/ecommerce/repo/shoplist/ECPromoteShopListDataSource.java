package com.tencent.ecommerce.repo.shoplist;

import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.ecommerce.base.ktx.c;
import com.tencent.ecommerce.base.list.BaseListDataSource;
import com.tencent.ecommerce.base.list.IListRepository;
import com.tencent.ecommerce.base.network.api.ECNetworkResponse;
import com.tencent.ecommerce.base.network.api.IECNetworkPBContracts;
import com.tencent.ecommerce.biz.shoplist.ECPromoteShopItem;
import com.tencent.ecommerce.repo.proto.ecom.window_info_svr.ECWindowInfoSvr$GetStorePromotionsReq;
import com.tencent.ecommerce.repo.proto.ecom.window_info_svr.ECWindowInfoSvr$GetStorePromotionsRsp;
import com.tencent.ecommerce.repo.proto.ecom.window_info_svr.ECWindowInfoSvr$ShowWindowInfo;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \u00102\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ'\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ/\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0004H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ1\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00062\u0006\u0010\u0005\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\u0004H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\r\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/ecommerce/repo/shoplist/ECPromoteShopListDataSource;", "Lcom/tencent/ecommerce/base/list/BaseListDataSource;", "Lcom/tencent/ecommerce/repo/shoplist/b;", "Lcom/tencent/ecommerce/biz/shoplist/a;", "", Const.BUNDLE_KEY_REQUEST, "Lcom/tencent/ecommerce/base/list/IListRepository$a;", "l", "(Lcom/tencent/ecommerce/repo/shoplist/b;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "extra", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "(Lcom/tencent/ecommerce/repo/shoplist/b;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cookie", DomainData.DOMAIN_NAME, "<init>", "()V", "b", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECPromoteShopListDataSource extends BaseListDataSource<ECPromoteShopRequestInfo, ECPromoteShopItem, String> {

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\"\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\tH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/ecommerce/repo/shoplist/ECPromoteShopListDataSource$b", "Lcom/tencent/ecommerce/base/network/api/IECNetworkPBContracts;", "Lcom/tencent/ecommerce/repo/proto/ecom/window_info_svr/ECWindowInfoSvr$GetStorePromotionsReq;", "Lcom/tencent/ecommerce/repo/proto/ecom/window_info_svr/ECWindowInfoSvr$GetStorePromotionsRsp;", "params", "", WadlProxyConsts.CHANNEL, "Lorg/json/JSONObject;", "reqExt", "", "b", "rsp", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class b implements IECNetworkPBContracts<ECWindowInfoSvr$GetStorePromotionsReq, ECWindowInfoSvr$GetStorePromotionsRsp> {
        b() {
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public ECWindowInfoSvr$GetStorePromotionsRsp decodeResponse(byte[] rsp) {
            return new ECWindowInfoSvr$GetStorePromotionsRsp().mergeFrom(rsp);
        }

        @Override // com.tencent.ecommerce.base.network.api.IECNetworkPBContracts
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] encodeRequestParams(ECWindowInfoSvr$GetStorePromotionsReq params, int channel, JSONObject reqExt) {
            return params.toByteArray();
        }
    }

    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public Object h(ECPromoteShopRequestInfo eCPromoteShopRequestInfo, String str, Continuation<? super IListRepository.Result<ECPromoteShopItem, String>> continuation) {
        return n(eCPromoteShopRequestInfo, str, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0026  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final /* synthetic */ Object n(ECPromoteShopRequestInfo eCPromoteShopRequestInfo, String str, Continuation<? super IListRepository.Result<ECPromoteShopItem, String>> continuation) {
        ECPromoteShopListDataSource$loadPageFromServer$1 eCPromoteShopListDataSource$loadPageFromServer$1;
        Object coroutine_suspended;
        int i3;
        int code;
        List emptyList;
        List b16;
        if (continuation instanceof ECPromoteShopListDataSource$loadPageFromServer$1) {
            eCPromoteShopListDataSource$loadPageFromServer$1 = (ECPromoteShopListDataSource$loadPageFromServer$1) continuation;
            int i16 = eCPromoteShopListDataSource$loadPageFromServer$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                eCPromoteShopListDataSource$loadPageFromServer$1.label = i16 - Integer.MIN_VALUE;
                Object obj = eCPromoteShopListDataSource$loadPageFromServer$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = eCPromoteShopListDataSource$loadPageFromServer$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    cg0.a.b("ECPromoteShopListDataSource", "loadPageFromServer, cookie: " + str + "\uff0crequestInfo: " + eCPromoteShopRequestInfo);
                    ECWindowInfoSvr$GetStorePromotionsReq eCWindowInfoSvr$GetStorePromotionsReq = new ECWindowInfoSvr$GetStorePromotionsReq();
                    eCWindowInfoSvr$GetStorePromotionsReq.req_source.set(eCPromoteShopRequestInfo.channel);
                    c.b(eCWindowInfoSvr$GetStorePromotionsReq.cookie, str);
                    eCWindowInfoSvr$GetStorePromotionsReq.scene.set(eCPromoteShopRequestInfo.scene);
                    eCWindowInfoSvr$GetStorePromotionsReq.owner_id.set(eCPromoteShopRequestInfo.ownerId);
                    b bVar = new b();
                    eCPromoteShopListDataSource$loadPageFromServer$1.label = 1;
                    obj = com.tencent.ecommerce.base.network.service.a.f("trpc.ecom.window_info_svr.WindowInfoSvr", "/trpc.ecom.window_info_svr.WindowInfoSvr/GetStorePromotions", bVar, eCWindowInfoSvr$GetStorePromotionsReq, eCPromoteShopListDataSource$loadPageFromServer$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (i3 == 1) {
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ECNetworkResponse eCNetworkResponse = (ECNetworkResponse) obj;
                code = eCNetworkResponse.getCode();
                String message = eCNetworkResponse.getMessage();
                ECWindowInfoSvr$GetStorePromotionsRsp eCWindowInfoSvr$GetStorePromotionsRsp = (ECWindowInfoSvr$GetStorePromotionsRsp) eCNetworkResponse.b();
                cg0.a.b("ECPromoteShopListDataSource", "loadPageFromServer rsp, code=" + code + ", msg=" + message);
                if (code == 0 || eCWindowInfoSvr$GetStorePromotionsRsp == null) {
                    emptyList = CollectionsKt__CollectionsKt.emptyList();
                    return new IListRepository.Result(false, emptyList, false, "");
                }
                List<ECWindowInfoSvr$ShowWindowInfo> list = eCWindowInfoSvr$GetStorePromotionsRsp.shops.get();
                cg0.a.b("ECPromoteShopListDataSource", "loadPageFromServer rsp, data size = " + list.size());
                b16 = a.b(list);
                boolean z16 = eCWindowInfoSvr$GetStorePromotionsRsp.is_end.get() == 0;
                String c16 = c.c(eCWindowInfoSvr$GetStorePromotionsRsp.cookie, "");
                return new IListRepository.Result(true, b16, z16, c16 != null ? c16 : "");
            }
        }
        eCPromoteShopListDataSource$loadPageFromServer$1 = new ECPromoteShopListDataSource$loadPageFromServer$1(this, continuation);
        Object obj2 = eCPromoteShopListDataSource$loadPageFromServer$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = eCPromoteShopListDataSource$loadPageFromServer$1.label;
        if (i3 != 0) {
        }
        ECNetworkResponse eCNetworkResponse2 = (ECNetworkResponse) obj2;
        code = eCNetworkResponse2.getCode();
        String message2 = eCNetworkResponse2.getMessage();
        ECWindowInfoSvr$GetStorePromotionsRsp eCWindowInfoSvr$GetStorePromotionsRsp2 = (ECWindowInfoSvr$GetStorePromotionsRsp) eCNetworkResponse2.b();
        cg0.a.b("ECPromoteShopListDataSource", "loadPageFromServer rsp, code=" + code + ", msg=" + message2);
        if (code == 0) {
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return new IListRepository.Result(false, emptyList, false, "");
    }

    static /* synthetic */ Object o(ECPromoteShopListDataSource eCPromoteShopListDataSource, ECPromoteShopRequestInfo eCPromoteShopRequestInfo, String str, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = "";
        }
        return eCPromoteShopListDataSource.n(eCPromoteShopRequestInfo, str, continuation);
    }

    @Override // com.tencent.ecommerce.base.list.BaseListDataSource
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Object c(ECPromoteShopRequestInfo eCPromoteShopRequestInfo, Continuation<? super IListRepository.Result<ECPromoteShopItem, String>> continuation) {
        return o(this, eCPromoteShopRequestInfo, null, continuation, 2, null);
    }
}
