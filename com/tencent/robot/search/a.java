package com.tencent.robot.search;

import android.text.TextUtils;
import android.view.View;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.robot.aio.input.RobotSearchMsgIntent;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010 \u001a\u00020\u001e\u0012\u0006\u0010#\u001a\u00020\u0017\u00a2\u0006\u0004\b$\u0010%J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016J\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00122\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\tH\u0016R\u0014\u0010 \u001a\u00020\u001e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u001fR\u0014\u0010#\u001a\u00020\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006&"}, d2 = {"Lcom/tencent/robot/search/a;", "Lcom/tencent/robot/slash/businessapi/c;", "Lc64/b;", "searchData", "", DomainData.DOMAIN_NAME, "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", "Lu54/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "", "keyword", "Lcom/tencent/robot/slash/businessapi/a;", "j", "Lb74/a;", "itemData", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "c", "l", h.F, "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "b", "Landroid/view/View;", "mAnchorView", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    public a(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
    }

    private final void n(c64.b searchData) {
        if (searchData != null && !TextUtils.isEmpty(searchData.getTitle())) {
            if (QLog.isColorLevel()) {
                QLog.d("RobotSearchBusinessDelegate", 1, "[handleItemClick]: searchData.title = " + searchData.getTitle());
            }
            this.mAIOContext.e().h(new AIOMsgSendEvent.SendTextWithCallbackData(searchData.getTitle(), searchData.getCallbackData()));
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
        if (itemData instanceof c64.b) {
            n((c64.b) itemData);
        }
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String str, @NotNull String str2) {
        c.a.f(this, str, str2);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        this.mAIOContext.e().h(RobotSearchMsgIntent.OnRobotSearchDismissAnimStart.f367155d);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new AIOMsgSendEvent.SetAIBusinessFlag(1));
        this.mAIOContext.e().h(new RobotSearchMsgIntent.OnRobotSearchDialogChanged(true));
        com.tencent.mobileqq.aio.utils.b.f194119a.p("em_bas_ai_searches_floating");
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs functionReportArgs) {
        c.a.d(this, functionReportArgs);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new AIOMsgSendEvent.SetAIBusinessFlag(0));
        this.mAIOContext.e().h(new RobotSearchMsgIntent.OnRobotSearchDialogChanged(false));
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void g(@NotNull FunctionReportArgs functionReportArgs) {
        c.a.e(this, functionReportArgs);
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    public u54.c h() {
        AIOContact c16 = this.mAIOContext.g().r().c();
        return new u54.c(c16.j(), c16.e());
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public boolean hideKeyboard() {
        return c.a.b(this);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void i(@NotNull CommonBotInfo commonBotInfo, @NotNull CommonBotFeatureInfo commonBotFeatureInfo, int i3) {
        c.a.g(this, commonBotInfo, commonBotFeatureInfo, i3);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public com.tencent.robot.slash.businessapi.a j(@Nullable Object searchResponse, @NotNull String keyword) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        if (!(searchResponse instanceof List)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : (List) searchResponse) {
            if (obj instanceof c64.b) {
                c64.b bVar = (c64.b) obj;
                arrayList.add(new c64.b(bVar.getTitle(), bVar.getCallbackData()));
            }
        }
        return new com.tencent.robot.slash.businessapi.a(arrayList, null, 4);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @Nullable
    public SearchSessionParams k(@Nullable Object args) {
        return null;
    }

    @Override // com.tencent.robot.slash.businessapi.b
    @NotNull
    /* renamed from: l, reason: from getter */
    public View getMAnchorView() {
        return this.mAnchorView;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    @NotNull
    public n<u54.c> m(@NotNull com.tencent.mvi.api.runtime.b mviContext) {
        Intrinsics.checkNotNullParameter(mviContext, "mviContext");
        return new k54.a(this.mAIOContext, this);
    }
}
