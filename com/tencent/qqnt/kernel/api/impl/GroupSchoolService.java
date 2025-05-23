package com.tencent.qqnt.kernel.api.impl;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qqnt.kernel.nativeinterface.BatchGetGroupSchoolRoleReq;
import com.tencent.qqnt.kernel.nativeinterface.CheckInGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.ConfirmGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.DeleteGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GetGroupSchoolNoticeListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolNoticeStatisticsReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskCheckInInfoReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskDetailReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskListReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskStatisticsReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTaskUnCheckInReq;
import com.tencent.qqnt.kernel.nativeinterface.GroupSchoolTemplateListReq;
import com.tencent.qqnt.kernel.nativeinterface.IBatchGetUserGroupSchoolRoleCallback;
import com.tencent.qqnt.kernel.nativeinterface.ICheckInGroupSchoolTaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.IConfirmGroupSchoolNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolNoticeStatisticCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskCheckInInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskDetailCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskStatisticsCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTaskUnCheckInCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolTemplateListCallback;
import com.tencent.qqnt.kernel.nativeinterface.IGetGroupSchoolToolboxInfoCallback;
import com.tencent.qqnt.kernel.nativeinterface.IKernelGroupSchoolService;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolNoticeCallback;
import com.tencent.qqnt.kernel.nativeinterface.IPublishGroupSchoolTaskCallback;
import com.tencent.qqnt.kernel.nativeinterface.ModGroupSchoolTaskStatusReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolNoticeReq;
import com.tencent.qqnt.kernel.nativeinterface.PublishGroupSchoolTaskReq;
import com.tencent.qqnt.kernel.nativeinterface.RemindGroupSchoolNoticeReq;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00d0\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 A2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001BB\u0019\u0012\b\u0010<\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010>\u001a\u00020=\u00a2\u0006\u0004\b?\u0010@J\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u001a\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\r2\b\u0010\u0007\u001a\u0004\u0018\u00010\u000eH\u0016J\u001a\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00132\b\u0010\u0007\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00162\b\u0010\u0007\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00192\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u001d\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u001b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010 \u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u001e2\b\u0010\u0007\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010#\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020!2\b\u0010\u0007\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010%\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020$2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010(\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020&2\b\u0010\u0007\u001a\u0004\u0018\u00010'H\u0016J\u001a\u0010+\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020)2\b\u0010\u0007\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010.\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020,2\b\u0010\u0007\u001a\u0004\u0018\u00010-H\u0016J\u001a\u00101\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020/2\b\u0010\u0007\u001a\u0004\u0018\u000100H\u0016J\u001a\u00104\u001a\u00020\b2\u0006\u0010\u0005\u001a\u0002022\b\u0010\u0007\u001a\u0004\u0018\u000103H\u0016J\u001a\u00107\u001a\u00020\b2\u0006\u0010\u0005\u001a\u0002052\b\u0010\u0007\u001a\u0004\u0018\u000106H\u0016J\u001a\u0010;\u001a\u00020\b2\u0006\u00109\u001a\u0002082\b\u0010\u0007\u001a\u0004\u0018\u00010:H\u0016\u00a8\u0006C"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/GroupSchoolService;", "Lcom/tencent/qqnt/kernel/api/impl/BaseService;", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupSchoolService;", "Lcom/tencent/qqnt/kernel/api/r;", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeListReq;", "req", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeListCallback;", "result", "", "getGroupSchoolNoticeList", "Lcom/tencent/qqnt/kernel/nativeinterface/GetGroupSchoolNoticeDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeDetailCallback;", "getGroupSchoolNoticeDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolNoticeCallback;", "publishGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/DeleteGroupSchoolNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "deleteGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/ConfirmGroupSchoolNoticeReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IConfirmGroupSchoolNoticeCallback;", "confirmGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolNoticeStatisticsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolNoticeStatisticCallback;", "getGroupSchoolNoticeStatistic", "Lcom/tencent/qqnt/kernel/nativeinterface/RemindGroupSchoolNoticeReq;", "remindGroupSchoolNotice", "Lcom/tencent/qqnt/kernel/nativeinterface/BatchGetGroupSchoolRoleReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IBatchGetUserGroupSchoolRoleCallback;", "batchGetUserGroupSchoolRole", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTemplateListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTemplateListCallback;", "getGroupSchoolTemplateList", "Lcom/tencent/qqnt/kernel/nativeinterface/PublishGroupSchoolTaskReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IPublishGroupSchoolTaskCallback;", "publishGroupSchoolTask", "Lcom/tencent/qqnt/kernel/nativeinterface/ModGroupSchoolTaskStatusReq;", "modifyGroupSchoolTaskStatus", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskDetailReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskDetailCallback;", "getGroupSchoolTaskDetail", "Lcom/tencent/qqnt/kernel/nativeinterface/CheckInGroupSchoolTaskReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/ICheckInGroupSchoolTaskCallback;", "checkInGroupSchoolTask", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskListReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskListCallback;", "getGroupSchoolTaskList", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskStatisticsReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskStatisticsCallback;", "getGroupSchoolTaskStatistics", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskCheckInInfoReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskCheckInInfoCallback;", "getGroupSchoolTaskCheckInInfo", "Lcom/tencent/qqnt/kernel/nativeinterface/GroupSchoolTaskUnCheckInReq;", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolTaskUnCheckInCallback;", "getGroupSchoolTaskUnCheckInInfo", "", "groupCode", "Lcom/tencent/qqnt/kernel/nativeinterface/IGetGroupSchoolToolboxInfoCallback;", "getGroupSchoolToolboxInfo", "service", "Lcom/tencent/qqnt/kernel/api/impl/py;", "content", "<init>", "(Lcom/tencent/qqnt/kernel/nativeinterface/IKernelGroupSchoolService;Lcom/tencent/qqnt/kernel/api/impl/py;)V", "d", "a", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GroupSchoolService extends BaseService<IKernelGroupSchoolService, IKernelGroupSchoolService> implements com.tencent.qqnt.kernel.api.r {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/kernel/api/impl/GroupSchoolService$a;", "", "", "SUB_TAG", "Ljava/lang/String;", "<init>", "()V", "kernel_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(47188);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 20)) {
            redirector.redirect((short) 20);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GroupSchoolService(@Nullable IKernelGroupSchoolService iKernelGroupSchoolService, @NotNull py content) {
        super("GroupSchoolService", content, iKernelGroupSchoolService);
        Intrinsics.checkNotNullParameter(content, "content");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iKernelGroupSchoolService, (Object) content);
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void batchGetUserGroupSchoolRole(@NotNull final BatchGetGroupSchoolRoleReq req, @Nullable IBatchGetUserGroupSchoolRoleCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("batchGetUserGroupSchoolRole", result, new Function1<IBatchGetUserGroupSchoolRoleCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$batchGetUserGroupSchoolRole$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ BatchGetGroupSchoolRoleReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IBatchGetUserGroupSchoolRoleCallback iBatchGetUserGroupSchoolRoleCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iBatchGetUserGroupSchoolRoleCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.batchGetUserGroupSchoolRole(this.$req, iBatchGetUserGroupSchoolRoleCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void checkInGroupSchoolTask(@NotNull final CheckInGroupSchoolTaskReq req, @Nullable ICheckInGroupSchoolTaskCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("checkInGroupSchoolTask", result, new Function1<ICheckInGroupSchoolTaskCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$checkInGroupSchoolTask$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ CheckInGroupSchoolTaskReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable ICheckInGroupSchoolTaskCallback iCheckInGroupSchoolTaskCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iCheckInGroupSchoolTaskCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.checkInGroupSchoolTask(this.$req, iCheckInGroupSchoolTaskCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void confirmGroupSchoolNotice(@NotNull final ConfirmGroupSchoolNoticeReq req, @Nullable IConfirmGroupSchoolNoticeCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("confirmGroupSchoolNotice", result, new Function1<IConfirmGroupSchoolNoticeCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$confirmGroupSchoolNotice$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ConfirmGroupSchoolNoticeReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IConfirmGroupSchoolNoticeCallback iConfirmGroupSchoolNoticeCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iConfirmGroupSchoolNoticeCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.confirmGroupSchoolNotice(this.$req, iConfirmGroupSchoolNoticeCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void deleteGroupSchoolNotice(@NotNull final DeleteGroupSchoolNoticeReq req, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("deleteGroupSchoolNotice", result, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$deleteGroupSchoolNotice$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ DeleteGroupSchoolNoticeReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.deleteGroupSchoolNotice(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolNoticeDetail(@NotNull final GetGroupSchoolNoticeDetailReq req, @Nullable IGetGroupSchoolNoticeDetailCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolNoticeDetail", result, new Function1<IGetGroupSchoolNoticeDetailCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolNoticeDetail$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GetGroupSchoolNoticeDetailReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolNoticeDetailCallback iGetGroupSchoolNoticeDetailCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolNoticeDetailCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolNoticeDetail(this.$req, iGetGroupSchoolNoticeDetailCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolNoticeList(@NotNull final GetGroupSchoolNoticeListReq req, @Nullable IGetGroupSchoolNoticeListCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolNoticeList", result, new Function1<IGetGroupSchoolNoticeListCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolNoticeList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GetGroupSchoolNoticeListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolNoticeListCallback iGetGroupSchoolNoticeListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolNoticeListCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolNoticeList(this.$req, iGetGroupSchoolNoticeListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolNoticeStatistic(@NotNull final GroupSchoolNoticeStatisticsReq req, @Nullable IGetGroupSchoolNoticeStatisticCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolNoticeStatistic", result, new Function1<IGetGroupSchoolNoticeStatisticCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolNoticeStatistic$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupSchoolNoticeStatisticsReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolNoticeStatisticCallback iGetGroupSchoolNoticeStatisticCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolNoticeStatisticCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolNoticeStatistic(this.$req, iGetGroupSchoolNoticeStatisticCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolTaskCheckInInfo(@NotNull final GroupSchoolTaskCheckInInfoReq req, @Nullable IGetGroupSchoolTaskCheckInInfoCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolTaskCheckInInfo", result, new Function1<IGetGroupSchoolTaskCheckInInfoCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolTaskCheckInInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupSchoolTaskCheckInInfoReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolTaskCheckInInfoCallback iGetGroupSchoolTaskCheckInInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolTaskCheckInInfoCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolTaskCheckInInfo(this.$req, iGetGroupSchoolTaskCheckInInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolTaskDetail(@NotNull final GroupSchoolTaskDetailReq req, @Nullable IGetGroupSchoolTaskDetailCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolTaskDetail", result, new Function1<IGetGroupSchoolTaskDetailCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolTaskDetail$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupSchoolTaskDetailReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolTaskDetailCallback iGetGroupSchoolTaskDetailCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolTaskDetailCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolTaskDetail(this.$req, iGetGroupSchoolTaskDetailCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolTaskList(@NotNull final GroupSchoolTaskListReq req, @Nullable IGetGroupSchoolTaskListCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolTaskList", result, new Function1<IGetGroupSchoolTaskListCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolTaskList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupSchoolTaskListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolTaskListCallback iGetGroupSchoolTaskListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolTaskListCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolTaskList(this.$req, iGetGroupSchoolTaskListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolTaskStatistics(@NotNull final GroupSchoolTaskStatisticsReq req, @Nullable IGetGroupSchoolTaskStatisticsCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolTaskStatistics", result, new Function1<IGetGroupSchoolTaskStatisticsCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolTaskStatistics$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupSchoolTaskStatisticsReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolTaskStatisticsCallback iGetGroupSchoolTaskStatisticsCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolTaskStatisticsCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolTaskStatistics(this.$req, iGetGroupSchoolTaskStatisticsCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolTaskUnCheckInInfo(@NotNull final GroupSchoolTaskUnCheckInReq req, @Nullable IGetGroupSchoolTaskUnCheckInCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolTaskUnCheckInInfo", result, new Function1<IGetGroupSchoolTaskUnCheckInCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolTaskUnCheckInInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupSchoolTaskUnCheckInReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolTaskUnCheckInCallback iGetGroupSchoolTaskUnCheckInCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolTaskUnCheckInCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolTaskUnCheckInInfo(this.$req, iGetGroupSchoolTaskUnCheckInCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolTemplateList(@NotNull final GroupSchoolTemplateListReq req, @Nullable IGetGroupSchoolTemplateListCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("getGroupSchoolTemplateList", result, new Function1<IGetGroupSchoolTemplateListCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolTemplateList$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ GroupSchoolTemplateListReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolTemplateListCallback iGetGroupSchoolTemplateListCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolTemplateListCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolTemplateList(this.$req, iGetGroupSchoolTemplateListCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void getGroupSchoolToolboxInfo(final long groupCode, @Nullable IGetGroupSchoolToolboxInfoCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, Long.valueOf(groupCode), result);
        } else {
            check("getGroupSchoolToolboxInfo", result, new Function1<IGetGroupSchoolToolboxInfoCallback, Unit>(groupCode) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$getGroupSchoolToolboxInfo$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ long $groupCode;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$groupCode = groupCode;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, GroupSchoolService.this, Long.valueOf(groupCode));
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IGetGroupSchoolToolboxInfoCallback iGetGroupSchoolToolboxInfoCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iGetGroupSchoolToolboxInfoCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.getGroupSchoolToolboxInfo(this.$groupCode, iGetGroupSchoolToolboxInfoCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void modifyGroupSchoolTaskStatus(@NotNull final ModGroupSchoolTaskStatusReq req, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("modifyGroupSchoolTaskStatus", result, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$modifyGroupSchoolTaskStatus$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ ModGroupSchoolTaskStatusReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.modifyGroupSchoolTaskStatus(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void publishGroupSchoolNotice(@NotNull final PublishGroupSchoolNoticeReq req, @Nullable IPublishGroupSchoolNoticeCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("publishGroupSchoolNotice", result, new Function1<IPublishGroupSchoolNoticeCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$publishGroupSchoolNotice$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PublishGroupSchoolNoticeReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IPublishGroupSchoolNoticeCallback iPublishGroupSchoolNoticeCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iPublishGroupSchoolNoticeCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.publishGroupSchoolNotice(this.$req, iPublishGroupSchoolNoticeCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void publishGroupSchoolTask(@NotNull final PublishGroupSchoolTaskReq req, @Nullable IPublishGroupSchoolTaskCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("publishGroupSchoolTask", result, new Function1<IPublishGroupSchoolTaskCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$publishGroupSchoolTask$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ PublishGroupSchoolTaskReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IPublishGroupSchoolTaskCallback iPublishGroupSchoolTaskCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iPublishGroupSchoolTaskCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.publishGroupSchoolTask(this.$req, iPublishGroupSchoolTaskCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }

    @Override // com.tencent.qqnt.kernel.api.r
    public void remindGroupSchoolNotice(@NotNull final RemindGroupSchoolNoticeReq req, @Nullable IOperateCallback result) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) req, (Object) result);
        } else {
            Intrinsics.checkNotNullParameter(req, "req");
            check("remindGroupSchoolNotice", result, new Function1<IOperateCallback, Unit>(req) { // from class: com.tencent.qqnt.kernel.api.impl.GroupSchoolService$remindGroupSchoolNotice$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ RemindGroupSchoolNoticeReq $req;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$req = req;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) GroupSchoolService.this, (Object) req);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                @Nullable
                public final Unit invoke(@Nullable IOperateCallback iOperateCallback) {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        return (Unit) iPatchRedirector2.redirect((short) 2, (Object) this, (Object) iOperateCallback);
                    }
                    IKernelGroupSchoolService service = GroupSchoolService.this.getService();
                    if (service == null) {
                        return null;
                    }
                    service.remindGroupSchoolNotice(this.$req, iOperateCallback);
                    return Unit.INSTANCE;
                }
            });
        }
    }
}
