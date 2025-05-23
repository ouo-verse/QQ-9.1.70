package com.tencent.mobileqq.aio.input.at.business;

import com.tencent.mobileqq.aio.input.at.business.n;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.kernel.nativeinterface.MemberInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u000f\u001a\u00020\n\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u0002\u001a\u00020\u0001H\u0016J\b\u0010\t\u001a\u00020\u0001H\u0016R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/aio/input/at/business/o;", "Lcom/tencent/mobileqq/aio/input/at/common/list/data/b;", "newItemData", "", "f", "e", "", "Lcom/tencent/mobileqq/aio/input/at/common/list/a;", "b", "a", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "d", "Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "j", "()Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;", "memberInfo", "", "mId", "<init>", "(Ljava/lang/String;Lcom/tencent/qqnt/kernel/nativeinterface/MemberInfo;)V", "aio_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class o extends com.tencent.mobileqq.aio.input.at.common.list.data.b {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MemberInfo memberInfo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(@NotNull String mId, @NotNull MemberInfo memberInfo) {
        super(mId);
        Intrinsics.checkNotNullParameter(mId, "mId");
        Intrinsics.checkNotNullParameter(memberInfo, "memberInfo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) mId, (Object) memberInfo);
        } else {
            this.memberInfo = memberInfo;
        }
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.list.data.b
    @NotNull
    public com.tencent.mobileqq.aio.input.at.common.list.data.b a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (com.tencent.mobileqq.aio.input.at.common.list.data.b) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        o oVar = new o(c(), this.memberInfo);
        oVar.i(d());
        oVar.h(d());
        return oVar;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.list.data.b
    @NotNull
    public List<com.tencent.mobileqq.aio.input.at.common.list.a> b(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b newItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) newItemData);
        }
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.b(newItemData));
        o oVar = (o) newItemData;
        String newItemAvatarPath = oVar.memberInfo.avatarPath;
        if (!Intrinsics.areEqual(this.memberInfo.avatarPath, newItemAvatarPath)) {
            Intrinsics.checkNotNullExpressionValue(newItemAvatarPath, "newItemAvatarPath");
            arrayList.add(new n.a(newItemAvatarPath));
        }
        boolean z16 = this.memberInfo.isSpecialConcerned;
        boolean z17 = oVar.memberInfo.isSpecialConcerned;
        if (z16 != z17) {
            arrayList.add(new n.c(z17));
        }
        AtUtils atUtils = AtUtils.f189228a;
        if (!Intrinsics.areEqual(atUtils.h(this.memberInfo).toString(), atUtils.h(oVar.memberInfo))) {
            arrayList.add(new n.b(atUtils.h(oVar.memberInfo).toString()));
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.list.data.b
    public boolean e(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b newItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) newItemData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        if (!super.e(newItemData)) {
            return false;
        }
        MemberInfo memberInfo = ((o) newItemData).memberInfo;
        if (!Intrinsics.areEqual(this.memberInfo.avatarPath, memberInfo.avatarPath)) {
            return false;
        }
        AtUtils atUtils = AtUtils.f189228a;
        if (!Intrinsics.areEqual(atUtils.h(this.memberInfo).toString(), atUtils.h(memberInfo).toString()) || this.memberInfo.isSpecialConcerned != memberInfo.isSpecialConcerned) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.mobileqq.aio.input.at.common.list.data.b
    public boolean f(@NotNull com.tencent.mobileqq.aio.input.at.common.list.data.b newItemData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) newItemData)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newItemData, "newItemData");
        return super.f(newItemData);
    }

    @NotNull
    public final MemberInfo j() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (MemberInfo) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.memberInfo;
    }
}
