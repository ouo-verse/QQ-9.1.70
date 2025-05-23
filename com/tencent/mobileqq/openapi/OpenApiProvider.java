package com.tencent.mobileqq.openapi;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.common.config.AppSetting;
import com.tencent.gamecenter.wadl.api.IQQGameProviderService;
import com.tencent.mobileqq.openapi.sdk.d;
import com.tencent.mobileqq.openapi.sdk.e;
import com.tencent.mobileqq.openapi.sdk.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.ProcessConstant;

/* loaded from: classes16.dex */
public class OpenApiProvider extends ContentProvider {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    private static final UriMatcher f256895d;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73458);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
            return;
        }
        UriMatcher uriMatcher = new UriMatcher(-1);
        f256895d = uriMatcher;
        try {
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "query_msg", 0);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "query_face", 1);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "query_nick", 2);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "reg_receiver", 3);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "send_msg", 4);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "set_readed", 5);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "openaio", 6);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "decodesilk", 7);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "download_media", 8);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "exchange_uin", 9);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "paycode_channel", 10);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "query_app_version", 11);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "res_task", 12);
            uriMatcher.addURI(IQQGameProviderService.AUTHORITY, "mini_app", 13);
        } catch (Throwable th5) {
            if (QLog.isColorLevel()) {
                QLog.d("OpenApi.Provider", 2, "openapi amazing at ", th5);
            }
        }
    }

    public OpenApiProvider() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private Cursor a(int i3) {
        MatrixCursor matrixCursor = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256936l);
        matrixCursor.addRow(new Object[]{Integer.valueOf(i3)});
        return matrixCursor;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        IQQGameProviderService iQQGameProviderService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, uri, str, strArr)).intValue();
        }
        if (!"Success".equals(MobileQQ.sInjectResult)) {
            return -1000;
        }
        OpenApiManager.getInstance();
        if (OpenApiManager.isGameCenterCode(f256895d.match(uri))) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iQQGameProviderService = (IQQGameProviderService) peekAppRuntime.getRuntimeService(IQQGameProviderService.class, ProcessConstant.MULTI);
            } else {
                iQQGameProviderService = null;
            }
            if (iQQGameProviderService != null) {
                return iQQGameProviderService.delete(uri, str, strArr);
            }
            return -5;
        }
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) uri);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Uri) iPatchRedirector.redirect((short) 5, (Object) this, (Object) uri, (Object) contentValues);
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (QLog.isColorLevel()) {
            QLog.d("OpenApi.Provider", 2, "onCreate");
            return true;
        }
        return true;
    }

    @Override // android.content.ContentProvider
    @Nullable
    public ParcelFileDescriptor openFile(@NonNull Uri uri, @NonNull String str) throws FileNotFoundException {
        IQQGameProviderService iQQGameProviderService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ParcelFileDescriptor) iPatchRedirector.redirect((short) 7, (Object) this, (Object) uri, (Object) str);
        }
        if (!"Success".equals(MobileQQ.sInjectResult)) {
            return super.openFile(uri, str);
        }
        OpenApiManager.getInstance();
        if (OpenApiManager.isGameCenterCode(f256895d.match(uri))) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null) {
                iQQGameProviderService = (IQQGameProviderService) peekAppRuntime.getRuntimeService(IQQGameProviderService.class, ProcessConstant.MULTI);
            } else {
                iQQGameProviderService = null;
            }
            if (iQQGameProviderService != null) {
                return iQQGameProviderService.openFile(uri, str);
            }
            return super.openFile(uri, str);
        }
        return super.openFile(uri, str);
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        long j3;
        long j16;
        long j17;
        long j18;
        char c16;
        boolean z16;
        boolean z17;
        int intValue;
        int i3;
        String str3;
        int i16;
        e eVar;
        int i17;
        int i18;
        List<f> handlePayMsgRsp;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Cursor) iPatchRedirector.redirect((short) 3, this, uri, strArr, str, strArr2, str2);
        }
        if (!"Success".equals(MobileQQ.sInjectResult)) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE});
            matrixCursor.addRow(new Object[]{-1000});
            return matrixCursor;
        }
        OpenApiManager openApiManager = OpenApiManager.getInstance();
        int match = f256895d.match(uri);
        if (OpenApiManager.isGameCenterCode(match)) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            IQQGameProviderService iQQGameProviderService = peekAppRuntime != null ? (IQQGameProviderService) peekAppRuntime.getRuntimeService(IQQGameProviderService.class, ProcessConstant.MULTI) : null;
            if (iQQGameProviderService != null) {
                return iQQGameProviderService.query(uri, strArr, str, strArr2, str2);
            }
            return a(-5);
        }
        if (!openApiManager.isSDKEnable()) {
            return a(-5);
        }
        String queryParameter = uri.getQueryParameter("appid");
        String queryParameter2 = uri.getQueryParameter(PushClientConstants.TAG_PKG_NAME);
        if (!TextUtils.isEmpty(queryParameter) && !TextUtils.isEmpty(queryParameter2)) {
            if (!openApiManager.verifyCallingPackage(this, queryParameter2)) {
                return a(-3);
            }
            switch (match) {
                case 0:
                    String queryParameter3 = uri.getQueryParameter("uin");
                    try {
                        int intValue2 = Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue();
                        int intValue3 = Integer.valueOf(uri.getQueryParameter("count")).intValue();
                        if (!TextUtils.isEmpty(queryParameter3) && intValue3 >= 0) {
                            try {
                                z16 = Boolean.valueOf(uri.getQueryParameter("only_unread")).booleanValue();
                            } catch (Exception unused) {
                                z16 = true;
                            }
                            try {
                                z17 = Boolean.valueOf(uri.getQueryParameter("only_recv")).booleanValue();
                            } catch (Exception unused2) {
                                z17 = true;
                            }
                            ArrayList arrayList = new ArrayList(intValue3);
                            int lastMessages = openApiManager.getLastMessages(arrayList, queryParameter, queryParameter2, queryParameter3, intValue2, intValue3, z17, z16);
                            if (QLog.isColorLevel()) {
                                StringBuilder sb5 = new StringBuilder(100);
                                sb5.append("query msg, uin = ");
                                sb5.append(StringUtil.getSimpleUinForPrint(queryParameter3));
                                sb5.append(", type = ");
                                sb5.append(intValue2);
                                sb5.append(", count = ");
                                sb5.append(intValue3);
                                sb5.append(", rs = ");
                                sb5.append(lastMessages);
                                sb5.append(", rscount = ");
                                sb5.append(arrayList.size());
                                QLog.d("OpenApi.Provider", 2, sb5.toString());
                            }
                            if (lastMessages != 0) {
                                return a(lastMessages);
                            }
                            MatrixCursor matrixCursor2 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256937m);
                            Iterator<d> it = arrayList.iterator();
                            while (it.hasNext()) {
                                matrixCursor2.addRow(it.next().a());
                            }
                            return matrixCursor2;
                        }
                        return a(-6);
                    } catch (Exception e16) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "query_msg", e16);
                        }
                        return a(-6);
                    }
                case 1:
                    String queryParameter4 = uri.getQueryParameter("uin");
                    try {
                        int intValue4 = Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue();
                        if (TextUtils.isEmpty(queryParameter4)) {
                            return a(-6);
                        }
                        f avatarPath = openApiManager.getAvatarPath(queryParameter, queryParameter2, queryParameter4, intValue4);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb6 = new StringBuilder(150);
                            sb6.append("query face, uin = ");
                            sb6.append(StringUtil.getSimpleUinForPrint(queryParameter4));
                            sb6.append(", type = ");
                            sb6.append(intValue4);
                            sb6.append(", rs = ");
                            sb6.append(avatarPath.f256973b);
                            sb6.append(", path = ");
                            sb6.append(avatarPath.f256974c);
                            QLog.d("OpenApi.Provider", 2, sb6.toString());
                        }
                        int i19 = avatarPath.f256973b;
                        if (i19 != 0) {
                            return a(i19);
                        }
                        MatrixCursor matrixCursor3 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256938n);
                        matrixCursor3.addRow(new Object[]{avatarPath.f256974c});
                        return matrixCursor3;
                    } catch (Exception e17) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "query_face", e17);
                        }
                        return a(-6);
                    }
                case 2:
                    String queryParameter5 = uri.getQueryParameter("uin");
                    try {
                        int intValue5 = Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue();
                        if (TextUtils.isEmpty(queryParameter5)) {
                            return a(-6);
                        }
                        f nickName = openApiManager.getNickName(queryParameter, queryParameter2, queryParameter5, intValue5);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb7 = new StringBuilder(150);
                            sb7.append("query nick, uin = ");
                            sb7.append(StringUtil.getSimpleUinForPrint(queryParameter5));
                            sb7.append(", type = ");
                            sb7.append(intValue5);
                            sb7.append(", rs = ");
                            sb7.append(nickName.f256973b);
                            QLog.d("OpenApi.Provider", 2, sb7.toString());
                        }
                        int i26 = nickName.f256973b;
                        if (i26 != 0) {
                            return a(i26);
                        }
                        MatrixCursor matrixCursor4 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256939o);
                        matrixCursor4.addRow(new Object[]{nickName.f256974c});
                        return matrixCursor4;
                    } catch (Exception e18) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "query_nick", e18);
                        }
                        return a(-6);
                    }
                case 3:
                    try {
                        int intValue6 = Integer.valueOf(uri.getQueryParameter("op")).intValue();
                        long longValue = intValue6 == 1 ? Long.valueOf(uri.getQueryParameter("sessionkey")).longValue() : 0L;
                        if (intValue6 == 1) {
                            try {
                                intValue = Integer.valueOf(uri.getQueryParameter("msg_filter")).intValue();
                                int intValue7 = Integer.valueOf(uri.getQueryParameter("uin_filter")).intValue();
                                String queryParameter6 = uri.getQueryParameter(QCircleDaTongConstant.ElementParamValue.PERMISSION);
                                if (TextUtils.isEmpty(queryParameter6)) {
                                    return a(-6);
                                }
                                i3 = intValue7;
                                str3 = queryParameter6;
                                i16 = 1;
                            } catch (Exception e19) {
                                if (QLog.isColorLevel()) {
                                    QLog.d("OpenApi.Provider", 2, "reg_receiver", e19);
                                }
                                return a(-6);
                            }
                        } else {
                            i16 = 1;
                            intValue = 0;
                            i3 = 0;
                            str3 = null;
                        }
                        if (intValue6 == i16) {
                            eVar = openApiManager.registerThirdApp(queryParameter, queryParameter2, longValue, intValue, i3, str3);
                        } else {
                            eVar = new e(openApiManager.unregisterThirdApp(queryParameter, queryParameter2), 0L, null);
                        }
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "reg, op = " + intValue6 + ", filter = " + intValue + ", rs = " + eVar.f256969a + ", stamp = " + eVar.f256970b + ", uin = " + eVar.f256971c);
                        }
                        MatrixCursor matrixCursor5 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256940p);
                        matrixCursor5.addRow(new Object[]{Integer.valueOf(eVar.f256969a), Long.valueOf(eVar.f256970b), eVar.f256971c});
                        return matrixCursor5;
                    } catch (Exception e26) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "reg_receiver", e26);
                        }
                        return a(-6);
                    }
                case 4:
                    String queryParameter7 = uri.getQueryParameter("uin");
                    try {
                        int intValue8 = Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue();
                        int intValue9 = Integer.valueOf(uri.getQueryParameter(QQHealthReportApiImpl.MSG_TYPE_KEY)).intValue();
                        String queryParameter8 = uri.getQueryParameter(RemoteMessageConst.MessageBody.MSG_CONTENT);
                        String queryParameter9 = uri.getQueryParameter("media_path");
                        if (!TextUtils.isEmpty(queryParameter7) && (!TextUtils.isEmpty(queryParameter8) || !TextUtils.isEmpty(queryParameter9))) {
                            f sendMessage = openApiManager.sendMessage(queryParameter, queryParameter2, queryParameter7, intValue8, intValue9, queryParameter8, queryParameter9);
                            if (QLog.isColorLevel()) {
                                QLog.d("OpenApi.Provider", 2, "sendMsg, uin = " + queryParameter7 + "msgType = " + intValue9 + ", result = " + sendMessage.f256973b);
                            }
                            int i27 = sendMessage.f256973b;
                            if (i27 != 0) {
                                return a(i27);
                            }
                            MatrixCursor matrixCursor6 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256941q);
                            matrixCursor6.addRow(new Object[]{sendMessage.f256974c});
                            return matrixCursor6;
                        }
                        return a(-6);
                    } catch (Exception e27) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "send msg", e27);
                        }
                        return a(-6);
                    }
                case 5:
                    String queryParameter10 = uri.getQueryParameter("uin");
                    String queryParameter11 = uri.getQueryParameter("msgid");
                    try {
                        int intValue10 = Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue();
                        if (!TextUtils.isEmpty(queryParameter10) && !TextUtils.isEmpty(queryParameter11)) {
                            int messageReaded = openApiManager.setMessageReaded(queryParameter, queryParameter2, queryParameter10, intValue10, queryParameter11);
                            if (QLog.isColorLevel()) {
                                QLog.d("OpenApi.Provider", 2, "set readed, uin = " + StringUtil.getSimpleUinForPrint(queryParameter10) + ", uinType = " + intValue10 + ", msgids = " + strArr2 + ", rs = " + messageReaded);
                            }
                            MatrixCursor matrixCursor7 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256936l);
                            matrixCursor7.addRow(new Object[]{Integer.valueOf(messageReaded)});
                            return matrixCursor7;
                        }
                        return a(-6);
                    } catch (Exception e28) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "set_readed", e28);
                        }
                        return a(-6);
                    }
                case 6:
                    try {
                        int openAIO = openApiManager.openAIO(queryParameter, queryParameter2, uri.getQueryParameter("uin"), Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue());
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "open aio, result = " + openAIO);
                        }
                        MatrixCursor matrixCursor8 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256943s);
                        matrixCursor8.addRow(new Object[]{Integer.valueOf(openAIO)});
                        return matrixCursor8;
                    } catch (Exception e29) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "openaio", e29);
                        }
                        return a(-6);
                    }
                case 7:
                    String queryParameter12 = uri.getQueryParameter("uin");
                    try {
                        i17 = Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue();
                    } catch (Exception e36) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "decodesilk", e36);
                        }
                        i17 = 0;
                    }
                    String queryParameter13 = uri.getQueryParameter("msgid");
                    String queryParameter14 = uri.getQueryParameter("media_path");
                    String queryParameter15 = uri.getQueryParameter("pcm_path");
                    if (!TextUtils.isEmpty(queryParameter12) && !TextUtils.isEmpty(queryParameter13) && !TextUtils.isEmpty(queryParameter14) && !TextUtils.isEmpty(queryParameter15)) {
                        Pair<Integer, Integer> decodePtt = openApiManager.decodePtt(queryParameter, queryParameter2, queryParameter12, i17, queryParameter13, queryParameter14, queryParameter15);
                        MatrixCursor matrixCursor9 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256944t);
                        matrixCursor9.addRow(new Object[]{decodePtt.first, decodePtt.second});
                        return matrixCursor9;
                    }
                    return a(-6);
                case 8:
                    String queryParameter16 = uri.getQueryParameter("uin");
                    String queryParameter17 = uri.getQueryParameter("msgid");
                    try {
                        i18 = Integer.valueOf(uri.getQueryParameter(IPublicAccountBrowser.KEY_UIN_TYPE)).intValue();
                    } catch (Exception e37) {
                        if (QLog.isColorLevel()) {
                            QLog.d("OpenApi.Provider", 2, "downMedia", e37);
                        }
                        i18 = 0;
                    }
                    if (!TextUtils.isEmpty(queryParameter16) && !TextUtils.isEmpty(queryParameter17) && i18 != 0) {
                        Pair<Integer, Integer> downloadMedia = openApiManager.downloadMedia(queryParameter, queryParameter2, queryParameter16, i18, queryParameter17);
                        if (((Integer) downloadMedia.first).intValue() != 0) {
                            return a(((Integer) downloadMedia.first).intValue());
                        }
                        MatrixCursor matrixCursor10 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256945u);
                        matrixCursor10.addRow(new Object[]{downloadMedia.second});
                        return matrixCursor10;
                    }
                    return a(-6);
                case 9:
                    try {
                        j3 = Long.valueOf(uri.getQueryParameter("lastsessionkey")).longValue();
                        try {
                            j18 = Long.valueOf(uri.getQueryParameter("sessionkey")).longValue();
                            j16 = j3;
                            j17 = 0;
                        } catch (Exception e38) {
                            e = e38;
                            if (QLog.isColorLevel()) {
                                QLog.d("OpenApi.Provider", 2, "exchangeUin", e);
                            }
                            j16 = j3;
                            j17 = 0;
                            j18 = 0;
                            if (j16 == j17) {
                            }
                            return a(-6);
                        }
                    } catch (Exception e39) {
                        e = e39;
                        j3 = 0;
                    }
                    if (j16 == j17 && j18 != j17 && strArr2 != null && strArr2.length != 0) {
                        f[] exchangeUins = openApiManager.exchangeUins(queryParameter, queryParameter2, j16, j18, strArr2);
                        if (QLog.isColorLevel()) {
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append("exchange uin, result = ");
                            c16 = 0;
                            sb8.append(exchangeUins[0].f256973b);
                            QLog.d("OpenApi.Provider", 2, sb8.toString());
                        } else {
                            c16 = 0;
                        }
                        if (exchangeUins.length != strArr2.length) {
                            return a(exchangeUins[c16].f256973b);
                        }
                        MatrixCursor matrixCursor11 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256946v);
                        for (f fVar : exchangeUins) {
                            matrixCursor11.addRow(new Object[]{Integer.valueOf(fVar.f256973b), fVar.f256974c});
                        }
                        return matrixCursor11;
                    }
                    return a(-6);
                case 10:
                    String queryParameter18 = uri.getQueryParameter(QQHealthReportApiImpl.MSG_TYPE_KEY);
                    if (queryParameter18 != null) {
                        handlePayMsgRsp = openApiManager.handlePayMsgReq(queryParameter, queryParameter2, uri.getQueryParameter(QCircleDaTongConstant.ElementParamValue.PERMISSION), Integer.parseInt(queryParameter18), uri.getQueryParameter("msgSummary"));
                    } else {
                        handlePayMsgRsp = openApiManager.handlePayMsgRsp(null);
                    }
                    if (handlePayMsgRsp == null || handlePayMsgRsp.size() <= 0) {
                        return null;
                    }
                    MatrixCursor matrixCursor12 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256947w);
                    for (f fVar2 : handlePayMsgRsp) {
                        matrixCursor12.addRow(new Object[]{Integer.valueOf(fVar2.f256972a), Integer.valueOf(fVar2.f256973b), fVar2.f256974c});
                    }
                    return matrixCursor12;
                case 11:
                    String str4 = AppSetting.f99551k;
                    MatrixCursor matrixCursor13 = new MatrixCursor(com.tencent.mobileqq.openapi.sdk.a.f256948x);
                    matrixCursor13.addRow(new Object[]{str4});
                    return matrixCursor13;
                default:
                    if (QLog.isColorLevel()) {
                        QLog.d("OpenApi.Provider", 2, "error code = " + match);
                    }
                    MatrixCursor matrixCursor14 = new MatrixCursor(new String[]{IQQGameProviderService.COLUMN_NAME_RS_CODE});
                    matrixCursor14.addRow(new Object[]{-5});
                    return matrixCursor14;
            }
        }
        return a(-6);
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 8, this, uri, contentValues, str, strArr)).intValue();
    }
}
