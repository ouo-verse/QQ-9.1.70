package com.tencent.mobileqq.vas.social.config;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.hippy.ZplanVasSquareHippyFragment;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.zootopia.api.IZootopiaC2CApi;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.c2c.ZootopiaC2CAvatarFragment;
import com.tencent.state.VasExtensionsKt;
import com.tencent.state.square.api.FloatPanelParams;
import com.tencent.state.square.api.ISquareHippyEngine;
import com.tencent.state.square.api.ISquareHippyMethodObserver;
import com.tencent.state.square.api.OpenHippyParams;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import mqq.util.WeakReference;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001\u0005B\u0007\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J*\u0010\u0010\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH\u0016J,\u0010\u0013\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J \u0010 \u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eR&\u0010$\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\"0!8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/vas/social/config/i;", "Lcom/tencent/state/square/api/ISquareHippyEngine;", "", "observer", "", "a", "Lcom/tencent/state/square/api/OpenHippyParams;", "params", "", "preloadHippyPage", "Landroid/content/Context;", "context", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "", "isPanel", "openHippyPage", "Lcom/tencent/state/square/api/FloatPanelParams;", WinkDaTongReportConstant.ElementParamValue.MUSIC_FROM_PANEL, "openHippyPanel", "Lorg/json/JSONObject;", "Landroidx/fragment/app/Fragment;", "createHippyFragment", "Lcom/tencent/state/square/api/ISquareHippyMethodObserver;", "addMethodObserver", "removeMethodObserver", "destroyPreloadHippy", "method", "Lcom/tencent/mtt/hippy/common/HippyMap;", "readableMap", "Lcom/tencent/mtt/hippy/modules/Promise;", "promise", "b", "", "Lmqq/util/WeakReference;", "Ljava/util/Map;", "methodObservers", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class i implements ISquareHippyEngine {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Map<String, WeakReference<ISquareHippyMethodObserver>> methodObservers = new LinkedHashMap();

    private final String a(Object observer) {
        return Reflection.getOrCreateKotlinClass(observer.getClass()).getSimpleName() + "#" + System.identityHashCode(observer);
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void addMethodObserver(ISquareHippyMethodObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.methodObservers.put(a(observer), new WeakReference<>(observer));
    }

    public final void b(String method, HippyMap readableMap, Promise promise) {
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(readableMap, "readableMap");
        Iterator<Map.Entry<String, WeakReference<ISquareHippyMethodObserver>>> it = this.methodObservers.entrySet().iterator();
        while (it.hasNext()) {
            ISquareHippyMethodObserver iSquareHippyMethodObserver = it.next().getValue().get();
            if (iSquareHippyMethodObserver != null) {
                iSquareHippyMethodObserver.onMethodCall(method, readableMap, promise);
            }
        }
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public Fragment createHippyFragment(JSONObject params) {
        Intrinsics.checkNotNullParameter(params, "params");
        OpenHippyInfo openHippyInfo = new OpenHippyInfo(params);
        openHippyInfo.framework = HippyQQConstants.HIPPY_VUE;
        openHippyInfo.processName = "main";
        openHippyInfo.fragmentClass = ZplanVasSquareHippyFragment.class;
        openHippyInfo.updateJsBundleType = 1;
        openHippyInfo.isCustomNightMode = true;
        Bundle bundle = openHippyInfo.toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        ZplanVasSquareHippyFragment zplanVasSquareHippyFragment = new ZplanVasSquareHippyFragment();
        Bundle bundle2 = new Bundle();
        bundle2.putBundle("params", bundle);
        zplanVasSquareHippyFragment.setArguments(bundle2);
        return zplanVasSquareHippyFragment;
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void destroyPreloadHippy(OpenHippyParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = params.getBundleName();
        openHippyInfo.framework = HippyQQConstants.HIPPY_VUE;
        openHippyInfo.processName = "main";
        openHippyInfo.domain = params.getDomain();
        openHippyInfo.fragmentClass = ZplanVasSquareHippyFragment.class;
        openHippyInfo.url = params.getUrl();
        openHippyInfo.updateJsBundleType = 1;
        openHippyInfo.isCustomNightMode = true;
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).destroyPreloadHippy(openHippyInfo);
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void openHippyPage(Context context, FragmentManager fragmentManager, OpenHippyParams params, boolean isPanel) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(params, "params");
        boolean z16 = fragmentManager == null;
        QLog.i("VasSquareHippyEngine", 1, "openHippyPage, " + z16 + ", panel:" + isPanel + ", name:" + params.getBundleName() + ", url:" + params.getUrl());
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = params.getBundleName();
        openHippyInfo.framework = HippyQQConstants.HIPPY_VUE;
        openHippyInfo.processName = "main";
        openHippyInfo.domain = params.getDomain();
        openHippyInfo.fragmentClass = ZplanVasSquareHippyFragment.class;
        openHippyInfo.url = params.getUrl();
        openHippyInfo.updateJsBundleType = 1;
        openHippyInfo.isCustomNightMode = true;
        Bundle bundle = openHippyInfo.toBundle();
        bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
        if (context instanceof FragmentActivity) {
            if (isPanel) {
                ZplanVasSquareHippyFragment zplanVasSquareHippyFragment = new ZplanVasSquareHippyFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("params", bundle);
                zplanVasSquareHippyFragment.setArguments(bundle2);
                QRouteApi api = QRoute.api(IZootopiaC2CApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaC2CApi::class.java)");
                IZootopiaC2CApi iZootopiaC2CApi = (IZootopiaC2CApi) api;
                if (fragmentManager == null) {
                    fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(fragmentManager, "context.supportFragmentManager");
                }
                IZootopiaC2CApi.a.a(iZootopiaC2CApi, fragmentManager, com.tencent.sqshow.zootopia.utils.i.b(650), zplanVasSquareHippyFragment, false, 8, null);
                return;
            }
            Intent intent = new Intent();
            intent.putExtra("params", bundle);
            intent.putExtra("public_fragment_window_feature", 1);
            QPublicFragmentActivity.start(context, intent, ZplanVasSquareHippyFragment.class);
        }
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void openHippyPanel(Context context, FragmentManager fragmentManager, OpenHippyParams params, FloatPanelParams panel) {
        Intrinsics.checkNotNullParameter(params, "params");
        Intrinsics.checkNotNullParameter(panel, "panel");
        boolean z16 = fragmentManager == null;
        QLog.i("VasSquareHippyEngine", 1, "openHippyPanel, " + z16 + ", name:" + params.getBundleName() + ", url:" + params.getUrl() + ", " + panel);
        if (context instanceof FragmentActivity) {
            OpenHippyInfo openHippyInfo = new OpenHippyInfo();
            openHippyInfo.bundleName = params.getBundleName();
            openHippyInfo.framework = HippyQQConstants.HIPPY_VUE;
            openHippyInfo.processName = "main";
            openHippyInfo.domain = params.getDomain();
            openHippyInfo.fragmentClass = ZplanVasSquareHippyFragment.class;
            openHippyInfo.url = params.getUrl();
            openHippyInfo.updateJsBundleType = 1;
            openHippyInfo.isCustomNightMode = true;
            Bundle bundle = openHippyInfo.toBundle();
            bundle.putLong(HippyQQConstants.STEP_NAME_OPEN_PAGE_START, System.currentTimeMillis());
            ZplanVasSquareHippyFragment zplanVasSquareHippyFragment = new ZplanVasSquareHippyFragment();
            zplanVasSquareHippyFragment.setArguments(VasExtensionsKt.bundleOf(TuplesKt.to("params", bundle)));
            int height = panel.getHeight();
            int height2 = panel.getHeight();
            boolean isMaskBackground = panel.isMaskBackground();
            boolean isDragViewTransparent = panel.isDragViewTransparent();
            Integer dragHandleResource = panel.getDragHandleResource();
            ZootopiaC2CAvatarFragment b16 = ZootopiaC2CAvatarFragment.INSTANCE.b(new ZootopiaC2CAvatarFragment.Config(height, height2, true, isMaskBackground, isDragViewTransparent, dragHandleResource != null ? dragHandleResource.intValue() : R.drawable.ikd), zplanVasSquareHippyFragment);
            if (fragmentManager == null) {
                fragmentManager = ((FragmentActivity) context).getSupportFragmentManager();
                Intrinsics.checkNotNullExpressionValue(fragmentManager, "context.supportFragmentManager");
            }
            com.tencent.mobileqq.zootopia.utils.d.a(b16, fragmentManager, "SquareHippy");
        }
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void preloadHippyPage(OpenHippyParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        QLog.i("VasSquareHippyEngine", 1, "preloadHippyPage, name:" + params.getBundleName() + ", url:" + params.getUrl());
        OpenHippyInfo openHippyInfo = new OpenHippyInfo();
        openHippyInfo.bundleName = params.getBundleName();
        openHippyInfo.framework = HippyQQConstants.HIPPY_VUE;
        openHippyInfo.processName = "main";
        openHippyInfo.domain = params.getDomain();
        openHippyInfo.fragmentClass = ZplanVasSquareHippyFragment.class;
        openHippyInfo.url = params.getUrl();
        openHippyInfo.updateJsBundleType = 1;
        openHippyInfo.isCustomNightMode = true;
        ((IHippyAccessHelper) QRoute.api(IHippyAccessHelper.class)).preloadHippyPage(openHippyInfo);
    }

    @Override // com.tencent.state.square.api.ISquareHippyEngine
    public void removeMethodObserver(ISquareHippyMethodObserver observer) {
        Intrinsics.checkNotNullParameter(observer, "observer");
        this.methodObservers.remove(a(observer));
    }
}
