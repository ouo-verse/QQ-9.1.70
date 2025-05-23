package h73;

import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.WinkEditorFragment;
import com.tencent.mobileqq.wink.report.g;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkDatongCurrentParams;
import com.tencent.videocut.model.MediaClip;
import com.tencent.videocut.model.MediaType;
import com.tencent.videocut.model.ResourceModel;
import cooperation.peak.PeakConstants;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lh73/a;", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bJ\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007\u00a8\u0006\f"}, d2 = {"Lh73/a$a;", "", "", "Lcom/tencent/videocut/model/MediaClip;", "videos", "", "b", "Lcom/tencent/biz/richframework/part/BasePartFragment;", "hostFragment", "a", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: h73.a$a, reason: collision with other inner class name and from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(@NotNull BasePartFragment hostFragment) {
            boolean isBlank;
            Intrinsics.checkNotNullParameter(hostFragment, "hostFragment");
            if (hostFragment instanceof WinkEditorFragment) {
                WinkEditorFragment winkEditorFragment = (WinkEditorFragment) hostFragment;
                boolean z16 = false;
                boolean booleanExtra = winkEditorFragment.getHostActivity().getIntent().getBooleanExtra(QQWinkConstants.IS_AUTO_TEMPLATE, false);
                String stringExtra = winkEditorFragment.getHostActivity().getIntent().getStringExtra(QQWinkConstants.ENTRY_BUSINESS_NAME);
                if (booleanExtra) {
                    if (stringExtra != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(stringExtra);
                        if (!isBlank) {
                            z16 = true;
                        }
                    }
                    if (z16) {
                        g.b(stringExtra, winkEditorFragment.getHostActivity().getIntent().getStringExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID));
                    }
                }
            }
        }

        public final void b(@NotNull List<? extends MediaClip> videos) {
            MediaType mediaType;
            Intrinsics.checkNotNullParameter(videos, "videos");
            Iterator<? extends MediaClip> it = videos.iterator();
            int i3 = 0;
            int i16 = 0;
            while (it.hasNext()) {
                ResourceModel resourceModel = it.next().resource;
                if (resourceModel != null) {
                    mediaType = resourceModel.type;
                } else {
                    mediaType = null;
                }
                if (mediaType == MediaType.IMAGE) {
                    i16++;
                } else {
                    i3++;
                }
            }
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_CONTENT_NUM, Integer.valueOf(i3 + i16));
            WinkDatongCurrentParams.put("xsj_picture_num", Integer.valueOf(i16));
            WinkDatongCurrentParams.put(WinkDaTongReportConstant.ElementParamKey.XSJ_VIDEO_NUM, Integer.valueOf(i3));
        }

        Companion() {
        }
    }
}
