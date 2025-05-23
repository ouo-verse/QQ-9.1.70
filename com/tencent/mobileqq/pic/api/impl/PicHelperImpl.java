package com.tencent.mobileqq.pic.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.h;
import com.tencent.mobileqq.pic.j;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.ProtocolDownloaderConstants;
import com.tencent.mobileqq.transfile.TranDbRecord;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.util.aw;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

/* loaded from: classes16.dex */
public class PicHelperImpl implements IPicHelper {
    static IPatchRedirector $redirector_;

    public PicHelperImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean hasBigFile(MessageForPic messageForPic) {
        return hasFile(messageForPic, ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE);
    }

    public static boolean hasFile(MessageForPic messageForPic, String str) {
        if (messageForPic.isSendFromLocal()) {
            v picUploadInfo = messageForPic.getPicUploadInfo();
            picUploadInfo.I = str;
            return picUploadInfo.f();
        }
        k picDownloadInfo = messageForPic.getPicDownloadInfo();
        picDownloadInfo.I = str;
        return picDownloadInfo.f();
    }

    public static boolean hasRawFile(MessageForPic messageForPic) {
        return hasFile(messageForPic, ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW);
    }

    public static boolean hasThumbFile(MessageForPic messageForPic) {
        return hasFile(messageForPic, "chatthumb");
    }

    public static boolean isImageExpiredStatic(String str) {
        String[] split;
        if (!TextUtils.isEmpty(str) && (split = str.split("_", 2)) != null && split.length == 2) {
            try {
                return PicDownloadExplicitError.isImageExpires(Integer.parseInt(split[0]), split[1]);
            } catch (NumberFormatException unused) {
            }
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public void cachePicToDisk(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            cachePicToDisk(messageForPic, null);
        } else {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) messageForPic);
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public String getBiggestFilePath(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (String) iPatchRedirector.redirect((short) 15, (Object) this, (Object) messageForPic);
        }
        if (hasRawFile(messageForPic)) {
            return messageForPic.getFilePath(ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW);
        }
        if (hasBigFile(messageForPic)) {
            return messageForPic.getFilePath(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE);
        }
        if (hasThumbFile(messageForPic)) {
            return messageForPic.getFilePath("chatthumb");
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public URLDrawable getDrawable(t tVar, int i3, String str, URLDrawable.URLDrawableOptions uRLDrawableOptions) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = false;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (URLDrawable) iPatchRedirector.redirect((short) 10, this, tVar, Integer.valueOf(i3), str, uRLDrawableOptions);
        }
        if (tVar == null) {
            return null;
        }
        URL url = getURL(tVar, i3, str);
        String memoryCacheKeySuffix = getMemoryCacheKeySuffix(tVar, i3, str);
        if (!TextUtils.isEmpty(memoryCacheKeySuffix)) {
            if (uRLDrawableOptions == null) {
                uRLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
            }
            uRLDrawableOptions.mMemoryCacheKeySuffix = memoryCacheKeySuffix;
        }
        URLDrawable drawable = URLDrawable.getDrawable(url, uRLDrawableOptions);
        drawable.setTag(tVar);
        if (!tVar.isSendFromLocal()) {
            if (j.f258723a) {
                drawable.setAutoDownload(true);
            } else {
                boolean readValue = SettingCloneUtil.readValue((Context) BaseApplication.getContext(), (String) null, BaseApplication.getContext().getString(R.string.czu), AppConstants.QQSETTING_AUTO_RECEIVE_PIC_KEY, true);
                if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1 || readValue) {
                    z16 = true;
                }
                drawable.setAutoDownload(z16);
            }
        }
        return drawable;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004b, code lost:
    
