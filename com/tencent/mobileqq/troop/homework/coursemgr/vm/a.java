package com.tencent.mobileqq.troop.homework.coursemgr.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.troop.homework.coursemgr.intent.d;
import com.tencent.mobileqq.troop.homework.coursemgr.intent.e;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.CourseData;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.CourseInfo;
import com.tencent.mobileqq.troop.homework.coursemgr.repo.TroopHwCourseMgrRsp;
import com.tencent.mobileqq.troop.homework.handler.HomeworkCourseHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.rmonitor.custom.ICustomDataEditor;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 :2\u00020\u0001:\u0001;B\u0007\u00a2\u0006\u0004\b8\u00109J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\"\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\rJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0014\u001a\u00020\u000bJ\u0006\u0010\u0015\u001a\u00020\u000bJ\u0006\u0010\u0017\u001a\u00020\u0016J\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004R\u001a\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001d\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001f8\u0006\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010\u0006\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R$\u00100\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R$\u00107\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b1\u00102\u001a\u0004\b3\u00104\"\u0004\b5\u00106\u00a8\u0006<"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/vm/a;", "Landroidx/lifecycle/ViewModel;", "", "courseName", "", ICustomDataEditor.STRING_ARRAY_PARAM_2, "troopUin", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "courseMgrRsp", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "courseInfo", "", "X1", "", "S1", "R1", "newCourseInfo", "d2", "O1", "M1", "W1", "N1", "", "P1", "b2", "Z1", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/homework/coursemgr/intent/c;", "i", "Landroidx/lifecycle/MutableLiveData;", "_intentMutableLiveData", "Landroidx/lifecycle/LiveData;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroidx/lifecycle/LiveData;", "T1", "()Landroidx/lifecycle/LiveData;", "intentLiveData", BdhLogUtil.LogTag.Tag_Conn, "I", "pageStateStyle", "D", "Ljava/lang/String;", "E", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "Q1", "()Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "c2", "(Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;)V", "courseResp", UserInfo.SEX_FEMALE, "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "U1", "()Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;", "setSelectCourseInfo", "(Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/CourseInfo;)V", "selectCourseInfo", "<init>", "()V", "G", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class a extends ViewModel {
    static IPatchRedirector $redirector_;

    /* renamed from: G, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: C, reason: from kotlin metadata */
    private int pageStateStyle;

    /* renamed from: D, reason: from kotlin metadata */
    @NotNull
    private String troopUin;

    /* renamed from: E, reason: from kotlin metadata */
    @Nullable
    private TroopHwCourseMgrRsp courseResp;

    /* renamed from: F, reason: from kotlin metadata */
    @Nullable
    private CourseInfo selectCourseInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<com.tencent.mobileqq.troop.homework.coursemgr.intent.c> _intentMutableLiveData;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final LiveData<com.tencent.mobileqq.troop.homework.coursemgr.intent.c> intentLiveData;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\n\u0010\u000bR\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00078\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/coursemgr/vm/a$a;", "", "", "MAX_COURSE_NUM", "I", "STATE_STYLE_ADD", "STATE_STYLE_LIST", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.coursemgr.vm.a$a, reason: collision with other inner class name and from kotlin metadata */
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
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000028\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u001b\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/homework/coursemgr/vm/a$b", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "resp", "", "Lcom/tencent/mobileqq/troop/homework/handler/CourseMgrCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class b implements Function2<Boolean, TroopHwCourseMgrRsp, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f296940e;

        b(String str) {
            this.f296940e = str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) str);
            }
        }

        public void a(boolean isSuccess, @Nullable TroopHwCourseMgrRsp resp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), resp);
                return;
            }
            if (isSuccess) {
                a.this.c2(resp);
            } else {
                QLog.i("TroopHwCourseViewModel", 1, "[addCourse] courseName = " + this.f296940e + " resp = " + resp);
            }
            MutableLiveData mutableLiveData = a.this._intentMutableLiveData;
            if (resp != null) {
                i3 = resp.getRetCode();
            }
            mutableLiveData.postValue(new com.tencent.mobileqq.troop.homework.coursemgr.intent.a(isSuccess, i3));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopHwCourseMgrRsp troopHwCourseMgrRsp) {
            a(bool.booleanValue(), troopHwCourseMgrRsp);
            return Unit.INSTANCE;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u000028\u0012\u0013\u0012\u00110\u0002\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\u0015\u0012\u0013\u0018\u00010\u0006\u00a2\u0006\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0001j\u0002`\tJ\u001b\u0010\n\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"com/tencent/mobileqq/troop/homework/coursemgr/vm/a$c", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isSuccess", "Lcom/tencent/mobileqq/troop/homework/coursemgr/repo/TroopHwCourseMgrRsp;", "resp", "", "Lcom/tencent/mobileqq/troop/homework/handler/CourseMgrCallback;", "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes19.dex */
    public static final class c implements Function2<Boolean, TroopHwCourseMgrRsp, Unit> {
        static IPatchRedirector $redirector_;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ CourseInfo f296942e;

        c(CourseInfo courseInfo) {
            this.f296942e = courseInfo;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this, (Object) courseInfo);
            }
        }

        public void a(boolean isSuccess, @Nullable TroopHwCourseMgrRsp resp) {
            IPatchRedirector iPatchRedirector = $redirector_;
            int i3 = 0;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(isSuccess), resp);
                return;
            }
            if (isSuccess) {
                a.this.c2(resp);
            } else {
                QLog.i("TroopHwCourseViewModel", 1, "[deleteCourse] courseInfo = " + this.f296942e + " resp = " + resp);
            }
            MutableLiveData mutableLiveData = a.this._intentMutableLiveData;
            if (resp != null) {
                i3 = resp.getRetCode();
            }
            mutableLiveData.postValue(new com.tencent.mobileqq.troop.homework.coursemgr.intent.b(isSuccess, i3));
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, TroopHwCourseMgrRsp troopHwCourseMgrRsp) {
            a(bool.booleanValue(), troopHwCourseMgrRsp);
            return Unit.INSTANCE;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50874);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 18)) {
            redirector.redirect((short) 18);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        MutableLiveData<com.tencent.mobileqq.troop.homework.coursemgr.intent.c> mutableLiveData = new MutableLiveData<>();
        this._intentMutableLiveData = mutableLiveData;
        this.intentLiveData = mutableLiveData;
        this.pageStateStyle = 1;
        this.troopUin = "";
    }

    private final boolean a2(String courseName) {
        CourseData courseData;
        TroopHwCourseMgrRsp troopHwCourseMgrRsp = this.courseResp;
        if (troopHwCourseMgrRsp != null && (courseData = troopHwCourseMgrRsp.getCourseData()) != null) {
            ArrayList<CourseInfo> defaultList = courseData.getDefaultList();
            if (defaultList != null) {
                Iterator<T> it = defaultList.iterator();
                while (it.hasNext()) {
                    if (Intrinsics.areEqual(((CourseInfo) it.next()).getCourseName(), courseName)) {
                        return true;
                    }
                }
            }
            ArrayList<CourseInfo> customList = courseData.getCustomList();
            if (customList != null) {
                Iterator<T> it5 = customList.iterator();
                while (it5.hasNext()) {
                    if (Intrinsics.areEqual(((CourseInfo) it5.next()).getCourseName(), courseName)) {
                        return true;
                    }
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public final void M1(@NotNull String courseName) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) courseName);
            return;
        }
        Intrinsics.checkNotNullParameter(courseName, "courseName");
        if (a2(courseName)) {
            QQToastUtil.showQQToast(R.string.f23408790);
        } else {
            HomeworkCourseHandler.f297080a.b(this.troopUin, courseName, new b(courseName));
        }
    }

    public final void N1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this);
        } else {
            this.pageStateStyle = 1;
            this._intentMutableLiveData.postValue(new e(1));
        }
    }

    public final void O1(@NotNull CourseInfo courseInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) courseInfo);
        } else {
            Intrinsics.checkNotNullParameter(courseInfo, "courseInfo");
            HomeworkCourseHandler.f297080a.c(this.troopUin, courseInfo.getCourseName(), new c(courseInfo));
        }
    }

    public final int P1() {
        int i3;
        CourseData courseData;
        ArrayList<CourseInfo> customList;
        CourseData courseData2;
        ArrayList<CourseInfo> defaultList;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Integer) iPatchRedirector.redirect((short) 15, (Object) this)).intValue();
        }
        TroopHwCourseMgrRsp troopHwCourseMgrRsp = this.courseResp;
        int i16 = 0;
        if (troopHwCourseMgrRsp != null && (courseData2 = troopHwCourseMgrRsp.getCourseData()) != null && (defaultList = courseData2.getDefaultList()) != null) {
            i3 = defaultList.size();
        } else {
            i3 = 0;
        }
        int i17 = i3 + 0;
        TroopHwCourseMgrRsp troopHwCourseMgrRsp2 = this.courseResp;
        if (troopHwCourseMgrRsp2 != null && (courseData = troopHwCourseMgrRsp2.getCourseData()) != null && (customList = courseData.getCustomList()) != null) {
            i16 = customList.size();
        }
        return i17 + i16;
    }

    @Nullable
    public final TroopHwCourseMgrRsp Q1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (TroopHwCourseMgrRsp) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.courseResp;
    }

    @NotNull
    public final List<CourseInfo> R1() {
        ArrayList<CourseInfo> arrayList;
        CourseData courseData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (List) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        ArrayList arrayList2 = new ArrayList();
        TroopHwCourseMgrRsp troopHwCourseMgrRsp = this.courseResp;
        if (troopHwCourseMgrRsp == null || (courseData = troopHwCourseMgrRsp.getCourseData()) == null || (arrayList = courseData.getCustomList()) == null) {
            arrayList = new ArrayList<>();
        }
        arrayList2.addAll(arrayList);
        return arrayList2;
    }

    @NotNull
    public final List<CourseInfo> S1() {
        ArrayList<CourseInfo> arrayList;
        CourseData courseData;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (List) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        ArrayList arrayList2 = new ArrayList();
        TroopHwCourseMgrRsp troopHwCourseMgrRsp = this.courseResp;
        if (troopHwCourseMgrRsp == null || (courseData = troopHwCourseMgrRsp.getCourseData()) == null || (arrayList = courseData.getDefaultList()) == null) {
            arrayList = new ArrayList<>();
        }
        arrayList2.addAll(arrayList);
        return arrayList2;
    }

    @NotNull
    public final LiveData<com.tencent.mobileqq.troop.homework.coursemgr.intent.c> T1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (LiveData) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.intentLiveData;
    }

    @Nullable
    public final CourseInfo U1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (CourseInfo) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return this.selectCourseInfo;
    }

    public final void W1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
        } else {
            this.pageStateStyle = 2;
            this._intentMutableLiveData.postValue(new e(2));
        }
    }

    public final void X1(@NotNull String troopUin, @Nullable TroopHwCourseMgrRsp courseMgrRsp, @Nullable CourseInfo courseInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, troopUin, courseMgrRsp, courseInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(troopUin, "troopUin");
        this.troopUin = troopUin;
        this.courseResp = courseMgrRsp;
        this.selectCourseInfo = courseInfo;
    }

    public final boolean Z1() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            return ((Boolean) iPatchRedirector.redirect((short) 17, (Object) this)).booleanValue();
        }
        if (this.pageStateStyle == 2) {
            return true;
        }
        return false;
    }

    public final boolean b2() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        if (P1() >= 30) {
            return true;
        }
        return false;
    }

    public final void c2(@Nullable TroopHwCourseMgrRsp troopHwCourseMgrRsp) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) troopHwCourseMgrRsp);
        } else {
            this.courseResp = troopHwCourseMgrRsp;
        }
    }

    public final void d2(@NotNull CourseInfo newCourseInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) newCourseInfo);
            return;
        }
        Intrinsics.checkNotNullParameter(newCourseInfo, "newCourseInfo");
        if (Intrinsics.areEqual(newCourseInfo, this.selectCourseInfo)) {
            return;
        }
        this.selectCourseInfo = newCourseInfo;
        this._intentMutableLiveData.postValue(new d());
    }
}
