package com.tencent.mobileqq.transfile;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.cache.api.util.ImageCacheHelper;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.GifDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableHandler;
import com.tencent.libavif.AvifDecoder;
import com.tencent.libavif.AvifImage;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.ac;
import com.tencent.mobileqq.avifcodec.api.IAvifConfigServiceApi;
import com.tencent.mobileqq.config.business.AvifDownloadConfProcessor;
import com.tencent.mobileqq.config.business.RichmediaHttpsConfProcessor;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.ThumbWidthHeightDP;
import com.tencent.mobileqq.highway.netprobe.MtuProbe;
import com.tencent.mobileqq.highway.netprobe.PingProbe;
import com.tencent.mobileqq.highway.netprobe.ProbeChain;
import com.tencent.mobileqq.highway.netprobe.ProbeRequest;
import com.tencent.mobileqq.highway.netprobe.ProbeTask;
import com.tencent.mobileqq.highway.netprobe.TracerouteProbe;
import com.tencent.mobileqq.highway.netprobe.WeakNetLearner;
import com.tencent.mobileqq.highway.protocol.subcmd0x501;
import com.tencent.mobileqq.message.msgstorage.api.IMsgStorageApi;
import com.tencent.mobileqq.mixedmsg.api.IMsgMixed;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.pic.api.IDep;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile;
import com.tencent.mobileqq.pic.c;
import com.tencent.mobileqq.pic.compress.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.QQBeaconReport;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.statistics.r;
import com.tencent.mobileqq.structmsg.api.IMsgStructing;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.transfile.dns.InnerDns;
import com.tencent.mobileqq.transfile.quic.internal.QuicEngineImp;
import com.tencent.mobileqq.transfile.quic.open.IQuicEngine;
import com.tencent.mobileqq.transfile.quic.open.QuicReq;
import com.tencent.mobileqq.transfile.quic.report.DownloadListener;
import com.tencent.mobileqq.transfile.quic.report.QuicNetReport;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.PicCryptor;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.af;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vaswebviewplugin.IndividuationPlugin;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.java_websocket.WebSocketImpl;

/* loaded from: classes19.dex */
public class BasePicDownloadProcessor extends BaseDownloadProcessor implements NetFailedListener, IPicTransFile.a {
    static IPatchRedirector $redirector_ = null;
    protected static final int AVIF_DECODE_EXCEPTION = 4;
    protected static final int AVIF_DECODE_FAIL = 1;
    protected static final int AVIF_DECODE_FAIL_SO_FAIL = 2;
    protected static final int AVIF_DECODE_FAIL_UNKNOWN = 6;
    protected static final int AVIF_DECODE_FILETYPE_ERROR = 5;
    protected static final int AVIF_DECODE_OOM = 3;
    protected static final int AVIF_DECODE_RENAME_FAIL = 7;
    protected static final int AVIF_DECODE_SUC = 0;
    public static final String AVIF_FILE_SUFFIX = ".avif";
    public static final int AVIF_REQ_APPRUNTIME_NULL = 12;
    public static final int AVIF_REQ_CODEC_UNSURPPORT = 5;
    protected static final int AVIF_REQ_DENSITY_UNSURPPORT = 10;
    protected static final int AVIF_REQ_FLASH_PHOTO = 9;
    protected static final int AVIF_REQ_HAS_TMP_AVIF = 7;
    protected static final int AVIF_REQ_INVALID_MSG_RECORD = 2;
    protected static final int AVIF_REQ_IS_RAW_PHOTO = 3;
    protected static final int AVIF_REQ_OUTPUTSTREAM_UNSURPPORT = 11;
    protected static final int AVIF_REQ_OVERSIZE = 6;
    protected static final int AVIF_REQ_RETRY = 1;
    public static final int AVIF_REQ_SO_DOWNLOAD_FAILED = 8;
    protected static final int AVIF_REQ_SUC = 0;
    public static final int AVIF_REQ_SWITCH_CLOSE = 4;
    public static final String C2C_PIC_DOWNLOAD_ERROR_CODE = "C2CPicDownloadErrorCode";
    static final int DOWNLOAD_ST_COMPLETE = 1;
    static final int DOWNLOAD_ST_HEAD = 2;
    static final int DOWNLOAD_ST_LEFT = 4;
    static final int DOWNLOAD_ST_PART = 3;
    private static final int ENCRYPT_APPID = 1600000226;
    public static final String GROUP_PIC_DOWNLOAD_ERROR_CODE = "GroupPicDownloadErrorCode";
    public static final String KEY_PIC_DOWNLOAD_ERROR_CODE = "param_detail_code";
    protected static final int QUIC_FAIL_IP_LIST_EMPTY = 1;
    protected static final int QUIC_FAIL_REQUEST_HTTPS = 3;
    protected static final int QUIC_FAIL_REQUEST_QUIC = 2;
    protected static final int QUIC_FAIL_SO_LOAD = 4;
    public static final String REPORT_TAG_DIRECT_DOWNLOAD_FAIL = "report_direct_download_fail";
    public static final String REQ_PARAM_AVIF = "tp=avif";
    private static final Pattern URL_ENCRYPR_PATH_PATTERN;
    protected long decryptConsumeTime;
    private ArrayList<String> failIpReported;
    protected volatile long mAvifDelayCost;
    protected HashMap<String, String> mAvifReportInfo;
    protected String mDecryptErrorMsg;
    protected String mDirectDownFailReason;
    protected boolean mEncryptPic;
    protected boolean mEncryptUrl;
    protected boolean mHttpReqWithQuicIp;
    protected boolean mIpFromInnerDns;
    protected TransferRequest.PicDownExtraInfo mPicDownExtra;
    protected boolean mPicEncryptRollback;
    protected QuicDownloadListener mQuicDownloadListener;
    protected QuicNetReport mQuicNetReport;
    protected int mSSORequestReason;
    protected byte[] mST;
    protected byte[] mSTKey;
    public WeakNetLearner mWeakNetLearner;

    /* loaded from: classes19.dex */
    private static class QuicDownloadListener implements DownloadListener {
        static IPatchRedirector $redirector_;
        private WeakReference<BasePicDownloadProcessor> baseDownloadProcesser;
        private final AtomicBoolean cancel;

