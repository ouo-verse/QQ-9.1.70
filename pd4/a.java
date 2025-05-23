package pd4;

import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&J \u0010\u000b\u001a\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00022\b\b\u0002\u0010\n\u001a\u00020\tH&\u00a8\u0006\f"}, d2 = {"Lpd4/a;", "", "", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", DownloadInfo.spKey_Config, "", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/tavcut/model/ClipSource;", "clips", "", "modifyClipsDuration", "setClipAssetsWithCallback", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface a {
    void m(@Nullable List<? extends VoiceEnum> config);

    void setClipAssetsWithCallback(@NotNull List<ClipSource> clips, boolean modifyClipsDuration);
}
