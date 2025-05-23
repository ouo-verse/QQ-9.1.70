package com.tencent.mobileqq.profilecard.bussiness.guide.handler;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.profilecard.bussiness.guide.bean.ProfileGuide;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xf12.oidb_0xf12$ReqBody;
import tencent.im.oidb.cmd0xf12.oidb_0xf12$RspBody;
import tencent.im.oidb.cmd0xf13.oidb_0xf13$ReqBody;
import tencent.im.oidb.oidb_sso$OIDBSSOPkg;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0006\u0010\b\u001a\u00020\tJ$\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J$\u0010\u0011\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013H\u0014J&\u0010\u0015\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideHandler;", "Lcom/tencent/mobileqq/app/BusinessHandler;", "app", "Lcom/tencent/common/app/AppInterface;", "(Lcom/tencent/common/app/AppInterface;)V", "getCommandList", "", "", "getProfileGuide", "", "handleGetProfileGuide", "req", "Lcom/tencent/qphone/base/remote/ToServiceMsg;", "res", "Lcom/tencent/qphone/base/remote/FromServiceMsg;", "data", "", "handleReportProfileGuideRead", "observerClass", "Ljava/lang/Class;", "Lcom/tencent/mobileqq/app/BusinessObserver;", "onReceive", "reportProfileGuideRead", "guideId", "", "guideType", QCircleDaTongConstant.ElementParamValue.OPERATION, "Companion", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes16.dex */
public class ProfileGuideHandler extends BusinessHandler {
    static IPatchRedirector $redirector_ = null;

    @NotNull
    public static final String CMD_GET_PROFILE_GUIDE = "OidbSvc.0xf12";

    @NotNull
    public static final String CMD_REPORT_PROFILE_GUIDE_READ = "OidbSvc.0xf13";

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    @NotNull
    public static final String TAG = "ProfileGuideHandler";

