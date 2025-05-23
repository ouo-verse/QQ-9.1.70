package com.tencent.mobileqq.aio.animation.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IAIOHttpApi;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001f\u0010 J5\u0010\u000b\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012J\u0016\u0010\u0017\u001a\u00020\t2\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0015J\u000e\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0016\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002R\u001e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001d\u00a8\u0006!"}, d2 = {"Lcom/tencent/mobileqq/aio/animation/util/AioAnimationConfigHolder;", "", "", "url", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "", "onComplete", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "j", "Landroid/content/SharedPreferences;", "f", "Landroid/content/Context;", "context", h.F, "", "Lcom/tencent/mobileqq/aio/animation/config/a;", "e", "Ljava/util/ArrayList;", "rules", "l", "g", "", "serverVersion", "k", "b", "Ljava/util/ArrayList;", "mAnimationRules", "<init>", "()V", "aio_animation_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class AioAnimationConfigHolder {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final AioAnimationConfigHolder f188156a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static ArrayList<com.tencent.mobileqq.aio.animation.config.a> mAnimationRules;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(29839);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f188156a = new AioAnimationConfigHolder();
        }
    }

    AioAnimationConfigHolder() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final SharedPreferences f() {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(MobileQQ.sMobileQQ, "AioAnimationConfigHelper_SP_" + MobileQQ.sMobileQQ.peekAppRuntime().getAccount(), "common_mmkv_configurations");
        Intrinsics.checkNotNullExpressionValue(fromSpAdapter, "fromSpAdapter(MobileQQ.s\u2026e, QMMKVFile.FILE_COMMON)");
        return fromSpAdapter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h(final Context context) {
        if (e() != null) {
            if (QLog.isDevelopLevel()) {
                QLog.d("AioAnimationConfigHolder", 4, "loadEggConfig, already loaded");
                return;
            }
            return;
        }
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.util.c
            @Override // java.lang.Runnable
            public final void run() {
                AioAnimationConfigHolder.i(context);
            }
        }, 64, null, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i(Context context) {
        Integer num;
        Intrinsics.checkNotNullParameter(context, "$context");
        ArrayList<com.tencent.mobileqq.aio.animation.config.a> g16 = b.f188159a.g(context);
        if (g16 != null) {
            num = Integer.valueOf(g16.size());
        } else {
            num = null;
        }
        QLog.i("AioAnimationConfigHolder", 1, "loadEggConfig, from xml, rules: " + num);
        f188156a.l(g16);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void j() {
        f().edit().putString("KEY_EGG_FILE_CONFIG_URL", "").apply();
    }

    private final void m(final String url, final Function1<? super Boolean, Unit> onComplete) {
        if (TextUtils.isEmpty(url)) {
            QLog.i("AioAnimationConfigHolder", 1, "updateResources, url is empty");
        } else {
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.aio.animation.util.d
                @Override // java.lang.Runnable
                public final void run() {
                    AioAnimationConfigHolder.n(url, onComplete);
                }
            }, 128, null, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(String str, Function1 onComplete) {
        Intrinsics.checkNotNullParameter(onComplete, "$onComplete");
        if (Intrinsics.areEqual(str, "#test#")) {
            QLog.i("AioAnimationConfigHolder", 1, "unzip local file");
            onComplete.invoke(Boolean.TRUE);
        } else {
            String modifiedUrl = MsfSdkUtils.insertMtype("ConfigCheck", str);
            IAIOHttpApi iAIOHttpApi = (IAIOHttpApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IAIOHttpApi.class);
            Intrinsics.checkNotNullExpressionValue(modifiedUrl, "modifiedUrl");
            onComplete.invoke(Boolean.valueOf(iAIOHttpApi.download(modifiedUrl, new File(b.f188159a.d()))));
        }
    }

    @Nullable
    public final synchronized List<com.tencent.mobileqq.aio.animation.config.a> e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return mAnimationRules;
    }

    public final void g(@NotNull final Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) context);
            return;
        }
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences f16 = f();
        final long j3 = f16.getLong("k_eggs_file_version", 0L);
        final String string = f16.getString("KEY_EGG_FILE_CONFIG_URL", "");
        if (TextUtils.isEmpty(string)) {
            QLog.i("AioAnimationConfigHolder", 1, "loadAndUpdateRules, no need update, version=" + j3);
            Context applicationContext = MobileQQ.sMobileQQ.getApplicationContext();
            Intrinsics.checkNotNullExpressionValue(applicationContext, "sMobileQQ.applicationContext");
            h(applicationContext);
            return;
        }
        QLog.i("AioAnimationConfigHolder", 1, "loadAndUpdateRules, start to update, version=" + j3 + " url=" + string);
        m(string, new Function1<Boolean, Unit>(context, j3, string) { // from class: com.tencent.mobileqq.aio.animation.util.AioAnimationConfigHolder$loadAndUpdateRules$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Context $context;
            final /* synthetic */ String $url;
            final /* synthetic */ long $version;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$context = context;
                this.$version = j3;
                this.$url = string;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, context, Long.valueOf(j3), string);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                    return;
                }
                if (z16) {
                    b bVar = b.f188159a;
                    ArrayList<com.tencent.mobileqq.aio.animation.config.a> h16 = bVar.h(this.$context, bVar.d());
                    if (h16 != null) {
                        AioAnimationConfigHolder aioAnimationConfigHolder = AioAnimationConfigHolder.f188156a;
                        aioAnimationConfigHolder.j();
                        aioAnimationConfigHolder.l(h16);
                        QLog.i("AioAnimationConfigHolder", 1, "loadAndUpdateRules, success, version=" + this.$version + ", url=" + this.$url + ", ruleSize=" + h16.size());
                        return;
                    }
                    QLog.w("AioAnimationConfigHolder", 1, "loadAndUpdateRules, parseRulesFromZip failed, url=" + this.$url);
                }
                QLog.i("AioAnimationConfigHolder", 1, "loadAndUpdateRules, failed to update, url=" + this.$url);
                AioAnimationConfigHolder.f188156a.h(this.$context);
            }
        });
    }

    public final void k(long serverVersion, @NotNull String url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, Long.valueOf(serverVersion), url);
            return;
        }
        Intrinsics.checkNotNullParameter(url, "url");
        SharedPreferences f16 = f();
        long j3 = f16.getLong("k_eggs_file_version", 0L);
        QLog.i("AioAnimationConfigHolder", 1, "onConfigVersionUpdate, currentVersion: " + j3 + ", serverVersion: " + serverVersion + ", url: " + url);
        if (serverVersion > 0 && serverVersion != j3 && !TextUtils.isEmpty(url)) {
            f16.edit().putLong("k_eggs_file_version", serverVersion).putString("KEY_EGG_FILE_CONFIG_URL", url).apply();
        }
    }

    public final synchronized void l(@Nullable ArrayList<com.tencent.mobileqq.aio.animation.config.a> rules) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rules);
        } else {
            mAnimationRules = rules;
        }
    }
}
