package com.tencent.videocut.render;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.tavcut.core.session.ISessionListener;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import com.tencent.videocut.render.BackgroundTextRenderHelper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.PAGAsset;

/* compiled from: P */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002%&B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u00a2\u0006\u0004\b\"\u0010#J\u001c\u0010\b\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0014\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016R\u0014\u0010\u001e\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010 \u00a8\u0006'"}, d2 = {"Lcom/tencent/videocut/render/BackgroundTextRenderHelper;", "Lcom/tencent/videocut/render/a;", "Lcom/tencent/videocut/model/StickerModel;", "Lcom/tencent/videocut/render/BackgroundTextRenderHelper$b;", "Lorg/light/lightAssetKit/Entity;", "entity", "", TemplateParser.KEY_ENTITY_ID, HippyTKDListViewAdapter.X, "Lcom/tencent/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "data", "w", "", "removeEntity", "oldData", "newData", "B", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "y", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lcom/tencent/tavcut/core/session/ICutSession;", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "e", "I", "backgroundTextEntityId", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "f", "a", "b", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class BackgroundTextRenderHelper extends a<StickerModel, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int backgroundTextEntityId;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/videocut/render/BackgroundTextRenderHelper$a;", "", "", "NAME_ID_SEPARATOR", "Ljava/lang/String;", "TAG", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.BackgroundTextRenderHelper$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0013\u00a2\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\u000e\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0017\u0010\u0012\u001a\u00020\u00048\u0006\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\n\u0010\u0011R\u0017\u0010\u0017\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u000f\u0010\u0016\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/videocut/render/BackgroundTextRenderHelper$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/light/lightAssetKit/Entity;", "a", "Lorg/light/lightAssetKit/Entity;", "getEntity", "()Lorg/light/lightAssetKit/Entity;", "entity", "b", "I", "()I", TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/videocut/model/StickerModel;", "c", "Lcom/tencent/videocut/model/StickerModel;", "()Lcom/tencent/videocut/model/StickerModel;", "model", "<init>", "(Lorg/light/lightAssetKit/Entity;ILcom/tencent/videocut/model/StickerModel;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
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

        public final int a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
            }
            return this.entityId;
        }

        @NotNull
        public final StickerModel b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                return (StickerModel) iPatchRedirector.redirect((short) 5, (Object) this);
            }
            return this.model;
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
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\t\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/videocut/render/BackgroundTextRenderHelper$c", "Lcom/tencent/tavcut/core/session/ISessionListener;", "", "onRenderDataApplied", "Lcom/tencent/tavcut/core/render/builder/light/model/LAKRenderModel;", "newData", "", "duration", "mediaDuration", "onRenderDataChanged", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final class c implements ISessionListener {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Entity f384092b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ Function1<Entity, Unit> f384093c;

        /* JADX WARN: Multi-variable type inference failed */
        c(Entity entity, Function1<? super Entity, Unit> function1) {
            this.f384092b = entity;
            this.f384093c = function1;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, BackgroundTextRenderHelper.this, entity, function1);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataApplied() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            w53.b.c("backgroundText", "addEntity onRenderDataApplied step in ");
            BackgroundTextRenderHelper.this.tavCutSession.removeSessionListener(this);
            Entity entity = this.f384092b;
            if (entity != null) {
                Function1<Entity, Unit> function1 = this.f384093c;
                w53.b.c("backgroundText", "addEntity updateAction step in ");
                function1.invoke(entity);
            }
        }

        @Override // com.tencent.tavcut.core.session.ISessionListener
        public void onRenderDataChanged(@NotNull LAKRenderModel newData, long duration, long mediaDuration) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, newData, Long.valueOf(duration), Long.valueOf(mediaDuration));
            } else {
                Intrinsics.checkNotNullParameter(newData, "newData");
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59595);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 10)) {
            redirector.redirect((short) 10);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BackgroundTextRenderHelper(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
        }
    }

    private final Entity x(Entity entity, int entityId) {
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
            Entity x16 = x(it.next(), entityId);
            if (x16 != null) {
                return x16;
            }
        }
        return null;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public b q(@NotNull StickerModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (b) iPatchRedirector.redirect((short) 6, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        for (TextItem textItem : model.textItems) {
            this.tavCutSession.registerFont(textItem.fontFamily, textItem.fontStyle, textItem.fontPath);
        }
        return com.tencent.videocut.render.extension.f.m(model);
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable StickerModel oldData, @NotNull StickerModel newData) {
        boolean isBlank;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, entity, oldData, newData);
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
        if (com.tencent.videocut.render.extension.f.z(newData, oldData, entity, this.tavCutSession)) {
            this.tavCutSession.notifyReloadAsset();
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        ms.a.f("BackgroundTextRenderHelper", "tavcutTextSticker  removeEntity -\u300bentityID:" + entity.getId());
        this.tavCutSession.removeEntity(entity);
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    public List<StickerModel> s(@NotNull MediaModel model) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        Collection<StickerModel> values = model.stickers.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (((StickerModel) obj).type == StickerModel.Type.TEXT_BACKGROUND_TEMPLATE) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @Override // com.tencent.videocut.render.m
    @Nullable
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull final b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        Entity x16 = x(this.tavCutSession.getRootEntity(), data.a());
        if (x16 != null) {
            String str = data.b().filePath;
            td4.g r16 = rd4.c.f431135f.r();
            String a16 = com.tencent.videocut.utils.k.f384249b.a(str);
            if (a16 == null) {
                a16 = str;
            }
            ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, r16.a(str, a16), false, 2, null);
            Collection<Component> components = x16.getComponents();
            if (components != null) {
                Intrinsics.checkNotNullExpressionValue(components, "components");
                for (Component component : components) {
                    if (component instanceof PAGAsset) {
                        ((PAGAsset) component).setSrc(a16);
                    }
                }
            }
            StickerModel stickerModel = new StickerModel(null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, null, -1, 1, null);
            ms.a.f("BackgroundTextRenderHelper", " addEntity -updateEntity -\u300bentityID:" + x16.getId() + " -> " + x16);
            if (com.tencent.videocut.render.extension.f.z(data.b(), stickerModel, x16, this.tavCutSession)) {
                this.tavCutSession.notifyReloadAsset();
            }
        }
        this.tavCutSession.addSessionListener(new c(x16, new Function1<Entity, Unit>(this) { // from class: com.tencent.videocut.render.BackgroundTextRenderHelper$addEntity$updateAction$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ BackgroundTextRenderHelper this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) BackgroundTextRenderHelper.b.this, (Object) this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Entity entity) {
                invoke2(entity);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Entity textEntity) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) textEntity);
                    return;
                }
                Intrinsics.checkNotNullParameter(textEntity, "textEntity");
                if (com.tencent.videocut.render.extension.f.z(BackgroundTextRenderHelper.b.this.b(), new StickerModel(null, null, 0L, 0L, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, false, 0, 0, 0.0f, 0.0f, null, null, 0, null, null, null, null, 0, 0, 0L, null, null, null, null, 0.0f, null, null, null, -1, 1, null), textEntity, this.this$0.tavCutSession)) {
                    this.this$0.tavCutSession.notifyReloadAsset();
                }
            }
        }));
        this.backgroundTextEntityId = data.a();
        return x16;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull StickerModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.videocut.render.a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull StickerModel newModel, @NotNull StickerModel oldModel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
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
                        if (z26 && newModel.width == oldModel.width && newModel.height == oldModel.height && newModel.startTime == oldModel.startTime && newModel.duration == oldModel.duration && Intrinsics.areEqual(newModel.filePath, oldModel.filePath) && newModel.layerIndex == oldModel.layerIndex && Intrinsics.areEqual(newModel.textItems, oldModel.textItems)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
