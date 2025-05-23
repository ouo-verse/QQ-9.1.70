package com.tencent.hippykotlin.demo.pages.qwallet.base.module;

import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class NickNameBean {
    public final String nickName;
    public final String uid;
    public final String uin;

    public NickNameBean() {
        this(null, null, null, 7, null);
    }

    public final int hashCode() {
        String str = this.uin;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.uid;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.nickName;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("NickNameBean(uin=");
        m3.append(this.uin);
        m3.append(", uid=");
        m3.append(this.uid);
        m3.append(", nickName=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.nickName, ')');
    }

    public NickNameBean(String str, String str2, String str3) {
        this.uin = str;
        this.uid = str2;
        this.nickName = str3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NickNameBean)) {
            return false;
        }
        NickNameBean nickNameBean = (NickNameBean) obj;
        return Intrinsics.areEqual(this.uin, nickNameBean.uin) && Intrinsics.areEqual(this.uid, nickNameBean.uid) && Intrinsics.areEqual(this.nickName, nickNameBean.nickName);
    }

    public /* synthetic */ NickNameBean(String str, String str2, String str3, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(null, null, null);
    }
}
