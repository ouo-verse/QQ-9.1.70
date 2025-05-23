package com.tencent.mobileqq.haoliyou;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.Pair;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.libra.util.ImageContentType;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.forward.ForwardFileBaseOption;
import com.tencent.mobileqq.haoliyou.UriParserPathHelper;
import com.tencent.mobileqq.haoliyou.orion.ZhuoXusManager;
import com.tencent.mobileqq.haoliyou.sso.CheckForwardManager;
import com.tencent.mobileqq.haoliyou.sso.OnCheckShareListener;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.bg;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$AppFileMsgInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$CheckShareExtensionReq;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$ImgInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$TextInfo;
import tencent.im.oidb.cmd0xc78.oidb_cmd0xc78$VideoInfo;

/* compiled from: P */
/* loaded from: classes7.dex */
public class JumpForwardSecurityCheck {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "CheckForward.Security";
    public QBaseActivity mActivity;
    UriParserPathHelper mFilePathHelper;
    public WeakReference<OnCheckShareListener> mListener;
    public HashSet<String> pkgs;

    public JumpForwardSecurityCheck(QBaseActivity qBaseActivity, OnCheckShareListener onCheckShareListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qBaseActivity, (Object) onCheckShareListener);
            return;
        }
        this.mActivity = qBaseActivity;
        this.pkgs = bg.b(qBaseActivity);
        this.mListener = new WeakReference<>(onCheckShareListener);
    }

    private ArrayList<Uri> getMultiUriFromExtra(Bundle bundle) {
        Object obj = bundle.get("android.intent.extra.STREAM");
        if (obj != null && (obj instanceof ArrayList)) {
            return (ArrayList) obj;
        }
        return null;
    }

    private ArrayList<Uri> getUriListFromExtra(Intent intent, String str) {
        Bundle extras;
        String type;
        Uri data;
        try {
            extras = intent.getExtras();
            type = intent.getType();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "getUriListFromExtra exception=", th5);
        }
        if (!TextUtils.isEmpty(type) && !TextUtils.isEmpty(str) && extras != null) {
            ArrayList<Uri> arrayList = new ArrayList<>();
            if (!str.equals("android.intent.action.SEND") && !str.equals("android.intent.action.SEND_MULTIPLE")) {
                if (!str.equals(CommonConstant.ACTION.HWID_SCHEME_URL) || (data = intent.getData()) == null) {
                    return null;
                }
                arrayList.add(data);
                return arrayList;
            }
            if ((type.startsWith("text/") && !extras.containsKey("android.intent.extra.STREAM")) || type.startsWith("message/")) {
                return null;
            }
            if (type.startsWith(ImageContentType.IMAGE_PREFIX)) {
                if (str.equals("android.intent.action.SEND")) {
                    Uri uriFromExtra = getUriFromExtra(extras);
                    if (uriFromExtra != null) {
                        arrayList.add(uriFromExtra);
                        return arrayList;
                    }
                } else {
                    ArrayList<Uri> multiUriFromExtra = getMultiUriFromExtra(extras);
                    if (multiUriFromExtra != null && multiUriFromExtra.size() > 0) {
                        return multiUriFromExtra;
                    }
                }
            } else if (str.equals("android.intent.action.SEND")) {
                Uri uriFromExtra2 = getUriFromExtra(extras);
                if (uriFromExtra2 != null) {
                    arrayList.add(uriFromExtra2);
                    return arrayList;
                }
            } else {
                ArrayList<Uri> multiUriFromExtra2 = getMultiUriFromExtra(extras);
                if (multiUriFromExtra2 != null && multiUriFromExtra2.size() > 0) {
                    return multiUriFromExtra2;
                }
            }
            return null;
        }
        return null;
    }

    private boolean prepareFileInfoAndReq(Uri uri, int i3, String str) {
        if (this.mFilePathHelper == null) {
            this.mFilePathHelper = new UriParserPathHelper(this.mActivity, false, new UriParserPathHelper.IOnFileCopyFinishListener(i3, str) { // from class: com.tencent.mobileqq.haoliyou.JumpForwardSecurityCheck.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String val$action;
                final /* synthetic */ int val$type;

                {
                    this.val$type = i3;
                    this.val$action = str;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, this, JumpForwardSecurityCheck.this, Integer.valueOf(i3), str);
                    }
                }

                @Override // com.tencent.mobileqq.haoliyou.UriParserPathHelper.IOnFileCopyFinishListener
                public void onFaild(Uri uri2) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                        iPatchRedirector.redirect((short) 3, (Object) this, (Object) uri2);
                        return;
                    }
                    QLog.e(JumpForwardSecurityCheck.TAG, 1, "system share.prepareFileInfoAndReq : onFaild= " + uri2);
                    JumpForwardSecurityCheck.this.mActivity.finish();
                }

                @Override // com.tencent.mobileqq.haoliyou.UriParserPathHelper.IOnFileCopyFinishListener
                public void onFinish(String str2, String str3, long j3) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, this, str2, str3, Long.valueOf(j3));
                        return;
                    }
                    QLog.d(JumpForwardSecurityCheck.TAG, 1, "system share.prepareFileInfoAndReq : onFinish= " + str2);
                    try {
                        int i16 = this.val$type;
                        if (i16 == 2) {
                            ArrayList<String> arrayList = new ArrayList<>();
                            arrayList.add(str2);
                            JumpForwardSecurityCheck.this.sendCheckImgShareReq(arrayList, this.val$action);
                        } else if (i16 == 4) {
                            ArrayList<String> arrayList2 = new ArrayList<>();
                            arrayList2.add(str2);
                            JumpForwardSecurityCheck.this.sendCheckFileShareReq(arrayList2, this.val$action);
                        } else if (i16 == 3) {
                            JumpForwardSecurityCheck.this.sendCheckVideoShareReq(str2, this.val$action);
                        }
                    } catch (Throwable th5) {
                        QLog.e(JumpForwardSecurityCheck.TAG, 1, "system share.prepareFileInfoAndReq exception=", th5);
                    }
                }
            });
        }
        String pathFromUri = this.mFilePathHelper.getPathFromUri(uri, true, false);
        QLog.d(TAG, 1, "system share.prepareFileInfoAndReq : uri= " + uri + ", path= " + pathFromUri);
        if (TextUtils.isEmpty(pathFromUri)) {
            return false;
        }
        UriParserPathHelper uriParserPathHelper = this.mFilePathHelper;
        if (uriParserPathHelper.waiting || uriParserPathHelper.isCopying()) {
            return true;
        }
        File file = new File(pathFromUri);
        long length = file.length();
        UriParserPathHelper uriParserPathHelper2 = this.mFilePathHelper;
        if (!uriParserPathHelper2.waiting && !uriParserPathHelper2.isCopying() && length == 0) {
            return false;
        }
        if (!ForwardFileBaseOption.v(pathFromUri) && file.canRead()) {
            if (i3 == 2) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add(pathFromUri);
                sendCheckImgShareReq(arrayList, str);
            } else if (i3 == 4) {
                ArrayList<String> arrayList2 = new ArrayList<>();
                arrayList2.add(pathFromUri);
                sendCheckFileShareReq(arrayList2, str);
            } else if (i3 == 3) {
                sendCheckVideoShareReq(pathFromUri, str);
            }
            return true;
        }
        QLog.d(TAG, 1, "system share.prepareFileInfoAndReq : can not Read");
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00c0 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x008c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean checkContainsPrivateUri(Intent intent) {
        String action;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent)).booleanValue();
        }
        if (intent == null) {
            return false;
        }
        try {
            action = intent.getAction();
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "checkContainsPrivateUri exception ", th5);
        }
        if (action == null) {
            return false;
        }
        boolean isSwitchOn = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("opensdk_file_forward_private_check_switch", false);
        QLog.i(TAG, 1, "checkContainsPrivateUri switch: " + isSwitchOn);
        if (!isSwitchOn) {
            return false;
        }
        QBaseActivity qBaseActivity = this.mActivity;
        ArrayList<Uri> uriListFromExtra = getUriListFromExtra(intent, action);
        if (uriListFromExtra != null && !uriListFromExtra.isEmpty()) {
            if (qBaseActivity == null) {
                QLog.e(TAG, 1, "checkContainsPrivateUri context is null");
                return false;
            }
            File filesDir = qBaseActivity.getFilesDir();
            File cacheDir = qBaseActivity.getCacheDir();
            if (filesDir != null && cacheDir != null) {
                String path = filesDir.getPath();
                String path2 = cacheDir.getPath();
                if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(path2)) {
                    Iterator<Uri> it = uriListFromExtra.iterator();
                    while (it.hasNext()) {
                        Uri next = it.next();
                        if (next == null) {
                            QLog.e(TAG, 1, "checkContainsPrivateUri uri is null");
                        } else {
                            String path3 = next.getPath();
                            if (path3 != null && !path3.isEmpty()) {
                                if (!path3.startsWith(path) && !path3.startsWith(path2)) {
                                    z16 = false;
                                    if (!z16) {
                                        QLog.e(TAG, 1, "checkContainsPrivateUri true: " + next);
                                        return true;
                                    }
                                }
                                z16 = true;
                                if (!z16) {
                                }
                            }
                            QLog.e(TAG, 1, "checkContainsPrivateUri path: " + path3);
                        }
                    }
                    return false;
                }
                QLog.e(TAG, 1, "checkContainsPrivateUri path error. filesDir: " + path + ", cacheDir: " + path2);
                return false;
            }
            QLog.e(TAG, 1, "checkContainsPrivateUri dir is null");
            return false;
        }
        QLog.e(TAG, 1, "checkContainsPrivateUri uriList is null or empty");
        return false;
    }

    public ArrayList<String> getMultiFilePathFromExtra(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ArrayList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) bundle);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Object obj = bundle.get("android.intent.extra.STREAM");
        if (obj != null && (obj instanceof ArrayList)) {
            ArrayList arrayList2 = (ArrayList) obj;
            UriParserPathHelper uriParserPathHelper = new UriParserPathHelper(this.mActivity, false, null);
            for (int i3 = 0; i3 < arrayList2.size(); i3++) {
                String pathFromUri = uriParserPathHelper.getPathFromUri((Uri) arrayList2.get(i3));
                if (!TextUtils.isEmpty(pathFromUri)) {
                    arrayList.add(pathFromUri);
                }
            }
        }
        return arrayList;
    }

    public Uri getUriFromExtra(Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Uri) iPatchRedirector.redirect((short) 3, (Object) this, (Object) bundle);
        }
        Object obj = bundle.get("android.intent.extra.STREAM");
        if (obj != null) {
            if (obj instanceof Uri) {
                return (Uri) obj;
            }
            if (obj instanceof String) {
                return Uri.parse((String) obj);
            }
        }
        return null;
    }

    public boolean prepareSecurityCheck(Intent intent, String str) {
        Uri data;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) str)).booleanValue();
        }
        try {
        } catch (Throwable th5) {
            QLog.e(TAG, 1, "system share.prepareSecurityCheck exception=", th5);
        }
        if (!ZhuoXusManager.instance().needReportSystemShareInfo()) {
            return false;
        }
        Bundle extras = intent.getExtras();
        String type = intent.getType();
        if (!TextUtils.isEmpty(type) && !TextUtils.isEmpty(str)) {
            int i3 = 3;
            if (!str.equals("android.intent.action.SEND") && !str.equals("android.intent.action.SEND_MULTIPLE")) {
                if (!str.equals(CommonConstant.ACTION.HWID_SCHEME_URL) || (data = intent.getData()) == null) {
                    return false;
                }
                if (type != null && type.startsWith(ImageContentType.IMAGE_PREFIX)) {
                    if (prepareFileInfoAndReq(data, 2, str)) {
                        return true;
                    }
                } else {
                    if (!type.startsWith("video/")) {
                        i3 = 4;
                    }
                    if (prepareFileInfoAndReq(data, i3, str)) {
                        return true;
                    }
                }
                return false;
            }
            if (type.startsWith("text/") && !extras.containsKey("android.intent.extra.STREAM")) {
                sendCheckTextShareReq(extras.getString("android.intent.extra.TEXT"));
                return true;
            }
            if (type.startsWith("message/")) {
                SpannableString spannableString = (SpannableString) extras.get("android.intent.extra.TEXT");
                if (spannableString != null) {
                    sendCheckTextShareReq(spannableString.toString());
                    return true;
                }
            } else if (type.startsWith(ImageContentType.IMAGE_PREFIX)) {
                if (str.equals("android.intent.action.SEND")) {
                    Uri uriFromExtra = getUriFromExtra(extras);
                    if (uriFromExtra != null && prepareFileInfoAndReq(uriFromExtra, 2, str)) {
                        return true;
                    }
                } else {
                    ArrayList<String> multiFilePathFromExtra = getMultiFilePathFromExtra(extras);
                    if (multiFilePathFromExtra != null && multiFilePathFromExtra.size() > 0) {
                        sendCheckImgShareReq(multiFilePathFromExtra, str);
                        return true;
                    }
                }
            } else if (str.equals("android.intent.action.SEND")) {
                extras.get("android.intent.extra.STREAM");
                Uri uriFromExtra2 = getUriFromExtra(extras);
                if (uriFromExtra2 == null || ("text/x-vcard".equals(type) && "content".equals(uriFromExtra2.getScheme()))) {
                    return false;
                }
                if (!type.startsWith("video/")) {
                    i3 = 4;
                }
                if (prepareFileInfoAndReq(uriFromExtra2, i3, str)) {
                    return true;
                }
            } else {
                ArrayList<String> multiFilePathFromExtra2 = getMultiFilePathFromExtra(extras);
                if (multiFilePathFromExtra2 != null && multiFilePathFromExtra2.size() > 0) {
                    sendCheckFileShareReq(multiFilePathFromExtra2, str);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public void sendCheckFileShareReq(ArrayList<String> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) arrayList, (Object) str);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendCheckFileShareReq path len= " + arrayList.size() + ", action=" + str);
            }
            CheckForwardManager checkForwardManager = (CheckForwardManager) this.mActivity.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
            oidb_cmd0xc78$CheckShareExtensionReq requestCommonFiled = setRequestCommonFiled();
            requestCommonFiled.content_type.set(4);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    File file = new File(next);
                    if (file.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "sendCheckFileShareReq path " + next);
                        }
                        oidb_cmd0xc78$AppFileMsgInfo oidb_cmd0xc78_appfilemsginfo = new oidb_cmd0xc78$AppFileMsgInfo();
                        String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(next));
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "sendCheckFileShareReq md5= " + bytes2HexStr);
                        }
                        oidb_cmd0xc78_appfilemsginfo.md5.set(bytes2HexStr);
                        oidb_cmd0xc78_appfilemsginfo.sha1.set(JumpShareUtils.getSHA1(next));
                        oidb_cmd0xc78_appfilemsginfo.file_size.set((int) file.length());
                        requestCommonFiled.files.add(oidb_cmd0xc78_appfilemsginfo);
                    }
                }
            }
            OnCheckShareListener onCheckShareListener = this.mListener.get();
            if (onCheckShareListener != null) {
                checkForwardManager.sendCheckShareReq((QQAppInterface) this.mActivity.getAppRuntime(), requestCommonFiled, str, onCheckShareListener);
            }
        }
    }

    public void sendCheckImgShareReq(ArrayList<String> arrayList, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) arrayList, (Object) str);
            return;
        }
        if (arrayList != null && !arrayList.isEmpty()) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendCheckImgShareReq path len= " + arrayList.size() + ", action=" + str);
            }
            CheckForwardManager checkForwardManager = (CheckForwardManager) this.mActivity.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
            oidb_cmd0xc78$CheckShareExtensionReq requestCommonFiled = setRequestCommonFiled();
            requestCommonFiled.content_type.set(2);
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (!TextUtils.isEmpty(next)) {
                    File file = new File(next);
                    if (file.exists()) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "sendCheckImgShareReq path " + next);
                        }
                        oidb_cmd0xc78$ImgInfo oidb_cmd0xc78_imginfo = new oidb_cmd0xc78$ImgInfo();
                        String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(next));
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "sendCheckImgShareReq md5= " + bytes2HexStr);
                        }
                        oidb_cmd0xc78_imginfo.md5.set(bytes2HexStr);
                        oidb_cmd0xc78_imginfo.sha1.set(JumpShareUtils.getSHA1(next));
                        Pair<Integer, Integer> imgFileWH = JumpShareUtils.getImgFileWH(next);
                        if (imgFileWH != null) {
                            oidb_cmd0xc78_imginfo.width.set(((Integer) imgFileWH.first).intValue());
                            oidb_cmd0xc78_imginfo.height.set(((Integer) imgFileWH.second).intValue());
                        }
                        Pair<StringBuilder, StringBuilder> qRCodeResult = JumpShareUtils.getQRCodeResult(this.mActivity, file);
                        if (qRCodeResult != null) {
                            if (!TextUtils.isEmpty((CharSequence) qRCodeResult.first)) {
                                oidb_cmd0xc78_imginfo.qr_code_result.set(((StringBuilder) qRCodeResult.first).toString());
                            }
                            if (!TextUtils.isEmpty((CharSequence) qRCodeResult.second)) {
                                oidb_cmd0xc78_imginfo.qr_decode_type.set(((StringBuilder) qRCodeResult.second).toString());
                            }
                        }
                        requestCommonFiled.imgs.add(oidb_cmd0xc78_imginfo);
                    }
                }
            }
            OnCheckShareListener onCheckShareListener = this.mListener.get();
            if (onCheckShareListener != null) {
                checkForwardManager.sendCheckShareReq((QQAppInterface) this.mActivity.getAppRuntime(), requestCommonFiled, str, onCheckShareListener);
            }
        }
    }

    public void sendCheckTextShareReq(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendCheckTextShareReq text " + str);
        }
        CheckForwardManager checkForwardManager = (CheckForwardManager) this.mActivity.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
        oidb_cmd0xc78$CheckShareExtensionReq requestCommonFiled = setRequestCommonFiled();
        requestCommonFiled.content_type.set(1);
        oidb_cmd0xc78$TextInfo oidb_cmd0xc78_textinfo = new oidb_cmd0xc78$TextInfo();
        oidb_cmd0xc78_textinfo.text_content.set(str);
        requestCommonFiled.texts.add(oidb_cmd0xc78_textinfo);
        OnCheckShareListener onCheckShareListener = this.mListener.get();
        if (onCheckShareListener != null) {
            checkForwardManager.sendCheckShareReq((QQAppInterface) this.mActivity.getAppRuntime(), requestCommonFiled, "android.intent.action.SEND", onCheckShareListener);
        }
    }

    public void sendCheckVideoShareReq(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "sendCheckVideoShareReq path = " + str + ",action= " + str2);
        }
        CheckForwardManager checkForwardManager = (CheckForwardManager) this.mActivity.getAppRuntime().getManager(QQManagerFactory.CHECK_FORWARD_MANAGER);
        oidb_cmd0xc78$CheckShareExtensionReq requestCommonFiled = setRequestCommonFiled();
        requestCommonFiled.content_type.set(3);
        if (!TextUtils.isEmpty(str) && new File(str).exists()) {
            oidb_cmd0xc78$VideoInfo oidb_cmd0xc78_videoinfo = new oidb_cmd0xc78$VideoInfo();
            String bytes2HexStr = HexUtil.bytes2HexStr(FileManagerUtil.getMd5(str));
            oidb_cmd0xc78_videoinfo.md5.set(bytes2HexStr);
            long durationOfVideo = ShortVideoUtils.getDurationOfVideo(str);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "sendCheckVideoShareReq md5= " + bytes2HexStr + ",du=" + durationOfVideo);
            }
            oidb_cmd0xc78_videoinfo.sha1.set(JumpShareUtils.getSHA1(str));
            oidb_cmd0xc78_videoinfo.play_duration.set((int) durationOfVideo);
            requestCommonFiled.videos.add(oidb_cmd0xc78_videoinfo);
        }
        OnCheckShareListener onCheckShareListener = this.mListener.get();
        if (onCheckShareListener != null) {
            checkForwardManager.sendCheckShareReq((QQAppInterface) this.mActivity.getAppRuntime(), requestCommonFiled, str2, onCheckShareListener);
        }
    }

    public oidb_cmd0xc78$CheckShareExtensionReq setRequestCommonFiled() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (oidb_cmd0xc78$CheckShareExtensionReq) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        oidb_cmd0xc78$CheckShareExtensionReq oidb_cmd0xc78_checkshareextensionreq = new oidb_cmd0xc78$CheckShareExtensionReq();
        oidb_cmd0xc78_checkshareextensionreq.uin.set(Long.valueOf(this.mActivity.getAppRuntime().getCurrentAccountUin()).longValue());
        HashSet<String> hashSet = this.pkgs;
        if (hashSet != null && !hashSet.isEmpty()) {
            Iterator<String> it = this.pkgs.iterator();
            while (it.hasNext()) {
                oidb_cmd0xc78_checkshareextensionreq.android_package_names.add(it.next());
            }
        }
        if (JumpShareUtils.getNeedReportInstallFlag()) {
            oidb_cmd0xc78_checkshareextensionreq.user_flag1.set(1L);
            i3 = JumpShareUtils.getBlackFlag();
            oidb_cmd0xc78_checkshareextensionreq.user_flag2.set(i3);
        } else {
            i3 = 0;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "setRequestCommonFiled flag =" + i3 + " ,pkg: ");
        }
        return oidb_cmd0xc78_checkshareextensionreq;
    }
}
