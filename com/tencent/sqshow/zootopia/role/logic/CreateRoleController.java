package com.tencent.sqshow.zootopia.role.logic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mobileqq.z1.download.ZPlanResDownloadReq;
import com.tencent.mobileqq.zootopia.ZootopiaSource;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.api.IZPlanMMKVApi;
import com.tencent.mobileqq.zplan.download.api.ICommonDownloadHelper;
import com.tencent.mobileqq.zplan.persistent.api.IZPlanDataHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.sqshow.zootopia.card.report.ZplanViewReportHelper;
import com.tencent.sqshow.zootopia.nativeui.view.action.PortalStoreCreateRoleBubbleHelper;
import com.tencent.sqshow.zootopia.role.logic.CreateRoleController;
import com.tencent.sqshow.zootopia.utils.ah;
import com.tencent.state.report.SquareReportConst;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyEnum;
import com.tencent.ttpic.openapi.util.VideoTemplateParser;
import com.tencent.util.QQToastUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__MutableCollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n74.ar;
import qv4.aa;
import qv4.ab;
import qv4.bb;
import qv4.bc;
import qv4.bd;
import qv4.bp;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u00b0\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u0000 \f2\u00020\u0001:\u00027sB\u001f\u0012\u0006\u0010;\u001a\u000206\u0012\u0006\u0010A\u001a\u00020<\u0012\u0006\u0010F\u001a\u00020,\u00a2\u0006\u0004\bq\u0010rJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0007H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\u000bH\u0002J\b\u0010\r\u001a\u00020\u0002H\u0002J\u0006\u0010\u000e\u001a\u00020\u0002J\u0006\u0010\u000f\u001a\u00020\u0002J\u0006\u0010\u0010\u001a\u00020\u0002J\u0006\u0010\u0011\u001a\u00020\u0002J\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J\u0014\u0010\u0019\u001a\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00120\u0017J\u001e\u0010\u001d\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0017J\u0006\u0010\u001e\u001a\u00020\u0002J\u0006\u0010\u001f\u001a\u00020\u0002J\u0006\u0010 \u001a\u00020\u0002J\u0010\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0015J\b\u0010#\u001a\u0004\u0018\u00010\u0015J\u0010\u0010$\u001a\u00020\u00022\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aJ\b\u0010%\u001a\u0004\u0018\u00010\u001aJ\b\u0010'\u001a\u0004\u0018\u00010&J\b\u0010(\u001a\u0004\u0018\u00010&J\u000e\u0010*\u001a\u00020\u00022\u0006\u0010)\u001a\u00020&J\u0006\u0010+\u001a\u00020\u0002J\u0006\u0010-\u001a\u00020,J\u0006\u0010.\u001a\u00020\u000bJ\u0006\u0010/\u001a\u00020\tJ\u0006\u00100\u001a\u00020\u0007J\u0006\u00102\u001a\u000201J\u0012\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b03J\u0006\u00105\u001a\u00020\tR\u0017\u0010;\u001a\u0002068\u0006\u00a2\u0006\f\n\u0004\b7\u00108\u001a\u0004\b9\u0010:R\u0017\u0010A\u001a\u00020<8\u0006\u00a2\u0006\f\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0017\u0010F\u001a\u00020,8\u0006\u00a2\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bD\u0010ER\u0016\u0010H\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\bG\u0010\"R\u0014\u0010L\u001a\u00020I8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\bJ\u0010KR\u0014\u0010O\u001a\u00020M8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010NR\u0014\u0010R\u001a\u00020P8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010QR'\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010S8\u0002@\u0002X\u0082\u000e\u00f8\u0001\u0000\u00f8\u0001\u0001\u00f8\u0001\u0002\u00a2\u0006\u0006\n\u0004\b4\u0010TR\u0018\u0010W\u001a\u0004\u0018\u00010\u00158\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010VR\u0018\u0010Y\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010XR\"\u0010\\\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00170Z8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010[R\u0014\u0010_\u001a\u00020]8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010^R\u0016\u0010a\u001a\u0002018\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b?\u0010`R\u0018\u0010c\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010bR\u0018\u0010d\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010bR\u0018\u0010g\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b2\u0010fR\u0016\u0010i\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010hR\u0016\u0010k\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0013\u0010jR\"\u0010p\u001a\u00020\t8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b#\u0010h\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b!\u00a8\u0006t"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController;", "", "", "D", "H", "N", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "", "l", "", "y", "", "t", "f", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "g", BdhLogUtil.LogTag.Tag_Conn, "E", "Lqv4/ab;", "r", "", "Lqv4/bb;", "o", "Lcom/tencent/mobileqq/zootopia/api/e;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lqv4/bp;", "templateMaterial", "Lqv4/bd;", HippyTKDListViewAdapter.X, "w", "L", "G", "materialInfo", "I", ReportConstant.COSTREPORT_PREFIX, "J", "v", "Lpu4/g;", "k", "i", WadlProxyConsts.KEY_MATERIAL, "M", "B", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "j", DomainData.DOMAIN_NAME, "P", "u", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "p", "", tl.h.F, "O", "Landroid/app/Activity;", "a", "Landroid/app/Activity;", "getActivity", "()Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "Ln74/ar;", "b", "Ln74/ar;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "()Ln74/ar;", "mBinding", "c", "Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "getSourceCurrent", "()Lcom/tencent/mobileqq/zootopia/ZootopiaSource;", "sourceCurrent", "d", "mStep", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep;", "e", "Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleGuideStep;", "guideStep", "Lcom/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep;", "Lcom/tencent/sqshow/zootopia/role/logic/BaseCreateRoleSelectStep;", "selectFaceStep", "Lcom/tencent/sqshow/zootopia/role/logic/q;", "Lcom/tencent/sqshow/zootopia/role/logic/q;", "selectSuccessStep", "Lkotlin/Result;", "Lkotlin/Result;", "mRoleInfo", "Lqv4/bb;", "mSelectMaterialInfo", "Lqv4/bp;", "mTemplateMaterial", "", "Ljava/util/List;", "roleInfoCallbackList", "Ljava/util/concurrent/locks/ReentrantLock;", "Ljava/util/concurrent/locks/ReentrantLock;", "roleInfoLock", "Lcom/tencent/sqshow/zootopia/card/report/ZplanViewReportHelper;", "reportHelper", "Lpu4/g;", "headMaterial", "bodyMaterial", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "netInfoListener", "Z", "stayInPageWhenHasRegistered", "Ljava/lang/String;", "referExternalEntrance", UserInfo.SEX_FEMALE, "()Z", "K", "(Z)V", "isChecked", "<init>", "(Landroid/app/Activity;Ln74/ar;Lcom/tencent/mobileqq/zootopia/ZootopiaSource;)V", "GetRoleInfoException", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class CreateRoleController {

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final Activity activity;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ar mBinding;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final ZootopiaSource sourceCurrent;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int mStep;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final CreateRoleGuideStep guideStep;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final BaseCreateRoleSelectStep selectFaceStep;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final q selectSuccessStep;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Result<ab> mRoleInfo;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private bb mSelectMaterialInfo;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private bp mTemplateMaterial;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private List<com.tencent.mobileqq.zootopia.api.e<ab>> roleInfoCallbackList;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final ReentrantLock roleInfoLock;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ZplanViewReportHelper reportHelper;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private pu4.g headMaterial;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private pu4.g bodyMaterial;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private INetInfoHandler netInfoListener;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    private boolean stayInPageWhenHasRegistered;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    private String referExternalEntrance;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isChecked;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController$GetRoleInfoException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "errorCode", "", "errorMessage", "", "(ILjava/lang/String;)V", "getErrorCode", "()I", "getErrorMessage", "()Ljava/lang/String;", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes34.dex */
    public static final class GetRoleInfoException extends RuntimeException {
        private final int errorCode;
        private final String errorMessage;

        public GetRoleInfoException(int i3, String str) {
            super("GetRoleInfoException errorCode:" + i3 + ", errorMessage:" + str);
            this.errorCode = i3;
            this.errorMessage = str;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMessage() {
            return this.errorMessage;
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003*\u00020\u0002R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\b\u0010\u0007R\u0014\u0010\t\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0007R\u0014\u0010\f\u001a\u00020\u000b8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/role/logic/CreateRoleController$a;", "", "Lqv4/bb;", "Lqv4/bp;", "a", "", "STEP_ENTRY", "I", "STEP_GUIDE", "STEP_SELECT_FACE", "STEP_SELECT_SUCCESS", "", "TAG", "Ljava/lang/String;", "ZPLAN_HAS_SHOWN_CREATE_ROLE_GUIDE", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.sqshow.zootopia.role.logic.CreateRoleController$a, reason: from kotlin metadata */
    /* loaded from: classes34.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final bp a(bb bbVar) {
            bp bpVar;
            Object firstOrNull;
            Intrinsics.checkNotNullParameter(bbVar, "<this>");
            bp[] bpVarArr = bbVar.f430045b;
            Intrinsics.checkNotNullExpressionValue(bpVarArr, "this.list");
            int length = bpVarArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    bpVar = null;
                    break;
                }
                bpVar = bpVarArr[i3];
                if (Intrinsics.areEqual(bpVar.f430096c, bbVar.f430046c)) {
                    break;
                }
                i3++;
            }
            if (bpVar != null) {
                return bpVar;
            }
            bp[] bpVarArr2 = bbVar.f430045b;
            Intrinsics.checkNotNullExpressionValue(bpVarArr2, "this.list");
            firstOrNull = ArraysKt___ArraysKt.firstOrNull(bpVarArr2);
            return (bp) firstOrNull;
        }

        Companion() {
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleController$c", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/ab;", "result", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements com.tencent.mobileqq.zootopia.api.e<ab> {
        c() {
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(ab result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("CreateRoleController", 1, "doGetRegisterInfoReq :: success , result == " + result);
            ReentrantLock reentrantLock = CreateRoleController.this.roleInfoLock;
            CreateRoleController createRoleController = CreateRoleController.this;
            reentrantLock.lock();
            try {
                createRoleController.mRoleInfo = Result.m475boximpl(Result.m476constructorimpl(result));
                Iterator it = createRoleController.roleInfoCallbackList.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mobileqq.zootopia.api.e) it.next()).onResultSuccess(result);
                }
                createRoleController.roleInfoCallbackList.clear();
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.i("CreateRoleController", 1, "doGetRegisterInfoReq :: failed , error == " + error + " , message == " + message);
            ReentrantLock reentrantLock = CreateRoleController.this.roleInfoLock;
            CreateRoleController createRoleController = CreateRoleController.this;
            reentrantLock.lock();
            try {
                Result.Companion companion = Result.INSTANCE;
                createRoleController.mRoleInfo = Result.m475boximpl(Result.m476constructorimpl(ResultKt.createFailure(new GetRoleInfoException(error, message))));
                Iterator it = createRoleController.roleInfoCallbackList.iterator();
                while (it.hasNext()) {
                    ((com.tencent.mobileqq.zootopia.api.e) it.next()).onResultFailure(error, message);
                }
                createRoleController.roleInfoCallbackList.clear();
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
                CreateRoleController.this.getMBinding().f418708s.b();
                QQToastUtil.showQQToast(R.string.f169795xn2);
            } catch (Throwable th5) {
                reentrantLock.unlock();
                throw th5;
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u000b\u001a\u00020\u0004H\u0016J\b\u0010\f\u001a\u00020\u0004H\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleController$d", "Lcom/tencent/mobileqq/msf/sdk/handler/INetInfoHandler;", "", "p0", "", "onNetNone2Mobile", "onNetNone2Wifi", "apn", "onNetWifi2Mobile", TPDownloadProxyEnum.USER_SSID, "onNetMobile2Wifi", "onNetMobile2None", "onNetWifi2None", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class d implements INetInfoHandler {
        d() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void c(CreateRoleController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.H();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void d(CreateRoleController this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.H();
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Mobile(String p06) {
            QLog.i("CreateRoleController", 1, "onNetNone2Mobile");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final CreateRoleController createRoleController = CreateRoleController.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.role.logic.g
                @Override // java.lang.Runnable
                public final void run() {
                    CreateRoleController.d.c(CreateRoleController.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetNone2Wifi(String p06) {
            QLog.i("CreateRoleController", 1, "onNetNone2Wifi");
            Handler uIHandlerV2 = ThreadManagerV2.getUIHandlerV2();
            final CreateRoleController createRoleController = CreateRoleController.this;
            uIHandlerV2.post(new Runnable() { // from class: com.tencent.sqshow.zootopia.role.logic.h
                @Override // java.lang.Runnable
                public final void run() {
                    CreateRoleController.d.d(CreateRoleController.this);
                }
            });
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2None() {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetMobile2Wifi(String ssid) {
        }

        @Override // com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler
        public void onNetWifi2Mobile(String apn) {
        }
    }

    public CreateRoleController(Activity activity, ar mBinding, ZootopiaSource sourceCurrent) {
        BaseCreateRoleSelectStep createRoleSelectFaceStep;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(mBinding, "mBinding");
        Intrinsics.checkNotNullParameter(sourceCurrent, "sourceCurrent");
        this.activity = activity;
        this.mBinding = mBinding;
        this.sourceCurrent = sourceCurrent;
        this.guideStep = new CreateRoleGuideStep(activity, mBinding, this);
        if (qb4.a.f428794a.c()) {
            createRoleSelectFaceStep = new l(activity, mBinding, this);
        } else {
            createRoleSelectFaceStep = new CreateRoleSelectFaceStep(activity, mBinding, this);
        }
        this.selectFaceStep = createRoleSelectFaceStep;
        this.selectSuccessStep = new q(activity, mBinding, this);
        this.roleInfoCallbackList = new ArrayList();
        this.roleInfoLock = new ReentrantLock();
        this.reportHelper = new ZplanViewReportHelper();
        this.referExternalEntrance = "";
    }

    private final void D() {
        Bundle extras;
        Intent intent = this.activity.getIntent();
        if (intent == null || (extras = intent.getExtras()) == null) {
            return;
        }
        String string = extras.getString("key_refer_external_entrance", "");
        Intrinsics.checkNotNullExpressionValue(string, "extra.getString(CreateRo\u2026ER_EXTERNAL_ENTRANCE, \"\")");
        this.referExternalEntrance = string;
        this.stayInPageWhenHasRegistered = extras.getBoolean("key_stay_in_page_when_has_registered", false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void H() {
        if (this.mStep == 2) {
            QLog.i("CreateRoleController", 1, "reloadData :: step == STEP_SELECT_FACE");
            RecyclerView.Adapter adapter = this.mBinding.f418699j.getAdapter();
            if (adapter != null) {
                adapter.notifyDataSetChanged();
            }
        }
    }

    private final void N() {
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(800L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        this.mBinding.f418706q.startAnimation(rotateAnimation);
        this.mBinding.f418707r.setVisibility(0);
    }

    private final void f() {
        HashMap hashMap = new HashMap();
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, ah.b(getSourceCurrent()));
        hashMap.put("zplan_template_back", 1);
        VideoReport.resetPageStats();
        ZplanViewReportHelper zplanViewReportHelper = this.reportHelper;
        Activity activity = this.activity;
        ConstraintLayout constraintLayout = this.mBinding.f418709t;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "mBinding.root");
        zplanViewReportHelper.a(activity, constraintLayout, "pg_zplan_template_avatar", hashMap);
        VideoReport.traverseExposure();
    }

    private final int l() {
        return this.isChecked ? 1 : 0;
    }

    private final String t() {
        String currentUin = ((IZPlanApi) QRoute.api(IZPlanApi.class)).getCurrentUin();
        if (currentUin == null) {
            currentUin = "";
        }
        return "zplan_has_shown_create_role_guide_" + currentUin;
    }

    private final boolean y() {
        return ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).getBoolean(t(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void z() {
        this.mBinding.f418707r.setVisibility(8);
        this.mBinding.f418691b.setVisibility(0);
    }

    public final void A() {
        D();
        C();
        E();
        w();
        N();
    }

    public final void B() {
        this.selectFaceStep.z();
    }

    public final void C() {
        aa aaVar = new aa();
        aaVar.f429884a = ah.b(this.sourceCurrent);
        String d16 = qb4.a.f428794a.d();
        aaVar.f429885b = d16;
        QLog.i("CreateRoleController", 1, "GetRegisterInfoReq :: start , subSource == " + aaVar.f429884a + " newRegisterPageExpKey == " + d16);
        pb4.b.b(pb4.b.f425866a, aaVar, new c(), 0, 4, null);
    }

    public final void E() {
        this.netInfoListener = new d();
        AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.netInfoListener);
    }

    /* renamed from: F, reason: from getter */
    public final boolean getIsChecked() {
        return this.isChecked;
    }

    public final void G() {
        f();
        this.mStep = 3;
        this.selectSuccessStep.n();
    }

    public final void I(bb materialInfo) {
        this.mSelectMaterialInfo = materialInfo;
    }

    public final void J(bp templateMaterial) {
        this.mTemplateMaterial = templateMaterial;
    }

    public final void K(boolean z16) {
        this.isChecked = z16;
    }

    public final void L() {
        ((IZPlanMMKVApi) QRoute.api(IZPlanMMKVApi.class)).setBoolean(t(), true);
    }

    public final void M(pu4.g material) {
        Intrinsics.checkNotNullParameter(material, "material");
        N();
        this.mBinding.f418691b.setDefaultDrawable(null);
        this.mBinding.f418691b.setURLDrawableDownListener(new e());
        this.mBinding.f418691b.e(material);
        this.mBinding.f418691b.setVisibility(0);
    }

    public final boolean O() {
        if (!qb4.a.f428794a.a()) {
            return false;
        }
        int mStep = getMStep();
        if (mStep == 1) {
            this.guideStep.u();
            return true;
        }
        if (mStep != 2) {
            return false;
        }
        this.selectFaceStep.u();
        return true;
    }

    /* renamed from: P, reason: from getter */
    public final boolean getStayInPageWhenHasRegistered() {
        return this.stayInPageWhenHasRegistered;
    }

    public final void g() {
        INetInfoHandler iNetInfoHandler = this.netInfoListener;
        if (iNetInfoHandler != null) {
            AppNetConnInfo.unregisterNetInfoHandler(iNetInfoHandler);
        }
    }

    public final Map<String, String> h() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        bp mTemplateMaterial = getMTemplateMaterial();
        String str = mTemplateMaterial != null ? mTemplateMaterial.f430096c : null;
        if (str == null) {
            str = "";
        }
        linkedHashMap.put("zplan_avatar_id", str);
        linkedHashMap.put(SquareReportConst.Key.KEY_IS_TICK, String.valueOf(l()));
        return linkedHashMap;
    }

    public final pu4.g i() {
        pu4.g gVar;
        bp mTemplateMaterial = getMTemplateMaterial();
        return (mTemplateMaterial == null || (gVar = mTemplateMaterial.f430094a) == null) ? this.bodyMaterial : gVar;
    }

    /* renamed from: j, reason: from getter */
    public final ZootopiaSource getSourceCurrent() {
        return this.sourceCurrent;
    }

    public final pu4.g k() {
        pu4.g gVar;
        bp mTemplateMaterial = getMTemplateMaterial();
        return (mTemplateMaterial == null || (gVar = mTemplateMaterial.f430095b) == null) ? this.headMaterial : gVar;
    }

    /* renamed from: m, reason: from getter */
    public final ar getMBinding() {
        return this.mBinding;
    }

    /* renamed from: n, reason: from getter */
    public final String getReferExternalEntrance() {
        return this.referExternalEntrance;
    }

    public final List<bb> o() {
        ab r16 = r();
        if (r16 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        qv4.l[] lVarArr = r16.f429899n;
        Intrinsics.checkNotNullExpressionValue(lVarArr, "roleInfo.genderList");
        for (qv4.l lVar : lVarArr) {
            bb[] bbVarArr = lVar.f430184a;
            boolean z16 = true;
            if (bbVarArr != null) {
                if (!(bbVarArr.length == 0)) {
                    z16 = false;
                }
            }
            if (!z16) {
                Intrinsics.checkNotNullExpressionValue(bbVarArr, "it.list");
                CollectionsKt__MutableCollectionsKt.addAll(arrayList, bbVarArr);
            }
        }
        return arrayList;
    }

    /* renamed from: p, reason: from getter */
    public final ZplanViewReportHelper getReportHelper() {
        return this.reportHelper;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void q(com.tencent.mobileqq.zootopia.api.e<ab> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        ReentrantLock reentrantLock = this.roleInfoLock;
        reentrantLock.lock();
        try {
            Result<ab> result = this.mRoleInfo;
            if (result == null) {
                this.roleInfoCallbackList.add(callback);
            } else {
                if (Result.m483isSuccessimpl(result.getValue())) {
                    Object value = result.getValue();
                    if (!Result.m482isFailureimpl(value)) {
                        r3 = value;
                    }
                    Intrinsics.checkNotNull(r3);
                    callback.onResultSuccess(r3);
                } else {
                    GetRoleInfoException getRoleInfoException = (GetRoleInfoException) Result.m479exceptionOrNullimpl(result.getValue());
                    callback.onResultFailure(getRoleInfoException != null ? getRoleInfoException.getErrorCode() : -1, getRoleInfoException != null ? getRoleInfoException.getErrorMessage() : null);
                }
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final ab r() {
        ReentrantLock reentrantLock = this.roleInfoLock;
        reentrantLock.lock();
        try {
            Result<ab> result = this.mRoleInfo;
            ab abVar = null;
            if (result != null) {
                Object value = result.getValue();
                if (!Result.m482isFailureimpl(value)) {
                    abVar = value;
                }
                abVar = abVar;
            }
            return abVar;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* renamed from: s, reason: from getter */
    public final bb getMSelectMaterialInfo() {
        return this.mSelectMaterialInfo;
    }

    /* renamed from: u, reason: from getter */
    public final int getMStep() {
        return this.mStep;
    }

    /* renamed from: v, reason: from getter */
    public final bp getMTemplateMaterial() {
        return this.mTemplateMaterial;
    }

    public final void w() {
        int i3 = this.mStep;
        int i16 = 2;
        if (i3 == 0) {
            if (qb4.a.f428794a.b() && !y()) {
                this.guideStep.A();
                i16 = 1;
            } else {
                this.selectFaceStep.H();
            }
            this.mStep = i16;
            return;
        }
        if (i3 == 1) {
            this.selectFaceStep.H();
            this.mStep = 2;
        } else if (i3 != 2) {
            QLog.e("CreateRoleController", 1, "handleNextStep unknown step");
        } else {
            this.selectSuccessStep.n();
            this.mStep = 3;
        }
    }

    public final void x(bp templateMaterial, com.tencent.mobileqq.zootopia.api.e<bd> callback) {
        String str;
        Intrinsics.checkNotNullParameter(callback, "callback");
        bc bcVar = new bc();
        if (templateMaterial == null || (str = templateMaterial.f430096c) == null) {
            str = "";
        }
        bcVar.f430050a = str;
        bcVar.f430051b = 0;
        pb4.b.d(pb4.b.f425866a, bcVar, new b(callback), 0, 4, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003H\u0002\u00a2\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0016J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0016\u00a8\u0006\u000f"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleController$b", "Lcom/tencent/mobileqq/zootopia/api/e;", "Lqv4/bd;", "", "", VideoTemplateParser.ITEM_LIST, "", "a", "([Ljava/lang/String;)V", "result", "b", "", "error", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class b implements com.tencent.mobileqq.zootopia.api.e<bd> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bd> f372736d;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleController$b$a", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldw4/b;", "dressKeyResult", "", "a", "", "error", "", "message", "onResultFailure", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
        /* loaded from: classes34.dex */
        public static final class a implements com.tencent.mobileqq.zootopia.api.e<dw4.b> {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ com.tencent.mobileqq.zootopia.api.e<bd> f372737d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ bd f372738e;

            a(com.tencent.mobileqq.zootopia.api.e<bd> eVar, bd bdVar) {
                this.f372737d = eVar;
                this.f372738e = bdVar;
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResultSuccess(dw4.b dressKeyResult) {
                Intrinsics.checkNotNullParameter(dressKeyResult, "dressKeyResult");
                QLog.i("CreateRoleController", 1, "registerAvatar refreshDressInfo success, dressKey:" + dressKeyResult.f395115b + ", gender:" + dressKeyResult.f395116c);
                this.f372737d.onResultSuccess(this.f372738e);
                PortalStoreCreateRoleBubbleHelper.f371421a.d();
            }

            @Override // com.tencent.mobileqq.zootopia.api.e
            public void onResultFailure(int error, String message) {
                QLog.i("CreateRoleController", 1, "registerAvatar refreshDressInfo fail, error:" + error + ", message:" + message);
                this.f372737d.onResultSuccess(this.f372738e);
            }
        }

        b(com.tencent.mobileqq.zootopia.api.e<bd> eVar) {
            this.f372736d = eVar;
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onResultSuccess(bd result) {
            Intrinsics.checkNotNullParameter(result, "result");
            QLog.i("CreateRoleController", 1, "registerAvatar request success, isRegistered:" + result.f430053b);
            if (result.f430053b == 0) {
                a(result.f430052a);
                ((IZPlanDataHelper) QRoute.api(IZPlanDataHelper.class)).updateCreatedRolePackageCache();
                com.tencent.sqshow.dresskey.b.f369818a.u("create_role", true, new a(this.f372736d, result));
            } else {
                QLog.i("CreateRoleController", 1, "registerAvatar request success, but has registered");
                this.f372736d.onResultSuccess(result);
            }
            SimpleEventBus.getInstance().dispatchEvent(new CreateRoleEvent(true, result.f430053b == 0));
        }

        @Override // com.tencent.mobileqq.zootopia.api.e
        public void onResultFailure(int error, String message) {
            QLog.e("CreateRoleController", 1, "registerAvatar request fail, error:" + error + ", message:" + message);
            this.f372736d.onResultFailure(error, message);
            SimpleEventBus.getInstance().dispatchEvent(new CreateRoleEvent(false, false, 2, null));
        }

        private final void a(String[] itemList) {
            if (itemList != null) {
                for (String str : itemList) {
                    if (str.length() > 0) {
                        ZPlanResDownloadReq zPlanResDownloadReq = new ZPlanResDownloadReq(str, null, null, 6, null);
                        QRouteApi api = QRoute.api(ICommonDownloadHelper.class);
                        Intrinsics.checkNotNullExpressionValue(api, "api(ICommonDownloadHelper::class.java)");
                        ICommonDownloadHelper.a.a((ICommonDownloadHelper) api, zPlanResDownloadReq, null, false, 6, null);
                    }
                }
            }
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\n\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001c\u0010\u000b\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010\r\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\t\u001a\u0004\u0018\u00010\fH\u0016J$\u0010\u000f\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\u000eH\u0016\u00a8\u0006\u0010"}, d2 = {"com/tencent/sqshow/zootopia/role/logic/CreateRoleController$e", "Lcom/tencent/image/URLDrawableDownListener;", "Landroid/view/View;", "p0", "Lcom/tencent/image/URLDrawable;", "p1", "", "onLoadSuccessed", "", "p2", "onLoadFailed", "onLoadCancelled", "Ljava/lang/InterruptedException;", "onLoadInterrupted", "", "onLoadProgressed", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class e implements URLDrawableDownListener {
        e() {
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadCancelled(View p06, URLDrawable p16) {
            CreateRoleController.this.z();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadFailed(View p06, URLDrawable p16, Throwable p26) {
            CreateRoleController.this.z();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadInterrupted(View p06, URLDrawable p16, InterruptedException p26) {
            CreateRoleController.this.z();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadSuccessed(View p06, URLDrawable p16) {
            CreateRoleController.this.z();
        }

        @Override // com.tencent.image.URLDrawableDownListener
        public void onLoadProgressed(View p06, URLDrawable p16, int p26) {
        }
    }
}
