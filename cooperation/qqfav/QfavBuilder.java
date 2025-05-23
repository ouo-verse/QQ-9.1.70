package cooperation.qqfav;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.biz.qqcircle.immersive.request.search.QFSSearchBaseRequest;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.api.constant.GmCgConstants;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.ark.api.IArkConfig;
import com.tencent.mobileqq.ark.config.ArkMsgReplyConfigMgr;
import com.tencent.mobileqq.config.ar;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForArkApp;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.troop.TroopMemberNickInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.guild.message.msgtype.MessageRecordForMarkdown;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.shortvideo.j;
import com.tencent.mobileqq.troop.utils.ac;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IMsgConverterUtilsApi;
import com.tencent.qqnt.kernel.nativeinterface.FileElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgElement;
import com.tencent.qqnt.kernel.nativeinterface.MsgRecord;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.util.QQCustomArkDialogUtil;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import mqq.app.api.ProcessConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes28.dex */
public class QfavBuilder {

    /* renamed from: a, reason: collision with root package name */
    private Intent f390548a;

    /* renamed from: b, reason: collision with root package name */
    private Runnable f390549b = null;

    /* renamed from: c, reason: collision with root package name */
    private Handler f390550c = null;

    /* renamed from: d, reason: collision with root package name */
    private String f390551d = null;

    /* compiled from: P */
    /* loaded from: classes28.dex */
    class a implements Comparator<MsgElement> {
        a() {
        }

