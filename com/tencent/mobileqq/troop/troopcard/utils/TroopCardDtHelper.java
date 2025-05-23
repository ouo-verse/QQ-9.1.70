package com.tencent.mobileqq.troop.troopcard.utils;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.PageParams;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.EndExposurePolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import com.tencent.qqlive.module.videoreport.page.VideoReportPageInfo;
import com.tencent.widget.ActionMenuItem;
import com.tencent.widget.ActionSheet;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsJVMKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u00c0\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\bI\u0010JJ\u001e\u0010\u0006\u001a\u00020\u00052\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J\u001e\u0010\u0007\u001a\u00020\u00052\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J\u001e\u0010\b\u001a\u00020\u00052\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002J\u0010\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\tJ8\u0010\u0015\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\t2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J&\u0010\u0017\u001a\u00020\u00162\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\f\u0010\u0018\u001a\u00020\u0003*\u00020\u000fH\u0002J,\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J\u001a\u0010\u001f\u001a\u00020\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0003H\u0007J\u001a\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0003H\u0007J\u001a\u0010\"\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0003H\u0007J\u001a\u0010$\u001a\u00020\u00052\b\u0010#\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0003H\u0007J,\u0010)\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u00032\b\u0010&\u001a\u0004\u0018\u00010\u00032\u0006\u0010(\u001a\u00020'H\u0007J\u001a\u0010+\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001e\u001a\u00020\u0003H\u0007J\u0012\u0010-\u001a\u00020\u00052\b\u0010,\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u0010/\u001a\u00020\u00052\b\u0010.\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u00101\u001a\u00020\u00052\b\u00100\u001a\u0004\u0018\u00010\tH\u0007J\u0012\u00103\u001a\u00020\u00052\b\u00102\u001a\u0004\u0018\u00010\tH\u0007J\u001a\u00106\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\t2\u0006\u00105\u001a\u00020'H\u0007J2\u00109\u001a\u00020\u00052\b\u00107\u001a\u0004\u0018\u00010\t2\u0006\u00108\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0007J\"\u0010=\u001a\u00020\u00052\b\u0010:\u001a\u0004\u0018\u00010\t2\u0006\u0010;\u001a\u00020\u00032\u0006\u0010<\u001a\u00020'H\u0007J\u0012\u0010?\u001a\u00020\u00052\b\u0010>\u001a\u0004\u0018\u00010\tH\u0007J*\u0010C\u001a\u00020\u0005*\u0004\u0018\u00010\t2\u0006\u0010@\u001a\u00020\u00032\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050AH\u0002J,\u0010E\u001a\u00020\u0005*\u00020\t2\u0006\u0010D\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0002H\u0002J,\u0010H\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010Fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001`G2\u0006\u0010D\u001a\u00020\u0003H\u0002\u00a8\u0006K"}, d2 = {"Lcom/tencent/mobileqq/troop/troopcard/utils/TroopCardDtHelper;", "", "", "", "params", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, QCircleScheme.AttrQQPublish.INPUT_TAB_ZSHOW, BdhLogUtil.LogTag.Tag_Conn, "Landroid/view/View;", "essenceGuideLayout", "l", "Landroidx/fragment/app/FragmentActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, MosaicConstants$JsProperty.PROP_ROOT_VIEW, "Lcom/tencent/mobileqq/troop/data/TroopInfoData;", "troopInfoData", "Landroid/os/Bundle;", "extra", "", "isNewPage", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Lcom/tencent/qqlive/module/videoreport/PageParams;", "g", h.F, "Lcom/tencent/widget/ActionSheet;", "actionSheet", "bundle", "b", "reportView", "groupUin", ReportConstant.COSTREPORT_PREFIX, "shareView", "u", "v", "sendMsgView", "t", "joinBtn", "secureBizId", "", "statOption", "i", "editProfileView", "j", "qrCodeView", "r", "troopNameTv", "y", "troopAvatarIv", "w", "troopCoverIv", HippyTKDListViewAdapter.X, "gameView", "btnType", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "view", "eid", "o", "essenceItemView", "essenceId", "essenceType", "k", "memberDistributionView", DomainData.DOMAIN_NAME, "method", "Lkotlin/Function1;", "callback", "e", "elementId", "c", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "f", "<init>", "()V", "qqtroop-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes19.dex */
public final class TroopCardDtHelper {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final TroopCardDtHelper f299952a;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(57455);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f299952a = new TroopCardDtHelper();
        }
    }

    TroopCardDtHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void B(TroopCardDtHelper troopCardDtHelper, Map map, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            map = null;
        }
        troopCardDtHelper.A(map);
    }

    @JvmStatic
    public static final void b(@NotNull ActionSheet actionSheet, @Nullable Bundle bundle, @Nullable TroopInfoData troopInfoData, boolean isNewPage) {
        String str;
        Intrinsics.checkNotNullParameter(actionSheet, "actionSheet");
        LinearLayout linearLayout = actionSheet.mContentContainer;
        if (linearLayout == null || troopInfoData == null || (str = troopInfoData.troopUin) == null) {
            return;
        }
        VideoReport.setPageId(linearLayout, "pg_group_apply_profile");
        VideoReport.setPageParams(linearLayout, g(troopInfoData, bundle, isNewPage));
        int childCount = linearLayout.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = linearLayout.getChildAt(i3);
            ActionMenuItem actionMenuItem = actionSheet.getActionMenuItem(i3);
            if (actionMenuItem != null && childAt != null) {
                int i16 = actionMenuItem.action;
                if (i16 != 9) {
                    if (i16 == 10) {
                        s(childAt, str);
                    }
                } else {
                    u(childAt, str);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(View view, String str, Map<String, ? extends Object> map) {
        VideoReport.setElementId(view, str);
        VideoReport.setElementClickPolicy(view, ClickPolicy.REPORT_ALL);
        VideoReport.setElementExposePolicy(view, ExposurePolicy.REPORT_ALL);
        VideoReport.setElementEndExposePolicy(view, EndExposurePolicy.REPORT_ALL);
        if (map != null) {
            VideoReport.setElementParams(view, map);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void d(TroopCardDtHelper troopCardDtHelper, View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            map = null;
        }
        troopCardDtHelper.c(view, str, map);
    }

    private final void e(View view, String str, Function1<? super View, Unit> function1) {
        if (view == null) {
            QLog.i("TroopCardDtHelper", 1, str + " view is null");
            return;
        }
        function1.invoke(view);
    }

    private final HashMap<String, Object> f(String elementId) {
        Map<String, Object> map;
        HashMap<String, Object> hashMap = new HashMap<>();
        VideoReportPageInfo pageInfo = VideoReport.getPageInfo();
        if (pageInfo != null) {
            map = pageInfo.pageParams;
        } else {
            map = null;
        }
        if (map == null) {
            map = new LinkedHashMap<>();
        }
        hashMap.putAll(map);
        hashMap.put("dt_pgid", "pg_group_apply_profile");
        hashMap.put("pgid", "pg_group_apply_profile");
        hashMap.put("dt_eid", elementId);
        hashMap.put("eid", elementId);
        hashMap.put("cur_pg", map);
        return hashMap;
    }

    @JvmStatic
    @NotNull
    public static final PageParams g(@Nullable TroopInfoData troopInfoData, @Nullable Bundle extra, boolean isNewPage) {
        String str;
        String str2;
        Object obj;
        int i3;
        String str3;
        String str4;
        String str5;
        Map mapOf;
        Pair[] pairArr = new Pair[8];
        String str6 = null;
        if (troopInfoData != null) {
            str = troopInfoData.troopUin;
        } else {
            str = null;
        }
        String str7 = "";
        if (str == null) {
            str = "";
        }
        pairArr[0] = TuplesKt.to("group_id", str);
        if (troopInfoData != null) {
            str2 = troopInfoData.troopName;
        } else {
            str2 = null;
        }
        if (str2 == null) {
            str2 = "";
        }
        pairArr[1] = TuplesKt.to("group_name", str2);
        if (troopInfoData == null || (obj = f299952a.h(troopInfoData)) == null) {
            obj = 0;
        }
        pairArr[2] = TuplesKt.to("group_uin_type", obj);
        if (troopInfoData != null) {
            i3 = troopInfoData.getStatOption();
        } else {
            i3 = -1;
        }
        pairArr[3] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, String.valueOf(i3));
        if (extra != null) {
            str3 = extra.getString("trans_info", "");
        } else {
            str3 = null;
        }
        if (str3 == null) {
            str3 = "";
        }
        pairArr[4] = TuplesKt.to("trans_info", str3);
        if (extra != null) {
            str4 = extra.getString("sec_biz_id", "");
        } else {
            str4 = null;
        }
        if (str4 == null) {
            str4 = "";
        }
        pairArr[5] = TuplesKt.to(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, str4);
        if (isNewPage) {
            str5 = "1";
        } else {
            str5 = "0";
        }
        pairArr[6] = TuplesKt.to("now_page", str5);
        if (troopInfoData != null) {
            str6 = troopInfoData.troopowneruin;
        }
        if (str6 != null) {
            str7 = str6;
        }
        pairArr[7] = TuplesKt.to("group_owner_uin", str7);
        mapOf = MapsKt__MapsKt.mapOf(pairArr);
        return new PageParams((Map<String, ?>) mapOf);
    }

    private final String h(TroopInfoData troopInfoData) {
        if (troopInfoData.bOwner) {
            return "1";
        }
        if (troopInfoData.bAdmin) {
            return "2";
        }
        if (troopInfoData.isMember) {
            return "3";
        }
        return "4";
    }

    @JvmStatic
    public static final void i(@Nullable final View joinBtn, @NotNull final String groupUin, @Nullable final String secureBizId, final int statOption) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        f299952a.e(joinBtn, "initApplyJoinGroupButtonDtReport", new Function1<View, Unit>(groupUin, secureBizId, statOption, joinBtn) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initApplyJoinGroupButtonDtReport$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupUin;
            final /* synthetic */ View $joinBtn;
            final /* synthetic */ String $secureBizId;
            final /* synthetic */ int $statOption;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupUin = groupUin;
                this.$secureBizId = secureBizId;
                this.$statOption = statOption;
                this.$joinBtn = joinBtn;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, groupUin, secureBizId, Integer.valueOf(statOption), joinBtn);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                Pair[] pairArr = new Pair[3];
                pairArr[0] = TuplesKt.to("group_id", this.$groupUin);
                String str = this.$secureBizId;
                if (str == null) {
                    str = "";
                }
                pairArr[1] = TuplesKt.to(QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, str);
                pairArr[2] = TuplesKt.to(WinkDaTongReportConstant.ElementParamKey.XSJ_USER_FROM, String.valueOf(this.$statOption));
                mapOf = MapsKt__MapsKt.mapOf(pairArr);
                com.tencent.mobileqq.troop.dtreport.a.g(this.$joinBtn, "em_group_apply_btn", mapOf, ClickPolicy.REPORT_ALL);
            }
        });
    }

    @JvmStatic
    public static final void j(@Nullable View editProfileView, @NotNull final String groupUin) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        f299952a.e(editProfileView, "initEditProfileButtonData", new Function1<View, Unit>(groupUin) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initEditProfileButtonData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupUin = groupUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupUin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_id", this.$groupUin));
                TroopCardDtHelper.f299952a.c(it, "em_group_edit_profile_btn", mapOf);
            }
        });
    }

    @JvmStatic
    public static final void k(@Nullable View essenceItemView, @NotNull final String essenceId, final int essenceType) {
        Intrinsics.checkNotNullParameter(essenceId, "essenceId");
        if (essenceItemView != null) {
            f299952a.e(essenceItemView, "initEssenceData", new Function1<View, Unit>(essenceType, essenceId) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initEssenceData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $essenceId;
                final /* synthetic */ int $essenceType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$essenceType = essenceType;
                    this.$essenceId = essenceId;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, essenceType, (Object) essenceId);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Map mapOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("quintessence_type", Integer.valueOf(this.$essenceType)), TuplesKt.to("quintessence_id", this.$essenceId));
                    TroopCardDtHelper.f299952a.c(it, "em_group_quintessence", mapOf);
                    VideoReport.setElementReuseIdentifier(it, this.$essenceId);
                }
            });
        }
    }

    @JvmStatic
    public static final void m(@Nullable View gameView, final int btnType) {
        if (gameView != null) {
            f299952a.e(gameView, "initGameAreaData", new Function1<View, Unit>(btnType) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initGameAreaData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int $btnType;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$btnType = btnType;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, btnType);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    Map mapOf;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                        return;
                    }
                    Intrinsics.checkNotNullParameter(it, "it");
                    mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("btn_type", Integer.valueOf(this.$btnType)));
                    TroopCardDtHelper.f299952a.c(it, "em_group_battle_record", mapOf);
                }
            });
        }
    }

    @JvmStatic
    public static final void n(@Nullable View memberDistributionView) {
        if (memberDistributionView != null) {
            f299952a.e(memberDistributionView, "initMemberDistributionData", TroopCardDtHelper$initMemberDistributionData$1.INSTANCE);
        }
    }

    @JvmStatic
    public static final void o(@Nullable View view, @NotNull final String eid, @Nullable final Map<String, ? extends Object> params) {
        Intrinsics.checkNotNullParameter(eid, "eid");
        if (view != null) {
            f299952a.e(view, "initMetaDreamData", new Function1<View, Unit>(eid, params) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initMetaDreamData$1
                static IPatchRedirector $redirector_;
                final /* synthetic */ String $eid;
                final /* synthetic */ Map<String, Object> $params;

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                    this.$eid = eid;
                    this.$params = params;
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) eid, (Object) params);
                    }
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view2) {
                    invoke2(view2);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull View it) {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    } else {
                        Intrinsics.checkNotNullParameter(it, "it");
                        TroopCardDtHelper.f299952a.c(it, this.$eid, this.$params);
                    }
                }
            });
        }
    }

    public static /* synthetic */ void p(View view, String str, Map map, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            map = null;
        }
        o(view, str, map);
    }

    @JvmStatic
    public static final void q(@Nullable final FragmentActivity activity, @Nullable View rootView, @Nullable final TroopInfoData troopInfoData, @Nullable final Bundle extra, final boolean isNewPage) {
        f299952a.e(rootView, "initPageData", new Function1<View, Unit>(troopInfoData, extra, isNewPage) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initPageData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ Bundle $extra;
            final /* synthetic */ boolean $isNewPage;
            final /* synthetic */ TroopInfoData $troopInfoData;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$troopInfoData = troopInfoData;
                this.$extra = extra;
                this.$isNewPage = isNewPage;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, this, FragmentActivity.this, troopInfoData, extra, Boolean.valueOf(isNewPage));
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                VideoReport.addToDetectionWhitelist(FragmentActivity.this);
                VideoReport.setPageId(it, "pg_group_apply_profile");
                VideoReport.setPageParams(it, TroopCardDtHelper.g(this.$troopInfoData, this.$extra, this.$isNewPage));
            }
        });
    }

    @JvmStatic
    public static final void r(@Nullable View qrCodeView) {
        if (qrCodeView != null) {
            f299952a.e(qrCodeView, "initQrCodeButtonData", TroopCardDtHelper$initQrCodeButtonData$1.INSTANCE);
        }
    }

    @JvmStatic
    public static final void s(@Nullable View reportView, @NotNull final String groupUin) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        f299952a.e(reportView, "initReportButtonInActionSheet", new Function1<View, Unit>(groupUin) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initReportButtonInActionSheet$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupUin = groupUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupUin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_id", this.$groupUin));
                TroopCardDtHelper.f299952a.c(it, "em_group_report_btn", mapOf);
            }
        });
    }

    @JvmStatic
    public static final void t(@Nullable View sendMsgView, @NotNull final String groupUin) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        f299952a.e(sendMsgView, "initSendMsgButtonData", new Function1<View, Unit>(groupUin) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initSendMsgButtonData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupUin = groupUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupUin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("group_id", this.$groupUin));
                TroopCardDtHelper.f299952a.c(it, "em_group_sendmsg_btn", mapOf);
            }
        });
    }

    @JvmStatic
    public static final void u(@Nullable View shareView, @NotNull final String groupUin) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        f299952a.e(shareView, "initShareButtonInActionSheet", new Function1<View, Unit>(groupUin) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initShareButtonInActionSheet$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupUin = groupUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupUin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                Map mapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("group_id", this.$groupUin), TuplesKt.to("group_btn_location", "0"));
                TroopCardDtHelper.f299952a.c(it, "em_group_share_entrance", mapOf);
            }
        });
    }

    @JvmStatic
    public static final void v(@Nullable View shareView, @NotNull final String groupUin) {
        Intrinsics.checkNotNullParameter(groupUin, "groupUin");
        f299952a.e(shareView, "initShareButtonInBottomData", new Function1<View, Unit>(groupUin) { // from class: com.tencent.mobileqq.troop.troopcard.utils.TroopCardDtHelper$initShareButtonInBottomData$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ String $groupUin;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.$groupUin = groupUin;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) groupUin);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull View it) {
                HashMap hashMapOf;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this, (Object) it);
                    return;
                }
                Intrinsics.checkNotNullParameter(it, "it");
                hashMapOf = MapsKt__MapsKt.hashMapOf(TuplesKt.to("group_id", this.$groupUin), TuplesKt.to("group_btn_location", "1"));
                TroopCardDtHelper.f299952a.c(it, "em_group_share_entrance", hashMapOf);
            }
        });
    }

    @JvmStatic
    public static final void w(@Nullable View troopAvatarIv) {
        if (troopAvatarIv != null) {
            f299952a.e(troopAvatarIv, "initTroopAvatarData", TroopCardDtHelper$initTroopAvatarData$1.INSTANCE);
        }
    }

    @JvmStatic
    public static final void x(@Nullable View troopCoverIv) {
        if (troopCoverIv != null) {
            f299952a.e(troopCoverIv, "initTroopCoverData", TroopCardDtHelper$initTroopCoverData$1.INSTANCE);
        }
    }

    @JvmStatic
    public static final void y(@Nullable View troopNameTv) {
        if (troopNameTv != null) {
            f299952a.e(troopNameTv, "initTroopNameData", TroopCardDtHelper$initTroopNameData$1.INSTANCE);
        }
    }

    public final void A(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) params);
            return;
        }
        HashMap<String, Object> f16 = f("em_group_medal_more");
        if (params == null) {
            params = new LinkedHashMap<>();
        }
        f16.putAll(params);
        VideoReport.reportEvent("dt_clck", f16);
    }

    public final void C(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
            return;
        }
        HashMap<String, Object> f16 = f("em_group_essence_tab");
        if (params == null) {
            params = new LinkedHashMap<>();
        }
        f16.putAll(params);
        VideoReport.reportEvent("dt_clck", f16);
    }

    public final void l(@Nullable View essenceGuideLayout) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) essenceGuideLayout);
        } else if (essenceGuideLayout != null) {
            e(essenceGuideLayout, "initEssenceGuideData", TroopCardDtHelper$initEssenceGuideData$1.INSTANCE);
        }
    }

    public final void z(@Nullable Map<String, ? extends Object> params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
            return;
        }
        HashMap<String, Object> f16 = f("em_group_medal");
        if (params == null) {
            params = new LinkedHashMap<>();
        }
        f16.putAll(params);
        VideoReport.reportEvent("dt_clck", f16);
    }
}
