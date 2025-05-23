package com.tencent.bugly.proguard;

import com.tencent.rmonitor.base.config.ConfigFetcher;
import com.tencent.rmonitor.common.logger.Logger;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class z extends com.tencent.rmonitor.base.config.data.m {

    /* renamed from: a, reason: collision with root package name */
    private float f98584a;

    /* renamed from: b, reason: collision with root package name */
    private float f98585b;

    /* renamed from: c, reason: collision with root package name */
    private float f98586c;

    /* renamed from: d, reason: collision with root package name */
    private float f98587d;

    /* renamed from: e, reason: collision with root package name */
    private float f98588e;

    /* renamed from: f, reason: collision with root package name */
    private float f98589f;

    /* renamed from: g, reason: collision with root package name */
    private float f98590g;

    /* renamed from: h, reason: collision with root package name */
    private float f98591h;

    /* renamed from: i, reason: collision with root package name */
    private float f98592i;

    /* renamed from: j, reason: collision with root package name */
    private float f98593j;

    public z(String str) {
        super(str);
        this.f98589f = 0.0f;
        this.f98590g = 1.0f;
        this.f98591h = 1.0f;
        this.f98592i = 1.0f;
        this.f98593j = 0.0f;
        this.f98584a = (float) Math.random();
        this.f98585b = (float) Math.random();
        this.f98586c = (float) Math.random();
        this.f98587d = (float) Math.random();
        this.f98588e = (float) Math.random();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x0086, code lost:
    
        if (r0.f98593j >= r0.f98587d) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0090, code lost:
    
        if (r0.f98590g >= r0.f98585b) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0099, code lost:
    
        if (r0.f98591h >= r0.f98586c) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00a2, code lost:
    
        if (r0.f98589f >= r0.f98584a) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00ab, code lost:
    
        if (r0.f98592i >= r0.f98588e) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean a(String str) {
        boolean z16;
        com.tencent.rmonitor.base.config.data.m h16 = ConfigFetcher.g().h("http");
        if (!(h16 instanceof z)) {
            return false;
        }
        z zVar = (z) h16;
        str.hashCode();
        char c16 = '\uffff';
        switch (str.hashCode()) {
            case -1714796731:
                if (str.equals("userinfo_ratio")) {
                    c16 = 0;
                    break;
                }
                break;
            case -558327676:
                if (str.equals("crash_atta_ratio")) {
                    c16 = 1;
                    break;
                }
                break;
            case 877289295:
                if (str.equals("error_portal_ratio")) {
                    c16 = 2;
                    break;
                }
                break;
            case 1161472016:
                if (str.equals("crash_portal_ratio")) {
                    c16 = 3;
                    break;
                }
                break;
            case 2144791589:
                if (str.equals("launch_time_ratio")) {
                    c16 = 4;
                    break;
                }
                break;
        }
        switch (c16) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                Logger.f365497g.w("HttpRequestControlConfig", str + " is not a valid key");
                z16 = false;
                break;
        }
        z16 = true;
        if (z16) {
            return true;
        }
        Logger.f365497g.i("HttpRequestControlConfig", str + " is disabled, please modify your project's setting");
        return false;
    }

    @Override // com.tencent.rmonitor.base.config.data.m, com.tencent.rmonitor.base.config.h
    public final void parsePluginConfig(JSONObject jSONObject) {
        try {
            if (jSONObject == null) {
                Logger.f365497g.i("HttpRequestControlConfig", "http configs is null");
                return;
            }
            if (jSONObject.has("crash_atta_ratio")) {
                this.f98589f = (float) jSONObject.getDouble("crash_atta_ratio");
            }
            if (jSONObject.has("crash_portal_ratio")) {
                this.f98590g = (float) jSONObject.getDouble("crash_portal_ratio");
            }
            if (jSONObject.has("error_portal_ratio")) {
                this.f98591h = (float) jSONObject.getDouble("error_portal_ratio");
            }
            if (jSONObject.has("launch_time_ratio")) {
                this.f98593j = (float) jSONObject.getDouble("launch_time_ratio");
            }
            if (jSONObject.has("userinfo_ratio")) {
                this.f98592i = (float) jSONObject.getDouble("userinfo_ratio");
            }
        } catch (Throwable th5) {
            Logger.f365497g.b("HttpRequestControlConfig", "parseHttpConfigs", th5);
        }
    }
}
