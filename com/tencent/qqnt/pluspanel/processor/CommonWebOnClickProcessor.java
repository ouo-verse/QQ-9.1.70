package com.tencent.qqnt.pluspanel.processor;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import com.tencent.aio.data.AIOSession;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.sdk.EntryModel;
import com.tencent.mobileqq.mini.utils.SchemaUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.network.session.cache.SessionDbHelper;
import java.net.URI;
import java.net.URISyntaxException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.AppRuntime;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0017\u0010\u0018J0\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J0\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J \u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/CommonWebOnClickProcessor;", "Lcom/tencent/qqnt/pluspanel/logic/b;", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lmqq/app/AppRuntime;", "app", "", "uin", "Lcom/tencent/qqnt/pluspanel/data/a;", "data", "Lcom/tencent/aio/data/AIOSession;", SessionDbHelper.SESSION_ID, "", "e", "Lcom/tencent/mobileqq/app/QQAppInterface;", "", "f", "", "origUrl", "d", "Lcom/tencent/aio/api/runtime/a;", "context", "a", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CommonWebOnClickProcessor implements com.tencent.qqnt.pluspanel.logic.b {

    /* renamed from: a, reason: collision with root package name */
    private static final a f360463a = new a(null);

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/pluspanel/processor/CommonWebOnClickProcessor$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "base_proj_nt_ext_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    private final String d(String origUrl, com.tencent.qqnt.pluspanel.data.a data, AIOSession session) {
        String replace$default;
        if ((origUrl.length() == 0) || 102007304 != data.c()) {
            return origUrl;
        }
        replace$default = StringsKt__StringsJVMKt.replace$default(origUrl, "$GTYPE$", String.valueOf(session.c().e() == 2 ? 2 : 1), false, 4, (Object) null);
        return replace$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean e(Activity activity, AppRuntime app, long uin, com.tencent.qqnt.pluspanel.data.a data, AIOSession session) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        EntryModel entryModel;
        String k3 = data.k();
        if ((k3 == null || k3.length() == 0) || !((IMiniAppService) QRoute.api(IMiniAppService.class)).isMiniAppUrl(data.k())) {
            return false;
        }
        QLog.i("CommonWebOnClickProcessor", 1, "troopFormLog openMiniApp:url :" + data.k());
        String k16 = data.k();
        Intrinsics.checkNotNull(k16);
        String currentAccountUin = app.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        replace$default = StringsKt__StringsJVMKt.replace$default(k16, "$UIN$", currentAccountUin, false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$GCODE$", String.valueOf(uin), false, 4, (Object) null);
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "$APPID$", String.valueOf(data.c()), false, 4, (Object) null);
        if (session.c().e() == 2) {
            entryModel = new EntryModel(1, uin, session.c().g(), false);
        } else {
            entryModel = new EntryModel(0, uin, session.c().g(), false);
        }
        return ((IMiniAppService) QRoute.api(IMiniAppService.class)).startMiniApp(activity, replace$default3, 2052, entryModel, null);
    }

    @Override // com.tencent.qqnt.pluspanel.logic.b
    public void a(final com.tencent.qqnt.pluspanel.data.a data, com.tencent.aio.api.runtime.a context) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(context, "context");
        final AIOSession r16 = context.g().r();
        final FragmentActivity requireActivity = context.c().requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "context.fragment.requireActivity()");
        com.tencent.qqnt.pluspanel.processor.util.a.f360544a.a(context, new Function2<Long, QQAppInterface, Unit>() { // from class: com.tencent.qqnt.pluspanel.processor.CommonWebOnClickProcessor$onClick$1
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
                boolean e16;
                Intrinsics.checkNotNullParameter(app, "app");
                e16 = CommonWebOnClickProcessor.this.e(requireActivity, app, j3, data, r16);
                if (e16) {
                    return;
                }
                CommonWebOnClickProcessor.this.f(requireActivity, app, j3, data, r16);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void f(Activity activity, QQAppInterface app, long uin, com.tencent.qqnt.pluspanel.data.a data, AIOSession session) {
        String replace$default;
        String replace$default2;
        String replace$default3;
        ax c16;
        String k3 = data.k();
        boolean z16 = false;
        if (k3 == null || k3.length() == 0) {
            return;
        }
        String k16 = data.k();
        Intrinsics.checkNotNull(k16);
        String currentAccountUin = app.getCurrentAccountUin();
        Intrinsics.checkNotNullExpressionValue(currentAccountUin, "app.currentAccountUin");
        replace$default = StringsKt__StringsJVMKt.replace$default(k16, "$UIN$", currentAccountUin, false, 4, (Object) null);
        replace$default2 = StringsKt__StringsJVMKt.replace$default(replace$default, "$GCODE$", String.valueOf(uin), false, 4, (Object) null);
        replace$default3 = StringsKt__StringsJVMKt.replace$default(replace$default2, "$APPID$", String.valueOf(data.c()), false, 4, (Object) null);
        String d16 = d(replace$default3, data, session);
        try {
            if (TextUtils.equals(new URI(d16).getScheme(), SchemaUtils.SCHEMA_MQQAPI) && (c16 = bi.c(app, activity, d16)) != null) {
                c16.b();
                z16 = true;
            }
        } catch (URISyntaxException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("CommonWebOnClickProcessor", 2, "uri exception: " + e16);
            }
        }
        if (z16) {
            return;
        }
        Intent intent = new Intent(activity, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("url", d16);
        intent.putExtra(AppConstants.LeftViewText.SELFSET_LEFTVIEWTEXT, HardCodeUtil.qqStr(R.string.f171898lr0));
        activity.startActivity(intent);
    }
}
