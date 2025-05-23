package pd4;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewConstants;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.tavcut.composition.model.component.AITextureComponent;
import com.tencent.tavcut.composition.model.component.AudioSource;
import com.tencent.tavcut.composition.model.component.BackgroundFillMode;
import com.tencent.tavcut.composition.model.component.CustomGraph;
import com.tencent.tavcut.composition.model.component.EntityIdentifier;
import com.tencent.tavcut.composition.model.component.Image;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.LUTFilter;
import com.tencent.tavcut.composition.model.component.MultiMedia;
import com.tencent.tavcut.composition.model.component.PAGAsset;
import com.tencent.tavcut.composition.model.component.Priority;
import com.tencent.tavcut.composition.model.component.ScreenTransform;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.composition.model.component.SubAssetComponent;
import com.tencent.tavcut.composition.model.component.TimeOffset;
import com.tencent.tavcut.composition.model.component.Timeline;
import com.tencent.tavcut.composition.model.component.Transition;
import com.tencent.tavcut.model.ClipSource;
import com.tencent.tavcut.model.Painting;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.VoiceEnum;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import cooperation.qqcircle.report.QCircleReportHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 32\u00020\u0001:\u0003$*SB\u0007\u00a2\u0006\u0004\bk\u0010lJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0002J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0001H\u0002J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J\u000e\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016J\u001e\u0010\u001d\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0004J\u001e\u0010\u001e\u001a\u00020\u00022\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u0004J\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019J\u000e\u0010\"\u001a\u00020\u00022\u0006\u0010!\u001a\u00020 J\u0012\u0010$\u001a\u0004\u0018\u00010 2\b\u0010#\u001a\u0004\u0018\u00010\u0012J\u0016\u0010&\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014J\u0016\u0010'\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014J \u0010*\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u0006J \u0010+\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u0006J\u0017\u0010,\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b,\u0010-J\u000e\u0010.\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010/\u001a\u00020\u0002J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0002J\u0006\u00103\u001a\u00020\u0002J\u0006\u00104\u001a\u00020\u0002J\u0006\u00105\u001a\u00020\u0016J\u0006\u00106\u001a\u00020\u0016J$\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0019\"\b\b\u0000\u00107*\u00020\u00012\f\u00109\u001a\b\u0012\u0004\u0012\u00028\u000008J\u0010\u0010;\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020\u0006J\u0014\u0010?\u001a\u00020\u00022\f\u0010>\u001a\b\u0012\u0004\u0012\u00020=0\u0019J\u000e\u0010B\u001a\u00020\u00022\u0006\u0010A\u001a\u00020@J\u000e\u0010C\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010E\u001a\u00020\u00022\u0006\u0010D\u001a\u00020\u00142\u0006\u0010\u0011\u001a\u00020\u0010J\u001e\u0010I\u001a\u00020G2\u0006\u0010F\u001a\u00020\u00062\u0006\u0010H\u001a\u00020G2\u0006\u0010\u0011\u001a\u00020\u0010J\u0016\u0010L\u001a\u00020\u00022\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010\u0019R\u0014\u0010N\u001a\u00020\u00048\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b$\u0010MR\u0016\u0010Q\u001a\u00020O8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b*\u0010PR\u0014\u0010U\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bS\u0010TR\u0014\u0010V\u001a\u00020R8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010TR\"\u0010]\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010@8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010^R$\u0010f\u001a\u0004\u0018\u00010`8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bB\u0010a\u001a\u0004\bb\u0010c\"\u0004\bd\u0010eR\u0014\u0010i\u001a\u00020g8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010hR\u0016\u0010j\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\u001d\u00a8\u0006m"}, d2 = {"Lpd4/b;", "", "", "D", "", h.F, "", TemplateParser.KEY_ENTITY_ID, "i", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "l", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "y", HippyQQConstants.URL_COMPONENT_NAME, HippyTKDListViewAdapter.X, "Lcom/tencent/tavcut/model/Painting;", "backGround", "", "o", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "u", "", "Lcom/tencent/tavcut/model/ClipSource;", "clips", "modifyClipsDuration", "I", "J", "p", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "f", "sourceKey", "a", "originEntityId", "M", "w", "parentId", "index", "b", "d", "v", "(I)V", "G", BdhLogUtil.LogTag.Tag_Conn, "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "k", "j", "H", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, DomainData.DOMAIN_NAME, "T", "Lkotlin/reflect/KClass;", "clazz", "E", UserInfo.SEX_FEMALE, "r", "Lcom/tencent/tavcut/composition/model/component/Timeline;", "timeLine", "O", "Lpd4/a;", "listener", "g", "N", "identifyComponent", "t", "componentId", "Lcom/tencent/tavcut/composition/model/component/MultiMedia;", "originMultiMedia", "P", "Lcom/tencent/tavcut/rendermodel/VoiceEnum;", DownloadInfo.spKey_Config, "L", "Z", "enableDynamicEntity", "Lpd4/c;", "Lpd4/c;", "mutableRenderModel", "Ljava/util/concurrent/atomic/AtomicInteger;", "c", "Ljava/util/concurrent/atomic/AtomicInteger;", "entityIdGenerator", "componentIdGenerator", "e", "Ljava/lang/String;", ReportConstant.COSTREPORT_PREFIX, "()Ljava/lang/String;", "setTemplateDir", "(Ljava/lang/String;)V", "templateDir", "Lpd4/a;", "dataChangeListener", "Lzd4/b;", "Lzd4/b;", "getRenderChainManager", "()Lzd4/b;", "K", "(Lzd4/b;)V", "renderChainManager", "Lpd4/b$a;", "Lpd4/b$a;", "commandQueue", VasWebviewConstants.KEY_UPDATE_FLAG, "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private pd4.a dataChangeListener;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private zd4.b renderChainManager;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int updateFlag;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final boolean enableDynamicEntity = true;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private pd4.c mutableRenderModel = new pd4.c(new RenderModel(null, null, null, null, null, false, 0, null, null, null, 0, 0, null, null, 16383, null));

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger entityIdGenerator = new AtomicInteger(0);

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final AtomicInteger componentIdGenerator = new AtomicInteger(0);

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private String templateDir = "/";

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final a commandQueue = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010!\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0006\u001a\u00020\u0004J\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\n\u00a8\u0006\u000e"}, d2 = {"Lpd4/b$a;", "", "Lpd4/b$c;", "command", "", "c", "a", "", "b", "", "Ljava/util/List;", SemanticAttributes.MessagingDestinationKindValues.QUEUE, "<init>", "()V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        private final List<c> queue = new ArrayList();

        public final synchronized void a() {
            this.queue.clear();
        }

        @NotNull
        public final synchronized List<c> b() {
            List<c> list;
            list = CollectionsKt___CollectionsKt.toList(this.queue);
            return list;
        }

        public final synchronized void c(@NotNull c command) {
            Intrinsics.checkParameterIsNotNull(command, "command");
            synchronized (this) {
                this.queue.add(command);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\bb\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u00a8\u0006\u0006"}, d2 = {"Lpd4/b$c;", "", "a", "b", "c", "d", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes26.dex */
    public interface c {

        /* compiled from: P */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0010\u001a\u00020\u0004\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0015\u0010\u0016J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u000b\u001a\u0004\b\n\u0010\rR\u0017\u0010\u0014\u001a\u00020\u00118\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0012\u001a\u0004\b\u000f\u0010\u0013\u00a8\u0006\u0017"}, d2 = {"Lpd4/b$c$a;", "Lpd4/b$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "c", "()I", "parentId", "b", "childIndex", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "()Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "<init>", "(IILcom/tencent/tavcut/rendermodel/entity/Entity;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: pd4.b$c$a, reason: from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class AddEntity implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int parentId;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            private final int childIndex;

            /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final Entity entity;

            public AddEntity(int i3, int i16, @NotNull Entity entity) {
                Intrinsics.checkParameterIsNotNull(entity, "entity");
                this.parentId = i3;
                this.childIndex = i16;
                this.entity = entity;
            }

            /* renamed from: a, reason: from getter */
            public final int getChildIndex() {
                return this.childIndex;
            }

            @NotNull
            /* renamed from: b, reason: from getter */
            public final Entity getEntity() {
                return this.entity;
            }

            /* renamed from: c, reason: from getter */
            public final int getParentId() {
                return this.parentId;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (other instanceof AddEntity) {
                        AddEntity addEntity = (AddEntity) other;
                        if (this.parentId != addEntity.parentId || this.childIndex != addEntity.childIndex || !Intrinsics.areEqual(this.entity, addEntity.entity)) {
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
                int i16 = ((this.parentId * 31) + this.childIndex) * 31;
                Entity entity = this.entity;
                if (entity != null) {
                    i3 = entity.hashCode();
                } else {
                    i3 = 0;
                }
                return i16 + i3;
            }

            @NotNull
            public String toString() {
                return "AddEntity(parentId=" + this.parentId + ", childIndex=" + this.childIndex + ", entity=" + this.entity + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\r\u001a\u00020\u0004\u00a2\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\f\u00a8\u0006\u0010"}, d2 = {"Lpd4/b$c$b;", "Lpd4/b$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "()I", TemplateParser.KEY_ENTITY_ID, "<init>", "(I)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: pd4.b$c$b, reason: collision with other inner class name and from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class RemoveEntity implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int entityId;

            public RemoveEntity(int i3) {
                this.entityId = i3;
            }

            /* renamed from: a, reason: from getter */
            public final int getEntityId() {
                return this.entityId;
            }

            public boolean equals(@Nullable Object other) {
                if (this != other) {
                    if (!(other instanceof RemoveEntity) || this.entityId != ((RemoveEntity) other).entityId) {
                        return false;
                    }
                    return true;
                }
                return true;
            }

            public int hashCode() {
                return this.entityId;
            }

            @NotNull
            public String toString() {
                return "RemoveEntity(entityId=" + this.entityId + ")";
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u000e\u001a\u00020\u0004\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0013\u0010\u0014J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u000f8\u0006\u00a2\u0006\f\n\u0004\b\f\u0010\u0010\u001a\u0004\b\n\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lpd4/b$c$c;", "Lpd4/b$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "a", "I", "b", "()I", TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "()Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", HippyQQConstants.URL_COMPONENT_NAME, "<init>", "(ILcom/tencent/tavcut/rendermodel/component/IdentifyComponent;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: pd4.b$c$c, reason: collision with other inner class name and from toString */
        /* loaded from: classes26.dex */
        public static final /* data */ class UpdateComponent implements c {

            /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
            private final int entityId;

            /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
            @NotNull
            private final IdentifyComponent component;

            public UpdateComponent(int i3, @NotNull IdentifyComponent component) {
                Intrinsics.checkParameterIsNotNull(component, "component");
                this.entityId = i3;
                this.component = component;
            }

            @NotNull
            /* renamed from: a, reason: from getter */
            public final IdentifyComponent getComponent() {
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
                IdentifyComponent identifyComponent = this.component;
                if (identifyComponent != null) {
                    i3 = identifyComponent.hashCode();
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
        @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\n\u00a2\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\n8\u0006\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lpd4/b$c$d;", "Lpd4/b$c;", "", "toString", "", "hashCode", "", "other", "", "equals", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "a", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "()Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "<init>", "(Lcom/tencent/tavcut/composition/model/component/InputSource;)V", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
        /* renamed from: pd4.b$c$d, reason: from toString */
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
    }

    private final void D() {
        if (h()) {
            this.updateFlag |= 4;
        }
    }

    public static /* synthetic */ Entity c(b bVar, Entity entity, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = -1;
        }
        return bVar.b(entity, i3, i16);
    }

    public static /* synthetic */ Entity e(b bVar, Entity entity, int i3, int i16, int i17, Object obj) {
        if ((i17 & 4) != 0) {
            i16 = -1;
        }
        return bVar.d(entity, i3, i16);
    }

    private final boolean h() {
        return !this.mutableRenderModel.k().isEmpty();
    }

    private final boolean i(int entityId) {
        Entity q16 = this.mutableRenderModel.q(entityId);
        if (q16 != null) {
            for (IdentifyComponent identifyComponent : q16.getComponents()) {
                if (identifyComponent.getData() instanceof Transition) {
                    Object data = identifyComponent.getData();
                    if (data != null) {
                        if (w(entityId, IdentifyComponent.copy$default(identifyComponent, null, null, Transition.copy$default((Transition) data, null, null, null, null, null, null, "", 0L, null, null, QCircleReportHelper.SCENE_PAGE_ID_NEW_POLYMERIZE_DETAIL_GROUP_PAGE, null), null, 11, null))) {
                            C();
                            return true;
                        }
                        return true;
                    }
                    throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.Transition");
                }
            }
            return false;
        }
        return false;
    }

    private final int l() {
        return this.componentIdGenerator.incrementAndGet();
    }

    private final int m() {
        return this.entityIdGenerator.incrementAndGet();
    }

    private final String o(Painting backGround) {
        if (backGround.backgroundFillMode == BackgroundFillMode.PAG) {
            return backGround.pagPath;
        }
        return null;
    }

    private final boolean x(Object component) {
        return !(component instanceof CustomGraph);
    }

    private final boolean y(Entity entity) {
        if (!this.enableDynamicEntity) {
            return false;
        }
        Iterator<T> it = entity.getComponents().iterator();
        while (it.hasNext()) {
            KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(((IdentifyComponent) it.next()).getData().getClass());
            if (!Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(EntityIdentifier.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Priority.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(PAGAsset.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(TimeOffset.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(ScreenTransform.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(LUTFilter.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(AITextureComponent.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(SubAssetComponent.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Image.class)) && !Intrinsics.areEqual(orCreateKotlinClass, Reflection.getOrCreateKotlinClass(Transition.class))) {
                return false;
            }
        }
        Iterator<T> it5 = entity.getChildren().iterator();
        boolean z16 = true;
        while (it5.hasNext()) {
            z16 &= y((Entity) it5.next());
        }
        return z16;
    }

    private final boolean z(IdentifyComponent component) {
        if (component.getData() instanceof PAGAsset) {
            Object data = component.getData();
            if (data != null) {
                Iterator<T> it = ((PAGAsset) data).replacement.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((PAGAsset.Replacement) it.next()).src, "videoSource")) {
                        return true;
                    }
                }
                return false;
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.PAGAsset");
        }
        return false;
    }

    public final boolean A() {
        if ((this.updateFlag & 2) != 0) {
            return true;
        }
        return false;
    }

    public final boolean B() {
        if ((this.updateFlag & 4) != 0) {
            return true;
        }
        return false;
    }

    public final void C() {
        if (h()) {
            this.updateFlag |= 2;
        }
    }

    @NotNull
    public final <T> List<Entity> E(@NotNull KClass<T> clazz) {
        Intrinsics.checkParameterIsNotNull(clazz, "clazz");
        pd4.c cVar = this.mutableRenderModel;
        String qualifiedName = clazz.getQualifiedName();
        if (qualifiedName == null) {
            qualifiedName = "";
        }
        return cVar.p(qualifiedName);
    }

    @Nullable
    public final Entity F(int entityId) {
        return this.mutableRenderModel.q(entityId);
    }

    public final void G(int entityId) {
        if (i(entityId)) {
            return;
        }
        synchronized (this.commandQueue) {
            Entity F = F(entityId);
            if (F != null) {
                this.mutableRenderModel.t(entityId);
                if (y(F)) {
                    this.commandQueue.c(new c.RemoveEntity(entityId));
                } else {
                    C();
                }
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void H() {
        this.updateFlag = 0;
        this.commandQueue.a();
    }

    public final void I(@NotNull List<ClipSource> clips, boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        boolean isEmpty = this.mutableRenderModel.k().isEmpty();
        this.mutableRenderModel.v(clips, modifyClipsDuration);
        ee4.b.b("RenderDataDispatcher", "RenderDataDispatcher setClipAssets isInit: " + isEmpty);
        if (isEmpty) {
            D();
        } else {
            C();
        }
    }

    public final void J(@NotNull List<ClipSource> clips, boolean modifyClipsDuration) {
        Intrinsics.checkParameterIsNotNull(clips, "clips");
        this.mutableRenderModel.v(clips, modifyClipsDuration);
        pd4.a aVar = this.dataChangeListener;
        if (aVar != null) {
            aVar.setClipAssetsWithCallback(clips, modifyClipsDuration);
        }
    }

    public final void K(@Nullable zd4.b bVar) {
        this.renderChainManager = bVar;
    }

    public final void L(@Nullable List<? extends VoiceEnum> config) {
        pd4.a aVar;
        if (this.mutableRenderModel.x(config) && (aVar = this.dataChangeListener) != null) {
            aVar.m(config);
        }
    }

    public final void M(int originEntityId, @NotNull IdentifyComponent component) {
        List<IdentifyComponent> list;
        Intrinsics.checkParameterIsNotNull(component, "component");
        ee4.b.a("RenderDataDispatcher", "updateComponent begin originID " + originEntityId + " component: " + component.getData());
        if (!w(originEntityId, IdentifyComponent.copy$default(component, null, null, null, null, 15, null)) || !h()) {
            return;
        }
        Entity q16 = this.mutableRenderModel.q(originEntityId);
        Object obj = null;
        if (q16 != null) {
            list = q16.getComponents();
        } else {
            list = null;
        }
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(((IdentifyComponent) next).getData().getClass()), Reflection.getOrCreateKotlinClass(component.getData().getClass()))) {
                    obj = next;
                    break;
                }
            }
            IdentifyComponent identifyComponent = (IdentifyComponent) obj;
            if (identifyComponent != null) {
                if (x(identifyComponent.getData())) {
                    this.commandQueue.c(new c.UpdateComponent(originEntityId, identifyComponent));
                } else {
                    C();
                }
            }
        }
    }

    public final void N(@NotNull Painting backGround) {
        ScreenTransform screenTransform;
        Intrinsics.checkParameterIsNotNull(backGround, "backGround");
        if (!this.mutableRenderModel.w(backGround)) {
            return;
        }
        for (Entity entity : E(Reflection.getOrCreateKotlinClass(MultiMedia.class))) {
            for (IdentifyComponent identifyComponent : entity.getComponents()) {
                Object data = identifyComponent.getData();
                if (data instanceof ScreenTransform) {
                    Object data2 = identifyComponent.getData();
                    if (data2 != null) {
                        ScreenTransform screenTransform2 = (ScreenTransform) data2;
                        ScreenTransform screenTransform3 = backGround.screenTransform;
                        if (screenTransform3 != null) {
                            screenTransform = screenTransform3;
                        } else {
                            screenTransform = screenTransform2;
                        }
                        if (!Intrinsics.areEqual(screenTransform2, screenTransform)) {
                            M(entity.getId(), IdentifyComponent.copy$default(identifyComponent, null, null, screenTransform, null, 11, null));
                        }
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.ScreenTransform");
                    }
                } else if (data instanceof MultiMedia) {
                    t(identifyComponent, backGround);
                }
            }
        }
    }

    public final void O(@NotNull List<Timeline> timeLine) {
        Intrinsics.checkParameterIsNotNull(timeLine, "timeLine");
        Iterator<T> it = timeLine.iterator();
        while (it.hasNext()) {
            ee4.b.a("RenderDataDispatcher", "updateTimeLine time " + ((Timeline) it.next()).range);
        }
        this.mutableRenderModel.A(timeLine);
    }

    @NotNull
    public final MultiMedia P(int componentId, @NotNull MultiMedia originMultiMedia, @NotNull Painting backGround) {
        Integer num;
        boolean z16;
        String str;
        String str2;
        MultiMedia copy;
        Intrinsics.checkParameterIsNotNull(originMultiMedia, "originMultiMedia");
        Intrinsics.checkParameterIsNotNull(backGround, "backGround");
        String o16 = o(backGround);
        if (!Intrinsics.areEqual(originMultiMedia.size, backGround.renderSize)) {
            D();
        }
        BackgroundFillMode backgroundFillMode = backGround.backgroundFillMode;
        if (backgroundFillMode != null) {
            num = Integer.valueOf(backgroundFillMode.getValue());
        } else {
            num = null;
        }
        Integer num2 = num;
        if (o16 != null && o16.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (!z16) {
            str = "";
        } else {
            str = backGround.backgroundColor;
        }
        if (o16 == null) {
            str2 = "";
        } else {
            str2 = o16;
        }
        copy = originMultiMedia.copy((r42 & 1) != 0 ? originMultiMedia.entityId : null, (r42 & 2) != 0 ? originMultiMedia.componentID : null, (r42 & 4) != 0 ? originMultiMedia.enabled : null, (r42 & 8) != 0 ? originMultiMedia.type : null, (r42 & 16) != 0 ? originMultiMedia.fillScale : backGround.fillScale, (r42 & 32) != 0 ? originMultiMedia.imageDurations : null, (r42 & 64) != 0 ? originMultiMedia.imageEffect : null, (r42 & 128) != 0 ? originMultiMedia.key : null, (r42 & 256) != 0 ? originMultiMedia.maxSourceCount : null, (r42 & 512) != 0 ? originMultiMedia.minDuration : null, (r42 & 1024) != 0 ? originMultiMedia.minSourceCount : null, (r42 & 2048) != 0 ? originMultiMedia.scaleMode : null, (r42 & 4096) != 0 ? originMultiMedia.size : backGround.renderSize, (r42 & 8192) != 0 ? originMultiMedia.speed : null, (r42 & 16384) != 0 ? originMultiMedia.src : null, (r42 & 32768) != 0 ? originMultiMedia.version : null, (r42 & 65536) != 0 ? originMultiMedia.volume : null, (r42 & 131072) != 0 ? originMultiMedia.backgroundColor : str, (r42 & 262144) != 0 ? originMultiMedia.backgroundFillMode : num2, (r42 & 524288) != 0 ? originMultiMedia.volumeEffects : null, (r42 & 1048576) != 0 ? originMultiMedia.backgroundPagPath : str2, (r42 & 2097152) != 0 ? originMultiMedia.resLoopCount : null, (r42 & 4194304) != 0 ? originMultiMedia.visibleWhileOverTime : null, (r42 & 8388608) != 0 ? originMultiMedia.unknownFields() : null);
        Size size = copy.size;
        if (size != null) {
            this.mutableRenderModel.z(size);
        }
        if (!Intrinsics.areEqual(copy, originMultiMedia)) {
            this.mutableRenderModel.y(componentId, copy);
        }
        return copy;
    }

    @Nullable
    public final InputSource a(@Nullable String sourceKey) {
        if (sourceKey != null) {
            return this.mutableRenderModel.a(sourceKey);
        }
        return null;
    }

    @NotNull
    public final Entity b(@NotNull Entity entity, int parentId, int index) {
        Entity d16;
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        synchronized (this.commandQueue) {
            d16 = d(entity, parentId, index);
            if (y(d16)) {
                this.commandQueue.c(new c.AddEntity(parentId, this.mutableRenderModel.r(d16.getId()), d16));
            } else {
                C();
            }
        }
        return d16;
    }

    @NotNull
    public final Entity d(@NotNull Entity entity, int parentId, int index) {
        Intrinsics.checkParameterIsNotNull(entity, "entity");
        int m3 = m();
        Entity copy$default = Entity.copy$default(entity, m3, null, null, null, false, 0, 62, null);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = entity.getComponents().iterator();
        while (it.hasNext()) {
            arrayList.add(IdentifyComponent.copy$default((IdentifyComponent) it.next(), Integer.valueOf(l()), Integer.valueOf(m3), null, null, 12, null));
        }
        Entity copy$default2 = Entity.copy$default(copy$default, 0, null, null, arrayList, false, 0, 55, null);
        this.mutableRenderModel.c(parentId, copy$default2, index);
        return copy$default2;
    }

    public final void f(@NotNull InputSource inputSource) {
        Intrinsics.checkParameterIsNotNull(inputSource, "inputSource");
        synchronized (this.commandQueue) {
            boolean z16 = !Intrinsics.areEqual(inputSource, a(inputSource.key));
            this.mutableRenderModel.f(inputSource);
            if (z16) {
                if (this.enableDynamicEntity) {
                    this.commandQueue.c(new c.UpdateInputSource(inputSource));
                } else {
                    C();
                }
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void g(@NotNull pd4.a listener) {
        Intrinsics.checkParameterIsNotNull(listener, "listener");
        this.dataChangeListener = listener;
    }

    public final void j() {
        long j3;
        zd4.b bVar;
        zd4.b bVar2;
        synchronized (this.commandQueue) {
            List<c> b16 = this.commandQueue.b();
            for (c cVar : b16) {
                if ((cVar instanceof c.UpdateInputSource) && (bVar2 = this.renderChainManager) != null) {
                    bVar2.g(((c.UpdateInputSource) cVar).getInputSource());
                }
            }
            for (c cVar2 : b16) {
                if (cVar2 instanceof c.UpdateComponent) {
                    zd4.b bVar3 = this.renderChainManager;
                    if (bVar3 != null) {
                        bVar3.c(((c.UpdateComponent) cVar2).getEntityId(), ((c.UpdateComponent) cVar2).getComponent());
                    }
                } else if (cVar2 instanceof c.AddEntity) {
                    zd4.b bVar4 = this.renderChainManager;
                    if (bVar4 != null) {
                        bVar4.e(((c.AddEntity) cVar2).getParentId(), ((c.AddEntity) cVar2).getChildIndex(), ((c.AddEntity) cVar2).getEntity());
                    }
                } else if ((cVar2 instanceof c.RemoveEntity) && (bVar = this.renderChainManager) != null) {
                    bVar.a(((c.RemoveEntity) cVar2).getEntityId());
                }
            }
            this.commandQueue.a();
            zd4.b bVar5 = this.renderChainManager;
            if (bVar5 != null) {
                j3 = bVar5.getMovieControllerDuration();
            } else {
                j3 = 0;
            }
            zd4.b bVar6 = this.renderChainManager;
            if (bVar6 != null) {
                bVar6.f(j3);
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final void k() {
        this.updateFlag |= 4;
    }

    @NotNull
    public final RenderModel n() {
        return this.mutableRenderModel.j();
    }

    @NotNull
    public final List<ClipSource> p() {
        return this.mutableRenderModel.k();
    }

    @NotNull
    public final RenderModel q() {
        return this.mutableRenderModel.n();
    }

    public final int r() {
        return this.mutableRenderModel.getRenderRootId();
    }

    @NotNull
    /* renamed from: s, reason: from getter */
    public final String getTemplateDir() {
        return this.templateDir;
    }

    public final void t(@NotNull IdentifyComponent identifyComponent, @NotNull Painting backGround) {
        MultiMedia multiMedia;
        Intrinsics.checkParameterIsNotNull(identifyComponent, "identifyComponent");
        Intrinsics.checkParameterIsNotNull(backGround, "backGround");
        Object data = identifyComponent.getData();
        if (data != null) {
            MultiMedia multiMedia2 = (MultiMedia) data;
            Integer id5 = identifyComponent.getId();
            if (id5 != null) {
                multiMedia = P(id5.intValue(), multiMedia2, backGround);
            } else {
                multiMedia = null;
            }
            if (!Intrinsics.areEqual(multiMedia2, multiMedia) && h()) {
                C();
                return;
            }
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.tavcut.composition.model.component.MultiMedia");
    }

    public final void u(@NotNull RenderModel renderModel) {
        Intrinsics.checkParameterIsNotNull(renderModel, "renderModel");
        ee4.b.b("RenderDataDispatcher", "RenderDataDispatcher initRenderModel");
        pd4.c cVar = new pd4.c(renderModel);
        this.mutableRenderModel = cVar;
        this.entityIdGenerator.set(cVar.m());
        this.componentIdGenerator.set(this.mutableRenderModel.l());
        D();
    }

    public final void v(int entityId) {
        this.mutableRenderModel.t(entityId);
    }

    public final boolean w(int originEntityId, @NotNull IdentifyComponent component) {
        List<IdentifyComponent> components;
        Intrinsics.checkParameterIsNotNull(component, "component");
        ee4.b.a("RenderDataDispatcher", "internalUpdateComponent start=====");
        Entity q16 = this.mutableRenderModel.q(originEntityId);
        if (q16 != null && (components = q16.getComponents()) != null) {
            for (IdentifyComponent identifyComponent : components) {
                if (z(identifyComponent)) {
                    C();
                }
                if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(identifyComponent.getData().getClass()), Reflection.getOrCreateKotlinClass(component.getData().getClass())) && (!Intrinsics.areEqual(identifyComponent.getData(), component.getData()))) {
                    ee4.b.a("RenderDataDispatcher", "internalUpdateComponent component id: " + component.getData());
                    Object data = component.getData();
                    if (data instanceof AudioSource) {
                        AudioSource audioSource = (AudioSource) data;
                        if (audioSource.entityId == null && audioSource.componentID == null && audioSource.audioSourceType == null) {
                            data = AudioSource.copy$default(audioSource, identifyComponent.getEntityId(), identifyComponent.getId(), null, null, null, null, null, null, null, 0, null, null, 3580, null);
                        }
                    }
                    Integer id5 = identifyComponent.getId();
                    if (id5 != null) {
                        this.mutableRenderModel.y(id5.intValue(), data);
                    }
                    return true;
                }
            }
        }
        ee4.b.a("RenderDataDispatcher", "internalUpdateComponent end=====");
        return false;
    }
}