        if (com.tencent.mobileqq.transfile.ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW.equals(r6) != false) goto L17;
     */
    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int getFileSizeType(String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Integer) iPatchRedirector.redirect((short) 11, this, str, Boolean.valueOf(z16))).intValue();
        }
        if (!"chatthumb".equals(str)) {
            if (ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE.equals(str)) {
                if (z16) {
                    return 1;
                }
            }
            return 131075;
        }
        return 65537;
    }

    String getHost(h hVar) {
        if (hVar == null) {
            return null;
        }
        int i3 = hVar.f258713h;
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 1000 && i3 != 1001 && i3 != 1008 && i3 != 1009 && i3 != 1020) {
                    if (i3 != 3000) {
                        if (i3 != 10002 && i3 != 10004 && i3 != 10008 && i3 != 1023 && i3 != 1024) {
                            switch (i3) {
                                case 1004:
                                case 1005:
                                case 1006:
                                    break;
                                default:
                                    return null;
                            }
                        }
                    } else {
                        return ProtocolDownloaderConstants.HOST_DISSCUSSION;
                    }
                }
            } else {
                return ProtocolDownloaderConstants.HOST_GROUP;
            }
        }
        return ProtocolDownloaderConstants.HOST_C2C;
    }

    public String getMemoryCacheKeySuffix(t tVar, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, this, tVar, Integer.valueOf(i3), str);
        }
        if (tVar == null) {
            return null;
        }
        return getMemoryCacheKeySuffix(tVar.isSendFromLocal() ? tVar.getPicUploadInfo() : tVar.getPicDownloadInfo(), i3, str);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public String getMsgSummaryForAnimationPic(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this, (Object) messageForPic);
        }
        if (messageForPic == null) {
            return null;
        }
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData != null) {
            String str = picMessageExtraData.textSummary;
            if (!TextUtils.isEmpty(str)) {
                if (QLog.isColorLevel()) {
                    QLog.d("msgSummary", 2, "textSummary: " + aw.a(str));
                }
                return str;
            }
        }
        PicMessageExtraData picMessageExtraData2 = messageForPic.picExtraData;
        if (picMessageExtraData2 != null && picMessageExtraData2.isEmotion()) {
            return BaseApplication.getContext().getString(R.string.iml);
        }
        if (!messageForPic.checkGif()) {
            return null;
        }
        return BaseApplication.getContext().getString(R.string.iml);
    }

    String getProtocol(h hVar, int i3) {
        String str;
        if (i3 == 65537) {
            str = "chatthumb";
        } else if (i3 == 1) {
            str = ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE;
        } else if (i3 == 131075) {
            str = ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW;
        } else {
            str = null;
        }
        if (hVar.f258713h == 8000) {
            return AbsDownloader.PROTOCAL_FAVORITE_IMAGE;
        }
        return str;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public URL getURL(String str, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (URL) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, i3);
        }
        try {
            return new URL(i3 == 65537 ? "chatthumb" : (i3 != 1 && i3 == 131075) ? ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW : ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE, (String) null, str);
        } catch (MalformedURLException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public boolean isEmotion(MessageForPic messageForPic) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) messageForPic)).booleanValue();
        }
        if (messageForPic.checkGif()) {
            return true;
        }
        PicMessageExtraData picMessageExtraData = messageForPic.picExtraData;
        if (picMessageExtraData != null) {
            return picMessageExtraData.isEmotion();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public boolean isImageExpired(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, (Object) str)).booleanValue();
        }
        return isImageExpiredStatic(str);
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public void parseDbMsgOldVersion(MessageForPic messageForPic, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) messageForPic, (Object) str);
            return;
        }
        TranDbRecord.PicDbRecord picDbRecord = new TranDbRecord.PicDbRecord();
        picDbRecord.initFromMsg(str);
        messageForPic.path = picDbRecord.path;
        messageForPic.size = picDbRecord.size;
        messageForPic.type = picDbRecord.type;
        messageForPic.isRead = picDbRecord.isRead;
        messageForPic.uuid = picDbRecord.uuid;
        messageForPic.md5 = picDbRecord.md5;
        messageForPic.serverStoreSource = picDbRecord.serverStoreSource;
        messageForPic.thumbMsgUrl = picDbRecord.thumbMsgUrl;
        messageForPic.bigThumbMsgUrl = picDbRecord.bigThumbMsgUrl;
        messageForPic.bigMsgUrl = picDbRecord.bigMsgUrl;
        messageForPic.rawMsgUrl = picDbRecord.rawMsgUrl;
        messageForPic.picExtraFlag = picDbRecord.extraFlag;
        messageForPic.picExtraObject = picDbRecord.extraObject;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public void cachePicToDisk(MessageForPic messageForPic, String str) {
        URL url;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) messageForPic, (Object) str);
            return;
        }
        String str2 = messageForPic.md5;
        if (str2 == null) {
            return;
        }
        URL url2 = getURL(str2, messageForPic.fileSizeFlag == 1 ? 131075 : 1);
        String url3 = url2 != null ? url2.toString() : null;
        if (!AbsDownloader.hasFile(url3)) {
            FileUtils.copyFile(messageForPic.path, AbsDownloader.getFilePath(url3));
        }
        if (TextUtils.isEmpty(str) || (url = getURL(messageForPic.md5, 65537)) == null) {
            return;
        }
        FileUtils.copyFile(str, AbsDownloader.getFilePath(url.toString()));
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0076, code lost:
    
        if ("".equals(r9) != false) goto L39;
     */
    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public URL getURL(v vVar, int i3, String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (URL) iPatchRedirector.redirect((short) 5, this, vVar, Integer.valueOf(i3), str);
        }
        if (vVar == null) {
            return null;
        }
        String host = vVar.G < 4 ? getHost(vVar) : null;
        String protocol2 = getProtocol(vVar, i3);
        if (vVar.f258713h == 8000 && i3 == 65537) {
            str2 = vVar.L;
        } else {
            String str3 = vVar.J;
            if (str3 != null && !"".equals(str3)) {
                str2 = vVar.J;
            } else {
                String str4 = vVar.f258711e;
                if (str4 != null && !"".equals(str4)) {
                    str2 = vVar.f258711e;
                } else {
                    String str5 = vVar.K;
                    str2 = (str5 == null || "".equals(str5)) ? "" : vVar.K;
                }
            }
        }
        if (str2 != null) {
            try {
            } catch (MalformedURLException e16) {
                e16.printStackTrace();
            }
        }
        if (QLog.isColorLevel()) {
            QLog.e("PicBaseInfo", 2, "getURL file == null" + vVar.toString());
        }
        if (str != null && str2 != null) {
            return new URL(str, host, str2);
        }
        if (protocol2 != null && str2 != null) {
            return new URL(protocol2, host, str2);
        }
        return null;
    }

    public String getMemoryCacheKeySuffix(h hVar, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, this, hVar, Integer.valueOf(i3), str);
        }
        if (hVar.f258713h == 10014 && i3 == 65537) {
            return IGuildPicAIO.GUILD_PIC_URLDRAWABLE_STUFF;
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public URL getURL(k kVar, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (URL) iPatchRedirector.redirect((short) 6, this, kVar, Integer.valueOf(i3), str);
        }
        if (kVar == null) {
            return null;
        }
        String str2 = kVar.J;
        if (str2 == null || "null".equals(str2) || "".equals(str2)) {
            if (kVar.f258713h == 8000 && i3 == 65537) {
                str2 = kVar.M;
            } else {
                str2 = kVar.K;
            }
        }
        if (kVar.V) {
            i3 = 1;
        }
        if (str == null) {
            str = getProtocol(kVar, i3);
        }
        if (str2 == null) {
            try {
                str2 = "holyshit_" + System.currentTimeMillis();
                if (QLog.isColorLevel()) {
                    QLog.e("PicBaseInfo", 2, "getURL file == null" + kVar.toString());
                }
            } catch (MalformedURLException e16) {
                QLog.e("PicBaseInfo", 1, "getURL error ", e16);
                return null;
            }
        }
        if (str != null) {
            return new URL(str, (String) null, str2);
        }
        return null;
    }

    @Override // com.tencent.mobileqq.pic.api.IPicHelper
    public URL getURL(t tVar, int i3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (URL) iPatchRedirector.redirect((short) 7, this, tVar, Integer.valueOf(i3), str);
        }
        if (tVar == null) {
            return null;
        }
        if (tVar.isSendFromLocal()) {
            return getURL(tVar.getPicUploadInfo(), i3, str);
        }
        return getURL(tVar.getPicDownloadInfo(), i3, str);
    }
}
