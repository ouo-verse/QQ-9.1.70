package com.tencent.mobileqq.wink.picker.interceptor;

import android.os.SystemClock;
import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.edit.manager.WinkEditorResourceManager;
import com.tencent.mobileqq.wink.editor.model.template.TemplatePreProcessConfig;
import com.tencent.mobileqq.wink.picker.MediaPickerInput;
import com.tencent.mobileqq.wink.picker.MediaPickerOutput;
import com.tencent.mobileqq.wink.picker.MediaPickerScene;
import com.tencent.mobileqq.wink.picker.TemplateLibraryData;
import com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor;
import com.tencent.mobileqq.wink.picker.interceptor.c;
import com.tencent.mobileqq.wink.picker.utils.FullSpaceArExtKt;
import com.tencent.mobileqq.wink.utils.an;
import com.tencent.mobileqq.winkpublish.report.MediaPickerErrorCode;
import cooperation.photoplus.sticker.Sticker;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00152\u00020\u0001:\u0001\u0012B\u0007\u00a2\u0006\u0004\b!\u0010\"J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u001a\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u001c\u0010\r\u001a\u00020\u00022\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nH\u0002J\b\u0010\u000e\u001a\u00020\fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\"\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0002H\u0014J\"\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00170\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0014R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/mobileqq/wink/picker/interceptor/j;", "Lcom/tencent/mobileqq/wink/picker/interceptor/TemplateLibBaseMediaInterceptor;", "", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "", "isSuccess", "", "data", ExifInterface.LATITUDE_SOUTH, BdhLogUtil.LogTag.Tag_Req, "", "", "", "T", "name", "Lcom/tencent/mobileqq/wink/picker/interceptor/c$a;", "chain", "Lcom/tencent/mobileqq/wink/picker/b;", "a", "type", "onUpdate", "P", "", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "selectedMedia", ReportConstant.COSTREPORT_PREFIX, "M", "Ljava/lang/Integer;", "renderMediaIndex", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig$Media;", "N", "Lcom/tencent/mobileqq/wink/editor/model/template/TemplatePreProcessConfig$Media;", "mediaPreprocessConfig", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes21.dex */
public final class j extends TemplateLibBaseMediaInterceptor {

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private Integer renderMediaIndex;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TemplatePreProcessConfig.Media mediaPreprocessConfig;

