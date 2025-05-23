package com.tencent.mobileqq.teamwork;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.DirectForwardActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.tendoc.TencentDocLocalCooperationProcessor;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;
import com.tencent.mobileqq.teamwork.api.IGetExternalInterface;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.util.UiThreadUtil;
import com.tencent.weiyun.transmission.db.JobDbManager;
import com.tencent.xweb.FileReaderHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TeamWorkUtils {

    /* renamed from: a, reason: collision with root package name */
    private static String f291560a = "TeamWorkUtils";

    /* renamed from: b, reason: collision with root package name */
    public static String f291561b = "https://docs.qq.com/desktop/favicon.ico";

    /* renamed from: c, reason: collision with root package name */
    public static final Map<Integer, String> f291562c;

    /* renamed from: d, reason: collision with root package name */
    public static final HashMap<String, String> f291563d;

    /* renamed from: e, reason: collision with root package name */
    public static final Map<String, Integer> f291564e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseArray<Pair<Integer, String>> f291565f;

    /* renamed from: g, reason: collision with root package name */
    public static final SparseArray<Pair<Integer, String>> f291566g;

    /* renamed from: h, reason: collision with root package name */
    private static long f291567h;

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.teamwork.TeamWorkUtils$1, reason: invalid class name */
    /* loaded from: classes18.dex */
    class AnonymousClass1 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f291568d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f291569e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ qb1.e f291570f;

        AnonymousClass1(String str, String str2, qb1.e eVar) {
            this.f291568d = str;
            this.f291569e = str2;
            this.f291570f = eVar;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ void d(final qb1.e eVar, Object obj) {
            if (!(obj instanceof JSONObject)) {
                return;
            }
            try {
                JSONObject jSONObject = (JSONObject) obj;
                int i3 = jSONObject.getInt("retcode");
                if (i3 != 0) {
                    QLog.e(TeamWorkUtils.f291560a, 1, "fail to fetch doc info, retCode: " + i3);
                    eVar.a(Integer.valueOf(R.drawable.okl));
                    return;
                }
                String string = jSONObject.getJSONObject("doc_meta").getString(JobDbManager.COL_UP_MIME_TYPE);
                if (string.isEmpty()) {
                    eVar.a(Integer.valueOf(R.drawable.okl));
                    return;
                }
                TDFileType tDFileType = TDFileType.UNKNOWN;
                Iterator<Map.Entry<TDFileType, List<String>>> it = TeamWorkHandlerUtils.f291534c.entrySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Map.Entry<TDFileType, List<String>> next = it.next();
                    List<String> value = next.getValue();
                    if (value != null && value.contains(string)) {
                        tDFileType = next.getKey();
                        break;
                    }
                }
                final Integer num = TeamWorkHandlerUtils.f291535d.get(tDFileType);
                UiThreadUtil.runOnUiThread(new Runnable() { // from class: com.tencent.mobileqq.teamwork.bl
                    @Override // java.lang.Runnable
                    public final void run() {
                        qb1.e.this.a(num);
                    }
                });
            } catch (JSONException e16) {
                QLog.e(TeamWorkUtils.f291560a, 1, "fail to parse json in getTDDocFileThumbUrl method", e16);
                eVar.a(Integer.valueOf(R.drawable.okl));
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            String str = this.f291568d;
            String str2 = this.f291569e;
            final qb1.e eVar = this.f291570f;
            TeamWorkHandlerUtils.l(str, str2, new IGetExternalInterface.d() { // from class: com.tencent.mobileqq.teamwork.bk
                @Override // com.tencent.mobileqq.teamwork.api.IGetExternalInterface.d
                public final void a(Object obj) {
                    TeamWorkUtils.AnonymousClass1.d(qb1.e.this, obj);
                }
            });
        }
    }

    static {
        HashMap hashMap = new HashMap();
        f291562c = hashMap;
        hashMap.put(9, ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING);
        hashMap.put(12, ITeamWorkUtils.TD_SOURCE_QQ_URL_2_DOC);
        HashMap<String, String> hashMap2 = new HashMap<>();
        f291563d = hashMap2;
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_AIOMSG, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_MSG);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MY_FILE);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_YINDAO, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MY_FILE);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_BANNER, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MY_FILE);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_MYFILE_MENU_CREATE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_TEMPLATELIST);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_GRPFILE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_TROOP_FILE);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_AIO_GREY, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_GRAY_BAR);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_AIO_EDIT, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_EDIT);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_FILE_EDIT, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_BOTTOM_EDIT);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_FILE_SHARE_EDIT, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_MENU_EDIT);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_ONLINE_PREVIEW, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_ONLINE_PREVIEW);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_OCR_SAVE, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_OCR_SAVE);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_URL_2_DOC, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_URL_2_DOC);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING, ITeamWorkUtils.TD_SOURCE_QQ_MINI_IMPORTING);
        hashMap2.put(ITeamWorkUtils.TD_SOURCE_QQ_AIO_ARK_H5, AppConstants.Preferences.DOCS_MINIAPP_CONFIG_AIO_ARK_H5);
        HashMap hashMap3 = new HashMap();
        f291564e = hashMap3;
        SparseArray<Pair<Integer, String>> sparseArray = new SparseArray<>();
        f291565f = sparseArray;
        SparseArray<Pair<Integer, String>> sparseArray2 = new SparseArray<>();
        f291566g = sparseArray2;
        hashMap3.put(FileReaderHelper.DOCX_EXT, 1);
        hashMap3.put("sheet", 2);
        hashMap3.put("form", 3);
        hashMap3.put(WinkDaTongReportConstant.ElementParamValue.BOTTOM_TAB_SWITCH_TYPE_SLIDE, 4);
        hashMap3.put(FileReaderHelper.PDF_EXT, 5);
        sparseArray.put(1, new Pair<>(Integer.valueOf(R.drawable.dgf), "static://DefaultTeamWorkMiniShareDoc"));
        sparseArray.put(2, new Pair<>(Integer.valueOf(R.drawable.f162438dh2), "static://DefaultTeamWorkMiniShareSheet"));
        sparseArray.put(3, new Pair<>(Integer.valueOf(R.drawable.dgy), "static://DefaultTeamWorkMiniShareForm"));
        sparseArray.put(4, new Pair<>(Integer.valueOf(R.drawable.f162440dh4), "static://DefaultTeamWorkMiniShareSlide"));
        sparseArray.put(5, new Pair<>(Integer.valueOf(R.drawable.f162436dh0), "static://DefaultTeamWorkMiniSharePdf"));
        sparseArray2.put(1, new Pair<>(Integer.valueOf(R.drawable.dge), "static://DefaultTeamWorkH5ShareDoc"));
        sparseArray2.put(2, new Pair<>(Integer.valueOf(R.drawable.f162437dh1), "static://DefaultTeamWorkH5ShareSheet"));
        sparseArray2.put(3, new Pair<>(Integer.valueOf(R.drawable.dgx), "static://DefaultTeamWorkH5ShareForm"));
        sparseArray2.put(4, new Pair<>(Integer.valueOf(R.drawable.f162439dh3), "static://DefaultTeamWorkH5ShareSlide"));
        sparseArray2.put(5, new Pair<>(Integer.valueOf(R.drawable.dgz), "static://DefaultTeamWorkH5SharePdf"));
        f291567h = 0L;
    }

    public static void b(String str, String str2, qb1.e eVar) {
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("tencent_doc_new_file_icon", true)) {
            ThreadManagerV2.excute(new AnonymousClass1(str, str2, eVar), 128, null, false);
            return;
        }
        if (com.tencent.mobileqq.filemanager.data.e.a(str)) {
            eVar.a("https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.doc.png");
            return;
        }
        if (com.tencent.mobileqq.filemanager.data.e.f(str)) {
            eVar.a("https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.sheet.png");
            return;
        }
        if (com.tencent.mobileqq.filemanager.data.e.b(str)) {
            eVar.a("https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.form.png");
            return;
        }
        if (com.tencent.mobileqq.filemanager.data.e.e(str)) {
            eVar.a("https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.slide.png");
            return;
        }
        if (com.tencent.mobileqq.filemanager.data.e.d(str)) {
            eVar.a("https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-pdf.png");
        } else if (com.tencent.mobileqq.filemanager.data.e.c(str)) {
            eVar.a("https://docs.gtimg.com/docs-design-resources/document-management/tencent-docs/png-200px/application-vnd.tdocs-apps.mind.png");
        } else {
            eVar.a("");
        }
    }

    public static void c(QQAppInterface qQAppInterface, Activity activity, TencentDocData tencentDocData, TeamWorkFileImportInfo teamWorkFileImportInfo) {
        boolean z16;
        boolean z17;
        int i3;
        Class<?> cls;
        ta1.l c16 = TencentDocLocalCooperationProcessor.c();
        if (c16 != null) {
            z16 = c16.b(teamWorkFileImportInfo.f292074f);
        } else {
            z16 = false;
        }
        int i16 = teamWorkFileImportInfo.f292070d;
        if ((i16 == 1 || i16 == 0 || i16 == 3000) && TextUtils.isEmpty(teamWorkFileImportInfo.f292071d0)) {
            z17 = true;
        } else {
            z17 = false;
        }
        Intent intent = new Intent();
        intent.putExtra("key_flag_from_plugin", true);
        intent.putExtra(ForwardRecentActivity.KEY_FORWARD_SHOW_DIRECT_SHARE_TIPS, true);
        intent.putExtra("forward_type", 1001);
        intent.putExtra(AppConstants.Key.SHARE_REQ_TYPE, 95);
        intent.putExtra("pluginName", "web_share");
        intent.putExtra(AppConstants.Key.SHARE_REQ_IMAGE_REMOTE_URL, tencentDocData.docIcon);
        StringBuilder sb5 = new StringBuilder();
        sb5.append(qQAppInterface.getCurrentNickname());
        sb5.append(HardCodeUtil.qqStr(R.string.u0u));
        if (z16) {
            i3 = R.string.u0l;
        } else {
            i3 = R.string.u0y;
        }
        sb5.append(HardCodeUtil.qqStr(i3));
        sb5.append("\u300a");
        sb5.append(tencentDocData.title);
        sb5.append("\u300b");
        String sb6 = sb5.toString();
        if (sb6 != null && sb6.length() > 45) {
            sb6 = sb6.substring(0, 45) + "\u2026";
        }
        intent.putExtra("title", sb6);
        String str = tencentDocData.summary;
        if (str != null && str.length() > 60) {
            str = str.substring(0, 60) + "\u2026";
        }
        intent.putExtra("desc", str);
        intent.putExtra("detail_url", tencentDocData.docUrl);
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_CONTENT_ACTION, "web");
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ACTION, "web");
        intent.putExtra(AppConstants.Key.STRUCT_SHARE_KEY_SOURCE_ICON, f291561b);
        intent.putExtra("app_name", activity.getString(R.string.hz5));
        intent.putExtra(AppConstants.Key.SHARE_SOURCE_URL, ITeamWorkUtils.DOCS_LIST_URL);
        intent.putExtra("forward _key_nojump", true);
        AbsStructMsg e16 = com.tencent.mobileqq.structmsg.i.e(intent.getExtras());
        if (e16 != null) {
            intent.putExtra(AppConstants.Key.STRUCT_MSG_BYTES, e16.getBytes());
            if (z17) {
                intent.putExtra("uintype", teamWorkFileImportInfo.f292070d);
                intent.putExtra("uin", teamWorkFileImportInfo.f292072e);
                intent.putExtra("troop_uin", teamWorkFileImportInfo.f292072e);
                intent.putExtra("uinname", com.tencent.mobileqq.utils.ac.Q(qQAppInterface, teamWorkFileImportInfo.f292072e, teamWorkFileImportInfo.f292070d));
            }
            StringBuilder sb7 = new StringBuilder(HardCodeUtil.qqStr(R.string.tzv));
            int i17 = teamWorkFileImportInfo.f292070d;
            if (i17 != 1 && i17 != 3000) {
                if (i17 == 0) {
                    sb7.append("\u597d\u53cb");
                }
            } else {
                sb7.append("\u7fa4\u6210\u5458");
            }
            if (z16) {
                sb7.append("\u4e00\u8d77\u7f16\u8f91\u6587\u6863\uff1a");
            } else {
                sb7.append("\u4e00\u8d77\u67e5\u770b\u6587\u6863\uff1a");
            }
            intent.putExtra(AppConstants.Key.KEY_SEND_TIPS, sb7.toString());
            if (!z17) {
                lr2.a.j(null, "0X800A5A1");
            } else {
                lr2.a.j(null, "0X800A5A2");
            }
            if (z17) {
                cls = DirectForwardActivity.class;
            } else {
                cls = ForwardRecentActivity.class;
            }
            intent.setClass(activity, cls);
            activity.startActivityForResult(intent, 2864);
        }
    }
}
