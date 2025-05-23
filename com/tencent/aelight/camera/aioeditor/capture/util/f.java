package com.tencent.aelight.camera.aioeditor.capture.util;

import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static Random f67201a = new Random();

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f67202a;

        /* renamed from: b, reason: collision with root package name */
        public int f67203b;

        public a(int i3, int i16) {
            this.f67202a = i3;
            this.f67203b = i16;
        }
    }

    public static a a() {
        int i3 = ScreenUtil.SCREEN_WIDTH;
        int nextInt = (i3 / 4) - f67201a.nextInt(i3 / 2);
        int i16 = ScreenUtil.SCREEN_WIDTH;
        return new a((ScreenUtil.SCREEN_WIDTH / 2) + nextInt, ((ScreenUtil.SCREEN_HIGHT - ScreenUtil.dip2px(249.0f)) / 2) + ((i16 / 4) - f67201a.nextInt(i16 / 2)));
    }
}
