package com.tencent.videocut.render;

import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.wink.api.QQWinkConstants;
import com.tencent.mobileqq.wink.editor.effect.model.WinkEffectCatType;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.LAKRenderModel;
import com.tencent.tavcut.core.render.builder.light.model.Painting;
import com.tencent.tavcut.core.render.builder.light.model.pag.PagEffectData;
import com.tencent.tavcut.core.render.builder.light.model.type.TimeStretchMode;
import com.tencent.tavcut.core.render.player.IPlayer;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.SpecialEffectModel;
import com.tencent.videocut.model.SpecialEffectModelKt;
import com.tencent.videocut.render.ComposeRenderLayer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.EntityIdentifier;
import org.light.lightAssetKit.components.LightAssetFragment;
import org.light.lightAssetKit.components.PAGAsset;
import org.light.lightAssetKit.components.Rect;
import org.light.lightAssetKit.components.ScreenTransform;
import org.light.lightAssetKit.components.Size;
import org.light.lightAssetKit.components.TimeOffset;
import org.light.lightAssetKit.components.Vec3;
import org.light.lightAssetKit.enums.PAGScaleMode;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0007\u0018\u0000 /2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00010B\u0017\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u00a2\u0006\u0004\b-\u0010.J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0002J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u00122\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0004H\u0016J\"\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\f\u001a\u00020\u0002H\u0016R\u0014\u0010%\u001a\u00020\"8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010,\u001a\u00020*8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b+\u0010\u0010\u00a8\u00061"}, d2 = {"Lcom/tencent/videocut/render/o;", "Lcom/tencent/videocut/render/a;", "Lcom/tencent/videocut/model/SpecialEffectModel;", "Lcom/tencent/videocut/render/p;", "Lorg/light/lightAssetKit/Entity;", "originalEntity", "Lorg/light/lightAssetKit/components/PAGAsset;", HippyTKDListViewAdapter.X, "Lorg/light/lightAssetKit/components/TimeOffset;", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Lorg/light/lightAssetKit/components/ScreenTransform;", "y", "model", "", "B", BdhLogUtil.LogTag.Tag_Conn, "D", "Lcom/tencent/videocut/model/MediaModel;", "", ReportConstant.COSTREPORT_PREFIX, "entity", "", "removeEntity", "oldData", "newData", UserInfo.SEX_FEMALE, "data", "v", "E", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", "w", "Lcom/tencent/tavcut/core/session/ICutSession;", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "Lcom/tencent/videocut/render/ComposeRenderLayer$RunningMode;", "e", "Lcom/tencent/videocut/render/ComposeRenderLayer$RunningMode;", "runningMode", "", "f", "rateTolerance", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;Lcom/tencent/videocut/render/ComposeRenderLayer$RunningMode;)V", "g", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class o extends a<SpecialEffectModel, p> {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ComposeRenderLayer.RunningMode runningMode;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final double rateTolerance;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/render/o$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.o$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59732);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 9)) {
            redirector.redirect((short) 9);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public o(@NotNull ICutSession tavCutSession, @NotNull ComposeRenderLayer.RunningMode runningMode) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        Intrinsics.checkNotNullParameter(runningMode, "runningMode");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession, (Object) runningMode);
            return;
        }
        this.tavCutSession = tavCutSession;
        this.runningMode = runningMode;
        this.rateTolerance = 0.01d;
    }

    private final boolean B(SpecialEffectModel model) {
        float f16;
        Float f17 = model.scaleWithCrop;
        if (f17 != null) {
            f16 = f17.floatValue();
        } else {
            f16 = 1.7777778f;
        }
        if (f16 < 1.0f) {
            return true;
        }
        return false;
    }

    private final p C(SpecialEffectModel model) {
        long j3;
        boolean z16;
        int ordinal;
        String str = model.filePath;
        if (str == null) {
            return p.INSTANCE.a();
        }
        Long l3 = model.durationUs;
        if (l3 != null) {
            long longValue = l3.longValue();
            Triple<Entity, List<InputSource>, LightAsset> g16 = com.tencent.videocut.render.utils.c.f384212a.g(str, this.tavCutSession);
            Entity first = g16.getFirst();
            if (first == null) {
                return null;
            }
            Collection<Component> components = first.getComponents();
            Intrinsics.checkNotNullExpressionValue(components, "lakEntity.components");
            for (Component component : components) {
                if (component instanceof LightAssetFragment) {
                    ((LightAssetFragment) component).setPagOrientation(B(model) ? 1 : 0);
                }
            }
            com.tencent.videocut.render.utils.c cVar = com.tencent.videocut.render.utils.c.f384212a;
            Long l16 = model.startTimeUs;
            if (l16 != null) {
                j3 = l16.longValue();
            } else {
                j3 = 0;
            }
            Entity b16 = com.tencent.videocut.render.utils.c.b(cVar, first, j3, longValue, null, 8, null);
            List<InputSource> second = g16.getSecond();
            String valueOf = String.valueOf(first.getId());
            Integer num = model.temporary;
            if (num != null && num.intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            Integer num2 = model.effectType;
            if (num2 != null) {
                ordinal = num2.intValue();
            } else {
                ordinal = WinkEffectCatType.TypeFace.ordinal();
            }
            return new p(b16, second, null, valueOf, z16, true, ordinal);
        }
        return p.INSTANCE.a();
    }

    private final p D(SpecialEffectModel model) {
        PAGScaleMode pAGScaleMode;
        long j3;
        ArrayList arrayListOf;
        List listOf;
        boolean z16;
        int ordinal;
        String str;
        String str2 = model.filePath;
        if (str2 == null) {
            return p.INSTANCE.a();
        }
        Long l3 = model.durationUs;
        if (l3 != null) {
            long longValue = l3.longValue();
            Integer num = model.scaleMode;
            if (num != null && num.intValue() == 1) {
                pAGScaleMode = PAGScaleMode.Stretch;
            } else if (num != null && num.intValue() == 2) {
                pAGScaleMode = PAGScaleMode.LetterBox;
            } else {
                pAGScaleMode = PAGScaleMode.Zoom;
            }
            PAGScaleMode pAGScaleMode2 = pAGScaleMode;
            if (B(model) && (str = model.landscapeFilePath) != null) {
                str2 = str;
            }
            rd4.c cVar = rd4.c.f431135f;
            PagEffectData A = cVar.A(str2);
            if (A == null) {
                return p.INSTANCE.a();
            }
            td4.g r16 = cVar.r();
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            InputSource g16 = r16.g(str2, -1, uuid, TimeStretchMode.REPEAT);
            PAGAsset k3 = cVar.o().k(g16.getKey(), pAGScaleMode2, 0, 1, A.getImageLayerList().size());
            td4.e o16 = cVar.o();
            Long l16 = model.startTimeUs;
            if (l16 != null) {
                j3 = l16.longValue();
            } else {
                j3 = 0;
            }
            TimeOffset m3 = o16.m(j3, longValue, 0);
            td4.f q16 = cVar.q();
            String str3 = model.name;
            if (str3 == null) {
                str3 = QQWinkConstants.TAB_EFFECT;
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(k3, m3);
            Entity a16 = q16.a(str3, arrayListOf);
            listOf = CollectionsKt__CollectionsJVMKt.listOf(g16);
            String valueOf = String.valueOf(a16.getId());
            Integer num2 = model.temporary;
            if (num2 != null && num2.intValue() == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            Integer num3 = model.effectType;
            if (num3 != null) {
                ordinal = num3.intValue();
            } else {
                ordinal = WinkEffectCatType.TypeFace.ordinal();
            }
            return new p(a16, listOf, A, valueOf, z16, false, ordinal, 32, null);
        }
        return p.INSTANCE.a();
    }

    private final PAGAsset x(Entity originalEntity) {
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        for (Component component : components) {
            if (component instanceof PAGAsset) {
                return (PAGAsset) component;
            }
        }
        return null;
    }

    private final ScreenTransform y(Entity originalEntity) {
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        for (Component component : components) {
            if (component instanceof ScreenTransform) {
                return (ScreenTransform) component;
            }
        }
        return null;
    }

    private final TimeOffset z(Entity originalEntity) {
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        for (Component component : components) {
            if (component instanceof TimeOffset) {
                return (TimeOffset) component;
            }
        }
        return null;
    }

    @Override // com.tencent.videocut.render.a
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull SpecialEffectModel newModel, @NotNull SpecialEffectModel oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        if (Intrinsics.areEqual(newModel.id, oldModel.id) && Intrinsics.areEqual(newModel.name, oldModel.name) && Intrinsics.areEqual(newModel.filePath, oldModel.filePath) && Intrinsics.areEqual(newModel.scale, oldModel.scale) && Intrinsics.areEqual(newModel.scaleWithCrop, oldModel.scaleWithCrop) && Intrinsics.areEqual(newModel.durationUs, oldModel.durationUs) && Intrinsics.areEqual(newModel.startTimeUs, oldModel.startTimeUs) && Intrinsics.areEqual(newModel.landscapeFilePath, oldModel.landscapeFilePath)) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public p q(@NotNull SpecialEffectModel model) {
        float f16;
        Size size;
        Integer num;
        float f17;
        float f18;
        p D;
        boolean z16;
        Painting painting;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (p) iPatchRedirector.redirect((short) 6, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        Float f19 = model.scale;
        if (f19 != null) {
            f19.floatValue();
        }
        Float f26 = model.scaleWithCrop;
        if (f26 != null) {
            f16 = f26.floatValue();
        } else {
            f16 = 1.7777778f;
        }
        IPlayer player = this.tavCutSession.getPlayer();
        if (player != null) {
            player.getRenderSize();
        }
        LAKRenderModel renderModel = this.tavCutSession.getRenderModel();
        Integer num2 = null;
        if (renderModel != null && (painting = renderModel.getPainting()) != null) {
            size = painting.getRenderSize();
        } else {
            size = null;
        }
        if (size != null) {
            num = Integer.valueOf(size.height);
        } else {
            num = null;
        }
        if (size != null) {
            num2 = Integer.valueOf(size.width);
        }
        if (num != null && num2 != null && Math.abs((num.intValue() / num2.intValue()) - f16) >= this.rateTolerance) {
            f17 = 1280.0f;
            f18 = 720.0f;
        } else {
            f17 = 0.0f;
            f18 = 0.0f;
        }
        w53.b.a("render_helper_SpecialEffectRenderHelper", "calc screen " + f18 + " " + f17);
        l73.a aVar = l73.a.f413927a;
        boolean m3 = aVar.m(model.filePath);
        if (m3) {
            aVar.p(model.filePath, this.tavCutSession);
            D = C(model);
        } else {
            D = D(model);
        }
        if (D == null) {
            return p.INSTANCE.a();
        }
        if (!m3 || !j73.a.f409615a.i(model.filePath)) {
            Collection<Component> components = D.c().getComponents();
            Intrinsics.checkNotNullExpressionValue(components, "specialEffectModel.entity.components");
            for (Component it : components) {
                if (it instanceof ScreenTransform) {
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    ScreenTransform screenTransform = (ScreenTransform) it;
                    boolean z17 = true;
                    if (f18 == 0.0f) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        if (f17 != 0.0f) {
                            z17 = false;
                        }
                        if (!z17) {
                            float f27 = 2;
                            screenTransform.setOffset(new Rect((float) Math.floor((-f17) / f27), (float) Math.floor((-f18) / f27), (float) Math.ceil(f18 / f27), (float) Math.ceil(f17 / f27)));
                            screenTransform.setScale(new Vec3(1.0f, 1.0f, 1.0f));
                            screenTransform.setAnchor(new Rect(0.0f, 0.0f, 0.0f, 0.0f));
                            w53.b.a("render_helper_SpecialEffectRenderHelper", "change offset: " + screenTransform.getOffset().left + " " + screenTransform.getOffset().top + " " + screenTransform.getOffset().right + " " + screenTransform.getOffset().bottom);
                        }
                    }
                }
            }
        }
        return D;
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable SpecialEffectModel oldData, @NotNull SpecialEffectModel newData) {
        boolean contains;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        if (!SpecialEffectModelKt.getValid(newData)) {
            return;
        }
        w53.b.a("render_helper_SpecialEffectRenderHelper", "updateEntity: " + entity + " " + this.tavCutSession.getRootEntity());
        p q16 = q(newData);
        List<InputSource> d16 = q16.d();
        if (d16 != null) {
            for (InputSource inputSource : d16) {
                contains = CollectionsKt___CollectionsKt.contains(q16.d(), this.tavCutSession.accessInputSource(inputSource.getKey()));
                if (!contains) {
                    ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, inputSource, false, 2, null);
                }
            }
        }
        Collection<Component> components = q16.c().getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "renderData.entity.components");
        for (Component component : components) {
            if (component instanceof PAGAsset) {
                PAGAsset x16 = x(entity);
                if (x16 != null) {
                    x16.setSrc(((PAGAsset) component).getSrc());
                }
                if (x16 != null) {
                    x16.setMusicID(((PAGAsset) component).getMusicID());
                }
                if (x16 != null) {
                    x16.setReplacement(((PAGAsset) component).getReplacement());
                }
                if (x16 != null) {
                    x16.setLayerScaleModes(((PAGAsset) component).getLayerScaleModes());
                }
                if (x16 != null) {
                    x16.setScaleMode(((PAGAsset) component).getScaleMode());
                }
            } else if (component instanceof TimeOffset) {
                TimeOffset z16 = z(entity);
                if (z16 != null) {
                    z16.setStartOffset(((TimeOffset) component).getStartOffset());
                }
                if (z16 != null) {
                    z16.setDuration(((TimeOffset) component).getDuration());
                }
            } else if (component instanceof ScreenTransform) {
                ScreenTransform y16 = y(entity);
                if (y16 != null) {
                    y16.setPosition(((ScreenTransform) component).getPosition());
                }
                if (y16 != null) {
                    y16.setRotation(((ScreenTransform) component).getRotation());
                }
                if (y16 != null) {
                    y16.setScale(((ScreenTransform) component).getScale());
                }
                if (y16 != null) {
                    y16.setEnabled(((ScreenTransform) component).getEnabled());
                }
                if (y16 != null) {
                    y16.setAnchor(((ScreenTransform) component).getAnchor());
                }
                if (y16 != null) {
                    y16.setOffset(((ScreenTransform) component).getOffset());
                }
                if (y16 != null) {
                    y16.setPivot(((ScreenTransform) component).getPivot());
                }
            }
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        w53.b.a("render_helper_SpecialEffectRenderHelper", "removeEntity: " + entity + " " + entity.getParent() + " " + this.tavCutSession.getRootEntity());
        this.tavCutSession.removeEntity(entity);
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    public List<SpecialEffectModel> s(@NotNull MediaModel model) {
        List<SpecialEffectModel> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        if (model != MediaModel.INSTANCE.getEMPTY()) {
            list = CollectionsKt___CollectionsKt.toList(model.specialEffects.values());
            return list;
        }
        return f();
    }

    @Override // com.tencent.videocut.render.m
    @Nullable
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull p data) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Entity) iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (!data.e()) {
            return null;
        }
        w53.b.a("render_helper_SpecialEffectRenderHelper", "addEntity " + data.c() + " " + this.tavCutSession.getRootEntity());
        List<InputSource> d16 = data.d();
        if (d16 != null) {
            Iterator<T> it = d16.iterator();
            while (it.hasNext()) {
                ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, (InputSource) it.next(), false, 2, null);
            }
        }
        Collection<Component> components = data.c().getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "data.entity.components");
        for (Component component : components) {
            if (component instanceof EntityIdentifier) {
                EntityIdentifier entityIdentifier = (EntityIdentifier) component;
                if (data.b() == WinkEffectCatType.TypeFace.ordinal()) {
                    str = "face_specialEffect";
                } else {
                    str = "screen_specialEffect";
                }
                entityIdentifier.setName(str);
            }
        }
        com.tencent.videocut.render.utils.a.f384204a.f(this.tavCutSession, data.c(), data.b());
        return data.c();
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull SpecialEffectModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return String.valueOf(model.id);
    }
}
