package com.tencent.local_edit.andserver.http.multipart;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.tencent.local_edit.andserver.error.MaxUploadSizeExceededException;
import com.tencent.local_edit.andserver.error.MultipartException;
import com.tencent.local_edit.andserver.util.MediaType;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.Charsets;

/* compiled from: P */
/* loaded from: classes7.dex */
public class f implements d {

    /* renamed from: a, reason: collision with root package name */
    private DiskFileItemFactory f119834a;

    /* renamed from: b, reason: collision with root package name */
    private FileUpload f119835b;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: P */
    /* loaded from: classes7.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        private final com.tencent.local_edit.andserver.util.f<String, b> f119836a;

        /* renamed from: b, reason: collision with root package name */
        private final com.tencent.local_edit.andserver.util.f<String, String> f119837b;

        /* renamed from: c, reason: collision with root package name */
        private final Map<String, String> f119838c;

        public a(com.tencent.local_edit.andserver.util.f<String, b> fVar, com.tencent.local_edit.andserver.util.f<String, String> fVar2, Map<String, String> map) {
            this.f119836a = fVar;
            this.f119837b = fVar2;
            this.f119838c = map;
        }

        public Map<String, String> a() {
            return this.f119838c;
        }

        public com.tencent.local_edit.andserver.util.f<String, b> b() {
            return this.f119836a;
        }

        public com.tencent.local_edit.andserver.util.f<String, String> c() {
            return this.f119837b;
        }
    }

    public f() {
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        this.f119834a = diskFileItemFactory;
        this.f119835b = new FileUpload(diskFileItemFactory);
    }

    @NonNull
    private String e(com.tencent.local_edit.andserver.http.b bVar) {
        MediaType contentType = bVar.getContentType();
        if (contentType == null) {
            return Charsets.toCharset("utf-8").name();
        }
        Charset charset = contentType.getCharset();
        if (charset == null) {
            charset = Charsets.toCharset("utf-8");
        }
        return charset.name();
    }

    private String f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        Charset charset = MediaType.parseMediaType(str).getCharset();
        if (charset != null) {
            return charset.name();
        }
        return str2;
    }

    private a h(com.tencent.local_edit.andserver.http.b bVar) throws MultipartException {
        String e16 = e(bVar);
        FileUpload i3 = i(e16);
        try {
            com.tencent.local_edit.andserver.http.e body = bVar.getBody();
            com.tencent.local_edit.andserver.util.a.c(body, "The body cannot be null.");
            return g(i3.parseRequest(new com.tencent.local_edit.andserver.http.multipart.a(body)), e16);
        } catch (FileUploadBase.FileSizeLimitExceededException e17) {
            throw new MaxUploadSizeExceededException(i3.getFileSizeMax(), e17);
        } catch (FileUploadBase.SizeLimitExceededException e18) {
            throw new MaxUploadSizeExceededException(i3.getSizeMax(), e18);
        } catch (FileUploadException e19) {
            throw new MultipartException("Failed to parse multipart servlet request.", e19);
        }
    }

    private FileUpload i(@NonNull String str) {
        FileUpload fileUpload = this.f119835b;
        if (!str.equalsIgnoreCase(fileUpload.getHeaderEncoding())) {
            FileUpload fileUpload2 = new FileUpload(this.f119834a);
            fileUpload2.setSizeMax(this.f119835b.getSizeMax());
            fileUpload2.setFileSizeMax(this.f119835b.getFileSizeMax());
            fileUpload2.setHeaderEncoding(str);
            return fileUpload2;
        }
        return fileUpload;
    }

    @Override // com.tencent.local_edit.andserver.http.multipart.d
    public void a(c cVar) {
        if (cVar != null) {
            try {
                Iterator<b> it = cVar.c().values().iterator();
                while (it.hasNext()) {
                    for (b bVar : (List) it.next()) {
                        if (bVar instanceof StandardMultipartFile) {
                            ((StandardMultipartFile) bVar).getFileItem().delete();
                        }
                    }
                }
            } catch (Throwable unused) {
                Log.w("AndServer", "Failed to perform multipart cleanup for servlet request.");
            }
        }
    }

    @Override // com.tencent.local_edit.andserver.http.multipart.d
    public c b(com.tencent.local_edit.andserver.http.b bVar) throws MultipartException {
        if (bVar instanceof c) {
            return (c) bVar;
        }
        a h16 = h(bVar);
        return new e(bVar, h16.b(), h16.c(), h16.a());
    }

    @Override // com.tencent.local_edit.andserver.http.multipart.d
    public boolean c(com.tencent.local_edit.andserver.http.b bVar) {
        com.tencent.local_edit.andserver.http.e body;
        if (!bVar.getMethod().allowBody() || (body = bVar.getBody()) == null || !FileUploadBase.isMultipartContent(new com.tencent.local_edit.andserver.http.multipart.a(body))) {
            return false;
        }
        return true;
    }

    protected StandardMultipartFile d(FileItem fileItem) {
        return new StandardMultipartFile(fileItem);
    }

    protected a g(List<FileItem> list, String str) {
        String string;
        com.tencent.local_edit.andserver.util.e eVar = new com.tencent.local_edit.andserver.util.e();
        com.tencent.local_edit.andserver.util.e eVar2 = new com.tencent.local_edit.andserver.util.e();
        HashMap hashMap = new HashMap();
        for (FileItem fileItem : list) {
            if (fileItem.isFormField()) {
                String f16 = f(fileItem.getContentType(), str);
                if (f16 != null) {
                    try {
                        string = fileItem.getString(f16);
                    } catch (UnsupportedEncodingException unused) {
                        string = fileItem.getString();
                    }
                } else {
                    string = fileItem.getString();
                }
                List list2 = eVar2.get(fileItem.getFieldName());
                if (list2 == null) {
                    LinkedList linkedList = new LinkedList();
                    linkedList.add(string);
                    eVar2.put(fileItem.getFieldName(), linkedList);
                } else {
                    list2.add(string);
                }
                hashMap.put(fileItem.getFieldName(), fileItem.getContentType());
            } else {
                StandardMultipartFile d16 = d(fileItem);
                eVar.a(d16.getName(), d16);
            }
        }
        return new a(eVar, eVar2, hashMap);
    }
}
