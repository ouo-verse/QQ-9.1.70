package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

/* loaded from: classes10.dex */
class PokeItemAnimationManager$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f179385d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ String f179386e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ Context f179387f;
    final /* synthetic */ k this$0;

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (QLog.isColorLevel()) {
                QLog.d("LzmaUtils", 2, "inFileDir:" + this.f179385d + " | outFileDir:" + this.f179386e);
            }
            FileUtils.uncompressZip(this.f179385d, this.f179386e, false);
        } catch (IOException e16) {
            if (QLog.isColorLevel()) {
                QLog.d("LzmaUtils", 2, e16, new Object[0]);
            }
        }
        k.a(null, this.f179386e, this.f179387f);
    }
}
