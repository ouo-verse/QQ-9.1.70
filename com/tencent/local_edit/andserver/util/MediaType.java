package com.tencent.local_edit.andserver.util;

import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import com.tencent.local_edit.andserver.error.InvalidMediaTypeException;
import com.tencent.local_edit.andserver.error.InvalidMimeTypeException;
import com.tencent.local_edit.andserver.util.MimeType;
import com.tencent.local_edit.andserver.util.comparator.CompoundComparator;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

/* compiled from: P */
/* loaded from: classes7.dex */
public class MediaType extends MimeType {
    public static final String ALL_VALUE = "*/*";
    public static final String APPLICATION_FORM_URLENCODED_VALUE = "application/x-www-form-urlencoded";
    public static final String APPLICATION_JSON_VALUE = "application/json";
    public static final String APPLICATION_OCTET_STREAM_VALUE = "application/octet-stream";
    public static final String APPLICATION_XHTML_XML_VALUE = "application/xhtml+xml";
    public static final String IMAGE_GIF_VALUE = "image/gif";
    public static final String IMAGE_JPEG_VALUE = "image/jpeg";
    public static final String IMAGE_PNG_VALUE = "image/png";
    public static final String MULTIPART_FORM_DATA_VALUE = "multipart/form-data";
    public static final String TEXT_HTML_VALUE = "text/html";
    public static final String TEXT_PLAIN_VALUE = "text/plain";
    public static final MediaType ALL = valueOf("*/*");
    public static final MediaType APPLICATION_JSON = valueOf("application/json");
    public static final String APPLICATION_JSON_UTF8_VALUE = "application/json;charset=UTF-8";
    public static final MediaType APPLICATION_JSON_UTF8 = valueOf(APPLICATION_JSON_UTF8_VALUE);
    public static final String APPLICATION_XML_VALUE = "application/xml";
    public static final MediaType APPLICATION_XML = valueOf(APPLICATION_XML_VALUE);
    public static final String APPLICATION_XML_UTF8_VALUE = "application/xml;charset=UTF-8";
    public static final MediaType APPLICATION_XML_UTF8 = valueOf(APPLICATION_XML_UTF8_VALUE);
    public static final String APPLICATION_ATOM_XML_VALUE = "application/atom+xml";
    public static final MediaType APPLICATION_ATOM_XML = valueOf(APPLICATION_ATOM_XML_VALUE);
    public static final MediaType APPLICATION_FORM_URLENCODED = valueOf("application/x-www-form-urlencoded");
    public static final MediaType APPLICATION_OCTET_STREAM = valueOf("application/octet-stream");
    public static final String APPLICATION_RSS_XML_VALUE = "application/rss+xml";
    public static final MediaType APPLICATION_RSS_XML = valueOf(APPLICATION_RSS_XML_VALUE);
    public static final MediaType APPLICATION_XHTML_XML = valueOf("application/xhtml+xml");
    public static final String APPLICATION_PDF_VALUE = "application/pdf";
    public static final MediaType APPLICATION_PDF = valueOf(APPLICATION_PDF_VALUE);
    public static final MediaType IMAGE_GIF = valueOf("image/gif");
    public static final MediaType IMAGE_JPEG = valueOf("image/jpeg");
    public static final MediaType IMAGE_PNG = valueOf("image/png");
    public static final MediaType MULTIPART_FORM_DATA = valueOf("multipart/form-data");
    public static final String TEXT_EVENT_STREAM_VALUE = "text/event-stream";
    public static final MediaType TEXT_EVENT_STREAM = valueOf(TEXT_EVENT_STREAM_VALUE);
    public static final MediaType TEXT_HTML = valueOf("text/html");
    public static final String TEXT_MARKDOWN_VALUE = "text/markdown";
    public static final MediaType TEXT_MARKDOWN = valueOf(TEXT_MARKDOWN_VALUE);
    public static final MediaType TEXT_PLAIN = valueOf("text/plain");
    public static final String TEXT_XML_VALUE = "text/xml";
    public static final MediaType TEXT_XML = valueOf(TEXT_XML_VALUE);
    public static final Comparator<MediaType> QUALITY_VALUE_COMPARATOR = new a();
    public static final Comparator<MediaType> SPECIFICITY_COMPARATOR = new b();

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class a implements Comparator<MediaType> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MediaType mediaType, MediaType mediaType2) {
            int compare = Double.compare(mediaType2.getQualityValue(), mediaType.getQualityValue());
            if (compare != 0) {
                return compare;
            }
            if (mediaType.isWildcardType() && !mediaType2.isWildcardType()) {
                return 1;
            }
            if (mediaType2.isWildcardType() && !mediaType.isWildcardType()) {
                return -1;
            }
            if (!mediaType.getType().equals(mediaType2.getType())) {
                return 0;
            }
            if (mediaType.isWildcardSubtype() && !mediaType2.isWildcardSubtype()) {
                return 1;
            }
            if (mediaType2.isWildcardSubtype() && !mediaType.isWildcardSubtype()) {
                return -1;
            }
            if (!mediaType.getSubtype().equals(mediaType2.getSubtype())) {
                return 0;
            }
            int size = mediaType.getParameters().size();
            int size2 = mediaType2.getParameters().size();
            if (size2 < size) {
                return -1;
            }
            if (size2 != size) {
                return 1;
            }
            return 0;
        }
    }

    /* compiled from: P */
    /* loaded from: classes7.dex */
    class b extends MimeType.a<MediaType> {
        b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.tencent.local_edit.andserver.util.MimeType.a
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public int b(MediaType mediaType, MediaType mediaType2) {
            int compare = Double.compare(mediaType2.getQualityValue(), mediaType.getQualityValue());
            if (compare != 0) {
                return compare;
            }
            return super.b(mediaType, mediaType2);
        }
    }

    public MediaType(String str) {
        super(str);
    }

    public static MediaType getFileMediaType(String str) {
        String urlExtension = getUrlExtension(str);
        if (!MimeTypeMap.getSingleton().hasExtension(urlExtension)) {
            return APPLICATION_OCTET_STREAM;
        }
        try {
            return parseMediaType(MimeTypeMap.getSingleton().getMimeTypeFromExtension(urlExtension));
        } catch (Exception unused) {
            return APPLICATION_OCTET_STREAM;
        }
    }

    public static String getUrlExtension(String str) {
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(str);
        if (TextUtils.isEmpty(fileExtensionFromUrl)) {
            return "";
        }
        return fileExtensionFromUrl;
    }

    public static MediaType parseMediaType(String str) {
        try {
            MimeType valueOf = MimeType.valueOf(str);
            try {
                return new MediaType(valueOf.getType(), valueOf.getSubtype(), valueOf.getParameters());
            } catch (IllegalArgumentException e16) {
                throw new InvalidMediaTypeException(str, e16.getMessage());
            }
        } catch (InvalidMimeTypeException e17) {
            throw new InvalidMediaTypeException(e17);
        }
    }

    public static List<MediaType> parseMediaTypes(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.emptyList();
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        ArrayList arrayList = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if (trim.length() > 0) {
                arrayList.add(trim);
            }
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(parseMediaType((String) it.next()));
        }
        return arrayList2;
    }

    public static void sortByQualityValue(List<MediaType> list) {
        com.tencent.local_edit.andserver.util.a.c(list, "'mediaTypes' must not be null");
        if (list.size() > 1) {
            Collections.sort(list, QUALITY_VALUE_COMPARATOR);
        }
    }

    public static void sortBySpecificity(List<MediaType> list) {
        com.tencent.local_edit.andserver.util.a.c(list, "'mediaTypes' must not be null");
        if (list.size() > 1) {
            Collections.sort(list, SPECIFICITY_COMPARATOR);
        }
    }

    public static void sortBySpecificityAndQuality(List<MediaType> list) {
        com.tencent.local_edit.andserver.util.a.c(list, "'mediaTypes' must not be null");
        if (list.size() > 1) {
            Collections.sort(list, new CompoundComparator(SPECIFICITY_COMPARATOR, QUALITY_VALUE_COMPARATOR));
        }
    }

    public static MediaType valueOf(String str) {
        return parseMediaType(str);
    }

    @Override // com.tencent.local_edit.andserver.util.MimeType
    protected void checkParameters(String str, String str2) {
        boolean z16;
        super.checkParameters(str, str2);
        if (QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB.equals(str)) {
            String unquote = unquote(str2);
            double parseDouble = Double.parseDouble(unquote);
            String str3 = "Invalid quality value '" + unquote + "': should be between 0.0 and 1.0";
            if (parseDouble >= 0.0d && parseDouble <= 1.0d) {
                z16 = true;
            } else {
                z16 = false;
            }
            com.tencent.local_edit.andserver.util.a.b(z16, str3);
        }
    }

    public MediaType copyQualityValue(MediaType mediaType) {
        if (!mediaType.getParameters().containsKey(QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB)) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(getParameters());
        linkedHashMap.put(QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, mediaType.getParameters().get(QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB));
        return new MediaType(this, linkedHashMap);
    }

    public double getQualityValue() {
        String parameter = getParameter(QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB);
        if (parameter != null) {
            return Double.parseDouble(unquote(parameter));
        }
        return 1.0d;
    }

    public boolean includes(MediaType mediaType) {
        return super.includes((MimeType) mediaType);
    }

    public boolean isCompatibleWith(MediaType mediaType) {
        return super.isCompatibleWith((MimeType) mediaType);
    }

    public MediaType removeQualityValue() {
        if (!getParameters().containsKey(QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB)) {
            return this;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(getParameters());
        linkedHashMap.remove(QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB);
        return new MediaType(this, linkedHashMap);
    }

    public MediaType(String str, String str2) {
        super(str, str2, (Map<String, String>) Collections.emptyMap());
    }

    public MediaType(String str, String str2, Charset charset) {
        super(str, str2, charset);
    }

    public MediaType(String str, String str2, double d16) {
        this(str, str2, (Map<String, String>) Collections.singletonMap(QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, Double.toString(d16)));
    }

    public MediaType(MediaType mediaType, Charset charset) {
        super(mediaType, charset);
    }

    public MediaType(MediaType mediaType, Map<String, String> map) {
        super(mediaType.getType(), mediaType.getSubtype(), map);
    }

    public MediaType(String str, String str2, Map<String, String> map) {
        super(str, str2, map);
    }

    public static List<MediaType> parseMediaTypes(List<String> list) {
        if (list != null && !list.isEmpty()) {
            if (list.size() == 1) {
                return parseMediaTypes(list.get(0));
            }
            ArrayList arrayList = new ArrayList(8);
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.addAll(parseMediaTypes(it.next()));
            }
            return arrayList;
        }
        return Collections.emptyList();
    }
}
