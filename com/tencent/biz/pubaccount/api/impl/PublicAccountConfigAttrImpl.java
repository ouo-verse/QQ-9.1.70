package com.tencent.biz.pubaccount.api.impl;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigGroupInfo;
import com.tencent.mobileqq.mp.mobileqq_mp$ConfigInfo;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class PublicAccountConfigAttrImpl implements IPublicAccountConfigAttr {
    public List<IPublicAccountConfigAttr.a> configs;
    public int type;

    public PublicAccountConfigAttrImpl() {
        this.type = 0;
        this.configs = new ArrayList();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr
    public List<IPublicAccountConfigAttr.a> getConfigs() {
        return this.configs;
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr
    public int getType() {
        return this.type;
    }

    public void initPaConfigInfo(IPublicAccountConfigAttr.a aVar, mobileqq_mp$ConfigInfo mobileqq_mp_configinfo) {
        aVar.f79329a = mobileqq_mp_configinfo.type.get();
        aVar.f79330b = mobileqq_mp_configinfo.title.get();
        aVar.f79331c = mobileqq_mp_configinfo.content.get();
        aVar.f79333e = mobileqq_mp_configinfo.event_id.get();
        aVar.f79336h = mobileqq_mp_configinfo.url.get();
        aVar.f79334f = mobileqq_mp_configinfo.state.get();
        aVar.f79335g = mobileqq_mp_configinfo.state_id.get();
        aVar.f79337i = mobileqq_mp_configinfo.confirm_flag.get();
        aVar.f79338j = mobileqq_mp_configinfo.confirm_tips.get();
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr
    public List<IPublicAccountConfigAttr> parser(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray == null) {
            return arrayList;
        }
        try {
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                PublicAccountConfigAttrImpl publicAccountConfigAttrImpl = new PublicAccountConfigAttrImpl();
                publicAccountConfigAttrImpl.type = jSONObject.optInt("type");
                JSONArray jSONArray2 = jSONObject.getJSONArray(DownloadInfo.spKey_Config);
                int length2 = jSONArray2.length();
                for (int i16 = 0; i16 < length2; i16++) {
                    IPublicAccountConfigAttr.a parser = parser(jSONArray2.getJSONObject(i16));
                    if (parser != null) {
                        publicAccountConfigAttrImpl.configs.add(parser);
                    }
                }
                arrayList.add(publicAccountConfigAttrImpl);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return arrayList;
    }

    public PublicAccountConfigAttrImpl(mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo) {
        this(0, mobileqq_mp_configgroupinfo);
    }

    public PublicAccountConfigAttrImpl(int i3, mobileqq_mp$ConfigGroupInfo mobileqq_mp_configgroupinfo) {
        this.type = i3;
        if (mobileqq_mp_configgroupinfo == null) {
            return;
        }
        List<mobileqq_mp$ConfigInfo> list = mobileqq_mp_configgroupinfo.config_info.get();
        this.configs = new ArrayList(list.size());
        Iterator<mobileqq_mp$ConfigInfo> it = list.iterator();
        while (it.hasNext()) {
            IPublicAccountConfigAttr.a aVar = new IPublicAccountConfigAttr.a();
            initPaConfigInfo(aVar, it.next());
            this.configs.add(aVar);
        }
    }

    @Override // com.tencent.biz.pubaccount.api.IPublicAccountConfigAttr
    public List<IPublicAccountConfigAttr> castToPaConfigAttrs(List<mobileqq_mp$ConfigGroupInfo> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<mobileqq_mp$ConfigGroupInfo> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(new PublicAccountConfigAttrImpl(it.next()));
        }
        return arrayList;
    }

    private static IPublicAccountConfigAttr.a parser(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        IPublicAccountConfigAttr.a aVar = new IPublicAccountConfigAttr.a();
        try {
            aVar.f79329a = jSONObject.optInt("type");
            aVar.f79330b = jSONObject.optString("title");
            aVar.f79331c = jSONObject.optString("content");
            aVar.f79332d = jSONObject.optInt("follow_handle");
            aVar.f79333e = jSONObject.optInt("event_id");
            aVar.f79334f = jSONObject.optInt("state");
            aVar.f79335g = jSONObject.optInt("state_id");
            aVar.f79336h = jSONObject.optString("url");
            aVar.f79337i = jSONObject.optInt("confirm_flag");
            aVar.f79338j = jSONObject.optString("confirm_tips");
            aVar.f79339k = jSONObject.optString("pic_url");
            aVar.f79340l = jSONObject.optString("lng");
            aVar.f79341m = jSONObject.optString(QCircleSchemeAttr.Polymerize.LAT);
            aVar.f79342n = jSONObject.optString("phone_number");
            aVar.f79343o = jSONObject.optInt("width");
            aVar.f79344p = jSONObject.optInt("height");
            aVar.f79345q = jSONObject.optString("icon");
            aVar.f79346r = jSONObject.optString("vid");
            if (aVar.f79329a == 3 && aVar.f79333e == 23 && !TextUtils.isEmpty(aVar.f79331c)) {
                zx.b bVar = new zx.b();
                bVar.b(aVar.f79331c);
                if (TextUtils.isEmpty(aVar.f79339k) && !TextUtils.isEmpty(bVar.f453632f.f453646b)) {
                    aVar.f79339k = bVar.f453632f.f453646b;
                }
                if (TextUtils.isEmpty(aVar.f79330b) && !TextUtils.isEmpty(bVar.f453627a)) {
                    aVar.f79330b = bVar.f453627a;
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return aVar;
    }
}
