package com.tencent.richframework.text.rich.parser;

import android.text.Spannable;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.text.rich.bean.RichTextPreloadParserInfo;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

/* loaded from: classes25.dex */
public class RFWPreloadParseRichTextHelper {
    private static volatile RFWPreloadParseRichTextHelper sHelper;
    private static final LruCache<String, Spannable> SPANNABLE_LRU_CACHE = new LruCache<String, Spannable>(20) { // from class: com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper.1
    };
    private static final LruCache<String, RichTextPreloadParserInfo> PARSER_INFO_LRU_CACHE = new LruCache<>(20);

    /* renamed from: com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper$3, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass3 implements Runnable {
        final /* synthetic */ RFWPreloadParseRichTextHelper this$0;
        final /* synthetic */ Object val$object;
        final /* synthetic */ RichTextPreloadParserInfo val$parserInfo;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.synchroParserDynamicRuleText(this.val$object, this.val$parserInfo);
        }
    }

    /* renamed from: com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper$4, reason: invalid class name */
    /* loaded from: classes25.dex */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ RFWPreloadParseRichTextHelper this$0;
        final /* synthetic */ Object val$object;
        final /* synthetic */ RichTextPreloadParserInfo val$parserInfo;

        @Override // java.lang.Runnable
        public void run() {
            this.this$0.synchroParserDynamicAndBaseRuleText(this.val$object, this.val$parserInfo);
        }
    }

    RFWPreloadParseRichTextHelper() {
    }

    public static RFWPreloadParseRichTextHelper g() {
        if (sHelper == null) {
            synchronized (RFWPreloadParseRichTextHelper.class) {
                if (sHelper == null) {
                    sHelper = new RFWPreloadParseRichTextHelper();
                }
            }
        }
        return sHelper;
    }

    public Spannable getSpannableCachePool(String str) {
        if (str == null) {
            return null;
        }
        return SPANNABLE_LRU_CACHE.get(str);
    }

    public void preloadParserBaseRuleText(final RichTextPreloadParserInfo richTextPreloadParserInfo) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new Runnable() { // from class: com.tencent.richframework.text.rich.parser.RFWPreloadParseRichTextHelper.2
            @Override // java.lang.Runnable
            public void run() {
                if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_intercept_preload_rich_text_before_skin_load", true) && QCircleSkinHelper.getInstance().isPackageLoading()) {
                    QLog.e("RFWPreloadParseRichTextHelper", 1, "[preloadParserRichTextForFeed] intercept preload when skin is loading");
                } else {
                    RFWPreloadParseRichTextHelper.this.synchroParserBaseRuleText(richTextPreloadParserInfo);
                }
            }
        });
    }

    public void putSpannableCache(String str, Spannable spannable) {
        if (!TextUtils.isEmpty(str) && spannable != null) {
            SPANNABLE_LRU_CACHE.put(str, spannable);
        }
    }

    public void release() {
        PARSER_INFO_LRU_CACHE.evictAll();
        SPANNABLE_LRU_CACHE.evictAll();
    }

    public void removeSpannableCache(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        SPANNABLE_LRU_CACHE.remove(str);
    }

    public Spannable synchroParserBaseRuleText(RichTextPreloadParserInfo richTextPreloadParserInfo) {
        Spannable spannable = null;
        if (richTextPreloadParserInfo == null) {
            return null;
        }
        try {
            spannable = RFWParseRichTextManager.parseBaseRule(richTextPreloadParserInfo);
        } catch (Throwable th5) {
            QLog.e("RFWPreloadParseRichTextHelper", 2, "[preloadParserBaseRuleText] error: ", th5);
        }
        if (spannable != null) {
            putSpannableCache(richTextPreloadParserInfo.getCacheKey(), spannable);
        }
        return spannable;
    }

    public Spannable synchroParserDynamicAndBaseRuleText(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        Spannable spannable = null;
        if (richTextPreloadParserInfo == null) {
            return null;
        }
        try {
            spannable = RFWParseRichTextManager.parseDynamicAndBaseRule(obj, richTextPreloadParserInfo);
        } catch (Throwable th5) {
            QLog.e("RFWPreloadParseRichTextHelper", 2, "[preloadParserDynamicAndBaseRuleText] error: ", th5);
        }
        if (spannable != null) {
            putSpannableCache(richTextPreloadParserInfo.getCacheKey(), spannable);
        }
        return spannable;
    }

    public Spannable synchroParserDynamicRuleText(Object obj, RichTextPreloadParserInfo richTextPreloadParserInfo) {
        Spannable spannable = null;
        if (richTextPreloadParserInfo == null) {
            return null;
        }
        try {
            spannable = RFWParseRichTextManager.parseDynamicRule(obj, richTextPreloadParserInfo);
        } catch (Throwable th5) {
            QLog.e("RFWPreloadParseRichTextHelper", 2, "[preloadParserDynamicRuleText] error: ", th5);
        }
        if (spannable != null) {
            putSpannableCache(richTextPreloadParserInfo.getCacheKey(), spannable);
        }
        return spannable;
    }
}
