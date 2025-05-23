package com.tencent.tdf.filepicker;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.tdf.filepicker.FilePickerDelegate;
import java.util.ArrayList;

/* loaded from: classes26.dex */
public class FilePickerChannel implements FilePickerDelegate.FilePickerCallback {
    static IPatchRedirector $redirector_ = null;
    static final String DIR_TYPE = "dir";
    private FilePickerDelegate mFilePickerDelegate;
    public long mNativeFilePicker;

    public FilePickerChannel(FilePickerDelegate filePickerDelegate) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) filePickerDelegate);
        } else {
            this.mFilePickerDelegate = filePickerDelegate;
            filePickerDelegate.SetFilePickerCallback(this);
        }
    }

    private native void onDirectoryPathPicked(long j3, String str);

    private native void onFilePicked(long j3, ArrayList<FileInfo> arrayList);

    private static String resolveType(String str) {
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1349088399:
                if (str.equals("custom")) {
                    c16 = 0;
                    break;
                }
                break;
            case 96748:
                if (str.equals(SemanticAttributes.DbCassandraConsistencyLevelValues.ANY)) {
                    c16 = 1;
                    break;
                }
                break;
            case 99469:
                if (str.equals("dir")) {
                    c16 = 2;
                    break;
                }
                break;
            case 93166550:
                if (str.equals("audio")) {
                    c16 = 3;
                    break;
                }
                break;
            case 100313435:
                if (str.equals("image")) {
                    c16 = 4;
                    break;
                }
                break;
            case 103772132:
                if (str.equals(QAdVrReportParams.ParamKey.MEDIA)) {
                    c16 = 5;
                    break;
                }
                break;
            case 112202875:
                if (str.equals("video")) {
                    c16 = 6;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
            case 1:
                return "*/*";
            case 2:
                return "dir";
            case 3:
                return "audio/*";
            case 4:
                return "image/*";
            case 5:
                return "image/*,video/*";
            case 6:
                return "video/*";
            default:
                return null;
        }
    }

    public void attach(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, j3);
        } else {
            this.mNativeFilePicker = j3;
        }
    }

    @Override // com.tencent.tdf.filepicker.FilePickerDelegate.FilePickerCallback
    public void onDirectoryPathPicked(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            onDirectoryPathPicked(this.mNativeFilePicker, str);
        }
    }

    @Override // com.tencent.tdf.filepicker.FilePickerDelegate.FilePickerCallback
    public void onFilePicked(ArrayList<FileInfo> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) arrayList);
        } else {
            onFilePicked(this.mNativeFilePicker, arrayList);
        }
    }

    public void pickDirectoryPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.mFilePickerDelegate.startFileExplorer("dir", false, false);
        }
    }

    public void pickFiles(String str, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Boolean.valueOf(z16), Boolean.valueOf(z17));
        } else {
            this.mFilePickerDelegate.startFileExplorer(resolveType(str), z16, z17);
        }
    }
}
