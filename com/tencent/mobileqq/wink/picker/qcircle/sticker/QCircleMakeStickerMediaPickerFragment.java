package com.tencent.mobileqq.wink.picker.qcircle.sticker;

import android.view.View;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.wink.utils.j;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u000b2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\r"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "Ze", "<init>", "()V", "b0", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleMakeStickerMediaPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f325106a0 = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/sticker/QCircleMakeStickerMediaPickerFragment$b", "Lcom/tencent/mobileqq/wink/utils/j$a;", "", "hasFace", "isLegal", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements j.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f325107a;

        b(LocalMediaInfo localMediaInfo) {
            this.f325107a = localMediaInfo;
        }

        @Override // com.tencent.mobileqq.wink.utils.j.a
        public void a(boolean hasFace, boolean isLegal) {
            if (isLegal) {
                com.tencent.mobileqq.wink.picker.core.c.f324480a.i(QCircleMakeStickerMediaPreviewFragment.INSTANCE.a(this.f325107a));
            } else {
                QQToast.makeText(BaseApplication.getContext().getApplicationContext(), R.string.f240447p7, 0).show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ci(LocalMediaInfo localMediaInfo) {
        String str = localMediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
        j.i(str, false, new b(localMediaInfo));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public Config Fh(@NotNull Config config) {
        Config copy;
        Intrinsics.checkNotNullParameter(config, "config");
        copy = config.copy((r34 & 1) != 0 ? config.localMediaTabType : TabType.ONLY_IMAGE, (r34 & 2) != 0 ? config.initLocalMediaTab : null, (r34 & 4) != 0 ? config.initLocalDbQueryType : null, (r34 & 8) != 0 ? config.ZoneMediaTabType : null, (r34 & 16) != 0 ? config.needDragSelect : false, (r34 & 32) != 0 ? config.needScrollTimeline : false, (r34 & 64) != 0 ? config.maxSelectMediaSize : 0, (r34 & 128) != 0 ? config.startCountNum : 0, (r34 & 256) != 0 ? config.alreadySelectedMediaPath : null, (r34 & 512) != 0 ? config.alreadySelectedMedia : null, (r34 & 1024) != 0 ? config.queryMediaFilter : null, (r34 & 2048) != 0 ? config.selectMediaFilter : null, (r34 & 4096) != 0 ? config.needShowExitDialog : false, (r34 & 8192) != 0 ? config.firstIconCamera : false, (r34 & 16384) != 0 ? config.businessRequestCode : 0, (r34 & 32768) != 0 ? config.from : null);
        return copy;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable final LocalMediaInfo mediaInfo) {
        if (FastClickUtils.isFastDoubleClick("QCircleMakeStickerMediaPickerFragment", 500L) || mediaInfo == null) {
            return;
        }
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.sticker.a
            @Override // java.lang.Runnable
            public final void run() {
                QCircleMakeStickerMediaPickerFragment.Ci(LocalMediaInfo.this);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.f325106a0.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
