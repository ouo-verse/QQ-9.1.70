package com.tencent.image;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.IOException;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes7.dex */
public class NativeGifIOException extends IOException {
    static IPatchRedirector $redirector_ = null;
    private static final long serialVersionUID = 13038402904505L;
    public final NativeGifError reason;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static final class NativeGifError {
        private static final /* synthetic */ NativeGifError[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final NativeGifError CLOSE_FAILED;
        public static final NativeGifError DATA_TOO_BIG;
        public static final NativeGifError EOF_TOO_SOON;
        public static final NativeGifError ERROR_ALLOC_PIXEL_REF;
        public static final NativeGifError ERROR_GIF_FILE;
        public static final NativeGifError FAIL_ADD_EXTENSION;
        public static final NativeGifError FAIL_CHOOSE_FROM_ONE_CHOICE;
        public static final NativeGifError FAIL_EXTRACT;
        public static final NativeGifError FAIL_GET_EXTENSION;
        public static final NativeGifError FAIL_GET_EXTENSION_NEXT;
        public static final NativeGifError FAIL_GET_RECORD_TYPE;
        public static final NativeGifError FIAL_GET_IMGE_DESC;
        public static final NativeGifError IMAGE_COUNT_LESS_1;
        public static final NativeGifError IMAGE_DEFECT;
        public static final NativeGifError IMG_NOT_CONFINED;
        public static final NativeGifError INVALID_DIMENSIONS;
        public static final NativeGifError INVALID_IMG_DIMS;
        public static final NativeGifError INVALID_SCR_DIMS;
        public static final NativeGifError NOT_ENOUGH_MEM;
        public static final NativeGifError NOT_GIF_FILE;
        public static final NativeGifError NOT_READABLE;
        public static final NativeGifError NO_COLOR_MAP;
        public static final NativeGifError NO_ERROR;
        public static final NativeGifError NO_FRAMES;
        public static final NativeGifError NO_IMAG_DSCR;
        public static final NativeGifError NO_SCRN_DSCR;
        public static final NativeGifError OPEN_FAILED;
        public static final NativeGifError READ_FAILED;
        public static final NativeGifError SAMPLER_FAIL_BEGIN;
        public static final NativeGifError UNKNOWN;
        public static final NativeGifError WRONG_RECORD;
        public final String description;
        private int errorCode;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(9837);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
                return;
            }
            NativeGifError nativeGifError = new NativeGifError("NO_ERROR", 0, 0, "No error");
            NO_ERROR = nativeGifError;
            NativeGifError nativeGifError2 = new NativeGifError("OPEN_FAILED", 1, 101, "Failed to open given input");
            OPEN_FAILED = nativeGifError2;
            NativeGifError nativeGifError3 = new NativeGifError("READ_FAILED", 2, 102, "Failed to read from given input");
            READ_FAILED = nativeGifError3;
            NativeGifError nativeGifError4 = new NativeGifError("NOT_GIF_FILE", 3, 103, "Data is not in GIF format");
            NOT_GIF_FILE = nativeGifError4;
            NativeGifError nativeGifError5 = new NativeGifError("NO_SCRN_DSCR", 4, 104, "No screen descriptor detected");
            NO_SCRN_DSCR = nativeGifError5;
            NativeGifError nativeGifError6 = new NativeGifError("NO_IMAG_DSCR", 5, 105, "No image descriptor detected");
            NO_IMAG_DSCR = nativeGifError6;
            NativeGifError nativeGifError7 = new NativeGifError("NO_COLOR_MAP", 6, 106, "Neither global nor local color map found");
            NO_COLOR_MAP = nativeGifError7;
            NativeGifError nativeGifError8 = new NativeGifError("WRONG_RECORD", 7, 107, "Wrong record type detected");
            WRONG_RECORD = nativeGifError8;
            NativeGifError nativeGifError9 = new NativeGifError("DATA_TOO_BIG", 8, 108, "Number of pixels bigger than width * height");
            DATA_TOO_BIG = nativeGifError9;
            NativeGifError nativeGifError10 = new NativeGifError("NOT_ENOUGH_MEM", 9, 109, "Failed to allocate required memory");
            NOT_ENOUGH_MEM = nativeGifError10;
            NativeGifError nativeGifError11 = new NativeGifError("CLOSE_FAILED", 10, 110, "Failed to close given input");
            CLOSE_FAILED = nativeGifError11;
            NativeGifError nativeGifError12 = new NativeGifError("NOT_READABLE", 11, 111, "Given file was not opened for read");
            NOT_READABLE = nativeGifError12;
            NativeGifError nativeGifError13 = new NativeGifError("IMAGE_DEFECT", 12, 112, "Image is defective, decoding aborted");
            IMAGE_DEFECT = nativeGifError13;
            NativeGifError nativeGifError14 = new NativeGifError("EOF_TOO_SOON", 13, 113, "Image EOF detected before image complete");
            EOF_TOO_SOON = nativeGifError14;
            NativeGifError nativeGifError15 = new NativeGifError("NO_FRAMES", 14, 1000, "No frames found, at least one frame required");
            NO_FRAMES = nativeGifError15;
            NativeGifError nativeGifError16 = new NativeGifError("INVALID_SCR_DIMS", 15, 1001, "Invalid screen size, dimensions must be positive");
            INVALID_SCR_DIMS = nativeGifError16;
            NativeGifError nativeGifError17 = new NativeGifError("INVALID_IMG_DIMS", 16, 1002, "Invalid image size, dimensions must be positive");
            INVALID_IMG_DIMS = nativeGifError17;
            NativeGifError nativeGifError18 = new NativeGifError("IMG_NOT_CONFINED", 17, 1003, "Image size exceeds screen size");
            IMG_NOT_CONFINED = nativeGifError18;
            NativeGifError nativeGifError19 = new NativeGifError("ERROR_GIF_FILE", 18, 2015, "DGifOpen fail. gif is null.");
            ERROR_GIF_FILE = nativeGifError19;
            NativeGifError nativeGifError20 = new NativeGifError("FAIL_GET_RECORD_TYPE", 19, 2016, "DGifGetRecordType fail. cannot get record type.");
            FAIL_GET_RECORD_TYPE = nativeGifError20;
            NativeGifError nativeGifError21 = new NativeGifError("FIAL_GET_IMGE_DESC", 20, 2017, "DGifGetImageDesc fail. cann't get image description record type.");
            FIAL_GET_IMGE_DESC = nativeGifError21;
            NativeGifError nativeGifError22 = new NativeGifError("IMAGE_COUNT_LESS_1", 21, 2018, "image count < 1.");
            IMAGE_COUNT_LESS_1 = nativeGifError22;
            NativeGifError nativeGifError23 = new NativeGifError("INVALID_DIMENSIONS", 22, 2019, "innerwith or innerheight <= 0");
            INVALID_DIMENSIONS = nativeGifError23;
            NativeGifError nativeGifError24 = new NativeGifError("FAIL_CHOOSE_FROM_ONE_CHOICE", 23, 2020, "chooseFromOneChoice fail.");
            FAIL_CHOOSE_FROM_ONE_CHOICE = nativeGifError24;
            NativeGifError nativeGifError25 = new NativeGifError("ERROR_ALLOC_PIXEL_REF", 24, 2021, "allocPixelRef fail.");
            ERROR_ALLOC_PIXEL_REF = nativeGifError25;
            NativeGifError nativeGifError26 = new NativeGifError("FAIL_EXTRACT", 25, 2022, "Extract failed.");
            FAIL_EXTRACT = nativeGifError26;
            NativeGifError nativeGifError27 = new NativeGifError("SAMPLER_FAIL_BEGIN", 26, 2023, "Sampler failed to begin.");
            SAMPLER_FAIL_BEGIN = nativeGifError27;
            NativeGifError nativeGifError28 = new NativeGifError("FAIL_GET_EXTENSION", 27, MessageRecord.MSG_TYPE_CONFIGURABLE_GRAY_TIPS, "DGifGetExtension fail.");
            FAIL_GET_EXTENSION = nativeGifError28;
            NativeGifError nativeGifError29 = new NativeGifError("FAIL_ADD_EXTENSION", 28, 2025, "AddExtensionBlock fail.");
            FAIL_ADD_EXTENSION = nativeGifError29;
            NativeGifError nativeGifError30 = new NativeGifError("FAIL_GET_EXTENSION_NEXT", 29, 2026, "DGifGetExtensionNext fail.");
            FAIL_GET_EXTENSION_NEXT = nativeGifError30;
            NativeGifError nativeGifError31 = new NativeGifError("UNKNOWN", 30, -1, "Unknown error");
            UNKNOWN = nativeGifError31;
            $VALUES = new NativeGifError[]{nativeGifError, nativeGifError2, nativeGifError3, nativeGifError4, nativeGifError5, nativeGifError6, nativeGifError7, nativeGifError8, nativeGifError9, nativeGifError10, nativeGifError11, nativeGifError12, nativeGifError13, nativeGifError14, nativeGifError15, nativeGifError16, nativeGifError17, nativeGifError18, nativeGifError19, nativeGifError20, nativeGifError21, nativeGifError22, nativeGifError23, nativeGifError24, nativeGifError25, nativeGifError26, nativeGifError27, nativeGifError28, nativeGifError29, nativeGifError30, nativeGifError31};
        }

