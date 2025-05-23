package com.tencent.videocut.render;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.core.render.builder.light.model.InputSource;
import com.tencent.tavcut.core.session.ICutSession;
import com.tencent.videocut.model.AudioModel;
import com.tencent.videocut.model.MediaModel;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.lightAssetKit.Entity;
import org.light.lightAssetKit.components.AudioSource;
import org.light.lightAssetKit.components.Component;
import org.light.lightAssetKit.components.TimeOffset;

/* compiled from: P */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\u0006\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0003H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\"\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0017\u001a\u00020\u0002H\u0016R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/videocut/render/AudioModelRender;", "Lcom/tencent/videocut/render/a;", "Lcom/tencent/videocut/model/AudioModel;", "Lcom/tencent/videocut/render/l;", "Lorg/light/lightAssetKit/components/TimeOffset;", HippyQQConstants.URL_COMPONENT_NAME, "model", "", BdhLogUtil.LogTag.Tag_Conn, "Lorg/light/lightAssetKit/components/AudioSource;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/tencent/videocut/model/MediaModel;", "", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "y", "data", "Lorg/light/lightAssetKit/Entity;", HippyTKDListViewAdapter.X, "entity", "removeEntity", "oldData", "newData", "B", "Lcom/tencent/tavcut/core/session/ICutSession;", "d", "Lcom/tencent/tavcut/core/session/ICutSession;", "iCutSession", "<init>", "(Lcom/tencent/tavcut/core/session/ICutSession;)V", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes27.dex */
public final class AudioModelRender extends a<AudioModel, l> {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final ICutSession iCutSession;

    public AudioModelRender(@NotNull ICutSession iCutSession) {
        Intrinsics.checkNotNullParameter(iCutSession, "iCutSession");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iCutSession);
        } else {
            this.iCutSession = iCutSession;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void A(AudioSource component, AudioModel model) {
        AudioSource b16 = com.tencent.videocut.render.extension.a.b(model);
        component.setVolume(b16.getVolume());
        component.setSpeed(b16.getSpeed());
        component.setVolumeEffects(b16.getVolumeEffects());
        component.setAudioSourceType(b16.getAudioSourceType());
        component.setSrc(b16.getSrc());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(TimeOffset component, AudioModel model) {
        TimeOffset h16 = com.tencent.videocut.render.extension.a.h(model);
        component.setStartOffset(h16.getStartOffset());
        component.setEndOffset(h16.getEndOffset());
        component.setDuration(h16.getDuration());
        component.setLoopCount(h16.getLoopCount());
        component.setVisibleWhileOverTime(h16.getVisibleWhileOverTime());
    }

    @Override // com.tencent.videocut.render.m
    /* renamed from: B, reason: merged with bridge method [inline-methods] */
    public void a(@NotNull final Entity entity, @Nullable AudioModel oldData, @NotNull final AudioModel newData) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, entity, oldData, newData);
            return;
        }
        Intrinsics.checkNotNullParameter(entity, "entity");
        Intrinsics.checkNotNullParameter(newData, "newData");
        this.iCutSession.pushCustomCommand(new Function1<ICutSession, Unit>(entity, this) { // from class: com.tencent.videocut.render.AudioModelRender$updateEntity$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Entity $entity;
            final /* synthetic */ AudioModelRender this$0;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$entity = entity;
                this.this$0 = this;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, AudioModel.this, entity, this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ICutSession iCutSession) {
                invoke2(iCutSession);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull ICutSession pushCustomCommand) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) pushCustomCommand);
                    return;
                }
                Intrinsics.checkNotNullParameter(pushCustomCommand, "$this$pushCustomCommand");
                InputSource d16 = com.tencent.videocut.render.extension.a.d(AudioModel.this);
                boolean z16 = false;
                if (!Intrinsics.areEqual(pushCustomCommand.accessInputSource(d16.getKey()), d16)) {
                    ICutSession.DefaultImpls.addInputSource$default(pushCustomCommand, d16, false, 2, null);
                }
                Collection<Component> components = this.$entity.getComponents();
                Intrinsics.checkNotNullExpressionValue(components, "entity.components");
                AudioModelRender audioModelRender = this.this$0;
                AudioModel audioModel = AudioModel.this;
                for (Component it : components) {
                    if (it instanceof TimeOffset) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        audioModelRender.C((TimeOffset) it, audioModel);
                    } else if (it instanceof AudioSource) {
                        Intrinsics.checkNotNullExpressionValue(it, "it");
                        audioModelRender.A((AudioSource) it, audioModel);
                    }
                    Intrinsics.checkNotNullExpressionValue(it, "it");
                    if (!pushCustomCommand.componentSupportDynamicModify(it)) {
                        z16 = true;
                    }
                }
                if (z16) {
                    pushCustomCommand.notifyReloadAsset();
                }
            }
        });
    }

    @Override // com.tencent.videocut.render.m
    public void removeEntity(@NotNull Entity entity) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) entity);
        } else {
            Intrinsics.checkNotNullParameter(entity, "entity");
            this.iCutSession.removeEntity(entity);
        }
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    public List<AudioModel> s(@NotNull MediaModel model) {
        List<AudioModel> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (List) iPatchRedirector.redirect((short) 2, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        list = CollectionsKt___CollectionsKt.toList(model.audios.values());
        return list;
    }

    @Override // com.tencent.videocut.render.m
    @NotNull
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Entity b(@NotNull l data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Entity) iPatchRedirector.redirect((short) 5, (Object) this, (Object) data);
        }
        Intrinsics.checkNotNullParameter(data, "data");
        ICutSession.DefaultImpls.addInputSource$default(this.iCutSession, data.b(), false, 2, null);
        this.iCutSession.addBgm(data.a());
        return data.a();
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public String j(@NotNull AudioModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return model.id;
    }

    @Override // com.tencent.videocut.render.a
    @NotNull
    /* renamed from: z, reason: merged with bridge method [inline-methods] */
    public l q(@NotNull AudioModel model) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (l) iPatchRedirector.redirect((short) 3, (Object) this, (Object) model);
        }
        Intrinsics.checkNotNullParameter(model, "model");
        return com.tencent.videocut.render.extension.a.k(model);
    }
}
