package org.apache.commons.fileupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.NoSuchElementException;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.MultipartStream;
import org.apache.commons.fileupload.util.Closeable;
import org.apache.commons.fileupload.util.FileItemHeadersImpl;
import org.apache.commons.fileupload.util.LimitedInputStream;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.IOUtils;

/* compiled from: P */
/* loaded from: classes29.dex */
public abstract class FileUploadBase {
    public static final String ATTACHMENT = "attachment";
    public static final String CONTENT_DISPOSITION = "Content-disposition";
    public static final String CONTENT_LENGTH = "Content-length";
    public static final String CONTENT_TYPE = "Content-type";
    public static final String FORM_DATA = "form-data";

    @Deprecated
    public static final int MAX_HEADER_SIZE = 1024;
    public static final String MULTIPART = "multipart/";
    public static final String MULTIPART_FORM_DATA = "multipart/form-data";
    public static final String MULTIPART_MIXED = "multipart/mixed";
    private String headerEncoding;
    private ProgressListener listener;
    private long sizeMax = -1;
    private long fileSizeMax = -1;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes29.dex */
    public class FileItemIteratorImpl implements FileItemIterator {
        private final byte[] boundary;
        private String currentFieldName;
        private FileItemStreamImpl currentItem;
        private boolean eof;
        private boolean itemValid;
        private final MultipartStream multi;
        private final MultipartStream.ProgressNotifier notifier;
        private boolean skipPreamble;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes29.dex */
        public class FileItemStreamImpl implements FileItemStream {
            private final String contentType;
            private final String fieldName;
            private final boolean formField;
            private FileItemHeaders headers;
            private final String name;
            private boolean opened;
            private final InputStream stream;

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r8v1, types: [org.apache.commons.fileupload.FileUploadBase$FileItemIteratorImpl$FileItemStreamImpl$1] */
            FileItemStreamImpl(String str, String str2, String str3, boolean z16, long j3) throws IOException {
                this.name = str;
                this.fieldName = str2;
                this.contentType = str3;
                this.formField = z16;
                if (FileUploadBase.this.fileSizeMax != -1 && j3 != -1 && j3 > FileUploadBase.this.fileSizeMax) {
                    FileSizeLimitExceededException fileSizeLimitExceededException = new FileSizeLimitExceededException(String.format("The field %s exceeds its maximum permitted size of %s bytes.", str2, Long.valueOf(FileUploadBase.this.fileSizeMax)), j3, FileUploadBase.this.fileSizeMax);
                    fileSizeLimitExceededException.setFileName(str);
                    fileSizeLimitExceededException.setFieldName(str2);
                    throw new FileUploadIOException(fileSizeLimitExceededException);
                }
                final MultipartStream.ItemInputStream newInputStream = FileItemIteratorImpl.this.multi.newInputStream();
                this.stream = FileUploadBase.this.fileSizeMax != -1 ? new LimitedInputStream(newInputStream, FileUploadBase.this.fileSizeMax) { // from class: org.apache.commons.fileupload.FileUploadBase.FileItemIteratorImpl.FileItemStreamImpl.1
                    @Override // org.apache.commons.fileupload.util.LimitedInputStream
                    protected void raiseError(long j16, long j17) throws IOException {
                        newInputStream.close(true);
                        FileSizeLimitExceededException fileSizeLimitExceededException2 = new FileSizeLimitExceededException(String.format("The field %s exceeds its maximum permitted size of %s bytes.", FileItemStreamImpl.this.fieldName, Long.valueOf(j16)), j17, j16);
                        fileSizeLimitExceededException2.setFieldName(FileItemStreamImpl.this.fieldName);
                        fileSizeLimitExceededException2.setFileName(FileItemStreamImpl.this.name);
                        throw new FileUploadIOException(fileSizeLimitExceededException2);
                    }
                } : newInputStream;
            }

            void close() throws IOException {
                this.stream.close();
            }

            @Override // org.apache.commons.fileupload.FileItemStream
            public String getContentType() {
                return this.contentType;
            }

