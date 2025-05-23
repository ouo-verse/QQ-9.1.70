package com.tencent.richframework.text.rich.bean;

import android.text.Spanned;
import android.text.SpannedString;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.parser.IParseRuleStrategyParser;

/* loaded from: classes25.dex */
public class RichTextPreloadParserInfo {
    private String mCacheKey;
    private RichTextPreloadConfig mConfig;
    private Class<? extends IParseRuleStrategyParser> mDynamicParserClass;
    public String mPreloadBusinessTag;
    private Spanned mPreloadContent;

    public RichTextPreloadParserInfo(String str, Spanned spanned) {
        this.mPreloadBusinessTag = str;
        this.mPreloadContent = spanned;
    }

    private String differConfig() {
        StringBuilder sb5 = new StringBuilder("");
        RichTextPreloadConfig richTextPreloadConfig = this.mConfig;
        if (richTextPreloadConfig == null) {
            return sb5.toString();
        }
        if (richTextPreloadConfig.getImageSpanConfig() != null) {
            sb5.append(this.mConfig.getImageSpanConfig().getIconSize());
        }
        if (this.mConfig.getAtConfig() != null) {
            sb5.append(this.mConfig.getAtConfig().getSpecialAreaColorId());
            sb5.append(this.mConfig.getAtConfig().isNeedSpecialAreaBold() ? 1 : 0);
        }
        if (this.mConfig.getTagConfig() != null) {
            sb5.append(this.mConfig.getTagConfig().getTagTextSize());
            sb5.append(this.mConfig.getTagConfig().getSpecialAreaColorId());
            sb5.append(this.mConfig.getTagConfig().getSpecialAreaHasBackgroundColorId());
            sb5.append(this.mConfig.getTagConfig().getSpecialAreaHashTagBackgroundColorId());
            sb5.append(this.mConfig.getTagConfig().isNeedSpecialAreaBold() ? 1 : 0);
            sb5.append(this.mConfig.getTagConfig().isNeedSpecialHashTagAreaBackground() ? 1 : 0);
        }
        return sb5.toString();
    }

    public String getCacheKey() {
        String str;
        try {
            Spanned preloadContent = getPreloadContent();
            if (preloadContent == null) {
                str = "";
            } else {
                str = String.valueOf(preloadContent.hashCode());
            }
            String str2 = getPreloadBusinessTag() + str + differConfig();
            this.mCacheKey = str2;
            return str2;
        } catch (Exception e16) {
            QLog.e("RichTextPreloadParserInfo", 1, "getCacheKey  e = " + e16.getMessage());
            return "";
        }
    }

    public RichTextPreloadConfig getConfig() {
        return this.mConfig;
    }

    public Class<? extends IParseRuleStrategyParser> getDynamicParserClass() {
        return this.mDynamicParserClass;
    }

    public String getPreloadBusinessTag() {
        String str = this.mPreloadBusinessTag;
        if (str == null) {
            return "";
        }
        return str;
    }

    public Spanned getPreloadContent() {
        Spanned spanned = this.mPreloadContent;
        if (spanned == null) {
            return new SpannedString("");
        }
        return spanned;
    }

    public void setCacheKey(String str) {
        this.mCacheKey = str;
    }

    public void setConfig(RichTextPreloadConfig richTextPreloadConfig) {
        this.mConfig = richTextPreloadConfig;
    }

    public void setDynamicParserClass(Class<? extends IParseRuleStrategyParser> cls) {
        this.mDynamicParserClass = cls;
    }

    public void setPreloadContent(Spanned spanned) {
        this.mPreloadContent = spanned;
    }
}
