package com.tencent.mobileqq.vas.theme.api.impl;

import android.os.Bundle;
import com.qq.wx.voice.util.ErrorCode;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.theme.ThemeConstants;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.theme.ThemeReporter;
import com.tencent.mobileqq.vas.theme.api.IThemeRequest;
import com.tencent.mobileqq.vas.theme.api.impl.ThemeRequestImpl;
import com.tencent.mobileqq.vas.util.VasUtil;
import com.tencent.pb.theme.ThemeAuth$ReqBody;
import com.tencent.pb.theme.ThemeAuth$RspBody;
import com.tencent.pb.theme.ThemeAuth$SubCmd0x3ReqSet;
import com.tencent.pb.theme.ThemeAuth$SubCmd0x3RspSet;
import com.tencent.pb.theme.ThemeAuth$diyThemeInfo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00122\u00020\u0001:\u0001\u0013B\u0007\u00a2\u0006\u0004\b\u0010\u0010\u0011J@\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bH\u0002J0\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u001e\u0010\u000b\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n0\bH\u0016\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/vas/theme/api/impl/ThemeRequestImpl;", "Lcom/tencent/mobileqq/vas/theme/api/IThemeRequest;", "Lcom/tencent/pb/theme/ThemeAuth$RspBody;", "rspBody", "", "isSuccess", "", "requestThemeID", "Lkotlin/Function3;", "", "", "callback", "activeCallback", "Landroid/os/Bundle;", "reqBundle", "setTheme", "<init>", "()V", "Companion", "a", "vas-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes20.dex */
public final class ThemeRequestImpl implements IThemeRequest {
    public static final int COMD3 = 3;

    @NotNull
    public static final String TAG = "ThemeRequestImpl";

