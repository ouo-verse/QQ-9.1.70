package org.apache.commons.io.input;

import com.tencent.local_edit.andserver.util.MediaType;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.ByteOrderMark;

/* compiled from: P */
/* loaded from: classes29.dex */
public class XmlStreamReader extends Reader {
    private static final int BUFFER_SIZE = 4096;
    private static final String HTTP_EX_1 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], BOM must be NULL";
    private static final String HTTP_EX_2 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], encoding mismatch";
    private static final String HTTP_EX_3 = "Invalid encoding, CT-MIME [{0}] CT-Enc [{1}] BOM [{2}] XML guess [{3}] XML prolog [{4}], Invalid MIME";
    private static final String RAW_EX_1 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] encoding mismatch";
    private static final String RAW_EX_2 = "Invalid encoding, BOM [{0}] XML guess [{1}] XML prolog [{2}] unknown BOM";
    private static final String US_ASCII = "US-ASCII";
    private static final String UTF_16 = "UTF-16";
    private static final String UTF_16BE = "UTF-16BE";
    private static final String UTF_16LE = "UTF-16LE";
    private static final String UTF_32 = "UTF-32";
    private static final String UTF_8 = "UTF-8";
    private final String defaultEncoding;
    private final String encoding;
    private final Reader reader;
    private static final ByteOrderMark[] BOMS = {ByteOrderMark.UTF_8, ByteOrderMark.UTF_16BE, ByteOrderMark.UTF_16LE, ByteOrderMark.UTF_32BE, ByteOrderMark.UTF_32LE};
    private static final String UTF_32BE = "UTF-32BE";
    private static final String UTF_32LE = "UTF-32LE";
    private static final String EBCDIC = "CP1047";
    private static final ByteOrderMark[] XML_GUESS_BYTES = {new ByteOrderMark("UTF-8", 60, 63, 120, 109), new ByteOrderMark("UTF-16BE", 0, 60, 0, 63), new ByteOrderMark("UTF-16LE", 60, 0, 63, 0), new ByteOrderMark(UTF_32BE, 0, 0, 0, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109), new ByteOrderMark(UTF_32LE, 60, 0, 0, 0, 63, 0, 0, 0, 120, 0, 0, 0, 109, 0, 0, 0), new ByteOrderMark(EBCDIC, 76, 111, 167, 148)};
    private static final Pattern CHARSET_PATTERN = Pattern.compile("charset=[\"']?([.[^; \"']]*)[\"']?");
    public static final Pattern ENCODING_PATTERN = Pattern.compile("<\\?xml.*encoding[\\s]*=[\\s]*((?:\".[^\"]*\")|(?:'.[^']*'))", 8);

    public XmlStreamReader(File file) throws IOException {
        this(new FileInputStream(file));
    }

    private String doHttpStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, String str, boolean z16) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateHttpEncoding(str, bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2), z16);
        } catch (XmlStreamReaderException e16) {
            if (z16) {
                return doLenientDetection(str, e16);
            }
            throw e16;
        }
    }

    private String doLenientDetection(String str, XmlStreamReaderException xmlStreamReaderException) throws IOException {
        if (str != null && str.startsWith("text/html")) {
            try {
                return calculateHttpEncoding(MediaType.TEXT_XML_VALUE + str.substring(9), xmlStreamReaderException.getBomEncoding(), xmlStreamReaderException.getXmlGuessEncoding(), xmlStreamReaderException.getXmlEncoding(), true);
            } catch (XmlStreamReaderException e16) {
                xmlStreamReaderException = e16;
            }
        }
        String xmlEncoding = xmlStreamReaderException.getXmlEncoding();
        if (xmlEncoding == null) {
            xmlEncoding = xmlStreamReaderException.getContentTypeEncoding();
        }
        if (xmlEncoding == null) {
            String str2 = this.defaultEncoding;
            if (str2 == null) {
                return "UTF-8";
            }
            return str2;
        }
        return xmlEncoding;
    }

    private String doRawStream(BOMInputStream bOMInputStream, BOMInputStream bOMInputStream2, boolean z16) throws IOException {
        String bOMCharsetName = bOMInputStream.getBOMCharsetName();
        String bOMCharsetName2 = bOMInputStream2.getBOMCharsetName();
        try {
            return calculateRawEncoding(bOMCharsetName, bOMCharsetName2, getXmlProlog(bOMInputStream2, bOMCharsetName2));
        } catch (XmlStreamReaderException e16) {
            if (z16) {
                return doLenientDetection(null, e16);
            }
            throw e16;
        }
    }

    static String getContentTypeEncoding(String str) {
        int indexOf;
        String str2;
        if (str == null || (indexOf = str.indexOf(";")) <= -1) {
            return null;
        }
        Matcher matcher = CHARSET_PATTERN.matcher(str.substring(indexOf + 1));
        if (matcher.find()) {
            str2 = matcher.group(1);
        } else {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        return str2.toUpperCase(Locale.US);
    }

    static String getContentTypeMime(String str) {
        if (str != null) {
            int indexOf = str.indexOf(";");
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            return str.trim();
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0039, code lost:
    
        throw new java.io.IOException("Unexpected end of XML stream");
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0057, code lost:
    
        throw new java.io.IOException("XML prolog or ROOT element not found on first " + r7 + " bytes");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x002f, code lost:
    
        if (r3 != (-1)) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String getXmlProlog(InputStream inputStream, String str) throws IOException {
        if (str != null) {
            byte[] bArr = new byte[4096];
            inputStream.mark(4096);
            int read = inputStream.read(bArr, 0, 4096);
            String str2 = "";
            int i3 = 4096;
            int i16 = 0;
            int i17 = -1;
            while (read != -1 && i17 == -1 && i16 < 4096) {
                i16 += read;
                i3 -= read;
                read = inputStream.read(bArr, i16, i3);
                str2 = new String(bArr, 0, i16, str);
                i17 = str2.indexOf(62);
            }
            if (i16 > 0) {
                inputStream.reset();
                BufferedReader bufferedReader = new BufferedReader(new StringReader(str2.substring(0, i17 + 1)));
                StringBuffer stringBuffer = new StringBuffer();
                for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                    stringBuffer.append(readLine);
                }
                Matcher matcher = ENCODING_PATTERN.matcher(stringBuffer);
                if (matcher.find()) {
                    String upperCase = matcher.group(1).toUpperCase();
                    return upperCase.substring(1, upperCase.length() - 1);
                }
            }
        }
        return null;
    }

    static boolean isAppXml(String str) {
        if (str != null && (str.equals(MediaType.APPLICATION_XML_VALUE) || str.equals("application/xml-dtd") || str.equals("application/xml-external-parsed-entity") || (str.startsWith("application/") && str.endsWith("+xml")))) {
            return true;
        }
        return false;
    }

    static boolean isTextXml(String str) {
        if (str != null && (str.equals(MediaType.TEXT_XML_VALUE) || str.equals("text/xml-external-parsed-entity") || (str.startsWith("text/") && str.endsWith("+xml")))) {
            return true;
        }
        return false;
    }

    String calculateHttpEncoding(String str, String str2, String str3, String str4, boolean z16) throws IOException {
        if (z16 && str4 != null) {
            return str4;
        }
        String contentTypeMime = getContentTypeMime(str);
        String contentTypeEncoding = getContentTypeEncoding(str);
        boolean isAppXml = isAppXml(contentTypeMime);
        boolean isTextXml = isTextXml(contentTypeMime);
        if (!isAppXml && !isTextXml) {
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_3, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
        }
        if (contentTypeEncoding == null) {
            if (isAppXml) {
                return calculateRawEncoding(str2, str3, str4);
            }
            String str5 = this.defaultEncoding;
            if (str5 == null) {
                return "US-ASCII";
            }
            return str5;
        }
        if (!contentTypeEncoding.equals("UTF-16BE") && !contentTypeEncoding.equals("UTF-16LE")) {
            if (contentTypeEncoding.equals("UTF-16")) {
                if (str2 != null && str2.startsWith("UTF-16")) {
                    return str2;
                }
                throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
            }
            if (!contentTypeEncoding.equals(UTF_32BE) && !contentTypeEncoding.equals(UTF_32LE)) {
                if (contentTypeEncoding.equals(UTF_32)) {
                    if (str2 != null && str2.startsWith(UTF_32)) {
                        return str2;
                    }
                    throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_2, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
                }
                return contentTypeEncoding;
            }
            if (str2 == null) {
                return contentTypeEncoding;
            }
            throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
        }
        if (str2 == null) {
            return contentTypeEncoding;
        }
        throw new XmlStreamReaderException(MessageFormat.format(HTTP_EX_1, contentTypeMime, contentTypeEncoding, str2, str3, str4), contentTypeMime, contentTypeEncoding, str2, str3, str4);
    }

    String calculateRawEncoding(String str, String str2, String str3) throws IOException {
        if (str == null) {
            if (str2 != null && str3 != null) {
                if (str3.equals("UTF-16") && (str2.equals("UTF-16BE") || str2.equals("UTF-16LE"))) {
                    return str2;
                }
                return str3;
            }
            String str4 = this.defaultEncoding;
            if (str4 == null) {
                return "UTF-8";
            }
            return str4;
        }
        if (str.equals("UTF-8")) {
            if (str2 != null && !str2.equals("UTF-8")) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals("UTF-8")) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            return str;
        }
        if (!str.equals("UTF-16BE") && !str.equals("UTF-16LE")) {
            if (!str.equals(UTF_32BE) && !str.equals(UTF_32LE)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_2, str, str2, str3), str, str2, str3);
            }
            if (str2 != null && !str2.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            if (str3 != null && !str3.equals(UTF_32) && !str3.equals(str)) {
                throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
            }
            return str;
        }
        if (str2 != null && !str2.equals(str)) {
            throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
        }
        if (str3 != null && !str3.equals("UTF-16") && !str3.equals(str)) {
            throw new XmlStreamReaderException(MessageFormat.format(RAW_EX_1, str, str2, str3), str, str2, str3);
        }
        return str;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.reader.close();
    }

    public String getDefaultEncoding() {
        return this.defaultEncoding;
    }

    public String getEncoding() {
        return this.encoding;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i3, int i16) throws IOException {
        return this.reader.read(cArr, i3, i16);
    }

    public XmlStreamReader(InputStream inputStream) throws IOException {
        this(inputStream, true);
    }

    public XmlStreamReader(InputStream inputStream, boolean z16) throws IOException {
        this(inputStream, z16, (String) null);
    }

    public XmlStreamReader(InputStream inputStream, boolean z16, String str) throws IOException {
        this.defaultEncoding = str;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 4096), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        String doRawStream = doRawStream(bOMInputStream, bOMInputStream2, z16);
        this.encoding = doRawStream;
        this.reader = new InputStreamReader(bOMInputStream2, doRawStream);
    }

    public XmlStreamReader(URL url) throws IOException {
        this(url.openConnection(), (String) null);
    }

    public XmlStreamReader(URLConnection uRLConnection, String str) throws IOException {
        this.defaultEncoding = str;
        String contentType = uRLConnection.getContentType();
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(uRLConnection.getInputStream(), 4096), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        if (!(uRLConnection instanceof HttpURLConnection) && contentType == null) {
            this.encoding = doRawStream(bOMInputStream, bOMInputStream2, true);
        } else {
            this.encoding = doHttpStream(bOMInputStream, bOMInputStream2, contentType, true);
        }
        this.reader = new InputStreamReader(bOMInputStream2, this.encoding);
    }

    public XmlStreamReader(InputStream inputStream, String str) throws IOException {
        this(inputStream, str, true);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z16, String str2) throws IOException {
        this.defaultEncoding = str2;
        BOMInputStream bOMInputStream = new BOMInputStream(new BufferedInputStream(inputStream, 4096), false, BOMS);
        BOMInputStream bOMInputStream2 = new BOMInputStream(bOMInputStream, true, XML_GUESS_BYTES);
        String doHttpStream = doHttpStream(bOMInputStream, bOMInputStream2, str, z16);
        this.encoding = doHttpStream;
        this.reader = new InputStreamReader(bOMInputStream2, doHttpStream);
    }

    public XmlStreamReader(InputStream inputStream, String str, boolean z16) throws IOException {
        this(inputStream, str, z16, null);
    }
}
