package com.tencent.gcloud.apkchannel;

import android.util.Log;
import com.tencent.gcloud.apkchannel.v1.ZipEocdCommentTool;
import com.tencent.gcloud.apkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.gcloud.apkchannel.v2.ApkSignatureV2ChannelTool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ApkChannelUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String CHANNELID = "channelId";
    public static final int CHANNEL_ID_WHITE_LIST_END = 89999999;
    public static final int CHANNEL_ID_WHITE_LIST_START = 89900000;
    public static final int OFFICIAL_CHANNEL_ID_WHITE_LIST_END = 79999999;
    public static final int OFFICIAL_CHANNEL_ID_WHITE_LIST_START = 79900000;
    public static final String TAG = "ApkChannelUtil";

    public ApkChannelUtil() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void clearChannel(String str) throws Exception {
        clearKeyValuePair(str);
    }

    private static void clearKeyValuePair(String str) throws Exception {
        ZipEocdCommentTool.clearComment(str);
    }

    public static long getCDFHOffset(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.readCDFHOffset(str);
            Log.i("ApkChannelUtil", "getCDFHOffset offset:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    public static long getCDFHSize(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.readCDFHSize(str);
            Log.i("ApkChannelUtil", "getCDFHSize size:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    public static long getEOCDOffset(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.readEOCDOffset(str);
            Log.i("ApkChannelUtil", "getEOCDOffset offset:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    public static long getEOCDSize(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.readEOCDSize(str);
            Log.i("ApkChannelUtil", "getEOCDSize size:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    private static int getV2ChannelBlockId(String str) throws IOException {
        try {
            return ApkSignatureV2ChannelTool.getApkCurChannelId(str);
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    private static String getV2ChannelBlockValue(String str) throws IOException {
        byte[] bArr;
        Log.i("ApkChannelUtil", "apollo0511 getV2ChannelBlockValue apkFilePath:" + str);
        try {
            bArr = ApkSignatureV2ChannelTool.getApkCurChannelValue(str);
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        try {
            return new ChannelComment().getValue(bArr);
        } catch (ProtocolException e17) {
            e17.printStackTrace();
            return null;
        }
    }

    public static int getV2ChannelId(String str) throws IOException {
        try {
            Log.i("ApkChannelUtil", "getV2ChannelId apkFilePath:" + str);
            return getV2ChannelBlockId(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("ApkChannelUtil", "getV2ChannelId exception!");
            return -1;
        }
    }

    public static long getV2ChannelOffset(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.readCommentOffset(str);
            Log.i("ApkChannelUtil", "getV2ChannelOffset offset:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    public static long getV2ChannelSize(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.readCommentSize(str);
            Log.i("ApkChannelUtil", "getV2ChannelSize size:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    public static String getV2ChannelValue(String str) throws IOException {
        try {
            Log.i("ApkChannelUtil", "getV2ChannelValue apkFilePath:" + str);
            return getV2ChannelBlockValue(str);
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("ApkChannelUtil", "getV2ChannelValue exception!");
            return null;
        }
    }

    public static long getV2SignBlockOffset(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.getSignBlockOffset(str);
            Log.i("ApkChannelUtil", "getV2SignBlockOffset offset:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    public static long getV2SignBlockSize(String str) {
        long j3 = 0;
        try {
            j3 = ApkSignatureV2ChannelTool.getSignBlockSize(str);
            Log.i("ApkChannelUtil", "getV2SignBlockSize size:" + j3);
            return j3;
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
            e16.printStackTrace();
            return j3;
        } catch (IOException e17) {
            e17.printStackTrace();
            return j3;
        }
    }

    public static int isSignatureV2Apk(String str) {
        try {
            boolean isSignatureV2Apk = ApkSignatureV2ChannelTool.isSignatureV2Apk(str);
            Log.i("ApkChannelUtil", "isSignatureV2Apk ret:" + isSignatureV2Apk);
            if (isSignatureV2Apk) {
                return 1;
            }
            return 0;
        } catch (IOException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public static String readChannel(String str) throws IOException {
        try {
            ChannelComment readChannelComment = readChannelComment(str);
            if (readChannelComment == null) {
                return null;
            }
            return readChannelComment.f108391p.getProperty("channelId");
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    private static ChannelComment readChannelComment(String str) throws IOException {
        byte[] readComment;
        try {
            readComment = ApkSignatureV2ChannelTool.readYYBComment(str);
        } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException unused) {
            readComment = ZipEocdCommentTool.readComment(str);
        }
        if (readComment == null) {
            return null;
        }
        ChannelComment channelComment = new ChannelComment();
        try {
            channelComment.decode(readComment);
            return channelComment;
        } catch (ProtocolException e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static void updateChannel(String str, String str2) throws Exception {
        updateKeyValuePair(str, "channelId", str2);
    }

    private static boolean updateKeyValueBlock(int i3, String str, String str2) throws Exception {
        if (i3 <= 0 || str == null || str.equals("")) {
            return false;
        }
        ChannelComment channelComment = new ChannelComment();
        if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
            ApkSignatureV2ChannelTool.updateChannInfoBlock(str2, i3, channelComment.encode(str));
            return true;
        }
        return true;
    }

    private static void updateKeyValuePair(String str, String str2, String str3) throws Exception {
        ChannelComment readChannelComment = readChannelComment(str);
        if (readChannelComment == null) {
            readChannelComment = new ChannelComment();
        }
        readChannelComment.f108391p.setProperty(str2, str3);
        if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str)) {
            ApkSignatureV2ChannelTool.updateYYBComment(str, readChannelComment.encode());
        } else {
            ZipEocdCommentTool.updateComment(str, readChannelComment.encode());
        }
    }

    public static boolean updateV2ChannelInfo(int i3, String str, String str2) throws Exception {
        try {
            Log.i("ApkChannelUtil", "updateV2ChannelInfo channelId:" + i3 + ",channelInfo:" + str + ",apkFilePath:" + str2);
            return updateKeyValueBlock(i3, str, str2);
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("ApkChannelUtil", "updateV2ChannelInfo exception!");
            return false;
        }
    }

    public static void writeOldCommentToNewFile(String str, String str2) throws Exception {
        ChannelComment readChannelComment = readChannelComment(str);
        if (readChannelComment != null) {
            if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
            } else {
                ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
            }
        }
    }

    public static void writeOldCommentToNewFileWithWhiteList(String str, String str2) throws Exception {
        int i3;
        try {
            ChannelComment readChannelComment = readChannelComment(str);
            if (readChannelComment == null) {
                Log.i("ApkChannelUtil", "Comment is null");
                return;
            }
            String readChannel = readChannel(str);
            if (readChannel == null) {
                Log.i("ApkChannelUtil", "old_apk_channel_value is null");
                return;
            }
            String readChannel2 = readChannel(str2);
            if (readChannel2 != null) {
                i3 = Integer.parseInt(readChannel2);
            } else {
                i3 = 0;
            }
            int parseInt = Integer.parseInt(readChannel);
            if (parseInt >= 79900000 && parseInt <= 89999999) {
                if (readChannel2 == null) {
                    Log.i("ApkChannelUtil", "old channel=" + parseInt + " new channel value is null");
                    if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                        Log.i("ApkChannelUtil", "use v2 signature");
                        ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                    } else {
                        Log.i("ApkChannelUtil", "use v1 signature");
                        ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                    }
                } else if (parseInt >= 79900000 && parseInt <= 79999999 && i3 >= 89900000 && i3 <= 89999999) {
                    Log.i("ApkChannelUtil", "old channel=" + parseInt + " new channel=" + i3);
                    if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                        Log.i("ApkChannelUtil", "use v2 signature");
                        ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                    } else {
                        Log.i("ApkChannelUtil", "use v1 signature");
                        ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                    }
                } else {
                    Log.i("ApkChannelUtil", "old channel=" + parseInt + " new channel=" + i3);
                    Log.i("ApkChannelUtil", "Don't need reWrite channel Value");
                }
            } else {
                Log.i("ApkChannelUtil", "value=" + parseInt);
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i("ApkChannelUtil", "use v2 signature");
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                } else {
                    Log.i("ApkChannelUtil", "use v1 signature");
                    ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                }
            }
            Log.i("ApkChannelUtil", "final_apk_channel_value=" + readChannel(str2));
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("ApkChannelUtil", "writeOldCommentToNewFileWithWhiteList exception!");
        }
    }

    public static int writeOldCommentToNewFileWithWhiteListRetunReWriteRes(String str, String str2) throws Exception {
        int parseInt;
        try {
            ChannelComment readChannelComment = readChannelComment(str);
            if (readChannelComment == null) {
                Log.i("ApkChannelUtil", "Comment is null");
                return 0;
            }
            String readChannel = readChannel(str);
            if (readChannel == null) {
                Log.i("ApkChannelUtil", "old_apk_channel_value is null");
                return 0;
            }
            String readChannel2 = readChannel(str2);
            if (readChannel2 != null) {
                try {
                    parseInt = Integer.parseInt(readChannel2);
                } catch (NumberFormatException unused) {
                    Log.i("ApkChannelUtil", "old_channelValue or new_channelValue is character\uff0c rewrite old channel directly.");
                    try {
                        if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                            Log.i("ApkChannelUtil", "use v2 signature");
                            ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                            return 2000;
                        }
                        Log.i("ApkChannelUtil", "use v1 signature");
                        ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                        return 2000;
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        Log.i("ApkChannelUtil", "writeOldCommentToNewFileWithWhiteListReturnReWriteRes exception!");
                        return 2001;
                    }
                }
            } else {
                parseInt = 0;
            }
            int parseInt2 = Integer.parseInt(readChannel);
            if (parseInt2 >= 79900000 && parseInt2 <= 89999999) {
                if (readChannel2 == null) {
                    Log.i("ApkChannelUtil", "old channel=" + parseInt2 + " new channel value is null");
                    if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                        Log.i("ApkChannelUtil", "use v2 signature");
                        ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                    } else {
                        Log.i("ApkChannelUtil", "use v1 signature");
                        ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                    }
                } else if (parseInt2 >= 79900000 && parseInt2 <= 79999999 && parseInt >= 89900000 && parseInt <= 89999999) {
                    Log.i("ApkChannelUtil", "old channel=" + parseInt2 + " new channel=" + parseInt);
                    if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                        Log.i("ApkChannelUtil", "use v2 signature");
                        ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                    } else {
                        Log.i("ApkChannelUtil", "use v1 signature");
                        ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                    }
                } else {
                    Log.i("ApkChannelUtil", "old channel=" + parseInt2 + " new channel=" + parseInt);
                    Log.i("ApkChannelUtil", "Don't need reWrite channel Value");
                }
            } else {
                Log.i("ApkChannelUtil", "value=" + parseInt2);
                if (ApkSignatureV2ChannelTool.isSignatureV2Apk(str2)) {
                    Log.i("ApkChannelUtil", "use v2 signature");
                    ApkSignatureV2ChannelTool.updateYYBComment(str2, readChannelComment.encode());
                } else {
                    Log.i("ApkChannelUtil", "use v1 signature");
                    ZipEocdCommentTool.updateComment(str2, readChannelComment.encode());
                }
            }
            Log.i("ApkChannelUtil", "final_apk_channel_value=" + readChannel(str2));
            return 0;
        } catch (Exception e17) {
            e17.printStackTrace();
            Log.i("ApkChannelUtil", "writeOldCommentToNewFileWithWhiteListRetunReWriteRes exception!");
            return 1001;
        }
    }
}
