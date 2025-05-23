package com.tencent.mobileqq.wink.picker.core;

import android.view.View;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.advrreport.QAdVrReportParams;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment$initMediaPickerFactory$1$mediaItemClickListener$2;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener;
import com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/UniversalMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Zh", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "", "Ze", "", "requestCode", "", "P5", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public abstract class SingleMediaPickerFragment extends UniversalMediaPickerFragment {

    @NotNull
    public Map<Integer, View> Z = new LinkedHashMap();

    public boolean P5(int requestCode) {
        return false;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.Single;
    }

    public abstract void Ze(@Nullable LocalMediaInfo mediaInfo);

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public d Zh() {
        return new UniversalMediaPickerFactory() { // from class: com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment$initMediaPickerFactory$1

            /* renamed from: d, reason: collision with root package name and from kotlin metadata */
            private boolean singleSelectMode;

            /* renamed from: e, reason: collision with root package name and from kotlin metadata */
            @NotNull
            private final Lazy mediaItemClickListener;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(false);
                Lazy lazy;
                this.singleSelectMode = true;
                lazy = LazyKt__LazyJVMKt.lazy(new Function0<SingleMediaPickerFragment$initMediaPickerFactory$1$mediaItemClickListener$2.a>() { // from class: com.tencent.mobileqq.wink.picker.core.SingleMediaPickerFragment$initMediaPickerFactory$1$mediaItemClickListener$2

                    @Metadata(d1 = {"\u00003\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J6\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u000bH\u0016\u00a8\u0006\u0012"}, d2 = {"com/tencent/mobileqq/wink/picker/core/SingleMediaPickerFragment$initMediaPickerFactory$1$mediaItemClickListener$2$a", "Lcom/tencent/mobileqq/wink/picker/core/universal/UniversalMediaItemClickListener;", "Landroid/view/View;", "v", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", QAdVrReportParams.ParamKey.MEDIA, "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "layoutPosition", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "winkMediaViewModel", "", "b", "itemInfo", "selectedMediaViewModel", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
                    /* loaded from: classes21.dex */
                    public static final class a extends UniversalMediaItemClickListener {

                        /* renamed from: b, reason: collision with root package name */
                        final /* synthetic */ SingleMediaPickerFragment f324463b;

                        a(SingleMediaPickerFragment singleMediaPickerFragment) {
                            this.f324463b = singleMediaPickerFragment;
                        }

                        @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener, com.tencent.mobileqq.wink.picker.core.a
                        public int a(@NotNull View v3, @NotNull LocalMediaInfo itemInfo, @NotNull MediaType mediaType, @NotNull WinkSelectedMediaViewModel selectedMediaViewModel) {
                            Intrinsics.checkNotNullParameter(v3, "v");
                            Intrinsics.checkNotNullParameter(itemInfo, "itemInfo");
                            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
                            Intrinsics.checkNotNullParameter(selectedMediaViewModel, "selectedMediaViewModel");
                            this.f324463b.Ze(itemInfo);
                            return 2;
                        }

                        @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaItemClickListener, com.tencent.mobileqq.wink.picker.core.a
                        public void b(@NotNull View v3, @NotNull List<? extends LocalMediaInfo> media, @NotNull MediaType mediaType, int layoutPosition, @NotNull WinkSelectedMediaViewModel winkMediaViewModel) {
                            Object orNull;
                            Intrinsics.checkNotNullParameter(v3, "v");
                            Intrinsics.checkNotNullParameter(media, "media");
                            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
                            Intrinsics.checkNotNullParameter(winkMediaViewModel, "winkMediaViewModel");
                            SingleMediaPickerFragment singleMediaPickerFragment = this.f324463b;
                            orNull = CollectionsKt___CollectionsKt.getOrNull(media, layoutPosition);
                            singleMediaPickerFragment.Ze((LocalMediaInfo) orNull);
                        }
                    }

                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    @NotNull
                    public final a invoke() {
                        return new a(SingleMediaPickerFragment.this);
                    }
                });
                this.mediaItemClickListener = lazy;
            }

            @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
            @NotNull
            public a a() {
                return (a) this.mediaItemClickListener.getValue();
            }

            @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
            public boolean c(int requestCode) {
                return SingleMediaPickerFragment.this.P5(requestCode);
            }

            @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
            /* renamed from: d, reason: from getter */
            public boolean getSingleSelectMode() {
                return this.singleSelectMode;
            }

            @Override // com.tencent.mobileqq.wink.picker.core.universal.UniversalMediaPickerFactory, com.tencent.mobileqq.wink.picker.core.d
            public void e(boolean z16) {
                this.singleSelectMode = z16;
            }
        };
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.Z.clear();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment, com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
