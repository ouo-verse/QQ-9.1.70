package com.tencent.mobileqq.wink.picker.qcircle;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.WinkCoroutineScopes;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.InitBean;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment;
import com.tencent.mobileqq.winkpublish.util.PublishVideoUtils;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0017B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\b\u0010\u000b\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014J\u0012\u0010\u0012\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleCollectionPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleCollectionPickerFragment$b;", "callBack", "", "Ei", "", "path", "Gi", "getLogTag", "Lcom/tencent/mobileqq/wink/picker/InitBean;", "Oh", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Fh", "mediaInfo", "Ze", "<init>", "()V", "b0", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QCircleCollectionPickerFragment extends SingleMediaPickerFragment {

    /* renamed from: a0, reason: collision with root package name */
    @NotNull
    public Map<Integer, View> f324943a0 = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleCollectionPickerFragment$b;", "", "", "framePath", "", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static abstract class b {
        public abstract void a(@NotNull String framePath);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/mobileqq/wink/picker/qcircle/QCircleCollectionPickerFragment$c", "Lcom/tencent/mobileqq/wink/picker/qcircle/QCircleCollectionPickerFragment$b;", "", "framePath", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c extends b {
        c() {
        }

        @Override // com.tencent.mobileqq.wink.picker.qcircle.QCircleCollectionPickerFragment.b
        public void a(@NotNull String framePath) {
            boolean z16;
            Intrinsics.checkNotNullParameter(framePath, "framePath");
            if (framePath.length() > 0) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                QCircleCollectionPickerFragment.this.Gi(framePath);
            }
        }
    }

    private final void Ei(final LocalMediaInfo selectedMedia, final b callBack) {
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.a
            @Override // java.lang.Runnable
            public final void run() {
                QCircleCollectionPickerFragment.Fi(LocalMediaInfo.this, callBack);
            }
        }, 64, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Fi(LocalMediaInfo selectedMedia, b callBack) {
        Intrinsics.checkNotNullParameter(selectedMedia, "$selectedMedia");
        Intrinsics.checkNotNullParameter(callBack, "$callBack");
        w53.b.a("QCircleCollectionPickerFragment", "get frame: " + selectedMedia);
        if (e93.i.E(selectedMedia)) {
            if (!e93.i.I(selectedMedia)) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(WinkCoroutineScopes.f317652a.c()), null, null, new QCircleCollectionPickerFragment$getFirstFramePath$1$1(selectedMedia, callBack, null), 3, null);
                return;
            }
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            mediaMetadataRetriever.setDataSource(e93.i.j(selectedMedia), new HashMap());
            Bitmap frameAtTime = mediaMetadataRetriever.getFrameAtTime(500L, 2);
            String str = u53.a.f438366g + File.separator + e93.i.v(selectedMedia);
            w53.b.a("QCircleCollectionPickerFragment", "qzone video frame path: " + str);
            if (new File(str).exists()) {
                callBack.a(str);
                return;
            }
            String saveBitmapToLocal = PublishVideoUtils.saveBitmapToLocal(frameAtTime, str);
            Intrinsics.checkNotNullExpressionValue(saveBitmapToLocal, "saveBitmapToLocal(bitmap, firstFramePath)");
            callBack.a(saveBitmapToLocal);
            return;
        }
        if (e93.i.I(selectedMedia)) {
            String videoCover = PublishVideoUtils.getVideoCover(selectedMedia.path);
            w53.b.a("QCircleCollectionPickerFragment", "video frame path: " + videoCover);
            if (videoCover != null) {
                Intrinsics.checkNotNullExpressionValue(videoCover, "this");
                callBack.a(videoCover);
                return;
            }
            return;
        }
        String str2 = selectedMedia.path;
        if (str2 == null) {
            str2 = "";
        }
        callBack.a(str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Gi(final String path) {
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.wink.picker.qcircle.b
            @Override // java.lang.Runnable
            public final void run() {
                QCircleCollectionPickerFragment.Hi(QCircleCollectionPickerFragment.this, path);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hi(QCircleCollectionPickerFragment this$0, String path) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(path, "$path");
        FragmentActivity requireActivity = this$0.requireActivity();
        w53.b.a("QCircleCollectionPickerFragment", "jump to media crop: " + path);
        requireActivity.getIntent().putExtra(QQWinkConstants.PICK_MEDIA_FRAME_PATH, path);
        requireActivity.setResult(-1, requireActivity.getIntent());
        requireActivity.finish();
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

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public InitBean Oh() {
        return new InitBean(false, null, 3, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment
    public void Ze(@Nullable LocalMediaInfo mediaInfo) {
        if (mediaInfo == null) {
            w53.b.a("QCircleCollectionPickerFragment", "selected media is null");
        } else {
            Ei(mediaInfo, new c());
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.f324943a0.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QCircleCollectionPickerFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
