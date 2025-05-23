package com.tencent.mobileqq.troop.homework.clockin.remind.vm;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.clockin.remind.data.RemindStatus;
import com.tencent.mobileqq.troop.homework.clockin.remind.event.HWClockInRemindEvent;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskUnCheckInReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskUnCheckInRsp;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolUncheckInStudent;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupSchoolNoticeReq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0016\u0018\u0000 a2\u00020\u00012\u00020\u00022\b\u0012\u0004\u0012\u00020\u00040\u0003:\u0002bcB\u0017\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010&\u001a\u00020#\u00a2\u0006\u0004\b_\u0010`J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\b\u0010\u000e\u001a\u00020\tH\u0002J\u0006\u0010\u000f\u001a\u00020\tJ\u0006\u0010\u0010\u001a\u00020\tJ$\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016J\u000e\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007J\u0012\u0010\u0019\u001a\u00020\t2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\u0006\u0010\u001a\u001a\u00020\tJ\b\u0010\u001b\u001a\u00020\tH\u0014J\u0014\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u001d0\u001cH\u0016R\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0014\u0010&\u001a\u00020#8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010%R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R#\u00102\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0(0-8\u0006\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001a\u00104\u001a\b\u0012\u0004\u0012\u00020\u00110'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b3\u0010+R\u001d\u00107\u001a\b\u0012\u0004\u0012\u00020\u00110-8\u0006\u00a2\u0006\f\n\u0004\b5\u0010/\u001a\u0004\b6\u00101R\"\u0010:\u001a\u0010\u0012\f\u0012\n 8*\u0004\u0018\u00010\u00070\u00070'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b9\u0010+R\u001d\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070-8\u0006\u00a2\u0006\f\n\u0004\b;\u0010/\u001a\u0004\b<\u00101R\u001a\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00070'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b>\u0010+R\u001d\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00070-8\u0006\u00a2\u0006\f\n\u0004\b@\u0010/\u001a\u0004\bA\u00101R\u001a\u0010E\u001a\b\u0012\u0004\u0012\u00020C0'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bD\u0010+R\u001d\u0010H\u001a\b\u0012\u0004\u0012\u00020C0-8\u0006\u00a2\u0006\f\n\u0004\bF\u0010/\u001a\u0004\bG\u00101R\u001a\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00070'8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bI\u0010+R\u001d\u0010M\u001a\b\u0012\u0004\u0012\u00020\u00070-8\u0006\u00a2\u0006\f\n\u0004\bK\u0010/\u001a\u0004\bL\u00101R\u0014\u0010P\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bO\u0010@R\u0014\u0010S\u001a\u00020\u00058\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bQ\u0010RR\u0014\u0010U\u001a\u00020N8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bT\u0010@R\u0016\u0010X\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bY\u0010>R\u0016\u0010\\\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b[\u0010WR\u0016\u0010^\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b]\u0010W\u00a8\u0006d"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskUnCheckInCallback;", "Lcom/tencent/biz/richframework/eventbus/SimpleEventReceiver;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "studentUin", "", "isChecked", "", "b2", "R1", "m2", "k2", "l2", "initData", SemanticAttributes.DbSystemValues.H2, "", "errCode", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskUnCheckInRsp;", "rsp", "onResult", "f2", "event", "onReceiveEvent", "c2", "onCleared", "Ljava/util/ArrayList;", "Ljava/lang/Class;", "getEventClass", "Landroid/content/Context;", "i", "Landroid/content/Context;", "context", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;", "fragmentData", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/b;", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/MutableLiveData;", "_studentList", "Landroidx/lifecycle/LiveData;", "D", "Landroidx/lifecycle/LiveData;", "Z1", "()Landroidx/lifecycle/LiveData;", "studentList", "E", "_waitingRemindCount", UserInfo.SEX_FEMALE, ICustomDataEditor.STRING_ARRAY_PARAM_2, "waitingRemindCount", "kotlin.jvm.PlatformType", "G", "_isEnd", "H", "g2", "isEnd", "I", "_remindBtnClickable", "J", "W1", "remindBtnClickable", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b;", "K", "_selectBtnStatus", "L", "X1", "selectBtnStatus", "M", "_finishFragment", "N", "U1", "finishFragment", "", "P", "clockInDate", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/String;", "clockInTaskId", BdhLogUtil.LogTag.Tag_Req, "troopUin", ExifInterface.LATITUDE_SOUTH, "Z", "isAllRemind", "T", "pageIndex", "U", "isRequesting", "V", "isSelectAll", "<init>", "(Landroid/content/Context;Lcom/tencent/mobileqq/troop/homework/clockin/remind/data/a;)V", "W", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends ViewModel implements IGetGroupSchoolTaskUnCheckInCallback, SimpleEventReceiver<SimpleBaseEvent> {
    static IPatchRedirector $redirector_;

    /* renamed from: W, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b>> _studentList;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b>> studentList;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _waitingRemindCount;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> waitingRemindCount;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isEnd;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isEnd;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _remindBtnClickable;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> remindBtnClickable;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _selectBtnStatus;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> selectBtnStatus;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _finishFragment;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> finishFragment;

    /* renamed from: P, reason: from kotlin metadata */
    private final long clockInDate;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final String clockInTaskId;

    /* renamed from: R, reason: from kotlin metadata */
    private final long troopUin;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isAllRemind;

    /* renamed from: T, reason: from kotlin metadata */
    private int pageIndex;

    /* renamed from: U, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: V, reason: from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Context context;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.mobileqq.troop.homework.clockin.remind.data.a fragmentData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$a;", "", "", "PAGE_INDEX_START", "I", "PAGE_SIZE", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.remind.vm.g$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b$a;", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b$b;", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b$c;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b$a;", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f296529a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44521);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f296529a = new a();
                }
            }

            a() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b$b;", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.homework.clockin.remind.vm.g$b$b, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8717b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C8717b f296530a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44524);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f296530a = new C8717b();
                }
            }

            C8717b() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b$c;", "Lcom/tencent/mobileqq/troop/homework/clockin/remind/vm/g$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class c extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f296531a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44525);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f296531a = new c();
                }
            }

            c() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(44527);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull Context context, @NotNull com.tencent.mobileqq.troop.homework.clockin.remind.data.a fragmentData) {
        Long longOrNull;
        long j3;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fragmentData, "fragmentData");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) fragmentData);
            return;
        }
        this.context = context;
        this.fragmentData = fragmentData;
        MutableLiveData<List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b>> mutableLiveData = new MutableLiveData<>();
        this._studentList = mutableLiveData;
        this.studentList = mutableLiveData;
        MutableLiveData<Integer> mutableLiveData2 = new MutableLiveData<>();
        this._waitingRemindCount = mutableLiveData2;
        this.waitingRemindCount = mutableLiveData2;
        MutableLiveData<Boolean> mutableLiveData3 = new MutableLiveData<>(Boolean.FALSE);
        this._isEnd = mutableLiveData3;
        this.isEnd = mutableLiveData3;
        MutableLiveData<Boolean> mutableLiveData4 = new MutableLiveData<>();
        this._remindBtnClickable = mutableLiveData4;
        this.remindBtnClickable = mutableLiveData4;
        MutableLiveData<b> mutableLiveData5 = new MutableLiveData<>();
        this._selectBtnStatus = mutableLiveData5;
        this.selectBtnStatus = mutableLiveData5;
        MutableLiveData<Boolean> mutableLiveData6 = new MutableLiveData<>();
        this._finishFragment = mutableLiveData6;
        this.finishFragment = mutableLiveData6;
        this.clockInDate = fragmentData.a();
        this.clockInTaskId = fragmentData.c();
        longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(fragmentData.e());
        if (longOrNull != null) {
            j3 = longOrNull.longValue();
        } else {
            j3 = 0;
        }
        this.troopUin = j3;
        this.isAllRemind = fragmentData.f();
        this.pageIndex = 1;
        SimpleEventBus.getInstance().registerReceiver(this);
    }

    private final void R1() {
        ArrayList arrayList = new ArrayList();
        List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> value = this._studentList.getValue();
        if (value != null) {
            for (com.tencent.mobileqq.troop.homework.clockin.remind.data.b bVar : value) {
                if (this.isSelectAll) {
                    if (bVar.b() == RemindStatus.STATUS_UNCHECKED) {
                        arrayList.add(Long.valueOf(Long.parseLong(bVar.d())));
                    }
                } else if (bVar.b() == RemindStatus.STATUS_CHECKED) {
                    arrayList.add(Long.valueOf(Long.parseLong(bVar.d())));
                }
            }
        }
        RemindGroupSchoolNoticeReq remindGroupSchoolNoticeReq = new RemindGroupSchoolNoticeReq(this.clockInTaskId, this.troopUin, arrayList, this.isSelectAll, 2);
        r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
        if (groupSchoolService != null) {
            groupSchoolService.remindGroupSchoolNotice(remindGroupSchoolNoticeReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.vm.e
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    g.S1(g.this, i3, str);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void S1(final g this$0, final int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.vm.f
            @Override // java.lang.Runnable
            public final void run() {
                g.T1(i3, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void T1(int i3, g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            QQToast.makeText(this$0.context, 2, "\u5df2\u63d0\u9192", 0).show();
            this$0._finishFragment.postValue(Boolean.TRUE);
            return;
        }
        com.tencent.mobileqq.troop.homework.clockin.a aVar = new com.tencent.mobileqq.troop.homework.clockin.a();
        Context context = this$0.context;
        String a16 = aVar.a(i3);
        if (a16 == null) {
            a16 = "\u5f53\u524d\u65e0\u6cd5\u63d0\u9192\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
        }
        QQToast.makeText(context, 1, a16, 0).show();
    }

    private final void b2(String studentUin, boolean isChecked) {
        List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> value = this._studentList.getValue();
        if (value != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(value);
            Iterator it = arrayList.iterator();
            int i3 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i16 = i3 + 1;
                com.tencent.mobileqq.troop.homework.clockin.remind.data.b bVar = (com.tencent.mobileqq.troop.homework.clockin.remind.data.b) it.next();
                if (Intrinsics.areEqual(bVar.d(), studentUin)) {
                    com.tencent.mobileqq.troop.homework.clockin.remind.data.b bVar2 = new com.tencent.mobileqq.troop.homework.clockin.remind.data.b(bVar.d(), bVar.a(), bVar.c(), bVar.b());
                    RemindStatus b16 = bVar2.b();
                    RemindStatus remindStatus = RemindStatus.STATUS_UNCHECKED;
                    if (b16 == remindStatus) {
                        bVar2.e(RemindStatus.STATUS_CHECKED);
                    } else if (bVar2.b() == RemindStatus.STATUS_CHECKED) {
                        bVar2.e(remindStatus);
                    }
                    arrayList.set(i3, bVar2);
                } else {
                    i3 = i16;
                }
            }
            this._studentList.setValue(arrayList);
        }
        m2();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void d2(g this$0, DialogInterface dialogInterface, int i3) {
        Activity activity;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Context context = this$0.context;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null) {
            h.a.f(com.tencent.mobileqq.troop.homework.clockin.report.a.f296532a, new View(activity), "em_group_confirm_remind_btn", null, activity.getWindow().getDecorView(), 4, null);
        }
        this$0.R1();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void i2(SimpleBaseEvent simpleBaseEvent, g this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (simpleBaseEvent instanceof HWClockInRemindEvent.RemindListItemEvent) {
            HWClockInRemindEvent.RemindListItemEvent remindListItemEvent = (HWClockInRemindEvent.RemindListItemEvent) simpleBaseEvent;
            this$0.b2(remindListItemEvent.getStudentUin(), remindListItemEvent.isChecked());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(int i3, GroupSchoolTaskUnCheckInRsp groupSchoolTaskUnCheckInRsp, g this$0) {
        RemindStatus remindStatus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0) {
            if (groupSchoolTaskUnCheckInRsp != null) {
                ArrayList arrayList = new ArrayList();
                List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> list = this$0._studentList.getValue();
                if (list != null) {
                    Intrinsics.checkNotNullExpressionValue(list, "list");
                    arrayList.addAll(list);
                }
                Iterator<GroupSchoolUncheckInStudent> it = groupSchoolTaskUnCheckInRsp.students.iterator();
                while (it.hasNext()) {
                    GroupSchoolUncheckInStudent next = it.next();
                    if (next.remindTime != 0) {
                        remindStatus = RemindStatus.STATUS_HAD_REMINDED;
                    } else if (this$0.isSelectAll) {
                        remindStatus = RemindStatus.STATUS_CHECKED;
                    } else {
                        remindStatus = RemindStatus.STATUS_UNCHECKED;
                    }
                    RemindStatus remindStatus2 = remindStatus;
                    String valueOf = String.valueOf(next.uin);
                    String str = next.name;
                    Intrinsics.checkNotNullExpressionValue(str, "student.name");
                    arrayList.add(new com.tencent.mobileqq.troop.homework.clockin.remind.data.b(valueOf, str, next.remindTime, remindStatus2));
                }
                this$0._studentList.setValue(arrayList);
                this$0._isEnd.setValue(Boolean.valueOf(groupSchoolTaskUnCheckInRsp.isEnd));
                this$0.m2();
                this$0.pageIndex++;
            }
        } else {
            String a16 = new com.tencent.mobileqq.troop.homework.clockin.a().a(i3);
            if (a16 == null) {
                a16 = "\u7f51\u7edc\u7e41\u5fd9\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5";
            }
            QQToastUtil.showQQToastInUiThread(1, a16);
        }
        this$0.isRequesting = false;
    }

    private final void k2() {
        List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> value = this._studentList.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.troop.homework.clockin.remind.data.HWClockInRemindStudent>");
        Iterator<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> it = value.iterator();
        while (it.hasNext()) {
            if (it.next().b() == RemindStatus.STATUS_CHECKED) {
                this._remindBtnClickable.setValue(Boolean.TRUE);
                return;
            }
        }
        this._remindBtnClickable.setValue(Boolean.FALSE);
    }

    private final void l2() {
        if (this.isAllRemind) {
            this._selectBtnStatus.postValue(b.a.f296529a);
            return;
        }
        List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> value = this._studentList.getValue();
        if (value != null) {
            boolean areEqual = Intrinsics.areEqual(this._isEnd.getValue(), Boolean.TRUE);
            boolean z16 = true;
            boolean z17 = true;
            for (com.tencent.mobileqq.troop.homework.clockin.remind.data.b bVar : value) {
                if (bVar.b() != RemindStatus.STATUS_HAD_REMINDED) {
                    z16 = false;
                }
                if (bVar.b() == RemindStatus.STATUS_UNCHECKED) {
                    z17 = false;
                }
            }
            if (areEqual && z16) {
                this._selectBtnStatus.postValue(b.a.f296529a);
                return;
            }
            if (areEqual && z17) {
                this._selectBtnStatus.postValue(b.C8717b.f296530a);
            } else if (!z17) {
                this._selectBtnStatus.postValue(b.c.f296531a);
            }
        }
    }

    private final void m2() {
        k2();
        l2();
    }

    @NotNull
    public final LiveData<Boolean> U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (LiveData) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.finishFragment;
    }

    @NotNull
    public final LiveData<Boolean> W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (LiveData) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.remindBtnClickable;
    }

    @NotNull
    public final LiveData<b> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.selectBtnStatus;
    }

    @NotNull
    public final LiveData<List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b>> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.studentList;
    }

    @NotNull
    public final LiveData<Integer> a2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.waitingRemindCount;
    }

    public final void c2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            DialogUtil.createCustomDialog(this.context, 230, (String) null, "\u662f\u5426\u786e\u5b9a\u63d0\u9192\uff1f\u786e\u5b9a\u540e\u9009\u4e2d\u7684\u5b66\u751f\u5bb6\u957f\u4f1a\u6536\u5230\u63d0\u9192\u6d88\u606f\u3002", "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.vm.c
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.d2(g.this, dialogInterface, i3);
                }
            }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.vm.d
                @Override // android.content.DialogInterface.OnClickListener
                public final void onClick(DialogInterface dialogInterface, int i3) {
                    g.e2(dialogInterface, i3);
                }
            }).show();
        }
    }

    public final void f2(boolean isChecked) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, isChecked);
            return;
        }
        this.isSelectAll = isChecked;
        List<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> value = this._studentList.getValue();
        if (value != null) {
            ArrayList<com.tencent.mobileqq.troop.homework.clockin.remind.data.b> arrayList = new ArrayList();
            arrayList.addAll(value);
            int i3 = 0;
            for (com.tencent.mobileqq.troop.homework.clockin.remind.data.b bVar : arrayList) {
                int i16 = i3 + 1;
                com.tencent.mobileqq.troop.homework.clockin.remind.data.b bVar2 = new com.tencent.mobileqq.troop.homework.clockin.remind.data.b(bVar.d(), bVar.a(), bVar.c(), bVar.b());
                if (this.isSelectAll) {
                    if (bVar2.b() == RemindStatus.STATUS_UNCHECKED) {
                        bVar2.e(RemindStatus.STATUS_CHECKED);
                    }
                } else if (bVar2.b() == RemindStatus.STATUS_CHECKED) {
                    bVar2.e(RemindStatus.STATUS_UNCHECKED);
                }
                arrayList.set(i3, bVar2);
                i3 = i16;
            }
            this._studentList.setValue(arrayList);
        }
        m2();
    }

    @NotNull
    public final LiveData<Boolean> g2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.isEnd;
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    @NotNull
    public ArrayList<Class<SimpleBaseEvent>> getEventClass() {
        ArrayList<Class<SimpleBaseEvent>> arrayListOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(HWClockInRemindEvent.RemindListItemEvent.class);
            return arrayListOf;
        }
        return (ArrayList) iPatchRedirector.redirect((short) 15, (Object) this);
    }

    public final void h2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        Boolean value = this._isEnd.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        if (!this.isRequesting && !booleanValue) {
            this.isRequesting = true;
            GroupSchoolTaskUnCheckInReq groupSchoolTaskUnCheckInReq = new GroupSchoolTaskUnCheckInReq(this.troopUin, this.clockInTaskId, this.clockInDate, this.pageIndex, 50);
            r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
            if (groupSchoolService != null) {
                groupSchoolService.getGroupSchoolTaskUnCheckInInfo(groupSchoolTaskUnCheckInReq, this);
            }
        }
    }

    public final void initData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        this._studentList.setValue(this.fragmentData.b());
        this._isEnd.setValue(Boolean.valueOf(this.fragmentData.g()));
        this._waitingRemindCount.setValue(Integer.valueOf(this.fragmentData.d()));
        m2();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            super.onCleared();
            SimpleEventBus.getInstance().unRegisterReceiver(this);
        }
    }

    @Override // com.tencent.biz.richframework.eventbus.SimpleEventReceiver
    public void onReceiveEvent(@Nullable final SimpleBaseEvent event) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) event);
        } else {
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.vm.a
                @Override // java.lang.Runnable
                public final void run() {
                    g.i2(SimpleBaseEvent.this, this);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback
    public void onResult(final int errCode, @Nullable String errMsg, @Nullable final GroupSchoolTaskUnCheckInRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Integer.valueOf(errCode), errMsg, rsp);
        } else {
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.clockin.remind.vm.b
                @Override // java.lang.Runnable
                public final void run() {
                    g.j2(errCode, rsp, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(DialogInterface dialogInterface, int i3) {
    }
}
