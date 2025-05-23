package com.tencent.qbar;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes22.dex */
public class QBarConstants {
    static IPatchRedirector $redirector_ = null;
    public static final int AZTEC = 1;
    public static final int CODABAR = 2;
    public static final int CODE25 = 19;
    public static final int CODE_128 = 5;
    public static final int CODE_39 = 3;
    public static final int CODE_93 = 4;
    public static final int DATAMATRIX_READER = 5;
    public static final int DATA_MATRIX = 6;
    public static final int EAN_13 = 8;
    public static final int EAN_8 = 7;
    public static final int FAST = 0;
    public static final int GRAY = 0;
    public static final int H = 3;
    public static final int ITF = 9;
    public static final int L = 0;
    public static final int M = 1;
    public static final int MAXICODE = 10;
    public static final int NORMAL = 1;
    public static final int NO_RESULT = 0;
    public static final int ONED_BARCODE_READER = 1;
    public static final int PDF417_READER = 4;
    public static final int PDF_417 = 11;
    public static final int Q = 2;
    public static final int QRCODE_READER = 2;
    public static final int QR_CODE = 12;
    public static final int RGB = 1;
    public static final int RGBA = 2;
    public static final int RSS_14 = 13;
    public static final int RSS_EXPANDED = 14;
    public static final int SCAN_FILE = 1;
    public static final int SCAN_VIDEO = 0;
    public static final int SEARCH_MULTI = 1;
    public static final int SEARCH_ONE = 0;
    public static final int TRYHARDER = 2;
    public static final int UPC_A = 15;
    public static final int UPC_E = 16;
    public static final int UPC_EAN_EXTENSION = 17;

    public QBarConstants() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
