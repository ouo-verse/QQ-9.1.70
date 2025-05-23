package com.qzone.reborn.comment.activity;

import android.os.Bundle;
import cd.n;
import com.qzone.reborn.base.QZoneBaseActivity;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.util.b;
import com.tencent.mobileqq.R;
import d5.r;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import mqq.app.Constants;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0014J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\t\u001a\u00020\bH\u0014J\b\u0010\n\u001a\u00020\bH\u0014J\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/qzone/reborn/comment/activity/QZoneCommentPanelActivity;", "Lcom/qzone/reborn/base/QZoneBaseActivity;", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "Ld5/r;", "getQUIProfileTheme", "", "isNeedQZoneStyleActivityAnim", "enableQUIProfile", "finish", "Lcom/qzone/reborn/util/b;", "a0", "Lcom/qzone/reborn/util/b;", "mQUIProfileTheme", "<init>", "()V", "b0", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QZoneCommentPanelActivity extends QZoneBaseActivity {

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: c0, reason: collision with root package name */
    private static boolean f53586c0 = true;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private b mQUIProfileTheme;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/reborn/comment/activity/QZoneCommentPanelActivity$a;", "", "", "sEnableQUIProfile", "Z", "getSEnableQUIProfile", "()Z", "a", "(Z)V", "", "NO_ANIM", "I", "<init>", "()V", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.qzone.reborn.comment.activity.QZoneCommentPanelActivity$a, reason: from kotlin metadata */
    /* loaded from: classes37.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(boolean z16) {
            QZoneCommentPanelActivity.f53586c0 = z16;
        }

        Companion() {
        }
    }

    @Override // com.qzone.reborn.base.QZoneBaseActivity
    protected boolean enableQUIProfile() {
        return f53586c0;
    }

    @Override // com.qzone.reborn.base.QZoneBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, android.app.Activity
    public void finish() {
        super.finish();
        f53586c0 = true;
        n.INSTANCE.b(this);
        overridePendingTransition(0, 0);
    }

    @Override // com.qzone.reborn.base.QZoneBaseActivity
    protected r getQUIProfileTheme() {
        if (this.mQUIProfileTheme == null && g.f53821a.a().l()) {
            this.mQUIProfileTheme = new b(this, enableQUIProfile());
        }
        return this.mQUIProfileTheme;
    }

    @Override // com.qzone.reborn.base.QZoneBaseActivity
    protected boolean isNeedQZoneStyleActivityAnim() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.reborn.base.QZoneBaseActivity, com.tencent.biz.richframework.activity.CompatPublicActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.f154786u, R.anim.f154789v);
    }
}
