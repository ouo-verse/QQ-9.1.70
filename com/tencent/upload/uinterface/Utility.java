package com.tencent.upload.uinterface;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.selectmember.ISelectMemberActivityConstants;
import com.tencent.upload.common.UploadConfiguration;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes27.dex */
public class Utility {
    static IPatchRedirector $redirector_ = null;
    private static final String MAGIC_CLASS_NAME = "126%138%136%73%143%128%137%126%128%137%143%73%146%137%142%73%128%147%139%138%141%143%73%96%136%139%143%148%110%128%141%145%132%126%128%";
    private static final String MAGIC_PACKAGE_NAME = "126%138%136%73%140%149%138%137%128%";

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static class AlbumTypeID {
        static IPatchRedirector $redirector_ = null;
        public static final int ALBUM_BLOG = 2;
        public static final int ALBUM_BLOGFACE = 9;
        public static final int ALBUM_CAMPUS = 5;
        public static final int ALBUM_COMMON = 0;
        public static final int ALBUM_KING = 24;
        public static final int ALBUM_MICRO = 11;
        public static final int ALBUM_MOBILE = 1;
        public static final int ALBUM_OLDMICRO = 12;
        public static final int ALBUM_OLDPYHEAD = 18;
        public static final int ALBUM_OLDQPAI = 14;
        public static final int ALBUM_OLDQPAI_SYNC = 16;
        public static final int ALBUM_OLDQZONEAPP = 20;
        public static final int ALBUM_PPT = 10;
        public static final int ALBUM_PRIVBLOG = 7;
        public static final int ALBUM_PYHEAD = 17;
        public static final int ALBUM_QPAI = 13;
        public static final int ALBUM_QPAI_SYNC = 15;
        public static final int ALBUM_QQSHOW = 4;
        public static final int ALBUM_QZONEAPP = 19;
        public static final int ALBUM_SHARE = 23;
        public static final int ALBUM_SHARE_OLD = 21;
        public static final int ALBUM_SYSTEM = 22;
        public static final int ALBUM_WEAPP = 25;

        public AlbumTypeID() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public Utility() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static final boolean clearUploadTempCache(Context context) {
        return UploadServiceBuilder.getInstance().clearCacheWhenIdle(context);
    }

    public static String decrypt(String str) {
        try {
            String str2 = new String();
            StringTokenizer stringTokenizer = new StringTokenizer(str, "%");
            while (stringTokenizer.hasMoreElements()) {
                str2 = str2 + ((char) (Integer.parseInt((String) stringTokenizer.nextElement()) - 27));
            }
            return str2;
        } catch (Exception e16) {
            e16.printStackTrace();
            return null;
        }
    }

    public static final long getCurrentUploadServerTime() {
        long[] uploadServerTimePair = UploadConfiguration.getUploadServerTimePair();
        if (uploadServerTimePair != null && uploadServerTimePair.length == 2) {
            long j3 = uploadServerTimePair[0];
            if (j3 > 0 && uploadServerTimePair[1] > 0) {
                return (j3 + (System.currentTimeMillis() / 1000)) - uploadServerTimePair[1];
            }
        }
        return System.currentTimeMillis() / 1000;
    }

    public static final void keepLongConnection(Context context, Long l3, String str) {
        keepLongConnection(context, l3, str, MAGIC_PACKAGE_NAME, MAGIC_CLASS_NAME);
    }

    public static final boolean needCompress2Webp(int i3, int i16) {
        if (i16 == 2 && (i3 & 16) == 16) {
            return true;
        }
        if (i16 != 2 && i16 != 3 && (i3 & 1) == 1) {
            return true;
        }
        return false;
    }

    public static final void keepLongConnection(Context context, Long l3, String str, String str2, String str3) {
        Intent intent = new Intent();
        intent.putExtra(ISelectMemberActivityConstants.PARAM_FROM, 0);
        intent.putExtra("param_uin", l3);
        intent.putExtra("param_scene", 2);
        intent.putExtra("param_push_data", str);
        intent.setClassName(decrypt(str2), decrypt(str3));
        context.startService(intent);
    }
}
