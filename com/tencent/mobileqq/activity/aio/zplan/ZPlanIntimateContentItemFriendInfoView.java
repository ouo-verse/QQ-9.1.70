package com.tencent.mobileqq.activity.aio.zplan;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.business.FriendIntimateRelationshipConfProcessor;
import com.tencent.mobileqq.config.business.q;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.kandian.base.view.widget.ticker.TickerView;
import com.tencent.mobileqq.mutualmark.api.IMutualMarkHelperApi;
import com.tencent.mobileqq.mutualmark.oldlogic.FriendIntimateRelationshipHelper;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.profilecard.utils.ProfileCardConst;
import com.tencent.mobileqq.profilecard.utils.ProfileUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.webview.util.w;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.light.LightConstants;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010F\u001a\u00020E\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010G\u0012\b\b\u0002\u0010I\u001a\u00020\t\u00a2\u0006\u0004\bJ\u0010KJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0002H\u0002J\b\u0010\b\u001a\u00020\u0002H\u0002J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH\u0002J\u0010\u0010\u000e\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u0002H\u0014J\b\u0010\u0010\u001a\u00020\u0005H\u0014J\u0018\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\tH\u0014J\u0010\u0010\u0015\u001a\u00020\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\fJ\b\u0010\u0016\u001a\u00020\u0002H\u0014J\b\u0010\u0017\u001a\u00020\u0002H\u0014J\b\u0010\u0018\u001a\u00020\u0002H\u0014J\b\u0010\u0019\u001a\u00020\u0002H\u0014J\b\u0010\u001a\u001a\u00020\u0002H\u0014J\u0010\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u001bH\u0014R\u001a\u0010!\u001a\u00020\f8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R\u001a\u0010&\u001a\u00020\t8\u0006X\u0086D\u00a2\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010,R\u0018\u0010/\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010,R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0018\u00105\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u0010,R\u0018\u00108\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00107R\u0018\u0010:\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b9\u0010,R\u0018\u0010<\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b;\u0010,R\"\u0010D\u001a\u00020=8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C\u00a8\u0006L"}, d2 = {"Lcom/tencent/mobileqq/activity/aio/zplan/ZPlanIntimateContentItemFriendInfoView;", "Lcom/tencent/mobileqq/activity/aio/intimate/view/IntimateContentItemBaseView;", "", "y", "v", "", "u", "D", "w", "", "friendIntimateType", "B", "", "url", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "b", "a", "Lcom/tencent/mobileqq/data/IntimateInfo;", "intimateInfo", "i", "eventId", BdhLogUtil.LogTag.Tag_Conn, "f", "e", tl.h.F, "g", "d", "Landroid/view/View;", "c", UserInfo.SEX_FEMALE, "Ljava/lang/String;", "getTAG", "()Ljava/lang/String;", "TAG", "G", "I", "getVALUE_UPDATE_ANIM_DURATION", "()I", "VALUE_UPDATE_ANIM_DURATION", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "H", "Lcom/tencent/mobileqq/kandian/base/view/widget/ticker/TickerView;", "daysTV", "Landroid/widget/TextView;", "Landroid/widget/TextView;", "daysTipTV", "J", "intimateInfoTV", "Landroid/widget/LinearLayout;", "K", "Landroid/widget/LinearLayout;", "currentLevelSourceLL", "L", "currentLevelSourceCallTv", "M", "Landroid/view/View;", "currentLevelSourceDivBg", "N", "currentLevelSourceTv", "P", "nextLevelSourceTV", "Ljava/lang/Runnable;", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "Ljava/lang/Runnable;", "getMUpdateDaysAnimBeginRunnable", "()Ljava/lang/Runnable;", "setMUpdateDaysAnimBeginRunnable", "(Ljava/lang/Runnable;)V", "mUpdateDaysAnimBeginRunnable", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class ZPlanIntimateContentItemFriendInfoView extends IntimateContentItemBaseView {

    /* renamed from: F, reason: from kotlin metadata */
    @NotNull
    private final String TAG;

    /* renamed from: G, reason: from kotlin metadata */
    private final int VALUE_UPDATE_ANIM_DURATION;

    /* renamed from: H, reason: from kotlin metadata */
    @Nullable
    private TickerView daysTV;

    /* renamed from: I, reason: from kotlin metadata */
    @Nullable
    private TextView daysTipTV;

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private TextView intimateInfoTV;

    /* renamed from: K, reason: from kotlin metadata */
    @Nullable
    private LinearLayout currentLevelSourceLL;

    /* renamed from: L, reason: from kotlin metadata */
    @Nullable
    private TextView currentLevelSourceCallTv;

    /* renamed from: M, reason: from kotlin metadata */
    @Nullable
    private View currentLevelSourceDivBg;

    /* renamed from: N, reason: from kotlin metadata */
    @Nullable
    private TextView currentLevelSourceTv;

    /* renamed from: P, reason: from kotlin metadata */
    @Nullable
    private TextView nextLevelSourceTV;

    /* renamed from: Q, reason: from kotlin metadata */
    @NotNull
    private Runnable mUpdateDaysAnimBeginRunnable;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanIntimateContentItemFriendInfoView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void A(String url) {
        if (!TextUtils.isEmpty(url) && w.a(1000L)) {
            Intent intent = new Intent(this.f179219d, (Class<?>) QQBrowserActivity.class);
            intent.putExtra("url", url);
            intent.putExtra("startOpenPageTime", System.currentTimeMillis());
            this.f179219d.startActivity(intent);
        }
    }

    private final void B(int friendIntimateType) {
        if (friendIntimateType != 1) {
            if (friendIntimateType != 2) {
                if (friendIntimateType != 3) {
                    if (friendIntimateType != 26) {
                        ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 4, 0, "", "", "", "");
                        return;
                    } else {
                        ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 5, 0, "", "", "", "");
                        return;
                    }
                }
                ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 3, 0, "", "", "", "");
                return;
            }
            ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 2, 0, "", "", "", "");
            return;
        }
        ReportController.o(null, "dc00898", "", "", "0X800B565", "0X800B565", 1, 0, "", "", "", "");
    }

    private final void D() {
        if (!this.D) {
            return;
        }
        int max = Math.max(0, this.f179223i.lastAnimAfterFriendDays);
        int max2 = Math.max(0, this.f179223i.beFriendDays);
        int i3 = 2;
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "smoothUpdateDays fromDays:" + max + " toDays:" + max2);
        }
        if (max <= 0) {
            int length = String.valueOf(max2).length();
            String str = "";
            for (int i16 = 0; i16 < length && i16 < 5; i16++) {
                str = str + "0";
            }
            TickerView tickerView = this.daysTV;
            Intrinsics.checkNotNull(tickerView);
            tickerView.setText(str, false);
        }
        TickerView tickerView2 = this.daysTV;
        Intrinsics.checkNotNull(tickerView2);
        if (max2 > max) {
            i3 = 1;
        }
        tickerView2.setPreferredScrollingDirection(i3);
        TickerView tickerView3 = this.daysTV;
        Intrinsics.checkNotNull(tickerView3);
        tickerView3.setDigitalAnimWidthSpeedIncrement(true);
        TickerView tickerView4 = this.daysTV;
        Intrinsics.checkNotNull(tickerView4);
        tickerView4.setIgnoreWidthAnim(true);
        TickerView tickerView5 = this.daysTV;
        Intrinsics.checkNotNull(tickerView5);
        tickerView5.setText(String.valueOf(max2));
        TextView textView = this.daysTipTV;
        Intrinsics.checkNotNull(textView);
        textView.setVisibility(0);
        y();
    }

    private final boolean u() {
        return true;
    }

    private final void v() {
        if (!this.D) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.i(this.TAG, 2, "checkAndStartUpdateAnim isResumed:" + this.f179221f + " currentShowType:" + this.C + " intimateInfo:" + this.f179223i);
        }
        if (this.f179221f && this.f179223i != null) {
            removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
            if (u()) {
                IntimateInfo intimateInfo = this.f179223i;
                int i3 = intimateInfo.lastAnimAfterFriendDays;
                int i16 = intimateInfo.beFriendDays;
                if (i3 != i16 && i16 > 0) {
                    postDelayed(this.mUpdateDaysAnimBeginRunnable, 300L);
                }
            }
        }
    }

    private final void w() {
        boolean contains$default;
        boolean contains$default2;
        String url;
        String url2;
        IntimateInfo intimateInfo = this.f179223i;
        if (intimateInfo == null) {
            return;
        }
        String str = this.f179220e;
        int i3 = intimateInfo.maskType;
        if (com.tencent.mobileqq.activity.aio.intimate.e.e(i3)) {
            String url3 = FriendIntimateRelationshipHelper.p();
            if (!TextUtils.isEmpty(url3)) {
                Intrinsics.checkNotNullExpressionValue(url3, "url");
                contains$default = StringsKt__StringsKt.contains$default((CharSequence) url3, (CharSequence) "frd_uin=", false, 2, (Object) null);
                if (contains$default) {
                    Intrinsics.checkNotNullExpressionValue(url3, "url");
                    contains$default2 = StringsKt__StringsKt.contains$default((CharSequence) url3, (CharSequence) "frd_type=", false, 2, (Object) null);
                    if (contains$default2) {
                        Intrinsics.checkNotNullExpressionValue(url3, "url");
                        url = StringsKt__StringsJVMKt.replace$default(url3, "frd_uin=", "frd_uin=" + str, false, 4, (Object) null);
                        Intrinsics.checkNotNullExpressionValue(url, "url");
                        url2 = StringsKt__StringsJVMKt.replace$default(url, "frd_type=", "frd_type=" + i3, false, 4, (Object) null);
                        B(i3);
                        Intrinsics.checkNotNullExpressionValue(url2, "url");
                        A(url2);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        String url4 = FriendIntimateRelationshipHelper.b(str);
        B(i3);
        Intrinsics.checkNotNullExpressionValue(url4, "url");
        A(url4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(ZPlanIntimateContentItemFriendInfoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f179221f) {
            this$0.D();
        }
    }

    private final void y() {
        if (!this.D) {
            return;
        }
        IntimateInfo intimateInfo = this.f179223i;
        if (intimateInfo != null) {
            intimateInfo.lastAnimAfterFriendDays = intimateInfo.beFriendDays;
            ThreadManagerV2.postImmediately(new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zplan.i
                @Override // java.lang.Runnable
                public final void run() {
                    ZPlanIntimateContentItemFriendInfoView.z(ZPlanIntimateContentItemFriendInfoView.this);
                }
            }, null, true);
        }
        if (QLog.isColorLevel()) {
            QLog.d("intimate_relationship", 2, "onDaysUpdated intimateInfo: " + this.f179223i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(ZPlanIntimateContentItemFriendInfoView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.f179223i != null && this$0.j() != null) {
            Manager manager = this$0.j().getManager(QQManagerFactory.INTIMATE_INFO_MANAGER);
            Intrinsics.checkNotNull(manager, "null cannot be cast to non-null type com.tencent.mobileqq.friends.intimate.IntimateInfoManager");
            ((com.tencent.mobileqq.friends.intimate.c) manager).v(this$0.f179223i);
        }
    }

    public final void C(@Nullable String eventId) {
        try {
            QRouteApi api = QRoute.api(IMutualMarkHelperApi.class);
            Intrinsics.checkNotNullExpressionValue(api, "api(IMutualMarkHelperApi::class.java)");
            IMutualMarkHelperApi iMutualMarkHelperApi = (IMutualMarkHelperApi) api;
            iMutualMarkHelperApi.reportItemEvent(eventId, "pg_aio_swipleft", "em_zplan_friend_value", iMutualMarkHelperApi.getPgSwipLeftData(), null);
        } catch (Exception e16) {
            QLog.e(this.TAG, 1, "reportZPlanFriendInfo error:" + e16);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected boolean a() {
        return true;
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void b() {
        View inflate = LayoutInflater.from(this.f179219d).inflate(R.layout.f169209i91, (ViewGroup) this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(context)\n          \u2026_friend_info, this, true)");
        this.daysTV = (TickerView) inflate.findViewById(R.id.dnx);
        this.daysTipTV = (TextView) inflate.findViewById(R.id.lm7);
        this.intimateInfoTV = (TextView) inflate.findViewById(R.id.dnv);
        this.currentLevelSourceLL = (LinearLayout) inflate.findViewById(R.id.xev);
        this.currentLevelSourceCallTv = (TextView) inflate.findViewById(R.id.ucf);
        this.currentLevelSourceDivBg = inflate.findViewById(R.id.xeu);
        this.currentLevelSourceTv = (TextView) inflate.findViewById(R.id.ucg);
        this.nextLevelSourceTV = (TextView) inflate.findViewById(R.id.zqp);
        TickerView tickerView = this.daysTV;
        if (tickerView != null) {
            tickerView.setCharacterLists("9876543210");
        }
        TickerView tickerView2 = this.daysTV;
        if (tickerView2 != null) {
            tickerView2.setAnimationDuration(this.VALUE_UPDATE_ANIM_DURATION + LightConstants.ErrorCode.SDK_VERSION_NOT_SUPPORT);
        }
        LinearLayout linearLayout = this.currentLevelSourceLL;
        if (linearLayout != null) {
            linearLayout.setOnClickListener(this);
        }
        TextView textView = this.nextLevelSourceTV;
        if (textView != null) {
            textView.setOnClickListener(this);
        }
        LinearLayout linearLayout2 = this.currentLevelSourceLL;
        if (linearLayout2 != null) {
            linearLayout2.setOnTouchListener(this);
        }
        TextView textView2 = this.nextLevelSourceTV;
        if (textView2 != null) {
            textView2.setOnTouchListener(this);
        }
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void c(@NotNull View v3) {
        Intrinsics.checkNotNullParameter(v3, "v");
        int id5 = v3.getId();
        boolean z16 = false;
        if (id5 == R.id.imu) {
            AllInOne allInOne = new AllInOne(k(), 0);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 2);
            allInOne.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 23);
            ProfileUtils.openProfileCard(this.f179219d, allInOne);
            return;
        }
        if (id5 == R.id.cnr) {
            AllInOne allInOne2 = new AllInOne(this.f179220e, 1);
            allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SOURCE_ID, 2);
            allInOne2.extras.putInt(ProfileCardConst.ENTER_PAGE_SUB_SOURCE_ID, 23);
            ProfileUtils.openProfileCard(this.f179219d, allInOne2);
            return;
        }
        if (id5 == R.id.xev || id5 == R.id.zqp) {
            z16 = true;
        }
        if (z16) {
            w();
            C("dt_clck");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void d() {
        removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void e() {
        removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
        C("dt_imp_end");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    public void f() {
        v();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void g() {
        removeCallbacks(this.mUpdateDaysAnimBeginRunnable);
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void h() {
        v();
    }

    @Override // com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemBaseView
    protected void i(@NotNull IntimateInfo intimateInfo, int friendIntimateType) {
        String str;
        Intrinsics.checkNotNullParameter(intimateInfo, "intimateInfo");
        int i3 = intimateInfo.beFriendDays;
        if (u() && intimateInfo.beFriendDays > 0) {
            i3 = Math.max(0, intimateInfo.lastAnimAfterFriendDays);
        }
        if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "updateIntimateInfo beFriendDays: " + i3);
        }
        if (i3 >= -1) {
            if (i3 == 0) {
                str = this.f179219d.getResources().getString(R.string.bya);
                Intrinsics.checkNotNullExpressionValue(str, "context.resources.getStr\u2026relation_be_friend_today)");
                TextView textView = this.daysTipTV;
                Intrinsics.checkNotNull(textView);
                textView.setVisibility(8);
            } else {
                String valueOf = String.valueOf(i3);
                if (i3 == -1) {
                    str = "999+";
                } else {
                    str = valueOf;
                }
                TextView textView2 = this.daysTipTV;
                Intrinsics.checkNotNull(textView2);
                textView2.setVisibility(0);
            }
            TickerView tickerView = this.daysTV;
            Intrinsics.checkNotNull(tickerView);
            tickerView.setText(str, false);
            if (friendIntimateType != 1) {
                if (friendIntimateType != 2) {
                    if (friendIntimateType != 3) {
                        if (friendIntimateType != 26) {
                            TextView textView3 = this.intimateInfoTV;
                            if (textView3 != null) {
                                textView3.setText(R.string.by9);
                            }
                        } else {
                            TextView textView4 = this.intimateInfoTV;
                            if (textView4 != null) {
                                textView4.setText(R.string.f160961wf);
                            }
                        }
                    } else {
                        TextView textView5 = this.intimateInfoTV;
                        if (textView5 != null) {
                            textView5.setText(R.string.byc);
                        }
                    }
                } else {
                    TextView textView6 = this.intimateInfoTV;
                    if (textView6 != null) {
                        textView6.setText(R.string.byb);
                    }
                }
            } else {
                TextView textView7 = this.intimateInfoTV;
                if (textView7 != null) {
                    textView7.setText(R.string.byd);
                }
            }
            LinearLayout linearLayout = this.currentLevelSourceLL;
            Intrinsics.checkNotNull(linearLayout);
            linearLayout.setBackgroundResource(R.drawable.m7v);
            View view = this.currentLevelSourceDivBg;
            Intrinsics.checkNotNull(view);
            view.setBackgroundColor(getResources().getColor(R.color.d18));
            TextView textView8 = this.nextLevelSourceTV;
            Intrinsics.checkNotNull(textView8);
            textView8.setBackgroundResource(R.drawable.oxb);
            IntimateInfo.IntimateScoreCardInfo intimateScoreCardInfo = intimateInfo.scoreCardInfo;
            if (intimateScoreCardInfo != null && !TextUtils.isEmpty(intimateScoreCardInfo.typeDescribe)) {
                TextView textView9 = this.currentLevelSourceCallTv;
                Intrinsics.checkNotNull(textView9);
                textView9.setText(intimateInfo.scoreCardInfo.typeDescribe);
                TextView textView10 = this.currentLevelSourceTv;
                Intrinsics.checkNotNull(textView10);
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String string = this.f179219d.getString(R.string.f161061wp);
                Intrinsics.checkNotNullExpressionValue(string, "context.getString(R.stri\u2026tion_current_source_tips)");
                String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(intimateInfo.scoreCardInfo.score)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
                textView10.setText(format);
                LinearLayout linearLayout2 = this.currentLevelSourceLL;
                Intrinsics.checkNotNull(linearLayout2);
                linearLayout2.setVisibility(0);
            } else {
                LinearLayout linearLayout3 = this.currentLevelSourceLL;
                Intrinsics.checkNotNull(linearLayout3);
                linearLayout3.setVisibility(8);
            }
            IntimateInfo.IntimateScoreCardInfo intimateScoreCardInfo2 = intimateInfo.scoreCardInfo;
            if (intimateScoreCardInfo2 != null && !TextUtils.isEmpty(intimateScoreCardInfo2.levelDescribe)) {
                TextView textView11 = this.nextLevelSourceTV;
                Intrinsics.checkNotNull(textView11);
                textView11.setText(intimateInfo.scoreCardInfo.levelDescribe);
                TextView textView12 = this.nextLevelSourceTV;
                Intrinsics.checkNotNull(textView12);
                textView12.setVisibility(0);
            } else {
                TextView textView13 = this.nextLevelSourceTV;
                Intrinsics.checkNotNull(textView13);
                textView13.setVisibility(8);
            }
            TickerView tickerView2 = this.daysTV;
            Intrinsics.checkNotNull(tickerView2);
            tickerView2.setTextColor(this.f179219d.getResources().getColor(R.color.qui_common_text_primary));
            TextView textView14 = this.daysTipTV;
            Intrinsics.checkNotNull(textView14);
            textView14.setTextColor(this.f179219d.getResources().getColor(R.color.qui_common_text_primary));
            TextView textView15 = this.intimateInfoTV;
            Intrinsics.checkNotNull(textView15);
            textView15.setTextColor(this.f179219d.getResources().getColor(R.color.qui_common_text_primary));
            TextView textView16 = this.nextLevelSourceTV;
            Intrinsics.checkNotNull(textView16);
            textView16.setBackgroundResource(R.drawable.oxb);
        } else {
            TickerView tickerView3 = this.daysTV;
            Intrinsics.checkNotNull(tickerView3);
            tickerView3.setText("");
            TextView textView17 = this.daysTipTV;
            Intrinsics.checkNotNull(textView17);
            textView17.setVisibility(8);
            TextView textView18 = this.intimateInfoTV;
            Intrinsics.checkNotNull(textView18);
            textView18.setText("");
            TextView textView19 = this.currentLevelSourceTv;
            Intrinsics.checkNotNull(textView19);
            textView19.setVisibility(4);
            TextView textView20 = this.nextLevelSourceTV;
            Intrinsics.checkNotNull(textView20);
            textView20.setVisibility(4);
        }
        v();
        q a16 = FriendIntimateRelationshipConfProcessor.a();
        Intrinsics.checkNotNullExpressionValue(a16, "loadConfig()");
        if (intimateInfo.currentScore >= a16.f202722r0) {
            LinearLayout linearLayout4 = this.currentLevelSourceLL;
            Intrinsics.checkNotNull(linearLayout4);
            linearLayout4.setVisibility(0);
            TextView textView21 = this.nextLevelSourceTV;
            Intrinsics.checkNotNull(textView21);
            textView21.setVisibility(0);
        } else {
            LinearLayout linearLayout5 = this.currentLevelSourceLL;
            Intrinsics.checkNotNull(linearLayout5);
            linearLayout5.setVisibility(8);
            TextView textView22 = this.nextLevelSourceTV;
            Intrinsics.checkNotNull(textView22);
            textView22.setVisibility(8);
        }
        C("dt_imp");
    }

    public final void setMUpdateDaysAnimBeginRunnable(@NotNull Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "<set-?>");
        this.mUpdateDaysAnimBeginRunnable = runnable;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanIntimateContentItemFriendInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ZPlanIntimateContentItemFriendInfoView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ZPlanIntimateContentItemFriendInfoView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TAG = "ZPlanIntimateContentItemFriendInfoView";
        this.VALUE_UPDATE_ANIM_DURATION = 2500;
        this.mUpdateDaysAnimBeginRunnable = new Runnable() { // from class: com.tencent.mobileqq.activity.aio.zplan.h
            @Override // java.lang.Runnable
            public final void run() {
                ZPlanIntimateContentItemFriendInfoView.x(ZPlanIntimateContentItemFriendInfoView.this);
            }
        };
    }
}
