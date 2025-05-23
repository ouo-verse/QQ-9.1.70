package com.tencent.mobileqq.filemanager.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ResolveInfo;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.exoplayer2.source.hls.DefaultHlsExtractorFactory;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.qq.taf.jce.HexUtil;
import com.tencent.aelight.camera.api.IAELaunchRecorder;
import com.tencent.ams.mosaic.jsengine.component.text.TextComponent;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.ditto.widget.DittoImageArea;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.URLDrawable;
import com.tencent.imcore.message.Message;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOutputStream;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.FaceConstant;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForFile;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.api.IFMDataCacheApi;
import com.tencent.mobileqq.filemanager.api.IFileManagerDepend;
import com.tencent.mobileqq.filemanager.api.IFileSandboxPathUtilApi;
import com.tencent.mobileqq.filemanager.api.IQQFileSelectorUtil;
import com.tencent.mobileqq.filemanager.api.IQQFileTempUtils;
import com.tencent.mobileqq.filemanager.data.FavFileInfo;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import com.tencent.mobileqq.filemanager.util.FMDialogUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.ah;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.filemanageraux.data.WeiYunFileInfo;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.teamwork.bp;
import com.tencent.mobileqq.transfile.TimeoutParam;
import com.tencent.mobileqq.transfile.filebrowser.MimeTypesTools;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.uniformdownload.api.IUniformDownloadMgr;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.PackageUtil;
import com.tencent.mobileqq.utils.ec;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.vas.config.business.qvip.KingCardProcessor;
import com.tencent.mobileqq.weiyun.api.IWeiyunResponseHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.qmethod.pandoraex.monitor.NetworkMonitor;
import com.tencent.qmethod.pandoraex.monitor.RuntimeMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.rfix.loader.utils.RFixConstants;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsConfig;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.xweb.FileReaderHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.webviewplugin.QzoneWebViewOfflinePlugin;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.TimeZone;
import kotlin.text.Typography;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.apache.http.util.ByteArrayBuffer;
import org.jf.dexlib2.analysis.RegisterType;
import org.json.JSONObject;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
public class QQFileManagerUtilImpl {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f209227a;

    /* renamed from: b, reason: collision with root package name */
    private static final String f209228b;

    /* renamed from: c, reason: collision with root package name */
    private static HashMap<String, Integer> f209229c;

    /* renamed from: d, reason: collision with root package name */
    private static HashMap<String, String> f209230d;

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<Long> f209231e;

    /* renamed from: f, reason: collision with root package name */
    private static HashMap<Integer, String> f209232f;