        NativeGifError(String str, int i3, int i16, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, str, Integer.valueOf(i3), Integer.valueOf(i16), str2);
            } else {
                this.errorCode = i16;
                this.description = str2;
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public static NativeGifError fromCode(int i3) {
            for (NativeGifError nativeGifError : values()) {
                if (nativeGifError.errorCode == i3) {
                    return nativeGifError;
                }
            }
            NativeGifError nativeGifError2 = UNKNOWN;
            nativeGifError2.errorCode = i3;
            return nativeGifError2;
        }

        public static NativeGifError valueOf(String str) {
            return (NativeGifError) Enum.valueOf(NativeGifError.class, str);
        }

        public static NativeGifError[] values() {
            return (NativeGifError[]) $VALUES.clone();
        }

        public int getErrorCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
            }
            return this.errorCode;
        }

        String getFormattedDescription() {
            return String.format(Locale.US, "NativeGifError %d: %s", Integer.valueOf(this.errorCode), this.description);
        }
    }

    NativeGifIOException(NativeGifError nativeGifError) {
        super(nativeGifError.getFormattedDescription());
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.reason = nativeGifError;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) nativeGifError);
        }
    }

    NativeGifIOException(int i3) {
        this(NativeGifError.fromCode(i3));
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, i3);
    }
}
