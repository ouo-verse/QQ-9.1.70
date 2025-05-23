package com.tencent.component.network.module.report;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.network.downloader.DownloadReport;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.handler.ReportHandler;
import com.tencent.component.network.module.base.QDLog;
import com.tencent.component.network.module.common.NetworkState;
import com.tencent.component.network.utils.StringUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Response;
import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpResponse;
import org.apache.http.NoHttpResponseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ConnectionPoolTimeoutException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ImageDownloadReporter implements ReportHandler {
    private static final String CONTENTTYPE_HTML = "text/html";
    private static final char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static String bytes2HexStr(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = digits;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return null;
    }

    public static int getRetCodeFrom(Throwable th5, int i3) {
        int i16;
        if (th5 == null) {
            return i3;
        }
        if (th5 instanceof ClientProtocolException) {
            return 8;
        }
        if (th5 instanceof SSLPeerUnverifiedException) {
            return 12;
        }
        if (th5 instanceof NoHttpResponseException) {
            return 11;
        }
        if (th5 instanceof UnknownHostException) {
            return 9;
        }
        if (th5 instanceof ConnectionPoolTimeoutException) {
            return 13;
        }
        if (th5 instanceof SSLHandshakeException) {
            return 15;
        }
        if (th5 instanceof ConnectTimeoutException) {
            return 10;
        }
        if (th5 instanceof IllegalStateException) {
            String stackTraceString = Log.getStackTraceString(th5);
            i16 = (stackTraceString == null || !stackTraceString.contains("Connection is not open")) ? 5 : 50007;
        } else {
            if (th5 instanceof SocketException) {
                return 6;
            }
            if (th5 instanceof SocketTimeoutException) {
                return 7;
            }
            if (th5 instanceof FileNotFoundException) {
                return 1;
            }
            if (th5 instanceof IOException) {
                String stackTraceString2 = Log.getStackTraceString(th5);
                if (stackTraceString2 != null && stackTraceString2.contains("No space left on device")) {
                    i16 = 50003;
                } else if (stackTraceString2 != null && stackTraceString2.contains("Network is unreachable")) {
                    i16 = 50004;
                } else if (stackTraceString2 == null || !stackTraceString2.contains("No route to host")) {
                    i16 = (stackTraceString2 == null || !stackTraceString2.contains("Connection refused")) ? 2 : 50006;
                } else {
                    i16 = 50005;
                }
            } else {
                if (th5 instanceof Exception) {
                    return 4;
                }
                if (th5 instanceof OutOfMemoryError) {
                    return 3;
                }
                return i3;
            }
        }
        return i16;
    }

    private static byte[] readFromFile(File file, long j3, int i3) {
        RandomAccessFile randomAccessFile;
        byte[] bArr = null;
        if (file != null && file.exists() && file.isFile()) {
            long length = file.length();
            if (j3 < 0) {
                j3 = 0;
            }
            if (j3 < length && i3 > 0) {
                int min = Math.min(i3, (int) (length - j3));
                try {
                    byte[] bArr2 = new byte[min];
                    randomAccessFile = new RandomAccessFile(file, "r");
                    try {
                        randomAccessFile.seek(j3);
                        int read = randomAccessFile.read(bArr2);
                        if (read > 0) {
                            if (read < min) {
                                byte[] bArr3 = new byte[read];
                                System.arraycopy(bArr2, 0, bArr3, 0, read);
                                bArr = bArr3;
                            } else {
                                bArr = bArr2;
                            }
                        }
                        try {
                            randomAccessFile.close();
                        } catch (IOException unused) {
                        }
                        return bArr;
                    } catch (Throwable unused2) {
                        if (randomAccessFile != null) {
                            try {
                                randomAccessFile.close();
                            } catch (IOException unused3) {
                            }
                        }
                        return null;
                    }
                } catch (Throwable unused4) {
                    randomAccessFile = null;
                }
            }
        }
        return null;
    }

    public boolean handleContentType(DownloadResult downloadResult, HttpResponse httpResponse) {
        String str = downloadResult.getContent().type;
        if (!TextUtils.isEmpty(str) && StringUtil.startsWithIgnoreCase(str, "text/html")) {
            InputStream inputStream = null;
            try {
                try {
                    try {
                        inputStream = httpResponse.getEntity().getContent();
                        byte[] bArr = new byte[1024];
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            downloadResult.getContent().content = new String(bArr, 0, read);
                        }
                        inputStream.close();
                    } catch (Throwable th5) {
                        if (inputStream != null) {
                            try {
                                inputStream.close();
                            } catch (IOException e16) {
                                QDLog.w("ImageDownloader", "", e16);
                            }
                        }
                        throw th5;
                    }
                } catch (IOException e17) {
                    QDLog.w("ImageDownloadReporter", "handleContentType", e17);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
            } catch (IOException e18) {
                QDLog.w("ImageDownloader", "", e18);
            }
        }
        return false;
    }

    @Override // com.tencent.component.network.downloader.handler.ReportHandler
    public void handleReport(DownloadResult downloadResult, DownloadReport downloadReport) {
        uploadReport(obtainReportObj(downloadResult, downloadReport));
    }

    @Override // com.tencent.component.network.downloader.handler.ReportHandler
    public ReportHandler.DownloadReportObject obtainReportObj(DownloadResult downloadResult, DownloadReport downloadReport) {
        ReportHandler.DownloadReportObject downloadReportObject = new ReportHandler.DownloadReportObject();
        downloadReportObject.init();
        downloadReportObject.setUrl(downloadReport.url);
        downloadReportObject.fileSize = downloadReport.fileSize;
        long j3 = downloadReport.startTime;
        downloadReportObject.startTime = j3;
        long j16 = downloadReport.endTime;
        downloadReportObject.endTime = j16;
        downloadReportObject.elapse = j16 - j3;
        downloadReportObject.flow = downloadReport.f99895id;
        downloadReportObject.networkType = NetworkState.g().getNetworkType();
        downloadReportObject.serverIp = downloadReport.remoteAddress;
        downloadReportObject.dnsIp = downloadReport.dns;
        downloadReportObject.retry = downloadReport.currAttempCount;
        downloadReportObject.strategyInfo = downloadReport.strategyInfo;
        downloadReportObject.clientip = downloadReport.clientip;
        downloadReportObject.totaltime = downloadReport.totaltime;
        downloadReportObject.downloadTime = downloadReport.downloadTime;
        downloadReportObject.t_wait = downloadReport.t_wait;
        downloadReportObject.t_prepare = downloadReport.t_prepare;
        downloadReportObject.t_conn = downloadReport.t_conn;
        downloadReportObject.t_recvrsp = downloadReport.t_recvrsp;
        downloadReportObject.t_recvdata = downloadReport.t_recvdata;
        downloadReportObject.t_process = downloadReport.t_process;
        downloadReportObject.content_type = downloadReport.content_type;
        downloadReportObject.concurrent = downloadReport.concurrent;
        downloadReportObject.refer = downloadReport.refer;
        downloadReportObject.f99898t = downloadReport.exception;
        downloadReportObject.logInfo = downloadReport.logInfo;
        downloadReportObject.isFromQzoneAlbum = downloadReport.isFromQzoneAlbum;
        downloadReportObject.isHttp2 = downloadReport.isHttp2;
        downloadReportObject.isSucceed = downloadReport.isSucceed;
        downloadReportObject.domain = downloadReport.domain;
        downloadReportObject.strategyId = downloadReport.strategyId;
        if (downloadResult.getStatus().isSucceed()) {
            if (downloadResult.getContent().noCache) {
                int retCodeFrom = getRetCodeFrom(downloadReport.response, downloadReport.okResponse, 0);
                downloadReportObject.retCode = retCodeFrom;
                if (retCodeFrom == 0) {
                    downloadReportObject.retCode = -2;
                }
            } else if (downloadResult.getContent().size != downloadResult.getContent().length && !downloadResult.getContent().isGzip) {
                downloadReportObject.retCode = 50008;
                downloadReportObject.errMsg.append(";content-length:" + downloadResult.getContent().length + ";actual-size:" + downloadResult.getContent().size);
                File file = new File(downloadResult.getPath());
                String bytes2HexStr = bytes2HexStr(readFromFile(file, 0L, 1024));
                String bytes2HexStr2 = bytes2HexStr(readFromFile(file, file.length() - 1024, 1024));
                downloadReportObject.errMsg.append(";head-content:" + bytes2HexStr);
                downloadReportObject.errMsg.append(";tail-content:" + bytes2HexStr2);
            } else if (downloadResult.getContent().realsize > 0 && downloadResult.getContent().realsize != downloadResult.getContent().length) {
                downloadReportObject.retCode = 50002;
                downloadReportObject.errMsg.append(";content-length:" + downloadResult.getContent().length + ";real-size:" + downloadResult.getContent().realsize);
            } else {
                downloadReportObject.retCode = 0;
            }
        } else {
            downloadReportObject.errMsg.append("httpStatus:" + downloadReport.httpStatus + "; ");
            Throwable th5 = downloadReport.exception;
            if (th5 != null) {
                downloadReportObject.retCode = getRetCodeFrom(th5, downloadReportObject.retCode);
                downloadReportObject.errMsg.append(Log.getStackTraceString(downloadReport.exception));
            } else if (downloadResult.getStatus().getFailReason() == 5) {
                downloadReportObject.retCode = -1;
                downloadReportObject.errMsg.append("content-type:" + downloadResult.getContent().type + "; data:" + downloadResult.getContent().content + "; ");
            } else if (downloadReport.response == null) {
                downloadReportObject.retCode = -99997;
            } else {
                downloadReportObject.retCode = downloadReport.httpStatus;
            }
        }
        return downloadReportObject;
    }

    @Override // com.tencent.component.network.downloader.handler.ReportHandler
    public void uploadReport(ReportHandler.DownloadReportObject downloadReportObject) {
        if (downloadReportObject == null) {
            return;
        }
        BusinessReport.uploadReport(downloadReportObject, downloadReportObject.appIdType, 1);
    }

    private int getRetCodeFrom(HttpResponse httpResponse, Response response, int i3) {
        List<String> headers;
        if (httpResponse != null) {
            HeaderIterator headerIterator = httpResponse.headerIterator("Retcode");
            if (headerIterator == null) {
                return i3;
            }
            while (headerIterator.hasNext()) {
                Header nextHeader = headerIterator.nextHeader();
                if (nextHeader != null) {
                    try {
                        return Integer.parseInt(nextHeader.getValue());
                    } catch (NumberFormatException e16) {
                        QDLog.w("ImageDownload", "getRetCodeFrom", e16);
                    }
                }
            }
            return i3;
        }
        if (response == null || (headers = response.headers("Retcode")) == null) {
            return i3;
        }
        for (String str : headers) {
            if (str != null) {
                try {
                    return Integer.parseInt(str);
                } catch (NumberFormatException e17) {
                    QDLog.w("ImageDownload", "getRetCodeFrom", e17);
                }
            }
        }
        return i3;
    }
}
