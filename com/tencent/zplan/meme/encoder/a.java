package com.tencent.zplan.meme.encoder;

import android.graphics.Bitmap;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.zplan.meme.action.ActionStatus;
import java.nio.ByteBuffer;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\bf\u0018\u0000 \u00102\u00020\u0001:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H&J \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u0004H&J\b\u0010\u0011\u001a\u00020\u0002H\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u0012H&J\b\u0010\u0014\u001a\u00020\u0004H&J\b\u0010\u0015\u001a\u00020\nH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/zplan/meme/encoder/a;", "", "", "init", "", "portraitId", "", "pixels", "width", "height", "", "b", "", "outputFilePath", "frameTime", "Lcom/tencent/zplan/meme/action/ActionStatus;", "a", "close", "", "getFrames", "getFrameCount", "c", "record_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes27.dex */
public interface a {

    /* renamed from: a, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = Companion.f385790a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ$\u0010\t\u001a\u00020\b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u00a8\u0006\f"}, d2 = {"Lcom/tencent/zplan/meme/encoder/a$b;", "", "", "", "width", "height", "Landroid/graphics/Bitmap$Config;", DownloadInfo.spKey_Config, "Landroid/graphics/Bitmap;", "a", "<init>", "()V", "record_debug"}, k = 1, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.encoder.a$b, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {

        /* renamed from: a */
        static final /* synthetic */ Companion f385790a = new Companion();

        Companion() {
        }

        public static /* synthetic */ Bitmap b(Companion companion, byte[] bArr, int i3, int i16, Bitmap.Config config, int i17, Object obj) {
            if ((i17 & 4) != 0) {
                config = Bitmap.Config.ARGB_8888;
            }
            return companion.a(bArr, i3, i16, config);
        }

        @NotNull
        public final Bitmap a(@NotNull byte[] toBitmap, int i3, int i16, @NotNull Bitmap.Config config) {
            Intrinsics.checkNotNullParameter(toBitmap, "$this$toBitmap");
            Intrinsics.checkNotNullParameter(config, "config");
            Bitmap createBitmap = Bitmap.createBitmap(i3, i16, config);
            createBitmap.copyPixelsFromBuffer(ByteBuffer.wrap(toBitmap));
            Intrinsics.checkNotNullExpressionValue(createBitmap, "Bitmap.createBitmap(widt\u2026wrap(this))\n            }");
            return createBitmap;
        }
    }

    @NotNull
    ActionStatus a(int portraitId, @NotNull String outputFilePath, int frameTime);

    boolean b(int portraitId, @NotNull byte[] pixels, int width, int height);

    boolean c();

    void close();

    int getFrameCount();

    @NotNull
    List<String> getFrames();

    void init();

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    /* renamed from: com.tencent.zplan.meme.encoder.a$a */
    /* loaded from: classes27.dex */
    public static final class C10067a {
        public static boolean b(@NotNull a aVar) {
            return true;
        }

        public static void a(@NotNull a aVar) {
        }

        public static void c(@NotNull a aVar) {
        }
    }
}
