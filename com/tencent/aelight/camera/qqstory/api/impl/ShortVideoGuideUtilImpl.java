package com.tencent.aelight.camera.qqstory.api.impl;

import android.app.Activity;
import com.tencent.aelight.camera.aioeditor.shortvideo.util.ShortVideoGuideUtil;
import com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil;
import com.tencent.common.app.AppInterface;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ShortVideoGuideUtilImpl implements IShortVideoGuideUtil {
    @Override // com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil
    public boolean isAllResourceReady() {
        return ShortVideoGuideUtil.a();
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil
    public boolean isResourceReady(AppInterface appInterface) {
        return ShortVideoGuideUtil.b(appInterface);
    }

    @Override // com.tencent.aelight.camera.qqstory.api.IShortVideoGuideUtil
    public boolean startPTVActivity(Activity activity, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i3) {
        return ShortVideoGuideUtil.c(activity, str, str2, str3, str4, str5, str6, str7, str8, i3);
    }
}
