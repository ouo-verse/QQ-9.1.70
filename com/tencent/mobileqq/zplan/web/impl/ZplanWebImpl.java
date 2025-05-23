package com.tencent.mobileqq.zplan.web.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.zplan.utils.ab;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.ag;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0011R\u0016\u0010\u0017\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/zplan/web/impl/ZplanWebImpl;", "Lcl3/b;", "", "bid", "", "X0", "j", "Landroid/content/Context;", "context", "url", "Landroid/os/Bundle;", "pageBundle", "C0", "", "Y", "", "b", "[Ljava/lang/String;", "offlineResBids", "c", "offlineResBidsDev", "d", "Z", "isResDownloaded", "", "e", "J", "lastCheckTime", "<init>", "()V", "f", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanWebImpl implements cl3.b {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final String[] offlineResBids = {"4942", "5050", "5051"};

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final String[] offlineResBidsDev = {"5036"};

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean isResDownloaded;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private long lastCheckTime;

    private final void X0(final String bid) {
        QLog.d("ZplanWebImpl", 4, ">>loadOfflineRes bid:" + bid);
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.zplan.web.impl.k
            @Override // java.lang.Runnable
            public final void run() {
                ZplanWebImpl.Y0(bid, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Y0(String bid, ZplanWebImpl this$0) {
        Intrinsics.checkNotNullParameter(bid, "$bid");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        HtmlOffline.j(bid, MobileQQ.sMobileQQ.peekAppRuntime(), true, new b(bid, this$0));
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004e A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004f  */
    @Override // cl3.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void C0(final Context context, String url, Bundle pageBundle) {
        boolean isBlank;
        boolean z16;
        boolean isBlank2;
        boolean isBlank3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        final Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        isBlank = StringsKt__StringsJVMKt.isBlank(url);
        if (isBlank) {
            url = "";
            String string = pageBundle != null ? pageBundle.getString("url", "") : null;
            if (string != null) {
                Intrinsics.checkNotNullExpressionValue(string, "pageBundle?.getString(We\u2026nstant.KEY_URL, \"\") ?: \"\"");
                url = string;
            }
            isBlank3 = StringsKt__StringsJVMKt.isBlank(url);
            if (isBlank3) {
                url = null;
            }
        }
        if (url != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(url);
            if (!isBlank2) {
                z16 = false;
                if (z16) {
                    intent.putExtra("url", ag.f373258a.a(url));
                    intent.putExtra("fragment_class", ZPlanCustomTitleWebFragment.class.getCanonicalName());
                    if (pageBundle != null) {
                        pageBundle.putBoolean(QQBrowserActivity.EXTRA_FINISH_ANIMATION_NONE, true);
                        pageBundle.putInt("extra_theme_id", R.style.f173288zx);
                        intent.putExtras(pageBundle);
                    }
                    if (ab.c(url) && ab.d(url)) {
                        ab.a(context, ab.b(url), new Function0<Unit>() { // from class: com.tencent.mobileqq.zplan.web.impl.ZplanWebImpl$openCustomTitleBrowserPage$2
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
                                context.startActivity(intent);
                            }
                        });
                        return;
                    } else {
                        context.startActivity(intent);
                        return;
                    }
                }
                return;
            }
        }
        z16 = true;
        if (z16) {
        }
    }

    @Override // cl3.b
    /* renamed from: Y, reason: from getter */
    public boolean getIsResDownloaded() {
        return this.isResDownloaded;
    }

    @Override // cl3.b
    public void j() {
        QLog.d("ZplanWebImpl", 4, ">>preDownloadOfflineRes isResDownloaded:" + this.isResDownloaded);
        for (String str : this.offlineResBids) {
            X0(str);
        }
        this.lastCheckTime = System.currentTimeMillis();
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/zplan/web/impl/ZplanWebImpl$b", "Lcom/tencent/biz/common/offline/a;", "", "param1", "", "code", "", "loaded", "progress", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.biz.common.offline.a {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f336060d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ZplanWebImpl f336061e;

        b(String str, ZplanWebImpl zplanWebImpl) {
            this.f336060d = str;
            this.f336061e = zplanWebImpl;
        }

        @Override // com.tencent.biz.common.offline.a
        public void loaded(String param1, int code) {
            QLog.d("ZplanWebImpl", 4, ">>preDownloadOfflineRes loaded param1=" + param1 + " code=" + code + " bid = " + this.f336060d);
            HashMap hashMap = new HashMap();
            hashMap.put("k_offline_down_err_code", String.valueOf(code));
            if (code == 0) {
                mb4.c.c(mb4.c.f416532a, "e_offline_down_success", hashMap, false, 4, null);
            } else {
                mb4.c.c(mb4.c.f416532a, "e_offline_down_failed", hashMap, false, 4, null);
            }
            boolean z16 = false;
            boolean z17 = code == 0 || code == 5;
            ZplanWebImpl zplanWebImpl = this.f336061e;
            if (Intrinsics.areEqual(this.f336060d, "4942")) {
                z16 = z17;
            } else if (this.f336061e.isResDownloaded && z17) {
                z16 = true;
            }
            zplanWebImpl.isResDownloaded = z16;
            QLog.d("ZplanWebImpl", 4, ">>loadOfflineRes isResDownloaded:" + this.f336061e.isResDownloaded);
        }

        @Override // com.tencent.biz.common.offline.a
        public void progress(int progress) {
        }
    }
}
