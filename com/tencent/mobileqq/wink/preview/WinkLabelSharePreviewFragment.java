package com.tencent.mobileqq.wink.preview;

import android.os.Bundle;
import android.view.View;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.biz.richframework.part.ImmersivePartFragment;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.preview.part.label.WinkLabelSharePreviewMediaPart;
import com.tencent.mobileqq.wink.preview.part.label.WinkLabelSharePreviewPublishPart;
import com.tencent.mobileqq.wink.preview.part.label.WinkLabelSharePreviewSyncQZonePart;
import com.tencent.mobileqq.winkreport.datong.WinkDTParamBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import uq3.c;
import w53.b;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001dB\u0007\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u000b\u001a\u00020\nH\u0014J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0014R\u001b\u0010\u0019\u001a\u00020\u00148BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/wink/preview/WinkLabelSharePreviewFragment;", "Lcom/tencent/biz/richframework/part/ImmersivePartFragment;", "", "rh", "qh", "Landroid/view/View;", "contentView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onViewCreatedAfterPartInit", "", "isUseDarkTextStatusBar", "view", DKEngine.ExtraEvent.EXTRA_EVENT_ON_VIEW_CREATED, "", "getContentLayoutId", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "getStatusBarColor", "Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "ph", "()Lcom/tencent/mobileqq/wink/preview/viewmodel/a;", "viewModel", "<init>", "()V", "D", "a", "qq-wink-temp-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkLabelSharePreviewFragment extends ImmersivePartFragment {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    public WinkLabelSharePreviewFragment() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.wink.preview.viewmodel.a>() { // from class: com.tencent.mobileqq.wink.preview.WinkLabelSharePreviewFragment$viewModel$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final com.tencent.mobileqq.wink.preview.viewmodel.a invoke() {
                return (com.tencent.mobileqq.wink.preview.viewmodel.a) WinkLabelSharePreviewFragment.this.getViewModel(com.tencent.mobileqq.wink.preview.viewmodel.a.class);
            }
        });
        this.viewModel = lazy;
    }

    private final com.tencent.mobileqq.wink.preview.viewmodel.a ph() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.wink.preview.viewmodel.a) value;
    }

    private final void qh() {
        Object obj;
        try {
            Bundle extras = getHostActivity().getIntent().getExtras();
            if (extras != null) {
                obj = extras.get("key_attrs");
            } else {
                obj = null;
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
            HashMap hashMap = (HashMap) obj;
            ArrayList arrayList = new ArrayList();
            for (int i3 = 0; i3 < 10; i3++) {
                String str = QCircleScheme.AttrQQPublish.LABEL_FOR_QQ + i3;
                if (hashMap.containsKey(str)) {
                    Object obj2 = hashMap.get(str);
                    Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
                    arrayList.add((String) obj2);
                }
            }
            ph().h2(arrayList);
        } catch (Exception e16) {
            b.b("WinkLabelSharePreviewFragment", "get qq label failed! ", e16);
        }
    }

    private final void rh() {
        List<String> mutableListOf;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(ph().getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String());
        mutableListOf.add(ph().getCom.qzone.album.data.model.PhotoCategorySummaryInfo.AVATAR_URL java.lang.String());
        ph().e2(mutableListOf);
    }

    @Override // com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new com.tencent.mobileqq.wink.preview.part.label.a());
        arrayList.add(new WinkLabelSharePreviewPublishPart());
        arrayList.add(new WinkLabelSharePreviewMediaPart());
        arrayList.add(new WinkLabelSharePreviewSyncQZonePart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        return R.layout.i7t;
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    protected int getStatusBarColor() {
        if (!QQTheme.isNowThemeIsNight()) {
            return -1;
        }
        return -16777216;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment
    public boolean isUseDarkTextStatusBar() {
        if (!c.P6()) {
            return true;
        }
        return !QQTheme.isNowThemeIsNight();
    }

    @Override // com.tencent.biz.richframework.part.ImmersivePartFragment, androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        view.setBackgroundColor(getStatusBarColor());
        ph().i2(this);
        qh();
        rh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.BasePartFragment
    public void onViewCreatedAfterPartInit(@NotNull View contentView, @Nullable Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(contentView, "contentView");
        super.onViewCreatedAfterPartInit(contentView, savedInstanceState);
        VideoReport.addToDetectionWhitelist(getActivity());
        String c16 = WinkContext.INSTANCE.d().getDtParams().c();
        VideoReport.setPageId(getView(), WinkDaTongReportConstant.PageId.PG_QQ_MY_PERSONAL_TAG_PAGE);
        VideoReport.setPageParams(getView(), new WinkDTParamBuilder().buildPageParams(null, c16));
    }
}
