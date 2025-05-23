package com.tencent.videocut.render;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.utils.n;
import com.tencent.mobileqq.wink.utils.w;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.ComponentBase;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.PAGAsset;
import org.light.lightAssetKit.components.ReplaceItem;
import org.light.lightAssetKit.enums.ReplaceType;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 =2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002>?B\u000f\u0012\u0006\u0010.\u001a\u00020,\u00a2\u0006\u0004\b;\u0010<J6\u0010\f\u001a\u00020\n2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0004\u0012\u00020\n0\bH\u0002J\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016J*\u0010\u0016\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0018\u0010\u000b\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0012\u0004\u0012\u00020\n0\bJ\u0006\u0010\u0017\u001a\u00020\nJ\u0014\u0010\u0019\u001a\u00020\n2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013J\u0016\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002J\u0010\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0003H\u0016J\u0016\u0010 \u001a\u00020\n2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020\u0013H\u0014J\u0010\u0010!\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u0005H\u0016J\u0010\u0010#\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u0011H\u0016J\"\u0010$\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001b\u001a\u00020\u0002H\u0016J\u0010\u0010%\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0018\u0010+\u001a\u00020*2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010)\u001a\u00020\u0002H\u0016R\u0014\u0010.\u001a\u00020,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010-R\u0016\u00101\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u00103R\"\u0010:\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020706058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b8\u00109\u00a8\u0006@"}, d2 = {"Lcom/tencent/videocut/render/TemplateTextRenderHelper;", "Lcom/tencent/videocut/render/a;", "Lcom/tencent/videocut/model/StickerModel;", "Lcom/tencent/videocut/render/TemplateTextRenderHelper$b;", "", "Lorg/light/lightAssetKit/Entity;", "Lorg/light/lightAssetKit/components/PAGAsset;", "pagAssetMap", "Lkotlin/Function1;", "", "", "callback", "D", "entity", "", TemplateParser.KEY_ENTITY_ID, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "rootEntity", "I", "H", "stickerModelList", "G", "oldData", "newData", "K", "data", "y", "items", "p", "removeEntity", "mediaModel", "d", "J", BdhLogUtil.LogTag.Tag_Conn, "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", "B", "Lcom/tencent/tavcut/core/session/ICutSession;", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "e", "Z", "forceUpdate", "f", "Lorg/light/lightAssetKit/Entity;", "mRootEntity", "", "Lmqq/util/WeakReference;", "Lorg/light/lightAssetKit/ComponentBase;", "g", "Ljava/util/Set;", "mPagAssetWeakRefSet", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", tl.h.F, "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class TemplateTextRenderHelper extends a<StickerModel, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean forceUpdate;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Entity mRootEntity;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<WeakReference<ComponentBase>> mPagAssetWeakRefSet;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/render/TemplateTextRenderHelper$a;", "", "", "NAME_ID_SEPARATOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.TemplateTextRenderHelper$a, reason: from kotlin metadata */
    /* loaded from: classes27.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u0017\u0010\u0011\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000e\u0010\u0010R\u0017\u0010\u0017\u001a\u00020\u00128\u0006\u00a2\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/render/TemplateTextRenderHelper$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/light/lightAssetKit/Entity;", "a", "Lorg/light/lightAssetKit/Entity;", "()Lorg/light/lightAssetKit/Entity;", "entity", "b", "I", "()I", TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/videocut/model/StickerModel;", "c", "Lcom/tencent/videocut/model/StickerModel;", "getModel", "()Lcom/tencent/videocut/model/StickerModel;", "model", "<init>", "(Lorg/light/lightAssetKit/Entity;ILcom/tencent/videocut/model/StickerModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Entity entity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        private final int entityId;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final StickerModel model;

        public b(@NotNull Entity entity, int i3, @NotNull StickerModel model) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(model, "model");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, entity, Integer.valueOf(i3), model);
                return;
            }
            this.entity = entity;
            this.entityId = i3;
            this.model = model;
        }

        @NotNull
        public final Entity a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Entity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.entity;
        }

        public final int b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.entityId;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
                return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.entity, bVar.entity) && this.entityId == bVar.entityId && Intrinsics.areEqual(this.model, bVar.model)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
                return ((Integer) iPatchRedirector.redirect((short) 11, (Object) this)).intValue();
            }
            return (((this.entity.hashCode() * 31) + this.entityId) * 31) + this.model.hashCode();
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
                return (String) iPatchRedirector.redirect((short) 10, (Object) this);
            }
            return "RenderData(entity=" + this.entity + ", entityId=" + this.entityId + ", model=" + this.model + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class c<T> implements Comparator {
        static IPatchRedirector $redirector_;

        public c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T t16, T t17) {
            int compareValues;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                compareValues = ComparisonsKt__ComparisonsKt.compareValues(((StickerModel) t16).id, ((StickerModel) t17).id);
                return compareValues;
            }
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59778);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TemplateTextRenderHelper(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
            this.mPagAssetWeakRefSet = new LinkedHashSet();
        }
    }

    private final void D(Map<Entity, ? extends PAGAsset> pagAssetMap, final Function1<? super List<Entity>, Unit> callback) {
        final int size = pagAssetMap.size();
        final ArrayList arrayList = new ArrayList();
        for (Map.Entry<Entity, ? extends PAGAsset> entry : pagAssetMap.entrySet()) {
            final Entity key = entry.getKey();
            final PAGAsset value = entry.getValue();
            w53.b.a("TemplateTextRenderHelper", "add pagAsset to set");
            this.mPagAssetWeakRefSet.add(new WeakReference<>(value));
            value.setComponentUpdateListener(new ComponentBase.ComponentUpdateListener() { // from class: com.tencent.videocut.render.r
                @Override // org.light.lightAssetKit.ComponentBase.ComponentUpdateListener
                public final void onComponentUpdate(ComponentBase componentBase) {
                    TemplateTextRenderHelper.E(PAGAsset.this, arrayList, key, size, this, callback, componentBase);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E(final PAGAsset pagAsset, final List assetEntityList, final Entity entity, final int i3, final TemplateTextRenderHelper this$0, final Function1 callback, final ComponentBase componentBase) {
        Intrinsics.checkNotNullParameter(pagAsset, "$pagAsset");
        Intrinsics.checkNotNullParameter(assetEntityList, "$assetEntityList");
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.videocut.render.s
            @Override // java.lang.Runnable
            public final void run() {
                TemplateTextRenderHelper.F(ComponentBase.this, pagAsset, assetEntityList, entity, i3, this$0, callback);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void F(ComponentBase componentBase, PAGAsset pagAsset, List assetEntityList, Entity entity, int i3, TemplateTextRenderHelper this$0, Function1 callback) {
        Object orNull;
        String str;
        Intrinsics.checkNotNullParameter(pagAsset, "$pagAsset");
        Intrinsics.checkNotNullParameter(assetEntityList, "$assetEntityList");
        Intrinsics.checkNotNullParameter(entity, "$entity");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNull(componentBase, "null cannot be cast to non-null type org.light.lightAssetKit.components.PAGAsset");
        pagAsset.setReplacement(((PAGAsset) componentBase).getReplacement());
        ArrayList<ReplaceItem> replacement = pagAsset.getReplacement();
        Intrinsics.checkNotNullExpressionValue(replacement, "pagAsset.replacement");
        orNull = CollectionsKt___CollectionsKt.getOrNull(replacement, 0);
        ReplaceItem replaceItem = (ReplaceItem) orNull;
        if (replaceItem != null) {
            str = replaceItem.src;
        } else {
            str = null;
        }
        w53.b.a("TemplateTextRenderHelper", " isTextComponent text:" + str);
        assetEntityList.add(entity);
        if (assetEntityList.size() == i3) {
            this$0.tavCutSession.notifyReloadAsset();
            callback.invoke(assetEntityList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Entity z(Entity entity, int entityId) {
        if (entity == null) {
            return null;
        }
        if (entity.getId() == entityId) {
            return entity;
        }
        List<Entity> children = entity.getChildren();
        if (children == null) {
            return null;
        }
        Iterator<Entity> it = children.iterator();
        while (it.hasNext()) {
            Entity z16 = z(it.next(), entityId);
            if (z16 != null) {
                return z16;
            }
        }
        return null;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull StickerModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.videocut.render.a
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull StickerModel newModel, @NotNull StickerModel oldModel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return ((Boolean) iPatchRedirector.redirect((short) 14, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        if (newModel.centerX == oldModel.centerX) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            if (newModel.centerY == oldModel.centerY) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                if (newModel.scaleX == oldModel.scaleX) {
                    z18 = true;
                } else {
                    z18 = false;
                }
                if (z18) {
                    if (newModel.scaleY == oldModel.scaleY) {
                        z19 = true;
                    } else {
                        z19 = false;
                    }
                    if (z19) {
                        if (newModel.rotate == oldModel.rotate) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        if (z26 && newModel.width == oldModel.width && newModel.height == oldModel.height && newModel.startTime == oldModel.startTime && newModel.duration == oldModel.duration && Intrinsics.areEqual(newModel.filePath, oldModel.filePath) && newModel.layerIndex == oldModel.layerIndex && Intrinsics.areEqual(newModel.textItems, oldModel.textItems) && !this.forceUpdate) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public b q(@NotNull StickerModel model) {
        boolean isBlank;
        boolean isBlank2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (b) iPatchRedirector.redirect((short) 12, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        for (TextItem textItem : model.textItems) {
            w.a d16 = w.e().d(textItem.fontFamily);
            if (d16 == null || Intrinsics.areEqual(d16.f326735c, textItem.fontStyle)) {
                isBlank = StringsKt__StringsJVMKt.isBlank(textItem.fontPath);
                if (!isBlank) {
                    this.tavCutSession.registerFont(textItem.fontFamily, textItem.fontStyle, textItem.fontPath);
                }
            } else {
                String str = d16.f326736d;
                Intrinsics.checkNotNullExpressionValue(str, "fontInfo.fontPath");
                isBlank2 = StringsKt__StringsJVMKt.isBlank(str);
                if (!isBlank2) {
                    ICutSession iCutSession = this.tavCutSession;
                    String str2 = d16.f326734b;
                    Intrinsics.checkNotNullExpressionValue(str2, "fontInfo.fontFamily");
                    String str3 = textItem.fontStyle;
                    String str4 = d16.f326736d;
                    Intrinsics.checkNotNullExpressionValue(str4, "fontInfo.fontPath");
                    iCutSession.registerFont(str2, str3, str4);
                }
            }
        }
        return com.tencent.videocut.render.extension.f.x(model);
    }

    public final void G(@NotNull List<? extends StickerModel> stickerModelList) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) stickerModelList);
            return;
        }
        Intrinsics.checkNotNullParameter(stickerModelList, "stickerModelList");
        ArrayList arrayList = new ArrayList();
        for (Object obj : stickerModelList) {
            StickerModel.Type type = ((StickerModel) obj).type;
            if (type != StickerModel.Type.TEXT_TEMPLATE && type != StickerModel.Type.IMAGE_TEMPLATE) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            try {
                final int intValue = com.tencent.videocut.render.extension.f.i((StickerModel) it.next()).component2().intValue();
                this.tavCutSession.pushCustomCommandSync(new Function1<ICutSession, Unit>(intValue) { // from class: com.tencent.videocut.render.TemplateTextRenderHelper$removeTemplateStickers$2$1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ int $entityId;

                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                        this.$entityId = intValue;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TemplateTextRenderHelper.this, intValue);
                        }
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(ICutSession iCutSession) {
                        invoke2(iCutSession);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(@NotNull ICutSession pushCustomCommandSync) {
                        Entity z17;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pushCustomCommandSync);
                            return;
                        }
                        Intrinsics.checkNotNullParameter(pushCustomCommandSync, "$this$pushCustomCommandSync");
                        Entity rootEntity = pushCustomCommandSync.getRootEntity();
                        z17 = TemplateTextRenderHelper.this.z(rootEntity, this.$entityId);
                        w53.b.c("TemplateTextRenderHelper", "onRemoved: entity by id : " + this.$entityId + "\uff0c " + rootEntity);
                        if (z17 == null) {
                            w53.b.c("TemplateTextRenderHelper", "onRemoved: can not find entity by id : " + this.$entityId);
                            return;
                        }
                        pushCustomCommandSync.removeEntity(z17);
                    }
                });
            } catch (Exception e16) {
                w53.b.d("TemplateTextRenderHelper", "removeTemplateSticker: splite Id fail", e16);
                return;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        w53.b.a("TemplateTextRenderHelper", "removeTemplateTextEntityCallback pagAssetRef size :" + this.mPagAssetWeakRefSet.size());
        Iterator<T> it = this.mPagAssetWeakRefSet.iterator();
        while (it.hasNext()) {
            ComponentBase componentBase = (ComponentBase) ((WeakReference) it.next()).get();
            if (componentBase != null) {
                componentBase.setComponentUpdateListener(null);
            }
        }
        this.mPagAssetWeakRefSet.clear();
    }

    public final void I(@Nullable Entity rootEntity, @NotNull Function1<? super List<Entity>, Unit> callback) {
        List<Entity> emptyList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) rootEntity, (Object) callback);
            return;
        }
        Intrinsics.checkNotNullParameter(callback, "callback");
        w53.b.f("TemplateTextRenderHelper", "old " + this.mRootEntity + ", new: " + rootEntity);
        if (Intrinsics.areEqual(rootEntity, this.mRootEntity)) {
            return;
        }
        this.mRootEntity = rootEntity;
        w53.b.a("TemplateTextRenderHelper", " setTemplateTextEntityCallback begin}");
        if (rootEntity == null || (emptyList = com.tencent.videocut.render.extension.d.b(rootEntity, n.a.INSTANCE.d())) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Entity entity : emptyList) {
            Collection<Component> components = entity.getComponents();
            Intrinsics.checkNotNullExpressionValue(components, "assetEntity.components");
            boolean z16 = false;
            for (Component component : components) {
                if (component instanceof PAGAsset) {
                    Intrinsics.checkNotNull(component, "null cannot be cast to non-null type org.light.lightAssetKit.components.PAGAsset");
                    PAGAsset pAGAsset = (PAGAsset) component;
                    ArrayList<ReplaceItem> replacement = pAGAsset.getReplacement();
                    Intrinsics.checkNotNullExpressionValue(replacement, "replacement");
                    if (!replacement.isEmpty()) {
                        Iterator<ReplaceItem> it = replacement.iterator();
                        while (it.hasNext()) {
                            if (it.next().replaceType == ReplaceType.Text) {
                                z16 = true;
                            }
                        }
                    }
                    if (z16) {
                        linkedHashMap.put(entity, pAGAsset);
                    }
                }
            }
        }
        D(linkedHashMap, callback);
        w53.b.a("TemplateTextRenderHelper", " setCutSessionAllTextEntityCallback end}");
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable final StickerModel oldData, @NotNull final StickerModel newData) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        for (TextItem textItem : newData.textItems) {
            isBlank = StringsKt__StringsJVMKt.isBlank(textItem.fontPath);
            if (!isBlank) {
                this.tavCutSession.registerFont(textItem.fontFamily, textItem.fontStyle, textItem.fontPath);
            }
        }
        this.tavCutSession.pushCustomCommandSync(new Function1<ICutSession, Unit>(newData, oldData) { // from class: com.tencent.videocut.render.TemplateTextRenderHelper$updateEntity$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ StickerModel $newData;
            final /* synthetic */ StickerModel $oldData;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$newData = newData;
                this.$oldData = oldData;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, TemplateTextRenderHelper.this, newData, oldData);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ICutSession iCutSession) {
                invoke2(iCutSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ICutSession pushCustomCommandSync) {
                Entity z16;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pushCustomCommandSync);
                    return;
                }
                Intrinsics.checkNotNullParameter(pushCustomCommandSync, "$this$pushCustomCommandSync");
                z16 = TemplateTextRenderHelper.this.z(pushCustomCommandSync.getRootEntity(), com.tencent.videocut.render.extension.f.i(this.$newData).getSecond().intValue());
                w53.b.a("TemplateTextRenderHelper", "updateEntity id: " + z16);
                if (z16 == null || !com.tencent.videocut.render.extension.f.z(this.$newData, this.$oldData, z16, pushCustomCommandSync)) {
                    return;
                }
                pushCustomCommandSync.notifyReloadAsset();
            }
        });
    }

    public final void K(@NotNull StickerModel oldData, @NotNull StickerModel newData) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) oldData, (Object) newData);
            return;
        }
        Intrinsics.checkNotNullParameter(oldData, "oldData");
        Intrinsics.checkNotNullParameter(newData, "newData");
        for (TextItem textItem : newData.textItems) {
            isBlank = StringsKt__StringsJVMKt.isBlank(textItem.fontPath);
            if (!isBlank) {
                this.tavCutSession.registerFont(textItem.fontFamily, textItem.fontStyle, textItem.fontPath);
            }
        }
        Entity z16 = z(this.tavCutSession.getRootEntity(), com.tencent.videocut.render.extension.f.i(newData).getSecond().intValue());
        if (z16 != null) {
            w53.b.a("TemplateTextRenderHelper", "updateEntity 1");
            if (com.tencent.videocut.render.extension.f.z(newData, oldData, z16, this.tavCutSession)) {
                this.tavCutSession.notifyReloadAsset();
            }
        }
        Iterator<StickerModel> it = f().iterator();
        int i3 = 0;
        while (true) {
            if (it.hasNext()) {
                if (Intrinsics.areEqual(it.next().id, oldData.id)) {
                    break;
                } else {
                    i3++;
                }
            } else {
                i3 = -1;
                break;
            }
        }
        if (i3 >= 0) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(f().subList(0, i3));
            arrayList.add(newData);
            int i16 = i3 + 1;
            if (i16 < f().size()) {
                arrayList.addAll(f().subList(i16, f().size()));
            }
            t(arrayList);
        }
    }

    @Override // com.tencent.videocut.render.a, com.tencent.videocut.render.i
    public void d(@NotNull MediaModel mediaModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) mediaModel);
            return;
        }
        Intrinsics.checkNotNullParameter(mediaModel, "mediaModel");
        super.d(mediaModel);
        w53.b.a("TemplateTextRenderHelper", "update");
        if (this.forceUpdate) {
            this.forceUpdate = false;
        }
    }

    @Override // com.tencent.videocut.render.a
    protected void p(@NotNull List<? extends StickerModel> items) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) items);
            return;
        }
        Intrinsics.checkNotNullParameter(items, "items");
        Iterator<T> it = items.iterator();
        while (it.hasNext()) {
            String j3 = j((StickerModel) it.next());
            w53.b.a("TemplateTextRenderHelper", "removeEntity: " + j3);
            i().remove(j3);
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) entity);
        } else {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    public List<StickerModel> s(@NotNull MediaModel model) {
        List<StickerModel> sortedWith;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        if (model == MediaModel.INSTANCE.getEMPTY()) {
            return f();
        }
        Collection<StickerModel> values = model.stickers.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            StickerModel.Type type = ((StickerModel) obj).type;
            if (type != StickerModel.Type.TEXT_TEMPLATE && type != StickerModel.Type.IMAGE_TEMPLATE) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        sortedWith = CollectionsKt___CollectionsKt.sortedWith(arrayList, new c());
        return sortedWith;
    }

    @Override // com.tencent.videocut.render.m
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (Entity) iPatchRedirector.redirect((short) 7, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        w53.b.a("TemplateTextRenderHelper", "addEntity: " + data.b());
        return data.a();
    }
}
