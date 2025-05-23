package com.tencent.qqnt.troopmemberlist.datasync;

import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberCommonListResult;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberExtListResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001a2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001>B\u000f\u0012\u0006\u0010<\u001a\u00020\u0017\u00a2\u0006\u0004\b=\u0010\u001dJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\b\u0010\u0005\u001a\u00020\u0000H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016R\"\u0010\u000e\u001a\u00020\b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0004\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010&\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010*\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b'\u0010\u0019\u001a\u0004\b(\u0010\u001b\"\u0004\b)\u0010\u001dR$\u0010.\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b+\u0010!\u001a\u0004\b,\u0010#\"\u0004\b-\u0010%R\"\u00101\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b,\u0010\u0019\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR$\u00108\u001a\u0004\u0018\u0001028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0005\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u0010;\u001a\u00020\u00178\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0012\u0010\u0019\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001d\u00a8\u0006?"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/datasync/e;", "Lcom/tencent/qqnt/troopmemberlist/datasync/b;", "", "b", "c", "j", "", "toString", "", "Z", DomainData.DOMAIN_NAME, "()Z", "t", "(Z)V", "res", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "d", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "k", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "detailInfo", "", "e", "I", "l", "()I", "r", "(I)V", "detailInfoCode", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;", "f", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;", ReportConstant.COSTREPORT_PREFIX, "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberCommonListResult;)V", "memberListInfo", "g", "getMemberListCode", "setMemberListCode", "memberListCode", h.F, "i", "p", "adminListInfo", "getAdminListCode", "setAdminListCode", "adminListCode", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "o", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;", "u", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberExtListResult;)V", "selfLevelInfo", "getSelfLevelCode", "setSelfLevelCode", "selfLevelCode", "partCount", "<init>", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends b<e> {
    static IPatchRedirector $redirector_;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean res;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopInfo detailInfo;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int detailInfoCode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GroupMemberCommonListResult memberListInfo;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private int memberListCode;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GroupMemberCommonListResult adminListInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int adminListCode;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private GroupMemberExtListResult selfLevelInfo;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private int selfLevelCode;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/troopmemberlist/datasync/e$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.troopmemberlist.datasync.e$a, reason: from kotlin metadata */
    /* loaded from: classes25.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63564);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(int i3) {
        super(i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3);
            return;
        }
        this.res = true;
        this.detailInfoCode = -1;
        this.memberListCode = -1;
        this.adminListCode = -1;
        this.selfLevelCode = -1;
    }

    @Override // com.tencent.qqnt.troopmemberlist.datasync.b
    protected void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.troopmemberlist.datasync.b
    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        }
    }

    @Nullable
    public final GroupMemberCommonListResult i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (GroupMemberCommonListResult) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.adminListInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.qqnt.troopmemberlist.datasync.b
    @NotNull
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (e) iPatchRedirector.redirect((short) 22, (Object) this);
        }
        return this;
    }

    @Nullable
    public final TroopInfo k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.detailInfo;
    }

    public final int l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return this.detailInfoCode;
    }

    @Nullable
    public final GroupMemberCommonListResult m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (GroupMemberCommonListResult) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.memberListInfo;
    }

    public final boolean n() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.res;
    }

    @Nullable
    public final GroupMemberExtListResult o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (GroupMemberExtListResult) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return this.selfLevelInfo;
    }

    public final void p(@Nullable GroupMemberCommonListResult groupMemberCommonListResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) groupMemberCommonListResult);
        } else {
            this.adminListInfo = groupMemberCommonListResult;
        }
    }

    public final void q(@Nullable TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) troopInfo);
        } else {
            this.detailInfo = troopInfo;
        }
    }

    public final void r(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
        } else {
            this.detailInfoCode = i3;
        }
    }

    public final void s(@Nullable GroupMemberCommonListResult groupMemberCommonListResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) groupMemberCommonListResult);
        } else {
            this.memberListInfo = groupMemberCommonListResult;
        }
    }

    public final void t(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, z16);
        } else {
            this.res = z16;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (String) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return "res:" + this.res + ", detailInfoCode:" + this.detailInfoCode + ", memberListCode:" + this.memberListCode + ", selfLevelCode:" + this.selfLevelCode;
    }

    public final void u(@Nullable GroupMemberExtListResult groupMemberExtListResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) groupMemberExtListResult);
        } else {
            this.selfLevelInfo = groupMemberExtListResult;
        }
    }
}
