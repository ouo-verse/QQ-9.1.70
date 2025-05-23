package com.tencent.mobileqq.vas.adv.negativefeedback.common;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.vas.adv.api.INFBApi;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.HashMap;
import java.util.HashSet;
import jz2.NFBBusinessInfo;
import jz2.b;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import lz2.a;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\f\u0010\u000b\u001a\u00020\u0002*\u00020\u0006H\u0002J\u001a\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u001a\u0010\u0014\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\tJ\u001a\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015R+\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0018j\b\u0012\u0004\u0012\u00020\u0002`\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR7\u0010#\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f0\u001ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u001f` 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u001a\u001a\u0004\b!\u0010\"R7\u0010&\u001a\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t0\u001ej\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\t` 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b$\u0010\u001a\u001a\u0004\b%\u0010\"R\u001b\u0010(\u001a\u00020\u00048FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b$\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/mobileqq/vas/adv/negativefeedback/common/QPublicAccountNFBController;", "Lcom/tencent/mobileqq/app/lifecycle/DefaultBaseActivityLifecycleCallback;", "", "busiId", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "l", "Ljz2/a;", "k", "e", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnActivityCreate", "doOnActivityOnStart", "doOnActivityStopped", "doOnActivityDestroyed", "info", DomainData.DOMAIN_NAME, "Landroid/view/MotionEvent;", "event", "f", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "Lkotlin/Lazy;", "i", "()Ljava/util/HashSet;", "mRegisteredBusinessSet", "Ljava/util/HashMap;", "Llz2/a;", "Lkotlin/collections/HashMap;", "j", "()Ljava/util/HashMap;", "mRunningBusinessMap", h.F, "g", "mBusinessExtraMap", "()Z", "mNFBEnabled", "<init>", "()V", "vas-adv-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class QPublicAccountNFBController extends DefaultBaseActivityLifecycleCallback {

    /* renamed from: d, reason: collision with root package name */
    @NotNull
    public static final QPublicAccountNFBController f308109d = new QPublicAccountNFBController();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mRegisteredBusinessSet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mRunningBusinessMap;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mBusinessExtraMap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Lazy mNFBEnabled;

    static {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        Lazy lazy4;
        QRoute.api(INFBApi.class);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<HashSet<String>>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.common.QPublicAccountNFBController$mRegisteredBusinessSet$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashSet<String> invoke() {
                HashSet<String> hashSet = new HashSet<>();
                String[] REGISTERED_BUSINESS = b.f411253a;
                Intrinsics.checkNotNullExpressionValue(REGISTERED_BUSINESS, "REGISTERED_BUSINESS");
                CollectionsKt__MutableCollectionsKt.addAll(hashSet, REGISTERED_BUSINESS);
                return hashSet;
            }
        });
        mRegisteredBusinessSet = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, a>>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.common.QPublicAccountNFBController$mRunningBusinessMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, a> invoke() {
                return new HashMap<>();
            }
        });
        mRunningBusinessMap = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<HashMap<String, NFBBusinessInfo>>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.common.QPublicAccountNFBController$mBusinessExtraMap$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final HashMap<String, NFBBusinessInfo> invoke() {
                return new HashMap<>();
            }
        });
        mBusinessExtraMap = lazy3;
        lazy4 = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>() { // from class: com.tencent.mobileqq.vas.adv.negativefeedback.common.QPublicAccountNFBController$mNFBEnabled$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final Boolean invoke() {
                return Boolean.valueOf(((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("105828", true));
            }
        });
        mNFBEnabled = lazy4;
    }

    QPublicAccountNFBController() {
    }

    private final String e(Activity activity) {
        return String.valueOf(activity.hashCode());
    }

    private final HashMap<String, NFBBusinessInfo> g() {
        return (HashMap) mBusinessExtraMap.getValue();
    }

    private final HashSet<String> i() {
        return (HashSet) mRegisteredBusinessSet.getValue();
    }

    private final HashMap<String, a> j() {
        return (HashMap) mRunningBusinessMap.getValue();
    }

    private final NFBBusinessInfo k(Activity activity) {
        String stringExtra;
        Bundle bundleExtra;
        Intent intent = activity.getIntent();
        if (intent != null && (stringExtra = intent.getStringExtra("negative_feedback_business_id")) != null) {
            NFBBusinessInfo nFBBusinessInfo = new NFBBusinessInfo(stringExtra, null, null, null, null, null, null, null, null, null, null, null, 4094, null);
            Intent intent2 = activity.getIntent();
            if (intent2 != null && (bundleExtra = intent2.getBundleExtra("negative_feedback_business_extras")) != null) {
                String str = "";
                String string = bundleExtra.getString("adpos_id", "");
                if (string == null) {
                    string = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string, "it1.getString(NegativeFB\u2026.KEY_AD_POS_ID, \"\") ?: \"\"");
                }
                nFBBusinessInfo.n(string);
                String string2 = bundleExtra.getString("ad_id", "");
                if (string2 == null) {
                    string2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(string2, "it1.getString(NegativeFB\u2026ants.KEY_AD_ID, \"\") ?: \"\"");
                }
                nFBBusinessInfo.m(string2);
                String string3 = bundleExtra.getString("item_id", "");
                if (string3 != null) {
                    Intrinsics.checkNotNullExpressionValue(string3, "it1.getString(NegativeFB\u2026ts.KEY_ITEM_ID, \"\") ?: \"\"");
                    str = string3;
                }
                nFBBusinessInfo.o(str);
                return nFBBusinessInfo;
            }
            return nFBBusinessInfo;
        }
        return g().get(e(activity));
    }

    private final boolean l(Activity activity) {
        return j().containsKey(e(activity));
    }

    private final boolean m(String busiId) {
        return i().contains(busiId);
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityCreate(@NotNull Activity activity, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        NFBBusinessInfo k3 = k(activity);
        if (k3 != null && m(k3.getBusiId()) && !l(activity)) {
            com.tencent.mobileqq.vas.adv.negativefeedback.core.impl.a aVar = new com.tencent.mobileqq.vas.adv.negativefeedback.core.impl.a(k3);
            g().clear();
            j().put(e(activity), aVar);
            aVar.c(activity, savedInstanceState);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityDestroyed(@NotNull Activity activity) {
        a remove;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (l(activity) && (remove = j().remove(e(activity))) != null) {
            remove.onActivityDestroy(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityOnStart(@NotNull Activity activity) {
        a aVar;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (l(activity) && (aVar = j().get(e(activity))) != null) {
            aVar.a(activity);
        }
    }

    @Override // com.tencent.mobileqq.app.lifecycle.DefaultBaseActivityLifecycleCallback, com.tencent.mobileqq.app.lifecycle.BaseActivityLifecycleCallbacks
    public void doOnActivityStopped(@NotNull Activity activity) {
        a aVar;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (l(activity) && (aVar = j().get(e(activity))) != null) {
            aVar.onActivityStop(activity);
        }
    }

    public final void f(@Nullable Activity activity, @Nullable MotionEvent event) {
        a aVar;
        if (activity != null && event != null && h() && (aVar = j().get(e(activity))) != null) {
            aVar.b(activity, event);
        }
    }

    public final boolean h() {
        return ((Boolean) mNFBEnabled.getValue()).booleanValue();
    }

    public final void n(@Nullable Activity activity, @Nullable NFBBusinessInfo info) {
        if (activity == null || info == null || !h() || !m(info.getBusiId())) {
            return;
        }
        g().put(e(activity), info);
    }
}
