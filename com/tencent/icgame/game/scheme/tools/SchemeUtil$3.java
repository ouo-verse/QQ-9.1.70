package com.tencent.icgame.game.scheme.tools;

import android.content.Context;
import android.content.Intent;

/* compiled from: P */
/* loaded from: classes7.dex */
class SchemeUtil$3 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ Intent f115820d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Context f115821e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ String f115822f;

    @Override // java.lang.Runnable
    public void run() {
        try {
            Intent intent = this.f115820d;
            if (intent != null) {
                this.f115821e.startActivity(intent);
            } else {
                a.a(this.f115821e, this.f115822f);
            }
        } catch (Exception unused) {
        }
    }
}
