package com.tencent.videocut.render;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.JsonElement;
import com.tencent.biz.common.util.WebViewConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.FilterModel;
import com.tencent.videocut.model.LutFilterModel;
import com.tencent.videocut.model.MediaModel;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightAsset;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.LightAssetDataContext;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.LUTFilter;
import org.light.lightAssetKit.components.TimeOffset;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B\u000f\u0012\u0006\u0010#\u001a\u00020 \u00a2\u0006\u0004\b)\u0010*J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0002J\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\u0006\u0010\n\u001a\u00020\fH\u0016J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u0003H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0004H\u0016J\"\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0002H\u0016J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0018\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0002H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0006\u0010\u001f\u001a\u00020\u0012R\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R$\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0006\u0012\u0004\u0018\u00010%0$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006-"}, d2 = {"Lcom/tencent/videocut/render/j;", "Lcom/tencent/videocut/render/a;", "Lcom/tencent/videocut/model/FilterModel;", "Lcom/tencent/videocut/render/f;", "Lorg/light/lightAssetKit/Entity;", "originalEntity", "Lorg/light/lightAssetKit/components/LUTFilter;", HippyTKDListViewAdapter.X, "Lorg/light/lightAssetKit/components/TimeOffset;", "y", "model", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/videocut/model/MediaModel;", "", ReportConstant.COSTREPORT_PREFIX, "data", "v", "entity", "", "removeEntity", "oldData", "newData", "E", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "D", "", "w", "B", "Lcom/tencent/tavcut/core/session/ICutSession;", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "", "Lcom/google/gson/JsonElement;", "e", "Ljava/util/Map;", "preInputSourceMap", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "f", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class j extends a<FilterModel, f> {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: g, reason: collision with root package name */
    private static boolean f384152g;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Map<String, ? extends JsonElement> preInputSourceMap;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/render/j$a;", "", "", "TAG", "Ljava/lang/String;", "", "specialBackgroundText", "Z", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.j$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59687);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 11)) {
            redirector.redirect((short) 11);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public j(@NotNull ICutSession tavCutSession) {
        Map<String, ? extends JsonElement> emptyMap;
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
            return;
        }
        this.tavCutSession = tavCutSession;
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.preInputSourceMap = emptyMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final f C(FilterModel model) {
        String str;
        boolean z16;
        boolean isBlank;
        LutFilterModel lutFilterModel = model.lut;
        if (lutFilterModel != null) {
            str = lutFilterModel.filePath;
        } else {
            str = null;
        }
        if (str != null) {
            isBlank = StringsKt__StringsJVMKt.isBlank(str);
            if (!isBlank) {
                z16 = false;
                if (!z16) {
                    return f.INSTANCE.a();
                }
                File parentFile = new File(str).getParentFile();
                Intrinsics.checkNotNull(parentFile);
                String materialDirPath = parentFile.getAbsolutePath();
                w53.b.a("LutFilterModelRender", "prepareLakFragmentRenderData: materialDirPath:" + materialDirPath);
                com.tencent.videocut.render.utils.c cVar = com.tencent.videocut.render.utils.c.f384212a;
                Intrinsics.checkNotNullExpressionValue(materialDirPath, "materialDirPath");
                Triple<Entity, List<InputSource>, LightAsset> g16 = cVar.g(materialDirPath, this.tavCutSession);
                Entity first = g16.getFirst();
                if (first == null) {
                    first = new Entity();
                }
                return new f(com.tencent.videocut.render.utils.c.b(cVar, first, model.startTimeUs, WebViewConstants.WV.ENABLE_WEBAIO_SWITCH, null, 8, null), g16.getSecond(), String.valueOf(first.getId()), true);
            }
        }
        z16 = true;
        if (!z16) {
        }
    }

    private final LUTFilter x(Entity originalEntity) {
        Object obj;
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        Iterator<T> it = components.iterator();
        while (true) {
            if (it.hasNext()) {
                obj = it.next();
                if (((Component) obj) instanceof LUTFilter) {
                    break;
                }
            } else {
                obj = null;
                break;
            }
        }
        return (LUTFilter) obj;
    }

    private final TimeOffset y(Entity originalEntity) {
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        for (Component component : components) {
            if (component instanceof TimeOffset) {
                return (TimeOffset) component;
            }
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x004a, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r5.lut, r6.lut) != false) goto L33;
     */
    @Override // com.tencent.videocut.render.a
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean l(@NotNull FilterModel newModel, @NotNull FilterModel oldModel) {
        String str;
        String str2;
        String str3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        LutFilterModel lutFilterModel = newModel.lut;
        String str4 = null;
        if (lutFilterModel != null) {
            str = lutFilterModel.name;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "\u667a\u80fd")) {
            LutFilterModel lutFilterModel2 = oldModel.lut;
            if (lutFilterModel2 != null) {
                str3 = lutFilterModel2.name;
            } else {
                str3 = null;
            }
            if (Intrinsics.areEqual(str3, "\u667a\u80fd")) {
            }
        }
        LutFilterModel lutFilterModel3 = newModel.lut;
        if (lutFilterModel3 != null) {
            str2 = lutFilterModel3.name;
        } else {
            str2 = null;
        }
        if (!Intrinsics.areEqual(str2, "\u667a\u80fd")) {
            LutFilterModel lutFilterModel4 = oldModel.lut;
            if (lutFilterModel4 != null) {
                str4 = lutFilterModel4.name;
            }
            if (!Intrinsics.areEqual(str4, "\u667a\u80fd")) {
                return true;
            }
        }
        return false;
    }

    public final void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
        } else {
            f384152g = true;
        }
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public f q(@NotNull FilterModel model) {
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (f) iPatchRedirector.redirect((short) 8, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        LutFilterModel lutFilterModel = model.lut;
        if (lutFilterModel != null) {
            str = lutFilterModel.name;
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, "\u667a\u80fd")) {
            return C(model);
        }
        return com.tencent.videocut.render.extension.c.b(model, false);
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable FilterModel oldData, @NotNull FilterModel newData) {
        String str;
        String str2;
        LutFilterModel lutFilterModel;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        w53.b.a("LutFilterModelRender", "update lut " + entity);
        String str3 = null;
        if (oldData != null && (lutFilterModel = oldData.lut) != null) {
            str = lutFilterModel.filePath;
        } else {
            str = null;
        }
        LutFilterModel lutFilterModel2 = newData.lut;
        if (lutFilterModel2 != null) {
            str2 = lutFilterModel2.filePath;
        } else {
            str2 = null;
        }
        LUTFilter x16 = x(entity);
        if (x16 != null) {
            str3 = x16.getSrc();
        }
        if (!Intrinsics.areEqual(str, str2) && str2 != null && !Intrinsics.areEqual(newData.lut.name, "\u667a\u80fd")) {
            InputSource b16 = rd4.c.f431135f.r().b(str2, newData.id);
            str3 = b16.getKey();
            if (!Intrinsics.areEqual(b16, this.tavCutSession.accessInputSource(str3))) {
                this.tavCutSession.addInputSource(b16, false);
            }
        }
        Collection<Component> components = entity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "entity.components");
        for (Component component : components) {
            if (component instanceof LUTFilter) {
                LUTFilter x17 = x(entity);
                if (x17 != null) {
                    x17.setSrc(str3);
                }
                if (x17 != null) {
                    LutFilterModel lutFilterModel3 = newData.lut;
                    Intrinsics.checkNotNull(lutFilterModel3);
                    x17.setIntensity(lutFilterModel3.intensity / 100.0f);
                }
            } else if (component instanceof TimeOffset) {
                TimeOffset y16 = y(entity);
                if (y16 != null) {
                    y16.setStartOffset(newData.startTimeUs);
                }
                if (y16 != null) {
                    y16.setDuration(newData.durationUs);
                }
            }
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        Map<String, ? extends JsonElement> emptyMap;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        w53.b.a("LutFilterModelRender", "remove lut " + entity);
        this.tavCutSession.removeEntity(entity);
        LightAssetDataContext lightAssetDataContext = this.tavCutSession.getLightAssetDataContext();
        if (lightAssetDataContext != null) {
            Iterator<String> it = this.preInputSourceMap.keySet().iterator();
            while (it.hasNext()) {
                lightAssetDataContext.updateInputSource(it.next(), null);
            }
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.preInputSourceMap = emptyMap;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    public List<FilterModel> s(@NotNull MediaModel model) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        Collection<FilterModel> values = model.filterModels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : values) {
            if (((FilterModel) obj).lut != null) {
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
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull f data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (data == f.INSTANCE.a()) {
            return null;
        }
        w53.b.a("LutFilterModelRender", "add lut " + data);
        List<InputSource> c16 = data.c();
        if (c16 != null) {
            Iterator<T> it = c16.iterator();
            while (it.hasNext()) {
                ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, (InputSource) it.next(), false, 2, null);
            }
        }
        com.tencent.videocut.render.utils.a.f384204a.b(this.tavCutSession, data.b(), f384152g ? 1 : 0);
        return data.b();
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull FilterModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (String) iPatchRedirector.redirect((short) 9, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        String simpleName = model.getClass().getSimpleName();
        Intrinsics.checkNotNullExpressionValue(simpleName, "model.javaClass.simpleName");
        return simpleName;
    }

    @Override // com.tencent.videocut.render.a
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull FilterModel newModel, @NotNull FilterModel oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(newModel, "newModel");
        Intrinsics.checkNotNullParameter(oldModel, "oldModel");
        if (Intrinsics.areEqual(newModel.lut, oldModel.lut) && newModel.durationUs == oldModel.durationUs) {
            return true;
        }
        return false;
    }
}
