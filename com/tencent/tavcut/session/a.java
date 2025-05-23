package com.tencent.tavcut.session;

import com.tencent.hippy.qq.view.pag.HippyQQPagView;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.tavcut.composition.model.component.InputSource;
import com.tencent.tavcut.composition.model.component.Size;
import com.tencent.tavcut.model.TextPlaceInfo;
import com.tencent.tavcut.operator.IClipSourceOperator;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.rendermodel.RenderModel;
import com.tencent.tavcut.rendermodel.component.IdentifyComponent;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import com.tencent.ttpic.videoshelf.data.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\f\u001a\u00020\u000bH&J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH&J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u0010H&J\u001a\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\b\b\u0002\u0010\u0016\u001a\u00020\u0015H&J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u001b\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H&J\u0018\u0010\u001d\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H&J\u0010\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0015H&J\u0010\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H&J\"\u0010&\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00152\u0006\u0010$\u001a\u00020\u00102\b\u0010%\u001a\u0004\u0018\u00010\u0010H&J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 2\u0006\u0010(\u001a\u00020'H&J\u0018\u0010-\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\u00152\u0006\u0010,\u001a\u00020+H&J\u0010\u00100\u001a\u00020\u00042\u0006\u0010/\u001a\u00020.H&J\b\u00102\u001a\u000201H&J\u0010\u00105\u001a\u00020\u00042\u0006\u00104\u001a\u000203H&J\u001e\u00109\u001a\b\u0012\u0004\u0012\u00020\u0015082\u0006\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020'H&J\u001a\u0010;\u001a\u0004\u0018\u00010:2\u0006\u00106\u001a\u00020'2\u0006\u00107\u001a\u00020'H&J\u0018\u0010=\u001a\n\u0012\u0004\u0012\u00020:\u0018\u00010<2\u0006\u0010*\u001a\u00020\u0015H&J\b\u0010>\u001a\u00020\u0004H&J \u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\u00102\u0006\u0010@\u001a\u00020\u00102\u0006\u0010A\u001a\u00020\u0010H&J\b\u0010C\u001a\u00020\u0004H&J\b\u0010D\u001a\u00020\u0004H&\u00a8\u0006E"}, d2 = {"Lcom/tencent/tavcut/session/a;", "", "Lcom/tencent/tavcut/render/player/IPlayer;", "player", "", "p", "l", "Lcom/tencent/tavcut/rendermodel/RenderModel;", "renderModel", "g", "getRenderModel", "", "getTotalDurationUs", "Lcom/tencent/tavcut/composition/model/component/InputSource;", "inputSource", "j", "", "sourceKey", "accessInputSource", "Lcom/tencent/tavcut/rendermodel/entity/Entity;", "entity", "", "index", "i", "parentEntityId", "e", "b", "f", "o", h.F, "id", "a", "Lcom/tencent/tavcut/composition/model/component/Size;", "renderSize", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "backgroundFillMode", "backColor", Constants.PAG_FILE_PATH, "updateBackground", "", "fillScale", DomainData.DOMAIN_NAME, TemplateParser.KEY_ENTITY_ID, "Lcom/tencent/tavcut/rendermodel/component/IdentifyComponent;", "identifyComponent", "c", "Lcom/tencent/tavcut/session/d;", "listener", "k", "Lcom/tencent/tavcut/operator/IClipSourceOperator;", "getClipSourceOperator", "Lfe4/a;", "effectNode", "d", HippyTKDListViewAdapter.X, "y", "Ljava/util/ArrayList;", "getEntitiesUnderPoint", "Lcom/tencent/tavcut/model/TextPlaceInfo;", "getEditableTextUnderPoint", "", "getEditableTextByEntityId", "release", "fontFamily", "fontStyle", "fontPath", "registerFont", HippyQQPagView.FunctionName.FLUSH, "flushWithoutDelay", "lib_tavcut_release"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes26.dex */
public interface a {

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    /* renamed from: com.tencent.tavcut.session.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9882a {
        public static /* synthetic */ Entity a(a aVar, Entity entity, int i3, int i16, Object obj) {
            if (obj == null) {
                if ((i16 & 2) != 0) {
                    i3 = -1;
                }
                return aVar.i(entity, i3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEffect");
        }
    }

    void a(int id5);

    @Nullable
    InputSource accessInputSource(@NotNull String sourceKey);

    @NotNull
    Entity b(@NotNull Entity entity);

    void c(int entityId, @NotNull IdentifyComponent identifyComponent);

    void d(@NotNull fe4.a effectNode);

    @NotNull
    Entity e(int parentEntityId, @NotNull Entity entity);

    @NotNull
    Entity f(@NotNull Entity entity, int index);

    void flush();

    void flushWithoutDelay();

    void g(@NotNull RenderModel renderModel);

    @NotNull
    /* renamed from: getClipSourceOperator */
    IClipSourceOperator getIClipSourceOperator();

    @Nullable
    List<TextPlaceInfo> getEditableTextByEntityId(int entityId);

    @Nullable
    TextPlaceInfo getEditableTextUnderPoint(float x16, float y16);

    @NotNull
    ArrayList<Integer> getEntitiesUnderPoint(float x16, float y16);

    @Nullable
    RenderModel getRenderModel();

    long getTotalDurationUs();

    @NotNull
    Entity h(@NotNull Entity entity, int index);

    @NotNull
    Entity i(@NotNull Entity entity, int index);

    void j(@NotNull InputSource inputSource);

    void k(@NotNull d listener);

    void l(@Nullable IPlayer player);

    void n(@NotNull Size renderSize, float fillScale);

    @NotNull
    Entity o(@NotNull Entity entity);

    void p(@NotNull IPlayer player);

    void q(@NotNull Size renderSize);

    void registerFont(@NotNull String fontFamily, @NotNull String fontStyle, @NotNull String fontPath);

    void release();

    void updateBackground(int backgroundFillMode, @NotNull String backColor, @Nullable String pagFilePath);
}
