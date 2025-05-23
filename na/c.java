package na;

import com.qzone.reborn.albumx.qzone.vas.network.QZonePhotoDegradeCloseNotifyRequest;
import com.qzone.reborn.albumx.qzone.vas.network.QZonePhotoDegradeNotifyRequest;
import com.qzone.reborn.albumx.qzone.vas.network.QzonePhotoDegradeIsGrayUinRequest;
import com.qzone.reborn.base.n;
import com.qzone.reborn.configx.g;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZonePhotoDegrade$IsGrayUinRsp;
import qzone.QZonePhotoDegrade$QueryNotifyMsgRsp;
import qzone.QZonePhotoDegrade$Text;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\r\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004J\u000e\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002J\u0014\u0010\u000e\u001a\u00020\r2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\"\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000f2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00070\u0011J\u0006\u0010\u0015\u001a\u00020\u0012R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lna/c;", "", "", "scene", "Lcom/qzone/reborn/base/n$a;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "dataCallback", "", "i", "c", "", "Lqzone/QZonePhotoDegrade$Text;", "textList", "", "j", "", "uin", "Lkotlin/Function1;", "", "callback", "g", "e", "b", "Z", "f", "()Z", "setGrayUser", "(Z)V", "isGrayUser", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public static final c f419539a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean isGrayUser;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J4\u0010\r\u001a\u00020\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"na/c$a", "Lcom/tencent/biz/richframework/network/observer/VSDispatchObserver$OnVSRspCallBack;", "Lqzone/QZonePhotoDegrade$QueryNotifyMsgRsp;", "Lcom/tencent/biz/richframework/network/request/BaseRequest;", Const.BUNDLE_KEY_REQUEST, "", "isSuccess", "", "retCode", "", "errMsg", "rsp", "", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes38.dex */
    public static final class a implements VSDispatchObserver.OnVSRspCallBack<QZonePhotoDegrade$QueryNotifyMsgRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ n.a<QZonePhotoDegrade$QueryNotifyMsgRsp> f419541a;

        a(n.a<QZonePhotoDegrade$QueryNotifyMsgRsp> aVar) {
            this.f419541a = aVar;
        }

        @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceive(BaseRequest request, boolean isSuccess, long retCode, String errMsg, QZonePhotoDegrade$QueryNotifyMsgRsp rsp) {
            Intrinsics.checkNotNullParameter(errMsg, "errMsg");
            RFWLog.d("QZoneOriginalPhotoDegradeManager", RFWLog.USR, "requestNotifyInfo, isSuccess: " + isSuccess + ", retCode: " + retCode + ", errMsg: " + errMsg);
            if (isSuccess && rsp != null) {
                this.f419541a.onSuccess(rsp, retCode, errMsg, true);
            } else {
                this.f419541a.onFailure(retCode, errMsg);
            }
        }
    }

    c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
        RFWLog.d("QZoneOriginalPhotoDegradeManager", RFWLog.USR, "closeAlbumListTips, isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(Function1 callback, BaseRequest baseRequest, boolean z16, long j3, String str, QZonePhotoDegrade$IsGrayUinRsp qZonePhotoDegrade$IsGrayUinRsp) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        RFWLog.d("QZoneOriginalPhotoDegradeManager", RFWLog.USR, "requestNotifyInfo, isSuccess: " + z16 + ", retCode: " + j3 + ", errMsg: " + str);
        if (z16 && qZonePhotoDegrade$IsGrayUinRsp != null) {
            isGrayUser = qZonePhotoDegrade$IsGrayUinRsp.is_gray_uin.get();
            callback.invoke(Boolean.valueOf(qZonePhotoDegrade$IsGrayUinRsp.is_gray_uin.get()));
        } else {
            isGrayUser = false;
            callback.invoke(Boolean.FALSE);
        }
    }

    public final void c(int scene) {
        VSNetworkHelper.getInstance().sendRequest(new QZonePhotoDegradeCloseNotifyRequest(scene), new VSDispatchObserver.OnVSRspCallBack() { // from class: na.b
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.d(baseRequest, z16, j3, str, obj);
            }
        });
    }

    public final boolean e() {
        return g.f53821a.b().Z();
    }

    public final boolean f() {
        return isGrayUser;
    }

    public final void g(long uin, final Function1<? super Boolean, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        VSNetworkHelper.getInstance().sendRequest(new QzonePhotoDegradeIsGrayUinRequest(uin), new VSDispatchObserver.OnVSRspCallBack() { // from class: na.a
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                c.h(Function1.this, baseRequest, z16, j3, str, (QZonePhotoDegrade$IsGrayUinRsp) obj);
            }
        });
    }

    public final void i(int scene, n.a<QZonePhotoDegrade$QueryNotifyMsgRsp> dataCallback) {
        Intrinsics.checkNotNullParameter(dataCallback, "dataCallback");
        if (!e()) {
            RFWLog.d("QZoneOriginalPhotoDegradeManager", RFWLog.USR, "requestNotifyInfo fail, photo degrade is disable");
        } else {
            VSNetworkHelper.getInstance().sendRequest(new QZonePhotoDegradeNotifyRequest(scene), new a(dataCallback));
        }
    }

    public final String j(List<QZonePhotoDegrade$Text> textList) {
        Intrinsics.checkNotNullParameter(textList, "textList");
        StringBuilder sb5 = new StringBuilder();
        for (QZonePhotoDegrade$Text qZonePhotoDegrade$Text : textList) {
            if (qZonePhotoDegrade$Text.type.get() == 0) {
                sb5.append(qZonePhotoDegrade$Text.f430343msg.get());
            }
        }
        String sb6 = sb5.toString();
        Intrinsics.checkNotNullExpressionValue(sb6, "result.toString()");
        return sb6;
    }
}
