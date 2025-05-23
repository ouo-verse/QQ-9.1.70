package com.tencent.biz.qqstory.model;

import android.content.Intent;
import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;

/* compiled from: P */
/* loaded from: classes5.dex */
public class h extends b {

    /* renamed from: d, reason: collision with root package name */
    public static String f94041d = k(-128);

    /* renamed from: e, reason: collision with root package name */
    public static String f94042e = "key_last_get_config_time";

    /* renamed from: c, reason: collision with root package name */
    public g f94043c = (g) xc0.c.a(g.class, new Object[0]);

    public h() {
        super.a(BaseApplicationImpl.getApplication());
    }

    public static String g() {
        return BaseApplicationImpl.getApplication().getRuntime().getAccount();
    }

    public static int h() {
        return ((Integer) ((h) i.c(10)).j("int_high_bitrate", 3000)).intValue() * 1000;
    }

    public static int i() {
        return ((Integer) ((h) i.c(10)).j("int_upload_video_size_limit", Integer.valueOf(MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE))).intValue() * 1024;
    }

    public static String k(int i3) {
        return "qqstory_config_version_of_type__" + i3;
    }

    public int f() {
        return ea.P1(QQStoryContext.h().b(), f94041d, QQStoryContext.h().d());
    }

    public <V> V j(@NonNull String str, @NonNull V v3) {
        return (V) super.c(str + "_" + g(), v3);
    }

    public boolean l(int i3, Intent intent, ConfigurationService$Config configurationService$Config) {
        return this.f94043c.c(i3, intent, configurationService$Config);
    }

    public <V> void m(@NonNull String str, @NonNull V v3) {
        super.d(str + "_" + g(), v3);
    }
}
