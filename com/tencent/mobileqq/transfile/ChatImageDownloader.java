package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.DownloadParams;
import com.tencent.image.GifDrawable;
import com.tencent.image.RoundRectBitmap;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.LogTag;
import com.tencent.mobileqq.app.ac;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.guild.media.pic.api.IGuildPicAIO;
import com.tencent.mobileqq.haoliyou.JefsClass;
import com.tencent.mobileqq.msf.core.c0.j;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IPicAIO;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.pic.api.impl.PicPreDownloadImpl;
import com.tencent.mobileqq.pic.f;
import com.tencent.mobileqq.pic.i;
import com.tencent.mobileqq.pic.k;
import com.tencent.mobileqq.pic.n;
import com.tencent.mobileqq.pic.operator.DownloadPicOperator;
import com.tencent.mobileqq.pic.p;
import com.tencent.mobileqq.pic.t;
import com.tencent.mobileqq.pic.v;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.TranDbRecord;
import com.tencent.mobileqq.transfile.bitmapcreator.CustomBitmap;
import com.tencent.mobileqq.transfile.bitmapcreator.ExifBitmapCreator;
import com.tencent.mobileqq.transfile.chatpic.PicDownloadExplicitError;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import mqq.app.AccountNotMatchException;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ChatImageDownloader extends BaseImageDownloader {
    static IPatchRedirector $redirector_ = null;
    static final String TAG = "ChatImageDownloader";
    protected BaseApplication application;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public class DownloadData {
        static IPatchRedirector $redirector_;
        AppInterface app;
        BaseApplication application;
        public k downInfo;
        int fileSizeType;
        URLDrawableHandler handler;
        String host;
        public String logId;
        public int mPrioty;
        public int netWorkType;
        OutputStream out;
        public MessageForPic pic;
        boolean sendFromLoacal;
        String sendPath;
        public long startOffset;
        public int uinType;
        public v upInfo;
        URL url;

        public DownloadData() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ChatImageDownloader.this);
                return;
            }
            this.mPrioty = 1;
            this.uinType = -1;
            this.netWorkType = -1;
            this.logId = p.i();
        }
    }

    public ChatImageDownloader(BaseApplication baseApplication) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseApplication);
        } else {
            this.application = baseApplication;
        }
    }

    public static void generateReason(HashMap<String, String> hashMap, int i3, String str, FileMsg.StepBaseInfo stepBaseInfo, FileMsg.StepTransInfo stepTransInfo, boolean z16, FileMsg.StepBaseInfo stepBaseInfo2) {
        String str2;
        if (!ProcessorReport.adjustErrorCode(i3, hashMap)) {
            hashMap.put("param_FailCode", Integer.toString(i3));
            if (i3 != -9527 && i3 != 9311 && i3 != 9044 && i3 != 9350 && i3 != 9351) {
                hashMap.put(ReportConstant.KEY_ERR_DESC, str);
            } else {
                hashMap.put(ReportConstant.KEY_REASON, str);
            }
        } else {
            hashMap.put(ReportConstant.KEY_ERR_DESC, str);
        }
        if (z16 && stepBaseInfo2 == null && stepBaseInfo == null && stepTransInfo == null) {
            str2 = "1_-1_0_0_0;2_-1_0_0_0;3_-1_0_0_0";
        } else if (stepBaseInfo2 != null && stepBaseInfo != null && stepTransInfo != null) {
            str2 = stepBaseInfo2.getStepReportInfo(1) + ";" + stepBaseInfo.getStepReportInfo(2) + ";" + stepTransInfo.getStepReportInfo(3);
        } else {
            str2 = "";
        }
        if (QLog.isColorLevel()) {
            QLog.d("reportResult", 2, "parmStep: " + str2);
        }
        hashMap.put(ReportConstant.KEY_STEP_INFO, str2);
    }

    private DownloadData getDownloadData(DownloadParams downloadParams) throws AccountNotMatchException {
        boolean z16;
        String thumbPath;
        if (downloadParams != null) {
            DownloadData downloadData = new DownloadData();
            downloadData.url = downloadParams.url;
            f.b("PIC_TAG", "getDownloadData", "url:" + downloadData.url);
            downloadData.application = this.application;
            downloadData.startOffset = downloadParams.downloaded;
            Object obj = downloadParams.tag;
            if (obj != null && (obj instanceof t)) {
                t tVar = (t) obj;
                if (tVar instanceof MessageForPic) {
                    downloadData.pic = (MessageForPic) tVar;
                    downloadData.netWorkType = com.tencent.mobileqq.pic.a.a();
                    AppInterface appInterface = downloadData.app;
                    MessageForPic messageForPic = downloadData.pic;
                    downloadData.uinType = n.i(appInterface, messageForPic.istroop, messageForPic.frienduin);
                }
                downloadData.downInfo = tVar.getPicDownloadInfo();
                log(downloadData, "getDownloadData", "uuid:" + downloadData.downInfo.K + ",md5\uff1a" + downloadData.downInfo.J);
                downloadData.host = getHost(downloadData.downInfo.f258713h);
                String protocol2 = downloadParams.url.getProtocol();
                if (downloadData.downInfo.R == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                downloadData.fileSizeType = ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(protocol2, z16);
                if (tVar.isSendFromLocal()) {
                    downloadData.sendFromLoacal = true;
                    v picUploadInfo = tVar.getPicUploadInfo();
                    downloadData.upInfo = picUploadInfo;
                    downloadData.downInfo.H = true;
                    if (downloadData.fileSizeType == 65537) {
                        if (picUploadInfo.E == 10) {
                            thumbPath = ((PicFowardDbRecordData) picUploadInfo.F).fowardThumbPath;
                            if (thumbPath == null || "".equals(thumbPath)) {
                                thumbPath = getThumbPath(downloadData, thumbPath);
                            }
                        } else if (downloadData.pic.isQzonePic) {
                            thumbPath = picUploadInfo.L;
                        } else {
                            thumbPath = getThumbPath(downloadData, null);
                        }
                        downloadData.sendPath = thumbPath;
                    } else {
                        downloadData.sendPath = picUploadInfo.K;
                    }
                    log(downloadData, "getDownloadData", "path:" + downloadData.upInfo.K + ",sendPath\uff1a" + downloadData.sendPath);
                }
            } else if (obj != null && (obj instanceof String)) {
                downloadData.sendPath = (String) obj;
            } else {
                if (obj == null) {
                    log(downloadData, "getDownloadData", "config.tag error,config.tag==null");
                } else {
                    log(downloadData, "getDownloadData", "config.tag error,config.tag:" + downloadParams.tag);
                }
                throw new ChatPicDownloadFailedException(9302, 0L, "param error,config.tag error", false, false);
            }
            return downloadData;
        }
        throw new ChatPicDownloadFailedException(9302, 0L, "holy,config == null", false, false);
    }

    static String getHost(int i3) {
        if (i3 == 0) {
            return ProtocolDownloaderConstants.HOST_C2C;
        }
        if (i3 != 1) {
            if (i3 == 1000 || i3 == 1001 || i3 == 1004 || i3 == 1005 || i3 == 1008 || i3 == 1009 || i3 == 1020) {
                return ProtocolDownloaderConstants.HOST_C2C;
            }
            if (i3 != 3000) {
                if (i3 != 6000) {
                    return (i3 == 10002 || i3 == 10004 || i3 == 10008 || i3 == 10010 || i3 != 1023) ? ProtocolDownloaderConstants.HOST_C2C : ProtocolDownloaderConstants.HOST_C2C;
                }
                return "";
            }
            return ProtocolDownloaderConstants.HOST_DISSCUSSION;
        }
        return ProtocolDownloaderConstants.HOST_GROUP;
    }

    private String getThumbPath(DownloadData downloadData, String str) {
        if (FileUtils.fileExists(str)) {
            return str;
        }
        if (FileUtils.fileExists(downloadData.upInfo.K)) {
            CompressInfo compressInfo = new CompressInfo(downloadData.upInfo.K, 0);
            compressInfo.f258514d = downloadData.upInfo.f258711e;
            ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo);
            return compressInfo.H;
        }
        return str;
    }

    private boolean limitSizeByServer(DownloadParams downloadParams) {
        ThumbWidthHeightDP thumbWidthHeightDP;
        Object obj = downloadParams.tag;
        if (!(obj instanceof MessageForPic) || (thumbWidthHeightDP = ((MessageForPic) obj).thumbWidthHeightDP) == null || !thumbWidthHeightDP.mLimitSizeByServer) {
            return false;
        }
        return true;
    }

    public static void log(Object obj, String str, String str2) {
        if (obj instanceof DownloadData) {
            if (QLog.isColorLevel()) {
                DownloadData downloadData = (DownloadData) obj;
                if (downloadData.upInfo != null) {
                    int fileType = RichMediaUtil.getFileType(downloadData.fileSizeType);
                    v vVar = downloadData.upInfo;
                    RichMediaUtil.logdLogic(vVar.f258713h, false, fileType, String.valueOf(vVar.D), str, str2);
                    return;
                } else if (downloadData.downInfo != null) {
                    int fileType2 = RichMediaUtil.getFileType(downloadData.fileSizeType);
                    k kVar = downloadData.downInfo;
                    RichMediaUtil.logdLogic(kVar.f258713h, false, fileType2, String.valueOf(kVar.D), str, str2);
                    return;
                } else {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "step:" + str + ",content: " + str2);
                        return;
                    }
                    return;
                }
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "step:" + str + ",content: " + str2);
        }
    }

    public static void reportBigPicDownCost(String str, int i3, int i16, long j3) {
        f.b(TAG, "reportBigPicDownCost", "uintype:" + i3 + ",networktype:" + i16 + ",timeCost:" + j3);
        if (i3 != -1 && i16 != -1 && j3 >= 0) {
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_uintype", String.valueOf(i3));
            hashMap.put("param_networktype", String.valueOf(i16));
            hashMap.put("param_timecost", String.valueOf(j3));
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(str, "actBigPicDownCost", false, 0L, 0L, hashMap, "");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0040 A[Catch: Exception -> 0x00ab, TRY_ENTER, TryCatch #0 {Exception -> 0x00ab, blocks: (B:3:0x0001, B:5:0x0016, B:7:0x0023, B:17:0x0040, B:19:0x0057, B:21:0x005d, B:22:0x0072, B:23:0x0075, B:25:0x008c, B:27:0x0092, B:28:0x00a7), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008c A[Catch: Exception -> 0x00ab, TryCatch #0 {Exception -> 0x00ab, blocks: (B:3:0x0001, B:5:0x0016, B:7:0x0023, B:17:0x0040, B:19:0x0057, B:21:0x005d, B:22:0x0072, B:23:0x0075, B:25:0x008c, B:27:0x0092, B:28:0x00a7), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void reportClientExist(MessageRecord messageRecord) {
        boolean z16;
        URL url;
        try {
            String host = getHost(messageRecord.istroop);
            TranDbRecord.PicDbRecord picDbRecord = new TranDbRecord.PicDbRecord();
            picDbRecord.initFromMsg(messageRecord.f203106msg);
            if (picDbRecord.type != 1) {
                return;
            }
            String str = picDbRecord.uuid;
            String str2 = picDbRecord.md5;
            if (!com.tencent.mobileqq.utils.c.h(messageRecord.msgtype)) {
                int i3 = messageRecord.msgtype;
                if (i3 != -3001 && i3 != -30002 && i3 != -30003) {
                    z16 = false;
                    if (!z16) {
                        URL url2 = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL((MessageForPic) messageRecord, 65537, (String) null);
                        if (AbsDownloader.getFile(url2.toString()) != null) {
                            if (QLog.isColorLevel()) {
                                QLog.d(TAG, 2, "reportClientExist thumbURL:" + url2);
                            }
                            reportClientExist(messageRecord, host, str, str2, true);
                        }
                    }
                    url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL((MessageForPic) messageRecord, 65537, (String) null);
                    if (AbsDownloader.getFile(url.toString()) == null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "reportClientExist bigURL:" + url);
                        }
                        reportClientExist(messageRecord, host, str, str2, false);
                        return;
                    }
                    return;
                }
            }
            z16 = true;
            if (!z16) {
            }
            url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL((MessageForPic) messageRecord, 65537, (String) null);
            if (AbsDownloader.getFile(url.toString()) == null) {
            }
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.d("reportClientExist", 2, "error", e16);
            }
        }
    }

    public static void reportResult(ReportData reportData, boolean z16, int i3, int i16, String str, FileMsg.StepBaseInfo stepBaseInfo, FileMsg.StepBaseInfo stepBaseInfo2, FileMsg.StepTransInfo stepTransInfo) {
        long j3;
        System.currentTimeMillis();
        long j16 = 0;
        if (stepTransInfo != null) {
            j3 = stepTransInfo.flowDown;
        } else {
            j3 = 0;
        }
        if (stepTransInfo != null) {
            j16 = stepTransInfo.contentSize;
        }
        long j17 = j16;
        if (RichMediaStrategy.noReportByErrorCode(i16)) {
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        generateReason(hashMap, i16, str, stepBaseInfo2, stepTransInfo, z16, stepBaseInfo);
        hashMap.put(ReportConstant.KEY_UUID, reportData.uuid);
        hashMap.put("flow", String.valueOf(j3));
        hashMap.put("msgTime", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(reportData.msgTime * 1000)));
        hashMap.put("client_exist", String.valueOf(reportData.clientExist));
        if (stepBaseInfo2 != null) {
            hashMap.put("param_RequestUrl", stepBaseInfo2.toReportJson());
        }
        if (stepTransInfo != null) {
            hashMap.put("param_HttpTran", stepTransInfo.toReportJson());
        }
        if (stepTransInfo != null) {
            hashMap.put("param_retry", String.valueOf(stepTransInfo.retryCount));
            if (stepTransInfo.result) {
                hashMap.put("serverip", stepTransInfo.firstIp);
                hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, stepTransInfo.firstIp);
            } else {
                hashMap.put("serverip", stepTransInfo.lastUseIp);
                hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, stepTransInfo.lastUseIp);
                if (i16 == -9527) {
                    hashMap.put("param_rspHeader", stepTransInfo.respHeader);
                }
            }
        }
        if (z16) {
            if (!reportData.multiMediaEvtTag.equals(StatisticCollector.C2C_PICDOWN_STATISTIC_TAG) && !reportData.multiMediaEvtTag.equals(StatisticCollector.C2C_SMAILLPICDOWN_STATISTIC_TAG)) {
                hashMap.put(ReportConstant.KEY_GROUP_ID, reportData.peerUin);
            } else {
                hashMap.put(ReportConstant.KEY_TO_UIN, reportData.peerUin);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, reportData.multiMediaEvtTag, true, i3, j3, hashMap, "");
            return;
        }
        if (i16 == 9301) {
            hashMap.put(j.f247808i, str);
        }
        String str2 = reportData.msgDate;
        if (str2 != null && !str2.equals("")) {
            hashMap.put("param_MsgTime", reportData.msgDate);
        }
        if (!reportData.multiMediaEvtTag.equals(StatisticCollector.C2C_PICDOWN_STATISTIC_TAG) && !reportData.multiMediaEvtTag.equals(StatisticCollector.C2C_SMAILLPICDOWN_STATISTIC_TAG)) {
            hashMap.put(ReportConstant.KEY_GROUP_ID, reportData.peerUin);
            hashMap.put("param_url", reportData.srvUrl);
            hashMap.put("param_fsized", j3 + "");
            hashMap.put("param_fsizeo", j17 + "");
        } else {
            hashMap.put(ReportConstant.KEY_TO_UIN, reportData.peerUin);
            hashMap.put("param_url", reportData.srvUrl);
            hashMap.put("param_fsized", j3 + "");
            hashMap.put("param_fsizeo", j17 + "");
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, reportData.multiMediaEvtTag, false, 0L, 0L, hashMap, "");
    }

    public Object decodeAioPicThumb(File file, DownloadParams downloadParams, BitmapFactory.Options options) throws Exception {
        File file2;
        OutOfMemoryError e16;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return iPatchRedirector.redirect((short) 10, this, file, downloadParams, options);
        }
        String str = downloadParams.urlStr;
        try {
            String absolutePath = file.getAbsolutePath();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            boolean z17 = false;
            options.inJustDecodeBounds = false;
            String name = file.getName();
            if (!name.endsWith("_hd")) {
                File file3 = new File(absolutePath + "_hd");
                if (file3.exists()) {
                    try {
                        if (QLog.isColorLevel()) {
                            log(downloadParams, "DecodeFile", "DecodeFile hd thumb instead,cacheFile=" + file3.getAbsolutePath() + ", url=" + str);
                        }
                        file = file3;
                        z16 = true;
                    } catch (OutOfMemoryError e17) {
                        e16 = e17;
                        file2 = file3;
                        logDecodeFile(downloadParams, file2, str, options, 1, false, "step:create roundBitmap, " + e16.getMessage());
                        throw e16;
                    }
                }
                z16 = false;
            } else {
                if (name.length() > 3) {
                    if (QLog.isColorLevel()) {
                        log(downloadParams, "DecodeFile", "DecodeFile hd ,hdPath=" + absolutePath);
                    }
                    absolutePath = absolutePath.substring(0, absolutePath.length() - 3);
                    z16 = true;
                }
                z16 = false;
            }
            Bitmap decodeFile = SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (decodeFile == null && z16) {
                boolean fileExists = FileUtils.fileExists(absolutePath);
                if (fileExists && (decodeFile = SafeBitmapFactory.decodeFile(absolutePath, options)) == null) {
                    String encodeFileHexStr = MD5Utils.encodeFileHexStr(absolutePath);
                    FileUtils.deleteFile(absolutePath);
                    if (QLog.isColorLevel()) {
                        log(downloadParams, "DecodeFile", "delete err thumb md5=" + encodeFileHexStr);
                    }
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("decode hd failed, try decode thumb ");
                    sb5.append(absolutePath);
                    sb5.append(" exist=");
                    sb5.append(fileExists);
                    sb5.append(" result=");
                    if (decodeFile != null) {
                        z17 = true;
                    }
                    sb5.append(z17);
                    log(downloadParams, "DecodeFile", sb5.toString());
                }
            }
            if (decodeFile != null) {
                if (z16) {
                    FileUtils.deleteFile(absolutePath);
                }
                DownloadParams.DecodeHandler decodeHandler = downloadParams.mDecodeHandler;
                if (decodeHandler != null) {
                    decodeFile = decodeHandler.run(downloadParams, decodeFile);
                }
                Object obj = downloadParams.tag;
                if (obj != null) {
                    if ((obj instanceof MessageForPic) && (((MessageForPic) obj).subMsgType == 2 || str.endsWith("?noRound"))) {
                        return decodeFile;
                    }
                    Object obj2 = downloadParams.tag;
                    if (obj2 instanceof CustomBitmap) {
                        return ((CustomBitmap) obj2).createBitmap(decodeFile);
                    }
                }
                if (decodeFile != null) {
                    RoundRectBitmap resizeAndClipBitmap = resizeAndClipBitmap(decodeFile, downloadParams);
                    if (!decodeFile.equals(resizeAndClipBitmap.mBitmap)) {
                        decodeFile.recycle();
                    }
                    RoundRectBitmap roundRectBitmap = new RoundRectBitmap(new ExifBitmapCreator(file.getAbsolutePath()).creatBitmap(resizeAndClipBitmap.mBitmap), resizeAndClipBitmap.mCornerRadius, resizeAndClipBitmap.mBoardColor, resizeAndClipBitmap.mBorderWidth);
                    BaseApplication baseApplication = this.application;
                    if (baseApplication != null) {
                        roundRectBitmap.mDisplayWidth = baseApplication.getResources().getDisplayMetrics().widthPixels;
                        roundRectBitmap.mDisplayHeight = this.application.getResources().getDisplayMetrics().heightPixels;
                    }
                    logDecodeFile(downloadParams, file, str, options, 1, true, "step:create roundBitmap");
                    return roundRectBitmap;
                }
                throw new NullPointerException();
            }
            if (!((t) downloadParams.tag).isSendFromLocal()) {
                String encodeFileHexStr2 = MD5Utils.encodeFileHexStr(file.getAbsolutePath());
                k picDownloadInfo = ((t) downloadParams.tag).getPicDownloadInfo();
                QLog.i(LogTag.RICH_MEDIA + TransFileUtil.getUinDesc(picDownloadInfo.f258713h) + ".dw", 1, "id:" + String.valueOf(picDownloadInfo.D) + "step: UIDecoder FAIL srcPicMD5:" + encodeFileHexStr2);
            }
            file.delete();
            logDecodeFile(downloadParams, file, str, options, 1, false, "step:decode error, not valid pic");
            throw new IOException("step:decode error, not valid pic");
        } catch (OutOfMemoryError e18) {
            file2 = file;
            e16 = e18;
        }
    }

    protected boolean decodeByAIOPicThumb(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, file, downloadParams, uRLDrawableHandler)).booleanValue();
        }
        return "chatthumb".equals(downloadParams.url.getProtocol());
    }

    protected boolean decodeByGif(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, this, file, downloadParams, uRLDrawableHandler)).booleanValue();
        }
        Object obj = downloadParams.tag;
        if ((obj instanceof MessageForPic) && ac.c((MessageForPic) obj)) {
            return false;
        }
        return GifDrawable.isGifFile(file);
    }

    @Override // com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public Object decodeFile(File file, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return iPatchRedirector.redirect((short) 6, this, file, downloadParams, uRLDrawableHandler);
        }
        if (QLog.isColorLevel()) {
            log(downloadParams, "DecodeFile", "decodeFile config.tag " + downloadParams.tag);
        }
        try {
            String str = downloadParams.urlStr;
            URL url = downloadParams.url;
            if (QLog.isColorLevel()) {
                log(downloadParams, "DecodeFile", "DecodeFile START,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
            }
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            options.inDensity = 160;
            options.inTargetDensity = 160;
            options.inScreenDensity = 160;
            options.inJustDecodeBounds = true;
            if (decodeByGif(file, downloadParams, uRLDrawableHandler)) {
                payPicFlow(downloadParams);
                if (QLog.isColorLevel()) {
                    log(downloadParams, "DecodeFile", "DecodeFile END,GIF image,cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str);
                    return null;
                }
                return null;
            }
            if (decodeByAIOPicThumb(file, downloadParams, uRLDrawableHandler)) {
                return decodeAioPicThumb(file, downloadParams, options);
            }
            options.inJustDecodeBounds = true;
            SafeBitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (options.outHeight != 0 && options.outWidth != 0) {
                return decodeImage(url, file, downloadParams, options);
            }
            file.delete();
            logDecodeFile(downloadParams, file, str, options, 1, false, "step:decode bounds error, not valid pic");
            throw new IOException("step:decode bounds error, not valid pic");
        } catch (Exception e16) {
            String exceptionMessage = ProcessorReport.getExceptionMessage(e16);
            if (exceptionMessage == null || exceptionMessage.length() == 0) {
                exceptionMessage = e16.toString();
            }
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, exceptionMessage);
                log(downloadParams, "DecodeFile", "DecodeFile FAIL,exceptionmsg:" + exceptionMessage);
            }
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("params_failDesc", exceptionMessage);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance((String) null, "actPicUIDecoder", false, -1L, 0L, hashMap, "", true);
            throw e16;
        }
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public File downloadImage(OutputStream outputStream, DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (File) iPatchRedirector.redirect((short) 5, this, outputStream, downloadParams, uRLDrawableHandler);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        String str3 = downloadParams.urlStr;
        boolean z17 = true;
        if (str3 != null && str3.startsWith(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE)) {
            z16 = true;
        } else {
            z16 = false;
        }
        DownloadData downloadData = getDownloadData(downloadParams);
        downloadData.out = outputStream;
        downloadData.handler = uRLDrawableHandler;
        if (downloadData.upInfo != null && downloadData.sendPath != null) {
            File file = new File(downloadData.sendPath);
            if (file.exists()) {
                log(downloadData, "result", "success file(send) exist, copy file from:" + downloadData.sendPath);
                BaseImageDownloader.copyFromFile(downloadData.out, file, downloadData.handler);
                return null;
            }
        }
        uRLDrawableHandler.publishProgress(0);
        if (downloadData.downInfo != null) {
            if (Thread.currentThread().getId() != Looper.getMainLooper().getThread().getId()) {
                if (Utils.B() && Utils.z() < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_FOR_TV) {
                    throw new IOException("SD card free space is " + Utils.z());
                }
                TransferResult stepDownload = stepDownload(downloadData);
                if (stepDownload != null) {
                    if (stepDownload.mResult != 0) {
                        z17 = false;
                    }
                    String str4 = stepDownload.mErrDesc;
                    if (z17) {
                        str = "successed";
                    } else {
                        str = "failed " + str4;
                    }
                    log(downloadData, "result", str);
                    if (!z17) {
                        PicDownloadExplicitError picError = PicDownloadExplicitError.getPicError(stepDownload);
                        if (picError == null) {
                            long j3 = stepDownload.mErrCode;
                            if (j3 == 9037) {
                                uRLDrawableHandler.doCancel();
                            } else {
                                if (j3 == -9527 && "H_404_-124".equals(stepDownload.mErrDesc)) {
                                    log(downloadData, "result", "successed|failed,H_404_-124,decodeFile will check");
                                    return null;
                                }
                                throw new ChatPicDownloadFailedException((int) stepDownload.mErrCode, 0L, stepDownload.mErrDesc, false, false);
                            }
                        } else {
                            throw picError;
                        }
                    } else if (z16) {
                        AppInterface appInterface = downloadData.app;
                        if (appInterface != null) {
                            str2 = appInterface.getCurrentAccountUin();
                        } else {
                            str2 = null;
                        }
                        reportBigPicDownCost(str2, downloadData.uinType, downloadData.netWorkType, SystemClock.uptimeMillis() - uptimeMillis);
                    }
                    return null;
                }
                throw new NullPointerException("exception: result is null");
            }
            log(downloadData, "result", "failed could not call object.wait in Main thread ,sendpath:" + downloadData.sendPath + ",uniseq:" + downloadData.downInfo.D);
            throw new ChatPicDownloadFailedException(AppConstants.RichMediaErrorCode.ERROR_MAIN_THREAD_WAIT, 0L, "param error,could not call object.wait in Main thread", false, false);
        }
        log(downloadData, "result", "param error,params.downInfo == null,sendpath:" + downloadData.sendPath);
        throw new ChatPicDownloadFailedException(9302, 0L, "param error,params.downInfo == null", false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.transfile.BaseImageDownloader
    public int getTryTime(URL url) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) url)).intValue();
        }
        if (!url.getProtocol().equals(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE) && !url.getProtocol().equals(ProtocolDownloaderConstants.PROTOCOL_CHAT_RAW)) {
            return super.getTryTime(url);
        }
        return 3;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader, com.tencent.image.ProtocolDownloader.Adapter, com.tencent.image.ProtocolDownloader
    public File loadImageFile(DownloadParams downloadParams, URLDrawableHandler uRLDrawableHandler) throws Exception {
        File guildChatImageFile;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (File) iPatchRedirector.redirect((short) 4, (Object) this, (Object) downloadParams, (Object) uRLDrawableHandler);
        }
        if (((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).limitByGuild(downloadParams) && (guildChatImageFile = ((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getGuildChatImageFile(downloadParams)) != null) {
            return guildChatImageFile;
        }
        return super.loadImageFile(downloadParams, uRLDrawableHandler);
    }

    void logDecodeFile(DownloadParams downloadParams, File file, String str, BitmapFactory.Options options, int i3, boolean z16, String str2) {
        if (z16) {
            if (QLog.isColorLevel()) {
                log(downloadParams, "DecodeFile", "DecodeFile SUCCESS,retryCount=" + i3 + ",options.inSampleSize=" + options.inSampleSize + ",cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str + ",extraMsg=" + str2);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            log(downloadParams, "DecodeFile", "DecodeFile FAIL,retryCount=" + i3 + ",options.inSampleSize=" + options.inSampleSize + ",cacheFile=" + file.getAbsolutePath() + JefsClass.INDEX_URL + str + ",extraMsg=" + str2);
        }
    }

    protected void payPicFlow(DownloadParams downloadParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) downloadParams);
            return;
        }
        Object obj = downloadParams.tag;
        if (obj != null && (obj instanceof MessageForPic)) {
            MessageForPic messageForPic = (MessageForPic) obj;
            String str = messageForPic.selfuin;
            PicPreDownloader picPreDownloader = ((PicPreDownloadImpl) ((AppInterface) MobileQQ.sMobileQQ.peekAppRuntime()).getRuntimeService(IPicPreDownload.class, "")).picPreDownloader;
            picPreDownloader.s().a(messageForPic, messageForPic.size);
            picPreDownloader.n();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0127 A[Catch: OutOfMemoryError -> 0x01e1, TryCatch #0 {OutOfMemoryError -> 0x01e1, blocks: (B:9:0x001b, B:11:0x005c, B:12:0x00a2, B:14:0x00cf, B:15:0x0103, B:17:0x0111, B:19:0x0121, B:21:0x0127, B:23:0x013f, B:25:0x014b, B:33:0x0170, B:34:0x01b9, B:37:0x017b, B:38:0x0180, B:40:0x0183, B:41:0x0185, B:42:0x018c, B:43:0x0187, B:44:0x017e, B:47:0x019e, B:52:0x01ab, B:56:0x0113, B:58:0x0119), top: B:8:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x013f A[Catch: OutOfMemoryError -> 0x01e1, TryCatch #0 {OutOfMemoryError -> 0x01e1, blocks: (B:9:0x001b, B:11:0x005c, B:12:0x00a2, B:14:0x00cf, B:15:0x0103, B:17:0x0111, B:19:0x0121, B:21:0x0127, B:23:0x013f, B:25:0x014b, B:33:0x0170, B:34:0x01b9, B:37:0x017b, B:38:0x0180, B:40:0x0183, B:41:0x0185, B:42:0x018c, B:43:0x0187, B:44:0x017e, B:47:0x019e, B:52:0x01ab, B:56:0x0113, B:58:0x0119), top: B:8:0x001b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected RoundRectBitmap resizeAndClipBitmap(Bitmap bitmap, DownloadParams downloadParams) {
        int i3;
        int i16;
        int i17;
        int i18;
        int i19;
        int i26;
        int i27;
        int i28;
        int i29;
        int i36;
        float f16;
        float f17;
        float f18;
        float f19;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (RoundRectBitmap) iPatchRedirector.redirect((short) 9, (Object) this, (Object) bitmap, (Object) downloadParams);
        }
        try {
            float f26 = this.application.getResources().getDisplayMetrics().density;
            int i37 = this.application.getResources().getDisplayMetrics().densityDpi;
            float aioImageRoundCorner = ((IPicAIO) QRoute.api(IPicAIO.class)).getAioImageRoundCorner(downloadParams) * f26;
            boolean c16 = com.tencent.mobileqq.v.c(downloadParams.mImgType);
            int imgThumbMinPx = CommonImgThumbHelper.getImgThumbMinPx(c16);
            int imgThumbMinPx2 = CommonImgThumbHelper.getImgThumbMinPx(c16);
            int imgThumbMaxPx = CommonImgThumbHelper.getImgThumbMaxPx(c16);
            int imgThumbMaxPx2 = CommonImgThumbHelper.getImgThumbMaxPx(c16);
            Object obj = downloadParams.tag;
            if (obj instanceof MessageForPic) {
                MessageForPic messageForPic = (MessageForPic) obj;
                imgThumbMinPx = Utils.n(AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic, c16).mMinWidth, this.application.getResources());
                imgThumbMinPx2 = Utils.n(AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic, c16).mMinHeight, this.application.getResources());
                imgThumbMaxPx = Utils.n(AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic, c16).mMaxWidth, this.application.getResources());
                imgThumbMaxPx2 = Utils.n(AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic, c16).mMaxHeight, this.application.getResources());
            }
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            Paint paint = new Paint(1);
            paint.setColor(-16777216);
            int imgThumbMinDp = CommonImgThumbHelper.getImgThumbMinDp(c16);
            int imgThumbMinDp2 = CommonImgThumbHelper.getImgThumbMinDp(c16);
            int imgThumbMaxDp = CommonImgThumbHelper.getImgThumbMaxDp(c16);
            int imgThumbMaxDp2 = CommonImgThumbHelper.getImgThumbMaxDp(c16);
            Object obj2 = downloadParams.tag;
            if (obj2 instanceof MessageForPic) {
                MessageForPic messageForPic2 = (MessageForPic) obj2;
                int i38 = AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic2, c16).mMinWidth;
                int i39 = AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic2, c16).mMinHeight;
                i16 = AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic2, c16).mMaxWidth;
                int i46 = AIOImgThumbHelper.getThumbWidthHeightDP(messageForPic2, c16).mMaxHeight;
                i17 = i38;
                i18 = i37;
                i26 = i46;
                i3 = i39;
                i19 = imgThumbMinPx;
            } else {
                i3 = imgThumbMinDp2;
                i16 = imgThumbMaxDp;
                i17 = imgThumbMinDp;
                i18 = i37;
                i19 = imgThumbMinPx;
                i26 = imgThumbMaxDp2;
            }
            float f27 = width;
            float f28 = height;
            float f29 = f28 * 3.0f;
            if (f27 > f29) {
                i27 = (int) f29;
            } else {
                float f36 = f27 * 3.0f;
                if (f28 > f36) {
                    i28 = (int) f36;
                    i27 = width;
                    if (!limitSizeByServer(downloadParams)) {
                        return new RoundRectBitmap(((ICompressOperator) QRoute.api(ICompressOperator.class)).clip(bitmap, ((MessageForPic) downloadParams.tag).thumbWidthHeightDP), aioImageRoundCorner);
                    }
                    if (((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).limitByGuild(downloadParams)) {
                        MessageForPic messageForPic3 = (MessageForPic) downloadParams.tag;
                        return new RoundRectBitmap(((IGuildPicAIO) QRoute.api(IGuildPicAIO.class)).getThumbBitmap(bitmap, (int) messageForPic3.width, (int) messageForPic3.height), aioImageRoundCorner);
                    }
                    if (i27 >= i17 && i28 >= i3) {
                        if (i27 < i16 && i28 < i26) {
                            i29 = (int) ((i27 * f26) + 0.5f);
                            i36 = (int) ((i28 * f26) + 0.5f);
                        } else {
                            if (i27 > i28) {
                                f16 = imgThumbMaxPx;
                                f17 = i27;
                            } else {
                                f16 = imgThumbMaxPx2;
                                f17 = i28;
                            }
                            float f37 = f16 / f17;
                            if (i27 > i28) {
                                f18 = imgThumbMinPx2;
                                f19 = i28;
                            } else {
                                f18 = i19;
                                f19 = i27;
                            }
                            float max = Math.max(f37, f18 / f19);
                            i36 = (int) ((i28 * max) + 0.5f);
                            i29 = (int) ((i27 * max) + 0.5f);
                        }
                        Bitmap createBitmap = Bitmap.createBitmap(i29, i36, bitmap.getConfig());
                        createBitmap.setDensity(i18);
                        new Canvas(createBitmap).drawBitmap(bitmap, new Rect(0, 0, i27, i28), new Rect(0, 0, i29, i36), paint);
                        return new RoundRectBitmap(createBitmap, aioImageRoundCorner);
                    }
                    int i47 = i19;
                    if (i27 < i28) {
                        int i48 = (int) ((i28 * (i47 / i27)) + 0.5f);
                        if (i48 > imgThumbMaxPx2) {
                            imgThumbMinPx2 = imgThumbMaxPx2;
                        } else {
                            imgThumbMinPx2 = i48;
                        }
                    } else {
                        int i49 = (int) ((i27 * (imgThumbMinPx2 / i28)) + 0.5f);
                        i47 = i49 > imgThumbMaxPx ? imgThumbMaxPx : i49;
                    }
                    i29 = i47;
                    i36 = imgThumbMinPx2;
                    Bitmap createBitmap2 = Bitmap.createBitmap(i29, i36, bitmap.getConfig());
                    createBitmap2.setDensity(i18);
                    new Canvas(createBitmap2).drawBitmap(bitmap, new Rect(0, 0, i27, i28), new Rect(0, 0, i29, i36), paint);
                    return new RoundRectBitmap(createBitmap2, aioImageRoundCorner);
                }
                i27 = width;
            }
            i28 = height;
            if (!limitSizeByServer(downloadParams)) {
            }
        } catch (OutOfMemoryError unused) {
            return new RoundRectBitmap(bitmap, 8.0f);
        }
    }

    TransferResult stepDownload(DownloadData downloadData) throws Exception {
        if (downloadData.app == null) {
            downloadData.app = (AppInterface) MobileQQ.sMobileQQ.peekAppRuntime();
        }
        if (downloadData.app != null) {
            k kVar = downloadData.downInfo;
            kVar.I = downloadData.url.getProtocol();
            MessageForPic messageForPic = downloadData.pic;
            if (messageForPic != null) {
                kVar.f258729f0 = messageForPic.bEnableEnc;
                kVar.S = messageForPic.time;
            }
            p f16 = i.f(5, 1280, 1);
            f16.H = downloadData.pic;
            f16.f258786h = "PIC_TAG";
            f16.f258788m = kVar;
            f16.N = downloadData.handler;
            com.tencent.mobileqq.pic.operator.a k3 = i.k(f16);
            if (k3 instanceof DownloadPicOperator) {
                f.c("PIC_TAG", downloadData.logId, "stepDownload", "url:" + downloadData.url + ",info:" + downloadData.downInfo);
                k3.i();
                return ((DownloadPicOperator) k3).y();
            }
            f.c("PIC_TAG", downloadData.logId, "stepDownload", "operator wrong");
            return null;
        }
        log(downloadData, "stepDownload", "params.app == null ,selfuin:" + downloadData.downInfo.f258714i);
        throw new ChatPicDownloadFailedException(9302, 0L, "stepDownload,params.app == null ,selfuin:" + downloadData.downInfo.f258714i, false, false);
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean supportBreakpointContinuingly() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this)).booleanValue();
        }
        return true;
    }

    @Override // com.tencent.mobileqq.transfile.AbsDownloader
    public boolean useDiskCache() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        return true;
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class ReportData {
        static IPatchRedirector $redirector_;
        boolean clientExist;
        int fileId;
        long fileSize;
        String logTag;
        String md5;
        String msgDate;
        long msgTime;
        String multiMediaEvtTag;
        String peerUin;
        String srvAddr;
        String srvUrl;
        String uuid;

        public ReportData(String str, String str2, String str3, String str4, String str5, String str6, long j3, String str7) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, str2, str3, str4, str5, str6, Long.valueOf(j3), str7);
                return;
            }
            this.peerUin = str;
            this.logTag = str2;
            this.multiMediaEvtTag = str3;
            this.srvAddr = str4;
            this.srvUrl = str5;
            this.uuid = str6;
            this.fileSize = j3;
            this.md5 = str7;
        }

        public ReportData(String str, String str2, String str3, String str4, String str5, String str6) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, str, str2, str3, str4, str5, str6);
                return;
            }
            this.peerUin = str;
            this.logTag = str2;
            this.multiMediaEvtTag = str3;
            this.srvAddr = str4;
            this.srvUrl = str5;
            this.uuid = str6;
        }
    }

    private static void reportClientExist(MessageRecord messageRecord, String str, String str2, String str3, boolean z16) {
        String str4;
        String str5;
        String str6;
        String str7;
        boolean equals = str.equals(ProtocolDownloaderConstants.HOST_C2C);
        boolean equals2 = str.equals(ProtocolDownloaderConstants.HOST_GROUP);
        boolean equals3 = str.equals(ProtocolDownloaderConstants.HOST_DISSCUSSION);
        if (equals) {
            str6 = z16 ? "dim.buddy_thumbpic_down" : "dim.buddy_pic_down";
            str7 = z16 ? StatisticCollector.C2C_SMAILLPICDOWN_STATISTIC_TAG : StatisticCollector.C2C_PICDOWN_STATISTIC_TAG;
        } else if (equals2) {
            str6 = z16 ? "dim.group_thumbpic_down" : "dim.group_pic_down";
            str7 = z16 ? StatisticCollector.TROOP_SMAILLPIC_DOWNLOAD_STATISTIC_TAG : StatisticCollector.TROOP_PIC_DOWNLOAD_STATISTIC_TAG;
        } else {
            if (!equals3) {
                str4 = null;
                str5 = null;
                ReportData reportData = new ReportData(messageRecord.frienduin, str4, str5, null, null, str2, 0L, str3);
                reportData.clientExist = true;
                reportData.msgTime = messageRecord.time;
                reportResult(reportData, true, (int) 0, 0, "", null, null, null);
            }
            str6 = z16 ? "dim.discuss_thumbpic_down" : "dim.discuss_pic_down";
            str7 = z16 ? StatisticCollector.DISCUSSION_SMALLPIC_DOWNLOAD_STATISTIC_TAG : StatisticCollector.DISCUSSION_PIC_DOWNLOAD_STATISTIC_TAG;
        }
        str4 = str6;
        str5 = str7;
        ReportData reportData2 = new ReportData(messageRecord.frienduin, str4, str5, null, null, str2, 0L, str3);
        reportData2.clientExist = true;
        reportData2.msgTime = messageRecord.time;
        reportResult(reportData2, true, (int) 0, 0, "", null, null, null);
    }
}
