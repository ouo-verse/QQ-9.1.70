package org.apache.httpcore.util;

import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.qqlive.tvkplayer.thirdparties.dnsjava.TTL;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;
import org.apache.httpcore.HeaderElement;
import org.apache.httpcore.HttpEntity;
import org.apache.httpcore.HttpResponse;
import org.apache.httpcore.NameValuePair;
import org.apache.httpcore.ParseException;
import org.apache.httpcore.entity.ContentType;
import org.apache.httpcore.protocol.HTTP;

/* compiled from: P */
/* loaded from: classes29.dex */
public final class EntityUtils {
    private static final int DEFAULT_BUFFER_SIZE = 4096;

    EntityUtils() {
    }

    public static void consume(HttpEntity httpEntity) throws IOException {
        InputStream content;
        if (httpEntity != null && httpEntity.isStreaming() && (content = httpEntity.getContent()) != null) {
            content.close();
        }
    }

    public static void consumeQuietly(HttpEntity httpEntity) {
        try {
            consume(httpEntity);
        } catch (IOException unused) {
        }
    }

    @Deprecated
    public static String getContentCharSet(HttpEntity httpEntity) throws ParseException {
        NameValuePair parameterByName;
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() != null) {
            HeaderElement[] elements = httpEntity.getContentType().getElements();
            if (elements.length > 0 && (parameterByName = elements[0].getParameterByName(HttpMsg.CHARSET)) != null) {
                return parameterByName.getValue();
            }
        }
        return null;
    }

    @Deprecated
    public static String getContentMimeType(HttpEntity httpEntity) throws ParseException {
        Args.notNull(httpEntity, "Entity");
        if (httpEntity.getContentType() != null) {
            HeaderElement[] elements = httpEntity.getContentType().getElements();
            if (elements.length > 0) {
                return elements[0].getName();
            }
        }
        return null;
    }

    public static byte[] toByteArray(HttpEntity httpEntity) throws IOException {
        boolean z16;
        Args.notNull(httpEntity, "Entity");
        InputStream content = httpEntity.getContent();
        if (content == null) {
            return null;
        }
        try {
            if (httpEntity.getContentLength() <= TTL.MAX_VALUE) {
                z16 = true;
            } else {
                z16 = false;
            }
            Args.check(z16, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength < 0) {
                contentLength = 4096;
            }
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(contentLength);
            byte[] bArr = new byte[4096];
            while (true) {
                int read = content.read(bArr);
                if (read != -1) {
                    byteArrayBuffer.append(bArr, 0, read);
                } else {
                    return byteArrayBuffer.toByteArray();
                }
            }
        } finally {
            content.close();
        }
    }

    private static String toString(HttpEntity httpEntity, ContentType contentType) throws IOException {
        InputStream content = httpEntity.getContent();
        Charset charset = null;
        if (content == null) {
            return null;
        }
        try {
            Args.check(httpEntity.getContentLength() <= TTL.MAX_VALUE, "HTTP entity too large to be buffered in memory");
            int contentLength = (int) httpEntity.getContentLength();
            if (contentLength < 0) {
                contentLength = 4096;
            }
            if (contentType != null) {
                Charset charset2 = contentType.getCharset();
                if (charset2 == null) {
                    ContentType byMimeType = ContentType.getByMimeType(contentType.getMimeType());
                    if (byMimeType != null) {
                        charset = byMimeType.getCharset();
                    }
                } else {
                    charset = charset2;
                }
            }
            if (charset == null) {
                charset = HTTP.DEF_CONTENT_CHARSET;
            }
            InputStreamReader inputStreamReader = new InputStreamReader(content, charset);
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(contentLength);
            char[] cArr = new char[1024];
            while (true) {
                int read = inputStreamReader.read(cArr);
                if (read != -1) {
                    charArrayBuffer.append(cArr, 0, read);
                } else {
                    return charArrayBuffer.toString();
                }
            }
        } finally {
            content.close();
        }
    }

    public static void updateEntity(HttpResponse httpResponse, HttpEntity httpEntity) throws IOException {
        Args.notNull(httpResponse, "Response");
        consume(httpResponse.getEntity());
        httpResponse.setEntity(httpEntity);
    }

    public static String toString(HttpEntity httpEntity, Charset charset) throws IOException, ParseException {
        ContentType contentType;
        Args.notNull(httpEntity, "Entity");
        try {
            contentType = ContentType.get(httpEntity);
        } catch (UnsupportedCharsetException e16) {
            if (charset == null) {
                throw new UnsupportedEncodingException(e16.getMessage());
            }
            contentType = null;
        }
        if (contentType != null) {
            if (contentType.getCharset() == null) {
                contentType = contentType.withCharset(charset);
            }
        } else {
            contentType = ContentType.DEFAULT_TEXT.withCharset(charset);
        }
        return toString(httpEntity, contentType);
    }

    public static String toString(HttpEntity httpEntity, String str) throws IOException, ParseException {
        return toString(httpEntity, str != null ? Charset.forName(str) : null);
    }

    public static String toString(HttpEntity httpEntity) throws IOException, ParseException {
        Args.notNull(httpEntity, "Entity");
        return toString(httpEntity, ContentType.get(httpEntity));
    }
}
