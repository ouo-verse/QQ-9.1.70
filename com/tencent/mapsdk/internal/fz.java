package com.tencent.mapsdk.internal;

import android.util.Log;
import com.tencent.mapsdk.core.utils.log.LogUtil;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class fz {

    /* renamed from: a, reason: collision with root package name */
    public static final int f148410a = 0;

    /* renamed from: b, reason: collision with root package name */
    public static final int f148411b = 1;

    /* renamed from: c, reason: collision with root package name */
    public int f148412c;

    /* renamed from: d, reason: collision with root package name */
    public int f148413d;

    /* renamed from: e, reason: collision with root package name */
    public JSONArray f148414e;

    /* renamed from: f, reason: collision with root package name */
    public String[] f148415f;

    public fz() {
        this.f148415f = new String[0];
    }

    private int c() {
        return this.f148412c;
    }

    private int d() {
        return this.f148413d;
    }

    private JSONArray e() {
        return this.f148414e;
    }

    private String[] f() {
        return this.f148415f;
    }

    public final boolean a() {
        if (this.f148412c == 1) {
            return true;
        }
        return false;
    }

    public final boolean b() {
        if (this.f148413d == 1) {
            return true;
        }
        return false;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer("IndoorAuth{");
        stringBuffer.append("mEnabled=");
        stringBuffer.append(this.f148412c);
        stringBuffer.append(", mType=");
        stringBuffer.append(this.f148413d);
        stringBuffer.append(", mBuildingJsonArray=");
        stringBuffer.append(this.f148414e);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }

    public fz(int i3, int i16, JSONArray jSONArray) {
        this.f148415f = new String[0];
        this.f148412c = i3;
        this.f148413d = i16;
        this.f148414e = jSONArray;
        if (jSONArray == null) {
            this.f148415f = null;
            return;
        }
        int length = jSONArray.length();
        this.f148415f = new String[length];
        for (int i17 = 0; i17 < length; i17++) {
            try {
                this.f148415f[i17] = this.f148414e.getString(i17);
            } catch (JSONException e16) {
                this.f148415f = null;
                LogUtil.d(Log.getStackTraceString(e16));
                return;
            }
        }
    }
}
