package com.tencent.mobileqq.zplan.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import com.tencent.qphone.base.util.QLog;
import i74.a;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppActivity;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0001$B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\b\u0010\u0007\u001a\u00020\u0002H\u0014J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\b\u0010\f\u001a\u00020\u0002H\u0014J\b\u0010\r\u001a\u00020\u0002H\u0014J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014J\"\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u0016\u001a\u00020\u0002H\u0014J\u001a\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00112\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0014J\b\u0010\u001b\u001a\u00020\u0002H\u0014J\b\u0010\u001c\u001a\u00020\u0002H\u0016R\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006%"}, d2 = {"Lcom/tencent/mobileqq/zplan/activity/PeakHostActivity;", "Lmqq/app/AppActivity;", "", "F2", "Landroid/content/Context;", "newBase", "attachBaseContext", "beforeDoOnCreate", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "doOnCreate", "doOnResume", "doOnPause", "Landroid/content/Intent;", "intent", "doOnNewIntent", "", "requestCode", "requestCode2", "data", "doOnActivityResult", "doOnBackPressed", "keyCode", "Landroid/view/KeyEvent;", "event", "doOnKeyDown", "doOnDestroy", "finish", "Li74/a;", "a0", "Li74/a;", "mLogic", "<init>", "()V", "b0", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PeakHostActivity extends AppActivity {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private a mLogic;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J4\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tH\u0007R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\r8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/zplan/activity/PeakHostActivity$a;", "", "Landroid/content/Context;", "context", "Ljava/lang/Class;", "Li74/a;", "clazz", "Landroid/os/Bundle;", "params", "", "intentFlags", "", "a", "", "KEY_LOGIC_CLASS", "Ljava/lang/String;", "TAG", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.zplan.activity.PeakHostActivity$a, reason: from kotlin metadata */
    /* loaded from: classes35.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void a(Context context, Class<? extends a> clazz, Bundle params, int intentFlags) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(clazz, "clazz");
            Intrinsics.checkNotNullParameter(params, "params");
            Intent intent = new Intent(context, (Class<?>) PeakHostActivity.class);
            intent.putExtras(params);
            intent.putExtra("peak_activity_logic_class", clazz.getName());
            if (intentFlags != 0) {
                intent.addFlags(intentFlags);
            }
            intent.addFlags(268435456);
            context.startActivity(intent);
        }

        Companion() {
        }
    }

    private final void F2() {
        String stringExtra = getIntent().getStringExtra("peak_activity_logic_class");
        if (stringExtra == null) {
            return;
        }
        QLog.i("PeakHostActivity", 1, "init logic class: " + stringExtra);
        try {
            Object newInstance = Class.forName(stringExtra).newInstance();
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type com.tencent.sqshow.activity.BasicActivityLogic");
            this.mLogic = (a) newInstance;
        } catch (Exception e16) {
            QLog.e("PeakHostActivity", 1, e16, new Object[0]);
        }
        a aVar = this.mLogic;
        if (aVar != null) {
            aVar.m(this);
        }
    }

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // mqq.app.AppActivity
    public void beforeDoOnCreate() {
        super.beforeDoOnCreate();
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