            @Override // org.apache.commons.fileupload.FileItemStream
            public String getFieldName() {
                return this.fieldName;
            }

            @Override // org.apache.commons.fileupload.FileItemHeadersSupport
            public FileItemHeaders getHeaders() {
                return this.headers;
            }

            @Override // org.apache.commons.fileupload.FileItemStream
            public String getName() {
                return Streams.checkFileName(this.name);
            }

            @Override // org.apache.commons.fileupload.FileItemStream
            public boolean isFormField() {
                return this.formField;
            }

            @Override // org.apache.commons.fileupload.FileItemStream
            public InputStream openStream() throws IOException {
                if (!this.opened) {
                    if (!((Closeable) this.stream).isClosed()) {
                        return this.stream;
                    }
                    throw new FileItemStream.ItemSkippedException();
                }
                throw new IllegalStateException("The stream was already opened.");
            }

            @Override // org.apache.commons.fileupload.FileItemHeadersSupport
            public void setHeaders(FileItemHeaders fileItemHeaders) {
                this.headers = fileItemHeaders;
            }
        }

        FileItemIteratorImpl(RequestContext requestContext) throws FileUploadException, IOException {
            long j3;
            InputStream inputStream;
            if (requestContext != null) {
                String contentType = requestContext.getContentType();
                if (contentType != null && contentType.toLowerCase(Locale.ENGLISH).startsWith(FileUploadBase.MULTIPART)) {
                    int contentLength = requestContext.getContentLength();
                    if (UploadContext.class.isAssignableFrom(requestContext.getClass())) {
                        j3 = ((UploadContext) requestContext).contentLength();
                    } else {
                        j3 = contentLength;
                    }
                    long j16 = j3;
                    if (FileUploadBase.this.sizeMax >= 0) {
                        if (j16 != -1 && j16 > FileUploadBase.this.sizeMax) {
                            throw new SizeLimitExceededException(String.format("the request was rejected because its size (%s) exceeds the configured maximum (%s)", Long.valueOf(j16), Long.valueOf(FileUploadBase.this.sizeMax)), j16, FileUploadBase.this.sizeMax);
                        }
                        inputStream = new LimitedInputStream(requestContext.getInputStream(), FileUploadBase.this.sizeMax) { // from class: org.apache.commons.fileupload.FileUploadBase.FileItemIteratorImpl.1
                            @Override // org.apache.commons.fileupload.util.LimitedInputStream
                            protected void raiseError(long j17, long j18) throws IOException {
                                throw new FileUploadIOException(new SizeLimitExceededException(String.format("the request was rejected because its size (%s) exceeds the configured maximum (%s)", Long.valueOf(j18), Long.valueOf(j17)), j18, j17));
                            }
                        };
                    } else {
                        inputStream = requestContext.getInputStream();
                    }
                    String str = FileUploadBase.this.headerEncoding;
                    str = str == null ? requestContext.getCharacterEncoding() : str;
                    byte[] boundary = FileUploadBase.this.getBoundary(contentType);
                    this.boundary = boundary;
                    if (boundary != null) {
                        MultipartStream.ProgressNotifier progressNotifier = new MultipartStream.ProgressNotifier(FileUploadBase.this.listener, j16);
                        this.notifier = progressNotifier;
                        try {
                            MultipartStream multipartStream = new MultipartStream(inputStream, boundary, progressNotifier);
                            this.multi = multipartStream;
                            multipartStream.setHeaderEncoding(str);
                            this.skipPreamble = true;
                            findNextItem();
                            return;
                        } catch (IllegalArgumentException e16) {
                            IOUtils.closeQuietly(inputStream);
                            throw new InvalidContentTypeException(String.format("The boundary specified in the %s header is too long", FileUploadBase.CONTENT_TYPE), e16);
                        }
                    }
                    IOUtils.closeQuietly(inputStream);
                    throw new FileUploadException("the request was rejected because no multipart boundary was found");
                }
                throw new InvalidContentTypeException(String.format("the request doesn't contain a %s or %s stream, content type header is %s", "multipart/form-data", FileUploadBase.MULTIPART_MIXED, contentType));
            }
            throw new NullPointerException("ctx parameter");
        }

