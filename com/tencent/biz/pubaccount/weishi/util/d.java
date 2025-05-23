package com.tencent.biz.pubaccount.weishi.util;

import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.PlatformInfor;
import cooperation.qzone.report.datong.QZoneDTLoginReporter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tencent.gdt.access;
import tencent.gdt.qq_ad_get;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\t\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/biz/pubaccount/weishi/util/d;", "", "", QZoneDTLoginReporter.SCHEMA, "Ltencent/gdt/access$AdGetReq;", "a", "Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;", "c", "d", "", "b", "adBuffer", "Ltencent/gdt/access$AdGetRsp;", "e", "<init>", "()V", "qqweishi_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public static final d f81760a = new d();

    d() {
    }

    private final access.AdGetReq a(String schema) {
        access.AdGetReq adGetReq = new access.AdGetReq();
        qq_ad_get.QQAdGet qQAdGet = new qq_ad_get.QQAdGet();
        try {
            adGetReq.busi_type.set(24);
            adGetReq.client_mod.set(d());
            adGetReq.schema_source.set(schema);
            qq_ad_get.QQAdGet.PositionInfo positionInfo = new qq_ad_get.QQAdGet.PositionInfo();
            positionInfo.pos_id.set("2053233236499077");
            positionInfo.ad_count.set(2);
            qq_ad_get.QQAdGet.PositionInfo.PositionExt positionExt = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
            positionExt.deep_link_version.set(1);
            positionInfo.pos_ext.set(positionExt);
            qQAdGet.position_info.add(positionInfo);
            qq_ad_get.QQAdGet.DeviceInfo c16 = c();
            if (c16 != null) {
                qQAdGet.device_info.set(c16);
            }
            qQAdGet.user_info.set(new qq_ad_get.QQAdGet.UserInfo());
        } catch (Throwable th5) {
            QLog.d("WSAdRequestUtils", 2, "create ad request failed, error is " + th5);
        }
        adGetReq.qq_ad_get.set(qQAdGet);
        return adGetReq;
    }

    private final qq_ad_get.QQAdGet.DeviceInfo c() {
        try {
            GdtDeviceInfoHelper.Result create = GdtDeviceInfoHelper.create(RFWApplication.getApplication(), new GdtDeviceInfoHelper.Params());
            if (create == null) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d("WSAdRequestUtils", 2, "gdt device info init success");
            }
            return create.deviceInfo;
        } catch (Exception e16) {
            QLog.e("WSAdRequestUtils", 1, "Error when get gdt device info", e16);
            return null;
        }
    }

    private final String d() {
        String str;
        if (SimpleUIUtil.isNowElderMode()) {
            str = PlatformInfor.ELDER_MODE;
        } else {
            str = "default";
        }
        return StudyModeManager.t() ? "teenager" : str;
    }

    public final byte[] b(String schema) {
        Intrinsics.checkNotNullParameter(schema, "schema");
        return a(schema).toByteArray();
    }

    public final access.AdGetRsp e(byte[] adBuffer) {
        Intrinsics.checkNotNullParameter(adBuffer, "adBuffer");
        access.AdGetRsp adGetRsp = new access.AdGetRsp();
        adGetRsp.mergeFrom(adBuffer);
        return adGetRsp;
    }
}
