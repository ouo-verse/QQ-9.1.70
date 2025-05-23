package com.tencent.qqnt.pluspanel.processor;

import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.app.api.IRuntimeService;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0018\u0010\u000e\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u0018\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/PlayTogetherOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "", "uin", "", "originUrl", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "Lcom/tencent/aio/api/runtime/a;", "context", "", "d", WadlProxyConsts.KEY_JUMP_URL, "curFriendUin", "c", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class PlayTogetherOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360480a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/PlayTogetherOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final String c(String jumpUrl, String curFriendUin) {
        boolean contains$default;
        String replace$default;
        if (TextUtils.isEmpty(jumpUrl)) {
            return jumpUrl;
        }
        contains$default = StringsKt__StringsKt.contains$default((CharSequence) jumpUrl, (CharSequence) "$TOUIN$", false, 2, (Object) null);
        if (!contains$default || TextUtils.isEmpty(curFriendUin)) {
            return jumpUrl;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(jumpUrl, "$TOUIN$", curFriendUin, false, 4, (Object) null);
        return replace$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(long uin, String originUrl, QQAppInterface app, com.tencent.aio.api.runtime.a context) {
        FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        String g16 = context.g().r().c().g();
        ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(requireActivity, c(originUrl, String.valueOf(uin)), 2053, new EntryModel(0, uin, g16, false), null);
        IRuntimeService runtimeService = app.getRuntimeService(IRedTouchManager.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(\n \u2026ssConstant.MAIN\n        )");
        IRedTouchManager iRedTouchManager = (IRedTouchManager) runtimeService;
        iRedTouchManager.onRedTouchItemClick(iRedTouchManager.getAppInfoByPath("110000"), "");
        ReportController.o(null, "dc00898", "", "", "0X800A120", "0X800A120", 0, 0, "", "", "", "");
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(com.tencent.qqnt.pluspanel.data.a data, final com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        final String a16 = data.a();
        if (a16 == null) {
            QLog.i("PlayTogetherOnClickProcessor", 1, "[onClick]: originUrl is null");
        } else {
            com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.PlayTogetherOnClickProcessor$onClick$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Long l3, QQAppInterface qQAppInterface) {
                    invoke(l3.longValue(), qQAppInterface);
                    return Unit.INSTANCE;
                }

                public final void invoke(long j3, QQAppInterface app) {
                    Intrinsics.checkNotNullParameter(app, "app");
                    PlayTogetherOnClickProcessor.this.d(j3, a16, app, context);
                }
            });
        }
    }
}
