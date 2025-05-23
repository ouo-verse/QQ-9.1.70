package com.tencent.mobileqq.qwallet.hb.panel.preview;

import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.tencent.mobileqq.activity.aio.p;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qwallet.hb.panel.recommend.SkinRecommendViewModel;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$GetRecommendSkinsRsp;
import com.tencent.mobileqq.qwallet.pb.RedPackSkin$RecommendSkin;
import com.tencent.mobileqq.qwallet.pb.RedPackSkinExt;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020\"\u00a2\u0006\u0004\b$\u0010%Jj\u0010\u000e\u001a\u00020\f2b\u0010\r\u001a^\u0012\u0013\u0012\u00110\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\u0007\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\n\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0002R\u0017\u0010\b\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u001e\u001a\u0004\u0018\u00010\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001f\u0010\u0010\u001a\u0004\b \u0010\u0012\u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/qwallet/hb/panel/preview/SkinPreviewEntryViewModel;", "Landroidx/lifecycle/ViewModel;", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "", "skinId", "errCode", "", "errMsg", "", "callback", "P1", "i", "I", "N1", "()I", "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "O1", "()Lcom/tencent/mobileqq/qwallet/hb/panel/recommend/SkinRecommendViewModel;", "skinRecommendVM", "Lcom/tencent/mobileqq/activity/aio/p;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/mobileqq/activity/aio/p;", "M1", "()Lcom/tencent/mobileqq/activity/aio/p;", "currentSessionInfo", "D", "L1", "currentHbType", "Landroidx/lifecycle/SavedStateHandle;", "stateHandle", "<init>", "(Landroidx/lifecycle/SavedStateHandle;)V", "qqpay-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class SkinPreviewEntryViewModel extends ViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private final p currentSessionInfo;

    /* renamed from: D, reason: from kotlin metadata */
    private final int currentHbType;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final int skinId;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final SkinRecommendViewModel skinRecommendVM;

    public SkinPreviewEntryViewModel(@NotNull SavedStateHandle stateHandle) {
        int intValue;
        Intrinsics.checkNotNullParameter(stateHandle, "stateHandle");
        Integer num = (Integer) stateHandle.get("skin_id");
        if (num == null) {
            intValue = 0;
        } else {
            intValue = num.intValue();
        }
        this.skinId = intValue;
        this.skinRecommendVM = new SkinRecommendViewModel();
        f fVar = f.f277592a;
        this.currentSessionInfo = fVar.d();
        this.currentHbType = fVar.c();
    }

    /* renamed from: L1, reason: from getter */
    public final int getCurrentHbType() {
        return this.currentHbType;
    }

    @Nullable
    /* renamed from: M1, reason: from getter */
    public final p getCurrentSessionInfo() {
        return this.currentSessionInfo;
    }

    /* renamed from: N1, reason: from getter */
    public final int getSkinId() {
        return this.skinId;
    }

    @NotNull
    /* renamed from: O1, reason: from getter */
    public final SkinRecommendViewModel getSkinRecommendVM() {
        return this.skinRecommendVM;
    }

    public final void P1(@NotNull final Function4<? super Boolean, ? super Integer, ? super Integer, ? super String, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.skinRecommendVM.o2(this.skinId, 3, new Function3<RedPackSkin$GetRecommendSkinsRsp, Integer, String, Unit>() { // from class: com.tencent.mobileqq.qwallet.hb.panel.preview.SkinPreviewEntryViewModel$requestSkinInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(RedPackSkin$GetRecommendSkinsRsp redPackSkin$GetRecommendSkinsRsp, Integer num, String str) {
                invoke(redPackSkin$GetRecommendSkinsRsp, num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable RedPackSkin$GetRecommendSkinsRsp redPackSkin$GetRecommendSkinsRsp, int i3, @Nullable String str) {
                RedPackSkin$RecommendSkin redPackSkin$RecommendSkin;
                ArrayList arrayListOf;
                List<RedPackSkin$RecommendSkin> list;
                Object firstOrNull;
                List<RedPackSkin$RecommendSkin> list2;
                if (redPackSkin$GetRecommendSkinsRsp == null) {
                    callback.invoke(Boolean.FALSE, 0, Integer.valueOf(i3), str);
                    return;
                }
                PBRepeatMessageField<RedPackSkin$RecommendSkin> pBRepeatMessageField = redPackSkin$GetRecommendSkinsRsp.skins;
                QLog.d("SkinRecommendViewModel", 2, "refreshSkinInfo: callback skinId " + ((pBRepeatMessageField == null || (list2 = pBRepeatMessageField.get()) == null) ? null : RedPackSkinExt.b(list2)));
                PBRepeatMessageField<RedPackSkin$RecommendSkin> pBRepeatMessageField2 = redPackSkin$GetRecommendSkinsRsp.skins;
                if (pBRepeatMessageField2 == null || (list = pBRepeatMessageField2.get()) == null) {
                    redPackSkin$RecommendSkin = null;
                } else {
                    firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    redPackSkin$RecommendSkin = (RedPackSkin$RecommendSkin) firstOrNull;
                }
                if (redPackSkin$RecommendSkin != null) {
                    arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(com.tencent.mobileqq.qwallet.pb.a.INSTANCE.b(redPackSkin$RecommendSkin));
                    this.getSkinRecommendVM().Z1().postValue(arrayListOf);
                    callback.invoke(Boolean.TRUE, Integer.valueOf(this.getSkinId()), 0, null);
                    return;
                }
                callback.invoke(Boolean.FALSE, 0, Integer.valueOf(redPackSkin$GetRecommendSkinsRsp.err_code.get()), redPackSkin$GetRecommendSkinsRsp.err_msg.get());
            }
        });
    }
}