    private final boolean activeCallback(ThemeAuth$RspBody rspBody, boolean isSuccess, String requestThemeID, Function3<? super String, ? super Integer, ? super String, Unit> callback) {
        String valueOf;
        int i3;
        String str;
        ThemeAuth$SubCmd0x3RspSet themeAuth$SubCmd0x3RspSet = rspBody.msg_subcmd0x3_rsp_set.get();
        if (isSuccess) {
            i3 = themeAuth$SubCmd0x3RspSet.int32_result.get();
            valueOf = String.valueOf(themeAuth$SubCmd0x3RspSet.uint32_theme_id.get());
            str = themeAuth$SubCmd0x3RspSet.str_diy_theme_err_msg.get();
            Intrinsics.checkNotNullExpressionValue(str, "str_diy_theme_err_msg.get()");
        } else {
            valueOf = String.valueOf(themeAuth$SubCmd0x3RspSet.uint32_theme_id.get());
            i3 = ErrorCode.WX_TTS_ERROR_TEXT_TO_GBK;
            str = "\u670d\u52a1\u5668\u4fdd\u5b58\u8d85\u65f6\uff0c\u8bf7\u91cd\u8bd5\u3002";
        }
        VasLogReporter.Companion companion = VasLogReporter.INSTANCE;
        VasLogReportProxy.report$default(companion.getTheme(), "handleThemeAuth Set result:" + i3 + ", themeId:" + ((Object) valueOf), null, 2, null);
        if (Intrinsics.areEqual(requestThemeID, valueOf)) {
            companion.getTheme().reportLow("handleThemeAuth set back themeId=" + ((Object) valueOf) + ", result=" + i3);
            callback.invoke(valueOf, Integer.valueOf(i3), str);
            return false;
        }
        companion.getTheme().reportLow("handleThemeAuth set back timeout");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setTheme$lambda$2(ThemeRequestImpl this$0, String themeId, Function3 callback, int i3, boolean z16, Object obj) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(themeId, "$themeId");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        if (obj instanceof ThemeAuth$RspBody) {
            VasLogReporter.INSTANCE.getTheme().reportLow("setSVTheme, receive isSuccess[" + z16 + "]");
            this$0.activeCallback((ThemeAuth$RspBody) obj, z16, themeId, callback);
            return;
        }
        VasLogReporter.INSTANCE.getTheme().reportLow("setSVTheme, receive error");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x00e9  */
    @Override // com.tencent.mobileqq.vas.theme.api.IThemeRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void setTheme(@NotNull Bundle reqBundle, @NotNull final Function3<? super String, ? super Integer, ? super String, Unit> callback) {
        boolean z16;
        int parseInt;
        Intrinsics.checkNotNullParameter(reqBundle, "reqBundle");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String string = reqBundle.getString("themeId");
        if (string == null) {
            return;
        }
        String string2 = reqBundle.getString("seriesID");
        VasLogReporter.INSTANCE.getTheme().reportLow("setSVTheme, themeId=" + string + ", seriesIdStr=" + string2);
        ThemeAuth$SubCmd0x3ReqSet themeAuth$SubCmd0x3ReqSet = new ThemeAuth$SubCmd0x3ReqSet();
        themeAuth$SubCmd0x3ReqSet.uint32_theme_id.set(Integer.parseInt(string));
        if (string2 != null && string2.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            try {
                parseInt = Integer.parseInt(string2);
            } catch (Exception unused) {
            }
            themeAuth$SubCmd0x3ReqSet.uint32_suit_id.set(parseInt);
            if (!Intrinsics.areEqual(ThemeReporter.FROM_DIY, reqBundle.getString("key_from"))) {
                ThemeAuth$diyThemeInfo themeAuth$diyThemeInfo = new ThemeAuth$diyThemeInfo();
                PBUInt32Field pBUInt32Field = themeAuth$diyThemeInfo.uin32_drawer_tab_id;
                String string3 = reqBundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_DRAWER);
                Intrinsics.checkNotNull(string3);
                pBUInt32Field.set(Integer.parseInt(string3));
                PBUInt32Field pBUInt32Field2 = themeAuth$diyThemeInfo.uin32_message_tab_id;
                String string4 = reqBundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_MESSAGE);
                Intrinsics.checkNotNull(string4);
                pBUInt32Field2.set(Integer.parseInt(string4));
                PBUInt32Field pBUInt32Field3 = themeAuth$diyThemeInfo.uin32_aio_tab_id;
                String string5 = reqBundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_AIO);
                Intrinsics.checkNotNull(string5);
                pBUInt32Field3.set(Integer.parseInt(string5));
                PBUInt32Field pBUInt32Field4 = themeAuth$diyThemeInfo.uin32_freind_tab_id;
                String string6 = reqBundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_FRIEND);
                Intrinsics.checkNotNull(string6);
                pBUInt32Field4.set(Integer.parseInt(string6));
                PBUInt32Field pBUInt32Field5 = themeAuth$diyThemeInfo.uin32_dynamics_tab_id;
                String string7 = reqBundle.getString(ThemeConstants.BUNDLE_KEY_PAGE_DYNAMIC);
                Intrinsics.checkNotNull(string7);
                pBUInt32Field5.set(Integer.parseInt(string7));
                themeAuth$SubCmd0x3ReqSet.diy_theme_info.set(themeAuth$diyThemeInfo);
                themeAuth$SubCmd0x3ReqSet.uint32_diy_theme_flag.set(1);
            } else {
                themeAuth$SubCmd0x3ReqSet.uint32_diy_theme_flag.set(0);
            }
            ThemeAuth$ReqBody themeAuth$ReqBody = new ThemeAuth$ReqBody();
            themeAuth$ReqBody.uint32_sub_cmd.set(3);
            themeAuth$ReqBody.int32_plat_id.set(109);
            themeAuth$ReqBody.str_qq_version.set(AppSetting.f99554n);
            PBUInt32Field pBUInt32Field6 = themeAuth$ReqBody.uint32_qq_version;
            String buildNum = AppSetting.f99542b;
            Intrinsics.checkNotNullExpressionValue(buildNum, "buildNum");
            pBUInt32Field6.set(Integer.parseInt(buildNum));
            themeAuth$ReqBody.msg_subcmd0x3_req_set.set(themeAuth$SubCmd0x3ReqSet);
            themeAuth$ReqBody.setHasFlag(true);
            VasUtil.getService().getPbRequest().request(ThemeConstants.CMD_THEME_AUTH, themeAuth$ReqBody, ThemeAuth$RspBody.class, new BusinessObserver() { // from class: h33.a
                @Override // com.tencent.mobileqq.app.BusinessObserver
                public final void onUpdate(int i3, boolean z17, Object obj) {
                    ThemeRequestImpl.setTheme$lambda$2(ThemeRequestImpl.this, string, callback, i3, z17, obj);
                }
            });
        }
        parseInt = 0;
        themeAuth$SubCmd0x3ReqSet.uint32_suit_id.set(parseInt);
        if (!Intrinsics.areEqual(ThemeReporter.FROM_DIY, reqBundle.getString("key_from"))) {
        }
        ThemeAuth$ReqBody themeAuth$ReqBody2 = new ThemeAuth$ReqBody();
        themeAuth$ReqBody2.uint32_sub_cmd.set(3);
        themeAuth$ReqBody2.int32_plat_id.set(109);
        themeAuth$ReqBody2.str_qq_version.set(AppSetting.f99554n);
        PBUInt32Field pBUInt32Field62 = themeAuth$ReqBody2.uint32_qq_version;
        String buildNum2 = AppSetting.f99542b;
        Intrinsics.checkNotNullExpressionValue(buildNum2, "buildNum");
        pBUInt32Field62.set(Integer.parseInt(buildNum2));
        themeAuth$ReqBody2.msg_subcmd0x3_req_set.set(themeAuth$SubCmd0x3ReqSet);
        themeAuth$ReqBody2.setHasFlag(true);
        VasUtil.getService().getPbRequest().request(ThemeConstants.CMD_THEME_AUTH, themeAuth$ReqBody2, ThemeAuth$RspBody.class, new BusinessObserver() { // from class: h33.a
            @Override // com.tencent.mobileqq.app.BusinessObserver
            public final void onUpdate(int i3, boolean z17, Object obj) {
                ThemeRequestImpl.setTheme$lambda$2(ThemeRequestImpl.this, string, callback, i3, z17, obj);
            }
        });
    }
}
