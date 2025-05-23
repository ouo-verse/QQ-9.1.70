package com.tencent.mobileqq.search.fragment.searchentry.hippy;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class TKDSearchHistoryBean {
    private String aid;
    private int fromWhere;

    /* renamed from: id, reason: collision with root package name */
    private int f283224id;
    private String jsonStr;
    private String keyword;
    private String label;
    private String title;
    private String url;

    /* compiled from: P */
    /* loaded from: classes18.dex */
    public interface FromWhere {
        public static final int DIRECT = 21;
        public static final int KEYWORD = 5;
        public static final int LIST_RECOMMEND = 15;
        public static final int RIGHT_RECOMMEND = 14;
        public static final int SITE = 3;
        public static final int TOPPING_RECOMMEND = 13;
        public static final int VERTICL_SUGGEST_WORD = 95;
    }

    @NonNull
    public static TKDSearchHistoryBean createFromJson(@NonNull JsonObject jsonObject) {
        try {
            return (TKDSearchHistoryBean) new Gson().fromJson((JsonElement) jsonObject, TKDSearchHistoryBean.class);
        } catch (Exception unused) {
            return new TKDSearchHistoryBean();
        }
    }

    @NonNull
    public static TKDSearchHistoryBean createFromKeyword(@NonNull String str) {
        TKDSearchHistoryBean tKDSearchHistoryBean = new TKDSearchHistoryBean();
        tKDSearchHistoryBean.keyword = str;
        tKDSearchHistoryBean.title = str;
        tKDSearchHistoryBean.url = str;
        tKDSearchHistoryBean.fromWhere = 5;
        tKDSearchHistoryBean.f283224id = str.hashCode();
        return tKDSearchHistoryBean;
    }

    @NonNull
    private String safetyStrValue(@Nullable String str) {
        if (str == null) {
            return "";
        }
        return str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass() && this.f283224id == ((TKDSearchHistoryBean) obj).f283224id) {
            return true;
        }
        return false;
    }

    @NonNull
    public String getAid() {
        return safetyStrValue(this.aid);
    }

    public int getFromWhere() {
        return this.fromWhere;
    }

    public int getId() {
        return this.f283224id;
    }

    @NonNull
    public String getJsonStr() {
        return safetyStrValue(this.jsonStr);
    }

    @NonNull
    public String getKeyword() {
        return safetyStrValue(this.keyword);
    }

    @NonNull
    public String getLabel() {
        return safetyStrValue(this.label);
    }

    @NonNull
    public String getTitle() {
        return safetyStrValue(this.title);
    }

    @NonNull
    public String getUrl() {
        return safetyStrValue(this.url);
    }

    public int hashCode() {
        return this.f283224id;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setFromWhere(int i3) {
        this.fromWhere = i3;
    }

    public void setId(int i3) {
        this.f283224id = i3;
    }

    public void setJsonStr(String str) {
        this.jsonStr = str;
    }

    public void setKeyword(String str) {
        this.keyword = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    @NonNull
    public String toJsonStr() {
        try {
            return new Gson().toJson(this);
        } catch (Exception unused) {
            return new JsonObject().toString();
        }
    }
}
