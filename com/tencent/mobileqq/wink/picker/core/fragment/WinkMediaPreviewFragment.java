package com.tencent.mobileqq.wink.picker.core.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.compat.RFWThemeUtil;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.ocr.data.OcrConfig;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewActionPart;
import com.tencent.mobileqq.wink.picker.core.part.WinkMediaPreviewContentPart;
import com.tencent.mobileqq.wink.picker.core.viewmodel.p;
import com.tencent.mobileqq.wink.picker.core.viewmodel.q;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 %2\u00020\u0001:\u00013B\u0007\u00a2\u0006\u0004\b1\u00102J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0014J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J(\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0002H\u0016R6\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u001b\u0018\u0001`\u001c8\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\"\u0010*\u001a\u00020\u00078\u0004@\u0004X\u0084\u000e\u00a2\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u001b\u00100\u001a\u00020+8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/\u00a8\u00064"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPreviewFragment;", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPickerChildFragment;", "", OcrConfig.CHINESE, "Landroid/content/Context;", "context", "onAttach", "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getLogTag", "Landroid/view/View;", "view", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "", "params", "uh", "", "onBackEvent", "onResume", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "Lkotlin/collections/ArrayList;", "E", "Ljava/util/ArrayList;", "wh", "()Ljava/util/ArrayList;", "setPreviewMedia", "(Ljava/util/ArrayList;)V", "previewMedia", UserInfo.SEX_FEMALE, "I", "xh", "()I", "setStartPosition", "(I)V", "startPosition", "Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "G", "Lkotlin/Lazy;", "vh", "()Lcom/tencent/mobileqq/wink/picker/core/viewmodel/p;", "mediaPickerUIStateViewModel", "<init>", "()V", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public class WinkMediaPreviewFragment extends WinkMediaPickerChildFragment {

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ArrayList<LocalMediaInfo> previewMedia;

    /* renamed from: F, reason: from kotlin metadata */
    private int startPosition;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final Lazy mediaPickerUIStateViewModel;

    @NotNull
    public Map<Integer, View> H = new LinkedHashMap();

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u001c\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005J\u001c\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u00058\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPreviewFragment$a;", "", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "previewMedia", "", "previewStartPos", "Lcom/tencent/mobileqq/wink/picker/core/fragment/WinkMediaPreviewFragment;", "a", "Landroid/os/Bundle;", "b", "", "ARG_PREVIEW_MEDIA", "Ljava/lang/String;", "ARG_PREVIEW_START_POS", "PREVIEW_MEDIA_RANGE", "I", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment$a, reason: from kotlin metadata */
    /* loaded from: classes21.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final WinkMediaPreviewFragment a(@NotNull List<? extends LocalMediaInfo> previewMedia, int previewStartPos) {
            Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
            Bundle b16 = b(previewMedia, previewStartPos);
            WinkMediaPreviewFragment winkMediaPreviewFragment = new WinkMediaPreviewFragment();
            winkMediaPreviewFragment.setArguments(b16);
            return winkMediaPreviewFragment;
        }

        @NotNull
        public final Bundle b(@NotNull List<? extends LocalMediaInfo> previewMedia, int previewStartPos) {
            Intrinsics.checkNotNullParameter(previewMedia, "previewMedia");
            try {
                Bundle bundle = new Bundle();
                int i3 = previewStartPos - 100;
                if (i3 <= 0) {
                    i3 = 0;
                }
                int size = previewMedia.size();
                int i16 = previewStartPos + 100;
                if (i16 < previewMedia.size()) {
                    size = i16;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(previewMedia.subList(i3, size));
                bundle.putSerializable("mediaType", arrayList);
                bundle.putSerializable("previewStartPos", Integer.valueOf(previewStartPos - i3));
                return bundle;
            } catch (Exception e16) {
                w53.b.c("WinkMediaPreviewFragment", "error: " + e16);
                return new Bundle();
            }
        }

        Companion() {
        }
    }

    public WinkMediaPreviewFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<p>() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPreviewFragment$mediaPickerUIStateViewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final p invoke() {
                FragmentActivity requireActivity = WinkMediaPreviewFragment.this.requireActivity();
                Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
                return q.a(requireActivity);
            }
        });
        this.mediaPickerUIStateViewModel = lazy;
    }

    private final p vh() {
        return (p) this.mediaPickerUIStateViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void yh(WinkMediaPreviewFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.onBackEvent();
        EventCollector.getInstance().onViewClicked(view);
    }

    private final void zh() {
        LocalMediaInfo localMediaInfo;
        ArrayList<LocalMediaInfo> arrayList = this.previewMedia;
        if (arrayList != null) {
            localMediaInfo = arrayList.get(this.startPosition);
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo != null) {
            Map<String, Object> customParams = WinkDTParamBuilder.buildElementParams();
            Intrinsics.checkNotNullExpressionValue(customParams, "customParams");
            uh(customParams);
            com.tencent.mobileqq.wink.picker.report.a.o(getView(), requireActivity(), WinkDaTongReportConstant.PageId.PG_XSJ_CAMERA_VIDEO_MATERIAL_PREVIEW_PAGE, false, null, 0, false, false, customParams, 96, null);
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment
    public void _$_clearFindViewByIdCache() {
        this.H.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        List<Part> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(new WinkMediaPreviewContentPart(this.previewMedia, this.startPosition, false, 4, null), new WinkMediaPreviewActionPart());
        return mutableListOf;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i6e;
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMediaPreviewFragment";
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        ArrayList<LocalMediaInfo> arrayList;
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            Serializable serializable = arguments.getSerializable("mediaType");
            if (serializable instanceof ArrayList) {
                arrayList = (ArrayList) serializable;
            } else {
                arrayList = null;
            }
            if (arrayList != null) {
                this.previewMedia = arrayList;
            }
            this.startPosition = arguments.getInt("previewStartPos", 0);
        }
        vh().W1(false);
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

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        setStatusBarTextColor();
    }

    @Override // com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerChildFragment, com.tencent.mobileqq.wink.picker.core.fragment.WinkMediaPickerBaseFragment, com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(getResources().getColor(R.color.bdg));
        }
        View findViewById = view.findViewById(R.id.t2c);
        if (findViewById != null) {
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.picker.core.fragment.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    WinkMediaPreviewFragment.yh(WinkMediaPreviewFragment.this, view2);
                }
            });
        }
        if (needAdjustImmersive()) {
            RFWThemeUtil.setNavigationBarColor(getActivity(), ContextCompat.getColor(requireActivity(), R.color.bd6));
        }
        zh();
    }

    @NotNull
    public Map<String, Object> uh(@NotNull Map<String, Object> params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return params;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Nullable
    public final ArrayList<LocalMediaInfo> wh() {
        return this.previewMedia;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: xh, reason: from getter */
    public final int getStartPosition() {
        return this.startPosition;
    }
}
