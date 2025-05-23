package com.tencent.mobileqq.utils;

import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\t\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0004\u001a\u00020\u0002J\u0006\u0010\u0005\u001a\u00020\u0002R$\u0010\f\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0007\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0013\u001a\u00020\r8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/utils/dl;", "", "", "d", "a", "e", "Lcom/tencent/mobileqq/utils/di;", "b", "Lcom/tencent/mobileqq/utils/di;", "()Lcom/tencent/mobileqq/utils/di;", "f", "(Lcom/tencent/mobileqq/utils/di;)V", "configBean", "", "c", "Z", "()Z", "setNeedReloadUI", "(Z)V", "needReloadUI", "<init>", "()V", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class dl {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final dl f307676a = new dl();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static QQSettingMeViewListBean configBean;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static boolean needReloadUI;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/utils/dl$a", "Lpy2/a;", "Lcom/tencent/mobileqq/utils/di;", DownloadInfo.spKey_Config, "", "b", "drawer-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes20.dex */
    public static final class a implements py2.a<QQSettingMeViewListBean> {
        a() {
        }

        @Override // py2.a
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@Nullable QQSettingMeViewListBean config) {
            int i3;
            Integer num;
            Integer drawerUIForm;
            if (config != null) {
                QLog.i("QQSettingMeViewListConfigRepo", 1, "[loadAppConfig]: config is " + config);
            }
            dl dlVar = dl.f307676a;
            dlVar.f(config);
            QQSettingMeViewListBean b16 = dlVar.b();
            if (b16 != null && (drawerUIForm = b16.getDrawerUIForm()) != null) {
                i3 = drawerUIForm.intValue();
            } else {
                i3 = 1;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("[loadAppConfig]: drawerUIForm is ");
            QQSettingMeViewListBean b17 = dlVar.b();
            if (b17 != null) {
                num = b17.getDrawerUIForm();
            } else {
                num = null;
            }
            sb5.append(num);
            sb5.append(",drawerUI:");
            sb5.append(i3);
            sb5.append(TokenParser.SP);
            QLog.i("QQSettingMeViewListConfigRepo", 1, sb5.toString());
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            Intrinsics.checkNotNullExpressionValue(fromV2, "fromV2(MobileQQ.sMobileQQ, QMMKVFile.FILE_COMMON)");
            fromV2.putInt("IS_USED_DRAWER_UI_V3", i3, true);
        }
    }

    dl() {
    }

    public final void a() {
        needReloadUI = true;
        configBean = null;
    }

    @Nullable
    public final QQSettingMeViewListBean b() {
        return configBean;
    }

    public final boolean c() {
        return needReloadUI;
    }

    public final void d() {
        QLog.i("QQSettingMeViewListConfigRepo", 1, "[loadAppConfig]: loaded is force");
        ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadLargeConfigAsync("setting_me_view_list_v3", new a());
    }

    public final void e() {
        needReloadUI = false;
    }

    public final void f(@Nullable QQSettingMeViewListBean qQSettingMeViewListBean) {
        configBean = qQSettingMeViewListBean;
    }
}
