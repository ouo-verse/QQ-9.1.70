package com.tencent.biz.pubaccount.weishi.commonpopdialog;

import UserGrowth.stGetUserPopWindowsRsp;
import UserGrowth.stPopWindowItem;
import UserGrowth.stSetUserPopWindowsRsp;
import com.tencent.biz.pubaccount.weishi.net.common.e;
import com.tencent.biz.pubaccount.weishi.net.common.g;
import com.tencent.biz.pubaccount.weishi.net.common.j;
import com.tencent.biz.pubaccount.weishi.net.d;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import java.lang.ref.SoftReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J&\u0010\b\u001a\u00020\u00062\u001e\u0010\u0007\u001a\u001a\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0004\u0012\u00020\u00060\u0002J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004R0\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/commonpopdialog/b;", "", "Lkotlin/Function1;", "", "", "LUserGrowth/stPopWindowItem;", "", "callback", "a", "dialogType", "actionType", "c", "b", "Ljava/util/Map;", "()Ljava/util/Map;", "d", "(Ljava/util/Map;)V", "dialogMap", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f80631a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static Map<Integer, stPopWindowItem> dialogMap;

    b() {
    }

    public final void a(Function1<? super Map<Integer, stPopWindowItem>, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        e.a(new WSPopDialogRequest()).b(new a(new SoftReference(callback)));
    }

    public final Map<Integer, stPopWindowItem> b() {
        return dialogMap;
    }

    public final void c(int dialogType, int actionType) {
        e.a(new WSPopDialogActionRequest(dialogType, actionType)).b(new C0822b());
    }

    public final void d(Map<Integer, stPopWindowItem> map) {
        dialogMap = map;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J0\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\r\u001a\u00020\u000b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0014J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\u000f"}, d2 = {"com/tencent/biz/pubaccount/weishi/commonpopdialog/b$a", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stGetUserPopWindowsRsp;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class a extends com.tencent.biz.pubaccount.weishi.net.common.b<stGetUserPopWindowsRsp, stGetUserPopWindowsRsp> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ SoftReference<Function1<Map<Integer, stPopWindowItem>, Unit>> f80633a;

        a(SoftReference<Function1<Map<Integer, stPopWindowItem>, Unit>> softReference) {
            this.f80633a = softReference;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(stGetUserPopWindowsRsp rsp) {
            Map<Integer, stPopWindowItem> map;
            Map<Integer, stPopWindowItem> map2;
            if (rsp != null && (map2 = rsp.data) != null) {
                SoftReference<Function1<Map<Integer, stPopWindowItem>, Unit>> softReference = this.f80633a;
                b.f80631a.d(map2);
                Function1<Map<Integer, stPopWindowItem>, Unit> function1 = softReference.get();
                if (function1 != null) {
                    function1.invoke(map2);
                }
            }
            x.j("WSPopDialogFetcher", "fetchDialogData() request success. rsp.size = " + ((rsp == null || (map = rsp.data) == null) ? null : Integer.valueOf(map.size())) + ", callback is null = " + (this.f80633a.get() == null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(j errorInfo) {
            x.f("WSPopDialogFetcher", "fetchDialogData() request failed. code = " + (errorInfo != null ? Integer.valueOf(errorInfo.a()) : null) + ", msg = " + (errorInfo != null ? errorInfo.b() : null));
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stGetUserPopWindowsRsp c(g<stGetUserPopWindowsRsp> request, stGetUserPopWindowsRsp rsp, d headerBean) {
            return rsp;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001J0\u0010\b\u001a\u0004\u0018\u00010\u00022\u0010\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014\u00a8\u0006\r"}, d2 = {"com/tencent/biz/pubaccount/weishi/commonpopdialog/b$b", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stSetUserPopWindowsRsp;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.biz.pubaccount.weishi.commonpopdialog.b$b, reason: collision with other inner class name */
    /* loaded from: classes32.dex */
    public static final class C0822b extends com.tencent.biz.pubaccount.weishi.net.common.b<stSetUserPopWindowsRsp, stSetUserPopWindowsRsp> {
        C0822b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public stSetUserPopWindowsRsp c(g<stSetUserPopWindowsRsp> request, stSetUserPopWindowsRsp rsp, d headerBean) {
            x.j("WSPopDialogFetcher", "sendWindowActionRequest() request success.");
            return rsp;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(j errorInfo) {
            x.f("WSPopDialogFetcher", "sendWindowActionRequest() request failed. code = " + (errorInfo != null ? Integer.valueOf(errorInfo.a()) : null) + ", msg = " + (errorInfo != null ? errorInfo.b() : null));
        }
    }
}
