package com.tencent.videocut.render;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.adinfo.QAdPlayStrategyDefine$PlayStrategyKey;
import com.tencent.mobileqq.wink.editor.sticker.WinkStickerModel;
import com.tencent.tavcut.core.manager.StickerTrackerManager;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.model.StickerModel;
import com.tencent.videocut.model.TextItem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003,-.B\u000f\u0012\u0006\u0010(\u001a\u00020%\u00a2\u0006\u0004\b)\u0010*J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u0003J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\tH\u0016J\"\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0017\u0010\u0017\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0005\u001a\u00020\u0002\u00a2\u0006\u0004\b\u0017\u0010\u0018J&\u0010!\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001fJ\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0002H\u0016R\u0014\u0010(\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006/"}, d2 = {"Lcom/tencent/videocut/render/StickerRenderHelper;", "Lcom/tencent/videocut/render/a;", "Lcom/tencent/videocut/model/StickerModel;", "Lcom/tencent/videocut/render/StickerRenderHelper$b;", "Lcom/tencent/videocut/model/MediaModel;", "model", "", ReportConstant.COSTREPORT_PREFIX, "data", "Lorg/light/lightAssetKit/Entity;", "v", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "entity", "", "removeEntity", "oldData", "newData", BdhLogUtil.LogTag.Tag_Conn, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "", HippyTKDListViewAdapter.X, "", "w", "(Lcom/tencent/videocut/model/StickerModel;)Ljava/lang/Integer;", "Lcom/tencent/tavcut/core/manager/StickerTrackerManager;", "stickerTrackerManager", "Lsd4/b;", DownloadInfo.spKey_Config, "Lcom/tencent/mobileqq/wink/editor/sticker/WinkStickerModel;", "curStickerModel", "Lcom/tencent/tavcut/core/manager/a;", "callback", "B", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "y", "Lcom/tencent/tavcut/core/session/ICutSession;", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "e", "a", "b", "STICKER_TYPE", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class StickerRenderHelper extends a<StickerModel, b> {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/videocut/render/StickerRenderHelper$STICKER_TYPE;", "", "(Ljava/lang/String;I)V", "MOSAIC", "TEXT", "TEXT_TEMPLATE", "TEXT_BACKGROUND_TEMPLATE", QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, "DIY", "MOSAIC_DOODLE", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes27.dex */
    public static final class STICKER_TYPE {
        private static final /* synthetic */ STICKER_TYPE[] $VALUES;
        static IPatchRedirector $redirector_;
        public static final STICKER_TYPE DIY;
        public static final STICKER_TYPE MOSAIC;
        public static final STICKER_TYPE MOSAIC_DOODLE;
        public static final STICKER_TYPE NORMAL;
        public static final STICKER_TYPE TEXT;
        public static final STICKER_TYPE TEXT_BACKGROUND_TEMPLATE;
        public static final STICKER_TYPE TEXT_TEMPLATE;

        private static final /* synthetic */ STICKER_TYPE[] $values() {
            return new STICKER_TYPE[]{MOSAIC, TEXT, TEXT_TEMPLATE, TEXT_BACKGROUND_TEMPLATE, NORMAL, DIY, MOSAIC_DOODLE};
        }

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59753);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
                return;
            }
            MOSAIC = new STICKER_TYPE("MOSAIC", 0);
            TEXT = new STICKER_TYPE("TEXT", 1);
            TEXT_TEMPLATE = new STICKER_TYPE("TEXT_TEMPLATE", 2);
            TEXT_BACKGROUND_TEMPLATE = new STICKER_TYPE("TEXT_BACKGROUND_TEMPLATE", 3);
            NORMAL = new STICKER_TYPE(QAdPlayStrategyDefine$PlayStrategyKey.NORMAL, 4);
            DIY = new STICKER_TYPE("DIY", 5);
            MOSAIC_DOODLE = new STICKER_TYPE("MOSAIC_DOODLE", 6);
            $VALUES = $values();
        }

        STICKER_TYPE(String str, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
            }
        }

        public static STICKER_TYPE valueOf(String str) {
            return (STICKER_TYPE) Enum.valueOf(STICKER_TYPE.class, str);
        }

        public static STICKER_TYPE[] values() {
            return (STICKER_TYPE[]) $VALUES.clone();
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/videocut/render/StickerRenderHelper$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.StickerRenderHelper$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59756);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 12)) {
            redirector.redirect((short) 12);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public StickerRenderHelper(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
        }
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public b q(@NotNull StickerModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (b) iPatchRedirector.redirect((short) 7, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        ms.a.a("render_helper_StickerRenderHelper", "prepareRenderData " + model.id);
        for (TextItem textItem : model.textItems) {
            this.tavCutSession.registerFont(textItem.fontFamily, textItem.fontStyle, textItem.fontPath);
        }
        return com.tencent.videocut.render.extension.f.v(model, this.tavCutSession);
    }

    public final void B(@NotNull StickerTrackerManager stickerTrackerManager, @NotNull sd4.b config, @NotNull WinkStickerModel curStickerModel, @NotNull com.tencent.tavcut.core.manager.a callback) {
        Integer w3;
        Entity e16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, stickerTrackerManager, config, curStickerModel, callback);
            return;
        }
        Intrinsics.checkNotNullParameter(stickerTrackerManager, "stickerTrackerManager");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(curStickerModel, "curStickerModel");
        Intrinsics.checkNotNullParameter(callback, "callback");
        if (com.tencent.mobileqq.wink.editor.sticker.e.d(curStickerModel)) {
            Entity g16 = g(curStickerModel.id);
            w3 = null;
            if (g16 != null && (e16 = com.tencent.videocut.render.utils.c.f384212a.e(g16)) != null) {
                w3 = Integer.valueOf(e16.getId());
            }
        } else {
            w3 = w(curStickerModel);
        }
        if (w3 != null) {
            config.m(w3);
            stickerTrackerManager.k0(callback);
        }
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull Entity entity, @Nullable StickerModel oldData, @NotNull StickerModel newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        w53.b.a("render_helper_StickerRenderHelper", "updateEntity " + entity);
        if (com.tencent.videocut.render.extension.f.z(newData, oldData, entity, this.tavCutSession)) {
            this.tavCutSession.notifyReloadAsset();
        }
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        w53.b.a("render_helper_StickerRenderHelper", "removeEntity " + entity);
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
            StickerModel.Type type = ((StickerModel) obj).type;
            if (type != StickerModel.Type.TEXT_TEMPLATE && type != StickerModel.Type.IMAGE_TEMPLATE && type != StickerModel.Type.TEXT_BACKGROUND_TEMPLATE) {
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
    public Entity b(@NotNull b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Entity) iPatchRedirector.redirect((short) 3, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        w53.b.a("render_helper_StickerRenderHelper", "addEntity " + data.d());
        for (InputSource inputSource : data.b()) {
            if (inputSource != null) {
                ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, inputSource, false, 2, null);
            }
        }
        if (z(data)) {
            com.tencent.videocut.render.utils.a.f384204a.c(this.tavCutSession, data.a());
        } else if (data.c() == STICKER_TYPE.MOSAIC_DOODLE) {
            com.tencent.videocut.render.utils.a.f384204a.d(this.tavCutSession, data.a());
        } else if (data.d()) {
            com.tencent.videocut.render.utils.a.f384204a.a(this.tavCutSession, data.a());
        } else {
            com.tencent.videocut.render.utils.a.h(com.tencent.videocut.render.utils.a.f384204a, this.tavCutSession, data.a(), 0, 4, null);
        }
        return data.a();
    }

    @Nullable
    public final Integer w(@NotNull StickerModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return h(model.id);
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull StickerModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.videocut.render.a
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public boolean k(@NotNull StickerModel newModel, @NotNull StickerModel oldModel) {
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
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
                        if (z26 && newModel.width == oldModel.width && newModel.height == oldModel.height && newModel.startTime == oldModel.startTime && newModel.duration == oldModel.duration && Intrinsics.areEqual(newModel.filePath, oldModel.filePath) && newModel.layerIndex == oldModel.layerIndex && Intrinsics.areEqual(newModel.textItems, oldModel.textItems) && Intrinsics.areEqual(newModel.watermarkModel, oldModel.watermarkModel)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final boolean z(@NotNull b data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) data)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.c() == STICKER_TYPE.MOSAIC) {
            return true;
        }
        return false;
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\r\u001a\u00020\t\u0012\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0019\u0012\b\b\u0002\u0010!\u001a\u00020\u0007\u00a2\u0006\u0004\b\"\u0010#J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\r\u001a\u00020\t8\u0006\u00a2\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\n\u0010\fR\u001f\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000e8\u0006\u00a2\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0010\u0010\u0012R\u0017\u0010\u0018\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u0017\u0010\u001d\u001a\u00020\u00198\u0006\u00a2\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0014\u0010\u001cR\u0017\u0010!\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010 \u00a8\u0006$"}, d2 = {"Lcom/tencent/videocut/render/StickerRenderHelper$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lorg/light/lightAssetKit/Entity;", "a", "Lorg/light/lightAssetKit/Entity;", "()Lorg/light/lightAssetKit/Entity;", "entity", "", "Lcom/tencent/tavcut/core/render/builder/light/model/InputSource;", "b", "Ljava/util/List;", "()Ljava/util/List;", "inputSource", "c", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "id", "Lcom/tencent/videocut/render/StickerRenderHelper$STICKER_TYPE;", "d", "Lcom/tencent/videocut/render/StickerRenderHelper$STICKER_TYPE;", "()Lcom/tencent/videocut/render/StickerRenderHelper$STICKER_TYPE;", "type", "e", "Z", "()Z", "isAIEntity", "<init>", "(Lorg/light/lightAssetKit/Entity;Ljava/util/List;Ljava/lang/String;Lcom/tencent/videocut/render/StickerRenderHelper$STICKER_TYPE;Z)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes27.dex */
    public static final /* data */ class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final Entity entity;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final List<InputSource> inputSource;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final String id;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata */
        @NotNull
        private final STICKER_TYPE type;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata */
        private final boolean isAIEntity;

        public b(@NotNull Entity entity, @NotNull List<InputSource> inputSource, @NotNull String id5, @NotNull STICKER_TYPE type, boolean z16) {
            Intrinsics.checkNotNullParameter(entity, "entity");
            Intrinsics.checkNotNullParameter(inputSource, "inputSource");
            Intrinsics.checkNotNullParameter(id5, "id");
            Intrinsics.checkNotNullParameter(type, "type");
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, entity, inputSource, id5, type, Boolean.valueOf(z16));
                return;
            }
            this.entity = entity;
            this.inputSource = inputSource;
            this.id = id5;
            this.type = type;
            this.isAIEntity = z16;
        }

        @NotNull
        public final Entity a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (Entity) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return this.entity;
        }

        @NotNull
        public final List<InputSource> b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (List) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.inputSource;
        }

        @NotNull
        public final STICKER_TYPE c() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                return (STICKER_TYPE) iPatchRedirector.redirect((short) 6, (Object) this);
            }
            return this.type;
        }

        public final boolean d() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
            }
            return this.isAIEntity;
        }

        public boolean equals(@Nullable Object other) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
                return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this, other)).booleanValue();
            }
            if (this == other) {
                return true;
            }
            if (!(other instanceof b)) {
                return false;
            }
            b bVar = (b) other;
            if (Intrinsics.areEqual(this.entity, bVar.entity) && Intrinsics.areEqual(this.inputSource, bVar.inputSource) && Intrinsics.areEqual(this.id, bVar.id) && this.type == bVar.type && this.isAIEntity == bVar.isAIEntity) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
                return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
            }
            int hashCode = ((((((this.entity.hashCode() * 31) + this.inputSource.hashCode()) * 31) + this.id.hashCode()) * 31) + this.type.hashCode()) * 31;
            boolean z16 = this.isAIEntity;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
                return (String) iPatchRedirector.redirect((short) 14, (Object) this);
            }
            return "RenderData(entity=" + this.entity + ", inputSource=" + this.inputSource + ", id=" + this.id + ", type=" + this.type + ", isAIEntity=" + this.isAIEntity + ")";
        }

        public /* synthetic */ b(Entity entity, List list, String str, STICKER_TYPE sticker_type, boolean z16, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(entity, list, (i3 & 4) != 0 ? "" : str, (i3 & 8) != 0 ? STICKER_TYPE.NORMAL : sticker_type, (i3 & 16) != 0 ? false : z16);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, this, entity, list, str, sticker_type, Boolean.valueOf(z16), Integer.valueOf(i3), defaultConstructorMarker);
        }
    }
}
