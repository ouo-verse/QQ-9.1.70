package com.tencent.mobileqq.emoticonview.api;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import java.net.URL;
import mqq.app.AppRuntime;

@QAPI(process = {""})
/* loaded from: classes12.dex */
public interface IHotPicSearchService extends QRouteApi {
    int getReportFromType();

    URL getURL(String str);

    boolean isRichTextLastTab(Context context, String str);

    void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable, Parcelable parcelable2, String str, int i3, int i16);
}
