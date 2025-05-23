package com.tencent.zplan.meme.encoder;

import com.tencent.map.geolocation.TencentLocation;
import com.tencent.zplan.common.utils.LogUtil;
import kotlin.Metadata;
import lx4.d;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n\u00a2\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", TencentLocation.RUN_MODE}, k = 3, mv = {1, 4, 2})
/* loaded from: classes27.dex */
final class MemeEncodeController$onSingleFrame$1 implements Runnable {

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ b f385784d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ int f385785e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ byte[] f385786f;

    /* renamed from: h, reason: collision with root package name */
    final /* synthetic */ int f385787h;

    /* renamed from: i, reason: collision with root package name */
    final /* synthetic */ int f385788i;
    final /* synthetic */ MemeEncodeController this$0;

    @Override // java.lang.Runnable
    public final void run() {
        String str;
        String str2;
        try {
            this.f385784d.getEncoder().b(this.f385785e, this.f385786f, this.f385787h, this.f385788i);
        } catch (Exception e16) {
            d a16 = LogUtil.f385285b.a();
            if (a16 != null) {
                str2 = this.this$0.TAG;
                a16.e(str2, 1, "onRecordFrame error in handler", e16);
            }
        } catch (OutOfMemoryError e17) {
            d a17 = LogUtil.f385285b.a();
            if (a17 != null) {
                str = this.this$0.TAG;
                a17.e(str, 1, "onRecordFrame oom in handler", e17);
            }
            this.f385784d.getStatistic().d(true);
        }
    }
}
