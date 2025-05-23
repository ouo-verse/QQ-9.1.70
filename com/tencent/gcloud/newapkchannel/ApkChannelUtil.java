package com.tencent.gcloud.newapkchannel;

import android.util.Log;
import com.tencent.gcloud.newapkchannel.v2.ApkSignatureSchemeV2Verifier;
import com.tencent.gcloud.newapkchannel.v2.ApkSignatureV2V3ChannelTool;
import com.tencent.gcloud.newapkchannel.v2.ZipEocdCommentTool;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.IOException;
import java.net.ProtocolException;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ApkChannelUtil {
    static IPatchRedirector $redirector_ = null;
    public static final String CHANNEL_ID = "channelId";
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

    public static int GetSignatureSize(String str) {
        try {
            MSDKComment readMsdkComment = readMsdkComment(str);
            if (readMsdkComment == null) {
                readMsdkComment = new MSDKComment();
            }
            return ApkSignatureV2V3ChannelTool.GetApkSignatureSize(str, readMsdkComment);
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("ApkChannelUtil", "GetSignatureSize Exception.");
            return -1;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int isSignatureV2Apk(String str) {
        boolean z16;
        try {
            z16 = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str);
            try {
                Log.i("ApkChannelUtil", "isSignatureV2Apk ret:" + z16);
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                Log.i("ApkChannelUtil", "judge isSignatureV2Apk exception failed!");
                if (z16) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return 1;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:1|(2:2|3)|(3:5|6|(4:8|9|10|(1:12)(1:14)))|20|9|10|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0035, code lost:
    
        r3 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0036, code lost:
    
        r3 = r12;
        r12 = r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003c, code lost:
    
        r12.printStackTrace();
        android.util.Log.i("ApkChannelUtil", "judge isSignV2Plus exception failed!");
        r12 = r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0048 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0049 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int isSignatureV2PlusApk(String str) {
        boolean z16;
        long GetSignatureSize;
        long signaturOffset;
        try {
            GetSignatureSize = GetSignatureSize(str);
            signaturOffset = ApkSignatureSchemeV2Verifier.getSignaturOffset(str);
        } catch (Exception e16) {
            e = e16;
            boolean z17 = false;
        }
        if (GetSignatureSize % 4096 == 0) {
            if (signaturOffset % 4096 == 0) {
                z16 = true;
                Log.i("ApkChannelUtil", "isSignV2Plus ret:" + z16);
                if (z16) {
                    return 1;
                }
                return 0;
            }
        }
        z16 = false;
        Log.i("ApkChannelUtil", "isSignV2Plus ret:" + z16);
        if (z16) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002d A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int isSignatureV3Apk(String str) {
        boolean z16;
        try {
            z16 = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str);
            try {
                Log.i("ApkChannelUtil", "isSignatureV3Apk ret:" + z16);
            } catch (Exception e16) {
                e = e16;
                e.printStackTrace();
                Log.i("ApkChannelUtil", "judge isSignatureV3Apk exception failed!");
                if (z16) {
                }
            }
        } catch (Exception e17) {
            e = e17;
            z16 = false;
        }
        if (z16) {
            return 0;
        }
        return 1;
    }

    public static String readChannel(String str) {
        try {
            MSDKComment readMsdkComment = readMsdkComment(str);
            if (readMsdkComment == null) {
                Log.i("ApkChannelUtil", "readChannel, Comment is null");
                return null;
            }
            Log.i("ApkChannelUtil", "readChannel success, channel=" + readMsdkComment.getP().getProperty("channelId"));
            return readMsdkComment.getP().getProperty("channelId");
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("ApkChannelUtil", "readChannel exception failed!");
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static MSDKComment readMsdkComment(String str) throws IOException {
        byte[] readYYBComment;
        boolean isSignatureV3Apk = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str);
        boolean isSignatureV2Apk = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str);
        if (isSignatureV2Apk || isSignatureV3Apk) {
            try {
                readYYBComment = ApkSignatureV2V3ChannelTool.readYYBComment(str);
            } catch (ApkSignatureSchemeV2Verifier.SignatureNotFoundException e16) {
                e16.printStackTrace();
            }
            if (readYYBComment == null) {
                readYYBComment = ZipEocdCommentTool.readComment(str);
                if (isSignatureV2Apk && readYYBComment != null) {
                    System.out.println("you are use v2 signature but use v1 channel modle");
                } else if (isSignatureV3Apk && readYYBComment != null) {
                    System.out.println("you are use v3 signature but use v1 channel modle");
                }
            }
            if (readYYBComment != null) {
                return null;
            }
            MSDKComment mSDKComment = new MSDKComment();
            try {
                mSDKComment.decode(readYYBComment);
                return mSDKComment;
            } catch (ProtocolException e17) {
                e17.printStackTrace();
                return null;
            }
        }
        readYYBComment = null;
        if (readYYBComment == null) {
        }
        if (readYYBComment != null) {
        }
    }

    public static void updateChannel(String str, String str2) throws Exception {
        updateKeyValuePair(str, "channelId", str2);
    }

    private static void updateKeyValuePair(String str, String str2, String str3) throws Exception {
        MSDKComment readMsdkComment = readMsdkComment(str);
        if (readMsdkComment == null) {
            readMsdkComment = new MSDKComment();
        }
        readMsdkComment.getP().setProperty(str2, str3);
        boolean isSignatureV2Apk = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str);
        boolean isSignatureV3Apk = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str);
        if (!isSignatureV2Apk && !isSignatureV3Apk) {
            ZipEocdCommentTool.updateComment(str, readMsdkComment.encode());
        } else {
            ApkSignatureV2V3ChannelTool.updateYYBComment(str, readMsdkComment);
        }
    }

    public static void writeOldCommentToNewFileWithWhiteList(String str, String str2) {
        int i3;
        Log.i("ApkChannelUtil", "start writeOldCommentToNewFileWithWhiteList.");
        try {
            MSDKComment readMsdkComment = readMsdkComment(str);
            if (readMsdkComment == null) {
                Log.i("ApkChannelUtil", "old apk Comment is null, writeOldCommentToNewFileWithWhiteList end.");
                return;
            }
            String readChannel = readChannel(str);
            if (readChannel == null) {
                Log.i("ApkChannelUtil", "old_apk_channel_value is null, writeOldCommentToNewFileWithWhiteList end.");
                return;
            }
            String readChannel2 = readChannel(str2);
            if (readChannel2 != null) {
                i3 = Integer.parseInt(readChannel2);
            } else {
                i3 = 0;
            }
            int parseInt = Integer.parseInt(readChannel);
            if (readChannel2 == null) {
                Log.i("ApkChannelUtil", "old channel=" + readChannel + " new channel = null;");
            } else {
                Log.i("ApkChannelUtil", "old channel=" + readChannel + " new channel=" + readChannel2);
            }
            String str3 = "use v2 way rewrite channel";
            if (parseInt >= 79900000 && parseInt <= 89999999) {
                if (readChannel2 == null) {
                    Log.i("ApkChannelUtil", "old channel=" + parseInt + " new channel value is null");
                    boolean isSignatureV2Apk = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str2);
                    boolean isSignatureV3Apk = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str2);
                    if (!isSignatureV2Apk && !isSignatureV3Apk) {
                        Log.i("ApkChannelUtil", "use v1 way rewrite channel");
                        ZipEocdCommentTool.updateComment(str2, readMsdkComment.encode());
                    }
                    str3 = "use v3 way rewrite channel";
                    Log.i("ApkChannelUtil", str3);
                    ApkSignatureV2V3ChannelTool.updateYYBComment(str2, readMsdkComment);
                } else if (parseInt >= 79900000 && parseInt <= 79999999 && i3 >= 89900000 && i3 <= 89999999) {
                    boolean isSignatureV2Apk2 = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str2);
                    boolean isSignatureV3Apk2 = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str2);
                    if (!isSignatureV2Apk2 && !isSignatureV3Apk2) {
                        Log.i("ApkChannelUtil", "use v1 way rewrite channel");
                        ZipEocdCommentTool.updateComment(str2, readMsdkComment.encode());
                    }
                    str3 = "use v3 way rewrite channel";
                    Log.i("ApkChannelUtil", str3);
                    ApkSignatureV2V3ChannelTool.updateYYBComment(str2, readMsdkComment);
                } else {
                    Log.i("ApkChannelUtil", "Don't need reWrite channel Value");
                }
            } else {
                boolean isSignatureV2Apk3 = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str2);
                boolean isSignatureV3Apk3 = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str2);
                if (!isSignatureV2Apk3 && !isSignatureV3Apk3) {
                    Log.i("ApkChannelUtil", "use v1 way rewrite channel");
                    ZipEocdCommentTool.updateComment(str2, readMsdkComment.encode());
                }
                str3 = "use v3 way rewrite channel";
                Log.i("ApkChannelUtil", str3);
                ApkSignatureV2V3ChannelTool.updateYYBComment(str2, readMsdkComment);
            }
            Log.i("ApkChannelUtil", "final_apk_channel_value=" + readChannel(str2));
            Log.i("ApkChannelUtil", "writeOldCommentToNewFileWithWhiteList end.");
        } catch (Exception e16) {
            e16.printStackTrace();
            Log.i("ApkChannelUtil", "writeOldCommentToNewFileWithWhiteList exception failed!");
        }
    }

    public static int writeOldCommentToNewFileWithWhiteListRetunReWriteRes(String str, String str2) {
        int parseInt;
        Log.i("ApkChannelUtil", "start writeOldCommentToNewFileWithWhiteList.");
        try {
            MSDKComment readMsdkComment = readMsdkComment(str);
            if (readMsdkComment == null) {
                Log.i("ApkChannelUtil", "old apk Comment is null, writeOldCommentToNewFileWithWhiteList end.");
                return 0;
            }
            String readChannel = readChannel(str);
            if (readChannel == null) {
                Log.i("ApkChannelUtil", "old_apk_channel_value is null, writeOldCommentToNewFileWithWhiteList end.");
                return 0;
            }
            String readChannel2 = readChannel(str2);
            String str3 = "use v2 way rewrite channel";
            if (readChannel2 != null) {
                try {
                    parseInt = Integer.parseInt(readChannel2);
                } catch (NumberFormatException unused) {
                    Log.i("ApkChannelUtil", "old_channelValue or new_channelValue is character\uff0c rewrite old channel directly.");
                    try {
                        boolean isSignatureV2Apk = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str2);
                        boolean isSignatureV3Apk = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str2);
                        if (!isSignatureV2Apk && !isSignatureV3Apk) {
                            Log.i("ApkChannelUtil", "use v1 way rewrite channel");
                            ZipEocdCommentTool.updateComment(str2, readMsdkComment.encode());
                            return 2000;
                        }
                        str3 = "use v3 way rewrite channel";
                        Log.i("ApkChannelUtil", str3);
                        ApkSignatureV2V3ChannelTool.updateYYBComment(str2, readMsdkComment);
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
                    boolean isSignatureV2Apk2 = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str2);
                    boolean isSignatureV3Apk2 = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str2);
                    if (!isSignatureV2Apk2 && !isSignatureV3Apk2) {
                        Log.i("ApkChannelUtil", "use v1 way rewrite channel");
                        ZipEocdCommentTool.updateComment(str2, readMsdkComment.encode());
                    }
                    str3 = "use v3 way rewrite channel";
                    Log.i("ApkChannelUtil", str3);
                    ApkSignatureV2V3ChannelTool.updateYYBComment(str2, readMsdkComment);
                } else if (parseInt2 >= 79900000 && parseInt2 <= 79999999 && parseInt >= 89900000 && parseInt <= 89999999) {
                    boolean isSignatureV2Apk3 = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str2);
                    boolean isSignatureV3Apk3 = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str2);
                    if (!isSignatureV2Apk3 && !isSignatureV3Apk3) {
                        Log.i("ApkChannelUtil", "use v1 way rewrite channel");
                        ZipEocdCommentTool.updateComment(str2, readMsdkComment.encode());
                    }
                    str3 = "use v3 way rewrite channel";
                    Log.i("ApkChannelUtil", str3);
                    ApkSignatureV2V3ChannelTool.updateYYBComment(str2, readMsdkComment);
                } else {
                    Log.i("ApkChannelUtil", "Don't need reWrite channel Value");
                }
            } else {
                boolean isSignatureV2Apk4 = ApkSignatureV2V3ChannelTool.isSignatureV2Apk(str2);
                boolean isSignatureV3Apk4 = ApkSignatureV2V3ChannelTool.isSignatureV3Apk(str2);
                if (!isSignatureV2Apk4 && !isSignatureV3Apk4) {
                    Log.i("ApkChannelUtil", "use v1 way rewrite channel");
                    ZipEocdCommentTool.updateComment(str2, readMsdkComment.encode());
                }
                str3 = "use v3 way rewrite channel";
                Log.i("ApkChannelUtil", str3);
                ApkSignatureV2V3ChannelTool.updateYYBComment(str2, readMsdkComment);
            }
            Log.i("ApkChannelUtil", "final_apk_channel_value=" + readChannel(str2));
            Log.i("ApkChannelUtil", "writeOldCommentToNewFileWithWhiteList end.");
            return 0;
        } catch (Exception e17) {
            e17.printStackTrace();
            Log.i("ApkChannelUtil", "writeOldCommentToNewFileWithWhiteListRetunReWriteRes exception failed!");
            return 1001;
        }
    }
}
