package com.tencent.videocut.render;

import android.os.SystemClock;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.BackgroundModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SizeF;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.text.StringsKt__IndentKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.MultiMedia;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.enums.BackgroundFillMode;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 *2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001+B\u000f\u0012\u0006\u0010'\u001a\u00020$\u00a2\u0006\u0004\b(\u0010)J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0006H\u0002J\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u0002H\u0002J8\u0010\u0017\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\rH\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0018H\u0016J\u0010\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u0004H\u0016J\"\u0010 \u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u00042\b\u0010\u001e\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001f\u001a\u00020\u0002H\u0016J\u0014\u0010!\u001a\u0004\u0018\u00010\u00122\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016J\u0012\u0010#\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u0006,"}, d2 = {"Lcom/tencent/videocut/render/BackgroundModelRender;", "Lcom/tencent/videocut/render/b;", "Lcom/tencent/videocut/model/BackgroundModel;", "Lcom/tencent/videocut/render/l;", "Lorg/light/lightAssetKit/Entity;", "originalEntity", "Lorg/light/lightAssetKit/components/MultiMedia;", DomainData.DOMAIN_NAME, "model", "r", "", "v", "t", "", "width", "height", "", "fillScale", "", "argbBgColor", "Lorg/light/lightAssetKit/enums/BackgroundFillMode;", "bgFillMode", "newImageEffect", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/videocut/model/MediaModel;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "data", "l", "entity", "removeEntity", "oldData", "newData", "u", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "p", "o", "Lcom/tencent/tavcut/core/session/ICutSession;", "c", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "d", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class BackgroundModelRender extends b<BackgroundModel, l> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\n\u001a\u00020\t8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/videocut/render/BackgroundModelRender$a;", "", "", "MAX_EDIT_RENDER_SIZE", "I", "", "RATIO_2_3", UserInfo.SEX_FEMALE, "RATIO_9_16", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.BackgroundModelRender$a, reason: from kotlin metadata */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59575);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public BackgroundModelRender(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
        }
    }

    private final MultiMedia n(Entity originalEntity) {
        w53.b.a("BackgroundModelRender", "getMultiMedia");
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        for (Component component : components) {
            if (component instanceof MultiMedia) {
                w53.b.a("BackgroundModelRender", "getMultiMedia: " + component);
                return (MultiMedia) component;
            }
        }
        w53.b.a("BackgroundModelRender", "getMultiMedia: null");
        return null;
    }

    private final MultiMedia r(BackgroundModel model) {
        boolean z16;
        BackgroundFillMode backgroundFillMode;
        int i3;
        MultiMedia multiMedia = new MultiMedia();
        multiMedia.setFillScale(model.fillScale);
        com.tencent.videocut.model.BackgroundFillMode backgroundFillMode2 = model.bgFillMode;
        int i16 = 0;
        if (backgroundFillMode2 != null && backgroundFillMode2.getValue() == com.tencent.videocut.model.BackgroundFillMode.PAG.getValue()) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            backgroundFillMode = BackgroundFillMode.GaussianBlur;
        } else {
            backgroundFillMode = BackgroundFillMode.SolidColorFill;
        }
        multiMedia.setBackgroundFillMode(backgroundFillMode);
        multiMedia.setBackgroundColor(model.bgColor);
        multiMedia.setSrc(model.bgPagPath);
        SizeF sizeF = model.renderSize;
        if (sizeF != null) {
            i3 = MathKt__MathJVMKt.roundToInt(sizeF.width);
        } else {
            i3 = 0;
        }
        SizeF sizeF2 = model.renderSize;
        if (sizeF2 != null) {
            i16 = MathKt__MathJVMKt.roundToInt(sizeF2.height);
        }
        multiMedia.setSize(new Size(i3, i16));
        multiMedia.setImageEffect(model.imageEffect);
        return multiMedia;
    }

    private final void s(final int width, final int height, final float fillScale, final String argbBgColor, final BackgroundFillMode bgFillMode, final int newImageEffect) {
        String trimIndent;
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        trimIndent = StringsKt__IndentKt.trimIndent("updateBackground:\n            width:" + width + "\n            height:" + height + "\n            fillScale:" + fillScale + "\n            argbBgColor:" + argbBgColor + "\n            bgFillMode:" + bgFillMode + "\n            imageEffect:" + newImageEffect + "\n            hash:" + elapsedRealtime + "\n        ");
        w53.b.a("BackgroundModelRender", trimIndent);
        this.tavCutSession.runOnPlayerThread(new Function0<Unit>(width, height, fillScale, argbBgColor, bgFillMode, newImageEffect, elapsedRealtime) { // from class: com.tencent.videocut.render.BackgroundModelRender$updateBackground$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $argbBgColor;
            final /* synthetic */ BackgroundFillMode $bgFillMode;
            final /* synthetic */ float $fillScale;
            final /* synthetic */ long $hash;
            final /* synthetic */ int $height;
            final /* synthetic */ int $newImageEffect;
            final /* synthetic */ int $width;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$width = width;
                this.$height = height;
                this.$fillScale = fillScale;
                this.$argbBgColor = argbBgColor;
                this.$bgFillMode = bgFillMode;
                this.$newImageEffect = newImageEffect;
                this.$hash = elapsedRealtime;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, BackgroundModelRender.this, Integer.valueOf(width), Integer.valueOf(height), Float.valueOf(fillScale), argbBgColor, bgFillMode, Integer.valueOf(newImageEffect), Long.valueOf(elapsedRealtime));
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ICutSession iCutSession;
                ICutSession iCutSession2;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                iCutSession = BackgroundModelRender.this.tavCutSession;
                iCutSession.updateRenderSize(new Size(this.$width, this.$height), this.$fillScale);
                BackgroundModelRender backgroundModelRender = BackgroundModelRender.this;
                iCutSession2 = backgroundModelRender.tavCutSession;
                MultiMedia o16 = backgroundModelRender.o(iCutSession2.getRootEntity());
                if (o16 != null) {
                    String str = this.$argbBgColor;
                    BackgroundFillMode backgroundFillMode = this.$bgFillMode;
                    int i3 = this.$newImageEffect;
                    long j3 = this.$hash;
                    o16.setBackgroundColor(com.tencent.videocut.utils.d.f384234a.a(str));
                    o16.setBackgroundFillMode(backgroundFillMode);
                    o16.setImageEffect(i3);
                    w53.b.a("BackgroundModelRender", "updateBackground: real " + j3 + " " + o16.toJson());
                }
            }
        });
    }

    private final void t(BackgroundModel model) {
        int i3;
        int i16;
        BackgroundFillMode backgroundFillMode;
        SizeF sizeF = model.renderSize;
        if (sizeF != null) {
            i3 = MathKt__MathJVMKt.roundToInt(sizeF.width);
        } else {
            i3 = 720;
        }
        int i17 = i3;
        SizeF sizeF2 = model.renderSize;
        if (sizeF2 != null) {
            i16 = MathKt__MathJVMKt.roundToInt(sizeF2.height);
        } else {
            i16 = 1280;
        }
        int i18 = i16;
        float f16 = model.fillScale;
        String str = model.bgColor;
        if (model.bgFillMode == com.tencent.videocut.model.BackgroundFillMode.SOLID_COLOR) {
            backgroundFillMode = BackgroundFillMode.SolidColorFill;
        } else {
            backgroundFillMode = BackgroundFillMode.GaussianBlur;
        }
        s(i17, i18, f16, str, backgroundFillMode, model.imageEffect);
    }

    private final void v(MultiMedia model) {
        int i3;
        int i16;
        BackgroundFillMode backgroundFillMode;
        Size size = model.getSize();
        if (size != null) {
            i3 = size.width;
        } else {
            i3 = 720;
        }
        int i17 = i3;
        Size size2 = model.getSize();
        if (size2 != null) {
            i16 = size2.height;
        } else {
            i16 = 1280;
        }
        int i18 = i16;
        float fillScale = model.getFillScale();
        String backgroundColor = model.getBackgroundColor();
        Intrinsics.checkNotNullExpressionValue(backgroundColor, "model.backgroundColor");
        if (model.getBackgroundFillMode() != null) {
            backgroundFillMode = model.getBackgroundFillMode();
        } else {
            backgroundFillMode = BackgroundFillMode.SolidColorFill;
        }
        BackgroundFillMode backgroundFillMode2 = backgroundFillMode;
        Intrinsics.checkNotNullExpressionValue(backgroundFillMode2, "if (model.backgroundFill\u2026ndFillMode.SolidColorFill");
        s(i17, i18, fillScale, backgroundColor, backgroundFillMode2, model.getImageEffect());
    }

    @Override // com.tencent.videocut.render.m
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull l data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        w53.b.a("BackgroundModelRender", "addEntity: " + data);
        MultiMedia n3 = n(data.a());
        if (n3 != null) {
            v(n3);
        }
        return data.a();
    }

    @Override // com.tencent.videocut.render.b
    @Nullable
    /* renamed from: m, reason: merged with bridge method [inline-methods] */
    public String e(@Nullable BackgroundModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, (Object) model);
        }
        if (model != null) {
            return model.id;
        }
        return null;
    }

    @Nullable
    public final MultiMedia o(@Nullable Entity entity) {
        List<Entity> entitiesWithComponent;
        Object orNull;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (MultiMedia) iPatchRedirector.redirect((short) 8, (Object) this, (Object) entity);
        }
        if (entity != null && (entitiesWithComponent = entity.getEntitiesWithComponent(MultiMedia.class)) != null) {
            orNull = CollectionsKt___CollectionsKt.getOrNull(entitiesWithComponent, 0);
            Entity entity2 = (Entity) orNull;
            if (entity2 != null) {
                return (MultiMedia) entity2.getComponent(MultiMedia.class);
            }
        }
        return null;
    }

    @Override // com.tencent.videocut.render.b
    @NotNull
    /* renamed from: p, reason: merged with bridge method [inline-methods] */
    public l h(@NotNull BackgroundModel model) {
        List<? extends Component> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (l) iPatchRedirector.redirect((short) 7, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        td4.f q16 = rd4.c.f431135f.q();
        listOf = CollectionsKt__CollectionsJVMKt.listOf(r(model));
        return new l(q16.a("background", listOf), new InputSource(null, null, null, null, null, null, null, null, null, null, null, 2047, null), null, 4, null);
    }

    @Override // com.tencent.videocut.render.b
    @Nullable
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public BackgroundModel j(@NotNull MediaModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (BackgroundModel) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.backgroundModel;
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entity);
        } else {
            Intrinsics.checkNotNullParameter(entity, "entity");
        }
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable BackgroundModel oldData, @NotNull BackgroundModel newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        t(newData);
    }
}
