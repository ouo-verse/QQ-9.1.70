package com.tencent.tavcut.core.dataprocessor;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tritonaudio.InnerAudioPlugin;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.tavcut.core.render.IRenderChainManager;
import com.tencent.tavcut.core.render.builder.light.model.ClipSource;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Painting;
import com.tencent.tavcut.core.render.builder.light.model.Timeline;
import com.tencent.tavcut.core.render.builder.light.model.properties.Layout;
import com.tencent.tavcut.core.render.builder.light.model.properties.Properties;
import com.tencent.tavcut.core.render.builder.light.model.type.VoiceEnum;
import com.tencent.tavcut.core.render.log.TavLogger;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.WatermarkConfig;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.PAGAsset;
import org.light.lightAssetKit.components.ReplaceItem;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.enums.ReplaceType;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00c2\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u0003SW\u001aB!\u0012\u0018\u0010r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u00020\u00070p\u00a2\u0006\u0004\bs\u0010tJ \u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\u0005H\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H\u0002J\u0016\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0005J(\u0010\u0013\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0005J\u001e\u0010\u0014\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0015J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u0018J \u0010\"\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010!\u001a\u00020 J\u0017\u0010#\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cH\u0000\u00a2\u0006\u0004\b#\u0010$J\u0014\u0010'\u001a\u00020\u00072\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0\u0002J\u000e\u0010(\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001cJ\u0006\u0010)\u001a\u00020\u0007J\u0014\u0010,\u001a\u00020\u00072\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00070*J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00022\b\u0010-\u001a\u0004\u0018\u00010\u001cJ\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002J\u0016\u00102\u001a\u00020\u00072\u0006\u0010!\u001a\u00020 2\u0006\u00101\u001a\u000200J\u0014\u00105\u001a\u00020\u00052\f\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0002J\u0014\u00106\u001a\u00020\u00052\f\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0002J\u0014\u00107\u001a\u00020\u00052\f\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0002J\u0006\u00108\u001a\u00020 J\f\u00109\u001a\b\u0012\u0004\u0012\u0002030\u0002J\u0014\u0010:\u001a\u00020\u00072\f\u00104\u001a\b\u0012\u0004\u0012\u0002030\u0002J\u0006\u0010;\u001a\u00020\u0007J\u0006\u0010<\u001a\u00020\u000eJ\u0006\u0010=\u001a\u00020\u000eJ$\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0002\"\b\b\u0000\u0010?*\u00020>2\f\u0010A\u001a\b\u0012\u0004\u0012\u00028\u00000@J\u000e\u0010E\u001a\u00020\u00072\u0006\u0010D\u001a\u00020CJ\u0018\u0010I\u001a\u00020\u00072\u0006\u0010G\u001a\u00020F2\b\b\u0002\u0010H\u001a\u00020\u0005J\u001a\u0010M\u001a\u00020\u00052\b\u0010K\u001a\u0004\u0018\u00010J2\b\u0010L\u001a\u0004\u0018\u00010JJ\u0016\u0010P\u001a\u00020\u00072\u000e\u0010O\u001a\n\u0012\u0004\u0012\u00020N\u0018\u00010\u0002J\u0010\u0010R\u001a\u00020\u00072\b\u0010O\u001a\u0004\u0018\u00010QR\u0014\u0010U\u001a\u00020\u00058\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010Y\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bW\u0010XR\u0014\u0010Z\u001a\u00020V8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010XR\"\u0010`\u001a\u00020\u00188\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\"\u0010[\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_R\u0018\u0010c\u001a\u0004\u0018\u00010C8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\ba\u0010bR$\u0010j\u001a\u0004\u0018\u00010d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u0017\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR\u0016\u0010l\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bE\u0010kR\u0014\u0010o\u001a\u00020m8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010nR&\u0010r\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070*\u0012\u0004\u0012\u00020\u00070p8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b8\u0010q\u00a8\u0006u"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher;", "", "", "Lcom/tencent/tavcut/core/render/builder/light/model/ClipSource;", "clips", "", "modifyClipsDuration", "", UserInfo.SEX_FEMALE, "y", HippyTKDListViewAdapter.X, h.F, "enable", "k", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "renderModel", "needInitTemplate", "r", "enableImageEffect", "G", "I", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "inputSource", "f", "", "sourceKey", "c", "D", "Lorg/light/lightAssetKit/Entity;", "entity", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "entityNodeType", "", "index", "d", ReportConstant.COSTREPORT_PREFIX, "(Lorg/light/lightAssetKit/Entity;)V", "Lcom/tencent/tavcut/core/render/builder/light/model/Timeline;", "timeLine", "P", BdhLogUtil.LogTag.Tag_Conn, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lkotlin/Function0;", "runnable", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "rootEntity", "o", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", InnerAudioPlugin.AUDIO_PROPERTY_VOLUME, "J", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "commands", "w", "v", "t", "i", "j", "l", "E", "p", DomainData.DOMAIN_NAME, "Lorg/light/lightAssetKit/components/Component;", "T", "Lkotlin/reflect/KClass;", "clazz", "B", "Lcom/tencent/tavcut/core/dataprocessor/a;", "listener", "g", "Lcom/tencent/tavcut/core/render/builder/light/model/Painting;", "backGround", "needFlush", "O", "Lorg/light/lightAssetKit/components/Size;", "originSize", "updateSize", "u", "Lcom/tencent/tavcut/core/render/builder/light/model/type/VoiceEnum;", DownloadInfo.spKey_Config, "M", "Lorg/light/WatermarkConfig;", "N", "a", "Z", "enableDynamicEntity", "Ljava/util/concurrent/atomic/AtomicInteger;", "b", "Ljava/util/concurrent/atomic/AtomicInteger;", "entityIdGenerator", "componentIdGenerator", "Ljava/lang/String;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "()Ljava/lang/String;", "L", "(Ljava/lang/String;)V", "templateDir", "e", "Lcom/tencent/tavcut/core/dataprocessor/a;", "dataChangeListener", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "Lcom/tencent/tavcut/core/render/IRenderChainManager;", "getRenderChainManager", "()Lcom/tencent/tavcut/core/render/IRenderChainManager;", "K", "(Lcom/tencent/tavcut/core/render/IRenderChainManager;)V", "renderChainManager", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "lakRenderModel", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$a;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$a;", "commandQueue", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "taskExecutor", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class RenderDataDispatcher {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enableDynamicEntity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger entityIdGenerator;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger componentIdGenerator;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String templateDir;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private com.tencent.tavcut.core.dataprocessor.a dataChangeListener;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IRenderChainManager renderChainManager;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private LAKRenderModel lakRenderModel;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final a commandQueue;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final Function1<Function0<Unit>, Unit> taskExecutor;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0004J\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u000b\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$a;", "", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "command", "", "d", "", "b", "a", "c", "", "Ljava/util/List;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private List<c> queue = new ArrayList();

        public final synchronized void a() {
            TavLogger.d("RenderDataDispatcher", "clear command thread: " + Thread.currentThread());
            ArrayList arrayList = new ArrayList();
            for (c cVar : this.queue) {
                if (cVar instanceof c.d) {
                    arrayList.add(cVar);
                }
            }
            this.queue = arrayList;
        }

        @NotNull
        public final synchronized List<c> b() {
            List<c> list;
            TavLogger.d("RenderDataDispatcher", "consume command thread: " + Thread.currentThread());
            list = this.queue;
            this.queue = new ArrayList();
            return list;
        }

        @NotNull
        public final synchronized List<c> c() {
            List<c> list;
            list = CollectionsKt___CollectionsKt.toList(this.queue);
            return list;
        }

        public final synchronized void d(@NotNull c command) {
            Intrinsics.checkParameterIsNotNull(command, "command");
            TavLogger.d("RenderDataDispatcher", "push command thread: " + Thread.currentThread());
            synchronized (this) {
                this.queue.add(command);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\t\u0002\u0003\u0004\u0005\u0006\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "", "a", "b", "c", "d", "e", "f", "g", h.F, "i", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public interface c {

        /* compiled from: P */
        @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0017\u001a\u00020\u0004\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000f\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0013\u001a\u00020\u00108\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u0011\u001a\u0004\b\u000b\u0010\u0012R\u0017\u0010\u0017\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$a;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "a", "Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "b", "()Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;", "entityNodeType", "Lorg/light/lightAssetKit/Entity;", "Lorg/light/lightAssetKit/Entity;", "()Lorg/light/lightAssetKit/Entity;", "entity", "c", "I", "()I", "index", "<init>", "(Lcom/tencent/tavcut/core/dataprocessor/EntityNodeType;Lorg/light/lightAssetKit/Entity;I)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher$c$a, reason: from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class AddEntity implements d {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final EntityNodeType entityNodeType;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final Entity entity;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            private final int index;

            public AddEntity(@NotNull EntityNodeType entityNodeType, @NotNull Entity entity, int i3) {
                Intrinsics.checkParameterIsNotNull(entityNodeType, "entityNodeType");
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                this.entityNodeType = entityNodeType;
                this.entity = entity;
                this.index = i3;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final Entity getEntity() {
                return this.entity;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final EntityNodeType getEntityNodeType() {
                return this.entityNodeType;
            }

            /* renamed from: c, reason: from getter */
            public final int getIndex() {
                return this.index;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (other instanceof AddEntity) {
                        AddEntity addEntity = (AddEntity) other;
                        if (!Intrinsics.areEqual(this.entityNodeType, addEntity.entityNodeType) || !Intrinsics.areEqual(this.entity, addEntity.entity) || this.index != addEntity.index) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }

            public int hashCode() {
                int i3;
                EntityNodeType entityNodeType = this.entityNodeType;
                int i16 = 0;
                if (entityNodeType != null) {
                    i3 = entityNodeType.hashCode();
                } else {
                    i3 = 0;
                }
                int i17 = i3 * 31;
                Entity entity = this.entity;
                if (entity != null) {
                    i16 = entity.hashCode();
                }
                return ((i17 + i16) * 31) + this.index;
            }

            @NotNull
            public String toString() {
                return "AddEntity(entityNodeType=" + this.entityNodeType + ", entity=" + this.entity + ", index=" + this.index + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a2\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\f\u0010\u000e\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$b;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lkotlin/Function0;", "", "a", "Lkotlin/jvm/functions/Function0;", "()Lkotlin/jvm/functions/Function0;", "runnable", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher$c$b, reason: from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class CustomCommand implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final Function0<Unit> runnable;

            public CustomCommand(@NotNull Function0<Unit> runnable) {
                Intrinsics.checkParameterIsNotNull(runnable, "runnable");
                this.runnable = runnable;
            }

            @NotNull
            public final Function0<Unit> a() {
                return this.runnable;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (!(other instanceof CustomCommand) || !Intrinsics.areEqual(this.runnable, ((CustomCommand) other).runnable)) {
                        return false;
                    }
                    return true;
                }
                return true;
            }

            public int hashCode() {
                Function0<Unit> function0 = this.runnable;
                if (function0 != null) {
                    return function0.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "CustomCommand(runnable=" + this.runnable + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$c;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher$c$c, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        public static final class C9879c implements c {

            /* renamed from: a, reason: collision with root package name */
            public static final C9879c f374278a = new C9879c();

            C9879c() {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$d;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes26.dex */
        public interface d extends c {
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$e;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes26.dex */
        public static final class e implements c {

            /* renamed from: a, reason: collision with root package name */
            public static final e f374279a = new e();

            e() {
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$f;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$d;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lorg/light/lightAssetKit/Entity;", "a", "Lorg/light/lightAssetKit/Entity;", "()Lorg/light/lightAssetKit/Entity;", "entity", "<init>", "(Lorg/light/lightAssetKit/Entity;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher$c$f, reason: from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class RemoveEntity implements d {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final Entity entity;

            public RemoveEntity(@NotNull Entity entity) {
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                this.entity = entity;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final Entity getEntity() {
                return this.entity;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (!(other instanceof RemoveEntity) || !Intrinsics.areEqual(this.entity, ((RemoveEntity) other).entity)) {
                        return false;
                    }
                    return true;
                }
                return true;
            }

            public int hashCode() {
                Entity entity = this.entity;
                if (entity != null) {
                    return entity.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "RemoveEntity(entity=" + this.entity + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$g;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", TemplateParser.KEY_ENTITY_ID, "Lorg/light/lightAssetKit/components/Component;", "Lorg/light/lightAssetKit/components/Component;", "()Lorg/light/lightAssetKit/components/Component;", HippyQQConstants.URL_COMPONENT_NAME, "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher$c$g, reason: from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class UpdateComponent implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int entityId;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final Component component;

            @NotNull
            /* renamed from: a, reason: from getter */
            public final Component getComponent() {
                return this.component;
            }

            /* renamed from: b, reason: from getter */
            public final int getEntityId() {
                return this.entityId;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (other instanceof UpdateComponent) {
                        UpdateComponent updateComponent = (UpdateComponent) other;
                        if (this.entityId != updateComponent.entityId || !Intrinsics.areEqual(this.component, updateComponent.component)) {
                            return false;
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            }

            public int hashCode() {
                int i3;
                int i16 = this.entityId * 31;
                Component component = this.component;
                if (component != null) {
                    i3 = component.hashCode();
                } else {
                    i3 = 0;
                }
                return i16 + i3;
            }

            @NotNull
            public String toString() {
                return "UpdateComponent(entityId=" + this.entityId + ", component=" + this.component + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$h;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "a", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "()Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "inputSource", "<init>", "(Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;)V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* renamed from: com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher$c$h, reason: from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class UpdateInputSource implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final InputSource inputSource;

            public UpdateInputSource(@NotNull InputSource inputSource) {
                Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
                this.inputSource = inputSource;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final InputSource getInputSource() {
                return this.inputSource;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (!(other instanceof UpdateInputSource) || !Intrinsics.areEqual(this.inputSource, ((UpdateInputSource) other).inputSource)) {
                        return false;
                    }
                    return true;
                }
                return true;
            }

            public int hashCode() {
                InputSource inputSource = this.inputSource;
                if (inputSource != null) {
                    return inputSource.hashCode();
                }
                return 0;
            }

            @NotNull
            public String toString() {
                return "UpdateInputSource(inputSource=" + this.inputSource + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c$i;", "Lcom/tencent/tavcut/core/dataprocessor/RenderDataDispatcher$c;", "<init>", "()V", "lib_tavcut_debug"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes26.dex */
        public static final class i implements c {

            /* renamed from: a, reason: collision with root package name */
            public static final i f374284a = new i();

            i() {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RenderDataDispatcher(@NotNull Function1<? super Function0<Unit>, Unit> taskExecutor) {
        Intrinsics.checkParameterIsNotNull(taskExecutor, "taskExecutor");
        this.taskExecutor = taskExecutor;
        this.enableDynamicEntity = true;
        this.entityIdGenerator = new AtomicInteger(0);
        this.componentIdGenerator = new AtomicInteger(0);
        this.templateDir = "/";
        this.lakRenderModel = new LAKRenderModel(null, null, null, null, null, null, false, 0, null, null, null, 0L, 0, null, null, false, null, null, 262143, null);
        this.commandQueue = new a();
    }

    private final void F(List<ClipSource> clips, boolean modifyClipsDuration) {
        this.lakRenderModel.setClipsAssets(clips);
        this.lakRenderModel.setModifyClipsDuration(modifyClipsDuration);
    }

    public static /* synthetic */ void H(RenderDataDispatcher renderDataDispatcher, List list, boolean z16, boolean z17, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            z17 = false;
        }
        renderDataDispatcher.G(list, z16, z17);
    }

    public static /* synthetic */ void e(RenderDataDispatcher renderDataDispatcher, Entity entity, EntityNodeType entityNodeType, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = -1;
        }
        renderDataDispatcher.d(entity, entityNodeType, i3);
    }

    private final boolean h() {
        return !this.lakRenderModel.getClipsAssets().isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x() {
        if (h()) {
            synchronized (this.commandQueue) {
                TavLogger.d("RenderDataDispatcher", "add notifyInitTemplate");
                this.commandQueue.d(c.C9879c.f374278a);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void y() {
        if (h()) {
            synchronized (this.commandQueue) {
                this.commandQueue.d(c.i.f374284a);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void A(@NotNull Function0<Unit> runnable) {
        Intrinsics.checkParameterIsNotNull(runnable, "runnable");
        synchronized (this.commandQueue) {
            this.commandQueue.d(new c.CustomCommand(runnable));
            Unit unit = Unit.INSTANCE;
        }
    }

    @NotNull
    public final <T extends Component> List<Entity> B(@NotNull KClass<T> clazz) {
        List<Entity> emptyList;
        Entity entity;
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        IRenderChainManager iRenderChainManager = this.renderChainManager;
        if (iRenderChainManager != null) {
            if (iRenderChainManager != null) {
                entity = iRenderChainManager.getRootEntity();
            } else {
                entity = null;
            }
            List<Entity> findEntitiesByComponent = iRenderChainManager.findEntitiesByComponent(entity, clazz);
            if (findEntitiesByComponent != null) {
                return findEntitiesByComponent;
            }
        }
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        return emptyList;
    }

    public final void C(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        synchronized (this.commandQueue) {
            this.commandQueue.d(new c.RemoveEntity(entity));
            Unit unit = Unit.INSTANCE;
        }
    }

    @Nullable
    public final InputSource D(@NotNull String sourceKey) {
        Intrinsics.checkParameterIsNotNull(sourceKey, "sourceKey");
        return null;
    }

    public final void E() {
        synchronized (this.commandQueue) {
            this.commandQueue.a();
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void G(@NotNull List<ClipSource> clips, boolean modifyClipsDuration, boolean enableImageEffect) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        boolean isEmpty = this.lakRenderModel.getClipsAssets().isEmpty();
        F(clips, modifyClipsDuration);
        k(enableImageEffect);
        if (isEmpty) {
            y();
        } else {
            z();
        }
    }

    public final void I(@NotNull List<ClipSource> clips, boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        F(clips, modifyClipsDuration);
        com.tencent.tavcut.core.dataprocessor.a aVar = this.dataChangeListener;
        if (aVar != null) {
            aVar.setClipAssetsWithCallback(clips, modifyClipsDuration);
        }
    }

    public final void J(int index, float volume) {
        int collectionSizeOrDefault;
        LAKRenderModel lAKRenderModel = this.lakRenderModel;
        List<ClipSource> clipsAssets = lAKRenderModel.getClipsAssets();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(clipsAssets, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        int i3 = 0;
        for (Object obj : clipsAssets) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            ClipSource clipSource = (ClipSource) obj;
            if (index == i3) {
                IRenderChainManager iRenderChainManager = this.renderChainManager;
                if (iRenderChainManager != null) {
                    iRenderChainManager.setOriginVolumeForClip(index, volume);
                }
                clipSource = clipSource.copy((r30 & 1) != 0 ? clipSource.sourceId : null, (r30 & 2) != 0 ? clipSource.path : null, (r30 & 4) != 0 ? clipSource.type : null, (r30 & 8) != 0 ? clipSource.duration : 0L, (r30 & 16) != 0 ? clipSource.speed : null, (r30 & 32) != 0 ? clipSource.volume : Float.valueOf(volume), (r30 & 64) != 0 ? clipSource.startOffset : null, (r30 & 128) != 0 ? clipSource.matrix : null, (r30 & 256) != 0 ? clipSource.photoEffectPath : null, (r30 & 512) != 0 ? clipSource.transform : null, (r30 & 1024) != 0 ? clipSource.clipRect : null, (r30 & 2048) != 0 ? clipSource.byteArray : null, (r30 & 4096) != 0 ? clipSource.autoLoop : null);
            }
            arrayList.add(clipSource);
            i3 = i16;
        }
        lAKRenderModel.setClipsAssets(arrayList);
    }

    public final void K(@Nullable IRenderChainManager iRenderChainManager) {
        this.renderChainManager = iRenderChainManager;
    }

    public final void L(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.templateDir = str;
    }

    public final void N(@Nullable WatermarkConfig config) {
        this.lakRenderModel.setWatermarkConfig(config);
    }

    public final void O(@NotNull Painting backGround, boolean needFlush) {
        Intrinsics.checkParameterIsNotNull(backGround, "backGround");
        LAKRenderModel lakRenderModel = getLakRenderModel();
        lakRenderModel.setPainting(backGround);
        Size renderSize = backGround.getRenderSize();
        if (renderSize != null) {
            if (lakRenderModel.getProperties() == null) {
                lakRenderModel.setProperties(new Properties(null, null, null, null, null, null, null, 127, null));
            }
            Properties properties = lakRenderModel.getProperties();
            if (properties != null) {
                properties.setLayout(new Layout(Integer.valueOf(renderSize.width), Integer.valueOf(renderSize.height)));
            }
        }
        getLakRenderModel().setPainting(Painting.copy$default(backGround, null, null, backGround.getRenderSize(), null, null, 27, null));
        if (needFlush) {
            y();
        }
    }

    public final void P(@NotNull List<Timeline> timeLine) {
        LAKRenderModel copy;
        Intrinsics.checkParameterIsNotNull(timeLine, "timeLine");
        Iterator<T> it = timeLine.iterator();
        while (it.hasNext()) {
            TavLogger.d("RenderDataDispatcher", "updateTimeLine time " + ((Timeline) it.next()).getRange());
        }
        copy = r1.copy((r37 & 1) != 0 ? r1.renderScene : null, (r37 & 2) != 0 ? r1.root : null, (r37 & 4) != 0 ? r1.jsonData : null, (r37 & 8) != 0 ? r1.inputSources : null, (r37 & 16) != 0 ? r1.painting : null, (r37 & 32) != 0 ? r1.clipsAssets : null, (r37 & 64) != 0 ? r1.modifyClipsDuration : false, (r37 & 128) != 0 ? r1.seekTolerance : 0, (r37 & 256) != 0 ? r1.properties : null, (r37 & 512) != 0 ? r1.audioAssets : null, (r37 & 1024) != 0 ? r1.timeLines : timeLine, (r37 & 2048) != 0 ? r1.maxDuration : 0L, (r37 & 4096) != 0 ? r1.componentLevel : 0, (r37 & 8192) != 0 ? r1.voiceChangerConfig : null, (r37 & 16384) != 0 ? r1.customRenderConfig : null, (r37 & 32768) != 0 ? r1.exportMode : false, (r37 & 65536) != 0 ? r1.stickerValue : null, (r37 & 131072) != 0 ? this.lakRenderModel.watermarkConfig : null);
        this.lakRenderModel = copy;
    }

    @Nullable
    public final InputSource c(@Nullable String sourceKey) {
        IRenderChainManager iRenderChainManager;
        if (sourceKey == null || (iRenderChainManager = this.renderChainManager) == null) {
            return null;
        }
        return iRenderChainManager.accessInputSource(sourceKey);
    }

    public final void d(@NotNull Entity entity, @NotNull EntityNodeType entityNodeType, int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        Intrinsics.checkParameterIsNotNull(entityNodeType, "entityNodeType");
        TavLogger.d("RenderDataDispatcher", "addAndNotifyEntityChanged entity: " + entity.toJson());
        synchronized (this.commandQueue) {
            TavLogger.d("RenderDataDispatcher", "in addAndNotifyEntityChanged sync ");
            this.commandQueue.d(new c.AddEntity(entityNodeType, entity, index));
            IRenderChainManager iRenderChainManager = this.renderChainManager;
            if (iRenderChainManager != null && !iRenderChainManager.entitySupportDynamicAdd(entity)) {
                z();
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void f(@NotNull InputSource inputSource) {
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        synchronized (this.commandQueue) {
            this.commandQueue.d(new c.UpdateInputSource(inputSource));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void g(@NotNull com.tencent.tavcut.core.dataprocessor.a listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.dataChangeListener = listener;
    }

    public final int i() {
        return this.commandQueue.c().size();
    }

    @NotNull
    public final List<c> j() {
        return this.commandQueue.b();
    }

    public final void l(@NotNull List<? extends c> commands) {
        IRenderChainManager iRenderChainManager;
        IRenderChainManager iRenderChainManager2;
        Intrinsics.checkParameterIsNotNull(commands, "commands");
        TavLogger.e("RenderDataDispatcher", "flushCommand...");
        synchronized (this.commandQueue) {
            for (c cVar : commands) {
                if ((cVar instanceof c.UpdateInputSource) && (iRenderChainManager2 = this.renderChainManager) != null) {
                    iRenderChainManager2.updateResource(((c.UpdateInputSource) cVar).getInputSource());
                }
            }
            for (c cVar2 : commands) {
                if (cVar2 instanceof c.UpdateComponent) {
                    IRenderChainManager iRenderChainManager3 = this.renderChainManager;
                    if (iRenderChainManager3 != null) {
                        iRenderChainManager3.updateComponent(((c.UpdateComponent) cVar2).getEntityId(), ((c.UpdateComponent) cVar2).getComponent());
                    }
                } else if (cVar2 instanceof c.AddEntity) {
                    IRenderChainManager iRenderChainManager4 = this.renderChainManager;
                    if (iRenderChainManager4 != null) {
                        iRenderChainManager4.addEntity(((c.AddEntity) cVar2).getEntityNodeType(), ((c.AddEntity) cVar2).getEntity(), ((c.AddEntity) cVar2).getIndex());
                    }
                } else if ((cVar2 instanceof c.RemoveEntity) && (iRenderChainManager = this.renderChainManager) != null) {
                    iRenderChainManager.removeEntity(((c.RemoveEntity) cVar2).getEntity());
                }
            }
            IRenderChainManager iRenderChainManager5 = this.renderChainManager;
            if (iRenderChainManager5 != null) {
                iRenderChainManager5.emit();
            }
            IRenderChainManager iRenderChainManager6 = this.renderChainManager;
            if (iRenderChainManager6 != null) {
                iRenderChainManager6.notifyDurationChange();
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    @NotNull
    public final List<Entity> m() {
        return new ArrayList();
    }

    @NotNull
    /* renamed from: n, reason: from getter */
    public final LAKRenderModel getLakRenderModel() {
        return this.lakRenderModel;
    }

    @NotNull
    public final List<Entity> o(@Nullable Entity rootEntity) {
        List<Entity> list;
        ReplaceType replaceType;
        ArrayList arrayList = new ArrayList();
        IRenderChainManager iRenderChainManager = this.renderChainManager;
        if (iRenderChainManager != null) {
            list = iRenderChainManager.findEntitiesByComponent(rootEntity, Reflection.getOrCreateKotlinClass(PAGAsset.class));
        } else {
            list = null;
        }
        if (list != null) {
            for (Entity entity : list) {
                Collection<Component> components = entity.getComponents();
                Intrinsics.checkExpressionValueIsNotNull(components, "assetEntity.components");
                for (Component component : components) {
                    if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(component.getClass()), Reflection.getOrCreateKotlinClass(PAGAsset.class))) {
                        ArrayList<ReplaceItem> replacement = ((PAGAsset) component).getReplacement();
                        Intrinsics.checkExpressionValueIsNotNull(replacement, "replacement");
                        for (ReplaceItem replaceItem : replacement) {
                            if (replaceItem != null) {
                                replaceType = replaceItem.replaceType;
                            } else {
                                replaceType = null;
                            }
                            if (replaceType == ReplaceType.Text) {
                                arrayList.add(entity);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    @NotNull
    public final LAKRenderModel p() {
        return this.lakRenderModel;
    }

    @NotNull
    /* renamed from: q, reason: from getter */
    public final String getTemplateDir() {
        return this.templateDir;
    }

    public final void r(@NotNull LAKRenderModel renderModel, final boolean needInitTemplate) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        this.lakRenderModel = renderModel;
        this.taskExecutor.invoke(new Function0<Unit>() { // from class: com.tencent.tavcut.core.dataprocessor.RenderDataDispatcher$initRenderModel$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                if (needInitTemplate) {
                    RenderDataDispatcher.this.x();
                } else {
                    RenderDataDispatcher.this.y();
                }
            }
        });
    }

    public final void s(@NotNull Entity entity) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        synchronized (this.commandQueue) {
            this.commandQueue.d(new c.RemoveEntity(entity));
            Unit unit = Unit.INSTANCE;
        }
    }

    public final boolean t(@NotNull List<? extends c> commands) {
        Intrinsics.checkParameterIsNotNull(commands, "commands");
        return commands.contains(c.C9879c.f374278a);
    }

    public final boolean u(@Nullable Size originSize, @Nullable Size updateSize) {
        Integer num;
        Integer num2;
        Integer num3;
        if (originSize == null && updateSize == null) {
            return true;
        }
        Integer num4 = null;
        if (originSize != null) {
            num = Integer.valueOf(originSize.width);
        } else {
            num = null;
        }
        if (updateSize != null) {
            num2 = Integer.valueOf(updateSize.width);
        } else {
            num2 = null;
        }
        if (Intrinsics.areEqual(num, num2)) {
            if (originSize != null) {
                num3 = Integer.valueOf(originSize.height);
            } else {
                num3 = null;
            }
            if (updateSize != null) {
                num4 = Integer.valueOf(updateSize.height);
            }
            if (Intrinsics.areEqual(num3, num4)) {
                return true;
            }
        }
        return false;
    }

    public final boolean v(@NotNull List<? extends c> commands) {
        Intrinsics.checkParameterIsNotNull(commands, "commands");
        return commands.contains(c.e.f374279a);
    }

    public final boolean w(@NotNull List<? extends c> commands) {
        Intrinsics.checkParameterIsNotNull(commands, "commands");
        if (!commands.contains(c.i.f374284a) && !t(commands)) {
            return false;
        }
        return true;
    }

    public final void z() {
        if (h()) {
            synchronized (this.commandQueue) {
                this.commandQueue.d(c.e.f374279a);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    private final void k(boolean enable) {
    }

    public final void M(@Nullable List<? extends VoiceEnum> config) {
    }
}
