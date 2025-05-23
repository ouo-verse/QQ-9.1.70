package com.tencent.bugly.common.reporter.upload;

import android.net.http.Headers;
import com.tencent.bugly.common.network.NetworkWatcher;
import com.tencent.bugly.common.reporter.IReporter;
import com.tencent.bugly.common.reporter.data.AttachmentInfo;
import com.tencent.bugly.common.reporter.data.ReportData;
import com.tencent.bugly.common.reporter.link.PluginLinkDataProxy;
import com.tencent.bugly.common.reporter.upload.UploadEncrypt;
import com.tencent.component.network.downloader.impl.ipc.Const;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.weiyun.transmission.db.JobDbManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 (2\u00020\u0001:\u0001(B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ4\u0010\r\u001a\u00020\u000e2\"\u0010\u000f\u001a\u001e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00110\u0010j\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0011`\u00122\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0015H\u0002J\u0010\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u0002J\b\u0010\u001b\u001a\u00020\u0011H\u0002J\b\u0010\u001c\u001a\u00020\u0011H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u000eH\u0016J\b\u0010 \u001a\u00020\u000eH\u0002J\u001a\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002J\u0018\u0010%\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020'2\u0006\u0010\u0013\u001a\u00020\u0011H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006)"}, d2 = {"Lcom/tencent/bugly/common/reporter/upload/FileUploadRunnable;", "Lcom/tencent/bugly/common/reporter/upload/ReporterUpload;", "url", "Ljava/net/URL;", "reportData", "Lcom/tencent/bugly/common/reporter/data/ReportData;", "callback", "Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;", "(Ljava/net/URL;Lcom/tencent/bugly/common/reporter/data/ReportData;Lcom/tencent/bugly/common/reporter/IReporter$ReportCallback;)V", "buffer", "Ljava/lang/StringBuffer;", "uploadFile", "Ljava/io/File;", "buildHeader", "", "headers", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "encryptKey", "checkUploadAttachment", "", "checkUploadFile", "generateBoundary", "isEndBoundary", "generateContentDispositionForFile", WadlProxyConsts.PARAM_FILENAME, "generateContentDispositionForJson", "generateEmptyLine", "generateJsonContent", "", Const.BUNDLE_KEY_REQUEST, "requestInternal", JobDbManager.TBL_UPLOAD, "", Headers.CONN_DIRECTIVE, "Ljava/net/HttpURLConnection;", "writeBody", "dataOutputStream", "Ljava/io/DataOutputStream;", "Companion", "bugly-common_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes5.dex */
public final class FileUploadRunnable extends ReporterUpload {
    private static final String BOUNDARY = "27182818284590452353602874713526";
    private static final String TAG = "RMonitor_report_File";
    private final StringBuffer buffer;
    private File uploadFile;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileUploadRunnable(@NotNull URL url, @NotNull ReportData reportData, @Nullable IReporter.ReportCallback reportCallback) {
        super(url, reportData, reportCallback);
        Intrinsics.checkParameterIsNotNull(url, "url");
        Intrinsics.checkParameterIsNotNull(reportData, "reportData");
        this.buffer = new StringBuffer(512);
    }

    private final void buildHeader(HashMap<String, String> headers, String encryptKey) {
        headers.put("Content-Type", "multipart/form-data; boundary=27182818284590452353602874713526");
        headers.put("Content-Encoding", "encrypt");
        headers.put("X-ENCRYPTION-KEY", encryptKey);
        headers.put("X-ENCRYPTION-VERSION", UploadEncrypt.INSTANCE.getEncryptVersion());
    }

    private final boolean checkUploadAttachment() {
        if (getReportData().getAttachmentInfo() != null) {
            return true;
        }
        return false;
    }

    private final boolean checkUploadFile() {
        boolean z16;
        String uploadFilePath = getReportData().getUploadFilePath();
        if (uploadFilePath.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            return false;
        }
        File file = new File(uploadFilePath);
        this.uploadFile = file;
        if (file.exists()) {
            return true;
        }
        return false;
    }

    private final String generateBoundary(boolean isEndBoundary) {
        StringBuffer stringBuffer = this.buffer;
        stringBuffer.delete(0, stringBuffer.length());
        if (isEndBoundary) {
            StringBuffer stringBuffer2 = this.buffer;
            stringBuffer2.append("--");
            stringBuffer2.append(BOUNDARY);
            stringBuffer2.append("--\r\n");
        } else {
            StringBuffer stringBuffer3 = this.buffer;
            stringBuffer3.append("--");
            stringBuffer3.append(BOUNDARY);
            stringBuffer3.append("\r\n");
        }
        String stringBuffer4 = this.buffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer4, "buffer.toString()");
        return stringBuffer4;
    }

    private final String generateContentDispositionForFile(String fileName) {
        StringBuffer stringBuffer = this.buffer;
        stringBuffer.delete(0, stringBuffer.length());
        if (getReportData().getReportType() == 1) {
            this.buffer.append("Content-Disposition: form-data; name=\"_file\"; filename=\"" + fileName + "\"\r\n");
        }
        String stringBuffer2 = this.buffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }

    private final String generateContentDispositionForJson() {
        StringBuffer stringBuffer = this.buffer;
        stringBuffer.delete(0, stringBuffer.length());
        this.buffer.append("Content-Disposition: form-data; name=\"_json\"\r\n");
        String stringBuffer2 = this.buffer.toString();
        Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "buffer.toString()");
        return stringBuffer2;
    }

    private final String generateEmptyLine() {
        return "\r\n";
    }

    private final byte[] generateJsonContent(String encryptKey) {
        StringBuffer stringBuffer = this.buffer;
        stringBuffer.delete(0, stringBuffer.length());
        this.buffer.append(getReportData().getParams().toString());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            String stringBuffer2 = this.buffer.toString();
            Intrinsics.checkExpressionValueIsNotNull(stringBuffer2, "buffer.toString()");
            Charset forName = Charset.forName("utf-8");
            Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
            if (stringBuffer2 != null) {
                byte[] bytes = stringBuffer2.getBytes(forName);
                Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                byteArrayOutputStream.write(bytes);
                UploadEncrypt.Companion companion = UploadEncrypt.INSTANCE;
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                Intrinsics.checkExpressionValueIsNotNull(byteArray, "outputStream.toByteArray()");
                byte[] doUploadEncrypt = companion.doUploadEncrypt(byteArray, encryptKey);
                CloseableKt.closeFinally(byteArrayOutputStream, null);
                return doUploadEncrypt;
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        } catch (Throwable th5) {
            try {
                throw th5;
            } catch (Throwable th6) {
                CloseableKt.closeFinally(byteArrayOutputStream, th5);
                throw th6;
            }
        }
    }

    private final void requestInternal() {
        String str;
        String str2 = "";
        HashMap<String, String> hashMap = new HashMap<>();
        String createEncryptKey = UploadEncrypt.INSTANCE.createEncryptKey();
        buildHeader(hashMap, createEncryptKey);
        if (getReportData().getParams() != null && getReportData().getParams().has("sub_type")) {
            Logger.f365497g.i(TAG, "url: " + getUrl() + ", sub_type: " + getReportData().getParams().get("sub_type"));
        }
        HttpURLConnection connectionBuilder = connectionBuilder(hashMap, getReportData().getReportStrategy().getConnectTimeout(), getReportData().getReportStrategy().getReadTimeout());
        try {
            try {
                try {
                    try {
                        upload(connectionBuilder, createEncryptKey);
                        if (connectionBuilder == null) {
                            return;
                        }
                    } catch (FileNotFoundException e16) {
                        Logger logger = Logger.f365497g;
                        String[] strArr = new String[2];
                        strArr[0] = TAG;
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(e16);
                        sb5.append(MsgSummary.STR_COLON);
                        File file = this.uploadFile;
                        if (file != null) {
                            str = file.getPath();
                        } else {
                            str = null;
                        }
                        sb5.append(str);
                        sb5.append(" not found");
                        strArr[1] = sb5.toString();
                        logger.e(strArr);
                        IReporter.ReportCallback callback = getCallback();
                        if (callback != null) {
                            callback.onFailure(601, "FileNotFoundError", getReportData().getDbId(), 0);
                        }
                        if (connectionBuilder == null) {
                            return;
                        }
                    } catch (Exception e17) {
                        Logger.f365497g.e(TAG, e17.toString());
                        IReporter.ReportCallback callback2 = getCallback();
                        if (callback2 != null) {
                            String message = e17.getMessage();
                            if (message != null) {
                                str2 = message;
                            }
                            callback2.onFailure(603, str2, getReportData().getDbId(), 0);
                        }
                        if (connectionBuilder == null) {
                            return;
                        }
                    }
                } catch (OutOfMemoryError unused) {
                    IReporter.ReportCallback callback3 = getCallback();
                    if (callback3 != null) {
                        callback3.onFailure(600, "OutOfMemoryError", 0, 0);
                    }
                    if (connectionBuilder == null) {
                        return;
                    }
                }
            } catch (Throwable th5) {
                Logger.f365497g.e(TAG, th5.toString());
                IReporter.ReportCallback callback4 = getCallback();
                if (callback4 != null) {
                    String message2 = th5.getMessage();
                    if (message2 != null) {
                        str2 = message2;
                    }
                    callback4.onFailure(700, str2, getReportData().getDbId(), 0);
                }
                if (connectionBuilder == null) {
                    return;
                }
            }
            connectionBuilder.disconnect();
        } catch (Throwable th6) {
            if (connectionBuilder != null) {
                connectionBuilder.disconnect();
            }
            throw th6;
        }
    }

    private final int upload(HttpURLConnection connection, String encryptKey) {
        if (connection != null) {
            DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream());
            try {
                writeBody(dataOutputStream, encryptKey);
                int size = dataOutputStream.size();
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(dataOutputStream, null);
                dealResp(readResp(TAG, connection), connection.getResponseCode(), size);
                return size;
            } catch (Throwable th5) {
                try {
                    throw th5;
                } catch (Throwable th6) {
                    CloseableKt.closeFinally(dataOutputStream, th5);
                    throw th6;
                }
            }
        }
        return 0;
    }

    private final void writeBody(DataOutputStream dataOutputStream, String encryptKey) {
        if (getReportData().getAttachmentInfo() != null) {
            AttachmentInfo attachmentInfo = getReportData().getAttachmentInfo();
            if (attachmentInfo == null) {
                Intrinsics.throwNpe();
            }
            ArrayList<AttachmentInfo.Item> itemLists = attachmentInfo.getItemLists();
            Intrinsics.checkExpressionValueIsNotNull(itemLists, "reportData.getAttachment()!!.itemLists");
            for (AttachmentInfo.Item item : itemLists) {
                String generateBoundary = generateBoundary(false);
                Charset forName = Charset.forName("utf-8");
                Intrinsics.checkExpressionValueIsNotNull(forName, "Charset.forName(charsetName)");
                if (generateBoundary != null) {
                    byte[] bytes = generateBoundary.getBytes(forName);
                    Intrinsics.checkExpressionValueIsNotNull(bytes, "(this as java.lang.String).getBytes(charset)");
                    dataOutputStream.write(bytes);
                    String str = item.fileName;
                    Intrinsics.checkExpressionValueIsNotNull(str, "it.fileName");
                    String generateContentDispositionForFile = generateContentDispositionForFile(str);
                    Charset forName2 = Charset.forName("utf-8");
                    Intrinsics.checkExpressionValueIsNotNull(forName2, "Charset.forName(charsetName)");
                    if (generateContentDispositionForFile != null) {
                        byte[] bytes2 = generateContentDispositionForFile.getBytes(forName2);
                        Intrinsics.checkExpressionValueIsNotNull(bytes2, "(this as java.lang.String).getBytes(charset)");
                        dataOutputStream.write(bytes2);
                        String generateEmptyLine = generateEmptyLine();
                        Charset forName3 = Charset.forName("utf-8");
                        Intrinsics.checkExpressionValueIsNotNull(forName3, "Charset.forName(charsetName)");
                        if (generateEmptyLine != null) {
                            byte[] bytes3 = generateEmptyLine.getBytes(forName3);
                            Intrinsics.checkExpressionValueIsNotNull(bytes3, "(this as java.lang.String).getBytes(charset)");
                            dataOutputStream.write(bytes3);
                            dataOutputStream.write(item.data);
                            String generateEmptyLine2 = generateEmptyLine();
                            Charset forName4 = Charset.forName("utf-8");
                            Intrinsics.checkExpressionValueIsNotNull(forName4, "Charset.forName(charsetName)");
                            if (generateEmptyLine2 != null) {
                                byte[] bytes4 = generateEmptyLine2.getBytes(forName4);
                                Intrinsics.checkExpressionValueIsNotNull(bytes4, "(this as java.lang.String).getBytes(charset)");
                                dataOutputStream.write(bytes4);
                            } else {
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                        } else {
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                } else {
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
            }
            String generateBoundary2 = generateBoundary(false);
            Charset forName5 = Charset.forName("utf-8");
            Intrinsics.checkExpressionValueIsNotNull(forName5, "Charset.forName(charsetName)");
            if (generateBoundary2 != null) {
                byte[] bytes5 = generateBoundary2.getBytes(forName5);
                Intrinsics.checkExpressionValueIsNotNull(bytes5, "(this as java.lang.String).getBytes(charset)");
                dataOutputStream.write(bytes5);
                String generateContentDispositionForJson = generateContentDispositionForJson();
                Charset forName6 = Charset.forName("utf-8");
                Intrinsics.checkExpressionValueIsNotNull(forName6, "Charset.forName(charsetName)");
                if (generateContentDispositionForJson != null) {
                    byte[] bytes6 = generateContentDispositionForJson.getBytes(forName6);
                    Intrinsics.checkExpressionValueIsNotNull(bytes6, "(this as java.lang.String).getBytes(charset)");
                    dataOutputStream.write(bytes6);
                    String generateEmptyLine3 = generateEmptyLine();
                    Charset forName7 = Charset.forName("utf-8");
                    Intrinsics.checkExpressionValueIsNotNull(forName7, "Charset.forName(charsetName)");
                    if (generateEmptyLine3 != null) {
                        byte[] bytes7 = generateEmptyLine3.getBytes(forName7);
                        Intrinsics.checkExpressionValueIsNotNull(bytes7, "(this as java.lang.String).getBytes(charset)");
                        dataOutputStream.write(bytes7);
                        dataOutputStream.write(generateJsonContent(encryptKey));
                        Charset forName8 = Charset.forName("utf-8");
                        Intrinsics.checkExpressionValueIsNotNull(forName8, "Charset.forName(charsetName)");
                        byte[] bytes8 = "\r\n".getBytes(forName8);
                        Intrinsics.checkExpressionValueIsNotNull(bytes8, "(this as java.lang.String).getBytes(charset)");
                        dataOutputStream.write(bytes8);
                        String generateBoundary3 = generateBoundary(true);
                        Charset forName9 = Charset.forName("utf-8");
                        Intrinsics.checkExpressionValueIsNotNull(forName9, "Charset.forName(charsetName)");
                        if (generateBoundary3 != null) {
                            byte[] bytes9 = generateBoundary3.getBytes(forName9);
                            Intrinsics.checkExpressionValueIsNotNull(bytes9, "(this as java.lang.String).getBytes(charset)");
                            dataOutputStream.write(bytes9);
                            dataOutputStream.close();
                            return;
                        }
                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        if (this.uploadFile != null) {
            String generateBoundary4 = generateBoundary(false);
            Charset forName10 = Charset.forName("utf-8");
            Intrinsics.checkExpressionValueIsNotNull(forName10, "Charset.forName(charsetName)");
            if (generateBoundary4 != null) {
                byte[] bytes10 = generateBoundary4.getBytes(forName10);
                Intrinsics.checkExpressionValueIsNotNull(bytes10, "(this as java.lang.String).getBytes(charset)");
                dataOutputStream.write(bytes10);
                File file = this.uploadFile;
                if (file == null) {
                    Intrinsics.throwNpe();
                }
                String name = file.getName();
                Intrinsics.checkExpressionValueIsNotNull(name, "uploadFile!!.name");
                String generateContentDispositionForFile2 = generateContentDispositionForFile(name);
                Charset forName11 = Charset.forName("utf-8");
                Intrinsics.checkExpressionValueIsNotNull(forName11, "Charset.forName(charsetName)");
                if (generateContentDispositionForFile2 != null) {
                    byte[] bytes11 = generateContentDispositionForFile2.getBytes(forName11);
                    Intrinsics.checkExpressionValueIsNotNull(bytes11, "(this as java.lang.String).getBytes(charset)");
                    dataOutputStream.write(bytes11);
                    String generateEmptyLine4 = generateEmptyLine();
                    Charset forName12 = Charset.forName("utf-8");
                    Intrinsics.checkExpressionValueIsNotNull(forName12, "Charset.forName(charsetName)");
                    if (generateEmptyLine4 != null) {
                        byte[] bytes12 = generateEmptyLine4.getBytes(forName12);
                        Intrinsics.checkExpressionValueIsNotNull(bytes12, "(this as java.lang.String).getBytes(charset)");
                        dataOutputStream.write(bytes12);
                        FileInputStream fileInputStream = new FileInputStream(this.uploadFile);
                        try {
                            ByteStreamsKt.copyTo(fileInputStream, dataOutputStream, Math.min(fileInputStream.available(), 1048576));
                            CloseableKt.closeFinally(fileInputStream, null);
                            String generateEmptyLine5 = generateEmptyLine();
                            Charset forName13 = Charset.forName("utf-8");
                            Intrinsics.checkExpressionValueIsNotNull(forName13, "Charset.forName(charsetName)");
                            if (generateEmptyLine5 != null) {
                                byte[] bytes13 = generateEmptyLine5.getBytes(forName13);
                                Intrinsics.checkExpressionValueIsNotNull(bytes13, "(this as java.lang.String).getBytes(charset)");
                                dataOutputStream.write(bytes13);
                                String generateBoundary5 = generateBoundary(false);
                                Charset forName14 = Charset.forName("utf-8");
                                Intrinsics.checkExpressionValueIsNotNull(forName14, "Charset.forName(charsetName)");
                                if (generateBoundary5 != null) {
                                    byte[] bytes14 = generateBoundary5.getBytes(forName14);
                                    Intrinsics.checkExpressionValueIsNotNull(bytes14, "(this as java.lang.String).getBytes(charset)");
                                    dataOutputStream.write(bytes14);
                                    String generateContentDispositionForJson2 = generateContentDispositionForJson();
                                    Charset forName15 = Charset.forName("utf-8");
                                    Intrinsics.checkExpressionValueIsNotNull(forName15, "Charset.forName(charsetName)");
                                    if (generateContentDispositionForJson2 != null) {
                                        byte[] bytes15 = generateContentDispositionForJson2.getBytes(forName15);
                                        Intrinsics.checkExpressionValueIsNotNull(bytes15, "(this as java.lang.String).getBytes(charset)");
                                        dataOutputStream.write(bytes15);
                                        String generateEmptyLine6 = generateEmptyLine();
                                        Charset forName16 = Charset.forName("utf-8");
                                        Intrinsics.checkExpressionValueIsNotNull(forName16, "Charset.forName(charsetName)");
                                        if (generateEmptyLine6 != null) {
                                            byte[] bytes16 = generateEmptyLine6.getBytes(forName16);
                                            Intrinsics.checkExpressionValueIsNotNull(bytes16, "(this as java.lang.String).getBytes(charset)");
                                            dataOutputStream.write(bytes16);
                                            dataOutputStream.write(generateJsonContent(encryptKey));
                                            Charset forName17 = Charset.forName("utf-8");
                                            Intrinsics.checkExpressionValueIsNotNull(forName17, "Charset.forName(charsetName)");
                                            byte[] bytes17 = "\r\n".getBytes(forName17);
                                            Intrinsics.checkExpressionValueIsNotNull(bytes17, "(this as java.lang.String).getBytes(charset)");
                                            dataOutputStream.write(bytes17);
                                            String generateBoundary6 = generateBoundary(true);
                                            Charset forName18 = Charset.forName("utf-8");
                                            Intrinsics.checkExpressionValueIsNotNull(forName18, "Charset.forName(charsetName)");
                                            if (generateBoundary6 != null) {
                                                byte[] bytes18 = generateBoundary6.getBytes(forName18);
                                                Intrinsics.checkExpressionValueIsNotNull(bytes18, "(this as java.lang.String).getBytes(charset)");
                                                dataOutputStream.write(bytes18);
                                                dataOutputStream.close();
                                                return;
                                            }
                                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                        }
                                        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                    }
                                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                                }
                                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                            }
                            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                        } catch (Throwable th5) {
                            try {
                                throw th5;
                            } catch (Throwable th6) {
                                CloseableKt.closeFinally(fileInputStream, th5);
                                throw th6;
                            }
                        }
                    }
                    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
                }
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
    }

    @Override // com.tencent.bugly.common.reporter.upload.BaseUpload
    public void request() {
        if (whetherBlock()) {
            IReporter.ReportCallback callback = getCallback();
            if (callback != null) {
                callback.onSuccess(getReportData().getDbId(), 0);
                return;
            }
            return;
        }
        if (!NetworkWatcher.INSTANCE.isNetworkConnectedRealtime()) {
            IReporter.ReportCallback callback2 = getCallback();
            if (callback2 != null) {
                callback2.onFailure(602, "network not available", getReportData().getDbId(), 0);
                return;
            }
            return;
        }
        if (!checkUploadFile() && !checkUploadAttachment()) {
            IReporter.ReportCallback callback3 = getCallback();
            if (callback3 != null) {
                callback3.onFailure(601, "no upload content", getReportData().getDbId(), 0);
                return;
            }
            return;
        }
        PluginLinkDataProxy.getInstance().collectPluginLinkData(getReportData().getParams());
        requestInternal();
    }
}
