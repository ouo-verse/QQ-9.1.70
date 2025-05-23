package com.tencent.mobileqq.zplan.minixwconnected.forward;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.forward.ForwardArkMsgOption;
import com.tencent.mobileqq.forward.e;
import com.tencent.qphone.base.util.QLog;
import hf0.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u000f\u0012\u0006\u0010\u0012\u001a\u00020\r\u00a2\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u001a\u0010\n\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u000b\u001a\u00020\u0002H\u0014J\b\u0010\f\u001a\u00020\u0004H\u0014R\u0017\u0010\u0012\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/zplan/minixwconnected/forward/ForwardMiniHomeConnectOption;", "Lcom/tencent/mobileqq/forward/ForwardArkMsgOption;", "", "o", "", "preloadData", "", "type", "Landroid/os/Bundle;", "extra", "buildForwardDialog", "buildForwardAbility", "allowQZoneAbility", "Landroid/content/Intent;", "f", "Landroid/content/Intent;", "getIntent", "()Landroid/content/Intent;", "intent", "", h.F, "Ljava/lang/String;", "mArkInfo", "<init>", "(Landroid/content/Intent;)V", "i", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ForwardMiniHomeConnectOption extends ForwardArkMsgOption {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final Intent intent;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private String mArkInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForwardMiniHomeConnectOption(Intent intent) {
        super(intent);
        Intrinsics.checkNotNullParameter(intent, "intent");
        this.intent = intent;
        this.mArkInfo = "";
    }

    private final void o() {
        Activity activity = this.mActivity;
        if (activity != null) {
            activity.setResult(-1, this.intent);
        }
        Activity activity2 = this.mActivity;
        if (activity2 != null) {
            activity2.finish();
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    protected boolean allowQZoneAbility() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardAbility() {
        if (allowDiscussAbility()) {
            this.mForwardAbilities.add(e.Q3);
        }
        if (allowTroopAbility()) {
            this.mForwardAbilities.add(e.P3);
        }
        if (allowFriendAbility()) {
            this.mForwardAbilities.add(e.O3);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardBaseOption
    public void buildForwardDialog(int type, Bundle extra) {
        if (a.a("ForwardMiniHomeConnectOption")) {
            QLog.e("ForwardMiniHomeConnectOption", 1, "buildForwardDialog isFastDoubleClick");
            o();
            return;
        }
        if (this.mArkInfo.length() == 0) {
            QLog.e("ForwardMiniHomeConnectOption", 1, "buildForwardDialog mArkInfo isEmpty!");
            o();
        } else {
            super.buildForwardDialog(type, extra);
        }
    }

    @Override // com.tencent.mobileqq.forward.ForwardArkMsgOption, com.tencent.mobileqq.forward.ForwardBaseOption
    public boolean preloadData() {
        Bundle extras;
        Intent intent = this.mIntent;
        String string = (intent == null || (extras = intent.getExtras()) == null) ? null : extras.getString("share_ark_info");
        if (string == null) {
            string = "";
        }
        this.mArkInfo = string;
        return true;
    }
}
