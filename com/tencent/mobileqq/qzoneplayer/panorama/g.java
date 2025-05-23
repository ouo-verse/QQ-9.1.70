package com.tencent.mobileqq.qzoneplayer.panorama;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import com.tencent.mobileqq.qzoneplayer.ui.common.PlayerResources;
import com.tencent.mobileqq.qzoneplayer.video.FeedVideoEnv;
import com.tencent.oskplayer.util.PlayerUtils;

/* compiled from: P */
/* loaded from: classes35.dex */
public class g {

    /* renamed from: a, reason: collision with root package name */
    private int f279428a;

    /* renamed from: b, reason: collision with root package name */
    private int f279429b;

    /* renamed from: c, reason: collision with root package name */
    private int f279430c;

    /* renamed from: d, reason: collision with root package name */
    private int f279431d;

    /* renamed from: e, reason: collision with root package name */
    private int f279432e;

    /* renamed from: f, reason: collision with root package name */
    private int f279433f;

    public boolean a(Context context) {
        try {
            int b16 = a.b(a.a(35633, i(context)), a.a(35632, c(context)), new String[]{"a_Position", "a_TexCoordinate"});
            this.f279433f = b16;
            this.f279428a = GLES20.glGetUniformLocation(b16, "u_MVPMatrix");
            this.f279429b = GLES20.glGetUniformLocation(this.f279433f, "u_MVMatrix");
            this.f279430c = GLES20.glGetUniformLocation(this.f279433f, "u_Texture");
            this.f279431d = GLES20.glGetAttribLocation(this.f279433f, "a_Position");
            this.f279432e = GLES20.glGetAttribLocation(this.f279433f, "a_TexCoordinate");
            return true;
        } catch (Exception e16) {
            PlayerUtils.log(6, "Video360Program", "crate and link program error: " + GLUtils.getEGLErrorString(GLES20.glGetError()) + " stack:" + e16.toString());
            return false;
        }
    }

    public void b() {
        int i3 = this.f279433f;
        if (i3 != 0) {
            GLES20.glDeleteProgram(i3);
            this.f279433f = 0;
        }
    }

    protected String c(Context context) {
        return a.d(context, FeedVideoEnv.playerResources.getRawId(PlayerResources.RawId.RAW_360_FRAG_SHADER));
    }

    public int d() {
        return this.f279429b;
    }

    public int e() {
        return this.f279428a;
    }

    public int f() {
        return this.f279431d;
    }

    public int g() {
        return this.f279432e;
    }

    public int h() {
        return this.f279430c;
    }

    protected String i(Context context) {
        return a.d(context, FeedVideoEnv.playerResources.getRawId(PlayerResources.RawId.RAW_360_VERTEX_SHADER));
    }

    public void j() {
        GLES20.glUseProgram(this.f279433f);
    }
}
