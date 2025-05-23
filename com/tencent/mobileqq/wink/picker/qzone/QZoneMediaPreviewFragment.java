package com.tencent.mobileqq.wink.picker.qzone;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.wink.picker.MediaType;
import com.tencent.mobileqq.wink.picker.core.WinkMediaPickerMainBaseFragment;
import com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewThumbListPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.WinkSelectedMediaViewModel;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewBottomPart;
import com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewContentPart;
import com.tencent.mobileqq.wink.picker.qzone.part.QZoneMediaPreviewTopPart;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 32\u00020\u0001:\u00014B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u001a\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0006H\u0016R*\u0010\u001a\u001a\u0016\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015j\n\u0012\u0004\u0012\u00020\u0016\u0018\u0001`\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010%\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010#R\u001b\u0010+\u001a\u00020&8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u001d\u00100\u001a\u0004\u0018\u00010,8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b-\u0010(\u001a\u0004\b.\u0010/\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaPreviewFragment;", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "", "getContentLayoutId", "Landroid/content/Context;", "context", "", "onAttach", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "onBackEvent", "onResume", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "previewMedia", UserInfo.SEX_FEMALE, "I", "startPosition", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "G", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "H", "Z", "showAllMedia", "enableEdit", "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "J", "Lkotlin/Lazy;", "wh", "()Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "K", "xh", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/WinkSelectedMediaViewModel;", "selectedMediaViewModel", "<init>", "()V", "L", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class QZoneMediaPreviewFragment extends WinkMediaPickerChildFragment {

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> previewMedia;

    /* renamed from: F, reason: from kotlin metadata */
    private int startPosition;

    /* renamed from: G, reason: from kotlin metadata */
    private MediaType mediaType;

    /* renamed from: H, reason: from kotlin metadata */
    private boolean showAllMedia;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean enableEdit = true;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final Lazy nextStepHelper;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy selectedMediaViewModel;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ6\u0010\r\u001a\u00020\f2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0002J8\u0010\u000f\u001a\u00020\u000e2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\tR\u0014\u0010\u0011\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0014\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0012R\u0014\u0010\u0016\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0012R\u0014\u0010\u0017\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00108\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0012\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaPreviewFragment$a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "previewMedia", "", "previewStartPos", "Lcom/tencent/mobileqq/wink/picker/MediaType;", "mediaType", "", "showAllMedia", "enableEdit", "Landroid/os/Bundle;", "b", "Lcom/tencent/mobileqq/wink/picker/qzone/QZoneMediaPreviewFragment;", "a", "", "ARG_PREVIEW_ENABLE_EDIT", "Ljava/lang/String;", "ARG_PREVIEW_MEDIA", "ARG_PREVIEW_MEDIA_TYPE", "ARG_PREVIEW_SHOW_ALL_MEDIAS", "ARG_PREVIEW_START_POS", "PREVIEW_MEDIA_RANGE", "I", "TAG", "<init>", "()V", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final Bundle b(List<? extends LocalMediaInfo> previewMedia, int previewStartPos, MediaType mediaType, boolean showAllMedia, boolean enableEdit) {
            try {
                Bundle bundle = new Bundle();
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(previewMedia);
                bundle.putSerializable("mediaType", arrayList);
                bundle.putSerializable("previewStartPos", Integer.valueOf(previewStartPos));
                bundle.putSerializable("previewMediaType", mediaType);
                bundle.putSerializable("showAllMedias", Boolean.valueOf(showAllMedia));
                bundle.putBoolean("previewEnableEdit", enableEdit);
                return bundle;
            } catch (Exception e16) {
                w53.b.c("QZoneMediaPreviewFragment", "error: " + e16);
                return new Bundle();
            }
        }

        @NotNull
        public final QZoneMediaPreviewFragment a(@NotNull List<? extends LocalMediaInfo> previewMedia, int previewStartPos, @NotNull MediaType mediaType, boolean showAllMedia, boolean enableEdit) {
            Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            Bundle b16 = b(previewMedia, previewStartPos, mediaType, showAllMedia, enableEdit);
            QZoneMediaPreviewFragment qZoneMediaPreviewFragment = new QZoneMediaPreviewFragment();
            qZoneMediaPreviewFragment.setArguments(b16);
            return qZoneMediaPreviewFragment;
        }

        Companion() {
        }
    }

    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/picker/qzone/QZoneMediaPreviewFragment$b", "Lcom/tencent/mobileqq/wink/picker/core/part/WinkMediaPickerNextStepDialogPart$a;", "", "onCancelClick", "", "b", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements WinkMediaPickerNextStepDialogPart.a {
        b() {
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        @NotNull
        public List<LocalMediaInfo> a() {
            List<LocalMediaInfo> emptyList;
            List<LocalMediaInfo> selectedMedia;
            WinkSelectedMediaViewModel xh5 = QZoneMediaPreviewFragment.this.xh();
            if (xh5 == null || (selectedMedia = xh5.getSelectedMedia()) == null) {
                emptyList = CollectionsKt__CollectionsKt.emptyList();
                return emptyList;
            }
            return selectedMedia;
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public boolean b() {
            return QZoneMediaPreviewFragment.this.wh().isRunning.get();
        }

        @Override // com.tencent.mobileqq.wink.picker.core.part.WinkMediaPickerNextStepDialogPart.a
        public void onCancelClick() {
            QZoneMediaPreviewFragment.this.wh().f();
        }
    }

    public QZoneMediaPreviewFragment() {
        Lazy lazy;
        Lazy lazy2;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<WinkMediaPickerNextStepHelper>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPreviewFragment$nextStepHelper$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final WinkMediaPickerNextStepHelper invoke() {
                return new WinkMediaPickerNextStepHelper(com.tencent.mobileqq.wink.picker.core.viewmodel.q.e(QZoneMediaPreviewFragment.this));
            }
        });
        this.nextStepHelper = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(new Function0<WinkSelectedMediaViewModel>() { // from class: com.tencent.mobileqq.wink.picker.qzone.QZoneMediaPreviewFragment$selectedMediaViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @Nullable
            public final WinkSelectedMediaViewModel invoke() {
                Fragment parentFragment = QZoneMediaPreviewFragment.this.getParentFragment();
                WinkMediaPickerMainBaseFragment winkMediaPickerMainBaseFragment = parentFragment instanceof WinkMediaPickerMainBaseFragment ? (WinkMediaPickerMainBaseFragment) parentFragment : null;
                if (winkMediaPickerMainBaseFragment != null) {
                    return com.tencent.mobileqq.wink.picker.core.viewmodel.q.j(winkMediaPickerMainBaseFragment);
                }
                return null;
            }
        });
        this.selectedMediaViewModel = lazy2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkMediaPickerNextStepHelper wh() {
        return (WinkMediaPickerNextStepHelper) this.nextStepHelper.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final WinkSelectedMediaViewModel xh() {
        return (WinkSelectedMediaViewModel) this.selectedMediaViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(QZoneMediaPreviewFragment this$0, View it) {
        EventCollector.getInstance().onViewClickedBefore(it);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(it, "it");
        com.tencent.mobileqq.wink.picker.report.a.d(it, WinkDaTongReportConstant.ElementId.EM_XSJ_QZ_BACK);
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(it);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        Part[] partArr = new Part[4];
        partArr[0] = new QZoneMediaPreviewTopPart();
        ArrayList<LocalMediaInfo> arrayList = this.previewMedia;
        int i3 = this.startPosition;
        MediaType mediaType = this.mediaType;
        if (mediaType == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaType");
            mediaType = null;
        }
        partArr[1] = new QZoneMediaPreviewContentPart(arrayList, i3, mediaType, this.showAllMedia);
        int i16 = this.startPosition;
        MediaType mediaType2 = this.mediaType;
        if (mediaType2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mediaType");
            mediaType2 = null;
        }
        partArr[2] = new WinkMediaPreviewThumbListPart(i16, mediaType2, this.showAllMedia);
        partArr[3] = new QZoneMediaPreviewBottomPart(wh(), this.enableEdit);
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(partArr);
        mutableListOf.add(new WinkMediaPickerNextStepDialogPart(new b(), false, 2, null));
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i7h;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QZoneMediaPreviewFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        ArrayList<LocalMediaInfo> arrayList;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("mediaType");
            MediaType mediaType = null;
            if (serializable instanceof ArrayList) {
                arrayList = (ArrayList) serializable;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                this.previewMedia = arrayList;
            }
            this.startPosition = arguments.getInt("previewStartPos", 0);
            Serializable serializable2 = arguments.getSerializable("previewMediaType");
            if (serializable2 instanceof MediaType) {
                mediaType = (MediaType) serializable2;
            }
            if (mediaType == null) {
                mediaType = MediaType.LOCAL_ALL;
            }
            this.mediaType = mediaType;
            this.showAllMedia = arguments.getBoolean("showAllMedias", false);
            this.enableEdit = arguments.getBoolean("previewEnableEdit", true);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.biz.richframework.part.BasePartFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, com.tencent.biz.richframework.compat.IFragmentCallbacks
    public boolean onBackEvent() {
        ViewGroup viewGroup;
        ViewParent parent = getFragmentContentView().getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(getResources().getColor(R.color.ajr));
        }
        return super.onBackEvent();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBarTextColor();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup;
        List<LocalMediaInfo> selectedMedia;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewParent parent = view.getParent();
        Integer num = null;
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(getResources().getColor(R.color.bdg));
        }
        view.findViewById(R.id.t2c).setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.qzone.k
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                QZoneMediaPreviewFragment.yh(QZoneMediaPreviewFragment.this, view2);
            }
        });
        if (needAdjustImmersive()) {
            RFWThemeUtil.setNavigationBarColor(getActivity(), ContextCompat.getColor(requireActivity(), R.color.bd6));
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        WinkSelectedMediaViewModel xh5 = xh();
        if (xh5 != null && (selectedMedia = xh5.getSelectedMedia()) != null) {
            num = Integer.valueOf(selectedMedia.size());
        }
        linkedHashMap.put(WinkDaTongReportConstant.ElementParamKey.PIC_NUM, num);
        com.tencent.mobileqq.wink.picker.report.a.o(view, requireActivity(), WinkDaTongReportConstant.PageId.PG_BAS_PREVIEW, false, null, 0, false, false, linkedHashMap, 224, null);
    }
}
