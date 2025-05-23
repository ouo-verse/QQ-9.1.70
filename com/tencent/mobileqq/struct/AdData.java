package com.tencent.mobileqq.struct;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.ditto.shell.LayoutAttrDefine;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class AdData implements Serializable, Comparable<AdData> {
    static IPatchRedirector $redirector_ = null;
    public static final int UI_PICTURE = 2;
    public static final int UI_PICTURE_and_TEXT = 3;
    public String actionData;
    public int ad_source;
    public String avatarBgGif;
    public int bgColor;
    public String content;
    public String content2;
    public String contentColor;
    public String distance;
    public String expose_url;
    public int fontColor;
    public String hasAvatarAnimation;
    public boolean hasShow;

    /* renamed from: id, reason: collision with root package name */
    public long f290268id;
    public int idType;
    public String img_url;
    public String jump_url;
    public String logo_url;
    public String nowBoardcastGif;
    public String nowBoardcastWording;
    public int picType;
    public int position;
    public String title;
    public int typeUI;
    public String wording;

    public AdData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.picType = 1;
            this.hasShow = false;
        }
    }

    public static String getWording(int i3, String str) {
        if (str != null && str.length() > 0) {
            return str;
        }
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 != 4) {
                        return BaseApplication.getContext().getString(R.string.f171276dp1);
                    }
                    return BaseApplication.getContext().getString(R.string.bpr);
                }
                return BaseApplication.getContext().getString(R.string.f171507fm3);
            }
            return BaseApplication.getContext().getString(R.string.a_8);
        }
        return BaseApplication.getContext().getString(R.string.few);
    }

    public static int parseAdColor(int i3, boolean z16, String str) {
        boolean z17;
        boolean z18 = false;
        if (str == null) {
            z17 = false;
        } else {
            if (str.startsWith("#")) {
                str = str.replace("#", "");
            }
            if (str.length() > 6) {
                str = str.substring(str.length() - 6, str.length());
            }
            z17 = true;
        }
        int i16 = -1;
        if (z17) {
            try {
                i16 = Integer.parseInt(str, 16) | (-16777216);
                z18 = true;
            } catch (Exception unused) {
            }
        }
        if (z18) {
            return i16;
        }
        if (z16) {
            if (i3 != 0) {
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                return -35755;
                            }
                            return i16;
                        }
                        return -627103;
                    }
                    return -10249473;
                }
                return -23224;
            }
            return -33153;
        }
        return i16;
    }

    public boolean parseJson(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str)).booleanValue();
        }
        if (str != null && str.length() != 0) {
            if (str.endsWith(",}")) {
                str = str.substring(0, str.length() - 2) + "}";
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.title = jSONObject.optString("title");
                this.content = jSONObject.optString("content");
                this.content2 = jSONObject.optString("content2");
                this.typeUI = jSONObject.optInt("type");
                String optString = jSONObject.optString("img_url");
                this.img_url = optString;
                if (optString != null) {
                    this.img_url = optString.trim();
                }
                this.jump_url = jSONObject.optString("jump_url");
                this.actionData = jSONObject.optString(PublicAccountMessageUtilImpl.ITEM_ACTION_DATA);
                this.expose_url = jSONObject.optString("expose_url");
                this.bgColor = parseAdColor(this.ad_source, true, jSONObject.optString(LayoutAttrDefine.BG_Color));
                this.fontColor = parseAdColor(this.ad_source, false, jSONObject.optString("font_color"));
                this.wording = getWording(this.ad_source, jSONObject.optString("corner_wording"));
                this.distance = jSONObject.optString(Element.ELEMENT_NAME_DISTANCE);
                this.f290268id = jSONObject.optLong("id");
                this.idType = jSONObject.optInt("id_type");
                if (jSONObject.has("pic_type")) {
                    this.picType = jSONObject.optInt("pic_type");
                }
                this.logo_url = jSONObject.optString("logo_url");
                if (jSONObject.has("content_color")) {
                    this.contentColor = jSONObject.optString("content_color");
                }
                if (jSONObject.has("content_color")) {
                    this.hasAvatarAnimation = jSONObject.optString("hasAvatarAnimation");
                }
                if (jSONObject.has("content_color")) {
                    this.avatarBgGif = jSONObject.optString("avatarBgGif");
                }
                if (jSONObject.has("content_color")) {
                    this.nowBoardcastWording = jSONObject.optString("nowBoardcastWording");
                }
                if (jSONObject.has("content_color")) {
                    this.nowBoardcastGif = jSONObject.optString("nowBoardcastGif");
                }
                String str2 = this.img_url;
                if (str2 == null || !str2.startsWith("http")) {
                    return false;
                }
                return true;
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.w(AdData.class.getSimpleName(), 2, e16.getMessage());
                }
            }
        }
        return false;
    }

    @Override // java.lang.Comparable
    public int compareTo(AdData adData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this, (Object) adData)).intValue();
        }
        int i3 = this.position;
        int i16 = adData.position;
        if (i3 > i16) {
            return 1;
        }
        return i3 == i16 ? 0 : -1;
    }
}
