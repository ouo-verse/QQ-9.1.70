package i64;

import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mvi.base.route.MsgIntent;
import com.tencent.mvi.base.route.j;
import com.tencent.robot.slash.businessapi.ConvertSearchTools;
import com.tencent.robot.slash.dialog.content.base.SlashDialogVM;
import com.tencent.robot.slash.dialog.content.title.SlashTitleMsgIntent;
import com.tencent.robot.slash.dialog.content.title.SlashTitleUIState;
import com.tencent.robot.widget.bottomdialog.BottomSheetDialogMsgIntent;
import com.tencent.robot.widget.list.vb.CommonListMsgIntent;
import i64.a;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002*\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0006B\u000f\u0012\u0006\u0010\u001c\u001a\u00020\u001b\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0007H\u0002J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0010H\u0014J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0002H\u0016J\u0010\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0014R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001f"}, d2 = {"Li64/e;", "Lcom/tencent/robot/slash/dialog/content/base/SlashDialogVM;", "Li64/a;", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState;", "Lw64/e;", "Lu54/c;", "Lcom/tencent/robot/slash/dialog/content/base/SlashVM;", "", "t", "v", "Lcom/tencent/robot/widget/list/vb/CommonListMsgIntent$SubmitListMsgIntent;", "event", "u", "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleMsgIntent$RefreshTitle;", ReportConstant.COSTREPORT_PREFIX, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/mvi/base/route/MsgIntent;", "E", "intent", "r", "", "", DomainData.DOMAIN_NAME, "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleBannerState;", BdhLogUtil.LogTag.Tag_Conn, "Lcom/tencent/robot/slash/dialog/content/title/SlashTitleUIState$TitleBannerState;", "titleState", "", "needRegisterHeightProviderCallback", "<init>", "(Z)V", "robot-business-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class e extends SlashDialogVM<a, SlashTitleUIState, w64.e<u54.c>> {

    /* renamed from: C, reason: from kotlin metadata */
    @Nullable
    private SlashTitleUIState.TitleBannerState titleState;

    public e(boolean z16) {
        super(z16);
    }

    private final void q() {
        updateUI(SlashTitleUIState.DialogDismiss.f368508d);
    }

    private final void s(SlashTitleMsgIntent.RefreshTitle event) {
        SlashTitleUIState.TitleBannerState titleBannerState = new SlashTitleUIState.TitleBannerState(event.getTitleStyle(), event.getRobotName(), event.getRobotUin(), event.getRobotTinyId(), event.getCustomTitleInfo());
        this.titleState = titleBannerState;
        Intrinsics.checkNotNull(titleBannerState);
        updateUI(titleBannerState);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void t() {
        Integer num;
        SlashTitleUIState.TitleBannerState titleBannerState = this.titleState;
        if (titleBannerState != null) {
            num = Integer.valueOf(titleBannerState.getTitleStyle());
        } else {
            num = null;
        }
        if (num != null && num.intValue() == 4) {
            ((w64.e) getMContext()).e().h(SlashTitleMsgIntent.OnTitleRightClickMsgIntent.f368500e);
        }
    }

    private final void u(CommonListMsgIntent.SubmitListMsgIntent event) {
        Object firstOrNull;
        SlashTitleMsgIntent.RefreshTitle n3;
        firstOrNull = CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) event.b());
        b74.a aVar = (b74.a) firstOrNull;
        if (aVar != null && (n3 = ConvertSearchTools.f368422a.n(aVar, event.getTitleStyle(), event.getCustomTitleInfo())) != null) {
            SlashTitleUIState.TitleBannerState titleBannerState = new SlashTitleUIState.TitleBannerState(n3.getTitleStyle(), n3.getRobotName(), n3.getRobotUin(), n3.getRobotTinyId(), n3.getCustomTitleInfo());
            this.titleState = titleBannerState;
            Intrinsics.checkNotNull(titleBannerState);
            updateUI(titleBannerState);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void v() {
        SlashTitleUIState.TitleBannerState titleBannerState = this.titleState;
        boolean z16 = false;
        if (titleBannerState != null && titleBannerState.getTitleStyle() == 0) {
            z16 = true;
        }
        if (z16) {
            j e16 = ((w64.e) getMContext()).e();
            SlashTitleUIState.TitleBannerState titleBannerState2 = this.titleState;
            Intrinsics.checkNotNull(titleBannerState2);
            String valueOf = String.valueOf(titleBannerState2.getRobotUin());
            SlashTitleUIState.TitleBannerState titleBannerState3 = this.titleState;
            Intrinsics.checkNotNull(titleBannerState3);
            e16.h(new SlashTitleMsgIntent.OnTitleRobotClickMsgIntent(valueOf, String.valueOf(titleBannerState3.getRobotTinyId())));
        }
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    protected void E(@NotNull MsgIntent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (event instanceof SlashTitleMsgIntent.RefreshTitle) {
            s((SlashTitleMsgIntent.RefreshTitle) event);
        } else if (event instanceof CommonListMsgIntent.SubmitListMsgIntent) {
            u((CommonListMsgIntent.SubmitListMsgIntent) event);
        } else if (event instanceof BottomSheetDialogMsgIntent.OnDialogDismissed) {
            q();
        }
    }

    @Override // com.tencent.robot.slash.dialog.content.base.SlashDialogVM
    @NotNull
    protected List<String> n() {
        List<String> listOf;
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new String[]{u64.c.c(Reflection.getOrCreateKotlinClass(SlashTitleMsgIntent.RefreshTitle.class)), u64.c.c(Reflection.getOrCreateKotlinClass(CommonListMsgIntent.SubmitListMsgIntent.class)), u64.c.c(Reflection.getOrCreateKotlinClass(BottomSheetDialogMsgIntent.OnDialogDismissed.class))});
        return listOf;
    }

    @Override // com.tencent.mvi.mvvm.framework.FrameworkVM
    /* renamed from: r, reason: merged with bridge method [inline-methods] */
    public void handleIntent(@NotNull a intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (intent instanceof a.C10510a) {
            v();
        } else if (intent instanceof a.b) {
            t();
        }
    }
}
