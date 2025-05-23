package com.android.vending.expansion.zipfile;

import android.content.ContentProvider;
import android.content.ContentProviderOperation;
import android.content.ContentProviderResult;
import android.content.ContentValues;
import android.content.Context;
import android.content.OperationApplicationException;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.AssetFileDescriptor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import com.android.vending.expansion.zipfile.b;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class APEZProvider extends ContentProvider {

    /* renamed from: f, reason: collision with root package name */
    public static final String[] f31267f = {"_id", "ZPFN", "ZFIL", "ZMOD", "ZCRC", "ZCOL", "ZUNL", "ZTYP"};

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f31268h = {0, 1, 2, 3, 4, 5, 6, 7};

    /* renamed from: d, reason: collision with root package name */
    private b f31269d;

    /* renamed from: e, reason: collision with root package name */
    private boolean f31270e;

    private boolean b() {
        int i3;
        if (!this.f31270e) {
            Context context = getContext();
            PackageManager packageManager = context.getPackageManager();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(a(), 128);
            try {
                int i16 = InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 0).versionCode;
                Bundle bundle = resolveContentProvider.metaData;
                String[] strArr = null;
                if (bundle != null) {
                    int i17 = bundle.getInt("mainVersion", i16);
                    int i18 = resolveContentProvider.metaData.getInt("patchVersion", i16);
                    String string = resolveContentProvider.metaData.getString("mainFilename");
                    if (string != null) {
                        String string2 = resolveContentProvider.metaData.getString("patchFilename");
                        if (string2 != null) {
                            strArr = new String[]{string, string2};
                        } else {
                            strArr = new String[]{string};
                        }
                    }
                    i3 = i18;
                    i16 = i17;
                } else {
                    i3 = i16;
                }
                try {
                    if (strArr == null) {
                        this.f31269d = a.b(context, i16, i3);
                    } else {
                        this.f31269d = a.c(strArr);
                    }
                    this.f31270e = true;
                    return true;
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            } catch (PackageManager.NameNotFoundException e17) {
                e17.printStackTrace();
            }
        }
        return false;
    }

    public abstract String a();

    @Override // android.content.ContentProvider
    public ContentProviderResult[] applyBatch(ArrayList<ContentProviderOperation> arrayList) throws OperationApplicationException {
        b();
        return super.applyBatch(arrayList);
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return "vnd.android.cursor.item/asset";
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return true;
    }

    @Override // android.content.ContentProvider
    public AssetFileDescriptor openAssetFile(Uri uri, String str) throws FileNotFoundException {
        b();
        String encodedPath = uri.getEncodedPath();
        if (encodedPath.startsWith("/")) {
            encodedPath = encodedPath.substring(1);
        }
        return this.f31269d.c(encodedPath);
    }

    @Override // android.content.ContentProvider
    public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException {
        b();
        AssetFileDescriptor openAssetFile = openAssetFile(uri, str);
        if (openAssetFile != null) {
            return openAssetFile.getParcelFileDescriptor();
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        b.a[] b16;
        int[] iArr;
        b();
        b bVar = this.f31269d;
        if (bVar == null) {
            b16 = new b.a[0];
        } else {
            b16 = bVar.b();
        }
        if (strArr == null) {
            iArr = f31268h;
            strArr = f31267f;
        } else {
            int length = strArr.length;
            iArr = new int[length];
            for (int i3 = 0; i3 < length; i3++) {
                if (strArr[i3].equals("_id")) {
                    iArr[i3] = 0;
                } else if (strArr[i3].equals("ZPFN")) {
                    iArr[i3] = 1;
                } else if (strArr[i3].equals("ZFIL")) {
                    iArr[i3] = 2;
                } else if (strArr[i3].equals("ZMOD")) {
                    iArr[i3] = 3;
                } else if (strArr[i3].equals("ZCRC")) {
                    iArr[i3] = 4;
                } else if (strArr[i3].equals("ZCOL")) {
                    iArr[i3] = 5;
                } else if (strArr[i3].equals("ZUNL")) {
                    iArr[i3] = 6;
                } else if (strArr[i3].equals("ZTYP")) {
                    iArr[i3] = 7;
                } else {
                    throw new RuntimeException();
                }
            }
        }
        MatrixCursor matrixCursor = new MatrixCursor(strArr, b16.length);
        int length2 = iArr.length;
        for (b.a aVar : b16) {
            MatrixCursor.RowBuilder newRow = matrixCursor.newRow();
            for (int i16 = 0; i16 < length2; i16++) {
                switch (iArr[i16]) {
                    case 0:
                        newRow.add(Integer.valueOf(i16));
                        break;
                    case 1:
                        newRow.add(aVar.f31275b);
                        break;
                    case 2:
                        newRow.add(aVar.c());
                        break;
                    case 3:
                        newRow.add(Long.valueOf(aVar.f31279f));
                        break;
                    case 4:
                        newRow.add(Long.valueOf(aVar.f31280g));
                        break;
                    case 5:
                        newRow.add(Long.valueOf(aVar.f31281h));
                        break;
                    case 6:
                        newRow.add(Long.valueOf(aVar.f31282i));
                        break;
                    case 7:
                        newRow.add(Integer.valueOf(aVar.f31278e));
                        break;
                }
            }
        }
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
