package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.os.Parcelable;
import android.widget.EditText;
import mqq.app.AppRuntime;

/* loaded from: classes12.dex */
public interface IHotPicSearchEmoticonInfo {
    void report(AppRuntime appRuntime);

    void send(AppRuntime appRuntime, Context context, EditText editText, Parcelable parcelable);
}
