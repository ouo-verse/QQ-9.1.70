package com.tencent.biz.common.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.webview.swift.injector.aa;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.audiorecorder.MiniGameLameMp3EncodeThread;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.widget.ActionSheet;
import java.io.File;

/* compiled from: P */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    private int f78452a;

    /* renamed from: b, reason: collision with root package name */
    private ValueCallback<Uri> f78453b;

    /* renamed from: c, reason: collision with root package name */
    private ValueCallback<Uri[]> f78454c;

    /* renamed from: d, reason: collision with root package name */
    private Uri f78455d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements ActionSheet.OnDismissListener {
        a() {
        }

        @Override // com.tencent.widget.ActionSheet.OnDismissListener
        public void onDismiss() {
            c.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class b implements DialogInterface.OnCancelListener {
        b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            c.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.biz.common.util.c$c, reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0791c implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f78458d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f78459e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f78460f;

        C0791c(Activity activity, String str, ActionSheet actionSheet) {
            this.f78458d = activity;
            this.f78459e = str;
            this.f78460f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                c.this.k(this.f78458d);
            } else if (i3 == 1) {
                c.this.l(this.f78458d, this.f78459e);
            }
            this.f78460f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class d implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f78462d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f78463e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f78464f;

        d(Activity activity, String str, ActionSheet actionSheet) {
            this.f78462d = activity;
            this.f78463e = str;
            this.f78464f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                c.this.j(this.f78462d);
            } else if (i3 == 1) {
                c.this.l(this.f78462d, this.f78463e);
            }
            this.f78464f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class e implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Activity f78466d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f78467e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ ActionSheet f78468f;

        e(Activity activity, String str, ActionSheet actionSheet) {
            this.f78466d = activity;
            this.f78467e = str;
            this.f78468f = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            if (i3 == 0) {
                c.this.m(this.f78466d);
            } else if (i3 == 1) {
                c.this.l(this.f78466d, this.f78467e);
            }
            this.f78468f.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        ValueCallback<Uri> valueCallback = this.f78453b;
        if (valueCallback != null) {
            valueCallback.onReceiveValue(Uri.EMPTY);
            this.f78452a = Integer.MIN_VALUE;
            this.f78453b = null;
            this.f78455d = null;
        }
        ValueCallback<Uri[]> valueCallback2 = this.f78454c;
        if (valueCallback2 != null) {
            valueCallback2.onReceiveValue(null);
            this.f78454c = null;
            this.f78455d = null;
            this.f78452a = Integer.MIN_VALUE;
        }
    }

    private String h(String str) {
        if (TextUtils.isEmpty(str)) {
            return "*/*";
        }
        if (str.startsWith(".") && ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).q()) {
            str = ((com.tencent.mobileqq.webview.swift.injector.c) aa.k(com.tencent.mobileqq.webview.swift.injector.c.class)).n(str);
            if (TextUtils.isEmpty(str)) {
                return "*/*";
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Activity activity) {
        File file = new File(AppConstants.SDCARD_PATH + "photo/");
        if (!file.exists() && !file.mkdirs()) {
            f();
            QQToast.makeText(activity, 1, activity.getString(R.string.y_), 0).show();
            return;
        }
        this.f78455d = Uri.fromFile(new File(file, "VID_" + System.currentTimeMillis() + ".mp4"));
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("output", this.f78455d);
        intent.putExtra("android.intent.extra.videoQuality", 1);
        o(activity, intent, R.string.f170664xt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(Activity activity) {
        File file = new File(AppConstants.SDCARD_PATH + "photo/");
        if (!file.exists() && !file.mkdirs()) {
            f();
            QQToast.makeText(activity, 1, activity.getString(R.string.y_), 0).show();
            QLog.w("FileChooserHelper", 1, "openCamera file mkdirs failed.");
            return;
        }
        Intent intent = new Intent();
        this.f78455d = FileProvider7Helper.setSystemCapture(activity, new File(file, "IMG_" + System.currentTimeMillis() + ".jpg"), intent);
        o(activity, intent, R.string.f170664xt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Activity activity, String str) {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.addCategory("android.intent.category.OPENABLE");
        String h16 = h(str);
        if (QLog.isDevelopLevel()) {
            QLog.d("FileChooserHelper", 1, String.format("[openFileChooser] accept: %s mimeType: %s", str, h16));
        }
        intent.setType(h16);
        o(activity, intent, R.string.f170679ya);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Activity activity) {
        o(activity, new Intent("android.provider.MediaStore.RECORD_SOUND"), R.string.f170680yb);
    }

    private void o(Activity activity, Intent intent, int i3) {
        if (activity != null && intent != null && i3 > 0) {
            if (activity.getPackageManager().resolveActivity(intent, 65536) != null) {
                try {
                    activity.startActivityForResult(intent, this.f78452a);
                    return;
                } catch (Exception e16) {
                    if (QLog.isColorLevel()) {
                        QLog.w("FileChooserHelper", 2, "Caution: activity for intent was queried but can't started because " + e16.getMessage());
                    }
                }
            }
            f();
            QQToast.makeText(activity, 1, i3, 0).show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean g(int i3, int i16, Intent intent) {
        Uri uri;
        Uri[] uriArr;
        Uri uri2;
        Object obj;
        if (this.f78452a != i3) {
            return false;
        }
        if (QLog.isDevelopLevel()) {
            Object[] objArr = new Object[3];
            objArr[0] = Integer.valueOf(i16);
            if (intent != null) {
                obj = intent.getData();
            } else {
                obj = "";
            }
            objArr[1] = obj;
            objArr[2] = this.f78455d;
            QLog.d("FileChooserHelper", 1, String.format("doOnActivityResult result: %d data: %s mFileGenerationUri: ", objArr));
        }
        if (this.f78453b != null) {
            if (-1 == i16) {
                uri2 = this.f78455d;
                if (uri2 == null) {
                    if (intent != null) {
                        uri2 = intent.getData();
                    } else {
                        uri2 = Uri.EMPTY;
                    }
                }
            } else {
                uri2 = null;
            }
            this.f78453b.onReceiveValue(uri2);
        } else if (this.f78454c != null) {
            if (-1 == i16) {
                uri = this.f78455d;
                if (uri == null) {
                    if (intent != null) {
                        uri = intent.getData();
                    }
                }
                ValueCallback<Uri[]> valueCallback = this.f78454c;
                if (uri == null) {
                    uriArr = new Uri[]{uri};
                } else {
                    uriArr = null;
                }
                valueCallback.onReceiveValue(uriArr);
            }
            uri = null;
            ValueCallback<Uri[]> valueCallback2 = this.f78454c;
            if (uri == null) {
            }
            valueCallback2.onReceiveValue(uriArr);
        } else if (QLog.isColorLevel()) {
            QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback should not be null!");
        }
        this.f78452a = Integer.MIN_VALUE;
        this.f78453b = null;
        this.f78455d = null;
        this.f78454c = null;
        return true;
    }

    @TargetApi(21)
    public boolean i(Activity activity, int i3, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String str;
        if (activity == null || valueCallback == null) {
            return false;
        }
        this.f78454c = valueCallback;
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        String str2 = "";
        if (acceptTypes == null) {
            str = "";
        } else {
            str = acceptTypes[0];
        }
        if (fileChooserParams.isCaptureEnabled()) {
            str2 = "*";
        }
        n(activity, i3, null, str, str2);
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x011d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void n(Activity activity, int i3, ValueCallback<Uri> valueCallback, String str, String str2) {
        String str3;
        boolean z16;
        if (activity != null) {
            if (valueCallback != null || this.f78454c != null) {
                if (QLog.isColorLevel() && this.f78453b != null) {
                    QLog.w("FileChooserHelper", 2, "Caution: mFilePathCallback not null, Plz call doOnActivityResult in the onActivityResult method of caller");
                }
                boolean z17 = true;
                if (QLog.isDevelopLevel()) {
                    QLog.d("FileChooserHelper", 1, String.format("[showFileChooser] accept: %s capture: %s pathCallback: %s", str, str2, this.f78453b));
                }
                this.f78452a = i3;
                this.f78453b = valueCallback;
                this.f78455d = null;
                String str4 = "";
                if (str == null) {
                    str3 = "";
                } else {
                    str3 = str.toLowerCase();
                }
                if (str2 != null) {
                    str4 = str2.toLowerCase();
                }
                if (TextUtils.isEmpty(str4)) {
                    l(activity, str3);
                    return;
                }
                if (!"camera".equals(str4) && !MiniGameLameMp3EncodeThread.AUDIO_SOURCE_CAMCORDER.equals(str4) && !"microphone".equals(str4)) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (!z16) {
                    if (str3.contains(ImageContentType.IMAGE_PREFIX)) {
                        str4 = "camera";
                    } else if (str3.contains("video/")) {
                        str4 = MiniGameLameMp3EncodeThread.AUDIO_SOURCE_CAMCORDER;
                    } else if (str3.contains("audio/")) {
                        str4 = "microphone";
                    }
                    if (!z17) {
                        ActionSheet create = ActionSheet.create(activity);
                        create.setOnDismissListener(new a());
                        create.setOnCancelListener(new b());
                        if (str4.equals("camera")) {
                            create.addButton(activity.getString(R.string.hw5), 0);
                            create.addButton(activity.getString(R.string.b7u), 0);
                            create.setOnButtonClickListener(new C0791c(activity, str3, create));
                        } else if (str4.equals(MiniGameLameMp3EncodeThread.AUDIO_SOURCE_CAMCORDER)) {
                            create.addButton(activity.getString(R.string.heu), 0);
                            create.addButton(activity.getString(R.string.b7u), 0);
                            create.setOnButtonClickListener(new d(activity, str3, create));
                        } else if (str4.equals("microphone")) {
                            create.addButton(activity.getString(R.string.gzu), 0);
                            create.addButton(activity.getString(R.string.b7u), 0);
                            create.setOnButtonClickListener(new e(activity, str3, create));
                        }
                        create.show();
                        return;
                    }
                    l(activity, str3);
                    return;
                }
                z17 = z16;
                if (!z17) {
                }
            }
        }
    }
}
