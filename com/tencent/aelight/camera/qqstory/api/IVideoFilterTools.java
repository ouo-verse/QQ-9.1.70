package com.tencent.aelight.camera.qqstory.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

/* compiled from: P */
@QAPI(process = {"all"})
/* loaded from: classes3.dex */
public interface IVideoFilterTools extends QRouteApi {
    public static final String BASE_CONFIG = "filter_config_new.xml";
    public static final String CATEGORYS = "categorys";
    public static final String CONFIG_FILE = "params.json";
    public static final String FILTERS = "filters";
    public static final String FILTER_ASSET = "filter_template.cfg";
    public static final String LOCK_CATEGORYS = "locked_categorys";
    public static final String TEMP_FILTER_CONFIG_ZIP = "temp_filter_zip";

    String getCommonPrefix();

    int getQQShortVideoFilterConfigVersion(Context context);

    void handleQQShortVideoCommonConfig(String str);

    void updateQQShortVideoFilterConfig(Context context, String str);
}
