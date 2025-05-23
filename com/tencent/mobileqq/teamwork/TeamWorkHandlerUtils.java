package com.tencent.mobileqq.teamwork;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.local_edit.andserver.util.MediaType;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHandler;
import com.tencent.mobileqq.teamwork.api.ITeamWorkHttpUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkHandlerUtils {

    /* renamed from: a, reason: collision with root package name */
    private static String f291532a;

    /* renamed from: b, reason: collision with root package name */
    private static String f291533b;

    /* renamed from: c, reason: collision with root package name */
    public static final Map<TDFileType, List<String>> f291534c;

    /* renamed from: d, reason: collision with root package name */
    public static final Map<TDFileType, Integer> f291535d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class a implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291536a;

        a(IGetExternalInterface.d dVar) {
            this.f291536a = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:14:0x0068  */
        /* JADX WARN: Removed duplicated region for block: B:4:0x004d  */
        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Object obj) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = null;
            if (obj instanceof String) {
                try {
                    jSONObject = new JSONObject((String) obj);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (jSONObject.optInt("retcode", -1) != 0) {
                        jSONObject.put("retcode", -1);
                        if (QLog.isColorLevel()) {
                            QLog.e("TeamWorkHandlerUtils", 2, "failed result" + obj);
                        }
                    }
                    jSONObject2 = jSONObject;
                } catch (Throwable th6) {
                    th = th6;
                    jSONObject2 = jSONObject;
                    if (QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, th, new Object[0]);
                    }
                    if (jSONObject2 == null) {
                    }
                    if (QLog.isColorLevel()) {
                    }
                    this.f291536a.a((String) jSONObject2.opt("key"));
                }
            }
            if (jSONObject2 == null) {
                jSONObject2 = new JSONObject();
                try {
                    jSONObject2.put("retcode", -1);
                } catch (JSONException e16) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, e16, new Object[0]);
                    }
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TeamWorkHandlerUtils", 2, jSONObject2.toString());
            }
            this.f291536a.a((String) jSONObject2.opt("key"));
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class b implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291537a;

        b(IGetExternalInterface.d dVar) {
            this.f291537a = dVar;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            JSONObject jSONObject = null;
            try {
                if (obj instanceof String) {
                    JSONObject jSONObject2 = new JSONObject((String) obj);
                    try {
                        if (jSONObject2.optInt("retcode", -1) != 0) {
                            jSONObject2.put("retcode", -1);
                            if (QLog.isColorLevel()) {
                                QLog.e("TeamWorkHandlerUtils", 2, "checkFormCache failed result" + obj);
                            }
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th5) {
                        th = th5;
                        jSONObject = jSONObject2;
                        if (QLog.isColorLevel()) {
                            QLog.e("TeamWorkHandlerUtils", 2, th, new Object[0]);
                        }
                        this.f291537a.a(jSONObject);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
            this.f291537a.a(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class c implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291538a;

        c(IGetExternalInterface.d dVar) {
            this.f291538a = dVar;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            if (obj instanceof String) {
                try {
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, th5, new Object[0]);
                    }
                }
                if (new JSONObject((String) obj).optInt("retcode", -1) != 0) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, "setUserPrivilege failed result" + obj);
                    }
                    this.f291538a.a(Boolean.FALSE);
                    return;
                }
                this.f291538a.a(Boolean.TRUE);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class d implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f291539a;

        d(String str) {
            this.f291539a = str;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            if (obj instanceof String) {
                String str = (String) obj;
                if (!TextUtils.isEmpty(str)) {
                    FileUtils.writeFile(TeamWorkHandlerUtils.h(), MD5Utils.encodeHexStr(this.f291539a), str);
                }
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class e implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291540a;

        e(IGetExternalInterface.d dVar) {
            this.f291540a = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x004d  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x0060  */
        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Object obj) {
            JSONObject jSONObject = null;
            try {
                if (obj instanceof String) {
                    JSONObject jSONObject2 = new JSONObject((String) obj);
                    try {
                        if (jSONObject2.optInt("retcode", -1) != 0) {
                            jSONObject2.put("retcode", -1);
                            if (QLog.isColorLevel()) {
                                QLog.e("TeamWorkHandlerUtils", 2, "failed result" + obj);
                            }
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th5) {
                        th = th5;
                        jSONObject = jSONObject2;
                        if (QLog.isColorLevel()) {
                            QLog.e("TeamWorkHandlerUtils", 2, th, new Object[0]);
                        }
                        if (jSONObject == null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        this.f291540a.a(jSONObject);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("retcode", -1);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TeamWorkHandlerUtils", 2, jSONObject.toString());
            }
            this.f291540a.a(jSONObject);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class f implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291541a;

        f(IGetExternalInterface.d dVar) {
            this.f291541a = dVar;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            JSONObject jSONObject = null;
            try {
                if (obj instanceof String) {
                    JSONObject jSONObject2 = new JSONObject((String) obj);
                    try {
                        if (jSONObject2.optInt("retcode", -1) != 0 && QLog.isColorLevel()) {
                            QLog.e("TeamWorkHandlerUtils", 2, "checkFormCache failed result" + obj);
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th5) {
                        th = th5;
                        jSONObject = jSONObject2;
                        if (QLog.isColorLevel()) {
                            QLog.e("TeamWorkHandlerUtils", 2, th, new Object[0]);
                        }
                        this.f291541a.a(jSONObject);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
            this.f291541a.a(jSONObject);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class g implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291542a;

        g(IGetExternalInterface.d dVar) {
            this.f291542a = dVar;
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            JSONObject jSONObject;
            JSONObject jSONObject2 = null;
            if (obj instanceof String) {
                try {
                    jSONObject = new JSONObject((String) obj);
                } catch (Throwable th5) {
                    th = th5;
                }
                try {
                    if (jSONObject.optInt("retcode", -1) != 0 && QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, "checkFormCache failed result" + obj);
                    }
                    jSONObject2 = jSONObject;
                } catch (Throwable th6) {
                    th = th6;
                    jSONObject2 = jSONObject;
                    if (QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, th, new Object[0]);
                    }
                    this.f291542a.a(jSONObject2);
                }
            }
            this.f291542a.a(jSONObject2);
        }
    }

    /* compiled from: P */
    /* loaded from: classes18.dex */
    class h implements IGetExternalInterface.d {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ IGetExternalInterface.d f291543a;

        h(IGetExternalInterface.d dVar) {
            this.f291543a = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void a(Object obj) {
            JSONObject jSONObject = null;
            try {
                if (obj instanceof String) {
                    JSONObject jSONObject2 = new JSONObject((String) obj);
                    try {
                        if (jSONObject2.optInt("retcode", -1) != 0) {
                            jSONObject2.put("retcode", -1);
                            if (QLog.isColorLevel()) {
                                QLog.e("TeamWorkHandlerUtils", 2, "[sendLocalCooperationGrayTip] failed result" + obj);
                            }
                        }
                        jSONObject = jSONObject2;
                    } catch (Throwable th5) {
                        th = th5;
                        jSONObject = jSONObject2;
                        if (QLog.isColorLevel()) {
                            QLog.e("TeamWorkHandlerUtils", 2, "[sendLocalCooperationGrayTip] e:" + th);
                        }
                        if (jSONObject == null) {
                        }
                        if (QLog.isColorLevel()) {
                        }
                        this.f291543a.a(jSONObject);
                    }
                }
            } catch (Throwable th6) {
                th = th6;
            }
            if (jSONObject == null) {
                jSONObject = new JSONObject();
                try {
                    jSONObject.put("retcode", -1);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("TeamWorkHandlerUtils", 2, "[sendLocalCooperationGrayTip] result:" + jSONObject.toString());
            }
            this.f291543a.a(jSONObject);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class i implements IGetExternalInterface.d {
        i() {
        }

        @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
        public void a(Object obj) {
            if (obj instanceof String) {
                try {
                    if (new JSONObject((String) obj).optInt("retcode", -1) != 0 && QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, "wechatShareTips failed result" + obj);
                    }
                } catch (Throwable th5) {
                    if (QLog.isColorLevel()) {
                        QLog.e("TeamWorkHandlerUtils", 2, th5, new Object[0]);
                    }
                }
            }
        }
    }

    static {
        Class<TDFileType> cls = TDFileType.class;
        f291534c = new EnumMap<TDFileType, List<String>>(cls) { // from class: com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils.1
            {
                put((AnonymousClass1) TDFileType.DOC, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.doc"));
                put((AnonymousClass1) TDFileType.SHEET, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.sheet"));
                put((AnonymousClass1) TDFileType.FORM, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.form"));
                put((AnonymousClass1) TDFileType.SLIDE, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.slide"));
                put((AnonymousClass1) TDFileType.PDF, (TDFileType) Collections.singletonList(MediaType.APPLICATION_PDF_VALUE));
                put((AnonymousClass1) TDFileType.MIND_MAP, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.mind"));
                put((AnonymousClass1) TDFileType.FLOW_CHART, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.flowchart"));
                put((AnonymousClass1) TDFileType.SMART_SHEET, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.smartsheet"));
                put((AnonymousClass1) TDFileType.SMART_CANVAS, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.smartcanvas"));
                put((AnonymousClass1) TDFileType.VOICE_NOTE, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.rec"));
                put((AnonymousClass1) TDFileType.BOARD, (TDFileType) Collections.singletonList("application/vnd.tdocs-apps.board"));
                put((AnonymousClass1) TDFileType.DRIVE_WORD, (TDFileType) Arrays.asList("application/vnd.ms-word", "application/msword", "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "application/kswps", "application/kswpt", "application/vnd.openxmlformats-officedocument.wordprocessingml.template", "application/vnd.ms-word.document.macroEnabled.12", "application/vnd.ms-word.template.macroEnabled.12"));
                put((AnonymousClass1) TDFileType.DRIVE_EXCEL, (TDFileType) Arrays.asList("application/vnd.ms-excel", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "application/vnd.openxmlformats-officedocument.spreadsheetml.template", "text/csv", "text/csv; charset=utf-8", "application/vnd.ms-excel.sheet.binary.macroEnabled.12", "application/vnd.ms-excel.sheet.macroEnabled.12", "application/vnd.ms-excel.template.macroEnabled.12", "application/kset", "application/ksett"));
                put((AnonymousClass1) TDFileType.DRIVE_PPT, (TDFileType) Arrays.asList("application/vnd.ms-powerpoint", "application/vnd.openxmlformats-officedocument.presentationml.presentation", "application/vnd.openxmlformats-officedocument.presentationml.template", "application/vnd.openxmlformats-officedocument.presentationml.slideshow", "application/ksdps", "application/ksdpt", "application/vnd.ms-powerpoint.presentation.macroEnabled.12", "application/vnd.ms-powerpoint.template.macroEnabled.12", "application/vnd.ms-powerpoint.slideshow.macroEnabled.12"));
            }
        };
        f291535d = new EnumMap<TDFileType, Integer>(cls) { // from class: com.tencent.mobileqq.teamwork.TeamWorkHandlerUtils.2
            {
                put((AnonymousClass2) TDFileType.DOC, (TDFileType) Integer.valueOf(R.drawable.oke));
                put((AnonymousClass2) TDFileType.SHEET, (TDFileType) Integer.valueOf(R.drawable.okm));
                put((AnonymousClass2) TDFileType.SLIDE, (TDFileType) Integer.valueOf(R.drawable.okj));
                put((AnonymousClass2) TDFileType.FORM, (TDFileType) Integer.valueOf(R.drawable.okg));
                put((AnonymousClass2) TDFileType.PDF, (TDFileType) Integer.valueOf(R.drawable.oki));
                put((AnonymousClass2) TDFileType.MIND_MAP, (TDFileType) Integer.valueOf(R.drawable.okh));
                put((AnonymousClass2) TDFileType.FLOW_CHART, (TDFileType) Integer.valueOf(R.drawable.okf));
                put((AnonymousClass2) TDFileType.SMART_SHEET, (TDFileType) Integer.valueOf(R.drawable.filelook_smartsheet));
                put((AnonymousClass2) TDFileType.SMART_CANVAS, (TDFileType) Integer.valueOf(R.drawable.filelook_smartcanvas));
                put((AnonymousClass2) TDFileType.VOICE_NOTE, (TDFileType) Integer.valueOf(R.drawable.filelook_voicenote));
                put((AnonymousClass2) TDFileType.BOARD, (TDFileType) Integer.valueOf(R.drawable.okd));
                put((AnonymousClass2) TDFileType.DRIVE_WORD, (TDFileType) Integer.valueOf(R.drawable.ohx));
                put((AnonymousClass2) TDFileType.DRIVE_EXCEL, (TDFileType) Integer.valueOf(R.drawable.ohz));
                put((AnonymousClass2) TDFileType.DRIVE_PPT, (TDFileType) Integer.valueOf(R.drawable.ohy));
                put((AnonymousClass2) TDFileType.UNKNOWN, (TDFileType) Integer.valueOf(R.drawable.okl));
            }
        };
    }

    public static boolean a(String str) {
        File i3 = i(str);
        if (System.currentTimeMillis() - i3.lastModified() > 7200000) {
            i3.delete();
            return false;
        }
        return i3.exists();
    }

    public static void b(JSONObject jSONObject, String str, IGetExternalInterface.d dVar) {
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(jSONObject, str, ITeamWorkHandler.URL_GET_FORM_CACHE, ITeamWorkHandler.DOCS_DOMAIN, new b(dVar));
    }

    public static void c() {
        File file = new File(h());
        if (file.exists()) {
            for (File file2 : file.listFiles()) {
                if (System.currentTimeMillis() - file2.lastModified() > 7200000) {
                    file2.delete();
                }
            }
        }
    }

    public static void d(String str) {
        File i3 = i(str);
        if (i3.exists()) {
            i3.delete();
        }
    }

    public static void e(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String[] split = str.split("\\$");
        if (split.length != 2) {
            return;
        }
        try {
            String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
            HashMap hashMap = new HashMap();
            hashMap.put("HTTP_X_XSRF_PROTECTION", replaceAll);
            ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost("domain_id=" + split[0] + "&pad_id=" + split[1] + "&list_type=5&xsrf=" + replaceAll, str2, ITeamWorkHandler.URL_DELETE_DOC, ITeamWorkHandler.DOCS_DOMAIN, "TOK=" + replaceAll, hashMap, false, null);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void f(String str, String str2, String str3) {
        String str4 = "doc_url=" + URLEncoder.encode(str3);
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(str4, str, "https://docs.qq.com/dop-api/opendoc?id=" + str2 + "&prefetch=1", ITeamWorkHandler.DOCS_DOMAIN, new d(str2));
    }

    public static String g(String str) {
        return FileUtils.readFileContent(i(str));
    }

    public static String h() {
        String str = f291532a;
        if (str != null) {
            return str;
        }
        String str2 = k() + "Tencent/tdoc/";
        f291532a = str2;
        return str2;
    }

    private static File i(String str) {
        return new File(h(), MD5Utils.encodeHexStr(str));
    }

    public static String j(String str) {
        return Uri.parse(str).getLastPathSegment();
    }

    public static String k() {
        String str = f291533b;
        if (str != null) {
            return str;
        }
        File externalFilesDir = MobileQQ.sMobileQQ.getExternalFilesDir(null);
        if (externalFilesDir == null) {
            externalFilesDir = MobileQQ.sMobileQQ.getFilesDir();
        }
        String absolutePath = externalFilesDir.getAbsolutePath();
        if (!absolutePath.endsWith("/")) {
            absolutePath = absolutePath + "/";
        }
        f291533b = absolutePath;
        return absolutePath;
    }

    public static void l(String str, String str2, IGetExternalInterface.d dVar) {
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(str2, "https://docs.qq.com/cgi-bin/online_docs/doc_infoguest?docUrl=" + str, ITeamWorkHandler.DOCS_DOMAIN, new e(dVar));
    }

    public static void m(String str, o oVar, IGetExternalInterface.d dVar) {
        try {
            int i3 = oVar.f292297c;
            int i16 = 1;
            if (i3 == 0) {
                i3 = 1;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", URLEncoder.encode(oVar.f292303i));
            String str2 = oVar.f292309o;
            if (str2 != null) {
                jSONObject.put("title", URLEncoder.encode(str2));
            }
            jSONObject.put("type", 0);
            String str3 = oVar.f292310p;
            if (str3 == null) {
                str3 = "0";
            }
            jSONObject.put("folderId", str3);
            StringBuilder sb5 = new StringBuilder(ITeamWorkHandler.URL_GET_WX_QRCODE);
            sb5.append('?');
            sb5.append("domainId=");
            sb5.append(oVar.f292308n);
            sb5.append("&padId=");
            sb5.append(oVar.f292307m);
            sb5.append("&dataType=");
            if (oVar.f292300f != 3) {
                i16 = 0;
            }
            sb5.append(i16);
            sb5.append("&page=");
            sb5.append("pages/shareFriend/shareFriend");
            sb5.append("&ac=");
            sb5.append("share");
            sb5.append("&t=");
            sb5.append("0");
            sb5.append("&policy=");
            sb5.append(String.valueOf(i3));
            sb5.append("&right_flag=");
            sb5.append("1");
            sb5.append("&param=");
            sb5.append(jSONObject.toString());
            sb5.append("&type=");
            sb5.append("1");
            ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(str, sb5.toString(), ITeamWorkHandler.DOCS_DOMAIN, new a(dVar));
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TeamWorkHandlerUtils", 2, e16, new Object[0]);
            }
            dVar.a(null);
        }
    }

    public static void n(JSONObject jSONObject, String str, String str2, IGetExternalInterface.d dVar) {
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).uploadFileWithParam(jSONObject, str, ITeamWorkHttpUtils.DEFAULT_TENCENT_DOC_IMPORT_FORM, str2, new g(dVar));
    }

    public static void o(JSONObject jSONObject, String str, IGetExternalInterface.d dVar) {
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(jSONObject, str, ITeamWorkHandler.URL_IMPORT_FORM, ITeamWorkHandler.DOCS_DOMAIN, new f(dVar));
    }

    public static void p(String str, String str2, int i3, String str3, String str4, String str5, IGetExternalInterface.d dVar) {
        try {
            ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(str5, "https://docs.qq.com/cgi-go/users/pushNotify?docname=" + str + "&url=" + URLEncoder.encode(str2, "UTF-8") + "&authflag=" + i3 + "&groupcode=" + str3 + "&touin=" + str4, ITeamWorkHandler.DOCS_DOMAIN, new h(dVar));
        } catch (UnsupportedEncodingException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TeamWorkHandlerUtils", 2, "[sendLocalCooperationGrayTip] e:" + e16);
            }
        }
    }

    public static void q(String str, String str2, String str3, int i3, IGetExternalInterface.d dVar) {
        if (TextUtils.isEmpty(str3)) {
            dVar.a(Boolean.FALSE);
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            jSONObject.put("id", str3);
            jSONObject.put("type", 2);
            jSONObject2.put("obj", jSONObject);
            jSONObject2.put("policy", i3);
            String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
            jSONObject2.put("xsrf", replaceAll);
            ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsPost(jSONObject2, str, String.format(ITeamWorkHandler.URL_SET_USER, str2) + "?&xsrf=" + replaceAll, ITeamWorkHandler.DOCS_DOMAIN, "TOK=" + replaceAll, new c(dVar));
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.e("TeamWorkHandlerUtils", 2, e16, new Object[0]);
            }
            dVar.a(Boolean.FALSE);
        }
    }

    public static void r(String str, o oVar) {
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        ((ITeamWorkHttpUtils) QRoute.api(ITeamWorkHttpUtils.class)).sendHttpsGet(str, ITeamWorkHandler.URL_WECHAT_SHARE_TIPS + "?domainId=" + oVar.f292308n + "&padId=" + oVar.f292307m + "&xsrf=" + replaceAll, ITeamWorkHandler.DOCS_DOMAIN, "TOK=" + replaceAll, new i());
    }
}
