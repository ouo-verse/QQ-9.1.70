package com.tencent.mobileqq.troop.homework.notice.remind.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.notice.remind.data.RemindStatus;
import com.tencent.mobileqq.troop.utils.h;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.data.IDynamicParams;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.r;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeReceiverInfo;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeStatisticsReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeStatisticsRsp;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupSchoolNoticeReq;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0017\u0018\u0000 U2\u00020\u00012\u00020\u0002:\u0002VWB\u0019\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001d\u00a2\u0006\u0004\bS\u0010TJ\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0012\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\u0005H\u0002J\u0012\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007H\u0002J\u0006\u0010\f\u001a\u00020\u0005J$\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0007R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010#\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010%\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b$\u0010\"R \u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130'0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u0010)R#\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130'0+8\u0006\u00a2\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00030&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010)R\u001d\u00105\u001a\b\u0012\u0004\u0012\u00020\u00030+8\u0006\u00a2\u0006\f\n\u0004\b3\u0010-\u001a\u0004\b4\u0010/R\"\u00108\u001a\u0010\u0012\f\u0012\n 6*\u0004\u0018\u00010\u00070\u00070&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b7\u0010)R\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00070+8\u0006\u00a2\u0006\f\n\u0004\b9\u0010-\u001a\u0004\b:\u0010/R\u001a\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00070&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b<\u0010)R\u001d\u0010@\u001a\b\u0012\u0004\u0012\u00020\u00070+8\u0006\u00a2\u0006\f\n\u0004\b>\u0010-\u001a\u0004\b?\u0010/R\u001a\u0010C\u001a\b\u0012\u0004\u0012\u00020A0&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bB\u0010)R\u001d\u0010F\u001a\b\u0012\u0004\u0012\u00020A0+8\u0006\u00a2\u0006\f\n\u0004\bD\u0010-\u001a\u0004\bE\u0010/R\u001a\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00070&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bG\u0010)R\u001d\u0010K\u001a\b\u0012\u0004\u0012\u00020\u00070+8\u0006\u00a2\u0006\f\n\u0004\bI\u0010-\u001a\u0004\bJ\u0010/R\u0016\u0010M\u001a\u00020\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bL\u00107R\u0016\u0010P\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bQ\u0010O\u00a8\u0006X"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g;", "Landroidx/lifecycle/ViewModel;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeStatisticCallback;", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "", "R1", "", "isFirstUpdate", ICustomDataEditor.NUMBER_PARAM_2, "l2", "m2", "k2", "errCode", "", "errMsg", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeStatisticsRsp;", "rsp", "onResult", "Lcom/tencent/mobileqq/troop/homework/notice/remind/data/a;", "data", "c2", "d2", "status", SemanticAttributes.DbSystemValues.H2, "Landroid/os/Bundle;", "i", "Landroid/os/Bundle;", "bundle", "Landroid/content/Context;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/content/Context;", "context", BdhLogUtil.LogTag.Tag_Conn, "Ljava/lang/String;", "noticeId", "D", "troopUin", "Landroidx/lifecycle/MutableLiveData;", "", "E", "Landroidx/lifecycle/MutableLiveData;", "_remindList", "Landroidx/lifecycle/LiveData;", UserInfo.SEX_FEMALE, "Landroidx/lifecycle/LiveData;", "X1", "()Landroidx/lifecycle/LiveData;", "remindList", "G", "_waitingRemindCount", "H", "b2", "waitingRemindCount", "kotlin.jvm.PlatformType", "I", "_isEnd", "J", "i2", "isEnd", "K", "_remindBtnClickable", "L", "W1", "remindBtnClickable", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b;", "M", "_selectBtnStatus", "N", "Z1", "selectBtnStatus", "P", "_finishFragment", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "U1", "finishFragment", BdhLogUtil.LogTag.Tag_Req, "waitingRequestPageCnt", ExifInterface.LATITUDE_SOUTH, "Z", "isRequesting", "T", "isSelectAll", "<init>", "(Landroid/os/Bundle;Landroid/content/Context;)V", "U", "a", "b", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class g extends ViewModel implements IGetGroupSchoolNoticeStatisticCallback {
    static IPatchRedirector $redirector_;

    /* renamed from: U, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final String noticeId;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private final String troopUin;

    /* renamed from: E, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<com.tencent.mobileqq.troop.homework.notice.remind.data.a>> _remindList;

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final LiveData<List<com.tencent.mobileqq.troop.homework.notice.remind.data.a>> remindList;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Integer> _waitingRemindCount;

    /* renamed from: H, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Integer> waitingRemindCount;

    /* renamed from: I, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _isEnd;

    /* renamed from: J, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> isEnd;

    /* renamed from: K, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _remindBtnClickable;

    /* renamed from: L, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> remindBtnClickable;

    /* renamed from: M, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<b> _selectBtnStatus;

    /* renamed from: N, reason: from kotlin metadata */
    @NotNull
    private final LiveData<b> selectBtnStatus;

    /* renamed from: P, reason: from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _finishFragment;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private final LiveData<Boolean> finishFragment;

    /* renamed from: R, reason: from kotlin metadata */
    private int waitingRequestPageCnt;

    /* renamed from: S, reason: from kotlin metadata */
    private boolean isRequesting;

    /* renamed from: T, reason: from kotlin metadata */
    private boolean isSelectAll;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Bundle bundle;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final Context context;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$a;", "", "", "PAGE_SIZE", "I", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.g$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0004\u00a2\u0006\u0004\b\u0002\u0010\u0003\u0082\u0001\u0003\u0007\b\t\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b;", "", "<init>", "()V", "a", "b", "c", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b$a;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b$b;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b$c;", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static abstract class b {
        static IPatchRedirector $redirector_;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b$a;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class a extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final a f297328a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54235);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f297328a = new a();
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
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b$b;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.g$b$b, reason: collision with other inner class name */
        /* loaded from: classes19.dex */
        public static final class C8750b extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final C8750b f297329a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54238);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f297329a = new C8750b();
                }
            }

            C8750b() {
                super(null);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003\u00a8\u0006\u0004"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b$c;", "Lcom/tencent/mobileqq/troop/homework/notice/remind/viewmodel/g$b;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes19.dex */
        public static final class c extends b {
            static IPatchRedirector $redirector_;

            /* renamed from: a, reason: collision with root package name */
            @NotNull
            public static final c f297330a;

            static {
                IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54240);
                $redirector_ = redirector;
                if (redirector != null && redirector.hasPatch((short) 2)) {
                    redirector.redirect((short) 2);
                } else {
                    f297330a = new c();
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(54243);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public g(@NotNull Bundle bundle, @Nullable Context context) {
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) bundle, (Object) context);
            return;
        }
        this.bundle = bundle;
        this.context = context;
        String string = bundle.getString("NOTICE_ID", "0");
        Intrinsics.checkNotNullExpressionValue(string, "bundle.getString(HWNoticeArgKey.NOTICE_ID, \"0\")");
        this.noticeId = string;
        String string2 = bundle.getString("TROOP_UIN", "0");
        Intrinsics.checkNotNullExpressionValue(string2, "bundle.getString(HWNoticeArgKey.TROOP_UIN, \"0\")");
        this.troopUin = string2;
        MutableLiveData<List<com.tencent.mobileqq.troop.homework.notice.remind.data.a>> mutableLiveData = new MutableLiveData<>();
        this._remindList = mutableLiveData;
        this.remindList = mutableLiveData;
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
        this.waitingRequestPageCnt = 1;
    }

    private final void R1() {
        ArrayList arrayList = new ArrayList();
        List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> value = this._remindList.getValue();
        if (value != null) {
            for (com.tencent.mobileqq.troop.homework.notice.remind.data.a aVar : value) {
                if (this.isSelectAll) {
                    if (aVar.b() == RemindStatus.STATUS_UNCHECKED) {
                        arrayList.add(Long.valueOf(Long.parseLong(aVar.c())));
                    }
                } else if (aVar.b() == RemindStatus.STATUS_CHECKED) {
                    arrayList.add(Long.valueOf(Long.parseLong(aVar.c())));
                }
            }
        }
        RemindGroupSchoolNoticeReq remindGroupSchoolNoticeReq = new RemindGroupSchoolNoticeReq(this.noticeId, Long.parseLong(this.troopUin), arrayList, this.isSelectAll, 1);
        r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
        if (groupSchoolService != null) {
            groupSchoolService.remindGroupSchoolNotice(remindGroupSchoolNoticeReq, new IOperateCallback() { // from class: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.e
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
        com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.f
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
        } else {
            QQToast.makeText(this$0.context, 1, "\u5f53\u524d\u65e0\u6cd5\u63d0\u9192\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5", 0).show();
        }
    }

    private final int a2() {
        boolean z16;
        List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> value = this._remindList.getValue();
        if (value == null) {
            return 0;
        }
        List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> list = value;
        if ((list instanceof Collection) && list.isEmpty()) {
            return 0;
        }
        Iterator<T> it = list.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (((com.tencent.mobileqq.troop.homework.notice.remind.data.a) it.next()).b() == RemindStatus.STATUS_CHECKED) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16 && (i3 = i3 + 1) < 0) {
                CollectionsKt__CollectionsKt.throwCountOverflow();
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e2(g this$0, DialogInterface dialogInterface, int i3) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.R1();
        dialogInterface.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map g2(g this$0, String str) {
        HashMap hashMapOf;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("remind_num", Integer.valueOf(this$0.a2())));
        return hashMapOf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j2(int i3, GroupSchoolNoticeStatisticsRsp groupSchoolNoticeStatisticsRsp, g this$0) {
        boolean z16;
        RemindStatus remindStatus;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (i3 == 0 && groupSchoolNoticeStatisticsRsp != null) {
            ArrayList arrayList = new ArrayList();
            List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> list = this$0._remindList.getValue();
            if (list != null) {
                Intrinsics.checkNotNullExpressionValue(list, "list");
                arrayList.addAll(list);
            }
            Iterator<GroupSchoolNoticeReceiverInfo> it = groupSchoolNoticeStatisticsRsp.receivers.iterator();
            while (it.hasNext()) {
                GroupSchoolNoticeReceiverInfo next = it.next();
                if (next.remindTime != 0) {
                    remindStatus = RemindStatus.STATUS_HAD_REMINDED;
                } else if (this$0.isSelectAll) {
                    remindStatus = RemindStatus.STATUS_CHECKED;
                } else {
                    remindStatus = RemindStatus.STATUS_UNCHECKED;
                }
                String valueOf = String.valueOf(next.uin);
                String str = next.name;
                Intrinsics.checkNotNullExpressionValue(str, "receiver.name");
                arrayList.add(new com.tencent.mobileqq.troop.homework.notice.remind.data.a(valueOf, remindStatus, str));
            }
            this$0._remindList.setValue(arrayList);
            this$0._waitingRemindCount.setValue(Integer.valueOf(groupSchoolNoticeStatisticsRsp.total - groupSchoolNoticeStatisticsRsp.confirmedCount));
            this$0._isEnd.setValue(Boolean.valueOf(groupSchoolNoticeStatisticsRsp.isEnd));
            if (this$0.waitingRequestPageCnt == 1) {
                z16 = true;
            } else {
                z16 = false;
            }
            this$0.n2(z16);
            this$0.waitingRequestPageCnt++;
        }
        this$0.isRequesting = false;
    }

    private final void l2() {
        List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> value = this._remindList.getValue();
        Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlin.collections.List<com.tencent.mobileqq.troop.homework.notice.remind.data.HWRemindInfo>");
        Iterator<com.tencent.mobileqq.troop.homework.notice.remind.data.a> it = value.iterator();
        while (it.hasNext()) {
            if (it.next().b() == RemindStatus.STATUS_CHECKED) {
                this._remindBtnClickable.postValue(Boolean.TRUE);
                return;
            }
        }
        this._remindBtnClickable.postValue(Boolean.FALSE);
    }

    private final void m2(boolean isFirstUpdate) {
        List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> value = this._remindList.getValue();
        if (value != null) {
            if (isFirstUpdate && (!value.isEmpty())) {
                this._selectBtnStatus.postValue(b.c.f297330a);
                return;
            }
            boolean areEqual = Intrinsics.areEqual(this._isEnd.getValue(), Boolean.TRUE);
            boolean z16 = true;
            boolean z17 = true;
            for (com.tencent.mobileqq.troop.homework.notice.remind.data.a aVar : value) {
                if (aVar.b() != RemindStatus.STATUS_HAD_REMINDED) {
                    z16 = false;
                }
                if (aVar.b() == RemindStatus.STATUS_UNCHECKED) {
                    z17 = false;
                }
            }
            if (areEqual && z16) {
                this._selectBtnStatus.postValue(b.a.f297328a);
            } else if (z17) {
                this.isSelectAll = true;
                this._selectBtnStatus.postValue(b.C8750b.f297329a);
            } else {
                this._selectBtnStatus.postValue(b.c.f297330a);
            }
        }
    }

    private final void n2(boolean isFirstUpdate) {
        l2();
        m2(isFirstUpdate);
    }

    static /* synthetic */ void o2(g gVar, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        gVar.n2(z16);
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
    public final LiveData<List<com.tencent.mobileqq.troop.homework.notice.remind.data.a>> X1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.remindList;
    }

    @NotNull
    public final LiveData<b> Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (LiveData) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.selectBtnStatus;
    }

    @NotNull
    public final LiveData<Integer> b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (LiveData) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.waitingRemindCount;
    }

    public final void c2(@NotNull com.tencent.mobileqq.troop.homework.notice.remind.data.a data) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) data);
            return;
        }
        Intrinsics.checkNotNullParameter(data, "data");
        List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> value = this._remindList.getValue();
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
                if (Intrinsics.areEqual(((com.tencent.mobileqq.troop.homework.notice.remind.data.a) it.next()).c(), data.c())) {
                    com.tencent.mobileqq.troop.homework.notice.remind.data.a aVar = new com.tencent.mobileqq.troop.homework.notice.remind.data.a(data.c(), data.b(), data.a());
                    RemindStatus b16 = aVar.b();
                    RemindStatus remindStatus = RemindStatus.STATUS_UNCHECKED;
                    if (b16 == remindStatus) {
                        aVar.d(RemindStatus.STATUS_CHECKED);
                    } else if (aVar.b() == RemindStatus.STATUS_CHECKED) {
                        aVar.d(remindStatus);
                    }
                    arrayList.set(i3, aVar);
                } else {
                    i3 = i16;
                }
            }
            this._remindList.setValue(arrayList);
        }
        o2(this, false, 1, null);
    }

    public final void d2() {
        Activity activity;
        View view;
        Window window;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        QQCustomDialog createCustomDialog = DialogUtil.createCustomDialog(this.context, 230, (String) null, "\u662f\u5426\u786e\u5b9a\u63d0\u9192\uff1f\u786e\u5b9a\u540e\u9009\u4e2d\u7684\u5b66\u751f\u5bb6\u957f\u4f1a\u6536\u5230\u63d0\u9192\u6d88\u606f\u3002", "\u53d6\u6d88", "\u786e\u5b9a", new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.b
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.e2(g.this, dialogInterface, i3);
            }
        }, new DialogInterface.OnClickListener() { // from class: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.c
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i3) {
                g.f2(dialogInterface, i3);
            }
        });
        createCustomDialog.show();
        com.tencent.mobileqq.troop.homework.notice.report.a aVar = com.tencent.mobileqq.troop.homework.notice.report.a.f297331a;
        TextView btnight = createCustomDialog.getBtnight();
        ExposurePolicy exposurePolicy = ExposurePolicy.REPORT_NONE;
        Context context = this.context;
        if (context instanceof Activity) {
            activity = (Activity) context;
        } else {
            activity = null;
        }
        if (activity != null && (window = activity.getWindow()) != null) {
            view = window.getDecorView();
        } else {
            view = null;
        }
        IDynamicParams iDynamicParams = new IDynamicParams() { // from class: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.d
            @Override // com.tencent.qqlive.module.videoreport.data.IDynamicParams
            public final Map getDynamicParams(String str) {
                Map g26;
                g26 = g.g2(g.this, str);
                return g26;
            }
        };
        Intrinsics.checkNotNullExpressionValue(btnight, "btnight");
        h.a.m(aVar, btnight, "em_group_confirm_remind_btn", exposurePolicy, null, iDynamicParams, view, 8, null);
        TextView btnight2 = createCustomDialog.getBtnight();
        Intrinsics.checkNotNullExpressionValue(btnight2, "dialog.btnight");
        aVar.f(btnight2);
    }

    public final void h2(boolean status) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, status);
            return;
        }
        this.isSelectAll = status;
        List<com.tencent.mobileqq.troop.homework.notice.remind.data.a> value = this._remindList.getValue();
        if (value != null) {
            ArrayList<com.tencent.mobileqq.troop.homework.notice.remind.data.a> arrayList = new ArrayList();
            arrayList.addAll(value);
            int i3 = 0;
            for (com.tencent.mobileqq.troop.homework.notice.remind.data.a aVar : arrayList) {
                int i16 = i3 + 1;
                com.tencent.mobileqq.troop.homework.notice.remind.data.a aVar2 = new com.tencent.mobileqq.troop.homework.notice.remind.data.a(aVar.c(), aVar.b(), aVar.a());
                if (this.isSelectAll) {
                    if (aVar2.b() == RemindStatus.STATUS_UNCHECKED) {
                        aVar2.d(RemindStatus.STATUS_CHECKED);
                    }
                } else if (aVar2.b() == RemindStatus.STATUS_CHECKED) {
                    aVar2.d(RemindStatus.STATUS_UNCHECKED);
                }
                arrayList.set(i3, aVar2);
                i3 = i16;
            }
            this._remindList.setValue(arrayList);
        }
        o2(this, false, 1, null);
    }

    @NotNull
    public final LiveData<Boolean> i2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (LiveData) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return this.isEnd;
    }

    public final void k2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        Boolean value = this._isEnd.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        boolean booleanValue = value.booleanValue();
        if (!this.isRequesting && !booleanValue) {
            this.isRequesting = true;
            GroupSchoolNoticeStatisticsReq groupSchoolNoticeStatisticsReq = new GroupSchoolNoticeStatisticsReq(this.noticeId, Long.parseLong(this.troopUin), 2, this.waitingRequestPageCnt, 50);
            r groupSchoolService = ((IKernelService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IKernelService.class, "all")).getGroupSchoolService();
            if (groupSchoolService != null) {
                groupSchoolService.getGroupSchoolNoticeStatistic(groupSchoolNoticeStatisticsReq, this);
            }
        }
    }

    @Override // com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback
    public void onResult(final int errCode, @Nullable String errMsg, @Nullable final GroupSchoolNoticeStatisticsRsp rsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, Integer.valueOf(errCode), errMsg, rsp);
        } else {
            com.tencent.qav.thread.a.b(new Runnable() { // from class: com.tencent.mobileqq.troop.homework.notice.remind.viewmodel.a
                @Override // java.lang.Runnable
                public final void run() {
                    g.j2(errCode, rsp, this);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f2(DialogInterface dialogInterface, int i3) {
    }
}
