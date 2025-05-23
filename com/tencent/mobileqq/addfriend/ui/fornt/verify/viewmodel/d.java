package com.tencent.mobileqq.addfriend.ui.fornt.verify.viewmodel;

import android.content.Intent;
import android.text.TextUtils;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.data.KplRoleInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J(\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0006\u0010\u000e\u001a\u00020\u0004J\u0010\u0010\u0010\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0012\u001a\u00020\u0004J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0016\u0010\u0016\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/mobileqq/addfriend/ui/fornt/verify/viewmodel/d;", "Landroidx/lifecycle/ViewModel;", "Landroid/content/Intent;", "intent", "", "mAddUin", "N1", "", "mSourceId", "mSubSourceId", "Lcom/tencent/mobileqq/data/KplRoleInfo$WZRYUIinfo;", "mWZRYUIinfo", "", "Q1", "L1", "value", "R1", "P1", "M1", "O1", "i", "Ljava/lang/String;", "mRemark", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "mRemarkForTroop", "<init>", "()V", "qqaddfriend-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mRemark;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mRemarkForTroop;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRemark = "";
            this.mRemarkForTroop = "";
        }
    }

    private final String N1(Intent intent, String mAddUin) {
        String k3 = com.tencent.mobileqq.addfriend.utils.a.k(com.tencent.mobileqq.addfriend.utils.a.f(), O1(intent), mAddUin);
        Intrinsics.checkNotNullExpressionValue(k3, "getTroopMemberName(AddFr\u2026ace(), troopUin, mAddUin)");
        String str = "";
        if (Intrinsics.areEqual(mAddUin, k3)) {
            k3 = "";
        }
        if (TextUtils.isEmpty(k3) || Intrinsics.areEqual(mAddUin, k3)) {
            k3 = com.tencent.mobileqq.addfriend.utils.a.h(com.tencent.mobileqq.addfriend.utils.a.f(), mAddUin);
            Intrinsics.checkNotNullExpressionValue(k3, "getFriendNick(AddFriendU\u2026tAppInterface(), mAddUin)");
        }
        if (TextUtils.isEmpty(k3) || Intrinsics.areEqual(mAddUin, k3)) {
            String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (stringExtra != null) {
                str = stringExtra;
            }
            return str;
        }
        return k3;
    }

    @NotNull
    public final String L1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.mRemark;
    }

    @NotNull
    public final String M1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mRemarkForTroop;
    }

    @NotNull
    public final String O1(@NotNull Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) intent);
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        String stringExtra = intent.getStringExtra("param_return_profilecard_group_uin");
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("troop_uin");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            stringExtra = intent.getStringExtra("extra");
        }
        if (stringExtra == null) {
            return "";
        }
        return stringExtra;
    }

    public final void P1(@NotNull Intent intent, @NotNull String mAddUin) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent, (Object) mAddUin);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(mAddUin, "mAddUin");
        this.mRemarkForTroop = N1(intent, mAddUin);
    }

    public final void Q1(@NotNull Intent intent, int mSourceId, int mSubSourceId, @Nullable KplRoleInfo.WZRYUIinfo mWZRYUIinfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, intent, Integer.valueOf(mSourceId), Integer.valueOf(mSubSourceId), mWZRYUIinfo);
            return;
        }
        Intrinsics.checkNotNullParameter(intent, "intent");
        String str = "";
        if (com.tencent.mobileqq.addfriend.utils.a.p(mSourceId)) {
            String stringExtra = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (stringExtra != null) {
                str = stringExtra;
            }
            this.mRemark = str;
            return;
        }
        if (mWZRYUIinfo != null) {
            String stringExtra2 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
            if (stringExtra2 != null) {
                str = stringExtra2;
            }
            this.mRemark = str;
            return;
        }
        if (mSourceId == 3004) {
            if (mSubSourceId == 5 || mSubSourceId == 6 || mSubSourceId == 7 || mSubSourceId == 8) {
                String stringExtra3 = intent.getStringExtra(IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME);
                if (stringExtra3 != null) {
                    str = stringExtra3;
                }
                this.mRemark = str;
            }
        }
    }

    public final void R1(@Nullable String value) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) value);
            return;
        }
        if (value == null) {
            value = "";
        }
        this.mRemark = value;
    }
}
