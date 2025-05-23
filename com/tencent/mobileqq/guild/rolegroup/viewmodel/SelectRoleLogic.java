package com.tencent.mobileqq.guild.rolegroup.viewmodel;

import androidx.exifinterface.media.ExifInterface;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.guild.rolegroup.model.data.RoleGroupModel;
import com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mtt.hippy.views.textinput.HippyTextInputController;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yx1.RoleSelectItem;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u0000 S2\u00020\u0001:\u0007\u001bZ\u001e!%*[B)\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u001f\u001a\u00020\u001a\u0012\u0006\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010'\u001a\u00020$\u00a2\u0006\u0004\bX\u0010YJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u0006\u0010\t\u001a\u00020\u0004J0\u0010\u0010\u001a\u00020\u00042\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n2\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00020\u000eJ\u0014\u0010\u0012\u001a\u00020\u00042\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0016\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0002J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\f0\u000bJ\u0006\u0010\u0018\u001a\u00020\u0004J\u0006\u0010\u0019\u001a\u00020\u0004R\u0014\u0010\u001d\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001f\u001a\u00020\u001a8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0014\u0010#\u001a\u00020 8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b!\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R \u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u000b0(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010+R\u001a\u00100\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b/\u0010+R\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00070(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b1\u0010+R\"\u00105\u001a\u0010\u0012\f\u0012\n 3*\u0004\u0018\u00010\u00020\u00020(8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b4\u0010+R!\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u00106\u001a\u0004\b7\u00108R!\u0010=\u001a\b\u0012\u0004\u0012\u00020:0\u00068FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b;\u00106\u001a\u0004\b<\u00108R0\u0010C\u001a\b\u0012\u0004\u0012\u00020>0\u000b2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020>0\u000b8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\u0018\u0010@\u001a\u0004\bA\u0010BR\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020>0\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010@R\u001c\u0010H\u001a\b\u0012\u0004\u0012\u00020\u00130E8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bF\u0010GR \u0010M\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020J0I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bK\u0010LR\u001d\u0010O\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u000b0\u00068F\u00a2\u0006\u0006\u001a\u0004\bN\u00108R\u0017\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\bF\u00108R\u0017\u0010R\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\bQ\u00108R\u0017\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068F\u00a2\u0006\u0006\u001a\u0004\bS\u00108R\u0017\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00020\u00068F\u00a2\u0006\u0006\u001a\u0004\bK\u00108R\u0017\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b8F\u00a2\u0006\u0006\u001a\u0004\bV\u0010B\u00a8\u0006\\"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic;", "", "", "w", "", BdhLogUtil.LogTag.Tag_Conn, "Landroidx/lifecycle/LiveData;", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$RunningState;", "j", HippyTKDListViewAdapter.X, "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$d;", "callback", "Lkotlin/Function1;", "filter", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "roles", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "roleId", "isSelect", "y", "t", "l", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "a", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "allRolesFetcher", "b", "selectedRolesFetcher", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$e;", "c", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$e;", "rolesModifier", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$c;", "d", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$c;", "modifiableChecker", "Landroidx/lifecycle/MutableLiveData;", "Lyx1/e;", "e", "Landroidx/lifecycle/MutableLiveData;", "_liveRoleSelectList", "f", "_liveAllRolesFetchState", "g", "_liveSelectedRolesFetchState", tl.h.F, "_liveRoleModifyState", "kotlin.jvm.PlatformType", "i", "_liveIsSelectRolesChanged", "Lkotlin/Lazy;", "r", "()Landroidx/lifecycle/LiveData;", "liveRunningState", "", "k", "getLiveSelectCount", "liveSelectCount", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "<set-?>", "Ljava/util/List;", "v", "()Ljava/util/List;", "selectedRoles", "allRoles", "", DomainData.DOMAIN_NAME, "Ljava/util/Set;", "remoteSelectedRoleIds", "", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$ModifierOperation;", "o", "Ljava/util/Map;", "localOperations", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "liveRoleSelectList", "liveAllRolesFetchState", ReportConstant.COSTREPORT_PREFIX, "liveSelectedRolesFetchState", "p", "liveRoleModifyState", "liveIsSelectRolesChanged", "u", "selectedRoleIds", "<init>", "(Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$e;Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$c;)V", "ModifierOperation", "RunningState", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class SelectRoleLogic {

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b allRolesFetcher;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b selectedRolesFetcher;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final e rolesModifier;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final c modifiableChecker;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<List<RoleSelectItem>> _liveRoleSelectList;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<RunningState> _liveAllRolesFetchState;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<RunningState> _liveSelectedRolesFetchState;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<RunningState> _liveRoleModifyState;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final MutableLiveData<Boolean> _liveIsSelectRolesChanged;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveRunningState;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy liveSelectCount;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<RoleGroupModel> selectedRoles;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private List<RoleGroupModel> allRoles;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private Set<String> remoteSelectedRoleIds;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Map<String, ModifierOperation> localOperations;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$ModifierOperation;", "", "value", "", "(Ljava/lang/String;IZ)V", HippyTextInputController.COMMAND_getValue, "()Z", "ADD", "REMOVE", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum ModifierOperation {
        ADD(true),
        REMOVE(false);

        private final boolean value;

        ModifierOperation(boolean z16) {
            this.value = z16;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$RunningState;", "", "(Ljava/lang/String;I)V", "REQUESTING", "SUBMITTING", com.tencent.tmdownloader.a.CONNTECTSTATE_FINISH, "REQUEST_ERROR", "SUBMIT_ERROR", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public enum RunningState {
        REQUESTING,
        SUBMITTING,
        FINISH,
        REQUEST_ERROR,
        SUBMIT_ERROR
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\t\u0010\nJ\u0018\u0010\u0005\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002H\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$a;", "", "", "Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$RunningState;", "states", "b", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic$a, reason: from kotlin metadata */
    /* loaded from: classes14.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final RunningState b(List<? extends RunningState> states) {
            boolean z16;
            boolean z17;
            boolean z18;
            boolean z19;
            boolean z26;
            boolean z27;
            boolean z28;
            boolean z29;
            boolean z36;
            List<? extends RunningState> list = states;
            boolean z37 = list instanceof Collection;
            boolean z38 = true;
            if (!z37 || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((RunningState) it.next()) == RunningState.FINISH) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    if (!z16) {
                        z17 = false;
                        break;
                    }
                }
            }
            z17 = true;
            if (z17) {
                return RunningState.FINISH;
            }
            if (!z37 || !list.isEmpty()) {
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    if (((RunningState) it5.next()) == RunningState.SUBMITTING) {
                        z18 = true;
                    } else {
                        z18 = false;
                    }
                    if (z18) {
                        z19 = true;
                        break;
                    }
                }
            }
            z19 = false;
            if (z19) {
                return RunningState.SUBMITTING;
            }
            if (!z37 || !list.isEmpty()) {
                Iterator<T> it6 = list.iterator();
                while (it6.hasNext()) {
                    if (((RunningState) it6.next()) == RunningState.REQUESTING) {
                        z26 = true;
                    } else {
                        z26 = false;
                    }
                    if (z26) {
                        z27 = true;
                        break;
                    }
                }
            }
            z27 = false;
            if (z27) {
                return RunningState.REQUESTING;
            }
            if (!z37 || !list.isEmpty()) {
                Iterator<T> it7 = list.iterator();
                while (it7.hasNext()) {
                    if (((RunningState) it7.next()) == RunningState.REQUEST_ERROR) {
                        z28 = true;
                    } else {
                        z28 = false;
                    }
                    if (z28) {
                        z29 = true;
                        break;
                    }
                }
            }
            z29 = false;
            if (z29) {
                return RunningState.REQUEST_ERROR;
            }
            if (!z37 || !list.isEmpty()) {
                Iterator<T> it8 = list.iterator();
                while (it8.hasNext()) {
                    if (((RunningState) it8.next()) == RunningState.SUBMIT_ERROR) {
                        z36 = true;
                    } else {
                        z36 = false;
                    }
                    if (z36) {
                        break;
                    }
                }
            }
            z38 = false;
            if (z38) {
                return RunningState.SUBMIT_ERROR;
            }
            return RunningState.FINISH;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H&\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$b;", "", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "callback", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface b {
        void a(@NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleGroupModel>> callback);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J&\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006H&\u00a8\u0006\t"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$c;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "role", "", "isSelect", "", "allRoles", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface c {
        boolean a(@NotNull RoleGroupModel role, boolean isSelect, @NotNull List<RoleGroupModel> allRoles);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J\t\u0010\u0003\u001a\u00020\u0002H\u00d6\u0001J\t\u0010\u0005\u001a\u00020\u0004H\u00d6\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003R\u0017\u0010\f\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\t\u0010\u000bR\u0017\u0010\u0010\u001a\u00020\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$d;", "", "", "toString", "", "hashCode", "other", "", "equals", "a", "Ljava/lang/String;", "()Ljava/lang/String;", "roleId", "b", "Z", "()Z", "isSelect", "<init>", "(Ljava/lang/String;Z)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic$d, reason: from toString */
    /* loaded from: classes14.dex */
    public static final /* data */ class RoleSelectOperation {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        @NotNull
        private final String roleId;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        private final boolean isSelect;

        public RoleSelectOperation(@NotNull String roleId, boolean z16) {
            Intrinsics.checkNotNullParameter(roleId, "roleId");
            this.roleId = roleId;
            this.isSelect = z16;
        }

        @NotNull
        /* renamed from: a, reason: from getter */
        public final String getRoleId() {
            return this.roleId;
        }

        /* renamed from: b, reason: from getter */
        public final boolean getIsSelect() {
            return this.isSelect;
        }

        public boolean equals(@Nullable Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof RoleSelectOperation)) {
                return false;
            }
            RoleSelectOperation roleSelectOperation = (RoleSelectOperation) other;
            if (Intrinsics.areEqual(this.roleId, roleSelectOperation.roleId) && this.isSelect == roleSelectOperation.isSelect) {
                return true;
            }
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int hashCode = this.roleId.hashCode() * 31;
            boolean z16 = this.isSelect;
            int i3 = z16;
            if (z16 != 0) {
                i3 = 1;
            }
            return hashCode + i3;
        }

        @NotNull
        public String toString() {
            return "RoleSelectOperation(roleId=" + this.roleId + ", isSelect=" + this.isSelect + ")";
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J2\u0010\n\u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$e;", "", "", "", "addRoles", "removeRoles", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "callback", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface e {
        void a(@NotNull List<String> addRoles, @NotNull List<String> removeRoles, @NotNull com.tencent.mobileqq.guild.base.repository.h<Boolean> callback);
    }

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes14.dex */
    public /* synthetic */ class f {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f232892a;

        static {
            int[] iArr = new int[ModifierOperation.values().length];
            try {
                iArr[ModifierOperation.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ModifierOperation.REMOVE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f232892a = iArr;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$g", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class g implements com.tencent.mobileqq.guild.base.repository.h<List<? extends RoleGroupModel>> {
        g() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable List<RoleGroupModel> result) {
            Intrinsics.checkNotNullParameter(error, "error");
            boolean z16 = true;
            if (!error.d()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "Failed fetch all roles: " + error;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.SelectRoleLogic", 1, (String) it.next(), null);
                }
                SelectRoleLogic.this._liveAllRolesFetchState.setValue(RunningState.REQUEST_ERROR);
                return;
            }
            if (result == null) {
                z16 = false;
            }
            if (z16) {
                SelectRoleLogic.this.allRoles = result;
                SelectRoleLogic.this._liveAllRolesFetchState.setValue(RunningState.FINISH);
                SelectRoleLogic.this.C();
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$h", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lcom/tencent/mobileqq/guild/rolegroup/model/data/RoleGroupModel;", "Lri1/a;", "error", "result", "", "b", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class h implements com.tencent.mobileqq.guild.base.repository.h<List<? extends RoleGroupModel>> {
        h() {
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable List<RoleGroupModel> result) {
            int collectionSizeOrDefault;
            Set set;
            Intrinsics.checkNotNullParameter(error, "error");
            boolean z16 = true;
            if (!error.d()) {
                Logger logger = Logger.f235387a;
                Logger.b bVar = new Logger.b();
                String str = "Failed fetch checked roles: " + error;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.SelectRoleLogic", 1, (String) it.next(), null);
                }
                SelectRoleLogic.this._liveSelectedRolesFetchState.setValue(RunningState.REQUEST_ERROR);
                return;
            }
            if (result == null) {
                z16 = false;
            }
            if (z16) {
                SelectRoleLogic selectRoleLogic = SelectRoleLogic.this;
                List<RoleGroupModel> list = result;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                Iterator<T> it5 = list.iterator();
                while (it5.hasNext()) {
                    arrayList.add(((RoleGroupModel) it5.next()).getId());
                }
                set = CollectionsKt___CollectionsKt.toSet(arrayList);
                selectRoleLogic.remoteSelectedRoleIds = set;
                SelectRoleLogic.this._liveSelectedRolesFetchState.setValue(RunningState.FINISH);
                SelectRoleLogic.this.C();
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J!\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a2\u0006\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"com/tencent/mobileqq/guild/rolegroup/viewmodel/SelectRoleLogic$i", "Lcom/tencent/mobileqq/guild/base/repository/h;", "", "Lri1/a;", "error", "result", "", "b", "(Lri1/a;Ljava/lang/Boolean;)V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public static final class i implements com.tencent.mobileqq.guild.base.repository.h<Boolean> {

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.guild.base.repository.h<List<RoleSelectOperation>> f232896b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ List<RoleSelectOperation> f232897c;

        i(com.tencent.mobileqq.guild.base.repository.h<List<RoleSelectOperation>> hVar, List<RoleSelectOperation> list) {
            this.f232896b = hVar;
            this.f232897c = list;
        }

        @Override // com.tencent.mobileqq.guild.base.repository.h
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(@NotNull ri1.a error, @Nullable Boolean result) {
            Intrinsics.checkNotNullParameter(error, "error");
            boolean z16 = true;
            Logger.f235387a.d().i("Guild.rg.SelectRoleLogic", 1, "submitOperations onResult: " + error + ", result: " + result);
            if (!error.d()) {
                Logger.b bVar = new Logger.b();
                String str = "submitOperations onResult failed: " + error + ", result: " + result;
                if (str instanceof String) {
                    bVar.a().add(str);
                }
                Iterator<T> it = bVar.a().iterator();
                while (it.hasNext()) {
                    Logger.f235387a.d().e("Guild.rg.SelectRoleLogic", 1, (String) it.next(), null);
                }
                SelectRoleLogic.this._liveRoleModifyState.setValue(RunningState.SUBMIT_ERROR);
                this.f232896b.a(error, this.f232897c);
                SelectRoleLogic.this.x();
                return;
            }
            if (result == null) {
                z16 = false;
            }
            if (z16) {
                SelectRoleLogic.this._liveRoleModifyState.setValue(RunningState.FINISH);
                this.f232896b.a(error, this.f232897c);
                SelectRoleLogic.this.localOperations.clear();
                SelectRoleLogic.this.x();
                return;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public SelectRoleLogic(@NotNull b allRolesFetcher, @NotNull b selectedRolesFetcher, @NotNull e rolesModifier, @NotNull c modifiableChecker) {
        Lazy lazy;
        Lazy lazy2;
        List<RoleGroupModel> emptyList;
        List<RoleGroupModel> emptyList2;
        Set<String> emptySet;
        Intrinsics.checkNotNullParameter(allRolesFetcher, "allRolesFetcher");
        Intrinsics.checkNotNullParameter(selectedRolesFetcher, "selectedRolesFetcher");
        Intrinsics.checkNotNullParameter(rolesModifier, "rolesModifier");
        Intrinsics.checkNotNullParameter(modifiableChecker, "modifiableChecker");
        this.allRolesFetcher = allRolesFetcher;
        this.selectedRolesFetcher = selectedRolesFetcher;
        this.rolesModifier = rolesModifier;
        this.modifiableChecker = modifiableChecker;
        this._liveRoleSelectList = new MutableLiveData<>();
        this._liveAllRolesFetchState = new MutableLiveData<>();
        this._liveSelectedRolesFetchState = new MutableLiveData<>();
        this._liveRoleModifyState = new MutableLiveData<>();
        this._liveIsSelectRolesChanged = new MutableLiveData<>(Boolean.FALSE);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<LiveData<RunningState>>() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic$liveRunningState$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final LiveData<SelectRoleLogic.RunningState> invoke() {
                LiveData<SelectRoleLogic.RunningState> j3;
                j3 = SelectRoleLogic.this.j();
                return j3;
            }
        });
        this.liveRunningState = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new SelectRoleLogic$liveSelectCount$2(this));
        this.liveSelectCount = lazy2;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        this.selectedRoles = emptyList;
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.allRoles = emptyList2;
        emptySet = SetsKt__SetsKt.emptySet();
        this.remoteSelectedRoleIds = emptySet;
        this.localOperations = new LinkedHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void B(SelectRoleLogic selectRoleLogic, com.tencent.mobileqq.guild.base.repository.h hVar, Function1 function1, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            function1 = new Function1<RoleSelectOperation, Boolean>() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.SelectRoleLogic$submitOperations$1
                @Override // kotlin.jvm.functions.Function1
                @NotNull
                public final Boolean invoke(@NotNull SelectRoleLogic.RoleSelectOperation it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.TRUE;
                }
            };
        }
        selectRoleLogic.A(hVar, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C() {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        int i3;
        List<RoleGroupModel> list = this.allRoles;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (RoleGroupModel roleGroupModel : list) {
            ModifierOperation modifierOperation = this.localOperations.get(roleGroupModel.getId());
            if (modifierOperation == null) {
                i3 = -1;
            } else {
                i3 = f.f232892a[modifierOperation.ordinal()];
            }
            boolean z16 = true;
            if (i3 != 1) {
                if (i3 != 2) {
                    z16 = this.remoteSelectedRoleIds.contains(roleGroupModel.getId());
                } else {
                    z16 = false;
                }
            }
            arrayList.add(new RoleSelectItem(z16, this.modifiableChecker.a(roleGroupModel, z16, this.allRoles), this.remoteSelectedRoleIds.contains(roleGroupModel.getId()), roleGroupModel));
        }
        this._liveRoleSelectList.setValue(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (((RoleSelectItem) obj).getIsSelect()) {
                arrayList2.add(obj);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((RoleSelectItem) it.next()).getRole());
        }
        this.selectedRoles = arrayList3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LiveData<RunningState> j() {
        final List listOf;
        final MediatorLiveData mediatorLiveData = new MediatorLiveData();
        listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new LiveData[]{n(), p(), s()});
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            mediatorLiveData.addSource((LiveData) it.next(), new Observer() { // from class: com.tencent.mobileqq.guild.rolegroup.viewmodel.s
                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    SelectRoleLogic.k(MediatorLiveData.this, listOf, obj);
                }
            });
        }
        return mediatorLiveData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void k(MediatorLiveData<RunningState> mediatorLiveData, List<? extends LiveData<RunningState>> list, Object obj) {
        int collectionSizeOrDefault;
        Companion companion = INSTANCE;
        List<? extends LiveData<RunningState>> list2 = list;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list2, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add((RunningState) ((LiveData) it.next()).getValue());
        }
        mediatorLiveData.setValue(companion.b(arrayList));
    }

    private final boolean w() {
        Map<String, ModifierOperation> map = this.localOperations;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<String, ModifierOperation> entry : map.entrySet()) {
            if (entry.getValue().getValue()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add((String) ((Map.Entry) it.next()).getKey());
        }
        Map<String, ModifierOperation> map2 = this.localOperations;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry<String, ModifierOperation> entry2 : map2.entrySet()) {
            if (!entry2.getValue().getValue()) {
                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
            }
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap2.size());
        Iterator it5 = linkedHashMap2.entrySet().iterator();
        while (it5.hasNext()) {
            arrayList2.add((String) ((Map.Entry) it5.next()).getKey());
        }
        Iterator it6 = arrayList.iterator();
        while (it6.hasNext()) {
            if (!this.remoteSelectedRoleIds.contains((String) it6.next())) {
                return true;
            }
        }
        Iterator it7 = arrayList2.iterator();
        while (it7.hasNext()) {
            if (this.remoteSelectedRoleIds.contains((String) it7.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A(@NotNull com.tencent.mobileqq.guild.base.repository.h<List<RoleSelectOperation>> callback, @NotNull Function1<? super RoleSelectOperation, Boolean> filter) {
        int collectionSizeOrDefault;
        int collectionSizeOrDefault2;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(filter, "filter");
        List<RoleSelectOperation> t16 = t();
        ArrayList arrayList = new ArrayList();
        for (Object obj : t16) {
            if (filter.invoke(obj).booleanValue()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : arrayList) {
            if (((RoleSelectOperation) obj2).getIsSelect()) {
                arrayList2.add(obj2);
            }
        }
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList2, 10);
        ArrayList arrayList3 = new ArrayList(collectionSizeOrDefault);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((RoleSelectOperation) it.next()).getRoleId());
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : arrayList) {
            if (!((RoleSelectOperation) obj3).getIsSelect()) {
                arrayList4.add(obj3);
            }
        }
        collectionSizeOrDefault2 = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList4, 10);
        ArrayList arrayList5 = new ArrayList(collectionSizeOrDefault2);
        Iterator it5 = arrayList4.iterator();
        while (it5.hasNext()) {
            arrayList5.add(((RoleSelectOperation) it5.next()).getRoleId());
        }
        this._liveRoleModifyState.setValue(RunningState.SUBMITTING);
        this.rolesModifier.a(arrayList3, arrayList5, new i(callback, arrayList));
    }

    public final void l() {
        this._liveAllRolesFetchState.setValue(RunningState.REQUESTING);
        this.allRolesFetcher.a(new g());
    }

    public final void m() {
        this._liveSelectedRolesFetchState.setValue(RunningState.REQUESTING);
        this.selectedRolesFetcher.a(new h());
    }

    @NotNull
    public final LiveData<RunningState> n() {
        return this._liveAllRolesFetchState;
    }

    @NotNull
    public final LiveData<Boolean> o() {
        return this._liveIsSelectRolesChanged;
    }

    @NotNull
    public final LiveData<RunningState> p() {
        return this._liveRoleModifyState;
    }

    @NotNull
    public final LiveData<List<RoleSelectItem>> q() {
        return this._liveRoleSelectList;
    }

    @NotNull
    public final LiveData<RunningState> r() {
        return (LiveData) this.liveRunningState.getValue();
    }

    @NotNull
    public final LiveData<RunningState> s() {
        return this._liveSelectedRolesFetchState;
    }

    @NotNull
    public final List<RoleSelectOperation> t() {
        Map<String, ModifierOperation> map = this.localOperations;
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, ModifierOperation> entry : map.entrySet()) {
            arrayList.add(new RoleSelectOperation(entry.getKey(), entry.getValue().getValue()));
        }
        return arrayList;
    }

    @NotNull
    public final List<String> u() {
        int collectionSizeOrDefault;
        List<RoleGroupModel> list = this.selectedRoles;
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(((RoleGroupModel) it.next()).getId());
        }
        return arrayList;
    }

    @NotNull
    public final List<RoleGroupModel> v() {
        return this.selectedRoles;
    }

    public final void x() {
        l();
        m();
    }

    public final void y(@NotNull String roleId, boolean isSelect) {
        List<RoleSelectOperation> listOf;
        Intrinsics.checkNotNullParameter(roleId, "roleId");
        listOf = CollectionsKt__CollectionsJVMKt.listOf(new RoleSelectOperation(roleId, isSelect));
        z(listOf);
    }

    public final void z(@NotNull List<RoleSelectOperation> roles) {
        ModifierOperation modifierOperation;
        Intrinsics.checkNotNullParameter(roles, "roles");
        for (RoleSelectOperation roleSelectOperation : roles) {
            Map<String, ModifierOperation> map = this.localOperations;
            String roleId = roleSelectOperation.getRoleId();
            if (roleSelectOperation.getIsSelect()) {
                modifierOperation = ModifierOperation.ADD;
            } else {
                modifierOperation = ModifierOperation.REMOVE;
            }
            map.put(roleId, modifierOperation);
        }
        C();
        this._liveIsSelectRolesChanged.postValue(Boolean.valueOf(w()));
    }
}
