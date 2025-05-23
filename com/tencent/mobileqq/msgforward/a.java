package com.tencent.mobileqq.msgforward;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.multimsg.save.g;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a implements ShareActionSheet.OnItemClickListener, g {
    static IPatchRedirector $redirector_;
    public static String C;
    public static String D;
    public static String E;
    public static String F;
    public static String G;
    public static String H;

    /* renamed from: d, reason: collision with root package name */
    public static String f251427d;

    /* renamed from: e, reason: collision with root package name */
    private static String f251428e;

    /* renamed from: f, reason: collision with root package name */
    public static String f251429f;

    /* renamed from: h, reason: collision with root package name */
    public static String f251430h;

    /* renamed from: i, reason: collision with root package name */
    public static String f251431i;

    /* renamed from: m, reason: collision with root package name */
    public static String f251432m;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73136);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 26)) {
            redirector.redirect((short) 26);
            return;
        }
        f251427d = AppConstants.SDCARD_PATH + "TempMail" + File.separator;
        f251428e = HardCodeUtil.qqStr(R.string.jae);
        f251429f = "0X8007F0A ";
        f251430h = "0X8007F0B ";
        f251431i = "0X8007F0C ";
        f251432m = "0X8007F0D ";
        C = "0X8007F0E ";
        D = "0X8007F0F ";
        E = "0X8007F10 ";
        F = "0X800A77E";
        G = "0X800B761";
        H = "0X800B762";
    }

    public static String e(MessageForPic messageForPic) {
        URL url = URLDrawableHelper.getURL(messageForPic, 131075);
        if (AbsDownloader.getFile(url.toString()) != null) {
            return AbsDownloader.getFilePath(url.toString());
        }
        URL url2 = URLDrawableHelper.getURL(messageForPic, 1);
        if (AbsDownloader.getFile(url2.toString()) != null) {
            return AbsDownloader.getFilePath(url2.toString());
        }
        URL url3 = URLDrawableHelper.getURL(messageForPic, 65537);
        if (AbsDownloader.getFile(url3.toString()) != null) {
            return AbsDownloader.getFilePath(url3.toString());
        }
        return null;
    }

    public static String f(MessageForPic messageForPic, List<String> list, List<String> list2) {
        String str;
        String e16 = e(messageForPic);
        if (e16 == null) {
            QLog.e("AIOShareActionSheet", 1, "getPicMsgPath null, ", messageForPic.getUserLogString());
            return null;
        }
        list.add(e16);
        if (new File(e16).getName().indexOf(".") == -1) {
            str = FileUtils.estimateFileType(e16);
        } else {
            str = "";
        }
        String str2 = HardCodeUtil.qqStr(R.string.jai) + list.size() + "." + str;
        String str3 = str2 + HardCodeUtil.qqStr(R.string.jad);
        list2.add(str2);
        return str3;
    }
}
