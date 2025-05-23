package com.tencent.mobileqq.zplan.push;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor;
import com.tencent.mobileqq.zplan.avatar.edit.ZPlanEditAvatarUtils;
import com.tencent.mobileqq.zplan.avatar.image.ZPlanAvatarImageManager;
import com.tencent.mobileqq.zplan.model.ZPlanUserInfo;
import com.tencent.mobileqq.zplan.persistent.ZplanDataRepository;
import com.tencent.mobileqq.zplan.servlet.ZPlanRequest;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.servlet.ZPlanRequestHandler;
import com.tencent.sqshow.utils.featureswitch.ZPlanFeatureSwitch;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb$UdcUinData;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001#B\u000f\u0012\u0006\u0010%\u001a\u00020\"\u00a2\u0006\u0004\b(\u0010)J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\u0002H\u0016J\u0012\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u0014\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0011\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0015H\u0016J\b\u0010\u0017\u001a\u00020\u0007H\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u0015J \u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u0016\u0010!\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0018R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010&\u00a8\u0006*"}, d2 = {"Lcom/tencent/mobileqq/zplan/push/ZPlanProfileProcessor;", "Lcom/tencent/mobileqq/profilecommon/processor/AbsProfileCommonProcessor;", "", "appearanceKey", "uin", "", "notifyBusinessObserver", "", "b", "flag", "g", "getProcessorKey", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$ReqBody;", "reqBody", "onGetProfileDetailRequestForLogin", "Landroid/os/Bundle;", Const.BUNDLE_KEY_REQUEST, "success", "Ltencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData;", "udcUinData", "onGetProfileDetailResponse", "", "onProcessProfileModifyPushBegin", "onProcessProfileModifyPushEnd", "", "type", "Lcom/tencent/mobileqq/pb/ByteStringMicro;", "bytesValue", "onProcessProfileModifyPush", "timestamp", "f", "d", "gender", "c", "Lmqq/app/AppRuntime;", "a", "Lmqq/app/AppRuntime;", "app", "J", "profileModifyUin", "<init>", "(Lmqq/app/AppRuntime;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZPlanProfileProcessor extends AbsProfileCommonProcessor {

    /* renamed from: a, reason: from kotlin metadata */
    private final AppRuntime app;

    /* renamed from: b, reason: from kotlin metadata */
    private long profileModifyUin;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZPlanProfileProcessor(AppRuntime app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        this.app = app;
    }

    public final void b(String appearanceKey, String uin, boolean notifyBusinessObserver) {
        List listOf;
        QLog.i("[zplan][ZPlanProfileProcessor]", 1, "handleModifyProfileAppearanceKey, uin:" + uin + ", appearanceKey:" + appearanceKey + ", notifyBusinessObserver:" + notifyBusinessObserver);
        ZplanDataRepository.f334898a.F(uin, appearanceKey);
        if (notifyBusinessObserver) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(uin);
            String name = ZPlanRequestHandler.class.getName();
            AppRuntime appRuntime = this.app;
            Intrinsics.checkNotNull(appRuntime, "null cannot be cast to non-null type com.tencent.common.app.AppInterface");
            BusinessHandler businessHandler = ((AppInterface) appRuntime).getBusinessHandler(name);
            Intrinsics.checkNotNull(businessHandler, "null cannot be cast to non-null type com.tencent.sqshow.servlet.ZPlanRequestHandler");
            ((ZPlanRequestHandler) businessHandler).notifyUI(27405, true, listOf);
        }
    }

    private final void g(boolean flag) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            QLog.i("[zplan][ZPlanProfileProcessor]", 1, "handleModifyZPlanEditAvatarFlag flag:" + flag);
            ZPlanEditAvatarUtils.f331613a.i0(peekAppRuntime, flag);
        }
    }

    public final void c(String uin, int gender) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("[zplan][ZPlanProfileProcessor]", 1, "handleModifyAppearanceGender uin:" + uin + ", gender:" + gender);
        ZplanDataRepository.f334898a.I(uin, gender);
    }

    public final void d(String uin, String appearanceKey, boolean notifyBusinessObserver) {
        List<String> listOf;
        Intrinsics.checkNotNullParameter(uin, "uin");
        Intrinsics.checkNotNullParameter(appearanceKey, "appearanceKey");
        b(appearanceKey, uin, notifyBusinessObserver);
        if (ZPlanFeatureSwitch.f369852a.F()) {
            ZPlanRequest zPlanRequest = ZPlanRequest.f335367a;
            listOf = CollectionsKt__CollectionsJVMKt.listOf(uin);
            zPlanRequest.k(listOf, new b(uin, this, notifyBusinessObserver));
        }
    }

    public final void f(String uin, long timestamp) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        QLog.i("[zplan][ZPlanProfileProcessor]", 1, "handleModifyAppearanceTimeStamp, uin:" + uin + ", timeStamp:" + timestamp);
        ZplanDataRepository.f334898a.H(uin, timestamp);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public String getProcessorKey() {
        return "[zplan][ZPlanProfileProcessor]";
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPush(int type, ByteStringMicro bytesValue) {
        Intrinsics.checkNotNullParameter(bytesValue, "bytesValue");
        if (type == 27404) {
            f(String.valueOf(this.profileModifyUin), ByteBuffer.wrap(bytesValue.toByteArray()).asIntBuffer().get());
        } else {
            if (type != 27405) {
                if (type != 45140) {
                    return;
                }
                c(String.valueOf(this.profileModifyUin), ByteBuffer.wrap(bytesValue.toByteArray()).asIntBuffer().get());
                return;
            }
            String appearanceKey = bytesValue.toStringUtf8();
            String valueOf = String.valueOf(this.profileModifyUin);
            Intrinsics.checkNotNullExpressionValue(appearanceKey, "appearanceKey");
            d(valueOf, appearanceKey, !String.valueOf(this.profileModifyUin).equals(this.app.getAccount()));
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushBegin(long uin) {
        super.onProcessProfileModifyPushBegin(uin);
        QLog.i("[zplan][ZPlanProfileProcessor]", 1, "onProcessProfileModifyPushBegin, uin:" + uin);
        this.profileModifyUin = uin;
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onProcessProfileModifyPushEnd() {
        super.onProcessProfileModifyPushEnd();
        QLog.i("[zplan][ZPlanProfileProcessor]", 1, "onProcessProfileModifyPushEnd persistResult=" + ZplanDataRepository.f334898a.r(String.valueOf(this.profileModifyUin)));
        this.profileModifyUin = 0L;
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/zplan/push/ZPlanProfileProcessor$b", "Lcom/tencent/mobileqq/zplan/servlet/d;", "", "success", "", "result", "", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zplan.servlet.d {

        /* renamed from: a */
        final /* synthetic */ String f335033a;

        /* renamed from: b */
        final /* synthetic */ ZPlanProfileProcessor f335034b;

        /* renamed from: c */
        final /* synthetic */ boolean f335035c;

        b(String str, ZPlanProfileProcessor zPlanProfileProcessor, boolean z16) {
            this.f335033a = str;
            this.f335034b = zPlanProfileProcessor;
            this.f335035c = z16;
        }

        @Override // com.tencent.mobileqq.zplan.servlet.d
        public void a(boolean success, Object result) {
            ZPlanUserInfo zPlanUserInfo;
            String str;
            if (!success || result == null || (zPlanUserInfo = (ZPlanUserInfo) ((Map) result).get(this.f335033a)) == null || (str = zPlanUserInfo.appearanceKey) == null) {
                return;
            }
            this.f335034b.b(str, this.f335033a, this.f335035c);
        }
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public boolean onGetProfileDetailRequestForLogin(oidb_0x5eb$ReqBody reqBody) {
        PBUInt32Field pBUInt32Field;
        PBUInt32Field pBUInt32Field2;
        PBUInt32Field pBUInt32Field3;
        PBUInt32Field pBUInt32Field4;
        PBUInt32Field pBUInt32Field5;
        if (reqBody != null && (pBUInt32Field5 = reqBody.req_zplanphoto_url) != null) {
            pBUInt32Field5.set(1);
        }
        if (reqBody != null && (pBUInt32Field4 = reqBody.req_zplan_avatar_gender) != null) {
            pBUInt32Field4.set(1);
        }
        if (reqBody != null && (pBUInt32Field3 = reqBody.req_zplan_appearanceKey) != null) {
            pBUInt32Field3.set(1);
        }
        if (reqBody != null && (pBUInt32Field2 = reqBody.req_zplan_appearanceKey_time) != null) {
            pBUInt32Field2.set(1);
        }
        if (reqBody != null && (pBUInt32Field = reqBody.uint32_flag_zplan_edit_avatar) != null) {
            pBUInt32Field.set(1);
        }
        return true;
    }

    public static /* synthetic */ void e(ZPlanProfileProcessor zPlanProfileProcessor, String str, String str2, boolean z16, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z16 = true;
        }
        zPlanProfileProcessor.d(str, str2, z16);
    }

    @Override // com.tencent.mobileqq.profilecommon.processor.AbsProfileCommonProcessor
    public void onGetProfileDetailResponse(Bundle r75, boolean success, oidb_0x5eb$UdcUinData udcUinData) {
        String str;
        if (!success || udcUinData == null) {
            return;
        }
        ZPlanAvatarImageManager.INSTANCE.a().H();
        if (udcUinData.uint64_uin.has()) {
            str = String.valueOf(udcUinData.uint64_uin.get());
        } else {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null || (str = peekAppRuntime.getCurrentUin()) == null) {
                str = null;
            }
        }
        if (str == null) {
            return;
        }
        String a16 = com.tencent.zplan.common.utils.i.a(str);
        QLog.i("[zplan][ZPlanProfileProcessor]", 1, "onGetProfileDetailResponse, uin:" + a16);
        if (udcUinData.zplan_avatar_gender.has()) {
            c(str, udcUinData.zplan_avatar_gender.get());
        }
        if (udcUinData.zplan_appearanceKey.has()) {
            String stringUtf8 = udcUinData.zplan_appearanceKey.get().toStringUtf8();
            Intrinsics.checkNotNullExpressionValue(stringUtf8, "udcUinData.zplan_appeara\u2026eKey.get().toStringUtf8()");
            d(str, stringUtf8, false);
        }
        if (udcUinData.zplan_appearanceKey_time.has()) {
            f(str, udcUinData.zplan_appearanceKey_time.get());
        }
        if (udcUinData.uint32_flag_zplan_edit_avatar.has()) {
            g(udcUinData.uint32_flag_zplan_edit_avatar.get() > 0);
        }
        QLog.i("[zplan][ZPlanProfileProcessor]", 1, "onGetProfileDetailResponse persistUserInfo, uin:" + a16);
        ZplanDataRepository.f334898a.r(str);
    }
}
