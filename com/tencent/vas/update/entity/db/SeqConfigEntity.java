package com.tencent.vas.update.entity.db;

import android.text.TextUtils;
import com.tencent.vas.update.util.FileUtil;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import qw4.a;

/* compiled from: P */
/* loaded from: classes27.dex */
public class SeqConfigEntity {
    private static final String MMKV_KEY = "seq_v2_mmkv";
    private static final String SEQ_CONFIG = "seq_v2.cfg";
    public static final String SEQ_CONFIG_PATH = VasUpdateWrapper.getCommonManager().b() + File.separator + SEQ_CONFIG;
    private static final String TAG = "VasUpdate_SeqConfig";
    public String mAppVer;
    public int mPollTime;
    public ArrayList<PreloadItem> mPreloadList;
    public int mPreloadVer;
    public long mSeq;

    public static JSONArray convertPreloadListToJson(ArrayList<PreloadItem> arrayList) {
        JSONArray jSONArray = new JSONArray();
        if (arrayList == null) {
            return jSONArray;
        }
        Iterator<PreloadItem> it = arrayList.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(PreloadItem.convertToJson(it.next()));
        }
        return jSONArray;
    }

    public static SeqConfigEntity loadSeqConfig() {
        SeqConfigEntity seqConfigEntity = new SeqConfigEntity();
        File file = new File(SEQ_CONFIG_PATH);
        if (!file.exists()) {
            if (a.f430258b) {
                String a16 = VasUpdateWrapper.getMMKVManager().a(MMKV_KEY);
                if (!TextUtils.isEmpty(a16)) {
                    SeqConfigEntity parseSeqJson = parseSeqJson(a16);
                    VasUpdateWrapper.getLog().e(TAG, "loadSeqConfig mmkv content = " + a16);
                    return parseSeqJson;
                }
                return seqConfigEntity;
            }
            return seqConfigEntity;
        }
        String readFileContent = FileUtil.readFileContent(file);
        if (a.f430258b) {
            FileUtil.deleteFile(file.getAbsolutePath());
            VasUpdateWrapper.getMMKVManager().encodeString(MMKV_KEY, readFileContent);
        }
        VasUpdateWrapper.getLog().e(TAG, "loadSeqConfig content = " + readFileContent);
        return parseSeqJson(readFileContent);
    }

    public static SeqConfigEntity parseSeqJson(String str) {
        SeqConfigEntity seqConfigEntity = new SeqConfigEntity();
        try {
        } catch (Throwable th5) {
            th5.printStackTrace();
            VasUpdateWrapper.getLog().e(TAG, "parseSeqJson exception", th5);
        }
        if (TextUtils.isEmpty(str)) {
            return seqConfigEntity;
        }
        JSONObject jSONObject = new JSONObject(str);
        seqConfigEntity.mSeq = jSONObject.optLong("seq");
        seqConfigEntity.mAppVer = jSONObject.optString("appver");
        seqConfigEntity.mPreloadVer = jSONObject.optInt("plver");
        seqConfigEntity.mPreloadList = PreloadItem.parsePreloadItemList(jSONObject.optJSONArray("preloadList"));
        return seqConfigEntity;
    }

    public static void saveSeqConfig(SeqConfigEntity seqConfigEntity) {
        if (seqConfigEntity == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("seq", seqConfigEntity.mSeq);
            jSONObject.put("appver", seqConfigEntity.mAppVer);
            jSONObject.put("plver", seqConfigEntity.mPreloadVer);
            jSONObject.put("mPreloadList", convertPreloadListToJson(seqConfigEntity.mPreloadList));
        } catch (JSONException e16) {
            e16.printStackTrace();
        }
        if (a.f430258b) {
            VasUpdateWrapper.getMMKVManager().encodeString(MMKV_KEY, jSONObject.toString());
            if (VasUpdateWrapper.getLog().isColorLevel()) {
                VasUpdateWrapper.getLog().i(TAG, "saveSeqConfig value = \n" + jSONObject);
                return;
            }
            return;
        }
        boolean writeFileContent = FileUtil.writeFileContent(SEQ_CONFIG_PATH, jSONObject.toString());
        if (VasUpdateWrapper.getLog().isColorLevel()) {
            VasUpdateWrapper.getLog().i(TAG, "saveSeqConfig value = \n" + jSONObject + " result= " + writeFileContent);
        }
    }
}
