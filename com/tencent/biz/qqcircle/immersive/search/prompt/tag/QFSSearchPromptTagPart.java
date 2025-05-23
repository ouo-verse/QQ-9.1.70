package com.tencent.biz.qqcircle.immersive.search.prompt.tag;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import circlesearch.CircleSearchExhibition$PromptTag;
import circlesearch.CircleSearchExhibition$PromptTagInfo;
import circlesearch.CircleSearchExhibition$StPromptResp;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.biz.qqcircle.immersive.QFSBaseFragment;
import com.tencent.biz.qqcircle.immersive.part.u;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.data.base.UIStateData;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b&\u0010'J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u001c\u0010\u000b\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001b\u0010%\u001a\u00020 8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\u00a8\u0006("}, d2 = {"Lcom/tencent/biz/qqcircle/immersive/search/prompt/tag/QFSSearchPromptTagPart;", "Lcom/tencent/biz/qqcircle/immersive/part/u;", "", "getLogTag", "", "getInitRelyViewStubId", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onPartCreate", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "onInitView", "Landroid/widget/TextView;", "d", "Landroid/widget/TextView;", "tvTitle", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/tag/a;", "f", "Lcom/tencent/biz/qqcircle/immersive/search/prompt/tag/a;", "tagAdapter", "", "Lcirclesearch/CircleSearchExhibition$PromptTagInfo;", h.F, "Ljava/util/List;", "tagInfos", "Lp70/e;", "i", "Lkotlin/Lazy;", "A9", "()Lp70/e;", "viewModel", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class QFSSearchPromptTagPart extends u {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TextView tvTitle;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a tagAdapter;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private List<CircleSearchExhibition$PromptTagInfo> tagInfos;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public QFSSearchPromptTagPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<p70.e>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.tag.QFSSearchPromptTagPart$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final p70.e invoke() {
                return (p70.e) QFSSearchPromptTagPart.this.getViewModel(p70.e.class);
            }
        });
        this.viewModel = lazy;
    }

    private final p70.e A9() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (p70.e) value;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void B9(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.Part
    public int getInitRelyViewStubId() {
        return R.id.f54052e6;
    }

    @Override // com.tencent.biz.richframework.part.Part
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        return "QFSSearchPromptTagPart";
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@Nullable View rootView) {
        TextView textView;
        super.onInitView(rootView);
        RecyclerView recyclerView = null;
        if (rootView != null) {
            textView = (TextView) rootView.findViewById(R.id.f54042e5);
        } else {
            textView = null;
        }
        this.tvTitle = textView;
        if (rootView != null) {
            recyclerView = (RecyclerView) rootView.findViewById(R.id.f54022e3);
        }
        this.recyclerView = recyclerView;
        if (recyclerView != null) {
            recyclerView.setLayoutManager(new GridLayoutManager(recyclerView.getContext(), 2));
            recyclerView.setNestedScrollingEnabled(false);
            recyclerView.addItemDecoration(new e());
            a aVar = new a();
            this.tagAdapter = aVar;
            recyclerView.setAdapter(aVar);
        }
        a aVar2 = this.tagAdapter;
        if (aVar2 != null) {
            aVar2.setData(this.tagInfos);
        }
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onPartCreate(@Nullable Activity activity, @Nullable Bundle savedInstanceState) {
        super.onPartCreate(activity, savedInstanceState);
        MutableLiveData<UIStateData<CircleSearchExhibition$StPromptResp>> M1 = A9().M1();
        QFSBaseFragment hostFragment = getHostFragment();
        final Function1<UIStateData<CircleSearchExhibition$StPromptResp>, Unit> function1 = new Function1<UIStateData<CircleSearchExhibition$StPromptResp>, Unit>() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.tag.QFSSearchPromptTagPart$onPartCreate$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(UIStateData<CircleSearchExhibition$StPromptResp> uIStateData) {
                invoke2(uIStateData);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(UIStateData<CircleSearchExhibition$StPromptResp> uIStateData) {
                CircleSearchExhibition$PromptTag circleSearchExhibition$PromptTag;
                PBRepeatMessageField<CircleSearchExhibition$PromptTagInfo> pBRepeatMessageField;
                String tag = QFSSearchPromptTagPart.this.getTAG();
                CircleSearchExhibition$StPromptResp data = uIStateData.getData();
                QLog.d(tag, 1, "[onChanged] " + ((data == null || (circleSearchExhibition$PromptTag = data.tag_search) == null || (pBRepeatMessageField = circleSearchExhibition$PromptTag.hot_info) == null) ? null : Integer.valueOf(pBRepeatMessageField.size())));
                if (uIStateData.getState() == 2 || uIStateData.getState() == 3) {
                    if (uIStateData.getData() == null) {
                        QLog.w(QFSSearchPromptTagPart.this.getTAG(), 1, "[onChanged] invalid data");
                    } else if (!uIStateData.getData().tag_search.hot_info.isEmpty()) {
                        QFSSearchPromptTagPart.this.tagInfos = uIStateData.getData().tag_search.hot_info.get();
                        QFSSearchPromptTagPart.this.startInit();
                    } else {
                        QLog.d(QFSSearchPromptTagPart.this.getTAG(), 1, "[onChanged] empty data");
                    }
                }
            }
        };
        M1.observe(hostFragment, new Observer() { // from class: com.tencent.biz.qqcircle.immersive.search.prompt.tag.b
            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                QFSSearchPromptTagPart.B9(Function1.this, obj);
            }
        });
    }
}
