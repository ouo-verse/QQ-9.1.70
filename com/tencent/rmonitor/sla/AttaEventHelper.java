package com.tencent.rmonitor.sla;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.bugly.common.meta.UserMeta;
import com.tencent.bugly.common.privacy.PrivacyInformation;
import com.tencent.bugly.common.utils.OSVersionFormatUtil;
import com.tencent.rmonitor.base.meta.BaseInfo;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\"\u0010\u0006\u001a\u00020\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0014\u0010\r\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/rmonitor/sla/AttaEventHelper;", "", "", "field", "Lkotlin/Function0;", "block", "c", "Lcom/tencent/rmonitor/sla/c;", "attaEvent", "", "a", "", "list", "b", "<init>", "()V", "rmonitor-core_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class AttaEventHelper {

    /* renamed from: a, reason: collision with root package name */
    public static final AttaEventHelper f365808a = new AttaEventHelper();

    AttaEventHelper() {
    }

    private final String c(String field, Function0<String> block) {
        if (TextUtils.isEmpty(field)) {
            String invoke = block.invoke();
            if (invoke == null) {
                return "";
            }
            return invoke;
        }
        if (field == null) {
            Intrinsics.throwNpe();
        }
        return field;
    }

    public final void a(@NotNull AttaEvent attaEvent) {
        long currentTimeMillis;
        Intrinsics.checkParameterIsNotNull(attaEvent, "attaEvent");
        attaEvent.N(c(attaEvent.getAppVersion(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$1
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return BaseInfo.userMeta.appVersion;
            }
        }));
        attaEvent.M(c(attaEvent.getAppName(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$2
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return com.tencent.rmonitor.common.util.a.f365523c.a(BaseInfo.app);
            }
        }));
        attaEvent.K(c(attaEvent.getAppBundleId(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$3
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                String packageName;
                Application application = BaseInfo.app;
                return (application == null || (packageName = application.getPackageName()) == null) ? "" : packageName;
            }
        }));
        attaEvent.L(c(attaEvent.getAppKey(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$4
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                StringBuilder sb5 = new StringBuilder();
                UserMeta userMeta = BaseInfo.userMeta;
                sb5.append(userMeta.appKey);
                sb5.append("-");
                sb5.append(userMeta.appId);
                return sb5.toString();
            }
        }));
        attaEvent.s0(c(attaEvent.getUserId(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$5
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return BaseInfo.userMeta.uin;
            }
        }));
        attaEvent.q0(c(attaEvent.getSdkVersion(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$6
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return "4.4.3";
            }
        }));
        if (attaEvent.getEventTime() > 0) {
            currentTimeMillis = attaEvent.getEventTime();
        } else {
            currentTimeMillis = System.currentTimeMillis();
        }
        attaEvent.U(currentTimeMillis);
        attaEvent.r0(System.currentTimeMillis());
        attaEvent.P(c(attaEvent.getDeviceId(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$7
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return BaseInfo.userMeta.getUniqueID();
            }
        }));
        attaEvent.Z(c(attaEvent.getOsVersion(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$8
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
                int androidFrameworkVersion = privacyInformation.getAndroidFrameworkVersion();
                PrivacyInformation privacyInformation2 = PrivacyInformation.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(privacyInformation2, "PrivacyInformation.getInstance()");
                return OSVersionFormatUtil.formatOSVersion(androidFrameworkVersion, privacyInformation2.getOSVersion());
            }
        }));
        attaEvent.X(c(attaEvent.getManufacturer(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$9
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
                return privacyInformation.getManufacture();
            }
        }));
        attaEvent.Y(c(attaEvent.getModel(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$10
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
                return privacyInformation.getModel();
            }
        }));
        attaEvent.p0(c(attaEvent.getProductId(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$11
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final String invoke() {
                return BaseInfo.userMeta.appId;
            }
        }));
        attaEvent.V(c(attaEvent.getFullOSVersion(), new Function0<String>() { // from class: com.tencent.rmonitor.sla.AttaEventHelper$fillBaseInfo$12
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                PrivacyInformation privacyInformation = PrivacyInformation.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(privacyInformation, "PrivacyInformation.getInstance()");
                int androidFrameworkVersion = privacyInformation.getAndroidFrameworkVersion();
                PrivacyInformation privacyInformation2 = PrivacyInformation.getInstance();
                Intrinsics.checkExpressionValueIsNotNull(privacyInformation2, "PrivacyInformation.getInstance()");
                return OSVersionFormatUtil.makeFullOSVersion(androidFrameworkVersion, privacyInformation2.getOSVersion());
            }
        }));
    }

    public final void b(@NotNull List<AttaEvent> list) {
        Intrinsics.checkParameterIsNotNull(list, "list");
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            f365808a.a((AttaEvent) it.next());
        }
    }
}
