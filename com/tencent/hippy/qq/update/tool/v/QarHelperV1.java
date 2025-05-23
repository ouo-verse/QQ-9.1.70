package com.tencent.hippy.qq.update.tool.v;

import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipEntry;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipFile;
import com.tencent.hippy.qq.update.qarchive.tools.zip.ZipOutputStream;
import com.tencent.hippy.qq.update.tool.ExtensionFiled;
import com.tencent.hippy.qq.update.tool.QarBody;
import com.tencent.hippy.qq.update.tool.QarHeader;
import com.tencent.hippy.qq.update.tool.QarHelper;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QarHelperV1 extends QarHelper {
    static long createTime = System.currentTimeMillis();

    public static String byteToHexString(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
            for (int i3 = 0; i3 < bArr.length; i3++) {
                if ((bArr[i3] & 255) < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Long.toString(bArr[i3] & 255, 16));
            }
            return stringBuffer.toString();
        }
        return null;
    }

    private boolean checkQAR(QarHeader qarHeader) {
        if (VersionConfiguration.isQBDAvalible(qarHeader.version) && qarHeader.isQBDAvabile()) {
            return true;
        }
        return false;
    }

    private void readFullBody(BufferedInputStream bufferedInputStream, ZipOutputStream zipOutputStream) throws Exception {
        long j3;
        while (bufferedInputStream.available() > 0) {
            QarBody readBody = this.proxyBody.readBody(bufferedInputStream);
            ZipEntry zipEntry = new ZipEntry(readBody.fileName);
            int i3 = readBody.method;
            if (i3 == 0) {
                zipOutputStream.setMethod(0);
                zipEntry.setCrc(readBody.crc);
            } else {
                zipOutputStream.setMethod(i3);
            }
            zipEntry.setSize(readBody.fileLength);
            zipEntry.setTime(createTime);
            zipOutputStream.putNextEntry(zipEntry);
            if (readBody.type == 1) {
                long j16 = 0;
                while (true) {
                    long j17 = 32768 + j16;
                    j3 = readBody.fileLength;
                    if (j17 >= j3) {
                        break;
                    }
                    bufferedInputStream.read(VersionConfiguration.BYTE_BUFFER);
                    zipOutputStream.write(VersionConfiguration.BYTE_BUFFER, 0, 32768);
                    j16 = j17;
                }
                int i16 = (int) (j3 - j16);
                byte[] bArr = new byte[i16];
                bufferedInputStream.read(bArr);
                zipOutputStream.write(bArr, 0, i16);
            }
            this.checkSum.put(readBody.fileName, Long.valueOf(readBody.crc));
        }
    }

    @Override // com.tencent.hippy.qq.update.tool.QarHelper
    protected List<ExtensionFiled> addExBody(QarBody qarBody) {
        List<String> list = this.uncompressFiles;
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.uncompressFiles) {
                ExtensionFiled extensionFiled = new ExtensionFiled();
                extensionFiled.setEx(ExtensionFiled.DEFAULT_KEY_UNCOMPRESS, str);
                arrayList.add(extensionFiled);
            }
            return arrayList;
        }
        return null;
    }

    @Override // com.tencent.hippy.qq.update.tool.QarHelper
    protected List<ExtensionFiled> addExHeader(QarHeader qarHeader) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.hippy.qq.update.tool.QarHelper
    public String getQarMd5(File file) {
        MessageDigest messageDigest;
        boolean z16;
        try {
            messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
        } catch (NoSuchAlgorithmException e16) {
            e16.printStackTrace();
            messageDigest = null;
        }
        if (messageDigest == null) {
            return "";
        }
        try {
            ZipFile zipFile = new ZipFile(file, "utf-8");
            md5Header(messageDigest);
            Enumeration<ZipEntry> entriesInPhysicalOrder = zipFile.getEntriesInPhysicalOrder();
            while (entriesInPhysicalOrder.hasMoreElements()) {
                ZipEntry nextElement = entriesInPhysicalOrder.nextElement();
                if (!nextElement.getName().contains("../")) {
                    if (nextElement.isDirectory()) {
                        md5Body(messageDigest, nextElement, 2);
                    } else {
                        List<String> list = this.exceptFiles;
                        if (list != null) {
                            Iterator<String> it = list.iterator();
                            while (true) {
                                if (it.hasNext()) {
                                    if (nextElement.getName().startsWith(it.next())) {
                                        z16 = true;
                                        break;
                                    }
                                } else {
                                    z16 = false;
                                    break;
                                }
                            }
                            if (z16) {
                            }
                        }
                        md5Body(messageDigest, nextElement, 1);
                        InputStream inputStream = zipFile.getInputStream(nextElement);
                        md5BodyData(messageDigest, inputStream, VersionConfiguration.BYTE_BUFFER);
                        inputStream.close();
                    }
                }
            }
            String byteToHexString = byteToHexString(messageDigest.digest());
            zipFile.close();
            return byteToHexString;
        } catch (Exception e17) {
            e17.printStackTrace();
            return "";
        }
    }

    @Override // com.tencent.hippy.qq.update.tool.QarHelper
    public boolean read(String str, String str2) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(str)));
            this.proxyHeader.readHeader(bufferedInputStream);
            if (!checkQAR(this.proxyHeader)) {
                PrintStream printStream = System.out;
                StringBuilder sb5 = new StringBuilder();
                sb5.append("YorkeLi:  Header not suport|qar:");
                sb5.append(this.proxyHeader.qarMark);
                sb5.append("|");
                sb5.append(this.proxyHeader.version);
                sb5.append("|but:");
                sb5.append(VersionConfiguration.CURRENT_VERSION);
                sb5.append("|");
                Objects.requireNonNull(this.proxyHeader);
                sb5.append(1233211);
                printStream.print(sb5.toString());
                return false;
            }
            ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(str2));
            zipOutputStream.setLevel(3);
            zipOutputStream.setEncoding("utf-8");
            readFullBody(bufferedInputStream, zipOutputStream);
            zipOutputStream.close();
            bufferedInputStream.close();
            boolean checkSum = checkSum(str2);
            this.checkSum.clear();
            if (!checkSum) {
                return false;
            }
            return true;
        } catch (FileNotFoundException e16) {
            e16.printStackTrace();
            return false;
        } catch (Exception e17) {
            e17.printStackTrace();
            return false;
        }
    }

    @Override // com.tencent.hippy.qq.update.tool.QarHelper
    public boolean write(File file, File file2) {
        boolean z16;
        try {
            ZipFile zipFile = new ZipFile(file, "utf-8");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
            writeHeader(bufferedOutputStream);
            Enumeration<ZipEntry> entriesInPhysicalOrder = zipFile.getEntriesInPhysicalOrder();
            while (entriesInPhysicalOrder.hasMoreElements()) {
                ZipEntry nextElement = entriesInPhysicalOrder.nextElement();
                if (!nextElement.getName().contains("../")) {
                    List<String> list = this.exceptFiles;
                    if (list != null) {
                        Iterator<String> it = list.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (nextElement.getName().startsWith(it.next())) {
                                    System.out.println(nextElement.getName());
                                    z16 = true;
                                    break;
                                }
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (z16) {
                        }
                    }
                    if (nextElement.isDirectory()) {
                        writeBody(bufferedOutputStream, nextElement, 2);
                    } else {
                        writeBody(bufferedOutputStream, nextElement, 1);
                        InputStream inputStream = zipFile.getInputStream(nextElement);
                        writeBodyData(bufferedOutputStream, inputStream, VersionConfiguration.BYTE_BUFFER);
                        inputStream.close();
                    }
                }
            }
            bufferedOutputStream.close();
            zipFile.close();
            File file3 = new File(file2.getAbsolutePath());
            if (!file3.exists() || file3.length() <= 0) {
                return false;
            }
            return true;
        } catch (Exception e16) {
            e16.printStackTrace();
            return false;
        }
    }
}
