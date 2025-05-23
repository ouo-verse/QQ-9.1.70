package com.tencent.mobileqq.wink.picker.qcircle;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.tencent.mobileqq.wink.picker.MediaFilter;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment;
import com.tencent.mobileqq.wink.picker.qcircle.viewmodel.QCircleTemplateMediaPickerViewModel;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006R\u0017\u0010\u0010\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0012\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0014\u001a\u00020\f8\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0013\u0010\u000f\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qcircle/c;", "", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/a;", "a", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerBaseFragment;", "fragment", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/c;", "b", "Lcom/tencent/mobileqq/wink/picker/qcircle/viewmodel/QCircleTemplateMediaPickerViewModel;", "f", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "c", "()Lcom/tencent/mobileqq/wink/picker/MediaFilter;", "selectMediaFilter", "e", "selectMediaFilterForZShow", "d", "selectMediaFilterForMemoryAlbum", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f324971a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MediaFilter selectMediaFilter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MediaFilter selectMediaFilterForZShow;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final MediaFilter selectMediaFilterForMemoryAlbum;

    static {
        MediaFilter a16;
        if (QzoneConfig.isWinkPublishLimitVideoResolution()) {
            MediaFilter.Companion companion = MediaFilter.INSTANCE;
            MediaFilter.a aVar = new MediaFilter.a();
            aVar.e(0.375f);
            aVar.c(2.5f);
            aVar.i(3000);
            aVar.h(3000);
            aVar.j(1000L);
            a16 = aVar.a();
        } else {
            MediaFilter.Companion companion2 = MediaFilter.INSTANCE;
            MediaFilter.a aVar2 = new MediaFilter.a();
            aVar2.e(0.375f);
            aVar2.c(2.5f);
            aVar2.j(1000L);
            a16 = aVar2.a();
        }
        selectMediaFilter = a16;
        MediaFilter.a aVar3 = new MediaFilter.a();
        aVar3.e(0.375f);
        aVar3.c(2.5f);
        aVar3.j(2000L);
        selectMediaFilterForZShow = aVar3.a();
        MediaFilter.a aVar4 = new MediaFilter.a();
        aVar4.e(0.375f);
        aVar4.c(2.5f);
        aVar4.j(2000L);
        aVar4.g(900000L);
        selectMediaFilterForMemoryAlbum = aVar4.a();
    }

    c() {
    }

    @NotNull
    public final com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a a(@NotNull FragmentActivity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ViewModel viewModel = new ViewModelProvider(activity).get(com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(activi\u2026ipsViewModel::class.java)");
        return (com.tencent.mobileqq.wink.picker.qcircle.viewmodel.a) viewModel;
    }

    @NotNull
    public final com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c b(@NotNull WinkMediaPickerBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026nerViewModel::class.java)");
        return (com.tencent.mobileqq.wink.picker.qcircle.viewmodel.c) viewModel;
    }

    @NotNull
    public final MediaFilter c() {
        return selectMediaFilter;
    }

    @NotNull
    public final MediaFilter d() {
        return selectMediaFilterForMemoryAlbum;
    }

    @NotNull
    public final MediaFilter e() {
        return selectMediaFilterForZShow;
    }

    @NotNull
    public final QCircleTemplateMediaPickerViewModel f(@NotNull WinkMediaPickerBaseFragment fragment) {
        Intrinsics.checkNotNullParameter(fragment, "fragment");
        ViewModel viewModel = new ViewModelProvider(fragment).get(QCircleTemplateMediaPickerViewModel.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(fragme\u2026kerViewModel::class.java)");
        return (QCircleTemplateMediaPickerViewModel) viewModel;
    }
}
