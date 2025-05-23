package com.tencent.mobileqq.troop.homework.coursemgr.fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.richframework.part.Part;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicTransFragmentActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.CourseInfo;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.TroopHwCourseMgrRsp;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u00152\u00020\u0001:\u0001\u0016B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u001b\u0010\u0012\u001a\u00020\r8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0017"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "", "getContentLayoutId", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "", "onCreate", "", "Lcom/tencent/biz/richframework/part/Part;", "assembleParts", "", "needImmersive", "Lcom/tencent/mobileqq/troop/homework/coursemgr/vm/a;", BdhLogUtil.LogTag.Tag_Conn, "Lkotlin/Lazy;", "rh", "()Lcom/tencent/mobileqq/troop/homework/coursemgr/vm/a;", "viewModel", "<init>", "()V", "D", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopHwCourseFragment extends QPublicBaseFragment {
    static IPatchRedirector $redirector_;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;
    private static long E;

    /* renamed from: C, reason: from kotlin metadata */
    @NotNull
    private final Lazy viewModel;

    /* compiled from: P */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ4\u0010\r\u001a\u00020\f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\u000e\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0011\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0014\u0010\u0012\u001a\u00020\u00048\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u000fR\u0014\u0010\u0015\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u00068\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0016\u0010\u000fR\u0016\u0010\u0018\u001a\u00020\u00178\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0018\u0010\u0019\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/fragment/TroopHwCourseFragment$a;", "", "Lcom/tencent/mobileqq/app/QBaseActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "", "requestCode", "", "troopUin", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "courseMgrResp", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "courseInfo", "", "a", "OPEN_PARAMS_KEY_COURSE_JSON", "Ljava/lang/String;", "OPEN_PARAMS_KEY_CUR_SELECT_COURSE", "OPEN_PARAMS_KEY_TROOP_UIN", "PAGE_OPEN_MIN_GAP_TIME_MILLIS", "I", "RESULT_PARAMS_KEY_COURSE_JSON", "RESULT_PARAMS_KEY_CUR_SELECT_COURSE", "TAG", "", "lastOpenTimeMillis", "J", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseFragment$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        public final void a(@Nullable QBaseActivity activity, int requestCode, @NotNull String troopUin, @Nullable TroopHwCourseMgrRsp courseMgrResp, @Nullable CourseInfo courseInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, activity, Integer.valueOf(requestCode), troopUin, courseMgrResp, courseInfo);
                return;
            }
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            if (activity != null && courseMgrResp != null && courseInfo != null && System.currentTimeMillis() - TroopHwCourseFragment.E >= 1000) {
                TroopHwCourseFragment.E = System.currentTimeMillis();
                Intent intent = new Intent();
                intent.putExtra("public_fragment_window_feature", 1);
                intent.putExtra(QBaseActivity.KEY_SET_ACTIVITY_ANIMATION, true);
                intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_ENTER_ANIMATION, 0);
                intent.putExtra(QBaseActivity.KEY_ACTIVITY_CLOSE_EXIT_ANIMATION, 0);
                intent.putExtra("troop_uin", troopUin);
                intent.putExtra("open_params_key_course_json", courseMgrResp);
                intent.putExtra("open_params_key_select_course", courseInfo);
                QPublicFragmentActivity.b.e(activity, intent, QPublicTransFragmentActivity.class, TroopHwCourseFragment.class, requestCode);
                return;
            }
            QLog.i("TroopHwCourseFragment", 1, "[openForResult] activity = " + activity + " courseInfo = " + courseInfo + " courseMgrResp = " + courseMgrResp);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50639);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public TroopHwCourseFragment() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.mobileqq.troop.homework.coursemgr.vm.a>() { // from class: com.tencent.mobileqq.troop.homework.coursemgr.fragment.TroopHwCourseFragment$viewModel$2
                static IPatchRedirector $redirector_;

                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHwCourseFragment.this);
                    }
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final com.tencent.mobileqq.troop.homework.coursemgr.vm.a invoke() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    return (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) ? (com.tencent.mobileqq.troop.homework.coursemgr.vm.a) TroopHwCourseFragment.this.getViewModel(com.tencent.mobileqq.troop.homework.coursemgr.vm.a.class) : (com.tencent.mobileqq.troop.homework.coursemgr.vm.a) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            });
            this.viewModel = lazy;
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final com.tencent.mobileqq.troop.homework.coursemgr.vm.a rh() {
        Object value = this.viewModel.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-viewModel>(...)");
        return (com.tencent.mobileqq.troop.homework.coursemgr.vm.a) value;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.interfaces.IPartHost
    @NotNull
    public List<Part> assembleParts() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TroopHwCourseContainerPart());
        arrayList.add(new TroopHwCourseListPart());
        arrayList.add(new TroopHwCourseAddPart());
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.part.BasePartFragment
    public int getContentLayoutId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.layout.g0c;
    }

    @Override // com.tencent.mobileqq.fragment.QPublicBaseFragment, com.tencent.mobileqq.app.QBaseFragment
    public boolean needImmersive() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this)).booleanValue();
        }
        return false;
    }

    @Override // com.tencent.mobileqq.app.QBaseFragment, com.tencent.biz.richframework.compat.CompatPublicFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Intent intent;
        TroopHwCourseMgrRsp troopHwCourseMgrRsp;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) savedInstanceState);
            return;
        }
        super.onCreate(savedInstanceState);
        FragmentActivity activity = getActivity();
        if (activity != null && (intent = activity.getIntent()) != null) {
            try {
                String stringExtra = intent.getStringExtra("troop_uin");
                if (stringExtra == null) {
                    stringExtra = "";
                } else {
                    Intrinsics.checkNotNullExpressionValue(stringExtra, "it.getStringExtra(OPEN_PARAMS_KEY_TROOP_UIN) ?: \"\"");
                }
                Serializable serializableExtra = intent.getSerializableExtra("open_params_key_course_json");
                CourseInfo courseInfo = null;
                if (serializableExtra instanceof TroopHwCourseMgrRsp) {
                    troopHwCourseMgrRsp = (TroopHwCourseMgrRsp) serializableExtra;
                } else {
                    troopHwCourseMgrRsp = null;
                }
                Serializable serializableExtra2 = intent.getSerializableExtra("open_params_key_select_course");
                if (serializableExtra2 instanceof CourseInfo) {
                    courseInfo = (CourseInfo) serializableExtra2;
                }
                if (stringExtra.length() == 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16 || troopHwCourseMgrRsp == null || courseInfo == null) {
                    QLog.i("TroopHwCourseFragment", 1, "[onCreate] troopUin = " + stringExtra + " courseMgrResp = " + troopHwCourseMgrRsp + " courseInfo = " + courseInfo);
                    FragmentActivity activity2 = getActivity();
                    if (activity2 != null) {
                        activity2.finish();
                    }
                }
                rh().X1(stringExtra, troopHwCourseMgrRsp, courseInfo);
            } catch (Exception e16) {
                QLog.i("TroopHwCourseFragment", 1, "[onCreate] exception = " + e16);
            }
        }
    }
}