        public QuicDownloadListener(BasePicDownloadProcessor basePicDownloadProcessor) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) basePicDownloadProcessor);
            } else {
                this.cancel = new AtomicBoolean(false);
                this.baseDownloadProcesser = new WeakReference<>(basePicDownloadProcessor);
            }
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public boolean isCanceled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this)).booleanValue();
            }
            return this.cancel.get();
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void onDownloadFailed(String str, QuicNetReport quicNetReport) {
            boolean z16;
            HttpNetReq httpNetReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) quicNetReport);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(BaseTransProcessor.TAG, 2, "quic download failed. use http try again. errCode: " + quicNetReport.errCode + " errMsg: " + quicNetReport.errMsg);
            }
            if (this.cancel.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d(BaseTransProcessor.TAG, 2, "task canceled.");
                    return;
                }
                return;
            }
            BasePicDownloadProcessor basePicDownloadProcessor = this.baseDownloadProcesser.get();
            if (basePicDownloadProcessor != null && (httpNetReq = (HttpNetReq) basePicDownloadProcessor.mNetReq) != null) {
                if (quicNetReport.failReason == 8) {
                    if (httpNetReq.mCallback != null) {
                        QLog.d(BaseTransProcessor.TAG, 1, "downloadProcessor failReason downloading.");
                        NetResp netResp = new NetResp(httpNetReq);
                        netResp.mResult = 3;
                        httpNetReq.mCallback.onResp(netResp);
                        return;
                    }
                    return;
                }
                quicNetReport.isHttpRetryed = true;
                quicNetReport.stats = QuicEngineImp.saveNetStats(quicNetReport);
                basePicDownloadProcessor.mQuicNetReport = quicNetReport;
                basePicDownloadProcessor.handleQuicFail(2);
                return;
            }
            StringBuilder sb5 = new StringBuilder();
            sb5.append("download fail, downloadProcessor or netReq is null. processor: ");
            if (basePicDownloadProcessor == null) {
                z16 = true;
            } else {
                z16 = false;
            }
            sb5.append(z16);
            QLog.e(BaseTransProcessor.TAG, 1, sb5.toString());
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void onDownloadProgress(String str, long j3, long j16) {
            HttpNetReq httpNetReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, this, str, Long.valueOf(j3), Long.valueOf(j16));
                return;
            }
            if (this.cancel.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d(BaseTransProcessor.TAG, 2, "task canceled.");
                    return;
                }
                return;
            }
            BasePicDownloadProcessor basePicDownloadProcessor = this.baseDownloadProcesser.get();
            if (basePicDownloadProcessor != null && (httpNetReq = (HttpNetReq) basePicDownloadProcessor.mNetReq) != null) {
                INetEngineListener iNetEngineListener = httpNetReq.mCallback;
                if (iNetEngineListener != null) {
                    iNetEngineListener.onUpdateProgeress(httpNetReq, j16, j3);
                    return;
                }
                return;
            }
            QLog.e(BaseTransProcessor.TAG, 1, "quic download progress downloadProcess is null");
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void onDownloadSucceed(String str, QuicNetReport quicNetReport) {
            HttpNetReq httpNetReq;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) quicNetReport);
                return;
            }
            if (QLog.isColorLevel()) {
                QLog.d(BaseTransProcessor.TAG, 2, "quic download cost time: " + quicNetReport.totaltime + " waitTime: " + quicNetReport.waitCost + "  firstCostTime: " + quicNetReport.firstPackageCost);
            }
            if (this.cancel.get()) {
                if (QLog.isColorLevel()) {
                    QLog.d(BaseTransProcessor.TAG, 2, "task canceled.");
                    return;
                }
                return;
            }
            BasePicDownloadProcessor basePicDownloadProcessor = this.baseDownloadProcesser.get();
            if (basePicDownloadProcessor != null && (httpNetReq = (HttpNetReq) basePicDownloadProcessor.mNetReq) != null) {
                quicNetReport.stats = QuicEngineImp.saveNetStats(quicNetReport);
                quicNetReport.success = true;
                basePicDownloadProcessor.mQuicNetReport = quicNetReport;
                basePicDownloadProcessor.quicDownloadSuc(quicNetReport, httpNetReq);
                return;
            }
            QLog.e(BaseTransProcessor.TAG, 1, "quic download success downloadProcess is null");
        }

        @Override // com.tencent.mobileqq.transfile.quic.report.DownloadListener
        public void setCancel(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            } else {
                this.cancel.set(z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(39801);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 41)) {
            redirector.redirect((short) 41);
        } else {
            URL_ENCRYPR_PATH_PATTERN = Pattern.compile(".*//[^/]*/[^/]*/(.*)/.*");
        }
    }

    public BasePicDownloadProcessor(BaseTransFileController baseTransFileController, TransferRequest transferRequest) {
        super(baseTransFileController, transferRequest);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) baseTransFileController, (Object) transferRequest);
            return;
        }
        this.mSSORequestReason = 0;
        this.mDirectDownFailReason = "";
        this.mIpFromInnerDns = false;
        this.failIpReported = new ArrayList<>();
        this.mAvifReportInfo = new HashMap<>();
        this.mAvifDelayCost = 0L;
        this.mEncryptPic = false;
        this.mEncryptUrl = false;
        this.mPicEncryptRollback = false;
        this.decryptConsumeTime = 0L;
        this.mWeakNetLearner = BaseTransProcessorStaticVariable.WEAK_NET_LEARNER;
        encryptConfigInit();
    }

    private boolean checkPicFormat(NetResp netResp) {
        if (netResp != null) {
            try {
                if (netResp.mReq.mOutPath != null) {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(netResp.mReq.mOutPath, options);
                    if (options.outHeight > 0) {
                        if (options.outWidth <= 0) {
                        }
                    }
                    return false;
                }
            } catch (Throwable th5) {
                th5.printStackTrace();
                return false;
            }
        }
        return true;
    }

    private boolean compressAvifRgbToHdJpg(AvifDecoder avifDecoder, MessageForPic messageForPic) {
        String hdThumbFilePath = getHdThumbFilePath(messageForPic);
        if (TextUtils.isEmpty(hdThumbFilePath)) {
            return true;
        }
        Bitmap d16 = avifDecoder.g().d(false);
        CompressInfo compressInfo = new CompressInfo(this.mUiRequest.mOutFilePath, 0);
        compressInfo.R = true;
        compressInfo.H = hdThumbFilePath;
        ThumbWidthHeightDP thumbWidthHeightDP = messageForPic.thumbWidthHeightDP;
        compressInfo.U = thumbWidthHeightDP;
        return g.l(d16, compressInfo.D, hdThumbFilePath, false, compressInfo.f258514d, 0, thumbWidthHeightDP);
    }

    private boolean compressAvifRgbToJpg(AvifDecoder avifDecoder, MessageForPic messageForPic) {
        AvifImage g16 = avifDecoder.g();
        int c16 = AvifDownloadConfProcessor.a().c();
        return g.m(this.mUiRequest.mOutFilePath, "compressAvifToJpeg", null, new g.b(g16.d(false), c16) { // from class: com.tencent.mobileqq.transfile.BasePicDownloadProcessor.2
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bitmap val$bm;
            final /* synthetic */ int val$quality;

            {
                this.val$bm = r6;
                this.val$quality = c16;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, BasePicDownloadProcessor.this, r6, Integer.valueOf(c16));
                }
            }

            @Override // com.tencent.mobileqq.pic.compress.g.b
            public void compress(OutputStream outputStream) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                } else {
                    this.val$bm.compress(Bitmap.CompressFormat.JPEG, this.val$quality, outputStream);
                }
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:90:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x03d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int compressAvifToJpg() {
        boolean z16;
        AvifDecoder avifDecoder;
        String str;
        String str2;
        byte[] bArr;
        long j3;
        long j16;
        long j17;
        long j18;
        boolean z17;
        boolean z18;
        byte[] bArr2;
        int i3;
        long j19;
        long j26;
        long j27;
        boolean z19;
        long j28;
        AvifDecoder avifDecoder2;
        long j29;
        long j36;
        long j37;
        boolean z26;
        boolean z27;
        boolean z28;
        String str3 = "compressAvifRgbToHdJpg decoder destroy ";
        if (!isAvifDecodeSwithOpen("debug_avif_decode_crash")) {
            if (isAvifDecodeSwithOpen("debug_avif_decode_failed")) {
                return 6;
            }
            if (!com.tencent.mobileqq.avifcodec.b.b().c()) {
                return 2;
            }
            TransferRequest transferRequest = this.mUiRequest;
            MessageRecord messageRecord = transferRequest.mRec;
            if (!(messageRecord instanceof MessageForPic)) {
                return 6;
            }
            MessageForPic messageForPic = (MessageForPic) messageRecord;
            if (messageForPic.fileSizeFlag == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (transferRequest.mFileType != ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE, z16)) {
                return 5;
            }
            QLog.i("avif_tag", 1, "compressAvifToJpg : " + messageForPic.uuid);
            long currentTimeMillis = System.currentTimeMillis();
            String str4 = this.mUiRequest.mOutFilePath;
            try {
                byte[] readFile = FileUtils.readFile(str4);
                this.mAvifReportInfo.put("param_decodeReadCost", String.valueOf(System.currentTimeMillis() - currentTimeMillis));
                long currentTimeMillis2 = System.currentTimeMillis();
                avifDecoder = AvifDecoder.c(readFile);
                if (avifDecoder != null) {
                    try {
                        if (avifDecoder.n() == 0) {
                            long currentTimeMillis3 = System.currentTimeMillis();
                            AvifImage g16 = avifDecoder.g();
                            int h16 = g16.h();
                            int g17 = g16.g();
                            if (h16 > 0 && g17 > 0) {
                                StringBuilder sb5 = new StringBuilder();
                                try {
                                    sb5.append("compressAvifToJpg srcImage wh :");
                                    sb5.append(h16);
                                    sb5.append(HippyTKDListViewAdapter.X);
                                    sb5.append(g17);
                                    QLog.i("avif_tag", 1, sb5.toString());
                                    this.mAvifReportInfo.put("param_width", String.valueOf(h16));
                                    this.mAvifReportInfo.put("param_height", String.valueOf(g17));
                                    long j38 = currentTimeMillis3 - currentTimeMillis2;
                                    this.mAvifReportInfo.put("param_decodeYuvCost", String.valueOf(j38));
                                    boolean g18 = AvifDownloadConfProcessor.a().g();
                                    HashMap<String, String> hashMap = this.mAvifReportInfo;
                                    if (g18) {
                                        str = "1";
                                    } else {
                                        str = "0";
                                    }
                                    hashMap.put("param_yuvToJpgSwitch", str);
                                    if (g16.i() == 3 && g18) {
                                        try {
                                            j16 = System.currentTimeMillis();
                                            boolean compressAvifYuvToJpg = compressAvifYuvToJpg(avifDecoder, messageForPic);
                                            j17 = System.currentTimeMillis();
                                            StringBuilder sb6 = new StringBuilder();
                                            sb6.append("compressAvifYuvToJpg ret: ");
                                            sb6.append(compressAvifYuvToJpg);
                                            sb6.append("\uff0c cost:");
                                            bArr = readFile;
                                            long j39 = j17 - j16;
                                            sb6.append(j39);
                                            sb6.append("ms");
                                            str2 = str4;
                                            QLog.i("avif_tag", 1, sb6.toString());
                                            if (compressAvifYuvToJpg) {
                                                this.mAvifReportInfo.put("param_yuvToJpgCost", String.valueOf(j39));
                                                j3 = System.currentTimeMillis();
                                                boolean compressAvifYuvToHdJpg = compressAvifYuvToHdJpg(avifDecoder, messageForPic);
                                                j18 = System.currentTimeMillis();
                                                StringBuilder sb7 = new StringBuilder();
                                                z26 = compressAvifYuvToJpg;
                                                sb7.append("compressAvifYuvToHdJpg retHd: ");
                                                sb7.append(compressAvifYuvToHdJpg);
                                                sb7.append("\uff0c cost:");
                                                sb7.append(j18 - j3);
                                                sb7.append("ms");
                                                QLog.i("avif_tag", 1, sb7.toString());
                                                z27 = compressAvifYuvToHdJpg;
                                            } else {
                                                z26 = compressAvifYuvToJpg;
                                                j3 = 0;
                                                j18 = 0;
                                                z27 = false;
                                            }
                                            if (z27) {
                                                z28 = z27;
                                                this.mAvifReportInfo.put("param_yuvToHdJpgCost", String.valueOf(j18 - j3));
                                            } else {
                                                z28 = z27;
                                            }
                                            z17 = z26;
                                            z18 = z28;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            str3 = "compressAvifRgbToHdJpg decoder destroy ";
                                            try {
                                                QLog.e("avif_tag", 1, "compressAvifToJpg error ", th);
                                                if (!(th instanceof OutOfMemoryError)) {
                                                }
                                            } finally {
                                                if (avifDecoder != null) {
                                                    avifDecoder.b();
                                                    QLog.i("avif_tag", 1, str3);
                                                }
                                            }
                                        }
                                    } else {
                                        str2 = str4;
                                        bArr = readFile;
                                        j3 = 0;
                                        j16 = 0;
                                        j17 = 0;
                                        j18 = 0;
                                        z17 = false;
                                        z18 = false;
                                    }
                                    if (!z17) {
                                        long currentTimeMillis4 = System.currentTimeMillis();
                                        boolean compressAvifRgbToJpg = compressAvifRgbToJpg(avifDecoder, messageForPic);
                                        j27 = System.currentTimeMillis();
                                        j19 = j3;
                                        bArr2 = bArr;
                                        long j46 = j27 - currentTimeMillis4;
                                        i3 = g17;
                                        this.mAvifReportInfo.put("param_rgbToJpgCost", String.valueOf(j46));
                                        QLog.i("avif_tag", 1, "compressAvifRgbToJpg ret: " + compressAvifRgbToJpg + "\uff0c cost:" + j46 + "ms");
                                        j26 = currentTimeMillis4;
                                        j16 = 0;
                                        z19 = compressAvifRgbToJpg;
                                    } else {
                                        bArr2 = bArr;
                                        i3 = g17;
                                        j19 = j3;
                                        j26 = 0;
                                        j27 = 0;
                                        z19 = z17;
                                    }
                                    if (!z18) {
                                        long currentTimeMillis5 = System.currentTimeMillis();
                                        z18 = compressAvifRgbToHdJpg(avifDecoder, messageForPic);
                                        j37 = System.currentTimeMillis();
                                        avifDecoder2 = avifDecoder;
                                        try {
                                            j28 = j26;
                                            long j47 = j37 - currentTimeMillis5;
                                            j29 = currentTimeMillis5;
                                            this.mAvifReportInfo.put("param_rgbToHdJpgCost", String.valueOf(j47));
                                            QLog.i("avif_tag", 1, "compressAvifRgbToHdJpg retHd: " + z18 + "\uff0c cost:" + j47 + "ms");
                                            j36 = 0L;
                                        } catch (Throwable th6) {
                                            th = th6;
                                            str3 = "compressAvifRgbToHdJpg decoder destroy ";
                                            avifDecoder = avifDecoder2;
                                            QLog.e("avif_tag", 1, "compressAvifToJpg error ", th);
                                            if (!(th instanceof OutOfMemoryError)) {
                                                if (avifDecoder != null) {
                                                    avifDecoder.b();
                                                    QLog.i("avif_tag", 1, str3);
                                                    return 3;
                                                }
                                                return 3;
                                            }
                                            if (avifDecoder != null) {
                                                avifDecoder.b();
                                                QLog.i("avif_tag", 1, str3);
                                                return 4;
                                            }
                                            return 4;
                                        }
                                    } else {
                                        j28 = j26;
                                        avifDecoder2 = avifDecoder;
                                        j29 = 0;
                                        j36 = j19;
                                        j37 = 0;
                                    }
                                    if (isNeedDebugWatermask()) {
                                        StringBuilder sb8 = new StringBuilder("\u683c\u5f0f\uff1aavif");
                                        sb8.append("\n\u5c3a\u5bf8\uff1a");
                                        sb8.append(h16);
                                        sb8.append(HippyTKDListViewAdapter.X);
                                        sb8.append(i3);
                                        sb8.append("\navif\u5927\u5c0f\uff1a");
                                        sb8.append(bArr2.length / 1000);
                                        sb8.append("kb");
                                        sb8.append("\n\u751f\u6210jpg\u5927\u56fe\u5927\u5c0f\uff1a");
                                        sb8.append(new File(str2).length() / 1000);
                                        sb8.append("kb");
                                        sb8.append("\n\u89e3\u7801yuv\u8017\u65f6\uff1a");
                                        sb8.append(j38);
                                        sb8.append("ms");
                                        if (j16 > 0) {
                                            sb8.append("\nyuv\u76f4\u8f6cjpg\u5927\u56fe\u8017\u65f6\uff1a");
                                            sb8.append(j17 - j16);
                                            sb8.append("ms");
                                        }
                                        if (j36 > 0) {
                                            sb8.append("\nyuv\u76f4\u8f6c\u9ad8\u6e05\u7f29\u7565\u56fe\u8017\u65f6\uff1a");
                                            sb8.append(j18 - j36);
                                            sb8.append("ms");
                                        }
                                        if (j28 > 0) {
                                            sb8.append("\nrgb\u8f6cjpg\u5927\u56fe\u8017\u65f6\uff1a");
                                            sb8.append(j27 - j28);
                                            sb8.append("ms");
                                        }
                                        if (j29 > 0) {
                                            sb8.append("\nrgb\u8f6c\u9ad8\u6e05\u7f29\u7565\u56fe\u8017\u65f6\uff1a");
                                            sb8.append(j37 - j29);
                                            sb8.append("ms");
                                        }
                                        sb8.append("\n\u603b\u8017\u65f6\uff1a");
                                        sb8.append(System.currentTimeMillis() - currentTimeMillis2);
                                        sb8.append("ms");
                                        printDebugWatermaskInfo(sb8.toString(), false);
                                        QLog.i("avif_tag", 1, "compressAvifToJpg waterInfo: " + sb8.toString());
                                    }
                                    if (z18) {
                                        String hdThumbFilePath = getHdThumbFilePath(messageForPic);
                                        URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(messageForPic, 65537, (String) null);
                                        if (new File(hdThumbFilePath).exists()) {
                                            ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onFileDownload(hdThumbFilePath, this.mUiRequest.mRec);
                                        }
                                        refreshURLDrawable(messageForPic, url, true);
                                    }
                                    QLog.i("avif_tag", 1, "compressAvifRgbToHdJpg ret: " + z18);
                                    int i16 = !z19;
                                    avifDecoder2.b();
                                    QLog.i("avif_tag", 1, "compressAvifRgbToHdJpg decoder destroy ");
                                    return i16;
                                } catch (Throwable th7) {
                                    th = th7;
                                }
                            }
                            avifDecoder.b();
                            QLog.i("avif_tag", 1, "compressAvifRgbToHdJpg decoder destroy ");
                            return 1;
                        }
                    } catch (Throwable th8) {
                        th = th8;
                    }
                }
                if (avifDecoder != null) {
                    return 1;
                }
                return 1;
            } catch (Throwable th9) {
                th = th9;
                avifDecoder = null;
            }
        } else {
            throw new Error("debug_avif_decode_crash open");
        }
    }

    private boolean compressAvifYuvToHdJpg(AvifDecoder avifDecoder, MessageForPic messageForPic) {
        String hdThumbFilePath = getHdThumbFilePath(messageForPic);
        AvifImage g16 = avifDecoder.g();
        int h16 = g16.h();
        int g17 = g16.g();
        int c16 = AvifDownloadConfProcessor.a().c();
        g.c u16 = g.u(messageForPic.thumbWidthHeightDP, 0, Math.max(h16, g17));
        float f16 = u16.f258695c / u16.f258693a;
        float f17 = h16;
        float f18 = g17;
        if (f17 <= f18 * f16 && f18 <= f17 * f16) {
            float max = Math.max(h16, g17);
            int i3 = u16.f258695c;
            if (max > i3) {
                float f19 = i3 / max;
                h16 = (int) (f17 * f19);
                g17 = (int) (f18 * f19);
                if (h16 != 0 && g17 != 0) {
                    QLog.i("avif_tag", 1, "compressAvifYuvToHdJpg scaleImage wh :" + h16 + HippyTKDListViewAdapter.X + g17);
                    if (!avifDecoder.q(h16, g17)) {
                        QLog.i("avif_tag", 1, "compressAvifYuvToHdJpg scaleImage failed");
                        return false;
                    }
                    g16 = avifDecoder.g();
                } else {
                    QLog.i("avif_tag", 1, "compressAvifYuvToHdJpg scaleImage failed, wh is 0");
                    return false;
                }
            }
            return g.m(hdThumbFilePath, "compressAvifYuvToHdJpg", null, new g.b(new YuvImage(g16.a(), 17, h16, g17, null), c16) { // from class: com.tencent.mobileqq.transfile.BasePicDownloadProcessor.3
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$quality;
                final /* synthetic */ YuvImage val$yuvImage;

                {
                    this.val$yuvImage = r6;
                    this.val$quality = c16;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, BasePicDownloadProcessor.this, r6, Integer.valueOf(c16));
                    }
                }

                @Override // com.tencent.mobileqq.pic.compress.g.b
                public void compress(OutputStream outputStream) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                    } else {
                        this.val$yuvImage.compressToJpeg(new Rect(0, 0, this.val$yuvImage.getWidth(), this.val$yuvImage.getHeight()), this.val$quality, outputStream);
                    }
                }
            });
        }
        QLog.i("avif_tag", 1, "compressAvifYuvToHdJpg ratio is big: " + f16);
        return false;
    }

    private boolean compressAvifYuvToJpg(AvifDecoder avifDecoder, MessageForPic messageForPic) {
        if (isAvifDecodeSwithOpen("debug_avif_decode_yuv_to_jpg_failed")) {
            return false;
        }
        AvifImage g16 = avifDecoder.g();
        return g.m(this.mUiRequest.mOutFilePath, "compressAvifToJpeg", null, new g.b(new YuvImage(g16.a(), 17, g16.h(), g16.g(), null), AvifDownloadConfProcessor.a().c()) { // from class: com.tencent.mobileqq.transfile.BasePicDownloadProcessor.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ int val$quality;
            final /* synthetic */ YuvImage val$yuvImage;

            {
                this.val$yuvImage = r6;
                this.val$quality = r7;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, BasePicDownloadProcessor.this, r6, Integer.valueOf(r7));
                }
            }

            @Override // com.tencent.mobileqq.pic.compress.g.b
            public void compress(OutputStream outputStream) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                } else {
                    this.val$yuvImage.compressToJpeg(new Rect(0, 0, this.val$yuvImage.getWidth(), this.val$yuvImage.getHeight()), this.val$quality, outputStream);
                }
            }
        });
    }

    private void doSendHttpReq() {
        boolean z16;
        IHttpEngineService iHttpEngineService;
        NetReq netReq = this.mNetReq;
        if (netReq != null && (iHttpEngineService = this.mNetEngine) != null) {
            iHttpEngineService.sendReq(netReq);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("mNetReq == null or mNetEngine == null, mNetEngins is ");
        if (this.mNetEngine == null) {
            z16 = true;
        } else {
            z16 = false;
        }
        sb5.append(z16);
        QLog.d(BaseTransProcessor.TAG, 1, sb5.toString());
    }

    private String getHdThumbFilePath(MessageForPic messageForPic) {
        String filePath = AbsDownloader.getFilePath(((IPicHelper) QRoute.api(IPicHelper.class)).getURL(messageForPic, 65537, (String) null).toString());
        if (filePath != null && !filePath.endsWith("_hd")) {
            if (filePath.endsWith("_big400")) {
                filePath.replace("_big400", "_hd");
                return filePath;
            }
            return filePath + "_hd";
        }
        return filePath;
    }

    private void handleProgressiveJPEG(NetResp netResp) {
        String str;
        String str2;
        NetReq netReq = netResp.mReq;
        if (netReq != null && (str = netReq.mTempPath) != null && str.length() != 0 && (str2 = netResp.mReq.mOutPath) != null && str2.length() != 0) {
            NetReq netReq2 = netResp.mReq;
            String str3 = netReq2.mTempPath;
            String str4 = netReq2.mOutPath;
            if (this.mUiRequest == null) {
                return;
            }
            if (QLog.isColorLevel()) {
                TransferRequest transferRequest = this.mUiRequest;
                RichMediaUtil.log(transferRequest.mUinType, transferRequest.mIsUp, transferRequest.mFileType, String.valueOf(transferRequest.mUniseq), "handleProgressiveJPEG", "mUiRequest.mRequestOffset: " + this.mUiRequest.mRequestOffset + " mUiRequest.mRequestLength: " + this.mUiRequest.mRequestLength + " tempPath: " + str3 + " outPath: " + str4);
            }
            int downloadStatus = getDownloadStatus(this.mUiRequest);
            if (downloadStatus == 4) {
                writeProgressiveLastSlice(str4, str3);
            } else if (downloadStatus == 2) {
                writeProgressiveFirstSlice(str4, str3);
            } else if (downloadStatus == 3) {
                writeProgressiveMidSlice(str4, str3);
            }
        }
    }

    private boolean isAvifDecodeSwithOpen(String str) {
        return false;
    }

    private boolean isNeedDebugWatermask() {
        return isAvifDecodeSwithOpen("debug_avif_watermask_switch");
    }

    private boolean needReport() {
        if (System.currentTimeMillis() % 1000 < 10) {
            return true;
        }
        return false;
    }

    private void printDebugWatermaskInfo(String str, boolean z16) {
        boolean z17;
        TransferRequest transferRequest = this.mUiRequest;
        MessageRecord messageRecord = transferRequest.mRec;
        if (!(messageRecord instanceof MessageForPic)) {
            return;
        }
        MessageForPic messageForPic = (MessageForPic) messageRecord;
        if (messageForPic.fileSizeFlag == 1) {
            z17 = true;
        } else {
            z17 = false;
        }
        if (transferRequest.mFileType != ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE, z17)) {
            return;
        }
        String hdThumbFilePath = getHdThumbFilePath(messageForPic);
        Bitmap decodeFile = BitmapFactory.decodeFile(hdThumbFilePath);
        if (decodeFile != null) {
            str = str + "\n\u9ad8\u6e05\u7f29\u7565\u56fe\u5c3a\u5bf8\uff1a" + decodeFile.getWidth() + HippyTKDListViewAdapter.X + decodeFile.getHeight();
            Bitmap copy = decodeFile.copy(decodeFile.getConfig(), true);
            g.p(copy, str, 10.0f);
            g.m(hdThumbFilePath, "drawWaterMask", null, new g.b(copy) { // from class: com.tencent.mobileqq.transfile.BasePicDownloadProcessor.4
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bitmap val$finalBm;

                {
                    this.val$finalBm = copy;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BasePicDownloadProcessor.this, (Object) copy);
                    }
                }

                @Override // com.tencent.mobileqq.pic.compress.g.b
                public void compress(OutputStream outputStream) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                    } else {
                        this.val$finalBm.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                    }
                }
            });
        }
        String str2 = this.mUiRequest.mOutFilePath;
        Bitmap decodeFile2 = BitmapFactory.decodeFile(str2);
        if (decodeFile2 != null) {
            Bitmap copy2 = decodeFile2.copy(decodeFile2.getConfig(), true);
            g.p(copy2, str, 32.0f);
            g.m(str2, "drawWaterMask", null, new g.b(copy2) { // from class: com.tencent.mobileqq.transfile.BasePicDownloadProcessor.5
                static IPatchRedirector $redirector_;
                final /* synthetic */ Bitmap val$finalBm;

                {
                    this.val$finalBm = copy2;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) BasePicDownloadProcessor.this, (Object) copy2);
                    }
                }

                @Override // com.tencent.mobileqq.pic.compress.g.b
                public void compress(OutputStream outputStream) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) outputStream);
                    } else {
                        this.val$finalBm.compress(Bitmap.CompressFormat.JPEG, 90, outputStream);
                    }
                }
            });
        }
        if (z16) {
            URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(messageForPic, 65537, (String) null);
            if (new File(hdThumbFilePath).exists()) {
                ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onFileDownload(hdThumbFilePath, this.mUiRequest.mRec);
            }
            refreshURLDrawable(messageForPic, url, true);
        }
    }

    private void reportDecodeAvifResult(boolean z16) {
        if (!needReport()) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(ReportConstant.DecodeAvif.PARAM_UIN_TYPE, String.valueOf(this.mUiRequest.mUinType));
        hashMap.put(ReportConstant.DecodeAvif.PARAM_PIC_TYPE, "avif");
        hashMap.put(ReportConstant.DecodeAvif.PARAM_DECODE_SUCCESS, boolToIntString(z16));
        QQBeaconReport.report(this.mUiRequest.mSelfUin, ReportConstant.DecodeAvif.EVENT, hashMap);
    }

    private void writeProgressiveFirstSlice(String str, String str2) {
        File file;
        File file2;
        byte[] bArr = {-1, -39};
        File file3 = new File(str2);
        File file4 = new File(str);
        if (file4.exists()) {
            file4.delete();
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("peak_pgjpeg", 4, "handleProgressiveJPEG head:tempFile length is " + file3.length() + ", " + str);
        }
        if (file3.exists()) {
            RandomAccessFile randomAccessFile = null;
            try {
                try {
                    RandomAccessFile randomAccessFile2 = new RandomAccessFile(file3, "rw");
                    try {
                        randomAccessFile2.seek(randomAccessFile2.length());
                        randomAccessFile2.write(bArr);
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e16) {
                            e16.printStackTrace();
                        }
                    } catch (FileNotFoundException e17) {
                        e = e17;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (!FileUtils.rename(str2, str)) {
                            if (FileUtils.copyFile(str2, str)) {
                                file2 = new File(str2);
                                file2.delete();
                            } else {
                                file = new File(str2);
                                file.delete();
                            }
                        }
                        return;
                    } catch (IOException e19) {
                        e = e19;
                        randomAccessFile = randomAccessFile2;
                        e.printStackTrace();
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e26) {
                                e26.printStackTrace();
                            }
                        }
                        if (!FileUtils.rename(str2, str)) {
                            if (FileUtils.copyFile(str2, str)) {
                                file2 = new File(str2);
                                file2.delete();
                            } else {
                                file = new File(str2);
                                file.delete();
                            }
                        }
                        return;
                    } catch (Throwable th5) {
                        th = th5;
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e27) {
                                e27.printStackTrace();
                            }
                        }
                        if (!FileUtils.rename(str2, str)) {
                            if (FileUtils.copyFile(str2, str)) {
                                new File(str2).delete();
                                throw th;
                            }
                            new File(str2).delete();
                            throw th;
                        }
                        throw th;
                    }
                } catch (FileNotFoundException e28) {
                    e = e28;
                } catch (IOException e29) {
                    e = e29;
                }
                if (!FileUtils.rename(str2, str)) {
                    if (FileUtils.copyFile(str2, str)) {
                        file2 = new File(str2);
                        file2.delete();
                    } else {
                        file = new File(str2);
                        file.delete();
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
        }
    }

    private void writeProgressiveLastSlice(String str, String str2) {
        FileInputStream fileInputStream;
        File file;
        File file2;
        String str3 = str + ".tmp1";
        FileUtils.copyFile(str, str3);
        File file3 = new File(str3);
        File file4 = new File(str2);
        if (QLog.isDevelopLevel()) {
            QLog.d("peak_pgjpeg", 4, "handleProgressiveJPEG left part:tempFile length is " + file4.length() + ", " + str);
        }
        if (file3.exists() && file4.exists()) {
            RandomAccessFile randomAccessFile = null;
            try {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file3, "rw");
                try {
                    randomAccessFile2.seek(this.mUiRequest.mRequestOffset);
                    fileInputStream = new FileInputStream(file4);
                    try {
                        byte[] bArr = new byte[1024];
                        while (true) {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                randomAccessFile2.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (IOException e16) {
                                    e16.printStackTrace();
                                }
                            }
                        }
                        randomAccessFile2.close();
                        try {
                            fileInputStream.close();
                        } catch (IOException e17) {
                            e17.printStackTrace();
                        }
                        file4.delete();
                    } catch (Throwable unused) {
                        randomAccessFile = randomAccessFile2;
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException e18) {
                                e18.printStackTrace();
                            }
                        }
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                e19.printStackTrace();
                            }
                        }
                        file4.delete();
                        if (!FileUtils.rename(str3, str)) {
                            if (FileUtils.copyFile(str3, str)) {
                                file2 = new File(str3);
                                file2.delete();
                            } else {
                                file = new File(str3);
                                file.delete();
                            }
                        }
                        return;
                    }
                } catch (Throwable unused2) {
                    fileInputStream = null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
            if (!FileUtils.rename(str3, str)) {
                if (FileUtils.copyFile(str3, str)) {
                    file2 = new File(str3);
                    file2.delete();
                } else {
                    file = new File(str3);
                    file.delete();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:72:? A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ba A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00b5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void writeProgressiveMidSlice(String str, String str2) {
        FileInputStream fileInputStream;
        RandomAccessFile randomAccessFile;
        Throwable th5;
        File file;
        File file2;
        byte[] bArr = {-1, -39};
        String str3 = str + ".tmp1";
        FileUtils.copyFile(str, str3);
        File file3 = new File(str3);
        File file4 = new File(str2);
        if (QLog.isDevelopLevel()) {
            QLog.d("peak_pgjpeg", 4, "handleProgressiveJPEG part:tempFile length is " + file4.length() + ", " + str);
        }
        if (file3.exists() && file4.exists()) {
            RandomAccessFile randomAccessFile2 = null;
            try {
                randomAccessFile = new RandomAccessFile(file3, "rw");
            } catch (IOException unused) {
                fileInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                fileInputStream = null;
                randomAccessFile = null;
            }
            try {
                randomAccessFile.seek(this.mUiRequest.mRequestOffset);
                fileInputStream = new FileInputStream(file4);
            } catch (IOException unused2) {
                fileInputStream = null;
            } catch (Throwable th7) {
                th = th7;
                fileInputStream = null;
                th5 = th;
                if (randomAccessFile != null) {
                }
                if (fileInputStream != null) {
                }
                file4.delete();
                if (FileUtils.rename(str3, str)) {
                }
            }
            try {
                byte[] bArr2 = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr2);
                    if (read <= 0) {
                        break;
                    } else {
                        randomAccessFile.write(bArr2, 0, read);
                    }
                }
                randomAccessFile.write(bArr);
                try {
                    randomAccessFile.close();
                } catch (IOException unused3) {
                }
                try {
                    fileInputStream.close();
                } catch (IOException unused4) {
                }
                file4.delete();
            } catch (IOException unused5) {
                randomAccessFile2 = randomAccessFile;
                if (randomAccessFile2 != null) {
                    try {
                        randomAccessFile2.close();
                    } catch (IOException unused6) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused7) {
                    }
                }
                file4.delete();
                if (!FileUtils.rename(str3, str)) {
                    if (FileUtils.copyFile(str3, str)) {
                        file2 = new File(str3);
                        file2.delete();
                    } else {
                        file = new File(str3);
                        file.delete();
                    }
                }
                return;
            } catch (Throwable th8) {
                th5 = th8;
                if (randomAccessFile != null) {
                    try {
                        randomAccessFile.close();
                    } catch (IOException unused8) {
                    }
                }
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException unused9) {
                    }
                }
                file4.delete();
                if (FileUtils.rename(str3, str)) {
                    if (FileUtils.copyFile(str3, str)) {
                        new File(str3).delete();
                        throw th5;
                    }
                    new File(str3).delete();
                    throw th5;
                }
                throw th5;
            }
            if (!FileUtils.rename(str3, str)) {
                if (FileUtils.copyFile(str3, str)) {
                    file2 = new File(str3);
                    file2.delete();
                } else {
                    file = new File(str3);
                    file.delete();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String appendInfoForSvr(String str, boolean z16) {
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            return (String) iPatchRedirector.redirect((short) 20, this, str, Boolean.valueOf(z16));
        }
        int i3 = this.mUiRequest.mDownMode;
        if (i3 == 0) {
            str2 = "&rf=aio";
        } else if (i3 == 1) {
            str2 = "&rf=naio";
        } else {
            str2 = "&rf=other";
        }
        String str4 = "cldver=" + AppSetting.f99554n + str2;
        int indexOf = str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        if (indexOf > 0) {
            int i16 = indexOf + 1;
            if (str.length() == i16) {
                str3 = str.substring(0, i16) + str4;
            } else {
                int indexOf2 = str.indexOf("#", indexOf);
                if (indexOf2 > -1) {
                    str3 = str.substring(0, indexOf2) + ContainerUtils.FIELD_DELIMITER + str4 + str.substring(indexOf2);
                } else {
                    str3 = str + ContainerUtils.FIELD_DELIMITER + str4;
                }
            }
        } else {
            str3 = str + QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER + str4;
        }
        String str5 = str3 + "&msgTime=" + this.mUiRequest.mMsgTime;
        if (z16) {
            return str5 + "&tp=avif";
        }
        return str5;
    }

    protected String boolToIntString(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return (String) iPatchRedirector.redirect((short) 19, (Object) this, z16);
        }
        if (z16) {
            return "1";
        }
        return "0";
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public int cancel() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            return ((Integer) iPatchRedirector.redirect((short) 31, (Object) this)).intValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d(BaseTransProcessor.TAG, 2, "cancel()");
        }
        QuicDownloadListener quicDownloadListener = this.mQuicDownloadListener;
        if (quicDownloadListener != null) {
            quicDownloadListener.setCancel(true);
            this.mQuicDownloadListener = null;
        }
        return super.cancel();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void checkFailCodeReport(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
        } else if (!z16 && this.mProcessorReport.errCode == 0 && QLog.isColorLevel()) {
            r.a("PIC_TRANS_0_ERROR", Arrays.toString(new Throwable().getStackTrace()));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean checkMemoryForEncrypt() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, (Object) this)).booleanValue();
        }
        TransferRequest transferRequest = this.mUiRequest;
        if (transferRequest.mFileType == 65537) {
            return true;
        }
        MessageRecord messageRecord = transferRequest.mRec;
        if (messageRecord instanceof MessageForPic) {
            long j3 = ((MessageForPic) messageRecord).size;
            long maxMemory = Runtime.getRuntime().maxMemory() - (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory());
            if (maxMemory < j3) {
                QLog.e(BaseTransProcessor.TAG, 1, "checkMemoryForEncrypt : memory is not enough ! remainMemory = " + maxMemory + ", picSize = " + j3);
                return false;
            }
            if (j3 > 5242880) {
                QLog.e(BaseTransProcessor.TAG, 1, "checkMemoryForEncrypt : pic too large, picSize = " + j3);
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void directMsgUrlDown(String str, int i3) {
        String str2 = this.mPicDownExtra.mUrlFromMsg;
        this.mUrlPath = str2;
        if (str2 != null && str2.length() != 0) {
            if (QLog.isColorLevel() && this.mUrlPath.contains("com.tencent.mobileqq")) {
                r.a("Download_Pic_URL_Invalid", this.mUrlPath);
                QLog.d(BaseTransProcessor.TAG, 1, "directMsgUrlDown Download_Pic_URL_Invalid:" + this.mUrlPath);
            }
            ArrayList<ServerAddr> selectIpList = selectIpList(makeServerIpList(InnerDns.getInstance().reqDnsForIpList(str, i3, true, 28, false), true), makeServerIpList(InnerDns.getInstance().reqDnsForIpList(str, i3, true, 1, false), false), str);
            this.mIpList = selectIpList;
            if (selectIpList != null && selectIpList.size() > 0) {
                this.mIpFromInnerDns = true;
                this.mDirectMsgUrlDown = true;
                this.mProcessorReport.mStepDirectDown.logStartTime();
                boolean isUsingHttps = isUsingHttps();
                if (QLog.isColorLevel()) {
                    QLog.d(BaseTransProcessor.TAG, 2, "isHttps: " + isUsingHttps);
                }
                if (isUsingHttps) {
                    this.mEncryptPic = false;
                    this.mEncryptUrl = false;
                }
                receiveFile(isUsingHttps, isQuicDomain(str));
                return;
            }
            if (isQuicDomain(str)) {
                handleQuicFail(1);
                return;
            } else {
                this.mSSORequestReason = 2;
                sendRequest();
                return;
            }
        }
        QLog.i(BaseTransProcessor.TAG, 1, "directMsgUrlDown url path not available");
        this.mSSORequestReason = 1;
        sendRequest();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void doReport(boolean z16, String str, long j3, HashMap<String, String> hashMap) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, this, Boolean.valueOf(z16), str, Long.valueOf(j3), hashMap);
            return;
        }
        if (!z16) {
            String valueOf = String.valueOf(this.mProcessorReport.errCode);
            ProcessorReport processorReport = this.mProcessorReport;
            if (processorReport.errCode == -9527 && (str2 = processorReport.mReportInfo.get(ReportConstant.KEY_REASON)) != null) {
                valueOf = str2;
            }
            hashMap.put(KEY_PIC_DOWNLOAD_ERROR_CODE, valueOf);
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, str, true, j3, this.mTotolLen, hashMap, null);
        }
    }

    protected void doReportAvif(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, (Object) this, z16);
            return;
        }
        int i3 = this.mUiRequest.mUinType;
        int i16 = 1;
        if (i3 != 1 && i3 != 3000) {
            if (i3 == 10014) {
                i16 = 3;
            }
        } else {
            i16 = 2;
        }
        this.mAvifReportInfo.put(QQNotificationManager.PARAM_UINTYPE, String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.AVIF_PIC_DOWNLOAD_STATISTIC_TAG, z16, 0L, 0L, this.mAvifReportInfo, null);
        this.mAvifReportInfo.clear();
    }

    protected void doReportAvifReqSupport(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("param_code", String.valueOf(i3));
        hashMap.put("param_codec_support", String.valueOf(i16));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, StatisticCollector.AVIF_REQ_SUPPORT_STATISTIC_TAG, true, 0L, 0L, hashMap, null);
    }

    public void encryptConfigInit() {
        String str;
        byte[] bArr;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        TicketManager ticketManager = (TicketManager) this.app.getManager(2);
        this.mSTKey = ticketManager.getStkey(this.app.getAccount(), ENCRYPT_APPID);
        this.mST = ticketManager.getSt(this.app.getAccount(), ENCRYPT_APPID);
        subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf picDownEncryptConf = ((IDep) QRoute.api(IDep.class)).getPicDownEncryptConf();
        byte[] bArr2 = this.mST;
        if (bArr2 != null && (bArr = this.mSTKey) != null && bArr2.length > 0 && bArr.length > 0 && picDownEncryptConf != null) {
            this.mEncryptUrl = picDownEncryptConf.bool_enable_encrypt_request.get();
            this.mEncryptPic = picDownEncryptConf.bool_enable_encrypted_pic.get();
        } else {
            this.mEncryptPic = false;
            this.mEncryptUrl = false;
        }
        if (this.mSTKey == null) {
            str = "key or switch can't get!";
        } else {
            str = "STKey:" + MD5.toMD5(this.mSTKey);
        }
        logRichMediaEvent("ticketInit", str);
        if (!isAllowEncrypt(picDownEncryptConf) || !BaseDownloadProcessor.IS_MAIN_PROCESS) {
            this.mEncryptPic = false;
            this.mEncryptUrl = false;
        }
    }

    public void encryptReqInit(HttpNetReq httpNetReq, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) httpNetReq, (Object) str);
            return;
        }
        if (this.mEncryptUrl) {
            String encryptURL = encryptURL(str);
            httpNetReq.mReqUrl = encryptURL;
            if (!str.equals(encryptURL)) {
                httpNetReq.mReqProperties.put("Cookie", "mST=" + PkgTools.toHexStr(this.mST));
                if (this.mEncryptPic) {
                    PicCryptor picCryptor = new PicCryptor(this.mSTKey);
                    picCryptor.f307064m = httpNetReq;
                    httpNetReq.decoder = picCryptor;
                    httpNetReq.mTempPath = httpNetReq.mOutPath + "." + MD5.toMD5(TransFileUtil.getUrlResoursePath(str, false)) + ".tmp";
                }
            }
        } else {
            this.mEncryptPic = false;
        }
        if (this.mPicEncryptRollback && !this.mEncryptPic) {
            httpNetReq.mTempPath = httpNetReq.mOutPath + "." + MD5.toMD5(TransFileUtil.getUrlResoursePath(str, false)) + ".tmp";
            StringBuilder sb5 = new StringBuilder();
            sb5.append(str);
            sb5.append("&rollback=1");
            httpNetReq.mReqUrl = sb5.toString();
        }
    }

    public String encryptURL(String str) {
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        }
        String encryptPath = getEncryptPath(str);
        Cryptor cryptor = new Cryptor();
        if (encryptPath != null) {
            String str3 = encryptPath + "&encrypt=";
            if (this.mEncryptPic) {
                str2 = str3 + "1";
            } else {
                str2 = str3 + "0";
            }
            return str.replace(encryptPath, PkgTools.toHexStr(cryptor.encrypt(str2.getBytes(), this.mSTKey)));
        }
        this.mEncryptPic = false;
        return str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void fixAvifOutFilePath(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, z16);
            return;
        }
        String str = this.mUiRequest.mOutFilePath;
        if (str != null && str.length() != 0) {
            boolean endsWith = this.mUiRequest.mOutFilePath.endsWith(AVIF_FILE_SUFFIX);
            if (z16 && !endsWith) {
                this.mUiRequest.mOutFilePath = this.mUiRequest.mOutFilePath + AVIF_FILE_SUFFIX;
                return;
            }
            if (!z16 && endsWith) {
                TransferRequest transferRequest = this.mUiRequest;
                transferRequest.mOutFilePath = transferRequest.mOutFilePath.substring(0, r0.length() - 5);
            }
        }
    }

    protected int getDnsType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 37)) {
            return ((Integer) iPatchRedirector.redirect((short) 37, (Object) this)).intValue();
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getDownloadStatus(TransferRequest transferRequest) {
        int i3;
        int i16 = transferRequest.mRequestOffset;
        if (i16 < 0) {
            return 1;
        }
        if (i16 > 0) {
            if (transferRequest.mRequestLength > 0) {
                i3 = 3;
            } else {
                i3 = 4;
            }
            return i3;
        }
        if (transferRequest.mRequestLength <= 0) {
            return 1;
        }
        return 2;
    }

    public String getEncryptPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str);
        }
        Matcher matcher = URL_ENCRYPR_PATH_PATTERN.matcher(str);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getFixUrl(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            return (String) iPatchRedirector.redirect((short) 22, (Object) this, (Object) str);
        }
        return str;
    }

    protected String getHttpDomain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 36)) {
            return (String) iPatchRedirector.redirect((short) 36, (Object) this);
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean getQuicToggleState() {
        IFeatureRuntimeService iFeatureRuntimeService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 38)) {
            return ((Boolean) iPatchRedirector.redirect((short) 38, (Object) this)).booleanValue();
        }
        AppInterface appInterface = this.app;
        if (appInterface == null || (iFeatureRuntimeService = (IFeatureRuntimeService) appInterface.getRuntimeService(IFeatureRuntimeService.class, "all")) == null) {
            return false;
        }
        return iFeatureRuntimeService.isFeatureSwitchEnable("android_richmedia_picdownload_quic_8885", false);
    }

    public void handleBigThumb() {
        MessageForPic messageForPic;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
            return;
        }
        MessageRecord messageRecord = this.mUiRequest.mRec;
        if (GifDrawable.isGifFile(new File(this.mUiRequest.mOutFilePath))) {
            if (messageRecord != null && (messageRecord instanceof MessageForPic)) {
                MessageForPic messageForPic2 = (MessageForPic) messageRecord;
                if (!messageForPic2.checkGif()) {
                    messageForPic2.imageType = 2000;
                    messageForPic2.updateMessage();
                    return;
                }
                return;
            }
            return;
        }
        if (ah.v() >= 240) {
            if (((IMsgMixed) QRoute.api(IMsgMixed.class)).isMessageForMixedMsg(messageRecord)) {
                messageRecord = ((IMsgMixed) QRoute.api(IMsgMixed.class)).getMessageForPic(messageRecord, this.mUiRequest.mSubMsgId);
            } else if (((IMsgStructing) QRoute.api(IMsgStructing.class)).isMessageForStructing(messageRecord)) {
                messageRecord = ((IMsgStructing) QRoute.api(IMsgStructing.class)).getMessageForPic(messageRecord);
            }
            if (messageRecord != null && (messageRecord instanceof MessageForPic)) {
                messageForPic = (MessageForPic) messageRecord;
            } else {
                messageForPic = null;
            }
            if (messageForPic != null) {
                if (ac.c(messageForPic) && !TextUtils.isEmpty(messageForPic.md5)) {
                    af.f(this.mUiRequest.mOutFilePath, this.mUiRequest.mOutFilePath + "_fp", messageForPic.md5);
                    return;
                }
                updateThumb(messageForPic);
            }
        }
    }

    protected void handleQuicFail(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 35)) {
            iPatchRedirector.redirect((short) 35, (Object) this, i3);
            return;
        }
        QLog.i(BaseTransProcessor.TAG, 1, "handleQuicfaile, reason is " + i3);
        if (i3 == 2) {
            this.mHttpReqWithQuicIp = true;
            doSendHttpReq();
        } else {
            if (i3 == 4) {
                QuicNetReport quicNetReport = new QuicNetReport();
                this.mQuicNetReport = quicNetReport;
                quicNetReport.failReason = 7;
                quicNetReport.isHttpRetryed = true;
                this.mHttpReqWithQuicIp = true;
                doSendHttpReq();
                return;
            }
            directMsgUrlDown(getHttpDomain(), getDnsType());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:63:0x00be, code lost:
    
        if (r18.mEncryptPic != false) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00c5, code lost:
    
        r5 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c3, code lost:
    
        if (r2 == 9058) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void handleRespErr(NetResp netResp) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) netResp);
            return;
        }
        boolean z16 = false;
        if (this.mHttpReqWithQuicIp) {
            this.mHttpReqWithQuicIp = false;
            handleQuicFail(3);
            return;
        }
        if (netResp.mErrCode == 9364 && this.mNetworkChgRetryCount < 3) {
            logRichMediaEvent("[netChg]", "failed.but net change detect.so retry");
            this.mSSORequestReason = 4;
            this.mDirectDownFailReason = netResp.mErrDesc;
            this.mNetworkChgRetryCount++;
            clearReprotInfo();
            sendRequest();
            return;
        }
        if (isAvifNetReq()) {
            QLog.d(BaseTransProcessor.TAG, 1, "avif download failed, try jpg");
            this.mSupportAvifDown = false;
            this.mAvifReportInfo.put("param_downloadResult", "0");
            doReportAvif(false);
            sendRequest();
            return;
        }
        if (this.mEncryptPic || this.mEncryptUrl) {
            this.mEncryptPic = false;
            this.mEncryptUrl = false;
            this.mPicEncryptRollback = true;
            int i3 = netResp.mErrCode;
            if (i3 == -9527) {
                String str2 = netResp.mRespProperties.get(HttpMsg.Param_Reason);
                if (!TextUtils.isEmpty(str2) && str2.split("_").length >= 3) {
                    String[] split = str2.split("_");
                    String str3 = split[0];
                    String str4 = split[1];
                    String str5 = split[2];
                    if ("H".equals(str3)) {
                        if (IndividuationPlugin.Business_Pendant.equals(str4)) {
                            if (str5.equals("-106")) {
                            }
                        }
                    }
                }
                if (this.mNetReq != null) {
                    if (("encryptReqError=" + z16 + ", ResErroCode:" + netResp.mErrCode + " ,erroDesc:" + netResp.mErrDesc + " ,encryptUrl:" + ((HttpNetReq) this.mNetReq).mReqUrl) == null) {
                        str = "null";
                    } else {
                        str = ((HttpNetReq) this.mNetReq).mReqUrl + " ,ST:" + PkgTools.toHexStr(this.mST);
                    }
                    this.mDecryptErrorMsg = str;
                }
            }
        }
        if (this.mDirectMsgUrlDown) {
            this.mSSORequestReason = 3;
            this.mDirectDownFailReason = netResp.mErrDesc;
            sendRequest();
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.put("param_FailCode", String.valueOf(netResp.mErrCode));
            hashMap.put(ReportConstant.KEY_ERR_DESC, netResp.mErrDesc);
            NetReq netReq = this.mNetReq;
            if (netReq != null) {
                hashMap.put("param_url", ((HttpNetReq) netReq).mReqUrl);
            }
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.mUiRequest.mSelfUin, REPORT_TAG_DIRECT_DOWNLOAD_FAIL, false, (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000, this.mTotolLen, hashMap, "");
        } else {
            onError();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.mUiRequest.mUinType);
        stringBuffer.append(" isMsgDown:");
        stringBuffer.append(this.mDirectMsgUrlDown);
        stringBuffer.append(" result:");
        stringBuffer.append(netResp.mResult);
        stringBuffer.append(" adr:");
        ArrayList<ServerAddr> arrayList = this.mIpList;
        if (arrayList != null) {
            Iterator<ServerAddr> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    stringBuffer.append(StringUtil.toHexString(it.next().mIp) + ",");
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        }
        QLog.d(BaseTransProcessor.TAG, 1, stringBuffer.toString());
    }

    public void handleRespSuc(NetResp netResp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) netResp);
            return;
        }
        if (!this.mNetReq.mIsRenameInEngine) {
            handleProgressiveJPEG(netResp);
        }
        int i3 = 0;
        if ((this.mEncryptUrl || this.mEncryptPic) && !checkPicFormat(netResp)) {
            this.mEncryptPic = false;
            this.mEncryptUrl = false;
            this.mPicEncryptRollback = true;
            this.mDecryptErrorMsg = "checkPicFormat Erro, erroCode:" + netResp.mErrCode + " ,erroDesc:" + netResp.mErrDesc + " ,encryptUrl:" + ((HttpNetReq) this.mNetReq).mReqUrl + " ,ST:" + PkgTools.toHexStr(this.mST);
            sendRequest();
            return;
        }
        onSuccess();
        RMServMonitorReport rMServMonitorReport = this.mRSMReporter;
        long j3 = this.mRecvLen;
        TransferRequest.PicDownExtraInfo picDownExtraInfo = this.mPicDownExtra;
        if (picDownExtraInfo != null) {
            i3 = picDownExtraInfo.mStartDownOffset;
        }
        rMServMonitorReport.mFileSize = j3 - i3;
        reportForServerMonitor(netResp, true, RMServMonitorReport.REPORT_NAME_NM_PICDOWN, this.mUiRequest.mServerPath);
    }

    public void handleThumb() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this);
            return;
        }
        TransferRequest transferRequest = this.mUiRequest;
        TransferResult transferResult = transferRequest.mResult;
        if (transferResult != null) {
            transferResult.mResult = 0;
            transferResult.mOrigReq = transferRequest;
            try {
                int i3 = transferRequest.mFileType;
                if (i3 != 65537 || transferRequest.mOutFilePath == null) {
                    if ((i3 == 1 || i3 == 131075) && transferRequest.mOutFilePath != null && transferRequest.mRec != null) {
                        handleBigThumb();
                    }
                }
            } catch (Throwable th5) {
                if (QLog.isColorLevel()) {
                    QLog.e("PIC_TAG", 2, th5.getMessage());
                }
            }
        }
    }

    public boolean isAllowEncrypt(subcmd0x501.SubCmd0x501Rspbody.DownloadEncryptConf downloadEncryptConf) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) downloadEncryptConf)).booleanValue();
        }
        return false;
    }

    protected boolean isAvifNetReq() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return ((Boolean) iPatchRedirector.redirect((short) 24, (Object) this)).booleanValue();
        }
        NetReq netReq = this.mNetReq;
        if ((netReq instanceof HttpNetReq) && ((HttpNetReq) netReq).mReqUrl.contains(REQ_PARAM_AVIF)) {
            return true;
        }
        return false;
    }

    protected boolean isQuicDomain(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            return ((Boolean) iPatchRedirector.redirect((short) 33, (Object) this, (Object) str)).booleanValue();
        }
        if (!IPicTransFile.C2C_PIC_DOWNLOAD_QUIC_DOMAIN.equalsIgnoreCase(str) && !IPicTransFile.GROUP_PIC_DOWNLOAD_QUIC_DOMAIN.equalsIgnoreCase(str)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isSupportAvifDownload() {
        boolean z16;
        String str;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        if (!this.mSupportAvifDown) {
            QLog.i("avif_tag", 1, "not support : retry:" + this.mUiRequest.mMd5);
            doReportAvifReqSupport(1, 0);
            return false;
        }
        TransferRequest transferRequest = this.mUiRequest;
        MessageRecord messageRecord = transferRequest.mRec;
        if (!(messageRecord instanceof MessageForPic)) {
            doReportAvifReqSupport(2, 0);
            return false;
        }
        MessageForPic messageForPic = (MessageForPic) messageRecord;
        if (messageForPic.fileSizeFlag == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        int i3 = transferRequest.mFileType;
        if ((i3 == 131075 && z16) || i3 == 65537) {
            if (i3 == 131075 && z16) {
                doReportAvifReqSupport(3, 0);
                QLog.i("avif_tag", 1, "not support : file type " + this.mUiRequest.mFileType);
            }
            return false;
        }
        if (messageForPic.checkGif()) {
            QLog.i("avif_tag", 1, "not support gif ");
            return false;
        }
        if (ah.v() < 240) {
            doReportAvifReqSupport(10, 0);
            QLog.i("avif_tag", 1, "not support : density :" + ah.v());
            return false;
        }
        if (ac.c(messageForPic)) {
            doReportAvifReqSupport(9, 0);
            QLog.i("avif_tag", 1, "not support : is flash pic msg");
            return false;
        }
        TransferRequest transferRequest2 = this.mUiRequest;
        if (transferRequest2.useOutputstream && transferRequest2.mOut != null) {
            doReportAvifReqSupport(11, 0);
            QLog.i("avif_tag", 1, "not support : use output stream");
            return false;
        }
        com.tencent.mobileqq.config.business.c a16 = AvifDownloadConfProcessor.a();
        if (a16 != null && a16.f()) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime == null) {
                doReportAvifReqSupport(12, 0);
                QLog.i("avif_tag", 1, "not support : app runtime null");
                return false;
            }
            com.tencent.mobileqq.avifcodec.data.a decoderSupportAndUpdate = ((IAvifConfigServiceApi) QRoute.api(IAvifConfigServiceApi.class)).getDecoderSupportAndUpdate(peekAppRuntime, a16.e());
            if (!decoderSupportAndUpdate.f200174a) {
                doReportAvifReqSupport(5, decoderSupportAndUpdate.f200175b);
                QLog.i("avif_tag", 1, "not support : decode not support");
                return false;
            }
            if (!com.tencent.mobileqq.avifcodec.b.b().c()) {
                doReportAvifReqSupport(8, 0);
                com.tencent.mobileqq.avifcodec.b.b().f(null);
                QLog.i("avif_tag", 1, "not support : so is not download suc");
                return false;
            }
            long j3 = messageForPic.width;
            if (j3 != 0 && messageForPic.height != 0 && j3 <= a16.b() && messageForPic.height <= a16.a()) {
                String str3 = this.mUiRequest.mOutFilePath;
                if (str3 != null) {
                    if (str3.endsWith(AVIF_FILE_SUFFIX)) {
                        str = this.mUiRequest.mOutFilePath;
                    } else {
                        str = this.mUiRequest.mOutFilePath + AVIF_FILE_SUFFIX;
                    }
                    File file = new File(str);
                    if (file.exists()) {
                        doReportAvifReqSupport(7, 0);
                        boolean b16 = com.tencent.mobileqq.avifcodec.util.b.b(str);
                        this.mAvifReportInfo.put("param_lastCrashedUrl", this.mUrlPath);
                        HashMap<String, String> hashMap = this.mAvifReportInfo;
                        if (b16) {
                            str2 = "1";
                        } else {
                            str2 = "0";
                        }
                        hashMap.put("param_lastIsAvif", str2);
                        doReportAvif(false);
                        FileUtils.deleteFile(file);
                        QLog.i("avif_tag", 1, "not support : avif file exist:" + this.mUiRequest.mMd5);
                        return false;
                    }
                }
                doReportAvifReqSupport(0, 0);
                return true;
            }
            doReportAvifReqSupport(6, 0);
            QLog.i("avif_tag", 1, "not support : size =" + messageForPic.size + ", wh = " + messageForPic.width + HippyTKDListViewAdapter.X + messageForPic.height);
            return false;
        }
        doReportAvifReqSupport(4, 0);
        QLog.i("avif_tag", 1, "not support : switch not open");
        return false;
    }

    protected boolean isUsingHttps() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 29)) {
            return ((Boolean) iPatchRedirector.redirect((short) 29, (Object) this)).booleanValue();
        }
        RichmediaHttpsConfProcessor.a d16 = RichmediaHttpsConfProcessor.d();
        if (d16 != null && d16.a()) {
            return true;
        }
        return false;
    }

    protected ArrayList<ServerAddr> makeServerIpList(ArrayList<String> arrayList, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            return (ArrayList) iPatchRedirector.redirect((short) 28, this, arrayList, Boolean.valueOf(z16));
        }
        ArrayList<ServerAddr> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                ServerAddr serverAddr = new ServerAddr();
                serverAddr.mIp = next;
                serverAddr.port = BaseDownloadProcessor.getPicDownloadPort();
                serverAddr.isIpv6 = z16;
                arrayList2.add(serverAddr);
            }
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    public void onError() {
        ServerAddr ipAndPortFromUrl;
        int i3;
        super.onError();
        TransferRequest transferRequest = this.mUiRequest;
        TransferResult transferResult = transferRequest.mResult;
        if (transferResult != null) {
            transferResult.mResult = -1;
            ProcessorReport processorReport = this.mProcessorReport;
            transferResult.mErrCode = processorReport.errCode;
            transferResult.mErrDesc = processorReport.errDesc;
            transferResult.mOrigReq = transferRequest;
        }
        synchronized (this) {
            FileMsg fileMsg = this.file;
            if (fileMsg != null) {
                fileMsg.status = 2005;
            }
            Iterator<com.tencent.mobileqq.pic.c> it = this.mDownCallBacks.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.pic.c next = it.next();
                c.a aVar = new c.a();
                aVar.f258654a = -1;
                ProcessorReport processorReport2 = this.mProcessorReport;
                aVar.f258655b = processorReport2.errCode;
                aVar.f258656c = processorReport2.errDesc;
                next.h(aVar);
                if (QLog.isColorLevel()) {
                    QLog.d("PIC_TAG", 2, "onError ");
                }
            }
            if (this.file != null) {
                logRichMediaEvent("notify", "start");
            }
            notifyAll();
            if (this.file != null) {
                logRichMediaEvent("notify", "end");
            }
        }
        int i16 = this.mProcessorReport.errCode;
        if ((i16 == 9014 || i16 == 9050) && (ipAndPortFromUrl = TransFileUtil.getIpAndPortFromUrl(((HttpNetReq) this.mNetReq).mReqUrl)) != null) {
            String str = ipAndPortFromUrl.mIp;
            ProbeChain probeChain = new ProbeChain();
            if (this.mProcessorReport.errCode == 9014) {
                probeChain.addProbeItem(new PingProbe());
                probeChain.addProbeItem(new MtuProbe());
                probeChain.addProbeItem(new TracerouteProbe());
            } else {
                probeChain.addProbeItem(new PingProbe());
                probeChain.addProbeItem(new TracerouteProbe());
            }
            if (this.mProcessorReport.errCode == 9014) {
                i3 = -1201;
            } else {
                i3 = -1202;
            }
            ProbeRequest probeRequest = new ProbeRequest(str, i3, probeChain);
            WeakNetLearner weakNetLearner = this.mWeakNetLearner;
            if (weakNetLearner != null) {
                weakNetLearner.startProbe(new ProbeTask(probeRequest));
            }
        }
        sendMessageToUpdate(2005);
        ((IDep) QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, String.valueOf(this.mProcessorReport.errCode), false);
    }

    @Override // com.tencent.mobileqq.transfile.NetFailedListener
    public void onFailed(NetResp netResp) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this, (Object) netResp);
            return;
        }
        RMServMonitorReport rMServMonitorReport = this.mRSMReporter;
        long j3 = this.mRecvLen;
        TransferRequest.PicDownExtraInfo picDownExtraInfo = this.mPicDownExtra;
        if (picDownExtraInfo == null) {
            i3 = 0;
        } else {
            i3 = picDownExtraInfo.mStartDownOffset;
        }
        rMServMonitorReport.mFileSize = j3 - i3;
        reportForServerMonitor(netResp, false, RMServMonitorReport.REPORT_NAME_NM_PICDOWN, this.mUiRequest.mServerPath);
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    public void onResp(NetResp netResp) {
        boolean z16;
        boolean z17;
        StepInfo stepInfo;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) netResp);
            return;
        }
        super.onResp(netResp);
        StringBuilder sb5 = new StringBuilder();
        sb5.append("directMsgUrlDown:");
        sb5.append(this.mDirectMsgUrlDown);
        sb5.append(" isEncrypt:");
        boolean z18 = false;
        if (!this.mEncryptPic && !this.mEncryptUrl) {
            z16 = false;
        } else {
            z16 = true;
        }
        sb5.append(z16);
        sb5.append(" isRollBack:");
        sb5.append(this.mPicEncryptRollback);
        sb5.append(" result:");
        if (netResp.mResult == 0) {
            z17 = true;
        } else {
            z17 = false;
        }
        sb5.append(z17);
        logRichMediaEvent("onHttpResp", sb5.toString());
        if (QLog.isColorLevel() && this.mNetReq != null) {
            QLog.d("big_thumb", 2, "onResp" + this.mUiRequest.mFileType + "mUiRequest.mOutFilePath=" + this.mUiRequest.mOutFilePath + "url=" + ((HttpNetReq) this.mNetReq).mReqUrl);
        }
        if (this.mDirectMsgUrlDown) {
            stepInfo = this.mProcessorReport.mStepDirectDown;
        } else {
            stepInfo = this.mProcessorReport.mStepTrans;
        }
        ProcessorReport processorReport = this.mProcessorReport;
        if (netResp.mResult == 0) {
            z18 = true;
        }
        processorReport.copyStaticsInfoFromNetResp(stepInfo, netResp, z18);
        long j3 = netResp.mTotalFileLen;
        this.mTotolLen = j3;
        if (j3 <= 0) {
            this.mTotolLen = netResp.mTotalBlockLen + netResp.mReq.mStartDownOffset;
        }
        this.mRecvLen += netResp.mWrittenBlockLen;
        if (netResp.mResult == 0 && this.mNetReq != null) {
            handleRespSuc(netResp);
        } else {
            handleRespErr(netResp);
        }
        this.mNetReq = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0307 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0298 A[SYNTHETIC] */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onSuccess() {
        boolean z16;
        String str;
        String str2;
        boolean z17;
        long j3;
        boolean isAvifNetReq = isAvifNetReq();
        boolean b16 = com.tencent.mobileqq.avifcodec.util.b.b(this.mUiRequest.mOutFilePath);
        if (isAvifNetReq) {
            this.mAvifReportInfo.put("param_downloadResult", "1");
            HashMap<String, String> hashMap = this.mAvifReportInfo;
            if (b16) {
                str = "1";
            } else {
                str = "0";
            }
            hashMap.put(ReportConstant.KEY_RECEIVE_AVIF, str);
            StringBuilder sb5 = new StringBuilder();
            sb5.append("avif req download big pic is ");
            if (b16) {
                str2 = "avif";
            } else {
                str2 = "jpg";
            }
            sb5.append(str2);
            QLog.i("avif_tag", 1, sb5.toString());
            if (isNeedDebugWatermask()) {
                NetReq netReq = this.mNetReq;
                if (netReq instanceof HttpNetReq) {
                    HttpNetReq httpNetReq = (HttpNetReq) netReq;
                    if (httpNetReq.mReqUrl.contains(REQ_PARAM_AVIF)) {
                        QLog.i("avif_tag", 1, "avif req url is " + httpNetReq.mReqUrl);
                    }
                }
            }
            if (b16) {
                QLog.i("avif_tag", 1, "compressAvifToJpeg begin: " + this.mUiRequest.mOutFilePath);
                long currentTimeMillis = System.currentTimeMillis();
                this.mAvifDelayCost = 0L;
                ThreadManagerV2.executeDelay(new Runnable(currentTimeMillis) { // from class: com.tencent.mobileqq.transfile.BasePicDownloadProcessor.6
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ long val$startDecodeTime;

                    {
                        this.val$startDecodeTime = currentTimeMillis;
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                            iPatchRedirector.redirect((short) 1, this, BasePicDownloadProcessor.this, Long.valueOf(currentTimeMillis));
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector = $redirector_;
                        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                            iPatchRedirector.redirect((short) 2, (Object) this);
                        } else {
                            BasePicDownloadProcessor.this.mAvifDelayCost = System.currentTimeMillis() - this.val$startDecodeTime;
                        }
                    }
                }, 16, null, false, 1000L);
                int compressAvifToJpg = compressAvifToJpg();
                this.mAvifReportInfo.put("param_decodeErrcode", String.valueOf(compressAvifToJpg));
                if (compressAvifToJpg == 0) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                reportDecodeAvifResult(z17);
                if (compressAvifToJpg != 0) {
                    FileUtils.deleteFile(this.mUiRequest.mOutFilePath);
                    this.mSupportAvifDown = false;
                    sendRequest();
                    this.mAvifReportInfo.put("param_decodeFailedUrl", this.mUrlPath);
                    doReportAvif(true);
                    QLog.i("avif_tag", 1, "avif decode failed, retry jpg: " + this.mUiRequest.mMd5);
                    return;
                }
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                this.mAvifReportInfo.put("param_totalCost", String.valueOf(currentTimeMillis2));
                HashMap<String, String> hashMap2 = this.mAvifReportInfo;
                if (this.mAvifDelayCost == 0) {
                    j3 = currentTimeMillis2;
                } else {
                    j3 = this.mAvifDelayCost;
                }
                hashMap2.put("param_delayCost", String.valueOf(j3));
                if (currentTimeMillis2 > AvifDownloadConfProcessor.a().d()) {
                    this.mAvifReportInfo.put("param_decodeUrl", this.mUrlPath);
                }
            }
            if (this.mUiRequest.mOutFilePath.endsWith(AVIF_FILE_SUFFIX)) {
                long currentTimeMillis3 = System.currentTimeMillis();
                String substring = this.mUiRequest.mOutFilePath.substring(0, r0.length() - 5);
                boolean rename = FileUtils.rename(this.mUiRequest.mOutFilePath, substring);
                if (!rename) {
                    FileUtils.deleteFile(this.mUiRequest.mOutFilePath);
                    this.mSupportAvifDown = false;
                    this.mAvifReportInfo.put("param_decodeErrcode", String.valueOf(7));
                    doReportAvif(false);
                    sendRequest();
                    return;
                }
                this.mUiRequest.mOutFilePath = substring;
                QLog.i("avif_tag", 1, "rename avif file time: " + (System.currentTimeMillis() - currentTimeMillis3) + ", ret = " + rename);
            }
            doReportAvif(true);
        }
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_IS_AVIF, boolToIntString(isAvifNetReq()));
        this.mProcessorReport.mReportInfo.put(ReportConstant.KEY_RECEIVE_AVIF, boolToIntString(b16));
        super.onSuccess();
        if (QLog.isColorLevel()) {
            QLog.d("big_thumb", 2, "onsuccess mUiRequest.mFileType" + this.mUiRequest.mFileType + "mUiRequest.mOutFilePath=" + this.mUiRequest.mOutFilePath + "url=" + ((HttpNetReq) this.mNetReq).mReqUrl);
        }
        if (!b16) {
            long currentTimeMillis4 = System.currentTimeMillis();
            handleThumb();
            if (isNeedDebugWatermask()) {
                printDebugWatermaskInfo("\u683c\u5f0f\uff1ajpg\n\u603b\u8017\u65f6\uff1a" + (System.currentTimeMillis() - currentTimeMillis4) + "ms", true);
            }
        }
        synchronized (this) {
            FileMsg fileMsg = this.file;
            if (fileMsg != null) {
                fileMsg.status = 2003;
            }
            TransferRequest transferRequest = this.mUiRequest;
            if (transferRequest.mDisplayOutFilePath != null) {
                File file = new File(transferRequest.mDisplayOutFilePath);
                if (file.exists() && file.delete() && QLog.isDevelopLevel()) {
                    QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():Delete " + transferRequest.mDisplayOutFilePath);
                }
            }
            int downloadStatus = getDownloadStatus(this.mUiRequest);
            Iterator<com.tencent.mobileqq.pic.c> it = this.mDownCallBacks.iterator();
            while (it.hasNext()) {
                com.tencent.mobileqq.pic.c next = it.next();
                c.a aVar = new c.a();
                aVar.f258654a = 0;
                TransferRequest transferRequest2 = this.mUiRequest;
                aVar.f258658e = transferRequest2.mOutFilePath;
                aVar.f258660g = transferRequest2.mMd5;
                aVar.f258661h = transferRequest2.mFileType;
                aVar.f258662i = transferRequest2.mDownMode;
                if (downloadStatus != 2 && downloadStatus != 3) {
                    z16 = false;
                    aVar.f258663j = z16;
                    next.h(aVar);
                    if (this.mUiRequest.mFileType == 131075 && QLog.isDevelopLevel()) {
                        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.mUiRequest.mOutFilePath + ", isPart " + aVar.f258663j);
                    }
                    if (!QLog.isColorLevel()) {
                        QLog.d("PIC_TAG", 2, "onSuccess ");
                    }
                }
                z16 = true;
                aVar.f258663j = z16;
                next.h(aVar);
                if (this.mUiRequest.mFileType == 131075) {
                    QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onSuccess():" + this.mUiRequest.mOutFilePath + ", isPart " + aVar.f258663j);
                }
                if (!QLog.isColorLevel()) {
                }
            }
            if (this.file != null) {
                logRichMediaEvent("notify", "start");
            }
            notifyAll();
            if (this.file != null) {
                logRichMediaEvent("notify", "end");
            }
        }
        IMsgStorageApi iMsgStorageApi = (IMsgStorageApi) QRoute.api(IMsgStorageApi.class);
        TransferRequest transferRequest3 = this.mUiRequest;
        iMsgStorageApi.onFileDownload(transferRequest3.mOutFilePath, transferRequest3.mRec);
        sendMessageToUpdate(2003);
        ((IDep) QRoute.api(IDep.class)).reportEmotionPicMonitor(this.mUiRequest.mRec, null, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0171 A[Catch: all -> 0x017d, LOOP:0: B:47:0x016b->B:49:0x0171, LOOP_END, TryCatch #8 {, blocks: (B:15:0x0041, B:17:0x0045, B:18:0x0049, B:21:0x0053, B:23:0x0057, B:27:0x0075, B:29:0x007a, B:39:0x00c2, B:42:0x00c8, B:44:0x00ce, B:46:0x0165, B:47:0x016b, B:49:0x0171, B:51:0x017b, B:54:0x00f1, B:79:0x0106, B:81:0x0112, B:87:0x0132, B:86:0x012f, B:65:0x0137, B:68:0x013d, B:70:0x0143), top: B:14:0x0041, inners: #7 }] */
    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.INetEngineListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onUpdateProgeress(NetReq netReq, long j3, long j16) {
        Iterator<com.tencent.mobileqq.pic.c> it;
        TransferRequest transferRequest;
        Throwable th5;
        TransferRequest transferRequest2;
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, netReq, Long.valueOf(j3), Long.valueOf(j16));
            return;
        }
        int i3 = (int) ((10000 * j3) / j16);
        if (i3 > this.mLastProgress) {
            this.mLastProgress = i3;
            URLDrawableHandler uRLDrawableHandler = this.mPicDownExtra.mHandler;
            if (uRLDrawableHandler != null) {
                uRLDrawableHandler.publishProgress(i3);
            }
        }
        synchronized (this) {
            FileMsg fileMsg = this.file;
            if (fileMsg != null) {
                fileMsg.status = 2002;
            }
            TransferRequest transferRequest3 = this.mUiRequest;
            int i16 = transferRequest3.mRequestDisplayLength;
            if (transferRequest3.mRequestOffset == 0 && i16 > 0 && transferRequest3.mDisplayOutFilePath != null) {
                File file = new File(transferRequest3.mDisplayOutFilePath);
                File file2 = new File(netReq.mTempPath);
                long length = file2.length();
                if (!file.exists() && length > 0) {
                    long j17 = i16;
                    if (j17 < length) {
                        File file3 = new File(transferRequest3.mDisplayOutFilePath + "_tmp");
                        RandomAccessFile randomAccessFile = null;
                        try {
                            long copyFileUsingFileChannels = FileUtils.copyFileUsingFileChannels(file2, file3, 0, i16);
                            if (copyFileUsingFileChannels != j17 && file3.exists()) {
                                file3.delete();
                            } else {
                                byte[] bArr = {-1, -39};
                                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file3, "rw");
                                try {
                                    randomAccessFile2.seek(copyFileUsingFileChannels);
                                    randomAccessFile2.write(bArr);
                                    randomAccessFile = randomAccessFile2;
                                } catch (IOException unused) {
                                    transferRequest2 = transferRequest3;
                                    randomAccessFile = randomAccessFile2;
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                            FileUtils.renameFile(file3, file);
                                            try {
                                                if (QLog.isDevelopLevel()) {
                                                    QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onUpdateProgeress():Create file " + transferRequest2.mDisplayOutFilePath);
                                                }
                                            } catch (IOException e16) {
                                                e = e16;
                                                e.printStackTrace();
                                                it = this.mDownCallBacks.iterator();
                                                while (it.hasNext()) {
                                                }
                                            }
                                        } catch (IOException e17) {
                                            e = e17;
                                            z16 = false;
                                        }
                                        it = this.mDownCallBacks.iterator();
                                        while (it.hasNext()) {
                                        }
                                    }
                                    z16 = false;
                                    it = this.mDownCallBacks.iterator();
                                    while (it.hasNext()) {
                                    }
                                } catch (Throwable th6) {
                                    transferRequest = transferRequest3;
                                    th5 = th6;
                                    randomAccessFile = randomAccessFile2;
                                    if (randomAccessFile != null) {
                                        try {
                                            randomAccessFile.close();
                                            FileUtils.renameFile(file3, file);
                                            if (QLog.isDevelopLevel()) {
                                                QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onUpdateProgeress():Create file " + transferRequest.mDisplayOutFilePath);
                                                throw th5;
                                            }
                                            throw th5;
                                        } catch (IOException e18) {
                                            e18.printStackTrace();
                                            throw th5;
                                        }
                                    }
                                    throw th5;
                                }
                            }
                        } catch (IOException unused2) {
                            transferRequest2 = transferRequest3;
                        } catch (Throwable th7) {
                            transferRequest = transferRequest3;
                            th5 = th7;
                        }
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                                FileUtils.renameFile(file3, file);
                                try {
                                    if (QLog.isDevelopLevel()) {
                                        QLog.d("peak_pgjpeg", 4, "BasePicDownloadProcessor.onUpdateProgeress():Create file " + transferRequest3.mDisplayOutFilePath);
                                    }
                                } catch (IOException e19) {
                                    e = e19;
                                    e.printStackTrace();
                                    it = this.mDownCallBacks.iterator();
                                    while (it.hasNext()) {
                                    }
                                }
                            } catch (IOException e26) {
                                e = e26;
                                z16 = false;
                            }
                            it = this.mDownCallBacks.iterator();
                            while (it.hasNext()) {
                                it.next().a(i3, z16);
                            }
                        }
                    }
                }
            }
            z16 = false;
            it = this.mDownCallBacks.iterator();
            while (it.hasNext()) {
            }
        }
    }

    @Override // com.tencent.mobileqq.transfile.BaseTransProcessor, com.tencent.mobileqq.transfile.ITransProcessor
    public void pause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 32)) {
            iPatchRedirector.redirect((short) 32, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(BaseTransProcessor.TAG, 2, "pause()");
        }
        QuicDownloadListener quicDownloadListener = this.mQuicDownloadListener;
        if (quicDownloadListener != null) {
            quicDownloadListener.setCancel(true);
            this.mQuicDownloadListener = null;
        }
        super.pause();
    }

    protected void quicDownloadSuc(QuicNetReport quicNetReport, HttpNetReq httpNetReq) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 39)) {
            iPatchRedirector.redirect((short) 39, (Object) this, (Object) quicNetReport, (Object) httpNetReq);
            return;
        }
        if (httpNetReq != null && httpNetReq.mCallback != null) {
            NetResp netResp = new NetResp(httpNetReq);
            netResp.mHttpCode = quicNetReport.httpStatus;
            netResp.mTotalFileLen = quicNetReport.fileSize;
            netResp.reqCost = quicNetReport.totaltime;
            HashMap<String, String> hashMap = new HashMap<>();
            hashMap.putAll(quicNetReport.headers);
            netResp.setResult(0, quicNetReport.errCode, quicNetReport.errMsg, hashMap);
            httpNetReq.mCallback.onResp(netResp);
        }
    }

    void receiveFile(boolean z16, boolean z17) {
    }

    protected void refreshURLDrawable(MessageForPic messageForPic, URL url, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, this, messageForPic, url, Boolean.valueOf(z16));
            return;
        }
        if (z16) {
            ImageCacheHelper imageCacheHelper = ImageCacheHelper.f98636a;
            if (imageCacheHelper.g(url.toString()) != null) {
                imageCacheHelper.m(url.toString());
                URLDrawable drawable = URLDrawable.getDrawable(url);
                if (drawable != null) {
                    if (messageForPic.thumbWidthHeightDP == null) {
                        drawable.downloadImediatly(true);
                    } else {
                        drawable.invalidateSelf();
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportQuicNetState() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 40)) {
            iPatchRedirector.redirect((short) 40, (Object) this);
            return;
        }
        if (this.mQuicNetReport != null) {
            String reportTAG = getReportTAG();
            if (!StatisticCollector.C2C_SMAILLPICDOWN_STATISTIC_TAG.equals(reportTAG) && !StatisticCollector.C2C_PICDOWN_STATISTIC_TAG.equals(reportTAG)) {
                z16 = false;
            } else {
                z16 = true;
            }
            this.mQuicNetReport.reportBeaconEvent(false, z16);
            this.mQuicNetReport = null;
        }
    }

    public void updateThumb(MessageForPic messageForPic) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) messageForPic);
            return;
        }
        boolean z17 = true;
        if (messageForPic.fileSizeFlag == 1) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.mUiRequest.mFileType == ((IPicHelper) QRoute.api(IPicHelper.class)).getFileSizeType(ProtocolDownloaderConstants.PROTOCOL_CHAT_IMAGE, z16)) {
            CompressInfo compressInfo = new CompressInfo(this.mUiRequest.mOutFilePath, 0);
            URL url = ((IPicHelper) QRoute.api(IPicHelper.class)).getURL(messageForPic, 65537, (String) null);
            compressInfo.R = true;
            String filePath = AbsDownloader.getFilePath(url.toString());
            if (!filePath.endsWith("_hd")) {
                if (filePath.endsWith("_big400")) {
                    filePath.replace("_big400", "_hd");
                } else {
                    filePath = filePath + "_hd";
                }
                compressInfo.H = filePath;
                compressInfo.U = messageForPic.thumbWidthHeightDP;
                ((ICompressOperator) QRoute.api(ICompressOperator.class)).startThumbnail(compressInfo);
                if (compressInfo.H != null) {
                    File file = new File(filePath);
                    if (compressInfo.H.equals(compressInfo.D)) {
                        z17 = FileUtils.copyFile(new File(compressInfo.D), file);
                    }
                    if (file.exists()) {
                        ((IMsgStorageApi) QRoute.api(IMsgStorageApi.class)).onFileDownload(filePath, this.mUiRequest.mRec);
                    }
                    refreshURLDrawable(messageForPic, url, z17);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void useQuicDownload(HttpNetReq httpNetReq, IQuicEngine iQuicEngine) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) httpNetReq, (Object) iQuicEngine);
            return;
        }
        if (iQuicEngine == null) {
            handleQuicFail(4);
            return;
        }
        ArrayList<ServerAddr> arrayList = this.mIpList;
        if (arrayList != null && !arrayList.isEmpty()) {
            ServerAddr serverAddr = this.mIpList.get(0);
            String str = serverAddr.mIp;
            int i3 = serverAddr.port;
            if (TextUtils.isEmpty(str)) {
                handleQuicFail(1);
                return;
            }
            if (str.startsWith("[") && str.endsWith("]")) {
                str = str.substring(1, str.length() - 1);
            }
            if (i3 <= 0) {
                i3 = WebSocketImpl.DEFAULT_WSS_PORT;
            }
            QuicReq.Builder builder = new QuicReq.Builder(str, i3, this.mUrlPath, httpNetReq.mOutPath);
            if (!StringUtil.isEmpty(this.mDownDomain)) {
                builder.addHeader("host", this.mDownDomain);
            }
            if (this.mQuicDownloadListener == null) {
                this.mQuicDownloadListener = new QuicDownloadListener(this);
            }
            this.mQuicDownloadListener.cancel.set(false);
            if (httpNetReq.mTempPath == null) {
                httpNetReq.mTempPath = httpNetReq.mOutPath + "." + MD5.toMD5(TransFileUtil.getUrlResoursePath(httpNetReq.mReqUrl, false)) + ".tmp";
            }
            iQuicEngine.execute(builder.addHeader("Accept-Encoding", "identity").tempPath(httpNetReq.mTempPath).timeOut(new TimeoutParam().getReadTimeout(NetworkCenter.getInstance().getNetType())).businessId(2).isIpv6(serverAddr.isIpv6).rttHost(QuicNetReport.RTT_HOST).listener(this.mQuicDownloadListener).build());
            return;
        }
        handleQuicFail(1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void receiveFile(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            receiveFile(z16, false);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, z16);
        }
    }

    public BasePicDownloadProcessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        this.mSSORequestReason = 0;
        this.mDirectDownFailReason = "";
        this.mIpFromInnerDns = false;
        this.failIpReported = new ArrayList<>();
        this.mAvifReportInfo = new HashMap<>();
        this.mAvifDelayCost = 0L;
        this.mEncryptPic = false;
        this.mEncryptUrl = false;
        this.mPicEncryptRollback = false;
        this.decryptConsumeTime = 0L;
    }

    void sendRequest() {
    }
}
