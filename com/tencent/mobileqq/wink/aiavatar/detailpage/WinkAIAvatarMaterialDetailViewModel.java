package com.tencent.mobileqq.wink.aiavatar.detailpage;

import android.os.Bundle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.aiavatar.base.WinkAIAvatarUtils;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u0000 $2\u00020\u0001:\u0001%B\u0007\u00a2\u0006\u0004\b\"\u0010#J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0006\u0010\u0004\u001a\u00020\u0002J\u0010\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005J\u0006\u0010\n\u001a\u00020\tJ\u0006\u0010\f\u001a\u00020\u000bJ\u0006\u0010\r\u001a\u00020\u0007R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001e\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006&"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/detailpage/WinkAIAvatarMaterialDetailViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "getLogTag", "M1", "Landroid/os/Bundle;", "arguments", "", "Q1", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "O1", "", "P1", "R1", "Landroidx/lifecycle/MutableLiveData;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "i", "Landroidx/lifecycle/MutableLiveData;", "_uploadPicSuggestInfoCategoryLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "N1", "()Landroidx/lifecycle/LiveData;", "onUploadPicSuggestInfoCategoryLiveData", BdhLogUtil.LogTag.Tag_Conn, "Z", "isCoupleAvatar", "D", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "originStyleMaterial", "E", "Ljava/lang/String;", "comeFrom", "<init>", "()V", UserInfo.SEX_FEMALE, "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarMaterialDetailViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    private boolean isCoupleAvatar;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private MetaMaterial originStyleMaterial;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private String comeFrom;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaCategory> _uploadPicSuggestInfoCategoryLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<MetaCategory> onUploadPicSuggestInfoCategoryLiveData;

    public WinkAIAvatarMaterialDetailViewModel() {
        MutableLiveData<MetaCategory> mutableLiveData = new MutableLiveData<>();
        this._uploadPicSuggestInfoCategoryLiveData = mutableLiveData;
        this.onUploadPicSuggestInfoCategoryLiveData = mutableLiveData;
        this.originStyleMaterial = new MetaMaterial();
        this.comeFrom = "0";
    }

    @NotNull
    /* renamed from: M1, reason: from getter */
    public final String getComeFrom() {
        return this.comeFrom;
    }

    @NotNull
    public final LiveData<MetaCategory> N1() {
        return this.onUploadPicSuggestInfoCategoryLiveData;
    }

    @NotNull
    /* renamed from: O1, reason: from getter */
    public final MetaMaterial getOriginStyleMaterial() {
        return this.originStyleMaterial;
    }

    /* renamed from: P1, reason: from getter */
    public final boolean getIsCoupleAvatar() {
        return this.isCoupleAvatar;
    }

    public final void Q1(@Nullable Bundle arguments) {
        Serializable serializable;
        String str = null;
        if (arguments != null) {
            serializable = arguments.getSerializable("selected_style_material");
        } else {
            serializable = null;
        }
        MetaMaterial metaMaterial = (MetaMaterial) serializable;
        if (metaMaterial != null) {
            this.originStyleMaterial = metaMaterial;
        }
        boolean z16 = true;
        if (!com.tencent.mobileqq.wink.editor.c.Z0(this.originStyleMaterial)) {
            z16 = false;
        }
        this.isCoupleAvatar = z16;
        if (arguments != null) {
            str = arguments.getString("come_from");
        }
        if (str == null) {
            str = "0";
        }
        this.comeFrom = str;
    }

    public final void R1() {
        WinkAIAvatarUtils.f317678a.u(true, new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.detailpage.WinkAIAvatarMaterialDetailViewModel$requestUploadPicSuggestInfo$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends MetaCategory> list) {
                invoke2((List<MetaCategory>) list);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable List<MetaCategory> list) {
                MutableLiveData mutableLiveData;
                MetaCategory metaCategory = null;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        Object next = it.next();
                        if (Intrinsics.areEqual(((MetaCategory) next).f30532id, "upload_pic_suggest")) {
                            metaCategory = next;
                            break;
                        }
                    }
                    metaCategory = metaCategory;
                }
                if (metaCategory == null) {
                    w53.b.c("WinkAIAvatarMaterialDetailViewModel", "requestUploadPicSuggestInfo failed");
                } else {
                    WinkAIAvatarUtils.f317678a.x(metaCategory);
                    w53.b.f("WinkAIAvatarMaterialDetailViewModel", "requestUploadPicSuggestInfo success " + metaCategory.materials.size());
                }
                mutableLiveData = WinkAIAvatarMaterialDetailViewModel.this._uploadPicSuggestInfoCategoryLiveData;
                mutableLiveData.postValue(metaCategory);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkAIAvatarMaterialDetailViewModel";
    }
}
