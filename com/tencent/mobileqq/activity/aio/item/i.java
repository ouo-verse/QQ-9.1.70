package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.confess.ConfessInfo;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.hotpic.HotPicData;
import com.tencent.mobileqq.pic.aio.a;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.PicElement;
import cooperation.peak.PeakConstants;
import java.io.File;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes10.dex */
public class i {

    /* renamed from: a, reason: collision with root package name */
    public static int f179470a = 100;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f179471b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f179472c = true;

    /* compiled from: P */
    /* loaded from: classes10.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public URL f179473a;

        /* renamed from: b, reason: collision with root package name */
        public boolean f179474b;

        /* renamed from: c, reason: collision with root package name */
        public boolean f179475c;

        public a(MessageForPic messageForPic) {
            messageForPic.checkType();
            if (QLog.isColorLevel()) {
                QLog.d("PicItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + messageForPic.uniseq + " url:" + this.f179473a);
            }
            int i3 = messageForPic.imageType;
            if ((i3 == 3 || i3 == 2000) && i.f179472c) {
                this.f179474b = true;
                URL url = URLDrawableHelper.getURL(messageForPic, 1, null);
                if (AbsDownloader.getFile(url.toString()) != null) {
                    this.f179473a = url;
                    this.f179475c = true;
                    if (QLog.isColorLevel()) {
                        QLog.d("PicItemBuilder", 2, "getThumbDrawable,using GIF_BIG,uniseq:" + messageForPic.uniseq + " url:" + this.f179473a);
                    }
                }
            }
            if (this.f179473a == null) {
                this.f179473a = URLDrawableHelper.getURL(messageForPic, 65537, null);
                if (QLog.isColorLevel()) {
                    QLog.d("PicItemBuilder", 2, "getThumbDrawable,using thumb,uniseq:" + messageForPic.uniseq + " url:" + this.f179473a);
                }
            }
        }

        @NonNull
        public String toString() {
            URL url = this.f179473a;
            if (url != null) {
                return url.toString();
            }
            return super.toString();
        }
    }

