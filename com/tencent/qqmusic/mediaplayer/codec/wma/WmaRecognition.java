package com.tencent.qqmusic.mediaplayer.codec.wma;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.qqmusic.mediaplayer.AudioFormat;
import com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: P */
/* loaded from: classes23.dex */
public class WmaRecognition implements IAudioRecognition {
    public static String TAG = "WmaRecognition";
    private final int HEARER_LENGTH = 16;
    private final byte[] WMA_HEADER = {48, 38, -78, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -114, 102, -49, 17, -90, -39, 0, -86, 0, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, -50, Constants.SDK_SEND_CHANNEL_DATA_TYPE};

    /* JADX WARN: Removed duplicated region for block: B:15:0x0051  */
    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public AudioFormat.AudioType getAudioType(String str, byte[] bArr) {
        FileInputStream fileInputStream;
        byte[] bArr2;
        int i3;
        if (bArr == null || bArr.length < 16) {
            FileInputStream fileInputStream2 = null;
            bArr = null;
            fileInputStream2 = null;
            try {
                try {
                    fileInputStream = new FileInputStream(str);
                    try {
                        bArr = new byte[16];
                        fileInputStream.read(bArr);
                        try {
                            fileInputStream.close();
                        } catch (IOException e16) {
                            Logger.e(TAG, e16);
                        }
                    } catch (IOException e17) {
                        e = e17;
                        bArr2 = bArr;
                        fileInputStream2 = fileInputStream;
                        Logger.e(TAG, e);
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (IOException e18) {
                                Logger.e(TAG, e18);
                            }
                        }
                        bArr = bArr2;
                        if (bArr != null) {
                            i3 = 0;
                            while (i3 < 16) {
                                i3++;
                            }
                            if (i3 == 16) {
                            }
                        }
                        return AudioFormat.AudioType.UNSUPPORT;
                    } catch (Throwable th5) {
                        th = th5;
                        if (fileInputStream != null) {
                            try {
                                fileInputStream.close();
                            } catch (IOException e19) {
                                Logger.e(TAG, e19);
                            }
                        }
                        throw th;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    fileInputStream = fileInputStream2;
                }
            } catch (IOException e26) {
                e = e26;
                bArr2 = null;
            }
        }
        if (bArr != null && bArr.length >= 16) {
            i3 = 0;
            while (i3 < 16 && bArr[i3] == this.WMA_HEADER[i3]) {
                i3++;
            }
            if (i3 == 16) {
                return AudioFormat.AudioType.WMA;
            }
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }

    @Override // com.tencent.qqmusic.mediaplayer.codec.IAudioRecognition
    public AudioFormat.AudioType guessAudioType(String str) {
        if (!TextUtils.isEmpty(str) && str.toLowerCase().contains(".wma")) {
            return AudioFormat.AudioType.WMA;
        }
        return AudioFormat.AudioType.UNSUPPORT;
    }
}
