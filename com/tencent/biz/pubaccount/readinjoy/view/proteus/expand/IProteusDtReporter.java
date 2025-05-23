package com.tencent.biz.pubaccount.readinjoy.view.proteus.expand;

import android.support.annotation.Nullable;
import android.view.View;
import java.util.Map;

/* loaded from: classes4.dex */
public interface IProteusDtReporter {
    void handleProteusViewClick(View view);

    void setDtElementIdWithParams(View view, String str, @Nullable Map<String, Object> map);
}
