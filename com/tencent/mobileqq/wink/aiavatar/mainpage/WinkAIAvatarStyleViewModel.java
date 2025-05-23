package com.tencent.mobileqq.wink.aiavatar.mainpage;

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
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u0000 =2\u00020\u0001:\u0001>B\u0007\u00a2\u0006\u0004\b;\u0010<J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0006\u0010\b\u001a\u00020\u0006J\u0010\u0010\t\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u0006\u0010\u000f\u001a\u00020\nR\u001a\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u0012R\u001d\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0006\u00a2\u0006\f\n\u0004\b\u001c\u0010\u0016\u001a\u0004\b\u001d\u0010\u0018R\u001a\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0012R\u001d\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u00148\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u0016\u001a\u0004\b\"\u0010\u0018R\u0016\u0010&\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010)\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010(R\"\u00102\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b-\u0010*\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u00106\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b3\u0010*\u001a\u0004\b4\u0010/\"\u0004\b5\u00101R\"\u0010:\u001a\u00020,8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b7\u0010*\u001a\u0004\b8\u0010/\"\u0004\b9\u00101\u00a8\u0006?"}, d2 = {"Lcom/tencent/mobileqq/wink/aiavatar/mainpage/WinkAIAvatarStyleViewModel;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Landroid/os/Bundle;", "arguments", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "Z1", "b2", "W1", "", "getLogTag", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaCategory;", "metaCategory", "X1", "O1", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_materialCategoryLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "P1", "()Landroidx/lifecycle/LiveData;", "materialCategoryLiveData", BdhLogUtil.LogTag.Tag_Conn, "_shareInfoCategoryLiveData", "D", "Q1", "shareInfoCategoryLiveData", "E", "_uploadImgSuggestData", UserInfo.SEX_FEMALE, "U1", "uploadImgSuggestData", "G", "Z", "isSchemeJump", "H", "Ljava/lang/String;", "targetMaterialID", "I", "comeFrom", "", "J", "T1", "()I", "setTargetStyleTabPosition", "(I)V", "targetStyleTabPosition", "K", "R1", "setTargetStyleGroupPosition", "targetStyleGroupPosition", "L", "S1", "setTargetStyleItemPosition", "targetStyleItemPosition", "<init>", "()V", "M", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkAIAvatarStyleViewModel extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaCategory> _shareInfoCategoryLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MetaCategory> shareInfoCategoryLiveData;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaCategory> _uploadImgSuggestData;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<MetaCategory> uploadImgSuggestData;

    /* renamed from: G, reason: from kotlin metadata */
    private boolean isSchemeJump;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String targetMaterialID;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private String comeFrom;

    /* renamed from: J, reason: from kotlin metadata */
    private int targetStyleTabPosition;

    /* renamed from: K, reason: from kotlin metadata */
    private int targetStyleGroupPosition;

    /* renamed from: L, reason: from kotlin metadata */
    private int targetStyleItemPosition;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaCategory> _materialCategoryLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<MetaCategory> materialCategoryLiveData;

    public WinkAIAvatarStyleViewModel() {
        MutableLiveData<MetaCategory> mutableLiveData = new MutableLiveData<>();
        this._materialCategoryLiveData = mutableLiveData;
        this.materialCategoryLiveData = mutableLiveData;
        MutableLiveData<MetaCategory> mutableLiveData2 = new MutableLiveData<>();
        this._shareInfoCategoryLiveData = mutableLiveData2;
        this.shareInfoCategoryLiveData = mutableLiveData2;
        MutableLiveData<MetaCategory> mutableLiveData3 = new MutableLiveData<>();
        this._uploadImgSuggestData = mutableLiveData3;
        this.uploadImgSuggestData = mutableLiveData3;
        this.targetMaterialID = "";
        this.comeFrom = "0";
    }

    private final void Z1(Bundle arguments) {
        String str;
        String str2 = null;
        if (arguments != null) {
            str = arguments.getString("come_from");
        } else {
            str = null;
        }
        if (str == null) {
            str = "0";
        }
        this.comeFrom = str;
        if (arguments != null) {
            str2 = arguments.getString("material_id");
        }
        if (str2 == null) {
            str2 = "";
        }
        this.targetMaterialID = str2;
        w53.b.f("WinkAIAvatarViewModel", "parseNormalJumpArguments: " + this.comeFrom + ", " + str2);
    }

    private final boolean a2(Bundle arguments) {
        String str;
        if (arguments != null) {
            str = arguments.getString("key_scheme");
        } else {
            str = null;
        }
        w53.b.f("WinkAIAvatarViewModel", "parseSchemeArguments: " + str);
        com.tencent.mobileqq.wink.schema.d dVar = com.tencent.mobileqq.wink.schema.d.f326305a;
        if (!Intrinsics.areEqual(dVar.l("target", arguments), "24")) {
            return false;
        }
        this.isSchemeJump = true;
        String l3 = dVar.l("come_from", arguments);
        if (l3 == null) {
            l3 = "1";
        }
        this.comeFrom = l3;
        String l16 = dVar.l("material_id", arguments);
        if (l16 == null) {
            l16 = "";
        }
        this.targetMaterialID = l16;
        return true;
    }

    @NotNull
    /* renamed from: O1, reason: from getter */
    public final String getComeFrom() {
        return this.comeFrom;
    }

    @NotNull
    public final LiveData<MetaCategory> P1() {
        return this.materialCategoryLiveData;
    }

    @NotNull
    public final LiveData<MetaCategory> Q1() {
        return this.shareInfoCategoryLiveData;
    }

    /* renamed from: R1, reason: from getter */
    public final int getTargetStyleGroupPosition() {
        return this.targetStyleGroupPosition;
    }

    /* renamed from: S1, reason: from getter */
    public final int getTargetStyleItemPosition() {
        return this.targetStyleItemPosition;
    }

    /* renamed from: T1, reason: from getter */
    public final int getTargetStyleTabPosition() {
        return this.targetStyleTabPosition;
    }

    @NotNull
    public final LiveData<MetaCategory> U1() {
        return this.uploadImgSuggestData;
    }

    public final void W1(@Nullable Bundle arguments) {
        if (a2(arguments)) {
            return;
        }
        Z1(arguments);
    }

    public final void X1(@Nullable MetaCategory metaCategory) {
        boolean z16;
        if (this.targetMaterialID.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z16 && metaCategory != null) {
            ArrayList<MetaCategory> arrayList = metaCategory.subCategories;
            Intrinsics.checkNotNullExpressionValue(arrayList, "metaCategory.subCategories");
            int i3 = 0;
            for (Object obj : arrayList) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                ArrayList<MetaCategory> arrayList2 = ((MetaCategory) obj).subCategories;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "tabCategories.subCategories");
                int i17 = 0;
                for (Object obj2 : arrayList2) {
                    int i18 = i17 + 1;
                    if (i17 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    ArrayList<MetaMaterial> arrayList3 = ((MetaCategory) obj2).materials;
                    Intrinsics.checkNotNullExpressionValue(arrayList3, "groupCategories.materials");
                    Iterator<MetaMaterial> it = arrayList3.iterator();
                    int i19 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            if (Intrinsics.areEqual(it.next().f30533id, this.targetMaterialID)) {
                                break;
                            } else {
                                i19++;
                            }
                        } else {
                            i19 = -1;
                            break;
                        }
                    }
                    if (i19 >= 0) {
                        this.targetStyleTabPosition = i3;
                        this.targetStyleGroupPosition = i17;
                        this.targetStyleItemPosition = i19;
                        return;
                    }
                    i17 = i18;
                }
                i3 = i16;
            }
        }
    }

    public final void b2() {
        w53.b.f("WinkAIAvatarViewModel", "requestMaterials");
        WinkAIAvatarUtils.f317678a.u(false, new Function1<List<? extends MetaCategory>, Unit>() { // from class: com.tencent.mobileqq.wink.aiavatar.mainpage.WinkAIAvatarStyleViewModel$requestMaterials$1
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
                MetaCategory metaCategory;
                MutableLiveData mutableLiveData;
                MetaCategory metaCategory2;
                MutableLiveData mutableLiveData2;
                MutableLiveData mutableLiveData3;
                Object obj;
                Object obj2;
                MetaCategory metaCategory3 = null;
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            obj2 = null;
                            break;
                        } else {
                            obj2 = it.next();
                            if (Intrinsics.areEqual(((MetaCategory) obj2).f30532id, "ai_avatar")) {
                                break;
                            }
                        }
                    }
                    metaCategory = (MetaCategory) obj2;
                } else {
                    metaCategory = null;
                }
                mutableLiveData = WinkAIAvatarStyleViewModel.this._materialCategoryLiveData;
                mutableLiveData.postValue(metaCategory);
                if (list != null) {
                    Iterator<T> it5 = list.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            obj = null;
                            break;
                        } else {
                            obj = it5.next();
                            if (Intrinsics.areEqual(((MetaCategory) obj).f30532id, "share")) {
                                break;
                            }
                        }
                    }
                    metaCategory2 = (MetaCategory) obj;
                } else {
                    metaCategory2 = null;
                }
                mutableLiveData2 = WinkAIAvatarStyleViewModel.this._shareInfoCategoryLiveData;
                mutableLiveData2.postValue(metaCategory2);
                if (list != null) {
                    Iterator<T> it6 = list.iterator();
                    while (true) {
                        if (!it6.hasNext()) {
                            break;
                        }
                        Object next = it6.next();
                        if (Intrinsics.areEqual(((MetaCategory) next).f30532id, "upload_pic_suggest")) {
                            metaCategory3 = next;
                            break;
                        }
                    }
                    metaCategory3 = metaCategory3;
                }
                mutableLiveData3 = WinkAIAvatarStyleViewModel.this._uploadImgSuggestData;
                mutableLiveData3.postValue(metaCategory3);
            }
        });
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkAIAvatarViewModel";
    }
}