        /* JADX WARN: Code restructure failed: missing block: B:31:0x0075, code lost:
        
            r8 = r14.this$0.getFileName(r0);
            r10 = r0.getHeader(org.apache.commons.fileupload.FileUploadBase.CONTENT_TYPE);
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x0081, code lost:
        
            if (r8 != null) goto L31;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x0083, code lost:
        
            r11 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0086, code lost:
        
            r2 = new org.apache.commons.fileupload.FileUploadBase.FileItemIteratorImpl.FileItemStreamImpl(r14, r8, r9, r10, r11, getContentLength(r0));
            r14.currentItem = r2;
            r2.setHeaders(r0);
            r14.notifier.noteItem();
            r14.itemValid = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x009b, code lost:
        
            return true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0085, code lost:
        
            r11 = false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private boolean findNextItem() throws IOException {
            boolean readBoundary;
            if (this.eof) {
                return false;
            }
            FileItemStreamImpl fileItemStreamImpl = this.currentItem;
            if (fileItemStreamImpl != null) {
                fileItemStreamImpl.close();
                this.currentItem = null;
            }
            while (true) {
                if (this.skipPreamble) {
                    readBoundary = this.multi.skipPreamble();
                } else {
                    readBoundary = this.multi.readBoundary();
                }
                if (!readBoundary) {
                    if (this.currentFieldName == null) {
                        this.eof = true;
                        return false;
                    }
                    this.multi.setBoundary(this.boundary);
                    this.currentFieldName = null;
                } else {
                    FileItemHeaders parsedHeaders = FileUploadBase.this.getParsedHeaders(this.multi.readHeaders());
                    if (this.currentFieldName == null) {
                        String fieldName = FileUploadBase.this.getFieldName(parsedHeaders);
                        if (fieldName != null) {
                            String header = parsedHeaders.getHeader(FileUploadBase.CONTENT_TYPE);
                            if (header == null || !header.toLowerCase(Locale.ENGLISH).startsWith(FileUploadBase.MULTIPART_MIXED)) {
                                break;
                            }
                            this.currentFieldName = fieldName;
                            this.multi.setBoundary(FileUploadBase.this.getBoundary(header));
                            this.skipPreamble = true;
                        }
                    } else {
                        String fileName = FileUploadBase.this.getFileName(parsedHeaders);
                        if (fileName != null) {
                            FileItemStreamImpl fileItemStreamImpl2 = new FileItemStreamImpl(fileName, this.currentFieldName, parsedHeaders.getHeader(FileUploadBase.CONTENT_TYPE), false, getContentLength(parsedHeaders));
                            this.currentItem = fileItemStreamImpl2;
                            fileItemStreamImpl2.setHeaders(parsedHeaders);
                            this.notifier.noteItem();
                            this.itemValid = true;
                            return true;
                        }
                    }
                    this.multi.discardBodyData();
                }
            }
        }

        private long getContentLength(FileItemHeaders fileItemHeaders) {
            try {
                return Long.parseLong(fileItemHeaders.getHeader(FileUploadBase.CONTENT_LENGTH));
            } catch (Exception unused) {
                return -1L;
            }
        }

        @Override // org.apache.commons.fileupload.FileItemIterator
        public boolean hasNext() throws FileUploadException, IOException {
            if (this.eof) {
                return false;
            }
            if (this.itemValid) {
                return true;
            }
            try {
                return findNextItem();
            } catch (FileUploadIOException e16) {
                throw ((FileUploadException) e16.getCause());
            }
        }

        @Override // org.apache.commons.fileupload.FileItemIterator
        public FileItemStream next() throws FileUploadException, IOException {
            if (!this.eof && (this.itemValid || hasNext())) {
                this.itemValid = false;
                return this.currentItem;
            }
            throw new NoSuchElementException();
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class FileSizeLimitExceededException extends SizeException {
        private static final long serialVersionUID = 8150776562029630058L;
        private String fieldName;
        private String fileName;

        public FileSizeLimitExceededException(String str, long j3, long j16) {
            super(str, j3, j16);
        }

        @Override // org.apache.commons.fileupload.FileUploadBase.SizeException
        public /* bridge */ /* synthetic */ long getActualSize() {
            return super.getActualSize();
        }

