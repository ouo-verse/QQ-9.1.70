package com.tencent.ams.dsdk.monitor.metric;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.ams.dsdk.data.ModuleInfo;
import com.tencent.ams.dsdk.data.TemplateInfo;
import com.tencent.ams.dsdk.monitor.metric.core.MetricReporter;
import com.tencent.ams.dsdk.monitor.metric.core.TagSet;
import com.tencent.ams.dsdk.monitor.metric.event.MetricEvent;
import com.tencent.ams.dsdk.monitor.metric.event.TagName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class DynamicReporter {
    static IPatchRedirector $redirector_;

    public DynamicReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private static String getEncryptType(ModuleInfo moduleInfo) {
        if (moduleInfo == null) {
            return "unknown";
        }
        return String.valueOf(moduleInfo.getEncryptType());
    }

    private static String getMIFileType(ModuleInfo moduleInfo) {
        if (moduleInfo == null) {
            return "unknown";
        }
        return String.valueOf(moduleInfo.getFileType());
    }

    private static String getMIName(ModuleInfo moduleInfo) {
        if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getName())) {
            return moduleInfo.getName();
        }
        return "unknown";
    }

    private static String getMIVersion(ModuleInfo moduleInfo) {
        if (moduleInfo != null && !TextUtils.isEmpty(moduleInfo.getVersion())) {
            return moduleInfo.getVersion();
        }
        return "unknown";
    }

    private static List<TagSet> getTagSets(ModuleInfo moduleInfo) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TagSet.of(TagName.PKG_VERSION, getMIVersion(moduleInfo)));
        arrayList.add(TagSet.of("pkg_name", getMIName(moduleInfo)));
        arrayList.add(TagSet.of(TagName.IS_FORCE_UPDATE, isForceUpdate(moduleInfo)));
        arrayList.add(TagSet.of(TagName.FILE_TYPE, getMIFileType(moduleInfo)));
        arrayList.add(TagSet.of(TagName.ENCRYPT_TYPE, getEncryptType(moduleInfo)));
        return arrayList;
    }

    private static List<TagSet> getTagSetsByTemplateInfo(TemplateInfo templateInfo) {
        ArrayList arrayList = new ArrayList();
        if (templateInfo == null) {
            return arrayList;
        }
        arrayList.add(TagSet.of("templateId", getTemplateId(templateInfo)));
        arrayList.add(TagSet.of("downloadType", String.valueOf(templateInfo.getDownloadType())));
        arrayList.add(TagSet.of(TagName.IS_FORCE_UPDATE, String.valueOf(templateInfo.isForceUpdate())));
        arrayList.add(TagSet.of(TagName.TPT_VERSION, getVersion(templateInfo)));
        return arrayList;
    }

    private static String getTemplateId(TemplateInfo templateInfo) {
        if (templateInfo != null && !TextUtils.isEmpty(templateInfo.getTemplateId())) {
            return templateInfo.getTemplateId();
        }
        return "unknown";
    }

    private static String getVersion(TemplateInfo templateInfo) {
        if (templateInfo != null && !TextUtils.isEmpty(templateInfo.getVersion())) {
            return templateInfo.getVersion();
        }
        return "unknown";
    }

    private static String isForceUpdate(ModuleInfo moduleInfo) {
        if (moduleInfo == null) {
            return "unknown";
        }
        if (moduleInfo.isForceUpdate()) {
            return "yes";
        }
        return "no";
    }

    public static void reportBundleConfigGetEnd(long j3, String str) {
        MetricReporter.report(MetricEvent.BUNDLE_CONFIG_GET_END, TagSet.of("code", str));
        MetricReporter.report(MetricEvent.BUNDLE_CONFIG_GET_COST, SystemClock.uptimeMillis() - j3, TagSet.of("code", str));
    }

    public static void reportBundleConfigGetStart() {
        MetricReporter.report(MetricEvent.BUNDLE_CONFIG_GET_START, new TagSet[0]);
    }

    public static void reportBundleLocalConfigUpdateEnd(long j3, String str, ModuleInfo moduleInfo) {
        List<TagSet> tagSets = getTagSets(str, moduleInfo);
        MetricReporter.report(MetricEvent.BUNDLE_LOCAL_CONFIG_UPDATE_END, tagSets);
        MetricReporter.report(MetricEvent.BUNDLE_LOCAL_CONFIG_UPDATE_COST, SystemClock.uptimeMillis() - j3, tagSets);
    }

    public static void reportBundleLocalConfigUpdateStart(ModuleInfo moduleInfo) {
        MetricReporter.report(MetricEvent.BUNDLE_LOCAL_CONFIG_UPDATE_START, getTagSets(moduleInfo));
    }

    public static void reportDldTptEnd() {
        MetricReporter.report(MetricEvent.TEMPLATE_DOWNLOAD_END, new TagSet[0]);
    }

    public static void reportDldTptItemCanceled(TemplateInfo templateInfo) {
        MetricReporter.report(MetricEvent.TEMPLATE_DOWNLOAD_ITEM_CANCEL, getTagSetsByTemplateInfo(templateInfo));
    }

    public static void reportDldTptItemFailed(TemplateInfo templateInfo) {
        MetricReporter.report(MetricEvent.TEMPLATE_DOWNLOAD_ITEM_FAIL, getTagSetsByTemplateInfo(templateInfo));
    }

    public static void reportDldTptItemStart(TemplateInfo templateInfo) {
        MetricReporter.report(MetricEvent.TEMPLATE_DOWNLOAD_ITEM_START, getTagSetsByTemplateInfo(templateInfo));
    }

    public static void reportDldTptItemSuccess(TemplateInfo templateInfo) {
        MetricReporter.report(MetricEvent.TEMPLATE_DOWNLOAD_ITEM_SUCCESS, getTagSetsByTemplateInfo(templateInfo));
    }

    public static void reportDldTptStart() {
        MetricReporter.report(MetricEvent.TEMPLATE_DOWNLOAD_START, new TagSet[0]);
    }

    public static void reportDownloadEnd(long j3, String str, ModuleInfo moduleInfo) {
        List<TagSet> tagSets = getTagSets(str, moduleInfo);
        MetricReporter.report(MetricEvent.BUNDLE_DOWNLOAD_END, tagSets);
        MetricReporter.report(MetricEvent.BUNDLE_DOWNLOAD_COST, SystemClock.uptimeMillis() - j3, tagSets);
    }

    public static void reportDownloadHitCache(ModuleInfo moduleInfo) {
        MetricReporter.report(MetricEvent.BUNDLE_DOWNLOAD_HIT_CACHE, getTagSets(moduleInfo));
    }

    public static void reportDownloadStart(ModuleInfo moduleInfo) {
        MetricReporter.report(MetricEvent.BUNDLE_DOWNLOAD_START, getTagSets(moduleInfo));
    }

    public static void reportDynamicRenderEnd(long j3, String str, ModuleInfo moduleInfo, String str2) {
        List<TagSet> tagSets = getTagSets(str, moduleInfo);
        tagSets.add(TagSet.of(TagName.ENGINE_TYPE, str2));
        MetricReporter.report(MetricEvent.DYNAMIC_RENDER_END, tagSets);
        MetricReporter.report(MetricEvent.DYNAMIC_RENDER_COST, SystemClock.uptimeMillis() - j3, tagSets);
    }

    public static void reportDynamicRenderGetBundleEnd(long j3, String str) {
        MetricReporter.report(MetricEvent.DYNAMIC_RENDER_GET_BUNDLE_END, TagSet.of("code", str));
        MetricReporter.report(MetricEvent.DYNAMIC_RENDER_GET_BUNDLE_COST, j3, TagSet.of("code", str));
    }

    public static void reportDynamicRenderGetBundleStart() {
        MetricReporter.report(MetricEvent.DYNAMIC_RENDER_GET_BUNDLE_START, new TagSet[0]);
    }

    public static void reportDynamicRenderStart(ModuleInfo moduleInfo, String str) {
        List<TagSet> tagSets = getTagSets(moduleInfo);
        tagSets.add(TagSet.of(TagName.ENGINE_TYPE, str));
        MetricReporter.report(MetricEvent.DYNAMIC_RENDER_START, tagSets);
    }

    public static void reportHippyJsException(String str) {
        MetricReporter.report(10000000L, TagSet.of("errMsg", str));
    }

    public static void reportHippyNativeException(String str) {
        MetricReporter.report(10000001L, TagSet.of("errMsg", str));
    }

    public static void reportModuleCheckUnzipFileMD5(ModuleInfo moduleInfo, String str) {
        MetricReporter.report(MetricEvent.BUNDLE_CHECK_UNZIP_FILE_MD5, getTagSets(str, moduleInfo));
    }

    public static void reportModuleClearEnd(long j3, boolean z16, ModuleInfo moduleInfo) {
        String str;
        if (z16) {
            str = "yes";
        } else {
            str = "no";
        }
        List<TagSet> tagSets = getTagSets(str, moduleInfo);
        MetricReporter.report(MetricEvent.MODULE_FILE_CLEAR_END, tagSets);
        MetricReporter.report(MetricEvent.MODULE_FILE_CLEAR_COST, SystemClock.uptimeMillis() - j3, tagSets);
    }

    public static void reportModuleClearStart(ModuleInfo moduleInfo) {
        MetricReporter.report(MetricEvent.MODULE_FILE_CLEAR_START, getTagSets(moduleInfo));
    }

    public static void reportModuleTempClearEnd(long j3, boolean z16, ModuleInfo moduleInfo) {
        String str;
        if (z16) {
            str = "yes";
        } else {
            str = "no";
        }
        List<TagSet> tagSets = getTagSets(str, moduleInfo);
        MetricReporter.report(MetricEvent.MODULE_TEMP_FILE_CLEAR_END, tagSets);
        MetricReporter.report(MetricEvent.MODULE_TEMP_FILE_CLEAR_COST, SystemClock.uptimeMillis() - j3, tagSets);
    }

    public static void reportModuleTempClearStart(ModuleInfo moduleInfo) {
        MetricReporter.report(MetricEvent.MODULE_TEMP_FILE_CLEAR_START, getTagSets(moduleInfo));
    }

    public static void reportTptCfgGetEnd(long j3, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TagSet.of("code", str));
        MetricReporter.report(MetricEvent.TEMPLATE_CONFIG_GET_END, arrayList);
        MetricReporter.report(MetricEvent.TEMPLATE_CONFIG_GET_COST, System.currentTimeMillis() - j3, arrayList);
    }

    public static void reportTptCfgGetStart() {
        MetricReporter.report(MetricEvent.TEMPLATE_CONFIG_GET_START, new TagSet[0]);
    }

    public static void reportTptItemExist(TemplateInfo templateInfo) {
        MetricReporter.report(MetricEvent.TEMPLATE_DOWNLOAD_ITEM_EXIST, getTagSetsByTemplateInfo(templateInfo));
    }

    public static void reportUnzipBundleFileEnd(ModuleInfo moduleInfo, String str) {
        MetricReporter.report(MetricEvent.UNZIP_BUNDLE_FILE_END, getTagSets(str, moduleInfo));
    }

    public static void reportUnzipBundleFileStart(ModuleInfo moduleInfo) {
        MetricReporter.report(MetricEvent.UNZIP_BUNDLE_FILE_START, getTagSets(moduleInfo));
    }

    public static void reportUnzipEntryError(String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TagSet.of(TagName.ENTRY_NAME, str));
        arrayList.add(TagSet.of("code", str2));
        arrayList.add(TagSet.of("errMsg", str3));
        MetricReporter.report(MetricEvent.UNZIP_ENTRY_ERROR, arrayList);
    }

    public static void reportModuleCheckUnzipFileMD5(ModuleInfo moduleInfo, String str, String str2) {
        List<TagSet> tagSets = getTagSets(str, moduleInfo);
        tagSets.add(TagSet.of("errMsg", str2));
        MetricReporter.report(MetricEvent.BUNDLE_CHECK_UNZIP_FILE_MD5, tagSets);
    }

    public static void reportUnzipBundleFileEnd(ModuleInfo moduleInfo, String str, String str2) {
        List<TagSet> tagSets = getTagSets(str, moduleInfo);
        tagSets.add(TagSet.of("errMsg", str2));
        MetricReporter.report(MetricEvent.UNZIP_BUNDLE_FILE_END, tagSets);
    }

    public static void reportTptCfgGetEnd(long j3, String str, String str2) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(TagSet.of("code", str));
        arrayList.add(TagSet.of("errMsg", str2));
        MetricReporter.report(MetricEvent.TEMPLATE_CONFIG_GET_END, arrayList);
        MetricReporter.report(MetricEvent.TEMPLATE_CONFIG_GET_COST, System.currentTimeMillis() - j3, arrayList);
    }

    private static List<TagSet> getTagSets(String str, ModuleInfo moduleInfo) {
        List<TagSet> tagSets = getTagSets(moduleInfo);
        tagSets.add(TagSet.of("code", str));
        return tagSets;
    }
}
