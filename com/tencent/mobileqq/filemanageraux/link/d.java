package com.tencent.mobileqq.filemanageraux.link;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.qzone.preview.service.base.PictureConst;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.biz.qrcode.util.h;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mm.vfs.VFSFileOutputStream;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.l;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import cooperation.qzone.QZoneHelper;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

/* compiled from: P */
/* loaded from: classes12.dex */
final class d implements Handler.Callback {
    static IPatchRedirector $redirector_;
    private volatile boolean C;

    /* renamed from: d, reason: collision with root package name */
    private final a f209642d;

    /* renamed from: e, reason: collision with root package name */
    private final View f209643e;

    /* renamed from: f, reason: collision with root package name */
    private final MqqHandler f209644f;

    /* renamed from: h, reason: collision with root package name */
    private final MqqHandler f209645h;

    /* renamed from: i, reason: collision with root package name */
    private QQProgressDialog f209646i;

    /* renamed from: m, reason: collision with root package name */
    private Bitmap f209647m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar, ViewGroup viewGroup) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) aVar, (Object) viewGroup);
            return;
        }
        this.f209642d = aVar;
        View inflate = aVar.getBaseActivity().getLayoutInflater().inflate(R.layout.abk, viewGroup, false);
        this.f209643e = inflate;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        inflate.measure(makeMeasureSpec, makeMeasureSpec);
        TextView textView = (TextView) inflate.findViewById(R.id.cy6);
        TextView textView2 = (TextView) inflate.findViewById(R.id.cx9);
        AsyncImageView asyncImageView = (AsyncImageView) inflate.findViewById(R.id.cxy);
        String fileName = aVar.getFileName();
        int fileType = aVar.getFileType();
        textView.setText(FileManagerUtil.handleLongFileName(fileName, true, textView.getMeasuredWidth(), textView.getPaint(), 2));
        textView2.setText(q.g(aVar.getFileSize()));
        asyncImageView.setImageResource(FileManagerUtil.getFileIconResId(fileName));
        if (fileType == 5 || fileType == 0) {
            String filePath = aVar.getFilePath();
            if (q.f(filePath)) {
                if (fileType == 5) {
                    asyncImageView.setApkIconAsyncImage(filePath);
                } else {
                    asyncImageView.setAsyncImage(filePath);
                }
            }
        }
        asyncImageView.setSupportMaskView(false);
        ((AsyncImageView) inflate.findViewById(R.id.h0d)).setSupportMaskView(false);
        inflate.measure(makeMeasureSpec, makeMeasureSpec);
        inflate.layout(0, 0, inflate.getMeasuredWidth(), inflate.getMeasuredHeight());
        this.f209644f = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
        this.f209645h = new MqqWeakReferenceHandler(ThreadManagerV2.getFileThreadLooper(), this, false);
    }

    private void c(Object[] objArr) {
        String h16;
        if (objArr != null && objArr.length >= 3) {
            ShareActionSheetBuilder.ActionSheetItem actionSheetItem = (ShareActionSheetBuilder.ActionSheetItem) objArr[0];
            Bitmap bitmap = (Bitmap) objArr[1];
            if (((Boolean) objArr[2]).booleanValue()) {
                h16 = i(bitmap);
            } else {
                h16 = h(bitmap);
            }
            Message message = new Message();
            message.what = 2;
            message.obj = new Object[]{actionSheetItem, bitmap, h16};
            this.f209644f.sendMessage(message);
            return;
        }
        throw new IllegalArgumentException("handleSaveBitmap: args are invalid");
    }

    private void d(Object[] objArr) {
        if (objArr != null && objArr.length >= 3) {
            l((ShareActionSheetBuilder.ActionSheetItem) objArr[0], (Bitmap) objArr[1], (String) objArr[2]);
            return;
        }
        throw new IllegalArgumentException("handleShareRelay: args are invalid");
    }

    private Bitmap e(Bitmap bitmap, int i3, String str) {
        String str2;
        int i16;
        if (bitmap == null) {
            return null;
        }
        AsyncImageView asyncImageView = (AsyncImageView) this.f209643e.findViewById(R.id.h0d);
        asyncImageView.setImageBitmap(bitmap);
        TextView textView = (TextView) this.f209643e.findViewById(R.id.f166654d10);
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        Object[] objArr = new Object[1];
        if (TextUtils.isEmpty(str)) {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(BaseApplicationImpl.sApplication.getString(R.string.w3z));
            sb5.append(":");
            BaseApplicationImpl baseApplicationImpl2 = BaseApplicationImpl.sApplication;
            if (i3 == 1) {
                i16 = R.string.vv7;
            } else if (i3 == 2) {
                i16 = R.string.vv6;
            } else {
                i16 = R.string.vv8;
            }
            sb5.append(baseApplicationImpl2.getString(i16));
            str2 = sb5.toString();
        } else {
            str2 = BaseApplicationImpl.sApplication.getString(R.string.vv9) + ":" + str;
        }
        objArr[0] = str2;
        textView.setText(baseApplicationImpl.getString(R.string.f171449vv0, objArr));
        try {
            Bitmap createBitmap = Bitmap.createBitmap(this.f209643e.getMeasuredWidth(), this.f209643e.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
            this.f209643e.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Throwable th5) {
            try {
                QLog.e("WeiyunShareQrController<FileAssistant>", 2, "mergeQrPanel error", th5);
                return null;
            } finally {
                asyncImageView.setImageDrawable(null);
            }
        }
    }

    private void g() {
        Bitmap bitmap = this.f209647m;
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.f209647m.recycle();
            }
            this.f209647m = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x00af, code lost:
    
        if (r4 == null) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String h(Bitmap bitmap) {
        BufferedOutputStream bufferedOutputStream;
        BufferedOutputStream bufferedOutputStream2 = null;
        r2 = null;
        String str = null;
        if (bitmap == null || bitmap.isRecycled()) {
            return null;
        }
        VFSFile vFSFile = new VFSFile(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_IMG_SAVE));
        vFSFile.mkdirs();
        if (!vFSFile.canWrite()) {
            return null;
        }
        String l3 = Long.toString(System.currentTimeMillis());
        VFSFile vFSFile2 = new VFSFile(vFSFile.getAbsolutePath() + "/qrcode_" + System.currentTimeMillis() + ".jpg");
        int i3 = 2;
        while (vFSFile2.exists() && i3 < Integer.MAX_VALUE) {
            i3++;
            vFSFile2 = new VFSFile(vFSFile.getAbsolutePath() + "/qrcode_" + l3 + "(" + i3 + ").jpg");
        }
        boolean z16 = false;
        try {
            bufferedOutputStream = new BufferedOutputStream(new VFSFileOutputStream(vFSFile2));
            try {
                z16 = bitmap.compress(Bitmap.CompressFormat.PNG, 100, bufferedOutputStream);
            } catch (OutOfMemoryError e16) {
                e = e16;
                bufferedOutputStream2 = bufferedOutputStream;
                try {
                    QLog.w("WeiyunShareQrController<FileAssistant>", 2, "saveFile error", e);
                    if (bufferedOutputStream2 != null) {
                        try {
                            bufferedOutputStream2.close();
                        } catch (Throwable unused) {
                        }
                    }
                    str = "";
                    if (z16) {
                    }
                    String absolutePath = vFSFile2.getAbsolutePath();
                    l.a(absolutePath);
                    return absolutePath;
                } catch (Throwable th5) {
                    th = th5;
                    bufferedOutputStream = bufferedOutputStream2;
                    if (bufferedOutputStream != null) {
                    }
                    throw th;
                }
            } catch (Throwable th6) {
                th = th6;
                try {
                    QLog.e("WeiyunShareQrController<FileAssistant>", 2, "saveFile error", th);
                } catch (Throwable th7) {
                    th = th7;
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
            }
        } catch (OutOfMemoryError e17) {
            e = e17;
        } catch (Throwable th8) {
            th = th8;
            bufferedOutputStream = null;
        }
        try {
            bufferedOutputStream.close();
        } catch (Throwable unused3) {
            if (z16 && vFSFile2.exists()) {
                vFSFile2.delete();
                return str;
            }
            String absolutePath2 = vFSFile2.getAbsolutePath();
            l.a(absolutePath2);
            return absolutePath2;
        }
    }

    private static String i(Bitmap bitmap) {
        try {
            return h.P(BaseApplicationImpl.sApplication, "qfile_qrcode_share_" + System.currentTimeMillis() + ".png", bitmap);
        } catch (OutOfMemoryError e16) {
            QLog.w("WeiyunShareQrController<FileAssistant>", 2, "saveTemp error", e16);
            return "";
        }
    }

    private void l(ShareActionSheetBuilder.ActionSheetItem actionSheetItem, Bitmap bitmap, String str) {
        int i3;
        int i16;
        if (actionSheetItem == null) {
            return;
        }
        int i17 = actionSheetItem.action;
        BaseActivity baseActivity = this.f209642d.getBaseActivity();
        if (baseActivity != null && !baseActivity.isFinishing()) {
            QQProgressDialog qQProgressDialog = this.f209646i;
            if (qQProgressDialog != null) {
                qQProgressDialog.dismiss();
            }
            if ("".equals(str)) {
                b.j(1, R.string.dzy, true);
                return;
            }
            if (str == null) {
                if (i17 == 39) {
                    i16 = R.string.g2q;
                } else {
                    i16 = R.string.dzx;
                }
                b.j(1, i16, true);
                return;
            }
            if (i17 != 2) {
                if (i17 != 3) {
                    if (i17 != 9 && i17 != 10) {
                        if (i17 != 39) {
                            if (i17 == 72) {
                                Bundle bundle = new Bundle();
                                bundle.putInt(PictureConst.KEY_REQ_FOR_RECENT_OR_VIDEO, 1);
                                bundle.putInt("key_direct_show_uin_type", actionSheetItem.uinType);
                                bundle.putString("key_direct_show_uin", actionSheetItem.uin);
                                Intent intent = new Intent();
                                intent.putExtra("isFromShare", true);
                                intent.putExtra("forward_type", 1);
                                intent.putExtra(AppConstants.Key.FORWARD_FILEPATH, str);
                                intent.putExtra(AppConstants.Key.FORWARD_THUMB, str);
                                intent.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
                                intent.putExtra(AppConstants.Key.FORWARD_EXTRA, str);
                                intent.putExtras(bundle);
                                ForwardBaseOption.startForwardActivityForResult(baseActivity, intent, (Class<?>) ForwardRecentTranslucentActivity.class, 1, -1, "");
                                return;
                            }
                            return;
                        }
                        Intent intent2 = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
                        intent2.setData(Uri.parse("file://" + str));
                        baseActivity.sendBroadcast(intent2);
                        b.k(2, baseActivity.getString(R.string.g2r, str), true);
                        return;
                    }
                    String Ce = this.f209642d.Ce();
                    WXShareHelper b06 = WXShareHelper.b0();
                    if (i17 == 9) {
                        i3 = 0;
                    } else {
                        i3 = 1;
                    }
                    b06.x0(str, bitmap, i3, true, Ce);
                    return;
                }
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                AppInterface appInterface = baseActivity.getAppInterface();
                userInfo.qzone_uin = appInterface.getAccount();
                if (appInterface instanceof VideoAppInterface) {
                    userInfo.nickname = ((VideoAppInterface) appInterface).G(0, appInterface.getCurrentAccountUin(), null);
                } else {
                    userInfo.nickname = null;
                }
                QZoneHelper.forwardToPublishMood(baseActivity, userInfo, str, baseActivity.getString(R.string.b1o), baseActivity.getString(R.string.f171449vv0, ""), 2);
                return;
            }
            Intent intent3 = new Intent();
            intent3.putExtra("isFromShare", true);
            intent3.putExtra("forward_type", 1);
            intent3.putExtra(AppConstants.Key.FORWARD_FILEPATH, str);
            intent3.putExtra(AppConstants.Key.FORWARD_THUMB, str);
            intent3.putExtra(AppConstants.Key.FORWARD_URLDRAWABLE_BIG_URL, str);
            intent3.putExtra(AppConstants.Key.FORWARD_EXTRA, str);
            ForwardBaseOption.startForwardActivityForResult(baseActivity, intent3, 1, -1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ShareActionSheetBuilder.ActionSheetItem> a(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ShareActionSheetBuilder.ActionSheetItem> b(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
        arrayList.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void f() {
        this.C = true;
        g();
        QQProgressDialog qQProgressDialog = this.f209646i;
        if (qQProgressDialog != null) {
            qQProgressDialog.dismiss();
            this.f209646i = null;
        }
        this.f209644f.removeCallbacksAndMessages(null);
        this.f209645h.removeCallbacksAndMessages(null);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) message)).booleanValue();
        }
        if (this.C) {
            return false;
        }
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 == 2) {
                d((Object[]) message.obj);
            }
        } else {
            c((Object[]) message.obj);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean j(Bitmap bitmap, int i3, String str) {
        Bitmap e16 = e(bitmap, i3, str);
        if (e16 == null) {
            b.k(1, BaseApplicationImpl.sApplication.getResources().getString(R.string.vuv, -2), true);
            return false;
        }
        this.f209642d.s9(e16);
        if (e16 != this.f209647m) {
            g();
        }
        this.f209647m = e16;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void k(ShareActionSheetBuilder.ActionSheetItem actionSheetItem) {
        if (actionSheetItem == null) {
            return;
        }
        int i3 = actionSheetItem.action;
        boolean z16 = false;
        if (i3 != 39 && !NetworkUtil.isNetSupport(this.f209642d.getBaseActivity())) {
            b.j(0, R.string.b3j, false);
            if (QLog.isColorLevel()) {
                QLog.i("WeiyunShareQrController<FileAssistant>", 2, "toShare: net is not supported");
                return;
            }
            return;
        }
        if (i3 == 2 || i3 == 3 || i3 == 9 || i3 == 10 || i3 == 72 || i3 == 39) {
            if (this.f209646i == null) {
                QQProgressDialog qQProgressDialog = new QQProgressDialog(this.f209642d.getBaseActivity());
                this.f209646i = qQProgressDialog;
                qQProgressDialog.setMessage(R.string.cpr);
            }
            if (!this.f209646i.isShowing()) {
                this.f209646i.show();
            }
            Message message = new Message();
            message.what = 1;
            Object[] objArr = new Object[3];
            objArr[0] = actionSheetItem;
            objArr[1] = this.f209647m;
            if (i3 != 39) {
                z16 = true;
            }
            objArr[2] = Boolean.valueOf(z16);
            message.obj = objArr;
            this.f209645h.sendMessage(message);
        }
    }
}
