package com.tencent.mobileqq.troop.homework.clockin.detail.model.list;

import androidx.lifecycle.MutableLiveData;
import com.qzone.module.feedcomponent.manage.FeedManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qfix.redirect.utils.ReflectUtils;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bJ\b\u0010\u0003\u001a\u00020\u0002H&J#\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H&\u00a2\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0002H&J\b\u0010\u000b\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/e;", "", "", "init", "", "date", "", "needState", "b", "(JLjava/lang/Boolean;)V", FeedManager.LOAD_MORE, "a", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public interface e {
    public static final IPatchRedirector $redirector_ = null;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J4\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/e$a;", "", "Lkotlinx/coroutines/CoroutineScope;", "scope", "", "troopUin", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskData;", "detail", "", "isTeacher", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/vm/a;", "uiState", "Lcom/tencent/mobileqq/troop/homework/clockin/detail/model/list/e;", "a", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.troop.homework.clockin.detail.model.list.e$a, reason: from kotlin metadata */
    /* loaded from: classes19.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ Companion f296363a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42040);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 3)) {
                redirector.redirect((short) 3);
            } else {
                f296363a = new Companion();
            }
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @NotNull
        public final e a(@NotNull CoroutineScope scope, @NotNull String troopUin, @NotNull GroupSchoolTaskData detail, boolean isTeacher, @NotNull MutableLiveData<com.tencent.mobileqq.troop.homework.clockin.detail.vm.a> uiState) {
            e hWClockInDetailListStudentUseCase;
            Long longOrNull;
            Long longOrNull2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (e) iPatchRedirector.redirect((short) 2, this, scope, troopUin, detail, Boolean.valueOf(isTeacher), uiState);
            }
            Intrinsics.checkNotNullParameter(scope, "scope");
            Intrinsics.checkNotNullParameter(troopUin, "troopUin");
            Intrinsics.checkNotNullParameter(detail, "detail");
            Intrinsics.checkNotNullParameter(uiState, "uiState");
            long j3 = 0;
            if (isTeacher) {
                longOrNull2 = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                if (longOrNull2 != null) {
                    j3 = longOrNull2.longValue();
                }
                hWClockInDetailListStudentUseCase = new HWClockInDetailListTeacherUseCase(scope, uiState, j3, detail);
            } else {
                longOrNull = StringsKt__StringNumberConversionsKt.toLongOrNull(troopUin);
                if (longOrNull != null) {
                    j3 = longOrNull.longValue();
                }
                hWClockInDetailListStudentUseCase = new HWClockInDetailListStudentUseCase(scope, uiState, j3, detail);
            }
            return hWClockInDetailListStudentUseCase;
        }
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes19.dex */
    public static final class b {
        public static /* synthetic */ void a(e eVar, long j3, Boolean bool, int i3, Object obj) {
            if (obj == null) {
                if ((i3 & 2) != 0) {
                    bool = null;
                }
                eVar.b(j3, bool);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: switchDate");
        }
    }

    static {
        ReflectUtils.setStaticField(PatchRedirectCenter.getRedirector(42046), (Class<?>) e.class, "$redirector_");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1);
        } else {
            INSTANCE = Companion.f296363a;
        }
    }

    long a();

    void b(long date, @Nullable Boolean needState);

    void init();

    void loadMore();
}
