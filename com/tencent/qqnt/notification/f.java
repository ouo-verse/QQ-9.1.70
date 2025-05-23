package com.tencent.qqnt.notification;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.GroupNotifyMsg;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\u001a\u001a\u00020\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0016\u0012\u0006\u0010#\u001a\u00020\u000b\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010,\u001a\u00020\u000b\u0012\b\b\u0002\u0010.\u001a\u00020\u000b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010/\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0000J\t\u0010\t\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u0005\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0015\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u001a\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001c\u001a\u00020\u00168\u0006\u00a2\u0006\f\n\u0004\b\u001b\u0010\u0017\u001a\u0004\b\u001b\u0010\u0019R\"\u0010#\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010*\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010,\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001f\u0010\u001e\u001a\u0004\b$\u0010 \"\u0004\b+\u0010\"R\"\u0010.\u001a\u00020\u000b8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010\u001e\u001a\u0004\b\u001d\u0010 \"\u0004\b-\u0010\"R$\u00104\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0018\u00100\u001a\u0004\b\u0011\u00101\"\u0004\b2\u00103\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/notification/f;", "", "", "toString", "", "category", "a", QCircleDaTongConstant.ElementParamValue.XSJ_SHARE_PANEL_STYLE_OLD, "k", "hashCode", "other", "", "equals", "I", "c", "()I", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "j", "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;", "msg", "Lcom/tencent/qqnt/notification/e;", "Lcom/tencent/qqnt/notification/e;", "i", "()Lcom/tencent/qqnt/notification/e;", "listModel", "d", "detailModel", "e", "Z", "g", "()Z", "o", "(Z)V", "hadRead", "f", "Ljava/lang/String;", h.F, "()Ljava/lang/String;", "p", "(Ljava/lang/String;)V", "levelTagUin", DomainData.DOMAIN_NAME, "hadDeleteBySys", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "hadDealBySys", "Lcom/tencent/qqnt/notification/b;", "Lcom/tencent/qqnt/notification/b;", "()Lcom/tencent/qqnt/notification/b;", "l", "(Lcom/tencent/qqnt/notification/b;)V", "avatar", "<init>", "(ILcom/tencent/qqnt/kernel/nativeinterface/GroupNotifyMsg;Lcom/tencent/qqnt/notification/e;Lcom/tencent/qqnt/notification/e;ZLjava/lang/String;ZZLcom/tencent/qqnt/notification/b;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final /* data */ class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int category;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final GroupNotifyMsg msg;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e listModel;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e detailModel;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean hadRead;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String levelTagUin;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private boolean hadDeleteBySys;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean hadDealBySys;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b avatar;

    public f(int i3, @NotNull GroupNotifyMsg msg2, @NotNull e listModel, @NotNull e detailModel, boolean z16, @Nullable String str, boolean z17, boolean z18, @Nullable b bVar) {
        Intrinsics.checkNotNullParameter(msg2, "msg");
        Intrinsics.checkNotNullParameter(listModel, "listModel");
        Intrinsics.checkNotNullParameter(detailModel, "detailModel");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), msg2, listModel, detailModel, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18), bVar);
            return;
        }
        this.category = i3;
        this.msg = msg2;
        this.listModel = listModel;
        this.detailModel = detailModel;
        this.hadRead = z16;
        this.levelTagUin = str;
        this.hadDeleteBySys = z17;
        this.hadDealBySys = z18;
        this.avatar = bVar;
    }

    @NotNull
    public final f a(int category) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return (f) iPatchRedirector.redirect((short) 18, (Object) this, category);
        }
        return new f(category, this.msg, this.listModel, this.detailModel, this.hadRead, this.levelTagUin, this.hadDeleteBySys, this.hadDealBySys, this.avatar);
    }

    @Nullable
    public final b b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (b) iPatchRedirector.redirect((short) 15, (Object) this);
        }
        return this.avatar;
    }

    public final int c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.category;
    }

    @NotNull
    public final e d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (e) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.detailModel;
    }

    public final boolean e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return this.hadDealBySys;
    }

    public boolean equals(@Nullable Object other) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Boolean) iPatchRedirector.redirect((short) 31, (Object) this, other)).booleanValue();
        }
        if (this == other) {
            return true;
        }
        if (!(other instanceof f)) {
            return false;
        }
        f fVar = (f) other;
        if (this.category == fVar.category && Intrinsics.areEqual(this.msg, fVar.msg) && Intrinsics.areEqual(this.listModel, fVar.listModel) && Intrinsics.areEqual(this.detailModel, fVar.detailModel) && this.hadRead == fVar.hadRead && Intrinsics.areEqual(this.levelTagUin, fVar.levelTagUin) && this.hadDeleteBySys == fVar.hadDeleteBySys && this.hadDealBySys == fVar.hadDealBySys && Intrinsics.areEqual(this.avatar, fVar.avatar)) {
            return true;
        }
        return false;
    }

    public final boolean f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this)).booleanValue();
        }
        return this.hadDeleteBySys;
    }

    public final boolean g() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return this.hadRead;
    }

    @Nullable
    public final String h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        return this.levelTagUin;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        int hashCode;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            return ((Integer) iPatchRedirector.redirect((short) 30, (Object) this)).intValue();
        }
        int hashCode2 = ((((((this.category * 31) + this.msg.hashCode()) * 31) + this.listModel.hashCode()) * 31) + this.detailModel.hashCode()) * 31;
        boolean z16 = this.hadRead;
        int i3 = 1;
        int i16 = z16;
        if (z16 != 0) {
            i16 = 1;
        }
        int i17 = (hashCode2 + i16) * 31;
        String str = this.levelTagUin;
        int i18 = 0;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int i19 = (i17 + hashCode) * 31;
        boolean z17 = this.hadDeleteBySys;
        int i26 = z17;
        if (z17 != 0) {
            i26 = 1;
        }
        int i27 = (i19 + i26) * 31;
        boolean z18 = this.hadDealBySys;
        if (!z18) {
            i3 = z18 ? 1 : 0;
        }
        int i28 = (i27 + i3) * 31;
        b bVar = this.avatar;
        if (bVar != null) {
            i18 = bVar.hashCode();
        }
        return i28 + i18;
    }

    @NotNull
    public final e i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (e) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.listModel;
    }

    @NotNull
    public final GroupNotifyMsg j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (GroupNotifyMsg) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.msg;
    }

    @NotNull
    public final f k(@NotNull f old) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (f) iPatchRedirector.redirect((short) 19, (Object) this, (Object) old);
        }
        Intrinsics.checkNotNullParameter(old, "old");
        String str = this.levelTagUin;
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            this.levelTagUin = old.levelTagUin;
        }
        if (this.avatar == null) {
            this.avatar = old.avatar;
        }
        return this;
    }

    public final void l(@Nullable b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) bVar);
        } else {
            this.avatar = bVar;
        }
    }

    public final void m(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, z16);
        } else {
            this.hadDealBySys = z16;
        }
    }

    public final void n(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, z16);
        } else {
            this.hadDeleteBySys = z16;
        }
    }

    public final void o(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else {
            this.hadRead = z16;
        }
    }

    public final void p(@Nullable String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        } else {
            this.levelTagUin = str;
        }
    }

    @NotNull
    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return (String) iPatchRedirector.redirect((short) 17, (Object) this);
        }
        int i3 = this.category;
        GroupNotifyMsg groupNotifyMsg = this.msg;
        return "TroopNotificationMsg(category=" + i3 + ", msg.seq=" + groupNotifyMsg.seq + ", msg.type=" + groupNotifyMsg.originMsgType + ", msg.status=" + groupNotifyMsg.status + ", listModel=" + this.listModel + ", detailModel=" + this.detailModel + ", levelTagUin=" + this.levelTagUin + ")";
    }

    public /* synthetic */ f(int i3, GroupNotifyMsg groupNotifyMsg, e eVar, e eVar2, boolean z16, String str, boolean z17, boolean z18, b bVar, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(i3, groupNotifyMsg, eVar, eVar2, z16, (i16 & 32) != 0 ? null : str, (i16 & 64) != 0 ? false : z17, (i16 & 128) != 0 ? false : z18, (i16 & 256) != 0 ? null : bVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), groupNotifyMsg, eVar, eVar2, Boolean.valueOf(z16), str, Boolean.valueOf(z17), Boolean.valueOf(z18), bVar, Integer.valueOf(i16), defaultConstructorMarker);
    }
}
