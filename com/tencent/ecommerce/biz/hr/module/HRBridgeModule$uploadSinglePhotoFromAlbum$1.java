package com.tencent.ecommerce.biz.hr.module;

import com.tencent.ecommerce.base.pageopener.api.IECMediaSelector;
import com.tencent.ecommerce.base.pageopener.api.imageselector.ECMediaInfo;
import com.tencent.ecommerce.biz.comment.BatchUploader;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/ecommerce/biz/hr/module/HRBridgeModule$uploadSinglePhotoFromAlbum$1", "Lcom/tencent/ecommerce/base/pageopener/api/IECMediaSelector$ECMediaSelectorResultCallback;", "", "Lcom/tencent/ecommerce/base/pageopener/api/imageselector/c;", "medias", "", "onAlbumSelectedResultCallback", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class HRBridgeModule$uploadSinglePhotoFromAlbum$1 implements IECMediaSelector.ECMediaSelectorResultCallback {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ HRBridgeModule f102600a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ CoroutineScope f102601b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ JSONObject f102602c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ BatchUploader f102603d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ Function1 f102604e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HRBridgeModule$uploadSinglePhotoFromAlbum$1(HRBridgeModule hRBridgeModule, CoroutineScope coroutineScope, JSONObject jSONObject, BatchUploader batchUploader, Function1 function1) {
        this.f102600a = hRBridgeModule;
        this.f102601b = coroutineScope;
        this.f102602c = jSONObject;
        this.f102603d = batchUploader;
        this.f102604e = function1;
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector.ECMediaSelectorResultCallback
    public void onAlbumSelectedResultCallback(List<ECMediaInfo> medias) {
        BuildersKt__Builders_commonKt.launch$default(this.f102601b, null, null, new HRBridgeModule$uploadSinglePhotoFromAlbum$1$onAlbumSelectedResultCallback$1(this, medias, null), 3, null);
    }

    @Override // com.tencent.ecommerce.base.pageopener.api.IECMediaSelector.ECMediaSelectorResultCallback
    public void onCameraCaptureResultCallback(List<ECMediaInfo> list) {
        IECMediaSelector.ECMediaSelectorResultCallback.a.a(this, list);
    }
}