        @Override // java.util.Comparator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(MsgElement msgElement, MsgElement msgElement2) {
            return msgElement.fileElement.fileGroupIndex.intValue() - msgElement2.fileElement.fileGroupIndex.intValue();
        }
    }

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public interface b {
        void a(boolean z16);
    }

    public QfavBuilder(int i3) {
        Intent intent = new Intent();
        this.f390548a = intent;
        intent.putExtra("nType", i3);
    }

    public static void L(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp) {
        JSONObject jSONObject;
        try {
            JSONObject jSONObject2 = new JSONObject(messageForArkApp.ark_app_message.metaList);
            if (jSONObject2.has("contact")) {
                jSONObject = jSONObject2.optJSONObject("contact");
            } else {
                jSONObject = null;
            }
            if (jSONObject == null) {
                return;
            }
            ArrayList<byte[]> arrayList = new ArrayList<>();
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("bNameplateArkFav", true);
            byte[] bytes = jSONObject3.toString().getBytes();
            if (bytes != null) {
                arrayList.add(bytes);
            }
            JSONObject jSONObject4 = new JSONObject(messageForArkApp.ark_app_message.toAppXml());
            arrayList.add(jSONObject4.toString().getBytes());
            String optString = jSONObject.optString("nickname");
            String optString2 = jSONObject.optString("contactInfo");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(com.tencent.mobileqq.profile.util.b.g(jSONObject4.toString()));
            h0(arrayList2, false, optString, optString2, false, 0L, "").G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, qQAppInterface.getAccount());
        } catch (JSONException unused) {
            QLog.e(ProcessConstant.QQFAV, 1, "createProfileCardArkShareFav is error!");
        }
    }

    private static void P(String str, String str2, QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        d91.f arkFavConfig = ((IArkConfig) QRoute.api(IArkConfig.class)).getArkFavConfig();
        if (arkFavConfig != null && arkFavConfig.a() != null && arkFavConfig.a().size() != 0) {
            if (!TextUtils.isEmpty(str2)) {
                for (e91.e eVar : arkFavConfig.a()) {
                    if ((str + str2).equals(eVar.a() + eVar.c())) {
                        s(eVar, qQAppInterface, context, chatMessage, messageForArkApp, jSONObject);
                        return;
                    }
                }
            }
            for (e91.e eVar2 : arkFavConfig.a()) {
                if (str.equals(eVar2.a())) {
                    s(eVar2, qQAppInterface, context, chatMessage, messageForArkApp, jSONObject);
                    return;
                }
            }
            l(qQAppInterface, context, chatMessage, messageForArkApp, jSONObject);
            return;
        }
        l(qQAppInterface, context, chatMessage, messageForArkApp, jSONObject);
    }

    private void S(final Context context, final String str, final Intent intent, final int i3, final boolean z16) {
        this.f390549b = new Runnable() { // from class: cooperation.qqfav.QfavBuilder.3
            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(QfavBuilder.this.f390551d)) {
                    intent.putExtra("sName", QfavBuilder.this.f390551d);
                }
                QfavPluginProxyActivity.M2(context, str, intent, i3, z16);
                QfavBuilder.this.f390549b = null;
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void U(Context context, QQAppInterface qQAppInterface, boolean z16, String str) {
        QfavHelper.B(context, qQAppInterface.getAccount(), z16, str, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Unit V(TroopMemberNickInfo troopMemberNickInfo) {
        if (troopMemberNickInfo != null && !troopMemberNickInfo.getShowName().equals(troopMemberNickInfo.getUin())) {
            this.f390551d = troopMemberNickInfo.getShowName();
            return null;
        }
        return null;
    }

    public static void W(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage) {
        ArkAppMessage arkAppMessage;
        boolean z16;
        String string;
        String optString;
        int i3;
        MessageForArkApp messageForArkApp = (MessageForArkApp) chatMessage;
        if (messageForArkApp != null && (arkAppMessage = messageForArkApp.ark_app_message) != null) {
            MessageForArkApp messageForArkApp2 = (MessageForArkApp) com.tencent.mobileqq.ark.e.a(1, arkAppMessage.appName, messageForArkApp, messageForArkApp);
            if (messageForArkApp2 == null) {
                messageForArkApp2 = messageForArkApp;
            }
            if (messageForArkApp2.ark_app_message == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject(messageForArkApp2.ark_app_message.metaList);
                if (ar.f202319a.equals(messageForArkApp.ark_app_message.appName)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject("Location.Search");
                    b0(Float.parseFloat(jSONObject2.getString(QCircleSchemeAttr.Polymerize.LAT)), Float.parseFloat(jSONObject2.getString("lng")), jSONObject2.getString("name"), jSONObject2.getString("address"), "").R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
                    d.b(qQAppInterface, 11, 0, chatMessage.istroop);
                    return;
                }
                JSONObject jSONObject3 = null;
                if ("com.tencent.structmsg".equals(messageForArkApp.ark_app_message.appName)) {
                    if (jSONObject.has("music")) {
                        jSONObject3 = jSONObject.getJSONObject("music");
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (jSONObject.has("news")) {
                        jSONObject3 = jSONObject.getJSONObject("news");
                    }
                    JSONObject jSONObject4 = jSONObject3;
                    if (jSONObject4 != null) {
                        if (z16) {
                            string = context.getString(R.string.vxz);
                        } else {
                            string = jSONObject4.getString("title");
                        }
                        String str = string;
                        if (z16) {
                            optString = jSONObject4.getString("title") + "-" + jSONObject4.optString("desc");
                        } else {
                            optString = jSONObject4.optString("desc");
                        }
                        String str2 = optString;
                        String optString2 = jSONObject4.optString("tag");
                        String string2 = jSONObject4.getString("preview");
                        String string3 = jSONObject4.getString(WadlProxyConsts.KEY_JUMP_URL);
                        String optString3 = jSONObject4.optString("musicUrl", "");
                        Long valueOf = Long.valueOf(jSONObject4.getLong("appid"));
                        if (valueOf.longValue() == 100243533 || valueOf.longValue() == 100497308 || valueOf.longValue() == 100495085 || valueOf.longValue() == 205141 || valueOf.longValue() == 100895899) {
                            z16 = true;
                        }
                        if (!string3.startsWith("http")) {
                            return;
                        }
                        byte[] bytes = messageForArkApp2.ark_app_message.toAppXml().getBytes();
                        ArrayList<byte[]> arrayList = new ArrayList<>();
                        arrayList.add(bytes);
                        if (z16) {
                            i3 = 4;
                        } else {
                            i3 = 5;
                        }
                        Z(i3, str, string3, optString2, str2, string2, optString3, null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
                        d.b(qQAppInterface, 9, 0, chatMessage.istroop);
                        return;
                    }
                    d.b(qQAppInterface, 8, 0, chatMessage.istroop);
                    return;
                }
                if ("com.tencent.miniapp_01".equals(messageForArkApp.ark_app_message.appName)) {
                    if (jSONObject.has("detail_1")) {
                        jSONObject3 = jSONObject.getJSONObject("detail_1");
                    }
                    JSONObject jSONObject5 = jSONObject3;
                    if (jSONObject5 == null) {
                        return;
                    }
                    String string4 = jSONObject5.getString("title");
                    String optString4 = jSONObject5.optString("desc");
                    String string5 = jSONObject5.getString("preview");
                    String string6 = jSONObject5.getString("url");
                    String string7 = jSONObject5.getString("icon");
                    Long valueOf2 = Long.valueOf(jSONObject5.getLong("appid"));
                    String str3 = messageForArkApp2.ark_app_message.promptText;
                    ArrayList<byte[]> arrayList2 = new ArrayList<>();
                    JSONObject jSONObject6 = new JSONObject();
                    jSONObject6.put("appName", messageForArkApp2.ark_app_message.appName);
                    jSONObject6.put(QQCustomArkDialogUtil.APP_VIEW, messageForArkApp2.ark_app_message.appView);
                    jSONObject6.put(QQCustomArkDialogUtil.META_DATA, messageForArkApp2.ark_app_message.metaList);
                    jSONObject6.put(QQCustomArkDialogUtil.APP_MIN_VERSION, messageForArkApp2.ark_app_message.appMinVersion);
                    jSONObject6.put("appConfig", messageForArkApp2.ark_app_message.config);
                    jSONObject6.put(MessageRecordForMarkdown.MSG_MARKDOWN_COMPATIBLE_TEXT, messageForArkApp2.ark_app_message.compatibleText);
                    jSONObject6.put(QFSSearchBaseRequest.EXTRA_KEY_PROMPT_TEXT, messageForArkApp2.ark_app_message.promptText);
                    jSONObject6.put("appDesc", optString4);
                    JSONObject jSONObject7 = new JSONObject();
                    jSONObject7.put("arkAppInfo", jSONObject6);
                    arrayList2.add(jSONObject7.toString().getBytes());
                    if (!TextUtils.isEmpty(string5) && !string5.startsWith("http")) {
                        string5 = "https://" + string5;
                    }
                    Z(8, context.getString(R.string.zxl) + string4, string6, str3, optString4, string5, string7, null, false, valueOf2.longValue()).G("sBizDataList", arrayList2).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
                    return;
                }
                if (ArkMsgReplyConfigMgr.ARK_REPLY_FROM_TYPE_CARD_ARK_APP.equals(messageForArkApp.ark_app_message.appName)) {
                    L(qQAppInterface, context, chatMessage, messageForArkApp2);
                    return;
                }
                if ("com.tencent.tuwen.lua".equals(messageForArkApp.ark_app_message.appName)) {
                    r(qQAppInterface, context, chatMessage, messageForArkApp2, jSONObject);
                    return;
                }
                if ("com.tencent.music.lua".equals(messageForArkApp.ark_app_message.appName)) {
                    p(qQAppInterface, context, chatMessage, messageForArkApp2, jSONObject);
                    return;
                }
                if ("com.tencent.contact.lua".equals(messageForArkApp.ark_app_message.appName)) {
                    m(qQAppInterface, context, chatMessage, messageForArkApp2, jSONObject);
                    return;
                }
                if ("com.tencent.picture.lua".equals(messageForArkApp.ark_app_message.appName)) {
                    q(qQAppInterface, context, chatMessage, messageForArkApp2, jSONObject);
                    return;
                }
                if ("com.tencent.gameinvite.lua".equals(messageForArkApp.ark_app_message.appName)) {
                    n(qQAppInterface, context, chatMessage, messageForArkApp2, jSONObject);
                } else if ("com.tencent.miniapp.lua".equals(messageForArkApp.ark_app_message.appName)) {
                    o(qQAppInterface, context, chatMessage, messageForArkApp2, jSONObject);
                } else {
                    ArkAppMessage arkAppMessage2 = messageForArkApp.ark_app_message;
                    P(arkAppMessage2.appName, arkAppMessage2.bizSrc, qQAppInterface, context, chatMessage, messageForArkApp2, jSONObject);
                }
            } catch (Exception e16) {
                QLog.e(ProcessConstant.QQFAV, 1, e16, new Object[0]);
            }
        }
    }

    public static QfavBuilder X(String str, int i3, String str2) {
        return new QfavBuilder(4).m0("sPath", str).Q("nDuration", i3).m0("sBrief", str2);
    }

    public static QfavBuilder Y() {
        return new QfavBuilder(3);
    }

    public static QfavBuilder Z(int i3, String str, String str2, String str3, String str4, String str5, String str6, byte[] bArr, boolean z16, long j3) {
        long j16;
        if (bArr != null) {
            String[] M = QfavUtil.M(bArr);
            str = QfavUtil.a(M[0], str);
            str2 = QfavUtil.a(M[1], str2);
            str3 = QfavUtil.a(M[2], str3);
            str4 = QfavUtil.a(M[3], str4);
            str5 = QfavUtil.a(M[4], str5);
            str6 = QfavUtil.a(M[5], str6);
        }
        QfavBuilder m06 = new QfavBuilder(6).Q("nLinkType", i3).m0("sTitle", str).m0("sUrl", str2).H("bAppShare", z16).T("lAppId", j3).m0("sPublisher", str3).m0("sBrief", str4).m0("sPath", str5).m0("sResUrl", str6);
        if (z16) {
            j16 = 4;
        } else {
            j16 = 1;
        }
        return m06.T("lCategory", j16);
    }

    public static QfavBuilder a0(String str) {
        return new QfavBuilder(6).m0("sUrl", str);
    }

    public static QfavBuilder b0(float f16, float f17, String str, String str2, String str3) {
        return new QfavBuilder(7).m0("sLocation", str2).m0("sBrief", str3).m0("sPublisher", str).N("fLatitude", f16).N("fLongitude", f17);
    }

    public static QfavBuilder c0(QQAppInterface qQAppInterface, Contact contact, MessageForStructing messageForStructing, List<ChatMessage> list, Map<String, String> map) {
        long j3;
        if (messageForStructing != null && messageForStructing.structingMsg != null) {
            QfavBuilder M = new QfavBuilder(8).M(messageForStructing);
            if (!QfavUtil.C(messageForStructing)) {
                return M;
            }
            ArrayList<byte[]> arrayList = new ArrayList<>();
            byte[] L = QfavUtil.L(messageForStructing.uniseq, messageForStructing.structingMsg);
            if (L != null) {
                arrayList.add(L);
            }
            if (list != null && list.size() != 0) {
                j3 = list.size();
            } else {
                j3 = 1;
            }
            byte[] I = QfavUtil.I(messageForStructing.uniseq, j3);
            if (I != null) {
                arrayList.add(I);
            }
            byte[] J = QfavUtil.J(-1L, map);
            if (J != null) {
                arrayList.add(J);
            }
            QfavUtil.K(qQAppInterface, contact, messageForStructing, null, list, map, arrayList);
            M.G("sBizDataList", arrayList);
            return M;
        }
        return null;
    }

    public static QfavBuilder d0(Entity entity) {
        return new QfavBuilder(2).M(entity);
    }

    public static QfavBuilder e0(String str) {
        return new QfavBuilder(2).m0("sPath", str);
    }

    public static QfavBuilder f0(String str, int i3, String str2, long j3, String str3, long j16) {
        int u16 = QfavUtil.u(i3);
        if (str2 == null) {
            str2 = "";
        }
        if (4 == u16 || 5 == u16) {
            str2 = String.valueOf(j3);
        }
        return new QfavBuilder(2).m0("sMD5", str).m0("sPath", str3).Q("nPicType", u16).m0("sPicId", str2).T("lSize", j16);
    }

    public static QfavBuilder g0(Entity entity) {
        return new QfavBuilder(8).M(entity);
    }

    public static QfavBuilder h0(ArrayList<String> arrayList, boolean z16, String str, String str2, boolean z17, long j3, String str3) {
        long j16;
        QfavBuilder m06 = new QfavBuilder(8).n0("sPathList", arrayList).m0("sTitle", str).H("bOnlyPic", z16).m0("sText", str2).H("bAppShare", z17).T("lAppId", j3).m0("sAppName", str3);
        if (z17) {
            j16 = 4;
        } else {
            j16 = 1;
        }
        return m06.T("lCategory", j16);
    }

    public static QfavBuilder i0(Intent intent) {
        int i3;
        long j3;
        int intExtra;
        if (intent == null) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        int intExtra2 = intent.getIntExtra(ShortVideoConstants.FROM_BUSI_TYPE, 1);
        if (intExtra2 == 0) {
            i3 = 1;
        } else {
            i3 = intExtra2;
        }
        contentValues.put("shortVideoBusiType", Integer.valueOf(i3));
        contentValues.put("shortVideoDuration", Integer.valueOf(intent.getIntExtra(ShortVideoConstants.FILE_SEND_DURATION, 0)));
        contentValues.put("shortVideoFormat", Integer.valueOf(intent.getIntExtra(ShortVideoConstants.FILE_FORMAT, 0)));
        String stringExtra = intent.getStringExtra("file_send_path");
        contentValues.put("shortVideoLocalPath", stringExtra);
        contentValues.put("shortVideoMd5", intent.getStringExtra(ShortVideoConstants.FILE_SHORTVIDEO_MD5));
        if (new File(stringExtra).exists()) {
            j3 = new File(stringExtra).length();
        } else {
            j3 = 0;
        }
        contentValues.put("shortVideoSize", Long.valueOf(j3));
        String stringExtra2 = intent.getStringExtra("file_name");
        contentValues.put("shortVideoFileName", stringExtra2.substring(stringExtra2.lastIndexOf(47) + 1));
        contentValues.put("shortVideoThumbHeight", Integer.valueOf(intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_HEIGHT, 0)));
        contentValues.put("shortVideoThumbMd5", intent.getStringExtra(ShortVideoConstants.THUMBFILE_MD5));
        if (new File(stringExtra).exists()) {
            intExtra = (int) new File(stringExtra).length();
        } else {
            intExtra = intent.getIntExtra(ShortVideoConstants.FILE_THUMB_SIZE, 0);
        }
        contentValues.put("shortVideoThumbSize", Integer.valueOf(intExtra));
        contentValues.put("shortVideoThumbWidth", Integer.valueOf(intent.getIntExtra(ShortVideoConstants.THUMBFILE_SEND_WIDTH, 0)));
        contentValues.put("shortVideoThumbLocalPath", intent.getStringExtra(ShortVideoConstants.THUMBFILE_SEND_PATH));
        contentValues.put("shortVideoUuid", intent.getStringExtra(ShortVideoConstants.FILE_UUID));
        QfavBuilder qfavBuilder = new QfavBuilder(5);
        qfavBuilder.f390548a.putExtra("shortVideoContents", contentValues);
        if (intExtra2 == 0) {
            qfavBuilder.f390548a.putExtra("sBizDataList", QfavHelper.k());
        }
        return qfavBuilder.F(intent.getStringExtra(ShortVideoConstants.FROM_UIN));
    }

    public static QfavBuilder j0(MessageForShortVideo messageForShortVideo) {
        long j3;
        ContentValues contentValues = new ContentValues();
        contentValues.put("shortVideoDuration", Integer.valueOf(messageForShortVideo.videoFileTime));
        contentValues.put("shortVideoFileTYPE", Integer.valueOf(messageForShortVideo.fileType));
        contentValues.put("shortVideoFormat", Integer.valueOf(messageForShortVideo.videoFileFormat));
        contentValues.put("shortVideoMd5", messageForShortVideo.md5);
        int i3 = messageForShortVideo.busiType;
        if (i3 == 0) {
            i3 = 1;
        }
        contentValues.put("shortVideoBusiType", Integer.valueOf(i3));
        String findVideoPathIfExists = ShortVideoUtils.findVideoPathIfExists(messageForShortVideo);
        if (TextUtils.isEmpty(findVideoPathIfExists) || !new File(findVideoPathIfExists).exists()) {
            findVideoPathIfExists = messageForShortVideo.videoFileName;
        }
        contentValues.put("shortVideoLocalPath", findVideoPathIfExists);
        long j16 = messageForShortVideo.videoFileSize;
        if (findVideoPathIfExists != null && new File(findVideoPathIfExists).exists()) {
            j16 = new File(findVideoPathIfExists).length();
        }
        contentValues.put("shortVideoSize", Long.valueOf(j16));
        if (findVideoPathIfExists == null) {
            findVideoPathIfExists = "";
        }
        contentValues.put("shortVideoFileName", findVideoPathIfExists.substring(findVideoPathIfExists.lastIndexOf(47) + 1));
        contentValues.put("shortVideoThumbHeight", Integer.valueOf(messageForShortVideo.thumbHeight));
        contentValues.put("shortVideoThumbMd5", messageForShortVideo.thumbMD5);
        contentValues.put("shortVideoThumbWidth", Integer.valueOf(messageForShortVideo.thumbWidth));
        String str = messageForShortVideo.mThumbFilePath;
        if (TextUtils.isEmpty(str) || !new File(str).exists()) {
            str = j.l(messageForShortVideo.thumbMD5, "jpg");
        }
        if (new File(str).exists()) {
            j3 = new File(str).length();
        } else {
            j3 = messageForShortVideo.thumbFileSize;
        }
        contentValues.put("shortVideoThumbSize", Long.valueOf(j3));
        contentValues.put("shortVideoThumbLocalPath", str);
        contentValues.put("shortVideoUuid", messageForShortVideo.uuid);
        QfavBuilder qfavBuilder = new QfavBuilder(5);
        qfavBuilder.f390548a.putExtra("shortVideoContents", contentValues);
        if (messageForShortVideo.busiType == 0) {
            qfavBuilder.f390548a.putExtra("sBizDataList", QfavHelper.k());
        }
        return qfavBuilder;
    }

    public static QfavBuilder k0(String str, String str2) {
        return new QfavBuilder(1).m0("sText", str2).m0("sTitle", str);
    }

    private static void l(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        String str;
        try {
            String arkMetaValue = MessageForArkApp.getArkMetaValue(jSONObject.toString(), "title");
            String arkMetaValue2 = MessageForArkApp.getArkMetaValue(jSONObject.toString(), "source");
            String arkMetaValue3 = MessageForArkApp.getArkMetaValue(jSONObject.toString(), "tag");
            String arkMetaValue4 = MessageForArkApp.getArkMetaValue(jSONObject.toString(), "desc");
            String arkMetaValue5 = MessageForArkApp.getArkMetaValue(jSONObject.toString(), "preview");
            String arkMetaValue6 = MessageForArkApp.getArkMetaValue(jSONObject.toString(), WadlProxyConsts.KEY_JUMP_URL);
            if (TextUtils.isEmpty(arkMetaValue6)) {
                arkMetaValue6 = MessageForArkApp.getArkMetaValue(jSONObject.toString(), "jumpURL");
            }
            String str2 = arkMetaValue6;
            String arkMetaValue7 = MessageForArkApp.getArkMetaValue(jSONObject.toString(), "musicUrl");
            byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(bytes);
            if (TextUtils.isEmpty(arkMetaValue2)) {
                str = arkMetaValue3;
            } else {
                str = arkMetaValue2;
            }
            Z(5, arkMetaValue, str2, str, arkMetaValue4, arkMetaValue5, arkMetaValue7, null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.senderuin);
            d.b(qQAppInterface, 9, 0, chatMessage.istroop);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public static void l0(Activity activity, Intent intent) {
        if (intent != null) {
            QfavHelper.B(activity, intent.getStringExtra("lUin"), !intent.getBooleanExtra("bFailed", false), null, false);
        }
    }

    private static void m(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("contact");
            if (optJSONObject == null) {
                d.b(qQAppInterface, 8, 0, chatMessage.istroop);
                return;
            }
            String optString = optJSONObject.optString("avatar");
            String optString2 = optJSONObject.optString("nickname");
            String optString3 = optJSONObject.optString("contact");
            String optString4 = optJSONObject.optString("tag");
            optJSONObject.optString("tagIcon");
            String optString5 = optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(bytes);
            Z(5, optString2, optString5, optString4, optString3, optString, "", null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
            d.b(qQAppInterface, 9, 0, chatMessage.istroop);
        } catch (Exception e16) {
            QLog.e(ProcessConstant.QQFAV, 1, "addFavFromContactTemplate e = " + e16);
        }
    }

    private static void n(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("invite");
            if (optJSONObject == null) {
                d.b(qQAppInterface, 8, 0, chatMessage.istroop);
                return;
            }
            String optString = optJSONObject.optString("title");
            String optString2 = optJSONObject.optString("background");
            String optString3 = optJSONObject.optString("tag");
            optJSONObject.optString("tagIcon");
            String optString4 = optJSONObject.optString("jumpURL");
            byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(bytes);
            Z(5, optString3, optString4, optString3, optString, optString2, "", null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
            d.b(qQAppInterface, 9, 0, chatMessage.istroop);
        } catch (Exception e16) {
            QLog.e(ProcessConstant.QQFAV, 1, "addFavFromGameInviteTemplate e = " + e16);
        }
    }

    private static void o(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        String str;
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("miniapp");
            if (optJSONObject == null) {
                return;
            }
            String optString = optJSONObject.optString("title");
            String optString2 = optJSONObject.optString("preview");
            String optString3 = optJSONObject.optString("tag");
            optJSONObject.optString("tagIcon");
            String optString4 = optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(bytes);
            if (TextUtils.isEmpty(optString)) {
                str = QzoneConfig.DEFAULT_MINI_APP_FULL_SCREEN_TITLE;
            } else {
                str = optString3;
            }
            Z(5, str, optString4, optString3, optString, optString2, "", null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
            d.b(qQAppInterface, 9, 0, chatMessage.istroop);
        } catch (Exception e16) {
            QLog.e(ProcessConstant.QQFAV, 1, "addFavFromMiniTemplate e = " + e16);
        }
    }

    private static void p(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("music");
            if (optJSONObject == null) {
                d.b(qQAppInterface, 8, 0, chatMessage.istroop);
                return;
            }
            String string = context.getString(R.string.vxz);
            String str = optJSONObject.getString("title") + "-" + optJSONObject.optString("desc");
            String optString = optJSONObject.optString("tag");
            String string2 = optJSONObject.getString("preview");
            String string3 = optJSONObject.getString(WadlProxyConsts.KEY_JUMP_URL);
            String optString2 = optJSONObject.optString("musicUrl", "");
            if (!string3.startsWith("http")) {
                return;
            }
            byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(bytes);
            Z(4, string, string3, optString, str, string2, optString2, null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
            d.b(qQAppInterface, 9, 0, chatMessage.istroop);
        } catch (Exception e16) {
            QLog.e(ProcessConstant.QQFAV, 1, "addFavFromTuwenTemplate e = " + e16);
        }
    }

    private static void q(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("pic");
            if (optJSONObject == null) {
                d.b(qQAppInterface, 8, 0, chatMessage.istroop);
                return;
            }
            String optString = optJSONObject.optString("preview");
            String optString2 = optJSONObject.optString("tag");
            optJSONObject.optString("tagIcon");
            String optString3 = optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(bytes);
            Z(5, "\u56fe\u7247", optString3, optString2, optString2, optString, "", null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
            d.b(qQAppInterface, 9, 0, chatMessage.istroop);
        } catch (Exception e16) {
            QLog.e(ProcessConstant.QQFAV, 1, "addFavFromPicTemplate e = " + e16);
        }
    }

    private static void r(QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        try {
            JSONObject optJSONObject = jSONObject.optJSONObject("news");
            if (optJSONObject == null) {
                d.b(qQAppInterface, 8, 0, chatMessage.istroop);
                return;
            }
            String string = optJSONObject.getString("title");
            String optString = optJSONObject.optString("desc");
            String optString2 = optJSONObject.optString("tag");
            String string2 = optJSONObject.getString("preview");
            String string3 = optJSONObject.getString(WadlProxyConsts.KEY_JUMP_URL);
            String optString3 = optJSONObject.optString("musicUrl", "");
            if (!string3.startsWith("http")) {
                return;
            }
            byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
            ArrayList<byte[]> arrayList = new ArrayList<>();
            arrayList.add(bytes);
            Z(5, string, string3, optString2, optString, string2, optString3, null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
            d.b(qQAppInterface, 9, 0, chatMessage.istroop);
        } catch (Exception e16) {
            QLog.e(ProcessConstant.QQFAV, 1, "addFavFromTuwenTemplate e = " + e16);
        }
    }

    private static void s(e91.e eVar, QQAppInterface qQAppInterface, Context context, ChatMessage chatMessage, MessageForArkApp messageForArkApp, JSONObject jSONObject) {
        if (eVar != null && !TextUtils.isEmpty(eVar.b())) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(eVar.b());
                if (optJSONObject == null) {
                    d.b(qQAppInterface, 8, 0, chatMessage.istroop);
                    return;
                }
                int i3 = eVar.i();
                String optString = optJSONObject.optString(eVar.h());
                String optString2 = optJSONObject.optString(eVar.d());
                String optString3 = optJSONObject.optString(eVar.g());
                String optString4 = optJSONObject.optString(eVar.f());
                String optString5 = optJSONObject.optString(eVar.e());
                String optString6 = optJSONObject.optString(eVar.j());
                if (eVar.k() && !optString5.startsWith("http")) {
                    return;
                }
                byte[] bytes = messageForArkApp.ark_app_message.toAppXml().getBytes();
                ArrayList<byte[]> arrayList = new ArrayList<>();
                arrayList.add(bytes);
                Z(i3, optString, optString5, optString3, optString2, optString4, optString6, null, false, 0L).G("sBizDataList", arrayList).R(qQAppInterface, chatMessage).h((Activity) context, chatMessage.selfuin);
                d.b(qQAppInterface, 9, 0, chatMessage.istroop);
            } catch (Exception e16) {
                QLog.e(ProcessConstant.QQFAV, 1, "addFavTemplate " + eVar.a() + " error =" + e16);
            }
        }
    }

    public QfavBuilder A(int i3, long j3, String str, long j16, String str2) {
        this.f390548a.putExtra("nAuthorType", i3).putExtra("lUin", j3).putExtra("sName", str).putExtra("lGroupUin", j16).putExtra("sGroupName", str2);
        return this;
    }

    public QfavBuilder B(long j3, String str) {
        this.f390548a.putExtra("nAuthorType", 1).putExtra("lUin", j3).putExtra("sName", str);
        return this;
    }

    public QfavBuilder C(QQAppInterface qQAppInterface) {
        if (qQAppInterface == null) {
            return this;
        }
        return B(Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue(), qQAppInterface.getCurrentNickname());
    }

    public QfavBuilder D(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        if (messageRecord != null && qQAppInterface != null) {
            return E(qQAppInterface, messageRecord, messageRecord.senderuin, messageRecord.frienduin, messageRecord.issend, messageRecord.istroop);
        }
        return this;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:5|(1:7)(1:107)|(3:8|9|10)|(2:12|13)(20:66|(2:(1:69)(1:71)|70)(4:(18:(2:78|79)|82|83|(1:86)|87|88|(1:90)(1:96)|91|92|(3:58|59|(1:65))|17|(1:19)|20|(8:(3:34|35|(3:(1:41)(1:48)|42|43)(1:39))|57|53|35|(1:37)|(0)(0)|42|43)|24|(1:28)|29|30)|99|100|101)|15|(0)|17|(0)|20|(1:22)|(10:34|35|(0)|(0)(0)|42|43|24|(2:26|28)|29|30)|57|53|35|(0)|(0)(0)|42|43|24|(0)|29|30)|14|15|(0)|17|(0)|20|(0)|(0)|57|53|35|(0)|(0)(0)|42|43|24|(0)|29|30) */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0147, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0148, code lost:
    
        r16 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x010c, code lost:
    
        r13 = (com.tencent.mobileqq.app.TroopManager) r20.getManager(com.tencent.mobileqq.app.QQManagerFactory.TROOP_MANAGER);
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0114, code lost:
    
        if (r13 == null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0116, code lost:
    
        r13 = r13.G(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x011b, code lost:
    
        r13 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0074, code lost:
    
        r19.f390550c = new android.os.Handler(com.tencent.mobileqq.app.ThreadManagerV2.getQQCommonThreadLooper());
        ((com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi) com.tencent.mobileqq.qroute.QRoute.api(com.tencent.qqnt.troopmemberlist.ITroopMemberListRepoApi.class)).fetchTroopMemberName(r23, r4, mqq.app.api.ProcessConstant.QQFAV, new cooperation.qqfav.a(r19));
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00f8 A[Catch: Exception -> 0x014b, TryCatch #2 {Exception -> 0x014b, blocks: (B:59:0x00d5, B:61:0x00db, B:63:0x00df, B:65:0x00e7, B:17:0x00f2, B:19:0x00f8, B:50:0x010c, B:52:0x0116, B:53:0x011e), top: B:58:0x00d5 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0102 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012d  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QfavBuilder E(QQAppInterface qQAppInterface, MessageRecord messageRecord, String str, String str2, int i3, int i16) {
        int i17;
        int i18;
        String str3;
        String str4;
        long j3;
        long j16;
        long longValue;
        String str5;
        ac.a a16;
        long longValue2;
        String str6;
        if (qQAppInterface == null) {
            return this;
        }
        int r16 = QfavUtil.r(i16);
        String str7 = null;
        if (TextUtils.isEmpty(str)) {
            str3 = str2;
            i17 = 0;
            i18 = 1;
        } else {
            i17 = i16;
            i18 = r16;
            str3 = str;
        }
        try {
            try {
            } catch (Exception e16) {
                e = e16;
                str4 = "";
                j3 = 0;
                j16 = 0;
                e.printStackTrace();
                String K = K(messageRecord, str3, str7);
                if (str2 != null) {
                }
                return A(i18, j3, K, j16, str4);
            }
        } catch (Exception e17) {
            e = e17;
            str7 = "";
            str4 = str7;
        }
        if (com.tencent.mobileqq.service.message.remote.a.b(i3)) {
            str7 = qQAppInterface.getCurrentNickname();
            longValue = Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue();
        } else {
            if (i17 == 1006) {
                if (str3 == null) {
                    str7 = "";
                    str4 = str7;
                } else {
                    str7 = com.tencent.mobileqq.utils.ac.R(qQAppInterface, str3, i17);
                    str4 = "";
                }
                j3 = 0;
            } else {
                if (i17 != 1004 && i17 != 1000) {
                    if (i17 != 1 && i17 != 3000) {
                        str7 = com.tencent.mobileqq.utils.ac.R(qQAppInterface, str3, i17);
                        longValue = Long.valueOf(str3).longValue();
                    }
                    str7 = com.tencent.mobileqq.utils.ac.R(qQAppInterface, str3, 0);
                    if (str7.equals(str3) && i17 == 3000) {
                        str7 = com.tencent.mobileqq.utils.ac.l(qQAppInterface, str2, str3);
                    }
                    j3 = Long.valueOf(str3).longValue();
                    try {
                        if (1 == i17) {
                            str4 = com.tencent.mobileqq.utils.ac.g0(qQAppInterface, str2, true);
                        } else {
                            str4 = com.tencent.mobileqq.utils.ac.q(qQAppInterface, str2);
                        }
                    } catch (Exception e18) {
                        e = e18;
                        str4 = "";
                    }
                    try {
                        j16 = Long.valueOf(str2).longValue();
                        if (messageRecord != null) {
                            try {
                                if (com.tencent.biz.anonymous.a.m(messageRecord) && ((str5 = messageRecord.selfuin) == null || !str5.equals(messageRecord.senderuin))) {
                                    str7 = BaseApplication.getContext().getString(R.string.f170339mq);
                                }
                            } catch (Exception e19) {
                                e = e19;
                                e.printStackTrace();
                                String K2 = K(messageRecord, str3, str7);
                                if (str2 != null) {
                                }
                                return A(i18, j3, K2, j16, str4);
                            }
                        }
                        a16 = ac.a(messageRecord);
                        if (a16 != null) {
                            str7 = a16.f301997d;
                        }
                        if (2 != i18 || 3 == i18) {
                            if (1 != i17 && 1000 != i17) {
                                longValue2 = j16;
                                if (i17 == 1004 && i17 != 3000) {
                                    j16 = longValue2;
                                } else {
                                    if (i17 == 1004) {
                                        str6 = str3;
                                    } else {
                                        str6 = str2;
                                    }
                                    str4 = com.tencent.mobileqq.utils.ac.q(qQAppInterface, str6);
                                    j16 = Long.valueOf(str6).longValue();
                                }
                            }
                            String str8 = str2;
                            str4 = com.tencent.mobileqq.utils.ac.g0(qQAppInterface, str8, true);
                            longValue2 = Long.valueOf(str8).longValue();
                            if (i17 == 1004) {
                            }
                            if (i17 == 1004) {
                            }
                            str4 = com.tencent.mobileqq.utils.ac.q(qQAppInterface, str6);
                            j16 = Long.valueOf(str6).longValue();
                        }
                    } catch (Exception e26) {
                        e = e26;
                        j16 = 0;
                        e.printStackTrace();
                        String K22 = K(messageRecord, str3, str7);
                        if (str2 != null) {
                        }
                        return A(i18, j3, K22, j16, str4);
                    }
                    String K222 = K(messageRecord, str3, str7);
                    if (str2 != null && str2.equals(str4)) {
                        str4 = "";
                    }
                    return A(i18, j3, K222, j16, str4);
                }
                str7 = com.tencent.mobileqq.utils.ac.R(qQAppInterface, str2, i17);
                j3 = Long.valueOf(str2).longValue();
                str4 = "";
            }
            j16 = 0;
            if (messageRecord != null) {
            }
            a16 = ac.a(messageRecord);
            if (a16 != null) {
            }
            if (2 != i18) {
            }
            if (1 != i17) {
                longValue2 = j16;
                if (i17 == 1004) {
                }
                if (i17 == 1004) {
                }
                str4 = com.tencent.mobileqq.utils.ac.q(qQAppInterface, str6);
                j16 = Long.valueOf(str6).longValue();
                String K2222 = K(messageRecord, str3, str7);
                if (str2 != null) {
                    str4 = "";
                }
                return A(i18, j3, K2222, j16, str4);
            }
            String str82 = str2;
            str4 = com.tencent.mobileqq.utils.ac.g0(qQAppInterface, str82, true);
            longValue2 = Long.valueOf(str82).longValue();
            if (i17 == 1004) {
            }
            if (i17 == 1004) {
            }
            str4 = com.tencent.mobileqq.utils.ac.q(qQAppInterface, str6);
            j16 = Long.valueOf(str6).longValue();
            String K22222 = K(messageRecord, str3, str7);
            if (str2 != null) {
            }
            return A(i18, j3, K22222, j16, str4);
        }
        str4 = "";
        j3 = longValue;
        j16 = 0;
        if (messageRecord != null) {
        }
        a16 = ac.a(messageRecord);
        if (a16 != null) {
        }
        if (2 != i18) {
        }
        if (1 != i17) {
        }
        String str822 = str2;
        str4 = com.tencent.mobileqq.utils.ac.g0(qQAppInterface, str822, true);
        longValue2 = Long.valueOf(str822).longValue();
        if (i17 == 1004) {
        }
        if (i17 == 1004) {
        }
        str4 = com.tencent.mobileqq.utils.ac.q(qQAppInterface, str6);
        j16 = Long.valueOf(str6).longValue();
        String K222222 = K(messageRecord, str3, str7);
        if (str2 != null) {
        }
        return A(i18, j3, K222222, j16, str4);
    }

    public QfavBuilder F(String str) {
        try {
            this.f390548a.putExtra("nAuthorType", 1).putExtra("lUin", Long.parseLong(str));
        } catch (Exception unused) {
        }
        return this;
    }

    public QfavBuilder G(String str, ArrayList<byte[]> arrayList) {
        this.f390548a.putExtra(str, arrayList);
        return this;
    }

    public QfavBuilder H(String str, boolean z16) {
        this.f390548a.putExtra(str, z16);
        return this;
    }

    public void I(MsgRecord msgRecord, int i3) {
        FileElement fileElement;
        ContentValues contentValues = new ContentValues();
        MsgElement fileMsgElem = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).getFileMsgElem(msgRecord);
        String str = null;
        if (fileMsgElem != null) {
            fileElement = fileMsgElem.getFileElement();
        } else {
            fileElement = null;
        }
        int i16 = 1;
        if (fileElement == null) {
            QLog.e(ProcessConstant.QQFAV, 1, "buildNtFileContents fileElement is null");
            return;
        }
        int i17 = 3;
        if (i3 == 2) {
            i16 = 4;
        } else if (msgRecord.getSendType() == 1 && fileElement.getFilePath() != null && new File(fileElement.getFileName()).exists()) {
            i16 = 3;
        }
        if (i3 != 8 || fileElement.getFilePath() == null || !new File(fileElement.getFilePath()).exists()) {
            i17 = i16;
        }
        contentValues.put("fileCloudType", Integer.valueOf(i17));
        contentValues.put("fileUuId", fileElement.getFileUuid());
        contentValues.put("fileSize", Long.valueOf(fileElement.getFileSize()));
        contentValues.put(WadlProxyConsts.PARAM_FILENAME, fileElement.getFileName());
        contentValues.put("fileMd5", fileElement.getFileMd5());
        contentValues.put("filePath", fileElement.getFilePath());
        HashMap<Integer, String> picThumbPath = fileElement.getPicThumbPath();
        if (picThumbPath != null && !picThumbPath.isEmpty()) {
            Iterator<Map.Entry<Integer, String>> it = picThumbPath.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String value = it.next().getValue();
                if (!TextUtils.isEmpty(value) && new File(value).exists()) {
                    str = value;
                    break;
                }
            }
        }
        contentValues.put("fileThumbPath", str);
        contentValues.put("filePeerType", Integer.valueOf(com.tencent.nt.adapter.session.c.c(i3)));
        contentValues.put("fileBid", fileElement.getFileBizId());
        this.f390548a.putExtra("fileContents", contentValues);
    }

    public void J(MsgRecord msgRecord, int i3, long j3) {
        FileElement fileElement;
        ContentValues contentValues = new ContentValues();
        MsgElement msgElem = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).getMsgElem(msgRecord, j3);
        String str = null;
        if (msgElem != null) {
            fileElement = msgElem.getFileElement();
        } else {
            fileElement = null;
        }
        int i16 = 1;
        if (fileElement == null) {
            QLog.e(ProcessConstant.QQFAV, 1, "buildNtFileContents fileElement is null");
            return;
        }
        int i17 = 3;
        if (i3 == 2) {
            i16 = 4;
        } else if (msgRecord.getSendType() == 1 && fileElement.getFilePath() != null && new File(fileElement.getFileName()).exists()) {
            i16 = 3;
        }
        if (i3 != 8 || fileElement.getFilePath() == null || !new File(fileElement.getFilePath()).exists()) {
            i17 = i16;
        }
        contentValues.put("fileCloudType", Integer.valueOf(i17));
        contentValues.put("fileUuId", fileElement.getFileUuid());
        contentValues.put("fileSize", Long.valueOf(fileElement.getFileSize()));
        contentValues.put(WadlProxyConsts.PARAM_FILENAME, fileElement.getFileName());
        contentValues.put("fileMd5", fileElement.getFileMd5());
        contentValues.put("filePath", fileElement.getFilePath());
        HashMap<Integer, String> picThumbPath = fileElement.getPicThumbPath();
        if (picThumbPath != null && !picThumbPath.isEmpty()) {
            Iterator<Map.Entry<Integer, String>> it = picThumbPath.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                String value = it.next().getValue();
                if (!TextUtils.isEmpty(value) && new File(value).exists()) {
                    str = value;
                    break;
                }
            }
        }
        contentValues.put("fileThumbPath", str);
        contentValues.put("filePeerType", Integer.valueOf(com.tencent.nt.adapter.session.c.c(i3)));
        contentValues.put("fileBid", fileElement.getFileBizId());
        this.f390548a.putExtra("fileContents", contentValues);
    }

    public String K(MessageRecord messageRecord, String str, String str2) {
        if (str != null && str.equals(str2)) {
            if (messageRecord == null) {
                return "";
            }
            try {
                JSONObject jSONObject = messageRecord.mExJsonObject;
                if (jSONObject == null) {
                    return "";
                }
                return jSONObject.getString("self_nickname");
            } catch (JSONException unused) {
                QLog.d(ProcessConstant.QQFAV, 2, "msg don't has field that is self_nickname.");
                return "";
            }
        }
        return str2;
    }

    public QfavBuilder M(Entity entity) {
        this.f390548a.putExtra("cvEntityContents", QfavUtil.m(entity, ""));
        this.f390548a.putExtra("sEntityClassName", entity.getClass().getName());
        return this;
    }

    public QfavBuilder N(String str, float f16) {
        this.f390548a.putExtra(str, f16);
        return this;
    }

    public Intent O() {
        return this.f390548a;
    }

    public QfavBuilder Q(String str, int i3) {
        this.f390548a.putExtra(str, i3);
        return this;
    }

    public QfavBuilder R(QQAppInterface qQAppInterface, MessageRecord messageRecord) {
        long j3;
        QfavBuilder D = D(qQAppInterface, messageRecord);
        if (messageRecord == null) {
            j3 = new Date().getTime();
        } else {
            j3 = messageRecord.time * 1000;
        }
        return D.T("lCreateTime", j3);
    }

    public QfavBuilder T(String str, long j3) {
        this.f390548a.putExtra(str, j3);
        return this;
    }

    public boolean e(Activity activity, String str, int i3, Intent intent) {
        return f(activity, str, i3, intent, true);
    }

    public boolean f(Activity activity, String str, int i3, Intent intent, boolean z16) {
        ContentValues contentValues;
        Long asLong;
        e.a().f390609a = true;
        if (activity == null) {
            return false;
        }
        this.f390548a.putExtra("nOperation", 0);
        this.f390548a.putExtra("lCollectTime", System.currentTimeMillis());
        if (intent != null) {
            intent.putExtras(this.f390548a);
        } else {
            intent = this.f390548a;
        }
        Intent intent2 = intent;
        int intExtra = intent2.getIntExtra("nType", 0);
        if (intExtra != 2) {
            if (intExtra == 5 && (contentValues = (ContentValues) intent2.getParcelableExtra("shortVideoContents")) != null && (asLong = contentValues.getAsLong("shortVideoSize")) != null && asLong.longValue() >= GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                intent2.putExtra("nReasonInt", R.string.f238347ji);
                return false;
            }
        } else {
            String stringExtra = intent2.getStringExtra("sPath");
            if (intent2.getIntExtra("nPicType", 1) == 1 && QfavUtil.E(stringExtra, intent2.getLongExtra("lSize", -1L))) {
                intent2.putExtra("nReasonInt", R.string.cwk);
                if (QLog.isColorLevel()) {
                    QLog.i(ProcessConstant.QQFAV, 1, "QfavBuilder.add: picture too big [" + stringExtra + "]");
                }
                d.c(null, "Net_AddFav", 3, 3, -3);
                return false;
            }
        }
        if (this.f390550c != null) {
            S(activity, str, intent2, i3, z16);
            this.f390550c.postDelayed(this.f390549b, 100L);
            return true;
        }
        return QfavPluginProxyActivity.M2(activity, str, intent2, i3, z16);
    }

    public boolean g(Context context, String str, int i3, Intent intent) {
        e.a().f390609a = true;
        if (context == null) {
            return false;
        }
        this.f390548a.putExtra("nOperation", 0);
        this.f390548a.putExtra("lCollectTime", System.currentTimeMillis());
        if (intent != null) {
            intent.putExtras(this.f390548a);
        } else {
            intent = this.f390548a;
        }
        Intent intent2 = intent;
        if (intent2.getIntExtra("nType", 0) == 2) {
            String stringExtra = intent2.getStringExtra("sPath");
            if (intent2.getIntExtra("nPicType", 1) == 1 && QfavUtil.E(stringExtra, intent2.getLongExtra("lSize", -1L))) {
                intent2.putExtra("nReasonInt", R.string.cwk);
                if (QLog.isColorLevel()) {
                    QLog.i(ProcessConstant.QQFAV, 1, "QfavBuilder.add: picture too big [" + stringExtra + "]");
                }
                d.c(null, "Net_AddFav", 3, 3, -3);
                return false;
            }
        }
        if (this.f390550c != null) {
            S(context, str, intent2, i3, false);
            this.f390550c.postDelayed(this.f390549b, 100L);
            return true;
        }
        return QfavPluginProxyActivity.L2(context, str, intent2, i3);
    }

    public boolean h(Activity activity, String str) {
        return i(activity, str, R.string.b3n, null);
    }

    public boolean i(Activity activity, String str, int i3, b bVar) {
        Intent intent;
        String str2 = null;
        boolean e16 = e(activity, str, -1, null);
        if (!e16 && (intent = this.f390548a) != null) {
            str2 = activity.getString(intent.getIntExtra("nReasonInt", R.string.b3o));
        }
        QfavHelper.C(activity, str, e16, str2, false, i3);
        if (bVar != null) {
            bVar.a(e16);
        }
        return e16;
    }

    public boolean j(Context context, String str) {
        return k(context, str, R.string.b3n, null);
    }

    public boolean k(Context context, String str, int i3, b bVar) {
        Intent intent;
        String str2 = null;
        boolean g16 = g(context, str, -1, null);
        if (!g16 && (intent = this.f390548a) != null) {
            str2 = context.getString(intent.getIntExtra("nReasonInt", R.string.b3o));
        }
        QfavHelper.C(context, str, g16, str2, false, i3);
        if (bVar != null) {
            bVar.a(g16);
        }
        return g16;
    }

    public QfavBuilder m0(String str, String str2) {
        this.f390548a.putExtra(str, str2);
        return this;
    }

    public QfavBuilder n0(String str, ArrayList<String> arrayList) {
        this.f390548a.putStringArrayListExtra(str, arrayList);
        return this;
    }

    public boolean t(Activity activity, String str, int i3, Intent intent) {
        boolean e16 = e(activity, str, i3, intent);
        QfavHelper.C(activity, str, e16, "", false, R.string.b3n);
        return e16;
    }

    public boolean u(QQAppInterface qQAppInterface, Context context, FileManagerEntity fileManagerEntity, ChatMessage chatMessage, boolean z16) {
        return v(qQAppInterface, context, fileManagerEntity, chatMessage, z16, "", false, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x01a5  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0233 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02e8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0326 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean v(final QQAppInterface qQAppInterface, final Context context, FileManagerEntity fileManagerEntity, ChatMessage chatMessage, boolean z16, String str, boolean z17, boolean z18) {
        int fileSrcCloudType;
        String str2;
        boolean z19;
        File file;
        String str3;
        int i3;
        int i16;
        byte[] bArr;
        int i17;
        String str4;
        int i18;
        String str5;
        final boolean g16;
        final String str6;
        int i19;
        if (fileManagerEntity == null && TextUtils.isEmpty(str)) {
            return false;
        }
        if (!z17 && fileManagerEntity == null) {
            return false;
        }
        e.a().f390609a = true;
        if (z17) {
            fileSrcCloudType = 3;
        } else {
            fileSrcCloudType = FileManagerUtil.getFileSrcCloudType(fileManagerEntity);
        }
        if (fileSrcCloudType == 5) {
            str2 = fileManagerEntity.strFilePath;
            z19 = true;
        } else {
            str2 = str;
            z19 = z17;
        }
        if (z19 && !TextUtils.isEmpty(str2)) {
            file = new File(str2);
        } else {
            file = null;
        }
        if (fileManagerEntity != null) {
            str3 = fileManagerEntity.fileName;
        } else {
            str3 = str2;
        }
        String j3 = q.j(str3);
        if (chatMessage == null) {
            i3 = 7;
        } else {
            i3 = 6;
        }
        int i26 = i3;
        if (fileManagerEntity != null) {
            int cloudType = fileManagerEntity.getCloudType();
            if (cloudType != 1) {
                if (cloudType != 2) {
                    if (cloudType == 4) {
                        i19 = fileManagerEntity.busId;
                    }
                } else {
                    i19 = 25;
                }
            } else if (3000 == fileManagerEntity.peerType) {
                i19 = 106;
            } else {
                i16 = 3;
                if (fileManagerEntity != null) {
                    bArr = fileManagerEntity.fileName.getBytes();
                } else if (file != null) {
                    bArr = file.getName().getBytes();
                } else {
                    bArr = null;
                }
                if (fileManagerEntity == null && fileManagerEntity.fileSize > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
                    QfavUtil.Q(context, R.string.zxj, 1);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.zxj));
                    this.f390548a.putExtra("fileContents", contentValues);
                    return false;
                }
                if (bArr == null && bArr.length >= 256) {
                    if (!z16) {
                        QfavUtil.Q(context, R.string.b3q, 1);
                    }
                    d.d(qQAppInterface, "User_AddFav", 6, -80010, i26, i16, j3, null);
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.f170926b44));
                    this.f390548a.putExtra("fileContents", contentValues2);
                    return false;
                }
                if (fileSrcCloudType != 1) {
                    if (fileSrcCloudType != 2 && fileSrcCloudType != 3) {
                        if (fileSrcCloudType != 4) {
                            if (fileSrcCloudType != 5) {
                                if (!z16) {
                                    QfavUtil.Q(context, R.string.b3r, 0);
                                }
                                d.d(qQAppInterface, "User_AddFav", 6, -80003, i26, i16, j3, null);
                                ContentValues contentValues3 = new ContentValues();
                                contentValues3.put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.b46));
                                this.f390548a.putExtra("fileContents", contentValues3);
                                return false;
                            }
                        } else {
                            if (104 == fileManagerEntity.busId) {
                                long j16 = fileManagerEntity.lastTime;
                                if (j16 > 0 && j16 <= System.currentTimeMillis() / 1000) {
                                    if (!z16) {
                                        QfavUtil.Q(context, R.string.b3p, 1);
                                    }
                                    d.d(qQAppInterface, "User_AddFav", 6, -80011, i26, i16, j3, null);
                                    ContentValues contentValues4 = new ContentValues();
                                    contentValues4.put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.f170925b43));
                                    this.f390548a.putExtra("fileContents", contentValues4);
                                    return false;
                                }
                            }
                            if (chatMessage == null) {
                                D(qQAppInterface, chatMessage);
                            } else if (fileManagerEntity != null) {
                                String str7 = fileManagerEntity.selfUin;
                                String str8 = fileManagerEntity.peerUin;
                                boolean z26 = fileManagerEntity.bSend;
                                int i27 = fileManagerEntity.peerType;
                                if (i27 != 1 && i27 != 1000) {
                                    i17 = 1004;
                                    if (i27 != 1004) {
                                        if (i27 != 3000) {
                                            if (!z26) {
                                                str7 = str8;
                                            }
                                            i17 = 0;
                                        } else {
                                            i17 = 3000;
                                        }
                                    }
                                } else {
                                    i17 = 1;
                                }
                                if (TextUtils.isEmpty(str7)) {
                                    str4 = qQAppInterface.getCurrentAccountUin();
                                    i18 = 1;
                                } else {
                                    str4 = str7;
                                    i18 = z26 ? 1 : 0;
                                }
                                E(qQAppInterface, null, str4, str8, i18, i17);
                            }
                            if (h.p(qQAppInterface) && chatMessage != null && TextUtils.equals(chatMessage.frienduin, h.g(qQAppInterface))) {
                                this.f390548a.putExtra("lUin", qQAppInterface.getCurrentUin());
                            }
                            if (fileManagerEntity != null) {
                                if (fileSrcCloudType != 1) {
                                    if (fileSrcCloudType != 2) {
                                        if (fileSrcCloudType == 4) {
                                            str5 = fileManagerEntity.strTroopFilePath;
                                        }
                                    } else if (TextUtils.isEmpty(fileManagerEntity.WeiYunDirKey)) {
                                        str5 = fileManagerEntity.WeiYunFileId;
                                    } else {
                                        str5 = fileManagerEntity.WeiYunDirKey + fileManagerEntity.WeiYunFileId;
                                    }
                                } else {
                                    str5 = fileManagerEntity.Uuid;
                                }
                                ContentValues contentValues5 = new ContentValues();
                                contentValues5.put("fileCloudType", Integer.valueOf(fileSrcCloudType));
                                if (fileManagerEntity != null) {
                                    contentValues5.put("fileUuId", str5);
                                    contentValues5.put("fileSize", Long.valueOf(fileManagerEntity.fileSize));
                                    contentValues5.put(WadlProxyConsts.PARAM_FILENAME, fileManagerEntity.fileName);
                                    contentValues5.put("fileMd5", fileManagerEntity.strFileMd5);
                                    contentValues5.put("filePath", fileManagerEntity.getFilePath());
                                    contentValues5.put("fileThumbPath", fileManagerEntity.strThumbPath);
                                    contentValues5.put("filePeerType", Integer.valueOf(fileManagerEntity.peerType));
                                    contentValues5.put("fileBid", Integer.valueOf(fileManagerEntity.busId));
                                } else {
                                    contentValues5.put("filePath", str2);
                                }
                                this.f390548a.putExtra("fileContents", contentValues5);
                                if (!z16) {
                                    g16 = g(context, qQAppInterface.getAccount(), -1, null);
                                    if (!g16) {
                                        str6 = context.getString(this.f390548a.getIntExtra("nReasonInt", R.string.b3o));
                                    } else {
                                        str6 = null;
                                    }
                                    if (z18) {
                                        qQAppInterface.runOnUiThread(new Runnable() { // from class: cooperation.qqfav.QfavBuilder.1
                                            @Override // java.lang.Runnable
                                            public void run() {
                                                QfavHelper.B(context, qQAppInterface.getAccount(), g16, str6, false);
                                            }
                                        });
                                    }
                                } else {
                                    g16 = g(context, qQAppInterface.getAccount(), -1, null);
                                }
                                if (chatMessage != null && fileManagerEntity != null) {
                                    d.b(qQAppInterface, 5, fileManagerEntity.nFileType, chatMessage.istroop);
                                }
                                d.d(qQAppInterface, "User_AddFav", 6, 0, i26, i16, j3, null);
                                return g16;
                            }
                            str5 = "";
                            ContentValues contentValues52 = new ContentValues();
                            contentValues52.put("fileCloudType", Integer.valueOf(fileSrcCloudType));
                            if (fileManagerEntity != null) {
                            }
                            this.f390548a.putExtra("fileContents", contentValues52);
                            if (!z16) {
                            }
                            if (chatMessage != null) {
                                d.b(qQAppInterface, 5, fileManagerEntity.nFileType, chatMessage.istroop);
                            }
                            d.d(qQAppInterface, "User_AddFav", 6, 0, i26, i16, j3, null);
                            return g16;
                        }
                    }
                } else {
                    long j17 = fileManagerEntity.lastTime;
                    if (j17 > 0 && j17 <= System.currentTimeMillis() / 1000) {
                        if (!z16) {
                            QfavUtil.Q(context, R.string.b3p, 1);
                        }
                        d.d(qQAppInterface, "User_AddFav", 6, -80011, i26, i16, j3, null);
                        ContentValues contentValues6 = new ContentValues();
                        contentValues6.put("errorMsg", BaseApplication.getContext().getResources().getString(R.string.f170925b43));
                        this.f390548a.putExtra("fileContents", contentValues6);
                        return false;
                    }
                }
                if (chatMessage == null) {
                }
                if (h.p(qQAppInterface)) {
                    this.f390548a.putExtra("lUin", qQAppInterface.getCurrentUin());
                }
                if (fileManagerEntity != null) {
                }
                str5 = "";
                ContentValues contentValues522 = new ContentValues();
                contentValues522.put("fileCloudType", Integer.valueOf(fileSrcCloudType));
                if (fileManagerEntity != null) {
                }
                this.f390548a.putExtra("fileContents", contentValues522);
                if (!z16) {
                }
                if (chatMessage != null) {
                }
                d.d(qQAppInterface, "User_AddFav", 6, 0, i26, i16, j3, null);
                return g16;
            }
            i16 = i19;
            if (fileManagerEntity != null) {
            }
            if (fileManagerEntity == null) {
            }
            if (bArr == null) {
            }
            if (fileSrcCloudType != 1) {
            }
            if (chatMessage == null) {
            }
            if (h.p(qQAppInterface)) {
            }
            if (fileManagerEntity != null) {
            }
            str5 = "";
            ContentValues contentValues5222 = new ContentValues();
            contentValues5222.put("fileCloudType", Integer.valueOf(fileSrcCloudType));
            if (fileManagerEntity != null) {
            }
            this.f390548a.putExtra("fileContents", contentValues5222);
            if (!z16) {
            }
            if (chatMessage != null) {
            }
            d.d(qQAppInterface, "User_AddFav", 6, 0, i26, i16, j3, null);
            return g16;
        }
        i16 = -1;
        if (fileManagerEntity != null) {
        }
        if (fileManagerEntity == null) {
        }
        if (bArr == null) {
        }
        if (fileSrcCloudType != 1) {
        }
        if (chatMessage == null) {
        }
        if (h.p(qQAppInterface)) {
        }
        if (fileManagerEntity != null) {
        }
        str5 = "";
        ContentValues contentValues52222 = new ContentValues();
        contentValues52222.put("fileCloudType", Integer.valueOf(fileSrcCloudType));
        if (fileManagerEntity != null) {
        }
        this.f390548a.putExtra("fileContents", contentValues52222);
        if (!z16) {
        }
        if (chatMessage != null) {
        }
        d.d(qQAppInterface, "User_AddFav", 6, 0, i26, i16, j3, null);
        return g16;
    }

    public boolean w(QQAppInterface qQAppInterface, Context context, String str) {
        return v(qQAppInterface, context, null, null, false, str, true, true);
    }

    public boolean x(QQAppInterface qQAppInterface, Context context, String str) {
        return v(qQAppInterface, context, null, null, false, str, true, false);
    }

    public boolean y(final QQAppInterface qQAppInterface, final Context context, AIOMsgItem aIOMsgItem, MsgRecord msgRecord) {
        int i3;
        MsgElement fileMsgElem;
        FileElement fileElement;
        byte[] bArr;
        int i16;
        MsgRecord msgRecord2 = aIOMsgItem.getMsgRecord();
        if (context instanceof Activity) {
            i3 = ((Activity) context).getIntent().getIntExtra(AppConstants.Key.FORWARD_NT_FILE_INDEX, 0);
        } else {
            i3 = 0;
        }
        if (i3 > 0 && i3 < msgRecord2.elements.size()) {
            Collections.sort(msgRecord2.elements, new a());
            fileMsgElem = msgRecord2.elements.get(i3);
        } else {
            fileMsgElem = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).getFileMsgElem(msgRecord2);
        }
        final String str = null;
        if (fileMsgElem != null) {
            fileElement = fileMsgElem.getFileElement();
        } else {
            fileElement = null;
        }
        if (fileElement == null) {
            QLog.e(ProcessConstant.QQFAV, 1, "addNtFile fileElement is null");
            return false;
        }
        if (fileElement.getFileSize() > GmCgConstants.MIN_NECESSARY_STORAGE_SIZE_DEFAULT) {
            QfavUtil.Q(context, R.string.zxj, 1);
            ContentValues contentValues = new ContentValues();
            contentValues.put("errorMsg", context.getString(R.string.zxj));
            this.f390548a.putExtra("fileContents", contentValues);
            return false;
        }
        if (fileElement.getFileName() != null) {
            bArr = fileElement.getFileName().getBytes();
        } else {
            bArr = null;
        }
        if (bArr != null && bArr.length >= 256) {
            QfavUtil.Q(context, R.string.b3q, 1);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("errorMsg", context.getString(R.string.f170926b44));
            this.f390548a.putExtra("fileContents", contentValues2);
            return false;
        }
        if (com.tencent.qqnt.aio.element.file.util.a.f(fileElement)) {
            QfavUtil.Q(context, R.string.b3p, 1);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("errorMsg", context.getString(R.string.f170925b43));
            this.f390548a.putExtra("fileContents", contentValues3);
            return false;
        }
        ChatMessage convertToChatMessage = ((IMsgConverterUtilsApi) QRoute.api(IMsgConverterUtilsApi.class)).convertToChatMessage(qQAppInterface, msgRecord2);
        if (msgRecord != null && convertToChatMessage != null) {
            convertToChatMessage.senderuin = String.valueOf(msgRecord.getSenderUin());
            convertToChatMessage.frienduin = String.valueOf(msgRecord.getPeerUin());
            convertToChatMessage.istroop = com.tencent.nt.adapter.session.c.c(msgRecord.getChatType());
        }
        D(qQAppInterface, convertToChatMessage);
        if (h.p(qQAppInterface) && convertToChatMessage != null && TextUtils.equals(convertToChatMessage.frienduin, h.g(qQAppInterface))) {
            this.f390548a.putExtra("lUin", qQAppInterface.getCurrentUin());
        }
        if (aIOMsgItem.p0() == 8) {
            B(Long.valueOf(qQAppInterface.getCurrentAccountUin()).longValue(), qQAppInterface.getCurrentNickname());
        }
        J(msgRecord2, aIOMsgItem.p0(), fileMsgElem.elementId);
        final boolean g16 = g(context, qQAppInterface.getAccount(), -1, null);
        if (!g16) {
            str = context.getString(this.f390548a.getIntExtra("nReasonInt", R.string.b3o));
        }
        qQAppInterface.runOnUiThread(new Runnable() { // from class: cooperation.qqfav.b
            @Override // java.lang.Runnable
            public final void run() {
                QfavBuilder.U(context, qQAppInterface, g16, str);
            }
        });
        if (convertToChatMessage != null) {
            i16 = convertToChatMessage.istroop;
        } else {
            i16 = 0;
        }
        d.b(qQAppInterface, 5, 0, i16);
        return g16;
    }

    public boolean z(Context context) {
        String str;
        if (this.f390548a == null) {
            return false;
        }
        QfavPluginProxyService.d();
        Bundle extras = this.f390548a.getExtras();
        if (extras == null) {
            extras = new Bundle();
        }
        boolean d16 = QfavPluginProxyService.c().d("com.tencent.qqfav", 4, extras);
        if (!d16) {
            str = context.getString(this.f390548a.getIntExtra("nReasonInt", R.string.b3o));
        } else {
            str = null;
        }
        QfavHelper.C(context, "", d16, str, false, R.string.b3n);
        return d16;
    }

    public QfavBuilder(Intent intent) {
        this.f390548a = intent;
    }
}