        public String getFieldName() {
            return this.fieldName;
        }

        public String getFileName() {
            return this.fileName;
        }

        @Override // org.apache.commons.fileupload.FileUploadBase.SizeException
        public /* bridge */ /* synthetic */ long getPermittedSize() {
            return super.getPermittedSize();
        }

        public void setFieldName(String str) {
            this.fieldName = str;
        }

        public void setFileName(String str) {
            this.fileName = str;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class FileUploadIOException extends IOException {
        private static final long serialVersionUID = -7047616958165584154L;
        private final FileUploadException cause;

        public FileUploadIOException(FileUploadException fileUploadException) {
            this.cause = fileUploadException;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class IOFileUploadException extends FileUploadException {
        private static final long serialVersionUID = 1749796615868477269L;
        private final IOException cause;

        public IOFileUploadException(String str, IOException iOException) {
            super(str);
            this.cause = iOException;
        }

        @Override // org.apache.commons.fileupload.FileUploadException, java.lang.Throwable
        public Throwable getCause() {
            return this.cause;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class InvalidContentTypeException extends FileUploadException {
        private static final long serialVersionUID = -9073026332015646668L;

        public InvalidContentTypeException() {
        }

        public InvalidContentTypeException(String str) {
            super(str);
        }

        public InvalidContentTypeException(String str, Throwable th5) {
            super(str, th5);
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    protected static abstract class SizeException extends FileUploadException {
        private static final long serialVersionUID = -8776225574705254126L;
        private final long actual;
        private final long permitted;

        protected SizeException(String str, long j3, long j16) {
            super(str);
            this.actual = j3;
            this.permitted = j16;
        }

        public long getActualSize() {
            return this.actual;
        }

        public long getPermittedSize() {
            return this.permitted;
        }
    }

    /* compiled from: P */
    /* loaded from: classes29.dex */
    public static class SizeLimitExceededException extends SizeException {
        private static final long serialVersionUID = -2474893167098052828L;

        @Deprecated
        public SizeLimitExceededException() {
            this(null, 0L, 0L);
        }

        @Override // org.apache.commons.fileupload.FileUploadBase.SizeException
        public /* bridge */ /* synthetic */ long getActualSize() {
            return super.getActualSize();
        }

        @Override // org.apache.commons.fileupload.FileUploadBase.SizeException
        public /* bridge */ /* synthetic */ long getPermittedSize() {
            return super.getPermittedSize();
        }

        @Deprecated
        public SizeLimitExceededException(String str) {
            this(str, 0L, 0L);
        }

        public SizeLimitExceededException(String str, long j3, long j16) {
            super(str, j3, j16);
        }
    }

    /* compiled from: P */
    @Deprecated
    /* loaded from: classes29.dex */
    public static class UnknownSizeException extends FileUploadException {
        private static final long serialVersionUID = 7062279004812015273L;

        public UnknownSizeException() {
        }

        public UnknownSizeException(String str) {
            super(str);
        }
    }

    public static final boolean isMultipartContent(RequestContext requestContext) {
        String contentType = requestContext.getContentType();
        if (contentType == null || !contentType.toLowerCase(Locale.ENGLISH).startsWith(MULTIPART)) {
            return false;
        }
        return true;
    }

    private int parseEndOfLine(String str, int i3) {
        int i16;
        while (true) {
            int indexOf = str.indexOf(13, i3);
            if (indexOf == -1 || (i16 = indexOf + 1) >= str.length()) {
                break;
            }
            if (str.charAt(i16) == '\n') {
                return indexOf;
            }
            i3 = i16;
        }
        throw new IllegalStateException("Expected headers to be terminated by an empty line.");
    }

    private void parseHeaderLine(FileItemHeadersImpl fileItemHeadersImpl, String str) {
        int indexOf = str.indexOf(58);
        if (indexOf == -1) {
            return;
        }
        fileItemHeadersImpl.addHeader(str.substring(0, indexOf).trim(), str.substring(str.indexOf(58) + 1).trim());
    }

    @Deprecated
    protected FileItem createItem(Map<String, String> map, boolean z16) throws FileUploadException {
        return getFileItemFactory().createItem(getFieldName(map), getHeader(map, CONTENT_TYPE), z16, getFileName(map));
    }

    protected byte[] getBoundary(String str) {
        ParameterParser parameterParser = new ParameterParser();
        parameterParser.setLowerCaseNames(true);
        String str2 = parameterParser.parse(str, new char[]{';', ','}).get("boundary");
        if (str2 == null) {
            return null;
        }
        try {
            return str2.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException unused) {
            return str2.getBytes();
        }
    }

    protected String getFieldName(FileItemHeaders fileItemHeaders) {
        return getFieldName(fileItemHeaders.getHeader(CONTENT_DISPOSITION));
    }

    public abstract FileItemFactory getFileItemFactory();

    @Deprecated
    protected String getFileName(Map<String, String> map) {
        return getFileName(getHeader(map, CONTENT_DISPOSITION));
    }

    public long getFileSizeMax() {
        return this.fileSizeMax;
    }

    @Deprecated
    protected final String getHeader(Map<String, String> map, String str) {
        return map.get(str.toLowerCase(Locale.ENGLISH));
    }

    public String getHeaderEncoding() {
        return this.headerEncoding;
    }

    public FileItemIterator getItemIterator(RequestContext requestContext) throws FileUploadException, IOException {
        try {
            return new FileItemIteratorImpl(requestContext);
        } catch (FileUploadIOException e16) {
            throw ((FileUploadException) e16.getCause());
        }
    }

    protected FileItemHeaders getParsedHeaders(String str) {
        int length = str.length();
        FileItemHeadersImpl newFileItemHeaders = newFileItemHeaders();
        int i3 = 0;
        while (true) {
            int parseEndOfLine = parseEndOfLine(str, i3);
            if (i3 == parseEndOfLine) {
                return newFileItemHeaders;
            }
            StringBuilder sb5 = new StringBuilder(str.substring(i3, parseEndOfLine));
            i3 = parseEndOfLine + 2;
            while (i3 < length) {
                int i16 = i3;
                while (i16 < length) {
                    char charAt = str.charAt(i16);
                    if (charAt != ' ' && charAt != '\t') {
                        break;
                    }
                    i16++;
                }
                if (i16 == i3) {
                    break;
                }
                int parseEndOfLine2 = parseEndOfLine(str, i16);
                sb5.append(" ");
                sb5.append(str.substring(i16, parseEndOfLine2));
                i3 = parseEndOfLine2 + 2;
            }
            parseHeaderLine(newFileItemHeaders, sb5.toString());
        }
    }

    public ProgressListener getProgressListener() {
        return this.listener;
    }

    public long getSizeMax() {
        return this.sizeMax;
    }

    protected FileItemHeadersImpl newFileItemHeaders() {
        return new FileItemHeadersImpl();
    }

    @Deprecated
    protected Map<String, String> parseHeaders(String str) {
        FileItemHeaders parsedHeaders = getParsedHeaders(str);
        HashMap hashMap = new HashMap();
        Iterator<String> headerNames = parsedHeaders.getHeaderNames();
        while (headerNames.hasNext()) {
            String next = headerNames.next();
            Iterator<String> headers = parsedHeaders.getHeaders(next);
            StringBuilder sb5 = new StringBuilder(headers.next());
            while (headers.hasNext()) {
                sb5.append(",");
                sb5.append(headers.next());
            }
            hashMap.put(next, sb5.toString());
        }
        return hashMap;
    }

    public Map<String, List<FileItem>> parseParameterMap(RequestContext requestContext) throws FileUploadException {
        List<FileItem> parseRequest = parseRequest(requestContext);
        HashMap hashMap = new HashMap(parseRequest.size());
        for (FileItem fileItem : parseRequest) {
            String fieldName = fileItem.getFieldName();
            List list = (List) hashMap.get(fieldName);
            if (list == null) {
                list = new ArrayList();
                hashMap.put(fieldName, list);
            }
            list.add(fileItem);
        }
        return hashMap;
    }

    public List<FileItem> parseRequest(RequestContext requestContext) throws FileUploadException {
        ArrayList arrayList = new ArrayList();
        try {
            try {
                FileItemIterator itemIterator = getItemIterator(requestContext);
                FileItemFactory fileItemFactory = getFileItemFactory();
                if (fileItemFactory != null) {
                    while (itemIterator.hasNext()) {
                        FileItemStream next = itemIterator.next();
                        FileItem createItem = fileItemFactory.createItem(next.getFieldName(), next.getContentType(), next.isFormField(), ((FileItemIteratorImpl.FileItemStreamImpl) next).name);
                        arrayList.add(createItem);
                        try {
                            Streams.copy(next.openStream(), createItem.getOutputStream(), true);
                            createItem.setHeaders(next.getHeaders());
                        } catch (FileUploadIOException e16) {
                            throw ((FileUploadException) e16.getCause());
                        } catch (IOException e17) {
                            throw new IOFileUploadException(String.format("Processing of %s request failed. %s", "multipart/form-data", e17.getMessage()), e17);
                        }
                    }
                    return arrayList;
                }
                throw new NullPointerException("No FileItemFactory has been set.");
            } catch (FileUploadIOException e18) {
                throw ((FileUploadException) e18.getCause());
            } catch (IOException e19) {
                throw new FileUploadException(e19.getMessage(), e19);
            }
        } catch (Throwable th5) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    ((FileItem) it.next()).delete();
                } catch (Exception unused) {
                }
            }
            throw th5;
        }
    }

    public abstract void setFileItemFactory(FileItemFactory fileItemFactory);

    public void setFileSizeMax(long j3) {
        this.fileSizeMax = j3;
    }

    public void setHeaderEncoding(String str) {
        this.headerEncoding = str;
    }

    public void setProgressListener(ProgressListener progressListener) {
        this.listener = progressListener;
    }

    public void setSizeMax(long j3) {
        this.sizeMax = j3;
    }

    private String getFieldName(String str) {
        if (str == null || !str.toLowerCase(Locale.ENGLISH).startsWith(FORM_DATA)) {
            return null;
        }
        ParameterParser parameterParser = new ParameterParser();
        parameterParser.setLowerCaseNames(true);
        String str2 = parameterParser.parse(str, ';').get("name");
        return str2 != null ? str2.trim() : str2;
    }

    protected String getFileName(FileItemHeaders fileItemHeaders) {
        return getFileName(fileItemHeaders.getHeader(CONTENT_DISPOSITION));
    }

    private String getFileName(String str) {
        if (str != null) {
            String lowerCase = str.toLowerCase(Locale.ENGLISH);
            if (lowerCase.startsWith(FORM_DATA) || lowerCase.startsWith(ATTACHMENT)) {
                ParameterParser parameterParser = new ParameterParser();
                parameterParser.setLowerCaseNames(true);
                Map<String, String> parse = parameterParser.parse(str, ';');
                if (parse.containsKey("filename")) {
                    String str2 = parse.get("filename");
                    return str2 != null ? str2.trim() : "";
                }
            }
        }
        return null;
    }

    @Deprecated
    protected String getFieldName(Map<String, String> map) {
        return getFieldName(getHeader(map, CONTENT_DISPOSITION));
    }
}
