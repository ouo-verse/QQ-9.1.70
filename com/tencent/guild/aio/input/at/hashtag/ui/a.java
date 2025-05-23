package com.tencent.guild.aio.input.at.hashtag.ui;

import android.app.Activity;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.guild.aio.input.at.hashtag.ui.h;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes6.dex */
public class a extends i {
    public a(@NonNull Activity activity) {
        super(activity);
    }

    private int m() {
        return (this.f110957d.c().getAdapter().getCount() * this.f110958e.f110931a.f110940b) + this.f110958e.f110931a.f110942d;
    }

    @Override // com.tencent.guild.aio.input.at.hashtag.ui.i
    public int b(View view, int i3) {
        int m3 = m();
        h.b bVar = this.f110958e.f110931a;
        if (m3 < (i3 - bVar.f110942d) - bVar.f110943e) {
            return 1;
        }
        return 2;
    }

    @Override // com.tencent.guild.aio.input.at.hashtag.ui.i
    public int d(boolean z16, int i3) {
        if (this.f110954a) {
            if (z16) {
                this.f110959f = Math.min(i3 - this.f110958e.f110931a.f110950l, m());
                if (QLog.isDevelopLevel()) {
                    QLog.d("GuildHashtagUIHelper", 4, "visualHeight: " + this.f110959f + ", usableWindowHeight: " + i3);
                }
                if (i3 != -1) {
                    this.f110959f = Math.min(i3, this.f110959f);
                }
            } else {
                this.f110959f = this.f110957d.c().getHeight();
            }
        }
        return this.f110959f;
    }
}
