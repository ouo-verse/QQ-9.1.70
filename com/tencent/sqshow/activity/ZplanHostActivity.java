package com.tencent.sqshow.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qui.QUIImmersiveHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.zplan.utils.api.IUESoLoaderHelper;
import com.tencent.qphone.base.util.QLog;
import i74.a;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.Constants;

/* compiled from: P */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\"\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\u001a\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0002H\u0014J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/sqshow/activity/ZplanHostActivity;", "Lmqq/app/AppActivity;", "", "F2", "Landroid/content/Context;", "newBase", "attachBaseContext", "beforeDoOnCreate", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "doOnResume", "doOnPause", "Landroid/content/Intent;", "intent", "doOnNewIntent", "", "requestCode", "requestCode2", "data", "doOnActivityResult", "doOnBackPressed", "keyCode", "Landroid/view/KeyEvent;", "event", "doOnKeyDown", "doOnDestroy", "finish", "Li74/a;", "a0", "Li74/a;", "mLogic", "<init>", "()V", "b0", "a", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZplanHostActivity extends AppActivity {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private a mLogic;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007J<\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/sqshow/activity/ZplanHostActivity$a;", "", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "Li74/a;", "clazz", "Landroid/os/Bundle;", "params", "", "intentFlags", "", "b", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "requestCode", "d", "", "KEY_LOGIC_CLASS", "Ljava/lang/String;", "TAG", "<init>", "()V", "superqqshow-portal-api_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.activity.ZplanHostActivity$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, Class<? extends a> clazz, Bundle params) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(params, "params");
            c(this, context, clazz, params, 0, 8, null);
        }

        @JvmStatic
        public final void b(Context context, Class<? extends a> clazz, Bundle params, int intentFlags) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(params, "params");
            Intent intent = new Intent(context, (Class<?>) ZplanHostActivity.class);
            intent.putExtras(params);
            intent.putExtra("zplan_activity_logic_class", clazz.getName());
            if (intentFlags != 0) {
                intent.addFlags(intentFlags);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }

        @JvmStatic
        public final void d(Activity activity, Class<? extends a> clazz, Bundle params, int requestCode, int intentFlags) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(params, "params");
            Intent intent = new Intent(activity, (Class<?>) ZplanHostActivity.class);
            intent.putExtras(params);
            intent.putExtra("zplan_activity_logic_class", clazz.getName());
            if (intentFlags != 0) {
                intent.addFlags(intentFlags);
            }
            activity.startActivityForResult(intent, requestCode);
        }

        Companion() {
        }

        public static /* synthetic */ void c(Companion companion, Context context, Class cls, Bundle bundle, int i3, int i16, Object obj) {
            if ((i16 & 4) != 0) {
                bundle = new Bundle();
            }
            if ((i16 & 8) != 0) {
                i3 = 0;
            }
            companion.b(context, cls, bundle, i3);
        }

        public static /* synthetic */ void e(Companion companion, Activity activity, Class cls, Bundle bundle, int i3, int i16, int i17, Object obj) {
            if ((i17 & 4) != 0) {
                bundle = new Bundle();
            }
            Bundle bundle2 = bundle;
            if ((i17 & 16) != 0) {
                i16 = 0;
            }
            companion.d(activity, cls, bundle2, i3, i16);
        }
    }

    static {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ZplanHostActivity.class);
        QUIImmersiveHelper.f(arrayList);
    }

    private final void F2() {
        String stringExtra = getIntent().getStringExtra("zplan_activity_logic_class");
        if (stringExtra == null) {
            return;
        }
        QLog.i("ZPlanHostActivity", 1, "init logic class: " + stringExtra);
        try {
            Object newInstance = Class.forName(stringExtra).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.sqshow.activity.BasicActivityLogic");
            this.mLogic = (a) newInstance;
        } catch (Exception e16) {
            QLog.e("ZPlanHostActivity", 1, e16, new Object[0]);
        }
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.m(this);
        }
    }

    @JvmStatic
    public static final void G2(Context context, Class<? extends a> cls, Bundle bundle) {
        INSTANCE.a(context, cls, bundle);
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void beforeDoOnCreate() {
        super.beforeDoOnCreate();
        ((IUESoLoaderHelper) QRoute.api(IUESoLoaderHelper.class)).loadSo(this, "ZplanHostActivity");
        F2();
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnActivityResult(int requestCode, int requestCode2, Intent data) {
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.c(requestCode, requestCode2, data);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnBackPressed() {
        a aVar = this.mLogic;
        if (aVar != null ? aVar.d() : false) {
            return;
        }
        super.doOnBackPressed();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnCreate(Bundle savedInstanceState) {
        super.doOnCreate(savedInstanceState);
        a aVar = this.mLogic;
        if (aVar == null) {
            return true;
        }
        aVar.e();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnDestroy() {
        super.doOnDestroy();
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.f();
        }
        this.mLogic = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public boolean doOnKeyDown(int keyCode, KeyEvent event) {
        a aVar = this.mLogic;
        if (aVar != null ? aVar.g(keyCode, event) : false) {
            return true;
        }
        return super.doOnKeyDown(keyCode, event);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnNewIntent(Intent intent) {
        super.doOnNewIntent(intent);
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.h(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnPause() {
        super.doOnPause();
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.i();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void doOnResume() {
        super.doOnResume();
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.j();
        }
    }

    @Override // android.app.Activity
    public void finish() {
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.b();
        }
        super.finish();
    }
}
