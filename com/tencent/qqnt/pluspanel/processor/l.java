package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOSession;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0016\u0010\u0017J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J0\u0010\u0011\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u0004H\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0014H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/l;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Landroid/content/Context;", "context", "", WadlProxyConsts.KEY_JUMP_URL, "uin", "", "c", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "url", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "", "chatType", "", "d", "origUrl", "b", "Lcom/tencent/aio/api/runtime/a;", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class l implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360524a = new a(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/l$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final String b(String origUrl, com.tencent.qqnt.pluspanel.data.a data, int chatType, String uin) {
        String replace$default;
        String replace$default2;
        if ((origUrl.length() == 0) || 220 != data.c()) {
            return origUrl;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(origUrl, "$GTYPE$", String.valueOf(chatType == 2 ? 2 : 1), false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$GCODE$", uin, false, 4, (Object) null);
        return replace$default2;
    }

    private final boolean c(Context context, String jumpUrl, String uin) {
        boolean contains$default;
        if (QLog.isColorLevel()) {
            QLog.i("KingRedPacketC2COnClickProcessor", 2, "onMiniAppJump jumpUrl:" + jumpUrl);
        }
        QRouteApi api = QRoute.api(IMiniAppService.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IMiniAppService::class.java)");
        IMiniAppService iMiniAppService = (IMiniAppService) api;
        if (!(jumpUrl.length() > 0) || !iMiniAppService.isMiniAppUrl(jumpUrl)) {
            return false;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) jumpUrl, (CharSequence) "$TOUIN$", false, 2, (Object) null);
        if (contains$default) {
            if (uin.length() > 0) {
                jumpUrl = StringsKt__StringsJVMKt.replace$default(jumpUrl, "$TOUIN$", uin, false, 4, (Object) null);
            }
        }
        iMiniAppService.startMiniApp(context, jumpUrl, 2053, null);
        return true;
    }

    private final void d(Activity activity, String url, com.tencent.qqnt.pluspanel.data.a data, int chatType, String uin) {
        boolean startsWith$default;
        boolean startsWith$default2;
        if (url.length() > 0) {
            startsWith$default = StringsKt__StringsJVMKt.startsWith$default(url, "http://", false, 2, null);
            if (!startsWith$default) {
                startsWith$default2 = StringsKt__StringsJVMKt.startsWith$default(url, "https://", false, 2, null);
                if (!startsWith$default2) {
                    return;
                }
            }
            String b16 = b(url, data, chatType, uin);
            Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", b16);
            activity.startActivity(intent);
        }
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, com.tencent.aio.api.runtime.a context) {
        String a16;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        AIOSession r16 = context.g().r();
        if (r16.c().e() != 1) {
            return;
        }
        String uin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUinFromUid(r16.c().j());
        if (uin == null || uin.length() == 0) {
            QLog.e("KingRedPacketC2COnClickProcessor", 1, "KingRedPacket uin in null");
            return;
        }
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        if (Intrinsics.areEqual("miniapp", data.b())) {
            String a17 = data.a();
            if (a17 != null) {
                Intrinsics.checkNotNullExpressionValue(uin, "uin");
                c(requireActivity, a17, uin);
                return;
            }
            return;
        }
        if (!Intrinsics.areEqual("web", data.b()) || (a16 = data.a()) == null) {
            return;
        }
        int e16 = r16.c().e();
        Intrinsics.checkNotNullExpressionValue(uin, "uin");
        d(requireActivity, a16, data, e16, uin);
    }
}
