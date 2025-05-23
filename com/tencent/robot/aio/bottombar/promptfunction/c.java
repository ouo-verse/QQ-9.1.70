package com.tencent.robot.aio.bottombar.promptfunction;

import android.view.View;
import b54.FunctionReportArgs;
import com.tencent.aio.data.AIOContact;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.aio.event.AIOMsgSendEvent;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotFeatureInfo;
import com.tencent.qqnt.kernel.nativeinterface.CommonBotInfo;
import com.tencent.robot.slash.businessapi.SearchSessionParams;
import com.tencent.robot.slash.businessapi.c;
import com.tencent.robot.slash.manager.SlashDialogMsgIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;
import w64.n;

/* compiled from: P */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0013B\u0017\u0012\u0006\u0010\u001d\u001a\u00020\u001b\u0012\u0006\u0010 \u001a\u00020\u0014\u00a2\u0006\u0004\b!\u0010\"J\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0014\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\r\u001a\u00020\fH\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016J\u0010\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\b\u0010\u001a\u001a\u00020\u0005H\u0016R\u0014\u0010\u001d\u001a\u00020\u001b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0013\u0010\u001cR\u0014\u0010 \u001a\u00020\u00148\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001f\u00a8\u0006#"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/c;", "Lcom/tencent/robot/slash/businessapi/c;", "Lcom/tencent/mvi/api/runtime/b;", "mviContext", "Lw64/n;", "Lu54/c;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "args", "Lcom/tencent/robot/slash/businessapi/d;", "k", "searchResponse", "", "keyword", "Lcom/tencent/robot/slash/businessapi/a;", "j", "Lb74/a;", "itemData", "", "a", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "d", "f", "c", "l", h.F, "Lcom/tencent/aio/api/runtime/a;", "Lcom/tencent/aio/api/runtime/a;", "mAIOContext", "b", "Landroid/view/View;", "mAnchorView", "<init>", "(Lcom/tencent/aio/api/runtime/a;Landroid/view/View;)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class c implements com.tencent.robot.slash.businessapi.c {

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final a f366954c = new a(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.aio.api.runtime.a mAIOContext;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View mAnchorView;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/robot/aio/bottombar/promptfunction/c$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes25.dex */
    private static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        a() {
        }
    }

    public c(@NotNull com.tencent.aio.api.runtime.a mAIOContext, @NotNull View mAnchorView) {
        Intrinsics.checkNotNullParameter(mAIOContext, "mAIOContext");
        Intrinsics.checkNotNullParameter(mAnchorView, "mAnchorView");
        this.mAIOContext = mAIOContext;
        this.mAnchorView = mAnchorView;
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void a(@NotNull b74.a itemData, @Nullable String keyword) {
        Intrinsics.checkNotNullParameter(itemData, "itemData");
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void b(@NotNull String str, @NotNull String str2) {
        c.a.f(this, str, str2);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void c() {
        this.mAIOContext.e().h(SlashDialogMsgIntent.OnSlashDismissAnimStart.f368545e);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void d(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new AIOMsgSendEvent.SetAIBusinessFlag(4));
        this.mAIOContext.e().h(new SlashDialogMsgIntent.OnSlashDialogChanged(true));
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void e(@NotNull FunctionReportArgs functionReportArgs) {
        c.a.d(this, functionReportArgs);
    }

    @Override // com.tencent.robot.slash.businessapi.c
    public void f(@NotNull View rootView) {
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        this.mAIOContext.e().h(new AIOMsgSendEvent.SetAIBusinessFlag(0));
        this.mAIOContext.e().h(new SlashDialogMsgIntent.OnSlashDialogChanged(false));
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
        return null;
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
        return new f(this.mAIOContext, this);
    }
}
