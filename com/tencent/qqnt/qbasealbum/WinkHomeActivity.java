package com.tencent.qqnt.qbasealbum;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MotionEvent;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.compat.AndroidOUIWrapperUtil;
import com.tencent.cache.api.Business;
import com.tencent.cache.api.Page;
import com.tencent.cache.api.PageHierarchy;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.route.annotation.RoutePage;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqnt.qbasealbum.album.fragment.QAlbumPickerFragment;
import com.tencent.qqnt.qbasealbum.base.view.QAlbumBaseFragment;
import com.tencent.qqnt.qbasealbum.coroutine.QAlbumCoroutineScopes;
import com.tencent.qqnt.qbasealbum.customization.CustomizationFacade;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import com.tencent.qqnt.qbasealbum.datahub.LocalMediaDataHub;
import com.tencent.qqnt.qbasealbum.inject.QAlbumPickerContext;
import com.tencent.qqnt.qbasealbum.inject.g;
import com.tencent.qqnt.qbasealbum.model.Config;
import com.tencent.qqnt.qbasealbum.model.LocalMediaInfo;
import com.tencent.qqnt.qbasealbum.model.PickerInitBean;
import com.tencent.qqnt.qbasealbum.model.PreviewInitBean;
import com.tencent.qqnt.qbasealbum.urldrawable.AlbumThumbManager;
import cooperation.qzone.QzoneIPCModule;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@RoutePage(desc = "\u76f8\u518c\u4e3b\u9875", path = IPhotoLogicFactory.BASE_ALBUM_HOME_ACTIVITY_URI)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00040\bH\u0002J\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0015J\b\u0010\u0016\u001a\u00020\u0004H\u0016J\u0010\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0004H\u0014J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010 \u001a\u00020\u00042\u0006\u0010!\u001a\u00020\u0012H\u0016J\b\u0010\"\u001a\u00020\u0004H\u0002\u00a8\u0006#"}, d2 = {"Lcom/tencent/qqnt/qbasealbum/WinkHomeActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "getFirstFragment", "", DownloadInfo.spKey_Config, "Lcom/tencent/qqnt/qbasealbum/model/Config;", "callback", "Lkotlin/Function1;", "Lcom/tencent/qqnt/qbasealbum/model/PreviewInitBean;", "isExitAlbum", "", "context", "Landroid/content/Context;", "activityName", "Landroid/content/ComponentName;", "onActivityResult", "requestCode", "", QzoneIPCModule.RESULT_CODE, "data", "Landroid/content/Intent;", "onBackPressed", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", Constants.FILE_INSTANCE_STATE, "Landroid/os/Bundle;", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "onNewIntent", "intent", "setRequestedOrientation", "requestedOrientation", "setSystemUI", "nt_album_kit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Page(business = Business.Album, type = PageHierarchy.MainPage)
/* loaded from: classes25.dex */
public final class WinkHomeActivity extends FragmentActivity {
    static IPatchRedirector $redirector_;

    public WinkHomeActivity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void getFirstFragment(Config config, Function1<? super PreviewInitBean, Unit> callback) {
        HashMap<String, String> c16;
        HashMap<String, String> c17;
        boolean z16;
        HashMap<String, String> c18;
        String stringExtra = getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        getIntent().removeExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
        PickerInitBean pickerInitBean = null;
        if (getIntent().getBooleanExtra("IS_JUMP_TO_PREVIEW", false)) {
            Parcelable parcelableExtra = getIntent().getParcelableExtra("ARG_PREVIEW_INIT_BEAN");
            Intrinsics.checkNotNull(parcelableExtra);
            PreviewInitBean previewInitBean = (PreviewInitBean) parcelableExtra;
            ArrayList<LocalMediaInfo> a16 = previewInitBean.a();
            if (a16.isEmpty()) {
                for (Map.Entry<String, String> entry : config.p().entrySet()) {
                    LocalMediaDataHub.INSTANCE.a().F(entry.getKey(), entry.getValue());
                    com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a17 = CustomizationFacade.f361084a.a();
                    if (a17 != null && (c18 = a17.c()) != null) {
                        c18.put(entry.getKey(), entry.getValue());
                    }
                }
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(QAlbumCoroutineScopes.f361069a.e()), null, null, new WinkHomeActivity$getFirstFragment$2(previewInitBean, this, callback, null), 3, null);
                return;
            }
            ArrayList<LocalMediaInfo> arrayList = new ArrayList();
            for (Object obj : a16) {
                if (((LocalMediaInfo) obj).getPath() != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList();
            for (LocalMediaInfo localMediaInfo : arrayList) {
                LocalMediaDataHub a18 = LocalMediaDataHub.INSTANCE.a();
                String path = localMediaInfo.getPath();
                Intrinsics.checkNotNull(path);
                LocalMediaInfo T = a18.T(path);
                if (T != null) {
                    arrayList2.add(T);
                }
            }
            for (Map.Entry<String, String> entry2 : config.p().entrySet()) {
                LocalMediaDataHub.INSTANCE.a().F(entry2.getKey(), entry2.getValue());
                com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a19 = CustomizationFacade.f361084a.a();
                if (a19 != null && (c17 = a19.c()) != null) {
                    c17.put(entry2.getKey(), entry2.getValue());
                }
            }
            previewInitBean.f(new ArrayList<>(arrayList2));
            com.tencent.qqnt.qbasealbum.album.b.h(this).U1(previewInitBean);
            callback.invoke(previewInitBean);
            return;
        }
        for (Map.Entry<String, String> entry3 : config.p().entrySet()) {
            LocalMediaDataHub.INSTANCE.a().F(entry3.getKey(), entry3.getValue());
            com.tencent.qqnt.qbasealbum.customization.common.b<? extends com.tencent.qqnt.qbasealbum.customization.common.a> a26 = CustomizationFacade.f361084a.a();
            if (a26 != null && (c16 = a26.c()) != null) {
                c16.put(entry3.getKey(), entry3.getValue());
            }
        }
        LocalMediaDataHub.INSTANCE.a().Y(config.o());
        Parcelable parcelableExtra2 = getIntent().getParcelableExtra("ARG_PICKER_INIT_BEAN");
        if (parcelableExtra2 instanceof PickerInitBean) {
            pickerInitBean = (PickerInitBean) parcelableExtra2;
        }
        QAlbumPickerFragment a27 = QAlbumPickerFragment.INSTANCE.a(config, pickerInitBean);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, stringExtra);
        if (pickerInitBean != null) {
            bundle.putParcelable("ARG_PICKER_INIT_BEAN", pickerInitBean);
        }
        bundle.putParcelable("ARG_ALBUM_CONFIG", config);
        a27.setArguments(bundle);
        Unit unit = Unit.INSTANCE;
        beginTransaction.add(R.id.cks, a27).commitAllowingStateLoss();
    }

    private final boolean isExitAlbum(Context context, ComponentName activityName) {
        ActivityManager activityManager;
        ComponentName componentName;
        int i3;
        ComponentName componentName2;
        if (activityName != null) {
            try {
                Object systemService = context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
                if (systemService instanceof ActivityManager) {
                    activityManager = (ActivityManager) systemService;
                } else {
                    activityManager = null;
                }
                if (activityManager != null) {
                    Iterator<ActivityManager.AppTask> it = activityManager.getAppTasks().iterator();
                    while (it.hasNext()) {
                        ActivityManager.RecentTaskInfo taskInfo = it.next().getTaskInfo();
                        if (taskInfo != null) {
                            componentName = taskInfo.topActivity;
                        } else {
                            componentName = null;
                        }
                        if (componentName != null) {
                            i3 = taskInfo.numActivities;
                            if (i3 == 1) {
                                componentName2 = taskInfo.topActivity;
                                Intrinsics.checkNotNull(componentName2);
                                if (Intrinsics.areEqual(componentName2.getClassName(), activityName.getClassName())) {
                                    return true;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                    return false;
                }
                return false;
            } catch (Exception e16) {
                QLog.e("WinkHomeActivity", 1, "isActivityInStack exception: " + e16.getMessage());
                return false;
            }
        }
        return false;
    }

    private final void setSystemUI() {
        getWindow().addFlags(128);
        if (Build.VERSION.SDK_INT >= 29) {
            getWindow().setNavigationBarContrastEnforced(false);
        }
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false);
        getWindow().clearFlags(134217728);
        getWindow().clearFlags(67108864);
        getWindow().addFlags(Integer.MIN_VALUE);
        getWindow().getDecorView().setSystemUiVisibility(getWindow().getDecorView().getSystemUiVisibility() | 1024 | 512 | 256);
        getWindow().setStatusBarColor(0);
        getWindow().setNavigationBarColor(0);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, false, true);
        boolean dispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
        EventCollector.getInstance().onActivityDispatchTouchEvent(this, motionEvent, dispatchTouchEvent, false);
        return dispatchTouchEvent;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    @Deprecated(message = "Deprecated in Java")
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(requestCode), Integer.valueOf(resultCode), data);
        } else {
            super.onActivityResult(requestCode, resultCode, data);
            CustomizationFacade.f361084a.e(requestCode, resultCode, data);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        super.onBackPressed();
        if (QAlbumPickerContext.f361201a.l() instanceof QAlbumBaseFragment) {
            overridePendingTransition(0, R.anim.f154816sj);
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(@NotNull Configuration newConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) newConfig);
        } else {
            Intrinsics.checkNotNullParameter(newConfig, "newConfig");
            com.tencent.qqnt.qbasealbum.utils.d.f361649a.h();
            super.onConfigurationChanged(newConfig);
        }
        EventCollector.getInstance().onActivityConfigurationChanged(this, newConfig);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Class<? extends PickerCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> cls;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) savedInstanceState);
            return;
        }
        if (AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            AndroidOUIWrapperUtil.fixOrientation(this);
        }
        super.onCreate(savedInstanceState);
        setSystemUI();
        setContentView(R.layout.fsy);
        Config config = (Config) getIntent().getParcelableExtra("ARG_ALBUM_CONFIG");
        if (config == null) {
            Config.Companion companion = Config.INSTANCE;
            config = new Config.a().a();
        }
        Intrinsics.checkNotNullExpressionValue(config, "intent.getParcelableExtr\u2026FIG) ?: Config.build {  }");
        com.tencent.qqnt.qbasealbum.album.b.h(this).W1(config.t());
        com.tencent.qqnt.qbasealbum.album.b.h(this).S1(config.b());
        QAlbumPickerContext qAlbumPickerContext = QAlbumPickerContext.f361201a;
        Serializable serializableExtra = getIntent().getSerializableExtra("ARG_PICKER_CUSTOMIZE");
        Class<? extends PreviewCustomizationBase<? extends com.tencent.qqnt.qbasealbum.customization.common.a>> cls2 = null;
        if (serializableExtra instanceof Class) {
            cls = (Class) serializableExtra;
        } else {
            cls = null;
        }
        Serializable serializableExtra2 = getIntent().getSerializableExtra("ARG_PREVIEW_CUSTOMIZE");
        if (serializableExtra2 instanceof Class) {
            cls2 = (Class) serializableExtra2;
        }
        qAlbumPickerContext.m(this, config, cls, cls2);
        qAlbumPickerContext.q(this);
        CustomizationFacade.f361084a.d(getIntent());
        if (!getIntent().getBooleanExtra("IS_JUMP_TO_PREVIEW", false)) {
            overridePendingTransition(R.anim.f154807sa, R.anim.f154808sb);
        }
        getFirstFragment(config, new WinkHomeActivity$onCreate$1(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        super.onDestroy();
        QAlbumPickerContext qAlbumPickerContext = QAlbumPickerContext.f361201a;
        qAlbumPickerContext.s(this);
        if (!qAlbumPickerContext.c().isEmpty() && !isExitAlbum(this, g.f361234b.b())) {
            QLog.d("WinkHomeActivity", 1, "onDestroy, but other winHomeActivity in task!");
            return;
        }
        LocalMediaDataHub.INSTANCE.a().d0();
        qAlbumPickerContext.b(this);
        AlbumThumbManager.INSTANCE.e(this).d();
        qAlbumPickerContext.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(@Nullable Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            super.onNewIntent(intent);
            CustomizationFacade.f361084a.f(intent, this);
        }
    }

    @Override // android.app.Activity
    public void setRequestedOrientation(int requestedOrientation) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, requestedOrientation);
        } else if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
            super.setRequestedOrientation(requestedOrientation);
        }
    }
}