    @NotNull
    private final AppInterface app;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/profilecard/bussiness/guide/handler/ProfileGuideHandler$Companion;", "", "()V", "CMD_GET_PROFILE_GUIDE", "", "CMD_REPORT_PROFILE_GUIDE_READ", "TAG", "profilecard-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes16.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(18524);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ProfileGuideHandler(@NotNull AppInterface app) {
        super(app);
        Intrinsics.checkNotNullParameter(app, "app");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) app);
        } else {
            this.app = app;
        }
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler, com.tencent.mobileqq.app.BaseBusinessHandler
    @NotNull
    public Set<String> getCommandList() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (Set) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        if (this.allowCmdSet == null) {
            HashSet hashSet = new HashSet();
            this.allowCmdSet = hashSet;
            hashSet.add(CMD_GET_PROFILE_GUIDE);
            this.allowCmdSet.add(CMD_REPORT_PROFILE_GUIDE_READ);
        }
        Set<String> allowCmdSet = this.allowCmdSet;
        Intrinsics.checkNotNullExpressionValue(allowCmdSet, "allowCmdSet");
        return allowCmdSet;
    }

    public final void getProfileGuide() {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        AppInterface appInterface = this.app;
        if (appInterface != null) {
            l3 = Long.valueOf(appInterface.getLongAccountUin());
        } else {
            l3 = null;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("getProfileGuide uin=%s", Arrays.copyOf(new Object[]{l3}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(TAG, 2, format);
        }
        if (l3 != null) {
            oidb_0xf12$ReqBody oidb_0xf12_reqbody = new oidb_0xf12$ReqBody();
            oidb_0xf12_reqbody.uint64_uin.set(l3.longValue());
            sendPbReq(makeOIDBPkg(CMD_GET_PROFILE_GUIDE, 3858, 0, oidb_0xf12_reqbody.toByteArray()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00ca  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleGetProfileGuide(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        int i3;
        boolean z16;
        boolean z17;
        boolean z18;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, req, res, data);
            return;
        }
        if (res != null) {
            i3 = res.getResultCode();
        } else {
            i3 = -1;
        }
        if (res != null) {
            z16 = res.isSuccess();
        } else {
            z16 = false;
        }
        if (z16 && data != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        ProfileGuide profileGuide = null;
        if (z17) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "pkg.mergeFrom(data as ByteArray)");
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg2 = mergeFrom;
                i3 = oidb_sso_oidbssopkg2.uint32_result.get();
                if (i3 == 0) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18 && oidb_sso_oidbssopkg2.bytes_bodybuffer.has()) {
                    oidb_0xf12$RspBody oidb_0xf12_rspbody = new oidb_0xf12$RspBody();
                    oidb_0xf12_rspbody.mergeFrom(oidb_sso_oidbssopkg2.bytes_bodybuffer.get().toByteArray());
                    int i16 = oidb_0xf12_rspbody.uint32_guidecardid.get();
                    int i17 = oidb_0xf12_rspbody.uint32_guidecardtype.get();
                    String str = oidb_0xf12_rspbody.str_main_msg.get();
                    String str2 = oidb_0xf12_rspbody.str_secondary_msg.get();
                    ProfileGuide profileGuide2 = new ProfileGuide();
                    try {
                        profileGuide2.setGuideId(i16);
                        profileGuide2.setGuideType(i17);
                        profileGuide2.setGuideMainMsg(str);
                        profileGuide2.setGuideSecondaryMsg(str2);
                        z17 = z18;
                        profileGuide = profileGuide2;
                    } catch (Exception e16) {
                        e = e16;
                        profileGuide = profileGuide2;
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String format = String.format("handleGetProfileGuide decode fail, resultCode=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                        Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                        QLog.e(TAG, 1, format, e);
                        z17 = false;
                        if (QLog.isColorLevel()) {
                        }
                        notifyUI(1, z17, profileGuide);
                    }
                } else {
                    z17 = z18;
                }
            } catch (Exception e17) {
                e = e17;
            }
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("handleGetProfileGuide resultCode=%s success=%s profileGuide=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Boolean.valueOf(z17), profileGuide}, 3));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            QLog.d(TAG, 2, format2);
        }
        notifyUI(1, z17, profileGuide);
    }

    public final void handleReportProfileGuideRead(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        int i3;
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, req, res, data);
            return;
        }
        if (res != null) {
            i3 = res.getResultCode();
        } else {
            i3 = -1;
        }
        if (res != null) {
            z16 = res.isSuccess();
        } else {
            z16 = false;
        }
        if (z16 && data != null) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (z17) {
            try {
                oidb_sso$OIDBSSOPkg oidb_sso_oidbssopkg = new oidb_sso$OIDBSSOPkg();
                Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.ByteArray");
                oidb_sso$OIDBSSOPkg mergeFrom = oidb_sso_oidbssopkg.mergeFrom((byte[]) data);
                Intrinsics.checkNotNullExpressionValue(mergeFrom, "pkg.mergeFrom(data as ByteArray)");
                i3 = mergeFrom.uint32_result.get();
                if (i3 == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
            } catch (Exception e16) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format("handleReportProfileGuideRead decode fail, resultCode=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i3)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                QLog.e(TAG, 1, format, e16);
            }
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String format2 = String.format("handleReportProfileGuideRead resultCode=%s success=%s", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Boolean.valueOf(z17)}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(format, *args)");
            QLog.d(TAG, 2, format2);
        }
        notifyUI(2, z17, null);
    }

    @Override // com.tencent.mobileqq.app.BusinessHandler
    @NotNull
    protected Class<? extends BusinessObserver> observerClass() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Class) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return ProfileGuideObserver.class;
    }

    @Override // com.tencent.mobileqq.app.BaseBusinessHandler
    public void onReceive(@Nullable ToServiceMsg req, @Nullable FromServiceMsg res, @Nullable Object data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, req, res, data);
            return;
        }
        if (req != null) {
            str = req.getServiceCmd();
        } else {
            str = null;
        }
        if (msgCmdFilter(str)) {
            return;
        }
        if (Intrinsics.areEqual(str, CMD_GET_PROFILE_GUIDE)) {
            handleGetProfileGuide(req, res, data);
        } else if (Intrinsics.areEqual(str, CMD_REPORT_PROFILE_GUIDE_READ)) {
            handleReportProfileGuideRead(req, res, data);
        }
    }

    public final void reportProfileGuideRead(int guideId, int guideType, int operation) {
        Long l3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, Integer.valueOf(guideId), Integer.valueOf(guideType), Integer.valueOf(operation));
            return;
        }
        AppInterface appInterface = this.app;
        if (appInterface != null) {
            l3 = Long.valueOf(appInterface.getLongAccountUin());
        } else {
            l3 = null;
        }
        if (QLog.isColorLevel()) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format("reportProfileGuideRead uin=%s guideId=%s guideType=%s guideOp=%s", Arrays.copyOf(new Object[]{l3, Integer.valueOf(guideId), Integer.valueOf(guideType), Integer.valueOf(operation)}, 4));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            QLog.d(TAG, 2, format);
        }
        if (l3 != null) {
            oidb_0xf13$ReqBody oidb_0xf13_reqbody = new oidb_0xf13$ReqBody();
            oidb_0xf13_reqbody.uint64_uin.set(l3.longValue());
            oidb_0xf13_reqbody.uint32_guidecardid.set(guideId);
            oidb_0xf13_reqbody.uint32_guidecardtype.set(guideType);
            oidb_0xf13_reqbody.uint32_operation.set(operation);
            sendPbReq(makeOIDBPkg(CMD_REPORT_PROFILE_GUIDE_READ, 3859, 0, oidb_0xf13_reqbody.toByteArray()));
        }
    }
}
