package com.tencent.mobileqq.qqvideoedit.editor;

import android.graphics.Matrix;
import android.graphics.RectF;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qqvideoedit.editor.VideoEditorViewModel;
import com.tencent.mobileqq.qqvideoedit.editor.draft.VideoEditData;
import com.tencent.mobileqq.qqvideoedit.editor.sticker.VideoStickerModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.Size;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.ComposeRenderLayer;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.tavcut.render.player.IPlayer;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001(J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\n\u0010\t\u001a\u0004\u0018\u00010\bH&J\n\u0010\u000b\u001a\u0004\u0018\u00010\nH&J\n\u0010\r\u001a\u0004\u0018\u00010\fH&J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000eH&J\b\u0010\u0011\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0012H&J\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0014H&J\u0010\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u0016H&J\b\u0010\u0019\u001a\u00020\u0016H&J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH&J\b\u0010\u001d\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH&J\u0016\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u001a\u0018\u00010 H&J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H&J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010$\u001a\u00020#H&J\b\u0010(\u001a\u00020'H&J\b\u0010)\u001a\u00020'H&J\b\u0010*\u001a\u00020'H&J\u000e\u0010,\u001a\b\u0012\u0004\u0012\u00020+0\u0014H&J\b\u0010-\u001a\u00020\u000eH&J\b\u0010.\u001a\u00020\u0006H&J\b\u0010/\u001a\u00020\u000eH&J\b\u00100\u001a\u00020\u000eH&J\b\u00101\u001a\u00020\u000eH&J\u0018\u00106\u001a\u00020\u00062\u0006\u00103\u001a\u0002022\u0006\u00105\u001a\u000204H&\u00a8\u00067"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/aw;", "", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "hostFragment", "Lcom/tencent/mobileqq/qqvideoedit/editor/aw$a;", "params", "", "g0", "Lcom/tencent/tavcut/render/player/IPlayer;", "getPlayer", "Lcom/tencent/tavcut/session/a;", "l", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/ComposeRenderLayer;", "c0", "", "hidden", "b", "release", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "V", "", "e0", "", "durationUs", "W", "getDurationUs", "Lcom/tencent/mobileqq/qqvideoedit/editor/sticker/VideoStickerModel;", "stickerModel", "f0", "T", "i", "a0", "", "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "Y", "o", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/Size;", "a", "getRenderSize", "k", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditData;", DomainData.DOMAIN_NAME, "U", "Z", "b0", "d0", "p", "Landroid/graphics/Matrix;", "matrix", "Landroid/graphics/RectF;", "rectF", "X", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public interface aw {

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0086\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\r\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u001f\u001a\u00020\u0004\u0012\u0006\u0010!\u001a\u00020\u0004\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0017\u0010\u0011\u001a\u00020\r8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\t\u0010\u0010R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0019\u001a\u0004\b\u0014\u0010\u001aR\u0017\u0010\u001f\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001c\u0010\u001eR\u0017\u0010!\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u000e\u0010\u001e\u00a8\u0006$"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/editor/aw$a;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Z", "isInit", "()Z", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "b", "Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "()Lcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;", "editMode", "", "Lcom/tencent/mobileqq/qqvideoedit/editor/draft/VideoEditData;", "c", "Ljava/util/List;", "d", "()Ljava/util/List;", "videoEditData", "Ljava/lang/String;", "()Ljava/lang/String;", "templatePath", "e", "I", "()I", "width", "f", "height", "<init>", "(ZLcom/tencent/mobileqq/qqvideoedit/editor/VideoEditorViewModel$EditMode;Ljava/util/List;Ljava/lang/String;II)V", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.qqvideoedit.editor.aw$a, reason: from toString */
    /* loaded from: classes17.dex */
    public static final /* data */ class VideoTavCutParams {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isInit;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final VideoEditorViewModel.EditMode editMode;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final List<VideoEditData> videoEditData;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        @Nullable
        private final String templatePath;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        private final int width;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        private final int height;

        public VideoTavCutParams(boolean z16, @NotNull VideoEditorViewModel.EditMode editMode, @NotNull List<VideoEditData> videoEditData, @Nullable String str, int i3, int i16) {
            Intrinsics.checkNotNullParameter(editMode, "editMode");
            Intrinsics.checkNotNullParameter(videoEditData, "videoEditData");
            this.isInit = z16;
            this.editMode = editMode;
            this.videoEditData = videoEditData;
            this.templatePath = str;
            this.width = i3;
            this.height = i16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final VideoEditorViewModel.EditMode getEditMode() {
            return this.editMode;
        }

        /* renamed from: b, reason: from getter */
        public final int getHeight() {
            return this.height;
        }

        @Nullable
        /* renamed from: c, reason: from getter */
        public final String getTemplatePath() {
            return this.templatePath;
        }

        @NotNull
        public final List<VideoEditData> d() {
            return this.videoEditData;
        }

        /* renamed from: e, reason: from getter */
        public final int getWidth() {
            return this.width;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof VideoTavCutParams)) {
                return false;
            }
            VideoTavCutParams videoTavCutParams = (VideoTavCutParams) other;
            if (this.isInit == videoTavCutParams.isInit && this.editMode == videoTavCutParams.editMode && Intrinsics.areEqual(this.videoEditData, videoTavCutParams.videoEditData) && Intrinsics.areEqual(this.templatePath, videoTavCutParams.templatePath) && this.width == videoTavCutParams.width && this.height == videoTavCutParams.height) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12 */
        /* JADX WARN: Type inference failed for: r0v13 */
        public int hashCode() {
            int hashCode;
            boolean z16 = this.isInit;
            ?? r06 = z16;
            if (z16) {
                r06 = 1;
            }
            int hashCode2 = ((((r06 * 31) + this.editMode.hashCode()) * 31) + this.videoEditData.hashCode()) * 31;
            String str = this.templatePath;
            if (str == null) {
                hashCode = 0;
            } else {
                hashCode = str.hashCode();
            }
            return ((((hashCode2 + hashCode) * 31) + this.width) * 31) + this.height;
        }

        @NotNull
        public String toString() {
            return "VideoTavCutParams(isInit=" + this.isInit + ", editMode=" + this.editMode + ", videoEditData=" + this.videoEditData + ", templatePath=" + this.templatePath + ", width=" + this.width + ", height=" + this.height + ")";
        }
    }

    void T();

    boolean U();

    @NotNull
    MediaModel V();

    void W(long durationUs);

    void X(@NotNull Matrix matrix, @NotNull RectF rectF);

    void Y(float volume);

    void Z();

    @NotNull
    Size a();

    void a0(@NotNull VideoStickerModel stickerModel);

    void b(boolean hidden);

    boolean b0();

    @Nullable
    ComposeRenderLayer c0();

    boolean d0();

    @NotNull
    List<MediaModel> e0();

    void f0(@NotNull VideoStickerModel stickerModel);

    void g0(@NotNull BasePartFragment hostFragment, @NotNull VideoTavCutParams params);

    long getDurationUs();

    @Nullable
    IPlayer getPlayer();

    @NotNull
    Size getRenderSize();

    void i();

    @NotNull
    Size k();

    @Nullable
    com.tencent.tavcut.session.a l();

    @Nullable
    Map<String, VideoStickerModel> m();

    @NotNull
    List<VideoEditData> n();

    void o(float volume);

    boolean p();

    void release();
}
