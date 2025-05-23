package com.tencent.mobileqq.troop.jointype;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.part.BaseViewModel;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.troop.api.ITroopSystemMsgUtilApi;
import com.tencent.mobileqq.troop.jointype.event.TroopManageSetJoinTypeResultEvent;
import com.tencent.mobileqq.troop.utils.bg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.nativeinterface.GroupExt;
import com.tencent.qqnt.troop.ITroopInfoRepoApi;
import com.tencent.qqnt.troop.ITroopOperationRepoApi;
import com.tencent.qqnt.troop.TroopOperationRepo;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.trpcprotocol.TroopMultiGroupManageSvr$InviteMethod;

/* compiled from: P */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b5\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \u008f\u00012\u00020\u0001:\u0002\u0090\u0001B\t\u00a2\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J&\u0010\u0010\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0002H\u0002J\b\u0010\u0015\u001a\u00020\u0006H\u0002J\u001a\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002J\b\u0010\u001a\u001a\u00020\u0006H\u0002J\b\u0010\u001b\u001a\u00020\u0006H\u0002J\b\u0010\u001c\u001a\u00020\u0002H\u0002J\b\u0010\u001d\u001a\u00020\u0002H\u0002J\b\u0010\u001e\u001a\u00020\u0002H\u0002J\b\u0010\u001f\u001a\u00020\u0002H\u0002J\b\u0010 \u001a\u00020\nH\u0002J\u0010\u0010\"\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0002J\u0010\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\nH\u0002J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0002H\u0002J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0002H\u0002J\u0011\u0010(\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b(\u0010)J\u0011\u0010*\u001a\u0004\u0018\u00010\u0002H\u0002\u00a2\u0006\u0004\b*\u0010)J\b\u0010+\u001a\u00020\u0002H\u0002J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010.\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0016H\u0002J\b\u0010/\u001a\u00020\u0006H\u0002J\b\u00100\u001a\u00020\u0016H\u0016J$\u00104\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u00162\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u00103\u001a\u000202J\u0006\u00105\u001a\u00020\u0006J\u0006\u00106\u001a\u00020\u0006J\u000e\u00107\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011R$\u0010>\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b8\u00109\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010E\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b?\u0010@\u001a\u0004\bA\u0010B\"\u0004\bC\u0010DR&\u0010J\u001a\u0012\u0012\u0004\u0012\u00020\n0Fj\b\u0012\u0004\u0012\u00020\n`G8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bH\u0010IR\u0018\u0010M\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bK\u0010LR\"\u0010T\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010X\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bU\u0010O\u001a\u0004\bV\u0010Q\"\u0004\bW\u0010SR\"\u0010_\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R\"\u0010c\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b`\u0010Z\u001a\u0004\ba\u0010\\\"\u0004\bb\u0010^R\u0016\u0010d\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bO\u0010@R\u0016\u0010f\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\be\u0010eR\"\u0010j\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bg\u0010@\u001a\u0004\bh\u0010B\"\u0004\bi\u0010DR\"\u0010p\u001a\u00020\n8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bk\u0010e\u001a\u0004\bl\u0010m\"\u0004\bn\u0010oR\u0016\u0010r\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bq\u0010@R\u0016\u0010t\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bs\u0010@R\"\u0010x\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\bu\u0010@\u001a\u0004\bv\u0010B\"\u0004\bw\u0010DR\"\u0010|\u001a\u00020\u00028\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\by\u0010@\u001a\u0004\bz\u0010B\"\u0004\b{\u0010DR$\u0010\u0081\u0001\u001a\u0010\u0012\f\u0012\n ~*\u0004\u0018\u00010\u00110\u00110}8\u0002X\u0082\u0004\u00a2\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001R#\u0010\u0087\u0001\u001a\t\u0012\u0004\u0012\u00020\u00110\u0082\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u0083\u0001\u0010\u0084\u0001\u001a\u0006\b\u0085\u0001\u0010\u0086\u0001R%\u0010\u0089\u0001\u001a\u0010\u0012\f\u0012\n ~*\u0004\u0018\u00010\u00020\u00020}8\u0002X\u0082\u0004\u00a2\u0006\b\n\u0006\b\u0088\u0001\u0010\u0080\u0001R#\u0010\u008c\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020\u0082\u00018\u0006\u00a2\u0006\u0010\n\u0006\b\u008a\u0001\u0010\u0084\u0001\u001a\u0006\b\u008b\u0001\u0010\u0086\u0001\u00a8\u0006\u0091\u0001"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM;", "Lcom/tencent/biz/richframework/part/BaseViewModel;", "", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "data", "", "F2", "H2", "", "", "troopUinList", "Lcom/tencent/mobileqq/troop/jointype/troopmanage/multigroup/model/e;", "addMethod", "Ltencent/trpcprotocol/TroopMultiGroupManageSvr$InviteMethod;", "inviteMethod", "M2", "", "newOption", "rstSuccess", Constants.MMCCID, "B2", "", "question", "answer", "z2", Constants.BASE_IN_PLUGIN_VERSION, "p2", "r2", "u2", "y2", "x2", "Z1", com.tencent.mobileqq.msf.core.f0.c.e.h.f248218g, "l2", "mode", ICustomDataEditor.NUMBER_PARAM_2, "K2", "noExamination", "I2", "t2", "()Ljava/lang/Boolean;", "w2", "v2", "wording", "U2", "T2", "X1", "getLogTag", "troopUin", "Landroid/os/Bundle;", "pageArguments", "q2", "V2", "W2", "Y2", "i", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "k2", "()Lcom/tencent/mobileqq/data/troop/TroopInfo;", "setTroopInfo", "(Lcom/tencent/mobileqq/data/troop/TroopInfo;)V", "troopInfo", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Z", ICustomDataEditor.STRING_PARAM_2, "()Z", "setFromMultiGroup", "(Z)V", "isFromMultiGroup", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", BdhLogUtil.LogTag.Tag_Conn, "Ljava/util/ArrayList;", "troopUinListForMultiGroup", "D", "Landroid/os/Bundle;", "pageArgsBundle", "E", "I", "j2", "()I", "setSvcCount", "(I)V", "svcCount", UserInfo.SEX_FEMALE, SemanticAttributes.DbSystemValues.H2, "setOriginOption", "originOption", "G", "Ljava/lang/String;", "e2", "()Ljava/lang/String;", "Q2", "(Ljava/lang/String;)V", "newQuestion", "H", ICustomDataEditor.STRING_ARRAY_PARAM_2, "N2", "newAnswer", "originMemberInviteSwitch", "J", "originMemberInviteMode", "K", "c2", "P2", "newMemberInviteSwitch", "L", "b2", "()J", "O2", "(J)V", "newMemberInviteMode", "M", "originRobotInviteSwitch", "N", "originRobotInviteNoExamination", "P", "g2", "S2", "newRobotInviteSwitch", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "f2", "R2", "newRobotInviteNoExamination", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", BdhLogUtil.LogTag.Tag_Req, "Landroidx/lifecycle/MutableLiveData;", "_newOptionLiveData", "Landroidx/lifecycle/LiveData;", ExifInterface.LATITUDE_SOUTH, "Landroidx/lifecycle/LiveData;", "d2", "()Landroidx/lifecycle/LiveData;", "newOptionLiveData", "T", "_pageFinishLiveData", "U", "i2", "pageFinishLiveData", "<init>", "()V", "V", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopJoinTypeVM extends BaseViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: V, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private ArrayList<Long> troopUinListForMultiGroup;

    /* renamed from: D, reason: from kotlin metadata */
    @Nullable
    private Bundle pageArgsBundle;

    /* renamed from: E, reason: from kotlin metadata */
    private int svcCount;

    /* renamed from: F, reason: from kotlin metadata */
    private int originOption;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private String newQuestion;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private String newAnswer;

    /* renamed from: I, reason: from kotlin metadata */
    private boolean originMemberInviteSwitch;

    /* renamed from: J, reason: from kotlin metadata */
    private long originMemberInviteMode;

    /* renamed from: K, reason: from kotlin metadata */
    private boolean newMemberInviteSwitch;

    /* renamed from: L, reason: from kotlin metadata */
    private long newMemberInviteMode;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean originRobotInviteSwitch;

    /* renamed from: N, reason: from kotlin metadata */
    private boolean originRobotInviteNoExamination;

    /* renamed from: P, reason: from kotlin metadata */
    private boolean newRobotInviteSwitch;

    /* renamed from: Q, reason: from kotlin metadata */
    private boolean newRobotInviteNoExamination;

    /* renamed from: R, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _newOptionLiveData;

    /* renamed from: S, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> newOptionLiveData;

    /* renamed from: T, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _pageFinishLiveData;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> pageFinishLiveData;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private TroopInfo troopInfo;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private boolean isFromMultiGroup;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/jointype/TroopJoinTypeVM$a;", "", "", "ALLOW_MEMBER_INVITE_FLAG", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.jointype.TroopJoinTypeVM$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000026\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0013\u0012\u00110\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u0019\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/jointype/TroopJoinTypeVM$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/data/troop/TroopInfo;", "data", "", "Lcom/tencent/qqnt/troop/FetchTroopInfoCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Function2<Boolean, TroopInfo, Unit> {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeVM.this);
            }
        }

        public void a(boolean isSuccess, @NotNull TroopInfo data) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), data);
            } else {
                Intrinsics.checkNotNullParameter(data, "data");
                TroopJoinTypeVM.this.F2(isSuccess, data);
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopInfo troopInfo) {
            a(bool.booleanValue(), troopInfo);
            return Unit.INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54322);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 29)) {
            redirector.redirect((short) 29);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopJoinTypeVM() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.troopUinListForMultiGroup = new ArrayList<>();
        this.newQuestion = "";
        this.newAnswer = "";
        MutableLiveData<Integer> mutableLiveData = new MutableLiveData<>(-1);
        this._newOptionLiveData = mutableLiveData;
        this.newOptionLiveData = mutableLiveData;
        MutableLiveData<Boolean> mutableLiveData2 = new MutableLiveData<>(Boolean.FALSE);
        this._pageFinishLiveData = mutableLiveData2;
        this.pageFinishLiveData = mutableLiveData2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A2(TroopJoinTypeVM this$0, boolean z16, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (z16) {
            if (this$0.v2()) {
                this$0.svcCount++;
                this$0.D2();
            } else {
                this$0.svcCount++;
                this$0.B2();
            }
        } else if (i3 == 1006) {
            this$0.T2("\u5185\u5bb9\u5305\u542b\u654f\u611f\u8bcd\uff0c\u8bf7\u91cd\u65b0\u8f93\u5165");
        } else {
            QLog.e("TroopJoinTypeVM", 1, "modifyAnswerAndQuestion errCode: " + i3 + " errMsg: " + errMsg);
        }
        this$0.X1();
    }

    private final void B2() {
        String str;
        ITroopOperationRepoApi iTroopOperationRepoApi = (ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class);
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null) {
            str = troopInfo.getTroopUin();
        } else {
            str = null;
        }
        Integer value = this.newOptionLiveData.getValue();
        Intrinsics.checkNotNull(value);
        iTroopOperationRepoApi.modifyTroopJoinTypeFlag(null, str, value.intValue(), new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.jointype.i
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str2) {
                TroopJoinTypeVM.C2(TroopJoinTypeVM.this, z16, i3, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void C2(TroopJoinTypeVM this$0, boolean z16, int i3, String errMsg) {
        Short sh5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        if (z16) {
            TroopInfo troopInfo = this$0.troopInfo;
            if (troopInfo != null) {
                Integer value = this$0.newOptionLiveData.getValue();
                if (value != null) {
                    sh5 = Short.valueOf((short) value.intValue());
                } else {
                    sh5 = null;
                }
                troopInfo.cGroupOption = sh5.shortValue();
            }
        } else {
            QLog.e("TroopJoinTypeVM", 1, "modifyJoinTroopType errCode: " + i3 + " errMsg: " + errMsg);
            this$0.T2("\u4fee\u6539\u7fa4\u8d44\u6599\u5931\u8d25");
        }
        this$0.X1();
    }

    private final void D2() {
        String str;
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null) {
            return;
        }
        Intrinsics.checkNotNull(troopInfo);
        int i3 = ((int) troopInfo.troopPrivilegeFlag) & (-513) & 512;
        QRouteApi api = QRoute.api(ITroopOperationRepoApi.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(ITroopOperationRepoApi::class.java)");
        ITroopOperationRepoApi iTroopOperationRepoApi = (ITroopOperationRepoApi) api;
        TroopInfo troopInfo2 = this.troopInfo;
        if (troopInfo2 != null) {
            str = troopInfo2.getTroopUin();
        } else {
            str = null;
        }
        String str2 = str;
        Integer value = this.newOptionLiveData.getValue();
        Intrinsics.checkNotNull(value);
        iTroopOperationRepoApi.modifyTroopPayToJoinFlag(null, str2, 512, i3, value.intValue(), new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.jointype.f
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i16, String str3) {
                TroopJoinTypeVM.E2(TroopJoinTypeVM.this, z16, i16, str3);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void E2(TroopJoinTypeVM this$0, boolean z16, int i3, String str) {
        Long l3;
        Short sh5;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z16) {
            TroopInfo troopInfo = this$0.troopInfo;
            Long l16 = null;
            if (troopInfo != null) {
                Integer value = this$0.newOptionLiveData.getValue();
                if (value != null) {
                    sh5 = Short.valueOf((short) value.intValue());
                } else {
                    sh5 = null;
                }
                troopInfo.cGroupOption = sh5.shortValue();
            }
            TroopInfo troopInfo2 = this$0.troopInfo;
            if (troopInfo2 != null) {
                if (troopInfo2 != null) {
                    l3 = Long.valueOf(troopInfo2.troopPrivilegeFlag & (-513));
                } else {
                    l3 = null;
                }
                troopInfo2.troopPrivilegeFlag = l3.longValue();
            }
            TroopInfo troopInfo3 = this$0.troopInfo;
            if (troopInfo3 != null) {
                if (troopInfo3 != null) {
                    l16 = Long.valueOf(troopInfo3.troopPrivilegeFlag);
                }
                troopInfo3.dwAppPrivilegeFlag = l16.longValue();
            }
        } else {
            QLog.e("TroopJoinTypeVM", 1, "modifyTroopPayToJoinFlag errCode: " + i3 + " errMsg: " + str);
            this$0.T2("\u62b1\u6b49\uff0c\u4ec5\u7fa4\u4e3b\u624d\u80fd\u4fee\u6539\u4ed8\u8d39\u5165\u7fa4\u9009\u9879\u54e6");
        }
        this$0.X1();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F2(boolean isSuccess, TroopInfo data) {
        TroopInfo troopInfo;
        if (isSuccess && (troopInfo = this.troopInfo) != null) {
            if (troopInfo != null) {
                troopInfo.cGroupOption = data.cGroupOption;
            }
            if (troopInfo != null) {
                troopInfo.joinTroopAnswer = data.joinTroopAnswer;
            }
            if (troopInfo != null) {
                troopInfo.joinTroopQuestion = data.joinTroopQuestion;
            }
            if (troopInfo != null) {
                troopInfo.dwGroupFlagExt3 = data.dwGroupFlagExt3;
            }
            if (troopInfo != null) {
                troopInfo.dwGroupFlagExt = data.dwGroupFlagExt;
            }
            if (troopInfo != null) {
                troopInfo.troopPrivilegeFlag = data.troopPrivilegeFlag;
            }
            H2();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void G2(int newOption, boolean rstSuccess) {
        String str;
        String str2;
        String str3;
        Bundle bundle = this.pageArgsBundle;
        if (bundle == null) {
            return;
        }
        int i3 = -1;
        if (bundle != null) {
            i3 = bundle.getInt("seq", -1);
        }
        int i16 = i3;
        Bundle bundle2 = this.pageArgsBundle;
        String str4 = null;
        if (bundle2 != null) {
            str = bundle2.getString("processName", "");
        } else {
            str = null;
        }
        if (str == null) {
            str2 = "";
        } else {
            str2 = str;
        }
        Bundle bundle3 = this.pageArgsBundle;
        if (bundle3 != null) {
            str4 = bundle3.getString("troopUinList", "");
        }
        if (str4 == null) {
            str3 = "";
        } else {
            str3 = str4;
        }
        SimpleEventBus.getInstance().dispatchEvent(new TroopManageSetJoinTypeResultEvent(i16, str2, newOption, rstSuccess, str3));
        this._pageFinishLiveData.postValue(Boolean.TRUE);
    }

    private final void H2() {
        boolean z16;
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null) {
            return;
        }
        if ((troopInfo.dwGroupFlagExt & 128) == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.originMemberInviteSwitch = z16;
        this.newMemberInviteSwitch = z16;
        long Z1 = Z1();
        this.originMemberInviteMode = Z1;
        this.newMemberInviteMode = Z1;
        this.originRobotInviteSwitch = r2();
        boolean u26 = u2();
        this.originRobotInviteNoExamination = u26;
        this.newRobotInviteSwitch = this.originRobotInviteSwitch;
        this.newRobotInviteNoExamination = u26;
        this._newOptionLiveData.postValue(Integer.valueOf(troopInfo.cGroupOption));
    }

    private final void I2(final boolean noExamination) {
        final int i3;
        final TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null) {
            return;
        }
        if (noExamination) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        TroopOperationRepo.INSTANCE.updateRobotMemberExamine(troopInfo.getTroopUin(), i3, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.jointype.g
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i16, String str) {
                TroopJoinTypeVM.J2(TroopInfo.this, noExamination, i3, this, z16, i16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void J2(TroopInfo mTroopInfo, boolean z16, int i3, TroopJoinTypeVM this$0, boolean z17, int i16, String errMsg) {
        Intrinsics.checkNotNullParameter(mTroopInfo, "$mTroopInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("TroopJoinTypeVM", 1, "[realHandleInviteRobotExamineChanged] troopUin = " + mTroopInfo.getTroopUin() + " switch = " + z16 + " isSuccess = " + z17 + " errCode = " + i16 + " errMsg = " + errMsg);
        if (z17) {
            mTroopInfo.groupExt.inviteRobotMemberExamine = i3;
        }
        this$0.X1();
    }

    private final void K2(final boolean isOpen) {
        final int i3;
        final TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null) {
            return;
        }
        if (isOpen) {
            i3 = 2;
        } else {
            i3 = 1;
        }
        TroopOperationRepo.INSTANCE.updateAllowMemberInviteRobotSwitch(troopInfo.getTroopUin(), i3, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.jointype.j
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i16, String str) {
                TroopJoinTypeVM.L2(TroopInfo.this, isOpen, i3, this, z16, i16, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void L2(TroopInfo mTroopInfo, boolean z16, int i3, TroopJoinTypeVM this$0, boolean z17, int i16, String errMsg) {
        Intrinsics.checkNotNullParameter(mTroopInfo, "$mTroopInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("TroopJoinTypeVM", 1, "[realHandleInviteRobotSwitchChanged] troopUin = " + mTroopInfo.getTroopUin() + " switch = " + z16 + " isSuccess = " + z17 + " errCode = " + i16 + " errMsg = " + errMsg);
        if (z17) {
            mTroopInfo.groupExt.inviteRobotMemberSwitch = i3;
        }
        this$0.X1();
    }

    private final void M2(List<Long> troopUinList, final com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e addMethod, TroopMultiGroupManageSvr$InviteMethod inviteMethod) {
        if (!NetworkUtil.isNetworkAvailable()) {
            T2("\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e");
        } else {
            com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.repo.a.f297668a.b(troopUinList, addMethod, inviteMethod, new Function0<Unit>(addMethod) { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeVM$requestAddMethodForMultiGroup$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e $addMethod;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                    this.$addMethod = addMethod;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeVM.this, (Object) addMethod);
                    }
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                    } else {
                        TroopJoinTypeVM.this.U2("\u8bbe\u7f6e\u6210\u529f");
                        TroopJoinTypeVM.this.G2(this.$addMethod.a(), true);
                    }
                }
            }, new Function2<Integer, String, Unit>(addMethod) { // from class: com.tencent.mobileqq.troop.jointype.TroopJoinTypeVM$requestAddMethodForMultiGroup$2
                static IPatchRedirector $redirector_;
                final /* synthetic */ com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e $addMethod;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                    this.$addMethod = addMethod;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) TroopJoinTypeVM.this, (Object) addMethod);
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                    invoke2(num, str);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@Nullable Integer num, @Nullable String str) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) num, (Object) str);
                        return;
                    }
                    QLog.e("TroopJoinTypeVM", 1, "modifyJoinTroopType errCode: " + num + " errMsg: " + str);
                    TroopJoinTypeVM.this.T2("\u8bbe\u7f6e\u9080\u8bf7\u65b9\u5f0f\u5931\u8d25");
                    TroopJoinTypeVM.this.G2(this.$addMethod.a(), false);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void T2(String wording) {
        QQToast.makeText(BaseApplication.getContext(), 1, wording, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void U2(String wording) {
        QQToast.makeText(BaseApplication.getContext(), 2, wording, 0).show();
    }

    private final void X1() {
        int i3 = this.svcCount - 1;
        this.svcCount = i3;
        if (i3 == 0) {
            this._pageFinishLiveData.postValue(Boolean.TRUE);
        }
    }

    private final long Z1() {
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null) {
            long j3 = troopInfo.troopPrivilegeFlag;
            if ((j3 & 1048576) == 1048576) {
                return 1048576L;
            }
            if ((j3 & 101711872) == 0) {
                return 0L;
            }
            return 67108864L;
        }
        return -1L;
    }

    private final void l2(final boolean isOpen) {
        final TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null) {
            return;
        }
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyAllowMemberInvite(troopInfo.getTroopUin(), isOpen, null, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.jointype.h
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str) {
                TroopJoinTypeVM.m2(TroopInfo.this, isOpen, this, z16, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m2(TroopInfo mTroopInfo, boolean z16, TroopJoinTypeVM this$0, boolean z17, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(mTroopInfo, "$mTroopInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("TroopJoinTypeVM", 1, "[handleAllowMemberInviteChange] troopUin = " + mTroopInfo.getTroopUin() + " switch = " + z16 + " isSuccess = " + z17 + " errCode = " + i3 + " errMsg = " + errMsg);
        if (z17) {
            if (z16) {
                mTroopInfo.dwGroupFlagExt &= -129;
            } else {
                mTroopInfo.dwGroupFlagExt |= 128;
            }
            ((ITroopSystemMsgUtilApi) QRoute.api(ITroopSystemMsgUtilApi.class)).saveTroopFlagExToSP(BaseApplication.getContext(), mTroopInfo.getTroopUin(), mTroopInfo.dwGroupFlagExt);
        } else {
            this$0.T2("\u8bbe\u7f6e\u5141\u8bb8\u7fa4\u6210\u5458\u9080\u8bf7\u5165\u7fa4\u5931\u8d25");
        }
        this$0.X1();
    }

    private final void n2(final long mode) {
        final TroopInfo troopInfo = this.troopInfo;
        if (troopInfo == null) {
            return;
        }
        ((ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class)).modifyTroopPrivilegeFlag(null, troopInfo.getTroopUin(), mode, 101711872L, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.jointype.e
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str) {
                TroopJoinTypeVM.o2(TroopInfo.this, mode, this, z16, i3, str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void o2(TroopInfo mTroopInfo, long j3, TroopJoinTypeVM this$0, boolean z16, int i3, String errMsg) {
        Intrinsics.checkNotNullParameter(mTroopInfo, "$mTroopInfo");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errMsg, "errMsg");
        QLog.i("TroopJoinTypeVM", 1, "[handleInviteModeChange] troopUin = " + mTroopInfo.getTroopUin() + " switch = " + j3 + " isSuccess = " + z16 + " errCode = " + i3 + " errMsg = " + errMsg);
        if (com.tencent.qqnt.e.d(i3)) {
            mTroopInfo.troopPrivilegeFlag = j3 | (mTroopInfo.troopPrivilegeFlag & (~this$0.originMemberInviteMode));
        } else {
            this$0.T2("\u8bbe\u7f6e\u9080\u8bf7\u65b9\u5f0f\u5931\u8d25");
        }
        this$0.X1();
    }

    private final void p2() {
        boolean z16;
        Integer value = this.newOptionLiveData.getValue();
        boolean z17 = false;
        if ((value != null && value.intValue() == 1) || (value != null && value.intValue() == 3)) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16 || (value != null && value.intValue() == 2)) {
            z17 = true;
        }
        if (z17) {
            if (v2()) {
                this.svcCount++;
                D2();
                return;
            } else {
                this.svcCount++;
                B2();
                return;
            }
        }
        if (value != null && value.intValue() == 5) {
            if (v2()) {
                this.svcCount++;
                D2();
                return;
            } else {
                this.svcCount++;
                z2(this.newQuestion, null);
                return;
            }
        }
        if (value != null && value.intValue() == 4) {
            this.svcCount++;
            z2(this.newQuestion, this.newAnswer);
        }
    }

    private final boolean r2() {
        GroupExt groupExt;
        TroopInfo troopInfo = this.troopInfo;
        boolean z16 = false;
        if (troopInfo != null && (groupExt = troopInfo.groupExt) != null && groupExt.inviteRobotMemberSwitch == 1) {
            z16 = true;
        }
        return !z16;
    }

    private final Boolean t2() {
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null) {
            return Boolean.valueOf(TroopInfo.hasPayPrivilege(troopInfo.troopPrivilegeFlag, 128));
        }
        return null;
    }

    private final boolean u2() {
        GroupExt groupExt;
        TroopInfo troopInfo = this.troopInfo;
        boolean z16 = false;
        if (troopInfo != null && (groupExt = troopInfo.groupExt) != null && groupExt.inviteRobotMemberExamine == 2) {
            z16 = true;
        }
        return !z16;
    }

    private final boolean v2() {
        Boolean t26 = t2();
        Boolean bool = Boolean.TRUE;
        if (Intrinsics.areEqual(t26, bool) && Intrinsics.areEqual(w2(), bool)) {
            return true;
        }
        return false;
    }

    private final Boolean w2() {
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null) {
            return Boolean.valueOf(TroopInfo.hasPayPrivilege(troopInfo.troopPrivilegeFlag, 512));
        }
        return null;
    }

    private final boolean x2() {
        if (this.newRobotInviteNoExamination != this.originRobotInviteNoExamination) {
            return true;
        }
        return false;
    }

    private final boolean y2() {
        if (this.newRobotInviteSwitch != this.originRobotInviteSwitch) {
            return true;
        }
        return false;
    }

    private final void z2(String question, String answer) {
        String str;
        ITroopOperationRepoApi iTroopOperationRepoApi = (ITroopOperationRepoApi) QRoute.api(ITroopOperationRepoApi.class);
        TroopInfo troopInfo = this.troopInfo;
        if (troopInfo != null) {
            str = troopInfo.troopuin;
        } else {
            str = null;
        }
        iTroopOperationRepoApi.modifyAnswerAndQuestion(str, question, answer, null, new com.tencent.qqnt.troop.e() { // from class: com.tencent.mobileqq.troop.jointype.k
            @Override // com.tencent.qqnt.troop.e
            public final void onResult(boolean z16, int i3, String str2) {
                TroopJoinTypeVM.A2(TroopJoinTypeVM.this, z16, i3, str2);
            }
        });
    }

    public final void N2(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.newAnswer = str;
        }
    }

    public final void O2(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, j3);
        } else {
            this.newMemberInviteMode = j3;
        }
    }

    public final void P2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, z16);
        } else {
            this.newMemberInviteSwitch = z16;
        }
    }

    public final void Q2(@NotNull String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        } else {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.newQuestion = str;
        }
    }

    public final void R2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, z16);
        } else {
            this.newRobotInviteNoExamination = z16;
        }
    }

    public final void S2(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, z16);
        } else {
            this.newRobotInviteSwitch = z16;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0050, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r1, r4) != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0069, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2) == false) goto L38;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void V2() {
        boolean z16;
        long j3;
        boolean z17;
        String str;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this);
            return;
        }
        if (!NetworkUtil.isNetworkAvailable()) {
            T2("\u7f51\u7edc\u8fde\u63a5\u4e0d\u53ef\u7528\uff0c\u8bf7\u68c0\u67e5\u7f51\u7edc\u8bbe\u7f6e");
            return;
        }
        boolean z18 = false;
        this.svcCount = 0;
        int i3 = this.originOption;
        Integer value = this.newOptionLiveData.getValue();
        if (value != null && i3 == value.intValue()) {
            if (this.newQuestion.length() > 0) {
                z17 = true;
            } else {
                z17 = false;
            }
            String str2 = null;
            if (z17) {
                String str3 = this.newQuestion;
                TroopInfo troopInfo = this.troopInfo;
                if (troopInfo != null) {
                    str = troopInfo.joinTroopQuestion;
                } else {
                    str = null;
                }
            }
            if (this.newAnswer.length() > 0) {
                z18 = true;
            }
            if (z18) {
                String str4 = this.newAnswer;
                TroopInfo troopInfo2 = this.troopInfo;
                if (troopInfo2 != null) {
                    str2 = troopInfo2.joinTroopAnswer;
                }
            }
            if (y2()) {
                this.svcCount++;
                K2(this.newRobotInviteSwitch);
            }
            if (x2()) {
                this.svcCount++;
                I2(this.newRobotInviteNoExamination);
            }
            z16 = this.newMemberInviteSwitch;
            if (z16 != this.originMemberInviteSwitch) {
                this.svcCount++;
                l2(z16);
            }
            j3 = this.newMemberInviteMode;
            if (j3 != this.originMemberInviteMode) {
                this.svcCount++;
                n2(j3);
            }
            if (this.svcCount != 0) {
                this._pageFinishLiveData.postValue(Boolean.TRUE);
                return;
            }
            return;
        }
        p2();
        if (y2()) {
        }
        if (x2()) {
        }
        z16 = this.newMemberInviteSwitch;
        if (z16 != this.originMemberInviteSwitch) {
        }
        j3 = this.newMemberInviteMode;
        if (j3 != this.originMemberInviteMode) {
        }
        if (this.svcCount != 0) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c8  */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v5 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void W2() {
        String str;
        String str2;
        ?? r65;
        ?? r66;
        long j3;
        ?? r67;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            iPatchRedirector.redirect((short) 27, (Object) this);
            return;
        }
        Integer value = this.newOptionLiveData.getValue();
        String str3 = null;
        String str4 = "";
        if (value != null && value.intValue() == 5) {
            str2 = this.newQuestion;
            if (str2.length() == 0) {
                r67 = true;
            } else {
                r67 = false;
            }
            if (r67 != false) {
                TroopInfo troopInfo = this.troopInfo;
                if (troopInfo != null) {
                    str3 = troopInfo.joinTroopQuestion;
                }
                if (str3 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str3, "troopInfo?.joinTroopQuestion ?: \"\"");
                    str2 = str3;
                }
            }
        } else {
            Integer value2 = this.newOptionLiveData.getValue();
            if (value2 == null || value2.intValue() != 4) {
                str = "";
                Integer value3 = this.newOptionLiveData.getValue();
                Intrinsics.checkNotNull(value3);
                com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e eVar = new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e(value3.intValue(), str4, str);
                TroopMultiGroupManageSvr$InviteMethod troopMultiGroupManageSvr$InviteMethod = new TroopMultiGroupManageSvr$InviteMethod();
                troopMultiGroupManageSvr$InviteMethod.allow_invite.set(this.newMemberInviteSwitch ? 1 : 0);
                j3 = this.newMemberInviteMode;
                if (j3 != 1048576) {
                    troopMultiGroupManageSvr$InviteMethod.invite_type.set(0);
                } else if (j3 == 0) {
                    troopMultiGroupManageSvr$InviteMethod.invite_type.set(1);
                } else if (j3 == 67108864) {
                    troopMultiGroupManageSvr$InviteMethod.invite_type.set(2);
                }
                M2(this.troopUinListForMultiGroup, eVar, troopMultiGroupManageSvr$InviteMethod);
            }
            str2 = this.newQuestion;
            if (str2.length() == 0) {
                r65 = true;
            } else {
                r65 = false;
            }
            if (r65 != false) {
                TroopInfo troopInfo2 = this.troopInfo;
                if (troopInfo2 != null) {
                    str2 = troopInfo2.joinTroopQuestion;
                } else {
                    str2 = null;
                }
                if (str2 == null) {
                    str2 = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(str2, "troopInfo?.joinTroopQuestion ?: \"\"");
                }
            }
            String str5 = this.newAnswer;
            if (str5.length() == 0) {
                r66 = true;
            } else {
                r66 = false;
            }
            if (r66 != false) {
                TroopInfo troopInfo3 = this.troopInfo;
                if (troopInfo3 != null) {
                    str3 = troopInfo3.joinTroopAnswer;
                }
                if (str3 != null) {
                    Intrinsics.checkNotNullExpressionValue(str3, "troopInfo?.joinTroopAnswer ?: \"\"");
                    str4 = str3;
                }
            } else {
                str4 = str5;
            }
        }
        String str6 = str4;
        str4 = str2;
        str = str6;
        Integer value32 = this.newOptionLiveData.getValue();
        Intrinsics.checkNotNull(value32);
        com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e eVar2 = new com.tencent.mobileqq.troop.jointype.troopmanage.multigroup.model.e(value32.intValue(), str4, str);
        TroopMultiGroupManageSvr$InviteMethod troopMultiGroupManageSvr$InviteMethod2 = new TroopMultiGroupManageSvr$InviteMethod();
        troopMultiGroupManageSvr$InviteMethod2.allow_invite.set(this.newMemberInviteSwitch ? 1 : 0);
        j3 = this.newMemberInviteMode;
        if (j3 != 1048576) {
        }
        M2(this.troopUinListForMultiGroup, eVar2, troopMultiGroupManageSvr$InviteMethod2);
    }

    public final void Y2(int newOption) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, newOption);
        } else {
            this._newOptionLiveData.postValue(Integer.valueOf(newOption));
        }
    }

    @NotNull
    public final String a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (String) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return this.newAnswer;
    }

    public final long b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Long) iPatchRedirector.redirect((short) 17, (Object) this)).longValue();
        }
        return this.newMemberInviteMode;
    }

    public final boolean c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this)).booleanValue();
        }
        return this.newMemberInviteSwitch;
    }

    @NotNull
    public final LiveData<Integer> d2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return (LiveData) iPatchRedirector.redirect((short) 23, (Object) this);
        }
        return this.newOptionLiveData;
    }

    @NotNull
    public final String e2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (String) iPatchRedirector.redirect((short) 11, (Object) this);
        }
        return this.newQuestion;
    }

    public final boolean f2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            return ((Boolean) iPatchRedirector.redirect((short) 21, (Object) this)).booleanValue();
        }
        return this.newRobotInviteNoExamination;
    }

    public final boolean g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            return ((Boolean) iPatchRedirector.redirect((short) 19, (Object) this)).booleanValue();
        }
        return this.newRobotInviteSwitch;
    }

    @Override // com.tencent.biz.richframework.part.BaseViewModel
    @NotNull
    /* renamed from: getLogTag */
    public String getTAG() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "TroopJoinTypeVM";
    }

    public final int h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this)).intValue();
        }
        return this.originOption;
    }

    @NotNull
    public final LiveData<Boolean> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            return (LiveData) iPatchRedirector.redirect((short) 24, (Object) this);
        }
        return this.pageFinishLiveData;
    }

    public final int j2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Integer) iPatchRedirector.redirect((short) 7, (Object) this)).intValue();
        }
        return this.svcCount;
    }

    @Nullable
    public final TroopInfo k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopInfo) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.troopInfo;
    }

    public final void q2(@NotNull String troopUin, @NotNull List<Long> troopUinList, @NotNull Bundle pageArguments) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            iPatchRedirector.redirect((short) 25, this, troopUin, troopUinList, pageArguments);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        Intrinsics.checkNotNullParameter(troopUinList, "troopUinList");
        Intrinsics.checkNotNullParameter(pageArguments, "pageArguments");
        this.pageArgsBundle = pageArguments;
        if (!troopUinList.isEmpty()) {
            this.isFromMultiGroup = true;
            this.troopUinListForMultiGroup = bg.f302144a.n(troopUinList);
        }
        TroopInfo troopInfoFromCache = ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).getTroopInfoFromCache(troopUin);
        this.troopInfo = troopInfoFromCache;
        if (troopInfoFromCache != null) {
            this.originOption = troopInfoFromCache.cGroupOption;
            H2();
        }
        ((ITroopInfoRepoApi) QRoute.api(ITroopInfoRepoApi.class)).fetchTroopJoinType(troopUin, true, "TroopJoinTypeVM", null, new b());
    }

    public final boolean s2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return this.isFromMultiGroup;
    }
}
