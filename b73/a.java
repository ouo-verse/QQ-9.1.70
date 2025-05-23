package b73;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.music.vo.WinkEditorMusicInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0002H&J\b\u0010\u000e\u001a\u00020\rH&J\b\u0010\u0010\u001a\u00020\u000fH&\u00a8\u0006\u0011"}, d2 = {"Lb73/a;", "", "Lcom/tencent/mobileqq/wink/editor/music/vo/WinkEditorMusicInfo;", "selectedMusicInfo", "", "position", "", "J0", "", "enableMusicCut", "M", "musicInfo", "z5", "Lcom/tencent/mobileqq/wink/editor/WinkEditorViewModel$EditMode;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "oc", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public interface a {
    @NotNull
    WinkEditorViewModel.EditMode A();

    void J0(@Nullable WinkEditorMusicInfo selectedMusicInfo, int position);

    void M(boolean enableMusicCut);

    @NotNull
    /* renamed from: oc */
    String getPgId();

    void z5(@NotNull WinkEditorMusicInfo musicInfo);
}
