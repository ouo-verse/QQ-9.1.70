package pd4;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.composition.model.component.Camera;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.composition.model.component.Rect;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.composition.model.component.TransitionTrigger;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.entity.EntityId;
import com.tencent.tavcut.rendermodel.entity.MutableEntity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.tavcut.rendermodel.properties.Layout;
import com.tencent.tavcut.rendermodel.properties.Properties;
import com.tencent.videocut.utils.ReflectUtilsKt;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u0000 \u000f2\u00020\u0001:\u0001!B\u000f\u0012\u0006\u0010I\u001a\u00020\u0013\u00a2\u0006\u0004\bJ\u0010KJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J$\u0010\r\u001a\u00020\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0002J&\u0010\u000f\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000e\u001a\u00020\b2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J,\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007H\u0002J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0002J\u0006\u0010\u0017\u001a\u00020\u0002J\u001e\u0010\u001d\u001a\u00020\u00052\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u001bJ\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018J\u000e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\tJ\u0010\u0010!\u001a\u0004\u0018\u00010\t2\u0006\u0010 \u001a\u00020\bJ(\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\"\u001a\u00020\u00022\b\u0010$\u001a\u0004\u0018\u00010#J\u0016\u0010&\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010'\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0001J \u0010*\u001a\u00020\u00052\u0006\u0010(\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010)\u001a\u00020\u0002J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002J\u000e\u0010,\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00182\u0006\u0010-\u001a\u00020\bJ\u0010\u0010/\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u0002J\u0014\u00102\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u0002000\u0018J\u000e\u00105\u001a\u00020\u001b2\u0006\u00104\u001a\u000203J\u000e\u00108\u001a\u00020\u00052\u0006\u00107\u001a\u000206J\u001a\u00109\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\f\u001a\u00020\u000bJ\u0016\u0010<\u001a\u00020\u001b2\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010\u0018R\u0017\u0010@\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b!\u0010=\u001a\u0004\b>\u0010?R\u0016\u0010C\u001a\u00020A8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010BR \u0010E\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010DR\u0016\u0010G\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010=R\u0016\u0010I\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010H\u00a8\u0006L"}, d2 = {"Lpd4/c;", "", "", "componentId", TemplateParser.KEY_ENTITY_ID, "", "u", "", "", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "usedInputSource", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "i", "value", "g", HippyQQConstants.URL_COMPONENT_NAME, "inputSource", "e", "Lcom/tencent/tavcut/rendermodel/RenderModel;", DomainData.DOMAIN_NAME, "j", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "", "Lcom/tencent/tavcut/model/ClipSource;", "clips", "", "modifyClipsDuration", "v", "k", "f", "sourceKey", "a", "cid", "Lcom/google/gson/JsonObject;", "rawData", "b", ReportConstant.COSTREPORT_PREFIX, "y", "parentId", "index", "c", "r", "t", "type", "p", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/tavcut/composition/model/component/Timeline;", "timeLines", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/tavcut/model/Painting;", "backGround", "w", "Lcom/tencent/tavcut/composition/model/component/Size;", "size", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, h.F, "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", DownloadInfo.spKey_Config, HippyTKDListViewAdapter.X, "I", "o", "()I", "renderRootId", "Lcom/tencent/tavcut/rendermodel/entity/MutableEntity;", "Lcom/tencent/tavcut/rendermodel/entity/MutableEntity;", "mutableEntity", "Ljava/util/Map;", "mutableInputSource", "d", "lastEntitySize", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "<init>", "(Lcom/tencent/tavcut/rendermodel/RenderModel;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int renderRootId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private volatile MutableEntity mutableEntity;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final Map<String, InputSource> mutableInputSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int lastEntitySize;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private volatile RenderModel renderModel;

    /* renamed from: f, reason: collision with root package name */
    private static final String[] f425951f = {"src", "renderTargetKey", "resourcePath", "scriptPath"};

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0006\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 1, 16})
    /* loaded from: classes26.dex */
    public static final class b<T> implements Comparator<T> {
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            Integer num;
            T t18;
            Object obj;
            Integer num2;
            T t19;
            Object obj2;
            int compareValues;
            Iterator<T> it = ((Entity) t16).getComponents().iterator();
            while (true) {
                num = null;
                if (it.hasNext()) {
                    t18 = it.next();
                    if (((IdentifyComponent) t18).getData() instanceof Priority) {
                        break;
                    }
                } else {
                    t18 = (T) null;
                    break;
                }
            }
            IdentifyComponent identifyComponent = t18;
            if (identifyComponent != null) {
                obj = identifyComponent.getData();
            } else {
                obj = null;
            }
            if (!(obj instanceof Priority)) {
                obj = null;
            }
            Priority priority = (Priority) obj;
            if (priority != null) {
                num2 = priority.priority;
            } else {
                num2 = null;
            }
            Iterator<T> it5 = ((Entity) t17).getComponents().iterator();
            while (true) {
                if (it5.hasNext()) {
                    t19 = it5.next();
                    if (((IdentifyComponent) t19).getData() instanceof Priority) {
                        break;
                    }
                } else {
                    t19 = (T) null;
                    break;
                }
            }
            IdentifyComponent identifyComponent2 = t19;
            if (identifyComponent2 != null) {
                obj2 = identifyComponent2.getData();
            } else {
                obj2 = null;
            }
            if (!(obj2 instanceof Priority)) {
                obj2 = null;
            }
            Priority priority2 = (Priority) obj2;
            if (priority2 != null) {
                num = priority2.priority;
            }
            compareValues = ComparisonsKt__ComparisonsKt.compareValues(num2, num);
            return compareValues;
        }
    }

    public c(@NotNull RenderModel renderModel) {
        int i3;
        Object obj;
        Integer id5;
        ScreenTransform copy;
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.renderModel = renderModel;
        Entity root = this.renderModel.getRoot();
        if (root != null) {
            i3 = root.getId();
        } else {
            i3 = 1;
        }
        this.renderRootId = i3;
        this.mutableEntity = new MutableEntity(null, null, null, null, null, null, null, null, 255, null);
        this.mutableInputSource = new LinkedHashMap();
        this.lastEntitySize = -1;
        Entity root2 = this.renderModel.getRoot();
        if (root2 != null) {
            d(this, 0, root2, 0, 4, null);
            for (Map.Entry<String, InputSource> entry : this.renderModel.getInputSources().entrySet()) {
                this.mutableInputSource.put(entry.getKey(), entry.getValue());
            }
            Iterator<T> it = root2.getComponents().iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((IdentifyComponent) obj).getData().getClass()), Reflection.getOrCreateKotlinClass(ScreenTransform.class))) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            IdentifyComponent identifyComponent = (IdentifyComponent) obj;
            if (identifyComponent != null) {
                Object data = identifyComponent.getData();
                ScreenTransform screenTransform = (ScreenTransform) (data instanceof ScreenTransform ? data : null);
                if (screenTransform != null && Intrinsics.areEqual(screenTransform.anchor, new Rect(0.0f, 0.0f, 0.0f, 0.0f, null, 16, null)) && (id5 = identifyComponent.getId()) != null) {
                    int intValue = id5.intValue();
                    copy = screenTransform.copy((r36 & 1) != 0 ? screenTransform.entityId : null, (r36 & 2) != 0 ? screenTransform.componentID : null, (r36 & 4) != 0 ? screenTransform.enabled : null, (r36 & 8) != 0 ? screenTransform.type : null, (r36 & 16) != 0 ? screenTransform.anchor : new Rect(-1.0f, 1.0f, 1.0f, -1.0f, null, 16, null), (r36 & 32) != 0 ? screenTransform.offset : null, (r36 & 64) != 0 ? screenTransform.pivot : null, (r36 & 128) != 0 ? screenTransform.ePinToEdge : null, (r36 & 256) != 0 ? screenTransform.eFixSize : null, (r36 & 512) != 0 ? screenTransform.eEditingMode : null, (r36 & 1024) != 0 ? screenTransform.eKeepRatio : null, (r36 & 2048) != 0 ? screenTransform.position : null, (r36 & 4096) != 0 ? screenTransform.rotation : null, (r36 & 8192) != 0 ? screenTransform.scale : null, (r36 & 16384) != 0 ? screenTransform.euler : null, (r36 & 32768) != 0 ? screenTransform.objectEnabled : null, (r36 & 65536) != 0 ? screenTransform.version : null, (r36 & 131072) != 0 ? screenTransform.unknownFields() : null);
                    y(intValue, copy);
                }
            }
        }
    }

    public static /* synthetic */ void d(c cVar, int i3, Entity entity, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = -1;
        }
        cVar.c(i3, entity, i16);
    }

    private final void e(Object component, InputSource inputSource, Map<String, InputSource> usedInputSource) {
        InputSource inputSource2;
        String str;
        if ((component instanceof Camera) && (inputSource2 = this.mutableInputSource.get(inputSource.inputKey)) != null && (str = inputSource.inputKey) != null) {
            usedInputSource.put(str, inputSource2);
        }
    }

    private final InputSource g(String value, Map<String, InputSource> usedInputSource) {
        InputSource inputSource;
        if (!this.mutableInputSource.keySet().contains(value) || (inputSource = this.mutableInputSource.get(value)) == null) {
            return null;
        }
        usedInputSource.put(value, inputSource);
        return inputSource;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x006f A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x000a A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void i(Map<String, InputSource> usedInputSource, Entity entity) {
        String asString;
        InputSource g16;
        Iterator<T> it = entity.getComponents().iterator();
        while (it.hasNext()) {
            Object data = ((IdentifyComponent) it.next()).getData();
            if (data instanceof PAGAsset) {
                PAGAsset pAGAsset = (PAGAsset) data;
                String str = pAGAsset.src;
                if (str != null) {
                    g(str, usedInputSource);
                }
                Iterator<T> it5 = pAGAsset.replacement.iterator();
                while (it5.hasNext()) {
                    String str2 = ((PAGAsset.Replacement) it5.next()).src;
                    if (str2 != null) {
                        g(str2, usedInputSource);
                    }
                }
            } else if (data instanceof JsonObject) {
                JsonElement jsonElement = ((JsonObject) data).get("src");
                if (jsonElement != null && (asString = jsonElement.getAsString()) != null) {
                    g16 = g(asString, usedInputSource);
                    if (g16 == null) {
                        e(data, g16, usedInputSource);
                    }
                }
            } else {
                Object b16 = ReflectUtilsKt.b(data, f425951f);
                if (!(b16 instanceof String)) {
                    b16 = null;
                }
                asString = (String) b16;
                if (asString != null) {
                    g16 = g(asString, usedInputSource);
                    if (g16 == null) {
                    }
                }
            }
        }
        Iterator<T> it6 = entity.getChildren().iterator();
        while (it6.hasNext()) {
            i(usedInputSource, (Entity) it6.next());
        }
    }

    private final void u(int componentId, int entityId) {
        Object obj = this.mutableEntity.getComponents().get(Integer.valueOf(componentId));
        if (obj != null) {
            String componentType = obj.getClass().getName();
            MutableEntity mutableEntity = this.mutableEntity;
            Map h16 = com.tencent.videocut.utils.c.h(this.mutableEntity.getComponents(), Integer.valueOf(componentId));
            Map h17 = com.tencent.videocut.utils.c.h(this.mutableEntity.getRawComponents(), Integer.valueOf(componentId));
            Map<String, List<Integer>> byComponentType = this.mutableEntity.getByComponentType();
            Intrinsics.checkExpressionValueIsNotNull(componentType, "componentType");
            this.mutableEntity = MutableEntity.copy$default(mutableEntity, null, h16, h17, com.tencent.videocut.utils.c.c(this.mutableEntity.getEntityMapToComponent(), Integer.valueOf(entityId), Integer.valueOf(componentId)), com.tencent.videocut.utils.c.c(byComponentType, componentType, Integer.valueOf(entityId)), null, null, null, 225, null);
        }
    }

    public final synchronized void A(@NotNull List<Timeline> timeLines) {
        RenderModel copy;
        Intrinsics.checkParameterIsNotNull(timeLines, "timeLines");
        copy = r2.copy((r32 & 1) != 0 ? r2.renderScene : null, (r32 & 2) != 0 ? r2.root : null, (r32 & 4) != 0 ? r2.inputSources : null, (r32 & 8) != 0 ? r2.painting : null, (r32 & 16) != 0 ? r2.clipsAssets : null, (r32 & 32) != 0 ? r2.modifyClipsDuration : false, (r32 & 64) != 0 ? r2.seekTolerance : 0, (r32 & 128) != 0 ? r2.properties : null, (r32 & 256) != 0 ? r2.audioAssets : null, (r32 & 512) != 0 ? r2.timeLines : timeLines, (r32 & 1024) != 0 ? r2.maxDuration : 0L, (r32 & 2048) != 0 ? r2.componentLevel : 0, (r32 & 4096) != 0 ? r2.voiceChangerConfig : null, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
        this.renderModel = copy;
    }

    @Nullable
    public final synchronized InputSource a(@NotNull String sourceKey) {
        Intrinsics.checkParameterIsNotNull(sourceKey, "sourceKey");
        return this.mutableInputSource.get(sourceKey);
    }

    public final synchronized void b(int entityId, @NotNull Object component, int cid, @Nullable JsonObject rawData) {
        Intrinsics.checkParameterIsNotNull(component, "component");
        String componentType = component.getClass().getName();
        if (cid == -1) {
            if (!(component instanceof EntityIdentifier)) {
                this.mutableEntity = MutableEntity.copy$default(this.mutableEntity, null, null, null, null, null, null, null, com.tencent.videocut.utils.c.e(this.mutableEntity.getNoIdComponents(), Integer.valueOf(entityId), component), 127, null);
            }
            return;
        }
        MutableEntity mutableEntity = this.mutableEntity;
        Map g16 = com.tencent.videocut.utils.c.g(this.mutableEntity.getComponents(), Integer.valueOf(cid), component);
        Map g17 = com.tencent.videocut.utils.c.g(this.mutableEntity.getRawComponents(), Integer.valueOf(cid), rawData);
        Map e16 = com.tencent.videocut.utils.c.e(this.mutableEntity.getEntityMapToComponent(), Integer.valueOf(entityId), Integer.valueOf(cid));
        Map<String, List<Integer>> byComponentType = this.mutableEntity.getByComponentType();
        Intrinsics.checkExpressionValueIsNotNull(componentType, "componentType");
        this.mutableEntity = MutableEntity.copy$default(mutableEntity, null, g16, g17, e16, com.tencent.videocut.utils.c.e(byComponentType, componentType, Integer.valueOf(entityId)), null, null, null, 225, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x00bc A[Catch: all -> 0x010b, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0021, B:8:0x003e, B:12:0x004b, B:13:0x00b6, B:15:0x00bc, B:18:0x00c8, B:23:0x00dc, B:24:0x00e6, B:26:0x00ec, B:34:0x0102, B:35:0x010a), top: B:3:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ec A[Catch: all -> 0x010b, LOOP:1: B:24:0x00e6->B:26:0x00ec, LOOP_END, TRY_LEAVE, TryCatch #0 {, blocks: (B:4:0x0005, B:6:0x0021, B:8:0x003e, B:12:0x004b, B:13:0x00b6, B:15:0x00bc, B:18:0x00c8, B:23:0x00dc, B:24:0x00e6, B:26:0x00ec, B:34:0x0102, B:35:0x010a), top: B:3:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void c(int parentId, @NotNull Entity entity, int index) {
        int i3;
        Iterator<T> it;
        int i16 = index;
        synchronized (this) {
            Intrinsics.checkParameterIsNotNull(entity, "entity");
            if (!this.mutableEntity.getEntities().containsKey(Integer.valueOf(entity.getId()))) {
                yd4.a.f450209c.b("add_entity", "apply_end");
                List<Integer> list = this.mutableEntity.getParentMapToEntity().get(Integer.valueOf(parentId));
                if (list != null) {
                    i3 = list.size();
                } else {
                    i3 = 0;
                }
                if (i16 >= 0 && i3 >= i16) {
                    this.mutableEntity = MutableEntity.copy$default(this.mutableEntity, com.tencent.videocut.utils.c.g(this.mutableEntity.getEntities(), Integer.valueOf(entity.getId()), new EntityId(entity.getId(), entity.getName(), entity.getEnable())), null, null, null, null, com.tencent.videocut.utils.c.f(this.mutableEntity.getParentMapToEntity(), Integer.valueOf(parentId), Integer.valueOf(entity.getId()), i16), com.tencent.videocut.utils.c.g(this.mutableEntity.getEntityMapToParent(), Integer.valueOf(entity.getId()), Integer.valueOf(parentId)), null, 158, null);
                    for (IdentifyComponent identifyComponent : entity.getComponents()) {
                        Integer id5 = identifyComponent.getId();
                        if (id5 != null) {
                            b(entity.getId(), identifyComponent.getData(), id5.intValue(), identifyComponent.getRawData());
                        }
                    }
                    it = entity.getChildren().iterator();
                    while (it.hasNext()) {
                        d(this, entity.getId(), (Entity) it.next(), 0, 4, null);
                    }
                }
                i16 = i3;
                this.mutableEntity = MutableEntity.copy$default(this.mutableEntity, com.tencent.videocut.utils.c.g(this.mutableEntity.getEntities(), Integer.valueOf(entity.getId()), new EntityId(entity.getId(), entity.getName(), entity.getEnable())), null, null, null, null, com.tencent.videocut.utils.c.f(this.mutableEntity.getParentMapToEntity(), Integer.valueOf(parentId), Integer.valueOf(entity.getId()), i16), com.tencent.videocut.utils.c.g(this.mutableEntity.getEntityMapToParent(), Integer.valueOf(entity.getId()), Integer.valueOf(parentId)), null, 158, null);
                while (r0.hasNext()) {
                }
                it = entity.getChildren().iterator();
                while (it.hasNext()) {
                }
            } else {
                throw new IllegalStateException("entity id duplicate, please remove it first");
            }
        }
    }

    public final synchronized void f(@NotNull InputSource inputSource) {
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        String str = inputSource.key;
        if (str != null) {
            this.mutableInputSource.put(str, inputSource);
        }
    }

    @NotNull
    public final synchronized Map<String, InputSource> h(@NotNull Entity entity) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        linkedHashMap = new LinkedHashMap();
        i(linkedHashMap, entity);
        return linkedHashMap;
    }

    @NotNull
    public final synchronized RenderModel j() {
        Map plus;
        RenderModel copy;
        Entity q16 = q(this.renderRootId);
        if (q16 != null) {
            int size = this.mutableEntity.getEntities().size();
            if (this.lastEntitySize == size && !(!Intrinsics.areEqual(this.mutableInputSource, this.renderModel.getInputSources()))) {
                copy = r2.copy((r32 & 1) != 0 ? r2.renderScene : null, (r32 & 2) != 0 ? r2.root : q16, (r32 & 4) != 0 ? r2.inputSources : null, (r32 & 8) != 0 ? r2.painting : null, (r32 & 16) != 0 ? r2.clipsAssets : null, (r32 & 32) != 0 ? r2.modifyClipsDuration : false, (r32 & 64) != 0 ? r2.seekTolerance : 0, (r32 & 128) != 0 ? r2.properties : null, (r32 & 256) != 0 ? r2.audioAssets : null, (r32 & 512) != 0 ? r2.timeLines : null, (r32 & 1024) != 0 ? r2.maxDuration : 0L, (r32 & 2048) != 0 ? r2.componentLevel : 0, (r32 & 4096) != 0 ? r2.voiceChangerConfig : null, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
                this.renderModel = copy;
            }
            this.lastEntitySize = size;
            RenderModel renderModel = this.renderModel;
            plus = MapsKt__MapsKt.plus(new LinkedHashMap(), this.mutableInputSource);
            copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : q16, (r32 & 4) != 0 ? renderModel.inputSources : plus, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : null, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
            this.renderModel = copy;
        } else {
            throw new IllegalStateException("Root entity not found :" + this.renderRootId);
        }
        return this.renderModel;
    }

    @NotNull
    public final synchronized List<ClipSource> k() {
        return this.renderModel.getClipsAssets();
    }

    public final synchronized int l() {
        int i3;
        SortedMap sortedMap;
        if (!this.mutableEntity.getComponents().isEmpty()) {
            sortedMap = MapsKt__MapsJVMKt.toSortedMap(this.mutableEntity.getComponents());
            Object lastKey = sortedMap.lastKey();
            Intrinsics.checkExpressionValueIsNotNull(lastKey, "mutableEntity.components.toSortedMap().lastKey()");
            i3 = ((Number) lastKey).intValue();
        } else {
            i3 = 0;
        }
        return i3;
    }

    public final synchronized int m() {
        int i3;
        SortedMap sortedMap;
        if (!this.mutableEntity.getEntities().isEmpty()) {
            sortedMap = MapsKt__MapsJVMKt.toSortedMap(this.mutableEntity.getEntities());
            Object lastKey = sortedMap.lastKey();
            Intrinsics.checkExpressionValueIsNotNull(lastKey, "mutableEntity.entities.toSortedMap().lastKey()");
            i3 = ((Number) lastKey).intValue();
        } else {
            i3 = 0;
        }
        return i3;
    }

    @NotNull
    public final synchronized RenderModel n() {
        RenderModel copy;
        Entity q16 = q(this.renderRootId);
        if (q16 != null) {
            int size = this.mutableEntity.getEntities().size();
            if (this.lastEntitySize == size && !(!Intrinsics.areEqual(this.mutableInputSource, this.renderModel.getInputSources()))) {
                copy = r2.copy((r32 & 1) != 0 ? r2.renderScene : null, (r32 & 2) != 0 ? r2.root : q16, (r32 & 4) != 0 ? r2.inputSources : null, (r32 & 8) != 0 ? r2.painting : null, (r32 & 16) != 0 ? r2.clipsAssets : null, (r32 & 32) != 0 ? r2.modifyClipsDuration : false, (r32 & 64) != 0 ? r2.seekTolerance : 0, (r32 & 128) != 0 ? r2.properties : null, (r32 & 256) != 0 ? r2.audioAssets : null, (r32 & 512) != 0 ? r2.timeLines : null, (r32 & 1024) != 0 ? r2.maxDuration : 0L, (r32 & 2048) != 0 ? r2.componentLevel : 0, (r32 & 4096) != 0 ? r2.voiceChangerConfig : null, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
                this.renderModel = copy;
            }
            this.lastEntitySize = size;
            copy = r2.copy((r32 & 1) != 0 ? r2.renderScene : null, (r32 & 2) != 0 ? r2.root : q16, (r32 & 4) != 0 ? r2.inputSources : h(q16), (r32 & 8) != 0 ? r2.painting : null, (r32 & 16) != 0 ? r2.clipsAssets : null, (r32 & 32) != 0 ? r2.modifyClipsDuration : false, (r32 & 64) != 0 ? r2.seekTolerance : 0, (r32 & 128) != 0 ? r2.properties : null, (r32 & 256) != 0 ? r2.audioAssets : null, (r32 & 512) != 0 ? r2.timeLines : null, (r32 & 1024) != 0 ? r2.maxDuration : 0L, (r32 & 2048) != 0 ? r2.componentLevel : 0, (r32 & 4096) != 0 ? r2.voiceChangerConfig : null, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
            this.renderModel = copy;
        } else {
            throw new IllegalStateException("Root entity not found :" + this.renderRootId);
        }
        return this.renderModel;
    }

    /* renamed from: o, reason: from getter */
    public final int getRenderRootId() {
        return this.renderRootId;
    }

    @NotNull
    public final synchronized List<Entity> p(@NotNull String type) {
        ArrayList arrayList;
        Intrinsics.checkParameterIsNotNull(type, "type");
        ArrayList arrayList2 = new ArrayList();
        List<Integer> list = this.mutableEntity.getByComponentType().get(type);
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        arrayList2.addAll(list);
        arrayList = new ArrayList();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Entity q16 = q(((Number) it.next()).intValue());
            if (q16 != null) {
                arrayList.add(q16);
            }
        }
        return arrayList;
    }

    @Nullable
    public final synchronized Entity q(int entityId) {
        boolean z16;
        boolean z17;
        List emptyList;
        boolean z18;
        List list;
        List sortedWith;
        EntityId entityId2 = this.mutableEntity.getEntities().get(Integer.valueOf(entityId));
        if (entityId2 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List<Integer> list2 = this.mutableEntity.getEntityMapToComponent().get(Integer.valueOf(entityId));
        if (list2 != null) {
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                int intValue = ((Number) it.next()).intValue();
                Object obj = this.mutableEntity.getComponents().get(Integer.valueOf(intValue));
                JsonObject jsonObject = this.mutableEntity.getRawComponents().get(Integer.valueOf(intValue));
                if (obj != null) {
                    arrayList.add(new IdentifyComponent(Integer.valueOf(intValue), Integer.valueOf(entityId), obj, jsonObject));
                }
            }
        }
        List<Object> list3 = this.mutableEntity.getNoIdComponents().get(Integer.valueOf(entityId));
        if (list3 != null) {
            Iterator<T> it5 = list3.iterator();
            while (it5.hasNext()) {
                arrayList.add(new IdentifyComponent(-1, Integer.valueOf(entityId), it5.next(), null));
            }
        }
        boolean z19 = true;
        if (!arrayList.isEmpty()) {
            Iterator it6 = arrayList.iterator();
            while (it6.hasNext()) {
                if (((IdentifyComponent) it6.next()).getData() instanceof Priority) {
                    z16 = true;
                    break;
                }
            }
        }
        z16 = false;
        if (!z16) {
            arrayList.add(new IdentifyComponent(-1, Integer.valueOf(entityId), new Priority(null, null, null, null, Integer.MIN_VALUE, null, 47, null), null, 8, null));
        }
        if (!arrayList.isEmpty()) {
            Iterator it7 = arrayList.iterator();
            while (it7.hasNext()) {
                if (((IdentifyComponent) it7.next()).getData() instanceof EntityIdentifier) {
                    z17 = true;
                    break;
                }
            }
        }
        z17 = false;
        if (!z17) {
            arrayList.add(new IdentifyComponent(-1, Integer.valueOf(entityId), xd4.b.f447836a.a(entityId2.getName()), null, 8, null));
        }
        List<Integer> list4 = this.mutableEntity.getParentMapToEntity().get(Integer.valueOf(entityId));
        if (list4 == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            Iterator<T> it8 = list4.iterator();
            while (it8.hasNext()) {
                Entity q16 = q(((Number) it8.next()).intValue());
                if (q16 != null) {
                    emptyList.add(q16);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            Iterator it9 = arrayList.iterator();
            while (it9.hasNext()) {
                if (((IdentifyComponent) it9.next()).getData() instanceof TransitionTrigger) {
                    z18 = true;
                    break;
                }
            }
        }
        z18 = false;
        if (z18 || !(!emptyList.isEmpty())) {
            z19 = false;
        }
        if (z19) {
            sortedWith = CollectionsKt___CollectionsKt.sortedWith(emptyList, new b());
            list = sortedWith;
        } else {
            list = emptyList;
        }
        return new Entity(entityId2.getId(), entityId2.getName(), list, arrayList, entityId2.getEnabled(), 0, 32, null);
    }

    public final synchronized int r(int entityId) {
        Integer num;
        List<Integer> list = this.mutableEntity.getParentMapToEntity().get(this.mutableEntity.getEntityMapToParent().get(Integer.valueOf(entityId)));
        if (list != null) {
            num = Integer.valueOf(list.indexOf(Integer.valueOf(entityId)));
        } else {
            num = null;
        }
        if (num == null || num.intValue() == -1) {
            return -1;
        }
        return num.intValue();
    }

    public final synchronized void s(int entityId, int componentId) {
        if (this.mutableEntity.getComponents().containsKey(Integer.valueOf(componentId))) {
            u(componentId, entityId);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x008c A[Catch: all -> 0x00d4, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0013, B:10:0x0030, B:13:0x004d, B:15:0x008c, B:16:0x0092, B:18:0x0098, B:20:0x00a6, B:22:0x00b8, B:23:0x00be, B:25:0x00c4, B:30:0x0049), top: B:2:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b8 A[Catch: all -> 0x00d4, TryCatch #0 {, blocks: (B:3:0x0001, B:8:0x0013, B:10:0x0030, B:13:0x004d, B:15:0x008c, B:16:0x0092, B:18:0x0098, B:20:0x00a6, B:22:0x00b8, B:23:0x00be, B:25:0x00c4, B:30:0x0049), top: B:2:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized void t(int entityId) {
        Map emptyMap;
        List<Integer> list;
        List<Integer> list2;
        if (!this.mutableEntity.getEntities().containsKey(Integer.valueOf(entityId))) {
            return;
        }
        yd4.a.f450209c.b("remove_entity", "apply_end");
        Integer num = this.mutableEntity.getEntityMapToParent().get(Integer.valueOf(entityId));
        if (num != null) {
            emptyMap = com.tencent.videocut.utils.c.c(this.mutableEntity.getParentMapToEntity(), Integer.valueOf(num.intValue()), Integer.valueOf(entityId));
            if (emptyMap != null) {
                this.mutableEntity = MutableEntity.copy$default(this.mutableEntity, com.tencent.videocut.utils.c.h(this.mutableEntity.getEntities(), Integer.valueOf(entityId)), null, null, null, null, emptyMap, com.tencent.videocut.utils.c.h(this.mutableEntity.getEntityMapToParent(), Integer.valueOf(entityId)), null, 158, null);
                list = this.mutableEntity.getEntityMapToComponent().get(Integer.valueOf(entityId));
                if (list != null) {
                    Iterator<T> it = list.iterator();
                    while (it.hasNext()) {
                        s(entityId, ((Number) it.next()).intValue());
                    }
                }
                list2 = this.mutableEntity.getParentMapToEntity().get(Integer.valueOf(entityId));
                if (list2 != null) {
                    Iterator<T> it5 = list2.iterator();
                    while (it5.hasNext()) {
                        t(((Number) it5.next()).intValue());
                    }
                }
            }
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.mutableEntity = MutableEntity.copy$default(this.mutableEntity, com.tencent.videocut.utils.c.h(this.mutableEntity.getEntities(), Integer.valueOf(entityId)), null, null, null, null, emptyMap, com.tencent.videocut.utils.c.h(this.mutableEntity.getEntityMapToParent(), Integer.valueOf(entityId)), null, 158, null);
        list = this.mutableEntity.getEntityMapToComponent().get(Integer.valueOf(entityId));
        if (list != null) {
        }
        list2 = this.mutableEntity.getParentMapToEntity().get(Integer.valueOf(entityId));
        if (list2 != null) {
        }
    }

    public final synchronized void v(@NotNull List<ClipSource> clips, boolean modifyClipsDuration) {
        RenderModel copy;
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        copy = r2.copy((r32 & 1) != 0 ? r2.renderScene : null, (r32 & 2) != 0 ? r2.root : null, (r32 & 4) != 0 ? r2.inputSources : null, (r32 & 8) != 0 ? r2.painting : null, (r32 & 16) != 0 ? r2.clipsAssets : clips, (r32 & 32) != 0 ? r2.modifyClipsDuration : modifyClipsDuration, (r32 & 64) != 0 ? r2.seekTolerance : 0, (r32 & 128) != 0 ? r2.properties : null, (r32 & 256) != 0 ? r2.audioAssets : null, (r32 & 512) != 0 ? r2.timeLines : null, (r32 & 1024) != 0 ? r2.maxDuration : 0L, (r32 & 2048) != 0 ? r2.componentLevel : 0, (r32 & 4096) != 0 ? r2.voiceChangerConfig : null, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
        this.renderModel = copy;
    }

    public final synchronized boolean w(@NotNull Painting backGround) {
        RenderModel copy;
        Intrinsics.checkParameterIsNotNull(backGround, "backGround");
        if (!Intrinsics.areEqual(this.renderModel.getPainting(), backGround)) {
            copy = r2.copy((r32 & 1) != 0 ? r2.renderScene : null, (r32 & 2) != 0 ? r2.root : null, (r32 & 4) != 0 ? r2.inputSources : null, (r32 & 8) != 0 ? r2.painting : backGround, (r32 & 16) != 0 ? r2.clipsAssets : null, (r32 & 32) != 0 ? r2.modifyClipsDuration : false, (r32 & 64) != 0 ? r2.seekTolerance : 0, (r32 & 128) != 0 ? r2.properties : null, (r32 & 256) != 0 ? r2.audioAssets : null, (r32 & 512) != 0 ? r2.timeLines : null, (r32 & 1024) != 0 ? r2.maxDuration : 0L, (r32 & 2048) != 0 ? r2.componentLevel : 0, (r32 & 4096) != 0 ? r2.voiceChangerConfig : null, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
            this.renderModel = copy;
            return true;
        }
        return false;
    }

    public final boolean x(@Nullable List<? extends VoiceEnum> config) {
        RenderModel copy;
        if (!Intrinsics.areEqual(this.renderModel.getVoiceChangerConfig(), config)) {
            copy = r2.copy((r32 & 1) != 0 ? r2.renderScene : null, (r32 & 2) != 0 ? r2.root : null, (r32 & 4) != 0 ? r2.inputSources : null, (r32 & 8) != 0 ? r2.painting : null, (r32 & 16) != 0 ? r2.clipsAssets : null, (r32 & 32) != 0 ? r2.modifyClipsDuration : false, (r32 & 64) != 0 ? r2.seekTolerance : 0, (r32 & 128) != 0 ? r2.properties : null, (r32 & 256) != 0 ? r2.audioAssets : null, (r32 & 512) != 0 ? r2.timeLines : null, (r32 & 1024) != 0 ? r2.maxDuration : 0L, (r32 & 2048) != 0 ? r2.componentLevel : 0, (r32 & 4096) != 0 ? r2.voiceChangerConfig : config, (r32 & 8192) != 0 ? this.renderModel.customRenderConfig : null);
            this.renderModel = copy;
            return true;
        }
        return false;
    }

    public final synchronized void y(int componentId, @NotNull Object component) {
        Intrinsics.checkParameterIsNotNull(component, "component");
        if (this.mutableEntity.getComponents().containsKey(Integer.valueOf(componentId))) {
            yd4.a.f450209c.b("update_component", "apply_end");
            ee4.b.a("RenderModelHolder", "in real updateComponent id: " + componentId);
            if (component instanceof TimeOffset) {
                ee4.b.a("RenderModelHolder", "in real updateComponent time: " + ((TimeOffset) component).duration);
            }
            this.mutableEntity = MutableEntity.copy$default(this.mutableEntity, null, com.tencent.videocut.utils.c.g(this.mutableEntity.getComponents(), Integer.valueOf(componentId), component), null, null, null, null, null, null, 253, null);
        }
    }

    public final synchronized void z(@NotNull Size size) {
        Properties properties;
        RenderModel copy;
        Intrinsics.checkParameterIsNotNull(size, "size");
        RenderModel renderModel = this.renderModel;
        Properties properties2 = this.renderModel.getProperties();
        if (properties2 != null) {
            properties = Properties.copy$default(properties2, new Layout(size.width, size.height), null, null, null, null, null, null, 126, null);
        } else {
            properties = null;
        }
        copy = renderModel.copy((r32 & 1) != 0 ? renderModel.renderScene : null, (r32 & 2) != 0 ? renderModel.root : null, (r32 & 4) != 0 ? renderModel.inputSources : null, (r32 & 8) != 0 ? renderModel.painting : null, (r32 & 16) != 0 ? renderModel.clipsAssets : null, (r32 & 32) != 0 ? renderModel.modifyClipsDuration : false, (r32 & 64) != 0 ? renderModel.seekTolerance : 0, (r32 & 128) != 0 ? renderModel.properties : properties, (r32 & 256) != 0 ? renderModel.audioAssets : null, (r32 & 512) != 0 ? renderModel.timeLines : null, (r32 & 1024) != 0 ? renderModel.maxDuration : 0L, (r32 & 2048) != 0 ? renderModel.componentLevel : 0, (r32 & 4096) != 0 ? renderModel.voiceChangerConfig : null, (r32 & 8192) != 0 ? renderModel.customRenderConfig : null);
        this.renderModel = copy;
    }
}
