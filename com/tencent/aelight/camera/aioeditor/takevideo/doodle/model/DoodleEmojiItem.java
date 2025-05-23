package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import com.tencent.aelight.camera.aioeditor.capture.paster.QIMInformationPasterManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qqfeatureswitch.IFeatureRuntimeService;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fr.f;
import hr.d;
import hr.e;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DoodleEmojiItem implements Cloneable {
    public static final String POI_PASTER_LIST = "poi_poster_list";
    public String config;
    public String download_icon;
    public String download_url;
    public String download_wording;

    @Deprecated
    public int hide;
    public String icon;
    public Map<String, Map<String, d.a>> mCityRes;
    public List<d.c> mInfoItemList;
    public List<e.a> mItemList;
    public String mLocalEmojiFolderPath;
    public int mask;
    public String md5;
    public String name;
    public String pack_id;
    public String random_position;
    public int type;

    public DoodleEmojiItem() {
    }

    public static DoodleEmojiItem getDoodleEmojiItemFromJsonObj(JSONObject jSONObject) {
        int i3;
        DoodleEmojiItem doodleEmojiItem = (DoodleEmojiItem) JSONUtils.b(jSONObject, DoodleEmojiItem.class);
        if (doodleEmojiItem != null && (i3 = doodleEmojiItem.type) != 1) {
            try {
                if (i3 == 2) {
                    doodleEmojiItem.mItemList = e.i(jSONObject.getJSONArray(POI_PASTER_LIST));
                } else if (i3 == 3) {
                    doodleEmojiItem.mInfoItemList = d.h(jSONObject.getJSONArray("info_poster_list"));
                    doodleEmojiItem.mCityRes = d.j(jSONObject.optJSONArray("city_res"));
                    if (QLog.isColorLevel()) {
                        QLog.d("QIMInformationPasterManager", 2, "parsed information item list");
                    }
                    AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                    if (runtime != null && ((IFeatureRuntimeService) runtime.getRuntimeService(IFeatureRuntimeService.class, "all")).isFeatureSwitchEnable("rich_media_pre_download_sticker_emoji_on_startup", false)) {
                        QIMInformationPasterManager qIMInformationPasterManager = (QIMInformationPasterManager) f.d().g(12);
                        if (NetworkUtil.isWifiConnected(BaseApplication.getContext())) {
                            if (QLog.isColorLevel()) {
                                QLog.d("QIMInformationPasterManager", 2, "batchPullAllRes");
                            }
                            qIMInformationPasterManager.h(doodleEmojiItem.mInfoItemList);
                        } else {
                            qIMInformationPasterManager.l(doodleEmojiItem);
                        }
                    }
                    return doodleEmojiItem;
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("QIMInformationPasterManager", 2, e16, new Object[0]);
                }
                e16.printStackTrace();
                return null;
            }
        }
        return doodleEmojiItem;
    }

    public String getLocalEmojiFolderPath() {
        return this.mLocalEmojiFolderPath;
    }

    public int hashCode() {
        return this.pack_id.hashCode();
    }

    public void setLocalEmojiFolderPath(String str) {
        this.mLocalEmojiFolderPath = str;
    }

    public String toString() {
        return "DoodleEmojiItem{pack_id='" + this.pack_id + "', icon='" + this.icon + "', download_icon='" + this.download_icon + "', name='" + this.name + "', download_url='" + this.download_url + "', md5='" + this.md5 + "', mLocalEmojiFolderPath='" + this.mLocalEmojiFolderPath + "', config='" + this.config + "', mask=" + this.mask + "'}";
    }

    public DoodleEmojiItem(String str, String str2, String str3, String str4, String str5, String str6) {
        this.pack_id = str;
        this.icon = str2;
        this.download_icon = null;
        this.name = str3;
        this.download_url = str4;
        this.config = str5;
        this.md5 = str6;
        this.type = 1;
        this.mask = 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.pack_id.equals(((DoodleEmojiItem) obj).pack_id);
    }
}
