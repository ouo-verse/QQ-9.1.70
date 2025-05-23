package com.tencent.mobileqq.zplan.cloudmod.impl;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.z1.cloudmod.api.ZPlanCloudGameInfo;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zootopia.view.z;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.authorize.api.EnterModCheckResult;
import com.tencent.mobileqq.zplan.authorize.api.c;
import com.tencent.mobileqq.zplan.cloudmod.api.a;
import com.tencent.mobileqq.zplan.cloudmod.impl.container.ZPlanCloudModFragment;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.utils.CommonExKt;
import com.tencent.sqshow.zootopia.utils.ab;
import com.tencent.util.AppSetting;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Foreground;

/* compiled from: P */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u00010B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J \u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\fH\u0002J[\u0010\u001b\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\b2\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132#\u0010\u001a\u001a\u001f\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\f\u0018\u00010\u0016H\u0016J0\u0010$\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010!\u001a\u00020 2\u0006\u0010#\u001a\u00020\"H\u0016R\u0018\u0010(\u001a\u0004\u0018\u00010%8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010,\u001a\u00020)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+\u00a8\u00061"}, d2 = {"Lcom/tencent/mobileqq/zplan/cloudmod/impl/CloudModApiImpl;", "Lcom/tencent/mobileqq/zplan/cloudmod/api/a;", "", "Z0", "", "b1", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "result", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "", "modId", "", "d1", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "c1", ICustomDataEditor.STRING_ARRAY_PARAM_1, "needServerFullCheck", "", "", "ueParams", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "checkResult", "callback", "T", "Lcom/tencent/mobileqq/z1/cloudmod/api/ZPlanCloudGameInfo;", "cloudGameInfo", "mapId", "modStatus", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/zplan/cloudmod/api/b;", "listener", "S0", "Landroid/app/Dialog;", "b", "Landroid/app/Dialog;", "dialog", "Ljava/util/concurrent/atomic/AtomicBoolean;", "c", "Ljava/util/concurrent/atomic/AtomicBoolean;", "startMapComplete", "<init>", "()V", "d", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class CloudModApiImpl implements a {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private Dialog dialog;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicBoolean startMapComplete = new AtomicBoolean(false);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/zplan/cloudmod/impl/CloudModApiImpl$b", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "result", "", "c", "d", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements com.tencent.mobileqq.zplan.authorize.api.a<EnterModCheckResult> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Map<String, Object> f332600a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CloudModApiImpl f332601b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ ZootopiaSource f332602c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f332603d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1<EnterModCheckResult, Unit> f332604e;

        /* JADX WARN: Multi-variable type inference failed */
        b(Map<String, ? extends Object> map, CloudModApiImpl cloudModApiImpl, ZootopiaSource zootopiaSource, int i3, Function1<? super EnterModCheckResult, Unit> function1) {
            this.f332600a = map;
            this.f332601b = cloudModApiImpl;
            this.f332602c = zootopiaSource;
            this.f332603d = i3;
            this.f332604e = function1;
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(EnterModCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("CloudModApiImpl", 1, "startCloudMod onCheckComplete code=" + result.getResultCode());
            if (result.isPassed()) {
                ZootopiaEnterParams enterParamsAfterCheck = result.getEnterParamsAfterCheck();
                if (enterParamsAfterCheck != null) {
                    enterParamsAfterCheck.setUeParams(this.f332600a);
                }
                this.f332601b.d1(result, this.f332602c, this.f332603d);
            }
            Function1<EnterModCheckResult, Unit> function1 = this.f332604e;
            if (function1 != null) {
                function1.invoke(result);
            }
            this.f332601b.a1();
        }

        @Override // com.tencent.mobileqq.zplan.authorize.api.a
        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(EnterModCheckResult result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("CloudModApiImpl", 1, "onCheckInterceptor");
            this.f332601b.a1();
        }
    }

    private final String Z0() {
        if ((ab.INSTANCE.b().length() == 0) || ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("is_force_cloud_online", true)) {
            return "https://m.gamematrix.qq.com/v2/game?tk=C4Qw5gvAJgHAzAayggTACwFYBYBOA7ARwIGMAzAMgCMBLKCGLAYQCEAxNgTmZgFEBGLDABsKcgGdaEANJoAajwAqjBAAkAmgGUA6gEkAHltYIgA&ixy=1&f5=0&ml=0&channel_type=wz_sing&_fv=0&newDevice=1";
        }
        return "https://m.gamematrix.qq.com/v2/game?tk=C4Qw5gvALArgVjAnoglgNwHYC8MHYwBmAtjAGQBGKAJhABxQDCAQgGKsCcTtAogIxS0AbACZSAZ2oQANtwDiAEQCqsogDUQABVkAZAKZoAGgCcgA&ixy=1&f5=0&ml=0&channel_type=wz_sing&_fv=0&newDevice=1&console=1";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a1() {
        this.startMapComplete.set(true);
        CommonExKt.j(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.CloudModApiImpl$hideDialog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Dialog dialog;
                Dialog dialog2;
                dialog = CloudModApiImpl.this.dialog;
                QLog.i("CloudModApiImpl", 4, "dialog: " + dialog + " dismiss");
                dialog2 = CloudModApiImpl.this.dialog;
                if (dialog2 != null) {
                    dialog2.dismiss();
                }
                CloudModApiImpl.this.dialog = null;
            }
        });
    }

    private final boolean b1() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean("cloud_mod_console", false);
    }

    private final void c1(final Activity activity) {
        CommonExKt.h(new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.cloudmod.impl.CloudModApiImpl$showDilaog$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AtomicBoolean atomicBoolean;
                Dialog dialog;
                Dialog dialog2;
                Activity activity2 = activity;
                if (activity2 != null) {
                    CloudModApiImpl cloudModApiImpl = this;
                    atomicBoolean = cloudModApiImpl.startMapComplete;
                    if (atomicBoolean.get() || activity2.isFinishing() || activity2.isDestroyed()) {
                        return;
                    }
                    cloudModApiImpl.dialog = new z(activity2, true, true);
                    dialog = cloudModApiImpl.dialog;
                    if (dialog != null) {
                        dialog.setCancelable(true);
                    }
                    dialog2 = cloudModApiImpl.dialog;
                    if (dialog2 != null) {
                        dialog2.show();
                    }
                    QLog.d("CloudModApiImpl", 4, "show loading dialog");
                }
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d1(EnterModCheckResult result, ZootopiaSource source, int modId) {
        String str;
        ZootopiaEnterParams enterParamsAfterCheck = result.getEnterParamsAfterCheck();
        if (enterParamsAfterCheck == null || (str = enterParamsAfterCheck.toJsonString()) == null) {
            str = "";
        }
        String encode = URLEncoder.encode(str, "UTF-8");
        QLog.d("CloudModApiImpl", 4, "startCloudFragment encodeString=" + str);
        String Z0 = Z0();
        if (AppSetting.isDebugVersion() && b1()) {
            Z0 = Z0 + "&console=1";
        }
        Uri.Builder buildUpon = Uri.parse(Z0).buildUpon();
        buildUpon.appendQueryParameter("cd_extendInfo", encode);
        QLog.i("CloudModApiImpl", 1, "onCheckComplete :: url == " + buildUpon);
        ZootopiaActivity.Companion companion = ZootopiaActivity.INSTANCE;
        BaseApplication context = BaseApplication.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext()");
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        intent.putExtra("url", buildUpon.toString());
        intent.putExtra("modId", modId);
        intent.putExtra(OpenHippyInfo.EXTRA_KEY_IS_FULL_SCREEN, true);
        bundle.putParcelable("intent", intent);
        bundle.putBoolean("key_need_gesture_back", false);
        Unit unit = Unit.INSTANCE;
        ZootopiaActivity.Companion.c(companion, context, ZPlanCloudModFragment.class, source, bundle, false, 16, null);
        mg3.a aVar = mg3.a.f416730a;
        ZootopiaEnterParams enterParamsAfterCheck2 = result.getEnterParamsAfterCheck();
        Intrinsics.checkNotNull(enterParamsAfterCheck2);
        aVar.c(modId, enterParamsAfterCheck2.getVersion(), source);
    }

    @Override // com.tencent.mobileqq.zplan.cloudmod.api.a
    public void S0(ZPlanCloudGameInfo cloudGameInfo, int mapId, int modStatus, Context context, com.tencent.mobileqq.zplan.cloudmod.api.b listener) {
        Intrinsics.checkNotNullParameter(cloudGameInfo, "cloudGameInfo");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(listener, "listener");
        hg3.a.f404857a.b(cloudGameInfo, mapId, modStatus, new WeakReference<>(context), listener);
    }

    @Override // com.tencent.mobileqq.zplan.cloudmod.api.a
    public void T(int modId, boolean needServerFullCheck, ZootopiaSource source, Map<String, ? extends Object> ueParams, Function1<? super EnterModCheckResult, Unit> callback) {
        Intrinsics.checkNotNullParameter(source, "source");
        QLog.i("CloudModApiImpl", 1, "startCloudMod modId=" + modId + ", needServerFullCheck=" + needServerFullCheck + " source=" + source);
        ZootopiaEnterParams a16 = ZootopiaEnterParams.INSTANCE.a(modId, "");
        a16.setUeParams(ueParams);
        c1(Foreground.getTopActivity());
        ((c) vb3.a.f441346a.a(c.class)).I(a16, source, needServerFullCheck, new b(ueParams, this, source, modId, callback));
    }
}
