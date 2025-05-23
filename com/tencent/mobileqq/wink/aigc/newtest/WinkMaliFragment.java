package com.tencent.mobileqq.wink.aigc.newtest;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.aelight.camera.entry.api.IAECameraLauncher;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.aigc.newtest.WinkMaliFragment;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.picker.Config;
import com.tencent.mobileqq.wink.picker.TabType;
import com.tencent.mobileqq.wink.picker.core.UniversalMediaPickerFragment;
import com.tencent.mobileqq.wink.utils.j;
import com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.peak.PeakConstants;
import cooperation.qzone.QzoneIPCModule;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 02\u00020\u00012\u00020\u00022\u00020\u0003:\u000212B\u0007\u00a2\u0006\u0004\b.\u0010/J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0002J&\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0016J\"\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0016J\b\u0010\u001f\u001a\u00020\u0016H\u0014J\b\u0010 \u001a\u00020\u0016H\u0014J\b\u0010\"\u001a\u00020!H\u0016R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u00063"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/WinkMaliFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "Lcom/tencent/mobileqq/winkreport/crashreport/IWinkCrashReportCallback;", "Lcom/tencent/mobileqq/wink/aigc/newtest/d;", "Landroid/view/View;", "view", "", "initView", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "mediaInfo", "sh", "th", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreateView", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "model", "e3", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "onActivityResult", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getContentLayoutId", "getStatusBarColor", "", "getLogTag", "Landroidx/recyclerview/widget/RecyclerView;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/mobileqq/wink/aigc/newtest/c;", "D", "Lcom/tencent/mobileqq/wink/aigc/newtest/c;", "adapter", "E", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "currModelItem", "<init>", "()V", "G", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMaliFragment extends ImmersivePartFragment implements IWinkCrashReportCallback, d {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private com.tencent.mobileqq.wink.aigc.newtest.c adapter;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private ModelItem currModelItem;

    @NotNull
    public Map<Integer, View> F = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ(\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/WinkMaliFragment$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", HippyNestedScrollComponent.PRIORITY_PARENT, "Landroidx/recyclerview/widget/RecyclerView$State;", "state", "", "getItemOffsets", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends RecyclerView.ItemDecoration {
        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@NotNull Rect outRect, @NotNull View view, @NotNull RecyclerView parent, @NotNull RecyclerView.State state) {
            Intrinsics.checkNotNullParameter(outRect, "outRect");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Intrinsics.checkNotNullParameter(state, "state");
            if (parent.getChildLayoutPosition(view) % 2 == 0) {
                outRect.left = 0;
                outRect.right = ImmersiveUtils.dpToPx(2.5f);
            } else {
                outRect.left = ImmersiveUtils.dpToPx(2.5f);
                outRect.right = 0;
            }
            outRect.bottom = ImmersiveUtils.dpToPx(10.0f);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/wink/aigc/newtest/WinkMaliFragment$c", "Lcom/tencent/mobileqq/wink/utils/j$a;", "", "hasFace", "isLegal", "", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements j.a {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ LocalMediaInfo f317907b;

        c(LocalMediaInfo localMediaInfo) {
            this.f317907b = localMediaInfo;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(boolean z16, boolean z17, WinkMaliFragment this$0, LocalMediaInfo mediaInfo) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(mediaInfo, "$mediaInfo");
            if (z16 && z17) {
                this$0.th(mediaInfo);
            } else if (!z16) {
                QQToast.makeText(this$0.getContext(), R.string.f241357rn, 0).show();
            } else {
                QQToast.makeText(this$0.getContext(), R.string.f240447p7, 0).show();
            }
        }

        @Override // com.tencent.mobileqq.wink.utils.j.a
        public void a(final boolean hasFace, final boolean isLegal) {
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final WinkMaliFragment winkMaliFragment = WinkMaliFragment.this;
            final LocalMediaInfo localMediaInfo = this.f317907b;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.mobileqq.wink.aigc.newtest.h
                @Override // java.lang.Runnable
                public final void run() {
                    WinkMaliFragment.c.c(hasFace, isLegal, winkMaliFragment, localMediaInfo);
                }
            });
        }
    }

    private final void initView(View view) {
        RecyclerView recyclerView;
        FragmentManager supportFragmentManager;
        if (view != null) {
            recyclerView = (RecyclerView) view.findViewById(R.id.f123437gn);
        } else {
            recyclerView = null;
        }
        this.recyclerView = recyclerView;
        com.tencent.mobileqq.wink.aigc.newtest.c cVar = new com.tencent.mobileqq.wink.aigc.newtest.c();
        this.adapter = cVar;
        RecyclerView recyclerView2 = this.recyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setAdapter(cVar);
            recyclerView2.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView2.addItemDecoration(new b());
        }
        com.tencent.mobileqq.wink.aigc.newtest.c cVar2 = this.adapter;
        if (cVar2 != null) {
            cVar2.m0(this);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
            supportFragmentManager.setFragmentResultListener("7184", this, new FragmentResultListener() { // from class: com.tencent.mobileqq.wink.aigc.newtest.g
                @Override // androidx.fragment.app.FragmentResultListener
                public final void onFragmentResult(String str, Bundle bundle) {
                    WinkMaliFragment.uh(WinkMaliFragment.this, str, bundle);
                }
            });
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault())), null, null, new WinkMaliFragment$initView$3(this, null), 3, null);
    }

    private final void sh(LocalMediaInfo mediaInfo) {
        String str = mediaInfo.path;
        Intrinsics.checkNotNullExpressionValue(str, "mediaInfo.path");
        j.i(str, true, new c(mediaInfo));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x002e, code lost:
    
        if (r0 != false) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void th(LocalMediaInfo mediaInfo) {
        String str;
        boolean z16;
        boolean isBlank;
        boolean isBlank2;
        ModelItem modelItem = this.currModelItem;
        if (modelItem != null) {
            str = modelItem.getModelName();
        } else {
            str = null;
        }
        boolean z17 = false;
        if (str != null) {
            isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank2) {
                z16 = false;
                if (!z16) {
                    com.tencent.xaction.log.b.a("WinkMaliFragment", 1, "[handlePicturePicked] invalid modelName");
                    return;
                }
                if (mediaInfo != null) {
                    String str2 = mediaInfo.path;
                    if (str2 != null) {
                        isBlank = StringsKt__StringsJVMKt.isBlank(str2);
                    }
                    z17 = true;
                    if (!z17) {
                        com.tencent.xaction.log.b.a("WinkMaliFragment", 1, "[handlePicturePicked] path=" + mediaInfo.path);
                        Intent intent = new Intent();
                        intent.setClass(requireActivity(), QQWinkActivity.class);
                        intent.putExtra("public_fragment_class", WinkMaliDrawFragment.class.getName());
                        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
                        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
                        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
                        intent.putExtra("use_model_item", this.currModelItem);
                        intent.putExtra("image_media_info", (Parcelable) mediaInfo);
                        startActivity(intent);
                        return;
                    }
                }
                com.tencent.xaction.log.b.a("WinkMaliFragment", 1, "[handlePicturePicked] invalid mediaInfo");
                return;
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void uh(WinkMaliFragment this$0, String requestKey, Bundle result) {
        LocalMediaInfo localMediaInfo;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(result, "result");
        com.tencent.xaction.log.b.a("WinkMaliFragment", 1, "[FragmentResultListener] requestKey=" + requestKey);
        Object obj = result.get(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH);
        if (obj instanceof LocalMediaInfo) {
            localMediaInfo = (LocalMediaInfo) obj;
        } else {
            localMediaInfo = null;
        }
        if (localMediaInfo != null) {
            com.tencent.xaction.log.b.a("WinkMaliFragment", 1, "[FragmentResultListener] path=" + localMediaInfo.path);
            this$0.sh(localMediaInfo);
        }
    }

    public void _$_clearFindViewByIdCache() {
        this.F.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    @Override // com.tencent.mobileqq.wink.aigc.newtest.d
    public void e3(@NotNull ModelItem model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.currModelItem = model;
        Config.Companion companion = Config.INSTANCE;
        Config.a aVar = new Config.a();
        aVar.i(TabType.ONLY_IMAGE);
        aVar.f(true);
        aVar.o(com.tencent.mobileqq.wink.picker.qcircle.c.f324971a.c());
        aVar.e(7184);
        Config a16 = aVar.a();
        Intent intent = new Intent();
        intent.setClass(requireActivity(), QQWinkActivity.class);
        intent.putExtra("public_fragment_class", MaliSingleMediaPickerFragment.class.getName());
        intent.putExtras(UniversalMediaPickerFragment.Companion.b(UniversalMediaPickerFragment.INSTANCE, a16, null, 2, null));
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, R.style.atm);
        intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
        startActivityForResult(intent, 7184);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169191i62;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "WinkMaliFragment";
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        String str;
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null || (str = data.getStringExtra(AECameraConstants.FRAGMENT_RETURN_ACTION)) == null) {
            str = "";
        }
        com.tencent.xaction.log.b.a("WinkMaliFragment", 1, "[onActivityResult] requestCode=" + requestCode + ", resultCode=" + resultCode + ", action=" + str);
        FragmentActivity fragmentActivity = null;
        LocalMediaInfo localMediaInfo = null;
        if (Intrinsics.areEqual(str, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_IMAGE_PICKER)) {
            if (data != null) {
                localMediaInfo = (LocalMediaInfo) data.getParcelableExtra(AECameraConstants.FRAGMENT_CAMERA_RESULT_PATH);
            }
            th(localMediaInfo);
            return;
        }
        if (Intrinsics.areEqual(str, AECameraConstants.FRAGMENT_ACTION_JUMP_TO_CAMERA)) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(QQWinkConstants.WINK_CAPTURE_FRAGMENT_IGNORE_BOTTOM_HEIGHT, true);
            bundle.putInt("ability_flag", 2);
            bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            bundle.putString("app_key", "00000QG6YX3X0LZH");
            bundle.putBoolean("camera_direct_return_result", true);
            bundle.putString("camera_fragment_tag", "Mali");
            bundle.putInt("fragment_request_business_code", 7184);
            Context context = getContext();
            if (context instanceof FragmentActivity) {
                fragmentActivity = (FragmentActivity) context;
            }
            if (fragmentActivity != null) {
                ((IAECameraLauncher) QRoute.api(IAECameraLauncher.class)).winkLaunchAECameraFragmentForAIGCHB(fragmentActivity, bundle);
            }
        }
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onAttachReport() {
        za3.a.b(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateReport() {
        za3.a.c(this);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        initView(onCreateView);
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCreateViewReport() {
        za3.a.d(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onCustomReport(int i3) {
        za3.a.e(this, i3);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyReport() {
        za3.a.f(this);
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onDestroyViewReport() {
        za3.a.g(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onHiddenChangedReport(boolean z16) {
        za3.a.h(this, z16);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onPauseReport() {
        za3.a.i(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onResumeReport() {
        za3.a.j(this);
    }

    @Override // com.tencent.mobileqq.winkreport.crashreport.IWinkCrashReportCallback
    public /* synthetic */ void onViewCreatedReport() {
        za3.a.k(this);
    }
}
