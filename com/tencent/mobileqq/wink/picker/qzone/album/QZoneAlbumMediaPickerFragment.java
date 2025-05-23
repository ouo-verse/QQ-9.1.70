package com.tencent.mobileqq.wink.picker.qzone.album;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import com.google.android.material.appbar.AppBarLayout;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.InitBean;
import com.tencent.mobileqq.wink.picker.MediaInfo;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.QZoneInitBean;
import com.tencent.mobileqq.wink.picker.WinkMediaPickerScene;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaListPart;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.picker.core.part.aj;
import com.tencent.mobileqq.wink.picker.core.view.WinkRecyclerViewSkeletonView;
import com.tencent.mobileqq.wink.picker.core.viewmodel.p;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.wink.picker.core.viewmodel.v;
import com.tencent.mobileqq.wink.picker.g;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.data.base.UIStateData;
import cooperation.qzone.QzoneIPCModule;
import e93.QZoneAlbumInfo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 @2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\u0007\u00a2\u0006\u0004\b>\u0010?J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0014J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J \u0010\u001f\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00172\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J \u0010 \u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00172\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\"\u0010&\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0002H\u0016R\u001b\u0010-\u001a\u00020(8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001b\u00102\u001a\u00020.8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b/\u0010*\u001a\u0004\b0\u00101R\u001b\u00107\u001a\u0002038BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b4\u0010*\u001a\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010=\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010<\u00a8\u0006B"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/album/QZoneAlbumMediaPickerFragment;", "Lcom/tencent/mobileqq/wink/picker/core/WinkMediaPickerMainBaseFragment;", "Lcom/tencent/mobileqq/wink/picker/QZoneInitBean;", "", "Mi", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMediaList", "Hi", "Lcom/tencent/mobileqq/wink/picker/WinkMediaPickerScene;", "Sh", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "Landroid/view/View;", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "onResume", "", "onBackEvent", "", "getLogTag", "Lcom/tencent/mobileqq/wink/picker/core/d;", "Zh", "isFromQZoneMedia", "selectedMedia", "di", "hi", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "Ii", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "X", "Lkotlin/Lazy;", "Li", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/v;", "qZoneMediaViewModel", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "Y", "Ji", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "mediaPickerUIStateViewModel", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "Z", "Ki", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "a0", "I", "skeletonViewMarginTop", "b0", "Ljava/lang/String;", "pickerTitle", "<init>", "()V", "c0", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneAlbumMediaPickerFragment extends WinkMediaPickerMainBaseFragment<QZoneInitBean> {

    /* renamed from: c0, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: X, reason: from kotlin metadata */
    @NotNull
    private final Lazy qZoneMediaViewModel;

    /* renamed from: Y, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerUIStateViewModel;

    /* renamed from: Z, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    /* renamed from: a0, reason: collision with root package name and from kotlin metadata */
    private int skeletonViewMarginTop;

    /* renamed from: b0, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private String pickerTitle;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/album/QZoneAlbumMediaPickerFragment$a;", "", "Lcom/tencent/mobileqq/wink/picker/Config;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/picker/InitBean;", "initBean", "Landroid/os/Bundle;", "a", "", "PARAM_PARSE_SCHEMA_PARAMS", "Ljava/lang/String;", "", "QZONE_PREVIEW_REQUEST", "I", "TAG", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qzone.album.QZoneAlbumMediaPickerFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Bundle a(@NotNull Config config, @Nullable InitBean initBean) {
            Intrinsics.checkNotNullParameter(config, "config");
            Bundle bundle = new Bundle();
            bundle.putSerializable("WINK_MEDIA_PICKER_CONFIG", config);
            if (initBean != null) {
                bundle.putSerializable("WINK_MEDIA_PICKER_INIT_BEAN", initBean);
            }
            return bundle;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qzone/album/QZoneAlbumMediaPickerFragment$b", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkMediaPickerNextStepDialogPart.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        @NotNull
        public List<LocalMediaInfo> a() {
            return QZoneAlbumMediaPickerFragment.this.Wh().getSelectedMedia();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public boolean b() {
            return QZoneAlbumMediaPickerFragment.this.Ki().isRunning.get();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public void onCancelClick() {
            QZoneAlbumMediaPickerFragment.this.Ki().f();
        }
    }

    public QZoneAlbumMediaPickerFragment() {
        Lazy lazy;
        Lazy lazy2;
        Lazy lazy3;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<v>() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.QZoneAlbumMediaPickerFragment$qZoneMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final v invoke() {
                return q.i(QZoneAlbumMediaPickerFragment.this);
            }
        });
        this.qZoneMediaViewModel = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<p>() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.QZoneAlbumMediaPickerFragment$mediaPickerUIStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p invoke() {
                FragmentActivity requireActivity = QZoneAlbumMediaPickerFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return q.a(requireActivity);
            }
        });
        this.mediaPickerUIStateViewModel = lazy2;
        lazy3 = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.QZoneAlbumMediaPickerFragment$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                return new WinkMediaPickerNextStepHelper(q.e(QZoneAlbumMediaPickerFragment.this));
            }
        });
        this.nextStepHelper = lazy3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Hi(List<? extends LocalMediaInfo> selectedMediaList) {
        Intent intent = new Intent();
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, new ArrayList(selectedMediaList));
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        for (LocalMediaInfo localMediaInfo : selectedMediaList) {
            String str = localMediaInfo.path;
            if (str != null) {
                Intrinsics.checkNotNullExpressionValue(str, "info.path");
                HashMap<String, Serializable> hashMap3 = localMediaInfo.extData;
                Intrinsics.checkNotNullExpressionValue(hashMap3, "info.extData");
                hashMap.put(str, hashMap3);
                String str2 = localMediaInfo.path;
                Intrinsics.checkNotNullExpressionValue(str2, "info.path");
                hashMap2.put(str2, localMediaInfo);
            }
        }
        intent.putExtra(QQWinkConstants.CLIP_LOCAL_MEDIA_INFO_EXT_DATA, hashMap);
        intent.putExtra(QQWinkConstants.CLIP_ADDED_LOCAL_MEDIA_INFO, hashMap2);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.setResult(-1, intent);
        }
        FragmentActivity activity2 = getActivity();
        if (activity2 != null) {
            activity2.finish();
        }
    }

    private final p Ji() {
        return (p) this.mediaPickerUIStateViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMediaPickerNextStepHelper Ki() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    private final v Li() {
        return (v) this.qZoneMediaViewModel.getValue();
    }

    private final void Mi() {
        final WinkRecyclerViewSkeletonView winkRecyclerViewSkeletonView = (WinkRecyclerViewSkeletonView) requireView().findViewById(R.id.f85774pv);
        ((AppBarLayout) requireView().findViewById(R.id.sqc)).e(new AppBarLayout.g() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.c
            @Override // com.google.android.material.appbar.AppBarLayout.c
            public final void onOffsetChanged(AppBarLayout appBarLayout, int i3) {
                QZoneAlbumMediaPickerFragment.Ni(WinkRecyclerViewSkeletonView.this, this, appBarLayout, i3);
            }
        });
        Li().P1().observe(getViewLifecycleOwner(), new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.d
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumMediaPickerFragment.Oi(WinkRecyclerViewSkeletonView.this, (UIStateData) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ni(WinkRecyclerViewSkeletonView winkRecyclerViewSkeletonView, QZoneAlbumMediaPickerFragment this$0, AppBarLayout appBarLayout, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ViewGroup.LayoutParams layoutParams = winkRecyclerViewSkeletonView.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) layoutParams;
        int i16 = this$0.skeletonViewMarginTop + i3;
        if (((ViewGroup.MarginLayoutParams) layoutParams2).topMargin != i16) {
            ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin = i16;
            winkRecyclerViewSkeletonView.requestLayout();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Oi(WinkRecyclerViewSkeletonView winkRecyclerViewSkeletonView, UIStateData uIStateData) {
        if (uIStateData.getState() == 0) {
            winkRecyclerViewSkeletonView.setVisibility(0);
        } else {
            winkRecyclerViewSkeletonView.setVisibility(4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Pi(QZoneAlbumMediaPickerFragment this$0, QZoneAlbumInfo qZoneAlbumInfo) {
        String str;
        Object obj;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.Nh().getAlreadySelectedMedia().isEmpty()) {
            this$0.Li().fetchFirstPageMedia();
            return;
        }
        v Li = this$0.Li();
        Iterator<T> it = this$0.Nh().getAlreadySelectedMedia().iterator();
        while (true) {
            str = null;
            if (it.hasNext()) {
                obj = it.next();
                if (!TextUtils.isEmpty(((MediaInfo) obj).getAlbumId())) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        MediaInfo mediaInfo = (MediaInfo) obj;
        if (mediaInfo != null) {
            str = mediaInfo.getAlbumId();
        }
        Li.switchAlbum(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Qi(QZoneAlbumMediaPickerFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        Map<String, Object> l3 = com.tencent.mobileqq.wink.picker.report.a.l("em_xsj_return_button", true, this$0.Wh().getSelectedMedia());
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.picker.report.a.p(it, l3);
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    /* renamed from: Ii, reason: merged with bridge method [inline-methods] */
    public QZoneInitBean Oh() {
        return new QZoneInitBean(false, 0, 0, false, 0, 0, 0, false, null, false, false, false, false, 8183, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public WinkMediaPickerScene Sh() {
        return WinkMediaPickerScene.QZoneAlbum;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    @NotNull
    public com.tencent.mobileqq.wink.picker.core.d Zh() {
        return new QZoneAlbumMediaPickerFactory(Ph());
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new WinkMediaPickerNextStepDialogPart(new b(), false, 2, null));
        arrayList.add(Uh());
        arrayList.add(new aj());
        arrayList.add(new WinkMediaListPart(MediaType.QZONE_ALL, Li()));
        arrayList.addAll(com.tencent.mobileqq.wink.picker.core.c.f324480a.e().g());
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void di(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
        if (Ph().isSingleSelectMode()) {
            if (selectedMedia == null) {
                selectedMedia = CollectionsKt__CollectionsKt.emptyList();
            }
        } else {
            selectedMedia = Wh().getSelectedMedia();
        }
        List<? extends LocalMediaInfo> list = selectedMedia;
        Map<String, Object> l3 = com.tencent.mobileqq.wink.picker.report.a.l(WinkDaTongReportConstant.ElementId.EM_XSJ_NEXT_BUTTON, true, list);
        if (l3 != null) {
            l3.put("xsj_custom_pgid", "pg_xsj_choose_media_new_page");
        }
        com.tencent.mobileqq.wink.picker.report.a.e(null, "ev_xsj_camera_action", l3);
        w53.b.f("QZoneMediaListFragment", "performClickNextStep invoke, selectedMedia.size=" + list.size() + ", useVideoTemplate=true");
        WinkMediaPickerNextStepHelper Ki = Ki();
        Activity hostActivity = getHostActivity();
        Intrinsics.checkNotNullExpressionValue(hostActivity, "hostActivity");
        WinkMediaPickerNextStepHelper.i(Ki, hostActivity, Nh().getLocalMediaTabType(), list, Ph().getShowVideoTemplateButton(), null, null, new Function1<MediaPickerOutput, Unit>() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.QZoneAlbumMediaPickerFragment$onNextBtnClick$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(MediaPickerOutput mediaPickerOutput) {
                invoke2(mediaPickerOutput);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull MediaPickerOutput it) {
                Intent intent;
                Intrinsics.checkNotNullParameter(it, "it");
                Activity hostActivity2 = QZoneAlbumMediaPickerFragment.this.getHostActivity();
                boolean z16 = false;
                if (hostActivity2 != null && (intent = hostActivity2.getIntent()) != null && intent.getBooleanExtra(QQWinkConstants.KEY_IS_FROM_CLIP, false)) {
                    z16 = true;
                }
                if (z16 || !QZoneAlbumMediaPickerFragment.this.Ph().getEnableEdit()) {
                    QZoneAlbumMediaPickerFragment.this.Hi(it.f());
                    return;
                }
                Activity hostActivity3 = QZoneAlbumMediaPickerFragment.this.getHostActivity();
                Intrinsics.checkNotNullExpressionValue(hostActivity3, "hostActivity");
                Intent intent2 = QZoneAlbumMediaPickerFragment.this.getHostActivity().getIntent();
                Intrinsics.checkNotNullExpressionValue(intent2, "hostActivity.intent");
                g.d(hostActivity3, intent2, it);
            }
        }, 48, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.hkj;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaListFragment";
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 10 && resultCode == -1) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.setResult(-1, data);
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        if (Jh()) {
            return true;
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        String str;
        Intent intent;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            str = intent.getStringExtra(QCircleScheme.AttrQQPublish.QZONE_ALBUM_IMAGE_PICKER_TITLE);
        } else {
            str = null;
        }
        this.pickerTitle = str;
        Li().R1().observe(this, new Observer() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QZoneAlbumMediaPickerFragment.Pi(QZoneAlbumMediaPickerFragment.this, (QZoneAlbumInfo) obj);
            }
        });
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Ki().p();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBarTextColor();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = 1;
        this.skeletonViewMarginTop = requireContext().getResources().getDimensionPixelSize(R.dimen.cxx);
        TextView textView = (TextView) view.findViewById(R.id.f166986jo4);
        if (!TextUtils.isEmpty(this.pickerTitle)) {
            textView.setText(this.pickerTitle);
        } else {
            textView.setText(R.string.f216325y0);
        }
        view.findViewById(R.id.t2c).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.album.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZoneAlbumMediaPickerFragment.Qi(QZoneAlbumMediaPickerFragment.this, view2);
            }
        });
        Ji().W1(false);
        Mi();
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity(), "pg_xsj_choose_media_new_page", true, null, 0, false, true, null, com.tencent.luggage.wxa.rf.g.CTRL_INDEX, null);
    }

    @Override // com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment
    public void hi(boolean isFromQZoneMedia, @Nullable List<? extends LocalMediaInfo> selectedMedia) {
    }
}
