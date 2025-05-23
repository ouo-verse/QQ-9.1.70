package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.wink.api.IWinkEditorResourceAPI;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.TemplateLibraryHolderInfo;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.AudioOutputConfig;
import org.light.ClipPlaceHolder;
import org.light.LightAsset;
import org.light.LightEngine;
import org.light.RendererConfig;
import org.light.VideoOutputConfig;
import s53.a;
import s53.b;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001;BL\u0012\u0006\u0010-\u001a\u00020,\u0012\u0006\u0010/\u001a\u00020.\u0012\u000e\b\u0002\u00101\u001a\b\u0012\u0004\u0012\u00020\u001900\u0012#\b\u0002\u00107\u001a\u001d\u0012\u0013\u0012\u001103\u00a2\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u001902\u00a2\u0006\u0004\b8\u00109J.\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n2\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00052\u0006\u0010\f\u001a\u00020\u0003H\u0002J#\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0012\u0010\u0011J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u000f\u001a\u00020\u0002H\u0016J\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0003H\u0014J:\u0010\u001a\u001a\u00020\u0019*\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`\u00182\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0016J*\u0010\u001d\u001a\u00020\u0019*\u00020\u001b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00032\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016Jv\u0010(\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u00172\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00170\u00052\b\u0010\"\u001a\u0004\u0018\u00010\u00172\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010$\u001a\u0004\u0018\u00010\u00172\u0006\u0010&\u001a\u00020%2\"\u0010'\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`\u0018H\u0016R\u0014\u0010+\u001a\u00020\u00178TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b)\u0010*\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/adapter/click/WinkMemoryAlbumClickDelegator;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/adapter/click/BaseWinkAlbumClickDelegator;", "Ls53/a;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "metaMaterial", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/wink/picker/TemplateLibraryHolderInfo;", "Lkotlin/collections/ArrayList;", "D", WadlProxyConsts.KEY_MATERIAL, "", BdhLogUtil.LogTag.Tag_Conn, "data", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "(Ls53/a;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "y", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/mobileqq/wink/picker/d;", "B", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "", "w", "Landroid/content/Intent;", "selectedMedias", HippyTKDListViewAdapter.X, "Landroid/content/Context;", "context", QQWinkConstants.STORY_ID, "templateIds", "firstMediaPath", "mediaInfoList", "classifyId", "", "maxPicNum", Node.ATTRS_ATTR, "r", "i", "()Ljava/lang/String;", "logTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lkotlin/Function0;", "onBeforeLoad", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "onAfterLoad", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "g", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkMemoryAlbumClickDelegator extends BaseWinkAlbumClickDelegator<a> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkMemoryAlbumClickDelegator(@NotNull Activity activity, @NotNull WinkMediaPickerNextStepHelper nextStepHelper, @NotNull Function0<Unit> onBeforeLoad, @NotNull Function1<? super Boolean, Unit> onAfterLoad) {
        super(activity, nextStepHelper, onBeforeLoad, onAfterLoad);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nextStepHelper, "nextStepHelper");
        Intrinsics.checkNotNullParameter(onBeforeLoad, "onBeforeLoad");
        Intrinsics.checkNotNullParameter(onAfterLoad, "onAfterLoad");
    }

    private final List<Float> C(MetaMaterial material) {
        String m3 = WinkEditorResourceManager.a1().m(material);
        Intrinsics.checkNotNullExpressionValue(m3, "getInstance().getDownloadFolder(material)");
        LightAsset Load = LightAsset.Load(m3, 0);
        ArrayList arrayList = new ArrayList();
        LightEngine.initAuth(BaseApplication.context, "", "lightsdk_qq", WinkContext.Companion.j(WinkContext.INSTANCE, false, 1, null));
        ClipPlaceHolder[] templateMediaInfo = LightEngine.make(new VideoOutputConfig(30.0f, 0), new AudioOutputConfig(), new RendererConfig()).setAssetForMovie(Load).getClipPlaceHolders();
        Intrinsics.checkNotNullExpressionValue(templateMediaInfo, "templateMediaInfo");
        for (ClipPlaceHolder clipPlaceHolder : templateMediaInfo) {
            arrayList.add(Float.valueOf(((float) clipPlaceHolder.contentDuration) / ((float) 1000000)));
        }
        return arrayList;
    }

    private final ArrayList<TemplateLibraryHolderInfo> D(MetaMaterial metaMaterial, List<? extends LocalMediaInfo> selectedMedia) {
        LocalMediaInfo localMediaInfo;
        ArrayList<TemplateLibraryHolderInfo> arrayList = new ArrayList<>();
        List<Float> C = C(metaMaterial);
        int size = C.size() - 1;
        if (size >= 0) {
            int i3 = 0;
            while (true) {
                if (i3 < selectedMedia.size()) {
                    localMediaInfo = selectedMedia.get(i3);
                } else {
                    localMediaInfo = null;
                }
                arrayList.add(new TemplateLibraryHolderInfo(localMediaInfo, C.get(i3).floatValue(), ""));
                if (i3 == size) {
                    break;
                }
                i3++;
            }
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public List<LocalMediaInfo> p(@NotNull a data) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<b> m3 = data.m();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = m3.iterator();
        while (it.hasNext()) {
            LocalMediaInfo originPhoto = ((b) it.next()).getOriginPhoto();
            if (originPhoto != null) {
                arrayList.add(originPhoto);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @Nullable
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public TemplateLibraryData q(@NotNull a data, @NotNull MetaMaterial material) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(material, "material");
        if (data.d().getIsFixedSegmentsTemplate() == 1) {
            return new TemplateLibraryData(material, false, 0);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @NotNull
    public String i() {
        return super.i() + "_WinkMemoryAlbumClickDelegator";
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    public void r(@NotNull Context context, @Nullable String storyId, @NotNull List<String> templateIds, @Nullable String firstMediaPath, @NotNull List<? extends LocalMediaInfo> mediaInfoList, @Nullable String classifyId, int maxPicNum, @NotNull HashMap<String, String> attrs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateIds, "templateIds");
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public void f(@NotNull HashMap<String, String> hashMap, @NotNull a data, @Nullable MetaMaterial metaMaterial) {
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.d().getIsFixedSegmentsTemplate() == 1) {
            hashMap.put("libtemplate", data.d().getTemplateID());
            hashMap.put("tag", "#" + BaseApplication.context.getString(R.string.f240237om));
        } else if (data.d().getIsFixedSegmentsTemplate() == 0) {
            hashMap.put("tag", "#" + BaseApplication.context.getString(R.string.f240237om));
            hashMap.put("template", data.d().getTemplateID());
        }
        hashMap.put(QCircleScheme.AttrQQPublish.LIB_TEMPLATE_MEMORY_ID, data.getId());
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull Intent intent, @NotNull a data, @NotNull MetaMaterial material, @NotNull List<? extends LocalMediaInfo> selectedMedias) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(selectedMedias, "selectedMedias");
        if (data.d().getIsFixedSegmentsTemplate() == 1) {
            intent.putExtra(QQWinkConstants.PICK_TEMPLATE_MEDIA_MODEL, material);
            intent.putExtra(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
            intent.putExtra("template_holder_slot", D(material, selectedMedias));
        } else if (data.d().getIsFixedSegmentsTemplate() == 0) {
            intent.putExtra("lib_template_id", material.f30533id);
        }
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @Nullable
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Object k(@NotNull a aVar, @NotNull Continuation<? super MetaMaterial> continuation) {
        Continuation intercepted;
        Object coroutine_suspended;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(continuation);
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl.initCancellability();
        int isFixedSegmentsTemplate = aVar.d().getIsFixedSegmentsTemplate();
        if (isFixedSegmentsTemplate == 0) {
            BuildersKt__Builders_commonKt.launch$default(getMainScope(), null, null, new WinkMemoryAlbumClickDelegator$getMaterialInfo$2$1(aVar, cancellableContinuationImpl, null), 3, null);
        } else if (isFixedSegmentsTemplate != 1) {
            if (cancellableContinuationImpl.isActive()) {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(null));
            }
        } else {
            MetaMaterial P1 = WinkEditorResourceManager.a1().P1(aVar.d().getTemplateID());
            if (P1 == null) {
                ((IWinkEditorResourceAPI) QRoute.api(IWinkEditorResourceAPI.class)).fetchTemplateLibraryResource();
            }
            if (cancellableContinuationImpl.isActive()) {
                cancellableContinuationImpl.resumeWith(Result.m476constructorimpl(P1));
            }
        }
        Object result = cancellableContinuationImpl.getResult();
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (result == coroutine_suspended) {
            DebugProbes.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @Nullable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public Object l(@NotNull a aVar, @NotNull Continuation<? super List<MetaMaterial>> continuation) {
        return null;
    }
}
