package com.tencent.mobileqq.guild.media.widget.zoom;

import android.content.Context;
import android.widget.OverScroller;

/* compiled from: P */
/* loaded from: classes14.dex */
public abstract class a {

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.guild.media.widget.zoom.a$a, reason: collision with other inner class name */
    /* loaded from: classes14.dex */
    private static class C7846a extends a {

        /* renamed from: a, reason: collision with root package name */
        OverScroller f230080a;

        public C7846a(Context context) {
            this.f230080a = new OverScroller(context);
        }

        @Override // com.tencent.mobileqq.guild.media.widget.zoom.a
        public boolean a() {
            return this.f230080a.computeScrollOffset();
        }

        @Override // com.tencent.mobileqq.guild.media.widget.zoom.a
        public void b(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
            this.f230080a.fling(i3, i16, i17, i18, i19, i26, i27, i28);
        }

        @Override // com.tencent.mobileqq.guild.media.widget.zoom.a
        public void c(boolean z16) {
            this.f230080a.forceFinished(z16);
        }

        @Override // com.tencent.mobileqq.guild.media.widget.zoom.a
        public int d() {
            return this.f230080a.getCurrX();
        }

        @Override // com.tencent.mobileqq.guild.media.widget.zoom.a
        public int e() {
            return this.f230080a.getCurrY();
        }

        @Override // com.tencent.mobileqq.guild.media.widget.zoom.a
        public boolean g() {
            return this.f230080a.isFinished();
        }
    }

    public static a f(Context context) {
        return new C7846a(context);
    }

    public abstract boolean a();

    public abstract void b(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36);

    public abstract void c(boolean z16);

    public abstract int d();

    public abstract int e();

    public abstract boolean g();
}
