package com.tencent.videocut.render;

import com.google.gson.Gson;
import com.tencent.aelight.camera.download.api.IAEResUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqlive.tvkplayer.report.capability.TVKDeviceCapabilityReportConstant;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.render.builder.light.model.PostEffectOptions;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;
import com.tencent.videocut.model.MediaModel;
import java.io.File;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.PostEffect;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 22\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00013B\u000f\u0012\u0006\u0010'\u001a\u00020%\u00a2\u0006\u0004\b0\u00101J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\bH\u0002J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\nH\u0016\u00a2\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000f\u001a\u00020\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\u000e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0004H\u0016J#\u0010\u001b\u001a\u00020\u00022\b\u0010\u0019\u001a\u0004\u0018\u00010\u00022\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u001b\u0010\u001cJ)\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00042\b\u0010\u001d\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\u0016\u00a2\u0006\u0004\b\u001f\u0010 J\u001c\u0010$\u001a\u00020\u00132\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00040!H\u0016R\u0014\u0010'\u001a\u00020%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010&R\u0014\u0010*\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,\u00a8\u00064"}, d2 = {"Lcom/tencent/videocut/render/e;", "Lcom/tencent/videocut/render/b;", "", "Lcom/tencent/videocut/render/l;", "Lorg/light/lightAssetKit/Entity;", "originalEntity", "Lorg/light/lightAssetKit/components/PostEffect;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/tavcut/core/render/builder/light/model/PostEffectOptions;", DomainData.DOMAIN_NAME, "Lcom/tencent/videocut/model/MediaModel;", "model", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "(Lcom/tencent/videocut/model/MediaModel;)Ljava/lang/Boolean;", "", "l", "(Ljava/lang/Boolean;)Ljava/lang/String;", "p", TPReportKeys.LiveExKeys.LIVE_EX_DEFINATION_SWICH, "", ReportConstant.COSTREPORT_PREFIX, "data", "k", "entity", "removeEntity", com.tencent.mobileqq.msf.service.b.f250814q, com.tencent.mobileqq.msf.service.b.f250813p, "o", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)Z", "oldData", "newData", "r", "(Lorg/light/lightAssetKit/Entity;Ljava/lang/Boolean;Z)V", "", "", "entityMap", "c", "Lcom/tencent/tavcut/core/session/ICutSession;", "Lcom/tencent/tavcut/core/session/ICutSession;", "tavCutSession", "d", "Ljava/lang/String;", "TAG", "e", "Lorg/light/lightAssetKit/Entity;", "hdrEntity", "f", "lutEntity", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "g", "a", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class e extends b<Boolean, l> {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession tavCutSession;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Entity hdrEntity;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private Entity lutEntity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/tencent/videocut/render/e$a;", "", "", "LOW_HDR_DIR", "Ljava/lang/String;", "LUT_EFFECT_ENTITY_NAME", "LUT_EFFECT_FILE_NAME", "POST_EFFECT_DATA_FILE_NAME", "POST_EFFECT_ENTITY_DUMB", "POST_EFFECT_ENTITY_NAME", "<init>", "()V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.videocut.render.e$a, reason: from kotlin metadata */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(59655);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public e(@NotNull ICutSession tavCutSession) {
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) tavCutSession);
        } else {
            this.tavCutSession = tavCutSession;
            this.TAG = "DowngradeHDRProcessor";
        }
    }

    private final PostEffect m(Entity originalEntity) {
        Collection<Component> components = originalEntity.getComponents();
        Intrinsics.checkNotNullExpressionValue(components, "originalEntity.components");
        for (Component component : components) {
            if (component instanceof PostEffect) {
                return (PostEffect) component;
            }
        }
        return null;
    }

    private final PostEffectOptions n() {
        Map<String, String> lightBundleMap = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap();
        if (lightBundleMap != null) {
            try {
                String str = lightBundleMap.get(LightConstants.AgentType.PIC_ENHANCE_AGENT);
                String str2 = File.separator;
                String d16 = com.tencent.mobileqq.wink.utils.r.d(str + str2 + "lowhdr" + str2 + "lowhdr_posteffect.post");
                Intrinsics.checkNotNullExpressionValue(d16, "getStringFromFile(postDataPath)");
                Object fromJson = new Gson().fromJson(d16, (Class<Object>) PostEffectOptions.class);
                Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(json, PostEffectOptions::class.java)");
                return (PostEffectOptions) fromJson;
            } catch (Exception e16) {
                w53.b.c(this.TAG, "getPostOptionByAdjustmentJsonFile : " + e16);
            }
        }
        return new PostEffectOptions("adjustment", "blur", null, 10, Float.valueOf(1.0f), null, 1000, "screen", 20, 5, null, null, null, null, null, null, null, null, null, null, 6, null, 1, 35, -6, null, null, null, null, 0, 506461220, null);
    }

    @Override // com.tencent.videocut.render.m
    public /* bridge */ /* synthetic */ void a(Entity entity, Object obj, Object obj2) {
        r(entity, (Boolean) obj, ((Boolean) obj2).booleanValue());
    }

    @Override // com.tencent.videocut.render.b, com.tencent.videocut.render.m
    public void c(@NotNull Map<Integer, Entity> entityMap) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) entityMap);
            return;
        }
        Intrinsics.checkNotNullParameter(entityMap, "entityMap");
        w53.b.a(this.TAG, "updateEntityByReload");
        Entity entity = this.hdrEntity;
        if (entity != null) {
            if (entityMap.containsKey(Integer.valueOf(entity.getId()))) {
                w53.b.a(this.TAG, "updateEntityByReload hdrEntity " + Intrinsics.areEqual(entity, this.hdrEntity));
                this.hdrEntity = entityMap.get(Integer.valueOf(entity.getId()));
            } else {
                w53.b.a(this.TAG, "updateEntityByReload not contain hdrEntity " + entity.getId());
            }
        }
        Entity entity2 = this.lutEntity;
        if (entity2 != null && entityMap.containsKey(Integer.valueOf(entity2.getId()))) {
            w53.b.a(this.TAG, "updateEntityByReload lutEntity " + Intrinsics.areEqual(entity2, this.lutEntity));
            this.lutEntity = entityMap.get(Integer.valueOf(entity2.getId()));
        }
    }

    @Override // com.tencent.videocut.render.b
    public /* bridge */ /* synthetic */ l h(Boolean bool) {
        return p(bool.booleanValue());
    }

    @Override // com.tencent.videocut.render.m
    @Nullable
    /* renamed from: k, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull l data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (Entity) iPatchRedirector.redirect((short) 8, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        PostEffect m3 = m(data.a());
        if (m3 != null) {
            s(m3.getEnabled());
        }
        return data.a();
    }

    @Override // com.tencent.videocut.render.b
    @NotNull
    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public String e(@Nullable Boolean model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) model);
        }
        if (Intrinsics.areEqual(Boolean.TRUE, model)) {
            return "openHDR";
        }
        return "unopenHDR";
    }

    @Override // com.tencent.videocut.render.b
    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public boolean g(@Nullable Boolean newModel, @Nullable Boolean oldModel) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) newModel, (Object) oldModel)).booleanValue();
        }
        if (this.hdrEntity != null && this.lutEntity != null) {
            return true;
        }
        return false;
    }

    @NotNull
    public l p(boolean model) {
        List<? extends Component> listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (l) iPatchRedirector.redirect((short) 6, (Object) this, model);
        }
        w53.b.a(this.TAG, "prepareRenderData " + model);
        td4.f q16 = rd4.c.f431135f.q();
        PostEffect postEffect = new PostEffect();
        postEffect.setEnabled(model);
        listOf = CollectionsKt__CollectionsJVMKt.listOf(postEffect);
        return new l(q16.a(TVKDeviceCapabilityReportConstant.DEVICE_CAPABILITY_TYPE_HDR, listOf), new InputSource(null, null, null, null, null, null, null, null, null, null, null, 2047, null), null, 4, null);
    }

    @Override // com.tencent.videocut.render.b
    @Nullable
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public Boolean j(@NotNull MediaModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.openHDR;
    }

    public void r(@NotNull Entity entity, @Nullable Boolean oldData, boolean newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, entity, oldData, Boolean.valueOf(newData));
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        w53.b.a(this.TAG, "updateEntity " + oldData + ", " + newData);
        s(newData);
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) entity);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        w53.b.a(this.TAG, "removeEntity");
        Entity entity2 = this.lutEntity;
        if (entity2 != null) {
            ICutSession iCutSession = this.tavCutSession;
            Intrinsics.checkNotNull(entity2);
            iCutSession.removeEntity(entity2);
            this.lutEntity = null;
        }
        Entity entity3 = this.hdrEntity;
        if (entity3 != null) {
            ICutSession iCutSession2 = this.tavCutSession;
            Intrinsics.checkNotNull(entity3);
            iCutSession2.removeEntity(entity3);
            w53.b.a(this.TAG, "removeEntity hdrEntity");
            this.hdrEntity = null;
        }
    }

    public final void s(boolean r122) {
        List<? extends Component> listOf;
        List<? extends Component> listOf2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, r122);
            return;
        }
        w53.b.a(this.TAG, "updateLowLevelHDR");
        if (!r122) {
            Entity entity = this.hdrEntity;
            if (entity != null) {
                ICutSession iCutSession = this.tavCutSession;
                Intrinsics.checkNotNull(entity);
                iCutSession.switchEntity(entity, false);
            }
            Entity entity2 = this.lutEntity;
            if (entity2 != null) {
                ICutSession iCutSession2 = this.tavCutSession;
                Intrinsics.checkNotNull(entity2);
                iCutSession2.switchEntity(entity2, false);
                return;
            }
            return;
        }
        String str = ((IAEResUtil) QRoute.api(IAEResUtil.class)).getLightBundleMap().get(LightConstants.AgentType.PIC_ENHANCE_AGENT);
        Entity entity3 = this.hdrEntity;
        if (entity3 == null) {
            PostEffectOptions n3 = n();
            w53.b.a(this.TAG, "updateLowLevelHDR " + n3);
            rd4.c cVar = rd4.c.f431135f;
            td4.g r16 = cVar.r();
            String str2 = File.separator;
            String str3 = str + str2 + "lowhdr" + str2 + "lowhdr_posteffect.post";
            if (new File(str3).exists()) {
                w53.b.a(this.TAG, "updateLowLevelHDR hdrEntity create");
                InputSource f16 = r16.f(ByteString.Companion.encodeString$default(ByteString.INSTANCE, str3, null, 1, null).md5().hex(), str3, n3);
                String key = f16.getKey();
                PostEffect postEffect = new PostEffect();
                postEffect.setSrc(key);
                td4.f q16 = cVar.q();
                listOf2 = CollectionsKt__CollectionsJVMKt.listOf(postEffect);
                Entity a16 = q16.a("postEffect_entity", listOf2);
                ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, f16, false, 2, null);
                this.tavCutSession.addHDR(a16, 0);
                this.hdrEntity = a16;
            }
        } else {
            ICutSession iCutSession3 = this.tavCutSession;
            Intrinsics.checkNotNull(entity3);
            iCutSession3.switchEntity(entity3, true);
        }
        Entity entity4 = this.lutEntity;
        if (entity4 == null) {
            rd4.c cVar2 = rd4.c.f431135f;
            td4.e o16 = cVar2.o();
            String str4 = File.separator;
            String str5 = str + str4 + "lowhdr" + str4 + "lowhdr_lut.png";
            if (new File(str5).exists()) {
                w53.b.a(this.TAG, "updateLowLevelHDR lutEntity create");
                InputSource b16 = cVar2.r().b(str5, ByteString.Companion.encodeString$default(ByteString.INSTANCE, str5, null, 1, null).md5().hex());
                String key2 = b16.getKey();
                td4.f q17 = cVar2.q();
                listOf = CollectionsKt__CollectionsJVMKt.listOf(o16.f(key2, 0.6f));
                Entity a17 = q17.a("lut_entity", listOf);
                ICutSession.DefaultImpls.addInputSource$default(this.tavCutSession, b16, false, 2, null);
                this.tavCutSession.addVideoSourceEntity(a17, 0);
                this.lutEntity = a17;
                return;
            }
            return;
        }
        ICutSession iCutSession4 = this.tavCutSession;
        Intrinsics.checkNotNull(entity4);
        iCutSession4.switchEntity(entity4, true);
    }
}
