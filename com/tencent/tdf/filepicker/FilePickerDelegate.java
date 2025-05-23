package com.tencent.tdf.filepicker;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.Log;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes26.dex */
public class FilePickerDelegate {
    static IPatchRedirector $redirector_;
    private static final int REQUEST_CODE;
    private static final String TAG;
    private final Activity mActivity;
    private FilePickerCallback mFilePickerCallback;
    private boolean mIsMultipleSelection;
    private boolean mLoadDataToMemory;
    private final PermissionManager mPermissionManager;
    private String mType;

    /* loaded from: classes26.dex */
    interface FilePickerCallback {
        void onDirectoryPathPicked(String str);

        void onFilePicked(ArrayList<FileInfo> arrayList);
    }

    /* loaded from: classes26.dex */
    interface PermissionManager {
        void askForPermission(String str, int i3);

        boolean isPermissionGranted(String str);
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(15207);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            TAG = FilePickerDelegate.class.getName();
            REQUEST_CODE = (FilePickerDelegate.class.hashCode() + 43) & 65535;
        }
    }

    public FilePickerDelegate(Activity activity) {
        this(activity, new PermissionManager(activity) { // from class: com.tencent.tdf.filepicker.FilePickerDelegate.1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Activity val$activity;

            {
                this.val$activity = activity;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
                }
            }

            @Override // com.tencent.tdf.filepicker.FilePickerDelegate.PermissionManager
            public void askForPermission(String str, int i3) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                    iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, i3);
                } else {
                    ActivityCompat.requestPermissions(this.val$activity, new String[]{str}, i3);
                }
            }

            @Override // com.tencent.tdf.filepicker.FilePickerDelegate.PermissionManager
            public boolean isPermissionGranted(String str) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
                }
                if (ContextCompat.checkSelfPermission(this.val$activity, str) == 0) {
                    return true;
                }
                return false;
            }
        });
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) activity);
    }

    private void startFileExplorer() {
        Intent intent;
        String str = this.mType;
        if (str == null) {
            return;
        }
        if (str.equals(QzoneZipCacheHelper.DIR)) {
            intent = new Intent("android.intent.action.OPEN_DOCUMENT_TREE");
        } else {
            if (this.mType.equals("image/*")) {
                intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            } else {
                intent = new Intent("android.intent.action.GET_CONTENT");
                intent.addCategory("android.intent.category.OPENABLE");
            }
            Uri parse = Uri.parse(Environment.getExternalStorageDirectory().getPath() + File.separator);
            Log.d(TAG, "Selected type " + this.mType);
            intent.setDataAndType(parse, this.mType);
            intent.setType(this.mType);
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", this.mIsMultipleSelection);
            intent.putExtra("multi-pick", this.mIsMultipleSelection);
        }
        if (intent.resolveActivity(this.mActivity.getPackageManager()) != null) {
            this.mActivity.startActivityForResult(intent, REQUEST_CODE);
        } else {
            Log.e(TAG, "Can't find a valid activity to handle the request. Make sure you've a file explorer installed.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void SetFilePickerCallback(FilePickerCallback filePickerCallback) {
        this.mFilePickerCallback = filePickerCallback;
    }

    public boolean onActivityResult(int i3, int i16, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16), intent)).booleanValue();
        }
        if (this.mType == null) {
            return false;
        }
        int i17 = REQUEST_CODE;
        if (i3 == i17 && i16 == -1) {
            new BaseThread(new Runnable(intent) { // from class: com.tencent.tdf.filepicker.FilePickerDelegate.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ Intent val$data;

                {
                    this.val$data = intent;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) FilePickerDelegate.this, (Object) intent);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.val$data != null) {
                        ArrayList<FileInfo> arrayList = new ArrayList<>();
                        if (this.val$data.getClipData() != null) {
                            int itemCount = this.val$data.getClipData().getItemCount();
                            for (int i18 = 0; i18 < itemCount; i18++) {
                                FileInfo openFileStream = FileUtils.openFileStream(FilePickerDelegate.this.mActivity, this.val$data.getClipData().getItemAt(i18).getUri(), FilePickerDelegate.this.mLoadDataToMemory);
                                if (openFileStream != null) {
                                    arrayList.add(openFileStream);
                                }
                            }
                            if (FilePickerDelegate.this.mFilePickerCallback != null) {
                                FilePickerDelegate.this.mFilePickerCallback.onFilePicked(arrayList);
                                return;
                            }
                            return;
                        }
                        if (this.val$data.getData() != null) {
                            Uri data = this.val$data.getData();
                            if (FilePickerDelegate.this.mType.equals(QzoneZipCacheHelper.DIR)) {
                                String fullPathFromTreeUri = FileUtils.getFullPathFromTreeUri(DocumentsContract.buildDocumentUriUsingTree(data, DocumentsContract.getTreeDocumentId(data)), FilePickerDelegate.this.mActivity);
                                if (fullPathFromTreeUri != null) {
                                    if (FilePickerDelegate.this.mFilePickerCallback != null) {
                                        FilePickerDelegate.this.mFilePickerCallback.onDirectoryPathPicked(fullPathFromTreeUri);
                                        return;
                                    }
                                    return;
                                }
                                Log.e(FilePickerDelegate.TAG, "Failed to retrieve directory path.");
                                return;
                            }
                            FileInfo openFileStream2 = FileUtils.openFileStream(FilePickerDelegate.this.mActivity, data, FilePickerDelegate.this.mLoadDataToMemory);
                            if (openFileStream2 != null) {
                                arrayList.add(openFileStream2);
                            }
                            if (!arrayList.isEmpty()) {
                                if (FilePickerDelegate.this.mFilePickerCallback != null) {
                                    FilePickerDelegate.this.mFilePickerCallback.onFilePicked(arrayList);
                                    return;
                                }
                                return;
                            }
                            Log.e(FilePickerDelegate.TAG, "Failed to retrieve path.");
                            return;
                        }
                        if (this.val$data.getExtras() != null) {
                            Bundle extras = this.val$data.getExtras();
                            if (extras.keySet().contains("selectedItems")) {
                                ArrayList parcelableArrayList = extras.getParcelableArrayList("selectedItems");
                                if (parcelableArrayList != null) {
                                    Iterator it = parcelableArrayList.iterator();
                                    while (it.hasNext()) {
                                        Parcelable parcelable = (Parcelable) it.next();
                                        if (parcelable instanceof Uri) {
                                            FileInfo openFileStream3 = FileUtils.openFileStream(FilePickerDelegate.this.mActivity, (Uri) parcelable, FilePickerDelegate.this.mLoadDataToMemory);
                                            if (openFileStream3 != null) {
                                                arrayList.add(openFileStream3);
                                            }
                                        }
                                    }
                                }
                                FilePickerDelegate.this.mFilePickerCallback.onFilePicked(arrayList);
                                return;
                            }
                            Log.e(FilePickerDelegate.TAG, "Failed to retrieve path from bundle.");
                            return;
                        }
                        Log.e(FilePickerDelegate.TAG, "Unknown activity error, please fill an issue.");
                        return;
                    }
                    Log.e(FilePickerDelegate.TAG, "Unknown activity error, please fill an issue.");
                }
            }).start();
            return true;
        }
        if (i3 == i17 && i16 == 0) {
            Log.i(TAG, "User cancelled the picker request");
            return true;
        }
        if (i3 == i17) {
            Log.e(TAG, "Unknown activity error, please fill an issue.");
        }
        return false;
    }

    FilePickerDelegate(Activity activity, PermissionManager permissionManager) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) activity, (Object) permissionManager);
            return;
        }
        this.mIsMultipleSelection = false;
        this.mLoadDataToMemory = false;
        this.mActivity = activity;
        this.mPermissionManager = permissionManager;
    }

    public void startFileExplorer(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.mType = str;
        this.mIsMultipleSelection = z16;
        this.mLoadDataToMemory = z17;
        if (!this.mPermissionManager.isPermissionGranted(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE)) {
            this.mPermissionManager.askForPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE, REQUEST_CODE);
        } else {
            startFileExplorer();
        }
    }
}
