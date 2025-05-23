package com.tencent.luggage.wxa.t0;

import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.tencent.ilinkservice.IlinkLiveServiceImpl;
import com.tencent.ilinkservice.IlinkServiceLogImpl;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardServlet;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes8.dex */
public class b {

    /* renamed from: g, reason: collision with root package name */
    public static final Map f140817g;

    /* renamed from: b, reason: collision with root package name */
    public String f140819b;

    /* renamed from: c, reason: collision with root package name */
    public String f140820c;

    /* renamed from: d, reason: collision with root package name */
    public long f140821d;

    /* renamed from: a, reason: collision with root package name */
    public final String f140818a = "IlinkLiveJsapiBridge";

    /* renamed from: e, reason: collision with root package name */
    public d f140822e = new d();

    /* renamed from: f, reason: collision with root package name */
    public Handler f140823f = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends Handler {
        public a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x015a  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x019c A[Catch: JSONException -> 0x01ab, TRY_LEAVE, TryCatch #2 {JSONException -> 0x01ab, blocks: (B:23:0x00ff, B:38:0x0160, B:40:0x016f, B:42:0x017e, B:44:0x018d, B:46:0x019c, B:48:0x0125, B:51:0x0130, B:54:0x013b, B:57:0x0146), top: B:22:0x00ff }] */
        @Override // android.os.Handler
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void handleMessage(Message message) {
            char c16;
            IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "\u5f00\u59cbhandleMessage", new Object[0]);
            Bundle bundle = (Bundle) message.obj;
            int i3 = message.what;
            if (i3 != 0) {
                if (i3 != 1) {
                    switch (i3) {
                        case 10:
                            IlinkLiveServiceImpl.getInstance().InvockJsScript(String.format("typeof WeixinJSBridge !== 'undefined' && WeixinJSBridge.invokeCallbackHandler(%d, %s)", Long.valueOf(bundle.getLong("callbackid")), bundle.getString("param")));
                            return;
                        case 11:
                            IlinkLiveServiceImpl.getInstance().sendTransferRequest(bundle.getLong("callbackid"), bundle.getString("param"));
                            return;
                        case 12:
                            IlinkLiveServiceImpl.getInstance().finderInit(bundle.getLong("callbackid"));
                            return;
                        case 13:
                            IlinkLiveServiceImpl.getInstance().finderLivePrepare(bundle.getLong("callbackid"), bundle.getString("param"));
                            return;
                        case 14:
                            IlinkLiveServiceImpl.getInstance().finderCreateLive(bundle.getLong("callbackid"), bundle.getString("param"));
                            return;
                        case 15:
                            IlinkLiveServiceImpl.getInstance().finderCloseLive(bundle.getLong("callbackid"), bundle.getString("param"));
                            return;
                        case 16:
                            IlinkLiveServiceImpl.getInstance().finderJoinLive(bundle.getLong("callbackid"), bundle.getString("param"));
                            return;
                        case 17:
                            IlinkLiveServiceImpl.getInstance().finderSetAnchorStatus(bundle.getLong("callbackid"), bundle.getString("param"));
                            return;
                        case 18:
                            IlinkServiceLogImpl.getInstance().w("IlinkLiveJsapiBridge", "h5 require to close webview", new Object[0]);
                            IlinkLiveServiceImpl.getInstance().OnRequestCloseWebView();
                            return;
                        case 19:
                            IlinkServiceLogImpl.getInstance().w("IlinkLiveJsapiBridge", "h5 require to hide webview", new Object[0]);
                            IlinkLiveServiceImpl.getInstance().OnRequestHideWebView();
                            return;
                        case 20:
                            try {
                                JSONObject jSONObject = new JSONObject(bundle.getString("param"));
                                String string = jSONObject.getString("level");
                                int hashCode = string.hashCode();
                                if (hashCode != 3237038) {
                                    if (hashCode != 3641990) {
                                        if (hashCode != 95458899) {
                                            if (hashCode == 96784904 && string.equals("error")) {
                                                c16 = 3;
                                                if (c16 == 0) {
                                                    if (c16 != 1) {
                                                        if (c16 != 2) {
                                                            if (c16 != 3) {
                                                                IlinkServiceLogImpl.getInstance().v("H5", jSONObject.getString("msg"), new Object[0]);
                                                                return;
                                                            } else {
                                                                IlinkServiceLogImpl.getInstance().e("H5", jSONObject.getString("msg"), new Object[0]);
                                                                return;
                                                            }
                                                        }
                                                        IlinkServiceLogImpl.getInstance().w("H5", jSONObject.getString("msg"), new Object[0]);
                                                        return;
                                                    }
                                                    IlinkServiceLogImpl.getInstance().i("H5", jSONObject.getString("msg"), new Object[0]);
                                                    return;
                                                }
                                                IlinkServiceLogImpl.getInstance().d("H5", jSONObject.getString("msg"), new Object[0]);
                                                return;
                                            }
                                            c16 = '\uffff';
                                            if (c16 == 0) {
                                            }
                                        } else {
                                            if (string.equals("debug")) {
                                                c16 = 0;
                                                if (c16 == 0) {
                                                }
                                            }
                                            c16 = '\uffff';
                                            if (c16 == 0) {
                                            }
                                        }
                                    } else {
                                        if (string.equals("warn")) {
                                            c16 = 2;
                                            if (c16 == 0) {
                                            }
                                        }
                                        c16 = '\uffff';
                                        if (c16 == 0) {
                                        }
                                    }
                                } else {
                                    if (string.equals("info")) {
                                        c16 = 1;
                                        if (c16 == 0) {
                                        }
                                    }
                                    c16 = '\uffff';
                                    if (c16 == 0) {
                                    }
                                }
                            } catch (JSONException e16) {
                                e16.printStackTrace();
                                return;
                            }
                            break;
                        case 21:
                            if (Settings.canDrawOverlays(IlinkLiveServiceImpl.getInstance().getContext())) {
                                b.this.f140821d = bundle.getLong("callbackid");
                                b.this.k();
                                return;
                            }
                            IlinkServiceLogImpl.getInstance().e("IlinkLiveJsapiBridge", "do not have permision!", new Object[0]);
                            Intent intent = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
                            intent.setData(Uri.parse("package:" + IlinkLiveServiceImpl.getInstance().getContext().getPackageName()));
                            try {
                                IlinkLiveServiceImpl.getInstance().OnStartActivityForResult(intent, 5);
                            } catch (ActivityNotFoundException unused) {
                                Toast.makeText(IlinkLiveServiceImpl.getInstance().getContext(), "\u9700\u8981\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00\u5e94\u7528\u7684\u60ac\u6d6e\u7a97\u6743\u9650", 0).show();
                            }
                            b.this.a();
                            return;
                        case 22:
                            try {
                                String substring = new JSONObject(bundle.getString("param")).getString("localId").substring(22);
                                IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "upload file path: " + substring, new Object[0]);
                                IlinkLiveServiceImpl.getInstance().uploadMediaFile(bundle.getLong("callbackid"), substring);
                                return;
                            } catch (JSONException e17) {
                                e17.printStackTrace();
                                b.this.a(bundle.getLong("callbackid"), "get filepath err");
                                return;
                            }
                        default:
                            IlinkServiceLogImpl.getInstance().e("IlinkLiveJsapiBridge", "unknown msg", new Object[0]);
                            return;
                    }
                } else {
                    IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "Receive login complete:" + bundle.getInt("errcode"), new Object[0]);
                    IlinkLiveServiceImpl.getInstance().OnLoginComplete(bundle.getInt("errcode"), 0, "");
                }
            } else {
                IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "functionname:" + bundle.getString("functionname"), new Object[0]);
                IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "Callbackid:" + bundle.getInt("callbackid"), new Object[0]);
                b.this.b((long) bundle.getInt("callbackid"), "{\"key\":\"hello\"}");
            }
        }
    }

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.t0.b$b, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class DialogInterfaceOnClickListenerC6730b implements DialogInterface.OnClickListener {
        public DialogInterfaceOnClickListenerC6730b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i3) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "default try to callback to js", new Object[0]);
                        b.this.a();
                        return;
                    } else {
                        IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "cancel try to callback to js", new Object[0]);
                        b.this.a();
                        return;
                    }
                }
                IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "pick from gallery", new Object[0]);
                b.this.j();
                return;
            }
            IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "pick from camera", new Object[0]);
            if (ContextCompat.checkSelfPermission(IlinkLiveServiceImpl.getInstance().getContext(), QQPermissionConstants.Permission.CAMERA) == 0) {
                b.this.i();
            } else {
                IlinkLiveServiceImpl.getInstance().OnRequestPermission(new String[]{QQPermissionConstants.Permission.CAMERA}, 4);
                b.this.a();
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class c implements DialogInterface.OnCancelListener {
        public c() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", "cancel with touch outside!", new Object[0]);
            b.this.a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class d {
        public d() {
        }

        @JavascriptInterface
        public void invokeHandler(String str, String str2, long j3) {
            Log.d("IlinkLiveJsapiBridge", "invokeHandler: " + str + ", para: " + str2 + ", callbackid: " + j3);
            if (b.f140817g.containsKey(str)) {
                Message message = new Message();
                message.what = ((Integer) b.f140817g.get(str)).intValue();
                Bundle bundle = new Bundle();
                bundle.putString("param", str2);
                bundle.putLong("callbackid", j3);
                message.obj = bundle;
                b.this.f140823f.sendMessage(message);
                return;
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(CheckForwardServlet.KEY_ERR_CODE, -1);
                jSONObject.put("err_msg", "Not supported this function yet:" + str);
            } catch (JSONException e16) {
                e16.printStackTrace();
            }
            b.this.b(j3, jSONObject.toString());
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f140817g = hashMap;
        hashMap.put("finderH5ExtTransfer", 11);
        hashMap.put("finderH5Init", 12);
        hashMap.put("finderH5PrepareLive", 13);
        hashMap.put("finderH5CreateLive", 14);
        hashMap.put("finderH5CloseLive", 15);
        hashMap.put("finderH5JoinLive", 16);
        hashMap.put("finderH5SetAnchorStatus", 17);
        hashMap.put("finderH5CloseWebView", 18);
        hashMap.put("finderH5HideWebView", 19);
        hashMap.put("log", 20);
        hashMap.put("chooseImage", 21);
        hashMap.put("uploadMediaFile", 22);
    }

    public String c() {
        return new String(IlinkLiveServiceImpl.getInstance().getJsBridgeData());
    }

    public final String e() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES) + File.separator + new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_SSS").format(new Date()) + ".jpg";
    }

    public final String f() {
        String sdkdir = IlinkLiveServiceImpl.getInstance().getSdkdir();
        String format = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_SSS").format(new Date());
        File file = new File(sdkdir, "tmppic");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.toString() + File.separator + format + ".jpg";
    }

    public void g(long j3, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onFinderLivePrepare", new Object[0]);
        b(j3, str);
    }

    public void h(long j3, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onFinderSetAnchorStatusComplete", new Object[0]);
        b(j3, str);
    }

    public void i() {
        Uri fromFile;
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        try {
            this.f140819b = f();
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(IlinkLiveServiceImpl.getInstance().getContext(), IlinkLiveServiceImpl.getInstance().getContext().getPackageName() + ".fileprovider", new File(this.f140819b));
                intent.setFlags(1);
                intent.setFlags(2);
                intent.addFlags(64);
            } else {
                fromFile = Uri.fromFile(new File(this.f140819b));
            }
            intent.putExtra("output", fromFile);
            IlinkLiveServiceImpl.getInstance().OnStartActivityForResult(intent, 1);
        } catch (IOException e16) {
            e16.printStackTrace();
            IlinkServiceLogImpl.getInstance().e("IlinkLiveJsapiBridge", "Can not create image file!", new Object[0]);
            a();
        }
    }

    public void j() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        IlinkLiveServiceImpl.getInstance().OnStartActivityForResult(intent, 2);
    }

    public void k() {
        AlertDialog.Builder builder = new AlertDialog.Builder(IlinkLiveServiceImpl.getInstance().getContext());
        builder.setItems(new String[]{"\u62cd\u7167", "\u4ece\u76f8\u518c\u9009\u62e9", "\u53d6\u6d88"}, new DialogInterfaceOnClickListenerC6730b());
        AlertDialog create = builder.create();
        if (Build.VERSION.SDK_INT >= 26) {
            create.getWindow().setType(2038);
        } else {
            create.getWindow().setType(2003);
        }
        create.setOnCancelListener(new c());
        create.show();
    }

    public d b() {
        return this.f140822e;
    }

    public void c(long j3, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onFinderCloseLiveComplete", new Object[0]);
        b(j3, str);
    }

    public void d(long j3, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onFinderCreateLiveComplete", new Object[0]);
        b(j3, str);
    }

    public void b(long j3, String str) {
        Message message = new Message();
        message.what = 10;
        Bundle bundle = new Bundle();
        bundle.putLong("callbackid", j3);
        bundle.putString("param", str);
        message.obj = bundle;
        this.f140823f.sendMessage(message);
    }

    public void e(long j3, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onFinderInit", new Object[0]);
        b(j3, str);
    }

    public void g() {
        IlinkServiceLogImpl.getInstance().v("IlinkLiveJsapiBridge", "onOnLiveStartEvent", new Object[0]);
        IlinkLiveServiceImpl.getInstance().OnLiveStart();
    }

    public void h() {
        IlinkServiceLogImpl.getInstance().v("IlinkLiveJsapiBridge", "onOnLiveStopEvent", new Object[0]);
        IlinkLiveServiceImpl.getInstance().OnLiveStop();
    }

    public void a(Uri uri) {
        try {
            this.f140820c = e();
            Intent intent = new Intent("com.android.camera.action.CROP");
            Uri fromFile = Uri.fromFile(new File(this.f140820c));
            if (Build.VERSION.SDK_INT >= 24) {
                intent.setFlags(2);
                intent.setFlags(1);
            }
            IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "crop to save: " + this.f140820c, new Object[0]);
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("aspectX", 768);
            intent.putExtra("aspectY", 1024);
            intent.putExtra("outputX", 768);
            intent.putExtra("outputY", 1024);
            intent.putExtra("scale", true);
            intent.putExtra("return-data", false);
            intent.putExtra("output", fromFile);
            intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
            intent.putExtra("noFaceDetection", false);
            IlinkLiveServiceImpl.getInstance().OnStartActivityForResult(intent, 3);
        } catch (IOException e16) {
            e16.printStackTrace();
            a();
        }
    }

    public void j(long j3, String str) {
        IlinkServiceLogImpl.getInstance().v("IlinkLiveJsapiBridge", "onUploadMediaFileComplete", new Object[0]);
        b(j3, str);
    }

    public void f(long j3, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onFinderJoinLiveComplete", new Object[0]);
        b(j3, str);
    }

    public void b(long j3, int i3) {
        Message message = new Message();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putInt("errcode", i3);
        message.obj = bundle;
        this.f140823f.sendMessage(message);
    }

    public void i(long j3, String str) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onSendTransferRequestComplete", new Object[0]);
        b(j3, str);
    }

    public void a(String str, String str2) {
        if (new File(str).exists()) {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    fileOutputStream.close();
                    return;
                }
            }
        } else {
            IlinkServiceLogImpl.getInstance().e("IlinkLiveJsapiBridge", "old file not exit: " + str, new Object[0]);
        }
    }

    public final void a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("localIds", new JSONArray());
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        b(this.f140821d, jSONObject.toString());
    }

    public final void a(long j3, String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("err_msg", str);
            jSONObject.put("mediaUrl", "");
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        b(j3, jSONObject.toString());
    }

    public void a(int i3, int i16, Intent intent) {
        Uri fromFile;
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "Receive onActivityResult: " + i3 + ", resultcode: " + i16, new Object[0]);
        if (i3 == 1 && i16 == -1) {
            if (Build.VERSION.SDK_INT >= 24) {
                fromFile = FileProvider.getUriForFile(IlinkLiveServiceImpl.getInstance().getContext(), IlinkLiveServiceImpl.getInstance().getContext().getPackageName() + ".fileprovider", new File(this.f140819b));
            } else {
                fromFile = Uri.fromFile(new File(this.f140819b));
            }
            a(fromFile);
            return;
        }
        if (i3 == 2 && i16 == -1 && intent != null) {
            Uri data = intent.getData();
            IlinkServiceLogImpl.getInstance().d("IlinkLiveJsapiBridge", data.toString(), new Object[0]);
            a(data);
            return;
        }
        if (i3 != 3) {
            if (i3 == 4) {
                IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "REQUEST_CAMERA_PERMISSION Callback resultcode:" + i16, new Object[0]);
                return;
            }
            if (i3 == 5) {
                IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "REQUEST_OVERLAY_PERMISSION Callback resultcode:" + i16, new Object[0]);
                return;
            }
            return;
        }
        try {
            String f16 = f();
            IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "copy crop file:" + this.f140820c + ", to self path:" + f16, new Object[0]);
            a(this.f140820c, f16);
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONArray.mo162put("https://ilinklivelocal" + f16);
            jSONObject.put("localIds", jSONArray);
            b(this.f140821d, jSONObject.toString());
        } catch (IOException | JSONException unused) {
            a();
        }
    }

    public void a(int i3, String[] strArr, int[] iArr) {
        IlinkServiceLogImpl.getInstance().i("IlinkLiveJsapiBridge", "onReceiveRequestPermissionsResult: " + i3 + ", permissions: " + strArr, new Object[0]);
    }

    public void a(long j3, int i3) {
        Message message = new Message();
        message.what = 1;
        Bundle bundle = new Bundle();
        bundle.putInt("errcode", i3);
        message.obj = bundle;
        this.f140823f.sendMessage(message);
    }

    public void a(String str) {
        IlinkServiceLogImpl.getInstance().v("IlinkLiveJsapiBridge", "onRtmpUrlUpdateEvent:" + str, new Object[0]);
        IlinkLiveServiceImpl.getInstance().OnLiveRtmpUrlUpdate(str);
    }
}
