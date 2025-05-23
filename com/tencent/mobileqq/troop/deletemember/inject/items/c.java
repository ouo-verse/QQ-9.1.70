package com.tencent.mobileqq.troop.deletemember.inject.items;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqnt.kernel.nativeinterface.GroupMemberIllegalInfoResult;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002R\u0019\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006\u00a2\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/troop/deletemember/inject/items/c;", "Lcom/tencent/mobileqq/troop/deletemember/inject/items/b;", "", DomainData.DOMAIN_NAME, "l", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;", "info", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/GroupMemberIllegalInfoResult;)V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class c extends b {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final GroupMemberIllegalInfoResult info;

    public c(@Nullable GroupMemberIllegalInfoResult groupMemberIllegalInfoResult) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupMemberIllegalInfoResult);
        } else {
            this.info = groupMemberIllegalInfoResult;
        }
    }

    @Nullable
    public final String l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        GroupMemberIllegalInfoResult groupMemberIllegalInfoResult = this.info;
        if (groupMemberIllegalInfoResult != null) {
            return groupMemberIllegalInfoResult.getMsgBoxContent();
        }
        return null;
    }

    @Nullable
    public final GroupMemberIllegalInfoResult m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (GroupMemberIllegalInfoResult) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.info;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    @Override // com.tencent.mobileqq.troop.selectmember.bean.a
    @NotNull
    /* renamed from: n, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String getItemData() {
        boolean z16;
        String qqStr;
        String subGroupTitle;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        GroupMemberIllegalInfoResult groupMemberIllegalInfoResult = this.info;
        if (groupMemberIllegalInfoResult != null && (subGroupTitle = groupMemberIllegalInfoResult.getSubGroupTitle()) != null) {
            if (subGroupTitle.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                z16 = true;
                if (!z16) {
                    qqStr = this.info.getSubGroupTitle();
                } else {
                    qqStr = HardCodeUtil.qqStr(R.string.f2062057o);
                }
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(qqStr + "(%s\u4eba)", Arrays.copyOf(new Object[]{Integer.valueOf(a().size())}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                return format;
            }
        }
        z16 = false;
        if (!z16) {
        }
        StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
        String format2 = String.format(qqStr + "(%s\u4eba)", Arrays.copyOf(new Object[]{Integer.valueOf(a().size())}, 1));
        Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
        return format2;
    }
}
