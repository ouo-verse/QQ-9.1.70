package com.tencent.mobileqq.wink.editor.aitemplate;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IQQWinkMagicStudioApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qshadow.ShadowAIGCStatus$DoActionReply;
import qshadow.ShadowAIGCStatus$GetStatusReply;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004J\b\u0010\b\u001a\u00020\u0007H\u0016R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/mobileqq/wink/editor/aitemplate/WinkEditorAITemplateViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "N1", "", "action", "O1", "", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "Lqshadow/ShadowAIGCStatus$GetStatusReply;", "i", "Landroidx/lifecycle/MutableLiveData;", "_onChanceInfoLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "onChanceInfoLiveData", "<init>", "()V", BdhLogUtil.LogTag.Tag_Conn, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkEditorAITemplateViewModel extends BaseViewModel {

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<ShadowAIGCStatus$GetStatusReply> _onChanceInfoLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<ShadowAIGCStatus$GetStatusReply> onChanceInfoLiveData;

    public WinkEditorAITemplateViewModel() {
        MutableLiveData<ShadowAIGCStatus$GetStatusReply> mutableLiveData = new MutableLiveData<>();
        this._onChanceInfoLiveData = mutableLiveData;
        this.onChanceInfoLiveData = mutableLiveData;
    }

    @NotNull
    public final LiveData<ShadowAIGCStatus$GetStatusReply> M1() {
        return this.onChanceInfoLiveData;
    }

    public final void N1() {
        ((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).requestMagicStudioButtonInfo(1, new Function1<ShadowAIGCStatus$GetStatusReply, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateViewModel$requestMagicStudioButtonInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShadowAIGCStatus$GetStatusReply shadowAIGCStatus$GetStatusReply) {
                invoke2(shadowAIGCStatus$GetStatusReply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShadowAIGCStatus$GetStatusReply it) {
                MutableLiveData mutableLiveData;
                Intrinsics.checkNotNullParameter(it, "it");
                mutableLiveData = WinkEditorAITemplateViewModel.this._onChanceInfoLiveData;
                mutableLiveData.postValue(it);
            }
        });
    }

    public final void O1(int action) {
        ((IQQWinkMagicStudioApi) QRoute.api(IQQWinkMagicStudioApi.class)).requestMagicStudioButtonDoAction(action, new Function1<ShadowAIGCStatus$DoActionReply, Unit>() { // from class: com.tencent.mobileqq.wink.editor.aitemplate.WinkEditorAITemplateViewModel$requestMagicStudioDoAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ShadowAIGCStatus$DoActionReply shadowAIGCStatus$DoActionReply) {
                invoke2(shadowAIGCStatus$DoActionReply);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ShadowAIGCStatus$DoActionReply it) {
                Intrinsics.checkNotNullParameter(it, "it");
                WinkEditorAITemplateViewModel.this.N1();
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkEditorAITemplateViewModel";
    }
}
