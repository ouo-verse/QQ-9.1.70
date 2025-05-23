package com.tencent.mobileqq.vas.qqmc;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.state.data.SwitchConfig;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/vas/qqmc/b;", "", "Lcom/tencent/mobileqq/vas/qqmc/a;", "a", "<init>", "()V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public static final b f310591a = new b();

    b() {
    }

    public final SquareFilamentCoverRecordConfigData a() {
        SquareFilamentCoverRecordConfigData squareFilamentCoverRecordConfigData = (SquareFilamentCoverRecordConfigData) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(SwitchConfig.Group.filamentCoverRecord);
        return squareFilamentCoverRecordConfigData == null ? new SquareFilamentCoverRecordConfigData(false, false, 3, null) : squareFilamentCoverRecordConfigData;
    }
}
