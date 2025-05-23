package mj;

import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import qzone.QZoneBaseMeta$StUser;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0002\u001a\u00020\u0001*\u00020\u0000\u00a8\u0006\u0003"}, d2 = {"Lqzone/QZoneBaseMeta$StUser;", "Lcom/qzone/reborn/albumx/common/convert/bean/CommonStUser;", "a", "qzone_df_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class c {
    public static final CommonStUser a(QZoneBaseMeta$StUser qZoneBaseMeta$StUser) {
        Intrinsics.checkNotNullParameter(qZoneBaseMeta$StUser, "<this>");
        CommonStUser commonStUser = new CommonStUser();
        String str = qZoneBaseMeta$StUser.uid.get();
        Intrinsics.checkNotNullExpressionValue(str, "this.uid.get()");
        commonStUser.f(str);
        String str2 = qZoneBaseMeta$StUser.nick.get();
        Intrinsics.checkNotNullExpressionValue(str2, "this.nick.get()");
        commonStUser.e(str2);
        return commonStUser;
    }
}
