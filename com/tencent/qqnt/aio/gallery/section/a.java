package com.tencent.qqnt.aio.gallery.section;

import android.view.View;
import com.tencent.biz.richframework.part.adapter.section.Section;
import com.tencent.mobileqq.aio.msg.AIOMsgItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.PageReportPolicy;
import com.tencent.richframework.gallery.bean.RFWLayerItemMediaInfo;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0014J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0014J\b\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u000bH\u0016J(\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011H\u0014\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/qqnt/aio/gallery/section/a;", "Lcom/tencent/biz/richframework/part/adapter/section/Section;", "Lcom/tencent/richframework/gallery/bean/RFWLayerItemMediaInfo;", "", "getViewStubLayoutId", "Landroid/view/View;", "containerView", "", "onInitView", "", "p", "", NodeProps.VISIBLE, "onVisibleChanged", "data", "", "position", "", "", "payload", "onBindData", "<init>", "()V", "base_proj_nt_ext_api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes23.dex */
public abstract class a extends Section<RFWLayerItemMediaInfo> {
    static IPatchRedirector $redirector_;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    @NotNull
    public int[] getViewStubLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (int[]) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new int[0];
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public /* bridge */ /* synthetic */ void onBindData(RFWLayerItemMediaInfo rFWLayerItemMediaInfo, int i3, List list) {
        onBindData2(rFWLayerItemMediaInfo, i3, (List<Object>) list);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.biz.richframework.part.adapter.section.Section
    public void onInitView(@NotNull View containerView) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) containerView);
            return;
        }
        Intrinsics.checkNotNullParameter(containerView, "containerView");
        VideoReport.setPageId(containerView, p());
        VideoReport.setPageReportPolicy(containerView, PageReportPolicy.REPORT_NONE);
    }

    @Override // com.tencent.biz.richframework.part.adapter.section.Section, com.tencent.biz.richframework.part.adapter.VisibleAware
    public void onVisibleChanged(boolean visible) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, visible);
            return;
        }
        super.onVisibleChanged(visible);
        if (visible) {
            VideoReport.reportPgIn(this.mRootView);
        } else {
            VideoReport.reportPgOut(this.mRootView);
        }
    }

    @NotNull
    public abstract String p();

    /* renamed from: onBindData, reason: avoid collision after fix types in other method */
    protected void onBindData2(@NotNull RFWLayerItemMediaInfo data, int position, @Nullable List<Object> payload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, data, Integer.valueOf(position), payload);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        HashMap hashMap = new HashMap();
        if (data.getExtraData() instanceof AIOMsgItem) {
            Object extraData = data.getExtraData();
            Intrinsics.checkNotNull(extraData, "null cannot be cast to non-null type com.tencent.mobileqq.aio.msg.AIOMsgItem");
            AIOMsgItem aIOMsgItem = (AIOMsgItem) extraData;
            Pair<Long, Integer> a16 = com.tencent.qqnt.aio.gallery.b.f349994a.a(data);
            if (a16 == null) {
                return;
            }
            hashMap.put("transmission_mode", Integer.valueOf(com.tencent.qqnt.aio.gallery.e.a(aIOMsgItem.getMsgRecord(), a16.getSecond().intValue())));
            hashMap.put("aio_type", Integer.valueOf(aIOMsgItem.getMsgRecord().chatType));
            VideoReport.setPageParams(this.mRootView, new PageParams(hashMap));
        }
    }
}
