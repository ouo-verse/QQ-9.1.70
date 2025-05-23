package com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.wink.api.IQQWinkLauncher;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.context.WinkContext;
import com.tencent.mobileqq.wink.edit.manager.WinkDataServiceHandler;
import com.tencent.mobileqq.wink.edit.manager.e;
import com.tencent.mobileqq.wink.edit.manager.h;
import com.tencent.mobileqq.wink.editor.extractor.ExtractCoverHelper;
import com.tencent.mobileqq.wink.newalbum.collector.WinkNewMemoryAlbumResult;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.VideoTemplateData;
import com.tencent.mobileqq.wink.picker.interceptor.WinkMediaPickerNextStepHelper;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbes;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z83.a;

/* compiled from: P */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 32\b\u0012\u0004\u0012\u00020\u00020\u0001:\u00014BL\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010(\u001a\u00020'\u0012\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\f0)\u0012#\b\u0002\u00100\u001a\u001d\u0012\u0013\u0012\u00110,\u00a2\u0006\f\b-\u0012\b\b.\u0012\u0004\b\b(/\u0012\u0004\u0012\u00020\f0+\u00a2\u0006\u0004\b1\u00102J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J:\u0010\r\u001a\u00020\f*\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\t2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016J*\u0010\u0010\u001a\u00020\f*\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0014J\u001d\u0010\u0014\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0004\b\u0016\u0010\u0015Jv\u0010!\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\b2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\b0\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001f\u001a\u00020\u001e2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`\tH\u0016R\u0014\u0010$\u001a\u00020\b8TX\u0094\u0004\u00a2\u0006\u0006\u001a\u0004\b\"\u0010#\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u00065"}, d2 = {"Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/adapter/click/WinkNewAlbumClickDelegator;", "Lcom/tencent/mobileqq/wink/templatelibrary/memoryalbum/adapter/click/BaseWinkAlbumClickDelegator;", "Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;", "data", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", WadlProxyConsts.KEY_MATERIAL, "", "w", "Landroid/content/Intent;", "selectedMedias", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/wink/picker/b;", "output", "u", "y", "(Lcom/tencent/mobileqq/wink/newalbum/collector/WinkNewMemoryAlbumResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", QQWinkConstants.STORY_ID, "templateIds", "firstMediaPath", "mediaInfoList", "classifyId", "", "maxPicNum", Node.ATTRS_ATTR, "r", "i", "()Ljava/lang/String;", "logTag", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;", "nextStepHelper", "Lkotlin/Function0;", "onBeforeLoad", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "onAfterLoad", "<init>", "(Landroid/app/Activity;Lcom/tencent/mobileqq/wink/picker/interceptor/WinkMediaPickerNextStepHelper;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "g", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class WinkNewAlbumClickDelegator extends BaseWinkAlbumClickDelegator<WinkNewMemoryAlbumResult> {

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/adapter/click/WinkNewAlbumClickDelegator$b", "Lcom/tencent/mobileqq/wink/edit/manager/h$c;", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", "recommendList", "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class b implements h.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<MetaMaterial> f326546b;

        /* JADX WARN: Multi-variable type inference failed */
        b(CancellableContinuation<? super MetaMaterial> cancellableContinuation) {
            this.f326546b = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void a() {
            QLog.e(WinkNewAlbumClickDelegator.this.i(), 1, "getMaterialInfo, onRecommendFailed ");
            if (this.f326546b.isActive()) {
                this.f326546b.resumeWith(Result.m476constructorimpl(null));
                h.d().n(this);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void b(@Nullable ArrayList<MetaMaterial> recommendList) {
            Integer num;
            ArrayList<MetaMaterial> arrayList;
            Object orNull;
            String i3 = WinkNewAlbumClickDelegator.this.i();
            MetaMaterial metaMaterial = null;
            if (recommendList != null) {
                num = Integer.valueOf(recommendList.size());
            } else {
                num = null;
            }
            QLog.d(i3, 1, "getMaterialInfo, onRecommendFinish, size:" + num);
            if (this.f326546b.isActive()) {
                CancellableContinuation<MetaMaterial> cancellableContinuation = this.f326546b;
                Result.Companion companion = Result.INSTANCE;
                MetaCategory e16 = h.d().e();
                if (e16 != null && (arrayList = e16.materials) != null) {
                    orNull = CollectionsKt___CollectionsKt.getOrNull(arrayList, 0);
                    metaMaterial = (MetaMaterial) orNull;
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(metaMaterial));
                h.d().n(this);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0007\u001a\u00020\u00062\u001a\u0010\u0005\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\u0004H\u0016J\b\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/wink/templatelibrary/memoryalbum/adapter/click/WinkNewAlbumClickDelegator$c", "Lcom/tencent/mobileqq/wink/edit/manager/h$c;", "Ljava/util/ArrayList;", "Lcamera/XEFFECT_MATERIALS_GENERAL_DATASTRUCT/MetaMaterial;", "Lkotlin/collections/ArrayList;", "recommendList", "", "b", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes21.dex */
    public static final class c implements h.c {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ CancellableContinuation<List<MetaMaterial>> f326548b;

        /* JADX WARN: Multi-variable type inference failed */
        c(CancellableContinuation<? super List<MetaMaterial>> cancellableContinuation) {
            this.f326548b = cancellableContinuation;
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void a() {
            QLog.e(WinkNewAlbumClickDelegator.this.i(), 1, "getMaterialInfoList, onRecommendFailed ");
            if (this.f326548b.isActive()) {
                this.f326548b.resumeWith(Result.m476constructorimpl(null));
                h.d().n(this);
            }
        }

        @Override // com.tencent.mobileqq.wink.edit.manager.h.c
        public void b(@Nullable ArrayList<MetaMaterial> recommendList) {
            Integer num;
            String i3 = WinkNewAlbumClickDelegator.this.i();
            ArrayList<MetaMaterial> arrayList = null;
            if (recommendList != null) {
                num = Integer.valueOf(recommendList.size());
            } else {
                num = null;
            }
            QLog.d(i3, 1, "getMaterialInfoList, onRecommendFinish, size:" + num);
            if (this.f326548b.isActive()) {
                CancellableContinuation<List<MetaMaterial>> cancellableContinuation = this.f326548b;
                Result.Companion companion = Result.INSTANCE;
                MetaCategory e16 = h.d().e();
                if (e16 != null) {
                    arrayList = e16.materials;
                }
                cancellableContinuation.resumeWith(Result.m476constructorimpl(arrayList));
                h.d().n(this);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WinkNewAlbumClickDelegator(@NotNull Activity activity, @NotNull WinkMediaPickerNextStepHelper nextStepHelper, @NotNull Function0<Unit> onBeforeLoad, @NotNull Function1<? super Boolean, Unit> onAfterLoad) {
        super(activity, nextStepHelper, onBeforeLoad, onAfterLoad);
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(nextStepHelper, "nextStepHelper");
        Intrinsics.checkNotNullParameter(onBeforeLoad, "onBeforeLoad");
        Intrinsics.checkNotNullParameter(onAfterLoad, "onAfterLoad");
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public List<LocalMediaInfo> p(@NotNull WinkNewMemoryAlbumResult data) {
        Intrinsics.checkNotNullParameter(data, "data");
        List<a> i3 = data.i();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = i3.iterator();
        while (it.hasNext()) {
            LocalMediaInfo originPhoto = ((a) it.next()).getOriginPhoto();
            if (originPhoto != null) {
                arrayList.add(originPhoto);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @NotNull
    public String i() {
        return super.i() + "_WinkNewAlbumClickDelegator";
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    public void r(@NotNull Context context, @Nullable String storyId, @NotNull List<String> templateIds, @Nullable String firstMediaPath, @NotNull List<? extends LocalMediaInfo> mediaInfoList, @Nullable String classifyId, int maxPicNum, @NotNull HashMap<String, String> attrs) {
        boolean z16;
        Activity activity;
        Intent intent;
        String stringExtra;
        boolean z17;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(templateIds, "templateIds");
        Intrinsics.checkNotNullParameter(mediaInfoList, "mediaInfoList");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        if (firstMediaPath != null && firstMediaPath.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            QLog.e("WinkNewAlbumClickDelegator", 1, "[launchNewAlbumPreviewPage] first media path is null or empty");
            return;
        }
        List<? extends LocalMediaInfo> arrayList = new ArrayList<>();
        for (Object obj : mediaInfoList) {
            String str = ((LocalMediaInfo) obj).path;
            if (str != null && str.length() != 0) {
                z17 = false;
            } else {
                z17 = true;
            }
            if (!z17) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            QLog.e("WinkNewAlbumClickDelegator", 1, "[launchNewAlbumPreviewPage] filterMediaInfoList is empty");
            return;
        }
        if (arrayList.size() > maxPicNum) {
            arrayList = arrayList.subList(0, maxPicNum);
        }
        Bundle bundle = new Bundle();
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (intent = activity.getIntent()) != null && (stringExtra = intent.getStringExtra("QQWinkDataKeys-tag_name")) != null) {
            bundle.putString("QQWinkDataKeys-tag_name", stringExtra);
        }
        bundle.putString(QQWinkConstants.ENTRY_BUSINESS_NAME, "QCIRCLE");
        bundle.putString("app_key", "00000QG6YX3X0LZH");
        bundle.putString(QQWinkConstants.COVER_PATH, firstMediaPath);
        bundle.putSerializable(QQWinkConstants.MEDIA_PICKER_SCENE, MediaPickerScene.TEMPLATE_LIBRARY_MEMORY_ALBUM);
        bundle.putSerializable("key_attrs", attrs);
        bundle.putStringArrayList("templateId", bg.f302144a.n(templateIds));
        if (storyId != null) {
            bundle.putString(QQWinkConstants.STORY_ID, storyId);
        }
        bundle.putString(PeakConstants.QCIRCLE_CLIENT_TRACEID, WinkContext.INSTANCE.d().getTraceId());
        ((IQQWinkLauncher) QRoute.api(IQQWinkLauncher.class)).jumpToWinkNewAlbumPreview(context, bundle, arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @NotNull
    public MediaPickerOutput u(@NotNull MediaPickerOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        return MediaPickerOutput.b(super.u(output), null, null, new VideoTemplateData(true, true, null, 4, null), null, null, null, 59, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0048  */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(@NotNull HashMap<String, String> hashMap, @NotNull WinkNewMemoryAlbumResult data, @Nullable MetaMaterial metaMaterial) {
        Map<? extends String, ? extends String> map;
        boolean z16;
        String str;
        boolean isBlank;
        Intrinsics.checkNotNullParameter(hashMap, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Serializable serializableExtra = getCom.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY java.lang.String().getIntent().getSerializableExtra("key_attrs");
        if (serializableExtra instanceof Map) {
            map = (Map) serializableExtra;
        } else {
            map = null;
        }
        if (map == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        hashMap.putAll(map);
        String str2 = map.get("tag");
        if (str2 != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str2);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    str = data.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String();
                } else {
                    str = data.getCom.tencent.aelight.camera.constants.AEEditorConstants.ALBUMNAME java.lang.String() + "#" + str2;
                }
                hashMap.put("tag", str);
                hashMap.put(QCircleScheme.AttrQQPublish.LIB_TEMPLATE_MEMORY_ID, data.getStoryID() + data.getAlbumID());
            }
        }
        z16 = true;
        if (!z16) {
        }
        hashMap.put("tag", str);
        hashMap.put(QCircleScheme.AttrQQPublish.LIB_TEMPLATE_MEMORY_ID, data.getStoryID() + data.getAlbumID());
    }

    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void g(@NotNull Intent intent, @NotNull WinkNewMemoryAlbumResult data, @NotNull MetaMaterial material, @NotNull List<? extends LocalMediaInfo> selectedMedias) {
        Intrinsics.checkNotNullParameter(intent, "<this>");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(material, "material");
        Intrinsics.checkNotNullParameter(selectedMedias, "selectedMedias");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00aa A[PHI: r9
  0x00aa: PHI (r9v7 java.lang.Object) = (r9v6 java.lang.Object), (r9v1 java.lang.Object) binds: [B:22:0x00a7, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @Nullable
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object k(@NotNull WinkNewMemoryAlbumResult winkNewMemoryAlbumResult, @NotNull Continuation<? super MetaMaterial> continuation) {
        WinkNewAlbumClickDelegator$getMaterialInfo$1 winkNewAlbumClickDelegator$getMaterialInfo$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        List<LocalMediaInfo> p16;
        WinkNewAlbumClickDelegator winkNewAlbumClickDelegator;
        Continuation intercepted;
        WinkDataServiceHandler a16;
        Object coroutine_suspended2;
        if (continuation instanceof WinkNewAlbumClickDelegator$getMaterialInfo$1) {
            winkNewAlbumClickDelegator$getMaterialInfo$1 = (WinkNewAlbumClickDelegator$getMaterialInfo$1) continuation;
            int i16 = winkNewAlbumClickDelegator$getMaterialInfo$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkNewAlbumClickDelegator$getMaterialInfo$1.label = i16 - Integer.MIN_VALUE;
                obj = winkNewAlbumClickDelegator$getMaterialInfo$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkNewAlbumClickDelegator$getMaterialInfo$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p16 = (List) winkNewAlbumClickDelegator$getMaterialInfo$1.L$1;
                    winkNewAlbumClickDelegator = (WinkNewAlbumClickDelegator) winkNewAlbumClickDelegator$getMaterialInfo$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    p16 = p(winkNewMemoryAlbumResult);
                    ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
                    winkNewAlbumClickDelegator$getMaterialInfo$1.L$0 = this;
                    winkNewAlbumClickDelegator$getMaterialInfo$1.L$1 = p16;
                    winkNewAlbumClickDelegator$getMaterialInfo$1.label = 1;
                    obj = extractCoverHelper.C(p16, winkNewAlbumClickDelegator$getMaterialInfo$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkNewAlbumClickDelegator = this;
                }
                ArrayList arrayList = (ArrayList) obj;
                winkNewAlbumClickDelegator$getMaterialInfo$1.L$0 = winkNewAlbumClickDelegator;
                winkNewAlbumClickDelegator$getMaterialInfo$1.L$1 = p16;
                winkNewAlbumClickDelegator$getMaterialInfo$1.L$2 = arrayList;
                winkNewAlbumClickDelegator$getMaterialInfo$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkNewAlbumClickDelegator$getMaterialInfo$1);
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                final b bVar = new b(cancellableContinuationImpl);
                h.d().a(bVar);
                a16 = e.a();
                if (a16 != null) {
                    a16.o3(p16, arrayList, 2);
                    a16.p3(arrayList, 2);
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.WinkNewAlbumClickDelegator$getMaterialInfo$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th5) {
                        h.d().n(h.c.this);
                    }
                });
                obj = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(winkNewAlbumClickDelegator$getMaterialInfo$1);
                }
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        winkNewAlbumClickDelegator$getMaterialInfo$1 = new WinkNewAlbumClickDelegator$getMaterialInfo$1(this, continuation);
        obj = winkNewAlbumClickDelegator$getMaterialInfo$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkNewAlbumClickDelegator$getMaterialInfo$1.label;
        if (i3 == 0) {
        }
        ArrayList arrayList2 = (ArrayList) obj;
        winkNewAlbumClickDelegator$getMaterialInfo$1.L$0 = winkNewAlbumClickDelegator;
        winkNewAlbumClickDelegator$getMaterialInfo$1.L$1 = p16;
        winkNewAlbumClickDelegator$getMaterialInfo$1.L$2 = arrayList2;
        winkNewAlbumClickDelegator$getMaterialInfo$1.label = 2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkNewAlbumClickDelegator$getMaterialInfo$1);
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl2.initCancellability();
        final h.c bVar2 = new b(cancellableContinuationImpl2);
        h.d().a(bVar2);
        a16 = e.a();
        if (a16 != null) {
        }
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.WinkNewAlbumClickDelegator$getMaterialInfo$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                h.d().n(h.c.this);
            }
        });
        obj = cancellableContinuationImpl2.getResult();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended2) {
        }
        if (obj != coroutine_suspended) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x00aa A[PHI: r9
  0x00aa: PHI (r9v7 java.lang.Object) = (r9v6 java.lang.Object), (r9v1 java.lang.Object) binds: [B:22:0x00a7, B:10:0x0028] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    @Override // com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.BaseWinkAlbumClickDelegator
    @Nullable
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object l(@NotNull WinkNewMemoryAlbumResult winkNewMemoryAlbumResult, @NotNull Continuation<? super List<MetaMaterial>> continuation) {
        WinkNewAlbumClickDelegator$getMaterialInfoList$1 winkNewAlbumClickDelegator$getMaterialInfoList$1;
        Object obj;
        Object coroutine_suspended;
        int i3;
        List<LocalMediaInfo> p16;
        WinkNewAlbumClickDelegator winkNewAlbumClickDelegator;
        Continuation intercepted;
        WinkDataServiceHandler a16;
        Object coroutine_suspended2;
        if (continuation instanceof WinkNewAlbumClickDelegator$getMaterialInfoList$1) {
            winkNewAlbumClickDelegator$getMaterialInfoList$1 = (WinkNewAlbumClickDelegator$getMaterialInfoList$1) continuation;
            int i16 = winkNewAlbumClickDelegator$getMaterialInfoList$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                winkNewAlbumClickDelegator$getMaterialInfoList$1.label = i16 - Integer.MIN_VALUE;
                obj = winkNewAlbumClickDelegator$getMaterialInfoList$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = winkNewAlbumClickDelegator$getMaterialInfoList$1.label;
                if (i3 == 0) {
                    if (i3 != 1) {
                        if (i3 == 2) {
                            ResultKt.throwOnFailure(obj);
                            return obj;
                        }
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    p16 = (List) winkNewAlbumClickDelegator$getMaterialInfoList$1.L$1;
                    winkNewAlbumClickDelegator = (WinkNewAlbumClickDelegator) winkNewAlbumClickDelegator$getMaterialInfoList$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    ResultKt.throwOnFailure(obj);
                    p16 = p(winkNewMemoryAlbumResult);
                    ExtractCoverHelper extractCoverHelper = ExtractCoverHelper.f320276a;
                    winkNewAlbumClickDelegator$getMaterialInfoList$1.L$0 = this;
                    winkNewAlbumClickDelegator$getMaterialInfoList$1.L$1 = p16;
                    winkNewAlbumClickDelegator$getMaterialInfoList$1.label = 1;
                    obj = extractCoverHelper.C(p16, winkNewAlbumClickDelegator$getMaterialInfoList$1);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    winkNewAlbumClickDelegator = this;
                }
                ArrayList arrayList = (ArrayList) obj;
                winkNewAlbumClickDelegator$getMaterialInfoList$1.L$0 = winkNewAlbumClickDelegator;
                winkNewAlbumClickDelegator$getMaterialInfoList$1.L$1 = p16;
                winkNewAlbumClickDelegator$getMaterialInfoList$1.L$2 = arrayList;
                winkNewAlbumClickDelegator$getMaterialInfoList$1.label = 2;
                intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkNewAlbumClickDelegator$getMaterialInfoList$1);
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(intercepted, 1);
                cancellableContinuationImpl.initCancellability();
                final c cVar = new c(cancellableContinuationImpl);
                h.d().a(cVar);
                a16 = e.a();
                if (a16 != null) {
                    a16.o3(p16, arrayList, 2);
                    a16.p3(arrayList, 2);
                }
                cancellableContinuationImpl.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.WinkNewAlbumClickDelegator$getMaterialInfoList$2$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                        invoke2(th5);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@Nullable Throwable th5) {
                        h.d().n(h.c.this);
                    }
                });
                obj = cancellableContinuationImpl.getResult();
                coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (obj == coroutine_suspended2) {
                    DebugProbes.probeCoroutineSuspended(winkNewAlbumClickDelegator$getMaterialInfoList$1);
                }
                if (obj != coroutine_suspended) {
                    return coroutine_suspended;
                }
                return obj;
            }
        }
        winkNewAlbumClickDelegator$getMaterialInfoList$1 = new WinkNewAlbumClickDelegator$getMaterialInfoList$1(this, continuation);
        obj = winkNewAlbumClickDelegator$getMaterialInfoList$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = winkNewAlbumClickDelegator$getMaterialInfoList$1.label;
        if (i3 == 0) {
        }
        ArrayList arrayList2 = (ArrayList) obj;
        winkNewAlbumClickDelegator$getMaterialInfoList$1.L$0 = winkNewAlbumClickDelegator;
        winkNewAlbumClickDelegator$getMaterialInfoList$1.L$1 = p16;
        winkNewAlbumClickDelegator$getMaterialInfoList$1.L$2 = arrayList2;
        winkNewAlbumClickDelegator$getMaterialInfoList$1.label = 2;
        intercepted = IntrinsicsKt__IntrinsicsJvmKt.intercepted(winkNewAlbumClickDelegator$getMaterialInfoList$1);
        CancellableContinuationImpl cancellableContinuationImpl2 = new CancellableContinuationImpl(intercepted, 1);
        cancellableContinuationImpl2.initCancellability();
        final h.c cVar2 = new c(cancellableContinuationImpl2);
        h.d().a(cVar2);
        a16 = e.a();
        if (a16 != null) {
        }
        cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.tencent.mobileqq.wink.templatelibrary.memoryalbum.adapter.click.WinkNewAlbumClickDelegator$getMaterialInfoList$2$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Throwable th5) {
                invoke2(th5);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable Throwable th5) {
                h.d().n(h.c.this);
            }
        });
        obj = cancellableContinuationImpl2.getResult();
        coroutine_suspended2 = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (obj == coroutine_suspended2) {
        }
        if (obj != coroutine_suspended) {
        }
    }
}
