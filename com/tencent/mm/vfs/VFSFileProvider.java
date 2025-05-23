package com.tencent.mm.vfs;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.webkit.MimeTypeMap;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.util.InputMethodUtil;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes9.dex */
public class VFSFileProvider extends ContentProvider {
    private static final String[] COLUMNS = {InputMethodUtil.SOUGOU_URI_DISPLAYNAME, "_size"};
    private static final Pattern PATH_SEPARATE = Pattern.compile("/");
    private String mAuthority;

    private static Uri contentUriToVfsUri(Uri uri) {
        String path = uri.getPath();
        if (path == null || path.isEmpty()) {
            return null;
        }
        if (path.startsWith("/")) {
            path = path.substring(1);
        }
        String[] split = PATH_SEPARATE.split(path, 3);
        if (split.length < 2) {
            return null;
        }
        Uri.Builder builder = new Uri.Builder();
        String str = split[0];
        if (str.startsWith("@")) {
            if (split.length < 3) {
                return null;
            }
            builder.scheme(str.substring(1));
            if (split[1].equals("@")) {
                builder.authority(null);
            } else {
                builder.authority(split[1]);
            }
            builder.path(split[2]);
        } else {
            builder.scheme("wcf").authority(str).path(path.substring(str.length() + 1));
        }
        return builder.build();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Uri vfsUriToContentUri(Uri uri, String str) {
        String sb5;
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.isEmpty() && !scheme.equals("file")) {
            if (scheme.equals("wcf")) {
                sb5 = uri.getAuthority() + uri.getPath();
            } else {
                String authority = uri.getAuthority();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("@");
                sb6.append(scheme);
                sb6.append('/');
                if (authority == null || authority.isEmpty()) {
                    authority = "@";
                }
                sb6.append(authority);
                sb6.append(uri.getPath());
                sb5 = sb6.toString();
            }
            return new Uri.Builder().scheme("content").authority(str).path(sb5).build();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public void attachInfo(Context context, ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        if (!providerInfo.exported) {
            if (providerInfo.grantUriPermissions) {
                this.mAuthority = providerInfo.authority;
                return;
            }
            throw new SecurityException("Provider must grant uri permissions");
        }
        throw new SecurityException("Provider must not be exported");
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        Uri contentUriToVfsUri = contentUriToVfsUri(uri);
        if (contentUriToVfsUri != null) {
            return new VFSFile(contentUriToVfsUri).delete() ? 1 : 0;
        }
        throw new IllegalArgumentException("No mapping found for " + uri);
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        Context context;
        Uri contentUriToVfsUri = contentUriToVfsUri(uri);
        if (contentUriToVfsUri != null) {
            String scheme = contentUriToVfsUri.getScheme();
            if (scheme != null && scheme.equals("content") && (context = getContext()) != null) {
                return context.getContentResolver().getType(contentUriToVfsUri);
            }
            VFSFile vFSFile = new VFSFile(contentUriToVfsUri);
            int lastIndexOf = vFSFile.getName().lastIndexOf(46);
            if (lastIndexOf >= 0) {
                String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(vFSFile.getName().substring(lastIndexOf + 1));
                if (mimeTypeFromExtension != null) {
                    return mimeTypeFromExtension;
                }
                return "application/octet-stream";
            }
            return "application/octet-stream";
        }
        throw new IllegalArgumentException("No mapping found for " + uri);
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        throw new UnsupportedOperationException("No external inserts");
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        Uri contentUriToVfsUri = contentUriToVfsUri(uri);
        if (contentUriToVfsUri != null) {
            FileSystemManager.Resolution resolve = FileSystemManager.instance().resolve(contentUriToVfsUri);
            if (resolve.valid()) {
                try {
                    return resolve.fileSystem.openParcelFd(resolve.path, str);
                } catch (FileNotFoundException e16) {
                    throw e16;
                }
            }
            throw new FileNotFoundException("File not found: " + uri);
        }
        throw new FileNotFoundException("File not found: " + uri);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        int i3;
        Uri contentUriToVfsUri = contentUriToVfsUri(uri);
        if (contentUriToVfsUri != null) {
            VFSFile vFSFile = new VFSFile(contentUriToVfsUri);
            if (strArr == null) {
                strArr = COLUMNS;
            }
            String[] strArr3 = new String[strArr.length];
            Object[] objArr = new Object[strArr.length];
            int i16 = 0;
            for (String str3 : strArr) {
                if (InputMethodUtil.SOUGOU_URI_DISPLAYNAME.equals(str3)) {
                    strArr3[i16] = InputMethodUtil.SOUGOU_URI_DISPLAYNAME;
                    i3 = i16 + 1;
                    objArr[i16] = vFSFile.getName();
                } else if ("_size".equals(str3)) {
                    strArr3[i16] = "_size";
                    i3 = i16 + 1;
                    objArr[i16] = Long.valueOf(vFSFile.length());
                }
                i16 = i3;
            }
            String[] strArr4 = (String[]) Arrays.copyOf(strArr3, i16);
            Object[] copyOf = Arrays.copyOf(objArr, i16);
            MatrixCursor matrixCursor = new MatrixCursor(strArr4, 1);
            matrixCursor.addRow(copyOf);
            return matrixCursor;
        }
        throw new IllegalArgumentException("No mapping found for " + uri);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        throw new UnsupportedOperationException("No external updates");
    }
}
