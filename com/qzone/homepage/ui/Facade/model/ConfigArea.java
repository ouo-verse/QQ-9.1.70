package com.qzone.homepage.ui.Facade.model;

import NS_MOBILE_CUSTOM.ConfigRect;
import NS_MOBILE_CUSTOM.CustomColor;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.qzone.adapter.feedcomponent.i;
import com.qzone.common.account.LoginData;
import com.tencent.component.annotation.NeedParcel;
import com.tencent.component.app.common.SmartParcelable;
import cooperation.qzone.api.impl.QZoneIntimateSpaceApiImpl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes39.dex */
public class ConfigArea implements SmartParcelable {

    @NeedParcel
    public int canEdit;

    @NeedParcel
    public int contentStyle;

    @NeedParcel
    public String defaultText;

    @NeedParcel
    public Map<String, String> extInfo;

    @NeedParcel
    public int fontSize;

    /* renamed from: hp, reason: collision with root package name */
    @NeedParcel
    public int f47628hp;

    @NeedParcel
    public String imageUrl;

    @NeedParcel
    public int indexId;

    @NeedParcel
    public String schema;

    @NeedParcel
    public String text;

    @NeedParcel
    public int textColor;

    @NeedParcel
    public int textColorClick;

    @NeedParcel
    public int type;

    /* renamed from: wp, reason: collision with root package name */
    @NeedParcel
    public int f47629wp;

    /* renamed from: xp, reason: collision with root package name */
    @NeedParcel
    public int f47630xp;

    /* renamed from: yp, reason: collision with root package name */
    @NeedParcel
    public int f47631yp;

    public static String addParamToUrl(String str, String str2, String str3) {
        if (str.contains(str2 + ContainerUtils.KEY_VALUE_DELIMITER)) {
            return str.replaceFirst(str2 + "=[^&]*", str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3);
        }
        StringBuilder sb5 = new StringBuilder(str);
        if (str.indexOf(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER) < 1) {
            sb5.append(QZoneIntimateSpaceApiImpl.URL_QUERY_SPLITTER);
        } else {
            sb5.append(ContainerUtils.FIELD_DELIMITER);
        }
        sb5.append(str2 + ContainerUtils.KEY_VALUE_DELIMITER + str3);
        return sb5.toString();
    }

    public static ConfigArea createConfigArea(ConfigRect configRect, long j3) {
        if (configRect == null) {
            return null;
        }
        ConfigArea configArea = new ConfigArea();
        configArea.indexId = configRect.iIndexId;
        int i3 = configRect.iType;
        configArea.type = i3;
        configArea.f47630xp = configRect.iXp;
        configArea.f47631yp = configRect.iYp;
        configArea.f47629wp = configRect.iWp;
        configArea.f47628hp = configRect.iHp;
        configArea.canEdit = configRect.iCanEdit;
        configArea.text = configRect.strUserText;
        configArea.defaultText = configRect.strText;
        CustomColor customColor = configRect.stTextColor;
        if (customColor != null) {
            configArea.textColor = (customColor.f24973a << 24) + (customColor.f24976r << RegisterType.UNINIT_REF) + (customColor.f24975g << 8) + customColor.f24974b;
        }
        CustomColor customColor2 = configRect.stTextColorClick;
        if (customColor2 != null) {
            configArea.textColorClick = (customColor2.f24973a << 24) + (customColor2.f24976r << RegisterType.UNINIT_REF) + (customColor2.f24975g << 8) + customColor2.f24974b;
        }
        configArea.fontSize = configRect.iFontSize;
        configArea.schema = configRect.strSchema;
        configArea.imageUrl = configRect.strImageUrl;
        configArea.contentStyle = configRect.iContentStyle;
        configArea.extInfo = configRect.mapExtInfo;
        if (i3 == 11) {
            if (j3 == 0) {
                configArea.imageUrl = i.H().P(Long.valueOf(LoginData.getInstance().getUin()));
            } else {
                configArea.imageUrl = i.H().P(Long.valueOf(j3));
            }
        }
        if (!TextUtils.isEmpty(configArea.schema)) {
            String addParamToUrl = addParamToUrl(configArea.schema, "uin", j3 + "");
            configArea.schema = addParamToUrl;
            configArea.schema = addParamToUrl(addParamToUrl, "nickname", j3 + "");
        }
        return configArea;
    }

    public static ArrayList<ConfigArea> createConfigAreas(List<ConfigRect> list, long j3) {
        if (list == null) {
            return null;
        }
        ArrayList<ConfigArea> arrayList = new ArrayList<>();
        Iterator<ConfigRect> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(createConfigArea(it.next(), j3));
        }
        return arrayList;
    }
}
