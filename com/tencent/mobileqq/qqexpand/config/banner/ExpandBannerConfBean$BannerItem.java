package com.tencent.mobileqq.qqexpand.config.banner;

import com.google.gson.annotations.SerializedName;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ExpandBannerConfBean$BannerItem {
    public String bgBeginColor;
    public String bgEndColor;
    public String bgHorizontalColor;
    public JSONObject extra;

    @SerializedName("icon")
    public String iconUrl;

    /* renamed from: id, reason: collision with root package name */
    @SerializedName("appID")
    public long f263543id;
    public String schemeOrUrl;
    public String subTitle;
    public String title;
    public String type;
}
