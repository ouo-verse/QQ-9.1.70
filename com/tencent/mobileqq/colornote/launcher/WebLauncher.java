package com.tencent.mobileqq.colornote.launcher;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.utils.ax;
import com.tencent.mobileqq.utils.bi;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.report.QCircleLpReportDc010001;
import fa1.b;
import mqq.app.AppRuntime;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@KeepClassConstructor
/* loaded from: classes5.dex */
public class WebLauncher implements b {

    /* renamed from: a, reason: collision with root package name */
    private Bundle f201406a;

    public WebLauncher() {
    }

    @Override // fa1.b
    public int getType() {
        return R.id.background;
    }

    @Override // fa1.b
    public void launch(Context context, ColorNote colorNote) {
        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
        if (!colorNote.getSubType().startsWith("http") && (runtime instanceof QQAppInterface)) {
            ax c16 = bi.c((QQAppInterface) runtime, context, colorNote.getSubType());
            if (c16 != null) {
                c16.b();
                return;
            }
            QLog.e("WebLauncher", 1, "jumpAction is null!");
        }
        Intent intent = new Intent(context, (Class<?>) QQBrowserActivity.class);
        intent.putExtra("big_brother_source_key", "biz_src_jc_floatwin");
        intent.putExtra("url", colorNote.getSubType());
        if (colorNote.getReserve() != null) {
            try {
                intent.putExtra("key_scroll_y", new JSONObject(new String(colorNote.getReserve())).getInt("key_scroll_y"));
            } catch (JSONException e16) {
                QLog.e("WebLauncher", 1, e16, new Object[0]);
            }
        }
        intent.putExtra(QCircleLpReportDc010001.KEY_SUBTYPE, colorNote.mSubType);
        intent.addFlags(268435456);
        Bundle bundle = this.f201406a;
        if (bundle != null) {
            intent.putExtra("isFromFavourite", bundle.getBoolean("isFromFavourite", false));
        }
        context.startActivity(intent);
    }

    @Override // fa1.b
    public void onCreate(Context context, ColorNote colorNote, Bundle bundle) {
        this.f201406a = bundle;
    }

    public WebLauncher(Bundle bundle) {
        this.f201406a = bundle;
    }
}
