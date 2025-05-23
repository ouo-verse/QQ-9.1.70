package com.tencent.mobileqq.zplan.authorize.api;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zootopia.data.ZootopiaEnterParams;
import com.tencent.mobileqq.zplan.authorize.impl.manager.CheckPhoneManager;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J&\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J.\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J.\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00140\u0006H&J0\u0010\u0018\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0017\u001a\u00020\u00162\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&J\b\u0010\u0019\u001a\u00020\tH&\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/zplan/authorize/api/c;", "Lvb3/b;", "", "modId", "Lcom/tencent/mobileqq/zplan/authorize/api/ModChekerParams;", "params", "Lcom/tencent/mobileqq/zplan/authorize/api/a;", "Lcom/tencent/mobileqq/zplan/authorize/api/EnterModCheckResult;", "callback", "", "U", "D", "Lcom/tencent/mobileqq/zootopia/data/ZootopiaEnterParams;", "enterParams", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "source", "n0", WadlProxyConsts.SCENE_ID, "Lcom/tencent/mobileqq/zplan/authorize/impl/manager/CheckPhoneManager$EntryType;", "sceneType", "Lcom/tencent/mobileqq/zplan/authorize/api/CheckResult;", ExifInterface.LATITUDE_SOUTH, "", "needServerFullCheck", "I", "P", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public interface c extends vb3.b {
    void D(int modId, ModChekerParams params, a<EnterModCheckResult> callback);

    void I(ZootopiaEnterParams enterParams, ZootopiaSource source, boolean needServerFullCheck, a<EnterModCheckResult> callback);

    void P();

    void S(int sceneId, CheckPhoneManager.EntryType sceneType, ZootopiaSource source, a<CheckResult> callback);

    void U(int modId, ModChekerParams params, a<EnterModCheckResult> callback);

    void n0(int modId, ZootopiaEnterParams enterParams, ZootopiaSource source, a<EnterModCheckResult> callback);
}
