package com.tencent.mobileqq.troop.selectmember.vm;

import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.selectmember.helper.d;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi;
import com.tencent.qqnt.troopmemberlist.f;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \"2\u00020\u0001:\u0002\u000f\u0005B!\u0012\u0006\u0010\u0012\u001a\u00020\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b \u0010!J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00022\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0011R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00138\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0014R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0017R\u0016\u0010\u001a\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001c\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/vm/b;", "Lcom/tencent/qqnt/troopmemberlist/f;", "", "isForceNet", "", "b", "isRequestFail", "d", "", "fetchType", "c", "isSuccess", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "troopMemberList", "a", "", "Ljava/lang/String;", "troopUin", "Landroidx/fragment/app/FragmentActivity;", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/troop/selectmember/vm/b$b;", "Lcom/tencent/mobileqq/troop/selectmember/vm/b$b;", "callback", "I", "retryLoadMemberIndex", "e", "Z", "forceNet", "f", "curRequestIsNet", "<init>", "(Ljava/lang/String;Landroidx/fragment/app/FragmentActivity;Lcom/tencent/mobileqq/troop/selectmember/vm/b$b;)V", "g", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class b implements f {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final FragmentActivity activity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final InterfaceC8767b callback;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private volatile int retryLoadMemberIndex;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean forceNet;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean curRequestIsNet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/vm/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.vm.b$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/selectmember/vm/b$b;", "", "", "Lcom/tencent/mobileqq/data/troop/TroopMemberInfo;", "memberList", "", "c0", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.selectmember.vm.b$b, reason: collision with other inner class name */
    /* loaded from: classes19.dex */
    public interface InterfaceC8767b {
        void c0(@NotNull List<? extends TroopMemberInfo> memberList);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54995);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull String troopUin, @Nullable FragmentActivity fragmentActivity, @NotNull InterfaceC8767b callback) {
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(callback, "callback");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, troopUin, fragmentActivity, callback);
            return;
        }
        this.troopUin = troopUin;
        this.activity = fragmentActivity;
        this.callback = callback;
    }

    private final void b(boolean isForceNet) {
        if (QLog.isColorLevel()) {
            QLog.i("TroopSelectMemberFrag.Repo", 2, "[fetchTroopMemberList] isForceNet:" + isForceNet);
        }
        this.curRequestIsNet = this.forceNet;
        ((ITroopMemberListRepoApi) QRoute.api(ITroopMemberListRepoApi.class)).fetchTroopMemberList(this.troopUin, this.activity, isForceNet, "TroopSelectMemberFrag.Repo", this);
    }

    private final void d(boolean isRequestFail) {
        boolean z16 = true;
        this.retryLoadMemberIndex++;
        if (this.retryLoadMemberIndex == 1) {
            if (isRequestFail) {
                if (!this.forceNet || !NetworkUtil.isNetworkAvailable()) {
                    z16 = false;
                }
                b(z16);
                return;
            }
            b(!this.forceNet);
            return;
        }
        if (this.retryLoadMemberIndex == 2 && this.curRequestIsNet) {
            b(false);
        } else {
            this.callback.c0(new ArrayList());
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.f
    public void a(boolean isSuccess, @NotNull List<? extends TroopMemberInfo> troopMemberList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Boolean.valueOf(isSuccess), troopMemberList);
            return;
        }
        Intrinsics.checkNotNullParameter(troopMemberList, "troopMemberList");
        QLog.i("TroopSelectMemberFrag.Repo", 1, "[onFetchDataBySubThread] troopUin:" + this.troopUin + ", isSuccess:" + isSuccess + ", size:" + troopMemberList.size() + ",retryLoadMemberIndex:" + this.retryLoadMemberIndex + ", curRequestIsNet:" + this.curRequestIsNet);
        if (isSuccess && !troopMemberList.isEmpty()) {
            if (this.curRequestIsNet) {
                d.f298358a.d(this.activity, this.troopUin);
            }
            this.callback.c0(troopMemberList);
            return;
        }
        d(!isSuccess);
    }

    public final void c(int fetchType) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, fetchType);
            return;
        }
        this.retryLoadMemberIndex = 0;
        QLog.i("TroopSelectMemberFrag.Repo", 1, "[loadTroopMember] fetchType:" + fetchType + ", troopUin:" + this.troopUin);
        boolean c16 = d.f298358a.c(this.activity, this.troopUin, fetchType);
        this.forceNet = c16;
        b(c16);
    }
}
