package com.nostra13.universalimageloader.core.download;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.webkit.MimeTypeMap;
import com.nostra13.universalimageloader.core.assist.ContentLengthInputStream;
import com.nostra13.universalimageloader.core.download.ImageDownloader;
import com.nostra13.universalimageloader.utils.IoUtils;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/* compiled from: P */
/* loaded from: classes2.dex */
public class BaseImageDownloader implements ImageDownloader {
    protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    protected static final int BUFFER_SIZE = 32768;
    protected static final String CONTENT_CONTACTS_URI_PREFIX = "content://com.android.contacts/";
    public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5000;
    public static final int DEFAULT_HTTP_READ_TIMEOUT = 20000;
    private static final String ERROR_UNSUPPORTED_SCHEME = "UIL doesn't support scheme(protocol) by default [%s]. You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
    protected static final int MAX_REDIRECT_COUNT = 5;
    protected final int connectTimeout;
    protected final Context context;
    protected final int readTimeout;

    /* compiled from: P */
    /* renamed from: com.nostra13.universalimageloader.core.download.BaseImageDownloader$1, reason: invalid class name */
    /* loaded from: classes2.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme;

        static {
            int[] iArr = new int[ImageDownloader.Scheme.values().length];
            $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme = iArr;
            try {
                iArr[ImageDownloader.Scheme.HTTP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.HTTPS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.FILE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.CONTENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ASSETS.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.DRAWABLE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.UNKNOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    public BaseImageDownloader(Context context) {
        this(context, 5000, 20000);
    }

    @TargetApi(8)
    private InputStream getVideoThumbnailStream(String str) {
        Bitmap createVideoThumbnail = ThumbnailUtils.createVideoThumbnail(str, 2);
        if (createVideoThumbnail != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createVideoThumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
            return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        }
        return null;
    }

    private boolean isVideoContentUri(Uri uri) {
        String type = this.context.getContentResolver().getType(uri);
        if (type != null && type.startsWith("video/")) {
            return true;
        }
        return false;
    }

    private boolean isVideoFileUri(String str) {
        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(Uri.encode(str)));
        if (mimeTypeFromExtension != null && mimeTypeFromExtension.startsWith("video/")) {
            return true;
        }
        return false;
    }

    protected HttpURLConnection createConnection(String str, Object obj) throws IOException {
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(Uri.encode(str, ALLOWED_URI_CHARS)).openConnection();
        httpURLConnection.setConnectTimeout(this.connectTimeout);
        httpURLConnection.setReadTimeout(this.readTimeout);
        return httpURLConnection;
    }

    @TargetApi(14)
    protected InputStream getContactPhotoStream(Uri uri) {
        return ContactsContract.Contacts.openContactPhotoInputStream(this.context.getContentResolver(), uri, true);
    }

    @Override // com.nostra13.universalimageloader.core.download.ImageDownloader
    public InputStream getStream(String str, Object obj) throws IOException {
        switch (AnonymousClass1.$SwitchMap$com$nostra13$universalimageloader$core$download$ImageDownloader$Scheme[ImageDownloader.Scheme.ofUri(str).ordinal()]) {
            case 1:
            case 2:
                return getStreamFromNetwork(str, obj);
            case 3:
                return getStreamFromFile(str, obj);
            case 4:
                return getStreamFromContent(str, obj);
            case 5:
                return getStreamFromAssets(str, obj);
            case 6:
                return getStreamFromDrawable(str, obj);
            default:
                return getStreamFromOtherSource(str, obj);
        }
    }

    protected InputStream getStreamFromAssets(String str, Object obj) throws IOException {
        return this.context.getAssets().open(ImageDownloader.Scheme.ASSETS.crop(str));
    }

    protected InputStream getStreamFromContent(String str, Object obj) throws FileNotFoundException {
        ContentResolver contentResolver = this.context.getContentResolver();
        Uri parse = Uri.parse(str);
        if (isVideoContentUri(parse)) {
            Bitmap thumbnail = MediaStore.Video.Thumbnails.getThumbnail(contentResolver, Long.valueOf(parse.getLastPathSegment()).longValue(), 1, null);
            if (thumbnail != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                thumbnail.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                return new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            }
        } else if (str.startsWith(CONTENT_CONTACTS_URI_PREFIX)) {
            return getContactPhotoStream(parse);
        }
        return contentResolver.openInputStream(parse);
    }

    protected InputStream getStreamFromDrawable(String str, Object obj) {
        return this.context.getResources().openRawResource(Integer.parseInt(ImageDownloader.Scheme.DRAWABLE.crop(str)));
    }

    protected InputStream getStreamFromFile(String str, Object obj) throws IOException {
        String crop = ImageDownloader.Scheme.FILE.crop(str);
        if (isVideoFileUri(str)) {
            return getVideoThumbnailStream(crop);
        }
        return new ContentLengthInputStream(new BufferedInputStream(new FileInputStream(crop), 32768), (int) new File(crop).length());
    }

    protected InputStream getStreamFromNetwork(String str, Object obj) throws IOException {
        HttpURLConnection createConnection = createConnection(str, obj);
        for (int i3 = 0; createConnection.getResponseCode() / 100 == 3 && i3 < 5; i3++) {
            createConnection = createConnection(createConnection.getHeaderField("Location"), obj);
        }
        try {
            InputStream inputStream = createConnection.getInputStream();
            if (shouldBeProcessed(createConnection)) {
                return new ContentLengthInputStream(new BufferedInputStream(inputStream, 32768), createConnection.getContentLength());
            }
            IoUtils.closeSilently(inputStream);
            throw new IOException("Image request failed with response code " + createConnection.getResponseCode());
        } catch (IOException e16) {
            IoUtils.readAndCloseStream(createConnection.getErrorStream());
            throw e16;
        }
    }

    protected InputStream getStreamFromOtherSource(String str, Object obj) throws IOException {
        throw new UnsupportedOperationException(String.format(ERROR_UNSUPPORTED_SCHEME, str));
    }

    protected boolean shouldBeProcessed(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection.getResponseCode() == 200) {
            return true;
        }
        return false;
    }

    public BaseImageDownloader(Context context, int i3, int i16) {
        this.context = context.getApplicationContext();
        this.connectTimeout = i3;
        this.readTimeout = i16;
    }
}
