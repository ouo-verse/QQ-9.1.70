package com.tencent.mobileqq.emoticon;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.EmojiManagerServiceConstant;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallConstants;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes12.dex */
public class EmotionJsonUtils {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "EmotionJsonUtils";

    public EmotionJsonUtils() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String handleJsonFileDownload(AppInterface appInterface, com.tencent.mobileqq.vip.g gVar, boolean z16) {
        String parseJson;
        byte[] bArr = null;
        if (appInterface != null && gVar != null) {
            Bundle h16 = gVar.h();
            EmoticonPackage emoticonPackage = (EmoticonPackage) h16.getSerializable(EmojiManagerServiceConstant.PARAMS_KEY_EMOTICONPKG);
            if (emoticonPackage == null) {
                return null;
            }
            int i3 = h16.getInt("jsonType", EmojiManagerServiceConstant.JSON_EMOSM_MALL);
            File file = gVar.f313010h.get(gVar.f313004c);
            ReqInfo reqInfo = new ReqInfo();
            if (file != null && file.exists()) {
                bArr = FileUtils.fileToBytes(file);
            }
            byte[] bArr2 = bArr;
            ArrayList arrayList = new ArrayList();
            if (z16) {
                parseJson = parseSmallJson(appInterface, emoticonPackage, i3, bArr2, arrayList);
            } else {
                parseJson = parseJson(appInterface, emoticonPackage, i3, bArr2, arrayList, reqInfo);
            }
            if (QLog.isColorLevel() && parseJson != null) {
                QLog.e(TAG, 2, "handleJsonFileDownload : json parse result = " + parseJson);
            }
            return parseJson;
        }
        QLog.i(TAG, 1, "handleJsonFileDownload() ----- app:" + appInterface + ", task:" + gVar);
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static void parseItemInfoJson(EmoticonPackage emoticonPackage, int i3, ArrayList<Emoticon> arrayList, IEmoticonManagerService iEmoticonManagerService, JSONArray jSONArray, int i16, boolean z16) throws JSONException {
        for (int i17 = 0; i17 < i16; i17++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i17);
            String string = jSONObject.getString("id");
            String string2 = jSONObject.getString("name");
            String string3 = jSONObject.getString("character");
            String str = emoticonPackage.epId;
            Emoticon syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(str, string);
            if (syncFindEmoticonById == null) {
                if (i3 != EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD) {
                    syncFindEmoticonById = new Emoticon();
                    syncFindEmoticonById.eId = string;
                    syncFindEmoticonById.epId = str;
                    syncFindEmoticonById.name = string2;
                    syncFindEmoticonById.character = string3;
                    syncFindEmoticonById.jobType = 3;
                    z16 = true;
                }
                if (syncFindEmoticonById == null) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "emoticon json update, cannot find emoticon from epId: " + str);
                    }
                } else {
                    boolean b16 = com.tencent.mobileqq.core.util.a.b(emoticonPackage);
                    syncFindEmoticonById.isSound = emoticonPackage.hasSound;
                    arrayList.add(syncFindEmoticonById);
                    if (z16 && !b16) {
                        iEmoticonManagerService.saveEmoticon(syncFindEmoticonById);
                    }
                }
            } else if (string.equals(syncFindEmoticonById.eId) && str.equals(syncFindEmoticonById.epId) && string2.equals(syncFindEmoticonById.name)) {
                z16 = false;
                if (syncFindEmoticonById == null) {
                }
            } else {
                syncFindEmoticonById.eId = string;
                syncFindEmoticonById.epId = str;
                if (!TextUtils.isEmpty(string2)) {
                    syncFindEmoticonById.name = string2;
                }
                if (!TextUtils.isEmpty(string3)) {
                    syncFindEmoticonById.character = string3;
                }
                z16 = true;
                if (syncFindEmoticonById == null) {
                }
            }
        }
    }

    public static String parseJson(AppInterface appInterface, EmoticonPackage emoticonPackage, int i3, byte[] bArr, ArrayList<Emoticon> arrayList, ReqInfo reqInfo) {
        String obj;
        String parseJsonParamsVerify = parseJsonParamsVerify(appInterface, emoticonPackage, bArr, arrayList, reqInfo);
        if (parseJsonParamsVerify != null) {
            return parseJsonParamsVerify;
        }
        IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) appInterface.getRuntimeService(IEmoticonManagerService.class, "");
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr, "utf-8"));
            String string = jSONObject.getString("id");
            String string2 = jSONObject.getString("name");
            parseJsonDiversionConfig(emoticonPackage, jSONObject);
            String parseJsonApng = parseJsonApng(emoticonPackage, i3, iEmoticonManagerService, jSONObject, string, string2, "");
            if (parseJsonApng != null) {
                return parseJsonApng;
            }
            if (emoticonPackage.isAPNG == 2) {
                String optString = jSONObject.optString("supportApngSize");
                if (!TextUtils.isEmpty(optString)) {
                    emoticonPackage.supportSize = optString;
                }
            } else if (jSONObject.has("supportSize")) {
                emoticonPackage.supportSize = jSONObject.getJSONArray("supportSize").toString();
            }
            if (jSONObject.has("commDiyText")) {
                emoticonPackage.businessExtra = jSONObject.getJSONArray("commDiyText").toString();
            }
            iEmoticonManagerService.saveEmoticonPackage(emoticonPackage);
            String parseJsonImgs = parseJsonImgs(emoticonPackage, i3, arrayList, reqInfo, iEmoticonManagerService, jSONObject, string, iEmoticonManagerService.getExtensionSizeByScreenSize(string), com.tencent.mobileqq.core.util.a.b(emoticonPackage));
            if (parseJsonImgs != null) {
                return parseJsonImgs;
            }
            return null;
        } catch (JSONException e16) {
            e16.printStackTrace();
            obj = e16.toString();
            QLog.e(TAG, 1, "parseJson: PARSE_EMOTICON_JSON fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + emoticonPackage.epId + " exception=" + e16.toString());
            return obj;
        } catch (Exception e17) {
            e17.printStackTrace();
            obj = e17.toString();
            QLog.d(TAG, 1, "parseJson: PARSE_EMOTICON_JSON fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + emoticonPackage.epId + " exception=" + e17.toString());
            return obj;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00c8  */
    /* JADX WARN: Type inference failed for: r10v3, types: [int] */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static String parseJsonApng(EmoticonPackage emoticonPackage, int i3, IEmoticonManagerService iEmoticonManagerService, JSONObject jSONObject, String str, String str2, String str3) throws JSONException {
        int i16;
        int i17;
        String str4;
        int i18;
        int i19;
        int i26;
        int i27;
        boolean z16;
        boolean z17;
        ?? r102;
        int i28;
        int i29 = emoticonPackage.extraFlags & 1;
        int i36 = 0;
        if (jSONObject.has("isOriginal")) {
            i16 = jSONObject.getInt("isOriginal");
        } else {
            i16 = 0;
        }
        if (jSONObject.optInt("isApng") == 1) {
            i17 = 2;
        } else {
            i17 = 0;
        }
        emoticonPackage.isAPNG = i17;
        if (i29 == 0) {
            emoticonPackage.extraFlags |= i16;
        } else if (i29 > 0) {
            emoticonPackage.extraFlags &= i16;
        }
        if (jSONObject.has("mark")) {
            str4 = jSONObject.getString("mark");
        } else {
            str4 = str3;
        }
        if (jSONObject.has("type")) {
            i18 = jSONObject.getInt("type");
        } else {
            i18 = 0;
        }
        if (jSONObject.has("feetype")) {
            i19 = jSONObject.getInt("feetype");
        } else {
            i19 = 0;
        }
        if (jSONObject.has(EmoticonPackage.EMOTION_RSC_TYPE)) {
            i26 = jSONObject.getInt(EmoticonPackage.EMOTION_RSC_TYPE);
        } else {
            i26 = 0;
        }
        if (jSONObject.has("updateTime")) {
            i27 = jSONObject.getInt("updateTime");
        } else {
            i27 = 0;
        }
        if (jSONObject.has("ringtype")) {
            String string = jSONObject.getString("ringtype");
            if ("1".equals(string)) {
                z16 = true;
                z17 = z16;
                r102 = z16;
                if (!jSONObject.has("type") && 1 == i18) {
                    i28 = 3;
                } else {
                    i28 = 0;
                }
                if (jSONObject.has("downloadcount")) {
                    i36 = jSONObject.getInt("downloadcount");
                }
                emoticonPackage.epId = str;
                emoticonPackage.name = str2;
                emoticonPackage.mark = str4;
                emoticonPackage.type = i18;
                emoticonPackage.mobileFeetype = i19;
                emoticonPackage.hasSound = z17;
                emoticonPackage.subType = r102;
                emoticonPackage.downloadCount = i36;
                emoticonPackage.jobType = i28;
                parseJsonToEp(emoticonPackage, i3, iEmoticonManagerService, jSONObject, str, i26, i18, i27);
                parseJsonOperationInfo(emoticonPackage, jSONObject);
                parseJsonChildEmojiId(emoticonPackage, jSONObject);
                return null;
            }
            if ("2".equals(string)) {
                return "qFace are not supported";
            }
            if ("4".equals(string)) {
                r102 = 4;
                z17 = false;
                if (!jSONObject.has("type")) {
                }
                i28 = 0;
                if (jSONObject.has("downloadcount")) {
                }
                emoticonPackage.epId = str;
                emoticonPackage.name = str2;
                emoticonPackage.mark = str4;
                emoticonPackage.type = i18;
                emoticonPackage.mobileFeetype = i19;
                emoticonPackage.hasSound = z17;
                emoticonPackage.subType = r102;
                emoticonPackage.downloadCount = i36;
                emoticonPackage.jobType = i28;
                parseJsonToEp(emoticonPackage, i3, iEmoticonManagerService, jSONObject, str, i26, i18, i27);
                parseJsonOperationInfo(emoticonPackage, jSONObject);
                parseJsonChildEmojiId(emoticonPackage, jSONObject);
                return null;
            }
        }
        z16 = false;
        z17 = z16;
        r102 = z16;
        if (!jSONObject.has("type")) {
        }
        i28 = 0;
        if (jSONObject.has("downloadcount")) {
        }
        emoticonPackage.epId = str;
        emoticonPackage.name = str2;
        emoticonPackage.mark = str4;
        emoticonPackage.type = i18;
        emoticonPackage.mobileFeetype = i19;
        emoticonPackage.hasSound = z17;
        emoticonPackage.subType = r102;
        emoticonPackage.downloadCount = i36;
        emoticonPackage.jobType = i28;
        parseJsonToEp(emoticonPackage, i3, iEmoticonManagerService, jSONObject, str, i26, i18, i27);
        parseJsonOperationInfo(emoticonPackage, jSONObject);
        parseJsonChildEmojiId(emoticonPackage, jSONObject);
        return null;
    }

    protected static void parseJsonChildEmojiId(EmoticonPackage emoticonPackage, JSONObject jSONObject) throws JSONException {
        String[] split;
        if (jSONObject != null && jSONObject.has("childEmojiId")) {
            String string = jSONObject.getString("childEmojiId");
            if (!TextUtils.isEmpty(string) && (split = string.split(",")) != null && split.length > 0) {
                String str = split[0];
                if (!TextUtils.isEmpty(str)) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 2, "parseJson, child magic, id=" + str);
                    }
                    emoticonPackage.childEpId = str;
                }
            }
        }
    }

    protected static void parseJsonDiversionConfig(EmoticonPackage emoticonPackage, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("diversionConfig");
        if (optJSONObject != null) {
            int optInt = optJSONObject.optInt("diversionType");
            String optString = optJSONObject.optString("diversionName");
            String optString2 = optJSONObject.optString("copywriting");
            String optString3 = optJSONObject.optString(WadlProxyConsts.KEY_JUMP_URL);
            String optString4 = optJSONObject.optString("displayImg");
            long optLong = optJSONObject.optLong("beginTime");
            long optLong2 = optJSONObject.optLong("endTime");
            String optString5 = optJSONObject.optString("wording");
            String optString6 = optJSONObject.optString("from");
            emoticonPackage.copywritingType = optInt;
            emoticonPackage.copywritingContent = optString2;
            emoticonPackage.jumpUrl = optString3;
            emoticonPackage.imageUrl = optString4;
            emoticonPackage.diversionName = optString;
            emoticonPackage.beginTime = optLong;
            emoticonPackage.endTime = optLong2;
            emoticonPackage.buttonWording = optString5;
            emoticonPackage.comeFom = optString6;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0111  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected static String parseJsonImgs(EmoticonPackage emoticonPackage, int i3, ArrayList<Emoticon> arrayList, ReqInfo reqInfo, IEmoticonManagerService iEmoticonManagerService, JSONObject jSONObject, String str, int i16, boolean z16) throws JSONException {
        int i17;
        int i18;
        String str2;
        int i19;
        JSONArray jSONArray;
        boolean z17;
        Emoticon emoticon;
        boolean z18;
        boolean z19;
        JSONArray jSONArray2;
        JSONArray jSONArray3 = jSONObject.getJSONArray("imgs");
        int length = jSONArray3.length();
        ArrayList arrayList2 = new ArrayList();
        boolean z26 = true;
        boolean z27 = false;
        int i26 = 0;
        while (i26 < length) {
            JSONObject jSONObject2 = jSONArray3.getJSONObject(i26);
            String string = jSONObject2.getString("id");
            String string2 = jSONObject2.getString("name");
            if (jSONObject2.has("wWidthInPhone")) {
                i17 = jSONObject2.getInt("wWidthInPhone");
            } else {
                i17 = 0;
            }
            if (jSONObject2.has("wHeightInPhone")) {
                i18 = jSONObject2.getInt("wHeightInPhone");
            } else {
                i18 = 0;
            }
            String parseJsonKeywords = parseJsonKeywords(jSONObject2, string2);
            if (jSONObject2.has("diyText") && (jSONArray2 = jSONObject2.getJSONArray("diyText")) != null) {
                str2 = jSONArray2.toString();
            } else {
                str2 = "";
            }
            boolean z28 = z26;
            Emoticon syncFindEmoticonById = iEmoticonManagerService.syncFindEmoticonById(str, string);
            if (syncFindEmoticonById == null) {
                i19 = i26;
                jSONArray = jSONArray3;
                if (i3 != EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD) {
                    syncFindEmoticonById = new Emoticon();
                    syncFindEmoticonById.eId = string;
                    syncFindEmoticonById.epId = str;
                    syncFindEmoticonById.name = string2;
                    syncFindEmoticonById.width = i17;
                    syncFindEmoticonById.height = i18;
                    syncFindEmoticonById.keywords = parseJsonKeywords;
                    syncFindEmoticonById.businessExtra = str2;
                    emoticon = syncFindEmoticonById;
                    z18 = true;
                    if (emoticon != null) {
                        if (QLog.isColorLevel()) {
                            QLog.d(TAG, 2, "emoticon json update, cannot find emoticon from epId: " + str);
                        }
                    } else {
                        String parseJsonJobType = parseJsonJobType(emoticonPackage, emoticon);
                        if (parseJsonJobType != null) {
                            return parseJsonJobType;
                        }
                        if (TextUtils.isEmpty(emoticon.encryptKey)) {
                            z19 = true;
                        } else {
                            z19 = z27;
                        }
                        emoticon.isSound = emoticonPackage.hasSound;
                        parseJsonVoiceData(emoticonPackage, arrayList, i16, z16, z18, arrayList2, jSONObject2, string, string2, emoticon);
                        z27 = z19;
                    }
                    i26 = i19 + 1;
                    jSONArray3 = jSONArray;
                    z26 = z18;
                } else {
                    z18 = z28;
                    emoticon = syncFindEmoticonById;
                    if (emoticon != null) {
                    }
                    i26 = i19 + 1;
                    jSONArray3 = jSONArray;
                    z26 = z18;
                }
            } else {
                i19 = i26;
                jSONArray = jSONArray3;
                if (string.equals(syncFindEmoticonById.eId) && str.equals(syncFindEmoticonById.epId) && string2.equals(syncFindEmoticonById.name)) {
                    if (!parseJsonKeywords.equals(syncFindEmoticonById.keywords)) {
                        syncFindEmoticonById.keywords = parseJsonKeywords;
                        z17 = true;
                    } else {
                        z17 = false;
                    }
                    if (!str2.equals(syncFindEmoticonById.businessExtra)) {
                        syncFindEmoticonById.businessExtra = str2;
                    } else {
                        emoticon = syncFindEmoticonById;
                        z18 = z17;
                        if (emoticon != null) {
                        }
                        i26 = i19 + 1;
                        jSONArray3 = jSONArray;
                        z26 = z18;
                    }
                } else {
                    syncFindEmoticonById.eId = string;
                    syncFindEmoticonById.epId = str;
                    if (!TextUtils.isEmpty(string2)) {
                        syncFindEmoticonById.name = string2;
                    }
                    syncFindEmoticonById.width = i17;
                    syncFindEmoticonById.height = i18;
                    syncFindEmoticonById.keywords = parseJsonKeywords;
                    syncFindEmoticonById.businessExtra = str2;
                }
                emoticon = syncFindEmoticonById;
                z18 = true;
                if (emoticon != null) {
                }
                i26 = i19 + 1;
                jSONArray3 = jSONArray;
                z26 = z18;
            }
        }
        iEmoticonManagerService.saveEmoticons(arrayList2);
        if (emoticonPackage.newSoundEp) {
            iEmoticonManagerService.saveEmoticonPackage(emoticonPackage);
        }
        reqInfo.encryptKeysSuccess = !z27;
        return null;
    }

    private static String parseJsonJobType(EmoticonPackage emoticonPackage, Emoticon emoticon) {
        int i3 = emoticonPackage.jobType;
        if (i3 == 0) {
            emoticon.jobType = 0;
            return null;
        }
        if (i3 == 1) {
            return "qFace are not supported";
        }
        if (i3 == 3) {
            emoticon.jobType = 2;
            return null;
        }
        if (i3 == 5) {
            emoticon.jobType = 4;
            return null;
        }
        return null;
    }

    private static String parseJsonKeywords(JSONObject jSONObject, String str) throws JSONException {
        if (jSONObject.has("keywords")) {
            JSONArray jSONArray = jSONObject.getJSONArray("keywords");
            if (!TextUtils.isEmpty(str)) {
                jSONArray.mo162put(str);
            }
            return jSONArray.toString();
        }
        return "[" + str + "]";
    }

    protected static void parseJsonOperationInfo(EmoticonPackage emoticonPackage, JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray;
        if (jSONObject != null && jSONObject.has("operationInfo") && (jSONArray = jSONObject.getJSONArray("operationInfo")) != null && jSONArray.length() > 0) {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject2 = jSONArray.getJSONObject(i3);
                if (jSONObject2 != null && jSONObject2.has("platform") && "3".equals(jSONObject2.getString("platform"))) {
                    if (jSONObject2.has("minVersion")) {
                        String string = jSONObject2.getString("minVersion");
                        if (!TextUtils.isEmpty(string)) {
                            emoticonPackage.minQQVersion = string;
                            return;
                        }
                        return;
                    }
                    return;
                }
            }
        }
    }

    protected static String parseJsonParamsVerify(AppInterface appInterface, EmoticonPackage emoticonPackage, byte[] bArr, ArrayList<Emoticon> arrayList, ReqInfo reqInfo) {
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseJson : ap is null");
                return "app is null";
            }
            return "app is null";
        }
        if (emoticonPackage == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseJson : ep is null");
                return "ep is null";
            }
            return "ep is null";
        }
        if (bArr != null && bArr.length >= 1) {
            if (arrayList != null && reqInfo != null) {
                return null;
            }
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseJson : params is null");
                return "params is null";
            }
            return "params is null";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "parseJson : json data is null");
            return "json data is null";
        }
        return "json data is null";
    }

    protected static void parseJsonToEp(EmoticonPackage emoticonPackage, int i3, IEmoticonManagerService iEmoticonManagerService, JSONObject jSONObject, String str, int i16, int i17, int i18) {
        if (emoticonPackage.copywritingType != com.tencent.mobileqq.model.a.f247232b) {
            emoticonPackage.extraFlags |= 4;
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseJson, ep.extraFlags = " + emoticonPackage.extraFlags);
            }
        }
        if (jSONObject.has("type") && 4 == i17) {
            emoticonPackage.jobType = 5;
        }
        emoticonPackage.rscType = i16;
        if (i3 != EmojiManagerServiceConstant.JSON_EMOSM_KEYWORD) {
            emoticonPackage.localVersion = i18;
        }
        EmoticonPackage syncFindTabEmoticonPackageById = iEmoticonManagerService.syncFindTabEmoticonPackageById(str);
        if (syncFindTabEmoticonPackageById != null) {
            emoticonPackage.status = syncFindTabEmoticonPackageById.status;
            emoticonPackage.valid = syncFindTabEmoticonPackageById.valid;
        }
        if (emoticonPackage.mobileFeetype != 1 && ((str == null || !"10278".equals(str)) && emoticonPackage.jobType != 1)) {
            if (syncFindTabEmoticonPackageById != null) {
                emoticonPackage.wordingId = syncFindTabEmoticonPackageById.wordingId;
                return;
            } else {
                emoticonPackage.wordingId = -1L;
                return;
            }
        }
        emoticonPackage.wordingId = 1L;
    }

    private static void parseJsonVoiceData(EmoticonPackage emoticonPackage, ArrayList<Emoticon> arrayList, int i3, boolean z16, boolean z17, ArrayList<Emoticon> arrayList2, JSONObject jSONObject, String str, String str2, Emoticon emoticon) {
        JSONObject optJSONObject = jSONObject.optJSONObject("voiceData");
        if (optJSONObject != null) {
            emoticon.backColor = optJSONObject.optString("backcolor", null);
            emoticon.volumeColor = optJSONObject.optString("fontcolor", null);
            String optString = optJSONObject.optString("heightItems", null);
            emoticon.voicePrint = optString;
            if (!TextUtils.isEmpty(optString)) {
                emoticon.voicePrintItems = emoticon.parseSoundPrintString();
                emoticonPackage.newSoundEp = true;
            }
        }
        arrayList.add(emoticon);
        if (i3 != -1) {
            emoticon.extensionWidth = i3;
            emoticon.extensionHeight = i3;
        }
        if (z17 && !z16) {
            arrayList2.add(emoticon);
        }
    }

    public static String parseSmallJson(AppInterface appInterface, EmoticonPackage emoticonPackage, int i3, byte[] bArr, ArrayList<Emoticon> arrayList) {
        JSONObject jSONObject;
        long j3;
        JSONObject jSONObject2;
        JSONArray jSONArray;
        JSONArray jSONArray2;
        if (appInterface == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseSmallJson: app is null");
                return "app is null";
            }
            return "app is null";
        }
        if (emoticonPackage == null) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "parseSmallJson: ep is null");
                return "ep is null";
            }
            return "ep is null";
        }
        if (bArr != null && bArr.length >= 1) {
            if (arrayList == null) {
                if (QLog.isColorLevel()) {
                    QLog.d(TAG, 2, "parseSmallJson: params is null");
                    return "params is null";
                }
                return "params is null";
            }
            IEmoticonManagerService iEmoticonManagerService = (IEmoticonManagerService) appInterface.getRuntimeService(IEmoticonManagerService.class, "");
            try {
                jSONObject = new JSONObject(new String(bArr, "utf-8"));
                j3 = jSONObject.getLong("timestamp");
                jSONObject2 = jSONObject.getJSONObject("data");
                jSONArray = jSONObject2.getJSONArray("baseInfo");
                jSONArray2 = jSONObject2.getJSONArray("operationInfo");
            } catch (Exception e16) {
                e16.printStackTrace();
                String obj = e16.toString();
                QLog.e(TAG, 1, "parseSmallJson: fail 02 RESULT_CODE_JSON_PARSE_FAIL  ep=" + emoticonPackage.epId + " exception=" + e16.toString());
                return obj;
            } catch (OutOfMemoryError e17) {
                QLog.e(TAG, 1, "parseSmallJson: fail OutOfMemoryError  exception=" + e17.toString());
            } catch (JSONException e18) {
                e18.printStackTrace();
                String obj2 = e18.toString();
                QLog.e(TAG, 1, "parseSmallJson: fail 01 RESULT_CODE_JSON_PARSE_FAIL  ep=" + emoticonPackage.epId + " exception=" + e18.toString());
                return obj2;
            }
            if (jSONArray != null && jSONArray2 != null) {
                parseSmallPackageJson(emoticonPackage, i3, arrayList, iEmoticonManagerService, jSONObject, j3, jSONObject2, jSONArray, jSONArray2);
                return null;
            }
            return "parseSmallJson:json data is error";
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "parseSmallJson: data is null");
            return "json data is null";
        }
        return "json data is null";
    }

    protected static void parseSmallPackageJson(EmoticonPackage emoticonPackage, int i3, ArrayList<Emoticon> arrayList, IEmoticonManagerService iEmoticonManagerService, JSONObject jSONObject, long j3, JSONObject jSONObject2, JSONArray jSONArray, JSONArray jSONArray2) throws JSONException {
        int i16;
        int i17;
        String str;
        int i18 = 0;
        JSONObject jSONObject3 = (JSONObject) jSONArray.get(0);
        JSONObject jSONObject4 = (JSONObject) jSONArray2.get(0);
        String string = jSONObject3.getString("name");
        int optInt = jSONObject3.optInt("isAPNG", 0) + 1;
        emoticonPackage.isAPNG = optInt;
        if (optInt == 2) {
            emoticonPackage.rscType = 2;
        }
        int i19 = emoticonPackage.extraFlags & 1;
        if (jSONObject3.has("isOriginal")) {
            i16 = jSONObject3.getInt("isOriginal");
        } else {
            i16 = 0;
        }
        if (i19 == 0) {
            emoticonPackage.extraFlags = i16 | emoticonPackage.extraFlags;
        } else if (i19 > 0) {
            emoticonPackage.extraFlags = i16 & emoticonPackage.extraFlags;
        }
        if (jSONObject.has("type")) {
            i17 = jSONObject.getInt("type");
        } else {
            i17 = 6;
        }
        if (jSONObject4.has(VipFunCallConstants.KEY_FEET_TYPE)) {
            i18 = jSONObject4.getInt(VipFunCallConstants.KEY_FEET_TYPE);
        }
        emoticonPackage.localVersion = (int) (j3 / 1000);
        emoticonPackage.name = string;
        emoticonPackage.mark = "";
        emoticonPackage.type = i17;
        emoticonPackage.mobileFeetype = i18;
        emoticonPackage.jobType = 4;
        if (i18 != 1 && ((str = emoticonPackage.epId) == null || !"10278".equals(str))) {
            EmoticonPackage syncFindTabEmoticonPackageById = iEmoticonManagerService.syncFindTabEmoticonPackageById(emoticonPackage.epId);
            if (syncFindTabEmoticonPackageById != null) {
                emoticonPackage.wordingId = syncFindTabEmoticonPackageById.wordingId;
            } else {
                emoticonPackage.wordingId = -1L;
            }
        } else {
            emoticonPackage.wordingId = 1L;
        }
        iEmoticonManagerService.saveEmoticonPackage(emoticonPackage);
        JSONArray jSONArray3 = jSONObject2.getJSONArray("itemInfo");
        parseItemInfoJson(emoticonPackage, i3, arrayList, iEmoticonManagerService, jSONArray3, jSONArray3.length(), true);
    }
}
