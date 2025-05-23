package com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render;

import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qqvideoedit.thirdparty.logger.Logger;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.FilterModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaClip;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.model.MediaModel;
import com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.y;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.tavcut.rendermodel.entity.Entity;
import com.tencent.tavcut.rendermodel.parser.TemplateParser;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\"\u0010\u0011\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0010\u001a\u00020\u0007H\u0016R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/x;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/a;", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "model", "", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/h;", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/render/q;", "data", "", "y", TemplateParser.KEY_ENTITY_ID, "", "a", "originalEntityId", "oldData", "newData", HippyTKDListViewAdapter.X, "d", "Lcom/tencent/mobileqq/qqvideoedit/thirdparty/videocut/model/MediaModel;", "mediaModel", "Lcom/tencent/tavcut/session/a;", "tavCutSession", "<init>", "(Lcom/tencent/tavcut/session/a;)V", "e", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class x extends a {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private MediaModel mediaModel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(@NotNull com.tencent.tavcut.session.a tavCutSession) {
        super(tavCutSession);
        Intrinsics.checkNotNullParameter(tavCutSession, "tavCutSession");
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.a, com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    public void a(int entityId) {
        Logger.f275870a.b("VideoTrackColorFilterModelRender", "remove adjust " + entityId);
        super.a(entityId);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.b
    @NotNull
    public List<FilterRenderData> s(@NotNull MediaModel model) {
        Intrinsics.checkNotNullParameter(model, "model");
        this.mediaModel = model;
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        for (Object obj : model.videos) {
            int i16 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            FilterModel filterModel = ((MediaClip) obj).filter;
            if (filterModel != null && filterModel.color != null) {
                arrayList.add(new FilterRenderData(i3, filterModel, null, 4, null));
            }
            i3 = i16;
        }
        return arrayList;
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.a, com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public void e(int originalEntityId, @Nullable RenderData oldData, @NotNull RenderData newData) {
        Intrinsics.checkNotNullParameter(newData, "newData");
        Logger.f275870a.b("VideoTrackColorFilterModelRender", "update adjust " + originalEntityId);
        super.e(originalEntityId, oldData, newData);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.thirdparty.videocut.render.r
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public int b(@NotNull RenderData data) {
        Intrinsics.checkNotNullParameter(data, "data");
        y.Companion companion = y.INSTANCE;
        MediaModel mediaModel = this.mediaModel;
        String str = data.getInputSource().key;
        if (str == null) {
            str = "";
        }
        int a16 = companion.a(mediaModel, str);
        if (a16 < 0) {
            a16 = 0;
        }
        Entity b16 = getTavCutSession().b(data.getEntity());
        Logger.f275870a.b("VideoTrackColorFilterModelRender", "add adjust id=" + b16.getId() + " index=" + a16);
        return b16.getId();
    }
}
