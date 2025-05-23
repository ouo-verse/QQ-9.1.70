package com.tencent.mobileqq.album.custom.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.qqnt.qbasealbum.customization.common.a;
import com.tencent.qqnt.qbasealbum.customization.picker.PickerCustomizationBase;
import com.tencent.qqnt.qbasealbum.customization.preview.PreviewCustomizationBase;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00030\u0002H&J\u0018\u0010\u0007\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u00060\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/album/custom/api/IAlbumCustomApi;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "Ljava/lang/Class;", "Lcom/tencent/qqnt/qbasealbum/customization/picker/PickerCustomizationBase;", "Lcom/tencent/qqnt/qbasealbum/customization/common/a;", "getFavPickerCustom", "Lcom/tencent/qqnt/qbasealbum/customization/preview/PreviewCustomizationBase;", "getFavPreviewCustom", "base_proj_ext_api_release"}, k = 1, mv = {1, 7, 1})
@QAPI(process = {"all"})
/* loaded from: classes11.dex */
public interface IAlbumCustomApi extends QRouteApi {
    @NotNull
    Class<? extends PickerCustomizationBase<? extends a>> getFavPickerCustom();

    @NotNull
    Class<? extends PreviewCustomizationBase<? extends a>> getFavPreviewCustom();
}
