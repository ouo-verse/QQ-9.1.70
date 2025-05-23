package c44;

import a44.ReviseFunction;
import c44.a;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.robot.aio.input.RobotDrawMsgIntent;
import com.tencent.robot.draw.title.DrawTitleUIState;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\t\u00a2\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000fH\u0014J\u0010\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0002H\u0016J\u0010\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u0013H\u0014R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001d"}, d2 = {"Lc44/h;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "Lc44/a;", "Lcom/tencent/robot/draw/title/DrawTitleUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVM;", "", "t", "", "isChecked", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/robot/aio/input/RobotDrawMsgIntent$SubmitListMsgIntent;", "event", "r", "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "intent", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/robot/draw/title/DrawTitleUIState$TitleBannerState;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/draw/title/DrawTitleUIState$TitleBannerState;", "titleState", "needRegisterHeightProviderCallback", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class h extends SlashDialogVM<a, DrawTitleUIState, w64.e<u54.c>> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private DrawTitleUIState.TitleBannerState titleState;

    public h(boolean z16) {
        super(z16);
    }

    private final void r(RobotDrawMsgIntent.SubmitListMsgIntent event) {
        ReviseFunction reviseFunction;
        a44.a drawData = event.getDrawData();
        if (drawData != null && (reviseFunction = drawData.getReviseFunction()) != null) {
            DrawTitleUIState.TitleBannerState titleBannerState = new DrawTitleUIState.TitleBannerState(reviseFunction.getTitle(), reviseFunction.getQuestionMarkUrl(), reviseFunction.getQuestionMarkMsg());
            this.titleState = titleBannerState;
            Intrinsics.checkNotNull(titleBannerState);
            updateUI(titleBannerState);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void s(boolean isChecked) {
        ((w64.e) getMContext()).e().h(new RobotDrawMsgIntent.OnReviseSwitchChanged(isChecked));
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    protected void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof RobotDrawMsgIntent.SubmitListMsgIntent) {
            r((RobotDrawMsgIntent.SubmitListMsgIntent) event);
        }
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    protected List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsJVMKt.listOf(u64.c.c(Reflection.getOrCreateKotlinClass(RobotDrawMsgIntent.SubmitListMsgIntent.class)));
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: q, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.b) {
            t();
        } else if (intent instanceof a.OnSwitchChanged) {
            s(((a.OnSwitchChanged) intent).getIsChecked());
        }
    }

    private final void t() {
    }
}
