package com.tencent.mobileqq.wink.editor.sticker;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.ds;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.ResourceModel;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0016\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/sticker/b;", "", "Lcom/tencent/mobileqq/wink/editor/WinkVideoTavCut;", "cut", "", "endTime", "b", "J", "US_LONG", "c", "DEFAULT_FRAME_GAP", "Ljava/util/concurrent/ConcurrentHashMap;", "", "d", "Ljava/util/concurrent/ConcurrentHashMap;", "clipsFrameGap", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f321561a = new b();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final long US_LONG = 1000000;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static final long DEFAULT_FRAME_GAP = 33333;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ConcurrentHashMap<String, Long> clipsFrameGap = new ConcurrentHashMap<>();

    b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void c(String path) {
        long j3;
        Intrinsics.checkNotNullParameter(path, "$path");
        int x16 = com.tencent.mobileqq.wink.editor.export.j.x(path);
        ConcurrentHashMap<String, Long> concurrentHashMap = clipsFrameGap;
        if (x16 > 0) {
            j3 = US_LONG / x16;
        } else {
            j3 = DEFAULT_FRAME_GAP;
        }
        concurrentHashMap.put(path, Long.valueOf(j3));
        ms.a.f("wink_sticker_TextMetaMaterial", "getEndSeekTime|getVideoFrameRate:" + path + ",fps=" + x16 + ",frameGap:" + clipsFrameGap.get(path));
    }

    public final long b(@NotNull WinkVideoTavCut cut, long endTime) {
        ResourceModel resourceModel;
        final String str;
        long longValue;
        Intrinsics.checkNotNullParameter(cut, "cut");
        MediaClip b16 = ds.b(cut, endTime);
        if (b16 != null && (resourceModel = b16.resource) != null && (str = resourceModel.path) != null) {
            if (clipsFrameGap.get(str) == null) {
                ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.editor.sticker.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        b.c(str);
                    }
                }, 64, null, false);
                longValue = DEFAULT_FRAME_GAP;
            } else {
                Long l3 = clipsFrameGap.get(str);
                Intrinsics.checkNotNull(l3);
                longValue = l3.longValue();
            }
            endTime -= longValue;
        }
        if (endTime < 0) {
            return 0L;
        }
        return endTime;
    }
}
