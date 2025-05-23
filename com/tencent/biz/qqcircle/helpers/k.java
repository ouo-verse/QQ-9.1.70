package com.tencent.biz.qqcircle.helpers;

import android.app.Activity;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.util.Consumer;
import com.tencent.biz.qqcircle.QCirclePluginUtil;
import com.tencent.biz.qqcircle.events.QCircleShowSettingEvent;
import com.tencent.biz.qqcircle.requests.QCircleSetUserSwitchRequest;
import com.tencent.biz.qqcircle.utils.cj;
import com.tencent.biz.richframework.delegate.impl.RFWApplication;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermission;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog;
import com.tencent.mobileqq.qqpermission.base.AuthorizationRequestInfo;
import com.tencent.mobileqq.qqpermission.business.BusinessConfig;
import com.tencent.mobileqq.qqpermission.view.PermissionRequestDialog;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qqlive.module.videoreport.VideoReport;
import cooperation.qqcircle.report.datong.QCircleDTParamBuilder;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import feedcloud.FeedCloudCommon$Entry;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qqcircle.QQCircleProfile$SetUserSwitchRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001d\u0010\u001eJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J \u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J\u0018\u0010\n\u001a\u00020\b2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0002J,\u0010\f\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\u00022\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0007J\u0006\u0010\u000e\u001a\u00020\rJ\u0014\u0010\u0011\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012J\u0016\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0002J\u000e\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\u0017R\u0016\u0010\u001c\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001b\u00a8\u0006\u001f"}, d2 = {"Lcom/tencent/biz/qqcircle/helpers/k;", "", "", tl.h.F, "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Landroidx/core/util/Consumer;", "listener", "", "g", "l", "needRequestNet", "j", "Lfeedcloud/FeedCloudCommon$Entry;", "f", "", "extInfo", "i", "Landroid/view/View;", "view", "d", "accept", "e", "", "dtPageId", "c", "b", "Z", "hasReportAuthStatus", "<init>", "()V", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final k f84627a = new k();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static boolean hasReportAuthStatus;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016\u00a8\u0006\u0005"}, d2 = {"com/tencent/biz/qqcircle/helpers/k$a", "Lcom/tencent/mobileqq/qqpermission/authorization/QQAuthorizationDialog$AuthorizationListener;", "", "onAllow", "onRefuse", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class a extends QQAuthorizationDialog.AuthorizationListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Consumer<Boolean> f84629a;

        a(Consumer<Boolean> consumer) {
            this.f84629a = consumer;
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onAllow() {
            super.onAllow();
            k.f84627a.l(this.f84629a);
        }

        @Override // com.tencent.mobileqq.qqpermission.authorization.QQAuthorizationDialog.AuthorizationListener
        public void onRefuse() {
            super.onRefuse();
            Consumer<Boolean> consumer = this.f84629a;
            if (consumer != null) {
                consumer.accept(Boolean.FALSE);
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0004"}, d2 = {"com/tencent/biz/qqcircle/helpers/k$b", "Lcom/tencent/mobileqq/qqpermission/QQPermission$BasePermissionsListener;", "", "onAllGranted", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b extends QQPermission.BasePermissionsListener {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f84630a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ Consumer<Boolean> f84631b;

        b(boolean z16, Consumer<Boolean> consumer) {
            this.f84630a = z16;
            this.f84631b = consumer;
        }

        @Override // com.tencent.mobileqq.qqpermission.QQPermission.BasePermissionsListener
        public void onAllGranted() {
            super.onAllGranted();
            if (this.f84630a) {
                k.f84627a.l(this.f84631b);
                return;
            }
            Consumer<Boolean> consumer = this.f84631b;
            if (consumer != null) {
                consumer.accept(Boolean.TRUE);
            }
        }
    }

    k() {
    }

    private final void g(Activity activity, Consumer<Boolean> listener) {
        int i3;
        new PermissionRequestDialog(activity).setRequestContent(com.tencent.biz.qqcircle.utils.h.a(R.string.f194904d6));
        if (com.dataline.util.j.a()) {
            i3 = R.drawable.ohc;
        } else {
            i3 = R.drawable.ohb;
        }
        QQAuthorizationDialog.showAuthorizationRequestDialog(activity, new AuthorizationRequestInfo(i3, com.tencent.biz.qqcircle.utils.h.a(R.string.f181523e0), com.tencent.biz.qqcircle.utils.h.a(R.string.f194914d7), new a(listener)).plainTextDialog(com.tencent.biz.qqcircle.utils.h.a(R.string.f194904d6)));
    }

    private final boolean h() {
        if (ContextCompat.checkSelfPermission(RFWApplication.getApplication(), QQPermissionConstants.Permission.READ_CONTACTS) == 0) {
            return true;
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void k(k kVar, Activity activity, boolean z16, Consumer consumer, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z16 = true;
        }
        if ((i3 & 4) != 0) {
            consumer = null;
        }
        kVar.j(activity, z16, consumer);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(final Consumer<Boolean> listener) {
        VSNetworkHelper.getInstance().sendRequest(new QCircleSetUserSwitchRequest(16, 0), new VSDispatchObserver.OnVSRspCallBack() { // from class: com.tencent.biz.qqcircle.helpers.j
            @Override // com.tencent.biz.richframework.network.observer.VSDispatchObserver.OnVSRspCallBack
            public final void onReceive(BaseRequest baseRequest, boolean z16, long j3, String str, Object obj) {
                k.m(Consumer.this, baseRequest, z16, j3, str, (QQCircleProfile$SetUserSwitchRsp) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(Consumer consumer, BaseRequest baseRequest, boolean z16, long j3, String str, QQCircleProfile$SetUserSwitchRsp qQCircleProfile$SetUserSwitchRsp) {
        if (z16 && j3 == 0) {
            if (consumer != null) {
                consumer.accept(Boolean.TRUE);
            }
            SimpleEventBus.getInstance().dispatchEvent(new QCircleShowSettingEvent(29, true));
        } else {
            cj.b(false, j3, str);
            if (consumer != null) {
                consumer.accept(Boolean.FALSE);
            }
        }
    }

    public final void c(@NotNull String dtPageId) {
        String str;
        Intrinsics.checkNotNullParameter(dtPageId, "dtPageId");
        if (hasReportAuthStatus) {
            return;
        }
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        if (h()) {
            str = "open";
        } else {
            str = "close";
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_eid", QCircleDaTongConstant.ElementId.EM_XSJ_PHONE_ADDRESS_BUTTON);
        params.put("xsj_custom_pgid", dtPageId);
        params.put(QCircleDaTongConstant.ElementParamKey.XSJ_AUTH_STATUS, str);
        VideoReport.reportEvent("ev_xsj_abnormal_imp", params);
        hasReportAuthStatus = true;
    }

    public final void d(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_ADDRESSBOOK_AUTH_BAR);
        VideoReport.setElementReuseIdentifier(view, "QFSContractHelper");
        VideoReport.traversePage(view);
    }

    public final void e(@NotNull View view, boolean accept) {
        String str;
        Intrinsics.checkNotNullParameter(view, "view");
        VideoReport.setElementId(view, QCircleDaTongConstant.ElementId.EM_XSJ_ADDRESSBOOK_AUTH_OPERATION);
        Map<String, Object> params = new QCircleDTParamBuilder().buildElementParams();
        if (accept) {
            str = WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH;
        } else {
            str = "close";
        }
        Intrinsics.checkNotNullExpressionValue(params, "params");
        params.put("xsj_operation_type", str);
        VideoReport.setElementParams(view, params);
    }

    @NotNull
    public final FeedCloudCommon$Entry f() {
        String str;
        FeedCloudCommon$Entry feedCloudCommon$Entry = new FeedCloudCommon$Entry();
        feedCloudCommon$Entry.key.set("address_right");
        if (h()) {
            str = "1";
        } else {
            str = "0";
        }
        feedCloudCommon$Entry.value.set(str);
        return feedCloudCommon$Entry;
    }

    public final boolean i(@NotNull List<FeedCloudCommon$Entry> extInfo) {
        Intrinsics.checkNotNullParameter(extInfo, "extInfo");
        return Intrinsics.areEqual(QCirclePluginUtil.getValueFromListEntry(extInfo, "guide_address_recom"), "1");
    }

    @JvmOverloads
    public final void j(@NotNull Activity activity, boolean needRequestNet, @Nullable Consumer<Boolean> listener) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        boolean h16 = h();
        RFWLog.i("QFSContractHelper", RFWLog.USR, "[openContacts] granted=" + h16);
        if (h16) {
            if (needRequestNet) {
                g(activity, listener);
                return;
            } else {
                if (listener != null) {
                    listener.accept(Boolean.TRUE);
                    return;
                }
                return;
            }
        }
        com.tencent.biz.qqcircle.utils.z.b(activity, 2, new b(needRequestNet, listener), new BusinessConfig(QQPermissionConstants.Business.ID.QQ_QCIRCLE, QQPermissionConstants.Business.SCENE.QCIRCLE_FEED_READ_CONTACT), QQPermissionConstants.Permission.READ_CONTACTS);
    }
}
