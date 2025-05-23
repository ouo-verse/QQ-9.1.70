package com.tencent.open.agent.quickauth;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u0012\u0006\u0010\u001c\u001a\u00020\u0018\u0012\u0006\u0010!\u001a\u00020\u001d\u00a2\u0006\u0004\b)\u0010*J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0002H&J\b\u0010\n\u001a\u00020\tH&J\b\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0004\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u0017\u0010\u001c\u001a\u00020\u00188\u0006\u00a2\u0006\f\n\u0004\b\b\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010!\u001a\u00020\u001d8\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u001e\u001a\u0004\b\u001f\u0010 R\"\u0010(\u001a\u00020\"8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/open/agent/quickauth/j;", "", "", "l", "a", "Landroid/content/Intent;", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "b", "Lcom/tencent/open/agent/quickauth/z;", "e", "", "i", "", "k", "Lmqq/app/AppRuntime;", "d", "Landroid/content/res/Resources;", tl.h.F, "Landroid/app/Activity;", "Landroid/app/Activity;", "c", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/open/agent/quickauth/i;", "Lcom/tencent/open/agent/quickauth/i;", "j", "()Lcom/tencent/open/agent/quickauth/i;", "view", "Landroid/os/Bundle;", "Landroid/os/Bundle;", "g", "()Landroid/os/Bundle;", "mParams", "", "Ljava/lang/String;", "f", "()Ljava/lang/String;", DomainData.DOMAIN_NAME, "(Ljava/lang/String;)V", "currentAccount", "<init>", "(Landroid/app/Activity;Lcom/tencent/open/agent/quickauth/i;Landroid/os/Bundle;)V", "opensdk-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes22.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final i view;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle mParams;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String currentAccount;

    public j(@NotNull Activity activity, @NotNull i view, @NotNull Bundle mParams) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(mParams, "mParams");
        this.activity = activity;
        this.view = view;
        this.mParams = mParams;
        this.currentAccount = "";
    }

    public abstract void a();

    public abstract void b();

    @NotNull
    /* renamed from: c, reason: from getter */
    public final Activity getActivity() {
        return this.activity;
    }

    @NotNull
    public final AppRuntime d() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        Intrinsics.checkNotNullExpressionValue(peekAppRuntime, "sMobileQQ.peekAppRuntime()");
        return peekAppRuntime;
    }

    @NotNull
    public abstract QuickAuthApp e();

    @NotNull
    /* renamed from: f, reason: from getter */
    public final String getCurrentAccount() {
        return this.currentAccount;
    }

    @NotNull
    /* renamed from: g, reason: from getter */
    public final Bundle getMParams() {
        return this.mParams;
    }

    @NotNull
    public final Resources h() {
        Resources resources = this.activity.getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "activity.resources");
        return resources;
    }

    public long i() {
        return 0L;
    }

    @NotNull
    /* renamed from: j, reason: from getter */
    public final i getView() {
        return this.view;
    }

    public boolean k() {
        return true;
    }

    public abstract void l();

    public abstract void m(@NotNull Intent intent);

    public final void n(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.currentAccount = str;
    }
}
