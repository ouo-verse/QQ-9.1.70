package com.tencent.mobileqq.troopmanage.repo;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\bD\u0010ER\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0019\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u001c\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u0013\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\"\u0010\u001e\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u000b\u0010\u000e\"\u0004\b\u001d\u0010\u0010R\"\u0010!\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\f\u001a\u0004\b\u0003\u0010\u000e\"\u0004\b \u0010\u0010R\"\u0010$\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010\u0014\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\"\u0010'\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b%\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016\"\u0004\b&\u0010\u0018R\"\u0010+\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b(\u0010\f\u001a\u0004\b)\u0010\u000e\"\u0004\b*\u0010\u0010R\"\u00101\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\r\u0010-\u001a\u0004\b%\u0010.\"\u0004\b/\u00100R\"\u00104\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b2\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b3\u0010\u0018R\"\u0010:\u001a\u0002058\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00106\u001a\u0004\b(\u00107\"\u0004\b8\u00109R\"\u0010A\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b2\u0010>\"\u0004\b?\u0010@R\"\u0010C\u001a\u00020;8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010=\u001a\u0004\b<\u0010>\"\u0004\bB\u0010@\u00a8\u0006F"}, d2 = {"Lcom/tencent/mobileqq/troopmanage/repo/b;", "", "Landroid/os/Bundle;", "a", "Landroid/os/Bundle;", "l", "()Landroid/os/Bundle;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Landroid/os/Bundle;)V", "pageArgusBundle", "", "b", "Ljava/lang/String;", "j", "()Ljava/lang/String;", HippyTKDListViewAdapter.X, "(Ljava/lang/String;)V", "mTroopUin", "", "c", "Z", "e", "()Z", ReportConstant.COSTREPORT_PREFIX, "(Z)V", "mIsQiDianPrivateTroop", "d", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "mIsCustomGame", "o", "mCurrentAccount", "f", DomainData.DOMAIN_NAME, "mAutoApprovalUrl", "g", "u", "mMsgFreqLimitVisible", tl.h.F, "t", "mIsSupportTroopHonor", "i", "getMCurrentUin", "p", "mCurrentUin", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "v", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "mTroopInfo", "k", "r", "mIsHomeworkTroop", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "()Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "w", "(Lcom/tencent/mobileqq/troop/data/TroopInfoData;)V", "mTroopInfoData", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "I", "()I", "y", "(I)V", "mUserFrom", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "pageStatus", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Bundle pageArgusBundle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mTroopUin;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean mIsQiDianPrivateTroop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private boolean mIsCustomGame;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurrentAccount;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mAutoApprovalUrl;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean mMsgFreqLimitVisible;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mIsSupportTroopHonor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String mCurrentUin;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopInfo mTroopInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private boolean mIsHomeworkTroop;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private TroopInfoData mTroopInfoData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private int mUserFrom;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private int pageStatus;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.pageArgusBundle = new Bundle();
        this.mTroopUin = "";
        this.mCurrentAccount = "";
        this.mAutoApprovalUrl = "";
        this.mCurrentUin = "";
        this.mTroopInfo = new TroopInfo(this.mTroopUin);
        this.mTroopInfoData = new TroopInfoData();
        this.mUserFrom = 2;
        this.pageStatus = 2;
    }

    public final void A(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            iPatchRedirector.redirect((short) 29, (Object) this, i3);
        } else {
            this.pageStatus = i3;
        }
    }

    @NotNull
    public final String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (String) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.mAutoApprovalUrl;
    }

    @NotNull
    public final String b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return this.mCurrentAccount;
    }

    public final boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return this.mIsCustomGame;
    }

    public final boolean d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return ((Boolean) iPatchRedirector.redirect((short) 22, (Object) this)).booleanValue();
        }
        return this.mIsHomeworkTroop;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.mIsQiDianPrivateTroop;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return this.mIsSupportTroopHonor;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this)).booleanValue();
        }
        return this.mMsgFreqLimitVisible;
    }

    @NotNull
    public final TroopInfo h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 20, (Object) this);
        }
        return this.mTroopInfo;
    }

    @NotNull
    public final TroopInfoData i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (TroopInfoData) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.mTroopInfoData;
    }

    @NotNull
    public final String j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.mTroopUin;
    }

    public final int k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return ((Integer) iPatchRedirector.redirect((short) 26, (Object) this)).intValue();
        }
        return this.mUserFrom;
    }

    @NotNull
    public final Bundle l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Bundle) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.pageArgusBundle;
    }

    public final int m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return ((Integer) iPatchRedirector.redirect((short) 28, (Object) this)).intValue();
        }
        return this.pageStatus;
    }

    public final void n(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mAutoApprovalUrl = str;
        }
    }

    public final void o(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mCurrentAccount = str;
        }
    }

    public final void p(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mCurrentUin = str;
        }
    }

    public final void q(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, z16);
        } else {
            this.mIsCustomGame = z16;
        }
    }

    public final void r(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
        } else {
            this.mIsHomeworkTroop = z16;
        }
    }

    public final void s(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.mIsQiDianPrivateTroop = z16;
        }
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, z16);
        } else {
            this.mIsSupportTroopHonor = z16;
        }
    }

    public final void u(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, z16);
        } else {
            this.mMsgFreqLimitVisible = z16;
        }
    }

    public final void v(@NotNull TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) troopInfo);
        } else {
            Intrinsics.checkNotNullParameter(troopInfo, "<set-?>");
            this.mTroopInfo = troopInfo;
        }
    }

    public final void w(@NotNull TroopInfoData troopInfoData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, (Object) troopInfoData);
        } else {
            Intrinsics.checkNotNullParameter(troopInfoData, "<set-?>");
            this.mTroopInfoData = troopInfoData;
        }
    }

    public final void x(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.mTroopUin = str;
        }
    }

    public final void y(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, i3);
        } else {
            this.mUserFrom = i3;
        }
    }

    public final void z(@NotNull Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        } else {
            Intrinsics.checkNotNullParameter(bundle, "<set-?>");
            this.pageArgusBundle = bundle;
        }
    }
}
