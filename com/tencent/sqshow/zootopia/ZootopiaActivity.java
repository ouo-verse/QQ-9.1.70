package com.tencent.sqshow.zootopia;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.FragmentSource;
import com.tencent.mobileqq.zootopia.Source;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.api.c;
import com.tencent.mobileqq.zplan.api.IZPlanShareApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.fragment.ZootopiaBaseFragment;
import com.tencent.sqshow.zootopia.ZootopiaActivity;
import com.tencent.sqshow.zootopia.player.h;
import com.tencent.sqshow.zootopia.recommend.common.event.ZplanConfigChangeEvent;
import com.tencent.sqshow.zootopia.role.fragment.CreateRoleFragment;
import cooperation.qzone.QzoneIPCModule;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import n74.aq;
import p74.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 <2\u00020\u0001:\u0001=B\u0007\u00a2\u0006\u0004\b:\u0010;J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0012\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0010\u001a\u00020\u0002H\u0014J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0002H\u0016J\"\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0014J\b\u0010\u001d\u001a\u00020\u0002H\u0014J\b\u0010\u001e\u001a\u00020\u0002H\u0014J\b\u0010\u001f\u001a\u00020\bH\u0014J\u001a\u0010#\u001a\u00020\b2\u0006\u0010 \u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016J\b\u0010$\u001a\u00020\u0002H\u0016J\b\u0010%\u001a\u00020\u0002H\u0014J\u0006\u0010&\u001a\u00020\u0002J\u000e\u0010(\u001a\u00020\u00022\u0006\u0010'\u001a\u00020\nJ\b\u0010)\u001a\u00020\bH\u0014R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00105\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b3\u00104R\u0014\u00109\u001a\u0002068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u00108\u00a8\u0006>"}, d2 = {"Lcom/tencent/sqshow/zootopia/ZootopiaActivity;", "Lcom/tencent/mobileqq/app/QBaseActivity;", "", "K2", "", "H2", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "", "requestedOrientation", "setRequestedOrientation", "Landroid/content/res/Configuration;", "newConfig", "doOnConfigurationChanged", "doOnResume", "Landroid/content/res/Resources;", "getResources", "", "name", "", "getSystemService", "onPostThemeChanged", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "doOnPause", "doOnDestroy", "isWrapContent", "keyCode", "Landroid/view/KeyEvent;", "event", "onKeyDown", "finish", "doFinish", "I2", "animResId", "M2", "onBackEvent", "Ln74/aq;", "a0", "Ln74/aq;", "binding", "b0", "Z", "needGestureBack", "c0", "disableExitAnim", "d0", "I", "mExitAnim", "Lp74/a;", "e0", "Lp74/a;", "zplanTheme", "<init>", "()V", "f0", "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public class ZootopiaActivity extends QBaseActivity {

    /* renamed from: f0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private aq binding;

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    private boolean disableExitAnim;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    private boolean needGestureBack = true;

    /* renamed from: d0, reason: collision with root package name and from kotlin metadata */
    private int mExitAnim = R.anim.f154376jx;

    /* renamed from: e0, reason: collision with root package name and from kotlin metadata */
    private final a zplanTheme = new a(this);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001e\u0010\u001fJF\u0010\u000f\u001a\u00020\u000e\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\r\u001a\u00020\fH\u0007JD\u0010\u0013\u001a\u00020\u000e\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007JP\u0010\u0018\u001a\u00020\u0017\"\b\b\u0000\u0010\u0003*\u00020\u0002\"\b\b\u0001\u0010\u0015*\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001c\u001a\u00020\u00198\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u00198\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/sqshow/zootopia/ZootopiaActivity$a;", "", "Landroidx/fragment/app/Fragment;", "T", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "fragClazz", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "from", "Landroid/os/Bundle;", "bundle", "", "isSingleTop", "", "b", "Landroid/app/Activity;", "", "requestCode", "d", "Lcom/tencent/sqshow/zootopia/ZootopiaActivity;", "Z", "activityClazz", "Landroid/content/Intent;", "a", "", "KEY_FRAGMENT_CLASS", "Ljava/lang/String;", "KEY_NEED_GESTURE_BACK", "TAG", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.ZootopiaActivity$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final <T extends Fragment, Z extends ZootopiaActivity> Intent a(Context context, Class<Z> activityClazz, Class<T> fragClazz, ZootopiaSource from, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(activityClazz, "activityClazz");
            Intrinsics.checkNotNullParameter(fragClazz, "fragClazz");
            Intrinsics.checkNotNullParameter(from, "from");
            Intent intent = new Intent(context, (Class<?>) activityClazz);
            if (from.getMainSource() == Source.ProfileEntry) {
                intent.putExtra(ZootopiaSource.KEY_FRAGMENT_SOURCE, new FragmentSource(Source.Profile, from));
            } else {
                intent.putExtra(ZootopiaSource.KEY_FRAGMENT_SOURCE, new FragmentSource(Source.ZootopiaActivity, from));
            }
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("key_fragment_class", fragClazz.getName());
            return intent;
        }

        @JvmStatic
        public final <T extends Fragment> void b(Context context, Class<T> fragClazz, ZootopiaSource from, Bundle bundle, boolean isSingleTop) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragClazz, "fragClazz");
            Intrinsics.checkNotNullParameter(from, "from");
            Intent a16 = a(context, ZootopiaActivity.class, fragClazz, from, bundle);
            if (!(context instanceof Activity)) {
                a16.addFlags(268435456);
                if (isSingleTop) {
                    a16.addFlags(536870912);
                }
            }
            context.startActivity(a16);
        }

        @JvmStatic
        public final <T extends Fragment> void d(Activity context, Class<T> fragClazz, int requestCode, ZootopiaSource from, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(fragClazz, "fragClazz");
            Intrinsics.checkNotNullParameter(from, "from");
            context.startActivityForResult(a(context, ZootopiaActivity.class, fragClazz, from, bundle), requestCode);
        }

        Companion() {
        }

        public static /* synthetic */ void e(Companion companion, Activity activity, Class cls, int i3, ZootopiaSource zootopiaSource, Bundle bundle, int i16, Object obj) {
            if ((i16 & 16) != 0) {
                bundle = null;
            }
            companion.d(activity, cls, i3, zootopiaSource, bundle);
        }

        public static /* synthetic */ void c(Companion companion, Context context, Class cls, ZootopiaSource zootopiaSource, Bundle bundle, boolean z16, int i3, Object obj) {
            if ((i3 & 8) != 0) {
                bundle = null;
            }
            Bundle bundle2 = bundle;
            if ((i3 & 16) != 0) {
                z16 = false;
            }
            companion.b(context, cls, zootopiaSource, bundle2, z16);
        }
    }

    private final long H2() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        long j3 = 0;
        for (Fragment fragment : fragments) {
            boolean z16 = fragment instanceof ZootopiaBaseFragment;
            ZootopiaBaseFragment zootopiaBaseFragment = z16 ? (ZootopiaBaseFragment) fragment : null;
            if (zootopiaBaseFragment != null) {
                zootopiaBaseFragment.beforeFinish();
            }
            ZootopiaBaseFragment zootopiaBaseFragment2 = z16 ? (ZootopiaBaseFragment) fragment : null;
            j3 = RangesKt___RangesKt.coerceAtLeast(j3, zootopiaBaseFragment2 != null ? zootopiaBaseFragment2.xh() : 0L);
        }
        return j3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(ZootopiaActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.K2();
    }

    private final void K2() {
        long H2 = H2();
        if (H2 == 0) {
            doFinish();
        } else {
            ThreadManagerV2.getUIHandlerV2().postDelayed(new Runnable() { // from class: v74.b
                @Override // java.lang.Runnable
                public final void run() {
                    ZootopiaActivity.L2(ZootopiaActivity.this);
                }
            }, H2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L2(ZootopiaActivity this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.doFinish();
    }

    public final void M2(int animResId) {
        this.mExitAnim = animResId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doFinish() {
        super.finish();
        if (this.disableExitAnim) {
            overridePendingTransition(0, 0);
        } else {
            overridePendingTransition(0, this.mExitAnim);
        }
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        for (Fragment fragment : fragments) {
            ZootopiaBaseFragment zootopiaBaseFragment = fragment instanceof ZootopiaBaseFragment ? (ZootopiaBaseFragment) fragment : null;
            if (zootopiaBaseFragment != null) {
                zootopiaBaseFragment.Eh();
            }
        }
        h.f372229a.a(this);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnConfigurationChanged(Configuration newConfig) {
        super.doOnConfigurationChanged(newConfig);
        QLog.i("ZootopiaCommonActivity", 1, "doOnConfigurationChanged - " + this);
        SimpleEventBus.getInstance().dispatchEvent(new ZplanConfigChangeEvent(newConfig));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        Object firstOrNull;
        QLog.i("ZootopiaCommonActivity", 1, "doOnCreate - " + this + ", savedInstanceState = " + savedInstanceState);
        boolean doOnCreate = super.doOnCreate(savedInstanceState);
        aq g16 = aq.g(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(g16, "inflate(layoutInflater)");
        this.binding = g16;
        if (g16 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            g16 = null;
        }
        setContentView(g16.getRoot());
        com.tencent.sqshow.zootopia.utils.a.a(this);
        this.needGestureBack = getIntent().getBooleanExtra("key_need_gesture_back", true);
        String stringExtra = getIntent().getStringExtra("key_fragment_class");
        if (stringExtra == null) {
            return doOnCreate;
        }
        try {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) fragments);
            Fragment fragment = (Fragment) firstOrNull;
            if (fragment instanceof CreateRoleFragment) {
                QLog.d("ZootopiaCommonActivity", 1, "skip create Fragment ==> " + fragment);
            } else {
                Object newInstance = Class.forName(stringExtra).newInstance();
                Fragment fragment2 = newInstance instanceof Fragment ? (Fragment) newInstance : null;
                if (fragment2 == null) {
                    return doOnCreate;
                }
                fragment2.setArguments(getIntent().getExtras());
                getSupportFragmentManager().beginTransaction().replace(R.id.pvw, fragment2).commitAllowingStateLoss();
            }
        } catch (ClassNotFoundException e16) {
            QLog.e("ZootopiaCommonActivity", 1, "class for name " + stringExtra + " failed.", e16);
        }
        return doOnCreate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        ((IZPlanShareApi) QRoute.api(IZPlanShareApi.class)).setPreRecordShareListener(null);
        QLog.i("ZootopiaCommonActivity", 1, "doOnDestroy - " + this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        if (QLog.isColorLevel()) {
            QLog.d("ZootopiaCommonActivity", 1, "doOnResume");
        }
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity
    public void finish() {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: v74.a
            @Override // java.lang.Runnable
            public final void run() {
                ZootopiaActivity.J2(ZootopiaActivity.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, mqq.app.AppActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        a aVar = this.zplanTheme;
        Resources resources = super.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "super.getResources()");
        return aVar.b(resources);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (Intrinsics.areEqual("layout_inflater", name)) {
            Object systemService = super.getSystemService(name);
            if (systemService instanceof LayoutInflater) {
                return this.zplanTheme.a((LayoutInflater) systemService);
            }
        }
        return super.getSystemService(name);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    /* renamed from: isWrapContent, reason: from getter */
    public boolean getNeedGestureBack() {
        return this.needGestureBack;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Object obj;
        super.onActivityResult(requestCode, resultCode, data);
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        Iterator<T> it = fragments.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            } else {
                obj = it.next();
                if (((Fragment) obj).isVisible()) {
                    break;
                }
            }
        }
        Fragment fragment = (Fragment) obj;
        if (fragment != null) {
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseActivity
    public boolean onBackEvent() {
        Object firstOrNull;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) fragments);
        Fragment fragment = (Fragment) firstOrNull;
        BasePartFragment basePartFragment = fragment instanceof BasePartFragment ? (BasePartFragment) fragment : null;
        if (basePartFragment != null) {
            return basePartFragment.onBackEvent();
        }
        return false;
    }

    @Override // mqq.app.AppActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        boolean J5;
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        Intrinsics.checkNotNullExpressionValue(fragments, "supportFragmentManager.fragments");
        loop0: while (true) {
            for (ActivityResultCaller activityResultCaller : fragments) {
                c cVar = activityResultCaller instanceof c ? (c) activityResultCaller : null;
                J5 = cVar != null ? cVar.J5(event) : false;
            }
        }
        if (J5) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override // com.tencent.mobileqq.app.QBaseActivity, com.tencent.mobileqq.app.ISkinCallback, com.tencent.theme.SkinnableActivityProcesser.Callback
    public void onPostThemeChanged() {
        super.onPostThemeChanged();
        QLog.i("ZootopiaCommonActivity", 1, "onPostThemeChanged");
        com.tencent.sqshow.zootopia.utils.a.a(this);
    }

    @Override // mqq.app.AppActivity, android.app.Activity
    public void setRequestedOrientation(int requestedOrientation) {
        super.setRequestedOrientation(requestedOrientation);
        QLog.i("ZootopiaCommonActivity", 1, "setRequestedOrientation", new Exception());
    }

    public final void I2() {
        this.disableExitAnim = true;
    }
}
