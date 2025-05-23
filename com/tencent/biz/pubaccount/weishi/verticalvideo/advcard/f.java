package com.tencent.biz.pubaccount.weishi.verticalvideo.advcard;

import UserGrowth.stJoinGroupRsp;
import android.content.Context;
import com.tencent.biz.pubaccount.weishi.util.x;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.troop.utils.aq;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002\u001c!B\u0007\u00a2\u0006\u0004\b\u001f\u0010 J$\u0010\t\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u000b\u001a\u00020\bH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J&\u0010\u0012\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u0019\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001a\u001a\u00020\u00152\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018R\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006\""}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/f;", "", "Landroid/content/Context;", "context", "", "groupId", "LUserGrowth/stJoinGroupRsp;", "rsp", "", "g", "j", "d", "i", "qqGroupNum", "qqGroupOwnerPid", "Lkz/a;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/f$b;", "listener", tl.h.F, "", "status", "", "e", "(Ljava/lang/Integer;)Z", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/data/j;", "data", "f", "Lcom/tencent/biz/pubaccount/weishi/view/c;", "a", "Lcom/tencent/biz/pubaccount/weishi/view/c;", "loadingDialog", "<init>", "()V", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private com.tencent.biz.pubaccount.weishi.view.c loadingDialog;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0004\b\f\u0010\rR\u0017\u0010\u0006\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005R\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00078\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\b\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/f$b;", "", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "groupId", "LUserGrowth/stJoinGroupRsp;", "b", "LUserGrowth/stJoinGroupRsp;", "()LUserGrowth/stJoinGroupRsp;", "rsp", "<init>", "(Ljava/lang/String;LUserGrowth/stJoinGroupRsp;)V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final String groupId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final stJoinGroupRsp rsp;

        public b(String groupId, stJoinGroupRsp stjoingrouprsp) {
            Intrinsics.checkNotNullParameter(groupId, "groupId");
            this.groupId = groupId;
            this.rsp = stjoingrouprsp;
        }

        /* renamed from: a, reason: from getter */
        public final String getGroupId() {
            return this.groupId;
        }

        /* renamed from: b, reason: from getter */
        public final stJoinGroupRsp getRsp() {
            return this.rsp;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/f$c", "Lkz/a;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/f$b;", "resultData", "", "a", "", "errorCode", "", "errorMsg", "onFailure", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class c implements kz.a<b> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ WeakReference<Context> f81876b;

        c(WeakReference<Context> weakReference) {
            this.f81876b = weakReference;
        }

        @Override // kz.a
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSuccess(b resultData) {
            Intrinsics.checkNotNullParameter(resultData, "resultData");
            f.this.d();
            f.this.g(this.f81876b.get(), resultData.getGroupId(), resultData.getRsp());
        }

        @Override // kz.a
        public void onFailure(int errorCode, String errorMsg) {
            f.this.d();
            f.this.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d() {
        com.tencent.biz.pubaccount.weishi.view.c cVar = this.loadingDialog;
        if (cVar != null) {
            cVar.dismiss();
        }
    }

    private final void h(String qqGroupNum, String qqGroupOwnerPid, kz.a<b> listener) {
        com.tencent.biz.pubaccount.weishi.net.common.e.a(new WSJoinGroupRequest(qqGroupNum, qqGroupOwnerPid)).b(new d(qqGroupNum, listener));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void i() {
        QQToast.makeText(BaseApplication.getContext(), 1, R.string.x8z, 0).show();
    }

    private final void j(Context context) {
        com.tencent.biz.pubaccount.weishi.view.c cVar = this.loadingDialog;
        if (cVar == null) {
            cVar = new com.tencent.biz.pubaccount.weishi.view.c(context, context.getResources().getString(R.string.f169726x91));
        }
        cVar.show();
        this.loadingDialog = cVar;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001J.\u0010\t\u001a\u00020\u00032\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014J\u0010\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0014\u00a8\u0006\u0011"}, d2 = {"com/tencent/biz/pubaccount/weishi/verticalvideo/advcard/f$d", "Lcom/tencent/biz/pubaccount/weishi/net/common/b;", "LUserGrowth/stJoinGroupRsp;", "Lcom/tencent/biz/pubaccount/weishi/verticalvideo/advcard/f$b;", "Lcom/tencent/biz/pubaccount/weishi/net/common/g;", Const.BUNDLE_KEY_REQUEST, "rsp", "Lcom/tencent/biz/pubaccount/weishi/net/d;", "headerBean", "e", "Lcom/tencent/biz/pubaccount/weishi/net/common/j;", "errorInfo", "", "a", "resultData", "f", "b", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes32.dex */
    public static final class d extends com.tencent.biz.pubaccount.weishi.net.common.b<stJoinGroupRsp, b> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f81877a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ kz.a<b> f81878b;

        d(String str, kz.a<b> aVar) {
            this.f81877a = str;
            this.f81878b = aVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public b c(com.tencent.biz.pubaccount.weishi.net.common.g<stJoinGroupRsp> request, stJoinGroupRsp rsp, com.tencent.biz.pubaccount.weishi.net.d headerBean) {
            return new b(this.f81877a, rsp);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void d(b resultData) {
            Intrinsics.checkNotNullParameter(resultData, "resultData");
            stJoinGroupRsp rsp = resultData.getRsp();
            Integer valueOf = rsp != null ? Integer.valueOf(rsp.status) : null;
            stJoinGroupRsp rsp2 = resultData.getRsp();
            x.j("WSJoinGroupHelper", "request success. status = " + valueOf + ", sigature = " + (rsp2 != null ? rsp2.signature : null));
            this.f81878b.onSuccess(resultData);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void b(com.tencent.biz.pubaccount.weishi.net.common.j errorInfo) {
            x.f("WSJoinGroupHelper", "request failed. errorCode = " + (errorInfo != null ? Integer.valueOf(errorInfo.a()) : null) + ", errorMsg = " + (errorInfo != null ? errorInfo.b() : null));
            this.f81878b.onFailure(errorInfo != null ? errorInfo.a() : -1, errorInfo != null ? errorInfo.b() : null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.biz.pubaccount.weishi.net.common.b
        public void a(com.tencent.biz.pubaccount.weishi.net.common.j errorInfo) {
        }
    }

    private final boolean e(Integer status) {
        return (status != null && status.intValue() == 2) || (status != null && status.intValue() == 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(Context context, String groupId, stJoinGroupRsp rsp) {
        boolean isBlank;
        boolean z16;
        boolean isBlank2;
        Integer valueOf = rsp != null ? Integer.valueOf(rsp.status) : null;
        String str = rsp != null ? rsp.signature : null;
        x.f("WSJoinGroupHelper", "openTroopPage() context = " + context + ", groupId = " + groupId + ", status = " + valueOf + ", signature = " + str);
        if (context != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(groupId);
            if (!isBlank && e(valueOf)) {
                if (str != null) {
                    isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                    if (!isBlank2) {
                        z16 = false;
                        if (!z16) {
                            TroopUtils.I(context, aq.d(groupId, str, 60006), 2);
                            return;
                        }
                    }
                }
                z16 = true;
                if (!z16) {
                }
            }
        }
        i();
    }

    public final boolean f(Context context, com.tencent.biz.pubaccount.weishi.verticalvideo.data.j data) {
        String str;
        boolean isBlank;
        boolean isBlank2;
        String m3;
        if (context != null && data != null) {
            ez.a f16 = data.f();
            ez.b bVar = f16 instanceof ez.b ? (ez.b) f16 : null;
            String str2 = "";
            if (bVar == null || (str = bVar.l()) == null) {
                str = "";
            }
            if (bVar != null && (m3 = bVar.m()) != null) {
                str2 = m3;
            }
            x.j("WSJoinGroupHelper", "joinQQGroup() qqGroupNum = " + str + ", qqGroupOwnerPid = " + str2);
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str2);
                if (!isBlank2) {
                    j(context);
                    h(str, str2, new c(new WeakReference(context)));
                    return true;
                }
            }
        }
        return false;
    }
}
