package com.tencent.mobileqq.album.custom.api.impl;

import com.tencent.mobileqq.activity.photo.albumlogicImp.PickerCustomizationFavourite;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PreviewCustomizationFavourite;
import com.tencent.mobileqq.album.custom.api.IAlbumCustomApi;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002H\u0016J\u0018\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00060\u0002H\u0016\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/album/custom/api/impl/AlbumCustomApiImpl;", "Lcom/tencent/mobileqq/album/custom/api/IAlbumCustomApi;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "getFavPickerCustom", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "getFavPreviewCustom", "<init>", "()V", "base_proj_ext_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class AlbumCustomApiImpl implements IAlbumCustomApi {
    @Override // com.tencent.mobileqq.album.custom.api.IAlbumCustomApi
    public Class<? extends PickerCustomizationBase<? extends a>> getFavPickerCustom() {
        return PickerCustomizationFavourite.class;
    }

    @Override // com.tencent.mobileqq.album.custom.api.IAlbumCustomApi
    public Class<? extends PreviewCustomizationBase<? extends a>> getFavPreviewCustom() {
        return PreviewCustomizationFavourite.class;
    }
}