    private final void Q() {
        Object firstOrNull;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        if (getChain() != null && getTemplatePreProcessConfig() != null && this.mediaPreprocessConfig != null && this.renderMediaIndex != null) {
            c.a chain = getChain();
            Intrinsics.checkNotNull(chain);
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) chain.e());
            j((LocalMediaInfo) firstOrNull, this.mediaPreprocessConfig);
            c.a chain2 = getChain();
            if (chain2 != null && (b16 = chain2.b()) != null) {
                b16.m(0.2f);
            }
        }
    }

    private final void R(boolean isSuccess, Object data) {
        Map<? extends String, ? extends Object> map;
        Object obj;
        String str;
        MediaPickerInput mediaPickerInput;
        TemplateLibraryData templateLibraryData;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        c.a chain = getChain();
        if (chain != null && (b16 = chain.b()) != null) {
            b16.m(0.9f);
        }
        if (!e()) {
            return;
        }
        if (isSuccess && (data instanceof List)) {
            w53.b.f("TemplateLibReplaceMediaInterceptor", "handleReplaceImage success");
            List list = (List) data;
            Iterator it = list.iterator();
            while (true) {
                map = null;
                str = null;
                str = null;
                str = null;
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((com.tencent.mobileqq.wink.edit.bean.a) obj).busiID, QQWinkConstants.INSPIRATION_WIREFRAME_AR_BUSI_ID)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            com.tencent.mobileqq.wink.edit.bean.a aVar = (com.tencent.mobileqq.wink.edit.bean.a) obj;
            if (aVar != null) {
                c.a chain2 = getChain();
                if (chain2 != null && (mediaPickerInput = chain2.getMediaPickerInput()) != null && (templateLibraryData = mediaPickerInput.getTemplateLibraryData()) != null) {
                    str = templateLibraryData.getOriginalScriptParams();
                }
                map = FullSpaceArExtKt.c(aVar, str, an.f326680a.f(SystemClock.elapsedRealtime() + Sticker.JSON_SUFFIX));
            }
            if (map != null) {
                z().putAll(map);
            }
            HashMap hashMap = new HashMap();
            Iterator it5 = list.iterator();
            while (it5.hasNext()) {
                hashMap.putAll(((com.tencent.mobileqq.wink.edit.bean.a) it5.next()).c());
            }
            T(hashMap);
            return;
        }
        F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_REPLACE_MEDIA_FAILED, null, 2, null));
    }

    private final void S(boolean isSuccess, Object data) {
        Object first;
        Map<Integer, String> mutableMapOf;
        com.tencent.mobileqq.wink.picker.core.viewmodel.b b16;
        c.a chain = getChain();
        if (chain != null && (b16 = chain.b()) != null) {
            b16.m(0.8f);
        }
        if (!e()) {
            return;
        }
        if (isSuccess && getTemplatePreProcessConfig() != null && this.mediaPreprocessConfig != null) {
            w53.b.f("TemplateLibReplaceMediaInterceptor", "handleUploadOriginImage success");
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
            t().clear();
            WinkEditorResourceManager.a1().r3();
            c.a chain2 = getChain();
            Intrinsics.checkNotNull(chain2);
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) chain2.e());
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) first;
            TemplatePreProcessConfig.Media media = this.mediaPreprocessConfig;
            Intrinsics.checkNotNull(media);
            d(media, localMediaInfo, (Map) data);
            if (t().isEmpty()) {
                Integer num = this.renderMediaIndex;
                Intrinsics.checkNotNull(num);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(num, localMediaInfo.path));
                T(mutableMapOf);
                return;
            }
            x().Q3(t(), 6);
            return;
        }
        F(new MediaPickerErrorCode(MediaPickerErrorCode.ERROR_CODE_TEMPLATE_LIB_UPLOAD_IMAGES_FAILED, null, 2, null));
    }

    private final void T(Map<Integer, String> data) {
        I(data);
        CountDownLatch syncLatch = getSyncLatch();
        if (syncLatch != null) {
            syncLatch.countDown();
        }
    }

    @Override // com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor
    protected void P() {
        Object first;
        Map<Integer, String> mutableMapOf;
        if (!e()) {
            return;
        }
        c.a chain = getChain();
        TemplatePreProcessConfig.Media media = this.mediaPreprocessConfig;
        if (chain != null && media != null) {
            r().clear();
            first = CollectionsKt___CollectionsKt.first((List<? extends Object>) chain.e());
            LocalMediaInfo localMediaInfo = (LocalMediaInfo) first;
            c(localMediaInfo, media);
            if (r().isEmpty()) {
                Integer num = this.renderMediaIndex;
                Intrinsics.checkNotNull(num);
                mutableMapOf = MapsKt__MapsKt.mutableMapOf(TuplesKt.to(num, localMediaInfo.path));
                T(mutableMapOf);
                return;
            }
            x().S3(r());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00df A[EDGE_INSN: B:27:0x00df->B:28:0x00df BREAK  A[LOOP:0: B:18:0x0072->B:41:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[LOOP:0: B:18:0x0072->B:41:?, LOOP_END, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d8  */
    @Override // com.tencent.mobileqq.wink.picker.interceptor.c
    @NotNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public MediaPickerOutput a(@NotNull c.a chain) {
        int i3;
        TemplatePreProcessConfig.Media media;
        List<TemplatePreProcessConfig.Media> medias;
        Object obj;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (chain.a() == MediaPickerScene.TEMPLATE_LIBRARY_REPLACE && chain.getMediaPickerInput().getTemplateLibraryData() != null) {
            TemplateLibraryData templateLibraryData = chain.getMediaPickerInput().getTemplateLibraryData();
            if (templateLibraryData != null) {
                i3 = Integer.valueOf(templateLibraryData.getToReplacedMediaIndex());
            } else {
                i3 = 0;
            }
            this.renderMediaIndex = i3;
            E(chain.getMediaPickerInput().getTemplateLibraryData());
            if (getTemplatePreProcessConfig() == null) {
                chain.b().m(1.0f);
                return chain.f(chain.getMediaPickerInput());
            }
            x().v3();
            TemplatePreProcessConfig templatePreProcessConfig = getTemplatePreProcessConfig();
            if (templatePreProcessConfig != null && (medias = templatePreProcessConfig.getMedias()) != null) {
                Iterator<T> it = medias.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        TemplatePreProcessConfig.Media media2 = (TemplatePreProcessConfig.Media) obj;
                        int index = media2.getIndex();
                        Integer num = this.renderMediaIndex;
                        if (num == null || index != num.intValue()) {
                            List<TemplatePreProcessConfig.Media.Preprocess> preprocess = media2.getPreprocess();
                            if (preprocess != null) {
                                Intrinsics.checkNotNullExpressionValue(preprocess, "preprocess");
                                List<TemplatePreProcessConfig.Media.Preprocess> list = preprocess;
                                if (!(list instanceof Collection) || !list.isEmpty()) {
                                    Iterator<T> it5 = list.iterator();
                                    while (it5.hasNext()) {
                                        int index2 = ((TemplatePreProcessConfig.Media.Preprocess) it5.next()).getIndex();
                                        Integer num2 = this.renderMediaIndex;
                                        if (num2 != null && index2 == num2.intValue()) {
                                            z18 = true;
                                        } else {
                                            z18 = false;
                                        }
                                        if (z18) {
                                            z19 = true;
                                            break;
                                        }
                                    }
                                }
                                z19 = false;
                                if (z19) {
                                    z16 = true;
                                    if (!z16) {
                                        z17 = false;
                                        if (!z17) {
                                            break;
                                        }
                                    }
                                }
                            }
                            z16 = false;
                            if (!z16) {
                            }
                        }
                        z17 = true;
                        if (!z17) {
                        }
                    } else {
                        obj = null;
                        break;
                    }
                }
                media = (TemplatePreProcessConfig.Media) obj;
            } else {
                media = null;
            }
            this.mediaPreprocessConfig = media;
            K(chain);
            com.tencent.mobileqq.wink.b.a().addDefaultObservers(this);
            chain.b().y0(chain.e().size());
            L(null);
            m().clear();
            r().clear();
            t().clear();
            WinkEditorResourceManager.a1().r3();
            Q();
            N(new CountDownLatch(1));
            if (G(chain.getMediaPickerInput())) {
                f();
            } else {
                P();
            }
            CountDownLatch syncLatch = getSyncLatch();
            if (syncLatch != null) {
                syncLatch.await();
            }
            chain.b().m(1.0f);
            h();
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
        return "TemplateLibReplaceMediaInterceptor";
    }

    @Override // com.tencent.mobileqq.app.BusinessObserver
    public void onUpdate(int type, boolean isSuccess, @Nullable Object data) {
        if (type != 3) {
            if (type != 4) {
                if (type == 6) {
                    R(isSuccess, data);
                    return;
                }
                return;
            }
            S(isSuccess, data);
            return;
        }
        C(isSuccess);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.mobileqq.wink.picker.interceptor.TemplateLibBaseMediaInterceptor
    @NotNull
    protected Map<String, LocalMediaInfo> s(@NotNull List<? extends LocalMediaInfo> selectedMedia) {
        int collectionSizeOrDefault;
        int mapCapacity;
        int coerceAtLeast;
        Map<String, LocalMediaInfo> mutableMap;
        List<TemplatePreProcessConfig.Media.Preprocess> preprocess;
        boolean z16;
        Object first;
        Object first2;
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
        TemplatePreProcessConfig.Media media = this.mediaPreprocessConfig;
        if (media != null && (preprocess = media.getPreprocess()) != null) {
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
                        String originPath = replaceLayerMediaInfo.getOriginPath();
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) selectedMedia);
                        mutableMap.put(originPath, first);
                    }
                } else {
                    List<Integer> multipleIndexes2 = preprocess2.getMultipleIndexes();
                    Intrinsics.checkNotNullExpressionValue(multipleIndexes2, "preprocess.multipleIndexes");
                    Iterator<T> it = multipleIndexes2.iterator();
                    while (it.hasNext()) {
                        TemplateLibBaseMediaInterceptor.ReplaceLayerMediaInfo replaceLayerMediaInfo2 = v().get((Integer) it.next());
                        if (replaceLayerMediaInfo2 != null) {
                            String originPath2 = replaceLayerMediaInfo2.getOriginPath();
                            first2 = CollectionsKt___CollectionsKt.first((List<? extends Object>) selectedMedia);
                            mutableMap.put(originPath2, first2);
                        }
                    }
                }
            }
        }
        return mutableMap;
    }
}