    /* renamed from: g, reason: collision with root package name */
    private static Drawable f209233g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class a implements s {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f209269a;

        a(FileManagerEntity fileManagerEntity) {
            this.f209269a = fileManagerEntity;
        }

        @Override // com.tencent.mobileqq.filemanager.util.s
        public void a(String str, String str2) {
            this.f209269a.fileName = str;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes12.dex */
    public class b implements ah.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ ah.d f209270a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f209271b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f209272c;

        b(ah.d dVar, String str, String str2) {
            this.f209270a = dVar;
            this.f209271b = str;
            this.f209272c = str2;
        }

        @Override // com.tencent.mobileqq.filemanager.util.ah.c
        public void onSuccess(Bitmap bitmap) {
            if (bitmap == null) {
                ah.d dVar = this.f209270a;
                if (dVar != null) {
                    dVar.onResult(null);
                    return;
                }
                return;
            }
            try {
                q.q(bitmap, this.f209271b);
                bitmap.recycle();
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).setImageDegree(this.f209271b, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getImageDegree(this.f209272c));
                ah.d dVar2 = this.f209270a;
                if (dVar2 != null) {
                    dVar2.onResult(this.f209271b);
                }
            } catch (FileNotFoundException e16) {
                QQFileManagerUtilImpl.B(this.f209270a, e16, "createThumbnail FileNotFoundException:");
            } catch (IOException e17) {
                e17.printStackTrace();
                QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail IOException:" + e17.getMessage());
                ah.d dVar3 = this.f209270a;
                if (dVar3 != null) {
                    dVar3.onResult(null);
                }
            } catch (OutOfMemoryError e18) {
                e18.printStackTrace();
                QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + e18.getMessage());
                ah.d dVar4 = this.f209270a;
                if (dVar4 != null) {
                    dVar4.onResult(null);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class e extends ClickableSpan {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ah.f f209277d;

        e(ah.f fVar) {
            this.f209277d = fVar;
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(View view) {
            ah.f fVar = this.f209277d;
            if (fVar != null) {
                fVar.onClick(view);
            }
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(TextPaint textPaint) {
            textPaint.setColor(-12541697);
            textPaint.setUnderlineText(false);
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class f implements ValueCallback<String> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ WeakReference f209278a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f209279b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ WXShareHelper f209280c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* loaded from: classes12.dex */
        public class a implements FMDialogUtil.c {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ Activity f209281a;

            a(Activity activity) {
                this.f209281a = activity;
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void a() {
                ReportController.o(null, "dc00898", "", "", "0X800AE49", "0X800AE49", 0, 0, "", "", "", "");
            }

            @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
            public void b() {
                ReportController.o(null, "dc00898", "", "", "0X800AE48", "0X800AE48", 0, 0, "", "", "", "");
                try {
                    Intent intent = new Intent(this.f209281a, (Class<?>) QQBrowserActivity.class);
                    intent.putExtra("url", "https://upage.imtt.qq.com/m_imtt/qq_download_middle_page/real/qq_download_middle_page.html");
                    this.f209281a.startActivity(intent);
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("FileManagerUtil<FileAssistant>", 1, "startActivity error", th5);
                    }
                }
            }
        }

        f(WeakReference weakReference, String str, WXShareHelper wXShareHelper) {
            this.f209278a = weakReference;
            this.f209279b = str;
            this.f209280c = wXShareHelper;
        }

        @Override // com.tencent.smtt.sdk.ValueCallback, android.webkit.ValueCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onReceiveValue(String str) {
            Activity activity = (Activity) this.f209278a.get();
            if (activity != null && str != null) {
                String[] split = str.split(":");
                if (split != null && split.length == 2 && !split[0].startsWith("http")) {
                    String str2 = split[0];
                    String str3 = split[1];
                    String o16 = QQFileManagerUtilImpl.o1(str2);
                    int q16 = QQFileManagerUtilImpl.q1(str3);
                    if (o16 != null) {
                        ReportController.o(null, "dc00898", "", "", o16, o16, q16, 0, "", "", "", "");
                    }
                    if ((str2.startsWith(IAELaunchRecorder.MILESTONE_CLICK) || str2.startsWith("extraMenuEvent")) && str3.equalsIgnoreCase("send_to_wx") && QQFileUtilsImpl.o(activity, this.f209279b)) {
                        this.f209280c.t0(this.f209279b, BitmapFactory.decodeResource(activity.getResources(), QQFileManagerUtilImpl.K0(this.f209279b)));
                        return;
                    }
                    return;
                }
                if (str.startsWith("http")) {
                    ReportController.o(null, "dc00898", "", "", "0X800AE47", "0X800AE47", 0, 0, "", "", "", "");
                    FMDialogUtil.b(activity, null, R.string.f186973sq, new a(activity));
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class h implements ActionSheet.OnButtonClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ActionSheet f209283d;

        h(ActionSheet actionSheet) {
            this.f209283d = actionSheet;
        }

        @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
        public void onClick(View view, int i3) {
            this.f209283d.cancel();
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    public static class i extends DefaultHandler {

        /* renamed from: d, reason: collision with root package name */
        private String f209287d;

        /* renamed from: f, reason: collision with root package name */
        private Object f209289f;

        /* renamed from: a, reason: collision with root package name */
        Stack<Object> f209284a = new Stack<>();

        /* renamed from: b, reason: collision with root package name */
        private boolean f209285b = false;

        /* renamed from: c, reason: collision with root package name */
        private boolean f209286c = false;

        /* renamed from: e, reason: collision with root package name */
        private boolean f209288e = false;

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void characters(char[] cArr, int i3, int i16) throws SAXException {
            System.out.println("characters:");
            if (i16 > 0) {
                if (this.f209286c) {
                    this.f209287d = new String(cArr, i3, i16);
                    System.out.println("key:" + this.f209287d);
                }
                if (this.f209288e) {
                    if (HashMap.class.equals(this.f209284a.peek().getClass())) {
                        ((HashMap) this.f209284a.peek()).put(this.f209287d, new String(cArr, i3, i16));
                    } else if (ArrayList.class.equals(this.f209284a.peek().getClass())) {
                        ((ArrayList) this.f209284a.peek()).add(new String(cArr, i3, i16));
                    }
                    System.out.println("value:" + new String(cArr, i3, i16));
                }
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endDocument() throws SAXException {
            System.out.println(QQFileManagerUtilImpl.m1(R.string.mje));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void endElement(String str, String str2, String str3) throws SAXException {
            "plist".equals(str3);
            if ("key".equals(str3)) {
                this.f209286c = false;
            }
            if (HippyControllerProps.STRING.equals(str3)) {
                this.f209288e = false;
            }
            if ("integer".equals(str3)) {
                this.f209288e = false;
            }
            if (HippyControllerProps.ARRAY.equals(str3)) {
                this.f209289f = this.f209284a.pop();
            }
            if ("dict".equals(str3)) {
                this.f209289f = this.f209284a.pop();
            }
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startDocument() throws SAXException {
            System.out.println(QQFileManagerUtilImpl.m1(R.string.f171982mj4));
        }

        @Override // org.xml.sax.helpers.DefaultHandler, org.xml.sax.ContentHandler
        public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
            if ("plist".equals(str3)) {
                this.f209285b = true;
            }
            if ("dict".equals(str3)) {
                if (this.f209285b) {
                    this.f209284a.push(new HashMap());
                    this.f209285b = !this.f209285b;
                } else {
                    Object peek = this.f209284a.peek();
                    HashMap hashMap = new HashMap();
                    if (peek instanceof ArrayList) {
                        ((ArrayList) peek).add(hashMap);
                    } else if (peek instanceof HashMap) {
                        ((HashMap) peek).put(this.f209287d, hashMap);
                    }
                    this.f209284a.push(hashMap);
                }
            }
            if ("key".equals(str3)) {
                this.f209286c = true;
            }
            if ("true".equals(str3)) {
                ((HashMap) this.f209284a.peek()).put(this.f209287d, Boolean.TRUE);
            }
            if ("false".equals(str3)) {
                ((HashMap) this.f209284a.peek()).put(this.f209287d, Boolean.FALSE);
            }
            if (HippyControllerProps.ARRAY.equals(str3)) {
                if (this.f209285b) {
                    this.f209284a.push(new ArrayList());
                    this.f209285b = !this.f209285b;
                } else {
                    HashMap hashMap2 = (HashMap) this.f209284a.peek();
                    ArrayList arrayList = new ArrayList();
                    this.f209284a.push(arrayList);
                    hashMap2.put(this.f209287d, arrayList);
                }
            }
            if (HippyControllerProps.STRING.equals(str3)) {
                this.f209288e = true;
            }
            if ("integer".equals(str3)) {
                this.f209288e = true;
            }
        }
    }

    static {
        char[] cArr = {Typography.ellipsis};
        f209227a = cArr;
        f209228b = new String(cArr);
        f209229c = null;
        f209230d = null;
        f209231e = null;
        f209232f = new HashMap<>();
    }

    public static boolean A(Context context, String str, long j3) {
        String g16 = com.tencent.mobileqq.filemanager.data.d.g(context, str, "FileMaxSize");
        if (g16 == null) {
            return false;
        }
        long parseInt = Integer.parseInt(g16) * 1048576;
        if (QLog.isColorLevel()) {
            QLog.d("FileManagerUtil<FileAssistant>", 2, "canPreview limitSize: " + parseInt + ", fileSize: " + j3);
        }
        if (parseInt < j3) {
            return false;
        }
        return true;
    }

    public static BaseQQAppInterface A0() {
        AppRuntime waitAppRuntime;
        if (MobileQQ.sProcessId != 1 || (waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null)) == null || !(waitAppRuntime instanceof BaseQQAppInterface)) {
            return null;
        }
        return (BaseQQAppInterface) waitAppRuntime;
    }

    private static IUniformDownloadMgr A1() {
        return (IUniformDownloadMgr) r1().getRuntimeService(IUniformDownloadMgr.class, "all");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x007a A[Catch: Exception -> 0x0097, TRY_LEAVE, TryCatch #0 {Exception -> 0x0097, blocks: (B:5:0x0036, B:7:0x003c, B:9:0x005a, B:11:0x007a), top: B:4:0x0036 }] */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean A2(File file, File file2) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "normal renameFile: src[" + file.getAbsolutePath() + "] dest[" + file2.getAbsolutePath() + "]");
        }
        try {
            if (file2.exists()) {
                if (file2.getPath().startsWith(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(Environment.getExternalStorageDirectory().getAbsolutePath()))) {
                    z16 = file2.delete();
                    QLog.e("FileManagerUtil<FileAssistant>", 1, "normal rename, delete result[" + z16 + "]");
                    if (!z16) {
                        boolean renameTo = file.renameTo(file2);
                        QLog.e("FileManagerUtil<FileAssistant>", 1, "normal rename, rename result[" + renameTo + "]");
                        return renameTo;
                    }
                    return z16;
                }
            }
            z16 = true;
            if (!z16) {
            }
        } catch (Exception e16) {
            QLog.e("FileManagerUtil<FileAssistant>", 1, "normal rename exception: " + e16.getMessage());
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B(ah.d dVar, IOException iOException, String str) {
        iOException.printStackTrace();
        QLog.w("FileManagerUtil<FileAssistant>", 1, str + iOException.getMessage());
        if (dVar != null) {
            dVar.onResult(null);
        }
    }

    public static Bitmap B0(Context context, Bitmap bitmap, int i3) {
        int i16;
        int i17;
        int i18;
        if (bitmap == null) {
            return null;
        }
        try {
            float f16 = context.getResources().getDisplayMetrics().density;
            int dp2px = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).dp2px(i3, context.getResources());
            int width = (int) (bitmap.getWidth() * f16);
            int height = (int) (bitmap.getHeight() * f16);
            int width2 = bitmap.getWidth();
            int height2 = bitmap.getHeight();
            if (width2 > height2) {
                i18 = (width2 - height2) / 2;
                width = height;
                i16 = height2;
                i17 = 0;
            } else if (height2 > width2) {
                height = width;
                i16 = width2;
                i17 = (height2 - width2) / 2;
                height2 = i16;
                i18 = 0;
            } else {
                i16 = height2;
                i17 = 0;
                height2 = width2;
                i18 = 0;
            }
            Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap);
            Paint paint = new Paint();
            Rect rect = new Rect(i18, i17, height2 + i18, i16 + i17);
            Rect rect2 = new Rect(0, 0, width, height);
            RectF rectF = new RectF(rect2);
            paint.setAntiAlias(true);
            paint.setDither(true);
            paint.setFilterBitmap(true);
            canvas.drawARGB(0, 0, 0, 0);
            paint.setColor(-12434878);
            float f17 = dp2px;
            canvas.drawRoundRect(rectF, f17, f17, paint);
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
            canvas.drawBitmap(bitmap, rect, rect2, paint);
            return createBitmap;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    @TargetApi(10)
    public static void B1(final String str, final boolean z16, final int i3, final int i16, final int i17, final ah.c cVar) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.13
            /* JADX WARN: Removed duplicated region for block: B:10:0x0027 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:12:0x0028  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                Bitmap bitmap;
                float f16;
                int height;
                ah.c cVar2;
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                Bitmap bitmap2 = null;
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(str);
                        int i18 = i17;
                        long j3 = i18;
                        if (i18 <= 0) {
                            j3 = 5000000;
                        }
                        bitmap = mediaMetadataRetriever.getFrameAtTime(j3, 2);
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused) {
                        }
                    } catch (IllegalArgumentException | OutOfMemoryError | RuntimeException unused2) {
                        mediaMetadataRetriever.release();
                        bitmap = null;
                        if (bitmap == null) {
                        }
                    } catch (Throwable th5) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception unused3) {
                        }
                        throw th5;
                    }
                } catch (Exception unused4) {
                    bitmap = null;
                    if (bitmap == null) {
                    }
                }
                if (bitmap == null) {
                    return;
                }
                if (!z16 && (cVar2 = cVar) != null) {
                    cVar2.onSuccess(bitmap);
                    return;
                }
                if (bitmap.getWidth() < bitmap.getHeight()) {
                    f16 = i3;
                    height = bitmap.getWidth();
                } else {
                    f16 = i16;
                    height = bitmap.getHeight();
                }
                float f17 = f16 / height;
                Matrix matrix = new Matrix();
                matrix.setScale(f17, f17);
                try {
                    bitmap2 = QQFileManagerUtilImpl.a3(matrix, bitmap, i3, i16);
                } catch (Exception e16) {
                    QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception:" + e16.toString());
                }
                ah.c cVar3 = cVar;
                if (cVar3 != null) {
                    cVar3.onSuccess(bitmap2);
                }
            }
        }, 8, null, true);
    }

    public static void B2(BaseQQAppInterface baseQQAppInterface, Context context) {
        H2(baseQQAppInterface, baseQQAppInterface.getCurrentAccountUin(), context);
    }

    public static int C(FileManagerEntity fileManagerEntity) {
        String upperCase = fileManagerEntity.fileName.toUpperCase();
        if (upperCase.endsWith(".ZIP")) {
            return 13;
        }
        if (upperCase.endsWith(".RAR")) {
            return 14;
        }
        if (upperCase.endsWith(".7Z")) {
            return 15;
        }
        return -1;
    }

    public static SpannableString C0(String str, String str2, ah.f fVar) {
        int indexOf = str.indexOf(str2);
        int length = str2.length() + indexOf;
        SpannableString spannableString = new SpannableString(str);
        e eVar = new e(fVar);
        try {
            spannableString.setSpan(new ForegroundColorSpan(-12541697), indexOf, length, 33);
            spannableString.setSpan(eVar, indexOf, length, 33);
        } catch (Exception unused) {
        }
        return spannableString;
    }

    public static long C1(long j3) {
        return j3 | 6148924072160919552L;
    }

    public static void C2(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10) {
        D2(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, str6, j18, j19, j26, str7, str8, i3, str9, str10, new Bundle());
    }

    public static int D(FileManagerEntity fileManagerEntity) {
        String upperCase = fileManagerEntity.fileName.toUpperCase();
        if (upperCase.endsWith(".ZIP")) {
            return 13;
        }
        if (upperCase.endsWith(".RAR")) {
            return 14;
        }
        if (upperCase.endsWith(".7Z")) {
            return 15;
        }
        return -1;
    }

    public static w D0(BaseQQAppInterface baseQQAppInterface, int i3) {
        return new c(baseQQAppInterface, i3);
    }

    public static String D1(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity.isZipInnerFile && fileManagerEntity.nFileType == 0) {
            String str = fileManagerEntity.zipInnerPath;
            return lc1.b.a().getDefaultThumbPath() + "x-zip-" + com.tencent.securitysdk.utils.c.b(((String) fileManagerEntity.mContext) + str);
        }
        return "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006f, code lost:
    
        if (r1.indexOf("MalformedURLException") <= 0) goto L33;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x007f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x01cc  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0049  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void D2(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, String str6, long j18, long j19, long j26, String str7, String str8, int i3, String str9, String str10, Bundle bundle) {
        boolean z16;
        long j27;
        String str11;
        long j28;
        long j29;
        long j36;
        String str12;
        long j37;
        int i16;
        int i17;
        int i18;
        int i19;
        String str13 = str2;
        String str14 = str9;
        long currentTimeMillis = j16 == 0 ? System.currentTimeMillis() : j16;
        long currentTimeMillis2 = currentTimeMillis < 1 ? 0L : System.currentTimeMillis() - currentTimeMillis;
        if (str13 != null) {
            if (str2.length() > 0) {
                str13 = str13.substring(str13.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3, str13.lastIndexOf(":"));
                long j38 = currentTimeMillis2 >= 0 ? 0L : currentTimeMillis2;
                if (str14 != null && str9.length() > 0) {
                    z16 = true;
                    if (str14.indexOf("Network is unreachable") <= 0) {
                        if (str14.indexOf("No route to host") <= 0) {
                        }
                    }
                    if (NetworkUtil.isNetSupport(BaseApplication.getContext()) || z16) {
                        str14 = str14 + "_NotNetWork";
                        j27 = 9004;
                    } else {
                        j27 = j17;
                    }
                    if (baseQQAppInterface.isLogin()) {
                        j28 = 9004;
                        str11 = str14 + "_NotLogin";
                    } else {
                        str11 = str14;
                        j28 = j27;
                    }
                    int i26 = QQFileUtilsImpl.i();
                    HashMap<String, String> hashMap = new HashMap<>();
                    hashMap.put("serverip", str13);
                    hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, str13);
                    hashMap.put("param_ftnIP", str13);
                    hashMap.put("param_PeerUin", String.valueOf(str3));
                    hashMap.put(ReportConstant.KEY_UUID, String.valueOf(str4));
                    hashMap.put("param_MD5", str5);
                    hashMap.put("param_FailCode", Long.toString(j28));
                    hashMap.put(ReportConstant.KEY_ERR_DESC, String.valueOf(str6));
                    hashMap.put("param_fsized", String.valueOf(j19));
                    hashMap.put("param_fsizeo", String.valueOf(j26));
                    hashMap.put("param_url", String.valueOf(str7));
                    hashMap.put("param_rspHeader", String.valueOf(str8));
                    hashMap.put("param_retry", String.valueOf(i3));
                    hashMap.put("param_errMsg", str11 + "uin[" + baseQQAppInterface.getCurrentAccountUin() + "]");
                    hashMap.put("param_nSessionId", String.valueOf(j3));
                    hashMap.put("param_ipStackType", String.valueOf(i26));
                    hashMap.put("param_realTransferType", String.valueOf(0));
                    if (bundle == null) {
                        long j39 = bundle.getLong("param_transferTime", -1L);
                        j29 = 0;
                        if (j39 >= 0) {
                            j36 = j39;
                            if (j36 > j29) {
                                str12 = "]";
                                if (j18 >= 1024) {
                                    j37 = ((float) j18) / (((float) j36) / 1000.0f);
                                    hashMap.put("param_speed", String.valueOf(j37));
                                    int l3 = QQFileUtilsImpl.l();
                                    int m3 = QQFileUtilsImpl.m();
                                    long j46 = j37;
                                    long j47 = j28;
                                    if (bundle == null) {
                                        int i27 = bundle.getInt("param_fromType", 0);
                                        i18 = bundle.getInt("param_V6SelectType", 0);
                                        i19 = bundle.getInt("param_ipAddrType", 0);
                                        i17 = bundle.getInt("param_ishttps", 0);
                                        i16 = i27;
                                    } else {
                                        i16 = 0;
                                        i17 = 0;
                                        i18 = 0;
                                        i19 = 0;
                                    }
                                    hashMap.put("param_fromType", String.valueOf(i16));
                                    hashMap.put("param_V6SelectType", String.valueOf(i18));
                                    hashMap.put("param_ipAddrType", String.valueOf(i19));
                                    hashMap.put("param_stackType", String.valueOf(l3));
                                    hashMap.put("param_loginType", String.valueOf(m3));
                                    hashMap.put("param_ishttps", String.valueOf(i17));
                                    int i28 = i17;
                                    long j48 = j36;
                                    String str15 = str12;
                                    String str16 = str11;
                                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, false, j38, j18, hashMap, str10);
                                    if (QLog.isColorLevel()) {
                                        return;
                                    }
                                    QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + str + "], isSuccess[false], nSessionId[" + j3 + "], param_FailCode[" + j47 + "], startTime[" + currentTimeMillis + "], duration[" + j38 + "], rpSize[" + j18 + "], transfSize[" + j19 + "], fileSize[" + j26 + "], param_errorDesc[" + str6 + "], retryTimes[" + i3 + "], reserved[" + str10 + "], ipStackType[" + i26 + "] realTransferType[0] speed[" + j46 + "], errMsg[" + str16 + "] fromType[" + i16 + "] transferTime[" + j48 + "] isHttps[" + i28 + str15);
                                    return;
                                }
                            } else {
                                str12 = "]";
                            }
                            j37 = j29;
                            hashMap.put("param_speed", String.valueOf(j37));
                            int l36 = QQFileUtilsImpl.l();
                            int m36 = QQFileUtilsImpl.m();
                            long j462 = j37;
                            long j472 = j28;
                            if (bundle == null) {
                            }
                            hashMap.put("param_fromType", String.valueOf(i16));
                            hashMap.put("param_V6SelectType", String.valueOf(i18));
                            hashMap.put("param_ipAddrType", String.valueOf(i19));
                            hashMap.put("param_stackType", String.valueOf(l36));
                            hashMap.put("param_loginType", String.valueOf(m36));
                            hashMap.put("param_ishttps", String.valueOf(i17));
                            int i282 = i17;
                            long j482 = j36;
                            String str152 = str12;
                            String str162 = str11;
                            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, false, j38, j18, hashMap, str10);
                            if (QLog.isColorLevel()) {
                            }
                        }
                    } else {
                        j29 = 0;
                    }
                    j36 = j38;
                    if (j36 > j29) {
                    }
                    j37 = j29;
                    hashMap.put("param_speed", String.valueOf(j37));
                    int l362 = QQFileUtilsImpl.l();
                    int m362 = QQFileUtilsImpl.m();
                    long j4622 = j37;
                    long j4722 = j28;
                    if (bundle == null) {
                    }
                    hashMap.put("param_fromType", String.valueOf(i16));
                    hashMap.put("param_V6SelectType", String.valueOf(i18));
                    hashMap.put("param_ipAddrType", String.valueOf(i19));
                    hashMap.put("param_stackType", String.valueOf(l362));
                    hashMap.put("param_loginType", String.valueOf(m362));
                    hashMap.put("param_ishttps", String.valueOf(i17));
                    int i2822 = i17;
                    long j4822 = j36;
                    String str1522 = str12;
                    String str1622 = str11;
                    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, false, j38, j18, hashMap, str10);
                    if (QLog.isColorLevel()) {
                    }
                }
                z16 = false;
                if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
                }
                str14 = str14 + "_NotNetWork";
                j27 = 9004;
                if (baseQQAppInterface.isLogin()) {
                }
                int i262 = QQFileUtilsImpl.i();
                HashMap<String, String> hashMap2 = new HashMap<>();
                hashMap2.put("serverip", str13);
                hashMap2.put(ReportConstant.KEY_OLD_SERVER_IP, str13);
                hashMap2.put("param_ftnIP", str13);
                hashMap2.put("param_PeerUin", String.valueOf(str3));
                hashMap2.put(ReportConstant.KEY_UUID, String.valueOf(str4));
                hashMap2.put("param_MD5", str5);
                hashMap2.put("param_FailCode", Long.toString(j28));
                hashMap2.put(ReportConstant.KEY_ERR_DESC, String.valueOf(str6));
                hashMap2.put("param_fsized", String.valueOf(j19));
                hashMap2.put("param_fsizeo", String.valueOf(j26));
                hashMap2.put("param_url", String.valueOf(str7));
                hashMap2.put("param_rspHeader", String.valueOf(str8));
                hashMap2.put("param_retry", String.valueOf(i3));
                hashMap2.put("param_errMsg", str11 + "uin[" + baseQQAppInterface.getCurrentAccountUin() + "]");
                hashMap2.put("param_nSessionId", String.valueOf(j3));
                hashMap2.put("param_ipStackType", String.valueOf(i262));
                hashMap2.put("param_realTransferType", String.valueOf(0));
                if (bundle == null) {
                }
                j36 = j38;
                if (j36 > j29) {
                }
                j37 = j29;
                hashMap2.put("param_speed", String.valueOf(j37));
                int l3622 = QQFileUtilsImpl.l();
                int m3622 = QQFileUtilsImpl.m();
                long j46222 = j37;
                long j47222 = j28;
                if (bundle == null) {
                }
                hashMap2.put("param_fromType", String.valueOf(i16));
                hashMap2.put("param_V6SelectType", String.valueOf(i18));
                hashMap2.put("param_ipAddrType", String.valueOf(i19));
                hashMap2.put("param_stackType", String.valueOf(l3622));
                hashMap2.put("param_loginType", String.valueOf(m3622));
                hashMap2.put("param_ishttps", String.valueOf(i17));
                int i28222 = i17;
                long j48222 = j36;
                String str15222 = str12;
                String str16222 = str11;
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, false, j38, j18, hashMap2, str10);
                if (QLog.isColorLevel()) {
                }
            }
        }
        str13 = "";
        if (currentTimeMillis2 >= 0) {
        }
        if (str14 != null) {
            z16 = true;
            if (str14.indexOf("Network is unreachable") <= 0) {
            }
            if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
            }
            str14 = str14 + "_NotNetWork";
            j27 = 9004;
            if (baseQQAppInterface.isLogin()) {
            }
            int i2622 = QQFileUtilsImpl.i();
            HashMap<String, String> hashMap22 = new HashMap<>();
            hashMap22.put("serverip", str13);
            hashMap22.put(ReportConstant.KEY_OLD_SERVER_IP, str13);
            hashMap22.put("param_ftnIP", str13);
            hashMap22.put("param_PeerUin", String.valueOf(str3));
            hashMap22.put(ReportConstant.KEY_UUID, String.valueOf(str4));
            hashMap22.put("param_MD5", str5);
            hashMap22.put("param_FailCode", Long.toString(j28));
            hashMap22.put(ReportConstant.KEY_ERR_DESC, String.valueOf(str6));
            hashMap22.put("param_fsized", String.valueOf(j19));
            hashMap22.put("param_fsizeo", String.valueOf(j26));
            hashMap22.put("param_url", String.valueOf(str7));
            hashMap22.put("param_rspHeader", String.valueOf(str8));
            hashMap22.put("param_retry", String.valueOf(i3));
            hashMap22.put("param_errMsg", str11 + "uin[" + baseQQAppInterface.getCurrentAccountUin() + "]");
            hashMap22.put("param_nSessionId", String.valueOf(j3));
            hashMap22.put("param_ipStackType", String.valueOf(i2622));
            hashMap22.put("param_realTransferType", String.valueOf(0));
            if (bundle == null) {
            }
            j36 = j38;
            if (j36 > j29) {
            }
            j37 = j29;
            hashMap22.put("param_speed", String.valueOf(j37));
            int l36222 = QQFileUtilsImpl.l();
            int m36222 = QQFileUtilsImpl.m();
            long j462222 = j37;
            long j472222 = j28;
            if (bundle == null) {
            }
            hashMap22.put("param_fromType", String.valueOf(i16));
            hashMap22.put("param_V6SelectType", String.valueOf(i18));
            hashMap22.put("param_ipAddrType", String.valueOf(i19));
            hashMap22.put("param_stackType", String.valueOf(l36222));
            hashMap22.put("param_loginType", String.valueOf(m36222));
            hashMap22.put("param_ishttps", String.valueOf(i17));
            int i282222 = i17;
            long j482222 = j36;
            String str152222 = str12;
            String str162222 = str11;
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, false, j38, j18, hashMap22, str10);
            if (QLog.isColorLevel()) {
            }
        }
        z16 = false;
        if (NetworkUtil.isNetSupport(BaseApplication.getContext())) {
        }
        str14 = str14 + "_NotNetWork";
        j27 = 9004;
        if (baseQQAppInterface.isLogin()) {
        }
        int i26222 = QQFileUtilsImpl.i();
        HashMap<String, String> hashMap222 = new HashMap<>();
        hashMap222.put("serverip", str13);
        hashMap222.put(ReportConstant.KEY_OLD_SERVER_IP, str13);
        hashMap222.put("param_ftnIP", str13);
        hashMap222.put("param_PeerUin", String.valueOf(str3));
        hashMap222.put(ReportConstant.KEY_UUID, String.valueOf(str4));
        hashMap222.put("param_MD5", str5);
        hashMap222.put("param_FailCode", Long.toString(j28));
        hashMap222.put(ReportConstant.KEY_ERR_DESC, String.valueOf(str6));
        hashMap222.put("param_fsized", String.valueOf(j19));
        hashMap222.put("param_fsizeo", String.valueOf(j26));
        hashMap222.put("param_url", String.valueOf(str7));
        hashMap222.put("param_rspHeader", String.valueOf(str8));
        hashMap222.put("param_retry", String.valueOf(i3));
        hashMap222.put("param_errMsg", str11 + "uin[" + baseQQAppInterface.getCurrentAccountUin() + "]");
        hashMap222.put("param_nSessionId", String.valueOf(j3));
        hashMap222.put("param_ipStackType", String.valueOf(i26222));
        hashMap222.put("param_realTransferType", String.valueOf(0));
        if (bundle == null) {
        }
        j36 = j38;
        if (j36 > j29) {
        }
        j37 = j29;
        hashMap222.put("param_speed", String.valueOf(j37));
        int l362222 = QQFileUtilsImpl.l();
        int m362222 = QQFileUtilsImpl.m();
        long j4622222 = j37;
        long j4722222 = j28;
        if (bundle == null) {
        }
        hashMap222.put("param_fromType", String.valueOf(i16));
        hashMap222.put("param_V6SelectType", String.valueOf(i18));
        hashMap222.put("param_ipAddrType", String.valueOf(i19));
        hashMap222.put("param_stackType", String.valueOf(l362222));
        hashMap222.put("param_loginType", String.valueOf(m362222));
        hashMap222.put("param_ishttps", String.valueOf(i17));
        int i2822222 = i17;
        long j4822222 = j36;
        String str1522222 = str12;
        String str1622222 = str11;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, false, j38, j18, hashMap222, str10);
        if (QLog.isColorLevel()) {
        }
    }

    public static void E(final FileManagerEntity fileManagerEntity, final BaseQQAppInterface baseQQAppInterface, final ah.a aVar) {
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.18
            @Override // java.lang.Runnable
            public void run() {
                QQFileManagerUtilImpl.J2(FileManagerEntity.this, aVar, baseQQAppInterface);
            }
        });
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x0054, code lost:
    
        if (r0 == null) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0057, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x004f, code lost:
    
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x004d, code lost:
    
        if (r0 == null) goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static byte[] E0(String str, String str2) {
        BufferedInputStream bufferedInputStream;
        MessageDigest messageDigest;
        BufferedInputStream bufferedInputStream2 = null;
        if (Q0(str) == 0) {
            return null;
        }
        try {
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
        } catch (FileNotFoundException unused) {
            bufferedInputStream = null;
        } catch (IOException unused2) {
            bufferedInputStream = null;
        } catch (Throwable th5) {
            th = th5;
        }
        try {
            try {
                byte[] bArr = new byte[10240];
                try {
                    messageDigest = MessageDigest.getInstance(str2);
                } catch (NoSuchAlgorithmException e16) {
                    e16.printStackTrace();
                    messageDigest = null;
                }
                while (true) {
                    int read = bufferedInputStream.read(bArr);
                    if (read <= 0) {
                        try {
                            break;
                        } catch (IOException unused3) {
                        }
                    } else if (messageDigest != null) {
                        messageDigest.update(bArr, 0, read);
                    }
                }
                bufferedInputStream.close();
                if (messageDigest != null) {
                    byte[] digest = messageDigest.digest();
                    try {
                        bufferedInputStream.close();
                    } catch (IOException unused4) {
                    }
                    return digest;
                }
                try {
                    bufferedInputStream.close();
                } catch (IOException unused5) {
                }
                return null;
            } catch (FileNotFoundException unused6) {
            } catch (IOException unused7) {
            }
        } catch (Throwable th6) {
            th = th6;
            bufferedInputStream2 = bufferedInputStream;
            if (bufferedInputStream2 != null) {
                try {
                    bufferedInputStream2.close();
                } catch (IOException unused8) {
                }
            }
            throw th;
        }
    }

    public static String E1(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace("ftn_compress_getfile", "ftn_compress_getabs") + "size=750&";
    }

    public static void E2(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6) {
        F2(baseQQAppInterface, j3, str, j16, str2, str3, str4, str5, j17, j18, j19, i3, str6, new Bundle());
    }

    public static boolean F(ChatMessage chatMessage, BaseQQAppInterface baseQQAppInterface, Context context) {
        if (chatMessage == null || !chatMessage.isMultiMsg) {
            return false;
        }
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
        if (!TextUtils.isEmpty(extInfoFromExtStr) && Integer.parseInt(extInfoFromExtStr) == 4) {
            QQToast.makeText(context, R.string.f170961ba4, 0).show();
            return false;
        }
        MessageRecord primaryStructMsg = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getPrimaryStructMsg(baseQQAppInterface, chatMessage);
        if (primaryStructMsg != null && primaryStructMsg.extraflag == 32768) {
            QQToast.makeText(context, R.string.f170960ba3, 0).show();
            return false;
        }
        return true;
    }

    public static HashMap<String, String> F0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                String[] split2 = str2.split("_");
                if (split2 != null && split2.length == 2 && !TextUtils.isEmpty(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    public static String F1(String str, boolean z16, int i3, TextPaint textPaint, int i16) {
        int i17;
        boolean z17;
        int i18;
        String substring;
        if (!TextUtils.isEmpty(str) && textPaint != null && i3 > 0) {
            if (i16 > 1) {
                i17 = i16;
            } else {
                i17 = 1;
            }
            char[] charArray = str.toCharArray();
            StringBuilder sb5 = new StringBuilder();
            int i19 = 0;
            int i26 = 0;
            while (true) {
                if (i19 < charArray.length) {
                    sb5.append(charArray[i19]);
                    if (textPaint.measureText(sb5.toString()) > i3) {
                        i19--;
                        i26++;
                        sb5.delete(0, sb5.length());
                        if (i26 >= i17) {
                            z17 = true;
                            break;
                        }
                    }
                    i19++;
                } else {
                    z17 = false;
                    break;
                }
            }
            if (z17) {
                if (z16) {
                    i18 = 6;
                } else {
                    i18 = 15;
                }
                if (str.length() < i18) {
                    substring = str;
                } else {
                    substring = str.substring(str.length() - i18);
                }
                StringBuilder sb6 = new StringBuilder(substring);
                int i27 = 0;
                int i28 = 0;
                boolean z18 = false;
                while (true) {
                    if (i27 >= charArray.length - i18) {
                        break;
                    }
                    sb6.append(charArray[i27]);
                    if (textPaint.measureText(sb6.toString()) > i3 * i16) {
                        i28 = i27 - 2;
                        break;
                    }
                    int i29 = i27 + 1;
                    if (str.substring(i27, i29).equals(f209228b)) {
                        z18 = true;
                    }
                    if (i27 == (charArray.length - i18) - 1) {
                        i28 = i27 - 2;
                    }
                    i27 = i29;
                }
                if (i28 <= 0) {
                    i28 = 0;
                }
                if (!z18) {
                    return str.substring(0, i28) + f209228b + substring;
                }
                return str.substring(0, i28) + substring;
            }
            return str;
        }
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x00ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void F2(BaseQQAppInterface baseQQAppInterface, long j3, String str, long j16, String str2, String str3, String str4, String str5, long j17, long j18, long j19, int i3, String str6, Bundle bundle) {
        long j26;
        long j27;
        int i16;
        int i17;
        int i18;
        int i19;
        String str7 = str2;
        HashMap<String, String> hashMap = new HashMap<>();
        long j28 = 0;
        long j29 = j16 < 0 ? 0L : j16;
        if (str7 != null) {
            if (str2.length() > 0) {
                str7 = str7.substring(str7.indexOf(QzoneWebViewOfflinePlugin.STR_DEVIDER) + 3, str7.lastIndexOf(":"));
                int i26 = QQFileUtilsImpl.i();
                hashMap.put("serverip", str7);
                hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, str7);
                hashMap.put("param_ftnIP", str7);
                hashMap.put("param_PeerUin", str3);
                hashMap.put(ReportConstant.KEY_UUID, str4);
                hashMap.put("param_MD5", str5);
                hashMap.put("param_fsized", String.valueOf(j18));
                hashMap.put("param_fsizeo", String.valueOf(j19));
                hashMap.put("param_retry", String.valueOf(i3));
                hashMap.put("param_nSessionId", String.valueOf(j3));
                hashMap.put("param_errMsg", String.valueOf(str6));
                hashMap.put("param_ipStackType", String.valueOf(i26));
                hashMap.put("param_realTransferType", String.valueOf(0));
                if (bundle != null) {
                    long j36 = bundle.getLong("param_transferTime", -1L);
                    if (j36 >= 0) {
                        j26 = j36;
                        if (j26 > 0 && j17 >= 1024) {
                            j28 = ((float) j17) / (((float) j26) / 1000.0f);
                        }
                        long j37 = j28;
                        hashMap.put("param_speed", String.valueOf(j37));
                        int l3 = QQFileUtilsImpl.l();
                        int m3 = QQFileUtilsImpl.m();
                        if (bundle != null) {
                            int i27 = bundle.getInt("param_fromType", 0);
                            i18 = bundle.getInt("param_V6SelectType", 0);
                            i19 = bundle.getInt("param_ipAddrType", 0);
                            i16 = bundle.getInt("param_ishttps", 0);
                            j27 = j26;
                            i17 = i27;
                        } else {
                            j27 = j26;
                            i16 = 0;
                            i17 = 0;
                            i18 = 0;
                            i19 = 0;
                        }
                        hashMap.put("param_fromType", String.valueOf(i17));
                        hashMap.put("param_V6SelectType", String.valueOf(i18));
                        hashMap.put("param_ipAddrType", String.valueOf(i19));
                        hashMap.put("param_stackType", String.valueOf(l3));
                        hashMap.put("param_loginType", String.valueOf(m3));
                        hashMap.put("param_ishttps", String.valueOf(i16));
                        int i28 = i16;
                        int i29 = i17;
                        long j38 = j27;
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, true, j29, j17, hashMap, str6);
                        if (QLog.isColorLevel()) {
                            QLog.d("@@@@@@@", 2, "ReportFilemanagerInfo actType[" + str + "], isSuccess[true], nSessionId[" + j3 + "], duration[" + j29 + "], rpSize[" + j17 + "], transfSize[" + j18 + "], fileSize[" + j19 + "], retryTimes[" + i3 + "], reserved[" + str6 + "], ipStackType[" + i26 + "] realTransferType[0] speed[" + j37 + "] fromType[" + i29 + "] transferTime[" + j38 + "] isHttps[" + i28 + "]");
                            return;
                        }
                        return;
                    }
                }
                j26 = j29;
                if (j26 > 0) {
                    j28 = ((float) j17) / (((float) j26) / 1000.0f);
                }
                long j372 = j28;
                hashMap.put("param_speed", String.valueOf(j372));
                int l36 = QQFileUtilsImpl.l();
                int m36 = QQFileUtilsImpl.m();
                if (bundle != null) {
                }
                hashMap.put("param_fromType", String.valueOf(i17));
                hashMap.put("param_V6SelectType", String.valueOf(i18));
                hashMap.put("param_ipAddrType", String.valueOf(i19));
                hashMap.put("param_stackType", String.valueOf(l36));
                hashMap.put("param_loginType", String.valueOf(m36));
                hashMap.put("param_ishttps", String.valueOf(i16));
                int i282 = i16;
                int i292 = i17;
                long j382 = j27;
                StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, true, j29, j17, hashMap, str6);
                if (QLog.isColorLevel()) {
                }
            }
        }
        str7 = "";
        int i262 = QQFileUtilsImpl.i();
        hashMap.put("serverip", str7);
        hashMap.put(ReportConstant.KEY_OLD_SERVER_IP, str7);
        hashMap.put("param_ftnIP", str7);
        hashMap.put("param_PeerUin", str3);
        hashMap.put(ReportConstant.KEY_UUID, str4);
        hashMap.put("param_MD5", str5);
        hashMap.put("param_fsized", String.valueOf(j18));
        hashMap.put("param_fsizeo", String.valueOf(j19));
        hashMap.put("param_retry", String.valueOf(i3));
        hashMap.put("param_nSessionId", String.valueOf(j3));
        hashMap.put("param_errMsg", String.valueOf(str6));
        hashMap.put("param_ipStackType", String.valueOf(i262));
        hashMap.put("param_realTransferType", String.valueOf(0));
        if (bundle != null) {
        }
        j26 = j29;
        if (j26 > 0) {
        }
        long j3722 = j28;
        hashMap.put("param_speed", String.valueOf(j3722));
        int l362 = QQFileUtilsImpl.l();
        int m362 = QQFileUtilsImpl.m();
        if (bundle != null) {
        }
        hashMap.put("param_fromType", String.valueOf(i17));
        hashMap.put("param_V6SelectType", String.valueOf(i18));
        hashMap.put("param_ipAddrType", String.valueOf(i19));
        hashMap.put("param_stackType", String.valueOf(l362));
        hashMap.put("param_loginType", String.valueOf(m362));
        hashMap.put("param_ishttps", String.valueOf(i16));
        int i2822 = i16;
        int i2922 = i17;
        long j3822 = j27;
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(baseQQAppInterface.getCurrentAccountUin(), str, true, j29, j17, hashMap, str6);
        if (QLog.isColorLevel()) {
        }
    }

    private static boolean G(int i3) {
        if (i3 == 8 || i3 == 190 || i3 == 1 || i3 == 16 || i3 == 14 || i3 == 15 || i3 == 17 || i3 == 18 || i3 == 19 || i3 == 5 || i3 == 50 || i3 == -1 || i3 == 53 || i3 == 54) {
            return true;
        }
        return false;
    }

    public static long G0(String str) {
        long j3;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0L;
            }
            String S0 = S0(str);
            if (TextUtils.isEmpty(S0)) {
                return 0L;
            }
            if (FileReaderHelper.TXT_EXT.equals(S0.toLowerCase())) {
                j3 = FaceConstant.HeadDownload.QQHEAD_SYSTEM_MIN_STORAGE_SIZE;
            } else {
                j3 = QZoneHelper.Constants.NO_WIFI_UPLOAD_VIDEO_MAX_SIZE_DEFAULT;
            }
            String a16 = TencentDocImportFileInfoProcessor.c().a();
            if (TextUtils.isEmpty(a16)) {
                return j3;
            }
            String[] split = a16.split("#");
            if (split.length == 0) {
                return j3;
            }
            for (String str2 : split) {
                String[] split2 = str2.split("_");
                if (!split2[0].contains(S0) && !split2[0].contains(S0.toLowerCase())) {
                }
                return Long.parseLong(split2[1]);
            }
            return 0L;
        } catch (Exception e16) {
            QLog.e("FileManagerUtil<FileAssistant>", 1, " get docs import file max size exception =" + e16.toString());
            return 0L;
        }
    }

    public static boolean G1(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return false;
        }
        if (q.f(fileManagerEntity.strLargeThumPath) || q.f(fileManagerEntity.strMiddleThumPath)) {
            return true;
        }
        return q.f(fileManagerEntity.strThumbPath);
    }

    public static String G2(int i3, int i16) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        return String.valueOf(0);
                    }
                    return String.valueOf(1);
                }
                return String.valueOf(3);
            }
            if (i16 == 0) {
                return String.valueOf(2);
            }
            return String.valueOf(4);
        }
        return String.valueOf(7);
    }

    public static void H() {
        BaseQQAppInterface A0 = A0();
        List<FileManagerEntity> queryMaxRecentReocrds = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryMaxRecentReocrds(A0);
        if (queryMaxRecentReocrds == null) {
            return;
        }
        for (FileManagerEntity fileManagerEntity : queryMaxRecentReocrds) {
            if (!TextUtils.isEmpty(fileManagerEntity.Uuid)) {
                fileManagerEntity.status = 16;
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).deleteOfflineFile(A0, fileManagerEntity.peerUin, fileManagerEntity.fileName, fileManagerEntity.Uuid, fileManagerEntity.fileIdCrc, fileManagerEntity.bSend);
            }
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).clearAllData(A0);
    }

    public static String H0() {
        return lc1.b.a().getDefaultRecvPath();
    }

    public static boolean H1(Context context, String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return ec.k(context, new String[]{str});
        }
        return b2(str, (ShortcutManager) context.getSystemService(ShortcutManager.class));
    }

    private static void H2(BaseQQAppInterface baseQQAppInterface, String str, Context context) {
        int fromStatisticAssist = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADCANCEL());
        if (fromStatisticAssist > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, fromStatisticAssist, 0, "1", "1", null, null);
        }
        int fromStatisticAssist2 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADCANCEL());
        if (fromStatisticAssist2 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, fromStatisticAssist2, 0, "1", "0", null, null);
        }
        int fromStatisticAssist3 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADPAUSE());
        if (fromStatisticAssist3 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, fromStatisticAssist3, 0, "2", "1", null, null);
        }
        int fromStatisticAssist4 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADPAUSE());
        if (fromStatisticAssist4 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, fromStatisticAssist4, 0, "2", "0", null, null);
        }
        int fromStatisticAssist5 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADENTER());
        if (fromStatisticAssist5 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, fromStatisticAssist5, 0, "0", "1", null, null);
        }
        int fromStatisticAssist6 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADENTER());
        if (fromStatisticAssist6 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, fromStatisticAssist6, 0, "0", "0", null, null);
        }
        int fromStatisticAssist7 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADRUN());
        if (fromStatisticAssist7 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, fromStatisticAssist7, 0, "3", "1", null, null);
        }
        int fromStatisticAssist8 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADRUN());
        if (fromStatisticAssist8 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Start_download", 1, fromStatisticAssist8, 0, "3", "0", null, null);
        }
        int fromStatisticAssist9 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADSUCC());
        if (fromStatisticAssist9 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, fromStatisticAssist9, 0, "0", "1", null, null);
        }
        int fromStatisticAssist10 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMGENDOWNLOADFAILD());
        if (fromStatisticAssist10 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, fromStatisticAssist10, 0, "0", "1", null, null);
        }
        int fromStatisticAssist11 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADSUCC());
        if (fromStatisticAssist11 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Complete_download", 1, fromStatisticAssist11, 0, "0", null, null, null);
        }
        int fromStatisticAssist12 = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFromStatisticAssist(context, str, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getSUNIFORMABSDKDOWNLOADFAILD());
        if (fromStatisticAssist12 > 0) {
            ReportController.n(baseQQAppInterface, "CliOper", "", "", "Download", "Stop_download", 1, fromStatisticAssist12, 0, "0", "0", null, null);
        }
    }

    public static void I(Context context) {
        context.getSharedPreferences("LAST_CHOOSE_", 0).edit().clear().commit();
    }

    public static int I0(int i3) {
        return J0(i3, 2);
    }

    public static boolean I1(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return false;
        }
        if (q.f(fileManagerEntity.getFilePath()) || q.f(fileManagerEntity.strMiddleThumPath) || q.f(fileManagerEntity.strLargeThumPath) || q.f(fileManagerEntity.strThumbPath)) {
            return true;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "] no Thumb!");
        return false;
    }

    public static void I2(Context context, FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, boolean z16) {
        kc1.c.m(fileManagerEntity).d(z16, context, new d(fileManagerEntity, baseQQAppInterface));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean J(FileManagerEntity fileManagerEntity, FileManagerEntity fileManagerEntity2) {
        String str = fileManagerEntity.Uuid;
        if (str != null && str.equals(fileManagerEntity2.Uuid)) {
            return true;
        }
        String str2 = fileManagerEntity2.strFileSHA;
        if (str2 != null && str2.equals(fileManagerEntity.strFileSHA)) {
            return true;
        }
        String str3 = fileManagerEntity2.strFileMd5;
        if (str3 != null && (str3.equals(fileManagerEntity.strFileMd5) || fileManagerEntity2.strFileMd5.equals(fileManagerEntity.str10Md5))) {
            return true;
        }
        String str4 = fileManagerEntity2.strTroopFileSha1;
        if (str4 != null && str4.equals(fileManagerEntity.strTroopFileSha1)) {
            return true;
        }
        String str5 = fileManagerEntity2.strFileSha3;
        if (str5 != null && str5.equals(fileManagerEntity.strFileSha3)) {
            return true;
        }
        String str6 = fileManagerEntity2.str10Md5;
        if (str6 != null && str6.equals(fileManagerEntity.str10Md5)) {
            return true;
        }
        return false;
    }

    public static int J0(int i3, int i16) {
        if (i3 != 12) {
            if (i3 != 14) {
                if (i3 != 16) {
                    if (i3 != 21) {
                        switch (i3) {
                            case 0:
                                return R.drawable.filelook_image;
                            case 1:
                                return R.drawable.filelook_audio;
                            case 2:
                                return R.drawable.filelook_video;
                            case 3:
                                return R.drawable.filelook_doc;
                            case 4:
                                return R.drawable.filelook_zip;
                            case 5:
                                return R.drawable.filelook_apk;
                            case 6:
                                return R.drawable.filelook_xls;
                            case 7:
                                return R.drawable.filelook_ppt;
                            case 8:
                                return R.drawable.filelook_html;
                            case 9:
                                return R.drawable.filelook_pdf;
                            case 10:
                                return R.drawable.filelook_txt;
                            default:
                                return R.drawable.filelook_unknown;
                        }
                    }
                    return R.drawable.filelook_sketch;
                }
                return R.drawable.filelook_ipa;
            }
            return R.drawable.filelook_ai;
        }
        return R.drawable.filelook_ps;
    }

    public static String J1(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return "";
        }
        for (byte b16 : bArr) {
            String hexString = Integer.toHexString(b16 & 255);
            if (hexString.length() == 1) {
                hexString = '0' + hexString;
            }
            System.out.print(hexString.toUpperCase() + " ");
            stringBuffer.append(hexString.toUpperCase() + "");
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void J2(final FileManagerEntity fileManagerEntity, final ah.a aVar, final BaseQQAppInterface baseQQAppInterface) {
        if (fileManagerEntity == null) {
            QLog.w("CHECK_FILE_EXISTED", 1, "checkFileExisted: entity is null");
            if (aVar != null) {
                aVar.a(false);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i("CHECK_FILE_EXISTED", 1, "checkFile 10md5[" + fileManagerEntity.str10Md5 + "], sha3[" + fileManagerEntity.strFileSha3 + "], md5[" + fileManagerEntity.strFileMd5 + "]");
        }
        int i3 = fileManagerEntity.nFileType;
        if (i3 == 0 || i3 == 2) {
            new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.19
                @Override // java.lang.Runnable
                public void run() {
                    final FileManagerEntity fileManagerEntity2;
                    IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
                    BaseQQAppInterface baseQQAppInterface2 = BaseQQAppInterface.this;
                    FileManagerEntity fileManagerEntity3 = fileManagerEntity;
                    List<FileManagerEntity> queryFileManagerEntityByNameAndSize = iQQFileTempUtils.queryFileManagerEntityByNameAndSize(baseQQAppInterface2, fileManagerEntity3.fileName, fileManagerEntity3.fileSize);
                    if (QLog.isColorLevel()) {
                        QLog.i("CHECK_FILE_EXISTED", 1, "find file size[" + queryFileManagerEntityByNameAndSize.size() + "]");
                    }
                    Iterator<FileManagerEntity> it = queryFileManagerEntityByNameAndSize.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            fileManagerEntity2 = it.next();
                            if (fileManagerEntity2 != fileManagerEntity) {
                                long lastModified = new VFSFile(fileManagerEntity2.getFilePath()).lastModified();
                                if (fileManagerEntity2.localModifyTime != lastModified) {
                                    QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, but local modified,localModifyTime[" + fileManagerEntity2.localModifyTime + "], fileModified[" + lastModified + "]");
                                } else {
                                    if (QLog.isColorLevel()) {
                                        QLog.i("CHECK_FILE_EXISTED", 1, fileManagerEntity2.fileName + " findFile 10md5[" + fileManagerEntity2.str10Md5 + "], sha3[" + fileManagerEntity2.strFileSha3 + "], md5[" + fileManagerEntity2.strFileMd5 + "]");
                                    }
                                    if (QQFileManagerUtilImpl.J(fileManagerEntity2, fileManagerEntity)) {
                                        break;
                                    }
                                }
                            }
                        } else {
                            fileManagerEntity2 = null;
                            break;
                        }
                    }
                    if (fileManagerEntity2 == null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("CHECK_FILE_EXISTED", 1, "cann't find exsited file,entity[" + fileManagerEntity.fileName + "]");
                        }
                        ah.a aVar2 = aVar;
                        if (aVar2 != null) {
                            aVar2.a(false);
                            return;
                        }
                        return;
                    }
                    ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            fileManagerEntity.strFileSha3 = QQFileManagerUtilImpl.J1(QQFileManagerUtilImpl.u1(fileManagerEntity2.getFilePath()));
                            QLog.i("CHECK_FILE_EXISTED", 1, "find exsited file, set file download sucessed!");
                            FileManagerEntity fileManagerEntity4 = fileManagerEntity;
                            fileManagerEntity4.status = 1;
                            fileManagerEntity4.cloudType = 3;
                            fileManagerEntity4.setFilePath(fileManagerEntity2.getFilePath());
                            IQQFileTempUtils iQQFileTempUtils2 = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
                            AnonymousClass19 anonymousClass19 = AnonymousClass19.this;
                            iQQFileTempUtils2.updateFileEntity(BaseQQAppInterface.this, fileManagerEntity);
                            IQQFileTempUtils iQQFileTempUtils3 = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
                            AnonymousClass19 anonymousClass192 = AnonymousClass19.this;
                            BaseQQAppInterface baseQQAppInterface3 = BaseQQAppInterface.this;
                            FileManagerEntity fileManagerEntity5 = fileManagerEntity;
                            iQQFileTempUtils3.notifyItemStatus(baseQQAppInterface3, fileManagerEntity5.uniseq, fileManagerEntity5.nSessionId, fileManagerEntity5.peerUin, fileManagerEntity5.peerType, 11, new Object[]{fileManagerEntity5.getFilePath(), Long.valueOf(fileManagerEntity.fileSize), Boolean.TRUE, ""}, 0, null);
                            ((IFileManagerDepend) QRoute.api(IFileManagerDepend.class)).updateC2CVideoPlayStatus(fileManagerEntity, 4);
                            ah.a aVar3 = aVar;
                            if (aVar3 != null) {
                                aVar3.a(true);
                            }
                        }
                    });
                }
            });
        }
    }

    public static void K(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            QLog.w("FileManagerUtil<FileAssistant>", 1, "entity null!");
            return;
        }
        if (!fileManagerEntity.isCheckPrivateDir) {
            fileManagerEntity.isCheckPrivateDir = true;
            String filePath = fileManagerEntity.getFilePath();
            if (filePath != null && filePath.contains("/Tencent/QQfile_recv/")) {
                fileManagerEntity.setFilePath(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(fileManagerEntity.getFilePath()));
            }
            String str = fileManagerEntity.strThumbPath;
            if (str != null && str.contains("/Tencent/QQfile_recv/")) {
                fileManagerEntity.strThumbPath = ((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(fileManagerEntity.strThumbPath);
            }
            String str2 = fileManagerEntity.strMiddleThumPath;
            if (str2 != null && str2.contains("/Tencent/QQfile_recv/")) {
                fileManagerEntity.strMiddleThumPath = ((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(fileManagerEntity.strMiddleThumPath);
            }
            String str3 = fileManagerEntity.strLargeThumPath;
            if (str3 != null && str3.contains("/Tencent/QQfile_recv/")) {
                fileManagerEntity.strLargeThumPath = ((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(fileManagerEntity.strLargeThumPath);
            }
        }
        int i3 = fileManagerEntity.nFileType;
        if (i3 == -1 || i3 == 5) {
            String filePath2 = fileManagerEntity.getFilePath();
            if (filePath2 != null) {
                if (!filePath2.isEmpty()) {
                    fileManagerEntity.nFileType = T0(filePath2);
                }
                if (filePath2.startsWith(AppConstants.SDCARD_PATH + "/Android/data/com.tencent.mobileqq")) {
                    fileManagerEntity.setFilePath(((IFileSandboxPathUtilApi) QRoute.api(IFileSandboxPathUtilApi.class)).getSandboxPath(fileManagerEntity.getFilePath()));
                    return;
                }
                return;
            }
            if (fileManagerEntity.getCloudType() != 3 && fileManagerEntity.getCloudType() != 5) {
                String str4 = fileManagerEntity.strSrcName;
                if (str4 != null && str4.length() > 0) {
                    fileManagerEntity.nFileType = T0(fileManagerEntity.strSrcName);
                    return;
                } else {
                    fileManagerEntity.nFileType = T0(fileManagerEntity.fileName);
                    return;
                }
            }
            fileManagerEntity.nFileType = T0(fileManagerEntity.fileName);
        }
    }

    public static int K0(String str) {
        String j3 = q.j(str);
        if (j3 == null) {
            return R.drawable.f161608ea0;
        }
        return I0(T0(j3));
    }

    public static boolean K1(Context context, FileManagerEntity fileManagerEntity) {
        if (V1(context) && (fileManagerEntity.fileSize > G0(fileManagerEntity.fileName) || !r0(fileManagerEntity.fileName, bp.b().f292115a) || (!((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).isSelected(fileManagerEntity) && ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getRecentFiles().size() != 0))) {
            return true;
        }
        return false;
    }

    public static void K2(String str, int i3) {
        BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putInt("qlink_new_count_" + str, i3).commit();
    }

    public static FileManagerEntity L(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage) {
        int i3;
        if (chatMessage == null || !QQFileUtilsImpl.b(chatMessage)) {
            return null;
        }
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardFileType");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            i3 = Integer.parseInt(extInfoFromExtStr);
        } else {
            i3 = -1;
        }
        if (i3 != 1 && i3 != 2) {
            return null;
        }
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = w0().longValue();
        fileManagerEntity.uniseq = chatMessage.uniseq;
        fileManagerEntity.selfUin = baseQQAppInterface.getAccount();
        fileManagerEntity.isReaded = false;
        fileManagerEntity.peerUin = chatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        QQFileUtilsImpl.d(baseQQAppInterface, fileManagerEntity, chatMessage);
        fileManagerEntity.peerNick = l1(baseQQAppInterface, fileManagerEntity.peerUin, null, fileManagerEntity.peerType);
        fileManagerEntity.Uuid = chatMessage.getExtInfoFromExtStr("_m_ForwardUuid");
        fileManagerEntity.fileIdCrc = chatMessage.getExtInfoFromExtStr("_m_ForwardFileIdCrc");
        fileManagerEntity.fileName = chatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
        String extInfoFromExtStr2 = chatMessage.getExtInfoFromExtStr("_m_ForwardSize");
        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
            fileManagerEntity.fileSize = Long.parseLong(extInfoFromExtStr2);
        }
        String extInfoFromExtStr3 = chatMessage.getExtInfoFromExtStr("_m_ForwardSenderUin");
        if (!TextUtils.isEmpty(fileManagerEntity.selfUin)) {
            if (fileManagerEntity.selfUin.equals(extInfoFromExtStr3)) {
                fileManagerEntity.nOpType = 0;
            } else {
                fileManagerEntity.nOpType = 1;
            }
        }
        fileManagerEntity.status = -1;
        String extInfoFromExtStr4 = chatMessage.getExtInfoFromExtStr("_m_ForwardReceiverUin");
        if (!TextUtils.isEmpty(fileManagerEntity.selfUin)) {
            fileManagerEntity.bSend = !fileManagerEntity.selfUin.equals(extInfoFromExtStr4);
        }
        String extInfoFromExtStr5 = chatMessage.getExtInfoFromExtStr("_m_ForwardFilePath");
        if (FileUtils.fileExistsAndNotEmpty(extInfoFromExtStr5)) {
            fileManagerEntity.setFilePath(extInfoFromExtStr5);
            fileManagerEntity.setCloudType(3);
        } else {
            fileManagerEntity.setCloudType(1);
        }
        fileManagerEntity.strFileMd5 = chatMessage.getExtInfoFromExtStr("_m_ForwardMd5");
        fileManagerEntity.strFileSHA = chatMessage.getExtInfoFromExtStr("_m_ForwardSha");
        try {
            fileManagerEntity.imgWidth = Integer.parseInt(chatMessage.getExtInfoFromExtStr("_m_ForwardImgWidth"));
        } catch (NumberFormatException unused) {
        }
        try {
            fileManagerEntity.imgHeight = Integer.parseInt(chatMessage.getExtInfoFromExtStr("_m_ForwardImgHeight"));
        } catch (NumberFormatException unused2) {
        }
        t2(baseQQAppInterface, fileManagerEntity);
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertToMemMapByFileManagerProxy(baseQQAppInterface, fileManagerEntity);
        z(chatMessage);
        return fileManagerEntity;
    }

    public static FileManagerEntity L0(BaseQQAppInterface baseQQAppInterface, MessageForFile messageForFile) {
        FileManagerEntity queryFileEntityByUniseq = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq(baseQQAppInterface, messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
        if (queryFileEntityByUniseq == null) {
            FileManagerEntity fileEntityByUniseq = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFileEntityByUniseq(baseQQAppInterface, messageForFile.uniseq, messageForFile.frienduin, messageForFile.istroop);
            if (QLog.isColorLevel()) {
                QLog.d("FileManager", 2, "QueryFileEntityByUniseq return null, create new! sessionId[" + fileEntityByUniseq.nSessionId + "], messageId[" + fileEntityByUniseq.uniseq + "], peerUin[" + m0(fileEntityByUniseq.peerUin) + "], peerType[" + fileEntityByUniseq.peerType + "]");
            }
            String entityUuidByEntityManager = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).setEntityUuidByEntityManager(baseQQAppInterface, messageForFile);
            if (!entityUuidByEntityManager.equals("")) {
                fileEntityByUniseq.Uuid = entityUuidByEntityManager;
            }
            fileEntityByUniseq.status = v1(messageForFile.status);
            if (messageForFile.isSend()) {
                fileEntityByUniseq.setCloudType(3);
                if (TextUtils.isEmpty(messageForFile.url)) {
                    fileEntityByUniseq.status = 16;
                } else {
                    fileEntityByUniseq.setFilePath(messageForFile.url);
                }
            } else {
                fileEntityByUniseq.setCloudType(1);
                fileEntityByUniseq.lastTime = (messageForFile.time * 1000) + 604800000;
                if (fileEntityByUniseq.status == 1) {
                    fileEntityByUniseq.setCloudType(3);
                    fileEntityByUniseq.setFilePath(messageForFile.url);
                }
            }
            fileEntityByUniseq.fileName = messageForFile.fileName;
            fileEntityByUniseq.fileSize = messageForFile.fileSize;
            fileEntityByUniseq.nOpType = !messageForFile.isSend() ? 1 : 0;
            String str = messageForFile.frienduin;
            fileEntityByUniseq.peerUin = str;
            fileEntityByUniseq.peerType = messageForFile.istroop;
            fileEntityByUniseq.peerNick = l1(baseQQAppInterface, String.valueOf(str), null, messageForFile.istroop);
            fileEntityByUniseq.srvTime = messageForFile.time * 1000;
            fileEntityByUniseq.strServerPath = messageForFile.urlAtServer;
            fileEntityByUniseq.fProgress = ((float) ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getProgress(baseQQAppInterface, messageForFile.frienduin, messageForFile.fileSize, messageForFile.uniseq, messageForFile.istroop)) / 100.0f;
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertToMemMap(baseQQAppInterface, fileEntityByUniseq);
            fileEntityByUniseq.bDelInFM = true;
            return fileEntityByUniseq;
        }
        return queryFileEntityByUniseq;
    }

    public static void L1() {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.5
            @Override // java.lang.Runnable
            public void run() {
                PosixFilePermission posixFilePermission;
                PosixFilePermission posixFilePermission2;
                PosixFilePermission posixFilePermission3;
                PosixFilePermission posixFilePermission4;
                PosixFilePermission posixFilePermission5;
                PosixFilePermission posixFilePermission6;
                PosixFilePermission posixFilePermission7;
                Path path;
                QLog.i("FilePermission", 1, "initNoMedia run");
                String defaultRecvPath = lc1.b.a().getDefaultRecvPath();
                String defaultTmpPath = lc1.b.a().getDefaultTmpPath();
                File file = new File(defaultRecvPath);
                if (!FileUtils.fileExists(defaultRecvPath)) {
                    file.mkdirs();
                }
                File file2 = new File(defaultTmpPath);
                if (!FileUtils.fileExists(defaultTmpPath)) {
                    file2.mkdirs();
                }
                File file3 = new File(lc1.b.a().getDefaultRecvPath() + ".nomedia");
                if (file3.exists()) {
                    file3.delete();
                }
                try {
                    QLog.i("FilePermission", 1, "set 777 " + defaultRecvPath);
                    RuntimeMonitor.exec(Runtime.getRuntime(), "chmod 777 " + defaultRecvPath);
                } catch (IOException e16) {
                    QLog.i("FilePermission", 1, "set 777 exception");
                    e16.printStackTrace();
                }
                if (Build.VERSION.SDK_INT < 26) {
                    QLog.i("FilePermission", 1, "ver less O");
                    return;
                }
                ArrayList<FileInfo> n3 = q.n(defaultRecvPath, false, 0);
                if (n3 == null) {
                    QLog.i("FilePermission", 1, "NoFile need set");
                    return;
                }
                HashSet hashSet = new HashSet();
                posixFilePermission = PosixFilePermission.OWNER_WRITE;
                hashSet.add(posixFilePermission);
                posixFilePermission2 = PosixFilePermission.OWNER_READ;
                hashSet.add(posixFilePermission2);
                posixFilePermission3 = PosixFilePermission.OWNER_EXECUTE;
                hashSet.add(posixFilePermission3);
                posixFilePermission4 = PosixFilePermission.GROUP_READ;
                hashSet.add(posixFilePermission4);
                posixFilePermission5 = PosixFilePermission.GROUP_WRITE;
                hashSet.add(posixFilePermission5);
                posixFilePermission6 = PosixFilePermission.OTHERS_READ;
                hashSet.add(posixFilePermission6);
                posixFilePermission7 = PosixFilePermission.OTHERS_WRITE;
                hashSet.add(posixFilePermission7);
                Iterator<FileInfo> it = n3.iterator();
                while (it.hasNext()) {
                    FileInfo next = it.next();
                    if (!next.m()) {
                        try {
                            path = Paths.get(next.k(), new String[0]);
                            Files.setPosixFilePermissions(path, hashSet);
                        } catch (Throwable th5) {
                            QLog.i("FilePermission", 1, "set file throwable", th5);
                            th5.printStackTrace();
                        }
                    }
                }
            }
        }, 8, null, false);
    }

    public static void L2(final Context context, final String str) {
        if (!new VFSFile(str).exists()) {
            QQFMToastUtil.e(context, 0, R.string.bfa);
        } else {
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (Utils.z() < QQFileManagerUtilImpl.Q0(str)) {
                            com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.mio));
                        } else if (TextUtils.isEmpty(l.a(str))) {
                            com.tencent.mobileqq.filemanager.util.d.f(HardCodeUtil.qqStr(R.string.f212495no));
                        } else {
                            com.tencent.mobileqq.filemanager.util.d.b(context, 2, R.string.bfd);
                        }
                    } catch (Exception unused) {
                        com.tencent.mobileqq.filemanager.util.d.b(context, 0, R.string.bfc);
                    } catch (OutOfMemoryError unused2) {
                        com.tencent.mobileqq.filemanager.util.d.b(context, 0, R.string.mio);
                    }
                }
            }, 8, null, true);
        }
    }

    public static void M(FileManagerEntity fileManagerEntity) {
        int i3 = fileManagerEntity.nFileType;
        if (i3 == 0) {
            if (fileManagerEntity.imgHeight <= 0 || fileManagerEntity.imgWidth <= 0) {
                if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                    int[] a16 = a1(fileManagerEntity.getFilePath());
                    fileManagerEntity.imgWidth = a16[0];
                    fileManagerEntity.imgHeight = a16[1];
                }
                QLog.i("FileManagerUtil<FileAssistant>", 1, "localPic[" + fileManagerEntity.nSessionId + "] get thumbsize success size(wh)[" + fileManagerEntity.imgWidth + ":" + fileManagerEntity.imgHeight + "]");
            }
            URL createFilePicDrawlableURLWithSend = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).createFilePicDrawlableURLWithSend(fileManagerEntity);
            if (createFilePicDrawlableURLWithSend != null) {
                URLDrawable drawable = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getDrawable(createFilePicDrawlableURLWithSend);
                int i16 = fileManagerEntity.peerType;
                if (i16 == 6000 || i16 == 6005 || i16 == 6003) {
                    drawable.setIgnorePause(true);
                }
                drawable.downloadImediatly();
            }
            if (ZhuoXusManager.instance().isSendFileQRCodeOpen() && n0(fileManagerEntity.strMiddleThumPath)) {
                Pair<StringBuilder, StringBuilder> qRCodeResult = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getQRCodeResult(BaseApplication.getContext(), new File(fileManagerEntity.strMiddleThumPath));
                if (qRCodeResult != null) {
                    fileManagerEntity.strQRUrl = ((StringBuilder) qRCodeResult.first).toString();
                    if (QLog.isDevelopLevel()) {
                        QLog.i("IMG_FILE_QR", 1, "createMediThumbnail success:" + fileManagerEntity.strQRUrl);
                        return;
                    }
                    return;
                }
                if (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getIsQRing()) {
                    fileManagerEntity.strQRUrl = null;
                    return;
                } else {
                    fileManagerEntity.strQRUrl = "";
                    return;
                }
            }
            return;
        }
        if (i3 == 2) {
            ah.g Z2 = Z2(fileManagerEntity.getFilePath());
            if (Z2.f209330a == -1) {
                return;
            }
            fileManagerEntity.strLargeThumPath = Z2.f209331b;
            if (fileManagerEntity.imgHeight > 0 && fileManagerEntity.imgWidth > 0) {
                if (QLog.isColorLevel()) {
                    QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "] has size(wh)[" + fileManagerEntity.imgWidth + ":" + fileManagerEntity.imgHeight + "]");
                }
            } else {
                fileManagerEntity.imgWidth = Z2.f209332c;
                fileManagerEntity.imgHeight = Z2.f209333d;
                if (QLog.isColorLevel()) {
                    QLog.i("FileManagerUtil<FileAssistant>", 1, "Id[" + fileManagerEntity.nSessionId + "]get local video,(wh)[" + fileManagerEntity.imgWidth + ":" + fileManagerEntity.imgHeight + "]");
                }
            }
            QLog.i("FileManagerUtil<FileAssistant>", 1, "localvideo[" + fileManagerEntity.nSessionId + "] create thumb success size(wh)[" + fileManagerEntity.imgWidth + ":" + fileManagerEntity.imgHeight + "]");
        }
    }

    public static String M0(String str) {
        return FileUtils.getFileName(str);
    }

    public static void M1(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context) {
        if (chatMessage == null || !(chatMessage instanceof MessageForFile)) {
            return;
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).sendFileToDataline(baseQQAppInterface, context, L0(baseQQAppInterface, (MessageForFile) chatMessage));
    }

    public static void M2(String str, String str2, boolean z16) {
        BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).edit().putBoolean("qlink_new_flag_" + str + "_" + str2, z16).commit();
    }

    public static ah.e N(int i3, String str) {
        ah.e eVar = new ah.e();
        if (i3 == 0) {
            int[] a16 = a1(str);
            eVar.f209327a = a16[0];
            eVar.f209328b = a16[1];
        } else if (i3 == 2) {
            ah.g Z2 = Z2(str);
            if (Z2.f209330a == -1) {
                return eVar;
            }
            eVar.f209327a = Z2.f209332c;
            eVar.f209328b = Z2.f209333d;
            eVar.f209329c = Z2.f209331b;
        }
        return eVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x02a1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String N0(FileManagerEntity fileManagerEntity) {
        String str;
        BaseQQAppInterface A0;
        String str2 = "";
        BaseApplication context = BaseApplication.getContext();
        if (f209232f.size() == 0) {
            f209232f.put(1, context.getString(R.string.b6o));
            f209232f.put(9, context.getString(R.string.b6o));
            f209232f.put(10, context.getString(R.string.b6o));
            f209232f.put(11, context.getString(R.string.b6o));
            f209232f.put(12, context.getString(R.string.b6o));
            f209232f.put(13, context.getString(R.string.b6o));
            f209232f.put(6, context.getString(R.string.b6v));
            f209232f.put(4, context.getString(R.string.b6v));
            f209232f.put(20, context.getString(R.string.b6v));
            f209232f.put(22, context.getString(R.string.b77));
            f209232f.put(21, context.getString(R.string.b77));
            f209232f.put(0, context.getString(R.string.b77));
            f209232f.put(7, context.getString(R.string.b77));
            f209232f.put(3, context.getString(R.string.b77));
            f209232f.put(24, context.getString(R.string.b77));
            f209232f.put(5, context.getString(R.string.b6p));
            f209232f.put(50, context.getString(R.string.b6p));
            f209232f.put(14, context.getString(R.string.i_4));
            f209232f.put(15, context.getString(R.string.i_5));
            f209232f.put(16, context.getString(R.string.i__));
            f209232f.put(17, context.getString(R.string.i_7));
            f209232f.put(18, context.getString(R.string.i_6));
            f209232f.put(19, context.getString(R.string.i_8));
            f209232f.put(190, context.getString(R.string.i_a));
            f209232f.put(40, context.getString(R.string.i_9));
            f209232f.put(52, context.getString(R.string.zyd));
            f209232f.put(53, context.getString(R.string.f237097g5));
            f209232f.put(54, context.getString(R.string.f237107g6));
            f209232f.put(55, context.getString(R.string.f237077g3));
        }
        String k16 = k1(fileManagerEntity, context, f209232f.get(Integer.valueOf(fileManagerEntity.nOpType)));
        if (fileManagerEntity.getCloudType() == 0) {
            k16 = context.getString(R.string.b6o);
        }
        String str3 = null;
        if (fileManagerEntity.getCloudType() == 5) {
            k16 = context.getString(R.string.b6o);
            if (fileManagerEntity.bSend) {
                k16 = context.getString(R.string.b77);
            }
            str = fileManagerEntity.peerNick;
        } else {
            str = null;
        }
        if (fileManagerEntity.getCloudType() != 16 && fileManagerEntity.nOpType != 57) {
            if (fileManagerEntity.getCloudType() != 15 && fileManagerEntity.nOpType != 56) {
                String i16 = i1(fileManagerEntity, context, k16, str);
                if (fileManagerEntity.nOpType == 1 && fileManagerEntity.bSend) {
                    k16 = context.getString(R.string.b77);
                }
                try {
                    A0 = A0();
                    i16 = l1(A0, fileManagerEntity.peerUin, "", fileManagerEntity.peerType);
                    if (fileManagerEntity.TroopUin != 0) {
                        i16 = h1(fileManagerEntity, context, i16, A0);
                        k16 = null;
                    }
                    if (k16 != null && k16.equals(context.getString(R.string.b6v))) {
                        i16 = null;
                    }
                } catch (Exception unused) {
                }
                if (fileManagerEntity.peerType == 3000 && ((k16 != null && !k16.equals(context.getString(R.string.b6v))) || fileManagerEntity.nOpType == 28)) {
                    i16 = g1(fileManagerEntity, context, i16, A0);
                    if (TextUtils.isEmpty(fileManagerEntity.guildId)) {
                        i16 = j1(context, fileManagerEntity);
                    } else if (fileManagerEntity.peerType == com.tencent.mobileqq.filemanager.data.e.f207742a) {
                        i16 = "";
                    }
                    if (str3 == null && str3.equalsIgnoreCase(context.getString(R.string.b6p)) && fileManagerEntity.bSend) {
                        return context.getString(R.string.b77) + " " + i16;
                    }
                    if (fileManagerEntity.nOpType != 58) {
                        if (!TextUtils.isEmpty(fileManagerEntity.peerNick)) {
                            str2 = fileManagerEntity.peerNick + " ";
                        }
                        return context.getString(R.string.b6o) + " " + str2 + context.getString(R.string.f237087g4);
                    }
                    if (str3 != null && i16 != null) {
                        return str3 + " " + i16;
                    }
                    if (str3 != null) {
                        return str3;
                    }
                    return i16;
                }
                str3 = k16;
                if (TextUtils.isEmpty(fileManagerEntity.guildId)) {
                }
                if (str3 == null) {
                }
                if (fileManagerEntity.nOpType != 58) {
                }
            } else {
                return context.getString(R.string.b6o) + " " + context.getString(R.string.f230536ze);
            }
        } else {
            return context.getString(R.string.b6o) + " " + context.getString(R.string.zwn);
        }
    }

    public static boolean N1(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context) {
        return O1(baseQQAppInterface, chatMessage, context, false);
    }

    public static void N2(ImageView imageView, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity.nFileType == 13) {
            Drawable drawable = BaseApplication.getContext().getResources().getDrawable(R.drawable.f161608ea0);
            try {
                if (fileManagerEntity.strThumbPath == null) {
                    imageView.setImageDrawable(drawable);
                    return;
                } else {
                    imageView.setImageDrawable(URLDrawable.getDrawable(new URL(fileManagerEntity.strThumbPath), drawable, drawable));
                    return;
                }
            } catch (Exception unused) {
                imageView.setImageDrawable(drawable);
                return;
            }
        }
        if (fileManagerEntity.searchPCPart.f207687c) {
            imageView.setImageResource(R.drawable.filelook_floder);
            return;
        }
        String j3 = q.j(fileManagerEntity.fileName);
        if (TextUtils.isEmpty(j3)) {
            imageView.setImageResource(R.drawable.f161608ea0);
        } else {
            imageView.setImageResource(K0(j3));
        }
    }

    public static String O(String str, int i3, int i16, ah.d dVar) {
        if (TextUtils.isEmpty(str)) {
            if (dVar != null) {
                dVar.onResult(null);
            }
            return null;
        }
        VFSFile vFSFile = new VFSFile(lc1.b.a().getDefaultThumbPath());
        if (!vFSFile.exists()) {
            vFSFile.mkdirs();
        }
        String str2 = lc1.b.a().getDefaultThumbPath() + M0(str) + ".JPG";
        if (q.f(str2)) {
            if (dVar != null) {
                dVar.onResult(str2);
            }
            return str2;
        }
        int T0 = T0(str);
        if (T0 == 0) {
            if (!Q(str, i3, i16, dVar, str2)) {
                return null;
            }
        } else if (T0 == 2) {
            R(str, i3, i16, dVar, str2);
        } else {
            if (dVar != null) {
                dVar.onResult(null);
            }
            return null;
        }
        return str2;
    }

    public static FileManagerEntity O0(BaseQQAppInterface baseQQAppInterface, long j3, String str, int i3, ChatMessage chatMessage) {
        FileManagerEntity queryFileEntityByUniseq = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq(baseQQAppInterface, j3, str, i3);
        if (queryFileEntityByUniseq == null) {
            return L(baseQQAppInterface, chatMessage);
        }
        return queryFileEntityByUniseq;
    }

    public static boolean O1(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage, Context context, boolean z16) {
        String str;
        ReportController.o(baseQQAppInterface, "CliOper", "", "", "0X800644C", "0X800644C", 0, 0, "6", "", "", "");
        if (chatMessage == null || !(chatMessage instanceof MessageForFile)) {
            return false;
        }
        MessageForFile messageForFile = (MessageForFile) chatMessage;
        FileManagerEntity L0 = L0(baseQQAppInterface, messageForFile);
        int cloudType = L0.getCloudType();
        if (cloudType != 1) {
            if (cloudType != 3 && cloudType != 5) {
                return false;
            }
            if (!z16) {
                com.tencent.mobileqq.filemanager.util.d.d(context.getString(R.string.f170978be3));
            }
            ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).startSave2Weiyun();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).sendLocalFile(baseQQAppInterface, L0.getFilePath(), null, baseQQAppInterface.getAccount(), 0, false);
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).updateFileEntity(baseQQAppInterface, L0);
            if (QLog.isColorLevel()) {
                QLog.i("@-@", 1, "mEntity[" + L0.nSessionId + "]'s relateId[" + L0.nRelatedSessionId + "] reInit");
            }
            return true;
        }
        if (chatMessage.isSend()) {
            str = baseQQAppInterface.getCurrentAccountUin();
        } else {
            str = messageForFile.frienduin;
        }
        if (!z16) {
            com.tencent.mobileqq.filemanager.util.d.d(context.getString(R.string.f170978be3));
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).saveOfflineFile2WeiYun(baseQQAppInterface, L0, str);
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).updateFileEntity(baseQQAppInterface, L0);
        if (QLog.isColorLevel()) {
            QLog.i("@-@", 1, "mEntity[" + L0.nSessionId + "]'s relateId[" + L0.nRelatedSessionId + "] No reInit,Show Juhua");
        }
        FileManagerReporter.a aVar = new FileManagerReporter.a();
        aVar.f209157b = "file_to_weiyun";
        aVar.f209158c = 9;
        aVar.f209160e = L0.fileSize;
        aVar.f209159d = q.j(L0.fileName);
        FileManagerReporter.addData(baseQQAppInterface.getCurrentAccountUin(), aVar);
        return true;
    }

    public static void O2(ImageView imageView, String str) {
        String j3 = q.j(str);
        if (j3 == null) {
            imageView.setImageResource(R.drawable.f161608ea0);
        } else {
            imageView.setImageResource(K0(j3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean P(String str, int i3, int i16, ah.d dVar, String str2) {
        Bitmap imageThumbnail = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getImageThumbnail(str, i3, i16);
        if (imageThumbnail == null) {
            if (dVar != null) {
                dVar.onResult(null);
            }
            return true;
        }
        try {
            q.q(imageThumbnail, str2);
            imageThumbnail.recycle();
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).setImageDegree(str2, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getImageDegree(str));
            if (dVar != null) {
                dVar.onResult(str2);
                return false;
            }
            return false;
        } catch (FileNotFoundException e16) {
            B(dVar, e16, "createThumbnail FileNotFoundException:");
            return true;
        } catch (IOException e17) {
            B(dVar, e17, "createThumbnail IOException:");
            return true;
        } catch (OutOfMemoryError e18) {
            e18.printStackTrace();
            QLog.w("FileManagerUtil<FileAssistant>", 1, "createThumbnail OutOfMemoryError:" + e18.getMessage());
            if (dVar != null) {
                dVar.onResult(null);
            }
            return true;
        }
    }

    public static String P0(FileManagerEntity fileManagerEntity) {
        String string;
        String i26;
        String string2;
        BaseApplication context = BaseApplication.getContext();
        String string3 = context.getString(R.string.b78);
        int cloudType = fileManagerEntity.getCloudType();
        if (cloudType != 1) {
            string = null;
            if (cloudType != 2) {
                if (cloudType != 5) {
                    i26 = null;
                } else {
                    string2 = context.getString(R.string.f4g);
                }
            } else {
                string2 = context.getString(R.string.b7s);
            }
            string = string2;
            i26 = null;
        } else {
            string = context.getString(R.string.b6d);
            i26 = i2(fileManagerEntity.srvTime, fileManagerEntity.peerType);
        }
        if (string == null) {
            string = "" + r(string3, i26);
        }
        if (fileManagerEntity.getCloudType() == 2 && 3 == fileManagerEntity.nOpType) {
            return string;
        }
        if (fileManagerEntity.getCloudType() == 5) {
            return string;
        }
        if (fileManagerEntity.getCloudType() == 16 || fileManagerEntity.getCloudType() == 15) {
            return "";
        }
        if (fileManagerEntity.TroopUin != 0) {
            return string;
        }
        int i3 = fileManagerEntity.peerType;
        if (i3 == 10014 || i3 == com.tencent.mobileqq.filemanager.data.e.f207742a) {
            i26 = "";
        }
        if (i26 == null) {
            return "";
        }
        return i26;
    }

    public static void P1(Context context, String str) {
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            QQFMToastUtil.i(R.string.bet);
            return;
        }
        Intent openApkIntent = FileProvider7Helper.openApkIntent(context, str);
        openApkIntent.putExtra("big_brother_source_key", "biz_src_jc_file");
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), openApkIntent, 65536);
        boolean z16 = true;
        if (queryIntentActivities.size() != 1 || !queryIntentActivities.get(0).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity")) {
            z16 = false;
        }
        if (queryIntentActivities.size() > 0 && !z16) {
            try {
                context.startActivity(openApkIntent);
                return;
            } catch (ActivityNotFoundException unused) {
                QQFMToastUtil.i(R.string.c3d);
                return;
            }
        }
        QQFMToastUtil.i(R.string.c3d);
    }

    public static void P2(final AsyncImageView asyncImageView, final FileManagerEntity fileManagerEntity) {
        K(fileManagerEntity);
        String filePath = fileManagerEntity.getFilePath();
        int i3 = fileManagerEntity.nFileType;
        if (i3 == 0) {
            if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strMiddleThumPath)) {
                filePath = fileManagerEntity.strMiddleThumPath;
            } else if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strLargeThumPath)) {
                filePath = fileManagerEntity.strLargeThumPath;
            } else if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.getFilePath())) {
                filePath = fileManagerEntity.getFilePath();
                ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).createThumbWithOrig(FileManagerEntity.this);
                    }
                });
            }
        } else if (i3 == 2) {
            filePath = FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strLargeThumPath) ? fileManagerEntity.strLargeThumPath : FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strMiddleThumPath) ? fileManagerEntity.strMiddleThumPath : null;
        } else if (i3 == 13) {
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getTDDocFileThumbUrl(fileManagerEntity.Uuid, A0().getCurrentAccountUin(), new qb1.e() { // from class: com.tencent.mobileqq.filemanager.util.aj
                @Override // qb1.e
                public final void a(Object obj) {
                    QQFileManagerUtilImpl.f2(AsyncImageView.this, obj);
                }
            });
            return;
        }
        R2(asyncImageView, filePath, fileManagerEntity.nFileType);
    }

    private static boolean Q(final String str, final int i3, final int i16, final ah.d dVar, final String str2) {
        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
            if (P(str, i3, i16, dVar, str2)) {
                return false;
            }
            return true;
        }
        ah.b.a().execute(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.12
            @Override // java.lang.Runnable
            public void run() {
                if (!q.f(str2)) {
                    QQFileManagerUtilImpl.P(str, i3, i16, dVar, str2);
                    return;
                }
                ah.d dVar2 = dVar;
                if (dVar2 != null) {
                    dVar2.onResult(str2);
                }
            }
        });
        return true;
    }

    public static long Q0(String str) {
        if (str == null) {
            QLog.e("FileManagerUtil<FileAssistant>", 1, "getFileSizes: filePath is null");
            return 0L;
        }
        File file = new File(str);
        if (!file.exists()) {
            QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + str + " is not exists");
            return 0L;
        }
        long length = file.length();
        if (0 == length) {
            QLog.w("FileManagerUtil<FileAssistant>", 1, "file " + str + " len is 0");
        }
        return length;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void Q1(TextView textView, FileManagerEntity fileManagerEntity) {
        String str;
        String a16 = ap.a(fileManagerEntity.srvTime);
        String N0 = N0(fileManagerEntity);
        String g16 = q.g(fileManagerEntity.fileSize);
        String P0 = P0(fileManagerEntity);
        String string = BaseApplication.getContext().getString(R.string.b78);
        int width = textView.getWidth();
        TextPaint paint = textView.getPaint();
        if (fileManagerEntity.nFileType == 13) {
            str = a16 + " " + N0 + " " + BaseApplication.getContext().getString(R.string.b6f);
        } else {
            str = a16 + " " + N0 + string + g16 + string + P0;
        }
        float measureText = paint.measureText(str) + 30.0f;
        float f16 = width;
        if (measureText < f16) {
            textView.setText(str);
            return;
        }
        float f17 = width * 2;
        int i3 = 0;
        if (measureText > f17) {
            int length = N0.length();
            int i16 = 1;
            while (true) {
                int i17 = length - i16;
                if (i17 > 0) {
                    String substring = N0.substring(i3, i17);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(a16);
                    sb5.append(string);
                    sb5.append(substring);
                    String str2 = f209228b;
                    sb5.append(str2);
                    sb5.append(string);
                    sb5.append(g16);
                    sb5.append(string);
                    sb5.append(P0);
                    if (paint.measureText(sb5.toString()) + 30.0f < f17) {
                        textView.setVisibility(0);
                        if (fileManagerEntity.nFileType == 13) {
                            textView.setText(a16 + " " + N0 + str2 + " " + BaseApplication.getContext().getString(R.string.b6f));
                            return;
                        }
                        textView.setText(a16 + string + substring + str2 + string + g16 + string + P0);
                        return;
                    }
                    i16++;
                    i3 = 0;
                } else {
                    if (fileManagerEntity.nFileType == 13) {
                        textView.setText(a16 + " " + N0 + "\n" + BaseApplication.getContext().getString(R.string.b6f));
                        return;
                    }
                    textView.setText(a16 + string + N0 + "\n" + g16 + string + P0);
                    return;
                }
            }
        } else {
            if (paint.measureText(a16 + string + N0) + 30.0f > f16) {
                for (int i18 = 4; i18 <= N0.length(); i18++) {
                    if (paint.measureText(a16 + string + N0.substring(0, i18)) + 30.0f > f16) {
                        String substring2 = N0.substring(0, i18 - 1);
                        String replace = N0.replace(substring2, "");
                        if (fileManagerEntity.nFileType == 13) {
                            textView.setText(a16 + " " + substring2 + "\n" + replace + string + BaseApplication.getContext().getString(R.string.b6f));
                        } else {
                            textView.setText(a16 + string + substring2 + "\n" + replace + string + g16 + string + P0);
                        }
                        textView.setVisibility(0);
                        return;
                    }
                }
                return;
            }
            if (paint.measureText(a16 + string + N0 + string + g16) + 30.0f > f16) {
                if (fileManagerEntity.nFileType == 13) {
                    textView.setText(a16 + " " + N0 + "\n" + BaseApplication.getContext().getString(R.string.b6f));
                } else {
                    textView.setText(a16 + string + N0 + "\n" + g16 + string + P0);
                }
                textView.setVisibility(0);
                return;
            }
            if (fileManagerEntity.nFileType == 13) {
                textView.setText(a16 + " " + N0 + BaseApplication.getContext().getString(R.string.b6f));
            } else {
                textView.setText(a16 + string + N0 + string + g16 + string + P0);
            }
            textView.setVisibility(0);
        }
    }

    public static void Q2(AsyncImageView asyncImageView, String str) {
        try {
            asyncImageView.setImageResource(I0(T0(str)));
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    private static void R(String str, int i3, int i16, ah.d dVar, String str2) {
        B1(str, false, i3, i16, 3, new b(dVar, str2, str));
    }

    public static int R0(FileManagerEntity fileManagerEntity) {
        boolean z16;
        int i3;
        int i16 = fileManagerEntity.status;
        boolean z17 = false;
        if (-1 != i16 && 1 != i16) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (fileManagerEntity.bSend && 8 != (i3 = fileManagerEntity.nOpType) && 5 != i3 && 1 != i3) {
            z17 = true;
        }
        if (3 == fileManagerEntity.getCloudType()) {
            if (!z17 || (z17 && z16)) {
                if (!TextUtils.isEmpty(fileManagerEntity.Uuid) && fileManagerEntity.peerType != 6000) {
                    return 1;
                }
                if (!TextUtils.isEmpty(fileManagerEntity.WeiYunFileId)) {
                    return 2;
                }
                if (!TextUtils.isEmpty(fileManagerEntity.strTroopFilePath)) {
                    return 4;
                }
            }
            return 3;
        }
        if ((2 == fileManagerEntity.getCloudType() || 1 == fileManagerEntity.getCloudType() || (4 == fileManagerEntity.getCloudType() && fileManagerEntity.nOpType != 24)) && z17 && !z16 && !TextUtils.isEmpty(fileManagerEntity.getFilePath())) {
            return 3;
        }
        return fileManagerEntity.getCloudType();
    }

    public static boolean R1() {
        return AppNetConnInfo.isMobileConn();
    }

    public static void R2(AsyncImageView asyncImageView, String str, int i3) {
        if (i3 != 0) {
            if (i3 != 2) {
                if (i3 != 5) {
                    if (i3 != 13) {
                        asyncImageView.setDefaultImage(I0(i3));
                        return;
                    } else {
                        asyncImageView.setDefaultImage(R.drawable.filelook_unknown);
                        asyncImageView.setUrlIconAsyncImage(str);
                        return;
                    }
                }
                asyncImageView.setDefaultImage(R.drawable.filelook_apk);
                if (q.f(str)) {
                    asyncImageView.setApkIconAsyncImage(str);
                    return;
                }
                return;
            }
            asyncImageView.setDefaultImage(R.drawable.filelook_video);
            if (q.f(str)) {
                try {
                    asyncImageView.setAsyncImage(str);
                    return;
                } catch (Exception e16) {
                    e16.printStackTrace();
                    return;
                }
            }
            return;
        }
        asyncImageView.setDefaultImage(R.drawable.filelook_image);
        asyncImageView.setAsyncImage(str);
    }

    public static String S(String str) {
        byte[] c16 = c1(str);
        if (c16 == null) {
            return "";
        }
        return lc1.b.a().getDefaultThumbPath() + "x-video-" + HexUtil.bytes2HexStr(c16);
    }

    public static String S0(String str) {
        int lastIndexOf;
        if (str == null || (lastIndexOf = str.lastIndexOf(".")) <= 0 || lastIndexOf >= str.length() - 1) {
            return "";
        }
        return str.substring(lastIndexOf + 1).toUpperCase();
    }

    public static boolean S1(String str, String str2) {
        return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getBoolean("qlink_new_flag_" + str + "_" + str2, true);
    }

    public static void S2(AsyncImageView asyncImageView, String str, boolean z16) {
        String j3 = q.j(str);
        if (j3 == null) {
            asyncImageView.setImageResource(R.drawable.f161608ea0);
            return;
        }
        asyncImageView.setImageResource(K0(str));
        if (z16) {
            int T0 = T0(j3);
            if (T0 != 0) {
                if (T0 == 2) {
                    asyncImageView.setDefaultImage(R.drawable.f161609ea1);
                    asyncImageView.setAsyncImage(str);
                    return;
                }
                return;
            }
            asyncImageView.setDefaultImage(R.drawable.e9y);
            asyncImageView.setAsyncImage(str);
        }
    }

    public static String T(String str, int i3) {
        if (!TextUtils.isEmpty(str) && str.getBytes().length >= i3) {
            int i16 = i3 / 2;
            int i17 = i3 / 4;
            char[] charArray = str.toCharArray();
            StringBuilder sb5 = new StringBuilder();
            for (char c16 : charArray) {
                sb5.append(c16);
                if (sb5.toString().getBytes().length > i16) {
                    break;
                }
            }
            StringBuilder sb6 = new StringBuilder();
            int length = charArray.length - 1;
            int length2 = charArray.length - 1;
            while (true) {
                if (length2 <= 0) {
                    break;
                }
                sb6.append(charArray[length2]);
                if (sb6.toString().getBytes().length > i17) {
                    length = length2;
                    break;
                }
                length2--;
            }
            return sb5.toString() + f209228b + str.substring(length);
        }
        return "";
    }

    public static synchronized int T0(String str) {
        int V0;
        synchronized (QQFileManagerUtilImpl.class) {
            V0 = V0(q.j(str).toLowerCase());
        }
        return V0;
    }

    public static boolean T1(String str) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isContainChinese(str);
    }

    public static void T2(BaseQQAppInterface baseQQAppInterface, String str, String str2, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerUtil<FileAssistant>", 2, w2());
                return;
            }
            return;
        }
        int y16 = (int) y1(fileManagerEntity.peerType);
        QLog.i("FileManagerUtil<FileAssistant>", 2, "=_= Id[" + fileManagerEntity.nSessionId + "],setTempParam[" + y16 + "]");
        fileManagerEntity.tmpSessionType = (long) y16;
        fileManagerEntity.tmpSessionSig = x1(baseQQAppInterface, fileManagerEntity.peerUin, y16);
        if (y16 != 102) {
            if (y16 == 104 || y16 == 105) {
                fileManagerEntity.tmpSessionRelatedUin = str;
                return;
            }
            return;
        }
        fileManagerEntity.tmpSessionFromPhone = str;
        fileManagerEntity.tmpSessionToPhone = str2;
    }

    public static String U(String str) {
        if (str != null && str.length() != 0) {
            boolean T1 = T1(str);
            int i3 = 3;
            if (FontSettingManager.getFontLevel() >= 20.0f) {
                if (T1) {
                    i3 = 7;
                }
            } else if (FontSettingManager.getFontLevel() >= 18.0f) {
                i3 = T1 ? 5 : 2;
            } else if (FontSettingManager.getFontLevel() >= 17.0f) {
                if (!T1) {
                    i3 = 1;
                }
            } else {
                i3 = 0;
            }
            int i16 = 16 - i3;
            if (str.length() > i16) {
                int length = str.length();
                int i17 = i16 / 2;
                return str.substring(0, i17) + MiniBoxNoticeInfo.APPNAME_SUFFIX + str.substring(length - i17);
            }
            return str;
        }
        return "";
    }

    public static String U0(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 != 5) {
                            if (i3 != 6 && i3 != 7 && i3 != 9) {
                                return m1(R.string.mit);
                            }
                        } else {
                            return m1(R.string.mjg);
                        }
                    }
                    return m1(R.string.miw);
                }
                return m1(R.string.mj9);
            }
            return m1(R.string.min);
        }
        return m1(R.string.f171981mj3);
    }

    public static boolean U1() {
        return false;
    }

    public static void U2(AsyncImageView asyncImageView, FileManagerEntity fileManagerEntity) {
        K(fileManagerEntity);
        if (fileManagerEntity.nFileType == 0) {
            String str = fileManagerEntity.strLargeThumPath;
            if (TextUtils.isEmpty(str)) {
                str = D1(fileManagerEntity);
            }
            if (FileUtils.fileExistsAndNotEmpty(str)) {
                fileManagerEntity.strLargeThumPath = str;
                asyncImageView.setDefaultImage(R.drawable.e9y);
                asyncImageView.setAsyncImage(str);
                return;
            }
        }
        Q2(asyncImageView, fileManagerEntity.fileName);
    }

    public static String V(TextView textView, int i3, String str, String str2) {
        int length;
        if (b1(textView, str) <= i3) {
            return str2;
        }
        String str3 = str2;
        for (int i16 = 0; i16 < str2.length() && (length = str3.length() - 1) >= 1; i16++) {
            str3 = str3.substring(0, length);
            String str4 = str3 + f209228b;
            if (b1(textView, str.replace(str2, str4)) <= i3) {
                return str4;
            }
        }
        return f209228b;
    }

    public static synchronized int V0(String str) {
        synchronized (QQFileManagerUtilImpl.class) {
            if (str != null) {
                if (str.length() != 0) {
                    if (f209229c == null) {
                        HashMap<String, Integer> hashMap = new HashMap<>();
                        f209229c = hashMap;
                        hashMap.put(DefaultHlsExtractorFactory.MP3_FILE_EXTENSION, 1);
                        f209229c.put(".3gpp", 1);
                        f209229c.put(".flac", 1);
                        f209229c.put(".ogg", 1);
                        f209229c.put(".wav", 1);
                        f209229c.put(".m4a", 1);
                        f209229c.remove(".flv");
                        f209229c.remove(".m");
                        f209229c.remove(".webp");
                        f209229c.remove(".vcf");
                        f209229c.put(".heic", 0);
                        f209229c.put(".bmp", 0);
                        f209229c.put(".jpg", 0);
                        f209229c.put(".jpeg", 0);
                        f209229c.put(".png", 0);
                        f209229c.put(QzoneEmotionUtils.SIGN_ICON_URL_END, 0);
                        f209229c.put(".heic", 0);
                        f209229c.put(".heif", 0);
                        f209229c.put(".webp", 0);
                        f209229c.put(".psd", 12);
                        f209229c.put(".mov", 2);
                        f209229c.put(".mp4", 2);
                        f209229c.put(".3gp", 2);
                        f209229c.put(".avi", 2);
                        f209229c.put(".rmvb", 2);
                        f209229c.put(".mpg", 2);
                        f209229c.put(".rm", 2);
                        f209229c.put(".asf", 2);
                        f209229c.put(".mpeg", 2);
                        f209229c.put(".mkv", 2);
                        f209229c.put(".wmv", 2);
                        f209229c.put(".flv", 2);
                        f209229c.put(".f4v", 2);
                        f209229c.put(".webm", 2);
                        f209229c.put(".mod", 2);
                        f209229c.put(".mpe", 2);
                        f209229c.put(".m4r", 2);
                        f209229c.put(".m4u", 2);
                        f209229c.put(".m4v", 2);
                        f209229c.put(".vob", 2);
                        f209229c.put(".doc", 3);
                        f209229c.put(".docx", 3);
                        f209229c.put(".wps", 3);
                        f209229c.put(".pages", 3);
                        f209229c.put(".zip", 4);
                        f209229c.put(".rar", 4);
                        f209229c.put(".7z", 4);
                        f209229c.put(".tar", 4);
                        f209229c.put(".iso", 4);
                        f209229c.put(".gz", 4);
                        f209229c.put(".apk", 5);
                        f209229c.put(".apk.rename", 5);
                        f209229c.put(".xls", 6);
                        f209229c.put(".xlsx", 6);
                        f209229c.put(".csv", 6);
                        f209229c.put(".numbers", 6);
                        f209229c.put(".et", 6);
                        f209229c.put(".ppt", 7);
                        f209229c.put(".pptx", 7);
                        f209229c.put(".pps", 7);
                        f209229c.put(".dps", 7);
                        f209229c.put(".keynotes", 7);
                        f209229c.put(".htm", 8);
                        f209229c.put(".html", 8);
                        f209229c.put(".php", 8);
                        f209229c.put(".pdf", 9);
                        f209229c.put(".txt", 10);
                        f209229c.put(".epub", 10);
                        f209229c.put(".rtf", 10);
                        f209229c.put(".c", 10);
                        f209229c.put(".conf", 10);
                        f209229c.put(".cpp", 10);
                        f209229c.put(".h", 10);
                        f209229c.put(".java", 10);
                        f209229c.put(".log", 10);
                        f209229c.put(".prop", 10);
                        f209229c.put(".rc", 10);
                        f209229c.put(".sh", 10);
                        f209229c.put(".csv", 10);
                        f209229c.put(".xml", 10);
                        f209229c.put(".ai", 14);
                        f209229c.put(".font", 15);
                        f209229c.put(".ipa", 16);
                        f209229c.put(".keynote", 17);
                        f209229c.put(".note", 18);
                        f209229c.put(".numbers", 19);
                        f209229c.put(".pages", 20);
                        f209229c.put(".sketch", 21);
                    }
                    if (f209229c.containsKey(str.toLowerCase())) {
                        return f209229c.get(str.toLowerCase()).intValue();
                    }
                    return 11;
                }
            }
            return -1;
        }
    }

    public static boolean V1(Context context) {
        return ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).isImportLocaFilesForH5(context);
    }

    public static void V2(boolean z16, Context context, FMDialogUtil.c cVar) {
        W2(z16, context, cVar, -1);
    }

    private static void W(int i3, String str, BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3)) {
            if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips()) {
                ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(baseQQAppInterface);
            } else {
                h0(i3, str, fileManagerEntity);
            }
        }
    }

    public static int W0(ChatMessage chatMessage) {
        if (chatMessage.isMultiMsg) {
            String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
            if (!TextUtils.isEmpty(extInfoFromExtStr)) {
                int T0 = T0(extInfoFromExtStr);
                if (T0 == 2 || T0 == 0) {
                    return T0;
                }
                return -1;
            }
            return -1;
        }
        return -1;
    }

    public static boolean W1(String str) {
        return am.f(str);
    }

    public static void W2(boolean z16, Context context, FMDialogUtil.c cVar, int i3) {
        if (!NetworkUtil.isNetSupportHw(BaseApplication.getContext())) {
            c0(R.string.bqf);
            return;
        }
        if (!R1()) {
            cVar.b();
            return;
        }
        boolean isShowByCUKingCardHelper = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isShowByCUKingCardHelper(context, z16, cVar);
        if (isShowByCUKingCardHelper) {
            isShowByCUKingCardHelper = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isShowByFreeWifiHelper(context, z16, cVar);
        }
        if (isShowByCUKingCardHelper) {
            int i16 = R.string.f170958ba0;
            if (i3 == 0 && KingCardProcessor.get().aio.enable && !((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isKingCard()) {
                if (!z16) {
                    i16 = R.string.b_x;
                }
                FMDialogUtil.c(context, context.getString(R.string.b_v), KingCardProcessor.get().aio.appendKingcardString(context, context.getString(i16)), cVar);
                return;
            }
            if (!z16) {
                i16 = R.string.b_x;
            }
            FMDialogUtil.a(context, R.string.b_v, i16, cVar);
        }
    }

    private static void X(int i3, String str, FileManagerEntity fileManagerEntity) {
        if (!TextUtils.isEmpty(str)) {
            a0(str);
        } else if (!b0(i3, fileManagerEntity.fileName)) {
            b0(13, fileManagerEntity.fileName);
        }
    }

    public static byte[] X0(String str) {
        return E0(str, KeyPropertiesCompact.DIGEST_MD5);
    }

    public static boolean X1(BaseQQAppInterface baseQQAppInterface, ChatMessage chatMessage) {
        if (chatMessage == null || !chatMessage.isMultiMsg || TextUtils.isEmpty(chatMessage.senderuin) || !chatMessage.senderuin.equals(baseQQAppInterface.getCurrentAccountUin())) {
            return false;
        }
        return true;
    }

    public static void X2(Activity activity, TextView textView) {
        if (textView != null && f209233g == null) {
            Drawable drawable = activity.getResources().getDrawable(R.drawable.common_loading2);
            f209233g = drawable;
            textView.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            ((Animatable) f209233g).start();
        }
    }

    private static void Y(String str, FileManagerEntity fileManagerEntity) {
        if (!TextUtils.isEmpty(str)) {
            a0(str);
        } else {
            b0(13, fileManagerEntity.fileName);
        }
    }

    public static String Y0(String str) {
        if (f209230d == null) {
            HashMap<String, String> hashMap = new HashMap<>();
            f209230d = hashMap;
            hashMap.put("OnlinePreViewRotateScreenFunctionalSwitch", "1");
            f209230d.put("OnlinePreViewLocalPreviewFunctionalSwitch", "0");
            f209230d.put("OnlinePreViewAutoPreviewFunctionSwitch", "1");
            f209230d.put("OnlinePreViewAutoPreviewWiFiMaxSize", "1000");
            f209230d.put("OnlinePreViewAutoPreview3GMaxSize", "0");
            f209230d.put("OnlinePreViewAutoPreviewWiFiGroupMaxSize", "1000");
            f209230d.put("OnlinePreViewAutoPreview3GGroupMaxSize", "0");
            f209230d.put("OnlinePreViewdocFileMaxSize", "10");
            f209230d.put("OnlinePreViewdocFileType", "1");
            f209230d.put("OnlinePreViewdocInterfacePage", "qq_document_previewer_v2.html");
            f209230d.put("OnlinePreViewdocPreviewMode", "0");
            f209230d.put("OnlinePreViewdocxFileMaxSize", "10");
            f209230d.put("OnlinePreViewdocxFileType", "2");
            f209230d.put("OnlinePreViewdocxInterfacePage", "qq_document_previewer_v2.html");
            f209230d.put("OnlinePreViewdocxPreviewMode", "0");
            f209230d.put("OnlinePreViewrtfFileMaxSize", "10");
            f209230d.put("OnlinePreViewrtfFileType", "7");
            f209230d.put("OnlinePreViewrtfInterfacePage", "qq_document_previewer_v2.html");
            f209230d.put("OnlinePreViewrtfPreviewMode", "0");
            f209230d.put("OnlinePreViewpptFileMaxSize", "10");
            f209230d.put("OnlinePreViewpptFileType", "5");
            f209230d.put("OnlinePreViewpptInterfacePage", "qq_ppt_previewer_v2.html");
            f209230d.put("OnlinePreViewpptPreviewMode", "4");
            f209230d.put("OnlinePreViewpptxFileMaxSize", "10");
            f209230d.put("OnlinePreViewpptxFileType", "6");
            f209230d.put("OnlinePreViewpptxInterfacePage", "qq_ppt_previewer_v2.html");
            f209230d.put("OnlinePreViewpptxPreviewMode", "5");
            f209230d.put("OnlinePreViewpdfFileMaxSize", "10");
            f209230d.put("OnlinePreViewpdfFileType", "8");
            f209230d.put("OnlinePreViewpdfInterfacePage", "qq_pdf_previewer_v2.html");
            f209230d.put("OnlinePreViewpdfPreviewMode", "3");
            f209230d.put("OnlinePreViewzipFileMaxSize", "100");
            f209230d.put("OnlinePreViewzipFileType", "13");
            f209230d.put("OnlinePreViewzipInterfacePage", "qq_compress_previewer_v2.html");
            f209230d.put("OnlinePreViewzipPreviewMode", "1");
            f209230d.put("OnlinePreViewrarFileMaxSize", "100");
            f209230d.put("OnlinePreViewrarFileType", "14");
            f209230d.put("OnlinePreViewrarInterfacePage", "qq_compress_previewer_v2.html");
            f209230d.put("OnlinePreViewrarPreviewMode", "1");
            f209230d.put("OnlinePreView7zFileMaxSize", "100");
            f209230d.put("OnlinePreView7zFileType", "15");
            f209230d.put("OnlinePreView7zInterfacePage", "qq_compress_previewer_v2.html");
            f209230d.put("OnlinePreView7zPreviewMode", "1");
            f209230d.put("OnlinePreViewtxtFileMaxSize", "10");
            f209230d.put("OnlinePreViewtxtFileType", "16");
            f209230d.put("OnlinePreViewtxtInterfacePage", "qq_txt_previewer_v2.html");
            f209230d.put("OnlinePreViewtxtPreviewMode", "2");
            f209230d.put("OfflineConfigFlowSize", "1024");
            f209230d.put("OfflineConfigFlowTime", "30");
            f209230d.put("OfflineConfigFtnThumbMaxSize", "32768");
        }
        String str2 = f209230d.get(str);
        if (str2 == null && QLog.isColorLevel()) {
            QLog.e("FileManagerUtil<FileAssistant>", 2, "key[" + str + "],value null!");
        }
        return str2;
    }

    public static boolean Y1() {
        return com.tencent.mobileqq.filemanager.data.d.r();
    }

    public static void Y2(TextView textView) {
        Object obj;
        if (textView != null && (obj = f209233g) != null) {
            ((Animatable) obj).stop();
            f209233g = null;
            textView.setCompoundDrawables(null, null, null, null);
        }
    }

    private static void Z(int i3, String str, BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity.nOpType == 4) {
            if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(i3)) {
                if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).needShowGrayTips()) {
                    ((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).showGrayTips(baseQQAppInterface);
                    return;
                } else {
                    e0(i3, str, fileManagerEntity);
                    return;
                }
            }
            return;
        }
        e0(i3, str, fileManagerEntity);
    }

    public static String Z0(FileManagerEntity fileManagerEntity) {
        File file;
        String str;
        if (!ZhuoXusManager.instance().isSendFileQRCodeOpen()) {
            fileManagerEntity.strQRUrl = "";
            return "";
        }
        if (!TextUtils.isEmpty(fileManagerEntity.strQRUrl)) {
            if (QLog.isDevelopLevel()) {
                QLog.i("IMG_FILE_QR", 1, "getImageUrl:" + fileManagerEntity.strQRUrl);
            }
            return fileManagerEntity.strQRUrl;
        }
        if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strMiddleThumPath)) {
            file = new File(fileManagerEntity.strMiddleThumPath);
            str = "mid";
        } else if (FileUtils.fileExistsAndNotEmpty(fileManagerEntity.strLargeThumPath)) {
            file = new File(fileManagerEntity.strLargeThumPath);
            str = "larg";
        } else {
            return null;
        }
        Pair<StringBuilder, StringBuilder> qRCodeResult = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getQRCodeResult(BaseApplication.getContext(), file);
        if (qRCodeResult == null) {
            return "";
        }
        fileManagerEntity.strQRUrl = ((StringBuilder) qRCodeResult.first).toString();
        if (QLog.isDevelopLevel()) {
            QLog.i("IMG_FILE_QR", 1, "getImageUrl success:" + fileManagerEntity.strQRUrl + " use:" + str);
        }
        return fileManagerEntity.strQRUrl;
    }

    public static boolean Z1(long j3, long j16, TimeZone timeZone) {
        long j17 = j3 - j16;
        if (j17 < 86400000 && j17 > -86400000 && h2(j3, timeZone) == h2(j16, timeZone)) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x0139, code lost:
    
        if (r10 == null) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00d5, code lost:
    
        if (r10 == null) goto L59;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 10, insn: 0x0169: MOVE (r4 I:??[OBJECT, ARRAY]) = (r10 I:??[OBJECT, ARRAY]) (LINE:362), block:B:55:0x0169 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0091 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x011a A[Catch: all -> 0x0168, TRY_LEAVE, TryCatch #3 {all -> 0x0168, blocks: (B:26:0x00c8, B:40:0x00d3, B:48:0x00e4, B:50:0x00ec, B:42:0x0112, B:44:0x011a), top: B:22:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ec A[Catch: all -> 0x0168, TryCatch #3 {all -> 0x0168, blocks: (B:26:0x00c8, B:40:0x00d3, B:48:0x00e4, B:50:0x00ec, B:42:0x0112, B:44:0x011a), top: B:22:0x00bc }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x016c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13, types: [int] */
    /* JADX WARN: Type inference failed for: r8v14, types: [boolean] */
    /* JADX WARN: Type inference failed for: r8v15, types: [java.lang.StringBuilder] */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v20 */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8, types: [int] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x010d -> B:27:0x00d5). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ah.g Z2(String str) {
        Bitmap bitmap;
        String parent;
        BufferedOutputStream bufferedOutputStream;
        IOException e16;
        FileNotFoundException e17;
        OutputStream outputStream;
        boolean isColorLevel;
        String str2 = "sendVideo thumbFilePath=";
        String S = S(str);
        ah.g gVar = new ah.g();
        gVar.f209330a = 0;
        if (q.f(S)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).decodeFileWithBufferedStream(S, options);
            gVar.f209332c = options.outWidth;
            gVar.f209333d = options.outHeight;
            gVar.f209331b = S;
            return gVar;
        }
        OutputStream outputStream2 = null;
        try {
            bitmap = ThumbnailUtils.createVideoThumbnail(str, 1);
            if (bitmap == null) {
                try {
                    gVar.f209330a = -1;
                    return gVar;
                } catch (Exception e18) {
                    e = e18;
                    e.printStackTrace();
                    String str3 = lc1.b.a().getDefaultThumbPath() + System.currentTimeMillis() + ".jpg";
                    FileUtils.createFileIfNotExits(lc1.b.a().getDefaultThumbPath() + ".nomedia");
                    VFSFile vFSFile = new VFSFile(str3);
                    parent = vFSFile.getParent();
                    if (parent != null) {
                    }
                }
            }
        } catch (Exception e19) {
            e = e19;
            bitmap = null;
        }
        String str32 = lc1.b.a().getDefaultThumbPath() + System.currentTimeMillis() + ".jpg";
        FileUtils.createFileIfNotExits(lc1.b.a().getDefaultThumbPath() + ".nomedia");
        VFSFile vFSFile2 = new VFSFile(str32);
        parent = vFSFile2.getParent();
        if (parent != null) {
            return gVar;
        }
        VFSFile vFSFile3 = new VFSFile(parent);
        if (!vFSFile3.exists() || !vFSFile3.isDirectory()) {
            vFSFile3.mkdirs();
        }
        if (!vFSFile2.exists() || !vFSFile2.isFile()) {
            try {
                vFSFile2.createNewFile();
            } catch (IOException e26) {
                e26.printStackTrace();
            }
        }
        ?? r85 = -2;
        r85 = -2;
        r85 = -2;
        r85 = -2;
        r85 = -2;
        r85 = -2;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new VFSFileOutputStream(vFSFile2));
            } catch (FileNotFoundException e27) {
                bufferedOutputStream = null;
                e17 = e27;
                gVar.f209330a = r85;
                r85 = QLog.isColorLevel();
                if (r85 != 0) {
                }
            } catch (IOException e28) {
                bufferedOutputStream = null;
                e16 = e28;
                gVar.f209330a = r85;
                isColorLevel = QLog.isColorLevel();
                r85 = isColorLevel;
                if (isColorLevel) {
                }
                if (bufferedOutputStream != null) {
                }
                if (vFSFile2.exists()) {
                }
                return gVar;
            } catch (Throwable th5) {
                th = th5;
                if (outputStream2 != null) {
                }
                throw th;
            }
            try {
                if (bitmap != null) {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                    bufferedOutputStream.flush();
                } else {
                    gVar.f209330a = -1;
                }
            } catch (FileNotFoundException e29) {
                e17 = e29;
                gVar.f209330a = r85;
                r85 = QLog.isColorLevel();
                if (r85 != 0) {
                    r85 = new StringBuilder();
                    r85.append(str2);
                    r85.append(str32);
                    r85.append("FileNotFoundException error=");
                    r85.append(e17.getMessage());
                    str2 = r85.toString();
                    QLog.e("FileManagerUtil<FileAssistant>", 2, str2);
                }
            } catch (IOException e36) {
                e16 = e36;
                gVar.f209330a = r85;
                isColorLevel = QLog.isColorLevel();
                r85 = isColorLevel;
                if (isColorLevel) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(str2);
                    sb5.append(str32);
                    sb5.append(" IOException error=");
                    sb5.append(e16.getMessage());
                    str2 = sb5.toString();
                    QLog.e("FileManagerUtil<FileAssistant>", 2, str2);
                    r85 = sb5;
                }
                if (bufferedOutputStream != null) {
                    bufferedOutputStream.close();
                }
                if (vFSFile2.exists()) {
                }
                return gVar;
            }
            try {
                bufferedOutputStream.close();
            } catch (IOException unused) {
                if (vFSFile2.exists()) {
                    FileUtils.rename(str32, S);
                    q.d(str32);
                    gVar.f209331b = S;
                    if (bitmap != null) {
                        gVar.f209332c = bitmap.getWidth();
                        gVar.f209333d = bitmap.getHeight();
                    }
                } else {
                    gVar.f209330a = -1;
                    if (QLog.isColorLevel()) {
                        QLog.e("FileManagerUtil<FileAssistant>", 2, "sendVideo error  thumbFile.exists = false");
                    }
                }
                return gVar;
            }
        } catch (Throwable th6) {
            th = th6;
            outputStream2 = outputStream;
            if (outputStream2 != null) {
                try {
                    outputStream2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    public static void a0(String str) {
        QQFMToastUtil.j(str);
    }

    private static int[] a1(String str) {
        if (FileUtils.fileExistsAndNotEmpty(str)) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).decodeFileWithBufferedStream(str, options);
            int exifRotation = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExifRotation(str);
            if (exifRotation != 90 && exifRotation != 270) {
                return new int[]{options.outWidth, options.outHeight};
            }
            return new int[]{options.outHeight, options.outWidth};
        }
        return new int[]{0, 0};
    }

    public static boolean a2() {
        ArrayList<FavFileInfo> favFiles = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getFavFiles();
        if (favFiles != null && favFiles.size() > 0) {
            Iterator<FavFileInfo> it = favFiles.iterator();
            while (it.hasNext()) {
                if (T0(it.next().f207675h) == 0) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Bitmap a3(Matrix matrix, Bitmap bitmap, int i3, int i16) {
        Matrix matrix2;
        Bitmap bitmap2;
        Bitmap createBitmap;
        Matrix matrix3 = matrix;
        int width = bitmap.getWidth() - i3;
        int height = bitmap.getHeight() - i16;
        if (width >= 0 && height >= 0) {
            float width2 = bitmap.getWidth();
            float height2 = bitmap.getHeight();
            float f16 = i3;
            float f17 = i16;
            try {
                if (width2 / height2 > f16 / f17) {
                    float f18 = f17 / height2;
                    if ((f18 < 0.9f || f18 > 1.0f) && matrix3 != null) {
                        matrix3.setScale(f18, f18);
                    } else {
                        matrix3 = null;
                    }
                } else {
                    float f19 = f16 / width2;
                    if (matrix3 != null && (f19 < 0.9f || f19 > 1.0f)) {
                        matrix3.setScale(f19, f19);
                    } else {
                        matrix2 = null;
                        if (matrix2 == null) {
                            try {
                                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
                            } catch (OutOfMemoryError unused) {
                                QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
                                return null;
                            }
                        } else {
                            bitmap2 = bitmap;
                        }
                        if (bitmap2 != bitmap) {
                            bitmap.recycle();
                        }
                        createBitmap = Bitmap.createBitmap(bitmap2, Math.max(0, bitmap2.getWidth() - i3) / 2, Math.max(0, bitmap2.getHeight() - i16) / 2, i3, i16);
                        if (createBitmap != bitmap2 && bitmap2 != bitmap) {
                            bitmap2.recycle();
                        }
                        return createBitmap;
                    }
                }
                createBitmap = Bitmap.createBitmap(bitmap2, Math.max(0, bitmap2.getWidth() - i3) / 2, Math.max(0, bitmap2.getHeight() - i16) / 2, i3, i16);
                if (createBitmap != bitmap2) {
                    bitmap2.recycle();
                }
                return createBitmap;
            } catch (OutOfMemoryError unused2) {
                QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
                return null;
            }
            matrix2 = matrix3;
            if (matrix2 == null) {
            }
            if (bitmap2 != bitmap) {
            }
        } else {
            try {
                Bitmap createBitmap2 = Bitmap.createBitmap(i3, i16, Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap2);
                int max = Math.max(0, width / 2);
                int max2 = Math.max(0, height / 2);
                Rect rect = new Rect(max, max2, Math.min(i3, bitmap.getWidth()) + max, Math.min(i16, bitmap.getHeight()) + max2);
                int width3 = (i3 - rect.width()) / 2;
                int height3 = (i16 - rect.height()) / 2;
                canvas.drawBitmap(bitmap, rect, new Rect(width3, height3, i3 - width3, i16 - height3), (Paint) null);
                return createBitmap2;
            } catch (OutOfMemoryError unused3) {
                QLog.e("FileManagerUtil<FileAssistant>", 1, "transfrom bitmap fail, Exception OutOfMemoryError");
                return null;
            }
        }
    }

    public static boolean b0(int i3, String str) {
        switch (i3) {
            case 1:
                d0(U(str) + w1(R.string.bet));
            case 0:
                return true;
            case 2:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 3:
                d0(U(str) + w1(R.string.bet));
                return true;
            case 4:
                d0(U(str) + w1(R.string.bet));
                return true;
            case 5:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 6:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 7:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 8:
            case 14:
            default:
                if (QLog.isColorLevel()) {
                    QLog.e("FileManagerUtil<FileAssistant>", 1, "unknow errCode:" + i3);
                    return false;
                }
                return false;
            case 9:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 10:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 11:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 12:
                if (QLog.isDevelopLevel()) {
                    w2();
                }
                c0(R.string.bfh);
                return true;
            case 13:
                d0(U(str) + w1(R.string.bfk));
                return true;
            case 15:
                c0(R.string.cmk);
                return true;
            case 16:
                c0(R.string.bek);
                return true;
            case 17:
                QLog.e("FileManagerUtil<FileAssistant>", 1, "c2c video download cancel:" + i3);
                return true;
        }
    }

    private static int b1(TextView textView, String str) {
        if (textView.getLayout() == null) {
            return 0;
        }
        return StaticLayout.Builder.obtain(str, 0, str.length(), textView.getPaint(), textView.getWidth()).setAlignment(textView.getLayout().getAlignment()).setLineSpacing(textView.getLineSpacingExtra(), textView.getLineSpacingMultiplier()).build().getLineCount();
    }

    @RequiresApi(api = 25)
    public static boolean b2(String str, ShortcutManager shortcutManager) {
        List pinnedShortcuts;
        CharSequence shortLabel;
        if (shortcutManager != null && Build.VERSION.SDK_INT >= 26) {
            pinnedShortcuts = shortcutManager.getPinnedShortcuts();
            Iterator it = pinnedShortcuts.iterator();
            while (it.hasNext()) {
                shortLabel = ((ShortcutInfo) it.next()).getShortLabel();
                if (str.equals(shortLabel)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public static void b3(final BaseQQAppInterface baseQQAppInterface, final String str, final String str2, final int i3) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.16
            /* JADX WARN: Removed duplicated region for block: B:56:0x0189  */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() {
                String str3;
                String str4;
                int i16;
                String str5;
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                try {
                    LockMethodProxy.sleep(500L);
                } catch (InterruptedException e16) {
                    e16.printStackTrace();
                }
                SharedPreferences sharedPreferences = baseQQAppInterface.getApplication().getSharedPreferences(baseQQAppInterface.getCurrentAccountUin() + "BatProcessTips", 0);
                String str6 = str2 + "_" + i3 + "_LastShowTime";
                long j3 = sharedPreferences.getLong(str6, 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j3 < 86400000) {
                    if (QLog.isColorLevel()) {
                        QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + j3 + "],today has notify user!return!");
                        return;
                    }
                    return;
                }
                List<MessageRecord> msgList = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMsgList(baseQQAppInterface, str2, i3);
                if (msgList != null && msgList.size() != 0) {
                    String currentAccountUin = baseQQAppInterface.getCurrentAccountUin();
                    int size = msgList.size() - 1;
                    int i17 = 1;
                    while (size >= 0) {
                        MessageRecord messageRecord = msgList.get(size);
                        int i18 = size;
                        if (messageRecord.msgtype == -2005 && !messageRecord.isSend() && !messageRecord.senderuin.equalsIgnoreCase(currentAccountUin)) {
                            if (QLog.isDevelopLevel()) {
                                StringBuilder sb5 = new StringBuilder();
                                str3 = currentAccountUin;
                                sb5.append("updateBatProcessTips count[");
                                sb5.append(i17);
                                sb5.append("]");
                                str4 = "]";
                                i16 = 4;
                                QLog.d("FileManagerUtil<FileAssistant>", 4, sb5.toString());
                            } else {
                                str3 = currentAccountUin;
                                str4 = "]";
                                i16 = 4;
                            }
                            if (i17 >= i16) {
                                int i19 = QQFileManagerUtilImpl.L0(baseQQAppInterface, (MessageForFile) msgList.get(msgList.size() - 1)).nFileType;
                                if (i19 != 0) {
                                    if (i19 != 9) {
                                        if (i19 != 2) {
                                            if (i19 != 3 && i19 != 6 && i19 != 7) {
                                                str5 = "3";
                                                HashMap hashMap = new HashMap();
                                                hashMap.put("bat_process_tips_last_file_type", str5);
                                                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertAIOGrayTips(baseQQAppInterface, str2, str, i3, MessageRecord.MSG_TYPE_BAT_PROCESS_FILE, hashMap, BaseApplication.getContext().getString(R.string.b_k), -1L, -1L, -1L);
                                                sharedPreferences.edit().putLong(str6, currentTimeMillis);
                                                if (QLog.isColorLevel()) {
                                                    QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + j3 + "],[" + QQFileManagerUtilImpl.m0(str2) + "]add new grayTips!");
                                                }
                                                FileManagerReporter.addData("0X800506B");
                                                return;
                                            }
                                        }
                                    }
                                    str5 = "1";
                                    HashMap hashMap2 = new HashMap();
                                    hashMap2.put("bat_process_tips_last_file_type", str5);
                                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertAIOGrayTips(baseQQAppInterface, str2, str, i3, MessageRecord.MSG_TYPE_BAT_PROCESS_FILE, hashMap2, BaseApplication.getContext().getString(R.string.b_k), -1L, -1L, -1L);
                                    sharedPreferences.edit().putLong(str6, currentTimeMillis);
                                    if (QLog.isColorLevel()) {
                                    }
                                    FileManagerReporter.addData("0X800506B");
                                    return;
                                }
                                str5 = "0";
                                HashMap hashMap22 = new HashMap();
                                hashMap22.put("bat_process_tips_last_file_type", str5);
                                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertAIOGrayTips(baseQQAppInterface, str2, str, i3, MessageRecord.MSG_TYPE_BAT_PROCESS_FILE, hashMap22, BaseApplication.getContext().getString(R.string.b_k), -1L, -1L, -1L);
                                sharedPreferences.edit().putLong(str6, currentTimeMillis);
                                if (QLog.isColorLevel()) {
                                }
                                FileManagerReporter.addData("0X800506B");
                                return;
                            }
                            long j16 = messageRecord.time * 1000;
                            if (QLog.isColorLevel()) {
                                QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + j3 + "],time[" + j16 + str4);
                            }
                            if (j16 > j3) {
                                i17++;
                            }
                            size = i18 - 1;
                            currentAccountUin = str3;
                        } else {
                            return;
                        }
                    }
                    return;
                }
                if (QLog.isColorLevel()) {
                    QLog.i("updateBatProcessTips<FileAssistant>", 4, "lastShowTime[" + j3 + "],msgRecd null,return");
                }
            }
        }, 8, null, true);
    }

    public static void c0(int i3) {
        QQFMToastUtil.i(i3);
    }

    public static byte[] c1(String str) {
        return d1(str, Q0(str));
    }

    public static boolean c2(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null || fileManagerEntity.isZipInnerFile) {
            return false;
        }
        int R0 = R0(fileManagerEntity);
        if (R0 != 1 && R0 != 2) {
            if (R0 != 3) {
                if (R0 != 4) {
                    if (R0 != 6 || fileManagerEntity.nFileType != 0) {
                        return false;
                    }
                    return true;
                }
            } else {
                if (fileManagerEntity.nFileType != 0) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    public static String c3(BaseQQAppInterface baseQQAppInterface, Message message) {
        return d3(baseQQAppInterface, message);
    }

    private static void d0(String str) {
        QQFMToastUtil.j(str);
    }

    /* JADX WARN: Not initialized variable reg: 4, insn: 0x007a: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:123), block:B:29:0x007a */
    /* JADX WARN: Removed duplicated region for block: B:21:0x005a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] d1(String str, long j3) {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2;
        FileInputStream fileInputStream3 = null;
        try {
            try {
                fileInputStream = new FileInputStream(str);
                if (j3 >= 10002432) {
                    j3 = 10002432;
                }
            } catch (IOException e16) {
                e = e16;
                fileInputStream = null;
                QLog.e("FileManagerUtil<FileAssistant>", 1, "getMd5 exception with filePath = " + str, e);
                if (fileInputStream != null) {
                }
                return null;
            } catch (NullPointerException e17) {
                e = e17;
                fileInputStream = null;
                QLog.e("FileManagerUtil<FileAssistant>", 1, "getMd5 exception with filePath = " + str, e);
                if (fileInputStream != null) {
                }
                return null;
            } catch (Throwable th5) {
                th = th5;
                if (fileInputStream3 != null) {
                }
                throw th;
            }
            try {
                byte[] partfileMd5 = MD5.getPartfileMd5(str, j3);
                try {
                    fileInputStream.close();
                } catch (IOException e18) {
                    e18.printStackTrace();
                    QLog.e("FileManagerUtil<FileAssistant>", 1, "getMd5 close exception:" + e18.toString());
                }
                return partfileMd5;
            } catch (IOException e19) {
                e = e19;
                QLog.e("FileManagerUtil<FileAssistant>", 1, "getMd5 exception with filePath = " + str, e);
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e26) {
                        e26.printStackTrace();
                        QLog.e("FileManagerUtil<FileAssistant>", 1, "getMd5 close exception:" + e26.toString());
                    }
                }
                return null;
            } catch (NullPointerException e27) {
                e = e27;
                QLog.e("FileManagerUtil<FileAssistant>", 1, "getMd5 exception with filePath = " + str, e);
                if (fileInputStream != null) {
                }
                return null;
            }
        } catch (Throwable th6) {
            th = th6;
            fileInputStream3 = fileInputStream2;
            if (fileInputStream3 != null) {
                try {
                    fileInputStream3.close();
                } catch (IOException e28) {
                    e28.printStackTrace();
                    QLog.e("FileManagerUtil<FileAssistant>", 1, "getMd5 close exception:" + e28.toString());
                }
            }
            throw th;
        }
    }

    public static boolean d2(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null || fileManagerEntity.TroopUin == 0 || TextUtils.isEmpty(fileManagerEntity.strTroopFileID) || TextUtils.isEmpty(fileManagerEntity.strTroopFilePath)) {
            return false;
        }
        return true;
    }

    public static String d3(BaseQQAppInterface baseQQAppInterface, MessageRecord messageRecord) {
        FileManagerEntity queryFileEntityByUniseq = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileEntityByUniseq(baseQQAppInterface, messageRecord.uniseq, messageRecord.frienduin, messageRecord.istroop);
        if (queryFileEntityByUniseq == null) {
            return null;
        }
        if (queryFileEntityByUniseq.nFileType == -1) {
            queryFileEntityByUniseq.nFileType = T0(queryFileEntityByUniseq.getFilePath());
        }
        String str = "[" + U0(queryFileEntityByUniseq.nFileType) + "]";
        if (k.g(messageRecord)) {
            if ("gif".equalsIgnoreCase(q.j(queryFileEntityByUniseq.getFilePath()))) {
                return m1(R.string.iml);
            }
            return str;
        }
        return str + queryFileEntityByUniseq.fileName;
    }

    private static void e0(int i3, String str, FileManagerEntity fileManagerEntity) {
        if (b0(i3, fileManagerEntity.fileName)) {
            return;
        }
        if (str != null && str.length() > 0) {
            a0(str);
            return;
        }
        a0(U(fileManagerEntity.fileName) + w1(R.string.f170977be2));
    }

    public static int[] e1(String str) {
        int i3;
        int i16;
        if (!FileUtils.fileExistsAndNotEmpty(str)) {
            return new int[]{0, 0};
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        SafeBitmapFactory.decodeFile(str, options);
        int exifRotation = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExifRotation(str);
        if (exifRotation != 90 && exifRotation != 270) {
            i16 = options.outWidth;
            i3 = options.outHeight;
        } else {
            int i17 = options.outWidth;
            int i18 = options.outHeight;
            i3 = i17;
            i16 = i18;
        }
        return new int[]{i16, i3};
    }

    public static LinkedHashMap e2(String str) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (str == null) {
            if (QLog.isColorLevel()) {
                QLog.e("FileManagerUtil<FileAssistant>", 1, "jsonToMap but jsonString is null!");
            }
            return linkedHashMap;
        }
        String replace = str.replace("\"", "");
        if (replace.startsWith("{")) {
            replace = replace.substring(1);
        }
        if (replace.endsWith("}")) {
            replace = replace.substring(0, replace.length() - 1);
        }
        for (String str2 : replace.split(",")) {
            String[] split = str2.split(":");
            if (split.length == 1) {
                linkedHashMap.put(split[0].toLowerCase(), "");
            } else {
                linkedHashMap.put(split[0].toLowerCase(), split[1]);
            }
        }
        return linkedHashMap;
    }

    public static void f0(long j3, int i3, String str) {
        BaseQQAppInterface A0 = A0();
        FileManagerEntity queryFileEntityBySessionId = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileEntityBySessionId(A0, j3);
        if (queryFileEntityBySessionId == null) {
            return;
        }
        int i16 = queryFileEntityBySessionId.nOpType;
        if (i16 != 0) {
            if (i16 != 1) {
                if (i16 != 20) {
                    switch (i16) {
                        case 3:
                        case 5:
                            h0(i3, str, queryFileEntityBySessionId);
                            return;
                        case 4:
                        case 6:
                            Z(i3, str, A0, queryFileEntityBySessionId);
                            return;
                        case 7:
                            Y(str, queryFileEntityBySessionId);
                            return;
                        case 8:
                            break;
                        case 9:
                            b0(i3, null);
                            return;
                        default:
                            switch (i16) {
                                case 52:
                                    Y(str, queryFileEntityBySessionId);
                                    return;
                                case 53:
                                case 54:
                                    break;
                                default:
                                    return;
                            }
                    }
                } else {
                    W(i3, str, A0, queryFileEntityBySessionId);
                    return;
                }
            }
            X(i3, str, queryFileEntityBySessionId);
            return;
        }
        if (!b0(i3, queryFileEntityBySessionId.fileName)) {
            if (i3 == -98090) {
                QLog.d("FileManagerUtil<FileAssistant>", 1, "Over max space for one day");
            } else {
                Y(str, queryFileEntityBySessionId);
            }
        }
    }

    public static String f1(ChatMessage chatMessage) {
        if (chatMessage == null || !chatMessage.isMultiMsg) {
            return "";
        }
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_f_thumb_path_750_");
        String extInfoFromExtStr2 = chatMessage.getExtInfoFromExtStr("_f_thumb_path_384_");
        if (!TextUtils.isEmpty(extInfoFromExtStr) && FileUtils.fileExistsAndNotEmpty(extInfoFromExtStr)) {
            return extInfoFromExtStr;
        }
        if (TextUtils.isEmpty(extInfoFromExtStr) || !FileUtils.fileExistsAndNotEmpty(extInfoFromExtStr2)) {
            return "";
        }
        return extInfoFromExtStr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void f2(AsyncImageView asyncImageView, Object obj) {
        asyncImageView.setDefaultImage(R.drawable.filelook_unknown);
        if (obj instanceof Integer) {
            asyncImageView.setImageResource(((Integer) obj).intValue());
        } else if (obj instanceof String) {
            asyncImageView.setUrlIconAsyncImage((String) obj);
        }
    }

    public static void g0(long j3) {
        FileManagerEntity queryFileEntityBySessionId = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileEntityBySessionId(A0(), j3);
        if (queryFileEntityBySessionId == null) {
            return;
        }
        int i3 = queryFileEntityBySessionId.nOpType;
        if (i3 != 1 && i3 != 8) {
            if (i3 != 20 && i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        return;
                    }
                }
            }
            if (i3 == 6) {
                QQFMToastUtil.n(BaseApplication.getContext().getString(R.string.em5));
                an.j();
                return;
            } else {
                if (((IWeiyunResponseHandler) QRoute.api(IWeiyunResponseHandler.class)).endSave2Weiyun(0)) {
                    QQFMToastUtil.n(BaseApplication.getContext().getString(R.string.em5));
                    an.j();
                    return;
                }
                return;
            }
        }
        QQFMToastUtil.n(U(queryFileEntityBySessionId.fileName) + w1(R.string.b6w) + lc1.b.a().getDefaultRecvPath());
    }

    private static String g1(FileManagerEntity fileManagerEntity, Context context, String str, BaseQQAppInterface baseQQAppInterface) {
        String nickByDiscussionManager = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getNickByDiscussionManager(baseQQAppInterface, fileManagerEntity.peerUin);
        if (fileManagerEntity.bSend) {
            return context.getString(R.string.b5s) + nickByDiscussionManager;
        }
        return context.getString(R.string.b5q) + nickByDiscussionManager;
    }

    public static String g2(Map map) {
        try {
            return new JSONObject(map).toString();
        } catch (Exception unused) {
            return null;
        }
    }

    private static void h0(int i3, String str, FileManagerEntity fileManagerEntity) {
        if (b0(i3, fileManagerEntity.fileName)) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            a0(str);
        } else {
            b0(11, fileManagerEntity.fileName);
        }
    }

    private static String h1(FileManagerEntity fileManagerEntity, Context context, String str, BaseQQAppInterface baseQQAppInterface) {
        String str2;
        TroopInfo troopInfo = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getTroopInfo(baseQQAppInterface, fileManagerEntity.TroopUin);
        if (troopInfo != null && troopInfo.getTroopDisplayName() != null) {
            if (troopInfo.getTroopDisplayName() != null && troopInfo.getTroopDisplayName().length() > 14) {
                str2 = troopInfo.getTroopDisplayName();
            } else {
                str2 = troopInfo.getTroopDisplayName();
            }
        } else {
            str2 = "";
        }
        if (fileManagerEntity.bSend) {
            return context.getString(R.string.b5t) + str2;
        }
        return context.getString(R.string.b5r) + str2;
    }

    private static long h2(long j3, TimeZone timeZone) {
        return (timeZone.getOffset(j3) + j3) / 86400000;
    }

    public static synchronized void i0(long j3) {
        synchronized (QQFileManagerUtilImpl.class) {
            ArrayList<Long> arrayList = f209231e;
            if (arrayList == null) {
                return;
            }
            arrayList.remove(Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.e("##########", 2, "nSessionID[" + j3 + "]\u79fb\u9664\u4e0d\u663e\u793a\u53d6\u6d88\u6309\u94ae\u961f\u5217");
            }
        }
    }

    private static String i1(FileManagerEntity fileManagerEntity, Context context, String str, String str2) {
        if (str != null && !str.equals(context.getString(R.string.b6v)) && !str.equals(context.getString(R.string.b6p))) {
            return fileManagerEntity.peerNick;
        }
        return str2;
    }

    public static String i2(long j3, int i3) {
        long j16 = 604800000;
        if (i3 != 0 && i3 == 3000) {
            j16 = 2592000000L;
        }
        int time = ((int) ((new Date(j3 + j16).getTime() - new Date(com.tencent.mobileqq.service.message.e.K0() * 1000).getTime()) / 86400000)) + 1;
        if (time < 0) {
            return m1(R.string.mip);
        }
        if (time == 0) {
            return m1(R.string.miv);
        }
        return time + m1(R.string.mis);
    }

    public static int j0(String str) {
        if (str == null) {
            return -1;
        }
        if (H0().equalsIgnoreCase(q.k(str))) {
            return 0;
        }
        try {
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(FileManagerUtil.EXTERNALFILE_OF_FM_INFO, 0).edit();
            edit.remove(str);
            edit.commit();
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }

    private static String j1(Context context, FileManagerEntity fileManagerEntity) {
        String string = context.getResources().getString(R.string.f145810sh);
        if (!TextUtils.isEmpty(fileManagerEntity.guildName)) {
            return fileManagerEntity.guildName;
        }
        return string;
    }

    public static FileManagerEntity j2(String str, String str2, String str3, String str4, long j3, String str5, String str6, int i3) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = w0().longValue();
        fileManagerEntity.strFavFileId = str2;
        fileManagerEntity.strFavId = str;
        fileManagerEntity.fileName = str4;
        fileManagerEntity.fileSize = j3;
        fileManagerEntity.nFileType = T0(str4);
        fileManagerEntity.setCloudType(10);
        fileManagerEntity.setFilePath(str3);
        fileManagerEntity.bSend = false;
        fileManagerEntity.status = -1;
        fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity.strFileMd5 = str5;
        fileManagerEntity.peerType = i3;
        fileManagerEntity.peerUin = str6;
        if (i3 == 1) {
            fileManagerEntity.nOpType = 36;
        } else if (i3 == 0) {
            fileManagerEntity.nOpType = 37;
        } else if (i3 == 7) {
            fileManagerEntity.nOpType = 38;
        }
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertToMemMap(A0(), fileManagerEntity);
        return fileManagerEntity;
    }

    private static void k0(Context context, String str, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, context.getString(R.string.cm9));
        bundle2.putString("big_brother_source_key", "biz_src_jc_file");
        bundle2.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_jc_file");
        bundle2.putBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA, bundle);
        A1().startDownloadNoSzie(str, bundle2);
        QLog.i("FileManagerUtil<FileAssistant>", 1, "downloadQQBrowser:" + str);
    }

    private static String k1(FileManagerEntity fileManagerEntity, Context context, String str) {
        int i3 = fileManagerEntity.nOpType;
        if (i3 != -1) {
            if (i3 != 0 && i3 != 3 && i3 != 24 && i3 != 7) {
                if (i3 != 8) {
                    if (i3 != 21 && i3 != 22) {
                        return str;
                    }
                }
            }
            if (fileManagerEntity.nFileType == 13 && fileManagerEntity.selfUin.equals(fileManagerEntity.peerUin)) {
                return context.getString(R.string.b5p);
            }
            return context.getString(R.string.b77);
        }
        String string = context.getString(R.string.b6o);
        if (fileManagerEntity.bSend) {
            return context.getString(R.string.b77);
        }
        return string;
    }

    public static FileManagerEntity k2(FileInfo fileInfo) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = w0().longValue();
        fileManagerEntity.setCloudType(3);
        fileManagerEntity.fileName = fileInfo.j();
        fileManagerEntity.setFilePath(fileInfo.k());
        fileManagerEntity.fileSize = fileInfo.l();
        if (fileInfo.getType() == 5) {
            fileManagerEntity.nFileType = 5;
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).getApkPackageInfo(fileInfo.k(), new a(fileManagerEntity));
        } else {
            fileManagerEntity.nFileType = T0(fileInfo.j());
        }
        fileManagerEntity.status = -1;
        BaseQQAppInterface A0 = A0();
        QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + fileManagerEntity.nSessionId + "] fileName[" + fileInfo.j() + "]by local size(" + fileManagerEntity.imgHeight + ":" + fileManagerEntity.imgWidth + ")");
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertToMemMap(A0, fileManagerEntity);
        return fileManagerEntity;
    }

    public static void l0(Context context, String str, Bundle bundle) {
        if (A1().getApp() == null) {
            Bundle bundle2 = new Bundle();
            bundle2.putString(IUniformDownloadMgr.FILENAME_FROM_DIALOG, context.getString(R.string.cm9));
            bundle2.putString(IUniformDownloadMgr.DOWNLOAD_BIG_BROTHER_SOURCE, "biz_src_jc_file");
            Bundle bundle3 = new Bundle();
            bundle3.putAll(bundle);
            bundle3.putString("big_brother_source_key", "biz_src_jc_file");
            bundle2.putBundle(IUniformDownloadMgr.FILE_BUNDLE_USERDATA, bundle3);
            Intent intent = new Intent(IUniformDownloadMgr.UNIDOWNLOAD_BORDCAST);
            intent.putExtra("param", bundle2);
            intent.putExtra("url", str);
            context.sendBroadcast(intent);
            QLog.i("FileManagerUtil<FileAssistant>", 1, "app is null try sendBroadcast!");
            return;
        }
        Bundle bundle4 = new Bundle();
        bundle4.putAll(bundle);
        bundle4.putString("big_brother_source_key", "biz_src_jc_file");
        k0(context, str, bundle4);
    }

    public static String l1(BaseQQAppInterface baseQQAppInterface, String str, String str2, int i3) {
        if (AppConstants.DATALINE_PC_UIN.equalsIgnoreCase(str)) {
            if (i3 == 2) {
                return "\u6211\u7684\u624b\u673a";
            }
            if (i3 == 1) {
                return "\u6211\u7684Pad";
            }
            return HardCodeUtil.qqStr(R.string.cf5);
        }
        if (AppConstants.DATALINE_IPAD_UIN.equalsIgnoreCase(str)) {
            return HardCodeUtil.qqStr(R.string.f16272217);
        }
        if (AppConstants.DATALINE_PHONE_UIN.equalsIgnoreCase(str)) {
            return "\u6211\u7684\u624b\u673a";
        }
        if (AppConstants.FM_EXTERNAL_SAVEFILE_UIN.equalsIgnoreCase(str)) {
            return "";
        }
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getNickName(baseQQAppInterface, str, i3);
    }

    public static FileManagerEntity l2(OfflineFileInfo offlineFileInfo, int i3) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        BaseQQAppInterface A0 = A0();
        fileManagerEntity.nSessionId = w0().longValue();
        fileManagerEntity.Uuid = offlineFileInfo.f207721e;
        fileManagerEntity.fileIdCrc = offlineFileInfo.f207722f;
        fileManagerEntity.setCloudType(1);
        fileManagerEntity.strThumbPath = offlineFileInfo.G;
        String valueOf = String.valueOf(offlineFileInfo.f207723h);
        fileManagerEntity.peerUin = valueOf;
        fileManagerEntity.peerNick = l1(A0, valueOf, null, i3);
        fileManagerEntity.peerType = i3;
        String str = offlineFileInfo.f207725m;
        fileManagerEntity.fileName = str;
        fileManagerEntity.fileSize = offlineFileInfo.C;
        fileManagerEntity.nFileType = T0(str);
        fileManagerEntity.lastTime = offlineFileInfo.D;
        fileManagerEntity.status = -1;
        fileManagerEntity.srvTime = offlineFileInfo.E;
        fileManagerEntity.bSend = offlineFileInfo.f207720d;
        String str2 = fileManagerEntity.Uuid;
        if (str2 == null || str2.length() == 0) {
            fileManagerEntity.nWeiYunSrcType = -1;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + fileManagerEntity.nSessionId + "] fileName[" + offlineFileInfo.f207725m + "] by offlinefile size(" + fileManagerEntity.imgHeight + ":" + fileManagerEntity.imgWidth + ")");
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertToMemMap(A0, fileManagerEntity);
        return fileManagerEntity;
    }

    public static synchronized void m(long j3) {
        synchronized (QQFileManagerUtilImpl.class) {
            if (f209231e == null) {
                f209231e = new ArrayList<>();
            }
            if (f209231e.contains(Long.valueOf(j3))) {
                return;
            }
            f209231e.add(Long.valueOf(j3));
            if (QLog.isColorLevel()) {
                QLog.e("##########", 2, "nSessionID[" + j3 + "]\u52a0\u5165\u4e0d\u663e\u793a\u53d6\u6d88\u6309\u94ae\u961f\u5217");
            }
        }
    }

    public static synchronized String m0(String str) {
        synchronized (QQFileManagerUtilImpl.class) {
            if (str == null) {
                return "";
            }
            ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(str.length());
            if (!str.equals(null)) {
                int i3 = 0;
                int i16 = 0;
                while (i3 < str.length()) {
                    if (i16 > 15) {
                        i16 %= 16;
                    }
                    int codePointAt = str.codePointAt(i3) + "AnDrDQ_Fm_String".codePointAt(i16);
                    if (codePointAt > 65535) {
                        codePointAt %= 65535;
                    }
                    byteArrayBuffer.append(codePointAt);
                    i3++;
                    i16++;
                }
            }
            return "#_#" + HexUtil.bytes2HexStr(byteArrayBuffer.toByteArray()) + "O_O";
        }
    }

    public static String m1(int i3) {
        return HardCodeUtil.qqStr(i3);
    }

    public static FileManagerEntity m2(WeiYunFileInfo weiYunFileInfo) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = w0().longValue();
        fileManagerEntity.WeiYunFileId = weiYunFileInfo.f209603d;
        String str = weiYunFileInfo.f209605f;
        fileManagerEntity.fileName = str;
        fileManagerEntity.fileSize = weiYunFileInfo.f209606h;
        fileManagerEntity.nFileType = T0(str);
        fileManagerEntity.strThumbPath = weiYunFileInfo.H;
        fileManagerEntity.setCloudType(2);
        int i3 = weiYunFileInfo.f209608m;
        fileManagerEntity.nWeiYunSrcType = i3;
        if (i3 == 2) {
            fileManagerEntity.strLargeThumPath = weiYunFileInfo.E;
        }
        fileManagerEntity.lastTime = weiYunFileInfo.f209607i;
        fileManagerEntity.bSend = false;
        fileManagerEntity.status = -1;
        fileManagerEntity.srvTime = com.tencent.mobileqq.service.message.e.K0() * 1000;
        fileManagerEntity.strFileMd5 = weiYunFileInfo.I;
        fileManagerEntity.WeiYunDirKey = weiYunFileInfo.f209604e;
        fileManagerEntity.strFileSHA = weiYunFileInfo.J;
        BaseQQAppInterface A0 = A0();
        FileManagerEntity queryFileManagerEntityByWeiYunFileIdForMemory = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileManagerEntityByWeiYunFileIdForMemory(A0, weiYunFileInfo.f209603d);
        if (queryFileManagerEntityByWeiYunFileIdForMemory != null) {
            fileManagerEntity.imgWidth = queryFileManagerEntityByWeiYunFileIdForMemory.imgWidth;
            fileManagerEntity.imgHeight = queryFileManagerEntityByWeiYunFileIdForMemory.imgHeight;
        }
        QLog.i("FileManagerUtil<FileAssistant>", 1, "=_= create new Entity[" + fileManagerEntity.nSessionId + "] fileName[" + weiYunFileInfo.f209605f + "] by WeiYun size(" + fileManagerEntity.imgHeight + ":" + fileManagerEntity.imgWidth + ")");
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertToMemMap(A0, fileManagerEntity);
        return fileManagerEntity;
    }

    @TargetApi(9)
    public static int n(String str) {
        if (str == null) {
            return -1;
        }
        if (H0().equalsIgnoreCase(q.k(str))) {
            return 0;
        }
        try {
            SharedPreferences.Editor edit = BaseApplication.getContext().getSharedPreferences(FileManagerUtil.EXTERNALFILE_OF_FM_INFO, 0).edit();
            edit.putString(str, "-");
            edit.apply();
            return 0;
        } catch (Exception e16) {
            e16.printStackTrace();
            return -2;
        }
    }

    public static boolean n0(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new VFSFile(str).exists();
    }

    public static int n1(String str) {
        return BaseApplication.getContext().getSharedPreferences("mobileQQ", 0).getInt("qlink_new_count_" + str, 0);
    }

    public static FileManagerEntity n2(Bundle bundle) {
        FileManagerEntity fileManagerEntity = new FileManagerEntity();
        fileManagerEntity.nSessionId = w0().longValue();
        fileManagerEntity.setCloudType(2);
        fileManagerEntity.nOpType = 50;
        fileManagerEntity.bSend = false;
        fileManagerEntity.WeiYunFileId = (String) bundle.get("file_id");
        fileManagerEntity.fileName = (String) bundle.get("filename");
        fileManagerEntity.WeiYunDirKey = (String) bundle.get("pdir_key");
        return fileManagerEntity;
    }

    public static void o(@NonNull BaseQQAppInterface baseQQAppInterface, Context context, String str, String str2, int i3) {
        p(baseQQAppInterface, context, str, str2, i3, null);
    }

    public static boolean o0(FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return false;
        }
        long j3 = fileManagerEntity.srvTime;
        int i3 = fileManagerEntity.peerType;
        long j16 = 604800000;
        if (i3 != 0 && i3 == 3000) {
            j16 = 2592000000L;
        }
        if (j3 + j16 > com.tencent.mobileqq.service.message.e.K0() * 1000) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String o1(String str) {
        if (str.equalsIgnoreCase("userClickOnceEvent")) {
            return "0X800AE45";
        }
        if (str.equalsIgnoreCase("userClickAlwaysEvent")) {
            return "0X800AE44";
        }
        if (str.equalsIgnoreCase("userMenuClickEvent")) {
            return "0X800AE43";
        }
        return null;
    }

    public static void o2(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface, Activity activity, int i3) {
        FileManagerEntity fileManagerEntity2 = new FileManagerEntity();
        fileManagerEntity2.copyFrom(fileManagerEntity);
        fileManagerEntity2.nSessionId = w0().longValue();
        fileManagerEntity2.status = 2;
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).insertToMemMap(baseQQAppInterface, fileManagerEntity2);
        ForwardFileInfo createForwardFileInfo = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).createForwardFileInfo(fileManagerEntity2);
        createForwardFileInfo.N(i3);
        Bundle bundle = new Bundle();
        bundle.putInt("forward_type", ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
        bundle.putParcelable("fileinfo", createForwardFileInfo);
        bundle.putBoolean("not_forward", true);
        Intent intent = new Intent();
        intent.putExtras(bundle);
        intent.putExtra("destroy_last_activity", true);
        intent.putExtra("forward_type", ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
        intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, fileManagerEntity2.getFilePath());
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, m1(R.string.mj5) + U(fileManagerEntity2.fileName) + m1(R.string.miy) + q.g(fileManagerEntity2.fileSize) + "\u3002");
        intent.putExtra("k_favorites", c2(fileManagerEntity2));
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startForwardActivityForResult(activity, intent, 103);
    }

    public static void p(@NonNull final BaseQQAppInterface baseQQAppInterface, final Context context, final String str, final String str2, final int i3, final Bundle bundle) {
        ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.17
            @Override // java.lang.Runnable
            public void run() {
                try {
                    BitmapFactory.Options options = new BitmapFactory.Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeResource(context.getResources(), i3, options);
                    options.inSampleSize = 1;
                    options.inJustDecodeBounds = false;
                    Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i3, options);
                    if (decodeResource == null) {
                        return;
                    }
                    int e16 = com.tencent.mobileqq.utils.al.e(context);
                    if (decodeResource.getWidth() != e16) {
                        if (!wy2.d.f446753c) {
                            decodeResource = wy2.c.d().a(decodeResource, e16);
                        } else {
                            decodeResource = Bitmap.createScaledBitmap(decodeResource, e16, e16, false);
                        }
                    }
                    if (Build.VERSION.SDK_INT >= 26) {
                        QQFileManagerUtilImpl.q(context, str, str2, i3, bundle);
                        return;
                    }
                    Intent intent = new Intent("android.intent.action.MAIN");
                    intent.addCategory("android.intent.category.LAUNCHER");
                    intent.putExtra(str, true);
                    intent.setClassName(context, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getJumpActivityName());
                    intent.setFlags(337641472);
                    Bundle bundle2 = bundle;
                    if (bundle2 != null) {
                        intent.putExtras(bundle2);
                    }
                    ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).createShortcut(baseQQAppInterface, intent, str2, decodeResource);
                } catch (Exception unused) {
                }
            }
        }, 2, null, true);
    }

    public static String p0(long j3) {
        if (j3 == 0) {
            return "0";
        }
        if (j3 <= 512000) {
            return "0-500k";
        }
        if (j3 <= 1048576) {
            return "500k-1m";
        }
        if (j3 <= 3145728) {
            return "1m-3m";
        }
        if (j3 <= 5242880) {
            return "3m-5m";
        }
        if (j3 <= 10485760) {
            return "5m-10m";
        }
        return ">10m";
    }

    public static String p1(int i3) {
        switch (i3) {
            case 0:
                return "image";
            case 1:
                return "audio";
            case 2:
                return "video";
            case 3:
                return FileReaderHelper.DOC_EXT;
            case 4:
                return "zip";
            case 5:
                return RFixConstants.APK_PATH;
            case 6:
                return "excel";
            case 7:
                return FileReaderHelper.PPT_EXT;
            case 8:
                return TextComponent.SpanType.HTML;
            case 9:
                return FileReaderHelper.PDF_EXT;
            case 10:
                return FileReaderHelper.TXT_EXT;
            case 11:
            default:
                return "other";
            case 12:
                return "psd";
        }
    }

    public static void p2(BaseQQAppInterface baseQQAppInterface, Context context, FileManagerEntity fileManagerEntity) {
        if (!fileManagerEntity.bSend) {
            DialogUtil.createCustomDialog(context, 230, context.getString(R.string.f3y), context.getString(R.string.f3x), R.string.ihc, R.string.f171151ok, new g(), (DialogInterface.OnClickListener) null).show();
            return;
        }
        String string = context.getString(R.string.b6t);
        String string2 = context.getString(R.string.b6s);
        ActionSheet actionSheet = (ActionSheet) ActionSheetHelper.createDialog(context, null);
        actionSheet.addButton(string);
        actionSheet.addCancelButton(context.getString(R.string.cancel));
        actionSheet.setMainTitle(string2);
        actionSheet.setOnButtonClickListener(new h(actionSheet));
        actionSheet.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q(Context context, String str, String str2, int i3, Bundle bundle) {
        ShortcutManager shortcutManager;
        boolean isRequestPinShortcutSupported;
        String str3;
        ShortcutInfo.Builder shortLabel;
        ShortcutInfo.Builder icon;
        ShortcutInfo.Builder intent;
        ShortcutInfo build;
        if (Build.VERSION.SDK_INT >= 26 && (shortcutManager = (ShortcutManager) context.getSystemService(ShortcutManager.class)) != null && !b2(str2, shortcutManager)) {
            isRequestPinShortcutSupported = shortcutManager.isRequestPinShortcutSupported();
            if (isRequestPinShortcutSupported) {
                Intent intent2 = new Intent("android.intent.action.MAIN");
                intent2.addCategory("android.intent.category.LAUNCHER");
                intent2.putExtra(str, true);
                intent2.setClassName(context, ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getJumpActivityName());
                intent2.setFlags(337641472);
                if (bundle != null) {
                    intent2.putExtras(bundle);
                }
                if (!TextUtils.isEmpty(str2) && str2.equals(context.getString(R.string.cf5))) {
                    str3 = "my-dataline-shortcut";
                } else {
                    str3 = "my-shortcut";
                }
                shortLabel = new ShortcutInfo.Builder(context, str3).setShortLabel(str2);
                icon = shortLabel.setIcon(Icon.createWithResource(context, i3));
                intent = icon.setIntent(intent2);
                build = intent.build();
                shortcutManager.requestPinShortcut(build, PendingIntent.getBroadcast(context, 0, new Intent("com.tencent.fileassistant.createshrotcut"), 167772160).getIntentSender());
            }
        }
    }

    public static void q0(ChatMessage chatMessage, MessageForFile messageForFile) {
        messageForFile.uniseq = chatMessage.uniseq;
        messageForFile.msgseq = chatMessage.msgseq;
        messageForFile.fileName = chatMessage.getExtInfoFromExtStr("_m_ForwardFileName");
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardSize");
        if (!TextUtils.isEmpty(extInfoFromExtStr)) {
            messageForFile.fileSize = Long.parseLong(extInfoFromExtStr);
        }
        String extInfoFromExtStr2 = chatMessage.getExtInfoFromExtStr(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUIN());
        String extInfoFromExtStr3 = chatMessage.getExtInfoFromExtStr(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUINTYPE());
        String extInfoFromExtStr4 = chatMessage.getExtInfoFromExtStr(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUNISEQ());
        if (!TextUtils.isEmpty(extInfoFromExtStr2)) {
            messageForFile.saveExtInfoToExtStr(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUIN(), extInfoFromExtStr2);
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr3)) {
            messageForFile.saveExtInfoToExtStr(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUINTYPE(), extInfoFromExtStr3);
        }
        if (!TextUtils.isEmpty(extInfoFromExtStr4)) {
            messageForFile.saveExtInfoToExtStr(((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMultiMsgConstantEXTRAKEYOUTESTUNISEQ(), extInfoFromExtStr4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int q1(String str) {
        if (str == null) {
            return 4;
        }
        if (str.equalsIgnoreCase(TbsConfig.APP_QB)) {
            return 1;
        }
        if (str.equalsIgnoreCase("send_to_wx")) {
            return 2;
        }
        if (!str.equalsIgnoreCase("cn.wps.moffice_eng")) {
            return 4;
        }
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void q2(boolean z16, long j3, int i3, String str, BaseQQAppInterface baseQQAppInterface, int i16) {
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).onResultByDataLineHandler(z16, j3, i3, str, baseQQAppInterface, i16);
    }

    private static String r(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return "";
        }
        return str + str2;
    }

    public static boolean r0(String str, String str2) {
        String j3;
        if (TextUtils.isEmpty(str) || str2 == null || TextUtils.isEmpty(str2) || (j3 = am.j(str)) == null || j3.length() == 0 || str2.indexOf(j3.toLowerCase()) < 0) {
            return false;
        }
        return true;
    }

    public static AppRuntime r1() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    public static void r2(Context context, String str) {
        if (!q.p(str)) {
            c0(R.string.c3d);
            return;
        }
        String mimeType = MimeTypesTools.getMimeType(context, str);
        Intent intent = new Intent();
        intent.addFlags(268435456);
        intent.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        FileProvider7Helper.setIntentDataAndType(context, intent, mimeType, new File(str));
        intent.putExtra("big_brother_source_key", "biz_src_jc_file");
        List<ResolveInfo> queryIntentActivities = InstalledAppListMonitor.queryIntentActivities(context.getPackageManager(), intent, 65536);
        boolean z16 = true;
        if (queryIntentActivities.size() != 1 || !queryIntentActivities.get(0).activityInfo.name.equals("com.tencent.mobileqq.activity.JumpActivity")) {
            z16 = false;
        }
        if (queryIntentActivities.size() > 0 && !z16) {
            try {
                context.startActivity(intent);
                return;
            } catch (Exception unused) {
                QQFMToastUtil.i(R.string.c3d);
                return;
            }
        }
        QQFMToastUtil.i(R.string.c3d);
    }

    public static void s(FileManagerEntity fileManagerEntity) {
        int i3;
        if (fileManagerEntity == null) {
            return;
        }
        boolean p16 = q.p(fileManagerEntity.getFilePath());
        if (p16 && G(fileManagerEntity.nOpType)) {
            fileManagerEntity.cloudType = 3;
            fileManagerEntity.status = 1;
            return;
        }
        if (fileManagerEntity.getCloudType() != 3) {
            return;
        }
        if (p16 && ((i3 = fileManagerEntity.nOpType) == 0 || i3 == 6 || i3 == 52)) {
            return;
        }
        if (p16 && fileManagerEntity.nOpType == 51) {
            if (fileManagerEntity.status == 16) {
                fileManagerEntity.status = 0;
                return;
            }
            return;
        }
        if (fileManagerEntity.nFileType == 5) {
            ((IQQFileSelectorUtil) QRoute.api(IQQFileSelectorUtil.class)).upDataApkPathForPackageName(fileManagerEntity);
        }
        if (fileManagerEntity.status == 1) {
            fileManagerEntity.status = 16;
            int i16 = fileManagerEntity.peerType;
            if (i16 == 6000) {
                fileManagerEntity.setCloudType(6);
                fileManagerEntity.status = 16;
                return;
            }
            if (i16 == 10014) {
                fileManagerEntity.setCloudType(12);
                fileManagerEntity.status = -1;
                return;
            }
            if (i16 == com.tencent.mobileqq.filemanager.data.e.f207742a) {
                fileManagerEntity.setCloudType(13);
                fileManagerEntity.status = -1;
                return;
            }
            String str = fileManagerEntity.Uuid;
            if (str != null && str.length() > 0) {
                fileManagerEntity.setCloudType(1);
                fileManagerEntity.status = -1;
            } else if (!TextUtils.isEmpty(fileManagerEntity.WeiYunFileId)) {
                fileManagerEntity.setCloudType(2);
                fileManagerEntity.status = -1;
            }
        }
    }

    public static synchronized void s0(FileManagerEntity fileManagerEntity) {
        boolean z16;
        synchronized (QQFileManagerUtilImpl.class) {
            StringBuilder sb5 = new StringBuilder();
            if (fileManagerEntity == null) {
                sb5.append("entity is nll,stack:" + w2());
                QLog.i("FileManagerUtil<FileAssistant>", 1, sb5.toString());
                return;
            }
            int i3 = fileManagerEntity.nFileType;
            if (i3 != 2 && i3 != 0) {
                sb5.append("entity[");
                sb5.append(fileManagerEntity.nSessionId);
                sb5.append("] is not pic or video, return");
                QLog.i("FileManagerUtil<FileAssistant>", 1, sb5.toString());
                return;
            }
            if (fileManagerEntity.imgHeight > 0 && fileManagerEntity.imgWidth > 0) {
                sb5.append("entity[");
                sb5.append(fileManagerEntity.nSessionId);
                sb5.append("] size(wh)[");
                sb5.append(fileManagerEntity.imgWidth);
                sb5.append(":");
                sb5.append(fileManagerEntity.imgHeight);
                sb5.append("] OK, return!");
                QLog.i("FileManagerUtil<FileAssistant>", 1, sb5.toString());
                return;
            }
            String filePath = fileManagerEntity.getFilePath();
            if (q.f(filePath)) {
                if (i3 == 2) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                sb5.append("entity[");
                sb5.append(fileManagerEntity.nSessionId);
                sb5.append("] is local, use local calc size!");
            } else {
                filePath = fileManagerEntity.strLargeThumPath;
                if (q.f(filePath)) {
                    sb5.append("entity[");
                    sb5.append(fileManagerEntity.nSessionId);
                    sb5.append("] is cloude , use largThumb calc size!");
                } else {
                    filePath = fileManagerEntity.strMiddleThumPath;
                    if (q.f(filePath)) {
                        sb5.append("entity[");
                        sb5.append(fileManagerEntity.nSessionId);
                        sb5.append("] is cloud , use middleThumb calc size!,becarefull middle must createByLarge!!!");
                    } else if (i3 == 2) {
                        filePath = fileManagerEntity.strThumbPath;
                        if (q.f(filePath)) {
                            sb5.append("entity[");
                            sb5.append(fileManagerEntity.nSessionId);
                            sb5.append("] video is cloud , use thumb calc size!");
                        }
                    }
                }
                z16 = true;
            }
            if (TextUtils.isEmpty(filePath)) {
                sb5.append("entity[");
                sb5.append(fileManagerEntity.nSessionId);
                sb5.append("] is No LoaclFile,No LargeThumb,No middleThumb,so return");
                QLog.e("FileManagerUtil<FileAssistant>", 1, sb5.toString());
                return;
            }
            if (z16) {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).decodeFileWithBufferedStream(filePath, options);
                if (fileManagerEntity.imgHeight <= 0 || fileManagerEntity.imgWidth <= 0) {
                    fileManagerEntity.imgWidth = options.outWidth;
                    fileManagerEntity.imgHeight = options.outHeight;
                }
                int exifRotation = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getExifRotation(filePath);
                if (exifRotation == 90 || exifRotation == 270) {
                    fileManagerEntity.imgWidth = options.outHeight;
                    fileManagerEntity.imgHeight = options.outWidth;
                }
            } else if (i3 == 2) {
                M(fileManagerEntity);
            }
            sb5.append(" calc size over size(wh)[");
            sb5.append(fileManagerEntity.imgWidth);
            sb5.append(":");
            sb5.append(fileManagerEntity.imgHeight);
            sb5.append("]");
            sb5.append(" useImageCreateThumb:");
            sb5.append(z16);
            QLog.i("FileManagerUtil<FileAssistant>", 1, sb5.toString());
        }
    }

    public static byte[] s1(String str) {
        return E0(str, KeyPropertiesCompact.DIGEST_SHA1);
    }

    public static void s2(Activity activity, String str) {
        if (str != null && q.p(str)) {
            if (T0(str) == 5) {
                P1(activity, str);
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800AE42", "0X800AE42", 0, 0, "", "", "", "");
            FileManagerReporter.addData("0X8007152");
            WeakReference weakReference = new WeakReference(activity);
            Bundle bundle = new Bundle();
            bundle.putString("ChannelId", "biz_src_jc_file");
            WXShareHelper b06 = WXShareHelper.b0();
            if (b06.e0() && b06.d0()) {
                Bundle bundle2 = new Bundle();
                bundle2.putString("name", "send_to_wx");
                bundle2.putInt(DittoImageArea.RESOURCE_ID, R.drawable.nc6);
                bundle2.putString("value", "\u53d1\u9001\u5230\u5fae\u4fe1");
                Bundle bundle3 = new Bundle();
                bundle3.putBundle("weixin", bundle2);
                bundle.putBundle("extraMenu", bundle3);
            }
            QbSdk.openFileReaderListWithQBDownload(activity, str, bundle, new f(weakReference, str, b06));
            return;
        }
        c0(R.string.bet);
    }

    public static boolean t(boolean z16, ArrayList<FileManagerEntity> arrayList) {
        if (arrayList == null || arrayList.size() == 0) {
            return false;
        }
        Iterator<FileManagerEntity> it = arrayList.iterator();
        while (it.hasNext()) {
            if (kc1.c.m(it.next()).c(z16)) {
                return true;
            }
        }
        if (0 <= ((IFMConfig) QRoute.api(IFMConfig.class)).getFlowDialogSize()) {
            return false;
        }
        return true;
    }

    public static void t0(List<FileManagerEntity> list, Activity activity) {
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        ArrayList<? extends Parcelable> arrayList2 = new ArrayList<>();
        long j3 = 0;
        if (list != null && list.size() > 0) {
            for (FileManagerEntity fileManagerEntity : list) {
                if (!fileManagerEntity.sendCloudUnsuccessful()) {
                    ForwardFileInfo forwardFileInfo = new ForwardFileInfo();
                    forwardFileInfo.N(10001);
                    forwardFileInfo.w(fileManagerEntity.getCloudType());
                    forwardFileInfo.E(fileManagerEntity.nSessionId);
                    forwardFileInfo.y(fileManagerEntity.fileName);
                    forwardFileInfo.V(fileManagerEntity.uniseq);
                    forwardFileInfo.x(fileManagerEntity.WeiYunFileId);
                    forwardFileInfo.z(fileManagerEntity.fileSize);
                    forwardFileInfo.C(fileManagerEntity.getFilePath());
                    forwardFileInfo.Z(fileManagerEntity.Uuid);
                    forwardFileInfo.L = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getForwardId();
                    if (fileManagerEntity.getCloudType() == 3 && fileManagerEntity.getFilePath() != null && fileManagerEntity.getFilePath().length() > 0) {
                        arrayList.add(Uri.parse(fileManagerEntity.getFilePath()));
                    } else {
                        arrayList.add(Uri.parse(""));
                    }
                    j3 += forwardFileInfo.g();
                    arrayList2.add(forwardFileInfo);
                }
            }
        }
        Bundle bundle = new Bundle();
        Intent intent = new Intent();
        bundle.putInt("forward_type", ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
        bundle.putParcelableArrayList("fileinfo_array", arrayList2);
        bundle.putBoolean("not_forward", true);
        intent.putExtra("sendMultiple", true);
        bundle.putParcelableArrayList("android.intent.extra.STREAM", arrayList);
        intent.putExtras(bundle);
        intent.putExtra("foward_editbar", true);
        intent.putExtra("forward_type", ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getForwardUtilsForwardTypeFILE());
        String m16 = m1(R.string.mji);
        if (arrayList2.size() == 1) {
            m16 = m1(R.string.f171978mj0) + U(((ForwardFileInfo) arrayList2.get(0)).f()) + m1(R.string.mj_) + q.g(((ForwardFileInfo) arrayList2.get(0)).g()) + "\u3002";
        } else if (arrayList2.size() > 1) {
            m16 = m1(R.string.miu) + U(((ForwardFileInfo) arrayList2.get(0)).f()) + m1(R.string.mj7) + arrayList2.size() + m1(R.string.mja) + q.g(j3) + "\u3002";
        }
        intent.putExtra(AppConstants.Key.FORWARD_TEXT, m16);
        intent.putExtra("k_favorites", false);
        ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).startForwardActivityForResult(activity, intent, 103);
    }

    public static FileManagerEntity t1() {
        ArrayList<FileManagerEntity> recentFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getRecentFiles();
        Set<FileInfo> localFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getLocalFiles();
        ArrayList<WeiYunFileInfo> weiYunFiles = ((IFMDataCacheApi) QRoute.api(IFMDataCacheApi.class)).getWeiYunFiles();
        if (recentFiles != null && recentFiles.size() > 0) {
            Iterator<FileManagerEntity> it = recentFiles.iterator();
            while (it.hasNext()) {
                FileManagerEntity next = it.next();
                if (next.nFileType == 0) {
                    return next;
                }
            }
        }
        if (localFiles != null && localFiles.size() > 0) {
            for (FileInfo fileInfo : localFiles) {
                if (fileInfo.getType() == 0) {
                    return k2(fileInfo);
                }
            }
        }
        if (weiYunFiles != null && weiYunFiles.size() > 0) {
            Iterator<WeiYunFileInfo> it5 = weiYunFiles.iterator();
            while (it5.hasNext()) {
                WeiYunFileInfo next2 = it5.next();
                if (T0(next2.f209605f) == 0) {
                    return m2(next2);
                }
            }
            return null;
        }
        return null;
    }

    public static void t2(BaseQQAppInterface baseQQAppInterface, FileManagerEntity fileManagerEntity) {
        if (fileManagerEntity == null) {
            return;
        }
        int T0 = T0(fileManagerEntity.fileName);
        if (T0 == 0) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + fileManagerEntity.nSessionId + "] PicFile, size(wh)[" + fileManagerEntity.imgWidth + ":" + fileManagerEntity.imgHeight + "]");
        } else if (T0 == 2) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + fileManagerEntity.nSessionId + "] VideoFile,  Preload VideoThumb size(wh)[" + fileManagerEntity.imgWidth + ":" + fileManagerEntity.imgHeight + "]");
        } else {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "not pic or video!");
            return;
        }
        if (!Y1() && R1()) {
            return;
        }
        if (T0 == 0) {
            if (((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).isNeedCompressCut(fileManagerEntity)) {
                fileManagerEntity.strThumbPath = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).downLoadDiscThumb(baseQQAppInterface, fileManagerEntity, 7);
                if (QLog.isColorLevel()) {
                    QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + fileManagerEntity.nSessionId + "] is badPic Preload 750 Thumb[" + fileManagerEntity.strThumbPath + "]");
                    return;
                }
                return;
            }
            fileManagerEntity.strThumbPath = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).downLoadDiscThumb(baseQQAppInterface, fileManagerEntity, 5);
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + fileManagerEntity.nSessionId + "] Preload 384 Thumb[" + fileManagerEntity.strThumbPath + "]");
            }
            if (!R1()) {
                fileManagerEntity.strThumbPath = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).downLoadDiscThumb(baseQQAppInterface, fileManagerEntity, 7);
                if (QLog.isColorLevel()) {
                    QLog.i("FileManagerUtil<FileAssistant>", 1, "PreloadThumb Id[" + fileManagerEntity.nSessionId + "] is Wi-Fi Preload 750 Thumb[" + fileManagerEntity.strThumbPath + "]");
                    return;
                }
                return;
            }
            return;
        }
        if (T0 == 2) {
            if (fileManagerEntity.peerType == 3000) {
                String downloadDiscVideoThumb = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).downloadDiscVideoThumb(baseQQAppInterface, fileManagerEntity);
                if (downloadDiscVideoThumb != null) {
                    fileManagerEntity.strLargeThumPath = downloadDiscVideoThumb;
                    return;
                }
                return;
            }
            String downloadOfflineVideoThumb = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).downloadOfflineVideoThumb(baseQQAppInterface, fileManagerEntity);
            if (downloadOfflineVideoThumb != null) {
                fileManagerEntity.strLargeThumPath = downloadOfflineVideoThumb;
            }
        }
    }

    public static boolean u(int i3) {
        if (i3 == com.tencent.mobileqq.filemanager.data.e.f207744c) {
            return true;
        }
        return false;
    }

    public static long u0() {
        int i3 = MobileQQServiceBase.seq;
        MobileQQServiceBase.seq = i3 + 1;
        return i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x012b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:? A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] u1(String str) {
        Throwable th5;
        BufferedInputStream bufferedInputStream;
        long j3;
        long j16;
        long j17;
        long Q0 = Q0(str);
        if (Q0 < GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            return null;
        }
        try {
            long j18 = (Q0 / 2) - 5242880;
            long j19 = 1;
            long j26 = ((Q0 / 2) + 5242880) - 1;
            long j27 = Q0 - 10485760;
            long j28 = Q0 - 1;
            MessageDigest messageDigest = MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_SHA1);
            bufferedInputStream = new BufferedInputStream(new FileInputStream(str));
            int i3 = 0;
            long j29 = 0;
            while (true) {
                int i16 = i3;
                try {
                    try {
                        byte[] bArr = new byte[(int) Math.min((10485759 - j29) + j19, 10240L)];
                        int read = bufferedInputStream.read(bArr);
                        messageDigest.update(bArr, 0, read);
                        j29 += read;
                        i3 = i16 + read;
                        if (j29 >= 10485760) {
                            break;
                        }
                        j19 = 1;
                    } catch (Throwable th6) {
                        th5 = th6;
                        if (bufferedInputStream == null) {
                            try {
                                bufferedInputStream.close();
                                throw th5;
                            } catch (IOException e16) {
                                e16.printStackTrace();
                                throw th5;
                            }
                        }
                        throw th5;
                    }
                } catch (Exception e17) {
                    e = e17;
                    e.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                            return null;
                        } catch (IOException e18) {
                            e18.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            }
            long j36 = 1;
            bufferedInputStream.skip((j18 - 10485759) - 1);
            long j37 = 0;
            while (true) {
                long j38 = j26 - j18;
                long j39 = j18;
                j3 = Q0;
                byte[] bArr2 = new byte[(int) Math.min((j38 - j37) + j36, 10240L)];
                int read2 = bufferedInputStream.read(bArr2);
                messageDigest.update(bArr2, 0, read2);
                j37 += read2;
                i3 += read2;
                j16 = 1;
                if (j37 >= j38 + 1) {
                    break;
                }
                j36 = 1;
                Q0 = j3;
                j18 = j39;
            }
            bufferedInputStream.skip((j27 - j26) - 1);
            int i17 = i3;
            long j46 = 0;
            do {
                j17 = j28 - j27;
                byte[] bArr3 = new byte[(int) Math.min((j17 - j46) + j16, 10240L)];
                int read3 = bufferedInputStream.read(bArr3);
                if (read3 <= 0) {
                    break;
                }
                messageDigest.update(bArr3, 0, read3);
                j46 += read3;
                i17 += read3;
                j16 = 1;
            } while (j46 < j17 + 1);
            byte[] bArr4 = new byte[8];
            for (int i18 = 0; i18 < 8; i18++) {
                bArr4[(8 - i18) - 1] = (byte) ((j3 >> (64 - (r6 * 8))) & 255);
            }
            messageDigest.update(bArr4, 0, 8);
            QLog.i("FileManagerUtil<FileAssistant>", 1, "totalRead:" + i17);
            byte[] digest = messageDigest.digest();
            try {
                bufferedInputStream.close();
            } catch (IOException e19) {
                e19.printStackTrace();
            }
            return digest;
        } catch (Exception e26) {
            e = e26;
            bufferedInputStream = null;
        } catch (Throwable th7) {
            th5 = th7;
            bufferedInputStream = null;
            if (bufferedInputStream == null) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long u2(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17, BaseQQAppInterface baseQQAppInterface, int i18) {
        return ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).prepareForwardByDataLineMsgRecord(str, i3, str2, i16, str3, str4, str5, j3, i17, baseQQAppInterface, i18);
    }

    public static String v(ByteStringMicro byteStringMicro) {
        try {
            byte[] byteArray = byteStringMicro.toByteArray();
            if (byteArray == null) {
                return "";
            }
            char[] charArray = "0123456789ABCDEF".toCharArray();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b16 : byteArray) {
                stringBuffer.append(charArray[(b16 >>> 4) & 15]);
                stringBuffer.append(charArray[b16 & RegisterType.DOUBLE_HI]);
            }
            return stringBuffer.toString();
        } catch (Exception e16) {
            e16.printStackTrace();
            return "";
        }
    }

    public static long v0() {
        return com.tencent.mobileqq.service.message.s.f(com.tencent.mobileqq.service.message.s.a());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0010. Please report as an issue. */
    public static int v1(int i3) {
        if (i3 == 0) {
            return 0;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3 && i3 != 4001) {
                    switch (i3) {
                        case 1001:
                        case 1002:
                            break;
                        case 1003:
                            break;
                        case 1004:
                            break;
                        case 1005:
                            return 0;
                        default:
                            switch (i3) {
                                case 2001:
                                case 2002:
                                    break;
                                case 2003:
                                    break;
                                case 2004:
                                    break;
                                case 2005:
                                    return 0;
                                default:
                                    return -1;
                            }
                    }
                }
                return 3;
            }
            return 2;
        }
        return 1;
    }

    public static synchronized String v2(FileManagerEntity fileManagerEntity) {
        synchronized (QQFileManagerUtilImpl.class) {
            if (fileManagerEntity == null) {
                return "";
            }
            return "FileManagerEntity info, ], nSessionId[" + fileManagerEntity.nSessionId + "], fileName[" + fileManagerEntity.fileName + "], cloudType[" + fileManagerEntity.getCloudType() + "], uniseq[" + fileManagerEntity.uniseq + "], nRelatedSessionId[" + fileManagerEntity.nRelatedSessionId + "], bDelInAio[" + fileManagerEntity.bDelInAio + "], bDelInFM[" + fileManagerEntity.bDelInFM + "], fileSize[" + fileManagerEntity.fileSize + "], fProgress[" + fileManagerEntity.fProgress + "], lastTime[" + fileManagerEntity.lastTime + "], msgSeq[" + fileManagerEntity.msgSeq + "], msgUid[" + fileManagerEntity.msgUid + "], msgTime[" + fileManagerEntity.msgTime + "], nFileType[" + fileManagerEntity.nFileType + "], nOpType[" + fileManagerEntity.nOpType + "], nWeiYunSrcType[" + fileManagerEntity.nWeiYunSrcType + "], peerNick[" + fileManagerEntity.peerNick + "], peerType[" + fileManagerEntity.peerType + "], peerUin[" + m0(fileManagerEntity.peerUin) + "], selfUin[" + m0(fileManagerEntity.selfUin) + "], srvTime[" + fileManagerEntity.srvTime + "], status[" + fileManagerEntity.status + "], strFilePath[" + fileManagerEntity.getFilePath() + "], strServerPath[" + fileManagerEntity.strServerPath + "], strThumbPath[" + fileManagerEntity.strThumbPath + "], Uuid[" + fileManagerEntity.Uuid + "], WeiYunFileId[" + fileManagerEntity.WeiYunFileId + "], nOLfileSessionId[" + fileManagerEntity.nOLfileSessionId + "], strFileMd5[" + fileManagerEntity.strFileMd5 + "], strFileSHA[" + fileManagerEntity.strFileSHA + "], nOLfileSessionId[" + fileManagerEntity.nOLfileSessionId + "], WeiYunDirKey[" + fileManagerEntity.WeiYunDirKey + "], _status[" + fileManagerEntity.getStatus() + "], bOnceSuccess[" + fileManagerEntity.bOnceSuccess + "], imgHeight[" + fileManagerEntity.imgHeight + "], imgWidth[" + fileManagerEntity.imgWidth + "]";
        }
    }

    public static int w(List<FileInfo> list, long j3) {
        int size = list.size() - 1;
        int i3 = 0;
        while (i3 <= size) {
            int i16 = (i3 + size) >>> 1;
            FileInfo fileInfo = list.get(i16);
            if (fileInfo.e() > j3) {
                i3 = i16 + 1;
            } else if (fileInfo.e() < j3) {
                size = i16 - 1;
            } else {
                return i16;
            }
        }
        return i3;
    }

    public static Long w0() {
        return Long.valueOf((((int) (System.currentTimeMillis() / 1000)) << 32) | Math.abs(new Random().nextInt()));
    }

    private static String w1(int i3) {
        return BaseApplication.getContext().getString(i3);
    }

    public static synchronized String w2() {
        String printStack;
        synchronized (QQFileManagerUtilImpl.class) {
            printStack = FileUtils.printStack();
        }
        return printStack;
    }

    public static void x(final TextView textView, final FileManagerEntity fileManagerEntity) {
        if (textView.getMeasuredWidth() == 0) {
            textView.post(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.9
                @Override // java.lang.Runnable
                public void run() {
                    QQFileManagerUtilImpl.Q1(textView, fileManagerEntity);
                }
            });
        } else {
            Q1(textView, fileManagerEntity);
        }
    }

    public static byte[] x0(String str) {
        return u1(str);
    }

    public static byte[] x1(BaseQQAppInterface baseQQAppInterface, String str, int i3) {
        com.tencent.mobileqq.service.message.e msgCache = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).getMsgCache(baseQQAppInterface);
        if (i3 != 100) {
            if (i3 != 109) {
                if (i3 != 124) {
                    if (i3 != 127) {
                        return null;
                    }
                    return msgCache.c1(str);
                }
                return msgCache.k0(str);
            }
            return msgCache.q0(str);
        }
        return msgCache.b0(str);
    }

    public static void x2(final BaseQQAppInterface baseQQAppInterface, long j3) {
        int timAIOGaryTipsCount = ((IFMConfig) QRoute.api(IFMConfig.class)).timAIOGaryTipsCount();
        if (timAIOGaryTipsCount == 0) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "aio switch is off,return!");
                return;
            }
            return;
        }
        String str = "showTime_" + baseQQAppInterface.getCurrentAccountUin();
        final FileManagerEntity queryFileManagerEntityBySessionId = ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).queryFileManagerEntityBySessionId(baseQQAppInterface, j3);
        if (queryFileManagerEntityBySessionId == null) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "entity is null! return");
                return;
            }
            return;
        }
        int T0 = T0(queryFileManagerEntityBySessionId.fileName);
        if (T0 == -1 || T0 == 11) {
            T0 = T0(queryFileManagerEntityBySessionId.getFilePath());
        }
        if (T0 != 3 && T0 != 6) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "File type wrong, return!");
                return;
            }
            return;
        }
        int i3 = queryFileManagerEntityBySessionId.peerType;
        if (i3 != 0 && i3 != 3000) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "aio[" + queryFileManagerEntityBySessionId.peerType + "] not buddy or disc, return!");
                return;
            }
            return;
        }
        SharedPreferences sharedPreferences = baseQQAppInterface.getApplication().getSharedPreferences("TimTips", 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        int i16 = sharedPreferences.getInt("AIOshowTime_Total", 0);
        if (i16 >= timAIOGaryTipsCount) {
            if (QLog.isColorLevel()) {
                QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "more then total return!");
                return;
            }
            return;
        }
        long j16 = sharedPreferences.getLong(str, 0L);
        long K0 = com.tencent.mobileqq.service.message.e.K0();
        if (K0 - j16 < 86400000) {
            if (QLog.isColorLevel()) {
                QLog.w("FileManagerUtil<FileAssistant>_TimTips", 2, "less OneDay return!");
                return;
            }
            return;
        }
        if (PackageUtil.isAppInstalled(baseQQAppInterface.getApp().getBaseContext(), AppConstants.TIM_PACKAGE_NAME)) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>_TimTips", 2, "Tim installed return!");
                return;
            }
            return;
        }
        new Handler(ThreadManagerV2.getSubThreadLooper()).postDelayed(new Runnable() { // from class: com.tencent.mobileqq.filemanager.util.QQFileManagerUtilImpl.15
            @Override // java.lang.Runnable
            public void run() {
                IQQFileTempUtils iQQFileTempUtils = (IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class);
                BaseQQAppInterface baseQQAppInterface2 = BaseQQAppInterface.this;
                iQQFileTempUtils.insertAIOGrayTips(baseQQAppInterface2, queryFileManagerEntityBySessionId.peerUin, baseQQAppInterface2.getCurrentAccountUin(), queryFileManagerEntityBySessionId.peerType, MessageRecord.MSG_TYPE_TIM_GUIDE, BaseApplication.getContext().getString(R.string.bam));
            }
        }, 1000L);
        edit.putLong(str, K0);
        edit.putInt("AIOshowTime_Total", i16 + 1);
        edit.commit();
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerUtil<FileAssistant>_TimTips", 1, "lastShowTime[" + K0 + "],[" + m0(queryFileManagerEntityBySessionId.peerUin) + "]add new aiograyTips!");
        }
    }

    public static boolean y(FileManagerEntity fileManagerEntity) {
        return !am.j(fileManagerEntity.getFilePath()).equalsIgnoreCase(".mov");
    }

    public static ArrayList<FileInfo> y0(boolean z16, int i3) {
        FileInfo fileInfo;
        VFSFile[] listFiles = new VFSFile(H0()).listFiles();
        if (listFiles == null) {
            return null;
        }
        ArrayList<FileInfo> arrayList = new ArrayList<>();
        for (VFSFile vFSFile : listFiles) {
            String path = vFSFile.getPath();
            if (z16 || !vFSFile.getName().startsWith(".")) {
                try {
                    fileInfo = new FileInfo(path);
                } catch (FileNotFoundException e16) {
                    e16.printStackTrace();
                    fileInfo = null;
                }
                if (fileInfo != null) {
                    arrayList.add(fileInfo);
                }
            }
        }
        try {
            Map<String, ?> all = BaseApplication.getContext().getSharedPreferences(FileManagerUtil.EXTERNALFILE_OF_FM_INFO, 0).getAll();
            if (all != null && all.size() > 0) {
                Iterator<T> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    String str = (String) ((Map.Entry) it.next()).getKey();
                    if (q.p(str)) {
                        VFSFile vFSFile2 = new VFSFile(str);
                        FileInfo fileInfo2 = new FileInfo();
                        fileInfo2.y(vFSFile2.getName());
                        fileInfo2.t(vFSFile2.isDirectory());
                        fileInfo2.z(vFSFile2.getPath());
                        fileInfo2.A(vFSFile2.length());
                        fileInfo2.r(vFSFile2.lastModified());
                        arrayList.add(fileInfo2);
                    }
                }
            }
        } catch (Exception e17) {
            e17.printStackTrace();
        }
        if (i3 == 0) {
            Collections.sort(arrayList, new q.a());
        } else {
            Collections.sort(arrayList, new com.tencent.mobileqq.filemanager.util.g());
        }
        return arrayList;
    }

    public static long y1(int i3) {
        if (i3 != 1000) {
            if (i3 != 1001) {
                if (i3 != 1004) {
                    if (i3 != 1006) {
                        if (i3 != 1010) {
                            if (i3 != 10002) {
                                if (i3 != 1024 && i3 != 1025) {
                                    return -1L;
                                }
                                return 124L;
                            }
                            return 127L;
                        }
                        return 109L;
                    }
                    return 102L;
                }
                return 105L;
            }
            return 100L;
        }
        return 104L;
    }

    public static String y2(String str) {
        String str2;
        String str3;
        int lastIndexOf = str.lastIndexOf("/");
        int lastIndexOf2 = str.lastIndexOf(".");
        String str4 = "";
        if (lastIndexOf <= 0) {
            str2 = "";
            str3 = str2;
        } else {
            if (lastIndexOf2 > 0 && lastIndexOf2 > lastIndexOf) {
                str4 = str.substring(lastIndexOf, lastIndexOf2);
                str3 = str.substring(lastIndexOf2);
            } else {
                str4 = str.substring(lastIndexOf);
                str3 = "";
            }
            str2 = str.substring(0, lastIndexOf);
        }
        VFSFile vFSFile = new VFSFile(str);
        int i3 = 1;
        while (vFSFile.exists()) {
            str = str2 + str4 + "(" + i3 + ")" + str3;
            vFSFile = new VFSFile(str);
            i3++;
        }
        return str;
    }

    private static boolean z(ChatMessage chatMessage) {
        if (chatMessage == null || !QQFileUtilsImpl.b(chatMessage)) {
            return false;
        }
        String extInfoFromExtStr = chatMessage.getExtInfoFromExtStr("_m_ForwardFileStatus");
        if (!TextUtils.isEmpty(extInfoFromExtStr) && Integer.parseInt(extInfoFromExtStr) != 1) {
            return false;
        }
        return true;
    }

    @TargetApi(9)
    public static Map<String, File> z0(Context context) {
        boolean z16;
        HashMap hashMap = new HashMap(10);
        try {
            hashMap.put(FileManagerUtil.SD_CARD, Environment.getExternalStorageDirectory());
            StorageManager storageManager = (StorageManager) context.getSystemService(QQPermissionConstants.Permission.STORAGE_GROUP);
            for (String str : (String[]) storageManager.getClass().getMethod("getVolumePaths", null).invoke(storageManager, null)) {
                File file = new File(str);
                if (file.getUsableSpace() > 0) {
                    if (!hashMap.isEmpty()) {
                        Iterator it = hashMap.keySet().iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((File) hashMap.get((String) it.next())).getPath().equalsIgnoreCase(str)) {
                                    z16 = true;
                                    break;
                                }
                            } else {
                                z16 = false;
                                break;
                            }
                        }
                        if (z16) {
                        }
                    }
                    QLog.i("FileManagerUtil<FileAssistant>", 1, "this is a extCard Path:" + file.getPath());
                    hashMap.put(FileManagerUtil.EXTERNAL_SD_CARD, file);
                }
            }
        } catch (IllegalAccessException e16) {
            e16.printStackTrace();
        } catch (IllegalArgumentException e17) {
            e17.printStackTrace();
        } catch (NoSuchMethodException e18) {
            e18.printStackTrace();
        } catch (InvocationTargetException e19) {
            e19.printStackTrace();
        } catch (Exception e26) {
            e26.printStackTrace();
        }
        if (!hashMap.containsKey(FileManagerUtil.EXTERNAL_SD_CARD)) {
            try {
                File externalFilesDir = context.getExternalFilesDir(null);
                if (externalFilesDir != null) {
                    QLog.i("FileManagerUtil<FileAssistant>", 1, "extCard Path:" + externalFilesDir.getPath());
                    if (!externalFilesDir.getAbsolutePath().contains(((File) hashMap.get(FileManagerUtil.SD_CARD)).getAbsolutePath())) {
                        QLog.i("FileManagerUtil<FileAssistant>", 1, "this is a extCard. Path:" + externalFilesDir.getPath());
                        hashMap.put(FileManagerUtil.EXTERNAL_SD_CARD, externalFilesDir);
                    }
                } else {
                    QLog.i("FileManagerUtil<FileAssistant>", 1, "extCard Path:null");
                }
            } catch (Exception e27) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "Exception:" + e27.toString());
            }
        }
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0031  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static TimeoutParam z1() {
        int i3;
        boolean z16;
        int msfConnectedNetType;
        boolean z17;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) BaseApplication.getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        boolean z18 = false;
        if (activeNetworkInfo != null) {
            i3 = NetworkMonitor.getType(activeNetworkInfo);
            if (i3 == 1) {
                z16 = true;
                msfConnectedNetType = MobileQQ.sMobileQQ.getMsfConnectedNetType();
                if (msfConnectedNetType != 2) {
                    z17 = true;
                } else {
                    z17 = false;
                }
                if (QLog.isColorLevel()) {
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("getNetworkInfo,systemType:");
                    sb5.append(i3);
                    sb5.append(" msfType:");
                    sb5.append(msfConnectedNetType);
                    sb5.append(" isSameNet:");
                    if (z16 == z17) {
                        z18 = true;
                    }
                    sb5.append(z18);
                    QLog.i("FileManagerUtil<FileAssistant>.NetDebug", 1, sb5.toString());
                }
                if (z16 == z17) {
                    TimeoutParam timeoutParam = new TimeoutParam();
                    timeoutParam.readTimeoutFor2G = 20000;
                    timeoutParam.readTimeoutFor3G = 15000;
                    timeoutParam.readTimeoutForWifi = 10000;
                    timeoutParam.connectTimeoutFor2G = 10000;
                    timeoutParam.connectTimeoutFor3G = 5000;
                    timeoutParam.connectTimeoutForWifi = 5000;
                    return timeoutParam;
                }
                return null;
            }
        } else {
            i3 = -1;
        }
        z16 = false;
        msfConnectedNetType = MobileQQ.sMobileQQ.getMsfConnectedNetType();
        if (msfConnectedNetType != 2) {
        }
        if (QLog.isColorLevel()) {
        }
        if (z16 == z17) {
        }
    }

    public static boolean z2(VFSFile vFSFile, VFSFile vFSFile2) {
        boolean z16;
        if (QLog.isColorLevel()) {
            QLog.i("FileManagerUtil<FileAssistant>", 1, "vfs renameFile: src[" + vFSFile.getAbsolutePath() + "] dest[" + vFSFile2.getAbsolutePath() + "]");
        }
        if (vFSFile2.exists()) {
            z16 = vFSFile2.delete();
            QLog.e("FileManagerUtil<FileAssistant>", 1, "vfs rename, delete result[" + z16 + "]");
        } else {
            z16 = true;
        }
        if (z16) {
            boolean renameTo = vFSFile.renameTo(vFSFile2);
            QLog.e("FileManagerUtil<FileAssistant>", 1, "vfs rename, rename result[" + renameTo + "]");
            return renameTo;
        }
        return z16;
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class d implements FMDialogUtil.c {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ FileManagerEntity f209275a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ BaseQQAppInterface f209276b;

        d(FileManagerEntity fileManagerEntity, BaseQQAppInterface baseQQAppInterface) {
            this.f209275a = fileManagerEntity;
            this.f209276b = baseQQAppInterface;
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void b() {
            QQFileManagerUtilImpl.i0(this.f209275a.nSessionId);
            ((IQQFileTempUtils) QRoute.api(IQQFileTempUtils.class)).resumeByFileManagerEngine(this.f209276b, this.f209275a.nSessionId);
        }

        @Override // com.tencent.mobileqq.filemanager.util.FMDialogUtil.c
        public void a() {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class g implements DialogInterface.OnClickListener {
        g() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
        }
    }

    /* compiled from: P */
    /* loaded from: classes12.dex */
    class c implements w {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ BaseQQAppInterface f209273a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f209274b;

        c(BaseQQAppInterface baseQQAppInterface, int i3) {
            this.f209273a = baseQQAppInterface;
            this.f209274b = i3;
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public String a(String str, int i3, String str2, int i16, String str3, String str4, long j3, long j16, long j17, int i17) {
            return null;
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public long b(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17, long j16, int i18) {
            return QQFileManagerUtilImpl.u2(str, i3, str2, i16, str3, str4, str5, j3, i17, this.f209273a, this.f209274b);
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public long c(String str, int i3, String str2, int i16, String str3, String str4, String str5, long j3, int i17) {
            return b(str, i3, str2, i16, str3, str4, str5, j3, i17, 0L, 0);
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public void e(boolean z16, long j3, int i3, String str, String str2, String str3, String str4) {
            if (QLog.isColorLevel()) {
                QLog.i("FileManagerUtil<FileAssistant>", 1, "getDatalineProcessCallBack->onResult bSuccess[" + z16 + "],nSessionId[" + j3 + "],retCode[" + i3 + "],retMsg[" + str + "],uuid[" + str2 + "],troopUin[" + str3 + "],strNewPath[" + str4 + "]");
            }
            if (i3 != 0) {
                if (TextUtils.isEmpty(str)) {
                    com.tencent.mobileqq.filemanager.util.d.i(BaseApplication.getContext().getString(R.string.b_t));
                } else {
                    com.tencent.mobileqq.filemanager.util.d.i(str);
                }
                z16 = false;
            }
            QQFileManagerUtilImpl.q2(z16, j3, i3, str4, this.f209273a, this.f209274b);
        }

        @Override // com.tencent.mobileqq.filemanager.util.w
        public void d(boolean z16, String str, long j3, int i3, String str2, String str3, String str4) {
        }
    }
}
