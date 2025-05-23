package com.tencent.mobileqq.wink.picker.interceptor;

import android.os.SystemClock;
import androidx.core.util.Consumer;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.edit.util.AbortableCountDownLatch;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.picker.utils.FullSpaceArExtKt;
import com.tencent.mobileqq.wink.utils.an;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import cooperation.photoplus.sticker.Sticker;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u001f2\u00020\u0001:\u0001\u000fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\fH\u0016J\"\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0013\u001a\u00020\u0002H\u0014J\"\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00150\u00172\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00150\u0014H\u0014R\u001a\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/i;", "Lcom/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor;", "", BdhLogUtil.LogTag.Tag_Req, "", "isSuccess", "", "data", "T", ExifInterface.LATITUDE_SOUTH, "", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "", "type", "onUpdate", "P", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", "", ReportConstant.COSTREPORT_PREFIX, "Ljava/util/concurrent/CopyOnWriteArrayList;", "M", "Ljava/util/concurrent/CopyOnWriteArrayList;", "exportTasks", "<init>", "()V", "N", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class i extends TemplateLibBaseMediaInterceptor {

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final CopyOnWriteArrayList<String> exportTasks = new CopyOnWriteArrayList<>();

    private final void R() {
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        Object orNull;
        if (getChain() != null && getTemplatePreProcessConfig() != null) {
            m().clear();
            TemplatePreProcessConfig templatePreProcessConfig = getTemplatePreProcessConfig();
            Intrinsics.checkNotNull(templatePreProcessConfig);
            List<TemplatePreProcessConfig.Media> medias = templatePreProcessConfig.getMedias();
            if (medias != null) {
                int i3 = 0;
                for (Object obj : medias) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    c.a chain = getChain();
                    Intrinsics.checkNotNull(chain);
                    orNull = CollectionsKt___CollectionsKt.getOrNull(chain.e(), i3);
                    j((LocalMediaInfo) orNull, (TemplatePreProcessConfig.Media) obj);
                    i3 = i16;
                }
            }
            c.a chain2 = getChain();
            if (chain2 != null && (b16 = chain2.b()) != null) {
                b16.m(0.4f);
            }
        }
    }

    private final void S(boolean isSuccess, Object data) {
        int collectionSizeOrDefault;
        boolean z16;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        c.a chain = getChain();
        if (chain != null && (b16 = chain.b()) != null) {
            b16.m(0.9f);
        }
        if (!e()) {
            return;
        }
        if (!isSuccess) {
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.tencent.mobileqq.wink.edit.util.AbortableCountDownLatch.AbortedException");
            AbortableCountDownLatch.AbortedException abortedException = (AbortableCountDownLatch.AbortedException) data;
            String message = abortedException.getMessage();
            if (message != null && message.length() != 0) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_PROCESS_IMAGES_FAILED, null, 2, null));
                return;
            } else {
                F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_DETAIL_ERROR_MSG, abortedException.getMessage()));
                return;
            }
        }
        Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.wink.edit.bean.TemplateLibMediaProcessedBean>");
        List list = (List) data;
        w53.b.f("TemplateLibMediaInterceptor", "handleProcessImage " + list.size());
        List list2 = list;
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            I(((com.tencent.mobileqq.wink.edit.bean.a) it.next()).c());
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : list2) {
            if (Intrinsics.areEqual(((com.tencent.mobileqq.wink.edit.bean.a) obj).busiID, QQWinkConstants.INSPIRATION_WIREFRAME_AR_BUSI_ID)) {
                arrayList.add(obj);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
        ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
        Iterator it5 = arrayList.iterator();
        while (it5.hasNext()) {
            arrayList2.add(FullSpaceArExtKt.a((com.tencent.mobileqq.wink.edit.bean.a) it5.next(), an.f326680a.f(SystemClock.elapsedRealtime() + Sticker.JSON_SUFFIX)));
        }
        Pair<String, JSONArray> b17 = FullSpaceArExtKt.b(arrayList2);
        if (b17 != null) {
            z().put(b17.getFirst(), b17.getSecond());
        }
        Map<String, Object> z17 = z();
        JSONArray Z0 = WinkEditorResourceManager.a1().Z0();
        Intrinsics.checkNotNullExpressionValue(Z0, "getInstance().inspirationAIData");
        z17.put("InspirationAIData", Z0);
        CountDownLatch syncLatch = getSyncLatch();
        if (syncLatch != null) {
            syncLatch.countDown();
        }
    }

    private final void T(boolean isSuccess, Object data) {
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        c.a chain = getChain();
        if (chain != null && (b16 = chain.b()) != null) {
            b16.m(0.8f);
        }
        if (!e()) {
            return;
        }
        if (isSuccess && getTemplatePreProcessConfig() != null) {
            w53.b.f("TemplateLibMediaInterceptor", "handleUploadOriginImage success");
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            Map<String, String> map = (Map) data;
            t().clear();
            WinkEditorResourceManager.a1().r3();
            TemplatePreProcessConfig templatePreProcessConfig = getTemplatePreProcessConfig();
            Intrinsics.checkNotNull(templatePreProcessConfig);
            List<TemplatePreProcessConfig.Media> medias = templatePreProcessConfig.getMedias();
            Intrinsics.checkNotNullExpressionValue(medias, "templatePreProcessConfig!!.medias");
            int i3 = 0;
            for (Object obj : medias) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) obj;
                Intrinsics.checkNotNullExpressionValue(media, "media");
                c.a chain2 = getChain();
                Intrinsics.checkNotNull(chain2);
                d(media, chain2.e().get(i3), map);
                i3 = i16;
            }
            if (!t().isEmpty()) {
                x().R3(t(), 5, new Consumer() { // from class: com.tencent.mobileqq.wink.picker.interceptor.h
                    @Override // androidx.core.util.Consumer
                    public final void accept(Object obj2) {
                        i.U(i.this, (Float) obj2);
                    }
                });
                return;
            }
            CountDownLatch syncLatch = getSyncLatch();
            if (syncLatch != null) {
                syncLatch.countDown();
                return;
            }
            return;
        }
        F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_UPLOAD_IMAGES_FAILED, null, 2, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void U(i this$0, Float it) {
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c.a chain = this$0.getChain();
        if (chain != null && (b16 = chain.b()) != null) {
            Intrinsics.checkNotNullExpressionValue(it, "it");
            b16.i0(it.floatValue());
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor
    protected void P() {
        c.a chain;
        List<TemplatePreProcessConfig.Media> medias;
        if (e() && (chain = getChain()) != null) {
            r().clear();
            TemplatePreProcessConfig templatePreProcessConfig = getTemplatePreProcessConfig();
            if (templatePreProcessConfig != null && (medias = templatePreProcessConfig.getMedias()) != null) {
                Intrinsics.checkNotNullExpressionValue(medias, "medias");
                int i3 = 0;
                for (Object obj : medias) {
                    int i16 = i3 + 1;
                    if (i3 < 0) {
                        CollectionsKt__CollectionsKt.throwIndexOverflow();
                    }
                    TemplatePreProcessConfig.Media media = (TemplatePreProcessConfig.Media) obj;
                    LocalMediaInfo localMediaInfo = chain.e().get(i3);
                    Intrinsics.checkNotNullExpressionValue(media, "media");
                    c(localMediaInfo, media);
                    i3 = i16;
                }
            }
            if (r().isEmpty()) {
                CountDownLatch syncLatch = getSyncLatch();
                if (syncLatch != null) {
                    syncLatch.countDown();
                    return;
                }
                return;
            }
            x().S3(r());
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public MediaPickerOutput a(@NotNull c.a chain) {
        int i3;
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (chain.a() == MediaPickerScene.TEMPLATE_LIBRARY && chain.getMediaPickerInput().getTemplateLibraryData() != null) {
            K(chain);
            E(chain.getMediaPickerInput().getTemplateLibraryData());
            TemplatePreProcessConfig templatePreProcessConfig = getTemplatePreProcessConfig();
            com.tencent.mobileqq.wink.b.a().addDefaultObservers(this);
            chain.b().y0(chain.e().size());
            Long l3 = null;
            L(null);
            x().v3();
            if (templatePreProcessConfig == null) {
                M(false);
                N(new CountDownLatch(1));
                J(x().D3().getFirst());
            } else {
                M(templatePreProcessConfig.isNeedUserInfo());
                if (templatePreProcessConfig.isNeedUserInfo()) {
                    i3 = 3;
                } else {
                    i3 = 2;
                }
                N(new CountDownLatch(i3));
                J(x().D3().getFirst());
                R();
                if (G(chain.getMediaPickerInput())) {
                    f();
                } else {
                    P();
                }
            }
            CountDownLatch syncLatch = getSyncLatch();
            if (syncLatch != null) {
                l3 = Long.valueOf(syncLatch.getCount());
            }
            w53.b.f("TemplateLibMediaInterceptor", "[syncLatch count] " + l3);
            CountDownLatch syncLatch2 = getSyncLatch();
            if (syncLatch2 != null) {
                syncLatch2.await();
            }
            h();
            chain.b().m(1.0f);
            w53.b.f("TemplateLibMediaInterceptor", "removeObserver");
            com.tencent.mobileqq.wink.b.a().removeObserver(this);
            InterceptException interceptException = getInterceptException();
            if (interceptException == null) {
                return chain.f(MediaPickerInput.b(chain.getMediaPickerInput(), null, null, null, null, B(chain, z()), null, u(chain.getMediaPickerInput().j()), null, null, null, 943, null));
            }
            throw interceptException;
        }
        return chain.f(chain.getMediaPickerInput());
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    public String name() {
        return "TemplateLibMediaInterceptor";
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        if (type != 3) {
            if (type != 4) {
                if (type != 5) {
                    if (type == 7) {
                        D(isSuccess, data);
                        return;
                    }
                    return;
                }
                S(isSuccess, data);
                return;
            }
            T(isSuccess, data);
            return;
        }
        C(isSuccess);
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor
    @NotNull
    protected Map<String, LocalMediaInfo> s(@NotNull List<? extends LocalMediaInfo> selectedMedia) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map<String, LocalMediaInfo> mutableMap;
        List<TemplatePreProcessConfig.Media> medias;
        boolean z16;
        Intrinsics.checkNotNullParameter(selectedMedia, "selectedMedia");
        List<? extends LocalMediaInfo> list = selectedMedia;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        mapCapacity = MapsKt__MapsJVMKt.mapCapacity(collectionSizeOrDefault);
        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mapCapacity, 16);
        LinkedHashMap linkedHashMap = new LinkedHashMap(coerceAtLeast);
        for (Object obj : list) {
            linkedHashMap.put(((LocalMediaInfo) obj).path, obj);
        }
        mutableMap = MapsKt__MapsKt.toMutableMap(linkedHashMap);
        TemplatePreProcessConfig templatePreProcessConfig = getTemplatePreProcessConfig();
        if (templatePreProcessConfig != null && (medias = templatePreProcessConfig.getMedias()) != null) {
            int i3 = 0;
            for (Object obj2 : medias) {
                int i16 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt__CollectionsKt.throwIndexOverflow();
                }
                List<TemplatePreProcessConfig.Media.Preprocess> preprocess = ((TemplatePreProcessConfig.Media) obj2).getPreprocess();
                if (preprocess != null) {
                    Intrinsics.checkNotNullExpressionValue(preprocess, "preprocess");
                    for (TemplatePreProcessConfig.Media.Preprocess preprocess2 : preprocess) {
                        List<Integer> multipleIndexes = preprocess2.getMultipleIndexes();
                        if (multipleIndexes != null && !multipleIndexes.isEmpty()) {
                            z16 = false;
                        } else {
                            z16 = true;
                        }
                        if (z16) {
                            TemplateLibBaseMediaInterceptor.ReplaceLayerMediaInfo replaceLayerMediaInfo = v().get(Integer.valueOf(preprocess2.getIndex()));
                            if (replaceLayerMediaInfo != null) {
                                mutableMap.put(replaceLayerMediaInfo.getOriginPath(), selectedMedia.get(i3));
                            }
                        } else {
                            List<Integer> multipleIndexes2 = preprocess2.getMultipleIndexes();
                            Intrinsics.checkNotNullExpressionValue(multipleIndexes2, "preprocess.multipleIndexes");
                            Iterator<T> it = multipleIndexes2.iterator();
                            while (it.hasNext()) {
                                TemplateLibBaseMediaInterceptor.ReplaceLayerMediaInfo replaceLayerMediaInfo2 = v().get((Integer) it.next());
                                if (replaceLayerMediaInfo2 != null) {
                                    mutableMap.put(replaceLayerMediaInfo2.getOriginPath(), selectedMedia.get(i3));
                                }
                            }
                        }
                    }
                }
                i3 = i16;
            }
        }
        return mutableMap;
    }
}