    public static void a(MessageForPic messageForPic, Intent intent) {
        MsgElement msgElement;
        PicElement picElement;
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData != null) {
            if (picMessageExtraData.isCustomFace()) {
                intent.putExtra(AppConstants.Key.FORWARD_IS_CUSTOM_FACE, true);
                intent.putExtra(AppConstants.Key.FORWARD_CUSTOM_FACE_TYPE, messageForPic.picExtraData.customFaceType);
                intent.putExtra(AppConstants.Key.FORWARD_DIY_PACKAGE_ID, messageForPic.picExtraData.emojiPkgId);
                intent.putExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA, messageForPic.picExtraData.textSummary);
            } else if (messageForPic.picExtraData.isHotPics()) {
                intent.putExtra(HotPicData.HOT_PIC_HAS_EXTRA, true);
                intent.putExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA, messageForPic.picExtraData.textSummary);
            } else if (!messageForPic.picExtraData.isStickerPics() && !messageForPic.picExtraData.isStickerAdPic()) {
                if (messageForPic.picExtraData.isZhitu()) {
                    intent.putExtra(AppConstants.Key.FORWARD_IS_ZHITU, true);
                    intent.putExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA, messageForPic.picExtraData.textSummary);
                } else if (messageForPic.picExtraData.isSelfieFace()) {
                    intent.putExtra(AppConstants.Key.FORWARD_IS_SELFIE_FACE, true);
                    intent.putExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA, messageForPic.picExtraData.textSummary);
                    if (!TextUtils.isEmpty(messageForPic.picExtraData.mTemplateId)) {
                        intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, messageForPic.picExtraData.mTemplateId);
                    }
                } else if (!TextUtils.isEmpty(messageForPic.picExtraData.mTemplateId)) {
                    intent.putExtra(AppConstants.Key.FORWARD_SEND_TEMPLATE_PIC, true);
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_VIDEOPARAM, messageForPic.picExtraData.mTemplateId);
                    intent.putExtra(PeakConstants.KEY_QQ_CAMERA_MATERIAL_NAME, messageForPic.picExtraData.mTemplateName);
                }
            } else {
                if (messageForPic.picExtraData.isStickerPics()) {
                    intent.putExtra(AppConstants.Key.FORWARD_IS_STICKER, true);
                } else {
                    intent.putExtra(AppConstants.Key.FORWARD_IS_STICKER_AD, true);
                    intent.putExtra(IPicBus.AD_EMO_JUMP_URL, messageForPic.picExtraData.mAdEmoJumpUrl);
                    intent.putExtra(IPicBus.AD_EMO_DESC_STR, messageForPic.picExtraData.mAdEmoDescStr);
                }
                intent.putExtra(AppConstants.Key.FORWARD_SUMMARY_EXTRA, messageForPic.picExtraData.textSummary);
                intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_FROM, messageForPic.picExtraData.from);
                intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_INFO, messageForPic.picExtraData.source);
                intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_WEBURL, messageForPic.picExtraData.webUrl);
                intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_ICONURL, messageForPic.picExtraData.iconUrl);
                intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_PACKAGE, messageForPic.picExtraData.packageName);
                intent.putExtra(PeakConstants.KEY_EMOTION_SOURCE_EPID, messageForPic.picExtraData.emojiPkgId);
            }
        }
        Object obj = messageForPic.extObj;
        if (obj != null && (obj instanceof MsgElement) && (picElement = (msgElement = (MsgElement) obj).picElement) != null) {
            intent.putExtra(AppConstants.Key.FORWARD_PIC_SUB_TYPE, picElement.picSubType);
            Integer num = msgElement.picElement.picSubSubType;
            if (num != null) {
                intent.putExtra(AppConstants.Key.FORWARD_PIC_SUB_SUB_TYPE, num);
            }
            if (msgElement.picElement.getEmojiMall() != null) {
                intent.putExtra(AppConstants.Key.FORWARD_PIC_PACKAGE_ID, msgElement.picElement.getEmojiMall().packageId);
            }
        }
    }

    static Intent b(MessageForPic messageForPic, SessionInfo sessionInfo, QQAppInterface qQAppInterface, Context context) {
        boolean z16;
        int i3;
        int i16;
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", 1);
        bundle.putInt(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, sessionInfo.f179555d);
        Intent intent = new Intent();
        intent.putExtra(AppConstants.Key.FORWARD_IMAGE_WIDTH, messageForPic.width);
        intent.putExtra(AppConstants.Key.FORWARD_IMAGE_HEIGHT, messageForPic.height);
        intent.putExtra(AppConstants.Key.FORWARD_FILE_SIZE, messageForPic.size);
        intent.putExtra(AppConstants.Key.FORWARD_IMAGE_TYPE, messageForPic.imageType);
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, messageForPic.path);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_TASK_KEY, messageForPic.frienduin + messageForPic.uniseq + messageForPic.istroop);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN, messageForPic.frienduin);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ORG_UIN_TYPE, messageForPic.istroop);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_SERVER_PATH, messageForPic.uuid);
        intent.putExtra(AppConstants.Key.FORWARD_DOWNLOAD_IMAGE_ITEM_ID, messageForPic.uniseq);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_ISSEND, messageForPic.issend);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_SENDER_UIN, messageForPic.senderuin);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_MD5, messageForPic.md5);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_GROUP_FILEID, messageForPic.groupFileID);
        intent.putExtra(AppConstants.Key.FORWARD_PHOTO_FILE_SIZE_FLAG, messageForPic.fileSizeFlag);
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData != null) {
            intent.putExtra(AppConstants.Key.FORWARD_PHOTO_IMAGEBIZ_TYPE, picMessageExtraData.imageBizType);
            intent.putExtra(AppConstants.Key.FORWARD_PHOTO_ORIGIN_IMAGE_MD5, messageForPic.picExtraData.mOriginImageMd5);
        }
        intent.putExtras(bundle);
        if (!com.tencent.mobileqq.utils.c.h(messageForPic.msgtype) && (i16 = messageForPic.msgtype) != -3001 && i16 != -30002 && i16 != -30003) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            i3 = 65537;
        } else {
            i3 = 1;
        }
        URL url = URLDrawableHelper.getURL(messageForPic, i3);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE, true);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_THUMB_URL, url.toString());
        intent.putExtra(AppConstants.Key.FORWARD_URL_KEY, messageForPic.localUUID);
        URLDrawable n3 = ForwardUtils.n(context, messageForPic);
        intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, n3.getURL().toString());
        intent.putExtra("uinname", sessionInfo.f179563i);
        intent.putExtra(PeakConstants.MY_UIN, qQAppInterface.getAccount());
        intent.putExtra(PeakConstants.MY_NICK, qQAppInterface.getCurrentNickname());
        intent.putExtra("is_anonymous", com.tencent.biz.anonymous.a.h().d(sessionInfo.f179557e));
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra(PeakConstants.DEST_ACTIVITY_CLASS_NAME, SendPhotoActivity.class.getName());
        intent.putExtra(PeakConstants.DEST_ACTIVITY_PACKAGE_NAME, "com.tencent.mobileqq");
        intent.putExtra(PeakConstants.IS_SEND_TO_AIO, true);
        intent.putExtra(PeakConstants.SEND_BUSINESS_TYPE, 1009);
        intent.putExtra(PeakConstants.IS_WAIT_DEST_RESULT, true);
        intent.putExtra(ConfessInfo.KEY_CONFESS_TOPICID, sessionInfo.S);
        if (sessionInfo.f179555d != 10014) {
            intent.addFlags(603979776);
        }
        intent.putExtra(AppConstants.Key.FORWARD_MSG_FOR_PIC, messageForPic);
        if (FileUtils.fileExistsAndNotEmpty(messageForPic.path)) {
            intent.putExtra(AppConstants.Key.FORWARD_EXTRA, messageForPic.path);
        } else {
            String url2 = n3.getURL().toString();
            String str = null;
            if (AbsDownloader.hasFile(url2)) {
                File file = AbsDownloader.getFile(url2);
                if (file != null) {
                    str = file.getAbsolutePath();
                }
            } else {
                File file2 = AbsDownloader.getFile(URLDrawableHelper.getURL(messageForPic, 65537).toString());
                if (file2 != null && file2.exists()) {
                    str = file2.getAbsolutePath();
                }
            }
            intent.putExtra(AppConstants.Key.FORWARD_EXTRA, str);
        }
        intent.putExtra("direct_send_if_dataline_forward", true);
        intent.putExtra(AppConstants.Key.FORWARD_SOURCE_UIN_TYPE, sessionInfo.f179555d);
        intent.putExtra(AppConstants.Key.BUSI_TYPE, 1009);
        return intent;
    }

    public static URL c(MessageForPic messageForPic) {
        return new a(messageForPic).f179473a;
    }

    public static URLDrawable d(Context context, MessageForPic messageForPic) {
        return e(context, messageForPic, null, null);
    }

    public static URLDrawable e(Context context, MessageForPic messageForPic, ChatThumbView chatThumbView, int[] iArr) {
        j();
        return f(context, messageForPic, chatThumbView, iArr, null);
    }

    static URLDrawable f(Context context, MessageForPic messageForPic, ChatThumbView chatThumbView, int[] iArr, a aVar) {
        Bundle bundle;
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData != null && picMessageExtraData.isZPlanPic()) {
            bundle = new Bundle();
            bundle.putInt(AbstractGifImage.KEY_REFRESH_DELAY, 0);
        } else {
            bundle = null;
        }
        return new a.C8223a(messageForPic).e(chatThumbView).d(iArr).b(aVar).c(bundle).a().c();
    }

    public static Intent g(MessageForPic messageForPic, SessionInfo sessionInfo, QQAppInterface qQAppInterface, Context context) {
        Intent b16 = b(messageForPic, sessionInfo, qQAppInterface, context);
        a(messageForPic, b16);
        return b16;
    }

    public static void h(QQAppInterface qQAppInterface, int i3, String str, String str2, String str3, String str4) {
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        if (qQAppInterface != null && !TextUtils.isEmpty(str3) && AppConstants.EmotionMachineCategory.EXPRESSION_MACHINE_UIN.equals(str)) {
            if (i3 == -2) {
                str5 = "";
            } else {
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 3000) {
                            str9 = "other";
                        } else {
                            str9 = "discuss";
                        }
                    } else {
                        str9 = VipFunCallConstants.KEY_GROUP;
                    }
                } else {
                    str9 = "c2c";
                }
                str5 = str9;
            }
            if (qQAppInterface.getCurrentUin() == null) {
                str6 = "";
            } else {
                str6 = qQAppInterface.getCurrentUin();
            }
            if (str4 == null) {
                str7 = "";
            } else {
                str7 = str4;
            }
            if (str2 == null) {
                str8 = "";
            } else {
                str8 = str2;
            }
            ReportController.o(qQAppInterface, "dc00898", "", "", str3, str3, 0, 0, str6, str7, str5, str8);
        }
    }

    public static void i(QQAppInterface qQAppInterface, String str, String str2, String str3, String str4) {
        h(qQAppInterface, -2, str, str2, str3, str4);
    }

    public static void j() {
        String featureValue;
        if (!f179471b && (featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_gifplay.name())) != null && featureValue.length() > 0) {
            String[] split = featureValue.split("\\|");
            if (split.length >= 3) {
                f179472c = split[0].equals("1");
                try {
                    int parseInt = Integer.parseInt(split[2]);
                    f179470a = parseInt;
                    if (parseInt < 0) {
                        f179470a = 100;
                    }
                } catch (NumberFormatException unused) {
                    f179470a = 100;
                }
                AbstractGifImage.DoAccumulativeRunnable.DELAY = f179470a;
                f179471b = true;
            }
        }
    }
}
