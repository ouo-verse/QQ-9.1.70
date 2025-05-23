package com.tencent.mobileqq.vas.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.VasTabFactory;
import com.tencent.mobileqq.vas.api.IVasPageToggle;
import com.tencent.mobileqq.vas.toggle.UnitedProxy;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;
import com.tencent.xweb.FileReaderHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011JN\u0010\f\u001a\u00020\u000b2!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H\u0002JN\u0010\r\u001a\u00020\u000b2!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00030\u00022!\u0010\n\u001a\u001d\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/api/impl/VasPageToggleImpl;", "Lcom/tencent/mobileqq/vas/api/IVasPageToggle;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "configScheme", "schemeBuilder", ZPlanPublishSource.FROM_SCHEME, "", "success", "", "innerJudgeUseKuiklyShopPage", "isUseKuiklyShopPage", "troopNickUseShopListPage", "Z", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class VasPageToggleImpl implements IVasPageToggle {

    @NotNull
    private static final String TAG = "VasPageToggleImpl";
    private static final boolean sShopListEnable;

    @NotNull
    private static final UnitedProxy sShopListToggle;
    private boolean troopNickUseShopListPage = sShopListEnable;

    static {
        UnitedProxy b16 = com.tencent.mobileqq.vas.ar.INSTANCE.b("shouyouye", "2024-08-22", "vas_troop_nick_shop_list_config");
        sShopListToggle = b16;
        sShopListEnable = b16.onIsEnable(false);
    }

    private final boolean innerJudgeUseKuiklyShopPage(Function1<? super String, String> schemeBuilder, Function1<? super String, Unit> success) {
        boolean z16;
        if (!sShopListEnable) {
            return false;
        }
        JSONObject json = sShopListToggle.getJson();
        String kuiklyUrl = json.optString("kuikly_url", "");
        if (TextUtils.isEmpty(kuiklyUrl)) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(kuiklyUrl, "kuiklyUrl");
        String kuiklyUrl2 = schemeBuilder.invoke(kuiklyUrl);
        QLog.i(TAG, 1, "isUseKuiklyShopPage real url:" + kuiklyUrl2);
        if (json.optInt(FileReaderHelper.OPEN_FILE_FROM_FORCE, 0) == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            QLog.i(TAG, 1, "isUseKuiklyShopPage force jump");
            Intrinsics.checkNotNullExpressionValue(kuiklyUrl2, "kuiklyUrl");
            success.invoke(kuiklyUrl2);
            return true;
        }
        String abtestName = json.optString("abtest");
        if (TextUtils.isEmpty(abtestName)) {
            QLog.i(TAG, 1, "isUseKuiklyShopPage abtest name is empty");
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(abtestName, "abtestName");
        if (VasTabFactory.b("shouyouye", "2024-08-22", abtestName, null, 8, null).b().component1() == VasTabFactory.ABTest.B) {
            QLog.i(TAG, 1, "isUseKuiklyShopPage abtest is in exp");
            Intrinsics.checkNotNullExpressionValue(kuiklyUrl2, "kuiklyUrl");
            success.invoke(kuiklyUrl2);
            return true;
        }
        QLog.i(TAG, 1, "isUseKuiklyShopPage abtest is out exp");
        return false;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasPageToggle
    public boolean isUseKuiklyShopPage(@NotNull Function1<? super String, String> schemeBuilder, @NotNull Function1<? super String, Unit> success) {
        Intrinsics.checkNotNullParameter(schemeBuilder, "schemeBuilder");
        Intrinsics.checkNotNullParameter(success, "success");
        boolean innerJudgeUseKuiklyShopPage = innerJudgeUseKuiklyShopPage(schemeBuilder, success);
        this.troopNickUseShopListPage = innerJudgeUseKuiklyShopPage;
        return innerJudgeUseKuiklyShopPage;
    }

    @Override // com.tencent.mobileqq.vas.api.IVasPageToggle
    /* renamed from: troopNickUseShopListPage, reason: from getter */
    public boolean getTroopNickUseShopListPage() {
        return this.troopNickUseShopListPage;
    }
}
