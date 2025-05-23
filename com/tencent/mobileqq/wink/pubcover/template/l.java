package com.tencent.mobileqq.wink.pubcover.template;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b,\u0010-J\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001c\u0010\n\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006J\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002J\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006J\b\u0010\r\u001a\u0004\u0018\u00010\u0002J\u001a\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007J\b\u0010\u0014\u001a\u00020\u0007H\u0016R\u001c\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u001f\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00158\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u001f\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00198\u0006\u00a2\u0006\f\n\u0004\b!\u0010\u001b\u001a\u0004\b\"\u0010\u001dR\u0018\u0010&\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010%R$\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*\u00a8\u0006."}, d2 = {"Lcom/tencent/mobileqq/wink/pubcover/template/l;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "", "T1", "", "", "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", com.tencent.luggage.wxa.c8.c.B, "U1", "N1", "O1", "P1", WadlProxyConsts.KEY_MATERIAL, "", "shouldPost", "Q1", "id", "S1", "getLogTag", "Landroidx/lifecycle/MutableLiveData;", "i", "Landroidx/lifecycle/MutableLiveData;", "_currentMetaMaterialLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "M1", "()Landroidx/lifecycle/LiveData;", "currentMetaMaterialLiveData", BdhLogUtil.LogTag.Tag_Conn, "_currentMetaMaterialIdLiveData", "D", "L1", "currentMetaMaterialId", "E", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "beforeMetaMaterial", UserInfo.SEX_FEMALE, "currentMeatMaterial", "G", "Ljava/util/Map;", "enterStickers", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class l extends BaseViewModel {

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<String> _currentMetaMaterialIdLiveData;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<String> currentMetaMaterialId;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial beforeMetaMaterial;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private MetaMaterial currentMeatMaterial;

    /* renamed from: G, reason: from kotlin metadata */
    @Nullable
    private Map<String, WinkStickerModel> enterStickers;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<MetaMaterial> _currentMetaMaterialLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<MetaMaterial> currentMetaMaterialLiveData;

    public l() {
        MutableLiveData<MetaMaterial> mutableLiveData = new MutableLiveData<>();
        this._currentMetaMaterialLiveData = mutableLiveData;
        this.currentMetaMaterialLiveData = mutableLiveData;
        MutableLiveData<String> mutableLiveData2 = new MutableLiveData<>();
        this._currentMetaMaterialIdLiveData = mutableLiveData2;
        this.currentMetaMaterialId = mutableLiveData2;
    }

    public static /* synthetic */ void R1(l lVar, MetaMaterial metaMaterial, boolean z16, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        lVar.Q1(metaMaterial, z16);
    }

    @NotNull
    public final LiveData<String> L1() {
        return this.currentMetaMaterialId;
    }

    @NotNull
    public final LiveData<MetaMaterial> M1() {
        return this.currentMetaMaterialLiveData;
    }

    @Nullable
    /* renamed from: N1, reason: from getter */
    public final MetaMaterial getBeforeMetaMaterial() {
        return this.beforeMetaMaterial;
    }

    @Nullable
    public final Map<String, WinkStickerModel> O1() {
        return this.enterStickers;
    }

    @Nullable
    /* renamed from: P1, reason: from getter */
    public final MetaMaterial getCurrentMeatMaterial() {
        return this.currentMeatMaterial;
    }

    public final void Q1(@Nullable MetaMaterial material, boolean shouldPost) {
        String str;
        String str2;
        String str3 = null;
        if (material != null) {
            str = material.f30533id;
        } else {
            str = null;
        }
        MetaMaterial metaMaterial = this.currentMeatMaterial;
        if (metaMaterial != null) {
            str2 = metaMaterial.f30533id;
        } else {
            str2 = null;
        }
        if (Intrinsics.areEqual(str, str2)) {
            return;
        }
        if (shouldPost) {
            this._currentMetaMaterialLiveData.postValue(material);
        }
        if (material != null) {
            str3 = material.f30533id;
        }
        S1(str3);
        this.currentMeatMaterial = material;
    }

    public final void S1(@Nullable String id5) {
        this._currentMetaMaterialIdLiveData.postValue(id5);
    }

    public final void T1(@Nullable MetaMaterial metaMaterial) {
        this.beforeMetaMaterial = metaMaterial;
    }

    public final void U1(@Nullable Map<String, WinkStickerModel> stickers) {
        Set<String> keySet;
        Map<String, WinkStickerModel> map;
        this.enterStickers = new LinkedHashMap();
        if (stickers != null && (keySet = stickers.keySet()) != null) {
            for (String str : keySet) {
                WinkStickerModel winkStickerModel = stickers.get(str);
                if (winkStickerModel != null && (map = this.enterStickers) != null) {
                    map.put(str, winkStickerModel);
                }
            }
        }
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    public String getLogTag() {
        return "WinkCoverTemplateMenuViewModel";
    }
}
