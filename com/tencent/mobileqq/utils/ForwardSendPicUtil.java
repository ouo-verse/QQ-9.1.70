package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.guild.api.share.IGuildForwardUtilsApi;
import com.tencent.mobileqq.activity.photo.ImageInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.freesia_wrapper.FreesiaWrapperImpl;

/* loaded from: classes20.dex */
public class ForwardSendPicUtil {
    private static String a(Context context, String str, int i3, boolean z16) {
        int i16;
        if (FreesiaWrapperImpl.INSTANCE.b().isSwitchOn("forward_pic_compress_switch", true)) {
            QLog.d("ForwardSendPicUtil", 1, "new compressImage");
            CompressInfo compressInfo = new CompressInfo(str, 0, 1009);
            compressInfo.T = true;
            ((ICompressOperator) QRoute.api(ICompressOperator.class)).start(compressInfo);
            return compressInfo.H;
        }
        String sDKPrivatePath = VFSAssistantUtils.getSDKPrivatePath(aw.j(context, str, i3));
        ImageInfo imageInfo = new ImageInfo();
        if (z16) {
            i16 = 7;
        } else {
            i16 = 4;
        }
        aw.c(i16, context, str, sDKPrivatePath, true, imageInfo, i3);
        return imageInfo.f184139m;
    }

    public static boolean b(final QQAppInterface qQAppInterface, String str, int i3, String str2, final int i16, String str3, boolean z16, Context context, int i17) {
        boolean z17;
        Intent intent;
        if ((context instanceof Activity) && (intent = ((Activity) context).getIntent()) != null) {
            z17 = intent.getBooleanExtra("isFromFavorites", false);
        } else {
            z17 = false;
        }
        aw.m(-1L, i16, true, "image_send_prepare", ("ForwardSendPicUtil.sendPicTo." + context.getClass().getSimpleName()) + ", isQzoneShare=" + z16);
        String encodeFileHexStr = MD5Utils.encodeFileHexStr(str);
        if (QLog.isColorLevel()) {
            QLog.d("ForwardSendPicUtil", 2, "[@]call compressImage start!");
        }
        final String str4 = str;
        if (!z17) {
            str4 = a(context, str4, i16, z16);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardSendPicUtil", 2, "[@]call compressImage end!");
        }
        if (!FileUtils.fileExistsAndNotEmpty(str4)) {
            if (QLog.isColorLevel()) {
                QLog.d("ForwardSendPicUtil", 2, "sendPicTo,pic not exist,return false!");
            }
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardSendPicUtil", 2, "[@]call addAndSendPicMsgRecord start!");
        }
        if (str4 != null && qQAppInterface != null) {
            int i18 = 1009;
            if (((IFeatureRuntimeService) qQAppInterface.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("enable_change_business_type_for_fav") && z17) {
                i18 = 1053;
            }
            v.a aVar = new v.a();
            aVar.v(str4);
            aVar.m(i18);
            aVar.x(str2);
            aVar.y(0);
            aVar.A(str3);
            aVar.B(qQAppInterface.getCurrentAccountUin());
            aVar.I(i16);
            com.tencent.mobileqq.pic.u uVar = new com.tencent.mobileqq.pic.u();
            uVar.f258814k = encodeFileHexStr;
            aVar.o(uVar);
            com.tencent.mobileqq.pic.p createPicReq = ((IPicBus) QRoute.api(IPicBus.class)).createPicReq(2, i18);
            createPicReq.f(aVar.l());
            createPicReq.I = i17;
            if (i16 == 10014) {
                Intent intent2 = new Intent();
                intent2.putExtra(AppConstants.Key.FORWARD_FILEPATH, str4);
                intent2.putExtra("uin", str2);
                String guildIdOf = ((IGPSService) qQAppInterface.getRuntimeService(IGPSService.class, "")).getGuildIdOf(str2);
                if (!TextUtils.isEmpty(guildIdOf)) {
                    intent2.putExtra("guild_id", guildIdOf);
                    String a16 = com.tencent.mobileqq.activity.aio.forward.b.d().a(i17);
                    if (!TextUtils.isEmpty(a16)) {
                        intent2.putExtra(AppConstants.Key.SHARE_RES_COMMENT_MESSAGE, a16);
                    }
                    ((IGuildForwardUtilsApi) QRoute.api(IGuildForwardUtilsApi.class)).forwardToGuild(intent2, 2);
                    return true;
                }
                QLog.i("ForwardSendPicUtil", 1, "forward photo to guild error! guildId not found. channelId: " + str2 + ", filePath: " + str4);
            }
            com.tencent.mobileqq.forward.utils.f fVar = com.tencent.mobileqq.forward.utils.f.f211079a;
            fVar.m(fVar.c(i16, str2, str3), str4, i3);
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.utils.ForwardSendPicUtil.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        com.tencent.mobileqq.activity.photo.m.k(new String[]{str4}, i16, false, true, -1, qQAppInterface);
                    } catch (Exception unused) {
                    }
                }
            }, 5, null, false);
        }
        if (QLog.isColorLevel()) {
            QLog.d("ForwardSendPicUtil", 2, "[@]call addAndSendPicMsgRecord end!");
        }
        return true;
    }

    public static boolean c(QQAppInterface qQAppInterface, String str, String str2, int i3, String str3, boolean z16, Context context) {
        return b(qQAppInterface, str, 0, str2, i3, str3, z16, context, 0);
    }
}
