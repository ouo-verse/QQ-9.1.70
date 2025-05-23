package com.tencent.ams.fusion.widget.apng.decode;

import android.content.Context;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.Reader;
import com.tencent.ams.fusion.widget.apng.frame.animation.io.StreamReader;
import com.tencent.ams.fusion.widget.apng.io.APNGReader;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class APNGParser {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class FormatException extends IOException {
        static IPatchRedirector $redirector_;

        FormatException() {
            super("APNG Format error");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public APNGParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static boolean isAPNG(String str) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(str);
        } catch (Exception unused) {
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            boolean isAPNG = isAPNG(new StreamReader(fileInputStream));
            try {
                fileInputStream.close();
            } catch (IOException e16) {
                e16.printStackTrace();
            }
            return isAPNG;
        } catch (Exception unused2) {
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 == null) {
                return false;
            }
            try {
                fileInputStream2.close();
                return false;
            } catch (IOException e17) {
                e17.printStackTrace();
                return false;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            throw th;
        }
    }

    public static List<Chunk> parse(APNGReader aPNGReader) throws IOException {
        if (aPNGReader.matchFourCC("\u0089PNG") && aPNGReader.matchFourCC("\r\n\u001a\n")) {
            ArrayList arrayList = new ArrayList();
            while (aPNGReader.available() > 0) {
                arrayList.add(parseChunk(aPNGReader));
            }
            return arrayList;
        }
        throw new FormatException();
    }

    private static Chunk parseChunk(APNGReader aPNGReader) throws IOException {
        Chunk chunk;
        int position = aPNGReader.position();
        int readInt = aPNGReader.readInt();
        int readFourCC = aPNGReader.readFourCC();
        if (readFourCC == ACTLChunk.ID) {
            chunk = new ACTLChunk();
        } else if (readFourCC == FCTLChunk.ID) {
            chunk = new FCTLChunk();
        } else if (readFourCC == FDATChunk.ID) {
            chunk = new FDATChunk();
        } else if (readFourCC == IDATChunk.ID) {
            chunk = new IDATChunk();
        } else if (readFourCC == IENDChunk.ID) {
            chunk = new IENDChunk();
        } else if (readFourCC == IHDRChunk.ID) {
            chunk = new IHDRChunk();
        } else {
            chunk = new Chunk();
        }
        chunk.offset = position;
        chunk.fourcc = readFourCC;
        chunk.length = readInt;
        chunk.parse(aPNGReader);
        chunk.crc = aPNGReader.readInt();
        return chunk;
    }

    public static boolean isAPNG(Context context, String str) {
        InputStream inputStream = null;
        try {
            inputStream = context.getAssets().open(str);
            boolean isAPNG = isAPNG(new StreamReader(inputStream));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            return isAPNG;
        } catch (Exception unused) {
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e17) {
                e17.printStackTrace();
                return false;
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public static boolean isAPNG(Context context, int i3) {
        InputStream inputStream = null;
        try {
            inputStream = context.getResources().openRawResource(i3);
            boolean isAPNG = isAPNG(new StreamReader(inputStream));
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
            return isAPNG;
        } catch (Exception unused) {
            if (inputStream == null) {
                return false;
            }
            try {
                inputStream.close();
                return false;
            } catch (IOException e17) {
                e17.printStackTrace();
                return false;
            }
        } catch (Throwable th5) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                }
            }
            throw th5;
        }
    }

    public static boolean isAPNG(Reader reader) {
        APNGReader aPNGReader = reader instanceof APNGReader ? (APNGReader) reader : new APNGReader(reader);
        try {
            try {
                try {
                } catch (Throwable th5) {
                    if (aPNGReader != null) {
                        try {
                            aPNGReader.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th5;
                }
            } catch (IOException e16) {
                if (!(e16 instanceof FormatException)) {
                    e16.printStackTrace();
                }
                if (aPNGReader != null) {
                    aPNGReader.close();
                }
            }
        } catch (Throwable th7) {
            th7.printStackTrace();
        }
        if (aPNGReader.matchFourCC("\u0089PNG")) {
            if (!aPNGReader.matchFourCC("\r\n\u001a\n")) {
            }
            while (aPNGReader.available() > 0) {
                if (parseChunk(aPNGReader) instanceof ACTLChunk) {
                    try {
                        aPNGReader.close();
                        return true;
                    } catch (Throwable th8) {
                        th8.printStackTrace();
                        return true;
                    }
                }
            }
            aPNGReader.close();
            return false;
        }
        try {
            aPNGReader.close();
        } catch (Throwable th9) {
            th9.printStackTrace();
        }
        return false;
    }
}
