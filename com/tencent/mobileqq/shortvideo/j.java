package com.tencent.mobileqq.shortvideo;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.dpc.IDPCApiConstant;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.richmediavfs.RmVFSUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f288036a = false;

    /* renamed from: b, reason: collision with root package name */
    private static boolean f288037b = true;

    /* renamed from: c, reason: collision with root package name */
    public static String f288038c;

    public static String a(int i3) {
        if (i3 != 1007) {
            if (i3 != 2008) {
                if (i3 != 5001) {
                    if (i3 != 5002) {
                        switch (i3) {
                            case 999:
                                return " [STATUS_SEND_PREPARE] ";
                            case 1000:
                                return " [STATUS_SEND_REQUEST] ";
                            case 1001:
                                return " [STATUS_SEND_START] ";
                            case 1002:
                                return " [STATUS_SEND_PROCESS] ";
                            case 1003:
                                return " [STATUS_SEND_FINISHED] ";
                            case 1004:
                                return " [STATUS_SEND_CANCEL] ";
                            case 1005:
                                return " [STATUS_SEND_ERROR] ";
                            default:
                                switch (i3) {
                                    case 2000:
                                        return " [STATUS_RECV_REQUEST] ";
                                    case 2001:
                                        return " [STATUS_RECV_START] ";
                                    case 2002:
                                        return " [STATUS_RECV_PROCESS] ";
                                    case 2003:
                                        return " [STATUS_RECV_FINISHED] ";
                                    case 2004:
                                        return " [STATUS_RECV_CANCEL] ";
                                    case 2005:
                                        return " [STATUS_RECV_ERROR] ";
                                    default:
                                        return " [STATUS_UNKNOW " + i3 + "]";
                                }
                        }
                    }
                    return " [STATUS_FILE_EXPIRED] ";
                }
                return " [STATUS_FILE_UNSAFE] ";
            }
            return " [STATUS_RECV_PREPARED] ";
        }
        return " [STATUS_UPLOAD_FINISHED] ";
    }

    public static String b(int i3) {
        if (i3 != 6) {
            if (i3 != 7) {
                if (i3 != 9) {
                    if (i3 != 20) {
                        switch (i3) {
                            case 16:
                                return " [TYPE_VIDEO_THUMB_TROOP] ";
                            case 17:
                                return " [TYPE_VIDEO_DISUSS]";
                            case 18:
                                return " [TYPE_VIDEO_THUMB_DISUSS] ";
                            default:
                                return " [TYPE_NONE " + i3 + " ]";
                        }
                    }
                    return " [TYPE_VIDEO_FORWARD] ";
                }
                return " [TYPE_VIDEO_TROOP]";
            }
            return " [TYPE_VIDEO_THUMB_C2C] ";
        }
        return " [TYPE_VIDEO_C2C] ";
    }

    public static String c(MessageForShortVideo messageForShortVideo) {
        if (messageForShortVideo.isSend()) {
            return messageForShortVideo.selfuin;
        }
        int i3 = messageForShortVideo.istroop;
        if (i3 != 1 && i3 != 3000) {
            return messageForShortVideo.frienduin;
        }
        return messageForShortVideo.senderuin;
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x007f, code lost:
    
        r6.close();
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00a9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String d(File file) {
        FileInputStream fileInputStream;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        ByteBuffer allocate = ByteBuffer.allocate(8);
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            long j3 = 0;
            int i3 = 0;
            int i16 = 0;
            while (true) {
                int i17 = i3 + 1;
                if (i3 < 100) {
                    try {
                        try {
                            int read = fileInputStream.read(bArr);
                            if (read > 0) {
                                allocate.put(new byte[4]);
                                allocate.put(bArr);
                                allocate.flip();
                                j3 = allocate.getLong();
                                int read2 = read + fileInputStream.read(bArr2);
                                if (j3 == 1) {
                                    byte[] bArr3 = new byte[8];
                                    read2 += fileInputStream.read(bArr3);
                                    allocate.clear();
                                    allocate.put(bArr3);
                                    allocate.flip();
                                    j3 = allocate.getLong();
                                }
                                if (((char) bArr2[0]) == 'm' && ((char) bArr2[1]) == 'o' && ((char) bArr2[2]) == 'o' && ((char) bArr2[3]) == 'v') {
                                    break;
                                }
                                fileInputStream.skip(j3 - read2);
                                i16 = (int) (i16 + j3);
                                allocate.clear();
                                i3 = i17;
                            } else {
                                break;
                            }
                        } catch (Throwable th5) {
                            th = th5;
                            fileInputStream2 = fileInputStream;
                            if (fileInputStream2 != null) {
                                try {
                                    fileInputStream2.close();
                                } catch (Exception unused) {
                                }
                            }
                            throw th;
                        }
                    } catch (Exception e16) {
                        e = e16;
                        e.printStackTrace();
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                        }
                        return null;
                    }
                }
            }
            return i16 + "|" + j3;
        } catch (Exception e17) {
            e = e17;
            fileInputStream = null;
        } catch (Throwable th6) {
            th = th6;
            if (fileInputStream2 != null) {
            }
            throw th;
        }
    }

    public static String e() {
        if (f288038c == null) {
            f288038c = RmVFSUtils.getVFSPath(AppConstants.SDCARD_PATH);
        }
        return f288038c;
    }

    public static String f(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 4) {
                            return " shortvideo_cmd_unknow ";
                        }
                        return " shortvideo_cmd_reforward ";
                    }
                    return " shortvideo_cmd_forward ";
                }
                return " shortvideo_cmd_download ";
            }
            return " shortvideo_cmd_resend ";
        }
        return " shortvideo_cmd_send ";
    }

    public static String g(String str) {
        StringBuilder sb5 = new StringBuilder(e());
        sb5.append("shortvideo");
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append(str);
        sb5.append(str2);
        return sb5.toString();
    }

    public static String h() {
        return e() + "shortvideo" + File.separator;
    }

    public static String i(MessageForShortVideo messageForShortVideo) {
        return j(messageForShortVideo, "mp4");
    }

    public static String j(MessageForShortVideo messageForShortVideo, String str) {
        boolean z16;
        String str2;
        String n3 = n(messageForShortVideo, str);
        int i3 = messageForShortVideo.videoFileStatus;
        if (i3 != 1004 && i3 != 2004 && i3 != 5001 && i3 != 5002) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (messageForShortVideo.isSendFromLocal() && FileUtils.fileExistsAndNotEmpty(n3)) {
            z16 = false;
        }
        String g16 = g(messageForShortVideo.getMd5());
        File file = new File(g16);
        if (!file.exists()) {
            file.mkdirs();
            FileUtils.createFileIfNotExits(g16 + ".nomedia");
            return n3;
        }
        String[] list = file.list();
        if (list != null && list.length > 0) {
            for (String str3 : list) {
                if (!str3.endsWith(".tmp") && !str3.equals(".nomedia")) {
                    str2 = g16 + str3;
                    break;
                }
            }
        }
        str2 = null;
        if (z16 && str2 != null && !new File(n3).exists()) {
            long currentTimeMillis = System.currentTimeMillis();
            if (str2.equals(n3)) {
                return n3;
            }
            FileUtils.copyFile(str2, n3);
            if (QLog.isColorLevel()) {
                QLog.i("SVUtils", 2, "copy " + str2 + " to " + n3);
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            if (QLog.isColorLevel()) {
                QLog.d("SVUtils", 2, "getShortVideoSavePath-----time: = " + (currentTimeMillis2 - currentTimeMillis) + ", videoStatus:" + a(i3) + ", needCopy=" + z16);
            }
        }
        return n3;
    }

    public static String k() {
        StringBuilder sb5 = new StringBuilder(h());
        sb5.append("thumbs");
        sb5.append(File.separator);
        File file = new File(sb5.toString());
        if (!file.exists()) {
            file.mkdirs();
        }
        String str = sb5.toString() + ".nomedia";
        if (!new File(str).exists()) {
            FileUtils.createFileIfNotExits(str);
        }
        return sb5.toString();
    }

    public static String l(String str, String str2) {
        return k() + str + "." + str2;
    }

    public static boolean m() {
        if (!f288036a) {
            try {
                String featureValue = ((IDPCApi) QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.aio_config.name(), IDPCApiConstant.AIO_BLOCK_BROKEN_VIDEO);
                if (QLog.isColorLevel()) {
                    QLog.d("SVUtils", 2, "needBlockBrokenVideo:" + featureValue);
                }
                String[] split = featureValue.split("\\|");
                if (split.length > 5) {
                    f288037b = split[5].equals("1");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("SVUtils", 2, "needBlockBrokenVideo e:" + e16.toString());
                }
            }
            f288036a = true;
        }
        return f288037b;
    }

    public static String n(MessageForShortVideo messageForShortVideo, String str) {
        if (messageForShortVideo != null) {
            return g(messageForShortVideo.getMd5()) + messageForShortVideo.frienduin + Math.abs(messageForShortVideo.uniseq) + "." + str;
        }
        return "";
    }
}
