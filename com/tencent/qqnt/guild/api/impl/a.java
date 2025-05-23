package com.tencent.qqnt.guild.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0005B+\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0016R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0006R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0006R\u001e\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/qqnt/guild/api/impl/a;", "Lax3/a;", "", "b", "c", "a", "Ljava/lang/String;", "tabName", "freesiaName", "defaultSwitch", "d", "appId", "", "", "e", "[Ljava/lang/Object;", "prevConfig", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "f", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
final class a implements ax3.a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String tabName;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String freesiaName;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String defaultSwitch;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String appId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Object[] prevConfig;

    public a(@NotNull String tabName, @NotNull String freesiaName, @NotNull String defaultSwitch, @NotNull String appId) {
        Intrinsics.checkNotNullParameter(tabName, "tabName");
        Intrinsics.checkNotNullParameter(freesiaName, "freesiaName");
        Intrinsics.checkNotNullParameter(defaultSwitch, "defaultSwitch");
        Intrinsics.checkNotNullParameter(appId, "appId");
        this.tabName = tabName;
        this.freesiaName = freesiaName;
        this.defaultSwitch = defaultSwitch;
        this.appId = appId;
        this.prevConfig = new Object[0];
    }

    private final String b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadAsString(this.freesiaName, this.defaultSwitch);
    }

    private final String c() {
        String str;
        Map<String, String> tabParams = ABTestController.getInstance().getExpEntity(this.appId, this.tabName).getTabParams();
        if (tabParams == null || (str = tabParams.get("flag")) == null) {
            return this.defaultSwitch;
        }
        return str;
    }

    @Override // ax3.a
    @NotNull
    /* renamed from: a */
    public String getF356919a() {
        String c16;
        QRouteApi api = QRoute.api(IUnitedConfigManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IUnitedConfigManager::class.java)");
        boolean isSwitchOn = ((IUnitedConfigManager) api).isSwitchOn(this.freesiaName, false);
        if (isSwitchOn) {
            c16 = b();
        } else {
            c16 = c();
        }
        Object[] objArr = {Boolean.valueOf(isSwitchOn), c16};
        if (!Arrays.equals(this.prevConfig, objArr)) {
            String str = this.freesiaName;
            String str2 = this.tabName;
            String arrays = Arrays.toString(objArr);
            Intrinsics.checkNotNullExpressionValue(arrays, "toString(this)");
            QLog.i("SwitchConfigImpl", 1, "readSwitch() SwitchConfig changed: " + str + "/" + str2 + ", config is " + arrays);
            this.prevConfig = objArr;
        }
        return c16;
    }

    public /* synthetic */ a(String str, String str2, String str3, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i3 & 4) != 0 ? "0" : str3, (i3 & 8) != 0 ? ABTestController.APPID_1505 : str4);
    }
}
