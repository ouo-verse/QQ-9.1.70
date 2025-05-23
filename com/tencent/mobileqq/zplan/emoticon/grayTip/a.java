package com.tencent.mobileqq.zplan.emoticon.grayTip;

import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qqnt.graytips.action.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0004\u00a2\u0006\u0004\b\t\u0010\nJ\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\b\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0005\u0010\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/zplan/emoticon/grayTip/a;", "Lcom/tencent/qqnt/graytips/action/f;", "", "getActionType", "", "a", "Ljava/lang/String;", "()Ljava/lang/String;", VipFunCallConstants.KEY_GROUP, "<init>", "(Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final String group;

    public a(String group) {
        Intrinsics.checkNotNullParameter(group, "group");
        this.group = group;
    }

    /* renamed from: a, reason: from getter */
    public final String getGroup() {
        return this.group;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c A[ORIG_RETURN, RETURN] */
    @Override // com.tencent.qqnt.graytips.action.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getActionType() {
        String str = this.group;
        switch (str.hashCode()) {
            case 133819617:
                return !str.equals(ZPlanEmoticonGrayTipTABGroup.OPEN_EMOTICON_PANEL) ? -1 : 71;
            case 133819618:
                if (str.equals(ZPlanEmoticonGrayTipTABGroup.CREATE_ROLE)) {
                    return 76;
                }
                break;
            case 537603314:
                if (str.equals(ZPlanEmoticonGrayTipTABGroup.HAS_CREATED_ROLE)) {
                    return 71;
                }
                break;
        }
    }
}
