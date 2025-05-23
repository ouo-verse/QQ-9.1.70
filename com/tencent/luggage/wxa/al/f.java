package com.tencent.luggage.wxa.al;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.tencent.luggage.wxa.mg.g;
import com.tencent.luggage.wxa.mg.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public final class f implements g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f121555a;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(Context context) {
        this(context, null, 2, 0 == true ? 1 : 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(double d16) {
        return this.f121555a.a(d16);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean c() {
        return this.f121555a.c();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void d() {
        this.f121555a.d();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void f() {
        this.f121555a.f();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void g() {
        this.f121555a.g();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCacheTimeSec() {
        return this.f121555a.getCacheTimeSec();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCurrPosMs() {
        return this.f121555a.getCurrPosMs();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getCurrPosSec() {
        return this.f121555a.getCurrPosSec();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getPlayerType() {
        return this.f121555a.getPlayerType();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public int getVideoDurationSec() {
        return this.f121555a.getVideoDurationSec();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public View getView() {
        return this.f121555a.getView();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean i() {
        return this.f121555a.i();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean isPlaying() {
        return this.f121555a.isPlaying();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void j() {
        this.f121555a.j();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean pause() {
        return this.f121555a.pause();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setCover(Bitmap bitmap) {
        this.f121555a.setCover(bitmap);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setFullDirection(int i3) {
        this.f121555a.setFullDirection(i3);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setIMMVideoViewCallback(g.c cVar) {
        this.f121555a.setIMMVideoViewCallback(cVar);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setIsShowBasicControls(boolean z16) {
        this.f121555a.setIsShowBasicControls(z16);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public /* synthetic */ void setMinBufferDuration(long j3) {
        i31.d.a(this, j3);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setMute(boolean z16) {
        this.f121555a.setMute(z16);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setScaleType(g.h hVar) {
        this.f121555a.setScaleType(hVar);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoContext(k p06) {
        Intrinsics.checkNotNullParameter(p06, "p0");
        this.f121555a.setVideoContext(p06);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoFooterView(g.b bVar) {
        this.f121555a.setVideoFooterView(bVar);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void setVideoSource(int i3) {
        this.f121555a.setVideoSource(i3);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void start() {
        this.f121555a.start();
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void stop() {
        this.f121555a.stop();
    }

    public f(Context context, e thumbVideoView) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(thumbVideoView, "thumbVideoView");
        this.f121555a = thumbVideoView;
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(double d16, boolean z16) {
        return this.f121555a.a(d16, z16);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public boolean a(float f16) {
        return this.f121555a.a(f16);
    }

    public /* synthetic */ f(Context context, e eVar, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? new e(context) : eVar);
    }

    @Override // com.tencent.luggage.wxa.mg.g
    public void a(boolean z16, String str, int i3) {
        this.f121555a.a(z16, str, i3);
    }
}
