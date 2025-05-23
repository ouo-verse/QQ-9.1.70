package com.tencent.mobileqq.wink.aigc.newtest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.ParseCommon;
import com.tencent.biz.richframework.activity.CompatPublicActivity;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.libra.LoadState;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.wink.QQWinkActivity;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.winkpublish.publishconst.WinkHostConstants;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import cooperation.peak.PeakConstants;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 M2\u00020\u0001:\u0001NB\u0007\u00a2\u0006\u0004\bK\u0010LJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\u001b\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0082@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0012\u0010\u0011\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0014J\b\u0010\u001e\u001a\u00020\u001cH\u0014R\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109R\u001b\u0010@\u001a\u00020;8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?R\u0014\u0010D\u001a\u00020A8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR\u0018\u0010J\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bI\u0010G\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006O"}, d2 = {"Lcom/tencent/mobileqq/wink/aigc/newtest/WinkMaliDrawFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "Fh", "Gh", "Dh", "Ch", "", "msg", "Kh", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "url", "", "isResult", "Jh", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", ParseCommon.CONTAINER, "Landroid/view/View;", "onCreateView", MosaicConstants$JsFunction.FUNC_ON_DESTROY, "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "getContentLayoutId", "getStatusBarColor", "Landroid/widget/ImageView;", BdhLogUtil.LogTag.Tag_Conn, "Landroid/widget/ImageView;", "imageView", "Landroid/widget/ProgressBar;", "D", "Landroid/widget/ProgressBar;", "progressBar", "Landroid/widget/TextView;", "E", "Landroid/widget/TextView;", "statusTextView", UserInfo.SEX_FEMALE, "Landroid/view/View;", "btnToPublish", "G", "btnToEdit", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "H", "Lcom/tencent/mobileqq/wink/aigc/newtest/ModelItem;", "modelItem", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "I", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "localMediaInfo", "J", "Ljava/lang/String;", "resultLocalPath", "Lcom/tencent/mobileqq/wink/aigc/newtest/a;", "K", "Lkotlin/Lazy;", "Eh", "()Lcom/tencent/mobileqq/wink/aigc/newtest/a;", "viewModel", "Lkotlinx/coroutines/CoroutineScope;", "L", "Lkotlinx/coroutines/CoroutineScope;", "scope", "Lkotlinx/coroutines/Job;", "M", "Lkotlinx/coroutines/Job;", "drawJob", "N", "progressJob", "<init>", "()V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMaliDrawFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private ImageView imageView;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private ProgressBar progressBar;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TextView statusTextView;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private View btnToPublish;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private View btnToEdit;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private ModelItem modelItem;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private LocalMediaInfo localMediaInfo;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final CoroutineScope scope;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Job drawJob;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private Job progressJob;

    @NotNull
    public Map<Integer, View> P = new LinkedHashMap();

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private String resultLocalPath = "";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\b"}, d2 = {"com/tencent/mobileqq/wink/aigc/newtest/WinkMaliDrawFragment$b", "Lcom/tencent/mobileqq/qcircle/picload/listener/QCirclePicStateListener;", "Lcom/tencent/libra/LoadState;", "state", "Lcom/tencent/libra/request/Option;", "option", "", "onStateChange", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b extends QCirclePicStateListener {
        b() {
        }

        @Override // com.tencent.mobileqq.qcircle.picload.listener.QCirclePicStateListener, com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(@NotNull LoadState state, @NotNull Option option) {
            TextView textView;
            Intrinsics.checkNotNullParameter(state, "state");
            Intrinsics.checkNotNullParameter(option, "option");
            if (state == LoadState.STATE_SUCCESS) {
                TextView textView2 = WinkMaliDrawFragment.this.statusTextView;
                if (textView2 != null) {
                    textView2.setText("\u56fe\u7247\u52a0\u8f7d\u5b8c\u6210");
                }
                View view = WinkMaliDrawFragment.this.btnToPublish;
                if (view != null) {
                    view.setVisibility(0);
                }
                View view2 = WinkMaliDrawFragment.this.btnToEdit;
                if (view2 != null) {
                    view2.setVisibility(0);
                }
                WinkMaliDrawFragment winkMaliDrawFragment = WinkMaliDrawFragment.this;
                String picLocalPath = QCircleFeedPicLoader.g().getPicLocalPath(option);
                Intrinsics.checkNotNullExpressionValue(picLocalPath, "g().getPicLocalPath(option)");
                winkMaliDrawFragment.resultLocalPath = picLocalPath;
                com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "result local path=" + WinkMaliDrawFragment.this.resultLocalPath);
            } else if ((state == LoadState.STATE_DECODE_FAILED || state == LoadState.STATE_DOWNLOAD_FAILED) && (textView = WinkMaliDrawFragment.this.statusTextView) != null) {
                textView.setText("\u56fe\u7247\u52a0\u8f7d\u51fa\u9519");
            }
            ProgressBar progressBar = WinkMaliDrawFragment.this.progressBar;
            if (progressBar != null) {
                progressBar.setProgress(100);
            }
        }
    }

    public WinkMaliDrawFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<a>() { // from class: com.tencent.mobileqq.wink.aigc.newtest.WinkMaliDrawFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final a invoke() {
                return (a) WinkMaliDrawFragment.this.getViewModel(a.class);
            }
        });
        this.viewModel = lazy;
        this.scope = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null).plus(Dispatchers.getDefault()));
    }

    private final void Ch() {
        Job launch$default;
        String str;
        LocalMediaInfo localMediaInfo = this.localMediaInfo;
        if (localMediaInfo != null && (str = localMediaInfo.path) != null) {
            Jh(str, false);
        }
        Job job = this.drawJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(this.scope, null, null, new WinkMaliDrawFragment$draw$2(this, null), 3, null);
        this.drawJob = launch$default;
    }

    private final void Dh() {
        Job launch$default;
        Job job = this.progressJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        launch$default = BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new WinkMaliDrawFragment$fakeProgress$1(this, null), 3, null);
        this.progressJob = launch$default;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final a Eh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (a) value;
    }

    private final void Fh() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.resultLocalPath);
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = this.resultLocalPath;
        localMediaInfo.mMimeType = "image/jpeg";
        localMediaInfo.mOriginPath = arrayList;
        Intent intent = new Intent();
        intent.setClass(requireContext(), QQWinkActivity.class);
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(localMediaInfo);
        Unit unit = Unit.INSTANCE;
        intent.putExtra(QQWinkConstants.INPUT_MEDIA, arrayList2);
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
        intent.putExtra("public_fragment_class", "com.tencent.mobileqq.wink.editor.WinkEditorFragment");
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, 0);
        startActivity(intent);
    }

    private final void Gh() {
        boolean isBlank;
        isBlank = StringsKt__StringsJVMKt.isBlank(this.resultLocalPath);
        if (isBlank) {
            com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[onNext] invalid result path");
            return;
        }
        View view = this.btnToPublish;
        if (view != null) {
            view.setEnabled(false);
        }
        View view2 = this.btnToEdit;
        if (view2 != null) {
            view2.setEnabled(false);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(this.resultLocalPath);
        LocalMediaInfo localMediaInfo = new LocalMediaInfo();
        localMediaInfo.path = this.resultLocalPath;
        localMediaInfo.mMimeType = "image/jpeg";
        localMediaInfo.mOriginPath = arrayList;
        HashMap hashMap = new HashMap();
        hashMap.put(this.resultLocalPath, localMediaInfo);
        Intent intent = new Intent();
        intent.putStringArrayListExtra(WinkHostConstants.PhotoConst.photoPaths(), arrayList);
        intent.putExtra(WinkHostConstants.QAlbumConstants.selectedMediaInfoHashMap(), hashMap);
        intent.setClass(requireContext(), QQWinkActivity.class);
        intent.putExtra(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
        intent.putExtra("public_fragment_class", "com.tencent.mobileqq.wink.publish.fs.activity.FSUploadActivityFragment");
        intent.putExtra(CompatPublicActivity.KEY_THEME_ID, 0);
        startActivity(intent);
        View view3 = this.btnToPublish;
        if (view3 != null) {
            view3.setEnabled(true);
        }
        View view4 = this.btnToEdit;
        if (view4 != null) {
            view4.setEnabled(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Hh(WinkMaliDrawFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Gh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Ih(WinkMaliDrawFragment this$0, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.Fh();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void Jh(String url, boolean isResult) {
        Option obtain = Option.obtain();
        obtain.setTargetView(this.imageView);
        obtain.setUrl(url);
        obtain.setRequestWidth(ViewUtils.getScreenWidth());
        obtain.setRequestHeight(ViewUtils.getScreenWidth());
        obtain.setLoadingDrawableColor(-16777216);
        obtain.setFailedDrawableColor(-7829368);
        if (isResult) {
            QCircleFeedPicLoader.g().loadImage(obtain, new b());
        } else {
            QCircleFeedPicLoader.g().loadImage(obtain);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object Kh(String str, Continuation<? super Unit> continuation) {
        Object coroutine_suspended;
        Object withContext = BuildersKt.withContext(Dispatchers.getMain(), new WinkMaliDrawFragment$showStatus$2(this, str, null), continuation);
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (withContext == coroutine_suspended) {
            return withContext;
        }
        return Unit.INSTANCE;
    }

    public void _$_clearFindViewByIdCache() {
        this.P.clear();
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @Nullable
    public List<Part> assembleParts() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.f169190i61;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        return 0;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        LocalMediaInfo localMediaInfo;
        ModelItem modelItem;
        String str;
        Intent intent;
        Intent intent2;
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        String str2 = null;
        if (activity != null && (intent2 = activity.getIntent()) != null) {
            localMediaInfo = (LocalMediaInfo) intent2.getParcelableExtra("image_media_info");
        } else {
            localMediaInfo = null;
        }
        this.localMediaInfo = localMediaInfo;
        FragmentActivity activity2 = getActivity();
        if (activity2 != null && (intent = activity2.getIntent()) != null) {
            modelItem = (ModelItem) intent.getParcelableExtra("use_model_item");
        } else {
            modelItem = null;
        }
        this.modelItem = modelItem;
        LocalMediaInfo localMediaInfo2 = this.localMediaInfo;
        if (localMediaInfo2 != null) {
            str = localMediaInfo2.path;
        } else {
            str = null;
        }
        if (modelItem != null) {
            str2 = modelItem.getModelName();
        }
        com.tencent.xaction.log.b.a("WinkMaliDrawFragment", 1, "[onCreate] path=" + str + ", model=" + str2);
    }

    @Override // com.tencent.biz.richframework.part.BasePartFragment, androidx.fragment.app.Fragment
    @Nullable
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ImageView imageView;
        ProgressBar progressBar;
        View view;
        View view2;
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View onCreateView = super.onCreateView(inflater, container, savedInstanceState);
        TextView textView = null;
        if (onCreateView != null) {
            imageView = (ImageView) onCreateView.findViewById(R.id.f165023um1);
        } else {
            imageView = null;
        }
        this.imageView = imageView;
        if (onCreateView != null) {
            progressBar = (ProgressBar) onCreateView.findViewById(R.id.g1o);
        } else {
            progressBar = null;
        }
        this.progressBar = progressBar;
        if (onCreateView != null) {
            view = onCreateView.findViewById(R.id.tka);
        } else {
            view = null;
        }
        this.btnToPublish = view;
        if (onCreateView != null) {
            view2 = onCreateView.findViewById(R.id.tk_);
        } else {
            view2 = null;
        }
        this.btnToEdit = view2;
        if (onCreateView != null) {
            textView = (TextView) onCreateView.findViewById(R.id.f107566ar);
        }
        this.statusTextView = textView;
        Ch();
        Dh();
        View view3 = this.btnToPublish;
        if (view3 != null) {
            view3.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aigc.newtest.e
                @Override // android.view.View.OnClickListener
                public final void onClick(View view4) {
                    WinkMaliDrawFragment.Hh(WinkMaliDrawFragment.this, view4);
                }
            });
        }
        View view4 = this.btnToEdit;
        if (view4 != null) {
            view4.setOnClickListener(new View.OnClickListener() { // from class: com.tencent.mobileqq.wink.aigc.newtest.f
                @Override // android.view.View.OnClickListener
                public final void onClick(View view5) {
                    WinkMaliDrawFragment.Ih(WinkMaliDrawFragment.this, view5);
                }
            });
        }
        AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, onCreateView);
        return onCreateView;
    }

    @Override // com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Job job = this.drawJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        Job job2 = this.progressJob;
        if (job2 != null) {
            Job.DefaultImpls.cancel$default(job2, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }
}
