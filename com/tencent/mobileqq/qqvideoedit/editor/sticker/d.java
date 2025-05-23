package com.tencent.mobileqq.qqvideoedit.editor.sticker;

import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qqvideoedit.editor.VideoTavCut;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.BackgroundModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.SizeF;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.StickerModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/d;", "", "a", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00078\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\tR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000e8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0012\u001a\u00020\u00118\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00148\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/d$a;", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "videoStickerModel", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoTavCut;", "tavCut", "a", "", "PROGRESS_PROPORTION_FONT_FILE", "D", "PROGRESS_PROPORTION_PAG_ZIP", "", "STICKER_ADD_OFFSET", UserInfo.SEX_FEMALE, "", "STICKER_DURATION_US", "J", "", "STICKER_MAX_HEIGHT", "I", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.sticker.d$a, reason: from kotlin metadata */
    /* loaded from: classes17.dex */
    public static final class Companion {

        /* compiled from: P */
        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.sticker.d$a$a, reason: collision with other inner class name */
        /* loaded from: classes17.dex */
        public /* synthetic */ class C8438a {

            /* renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f275825a;

            static {
                int[] iArr = new int[StickerModel.Type.values().length];
                try {
                    iArr[StickerModel.Type.TOP_FRAME.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[StickerModel.Type.BOTTOM_FRAME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                f275825a = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final VideoStickerModel a(@NotNull VideoStickerModel videoStickerModel, @NotNull VideoTavCut tavCut) {
            float f16;
            Intrinsics.checkNotNullParameter(videoStickerModel, "videoStickerModel");
            Intrinsics.checkNotNullParameter(tavCut, "tavCut");
            try {
                int i3 = C8438a.f275825a[videoStickerModel.type.ordinal()];
                if (i3 != 1) {
                    if (i3 != 2) {
                        return videoStickerModel;
                    }
                    BackgroundModel backgroundModel = tavCut.V().backgroundModel;
                    Intrinsics.checkNotNull(backgroundModel);
                    SizeF sizeF = backgroundModel.renderSize;
                    Intrinsics.checkNotNull(sizeF);
                    float f17 = 1280;
                    float f18 = sizeF.width * f17;
                    BackgroundModel backgroundModel2 = tavCut.V().backgroundModel;
                    Intrinsics.checkNotNull(backgroundModel2);
                    SizeF sizeF2 = backgroundModel2.renderSize;
                    Intrinsics.checkNotNull(sizeF2);
                    float f19 = (f18 / sizeF2.height) / videoStickerModel.width;
                    int i16 = videoStickerModel.height;
                    float f26 = ((i16 * f19) / f17) - 1;
                    if (f26 > (-0.33333334f) - ((i16 * f19) / f17)) {
                        f16 = (-0.33333334f) - ((i16 * f19) / f17);
                    } else {
                        f16 = f26;
                    }
                    return VideoStickerModel.copyAndUpdate$default(videoStickerModel, null, null, 0L, 0L, 0, f19, 0.0f, 0.0f, f16, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -417, 31, null);
                }
                BackgroundModel backgroundModel3 = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel3);
                SizeF sizeF3 = backgroundModel3.renderSize;
                Intrinsics.checkNotNull(sizeF3);
                float f27 = 1280;
                float f28 = sizeF3.width * f27;
                BackgroundModel backgroundModel4 = tavCut.V().backgroundModel;
                Intrinsics.checkNotNull(backgroundModel4);
                SizeF sizeF4 = backgroundModel4.renderSize;
                Intrinsics.checkNotNull(sizeF4);
                float f29 = (f28 / sizeF4.height) / videoStickerModel.width;
                int i17 = videoStickerModel.height;
                float f36 = 1 - ((i17 * f29) / f27);
                if (f36 < ((i17 * f29) / f27) + 0.33333334f) {
                    f36 = ((i17 * f29) / f27) + 0.33333334f;
                }
                return VideoStickerModel.copyAndUpdate$default(videoStickerModel, null, null, 0L, 0L, 0, f29, 0.0f, 0.0f, f36, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, null, 0.0f, 0.0f, null, null, null, null, null, null, -417, 31, null);
            } catch (Exception e16) {
                ms.a.e("TextMetaMaterial", e16);
                return videoStickerModel;
            }
        }

        Companion() {
        }
    }
}
