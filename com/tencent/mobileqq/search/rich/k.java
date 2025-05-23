package com.tencent.mobileqq.search.rich;

import android.content.Context;
import com.tencent.image.AbstractGifImage;
import com.tencent.mobileqq.search.view.p;

/* compiled from: P */
/* loaded from: classes18.dex */
public class k extends j {
    @Override // com.tencent.mobileqq.search.rich.m, com.tencent.mobileqq.search.rich.f
    public void f(String str, String str2, String str3) {
        super.f(str, str2, str3);
        h b16 = b();
        if (b16 != null) {
            b16.update();
        }
    }

    @Override // com.tencent.mobileqq.search.rich.m
    protected h i(Context context) {
        return new p(this, context);
    }

    @Override // com.tencent.mobileqq.search.rich.m, com.tencent.mobileqq.search.rich.f
    public void pause() {
        super.pause();
        AbstractGifImage.pauseAll();
    }

    @Override // com.tencent.mobileqq.search.rich.m, com.tencent.mobileqq.search.rich.f
    public void resume() {
        super.resume();
        AbstractGifImage.resumeAll();
    }
}
