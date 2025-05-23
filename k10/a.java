package k10;

import UserGrowth.stSendarkMsgRsp;
import android.os.Bundle;
import com.tencent.biz.pubaccount.weishi.net.common.e;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.net.d;
import com.tencent.biz.pubaccount.weishi.share.ark.WSSendArkMsgRequest;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.component.network.utils.NetworkUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\r\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a8\u0006\u0010"}, d2 = {"Lk10/a;", "", "Lk10/b;", "params", "", "b", "", "resId", "c", "Landroid/os/Bundle;", "bundle", "Lsy/a;", "listener", "a", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f411382a = new a();

    a() {
    }

    private final void b(WSSendArkMsgParams params) {
        x.j("WSSendArkMsgManager", "[sendArkMsg]");
        if (!NetworkUtils.isNetworkAvailable(BaseApplication.getContext())) {
            c(R.string.cib);
        } else {
            e.a(new WSSendArkMsgRequest(params.getUinType(), params.f(), params.e(), params.getPosterId(), params.getFeedId(), params.getContentType())).b(new C10625a(params));
        }
    }

    private final void c(int resId) {
        BaseApplication context = BaseApplication.getContext();
        QQToast.makeText(context, 1, context.getString(resId), 0).show();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J3\u0010\t\u001a\u00020\u00032\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014\u00a2\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\t\u001a\u0004\u0018\u00010\u0003H\u0014\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014\u00a8\u0006\u0012"}, d2 = {"k10/a$a", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stSendarkMsgRsp;", "", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "(Lcom/tencent/biz/pubaccount/weishi/net/common/g;LUserGrowth/stSendarkMsgRsp;Lcom/tencent/biz/pubaccount/weishi/net/d;)Ljava/lang/Integer;", "", "f", "(Ljava/lang/Integer;)V", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "a", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: k10.a$a, reason: collision with other inner class name */
    /* loaded from: classes38.dex */
    public static final class C10625a extends com.tencent.biz.pubaccount.weishi.net.common.b<stSendarkMsgRsp, Integer> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WSSendArkMsgParams f411383a;

        C10625a(WSSendArkMsgParams wSSendArkMsgParams) {
            this.f411383a = wSSendArkMsgParams;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
            x.j("WSSendArkMsgManager", "[failureOnSubThread] errorInfo:" + errorInfo);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            super.b(errorInfo);
            x.j("WSSendArkMsgManager", "[failureOnUIThread] errorInfo:" + errorInfo);
            sy.a listener = this.f411383a.getListener();
            if (listener != null) {
                int a16 = errorInfo != null ? errorInfo.a() : -1;
                String b16 = errorInfo != null ? errorInfo.b() : null;
                if (b16 == null) {
                    b16 = "";
                }
                listener.onFailed(a16, b16);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(Integer e16) {
            super.d(e16);
            sy.a listener = this.f411383a.getListener();
            if (listener != null) {
                listener.onSuccess();
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer c(g<stSendarkMsgRsp> request, stSendarkMsgRsp rsp, d headerBean) {
            x.j("WSSendArkMsgManager", "[successOnSubThread] rsp:" + (rsp != null ? Integer.valueOf(rsp.reserve) : null));
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void a(Bundle bundle, sy.a listener) {
        String str;
        boolean isBlank;
        if (bundle != null) {
            int i3 = bundle.getInt("uintype");
            String string = bundle.getString("uin");
            String string2 = bundle.getString("troop_uin");
            boolean z16 = true;
            if (i3 == 1) {
                if (string2 != null) {
                    isBlank = StringsKt__StringsJVMKt.isBlank(string2);
                    if (!isBlank) {
                        z16 = false;
                    }
                }
                if (z16) {
                    str = string;
                    a aVar = f411382a;
                    String string3 = bundle.getString("forward_ark_app_meta");
                    String string4 = bundle.getString("shareFeedId");
                    String str2 = string4 != null ? "" : string4;
                    Intrinsics.checkNotNullExpressionValue(str2, "getString(WSShareArkCons\u2026.KEY_SHARE_FEED_ID) ?: \"\"");
                    String string5 = bundle.getString("sharePid");
                    String str3 = string5 != null ? "" : string5;
                    Intrinsics.checkNotNullExpressionValue(str3, "getString(WSShareArkConstants.KEY_SHARE_PID) ?: \"\"");
                    aVar.b(new WSSendArkMsgParams(i3, string, str, string3, str2, str3, bundle.getInt("shareContentType"), listener));
                }
            }
            str = string2;
            a aVar2 = f411382a;
            String string32 = bundle.getString("forward_ark_app_meta");
            String string42 = bundle.getString("shareFeedId");
            if (string42 != null) {
            }
            Intrinsics.checkNotNullExpressionValue(str2, "getString(WSShareArkCons\u2026.KEY_SHARE_FEED_ID) ?: \"\"");
            String string52 = bundle.getString("sharePid");
            if (string52 != null) {
            }
            Intrinsics.checkNotNullExpressionValue(str3, "getString(WSShareArkConstants.KEY_SHARE_PID) ?: \"\"");
            aVar2.b(new WSSendArkMsgParams(i3, string, str, string32, str2, str3, bundle.getInt("shareContentType"), listener));
        }
    }
}
