package com.tencent.mobileqq.zplan.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.common.config.pad.DeviceType;
import com.tencent.common.config.pad.PadUtil;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControlV2;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.mobileqq.zplan.meme.frameanim.model.ZPlanAvatarSource;
import com.tencent.mobileqq.zplan.model.MaintEntryType;
import com.tencent.mobileqq.zplan.utils.ax;
import com.tencent.mobileqq.zplan.utils.featureswitch.api.IZPlanFeatureSwitchHelper;
import com.tencent.mobileqq.zplan.view.b;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import com.tencent.state.report.SquareReportConst;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;
import com.tencent.zplan.common.model.AppTheme;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00112\u00020\u0001:\u0001'B'\u0012\u0006\u00101\u001a\u00020-\u0012\u0006\u00106\u001a\u000202\u0012\u0006\u00108\u001a\u00020\u0002\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u00a2\u0006\u0004\bN\u0010OJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002J\b\u0010\n\u001a\u00020\tH\u0002J\b\u0010\u000b\u001a\u00020\tH\u0002J\b\u0010\f\u001a\u00020\tH\u0002J\b\u0010\r\u001a\u00020\tH\u0002J\u0012\u0010\u0010\u001a\u00020\u00022\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0002H\u0002J\u0014\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002J\u0010\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u001f2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u0005H\u0002J\b\u0010!\u001a\u00020\u001aH\u0002J\b\u0010\"\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\u0002H\u0002J\u0016\u0010'\u001a\u00020\u001a2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020%0$H\u0016J\u0012\u0010(\u001a\u00020\u001a2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010+\u001a\u00020\u001a2\u0006\u0010*\u001a\u00020)H\u0016J\u0010\u0010,\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016R\u0017\u00101\u001a\u00020-8\u0006\u00a2\u0006\f\n\u0004\b'\u0010.\u001a\u0004\b/\u00100R\u0017\u00106\u001a\u0002028\u0006\u00a2\u0006\f\n\u0004\b+\u00103\u001a\u0004\b4\u00105R\u0014\u00108\u001a\u00020\u00028\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b(\u00107R\u0017\u0010\u0014\u001a\u00020\u00138\u0006\u00a2\u0006\f\n\u0004\b,\u00109\u001a\u0004\b:\u0010;R\u001e\u0010&\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b<\u0010=R\u0018\u0010?\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010>R\u0016\u0010A\u001a\u00020)8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\f\u0010@R\u0014\u0010C\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010BR\u0014\u0010D\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\n\u0010BR\u0014\u0010E\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010BR\u0014\u0010F\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\b\u0010BR\u0014\u0010G\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0006\u0010BR\u0014\u0010H\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010BR\u0014\u0010I\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010BR\u0014\u0010J\u001a\u00020\t8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010BR\u0014\u0010M\u001a\u00020K8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0004\u0010L\u00a8\u0006P"}, d2 = {"Lcom/tencent/mobileqq/zplan/view/d;", "Lcom/tencent/mobileqq/zplan/view/b;", "", "o", "p", "", "l", DomainData.DOMAIN_NAME, "k", "", "i", "j", "g", tl.h.F, "Landroid/view/MotionEvent;", "event", "r", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, ReportConstant.COSTREPORT_PREFIX, "", "friendUin", "w", "u", "f", "Lcom/tencent/mobileqq/zplan/view/b$a;", "listener", "", QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, "Landroid/content/Context;", "context", "resId", "Landroid/graphics/drawable/Drawable;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "y", HippyTKDListViewAdapter.X, "v", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/zplan/bubble/b;", "avatarBubbleRef", "a", "c", "", "externalEntrance", "b", "d", "Landroid/view/View;", "Landroid/view/View;", "getParentView", "()Landroid/view/View;", "parentView", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ZPlanAvatarSource;", "Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ZPlanAvatarSource;", "getSource", "()Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ZPlanAvatarSource;", "source", "Z", "enableFoldSplit", "J", "getFriendUin", "()J", "e", "Ljava/lang/ref/WeakReference;", "Landroid/view/MotionEvent;", "backgroundTouchEvent", "Ljava/lang/String;", "reportExternalEntrance", UserInfo.SEX_FEMALE, "avatarHeadStartX", "avatarHeadStartY", "avatarHeadWidth", "avatarHeadHeight", "avatarBodyStartX", "avatarBodyStartY", "avatarBodyWidth", "avatarBodyHeight", "Lcom/tencent/mobileqq/vas/aio/b;", "Lcom/tencent/mobileqq/vas/aio/b;", "controlV2", "<init>", "(Landroid/view/View;Lcom/tencent/mobileqq/zplan/meme/frameanim/model/ZPlanAvatarSource;ZJ)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final View parentView;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private final ZPlanAvatarSource source;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private final boolean enableFoldSplit;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final long friendUin;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private WeakReference<com.tencent.mobileqq.zplan.bubble.b> avatarBubbleRef;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private MotionEvent backgroundTouchEvent;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private String reportExternalEntrance;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private final float avatarHeadStartX;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private final float avatarHeadStartY;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    private final float avatarHeadWidth;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    private final float avatarHeadHeight;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    private final float avatarBodyStartX;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private final float avatarBodyStartY;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    private final float avatarBodyWidth;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    private final float avatarBodyHeight;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    private final com.tencent.mobileqq.vas.aio.b controlV2;

    public d(View parentView, ZPlanAvatarSource source, boolean z16, long j3) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(source, "source");
        this.parentView = parentView;
        this.source = source;
        this.enableFoldSplit = z16;
        this.friendUin = j3;
        this.reportExternalEntrance = "";
        this.avatarHeadStartX = ViewUtils.getScreenWidth() * 0.33f;
        this.avatarHeadStartY = ViewUtils.getScreenHeight() * 0.11f;
        this.avatarHeadWidth = ViewUtils.getScreenWidth() * 0.33f;
        this.avatarHeadHeight = ViewUtils.getScreenHeight() * 0.19f;
        this.avatarBodyStartX = ViewUtils.getScreenWidth() * 0.26f;
        this.avatarBodyStartY = ViewUtils.getScreenHeight() * 0.3f;
        this.avatarBodyWidth = ViewUtils.getScreenWidth() * 0.514f;
        this.avatarBodyHeight = ViewUtils.getScreenHeight() * 0.06f;
        this.controlV2 = VasZplanAIOConfigControlV2.INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void A(b.a listener, ActionSheet actionSheet, View view, int i3) {
        Intrinsics.checkNotNullParameter(listener, "$listener");
        Intrinsics.checkNotNullParameter(actionSheet, "$actionSheet");
        if (i3 == 10) {
            listener.gotoSmallHome();
        } else if (i3 == 11) {
            listener.gotoPortal(3);
        }
        actionSheet.cancel();
    }

    private final boolean f(long friendUin) {
        if (u(friendUin)) {
            return true;
        }
        com.tencent.mobileqq.vas.data.h a16 = this.controlV2.a(friendUin);
        if (a16 != null) {
            return a16.getIsCanVisit();
        }
        return false;
    }

    private final float g() {
        if (!p()) {
            return this.avatarBodyStartX;
        }
        return k() + (n() * 0.26f);
    }

    private final float h() {
        if (!p()) {
            return this.avatarBodyWidth;
        }
        return n() * 0.514f;
    }

    private final float i() {
        if (!p()) {
            return this.avatarHeadStartX;
        }
        return k() + (n() * 0.33f);
    }

    private final float j() {
        if (!p()) {
            return this.avatarHeadWidth;
        }
        return n() * 0.33f;
    }

    private final int k() {
        if (this.enableFoldSplit && o() && this.source == ZPlanAvatarSource.PROFILE) {
            return ax.f335802a.b();
        }
        return 0;
    }

    private final int l() {
        if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2) {
            return BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
        }
        return BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
    }

    private final Drawable m(Context context, int resId) {
        AppTheme appTheme;
        if (QQTheme.isNowThemeIsNight()) {
            appTheme = AppTheme.NIGHT;
        } else {
            appTheme = AppTheme.DAY;
        }
        Drawable drawable = context.getDrawable(resId);
        if (appTheme == AppTheme.NIGHT) {
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            if (mutate != null) {
                mutate.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
            }
        }
        return drawable;
    }

    private final int n() {
        if (this.enableFoldSplit && o()) {
            if (this.source == ZPlanAvatarSource.PROFILE) {
                return ax.f335802a.a();
            }
            return ax.f335802a.b();
        }
        return l();
    }

    private final boolean o() {
        return com.tencent.mobileqq.pad.e.a() == SplitViewState.STATE_FLAT;
    }

    private final boolean p() {
        return PadUtil.a(BaseApplication.getContext()) == DeviceType.FOLD;
    }

    private final boolean q() {
        return r(this.backgroundTouchEvent);
    }

    private final boolean u(long friendUin) {
        if (friendUin <= 0) {
            return true;
        }
        return false;
    }

    private final boolean v() {
        return com.tencent.mobileqq.zplan.model.j.a(((IZPlanApi) QRoute.api(IZPlanApi.class)).getMaintenanceInfo(MaintEntryType.ALL), new Date());
    }

    private final boolean w(long friendUin) {
        return f(friendUin);
    }

    private final void x() {
        String str;
        String str2;
        if (this.reportExternalEntrance.length() == 0) {
            return;
        }
        if (Intrinsics.areEqual("em_zplan_xiaowo_entrance_zhutai", this.reportExternalEntrance)) {
            str = "em_zplan_xiaowo_entrance_zhutai_actionsheet";
            str2 = "em_zplan_portal_entrance_zhutai_actionsheet";
        } else {
            str = "";
            str2 = "";
        }
        if (Intrinsics.areEqual("em_zplan_xiaowo_entrance_ketai", this.reportExternalEntrance)) {
            str = "em_zplan_xiaowo_entrance_ketai_actionsheet";
            str2 = "em_zplan_portal_entrance_ketai_actionsheet";
        }
        if (Intrinsics.areEqual("em_zplan_xiaowo_entrance_dongtai_background", this.reportExternalEntrance)) {
            str = "em_zplan_xiaowo_entrance_dongtai_actionsheet";
            str2 = "em_zplan_portal_entrance_dongtai_actionsheet";
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str);
        hashMap.put("zplan_action_type", "imp");
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap2.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, str2);
        hashMap2.put("zplan_action_type", "imp");
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap2);
    }

    private final void y() {
        if (this.reportExternalEntrance.length() == 0) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(DTParamKey.REPORT_KEY_APPKEY, SquareReportConst.APP_KEY);
        hashMap.put(SquareReportConst.Key.KEY_EXTERNAL_ENTRANCE, this.reportExternalEntrance);
        hashMap.put("zplan_action_type", "click");
        VideoReport.reportEvent("ev_zplan_external_entrance_action", hashMap);
    }

    private final void z(final b.a listener) {
        Context context = this.parentView.getContext();
        Dialog createDialog = ActionSheetHelper.createDialog(context, null);
        Intrinsics.checkNotNull(createDialog, "null cannot be cast to non-null type com.tencent.widget.ActionSheet");
        final ActionSheet actionSheet = (ActionSheet) createDialog;
        QRouteApi api = QRoute.api(IZPlanFeatureSwitchHelper.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZPlanFeatureSwitchHelper::class.java)");
        IZPlanFeatureSwitchHelper iZPlanFeatureSwitchHelper = (IZPlanFeatureSwitchHelper) api;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        actionSheet.addButtonWithLeftIcon(iZPlanFeatureSwitchHelper.getActionSheetGoSmallHomeString(), m(context, R.drawable.qui_fun_neighbors), 0, "", 10);
        actionSheet.addButtonWithLeftIcon(iZPlanFeatureSwitchHelper.getActionSheetGoPortalString(), m(context, R.drawable.qui_skin), 0, "", 11);
        actionSheet.addCancelButton(R.string.f169739xb4);
        actionSheet.setOnButtonClickListener(new ActionSheet.OnButtonClickListener() { // from class: com.tencent.mobileqq.zplan.view.c
            @Override // com.tencent.widget.ActionSheet.OnButtonClickListener
            public final void onClick(View view, int i3) {
                d.A(b.a.this, actionSheet, view, i3);
            }
        });
        actionSheet.show();
    }

    @Override // com.tencent.mobileqq.zplan.view.b
    public void a(WeakReference<com.tencent.mobileqq.zplan.bubble.b> avatarBubbleRef) {
        Intrinsics.checkNotNullParameter(avatarBubbleRef, "avatarBubbleRef");
        this.avatarBubbleRef = avatarBubbleRef;
    }

    @Override // com.tencent.mobileqq.zplan.view.b
    public void b(String externalEntrance) {
        Intrinsics.checkNotNullParameter(externalEntrance, "externalEntrance");
        this.reportExternalEntrance = externalEntrance;
    }

    @Override // com.tencent.mobileqq.zplan.view.b
    public void c(MotionEvent event) {
        this.backgroundTouchEvent = event;
    }

    @Override // com.tencent.mobileqq.zplan.view.b
    public void d(b.a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        if (v()) {
            listener.showMaintain();
            return;
        }
        if (t(this, null, 1, null)) {
            return;
        }
        if (q()) {
            listener.gotoPortal(1);
            return;
        }
        a b16 = a.INSTANCE.b(this.parentView, ViewConfiguration.getDoubleTapTimeout());
        b16.c();
        if (b16.b()) {
            return;
        }
        if (w(this.friendUin)) {
            z(listener);
            x();
        } else {
            listener.gotoPortal(1);
        }
        y();
    }

    private final boolean s(MotionEvent event) {
        WeakReference<com.tencent.mobileqq.zplan.bubble.b> weakReference;
        com.tencent.mobileqq.zplan.bubble.b bVar;
        if ((event == null && (event = this.backgroundTouchEvent) == null) || (weakReference = this.avatarBubbleRef) == null || (bVar = weakReference.get()) == null) {
            return false;
        }
        return bVar.d((int) event.getX(), (int) event.getY());
    }

    private final boolean r(MotionEvent event) {
        if (event == null) {
            return true;
        }
        float i3 = i();
        float j3 = j();
        float g16 = g();
        float h16 = h();
        float x16 = event.getX();
        float y16 = event.getY();
        if (x16 >= g16 && x16 <= g16 + h16) {
            float f16 = this.avatarHeadStartY;
            if (y16 >= f16 && y16 <= f16 + this.avatarHeadHeight + this.avatarBodyHeight) {
                return y16 >= this.avatarBodyStartY || (x16 >= i3 && x16 <= i3 + j3);
            }
        }
        return false;
    }

    static /* synthetic */ boolean t(d dVar, MotionEvent motionEvent, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            motionEvent = null;
        }
        return dVar.s(motionEvent);
    }
}
